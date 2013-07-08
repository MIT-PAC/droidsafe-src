package android.widget;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class HeaderViewListAdapter implements WrapperListAdapter, Filterable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.413 -0400", hash_original_field = "59E9F255F2F17EC006AE601269EA8540", hash_generated_field = "90F29768206AB431EA361CD94838716F")

    private ListAdapter mAdapter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.413 -0400", hash_original_field = "8B3453F15529335E224866A4AFCB80E3", hash_generated_field = "1174AC07D1E0FF5BE8FD7B73F622A98F")

    ArrayList<ListView.FixedViewInfo> mHeaderViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.413 -0400", hash_original_field = "B8FDAC0951330D9E01F6B98B286C3F3E", hash_generated_field = "88602AC90A2A75CECE8836CF4FDB527C")

    ArrayList<ListView.FixedViewInfo> mFooterViewInfos;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.413 -0400", hash_original_field = "A77BBF288DDB83C524B2E9A07CB0CFB5", hash_generated_field = "2DA9D21A65202F474DD30A137186E034")

    boolean mAreAllFixedViewsSelectable;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.413 -0400", hash_original_field = "6B708799D01ECAD7FAB52020404D876D", hash_generated_field = "6776BDE0D016372C684D038A88F70F04")

    private boolean mIsFilterable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.414 -0400", hash_original_method = "ED7F7094A6F9A9163E3FAE563C0A2BCF", hash_generated_method = "73641371E9BFC0FE22B42ECAD434270F")
    public  HeaderViewListAdapter(ArrayList<ListView.FixedViewInfo> headerViewInfos,
                                 ArrayList<ListView.FixedViewInfo> footerViewInfos,
                                 ListAdapter adapter) {
        mAdapter = adapter;
        mIsFilterable = adapter instanceof Filterable;
        {
            mHeaderViewInfos = EMPTY_INFO_LIST;
        } 
        {
            mHeaderViewInfos = headerViewInfos;
        } 
        {
            mFooterViewInfos = EMPTY_INFO_LIST;
        } 
        {
            mFooterViewInfos = footerViewInfos;
        } 
        mAreAllFixedViewsSelectable =
                areAllListInfosSelectable(mHeaderViewInfos)
                && areAllListInfosSelectable(mFooterViewInfos);
        
        
        
        
            
        
            
        
        
            
        
            
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.414 -0400", hash_original_method = "F816FE78C9557554F8C5B6BB80A06D13", hash_generated_method = "FE2B528E86801C0B6B0BC89F9E27CA0B")
    public int getHeadersCount() {
        int var51EB21BA6322BC21883B38109F793DB7_1272226471 = (mHeaderViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097580978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097580978;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.414 -0400", hash_original_method = "03601E80550495DBAEB6124EE960EF9F", hash_generated_method = "DAD1B7DB7396907AE019B3A3CD51DDEE")
    public int getFootersCount() {
        int var05D2A206262A11BE7E645CDC53B4074D_1334671576 = (mFooterViewInfos.size());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525852818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_525852818;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.415 -0400", hash_original_method = "D7DEAD009C651EAC8E2A235B793425D9", hash_generated_method = "0CBF928E785CFB22995E76A294BB92CC")
    public boolean isEmpty() {
        boolean varD35419911CAF869FB18BA02856781F0C_416940717 = (mAdapter == null || mAdapter.isEmpty());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_578136020 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_578136020;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.419 -0400", hash_original_method = "41241BC7260E3C26DE66CCD5C227EECC", hash_generated_method = "87A51D447D2190A576780D91BE269A19")
    private boolean areAllListInfosSelectable(ArrayList<ListView.FixedViewInfo> infos) {
        {
            {
                Iterator<ListView.FixedViewInfo> var8B5947E9D1DF62DF443918DA5B663B89_250789222 = (infos).iterator();
                var8B5947E9D1DF62DF443918DA5B663B89_250789222.hasNext();
                ListView.FixedViewInfo info = var8B5947E9D1DF62DF443918DA5B663B89_250789222.next();
            } 
        } 
        addTaint(infos.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014091780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014091780;
        
        
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.420 -0400", hash_original_method = "92115EA33573B801358871B3CD0766B3", hash_generated_method = "4C21528AF8E2234A4DE87C0A1250FE72")
    public boolean removeHeader(View v) {
        {
            int i = 0;
            boolean var3B35C29B0489E7CC40865002A99AAA03_1273937104 = (i < mHeaderViewInfos.size());
            {
                ListView.FixedViewInfo info = mHeaderViewInfos.get(i);
                {
                    mHeaderViewInfos.remove(i);
                    mAreAllFixedViewsSelectable =
                        areAllListInfosSelectable(mHeaderViewInfos)
                        && areAllListInfosSelectable(mFooterViewInfos);
                } 
            } 
        } 
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_996996303 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_996996303;
        
        
            
            
                
                
                        
                        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.421 -0400", hash_original_method = "C18E7E6A93212BDE730ADAF32E087D6A", hash_generated_method = "B1BBC355E69B5F041EE41EEB2F3F4DEC")
    public boolean removeFooter(View v) {
        {
            int i = 0;
            boolean varC9FB87404C9C311F63579621314C75C2_968281356 = (i < mFooterViewInfos.size());
            {
                ListView.FixedViewInfo info = mFooterViewInfos.get(i);
                {
                    mFooterViewInfos.remove(i);
                    mAreAllFixedViewsSelectable =
                        areAllListInfosSelectable(mHeaderViewInfos)
                        && areAllListInfosSelectable(mFooterViewInfos);
                } 
            } 
        } 
        addTaint(v.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1890930530 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1890930530;
        
        
            
            
                
                
                        
                        
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.421 -0400", hash_original_method = "5EA4C802749955ACC8971AB13A15905C", hash_generated_method = "0968EB7E7473DBC16981BD033C4E9C5B")
    public int getCount() {
        {
            int var661984E76F04D752B1BAEC58283825F0_587925134 = (getFootersCount() + getHeadersCount() + mAdapter.getCount());
        } 
        {
            int varE487CA7829F9BC3C8EBD5B664AB8BEFB_855479146 = (getFootersCount() + getHeadersCount());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215696243 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215696243;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.421 -0400", hash_original_method = "BA6CC34361A3C86CCD3E8BF91B771D57", hash_generated_method = "028F912ED794E72A21434D5B3AE86859")
    public boolean areAllItemsEnabled() {
        {
            boolean var9C54E106A28E5AC5432E590C5A6E2813_451274027 = (mAreAllFixedViewsSelectable && mAdapter.areAllItemsEnabled());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1131321558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1131321558;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.422 -0400", hash_original_method = "DF42B35442C4183A344219B7FD0FCDD1", hash_generated_method = "B76F7BD2C34ECD392891D1D651AE14D9")
    public boolean isEnabled(int position) {
        int numHeaders = getHeadersCount();
        {
            boolean var2010CA47FC71AF2CAA3A2C68AB451F64_669626895 = (mHeaderViewInfos.get(position).isSelectable);
        } 
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                boolean var976993602ACCF2E54C9355F58E9BFB82_100947617 = (mAdapter.isEnabled(adjPosition));
            } 
        } 
        boolean var1751AB55CF32B4B2D54E9279FA0C1F29_1160872570 = (mFooterViewInfos.get(adjPosition - adapterCount).isSelectable);
        addTaint(position);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756530763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_756530763;
        
        
        
            
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.423 -0400", hash_original_method = "5FB1DDE7849FB7B1EE35000192AE1125", hash_generated_method = "374BA3C3140C9E97C825D3F3D068E293")
    public Object getItem(int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1396687849 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_697063837 = null; 
        Object varB4EAC82CA7396A68D541C85D26508E83_554035943 = null; 
        int numHeaders = getHeadersCount();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1396687849 = mHeaderViewInfos.get(position).data;
        } 
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                varB4EAC82CA7396A68D541C85D26508E83_697063837 = mAdapter.getItem(adjPosition);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_554035943 = mFooterViewInfos.get(adjPosition - adapterCount).data;
        addTaint(position);
        Object varA7E53CE21691AB073D9660D615818899_1917229798; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1917229798 = varB4EAC82CA7396A68D541C85D26508E83_1396687849;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1917229798 = varB4EAC82CA7396A68D541C85D26508E83_697063837;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1917229798 = varB4EAC82CA7396A68D541C85D26508E83_554035943;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1917229798.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1917229798;
        
        
        
            
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.423 -0400", hash_original_method = "0EFF2641ED72ED5C174A1DFD9DE35423", hash_generated_method = "6376C414A9C73E2BE43914014335BACB")
    public long getItemId(int position) {
        int numHeaders = getHeadersCount();
        {
            int adjPosition = position - numHeaders;
            int adapterCount = mAdapter.getCount();
            {
                long var99E8EC83666448CE62AC20755BD9065F_537158265 = (mAdapter.getItemId(adjPosition));
            } 
        } 
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_663231256 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_663231256;
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.423 -0400", hash_original_method = "5C897DB1697E65CD415A86C35E25516F", hash_generated_method = "BA47E836F126F61B2A710DC1C137E36D")
    public boolean hasStableIds() {
        {
            boolean varFDE3CC3D22CA5BAB554F3ECCA23F98B2_234642275 = (mAdapter.hasStableIds());
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056103447 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056103447;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.424 -0400", hash_original_method = "B94999E1741825084E6BE4B30684EEAE", hash_generated_method = "1B3F509AA1A4E4263CD08AB430CB0BD0")
    public View getView(int position, View convertView, ViewGroup parent) {
        View varB4EAC82CA7396A68D541C85D26508E83_799742090 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_1213904658 = null; 
        View varB4EAC82CA7396A68D541C85D26508E83_579645885 = null; 
        int numHeaders = getHeadersCount();
        {
            varB4EAC82CA7396A68D541C85D26508E83_799742090 = mHeaderViewInfos.get(position).view;
        } 
        final int adjPosition = position - numHeaders;
        int adapterCount = 0;
        {
            adapterCount = mAdapter.getCount();
            {
                varB4EAC82CA7396A68D541C85D26508E83_1213904658 = mAdapter.getView(adjPosition, convertView, parent);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_579645885 = mFooterViewInfos.get(adjPosition - adapterCount).view;
        addTaint(position);
        addTaint(convertView.getTaint());
        addTaint(parent.getTaint());
        View varA7E53CE21691AB073D9660D615818899_1571586290; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1571586290 = varB4EAC82CA7396A68D541C85D26508E83_799742090;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1571586290 = varB4EAC82CA7396A68D541C85D26508E83_1213904658;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1571586290 = varB4EAC82CA7396A68D541C85D26508E83_579645885;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1571586290.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1571586290;
        
        
        
            
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.424 -0400", hash_original_method = "18109841CF71190B9879A21F432A9D28", hash_generated_method = "3A44F9B3D72A152254E49EDC658AD7BF")
    public int getItemViewType(int position) {
        int numHeaders = getHeadersCount();
        {
            int adjPosition = position - numHeaders;
            int adapterCount = mAdapter.getCount();
            {
                int var645C3D1547C170A59D2EE81F83FA9020_1135936537 = (mAdapter.getItemViewType(adjPosition));
            } 
        } 
        addTaint(position);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786292705 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1786292705;
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.424 -0400", hash_original_method = "8F6564F3EA2E826663B1C340FEA4D3E0", hash_generated_method = "32D5D8B7A48AB8F564C920A62F0831D1")
    public int getViewTypeCount() {
        {
            int var0AD31D021E508485C7C9D8AAC7CD7F8E_546471708 = (mAdapter.getViewTypeCount());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238408924 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_238408924;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.424 -0400", hash_original_method = "809D44C02719E33F590103DE7F6576A1", hash_generated_method = "394F8D6D1C3E11D04B82C1A93DEB883B")
    public void registerDataSetObserver(DataSetObserver observer) {
        
        {
            mAdapter.registerDataSetObserver(observer);
        } 
        addTaint(observer.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.424 -0400", hash_original_method = "3A9A7C936FBCE4451B499589F8C4C5C5", hash_generated_method = "CA1E1CE41BA81DA1B5FFC90A490DA640")
    public void unregisterDataSetObserver(DataSetObserver observer) {
        {
            mAdapter.unregisterDataSetObserver(observer);
        } 
        addTaint(observer.getTaint());
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.425 -0400", hash_original_method = "9E800AF0A66A6C48391AEDACEAEC8859", hash_generated_method = "A19CE48481CEC13CDDFFB1C391F067E5")
    public Filter getFilter() {
        Filter varB4EAC82CA7396A68D541C85D26508E83_78523572 = null; 
        Filter varB4EAC82CA7396A68D541C85D26508E83_127465761 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_78523572 = ((Filterable) mAdapter).getFilter();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_127465761 = null;
        Filter varA7E53CE21691AB073D9660D615818899_674194889; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_674194889 = varB4EAC82CA7396A68D541C85D26508E83_78523572;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_674194889 = varB4EAC82CA7396A68D541C85D26508E83_127465761;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_674194889.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_674194889;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.425 -0400", hash_original_method = "16C6428A588CE1C0BF49AB22D8718A60", hash_generated_method = "6088CD7CB7826FF94069408E07442F9F")
    public ListAdapter getWrappedAdapter() {
        ListAdapter varB4EAC82CA7396A68D541C85D26508E83_1880856578 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1880856578 = mAdapter;
        varB4EAC82CA7396A68D541C85D26508E83_1880856578.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1880856578;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:11.425 -0400", hash_original_field = "E7B5861FDFB008C25413C9B2AC5A155E", hash_generated_field = "AFA2D504E586D40E24D6E51B6C43EEE0")

    static final ArrayList<ListView.FixedViewInfo> EMPTY_INFO_LIST = new ArrayList<ListView.FixedViewInfo>();
}

