package android.test.mock;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MockContext extends Context {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.429 -0400", hash_original_method = "3BD432D7D653C5930EE983B863B99E4B", hash_generated_method = "3BD432D7D653C5930EE983B863B99E4B")
    public MockContext ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.430 -0400", hash_original_method = "CF22466B77047295B0A90CFB1E700947", hash_generated_method = "EBBE630C854716EBFD4C8B43AA205D45")
    @Override
    public AssetManager getAssets() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1781309587 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1781309587.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1781309587;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.430 -0400", hash_original_method = "C54B5267A2D44CE04E49213C47F52259", hash_generated_method = "3BDB1811D8201F1B7C0EE3F67B50321C")
    @Override
    public Resources getResources() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_301204751 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_301204751.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_301204751;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.430 -0400", hash_original_method = "E88041AF08BE295672677A7AE875FEFF", hash_generated_method = "B7FC40830B0BE5BB776CCE90B9905866")
    @Override
    public PackageManager getPackageManager() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_551293616 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_551293616.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_551293616;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.431 -0400", hash_original_method = "61790CFAFC8BCC32869A9B01BEB1BF44", hash_generated_method = "8D208B843FD0E7FD4815E8DD21CDCA73")
    @Override
    public ContentResolver getContentResolver() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2070892657 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2070892657.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2070892657;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.431 -0400", hash_original_method = "962B8DEC28714F6FEBBFE04F24E90B9C", hash_generated_method = "6F9413FD8AE17D1A158327D66460CD7E")
    @Override
    public Looper getMainLooper() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1343761715 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1343761715.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1343761715;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.432 -0400", hash_original_method = "7D1710194777282B9AA7CA1905E51B18", hash_generated_method = "AA0617950A0B1A74E7A657DA5882E87D")
    @Override
    public Context getApplicationContext() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1632601292 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1632601292.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1632601292;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.432 -0400", hash_original_method = "060683B1D8FC90BB795699914548359D", hash_generated_method = "695D862B4DD50288D3661AFA2D72799B")
    @Override
    public void setTheme(int resid) {
        addTaint(resid);
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_338421987 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_338421987.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_338421987;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.433 -0400", hash_original_method = "D8312749B850F43C5A70B4ED63CC08E3", hash_generated_method = "6092C9BE5A19E937DBFBB79EEE8C1F96")
    @Override
    public Resources.Theme getTheme() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_968808646 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_968808646.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_968808646;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.433 -0400", hash_original_method = "C51DF920D125BDAE90130F458F1F9388", hash_generated_method = "54499EE185511541EF870E8EAB8A02CF")
    @Override
    public ClassLoader getClassLoader() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1247420927 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1247420927.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1247420927;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.433 -0400", hash_original_method = "6D0C58F8CBE63957D6DF922F2249B8C5", hash_generated_method = "F74CCEE813FFC3467950D8F1A453C25F")
    @Override
    public String getPackageName() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1654714930 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1654714930.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1654714930;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.433 -0400", hash_original_method = "6E8F7F76B2482C387134CAE0922B8764", hash_generated_method = "AAE4290CE592222061E40863BE39E541")
    @Override
    public ApplicationInfo getApplicationInfo() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_755849485 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_755849485.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_755849485;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.434 -0400", hash_original_method = "C89556570A09E26932F56B416A239F82", hash_generated_method = "6029ADEAEB21AF914E366FA791DD1EB2")
    @Override
    public String getPackageResourcePath() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_598986966 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_598986966.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_598986966;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.434 -0400", hash_original_method = "FA444114F9C54186D6D89E2CA249FBCF", hash_generated_method = "33E11BEECC49D2DEFDAC9BD1D2D7A302")
    @Override
    public File getSharedPrefsFile(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1235683317 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1235683317.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1235683317;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.434 -0400", hash_original_method = "92AFBFFE30EEE36D5D46293F4B78E905", hash_generated_method = "13B178EC850A5F9F0F10CAA6978D268E")
    @Override
    public String getPackageCodePath() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1904220987 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1904220987.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1904220987;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.435 -0400", hash_original_method = "7A0D76AB436CE8A39BBA6ED25153EABF", hash_generated_method = "C85EB12D62D6FF26AC152CE0033A006A")
    @Override
    public SharedPreferences getSharedPreferences(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1141478410 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1141478410.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1141478410;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.435 -0400", hash_original_method = "6F9D455A12BE93D87BC450FB84CABAF4", hash_generated_method = "81B17E78E20A24A3D633AF3E8FCD3264")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2088280706 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2088280706.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2088280706;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.435 -0400", hash_original_method = "06BE4C94ED3C4C2DFF4AC6484EAC8136", hash_generated_method = "7274E31D94918AE7B3F48B1EB771E590")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        addTaint(mode);
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_187092130 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_187092130.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_187092130;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.435 -0400", hash_original_method = "52E0F39A74289A48663341DDCEF037DC", hash_generated_method = "4D20400413DD57A5312E02522F0A048B")
    @Override
    public boolean deleteFile(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1161531348 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1161531348.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1161531348;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.436 -0400", hash_original_method = "466D6BF0E43B95D4B6EB41E58C265707", hash_generated_method = "CF969F0249ED77AEDC2767945FE531E8")
    @Override
    public File getFileStreamPath(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_795558897 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_795558897.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_795558897;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.436 -0400", hash_original_method = "59F9DE1DC3F61B801C5281F9E3C6E2A4", hash_generated_method = "7BC0545BE0AD627922075AE12D53FEA0")
    @Override
    public String[] fileList() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_304414144 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_304414144.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_304414144;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.436 -0400", hash_original_method = "DBAC6A56B922EB1BA78CA1746FBB8CC3", hash_generated_method = "6062F1286C0F96AF6BBF087F116C79E6")
    @Override
    public File getFilesDir() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_535664811 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_535664811.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_535664811;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.436 -0400", hash_original_method = "90C15C4E056A492114901C79423D8DCF", hash_generated_method = "279519D8B5F11E2FFAC941D7F4786CB4")
    @Override
    public File getExternalFilesDir(String type) {
        addTaint(type.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1516535562 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1516535562.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1516535562;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.437 -0400", hash_original_method = "702F9A452622032EC8233CE54867C377", hash_generated_method = "685D79615313305E53C1353F3A9F4DFE")
    @Override
    public File getObbDir() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2037043397 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2037043397.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2037043397;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.437 -0400", hash_original_method = "FDF4A6103F9B59802F7D5E28BF5EFD3A", hash_generated_method = "A4D286BD3FD72FB0679EC88522478C05")
    @Override
    public File getCacheDir() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_273597078 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_273597078.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_273597078;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.437 -0400", hash_original_method = "2A92DC096DA51370A1334577ECF09ECC", hash_generated_method = "F98A0D49C89B6896656D7812A321BFEC")
    @Override
    public File getExternalCacheDir() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2063987370 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2063987370.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2063987370;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.437 -0400", hash_original_method = "34B447CE41C4ED84D6396B7E9780C31D", hash_generated_method = "CEEF85A1940083C08BDA6F77B56BAC10")
    @Override
    public File getDir(String name, int mode) {
        addTaint(mode);
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1194194633 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1194194633.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1194194633;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.438 -0400", hash_original_method = "CD5FDC840DBA80E0D8DDF078BF714DEA", hash_generated_method = "7CAADA8989CBC9695B5A6F4BBE7FBD4C")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String file, int mode, 
            SQLiteDatabase.CursorFactory factory) {
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(file.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1441438 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1441438.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1441438;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.438 -0400", hash_original_method = "7939EB7F51D4EA520B25C26292DA454F", hash_generated_method = "C90F6E66CA8048E980D1C1199B2BD78B")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String file, int mode,
            SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        addTaint(errorHandler.getTaint());
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(file.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1880179320 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1880179320.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1880179320;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.438 -0400", hash_original_method = "E48DC3F924F870943E4E36BC470CEAAB", hash_generated_method = "59DD08D08A11700D3A4FAA185D5938C9")
    @Override
    public File getDatabasePath(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_984069638 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_984069638.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_984069638;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.438 -0400", hash_original_method = "B170F7706E5C42A003C64B941E6F02C3", hash_generated_method = "E7DF585704EEA0118A5DD6E11D9DBB3D")
    @Override
    public String[] databaseList() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_426481690 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_426481690.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_426481690;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.439 -0400", hash_original_method = "F910F6C68A7FB093015261F7E1433E12", hash_generated_method = "232A5E3856A66B8518503F28400DF283")
    @Override
    public boolean deleteDatabase(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_445944908 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_445944908.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_445944908;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.446 -0400", hash_original_method = "B684586EF353D1CCAA3450E5FF9DC08F", hash_generated_method = "44E97B6926E7992041B1A0FBFE457BFD")
    @Override
    public Drawable getWallpaper() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1933670070 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1933670070.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1933670070;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.446 -0400", hash_original_method = "30AAB697F190292EC6A7D3C51657B6D7", hash_generated_method = "9E610F81C323E7BF3D32456B58EAADC7")
    @Override
    public Drawable peekWallpaper() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_35425077 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_35425077.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_35425077;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.446 -0400", hash_original_method = "4F392818CCC81F3909BB8C9EA84C5ED2", hash_generated_method = "E07AC1D5570D6E2876A3F6D23427AB35")
    @Override
    public int getWallpaperDesiredMinimumWidth() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1554662114 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1554662114.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1554662114;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.446 -0400", hash_original_method = "109D2D0B104293A4F52BC55EADD30F43", hash_generated_method = "7721BD41454EE1C6D9EEC5960B7FC09D")
    @Override
    public int getWallpaperDesiredMinimumHeight() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1532496706 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1532496706.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1532496706;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.447 -0400", hash_original_method = "13366CFA01CCB9E3D0D5A885A1E3BD82", hash_generated_method = "813BDEC75B9F428B7772BA290A74506D")
    @Override
    public void setWallpaper(Bitmap bitmap) throws IOException {
        addTaint(bitmap.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1847235625 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1847235625.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1847235625;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.447 -0400", hash_original_method = "72AC712F363F7774A80940CA93269479", hash_generated_method = "AD5668FF16AE9DEE048BB0BAB54D94FD")
    @Override
    public void setWallpaper(InputStream data) throws IOException {
        addTaint(data.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1788728281 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1788728281.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1788728281;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.447 -0400", hash_original_method = "6AFDDD74A00ECA2CECE35CA27A2C95A0", hash_generated_method = "B9C6404D7A0017C4AB9FC3AB2D68E9C8")
    @Override
    public void clearWallpaper() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_461636595 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_461636595.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_461636595;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.447 -0400", hash_original_method = "10BBC39B201767C43F0FBBE296ABD273", hash_generated_method = "90575AB0DE7291D8EFE21336A8AB881C")
    @Override
    public void startActivity(Intent intent) {
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_780023086 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_780023086.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_780023086;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.448 -0400", hash_original_method = "8A0FF876EE34DCD944B6E38C35E12478", hash_generated_method = "FC07BD195C83F5E124D8FCE4C6B5542A")
    @Override
    public void startActivities(Intent[] intents) {
        addTaint(intents[0].getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1548773713 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1548773713.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1548773713;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.448 -0400", hash_original_method = "70A0DB323D66E33A5F118512F09625C8", hash_generated_method = "9E4BF9804A80D98EB1914ED8B553E7C0")
    @Override
    public void startIntentSender(IntentSender intent,
            Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws IntentSender.SendIntentException {
        addTaint(extraFlags);
        addTaint(flagsValues);
        addTaint(flagsMask);
        addTaint(fillInIntent.getTaint());
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_646176262 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_646176262.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_646176262;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.448 -0400", hash_original_method = "7E1C16471170CAC5D2A8AEA7AFD07DD1", hash_generated_method = "5B5FD54DCCEFC507619E3C76178AD4D8")
    @Override
    public void sendBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_371080992 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_371080992.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_371080992;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.448 -0400", hash_original_method = "4C3B301BF0F66FC6027023D458D4F5CD", hash_generated_method = "F88637FE5EE5DD95EA107061803A8D1B")
    @Override
    public void sendBroadcast(Intent intent, String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1449827686 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1449827686.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1449827686;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.449 -0400", hash_original_method = "53C9E33F6F3BF762F0C7AD2D83F8B880", hash_generated_method = "8D7D313D92A3B74832E500ACDCE554B2")
    @Override
    public void sendOrderedBroadcast(Intent intent,
            String receiverPermission) {
        addTaint(receiverPermission.getTaint());
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_749000549 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_749000549.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_749000549;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.449 -0400", hash_original_method = "BD4D4F58A89D586949B717D061DAB18B", hash_generated_method = "DE50E140EA27588700893E5FDBB923CF")
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
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1875497642 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1875497642.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1875497642;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.449 -0400", hash_original_method = "F1DE7775DB33185A5749E492B31FBC7D", hash_generated_method = "FC1285B61D4D1AA78ABF9B7379C578C0")
    @Override
    public void sendStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1500132522 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1500132522.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1500132522;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.450 -0400", hash_original_method = "282E4DE5B4B9DE490016C7174B108592", hash_generated_method = "2B6179BA51007EDA9288FB49C929A9DE")
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
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_185632706 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_185632706.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_185632706;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.450 -0400", hash_original_method = "171AE827F280EA82963EC0D862FF9728", hash_generated_method = "DFD443EF7CE6532E5AADD4561B199CD9")
    @Override
    public void removeStickyBroadcast(Intent intent) {
        addTaint(intent.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_128779704 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_128779704.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_128779704;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.451 -0400", hash_original_method = "0850381B9C1FC302FA99B7B33A5E73A3", hash_generated_method = "E779CD07402AA233AB100BEC23E49630")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1820007204 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1820007204.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1820007204;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.451 -0400", hash_original_method = "38D46FC990EC0A671B9656203023C7E3", hash_generated_method = "547372CA60234C8FF4D14C9B4B01F154")
    @Override
    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter,
            String broadcastPermission, Handler scheduler) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(scheduler.getTaint());
        addTaint(broadcastPermission.getTaint());
        addTaint(filter.getTaint());
        addTaint(receiver.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1525715586 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1525715586.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1525715586;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.452 -0400", hash_original_method = "181E8EC9461ECBFDA8BFB6A0E30406B9", hash_generated_method = "4DDFFA567B603AC191DAD625E7A22EA9")
    @Override
    public void unregisterReceiver(BroadcastReceiver receiver) {
        addTaint(receiver.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1848550313 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1848550313.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1848550313;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.452 -0400", hash_original_method = "E1F1505B58131FB6B0B7748694608436", hash_generated_method = "BF63A599DE35BFF88F668CD1E511E289")
    @Override
    public ComponentName startService(Intent service) {
        addTaint(service.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_361197026 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_361197026.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_361197026;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.452 -0400", hash_original_method = "6B730D00DB06298D95F2B7A23DAD395A", hash_generated_method = "0D174CF9BA536233FB0C2B4351637747")
    @Override
    public boolean stopService(Intent service) {
        addTaint(service.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_542402747 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_542402747.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_542402747;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.453 -0400", hash_original_method = "BFAA291B41512300628CDA2B72A00114", hash_generated_method = "2656367E7C58DE5A92C37452CF2C7DDA")
    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        addTaint(flags);
        addTaint(conn.getTaint());
        addTaint(service.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_272843694 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_272843694.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_272843694;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.453 -0400", hash_original_method = "87503CB05E3F8FB5C16291E093E4FB05", hash_generated_method = "4DAE61552072F4BC2019AD0BE0C0B798")
    @Override
    public void unbindService(ServiceConnection conn) {
        addTaint(conn.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_430146902 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_430146902.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_430146902;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.453 -0400", hash_original_method = "30A10D280B19E6882E6D642EC1CD4917", hash_generated_method = "B0996BE0AB0FB7A872A487EE7A3921DA")
    @Override
    public boolean startInstrumentation(ComponentName className,
            String profileFile, Bundle arguments) {
        addTaint(arguments.getTaint());
        addTaint(profileFile.getTaint());
        addTaint(className.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_418931050 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_418931050.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_418931050;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.454 -0400", hash_original_method = "68E01286CFC0F57628C767DFD8F3DBC4", hash_generated_method = "A84B88122402091087106EF9EB98A20B")
    @Override
    public Object getSystemService(String name) {
        addTaint(name.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_957918331 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_957918331.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_957918331;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.454 -0400", hash_original_method = "FA0054E6225B3DA4E3AB5C60EE5617B0", hash_generated_method = "22750BDA07B55CE9832CF183F5FF9104")
    @Override
    public int checkPermission(String permission, int pid, int uid) {
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1861556135 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1861556135.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1861556135;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.454 -0400", hash_original_method = "39E4CC67C115397A8C51691BDA0DEFFF", hash_generated_method = "1F5275A4434C7E785E2DD2BA08550341")
    @Override
    public int checkCallingPermission(String permission) {
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_249043356 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_249043356.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_249043356;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.454 -0400", hash_original_method = "5DC2D3BE454D628902BC654B11EC880D", hash_generated_method = "EF259747D5D6D7AA59506D95CB789B17")
    @Override
    public int checkCallingOrSelfPermission(String permission) {
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1187661998 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1187661998.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1187661998;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.455 -0400", hash_original_method = "56C405B921CD26186CE93AE4FCE77002", hash_generated_method = "A9E389BBC14929918260549051D60C68")
    @Override
    public void enforcePermission(
            String permission, int pid, int uid, String message) {
        addTaint(message.getTaint());
        addTaint(uid);
        addTaint(pid);
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1996263366 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1996263366.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1996263366;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.455 -0400", hash_original_method = "404869BFDC0DC9DF47C55A15B6DC4397", hash_generated_method = "B54740C138358416D2386F9B66EA2CC4")
    @Override
    public void enforceCallingPermission(String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1732948885 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1732948885.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1732948885;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.455 -0400", hash_original_method = "DF4E179747318B1B15E40F55606A37E9", hash_generated_method = "B3E82D07D94E95D57D0E838B7EF24F8E")
    @Override
    public void enforceCallingOrSelfPermission(String permission, String message) {
        addTaint(message.getTaint());
        addTaint(permission.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1504764699 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1504764699.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1504764699;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.456 -0400", hash_original_method = "CA3402270A11C945C3AA0E7919220352", hash_generated_method = "68AAB319A0CFC3836BE6E6970BC7AE33")
    @Override
    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        addTaint(toPackage.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1788051116 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1788051116.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1788051116;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.456 -0400", hash_original_method = "A5567E6B8C539B68F363AE3EA825B3B1", hash_generated_method = "D7C126759A8C49CDB3F5E5A9D10DDCE9")
    @Override
    public void revokeUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_482609694 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_482609694.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_482609694;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.456 -0400", hash_original_method = "01DA97890A1635A805E6ABA70EA7E1A2", hash_generated_method = "47658A541D2D8C9410407B0E30FB022A")
    @Override
    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1624807229 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1624807229.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1624807229;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.456 -0400", hash_original_method = "0E91A21D8BB5EE13B32E9508DC980D04", hash_generated_method = "C1D112186B3FED14F139498C8EEE0B15")
    @Override
    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_952451196 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_952451196.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_952451196;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.457 -0400", hash_original_method = "4E907F188543B6F68B290447CBA938FC", hash_generated_method = "E129AC93A68C1A77FA748B70006CBE10")
    @Override
    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1110337104 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1110337104.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1110337104;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.457 -0400", hash_original_method = "10E5B81078B4D8C80FD1ADA81F59A293", hash_generated_method = "2B46110CE8120D0D7AA8D9989371954D")
    @Override
    public int checkUriPermission(Uri uri, String readPermission,
            String writePermission, int pid, int uid, int modeFlags) {
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(writePermission.getTaint());
        addTaint(readPermission.getTaint());
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1024137842 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1024137842.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1024137842;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.457 -0400", hash_original_method = "D6C517671FDE2208703A3C3A6D7AC623", hash_generated_method = "8D3C7973FBF8B5347C283574BA40AD5C")
    @Override
    public void enforceUriPermission(
            Uri uri, int pid, int uid, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uid);
        addTaint(pid);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_630179361 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_630179361.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_630179361;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.458 -0400", hash_original_method = "5404073C28217A8FED2D1029326FF0C1", hash_generated_method = "B6BE422CADAEEC604FF1C334E87FF547")
    @Override
    public void enforceCallingUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_741705486 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_741705486.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_741705486;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.458 -0400", hash_original_method = "581596FE93D696843E16CDAA47A17F02", hash_generated_method = "A783A1E71D1B060029D11AEE11BEFD82")
    @Override
    public void enforceCallingOrSelfUriPermission(
            Uri uri, int modeFlags, String message) {
        addTaint(message.getTaint());
        addTaint(modeFlags);
        addTaint(uri.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_497184416 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_497184416.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_497184416;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.458 -0400", hash_original_method = "3F20BE4E74327552B96137FD3F126AED", hash_generated_method = "C70D5AECA789EDB4DF72CAF622232A92")
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
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_2102098332 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_2102098332.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_2102098332;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.459 -0400", hash_original_method = "0406DB1DB1C22587C63AD75F49E0CA3F", hash_generated_method = "60CC43A13EDC575A128FED0DBD86F991")
    @Override
    public Context createPackageContext(String packageName, int flags) throws PackageManager.NameNotFoundException {
        addTaint(flags);
        addTaint(packageName.getTaint());
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_1951447671 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_1951447671.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_1951447671;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.459 -0400", hash_original_method = "B79081A4CFC106615A2ECE230BC1B163", hash_generated_method = "1902AAC3ED6E6830D2675B02AB1100F3")
    @Override
    public boolean isRestricted() {
        UnsupportedOperationException var81FA7E299EEE7F062EBFBEEF08B0464D_27820441 = new UnsupportedOperationException();
        var81FA7E299EEE7F062EBFBEEF08B0464D_27820441.addTaint(taint);
        throw var81FA7E299EEE7F062EBFBEEF08B0464D_27820441;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException();
    }

    
}

