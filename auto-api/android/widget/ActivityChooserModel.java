package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "4C000E064E4AAC53A002F734A3803AFE", hash_generated_field = "6392F8242B4A9D3DC6E2F079ACDCEA46")

    private final Object mInstanceLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "BDD11A174105185D4DFC52160E3514BE", hash_generated_field = "A383B170605041BAE9B92E5ABD19A2C0")

    private final List<ActivityResolveInfo> mActivites = new ArrayList<ActivityResolveInfo>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "A45D92F0F1E7DD7537AB0337C633B496", hash_generated_field = "CD99824E96948584D748917073F44E2A")

    private final List<HistoricalRecord> mHistoricalRecords = new ArrayList<HistoricalRecord>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "C20064CA31FAD1327132178E6648B402", hash_generated_field = "DD3DAD2906BF0D253EBD93D8930F9D13")

    private final PackageMonitor mPackageMonitor = new DataModelPackageMonitor();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "0AC95AC99D05B1B82A91751B7AF9D262", hash_generated_field = "357B9AB2EB9473252BE7FAC7D1E15CF3")

    private String mHistoryFileName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "B1135DD88C82BCDD4DCD8391BCD99883", hash_generated_field = "5782C825DA3F61D408DF2DCA63E7F54A")

    private Intent mIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "AB35EBBBAD6B54BD08B6B257BBB364A2", hash_generated_field = "972A273635E03BCAAB877E2B3CA36A43")

    private ActivitySorter mActivitySorter = new DefaultSorter();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "009B5E594BE56F87B3DDDC247536245A", hash_generated_field = "EDEDBBB721F293D506B0D4333D55AA26")

    private int mHistoryMaxSize = DEFAULT_HISTORY_MAX_LENGTH;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "5D5149323D264891E5B84C86B8D5566D", hash_generated_field = "2CA5D5746328370D849F634661FCCB3C")

    private boolean mCanReadHistoricalData = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "16353D6A786D24930B9B107BE61F2C9C", hash_generated_field = "A0038BE823A55BDB17A2EB5E4620EF9F")

    private boolean mReadShareHistoryCalled = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "2EA85A36CC27F7C4832E5A8C4EBC1736", hash_generated_field = "4EFA8B1A885AF19B054DFCDA0E6D3607")

    private boolean mHistoricalRecordsChanged = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2C33E5889A8CDA732A297DBE7101DB89")

    private final Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.455 -0400", hash_original_field = "669155EA4A74A2A42AAC5F61C77CAF5E", hash_generated_field = "84BCBE36C424794EB40EAAE6D9BDAEAE")

    private OnChooseActivityListener mActivityChoserModelPolicy;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.456 -0400", hash_original_method = "807F9125D161268ACCBF934F5F44F95B", hash_generated_method = "8CA02BD14F1D650854D2B4B344D04277")
    private  ActivityChooserModel(Context context, String historyFileName) {
        mContext = context.getApplicationContext();
        {
            boolean varAAE3DD8441840AD5E419F9A88A281AD8_1861489325 = (!TextUtils.isEmpty(historyFileName)
                && !historyFileName.endsWith(HISTORY_FILE_EXTENSION));
            {
                mHistoryFileName = historyFileName + HISTORY_FILE_EXTENSION;
            } 
            {
                mHistoryFileName = historyFileName;
            } 
        } 
        mPackageMonitor.register(mContext, true);
        
        
        
                
            
        
            
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.456 -0400", hash_original_method = "E9FF7BF71184D5918A5528B39387C05B", hash_generated_method = "0EBAA750D81BBC07F15435DF8D3CFF9F")
    public void setIntent(Intent intent) {
        {
            mIntent = intent;
            loadActivitiesLocked();
        } 
        
        
            
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.457 -0400", hash_original_method = "27A17A1D87D77EAA50C2FB6DFA94EC7A", hash_generated_method = "61FEA511DDC01F31EACEAD012B094E27")
    public Intent getIntent() {
        Intent varB4EAC82CA7396A68D541C85D26508E83_2032346325 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2032346325 = mIntent;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_2032346325.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2032346325;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.457 -0400", hash_original_method = "D90428775A0762F0AD6636514EC58022", hash_generated_method = "4AD77723E5C03CFE0F76417E93D497D2")
    public int getActivityCount() {
        {
            int var4413C4888B8E5E0960ECCEDD33A46240_333038491 = (mActivites.size());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378583432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_378583432;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.457 -0400", hash_original_method = "032146065CC1BA2D79ECD4CB63DFEC7F", hash_generated_method = "533314AEAE2498F685DBAB0172DD31E8")
    public ResolveInfo getActivity(int index) {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_2061226176 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2061226176 = mActivites.get(index).resolveInfo;
        } 
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2061226176.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2061226176;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.458 -0400", hash_original_method = "1C6D65F5A71D312AA7F7882C56EDED0B", hash_generated_method = "483AA36A23E1FA67D7DA98043A7B8DBE")
    public int getActivityIndex(ResolveInfo activity) {
        List<ActivityResolveInfo> activities = mActivites;
        final int activityCount = activities.size();
        {
            int i = 0;
            {
                ActivityResolveInfo currentActivity = activities.get(i);
            } 
        } 
        addTaint(activity.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866057773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1866057773;
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.459 -0400", hash_original_method = "2E1571A22B1C1279902BA9C2D35CCDAC", hash_generated_method = "458C27889FDAFBB63D99D1DBC0F7ACC9")
    public Intent chooseActivity(int index) {
        Intent varB4EAC82CA7396A68D541C85D26508E83_143201409 = null; 
        Intent varB4EAC82CA7396A68D541C85D26508E83_1669940509 = null; 
        ActivityResolveInfo chosenActivity = mActivites.get(index);
        ComponentName chosenName = new ComponentName(
                chosenActivity.resolveInfo.activityInfo.packageName,
                chosenActivity.resolveInfo.activityInfo.name);
        Intent choiceIntent = new Intent(mIntent);
        choiceIntent.setComponent(chosenName);
        {
            Intent choiceIntentCopy = new Intent(choiceIntent);
            final boolean handled = mActivityChoserModelPolicy.onChooseActivity(this,
                    choiceIntentCopy);
            {
                varB4EAC82CA7396A68D541C85D26508E83_143201409 = null;
            } 
        } 
        HistoricalRecord historicalRecord = new HistoricalRecord(chosenName,
                System.currentTimeMillis(), DEFAULT_HISTORICAL_RECORD_WEIGHT);
        addHisoricalRecord(historicalRecord);
        varB4EAC82CA7396A68D541C85D26508E83_1669940509 = choiceIntent;
        addTaint(index);
        Intent varA7E53CE21691AB073D9660D615818899_2110275514; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2110275514 = varB4EAC82CA7396A68D541C85D26508E83_143201409;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2110275514 = varB4EAC82CA7396A68D541C85D26508E83_1669940509;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2110275514.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2110275514;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.459 -0400", hash_original_method = "56E3863DC4DFDE24EBD2068470DB48E1", hash_generated_method = "502DB08B7514528D4C4579AC10A6BA23")
    public void setOnChooseActivityListener(OnChooseActivityListener listener) {
        mActivityChoserModelPolicy = listener;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.460 -0400", hash_original_method = "8C412D794940DE98F4AAE841092A3BC7", hash_generated_method = "AC80E5005EC5B741D9722FD2A95A0317")
    public ResolveInfo getDefaultActivity() {
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_919433228 = null; 
        ResolveInfo varB4EAC82CA7396A68D541C85D26508E83_793105194 = null; 
        {
            {
                boolean varF4409FAE14740E362411403D55FB8813_1039533176 = (!mActivites.isEmpty());
                {
                    varB4EAC82CA7396A68D541C85D26508E83_919433228 = mActivites.get(0).resolveInfo;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_793105194 = null;
        ResolveInfo varA7E53CE21691AB073D9660D615818899_589912012; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_589912012 = varB4EAC82CA7396A68D541C85D26508E83_919433228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_589912012 = varB4EAC82CA7396A68D541C85D26508E83_793105194;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_589912012.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_589912012;
        
        
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.460 -0400", hash_original_method = "6293689B582FC8E5AF147BEE230A1B37", hash_generated_method = "D1DBB09732C2AE259C22BE5178AC9528")
    public void setDefaultActivity(int index) {
        ActivityResolveInfo newDefaultActivity = mActivites.get(index);
        ActivityResolveInfo oldDefaultActivity = mActivites.get(0);
        float weight;
        {
            weight = oldDefaultActivity.weight - newDefaultActivity.weight
                + DEFAULT_ACTIVITY_INFLATION;
        } 
        {
            weight = DEFAULT_HISTORICAL_RECORD_WEIGHT;
        } 
        ComponentName defaultName = new ComponentName(
                newDefaultActivity.resolveInfo.activityInfo.packageName,
                newDefaultActivity.resolveInfo.activityInfo.name);
        HistoricalRecord historicalRecord = new HistoricalRecord(defaultName,
                System.currentTimeMillis(), weight);
        addHisoricalRecord(historicalRecord);
        addTaint(index);
        
        
        
        
        
            
                
        
            
        
        
                
                
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.461 -0400", hash_original_method = "79A1B7D3C52D92BAB878ED8275782ED6", hash_generated_method = "450F27A49681DF098B5C2143DE3387A0")
    private void readHistoricalData() {
        {
            mCanReadHistoricalData = false;
            mReadShareHistoryCalled = true;
            {
                boolean var5804576A691D9F5270256606BAE1902D_1715690429 = (!TextUtils.isEmpty(mHistoryFileName));
                {
                    AsyncTask.SERIAL_EXECUTOR.execute(new HistoryLoader());
                } 
            } 
        } 
        
        
            
                
            
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.461 -0400", hash_original_method = "50EE1C88911FEE4E5E828FE89316C1B7", hash_generated_method = "6F0970EC841F41B01544B9A2871AD67C")
    private void persistHistoricalData() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No preceding call to #readHistoricalData");
            } 
            mHistoricalRecordsChanged = false;
            mCanReadHistoricalData = true;
            {
                boolean var5804576A691D9F5270256606BAE1902D_1187156299 = (!TextUtils.isEmpty(mHistoryFileName));
                {
                    AsyncTask.SERIAL_EXECUTOR.execute(new HistoryPersister());
                } 
            } 
        } 
        
        
            
                
            
            
                
            
            
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.462 -0400", hash_original_method = "4FD548D8FB7638BF40234ABBB5D78544", hash_generated_method = "984A0D2F5FF617C13FFADE71CD64A8B3")
    public void setActivitySorter(ActivitySorter activitySorter) {
        {
            mActivitySorter = activitySorter;
            sortActivities();
        } 
        
        
            
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.462 -0400", hash_original_method = "B440CA3B13B34DB5E9312802F4C1443D", hash_generated_method = "C80E405750C601E300AF2DBCBC46B42D")
    private void sortActivities() {
        {
            {
                boolean varB5E7D1783EA2374EC2C1EE44024C2179_310810366 = (mActivitySorter != null && !mActivites.isEmpty());
                {
                    mActivitySorter.sort(mIntent, mActivites,
                        Collections.unmodifiableList(mHistoricalRecords));
                    notifyChanged();
                } 
            } 
        } 
        
        
            
                
                        
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.462 -0400", hash_original_method = "1F530ED27C984DBDEEC1EB526F5DD126", hash_generated_method = "56AB4F0711BC913DA0F690575C1A5B20")
    public void setHistoryMaxSize(int historyMaxSize) {
        {
            mHistoryMaxSize = historyMaxSize;
            pruneExcessiveHistoricalRecordsLocked();
            sortActivities();
        } 
        
        
            
                
            
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.463 -0400", hash_original_method = "EBCBD4C754CE0391425067ED25453667", hash_generated_method = "2DFAD9DF92F47A328C34E3910423904C")
    public int getHistoryMaxSize() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450147795 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_450147795;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.463 -0400", hash_original_method = "9F4BBC1AE7ECE6B5427CA6E0430F86F9", hash_generated_method = "CF16703E7DF837A1CDDE89F6FD61EE62")
    public int getHistorySize() {
        {
            int varE74BD067CCB63FDD155B3322AFBF873C_394531727 = (mHistoricalRecords.size());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055604038 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2055604038;
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.463 -0400", hash_original_method = "37F72BEA9084083CB35C7BD83368023D", hash_generated_method = "C5E6738DAFC973D5C650FCF6D89CF2D3")
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        mPackageMonitor.unregister();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.464 -0400", hash_original_method = "50B8FA4A00A0FC54414B26FDB0055015", hash_generated_method = "9A07F85537A420DB2685695D35ED3167")
    private boolean addHisoricalRecord(HistoricalRecord historicalRecord) {
        {
            final boolean added = mHistoricalRecords.add(historicalRecord);
            {
                mHistoricalRecordsChanged = true;
                pruneExcessiveHistoricalRecordsLocked();
                persistHistoricalData();
                sortActivities();
            } 
        } 
        addTaint(historicalRecord.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1802402835 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1802402835;
        
        
            
            
                
                
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.464 -0400", hash_original_method = "84DEA752877B716573664E1E2DB7F950", hash_generated_method = "4F87A8861316591883B21F32D617ED33")
    private void pruneExcessiveHistoricalRecordsLocked() {
        List<HistoricalRecord> choiceRecords = mHistoricalRecords;
        final int pruneCount = choiceRecords.size() - mHistoryMaxSize;
        mHistoricalRecordsChanged = true;
        {
            int i = 0;
            {
                HistoricalRecord prunedRecord = choiceRecords.remove(0);
            } 
        } 
        
        
        
        
            
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.464 -0400", hash_original_method = "CE097995E3DDE01957F3BEF111DCC08A", hash_generated_method = "3B941CF71597E0CF3F4BFAA20489F1A1")
    private void loadActivitiesLocked() {
        mActivites.clear();
        {
            List<ResolveInfo> resolveInfos = mContext.getPackageManager().queryIntentActivities(mIntent, 0);
            final int resolveInfoCount = resolveInfos.size();
            {
                int i = 0;
                {
                    ResolveInfo resolveInfo = resolveInfos.get(i);
                    mActivites.add(new ActivityResolveInfo(resolveInfo));
                } 
            } 
            sortActivities();
        } 
        {
            notifyChanged();
        } 
        
        
        
            
                
            
            
                
                
            
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.465 -0400", hash_original_method = "A58F8162E2D66FE48738B2459230A97A", hash_generated_method = "62EC9FCF3A1F577278BA04257DF65398")
    private void pruneHistoricalRecordsForPackageLocked(String packageName) {
        boolean recordsRemoved = false;
        List<HistoricalRecord> historicalRecords = mHistoricalRecords;
        {
            int i = 0;
            boolean varBE0151D4849F874558D3B97ACF98DD7B_1036662650 = (i < historicalRecords.size());
            {
                HistoricalRecord historicalRecord = historicalRecords.get(i);
                String recordPackageName = historicalRecord.activity.getPackageName();
                {
                    boolean varF0A69CA6ED747107A9EF432C02BA36BD_1970120966 = (recordPackageName.equals(packageName));
                    {
                        historicalRecords.remove(historicalRecord);
                        recordsRemoved = true;
                    } 
                } 
            } 
        } 
        {
            mHistoricalRecordsChanged = true;
            sortActivities();
        } 
        addTaint(packageName.getTaint());
        
        
        
        
            
            
            
                
                
            
        
        
            
            
        
    }

    
    public final static class HistoricalRecord {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.465 -0400", hash_original_field = "69A256025F66E4CE5D15C9DD7225D357", hash_generated_field = "E9F78AFB95D47915FCC3FF74E33CC6C3")

        public ComponentName activity;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.465 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "5A44367B7C554CE37EA61A01D45FAC73")

        public long time;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.465 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public float weight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.465 -0400", hash_original_method = "1C86724BE7B708067898B3EC6CC9E920", hash_generated_method = "00040F0E8D55D727A5B7BC80D0968951")
        public  HistoricalRecord(String activityName, long time, float weight) {
            this(ComponentName.unflattenFromString(activityName), time, weight);
            addTaint(activityName.getTaint());
            addTaint(time);
            addTaint(weight);
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.465 -0400", hash_original_method = "15F3A03D01E02908C99E8CDDD520EB93", hash_generated_method = "039A30ECAF845160B7B36EDE95851CB2")
        public  HistoricalRecord(ComponentName activityName, long time, float weight) {
            this.activity = activityName;
            this.time = time;
            this.weight = weight;
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.466 -0400", hash_original_method = "4E1A48E49166529A0B7FC03866764063", hash_generated_method = "DECEDA4FEE120F67B43F0F1D5467099C")
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((activity == null) ? 0 : activity.hashCode());
            result = prime * result + (int) (time ^ (time >>> 32));
            result = prime * result + Float.floatToIntBits(weight);
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_788408772 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_788408772;
            
            
            
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.466 -0400", hash_original_method = "B85F0FF6FF50850EA2189DB29FD09D21", hash_generated_method = "4C18CF315507DD616255FD0F00F83D30")
        @Override
        public boolean equals(Object obj) {
            {
                boolean varF071958F831141DD4937960A9F520909_41957313 = (getClass() != obj.getClass());
            } 
            HistoricalRecord other = (HistoricalRecord) obj;
            {
                boolean var6E1AC62E0C5F0574834B43B3C6FB54B7_951800108 = (!activity.equals(other.activity));
            } 
            {
                boolean var0EC1079F899BEB4CC63FE5981A8E170A_1421719577 = (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight));
            } 
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231063222 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231063222;
            
            
                
            
            
                
            
            
                
            
            
            
                
                    
                
            
                
            
            
                
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.467 -0400", hash_original_method = "DE8206875FA4E924E296C5ACB6D7F3F2", hash_generated_method = "FE6D0D1E5A7DADFBD0C07939E654340A")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1492338387 = null; 
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("; activity:").append(activity);
            builder.append("; time:").append(time);
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
            varB4EAC82CA7396A68D541C85D26508E83_1492338387 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1492338387.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1492338387;
            
            
            
            
            
            
            
            
        }

        
    }


    
    public final class ActivityResolveInfo implements Comparable<ActivityResolveInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.467 -0400", hash_original_field = "C00A4654C3CFD33861C7CC1FD2D3713F", hash_generated_field = "42ACA7D028AD018D3FE2BFC3E32F6A75")

        public ResolveInfo resolveInfo;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.467 -0400", hash_original_field = "7EDABF994B76A00CBC60C95AF337DB8F", hash_generated_field = "5E0BED1FCBFF5A96E07202027E15BAE7")

        public float weight;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.467 -0400", hash_original_method = "FE163077B7530186AE819FA48AA47F8E", hash_generated_method = "5FF0866FAB3426E950C36794AFE28F97")
        public  ActivityResolveInfo(ResolveInfo resolveInfo) {
            this.resolveInfo = resolveInfo;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.468 -0400", hash_original_method = "F192571EE56F5C4051616CB9861F74E4", hash_generated_method = "074EDD7D7DA7B2F223895BF50F7A4544")
        @Override
        public int hashCode() {
            int varB15BFDB6118FAFD3CC127562D11D77C0_1976679480 = (31 + Float.floatToIntBits(weight));
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047171275 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2047171275;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.468 -0400", hash_original_method = "FF799F5AAE6D6CF88DAF4502D583A290", hash_generated_method = "5537CA58144B9EF5DF31307933749F55")
        @Override
        public boolean equals(Object obj) {
            {
                boolean varF071958F831141DD4937960A9F520909_1424937880 = (getClass() != obj.getClass());
            } 
            ActivityResolveInfo other = (ActivityResolveInfo) obj;
            {
                boolean var0EC1079F899BEB4CC63FE5981A8E170A_1672656346 = (Float.floatToIntBits(weight) != Float.floatToIntBits(other.weight));
            } 
            addTaint(obj.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_937164956 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_937164956;
            
            
                
            
            
                
            
            
                
            
            
            
                
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.469 -0400", hash_original_method = "05EB01A51A0727988F01FD1C25038E23", hash_generated_method = "1345012F3D22D87A3245C0AA7325BC8D")
        public int compareTo(ActivityResolveInfo another) {
            int var5BBE0592BEB3EA28EEF75B5000201B3C_1824600906 = (Float.floatToIntBits(another.weight) - Float.floatToIntBits(weight));
            addTaint(another.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052189190 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1052189190;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.469 -0400", hash_original_method = "6B7079774B733597AE380820B7605540", hash_generated_method = "C0C36A4289F2734270EF3F02AA4ECA84")
        @Override
        public String toString() {
            String varB4EAC82CA7396A68D541C85D26508E83_1330471682 = null; 
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            builder.append("resolveInfo:").append(resolveInfo.toString());
            builder.append("; weight:").append(new BigDecimal(weight));
            builder.append("]");
            varB4EAC82CA7396A68D541C85D26508E83_1330471682 = builder.toString();
            varB4EAC82CA7396A68D541C85D26508E83_1330471682.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1330471682;
            
            
            
            
            
            
            
        }

        
    }


    
    private final class DefaultSorter implements ActivitySorter {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.470 -0400", hash_original_field = "607FF895363E04DFCB9D5664F60B57F0", hash_generated_field = "36A2609728A36E5BA82D7C988AE5AE60")

        private final Map<String, ActivityResolveInfo> mPackageNameToActivityMap = new HashMap<String, ActivityResolveInfo>();
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.470 -0400", hash_original_method = "4BF496988E00827DD1484620E43167BF", hash_generated_method = "4BF496988E00827DD1484620E43167BF")
        public DefaultSorter ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.471 -0400", hash_original_method = "1983622E810CF2F16D5FB85B8E79AAA7", hash_generated_method = "2BA0A4A76835209156910279E539A71A")
        public void sort(Intent intent, List<ActivityResolveInfo> activities,
                List<HistoricalRecord> historicalRecords) {
            Map<String, ActivityResolveInfo> packageNameToActivityMap = mPackageNameToActivityMap;
            packageNameToActivityMap.clear();
            final int activityCount = activities.size();
            {
                int i = 0;
                {
                    ActivityResolveInfo activity = activities.get(i);
                    activity.weight = 0.0f;
                    String packageName = activity.resolveInfo.activityInfo.packageName;
                    packageNameToActivityMap.put(packageName, activity);
                } 
            } 
            final int lastShareIndex = historicalRecords.size() - 1;
            float nextRecordWeight = 1;
            {
                int i = lastShareIndex;
                {
                    HistoricalRecord historicalRecord = historicalRecords.get(i);
                    String packageName = historicalRecord.activity.getPackageName();
                    ActivityResolveInfo activity = packageNameToActivityMap.get(packageName);
                    {
                        activity.weight += historicalRecord.weight * nextRecordWeight;
                        nextRecordWeight = nextRecordWeight * WEIGHT_DECAY_COEFFICIENT;
                    } 
                } 
            } 
            Collections.sort(activities);
            {
                {
                    int i = 0;
                } 
            } 
            addTaint(intent.getTaint());
            addTaint(activities.getTaint());
            addTaint(historicalRecords.getTaint());
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.472 -0400", hash_original_field = "16755C1D312376513A05EE549649A996", hash_generated_field = "80DD4E6EDFEAE82BDC0A595B5F72F371")

        private static final float WEIGHT_DECAY_COEFFICIENT = 0.95f;
    }


    
    private final class HistoryLoader implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.472 -0400", hash_original_method = "0F6CF60457783C48329031B15DA96823", hash_generated_method = "0F6CF60457783C48329031B15DA96823")
        public HistoryLoader ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.474 -0400", hash_original_method = "C7992FBC3712621E8BB422FE384E294B", hash_generated_method = "0AFCF3FC2A37E7BC1BE10F17108D7F3E")
        public void run() {
            FileInputStream fis = null;
            try 
            {
                fis = mContext.openFileInput(mHistoryFileName);
            } 
            catch (FileNotFoundException fnfe)
            { }
            try 
            {
                XmlPullParser parser = Xml.newPullParser();
                parser.setInput(fis, null);
                int type = XmlPullParser.START_DOCUMENT;
                {
                    type = parser.next();
                } 
                {
                    boolean var1249786F987A59B50F6E7EA2A4AB531E_1330597937 = (!TAG_HISTORICAL_RECORDS.equals(parser.getName()));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Share records file does not start with "
                            + TAG_HISTORICAL_RECORDS + " tag.");
                    } 
                } 
                List<HistoricalRecord> readRecords = new ArrayList<HistoricalRecord>();
                {
                    type = parser.next();
                    String nodeName = parser.getName();
                    {
                        boolean varE9687D88833662E84EEF04B8B0A9A85E_345381502 = (!TAG_HISTORICAL_RECORD.equals(nodeName));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new XmlPullParserException("Share records file not well-formed.");
                        } 
                    } 
                    String activity = parser.getAttributeValue(null, ATTRIBUTE_ACTIVITY);
                    final long time = Long.parseLong(parser.getAttributeValue(null, ATTRIBUTE_TIME));
                    final float weight = Float.parseFloat(parser.getAttributeValue(null, ATTRIBUTE_WEIGHT));
                    HistoricalRecord readRecord = new HistoricalRecord(activity, time,
                            weight);
                    readRecords.add(readRecord);
                } 
                {
                    Set<HistoricalRecord> uniqueShareRecords = new LinkedHashSet<HistoricalRecord>(readRecords);
                    List<HistoricalRecord> historicalRecords = mHistoricalRecords;
                    final int historicalRecordsCount = historicalRecords.size();
                    {
                        int i = historicalRecordsCount - 1;
                        {
                            HistoricalRecord historicalRecord = historicalRecords.get(i);
                            uniqueShareRecords.add(historicalRecord);
                        } 
                    } 
                    {
                        boolean varC2A990ED21E2616B83A41814FE1721C8_1740904389 = (historicalRecords.size() == uniqueShareRecords.size());
                    } 
                    historicalRecords.clear();
                    historicalRecords.addAll(uniqueShareRecords);
                    mHistoricalRecordsChanged = true;
                    mHandler.post(new Runnable() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.473 -0400", hash_original_method = "7B5BE6A8F3CF3144B75BD698B249F235", hash_generated_method = "0CE57F01674CAFE17F3300F39AA005DE")
                        public void run() {
                            pruneExcessiveHistoricalRecordsLocked();
                            sortActivities();
                            
                            
                            
                        }
});
                } 
            } 
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
                    } 
                    catch (IOException ioe)
                    { }
                } 
            } 
            
            
        }

        
    }


    
    private final class HistoryPersister implements Runnable {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.474 -0400", hash_original_method = "F652F13A8701B98B9D8C3619B90FF892", hash_generated_method = "F652F13A8701B98B9D8C3619B90FF892")
        public HistoryPersister ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.474 -0400", hash_original_method = "56491CDA5DB122242C8DDE4A7A87359C", hash_generated_method = "308E41222A65CAF00A6C6BF71B00BBC5")
        public void run() {
            FileOutputStream fos = null;
            List<HistoricalRecord> records = null;
            {
                records = new ArrayList<HistoricalRecord>(mHistoricalRecords);
            } 
            try 
            {
                fos = mContext.openFileOutput(mHistoryFileName, Context.MODE_PRIVATE);
            } 
            catch (FileNotFoundException fnfe)
            { }
            XmlSerializer serializer = Xml.newSerializer();
            try 
            {
                serializer.setOutput(fos, null);
                serializer.startDocument("UTF-8", true);
                serializer.startTag(null, TAG_HISTORICAL_RECORDS);
                final int recordCount = records.size();
                {
                    int i = 0;
                    {
                        HistoricalRecord record = records.remove(0);
                        serializer.startTag(null, TAG_HISTORICAL_RECORD);
                        serializer.attribute(null, ATTRIBUTE_ACTIVITY, record.activity.flattenToString());
                        serializer.attribute(null, ATTRIBUTE_TIME, String.valueOf(record.time));
                        serializer.attribute(null, ATTRIBUTE_WEIGHT, String.valueOf(record.weight));
                        serializer.endTag(null, TAG_HISTORICAL_RECORD);
                    } 
                } 
                serializer.endTag(null, TAG_HISTORICAL_RECORDS);
                serializer.endDocument();
            } 
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
                    } 
                    catch (IOException e)
                    { }
                } 
            } 
            
            
        }

        
    }


    
    private final class DataModelPackageMonitor extends PackageMonitor {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.475 -0400", hash_original_method = "7270678089AB03BAD6BBDC9C3DB17F70", hash_generated_method = "7270678089AB03BAD6BBDC9C3DB17F70")
        public DataModelPackageMonitor ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.475 -0400", hash_original_method = "C89F5C92B68E48D5DAFC93C690A3926A", hash_generated_method = "127949E8392499FAAB32F5B8715F8E57")
        @Override
        public void onPackageAdded(String packageName, int uid) {
            
            {
                loadActivitiesLocked();
            } 
            addTaint(packageName.getTaint());
            addTaint(uid);
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.475 -0400", hash_original_method = "E08DC591D228402C0DBF164DF68C0AF4", hash_generated_method = "6A7F66E2249654D73D8F49B5D6C37D3D")
        @Override
        public void onPackageAppeared(String packageName, int reason) {
            
            {
                loadActivitiesLocked();
            } 
            addTaint(packageName.getTaint());
            addTaint(reason);
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.475 -0400", hash_original_method = "A7BE115B10A66075A04B7082DDA7D411", hash_generated_method = "A273A0162799B58D7FFE22F810428893")
        @Override
        public void onPackageRemoved(String packageName, int uid) {
            
            {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            } 
            addTaint(packageName.getTaint());
            addTaint(uid);
            
            
                
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_method = "31BBEB936625AC985495016944655B18", hash_generated_method = "87BF23817ACDAD063A7CCCC4CE2944EB")
        @Override
        public void onPackageDisappeared(String packageName, int reason) {
            
            {
                pruneHistoricalRecordsForPackageLocked(packageName);
                loadActivitiesLocked();
            } 
            addTaint(packageName.getTaint());
            addTaint(reason);
            
            
                
                
            
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "FA52ACD91A762EFB98C64E6F734C4D25", hash_generated_field = "C0E6428FC538C3E98CD4F3F3FD104AD3")

    private static final String LOG_TAG = ActivityChooserModel.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "00C1CCA963C81A7DDA58A626A1979DA3", hash_generated_field = "2F78BC6BF3EA40EEBFAAF4062888B202")

    private static final String TAG_HISTORICAL_RECORDS = "historical-records";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "3ADAAE105DC8F21BB7CBEC47C1D0DFF1", hash_generated_field = "B57E7DC30CE2B7036D338B99DE1C8F4A")

    private static final String TAG_HISTORICAL_RECORD = "historical-record";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "E13990A37ACBE7F78BA9E552D603F5DB", hash_generated_field = "4F997BDD322ABDE394E143C88BE19902")

    private static final String ATTRIBUTE_ACTIVITY = "activity";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "B3485642830D4FB7BF523D4CAE813482", hash_generated_field = "4657BA7339C2DB58947DE9CCAAA8BCAF")

    private static final String ATTRIBUTE_TIME = "time";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "76190CA68A0DCC92E3A7C066E8CF1F70", hash_generated_field = "8399470D08376E2A59EAC9C79DB79A9E")

    private static final String ATTRIBUTE_WEIGHT = "weight";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "3618283F5DC227BE959D6205ABF93B15", hash_generated_field = "C17F091D6E1676968D87EC382F2A60E4")

    public static final String DEFAULT_HISTORY_FILE_NAME =
        "activity_choser_model_history.xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "47FB681069105B0255362C4BF4AB6E51", hash_generated_field = "51D1ECB43E515D53A9B4473F163B06AD")

    public static final int DEFAULT_HISTORY_MAX_LENGTH = 50;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "1B36629D46050C4AA3148B77E1702985", hash_generated_field = "450784023A27CD5EC5CEF077D5E372FC")

    private static final int DEFAULT_ACTIVITY_INFLATION = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "AAFA76E029DEFAF3CD45DE63256FBD8F", hash_generated_field = "48D4985B801C29FF4FB9AF6C46ABE846")

    private static final float DEFAULT_HISTORICAL_RECORD_WEIGHT = 1.0f;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "52CBB06050E39D454BA51CF00CA0F2D1", hash_generated_field = "5BDD81AF45C2360A5D0488EF180F0B0E")

    private static final String HISTORY_FILE_EXTENSION = ".xml";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "8C5E8C33309913A25C19F3D2DD557C14", hash_generated_field = "19F556E730E88DC545CC4ADD400592D6")

    private static final int INVALID_INDEX = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "2BB5CE89E396F79FD8627F7C142D6CEE", hash_generated_field = "922B32A26FF0AAB23FEB7772C78F88BB")

    private static final Object sRegistryLock = new Object();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:09.476 -0400", hash_original_field = "CBDE1B68888BEC0836ED7A9E864923C7", hash_generated_field = "BB4344C9185B0C58F3786BE4083DEBFE")

    private static final Map<String, ActivityChooserModel> sDataModelRegistry = new HashMap<String, ActivityChooserModel>();
}

