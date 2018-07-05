package com.dubbo.common.serializable;

/**
 * @Auther: zhangshanchuang
 * @Date: 18/7/5 09:51
 * @Description: java Serializbale 原理讨论
 * Java序列化是指把Java对象保存为二进制字节码的过程，Java反序列化是指把二进制码重新转换成Java对象的过程。
 * 那么为什么需要序列化呢？
 * 第一种情况是：一般情况下Java对象的声明周期都比Java虚拟机的要短，实际应用中我们希望在JVM停止运行之后能够持久化指定的对象，这时候就需要把对象进行序列化之后保存。
 * 第二种情况是：需要把Java对象通过网络进行传输的时候。因为数据只能够以二进制的形式在网络中进行传输，因此当把对象通过网络发送出去之前需要先序列化成二进制数据，在接收端读到二进制数据之后反序列化成Java对象。
 */
public class JavaSerializableTest {

}
