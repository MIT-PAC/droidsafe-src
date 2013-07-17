package junit.runner;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.io.*;
import java.net.URL;
import java.util.zip.*;

public class TestCaseClassLoader extends ClassLoader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.437 -0400", hash_original_field = "6DC07F35CC4626DDD55666217A1F8835", hash_generated_field = "CDE9A4356D91B8BE55E8D619F0B3C51E")

    private Vector fPathItems;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.437 -0400", hash_original_field = "F9425CAC411731858F04BB39F8970922", hash_generated_field = "69D32B1CA456D0B12288E98BB181C5A3")

    private String[] defaultExclusions = {
		"junit.framework.", 
		"junit.extensions.", 
		"junit.runner."
	};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.437 -0400", hash_original_field = "0479666B7B9CA752A56FBA15EDB1ED11", hash_generated_field = "50D4D05A2CF19A614A26430E9E2D854F")

    private Vector fExcluded;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.437 -0400", hash_original_method = "34D150DBA15CCC20FE0F33E337B5D5A0", hash_generated_method = "0405E7A9F9CDDBD8059303C3584E3D81")
    public  TestCaseClassLoader() {
        this(System.getProperty("java.class.path"));
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.438 -0400", hash_original_method = "F24087B7DF675CB39963D340E9AD0382", hash_generated_method = "D0925693CBC5D77C68D15A229C5B0D95")
    public  TestCaseClassLoader(String classPath) {
        addTaint(classPath.getTaint());
        scanPath(classPath);
        readExcludedPackages();
        // ---------- Original Method ----------
        //scanPath(classPath);
        //readExcludedPackages();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.438 -0400", hash_original_method = "D6CB27563073EDFA6C1A1F398697E6E2", hash_generated_method = "F77E182DE81433C52CF97C4B208B5996")
    private void scanPath(String classPath) {
        addTaint(classPath.getTaint());
        String separator = System.getProperty("path.separator");
        fPathItems= new Vector(10);
        StringTokenizer st = new StringTokenizer(classPath, separator);
        while
(st.hasMoreTokens())        
        {
            fPathItems.addElement(st.nextToken());
        } //End block
        // ---------- Original Method ----------
        //String separator= System.getProperty("path.separator");
        //fPathItems= new Vector(10);
        //StringTokenizer st= new StringTokenizer(classPath, separator);
        //while (st.hasMoreTokens()) {
			//fPathItems.addElement(st.nextToken());
		//}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.438 -0400", hash_original_method = "AD2D4B295C951CB6F23A0FC95F789D06", hash_generated_method = "C5220FCCFBAAA8F42A7CB30B5F178C0E")
    public URL getResource(String name) {
        addTaint(name.getTaint());
URL var3B4FE7F0BAA357C9C981381484B8370E_779329559 =         ClassLoader.getSystemResource(name);
        var3B4FE7F0BAA357C9C981381484B8370E_779329559.addTaint(taint);
        return var3B4FE7F0BAA357C9C981381484B8370E_779329559;
        // ---------- Original Method ----------
        //return ClassLoader.getSystemResource(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.439 -0400", hash_original_method = "E25FB0A342865210AC2893507B1969D9", hash_generated_method = "272ABA76516BD4241E6A1A38F3B74836")
    public InputStream getResourceAsStream(String name) {
        addTaint(name.getTaint());
InputStream var01C5C7295C81AB8015BCC0F108FE2C88_1155671409 =         ClassLoader.getSystemResourceAsStream(name);
        var01C5C7295C81AB8015BCC0F108FE2C88_1155671409.addTaint(taint);
        return var01C5C7295C81AB8015BCC0F108FE2C88_1155671409;
        // ---------- Original Method ----------
        //return ClassLoader.getSystemResourceAsStream(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.439 -0400", hash_original_method = "9B640A23D84324F25105A52D659CD058", hash_generated_method = "1F921D6D4174B11F9B9EBB799889F70A")
    public boolean isExcluded(String name) {
        addTaint(name.getTaint());
for(int i= 0;i < fExcluded.size();i++)
        {
            if(name.startsWith((String) fExcluded.elementAt(i)))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1404287162 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1668860839 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1668860839;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_327811050 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1980696871 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1980696871;
        // ---------- Original Method ----------
        //for (int i= 0; i < fExcluded.size(); i++) {
			//if (name.startsWith((String) fExcluded.elementAt(i))) {
				//return true;
			//}
		//}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.440 -0400", hash_original_method = "5A8E1629692D9DC7C7333C92257A2E23", hash_generated_method = "F3FDFB72950443E5BF50664BE2A212E6")
    public synchronized Class loadClass(String name, boolean resolve) throws ClassNotFoundException {
        addTaint(resolve);
        addTaint(name.getTaint());
        Class c = findLoadedClass(name);
        if(c != null)        
        {
Class var807FB10045EE51C06BDB74744A6714DF_2141895681 =         c;
        var807FB10045EE51C06BDB74744A6714DF_2141895681.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_2141895681;
        }
        if(isExcluded(name))        
        {
            try 
            {
                c= findSystemClass(name);
Class var807FB10045EE51C06BDB74744A6714DF_91866559 =                 c;
                var807FB10045EE51C06BDB74744A6714DF_91866559.addTaint(taint);
                return var807FB10045EE51C06BDB74744A6714DF_91866559;
            } //End block
            catch (ClassNotFoundException e)
            {
            } //End block
        } //End block
        if(c == null)        
        {
            byte[] data = lookupClassData(name);
            if(data == null)            
            {
            ClassNotFoundException var71A8680E9E32D6CDE5532D0AD6B7BA34_797846903 = new ClassNotFoundException();
            var71A8680E9E32D6CDE5532D0AD6B7BA34_797846903.addTaint(taint);
            throw var71A8680E9E32D6CDE5532D0AD6B7BA34_797846903;
            }
            c= defineClass(name, data, 0, data.length);
        } //End block
        if(resolve)        
        resolveClass(c);
Class var807FB10045EE51C06BDB74744A6714DF_76383369 =         c;
        var807FB10045EE51C06BDB74744A6714DF_76383369.addTaint(taint);
        return var807FB10045EE51C06BDB74744A6714DF_76383369;
        // ---------- Original Method ----------
        //Class c= findLoadedClass(name);
        //if (c != null)
			//return c;
        //if (isExcluded(name)) {
			//try {
				//c= findSystemClass(name);
				//return c;
			//} catch (ClassNotFoundException e) {
			//}
		//}
        //if (c == null) {
			//byte[] data= lookupClassData(name);
			//if (data == null)
				//throw new ClassNotFoundException();
			//c= defineClass(name, data, 0, data.length);
		//}
        //if (resolve) 
			//resolveClass(c);
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.442 -0400", hash_original_method = "43D8A8DE8192DE4313AA08C95ADD1453", hash_generated_method = "E85686ABAC1B3C78D2960FEE3898A05A")
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
            } //End block
            else
            {
                data= loadFileData(path, fileName);
            } //End block
            if(data != null)            
            {
            byte[] var8D777F385D3DFEC8815D20F7496026DC_119517313 = (data);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1546293711 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1546293711;
            }
        } //End block
        ClassNotFoundException var861A229D206F1BEB1A241D25B0C809D0_2146897739 = new ClassNotFoundException(className);
        var861A229D206F1BEB1A241D25B0C809D0_2146897739.addTaint(taint);
        throw var861A229D206F1BEB1A241D25B0C809D0_2146897739;
        // ---------- Original Method ----------
        //byte[] data= null;
        //for (int i= 0; i < fPathItems.size(); i++) {
			//String path= (String) fPathItems.elementAt(i);
			//String fileName= className.replace('.', '/')+".class";
			//if (isJar(path)) {
				//data= loadJarData(path, fileName);
			//} else {
				//data= loadFileData(path, fileName);
			//}
			//if (data != null)
				//return data;
		//}
        //throw new ClassNotFoundException(className);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.443 -0400", hash_original_method = "D1958816D560AAF990D492328B2ACA22", hash_generated_method = "F0729B95EFB6687C66BF303DAAA004D8")
     boolean isJar(String pathEntry) {
        addTaint(pathEntry.getTaint());
        boolean varF3691E55B353EC6F9EAF59D23C5B6D01_27589363 = (pathEntry.endsWith(".jar") ||
		       pathEntry.endsWith(".apk") ||
                       pathEntry.endsWith(".zip"));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_750441689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_750441689;
        // ---------- Original Method ----------
        //return pathEntry.endsWith(".jar") ||
		       //pathEntry.endsWith(".apk") ||
                       //pathEntry.endsWith(".zip");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.444 -0400", hash_original_method = "4C328FCFB8D8C5A73ACC65BA858A3F7E", hash_generated_method = "C09343EB8217B80608C57897ABAC20DA")
    private byte[] loadFileData(String path, String fileName) {
        addTaint(fileName.getTaint());
        addTaint(path.getTaint());
        File file = new File(path, fileName);
        if(file.exists())        
        {
            byte[] varF7756083E8CBC250CF2CEDD22D01805D_289280749 = (getClassData(file));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_198538238 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_198538238;
        } //End block
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1773481664 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_356105228 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_356105228;
        // ---------- Original Method ----------
        //File file= new File(path, fileName);
        //if (file.exists()) { 
			//return getClassData(file);
		//}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.444 -0400", hash_original_method = "6E324290C9C24F4E29DE2D96FABDFD83", hash_generated_method = "1AAD5F78F9A2131415563F0164A42F2F")
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
            byte[] var474D8A60A7CCB5FD5B9F226F06BEEEB7_1140544597 = (out.toByteArray());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_850472456 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_850472456;
        } //End block
        catch (IOException e)
        {
        } //End block
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_712085170 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1562196144 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1562196144;
        // ---------- Original Method ----------
        //try {
			//FileInputStream stream= new FileInputStream(f);
			//ByteArrayOutputStream out= new ByteArrayOutputStream(1000);
			//byte[] b= new byte[1000];
			//int n;
			//while ((n= stream.read(b)) != -1) 
				//out.write(b, 0, n);
			//stream.close();
			//out.close();
			//return out.toByteArray();
		//} catch (IOException e) {
		//}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.447 -0400", hash_original_method = "C76B1C7062D123058031C76531140DC1", hash_generated_method = "03D6CA4AC68CFDC1F9E51C53D736BC20")
    private byte[] loadJarData(String path, String fileName) {
        addTaint(fileName.getTaint());
        addTaint(path.getTaint());
        ZipFile zipFile = null;
        InputStream stream = null;
        File archive = new File(path);
        if(!archive.exists())        
        {
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_797712301 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1962887161 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1962887161;
        }
        try 
        {
            zipFile= new ZipFile(archive);
        } //End block
        catch (IOException io)
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1179113276 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_213774770 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_213774770;
        } //End block
        ZipEntry entry = zipFile.getEntry(fileName);
        if(entry == null)        
        {
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_1382125105 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1703986525 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1703986525;
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
            } //End block
            zipFile.close();
            byte[] var8D777F385D3DFEC8815D20F7496026DC_2108089310 = (data);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1413849826 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1413849826;
        } //End block
        catch (IOException e)
        {
        } //End block
        finally 
        {
            try 
            {
                if(stream != null)                
                stream.close();
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
        byte[] var37A6259CC0C1DAE299A7866489DFF0BD_2002944630 = (null);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_520525317 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_520525317;
        // ---------- Original Method ----------
        //ZipFile zipFile= null;
        //InputStream stream= null;
        //File archive= new File(path);
        //if (!archive.exists())
			//return null;
        //try {
			//zipFile= new ZipFile(archive);
		//} catch(IOException io) {
			//return null;
		//}
        //ZipEntry entry= zipFile.getEntry(fileName);
        //if (entry == null)
			//return null;
        //int size= (int) entry.getSize();
        //try {
			//stream= zipFile.getInputStream(entry);
			//byte[] data= new byte[size];
			//int pos= 0;
			//while (pos < size) {
				//int n= stream.read(data, pos, data.length - pos);
				//pos += n;
			//}
			//zipFile.close();
			//return data;
		//} catch (IOException e) {
		//} finally {
			//try {
				//if (stream != null)
					//stream.close();
			//} catch (IOException e) {
			//}
		//}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.449 -0400", hash_original_method = "1F7171E3DD1B25E20F5BDFEA6D44B6AF", hash_generated_method = "1818E03E59D42FBBA0C67FD218135035")
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
        } //End block
        catch (IOException e)
        {
            return;
        } //End block
        finally 
        {
            try 
            {
                is.close();
            } //End block
            catch (IOException e)
            {
            } //End block
        } //End block
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
            } //End block
        } //End block
        // ---------- Original Method ----------
        //fExcluded= new Vector(10);
        //for (int i= 0; i < defaultExclusions.length; i++)
			//fExcluded.addElement(defaultExclusions[i]);
        //InputStream is= getClass().getResourceAsStream(EXCLUDED_FILE);
        //if (is == null) 
			//return;
        //Properties p= new Properties();
        //try {
			//p.load(is);
		//}
		//catch (IOException e) {
			//return;
		//} finally {
			//try {
				//is.close();
			//} catch (IOException e) {
			//}
		//}
        //for (Enumeration e= p.propertyNames(); e.hasMoreElements(); ) {
			//String key= (String)e.nextElement();
			//if (key.startsWith("excluded.")) {
				//String path= p.getProperty(key);
				//path= path.trim();
				//if (path.endsWith("*"))
					//path= path.substring(0, path.length()-1);
				//if (path.length() > 0) 
					//fExcluded.addElement(path);				
			//}
		//}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:19.449 -0400", hash_original_field = "E81E5A40100021288FF5759B58F946E3", hash_generated_field = "CD4C74902896CC679399E8EEF125BD8F")

    static final String EXCLUDED_FILE = "excluded.properties";
}

