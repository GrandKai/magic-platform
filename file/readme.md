用enterprise architect 生成sql文件时，需要注意字符集是gbk，在使用sql文件生成表的时候需要指定字符集 --default-character-set=gbk，否则会导致注释乱码


TODOLIST:
1. 组织机构管理（暂时可以不弄，还没想好怎么弄）
2. 用户信息管理（用户可以分配角色）
3. 角色管理（角色可以批量分配用户）
4. 权限信息管理（权限绑定菜单，绑定操作）
5. 数据字典管理（数据类型，数据项目-我写过，我来弄）


编写说明：
1. 后台 Java 范例 Controller

```
@Api(tags = "角色相关操作")
@RestController
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /***
     * 获取所有【角色】信息（分页）
     * @param requestModel
     * @return
     */
    @PostMapping("")
    public ResponseModel page(@RequestBody RequestModel<RoleQueryModel> requestModel) {
        PageInfo pageInfo = roleService.getEntityPage(requestModel);
        return new ResponseModel<>(pageInfo);
    }


    @PostMapping("add")
    @OpsLog(value = "新增角色", type = OpsLogType.ADD)
    public ResponseModel add(@RequestBody RequestModel<Role> requestModel) {
        Role param = requestModel.getContent();
        Objects.requireNonNull(param, "请求对象不能为空");

        Objects.requireNonNull(param.getPlatId(), "系统id不能为空");

        roleService.addEntity(param);
        return new ResponseModel("新增角色成功！");
    }

    @PostMapping("update")
    @OpsLog(value = "修改角色", type = OpsLogType.UPDATE)
    public ResponseModel update(@RequestBody RequestModel<Role> requestModel) {
        Role param = requestModel.getContent();

        Objects.requireNonNull(param, "请求对象不能为空");
        Objects.requireNonNull(param.getId(), "角色id不能为空");
//        Objects.requireNonNull(param.getPlatId(), "系统id不能为空");

        roleService.updateEntity(param);
        return new ResponseModel("修改角色成功！");
    }

    @PostMapping("delete")
    @OpsLog(value = "删除角色", type = OpsLogType.DELETE)
    public ResponseModel delete(@RequestBody RequestModel<String> requestModel) {
        String id = requestModel.getContent();
        Objects.requireNonNull(id, "角色id不能为空");
        roleService.deleteEntity(id);

        return new ResponseModel();
    }
}

```

说明：增删改分别对应的 PostMapping 分别是 add, delete, update

service 对应的方法名称分别是 addEntity, deleteEntity, updateEntity

分页查询对应的  PostMapping 是空字符串，service 对应的方法是 getEntityPage，注意：在
getEntityPage 方法中 使用统一 selectEntityList 命名方法，以便查询所有实体和分页数据公用一个方法

推荐：获取一个实体使用 get 前缀，列表使用 select前缀