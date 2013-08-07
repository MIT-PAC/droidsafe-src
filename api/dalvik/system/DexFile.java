package dalvik.system;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;





import droidsafe.helpers.DSUtils;

public final class DexFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.723 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.723 -0400", hash_original_field = "65245EC8B4F9A383A7D88CBCE0DCE936", hash_generated_field = "AAA2A753F4CC89AA48A7F98FEF3601A3")

    private String mFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.723 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.723 -0400", hash_original_method = "DB9E956B9DDA3EEC264D03CBFDEFBF6F", hash_generated_method = "9E460D61C27B487B20C9A4F9A7002E15")
    public  DexFile(File file) throws IOException {
        this(file.getPath());
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.724 -0400", hash_original_method = "2B4E18996A051A13BE51394FD13F0A3C", hash_generated_method = "F42425DD98401A7DAF698362F1153DB2")
    public  DexFile(String fileName) throws IOException {
        mCookie = openDexFile(fileName, null, 0);
        mFileName = fileName;
        guard.open("close");
        // ---------- Original Method ----------
        //mCookie = openDexFile(fileName, null, 0);
        //mFileName = fileName;
        //guard.open("close");
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.724 -0400", hash_original_method = "A9D59C5CAA6AEFC931B2439A85EC8214", hash_generated_method = "8D2E1506C95983BAF3F0866420E60844")
    private  DexFile(String sourceName, String outputName, int flags) throws IOException {
        mCookie = openDexFile(sourceName, outputName, flags);
        mFileName = sourceName;
        guard.open("close");
        // ---------- Original Method ----------
        //mCookie = openDexFile(sourceName, outputName, flags);
        //mFileName = sourceName;
        //guard.open("close");
    }

    
    @DSModeled(DSC.BAN)
    static public DexFile loadDex(String sourcePathName, String outputPathName,
        int flags) throws IOException {
        return new DexFile(sourcePathName, outputPathName, flags);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.725 -0400", hash_original_method = "DFE26EB6CF2622DAE30C5BD1FDBCFEE9", hash_generated_method = "C8B0B7292F4C3DB22AB87147151B5A99")
    public String getName() {
String var034A1EDD43045D5BE42C7869180FB3DC_82685153 =         mFileName;
        var034A1EDD43045D5BE42C7869180FB3DC_82685153.addTaint(taint);
        return var034A1EDD43045D5BE42C7869180FB3DC_82685153;
        // ---------- Original Method ----------
        //return mFileName;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.725 -0400", hash_original_method = "9CC3987533495060FC4949865817E44B", hash_generated_method = "E86A97E31ACA959189568D3FF85B193D")
    public void close() throws IOException {
        guard.close();
        closeDexFile(mCookie);
        mCookie = 0;
        // ---------- Original Method ----------
        //guard.close();
        //closeDexFile(mCookie);
        //mCookie = 0;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.725 -0400", hash_original_method = "292E8055A30ED290AAAD3D0A5C7397D8", hash_generated_method = "D7176AB29E4F8202286EF1C77A7ECAE0")
    public Class loadClass(String name, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(name.getTaint());
        String slashName = name.replace('.', '/');
Class var08DA4FE666A2269C44F6B8F41F5D219D_56551441 =         loadClassBinaryName(slashName, loader);
        var08DA4FE666A2269C44F6B8F41F5D219D_56551441.addTaint(taint);
        return var08DA4FE666A2269C44F6B8F41F5D219D_56551441;
        // ---------- Original Method ----------
        //String slashName = name.replace('.', '/');
        //return loadClassBinaryName(slashName, loader);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.725 -0400", hash_original_method = "66D81951CD1FBB575468E800A0D13125", hash_generated_method = "279C5DFE98E42A9F5213D10B72D8DCE3")
    public Class loadClassBinaryName(String name, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(name.getTaint());
Class varC24D0AC4FF8441C0BBB3D1483BDE602C_1783661781 =         defineClass(name, loader, mCookie);
        varC24D0AC4FF8441C0BBB3D1483BDE602C_1783661781.addTaint(taint);
        return varC24D0AC4FF8441C0BBB3D1483BDE602C_1783661781;
        // ---------- Original Method ----------
        //return defineClass(name, loader, mCookie);
    }

    
    @DSModeled(DSC.BAN)
    private static Class defineClass(String name, ClassLoader loader, int cookie) {
    	Class clazz = new Class();
    	clazz.addTaint(name.taint);
    	clazz.addTaint(loader.taint);
    	clazz.addTaint(cookie);
    	return clazz;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.726 -0400", hash_original_method = "51AB769B18373F25E42ACAB5FC64B8CC", hash_generated_method = "9C6A55B14DB0D4AECC5F236B4A83D0D5")
    public Enumeration<String> entries() {
Enumeration<String> varF0AC681DBC38559533F072C2E2850F9B_1493649008 =         new DFEnum(this);
        varF0AC681DBC38559533F072C2E2850F9B_1493649008.addTaint(taint);
        return varF0AC681DBC38559533F072C2E2850F9B_1493649008;
        // ---------- Original Method ----------
        //return new DFEnum(this);
    }

    
    @DSModeled(DSC.BAN)
    private static String[] getClassNameList(int cookie) {
    	String[] s = new String[0];
    	s.addTaint(cookie);
    	return s;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.726 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "271B01A0C286411ADC3A779686EF67E4")
    @Override
    protected void finalize() throws Throwable {
        try 
        {
            if(guard != null)            
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.727 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.727 -0400", hash_original_field = "C666A4E3804CDAD10450450904B324CE", hash_generated_field = "4537F844CA5ED71629B9545AE9D715A7")

        private String[] mNameList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.727 -0400", hash_original_method = "4F1898FBD60AA29C9B2370CB647FB74F", hash_generated_method = "035F17F3606497FC41CDF82ED9451BA6")
          DFEnum(DexFile df) {
            addTaint(df.getTaint());
            mIndex = 0;
            mNameList = getClassNameList(mCookie);
            // ---------- Original Method ----------
            //mIndex = 0;
            //mNameList = getClassNameList(mCookie);
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.727 -0400", hash_original_method = "44B49EF070D2DA767A519B4A12A72A0B", hash_generated_method = "D16604AB37218C120CF14382CA5E5421")
        public boolean hasMoreElements() {
            boolean varFFC6890377154B35FEEF0342CDB405EB_81111190 = ((mIndex < mNameList.length));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1680554303 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1680554303;
            // ---------- Original Method ----------
            //return (mIndex < mNameList.length);
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:29.727 -0400", hash_original_method = "EDE97A24B23321A2938B638C5AA975A1", hash_generated_method = "CBF4B89E9458C40C33D36F967AB6D0B4")
        public String nextElement() {
String varB7F2210AFBB3BA6AEB1F1DD70313C1DA_198110323 =             mNameList[mIndex++];
            varB7F2210AFBB3BA6AEB1F1DD70313C1DA_198110323.addTaint(taint);
            return varB7F2210AFBB3BA6AEB1F1DD70313C1DA_198110323;
            // ---------- Original Method ----------
            //return mNameList[mIndex++];
        }

        
    }


    
}

