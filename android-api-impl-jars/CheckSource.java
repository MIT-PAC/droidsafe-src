import java.util.jar.*;
import java.util.HashSet;
import java.util.Enumeration;
import java.io.File;
import java.io.FilenameFilter;

public class CheckSource {
    private static String STUB_FILE = "../android.jar";
    
    public static void main(String[] args) throws Exception {
        JarFile stubJar = new JarFile(STUB_FILE, true);
        HashSet<String> stubClasses = new HashSet<String>();
        HashSet<String> notInStub = new HashSet<String>();

        for (Enumeration e = stubJar.entries(); e.hasMoreElements() ;) {
            JarEntry entry = (JarEntry)e.nextElement();
            
            stubClasses.add(entry.getName());
        }

        File currentDir = new File(".");
        File[] SRC_FILES = currentDir.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.matches(".*\\.jar");
                } 
            });

        for (File srcFile : SRC_FILES) {
            System.out.println("Using jar src file: " + srcFile);
            JarFile srcJar = new JarFile(srcFile, true);

             for (Enumeration e = srcJar.entries(); e.hasMoreElements() ;) {
                 JarEntry entry = (JarEntry)e.nextElement();
                 
                 if (entry.getName().endsWith(".class") && !stubClasses.contains(entry.getName()))
                     notInStub.add(entry.getName());

                 stubClasses.remove(entry.getName());
                 //                 System.out.println(entry.getName());
             }
        }
        
        System.out.println("\nMissing Classes:");
        for (String missing : stubClasses) {
            if (missing.endsWith(".class"))
                System.out.println(missing);
        }

        System.out.println("Have source but not in stub jar");
        for (String c : notInStub) {
            
            System.out.println(c);
        }
    }

}
