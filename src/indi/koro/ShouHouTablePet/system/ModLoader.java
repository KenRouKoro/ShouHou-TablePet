package indi.koro.ShouHouTablePet.system;

import indi.koro.ShouHouTablePet.data.Data;
import indi.koro.ShouHouTablePet.plugin.Mod;

import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class ModLoader {
    public ModLoader() {

    }

    public void modLoad() {
        File modsfile = new File("mods");
        File modsfiles[] = modsfile.listFiles();
        ArrayList<File> trueMods = new ArrayList<>();
        if (modsfiles == null) return;

        for (File file : modsfiles) {
            if (file.isFile()) trueMods.add(file);
        }
        //加载
        for (File mods : trueMods) {
            Set<Class<?>> classes = new LinkedHashSet<Class<?>>();//所有的Class对象
            Map<Class<?>, Annotation[]> classAnnotationMap = new HashMap<Class<?>, Annotation[]>();//每个Class对象上的注释对象
            Map<Class<?>, Map<Method, Annotation[]>> classMethodAnnoMap = new HashMap<Class<?>, Map<Method, Annotation[]>>();//每个Class对象中每个方法上的注释对象
            try {
                JarFile jarFile = new JarFile(mods);
                URL url = mods.toURL();
                ClassLoader loader = new URLClassLoader(new URL[]{url});//自己定义的classLoader类，把外部路径也加到load路径里，使系统去该路经load对象
                Enumeration<JarEntry> es = jarFile.entries();
                while (es.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) es.nextElement();
                    String name = jarEntry.getName();
                    if (name != null && name.endsWith(".class")) {//只解析了.class文件，没有解析里面的jar包
                        //默认去系统已经定义的路径查找对象，针对外部jar包不能用
                        //Class<?> c = Thread.currentThread().getContextClassLoader().loadClass(name.replace("/", ".").substring(0,name.length() - 6));
                        Class<?> c = loader.loadClass(name.replace("/", ".").substring(0, name.length() - 6));//自己定义的loader路径可以找到
                        System.out.println("加载文件：" + c);
                        classes.add(c);
                        Annotation[] classAnnos = c.getDeclaredAnnotations();
                        classAnnotationMap.put(c, classAnnos);
                        Method[] classMethods = c.getDeclaredMethods();
                        Map<Method, Annotation[]> methodAnnoMap = new HashMap<Method, Annotation[]>();
                        for (int i = 0; i < classMethods.length; i++) {
                            Annotation[] a = classMethods[i].getDeclaredAnnotations();
                            methodAnnoMap.put(classMethods[i], a);
                        }
                        classMethodAnnoMap.put(c, methodAnnoMap);
                        while (true) {
                            try {
                                if (c.getSuperclass().getName().equals("indi.koro.ShouHouTablePet.plugin.Mod")) {
                                    Mod mod = (Mod) c.newInstance();
                                    Data.mods.add(mod);
                                    break;
                                } else {
                                    c = c.getSuperclass();
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                break;
                            }
                        }
                    }
                }
                System.out.println("加载本文件类总数：" + classes.size());
            } catch (EOFException e) {

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public void petLoad() {
        File modsfile = new File("pets");
        File modsfiles[] = modsfile.listFiles();
        ArrayList<File> trueMods = new ArrayList<>();
        if (modsfiles == null) return;
        for (File file : modsfiles) {
            if (file.isFile()) trueMods.add(file);
        }
        //加载
        for (File mods : trueMods) {
            Set<Class<?>> classes = new LinkedHashSet<Class<?>>();//所有的Class对象
            Map<Class<?>, Annotation[]> classAnnotationMap = new HashMap<Class<?>, Annotation[]>();//每个Class对象上的注释对象
            Map<Class<?>, Map<Method, Annotation[]>> classMethodAnnoMap = new HashMap<Class<?>, Map<Method, Annotation[]>>();//每个Class对象中每个方法上的注释对象
            try {
                JarFile jarFile = new JarFile(mods);
                URL url = mods.toURL();
                ClassLoader loader = new URLClassLoader(new URL[]{url});//自己定义的classLoader类，把外部路径也加到load路径里，使系统去该路经load对象
                Enumeration<JarEntry> es = jarFile.entries();
                while (es.hasMoreElements()) {
                    JarEntry jarEntry = (JarEntry) es.nextElement();
                    String name = jarEntry.getName();
                    if (name != null && name.endsWith(".class")) {//只解析了.class文件，没有解析里面的jar包
                        //默认去系统已经定义的路径查找对象，针对外部jar包不能用
                        //Class<?> c = Thread.currentThread().getContextClassLoader().loadClass(name.replace("/", ".").substring(0,name.length() - 6));
                        Class<?> c = loader.loadClass(name.replace("/", ".").substring(0, name.length() - 6));//自己定义的loader路径可以找到
                        System.out.println("加载文件：" + c);
                        classes.add(c);
                        Annotation[] classAnnos = c.getDeclaredAnnotations();
                        classAnnotationMap.put(c, classAnnos);
                        Method[] classMethods = c.getDeclaredMethods();
                        Map<Method, Annotation[]> methodAnnoMap = new HashMap<Method, Annotation[]>();
                        for (int i = 0; i < classMethods.length; i++) {
                            Annotation[] a = classMethods[i].getDeclaredAnnotations();
                            methodAnnoMap.put(classMethods[i], a);
                        }
                        classMethodAnnoMap.put(c, methodAnnoMap);
                        while (true) {
                            try {
                                if (c.getSuperclass().getName().equals("indi.koro.ShouHouTablePet.system.Pet")) {
                                    Pet pet = (Pet) c.newInstance();
                                    Data.pets.put(pet.getName(), pet);
                                    break;
                                } else {
                                    c = c.getSuperclass();
                                }
                            } catch (Exception e) {
                                break;
                            }
                        }
                    }
                }
                System.out.println("加载本文件类总数：" + classes.size());

            } catch (EOFException e) {

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
