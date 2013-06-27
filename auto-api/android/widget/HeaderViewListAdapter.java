package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class HeaderViewListAdapter implements WrapperListAdapter, Filterable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.991 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:05.991 -0400", hash_original_field = "8B3453F15529335E224866A4AFCB80E3", hash_generated_field = "1174AC07D1E0FF5BE8FD7B73F622A98F")

    ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.000 -0400", hash_original_field = "B8FDAC0951330D9E01F6B98B286C3F3E", hash_generated_field = "88602AC90A2A75CECE8836CF4FDB527C")

    ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.000 -0400", hash_original_field = "A77BBF288DDB83C524B2E9A07CB0CFB5", hash_generated_field = "2DA9D21A65202F474DD30A137186E034")

    boolean mAreAllFixedViewsSelectable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.000 -0400", hash_original_field = "6B708799D01ECAD7FAB52020404D876D", hash_generated_field = "6776BDE0D016372C684D038A88F70F04")

    private boolean mIsFilterable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.006 -0400", hash_original_method = "ED7F7094A6F9A9163E3FAE563C0A2BCF", hash_generated_method = "73641371E9BFC0FE22B42ECAD434270F")
    public  HeaderViewListAdapter(ArrayList<ListView.FixedViewInfo> headerViewInfos,
                                 ArrayList<ListView.FixedViewInfo> footerViewInfos,
                                 ListAdapter adapter) {
        mAdapter = adapter;
        mIsFilterable = adapter instanceof Filterable;
        {
            mHeaderViewInfos = EMPTY_INFO_LIST;
        } //End block
        {
            mHeaderViewInfos = headerViewInfos;
        } //End block
        {
            mFooterViewInfos = EMPTY_INFO_LIST;
        } //End block
        {
            mFooterViewInfos = footerViewInfos;
        } //End block
        mAreAllFixedViewsSelectable =
                areAllListInfosSelectable(mHeaderViewInfos)
                && areAllListInfosSelectable(mFooterViewInfos);
        // ---------- Original Method ----------
        //mAdapter = adapter;
        //mIsFilterable = adapter instanceof Filterable;
        //if (headerViewInfos == null) {
            //mHeaderViewInfos = EMPTY_INFO_LIST;
        //} else {
            //mHeaderViewInfos = headerViewInfos;
        //}
        //if (footerViewInfos == null) {
            //mFooterViewInfos = EMPTY_INFO_LIST;
        //} else {
            //mFooterViewInfos = footerViewInfos;
        //}
        //mAreAllFixedViewsSelectable =
                //areAllListInfosSelectable(mHeaderViewInfos)
                //&& areAllListInfosSelectable(mFooterViewInfos);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.006 -0400", hash_original_method = "F816FE78C9557554F8C5B6BB80A06D13", hash_generated_method = "DE99BA177D51EB3E7C49C1E6278F9BAA")
    public int getHeadersCount() {
        int var51EB21BA6322BC21883B38109F793DB7_1178142557 = (mHeaderViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995669754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_995669754;
        // ---------- Original Method ----------
        //return mHeaderViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.007 -0400", hash_original_method = "03601E80550495DBAEB6124EE960EF9F", hash_generated_method = "339A16CE46C08A4A9559714E18390003")
    public int getFootersCount() {
        int var05D2A206262A11BE7E645CDC53B4074D_2145425193 = (mFooterViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222179675 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1222179675;
        // ---------- Original Method ----------
        //return mFooterViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.007 -0400", hash_original_method = "D7DEAD009C651EAC8E2A235B793425D9", hash_generated_method = "60ABEBBB0EC237FEC059ACE530906797")
    public boolean isEmpty() {
        boolean varD35419911CAF869FB18BA02856781F0C_1681620540 = (mAdapter == null || mAdapter.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1887200834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1887200834;
        // ---------- Original Method ----------
        //return mAdapter == null || mAdapter.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.037 -0400", hash_original_method = "41241BC7260E3C26DE66CCD5C227EECC", hash_generated_method = "A36EE745CF53D8308B893564CB5A6AE3")
    private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> infos) {
        {
            {
                Iterator<ListView.FixedViewInfo> var8B5947E9D1DF62DF443918DA5B663B89_2072866355 = (infos).iterator();
                var8B5947E9D1DF62DF443918DA5B663B89_2072866355.hasNext();
                ListView.FixedViewInfo info = var8B5947E9D1DF62DF443918DA5B663B89_2072866355.next();
            } //End collapsed parenthetic
        } //End block
        addTaint(infos.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_176592319 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_176592319;
        // ---------- Original Method ----------
        //if (infos != null) {
            //for (ListView.FixedViewInfo info : infos) {
                //if (!info.isSelectable) {
                    //return false;
                //}
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.038 -0400", hash_original_method = "92115EA33573B801358871B3CD0766B3", hash_generated_method = "04E99EFB52D0D2BDEA3A275E37BD84C0")
    public boolean removeHeader(View v) {
        {
            int i;
            i = 0;
            boolean var3B35C29B0489E7CC40865002A99AAA03_2088311817 = (i < mHeaderViewInfos.size());
            {
                ListView.FixedViewInfo info;
                info = mHeaderViewInfos.get(i);
                {
                    mHeaderViewInfos.remove(i);
                    mAreAllFixedViewsSelectable =
                        areAllListInfosSelectable(mHeaderViewInfos)
                        && areAllListInfosSelectable(mFooterViewInfos);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_422529612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_422529612;
        // ---------- Original Method ----------
        //for (int i = 0; i < mHeaderViewInfos.size(); i++) {
            //ListView.FixedViewInfo info = mHeaderViewInfos.get(i);
            //if (info.view == v) {
                //mHeaderViewInfos.remove(i);
                //mAreAllFixedViewsSelectable =
                        //areAllListInfosSelectable(mHeaderViewInfos)
                        //&& areAllListInfosSelectable(mFooterViewInfos);
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.039 -0400", hash_original_method = "C18E7E6A93212BDE730ADAF32E087D6A", hash_generated_method = "E702E97D92E46B0A8C635919C6CC3A5B")
    public boolean removeFooter(View v) {
        {
            int i;
            i = 0;
            boolean varC9FB87404C9C311F63579621314C75C2_53369105 = (i < mFooterViewInfos.size());
            {
                ListView.FixedViewInfo info;
                info = mFooterViewInfos.get(i);
                {
                    mFooterViewInfos.remove(i);
                    mAreAllFixedViewsSelectable =
                        areAllListInfosSelectable(mHeaderViewInfos)
                        && areAllListInfosSelectable(mFooterViewInfos);
                } //End block
            } //End block
        } //End collapsed parenthetic
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2130271710 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2130271710;
        // ---------- Original Method ----------
        //for (int i = 0; i < mFooterViewInfos.size(); i++) {
            //ListView.FixedViewInfo info = mFooterViewInfos.get(i);
            //if (info.view == v) {
                //mFooterViewInfos.remove(i);
                //mAreAllFixedViewsSelectable =
                        //areAllListInfosSelectable(mHeaderViewInfos)
                        //&& areAllListInfosSelectable(mFooterViewInfos);
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.040 -0400", hash_original_method = "5EA4C802749955ACC8971AB13A15905C", hash_generated_method = "F90E9CB59CDF907FB5B000A2CBA53449")
    public int getCount() {
        {
            int var661984E76F04D752B1BAEC58283825F0_324668413 = (getFootersCount() + getHeadersCount() + mAdapter.getCount());
        } //End block
        {
            int varE487CA7829F9BC3C8EBD5B664AB8BEFB_1903111235 = (getFootersCount() + getHeadersCount());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263338160 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1263338160;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return getFootersCount() + getHeadersCount() + mAdapter.getCount();
        //} else {
            //return getFootersCount() + getHeadersCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.041 -0400", hash_original_method = "BA6CC34361A3C86CCD3E8BF91B771D57", hash_generated_method = "8401AD24FEAA0DA8903CE63027E31D14")
    public boolean areAllItemsEnabled() {
        {
            boolean var9C54E106A28E5AC5432E590C5A6E2813_1151464505 = (mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2081652817 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2081652817;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.044 -0400", hash_original_method = "DF42B35442C4183A344219B7FD0FCDD1", hash_generated_method = "A443CDD49620872159F2909A2E50B83D")
    public boolean isEnabled(int position) {
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            boolean var2010CA47FC71AF2CAA3A2C68AB451F64_715516689 = (mHeaderViewInfos.get(position).isSelectable);
        } //End block
        int adjPosition;
        adjPosition = position - numHeaders;
        int adapterCount;
        adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                boolean var976993602ACCF2E54C9355F58E9BFB82_63973437 = (mAdapter.isEnabled(adjPosition));
            } //End block
        } //End block
        boolean var1751AB55CF32B4B2D54E9279FA0C1F29_1622448139 = (mFooterViewInfos.get(adjPosition - adapterCount).isSelectable);
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2138020530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2138020530;
        // ---------- Original Method ----------
        //int numHeaders = getHeadersCount();
        //if (position < numHeaders) {
            //return mHeaderViewInfos.get(position).isSelectable;
        //}
        //final int adjPosition = position - numHeaders;
        //int adapterCount = 0;
        //if (mAdapter != null) {
            //adapterCount = mAdapter.getCount();
            //if (adjPosition < adapterCount) {
                //return mAdapter.isEnabled(adjPosition);
            //}
        //}
        //return mFooterViewInfos.get(adjPosition - adapterCount).isSelectable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.056 -0400", hash_original_method = "5FB1DDE7849FB7B1EE35000192AE1125", hash_generated_method = "85A6C977619D79F8E226BCEF3CC06376")
    public Object getItem(int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1573645656 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_139052505 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_1098773027 = null; //Variable for return #3
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1573645656 = mHeaderViewInfos.get(position).data;
        } //End block
        int adjPosition;
        adjPosition = position - numHeaders;
        int adapterCount;
        adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                varB4EAC82CA7396A68D541C85D26508E83_139052505 = mAdapter.getItem(adjPosition);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1098773027 = mFooterViewInfos.get(adjPosition - adapterCount).data;
        addTaint(position);
        Object varA7E53CE21691AB073D9660D615818899_1708629385; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1708629385 = varB4EAC82CA7396A68D541C85D26508E83_1573645656;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1708629385 = varB4EAC82CA7396A68D541C85D26508E83_139052505;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1708629385 = varB4EAC82CA7396A68D541C85D26508E83_1098773027;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1708629385.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1708629385;
        // ---------- Original Method ----------
        //int numHeaders = getHeadersCount();
        //if (position < numHeaders) {
            //return mHeaderViewInfos.get(position).data;
        //}
        //final int adjPosition = position - numHeaders;
        //int adapterCount = 0;
        //if (mAdapter != null) {
            //adapterCount = mAdapter.getCount();
            //if (adjPosition < adapterCount) {
                //return mAdapter.getItem(adjPosition);
            //}
        //}
        //return mFooterViewInfos.get(adjPosition - adapterCount).data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.056 -0400", hash_original_method = "0EFF2641ED72ED5C174A1DFD9DE35423", hash_generated_method = "D57829B6B5B4D2C62CC47516D689B6C9")
    public long getItemId(int position) {
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            int adjPosition;
            adjPosition = position - numHeaders;
            int adapterCount;
            adapterCount = mAdapter.getCount();
            {
                long var99E8EC83666448CE62AC20755BD9065F_1135521032 = (mAdapter.getItemId(adjPosition));
            } //End block
        } //End block
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_517665663 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_517665663;
        // ---------- Original Method ----------
        //int numHeaders = getHeadersCount();
        //if (mAdapter != null && position >= numHeaders) {
            //int adjPosition = position - numHeaders;
            //int adapterCount = mAdapter.getCount();
            //if (adjPosition < adapterCount) {
                //return mAdapter.getItemId(adjPosition);
            //}
        //}
        //return -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.057 -0400", hash_original_method = "5C897DB1697E65CD415A86C35E25516F", hash_generated_method = "37CBC48F655BB8DE347BFF77B9C2CEC9")
    public boolean hasStableIds() {
        {
            boolean varFDE3CC3D22CA5BAB554F3ECCA23F98B2_1135258271 = (mAdapter.hasStableIds());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_312199312 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_312199312;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.hasStableIds();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.058 -0400", hash_original_method = "B94999E1741825084E6BE4B30684EEAE", hash_generated_method = "40633FAEE18EB3354958E69FB81078E2")
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_941012955 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_893103068 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_756874866 = null; //Variable for return #3
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            varB4EAC82CA7396A68D541C85D26508E83_941012955 = mHeaderViewInfos.get(position).view;
        } //End block
        int adjPosition;
        adjPosition = position - numHeaders;
        int adapterCount;
        adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                varB4EAC82CA7396A68D541C85D26508E83_893103068 = mAdapter.getView(adjPosition, convertView, parent);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_756874866 = mFooterViewInfos.get(adjPosition - adapterCount).view;
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1608580084; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1608580084 = varB4EAC82CA7396A68D541C85D26508E83_941012955;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1608580084 = varB4EAC82CA7396A68D541C85D26508E83_893103068;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1608580084 = varB4EAC82CA7396A68D541C85D26508E83_756874866;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1608580084.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1608580084;
        // ---------- Original Method ----------
        //int numHeaders = getHeadersCount();
        //if (position < numHeaders) {
            //return mHeaderViewInfos.get(position).view;
        //}
        //final int adjPosition = position - numHeaders;
        //int adapterCount = 0;
        //if (mAdapter != null) {
            //adapterCount = mAdapter.getCount();
            //if (adjPosition < adapterCount) {
                //return mAdapter.getView(adjPosition, convertView, parent);
            //}
        //}
        //return mFooterViewInfos.get(adjPosition - adapterCount).view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.058 -0400", hash_original_method = "18109841CF71190B9879A21F432A9D28", hash_generated_method = "438985F3D308815AFB524025B9BB59CF")
    public int getItemViewType(int position) {
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            int adjPosition;
            adjPosition = position - numHeaders;
            int adapterCount;
            adapterCount = mAdapter.getCount();
            {
                int var645C3D1547C170A59D2EE81F83FA9020_490382754 = (mAdapter.getItemViewType(adjPosition));
            } //End block
        } //End block
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206207112 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_206207112;
        // ---------- Original Method ----------
        //int numHeaders = getHeadersCount();
        //if (mAdapter != null && position >= numHeaders) {
            //int adjPosition = position - numHeaders;
            //int adapterCount = mAdapter.getCount();
            //if (adjPosition < adapterCount) {
                //return mAdapter.getItemViewType(adjPosition);
            //}
        //}
        //return AdapterView.ITEM_VIEW_TYPE_HEADER_OR_FOOTER;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.058 -0400", hash_original_method = "8F6564F3EA2E826663B1C340FEA4D3E0", hash_generated_method = "158A504CFB49FBD30A9041A1E6322C1C")
    public int getViewTypeCount() {
        {
            int var0AD31D021E508485C7C9D8AAC7CD7F8E_1292380582 = (mAdapter.getViewTypeCount());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142998976 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1142998976;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.getViewTypeCount();
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.065 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "394F8D6D1C3E11D04B82C1A93DEB883B")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        {
            mAdapter.registerDataSetObserver(observer);
        } //End block
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //mAdapter.registerDataSetObserver(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.066 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "CA1E1CE41BA81DA1B5FFC90A490DA640")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        {
            mAdapter.unregisterDataSetObserver(observer);
        } //End block
        addTaint(observer.getTaint());
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //mAdapter.unregisterDataSetObserver(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.066 -0400", hash_original_method = "9E800AF0A66A6C48391AEDACEAEC8859", hash_generated_method = "0A32190ED2DBC953086D0D41C699FE3A")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_1901393034 = null; //Variable for return #1
        Filter varB4EAC82CA7396A68D541C85D26508E83_1407989921 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1901393034 = ((Filterable) mAdapter).getFilter();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1407989921 = null;
        Filter varA7E53CE21691AB073D9660D615818899_898607432; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_898607432 = varB4EAC82CA7396A68D541C85D26508E83_1901393034;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_898607432 = varB4EAC82CA7396A68D541C85D26508E83_1407989921;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_898607432.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_898607432;
        // ---------- Original Method ----------
        //if (mIsFilterable) {
            //return ((Filterable) mAdapter).getFilter();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.081 -0400", hash_original_method = "16C6428A588CE1C0BF49AB22D8718A60", hash_generated_method = "2D7A63890C7B57DE91259E1F7D75DFDB")
    public ListAdapter getWrappedAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_751534207 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_751534207 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_751534207.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_751534207;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:06.082 -0400", hash_original_field = "E7B5861FDFB008C25413C9B2AC5A155E", hash_generated_field = "2EAD8918C42A1ED65AC4BB057808474F")

    static ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST = new ArrayList<ListView.FixedViewInfo>();
}

