/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package android.mtp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.Context;
import android.content.ContentValues;
import android.content.IContentProvider;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaScanner;
import android.net.Uri;
import android.os.Environment;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images;
import android.provider.MediaStore.MediaColumns;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

/**
 * {@hide}
 */
public class MtpDatabase {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.068 -0400", hash_original_field = "131C56E13EF7F1A4CB99A1E208A20A81", hash_generated_field = "68FD618B03744263304DEBBC6BC84BF6")


    private static final String TAG = "MtpDatabase";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.091 -0400", hash_original_field = "F1FAFA4108605695CE56CD81A1D3BAFF", hash_generated_field = "A5A9438D83781BEDCC6D653BCD792149")

    private static final int DEVICE_PROPERTIES_DATABASE_VERSION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.093 -0400", hash_original_field = "CC7F74A8BAFE59070A4347A2CFAB8C1D", hash_generated_field = "F7CAB2143BDD5134F67BA1EAB019CA60")


    private static final String[] ID_PROJECTION = new String[] {
            Files.FileColumns._ID, // 0
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.095 -0400", hash_original_field = "672A1C1B15FEBE6DF97F320C3B65DCA7", hash_generated_field = "EB574933C97E2AD1B4E541748A1F88E5")

    private static final String[] PATH_PROJECTION = new String[] {
            Files.FileColumns._ID, // 0
            Files.FileColumns.DATA, // 1
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.097 -0400", hash_original_field = "FF44B258F7465467DF32D4033E55E923", hash_generated_field = "3BE823F4A791623B8EA6020B1058FEAF")

    private static final String[] PATH_SIZE_FORMAT_PROJECTION = new String[] {
            Files.FileColumns._ID, // 0
            Files.FileColumns.DATA, // 1
            Files.FileColumns.SIZE, // 2
            Files.FileColumns.FORMAT, // 3
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.099 -0400", hash_original_field = "093F01FD36A9145800DC85190BF394BA", hash_generated_field = "D3F3F009295D38F6518DE6D53CFDC211")

    private static final String[] OBJECT_INFO_PROJECTION = new String[] {
            Files.FileColumns._ID, // 0
            Files.FileColumns.STORAGE_ID, // 1
            Files.FileColumns.FORMAT, // 2
            Files.FileColumns.PARENT, // 3
            Files.FileColumns.DATA, // 4
            Files.FileColumns.SIZE, // 5
            Files.FileColumns.DATE_MODIFIED, // 6
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.100 -0400", hash_original_field = "999539F445E598BE2FBA28CB51D94D01", hash_generated_field = "B29C95CF1E3DD1E3D028195B00D41907")

    private static final String ID_WHERE = Files.FileColumns._ID + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.102 -0400", hash_original_field = "8FE6E1D73CB84765E389AC777CA60479", hash_generated_field = "DC37B473CC2B0865A6DD7FFEC4D327D9")

    private static final String PATH_WHERE = Files.FileColumns.DATA + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.103 -0400", hash_original_field = "B4E340E3CC4D9B75805A65BAD336303D", hash_generated_field = "32F8A26AEED12D70AEE5881F2F54B823")


    private static final String STORAGE_WHERE = Files.FileColumns.STORAGE_ID + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.105 -0400", hash_original_field = "6458640FE15938C4F92C7895A016F12A", hash_generated_field = "E578AC379C3A65400DE34E9EF682B8DA")

    private static final String FORMAT_WHERE = Files.FileColumns.PARENT + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.107 -0400", hash_original_field = "F77239F7A961638102E5E7E47B257DE8", hash_generated_field = "281F6CDAAFE66960479F87ADED65CB2A")

    private static final String PARENT_WHERE = Files.FileColumns.FORMAT + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.108 -0400", hash_original_field = "5614C1B68DE48DD0629BE693F7136D57", hash_generated_field = "51547630400E0FAE52818438218617C8")

    private static final String STORAGE_FORMAT_WHERE = STORAGE_WHERE + " AND "
                                            + Files.FileColumns.FORMAT + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.110 -0400", hash_original_field = "9CDEFC50BEA41E9AFA3115259A819A4F", hash_generated_field = "A26582C8D7150AE8CB7B768BEE4228F5")

    private static final String STORAGE_PARENT_WHERE = STORAGE_WHERE + " AND "
                                            + Files.FileColumns.PARENT + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.112 -0400", hash_original_field = "EA2B383861E0CFE9F38BE479A70FDE46", hash_generated_field = "08034F796EF1A4BB1193793E20C47300")

    private static final String FORMAT_PARENT_WHERE = FORMAT_WHERE + " AND "
                                            + Files.FileColumns.PARENT + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.114 -0400", hash_original_field = "5800B04EF6590C3085C3E60D9D89C17D", hash_generated_field = "19DFB303BF80DD5F3C12551CFF84E4E5")

    private static final String STORAGE_FORMAT_PARENT_WHERE = STORAGE_FORMAT_WHERE + " AND "
                                            + Files.FileColumns.PARENT + "=?";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.145 -0400", hash_original_field = "D575F849664A5E7E41A6AE0C9BF49E1A", hash_generated_field = "1F3DBEA3903B404666D4455A4CD746AE")


    static final int[] FILE_PROPERTIES = {
            // NOTE must match beginning of AUDIO_PROPERTIES, VIDEO_PROPERTIES
            // and IMAGE_PROPERTIES below
            MtpConstants.PROPERTY_STORAGE_ID,
            MtpConstants.PROPERTY_OBJECT_FORMAT,
            MtpConstants.PROPERTY_PROTECTION_STATUS,
            MtpConstants.PROPERTY_OBJECT_SIZE,
            MtpConstants.PROPERTY_OBJECT_FILE_NAME,
            MtpConstants.PROPERTY_DATE_MODIFIED,
            MtpConstants.PROPERTY_PARENT_OBJECT,
            MtpConstants.PROPERTY_PERSISTENT_UID,
            MtpConstants.PROPERTY_NAME,
            MtpConstants.PROPERTY_DATE_ADDED,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.147 -0400", hash_original_field = "15C63D721AE84EFB57F3B25BED57EA39", hash_generated_field = "9F679EB393B98E30A57DAE5E91B06BEF")


    static final int[] AUDIO_PROPERTIES = {
            // NOTE must match FILE_PROPERTIES above
            MtpConstants.PROPERTY_STORAGE_ID,
            MtpConstants.PROPERTY_OBJECT_FORMAT,
            MtpConstants.PROPERTY_PROTECTION_STATUS,
            MtpConstants.PROPERTY_OBJECT_SIZE,
            MtpConstants.PROPERTY_OBJECT_FILE_NAME,
            MtpConstants.PROPERTY_DATE_MODIFIED,
            MtpConstants.PROPERTY_PARENT_OBJECT,
            MtpConstants.PROPERTY_PERSISTENT_UID,
            MtpConstants.PROPERTY_NAME,
            MtpConstants.PROPERTY_DISPLAY_NAME,
            MtpConstants.PROPERTY_DATE_ADDED,

            // audio specific properties
            MtpConstants.PROPERTY_ARTIST,
            MtpConstants.PROPERTY_ALBUM_NAME,
            MtpConstants.PROPERTY_ALBUM_ARTIST,
            MtpConstants.PROPERTY_TRACK,
            MtpConstants.PROPERTY_ORIGINAL_RELEASE_DATE,
            MtpConstants.PROPERTY_DURATION,
            MtpConstants.PROPERTY_GENRE,
            MtpConstants.PROPERTY_COMPOSER,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.149 -0400", hash_original_field = "F0464B68A1F4E670DB76B69EF1BA3576", hash_generated_field = "52D32E71E776C8800E0BFCBFFE71F538")


    static final int[] VIDEO_PROPERTIES = {
            // NOTE must match FILE_PROPERTIES above
            MtpConstants.PROPERTY_STORAGE_ID,
            MtpConstants.PROPERTY_OBJECT_FORMAT,
            MtpConstants.PROPERTY_PROTECTION_STATUS,
            MtpConstants.PROPERTY_OBJECT_SIZE,
            MtpConstants.PROPERTY_OBJECT_FILE_NAME,
            MtpConstants.PROPERTY_DATE_MODIFIED,
            MtpConstants.PROPERTY_PARENT_OBJECT,
            MtpConstants.PROPERTY_PERSISTENT_UID,
            MtpConstants.PROPERTY_NAME,
            MtpConstants.PROPERTY_DISPLAY_NAME,
            MtpConstants.PROPERTY_DATE_ADDED,

            // video specific properties
            MtpConstants.PROPERTY_ARTIST,
            MtpConstants.PROPERTY_ALBUM_NAME,
            MtpConstants.PROPERTY_DURATION,
            MtpConstants.PROPERTY_DESCRIPTION,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.151 -0400", hash_original_field = "BF030475C8D32285DF21B15FA873B600", hash_generated_field = "AA6920E26F3373263386E8C18E962E6F")


    static final int[] IMAGE_PROPERTIES = {
            // NOTE must match FILE_PROPERTIES above
            MtpConstants.PROPERTY_STORAGE_ID,
            MtpConstants.PROPERTY_OBJECT_FORMAT,
            MtpConstants.PROPERTY_PROTECTION_STATUS,
            MtpConstants.PROPERTY_OBJECT_SIZE,
            MtpConstants.PROPERTY_OBJECT_FILE_NAME,
            MtpConstants.PROPERTY_DATE_MODIFIED,
            MtpConstants.PROPERTY_PARENT_OBJECT,
            MtpConstants.PROPERTY_PERSISTENT_UID,
            MtpConstants.PROPERTY_NAME,
            MtpConstants.PROPERTY_DISPLAY_NAME,
            MtpConstants.PROPERTY_DATE_ADDED,

            // image specific properties
            MtpConstants.PROPERTY_DESCRIPTION,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.153 -0400", hash_original_field = "2B1FBA028D479F53F1C0C23C16CFEBCA", hash_generated_field = "DF1C987BF2073D2E408271EB2F460F05")


    static final int[] ALL_PROPERTIES = {
            // NOTE must match FILE_PROPERTIES above
            MtpConstants.PROPERTY_STORAGE_ID,
            MtpConstants.PROPERTY_OBJECT_FORMAT,
            MtpConstants.PROPERTY_PROTECTION_STATUS,
            MtpConstants.PROPERTY_OBJECT_SIZE,
            MtpConstants.PROPERTY_OBJECT_FILE_NAME,
            MtpConstants.PROPERTY_DATE_MODIFIED,
            MtpConstants.PROPERTY_PARENT_OBJECT,
            MtpConstants.PROPERTY_PERSISTENT_UID,
            MtpConstants.PROPERTY_NAME,
            MtpConstants.PROPERTY_DISPLAY_NAME,
            MtpConstants.PROPERTY_DATE_ADDED,

            // image specific properties
            MtpConstants.PROPERTY_DESCRIPTION,

            // audio specific properties
            MtpConstants.PROPERTY_ARTIST,
            MtpConstants.PROPERTY_ALBUM_NAME,
            MtpConstants.PROPERTY_ALBUM_ARTIST,
            MtpConstants.PROPERTY_TRACK,
            MtpConstants.PROPERTY_ORIGINAL_RELEASE_DATE,
            MtpConstants.PROPERTY_DURATION,
            MtpConstants.PROPERTY_GENRE,
            MtpConstants.PROPERTY_COMPOSER,

            // video specific properties
            MtpConstants.PROPERTY_ARTIST,
            MtpConstants.PROPERTY_ALBUM_NAME,
            MtpConstants.PROPERTY_DURATION,
            MtpConstants.PROPERTY_DESCRIPTION,

            // image specific properties
            MtpConstants.PROPERTY_DESCRIPTION,
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.069 -0400", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")


    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.071 -0400", hash_original_field = "F9DB4B38F600632EE10B3816F27F7461", hash_generated_field = "C4EC300190CE5D52202461D7E0557B4F")

    private  IContentProvider mMediaProvider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.072 -0400", hash_original_field = "F488B59709DB2C8A92AEFD40ED5E30F9", hash_generated_field = "9D1FFAB509CBA702BE86D582470A09F0")

    private  String mVolumeName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.074 -0400", hash_original_field = "211606F0DCE2E1FB24A7A85EA07CE9A4", hash_generated_field = "1B91AF0E22717B23E23DDF3C33BB426C")

    private  Uri mObjectsUri;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.075 -0400", hash_original_field = "567DABE935735DDF09FBE96AD5561752", hash_generated_field = "FEFFC91D18850A716EAE43FD4F35AE8B")

    private  String mMediaStoragePath;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.077 -0400", hash_original_field = "CCE4CD496DFB7E9C2F0295757D08B850", hash_generated_field = "FF6AB4C6BFE46C82FEA9A59895C93B4B")

    private  String[] mSubDirectories;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.079 -0400", hash_original_field = "6593CB97FF10C7E4BB53E5FB05D17674", hash_generated_field = "BF37F6998C67CC04B3D7B94685E40C6C")

    private String mSubDirectoriesWhere;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.080 -0400", hash_original_field = "D4368AD56436D4F728DC145CFF699059", hash_generated_field = "9CE07856DF97077B154008350C3FF71A")

    private String[] mSubDirectoriesWhereArgs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.082 -0400", hash_original_field = "6283206A78C154542BF89CB5BF05AAA5", hash_generated_field = "9471A85D354B48FE30FA0C94A06C1BDB")


    private final HashMap<String, MtpStorage> mStorageMap = new HashMap<String, MtpStorage>();

    static {
        System.loadLibrary("media_jni");
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.084 -0400", hash_original_field = "D76A6C016844024729CF2D7331DDC5D4", hash_generated_field = "AF7FDFA8C0A3BA571077220F049675F0")

    private final HashMap<Integer, MtpPropertyGroup> mPropertyGroupsByProperty
            = new HashMap<Integer, MtpPropertyGroup>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.085 -0400", hash_original_field = "4003FF24426D8B6D5B3F2FF6B4033240", hash_generated_field = "DE592FABA6CCAD4934ED67C49AFEB4AE")

    private final HashMap<Integer, MtpPropertyGroup> mPropertyGroupsByFormat
            = new HashMap<Integer, MtpPropertyGroup>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.087 -0400", hash_original_field = "686197D4D3AD14FB997C2F3EB009EDD5", hash_generated_field = "66450CBABABDDEC0574AAAF700ED5C8F")

    private boolean mDatabaseModified;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.088 -0400", hash_original_field = "8AE1403902C6B3372639953612978C70", hash_generated_field = "4172CB678D00AE9AE5C3A8CD67BBE65F")

    private SharedPreferences mDeviceProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.116 -0400", hash_original_field = "7560A790B29D9A15498F6F9824684DB8", hash_generated_field = "B574A36DE7F22C83270D004F5D7672B1")


    private  MediaScanner mMediaScanner;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.182 -0400", hash_original_field = "A4A4998D7B0D1DA56BE7F415CF4F3BBD", hash_generated_field = "0A3F8EE607897645EB2EE30B6939205B")

    private int mNativeContext;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.119 -0400", hash_original_method = "AC424751E1B86D54F0001662CA5936FC", hash_generated_method = "1BB4B99E13C5FAC5BB3B0705710B2AB6")
    
public MtpDatabase(Context context, String volumeName, String storagePath,
            String[] subDirectories) {
        native_setup();

        mContext = context;
        mMediaProvider = context.getContentResolver().acquireProvider("media");
        mVolumeName = volumeName;
        mMediaStoragePath = storagePath;
        mObjectsUri = Files.getMtpObjectsUri(volumeName);
        mMediaScanner = new MediaScanner(context);

        mSubDirectories = subDirectories;
        if (subDirectories != null) {
            // Compute "where" string for restricting queries to subdirectories
            StringBuilder builder = new StringBuilder();
            builder.append("(");
            int count = subDirectories.length;
            for (int i = 0; i < count; i++) {
                builder.append(Files.FileColumns.DATA + "=? OR "
                        + Files.FileColumns.DATA + " LIKE ?");
                if (i != count - 1) {
                    builder.append(" OR ");
                }
            }
            builder.append(")");
            mSubDirectoriesWhere = builder.toString();

            // Compute "where" arguments for restricting queries to subdirectories
            mSubDirectoriesWhereArgs = new String[count * 2];
            for (int i = 0, j = 0; i < count; i++) {
                String path = subDirectories[i];
                mSubDirectoriesWhereArgs[j++] = path;
                mSubDirectoriesWhereArgs[j++] = path + "/%";
            }
        }

        // Set locale to MediaScanner.
        Locale locale = context.getResources().getConfiguration().locale;
        if (locale != null) {
            String language = locale.getLanguage();
            String country = locale.getCountry();
            if (language != null) {
                if (country != null) {
                    mMediaScanner.setLocale(language + "_" + country);
                } else {
                    mMediaScanner.setLocale(language);
                }
            }
        }
        initDeviceProperties(context);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.120 -0400", hash_original_method = "24D5F4C50C2ABC5729410C2F2E889F36", hash_generated_method = "932E17C175F633B7C6ED1D87A1181F69")
    
@Override
    protected void finalize() throws Throwable {
        try {
            native_finalize();
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.122 -0400", hash_original_method = "C41704C2E754FFF47E4DCB237399472C", hash_generated_method = "867E35E0743057A4D6043D063FBB7185")
    
public void addStorage(MtpStorage storage) {
        mStorageMap.put(storage.getPath(), storage);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.123 -0400", hash_original_method = "9F9AEAC976D45A631538E53B2432819A", hash_generated_method = "FB6C06D9596D68D74E920AC479834ADA")
    
public void removeStorage(MtpStorage storage) {
        mStorageMap.remove(storage.getPath());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.125 -0400", hash_original_method = "43010F4438A1026A4A3B7A1EF9AA17EE", hash_generated_method = "1F374198029D7E334326D414E2E01031")
    
private void initDeviceProperties(Context context) {
        final String devicePropertiesName = "device-properties";
        mDeviceProperties = context.getSharedPreferences(devicePropertiesName, Context.MODE_PRIVATE);
        File databaseFile = context.getDatabasePath(devicePropertiesName);

        if (databaseFile.exists()) {
            // for backward compatibility - read device properties from sqlite database
            // and migrate them to shared prefs
            SQLiteDatabase db = null;
            Cursor c = null;
            try {
                db = context.openOrCreateDatabase("device-properties", Context.MODE_PRIVATE, null);
                if (db != null) {
                    c = db.query("properties", new String[] { "_id", "code", "value" },
                            null, null, null, null, null);
                    if (c != null) {
                        SharedPreferences.Editor e = mDeviceProperties.edit();
                        while (c.moveToNext()) {
                            String name = c.getString(1);
                            String value = c.getString(2);
                            e.putString(name, value);
                        }
                        e.commit();
                    }
                }
            } catch (Exception e) {
                Log.e(TAG, "failed to migrate device properties", e);
            } finally {
                if (c != null) c.close();
                if (db != null) db.close();
            }
            databaseFile.delete();
        }
    }

    // check to see if the path is contained in one of our storage subdirectories
    // returns true if we have no special subdirectories
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.127 -0400", hash_original_method = "70EF1EE948AC881244C630F3BC0B6357", hash_generated_method = "01C3333175E4B53B9C0357ED2D98CAAC")
    
private boolean inStorageSubDirectory(String path) {
        if (mSubDirectories == null) return true;
        if (path == null) return false;

        boolean allowed = false;
        int pathLength = path.length();
        for (int i = 0; i < mSubDirectories.length && !allowed; i++) {
            String subdir = mSubDirectories[i];
            int subdirLength = subdir.length();
            if (subdirLength < pathLength &&
                    path.charAt(subdirLength) == '/' &&
                    path.startsWith(subdir)) {
                allowed = true;
            }
        }
        return allowed;
    }

    // check to see if the path matches one of our storage subdirectories
    // returns true if we have no special subdirectories
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.128 -0400", hash_original_method = "FF3BB121FA814EED74F877E625533512", hash_generated_method = "A55E0FBF8DF3D7761DB21DBCF296E0CA")
    
private boolean isStorageSubDirectory(String path) {
    if (mSubDirectories == null) return false;
        for (int i = 0; i < mSubDirectories.length; i++) {
            if (path.equals(mSubDirectories[i])) {
                return true;
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.132 -0400", hash_original_method = "D9D90EC77A846AB091D3E208EB0F0EE3", hash_generated_method = "7FC338F50779879B1B77B28789B78377")
    
private int beginSendObject(String path, int format, int parent,
                         int storageId, long size, long modified) {
        // if mSubDirectories is not null, do not allow copying files to any other locations
        if (!inStorageSubDirectory(path)) return -1;

        // make sure the object does not exist
        if (path != null) {
            Cursor c = null;
            try {
                c = mMediaProvider.query(mObjectsUri, ID_PROJECTION, PATH_WHERE,
                        new String[] { path }, null);
                if (c != null && c.getCount() > 0) {
                    Log.w(TAG, "file already exists in beginSendObject: " + path);
                    return -1;
                }
            } catch (RemoteException e) {
                Log.e(TAG, "RemoteException in beginSendObject", e);
            } finally {
                if (c != null) {
                    c.close();
                }
            }
        }

        mDatabaseModified = true;
        ContentValues values = new ContentValues();
        values.put(Files.FileColumns.DATA, path);
        values.put(Files.FileColumns.FORMAT, format);
        values.put(Files.FileColumns.PARENT, parent);
        values.put(Files.FileColumns.STORAGE_ID, storageId);
        values.put(Files.FileColumns.SIZE, size);
        values.put(Files.FileColumns.DATE_MODIFIED, modified);

        try {
            Uri uri = mMediaProvider.insert(mObjectsUri, values);
            if (uri != null) {
                return Integer.parseInt(uri.getPathSegments().get(2));
            } else {
                return -1;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in beginSendObject", e);
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.134 -0400", hash_original_method = "FC22F4561D43E337C8CE69BAF28451A2", hash_generated_method = "EED100E050FE83DBE2352F2DF6939027")
    
private void endSendObject(String path, int handle, int format, boolean succeeded) {
        if (succeeded) {
            // handle abstract playlists separately
            // they do not exist in the file system so don't use the media scanner here
            if (format == MtpConstants.FORMAT_ABSTRACT_AV_PLAYLIST) {
                // extract name from path
                String name = path;
                int lastSlash = name.lastIndexOf('/');
                if (lastSlash >= 0) {
                    name = name.substring(lastSlash + 1);
                }
                // strip trailing ".pla" from the name
                if (name.endsWith(".pla")) {
                    name = name.substring(0, name.length() - 4);
                }

                ContentValues values = new ContentValues(1);
                values.put(Audio.Playlists.DATA, path);
                values.put(Audio.Playlists.NAME, name);
                values.put(Files.FileColumns.FORMAT, format);
                values.put(Files.FileColumns.DATE_MODIFIED, System.currentTimeMillis() / 1000);
                values.put(MediaColumns.MEDIA_SCANNER_NEW_OBJECT_ID, handle);
                try {
                    Uri uri = mMediaProvider.insert(Audio.Playlists.EXTERNAL_CONTENT_URI, values);
                } catch (RemoteException e) {
                    Log.e(TAG, "RemoteException in endSendObject", e);
                }
            } else {
                mMediaScanner.scanMtpFile(path, mVolumeName, handle, format);
            }
        } else {
            deleteFile(handle);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.137 -0400", hash_original_method = "E6E1F80ED9C94397FE8BB56CC3911838", hash_generated_method = "15CB18ED008834FD7A52CF536B8EDAC8")
    
private Cursor createObjectQuery(int storageID, int format, int parent) throws RemoteException {
        String where;
        String[] whereArgs;

        if (storageID == 0xFFFFFFFF) {
            // query all stores
            if (format == 0) {
                // query all formats
                if (parent == 0) {
                    // query all objects
                    where = null;
                    whereArgs = null;
                } else {
                    if (parent == 0xFFFFFFFF) {
                        // all objects in root of store
                        parent = 0;
                    }
                    where = PARENT_WHERE;
                    whereArgs = new String[] { Integer.toString(parent) };
                }
            } else {
                // query specific format
                if (parent == 0) {
                    // query all objects
                    where = FORMAT_WHERE;
                    whereArgs = new String[] { Integer.toString(format) };
                } else {
                    if (parent == 0xFFFFFFFF) {
                        // all objects in root of store
                        parent = 0;
                    }
                    where = FORMAT_PARENT_WHERE;
                    whereArgs = new String[] { Integer.toString(format),
                                               Integer.toString(parent) };
                }
            }
        } else {
            // query specific store
            if (format == 0) {
                // query all formats
                if (parent == 0) {
                    // query all objects
                    where = STORAGE_WHERE;
                    whereArgs = new String[] { Integer.toString(storageID) };
                } else {
                    if (parent == 0xFFFFFFFF) {
                        // all objects in root of store
                        parent = 0;
                    }
                    where = STORAGE_PARENT_WHERE;
                    whereArgs = new String[] { Integer.toString(storageID),
                                               Integer.toString(parent) };
                }
            } else {
                // query specific format
                if (parent == 0) {
                    // query all objects
                    where = STORAGE_FORMAT_WHERE;
                    whereArgs = new String[] {  Integer.toString(storageID),
                                                Integer.toString(format) };
                } else {
                    if (parent == 0xFFFFFFFF) {
                        // all objects in root of store
                        parent = 0;
                    }
                    where = STORAGE_FORMAT_PARENT_WHERE;
                    whereArgs = new String[] { Integer.toString(storageID),
                                               Integer.toString(format),
                                               Integer.toString(parent) };
                }
            }
        }

        // if we are restricting queries to mSubDirectories, we need to add the restriction
        // onto our "where" arguments
        if (mSubDirectoriesWhere != null) {
            if (where == null) {
                where = mSubDirectoriesWhere;
                whereArgs = mSubDirectoriesWhereArgs;
            } else {
                where = where + " AND " + mSubDirectoriesWhere;

                // create new array to hold whereArgs and mSubDirectoriesWhereArgs
                String[] newWhereArgs =
                        new String[whereArgs.length + mSubDirectoriesWhereArgs.length];
                int i, j;
                for (i = 0; i < whereArgs.length; i++) {
                    newWhereArgs[i] = whereArgs[i];
                }
                for (j = 0; j < mSubDirectoriesWhereArgs.length; i++, j++) {
                    newWhereArgs[i] = mSubDirectoriesWhereArgs[j];
                }
                whereArgs = newWhereArgs;
            }
        }

        return mMediaProvider.query(mObjectsUri, ID_PROJECTION, where, whereArgs, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.139 -0400", hash_original_method = "1AB1A60471887C7952C91FC79DC73600", hash_generated_method = "FC97E249D290DE75EF2A6DA738E49154")
    
private int[] getObjectList(int storageID, int format, int parent) {
        Cursor c = null;
        try {
            c = createObjectQuery(storageID, format, parent);
            if (c == null) {
                return null;
            }
            int count = c.getCount();
            if (count > 0) {
                int[] result = new int[count];
                for (int i = 0; i < count; i++) {
                    c.moveToNext();
                    result[i] = c.getInt(0);
                }
                return result;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getObjectList", e);
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.141 -0400", hash_original_method = "815D1FBD6F73DDDB5EA30A9CD9E1911E", hash_generated_method = "81F7F59862B6B7E7184D25B5B133D716")
    
private int getNumObjects(int storageID, int format, int parent) {
        Cursor c = null;
        try {
            c = createObjectQuery(storageID, format, parent);
            if (c != null) {
                return c.getCount();
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getNumObjects", e);
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.142 -0400", hash_original_method = "A7842810F8B2791B9F591CFE19686084", hash_generated_method = "D6116FADBDA028C3965F50A985FAE527")
    
private int[] getSupportedPlaybackFormats() {
        return new int[] {
            // allow transfering arbitrary files
            MtpConstants.FORMAT_UNDEFINED,

            MtpConstants.FORMAT_ASSOCIATION,
            MtpConstants.FORMAT_TEXT,
            MtpConstants.FORMAT_HTML,
            MtpConstants.FORMAT_WAV,
            MtpConstants.FORMAT_MP3,
            MtpConstants.FORMAT_MPEG,
            MtpConstants.FORMAT_EXIF_JPEG,
            MtpConstants.FORMAT_TIFF_EP,
            MtpConstants.FORMAT_GIF,
            MtpConstants.FORMAT_JFIF,
            MtpConstants.FORMAT_PNG,
            MtpConstants.FORMAT_TIFF,
            MtpConstants.FORMAT_WMA,
            MtpConstants.FORMAT_OGG,
            MtpConstants.FORMAT_AAC,
            MtpConstants.FORMAT_MP4_CONTAINER,
            MtpConstants.FORMAT_MP2,
            MtpConstants.FORMAT_3GP_CONTAINER,
            MtpConstants.FORMAT_ABSTRACT_AV_PLAYLIST,
            MtpConstants.FORMAT_WPL_PLAYLIST,
            MtpConstants.FORMAT_M3U_PLAYLIST,
            MtpConstants.FORMAT_PLS_PLAYLIST,
            MtpConstants.FORMAT_XML_DOCUMENT,
            MtpConstants.FORMAT_FLAC,
        };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.144 -0400", hash_original_method = "CCA2ADAB06248252FD572F5410529335", hash_generated_method = "952790FD41BD72AD21D4D86F5EEC28C4")
    
private int[] getSupportedCaptureFormats() {
        // no capture formats yet
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.156 -0400", hash_original_method = "735F58FB784499B130132E1D1D0A6EF6", hash_generated_method = "C693AD4BF2D40A3DEFDB5DD82D35B34B")
    
private int[] getSupportedObjectProperties(int format) {
        switch (format) {
            case MtpConstants.FORMAT_MP3:
            case MtpConstants.FORMAT_WAV:
            case MtpConstants.FORMAT_WMA:
            case MtpConstants.FORMAT_OGG:
            case MtpConstants.FORMAT_AAC:
                return AUDIO_PROPERTIES;
            case MtpConstants.FORMAT_MPEG:
            case MtpConstants.FORMAT_3GP_CONTAINER:
            case MtpConstants.FORMAT_WMV:
                return VIDEO_PROPERTIES;
            case MtpConstants.FORMAT_EXIF_JPEG:
            case MtpConstants.FORMAT_GIF:
            case MtpConstants.FORMAT_PNG:
            case MtpConstants.FORMAT_BMP:
                return IMAGE_PROPERTIES;
            case 0:
                return ALL_PROPERTIES;
            default:
                return FILE_PROPERTIES;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.157 -0400", hash_original_method = "4ADB7D20411DEBA6B53744FD57A1B9BC", hash_generated_method = "55A5D1181ACA7C8D18F7379FF2814F8D")
    
private int[] getSupportedDeviceProperties() {
        return new int[] {
            MtpConstants.DEVICE_PROPERTY_SYNCHRONIZATION_PARTNER,
            MtpConstants.DEVICE_PROPERTY_DEVICE_FRIENDLY_NAME,
            MtpConstants.DEVICE_PROPERTY_IMAGE_SIZE,
        };
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.159 -0400", hash_original_method = "60BE146E8EF847DC4DEAA0DD295CF6EF", hash_generated_method = "25B499659F76E29A73C869191BB5ACE4")
    
private MtpPropertyList getObjectPropertyList(long handle, int format, long property,
                        int groupCode, int depth) {
        // FIXME - implement group support
        if (groupCode != 0) {
            return new MtpPropertyList(0, MtpConstants.RESPONSE_SPECIFICATION_BY_GROUP_UNSUPPORTED);
        }

        MtpPropertyGroup propertyGroup;
        if (property == 0xFFFFFFFFL) {
             propertyGroup = mPropertyGroupsByFormat.get(format);
             if (propertyGroup == null) {
                int[] propertyList = getSupportedObjectProperties(format);
                propertyGroup = new MtpPropertyGroup(this, mMediaProvider, mVolumeName, propertyList);
                mPropertyGroupsByFormat.put(new Integer(format), propertyGroup);
            }
        } else {
              propertyGroup = mPropertyGroupsByProperty.get(property);
             if (propertyGroup == null) {
                int[] propertyList = new int[] { (int)property };
                propertyGroup = new MtpPropertyGroup(this, mMediaProvider, mVolumeName, propertyList);
                mPropertyGroupsByProperty.put(new Integer((int)property), propertyGroup);
            }
        }

        return propertyGroup.getPropertyList((int)handle, format, depth);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.162 -0400", hash_original_method = "302772813882807A262B74D926331003", hash_generated_method = "C49A4F21568F77EF6BA14E5EBB002A1F")
    
private int renameFile(int handle, String newName) {
        Cursor c = null;

        // first compute current path
        String path = null;
        String[] whereArgs = new String[] {  Integer.toString(handle) };
        try {
            c = mMediaProvider.query(mObjectsUri, PATH_PROJECTION, ID_WHERE, whereArgs, null);
            if (c != null && c.moveToNext()) {
                path = c.getString(1);
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getObjectFilePath", e);
            return MtpConstants.RESPONSE_GENERAL_ERROR;
        } finally {
            if (c != null) {
                c.close();
            }
        }
        if (path == null) {
            return MtpConstants.RESPONSE_INVALID_OBJECT_HANDLE;
        }

        // do not allow renaming any of the special subdirectories
        if (isStorageSubDirectory(path)) {
            return MtpConstants.RESPONSE_OBJECT_WRITE_PROTECTED;
        }

        // now rename the file.  make sure this succeeds before updating database
        File oldFile = new File(path);
        int lastSlash = path.lastIndexOf('/');
        if (lastSlash <= 1) {
            return MtpConstants.RESPONSE_GENERAL_ERROR;
        }
        String newPath = path.substring(0, lastSlash + 1) + newName;
        File newFile = new File(newPath);
        boolean success = oldFile.renameTo(newFile);
        if (!success) {
            Log.w(TAG, "renaming "+ path + " to " + newPath + " failed");
            return MtpConstants.RESPONSE_GENERAL_ERROR;
        }

        // finally update database
        ContentValues values = new ContentValues();
        values.put(Files.FileColumns.DATA, newPath);
        int updated = 0;
        try {
            // note - we are relying on a special case in MediaProvider.update() to update
            // the paths for all children in the case where this is a directory.
            updated = mMediaProvider.update(mObjectsUri, values, ID_WHERE, whereArgs);
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in mMediaProvider.update", e);
        }
        if (updated == 0) {
            Log.e(TAG, "Unable to update path for " + path + " to " + newPath);
            // this shouldn't happen, but if it does we need to rename the file to its original name
            newFile.renameTo(oldFile);
            return MtpConstants.RESPONSE_GENERAL_ERROR;
        }

        return MtpConstants.RESPONSE_OK;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.164 -0400", hash_original_method = "1D3D281F4C352D519906CDFCA72344F0", hash_generated_method = "29D7CB6AFE17D4879711146EB7F2A4C6")
    
private int setObjectProperty(int handle, int property,
                            long intValue, String stringValue) {
        switch (property) {
            case MtpConstants.PROPERTY_OBJECT_FILE_NAME:
                return renameFile(handle, stringValue);

            default:
                return MtpConstants.RESPONSE_OBJECT_PROP_NOT_SUPPORTED;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.166 -0400", hash_original_method = "3B1A5C8BA8CFB85527DF2D36443AA5D1", hash_generated_method = "16A69F75F029657EC87291AC0EF982A6")
    
private int getDeviceProperty(int property, long[] outIntValue, char[] outStringValue) {
        switch (property) {
            case MtpConstants.DEVICE_PROPERTY_SYNCHRONIZATION_PARTNER:
            case MtpConstants.DEVICE_PROPERTY_DEVICE_FRIENDLY_NAME:
                // writable string properties kept in shared preferences
                String value = mDeviceProperties.getString(Integer.toString(property), "");
                int length = value.length();
                if (length > 255) {
                    length = 255;
                }
                value.getChars(0, length, outStringValue, 0);
                outStringValue[length] = 0;
                return MtpConstants.RESPONSE_OK;

            case MtpConstants.DEVICE_PROPERTY_IMAGE_SIZE:
                // use screen size as max image size
                Display display = ((WindowManager)mContext.getSystemService(
                        Context.WINDOW_SERVICE)).getDefaultDisplay();
                int width = display.getMaximumSizeDimension();
                int height = display.getMaximumSizeDimension();
                String imageSize = Integer.toString(width) + "x" +  Integer.toString(height);
                imageSize.getChars(0, imageSize.length(), outStringValue, 0);
                outStringValue[imageSize.length()] = 0;
                return MtpConstants.RESPONSE_OK;

            default:
                return MtpConstants.RESPONSE_DEVICE_PROP_NOT_SUPPORTED;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.167 -0400", hash_original_method = "CC718C1B7D82DDDD77A8226D9CF15B26", hash_generated_method = "EA236C53B71FC0A13F40F4550FC8A1EE")
    
private int setDeviceProperty(int property, long intValue, String stringValue) {
        switch (property) {
            case MtpConstants.DEVICE_PROPERTY_SYNCHRONIZATION_PARTNER:
            case MtpConstants.DEVICE_PROPERTY_DEVICE_FRIENDLY_NAME:
                // writable string properties kept in shared prefs
                SharedPreferences.Editor e = mDeviceProperties.edit();
                e.putString(Integer.toString(property), stringValue);
                return (e.commit() ? MtpConstants.RESPONSE_OK
                        : MtpConstants.RESPONSE_GENERAL_ERROR);
        }

        return MtpConstants.RESPONSE_DEVICE_PROP_NOT_SUPPORTED;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.169 -0400", hash_original_method = "93EF9CF423A33C91F35E667983C9E71F", hash_generated_method = "C535B5869D3A4007B632C1D928283617")
    
private boolean getObjectInfo(int handle, int[] outStorageFormatParent,
                        char[] outName, long[] outSizeModified) {
        Cursor c = null;
        try {
            c = mMediaProvider.query(mObjectsUri, OBJECT_INFO_PROJECTION,
                            ID_WHERE, new String[] {  Integer.toString(handle) }, null);
            if (c != null && c.moveToNext()) {
                outStorageFormatParent[0] = c.getInt(1);
                outStorageFormatParent[1] = c.getInt(2);
                outStorageFormatParent[2] = c.getInt(3);

                // extract name from path
                String path = c.getString(4);
                int lastSlash = path.lastIndexOf('/');
                int start = (lastSlash >= 0 ? lastSlash + 1 : 0);
                int end = path.length();
                if (end - start > 255) {
                    end = start + 255;
                }
                path.getChars(start, end, outName, 0);
                outName[end - start] = 0;

                outSizeModified[0] = c.getLong(5);
                outSizeModified[1] = c.getLong(6);
                return true;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getObjectInfo", e);
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.171 -0400", hash_original_method = "07BE272D758EBFD34918917EF69CD8C3", hash_generated_method = "C0C4B80D6BFF29C6C10BE0422C9BD4F9")
    
private int getObjectFilePath(int handle, char[] outFilePath, long[] outFileLengthFormat) {
        if (handle == 0) {
            // special case root directory
            mMediaStoragePath.getChars(0, mMediaStoragePath.length(), outFilePath, 0);
            outFilePath[mMediaStoragePath.length()] = 0;
            outFileLengthFormat[0] = 0;
            outFileLengthFormat[1] = MtpConstants.FORMAT_ASSOCIATION;
            return MtpConstants.RESPONSE_OK;
        }
        Cursor c = null;
        try {
            c = mMediaProvider.query(mObjectsUri, PATH_SIZE_FORMAT_PROJECTION,
                            ID_WHERE, new String[] {  Integer.toString(handle) }, null);
            if (c != null && c.moveToNext()) {
                String path = c.getString(1);
                path.getChars(0, path.length(), outFilePath, 0);
                outFilePath[path.length()] = 0;
                outFileLengthFormat[0] = c.getLong(2);
                outFileLengthFormat[1] = c.getLong(3);
                return MtpConstants.RESPONSE_OK;
            } else {
                return MtpConstants.RESPONSE_INVALID_OBJECT_HANDLE;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getObjectFilePath", e);
            return MtpConstants.RESPONSE_GENERAL_ERROR;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.174 -0400", hash_original_method = "707DC9CE6B404863A18E31099030E2F6", hash_generated_method = "DF9844693B191C9ACC4A1F6D30071DF2")
    
private int deleteFile(int handle) {
        mDatabaseModified = true;
        String path = null;
        int format = 0;

        Cursor c = null;
        try {
            c = mMediaProvider.query(mObjectsUri, PATH_SIZE_FORMAT_PROJECTION,
                            ID_WHERE, new String[] {  Integer.toString(handle) }, null);
            if (c != null && c.moveToNext()) {
                // don't convert to media path here, since we will be matching
                // against paths in the database matching /data/media
                path = c.getString(1);
                format = c.getInt(3);
            } else {
                return MtpConstants.RESPONSE_INVALID_OBJECT_HANDLE;
            }

            if (path == null || format == 0) {
                return MtpConstants.RESPONSE_GENERAL_ERROR;
            }

            // do not allow deleting any of the special subdirectories
            if (isStorageSubDirectory(path)) {
                return MtpConstants.RESPONSE_OBJECT_WRITE_PROTECTED;
            }

            if (format == MtpConstants.FORMAT_ASSOCIATION) {
                // recursive case - delete all children first
                Uri uri = Files.getMtpObjectsUri(mVolumeName);
                int count = mMediaProvider.delete(uri, "_data LIKE ?",
                        new String[] { path + "/%"});
            }

            Uri uri = Files.getMtpObjectsUri(mVolumeName, handle);
            if (mMediaProvider.delete(uri, null, null) > 0) {
                return MtpConstants.RESPONSE_OK;
            } else {
                return MtpConstants.RESPONSE_INVALID_OBJECT_HANDLE;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in deleteFile", e);
            return MtpConstants.RESPONSE_GENERAL_ERROR;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.176 -0400", hash_original_method = "A0335EECF02545C287472F3B8086F21F", hash_generated_method = "8C5BDCFFE9E5B51DDF47BA3253CB727A")
    
private int[] getObjectReferences(int handle) {
        Uri uri = Files.getMtpReferencesUri(mVolumeName, handle);
        Cursor c = null;
        try {
            c = mMediaProvider.query(uri, ID_PROJECTION, null, null, null);
            if (c == null) {
                return null;
            }
            int count = c.getCount();
            if (count > 0) {
                int[] result = new int[count];
                for (int i = 0; i < count; i++) {
                    c.moveToNext();
                    result[i] = c.getInt(0);
                }
                return result;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getObjectList", e);
        } finally {
            if (c != null) {
                c.close();
            }
        }
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.178 -0400", hash_original_method = "9FB9CDA353A935851E52E35BC2BB3D21", hash_generated_method = "47DA8606A22D70DDB1B0A4E826ADAFD1")
    
private int setObjectReferences(int handle, int[] references) {
        mDatabaseModified = true;
        Uri uri = Files.getMtpReferencesUri(mVolumeName, handle);
        int count = references.length;
        ContentValues[] valuesList = new ContentValues[count];
        for (int i = 0; i < count; i++) {
            ContentValues values = new ContentValues();
            values.put(Files.FileColumns._ID, references[i]);
            valuesList[i] = values;
        }
        try {
            if (mMediaProvider.bulkInsert(uri, valuesList) > 0) {
                return MtpConstants.RESPONSE_OK;
            }
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in setObjectReferences", e);
        }
        return MtpConstants.RESPONSE_GENERAL_ERROR;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.179 -0400", hash_original_method = "41F87800C3B64D5C945FF47EDE64B00F", hash_generated_method = "7849D031FFB6800E5CF0C30C64BDA706")
    
private void sessionStarted() {
        mDatabaseModified = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-24 16:07:20.180 -0400", hash_original_method = "35748FCC6BF909F4C56A31AF443755AE", hash_generated_method = "5FDCC2AEF8431C7A9F619BFAE40810D6")
    
private void sessionEnded() {
        if (mDatabaseModified) {
            mContext.sendBroadcast(new Intent(MediaStore.ACTION_MTP_SESSION_END));
            mDatabaseModified = false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:04.474 -0400", hash_original_method = "B91E9A85D17B4C3984DC1E936380BF22", hash_generated_method = "40C1EAE506328FBBECFF0048FCF2E8D2")
    
    private final void native_setup(){
    	//Formerly a native method
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-03-25 14:22:04.477 -0400", hash_original_method = "B81676966F6941B90240D7A24C9E2FD3", hash_generated_method = "F4F0ABEE314221212592CD2BBD7D2805")
    
    private final void native_finalize(){
    	//Formerly a native method
    }



}
