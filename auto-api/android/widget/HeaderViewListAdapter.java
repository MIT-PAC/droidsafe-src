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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.660 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.660 -0400", hash_original_field = "8B3453F15529335E224866A4AFCB80E3", hash_generated_field = "1174AC07D1E0FF5BE8FD7B73F622A98F")

    ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.660 -0400", hash_original_field = "B8FDAC0951330D9E01F6B98B286C3F3E", hash_generated_field = "88602AC90A2A75CECE8836CF4FDB527C")

    ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.660 -0400", hash_original_field = "A77BBF288DDB83C524B2E9A07CB0CFB5", hash_generated_field = "2DA9D21A65202F474DD30A137186E034")

    boolean mAreAllFixedViewsSelectable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.660 -0400", hash_original_field = "6B708799D01ECAD7FAB52020404D876D", hash_generated_field = "6776BDE0D016372C684D038A88F70F04")

    private boolean mIsFilterable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.661 -0400", hash_original_method = "ED7F7094A6F9A9163E3FAE563C0A2BCF", hash_generated_method = "73641371E9BFC0FE22B42ECAD434270F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.661 -0400", hash_original_method = "F816FE78C9557554F8C5B6BB80A06D13", hash_generated_method = "A7BE5DDE87C883F849B604A2DB909D3C")
    public int getHeadersCount() {
        int var51EB21BA6322BC21883B38109F793DB7_238189747 = (mHeaderViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444433024 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_444433024;
        // ---------- Original Method ----------
        //return mHeaderViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.679 -0400", hash_original_method = "03601E80550495DBAEB6124EE960EF9F", hash_generated_method = "EA02CEFBACDA9017FFD179C5A5DD4B93")
    public int getFootersCount() {
        int var05D2A206262A11BE7E645CDC53B4074D_2026900257 = (mFooterViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670578527 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1670578527;
        // ---------- Original Method ----------
        //return mFooterViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.680 -0400", hash_original_method = "D7DEAD009C651EAC8E2A235B793425D9", hash_generated_method = "E9AC421A60C8C2CAF10EDEACB3143CD7")
    public boolean isEmpty() {
        boolean varD35419911CAF869FB18BA02856781F0C_727906950 = (mAdapter == null || mAdapter.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1484208477 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1484208477;
        // ---------- Original Method ----------
        //return mAdapter == null || mAdapter.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.715 -0400", hash_original_method = "41241BC7260E3C26DE66CCD5C227EECC", hash_generated_method = "FF6E8AA0D83E703F89118C9EE8827E54")
    private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> infos) {
        {
            {
                Iterator<ListView.FixedViewInfo> var8B5947E9D1DF62DF443918DA5B663B89_127831347 = (infos).iterator();
                var8B5947E9D1DF62DF443918DA5B663B89_127831347.hasNext();
                ListView.FixedViewInfo info = var8B5947E9D1DF62DF443918DA5B663B89_127831347.next();
            } //End collapsed parenthetic
        } //End block
        addTaint(infos.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1102318483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1102318483;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.716 -0400", hash_original_method = "92115EA33573B801358871B3CD0766B3", hash_generated_method = "78E76FC2FB86E50F6AE2C169C8084755")
    public boolean removeHeader(View v) {
        {
            int i;
            i = 0;
            boolean var3B35C29B0489E7CC40865002A99AAA03_1179877122 = (i < mHeaderViewInfos.size());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1788208293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1788208293;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.716 -0400", hash_original_method = "C18E7E6A93212BDE730ADAF32E087D6A", hash_generated_method = "01CECD94DA2B990485CDA049A4EFA760")
    public boolean removeFooter(View v) {
        {
            int i;
            i = 0;
            boolean varC9FB87404C9C311F63579621314C75C2_510112706 = (i < mFooterViewInfos.size());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_354224360 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_354224360;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.717 -0400", hash_original_method = "5EA4C802749955ACC8971AB13A15905C", hash_generated_method = "F961CF846EAC81D5AAF64EFB7F8E5F9E")
    public int getCount() {
        {
            int var661984E76F04D752B1BAEC58283825F0_1262264911 = (getFootersCount() + getHeadersCount() + mAdapter.getCount());
        } //End block
        {
            int varE487CA7829F9BC3C8EBD5B664AB8BEFB_614621827 = (getFootersCount() + getHeadersCount());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041315529 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2041315529;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return getFootersCount() + getHeadersCount() + mAdapter.getCount();
        //} else {
            //return getFootersCount() + getHeadersCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.717 -0400", hash_original_method = "BA6CC34361A3C86CCD3E8BF91B771D57", hash_generated_method = "87EC0E5FE7272EC4B1EF66733497D057")
    public boolean areAllItemsEnabled() {
        {
            boolean var9C54E106A28E5AC5432E590C5A6E2813_46806499 = (mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1173020398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1173020398;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.718 -0400", hash_original_method = "DF42B35442C4183A344219B7FD0FCDD1", hash_generated_method = "5F067F7CDBD5EA68F2654B6713D3D539")
    public boolean isEnabled(int position) {
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            boolean var2010CA47FC71AF2CAA3A2C68AB451F64_282098759 = (mHeaderViewInfos.get(position).isSelectable);
        } //End block
        int adjPosition;
        adjPosition = position - numHeaders;
        int adapterCount;
        adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                boolean var976993602ACCF2E54C9355F58E9BFB82_1507194472 = (mAdapter.isEnabled(adjPosition));
            } //End block
        } //End block
        boolean var1751AB55CF32B4B2D54E9279FA0C1F29_1766931199 = (mFooterViewInfos.get(adjPosition - adapterCount).isSelectable);
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_640996851 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_640996851;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.738 -0400", hash_original_method = "5FB1DDE7849FB7B1EE35000192AE1125", hash_generated_method = "2BB08F03A5E60BACD3027C7D03D7FBDB")
    public Object getItem(int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_351705190 = null; //Variable for return #1
        Object varB4EAC82CA7396A68D541C85D26508E83_1644804100 = null; //Variable for return #2
        Object varB4EAC82CA7396A68D541C85D26508E83_311658488 = null; //Variable for return #3
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            varB4EAC82CA7396A68D541C85D26508E83_351705190 = mHeaderViewInfos.get(position).data;
        } //End block
        int adjPosition;
        adjPosition = position - numHeaders;
        int adapterCount;
        adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1644804100 = mAdapter.getItem(adjPosition);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_311658488 = mFooterViewInfos.get(adjPosition - adapterCount).data;
        addTaint(position);
        Object varA7E53CE21691AB073D9660D615818899_446348727; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_446348727 = varB4EAC82CA7396A68D541C85D26508E83_351705190;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_446348727 = varB4EAC82CA7396A68D541C85D26508E83_1644804100;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_446348727 = varB4EAC82CA7396A68D541C85D26508E83_311658488;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_446348727.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_446348727;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.739 -0400", hash_original_method = "0EFF2641ED72ED5C174A1DFD9DE35423", hash_generated_method = "2764E902EC08F30CAB11F02DB60F5659")
    public long getItemId(int position) {
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            int adjPosition;
            adjPosition = position - numHeaders;
            int adapterCount;
            adapterCount = mAdapter.getCount();
            {
                long var99E8EC83666448CE62AC20755BD9065F_1122496827 = (mAdapter.getItemId(adjPosition));
            } //End block
        } //End block
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1439376448 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1439376448;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.758 -0400", hash_original_method = "5C897DB1697E65CD415A86C35E25516F", hash_generated_method = "3EB6026E7F9BAC0387ABEF469AC027D4")
    public boolean hasStableIds() {
        {
            boolean varFDE3CC3D22CA5BAB554F3ECCA23F98B2_1720324415 = (mAdapter.hasStableIds());
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922613000 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_922613000;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.hasStableIds();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.763 -0400", hash_original_method = "B94999E1741825084E6BE4B30684EEAE", hash_generated_method = "7ED84AF283AA99D25ECDC75B3D136C0C")
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_1493465673 = null; //Variable for return #1
        View varB4EAC82CA7396A68D541C85D26508E83_934120679 = null; //Variable for return #2
        View varB4EAC82CA7396A68D541C85D26508E83_1041228993 = null; //Variable for return #3
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1493465673 = mHeaderViewInfos.get(position).view;
        } //End block
        int adjPosition;
        adjPosition = position - numHeaders;
        int adapterCount;
        adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                varB4EAC82CA7396A68D541C85D26508E83_934120679 = mAdapter.getView(adjPosition, convertView, parent);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1041228993 = mFooterViewInfos.get(adjPosition - adapterCount).view;
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1011095454; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1011095454 = varB4EAC82CA7396A68D541C85D26508E83_1493465673;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1011095454 = varB4EAC82CA7396A68D541C85D26508E83_934120679;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1011095454 = varB4EAC82CA7396A68D541C85D26508E83_1041228993;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1011095454.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1011095454;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.763 -0400", hash_original_method = "18109841CF71190B9879A21F432A9D28", hash_generated_method = "BC2E1154F199EB4EE8D9CF2A72BE63FE")
    public int getItemViewType(int position) {
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            int adjPosition;
            adjPosition = position - numHeaders;
            int adapterCount;
            adapterCount = mAdapter.getCount();
            {
                int var645C3D1547C170A59D2EE81F83FA9020_2011186133 = (mAdapter.getItemViewType(adjPosition));
            } //End block
        } //End block
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487346114 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1487346114;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.764 -0400", hash_original_method = "8F6564F3EA2E826663B1C340FEA4D3E0", hash_generated_method = "D0D3BF7BC6B8125248976ABC11B847FF")
    public int getViewTypeCount() {
        {
            int var0AD31D021E508485C7C9D8AAC7CD7F8E_1950902990 = (mAdapter.getViewTypeCount());
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784757276 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_784757276;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.getViewTypeCount();
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.764 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "394F8D6D1C3E11D04B82C1A93DEB883B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.764 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "CA1E1CE41BA81DA1B5FFC90A490DA640")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.765 -0400", hash_original_method = "9E800AF0A66A6C48391AEDACEAEC8859", hash_generated_method = "1F3729C9DFFC3209C7C9C725147D4944")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_372223621 = null; //Variable for return #1
        Filter varB4EAC82CA7396A68D541C85D26508E83_398954560 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_372223621 = ((Filterable) mAdapter).getFilter();
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_398954560 = null;
        Filter varA7E53CE21691AB073D9660D615818899_1796689532; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1796689532 = varB4EAC82CA7396A68D541C85D26508E83_372223621;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1796689532 = varB4EAC82CA7396A68D541C85D26508E83_398954560;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1796689532.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1796689532;
        // ---------- Original Method ----------
        //if (mIsFilterable) {
            //return ((Filterable) mAdapter).getFilter();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.765 -0400", hash_original_method = "16C6428A588CE1C0BF49AB22D8718A60", hash_generated_method = "0C042DEDF832F50592A747790C560E0A")
    public ListAdapter getWrappedAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_1224934000 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1224934000 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1224934000.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1224934000;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:07.765 -0400", hash_original_field = "E7B5861FDFB008C25413C9B2AC5A155E", hash_generated_field = "2EAD8918C42A1ED65AC4BB057808474F")

    static ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST = new ArrayList<ListView.FixedViewInfo>();
}

