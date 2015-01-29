package junit.runner;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class TestCaseClassLoader extends ClassLoader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.604 -0500", hash_original_field = "8BB004A7CF4EF33164EC02A1CDC1B50F", hash_generated_field = "CD4C74902896CC679399E8EEF125BD8F")

	static final String EXCLUDED_FILE= "excluded.properties";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.600 -0500", hash_original_field = "87FC5A6EDF5A9DDC2731D4EE6A9E7A7D", hash_generated_field = "CDE9A4356D91B8BE55E8D619F0B3C51E")

	private Vector fPathItems;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.602 -0500", hash_original_field = "D32989618BA455016B88767AEA3BEC60", hash_generated_field = "69D32B1CA456D0B12288E98BB181C5A3")

	private String[] defaultExclusions= {
		"junit.framework.", 
		"junit.extensions.", 
		"junit.runner."
	};
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.606 -0500", hash_original_field = "0E34FC5E8D6C2A7F40BFC4269AC8544A", hash_generated_field = "50D4D05A2CF19A614A26430E9E2D854F")

	private Vector fExcluded;
	 
	/**
	 * Constructs a TestCaseLoader. It scans the class path
	 * and the excluded package paths
	 */
	@DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.608 -0500", hash_original_method = "34D150DBA15CCC20FE0F33E337B5D5A0", hash_generated_method = "B95E5DE1929152BD530E9CE4F42C9C2C")
	
public TestCaseClassLoader() {
		this(System.getProperty("java.class.path"));
	}
	
	/**
	 * Constructs a TestCaseLoader. It scans the class path
	 * and the excluded package paths
	 */
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.612 -0500", hash_original_method = "F24087B7DF675CB39963D340E9AD0382", hash_generated_method = "9FE0F7C23366ECF1FB281F03164A9AF7")
	
public TestCaseClassLoader(String classPath) {
		scanPath(classPath);
		readExcludedPackages();
	}

	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.614 -0500", hash_original_method = "D6CB27563073EDFA6C1A1F398697E6E2", hash_generated_method = "B7B3DFB26C91F8E6A766C136C162945C")
	
private void scanPath(String classPath) {
		String separator= System.getProperty("path.separator");
		fPathItems= new Vector(10);
		StringTokenizer st= new StringTokenizer(classPath, separator);
		while (st.hasMoreTokens()) {
			fPathItems.addElement(st.nextToken());
		}
	}
	
	@DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.617 -0500", hash_original_method = "AD2D4B295C951CB6F23A0FC95F789D06", hash_generated_method = "CCA7043CDD381E05A1A692A0E46F6708")
	
public URL getResource(String name) {
		return ClassLoader.getSystemResource(name);
	}
	
	@DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.619 -0500", hash_original_method = "E25FB0A342865210AC2893507B1969D9", hash_generated_method = "08EA080A9B3C0B9CB163ED25E1A23C6E")
	
public InputStream getResourceAsStream(String name) {
		return ClassLoader.getSystemResourceAsStream(name);
	}
	
	@DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.621 -0500", hash_original_method = "9B640A23D84324F25105A52D659CD058", hash_generated_method = "A4078FED40FFBA61ED5416B1E8792AAD")
	
public boolean isExcluded(String name) {
		for (int i= 0; i < fExcluded.size(); i++) {
			if (name.startsWith((String) fExcluded.elementAt(i))) {
				return true;
			}
		}
		return false;	
	}
	
	@DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.624 -0500", hash_original_method = "5A8E1629692D9DC7C7333C92257A2E23", hash_generated_method = "5AE423C45A57E5E2A90181A23E317319")
	
public synchronized Class loadClass(String name, boolean resolve)
		throws ClassNotFoundException {
			
		Class c= findLoadedClass(name);
		if (c != null)
			return c;
		//
		// Delegate the loading of excluded classes to the
		// standard class loader.
		//
		if (isExcluded(name)) {
			try {
				c= findSystemClass(name);
				return c;
			} catch (ClassNotFoundException e) {
				// keep searching
			}
		}
		if (c == null) {
			byte[] data= lookupClassData(name);
			if (data == null)
				throw new ClassNotFoundException();
			c= defineClass(name, data, 0, data.length);
		}
		if (resolve) 
			resolveClass(c);
		return c;
	}
	
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.626 -0500", hash_original_method = "43D8A8DE8192DE4313AA08C95ADD1453", hash_generated_method = "B947DE2DB6BFD8291CD9BD0A27A9973A")
	
private byte[] lookupClassData(String className) throws ClassNotFoundException {
		byte[] data= null;
		for (int i= 0; i < fPathItems.size(); i++) {
			String path= (String) fPathItems.elementAt(i);
			String fileName= className.replace('.', '/')+".class";
			if (isJar(path)) {
				data= loadJarData(path, fileName);
			} else {
				data= loadFileData(path, fileName);
			}
			if (data != null)
				return data;
		}
		throw new ClassNotFoundException(className);
	}
		
	@DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.628 -0500", hash_original_method = "D1958816D560AAF990D492328B2ACA22", hash_generated_method = "D1958816D560AAF990D492328B2ACA22")
	
boolean isJar(String pathEntry) {
		return pathEntry.endsWith(".jar") ||
		       pathEntry.endsWith(".apk") ||
                       pathEntry.endsWith(".zip");
	}

	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.631 -0500", hash_original_method = "4C328FCFB8D8C5A73ACC65BA858A3F7E", hash_generated_method = "9ACACB142F6B85B332882591F1F9143A")
	
private byte[] loadFileData(String path, String fileName) {
		File file= new File(path, fileName);
		if (file.exists()) { 
			return getClassData(file);
		}
		return null;
	}
	
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.633 -0500", hash_original_method = "6E324290C9C24F4E29DE2D96FABDFD83", hash_generated_method = "A9D1360D340645F93F99199E138A9A07")
	
private byte[] getClassData(File f) {
		try {
			FileInputStream stream= new FileInputStream(f);
			ByteArrayOutputStream out= new ByteArrayOutputStream(1000);
			byte[] b= new byte[1000];
			int n;
			while ((n= stream.read(b)) != -1) 
				out.write(b, 0, n);
			stream.close();
			out.close();
			return out.toByteArray();

		} catch (IOException e) {
		}
		return null;
	}

	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.636 -0500", hash_original_method = "C76B1C7062D123058031C76531140DC1", hash_generated_method = "E3CAD9BDCC835A182BA210449D360515")
	
private byte[] loadJarData(String path, String fileName) {
		ZipFile zipFile= null;
		InputStream stream= null;
		File archive= new File(path);
		if (!archive.exists())
			return null;
		try {
			zipFile= new ZipFile(archive);
		} catch(IOException io) {
			return null;
		}
		ZipEntry entry= zipFile.getEntry(fileName);
		if (entry == null)
			return null;
		int size= (int) entry.getSize();
		try {
			stream= zipFile.getInputStream(entry);
			byte[] data= new byte[size];
			int pos= 0;
			while (pos < size) {
				int n= stream.read(data, pos, data.length - pos);
				pos += n;
			}
			zipFile.close();
			return data;
		} catch (IOException e) {
		} finally {
			try {
				if (stream != null)
					stream.close();
			} catch (IOException e) {
			}
		}
		return null;
	}
	
	@DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:43.638 -0500", hash_original_method = "1F7171E3DD1B25E20F5BDFEA6D44B6AF", hash_generated_method = "29BCDC7154887B581023DD54DB552C3C")
	
private void readExcludedPackages() {		
		fExcluded= new Vector(10);
		for (int i= 0; i < defaultExclusions.length; i++)
			fExcluded.addElement(defaultExclusions[i]);
			
		InputStream is= getClass().getResourceAsStream(EXCLUDED_FILE);
		if (is == null) 
			return;
		Properties p= new Properties();
		try {
			p.load(is);
		}
		catch (IOException e) {
			return;
		} finally {
			try {
				is.close();
			} catch (IOException e) {
			}
		}
		for (Enumeration e= p.propertyNames(); e.hasMoreElements(); ) {
			String key= (String)e.nextElement();
			if (key.startsWith("excluded.")) {
				String path= p.getProperty(key);
				path= path.trim();
				if (path.endsWith("*"))
					path= path.substring(0, path.length()-1);
				if (path.length() > 0) 
					fExcluded.addElement(path);				
			}
		}
	}
}

