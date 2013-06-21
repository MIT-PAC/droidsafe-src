package android.preference;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    private PreferenceGroup mPreferenceGroup;
    private List<Preference> mPreferenceList;
    private ArrayList<PreferenceLayout> mPreferenceLayouts;
    private PreferenceLayout mTempPreferenceLayout = new PreferenceLayout();
    private boolean mHasReturnedViewTypeCount = false;
    private volatile boolean mIsSyncing = false;
    private Handler mHandler = new Handler();
    private Runnable mSyncRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.680 -0400", hash_original_method = "64E55F1CB25012944C9000EFC5F6389C", hash_generated_method = "098280FA3EF6FEBB87417E5331607D15")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void run() {
            syncMyPreferences();
            // ---------- Original Method ----------
            //syncMyPreferences();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.680 -0400", hash_original_method = "B0DE4241F694B745A6B6018AB0FE0031", hash_generated_method = "DEB5B32C0DA45CC7418BC41DB4C24878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        dsTaint.addTaint(preferenceGroup.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.680 -0400", hash_original_method = "47CAC8934A77F33A41B8A2FADE539715", hash_generated_method = "C47F4C52AF893BC458AEB5870A6FA0D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void syncMyPreferences() {
        {
            mIsSyncing = true;
        } //End block
        List<Preference> newPreferenceList;
        newPreferenceList = new ArrayList<Preference>(mPreferenceList.size());
        flattenPreferenceGroup(newPreferenceList, mPreferenceGroup);
        mPreferenceList = newPreferenceList;
        notifyDataSetChanged();
        {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.681 -0400", hash_original_method = "DB0831C85843D6D53F9495F3413A2CE3", hash_generated_method = "30323983D0958CB78E793517600C366E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void flattenPreferenceGroup(List<Preference> preferences, PreferenceGroup group) {
        dsTaint.addTaint(group.dsTaint);
        dsTaint.addTaint(preferences.dsTaint);
        group.sortPreferences();
        int groupSize;
        groupSize = group.getPreferenceCount();
        {
            int i;
            i = 0;
            {
                Preference preference;
                preference = group.getPreference(i);
                preferences.add(preference);
                {
                    boolean var40B43CACDE7540D84B524CC399BFB861_1505675064 = (!mHasReturnedViewTypeCount && !preference.hasSpecifiedLayout());
                    {
                        addPreferenceClassName(preference);
                    } //End block
                } //End collapsed parenthetic
                {
                    PreferenceGroup preferenceAsGroup;
                    preferenceAsGroup = (PreferenceGroup) preference;
                    {
                        boolean varE978992A5EA3610B487523EDFB788538_231696373 = (preferenceAsGroup.isOnSameScreenAsChildren());
                        {
                            flattenPreferenceGroup(preferences, preferenceAsGroup);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                preference.setOnPreferenceChangeInternalListener(this);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.681 -0400", hash_original_method = "B927BA6712254BD5B8D47CF220E79C5B", hash_generated_method = "DDC952B1E1EEBC83FCF4E45DF23D9390")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private PreferenceLayout createPreferenceLayout(Preference preference, PreferenceLayout in) {
        dsTaint.addTaint(preference.dsTaint);
        dsTaint.addTaint(in.dsTaint);
        PreferenceLayout pl;
        pl = in;
        pl = new PreferenceLayout();
        pl.name = preference.getClass().getName();
        pl.resId = preference.getLayoutResource();
        pl.widgetResId = preference.getWidgetLayoutResource();
        return (PreferenceLayout)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PreferenceLayout pl = in != null? in : new PreferenceLayout();
        //pl.name = preference.getClass().getName();
        //pl.resId = preference.getLayoutResource();
        //pl.widgetResId = preference.getWidgetLayoutResource();
        //return pl;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.681 -0400", hash_original_method = "22004160B58BE5F5ED0505DF7AB89FF1", hash_generated_method = "B6244D3D12F780BE0A2D05152970549D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void addPreferenceClassName(Preference preference) {
        dsTaint.addTaint(preference.dsTaint);
        PreferenceLayout pl;
        pl = createPreferenceLayout(preference, null);
        int insertPos;
        insertPos = Collections.binarySearch(mPreferenceLayouts, pl);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.682 -0400", hash_original_method = "146D9A3F8F2485F6100744DF28993915", hash_generated_method = "A1F520FFCE0A7FAB54BDC58AFB83A21F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCount() {
        int var0BB871AF6B245B4A49AE35894863E9A5_213052969 = (mPreferenceList.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mPreferenceList.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.686 -0400", hash_original_method = "B1551AF468D615637FECD6277399376D", hash_generated_method = "4A297DBA566DF5D4893E1BB56B51CB5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Preference getItem(int position) {
        dsTaint.addTaint(position);
        {
            boolean var45192FB07B3B45171D06867ACD726073_1944347765 = (position < 0 || position >= getCount());
        } //End collapsed parenthetic
        Preference var54A03E09EEA2AD120C6B0CA7307DDBB3_1246666877 = (mPreferenceList.get(position));
        return (Preference)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (position < 0 || position >= getCount()) return null;
        //return mPreferenceList.get(position);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.687 -0400", hash_original_method = "C2BB649F8AE8B2BA22DD6170BF8090F3", hash_generated_method = "96A143B021D89411948A30C1138EAA60")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getItemId(int position) {
        dsTaint.addTaint(position);
        {
            boolean var45192FB07B3B45171D06867ACD726073_1726839730 = (position < 0 || position >= getCount());
        } //End collapsed parenthetic
        long var9A0649B1E597F61DA956857B024285E0_250243893 = (this.getItem(position).getId());
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //if (position < 0 || position >= getCount()) return ListView.INVALID_ROW_ID;
        //return this.getItem(position).getId();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.687 -0400", hash_original_method = "0A6038B272F94F277CAFD95B96B15A1A", hash_generated_method = "D7942F4849D75F2ADBA24EBA55CC6AE7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        Preference preference;
        preference = this.getItem(position);
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        {
            boolean var0B0B396A5E36CD68AD5961924C81E087_2066401581 = (Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout) < 0);
            {
                convertView = null;
            } //End block
        } //End collapsed parenthetic
        View var5575242508DE21C07C444526CA3EEEAE_1765549449 = (preference.getView(convertView, parent));
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //final Preference preference = this.getItem(position);
        //mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        //if (Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout) < 0) {
            //convertView = null;
        //}
        //return preference.getView(convertView, parent);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.688 -0400", hash_original_method = "ED75A4DEF716F8048DFD61CCEF0A4510", hash_generated_method = "C6AEDE7A3D8C2432C459FA9C1491A56E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isEnabled(int position) {
        dsTaint.addTaint(position);
        {
            boolean var45192FB07B3B45171D06867ACD726073_1719609937 = (position < 0 || position >= getCount());
        } //End collapsed parenthetic
        boolean varDF36F1121016E2EC170CA94BD0653774_74095869 = (this.getItem(position).isSelectable());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (position < 0 || position >= getCount()) return true;
        //return this.getItem(position).isSelectable();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.688 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "8F9650A119DFC09D25E8DA1FABB131DF")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean areAllItemsEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.688 -0400", hash_original_method = "C2E233D65C74168849EC7AB5F1A2D9C0", hash_generated_method = "710C5AFE03F44F760883E0C873BA92B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onPreferenceChange(Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(preference.dsTaint);
        notifyDataSetChanged();
        // ---------- Original Method ----------
        //notifyDataSetChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.688 -0400", hash_original_method = "96B325BF777CE525D2D64038C1261EF1", hash_generated_method = "CA34C3C8B3040452267D0007A34476DD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onPreferenceHierarchyChange(Preference preference) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(preference.dsTaint);
        mHandler.removeCallbacks(mSyncRunnable);
        mHandler.post(mSyncRunnable);
        // ---------- Original Method ----------
        //mHandler.removeCallbacks(mSyncRunnable);
        //mHandler.post(mSyncRunnable);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.688 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "5B276EFEB8BB899F96DBEA3B21268F19")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean hasStableIds() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.689 -0400", hash_original_method = "95969FB891958AA0335CF8E62A1ABF37", hash_generated_method = "284CA9C9ACE174992466B409663C448D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getItemViewType(int position) {
        dsTaint.addTaint(position);
        {
            mHasReturnedViewTypeCount = true;
        } //End block
        Preference preference;
        preference = this.getItem(position);
        {
            boolean var19F6D64A36EFF1C69D8A34EB7BC97077_644044123 = (preference.hasSpecifiedLayout());
        } //End collapsed parenthetic
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        int viewType;
        viewType = Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout);
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.689 -0400", hash_original_method = "C26A2133E7F568EC0AF4EC87BB082A79", hash_generated_method = "01F03D7C4AE34C215791441CB727545F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getViewTypeCount() {
        {
            mHasReturnedViewTypeCount = true;
        } //End block
        int var2CB183217D2F693D68F15362DCAE0953_1599065469 = (Math.max(1, mPreferenceLayouts.size()));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (!mHasReturnedViewTypeCount) {
            //mHasReturnedViewTypeCount = true;
        //}
        //return Math.max(1, mPreferenceLayouts.size());
    }

    
    private static class PreferenceLayout implements Comparable<PreferenceLayout> {
        private int resId;
        private int widgetResId;
        private String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.689 -0400", hash_original_method = "59E57AFF09C316693D75CD225E52F361", hash_generated_method = "59E57AFF09C316693D75CD225E52F361")
                public PreferenceLayout ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.690 -0400", hash_original_method = "0A98309F64E867E673B1B3CFC2DB79CE", hash_generated_method = "583F4ADCD6AB203351F1EE4C3162DCAC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int compareTo(PreferenceLayout other) {
            dsTaint.addTaint(other.dsTaint);
            int compareNames;
            compareNames = name.compareTo(other.name);
            return dsTaint.getTaintInt();
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


    
    private static final String TAG = "PreferenceGroupAdapter";
}

