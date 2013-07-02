package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.333 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "45A1FAFEC6ED7EF70B481175C79188A0")

    Context mBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.333 -0400", hash_original_method = "10030D2DB2A8F36EE12AB3354BCBF9E2", hash_generated_method = "6955E83EDFF1B7CDF47D712DAA27309B")
    public  ContextWrapper(Context base) {
        mBase = base;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.333 -0400", hash_original_method = "C93782FE26B0F4F6F9B761D03AD74E79", hash_generated_method = "830419495511D798B581C6B33978D845")
    protected void attachBaseContext(Context base) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Base context already set");
        } 
        mBase = base;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.334 -0400", hash_original_method = "348D9A1AC27363C49C4D9EF878F36A33", hash_generated_method = "46441EE15FBF9C88869EB43161F36248")
    public Context getBaseContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1214813404 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1214813404 = mBase;
        varB4EAC82CA7396A68D541C85D26508E83_1214813404.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1214813404;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.335 -0400", hash_original_method = "207324BD2179C2BB1CD4C22794703A9D", hash_generated_method = "490EFC6E7FB20111C00B4475FB9246CE")
    @Override
    public AssetManager getAssets() {
        AssetManager varB4EAC82CA7396A68D541C85D26508E83_1779670389 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1779670389 = mBase.getAssets();
        varB4EAC82CA7396A68D541C85D26508E83_1779670389.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1779670389;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.336 -0400", hash_original_method = "47F2A94B0203C279563273E1E0895D4D", hash_generated_method = "D76C36940202084A35E8B6D66332B85D")
    @Override
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1401734568 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1401734568 = mBase.getResources();
        varB4EAC82CA7396A68D541C85D26508E83_1401734568.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1401734568;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.337 -0400", hash_original_method = "D7F633AF602934F61160FEA442625239", hash_generated_method = "6A97D79E1DDC94B251D5CC610A89E78C")
    @Override
    public PackageManager getPackageManager() {
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_1487305744 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1487305744 = mBase.getPackageManager();
        varB4EAC82CA7396A68D541C85D26508E83_1487305744.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1487305744;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.338 -0400", hash_original_method = "8EDC66E2D77BCDC119853EA41EA3296B", hash_generated_method = "03D74F52282237CCB56AAEB64FC76562")
    @Override
    public ContentResolver getContentResolver() {
        ContentResolver varB4EAC82CA7396A68D541C85D26508E83_529834420 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_529834420 = mBase.getContentResolver();
        varB4EAC82CA7396A68D541C85D26508E83_529834420.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_529834420;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.338 -0400", hash_original_method = "7DA68BFFD90B5B26D8702419E8D7FC4A", hash_generated_method = "65A37E65686F880F8EC97145D1B7E56A")
    @Override
    public Looper getMainLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_984392706 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_984392706 = mBase.getMainLooper();
        varB4EAC82CA7396A68D541C85D26508E83_984392706.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_984392706;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.339 -0400", hash_original_method = "78E13438476D4B526B3AB7AB982B9A37", hash_generated_method = "24630ECA50AA829A874C61715B3F22E2")
    @Override
    public Context getApplicationContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_458643876 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_458643876 = mBase.getApplicationContext();
        varB4EAC82CA7396A68D541C85D26508E83_458643876.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_458643876;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.339 -0400", hash_original_method = "52BC053E8452DD327B93F4A2F04B45DF", hash_generated_method = "19056A297577ED342A61F2F713A8D74B")
    @Override
    public void setTheme(int resid) {
        mBase.setTheme(resid);
        addTaint(resid);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.339 -0400", hash_original_method = "735F7E922A6884F691E7980C19D30ED9", hash_generated_method = "C9D38AD725DCFEA9CC934FE7079A0A7A")
    @Override
    public int getThemeResId() {
        int var7AC95F797AB08594A077B70F1A8CCEE7_619859122 = (mBase.getThemeResId());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827637523 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_827637523;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.340 -0400", hash_original_method = "A934E0879ABB06742AB01E1FAB54A9BF", hash_generated_method = "787D64CE7AA6B1FB9D4B9DD75C72762E")
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_639498350 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_639498350 = mBase.getTheme();
        varB4EAC82CA7396A68D541C85D26508E83_639498350.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_639498350;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.341 -0400", hash_original_method = "325690D530E21A0AB255EE9D69D84488", hash_generated_method = "4EDA11690A8126898B52D174AC6005D9")
    @Override
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1875450556 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1875450556 = mBase.getClassLoader();
        varB4EAC82CA7396A68D541C85D26508E83_1875450556.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1875450556;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.341 -0400", hash_original_method = "FC1F671DB2DE2D2F1C64463A96604F21", hash_generated_method = "5C77571D61F105836263EABC713AF023")
    @Override
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1164230137 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1164230137 = mBase.getPackageName();
        varB4EAC82CA7396A68D541C85D26508E83_1164230137.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1164230137;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.342 -0400", hash_original_method = "12EA4F448AA17744DA817E2FDC985059", hash_generated_method = "D427E95E2A091417E81ED004DA80899A")
    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_900504775 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_900504775 = mBase.getApplicationInfo();
        varB4EAC82CA7396A68D541C85D26508E83_900504775.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_900504775;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.342 -0400", hash_original_method = "1456FB2C70424875587B348EBED7BEBD", hash_generated_method = "7394B977B32815E0086381424DBB259C")
    @Override
    public String getPackageResourcePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1623357037 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1623357037 = mBase.getPackageResourcePath();
        varB4EAC82CA7396A68D541C85D26508E83_1623357037.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1623357037;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.343 -0400", hash_original_method = "90ECA4CEE907B9CC4828D0F1EDEE17EB", hash_generated_method = "3DF2A6A42FB3DEA2BC10B56CF78D10F7")
    @Override
    public String getPackageCodePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_890074275 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_890074275 = mBase.getPackageCodePath();
        varB4EAC82CA7396A68D541C85D26508E83_890074275.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_890074275;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.343 -0400", hash_original_method = "49CEDB82FC58CDF70EFA8B7A21272CFA", hash_generated_method = "76FFBEEC3A7F1A4414CB8E08A30B35B0")
    @Override
    public File getSharedPrefsFile(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1159444976 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1159444976 = mBase.getSharedPrefsFile(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1159444976.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1159444976;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.344 -0400", hash_original_method = "51168DD8811589A8A44258F7BDA9D1F0", hash_generated_method = "9A2277E92991FF4D1E693774C63C18DB")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_737558870 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_737558870 = mBase.getSharedPreferences(name, mode);
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_737558870.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_737558870;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.344 -0400", hash_original_method = "744F22B41784C38DFA56BA635287A3F7", hash_generated_method = "B0E5AEA9B0927E545FEFA391DAB2B670")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_1646062329 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1646062329 = mBase.openFileInput(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1646062329.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1646062329;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.345 -0400", hash_original_method = "1B551CEA36C6304276D435BC90F14FD3", hash_generated_method = "D30FE1881F9321C7F79AF54EA965CBA2")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_429707002 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_429707002 = mBase.openFileOutput(name, mode);
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_429707002.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_429707002;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.346 -0400", hash_original_method = "A1313161ACDE2AAD1A9AEF7D9E6B717D", hash_generated_method = "66AACA51892930C899F8ECAC2B8127F4")
    @Override
    public boolean deleteFile(String name) {
        boolean var14AF3FE5F23FD23E2C2EAF5A63873DB5_2006074364 = (mBase.deleteFile(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1351445933 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1351445933;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.346 -0400", hash_original_method = "41C51E2648C5FE16B28D046D5B54DAAA", hash_generated_method = "A2AB2BD8C230CD738C449F2E611587C6")
    @Override
    public File getFileStreamPath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1659345233 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1659345233 = mBase.getFileStreamPath(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1659345233.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1659345233;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.348 -0400", hash_original_method = "7FE19E11982633820D311587FC329BA9", hash_generated_method = "8A1898678C7D16720922EE52D94B284F")
    @Override
    public String[] fileList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1852807883 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1852807883 = mBase.fileList();
        varB4EAC82CA7396A68D541C85D26508E83_1852807883.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1852807883;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.349 -0400", hash_original_method = "14B449BDD79B281009CCC9DF0F75EC6B", hash_generated_method = "1924A64743B86936BE24859F2AD4970C")
    @Override
    public File getFilesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1955993664 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1955993664 = mBase.getFilesDir();
        varB4EAC82CA7396A68D541C85D26508E83_1955993664.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1955993664;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.350 -0400", hash_original_method = "BC309698CECF9063C5A4ADDF6C6EC7AF", hash_generated_method = "08A7E345E20F0E55CAFA8208B35DE2BA")
    @Override
    public File getExternalFilesDir(String type) {
        File varB4EAC82CA7396A68D541C85D26508E83_286058867 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_286058867 = mBase.getExternalFilesDir(type);
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_286058867.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_286058867;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.351 -0400", hash_original_method = "068174B051BB78F57C468F648940D142", hash_generated_method = "58DED816A6CA02612678197812153F12")
    @Override
    public File getObbDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_555427746 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_555427746 = mBase.getObbDir();
        varB4EAC82CA7396A68D541C85D26508E83_555427746.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_555427746;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.351 -0400", hash_original_method = "44DE59125179A0BDED11E57B810BFAF1", hash_generated_method = "2BE594588878C35896BCBA6A279CA0E3")
    @Override
    public File getCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_456788408 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_456788408 = mBase.getCacheDir();
        varB4EAC82CA7396A68D541C85D26508E83_456788408.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_456788408;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.352 -0400", hash_original_method = "7C2D809316E637C52FE8D4DE0AE386A3", hash_generated_method = "6C3A03DD6CC73C010D61CA5DCF92D487")
    @Override
    public File getExternalCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_624395131 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_624395131 = mBase.getExternalCacheDir();
        varB4EAC82CA7396A68D541C85D26508E83_624395131.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_624395131;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.353 -0400", hash_original_method = "A1FD69F0E118B7CAF1C496338AAD4B07", hash_generated_method = "0BAE0EACB7ABEC249A65598A4D640009")
    @Override
    public File getDir(String name, int mode) {
        File varB4EAC82CA7396A68D541C85D26508E83_2079068286 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2079068286 = mBase.getDir(name, mode);
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_2079068286.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2079068286;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.353 -0400", hash_original_method = "DDED7E3E0B02F872C2CC1A3BF9DCD873", hash_generated_method = "5B1C3B327E5B847C30E2580FB0524231")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_46684774 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_46684774 = mBase.openOrCreateDatabase(name, mode, factory);
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_46684774.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_46684774;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.354 -0400", hash_original_method = "670C2BACF8B510FB1BD02F583C82D7AC", hash_generated_method = "73C36964D9B8650AF5068A9D7E27112D")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1130494108 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1130494108 = mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        addTaint(errorHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1130494108.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1130494108;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.354 -0400", hash_original_method = "2060E0B3DB8EB041F39B4C3EBCF4134E", hash_generated_method = "0B536D3D261E079A8000882A21A60D08")
    @Override
    public boolean deleteDatabase(String name) {
        boolean var1201E6487C2E2ECBC3C1937591CAB600_289407683 = (mBase.deleteDatabase(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1748889355 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1748889355;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.355 -0400", hash_original_method = "A01E89BA0EE5F5DE805AF38A996A2059", hash_generated_method = "296F37B661334AC035FD42734113E843")
    @Override
    public File getDatabasePath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1971677051 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1971677051 = mBase.getDatabasePath(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1971677051.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1971677051;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.356 -0400", hash_original_method = "B3ECD12C5FD290CA7C545491C12B6E0F", hash_generated_method = "FDFCD48EC7CEBD703D0227F1737527E5")
    @Override
    public String[] databaseList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_815785610 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_815785610 = mBase.databaseList();
        varB4EAC82CA7396A68D541C85D26508E83_815785610.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_815785610;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.357 -0400", hash_original_method = "F9E6827CCB2CDD46111FB10DB307E9AE", hash_generated_method = "3354F58B3A4899EA8905AE5A57715BE7")
    @Override
    public Drawable getWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1669025391 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1669025391 = mBase.getWallpaper();
        varB4EAC82CA7396A68D541C85D26508E83_1669025391.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1669025391;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.359 -0400", hash_original_method = "0198388A7C02DAA006719AEF39F3322C", hash_generated_method = "505E82567721A72E501823044D0E9A30")
    @Override
    public Drawable peekWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_850657403 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_850657403 = mBase.peekWallpaper();
        varB4EAC82CA7396A68D541C85D26508E83_850657403.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_850657403;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.359 -0400", hash_original_method = "19E21BC09381D0D00BEBE6A5DFBF3F3C", hash_generated_method = "4CCD51FEE00124EB6AFCFF14991A284D")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varAADE4DC8942D82E82A9B42B92539E4A5_1945560724 = (mBase.getWallpaperDesiredMinimumWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930335144 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_930335144;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.360 -0400", hash_original_method = "3C43E61226EF3145DD8AB1F12075339B", hash_generated_method = "08F2F55DFDBE497857D459EEB47A0D23")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int varB7C2E2DEB0713543A3A0442CBAC5C5E5_302544377 = (mBase.getWallpaperDesiredMinimumHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1891967398 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1891967398;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.360 -0400", hash_original_method = "A836F480E829D8C861FB92C4C9146FF3", hash_generated_method = "29609FD6B8C29E9017BF7A70D11E4BA5")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        mBase.setWallpaper(bitmap);
        addTaint(bitmap.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.361 -0400", hash_original_method = "D6DB0F01F771FA9EFE610782CC61AF10", hash_generated_method = "A00D4A05242A2609F4276F20EC7C7215")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        mBase.setWallpaper(data);
        addTaint(data.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.361 -0400", hash_original_method = "707333CAD350B1F9359277B8D6F8C031", hash_generated_method = "889EBA665B576D5C1EA97218B0419F62")
    @Override
    public void clearWallpaper() throws IOException {
        mBase.clearWallpaper();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.361 -0400", hash_original_method = "130F62140951A945508EBFB32B94A765", hash_generated_method = "62AAAED4ACC557D655EDC63D9EAEB40E")
    @Override
    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
        addTaint(intent.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.362 -0400", hash_original_method = "013A3CF6138EA6FE6C22614936FE13C8", hash_generated_method = "4D0E24B8AE70C1442FE4BE7D99F8C648")
    @Override
    public void startActivities(Intent[] intents) {
        mBase.startActivities(intents);
        addTaint(intents[0].getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.362 -0400", hash_original_method = "D7C74DA04A5B79EC6630FAD526B70ED6", hash_generated_method = "BBB4C39151A919F17ABCE701C3C3D454")
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        mBase.startIntentSender(intent, fillInIntent, flagsMask,
                flagsValues, extraFlags);
        addTaint(intent.getTaint());
        addTaint(fillInIntent.getTaint());
        addTaint(flagsMask);
        addTaint(flagsValues);
        addTaint(extraFlags);
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.363 -0400", hash_original_method = "CD7D57CF51FEE3E0548133C9C2D084D1", hash_generated_method = "DF436B25EE9858154A53ABB5BBD74144")
    @Override
    public void sendBroadcast(Intent intent) {
        mBase.sendBroadcast(intent);
        addTaint(intent.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.363 -0400", hash_original_method = "0D532949C3012CD33C142E9B5D03BB61", hash_generated_method = "C7957C2C16C4D287950DCEC8F01AF14E")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        mBase.sendBroadcast(intent, receiverPermission);
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.363 -0400", hash_original_method = "F587D697CC21A22CF1C16322E48A38D4", hash_generated_method = "B17BA21F6A62780A5F382E8F01F821D7")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        mBase.sendOrderedBroadcast(intent, receiverPermission);
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.364 -0400", hash_original_method = "DEE55BD129D883E4F2F6F72EA9382082", hash_generated_method = "E4F17E79198D332D480471F8BBF02654")
    @Override
    public void sendOrderedBroadcast(
        Intent intent, String receiverPermission, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        mBase.sendOrderedBroadcast(intent, receiverPermission,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(initialCode);
        addTaint(initialData.getTaint());
        addTaint(initialExtras.getTaint());
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.364 -0400", hash_original_method = "E4D0FD66C31D49EF8A28B259CA31F5AB", hash_generated_method = "208249676EB91C33023CC4E83970E1C3")
    @Override
    public void sendStickyBroadcast(Intent intent) {
        mBase.sendStickyBroadcast(intent);
        addTaint(intent.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.364 -0400", hash_original_method = "7E21CD2A51D6CF22EBBD91300928AE98", hash_generated_method = "3CC4B1BA5B8B5402E0E30FBC8B888360")
    @Override
    public void sendStickyOrderedBroadcast(
        Intent intent, BroadcastReceiver resultReceiver,
        Handler scheduler, int initialCode, String initialData,
        Bundle initialExtras) {
        mBase.sendStickyOrderedBroadcast(intent,
                resultReceiver, scheduler, initialCode,
                initialData, initialExtras);
        addTaint(intent.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(scheduler.getTaint());
        addTaint(initialCode);
        addTaint(initialData.getTaint());
        addTaint(initialExtras.getTaint());
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.365 -0400", hash_original_method = "F6F4D7B74D392C087E12FF2E322B2B45", hash_generated_method = "561A50ABB21DDB79A5A5B26853811B57")
    @Override
    public void removeStickyBroadcast(Intent intent) {
        mBase.removeStickyBroadcast(intent);
        addTaint(intent.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.366 -0400", hash_original_method = "D33A933E89CAAB59BCB5CB9CA20F9A5A", hash_generated_method = "7468796F792CF06FC1C16F0EBFD77AEB")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter) {
        
        Intent varB4EAC82CA7396A68D541C85D26508E83_1643191998 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1643191998 = mBase.registerReceiver(receiver, filter);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1643191998.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1643191998;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.367 -0400", hash_original_method = "C498ADCED351E80E96A53362B4745838", hash_generated_method = "63FC4B016D996072BD7290BAA0964CBF")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter,
        String broadcastPermission, Handler scheduler) {
        
        Intent varB4EAC82CA7396A68D541C85D26508E83_1429404446 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1429404446 = mBase.registerReceiver(receiver, filter, broadcastPermission,
                scheduler);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1429404446.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1429404446;
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.368 -0400", hash_original_method = "D3936D1C8F9D43BCF113D4D92126FE25", hash_generated_method = "C7F4D152B844D3A60A2D11365AF2D135")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        mBase.unregisterReceiver(receiver);
        addTaint(receiver.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.370 -0400", hash_original_method = "460FA5078659EEF29B84A9C36C1BA43F", hash_generated_method = "84C7D6F1EE095CDD1FC82EF991CEFB02")
    @Override
    public ComponentName startService(Intent service) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_251175330 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_251175330 = mBase.startService(service);
        addTaint(service.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_251175330.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_251175330;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.370 -0400", hash_original_method = "2538E8D6E7BE6E9AB177EECCCE1CB620", hash_generated_method = "B8DB21F39A8A88AADE9AB24853B1BA6D")
    @Override
    public boolean stopService(Intent name) {
        boolean var79E09432295B6E81E775BAA1429D1742_1807168415 = (mBase.stopService(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144360592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_144360592;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.371 -0400", hash_original_method = "67132A5BC1B8EF0B15B0E872390898A0", hash_generated_method = "94E596A39FD6E962BC58307813CF9876")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        boolean varB449E6D6F4ECBAA56F7BEB7D0560F07C_216076779 = (mBase.bindService(service, conn, flags));
        addTaint(service.getTaint());
        addTaint(conn.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1545778392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1545778392;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.371 -0400", hash_original_method = "78D7D650BB4D5279C2DB8316AB02503B", hash_generated_method = "88ECDEB32CB302DE14C0AB46C55CB216")
    @Override
    public void unbindService(ServiceConnection conn) {
        mBase.unbindService(conn);
        addTaint(conn.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.372 -0400", hash_original_method = "093BF17242F85E57BE88B991FC8B0E44", hash_generated_method = "1114AAD849E551C06F884B1ABE2F9F14")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        boolean var7847DE7C5C74BB7E9D8EF837B1629B88_1073725168 = (mBase.startInstrumentation(className, profileFile, arguments));
        addTaint(className.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(arguments.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1925914823 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1925914823;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.372 -0400", hash_original_method = "4DFF381EBA248BD85BCC25FEFAAD92DA", hash_generated_method = "6158BE5D37894D769D2699C90885D038")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_30848929 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_30848929 = mBase.getSystemService(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_30848929.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_30848929;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.373 -0400", hash_original_method = "C6E05CB80424200F4C331B8669202D3F", hash_generated_method = "0AAAE6CEAA00AA59ADCA14025162D2D2")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        int var0B5D93936231AC00BB3EB885AB5DD216_1529314373 = (mBase.checkPermission(permission, pid, uid));
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848392731 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1848392731;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.373 -0400", hash_original_method = "28B4654D3709544EFD7B7FEA40DBBFF2", hash_generated_method = "4C85806209BA96B4775DA2FCCA627F56")
    @Override
    public int checkCallingPermission(String permission) {
        int var085AD305D9EE5D54D148F8FAB5BCD242_114692283 = (mBase.checkCallingPermission(permission));
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502120898 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502120898;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.373 -0400", hash_original_method = "284FE3FB34D582E990C725D71B70CDFB", hash_generated_method = "956926FB32590BC52450ED3940552F18")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        int var74DBDAA10225909C76130339398AA057_358602802 = (mBase.checkCallingOrSelfPermission(permission));
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1697701205 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1697701205;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.374 -0400", hash_original_method = "62A2576537CC71D60C1F63F5056773AE", hash_generated_method = "16349EBC41A0322EA1F5E68BE2786F56")
    @Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        mBase.enforcePermission(permission, pid, uid, message);
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.374 -0400", hash_original_method = "81E2CA4E96042AEDAEF02FD92A2A1A67", hash_generated_method = "8F247BF1A6D61B7A66A9D1F302C830DF")
    @Override
    public void enforceCallingPermission(String permission, String message) {
        mBase.enforceCallingPermission(permission, message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.375 -0400", hash_original_method = "4C72B3FC5896AFE13143126AEF9E54CC", hash_generated_method = "5C0CA4B6861C808C1FA619ACECF93698")
    @Override
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        mBase.enforceCallingOrSelfPermission(permission, message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.375 -0400", hash_original_method = "C92445D33E31E73A915DF30F0CA49E37", hash_generated_method = "1C1C4E2392CA1194F861BDAFBE26F8B2")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        mBase.grantUriPermission(toPackage, uri, modeFlags);
        addTaint(toPackage.getTaint());
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.376 -0400", hash_original_method = "10A2FB283E31FE469317FAE71C7AF4F8", hash_generated_method = "DDA7A03F0D7F1B67FF43E6BF3FB30C34")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        mBase.revokeUriPermission(uri, modeFlags);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.376 -0400", hash_original_method = "F52277BFC8F41FE72798C9E8418C1E24", hash_generated_method = "A5C7FCA615091E285D8A0156E13369D4")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        int var4BA59D5FCB145B56552A926363D08843_920106504 = (mBase.checkUriPermission(uri, pid, uid, modeFlags));
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364606756 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364606756;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.377 -0400", hash_original_method = "43D2E9446750BEAA21B381D934BB37A3", hash_generated_method = "BADCE497B295F3A4D8D088C5DA6C406C")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        int var32F95911BC4A7B4DB8535C3F25E383D2_1889157344 = (mBase.checkCallingUriPermission(uri, modeFlags));
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027160683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2027160683;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.378 -0400", hash_original_method = "4761F75E9F6B51877289AE555068D313", hash_generated_method = "FA93E7C20AEC28CBA0192F52E25C2B42")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        int varBF497F120043DE15F7549BECCC4FD74C_1324446176 = (mBase.checkCallingOrSelfUriPermission(uri, modeFlags));
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_703687878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_703687878;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.379 -0400", hash_original_method = "2B7D942FC66EB790715A21C2BF13434D", hash_generated_method = "CCC8AE2740312BC8D36376B86F4A4B57")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        int varE86989A776CE237B6A5E3024ADB23E65_1614607574 = (mBase.checkUriPermission(uri, readPermission, writePermission,
                pid, uid, modeFlags));
        addTaint(uri.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(writePermission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285428213 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285428213;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.380 -0400", hash_original_method = "BB196C48EA062CF760A21CBEDF203044", hash_generated_method = "C19668AEF19ADBEBE20272BBE12D41DC")
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        addTaint(message.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.380 -0400", hash_original_method = "B8C6D02BD75567C0C6C58E522F178982", hash_generated_method = "A8DFA3792740A27D7BF9C198BEFB9BCE")
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        mBase.enforceCallingUriPermission(uri, modeFlags, message);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        addTaint(message.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.381 -0400", hash_original_method = "7C2103EAC397ACBBFFA65707A1212FAD", hash_generated_method = "77FC3FEEA9D917A25DC053156E1DABE9")
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        addTaint(message.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.381 -0400", hash_original_method = "2C0B32E644AD3E21F1765D96680E56CD", hash_generated_method = "8806D23503F6B4A14BED74832F1CADD8")
    @Override
    public void enforceUriPermission(
            Uri uri, String readPermission, String writePermission,
            int pid, int uid, int modeFlags, String message) {
        mBase.enforceUriPermission(
                uri, readPermission, writePermission, pid, uid, modeFlags,
                message);
        addTaint(uri.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(writePermission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        addTaint(message.getTaint());
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.382 -0400", hash_original_method = "B027173E51D2D8A4B1BA8F51741454A2", hash_generated_method = "CC65A59B7CCE12F83196FDAFCD319252")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context varB4EAC82CA7396A68D541C85D26508E83_121808814 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_121808814 = mBase.createPackageContext(packageName, flags);
        addTaint(packageName.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_121808814.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_121808814;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:23.383 -0400", hash_original_method = "B09C0B118B70B22456444DDECE846C9F", hash_generated_method = "D33E3C286643D84B0D95F827D0AA4A9C")
    @Override
    public boolean isRestricted() {
        boolean var5B1D49D9F4C840BADBDE433A4848080A_1178550336 = (mBase.isRestricted());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355607752 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355607752;
        
        
    }

    
}

