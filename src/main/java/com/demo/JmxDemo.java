package com.demo;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.CompilationMXBean;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryManagerMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.management.OperatingSystemMXBean;
import java.lang.management.RuntimeMXBean;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by zhi.wang on 2017/11/30.
 */
public class JmxDemo {

    private static void printContent(Method[] methods, Object object) throws Exception {
        for (Method method : methods) {
            method.setAccessible(true);
            if (!method.getName().startsWith("set") || !method.getName().startsWith("is")) {
                System.out.println(method.getName());
                System.out.println(method.invoke(object));
                System.out.println("-----------------------------------");
            }
        }
    }

    private static void printRuntimeMXBean() throws Exception {
        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
        Method[] methods = runtimeMXBean.getClass().getMethods();
        printContent(methods, runtimeMXBean);
    }

    private static void printClassLoadingMXBean() throws Exception {
        ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
        Method[] methods = classLoadingMXBean.getClass().getMethods();
        printContent(methods, classLoadingMXBean);
    }

    private static void printCompilationMXBean() throws Exception {
        CompilationMXBean compilationMXBean = ManagementFactory.getCompilationMXBean();
        Method[] methods = compilationMXBean.getClass().getMethods();
        printContent(methods, compilationMXBean);
    }

    private static void printGarbageCollectorMXBean() throws Exception {
        List<GarbageCollectorMXBean> list = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean mxBean : list) {
            Method[] methods = mxBean.getClass().getMethods();
            printContent(methods, mxBean);
        }
    }

    private static void printMemoryManagerMXBean() throws Exception {
        List<MemoryManagerMXBean> list = ManagementFactory.getMemoryManagerMXBeans();
        for (MemoryManagerMXBean mxBean : list) {
            Method[] methods = mxBean.getClass().getMethods();
            printContent(methods, mxBean);
        }
    }

    private static void printMemoryPoolMXBean() throws Exception {
        List<MemoryPoolMXBean> list = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean mxBean : list) {
            Method[] methods = mxBean.getClass().getMethods();
            printContent(methods, mxBean);
        }
    }

    private static void printMemoryMXBean() throws Exception {
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();
        Method[] methods = memoryMXBean.getClass().getMethods();
        printContent(methods, memoryMXBean);
    }

    private static void printOperatingSystemMXBean() throws Exception {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        Method[] methods = operatingSystemMXBean.getClass().getMethods();
        printContent(methods, operatingSystemMXBean);
    }

    private static void ThreadMXBean() throws Exception {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        Method[] methods = threadMXBean.getClass().getMethods();
        printContent(methods, threadMXBean);
    }

    public static void main(String[] args) throws Exception {
        ThreadMXBean();
    }
}
