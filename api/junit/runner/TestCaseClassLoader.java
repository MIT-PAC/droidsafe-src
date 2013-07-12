package junit.runner;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.util.zip.*;

public class TestCaseClassLoader extends ClassLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.437 -0400", hash_original_field = "6DC07F35CC4626DDD55666217A1F8835", hash_generated_field = "CDE9A4356D91B8BE55E8D619F0B3C51E")

    private Vector fPathItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.437 -0400", hash_original_field = "F9425CAC411731858F04BB39F8970922", hash_generated_field = "69D32B1CA456D0B12288E98BB181C5A3")

    private String[] defaultExclusions = {
		"junit.framework.", 
		"junit.extensions.", 
		"junit.runner."
	};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.437 -0400", hash_original_field = "0479666B7B9CA752A56FBA15EDB1ED11", hash_generated_field = "50D4D05A2CF19A614A26430E9E2D854F")

    private Vector fExcluded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.437 -0400", hash_original_method = "34D150DBA15CCC20FE0F33E337B5D5A0", hash_generated_method = "0405E7A9F9CDDBD8059303C3584E3D81")
    public  TestCaseClassLoader() {
        this(System.getProperty("java.class.path"));
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.437 -0400", hash_original_method = "F24087B7DF675CB39963D340E9AD0382", hash_generated_method = "D0925693CBC5D77C68D15A229C5B0D95")
    public  TestCaseClassLoader(String classPath) {
        addTaint(classPath.getTaint());
        scanPath(classPath);
        readExcludedPackages();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.438 -0400", hash_original_method = "D6CB27563073EDFA6C1A1F398697E6E2", hash_generated_method = "F77E182DE81433C52CF97C4B208B5996")
    private void scanPath(String classPath) {
        addTaint(classPath.getTaint());
        String separator = System.getProperty("path.separator");
        fPathItems= new Vector(10);
        StringTokenizer st = new StringTokenizer(classPath, separator);
        while
(st.hasMoreTokens())        
        {
            fPathItems.addElement(st.nextToken());
        } 
        
        
        
        
        
			
		
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.438 -0400", hash_original_method = "AD2D4B295C951CB6F23A0FC95F789D06", hash_generated_method = "BA896609B5A600E26BAFCC8FDA6C8D04")
    public URL getResource(String name) {
        addTaint(name.getTaint());
URL var3B4FE7F0BAA357C9C981381484B8370E_1731220743 =         ClassLoader.getSystemResource(name);
        var3B4FE7F0BAA357C9C981381484B8370E_1731220743.addTaint(taint);
        return var3B4FE7F0BAA357C9C981381484B8370E_1731220743;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.438 -0400", hash_original_method = "E25FB0A342865210AC2893507B1969D9", hash_generated_method = "9B187D90C5EEBA678732D7DF0712F023")
    public InputStream getResourceAsStream(String name) {
        addTaint(name.getTaint());
InputStream var01C5C7295C81AB8015BCC0F108FE2C88_1911620923 =         ClassLoader.getSystemResourceAsStream(name);
        var01C5C7295C81AB8015BCC0F108FE2C88_1911620923.addTaint(taint);
        return var01C5C7295C81AB8015BCC0F108FE2C88_1911620923;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.439 -0400", hash_original_method = "9B640A23D84324F25105A52D659CD058", hash_generated_method = "550609B38F6BB969679778044C41CA01")
    public boolean isExcluded(String name) {
        addTaint(name.getTaint());
for(int i= 0;i < fExcluded.size();i++)
        {
    if(name.startsWith((String) fExcluded.elementAt(i)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1558949852 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903854648 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903854648;
            } 
        } 
        boolean var68934A3E9455FA72420237EB05902327_1683800893 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_339509745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_339509745;
        
        
			
				
			
		
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.440 -0400", hash_original_method = "5A8E1629692D9DC7C7333C92257A2E23", hash_generated_method = "A6D4DC96C279FD0420A39F17D7599B9A")
    public synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        addTaint(resolve);
        addTaint(name.getTaint());
        Class c = findLoadedClass(name);
    if(c != null)        
        {
Class var807FB10045EE51C06BDB74744A6714DF_517878065 =         c;
        var807FB10045EE51C06BDB74744A6714DF_517878065.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_517878065;
        }
    if(isExcluded(name))        
        {
            try 
            {
                c= findSystemClass(name);
Class var807FB10045EE51C06BDB74744A6714DF_677358600 =                 c;
                var807FB10045EE51C06BDB74744A6714DF_677358600.addTaint(taint);
                return var807FB10045EE51C06BDB74744A6714DF_677358600;
            } 
            catch (ClassNotFoundException e)
            {
            } 
        } 
    if(c == null)        
        {
            byte[] data = lookupClassData(name);
    if(data == null)            
            {
            ClassNotFoundException var71A8680E9E32D6CDE5532D0AD6B7BA34_1176627374 = new ClassNotFoundException();
            var71A8680E9E32D6CDE5532D0AD6B7BA34_1176627374.addTaint(taint);
            throw var71A8680E9E32D6CDE5532D0AD6B7BA34_1176627374;
            }
            c= defineClass(name, data, 0, data.length);
        } 
    if(resolve)        
        resolveClass(c);
Class var807FB10045EE51C06BDB74744A6714DF_1049031069 =         c;
        var807FB10045EE51C06BDB74744A6714DF_1049031069.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_1049031069;
        
        
        
			
        
			
				
				
			
			
		
        
			
			
				
			
		
        
			
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.441 -0400", hash_original_method = "43D8A8DE8192DE4313AA08C95ADD1453", hash_generated_method = "5A9E9143B23581E33AE53AEF14080756")
    private byte[] lookupClassData(String className) throws ClassNotFoundException {
        addTaint(className.getTaint());
        byte[] data = null;
for(int i= 0;i < fPathItems.size();i++)
        {
            String path = (String) fPathItems.elementAt(i);
            String fileName = className.replace('.', '/')+".class";
    if(isJar(path))            
            {
                data= loadJarData(path, fileName);
            } 
            else
            {
                data= loadFileData(path, fileName);
            } 
    if(data != null)            
            {
            byte[] var8D777F385D3DFEC8815D20F7496026DC_1609422258 = (data);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1062701959 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1062701959;
            }
        } 
        ClassNotFoundException var861A229D206F1BEB1A241D25B0C809D0_1759380672 = new ClassNotFoundException(className);
        var861A229D206F1BEB1A241D25B0C809D0_1759380672.addTaint(taint);
        throw var861A229D206F1BEB1A241D25B0C809D0_1759380672;
        
        
        
			
			
			
				
			
				
			
			
				
		
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.442 -0400", hash_original_method = "D1958816D560AAF990D492328B2ACA22", hash_generated_method = "8014B8A4E57E031ABDDDD4333B88C4CD")
     boolean isJar(String pathEntry) {
        addTaint(pathEntry.getTaint());
        boolean varF3691E55B353EC6F9EAF59D23C5B6D01_130965031 = (pathEntry.endsWith(".jar") ||
		       pathEntry.endsWith(".apk") ||
                       pathEntry.endsWith(".zip"));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1714382313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1714382313;
        
        
		       
                       
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.442 -0400", hash_original_method = "4C328FCFB8D8C5A73ACC65BA858A3F7E", hash_generated_method = "9EB325257EEF274EA2DB7F662D861217")
    private byte[] loadFileData(String path, String fileName) {
        addTaint(fileName.getTaint());
        addTaint(path.getTaint());
        File file = new File(path, fileName);
    if(file.exists())        
        {
            byte[] varF7756083E8CBC250CF2CEDD22D01805D_1489022178 = (getClassData(file));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_586425636 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_586425636;
        } 
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1529023096 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_797873788 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_797873788;
        
        
        
			
		
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.442 -0400", hash_original_method = "6E324290C9C24F4E29DE2D96FABDFD83", hash_generated_method = "652B3C1C46B23239CAA4C03770AD7C23")
    private byte[] getClassData(File f) {
        addTaint(f.getTaint());
        try 
        {
            FileInputStream stream = new FileInputStream(f);
            ByteArrayOutputStream out = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while
((n= stream.read(b)) != -1)            
            out.write(b, 0, n);
            stream.close();
            out.close();
            byte[] var474D8A60A7CCB5FD5B9F226F06BEEEB7_544340486 = (out.toByteArray());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_372647832 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_372647832;
        } 
        catch (IOException e)
        {
        } 
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_2135666374 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1165215643 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1165215643;
        
        
			
			
			
			
			
				
			
			
			
		
		
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.443 -0400", hash_original_method = "C76B1C7062D123058031C76531140DC1", hash_generated_method = "1C25C07232FE553B5DC0CF702250C80B")
    private byte[] loadJarData(String path, String fileName) {
        addTaint(fileName.getTaint());
        addTaint(path.getTaint());
        ZipFile zipFile = null;
        InputStream stream = null;
        File archive = new File(path);
    if(!archive.exists())        
        {
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1728646387 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1721389352 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1721389352;
        }
        try 
        {
            zipFile= new ZipFile(archive);
        } 
        catch (IOException io)
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1888938451 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1603826945 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1603826945;
        } 
        ZipEntry entry = zipFile.getEntry(fileName);
    if(entry == null)        
        {
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_262084199 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1395435923 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1395435923;
        }
        int size = (int) entry.getSize();
        try 
        {
            stream= zipFile.getInputStream(entry);
            byte[] data = new byte[size];
            int pos = 0;
            while
(pos < size)            
            {
                int n = stream.read(data, pos, data.length - pos);
                pos += n;
            } 
            zipFile.close();
            byte[] var8D777F385D3DFEC8815D20F7496026DC_1982669391 = (data);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_21451482 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_21451482;
        } 
        catch (IOException e)
        {
        } 
        finally 
        {
            try 
            {
    if(stream != null)                
                stream.close();
            } 
            catch (IOException e)
            {
            } 
        } 
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_93533459 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1150709545 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1150709545;
        
        
        
        
        
			
        
			
		
			
		
        
        
			
        
        
			
			
			
			
				
				
			
			
			
		
		
			
				
					
			
			
		
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.445 -0400", hash_original_method = "1F7171E3DD1B25E20F5BDFEA6D44B6AF", hash_generated_method = "1818E03E59D42FBBA0C67FD218135035")
    private void readExcludedPackages() {
        fExcluded= new Vector(10);
for(int i= 0;i < defaultExclusions.length;i++)
        fExcluded.addElement(defaultExclusions[i]);
        InputStream is = getClass().getResourceAsStream(EXCLUDED_FILE);
    if(is == null)        
        return;
        Properties p = new Properties();
        try 
        {
            p.load(is);
        } 
        catch (IOException e)
        {
            return;
        } 
        finally 
        {
            try 
            {
                is.close();
            } 
            catch (IOException e)
            {
            } 
        } 
for(Enumeration e= p.propertyNames();e.hasMoreElements();)
        {
            String key = (String)e.nextElement();
    if(key.startsWith("excluded."))            
            {
                String path = p.getProperty(key);
                path= path.trim();
    if(path.endsWith("*"))                
                path= path.substring(0, path.length()-1);
    if(path.length() > 0)                
                fExcluded.addElement(path);
            } 
        } 
        
        
        
			
        
        
			
        
        
			
		
		
			
		
			
				
			
			
		
        
			
			
				
				
				
					
				
					
			
		
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:21.445 -0400", hash_original_field = "E81E5A40100021288FF5759B58F946E3", hash_generated_field = "CD4C74902896CC679399E8EEF125BD8F")

    static final String EXCLUDED_FILE = "excluded.properties";
}

