* ZooKeeper知识点：
  * 1 ZooKeeper的ZAB协议（原子消息广播协议）
    *  CountDownLatch：CountDownLatch类位于java.util.concurrent包下，利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利  用CountDownLatch来实现这种功能了。
    * 分布式锁:因为在同一台机器可以用java 自带的锁进行控制并发，但是集群服务控制锁，redis，ZooKeeper