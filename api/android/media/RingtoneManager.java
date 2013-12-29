package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SdkConstant;
import android.annotation.SdkConstant.SdkConstantType;
import android.app.Activity;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DrmStore;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;

import com.android.internal.database.SortCursor;






public class RingtoneManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.084 -0500", hash_original_method = "DBC47BF2F28DE087272A0362AE49A9BD", hash_generated_method = "39659D7CC381EF0219D84A11D816E499")
    private static Uri getUriFromCursor(Cursor cursor) {
        return ContentUris.withAppendedId(Uri.parse(cursor.getString(URI_COLUMN_INDEX)), cursor
                .getLong(ID_COLUMN_INDEX));
    }

    /**
     * Returns a valid ringtone URI. No guarantees on which it returns. If it
     * cannot find one, returns null.
     * 
     * @param context The context to use for querying.
     * @return A ringtone URI, or null if one cannot be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.086 -0500", hash_original_method = "1192D831CE26227FD11FFFE1931A718B", hash_generated_method = "466760483F9E9AACC037C910489C8077")
    public static Uri getValidRingtoneUri(Context context) {
        final RingtoneManager rm = new RingtoneManager(context);
        
        Uri uri = getValidRingtoneUriFromCursorAndClose(context, rm.getInternalRingtones());

        if (uri == null) {
            uri = getValidRingtoneUriFromCursorAndClose(context, rm.getMediaRingtones());
        }
        
        if (uri == null) {
            uri = getValidRingtoneUriFromCursorAndClose(context, rm.getDrmRingtones());
        }
        
        return uri;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.087 -0500", hash_original_method = "6D36BC3A825A2854EC540CE79E0ECBCE", hash_generated_method = "EF8061E2A5A3CB2651093307549053D0")
    private static Uri getValidRingtoneUriFromCursorAndClose(Context context, Cursor cursor) {
        if (cursor != null) {
            Uri uri = null;
            
            if (cursor.moveToFirst()) {
                uri = getUriFromCursor(cursor);
            }
            cursor.close();
            
            return uri;
        } else {
            return null;
        }
    }
    
    /**
     * Constructs a where clause that consists of at least one column being 1
     * (true). This is used to find all matching sounds for the given sound
     * types (ringtone, notifications, etc.)
     * 
     * @param columns The columns that must be true.
     * @return The where clause.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.092 -0500", hash_original_method = "ABDE2603E3E0183A07EE30B4903BA6A9", hash_generated_method = "555DC2254EB46FA798B435DDC602A06D")
    private static String constructBooleanTrueWhereClause(List<String> columns, boolean includeDrm) {
        
        if (columns == null) return null;
        
        StringBuilder sb = new StringBuilder();
        sb.append("(");

        for (int i = columns.size() - 1; i >= 0; i--) {
            sb.append(columns.get(i)).append("=1 or ");
        }
        
        if (columns.size() > 0) {
            // Remove last ' or '
            sb.setLength(sb.length() - 4);
        }

        sb.append(")");

        if (!includeDrm) {
            // If not DRM files should be shown, the where clause
            // will be something like "(is_notification=1) and is_drm=0"
            sb.append(" and ");
            sb.append(MediaStore.MediaColumns.IS_DRM);
            sb.append("=0");
        }


        return sb.toString();
    }
    
    /**
     * Returns a {@link Ringtone} for a given sound URI.
     * <p>
     * If the given URI cannot be opened for any reason, this method will
     * attempt to fallback on another sound. If it cannot find any, it will
     * return null.
     * 
     * @param context A context used to query.
     * @param ringtoneUri The {@link Uri} of a sound or ringtone.
     * @return A {@link Ringtone} for the given URI, or null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.093 -0500", hash_original_method = "2EEAD7205454E4D34A279A8E10F02588", hash_generated_method = "6E666E4ADBE4A3013EBE6CF85AE2637A")
    public static Ringtone getRingtone(final Context context, Uri ringtoneUri) {
        // Don't set the stream type
        return getRingtone(context, ringtoneUri, -1);
    }

    /**
     * Returns a {@link Ringtone} for a given sound URI on the given stream
     * type. Normally, if you change the stream type on the returned
     * {@link Ringtone}, it will re-create the {@link MediaPlayer}. This is just
     * an optimized route to avoid that.
     * 
     * @param streamType The stream type for the ringtone, or -1 if it should
     *            not be set (and the default used instead).
     * @see #getRingtone(Context, Uri)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.094 -0500", hash_original_method = "BAE78D92DE6F84ECF15BBF8C83F31BAC", hash_generated_method = "FCF2D9662DD529F86BACBE6E446EFBB7")
    private static Ringtone getRingtone(final Context context, Uri ringtoneUri, int streamType) {

        try {
            Ringtone r = new Ringtone(context);
            if (streamType >= 0) {
                r.setStreamType(streamType);
            }
            r.open(ringtoneUri);
            return r;
        } catch (Exception ex) {
            Log.e(TAG, "Failed to open ringtone " + ringtoneUri);
        }

        return null;
    }
    
    /**
     * Gets the current default sound's {@link Uri}. This will give the actual
     * sound {@link Uri}, instead of using this, most clients can use
     * {@link System#DEFAULT_RINGTONE_URI}.
     * 
     * @param context A context used for querying.
     * @param type The type whose default sound should be returned. One of
     *            {@link #TYPE_RINGTONE}, {@link #TYPE_NOTIFICATION}, or
     *            {@link #TYPE_ALARM}.
     * @return A {@link Uri} pointing to the default sound for the sound type.
     * @see #setActualDefaultRingtoneUri(Context, int, Uri)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.095 -0500", hash_original_method = "ADF1ADA5ADFEAE953CF8C758A8A3E876", hash_generated_method = "432781D47D54B0365C059BF27B31EDE0")
    public static Uri getActualDefaultRingtoneUri(Context context, int type) {
        String setting = getSettingForType(type);
        if (setting == null) return null;
        final String uriString = Settings.System.getString(context.getContentResolver(), setting);
        return uriString != null ? Uri.parse(uriString) : null;
    }
    
    /**
     * Sets the {@link Uri} of the default sound for a given sound type.
     * 
     * @param context A context used for querying.
     * @param type The type whose default sound should be set. One of
     *            {@link #TYPE_RINGTONE}, {@link #TYPE_NOTIFICATION}, or
     *            {@link #TYPE_ALARM}.
     * @param ringtoneUri A {@link Uri} pointing to the default sound to set.
     * @see #getActualDefaultRingtoneUri(Context, int)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.096 -0500", hash_original_method = "7F35A6FA4FCD4A3BDBAD3E9C2A20C1FB", hash_generated_method = "D114430764B3B3ED4C9F3C4F7A8FBEC1")
    public static void setActualDefaultRingtoneUri(Context context, int type, Uri ringtoneUri) {
        String setting = getSettingForType(type);
        if (setting == null) return;
        Settings.System.putString(context.getContentResolver(), setting,
                ringtoneUri != null ? ringtoneUri.toString() : null);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.097 -0500", hash_original_method = "80EF3F46842B7A46317143BED17C21C8", hash_generated_method = "4CDBD97CED152A19231DA6FCA29BBEDB")
    private static String getSettingForType(int type) {
        if ((type & TYPE_RINGTONE) != 0) {
            return Settings.System.RINGTONE;
        } else if ((type & TYPE_NOTIFICATION) != 0) {
            return Settings.System.NOTIFICATION_SOUND;
        } else if ((type & TYPE_ALARM) != 0) {
            return Settings.System.ALARM_ALERT;
        } else {
            return null;
        }
    }
    
    /**
     * Returns whether the given {@link Uri} is one of the default ringtones.
     * 
     * @param ringtoneUri The ringtone {@link Uri} to be checked.
     * @return Whether the {@link Uri} is a default.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.098 -0500", hash_original_method = "A5F67B0DE383F4D74803ECD8836ECBBD", hash_generated_method = "07A0F4F4C6159FCAA99C5030B2808C03")
    public static boolean isDefault(Uri ringtoneUri) {
        return getDefaultType(ringtoneUri) != -1;
    }
    
    /**
     * Returns the type of a default {@link Uri}.
     * 
     * @param defaultRingtoneUri The default {@link Uri}. For example,
     *            {@link System#DEFAULT_RINGTONE_URI},
     *            {@link System#DEFAULT_NOTIFICATION_URI}, or
     *            {@link System#DEFAULT_ALARM_ALERT_URI}.
     * @return The type of the defaultRingtoneUri, or -1.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.099 -0500", hash_original_method = "7F2381BA185DA4A8E1D41167C61F9114", hash_generated_method = "5440D566E4F3C1ADAE4D1F50416CC394")
    public static int getDefaultType(Uri defaultRingtoneUri) {
        if (defaultRingtoneUri == null) {
            return -1;
        } else if (defaultRingtoneUri.equals(Settings.System.DEFAULT_RINGTONE_URI)) {
            return TYPE_RINGTONE;
        } else if (defaultRingtoneUri.equals(Settings.System.DEFAULT_NOTIFICATION_URI)) {
            return TYPE_NOTIFICATION;
        } else if (defaultRingtoneUri.equals(Settings.System.DEFAULT_ALARM_ALERT_URI)) {
            return TYPE_ALARM;
        } else {
            return -1;
        }
    }
 
    /**
     * Returns the {@link Uri} for the default ringtone of a particular type.
     * Rather than returning the actual ringtone's sound {@link Uri}, this will
     * return the symbolic {@link Uri} which will resolved to the actual sound
     * when played.
     * 
     * @param type The ringtone type whose default should be returned.
     * @return The {@link Uri} of the default ringtone for the given type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.100 -0500", hash_original_method = "C50204A078065E3CC44987C7DD4E9366", hash_generated_method = "BA0EBD10CA93FA259E6B3A424544ABA1")
    public static Uri getDefaultUri(int type) {
        if ((type & TYPE_RINGTONE) != 0) {
            return Settings.System.DEFAULT_RINGTONE_URI;
        } else if ((type & TYPE_NOTIFICATION) != 0) {
            return Settings.System.DEFAULT_NOTIFICATION_URI;
        } else if ((type & TYPE_ALARM) != 0) {
            return Settings.System.DEFAULT_ALARM_ALERT_URI;
        } else {
            return null;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.048 -0500", hash_original_field = "CF3A29214B268588C30A010731798E63", hash_generated_field = "3A6444404274E3DC8241965FB9932525")


    private static final String TAG = "RingtoneManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:33:19.485 -0500", hash_original_field = "3FB811A7D0CCDFC02A5B3095502526BA", hash_generated_field = "ED16E3EF92CA085FB457B680BC7372FC")

    // <attr name="ringtoneType">
    
    /**
     * Type that refers to sounds that are used for the phone ringer.
     */
    public static final int TYPE_RINGTONE = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.050 -0500", hash_original_field = "5068B31BB91742CAD9463F7DB299758A", hash_generated_field = "029B501B321A75F003C8674A558A6A13")

    public static final int TYPE_NOTIFICATION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.051 -0500", hash_original_field = "D5C26C587120E10168CDEC925F7A6481", hash_generated_field = "BBCA5A500FD53711269D32A2F6D1328A")

    public static final int TYPE_ALARM = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.052 -0500", hash_original_field = "227E6093351474163A37C7A8FF9FA166", hash_generated_field = "8B2416B9294AA23758C14C3C826B84A5")

    public static final int TYPE_ALL = TYPE_RINGTONE | TYPE_NOTIFICATION | TYPE_ALARM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:33:19.490 -0500", hash_original_field = "BDDA04ADABDE1F6E37A528F589F5B2F4", hash_generated_field = "F443B0EE39D1E5BC7443C958DEB66F3C")

    
    /**
     * Activity Action: Shows a ringtone picker.
     * <p>
     * Input: {@link #EXTRA_RINGTONE_EXISTING_URI},
     * {@link #EXTRA_RINGTONE_SHOW_DEFAULT},
     * {@link #EXTRA_RINGTONE_SHOW_SILENT}, {@link #EXTRA_RINGTONE_TYPE},
     * {@link #EXTRA_RINGTONE_DEFAULT_URI}, {@link #EXTRA_RINGTONE_TITLE},
     * {@link #EXTRA_RINGTONE_INCLUDE_DRM}.
     * <p>
     * Output: {@link #EXTRA_RINGTONE_PICKED_URI}.
     */
    @SdkConstant(SdkConstantType.ACTIVITY_INTENT_ACTION)
    public static final String ACTION_RINGTONE_PICKER = "android.intent.action.RINGTONE_PICKER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.054 -0500", hash_original_field = "714D0468F1EDB54832A94D6440013A14", hash_generated_field = "15B90050645A4B0ACA78D8B694436F94")

    public static final String EXTRA_RINGTONE_SHOW_DEFAULT =
            "android.intent.extra.ringtone.SHOW_DEFAULT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.055 -0500", hash_original_field = "07A72177C2458DB301C74F696724D459", hash_generated_field = "566FBEBBF846BAC920B7D536448DA17F")

    public static final String EXTRA_RINGTONE_SHOW_SILENT =
            "android.intent.extra.ringtone.SHOW_SILENT";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.056 -0500", hash_original_field = "70B6820393CF5ABFB41595DEFA9FEC8A", hash_generated_field = "49C6E1F26784A85592AF2845B4B011A9")

    public static final String EXTRA_RINGTONE_INCLUDE_DRM =
            "android.intent.extra.ringtone.INCLUDE_DRM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.057 -0500", hash_original_field = "BA57454B1DF25BF1B3BABB21221EC57E", hash_generated_field = "DD32E8C9C7605B6A0427DEBE5FB6649F")

    public static final String EXTRA_RINGTONE_EXISTING_URI =
            "android.intent.extra.ringtone.EXISTING_URI";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.058 -0500", hash_original_field = "3ECA10E11E1BBDA6A3009578B8141BEC", hash_generated_field = "2F864E5D7B1AA877297A60228AA9A231")

    public static final String EXTRA_RINGTONE_DEFAULT_URI =
            "android.intent.extra.ringtone.DEFAULT_URI";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.059 -0500", hash_original_field = "7E8CBD88B4137C5CFEDD24027DBEF13A", hash_generated_field = "C886712EA1AD4EE9A27BB53E4D5C1193")

    public static final String EXTRA_RINGTONE_TYPE = "android.intent.extra.ringtone.TYPE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.059 -0500", hash_original_field = "4C09D2264678111A3286B7025DE92451", hash_generated_field = "C7EE82D78FAE0B28774C006E7072A1B3")

    public static final String EXTRA_RINGTONE_TITLE = "android.intent.extra.ringtone.TITLE";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.061 -0500", hash_original_field = "F3835DB967B551B35F8FAA4B42FEC79A", hash_generated_field = "D3C599A283BEDF7A8196BE7FBEA4D16A")

    public static final String EXTRA_RINGTONE_PICKED_URI =
            "android.intent.extra.ringtone.PICKED_URI";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.062 -0500", hash_original_field = "232989824C1729EBE820A74194A20DFC", hash_generated_field = "61278DEB030EFDDB9C797A60BD51DDC9")

    
    private static final String[] INTERNAL_COLUMNS = new String[] {
        MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE,
        "\"" + MediaStore.Audio.Media.INTERNAL_CONTENT_URI + "\"",
        MediaStore.Audio.Media.TITLE_KEY
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.062 -0500", hash_original_field = "0BBBAD30787C1B0E2D9FBDE8BBEBEF64", hash_generated_field = "F0072927626BA463B81C1FE14BA8DBE2")


    private static final String[] DRM_COLUMNS = new String[] {
        DrmStore.Audio._ID, DrmStore.Audio.TITLE,
        "\"" + DrmStore.Audio.CONTENT_URI + "\"",
        DrmStore.Audio.TITLE + " AS " + MediaStore.Audio.Media.TITLE_KEY
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.063 -0500", hash_original_field = "AEC603840D900D0D5EC535D1E1246812", hash_generated_field = "A46619D87F6A6621C78234992B75AC16")


    private static final String[] MEDIA_COLUMNS = new String[] {
        MediaStore.Audio.Media._ID, MediaStore.Audio.Media.TITLE,
        "\"" + MediaStore.Audio.Media.EXTERNAL_CONTENT_URI + "\"",
        MediaStore.Audio.Media.TITLE_KEY
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.064 -0500", hash_original_field = "5C2C11035EF516EC76B515484DEF1D8A", hash_generated_field = "1A310793E4749C0228E19D15A9145CA7")

    public static final int ID_COLUMN_INDEX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.065 -0500", hash_original_field = "131F5655E9920CFA4C6456CB2C532498", hash_generated_field = "E6A1D3DFD42B4AC10515625F810A6BAD")

    public static final int TITLE_COLUMN_INDEX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.066 -0500", hash_original_field = "63F1401CE62E89FB54228071B33C5D6C", hash_generated_field = "D5F147507D1EF1CAC5885574BB55F033")

    public static final int URI_COLUMN_INDEX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.066 -0500", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "B0D69375984D6EE7DC93AC12DB4DFC55")


    private Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.067 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.068 -0500", hash_original_field = "4A85E902ED72E65A9AF8F6ED265E4F89", hash_generated_field = "6E649D5858461199DBD67FE0A0D43789")

    
    private Cursor mCursor;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.069 -0500", hash_original_field = "3FEDBD167A89E4A9EF4D78179D24AFFB", hash_generated_field = "4CBCEBAF01C88051929B10818FF66937")


    private int mType = TYPE_RINGTONE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.069 -0500", hash_original_field = "DB6D4AD6F2DC525EBC1671AC782D526E", hash_generated_field = "2E1F7E6AFE9515754C5EDB99981F24C8")

    private List<String> mFilterColumns = new ArrayList<String>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.070 -0500", hash_original_field = "E4F0349F57F6613CBBCC70F387F9E1D2", hash_generated_field = "F30049F1DB4460139DD5C5858E52950F")

    
    private boolean mStopPreviousRingtone = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.071 -0500", hash_original_field = "82B37309BC5F9BE0A4160E5CB5E6F9BB", hash_generated_field = "C4ECD4547B5F1082232499A5FFF0E4E3")

    private Ringtone mPreviousRingtone;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.072 -0500", hash_original_field = "139BB2F98F570EA7E9B7557E6F3A0F84", hash_generated_field = "BB569023441C69981692423BFE009466")


    private boolean mIncludeDrm;
    
    /**
     * Constructs a RingtoneManager. This constructor is recommended as its
     * constructed instance manages cursor(s).
     * 
     * @param activity The activity used to get a managed cursor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.073 -0500", hash_original_method = "2A8A1FC42FD49A3D281BB8A7356537D2", hash_generated_method = "EC93F794C97F7097FD5424FF3177DD1D")
    public RingtoneManager(Activity activity) {
        mContext = mActivity = activity;
        setType(mType);
    }

    /**
     * Constructs a RingtoneManager. The instance constructed by this
     * constructor will not manage the cursor(s), so the client should handle
     * this itself.
     * 
     * @param context The context to used to get a cursor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.074 -0500", hash_original_method = "AEFBB2F4D30FA9949534E3B15FD9C787", hash_generated_method = "C7A98A73F6C92819CAC94B8AF371E3EA")
    public RingtoneManager(Context context) {
        mContext = context;
        setType(mType);
    }

    /**
     * Sets which type(s) of ringtones will be listed by this.
     * 
     * @param type The type(s), one or more of {@link #TYPE_RINGTONE},
     *            {@link #TYPE_NOTIFICATION}, {@link #TYPE_ALARM},
     *            {@link #TYPE_ALL}.
     * @see #EXTRA_RINGTONE_TYPE           
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.076 -0500", hash_original_method = "9DE86AC52EF0C8E8314EB0C63463BFAA", hash_generated_method = "21F6A1F77590F76A21B7D8AB78D12C0C")
    public void setType(int type) {

        if (mCursor != null) {
            throw new IllegalStateException(
                    "Setting filter columns should be done before querying for ringtones.");
        }
        
        mType = type;
        setFilterColumnsList(type);
    }

    /**
     * Infers the playback stream type based on what type of ringtones this
     * manager is returning.
     * 
     * @return The stream type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.077 -0500", hash_original_method = "26C25231B8EE38423D74AE317EB8CDCC", hash_generated_method = "9EB5B89F8F6E3F86EE9B6CF019F16002")
    public int inferStreamType() {
        switch (mType) {
            
            case TYPE_ALARM:
                return AudioManager.STREAM_ALARM;
                
            case TYPE_NOTIFICATION:
                return AudioManager.STREAM_NOTIFICATION;
                
            default:
                return AudioManager.STREAM_RING;
        }
    }
    
    /**
     * Whether retrieving another {@link Ringtone} will stop playing the
     * previously retrieved {@link Ringtone}.
     * <p>
     * If this is false, make sure to {@link Ringtone#stop()} any previous
     * ringtones to free resources.
     * 
     * @param stopPreviousRingtone If true, the previously retrieved
     *            {@link Ringtone} will be stopped.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.078 -0500", hash_original_method = "A35CDF85342D56F6EFBA8853AE857D3A", hash_generated_method = "3E7603E6CD1ADA1D5CE44EE21EBD771E")
    public void setStopPreviousRingtone(boolean stopPreviousRingtone) {
        mStopPreviousRingtone = stopPreviousRingtone;
    }

    /**
     * @see #setStopPreviousRingtone(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.078 -0500", hash_original_method = "0B3E7FCD199769A7D560D3943A8B1B23", hash_generated_method = "BD04C7E52D3775E40DE50778E120D21E")
    public boolean getStopPreviousRingtone() {
        return mStopPreviousRingtone;
    }

    /**
     * Stops playing the last {@link Ringtone} retrieved from this.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.079 -0500", hash_original_method = "A83DE0FFAA4D869AA2ED1763D4647132", hash_generated_method = "B1CD2AAA77FC045069ED6C642C98E7EF")
    public void stopPreviousRingtone() {
        if (mPreviousRingtone != null) {
            mPreviousRingtone.stop();
        }
    }
    
    /**
     * Returns whether DRM ringtones will be included.
     * 
     * @return Whether DRM ringtones will be included.
     * @see #setIncludeDrm(boolean)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.080 -0500", hash_original_method = "9F2D30C6202871DC182E5AD2A88B91B1", hash_generated_method = "50B7702E8B0768961F49CDEB977D0E20")
    public boolean getIncludeDrm() {
        return mIncludeDrm;
    }

    /**
     * Sets whether to include DRM ringtones.
     * 
     * @param includeDrm Whether to include DRM ringtones.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.081 -0500", hash_original_method = "9AE3415FBA2FD0FC22ED2C93FA9F8016", hash_generated_method = "78FB59646365F91BBBA03CF00202BD2E")
    public void setIncludeDrm(boolean includeDrm) {
        mIncludeDrm = includeDrm;
    }

    /**
     * Returns a {@link Cursor} of all the ringtones available. The returned
     * cursor will be the same cursor returned each time this method is called,
     * so do not {@link Cursor#close()} the cursor. The cursor can be
     * {@link Cursor#deactivate()} safely.
     * <p>
     * If {@link RingtoneManager#RingtoneManager(Activity)} was not used, the
     * caller should manage the returned cursor through its activity's life
     * cycle to prevent leaking the cursor.
     * 
     * @return A {@link Cursor} of all the ringtones available.
     * @see #ID_COLUMN_INDEX
     * @see #TITLE_COLUMN_INDEX
     * @see #URI_COLUMN_INDEX
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.082 -0500", hash_original_method = "890985AD9BCFC1049E02A6DFBECAA43E", hash_generated_method = "01D12EE6863EF1A9F2C9EC5DF6350F08")
    public Cursor getCursor() {
        if (mCursor != null && mCursor.requery()) {
            return mCursor;
        }
        
        final Cursor internalCursor = getInternalRingtones();
        final Cursor drmCursor = mIncludeDrm ? getDrmRingtones() : null;
        final Cursor mediaCursor = getMediaRingtones();
             
        return mCursor = new SortCursor(new Cursor[] { internalCursor, drmCursor, mediaCursor },
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
    }

    /**
     * Gets a {@link Ringtone} for the ringtone at the given position in the
     * {@link Cursor}.
     * 
     * @param position The position (in the {@link Cursor}) of the ringtone.
     * @return A {@link Ringtone} pointing to the ringtone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.082 -0500", hash_original_method = "6FCC5829E72C1DEF0426E1D999C80198", hash_generated_method = "3F229D3D7475261BB36BA8A3EEDCD4D4")
    public Ringtone getRingtone(int position) {
        if (mStopPreviousRingtone && mPreviousRingtone != null) {
            mPreviousRingtone.stop();
        }
        
        mPreviousRingtone = getRingtone(mContext, getRingtoneUri(position), inferStreamType());
        return mPreviousRingtone;
    }

    /**
     * Gets a {@link Uri} for the ringtone at the given position in the {@link Cursor}.
     * 
     * @param position The position (in the {@link Cursor}) of the ringtone.
     * @return A {@link Uri} pointing to the ringtone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.083 -0500", hash_original_method = "4D2A1FDA5FCE10764EC2653DD3811CF2", hash_generated_method = "C12BEE11A955513EE74FBA26EC70500E")
    public Uri getRingtoneUri(int position) {
        final Cursor cursor = getCursor();
        
        if (!cursor.moveToPosition(position)) {
            return null;
        }
        
        return getUriFromCursor(cursor);
    }
    
    /**
     * Gets the position of a {@link Uri} within this {@link RingtoneManager}.
     * 
     * @param ringtoneUri The {@link Uri} to retreive the position of.
     * @return The position of the {@link Uri}, or -1 if it cannot be found.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.085 -0500", hash_original_method = "ED1F9D5C280AF9E93D506709043225B3", hash_generated_method = "734274D4215FD5B433A7CE87ECCB5FA2")
    public int getRingtonePosition(Uri ringtoneUri) {
        
        if (ringtoneUri == null) return -1;
        
        final Cursor cursor = getCursor();
        final int cursorCount = cursor.getCount();
        
        if (!cursor.moveToFirst()) {
            return -1;
        }
        
        // Only create Uri objects when the actual URI changes
        Uri currentUri = null;
        String previousUriString = null;
        for (int i = 0; i < cursorCount; i++) {
            String uriString = cursor.getString(URI_COLUMN_INDEX);
            if (currentUri == null || !uriString.equals(previousUriString)) {
                currentUri = Uri.parse(uriString);
            }
            
            if (ringtoneUri.equals(ContentUris.withAppendedId(currentUri, cursor
                    .getLong(ID_COLUMN_INDEX)))) {
                return i;
            }
            
            cursor.move(1);
            
            previousUriString = uriString;
        }
        
        return -1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.088 -0500", hash_original_method = "110261102C7F5AFCA1139D9C233B8EDA", hash_generated_method = "FEBEBEC21D2A0C924BA4AA5D6DAA6395")
    private Cursor getInternalRingtones() {
        return query(
                MediaStore.Audio.Media.INTERNAL_CONTENT_URI, INTERNAL_COLUMNS,
                constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm),
                null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.089 -0500", hash_original_method = "39880916742952A44000639C81C1DE13", hash_generated_method = "8FF5602659052AD222C67D91CEE65D2D")
    private Cursor getDrmRingtones() {
        // DRM store does not have any columns to use for filtering 
        return query(
                DrmStore.Audio.CONTENT_URI, DRM_COLUMNS,
                null, null, DrmStore.Audio.TITLE);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.090 -0500", hash_original_method = "2B8B74EFBA4661DD0239B341E05A9848", hash_generated_method = "7714E2B56AD179ACB88F395F4A239304")
    private Cursor getMediaRingtones() {
         // Get the external media cursor. First check to see if it is mounted.
        final String status = Environment.getExternalStorageState();
        
        return (status.equals(Environment.MEDIA_MOUNTED) ||
                    status.equals(Environment.MEDIA_MOUNTED_READ_ONLY))
                ? query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, MEDIA_COLUMNS,
                    constructBooleanTrueWhereClause(mFilterColumns, mIncludeDrm), null,
                    MediaStore.Audio.Media.DEFAULT_SORT_ORDER)
                : null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.091 -0500", hash_original_method = "395BF736796D6FE27621FD0BAFF0C552", hash_generated_method = "17A9CF02FA5560B070C979565914CE4F")
    private void setFilterColumnsList(int type) {
        List<String> columns = mFilterColumns;
        columns.clear();
        
        if ((type & TYPE_RINGTONE) != 0) {
            columns.add(MediaStore.Audio.AudioColumns.IS_RINGTONE);
        }
        
        if ((type & TYPE_NOTIFICATION) != 0) {
            columns.add(MediaStore.Audio.AudioColumns.IS_NOTIFICATION);
        }
        
        if ((type & TYPE_ALARM) != 0) {
            columns.add(MediaStore.Audio.AudioColumns.IS_ALARM);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:58.092 -0500", hash_original_method = "4C1ED3200DB68E8363398CACE6114D33", hash_generated_method = "C3A1A75DFF99AF9B184BBB2AB5643BD8")
    private Cursor query(Uri uri,
            String[] projection,
            String selection,
            String[] selectionArgs,
            String sortOrder) {
        if (mActivity != null) {
            return mActivity.managedQuery(uri, projection, selection, selectionArgs, sortOrder);
        } else {
            return mContext.getContentResolver().query(uri, projection, selection, selectionArgs,
                    sortOrder);
        }
    }
}

