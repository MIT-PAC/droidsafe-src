package android.preference;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import android.os.Handler;
import android.preference.Preference.OnPreferenceChangeInternalListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

class PreferenceGroupAdapter extends BaseAdapter implements OnPreferenceChangeInternalListener {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.931 -0500", hash_original_field = "3448C5E5D4B7A54DCB54B36785EADCD0", hash_generated_field = "3CD558471AD811C3362637174225D8B1")
    
    private static final String TAG = "PreferenceGroupAdapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.933 -0500", hash_original_field = "471107931B8ED684E83D803565E4E6F7", hash_generated_field = "9E796A8BD15586231740457EF37FD47D")

    private PreferenceGroup mPreferenceGroup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.935 -0500", hash_original_field = "AA94F4A4BB2311E5FFF451A9F8B32E0B", hash_generated_field = "18F192958EC897931FD8B3DA5BF85A77")

    private List<Preference> mPreferenceList;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.937 -0500", hash_original_field = "C743874746BAF5F8971A7066576FD699", hash_generated_field = "DA3004DA159CA709DF746F6CEC7DBE4F")

    private ArrayList<PreferenceLayout> mPreferenceLayouts;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.939 -0500", hash_original_field = "0CC617CF06086A93ADE6667A33A3B2EC", hash_generated_field = "21E20E055E82593BC0F10B12A6DDF8CB")

    private PreferenceLayout mTempPreferenceLayout = new PreferenceLayout();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.941 -0500", hash_original_field = "18043BDDF466670A54CD9DA3AB56FDA3", hash_generated_field = "68E5BAC937AEA9D08E6032C8918801F2")

    private boolean mHasReturnedViewTypeCount = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.943 -0500", hash_original_field = "16463B205723CE1AF405A997E8F91C23", hash_generated_field = "8BB536959B4C4BC77100BFD82203560A")
    
    private volatile boolean mIsSyncing = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.945 -0500", hash_original_field = "AD9C3D1E48D73BF1547D53C4C62401B2", hash_generated_field = "2E60E17486AAEB1A4E1F1878A0354061")
    
    private Handler mHandler = new Handler();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.482 -0400", hash_original_field = "A759A4E7184E3E83FC4B81BC91EB49E4", hash_generated_field = "6F8F5735F15B9F1306F9CF88A1481F4F")

    private Runnable mSyncRunnable = new Runnable() {        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:44.482 -0400", hash_original_method = "64E55F1CB25012944C9000EFC5F6389C", hash_generated_method = "098280FA3EF6FEBB87417E5331607D15")
        public void run() {
            syncMyPreferences();
            
        }
        
};

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.965 -0500", hash_original_method = "B0DE4241F694B745A6B6018AB0FE0031", hash_generated_method = "95E1B4F477E217E0E6F53D324F101CA7")
    
public PreferenceGroupAdapter(PreferenceGroup preferenceGroup) {
        mPreferenceGroup = preferenceGroup;
        // If this group gets or loses any children, let us know
        mPreferenceGroup.setOnPreferenceChangeInternalListener(this);

        mPreferenceList = new ArrayList<Preference>();
        mPreferenceLayouts = new ArrayList<PreferenceLayout>();

        syncMyPreferences();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.967 -0500", hash_original_method = "47CAC8934A77F33A41B8A2FADE539715", hash_generated_method = "83862446DB76F88ECA2467D19EDCB51A")
    
private void syncMyPreferences() {
        synchronized(this) {
            if (mIsSyncing) {
                return;
            }

            mIsSyncing = true;
        }

        List<Preference> newPreferenceList = new ArrayList<Preference>(mPreferenceList.size());
        flattenPreferenceGroup(newPreferenceList, mPreferenceGroup);
        mPreferenceList = newPreferenceList;
        
        notifyDataSetChanged();

        synchronized(this) {
            mIsSyncing = false;
            notifyAll();
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.970 -0500", hash_original_method = "DB0831C85843D6D53F9495F3413A2CE3", hash_generated_method = "1393374CC165636D02C8422280A09FB6")
    
private void flattenPreferenceGroup(List<Preference> preferences, PreferenceGroup group) {
        // TODO: shouldn't always?
        group.sortPreferences();

        final int groupSize = group.getPreferenceCount();
        for (int i = 0; i < groupSize; i++) {
            final Preference preference = group.getPreference(i);
            
            preferences.add(preference);
            
            if (!mHasReturnedViewTypeCount && !preference.hasSpecifiedLayout()) {
                addPreferenceClassName(preference);
            }
            
            if (preference instanceof PreferenceGroup) {
                final PreferenceGroup preferenceAsGroup = (PreferenceGroup) preference;
                if (preferenceAsGroup.isOnSameScreenAsChildren()) {
                    flattenPreferenceGroup(preferences, preferenceAsGroup);
                }
            }

            preference.setOnPreferenceChangeInternalListener(this);
        }
    }

    /**
     * Creates a string that includes the preference name, layout id and widget layout id.
     * If a particular preference type uses 2 different resources, they will be treated as
     * different view types.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.972 -0500", hash_original_method = "B927BA6712254BD5B8D47CF220E79C5B", hash_generated_method = "BD2788C82F8C0BFA5B2E437E43801942")
    
private PreferenceLayout createPreferenceLayout(Preference preference, PreferenceLayout in) {
        PreferenceLayout pl = in != null? in : new PreferenceLayout();
        pl.name = preference.getClass().getName();
        pl.resId = preference.getLayoutResource();
        pl.widgetResId = preference.getWidgetLayoutResource();
        return pl;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.975 -0500", hash_original_method = "22004160B58BE5F5ED0505DF7AB89FF1", hash_generated_method = "0F779E5E5C2CFDE5A29FEB851AF3C43E")
    
private void addPreferenceClassName(Preference preference) {
        final PreferenceLayout pl = createPreferenceLayout(preference, null);
        int insertPos = Collections.binarySearch(mPreferenceLayouts, pl);

        // Only insert if it doesn't exist (when it is negative).
        if (insertPos < 0) {
            // Convert to insert index
            insertPos = insertPos * -1 - 1;
            mPreferenceLayouts.add(insertPos, pl);
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.DATABASE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.977 -0500", hash_original_method = "146D9A3F8F2485F6100744DF28993915", hash_generated_method = "AD8CAB718C0FC746435AF32937C54F39")
    
public int getCount() {
        return mPreferenceList.size();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.980 -0500", hash_original_method = "B1551AF468D615637FECD6277399376D", hash_generated_method = "62EAC07E967E95133E6C020078002A17")
    
public Preference getItem(int position) {
        if (position < 0 || position >= getCount()) return null;
        return mPreferenceList.get(position);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.DATABASE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.982 -0500", hash_original_method = "C2BB649F8AE8B2BA22DD6170BF8090F3", hash_generated_method = "B317745E077FD87242E11208AD60B283")
    
public long getItemId(int position) {
        if (position < 0 || position >= getCount()) return ListView.INVALID_ROW_ID;
        return this.getItem(position).getId();
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.984 -0500", hash_original_method = "0A6038B272F94F277CAFD95B96B15A1A", hash_generated_method = "00420607D26EA9F45F57848A403F038D")
    
public View getView(int position, View convertView, ViewGroup parent) {
        final Preference preference = this.getItem(position);
        // Build a PreferenceLayout to compare with known ones that are cacheable.
        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);

        // If it's not one of the cached ones, set the convertView to null so that 
        // the layout gets re-created by the Preference.
        if (Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout) < 0) {
            convertView = null;
        }

        return preference.getView(convertView, parent);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.986 -0500", hash_original_method = "ED75A4DEF716F8048DFD61CCEF0A4510", hash_generated_method = "1EF13F6984EE92A11EDB6A7242B66E97")
    
@Override
    public boolean isEnabled(int position) {
        if (position < 0 || position >= getCount()) return true;
        return this.getItem(position).isSelectable();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.988 -0500", hash_original_method = "19954EF3B060E791A26DF845CEE18A7B", hash_generated_method = "1EFB24A37727A528A1C712837625FE3B")
    
@Override
    public boolean areAllItemsEnabled() {
        // There should always be a preference group, and these groups are always
        // disabled
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.991 -0500", hash_original_method = "C2E233D65C74168849EC7AB5F1A2D9C0", hash_generated_method = "5D3298B9C5A58A4AC1DCDD99B0EB89D4")
    
public void onPreferenceChange(Preference preference) {
        notifyDataSetChanged();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.993 -0500", hash_original_method = "96B325BF777CE525D2D64038C1261EF1", hash_generated_method = "3EC6E8EF0AD55C5233DCE171CCB56DF6")
    
public void onPreferenceHierarchyChange(Preference preference) {
        mHandler.removeCallbacks(mSyncRunnable);
        mHandler.post(mSyncRunnable);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.995 -0500", hash_original_method = "047E07C1992C7400A48E08BF432AD584", hash_generated_method = "393A59784E726D5BE49F0B29F763EDD7")
    
@Override
    public boolean hasStableIds() {
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.998 -0500", hash_original_method = "95969FB891958AA0335CF8E62A1ABF37", hash_generated_method = "5744C1606356E29F6DA1DD97DE5D24FC")
    
@Override
    public int getItemViewType(int position) {
        if (!mHasReturnedViewTypeCount) {
            mHasReturnedViewTypeCount = true;
        }
        
        final Preference preference = this.getItem(position);
        if (preference.hasSpecifiedLayout()) {
            return IGNORE_ITEM_VIEW_TYPE;
        }

        mTempPreferenceLayout = createPreferenceLayout(preference, mTempPreferenceLayout);

        int viewType = Collections.binarySearch(mPreferenceLayouts, mTempPreferenceLayout);
        if (viewType < 0) {
            // This is a class that was seen after we returned the count, so
            // don't recycle it.
            return IGNORE_ITEM_VIEW_TYPE;
        } else {
            return viewType;
        }
    }
    
    private static class PreferenceLayout implements Comparable<PreferenceLayout> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.953 -0500", hash_original_field = "2142279FAAC2FF3448D7D11FB02AB89E", hash_generated_field = "D57D54CAC1273148C7462B42AF5839E3")

        private int resId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.956 -0500", hash_original_field = "17661956B91108371A5F751D3D48139E", hash_generated_field = "C72CD28C67C0D0B9F30E5D9DB8173BFF")

        private int widgetResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.958 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

        private String name;
        
        @DSComment("Private Method")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:28.636 -0400", hash_original_method = "12E8ADB8C3EE61AC77B7A82A93B07078", hash_generated_method = "12E8ADB8C3EE61AC77B7A82A93B07078")
        public PreferenceLayout ()
        {
            //Synthesized constructor
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:22.960 -0500", hash_original_method = "0A98309F64E867E673B1B3CFC2DB79CE", hash_generated_method = "84AACF873005B030D9A068AE6475BB5D")
        
public int compareTo(PreferenceLayout other) {
            int compareNames = name.compareTo(other.name);
            if (compareNames == 0) {
                if (resId == other.resId) {
                    if (widgetResId == other.widgetResId) {
                        return 0;
                    } else {
                        return widgetResId - other.widgetResId;
                    }
                } else {
                    return resId - other.resId;
                }
            } else {
                return compareNames;
            }
        }
        
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:23.001 -0500", hash_original_method = "C26A2133E7F568EC0AF4EC87BB082A79", hash_generated_method = "D20532B94EECFDE24658552508F2E0FA")
    
@Override
    public int getViewTypeCount() {
        if (!mHasReturnedViewTypeCount) {
            mHasReturnedViewTypeCount = true;
        }
        
        return Math.max(1, mPreferenceLayouts.size());
    }
}

