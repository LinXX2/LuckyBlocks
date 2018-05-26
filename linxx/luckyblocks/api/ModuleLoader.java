package linxx.luckyblocks.api;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;

import linxx.luckyblocks.main.LuckyBlocks;

public class ModuleLoader {
    public static ArrayList<Module> modules = new ArrayList();

    public static void load() {
        File folder = new File(LuckyBlocks.GET_INSTANCE().getDataFolder() + "/modules/");
        if (!folder.exists()) {
            folder.mkdir();
        }
        for (File file : ModuleLoader.getFiles(folder)) {
            if (file != null) {
                if (file.isDirectory()) {
                    File[] arrfile = file.listFiles();
                    int n = arrfile.length;
                    int n2 = 0;
                    while (n2 < n) {
                        File f = arrfile[n2];
                        if (f != null) {
                            if (f.getName().endsWith(".class")) {
                                Module m = ModuleLoader.getModule(file, f);
                                if (m != null) {
                                    modules.add(m);
                                }
                            }
                        }
                        ++n2;
                    }
                } else {
                    if (file.getName().endsWith(".class")) {
                        Module m = ModuleLoader.getModule(folder, file);
                        if (m != null) {
                            modules.add(m);
                        }
                    }
                }
            }
        }
        for (Module m : modules) {
            m.load(LuckyBlocks.GET_INSTANCE(), API.GET_INSTANCE());
        }
    }

    private static Module getModule(File folder, File file) {
        Class c = ModuleLoader.getClassFromFile(folder, file);
        if (c == null) {
            return null;
        }
        if (Module.class.isAssignableFrom(c)) {
            try {
                return (Module)c.newInstance();
            }
            catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private static ArrayList<File> getFiles(File folder) {
        ArrayList<File> files = new ArrayList<File>();
        if (folder.isDirectory()) {
            files = new ArrayList<File>(Arrays.asList(folder.listFiles()));
        }
        return files;
    }

    private static Class<?> getClassFromFile(File folder, File file) {
        if (!folder.exists()) {
            return null;
        }
        try {
            URL url = folder.toURL();
            URL[] urls = new URL[]{url};
            URLClassLoader loader = new URLClassLoader(urls, LuckyBlocks.GET_INSTANCE().cl);
            Class cls = loader.loadClass(ModuleLoader.getNameWithoutExtension(file));
            return cls;
        }
        catch (Exception e) {
        	e.printStackTrace();
            return null;
        }
    }

    private static String getNameWithoutExtension(File file) {
        String name = file.getName();
        int pos = name.lastIndexOf(".");
        return name.substring(0, pos);
    }
}