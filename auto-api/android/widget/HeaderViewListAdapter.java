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
    private ListAdapter mAdapter;
    ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
    ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
    boolean mAreAllFixedViewsSelectable;
    private boolean mIsFilterable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.988 -0400", hash_original_method = "ED7F7094A6F9A9163E3FAE563C0A2BCF", hash_generated_method = "80D7687BDF80D4540EF17DC1123C7B09")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public HeaderViewListAdapter(ArrayList<ListView.FixedViewInfo> headerViewInfos,
                                 ArrayList<ListView.FixedViewInfo> footerViewInfos,
                                 ListAdapter adapter) {
        dsTaint.addTaint(footerViewInfos.dsTaint);
        dsTaint.addTaint(headerViewInfos.dsTaint);
        dsTaint.addTaint(adapter.dsTaint);
        mIsFilterable = adapter instanceof Filterable;
        {
            mHeaderViewInfos = EMPTY_INFO_LIST;
        } //End block
        {
            mFooterViewInfos = EMPTY_INFO_LIST;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.988 -0400", hash_original_method = "F816FE78C9557554F8C5B6BB80A06D13", hash_generated_method = "667EF3683C6DCAF39D95DC35D8BE3C98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getHeadersCount() {
        int var51EB21BA6322BC21883B38109F793DB7_1892492475 = (mHeaderViewInfos.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mHeaderViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.988 -0400", hash_original_method = "03601E80550495DBAEB6124EE960EF9F", hash_generated_method = "3A9817C78968951EA766757EE719A5B7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getFootersCount() {
        int var05D2A206262A11BE7E645CDC53B4074D_214808696 = (mFooterViewInfos.size());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFooterViewInfos.size();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.989 -0400", hash_original_method = "D7DEAD009C651EAC8E2A235B793425D9", hash_generated_method = "4B566C6C5E0165896DFCCDC6983C2C10")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEmpty() {
        boolean varD35419911CAF869FB18BA02856781F0C_865154051 = (mAdapter == null || mAdapter.isEmpty());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAdapter == null || mAdapter.isEmpty();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.997 -0400", hash_original_method = "41241BC7260E3C26DE66CCD5C227EECC", hash_generated_method = "800788CA4AEE597AE02DC34A9536884A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> infos) {
        dsTaint.addTaint(infos.dsTaint);
        {
            {
                Iterator<ListView.FixedViewInfo> var8B5947E9D1DF62DF443918DA5B663B89_425146159 = (infos).iterator();
                var8B5947E9D1DF62DF443918DA5B663B89_425146159.hasNext();
                ListView.FixedViewInfo info = var8B5947E9D1DF62DF443918DA5B663B89_425146159.next();
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.998 -0400", hash_original_method = "92115EA33573B801358871B3CD0766B3", hash_generated_method = "0D1D546EC62A893435FD22231938CCC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeHeader(View v) {
        dsTaint.addTaint(v.dsTaint);
        {
            int i;
            i = 0;
            boolean var3B35C29B0489E7CC40865002A99AAA03_840393952 = (i < mHeaderViewInfos.size());
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.998 -0400", hash_original_method = "C18E7E6A93212BDE730ADAF32E087D6A", hash_generated_method = "1C568F3A5B876F6952A8F97A763DF787")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean removeFooter(View v) {
        dsTaint.addTaint(v.dsTaint);
        {
            int i;
            i = 0;
            boolean varC9FB87404C9C311F63579621314C75C2_2118151064 = (i < mFooterViewInfos.size());
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
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.998 -0400", hash_original_method = "5EA4C802749955ACC8971AB13A15905C", hash_generated_method = "B45A8B0AAE14607931DAB23C0DEE6F50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCount() {
        {
            int var661984E76F04D752B1BAEC58283825F0_2017810061 = (getFootersCount() + getHeadersCount() + mAdapter.getCount());
        } //End block
        {
            int varE487CA7829F9BC3C8EBD5B664AB8BEFB_1840789454 = (getFootersCount() + getHeadersCount());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return getFootersCount() + getHeadersCount() + mAdapter.getCount();
        //} else {
            //return getFootersCount() + getHeadersCount();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.998 -0400", hash_original_method = "BA6CC34361A3C86CCD3E8BF91B771D57", hash_generated_method = "D9DB492466A6EA4D164C4046BCC2D198")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean areAllItemsEnabled() {
        {
            boolean var9C54E106A28E5AC5432E590C5A6E2813_1616179566 = (mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
        //} else {
            //return true;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.999 -0400", hash_original_method = "DF42B35442C4183A344219B7FD0FCDD1", hash_generated_method = "06F2DE988016395649367E11ECB46149")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isEnabled(int position) {
        dsTaint.addTaint(position);
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            boolean var2010CA47FC71AF2CAA3A2C68AB451F64_1737016065 = (mHeaderViewInfos.get(position).isSelectable);
        } //End block
        int adjPosition;
        adjPosition = position - numHeaders;
        int adapterCount;
        adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                boolean var976993602ACCF2E54C9355F58E9BFB82_803121891 = (mAdapter.isEnabled(adjPosition));
            } //End block
        } //End block
        boolean var1751AB55CF32B4B2D54E9279FA0C1F29_453823955 = (mFooterViewInfos.get(adjPosition - adapterCount).isSelectable);
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.999 -0400", hash_original_method = "5FB1DDE7849FB7B1EE35000192AE1125", hash_generated_method = "4C8866DE9D614320D477FF7B8125A12E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getItem(int position) {
        dsTaint.addTaint(position);
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            Object var6AB7D0FA28C8211C530E4CB0215B2508_1532548648 = (mHeaderViewInfos.get(position).data);
        } //End block
        int adjPosition;
        adjPosition = position - numHeaders;
        int adapterCount;
        adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                Object varBCF674558F683A280220A2833763211A_1794914941 = (mAdapter.getItem(adjPosition));
            } //End block
        } //End block
        Object varD0E75503EF9E3817387D601D9E247170_2080709378 = (mFooterViewInfos.get(adjPosition - adapterCount).data);
        return (Object)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.999 -0400", hash_original_method = "0EFF2641ED72ED5C174A1DFD9DE35423", hash_generated_method = "2A52C96A17119C27F11F9057FD074427")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public long getItemId(int position) {
        dsTaint.addTaint(position);
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            int adjPosition;
            adjPosition = position - numHeaders;
            int adapterCount;
            adapterCount = mAdapter.getCount();
            {
                long var99E8EC83666448CE62AC20755BD9065F_1590162636 = (mAdapter.getItemId(adjPosition));
            } //End block
        } //End block
        return dsTaint.getTaintLong();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:06.999 -0400", hash_original_method = "5C897DB1697E65CD415A86C35E25516F", hash_generated_method = "37AE0B0026A640CF215007D8F10D852C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasStableIds() {
        {
            boolean varFDE3CC3D22CA5BAB554F3ECCA23F98B2_1668595844 = (mAdapter.hasStableIds());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.hasStableIds();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.000 -0400", hash_original_method = "B94999E1741825084E6BE4B30684EEAE", hash_generated_method = "34CDFB0B04245BF3BA867FFD04460128")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public View getView(int position, View convertView, ViewGroup parent) {
        dsTaint.addTaint(position);
        dsTaint.addTaint(parent.dsTaint);
        dsTaint.addTaint(convertView.dsTaint);
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            View varFEEE2FB96821FD9C5446E8835D49B082_1877192928 = (mHeaderViewInfos.get(position).view);
        } //End block
        int adjPosition;
        adjPosition = position - numHeaders;
        int adapterCount;
        adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                View varB5B6117A36AA34BE190CECE4EEFA7D10_1201935515 = (mAdapter.getView(adjPosition, convertView, parent));
            } //End block
        } //End block
        View var43992248490C1C8DE261D65599B9119A_1260214503 = (mFooterViewInfos.get(adjPosition - adapterCount).view);
        return (View)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.000 -0400", hash_original_method = "18109841CF71190B9879A21F432A9D28", hash_generated_method = "CE34ED29C584D75DE19F259AAFCF3C8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getItemViewType(int position) {
        dsTaint.addTaint(position);
        int numHeaders;
        numHeaders = getHeadersCount();
        {
            int adjPosition;
            adjPosition = position - numHeaders;
            int adapterCount;
            adapterCount = mAdapter.getCount();
            {
                int var645C3D1547C170A59D2EE81F83FA9020_1533326346 = (mAdapter.getItemViewType(adjPosition));
            } //End block
        } //End block
        return dsTaint.getTaintInt();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.000 -0400", hash_original_method = "8F6564F3EA2E826663B1C340FEA4D3E0", hash_generated_method = "A68BB914739BFB5126153F0E255692E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getViewTypeCount() {
        {
            int var0AD31D021E508485C7C9D8AAC7CD7F8E_1800654164 = (mAdapter.getViewTypeCount());
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //return mAdapter.getViewTypeCount();
        //}
        //return 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.000 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "66B13A5EAF20D91B8AF17781BB09C95A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(observer.dsTaint);
        {
            mAdapter.registerDataSetObserver(observer);
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //mAdapter.registerDataSetObserver(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.001 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "4F3EC93856DE15D30B595D15C54F3C48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterDataSetObserver(DataSetObserver observer) {
        dsTaint.addTaint(observer.dsTaint);
        {
            mAdapter.unregisterDataSetObserver(observer);
        } //End block
        // ---------- Original Method ----------
        //if (mAdapter != null) {
            //mAdapter.unregisterDataSetObserver(observer);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.001 -0400", hash_original_method = "9E800AF0A66A6C48391AEDACEAEC8859", hash_generated_method = "DADB082861A2C1A7A6FA07AEB96A3347")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Filter getFilter() {
        {
            Filter var1F0C4580BBB501D7F7F07CD5F71FFAA0_1862153405 = (((Filterable) mAdapter).getFilter());
        } //End block
        return (Filter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mIsFilterable) {
            //return ((Filterable) mAdapter).getFilter();
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:07.001 -0400", hash_original_method = "16C6428A588CE1C0BF49AB22D8718A60", hash_generated_method = "69CF6912C3476C7F124FACDD73E457F5")
    @DSModeled(DSC.SAFE)
    public ListAdapter getWrappedAdapter() {
        return (ListAdapter)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mAdapter;
    }

    
    static final ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST =
        new ArrayList<ListView.FixedViewInfo>();
}

