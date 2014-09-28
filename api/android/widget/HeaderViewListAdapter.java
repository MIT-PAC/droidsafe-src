package android.widget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;

public class HeaderViewListAdapter implements WrapperListAdapter, Filterable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.789 -0500", hash_original_field = "AD39205CE4628FAF011224FC936A4AF8", hash_generated_field = "EF2B0A0494B67C8F24E4D169C794B14E")

    // Currently only used by some CTS tests, which may be removed.
    static final ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST =
        new ArrayList<ListView.FixedViewInfo>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.783 -0500", hash_original_field = "CBDD62EF585589E92C0E00AE9F4F22E2", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private  ListAdapter mAdapter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.785 -0500", hash_original_field = "1174AC07D1E0FF5BE8FD7B73F622A98F", hash_generated_field = "CEDAAC6F6360C6156C22BE83085C5887")

    // They are indeed created when declared in ListView and then shared.
    ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.787 -0500", hash_original_field = "88602AC90A2A75CECE8836CF4FDB527C", hash_generated_field = "88602AC90A2A75CECE8836CF4FDB527C")

    ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.791 -0500", hash_original_field = "2DA9D21A65202F474DD30A137186E034", hash_generated_field = "2DA9D21A65202F474DD30A137186E034")

    boolean mAreAllFixedViewsSelectable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.793 -0500", hash_original_field = "83C0874C8DB809FB4C012228E2EA2945", hash_generated_field = "6776BDE0D016372C684D038A88F70F04")

    private  boolean mIsFilterable;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.796 -0500", hash_original_method = "ED7F7094A6F9A9163E3FAE563C0A2BCF", hash_generated_method = "17E48957A55BEC240799DCB14352A679")
    
public HeaderViewListAdapter(ArrayList<ListView.FixedViewInfo> headerViewInfos,
                                 ArrayList<ListView.FixedViewInfo> footerViewInfos,
                                 ListAdapter adapter) {
        mAdapter = adapter;
        mIsFilterable = adapter instanceof Filterable;

        if (headerViewInfos == null) {
            mHeaderViewInfos = EMPTY_INFO_LIST;
        } else {
            mHeaderViewInfos = headerViewInfos;
        }

        if (footerViewInfos == null) {
            mFooterViewInfos = EMPTY_INFO_LIST;
        } else {
            mFooterViewInfos = footerViewInfos;
        }

        mAreAllFixedViewsSelectable =
                areAllListInfosSelectable(mHeaderViewInfos)
                && areAllListInfosSelectable(mFooterViewInfos);
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.799 -0500", hash_original_method = "F816FE78C9557554F8C5B6BB80A06D13", hash_generated_method = "D35435BAA79C392D18F5E294569DB3F6")
    
public int getHeadersCount() {
        return mHeaderViewInfos.size();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.801 -0500", hash_original_method = "03601E80550495DBAEB6124EE960EF9F", hash_generated_method = "62EBC05D9B9AEF1600C7DCEAB7EE6C8B")
    
public int getFootersCount() {
        return mFooterViewInfos.size();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.803 -0500", hash_original_method = "D7DEAD009C651EAC8E2A235B793425D9", hash_generated_method = "18936EBD4FFB4E563382822A2557BD7F")
    
public boolean isEmpty() {
        return mAdapter == null || mAdapter.isEmpty();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.805 -0500", hash_original_method = "41241BC7260E3C26DE66CCD5C227EECC", hash_generated_method = "C016B55F1984CD2E236CB6F46E6A228D")
    
private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> infos) {
        if (infos != null) {
            for (ListView.FixedViewInfo info : infos) {
                if (!info.isSelectable) {
                    return false;
                }
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.807 -0500", hash_original_method = "92115EA33573B801358871B3CD0766B3", hash_generated_method = "97A26830D9543447BDD9CD7A764A50AA")
    
public boolean removeHeader(View v) {
        for (int i = 0; i < mHeaderViewInfos.size(); i++) {
            ListView.FixedViewInfo info = mHeaderViewInfos.get(i);
            if (info.view == v) {
                mHeaderViewInfos.remove(i);

                mAreAllFixedViewsSelectable =
                        areAllListInfosSelectable(mHeaderViewInfos)
                        && areAllListInfosSelectable(mFooterViewInfos);

                return true;
            }
        }

        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.810 -0500", hash_original_method = "C18E7E6A93212BDE730ADAF32E087D6A", hash_generated_method = "96DBE4576AFB730C54F06FC0A08A5CE2")
    
public boolean removeFooter(View v) {
        for (int i = 0; i < mFooterViewInfos.size(); i++) {
            ListView.FixedViewInfo info = mFooterViewInfos.get(i);
            if (info.view == v) {
                mFooterViewInfos.remove(i);

                mAreAllFixedViewsSelectable =
                        areAllListInfosSelectable(mHeaderViewInfos)
                        && areAllListInfosSelectable(mFooterViewInfos);

                return true;
            }
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.DATABASE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.812 -0500", hash_original_method = "5EA4C802749955ACC8971AB13A15905C", hash_generated_method = "57CBC94C41FE3169911F7A0E0BD707AD")
    
public int getCount() {
        if (mAdapter != null) {
            return getFootersCount() + getHeadersCount() + mAdapter.getCount();
        } else {
            return getFootersCount() + getHeadersCount();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.814 -0500", hash_original_method = "BA6CC34361A3C86CCD3E8BF91B771D57", hash_generated_method = "7D9A7D32748E440039C2FB8CDE762C66")
    
public boolean areAllItemsEnabled() {
        if (mAdapter != null) {
            return mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled();
        } else {
            return true;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.817 -0500", hash_original_method = "DF42B35442C4183A344219B7FD0FCDD1", hash_generated_method = "31E5441154685EDB94F95C6086683FA9")
    
public boolean isEnabled(int position) {
        // Header (negative positions will throw an ArrayIndexOutOfBoundsException)
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return mHeaderViewInfos.get(position).isSelectable;
        }

        // Adapter
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getCount();
            if (adjPosition < adapterCount) {
                return mAdapter.isEnabled(adjPosition);
            }
        }

        // Footer (off-limits positions will throw an ArrayIndexOutOfBoundsException)
        return mFooterViewInfos.get(adjPosition - adapterCount).isSelectable;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.DATABASE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.819 -0500", hash_original_method = "5FB1DDE7849FB7B1EE35000192AE1125", hash_generated_method = "8918F8CAD06FC669E29BCDAAF4D39293")
    
public Object getItem(int position) {
        // Header (negative positions will throw an ArrayIndexOutOfBoundsException)
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return mHeaderViewInfos.get(position).data;
        }

        // Adapter
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getCount();
            if (adjPosition < adapterCount) {
                return mAdapter.getItem(adjPosition);
            }
        }

        // Footer (off-limits positions will throw an ArrayIndexOutOfBoundsException)
        return mFooterViewInfos.get(adjPosition - adapterCount).data;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.DATABASE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.822 -0500", hash_original_method = "0EFF2641ED72ED5C174A1DFD9DE35423", hash_generated_method = "E63E5B93CC2923AAA40B574637AC8D43")
    
public long getItemId(int position) {
        int numHeaders = getHeadersCount();
        if (mAdapter != null && position >= numHeaders) {
            int adjPosition = position - numHeaders;
            int adapterCount = mAdapter.getCount();
            if (adjPosition < adapterCount) {
                return mAdapter.getItemId(adjPosition);
            }
        }
        return -1;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.824 -0500", hash_original_method = "5C897DB1697E65CD415A86C35E25516F", hash_generated_method = "1C90C10F66C374B135420E1D1B8B8025")
    
public boolean hasStableIds() {
        if (mAdapter != null) {
            return mAdapter.hasStableIds();
        }
        return false;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.826 -0500", hash_original_method = "B94999E1741825084E6BE4B30684EEAE", hash_generated_method = "1EFB409B82444E045D3208D61B0334FB")
    
public View getView(int position, View convertView, ViewGroup parent) {
        // Header (negative positions will throw an ArrayIndexOutOfBoundsException)
        int numHeaders = getHeadersCount();
        if (position < numHeaders) {
            return mHeaderViewInfos.get(position).view;
        }

        // Adapter
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        if (mAdapter != null) {
            adapterCount = mAdapter.getCount();
            if (adjPosition < adapterCount) {
                return mAdapter.getView(adjPosition, convertView, parent);
            }
        }

        // Footer (off-limits positions will throw an ArrayIndexOutOfBoundsException)
        return mFooterViewInfos.get(adjPosition - adapterCount).view;
    }

    @DSSafe(DSCat.SAFE_LIST)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.829 -0500", hash_original_method = "18109841CF71190B9879A21F432A9D28", hash_generated_method = "294400AE5B0954E97BC6CBAE52859F08")
    
public int getItemViewType(int position) {
        int numHeaders = getHeadersCount();
        if (mAdapter != null && position >= numHeaders) {
            int adjPosition = position - numHeaders;
            int adapterCount = mAdapter.getCount();
            if (adjPosition < adapterCount) {
                return mAdapter.getItemViewType(adjPosition);
            }
        }

        return AdapterView.ITEM_VIEW_TYPE_HEADER_OR_FOOTER;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.831 -0500", hash_original_method = "8F6564F3EA2E826663B1C340FEA4D3E0", hash_generated_method = "2DF38352BC9D91C6EC5B960423681FED")
    
public int getViewTypeCount() {
        if (mAdapter != null) {
            return mAdapter.getViewTypeCount();
        }
        return 1;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.833 -0500", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "B74E824CE2534F171C068A593B2FABFD")
    
public void registerDataSetObserver(DataSetObserver observer) {
        if (mAdapter != null) {
            mAdapter.registerDataSetObserver(observer);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.835 -0500", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "1A40DA71628EA2969005B726C48A6DC9")
    
public void unregisterDataSetObserver(DataSetObserver observer) {
        if (mAdapter != null) {
            mAdapter.unregisterDataSetObserver(observer);
        }
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.837 -0500", hash_original_method = "9E800AF0A66A6C48391AEDACEAEC8859", hash_generated_method = "97FF7B6BF06B1EBE426196BC748DB848")
    
public Filter getFilter() {
        if (mIsFilterable) {
            return ((Filterable) mAdapter).getFilter();
        }
        return null;
    }
    
    @DSSafe(DSCat.SAFE_OTHERS)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:05.839 -0500", hash_original_method = "16C6428A588CE1C0BF49AB22D8718A60", hash_generated_method = "1B4072FCD9397C730B9A7DF907318F48")
    
public ListAdapter getWrappedAdapter() {
        return mAdapter;
    }
}

