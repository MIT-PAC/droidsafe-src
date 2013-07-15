package android.widget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class HeaderViewListAdapter implements WrapperListAdapter, Filterable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.619 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.619 -0400", hash_original_field = "8B3453F15529335E224866A4AFCB80E3", hash_generated_field = "1174AC07D1E0FF5BE8FD7B73F622A98F")

    ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.619 -0400", hash_original_field = "B8FDAC0951330D9E01F6B98B286C3F3E", hash_generated_field = "88602AC90A2A75CECE8836CF4FDB527C")

    ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.619 -0400", hash_original_field = "A77BBF288DDB83C524B2E9A07CB0CFB5", hash_generated_field = "2DA9D21A65202F474DD30A137186E034")

    boolean mAreAllFixedViewsSelectable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.619 -0400", hash_original_field = "6B708799D01ECAD7FAB52020404D876D", hash_generated_field = "6776BDE0D016372C684D038A88F70F04")

    private boolean mIsFilterable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.621 -0400", hash_original_method = "ED7F7094A6F9A9163E3FAE563C0A2BCF", hash_generated_method = "B3D70A7B69F7FF758815553830468E0B")
    public  HeaderViewListAdapter(ArrayList<ListView.FixedViewInfo> headerViewInfos,
                                 ArrayList<ListView.FixedViewInfo> footerViewInfos,
                                 ListAdapter adapter) {
        mAdapter = adapter;
        mIsFilterable = adapter instanceof Filterable;
    if(headerViewInfos == null)        
        {
            mHeaderViewInfos = EMPTY_INFO_LIST;
        } //End block
        else
        {
            mHeaderViewInfos = headerViewInfos;
        } //End block
    if(footerViewInfos == null)        
        {
            mFooterViewInfos = EMPTY_INFO_LIST;
        } //End block
        else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.622 -0400", hash_original_method = "F816FE78C9557554F8C5B6BB80A06D13", hash_generated_method = "DB6CA62863854ABAC966242244F308F6")
    public int getHeadersCount() {
        int varEC0BB00903232C4A08E22EDBBBDDB3B9_210762317 = (mHeaderViewInfos.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018778269 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2018778269;
        // ---------- Original Method ----------
        //return mHeaderViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.622 -0400", hash_original_method = "03601E80550495DBAEB6124EE960EF9F", hash_generated_method = "87D201D0B5F6D1863A55573340671A49")
    public int getFootersCount() {
        int var290018E65E5025ADA8657290793A446E_439758566 = (mFooterViewInfos.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457052370 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_457052370;
        // ---------- Original Method ----------
        //return mFooterViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.623 -0400", hash_original_method = "D7DEAD009C651EAC8E2A235B793425D9", hash_generated_method = "DA6E8C44342F9AF28BF7FE2C4E0D09BE")
    public boolean isEmpty() {
        boolean varD9E32D821C4CD0FE1F9CC72AC30ED7E9_945701244 = (mAdapter == null || mAdapter.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1791274986 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1791274986;
        // ---------- Original Method ----------
        //return mAdapter == null || mAdapter.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.623 -0400", hash_original_method = "41241BC7260E3C26DE66CCD5C227EECC", hash_generated_method = "F593AE2F8BA860AE99AA42D08ABE5E57")
    private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> infos) {
        addTaint(infos.getTaint());
    if(infos != null)        
        {
for(ListView.FixedViewInfo info : infos)
            {
    if(!info.isSelectable)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_523225297 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_514761868 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_514761868;
                } //End block
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_959021443 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_664424903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_664424903;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.624 -0400", hash_original_method = "92115EA33573B801358871B3CD0766B3", hash_generated_method = "41AFDD44CDC3E1DA9C9D29324EC66190")
    public boolean removeHeader(View v) {
        addTaint(v.getTaint());
for(int i = 0;i < mHeaderViewInfos.size();i++)
        {
            ListView.FixedViewInfo info = mHeaderViewInfos.get(i);
    if(info.view == v)            
            {
                mHeaderViewInfos.remove(i);
                mAreAllFixedViewsSelectable =
                        areAllListInfosSelectable(mHeaderViewInfos)
                        && areAllListInfosSelectable(mFooterViewInfos);
                boolean varB326B5062B2F0E69046810717534CB09_1676906176 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1556297587 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1556297587;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_295381197 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2124675641 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2124675641;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.625 -0400", hash_original_method = "C18E7E6A93212BDE730ADAF32E087D6A", hash_generated_method = "98953BE534F82007D6E4854EB7A1BBCE")
    public boolean removeFooter(View v) {
        addTaint(v.getTaint());
for(int i = 0;i < mFooterViewInfos.size();i++)
        {
            ListView.FixedViewInfo info = mFooterViewInfos.get(i);
    if(info.view == v)            
            {
                mFooterViewInfos.remove(i);
                mAreAllFixedViewsSelectable =
                        areAllListInfosSelectable(mHeaderViewInfos)
                        && areAllListInfosSelectable(mFooterViewInfos);
                boolean varB326B5062B2F0E69046810717534CB09_1461816404 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1785347619 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1785347619;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_855504779 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1638374816 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1638374816;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.625 -0400", hash_original_method = "5EA4C802749955ACC8971AB13A15905C", hash_generated_method = "39514B67DF5743BCFE219DC493E5BB85")
    public int getCount() {
    if(mAdapter != null)        
        {
            int var3241752E7D8661E02B6EEA2ED17B8E7A_343038706 = (getFootersCount() + getHeadersCount() + mAdapter.getCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581872724 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_581872724;
        } //End block
        else
        {
            int var28944B93C096C960DC1688A54560CBE2_2063332301 = (getFootersCount() + getHeadersCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341811557 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_341811557;
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return getFootersCount() + getHeadersCount() + mAdapter.getCount();
        //} else {
            //return getFootersCount() + getHeadersCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.625 -0400", hash_original_method = "BA6CC34361A3C86CCD3E8BF91B771D57", hash_generated_method = "A3A91F13492466C143333A4A2BEFD992")
    public boolean areAllItemsEnabled() {
    if(mAdapter != null)        
        {
            boolean varA6101A64396D6403047EC68F69AE5128_1830286434 = (mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110273330 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_110273330;
        } //End block
        else
        {
            boolean varB326B5062B2F0E69046810717534CB09_1847839949 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_675286234 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_675286234;
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.626 -0400", hash_original_method = "DF42B35442C4183A344219B7FD0FCDD1", hash_generated_method = "5F2DB64DFE99A48CFDEE223F984F8905")
    public boolean isEnabled(int position) {
        addTaint(position);
        int numHeaders = getHeadersCount();
    if(position < numHeaders)        
        {
            boolean var30157183DF2787D18A871909F0327DCA_392690013 = (mHeaderViewInfos.get(position).isSelectable);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1535108921 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1535108921;
        } //End block
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
    if(mAdapter != null)        
        {
            adapterCount = mAdapter.getCount();
    if(adjPosition < adapterCount)            
            {
                boolean var4C43D253CDA0B0BC1F497A7D7543BDDB_752870979 = (mAdapter.isEnabled(adjPosition));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720085504 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720085504;
            } //End block
        } //End block
        boolean var4097CC8FC94B53C875A7B9B7DB70D2F5_609087491 = (mFooterViewInfos.get(adjPosition - adapterCount).isSelectable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1461991680 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1461991680;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.627 -0400", hash_original_method = "5FB1DDE7849FB7B1EE35000192AE1125", hash_generated_method = "A8F07D29168EB2D2268209A3975F2D75")
    public Object getItem(int position) {
        addTaint(position);
        int numHeaders = getHeadersCount();
    if(position < numHeaders)        
        {
Object var290869F2955AE7DED08C5E8EA47554D5_1687325918 =             mHeaderViewInfos.get(position).data;
            var290869F2955AE7DED08C5E8EA47554D5_1687325918.addTaint(taint);
            return var290869F2955AE7DED08C5E8EA47554D5_1687325918;
        } //End block
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
    if(mAdapter != null)        
        {
            adapterCount = mAdapter.getCount();
    if(adjPosition < adapterCount)            
            {
Object var3B505FBB918E8ACD45D7F7D683201487_2069341200 =                 mAdapter.getItem(adjPosition);
                var3B505FBB918E8ACD45D7F7D683201487_2069341200.addTaint(taint);
                return var3B505FBB918E8ACD45D7F7D683201487_2069341200;
            } //End block
        } //End block
Object var85102CE5F5A2765360D9B519031AA68E_1967778577 =         mFooterViewInfos.get(adjPosition - adapterCount).data;
        var85102CE5F5A2765360D9B519031AA68E_1967778577.addTaint(taint);
        return var85102CE5F5A2765360D9B519031AA68E_1967778577;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.627 -0400", hash_original_method = "0EFF2641ED72ED5C174A1DFD9DE35423", hash_generated_method = "DEC9BD211CFD9656752751721086AD25")
    public long getItemId(int position) {
        addTaint(position);
        int numHeaders = getHeadersCount();
    if(mAdapter != null && position >= numHeaders)        
        {
            int adjPosition = position - numHeaders;
            int adapterCount = mAdapter.getCount();
    if(adjPosition < adapterCount)            
            {
                long var87281ABAD68856DB82E24EAC34178CF8_2120531102 = (mAdapter.getItemId(adjPosition));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1617291824 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1617291824;
            } //End block
        } //End block
        long var6BB61E3B7BCE0931DA574D19D1D82C88_567736885 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_78253998 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_78253998;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.628 -0400", hash_original_method = "5C897DB1697E65CD415A86C35E25516F", hash_generated_method = "E47959215F68186D94906303270B36B5")
    public boolean hasStableIds() {
    if(mAdapter != null)        
        {
            boolean var119BF31D74B3F724AAFCA804527305FD_730762807 = (mAdapter.hasStableIds());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_656898165 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_656898165;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1976620059 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1927884202 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1927884202;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.hasStableIds();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.628 -0400", hash_original_method = "B94999E1741825084E6BE4B30684EEAE", hash_generated_method = "E3138F36196B57D5D6C3146C944EEF76")
    public View getView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
        int numHeaders = getHeadersCount();
    if(position < numHeaders)        
        {
View varCB63BA7FA759F1F9DC52E0CAAEB8BBE9_2142598138 =             mHeaderViewInfos.get(position).view;
            varCB63BA7FA759F1F9DC52E0CAAEB8BBE9_2142598138.addTaint(taint);
            return varCB63BA7FA759F1F9DC52E0CAAEB8BBE9_2142598138;
        } //End block
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
    if(mAdapter != null)        
        {
            adapterCount = mAdapter.getCount();
    if(adjPosition < adapterCount)            
            {
View varC1514BA58B8E68706140CE4F92AE3424_1446334881 =                 mAdapter.getView(adjPosition, convertView, parent);
                varC1514BA58B8E68706140CE4F92AE3424_1446334881.addTaint(taint);
                return varC1514BA58B8E68706140CE4F92AE3424_1446334881;
            } //End block
        } //End block
View var887F5CA95EB2A1066712B07A6B2AD732_545629579 =         mFooterViewInfos.get(adjPosition - adapterCount).view;
        var887F5CA95EB2A1066712B07A6B2AD732_545629579.addTaint(taint);
        return var887F5CA95EB2A1066712B07A6B2AD732_545629579;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.629 -0400", hash_original_method = "18109841CF71190B9879A21F432A9D28", hash_generated_method = "165FA9464A799D9116EA4AD738ED33C3")
    public int getItemViewType(int position) {
        addTaint(position);
        int numHeaders = getHeadersCount();
    if(mAdapter != null && position >= numHeaders)        
        {
            int adjPosition = position - numHeaders;
            int adapterCount = mAdapter.getCount();
    if(adjPosition < adapterCount)            
            {
                int var25444017BD2D75DF8CC5AE07065DD7D3_1473540449 = (mAdapter.getItemViewType(adjPosition));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025964628 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025964628;
            } //End block
        } //End block
        int varD2DF48644AF99B2F15893F1C2BFF94E4_1119464523 = (AdapterView.ITEM_VIEW_TYPE_HEADER_OR_FOOTER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304808055 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1304808055;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.629 -0400", hash_original_method = "8F6564F3EA2E826663B1C340FEA4D3E0", hash_generated_method = "7C0B72537CC2E68CE0D8784F89AE13A4")
    public int getViewTypeCount() {
    if(mAdapter != null)        
        {
            int var6CFD29AF0C4A694E53F64930AB480CDF_369137574 = (mAdapter.getViewTypeCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189259529 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_189259529;
        } //End block
        int varC4CA4238A0B923820DCC509A6F75849B_1945825726 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123597327 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_123597327;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.getViewTypeCount();
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.629 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "32335E466B0703D3E78FB752261F1D23")
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
    if(mAdapter != null)        
        {
            mAdapter.registerDataSetObserver(observer);
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //mAdapter.registerDataSetObserver(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.630 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "47FC584A630BA9EEE65988188E6FA0FB")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
    if(mAdapter != null)        
        {
            mAdapter.unregisterDataSetObserver(observer);
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //mAdapter.unregisterDataSetObserver(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.630 -0400", hash_original_method = "9E800AF0A66A6C48391AEDACEAEC8859", hash_generated_method = "AE5BAE0676642438D4C84865542B66ED")
    public Filter getFilter() {
    if(mIsFilterable)        
        {
Filter varBA677C0C4F060B90F0F3696B5ADE4CC1_1093475147 =             ((Filterable) mAdapter).getFilter();
            varBA677C0C4F060B90F0F3696B5ADE4CC1_1093475147.addTaint(taint);
            return varBA677C0C4F060B90F0F3696B5ADE4CC1_1093475147;
        } //End block
Filter var540C13E9E156B687226421B24F2DF178_1510945643 =         null;
        var540C13E9E156B687226421B24F2DF178_1510945643.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1510945643;
        // ---------- Original Method ----------
        //if (mIsFilterable) {
            //return ((Filterable) mAdapter).getFilter();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.630 -0400", hash_original_method = "16C6428A588CE1C0BF49AB22D8718A60", hash_generated_method = "47798F05C051E43F9519B0E222A6317D")
    public ListAdapter getWrappedAdapter() {
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_1673574595 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_1673574595.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_1673574595;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:06.630 -0400", hash_original_field = "E7B5861FDFB008C25413C9B2AC5A155E", hash_generated_field = "AFA2D504E586D40E24D6E51B6C43EEE0")

    static final ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST = new ArrayList<ListView.FixedViewInfo>();
}

