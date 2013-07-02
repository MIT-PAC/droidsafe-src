package android.preference;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.481 -0400", hash_original_field = "60A1F576EA55DAAA9B029C3300F68D2D", hash_generated_field = "9E796A8BD15586231740457EF37FD47D")

    private PreferenceGroup mPreferenceGroup;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.481 -0400", hash_original_field = "49E5F06342B9A756471C57C41582CFFB", hash_generated_field = "18F192958EC897931FD8B3DA5BF85A77")

    private List<Preference> mPreferenceList;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.481 -0400", hash_original_field = "B17D80C739620B94B645CF4C17A79E8D", hash_generated_field = "DA3004DA159CA709DF746F6CEC7DBE4F")

    private ArrayList<PreferenceLayout> mPreferenceLayouts;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.481 -0400", hash_original_field = "0EA8349A74250C961790E8C2CB2711B0", hash_generated_field = "21E20E055E82593BC0F10B12A6DDF8CB")

    private PreferenceLayout mTempPreferenceLayout = new PreferenceLayout();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.481 -0400", hash_original_field = "EC716D907E12FB2C66058C9510972CEE", hash_generated_field = "68E5BAC937AEA9D08E6032C8918801F2")

    private boolean mHasReturnedViewTypeCount = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.481 -0400", hash_original_field = "ACF05BEDD3E446A1812760F79FD88601", hash_generated_field = "8BB536959B4C4BC77100BFD82203560A")

    private volatile boolean mIsSyncing = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.481 -0400", hash_original_field = "6781893E9FA50A9B7103FD3F674E566B", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")

    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.482 -0400", hash_original_field = "A759A4E7184E3E83FC4B81BC91EB49E4", hash_generated_field = "6F8F5735F15B9F1306F9CF88A1481F4F")

    private Runnable mSyncRunnable = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.482 -0400", hash_original_method = "64E55F1CB25012944C9000EFC5F6389C", hash_generated_method = "098280FA3EF6FEBB87417E5331607D15")
        public void run() {
            syncMyPreferences();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.482 -0400", hash_original_method = "B0DE4241F694B745A6B6018AB0FE0031", hash_generated_method = "2348D0E06D92E9723DB46FBB01A918CF")
    public  PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        mPreferenceGroup = preferenceGroup;
        mPreferenceGroup.setOnPreferenceChangeInternalListener(this);
        mPreferenceList = new ArrayList<Preference>();
        mPreferenceLayouts = new ArrayList<PreferenceLayout>();
        syncMyPreferences();
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.483 -0400", hash_original_method = "47CAC8934A77F33A41B8A2FADE539715", hash_generated_method = "933F7AE243A08C301FCD3C02BD7E5023")
    private void syncMyPreferences() {
        {
            mIsSyncing = true;
        } 
        List<Preference> newPreferenceList = new ArrayList<Preference>(mPreferenceList.size());
        flattenPreferenceGroup(newPreferenceList, mPreferenceGroup);
        mPreferenceList = newPreferenceList;
        notifyDataSetChanged();
        {
            mIsSyncing = false;
            notifyAll();
        } 
        
        
            
                
            
            
        
        
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.483 -0400", hash_original_method = "DB0831C85843D6D53F9495F3413A2CE3", hash_generated_method = "CFFEED66421E33C5BE3C9D4A8243B8C5")
    private void flattenPreferenceGroup(List<Preference> preferences, PreferenceGroup group) {
        group.sortPreferences();
        final int groupSize = group.getPreferenceCount();
        {
            int i = 0;
            {
                final Preference preference = group.getPreference(i);
                preferences.add(preference);
                {
                    boolean var40B43CACDE7540D84B524CC399BFB861_1904913317 = (!mHasReturnedViewTypeCount && !preference.hasSpecifiedLayout());
                    {
                        addPreferenceClassName(preference);
                    } 
                } 
                {
                    final PreferenceGroup preferenceAsGroup = (PreferenceGroup) preference;
                    {
                        boolean varE978992A5EA3610B487523EDFB788538_1640408684 = (preferenceAsGroup.isOnSameScreenAsChildren());
                        {
                            flattenPreferenceGroup(preferences, preferenceAsGroup);
                        } 
                    } 
                } 
                preference.setOnPreferenceChangeInternalListener(this);
            } 
        } 
        addTaint(preferences.getTaint());
        addTaint(group.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.486 -0400", hash_original_method = "B927BA6712254BD5B8D47CF220E79C5B", hash_generated_method = "F2437ACEB1F2950AE35435DE3F16D831")
    private PreferenceLayout createPreferenceLayout(Preference preference, PreferenceLayout in) {
        PreferenceLayout varB4EAC82CA7396A68D541C85D26508E83_806881247 = null; 
        PreferenceLayout pl;
        pl = in;
        pl = new PreferenceLayout();
        pl.name = preference.getClass().getName();
        pl.resId = preference.getLayoutResource();
        pl.widgetResId = preference.getWidgetLayoutResource();
        varB4EAC82CA7396A68D541C85D26508E83_806881247 = pl;
        addTaint(preference.getTaint());
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_806881247.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_806881247;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.486 -0400", hash_original_method = "22004160B58BE5F5ED0505DF7AB89FF1", hash_generated_method = "64C6BDFDFF939CADAD7248C6FFF4FA50")
    private void addPreferenceClassName(Preference preference) {
        final PreferenceLayout pl = createPreferenceLayout(preference, null);
        int insertPos = Collections.binarySearch(mPreferenceLayouts, pl);
        {
            insertPos = insertPos * -1 - 1;
            mPreferenceLayouts.add(insertPos, pl);
        } 
        addTaint(preference.getTaint());
        
        
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.487 -0400", hash_original_method = "146D9A3F8F2485F6100744DF28993915", hash_generated_method = "B7BBE42F7D0103B8D85E40D0FDBCD31A")
    public int getCount() {
        int var0BB871AF6B245B4A49AE35894863E9A5_239153169 = (mPreferenceList.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729658960 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1729658960;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.487 -0400", hash_original_method = "B1551AF468D615637FECD6277399376D", hash_generated_method = "8B60456E205255A9A783475920B1006C")
    public Preference getItem(int position) {
        Preference varB4EAC82CA7396A68D541C85D26508E83_1792702108 = null; 
        Preference varB4EAC82CA7396A68D541C85D26508E83_841889941 = null; 
        {
            boolean var45192FB07B3B45171D06867ACD726073_1931302918 = (position < 0 || position >= getCount());
            varB4EAC82CA7396A68D541C85D26508E83_1792702108 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_841889941 = mPreferenceList.get(position);
        addTaint(position);
        Preference varA7E53CE21691AB073D9660D615818899_1062617110; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1062617110 = varB4EAC82CA7396A68D541C85D26508E83_1792702108;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1062617110 = varB4EAC82CA7396A68D541C85D26508E83_841889941;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1062617110.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1062617110;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.488 -0400", hash_original_method = "C2BB649F8AE8B2BA22DD6170BF8090F3", hash_generated_method = "C8F284D396DE0B9B0FFB5A707F2BDF22")
    public long getItemId(int position) {
        {
            boolean var45192FB07B3B45171D06867ACD726073_1660803731 = (position < 0 || position >= getCount());
        } 
        long var9A0649B1E597F61DA956857B024285E0_668184929 = (this.getItem(position).getId());
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1809364200 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1809364200;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.489 -0400", hash_original_method = "0A6038B272F94F277CAFD95B96B15A1A", hash_generated_method = "83B7086C6EE9A6A5D808D30EC7A5CE87")
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_297616295 = null; 
        final Preference preference = this.getItem(position);
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        {
            boolean var0B0B396A5E36CD68AD5961924C81E087_881526379 = (Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout) < 0);
            {
                convertView = null;
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_297616295 = preference.getView(convertView, parent);
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_297616295.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_297616295;
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.489 -0400", hash_original_method = "ED75A4DEF716F8048DFD61CCEF0A4510", hash_generated_method = "F801E993F2458F38C20467E408F528DF")
    @Override
    public boolean isEnabled(int position) {
        {
            boolean var45192FB07B3B45171D06867ACD726073_1843062640 = (position < 0 || position >= getCount());
        } 
        boolean varDF36F1121016E2EC170CA94BD0653774_330335986 = (this.getItem(position).isSelectable());
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_8895685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_8895685;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.489 -0400", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "B0026A257632DA2EE5376DEF854D700A")
    @Override
    public boolean areAllItemsEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1939270567 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1939270567;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.490 -0400", hash_original_method = "C2E233D65C74168849EC7AB5F1A2D9C0", hash_generated_method = "1DCFE1C6BDEA034C748E4C6D97AA424B")
    public void onPreferenceChange(Preference preference) {
        
        notifyDataSetChanged();
        addTaint(preference.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.490 -0400", hash_original_method = "96B325BF777CE525D2D64038C1261EF1", hash_generated_method = "A1FADCE7230F148BC856F774670D35AF")
    public void onPreferenceHierarchyChange(Preference preference) {
        
        mHandler.removeCallbacks(mSyncRunnable);
        mHandler.post(mSyncRunnable);
        addTaint(preference.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.490 -0400", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "56373E5A99B4B09A3B8497611BDB75CA")
    @Override
    public boolean hasStableIds() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1990393265 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1990393265;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.491 -0400", hash_original_method = "95969FB891958AA0335CF8E62A1ABF37", hash_generated_method = "F0C93C35C3279BA94B402343BA37A191")
    @Override
    public int getItemViewType(int position) {
        {
            mHasReturnedViewTypeCount = true;
        } 
        final Preference preference = this.getItem(position);
        {
            boolean var19F6D64A36EFF1C69D8A34EB7BC97077_1645281960 = (preference.hasSpecifiedLayout());
        } 
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);
        int viewType = Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout);
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549318963 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1549318963;
        
        
            
        
        
        
            
        
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.491 -0400", hash_original_method = "C26A2133E7F568EC0AF4EC87BB082A79", hash_generated_method = "4237D0E3ABF624F0A0C50B901E5EFCBA")
    @Override
    public int getViewTypeCount() {
        {
            mHasReturnedViewTypeCount = true;
        } 
        int var2CB183217D2F693D68F15362DCAE0953_690806318 = (Math.max(1, mPreferenceLayouts.size()));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412927125 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_412927125;
        
        
            
        
        
    }

    
    private static class PreferenceLayout implements Comparable<PreferenceLayout> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.491 -0400", hash_original_field = "C0179AEDB850805806A31BDC39510289", hash_generated_field = "D57D54CAC1273148C7462B42AF5839E3")

        private int resId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.491 -0400", hash_original_field = "2888237166571D1285BA13E4324E3AEE", hash_generated_field = "C72CD28C67C0D0B9F30E5D9DB8173BFF")

        private int widgetResId;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.491 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.491 -0400", hash_original_method = "12E8ADB8C3EE61AC77B7A82A93B07078", hash_generated_method = "12E8ADB8C3EE61AC77B7A82A93B07078")
        public PreferenceLayout ()
        {
            
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.492 -0400", hash_original_method = "0A98309F64E867E673B1B3CFC2DB79CE", hash_generated_method = "556B8BA9FBBCA2A0C531C1A5CABDB0E3")
        public int compareTo(PreferenceLayout other) {
            int compareNames = name.compareTo(other.name);
            addTaint(other.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897980871 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_897980871;
            
            
            
                
                    
                        
                    
                        
                    
                
                    
                
            
                
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.492 -0400", hash_original_field = "81DE64C3C34751C325BA93388532677A", hash_generated_field = "3CD558471AD811C3362637174225D8B1")

    private static final String TAG = "PreferenceGroupAdapter";
}

