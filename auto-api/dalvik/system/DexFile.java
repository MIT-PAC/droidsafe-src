package dalvik.system;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

public final class DexFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.649 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.649 -0400", hash_original_field = "65245EC8B4F9A383A7D88CBCE0DCE936", hash_generated_field = "AAA2A753F4CC89AA48A7F98FEF3601A3")

    private String mFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.649 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.649 -0400", hash_original_method = "DB9E956B9DDA3EEC264D03CBFDEFBF6F", hash_generated_method = "9E460D61C27B487B20C9A4F9A7002E15")
    public  DexFile(File file) throws IOException {
        this(file.getPath());
        addTaint(file.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.649 -0400", hash_original_method = "2B4E18996A051A13BE51394FD13F0A3C", hash_generated_method = "F42425DD98401A7DAF698362F1153DB2")
    public  DexFile(String fileName) throws IOException {
        mCookie = openDexFile(fileName, null, 0);
        mFileName = fileName;
        guard.open("close");
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.649 -0400", hash_original_method = "A9D59C5CAA6AEFC931B2439A85EC8214", hash_generated_method = "8D2E1506C95983BAF3F0866420E60844")
    private  DexFile(String sourceName, String outputName, int flags) throws IOException {
        mCookie = openDexFile(sourceName, outputName, flags);
        mFileName = sourceName;
        guard.open("close");
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    static public DexFile loadDex(String sourcePathName, String outputPathName,
        int flags) throws IOException {
        return new DexFile(sourcePathName, outputPathName, flags);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.650 -0400", hash_original_method = "DFE26EB6CF2622DAE30C5BD1FDBCFEE9", hash_generated_method = "CD4398CF109B4EAD6BC5AAFCFA391918")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_181510391 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_181510391 = mFileName;
        varB4EAC82CA7396A68D541C85D26508E83_181510391.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_181510391;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.650 -0400", hash_original_method = "9CC3987533495060FC4949865817E44B", hash_generated_method = "E86A97E31ACA959189568D3FF85B193D")
    public void close() throws IOException {
        guard.close();
        closeDexFile(mCookie);
        mCookie = 0;
        
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.651 -0400", hash_original_method = "292E8055A30ED290AAAD3D0A5C7397D8", hash_generated_method = "724610FE5364D69B6E8E57A4F649E645")
    public Class loadClass(String name, ClassLoader loader) {
        Class varB4EAC82CA7396A68D541C85D26508E83_1827955259 = null; 
        String slashName = name.replace('.', '/');
        varB4EAC82CA7396A68D541C85D26508E83_1827955259 = loadClassBinaryName(slashName, loader);
        addTaint(name.getTaint());
        addTaint(loader.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1827955259.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1827955259;
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.651 -0400", hash_original_method = "66D81951CD1FBB575468E800A0D13125", hash_generated_method = "EFFED9465789BB2ED3870D97E83E0FF9")
    public Class loadClassBinaryName(String name, ClassLoader loader) {
    	
        addTaint(name.getTaint());
        addTaint(loader.getTaint());
        Class newClass = (Class)new Object();
        addTaint(newClass.getTaint());
        return newClass;
        
        
        
        
    }

    
    

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.652 -0400", hash_original_method = "51AB769B18373F25E42ACAB5FC64B8CC", hash_generated_method = "38D5B706B89751CC14553B038B813969")
    public Enumeration<String> entries() {
        Enumeration<String> varB4EAC82CA7396A68D541C85D26508E83_366161473 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_366161473 = new DFEnum(this);
        varB4EAC82CA7396A68D541C85D26508E83_366161473.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_366161473;
        
        
    }

    
    @DSModeled(DSC.BAN)
    private static String[] getClassNameList(int cookie) {
    	String[] s = new String[0];
    	s.addTaint(cookie);
    	return s;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.652 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            {
                guard.warnIfOpen();
            } 
            close();
        } 
        finally 
        {
            super.finalize();
        } 
        
        
            
                
            
            
        
            
        
    }

    
    @DSModeled(DSC.BAN)
    private static int openDexFile(String sourceName, String outputName,
        int flags) throws IOException {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623029097 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623029097;
    }

    
    @DSModeled(DSC.BAN)
    private static int openDexFile(byte[] fileContents) {
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747228384 = DSUtils.UNKNOWN_INT;
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1747228384;
    }

    
    @DSModeled(DSC.BAN)
    private static void closeDexFile(int cookie) {
    }

    
    @DSModeled(DSC.BAN)
    public static boolean isDexOptNeeded(String fileName) throws FileNotFoundException, IOException {
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689770446 = DSUtils.UNKNOWN_BOOLEAN;
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_689770446;
    }

    
    private class DFEnum implements Enumeration<String> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.653 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.653 -0400", hash_original_field = "C666A4E3804CDAD10450450904B324CE", hash_generated_field = "4537F844CA5ED71629B9545AE9D715A7")

        private String[] mNameList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.653 -0400", hash_original_method = "4F1898FBD60AA29C9B2370CB647FB74F", hash_generated_method = "9D343B4BFCB6666D20AB83F17E02C5AD")
          DFEnum(DexFile df) {
            mIndex = 0;
            mNameList = getClassNameList(mCookie);
            addTaint(df.getTaint());
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.654 -0400", hash_original_method = "44B49EF070D2DA767A519B4A12A72A0B", hash_generated_method = "2D4929EF1314C00ABCF34ABA6EBCBA6A")
        public boolean hasMoreElements() {
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1554841106 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1554841106;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:35.655 -0400", hash_original_method = "EDE97A24B23321A2938B638C5AA975A1", hash_generated_method = "B2188616125B4E794077892B10B25491")
        public String nextElement() {
            String varB4EAC82CA7396A68D541C85D26508E83_750601599 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_750601599 = mNameList[mIndex++];
            varB4EAC82CA7396A68D541C85D26508E83_750601599.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_750601599;
            
            
        }

        
    }


    
}

