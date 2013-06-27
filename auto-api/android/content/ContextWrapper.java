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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.378 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "45A1FAFEC6ED7EF70B481175C79188A0")

    Context mBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.390 -0400", hash_original_method = "10030D2DB2A8F36EE12AB3354BCBF9E2", hash_generated_method = "6955E83EDFF1B7CDF47D712DAA27309B")
    public  ContextWrapper(Context base) {
        mBase = base;
        // ---------- Original Method ----------
        //mBase = base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.392 -0400", hash_original_method = "C93782FE26B0F4F6F9B761D03AD74E79", hash_generated_method = "830419495511D798B581C6B33978D845")
    protected void attachBaseContext(Context base) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Base context already set");
        } //End block
        mBase = base;
        // ---------- Original Method ----------
        //if (mBase != null) {
            //throw new IllegalStateException("Base context already set");
        //}
        //mBase = base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.393 -0400", hash_original_method = "348D9A1AC27363C49C4D9EF878F36A33", hash_generated_method = "B15F3D6E12D12EE69EEB2BF07BDF4814")
    public Context getBaseContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_104893096 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_104893096 = mBase;
        varB4EAC82CA7396A68D541C85D26508E83_104893096.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_104893096;
        // ---------- Original Method ----------
        //return mBase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.398 -0400", hash_original_method = "207324BD2179C2BB1CD4C22794703A9D", hash_generated_method = "BF6BDE7EE260AB1264B8AC409E44BE84")
    @Override
    public AssetManager getAssets() {
        AssetManager varB4EAC82CA7396A68D541C85D26508E83_1046547946 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1046547946 = mBase.getAssets();
        varB4EAC82CA7396A68D541C85D26508E83_1046547946.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1046547946;
        // ---------- Original Method ----------
        //return mBase.getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.402 -0400", hash_original_method = "47F2A94B0203C279563273E1E0895D4D", hash_generated_method = "7980C78FDAF032DDC64DC749BECE2D51")
    @Override
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_95898892 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_95898892 = mBase.getResources();
        varB4EAC82CA7396A68D541C85D26508E83_95898892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_95898892;
        // ---------- Original Method ----------
        //return mBase.getResources();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.418 -0400", hash_original_method = "D7F633AF602934F61160FEA442625239", hash_generated_method = "8A1751A28F233C33472EA964145EB165")
    @Override
    public PackageManager getPackageManager() {
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_216682091 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_216682091 = mBase.getPackageManager();
        varB4EAC82CA7396A68D541C85D26508E83_216682091.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_216682091;
        // ---------- Original Method ----------
        //return mBase.getPackageManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.427 -0400", hash_original_method = "8EDC66E2D77BCDC119853EA41EA3296B", hash_generated_method = "6383AD99F81344B15AF36EA36B1050EC")
    @Override
    public ContentResolver getContentResolver() {
        ContentResolver varB4EAC82CA7396A68D541C85D26508E83_2012751876 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2012751876 = mBase.getContentResolver();
        varB4EAC82CA7396A68D541C85D26508E83_2012751876.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2012751876;
        // ---------- Original Method ----------
        //return mBase.getContentResolver();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.428 -0400", hash_original_method = "7DA68BFFD90B5B26D8702419E8D7FC4A", hash_generated_method = "9F9DCC848BCECC1C2D95613C419C585B")
    @Override
    public Looper getMainLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_1400676815 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1400676815 = mBase.getMainLooper();
        varB4EAC82CA7396A68D541C85D26508E83_1400676815.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1400676815;
        // ---------- Original Method ----------
        //return mBase.getMainLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.433 -0400", hash_original_method = "78E13438476D4B526B3AB7AB982B9A37", hash_generated_method = "E450419BCD44E3E242F172F25D6658D9")
    @Override
    public Context getApplicationContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_1287698053 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1287698053 = mBase.getApplicationContext();
        varB4EAC82CA7396A68D541C85D26508E83_1287698053.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1287698053;
        // ---------- Original Method ----------
        //return mBase.getApplicationContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.434 -0400", hash_original_method = "52BC053E8452DD327B93F4A2F04B45DF", hash_generated_method = "19056A297577ED342A61F2F713A8D74B")
    @Override
    public void setTheme(int resid) {
        mBase.setTheme(resid);
        addTaint(resid);
        // ---------- Original Method ----------
        //mBase.setTheme(resid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.435 -0400", hash_original_method = "735F7E922A6884F691E7980C19D30ED9", hash_generated_method = "10C04B4ABCE2301537497E568E6CADFD")
    @Override
    public int getThemeResId() {
        int var7AC95F797AB08594A077B70F1A8CCEE7_951831301 = (mBase.getThemeResId());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355362684 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355362684;
        // ---------- Original Method ----------
        //return mBase.getThemeResId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.452 -0400", hash_original_method = "A934E0879ABB06742AB01E1FAB54A9BF", hash_generated_method = "3019724E7CA312EA1297311F89F064D2")
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_1137713162 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1137713162 = mBase.getTheme();
        varB4EAC82CA7396A68D541C85D26508E83_1137713162.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1137713162;
        // ---------- Original Method ----------
        //return mBase.getTheme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.455 -0400", hash_original_method = "325690D530E21A0AB255EE9D69D84488", hash_generated_method = "965F79F9E4F30A71F5E80E4250CCA54B")
    @Override
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_244166990 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_244166990 = mBase.getClassLoader();
        varB4EAC82CA7396A68D541C85D26508E83_244166990.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_244166990;
        // ---------- Original Method ----------
        //return mBase.getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.496 -0400", hash_original_method = "FC1F671DB2DE2D2F1C64463A96604F21", hash_generated_method = "8BDD0C77658F05280C169217F152895C")
    @Override
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_693191403 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_693191403 = mBase.getPackageName();
        varB4EAC82CA7396A68D541C85D26508E83_693191403.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_693191403;
        // ---------- Original Method ----------
        //return mBase.getPackageName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.497 -0400", hash_original_method = "12EA4F448AA17744DA817E2FDC985059", hash_generated_method = "1493EB60FD22F9CEE81E5B2A9F0BE0B0")
    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_1716883954 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1716883954 = mBase.getApplicationInfo();
        varB4EAC82CA7396A68D541C85D26508E83_1716883954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1716883954;
        // ---------- Original Method ----------
        //return mBase.getApplicationInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.502 -0400", hash_original_method = "1456FB2C70424875587B348EBED7BEBD", hash_generated_method = "DBF41BCAF778A6A0684DB000B2EA4E9A")
    @Override
    public String getPackageResourcePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_2005879590 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2005879590 = mBase.getPackageResourcePath();
        varB4EAC82CA7396A68D541C85D26508E83_2005879590.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2005879590;
        // ---------- Original Method ----------
        //return mBase.getPackageResourcePath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.526 -0400", hash_original_method = "90ECA4CEE907B9CC4828D0F1EDEE17EB", hash_generated_method = "BE3D19B4F125538B01BFE8AFDB20B8A3")
    @Override
    public String getPackageCodePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_437551929 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_437551929 = mBase.getPackageCodePath();
        varB4EAC82CA7396A68D541C85D26508E83_437551929.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_437551929;
        // ---------- Original Method ----------
        //return mBase.getPackageCodePath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.531 -0400", hash_original_method = "49CEDB82FC58CDF70EFA8B7A21272CFA", hash_generated_method = "5E9BCAD6223D2FECC7550DAC9EA2BD2B")
    @Override
    public File getSharedPrefsFile(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_176408555 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_176408555 = mBase.getSharedPrefsFile(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_176408555.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_176408555;
        // ---------- Original Method ----------
        //return mBase.getSharedPrefsFile(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.537 -0400", hash_original_method = "51168DD8811589A8A44258F7BDA9D1F0", hash_generated_method = "E11862E35027E01BD50E52155C68F4C7")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1213902926 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1213902926 = mBase.getSharedPreferences(name, mode);
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1213902926.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1213902926;
        // ---------- Original Method ----------
        //return mBase.getSharedPreferences(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.555 -0400", hash_original_method = "744F22B41784C38DFA56BA635287A3F7", hash_generated_method = "8CB755868F45734FA83DF99C64E0B712")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_725908767 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_725908767 = mBase.openFileInput(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_725908767.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_725908767;
        // ---------- Original Method ----------
        //return mBase.openFileInput(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.561 -0400", hash_original_method = "1B551CEA36C6304276D435BC90F14FD3", hash_generated_method = "369A465873CC6B6BBE324C13E7041F68")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_541261493 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_541261493 = mBase.openFileOutput(name, mode);
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_541261493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_541261493;
        // ---------- Original Method ----------
        //return mBase.openFileOutput(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.586 -0400", hash_original_method = "A1313161ACDE2AAD1A9AEF7D9E6B717D", hash_generated_method = "9407A994655AE7EB24C2FF616A1479EF")
    @Override
    public boolean deleteFile(String name) {
        boolean var14AF3FE5F23FD23E2C2EAF5A63873DB5_1630921665 = (mBase.deleteFile(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_42134645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_42134645;
        // ---------- Original Method ----------
        //return mBase.deleteFile(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.590 -0400", hash_original_method = "41C51E2648C5FE16B28D046D5B54DAAA", hash_generated_method = "60491A6645FBB31A4C433009A21E2D48")
    @Override
    public File getFileStreamPath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1478699749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1478699749 = mBase.getFileStreamPath(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1478699749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1478699749;
        // ---------- Original Method ----------
        //return mBase.getFileStreamPath(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.591 -0400", hash_original_method = "7FE19E11982633820D311587FC329BA9", hash_generated_method = "5D9A9D226F67F5B9A5BBCC928CF4A065")
    @Override
    public String[] fileList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_1696509814 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1696509814 = mBase.fileList();
        varB4EAC82CA7396A68D541C85D26508E83_1696509814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1696509814;
        // ---------- Original Method ----------
        //return mBase.fileList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.597 -0400", hash_original_method = "14B449BDD79B281009CCC9DF0F75EC6B", hash_generated_method = "281D6965F8E9F78832C345898356B4AE")
    @Override
    public File getFilesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1366418888 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1366418888 = mBase.getFilesDir();
        varB4EAC82CA7396A68D541C85D26508E83_1366418888.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1366418888;
        // ---------- Original Method ----------
        //return mBase.getFilesDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.598 -0400", hash_original_method = "BC309698CECF9063C5A4ADDF6C6EC7AF", hash_generated_method = "7C3EC464C78F76747010E30F094FBCC9")
    @Override
    public File getExternalFilesDir(String type) {
        File varB4EAC82CA7396A68D541C85D26508E83_1814964075 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1814964075 = mBase.getExternalFilesDir(type);
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1814964075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1814964075;
        // ---------- Original Method ----------
        //return mBase.getExternalFilesDir(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.658 -0400", hash_original_method = "068174B051BB78F57C468F648940D142", hash_generated_method = "9EEEBAE10DB64FEDF9F392D780C4F3D1")
    @Override
    public File getObbDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1291215526 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1291215526 = mBase.getObbDir();
        varB4EAC82CA7396A68D541C85D26508E83_1291215526.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1291215526;
        // ---------- Original Method ----------
        //return mBase.getObbDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.660 -0400", hash_original_method = "44DE59125179A0BDED11E57B810BFAF1", hash_generated_method = "138FC656DCE3DD8778A6B3310AD737E4")
    @Override
    public File getCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_189113265 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_189113265 = mBase.getCacheDir();
        varB4EAC82CA7396A68D541C85D26508E83_189113265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_189113265;
        // ---------- Original Method ----------
        //return mBase.getCacheDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.680 -0400", hash_original_method = "7C2D809316E637C52FE8D4DE0AE386A3", hash_generated_method = "ED1F3339E252FF36F354B90A848563C6")
    @Override
    public File getExternalCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_734516649 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_734516649 = mBase.getExternalCacheDir();
        varB4EAC82CA7396A68D541C85D26508E83_734516649.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_734516649;
        // ---------- Original Method ----------
        //return mBase.getExternalCacheDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.681 -0400", hash_original_method = "A1FD69F0E118B7CAF1C496338AAD4B07", hash_generated_method = "141354B3460C40E18B1AA9ADB6B2AA74")
    @Override
    public File getDir(String name, int mode) {
        File varB4EAC82CA7396A68D541C85D26508E83_850277032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_850277032 = mBase.getDir(name, mode);
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_850277032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_850277032;
        // ---------- Original Method ----------
        //return mBase.getDir(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.683 -0400", hash_original_method = "DDED7E3E0B02F872C2CC1A3BF9DCD873", hash_generated_method = "D95F71449E7E293A5111102911DB3375")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1745964311 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1745964311 = mBase.openOrCreateDatabase(name, mode, factory);
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1745964311.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1745964311;
        // ---------- Original Method ----------
        //return mBase.openOrCreateDatabase(name, mode, factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.693 -0400", hash_original_method = "670C2BACF8B510FB1BD02F583C82D7AC", hash_generated_method = "FFE94C38579B81019DC6382B31C6BA96")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_2138356646 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2138356646 = mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        addTaint(errorHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2138356646.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2138356646;
        // ---------- Original Method ----------
        //return mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.697 -0400", hash_original_method = "2060E0B3DB8EB041F39B4C3EBCF4134E", hash_generated_method = "E6BB000437C87DC61825E93BB298E255")
    @Override
    public boolean deleteDatabase(String name) {
        boolean var1201E6487C2E2ECBC3C1937591CAB600_1155580985 = (mBase.deleteDatabase(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_905160490 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_905160490;
        // ---------- Original Method ----------
        //return mBase.deleteDatabase(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.717 -0400", hash_original_method = "A01E89BA0EE5F5DE805AF38A996A2059", hash_generated_method = "A27160EA435951FBF4048D8CE354B0E3")
    @Override
    public File getDatabasePath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1032004624 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1032004624 = mBase.getDatabasePath(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1032004624.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1032004624;
        // ---------- Original Method ----------
        //return mBase.getDatabasePath(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.720 -0400", hash_original_method = "B3ECD12C5FD290CA7C545491C12B6E0F", hash_generated_method = "22CCF53C567F3C7E37B7201D38335BBC")
    @Override
    public String[] databaseList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_659457444 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_659457444 = mBase.databaseList();
        varB4EAC82CA7396A68D541C85D26508E83_659457444.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_659457444;
        // ---------- Original Method ----------
        //return mBase.databaseList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.727 -0400", hash_original_method = "F9E6827CCB2CDD46111FB10DB307E9AE", hash_generated_method = "9AD177329879D36BB27E0CD765391E66")
    @Override
    public Drawable getWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_2127573587 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2127573587 = mBase.getWallpaper();
        varB4EAC82CA7396A68D541C85D26508E83_2127573587.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2127573587;
        // ---------- Original Method ----------
        //return mBase.getWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.741 -0400", hash_original_method = "0198388A7C02DAA006719AEF39F3322C", hash_generated_method = "01F8F45D50D75EF909C4D7AD116719F4")
    @Override
    public Drawable peekWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_860072432 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_860072432 = mBase.peekWallpaper();
        varB4EAC82CA7396A68D541C85D26508E83_860072432.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_860072432;
        // ---------- Original Method ----------
        //return mBase.peekWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.742 -0400", hash_original_method = "19E21BC09381D0D00BEBE6A5DFBF3F3C", hash_generated_method = "F5248F34316F8171ECB645FF4AE978A8")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varAADE4DC8942D82E82A9B42B92539E4A5_386491616 = (mBase.getWallpaperDesiredMinimumWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439790252 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1439790252;
        // ---------- Original Method ----------
        //return mBase.getWallpaperDesiredMinimumWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.743 -0400", hash_original_method = "3C43E61226EF3145DD8AB1F12075339B", hash_generated_method = "CABA5E6928C4070C3ADA7715EF9F2852")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int varB7C2E2DEB0713543A3A0442CBAC5C5E5_341317497 = (mBase.getWallpaperDesiredMinimumHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455000677 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_455000677;
        // ---------- Original Method ----------
        //return mBase.getWallpaperDesiredMinimumHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.744 -0400", hash_original_method = "A836F480E829D8C861FB92C4C9146FF3", hash_generated_method = "29609FD6B8C29E9017BF7A70D11E4BA5")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        mBase.setWallpaper(bitmap);
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
        //mBase.setWallpaper(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.756 -0400", hash_original_method = "D6DB0F01F771FA9EFE610782CC61AF10", hash_generated_method = "A00D4A05242A2609F4276F20EC7C7215")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        mBase.setWallpaper(data);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //mBase.setWallpaper(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.771 -0400", hash_original_method = "707333CAD350B1F9359277B8D6F8C031", hash_generated_method = "889EBA665B576D5C1EA97218B0419F62")
    @Override
    public void clearWallpaper() throws IOException {
        mBase.clearWallpaper();
        // ---------- Original Method ----------
        //mBase.clearWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.772 -0400", hash_original_method = "130F62140951A945508EBFB32B94A765", hash_generated_method = "62AAAED4ACC557D655EDC63D9EAEB40E")
    @Override
    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //mBase.startActivity(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.773 -0400", hash_original_method = "013A3CF6138EA6FE6C22614936FE13C8", hash_generated_method = "4D0E24B8AE70C1442FE4BE7D99F8C648")
    @Override
    public void startActivities(Intent[] intents) {
        mBase.startActivities(intents);
        addTaint(intents[0].getTaint());
        // ---------- Original Method ----------
        //mBase.startActivities(intents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.783 -0400", hash_original_method = "D7C74DA04A5B79EC6630FAD526B70ED6", hash_generated_method = "BBB4C39151A919F17ABCE701C3C3D454")
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
        // ---------- Original Method ----------
        //mBase.startIntentSender(intent, fillInIntent, flagsMask,
                //flagsValues, extraFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.785 -0400", hash_original_method = "CD7D57CF51FEE3E0548133C9C2D084D1", hash_generated_method = "DF436B25EE9858154A53ABB5BBD74144")
    @Override
    public void sendBroadcast(Intent intent) {
        mBase.sendBroadcast(intent);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //mBase.sendBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.789 -0400", hash_original_method = "0D532949C3012CD33C142E9B5D03BB61", hash_generated_method = "C7957C2C16C4D287950DCEC8F01AF14E")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        mBase.sendBroadcast(intent, receiverPermission);
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        // ---------- Original Method ----------
        //mBase.sendBroadcast(intent, receiverPermission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.799 -0400", hash_original_method = "F587D697CC21A22CF1C16322E48A38D4", hash_generated_method = "B17BA21F6A62780A5F382E8F01F821D7")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        mBase.sendOrderedBroadcast(intent, receiverPermission);
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        // ---------- Original Method ----------
        //mBase.sendOrderedBroadcast(intent, receiverPermission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.825 -0400", hash_original_method = "DEE55BD129D883E4F2F6F72EA9382082", hash_generated_method = "E4F17E79198D332D480471F8BBF02654")
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
        // ---------- Original Method ----------
        //mBase.sendOrderedBroadcast(intent, receiverPermission,
                //resultReceiver, scheduler, initialCode,
                //initialData, initialExtras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.827 -0400", hash_original_method = "E4D0FD66C31D49EF8A28B259CA31F5AB", hash_generated_method = "208249676EB91C33023CC4E83970E1C3")
    @Override
    public void sendStickyBroadcast(Intent intent) {
        mBase.sendStickyBroadcast(intent);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //mBase.sendStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.827 -0400", hash_original_method = "7E21CD2A51D6CF22EBBD91300928AE98", hash_generated_method = "3CC4B1BA5B8B5402E0E30FBC8B888360")
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
        // ---------- Original Method ----------
        //mBase.sendStickyOrderedBroadcast(intent,
                //resultReceiver, scheduler, initialCode,
                //initialData, initialExtras);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.842 -0400", hash_original_method = "F6F4D7B74D392C087E12FF2E322B2B45", hash_generated_method = "561A50ABB21DDB79A5A5B26853811B57")
    @Override
    public void removeStickyBroadcast(Intent intent) {
        mBase.removeStickyBroadcast(intent);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //mBase.removeStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.844 -0400", hash_original_method = "D33A933E89CAAB59BCB5CB9CA20F9A5A", hash_generated_method = "6CD3EB980137402104DB8623B753635B")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_2085345493 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2085345493 = mBase.registerReceiver(receiver, filter);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2085345493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2085345493;
        // ---------- Original Method ----------
        //return mBase.registerReceiver(receiver, filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.852 -0400", hash_original_method = "C498ADCED351E80E96A53362B4745838", hash_generated_method = "1180797C7D3D03EF54ABA208866B65D9")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter,
        String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_2002272412 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2002272412 = mBase.registerReceiver(receiver, filter, broadcastPermission,
                scheduler);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2002272412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2002272412;
        // ---------- Original Method ----------
        //return mBase.registerReceiver(receiver, filter, broadcastPermission,
                //scheduler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.869 -0400", hash_original_method = "D3936D1C8F9D43BCF113D4D92126FE25", hash_generated_method = "C7F4D152B844D3A60A2D11365AF2D135")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        mBase.unregisterReceiver(receiver);
        addTaint(receiver.getTaint());
        // ---------- Original Method ----------
        //mBase.unregisterReceiver(receiver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.871 -0400", hash_original_method = "460FA5078659EEF29B84A9C36C1BA43F", hash_generated_method = "B293F769614A420E672A85651E0630CE")
    @Override
    public ComponentName startService(Intent service) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_173073647 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_173073647 = mBase.startService(service);
        addTaint(service.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_173073647.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_173073647;
        // ---------- Original Method ----------
        //return mBase.startService(service);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.872 -0400", hash_original_method = "2538E8D6E7BE6E9AB177EECCCE1CB620", hash_generated_method = "263A9714E6233CF284317EFE5003AAF2")
    @Override
    public boolean stopService(Intent name) {
        boolean var79E09432295B6E81E775BAA1429D1742_1481657628 = (mBase.stopService(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_732869 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_732869;
        // ---------- Original Method ----------
        //return mBase.stopService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.895 -0400", hash_original_method = "67132A5BC1B8EF0B15B0E872390898A0", hash_generated_method = "A624D0784A3C4529391DDF5656E1CAC8")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        boolean varB449E6D6F4ECBAA56F7BEB7D0560F07C_1671712111 = (mBase.bindService(service, conn, flags));
        addTaint(service.getTaint());
        addTaint(conn.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_247635996 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_247635996;
        // ---------- Original Method ----------
        //return mBase.bindService(service, conn, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.896 -0400", hash_original_method = "78D7D650BB4D5279C2DB8316AB02503B", hash_generated_method = "88ECDEB32CB302DE14C0AB46C55CB216")
    @Override
    public void unbindService(ServiceConnection conn) {
        mBase.unbindService(conn);
        addTaint(conn.getTaint());
        // ---------- Original Method ----------
        //mBase.unbindService(conn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.909 -0400", hash_original_method = "093BF17242F85E57BE88B991FC8B0E44", hash_generated_method = "9F25B58276EC3B4B4C7E3D3A4CE1259B")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        boolean var7847DE7C5C74BB7E9D8EF837B1629B88_1860672047 = (mBase.startInstrumentation(className, profileFile, arguments));
        addTaint(className.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(arguments.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1774296318 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1774296318;
        // ---------- Original Method ----------
        //return mBase.startInstrumentation(className, profileFile, arguments);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.911 -0400", hash_original_method = "4DFF381EBA248BD85BCC25FEFAAD92DA", hash_generated_method = "4584E3DAE6FCCA53404596DCD20B80A3")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_129176650 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_129176650 = mBase.getSystemService(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_129176650.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_129176650;
        // ---------- Original Method ----------
        //return mBase.getSystemService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.922 -0400", hash_original_method = "C6E05CB80424200F4C331B8669202D3F", hash_generated_method = "38692315DB6A414BFFDBD59A48B983DB")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        int var0B5D93936231AC00BB3EB885AB5DD216_1144703688 = (mBase.checkPermission(permission, pid, uid));
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451623063 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1451623063;
        // ---------- Original Method ----------
        //return mBase.checkPermission(permission, pid, uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.942 -0400", hash_original_method = "28B4654D3709544EFD7B7FEA40DBBFF2", hash_generated_method = "6FBBFAA85FA04F9C6A42E9872BC06F58")
    @Override
    public int checkCallingPermission(String permission) {
        int var085AD305D9EE5D54D148F8FAB5BCD242_1030410282 = (mBase.checkCallingPermission(permission));
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076693297 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1076693297;
        // ---------- Original Method ----------
        //return mBase.checkCallingPermission(permission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.947 -0400", hash_original_method = "284FE3FB34D582E990C725D71B70CDFB", hash_generated_method = "6478A254FFF36574D60C20D12DE5F7AD")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        int var74DBDAA10225909C76130339398AA057_1815325929 = (mBase.checkCallingOrSelfPermission(permission));
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129524292 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2129524292;
        // ---------- Original Method ----------
        //return mBase.checkCallingOrSelfPermission(permission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.949 -0400", hash_original_method = "62A2576537CC71D60C1F63F5056773AE", hash_generated_method = "16349EBC41A0322EA1F5E68BE2786F56")
    @Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        mBase.enforcePermission(permission, pid, uid, message);
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mBase.enforcePermission(permission, pid, uid, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.949 -0400", hash_original_method = "81E2CA4E96042AEDAEF02FD92A2A1A67", hash_generated_method = "8F247BF1A6D61B7A66A9D1F302C830DF")
    @Override
    public void enforceCallingPermission(String permission, String message) {
        mBase.enforceCallingPermission(permission, message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mBase.enforceCallingPermission(permission, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.950 -0400", hash_original_method = "4C72B3FC5896AFE13143126AEF9E54CC", hash_generated_method = "5C0CA4B6861C808C1FA619ACECF93698")
    @Override
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        mBase.enforceCallingOrSelfPermission(permission, message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mBase.enforceCallingOrSelfPermission(permission, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.952 -0400", hash_original_method = "C92445D33E31E73A915DF30F0CA49E37", hash_generated_method = "1C1C4E2392CA1194F861BDAFBE26F8B2")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        mBase.grantUriPermission(toPackage, uri, modeFlags);
        addTaint(toPackage.getTaint());
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        // ---------- Original Method ----------
        //mBase.grantUriPermission(toPackage, uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.970 -0400", hash_original_method = "10A2FB283E31FE469317FAE71C7AF4F8", hash_generated_method = "DDA7A03F0D7F1B67FF43E6BF3FB30C34")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        mBase.revokeUriPermission(uri, modeFlags);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        // ---------- Original Method ----------
        //mBase.revokeUriPermission(uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.971 -0400", hash_original_method = "F52277BFC8F41FE72798C9E8418C1E24", hash_generated_method = "2455B5CFAEAD37AC600284EE48FC1CCA")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        int var4BA59D5FCB145B56552A926363D08843_2042685062 = (mBase.checkUriPermission(uri, pid, uid, modeFlags));
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136380492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2136380492;
        // ---------- Original Method ----------
        //return mBase.checkUriPermission(uri, pid, uid, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.972 -0400", hash_original_method = "43D2E9446750BEAA21B381D934BB37A3", hash_generated_method = "7382C57D703C8999DA000A5FDD6F0D74")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        int var32F95911BC4A7B4DB8535C3F25E383D2_50967521 = (mBase.checkCallingUriPermission(uri, modeFlags));
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645638856 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_645638856;
        // ---------- Original Method ----------
        //return mBase.checkCallingUriPermission(uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.974 -0400", hash_original_method = "4761F75E9F6B51877289AE555068D313", hash_generated_method = "F4BDE60ACD281DBCCD9B9A35AF54F72E")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        int varBF497F120043DE15F7549BECCC4FD74C_1333498208 = (mBase.checkCallingOrSelfUriPermission(uri, modeFlags));
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285900345 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_285900345;
        // ---------- Original Method ----------
        //return mBase.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.989 -0400", hash_original_method = "2B7D942FC66EB790715A21C2BF13434D", hash_generated_method = "0E48DED98C46F68CD3E9B8132929EC85")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        int varE86989A776CE237B6A5E3024ADB23E65_974161739 = (mBase.checkUriPermission(uri, readPermission, writePermission,
                pid, uid, modeFlags));
        addTaint(uri.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(writePermission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243358338 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_243358338;
        // ---------- Original Method ----------
        //return mBase.checkUriPermission(uri, readPermission, writePermission,
                //pid, uid, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:59.991 -0400", hash_original_method = "BB196C48EA062CF760A21CBEDF203044", hash_generated_method = "C19668AEF19ADBEBE20272BBE12D41DC")
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mBase.enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.009 -0400", hash_original_method = "B8C6D02BD75567C0C6C58E522F178982", hash_generated_method = "A8DFA3792740A27D7BF9C198BEFB9BCE")
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        mBase.enforceCallingUriPermission(uri, modeFlags, message);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mBase.enforceCallingUriPermission(uri, modeFlags, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.010 -0400", hash_original_method = "7C2103EAC397ACBBFFA65707A1212FAD", hash_generated_method = "77FC3FEEA9D917A25DC053156E1DABE9")
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mBase.enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.011 -0400", hash_original_method = "2C0B32E644AD3E21F1765D96680E56CD", hash_generated_method = "8806D23503F6B4A14BED74832F1CADD8")
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
        // ---------- Original Method ----------
        //mBase.enforceUriPermission(
                //uri, readPermission, writePermission, pid, uid, modeFlags,
                //message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.026 -0400", hash_original_method = "B027173E51D2D8A4B1BA8F51741454A2", hash_generated_method = "1DC889F568E64D11383753C55F6B1CC5")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context varB4EAC82CA7396A68D541C85D26508E83_1306348500 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1306348500 = mBase.createPackageContext(packageName, flags);
        addTaint(packageName.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1306348500.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1306348500;
        // ---------- Original Method ----------
        //return mBase.createPackageContext(packageName, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:00.033 -0400", hash_original_method = "B09C0B118B70B22456444DDECE846C9F", hash_generated_method = "EC765F18656B94E237DD94C45F7B756A")
    @Override
    public boolean isRestricted() {
        boolean var5B1D49D9F4C840BADBDE433A4848080A_87485473 = (mBase.isRestricted());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1538084434 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1538084434;
        // ---------- Original Method ----------
        //return mBase.isRestricted();
    }

    
}

