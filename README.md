# magic-platform
预设环境：假设你已经安装了 zookeeper(使用了默认配置)
#### （一）启动 dubbo-provider 工程
1. 创建数据库 auth, 最新 sql 脚本文件在 file/auth.sql中
2. 在 parent 子工程下执行 mvn install
3. 分别安装构建 entity, core, util, support, framework, dubbo, dubbo-provider
4. 启动 dubbo-provider 工程


#### （二）启动 magic-platform-api 工程
使用的端口是 9088，如果修改了启动端口，注意修改 vue-admin 前段端口
#### （三）启动 vue-admin 工程
根目录下运行 npm run dev

