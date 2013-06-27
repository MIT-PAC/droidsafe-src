package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

public final class DexFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.369 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.369 -0400", hash_original_field = "65245EC8B4F9A383A7D88CBCE0DCE936", hash_generated_field = "AAA2A753F4CC89AA48A7F98FEF3601A3")

    private String mFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.369 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "2D38C9B39338C5B15F94E3339CE63B3F")

    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.369 -0400", hash_original_method = "DB9E956B9DDA3EEC264D03CBFDEFBF6F", hash_generated_method = "9E460D61C27B487B20C9A4F9A7002E15")
    public  DexFile(File file) throws IOException {
        this(file.getPath());
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.370 -0400", hash_original_method = "2B4E18996A051A13BE51394FD13F0A3C", hash_generated_method = "F42425DD98401A7DAF698362F1153DB2")
    public  DexFile(String fileName) throws IOException {
        mCookie = openDexFile(fileName, null, 0);
        mFileName = fileName;
        guard.open("close");
        // ---------- Original Method ----------
        //mCookie = openDexFile(fileName, null, 0);
        //mFileName = fileName;
        //guard.open("close");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.371 -0400", hash_original_method = "A9D59C5CAA6AEFC931B2439A85EC8214", hash_generated_method = "8D2E1506C95983BAF3F0866420E60844")
    private  DexFile(String sourceName, String outputName, int flags) throws IOException {
        mCookie = openDexFile(sourceName, outputName, flags);
        mFileName = sourceName;
        guard.open("close");
        // ---------- Original Method ----------
        //mCookie = openDexFile(sourceName, outputName, flags);
        //mFileName = sourceName;
        //guard.open("close");
    }

    
        static public DexFile loadDex(String sourcePathName, String outputPathName,
        int flags) throws IOException {
        return new DexFile(sourcePathName, outputPathName, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.371 -0400", hash_original_method = "DFE26EB6CF2622DAE30C5BD1FDBCFEE9", hash_generated_method = "387944A4ECD16E30DB0DCF484EB2FDAF")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_362212143 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_362212143 = mFileName;
        varB4EAC82CA7396A68D541C85D26508E83_362212143.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_362212143;
        // ---------- Original Method ----------
        //return mFileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.371 -0400", hash_original_method = "9CC3987533495060FC4949865817E44B", hash_generated_method = "E86A97E31ACA959189568D3FF85B193D")
    public void close() throws IOException {
        guard.close();
        closeDexFile(mCookie);
        mCookie = 0;
        // ---------- Original Method ----------
        //guard.close();
        //closeDexFile(mCookie);
        //mCookie = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.381 -0400", hash_original_method = "292E8055A30ED290AAAD3D0A5C7397D8", hash_generated_method = "A7F4D170CC773BBB47C897C66C63ABC3")
    public Class loadClass(String name, ClassLoader loader) {
        Class varB4EAC82CA7396A68D541C85D26508E83_1268464772 = null; //Variable for return #1
        String slashName;
        slashName = name.replace('.', '/');
        varB4EAC82CA7396A68D541C85D26508E83_1268464772 = loadClassBinaryName(slashName, loader);
        addTaint(name.getTaint());
        addTaint(loader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1268464772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1268464772;
        // ---------- Original Method ----------
        //String slashName = name.replace('.', '/');
        //return loadClassBinaryName(slashName, loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.382 -0400", hash_original_method = "66D81951CD1FBB575468E800A0D13125", hash_generated_method = "1BF368C8FE26E799446BC062A1685516")
    public Class loadClassBinaryName(String name, ClassLoader loader) {
        Class varB4EAC82CA7396A68D541C85D26508E83_314421751 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_314421751 = defineClass(name, loader, mCookie);
        addTaint(name.getTaint());
        addTaint(loader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_314421751.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_314421751;
        // ---------- Original Method ----------
        //return defineClass(name, loader, mCookie);
    }

    
        private static Class defineClass(String name, ClassLoader loader, int cookie) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.383 -0400", hash_original_method = "51AB769B18373F25E42ACAB5FC64B8CC", hash_generated_method = "273C0E2E5DCE140CA0E9215EC82E9D53")
    public Enumeration<String> entries() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_871819181 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_871819181 = new DFEnum(this);
        varB4EAC82CA7396A68D541C85D26508E83_871819181.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_871819181;
        // ---------- Original Method ----------
        //return new DFEnum(this);
    }

    
        private static String[] getClassNameList(int cookie) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.384 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                guard.warnIfOpen();
            } //End block
            close();
        } //End block
        finally 
        {
            super.finalize();
        } //End block
        // ---------- Original Method ----------
        //try {
            //if (guard != null) {
                //guard.warnIfOpen();
            //}
            //close();
        //} finally {
            //super.finalize();
        //}
    }

    
        private static int openDexFile(String sourceName, String outputName,
        int flags) throws IOException {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static int openDexFile(byte[] fileContents) {
        return DSUtils.UNKNOWN_INT;
    }

    
        private static void closeDexFile(int cookie) {
    }

    
        public static boolean isDexOptNeeded(String fileName) throws FileNotFoundException, IOException {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
    private class DFEnum implements Enumeration<String> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.385 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.385 -0400", hash_original_field = "C666A4E3804CDAD10450450904B324CE", hash_generated_field = "4537F844CA5ED71629B9545AE9D715A7")

        private String[] mNameList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.385 -0400", hash_original_method = "4F1898FBD60AA29C9B2370CB647FB74F", hash_generated_method = "9D343B4BFCB6666D20AB83F17E02C5AD")
          DFEnum(DexFile df) {
            mIndex = 0;
            mNameList = getClassNameList(mCookie);
            addTaint(df.getTaint());
            // ---------- Original Method ----------
            //mIndex = 0;
            //mNameList = getClassNameList(mCookie);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.404 -0400", hash_original_method = "44B49EF070D2DA767A519B4A12A72A0B", hash_generated_method = "1EA57389AB554EB28CDE098974FC3B59")
        public boolean hasMoreElements() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928557646 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928557646;
            // ---------- Original Method ----------
            //return (mIndex < mNameList.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:27.405 -0400", hash_original_method = "EDE97A24B23321A2938B638C5AA975A1", hash_generated_method = "EC5AC5055CC86998B2BE68FDCA7A0458")
        public String nextElement() {
            String varB4EAC82CA7396A68D541C85D26508E83_986229850 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_986229850 = mNameList[mIndex++];
            varB4EAC82CA7396A68D541C85D26508E83_986229850.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_986229850;
            // ---------- Original Method ----------
            //return mNameList[mIndex++];
        }

        
    }


    
}

