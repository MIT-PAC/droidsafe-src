package dalvik.system;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;

public final class DexFile {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.238 -0400", hash_original_field = "6E854C680205E153D6A9DE7BA337DEAC", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.239 -0400", hash_original_field = "65245EC8B4F9A383A7D88CBCE0DCE936", hash_generated_field = "AAA2A753F4CC89AA48A7F98FEF3601A3")

    private String mFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.242 -0400", hash_original_field = "73ABE739BEC4C3DB38D39FA43D36469F", hash_generated_field = "E7FAF2CA4E8E292A9B5FAAE3D4817EEC")

    private final CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.244 -0400", hash_original_method = "DB9E956B9DDA3EEC264D03CBFDEFBF6F", hash_generated_method = "9E460D61C27B487B20C9A4F9A7002E15")
    public  DexFile(File file) throws IOException {
        this(file.getPath());
        addTaint(file.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.250 -0400", hash_original_method = "2B4E18996A051A13BE51394FD13F0A3C", hash_generated_method = "F42425DD98401A7DAF698362F1153DB2")
    public  DexFile(String fileName) throws IOException {
        mCookie = openDexFile(fileName, null, 0);
        mFileName = fileName;
        guard.open("close");
        // ---------- Original Method ----------
        //mCookie = openDexFile(fileName, null, 0);
        //mFileName = fileName;
        //guard.open("close");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.255 -0400", hash_original_method = "A9D59C5CAA6AEFC931B2439A85EC8214", hash_generated_method = "8D2E1506C95983BAF3F0866420E60844")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.259 -0400", hash_original_method = "DFE26EB6CF2622DAE30C5BD1FDBCFEE9", hash_generated_method = "408A063371426E9FBD55925AF005CFCA")
    public String getName() {
String var034A1EDD43045D5BE42C7869180FB3DC_1476460469 =         mFileName;
        var034A1EDD43045D5BE42C7869180FB3DC_1476460469.addTaint(taint);
        return var034A1EDD43045D5BE42C7869180FB3DC_1476460469;
        // ---------- Original Method ----------
        //return mFileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.263 -0400", hash_original_method = "9CC3987533495060FC4949865817E44B", hash_generated_method = "E86A97E31ACA959189568D3FF85B193D")
    public void close() throws IOException {
        guard.close();
        closeDexFile(mCookie);
        mCookie = 0;
        // ---------- Original Method ----------
        //guard.close();
        //closeDexFile(mCookie);
        //mCookie = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.267 -0400", hash_original_method = "292E8055A30ED290AAAD3D0A5C7397D8", hash_generated_method = "63FF1551CFAC881F60018914B9527432")
    public Class loadClass(String name, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(name.getTaint());
        String slashName = name.replace('.', '/');
Class var08DA4FE666A2269C44F6B8F41F5D219D_1562396323 =         loadClassBinaryName(slashName, loader);
        var08DA4FE666A2269C44F6B8F41F5D219D_1562396323.addTaint(taint);
        return var08DA4FE666A2269C44F6B8F41F5D219D_1562396323;
        // ---------- Original Method ----------
        //String slashName = name.replace('.', '/');
        //return loadClassBinaryName(slashName, loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.274 -0400", hash_original_method = "66D81951CD1FBB575468E800A0D13125", hash_generated_method = "39B06E4D23C8BADEBF5910352644D4AC")
    public Class loadClassBinaryName(String name, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(name.getTaint());
Class varC24D0AC4FF8441C0BBB3D1483BDE602C_551213512 =         defineClass(name, loader, mCookie);
        varC24D0AC4FF8441C0BBB3D1483BDE602C_551213512.addTaint(taint);
        return varC24D0AC4FF8441C0BBB3D1483BDE602C_551213512;
        // ---------- Original Method ----------
        //return defineClass(name, loader, mCookie);
    }

    
    private static Class defineClass(String name, ClassLoader loader, int cookie) {
    	Class clazz = new Class();
    	clazz.addTaint(name.taint);
    	clazz.addTaint(loader.taint);
    	clazz.addTaint(cookie);
    	return clazz;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.285 -0400", hash_original_method = "51AB769B18373F25E42ACAB5FC64B8CC", hash_generated_method = "B8A803CBA84ECE75555427B7976E83BB")
    public Enumeration<String> entries() {
Enumeration<String> varF0AC681DBC38559533F072C2E2850F9B_1589807603 =         new DFEnum(this);
        varF0AC681DBC38559533F072C2E2850F9B_1589807603.addTaint(taint);
        return varF0AC681DBC38559533F072C2E2850F9B_1589807603;
        // ---------- Original Method ----------
        //return new DFEnum(this);
    }

    
    @DSModeled(DSC.BAN)
    private static String[] getClassNameList(int cookie) {
    	String[] s = new String[0];
    	s.addTaint(cookie);
    	return s;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.294 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "271B01A0C286411ADC3A779686EF67E4")
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.312 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "B8B828CADFFAE7A5A771AAB7A1527A20")

        private int mIndex;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.314 -0400", hash_original_field = "C666A4E3804CDAD10450450904B324CE", hash_generated_field = "4537F844CA5ED71629B9545AE9D715A7")

        private String[] mNameList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.318 -0400", hash_original_method = "4F1898FBD60AA29C9B2370CB647FB74F", hash_generated_method = "035F17F3606497FC41CDF82ED9451BA6")
          DFEnum(DexFile df) {
            addTaint(df.getTaint());
            mIndex = 0;
            mNameList = getClassNameList(mCookie);
            // ---------- Original Method ----------
            //mIndex = 0;
            //mNameList = getClassNameList(mCookie);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.326 -0400", hash_original_method = "44B49EF070D2DA767A519B4A12A72A0B", hash_generated_method = "4B86A5E010B6DFFDD93BA82469B96668")
        public boolean hasMoreElements() {
            boolean varFFC6890377154B35FEEF0342CDB405EB_1302607442 = ((mIndex < mNameList.length));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1841208740 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1841208740;
            // ---------- Original Method ----------
            //return (mIndex < mNameList.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:19.331 -0400", hash_original_method = "EDE97A24B23321A2938B638C5AA975A1", hash_generated_method = "03EE664D5FCD2089D578F2ED25ACC1D8")
        public String nextElement() {
String varB7F2210AFBB3BA6AEB1F1DD70313C1DA_679087768 =             mNameList[mIndex++];
            varB7F2210AFBB3BA6AEB1F1DD70313C1DA_679087768.addTaint(taint);
            return varB7F2210AFBB3BA6AEB1F1DD70313C1DA_679087768;
            // ---------- Original Method ----------
            //return mNameList[mIndex++];
        }

        
    }


    
}

