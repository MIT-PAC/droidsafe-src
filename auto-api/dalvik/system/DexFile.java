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
    private int mCookie;
    private String mFileName;
    private CloseGuard guard = CloseGuard.get();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.218 -0400", hash_original_method = "DB9E956B9DDA3EEC264D03CBFDEFBF6F", hash_generated_method = "E63CB70F56B9E609CED7211D640D88E3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DexFile(File file) throws IOException {
        this(file.getPath());
        dsTaint.addTaint(file.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.218 -0400", hash_original_method = "2B4E18996A051A13BE51394FD13F0A3C", hash_generated_method = "5F1735329DFA34DBAD9C4933451AD11B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public DexFile(String fileName) throws IOException {
        dsTaint.addTaint(fileName);
        mCookie = openDexFile(fileName, null, 0);
        guard.open("close");
        // ---------- Original Method ----------
        //mCookie = openDexFile(fileName, null, 0);
        //mFileName = fileName;
        //guard.open("close");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.218 -0400", hash_original_method = "A9D59C5CAA6AEFC931B2439A85EC8214", hash_generated_method = "E3DA5515A9E0FFAF53819CD48E7337C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private DexFile(String sourceName, String outputName, int flags) throws IOException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(outputName);
        dsTaint.addTaint(sourceName);
        mCookie = openDexFile(sourceName, outputName, flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.219 -0400", hash_original_method = "DFE26EB6CF2622DAE30C5BD1FDBCFEE9", hash_generated_method = "1F71D3544D49FCD9C41791A6CA7BD384")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mFileName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.219 -0400", hash_original_method = "9CC3987533495060FC4949865817E44B", hash_generated_method = "E86A97E31ACA959189568D3FF85B193D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        guard.close();
        closeDexFile(mCookie);
        mCookie = 0;
        // ---------- Original Method ----------
        //guard.close();
        //closeDexFile(mCookie);
        //mCookie = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.219 -0400", hash_original_method = "292E8055A30ED290AAAD3D0A5C7397D8", hash_generated_method = "138B13580BC57B1C421A2ADED0E75533")
    @DSModeled(DSC.BAN)
    public Class loadClass(String name, ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(name);
        String slashName;
        slashName = name.replace('.', '/');
        Class varCFDE9E893B80FAC7A23822D6809E5FE9_1667738054 = (loadClassBinaryName(slashName, loader));
        return (Class)dsTaint.getTaint();
        // ---------- Original Method ----------
        //String slashName = name.replace('.', '/');
        //return loadClassBinaryName(slashName, loader);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.219 -0400", hash_original_method = "66D81951CD1FBB575468E800A0D13125", hash_generated_method = "FAB89F52C50D78AE87971E84B05B6D2B")
    @DSModeled(DSC.BAN)
    public Class loadClassBinaryName(String name, ClassLoader loader) {
        dsTaint.addTaint(loader.dsTaint);
        dsTaint.addTaint(name);
        Class var7DEFB04DDE6C70E16A5FDBF6FD094742_464362842 = (defineClass(name, loader, mCookie));
        return (Class)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return defineClass(name, loader, mCookie);
    }

    
        private static Class defineClass(String name, ClassLoader loader, int cookie) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.220 -0400", hash_original_method = "51AB769B18373F25E42ACAB5FC64B8CC", hash_generated_method = "CDFCAD8875EFB868294A4746896FB154")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<String> entries() {
        Enumeration<String> varFE58A56A7792C37220E2051BDF959CD4_1509170658 = (new DFEnum(this));
        return (Enumeration<String>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new DFEnum(this);
    }

    
        private static String[] getClassNameList(int cookie) {
        String[] retVal = {DSUtils.UNKNOWN_STRING};
        return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.220 -0400", hash_original_method = "7D87091EC31B409C33B787AE3F2DC647", hash_generated_method = "9FC9D50BDD14E42CF33F4D9E8C015023")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        private int mIndex;
        private String[] mNameList;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.221 -0400", hash_original_method = "4F1898FBD60AA29C9B2370CB647FB74F", hash_generated_method = "F6A21F1BA5FDC341268D6B3F9C171E11")
        //DSFIXME:  CODE0002: Requires DSC value to be set
         DFEnum(DexFile df) {
            dsTaint.addTaint(df.dsTaint);
            mIndex = 0;
            mNameList = getClassNameList(mCookie);
            // ---------- Original Method ----------
            //mIndex = 0;
            //mNameList = getClassNameList(mCookie);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.221 -0400", hash_original_method = "44B49EF070D2DA767A519B4A12A72A0B", hash_generated_method = "B2C7DBCBFA1DEC4A699C610BA10955D3")
        @DSModeled(DSC.SAFE)
        public boolean hasMoreElements() {
            return dsTaint.getTaintBoolean();
            // ---------- Original Method ----------
            //return (mIndex < mNameList.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.221 -0400", hash_original_method = "EDE97A24B23321A2938B638C5AA975A1", hash_generated_method = "3CDC20B6BD11F60D9203169612D146D0")
        @DSModeled(DSC.SAFE)
        public String nextElement() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return mNameList[mIndex++];
        }

        
    }


    
}

