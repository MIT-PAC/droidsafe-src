package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import android.os.Handler;
import android.preference.Preference.OnPreferenceChangeInternalListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

class PreferenceGroupAdapter extends BaseAdapter implements OnPreferenceChangeInternalListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.627 -0400", hash_original_field = "60A1F576EA55DAAA9B029C3300F68D2D", hash_generated_field = "9E796A8BD15586231740457EF37FD47D")

    private PreferenceGroup mPreferenceGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.627 -0400", hash_original_field = "49E5F06342B9A756471C57C41582CFFB", hash_generated_field = "18F192958EC897931FD8B3DA5BF85A77")

    private List<Preference> mPreferenceList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.627 -0400", hash_original_field = "B17D80C739620B94B645CF4C17A79E8D", hash_generated_field = "DA3004DA159CA709DF746F6CEC7DBE4F")

    private ArrayList<PreferenceLayout> mPreferenceLayouts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.627 -0400", hash_original_field = "0EA8349A74250C961790E8C2CB2711B0", hash_generated_field = "21E20E055E82593BC0F10B12A6DDF8CB")

    private PreferenceLayout mTempPreferenceLayout = new PreferenceLayout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.627 -0400", hash_original_field = "EC716D907E12FB2C66058C9510972CEE", hash_generated_field = "68E5BAC937AEA9D08E6032C8918801F2")

    private boolean mHasReturnedViewTypeCount = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.628 -0400", hash_original_field = "ACF05BEDD3E446A1812760F79FD88601", hash_generated_field = "8BB536959B4C4BC77100BFD82203560A")

    private volatile boolean mIsSyncing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.628 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.482 -0400", hash_original_field = "A759A4E7184E3E83FC4B81BC91EB49E4", hash_generated_field = "6F8F5735F15B9F1306F9CF88A1481F4F")

    private Runnable mSyncRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.482 -0400", hash_original_method = "64E55F1CB25012944C9000EFC5F6389C", hash_generated_method = "098280FA3EF6FEBB87417E5331607D15")
        public void run() {
            syncMyPreferences();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.628 -0400", hash_original_method = "B0DE4241F694B745A6B6018AB0FE0031", hash_generated_method = "2348D0E06D92E9723DB46FBB01A918CF")
    public  PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        mPreferenceGroup = preferenceGroup;
        mPreferenceGroup.setOnPreferenceChangeInternalListener(this);
        mPreferenceList = new ArrayList<Preference>();
        mPreferenceLayouts = new ArrayList<PreferenceLayout>();
        syncMyPreferences();
        // ---------- Original Method ----------
        //mPreferenceGroup = preferenceGroup;
        //mPreferenceGroup.setOnPreferenceChangeInternalListener(this);
        //mPreferenceList = new ArrayList<Preference>();
        //mPreferenceLayouts = new ArrayList<PreferenceLayout>();
        //syncMyPreferences();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.629 -0400", hash_original_method = "47CAC8934A77F33A41B8A2FADE539715", hash_generated_method = "F3A53D7C099FEB4F6A2629ADC6016B62")
    private void syncMyPreferences() {
        synchronized
(this)        {
            if(mIsSyncing)            
            {
                return;
            } //End block
            mIsSyncing = true;
        } //End block
        List<Preference> newPreferenceList = new ArrayList<Preference>(mPreferenceList.size());
        flattenPreferenceGroup(newPreferenceList, mPreferenceGroup);
        mPreferenceList = newPreferenceList;
        notifyDataSetChanged();
        synchronized
(this)        {
            mIsSyncing = false;
            notifyAll();
        } //End block
        // ---------- Original Method ----------
        //synchronized(this) {
            //if (mIsSyncing) {
                //return;
            //}
            //mIsSyncing = true;
        //}
        //List<Preference> newPreferenceList = new ArrayList<Preference>(mPreferenceList.size());
        //flattenPreferenceGroup(newPreferenceList, mPreferenceGroup);
        //mPreferenceList = newPreferenceList;
        //notifyDataSetChanged();
        //synchronized(this) {
            //mIsSyncing = false;
            //notifyAll();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.630 -0400", hash_original_method = "DB0831C85843D6D53F9495F3413A2CE3", hash_generated_method = "AC060DC7A703230347A68E0AE9FC84D9")
    private void flattenPreferenceGroup(List<Preference> preferences, PreferenceGroup group) {
        addTaint(group.getTaint());
        addTaint(preferences.getTaint());
        group.sortPreferences();
        final int groupSize = group.getPreferenceCount();
for(int i = 0;i < groupSize;i++)
        {
            final Preference preference = group.getPreference(i);
            preferences.add(preference);
            if(!mHasReturnedViewTypeCount && !preference.hasSpecifiedLayout())            
            {
                addPreferenceClassName(preference);
            } //End block
            if(preference instanceof PreferenceGroup)            
            {
                final PreferenceGroup preferenceAsGroup = (PreferenceGroup) preference;
                if(preferenceAsGroup.isOnSameScreenAsChildren())                
                {
                    flattenPreferenceGroup(preferences, preferenceAsGroup);
                } //End block
            } //End block
            preference.setOnPreferenceChangeInternalListener(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.631 -0400", hash_original_method = "B927BA6712254BD5B8D47CF220E79C5B", hash_generated_method = "3EC6F6F9056CD7B0629D22F19E0426B8")
    private PreferenceLayout createPreferenceLayout(Preference preference, PreferenceLayout in) {
        addTaint(in.getTaint());
        addTaint(preference.getTaint());
        PreferenceLayout pl = in != null? in : new PreferenceLayout();
        pl.name = preference.getClass().getName();
        pl.resId = preference.getLayoutResource();
        pl.widgetResId = preference.getWidgetLayoutResource();
PreferenceLayout var08A2C4A72E6D9753FFB2150962070B4D_959762402 =         pl;
        var08A2C4A72E6D9753FFB2150962070B4D_959762402.addTaint(taint);
        return var08A2C4A72E6D9753FFB2150962070B4D_959762402;
        // ---------- Original Method ----------
        //PreferenceLayout pl = in != null? in : new PreferenceLayout();
        //pl.name = preference.getClass().getName();
        //pl.resId = preference.getLayoutResource();
        //pl.widgetResId = preference.getWidgetLayoutResource();
        //return pl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.631 -0400", hash_original_method = "22004160B58BE5F5ED0505DF7AB89FF1", hash_generated_method = "76F09BBEB7638D778C7524FBBD4DA8B2")
    private void addPreferenceClassName(Preference preference) {
        addTaint(preference.getTaint());
        final PreferenceLayout pl = createPreferenceLayout(preference, null);
        int insertPos = Collections.binarySearch(mPreferenceLayouts, pl);
        if(insertPos < 0)        
        {
            insertPos = insertPos * -1 - 1;
            mPreferenceLayouts.add(insertPos, pl);
        } //End block
        // ---------- Original Method ----------
        //final PreferenceLayout pl = createPreferenceLayout(preference, null);
        //int insertPos = Collections.binarySearch(mPreferenceLayouts, pl);
        //if (insertPos < 0) {
            //insertPos = insertPos * -1 - 1;
            //mPreferenceLayouts.add(insertPos, pl);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.631 -0400", hash_original_method = "146D9A3F8F2485F6100744DF28993915", hash_generated_method = "6FCE11A59206599ADBCF318A61EF6C4E")
    public int getCount() {
        int varC421430EA712BB31552DDD51082F5040_1012360867 = (mPreferenceList.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056735467 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056735467;
        // ---------- Original Method ----------
        //return mPreferenceList.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.632 -0400", hash_original_method = "B1551AF468D615637FECD6277399376D", hash_generated_method = "11D4E095D4C707ECEB591312A6836347")
    public Preference getItem(int position) {
        addTaint(position);
        if(position < 0 || position >= getCount())        
        {
Preference var540C13E9E156B687226421B24F2DF178_1738846479 =         null;
        var540C13E9E156B687226421B24F2DF178_1738846479.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1738846479;
        }
Preference varC00C7940BC9F3D49E69E634FDBA25534_1563310662 =         mPreferenceList.get(position);
        varC00C7940BC9F3D49E69E634FDBA25534_1563310662.addTaint(taint);
        return varC00C7940BC9F3D49E69E634FDBA25534_1563310662;
        // ---------- Original Method ----------
        //if (position < 0 || position >= getCount()) return null;
        //return mPreferenceList.get(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.632 -0400", hash_original_method = "C2BB649F8AE8B2BA22DD6170BF8090F3", hash_generated_method = "616E262164316CE57165895EBFB5FC1D")
    public long getItemId(int position) {
        addTaint(position);
        if(position < 0 || position >= getCount())        
        {
        long var846671D8A4B86FA5CCE80364B710CCB1_1976269278 = (ListView.INVALID_ROW_ID);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1167023297 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1167023297;
        }
        long var59A7DB87FD3D5E8E8EFFF8EDCCC92635_322938502 = (this.getItem(position).getId());
                long var0F5264038205EDFB1AC05FBB0E8C5E94_559021080 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_559021080;
        // ---------- Original Method ----------
        //if (position < 0 || position >= getCount()) return ListView.INVALID_ROW_ID;
        //return this.getItem(position).getId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.633 -0400", hash_original_method = "0A6038B272F94F277CAFD95B96B15A1A", hash_generated_method = "4F88FE597FF9993C2EE8DA4F2A156131")
    public View getView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
        final Preference preference = this.getItem(position);
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        if(Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout) < 0)        
        {
            convertView = null;
        } //End block
View var120D4AB100F80F068E5DB1FAB11D521C_1628782937 =         preference.getView(convertView, parent);
        var120D4AB100F80F068E5DB1FAB11D521C_1628782937.addTaint(taint);
        return var120D4AB100F80F068E5DB1FAB11D521C_1628782937;
        // ---------- Original Method ----------
        //final Preference preference = this.getItem(position);
        //mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        //if (Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout) < 0) {
            //convertView = null;
        //}
        //return preference.getView(convertView, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.633 -0400", hash_original_method = "ED75A4DEF716F8048DFD61CCEF0A4510", hash_generated_method = "753153818B4D45B9E00A94F853B45BEC")
    @Override
    public boolean isEnabled(int position) {
        addTaint(position);
        if(position < 0 || position >= getCount())        
        {
        boolean varB326B5062B2F0E69046810717534CB09_753834097 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1112725767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1112725767;
        }
        boolean var9ED7D97E3459E2D24DE2FF96EC461932_1039587874 = (this.getItem(position).isSelectable());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1196669480 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1196669480;
        // ---------- Original Method ----------
        //if (position < 0 || position >= getCount()) return true;
        //return this.getItem(position).isSelectable();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.633 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "8FE13C3393A6D0545564BB0191A1B22C")
    @Override
    public boolean areAllItemsEnabled() {
        boolean var68934A3E9455FA72420237EB05902327_452080667 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_161340637 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_161340637;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.634 -0400", hash_original_method = "C2E233D65C74168849EC7AB5F1A2D9C0", hash_generated_method = "91145FFBCBC5AF1D9C0E8E0FB2D9A366")
    public void onPreferenceChange(Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(preference.getTaint());
        notifyDataSetChanged();
        // ---------- Original Method ----------
        //notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.634 -0400", hash_original_method = "96B325BF777CE525D2D64038C1261EF1", hash_generated_method = "7FED000FF54A66B7C90459DCE8D8A82C")
    public void onPreferenceHierarchyChange(Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(preference.getTaint());
        mHandler.removeCallbacks(mSyncRunnable);
        mHandler.post(mSyncRunnable);
        // ---------- Original Method ----------
        //mHandler.removeCallbacks(mSyncRunnable);
        //mHandler.post(mSyncRunnable);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.634 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "47252A2835FA024B4F1F4F98CAC94910")
    @Override
    public boolean hasStableIds() {
        boolean varB326B5062B2F0E69046810717534CB09_205993848 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_552158494 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_552158494;
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.635 -0400", hash_original_method = "95969FB891958AA0335CF8E62A1ABF37", hash_generated_method = "1D0A9ECAAEC7CCBE9C06E73E809B4C76")
    @Override
    public int getItemViewType(int position) {
        addTaint(position);
        if(!mHasReturnedViewTypeCount)        
        {
            mHasReturnedViewTypeCount = true;
        } //End block
        final Preference preference = this.getItem(position);
        if(preference.hasSpecifiedLayout())        
        {
            int varFEBA93B0789497EBEDEB09E7A2E12E05_103987029 = (IGNORE_ITEM_VIEW_TYPE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895248117 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_895248117;
        } //End block
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        int viewType = Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout);
        if(viewType < 0)        
        {
            int varFEBA93B0789497EBEDEB09E7A2E12E05_884779753 = (IGNORE_ITEM_VIEW_TYPE);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996386270 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996386270;
        } //End block
        else
        {
            int varBE99FDADF4634E48B1DF67A9485E0784_1189079419 = (viewType);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862022257 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1862022257;
        } //End block
        // ---------- Original Method ----------
        //if (!mHasReturnedViewTypeCount) {
            //mHasReturnedViewTypeCount = true;
        //}
        //final Preference preference = this.getItem(position);
        //if (preference.hasSpecifiedLayout()) {
            //return IGNORE_ITEM_VIEW_TYPE;
        //}
        //mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        //int viewType = Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout);
        //if (viewType < 0) {
            //return IGNORE_ITEM_VIEW_TYPE;
        //} else {
            //return viewType;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.635 -0400", hash_original_method = "C26A2133E7F568EC0AF4EC87BB082A79", hash_generated_method = "760C45B260063E29B8851C0F0C8A868B")
    @Override
    public int getViewTypeCount() {
        if(!mHasReturnedViewTypeCount)        
        {
            mHasReturnedViewTypeCount = true;
        } //End block
        int var929537438D74B8A936F7559129C853BD_1890944454 = (Math.max(1, mPreferenceLayouts.size()));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495949537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_495949537;
        // ---------- Original Method ----------
        //if (!mHasReturnedViewTypeCount) {
            //mHasReturnedViewTypeCount = true;
        //}
        //return Math.max(1, mPreferenceLayouts.size());
    }

    
    private static class PreferenceLayout implements Comparable<PreferenceLayout> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.636 -0400", hash_original_field = "C0179AEDB850805806A31BDC39510289", hash_generated_field = "D57D54CAC1273148C7462B42AF5839E3")

        private int resId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.636 -0400", hash_original_field = "2888237166571D1285BA13E4324E3AEE", hash_generated_field = "C72CD28C67C0D0B9F30E5D9DB8173BFF")

        private int widgetResId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.636 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.636 -0400", hash_original_method = "12E8ADB8C3EE61AC77B7A82A93B07078", hash_generated_method = "12E8ADB8C3EE61AC77B7A82A93B07078")
        public PreferenceLayout ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.636 -0400", hash_original_method = "0A98309F64E867E673B1B3CFC2DB79CE", hash_generated_method = "64FB0F323E87440ACC46A822E55229EE")
        public int compareTo(PreferenceLayout other) {
            addTaint(other.getTaint());
            int compareNames = name.compareTo(other.name);
            if(compareNames == 0)            
            {
                if(resId == other.resId)                
                {
                    if(widgetResId == other.widgetResId)                    
                    {
                        int varCFCD208495D565EF66E7DFF9F98764DA_871056272 = (0);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903691104 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_903691104;
                    } //End block
                    else
                    {
                        int var668428D0DDF44F2DC16828D31178E104_1142526877 = (widgetResId - other.widgetResId);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036895085 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1036895085;
                    } //End block
                } //End block
                else
                {
                    int varD9EFFAD18764D32F3A83FDC89447722F_1970205850 = (resId - other.resId);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029777645 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2029777645;
                } //End block
            } //End block
            else
            {
                int var691C605F2A969CC09889E4C30F3161B2_1249937002 = (compareNames);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702883838 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_702883838;
            } //End block
            // ---------- Original Method ----------
            //int compareNames = name.compareTo(other.name);
            //if (compareNames == 0) {
                //if (resId == other.resId) {
                    //if (widgetResId == other.widgetResId) {
                        //return 0;
                    //} else {
                        //return widgetResId - other.widgetResId;
                    //}
                //} else {
                    //return resId - other.resId;
                //}
            //} else {
                //return compareNames;
            //}
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.637 -0400", hash_original_field = "81DE64C3C34751C325BA93388532677A", hash_generated_field = "3CD558471AD811C3362637174225D8B1")

    private static final String TAG = "PreferenceGroupAdapter";
}

