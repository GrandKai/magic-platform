# magic-platform
0. 创建数据库 auth, 最新 sql 脚本文件在 file/auth.sql中
1. 在 parent 子工程下执行 mvn install
2. 分别安装 util (特别注意，该子工程需要手动 build，要不 class 打不到 jar 中--暂时不知道为啥)
3. 安装 entity, core, dubbo, support, backend, api,
4. 启动 api 工程即可

    1）可以直接执行 ApiApplication
    2) 也可以已经典 tomcat 方式执行