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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.947 -0400", hash_original_field = "70C30248F16505818D6F9EB3DE4F855F", hash_generated_field = "45A1FAFEC6ED7EF70B481175C79188A0")

    Context mBase;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.965 -0400", hash_original_method = "10030D2DB2A8F36EE12AB3354BCBF9E2", hash_generated_method = "6955E83EDFF1B7CDF47D712DAA27309B")
    public  ContextWrapper(Context base) {
        mBase = base;
        // ---------- Original Method ----------
        //mBase = base;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.976 -0400", hash_original_method = "C93782FE26B0F4F6F9B761D03AD74E79", hash_generated_method = "830419495511D798B581C6B33978D845")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.981 -0400", hash_original_method = "348D9A1AC27363C49C4D9EF878F36A33", hash_generated_method = "7BD065B22438609909E1F2D09E8D77AB")
    public Context getBaseContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_872657879 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_872657879 = mBase;
        varB4EAC82CA7396A68D541C85D26508E83_872657879.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_872657879;
        // ---------- Original Method ----------
        //return mBase;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.988 -0400", hash_original_method = "207324BD2179C2BB1CD4C22794703A9D", hash_generated_method = "FF9F941ED0E3ED03D86B8D0C4753FB17")
    @Override
    public AssetManager getAssets() {
        AssetManager varB4EAC82CA7396A68D541C85D26508E83_2116692517 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2116692517 = mBase.getAssets();
        varB4EAC82CA7396A68D541C85D26508E83_2116692517.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2116692517;
        // ---------- Original Method ----------
        //return mBase.getAssets();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:57.989 -0400", hash_original_method = "47F2A94B0203C279563273E1E0895D4D", hash_generated_method = "8322E213F918232FB83B6EEE9388D831")
    @Override
    public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1774288315 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1774288315 = mBase.getResources();
        varB4EAC82CA7396A68D541C85D26508E83_1774288315.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1774288315;
        // ---------- Original Method ----------
        //return mBase.getResources();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.001 -0400", hash_original_method = "D7F633AF602934F61160FEA442625239", hash_generated_method = "F2FB369C7F77B9F75D9CBF4E13CA2139")
    @Override
    public PackageManager getPackageManager() {
        PackageManager varB4EAC82CA7396A68D541C85D26508E83_2055574248 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2055574248 = mBase.getPackageManager();
        varB4EAC82CA7396A68D541C85D26508E83_2055574248.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2055574248;
        // ---------- Original Method ----------
        //return mBase.getPackageManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.005 -0400", hash_original_method = "8EDC66E2D77BCDC119853EA41EA3296B", hash_generated_method = "8336FA848495A48A62CC15165AD90335")
    @Override
    public ContentResolver getContentResolver() {
        ContentResolver varB4EAC82CA7396A68D541C85D26508E83_1796686037 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1796686037 = mBase.getContentResolver();
        varB4EAC82CA7396A68D541C85D26508E83_1796686037.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1796686037;
        // ---------- Original Method ----------
        //return mBase.getContentResolver();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.006 -0400", hash_original_method = "7DA68BFFD90B5B26D8702419E8D7FC4A", hash_generated_method = "E426549E8BB390FC8A27DE2755FE5075")
    @Override
    public Looper getMainLooper() {
        Looper varB4EAC82CA7396A68D541C85D26508E83_1323046750 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1323046750 = mBase.getMainLooper();
        varB4EAC82CA7396A68D541C85D26508E83_1323046750.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1323046750;
        // ---------- Original Method ----------
        //return mBase.getMainLooper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.019 -0400", hash_original_method = "78E13438476D4B526B3AB7AB982B9A37", hash_generated_method = "90AE3DEFCB664B67DBDB3B40B3F5582C")
    @Override
    public Context getApplicationContext() {
        Context varB4EAC82CA7396A68D541C85D26508E83_886724322 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_886724322 = mBase.getApplicationContext();
        varB4EAC82CA7396A68D541C85D26508E83_886724322.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_886724322;
        // ---------- Original Method ----------
        //return mBase.getApplicationContext();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.020 -0400", hash_original_method = "52BC053E8452DD327B93F4A2F04B45DF", hash_generated_method = "19056A297577ED342A61F2F713A8D74B")
    @Override
    public void setTheme(int resid) {
        mBase.setTheme(resid);
        addTaint(resid);
        // ---------- Original Method ----------
        //mBase.setTheme(resid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.024 -0400", hash_original_method = "735F7E922A6884F691E7980C19D30ED9", hash_generated_method = "12A19D4D7AA32E36CAE23D81BB637FD5")
    @Override
    public int getThemeResId() {
        int var7AC95F797AB08594A077B70F1A8CCEE7_1135306340 = (mBase.getThemeResId());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143382813 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1143382813;
        // ---------- Original Method ----------
        //return mBase.getThemeResId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.025 -0400", hash_original_method = "A934E0879ABB06742AB01E1FAB54A9BF", hash_generated_method = "7EAACC79019625EDE7CBF48329A6B628")
    @Override
    public Resources.Theme getTheme() {
        Resources.Theme varB4EAC82CA7396A68D541C85D26508E83_2108003464 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2108003464 = mBase.getTheme();
        varB4EAC82CA7396A68D541C85D26508E83_2108003464.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2108003464;
        // ---------- Original Method ----------
        //return mBase.getTheme();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.043 -0400", hash_original_method = "325690D530E21A0AB255EE9D69D84488", hash_generated_method = "73015BC785AE8DA6F50C0C6486224E35")
    @Override
    public ClassLoader getClassLoader() {
        ClassLoader varB4EAC82CA7396A68D541C85D26508E83_1014672081 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1014672081 = mBase.getClassLoader();
        varB4EAC82CA7396A68D541C85D26508E83_1014672081.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1014672081;
        // ---------- Original Method ----------
        //return mBase.getClassLoader();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.050 -0400", hash_original_method = "FC1F671DB2DE2D2F1C64463A96604F21", hash_generated_method = "EE6EEE5FD0EBEF0FAF5FF237291341F1")
    @Override
    public String getPackageName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1242501995 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1242501995 = mBase.getPackageName();
        varB4EAC82CA7396A68D541C85D26508E83_1242501995.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1242501995;
        // ---------- Original Method ----------
        //return mBase.getPackageName();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.054 -0400", hash_original_method = "12EA4F448AA17744DA817E2FDC985059", hash_generated_method = "91371BB354B57A7090B691B998AB3499")
    @Override
    public ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_1859974773 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1859974773 = mBase.getApplicationInfo();
        varB4EAC82CA7396A68D541C85D26508E83_1859974773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1859974773;
        // ---------- Original Method ----------
        //return mBase.getApplicationInfo();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.075 -0400", hash_original_method = "1456FB2C70424875587B348EBED7BEBD", hash_generated_method = "5E0B20FA32811D95CA4608B4C848BBE6")
    @Override
    public String getPackageResourcePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1368191093 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1368191093 = mBase.getPackageResourcePath();
        varB4EAC82CA7396A68D541C85D26508E83_1368191093.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1368191093;
        // ---------- Original Method ----------
        //return mBase.getPackageResourcePath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.076 -0400", hash_original_method = "90ECA4CEE907B9CC4828D0F1EDEE17EB", hash_generated_method = "7DF694948871CFF045525C9A3C6B1B63")
    @Override
    public String getPackageCodePath() {
        String varB4EAC82CA7396A68D541C85D26508E83_1027956386 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1027956386 = mBase.getPackageCodePath();
        varB4EAC82CA7396A68D541C85D26508E83_1027956386.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1027956386;
        // ---------- Original Method ----------
        //return mBase.getPackageCodePath();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.077 -0400", hash_original_method = "49CEDB82FC58CDF70EFA8B7A21272CFA", hash_generated_method = "33FF12B12A2927CC198F6667B41F226A")
    @Override
    public File getSharedPrefsFile(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1378250701 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1378250701 = mBase.getSharedPrefsFile(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1378250701.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1378250701;
        // ---------- Original Method ----------
        //return mBase.getSharedPrefsFile(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.096 -0400", hash_original_method = "51168DD8811589A8A44258F7BDA9D1F0", hash_generated_method = "0E68A12A16570D84990CEB409141DDEE")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        SharedPreferences varB4EAC82CA7396A68D541C85D26508E83_1050245758 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1050245758 = mBase.getSharedPreferences(name, mode);
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1050245758.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1050245758;
        // ---------- Original Method ----------
        //return mBase.getSharedPreferences(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.097 -0400", hash_original_method = "744F22B41784C38DFA56BA635287A3F7", hash_generated_method = "D8FC477D4FA869A8921CDFC52EA809BB")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        FileInputStream varB4EAC82CA7396A68D541C85D26508E83_838097755 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_838097755 = mBase.openFileInput(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_838097755.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_838097755;
        // ---------- Original Method ----------
        //return mBase.openFileInput(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.114 -0400", hash_original_method = "1B551CEA36C6304276D435BC90F14FD3", hash_generated_method = "9329963845B73BFCEA622060A6F5A14A")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        FileOutputStream varB4EAC82CA7396A68D541C85D26508E83_1310713272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1310713272 = mBase.openFileOutput(name, mode);
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1310713272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1310713272;
        // ---------- Original Method ----------
        //return mBase.openFileOutput(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.126 -0400", hash_original_method = "A1313161ACDE2AAD1A9AEF7D9E6B717D", hash_generated_method = "64BDEECE20A9B566A2C87397005B921E")
    @Override
    public boolean deleteFile(String name) {
        boolean var14AF3FE5F23FD23E2C2EAF5A63873DB5_2101823412 = (mBase.deleteFile(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684060853 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_684060853;
        // ---------- Original Method ----------
        //return mBase.deleteFile(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.127 -0400", hash_original_method = "41C51E2648C5FE16B28D046D5B54DAAA", hash_generated_method = "2AC364A207624D570D0F4D5C885F3819")
    @Override
    public File getFileStreamPath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_1629194847 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1629194847 = mBase.getFileStreamPath(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1629194847.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1629194847;
        // ---------- Original Method ----------
        //return mBase.getFileStreamPath(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.133 -0400", hash_original_method = "7FE19E11982633820D311587FC329BA9", hash_generated_method = "B65BCD3AED7D20D2B52BAEB326DF8098")
    @Override
    public String[] fileList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_827944266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_827944266 = mBase.fileList();
        varB4EAC82CA7396A68D541C85D26508E83_827944266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_827944266;
        // ---------- Original Method ----------
        //return mBase.fileList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.135 -0400", hash_original_method = "14B449BDD79B281009CCC9DF0F75EC6B", hash_generated_method = "6CFA4235EF64FE15CB12A189F414CD38")
    @Override
    public File getFilesDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1935303951 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1935303951 = mBase.getFilesDir();
        varB4EAC82CA7396A68D541C85D26508E83_1935303951.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1935303951;
        // ---------- Original Method ----------
        //return mBase.getFilesDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.136 -0400", hash_original_method = "BC309698CECF9063C5A4ADDF6C6EC7AF", hash_generated_method = "49B4C25D6490A12B487C69A4311BF649")
    @Override
    public File getExternalFilesDir(String type) {
        File varB4EAC82CA7396A68D541C85D26508E83_1383473919 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1383473919 = mBase.getExternalFilesDir(type);
        addTaint(type.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1383473919.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1383473919;
        // ---------- Original Method ----------
        //return mBase.getExternalFilesDir(type);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.140 -0400", hash_original_method = "068174B051BB78F57C468F648940D142", hash_generated_method = "4DEFC8A07BC7E27ACD94B0364B3EBA6E")
    @Override
    public File getObbDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1220120521 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1220120521 = mBase.getObbDir();
        varB4EAC82CA7396A68D541C85D26508E83_1220120521.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1220120521;
        // ---------- Original Method ----------
        //return mBase.getObbDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.151 -0400", hash_original_method = "44DE59125179A0BDED11E57B810BFAF1", hash_generated_method = "35BD57BC3DC0519CA3564A2ED9E532CE")
    @Override
    public File getCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_388492780 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_388492780 = mBase.getCacheDir();
        varB4EAC82CA7396A68D541C85D26508E83_388492780.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_388492780;
        // ---------- Original Method ----------
        //return mBase.getCacheDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.152 -0400", hash_original_method = "7C2D809316E637C52FE8D4DE0AE386A3", hash_generated_method = "072A8DB00ED190397AA80EE215B458DD")
    @Override
    public File getExternalCacheDir() {
        File varB4EAC82CA7396A68D541C85D26508E83_1604113617 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1604113617 = mBase.getExternalCacheDir();
        varB4EAC82CA7396A68D541C85D26508E83_1604113617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1604113617;
        // ---------- Original Method ----------
        //return mBase.getExternalCacheDir();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.153 -0400", hash_original_method = "A1FD69F0E118B7CAF1C496338AAD4B07", hash_generated_method = "91D4F1CA3B20DE93F35C3515683BC2AE")
    @Override
    public File getDir(String name, int mode) {
        File varB4EAC82CA7396A68D541C85D26508E83_1874589839 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1874589839 = mBase.getDir(name, mode);
        addTaint(name.getTaint());
        addTaint(mode);
        varB4EAC82CA7396A68D541C85D26508E83_1874589839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1874589839;
        // ---------- Original Method ----------
        //return mBase.getDir(name, mode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.154 -0400", hash_original_method = "DDED7E3E0B02F872C2CC1A3BF9DCD873", hash_generated_method = "39D3E2EEE9E9B32315D0581BD7E3843B")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_1219339609 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1219339609 = mBase.openOrCreateDatabase(name, mode, factory);
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1219339609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1219339609;
        // ---------- Original Method ----------
        //return mBase.openOrCreateDatabase(name, mode, factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.176 -0400", hash_original_method = "670C2BACF8B510FB1BD02F583C82D7AC", hash_generated_method = "2D8DE62A362A20BC4FF4C1452DD4A421")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory,
            DatabaseErrorHandler errorHandler) {
        SQLiteDatabase varB4EAC82CA7396A68D541C85D26508E83_430383019 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_430383019 = mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
        addTaint(name.getTaint());
        addTaint(mode);
        addTaint(factory.getTaint());
        addTaint(errorHandler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_430383019.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_430383019;
        // ---------- Original Method ----------
        //return mBase.openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.178 -0400", hash_original_method = "2060E0B3DB8EB041F39B4C3EBCF4134E", hash_generated_method = "3FD68F9DC2B47930DC3D2F47555C8FC9")
    @Override
    public boolean deleteDatabase(String name) {
        boolean var1201E6487C2E2ECBC3C1937591CAB600_1614519696 = (mBase.deleteDatabase(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1060484192 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1060484192;
        // ---------- Original Method ----------
        //return mBase.deleteDatabase(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.179 -0400", hash_original_method = "A01E89BA0EE5F5DE805AF38A996A2059", hash_generated_method = "88A5F5183723CADC2DC9CABBEE78F2F9")
    @Override
    public File getDatabasePath(String name) {
        File varB4EAC82CA7396A68D541C85D26508E83_194695700 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_194695700 = mBase.getDatabasePath(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_194695700.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_194695700;
        // ---------- Original Method ----------
        //return mBase.getDatabasePath(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.191 -0400", hash_original_method = "B3ECD12C5FD290CA7C545491C12B6E0F", hash_generated_method = "33EDB77AFEDC5BDAF1DDE0DFF17703F1")
    @Override
    public String[] databaseList() {
        String[] varB4EAC82CA7396A68D541C85D26508E83_542974560 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_542974560 = mBase.databaseList();
        varB4EAC82CA7396A68D541C85D26508E83_542974560.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_542974560;
        // ---------- Original Method ----------
        //return mBase.databaseList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.193 -0400", hash_original_method = "F9E6827CCB2CDD46111FB10DB307E9AE", hash_generated_method = "747D4046440C325E7EB355B443AF2505")
    @Override
    public Drawable getWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_551078656 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_551078656 = mBase.getWallpaper();
        varB4EAC82CA7396A68D541C85D26508E83_551078656.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_551078656;
        // ---------- Original Method ----------
        //return mBase.getWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.194 -0400", hash_original_method = "0198388A7C02DAA006719AEF39F3322C", hash_generated_method = "AD632E6C402A638D14D53B7A73224472")
    @Override
    public Drawable peekWallpaper() {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_375351032 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_375351032 = mBase.peekWallpaper();
        varB4EAC82CA7396A68D541C85D26508E83_375351032.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_375351032;
        // ---------- Original Method ----------
        //return mBase.peekWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.214 -0400", hash_original_method = "19E21BC09381D0D00BEBE6A5DFBF3F3C", hash_generated_method = "028E26BA8FEB6656D88D38E60CCA06AD")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        int varAADE4DC8942D82E82A9B42B92539E4A5_1067898662 = (mBase.getWallpaperDesiredMinimumWidth());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136126566 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1136126566;
        // ---------- Original Method ----------
        //return mBase.getWallpaperDesiredMinimumWidth();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.216 -0400", hash_original_method = "3C43E61226EF3145DD8AB1F12075339B", hash_generated_method = "C51755150E9A5C4744FDC696AE0CB663")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        int varB7C2E2DEB0713543A3A0442CBAC5C5E5_943907842 = (mBase.getWallpaperDesiredMinimumHeight());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1369881871 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1369881871;
        // ---------- Original Method ----------
        //return mBase.getWallpaperDesiredMinimumHeight();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.216 -0400", hash_original_method = "A836F480E829D8C861FB92C4C9146FF3", hash_generated_method = "29609FD6B8C29E9017BF7A70D11E4BA5")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        mBase.setWallpaper(bitmap);
        addTaint(bitmap.getTaint());
        // ---------- Original Method ----------
        //mBase.setWallpaper(bitmap);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.217 -0400", hash_original_method = "D6DB0F01F771FA9EFE610782CC61AF10", hash_generated_method = "A00D4A05242A2609F4276F20EC7C7215")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        mBase.setWallpaper(data);
        addTaint(data.getTaint());
        // ---------- Original Method ----------
        //mBase.setWallpaper(data);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.218 -0400", hash_original_method = "707333CAD350B1F9359277B8D6F8C031", hash_generated_method = "889EBA665B576D5C1EA97218B0419F62")
    @Override
    public void clearWallpaper() throws IOException {
        mBase.clearWallpaper();
        // ---------- Original Method ----------
        //mBase.clearWallpaper();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.219 -0400", hash_original_method = "130F62140951A945508EBFB32B94A765", hash_generated_method = "62AAAED4ACC557D655EDC63D9EAEB40E")
    @Override
    public void startActivity(Intent intent) {
        mBase.startActivity(intent);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //mBase.startActivity(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.220 -0400", hash_original_method = "013A3CF6138EA6FE6C22614936FE13C8", hash_generated_method = "4D0E24B8AE70C1442FE4BE7D99F8C648")
    @Override
    public void startActivities(Intent[] intents) {
        mBase.startActivities(intents);
        addTaint(intents[0].getTaint());
        // ---------- Original Method ----------
        //mBase.startActivities(intents);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.233 -0400", hash_original_method = "D7C74DA04A5B79EC6630FAD526B70ED6", hash_generated_method = "BBB4C39151A919F17ABCE701C3C3D454")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.234 -0400", hash_original_method = "CD7D57CF51FEE3E0548133C9C2D084D1", hash_generated_method = "DF436B25EE9858154A53ABB5BBD74144")
    @Override
    public void sendBroadcast(Intent intent) {
        mBase.sendBroadcast(intent);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //mBase.sendBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.235 -0400", hash_original_method = "0D532949C3012CD33C142E9B5D03BB61", hash_generated_method = "C7957C2C16C4D287950DCEC8F01AF14E")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        mBase.sendBroadcast(intent, receiverPermission);
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        // ---------- Original Method ----------
        //mBase.sendBroadcast(intent, receiverPermission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.248 -0400", hash_original_method = "F587D697CC21A22CF1C16322E48A38D4", hash_generated_method = "B17BA21F6A62780A5F382E8F01F821D7")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        mBase.sendOrderedBroadcast(intent, receiverPermission);
        addTaint(intent.getTaint());
        addTaint(receiverPermission.getTaint());
        // ---------- Original Method ----------
        //mBase.sendOrderedBroadcast(intent, receiverPermission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.249 -0400", hash_original_method = "DEE55BD129D883E4F2F6F72EA9382082", hash_generated_method = "E4F17E79198D332D480471F8BBF02654")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.250 -0400", hash_original_method = "E4D0FD66C31D49EF8A28B259CA31F5AB", hash_generated_method = "208249676EB91C33023CC4E83970E1C3")
    @Override
    public void sendStickyBroadcast(Intent intent) {
        mBase.sendStickyBroadcast(intent);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //mBase.sendStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.254 -0400", hash_original_method = "7E21CD2A51D6CF22EBBD91300928AE98", hash_generated_method = "3CC4B1BA5B8B5402E0E30FBC8B888360")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.258 -0400", hash_original_method = "F6F4D7B74D392C087E12FF2E322B2B45", hash_generated_method = "561A50ABB21DDB79A5A5B26853811B57")
    @Override
    public void removeStickyBroadcast(Intent intent) {
        mBase.removeStickyBroadcast(intent);
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //mBase.removeStickyBroadcast(intent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.273 -0400", hash_original_method = "D33A933E89CAAB59BCB5CB9CA20F9A5A", hash_generated_method = "43DAA84CA0A57A00C72D2D641D44822A")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_1937326040 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1937326040 = mBase.registerReceiver(receiver, filter);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1937326040.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1937326040;
        // ---------- Original Method ----------
        //return mBase.registerReceiver(receiver, filter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.274 -0400", hash_original_method = "C498ADCED351E80E96A53362B4745838", hash_generated_method = "334A1DCD11CB81F4488B240CA6CEF70F")
    @Override
    public Intent registerReceiver(
        BroadcastReceiver receiver, IntentFilter filter,
        String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        Intent varB4EAC82CA7396A68D541C85D26508E83_154145773 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_154145773 = mBase.registerReceiver(receiver, filter, broadcastPermission,
                scheduler);
        addTaint(receiver.getTaint());
        addTaint(filter.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(scheduler.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_154145773.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_154145773;
        // ---------- Original Method ----------
        //return mBase.registerReceiver(receiver, filter, broadcastPermission,
                //scheduler);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.275 -0400", hash_original_method = "D3936D1C8F9D43BCF113D4D92126FE25", hash_generated_method = "C7F4D152B844D3A60A2D11365AF2D135")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        mBase.unregisterReceiver(receiver);
        addTaint(receiver.getTaint());
        // ---------- Original Method ----------
        //mBase.unregisterReceiver(receiver);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.279 -0400", hash_original_method = "460FA5078659EEF29B84A9C36C1BA43F", hash_generated_method = "6F8B163FC0F5CCB7F6F2CA74276EA5DC")
    @Override
    public ComponentName startService(Intent service) {
        ComponentName varB4EAC82CA7396A68D541C85D26508E83_146161329 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_146161329 = mBase.startService(service);
        addTaint(service.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_146161329.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_146161329;
        // ---------- Original Method ----------
        //return mBase.startService(service);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.296 -0400", hash_original_method = "2538E8D6E7BE6E9AB177EECCCE1CB620", hash_generated_method = "2D1D1972DE8DF2AC71A6112A7076E05F")
    @Override
    public boolean stopService(Intent name) {
        boolean var79E09432295B6E81E775BAA1429D1742_2010985691 = (mBase.stopService(name));
        addTaint(name.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1903456977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1903456977;
        // ---------- Original Method ----------
        //return mBase.stopService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.297 -0400", hash_original_method = "67132A5BC1B8EF0B15B0E872390898A0", hash_generated_method = "AB24B9F0465A5A1564A5A34A19762052")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn,
            int flags) {
        boolean varB449E6D6F4ECBAA56F7BEB7D0560F07C_499974620 = (mBase.bindService(service, conn, flags));
        addTaint(service.getTaint());
        addTaint(conn.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827302466 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_827302466;
        // ---------- Original Method ----------
        //return mBase.bindService(service, conn, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.304 -0400", hash_original_method = "78D7D650BB4D5279C2DB8316AB02503B", hash_generated_method = "88ECDEB32CB302DE14C0AB46C55CB216")
    @Override
    public void unbindService(ServiceConnection conn) {
        mBase.unbindService(conn);
        addTaint(conn.getTaint());
        // ---------- Original Method ----------
        //mBase.unbindService(conn);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.305 -0400", hash_original_method = "093BF17242F85E57BE88B991FC8B0E44", hash_generated_method = "EDDEE08C7B3ED42480AD2E779FB010CF")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        boolean var7847DE7C5C74BB7E9D8EF837B1629B88_96592271 = (mBase.startInstrumentation(className, profileFile, arguments));
        addTaint(className.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(arguments.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_646025689 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_646025689;
        // ---------- Original Method ----------
        //return mBase.startInstrumentation(className, profileFile, arguments);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.325 -0400", hash_original_method = "4DFF381EBA248BD85BCC25FEFAAD92DA", hash_generated_method = "67C2B393D8D28252FD9C9842768AE519")
    @Override
    public Object getSystemService(String name) {
        Object varB4EAC82CA7396A68D541C85D26508E83_705468757 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_705468757 = mBase.getSystemService(name);
        addTaint(name.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_705468757.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_705468757;
        // ---------- Original Method ----------
        //return mBase.getSystemService(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.326 -0400", hash_original_method = "C6E05CB80424200F4C331B8669202D3F", hash_generated_method = "AB2958B06D0D4550BBC0849D915BD5E9")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        int var0B5D93936231AC00BB3EB885AB5DD216_1328362491 = (mBase.checkPermission(permission, pid, uid));
        addTaint(permission.getTaint());
        addTaint(pid);
        addTaint(uid);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31155554 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_31155554;
        // ---------- Original Method ----------
        //return mBase.checkPermission(permission, pid, uid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.327 -0400", hash_original_method = "28B4654D3709544EFD7B7FEA40DBBFF2", hash_generated_method = "B47C333ED149F2BECB4788BC19D3D47B")
    @Override
    public int checkCallingPermission(String permission) {
        int var085AD305D9EE5D54D148F8FAB5BCD242_1441758309 = (mBase.checkCallingPermission(permission));
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1664689517 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1664689517;
        // ---------- Original Method ----------
        //return mBase.checkCallingPermission(permission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.328 -0400", hash_original_method = "284FE3FB34D582E990C725D71B70CDFB", hash_generated_method = "FD980574D85C09B677DDBCBCD1F4D9ED")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        int var74DBDAA10225909C76130339398AA057_498414224 = (mBase.checkCallingOrSelfPermission(permission));
        addTaint(permission.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1146786253 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1146786253;
        // ---------- Original Method ----------
        //return mBase.checkCallingOrSelfPermission(permission);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.332 -0400", hash_original_method = "62A2576537CC71D60C1F63F5056773AE", hash_generated_method = "16349EBC41A0322EA1F5E68BE2786F56")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.343 -0400", hash_original_method = "81E2CA4E96042AEDAEF02FD92A2A1A67", hash_generated_method = "8F247BF1A6D61B7A66A9D1F302C830DF")
    @Override
    public void enforceCallingPermission(String permission, String message) {
        mBase.enforceCallingPermission(permission, message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mBase.enforceCallingPermission(permission, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.355 -0400", hash_original_method = "4C72B3FC5896AFE13143126AEF9E54CC", hash_generated_method = "5C0CA4B6861C808C1FA619ACECF93698")
    @Override
    public void enforceCallingOrSelfPermission(
            String permission, String message) {
        mBase.enforceCallingOrSelfPermission(permission, message);
        addTaint(permission.getTaint());
        addTaint(message.getTaint());
        // ---------- Original Method ----------
        //mBase.enforceCallingOrSelfPermission(permission, message);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.357 -0400", hash_original_method = "C92445D33E31E73A915DF30F0CA49E37", hash_generated_method = "1C1C4E2392CA1194F861BDAFBE26F8B2")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        mBase.grantUriPermission(toPackage, uri, modeFlags);
        addTaint(toPackage.getTaint());
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        // ---------- Original Method ----------
        //mBase.grantUriPermission(toPackage, uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.371 -0400", hash_original_method = "10A2FB283E31FE469317FAE71C7AF4F8", hash_generated_method = "DDA7A03F0D7F1B67FF43E6BF3FB30C34")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        mBase.revokeUriPermission(uri, modeFlags);
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        // ---------- Original Method ----------
        //mBase.revokeUriPermission(uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.372 -0400", hash_original_method = "F52277BFC8F41FE72798C9E8418C1E24", hash_generated_method = "9E6DA209B7B6EA5D13C7BEC1D7B8E281")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        int var4BA59D5FCB145B56552A926363D08843_362318527 = (mBase.checkUriPermission(uri, pid, uid, modeFlags));
        addTaint(uri.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431319658 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_431319658;
        // ---------- Original Method ----------
        //return mBase.checkUriPermission(uri, pid, uid, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.373 -0400", hash_original_method = "43D2E9446750BEAA21B381D934BB37A3", hash_generated_method = "26530C4223D94F369B1B9912A762229D")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        int var32F95911BC4A7B4DB8535C3F25E383D2_1895654092 = (mBase.checkCallingUriPermission(uri, modeFlags));
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886488669 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886488669;
        // ---------- Original Method ----------
        //return mBase.checkCallingUriPermission(uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.374 -0400", hash_original_method = "4761F75E9F6B51877289AE555068D313", hash_generated_method = "755594E3CCC97A16E15DA8E0B9393909")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        int varBF497F120043DE15F7549BECCC4FD74C_602590510 = (mBase.checkCallingOrSelfUriPermission(uri, modeFlags));
        addTaint(uri.getTaint());
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752227634 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1752227634;
        // ---------- Original Method ----------
        //return mBase.checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.376 -0400", hash_original_method = "2B7D942FC66EB790715A21C2BF13434D", hash_generated_method = "9F1D94BB7D4A0E470DE5A1D7BE330FE6")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        int varE86989A776CE237B6A5E3024ADB23E65_343711389 = (mBase.checkUriPermission(uri, readPermission, writePermission,
                pid, uid, modeFlags));
        addTaint(uri.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(writePermission.getTaint());
        addTaint(pid);
        addTaint(uid);
        addTaint(modeFlags);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692792254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_692792254;
        // ---------- Original Method ----------
        //return mBase.checkUriPermission(uri, readPermission, writePermission,
                //pid, uid, modeFlags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.389 -0400", hash_original_method = "BB196C48EA062CF760A21CBEDF203044", hash_generated_method = "C19668AEF19ADBEBE20272BBE12D41DC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.390 -0400", hash_original_method = "B8C6D02BD75567C0C6C58E522F178982", hash_generated_method = "A8DFA3792740A27D7BF9C198BEFB9BCE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.391 -0400", hash_original_method = "7C2103EAC397ACBBFFA65707A1212FAD", hash_generated_method = "77FC3FEEA9D917A25DC053156E1DABE9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.392 -0400", hash_original_method = "2C0B32E644AD3E21F1765D96680E56CD", hash_generated_method = "8806D23503F6B4A14BED74832F1CADD8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.408 -0400", hash_original_method = "B027173E51D2D8A4B1BA8F51741454A2", hash_generated_method = "913A9A99373DBB74E103A2133AF16297")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        Context varB4EAC82CA7396A68D541C85D26508E83_1729970787 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1729970787 = mBase.createPackageContext(packageName, flags);
        addTaint(packageName.getTaint());
        addTaint(flags);
        varB4EAC82CA7396A68D541C85D26508E83_1729970787.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1729970787;
        // ---------- Original Method ----------
        //return mBase.createPackageContext(packageName, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:58.409 -0400", hash_original_method = "B09C0B118B70B22456444DDECE846C9F", hash_generated_method = "A74BA0E565C362814FF54EC26D3E464E")
    @Override
    public boolean isRestricted() {
        boolean var5B1D49D9F4C840BADBDE433A4848080A_62143304 = (mBase.isRestricted());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1235155732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1235155732;
        // ---------- Original Method ----------
        //return mBase.isRestricted();
    }

    
}

