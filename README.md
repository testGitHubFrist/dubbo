备注：
 前提准备：zookeeper安装：http://gqsunrise.iteye.com/blog/2367143
        dubbo-admin ：dubbo管理系统安装：http://blog.csdn.net/u013142781/article/details/50396621
 1、工程创建参考  http://blog.csdn.net/lanlw123/article/details/53464143
 2、项目结构：使用maven多模块的结构
   1)dubbo 父项目：打包时只需要右键 run-maven install
   2)common 子项目存放公共的实体等
   3)Provider 子项目 服务提供者，应用于访问数据库为上层服务提供基础数据;和一些简单的逻辑服务
   4)Consumer 子项目  服务的消费者，普通的mvc结构，主要是界面与controller
   
   
   
常识：最近发现电脑总是蓝屏崩溃，经查询是由于Windows系统没有激活