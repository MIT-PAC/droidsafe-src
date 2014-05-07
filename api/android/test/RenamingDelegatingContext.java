package android.test;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

import android.content.ContentProvider;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.FileUtils;

import com.google.android.collect.Sets;

public class RenamingDelegatingContext extends ContextWrapper {
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.561 -0500", hash_original_field = "276841D30372F31C614BEDC7C2DB0F3F", hash_generated_field = "25D64DDA3F3009238ABDBADB548AC0B2")

    private Context mFileContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.563 -0500", hash_original_field = "02F7230E3B151BE1BDE6BF00418690D1", hash_generated_field = "38B9F00B3B94348DD3ACD5CEC6A09DEE")

    private String mFilePrefix = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.566 -0500", hash_original_field = "A968B97901F84DB3DB0A9D87FA171669", hash_generated_field = "DAD88E122F93A5C508E14D87A3BF9A70")

    private File mCacheDir;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.568 -0500", hash_original_field = "349D1EAD6A3DD6EDFBBB76E7AC55FC2F", hash_generated_field = "E2A875EF987A77EEC850F20D740B8615")

    private final Object mSync = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.570 -0500", hash_original_field = "9D48467151A424B3E3EF9ACC90242FD1", hash_generated_field = "E5CA7AE9199D32A37BD4AFE76E3BB38A")

    private Set<String> mDatabaseNames = Sets.newHashSet();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.572 -0500", hash_original_field = "FE1DBA3D9B039912878F17A7B1D23A01", hash_generated_field = "D758D404A6E30EDA7FC4BE6DA91D9289")

    private Set<String> mFileNames = Sets.newHashSet();

    /**
     * @param context : the context that will be delagated.
     * @param filePrefix : a prefix with which database and file names will be
     * prefixed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.587 -0500", hash_original_method = "B3953DF6513209A1975FCE5EE76F55AB", hash_generated_method = "A256AB97B748BDC9A0654DEDA67C5AA5")
    
public RenamingDelegatingContext(Context context, String filePrefix) {
        super(context);
        mFileContext = context;
        mFilePrefix = filePrefix;
    }

    /**
     * @param context : the context that will be delagated.
     * @param fileContext : the context that file and db methods will be delgated to
     * @param filePrefix : a prefix with which database and file names will be
     * prefixed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.589 -0500", hash_original_method = "9AEB362670EE8793CD7E6E8A367BD018", hash_generated_method = "0C79FC403716AE0CB3AEB29828F954FF")
    
public RenamingDelegatingContext(Context context, Context fileContext, String filePrefix) {
        super(context);
        mFileContext = fileContext;
        mFilePrefix = filePrefix;
    }

    /**
     * Makes accessible all files and databases whose names match the filePrefix that was passed to
     * the constructor. Normally only files and databases that were created through this context are
     * accessible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.579 -0500", hash_original_method = "2EB6B2D69F57A98D3ED2F6FA78A12FF7", hash_generated_method = "AC44C7C697ADB9F7CD12634D754B8616")
    
public void makeExistingFilesAndDbsAccessible() {
        String[] databaseList = mFileContext.databaseList();
        for (String diskName : databaseList) {
            if (shouldDiskNameBeVisible(diskName)) {
                mDatabaseNames.add(publicNameFromDiskName(diskName));
            }
        }
        String[] fileList = mFileContext.fileList();
        for (String diskName : fileList) {
            if (shouldDiskNameBeVisible(diskName)) {
                mFileNames.add(publicNameFromDiskName(diskName));
            }
        }
    }

    /**
     * Returns if the given diskName starts with the given prefix or not.
     * @param diskName name of the database/file.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.581 -0500", hash_original_method = "AE14EC823AA36078EBCBA6012466D013", hash_generated_method = "AE14EC823AA36078EBCBA6012466D013")
    
boolean shouldDiskNameBeVisible(String diskName) {
        return diskName.startsWith(mFilePrefix);
    }

    /**
     * Returns the public name (everything following the prefix) of the given diskName.
     * @param diskName name of the database/file.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.584 -0500", hash_original_method = "D497FA9053D718AE60BC2EFC5B528C4E", hash_generated_method = "D497FA9053D718AE60BC2EFC5B528C4E")
    
String publicNameFromDiskName(String diskName) {
        if (!shouldDiskNameBeVisible(diskName)) {
            throw new IllegalArgumentException("disk file should not be visible: " + diskName);
        }
        return diskName.substring(mFilePrefix.length(), diskName.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.592 -0500", hash_original_method = "417E64563BC7C8978E920D60AB5E069C", hash_generated_method = "DDAB411AE45E4397D7B8F4B4ED48EBA9")
    
public String getDatabasePrefix() {
        return mFilePrefix;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.594 -0500", hash_original_method = "288CD7FC3C9C01601C3178A31BF94464", hash_generated_method = "9CB493252D80F3E37E2B048587C901B6")
    
private String renamedFileName(String name) {
        return mFilePrefix + name;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.596 -0500", hash_original_method = "8FAA8E1E53764FC0A8E9121526A72753", hash_generated_method = "548721C6C605C38ED61702005824887D")
    
@Override
    public SQLiteDatabase openOrCreateDatabase(String name,
            int mode, SQLiteDatabase.CursorFactory factory) {
        final String internalName = renamedFileName(name);
        if (!mDatabaseNames.contains(name)) {
            mDatabaseNames.add(name);
            mFileContext.deleteDatabase(internalName);
        }
        return mFileContext.openOrCreateDatabase(internalName, mode, factory);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.599 -0500", hash_original_method = "83010A5AB0E017E780AA0ED965C40832", hash_generated_method = "A43C703F1B49A27097ECC27DF33EE9EC")
    
@Override
    public SQLiteDatabase openOrCreateDatabase(String name,
            int mode, SQLiteDatabase.CursorFactory factory, DatabaseErrorHandler errorHandler) {
        final String internalName = renamedFileName(name);
        if (!mDatabaseNames.contains(name)) {
            mDatabaseNames.add(name);
            mFileContext.deleteDatabase(internalName);
        }
        return mFileContext.openOrCreateDatabase(internalName, mode, factory, errorHandler);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.601 -0500", hash_original_method = "769583112D24FD602F7B9C331E63368D", hash_generated_method = "7A8AF00AB9512BA290868B36C8532A58")
    
@Override
    public boolean deleteDatabase(String name) {
        if (mDatabaseNames.contains(name)) {
            mDatabaseNames.remove(name);
            return mFileContext.deleteDatabase(renamedFileName(name));
        } else {
            return false;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.604 -0500", hash_original_method = "D9A3864414B54AB528512CE33B05FB4D", hash_generated_method = "56646076A0F271A179640E1F86969B74")
    
@Override
    public File getDatabasePath(String name) {
        return mFileContext.getDatabasePath(renamedFileName(name));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.606 -0500", hash_original_method = "C72F928FF6D1DE8462B16697F47B8129", hash_generated_method = "1E6447EA877984E40672D2D0088850A7")
    
@Override
    public String[] databaseList() {
        return mDatabaseNames.toArray(new String[]{});
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.608 -0500", hash_original_method = "22834974648353EE4B305B5F791B6612", hash_generated_method = "ADA9CC229E008B0376003841590912BC")
    
@Override
    public FileInputStream openFileInput(String name)
            throws FileNotFoundException {
        final String internalName = renamedFileName(name);
        if (mFileNames.contains(name)) {
            return mFileContext.openFileInput(internalName);
        } else {
            throw new FileNotFoundException(internalName);
        }
    }

    @DSSink(DSSinkKind.FILE)
    @DSSpec(DSCat.IO)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.612 -0500", hash_original_method = "BAFF09712F6A622B6FB90CC40B6EB538", hash_generated_method = "35066B5940DAC2748FDA30C1232F6747")
    
@Override
    public FileOutputStream openFileOutput(String name, int mode)
            throws FileNotFoundException {
        mFileNames.add(name);
        return mFileContext.openFileOutput(renamedFileName(name), mode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.614 -0500", hash_original_method = "46FF4FEA40FAAA40585EE8088997DFB9", hash_generated_method = "39CCB79239D930B50514FF5C82DB9426")
    
@Override
    public File getFileStreamPath(String name) {
        return mFileContext.getFileStreamPath(renamedFileName(name));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.616 -0500", hash_original_method = "B618668AF514509A928F75BC70031AF8", hash_generated_method = "D06E22A69BB7B8A2D949644DDB8F7B63")
    
@Override
    public boolean deleteFile(String name) {
        if (mFileNames.contains(name)) {
            mFileNames.remove(name);
            return mFileContext.deleteFile(renamedFileName(name));
        } else {
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.618 -0500", hash_original_method = "945BB3C3C9DB1E1310115126C2994271", hash_generated_method = "3FE2B69EEFC9142F2C2DD2481EC34499")
    
@Override
    public String[] fileList() {
        return mFileNames.toArray(new String[]{});
    }
    
    /**
     * In order to support calls to getCacheDir(), we create a temp cache dir (inside the real
     * one) and return it instead.  This code is basically getCacheDir(), except it uses the real
     * cache dir as the parent directory and creates a test cache dir inside that.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:46.621 -0500", hash_original_method = "46556D7A64741ECB467E5CBBE771B4E0", hash_generated_method = "90BED60B6DFDDAEF16739A02E4D581D8")
    
@Override
    public File getCacheDir() {
        synchronized (mSync) {
            if (mCacheDir == null) {
                mCacheDir = new File(mFileContext.getCacheDir(), renamedFileName("cache"));
            }
            if (!mCacheDir.exists()) {
                if(!mCacheDir.mkdirs()) {
                    Log.w("RenamingDelegatingContext", "Unable to create cache directory");
                    return null;
                }
                FileUtils.setPermissions(
                        mCacheDir.getPath(),
                        FileUtils.S_IRWXU|FileUtils.S_IRWXG|FileUtils.S_IXOTH,
                        -1, -1);
            }
        }
        return mCacheDir;
    }
    
}

