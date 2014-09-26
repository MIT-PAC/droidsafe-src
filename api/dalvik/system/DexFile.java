package dalvik.system;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

import droidsafe.helpers.DSUtils;

public final class DexFile {

    /**
     * Open a DEX file, specifying the file in which the optimized DEX
     * data should be written.  If the optimized form exists and appears
     * to be current, it will be used; if not, the VM will attempt to
     * regenerate it.
     *
     * This is intended for use by applications that wish to download
     * and execute DEX files outside the usual application installation
     * mechanism.  This function should not be called directly by an
     * application; instead, use a class loader such as
     * dalvik.system.DexClassLoader.
     *
     * @param sourcePathName
     *  Jar or APK file with "classes.dex".  (May expand this to include
     *  "raw DEX" in the future.)
     * @param outputPathName
     *  File that will hold the optimized form of the DEX data.
     * @param flags
     *  Enable optional features.  (Currently none defined.)
     * @return
     *  A new or previously-opened DexFile.
     * @throws IOException
     *  If unable to open the source or output file.
     */
    @DSComment("Dalvik class method")
    @DSBan(DSCat.DALVIK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.716 -0500", hash_original_method = "1EDCA09AD4C3913C3E18CC3064C22C6C", hash_generated_method = "BEC005FC12BA681CE5CAC96FCB71CC2A")
    
static public DexFile loadDex(String sourcePathName, String outputPathName,
        int flags) throws IOException {

        /*
         * TODO: we may want to cache previously-opened DexFile objects.
         * The cache would be synchronized with close().  This would help
         * us avoid mapping the same DEX more than once when an app
         * decided to open it multiple times.  In practice this may not
         * be a real issue.
         */
        return new DexFile(sourcePathName, outputPathName, flags);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Class defineClass(String name, ClassLoader loader, int cookie) {
    	Class clazz = new Class();
    	clazz.addTaint(name.getTaint());
    	clazz.addTaint(loader.getTaint());
    	clazz.addTaint(cookie);
    	return clazz;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String[] getClassNameList(int cookie) {
    	String[] s = new String[0];
    	s.addTaint(cookie);
    	return s;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int openDexFile(String sourceName, String outputName,
        int flags) throws IOException {
        outputName.addTaint(flags);
        outputName.addTaint(sourceName.getTaint());
        return (sourceName.getTaintInt() + flags + outputName.getTaintInt());
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int openDexFile(byte[] fileContents) {
        return fileContents.getTaintInt() + fileContents[0];
    }
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void closeDexFile(int cookie) {
    }
    
    public static boolean isDexOptNeeded(String fileName) throws FileNotFoundException, IOException {
        return (fileName.getTaintBoolean());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.701 -0500", hash_original_field = "17C86C09C6C4D7B6E875B4525EC536C5", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.703 -0500", hash_original_field = "EDC6D2A1228FB58172CCF792832A2DF2", hash_generated_field = "AAA2A753F4CC89AA48A7F98FEF3601A3")

    private  String mFileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.706 -0500", hash_original_field = "759D7885648499D4F341C13F7C4AA861", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();

    /**
     * Opens a DEX file from a given File object. This will usually be a ZIP/JAR
     * file with a "classes.dex" inside.
     *
     * The VM will generate the name of the corresponding file in
     * /data/dalvik-cache and open it, possibly creating or updating
     * it first if system permissions allow.  Don't pass in the name of
     * a file in /data/dalvik-cache, as the named file is expected to be
     * in its original (pre-dexopt) state.
     *
     * @param file
     *            the File object referencing the actual DEX file
     *
     * @throws IOException
     *             if an I/O error occurs, such as the file not being found or
     *             access rights missing for opening it
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.708 -0500", hash_original_method = "DB9E956B9DDA3EEC264D03CBFDEFBF6F", hash_generated_method = "938FC048B96D342FBB4D144DA3FC1D5B")
    
public DexFile(File file) throws IOException {
        this(file.getPath());
    }

    /**
     * Opens a DEX file from a given filename. This will usually be a ZIP/JAR
     * file with a "classes.dex" inside.
     *
     * The VM will generate the name of the corresponding file in
     * /data/dalvik-cache and open it, possibly creating or updating
     * it first if system permissions allow.  Don't pass in the name of
     * a file in /data/dalvik-cache, as the named file is expected to be
     * in its original (pre-dexopt) state.
     *
     * @param fileName
     *            the filename of the DEX file
     *
     * @throws IOException
     *             if an I/O error occurs, such as the file not being found or
     *             access rights missing for opening it
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.711 -0500", hash_original_method = "2B4E18996A051A13BE51394FD13F0A3C", hash_generated_method = "B9625D27D362B6F4B8A75F93914A42B5")
    
public DexFile(String fileName) throws IOException {
        mCookie = openDexFile(fileName, null, 0);
        mFileName = fileName;
        guard.open("close");
        //System.out.println("DEX FILE cookie is " + mCookie);
    }

    /**
     * Opens a DEX file from a given filename, using a specified file
     * to hold the optimized data.
     *
     * @param sourceName
     *  Jar or APK file with "classes.dex".
     * @param outputName
     *  File that will hold the optimized form of the DEX data.
     * @param flags
     *  Enable optional features.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.714 -0500", hash_original_method = "A9D59C5CAA6AEFC931B2439A85EC8214", hash_generated_method = "EA80EA3709A8C01338A8B5642E17C8F1")
    
private DexFile(String sourceName, String outputName, int flags) throws IOException {
        mCookie = openDexFile(sourceName, outputName, flags);
        mFileName = sourceName;
        guard.open("close");
        //System.out.println("DEX FILE cookie is " + mCookie);
    }

    /**
     * Gets the name of the (already opened) DEX file.
     *
     * @return the file name
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.718 -0500", hash_original_method = "DFE26EB6CF2622DAE30C5BD1FDBCFEE9", hash_generated_method = "77F463454BDEE4385EB69987BB58F477")
    
public String getName() {
        return mFileName;
    }

    /**
     * Closes the DEX file.
     * <p>
     * This may not be able to release any resources. If classes from this
     * DEX file are still resident, the DEX file can't be unmapped.
     *
     * @throws IOException
     *             if an I/O error occurs during closing the file, which
     *             normally should not happen
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.721 -0500", hash_original_method = "9CC3987533495060FC4949865817E44B", hash_generated_method = "F9F3B1574AD7419198B3D9C8BFB5E4E3")
    
public void close() throws IOException {
        guard.close();
        closeDexFile(mCookie);
        mCookie = 0;
    }

    /**
     * Loads a class. Returns the class on success, or a {@code null} reference
     * on failure.
     * <p>
     * If you are not calling this from a class loader, this is most likely not
     * going to do what you want. Use {@link Class#forName(String)} instead.
     * <p>
     * The method does not throw {@link ClassNotFoundException} if the class
     * isn't found because it isn't reasonable to throw exceptions wildly every
     * time a class is not found in the first DEX file we look at.
     *
     * @param name
     *            the class name, which should look like "java/lang/String"
     *
     * @param loader
     *            the class loader that tries to load the class (in most cases
     *            the caller of the method
     *
     * @return the {@link Class} object representing the class, or {@code null}
     *         if the class cannot be loaded
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.723 -0500", hash_original_method = "292E8055A30ED290AAAD3D0A5C7397D8", hash_generated_method = "EDAE0AB23FAABA755904A5F8071902BF")
    
public Class loadClass(String name, ClassLoader loader) {
        String slashName = name.replace('.', '/');
        return loadClassBinaryName(slashName, loader);
    }

    /**
     * See {@link #loadClass(String, ClassLoader)}.
     *
     * This takes a "binary" class name to better match ClassLoader semantics.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.726 -0500", hash_original_method = "66D81951CD1FBB575468E800A0D13125", hash_generated_method = "826103FA7E3545049DD5AAEC78CC9DCB")
    
public Class loadClassBinaryName(String name, ClassLoader loader) {
        return defineClass(name, loader, mCookie);
    }

    /**
     * Enumerate the names of the classes in this DEX file.
     *
     * @return an enumeration of names of classes contained in the DEX file, in
     *         the usual internal form (like "java/lang/String").
     */
    @DSComment("Dalvik class method")
    @DSBan(DSCat.DALVIK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.732 -0500", hash_original_method = "51AB769B18373F25E42ACAB5FC64B8CC", hash_generated_method = "2F173EE517FB3C5BC94167DFC70EE753")
    
public Enumeration<String> entries() {
        return new DFEnum(this);
    }

    /**
     * Called when the class is finalized. Makes sure the DEX file is closed.
     *
     * @throws IOException
     *             if an I/O error occurs during closing the file, which
     *             normally should not happen
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.754 -0500", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "F0F8D8EC0C5D8FA9E7582C7E60A1D793")
    
@Override protected void finalize() throws Throwable {
        try {
            if (guard != null) {
                guard.warnIfOpen();
            }
            close();
        } finally {
            super.finalize();
        }
    }
    
    private class DFEnum implements Enumeration<String> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.735 -0500", hash_original_field = "3FE793BBC68255EAC5B3588E7DE2E2C6", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.737 -0500", hash_original_field = "9A1C4167366DE08F4CC03A915A76FD69", hash_generated_field = "4537F844CA5ED71629B9545AE9D715A7")

        private String[] mNameList;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.741 -0500", hash_original_method = "4F1898FBD60AA29C9B2370CB647FB74F", hash_generated_method = "4F1898FBD60AA29C9B2370CB647FB74F")
        
DFEnum(DexFile df) {
            mIndex = 0;
            mNameList = getClassNameList(mCookie);
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.743 -0500", hash_original_method = "44B49EF070D2DA767A519B4A12A72A0B", hash_generated_method = "0BF7BA029BD9BF7799E883CC6E75EEEB")
        
public boolean hasMoreElements() {
            return (mIndex < mNameList.length);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:39.745 -0500", hash_original_method = "EDE97A24B23321A2938B638C5AA975A1", hash_generated_method = "8E0C899CEA38D57C1F891DBDE1E083E0")
        
public String nextElement() {
            return mNameList[mIndex++];
        }
        
    }
    
}

