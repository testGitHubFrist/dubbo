package com.dubbo.common.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/**
 * 获取系统信息工具类
 *
 * @author GaoQun
 */
public class OSUtils {

    private static String localName = null;

    private static String localIp = null;

    private OSUtils() {

    }

    /**
     * 获取服务器名称
     *
     * @return
     */
    public static String linuxLocalName() {
        if (localName == null) {
            InetAddress localhost = getInetAddr();
            if (localhost != null) {
                localName = localhost.getHostName();
            }
        }
        return localName;
    }

    /**
     * 获取网络地址信息
     *
     * @return
     */
    private synchronized static InetAddress getInetAddr() {
        InetAddress localhost = null;
        try {
            localhost = InetAddress.getLocalHost();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return localhost;
    }

    /**
     * 获取本机的IP地址，并自动区分Windows系统还是Linux系统
     *
     * @return
     */
    public static String getLocalIP() {
        if (localIp == null) {
            doGetLocalIp();
        }
        return localIp;
    }

    private synchronized static void doGetLocalIp() {

        InetAddress ip = null;
        try {
            //判断是否是windows系统
            if (isWindowsOS()) {
                ip = InetAddress.getLocalHost();
            } else {
                //如果是Linux系统
                boolean bFindIP = false;
                Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
                while (networkInterface.hasMoreElements()) {
                    if (bFindIP) {
                        break;
                    }
                    NetworkInterface ni = networkInterface.nextElement();
                    Enumeration<InetAddress> ips = ni.getInetAddresses();
                    while (ips.hasMoreElements()) {
                        ip = ips.nextElement();
                        if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && !ip.getHostAddress().contains(":"))
                            bFindIP = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (ip != null) {
            localIp = ip.getHostAddress();
        }
    }

    /**
     * 判断是windows还是Linux
     *
     * @return
     */
    public static boolean isWindowsOS() {
        boolean isWindowsOS = false;
        String osName = System.getProperty("os.name");
        if (osName.toLowerCase().indexOf("windows") > -1) {
            isWindowsOS = true;
        }
        return isWindowsOS;
    }

    /**
     * 本地ip是否等于给定的IP
     *
     * @param ip
     * @return
     */
    public static boolean isEqualOtherIp(String ip) {
        boolean flag = false;
        if (ip == null || ip.length() == 0) {
            return false;
        }
        InetAddress localAddress = null;
        try {
            boolean bFindIP = false;
            Enumeration<NetworkInterface> networkInterface = NetworkInterface.getNetworkInterfaces();
            while (networkInterface.hasMoreElements()) {
                if (bFindIP) {
                    break;
                }
                NetworkInterface ni = networkInterface.nextElement();
                Enumeration<InetAddress> ips = ni.getInetAddresses();
                while (ips.hasMoreElements()) {
                    localAddress = ips.nextElement();
                    if (localAddress.getHostAddress().equals(ip))
                        bFindIP = true;
                    flag = true;
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
