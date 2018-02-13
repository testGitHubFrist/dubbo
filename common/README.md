备注：提供者和消费者都需要引用的共同代码块（如entity和service接口）

备注：
 1、工程创建参考  http://blog.csdn.net/lanlw123/article/details/53464143
 2、项目结构：使用maven多模块的结构
   1)dubbo 父项目：打包时只需要右键 run-maven install
   2)common 子项目存放公共的实体等
   3)Provider 子项目 服务提供者，应用于访问数据库为上层服务提供基础数据;和一些简单的逻辑服务
   4)Consumer 子项目  服务的消费者，普通的mvc结构，主要是界面与controller