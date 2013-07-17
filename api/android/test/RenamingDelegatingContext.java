package android.test;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import com.google.android.collect.Sets;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.ContentProvider;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.FileUtils;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

public class RenamingDelegatingContext extends ContextWrapper {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.841 -0400", hash_original_field = "B621E04F879EF969C870D02B930BA150", hash_generated_field = "25D64DDA3F3009238ABDBADB548AC0B2")

    private Context mFileContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.841 -0400", hash_original_field = "5A6823A122A2BB98202A2BD8B338B839", hash_generated_field = "38B9F00B3B94348DD3ACD5CEC6A09DEE")

    private String mFilePrefix = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.842 -0400", hash_original_field = "0635BA74861D7387F8A35531AB504605", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.842 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.842 -0400", hash_original_field = "3020D00F938F2219E2941FFC2B7332B7", hash_generated_field = "E5CA7AE9199D32A37BD4AFE76E3BB38A")

    private Set<String> mDatabaseNames = Sets.newHashSet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.842 -0400", hash_original_field = "A9C4BA8BEBE8A1DAE6504580466348D9", hash_generated_field = "D758D404A6E30EDA7FC4BE6DA91D9289")

    private Set<String> mFileNames = Sets.newHashSet();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.843 -0400", hash_original_method = "B3953DF6513209A1975FCE5EE76F55AB", hash_generated_method = "5EABB90B602757D42ED9DE1181DD6708")
    public  RenamingDelegatingContext(Context context, String filePrefix) {
        super(context);
        mFileContext = context;
        mFilePrefix = filePrefix;
        // ---------- Original Method ----------
        //mFileContext = context;
        //mFilePrefix = filePrefix;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.844 -0400", hash_original_method = "9AEB362670EE8793CD7E6E8A367BD018", hash_generated_method = "8D4196C8EBC520F1B1BB3DCC072B4B21")
    public  RenamingDelegatingContext(Context context, Context fileContext, String filePrefix) {
        super(context);
        addTaint(context.getTaint());
        mFileContext = fileContext;
        mFilePrefix = filePrefix;
        // ---------- Original Method ----------
        //mFileContext = fileContext;
        //mFilePrefix = filePrefix;
    }

    
    public static <T extends ContentProvider> T providerWithRenamedContext(
            Class<T> contentProvider, Context c, String filePrefix) throws IllegalAccessException, InstantiationException {
        return providerWithRenamedContext(contentProvider, c, filePrefix, false);
    }

    
    public static <T extends ContentProvider> T providerWithRenamedContext(
            Class<T> contentProvider, Context c, String filePrefix,
            boolean allowAccessToExistingFilesAndDbs) throws IllegalAccessException, InstantiationException {
        Class<T> mProviderClass = contentProvider;
        T mProvider = mProviderClass.newInstance();
        RenamingDelegatingContext mContext = new RenamingDelegatingContext(c, filePrefix);
        if (allowAccessToExistingFilesAndDbs) {
            mContext.makeExistingFilesAndDbsAccessible();
        }
        mProvider.attachInfo(mContext, null);
        return mProvider;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.846 -0400", hash_original_method = "2EB6B2D69F57A98D3ED2F6FA78A12FF7", hash_generated_method = "88092B1C323B0D0EB8D585094ABFB93C")
    public void makeExistingFilesAndDbsAccessible() {
        String[] databaseList = mFileContext.databaseList();
for(String diskName : databaseList)
        {
            if(shouldDiskNameBeVisible(diskName))            
            {
                mDatabaseNames.add(publicNameFromDiskName(diskName));
            } //End block
        } //End block
        String[] fileList = mFileContext.fileList();
for(String diskName : fileList)
        {
            if(shouldDiskNameBeVisible(diskName))            
            {
                mFileNames.add(publicNameFromDiskName(diskName));
            } //End block
        } //End block
        // ---------- Original Method ----------
        //String[] databaseList = mFileContext.databaseList();
        //for (String diskName : databaseList) {
            //if (shouldDiskNameBeVisible(diskName)) {
                //mDatabaseNames.add(publicNameFromDiskName(diskName));
            //}
        //}
        //String[] fileList = mFileContext.fileList();
        //for (String diskName : fileList) {
            //if (shouldDiskNameBeVisible(diskName)) {
                //mFileNames.add(publicNameFromDiskName(diskName));
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.848 -0400", hash_original_method = "AE14EC823AA36078EBCBA6012466D013", hash_generated_method = "5BE638443DAA6A08A53F683B694D8180")
     boolean shouldDiskNameBeVisible(String diskName) {
        addTaint(diskName.getTaint());
        boolean varC475EE889E5CA894DF8715CEF854B3A7_814568200 = (diskName.startsWith(mFilePrefix));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1318605938 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1318605938;
        // ---------- Original Method ----------
        //return diskName.startsWith(mFilePrefix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.848 -0400", hash_original_method = "D497FA9053D718AE60BC2EFC5B528C4E", hash_generated_method = "482F7F32F089FC08DD1ABD99A30B590F")
     String publicNameFromDiskName(String diskName) {
        addTaint(diskName.getTaint());
        if(!shouldDiskNameBeVisible(diskName))        
        {
            IllegalArgumentException varB87E5E9841F3CD5EE783CC487F5E1612_1896809840 = new IllegalArgumentException("disk file should not be visible: " + diskName);
            varB87E5E9841F3CD5EE783CC487F5E1612_1896809840.addTaint(taint);
            throw varB87E5E9841F3CD5EE783CC487F5E1612_1896809840;
        } //End block
String var0CE097494E0BC0F82FE4E9665F1EC7B9_37468246 =         diskName.substring(mFilePrefix.length(), diskName.length());
        var0CE097494E0BC0F82FE4E9665F1EC7B9_37468246.addTaint(taint);
        return var0CE097494E0BC0F82FE4E9665F1EC7B9_37468246;
        // ---------- Original Method ----------
        //if (!shouldDiskNameBeVisible(diskName)) {
            //throw new IllegalArgumentException("disk file should not be visible: " + diskName);
        //}
        //return diskName.substring(mFilePrefix.length(), diskName.length());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.848 -0400", hash_original_method = "417E64563BC7C8978E920D60AB5E069C", hash_generated_method = "97E0725421465EFF1BD891E02386B068")
    public String getDatabasePrefix() {
String var362F964D970E0E1B94D1C2D044CD64A2_1776456719 =         mFilePrefix;
        var362F964D970E0E1B94D1C2D044CD64A2_1776456719.addTaint(taint);
        return var362F964D970E0E1B94D1C2D044CD64A2_1776456719;
        // ---------- Original Method ----------
        //return mFilePrefix;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.849 -0400", hash_original_method = "288CD7FC3C9C01601C3178A31BF94464", hash_generated_method = "E4C5240E9E8AE428F986E7E967894E0F")
    private String renamedFileName(String name) {
        addTaint(name.getTaint());
String varF2801096E84D7B061A670E1505987270_128525467 =         mFilePrefix + name;
        varF2801096E84D7B061A670E1505987270_128525467.addTaint(taint);
        return varF2801096E84D7B061A670E1505987270_128525467;
        // ---------- Original Method ----------
        //return mFilePrefix + name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.849 -0400", hash_original_method = "8FAA8E1E53764FC0A8E9121526A72753", hash_generated_method = "CF2B2E05988BAF65145FC251C24BD4D5")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name,
            int mode, SQLiteDatabase.CursorFactory factory) {
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
        final String internalName = renamedFileName(name);
        if(!mDatabaseNames.contains(name))        
        {
            mDatabaseNames.add(name);
            mFileContext.deleteDatabase(internalName);
        } //End block
SQLiteDatabase varEF9AA0913B9F67D8BA83A28CF0D2C274_599734229 =         mFileContext.openOrCreateDatabase(internalName, mode, factory);
        varEF9AA0913B9F67D8BA83A28CF0D2C274_599734229.addTaint(taint);
        return varEF9AA0913B9F67D8BA83A28CF0D2C274_599734229;
        // ---------- Original Method ----------
        //final String internalName = renamedFileName(name);
        //if (!mDatabaseNames.contains(name)) {
            //mDatabaseNames.add(name);
            //mFileContext.deleteDatabase(internalName);
        //}
        //return mFileContext.openOrCreateDatabase(internalName, mode, factory);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.850 -0400", hash_original_method = "83010A5AB0E017E780AA0ED965C40832", hash_generated_method = "E2A191DC6C951F8F661130C2D0558E54")
    @Override
    public SQLiteDatabase openOrCreateDatabase(String name,
            int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        addTaint(errorHandler.getTaint());
        addTaint(factory.getTaint());
        addTaint(mode);
        addTaint(name.getTaint());
        final String internalName = renamedFileName(name);
        if(!mDatabaseNames.contains(name))        
        {
            mDatabaseNames.add(name);
            mFileContext.deleteDatabase(internalName);
        } //End block
SQLiteDatabase varD521834BA89A83E0413BF0F37D6D9DCE_1295890241 =         mFileContext.openOrCreateDatabase(internalName, mode, factory, errorHandler);
        varD521834BA89A83E0413BF0F37D6D9DCE_1295890241.addTaint(taint);
        return varD521834BA89A83E0413BF0F37D6D9DCE_1295890241;
        // ---------- Original Method ----------
        //final String internalName = renamedFileName(name);
        //if (!mDatabaseNames.contains(name)) {
            //mDatabaseNames.add(name);
            //mFileContext.deleteDatabase(internalName);
        //}
        //return mFileContext.openOrCreateDatabase(internalName, mode, factory, errorHandler);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.851 -0400", hash_original_method = "769583112D24FD602F7B9C331E63368D", hash_generated_method = "2C2EA475DF3DFDB0B6338F86ACC60A60")
    @Override
    public boolean deleteDatabase(String name) {
        addTaint(name.getTaint());
        if(mDatabaseNames.contains(name))        
        {
            mDatabaseNames.remove(name);
            boolean varE0577A2601440216B756B5BEC91FF6A6_207507135 = (mFileContext.deleteDatabase(renamedFileName(name)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_259925430 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_259925430;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1529625715 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377998865 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_377998865;
        } //End block
        // ---------- Original Method ----------
        //if (mDatabaseNames.contains(name)) {
            //mDatabaseNames.remove(name);
            //return mFileContext.deleteDatabase(renamedFileName(name));
        //} else {
            //return false;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.851 -0400", hash_original_method = "D9A3864414B54AB528512CE33B05FB4D", hash_generated_method = "7580BE9F13F9055CFAD5B8C485712DD8")
    @Override
    public File getDatabasePath(String name) {
        addTaint(name.getTaint());
File var76CE04263C550BECC0F1A57BECD8BE94_1553710488 =         mFileContext.getDatabasePath(renamedFileName(name));
        var76CE04263C550BECC0F1A57BECD8BE94_1553710488.addTaint(taint);
        return var76CE04263C550BECC0F1A57BECD8BE94_1553710488;
        // ---------- Original Method ----------
        //return mFileContext.getDatabasePath(renamedFileName(name));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.852 -0400", hash_original_method = "C72F928FF6D1DE8462B16697F47B8129", hash_generated_method = "DFE39300C0589520553F86DD3A778162")
    @Override
    public String[] databaseList() {
String[] var9D5D41B4C26BCA35487A5325A77218ED_1594928931 =         mDatabaseNames.toArray(new String[]{});
        var9D5D41B4C26BCA35487A5325A77218ED_1594928931.addTaint(taint);
        return var9D5D41B4C26BCA35487A5325A77218ED_1594928931;
        // ---------- Original Method ----------
        //return mDatabaseNames.toArray(new String[]{});
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.852 -0400", hash_original_method = "22834974648353EE4B305B5F791B6612", hash_generated_method = "A0429C3915B9B2251DA0FD311E4A2048")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        addTaint(name.getTaint());
        final String internalName = renamedFileName(name);
        if(mFileNames.contains(name))        
        {
FileInputStream var2BD693B4BCAD6759F4E88A5E81233801_353665759 =             mFileContext.openFileInput(internalName);
            var2BD693B4BCAD6759F4E88A5E81233801_353665759.addTaint(taint);
            return var2BD693B4BCAD6759F4E88A5E81233801_353665759;
        } //End block
        else
        {
            FileNotFoundException var7FA59ADD56868E528F90EC0B33CEE535_177897557 = new FileNotFoundException(internalName);
            var7FA59ADD56868E528F90EC0B33CEE535_177897557.addTaint(taint);
            throw var7FA59ADD56868E528F90EC0B33CEE535_177897557;
        } //End block
        // ---------- Original Method ----------
        //final String internalName = renamedFileName(name);
        //if (mFileNames.contains(name)) {
            //return mFileContext.openFileInput(internalName);
        //} else {
            //throw new FileNotFoundException(internalName);
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.853 -0400", hash_original_method = "BAFF09712F6A622B6FB90CC40B6EB538", hash_generated_method = "3C5E2791BEDFBEA9C82599493A7E6136")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        addTaint(mode);
        addTaint(name.getTaint());
        mFileNames.add(name);
FileOutputStream var10B6626D436D657417F8FCB752E9658B_2058060826 =         mFileContext.openFileOutput(renamedFileName(name), mode);
        var10B6626D436D657417F8FCB752E9658B_2058060826.addTaint(taint);
        return var10B6626D436D657417F8FCB752E9658B_2058060826;
        // ---------- Original Method ----------
        //mFileNames.add(name);
        //return mFileContext.openFileOutput(renamedFileName(name), mode);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.853 -0400", hash_original_method = "46FF4FEA40FAAA40585EE8088997DFB9", hash_generated_method = "4EEFEA93D804A814585F8C5A3FFBEE88")
    @Override
    public File getFileStreamPath(String name) {
        addTaint(name.getTaint());
File var64D4A2E452E8A20AF76657C67B11AAE9_249271364 =         mFileContext.getFileStreamPath(renamedFileName(name));
        var64D4A2E452E8A20AF76657C67B11AAE9_249271364.addTaint(taint);
        return var64D4A2E452E8A20AF76657C67B11AAE9_249271364;
        // ---------- Original Method ----------
        //return mFileContext.getFileStreamPath(renamedFileName(name));
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.853 -0400", hash_original_method = "B618668AF514509A928F75BC70031AF8", hash_generated_method = "3E381783DD9D113881AB785D50361C78")
    @Override
    public boolean deleteFile(String name) {
        addTaint(name.getTaint());
        if(mFileNames.contains(name))        
        {
            mFileNames.remove(name);
            boolean var4837BA085A06E18BC860B9BADF1D1F47_1448461714 = (mFileContext.deleteFile(renamedFileName(name)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_885717444 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_885717444;
        } //End block
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_416105237 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_204218929 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_204218929;
        } //End block
        // ---------- Original Method ----------
        //if (mFileNames.contains(name)) {
            //mFileNames.remove(name);
            //return mFileContext.deleteFile(renamedFileName(name));
        //} else {
            //return false;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.854 -0400", hash_original_method = "945BB3C3C9DB1E1310115126C2994271", hash_generated_method = "9B2BB1DE65569A8C63446C249AEB4B1C")
    @Override
    public String[] fileList() {
String[] varE0E91E51CD6F4F1B465DF87E6E14623F_1404161158 =         mFileNames.toArray(new String[]{});
        varE0E91E51CD6F4F1B465DF87E6E14623F_1404161158.addTaint(taint);
        return varE0E91E51CD6F4F1B465DF87E6E14623F_1404161158;
        // ---------- Original Method ----------
        //return mFileNames.toArray(new String[]{});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:35.854 -0400", hash_original_method = "46556D7A64741ECB467E5CBBE771B4E0", hash_generated_method = "59406644C1BD41EB3D6E089A26C428FF")
    @Override
    public File getCacheDir() {
        synchronized
(mSync)        {
            if(mCacheDir == null)            
            {
                mCacheDir = new File(mFileContext.getCacheDir(), renamedFileName("cache"));
            } //End block
            if(!mCacheDir.exists())            
            {
                if(!mCacheDir.mkdirs())                
                {
File var540C13E9E156B687226421B24F2DF178_465137760 =                     null;
                    var540C13E9E156B687226421B24F2DF178_465137760.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_465137760;
                } //End block
                FileUtils.setPermissions(
                        mCacheDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
            } //End block
        } //End block
File var02A188D4F0BB4497378BBD745019EB79_230759785 =         mCacheDir;
        var02A188D4F0BB4497378BBD745019EB79_230759785.addTaint(taint);
        return var02A188D4F0BB4497378BBD745019EB79_230759785;
        // ---------- Original Method ----------
        //synchronized (mSync) {
            //if (mCacheDir == null) {
                //mCacheDir = new File(mFileContext.getCacheDir(), renamedFileName("cache"));
            //}
            //if (!mCacheDir.exists()) {
                //if(!mCacheDir.mkdirs()) {
                    //Log.w("RenamingDelegatingContext", "Unable to create cache directory");
                    //return null;
                //}
                //FileUtils.setPermissions(
                        //mCacheDir.getPath(),
                        //FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        //-1, -1);
            //}
        //}
        //return mCacheDir;
    }

    
}

