package android.test.mock;

// Droidsafe Imports
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class MockContext extends Context {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.098 -0400", hash_original_method = "3BD432D7D653C5930EE983B863B99E4B", hash_generated_method = "3BD432D7D653C5930EE983B863B99E4B")
    public MockContext ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.099 -0400", hash_original_method = "CF22466B77047295B0A90CFB1E700947", hash_generated_method = "D32FA8F1EB56DE94A6AD08B2D74B0BE7")
    @Override
    public AssetManager getAssets() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1799962077 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1799962077.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1799962077;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.099 -0400", hash_original_method = "C54B5267A2D44CE04E49213C47F52259", hash_generated_method = "C720C8C2971BA91B3BEDB99490B4B446")
    @Override
    public Resources getResources() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_508370580 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_508370580.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_508370580;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.100 -0400", hash_original_method = "E88041AF08BE295672677A7AE875FEFF", hash_generated_method = "14A6A70A9C988329A0CBFF5CBA5B9D54")
    @Override
    public PackageManager getPackageManager() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_887335692 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_887335692.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_887335692;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.100 -0400", hash_original_method = "61790CFAFC8BCC32869A9B01BEB1BF44", hash_generated_method = "A2FC1BF03D2E8B6D34D05E73572E75A2")
    @Override
    public ContentResolver getContentResolver() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1902575328 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1902575328.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1902575328;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.100 -0400", hash_original_method = "962B8DEC28714F6FEBBFE04F24E90B9C", hash_generated_method = "26B283B5D9CB5A53AD0702AA4A84D420")
    @Override
    public Looper getMainLooper() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_191895665 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_191895665.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_191895665;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.101 -0400", hash_original_method = "7D1710194777282B9AA7CA1905E51B18", hash_generated_method = "71869DC0317B2044239C0C1E9C918FB8")
    @Override
    public Context getApplicationContext() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_382489753 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_382489753.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_382489753;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.101 -0400", hash_original_method = "060683B1D8FC90BB795699914548359D", hash_generated_method = "25F8DBED59CE08344DE5203D113AC910")
    @Override
    public void setTheme(int resid) {
        addTaint(resid);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_450560533 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_450560533.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_450560533;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.101 -0400", hash_original_method = "D8312749B850F43C5A70B4ED63CC08E3", hash_generated_method = "2DE905CB752A6BA630279C6CE9AEC1C5")
    @Override
    public Resources.Theme getTheme() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_400946400 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_400946400.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_400946400;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.102 -0400", hash_original_method = "C51DF920D125BDAE90130F458F1F9388", hash_generated_method = "AD4F29D9ED603EA94F1BEA4210080633")
    @Override
    public ClassLoader getClassLoader() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_779758526 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_779758526.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_779758526;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.102 -0400", hash_original_method = "6D0C58F8CBE63957D6DF922F2249B8C5", hash_generated_method = "6AF9DAD808CD9C5BFF86EB01240420CC")
    @Override
    public String getPackageName() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1496745489 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1496745489.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1496745489;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.103 -0400", hash_original_method = "6E8F7F76B2482C387134CAE0922B8764", hash_generated_method = "3AA0A3AF23945E877285541C75548A1B")
    @Override
    public ApplicationInfo getApplicationInfo() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_737568259 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_737568259.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_737568259;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.103 -0400", hash_original_method = "C89556570A09E26932F56B416A239F82", hash_generated_method = "B5B926B1D3216F09D233ADAD139B18ED")
    @Override
    public String getPackageResourcePath() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_414046675 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_414046675.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_414046675;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.104 -0400", hash_original_method = "FA444114F9C54186D6D89E2CA249FBCF", hash_generated_method = "99BCE432198AD9E7EE3714D91DFAAE88")
    @Override
    public File getSharedPrefsFile(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1595806676 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1595806676.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1595806676;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.104 -0400", hash_original_method = "92AFBFFE30EEE36D5D46293F4B78E905", hash_generated_method = "1DDED7CF8E1E4D8EEA3601DDADF2A19A")
    @Override
    public String getPackageCodePath() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_935098577 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_935098577.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_935098577;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.105 -0400", hash_original_method = "7A0D76AB436CE8A39BBA6ED25153EABF", hash_generated_method = "3597B7B2BE988169A03F6734521F399B")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1945107955 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1945107955.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1945107955;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.105 -0400", hash_original_method = "6F9D455A12BE93D87BC450FB84CABAF4", hash_generated_method = "3DFBA8C9AE70CFFA66A1205E74C0C4A6")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_973442582 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_973442582.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_973442582;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.106 -0400", hash_original_method = "06BE4C94ED3C4C2DFF4AC6484EAC8136", hash_generated_method = "82E5D4B587C3173B7F93E682B3EDF489")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        addTaint(mode);
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_219917576 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_219917576.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_219917576;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.106 -0400", hash_original_method = "52E0F39A74289A48663341DDCEF037DC", hash_generated_method = "A2A3920B0EAB9DFD625DAEBE8926456B")
    @Override
    public boolean deleteFile(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1484229209 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1484229209.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1484229209;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.107 -0400", hash_original_method = "466D6BF0E43B95D4B6EB41E58C265707", hash_generated_method = "728F6CB9EB3CDC84BBBC44792A7FFFAF")
    @Override
    public File getFileStreamPath(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1180189492 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1180189492.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1180189492;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.107 -0400", hash_original_method = "59F9DE1DC3F61B801C5281F9E3C6E2A4", hash_generated_method = "D276D5FDB43B896F57948EF7A4E65ED2")
    @Override
    public String[] fileList() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_537692332 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_537692332.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_537692332;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.108 -0400", hash_original_method = "DBAC6A56B922EB1BA78CA1746FBB8CC3", hash_generated_method = "8127ED4460858FB5E3C02348C82586C3")
    @Override
    public File getFilesDir() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1706984007 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1706984007.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1706984007;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.108 -0400", hash_original_method = "90C15C4E056A492114901C79423D8DCF", hash_generated_method = "4CB4E74CFA4E267525D99AD51DC9B104")
    @Override
    public File getExternalFilesDir(String type) {
        addTaint(type.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1423909495 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1423909495.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1423909495;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.109 -0400", hash_original_method = "702F9A452622032EC8233CE54867C377", hash_generated_method = "08CC6F4CDBBE2C194C10EE05A5DF2230")
    @Override
    public File getObbDir() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1189865000 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1189865000.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1189865000;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.109 -0400", hash_original_method = "FDF4A6103F9B59802F7D5E28BF5EFD3A", hash_generated_method = "560B32C0340D82CD917F9E40D994CAE4")
    @Override
    public File getCacheDir() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1988031330 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1988031330.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1988031330;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.109 -0400", hash_original_method = "2A92DC096DA51370A1334577ECF09ECC", hash_generated_method = "88F73753CD8FF48504DBC839AC66501B")
    @Override
    public File getExternalCacheDir() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_436553953 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_436553953.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_436553953;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.110 -0400", hash_original_method = "34B447CE41C4ED84D6396B7E9780C31D", hash_generated_method = "9E558F441939210DA834A6DFD78868B6")
    @Override
    public File getDir(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1989302529 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1989302529.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1989302529;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.111 -0400", hash_original_method = "CD5FDC840DBA80E0D8DDF078BF714DEA", hash_generated_method = "642D2CA3CAF9FD4BF811BFF04E9DF35E")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String file, int mode, 
            SQLiteDatabase.CursorFactory factory) {
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(file.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_224296867 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_224296867.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_224296867;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.111 -0400", hash_original_method = "7939EB7F51D4EA520B25C26292DA454F", hash_generated_method = "1DF64C37813C4EF6DF7FE0359F63A3B6")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String file, int mode,
            SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        addTaint(errorHandler.getTaint());
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(file.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_257746227 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_257746227.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_257746227;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.111 -0400", hash_original_method = "E48DC3F924F870943E4E36BC470CEAAB", hash_generated_method = "7EFB96637546C1E1595CA85B65E2EA09")
    @Override
    public File getDatabasePath(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2033701900 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2033701900.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2033701900;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.112 -0400", hash_original_method = "B170F7706E5C42A003C64B941E6F02C3", hash_generated_method = "ADF35B1895577A1BC7EC7D5F28BC5638")
    @Override
    public String[] databaseList() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_224503572 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_224503572.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_224503572;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.112 -0400", hash_original_method = "F910F6C68A7FB093015261F7E1433E12", hash_generated_method = "4812A78CECE48E48B78BBE6A0A417863")
    @Override
    public boolean deleteDatabase(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2001611146 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2001611146.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2001611146;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.112 -0400", hash_original_method = "B684586EF353D1CCAA3450E5FF9DC08F", hash_generated_method = "27E0C1024FBF3720CA4AC3CAC12C0E5F")
    @Override
    public Drawable getWallpaper() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2145410797 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2145410797.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2145410797;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.112 -0400", hash_original_method = "30AAB697F190292EC6A7D3C51657B6D7", hash_generated_method = "C3D6866C90B36EE58B3F0BE71126E828")
    @Override
    public Drawable peekWallpaper() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1076829544 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1076829544.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1076829544;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.112 -0400", hash_original_method = "4F392818CCC81F3909BB8C9EA84C5ED2", hash_generated_method = "18F62F2930094B2B53A80AF7CC787933")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1288610947 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1288610947.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1288610947;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.113 -0400", hash_original_method = "109D2D0B104293A4F52BC55EADD30F43", hash_generated_method = "48E8FEF23C29DFC4AB087EE7CAD8279B")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1451798830 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1451798830.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1451798830;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.113 -0400", hash_original_method = "13366CFA01CCB9E3D0D5A885A1E3BD82", hash_generated_method = "B8CCE665AA09FE0694A0366EF0188A35")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        addTaint(bitmap.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2109992468 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2109992468.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2109992468;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.113 -0400", hash_original_method = "72AC712F363F7774A80940CA93269479", hash_generated_method = "D4609BE593405B06206F0132D5BCFA27")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        addTaint(data.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2143388465 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2143388465.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2143388465;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.113 -0400", hash_original_method = "6AFDDD74A00ECA2CECE35CA27A2C95A0", hash_generated_method = "EB83FA04527172C1B606799825623837")
    @Override
    public void clearWallpaper() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1437205326 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1437205326.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1437205326;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.114 -0400", hash_original_method = "10BBC39B201767C43F0FBBE296ABD273", hash_generated_method = "E9E4F482822AC508F695A84679EFB310")
    @Override
    public void startActivity(Intent intent) {
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_999546955 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_999546955.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_999546955;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.114 -0400", hash_original_method = "8A0FF876EE34DCD944B6E38C35E12478", hash_generated_method = "4E51363C61A8669AADC0C5D995239A71")
    @Override
    public void startActivities(Intent[] intents) {
        addTaint(intents[0].getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1117133317 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1117133317.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1117133317;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.114 -0400", hash_original_method = "70A0DB323D66E33A5F118512F09625C8", hash_generated_method = "43E513E18E7DC15CFC533CC98580D13E")
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        addTaint(extraFlags);
        addTaint(flagsValues);
        addTaint(flagsMask);
        addTaint(fillInIntent.getTaint());
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_381784875 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_381784875.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_381784875;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.115 -0400", hash_original_method = "7E1C16471170CAC5D2A8AEA7AFD07DD1", hash_generated_method = "5D357081A24985860DAFB69A1ACA27DC")
    @Override
    public void sendBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_917473671 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_917473671.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_917473671;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.115 -0400", hash_original_method = "4C3B301BF0F66FC6027023D458D4F5CD", hash_generated_method = "253BC18D05313C9E2A2C84A290813CA4")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_693047061 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_693047061.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_693047061;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.115 -0400", hash_original_method = "53C9E33F6F3BF762F0C7AD2D83F8B880", hash_generated_method = "652F5D5133126078BD461BB195C328A2")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1745617058 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1745617058.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1745617058;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.115 -0400", hash_original_method = "BD4D4F58A89D586949B717D061DAB18B", hash_generated_method = "D1A90072F09AAAD61BEB5E2B5295A703")
    @Override
    public void sendOrderedBroadcast(Intent intent, String receiverPermission,
            BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData,
           Bundle initialExtras) {
        addTaint(initialExtras.getTaint());
        addTaint(initialData.getTaint());
        addTaint(initialCode);
        addTaint(scheduler.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1864612547 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1864612547.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1864612547;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.116 -0400", hash_original_method = "F1DE7775DB33185A5749E492B31FBC7D", hash_generated_method = "C92E7C0932381317CF1B155F477CE782")
    @Override
    public void sendStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1387899374 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1387899374.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1387899374;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.116 -0400", hash_original_method = "282E4DE5B4B9DE490016C7174B108592", hash_generated_method = "0576AAE531469FFFDA5E687889475589")
    @Override
    public void sendStickyOrderedBroadcast(Intent intent,
            BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData,
           Bundle initialExtras) {
        addTaint(initialExtras.getTaint());
        addTaint(initialData.getTaint());
        addTaint(initialCode);
        addTaint(scheduler.getTaint());
        addTaint(resultReceiver.getTaint());
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1016445522 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1016445522.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1016445522;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.116 -0400", hash_original_method = "171AE827F280EA82963EC0D862FF9728", hash_generated_method = "D9CC101FA2B8EB8DF07CC4DB0C4F4500")
    @Override
    public void removeStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1740128867 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1740128867.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1740128867;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.116 -0400", hash_original_method = "0850381B9C1FC302FA99B7B33A5E73A3", hash_generated_method = "160B8AB52C441A75C1C5AA73BA780373")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1209807553 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1209807553.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1209807553;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.116 -0400", hash_original_method = "38D46FC990EC0A671B9656203023C7E3", hash_generated_method = "D034157E024213C5C8087680DF4A3ECC")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1461387121 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1461387121.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1461387121;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.116 -0400", hash_original_method = "181E8EC9461ECBFDA8BFB6A0E30406B9", hash_generated_method = "ED7FEE6BC15344C84169B43BB8F4B433")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        addTaint(receiver.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2090042397 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2090042397.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2090042397;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.116 -0400", hash_original_method = "E1F1505B58131FB6B0B7748694608436", hash_generated_method = "B05CC0C9781ED52C47CF630E52508939")
    @Override
    public ComponentName startService(Intent service) {
        addTaint(service.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_978164486 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_978164486.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_978164486;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.117 -0400", hash_original_method = "6B730D00DB06298D95F2B7A23DAD395A", hash_generated_method = "BD2602EE0EBE87B8170B9B3998C002CB")
    @Override
    public boolean stopService(Intent service) {
        addTaint(service.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_234576779 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_234576779.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_234576779;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.117 -0400", hash_original_method = "BFAA291B41512300628CDA2B72A00114", hash_generated_method = "9343DBE10A0E32C3F8B91A601D0BDE6B")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1628736063 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1628736063.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1628736063;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.117 -0400", hash_original_method = "87503CB05E3F8FB5C16291E093E4FB05", hash_generated_method = "DA1364E57271314E98199496CA568B3A")
    @Override
    public void unbindService(ServiceConnection conn) {
        addTaint(conn.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2100806073 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2100806073.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2100806073;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.117 -0400", hash_original_method = "30A10D280B19E6882E6D642EC1CD4917", hash_generated_method = "9BFC4F1476BE34238DF4A35DE187B65C")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        addTaint(arguments.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(className.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_611123914 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_611123914.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_611123914;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.117 -0400", hash_original_method = "68E01286CFC0F57628C767DFD8F3DBC4", hash_generated_method = "BF99240AE6A669C4DC5C5442F09F4D01")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1183346129 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1183346129.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1183346129;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.117 -0400", hash_original_method = "FA0054E6225B3DA4E3AB5C60EE5617B0", hash_generated_method = "5AA0C2ACD0A9CE48AB26672105B5F0E0")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1504704833 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1504704833.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1504704833;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.118 -0400", hash_original_method = "39E4CC67C115397A8C51691BDA0DEFFF", hash_generated_method = "45D929ACCD08187D1D864B4EAD622D90")
    @Override
    public int checkCallingPermission(String permission) {
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1897708301 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1897708301.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1897708301;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.118 -0400", hash_original_method = "5DC2D3BE454D628902BC654B11EC880D", hash_generated_method = "F8D8BDE53926494EC52B13493EAA63F4")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_639680869 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_639680869.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_639680869;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.118 -0400", hash_original_method = "56C405B921CD26186CE93AE4FCE77002", hash_generated_method = "0CB8CCEBC8EF1A299BFDB3944B5BFC57")
    @Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        addTaint(message.getTaint());
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1799286131 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1799286131.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1799286131;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.118 -0400", hash_original_method = "404869BFDC0DC9DF47C55A15B6DC4397", hash_generated_method = "14CB8234736635560C0B1BF10F5C27FE")
    @Override
    public void enforceCallingPermission(String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1409747007 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1409747007.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1409747007;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.118 -0400", hash_original_method = "DF4E179747318B1B15E40F55606A37E9", hash_generated_method = "AEDA1738FA7042E8AE9A79147BDFD5B7")
    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_27333296 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_27333296.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_27333296;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.118 -0400", hash_original_method = "CA3402270A11C945C3AA0E7919220352", hash_generated_method = "60B861020D18FC0670AC6C0063FB317D")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        addTaint(toPackage.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_746839225 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_746839225.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_746839225;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.118 -0400", hash_original_method = "A5567E6B8C539B68F363AE3EA825B3B1", hash_generated_method = "0997CD279F575F8296A2916465A1D9A0")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1162503285 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1162503285.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1162503285;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.119 -0400", hash_original_method = "01DA97890A1635A805E6ABA70EA7E1A2", hash_generated_method = "30AFE3A640A3BB35412D68185E7B2AFD")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_705003782 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_705003782.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_705003782;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.119 -0400", hash_original_method = "0E91A21D8BB5EE13B32E9508DC980D04", hash_generated_method = "C3F11F6D167FA9331B55D0DC1D838E54")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1704543488 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1704543488.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1704543488;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.119 -0400", hash_original_method = "4E907F188543B6F68B290447CBA938FC", hash_generated_method = "757BC0D52CA688491B95B158A0735F43")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1081026122 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1081026122.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1081026122;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.119 -0400", hash_original_method = "10E5B81078B4D8C80FD1ADA81F59A293", hash_generated_method = "4B1B959D253F7C38C46DF4FEA215347F")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(writePermission.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1202094492 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1202094492.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1202094492;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.119 -0400", hash_original_method = "D6C517671FDE2208703A3C3A6D7AC623", hash_generated_method = "780FC49EF51C2D79B79BDCFC382932DB")
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1174965500 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1174965500.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1174965500;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.119 -0400", hash_original_method = "5404073C28217A8FED2D1029326FF0C1", hash_generated_method = "0F9336DD6499E5B6713C9F3BFF546914")
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_337019672 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_337019672.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_337019672;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.120 -0400", hash_original_method = "581596FE93D696843E16CDAA47A17F02", hash_generated_method = "74CDF3CAF309C2F3E0D5EAACEADD9D38")
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2141992462 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2141992462.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2141992462;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.120 -0400", hash_original_method = "3F20BE4E74327552B96137FD3F126AED", hash_generated_method = "B9227D7AA77915FDC68A0B738C315402")
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
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_390277056 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_390277056.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_390277056;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.121 -0400", hash_original_method = "0406DB1DB1C22587C63AD75F49E0CA3F", hash_generated_method = "74E98FE06D78EB31A4D42F2141F02E6A")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        addTaint(flags);
        addTaint(packageName.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1612240259 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1612240259.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1612240259;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:36.121 -0400", hash_original_method = "B79081A4CFC106615A2ECE230BC1B163", hash_generated_method = "9F125BCD38A2739C1F112AD34338F0D3")
    @Override
    public boolean isRestricted() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1050100097 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1050100097.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1050100097;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

