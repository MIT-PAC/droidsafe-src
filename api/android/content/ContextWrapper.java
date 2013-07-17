package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.468 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "45A1FAFEC6ED7EF70B481175C79188A0")

    Context mBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.468 -0400", hash_original_method = "10030D2DB2A8F36EE12AB3354BCBF9E2", hash_generated_method = "6955E83EDFF1B7CDF47D712DAA27309B")
    public  ContextWrapper(Context base) {
        mBase = base;
        // ---------- Original Method ----------
        //mBase = base;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.469 -0400", hash_original_method = "C93782FE26B0F4F6F9B761D03AD74E79", hash_generated_method = "BC41AAB5EC9080693944ACE6E52133E7")
    protected void attachBaseContext(Context base) {
        if(mBase != null)        
        {
            IllegalStateException var66C5824069E0964DC69656CAA57B8B9F_188479167 = new IllegalStateException("Base context already set");
            var66C5824069E0964DC69656CAA57B8B9F_188479167.addTaint(taint);
            throw var66C5824069E0964DC69656CAA57B8B9F_188479167;
        } //End block
        mBase = base;
        // ---------- Original Method ----------
        //if (mBase != null) {
            //throw new IllegalStateException("Base context already set");
        //}
        //mBase = base;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.469 -0400", hash_original_method = "348D9A1AC27363C49C4D9EF878F36A33", hash_generated_method = "B2CEF60BF4C763A517BBEFB439868C6F")
    public Context getBaseContext() {
Context varA148490A8BFC4E02B4B251DB8934259F_937948670 =         mBase;
        varA148490A8BFC4E02B4B251DB8934259F_937948670.addTaint(taint);
        return varA148490A8BFC4E02B4B251DB8934259F_937948670;
        // ---------- Original Method ----------
        //return mBase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.469 -0400", hash_original_method = "207324BD2179C2BB1CD4C22794703A9D", hash_generated_method = "480993D861F31E203B6AB04E04B0F6D8")
    @Override
    public AssetManager getAssets() {
AssetManager var76C3CF86EE6D54B30C36C32803928372_489430778 =         mBase.getAssets();
        var76C3CF86EE6D54B30C36C32803928372_489430778.addTaint(taint);
        return var76C3CF86EE6D54B30C36C32803928372_489430778;
        // ---------- Original Method ----------
        //return mBase.getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.469 -0400", hash_original_method = "47F2A94B0203C279563273E1E0895D4D", hash_generated_method = "3B26FAB507C9022601BF740F386A33B5")
    @Override
    public Resources getResources() {
Resources varC0A9C6BE038D35ACBF64CA430137389B_659417915 =         mBase.getResources();
        varC0A9C6BE038D35ACBF64CA430137389B_659417915.addTaint(taint);
        return varC0A9C6BE038D35ACBF64CA430137389B_659417915;
        // ---------- Original Method ----------
        //return mBase.getResources();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.470 -0400", hash_original_method = "D7F633AF602934F61160FEA442625239", hash_generated_method = "436AB17741DDA51F4055FB2CCA56D708")
    @Override
    public PackageManager getPackageManager() {
PackageManager var2460232D63BA9F10997363947D615C09_933490083 =         mBase.getPackageManager();
        var2460232D63BA9F10997363947D615C09_933490083.addTaint(taint);
        return var2460232D63BA9F10997363947D615C09_933490083;
        // ---------- Original Method ----------
        //return mBase.getPackageManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.470 -0400", hash_original_method = "8EDC66E2D77BCDC119853EA41EA3296B", hash_generated_method = "A81339EE45A8599750511D276622A0B3")
    @Override
    public ContentResolver getContentResolver() {
ContentResolver var00D3C554E0AB15EA09A7796CA11174FA_758310135 =         mBase.getContentResolver();
        var00D3C554E0AB15EA09A7796CA11174FA_758310135.addTaint(taint);
        return var00D3C554E0AB15EA09A7796CA11174FA_758310135;
        // ---------- Original Method ----------
        //return mBase.getContentResolver();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.470 -0400", hash_original_method = "7DA68BFFD90B5B26D8702419E8D7FC4A", hash_generated_method = "191E9452FC20E90755E8592430066CBF")
    @Override
    public Looper getMainLooper() {
Looper var08A834780F62DEFB0CC11359A8BF5D1E_1278415160 =         mBase.getMainLooper();
        var08A834780F62DEFB0CC11359A8BF5D1E_1278415160.addTaint(taint);
        return var08A834780F62DEFB0CC11359A8BF5D1E_1278415160;
        // ---------- Original Method ----------
        //return mBase.getMainLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.471 -0400", hash_original_method = "78E13438476D4B526B3AB7AB982B9A37", hash_generated_method = "52EB1381A7AED3CC5A11E7AE4B918F16")
    @Override
    public Context getApplicationContext() {
Context var297DFF380BA41D2B4D2B12F4EF189288_1129997023 =         mBase.getApplicationContext();
        var297DFF380BA41D2B4D2B12F4EF189288_1129997023.addTaint(taint);
        return var297DFF380BA41D2B4D2B12F4EF189288_1129997023;
        // ---------- Original Method ----------
        //return mBase.getApplicationContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.471 -0400", hash_original_method = "52BC053E8452DD327B93F4A2F04B45DF", hash_generated_method = "B7B90D860BAF2521927315B295359630")
    @Override
    public void setTheme(int resid) {
        addTaint(resid);
        mBase.setTheme(resid);
        // ---------- Original Method ----------
        //mBase.setTheme(resid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.471 -0400", hash_original_method = "735F7E922A6884F691E7980C19D30ED9", hash_generated_method = "3BC287BFA0E938D78F9374C6BB2D3497")
    @Override
    public int getThemeResId() {
        int var694ACEAE2EB299A90303D08BF5923279_937734767 = (mBase.getThemeResId());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206379823 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1206379823;
        // ---------- Original Method ----------
        //return mBase.getThemeResId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.471 -0400", hash_original_method = "A934E0879ABB06742AB01E1FAB54A9BF", hash_generated_method = "EDAF402A5F4341538C40469CEBDF2994")
    @Override
    public Resources.Theme getTheme() {
Resources.Theme var76B6B77AD887645DC7839F859C86DB3B_968016803 =         mBase.getTheme();
        var76B6B77AD887645DC7839F859C86DB3B_968016803.addTaint(taint);
        return var76B6B77AD887645DC7839F859C86DB3B_968016803;
        // ---------- Original Method ----------
        //return mBase.getTheme();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.472 -0400", hash_original_method = "325690D530E21A0AB255EE9D69D84488", hash_generated_method = "8C120F89FCE5D2CA5BB14365E3B3557B")
    @Override
    public ClassLoader getClassLoader() {
ClassLoader varA8807F3BF816B843E87ECF72F437B526_2070112582 =         mBase.getClassLoader();
        varA8807F3BF816B843E87ECF72F437B526_2070112582.addTaint(taint);
        return varA8807F3BF816B843E87ECF72F437B526_2070112582;
        // ---------- Original Method ----------
        //return mBase.getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.472 -0400", hash_original_method = "FC1F671DB2DE2D2F1C64463A96604F21", hash_generated_method = "0C5E1D7FC40BE2A5A0779B6F5C8D98E3")
    @Override
    public String getPackageName() {
String varCC969730AEDAE2CF8E546E89D9BA5651_1055991280 =         mBase.getPackageName();
        varCC969730AEDAE2CF8E546E89D9BA5651_1055991280.addTaint(taint);
        return varCC969730AEDAE2CF8E546E89D9BA5651_1055991280;
        // ---------- Original Method ----------
        //return mBase.getPackageName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.472 -0400", hash_original_method = "12EA4F448AA17744DA817E2FDC985059", hash_generated_method = "8FA4D7F169BCD4CC8B02AC870168F016")
    @Override
    public ApplicationInfo getApplicationInfo() {
ApplicationInfo var5A440309FC948E478F14554A984E3988_1942070543 =         mBase.getApplicationInfo();
        var5A440309FC948E478F14554A984E3988_1942070543.addTaint(taint);
        return var5A440309FC948E478F14554A984E3988_1942070543;
        // ---------- Original Method ----------
        //return mBase.getApplicationInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.472 -0400", hash_original_method = "1456FB2C70424875587B348EBED7BEBD", hash_generated_method = "374F4FA6D348ACAC16BE88DBB81C99C5")
    @Override
    public String getPackageResourcePath() {
String varF7B3E0E6C53211CB95758CA5835079A9_343357980 =         mBase.getPackageResourcePath();
        varF7B3E0E6C53211CB95758CA5835079A9_343357980.addTaint(taint);
        return varF7B3E0E6C53211CB95758CA5835079A9_343357980;
        // ---------- Original Method ----------
        //return mBase.getPackageResourcePath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.473 -0400", hash_original_method = "90ECA4CEE907B9CC4828D0F1EDEE17EB", hash_generated_method = "C1C52E28F534A9526FE86A65BF1E9D07")
    @Override
    public String getPackageCodePath() {
String var3FBCA4B17D2D1E884408A8469AF743F1_1647355642 =         mBase.getPackageCodePath();
        var3FBCA4B17D2D1E884408A8469AF743F1_1647355642.addTaint(taint);
        return var3FBCA4B17D2D1E884408A8469AF743F1_1647355642;
        // ---------- Original Method ----------
        //return mBase.getPackageCodePath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.473 -0400", hash_original_method = "49CEDB82FC58CDF70EFA8B7A21272CFA", hash_generated_method = "C3BCA79E9C8F534EDF5CFF65CE599863")
    @Override
    public File getSharedPrefsFile(String name) {
        addTaint(name.getTaint());
File varCEC3785B29BF636922E886A7D1379E30_1302375521 =         mBase.getSharedPrefsFile(name);
        varCEC3785B29BF636922E886A7D1379E30_1302375521.addTaint(taint);
        return varCEC3785B29BF636922E886A7D1379E30_1302375521;
        // ---------- Original Method ----------
        //return mBase.getSharedPrefsFile(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.473 -0400", hash_original_method = "51168DD8811589A8A44258F7BDA9D1F0", hash_generated_method = "05C538077E8B49C0B0116107A095CE6F")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
SharedPreferences varA54C5E6B915CFF7C92731136C531E733_1908702096 =         mBase.getSharedPreferences(name, mode);
        varA54C5E6B915CFF7C92731136C531E733_1908702096.addTaint(taint);
        return varA54C5E6B915CFF7C92731136C531E733_1908702096;
        // ---------- Original Method ----------
        //return mBase.getSharedPreferences(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.473 -0400", hash_original_method = "744F22B41784C38DFA56BA635287A3F7", hash_generated_method = "5E9CCB1986C4300CF8C77A099EF46AE6")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        addTaint(name.getTaint());
FileInputStream varA1D772851A48D51218F8D32143265657_1268360870 =         mBase.openFileInput(name);
        varA1D772851A48D51218F8D32143265657_1268360870.addTaint(taint);
        return varA1D772851A48D51218F8D32143265657_1268360870;
        // ---------- Original Method ----------
        //return mBase.openFileInput(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.473 -0400", hash_original_method = "1B551CEA36C6304276D435BC90F14FD3", hash_generated_method = "06BE2843EB4BA59109C77BDC046129C1")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        addTaint(mode);
        addTaint(name.getTaint());
FileOutputStream varFFB8432828FDF9D378486365E66D6F43_166173958 =         mBase.openFileOutput(name, mode);
        varFFB8432828FDF9D378486365E66D6F43_166173958.addTaint(taint);
        return varFFB8432828FDF9D378486365E66D6F43_166173958;
        // ---------- Original Method ----------
        //return mBase.openFileOutput(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.474 -0400", hash_original_method = "A1313161ACDE2AAD1A9AEF7D9E6B717D", hash_generated_method = "A9B2DEA5074A1FA6B977381EE762FC8C")
    @Override
    public boolean deleteFile(String name) {
        addTaint(name.getTaint());
        boolean varA056F9400684E1AB0C1979E72E321ABB_1979897335 = (mBase.deleteFile(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1537536787 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1537536787;
        // ---------- Original Method ----------
        //return mBase.deleteFile(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.474 -0400", hash_original_method = "41C51E2648C5FE16B28D046D5B54DAAA", hash_generated_method = "AB55708478730C7511F1D7E2D116C791")
    @Override
    public File getFileStreamPath(String name) {
        addTaint(name.getTaint());
File var027FB8FEB8CEEAB5567BEEBFDAE53C40_1734897496 =         mBase.getFileStreamPath(name);
        var027FB8FEB8CEEAB5567BEEBFDAE53C40_1734897496.addTaint(taint);
        return var027FB8FEB8CEEAB5567BEEBFDAE53C40_1734897496;
        // ---------- Original Method ----------
        //return mBase.getFileStreamPath(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.474 -0400", hash_original_method = "7FE19E11982633820D311587FC329BA9", hash_generated_method = "4A259EA5F09BF36E237CA18278204D22")
    @Override
    public String[] fileList() {
String[] var157EF2457324FF8491DE605BB8617635_1055006322 =         mBase.fileList();
        var157EF2457324FF8491DE605BB8617635_1055006322.addTaint(taint);
        return var157EF2457324FF8491DE605BB8617635_1055006322;
        // ---------- Original Method ----------
        //return mBase.fileList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.474 -0400", hash_original_method = "14B449BDD79B281009CCC9DF0F75EC6B", hash_generated_method = "E65D37880C846049A152766349C6C6BA")
    @Override
    public File getFilesDir() {
File varF2FADB399563D1D269193BECAD845418_1792404857 =         mBase.getFilesDir();
        varF2FADB399563D1D269193BECAD845418_1792404857.addTaint(taint);
        return varF2FADB399563D1D269193BECAD845418_1792404857;
        // ---------- Original Method ----------
        //return mBase.getFilesDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.474 -0400", hash_original_method = "BC309698CECF9063C5A4ADDF6C6EC7AF", hash_generated_method = "848F7A4A3A7613FB273AA0A1FC6F78F8")
    @Override
    public File getExternalFilesDir(String type) {
        addTaint(type.getTaint());
File var077416DCEAEB550F87765A85F649EFCF_603272850 =         mBase.getExternalFilesDir(type);
        var077416DCEAEB550F87765A85F649EFCF_603272850.addTaint(taint);
        return var077416DCEAEB550F87765A85F649EFCF_603272850;
        // ---------- Original Method ----------
        //return mBase.getExternalFilesDir(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.475 -0400", hash_original_method = "068174B051BB78F57C468F648940D142", hash_generated_method = "8048B360EDBA5556E3C430FFC9F52E4C")
    @Override
    public File getObbDir() {
File var295ECEB91C0400D7F2A0D868D0A8D0B6_366724385 =         mBase.getObbDir();
        var295ECEB91C0400D7F2A0D868D0A8D0B6_366724385.addTaint(taint);
        return var295ECEB91C0400D7F2A0D868D0A8D0B6_366724385;
        // ---------- Original Method ----------
        //return mBase.getObbDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.475 -0400", hash_original_method = "44DE59125179A0BDED11E57B810BFAF1", hash_generated_method = "E5F3893F3F0CAE06DD3B103C4160C982")
    @Override
    public File getCacheDir() {
File var8A45B00CB25A88AC49713690DA087678_492168655 =         mBase.getCacheDir();
        var8A45B00CB25A88AC49713690DA087678_492168655.addTaint(taint);
        return var8A45B00CB25A88AC49713690DA087678_492168655;
        // ---------- Original Method ----------
        //return mBase.getCacheDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.475 -0400", hash_original_method = "7C2D809316E637C52FE8D4DE0AE386A3", hash_generated_method = "6A12EDDD122E82FCCEEFF0E16EE37129")
    @Override
    public File getExternalCacheDir() {
File varDEBDCE48CEB098BDA05FAAF605206941_1420673384 =         mBase.getExternalCacheDir();
        varDEBDCE48CEB098BDA05FAAF605206941_1420673384.addTaint(taint);
        return varDEBDCE48CEB098BDA05FAAF605206941_1420673384;
        // ---------- Original Method ----------
        //return mBase.getExternalCacheDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.475 -0400", hash_original_method = "A1FD69F0E118B7CAF1C496338AAD4B07", hash_generated_method = "B7D1367488FE0AB7785C8B48AAA68490")
    @Override
    public File getDir(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
File varD632E5C6B0038D67DB2E4A0B5DECF9E7_1428643664 =         mBase.getDir(name, mode);
        varD632E5C6B0038D67DB2E4A0B5DECF9E7_1428643664.addTaint(taint);
        return varD632E5C6B0038D67DB2E4A0B5DECF9E7_1428643664;
        // ---------- Original Method ----------
        //return mBase.getDir(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.475 -0400", hash_original_method = "DDED7E3E0B02F872C2CC1A3BF9DCD873", hash_generated_method = "D8B1FB59717E383626A10334004A246C")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
SQLiteDatabase varB8E18523B77D58562EBFF56A60961FED_914334992 =         mBase.openOrCreateDatabase(name, mode, factory);
        varB8E18523B77D58562EBFF56A60961FED_914334992.addTaint(taint);
        return varB8E18523B77D58562EBFF56A60961FED_914334992;
        // ---------- Original Method ----------
        //return mBase.openOrCreateDatabase(name, mode, factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.476 -0400", hash_original_method = "670C2BACF8B510FB1BD02F583C82D7AC", hash_generated_method = "3D47813DA5290DD601E59EEEBFA12442")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        addTaint(errorHandler.getTaint());
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
SQLiteDatabase var097237F008AD8FB2F6D3A10F81DFE394_1067459044 =         mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
        var097237F008AD8FB2F6D3A10F81DFE394_1067459044.addTaint(taint);
        return var097237F008AD8FB2F6D3A10F81DFE394_1067459044;
        // ---------- Original Method ----------
        //return mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.476 -0400", hash_original_method = "2060E0B3DB8EB041F39B4C3EBCF4134E", hash_generated_method = "67F779119F768E28399D9CE6E02A296D")
    @Override
    public boolean deleteDatabase(String name) {
        addTaint(name.getTaint());
        boolean varC01567A12CDB38AE2A5D9E9A12DB0662_1541331633 = (mBase.deleteDatabase(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1575333271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1575333271;
        // ---------- Original Method ----------
        //return mBase.deleteDatabase(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.476 -0400", hash_original_method = "A01E89BA0EE5F5DE805AF38A996A2059", hash_generated_method = "9791630DA192BB5DBB0BF82EC5828F73")
    @Override
    public File getDatabasePath(String name) {
        addTaint(name.getTaint());
File var71C1048CD82987A9AFA5C47AC5FC7AA1_827707496 =         mBase.getDatabasePath(name);
        var71C1048CD82987A9AFA5C47AC5FC7AA1_827707496.addTaint(taint);
        return var71C1048CD82987A9AFA5C47AC5FC7AA1_827707496;
        // ---------- Original Method ----------
        //return mBase.getDatabasePath(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.476 -0400", hash_original_method = "B3ECD12C5FD290CA7C545491C12B6E0F", hash_generated_method = "DCF41DF90A09A41B04867FABDD86224C")
    @Override
    public String[] databaseList() {
String[] varD7EC4DC557A648709205D012632CA3B8_2132004721 =         mBase.databaseList();
        varD7EC4DC557A648709205D012632CA3B8_2132004721.addTaint(taint);
        return varD7EC4DC557A648709205D012632CA3B8_2132004721;
        // ---------- Original Method ----------
        //return mBase.databaseList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.476 -0400", hash_original_method = "F9E6827CCB2CDD46111FB10DB307E9AE", hash_generated_method = "DF3AF788EADEB258380EF9520149D0FA")
    @Override
    public Drawable getWallpaper() {
Drawable var5A2D53E6B0246B0EFCBBDEA5C0B24CCA_200240886 =         mBase.getWallpaper();
        var5A2D53E6B0246B0EFCBBDEA5C0B24CCA_200240886.addTaint(taint);
        return var5A2D53E6B0246B0EFCBBDEA5C0B24CCA_200240886;
        // ---------- Original Method ----------
        //return mBase.getWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.477 -0400", hash_original_method = "0198388A7C02DAA006719AEF39F3322C", hash_generated_method = "17536E8171F3D4A471BE2EB4700A72CB")
    @Override
    public Drawable peekWallpaper() {
Drawable varF5795CFDDA47D7C8C04AD6D839A0BFDB_360850419 =         mBase.peekWallpaper();
        varF5795CFDDA47D7C8C04AD6D839A0BFDB_360850419.addTaint(taint);
        return varF5795CFDDA47D7C8C04AD6D839A0BFDB_360850419;
        // ---------- Original Method ----------
        //return mBase.peekWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.477 -0400", hash_original_method = "19E21BC09381D0D00BEBE6A5DFBF3F3C", hash_generated_method = "1CC62435512B38AF7C1531B0D0D47032")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int var9EC8F9D2ACA2DBF0A07FBE7ABC00542F_2074265797 = (mBase.getWallpaperDesiredMinimumWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994170268 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994170268;
        // ---------- Original Method ----------
        //return mBase.getWallpaperDesiredMinimumWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.477 -0400", hash_original_method = "3C43E61226EF3145DD8AB1F12075339B", hash_generated_method = "CA23D8A054FC6C58E370D867787C030F")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int varC71999CF10189161372166F7AA625785_1378804095 = (mBase.getWallpaperDesiredMinimumHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652362613 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1652362613;
        // ---------- Original Method ----------
        //return mBase.getWallpaperDesiredMinimumHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.477 -0400", hash_original_method = "A836F480E829D8C861FB92C4C9146FF3", hash_generated_method = "7F34E0DFA5B9D731E4E1C73FF5DDF35D")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        addTaint(bitmap.getTaint());
        mBase.setWallpaper(bitmap);
        // ---------- Original Method ----------
        //mBase.setWallpaper(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.477 -0400", hash_original_method = "D6DB0F01F771FA9EFE610782CC61AF10", hash_generated_method = "DA3C35C533C4D20B5016C1C89D220649")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        addTaint(data.getTaint());
        mBase.setWallpaper(data);
        // ---------- Original Method ----------
        //mBase.setWallpaper(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.477 -0400", hash_original_method = "707333CAD350B1F9359277B8D6F8C031", hash_generated_method = "889EBA665B576D5C1EA97218B0419F62")
    @Override
    public void clearWallpaper() throws IOException {
        mBase.clearWallpaper();
        // ---------- Original Method ----------
        //mBase.clearWallpaper();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.478 -0400", hash_original_method = "130F62140951A945508EBFB32B94A765", hash_generated_method = "6C0DD6BCBBFEDC54885AA9284A0144DE")
    @Override
    public void startActivity(Intent intent) {
        addTaint(intent.getTaint());
        mBase.startActivity(intent);
        // ---------- Original Method ----------
        //mBase.startActivity(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.478 -0400", hash_original_method = "013A3CF6138EA6FE6C22614936FE13C8", hash_generated_method = "7E017BA8ACD6DAB8EB0A9F3851450049")
    @Override
    public void startActivities(Intent[] intents) {
        addTaint(intents[0].getTaint());
        mBase.startActivities(intents);
        // ---------- Original Method ----------
        //mBase.startActivities(intents);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.478 -0400", hash_original_method = "D7C74DA04A5B79EC6630FAD526B70ED6", hash_generated_method = "A632291B20B3DE68B7E953C351EB0FF0")
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        addTaint(extraFlags);
        addTaint(flagsValues);
        addTaint(flagsMask);
        addTaint(fillInIntent.getTaint());
        addTaint(intent.getTaint());
        mBase.startIntentSender(intent, fillInIntent, flagsMask,
                flagsValues, extraFlags);
        // ---------- Original Method ----------
        //mBase.startIntentSender(intent, fillInIntent, flagsMask,
                //flagsValues, extraFlags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.478 -0400", hash_original_method = "CD7D57CF51FEE3E0548133C9C2D084D1", hash_generated_method = "2D4547361562E88556ED9736EB460F84")
    @Override
    public void sendBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        mBase.sendBroadcast(intent);
        // ---------- Original Method ----------
        //mBase.sendBroadcast(intent);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.478 -0400", hash_original_method = "0D532949C3012CD33C142E9B5D03BB61", hash_generated_method = "A8FB3D04861B2339CDAE5E4596923A4A")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        mBase.sendBroadcast(intent, receiverPermission);
        // ---------- Original Method ----------
        //mBase.sendBroadcast(intent, receiverPermission);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.478 -0400", hash_original_method = "F587D697CC21A22CF1C16322E48A38D4", hash_generated_method = "C9C94ADA00BA37E857FAA86E21A31BC7")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        mBase.sendOrderedBroadcast(intent, receiverPermission);
        // ---------- Original Method ----------
        //mBase.sendOrderedBroadcast(intent, receiverPermission);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.479 -0400", hash_original_method = "DEE55BD129D883E4F2F6F72EA9382082", hash_generated_method = "082C177ACFA1C32AABD3FB1FE7240D4E")
    @Override
    public void sendOrderedBroadcast(
        Intent intent, String receiverPermission, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        addTaint(initialExtras.getTaint());
        addTaint(initialData.getTaint());
        addTaint(initialCode);
        addTaint(scheduler.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        mBase.sendOrderedBroadcast(intent, receiverPermission,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
        // ---------- Original Method ----------
        //mBase.sendOrderedBroadcast(intent, receiverPermission,
                //resultReceiver, scheduler, initialCode,
                //initialData, initialExtras);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.479 -0400", hash_original_method = "E4D0FD66C31D49EF8A28B259CA31F5AB", hash_generated_method = "433BD975A8F7FD246F85B9A7F3CA304F")
    @Override
    public void sendStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        mBase.sendStickyBroadcast(intent);
        // ---------- Original Method ----------
        //mBase.sendStickyBroadcast(intent);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.479 -0400", hash_original_method = "7E21CD2A51D6CF22EBBD91300928AE98", hash_generated_method = "A71CA7EDD1C215242F89D9F6DDE7F0F4")
    @Override
    public void sendStickyOrderedBroadcast(
        Intent intent, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        addTaint(initialExtras.getTaint());
        addTaint(initialData.getTaint());
        addTaint(initialCode);
        addTaint(scheduler.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(intent.getTaint());
        mBase.sendStickyOrderedBroadcast(intent,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
        // ---------- Original Method ----------
        //mBase.sendStickyOrderedBroadcast(intent,
                //resultReceiver, scheduler, initialCode,
                //initialData, initialExtras);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.479 -0400", hash_original_method = "F6F4D7B74D392C087E12FF2E322B2B45", hash_generated_method = "BB41DCBD5702AF661DEFFC83F1A9A7E4")
    @Override
    public void removeStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        mBase.removeStickyBroadcast(intent);
        // ---------- Original Method ----------
        //mBase.removeStickyBroadcast(intent);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.480 -0400", hash_original_method = "D33A933E89CAAB59BCB5CB9CA20F9A5A", hash_generated_method = "923C389A61DC51ED4A59E247B9C71440")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent varAAEB1FD17C7C2C043C7061A56E2F4939_1373272444 =         mBase.registerReceiver(receiver, filter);
        varAAEB1FD17C7C2C043C7061A56E2F4939_1373272444.addTaint(taint);
        return varAAEB1FD17C7C2C043C7061A56E2F4939_1373272444;
        // ---------- Original Method ----------
        //return mBase.registerReceiver(receiver, filter);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.480 -0400", hash_original_method = "C498ADCED351E80E96A53362B4745838", hash_generated_method = "65CECE3028FFEFD3F9359F410FD7ABD0")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter,
        String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent var59A1EE21EC52E3621468EDA989E22DE4_78228739 =         mBase.registerReceiver(receiver, filter, broadcastPermission,
                scheduler);
        var59A1EE21EC52E3621468EDA989E22DE4_78228739.addTaint(taint);
        return var59A1EE21EC52E3621468EDA989E22DE4_78228739;
        // ---------- Original Method ----------
        //return mBase.registerReceiver(receiver, filter, broadcastPermission,
                //scheduler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.480 -0400", hash_original_method = "D3936D1C8F9D43BCF113D4D92126FE25", hash_generated_method = "71BAAC8550C712541999819238280518")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        addTaint(receiver.getTaint());
        mBase.unregisterReceiver(receiver);
        // ---------- Original Method ----------
        //mBase.unregisterReceiver(receiver);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.480 -0400", hash_original_method = "460FA5078659EEF29B84A9C36C1BA43F", hash_generated_method = "C0AD90EE4ADA2C801E0D4D8B202724B3")
    @Override
    public ComponentName startService(Intent service) {
        addTaint(service.getTaint());
ComponentName var3735A6AF9994E0412D2412319D7B8378_1651651434 =         mBase.startService(service);
        var3735A6AF9994E0412D2412319D7B8378_1651651434.addTaint(taint);
        return var3735A6AF9994E0412D2412319D7B8378_1651651434;
        // ---------- Original Method ----------
        //return mBase.startService(service);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.480 -0400", hash_original_method = "2538E8D6E7BE6E9AB177EECCCE1CB620", hash_generated_method = "B99488EB56FFA13B09FB6AE09426E27D")
    @Override
    public boolean stopService(Intent name) {
        addTaint(name.getTaint());
        boolean var39629D3681F516448922905A6CE13AFB_391689458 = (mBase.stopService(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1378610887 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1378610887;
        // ---------- Original Method ----------
        //return mBase.stopService(name);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.481 -0400", hash_original_method = "67132A5BC1B8EF0B15B0E872390898A0", hash_generated_method = "74BF1F321FA31B0143A6AA6E85CEB104")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        boolean var0C90BE0BE336E1F418604232563A281D_223131568 = (mBase.bindService(service, conn, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1699384482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1699384482;
        // ---------- Original Method ----------
        //return mBase.bindService(service, conn, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.481 -0400", hash_original_method = "78D7D650BB4D5279C2DB8316AB02503B", hash_generated_method = "84358EC91CF0ACC30367A472E4232FEB")
    @Override
    public void unbindService(ServiceConnection conn) {
        addTaint(conn.getTaint());
        mBase.unbindService(conn);
        // ---------- Original Method ----------
        //mBase.unbindService(conn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.481 -0400", hash_original_method = "093BF17242F85E57BE88B991FC8B0E44", hash_generated_method = "1725DB00F3CE39D449E28FA4462859B1")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        addTaint(arguments.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(className.getTaint());
        boolean var7484A730D276F213FA9C17D958113A5D_897664565 = (mBase.startInstrumentation(className, profileFile, arguments));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1358726353 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1358726353;
        // ---------- Original Method ----------
        //return mBase.startInstrumentation(className, profileFile, arguments);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.481 -0400", hash_original_method = "4DFF381EBA248BD85BCC25FEFAAD92DA", hash_generated_method = "C6C1FF1E499F93F82C167557A7C8A4FA")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
Object varCEE83A4312F10FC75EECB5EAD4E09ED3_380166415 =         mBase.getSystemService(name);
        varCEE83A4312F10FC75EECB5EAD4E09ED3_380166415.addTaint(taint);
        return varCEE83A4312F10FC75EECB5EAD4E09ED3_380166415;
        // ---------- Original Method ----------
        //return mBase.getSystemService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.481 -0400", hash_original_method = "C6E05CB80424200F4C331B8669202D3F", hash_generated_method = "A9BFC040C19B947497BCB83F58BF94BC")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        int var225C5302911F0602FFAEA8401DD39B27_514237095 = (mBase.checkPermission(permission, pid, uid));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1083261138 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1083261138;
        // ---------- Original Method ----------
        //return mBase.checkPermission(permission, pid, uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.482 -0400", hash_original_method = "28B4654D3709544EFD7B7FEA40DBBFF2", hash_generated_method = "715BB2A02FB11B5A5F1C914A27165FB6")
    @Override
    public int checkCallingPermission(String permission) {
        addTaint(permission.getTaint());
        int var4A7B40AB7CD5B1B8F72D9323B100FB29_253236189 = (mBase.checkCallingPermission(permission));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557411652 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1557411652;
        // ---------- Original Method ----------
        //return mBase.checkCallingPermission(permission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.482 -0400", hash_original_method = "284FE3FB34D582E990C725D71B70CDFB", hash_generated_method = "832AE766B488A5A0E614562FBF7C0A30")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        addTaint(permission.getTaint());
        int var0C61C1C30616180086F9A01C06F0D3E7_2062526628 = (mBase.checkCallingOrSelfPermission(permission));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191806693 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_191806693;
        // ---------- Original Method ----------
        //return mBase.checkCallingOrSelfPermission(permission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.482 -0400", hash_original_method = "62A2576537CC71D60C1F63F5056773AE", hash_generated_method = "F1A934CD117933EBD38DA5CB50F82906")
    @Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        addTaint(message.getTaint());
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        mBase.enforcePermission(permission, pid, uid, message);
        // ---------- Original Method ----------
        //mBase.enforcePermission(permission, pid, uid, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.483 -0400", hash_original_method = "81E2CA4E96042AEDAEF02FD92A2A1A67", hash_generated_method = "58C6F23319F7325A68A25455A1DEB6CE")
    @Override
    public void enforceCallingPermission(String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        mBase.enforceCallingPermission(permission, message);
        // ---------- Original Method ----------
        //mBase.enforceCallingPermission(permission, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.483 -0400", hash_original_method = "4C72B3FC5896AFE13143126AEF9E54CC", hash_generated_method = "AB78CED2143E8EFF343398F9E7121FAB")
    @Override
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        mBase.enforceCallingOrSelfPermission(permission, message);
        // ---------- Original Method ----------
        //mBase.enforceCallingOrSelfPermission(permission, message);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.483 -0400", hash_original_method = "C92445D33E31E73A915DF30F0CA49E37", hash_generated_method = "132BCFF17972778D1A25AAD25445FF99")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        addTaint(toPackage.getTaint());
        mBase.grantUriPermission(toPackage, uri, modeFlags);
        // ---------- Original Method ----------
        //mBase.grantUriPermission(toPackage, uri, modeFlags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.483 -0400", hash_original_method = "10A2FB283E31FE469317FAE71C7AF4F8", hash_generated_method = "1679A68408B187F348A87F616C937E3F")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        mBase.revokeUriPermission(uri, modeFlags);
        // ---------- Original Method ----------
        //mBase.revokeUriPermission(uri, modeFlags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.483 -0400", hash_original_method = "F52277BFC8F41FE72798C9E8418C1E24", hash_generated_method = "0C5326789B8A3BF35D53FE854D95C4C6")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        int var8F55548F65F71E2A5461DF44F624EEC9_1801542240 = (mBase.checkUriPermission(uri, pid, uid, modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659285428 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659285428;
        // ---------- Original Method ----------
        //return mBase.checkUriPermission(uri, pid, uid, modeFlags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.484 -0400", hash_original_method = "43D2E9446750BEAA21B381D934BB37A3", hash_generated_method = "B00522BA27F7A0B1F8FA4ECDB6AC78BC")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        int varACB43B79235C3B0DC9433FF0728C1DCF_2103202634 = (mBase.checkCallingUriPermission(uri, modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808404241 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1808404241;
        // ---------- Original Method ----------
        //return mBase.checkCallingUriPermission(uri, modeFlags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.484 -0400", hash_original_method = "4761F75E9F6B51877289AE555068D313", hash_generated_method = "8A59E196F1A4D4BD9595FD46E8EFE145")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        int var85446D6CED60A79A17B56581080F6A79_1772998979 = (mBase.checkCallingOrSelfUriPermission(uri, modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069058373 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2069058373;
        // ---------- Original Method ----------
        //return mBase.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.484 -0400", hash_original_method = "2B7D942FC66EB790715A21C2BF13434D", hash_generated_method = "F755CD1E23C2886681C4A17528EC8B81")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(writePermission.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(uri.getTaint());
        int var681F017BE4BEAE8059B13F24A76E516F_560468128 = (mBase.checkUriPermission(uri, readPermission, writePermission,
                pid, uid, modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974318370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1974318370;
        // ---------- Original Method ----------
        //return mBase.checkUriPermission(uri, readPermission, writePermission,
                //pid, uid, modeFlags);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.484 -0400", hash_original_method = "BB196C48EA062CF760A21CBEDF203044", hash_generated_method = "7C03E4DB56E7305AF6AE41949E41BC7E")
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
        // ---------- Original Method ----------
        //mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.485 -0400", hash_original_method = "B8C6D02BD75567C0C6C58E522F178982", hash_generated_method = "DE6C889E3693A351428610E1ACF6025F")
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        mBase.enforceCallingUriPermission(uri, modeFlags, message);
        // ---------- Original Method ----------
        //mBase.enforceCallingUriPermission(uri, modeFlags, message);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.485 -0400", hash_original_method = "7C2103EAC397ACBBFFA65707A1212FAD", hash_generated_method = "3351654B17DB77690AFE3B21DB48B639")
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
        // ---------- Original Method ----------
        //mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.485 -0400", hash_original_method = "2C0B32E644AD3E21F1765D96680E56CD", hash_generated_method = "CE3F3633A60AF1182BE1E840ED3A323A")
    @Override
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(writePermission.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(uri.getTaint());
        mBase.enforceUriPermission(
                uri, readPermission, writePermission, pid, uid, modeFlags,
                message);
        // ---------- Original Method ----------
        //mBase.enforceUriPermission(
                //uri, readPermission, writePermission, pid, uid, modeFlags,
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.485 -0400", hash_original_method = "B027173E51D2D8A4B1BA8F51741454A2", hash_generated_method = "3C2EEB992E73CDE63F1202B5D42428AC")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        addTaint(flags);
        addTaint(packageName.getTaint());
Context var20C383631F12A3C087EA6F1851C212D7_765471098 =         mBase.createPackageContext(packageName, flags);
        var20C383631F12A3C087EA6F1851C212D7_765471098.addTaint(taint);
        return var20C383631F12A3C087EA6F1851C212D7_765471098;
        // ---------- Original Method ----------
        //return mBase.createPackageContext(packageName, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:00.485 -0400", hash_original_method = "B09C0B118B70B22456444DDECE846C9F", hash_generated_method = "913CE6ABE560E390570B9705FEABD949")
    @Override
    public boolean isRestricted() {
        boolean varA24AECECD71E5C87C380584CAA5E94A0_1404733940 = (mBase.isRestricted());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1717955934 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1717955934;
        // ---------- Original Method ----------
        //return mBase.isRestricted();
    }

    
}

