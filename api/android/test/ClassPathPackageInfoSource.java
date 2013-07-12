package android.test;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.util.Log;
import com.google.android.collect.Maps;
import com.google.android.collect.Sets;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClassPathPackageInfoSource {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.922 -0400", hash_original_field = "5B48EC82264433BE164C825255AA2E2A", hash_generated_field = "2B4356F3CF13916E7DA764DFF592B50A")

    private final SimpleCache<String, ClassPathPackageInfo> cache = new SimpleCache<String, ClassPathPackageInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.922 -0400", hash_original_method = "C51B16E1A4E4D11F95C896FC8BD4A403", hash_generated_method = "D2CF2C83C4D88A5629AEC2A61FFA1A52")
        @Override
        protected ClassPathPackageInfo load(String pkgName) {
            addTaint(pkgName.getTaint());
ClassPathPackageInfo varBA00A6319552DBD246ACAD32EC974A7E_2039982539 =             createPackageInfo(pkgName);
            varBA00A6319552DBD246ACAD32EC974A7E_2039982539.addTaint(taint);
            return varBA00A6319552DBD246ACAD32EC974A7E_2039982539;
            
            
        }

        
};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.922 -0400", hash_original_field = "CD3FFF114C1E7AE001E9F0E995A21BC7", hash_generated_field = "738E08BA6D6240CD75FE2D1444323B8B")

    private String[] classPath;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.922 -0400", hash_original_field = "ED7CFCFF79B065F3584DF80079D00758", hash_generated_field = "10F94FB6EB6D746C033B473F8D40E7A3")

    private final Map<File, Set<String>> jarFiles = Maps.newHashMap();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.922 -0400", hash_original_field = "23508C9A13E40798812B11A9CFC1E55C", hash_generated_field = "F6BCA95A9F68D069180083A80576157E")

    private ClassLoader classLoader;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.922 -0400", hash_original_method = "5ED3C641A9C0B2F78FCA551972DB4070", hash_generated_method = "0F78D94EE956F24FEB5E237D1FEF66F4")
      ClassPathPackageInfoSource() {
        classPath = getClassPath();
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static void setApkPaths(String[] apkPaths) {
        ClassPathPackageInfoSource.apkPaths = apkPaths;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.923 -0400", hash_original_method = "DA950CFDA512912E4146952A9FFE3442", hash_generated_method = "246B8AE7E6F783FA5ACD797FD094CDB5")
    public ClassPathPackageInfo getPackageInfo(String pkgName) {
        addTaint(pkgName.getTaint());
ClassPathPackageInfo var999A519CF27E9DF61AC55F1537EAA8F8_1467713945 =         cache.get(pkgName);
        var999A519CF27E9DF61AC55F1537EAA8F8_1467713945.addTaint(taint);
        return var999A519CF27E9DF61AC55F1537EAA8F8_1467713945;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.923 -0400", hash_original_method = "276BBF38C683664C5FC093FA16997BEF", hash_generated_method = "DB6229CF815CA9E427004CB62B41E08E")
    private ClassPathPackageInfo createPackageInfo(String packageName) {
        addTaint(packageName.getTaint());
        Set<String> subpackageNames = new TreeSet<String>();
        Set<String> classNames = new TreeSet<String>();
        Set<Class<?>> topLevelClasses = Sets.newHashSet();
        findClasses(packageName, classNames, subpackageNames);
for(String className : classNames)
        {
    if(className.endsWith(".R") || className.endsWith(".Manifest"))            
            {
                continue;
            } 
            try 
            {
                topLevelClasses.add(Class.forName(className, false,
                        (classLoader != null) ? classLoader : CLASS_LOADER));
            } 
            catch (ClassNotFoundException e)
            {
            } 
        } 
ClassPathPackageInfo var401CB2EAF9C0C6CEC18A24A21E312BEC_362904609 =         new ClassPathPackageInfo(this, packageName, subpackageNames,
                topLevelClasses);
        var401CB2EAF9C0C6CEC18A24A21E312BEC_362904609.addTaint(taint);
        return var401CB2EAF9C0C6CEC18A24A21E312BEC_362904609;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.924 -0400", hash_original_method = "8D4A1EEE314B3C48143C50241149E8EC", hash_generated_method = "AB67DC00BFB462E02849C9C5A1140BCA")
    private void findClasses(String packageName, Set<String> classNames,
            Set<String> subpackageNames) {
        addTaint(subpackageNames.getTaint());
        addTaint(classNames.getTaint());
        addTaint(packageName.getTaint());
        String packagePrefix = packageName + '.';
        String pathPrefix = packagePrefix.replace('.', '/');
for(String entryName : classPath)
        {
            File classPathEntry = new File(entryName);
    if(classPathEntry.exists())            
            {
                try 
                {
    if(entryName.endsWith(".apk"))                    
                    {
                        findClassesInApk(entryName, packageName, classNames, subpackageNames);
                    } 
                    else
                    {
for(String apkPath : apkPaths)
                        {
                            File file = new File(apkPath);
                            scanForApkFiles(file, packageName, classNames, subpackageNames);
                        } 
                    } 
                } 
                catch (IOException e)
                {
                    AssertionError var8BAAF0487644E6BADFA04E3D9E011EF9_1399756924 = new AssertionError("Can't read classpath entry " +
                            entryName + ": " + e.getMessage());
                    var8BAAF0487644E6BADFA04E3D9E011EF9_1399756924.addTaint(taint);
                    throw var8BAAF0487644E6BADFA04E3D9E011EF9_1399756924;
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.925 -0400", hash_original_method = "A7DD27ACC72325E48B148F5150BD252D", hash_generated_method = "E312F7E29CA0A55E3925B8DB34CBB42F")
    private void scanForApkFiles(File source, String packageName,
            Set<String> classNames, Set<String> subpackageNames) throws IOException {
        addTaint(subpackageNames.getTaint());
        addTaint(classNames.getTaint());
        addTaint(packageName.getTaint());
        addTaint(source.getTaint());
    if(source.getPath().endsWith(".apk"))        
        {
            findClassesInApk(source.getPath(), packageName, classNames, subpackageNames);
        } 
        else
        {
            File[] files = source.listFiles();
    if(files != null)            
            {
for(File file : files)
                {
                    scanForApkFiles(file, packageName, classNames, subpackageNames);
                } 
            } 
        } 
        
        
            
        
            
            
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.925 -0400", hash_original_method = "7C382FB07C89ED3AC2E0C82EFB5FB1EF", hash_generated_method = "BA3521FA93713567A7DA333437D90E3D")
    private void findClassesInDirectory(File classDir,
            String packagePrefix, String pathPrefix, Set<String> classNames,
            Set<String> subpackageNames) throws IOException {
        addTaint(subpackageNames.getTaint());
        addTaint(classNames.getTaint());
        addTaint(pathPrefix.getTaint());
        addTaint(packagePrefix.getTaint());
        addTaint(classDir.getTaint());
        File directory = new File(classDir, pathPrefix);
    if(directory.exists())        
        {
for(File f : directory.listFiles())
            {
                String name = f.getName();
    if(name.endsWith(CLASS_EXTENSION) && isToplevelClass(name))                
                {
                    classNames.add(packagePrefix + getClassName(name));
                } 
                else
    if(f.isDirectory())                
                {
                    subpackageNames.add(packagePrefix + name);
                } 
            } 
        } 
        
        
        
            
                
                
                    
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.926 -0400", hash_original_method = "C944AB8B1856D79715AAA6F332DF1C0A", hash_generated_method = "EDFC276F696F5A071CFFB1CFA98881AB")
    private void findClassesInJar(File jarFile, String pathPrefix,
            Set<String> classNames, Set<String> subpackageNames) throws IOException {
        addTaint(subpackageNames.getTaint());
        addTaint(classNames.getTaint());
        addTaint(pathPrefix.getTaint());
        addTaint(jarFile.getTaint());
        Set<String> entryNames = getJarEntries(jarFile);
    if(!entryNames.contains(pathPrefix))        
        {
            return;
        } 
        int prefixLength = pathPrefix.length();
for(String entryName : entryNames)
        {
    if(entryName.startsWith(pathPrefix))            
            {
    if(entryName.endsWith(CLASS_EXTENSION))                
                {
                    int index = entryName.indexOf('/', prefixLength);
    if(index >= 0)                    
                    {
                        String p = entryName.substring(0, index).replace('/', '.');
                        subpackageNames.add(p);
                    } 
                    else
    if(isToplevelClass(entryName))                    
                    {
                        classNames.add(getClassName(entryName).replace('/', '.'));
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.927 -0400", hash_original_method = "3DB74F10ACB7465BB59ECD7AE11AEF17", hash_generated_method = "5C904D1DCE46A42DFF5EAF8174DEE0B3")
    private void findClassesInApk(String apkPath, String packageName,
            Set<String> classNames, Set<String> subpackageNames) throws IOException {
        addTaint(subpackageNames.getTaint());
        addTaint(classNames.getTaint());
        addTaint(packageName.getTaint());
        addTaint(apkPath.getTaint());
        DexFile dexFile = null;
        try 
        {
            dexFile = new DexFile(apkPath);
            Enumeration<String> apkClassNames = dexFile.entries();
            while
(apkClassNames.hasMoreElements())            
            {
                String className = apkClassNames.nextElement();
    if(className.startsWith(packageName))                
                {
                    String subPackageName = packageName;
                    int lastPackageSeparator = className.lastIndexOf('.');
    if(lastPackageSeparator > 0)                    
                    {
                        subPackageName = className.substring(0, lastPackageSeparator);
                    } 
    if(subPackageName.length() > packageName.length())                    
                    {
                        subpackageNames.add(subPackageName);
                    } 
                    else
    if(isToplevelClass(className))                    
                    {
                        classNames.add(className);
                    } 
                } 
            } 
        } 
        catch (IOException e)
        {
    if(false)            
            {
            } 
        } 
        finally 
        {
    if(dexFile != null)            
            {
            } 
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.928 -0400", hash_original_method = "47511CFE3B18B3B12FAA22B4CA43B4A2", hash_generated_method = "6157884CBE6BAE8619BC6EFAC5CDCDC4")
    private Set<String> getJarEntries(File jarFile) throws IOException {
        addTaint(jarFile.getTaint());
        Set<String> entryNames = jarFiles.get(jarFile);
    if(entryNames == null)        
        {
            entryNames = Sets.newHashSet();
            ZipFile zipFile = new ZipFile(jarFile);
            Enumeration<? extends ZipEntry> entries = zipFile.entries();
            while
(entries.hasMoreElements())            
            {
                String entryName = entries.nextElement().getName();
    if(entryName.endsWith(CLASS_EXTENSION))                
                {
                    entryNames.add(entryName);
                    int lastIndex = entryName.lastIndexOf('/');
                    do {
                        {
                            String packageName = entryName.substring(0, lastIndex + 1);
                            entryNames.add(packageName);
                            lastIndex = entryName.lastIndexOf('/', lastIndex - 1);
                        } 
} while (lastIndex > 0);
                } 
            } 
            jarFiles.put(jarFile, entryNames);
        } 
Set<String> var765F5FFF692F7D7E6B8C4D556FF7DF0A_626530695 =         entryNames;
        var765F5FFF692F7D7E6B8C4D556FF7DF0A_626530695.addTaint(taint);
        return var765F5FFF692F7D7E6B8C4D556FF7DF0A_626530695;
        
        
    }

    
        private static boolean isToplevelClass(String fileName) {
        return fileName.indexOf('$') < 0;
    }

    
        private static String getClassName(String className) {
        int classNameEnd = className.length() - CLASS_EXTENSION.length();
        return className.substring(0, classNameEnd);
    }

    
        private static String[] getClassPath() {
        String classPath = System.getProperty("java.class.path");
        String separator = System.getProperty("path.separator", ":");
        return classPath.split(Pattern.quote(separator));
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.929 -0400", hash_original_method = "EF51D9ADCA3E8F522FB005D173D913A5", hash_generated_method = "278C4AA58E3CC699090BB3856901B327")
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.929 -0400", hash_original_field = "43D0B420770CE85BCC54EEC5FE168CE7", hash_generated_field = "0A8E39F88964FFF21016A3B57374DBA5")

    private static final String CLASS_EXTENSION = ".class";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.929 -0400", hash_original_field = "867953EB5DDC22A2D7EF6CA92EC0222B", hash_generated_field = "4A3AFCB5D516866BED33F518C5F5F314")

    private static final ClassLoader CLASS_LOADER = ClassPathPackageInfoSource.class.getClassLoader();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:42.930 -0400", hash_original_field = "37BD4660999DA76F0835AF67E313023E", hash_generated_field = "E1257C69AD4D655B417A83840C52F8B9")

    private static String[] apkPaths;
}

