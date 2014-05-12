package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Xml;

import com.android.internal.content.PackageMonitor;

public class ActivityChooserModel extends DataSetObservable {

    /**
     * Gets the data model backed by the contents of the provided file with historical data.
     * Note that only one data model is backed by a given file, thus multiple calls with
     * the same file name will return the same model instance. If no such instance is present
     * it is created.
     * <p>
     * <strong>Note:</strong> To use the default historical data file clients should explicitly
     * pass as file name {@link #DEFAULT_HISTORY_FILE_NAME}. If no persistence of the choice
     * history is desired clients should pass <code>null</code> for the file name. In such
     * case a new model is returned for each invocation.
     * </p>
     *
     * <p>
     * <strong>Always use difference historical data files for semantically different actions.
     * For example, sharing is different from importing.</strong>
     * </p>
     *
     * @param context Context for loading resources.
     * @param historyFileName File name with choice history, <code>null</code>
     *        if the model should not be backed by a file. In this case the activities
     *        will be ordered only by data from the current session.
     *
     * @return The model.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.074 -0500", hash_original_method = "0D01D180802F00CC7597C044D40D73D9", hash_generated_method = "7ED2145194E106168FE2AECBB4D19FC3")
    
public static ActivityChooserModel get(Context context, String historyFileName) {
        synchronized (sRegistryLock) {
            ActivityChooserModel dataModel = sDataModelRegistry.get(historyFileName);
            if (dataModel == null) {
                dataModel = new ActivityChooserModel(context, historyFileName);
                sDataModelRegistry.put(historyFileName, dataModel);
            }
            dataModel.readHistoricalData();
            return dataModel;
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.004 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.007 -0500", hash_original_field = "E037CBE0BE3FBA8A7961920B44AD080F", hash_generated_field = "C0E6428FC538C3E98CD4F3F3FD104AD3")

    private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.009 -0500", hash_original_field = "E20593E22FC31D904E7E5B3A71EE8318", hash_generated_field = "2F78BC6BF3EA40EEBFAAF4062888B202")

    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.012 -0500", hash_original_field = "5F967947C66B27389D126D99E03528B1", hash_generated_field = "B57E7DC30CE2B7036D338B99DE1C8F4A")

    private static final String TAG_HISTORICAL_RECORD = "historical-record";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.014 -0500", hash_original_field = "56AFAE4CDEC4680C8609FCB3EDBC717D", hash_generated_field = "4F997BDD322ABDE394E143C88BE19902")

    private static final String ATTRIBUTE_ACTIVITY = "activity";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.017 -0500", hash_original_field = "40ADE1807AC7E1E341C80E5BC4D9CE29", hash_generated_field = "4657BA7339C2DB58947DE9CCAAA8BCAF")

    private static final String ATTRIBUTE_TIME = "time";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.020 -0500", hash_original_field = "77BBD3343B372696409C101C8F9C60BF", hash_generated_field = "8399470D08376E2A59EAC9C79DB79A9E")

    private static final String ATTRIBUTE_WEIGHT = "weight";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.022 -0500", hash_original_field = "8B8F9583173AB764EC9F9A025F38F1E5", hash_generated_field = "C17F091D6E1676968D87EC382F2A60E4")

    public static final String DEFAULT_HISTORY_FILE_NAME =
        "activity_choser_model_history.xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.025 -0500", hash_original_field = "815CFEE32450A538972A8F43519898CD", hash_generated_field = "51D1ECB43E515D53A9B4473F163B06AD")

    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.027 -0500", hash_original_field = "2AA93006CF4F51E2D3A52871199C92F7", hash_generated_field = "450784023A27CD5EC5CEF077D5E372FC")

    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.030 -0500", hash_original_field = "3296A6C22BF2803ACD276A7DC849A5FF", hash_generated_field = "48D4985B801C29FF4FB9AF6C46ABE846")

    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.033 -0500", hash_original_field = "B25DE5464F3B2FB0F1678D1D64A7BC0C", hash_generated_field = "5BDD81AF45C2360A5D0488EF180F0B0E")

    private static final String HISTORY_FILE_EXTENSION = ".xml";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.035 -0500", hash_original_field = "79922DB043510C9A19B5CA2602F88574", hash_generated_field = "19F556E730E88DC545CC4ADD400592D6")

    private static final int INVALID_INDEX = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.037 -0500", hash_original_field = "2A85441306B6DA10925576EDB0829DE9", hash_generated_field = "922B32A26FF0AAB23FEB7772C78F88BB")

    private static final Object sRegistryLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.040 -0500", hash_original_field = "D12002D66861D7C4CD7306DAE98689EB", hash_generated_field = "BB4344C9185B0C58F3786BE4083DEBFE")

    private static final Map<String, ActivityChooserModel> sDataModelRegistry =
        new HashMap<String, ActivityChooserModel>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.042 -0500", hash_original_field = "C1EC34416CA5919EC9DC169918854311", hash_generated_field = "6392F8242B4A9D3DC6E2F079ACDCEA46")

    private final Object mInstanceLock = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.045 -0500", hash_original_field = "851D03B9AF2BF2C54308D4FA4876FCCB", hash_generated_field = "A383B170605041BAE9B92E5ABD19A2C0")

    private final List<ActivityResolveInfo> mActivites = new ArrayList<ActivityResolveInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.047 -0500", hash_original_field = "3AC8F7346660D77AD24249C0102BEBB2", hash_generated_field = "CD99824E96948584D748917073F44E2A")

    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList<HistoricalRecord>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.049 -0500", hash_original_field = "89F8153148C52753FEADBC127391782E", hash_generated_field = "DD3DAD2906BF0D253EBD93D8930F9D13")

    private final PackageMonitor mPackageMonitor = new DataModelPackageMonitor();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.052 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.054 -0500", hash_original_field = "460D23C5FE834DF5E670AC904F537CE8", hash_generated_field = "357B9AB2EB9473252BE7FAC7D1E15CF3")

    private  String mHistoryFileName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.056 -0500", hash_original_field = "1811495D939DB843870F6315E04555CC", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.058 -0500", hash_original_field = "CDFE9562459CF682CD5791AE8590AE22", hash_generated_field = "972A273635E03BCAAB877E2B3CA36A43")

    private ActivitySorter mActivitySorter = new DefaultSorter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.061 -0500", hash_original_field = "9E260D706DA037E28705F134F95A2D17", hash_generated_field = "EDEDBBB721F293D506B0D4333D55AA26")

    private int mHistoryMaxSize = DEFAULT_HISTORY_MAX_LENGTH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.063 -0500", hash_original_field = "8A47E82C5B6544A76C54534A1159111E", hash_generated_field = "2CA5D5746328370D849F634661FCCB3C")

    private boolean mCanReadHistoricalData = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.065 -0500", hash_original_field = "AFD63AFE6577D9D6820D1BD49F835A0F", hash_generated_field = "A0038BE823A55BDB17A2EB5E4620EF9F")

    private boolean mReadShareHistoryCalled = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.067 -0500", hash_original_field = "B9DA8B44212AE5FF74D5FDCB48DCA951", hash_generated_field = "4EFA8B1A885AF19B054DFCDA0E6D3607")

    private boolean mHistoricalRecordsChanged = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.069 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "2C33E5889A8CDA732A297DBE7101DB89")

    private final Handler mHandler = new Handler();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.071 -0500", hash_original_field = "B556ED2FBA0B414787FE1A89D6F15079", hash_generated_field = "84BCBE36C424794EB40EAAE6D9BDAEAE")

    private OnChooseActivityListener mActivityChoserModelPolicy;

    /**
     * Creates a new instance.
     *
     * @param context Context for loading resources.
     * @param historyFileName The history XML file.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.076 -0500", hash_original_method = "807F9125D161268ACCBF934F5F44F95B", hash_generated_method = "4CC55F0D537F3401E12EDEB6D58A8114")
    
private ActivityChooserModel(Context context, String historyFileName) {
        mContext = context.getApplicationContext();
        if (!TextUtils.isEmpty(historyFileName)
                && !historyFileName.endsWith(HISTORY_FILE_EXTENSION)) {
            mHistoryFileName = historyFileName + HISTORY_FILE_EXTENSION;
        } else {
            mHistoryFileName = historyFileName;
        }
        mPackageMonitor.register(mContext, true);
    }

    /**
     * Sets an intent for which to choose a activity.
     * <p>
     * <strong>Note:</strong> Clients must set only semantically similar
     * intents for each data model.
     * <p>
     *
     * @param intent The intent.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.079 -0500", hash_original_method = "E9FF7BF71184D5918A5528B39387C05B", hash_generated_method = "91C5D66A53589765471AC9BE9C5BFCA3")
    
public void setIntent(Intent intent) {
        synchronized (mInstanceLock) {
            if (mIntent == intent) {
                return;
            }
            mIntent = intent;
            loadActivitiesLocked();
        }
    }

    /**
     * Gets the intent for which a activity is being chosen.
     *
     * @return The intent.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.081 -0500", hash_original_method = "27A17A1D87D77EAA50C2FB6DFA94EC7A", hash_generated_method = "932C480F63E4BDC434E715C77D01BFED")
    
public Intent getIntent() {
        synchronized (mInstanceLock) {
            return mIntent;
        }
    }

    /**
     * Gets the number of activities that can handle the intent.
     *
     * @return The activity count.
     *
     * @see #setIntent(Intent)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.084 -0500", hash_original_method = "D90428775A0762F0AD6636514EC58022", hash_generated_method = "C8E98811FE0D02D590564D80187E3373")
    
public int getActivityCount() {
        synchronized (mInstanceLock) {
            return mActivites.size();
        }
    }

    /**
     * Gets an activity at a given index.
     *
     * @return The activity.
     *
     * @see ActivityResolveInfo
     * @see #setIntent(Intent)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.086 -0500", hash_original_method = "032146065CC1BA2D79ECD4CB63DFEC7F", hash_generated_method = "D66592B3152CE0A00F052A67217D4190")
    
public ResolveInfo getActivity(int index) {
        synchronized (mInstanceLock) {
            return mActivites.get(index).resolveInfo;
        }
    }

    /**
     * Gets the index of a the given activity.
     *
     * @param activity The activity index.
     *
     * @return The index if found, -1 otherwise.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.088 -0500", hash_original_method = "1C6D65F5A71D312AA7F7882C56EDED0B", hash_generated_method = "B36B5CE7AFCADB83D2A6AD0AD42303BC")
    
public int getActivityIndex(ResolveInfo activity) {
        List<ActivityResolveInfo> activities = mActivites;
        final int activityCount = activities.size();
        for (int i = 0; i < activityCount; i++) {
            ActivityResolveInfo currentActivity = activities.get(i);
            if (currentActivity.resolveInfo == activity) {
                return i;
            }
        }
        return INVALID_INDEX;
    }

    /**
     * Chooses a activity to handle the current intent. This will result in
     * adding a historical record for that action and construct intent with
     * its component name set such that it can be immediately started by the
     * client.
     * <p>
     * <strong>Note:</strong> By calling this method the client guarantees
     * that the returned intent will be started. This intent is returned to
     * the client solely to let additional customization before the start.
     * </p>
     *
     * @return An {@link Intent} for launching the activity or null if the
     *         policy has consumed the intent.
     *
     * @see HistoricalRecord
     * @see OnChooseActivityListener
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.091 -0500", hash_original_method = "2E1571A22B1C1279902BA9C2D35CCDAC", hash_generated_method = "F99960AA35438CC484296F5D7EE4AB95")
    
public Intent chooseActivity(int index) {
        ActivityResolveInfo chosenActivity = mActivites.get(index);

        ComponentName chosenName = new ComponentName(
                chosenActivity.resolveInfo.activityInfo.packageName,
                chosenActivity.resolveInfo.activityInfo.name);

        Intent choiceIntent = new Intent(mIntent);
        choiceIntent.setComponent(chosenName);

        if (mActivityChoserModelPolicy != null) {
            // Do not allow the policy to change the intent.
            Intent choiceIntentCopy = new Intent(choiceIntent);
            final boolean handled = mActivityChoserModelPolicy.onChooseActivity(this,
                    choiceIntentCopy);
            if (handled) {
                return null;
            }
        }

        HistoricalRecord historicalRecord = new HistoricalRecord(chosenName,
                System.currentTimeMillis(), DEFAULT_HISTORICAL_RECORD_WEIGHT);
        addHisoricalRecord(historicalRecord);

        return choiceIntent;
    }
    
    public final static class HistoricalRecord {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.129 -0500", hash_original_field = "349BDCF162FD3E438C6A758EBB153707", hash_generated_field = "E9F78AFB95D47915FCC3FF74E33CC6C3")

        public  ComponentName activity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.132 -0500", hash_original_field = "FB68C26D0BB5DD6577F61578B9AE66A8", hash_generated_field = "5A44367B7C554CE37EA61A01D45FAC73")

        public  long time;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.135 -0500", hash_original_field = "ED32AE0265E055EF357B36A061633A65", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public  float weight;

        /**
         * Creates a new instance.
         *
         * @param activityName The activity component name flattened to string.
         * @param time The time the activity was chosen.
         * @param weight The weight of the record.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.138 -0500", hash_original_method = "1C86724BE7B708067898B3EC6CC9E920", hash_generated_method = "931B707B3369EE5B34B031F4EEEEFDE2")
        
public HistoricalRecord(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
        }

        /**
         * Creates a new instance.
         *
         * @param activityName The activity name.
         * @param time The time the activity was chosen.
         * @param weight The weight of the record.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.141 -0500", hash_original_method = "15F3A03D01E02908C99E8CDDD520EB93", hash_generated_method = "B117B1C7AD39008C7B37FC7FFAB23423")
        
public HistoricalRecord(ComponentName activityName, long time, float weight) {
            this.activity = activityName;
            this.time = time;
            this.weight = weight;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.143 -0500", hash_original_method = "4E1A48E49166529A0B7FC03866764063", hash_generated_method = "352078E7B322AA289CCF6775E22D1ADB")
        
@Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((activity == null) ? 0 : activity.hashCode());
            result = prime * result + (int) (time ^ (time >>> 32));
            result = prime * result + Float.floatToIntBits(weight);
            return result;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.146 -0500", hash_original_method = "B85F0FF6FF50850EA2189DB29FD09D21", hash_generated_method = "925EC01A17EFCF4C15E96773246D4FC3")
        
@Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            HistoricalRecord other = (HistoricalRecord) obj;
            if (activity == null) {
                if (other.activity != null) {
                    return false;
                }
            } else if (!activity.equals(other.activity)) {
                return false;
            }
            if (time != other.time) {
                return false;
            }
            if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight)) {
                return false;
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.148 -0500", hash_original_method = "DE8206875FA4E924E296C5ACB6D7F3F2", hash_generated_method = "9BB09691C87ABA3B5C765EB27953B0B3")
        
@Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(activity);
            builder.append("; time:").append(time);
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
            return builder.toString();
        }
        
    }
    
    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.154 -0500", hash_original_field = "388E10A296BB39658E74C632FC6834F9", hash_generated_field = "42ACA7D028AD018D3FE2BFC3E32F6A75")

        public  ResolveInfo resolveInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.156 -0500", hash_original_field = "ED32AE0265E055EF357B36A061633A65", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public float weight;

        /**
         * Creates a new instance.
         *
         * @param resolveInfo activity {@link ResolveInfo}.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.159 -0500", hash_original_method = "FE163077B7530186AE819FA48AA47F8E", hash_generated_method = "88816EE6F3022CF85C492F00D6ACDA7E")
        
public ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.161 -0500", hash_original_method = "F192571EE56F5C4051616CB9861F74E4", hash_generated_method = "13AB84BC74D8FAD5F7035FEF73FC4060")
        
@Override
        public int hashCode() {
            return 31 + Float.floatToIntBits(weight);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.164 -0500", hash_original_method = "FF799F5AAE6D6CF88DAF4502D583A290", hash_generated_method = "22E769B1C84475BBCF7353D36CFABAAF")
        
@Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            ActivityResolveInfo other = (ActivityResolveInfo) obj;
            if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight)) {
                return false;
            }
            return true;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.166 -0500", hash_original_method = "05EB01A51A0727988F01FD1C25038E23", hash_generated_method = "D7A9D7785F9F6C86346A0B0F5FE3E9EF")
        
public int compareTo(ActivityResolveInfo another) {
             return  Float.floatToIntBits(another.weight) - Float.floatToIntBits(weight);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.168 -0500", hash_original_method = "6B7079774B733597AE380820B7605540", hash_generated_method = "FCB473823D3E65A9CED590AB9A5E1E65")
        
@Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
            return builder.toString();
        }
        
    }
    
    private final class DefaultSorter implements ActivitySorter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.173 -0500", hash_original_field = "291DD62C8381C760FAE106954F174503", hash_generated_field = "80DD4E6EDFEAE82BDC0A595B5F72F371")

        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.176 -0500", hash_original_field = "4E416A09671288BBCB5BA49D39FD40A0", hash_generated_field = "36A2609728A36E5BA82D7C988AE5AE60")

        private final Map<String, ActivityResolveInfo> mPackageNameToActivityMap =
            new HashMap<String, ActivityResolveInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.169 -0400", hash_original_method = "4BF496988E00827DD1484620E43167BF", hash_generated_method = "4BF496988E00827DD1484620E43167BF")
        public DefaultSorter ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.180 -0500", hash_original_method = "1983622E810CF2F16D5FB85B8E79AAA7", hash_generated_method = "756C3AA0FD463B9CB639C740513E9A8A")
        
public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords) {
            Map<String, ActivityResolveInfo> packageNameToActivityMap =
                mPackageNameToActivityMap;
            packageNameToActivityMap.clear();

            final int activityCount = activities.size();
            for (int i = 0; i < activityCount; i++) {
                ActivityResolveInfo activity = activities.get(i);
                activity.weight = 0.0f;
                String packageName = activity.resolveInfo.activityInfo.packageName;
                packageNameToActivityMap.put(packageName, activity);
            }

            final int lastShareIndex = historicalRecords.size() - 1;
            float nextRecordWeight = 1;
            for (int i = lastShareIndex; i >= 0; i--) {
                HistoricalRecord historicalRecord = historicalRecords.get(i);
                String packageName = historicalRecord.activity.getPackageName();
                ActivityResolveInfo activity = packageNameToActivityMap.get(packageName);
                if (activity != null) {
                    activity.weight += historicalRecord.weight * nextRecordWeight;
                    nextRecordWeight = nextRecordWeight * WEIGHT_DECAY_COEFFICIENT;
                }
            }

            Collections.sort(activities);

            if (DEBUG) {
                for (int i = 0; i < activityCount; i++) {
                    Log.i(LOG_TAG, "Sorted: " + activities.get(i));
                }
            }
        }
    }
    
    private final class HistoryLoader implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.170 -0400", hash_original_method = "0F6CF60457783C48329031B15DA96823", hash_generated_method = "0F6CF60457783C48329031B15DA96823")
        public HistoryLoader ()
        {
            //Synthesized constructor
        }

       @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.189 -0500", hash_original_method = "C7992FBC3712621E8BB422FE384E294B", hash_generated_method = "F36BC393F0C978E8C08BA80782762A25")
        
public void run() {
            FileInputStream fis = null;
            try {
                fis = mContext.openFileInput(mHistoryFileName);
            } catch (FileNotFoundException fnfe) {
                if (DEBUG) {
                    Log.i(LOG_TAG, "Could not open historical records file: " + mHistoryFileName);
                }
                return;
            }
            try {
                XmlPullParser parser = Xml.newPullParser();
                parser.setInput(fis, null);

                int type = XmlPullParser.START_DOCUMENT;
                while (type != XmlPullParser.END_DOCUMENT && type != XmlPullParser.START_TAG) {
                    type = parser.next();
                }

                if (!TAG_HISTORICAL_RECORDS.equals(parser.getName())) {
                    throw new XmlPullParserException("Share records file does not start with "
                            + TAG_HISTORICAL_RECORDS + " tag.");
                }

                List<HistoricalRecord> readRecords = new ArrayList<HistoricalRecord>();

                while (true) {
                    type = parser.next();
                    if (type == XmlPullParser.END_DOCUMENT) {
                        break;
                    }
                    if (type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT) {
                        continue;
                    }
                    String nodeName = parser.getName();
                    if (!TAG_HISTORICAL_RECORD.equals(nodeName)) {
                        throw new XmlPullParserException("Share records file not well-formed.");
                    }

                    String activity = parser.getAttributeValue(null, ATTRIBUTE_ACTIVITY);
                    final long time =
                        Long.parseLong(parser.getAttributeValue(null, ATTRIBUTE_TIME));
                    final float weight =
                        Float.parseFloat(parser.getAttributeValue(null, ATTRIBUTE_WEIGHT));

                    HistoricalRecord readRecord = new HistoricalRecord(activity, time,
                            weight);
                    readRecords.add(readRecord);

                    if (DEBUG) {
                        Log.i(LOG_TAG, "Read " + readRecord.toString());
                    }
                }

                if (DEBUG) {
                    Log.i(LOG_TAG, "Read " + readRecords.size() + " historical records.");
                }

                synchronized (mInstanceLock) {
                    Set<HistoricalRecord> uniqueShareRecords =
                        new LinkedHashSet<HistoricalRecord>(readRecords);

                    // Make sure no duplicates. Example: Read a file with
                    // one record, add one record, persist the two records,
                    // add a record, read the persisted records - the
                    // read two records should not be added again.
                    List<HistoricalRecord> historicalRecords = mHistoricalRecords;
                    final int historicalRecordsCount = historicalRecords.size();
                    for (int i = historicalRecordsCount - 1; i >= 0; i--) {
                        HistoricalRecord historicalRecord = historicalRecords.get(i);
                        uniqueShareRecords.add(historicalRecord);
                    }

                    if (historicalRecords.size() == uniqueShareRecords.size()) {
                        return;
                    }

                    // Make sure the oldest records go to the end.
                    historicalRecords.clear();
                    historicalRecords.addAll(uniqueShareRecords);

                    mHistoricalRecordsChanged = true;

                    // Do this on the client thread since the client may be on the UI
                    // thread, wait for data changes which happen during sorting, and
                    // perform UI modification based on the data change.
                    mHandler.post(new Runnable() {
                        public void run() {
                            pruneExcessiveHistoricalRecordsLocked();
                            sortActivities();
                        }
                    });
                }
            } catch (XmlPullParserException xppe) {
                Log.e(LOG_TAG, "Error reading historical recrod file: " + mHistoryFileName, xppe);
            } catch (IOException ioe) {
                Log.e(LOG_TAG, "Error reading historical recrod file: " + mHistoryFileName, ioe);
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ioe) {
                        /* ignore */
                    }
                }
            }
        }
        
    }
    
    private final class HistoryPersister implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.171 -0400", hash_original_method = "F652F13A8701B98B9D8C3619B90FF892", hash_generated_method = "F652F13A8701B98B9D8C3619B90FF892")
        public HistoryPersister ()
        {
            //Synthesized constructor
        }

        @DSSpec(DSCat.THREADING)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.197 -0500", hash_original_method = "56491CDA5DB122242C8DDE4A7A87359C", hash_generated_method = "0E634B72781F99144EF2F4B3330B50E6")
        
public void run() {
            FileOutputStream fos = null;
            List<HistoricalRecord> records = null;

            synchronized (mInstanceLock) {
                records = new ArrayList<HistoricalRecord>(mHistoricalRecords);
            }

            try {
                fos = mContext.openFileOutput(mHistoryFileName, Context.MODE_PRIVATE);
            } catch (FileNotFoundException fnfe) {
                Log.e(LOG_TAG, "Error writing historical recrod file: " + mHistoryFileName, fnfe);
                return;
            }

            XmlSerializer serializer = Xml.newSerializer();

            try {
                serializer.setOutput(fos, null);
                serializer.startDocument("UTF-8", true);
                serializer.startTag(null, TAG_HISTORICAL_RECORDS);

                final int recordCount = records.size();
                for (int i = 0; i < recordCount; i++) {
                    HistoricalRecord record = records.remove(0);
                    serializer.startTag(null, TAG_HISTORICAL_RECORD);
                    serializer.attribute(null, ATTRIBUTE_ACTIVITY, record.activity.flattenToString());
                    serializer.attribute(null, ATTRIBUTE_TIME, String.valueOf(record.time));
                    serializer.attribute(null, ATTRIBUTE_WEIGHT, String.valueOf(record.weight));
                    serializer.endTag(null, TAG_HISTORICAL_RECORD);
                    if (DEBUG) {
                        Log.i(LOG_TAG, "Wrote " + record.toString());
                    }
                }

                serializer.endTag(null, TAG_HISTORICAL_RECORDS);
                serializer.endDocument();

                if (DEBUG) {
                    Log.i(LOG_TAG, "Wrote " + recordCount + " historical records.");
                }
            } catch (IllegalArgumentException iae) {
                Log.e(LOG_TAG, "Error writing historical recrod file: " + mHistoryFileName, iae);
            } catch (IllegalStateException ise) {
                Log.e(LOG_TAG, "Error writing historical recrod file: " + mHistoryFileName, ise);
            } catch (IOException ioe) {
                Log.e(LOG_TAG, "Error writing historical recrod file: " + mHistoryFileName, ioe);
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        /* ignore */
                    }
                }
            }
        }
        
    }
    
    private final class DataModelPackageMonitor extends PackageMonitor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.172 -0400", hash_original_method = "7270678089AB03BAD6BBDC9C3DB17F70", hash_generated_method = "7270678089AB03BAD6BBDC9C3DB17F70")
        public DataModelPackageMonitor ()
        {
            //Synthesized constructor
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.203 -0500", hash_original_method = "C89F5C92B68E48D5DAFC93C690A3926A", hash_generated_method = "F1568DF8BFCBB0E57801D31AD8C49B5E")
        
@Override
        public void onPackageAdded(String packageName, int uid) {
            synchronized (mInstanceLock) {
                loadActivitiesLocked();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.206 -0500", hash_original_method = "E08DC591D228402C0DBF164DF68C0AF4", hash_generated_method = "00871590302F7329D553334B8F7A09FA")
        
@Override
        public void onPackageAppeared(String packageName, int reason) {
            synchronized (mInstanceLock) {
                loadActivitiesLocked();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.208 -0500", hash_original_method = "A7BE115B10A66075A04B7082DDA7D411", hash_generated_method = "9E8C6BD9FB134B0FF0C485D19E17173E")
        
@Override
        public void onPackageRemoved(String packageName, int uid) {
            synchronized (mInstanceLock) {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.210 -0500", hash_original_method = "31BBEB936625AC985495016944655B18", hash_generated_method = "8B5056331EE59F3F708E54C259458A25")
        
@Override
        public void onPackageDisappeared(String packageName, int reason) {
            synchronized (mInstanceLock) {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            }
        }
        
    }
    
    public interface ActivityChooserModelClient {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void setActivityChooserModel(ActivityChooserModel dataModel);
    }
    
    public interface ActivitySorter {
        
        public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords);
    }
    
    public interface OnChooseActivityListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public boolean onChooseActivity(ActivityChooserModel host, Intent intent);
    }

    /**
     * Sets the listener for choosing an activity.
     *
     * @param listener The listener.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.093 -0500", hash_original_method = "56E3863DC4DFDE24EBD2068470DB48E1", hash_generated_method = "945308B1F8D38F595083588F81B721CD")
    
public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        mActivityChoserModelPolicy = listener;
    }

    /**
     * Gets the default activity, The default activity is defined as the one
     * with highest rank i.e. the first one in the list of activities that can
     * handle the intent.
     *
     * @return The default activity, <code>null</code> id not activities.
     *
     * @see #getActivity(int)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.095 -0500", hash_original_method = "8C412D794940DE98F4AAE841092A3BC7", hash_generated_method = "859CC40CECCD9B28B10704F18902B672")
    
public ResolveInfo getDefaultActivity() {
        synchronized (mInstanceLock) {
            if (!mActivites.isEmpty()) {
                return mActivites.get(0).resolveInfo;
            }
        }
        return null;
    }

    /**
     * Sets the default activity. The default activity is set by adding a
     * historical record with weight high enough that this activity will
     * become the highest ranked. Such a strategy guarantees that the default
     * will eventually change if not used. Also the weight of the record for
     * setting a default is inflated with a constant amount to guarantee that
     * it will stay as default for awhile.
     *
     * @param index The index of the activity to set as default.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.098 -0500", hash_original_method = "6293689B582FC8E5AF147BEE230A1B37", hash_generated_method = "E2FB95F92E3F33CB38D9AFC1C9D3C591")
    
public void setDefaultActivity(int index) {
        ActivityResolveInfo newDefaultActivity = mActivites.get(index);
        ActivityResolveInfo oldDefaultActivity = mActivites.get(0);

        final float weight;
        if (oldDefaultActivity != null) {
            // Add a record with weight enough to boost the chosen at the top.
            weight = oldDefaultActivity.weight - newDefaultActivity.weight
                + DEFAULT_ACTIVITY_INFLATION;
        } else {
            weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
        }

        ComponentName defaultName = new ComponentName(
                newDefaultActivity.resolveInfo.activityInfo.packageName,
                newDefaultActivity.resolveInfo.activityInfo.name);
        HistoricalRecord historicalRecord = new HistoricalRecord(defaultName,
                System.currentTimeMillis(), weight);
        addHisoricalRecord(historicalRecord);
    }

    /**
     * Reads the history data from the backing file if the latter
     * was provided. Calling this method more than once before a call
     * to {@link #persistHistoricalData()} has been made has no effect.
     * <p>
     * <strong>Note:</strong> Historical data is read asynchronously and
     *       as soon as the reading is completed any registered
     *       {@link DataSetObserver}s will be notified. Also no historical
     *       data is read until this method is invoked.
     * <p>
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.100 -0500", hash_original_method = "79A1B7D3C52D92BAB878ED8275782ED6", hash_generated_method = "FBF069AAA9C160930BF6F2545425DB0D")
    
private void readHistoricalData() {
        synchronized (mInstanceLock) {
            if (!mCanReadHistoricalData || !mHistoricalRecordsChanged) {
                return;
            }
            mCanReadHistoricalData = false;
            mReadShareHistoryCalled = true;
            if (!TextUtils.isEmpty(mHistoryFileName)) {
                AsyncTask.SERIAL_EXECUTOR.execute(new HistoryLoader());
            }
        }
    }

    /**
     * Persists the history data to the backing file if the latter
     * was provided. Calling this method before a call to {@link #readHistoricalData()}
     * throws an exception. Calling this method more than one without choosing an
     * activity has not effect.
     *
     * @throws IllegalStateException If this method is called before a call to
     *         {@link #readHistoricalData()}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.102 -0500", hash_original_method = "50EE1C88911FEE4E5E828FE89316C1B7", hash_generated_method = "F2A2234770B767080FFE4C421AD30B9D")
    
private void persistHistoricalData() {
        synchronized (mInstanceLock) {
            if (!mReadShareHistoryCalled) {
                throw new IllegalStateException("No preceding call to #readHistoricalData");
            }
            if (!mHistoricalRecordsChanged) {
                return;
            }
            mHistoricalRecordsChanged = false;
            mCanReadHistoricalData = true;
            if (!TextUtils.isEmpty(mHistoryFileName)) {
                AsyncTask.SERIAL_EXECUTOR.execute(new HistoryPersister());
            }
        }
    }

    /**
     * Sets the sorter for ordering activities based on historical data and an intent.
     *
     * @param activitySorter The sorter.
     *
     * @see ActivitySorter
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.104 -0500", hash_original_method = "4FD548D8FB7638BF40234ABBB5D78544", hash_generated_method = "DD80FCF01AE7E0BA9A1D8A695062C69A")
    
public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized (mInstanceLock) {
            if (mActivitySorter == activitySorter) {
                return;
            }
            mActivitySorter = activitySorter;
            sortActivities();
        }
    }

    /**
     * Sorts the activities based on history and an intent. If
     * a sorter is not specified this a default implementation is used.
     *
     * @see #setActivitySorter(ActivitySorter)
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.108 -0500", hash_original_method = "B440CA3B13B34DB5E9312802F4C1443D", hash_generated_method = "343228E589EF52FEFBDD6415F0B1CDAE")
    
private void sortActivities() {
        synchronized (mInstanceLock) {
            if (mActivitySorter != null && !mActivites.isEmpty()) {
                mActivitySorter.sort(mIntent, mActivites,
                        Collections.unmodifiableList(mHistoricalRecords));
                notifyChanged();
            }
        }
    }

    /**
     * Sets the maximal size of the historical data. Defaults to
     * {@link #DEFAULT_HISTORY_MAX_LENGTH}
     * <p>
     *   <strong>Note:</strong> Setting this property will immediately
     *   enforce the specified max history size by dropping enough old
     *   historical records to enforce the desired size. Thus, any
     *   records that exceed the history size will be discarded and
     *   irreversibly lost.
     * </p>
     *
     * @param historyMaxSize The max history size.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.110 -0500", hash_original_method = "1F530ED27C984DBDEEC1EB526F5DD126", hash_generated_method = "C2D50153FAE17B99702BDC7B8D6D63A2")
    
public void setHistoryMaxSize(int historyMaxSize) {
        synchronized (mInstanceLock) {
            if (mHistoryMaxSize == historyMaxSize) {
                return;
            }
            mHistoryMaxSize = historyMaxSize;
            pruneExcessiveHistoricalRecordsLocked();
            sortActivities();
        }
    }

    /**
     * Gets the history max size.
     *
     * @return The history max size.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.112 -0500", hash_original_method = "EBCBD4C754CE0391425067ED25453667", hash_generated_method = "2801A2704E59069A32759C53A4F30CA7")
    
public int getHistoryMaxSize() {
        synchronized (mInstanceLock) {
            return mHistoryMaxSize;
        }
    }

    /**
     * Gets the history size.
     *
     * @return The history size.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.114 -0500", hash_original_method = "9F4BBC1AE7ECE6B5427CA6E0430F86F9", hash_generated_method = "D4A939CE607C80DAD95FC7EE090209EA")
    
public int getHistorySize() {
        synchronized (mInstanceLock) {
            return mHistoricalRecords.size();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.117 -0500", hash_original_method = "37F72BEA9084083CB35C7BD83368023D", hash_generated_method = "248FD8D7CA66D4A764B53D560B63E87E")
    
@Override
    protected void finalize() throws Throwable {
        super.finalize();
        mPackageMonitor.unregister();
    }

    /**
     * Adds a historical record.
     *
     * @param historicalRecord The record to add.
     * @return True if the record was added.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.119 -0500", hash_original_method = "50B8FA4A00A0FC54414B26FDB0055015", hash_generated_method = "1F1AD402AF9EF6252BAF181BAA9D537D")
    
private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        synchronized (mInstanceLock) {
            final boolean added = mHistoricalRecords.add(historicalRecord);
            if (added) {
                mHistoricalRecordsChanged = true;
                pruneExcessiveHistoricalRecordsLocked();
                persistHistoricalData();
                sortActivities();
            }
            return added;
        }
    }

    /**
     * Prunes older excessive records to guarantee {@link #mHistoryMaxSize}.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.121 -0500", hash_original_method = "84DEA752877B716573664E1E2DB7F950", hash_generated_method = "87E0749EC6EB8C064C1EC8153137CC1C")
    
private void pruneExcessiveHistoricalRecordsLocked() {
        List<HistoricalRecord> choiceRecords = mHistoricalRecords;
        final int pruneCount = choiceRecords.size() - mHistoryMaxSize;
        if (pruneCount <= 0) {
            return;
        }
        mHistoricalRecordsChanged = true;
        for (int i = 0; i < pruneCount; i++) {
            HistoricalRecord prunedRecord = choiceRecords.remove(0);
            if (DEBUG) {
                Log.i(LOG_TAG, "Pruned: " + prunedRecord);
            }
        }
    }

    /**
     * Loads the activities.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.124 -0500", hash_original_method = "CE097995E3DDE01957F3BEF111DCC08A", hash_generated_method = "B58F04823BB23908BF298601986A7658")
    
private void loadActivitiesLocked() {
        mActivites.clear();
        if (mIntent != null) {
            List<ResolveInfo> resolveInfos =
                mContext.getPackageManager().queryIntentActivities(mIntent, 0);
            final int resolveInfoCount = resolveInfos.size();
            for (int i = 0; i < resolveInfoCount; i++) {
                ResolveInfo resolveInfo = resolveInfos.get(i);
                mActivites.add(new ActivityResolveInfo(resolveInfo));
            }
            sortActivities();
        } else {
            notifyChanged();
        }
    }

    /**
     * Prunes historical records for a package that goes away.
     *
     * @param packageName The name of the package that goes away.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:31:32.126 -0500", hash_original_method = "A58F8162E2D66FE48738B2459230A97A", hash_generated_method = "44AA757C179E2890376F71A67063914D")
    
private void pruneHistoricalRecordsForPackageLocked(String packageName) {
        boolean recordsRemoved = false;

        List<HistoricalRecord> historicalRecords = mHistoricalRecords;
        for (int i = 0; i < historicalRecords.size(); i++) {
            HistoricalRecord historicalRecord = historicalRecords.get(i);
            String recordPackageName = historicalRecord.activity.getPackageName();
            if (recordPackageName.equals(packageName)) {
                historicalRecords.remove(historicalRecord);
                recordsRemoved = true;
            }
        }

        if (recordsRemoved) {
            mHistoricalRecordsChanged = true;
            sortActivities();
        }
    }
}

