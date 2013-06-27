package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.AsyncTask;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import com.android.internal.content.PackageMonitor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;
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

public class ActivityChooserModel extends DataSetObservable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "4C000E064E4AAC53A002F734A3803AFE", hash_generated_field = "57CA5461546F8A6E4F119E4442D8A0BC")

    private Object mInstanceLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "BDD11A174105185D4DFC52160E3514BE", hash_generated_field = "958E7C726C1E797CBFF5ABEBDA0C7F0B")

    private List<ActivityResolveInfo> mActivites = new ArrayList<ActivityResolveInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "A45D92F0F1E7DD7537AB0337C633B496", hash_generated_field = "711091A8B3A3AE74CB39D74091A1FE95")

    private List<HistoricalRecord> mHistoricalRecords = new ArrayList<HistoricalRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "C20064CA31FAD1327132178E6648B402", hash_generated_field = "22019B493B955DECD87BD244788E6576")

    private PackageMonitor mPackageMonitor = new DataModelPackageMonitor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "0AC95AC99D05B1B82A91751B7AF9D262", hash_generated_field = "357B9AB2EB9473252BE7FAC7D1E15CF3")

    private String mHistoryFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "AB35EBBBAD6B54BD08B6B257BBB364A2", hash_generated_field = "972A273635E03BCAAB877E2B3CA36A43")

    private ActivitySorter mActivitySorter = new DefaultSorter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "009B5E594BE56F87B3DDDC247536245A", hash_generated_field = "EDEDBBB721F293D506B0D4333D55AA26")

    private int mHistoryMaxSize = DEFAULT_HISTORY_MAX_LENGTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "5D5149323D264891E5B84C86B8D5566D", hash_generated_field = "2CA5D5746328370D849F634661FCCB3C")

    private boolean mCanReadHistoricalData = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "16353D6A786D24930B9B107BE61F2C9C", hash_generated_field = "A0038BE823A55BDB17A2EB5E4620EF9F")

    private boolean mReadShareHistoryCalled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "2EA85A36CC27F7C4832E5A8C4EBC1736", hash_generated_field = "4EFA8B1A885AF19B054DFCDA0E6D3607")

    private boolean mHistoricalRecordsChanged = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.303 -0400", hash_original_field = "669155EA4A74A2A42AAC5F61C77CAF5E", hash_generated_field = "84BCBE36C424794EB40EAAE6D9BDAEAE")

    private OnChooseActivityListener mActivityChoserModelPolicy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.375 -0400", hash_original_method = "807F9125D161268ACCBF934F5F44F95B", hash_generated_method = "6AFC4B982D91CF915B7098FBF9DEAF98")
    private  ActivityChooserModel(Context context, String historyFileName) {
        mContext = context.getApplicationContext();
        {
            boolean varAAE3DD8441840AD5E419F9A88A281AD8_682752678 = (!TextUtils.isEmpty(historyFileName)
                && !historyFileName.endsWith(HISTORY_FILE_EXTENSION));
            {
                mHistoryFileName = historyFileName + HISTORY_FILE_EXTENSION;
            } //End block
            {
                mHistoryFileName = historyFileName;
            } //End block
        } //End collapsed parenthetic
        mPackageMonitor.register(mContext, true);
        // ---------- Original Method ----------
        //mContext = context.getApplicationContext();
        //if (!TextUtils.isEmpty(historyFileName)
                //&& !historyFileName.endsWith(HISTORY_FILE_EXTENSION)) {
            //mHistoryFileName = historyFileName + HISTORY_FILE_EXTENSION;
        //} else {
            //mHistoryFileName = historyFileName;
        //}
        //mPackageMonitor.register(mContext, true);
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.375 -0400", hash_original_method = "E9FF7BF71184D5918A5528B39387C05B", hash_generated_method = "0EBAA750D81BBC07F15435DF8D3CFF9F")
    public void setIntent(Intent intent) {
        {
            mIntent = intent;
            loadActivitiesLocked();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (mIntent == intent) {
                //return;
            //}
            //mIntent = intent;
            //loadActivitiesLocked();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.376 -0400", hash_original_method = "27A17A1D87D77EAA50C2FB6DFA94EC7A", hash_generated_method = "7C37DBCC424E2AA1E92F6CD03271BAFF")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1216165838 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1216165838 = mIntent;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1216165838.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1216165838;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mIntent;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.376 -0400", hash_original_method = "D90428775A0762F0AD6636514EC58022", hash_generated_method = "261A61B570F465736FBE7D490DFCEBFE")
    public int getActivityCount() {
        {
            int var4413C4888B8E5E0960ECCEDD33A46240_1979882847 = (mActivites.size());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143085963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_143085963;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mActivites.size();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.381 -0400", hash_original_method = "032146065CC1BA2D79ECD4CB63DFEC7F", hash_generated_method = "A395F13701FB4033538E4EC0E26FB66D")
    public ResolveInfo getActivity(int index) {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1748735050 = null; //Variable for return #1
        {
            varB4EAC82CA7396A68D541C85D26508E83_1748735050 = mActivites.get(index).resolveInfo;
        } //End block
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1748735050.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1748735050;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mActivites.get(index).resolveInfo;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.389 -0400", hash_original_method = "1C6D65F5A71D312AA7F7882C56EDED0B", hash_generated_method = "2E86F58D3D63FCDD5BA3209ADABFE648")
    public int getActivityIndex(ResolveInfo activity) {
        List<ActivityResolveInfo> activities;
        activities = mActivites;
        int activityCount;
        activityCount = activities.size();
        {
            int i;
            i = 0;
            {
                ActivityResolveInfo currentActivity;
                currentActivity = activities.get(i);
            } //End block
        } //End collapsed parenthetic
        addTaint(activity.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889120468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1889120468;
        // ---------- Original Method ----------
        //List<ActivityResolveInfo> activities = mActivites;
        //final int activityCount = activities.size();
        //for (int i = 0; i < activityCount; i++) {
            //ActivityResolveInfo currentActivity = activities.get(i);
            //if (currentActivity.resolveInfo == activity) {
                //return i;
            //}
        //}
        //return INVALID_INDEX;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.390 -0400", hash_original_method = "2E1571A22B1C1279902BA9C2D35CCDAC", hash_generated_method = "74BBFE510BF51E4E55CFFD1E66FD8E54")
    public Intent chooseActivity(int index) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_1988551938 = null; //Variable for return #1
        Intent varB4EAC82CA7396A68D541C85D26508E83_1029687997 = null; //Variable for return #2
        ActivityResolveInfo chosenActivity;
        chosenActivity = mActivites.get(index);
        ComponentName chosenName;
        chosenName = new ComponentName(
                chosenActivity.resolveInfo.activityInfo.packageName,
                chosenActivity.resolveInfo.activityInfo.name);
        Intent choiceIntent;
        choiceIntent = new Intent(mIntent);
        choiceIntent.setComponent(chosenName);
        {
            Intent choiceIntentCopy;
            choiceIntentCopy = new Intent(choiceIntent);
            boolean handled;
            handled = mActivityChoserModelPolicy.onChooseActivity(this,
                    choiceIntentCopy);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1988551938 = null;
            } //End block
        } //End block
        HistoricalRecord historicalRecord;
        historicalRecord = new HistoricalRecord(chosenName,
                System.currentTimeMillis(), DEFAULT_HISTORICAL_RECORD_WEIGHT);
        addHisoricalRecord(historicalRecord);
        varB4EAC82CA7396A68D541C85D26508E83_1029687997 = choiceIntent;
        addTaint(index);
        Intent varA7E53CE21691AB073D9660D615818899_747145848; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_747145848 = varB4EAC82CA7396A68D541C85D26508E83_1988551938;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_747145848 = varB4EAC82CA7396A68D541C85D26508E83_1029687997;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_747145848.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_747145848;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.390 -0400", hash_original_method = "56E3863DC4DFDE24EBD2068470DB48E1", hash_generated_method = "502DB08B7514528D4C4579AC10A6BA23")
    public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        mActivityChoserModelPolicy = listener;
        // ---------- Original Method ----------
        //mActivityChoserModelPolicy = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.391 -0400", hash_original_method = "8C412D794940DE98F4AAE841092A3BC7", hash_generated_method = "FE9F58B1E1B1A1D23EDB2877D253F88F")
    public ResolveInfo getDefaultActivity() {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1869642995 = null; //Variable for return #1
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_1279895596 = null; //Variable for return #2
        {
            {
                boolean varF4409FAE14740E362411403D55FB8813_2059543445 = (!mActivites.isEmpty());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1869642995 = mActivites.get(0).resolveInfo;
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1279895596 = null;
        ResolveInfo varA7E53CE21691AB073D9660D615818899_1124876373; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1124876373 = varB4EAC82CA7396A68D541C85D26508E83_1869642995;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1124876373 = varB4EAC82CA7396A68D541C85D26508E83_1279895596;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1124876373.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1124876373;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (!mActivites.isEmpty()) {
                //return mActivites.get(0).resolveInfo;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.401 -0400", hash_original_method = "6293689B582FC8E5AF147BEE230A1B37", hash_generated_method = "8A6BF9CA40A844DB267902D3B8E0F259")
    public void setDefaultActivity(int index) {
        ActivityResolveInfo newDefaultActivity;
        newDefaultActivity = mActivites.get(index);
        ActivityResolveInfo oldDefaultActivity;
        oldDefaultActivity = mActivites.get(0);
        float weight;
        {
            weight = oldDefaultActivity.weight - newDefaultActivity.weight
                + DEFAULT_ACTIVITY_INFLATION;
        } //End block
        {
            weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
        } //End block
        ComponentName defaultName;
        defaultName = new ComponentName(
                newDefaultActivity.resolveInfo.activityInfo.packageName,
                newDefaultActivity.resolveInfo.activityInfo.name);
        HistoricalRecord historicalRecord;
        historicalRecord = new HistoricalRecord(defaultName,
                System.currentTimeMillis(), weight);
        addHisoricalRecord(historicalRecord);
        addTaint(index);
        // ---------- Original Method ----------
        //ActivityResolveInfo newDefaultActivity = mActivites.get(index);
        //ActivityResolveInfo oldDefaultActivity = mActivites.get(0);
        //final float weight;
        //if (oldDefaultActivity != null) {
            //weight = oldDefaultActivity.weight - newDefaultActivity.weight
                //+ DEFAULT_ACTIVITY_INFLATION;
        //} else {
            //weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
        //}
        //ComponentName defaultName = new ComponentName(
                //newDefaultActivity.resolveInfo.activityInfo.packageName,
                //newDefaultActivity.resolveInfo.activityInfo.name);
        //HistoricalRecord historicalRecord = new HistoricalRecord(defaultName,
                //System.currentTimeMillis(), weight);
        //addHisoricalRecord(historicalRecord);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.403 -0400", hash_original_method = "79A1B7D3C52D92BAB878ED8275782ED6", hash_generated_method = "7A6EAB06CAD29FBA023FB687D503BDC8")
    private void readHistoricalData() {
        {
            mCanReadHistoricalData = false;
            mReadShareHistoryCalled = true;
            {
                boolean var5804576A691D9F5270256606BAE1902D_1773314817 = (!TextUtils.isEmpty(mHistoryFileName));
                {
                    AsyncTask.SERIAL_EXECUTOR.execute(new HistoryLoader());
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (!mCanReadHistoricalData || !mHistoricalRecordsChanged) {
                //return;
            //}
            //mCanReadHistoricalData = false;
            //mReadShareHistoryCalled = true;
            //if (!TextUtils.isEmpty(mHistoryFileName)) {
                //AsyncTask.SERIAL_EXECUTOR.execute(new HistoryLoader());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.403 -0400", hash_original_method = "50EE1C88911FEE4E5E828FE89316C1B7", hash_generated_method = "40083879A21553ACD5A24F6A48F7C770")
    private void persistHistoricalData() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No preceding call to #readHistoricalData");
            } //End block
            mHistoricalRecordsChanged = false;
            mCanReadHistoricalData = true;
            {
                boolean var5804576A691D9F5270256606BAE1902D_1758402457 = (!TextUtils.isEmpty(mHistoryFileName));
                {
                    AsyncTask.SERIAL_EXECUTOR.execute(new HistoryPersister());
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (!mReadShareHistoryCalled) {
                //throw new IllegalStateException("No preceding call to #readHistoricalData");
            //}
            //if (!mHistoricalRecordsChanged) {
                //return;
            //}
            //mHistoricalRecordsChanged = false;
            //mCanReadHistoricalData = true;
            //if (!TextUtils.isEmpty(mHistoryFileName)) {
                //AsyncTask.SERIAL_EXECUTOR.execute(new HistoryPersister());
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.404 -0400", hash_original_method = "4FD548D8FB7638BF40234ABBB5D78544", hash_generated_method = "984A0D2F5FF617C13FFADE71CD64A8B3")
    public void setActivitySorter(ActivitySorter activitySorter) {
        {
            mActivitySorter = activitySorter;
            sortActivities();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (mActivitySorter == activitySorter) {
                //return;
            //}
            //mActivitySorter = activitySorter;
            //sortActivities();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.404 -0400", hash_original_method = "B440CA3B13B34DB5E9312802F4C1443D", hash_generated_method = "6C3E9F928483B2D2F8489546DAF7ACB8")
    private void sortActivities() {
        {
            {
                boolean varB5E7D1783EA2374EC2C1EE44024C2179_1576419700 = (mActivitySorter != null && !mActivites.isEmpty());
                {
                    mActivitySorter.sort(mIntent, mActivites,
                        Collections.unmodifiableList(mHistoricalRecords));
                    notifyChanged();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (mActivitySorter != null && !mActivites.isEmpty()) {
                //mActivitySorter.sort(mIntent, mActivites,
                        //Collections.unmodifiableList(mHistoricalRecords));
                //notifyChanged();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.412 -0400", hash_original_method = "1F530ED27C984DBDEEC1EB526F5DD126", hash_generated_method = "56AB4F0711BC913DA0F690575C1A5B20")
    public void setHistoryMaxSize(int historyMaxSize) {
        {
            mHistoryMaxSize = historyMaxSize;
            pruneExcessiveHistoricalRecordsLocked();
            sortActivities();
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (mHistoryMaxSize == historyMaxSize) {
                //return;
            //}
            //mHistoryMaxSize = historyMaxSize;
            //pruneExcessiveHistoricalRecordsLocked();
            //sortActivities();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.412 -0400", hash_original_method = "EBCBD4C754CE0391425067ED25453667", hash_generated_method = "53759795EA199A6EC34704F8A6C5AA25")
    public int getHistoryMaxSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1046979628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1046979628;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mHistoryMaxSize;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.413 -0400", hash_original_method = "9F4BBC1AE7ECE6B5427CA6E0430F86F9", hash_generated_method = "76F7FCF42C5A63BE4290FE471A33AEA1")
    public int getHistorySize() {
        {
            int varE74BD067CCB63FDD155B3322AFBF873C_318818509 = (mHistoricalRecords.size());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648251198 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1648251198;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mHistoricalRecords.size();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.417 -0400", hash_original_method = "37F72BEA9084083CB35C7BD83368023D", hash_generated_method = "C5E6738DAFC973D5C650FCF6D89CF2D3")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        mPackageMonitor.unregister();
        // ---------- Original Method ----------
        //super.finalize();
        //mPackageMonitor.unregister();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.424 -0400", hash_original_method = "50B8FA4A00A0FC54414B26FDB0055015", hash_generated_method = "96EE18E01AADAB5CDA9884342BCF1F60")
    private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        {
            boolean added;
            added = mHistoricalRecords.add(historicalRecord);
            {
                mHistoricalRecordsChanged = true;
                pruneExcessiveHistoricalRecordsLocked();
                persistHistoricalData();
                sortActivities();
            } //End block
        } //End block
        addTaint(historicalRecord.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_52710819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_52710819;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //final boolean added = mHistoricalRecords.add(historicalRecord);
            //if (added) {
                //mHistoricalRecordsChanged = true;
                //pruneExcessiveHistoricalRecordsLocked();
                //persistHistoricalData();
                //sortActivities();
            //}
            //return added;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.424 -0400", hash_original_method = "84DEA752877B716573664E1E2DB7F950", hash_generated_method = "F80C6F2FC1CB767DC08F546E9B4FEA6B")
    private void pruneExcessiveHistoricalRecordsLocked() {
        List<HistoricalRecord> choiceRecords;
        choiceRecords = mHistoricalRecords;
        int pruneCount;
        pruneCount = choiceRecords.size() - mHistoryMaxSize;
        mHistoricalRecordsChanged = true;
        {
            int i;
            i = 0;
            {
                HistoricalRecord prunedRecord;
                prunedRecord = choiceRecords.remove(0);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //List<HistoricalRecord> choiceRecords = mHistoricalRecords;
        //final int pruneCount = choiceRecords.size() - mHistoryMaxSize;
        //if (pruneCount <= 0) {
            //return;
        //}
        //mHistoricalRecordsChanged = true;
        //for (int i = 0; i < pruneCount; i++) {
            //HistoricalRecord prunedRecord = choiceRecords.remove(0);
            //if (DEBUG) {
                //Log.i(LOG_TAG, "Pruned: " + prunedRecord);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.425 -0400", hash_original_method = "CE097995E3DDE01957F3BEF111DCC08A", hash_generated_method = "595D52F91D04F609730629C277154070")
    private void loadActivitiesLocked() {
        mActivites.clear();
        {
            List<ResolveInfo> resolveInfos;
            resolveInfos = mContext.getPackageManager().queryIntentActivities(mIntent, 0);
            int resolveInfoCount;
            resolveInfoCount = resolveInfos.size();
            {
                int i;
                i = 0;
                {
                    ResolveInfo resolveInfo;
                    resolveInfo = resolveInfos.get(i);
                    mActivites.add(new ActivityResolveInfo(resolveInfo));
                } //End block
            } //End collapsed parenthetic
            sortActivities();
        } //End block
        {
            notifyChanged();
        } //End block
        // ---------- Original Method ----------
        //mActivites.clear();
        //if (mIntent != null) {
            //List<ResolveInfo> resolveInfos =
                //mContext.getPackageManager().queryIntentActivities(mIntent, 0);
            //final int resolveInfoCount = resolveInfos.size();
            //for (int i = 0; i < resolveInfoCount; i++) {
                //ResolveInfo resolveInfo = resolveInfos.get(i);
                //mActivites.add(new ActivityResolveInfo(resolveInfo));
            //}
            //sortActivities();
        //} else {
            //notifyChanged();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.425 -0400", hash_original_method = "A58F8162E2D66FE48738B2459230A97A", hash_generated_method = "EF9302E48C2FA1C6ABE085C8DB7534AC")
    private void pruneHistoricalRecordsForPackageLocked(String packageName) {
        boolean recordsRemoved;
        recordsRemoved = false;
        List<HistoricalRecord> historicalRecords;
        historicalRecords = mHistoricalRecords;
        {
            int i;
            i = 0;
            boolean varBE0151D4849F874558D3B97ACF98DD7B_2114381781 = (i < historicalRecords.size());
            {
                HistoricalRecord historicalRecord;
                historicalRecord = historicalRecords.get(i);
                String recordPackageName;
                recordPackageName = historicalRecord.activity.getPackageName();
                {
                    boolean varF0A69CA6ED747107A9EF432C02BA36BD_617958440 = (recordPackageName.equals(packageName));
                    {
                        historicalRecords.remove(historicalRecord);
                        recordsRemoved = true;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        {
            mHistoricalRecordsChanged = true;
            sortActivities();
        } //End block
        addTaint(packageName.getTaint());
        // ---------- Original Method ----------
        //boolean recordsRemoved = false;
        //List<HistoricalRecord> historicalRecords = mHistoricalRecords;
        //for (int i = 0; i < historicalRecords.size(); i++) {
            //HistoricalRecord historicalRecord = historicalRecords.get(i);
            //String recordPackageName = historicalRecord.activity.getPackageName();
            //if (recordPackageName.equals(packageName)) {
                //historicalRecords.remove(historicalRecord);
                //recordsRemoved = true;
            //}
        //}
        //if (recordsRemoved) {
            //mHistoricalRecordsChanged = true;
            //sortActivities();
        //}
    }

    
    public final static class HistoricalRecord {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.426 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "E9F78AFB95D47915FCC3FF74E33CC6C3")

        public ComponentName activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.426 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "5A44367B7C554CE37EA61A01D45FAC73")

        public long time;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.426 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public float weight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.426 -0400", hash_original_method = "1C86724BE7B708067898B3EC6CC9E920", hash_generated_method = "00040F0E8D55D727A5B7BC80D0968951")
        public  HistoricalRecord(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
            addTaint(activityName.getTaint());
            addTaint(time);
            addTaint(weight);
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.426 -0400", hash_original_method = "15F3A03D01E02908C99E8CDDD520EB93", hash_generated_method = "039A30ECAF845160B7B36EDE95851CB2")
        public  HistoricalRecord(ComponentName activityName, long time, float weight) {
            this.activity = activityName;
            this.time = time;
            this.weight = weight;
            // ---------- Original Method ----------
            //this.activity = activityName;
            //this.time = time;
            //this.weight = weight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.427 -0400", hash_original_method = "4E1A48E49166529A0B7FC03866764063", hash_generated_method = "94F74ABF6D9D28AADE30B3468DEB3502")
        @Override
        public int hashCode() {
            int prime;
            prime = 31;
            int result;
            result = 1;
            result = prime * result + ((activity == null) ? 0 : activity.hashCode());
            result = prime * result + (int) (time ^ (time >>> 32));
            result = prime * result + Float.floatToIntBits(weight);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686678731 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_686678731;
            // ---------- Original Method ----------
            //final int prime = 31;
            //int result = 1;
            //result = prime * result + ((activity == null) ? 0 : activity.hashCode());
            //result = prime * result + (int) (time ^ (time >>> 32));
            //result = prime * result + Float.floatToIntBits(weight);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.432 -0400", hash_original_method = "B85F0FF6FF50850EA2189DB29FD09D21", hash_generated_method = "B8010476526904F0A7507AA5169EACB6")
        @Override
        public boolean equals(Object obj) {
            {
                boolean varF071958F831141DD4937960A9F520909_94813341 = (getClass() != obj.getClass());
            } //End collapsed parenthetic
            HistoricalRecord other;
            other = (HistoricalRecord) obj;
            {
                boolean var6E1AC62E0C5F0574834B43B3C6FB54B7_323402693 = (!activity.equals(other.activity));
            } //End collapsed parenthetic
            {
                boolean var0EC1079F899BEB4CC63FE5981A8E170A_1520314981 = (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight));
            } //End collapsed parenthetic
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_63750301 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_63750301;
            // ---------- Original Method ----------
            //if (this == obj) {
                //return true;
            //}
            //if (obj == null) {
                //return false;
            //}
            //if (getClass() != obj.getClass()) {
                //return false;
            //}
            //HistoricalRecord other = (HistoricalRecord) obj;
            //if (activity == null) {
                //if (other.activity != null) {
                    //return false;
                //}
            //} else if (!activity.equals(other.activity)) {
                //return false;
            //}
            //if (time != other.time) {
                //return false;
            //}
            //if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight)) {
                //return false;
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.432 -0400", hash_original_method = "DE8206875FA4E924E296C5ACB6D7F3F2", hash_generated_method = "5B61D58784FF0437B1029D26A2FC01DD")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_500256191 = null; //Variable for return #1
            StringBuilder builder;
            builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(activity);
            builder.append("; time:").append(time);
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
            varB4EAC82CA7396A68D541C85D26508E83_500256191 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_500256191.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_500256191;
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //builder.append("[");
            //builder.append("; activity:").append(activity);
            //builder.append("; time:").append(time);
            //builder.append("; weight:").append(new BigDecimal(weight));
            //builder.append("]");
            //return builder.toString();
        }

        
    }


    
    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.432 -0400", hash_original_field = "C00A4654C3CFD33861C7CC1FD2D3713F", hash_generated_field = "42ACA7D028AD018D3FE2BFC3E32F6A75")

        public ResolveInfo resolveInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.432 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public float weight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.433 -0400", hash_original_method = "FE163077B7530186AE819FA48AA47F8E", hash_generated_method = "5FF0866FAB3426E950C36794AFE28F97")
        public  ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
            // ---------- Original Method ----------
            //this.resolveInfo = resolveInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.433 -0400", hash_original_method = "F192571EE56F5C4051616CB9861F74E4", hash_generated_method = "0018B425F5D7A1B8D4B6FED50345805C")
        @Override
        public int hashCode() {
            int varB15BFDB6118FAFD3CC127562D11D77C0_1494740944 = (31 + Float.floatToIntBits(weight));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_217562741 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_217562741;
            // ---------- Original Method ----------
            //return 31 + Float.floatToIntBits(weight);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.451 -0400", hash_original_method = "FF799F5AAE6D6CF88DAF4502D583A290", hash_generated_method = "E58493315EE217193BCD5A00B522F37C")
        @Override
        public boolean equals(Object obj) {
            {
                boolean varF071958F831141DD4937960A9F520909_1574672437 = (getClass() != obj.getClass());
            } //End collapsed parenthetic
            ActivityResolveInfo other;
            other = (ActivityResolveInfo) obj;
            {
                boolean var0EC1079F899BEB4CC63FE5981A8E170A_386609942 = (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight));
            } //End collapsed parenthetic
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1510937838 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1510937838;
            // ---------- Original Method ----------
            //if (this == obj) {
                //return true;
            //}
            //if (obj == null) {
                //return false;
            //}
            //if (getClass() != obj.getClass()) {
                //return false;
            //}
            //ActivityResolveInfo other = (ActivityResolveInfo) obj;
            //if (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight)) {
                //return false;
            //}
            //return true;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.452 -0400", hash_original_method = "05EB01A51A0727988F01FD1C25038E23", hash_generated_method = "13DE91AD2365CAD6866FE48714A22C4F")
        public int compareTo(ActivityResolveInfo another) {
            int var5BBE0592BEB3EA28EEF75B5000201B3C_1228109674 = (Float.floatToIntBits(another.weight) - Float.floatToIntBits(weight));
            addTaint(another.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042764922 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1042764922;
            // ---------- Original Method ----------
            //return  Float.floatToIntBits(another.weight) - Float.floatToIntBits(weight);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.452 -0400", hash_original_method = "6B7079774B733597AE380820B7605540", hash_generated_method = "A1A80EBB39BAFD297BF7EEF544D67004")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1280470767 = null; //Variable for return #1
            StringBuilder builder;
            builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
            varB4EAC82CA7396A68D541C85D26508E83_1280470767 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1280470767.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1280470767;
            // ---------- Original Method ----------
            //StringBuilder builder = new StringBuilder();
            //builder.append("[");
            //builder.append("resolveInfo:").append(resolveInfo.toString());
            //builder.append("; weight:").append(new BigDecimal(weight));
            //builder.append("]");
            //return builder.toString();
        }

        
    }


    
    private final class DefaultSorter implements ActivitySorter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.452 -0400", hash_original_field = "607FF895363E04DFCB9D5664F60B57F0", hash_generated_field = "005A22651ED0264C567E9B0DDB552078")

        private Map<String, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap<String, ActivityResolveInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.452 -0400", hash_original_method = "4BF496988E00827DD1484620E43167BF", hash_generated_method = "4BF496988E00827DD1484620E43167BF")
        public DefaultSorter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.460 -0400", hash_original_method = "1983622E810CF2F16D5FB85B8E79AAA7", hash_generated_method = "F5AC521355F16D0C760ADDA2919C5DB2")
        public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords) {
            Map<String, ActivityResolveInfo> packageNameToActivityMap;
            packageNameToActivityMap = mPackageNameToActivityMap;
            packageNameToActivityMap.clear();
            int activityCount;
            activityCount = activities.size();
            {
                int i;
                i = 0;
                {
                    ActivityResolveInfo activity;
                    activity = activities.get(i);
                    activity.weight = 0.0f;
                    String packageName;
                    packageName = activity.resolveInfo.activityInfo.packageName;
                    packageNameToActivityMap.put(packageName, activity);
                } //End block
            } //End collapsed parenthetic
            int lastShareIndex;
            lastShareIndex = historicalRecords.size() - 1;
            float nextRecordWeight;
            nextRecordWeight = 1;
            {
                int i;
                i = lastShareIndex;
                {
                    HistoricalRecord historicalRecord;
                    historicalRecord = historicalRecords.get(i);
                    String packageName;
                    packageName = historicalRecord.activity.getPackageName();
                    ActivityResolveInfo activity;
                    activity = packageNameToActivityMap.get(packageName);
                    {
                        activity.weight += historicalRecord.weight * nextRecordWeight;
                        nextRecordWeight = nextRecordWeight * WEIGHT_DECAY_COEFFICIENT;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            Collections.sort(activities);
            {
                {
                    int i;
                    i = 0;
                } //End collapsed parenthetic
            } //End block
            addTaint(intent.getTaint());
            addTaint(activities.getTaint());
            addTaint(historicalRecords.getTaint());
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.460 -0400", hash_original_field = "16755C1D312376513A05EE549649A996", hash_generated_field = "32171AD54B59F3264680E0BA6ED074C1")

        private static float WEIGHT_DECAY_COEFFICIENT = 0.95f;
    }


    
    private final class HistoryLoader implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.461 -0400", hash_original_method = "0F6CF60457783C48329031B15DA96823", hash_generated_method = "0F6CF60457783C48329031B15DA96823")
        public HistoryLoader ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.477 -0400", hash_original_method = "C7992FBC3712621E8BB422FE384E294B", hash_generated_method = "A9AE0D3FEC543FC5A8E5B6961C981464")
        public void run() {
            FileInputStream fis;
            fis = null;
            try 
            {
                fis = mContext.openFileInput(mHistoryFileName);
            } //End block
            catch (FileNotFoundException fnfe)
            { }
            try 
            {
                XmlPullParser parser;
                parser = Xml.newPullParser();
                parser.setInput(fis, null);
                int type;
                type = XmlPullParser.START_DOCUMENT;
                {
                    type = parser.next();
                } //End block
                {
                    boolean var1249786F987A59B50F6E7EA2A4AB531E_2132909396 = (!TAG_HISTORICAL_RECORDS.equals(parser.getName()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Share records file does not start with "
                            + TAG_HISTORICAL_RECORDS + " tag.");
                    } //End block
                } //End collapsed parenthetic
                List<HistoricalRecord> readRecords;
                readRecords = new ArrayList<HistoricalRecord>();
                {
                    type = parser.next();
                    String nodeName;
                    nodeName = parser.getName();
                    {
                        boolean varE9687D88833662E84EEF04B8B0A9A85E_1462030472 = (!TAG_HISTORICAL_RECORD.equals(nodeName));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Share records file not well-formed.");
                        } //End block
                    } //End collapsed parenthetic
                    String activity;
                    activity = parser.getAttributeValue(null, ATTRIBUTE_ACTIVITY);
                    long time;
                    time = Long.parseLong(parser.getAttributeValue(null, ATTRIBUTE_TIME));
                    float weight;
                    weight = Float.parseFloat(parser.getAttributeValue(null, ATTRIBUTE_WEIGHT));
                    HistoricalRecord readRecord;
                    readRecord = new HistoricalRecord(activity, time,
                            weight);
                    readRecords.add(readRecord);
                } //End block
                {
                    Set<HistoricalRecord> uniqueShareRecords;
                    uniqueShareRecords = new LinkedHashSet<HistoricalRecord>(readRecords);
                    List<HistoricalRecord> historicalRecords;
                    historicalRecords = mHistoricalRecords;
                    int historicalRecordsCount;
                    historicalRecordsCount = historicalRecords.size();
                    {
                        int i;
                        i = historicalRecordsCount - 1;
                        {
                            HistoricalRecord historicalRecord;
                            historicalRecord = historicalRecords.get(i);
                            uniqueShareRecords.add(historicalRecord);
                        } //End block
                    } //End collapsed parenthetic
                    {
                        boolean varC2A990ED21E2616B83A41814FE1721C8_1845060616 = (historicalRecords.size() == uniqueShareRecords.size());
                    } //End collapsed parenthetic
                    historicalRecords.clear();
                    historicalRecords.addAll(uniqueShareRecords);
                    mHistoricalRecordsChanged = true;
                    mHandler.post(new Runnable() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.477 -0400", hash_original_method = "7B5BE6A8F3CF3144B75BD698B249F235", hash_generated_method = "0CE57F01674CAFE17F3300F39AA005DE")
                        public void run() {
                            pruneExcessiveHistoricalRecordsLocked();
                            sortActivities();
                            // ---------- Original Method ----------
                            //pruneExcessiveHistoricalRecordsLocked();
                            //sortActivities();
                        }
});
                } //End block
            } //End block
            catch (XmlPullParserException xppe)
            { }
            catch (IOException ioe)
            { }
            finally 
            {
                {
                    try 
                    {
                        fis.close();
                    } //End block
                    catch (IOException ioe)
                    { }
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private final class HistoryPersister implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.478 -0400", hash_original_method = "F652F13A8701B98B9D8C3619B90FF892", hash_generated_method = "F652F13A8701B98B9D8C3619B90FF892")
        public HistoryPersister ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.485 -0400", hash_original_method = "56491CDA5DB122242C8DDE4A7A87359C", hash_generated_method = "3EEBB042C7EBBE8638CF89021AEABF5D")
        public void run() {
            FileOutputStream fos;
            fos = null;
            List<HistoricalRecord> records;
            records = null;
            {
                records = new ArrayList<HistoricalRecord>(mHistoricalRecords);
            } //End block
            try 
            {
                fos = mContext.openFileOutput(mHistoryFileName, Context.MODE_PRIVATE);
            } //End block
            catch (FileNotFoundException fnfe)
            { }
            XmlSerializer serializer;
            serializer = Xml.newSerializer();
            try 
            {
                serializer.setOutput(fos, null);
                serializer.startDocument("UTF-8", true);
                serializer.startTag(null, TAG_HISTORICAL_RECORDS);
                int recordCount;
                recordCount = records.size();
                {
                    int i;
                    i = 0;
                    {
                        HistoricalRecord record;
                        record = records.remove(0);
                        serializer.startTag(null, TAG_HISTORICAL_RECORD);
                        serializer.attribute(null, ATTRIBUTE_ACTIVITY, record.activity.flattenToString());
                        serializer.attribute(null, ATTRIBUTE_TIME, String.valueOf(record.time));
                        serializer.attribute(null, ATTRIBUTE_WEIGHT, String.valueOf(record.weight));
                        serializer.endTag(null, TAG_HISTORICAL_RECORD);
                    } //End block
                } //End collapsed parenthetic
                serializer.endTag(null, TAG_HISTORICAL_RECORDS);
                serializer.endDocument();
            } //End block
            catch (IllegalArgumentException iae)
            { }
            catch (IllegalStateException ise)
            { }
            catch (IOException ioe)
            { }
            finally 
            {
                {
                    try 
                    {
                        fos.close();
                    } //End block
                    catch (IOException e)
                    { }
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private final class DataModelPackageMonitor extends PackageMonitor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.488 -0400", hash_original_method = "7270678089AB03BAD6BBDC9C3DB17F70", hash_generated_method = "7270678089AB03BAD6BBDC9C3DB17F70")
        public DataModelPackageMonitor ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.496 -0400", hash_original_method = "C89F5C92B68E48D5DAFC93C690A3926A", hash_generated_method = "127949E8392499FAAB32F5B8715F8E57")
        @Override
        public void onPackageAdded(String packageName, int uid) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                loadActivitiesLocked();
            } //End block
            addTaint(packageName.getTaint());
            addTaint(uid);
            // ---------- Original Method ----------
            //synchronized (mInstanceLock) {
                //loadActivitiesLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.497 -0400", hash_original_method = "E08DC591D228402C0DBF164DF68C0AF4", hash_generated_method = "6A7F66E2249654D73D8F49B5D6C37D3D")
        @Override
        public void onPackageAppeared(String packageName, int reason) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                loadActivitiesLocked();
            } //End block
            addTaint(packageName.getTaint());
            addTaint(reason);
            // ---------- Original Method ----------
            //synchronized (mInstanceLock) {
                //loadActivitiesLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.498 -0400", hash_original_method = "A7BE115B10A66075A04B7082DDA7D411", hash_generated_method = "A273A0162799B58D7FFE22F810428893")
        @Override
        public void onPackageRemoved(String packageName, int uid) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            } //End block
            addTaint(packageName.getTaint());
            addTaint(uid);
            // ---------- Original Method ----------
            //synchronized (mInstanceLock) {
                //pruneHistoricalRecordsForPackageLocked(packageName);
                //loadActivitiesLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_method = "31BBEB936625AC985495016944655B18", hash_generated_method = "87BF23817ACDAD063A7CCCC4CE2944EB")
        @Override
        public void onPackageDisappeared(String packageName, int reason) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            } //End block
            addTaint(packageName.getTaint());
            addTaint(reason);
            // ---------- Original Method ----------
            //synchronized (mInstanceLock) {
                //pruneHistoricalRecordsForPackageLocked(packageName);
                //loadActivitiesLocked();
            //}
        }

        
    }


    
    public interface ActivityChooserModelClient {

        
        public void setActivityChooserModel(ActivityChooserModel dataModel);
    }
    
    public interface ActivitySorter {

        
        
        
        public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords);
    }
    
    public interface OnChooseActivityListener {

        
        public boolean onChooseActivity(ActivityChooserModel host, Intent intent);
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "FA52ACD91A762EFB98C64E6F734C4D25", hash_generated_field = "555F56F5455F8B2E528EB773B92C0527")

    private static String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "00C1CCA963C81A7DDA58A626A1979DA3", hash_generated_field = "CE78080EB218FF867FF7DD35154937AF")

    private static String TAG_HISTORICAL_RECORDS = "historical-records";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "3ADAAE105DC8F21BB7CBEC47C1D0DFF1", hash_generated_field = "571010C080A731E05D9C8F0CDF2D97BD")

    private static String TAG_HISTORICAL_RECORD = "historical-record";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "E13990A37ACBE7F78BA9E552D603F5DB", hash_generated_field = "F27579C83C475B7D42FF555706C3910B")

    private static String ATTRIBUTE_ACTIVITY = "activity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "B3485642830D4FB7BF523D4CAE813482", hash_generated_field = "3351C5FDF8CBA59027E005B79E1345D0")

    private static String ATTRIBUTE_TIME = "time";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "76190CA68A0DCC92E3A7C066E8CF1F70", hash_generated_field = "0BAD9A7EBCA33EBB2082D23FD8F9F0B9")

    private static String ATTRIBUTE_WEIGHT = "weight";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "3618283F5DC227BE959D6205ABF93B15", hash_generated_field = "C17F091D6E1676968D87EC382F2A60E4")

    public static final String DEFAULT_HISTORY_FILE_NAME =
        "activity_choser_model_history.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "47FB681069105B0255362C4BF4AB6E51", hash_generated_field = "51D1ECB43E515D53A9B4473F163B06AD")

    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "1B36629D46050C4AA3148B77E1702985", hash_generated_field = "4CA7DA7629D21FFA76F15B6935F0245C")

    private static int DEFAULT_ACTIVITY_INFLATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "AAFA76E029DEFAF3CD45DE63256FBD8F", hash_generated_field = "8AA15E551810ED514A146FAC569C30B4")

    private static float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.499 -0400", hash_original_field = "52CBB06050E39D454BA51CF00CA0F2D1", hash_generated_field = "094D14C3914C93D4C1469751777A5B3D")

    private static String HISTORY_FILE_EXTENSION = ".xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.512 -0400", hash_original_field = "8C5E8C33309913A25C19F3D2DD557C14", hash_generated_field = "C571E6AA8B1BA3C6304912A7B1FC5E17")

    private static int INVALID_INDEX = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.512 -0400", hash_original_field = "2BB5CE89E396F79FD8627F7C142D6CEE", hash_generated_field = "EFF47F5F6CB46BDC40357E0B85199171")

    private static Object sRegistryLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:04.512 -0400", hash_original_field = "CBDE1B68888BEC0836ED7A9E864923C7", hash_generated_field = "8C2D4F8730B10B5B7B2E0BEDBE7C8AB2")

    private static Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap<String, ActivityChooserModel>();
}

