package com.demo;

import com.alibaba.fastjson.JSON;
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.Sigar;

/**
 * Created by zhi.wang on 2017/11/30.
 */
public class SigarDemo {
    private static Sigar sigar = null;

    private static void printCpu() throws Exception {
        Cpu cpu = sigar.getCpu();
        System.out.println(cpu.toMap());
    }

    private static void printMemory() throws Exception {
        System.out.println(sigar.getMem().toMap());
    }

    private static void printCpuInfo() throws Exception {
        System.out.println(JSON.toJSONString(sigar.getCpuInfoList()));
    }

    public static void main(String[] args) throws Exception {

        //windows下依赖sigar-amd64-winnt.dll
        String classPath = SigarDemo.class.getResource("/").getPath();
        System.setProperty("org.hyperic.sigar.path",classPath);
        sigar = new Sigar();

        printCpu();
        printMemory();
        printCpuInfo();
    }
}
