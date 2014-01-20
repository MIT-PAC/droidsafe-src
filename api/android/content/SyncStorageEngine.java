package android.content;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.accounts.Account;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import android.util.Xml;

import com.android.internal.os.AtomicFile;
import com.android.internal.util.ArrayUtils;
import com.android.internal.util.FastXmlSerializer;

public class SyncStorageEngine extends Handler {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.514 -0500", hash_original_method = "58FD7F74769293884900EBFE03B846A6", hash_generated_method = "EDCD8FBCAA16348D40B8B9F9F083F588")
    
public static SyncStorageEngine newTestInstance(Context context) {
        return new SyncStorageEngine(context, context.getFilesDir());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.517 -0500", hash_original_method = "ED5BE2338D68A0F61FF9F6A0518160F4", hash_generated_method = "8FCEB95D95687EF50D24DDA9B57645C6")
    
public static void init(Context context) {
        if (sSyncStorageEngine != null) {
            return;
        }
        // This call will return the correct directory whether Encrypted File Systems is
        // enabled or not.
        File dataDir = Environment.getSecureDataDirectory();
        sSyncStorageEngine = new SyncStorageEngine(context, dataDir);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.519 -0500", hash_original_method = "E2F0FAC5335BB0B002405F98A0EEA0BD", hash_generated_method = "F225F658250CC0F7524E05D424C8A732")
    
public static SyncStorageEngine getSingleton() {
        if (sSyncStorageEngine == null) {
            throw new IllegalStateException("not initialized");
        }
        return sSyncStorageEngine;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.604 -0500", hash_original_method = "2B5AC1B2F847EAF34CB62BA72FDAD096", hash_generated_method = "2FCBA234A8E3D4B9EC09881E21D44428")
    
public static boolean equals(Bundle b1, Bundle b2) {
        if (b1.size() != b2.size()) {
            return false;
        }
        if (b1.isEmpty()) {
            return true;
        }
        for (String key : b1.keySet()) {
            if (!b2.containsKey(key)) {
                return false;
            }
            if (!b1.get(key).equals(b2.get(key))) {
                return false;
            }
        }
        return true;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.675 -0500", hash_original_method = "95C75DD941065204D1878F796AFB73D9", hash_generated_method = "CD380022A9599053C9AF20CB78C98BFE")
    
static int getIntColumn(Cursor c, String name) {
        return c.getInt(c.getColumnIndex(name));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.677 -0500", hash_original_method = "D31304425BE62241852A05C2DAD11520", hash_generated_method = "5F169179EE73BEA2E150DCB74EA70AD0")
    
static long getLongColumn(Cursor c, String name) {
        return c.getLong(c.getColumnIndex(name));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.708 -0500", hash_original_method = "E4DA0135FFE566947D2B8F88E57874F7", hash_generated_method = "1D0FA115BDDDE29D6FC8883C302A341D")
    
static private byte[] flattenBundle(Bundle bundle) {
        byte[] flatData = null;
        Parcel parcel = Parcel.obtain();
        try {
            bundle.writeToParcel(parcel, 0);
            flatData = parcel.marshall();
        } finally {
            parcel.recycle();
        }
        return flatData;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.711 -0500", hash_original_method = "F0524A3E9BFBA6C03E3030AF4B1CA96F", hash_generated_method = "44644E7F98D4640ABF4BF3E8C8F0B1C1")
    
static private Bundle unflattenBundle(byte[] flatData) {
        Bundle bundle;
        Parcel parcel = Parcel.obtain();
        try {
            parcel.unmarshall(flatData, 0, flatData.length);
            parcel.setDataPosition(0);
            bundle = parcel.readBundle();
        } catch (RuntimeException e) {
            // A RuntimeException is thrown if we were unable to parse the parcel.
            // Create an empty parcel in this case.
            bundle = new Bundle();
        } finally {
            parcel.recycle();
        }
        return bundle;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.306 -0500", hash_original_field = "264AE0F69A379AF82B30661B10A7553C", hash_generated_field = "AF31108A14FC5488BDB972C9330ED310")

    private static final String TAG = "SyncManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.308 -0500", hash_original_field = "4A6EDB56E43981D79BBD4D9C5D13787C", hash_generated_field = "EF3259EDC7B0E8CE678372C0DF872FC5")

    private static final boolean DEBUG_FILE = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.311 -0500", hash_original_field = "0445B59DD94F41D04F820757FD0B7CFB", hash_generated_field = "38BF0EF4E89A3CF4939612B4A041EE55")

    private static final long DEFAULT_POLL_FREQUENCY_SECONDS = 60 * 60 * 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.313 -0500", hash_original_field = "B18E815C9163DB4A570F9575063544B3", hash_generated_field = "C007E49498DCD7D8957EDD3DF172B6AA")

    // @VisibleForTesting
    static final long MILLIS_IN_4WEEKS = 1000L * 60 * 60 * 24 * 7 * 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.316 -0500", hash_original_field = "7526D35F79D24A38147FFD61A0A8E2E8", hash_generated_field = "DBB1C0FAA50ADCA191193FD382FF1DB3")

    public static final int EVENT_START = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.318 -0500", hash_original_field = "629916BE232A3890E06A6402096B158A", hash_generated_field = "3BEF4367DEF9BD87D4115EACD7240966")

    public static final int EVENT_STOP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.320 -0500", hash_original_field = "9ACA6523018F4626EBDA95FB2ADAFB70", hash_generated_field = "23A3749EBAAECB171BAAC0BCFD6F9128")

    /** String names for the sync event types. */
    public static final String[] EVENTS = { "START", "STOP" };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.323 -0500", hash_original_field = "0AA225A5E9A043C3A1BE8E01039D7BC9", hash_generated_field = "CA7ACB3F234AF725615689B170392D03")

    public static final int SOURCE_SERVER = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.326 -0500", hash_original_field = "EFFF4E242D06942A15BB509E55A02095", hash_generated_field = "1B9C52B079F74B366A44C348D67DD20B")

    public static final int SOURCE_LOCAL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.328 -0500", hash_original_field = "5DEF3D370E248D7387F12899B841D2AF", hash_generated_field = "6873D2C4A74ED23B6139DD518C56FB9D")

    public static final int SOURCE_POLL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.331 -0500", hash_original_field = "4ED850C74C452BE0E5550714515A3D0F", hash_generated_field = "18826EB2F690F30A736E4BA73E385233")

    public static final int SOURCE_USER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.333 -0500", hash_original_field = "24E96B782B755EB024A3CD385F1FB89B", hash_generated_field = "7CEF055DDF11DD9167E38771846C2A7D")

    public static final int SOURCE_PERIODIC = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.335 -0500", hash_original_field = "8A5A60E1D83BF5C034C1BA2FA65938F5", hash_generated_field = "42B3B227F06616C376E0F38E8CD1D857")

    public static final long NOT_IN_BACKOFF_MODE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.338 -0500", hash_original_field = "ED8888F2D853B2981403071E61FE4C83", hash_generated_field = "CA0D4D8E029CF4F0FC382E8F90A0D776")

    public static final Intent SYNC_CONNECTION_SETTING_CHANGED_INTENT =
            new Intent("com.android.sync.SYNC_CONN_STATUS_CHANGED");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.340 -0500", hash_original_field = "BEF599C1F0DD7CAB871B687A4A763053", hash_generated_field = "7F341A05E23385DDD19FD97B27327C01")

    /** String names for the sync source types. */
    public static final String[] SOURCES = { "SERVER",
                                             "LOCAL",
                                             "POLL",
                                             "USER",
                                             "PERIODIC" };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.343 -0500", hash_original_field = "386F96246AB18749A7FF4E638CFEBDD9", hash_generated_field = "4DEC43F2868661A1BA0EBF5BF703C47A")

    public static final String MESG_SUCCESS = "success";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.345 -0500", hash_original_field = "2F257F4726946BF8F6AAED7693897301", hash_generated_field = "17FC59A1C84A7DA7A5A17548CAD57255")

    public static final String MESG_CANCELED = "canceled";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.347 -0500", hash_original_field = "B69E3C0685419F783632213E33AB6D51", hash_generated_field = "1B46D2BF183174FBED706FF3C2DF798D")

    public static final int MAX_HISTORY = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.349 -0500", hash_original_field = "41F9095680C49F0C28C0E7D718B24B1B", hash_generated_field = "2655E18C83B5F3B5454E37E1D43F3E2C")

    private static final int MSG_WRITE_STATUS = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.352 -0500", hash_original_field = "B1C9999D7407F25794EB4CCF5DE60589", hash_generated_field = "4EA8DDD188FF4C168E89C66E59773587")

    private static final long WRITE_STATUS_DELAY = 1000*60*10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.354 -0500", hash_original_field = "09C31F08512C33F6701CC5A4218A3863", hash_generated_field = "D7E2178F8C402B9173FFA3D315D94038")

    private static final int MSG_WRITE_STATISTICS = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.357 -0500", hash_original_field = "59D219C64ADB2F924BC4158959C22048", hash_generated_field = "20B3D5C604D6B06F3D714BB832758FDC")

    private static final long WRITE_STATISTICS_DELAY = 1000*60*30;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.360 -0500", hash_original_field = "5797BC0660FF9675692D0C1C8D82B0B0", hash_generated_field = "D424F9AD9A99C5564E56756A063DF4E4")

    private static final boolean SYNC_ENABLED_DEFAULT = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.362 -0500", hash_original_field = "1E39409E862F9C0BB5588863B87FA0B9", hash_generated_field = "BCB1DEDD10667E8F9144B92B5AF4FB3C")

    private static final int ACCOUNTS_VERSION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.364 -0500", hash_original_field = "651D1040C1E8E6D0E6223B68216AA795", hash_generated_field = "E829F19290AD6F16651117D8A72DC792")

    private static HashMap<String, String> sAuthorityRenames;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.491 -0500", hash_original_field = "26D22494CCDF53F584B358E3E8C5A58C", hash_generated_field = "30DA75A8F03960BB79F751A463A3C81A")

    private static volatile SyncStorageEngine sSyncStorageEngine = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.503 -0500", hash_original_field = "3CB842CFC826327677169E50F171CF05", hash_generated_field = "1AA6B4A5916CCA9E00BCD79C3BA829B9")

    private static final int PENDING_FINISH_TO_WRITE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.685 -0500", hash_original_field = "5BEF0F3C407D803FFE34B0A374E19EF3", hash_generated_field = "29DD7B46231A8851E3979ED054714BB2")

    public static final int STATUS_FILE_END = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.687 -0500", hash_original_field = "E2846C0B08C9948BE57576FD62ACDAE3", hash_generated_field = "3AD83470903C387E8F900C23B2FF2EA8")

    public static final int STATUS_FILE_ITEM = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.694 -0500", hash_original_field = "24DA76DB947CEA389781C2E032045D96", hash_generated_field = "197263DC5593D605C8462C10EBA64119")

    public static final int PENDING_OPERATION_VERSION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.713 -0500", hash_original_field = "86FF9BB6265922CD394631BF679D5C61", hash_generated_field = "C17775889B02E738EED29EAE10B23BE8")

    public static final int STATISTICS_FILE_END = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.715 -0500", hash_original_field = "6228E8EC576A8CCC859757C18570D997", hash_generated_field = "0293436725092F127B986477871B7112")

    public static final int STATISTICS_FILE_ITEM_OLD = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.718 -0500", hash_original_field = "73305F28738819EA4B572CD7398858A5", hash_generated_field = "74988DD095757B31CB2FB87FD58F31AD")

    public static final int STATISTICS_FILE_ITEM = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.461 -0500", hash_original_field = "C98AE26950D6156F9129319E90A725D8", hash_generated_field = "DCD9F929FBF293182CD7E5CC415D1656")

    private final SparseArray<AuthorityInfo> mAuthorities =
            new SparseArray<AuthorityInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.464 -0500", hash_original_field = "20FD7D843A90C90E4747485CD2A9D2D6", hash_generated_field = "4B36B4FEA0D3DAD8CB7109B7DAFD4F0B")

    private final HashMap<Account, AccountInfo> mAccounts =
        new HashMap<Account, AccountInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.466 -0500", hash_original_field = "56D3447B645CA9E486D9F636BC376724", hash_generated_field = "9061F8B36C87BD05CB7B61BC05EEA80D")

    private final ArrayList<PendingOperation> mPendingOperations =
            new ArrayList<PendingOperation>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.468 -0500", hash_original_field = "C65A16C9595357E7621D1C67987B5111", hash_generated_field = "17DF250BDACB991A8443A6BC974E4CEF")

    private final ArrayList<SyncInfo> mCurrentSyncs = new ArrayList<SyncInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.471 -0500", hash_original_field = "B68219C0A19E36A5261490447BA79367", hash_generated_field = "BB2BD481DA5E1951BA328BC00E9DDD6F")

    private final SparseArray<SyncStatusInfo> mSyncStatus =
            new SparseArray<SyncStatusInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.473 -0500", hash_original_field = "C74B3FE2287EA2BD0D88BA1FD16DD5F5", hash_generated_field = "6703D3447B5F81BE530922662FF9E2F7")

    private final ArrayList<SyncHistoryItem> mSyncHistory =
            new ArrayList<SyncHistoryItem>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.476 -0500", hash_original_field = "14983DF3E6833A27F9CFDD5794238834", hash_generated_field = "A61DFE30C0F235AC0390EF8C97D18E24")

    private final RemoteCallbackList<ISyncStatusObserver> mChangeListeners
            = new RemoteCallbackList<ISyncStatusObserver>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.478 -0500", hash_original_field = "7917E01A6FAE22986291ABA5BC5E419E", hash_generated_field = "2AE16416F500BFCB1C37E3AB89C8BDC4")

    private int mNextAuthorityId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.480 -0500", hash_original_field = "8C65ED2EB530566BC159DB582EBF3D92", hash_generated_field = "02779B60A3F80DE35E35BF0C5E0C43DC")

    private final DayStats[] mDayStats = new DayStats[7*4];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.482 -0500", hash_original_field = "FB2DD9550531F8AC67D035B45F568ED4", hash_generated_field = "EC9191FB914117C63C6512ED98BDDA48")

    private  Calendar mCal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.484 -0500", hash_original_field = "5823940FC0F93D8457936B751136F711", hash_generated_field = "0FB397B5159C15D66CFFB31661F31030")

    private int mYear;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.486 -0500", hash_original_field = "EBCACCD7A807DA767E07AF9537C727B4", hash_generated_field = "254F77756F02336521F67E6CA24B1E30")

    private int mYearInDays;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.488 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.493 -0500", hash_original_field = "F4D78D324419E3CB35397814995DA33F", hash_generated_field = "5D75657BE40E89D85D7C2D95C6C03670")

    private  AtomicFile mAccountInfoFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.495 -0500", hash_original_field = "43FDA3AD81FBBA029B02C276A79FD7BC", hash_generated_field = "BFFE61A45AAFF20D720253FB7EAF94E2")

    private  AtomicFile mStatusFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.498 -0500", hash_original_field = "2560FC5AE82514E2F8436FAB2210FA9D", hash_generated_field = "B21C478C853D31055421796340DF7AB7")

    private  AtomicFile mStatisticsFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.500 -0500", hash_original_field = "0FD749386378D2D46CAB28D70F104C91", hash_generated_field = "3E80DAA8531C0F48AE799261DF00CB4E")

    private  AtomicFile mPendingFile;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.505 -0500", hash_original_field = "B5F590598F520518BD24AC385EF444D8", hash_generated_field = "8ECC4C420766F27F9F3D44633E206229")

    private int mNumPendingFinished = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.507 -0500", hash_original_field = "B8BE376F03A383F61F17E96300A7F924", hash_generated_field = "F7ED6F40F4F31B59A250911223633F4B")

    private int mNextHistoryId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.509 -0500", hash_original_field = "9543951C6817EDD30A63B00CF9A421AC", hash_generated_field = "EBA144569AB4B50BF3932F380E591D51")

    private boolean mMasterSyncAutomatically = true;

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.512 -0500", hash_original_method = "A6EFE710C6881152489583C4A465D2CD", hash_generated_method = "7758E2E90161DD739C6ACE3450C6B9BE")
    
private SyncStorageEngine(Context context, File dataDir) {
        mContext = context;
        sSyncStorageEngine = this;

        mCal = Calendar.getInstance(TimeZone.getTimeZone("GMT+0"));

        File systemDir = new File(dataDir, "system");
        File syncDir = new File(systemDir, "sync");
        syncDir.mkdirs();
        mAccountInfoFile = new AtomicFile(new File(syncDir, "accounts.xml"));
        mStatusFile = new AtomicFile(new File(syncDir, "status.bin"));
        mPendingFile = new AtomicFile(new File(syncDir, "pending.bin"));
        mStatisticsFile = new AtomicFile(new File(syncDir, "stats.bin"));

        readAccountInfoLocked();
        readStatusLocked();
        readPendingOperationsLocked();
        readStatisticsLocked();
        readAndDeleteLegacyAccountInfoLocked();
        writeAccountInfoLocked();
        writeStatusLocked();
        writePendingOperationsLocked();
        writeStatisticsLocked();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.522 -0500", hash_original_method = "4DFC4B128F767AF6A0DE11433A3D7DB7", hash_generated_method = "05B68495556CEF6C4C4ACEFA660D4A65")
    
@Override public void handleMessage(Message msg) {
        if (msg.what == MSG_WRITE_STATUS) {
            synchronized (mAuthorities) {
                writeStatusLocked();
            }
        } else if (msg.what == MSG_WRITE_STATISTICS) {
            synchronized (mAuthorities) {
                writeStatisticsLocked();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.524 -0500", hash_original_method = "52497A49330565A574CE17BDC87E49EE", hash_generated_method = "586CCA5A6891213A4785EEA2F69C453E")
    
public void addStatusChangeListener(int mask, ISyncStatusObserver callback) {
        synchronized (mAuthorities) {
            mChangeListeners.register(callback, mask);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.526 -0500", hash_original_method = "6F129CA4CBCD6FCA8FC01A242206CA3D", hash_generated_method = "842A3277EC768CAD953C443A4366FF69")
    
public void removeStatusChangeListener(ISyncStatusObserver callback) {
        synchronized (mAuthorities) {
            mChangeListeners.unregister(callback);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.529 -0500", hash_original_method = "08D269D186E562E9C4A4640195EC72C3", hash_generated_method = "C71BE3B2C68985146E9C2D44F3AE7270")
    
private void reportChange(int which) {
        ArrayList<ISyncStatusObserver> reports = null;
        synchronized (mAuthorities) {
            int i = mChangeListeners.beginBroadcast();
            while (i > 0) {
                i--;
                Integer mask = (Integer)mChangeListeners.getBroadcastCookie(i);
                if ((which & mask.intValue()) == 0) {
                    continue;
                }
                if (reports == null) {
                    reports = new ArrayList<ISyncStatusObserver>(i);
                }
                reports.add(mChangeListeners.getBroadcastItem(i));
            }
            mChangeListeners.finishBroadcast();
        }

        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.v(TAG, "reportChange " + which + " to: " + reports);
        }

        if (reports != null) {
            int i = reports.size();
            while (i > 0) {
                i--;
                try {
                    reports.get(i).onStatusChanged(which);
                } catch (RemoteException e) {
                    // The remote callback list will take care of this for us.
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.532 -0500", hash_original_method = "1E3EB54BE416021CC2FC55EA818E4E21", hash_generated_method = "5DFB09E27D3C08ABB8D6CCE3271105EC")
    
public boolean getSyncAutomatically(Account account, String providerName) {
        synchronized (mAuthorities) {
            if (account != null) {
                AuthorityInfo authority = getAuthorityLocked(account, providerName,
                        "getSyncAutomatically");
                return authority != null && authority.enabled;
            }

            int i = mAuthorities.size();
            while (i > 0) {
                i--;
                AuthorityInfo authority = mAuthorities.valueAt(i);
                if (authority.authority.equals(providerName)
                        && authority.enabled) {
                    return true;
                }
            }
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.534 -0500", hash_original_method = "581987DB149A8DCAC958F242477B1863", hash_generated_method = "80235515D118795B4365CBB9562181D7")
    
public void setSyncAutomatically(Account account, String providerName, boolean sync) {
        Log.d(TAG, "setSyncAutomatically: " + /*account +*/ ", provider " + providerName
                + " -> " + sync);
        synchronized (mAuthorities) {
            AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
            if (authority.enabled == sync) {
                Log.d(TAG, "setSyncAutomatically: already set to " + sync + ", doing nothing");
                return;
            }
            authority.enabled = sync;
            writeAccountInfoLocked();
        }

        if (sync) {
            ContentResolver.requestSync(account, providerName, new Bundle());
        }
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.537 -0500", hash_original_method = "669A99F5C38004FBAED3A18D6E12F4E4", hash_generated_method = "F071B3A4F6BD9E4E592F185ECF2EDEB2")
    
public int getIsSyncable(Account account, String providerName) {
        synchronized (mAuthorities) {
            if (account != null) {
                AuthorityInfo authority = getAuthorityLocked(account, providerName,
                        "getIsSyncable");
                if (authority == null) {
                    return -1;
                }
                return authority.syncable;
            }

            int i = mAuthorities.size();
            while (i > 0) {
                i--;
                AuthorityInfo authority = mAuthorities.valueAt(i);
                if (authority.authority.equals(providerName)) {
                    return authority.syncable;
                }
            }
            return -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.539 -0500", hash_original_method = "F95D35FA2526F2113282D0AA6609AE27", hash_generated_method = "8657F753BDE6C64DDCB76C3EE59EA00A")
    
public void setIsSyncable(Account account, String providerName, int syncable) {
        if (syncable > 1) {
            syncable = 1;
        } else if (syncable < -1) {
            syncable = -1;
        }
        Log.d(TAG, "setIsSyncable: " + account + ", provider " + providerName + " -> " + syncable);
        synchronized (mAuthorities) {
            AuthorityInfo authority = getOrCreateAuthorityLocked(account, providerName, -1, false);
            if (authority.syncable == syncable) {
                Log.d(TAG, "setIsSyncable: already set to " + syncable + ", doing nothing");
                return;
            }
            authority.syncable = syncable;
            writeAccountInfoLocked();
        }

        if (syncable > 0) {
            ContentResolver.requestSync(account, providerName, new Bundle());
        }
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.541 -0500", hash_original_method = "8DC1822E61630B36C083348F9F85FD1C", hash_generated_method = "C301815FFE81A2EE90ADC4250BC3013C")
    
public Pair<Long, Long> getBackoff(Account account, String providerName) {
        synchronized (mAuthorities) {
            AuthorityInfo authority = getAuthorityLocked(account, providerName, "getBackoff");
            if (authority == null || authority.backoffTime < 0) {
                return null;
            }
            return Pair.create(authority.backoffTime, authority.backoffDelay);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.544 -0500", hash_original_method = "470D6F06A561962AAC0558CECDD66F24", hash_generated_method = "569805D22DF6D6829E66317ED4332A1B")
    
public void setBackoff(Account account, String providerName,
            long nextSyncTime, long nextDelay) {
        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.v(TAG, "setBackoff: " + account + ", provider " + providerName
                    + " -> nextSyncTime " + nextSyncTime + ", nextDelay " + nextDelay);
        }
        boolean changed = false;
        synchronized (mAuthorities) {
            if (account == null || providerName == null) {
                for (AccountInfo accountInfo : mAccounts.values()) {
                    if (account != null && !account.equals(accountInfo.account)) continue;
                    for (AuthorityInfo authorityInfo : accountInfo.authorities.values()) {
                        if (providerName != null && !providerName.equals(authorityInfo.authority)) {
                            continue;
                        }
                        if (authorityInfo.backoffTime != nextSyncTime
                                || authorityInfo.backoffDelay != nextDelay) {
                            authorityInfo.backoffTime = nextSyncTime;
                            authorityInfo.backoffDelay = nextDelay;
                            changed = true;
                        }
                    }
                }
            } else {
                AuthorityInfo authority =
                        getOrCreateAuthorityLocked(account, providerName, -1 /* ident */, true);
                if (authority.backoffTime == nextSyncTime && authority.backoffDelay == nextDelay) {
                    return;
                }
                authority.backoffTime = nextSyncTime;
                authority.backoffDelay = nextDelay;
                changed = true;
            }
        }

        if (changed) {
            reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.547 -0500", hash_original_method = "AFA2215C700770E680F9E8F54668F915", hash_generated_method = "3B90758A12C6C43B462CB99485E81B32")
    
public void clearAllBackoffs(SyncQueue syncQueue) {
        boolean changed = false;
        synchronized (mAuthorities) {
            for (AccountInfo accountInfo : mAccounts.values()) {
                for (AuthorityInfo authorityInfo : accountInfo.authorities.values()) {
                    if (authorityInfo.backoffTime != NOT_IN_BACKOFF_MODE
                            || authorityInfo.backoffDelay != NOT_IN_BACKOFF_MODE) {
                        if (Log.isLoggable(TAG, Log.VERBOSE)) {
                            Log.v(TAG, "clearAllBackoffs:"
                                    + " authority:" + authorityInfo.authority
                                    + " account:" + accountInfo.account.name
                                    + " backoffTime was: " + authorityInfo.backoffTime
                                    + " backoffDelay was: " + authorityInfo.backoffDelay);
                        }
                        authorityInfo.backoffTime = NOT_IN_BACKOFF_MODE;
                        authorityInfo.backoffDelay = NOT_IN_BACKOFF_MODE;
                        syncQueue.onBackoffChanged(accountInfo.account, authorityInfo.authority, 0);
                        changed = true;
                    }
                }
            }
        }

        if (changed) {
            reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.550 -0500", hash_original_method = "4C9FEA1518FBFDF4D1B5258B0B2AE78D", hash_generated_method = "60448F88E536EAE5AC8E0100698C300C")
    
public void setDelayUntilTime(Account account, String providerName, long delayUntil) {
        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.v(TAG, "setDelayUntil: " + account + ", provider " + providerName
                    + " -> delayUntil " + delayUntil);
        }
        synchronized (mAuthorities) {
            AuthorityInfo authority = getOrCreateAuthorityLocked(
                    account, providerName, -1 /* ident */, true);
            if (authority.delayUntil == delayUntil) {
                return;
            }
            authority.delayUntil = delayUntil;
        }

        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.552 -0500", hash_original_method = "DA0E26DF9B57177D554F116843CE820C", hash_generated_method = "A9436987637A91145540631754852D7F")
    
public long getDelayUntilTime(Account account, String providerName) {
        synchronized (mAuthorities) {
            AuthorityInfo authority = getAuthorityLocked(account, providerName, "getDelayUntil");
            if (authority == null) {
                return 0;
            }
            return authority.delayUntil;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.555 -0500", hash_original_method = "DA5487F77FC92CA93809E84A1EE05946", hash_generated_method = "C172E9D81AEE380B4B2BB426A88DABE9")
    
private void updateOrRemovePeriodicSync(Account account, String providerName, Bundle extras,
            long period, boolean add) {
        if (period <= 0) {
            period = 0;
        }
        if (extras == null) {
            extras = new Bundle();
        }
        if (Log.isLoggable(TAG, Log.VERBOSE)) {
            Log.v(TAG, "addOrRemovePeriodicSync: " + account + ", provider " + providerName
                    + " -> period " + period + ", extras " + extras);
        }
        synchronized (mAuthorities) {
            try {
                AuthorityInfo authority =
                        getOrCreateAuthorityLocked(account, providerName, -1, false);
                if (add) {
                    // add this periodic sync if one with the same extras doesn't already
                    // exist in the periodicSyncs array
                    boolean alreadyPresent = false;
                    for (int i = 0, N = authority.periodicSyncs.size(); i < N; i++) {
                        Pair<Bundle, Long> syncInfo = authority.periodicSyncs.get(i);
                        final Bundle existingExtras = syncInfo.first;
                        if (equals(existingExtras, extras)) {
                            if (syncInfo.second == period) {
                                return;
                            }
                            authority.periodicSyncs.set(i, Pair.create(extras, period));
                            alreadyPresent = true;
                            break;
                        }
                    }
                    // if we added an entry to the periodicSyncs array also add an entry to
                    // the periodic syncs status to correspond to it
                    if (!alreadyPresent) {
                        authority.periodicSyncs.add(Pair.create(extras, period));
                        SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);
                        status.setPeriodicSyncTime(authority.periodicSyncs.size() - 1, 0);
                    }
                } else {
                    // remove any periodic syncs that match the authority and extras
                    SyncStatusInfo status = mSyncStatus.get(authority.ident);
                    boolean changed = false;
                    Iterator<Pair<Bundle, Long>> iterator = authority.periodicSyncs.iterator();
                    int i = 0;
                    while (iterator.hasNext()) {
                        Pair<Bundle, Long> syncInfo = iterator.next();
                        if (equals(syncInfo.first, extras)) {
                            iterator.remove();
                            changed = true;
                            // if we removed an entry from the periodicSyncs array also
                            // remove the corresponding entry from the status
                            if (status != null) {
                                status.removePeriodicSyncTime(i);
                            }
                        } else {
                            i++;
                        }
                    }
                    if (!changed) {
                        return;
                    }
                }
            } finally {
                writeAccountInfoLocked();
                writeStatusLocked();
            }
        }

        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.558 -0500", hash_original_method = "403A8311B76EBF44C870FFCE456B63FB", hash_generated_method = "B9422856F206F513AFB03B3DCD723FB1")
    
public void addPeriodicSync(Account account, String providerName, Bundle extras,
            long pollFrequency) {
        updateOrRemovePeriodicSync(account, providerName, extras, pollFrequency, true /* add */);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.560 -0500", hash_original_method = "A5551A39E3E716437015AA42AB9CA434", hash_generated_method = "79EA740FD68ED6B1997AB9C040997461")
    
public void removePeriodicSync(Account account, String providerName, Bundle extras) {
        updateOrRemovePeriodicSync(account, providerName, extras, 0 /* period, ignored */,
                false /* remove */);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.562 -0500", hash_original_method = "43BA96B870E40929E429A78D83FB8F24", hash_generated_method = "D1E760CEEBCA6B5414E34F01D406B552")
    
public List<PeriodicSync> getPeriodicSyncs(Account account, String providerName) {
        ArrayList<PeriodicSync> syncs = new ArrayList<PeriodicSync>();
        synchronized (mAuthorities) {
            AuthorityInfo authority = getAuthorityLocked(account, providerName, "getPeriodicSyncs");
            if (authority != null) {
                for (Pair<Bundle, Long> item : authority.periodicSyncs) {
                    syncs.add(new PeriodicSync(account, providerName, item.first, item.second));
                }
            }
        }
        return syncs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.564 -0500", hash_original_method = "AF0CE82B663D00FD098AAFE2F6E1B437", hash_generated_method = "7C5851A1242CC9BF2E25B27B88386C3F")
    
public void setMasterSyncAutomatically(boolean flag) {
        synchronized (mAuthorities) {
            if (mMasterSyncAutomatically == flag) {
                return;
            }
            mMasterSyncAutomatically = flag;
            writeAccountInfoLocked();
        }
        if (flag) {
            ContentResolver.requestSync(null, null, new Bundle());
        }
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_SETTINGS);
        mContext.sendBroadcast(SYNC_CONNECTION_SETTING_CHANGED_INTENT);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.567 -0500", hash_original_method = "6DBCD9157A2DF54805879831F88D4B77", hash_generated_method = "72681C012D249A59D10E7D1E8DCF963C")
    
public boolean getMasterSyncAutomatically() {
        synchronized (mAuthorities) {
            return mMasterSyncAutomatically;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.569 -0500", hash_original_method = "AC4455129C3CF5603625E4A23A44D091", hash_generated_method = "B655F121D981C4785EF75BFA75FBDB8E")
    
public AuthorityInfo getOrCreateAuthority(Account account, String authority) {
        synchronized (mAuthorities) {
            return getOrCreateAuthorityLocked(account, authority,
                    -1 /* assign a new identifier if creating a new authority */,
                    true /* write to storage if this results in a change */);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.572 -0500", hash_original_method = "BAFC16DAE21D996A746903C6AB7A1E8C", hash_generated_method = "D668049BD0F7FD9F1001EC2966F8A37D")
    
public void removeAuthority(Account account, String authority) {
        synchronized (mAuthorities) {
            removeAuthorityLocked(account, authority, true /* doWrite */);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.574 -0500", hash_original_method = "B031DD2BDA31C86F4257F62895ABA1B2", hash_generated_method = "852C6026CD3CC54B24A72BDA57068E55")
    
public AuthorityInfo getAuthority(int authorityId) {
        synchronized (mAuthorities) {
            return mAuthorities.get(authorityId);
        }
    }

    /**
     * Returns true if there is currently a sync operation for the given
     * account or authority actively being processed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.576 -0500", hash_original_method = "F75815D4B05E7C78CBDEC7A3CDAC25FD", hash_generated_method = "064C3E0BDEF61E5B04B6655C4C246750")
    
public boolean isSyncActive(Account account, String authority) {
        synchronized (mAuthorities) {
            for (SyncInfo syncInfo : mCurrentSyncs) {
                AuthorityInfo ainfo = getAuthority(syncInfo.authorityId);
                if (ainfo != null && ainfo.account.equals(account)
                        && ainfo.authority.equals(authority)) {
                    return true;
                }
            }
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.579 -0500", hash_original_method = "42358B0BF27AF155FB408124FA39D63B", hash_generated_method = "3B6267578CC12B76A22166D162B50E60")
    
public PendingOperation insertIntoPending(PendingOperation op) {
        synchronized (mAuthorities) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "insertIntoPending: account=" + op.account
                    + " auth=" + op.authority
                    + " src=" + op.syncSource
                    + " extras=" + op.extras);
            }

            AuthorityInfo authority = getOrCreateAuthorityLocked(op.account,
                    op.authority,
                    -1 /* desired identifier */,
                    true /* write accounts to storage */);
            if (authority == null) {
                return null;
            }

            op = new PendingOperation(op);
            op.authorityId = authority.ident;
            mPendingOperations.add(op);
            appendPendingOperationLocked(op);

            SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);
            status.pending = true;
        }

        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        return op;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.582 -0500", hash_original_method = "50B189E2AFDD83FCD044E18708DDFA85", hash_generated_method = "A0CC1CBFBD6D70E6FDB76E5C5A7397A8")
    
public boolean deleteFromPending(PendingOperation op) {
        boolean res = false;
        synchronized (mAuthorities) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "deleteFromPending: account=" + op.account
                    + " auth=" + op.authority
                    + " src=" + op.syncSource
                    + " extras=" + op.extras);
            }
            if (mPendingOperations.remove(op)) {
                if (mPendingOperations.size() == 0
                        || mNumPendingFinished >= PENDING_FINISH_TO_WRITE) {
                    writePendingOperationsLocked();
                    mNumPendingFinished = 0;
                } else {
                    mNumPendingFinished++;
                }

                AuthorityInfo authority = getAuthorityLocked(op.account, op.authority,
                        "deleteFromPending");
                if (authority != null) {
                    if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "removing - " + authority);
                    final int N = mPendingOperations.size();
                    boolean morePending = false;
                    for (int i=0; i<N; i++) {
                        PendingOperation cur = mPendingOperations.get(i);
                        if (cur.account.equals(op.account)
                                && cur.authority.equals(op.authority)) {
                            morePending = true;
                            break;
                        }
                    }

                    if (!morePending) {
                        if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "no more pending!");
                        SyncStatusInfo status = getOrCreateSyncStatusLocked(authority.ident);
                        status.pending = false;
                    }
                }

                res = true;
            }
        }

        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        return res;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.584 -0500", hash_original_method = "B0FBF76821996DB4DA7D3758DC73EE90", hash_generated_method = "A82DAC44C31610260F8AF991A53CC1FC")
    
public int clearPending() {
        int num;
        synchronized (mAuthorities) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "clearPending");
            }
            num = mPendingOperations.size();
            mPendingOperations.clear();
            final int N = mSyncStatus.size();
            for (int i=0; i<N; i++) {
                mSyncStatus.valueAt(i).pending = false;
            }
            writePendingOperationsLocked();
        }
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_PENDING);
        return num;
    }

    /**
     * Return a copy of the current array of pending operations.  The
     * PendingOperation objects are the real objects stored inside, so that
     * they can be used with deleteFromPending().
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.587 -0500", hash_original_method = "C927FD207EDF022EE536945570AA8499", hash_generated_method = "706553CB9B319F44717E52996C412A21")
    
public ArrayList<PendingOperation> getPendingOperations() {
        synchronized (mAuthorities) {
            return new ArrayList<PendingOperation>(mPendingOperations);
        }
    }

    /**
     * Return the number of currently pending operations.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.589 -0500", hash_original_method = "CC9059641F127440F6B10F04341F5D1E", hash_generated_method = "0A023AC0E3C8066DD3006B4129461C8C")
    
public int getPendingOperationCount() {
        synchronized (mAuthorities) {
            return mPendingOperations.size();
        }
    }

    /**
     * Called when the set of account has changed, given the new array of
     * active accounts.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.592 -0500", hash_original_method = "38BC76D95CA0A954EB857B91A285A324", hash_generated_method = "82ACD7F436AB6358B2DD98EC3EEF7E28")
    
public void doDatabaseCleanup(Account[] accounts) {
        synchronized (mAuthorities) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) Log.w(TAG, "Updating for new accounts...");
            SparseArray<AuthorityInfo> removing = new SparseArray<AuthorityInfo>();
            Iterator<AccountInfo> accIt = mAccounts.values().iterator();
            while (accIt.hasNext()) {
                AccountInfo acc = accIt.next();
                if (!ArrayUtils.contains(accounts, acc.account)) {
                    // This account no longer exists...
                    if (Log.isLoggable(TAG, Log.VERBOSE)) {
                        Log.w(TAG, "Account removed: " + acc.account);
                    }
                    for (AuthorityInfo auth : acc.authorities.values()) {
                        removing.put(auth.ident, auth);
                    }
                    accIt.remove();
                }
            }

            // Clean out all data structures.
            int i = removing.size();
            if (i > 0) {
                while (i > 0) {
                    i--;
                    int ident = removing.keyAt(i);
                    mAuthorities.remove(ident);
                    int j = mSyncStatus.size();
                    while (j > 0) {
                        j--;
                        if (mSyncStatus.keyAt(j) == ident) {
                            mSyncStatus.remove(mSyncStatus.keyAt(j));
                        }
                    }
                    j = mSyncHistory.size();
                    while (j > 0) {
                        j--;
                        if (mSyncHistory.get(j).authorityId == ident) {
                            mSyncHistory.remove(j);
                        }
                    }
                }
                writeAccountInfoLocked();
                writeStatusLocked();
                writePendingOperationsLocked();
                writeStatisticsLocked();
            }
        }
    }

    /**
     * Called when a sync is starting. Supply a valid ActiveSyncContext with information
     * about the sync.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.594 -0500", hash_original_method = "1CDF6C9A1F9F2098201F4D7433D51EE7", hash_generated_method = "3044714150AE11168217F638F9DD33EF")
    
public SyncInfo addActiveSync(SyncManager.ActiveSyncContext activeSyncContext) {
        final SyncInfo syncInfo;
        synchronized (mAuthorities) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "setActiveSync: account="
                    + activeSyncContext.mSyncOperation.account
                    + " auth=" + activeSyncContext.mSyncOperation.authority
                    + " src=" + activeSyncContext.mSyncOperation.syncSource
                    + " extras=" + activeSyncContext.mSyncOperation.extras);
            }
            AuthorityInfo authority = getOrCreateAuthorityLocked(
                    activeSyncContext.mSyncOperation.account,
                    activeSyncContext.mSyncOperation.authority,
                    -1 /* assign a new identifier if creating a new authority */,
                    true /* write to storage if this results in a change */);
            syncInfo = new SyncInfo(authority.ident,
                    authority.account, authority.authority,
                    activeSyncContext.mStartTime);
            mCurrentSyncs.add(syncInfo);
        }

        reportActiveChange();
        return syncInfo;
    }

    /**
     * Called to indicate that a previously active sync is no longer active.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.597 -0500", hash_original_method = "2B31DF94CF8024B200C12FFD3895E8BE", hash_generated_method = "5F64586168BAF6F6F403282E848793A6")
    
public void removeActiveSync(SyncInfo syncInfo) {
        synchronized (mAuthorities) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "removeActiveSync: account="
                        + syncInfo.account + " auth=" + syncInfo.authority);
            }
            mCurrentSyncs.remove(syncInfo);
        }

        reportActiveChange();
    }

    /**
     * To allow others to send active change reports, to poke clients.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.599 -0500", hash_original_method = "5624025FD66E34CEC2F994FDB502F76B", hash_generated_method = "178F02D1FDAA12FE7676116BF391D7C7")
    
public void reportActiveChange() {
        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_ACTIVE);
    }
    
    public static class PendingOperation {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.368 -0500", hash_original_field = "9D630FBF90643CC60961CCF48FECCA0B", hash_generated_field = "9D630FBF90643CC60961CCF48FECCA0B")

         Account account;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.370 -0500", hash_original_field = "ADDF5490BF1C10ABAFE6E2B2AE40316C", hash_generated_field = "ADDF5490BF1C10ABAFE6E2B2AE40316C")

         int syncSource;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.372 -0500", hash_original_field = "246C0F9F2C0270494BEB2E9C6833888B", hash_generated_field = "246C0F9F2C0270494BEB2E9C6833888B")

         String authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.375 -0500", hash_original_field = "6F80A5414A80FF69E92A0BD3C0E073DC", hash_generated_field = "6F80A5414A80FF69E92A0BD3C0E073DC")

         Bundle extras;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.377 -0500", hash_original_field = "D7DC8099D62435877828BDBBACCABD83", hash_generated_field = "D7DC8099D62435877828BDBBACCABD83")

         boolean expedited;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.379 -0500", hash_original_field = "B11D0145EE299937169261FF5464F8E6", hash_generated_field = "B11D0145EE299937169261FF5464F8E6")

        int authorityId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.381 -0500", hash_original_field = "CCB24DDC55B05A8A59BF27C8C026E7C2", hash_generated_field = "CCB24DDC55B05A8A59BF27C8C026E7C2")

        byte[] flatExtras;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.384 -0500", hash_original_method = "EF059F8E3294963F1E848A9313768B5B", hash_generated_method = "EF059F8E3294963F1E848A9313768B5B")
        
PendingOperation(Account account, int source,
                String authority, Bundle extras, boolean expedited) {
            this.account = account;
            this.syncSource = source;
            this.authority = authority;
            this.extras = extras != null ? new Bundle(extras) : extras;
            this.expedited = expedited;
            this.authorityId = -1;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.387 -0500", hash_original_method = "1B5DBB8810EC174C356BDFB975D9E53C", hash_generated_method = "1B5DBB8810EC174C356BDFB975D9E53C")
        
PendingOperation(PendingOperation other) {
            this.account = other.account;
            this.syncSource = other.syncSource;
            this.authority = other.authority;
            this.extras = other.extras;
            this.authorityId = other.authorityId;
            this.expedited = other.expedited;
        }
        
    }
    
    static class AccountInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.391 -0500", hash_original_field = "9D630FBF90643CC60961CCF48FECCA0B", hash_generated_field = "9D630FBF90643CC60961CCF48FECCA0B")

         Account account;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.394 -0500", hash_original_field = "32A00E6A53EB0E09BB191F374D467778", hash_generated_field = "582FF2E1ECE36BD91B7F484171C698A4")

        final HashMap<String, AuthorityInfo> authorities =
                new HashMap<String, AuthorityInfo>();

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.396 -0500", hash_original_method = "0A42050331BE326DBD226E8BF4C55827", hash_generated_method = "0A42050331BE326DBD226E8BF4C55827")
        
AccountInfo(Account account) {
            this.account = account;
        }
        
    }
    
    public static class AuthorityInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.400 -0500", hash_original_field = "9D630FBF90643CC60961CCF48FECCA0B", hash_generated_field = "9D630FBF90643CC60961CCF48FECCA0B")

         Account account;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.402 -0500", hash_original_field = "246C0F9F2C0270494BEB2E9C6833888B", hash_generated_field = "246C0F9F2C0270494BEB2E9C6833888B")

         String authority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.405 -0500", hash_original_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747", hash_generated_field = "D6522CF0EB0B8A28ECDAD3A7DBFFD747")

         int ident;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.407 -0500", hash_original_field = "D42E676CEDD1F98F54276A59532354DC", hash_generated_field = "D42E676CEDD1F98F54276A59532354DC")

        boolean enabled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.409 -0500", hash_original_field = "79AAA92E0C1E2414AE9E421D3715FFA7", hash_generated_field = "79AAA92E0C1E2414AE9E421D3715FFA7")

        int syncable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.411 -0500", hash_original_field = "F9BE9859B6F90DC841CE99B8A7F51A4E", hash_generated_field = "F9BE9859B6F90DC841CE99B8A7F51A4E")

        long backoffTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.413 -0500", hash_original_field = "3E91C22FA3C3A3339E22C765EEF95ECF", hash_generated_field = "3E91C22FA3C3A3339E22C765EEF95ECF")

        long backoffDelay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.416 -0500", hash_original_field = "FF2672CE15194FA4F169DAC34CF8A869", hash_generated_field = "FF2672CE15194FA4F169DAC34CF8A869")

        long delayUntil;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.418 -0500", hash_original_field = "9A4BDF3CAA0D13530C1392D88D3B28FD", hash_generated_field = "9A4BDF3CAA0D13530C1392D88D3B28FD")

         ArrayList<Pair<Bundle, Long>> periodicSyncs;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.420 -0500", hash_original_method = "F1AF0EF8567860728BE1920368DC5483", hash_generated_method = "0280BA6672DA948742C07C0FEEF0FE72")
        
AuthorityInfo(Account account, String authority, int ident) {
            this.account = account;
            this.authority = authority;
            this.ident = ident;
            enabled = SYNC_ENABLED_DEFAULT;
            syncable = -1; // default to "unknown"
            backoffTime = -1; // if < 0 then we aren't in backoff mode
            backoffDelay = -1; // if < 0 then we aren't in backoff mode
            periodicSyncs = new ArrayList<Pair<Bundle, Long>>();
            periodicSyncs.add(Pair.create(new Bundle(), DEFAULT_POLL_FREQUENCY_SECONDS));
        }
        
    }
    
    public static class SyncHistoryItem {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.425 -0500", hash_original_field = "B11D0145EE299937169261FF5464F8E6", hash_generated_field = "B11D0145EE299937169261FF5464F8E6")

        int authorityId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.427 -0500", hash_original_field = "EFC3D33E7164A099395EA11FA008631A", hash_generated_field = "EFC3D33E7164A099395EA11FA008631A")

        int historyId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.429 -0500", hash_original_field = "8BDF38DD5485D11C65E41598A447EC76", hash_generated_field = "8BDF38DD5485D11C65E41598A447EC76")

        long eventTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.432 -0500", hash_original_field = "019980784258B693231C7932844AF0BC", hash_generated_field = "019980784258B693231C7932844AF0BC")

        long elapsedTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.434 -0500", hash_original_field = "926255832D3A4770F722E618872D36FC", hash_generated_field = "926255832D3A4770F722E618872D36FC")

        int source;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.436 -0500", hash_original_field = "0AA9440F5EB6CF7AA5F6EE77723B4674", hash_generated_field = "0AA9440F5EB6CF7AA5F6EE77723B4674")

        int event;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.437 -0500", hash_original_field = "7BAE41919A19B3117C8C028B40BE197B", hash_generated_field = "7BAE41919A19B3117C8C028B40BE197B")

        long upstreamActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.439 -0500", hash_original_field = "B78B031020001048916FB9B95358FFD7", hash_generated_field = "B78B031020001048916FB9B95358FFD7")

        long downstreamActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.441 -0500", hash_original_field = "4661373404204B119E74D3CE353ABACF", hash_generated_field = "4661373404204B119E74D3CE353ABACF")

        String mesg;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.143 -0400", hash_original_method = "2A1719F3DDEE538E4071CFCF49D97D66", hash_generated_method = "2A1719F3DDEE538E4071CFCF49D97D66")
        public SyncHistoryItem ()
        {
            //Synthesized constructor
        }

    }
    
    public static class DayStats {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.446 -0500", hash_original_field = "7B9E331B9FA77276F82C941B252DC90D", hash_generated_field = "0E9628A682BEC1AED9AC9EDA1BF2C9CB")

        public  int day;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.449 -0500", hash_original_field = "F8F1C6B074B9644F897C1D5B03E39CCB", hash_generated_field = "E32AF39AAA65273577552E6199614DFB")

        public int successCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.451 -0500", hash_original_field = "DFE732E8690B460BA7A1F772CD893FA2", hash_generated_field = "E8A8B28F4FBBA8ADC8F6EA4E5EA3DF18")

        public long successTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.453 -0500", hash_original_field = "E9E811D423BAE5335EA6E31D33EE81A5", hash_generated_field = "4E23062AC4D24AC50DF56E8B405F9CA1")

        public int failureCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.455 -0500", hash_original_field = "D53FE53EB5559271FAE6B472829BA388", hash_generated_field = "D11480323C3691B82CABDCBFB47DADC3")

        public long failureTime;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.458 -0500", hash_original_method = "59D9CE47C9B58BC0ECFC5F57173A8EB8", hash_generated_method = "6811E2F2A91C5607AB9A0282E9202CB9")
        
public DayStats(int day) {
            this.day = day;
        }
        
    }

    /**
     * Note that sync has started for the given account and authority.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.601 -0500", hash_original_method = "7B7D2D5D3E7E0D062624D3006A76AABE", hash_generated_method = "9E23FA9A1D1D853AED0FA4ADDB287F29")
    
public long insertStartSyncEvent(Account accountName, String authorityName,
            long now, int source) {
        long id;
        synchronized (mAuthorities) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "insertStartSyncEvent: account=" + accountName
                    + " auth=" + authorityName + " source=" + source);
            }
            AuthorityInfo authority = getAuthorityLocked(accountName, authorityName,
                    "insertStartSyncEvent");
            if (authority == null) {
                return -1;
            }
            SyncHistoryItem item = new SyncHistoryItem();
            item.authorityId = authority.ident;
            item.historyId = mNextHistoryId++;
            if (mNextHistoryId < 0) mNextHistoryId = 0;
            item.eventTime = now;
            item.source = source;
            item.event = EVENT_START;
            mSyncHistory.add(0, item);
            while (mSyncHistory.size() > MAX_HISTORY) {
                mSyncHistory.remove(mSyncHistory.size()-1);
            }
            id = item.historyId;
            if (Log.isLoggable(TAG, Log.VERBOSE)) Log.v(TAG, "returning historyId " + id);
        }

        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_STATUS);
        return id;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.608 -0500", hash_original_method = "50B7DBCE95202763C50A27A5F5D2A2F4", hash_generated_method = "AFD55BD6A2062E75D3EE05901F8526B5")
    
public void stopSyncEvent(long historyId, long elapsedTime, String resultMessage,
            long downstreamActivity, long upstreamActivity) {
        synchronized (mAuthorities) {
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "stopSyncEvent: historyId=" + historyId);
            }
            SyncHistoryItem item = null;
            int i = mSyncHistory.size();
            while (i > 0) {
                i--;
                item = mSyncHistory.get(i);
                if (item.historyId == historyId) {
                    break;
                }
                item = null;
            }

            if (item == null) {
                Log.w(TAG, "stopSyncEvent: no history for id " + historyId);
                return;
            }

            item.elapsedTime = elapsedTime;
            item.event = EVENT_STOP;
            item.mesg = resultMessage;
            item.downstreamActivity = downstreamActivity;
            item.upstreamActivity = upstreamActivity;

            SyncStatusInfo status = getOrCreateSyncStatusLocked(item.authorityId);

            status.numSyncs++;
            status.totalElapsedTime += elapsedTime;
            switch (item.source) {
                case SOURCE_LOCAL:
                    status.numSourceLocal++;
                    break;
                case SOURCE_POLL:
                    status.numSourcePoll++;
                    break;
                case SOURCE_USER:
                    status.numSourceUser++;
                    break;
                case SOURCE_SERVER:
                    status.numSourceServer++;
                    break;
                case SOURCE_PERIODIC:
                    status.numSourcePeriodic++;
                    break;
            }

            boolean writeStatisticsNow = false;
            int day = getCurrentDayLocked();
            if (mDayStats[0] == null) {
                mDayStats[0] = new DayStats(day);
            } else if (day != mDayStats[0].day) {
                System.arraycopy(mDayStats, 0, mDayStats, 1, mDayStats.length-1);
                mDayStats[0] = new DayStats(day);
                writeStatisticsNow = true;
            } else if (mDayStats[0] == null) {
            }
            final DayStats ds = mDayStats[0];

            final long lastSyncTime = (item.eventTime + elapsedTime);
            boolean writeStatusNow = false;
            if (MESG_SUCCESS.equals(resultMessage)) {
                // - if successful, update the successful columns
                if (status.lastSuccessTime == 0 || status.lastFailureTime != 0) {
                    writeStatusNow = true;
                }
                status.lastSuccessTime = lastSyncTime;
                status.lastSuccessSource = item.source;
                status.lastFailureTime = 0;
                status.lastFailureSource = -1;
                status.lastFailureMesg = null;
                status.initialFailureTime = 0;
                ds.successCount++;
                ds.successTime += elapsedTime;
            } else if (!MESG_CANCELED.equals(resultMessage)) {
                if (status.lastFailureTime == 0) {
                    writeStatusNow = true;
                }
                status.lastFailureTime = lastSyncTime;
                status.lastFailureSource = item.source;
                status.lastFailureMesg = resultMessage;
                if (status.initialFailureTime == 0) {
                    status.initialFailureTime = lastSyncTime;
                }
                ds.failureCount++;
                ds.failureTime += elapsedTime;
            }

            if (writeStatusNow) {
                writeStatusLocked();
            } else if (!hasMessages(MSG_WRITE_STATUS)) {
                sendMessageDelayed(obtainMessage(MSG_WRITE_STATUS),
                        WRITE_STATUS_DELAY);
            }
            if (writeStatisticsNow) {
                writeStatisticsLocked();
            } else if (!hasMessages(MSG_WRITE_STATISTICS)) {
                sendMessageDelayed(obtainMessage(MSG_WRITE_STATISTICS),
                        WRITE_STATISTICS_DELAY);
            }
        }

        reportChange(ContentResolver.SYNC_OBSERVER_TYPE_STATUS);
    }

    /**
     * Return a list of the currently active syncs. Note that the returned items are the
     * real, live active sync objects, so be careful what you do with it.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.611 -0500", hash_original_method = "F85BE50FB140D59BBA80C586F09539D3", hash_generated_method = "F2548D7197FEEF9A84FF78F65E098B45")
    
public List<SyncInfo> getCurrentSyncs() {
        synchronized (mAuthorities) {
            return new ArrayList<SyncInfo>(mCurrentSyncs);
        }
    }

    /**
     * Return an array of the current sync status for all authorities.  Note
     * that the objects inside the array are the real, live status objects,
     * so be careful what you do with them.
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.613 -0500", hash_original_method = "337F005F5350F3BD5177B0B27AD2E944", hash_generated_method = "88CFC6F2E81E7B9C1E45342372C662D3")
    
public ArrayList<SyncStatusInfo> getSyncStatus() {
        synchronized (mAuthorities) {
            final int N = mSyncStatus.size();
            ArrayList<SyncStatusInfo> ops = new ArrayList<SyncStatusInfo>(N);
            for (int i=0; i<N; i++) {
                ops.add(mSyncStatus.valueAt(i));
            }
            return ops;
        }
    }

    /**
     * Return an array of the current authorities. Note
     * that the objects inside the array are the real, live objects,
     * so be careful what you do with them.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.615 -0500", hash_original_method = "AEA28BD7AFFA3D47C607E69E1C170D48", hash_generated_method = "C2CAC7104824FF45BABF5B70D20F844E")
    
public ArrayList<AuthorityInfo> getAuthorities() {
        synchronized (mAuthorities) {
            final int N = mAuthorities.size();
            ArrayList<AuthorityInfo> infos = new ArrayList<AuthorityInfo>(N);
            for (int i=0; i<N; i++) {
                infos.add(mAuthorities.valueAt(i));
            }
            return infos;
        }
    }

    /**
     * Returns the status that matches the authority and account.
     *
     * @param account the account we want to check
     * @param authority the authority whose row should be selected
     * @return the SyncStatusInfo for the authority
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.619 -0500", hash_original_method = "0CFE1C56DFD3FFD9F777D7B0D6FDA886", hash_generated_method = "77B7619662E68BA266AF802F0AE051FF")
    
public SyncStatusInfo getStatusByAccountAndAuthority(Account account, String authority) {
        if (account == null || authority == null) {
          throw new IllegalArgumentException();
        }
        synchronized (mAuthorities) {
            final int N = mSyncStatus.size();
            for (int i=0; i<N; i++) {
                SyncStatusInfo cur = mSyncStatus.valueAt(i);
                AuthorityInfo ainfo = mAuthorities.get(cur.authorityId);

                if (ainfo != null && ainfo.authority.equals(authority) &&
                    account.equals(ainfo.account)) {
                  return cur;
                }
            }
            return null;
        }
    }

    /**
     * Return true if the pending status is true of any matching authorities.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.622 -0500", hash_original_method = "11629709D08EF9D9A0440D25565E7A8F", hash_generated_method = "E9E7776CE49A2046106334E2D3801A34")
    
public boolean isSyncPending(Account account, String authority) {
        synchronized (mAuthorities) {
            final int N = mSyncStatus.size();
            for (int i=0; i<N; i++) {
                SyncStatusInfo cur = mSyncStatus.valueAt(i);
                AuthorityInfo ainfo = mAuthorities.get(cur.authorityId);
                if (ainfo == null) {
                    continue;
                }
                if (account != null && !ainfo.account.equals(account)) {
                    continue;
                }
                if (ainfo.authority.equals(authority) && cur.pending) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * Return an array of the current sync status for all authorities.  Note
     * that the objects inside the array are the real, live status objects,
     * so be careful what you do with them.
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.624 -0500", hash_original_method = "B27CDDFFB9BAFF7BFEA0365E872FDD46", hash_generated_method = "14A2BEDBE7661F28E8CCD09FFF9DAD5C")
    
public ArrayList<SyncHistoryItem> getSyncHistory() {
        synchronized (mAuthorities) {
            final int N = mSyncHistory.size();
            ArrayList<SyncHistoryItem> items = new ArrayList<SyncHistoryItem>(N);
            for (int i=0; i<N; i++) {
                items.add(mSyncHistory.get(i));
            }
            return items;
        }
    }

    /**
     * Return an array of the current per-day statistics.  Note
     * that the objects inside the array are the real, live status objects,
     * so be careful what you do with them.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.626 -0500", hash_original_method = "3EC13B6BE37070366668DCFEFC381135", hash_generated_method = "CBD2287C19F0CC0F02D673F46F106A71")
    
public DayStats[] getDayStatistics() {
        synchronized (mAuthorities) {
            DayStats[] ds = new DayStats[mDayStats.length];
            System.arraycopy(mDayStats, 0, ds, 0, ds.length);
            return ds;
        }
    }

    /**
     * If sync is failing for any of the provider/accounts then determine the time at which it
     * started failing and return the earliest time over all the provider/accounts. If none are
     * failing then return 0.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.629 -0500", hash_original_method = "CFA8C7FA80DDF752958B19CD5427CAD8", hash_generated_method = "A99D41DEB66EC5CDC04120FD01869B01")
    
public long getInitialSyncFailureTime() {
        synchronized (mAuthorities) {
            if (!mMasterSyncAutomatically) {
                return 0;
            }

            long oldest = 0;
            int i = mSyncStatus.size();
            while (i > 0) {
                i--;
                SyncStatusInfo stats = mSyncStatus.valueAt(i);
                AuthorityInfo authority = mAuthorities.get(stats.authorityId);
                if (authority != null && authority.enabled) {
                    if (oldest == 0 || stats.initialFailureTime < oldest) {
                        oldest = stats.initialFailureTime;
                    }
                }
            }

            return oldest;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.631 -0500", hash_original_method = "C1CC7B80E3CCED2D49B24E4AC052D091", hash_generated_method = "8F4F536A41C19D545E934C6521C8A47C")
    
private int getCurrentDayLocked() {
        mCal.setTimeInMillis(System.currentTimeMillis());
        final int dayOfYear = mCal.get(Calendar.DAY_OF_YEAR);
        if (mYear != mCal.get(Calendar.YEAR)) {
            mYear = mCal.get(Calendar.YEAR);
            mCal.clear();
            mCal.set(Calendar.YEAR, mYear);
            mYearInDays = (int)(mCal.getTimeInMillis()/86400000);
        }
        return dayOfYear + mYearInDays;
    }

    /**
     * Retrieve an authority, returning null if one does not exist.
     *
     * @param accountName The name of the account for the authority.
     * @param authorityName The name of the authority itself.
     * @param tag If non-null, this will be used in a log message if the
     * requested authority does not exist.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.633 -0500", hash_original_method = "6C953B58E1758760E6819A681B8F6E8F", hash_generated_method = "357085A12863ABDA05F936423D1C1389")
    
private AuthorityInfo getAuthorityLocked(Account accountName, String authorityName,
            String tag) {
        AccountInfo account = mAccounts.get(accountName);
        if (account == null) {
            if (tag != null) {
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, tag + ": unknown account " + accountName);
                }
            }
            return null;
        }
        AuthorityInfo authority = account.authorities.get(authorityName);
        if (authority == null) {
            if (tag != null) {
                if (Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, tag + ": unknown authority " + authorityName);
                }
            }
            return null;
        }

        return authority;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.636 -0500", hash_original_method = "8765A57952C80F1A5760550FE9E929E6", hash_generated_method = "55017B3A2175F1528FC92A24642594C1")
    
private AuthorityInfo getOrCreateAuthorityLocked(Account accountName,
            String authorityName, int ident, boolean doWrite) {
        AccountInfo account = mAccounts.get(accountName);
        if (account == null) {
            account = new AccountInfo(accountName);
            mAccounts.put(accountName, account);
        }
        AuthorityInfo authority = account.authorities.get(authorityName);
        if (authority == null) {
            if (ident < 0) {
                ident = mNextAuthorityId;
                mNextAuthorityId++;
                doWrite = true;
            }
            if (Log.isLoggable(TAG, Log.VERBOSE)) {
                Log.v(TAG, "created a new AuthorityInfo for " + accountName
                    + ", provider " + authorityName);
            }
            authority = new AuthorityInfo(accountName, authorityName, ident);
            account.authorities.put(authorityName, authority);
            mAuthorities.put(ident, authority);
            if (doWrite) {
                writeAccountInfoLocked();
            }
        }

        return authority;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.638 -0500", hash_original_method = "654490315D677BE62FC7AFF81C0D5F85", hash_generated_method = "E2578E2048573AE9E7DF022901DB3F88")
    
private void removeAuthorityLocked(Account account, String authorityName, boolean doWrite) {
        AccountInfo accountInfo = mAccounts.get(account);
        if (accountInfo != null) {
            final AuthorityInfo authorityInfo = accountInfo.authorities.remove(authorityName);
            if (authorityInfo != null) {
                mAuthorities.remove(authorityInfo.ident);
                if (doWrite) {
                    writeAccountInfoLocked();
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.641 -0500", hash_original_method = "8F9F327D2E93831D0CA3DA1F9594BFF4", hash_generated_method = "5C02FED2EDB8E68A9BA2D59AC5999F3F")
    
public SyncStatusInfo getOrCreateSyncStatus(AuthorityInfo authority) {
        synchronized (mAuthorities) {
            return getOrCreateSyncStatusLocked(authority.ident);
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.643 -0500", hash_original_method = "1C22F2C698CD79AA856218BCBCBEF0F7", hash_generated_method = "9E8E2E91A3AAE544AC7871E301FCA278")
    
private SyncStatusInfo getOrCreateSyncStatusLocked(int authorityId) {
        SyncStatusInfo status = mSyncStatus.get(authorityId);
        if (status == null) {
            status = new SyncStatusInfo(authorityId);
            mSyncStatus.put(authorityId, status);
        }
        return status;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.645 -0500", hash_original_method = "EC72A1F81B7D887353DF2FA5F052A597", hash_generated_method = "517CA605FA8AD78AE0678A22A52C6C34")
    
public void writeAllState() {
        synchronized (mAuthorities) {
            // Account info is always written so no need to do it here.

            if (mNumPendingFinished > 0) {
                // Only write these if they are out of date.
                writePendingOperationsLocked();
            }

            // Just always write these...  they are likely out of date.
            writeStatusLocked();
            writeStatisticsLocked();
        }
    }

    /**
     * public for testing
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.647 -0500", hash_original_method = "E278B7FDC712595C2D25226C12B41BCD", hash_generated_method = "0538ACDB60E00F86ADA8439C53BD785B")
    
public void clearAndReadState() {
        synchronized (mAuthorities) {
            mAuthorities.clear();
            mAccounts.clear();
            mPendingOperations.clear();
            mSyncStatus.clear();
            mSyncHistory.clear();

            readAccountInfoLocked();
            readStatusLocked();
            readPendingOperationsLocked();
            readStatisticsLocked();
            readAndDeleteLegacyAccountInfoLocked();
            writeAccountInfoLocked();
            writeStatusLocked();
            writePendingOperationsLocked();
            writeStatisticsLocked();
        }
    }

    /**
     * Read all account information back in to the initial engine state.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.651 -0500", hash_original_method = "9E90C2E17AAFB2A4F084659253144E64", hash_generated_method = "6CB5DB174862C08791AD8619EC651F9B")
    
private void readAccountInfoLocked() {
        int highestAuthorityId = -1;
        FileInputStream fis = null;
        try {
            fis = mAccountInfoFile.openRead();
            if (DEBUG_FILE) Log.v(TAG, "Reading " + mAccountInfoFile.getBaseFile());
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(fis, null);
            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.START_TAG) {
                eventType = parser.next();
            }
            String tagName = parser.getName();
            if ("accounts".equals(tagName)) {
                String listen = parser.getAttributeValue(
                        null, "listen-for-tickles");
                String versionString = parser.getAttributeValue(null, "version");
                int version;
                try {
                    version = (versionString == null) ? 0 : Integer.parseInt(versionString);
                } catch (NumberFormatException e) {
                    version = 0;
                }
                String nextIdString = parser.getAttributeValue(null, "nextAuthorityId");
                try {
                    int id = (nextIdString == null) ? 0 : Integer.parseInt(nextIdString);
                    mNextAuthorityId = Math.max(mNextAuthorityId, id);
                } catch (NumberFormatException e) {
                    // don't care
                }
                mMasterSyncAutomatically = listen == null || Boolean.parseBoolean(listen);
                eventType = parser.next();
                AuthorityInfo authority = null;
                Pair<Bundle, Long> periodicSync = null;
                do {
                    if (eventType == XmlPullParser.START_TAG) {
                        tagName = parser.getName();
                        if (parser.getDepth() == 2) {
                            if ("authority".equals(tagName)) {
                                authority = parseAuthority(parser, version);
                                periodicSync = null;
                                if (authority.ident > highestAuthorityId) {
                                    highestAuthorityId = authority.ident;
                                }
                            }
                        } else if (parser.getDepth() == 3) {
                            if ("periodicSync".equals(tagName) && authority != null) {
                                periodicSync = parsePeriodicSync(parser, authority);
                            }
                        } else if (parser.getDepth() == 4 && periodicSync != null) {
                            if ("extra".equals(tagName)) {
                                parseExtra(parser, periodicSync);
                            }
                        }
                    }
                    eventType = parser.next();
                } while (eventType != XmlPullParser.END_DOCUMENT);
            }
        } catch (XmlPullParserException e) {
            Log.w(TAG, "Error reading accounts", e);
            return;
        } catch (java.io.IOException e) {
            if (fis == null) Log.i(TAG, "No initial accounts");
            else Log.w(TAG, "Error reading accounts", e);
            return;
        } finally {
            mNextAuthorityId = Math.max(highestAuthorityId + 1, mNextAuthorityId);
            if (fis != null) {
                try {
                    fis.close();
                } catch (java.io.IOException e1) {
                }
            }
        }

        maybeMigrateSettingsForRenamedAuthorities();
    }

    /**
     * some authority names have changed. copy over their settings and delete the old ones
     * @return true if a change was made
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.654 -0500", hash_original_method = "1F0CD4338AAE9E719690DF5E0BB493ED", hash_generated_method = "0BBF3A00BAFAA580DEB88F08EE34F6F5")
    
private boolean maybeMigrateSettingsForRenamedAuthorities() {
        boolean writeNeeded = false;

        ArrayList<AuthorityInfo> authoritiesToRemove = new ArrayList<AuthorityInfo>();
        final int N = mAuthorities.size();
        for (int i=0; i<N; i++) {
            AuthorityInfo authority = mAuthorities.valueAt(i);
            // skip this authority if it isn't one of the renamed ones
            final String newAuthorityName = sAuthorityRenames.get(authority.authority);
            if (newAuthorityName == null) {
                continue;
            }

            // remember this authority so we can remove it later. we can't remove it
            // now without messing up this loop iteration
            authoritiesToRemove.add(authority);

            // this authority isn't enabled, no need to copy it to the new authority name since
            // the default is "disabled"
            if (!authority.enabled) {
                continue;
            }

            // if we already have a record of this new authority then don't copy over the settings
            if (getAuthorityLocked(authority.account, newAuthorityName, "cleanup") != null) {
                continue;
            }

            AuthorityInfo newAuthority = getOrCreateAuthorityLocked(authority.account,
                    newAuthorityName, -1 /* ident */, false /* doWrite */);
            newAuthority.enabled = true;
            writeNeeded = true;
        }

        for (AuthorityInfo authorityInfo : authoritiesToRemove) {
            removeAuthorityLocked(authorityInfo.account, authorityInfo.authority,
                    false /* doWrite */);
            writeNeeded = true;
        }

        return writeNeeded;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.658 -0500", hash_original_method = "39CA1CD415012CC0A4B70AAED3727A93", hash_generated_method = "89DB49298EF9F83D398FDE706F26A477")
    
private AuthorityInfo parseAuthority(XmlPullParser parser, int version) {
        AuthorityInfo authority = null;
        int id = -1;
        try {
            id = Integer.parseInt(parser.getAttributeValue(
                    null, "id"));
        } catch (NumberFormatException e) {
            Log.e(TAG, "error parsing the id of the authority", e);
        } catch (NullPointerException e) {
            Log.e(TAG, "the id of the authority is null", e);
        }
        if (id >= 0) {
            String authorityName = parser.getAttributeValue(null, "authority");
            String enabled = parser.getAttributeValue(null, "enabled");
            String syncable = parser.getAttributeValue(null, "syncable");
            String accountName = parser.getAttributeValue(null, "account");
            String accountType = parser.getAttributeValue(null, "type");
            if (accountType == null) {
                accountType = "com.google";
                syncable = "unknown";
            }
            authority = mAuthorities.get(id);
            if (DEBUG_FILE) Log.v(TAG, "Adding authority: account="
                    + accountName + " auth=" + authorityName
                    + " enabled=" + enabled
                    + " syncable=" + syncable);
            if (authority == null) {
                if (DEBUG_FILE) Log.v(TAG, "Creating entry");
                authority = getOrCreateAuthorityLocked(
                        new Account(accountName, accountType), authorityName, id, false);
                // If the version is 0 then we are upgrading from a file format that did not
                // know about periodic syncs. In that case don't clear the list since we
                // want the default, which is a daily periodioc sync.
                // Otherwise clear out this default list since we will populate it later with
                // the periodic sync descriptions that are read from the configuration file.
                if (version > 0) {
                    authority.periodicSyncs.clear();
                }
            }
            if (authority != null) {
                authority.enabled = enabled == null || Boolean.parseBoolean(enabled);
                if ("unknown".equals(syncable)) {
                    authority.syncable = -1;
                } else {
                    authority.syncable =
                            (syncable == null || Boolean.parseBoolean(syncable)) ? 1 : 0;
                }
            } else {
                Log.w(TAG, "Failure adding authority: account="
                        + accountName + " auth=" + authorityName
                        + " enabled=" + enabled
                        + " syncable=" + syncable);
            }
        }

        return authority;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.664 -0500", hash_original_method = "5B7C41C6008D60C9ED6FB4C92797A204", hash_generated_method = "BFAF17CC65ECE479062B29396166B7A9")
    
private Pair<Bundle, Long> parsePeriodicSync(XmlPullParser parser, AuthorityInfo authority) {
        Bundle extras = new Bundle();
        String periodValue = parser.getAttributeValue(null, "period");
        final long period;
        try {
            period = Long.parseLong(periodValue);
        } catch (NumberFormatException e) {
            Log.e(TAG, "error parsing the period of a periodic sync", e);
            return null;
        } catch (NullPointerException e) {
            Log.e(TAG, "the period of a periodic sync is null", e);
            return null;
        }
        final Pair<Bundle, Long> periodicSync = Pair.create(extras, period);
        authority.periodicSyncs.add(periodicSync);

        return periodicSync;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.668 -0500", hash_original_method = "63A9A531A6D6EE37322509C7D60C0471", hash_generated_method = "80D1F953D9D382470BE85168BD28464A")
    
private void parseExtra(XmlPullParser parser, Pair<Bundle, Long> periodicSync) {
        final Bundle extras = periodicSync.first;
        String name = parser.getAttributeValue(null, "name");
        String type = parser.getAttributeValue(null, "type");
        String value1 = parser.getAttributeValue(null, "value1");
        String value2 = parser.getAttributeValue(null, "value2");

        try {
            if ("long".equals(type)) {
                extras.putLong(name, Long.parseLong(value1));
            } else if ("integer".equals(type)) {
                extras.putInt(name, Integer.parseInt(value1));
            } else if ("double".equals(type)) {
                extras.putDouble(name, Double.parseDouble(value1));
            } else if ("float".equals(type)) {
                extras.putFloat(name, Float.parseFloat(value1));
            } else if ("boolean".equals(type)) {
                extras.putBoolean(name, Boolean.parseBoolean(value1));
            } else if ("string".equals(type)) {
                extras.putString(name, value1);
            } else if ("account".equals(type)) {
                extras.putParcelable(name, new Account(value1, value2));
            }
        } catch (NumberFormatException e) {
            Log.e(TAG, "error parsing bundle value", e);
        } catch (NullPointerException e) {
            Log.e(TAG, "error parsing bundle value", e);
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.120 -0400", hash_original_method = "D0303AA7EB859F30BDBC9813BB120707", hash_generated_method = "456AC6D44877321312D3DB7B70E74378")
    private void writeAccountInfoLocked() {
        if(DEBUG_FILE){ }        FileOutputStream fos = null;
        try 
        {
            fos = mAccountInfoFile.startWrite();
            XmlSerializer out = new FastXmlSerializer();
            out.setOutput(fos, "utf-8");
            out.startDocument(null, true);
            out.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            out.startTag(null, "accounts");
            out.attribute(null, "version", Integer.toString(ACCOUNTS_VERSION));
            out.attribute(null, "nextAuthorityId", Integer.toString(mNextAuthorityId));
            if(!mMasterSyncAutomatically)            
            {
                out.attribute(null, "listen-for-tickles", "false");
            } //End block
            final int N = mAuthorities.size();
for(int i=0;i<N;i++)
            {
                AuthorityInfo authority = mAuthorities.valueAt(i);
                out.startTag(null, "authority");
                out.attribute(null, "id", Integer.toString(authority.ident));
                out.attribute(null, "account", authority.account.name);
                out.attribute(null, "type", authority.account.type);
                out.attribute(null, "authority", authority.authority);
                out.attribute(null, "enabled", Boolean.toString(authority.enabled));
                if(authority.syncable < 0)                
                {
                    out.attribute(null, "syncable", "unknown");
                } //End block
                else
                {
                    out.attribute(null, "syncable", Boolean.toString(authority.syncable != 0));
                } //End block
for(Pair<Bundle, Long> periodicSync : authority.periodicSyncs)
                {
                    out.startTag(null, "periodicSync");
                    out.attribute(null, "period", Long.toString(periodicSync.second));
                    final Bundle extras = periodicSync.first;
for(String key : extras.keySet())
                    {
                        out.startTag(null, "extra");
                        out.attribute(null, "name", key);
                        final Object value = extras.get(key);
                        if(value instanceof Long)                        
                        {
                            out.attribute(null, "type", "long");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
                        if(value instanceof Integer)                        
                        {
                            out.attribute(null, "type", "integer");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
                        if(value instanceof Boolean)                        
                        {
                            out.attribute(null, "type", "boolean");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
                        if(value instanceof Float)                        
                        {
                            out.attribute(null, "type", "float");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
                        if(value instanceof Double)                        
                        {
                            out.attribute(null, "type", "double");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
                        if(value instanceof String)                        
                        {
                            out.attribute(null, "type", "string");
                            out.attribute(null, "value1", value.toString());
                        } //End block
                        else
                        if(value instanceof Account)                        
                        {
                            out.attribute(null, "type", "account");
                            out.attribute(null, "value1", ((Account)value).name);
                            out.attribute(null, "value2", ((Account)value).type);
                        } //End block
                        out.endTag(null, "extra");
                    } //End block
                    out.endTag(null, "periodicSync");
                } //End block
                out.endTag(null, "authority");
            } //End block
            out.endTag(null, "accounts");
            out.endDocument();
            mAccountInfoFile.finishWrite(fos);
        } //End block
        catch (java.io.IOException e1)
        {
            if(fos != null)            
            {
                mAccountInfoFile.failWrite(fos);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    /**
     * Load sync engine state from the old syncmanager database, and then
     * erase it.  Note that we don't deal with pending operations, active
     * sync, or history.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.682 -0500", hash_original_method = "96B84444EEB95F8262A1F514B70427CB", hash_generated_method = "33B6AFAC50A132BCF2111D92B0BC9589")
    
private void readAndDeleteLegacyAccountInfoLocked() {
        // Look for old database to initialize from.
        File file = mContext.getDatabasePath("syncmanager.db");
        if (!file.exists()) {
            return;
        }
        String path = file.getPath();
        SQLiteDatabase db = null;
        try {
            db = SQLiteDatabase.openDatabase(path, null,
                    SQLiteDatabase.OPEN_READONLY);
        } catch (SQLiteException e) {
        }

        if (db != null) {
            final boolean hasType = db.getVersion() >= 11;

            // Copy in all of the status information, as well as accounts.
            if (DEBUG_FILE) Log.v(TAG, "Reading legacy sync accounts db");
            SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
            qb.setTables("stats, status");
            HashMap<String,String> map = new HashMap<String,String>();
            map.put("_id", "status._id as _id");
            map.put("account", "stats.account as account");
            if (hasType) {
                map.put("account_type", "stats.account_type as account_type");
            }
            map.put("authority", "stats.authority as authority");
            map.put("totalElapsedTime", "totalElapsedTime");
            map.put("numSyncs", "numSyncs");
            map.put("numSourceLocal", "numSourceLocal");
            map.put("numSourcePoll", "numSourcePoll");
            map.put("numSourceServer", "numSourceServer");
            map.put("numSourceUser", "numSourceUser");
            map.put("lastSuccessSource", "lastSuccessSource");
            map.put("lastSuccessTime", "lastSuccessTime");
            map.put("lastFailureSource", "lastFailureSource");
            map.put("lastFailureTime", "lastFailureTime");
            map.put("lastFailureMesg", "lastFailureMesg");
            map.put("pending", "pending");
            qb.setProjectionMap(map);
            qb.appendWhere("stats._id = status.stats_id");
            Cursor c = qb.query(db, null, null, null, null, null, null);
            while (c.moveToNext()) {
                String accountName = c.getString(c.getColumnIndex("account"));
                String accountType = hasType
                        ? c.getString(c.getColumnIndex("account_type")) : null;
                if (accountType == null) {
                    accountType = "com.google";
                }
                String authorityName = c.getString(c.getColumnIndex("authority"));
                AuthorityInfo authority = this.getOrCreateAuthorityLocked(
                        new Account(accountName, accountType),
                        authorityName, -1, false);
                if (authority != null) {
                    int i = mSyncStatus.size();
                    boolean found = false;
                    SyncStatusInfo st = null;
                    while (i > 0) {
                        i--;
                        st = mSyncStatus.valueAt(i);
                        if (st.authorityId == authority.ident) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        st = new SyncStatusInfo(authority.ident);
                        mSyncStatus.put(authority.ident, st);
                    }
                    st.totalElapsedTime = getLongColumn(c, "totalElapsedTime");
                    st.numSyncs = getIntColumn(c, "numSyncs");
                    st.numSourceLocal = getIntColumn(c, "numSourceLocal");
                    st.numSourcePoll = getIntColumn(c, "numSourcePoll");
                    st.numSourceServer = getIntColumn(c, "numSourceServer");
                    st.numSourceUser = getIntColumn(c, "numSourceUser");
                    st.numSourcePeriodic = 0;
                    st.lastSuccessSource = getIntColumn(c, "lastSuccessSource");
                    st.lastSuccessTime = getLongColumn(c, "lastSuccessTime");
                    st.lastFailureSource = getIntColumn(c, "lastFailureSource");
                    st.lastFailureTime = getLongColumn(c, "lastFailureTime");
                    st.lastFailureMesg = c.getString(c.getColumnIndex("lastFailureMesg"));
                    st.pending = getIntColumn(c, "pending") != 0;
                }
            }

            c.close();

            // Retrieve the settings.
            qb = new SQLiteQueryBuilder();
            qb.setTables("settings");
            c = qb.query(db, null, null, null, null, null, null);
            while (c.moveToNext()) {
                String name = c.getString(c.getColumnIndex("name"));
                String value = c.getString(c.getColumnIndex("value"));
                if (name == null) continue;
                if (name.equals("listen_for_tickles")) {
                    setMasterSyncAutomatically(value == null || Boolean.parseBoolean(value));
                } else if (name.startsWith("sync_provider_")) {
                    String provider = name.substring("sync_provider_".length(),
                            name.length());
                    int i = mAuthorities.size();
                    while (i > 0) {
                        i--;
                        AuthorityInfo authority = mAuthorities.valueAt(i);
                        if (authority.authority.equals(provider)) {
                            authority.enabled = value == null || Boolean.parseBoolean(value);
                            authority.syncable = 1;
                        }
                    }
                }
            }

            c.close();

            db.close();

            (new File(path)).delete();
        }
    }
    static {
        sAuthorityRenames = new HashMap<String, String>();
        sAuthorityRenames.put("contacts", "com.android.contacts");
        sAuthorityRenames.put("calendar", "com.android.calendar");
    }

    /**
     * Read all sync status back in to the initial engine state.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.690 -0500", hash_original_method = "8A0C770C89ACE123AD07688E6EE32DB8", hash_generated_method = "4ADF04B04F03EC8375470461FE2518DE")
    
private void readStatusLocked() {
        if (DEBUG_FILE) Log.v(TAG, "Reading " + mStatusFile.getBaseFile());
        try {
            byte[] data = mStatusFile.readFully();
            Parcel in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            int token;
            while ((token=in.readInt()) != STATUS_FILE_END) {
                if (token == STATUS_FILE_ITEM) {
                    SyncStatusInfo status = new SyncStatusInfo(in);
                    if (mAuthorities.indexOfKey(status.authorityId) >= 0) {
                        status.pending = false;
                        if (DEBUG_FILE) Log.v(TAG, "Adding status for id "
                                + status.authorityId);
                        mSyncStatus.put(status.authorityId, status);
                    }
                } else {
                    // Ooops.
                    Log.w(TAG, "Unknown status token: " + token);
                    break;
                }
            }
        } catch (java.io.IOException e) {
            Log.i(TAG, "No initial status");
        }
    }

    /**
     * Write all sync status to the sync status file.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.692 -0500", hash_original_method = "74BDFC1296AA332718133078DAF25C56", hash_generated_method = "B94282656CAC89533B864BAD327D0DCE")
    
private void writeStatusLocked() {
        if (DEBUG_FILE) Log.v(TAG, "Writing new " + mStatusFile.getBaseFile());

        // The file is being written, so we don't need to have a scheduled
        // write until the next change.
        removeMessages(MSG_WRITE_STATUS);

        FileOutputStream fos = null;
        try {
            fos = mStatusFile.startWrite();
            Parcel out = Parcel.obtain();
            final int N = mSyncStatus.size();
            for (int i=0; i<N; i++) {
                SyncStatusInfo status = mSyncStatus.valueAt(i);
                out.writeInt(STATUS_FILE_ITEM);
                status.writeToParcel(out, 0);
            }
            out.writeInt(STATUS_FILE_END);
            fos.write(out.marshall());
            out.recycle();

            mStatusFile.finishWrite(fos);
        } catch (java.io.IOException e1) {
            Log.w(TAG, "Error writing status", e1);
            if (fos != null) {
                mStatusFile.failWrite(fos);
            }
        }
    }

    /**
     * Read all pending operations back in to the initial engine state.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.697 -0500", hash_original_method = "1231AB171DBB37761A49B7E20056B86A", hash_generated_method = "A09497D8BB6CEB4CDD6BC9CD1E65DB77")
    
private void readPendingOperationsLocked() {
        if (DEBUG_FILE) Log.v(TAG, "Reading " + mPendingFile.getBaseFile());
        try {
            byte[] data = mPendingFile.readFully();
            Parcel in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            final int SIZE = in.dataSize();
            while (in.dataPosition() < SIZE) {
                int version = in.readInt();
                if (version != PENDING_OPERATION_VERSION && version != 1) {
                    Log.w(TAG, "Unknown pending operation version "
                            + version + "; dropping all ops");
                    break;
                }
                int authorityId = in.readInt();
                int syncSource = in.readInt();
                byte[] flatExtras = in.createByteArray();
                boolean expedited;
                if (version == PENDING_OPERATION_VERSION) {
                    expedited = in.readInt() != 0;
                } else {
                    expedited = false;
                }
                AuthorityInfo authority = mAuthorities.get(authorityId);
                if (authority != null) {
                    Bundle extras;
                    if (flatExtras != null) {
                        extras = unflattenBundle(flatExtras);
                    } else {
                        // if we are unable to parse the extras for whatever reason convert this
                        // to a regular sync by creating an empty extras
                        extras = new Bundle();
                    }
                    PendingOperation op = new PendingOperation(
                            authority.account, syncSource,
                            authority.authority, extras, expedited);
                    op.authorityId = authorityId;
                    op.flatExtras = flatExtras;
                    if (DEBUG_FILE) Log.v(TAG, "Adding pending op: account=" + op.account
                            + " auth=" + op.authority
                            + " src=" + op.syncSource
                            + " expedited=" + op.expedited
                            + " extras=" + op.extras);
                    mPendingOperations.add(op);
                }
            }
        } catch (java.io.IOException e) {
            Log.i(TAG, "No initial pending operations");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.700 -0500", hash_original_method = "0152B02FFEBFCD8F723BAE9C7F6EE92A", hash_generated_method = "5F848AC5CB12EF49353FEB6F548FD679")
    
private void writePendingOperationLocked(PendingOperation op, Parcel out) {
        out.writeInt(PENDING_OPERATION_VERSION);
        out.writeInt(op.authorityId);
        out.writeInt(op.syncSource);
        if (op.flatExtras == null && op.extras != null) {
            op.flatExtras = flattenBundle(op.extras);
        }
        out.writeByteArray(op.flatExtras);
        out.writeInt(op.expedited ? 1 : 0);
    }

    /**
     * Write all currently pending ops to the pending ops file.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.703 -0500", hash_original_method = "B08FC5F8DD5CA36D6F4DD131B7753109", hash_generated_method = "4FD7ED5798AFBFF982289ABB3D9B44D3")
    
private void writePendingOperationsLocked() {
        final int N = mPendingOperations.size();
        FileOutputStream fos = null;
        try {
            if (N == 0) {
                if (DEBUG_FILE) Log.v(TAG, "Truncating " + mPendingFile.getBaseFile());
                mPendingFile.truncate();
                return;
            }

            if (DEBUG_FILE) Log.v(TAG, "Writing new " + mPendingFile.getBaseFile());
            fos = mPendingFile.startWrite();

            Parcel out = Parcel.obtain();
            for (int i=0; i<N; i++) {
                PendingOperation op = mPendingOperations.get(i);
                writePendingOperationLocked(op, out);
            }
            fos.write(out.marshall());
            out.recycle();

            mPendingFile.finishWrite(fos);
        } catch (java.io.IOException e1) {
            Log.w(TAG, "Error writing pending operations", e1);
            if (fos != null) {
                mPendingFile.failWrite(fos);
            }
        }
    }

    /**
     * Append the given operation to the pending ops file; if unable to,
     * write all pending ops.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.706 -0500", hash_original_method = "3B9D2CCD4E7B33665C76FD82482A168C", hash_generated_method = "77C9E7EAB50AAC2444DC02FE5474559C")
    
private void appendPendingOperationLocked(PendingOperation op) {
        if (DEBUG_FILE) Log.v(TAG, "Appending to " + mPendingFile.getBaseFile());
        FileOutputStream fos = null;
        try {
            fos = mPendingFile.openAppend();
        } catch (java.io.IOException e) {
            if (DEBUG_FILE) Log.v(TAG, "Failed append; writing full file");
            writePendingOperationsLocked();
            return;
        }

        try {
            Parcel out = Parcel.obtain();
            writePendingOperationLocked(op, out);
            fos.write(out.marshall());
            out.recycle();
        } catch (java.io.IOException e1) {
            Log.w(TAG, "Error writing pending operations", e1);
        } finally {
            try {
                fos.close();
            } catch (java.io.IOException e2) {
            }
        }
    }

    /**
     * Read all sync statistics back in to the initial engine state.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.721 -0500", hash_original_method = "EF23341A4D9A5255D7511F96FA9CF980", hash_generated_method = "40E5EDC4616C5EA6D3E6611FA1DAB53E")
    
private void readStatisticsLocked() {
        try {
            byte[] data = mStatisticsFile.readFully();
            Parcel in = Parcel.obtain();
            in.unmarshall(data, 0, data.length);
            in.setDataPosition(0);
            int token;
            int index = 0;
            while ((token=in.readInt()) != STATISTICS_FILE_END) {
                if (token == STATISTICS_FILE_ITEM
                        || token == STATISTICS_FILE_ITEM_OLD) {
                    int day = in.readInt();
                    if (token == STATISTICS_FILE_ITEM_OLD) {
                        day = day - 2009 + 14245;  // Magic!
                    }
                    DayStats ds = new DayStats(day);
                    ds.successCount = in.readInt();
                    ds.successTime = in.readLong();
                    ds.failureCount = in.readInt();
                    ds.failureTime = in.readLong();
                    if (index < mDayStats.length) {
                        mDayStats[index] = ds;
                        index++;
                    }
                } else {
                    // Ooops.
                    Log.w(TAG, "Unknown stats token: " + token);
                    break;
                }
            }
        } catch (java.io.IOException e) {
            Log.i(TAG, "No initial statistics");
        }
    }

    /**
     * Write all sync statistics to the sync status file.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:43.724 -0500", hash_original_method = "FBD3A634F75EF390904BDDFD24CE73C8", hash_generated_method = "5B6D7B9372740F7BA2CAF352A032C7FC")
    
private void writeStatisticsLocked() {
        if (DEBUG_FILE) Log.v(TAG, "Writing new " + mStatisticsFile.getBaseFile());

        // The file is being written, so we don't need to have a scheduled
        // write until the next change.
        removeMessages(MSG_WRITE_STATISTICS);

        FileOutputStream fos = null;
        try {
            fos = mStatisticsFile.startWrite();
            Parcel out = Parcel.obtain();
            final int N = mDayStats.length;
            for (int i=0; i<N; i++) {
                DayStats ds = mDayStats[i];
                if (ds == null) {
                    break;
                }
                out.writeInt(STATISTICS_FILE_ITEM);
                out.writeInt(ds.day);
                out.writeInt(ds.successCount);
                out.writeLong(ds.successTime);
                out.writeInt(ds.failureCount);
                out.writeLong(ds.failureTime);
            }
            out.writeInt(STATISTICS_FILE_END);
            fos.write(out.marshall());
            out.recycle();

            mStatisticsFile.finishWrite(fos);
        } catch (java.io.IOException e1) {
            Log.w(TAG, "Error writing stats", e1);
            if (fos != null) {
                mStatisticsFile.failWrite(fos);
            }
        }
    }
}

