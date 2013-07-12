package android.content;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.095 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "45A1FAFEC6ED7EF70B481175C79188A0")

    Context mBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.096 -0400", hash_original_method = "10030D2DB2A8F36EE12AB3354BCBF9E2", hash_generated_method = "6955E83EDFF1B7CDF47D712DAA27309B")
    public  ContextWrapper(Context base) {
        mBase = base;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.096 -0400", hash_original_method = "C93782FE26B0F4F6F9B761D03AD74E79", hash_generated_method = "066905D89BDC055A650C0005D1012740")
    protected void attachBaseContext(Context base) {
    if(mBase != null)        
        {
            IllegalStateException var66C5824069E0964DC69656CAA57B8B9F_927334478 = new IllegalStateException("Base context already set");
            var66C5824069E0964DC69656CAA57B8B9F_927334478.addTaint(taint);
            throw var66C5824069E0964DC69656CAA57B8B9F_927334478;
        } 
        mBase = base;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.097 -0400", hash_original_method = "348D9A1AC27363C49C4D9EF878F36A33", hash_generated_method = "526E349042DB87E698E97A52C04E6A1E")
    public Context getBaseContext() {
Context varA148490A8BFC4E02B4B251DB8934259F_1512515247 =         mBase;
        varA148490A8BFC4E02B4B251DB8934259F_1512515247.addTaint(taint);
        return varA148490A8BFC4E02B4B251DB8934259F_1512515247;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.097 -0400", hash_original_method = "207324BD2179C2BB1CD4C22794703A9D", hash_generated_method = "CD883A99750493DE03A22D74A453CB4C")
    @Override
    public AssetManager getAssets() {
AssetManager var76C3CF86EE6D54B30C36C32803928372_988831513 =         mBase.getAssets();
        var76C3CF86EE6D54B30C36C32803928372_988831513.addTaint(taint);
        return var76C3CF86EE6D54B30C36C32803928372_988831513;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.097 -0400", hash_original_method = "47F2A94B0203C279563273E1E0895D4D", hash_generated_method = "9344764D9D8C4E55E56B44645843FC2F")
    @Override
    public Resources getResources() {
Resources varC0A9C6BE038D35ACBF64CA430137389B_1800566200 =         mBase.getResources();
        varC0A9C6BE038D35ACBF64CA430137389B_1800566200.addTaint(taint);
        return varC0A9C6BE038D35ACBF64CA430137389B_1800566200;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.098 -0400", hash_original_method = "D7F633AF602934F61160FEA442625239", hash_generated_method = "10B2F21C661441EC908FAA4B45070000")
    @Override
    public PackageManager getPackageManager() {
PackageManager var2460232D63BA9F10997363947D615C09_175595636 =         mBase.getPackageManager();
        var2460232D63BA9F10997363947D615C09_175595636.addTaint(taint);
        return var2460232D63BA9F10997363947D615C09_175595636;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.098 -0400", hash_original_method = "8EDC66E2D77BCDC119853EA41EA3296B", hash_generated_method = "8F0F883DDF778116DC2F12DE90F21FE1")
    @Override
    public ContentResolver getContentResolver() {
ContentResolver var00D3C554E0AB15EA09A7796CA11174FA_1854027769 =         mBase.getContentResolver();
        var00D3C554E0AB15EA09A7796CA11174FA_1854027769.addTaint(taint);
        return var00D3C554E0AB15EA09A7796CA11174FA_1854027769;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.098 -0400", hash_original_method = "7DA68BFFD90B5B26D8702419E8D7FC4A", hash_generated_method = "5B8173A7F23B77402574C9566C18E845")
    @Override
    public Looper getMainLooper() {
Looper var08A834780F62DEFB0CC11359A8BF5D1E_637031569 =         mBase.getMainLooper();
        var08A834780F62DEFB0CC11359A8BF5D1E_637031569.addTaint(taint);
        return var08A834780F62DEFB0CC11359A8BF5D1E_637031569;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.100 -0400", hash_original_method = "78E13438476D4B526B3AB7AB982B9A37", hash_generated_method = "D4FF684C45A05F48D6BB12374BE59DB8")
    @Override
    public Context getApplicationContext() {
Context var297DFF380BA41D2B4D2B12F4EF189288_579452063 =         mBase.getApplicationContext();
        var297DFF380BA41D2B4D2B12F4EF189288_579452063.addTaint(taint);
        return var297DFF380BA41D2B4D2B12F4EF189288_579452063;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.101 -0400", hash_original_method = "52BC053E8452DD327B93F4A2F04B45DF", hash_generated_method = "B7B90D860BAF2521927315B295359630")
    @Override
    public void setTheme(int resid) {
        addTaint(resid);
        mBase.setTheme(resid);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.102 -0400", hash_original_method = "735F7E922A6884F691E7980C19D30ED9", hash_generated_method = "B59C989D3A3F95372195977A2A8B4CC8")
    @Override
    public int getThemeResId() {
        int var694ACEAE2EB299A90303D08BF5923279_1561710635 = (mBase.getThemeResId());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422457082 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1422457082;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.103 -0400", hash_original_method = "A934E0879ABB06742AB01E1FAB54A9BF", hash_generated_method = "C4672051942DF0C1ECEDA7AC7F7E7A33")
    @Override
    public Resources.Theme getTheme() {
Resources.Theme var76B6B77AD887645DC7839F859C86DB3B_2122336811 =         mBase.getTheme();
        var76B6B77AD887645DC7839F859C86DB3B_2122336811.addTaint(taint);
        return var76B6B77AD887645DC7839F859C86DB3B_2122336811;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.103 -0400", hash_original_method = "325690D530E21A0AB255EE9D69D84488", hash_generated_method = "B04E6E0C0E09B4E871218F0DFCFE9B7D")
    @Override
    public ClassLoader getClassLoader() {
ClassLoader varA8807F3BF816B843E87ECF72F437B526_545859320 =         mBase.getClassLoader();
        varA8807F3BF816B843E87ECF72F437B526_545859320.addTaint(taint);
        return varA8807F3BF816B843E87ECF72F437B526_545859320;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.104 -0400", hash_original_method = "FC1F671DB2DE2D2F1C64463A96604F21", hash_generated_method = "1FAF83CC4CE58D09F493A6A3B54F96D9")
    @Override
    public String getPackageName() {
String varCC969730AEDAE2CF8E546E89D9BA5651_45307614 =         mBase.getPackageName();
        varCC969730AEDAE2CF8E546E89D9BA5651_45307614.addTaint(taint);
        return varCC969730AEDAE2CF8E546E89D9BA5651_45307614;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.104 -0400", hash_original_method = "12EA4F448AA17744DA817E2FDC985059", hash_generated_method = "8EC99FCC8F6C8D429AD4FA8668432818")
    @Override
    public ApplicationInfo getApplicationInfo() {
ApplicationInfo var5A440309FC948E478F14554A984E3988_467298648 =         mBase.getApplicationInfo();
        var5A440309FC948E478F14554A984E3988_467298648.addTaint(taint);
        return var5A440309FC948E478F14554A984E3988_467298648;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.104 -0400", hash_original_method = "1456FB2C70424875587B348EBED7BEBD", hash_generated_method = "E31F9535CE563CF788D927E5A9154A54")
    @Override
    public String getPackageResourcePath() {
String varF7B3E0E6C53211CB95758CA5835079A9_105841666 =         mBase.getPackageResourcePath();
        varF7B3E0E6C53211CB95758CA5835079A9_105841666.addTaint(taint);
        return varF7B3E0E6C53211CB95758CA5835079A9_105841666;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.105 -0400", hash_original_method = "90ECA4CEE907B9CC4828D0F1EDEE17EB", hash_generated_method = "63803ED123C330A508CD92C74BB5F141")
    @Override
    public String getPackageCodePath() {
String var3FBCA4B17D2D1E884408A8469AF743F1_901841560 =         mBase.getPackageCodePath();
        var3FBCA4B17D2D1E884408A8469AF743F1_901841560.addTaint(taint);
        return var3FBCA4B17D2D1E884408A8469AF743F1_901841560;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.105 -0400", hash_original_method = "49CEDB82FC58CDF70EFA8B7A21272CFA", hash_generated_method = "83E24604D275E6EC8A2C301749C1E7C6")
    @Override
    public File getSharedPrefsFile(String name) {
        addTaint(name.getTaint());
File varCEC3785B29BF636922E886A7D1379E30_413335080 =         mBase.getSharedPrefsFile(name);
        varCEC3785B29BF636922E886A7D1379E30_413335080.addTaint(taint);
        return varCEC3785B29BF636922E886A7D1379E30_413335080;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.106 -0400", hash_original_method = "51168DD8811589A8A44258F7BDA9D1F0", hash_generated_method = "A6E2EAF224CF66EC8262172AAF16C310")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
SharedPreferences varA54C5E6B915CFF7C92731136C531E733_948584785 =         mBase.getSharedPreferences(name, mode);
        varA54C5E6B915CFF7C92731136C531E733_948584785.addTaint(taint);
        return varA54C5E6B915CFF7C92731136C531E733_948584785;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.106 -0400", hash_original_method = "744F22B41784C38DFA56BA635287A3F7", hash_generated_method = "033E91088D7A77A7E6D190360D026B78")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        addTaint(name.getTaint());
FileInputStream varA1D772851A48D51218F8D32143265657_345837757 =         mBase.openFileInput(name);
        varA1D772851A48D51218F8D32143265657_345837757.addTaint(taint);
        return varA1D772851A48D51218F8D32143265657_345837757;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.107 -0400", hash_original_method = "1B551CEA36C6304276D435BC90F14FD3", hash_generated_method = "C7A9338A859673E7470075CF9F762BFC")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        addTaint(mode);
        addTaint(name.getTaint());
FileOutputStream varFFB8432828FDF9D378486365E66D6F43_1608459833 =         mBase.openFileOutput(name, mode);
        varFFB8432828FDF9D378486365E66D6F43_1608459833.addTaint(taint);
        return varFFB8432828FDF9D378486365E66D6F43_1608459833;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.107 -0400", hash_original_method = "A1313161ACDE2AAD1A9AEF7D9E6B717D", hash_generated_method = "7C3BA5EF0E1989CC0FAB3A56BDAFFFA5")
    @Override
    public boolean deleteFile(String name) {
        addTaint(name.getTaint());
        boolean varA056F9400684E1AB0C1979E72E321ABB_1784594274 = (mBase.deleteFile(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_571049053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_571049053;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.107 -0400", hash_original_method = "41C51E2648C5FE16B28D046D5B54DAAA", hash_generated_method = "091B822062C8E1EDDAE43A704460C47C")
    @Override
    public File getFileStreamPath(String name) {
        addTaint(name.getTaint());
File var027FB8FEB8CEEAB5567BEEBFDAE53C40_411589596 =         mBase.getFileStreamPath(name);
        var027FB8FEB8CEEAB5567BEEBFDAE53C40_411589596.addTaint(taint);
        return var027FB8FEB8CEEAB5567BEEBFDAE53C40_411589596;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.108 -0400", hash_original_method = "7FE19E11982633820D311587FC329BA9", hash_generated_method = "8E1642C312E125E66DB63633BF071CD2")
    @Override
    public String[] fileList() {
String[] var157EF2457324FF8491DE605BB8617635_1565245910 =         mBase.fileList();
        var157EF2457324FF8491DE605BB8617635_1565245910.addTaint(taint);
        return var157EF2457324FF8491DE605BB8617635_1565245910;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.108 -0400", hash_original_method = "14B449BDD79B281009CCC9DF0F75EC6B", hash_generated_method = "7B91C223016C0E52BE12B7D7F9156C3A")
    @Override
    public File getFilesDir() {
File varF2FADB399563D1D269193BECAD845418_1863960964 =         mBase.getFilesDir();
        varF2FADB399563D1D269193BECAD845418_1863960964.addTaint(taint);
        return varF2FADB399563D1D269193BECAD845418_1863960964;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.109 -0400", hash_original_method = "BC309698CECF9063C5A4ADDF6C6EC7AF", hash_generated_method = "6C677092860ACEF59767CE29EED8AD5E")
    @Override
    public File getExternalFilesDir(String type) {
        addTaint(type.getTaint());
File var077416DCEAEB550F87765A85F649EFCF_779740390 =         mBase.getExternalFilesDir(type);
        var077416DCEAEB550F87765A85F649EFCF_779740390.addTaint(taint);
        return var077416DCEAEB550F87765A85F649EFCF_779740390;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.110 -0400", hash_original_method = "068174B051BB78F57C468F648940D142", hash_generated_method = "44867EDC5B46C32F9B327F6A494C7D7C")
    @Override
    public File getObbDir() {
File var295ECEB91C0400D7F2A0D868D0A8D0B6_441639565 =         mBase.getObbDir();
        var295ECEB91C0400D7F2A0D868D0A8D0B6_441639565.addTaint(taint);
        return var295ECEB91C0400D7F2A0D868D0A8D0B6_441639565;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.110 -0400", hash_original_method = "44DE59125179A0BDED11E57B810BFAF1", hash_generated_method = "22FE35D0B72E68F6253CEC3AC80AD986")
    @Override
    public File getCacheDir() {
File var8A45B00CB25A88AC49713690DA087678_1450969313 =         mBase.getCacheDir();
        var8A45B00CB25A88AC49713690DA087678_1450969313.addTaint(taint);
        return var8A45B00CB25A88AC49713690DA087678_1450969313;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.110 -0400", hash_original_method = "7C2D809316E637C52FE8D4DE0AE386A3", hash_generated_method = "1B34486DE52FCF03BFEDE4DAC0AE534F")
    @Override
    public File getExternalCacheDir() {
File varDEBDCE48CEB098BDA05FAAF605206941_1960128016 =         mBase.getExternalCacheDir();
        varDEBDCE48CEB098BDA05FAAF605206941_1960128016.addTaint(taint);
        return varDEBDCE48CEB098BDA05FAAF605206941_1960128016;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.111 -0400", hash_original_method = "A1FD69F0E118B7CAF1C496338AAD4B07", hash_generated_method = "561447C95CCDB8A6A7A682D07287BAEC")
    @Override
    public File getDir(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
File varD632E5C6B0038D67DB2E4A0B5DECF9E7_1930045383 =         mBase.getDir(name, mode);
        varD632E5C6B0038D67DB2E4A0B5DECF9E7_1930045383.addTaint(taint);
        return varD632E5C6B0038D67DB2E4A0B5DECF9E7_1930045383;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.112 -0400", hash_original_method = "DDED7E3E0B02F872C2CC1A3BF9DCD873", hash_generated_method = "9E683AAB0E18727C8769225627B8EB80")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
SQLiteDatabase varB8E18523B77D58562EBFF56A60961FED_333920359 =         mBase.openOrCreateDatabase(name, mode, factory);
        varB8E18523B77D58562EBFF56A60961FED_333920359.addTaint(taint);
        return varB8E18523B77D58562EBFF56A60961FED_333920359;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.113 -0400", hash_original_method = "670C2BACF8B510FB1BD02F583C82D7AC", hash_generated_method = "C05D6C8C5E6D0B47164DC1FE5F6F260D")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        addTaint(errorHandler.getTaint());
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
SQLiteDatabase var097237F008AD8FB2F6D3A10F81DFE394_813039712 =         mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
        var097237F008AD8FB2F6D3A10F81DFE394_813039712.addTaint(taint);
        return var097237F008AD8FB2F6D3A10F81DFE394_813039712;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.114 -0400", hash_original_method = "2060E0B3DB8EB041F39B4C3EBCF4134E", hash_generated_method = "4BE060C2344C7A6E2C787CB31316FCC9")
    @Override
    public boolean deleteDatabase(String name) {
        addTaint(name.getTaint());
        boolean varC01567A12CDB38AE2A5D9E9A12DB0662_1353819980 = (mBase.deleteDatabase(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_334249082 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_334249082;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.114 -0400", hash_original_method = "A01E89BA0EE5F5DE805AF38A996A2059", hash_generated_method = "86FB87F2A4B1DD117CA40991B197C0BC")
    @Override
    public File getDatabasePath(String name) {
        addTaint(name.getTaint());
File var71C1048CD82987A9AFA5C47AC5FC7AA1_2123368129 =         mBase.getDatabasePath(name);
        var71C1048CD82987A9AFA5C47AC5FC7AA1_2123368129.addTaint(taint);
        return var71C1048CD82987A9AFA5C47AC5FC7AA1_2123368129;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.114 -0400", hash_original_method = "B3ECD12C5FD290CA7C545491C12B6E0F", hash_generated_method = "C59FA1181482E67C24CBB30A54807132")
    @Override
    public String[] databaseList() {
String[] varD7EC4DC557A648709205D012632CA3B8_2072281074 =         mBase.databaseList();
        varD7EC4DC557A648709205D012632CA3B8_2072281074.addTaint(taint);
        return varD7EC4DC557A648709205D012632CA3B8_2072281074;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.115 -0400", hash_original_method = "F9E6827CCB2CDD46111FB10DB307E9AE", hash_generated_method = "5CCBD4E866E0009A398201E567D41772")
    @Override
    public Drawable getWallpaper() {
Drawable var5A2D53E6B0246B0EFCBBDEA5C0B24CCA_87569521 =         mBase.getWallpaper();
        var5A2D53E6B0246B0EFCBBDEA5C0B24CCA_87569521.addTaint(taint);
        return var5A2D53E6B0246B0EFCBBDEA5C0B24CCA_87569521;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.115 -0400", hash_original_method = "0198388A7C02DAA006719AEF39F3322C", hash_generated_method = "ACDD068ABF234C53B868D61111B207A7")
    @Override
    public Drawable peekWallpaper() {
Drawable varF5795CFDDA47D7C8C04AD6D839A0BFDB_1736030033 =         mBase.peekWallpaper();
        varF5795CFDDA47D7C8C04AD6D839A0BFDB_1736030033.addTaint(taint);
        return varF5795CFDDA47D7C8C04AD6D839A0BFDB_1736030033;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.116 -0400", hash_original_method = "19E21BC09381D0D00BEBE6A5DFBF3F3C", hash_generated_method = "C27C3E888823C0CE9B045EB5521EDA1D")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int var9EC8F9D2ACA2DBF0A07FBE7ABC00542F_2331800 = (mBase.getWallpaperDesiredMinimumWidth());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_688749983 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_688749983;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.116 -0400", hash_original_method = "3C43E61226EF3145DD8AB1F12075339B", hash_generated_method = "A5CE37E1108323A4A65B9FCD3AC30132")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int varC71999CF10189161372166F7AA625785_1871449646 = (mBase.getWallpaperDesiredMinimumHeight());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577866682 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577866682;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.116 -0400", hash_original_method = "A836F480E829D8C861FB92C4C9146FF3", hash_generated_method = "7F34E0DFA5B9D731E4E1C73FF5DDF35D")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        addTaint(bitmap.getTaint());
        mBase.setWallpaper(bitmap);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.117 -0400", hash_original_method = "D6DB0F01F771FA9EFE610782CC61AF10", hash_generated_method = "DA3C35C533C4D20B5016C1C89D220649")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        addTaint(data.getTaint());
        mBase.setWallpaper(data);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.117 -0400", hash_original_method = "707333CAD350B1F9359277B8D6F8C031", hash_generated_method = "889EBA665B576D5C1EA97218B0419F62")
    @Override
    public void clearWallpaper() throws IOException {
        mBase.clearWallpaper();
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.117 -0400", hash_original_method = "130F62140951A945508EBFB32B94A765", hash_generated_method = "6C0DD6BCBBFEDC54885AA9284A0144DE")
    @Override
    public void startActivity(Intent intent) {
        addTaint(intent.getTaint());
        mBase.startActivity(intent);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.118 -0400", hash_original_method = "013A3CF6138EA6FE6C22614936FE13C8", hash_generated_method = "7E017BA8ACD6DAB8EB0A9F3851450049")
    @Override
    public void startActivities(Intent[] intents) {
        addTaint(intents[0].getTaint());
        mBase.startActivities(intents);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.118 -0400", hash_original_method = "D7C74DA04A5B79EC6630FAD526B70ED6", hash_generated_method = "A632291B20B3DE68B7E953C351EB0FF0")
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
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.118 -0400", hash_original_method = "CD7D57CF51FEE3E0548133C9C2D084D1", hash_generated_method = "2D4547361562E88556ED9736EB460F84")
    @Override
    public void sendBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        mBase.sendBroadcast(intent);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.119 -0400", hash_original_method = "0D532949C3012CD33C142E9B5D03BB61", hash_generated_method = "A8FB3D04861B2339CDAE5E4596923A4A")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        mBase.sendBroadcast(intent, receiverPermission);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.119 -0400", hash_original_method = "F587D697CC21A22CF1C16322E48A38D4", hash_generated_method = "C9C94ADA00BA37E857FAA86E21A31BC7")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        mBase.sendOrderedBroadcast(intent, receiverPermission);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.120 -0400", hash_original_method = "DEE55BD129D883E4F2F6F72EA9382082", hash_generated_method = "082C177ACFA1C32AABD3FB1FE7240D4E")
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
        
        
                
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.120 -0400", hash_original_method = "E4D0FD66C31D49EF8A28B259CA31F5AB", hash_generated_method = "433BD975A8F7FD246F85B9A7F3CA304F")
    @Override
    public void sendStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        mBase.sendStickyBroadcast(intent);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.121 -0400", hash_original_method = "7E21CD2A51D6CF22EBBD91300928AE98", hash_generated_method = "A71CA7EDD1C215242F89D9F6DDE7F0F4")
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
        
        
                
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.121 -0400", hash_original_method = "F6F4D7B74D392C087E12FF2E322B2B45", hash_generated_method = "BB41DCBD5702AF661DEFFC83F1A9A7E4")
    @Override
    public void removeStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        mBase.removeStickyBroadcast(intent);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.122 -0400", hash_original_method = "D33A933E89CAAB59BCB5CB9CA20F9A5A", hash_generated_method = "9E3FAE62FAAB1243C426756B6F93F385")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter) {
        
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent varAAEB1FD17C7C2C043C7061A56E2F4939_1592084704 =         mBase.registerReceiver(receiver, filter);
        varAAEB1FD17C7C2C043C7061A56E2F4939_1592084704.addTaint(taint);
        return varAAEB1FD17C7C2C043C7061A56E2F4939_1592084704;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.122 -0400", hash_original_method = "C498ADCED351E80E96A53362B4745838", hash_generated_method = "7B7783EC1051F09D68D997082DBFA54F")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter,
        String broadcastPermission, Handler scheduler) {
        
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
Intent var59A1EE21EC52E3621468EDA989E22DE4_1112668110 =         mBase.registerReceiver(receiver, filter, broadcastPermission,
                scheduler);
        var59A1EE21EC52E3621468EDA989E22DE4_1112668110.addTaint(taint);
        return var59A1EE21EC52E3621468EDA989E22DE4_1112668110;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.123 -0400", hash_original_method = "D3936D1C8F9D43BCF113D4D92126FE25", hash_generated_method = "71BAAC8550C712541999819238280518")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        addTaint(receiver.getTaint());
        mBase.unregisterReceiver(receiver);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.123 -0400", hash_original_method = "460FA5078659EEF29B84A9C36C1BA43F", hash_generated_method = "DF84EAD3CC9618C064C57B2ABAED1091")
    @Override
    public ComponentName startService(Intent service) {
        addTaint(service.getTaint());
ComponentName var3735A6AF9994E0412D2412319D7B8378_1315187816 =         mBase.startService(service);
        var3735A6AF9994E0412D2412319D7B8378_1315187816.addTaint(taint);
        return var3735A6AF9994E0412D2412319D7B8378_1315187816;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.123 -0400", hash_original_method = "2538E8D6E7BE6E9AB177EECCCE1CB620", hash_generated_method = "83144571358D607A4863707AB807BA88")
    @Override
    public boolean stopService(Intent name) {
        addTaint(name.getTaint());
        boolean var39629D3681F516448922905A6CE13AFB_1481277645 = (mBase.stopService(name));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1731590484 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1731590484;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.124 -0400", hash_original_method = "67132A5BC1B8EF0B15B0E872390898A0", hash_generated_method = "046F545F87BBD35B604C5F5B33AD3582")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        boolean var0C90BE0BE336E1F418604232563A281D_1775050025 = (mBase.bindService(service, conn, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_607539041 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_607539041;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.124 -0400", hash_original_method = "78D7D650BB4D5279C2DB8316AB02503B", hash_generated_method = "84358EC91CF0ACC30367A472E4232FEB")
    @Override
    public void unbindService(ServiceConnection conn) {
        addTaint(conn.getTaint());
        mBase.unbindService(conn);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.125 -0400", hash_original_method = "093BF17242F85E57BE88B991FC8B0E44", hash_generated_method = "DBD0A4587DCBF325640CA6B0D381CEC6")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        addTaint(arguments.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(className.getTaint());
        boolean var7484A730D276F213FA9C17D958113A5D_1922267064 = (mBase.startInstrumentation(className, profileFile, arguments));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_124331522 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_124331522;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.125 -0400", hash_original_method = "4DFF381EBA248BD85BCC25FEFAAD92DA", hash_generated_method = "4983651793390ED495EF7AC7C89EACB4")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
Object varCEE83A4312F10FC75EECB5EAD4E09ED3_1196453580 =         mBase.getSystemService(name);
        varCEE83A4312F10FC75EECB5EAD4E09ED3_1196453580.addTaint(taint);
        return varCEE83A4312F10FC75EECB5EAD4E09ED3_1196453580;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.125 -0400", hash_original_method = "C6E05CB80424200F4C331B8669202D3F", hash_generated_method = "274719DDFC823C1BB5CBC04E1399A299")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        int var225C5302911F0602FFAEA8401DD39B27_945134728 = (mBase.checkPermission(permission, pid, uid));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215431266 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_215431266;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.126 -0400", hash_original_method = "28B4654D3709544EFD7B7FEA40DBBFF2", hash_generated_method = "A08EDD2B784620B99AD03D4DDCD3678D")
    @Override
    public int checkCallingPermission(String permission) {
        addTaint(permission.getTaint());
        int var4A7B40AB7CD5B1B8F72D9323B100FB29_969955717 = (mBase.checkCallingPermission(permission));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132506781 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2132506781;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.126 -0400", hash_original_method = "284FE3FB34D582E990C725D71B70CDFB", hash_generated_method = "90FA77D71E252B618A0042B1A10D2EDE")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        addTaint(permission.getTaint());
        int var0C61C1C30616180086F9A01C06F0D3E7_411664526 = (mBase.checkCallingOrSelfPermission(permission));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359116369 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359116369;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.127 -0400", hash_original_method = "62A2576537CC71D60C1F63F5056773AE", hash_generated_method = "F1A934CD117933EBD38DA5CB50F82906")
    @Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        addTaint(message.getTaint());
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        mBase.enforcePermission(permission, pid, uid, message);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.127 -0400", hash_original_method = "81E2CA4E96042AEDAEF02FD92A2A1A67", hash_generated_method = "58C6F23319F7325A68A25455A1DEB6CE")
    @Override
    public void enforceCallingPermission(String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        mBase.enforceCallingPermission(permission, message);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.127 -0400", hash_original_method = "4C72B3FC5896AFE13143126AEF9E54CC", hash_generated_method = "AB78CED2143E8EFF343398F9E7121FAB")
    @Override
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        mBase.enforceCallingOrSelfPermission(permission, message);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.128 -0400", hash_original_method = "C92445D33E31E73A915DF30F0CA49E37", hash_generated_method = "132BCFF17972778D1A25AAD25445FF99")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        addTaint(toPackage.getTaint());
        mBase.grantUriPermission(toPackage, uri, modeFlags);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.128 -0400", hash_original_method = "10A2FB283E31FE469317FAE71C7AF4F8", hash_generated_method = "1679A68408B187F348A87F616C937E3F")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        mBase.revokeUriPermission(uri, modeFlags);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.129 -0400", hash_original_method = "F52277BFC8F41FE72798C9E8418C1E24", hash_generated_method = "4340D7FC38C4770DED9FF3F4BCC9A04C")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        int var8F55548F65F71E2A5461DF44F624EEC9_1403587014 = (mBase.checkUriPermission(uri, pid, uid, modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243860103 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243860103;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.133 -0400", hash_original_method = "43D2E9446750BEAA21B381D934BB37A3", hash_generated_method = "A6AEF7DB6914888ECB63D32432101608")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        int varACB43B79235C3B0DC9433FF0728C1DCF_37460114 = (mBase.checkCallingUriPermission(uri, modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594238910 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594238910;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.134 -0400", hash_original_method = "4761F75E9F6B51877289AE555068D313", hash_generated_method = "6194C0764CC0102C41DF0956BADBAEAF")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        int var85446D6CED60A79A17B56581080F6A79_320657377 = (mBase.checkCallingOrSelfUriPermission(uri, modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106379123 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2106379123;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.137 -0400", hash_original_method = "2B7D942FC66EB790715A21C2BF13434D", hash_generated_method = "F0998A30BC18E11B4149625B9C7B5D73")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(writePermission.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(uri.getTaint());
        int var681F017BE4BEAE8059B13F24A76E516F_1352936406 = (mBase.checkUriPermission(uri, readPermission, writePermission,
                pid, uid, modeFlags));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49120339 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_49120339;
        
        
                
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.139 -0400", hash_original_method = "BB196C48EA062CF760A21CBEDF203044", hash_generated_method = "7C03E4DB56E7305AF6AE41949E41BC7E")
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.139 -0400", hash_original_method = "B8C6D02BD75567C0C6C58E522F178982", hash_generated_method = "DE6C889E3693A351428610E1ACF6025F")
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        mBase.enforceCallingUriPermission(uri, modeFlags, message);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.140 -0400", hash_original_method = "7C2103EAC397ACBBFFA65707A1212FAD", hash_generated_method = "3351654B17DB77690AFE3B21DB48B639")
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.141 -0400", hash_original_method = "2C0B32E644AD3E21F1765D96680E56CD", hash_generated_method = "CE3F3633A60AF1182BE1E840ED3A323A")
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
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.141 -0400", hash_original_method = "B027173E51D2D8A4B1BA8F51741454A2", hash_generated_method = "D43A6D4F84FD04FED016CE671C817D5A")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        addTaint(flags);
        addTaint(packageName.getTaint());
Context var20C383631F12A3C087EA6F1851C212D7_778061249 =         mBase.createPackageContext(packageName, flags);
        var20C383631F12A3C087EA6F1851C212D7_778061249.addTaint(taint);
        return var20C383631F12A3C087EA6F1851C212D7_778061249;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:09.142 -0400", hash_original_method = "B09C0B118B70B22456444DDECE846C9F", hash_generated_method = "41AC99D6A2D9F1B4ACC01D4974225E66")
    @Override
    public boolean isRestricted() {
        boolean varA24AECECD71E5C87C380584CAA5E94A0_1675730576 = (mBase.isRestricted());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2069298907 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2069298907;
        
        
    }

    
}

