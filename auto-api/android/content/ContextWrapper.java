package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ContextWrapper extends Context {
    Context mBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.039 -0400", hash_original_method = "10030D2DB2A8F36EE12AB3354BCBF9E2", hash_generated_method = "BFFFA1A9B03B23F66FE079970D7E5C2B")
    @DSModeled(DSC.SAFE)
    public ContextWrapper(Context base) {
        dsTaint.addTaint(base.dsTaint);
        // ---------- Original Method ----------
        //mBase = base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.039 -0400", hash_original_method = "C93782FE26B0F4F6F9B761D03AD74E79", hash_generated_method = "CF5F32EFCEAEF9C5FD546566A5707DAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void attachBaseContext(Context base) {
        dsTaint.addTaint(base.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Base context already set");
        } //End block
        // ---------- Original Method ----------
        //if (mBase != null) {
            //throw new IllegalStateException("Base context already set");
        //}
        //mBase = base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.040 -0400", hash_original_method = "348D9A1AC27363C49C4D9EF878F36A33", hash_generated_method = "7B1B566B35E1E727F42BBCBF2852D76A")
    @DSModeled(DSC.SAFE)
    public Context getBaseContext() {
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.040 -0400", hash_original_method = "207324BD2179C2BB1CD4C22794703A9D", hash_generated_method = "8066059F01F3DFC6443909C843872C63")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public AssetManager getAssets() {
        AssetManager var4F205B831168D2859D757D1E92DDBB14_239108999 = (mBase.getAssets());
        return (AssetManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.041 -0400", hash_original_method = "47F2A94B0203C279563273E1E0895D4D", hash_generated_method = "949932D7205CB19BBB7777F3960D3B92")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Resources getResources() {
        Resources var60B9A655590DD2DA32D8FC5248D54CA3_363693245 = (mBase.getResources());
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getResources();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.041 -0400", hash_original_method = "D7F633AF602934F61160FEA442625239", hash_generated_method = "5F56AA97159F09E5C95357210FC62D00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public PackageManager getPackageManager() {
        PackageManager varCD60AACF723DE7FEF0F28834B33D3788_434288881 = (mBase.getPackageManager());
        return (PackageManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getPackageManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.050 -0400", hash_original_method = "8EDC66E2D77BCDC119853EA41EA3296B", hash_generated_method = "8438D7E838AEFF1A89C67E8065010AE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ContentResolver getContentResolver() {
        ContentResolver varDEC45C6FE41EA3E170F078DAEF66DE75_224117484 = (mBase.getContentResolver());
        return (ContentResolver)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getContentResolver();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.056 -0400", hash_original_method = "7DA68BFFD90B5B26D8702419E8D7FC4A", hash_generated_method = "BE6EACF2D20832F02B7177ABCAA3B09D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Looper getMainLooper() {
        Looper var69ADB12DA7C17482EA26ED5BC8C6D811_21582369 = (mBase.getMainLooper());
        return (Looper)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getMainLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.066 -0400", hash_original_method = "78E13438476D4B526B3AB7AB982B9A37", hash_generated_method = "CC4448B6EC0B30043031AEE7EAF6F488")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Context getApplicationContext() {
        Context var1360198B75C4FA904434BC0D8AA48CBD_60424241 = (mBase.getApplicationContext());
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getApplicationContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.066 -0400", hash_original_method = "52BC053E8452DD327B93F4A2F04B45DF", hash_generated_method = "8A87DB6F219E548C901E02FAA3AC052A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setTheme(int resid) {
        dsTaint.addTaint(resid);
        mBase.setTheme(resid);
        // ---------- Original Method ----------
        //mBase.setTheme(resid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.067 -0400", hash_original_method = "735F7E922A6884F691E7980C19D30ED9", hash_generated_method = "B0C8A7D9E6DC7B11CC18AD6969E0F61A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getThemeResId() {
        int var7AC95F797AB08594A077B70F1A8CCEE7_341872256 = (mBase.getThemeResId());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.getThemeResId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.067 -0400", hash_original_method = "A934E0879ABB06742AB01E1FAB54A9BF", hash_generated_method = "FAD96A156605D61C84D2978C9086E6CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varCF49010CA6154F28DEA5BFC80231478F_682506889 = (mBase.getTheme());
        return (Resources.Theme)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getTheme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.068 -0400", hash_original_method = "325690D530E21A0AB255EE9D69D84488", hash_generated_method = "DC4C8EA86B62BB62E54D150182F7DCDE")
    @DSModeled(DSC.BAN)
    @Override
    public ClassLoader getClassLoader() {
        ClassLoader var7430431A6894715AAF16CE61CB881D98_1416952278 = (mBase.getClassLoader());
        return (ClassLoader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.068 -0400", hash_original_method = "FC1F671DB2DE2D2F1C64463A96604F21", hash_generated_method = "BD98D2967CD677CA4A4532F1F167F19C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getPackageName() {
        String var1A9937FA3520EB03A15C4381B3409B5F_869579738 = (mBase.getPackageName());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mBase.getPackageName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.068 -0400", hash_original_method = "12EA4F448AA17744DA817E2FDC985059", hash_generated_method = "E93A255A9F4F73DB1159F716D9070A0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo varE1D800969C3C6EC770932C1F17EFA6A9_2042224709 = (mBase.getApplicationInfo());
        return (ApplicationInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getApplicationInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.069 -0400", hash_original_method = "1456FB2C70424875587B348EBED7BEBD", hash_generated_method = "BD1FE3A9374E16B9F5E2B3E9908E13B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getPackageResourcePath() {
        String var4C5A6FC4F8E3F88190DD89206BADAC65_1607647320 = (mBase.getPackageResourcePath());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mBase.getPackageResourcePath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.069 -0400", hash_original_method = "90ECA4CEE907B9CC4828D0F1EDEE17EB", hash_generated_method = "7BA28A44BA3898406554EEC32C87848C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String getPackageCodePath() {
        String var9B9AFA1AA59E35100E3DF4494362FD51_1755237489 = (mBase.getPackageCodePath());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mBase.getPackageCodePath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.070 -0400", hash_original_method = "49CEDB82FC58CDF70EFA8B7A21272CFA", hash_generated_method = "A3B9D34A04EE9F896981D12AF4A9DE9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getSharedPrefsFile(String name) {
        dsTaint.addTaint(name);
        File var8A06EA91FF6F284659309A032DBCD73C_691390108 = (mBase.getSharedPrefsFile(name));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getSharedPrefsFile(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.070 -0400", hash_original_method = "51168DD8811589A8A44258F7BDA9D1F0", hash_generated_method = "F2734E22C6EE8F6860D79BEAAC39FB99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(mode);
        SharedPreferences var7D2609DAE3A4A43B5E3F15D3F4A1D1FF_650072983 = (mBase.getSharedPreferences(name, mode));
        return (SharedPreferences)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getSharedPreferences(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.070 -0400", hash_original_method = "744F22B41784C38DFA56BA635287A3F7", hash_generated_method = "41E74624E64FA4DC27E1BBF2D804808F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        dsTaint.addTaint(name);
        FileInputStream varAEE276D082FE5465128DC98EAEC46E86_1506090939 = (mBase.openFileInput(name));
        return (FileInputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.openFileInput(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.071 -0400", hash_original_method = "1B551CEA36C6304276D435BC90F14FD3", hash_generated_method = "49F3839F22B74107219384E0DFB849D6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(mode);
        FileOutputStream varADDD7477690DD865F8C44D7D268648FB_132560231 = (mBase.openFileOutput(name, mode));
        return (FileOutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.openFileOutput(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.071 -0400", hash_original_method = "A1313161ACDE2AAD1A9AEF7D9E6B717D", hash_generated_method = "9199328AD081098AC84DEEDD4053856A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean deleteFile(String name) {
        dsTaint.addTaint(name);
        boolean var14AF3FE5F23FD23E2C2EAF5A63873DB5_2004591295 = (mBase.deleteFile(name));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBase.deleteFile(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.072 -0400", hash_original_method = "41C51E2648C5FE16B28D046D5B54DAAA", hash_generated_method = "CE25E18847DBFD6BC7370EA48F340AC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getFileStreamPath(String name) {
        dsTaint.addTaint(name);
        File var84B977E1CCD82A335554E38A2600337F_1822057893 = (mBase.getFileStreamPath(name));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getFileStreamPath(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.072 -0400", hash_original_method = "7FE19E11982633820D311587FC329BA9", hash_generated_method = "F94E4650071747F2E1735BBF046ACAA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] fileList() {
        String[] var6F5381480E894ED954B172672A6FA14B_1665251599 = (mBase.fileList());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mBase.fileList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.072 -0400", hash_original_method = "14B449BDD79B281009CCC9DF0F75EC6B", hash_generated_method = "D1BD1DA2530BE2831C558E13AB2059BC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getFilesDir() {
        File var2CFDC4BB999665F0BBA4730F0B3F0945_2116671291 = (mBase.getFilesDir());
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getFilesDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.073 -0400", hash_original_method = "BC309698CECF9063C5A4ADDF6C6EC7AF", hash_generated_method = "D8E91DA92C114F6DB6F72A6790A3F24E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getExternalFilesDir(String type) {
        dsTaint.addTaint(type);
        File varE984D8D8897547BB06108DF498D8FC99_817001633 = (mBase.getExternalFilesDir(type));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getExternalFilesDir(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.073 -0400", hash_original_method = "068174B051BB78F57C468F648940D142", hash_generated_method = "FB64170FEE1F26F363ED0FB0559F14BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getObbDir() {
        File varBDCEE8F1E697C5B5E6F123C95A6F2A0E_870300347 = (mBase.getObbDir());
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getObbDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.074 -0400", hash_original_method = "44DE59125179A0BDED11E57B810BFAF1", hash_generated_method = "2ED72942A0D387CAF3CEC532715CE9BD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getCacheDir() {
        File var88100E6CE907B25E04CE4973DFCCEF34_830594857 = (mBase.getCacheDir());
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getCacheDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.075 -0400", hash_original_method = "7C2D809316E637C52FE8D4DE0AE386A3", hash_generated_method = "BB20D9EFAFFCD538C1449663983B4971")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getExternalCacheDir() {
        File var2215BD8324C8F0EAC132C1771A7246CC_1878916332 = (mBase.getExternalCacheDir());
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getExternalCacheDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.076 -0400", hash_original_method = "A1FD69F0E118B7CAF1C496338AAD4B07", hash_generated_method = "5C6115A11F5D39BF9EA8B38F73DBE7C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getDir(String name, int mode) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(mode);
        File var385F4B6E0DA02AFF9DB74FC3D54CA9CD_1587626967 = (mBase.getDir(name, mode));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getDir(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.076 -0400", hash_original_method = "DDED7E3E0B02F872C2CC1A3BF9DCD873", hash_generated_method = "41C20845E64D6245705CDF528168D910")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(factory.dsTaint);
        dsTaint.addTaint(mode);
        SQLiteDatabase var241540ABF655844395772919923CD9EE_279896621 = (mBase.openOrCreateDatabase(name, mode, factory));
        return (SQLiteDatabase)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.openOrCreateDatabase(name, mode, factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.077 -0400", hash_original_method = "670C2BACF8B510FB1BD02F583C82D7AC", hash_generated_method = "175247BCAACB177965582DAA3D9E4758")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(errorHandler.dsTaint);
        dsTaint.addTaint(factory.dsTaint);
        dsTaint.addTaint(mode);
        SQLiteDatabase var5135080D1419AC5FB2EA75CBF36D7927_905113105 = (mBase.openOrCreateDatabase(name, mode, factory, errorHandler));
        return (SQLiteDatabase)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.086 -0400", hash_original_method = "2060E0B3DB8EB041F39B4C3EBCF4134E", hash_generated_method = "72B2F3BE94F1C66948FAFB7B1995994B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean deleteDatabase(String name) {
        dsTaint.addTaint(name);
        boolean var1201E6487C2E2ECBC3C1937591CAB600_680436747 = (mBase.deleteDatabase(name));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBase.deleteDatabase(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.087 -0400", hash_original_method = "A01E89BA0EE5F5DE805AF38A996A2059", hash_generated_method = "0F266C670D737B97C0464F15CE75AB3A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public File getDatabasePath(String name) {
        dsTaint.addTaint(name);
        File var856BDB13BABFDCB220C430BD539CC0A6_737281206 = (mBase.getDatabasePath(name));
        return (File)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getDatabasePath(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.088 -0400", hash_original_method = "B3ECD12C5FD290CA7C545491C12B6E0F", hash_generated_method = "C1E2419EDE24E7A6231CA624C907FE62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String[] databaseList() {
        String[] varA00359C0AE769853BC15D43D5F05C2EE_147106766 = (mBase.databaseList());
        String[] retVal = new String[1];
        retVal[0] = dsTaint.getTaintString();
        return retVal;
        // ---------- Original Method ----------
        //return mBase.databaseList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.088 -0400", hash_original_method = "F9E6827CCB2CDD46111FB10DB307E9AE", hash_generated_method = "EE79E6A07004ABDE1634C78AEA3BB117")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable getWallpaper() {
        Drawable var7166B67D63CFB5E5C8537F137DA6DC9B_1057832849 = (mBase.getWallpaper());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.089 -0400", hash_original_method = "0198388A7C02DAA006719AEF39F3322C", hash_generated_method = "AB2D8CF576D918BE226B7505A73F6AA0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Drawable peekWallpaper() {
        Drawable var9C8138D14C291AE0750CAA786DCA3915_1561919841 = (mBase.peekWallpaper());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.peekWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.090 -0400", hash_original_method = "19E21BC09381D0D00BEBE6A5DFBF3F3C", hash_generated_method = "AADB08845B6A2EB15BCDE3B0809692F2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varAADE4DC8942D82E82A9B42B92539E4A5_509084535 = (mBase.getWallpaperDesiredMinimumWidth());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.getWallpaperDesiredMinimumWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.091 -0400", hash_original_method = "3C43E61226EF3145DD8AB1F12075339B", hash_generated_method = "6DC00679614F50A347268F0460E2CB35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int varB7C2E2DEB0713543A3A0442CBAC5C5E5_1115009076 = (mBase.getWallpaperDesiredMinimumHeight());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.getWallpaperDesiredMinimumHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.092 -0400", hash_original_method = "A836F480E829D8C861FB92C4C9146FF3", hash_generated_method = "AADF69D3E6B7D8B65B272EAADCE51337")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        dsTaint.addTaint(bitmap.dsTaint);
        mBase.setWallpaper(bitmap);
        // ---------- Original Method ----------
        //mBase.setWallpaper(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.093 -0400", hash_original_method = "D6DB0F01F771FA9EFE610782CC61AF10", hash_generated_method = "C55D1D2C12D94F29FE2298EAC20DF39E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        dsTaint.addTaint(data.dsTaint);
        mBase.setWallpaper(data);
        // ---------- Original Method ----------
        //mBase.setWallpaper(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.094 -0400", hash_original_method = "707333CAD350B1F9359277B8D6F8C031", hash_generated_method = "889EBA665B576D5C1EA97218B0419F62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void clearWallpaper() throws IOException {
        mBase.clearWallpaper();
        // ---------- Original Method ----------
        //mBase.clearWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.094 -0400", hash_original_method = "130F62140951A945508EBFB32B94A765", hash_generated_method = "1ABDA66B52D647AA335E7554EFB8801F")
    @DSModeled(DSC.SPEC)
    @Override
    public void startActivity(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        mBase.startActivity(intent);
        // ---------- Original Method ----------
        //mBase.startActivity(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.095 -0400", hash_original_method = "013A3CF6138EA6FE6C22614936FE13C8", hash_generated_method = "9CBA28B00D96C678BEA7CB270194267C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void startActivities(Intent[] intents) {
        dsTaint.addTaint(intents[0].dsTaint);
        mBase.startActivities(intents);
        // ---------- Original Method ----------
        //mBase.startActivities(intents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.095 -0400", hash_original_method = "D7C74DA04A5B79EC6630FAD526B70ED6", hash_generated_method = "7346989CF467B50A405D0CCF61616FF4")
    @DSModeled(DSC.SPEC)
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        dsTaint.addTaint(flagsMask);
        dsTaint.addTaint(flagsValues);
        dsTaint.addTaint(extraFlags);
        dsTaint.addTaint(fillInIntent.dsTaint);
        dsTaint.addTaint(intent.dsTaint);
        mBase.startIntentSender(intent, fillInIntent, flagsMask,
                flagsValues, extraFlags);
        // ---------- Original Method ----------
        //mBase.startIntentSender(intent, fillInIntent, flagsMask,
                //flagsValues, extraFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.102 -0400", hash_original_method = "CD7D57CF51FEE3E0548133C9C2D084D1", hash_generated_method = "52FB25ABA370618DF8DFA4CB883EB797")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendBroadcast(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        mBase.sendBroadcast(intent);
        // ---------- Original Method ----------
        //mBase.sendBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.102 -0400", hash_original_method = "0D532949C3012CD33C142E9B5D03BB61", hash_generated_method = "90303E24CFDCF84BF6DB3A08DDEA1D24")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        dsTaint.addTaint(receiverPermission);
        dsTaint.addTaint(intent.dsTaint);
        mBase.sendBroadcast(intent, receiverPermission);
        // ---------- Original Method ----------
        //mBase.sendBroadcast(intent, receiverPermission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.103 -0400", hash_original_method = "F587D697CC21A22CF1C16322E48A38D4", hash_generated_method = "BA5E1E70CE7D263683E69F6C4ED8FA03")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        dsTaint.addTaint(receiverPermission);
        dsTaint.addTaint(intent.dsTaint);
        mBase.sendOrderedBroadcast(intent, receiverPermission);
        // ---------- Original Method ----------
        //mBase.sendOrderedBroadcast(intent, receiverPermission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.103 -0400", hash_original_method = "DEE55BD129D883E4F2F6F72EA9382082", hash_generated_method = "0C0EEF94B83045F70581621818C46D60")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendOrderedBroadcast(
        Intent intent, String receiverPermission, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        dsTaint.addTaint(receiverPermission);
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(initialExtras.dsTaint);
        dsTaint.addTaint(resultReceiver.dsTaint);
        dsTaint.addTaint(initialCode);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(initialData);
        mBase.sendOrderedBroadcast(intent, receiverPermission,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
        // ---------- Original Method ----------
        //mBase.sendOrderedBroadcast(intent, receiverPermission,
                //resultReceiver, scheduler, initialCode,
                //initialData, initialExtras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.104 -0400", hash_original_method = "E4D0FD66C31D49EF8A28B259CA31F5AB", hash_generated_method = "23C453B9BE735DB11FFBEC1079D2F06C")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendStickyBroadcast(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        mBase.sendStickyBroadcast(intent);
        // ---------- Original Method ----------
        //mBase.sendStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.110 -0400", hash_original_method = "7E21CD2A51D6CF22EBBD91300928AE98", hash_generated_method = "14B4D062FCD3C9FED1DBEBC35F3C3865")
    @DSModeled(DSC.SPEC)
    @Override
    public void sendStickyOrderedBroadcast(
        Intent intent, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(initialExtras.dsTaint);
        dsTaint.addTaint(resultReceiver.dsTaint);
        dsTaint.addTaint(initialCode);
        dsTaint.addTaint(intent.dsTaint);
        dsTaint.addTaint(initialData);
        mBase.sendStickyOrderedBroadcast(intent,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
        // ---------- Original Method ----------
        //mBase.sendStickyOrderedBroadcast(intent,
                //resultReceiver, scheduler, initialCode,
                //initialData, initialExtras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.115 -0400", hash_original_method = "F6F4D7B74D392C087E12FF2E322B2B45", hash_generated_method = "842C9F629DEE57863D77F45C75B1C0BA")
    @DSModeled(DSC.SPEC)
    @Override
    public void removeStickyBroadcast(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        mBase.removeStickyBroadcast(intent);
        // ---------- Original Method ----------
        //mBase.removeStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.115 -0400", hash_original_method = "D33A933E89CAAB59BCB5CB9CA20F9A5A", hash_generated_method = "3CEC6134E080043E4BEB5D28290C5057")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        Intent var890901CBB2C421F45947910AA3405EFB_1617966782 = (mBase.registerReceiver(receiver, filter));
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.registerReceiver(receiver, filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.118 -0400", hash_original_method = "C498ADCED351E80E96A53362B4745838", hash_generated_method = "F1A731F6D4FD6955776090085F7E8C53")
    @DSModeled(DSC.SPEC)
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter,
        String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(broadcastPermission);
        dsTaint.addTaint(receiver.dsTaint);
        dsTaint.addTaint(scheduler.dsTaint);
        dsTaint.addTaint(filter.dsTaint);
        Intent var1A5E9A47B3981BD24574530A7F5F54B2_1093806544 = (mBase.registerReceiver(receiver, filter, broadcastPermission,
                scheduler));
        return (Intent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.registerReceiver(receiver, filter, broadcastPermission,
                //scheduler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.118 -0400", hash_original_method = "D3936D1C8F9D43BCF113D4D92126FE25", hash_generated_method = "657F7AFC94145B1ACC4C7606AE45E82E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        dsTaint.addTaint(receiver.dsTaint);
        mBase.unregisterReceiver(receiver);
        // ---------- Original Method ----------
        //mBase.unregisterReceiver(receiver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.119 -0400", hash_original_method = "460FA5078659EEF29B84A9C36C1BA43F", hash_generated_method = "4DB2DBB8D53891DB9735EF4662868AF5")
    @DSModeled(DSC.SPEC)
    @Override
    public ComponentName startService(Intent service) {
        dsTaint.addTaint(service.dsTaint);
        ComponentName var1BF8FF46BC5C825890F8DFD41D7ECEC1_899884629 = (mBase.startService(service));
        return (ComponentName)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.startService(service);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.119 -0400", hash_original_method = "2538E8D6E7BE6E9AB177EECCCE1CB620", hash_generated_method = "E7F175261CCD5012657102F7D288857F")
    @DSModeled(DSC.SPEC)
    @Override
    public boolean stopService(Intent name) {
        dsTaint.addTaint(name.dsTaint);
        boolean var79E09432295B6E81E775BAA1429D1742_419191834 = (mBase.stopService(name));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBase.stopService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.130 -0400", hash_original_method = "67132A5BC1B8EF0B15B0E872390898A0", hash_generated_method = "114BDBEB5000B80CF5E39829388C84F4")
    @DSModeled(DSC.SPEC)
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(conn.dsTaint);
        dsTaint.addTaint(service.dsTaint);
        boolean varB449E6D6F4ECBAA56F7BEB7D0560F07C_457623292 = (mBase.bindService(service, conn, flags));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBase.bindService(service, conn, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.130 -0400", hash_original_method = "78D7D650BB4D5279C2DB8316AB02503B", hash_generated_method = "9AE4C750C9133F70F7FF6C9BE2174DBD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void unbindService(ServiceConnection conn) {
        dsTaint.addTaint(conn.dsTaint);
        mBase.unbindService(conn);
        // ---------- Original Method ----------
        //mBase.unbindService(conn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.131 -0400", hash_original_method = "093BF17242F85E57BE88B991FC8B0E44", hash_generated_method = "496E63AC58956CD799697741C7B36FDB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        dsTaint.addTaint(arguments.dsTaint);
        dsTaint.addTaint(className.dsTaint);
        dsTaint.addTaint(profileFile);
        boolean var7847DE7C5C74BB7E9D8EF837B1629B88_1333101184 = (mBase.startInstrumentation(className, profileFile, arguments));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBase.startInstrumentation(className, profileFile, arguments);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.131 -0400", hash_original_method = "4DFF381EBA248BD85BCC25FEFAAD92DA", hash_generated_method = "48A20C77ADB3B85B1E41C8268541CA89")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getSystemService(String name) {
        dsTaint.addTaint(name);
        Object var775837DC306FA3421E42286960084F37_1764638130 = (mBase.getSystemService(name));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.getSystemService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.132 -0400", hash_original_method = "C6E05CB80424200F4C331B8669202D3F", hash_generated_method = "617B30E8E7B519EF1507CEB126DE3FCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(permission);
        int var0B5D93936231AC00BB3EB885AB5DD216_241098755 = (mBase.checkPermission(permission, pid, uid));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.checkPermission(permission, pid, uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.132 -0400", hash_original_method = "28B4654D3709544EFD7B7FEA40DBBFF2", hash_generated_method = "1F757C0FDBECC708268BB151AEBD9A01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkCallingPermission(String permission) {
        dsTaint.addTaint(permission);
        int var085AD305D9EE5D54D148F8FAB5BCD242_791365570 = (mBase.checkCallingPermission(permission));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.checkCallingPermission(permission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.133 -0400", hash_original_method = "284FE3FB34D582E990C725D71B70CDFB", hash_generated_method = "14A871DE265286EAE2D6B7FC700A77DA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        dsTaint.addTaint(permission);
        int var74DBDAA10225909C76130339398AA057_918132121 = (mBase.checkCallingOrSelfPermission(permission));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.checkCallingOrSelfPermission(permission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.133 -0400", hash_original_method = "62A2576537CC71D60C1F63F5056773AE", hash_generated_method = "6ECCE5ADD612ED7EDC1ACCDDEFA591E6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(permission);
        mBase.enforcePermission(permission, pid, uid, message);
        // ---------- Original Method ----------
        //mBase.enforcePermission(permission, pid, uid, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.133 -0400", hash_original_method = "81E2CA4E96042AEDAEF02FD92A2A1A67", hash_generated_method = "4D2F2F938791CCC85EE3CBED4AA0C9CA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void enforceCallingPermission(String permission, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(permission);
        mBase.enforceCallingPermission(permission, message);
        // ---------- Original Method ----------
        //mBase.enforceCallingPermission(permission, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.134 -0400", hash_original_method = "4C72B3FC5896AFE13143126AEF9E54CC", hash_generated_method = "34AB6E565219EC13A9D624BF94FC9829")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(permission);
        mBase.enforceCallingOrSelfPermission(permission, message);
        // ---------- Original Method ----------
        //mBase.enforceCallingOrSelfPermission(permission, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.134 -0400", hash_original_method = "C92445D33E31E73A915DF30F0CA49E37", hash_generated_method = "1E88F1E4380889CB38BA9CC5EA9F4F47")
    @DSModeled(DSC.SPEC)
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(toPackage);
        dsTaint.addTaint(uri.dsTaint);
        mBase.grantUriPermission(toPackage, uri, modeFlags);
        // ---------- Original Method ----------
        //mBase.grantUriPermission(toPackage, uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.136 -0400", hash_original_method = "10A2FB283E31FE469317FAE71C7AF4F8", hash_generated_method = "8EA401AB18C9895DC17EDA2F84C36ED6")
    @DSModeled(DSC.SPEC)
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        mBase.revokeUriPermission(uri, modeFlags);
        // ---------- Original Method ----------
        //mBase.revokeUriPermission(uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.137 -0400", hash_original_method = "F52277BFC8F41FE72798C9E8418C1E24", hash_generated_method = "ACA32B571E0E81D51A6038F435FFBBEA")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(uri.dsTaint);
        int var4BA59D5FCB145B56552A926363D08843_6373707 = (mBase.checkUriPermission(uri, pid, uid, modeFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.checkUriPermission(uri, pid, uid, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.137 -0400", hash_original_method = "43D2E9446750BEAA21B381D934BB37A3", hash_generated_method = "027564D6201E85EF9FB3B7FD5D7C73EE")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        int var32F95911BC4A7B4DB8535C3F25E383D2_2067772646 = (mBase.checkCallingUriPermission(uri, modeFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.checkCallingUriPermission(uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.137 -0400", hash_original_method = "4761F75E9F6B51877289AE555068D313", hash_generated_method = "E39AEEC91B6D9711A8C6D7B9BA1B2A6B")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        int varBF497F120043DE15F7549BECCC4FD74C_1070475116 = (mBase.checkCallingOrSelfUriPermission(uri, modeFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.138 -0400", hash_original_method = "2B7D942FC66EB790715A21C2BF13434D", hash_generated_method = "4CA95245BD5B1414778AE46E1F369163")
    @DSModeled(DSC.SPEC)
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(writePermission);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(readPermission);
        dsTaint.addTaint(uri.dsTaint);
        int varE86989A776CE237B6A5E3024ADB23E65_1309316547 = (mBase.checkUriPermission(uri, readPermission, writePermission,
                pid, uid, modeFlags));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBase.checkUriPermission(uri, readPermission, writePermission,
                //pid, uid, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.138 -0400", hash_original_method = "BB196C48EA062CF760A21CBEDF203044", hash_generated_method = "E305E8F0637FBEF78C9F579EBB71D088")
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(uri.dsTaint);
        mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
        // ---------- Original Method ----------
        //mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.139 -0400", hash_original_method = "B8C6D02BD75567C0C6C58E522F178982", hash_generated_method = "731C6D1591718678D1A71EAE64B39535")
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        mBase.enforceCallingUriPermission(uri, modeFlags, message);
        // ---------- Original Method ----------
        //mBase.enforceCallingUriPermission(uri, modeFlags, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.139 -0400", hash_original_method = "7C2103EAC397ACBBFFA65707A1212FAD", hash_generated_method = "CC62A7BBEFED1F2E1B4786BDE9A216B3")
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(uri.dsTaint);
        mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
        // ---------- Original Method ----------
        //mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.139 -0400", hash_original_method = "2C0B32E644AD3E21F1765D96680E56CD", hash_generated_method = "EB24920FAC98276534C9EF756E08F0C4")
    @DSModeled(DSC.SPEC)
    @Override
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        dsTaint.addTaint(message);
        dsTaint.addTaint(uid);
        dsTaint.addTaint(modeFlags);
        dsTaint.addTaint(writePermission);
        dsTaint.addTaint(pid);
        dsTaint.addTaint(readPermission);
        dsTaint.addTaint(uri.dsTaint);
        mBase.enforceUriPermission(
                uri, readPermission, writePermission, pid, uid, modeFlags,
                message);
        // ---------- Original Method ----------
        //mBase.enforceUriPermission(
                //uri, readPermission, writePermission, pid, uid, modeFlags,
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.140 -0400", hash_original_method = "B027173E51D2D8A4B1BA8F51741454A2", hash_generated_method = "CC3E7655CECB44CFC2F1EFBAA02860B9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(packageName);
        Context varB5A7A42C55604B8B11296B08E013768F_1618981801 = (mBase.createPackageContext(packageName, flags));
        return (Context)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBase.createPackageContext(packageName, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:41.140 -0400", hash_original_method = "B09C0B118B70B22456444DDECE846C9F", hash_generated_method = "086B6F709A77C6EA57855F62012C75D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isRestricted() {
        boolean var5B1D49D9F4C840BADBDE433A4848080A_126547914 = (mBase.isRestricted());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBase.isRestricted();
    }

    
}

