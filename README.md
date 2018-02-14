*备注：
 *前提准备：zookeeper安装：http://gqsunrise.iteye.com/blog/2367143
        dubbo-admin ：dubbo管理系统安装：http://blog.csdn.net/u013142781/article/details/50396621
 *1、工程创建参考  http://blog.csdn.net/lanlw123/article/details/53464143
 *2、项目结构：使用maven多模块的结构
   *1)dubbo 父项目：打包时只需要右键 run-maven install
   *2)common 子项目存放公共的实体等
   *3)Provider 子项目 服务提供者，应用于访问数据库为上层服务提供基础数据;和一些简单的逻辑服务
   *4)Consumer 子项目  服务的消费者，普通的mvc结构，主要是界面与controller
   
   
   
*常识：最近发现电脑总是蓝屏崩溃，经查询是由于Windows系统没有激活;
*遇到的一些问题：
   *1)再运行Consumer 工程时，启动过程中总是提示 Caused by: java.lang.ClassNotFoundException:找不到Provider下的service，但是在Consumer工程的
   pom文件已经引入Provider工程，经过仔细排查，应该是eclipse没有部署Provider工程
   *  解决： 右键点击项目，选择Properties，选择Deployment Assembly，在右边点击Add，在弹出的窗口中选择Archives from Workspace --next --add   加入Provider与common
           