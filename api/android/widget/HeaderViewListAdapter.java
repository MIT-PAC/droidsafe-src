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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.830 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.830 -0400", hash_original_field = "8B3453F15529335E224866A4AFCB80E3", hash_generated_field = "1174AC07D1E0FF5BE8FD7B73F622A98F")

    ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.830 -0400", hash_original_field = "B8FDAC0951330D9E01F6B98B286C3F3E", hash_generated_field = "88602AC90A2A75CECE8836CF4FDB527C")

    ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.830 -0400", hash_original_field = "A77BBF288DDB83C524B2E9A07CB0CFB5", hash_generated_field = "2DA9D21A65202F474DD30A137186E034")

    boolean mAreAllFixedViewsSelectable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.830 -0400", hash_original_field = "6B708799D01ECAD7FAB52020404D876D", hash_generated_field = "6776BDE0D016372C684D038A88F70F04")

    private boolean mIsFilterable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.832 -0400", hash_original_method = "ED7F7094A6F9A9163E3FAE563C0A2BCF", hash_generated_method = "B3D70A7B69F7FF758815553830468E0B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.832 -0400", hash_original_method = "F816FE78C9557554F8C5B6BB80A06D13", hash_generated_method = "791D5399842FD9606073CC8C835A8F79")
    public int getHeadersCount() {
        int varEC0BB00903232C4A08E22EDBBBDDB3B9_634597927 = (mHeaderViewInfos.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300794992 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_300794992;
        // ---------- Original Method ----------
        //return mHeaderViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.833 -0400", hash_original_method = "03601E80550495DBAEB6124EE960EF9F", hash_generated_method = "5DD7A28E40DABD909D8A61BA03A15A6E")
    public int getFootersCount() {
        int var290018E65E5025ADA8657290793A446E_947470116 = (mFooterViewInfos.size());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907608844 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907608844;
        // ---------- Original Method ----------
        //return mFooterViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.833 -0400", hash_original_method = "D7DEAD009C651EAC8E2A235B793425D9", hash_generated_method = "DC03686CB7452FA4208AF404E225C040")
    public boolean isEmpty() {
        boolean varD9E32D821C4CD0FE1F9CC72AC30ED7E9_552159449 = (mAdapter == null || mAdapter.isEmpty());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_331512602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_331512602;
        // ---------- Original Method ----------
        //return mAdapter == null || mAdapter.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.833 -0400", hash_original_method = "41241BC7260E3C26DE66CCD5C227EECC", hash_generated_method = "ED81AE9C45D5F5B1CE4B82CA13417B67")
    private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> infos) {
        addTaint(infos.getTaint());
        if(infos != null)        
        {
for(ListView.FixedViewInfo info : infos)
            {
                if(!info.isSelectable)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_288500710 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417489657 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417489657;
                } //End block
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_199490426 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1477932442 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1477932442;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.834 -0400", hash_original_method = "92115EA33573B801358871B3CD0766B3", hash_generated_method = "23D90EBC302AC56F2F93D2574D8D866A")
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
                boolean varB326B5062B2F0E69046810717534CB09_1610466128 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_472661458 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_472661458;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1306752907 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146804820 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146804820;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.835 -0400", hash_original_method = "C18E7E6A93212BDE730ADAF32E087D6A", hash_generated_method = "4A697BC3D4C568D6742567176FA42166")
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
                boolean varB326B5062B2F0E69046810717534CB09_1092503510 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1801886161 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1801886161;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_727517993 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_273368325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_273368325;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.835 -0400", hash_original_method = "5EA4C802749955ACC8971AB13A15905C", hash_generated_method = "58A4165C8F36DF0B49B89FE3154A760F")
    public int getCount() {
        if(mAdapter != null)        
        {
            int var3241752E7D8661E02B6EEA2ED17B8E7A_592721278 = (getFootersCount() + getHeadersCount() + mAdapter.getCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672156244 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1672156244;
        } //End block
        else
        {
            int var28944B93C096C960DC1688A54560CBE2_1922489500 = (getFootersCount() + getHeadersCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577973367 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1577973367;
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return getFootersCount() + getHeadersCount() + mAdapter.getCount();
        //} else {
            //return getFootersCount() + getHeadersCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.836 -0400", hash_original_method = "BA6CC34361A3C86CCD3E8BF91B771D57", hash_generated_method = "57C08C556A9F43FB54CBE83341F6070B")
    public boolean areAllItemsEnabled() {
        if(mAdapter != null)        
        {
            boolean varA6101A64396D6403047EC68F69AE5128_903308559 = (mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_239910795 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_239910795;
        } //End block
        else
        {
            boolean varB326B5062B2F0E69046810717534CB09_1485909282 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891677720 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_891677720;
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.837 -0400", hash_original_method = "DF42B35442C4183A344219B7FD0FCDD1", hash_generated_method = "EBB06D63512D1CB769BF000A4D3E67FC")
    public boolean isEnabled(int position) {
        addTaint(position);
        int numHeaders = getHeadersCount();
        if(position < numHeaders)        
        {
            boolean var30157183DF2787D18A871909F0327DCA_1389809859 = (mHeaderViewInfos.get(position).isSelectable);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1046746504 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1046746504;
        } //End block
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if(mAdapter != null)        
        {
            adapterCount = mAdapter.getCount();
            if(adjPosition < adapterCount)            
            {
                boolean var4C43D253CDA0B0BC1F497A7D7543BDDB_1901688002 = (mAdapter.isEnabled(adjPosition));
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324796951 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324796951;
            } //End block
        } //End block
        boolean var4097CC8FC94B53C875A7B9B7DB70D2F5_1994616891 = (mFooterViewInfos.get(adjPosition - adapterCount).isSelectable);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1950082163 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1950082163;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.838 -0400", hash_original_method = "5FB1DDE7849FB7B1EE35000192AE1125", hash_generated_method = "72CF2D2A102EEF40F266B53ABBBA6954")
    public Object getItem(int position) {
        addTaint(position);
        int numHeaders = getHeadersCount();
        if(position < numHeaders)        
        {
Object var290869F2955AE7DED08C5E8EA47554D5_1597025072 =             mHeaderViewInfos.get(position).data;
            var290869F2955AE7DED08C5E8EA47554D5_1597025072.addTaint(taint);
            return var290869F2955AE7DED08C5E8EA47554D5_1597025072;
        } //End block
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if(mAdapter != null)        
        {
            adapterCount = mAdapter.getCount();
            if(adjPosition < adapterCount)            
            {
Object var3B505FBB918E8ACD45D7F7D683201487_18820632 =                 mAdapter.getItem(adjPosition);
                var3B505FBB918E8ACD45D7F7D683201487_18820632.addTaint(taint);
                return var3B505FBB918E8ACD45D7F7D683201487_18820632;
            } //End block
        } //End block
Object var85102CE5F5A2765360D9B519031AA68E_1869062222 =         mFooterViewInfos.get(adjPosition - adapterCount).data;
        var85102CE5F5A2765360D9B519031AA68E_1869062222.addTaint(taint);
        return var85102CE5F5A2765360D9B519031AA68E_1869062222;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.839 -0400", hash_original_method = "0EFF2641ED72ED5C174A1DFD9DE35423", hash_generated_method = "68AE4E8FD833D4BBF84E8EA7D16A462F")
    public long getItemId(int position) {
        addTaint(position);
        int numHeaders = getHeadersCount();
        if(mAdapter != null && position >= numHeaders)        
        {
            int adjPosition = position - numHeaders;
            int adapterCount = mAdapter.getCount();
            if(adjPosition < adapterCount)            
            {
                long var87281ABAD68856DB82E24EAC34178CF8_1033124544 = (mAdapter.getItemId(adjPosition));
                                long var0F5264038205EDFB1AC05FBB0E8C5E94_1053768711 = getTaintLong();
                return var0F5264038205EDFB1AC05FBB0E8C5E94_1053768711;
            } //End block
        } //End block
        long var6BB61E3B7BCE0931DA574D19D1D82C88_1658644266 = (-1);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1706965387 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1706965387;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.840 -0400", hash_original_method = "5C897DB1697E65CD415A86C35E25516F", hash_generated_method = "D5A31B945543C6C51F6A73D0F1FD2D94")
    public boolean hasStableIds() {
        if(mAdapter != null)        
        {
            boolean var119BF31D74B3F724AAFCA804527305FD_126247609 = (mAdapter.hasStableIds());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_939113184 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_939113184;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_392623797 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_983093102 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_983093102;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.hasStableIds();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.841 -0400", hash_original_method = "B94999E1741825084E6BE4B30684EEAE", hash_generated_method = "452E85088C7AA777E9B5F6CE0381CD70")
    public View getView(int position, View convertView, ViewGroup parent) {
        addTaint(parent.getTaint());
        addTaint(convertView.getTaint());
        addTaint(position);
        int numHeaders = getHeadersCount();
        if(position < numHeaders)        
        {
View varCB63BA7FA759F1F9DC52E0CAAEB8BBE9_306455639 =             mHeaderViewInfos.get(position).view;
            varCB63BA7FA759F1F9DC52E0CAAEB8BBE9_306455639.addTaint(taint);
            return varCB63BA7FA759F1F9DC52E0CAAEB8BBE9_306455639;
        } //End block
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if(mAdapter != null)        
        {
            adapterCount = mAdapter.getCount();
            if(adjPosition < adapterCount)            
            {
View varC1514BA58B8E68706140CE4F92AE3424_2072816020 =                 mAdapter.getView(adjPosition, convertView, parent);
                varC1514BA58B8E68706140CE4F92AE3424_2072816020.addTaint(taint);
                return varC1514BA58B8E68706140CE4F92AE3424_2072816020;
            } //End block
        } //End block
View var887F5CA95EB2A1066712B07A6B2AD732_485929044 =         mFooterViewInfos.get(adjPosition - adapterCount).view;
        var887F5CA95EB2A1066712B07A6B2AD732_485929044.addTaint(taint);
        return var887F5CA95EB2A1066712B07A6B2AD732_485929044;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.842 -0400", hash_original_method = "18109841CF71190B9879A21F432A9D28", hash_generated_method = "35AEB448640095FDC45305AC7AEB7BF2")
    public int getItemViewType(int position) {
        addTaint(position);
        int numHeaders = getHeadersCount();
        if(mAdapter != null && position >= numHeaders)        
        {
            int adjPosition = position - numHeaders;
            int adapterCount = mAdapter.getCount();
            if(adjPosition < adapterCount)            
            {
                int var25444017BD2D75DF8CC5AE07065DD7D3_852144177 = (mAdapter.getItemViewType(adjPosition));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2019427812 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2019427812;
            } //End block
        } //End block
        int varD2DF48644AF99B2F15893F1C2BFF94E4_38679651 = (AdapterView.ITEM_VIEW_TYPE_HEADER_OR_FOOTER);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302560192 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302560192;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.843 -0400", hash_original_method = "8F6564F3EA2E826663B1C340FEA4D3E0", hash_generated_method = "48D59D4E92CF7F71655A0CD12D9F5569")
    public int getViewTypeCount() {
        if(mAdapter != null)        
        {
            int var6CFD29AF0C4A694E53F64930AB480CDF_1141790686 = (mAdapter.getViewTypeCount());
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280641842 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1280641842;
        } //End block
        int varC4CA4238A0B923820DCC509A6F75849B_215610491 = (1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588679777 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_588679777;
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.getViewTypeCount();
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.844 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "32335E466B0703D3E78FB752261F1D23")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.844 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "47FC584A630BA9EEE65988188E6FA0FB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.844 -0400", hash_original_method = "9E800AF0A66A6C48391AEDACEAEC8859", hash_generated_method = "8EEB73589492AD7E91CFFA70A74D98AF")
    public Filter getFilter() {
        if(mIsFilterable)        
        {
Filter varBA677C0C4F060B90F0F3696B5ADE4CC1_1363634638 =             ((Filterable) mAdapter).getFilter();
            varBA677C0C4F060B90F0F3696B5ADE4CC1_1363634638.addTaint(taint);
            return varBA677C0C4F060B90F0F3696B5ADE4CC1_1363634638;
        } //End block
Filter var540C13E9E156B687226421B24F2DF178_1626070060 =         null;
        var540C13E9E156B687226421B24F2DF178_1626070060.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1626070060;
        // ---------- Original Method ----------
        //if (mIsFilterable) {
            //return ((Filterable) mAdapter).getFilter();
        //}
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.845 -0400", hash_original_method = "16C6428A588CE1C0BF49AB22D8718A60", hash_generated_method = "EB5826CF9E61E5B38E8DD4B4D62D0A7D")
    public ListAdapter getWrappedAdapter() {
ListAdapter varD72668EDE5E63ADF9340F3D8A19FD205_1861793026 =         mAdapter;
        varD72668EDE5E63ADF9340F3D8A19FD205_1861793026.addTaint(taint);
        return varD72668EDE5E63ADF9340F3D8A19FD205_1861793026;
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:00.845 -0400", hash_original_field = "E7B5861FDFB008C25413C9B2AC5A155E", hash_generated_field = "AFA2D504E586D40E24D6E51B6C43EEE0")

    static final ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST = new ArrayList<ListView.FixedViewInfo>();
}

