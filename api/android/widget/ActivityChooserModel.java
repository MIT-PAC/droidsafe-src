package android.widget;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ActivityChooserModel extends DataSetObservable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "4C000E064E4AAC53A002F734A3803AFE", hash_generated_field = "6392F8242B4A9D3DC6E2F079ACDCEA46")

    private final Object mInstanceLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "BDD11A174105185D4DFC52160E3514BE", hash_generated_field = "A383B170605041BAE9B92E5ABD19A2C0")

    private final List<ActivityResolveInfo> mActivites = new ArrayList<ActivityResolveInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "A45D92F0F1E7DD7537AB0337C633B496", hash_generated_field = "CD99824E96948584D748917073F44E2A")

    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList<HistoricalRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "C20064CA31FAD1327132178E6648B402", hash_generated_field = "DD3DAD2906BF0D253EBD93D8930F9D13")

    private final PackageMonitor mPackageMonitor = new DataModelPackageMonitor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "0AC95AC99D05B1B82A91751B7AF9D262", hash_generated_field = "357B9AB2EB9473252BE7FAC7D1E15CF3")

    private String mHistoryFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "AB35EBBBAD6B54BD08B6B257BBB364A2", hash_generated_field = "972A273635E03BCAAB877E2B3CA36A43")

    private ActivitySorter mActivitySorter = new DefaultSorter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "009B5E594BE56F87B3DDDC247536245A", hash_generated_field = "EDEDBBB721F293D506B0D4333D55AA26")

    private int mHistoryMaxSize = DEFAULT_HISTORY_MAX_LENGTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "5D5149323D264891E5B84C86B8D5566D", hash_generated_field = "2CA5D5746328370D849F634661FCCB3C")

    private boolean mCanReadHistoricalData = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "16353D6A786D24930B9B107BE61F2C9C", hash_generated_field = "A0038BE823A55BDB17A2EB5E4620EF9F")

    private boolean mReadShareHistoryCalled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "2EA85A36CC27F7C4832E5A8C4EBC1736", hash_generated_field = "4EFA8B1A885AF19B054DFCDA0E6D3607")

    private boolean mHistoricalRecordsChanged = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.154 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2C33E5889A8CDA732A297DBE7101DB89")

    private final Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.155 -0400", hash_original_field = "669155EA4A74A2A42AAC5F61C77CAF5E", hash_generated_field = "84BCBE36C424794EB40EAAE6D9BDAEAE")

    private OnChooseActivityListener mActivityChoserModelPolicy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.155 -0400", hash_original_method = "807F9125D161268ACCBF934F5F44F95B", hash_generated_method = "D4720E2BC3C9D66889563D801E8159FD")
    private  ActivityChooserModel(Context context, String historyFileName) {
        mContext = context.getApplicationContext();
        if(!TextUtils.isEmpty(historyFileName)
                && !historyFileName.endsWith(HISTORY_FILE_EXTENSION))        
        {
            mHistoryFileName = historyFileName + HISTORY_FILE_EXTENSION;
        } //End block
        else
        {
            mHistoryFileName = historyFileName;
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.156 -0400", hash_original_method = "E9FF7BF71184D5918A5528B39387C05B", hash_generated_method = "18CCE81ABD65A10D68A1CBBC40B99539")
    public void setIntent(Intent intent) {
        synchronized
(mInstanceLock)        {
            if(mIntent == intent)            
            {
                return;
            } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.156 -0400", hash_original_method = "27A17A1D87D77EAA50C2FB6DFA94EC7A", hash_generated_method = "2297AC25F831302A3BCE2E38AD9DE628")
    public Intent getIntent() {
        synchronized
(mInstanceLock)        {
Intent var4DCF8E3D75AE0B94CDA94656DCE16BCE_1921553417 =             mIntent;
            var4DCF8E3D75AE0B94CDA94656DCE16BCE_1921553417.addTaint(taint);
            return var4DCF8E3D75AE0B94CDA94656DCE16BCE_1921553417;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mIntent;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.157 -0400", hash_original_method = "D90428775A0762F0AD6636514EC58022", hash_generated_method = "764381587B4B70E44A9D49C1021D0116")
    public int getActivityCount() {
        synchronized
(mInstanceLock)        {
            int varEE9CF3CA592A4FE681A759B4BC597948_269078845 = (mActivites.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686922273 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1686922273;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mActivites.size();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.157 -0400", hash_original_method = "032146065CC1BA2D79ECD4CB63DFEC7F", hash_generated_method = "EFA63A723DD52CB7EA5EABC3D77E0AF2")
    public ResolveInfo getActivity(int index) {
        addTaint(index);
        synchronized
(mInstanceLock)        {
ResolveInfo var16A1693659E349C4F10493D7FEF7AF3F_108679729 =             mActivites.get(index).resolveInfo;
            var16A1693659E349C4F10493D7FEF7AF3F_108679729.addTaint(taint);
            return var16A1693659E349C4F10493D7FEF7AF3F_108679729;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mActivites.get(index).resolveInfo;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.158 -0400", hash_original_method = "1C6D65F5A71D312AA7F7882C56EDED0B", hash_generated_method = "E95C65EC7902BF93908E4ABAE18DCA05")
    public int getActivityIndex(ResolveInfo activity) {
        addTaint(activity.getTaint());
        List<ActivityResolveInfo> activities = mActivites;
        final int activityCount = activities.size();
for(int i = 0;i < activityCount;i++)
        {
            ActivityResolveInfo currentActivity = activities.get(i);
            if(currentActivity.resolveInfo == activity)            
            {
                int var865C0C0B4AB0E063E5CAA3387C1A8741_1934247067 = (i);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548957140 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_548957140;
            } //End block
        } //End block
        int varF059DD129FB8A61588D41BA6DF391A4E_352401162 = (INVALID_INDEX);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420078015 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1420078015;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.158 -0400", hash_original_method = "2E1571A22B1C1279902BA9C2D35CCDAC", hash_generated_method = "CED95FE0283513C397961DF58B31CF2C")
    public Intent chooseActivity(int index) {
        addTaint(index);
        ActivityResolveInfo chosenActivity = mActivites.get(index);
        ComponentName chosenName = new ComponentName(
                chosenActivity.resolveInfo.activityInfo.packageName,
                chosenActivity.resolveInfo.activityInfo.name);
        Intent choiceIntent = new Intent(mIntent);
        choiceIntent.setComponent(chosenName);
        if(mActivityChoserModelPolicy != null)        
        {
            Intent choiceIntentCopy = new Intent(choiceIntent);
            final boolean handled = mActivityChoserModelPolicy.onChooseActivity(this,
                    choiceIntentCopy);
            if(handled)            
            {
Intent var540C13E9E156B687226421B24F2DF178_1557981555 =                 null;
                var540C13E9E156B687226421B24F2DF178_1557981555.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1557981555;
            } //End block
        } //End block
        HistoricalRecord historicalRecord = new HistoricalRecord(chosenName,
                System.currentTimeMillis(), DEFAULT_HISTORICAL_RECORD_WEIGHT);
        addHisoricalRecord(historicalRecord);
Intent varE44B24DC285915FA809667F86F15DD6A_1368074179 =         choiceIntent;
        varE44B24DC285915FA809667F86F15DD6A_1368074179.addTaint(taint);
        return varE44B24DC285915FA809667F86F15DD6A_1368074179;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.159 -0400", hash_original_method = "56E3863DC4DFDE24EBD2068470DB48E1", hash_generated_method = "502DB08B7514528D4C4579AC10A6BA23")
    public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        mActivityChoserModelPolicy = listener;
        // ---------- Original Method ----------
        //mActivityChoserModelPolicy = listener;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.159 -0400", hash_original_method = "8C412D794940DE98F4AAE841092A3BC7", hash_generated_method = "23988C1363B0481FBCAC25A18B113953")
    public ResolveInfo getDefaultActivity() {
        synchronized
(mInstanceLock)        {
            if(!mActivites.isEmpty())            
            {
ResolveInfo varF81D77FBBA6386BD228B5E33DB7741BD_7953544 =                 mActivites.get(0).resolveInfo;
                varF81D77FBBA6386BD228B5E33DB7741BD_7953544.addTaint(taint);
                return varF81D77FBBA6386BD228B5E33DB7741BD_7953544;
            } //End block
        } //End block
ResolveInfo var540C13E9E156B687226421B24F2DF178_398345165 =         null;
        var540C13E9E156B687226421B24F2DF178_398345165.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_398345165;
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //if (!mActivites.isEmpty()) {
                //return mActivites.get(0).resolveInfo;
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.160 -0400", hash_original_method = "6293689B582FC8E5AF147BEE230A1B37", hash_generated_method = "15F0E289A9B211154D8D674740788F7E")
    public void setDefaultActivity(int index) {
        addTaint(index);
        ActivityResolveInfo newDefaultActivity = mActivites.get(index);
        ActivityResolveInfo oldDefaultActivity = mActivites.get(0);
        float weight;
        if(oldDefaultActivity != null)        
        {
            weight = oldDefaultActivity.weight - newDefaultActivity.weight
                + DEFAULT_ACTIVITY_INFLATION;
        } //End block
        else
        {
            weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
        } //End block
        ComponentName defaultName = new ComponentName(
                newDefaultActivity.resolveInfo.activityInfo.packageName,
                newDefaultActivity.resolveInfo.activityInfo.name);
        HistoricalRecord historicalRecord = new HistoricalRecord(defaultName,
                System.currentTimeMillis(), weight);
        addHisoricalRecord(historicalRecord);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.161 -0400", hash_original_method = "79A1B7D3C52D92BAB878ED8275782ED6", hash_generated_method = "5E09CEDE6A1BC09D58744FE19130CF12")
    private void readHistoricalData() {
        synchronized
(mInstanceLock)        {
            if(!mCanReadHistoricalData || !mHistoricalRecordsChanged)            
            {
                return;
            } //End block
            mCanReadHistoricalData = false;
            mReadShareHistoryCalled = true;
            if(!TextUtils.isEmpty(mHistoryFileName))            
            {
                AsyncTask.SERIAL_EXECUTOR.execute(new HistoryLoader());
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.161 -0400", hash_original_method = "50EE1C88911FEE4E5E828FE89316C1B7", hash_generated_method = "A27EC6C3A7305F0B8EF17D99A4E9FAFD")
    private void persistHistoricalData() {
        synchronized
(mInstanceLock)        {
            if(!mReadShareHistoryCalled)            
            {
                IllegalStateException var3FA515C78C3446B25BEB037F7FE64FCA_1227286634 = new IllegalStateException("No preceding call to #readHistoricalData");
                var3FA515C78C3446B25BEB037F7FE64FCA_1227286634.addTaint(taint);
                throw var3FA515C78C3446B25BEB037F7FE64FCA_1227286634;
            } //End block
            if(!mHistoricalRecordsChanged)            
            {
                return;
            } //End block
            mHistoricalRecordsChanged = false;
            mCanReadHistoricalData = true;
            if(!TextUtils.isEmpty(mHistoryFileName))            
            {
                AsyncTask.SERIAL_EXECUTOR.execute(new HistoryPersister());
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.162 -0400", hash_original_method = "4FD548D8FB7638BF40234ABBB5D78544", hash_generated_method = "592C089D2F0A427487BA7B99F44C385B")
    public void setActivitySorter(ActivitySorter activitySorter) {
        synchronized
(mInstanceLock)        {
            if(mActivitySorter == activitySorter)            
            {
                return;
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.162 -0400", hash_original_method = "B440CA3B13B34DB5E9312802F4C1443D", hash_generated_method = "FBD868E3B4D7BB6ED10134AC201B4166")
    private void sortActivities() {
        synchronized
(mInstanceLock)        {
            if(mActivitySorter != null && !mActivites.isEmpty())            
            {
                mActivitySorter.sort(mIntent, mActivites,
                        Collections.unmodifiableList(mHistoricalRecords));
                notifyChanged();
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.163 -0400", hash_original_method = "1F530ED27C984DBDEEC1EB526F5DD126", hash_generated_method = "29231AB0663CC1A7BB0CADD53F6E0D6A")
    public void setHistoryMaxSize(int historyMaxSize) {
        synchronized
(mInstanceLock)        {
            if(mHistoryMaxSize == historyMaxSize)            
            {
                return;
            } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.163 -0400", hash_original_method = "EBCBD4C754CE0391425067ED25453667", hash_generated_method = "6AAF2EBD70A5C16C515656BED5F712FF")
    public int getHistoryMaxSize() {
        synchronized
(mInstanceLock)        {
            int var60A475C6BC545DF9382D60CA60C0AFD1_1591134195 = (mHistoryMaxSize);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102668867 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1102668867;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mHistoryMaxSize;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.163 -0400", hash_original_method = "9F4BBC1AE7ECE6B5427CA6E0430F86F9", hash_generated_method = "B2819C3A6998C010FCE9ECEEDB620440")
    public int getHistorySize() {
        synchronized
(mInstanceLock)        {
            int varE99D5D1CE9ABD5BEC8AFB022AE600BF5_1102857582 = (mHistoricalRecords.size());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631593260 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_631593260;
        } //End block
        // ---------- Original Method ----------
        //synchronized (mInstanceLock) {
            //return mHistoricalRecords.size();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.163 -0400", hash_original_method = "37F72BEA9084083CB35C7BD83368023D", hash_generated_method = "C5E6738DAFC973D5C650FCF6D89CF2D3")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        mPackageMonitor.unregister();
        // ---------- Original Method ----------
        //super.finalize();
        //mPackageMonitor.unregister();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.163 -0400", hash_original_method = "50B8FA4A00A0FC54414B26FDB0055015", hash_generated_method = "DA0FCF0A47166EA7770D1D2A6B3E7435")
    private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        addTaint(historicalRecord.getTaint());
        synchronized
(mInstanceLock)        {
            final boolean added = mHistoricalRecords.add(historicalRecord);
            if(added)            
            {
                mHistoricalRecordsChanged = true;
                pruneExcessiveHistoricalRecordsLocked();
                persistHistoricalData();
                sortActivities();
            } //End block
            boolean varB60ED88355AC3F6898FD8A7AB1734D06_829893031 = (added);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2000860176 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2000860176;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.164 -0400", hash_original_method = "84DEA752877B716573664E1E2DB7F950", hash_generated_method = "2E7F3055A1DB03798BFC7C98F1F9C0BA")
    private void pruneExcessiveHistoricalRecordsLocked() {
        List<HistoricalRecord> choiceRecords = mHistoricalRecords;
        final int pruneCount = choiceRecords.size() - mHistoryMaxSize;
        if(pruneCount <= 0)        
        {
            return;
        } //End block
        mHistoricalRecordsChanged = true;
for(int i = 0;i < pruneCount;i++)
        {
            HistoricalRecord prunedRecord = choiceRecords.remove(0);
            if(DEBUG)            
            {
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.164 -0400", hash_original_method = "CE097995E3DDE01957F3BEF111DCC08A", hash_generated_method = "CF49077B2CD7CD012AC125F34EB99385")
    private void loadActivitiesLocked() {
        mActivites.clear();
        if(mIntent != null)        
        {
            List<ResolveInfo> resolveInfos = mContext.getPackageManager().queryIntentActivities(mIntent, 0);
            final int resolveInfoCount = resolveInfos.size();
for(int i = 0;i < resolveInfoCount;i++)
            {
                ResolveInfo resolveInfo = resolveInfos.get(i);
                mActivites.add(new ActivityResolveInfo(resolveInfo));
            } //End block
            sortActivities();
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.164 -0400", hash_original_method = "A58F8162E2D66FE48738B2459230A97A", hash_generated_method = "86325D14E5B34998F424D60739551EA2")
    private void pruneHistoricalRecordsForPackageLocked(String packageName) {
        addTaint(packageName.getTaint());
        boolean recordsRemoved = false;
        List<HistoricalRecord> historicalRecords = mHistoricalRecords;
for(int i = 0;i < historicalRecords.size();i++)
        {
            HistoricalRecord historicalRecord = historicalRecords.get(i);
            String recordPackageName = historicalRecord.activity.getPackageName();
            if(recordPackageName.equals(packageName))            
            {
                historicalRecords.remove(historicalRecord);
                recordsRemoved = true;
            } //End block
        } //End block
        if(recordsRemoved)        
        {
            mHistoricalRecordsChanged = true;
            sortActivities();
        } //End block
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.164 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "E9F78AFB95D47915FCC3FF74E33CC6C3")

        public ComponentName activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.164 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "5A44367B7C554CE37EA61A01D45FAC73")

        public long time;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.164 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public float weight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.165 -0400", hash_original_method = "1C86724BE7B708067898B3EC6CC9E920", hash_generated_method = "6A4D14D2B40550C038614A3DE96D1B4B")
        public  HistoricalRecord(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
            addTaint(weight);
            addTaint(time);
            addTaint(activityName.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.165 -0400", hash_original_method = "15F3A03D01E02908C99E8CDDD520EB93", hash_generated_method = "039A30ECAF845160B7B36EDE95851CB2")
        public  HistoricalRecord(ComponentName activityName, long time, float weight) {
            this.activity = activityName;
            this.time = time;
            this.weight = weight;
            // ---------- Original Method ----------
            //this.activity = activityName;
            //this.time = time;
            //this.weight = weight;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.166 -0400", hash_original_method = "4E1A48E49166529A0B7FC03866764063", hash_generated_method = "3B0E00D03D9D69C11EE95E24EC447760")
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((activity == null) ? 0 : activity.hashCode());
            result = prime * result + (int) (time ^ (time >>> 32));
            result = prime * result + Float.floatToIntBits(weight);
            int varB4A88417B3D0170D754C647C30B7216A_102603459 = (result);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121961832 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_121961832;
            // ---------- Original Method ----------
            //final int prime = 31;
            //int result = 1;
            //result = prime * result + ((activity == null) ? 0 : activity.hashCode());
            //result = prime * result + (int) (time ^ (time >>> 32));
            //result = prime * result + Float.floatToIntBits(weight);
            //return result;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.167 -0400", hash_original_method = "B85F0FF6FF50850EA2189DB29FD09D21", hash_generated_method = "4BC501845C9E5410744E92942F878F57")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            if(this == obj)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_601077454 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_215111355 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_215111355;
            } //End block
            if(obj == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_317189513 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030549766 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030549766;
            } //End block
            if(getClass() != obj.getClass())            
            {
                boolean var68934A3E9455FA72420237EB05902327_996235726 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500055438 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500055438;
            } //End block
            HistoricalRecord other = (HistoricalRecord) obj;
            if(activity == null)            
            {
                if(other.activity != null)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_200118852 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_985663980 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_985663980;
                } //End block
            } //End block
            else
            if(!activity.equals(other.activity))            
            {
                boolean var68934A3E9455FA72420237EB05902327_11038583 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1149305088 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1149305088;
            } //End block
            if(time != other.time)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1471665667 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_131164845 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_131164845;
            } //End block
            if(Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1873282763 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1035588754 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1035588754;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_2028042562 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112139964 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112139964;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.168 -0400", hash_original_method = "DE8206875FA4E924E296C5ACB6D7F3F2", hash_generated_method = "EFC308D493F77FEC1CC655303679EE7B")
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(activity);
            builder.append("; time:").append(time);
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
String varF4CF030572656354ACFDF83FEE21D7A6_317226636 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_317226636.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_317226636;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.168 -0400", hash_original_field = "C00A4654C3CFD33861C7CC1FD2D3713F", hash_generated_field = "42ACA7D028AD018D3FE2BFC3E32F6A75")

        public ResolveInfo resolveInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.168 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public float weight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.168 -0400", hash_original_method = "FE163077B7530186AE819FA48AA47F8E", hash_generated_method = "5FF0866FAB3426E950C36794AFE28F97")
        public  ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
            // ---------- Original Method ----------
            //this.resolveInfo = resolveInfo;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.168 -0400", hash_original_method = "F192571EE56F5C4051616CB9861F74E4", hash_generated_method = "7F6AD749B89A89F49059E8E94E99F843")
        @Override
        public int hashCode() {
            int var870AB715848EE80A9C18EC07E4D8B063_966920453 = (31 + Float.floatToIntBits(weight));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449609305 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_449609305;
            // ---------- Original Method ----------
            //return 31 + Float.floatToIntBits(weight);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.168 -0400", hash_original_method = "FF799F5AAE6D6CF88DAF4502D583A290", hash_generated_method = "945E57951DB08444C669B2A79B28EE10")
        @Override
        public boolean equals(Object obj) {
            addTaint(obj.getTaint());
            if(this == obj)            
            {
                boolean varB326B5062B2F0E69046810717534CB09_209346117 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973266774 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973266774;
            } //End block
            if(obj == null)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1890878992 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_672112295 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_672112295;
            } //End block
            if(getClass() != obj.getClass())            
            {
                boolean var68934A3E9455FA72420237EB05902327_1216485761 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2069054629 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_2069054629;
            } //End block
            ActivityResolveInfo other = (ActivityResolveInfo) obj;
            if(Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight))            
            {
                boolean var68934A3E9455FA72420237EB05902327_874030543 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_722537828 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_722537828;
            } //End block
            boolean varB326B5062B2F0E69046810717534CB09_471552787 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_21861458 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_21861458;
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.169 -0400", hash_original_method = "05EB01A51A0727988F01FD1C25038E23", hash_generated_method = "5269C76192F82713119B34F685EA8AAD")
        public int compareTo(ActivityResolveInfo another) {
            addTaint(another.getTaint());
            int var7DDFDF7A874F602BD83F39F6B9E3E74A_1119173032 = (Float.floatToIntBits(another.weight) - Float.floatToIntBits(weight));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779678586 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_779678586;
            // ---------- Original Method ----------
            //return  Float.floatToIntBits(another.weight) - Float.floatToIntBits(weight);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.169 -0400", hash_original_method = "6B7079774B733597AE380820B7605540", hash_generated_method = "A00CCA09BE17BCB3B64990BF9AFDA63A")
        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
String varF4CF030572656354ACFDF83FEE21D7A6_1142023533 =             builder.toString();
            varF4CF030572656354ACFDF83FEE21D7A6_1142023533.addTaint(taint);
            return varF4CF030572656354ACFDF83FEE21D7A6_1142023533;
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.169 -0400", hash_original_field = "607FF895363E04DFCB9D5664F60B57F0", hash_generated_field = "36A2609728A36E5BA82D7C988AE5AE60")

        private final Map<String, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap<String, ActivityResolveInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.169 -0400", hash_original_method = "4BF496988E00827DD1484620E43167BF", hash_generated_method = "4BF496988E00827DD1484620E43167BF")
        public DefaultSorter ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.170 -0400", hash_original_method = "1983622E810CF2F16D5FB85B8E79AAA7", hash_generated_method = "87227298B8387B4B0F38E66CEBDB753B")
        public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords) {
            addTaint(historicalRecords.getTaint());
            addTaint(activities.getTaint());
            addTaint(intent.getTaint());
            Map<String, ActivityResolveInfo> packageNameToActivityMap = mPackageNameToActivityMap;
            packageNameToActivityMap.clear();
            final int activityCount = activities.size();
for(int i = 0;i < activityCount;i++)
            {
                ActivityResolveInfo activity = activities.get(i);
                activity.weight = 0.0f;
                String packageName = activity.resolveInfo.activityInfo.packageName;
                packageNameToActivityMap.put(packageName, activity);
            } //End block
            final int lastShareIndex = historicalRecords.size() - 1;
            float nextRecordWeight = 1;
for(int i = lastShareIndex;i >= 0;i--)
            {
                HistoricalRecord historicalRecord = historicalRecords.get(i);
                String packageName = historicalRecord.activity.getPackageName();
                ActivityResolveInfo activity = packageNameToActivityMap.get(packageName);
                if(activity != null)                
                {
                    activity.weight += historicalRecord.weight * nextRecordWeight;
                    nextRecordWeight = nextRecordWeight * WEIGHT_DECAY_COEFFICIENT;
                } //End block
            } //End block
            Collections.sort(activities);
            if(DEBUG)            
            {
for(int i = 0;i < activityCount;i++)
                {
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.170 -0400", hash_original_field = "16755C1D312376513A05EE549649A996", hash_generated_field = "80DD4E6EDFEAE82BDC0A595B5F72F371")

        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
    }


    
    private final class HistoryLoader implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.170 -0400", hash_original_method = "0F6CF60457783C48329031B15DA96823", hash_generated_method = "0F6CF60457783C48329031B15DA96823")
        public HistoryLoader ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.171 -0400", hash_original_method = "C7992FBC3712621E8BB422FE384E294B", hash_generated_method = "BB014A7E0EE4C05945D68AA9CAE8F259")
        public void run() {
            FileInputStream fis = null;
            try 
            {
                fis = mContext.openFileInput(mHistoryFileName);
            } //End block
            catch (FileNotFoundException fnfe)
            {
                if(DEBUG)                
                {
                } //End block
                return;
            } //End block
            try 
            {
                XmlPullParser parser = Xml.newPullParser();
                parser.setInput(fis, null);
                int type = XmlPullParser.START_DOCUMENT;
                while
(type != XmlPullParser.END_DOCUMENT && type != XmlPullParser.START_TAG)                
                {
                    type = parser.next();
                } //End block
                if(!TAG_HISTORICAL_RECORDS.equals(parser.getName()))                
                {
                    XmlPullParserException var5FBDE362DFFC3C24BCC88AAC42CB95AA_1528371733 = new XmlPullParserException("Share records file does not start with "
                            + TAG_HISTORICAL_RECORDS + " tag.");
                    var5FBDE362DFFC3C24BCC88AAC42CB95AA_1528371733.addTaint(taint);
                    throw var5FBDE362DFFC3C24BCC88AAC42CB95AA_1528371733;
                } //End block
                List<HistoricalRecord> readRecords = new ArrayList<HistoricalRecord>();
                while
(true)                
                {
                    type = parser.next();
                    if(type == XmlPullParser.END_DOCUMENT)                    
                    {
                        break;
                    } //End block
                    if(type == XmlPullParser.END_TAG || type == XmlPullParser.TEXT)                    
                    {
                        continue;
                    } //End block
                    String nodeName = parser.getName();
                    if(!TAG_HISTORICAL_RECORD.equals(nodeName))                    
                    {
                        XmlPullParserException varF3F51246E63940A674F24490F1D3073F_849479082 = new XmlPullParserException("Share records file not well-formed.");
                        varF3F51246E63940A674F24490F1D3073F_849479082.addTaint(taint);
                        throw varF3F51246E63940A674F24490F1D3073F_849479082;
                    } //End block
                    String activity = parser.getAttributeValue(null, ATTRIBUTE_ACTIVITY);
                    final long time = Long.parseLong(parser.getAttributeValue(null, ATTRIBUTE_TIME));
                    final float weight = Float.parseFloat(parser.getAttributeValue(null, ATTRIBUTE_WEIGHT));
                    HistoricalRecord readRecord = new HistoricalRecord(activity, time,
                            weight);
                    readRecords.add(readRecord);
                    if(DEBUG)                    
                    {
                    } //End block
                } //End block
                if(DEBUG)                
                {
                } //End block
                synchronized
(mInstanceLock)                {
                    Set<HistoricalRecord> uniqueShareRecords = new LinkedHashSet<HistoricalRecord>(readRecords);
                    List<HistoricalRecord> historicalRecords = mHistoricalRecords;
                    final int historicalRecordsCount = historicalRecords.size();
for(int i = historicalRecordsCount - 1;i >= 0;i--)
                    {
                        HistoricalRecord historicalRecord = historicalRecords.get(i);
                        uniqueShareRecords.add(historicalRecord);
                    } //End block
                    if(historicalRecords.size() == uniqueShareRecords.size())                    
                    {
                        return;
                    } //End block
                    historicalRecords.clear();
                    historicalRecords.addAll(uniqueShareRecords);
                    mHistoricalRecordsChanged = true;
                    mHandler.post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.171 -0400", hash_original_method = "7B5BE6A8F3CF3144B75BD698B249F235", hash_generated_method = "0CE57F01674CAFE17F3300F39AA005DE")
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
            {
            } //End block
            catch (IOException ioe)
            {
            } //End block
            finally 
            {
                if(fis != null)                
                {
                    try 
                    {
                        fis.close();
                    } //End block
                    catch (IOException ioe)
                    {
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private final class HistoryPersister implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.171 -0400", hash_original_method = "F652F13A8701B98B9D8C3619B90FF892", hash_generated_method = "F652F13A8701B98B9D8C3619B90FF892")
        public HistoryPersister ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.172 -0400", hash_original_method = "56491CDA5DB122242C8DDE4A7A87359C", hash_generated_method = "FC4CE5BEB4D60C7B3633314C0370992C")
        public void run() {
            FileOutputStream fos = null;
            List<HistoricalRecord> records = null;
            synchronized
(mInstanceLock)            {
                records = new ArrayList<HistoricalRecord>(mHistoricalRecords);
            } //End block
            try 
            {
                fos = mContext.openFileOutput(mHistoryFileName, Context.MODE_PRIVATE);
            } //End block
            catch (FileNotFoundException fnfe)
            {
                return;
            } //End block
            XmlSerializer serializer = Xml.newSerializer();
            try 
            {
                serializer.setOutput(fos, null);
                serializer.startDocument("UTF-8", true);
                serializer.startTag(null, TAG_HISTORICAL_RECORDS);
                final int recordCount = records.size();
for(int i = 0;i < recordCount;i++)
                {
                    HistoricalRecord record = records.remove(0);
                    serializer.startTag(null, TAG_HISTORICAL_RECORD);
                    serializer.attribute(null, ATTRIBUTE_ACTIVITY, record.activity.flattenToString());
                    serializer.attribute(null, ATTRIBUTE_TIME, String.valueOf(record.time));
                    serializer.attribute(null, ATTRIBUTE_WEIGHT, String.valueOf(record.weight));
                    serializer.endTag(null, TAG_HISTORICAL_RECORD);
                    if(DEBUG)                    
                    {
                    } //End block
                } //End block
                serializer.endTag(null, TAG_HISTORICAL_RECORDS);
                serializer.endDocument();
                if(DEBUG)                
                {
                } //End block
            } //End block
            catch (IllegalArgumentException iae)
            {
            } //End block
            catch (IllegalStateException ise)
            {
            } //End block
            catch (IOException ioe)
            {
            } //End block
            finally 
            {
                if(fos != null)                
                {
                    try 
                    {
                        fos.close();
                    } //End block
                    catch (IOException e)
                    {
                    } //End block
                } //End block
            } //End block
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
    }


    
    private final class DataModelPackageMonitor extends PackageMonitor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.172 -0400", hash_original_method = "7270678089AB03BAD6BBDC9C3DB17F70", hash_generated_method = "7270678089AB03BAD6BBDC9C3DB17F70")
        public DataModelPackageMonitor ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.172 -0400", hash_original_method = "C89F5C92B68E48D5DAFC93C690A3926A", hash_generated_method = "E306A83B5D5ECCC6744562B574EF6635")
        @Override
        public void onPackageAdded(String packageName, int uid) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(uid);
            addTaint(packageName.getTaint());
            synchronized
(mInstanceLock)            {
                loadActivitiesLocked();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mInstanceLock) {
                //loadActivitiesLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.173 -0400", hash_original_method = "E08DC591D228402C0DBF164DF68C0AF4", hash_generated_method = "376D22EF41EB921C8D87080758BA8B82")
        @Override
        public void onPackageAppeared(String packageName, int reason) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(reason);
            addTaint(packageName.getTaint());
            synchronized
(mInstanceLock)            {
                loadActivitiesLocked();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mInstanceLock) {
                //loadActivitiesLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.173 -0400", hash_original_method = "A7BE115B10A66075A04B7082DDA7D411", hash_generated_method = "3DD87351A4166C3F8D12994C5ED5D241")
        @Override
        public void onPackageRemoved(String packageName, int uid) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(uid);
            addTaint(packageName.getTaint());
            synchronized
(mInstanceLock)            {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            } //End block
            // ---------- Original Method ----------
            //synchronized (mInstanceLock) {
                //pruneHistoricalRecordsForPackageLocked(packageName);
                //loadActivitiesLocked();
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.173 -0400", hash_original_method = "31BBEB936625AC985495016944655B18", hash_generated_method = "94862DE920213039998047DC3EF605EF")
        @Override
        public void onPackageDisappeared(String packageName, int reason) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(reason);
            addTaint(packageName.getTaint());
            synchronized
(mInstanceLock)            {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            } //End block
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.173 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.173 -0400", hash_original_field = "FA52ACD91A762EFB98C64E6F734C4D25", hash_generated_field = "C0E6428FC538C3E98CD4F3F3FD104AD3")

    private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.173 -0400", hash_original_field = "00C1CCA963C81A7DDA58A626A1979DA3", hash_generated_field = "2F78BC6BF3EA40EEBFAAF4062888B202")

    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.173 -0400", hash_original_field = "3ADAAE105DC8F21BB7CBEC47C1D0DFF1", hash_generated_field = "B57E7DC30CE2B7036D338B99DE1C8F4A")

    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.173 -0400", hash_original_field = "E13990A37ACBE7F78BA9E552D603F5DB", hash_generated_field = "4F997BDD322ABDE394E143C88BE19902")

    private static final String ATTRIBUTE_ACTIVITY = "activity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.173 -0400", hash_original_field = "B3485642830D4FB7BF523D4CAE813482", hash_generated_field = "4657BA7339C2DB58947DE9CCAAA8BCAF")

    private static final String ATTRIBUTE_TIME = "time";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.174 -0400", hash_original_field = "76190CA68A0DCC92E3A7C066E8CF1F70", hash_generated_field = "8399470D08376E2A59EAC9C79DB79A9E")

    private static final String ATTRIBUTE_WEIGHT = "weight";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.174 -0400", hash_original_field = "3618283F5DC227BE959D6205ABF93B15", hash_generated_field = "C17F091D6E1676968D87EC382F2A60E4")

    public static final String DEFAULT_HISTORY_FILE_NAME =
        "activity_choser_model_history.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.174 -0400", hash_original_field = "47FB681069105B0255362C4BF4AB6E51", hash_generated_field = "51D1ECB43E515D53A9B4473F163B06AD")

    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.174 -0400", hash_original_field = "1B36629D46050C4AA3148B77E1702985", hash_generated_field = "450784023A27CD5EC5CEF077D5E372FC")

    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.174 -0400", hash_original_field = "AAFA76E029DEFAF3CD45DE63256FBD8F", hash_generated_field = "48D4985B801C29FF4FB9AF6C46ABE846")

    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.174 -0400", hash_original_field = "52CBB06050E39D454BA51CF00CA0F2D1", hash_generated_field = "5BDD81AF45C2360A5D0488EF180F0B0E")

    private static final String HISTORY_FILE_EXTENSION = ".xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.174 -0400", hash_original_field = "8C5E8C33309913A25C19F3D2DD557C14", hash_generated_field = "19F556E730E88DC545CC4ADD400592D6")

    private static final int INVALID_INDEX = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.174 -0400", hash_original_field = "2BB5CE89E396F79FD8627F7C142D6CEE", hash_generated_field = "922B32A26FF0AAB23FEB7772C78F88BB")

    private static final Object sRegistryLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:58.174 -0400", hash_original_field = "CBDE1B68888BEC0836ED7A9E864923C7", hash_generated_field = "BB4344C9185B0C58F3786BE4083DEBFE")

    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap<String, ActivityChooserModel>();
}

