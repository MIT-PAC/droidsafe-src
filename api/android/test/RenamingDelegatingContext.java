package android.test;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.159 -0400", hash_original_field = "B621E04F879EF969C870D02B930BA150", hash_generated_field = "25D64DDA3F3009238ABDBADB548AC0B2")

    private Context mFileContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.159 -0400", hash_original_field = "5A6823A122A2BB98202A2BD8B338B839", hash_generated_field = "38B9F00B3B94348DD3ACD5CEC6A09DEE")

    private String mFilePrefix = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.159 -0400", hash_original_field = "0635BA74861D7387F8A35531AB504605", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.159 -0400", hash_original_field = "99CA2AB98020F687D6F8CAD3BC28A985", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.159 -0400", hash_original_field = "3020D00F938F2219E2941FFC2B7332B7", hash_generated_field = "E5CA7AE9199D32A37BD4AFE76E3BB38A")

    private Set<String> mDatabaseNames = Sets.newHashSet();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.159 -0400", hash_original_field = "A9C4BA8BEBE8A1DAE6504580466348D9", hash_generated_field = "D758D404A6E30EDA7FC4BE6DA91D9289")

    private Set<String> mFileNames = Sets.newHashSet();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.160 -0400", hash_original_method = "B3953DF6513209A1975FCE5EE76F55AB", hash_generated_method = "5EABB90B602757D42ED9DE1181DD6708")
    public  RenamingDelegatingContext(Context context, String filePrefix) {
        super(context);
        mFileContext = context;
        mFilePrefix = filePrefix;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.160 -0400", hash_original_method = "9AEB362670EE8793CD7E6E8A367BD018", hash_generated_method = "8D4196C8EBC520F1B1BB3DCC072B4B21")
    public  RenamingDelegatingContext(Context context, Context fileContext, String filePrefix) {
        super(context);
        addTaint(context.getTaint());
        mFileContext = fileContext;
        mFilePrefix = filePrefix;
        
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.161 -0400", hash_original_method = "2EB6B2D69F57A98D3ED2F6FA78A12FF7", hash_generated_method = "88092B1C323B0D0EB8D585094ABFB93C")
    public void makeExistingFilesAndDbsAccessible() {
        String[] databaseList = mFileContext.databaseList();
for(String diskName : databaseList)
        {
    if(shouldDiskNameBeVisible(diskName))            
            {
                mDatabaseNames.add(publicNameFromDiskName(diskName));
            } 
        } 
        String[] fileList = mFileContext.fileList();
for(String diskName : fileList)
        {
    if(shouldDiskNameBeVisible(diskName))            
            {
                mFileNames.add(publicNameFromDiskName(diskName));
            } 
        } 
        
        
        
            
                
            
        
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.162 -0400", hash_original_method = "AE14EC823AA36078EBCBA6012466D013", hash_generated_method = "68C3096CA5915C69D9C549D86260A2FC")
     boolean shouldDiskNameBeVisible(String diskName) {
        addTaint(diskName.getTaint());
        boolean varC475EE889E5CA894DF8715CEF854B3A7_2072222556 = (diskName.startsWith(mFilePrefix));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1654228848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1654228848;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.162 -0400", hash_original_method = "D497FA9053D718AE60BC2EFC5B528C4E", hash_generated_method = "4BF6313D93CA55C01859074C909FCF3B")
     String publicNameFromDiskName(String diskName) {
        addTaint(diskName.getTaint());
    if(!shouldDiskNameBeVisible(diskName))        
        {
            IllegalArgumentException varB87E5E9841F3CD5EE783CC487F5E1612_1029457413 = new IllegalArgumentException("disk file should not be visible: " + diskName);
            varB87E5E9841F3CD5EE783CC487F5E1612_1029457413.addTaint(taint);
            throw varB87E5E9841F3CD5EE783CC487F5E1612_1029457413;
        } 
String var0CE097494E0BC0F82FE4E9665F1EC7B9_384922230 =         diskName.substring(mFilePrefix.length(), diskName.length());
        var0CE097494E0BC0F82FE4E9665F1EC7B9_384922230.addTaint(taint);
        return var0CE097494E0BC0F82FE4E9665F1EC7B9_384922230;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.163 -0400", hash_original_method = "417E64563BC7C8978E920D60AB5E069C", hash_generated_method = "4EF867E680DFC50834BEEFE00D7CADD1")
    public String getDatabasePrefix() {
String var362F964D970E0E1B94D1C2D044CD64A2_1409738956 =         mFilePrefix;
        var362F964D970E0E1B94D1C2D044CD64A2_1409738956.addTaint(taint);
        return var362F964D970E0E1B94D1C2D044CD64A2_1409738956;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.163 -0400", hash_original_method = "288CD7FC3C9C01601C3178A31BF94464", hash_generated_method = "04F78B8E790B597D18E40311FD2B10A0")
    private String renamedFileName(String name) {
        addTaint(name.getTaint());
String varF2801096E84D7B061A670E1505987270_2133633190 =         mFilePrefix + name;
        varF2801096E84D7B061A670E1505987270_2133633190.addTaint(taint);
        return varF2801096E84D7B061A670E1505987270_2133633190;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.164 -0400", hash_original_method = "8FAA8E1E53764FC0A8E9121526A72753", hash_generated_method = "6DC4E725CEC061BD99E713302FDC7619")
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
        } 
SQLiteDatabase varEF9AA0913B9F67D8BA83A28CF0D2C274_1469936725 =         mFileContext.openOrCreateDatabase(internalName, mode, factory);
        varEF9AA0913B9F67D8BA83A28CF0D2C274_1469936725.addTaint(taint);
        return varEF9AA0913B9F67D8BA83A28CF0D2C274_1469936725;
        
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.164 -0400", hash_original_method = "83010A5AB0E017E780AA0ED965C40832", hash_generated_method = "BE6F00C932713837D988DA628F9B5D8F")
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
        } 
SQLiteDatabase varD521834BA89A83E0413BF0F37D6D9DCE_2045450895 =         mFileContext.openOrCreateDatabase(internalName, mode, factory, errorHandler);
        varD521834BA89A83E0413BF0F37D6D9DCE_2045450895.addTaint(taint);
        return varD521834BA89A83E0413BF0F37D6D9DCE_2045450895;
        
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.165 -0400", hash_original_method = "769583112D24FD602F7B9C331E63368D", hash_generated_method = "820CCA2DB33F38CCBCBAA56007F21514")
    @Override
    public boolean deleteDatabase(String name) {
        addTaint(name.getTaint());
    if(mDatabaseNames.contains(name))        
        {
            mDatabaseNames.remove(name);
            boolean varE0577A2601440216B756B5BEC91FF6A6_476241363 = (mFileContext.deleteDatabase(renamedFileName(name)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273236599 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273236599;
        } 
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1366441271 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309516928 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_309516928;
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.165 -0400", hash_original_method = "D9A3864414B54AB528512CE33B05FB4D", hash_generated_method = "FEE492D31D6F03B2CE7744C91C529042")
    @Override
    public File getDatabasePath(String name) {
        addTaint(name.getTaint());
File var76CE04263C550BECC0F1A57BECD8BE94_1477530150 =         mFileContext.getDatabasePath(renamedFileName(name));
        var76CE04263C550BECC0F1A57BECD8BE94_1477530150.addTaint(taint);
        return var76CE04263C550BECC0F1A57BECD8BE94_1477530150;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.166 -0400", hash_original_method = "C72F928FF6D1DE8462B16697F47B8129", hash_generated_method = "DEF63B295C39BCD0A23BC3489D0D41E7")
    @Override
    public String[] databaseList() {
String[] var9D5D41B4C26BCA35487A5325A77218ED_2132598794 =         mDatabaseNames.toArray(new String[]{});
        var9D5D41B4C26BCA35487A5325A77218ED_2132598794.addTaint(taint);
        return var9D5D41B4C26BCA35487A5325A77218ED_2132598794;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.166 -0400", hash_original_method = "22834974648353EE4B305B5F791B6612", hash_generated_method = "2CE7A765C7AC9374C00B76D25949AFC3")
    @Override
    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        addTaint(name.getTaint());
        final String internalName = renamedFileName(name);
    if(mFileNames.contains(name))        
        {
FileInputStream var2BD693B4BCAD6759F4E88A5E81233801_1298620003 =             mFileContext.openFileInput(internalName);
            var2BD693B4BCAD6759F4E88A5E81233801_1298620003.addTaint(taint);
            return var2BD693B4BCAD6759F4E88A5E81233801_1298620003;
        } 
        else
        {
            FileNotFoundException var7FA59ADD56868E528F90EC0B33CEE535_229085232 = new FileNotFoundException(internalName);
            var7FA59ADD56868E528F90EC0B33CEE535_229085232.addTaint(taint);
            throw var7FA59ADD56868E528F90EC0B33CEE535_229085232;
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.166 -0400", hash_original_method = "BAFF09712F6A622B6FB90CC40B6EB538", hash_generated_method = "C8336F2EC6D0C2848848C200C0B522D2")
    @Override
    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        addTaint(mode);
        addTaint(name.getTaint());
        mFileNames.add(name);
FileOutputStream var10B6626D436D657417F8FCB752E9658B_537619580 =         mFileContext.openFileOutput(renamedFileName(name), mode);
        var10B6626D436D657417F8FCB752E9658B_537619580.addTaint(taint);
        return var10B6626D436D657417F8FCB752E9658B_537619580;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.167 -0400", hash_original_method = "46FF4FEA40FAAA40585EE8088997DFB9", hash_generated_method = "7FB90C69DA3DCB1AEB96CF25AFFD022F")
    @Override
    public File getFileStreamPath(String name) {
        addTaint(name.getTaint());
File var64D4A2E452E8A20AF76657C67B11AAE9_702904836 =         mFileContext.getFileStreamPath(renamedFileName(name));
        var64D4A2E452E8A20AF76657C67B11AAE9_702904836.addTaint(taint);
        return var64D4A2E452E8A20AF76657C67B11AAE9_702904836;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.167 -0400", hash_original_method = "B618668AF514509A928F75BC70031AF8", hash_generated_method = "AC01DA18380D9D1EC5E681022710CAE9")
    @Override
    public boolean deleteFile(String name) {
        addTaint(name.getTaint());
    if(mFileNames.contains(name))        
        {
            mFileNames.remove(name);
            boolean var4837BA085A06E18BC860B9BADF1D1F47_14111904 = (mFileContext.deleteFile(renamedFileName(name)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2029408053 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2029408053;
        } 
        else
        {
            boolean var68934A3E9455FA72420237EB05902327_1834121612 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_908484525 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_908484525;
        } 
        
        
            
            
        
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.167 -0400", hash_original_method = "945BB3C3C9DB1E1310115126C2994271", hash_generated_method = "176517D255CBA9723AF4B18E3F733F6A")
    @Override
    public String[] fileList() {
String[] varE0E91E51CD6F4F1B465DF87E6E14623F_1454034788 =         mFileNames.toArray(new String[]{});
        varE0E91E51CD6F4F1B465DF87E6E14623F_1454034788.addTaint(taint);
        return varE0E91E51CD6F4F1B465DF87E6E14623F_1454034788;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:43.168 -0400", hash_original_method = "46556D7A64741ECB467E5CBBE771B4E0", hash_generated_method = "E5A5A27158D545618D01D22070830C52")
    @Override
    public File getCacheDir() {
        synchronized
(mSync)        {
    if(mCacheDir == null)            
            {
                mCacheDir = new File(mFileContext.getCacheDir(), renamedFileName("cache"));
            } 
    if(!mCacheDir.exists())            
            {
    if(!mCacheDir.mkdirs())                
                {
File var540C13E9E156B687226421B24F2DF178_1706525673 =                     null;
                    var540C13E9E156B687226421B24F2DF178_1706525673.addTaint(taint);
                    return var540C13E9E156B687226421B24F2DF178_1706525673;
                } 
                FileUtils.setPermissions(
                        mCacheDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
            } 
        } 
File var02A188D4F0BB4497378BBD745019EB79_125504630 =         mCacheDir;
        var02A188D4F0BB4497378BBD745019EB79_125504630.addTaint(taint);
        return var02A188D4F0BB4497378BBD745019EB79_125504630;
        
        
            
                
            
            
                
                    
                    
                
                
                        
                        
                        
            
        
        
    }

    
}

