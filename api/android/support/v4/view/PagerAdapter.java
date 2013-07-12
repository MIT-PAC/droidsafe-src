package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.801 -0400", hash_original_field = "9E7399A38DF912269AABB62597093F60", hash_generated_field = "2C795F8AF9A73C2DD35A795A42FEB9E0")

    private DataSetObservable mObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.801 -0400", hash_original_method = "FE6E138A162115EAC1384653A4B660CF", hash_generated_method = "FE6E138A162115EAC1384653A4B660CF")
    public PagerAdapter ()
    {
        
    }


    public abstract int getCount();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.801 -0400", hash_original_method = "DCAE5C6F617B7B7CD0D6B0A4179A4B48", hash_generated_method = "84BE4AD075128A51B7363B05F79871FF")
    public void startUpdate(ViewGroup container) {
        addTaint(container.getTaint());
        startUpdate((View) container);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.802 -0400", hash_original_method = "118A1191E1E4E1B1DC4CA223C52ECD6D", hash_generated_method = "90B1DBA0EC6D03A7E1C154D53FACE3A0")
    public Object instantiateItem(ViewGroup container, int position) {
        addTaint(position);
        addTaint(container.getTaint());
Object varDBAD8988DF87318F1C8F9884B635F560_1274041724 =         instantiateItem((View) container, position);
        varDBAD8988DF87318F1C8F9884B635F560_1274041724.addTaint(taint);
        return varDBAD8988DF87318F1C8F9884B635F560_1274041724;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.802 -0400", hash_original_method = "81B6B479C89D1904C5A685A128836D6A", hash_generated_method = "B252D9F05A3D203859A562150AAF0134")
    public void destroyItem(ViewGroup container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
        destroyItem((View) container, position, object);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.802 -0400", hash_original_method = "C728F6B9404F59904D353F9FF4128613", hash_generated_method = "60FBABCB3A4D8FC55639824D85715593")
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
        setPrimaryItem((View) container, position, object);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.803 -0400", hash_original_method = "D14DC4EE203F14C8F1345C8D2F18FF46", hash_generated_method = "B0F663EFA60BB3B909732E1EE258681A")
    public void finishUpdate(ViewGroup container) {
        addTaint(container.getTaint());
        finishUpdate((View) container);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.803 -0400", hash_original_method = "FA1E5F7C2B2EB1EE6744E074AA1F10AB", hash_generated_method = "2AD025258BA808635F28BA1BF2B444F8")
    public void startUpdate(View container) {
        addTaint(container.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.803 -0400", hash_original_method = "30C4B19C489FA29440838961A72E4BC8", hash_generated_method = "1644A2E11BF2EFDE0D68B7E7B30D716D")
    public Object instantiateItem(View container, int position) {
        addTaint(position);
        addTaint(container.getTaint());
        UnsupportedOperationException var823077F1D270E2F8516CF32E0AF02BDD_550051945 = new UnsupportedOperationException(
                "Required method instantiateItem was not overridden");
        var823077F1D270E2F8516CF32E0AF02BDD_550051945.addTaint(taint);
        throw var823077F1D270E2F8516CF32E0AF02BDD_550051945;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.804 -0400", hash_original_method = "0E7A719DFB33F3F65D1661AAD48E8CDE", hash_generated_method = "BF14960990265864F4105E72E9CEDC27")
    public void destroyItem(View container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
        UnsupportedOperationException var8789A9E8C56127DB67C6E1C6B1A90405_1626468707 = new UnsupportedOperationException("Required method destroyItem was not overridden");
        var8789A9E8C56127DB67C6E1C6B1A90405_1626468707.addTaint(taint);
        throw var8789A9E8C56127DB67C6E1C6B1A90405_1626468707;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.804 -0400", hash_original_method = "BBAFE0B2C7FC305268C2EE6C04F35275", hash_generated_method = "4A808F912C2A3738AFE71F40FF60A7FE")
    public void setPrimaryItem(View container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.804 -0400", hash_original_method = "140CF544DAB4E9753AD13C5C6F7AF228", hash_generated_method = "948CEEC952AF21DF136FE0405AB0883D")
    public void finishUpdate(View container) {
        addTaint(container.getTaint());
        
    }

    
    public abstract boolean isViewFromObject(View view, Object object);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.805 -0400", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "9CFD9FCD102270C1F6A535B659F1FAAA")
    public Parcelable saveState() {
Parcelable var540C13E9E156B687226421B24F2DF178_1479114771 =         null;
        var540C13E9E156B687226421B24F2DF178_1479114771.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1479114771;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.805 -0400", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "F5A125A85F42CD1DC99BEBF6861BC1A8")
    public void restoreState(Parcelable state, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(state.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.806 -0400", hash_original_method = "A005A760A98AF47FB8E2DAD0B5F81664", hash_generated_method = "04061D1A92E312795A8F15E638629955")
    public int getItemPosition(Object object) {
        addTaint(object.getTaint());
        int var5417DE8371B88024FCCF6EE7213A9962_1754850333 = (POSITION_UNCHANGED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655284407 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_655284407;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.806 -0400", hash_original_method = "8C7965DA0630180F14A7491670F343AF", hash_generated_method = "447E40668AD17723D01B3684710E1A4F")
    public void notifyDataSetChanged() {
        mObservable.notifyChanged();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.807 -0400", hash_original_method = "F0925616C6F47A4BCFCB9E7C14C25F57", hash_generated_method = "360ED7DC7F9F06557A86FF83CFD3E0DA")
     void registerDataSetObserver(DataSetObserver observer) {
        
        addTaint(observer.getTaint());
        mObservable.registerObserver(observer);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.807 -0400", hash_original_method = "F847CF5B5DF735E7D60F86704B1D73CD", hash_generated_method = "2D4026184382555EDF54EBEA3C9E984E")
     void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mObservable.unregisterObserver(observer);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.808 -0400", hash_original_method = "D33F5CC8812E682744289E753AD4C997", hash_generated_method = "C812F1C9FFFBA7C455280742BFC767D7")
    public CharSequence getPageTitle(int position) {
        addTaint(position);
CharSequence var540C13E9E156B687226421B24F2DF178_690655019 =         null;
        var540C13E9E156B687226421B24F2DF178_690655019.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_690655019;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.808 -0400", hash_original_field = "DFF7F17AC1946A5436CDB483B591C036", hash_generated_field = "1095B2C860AD558A4F53332EBAEFA10E")

    public static final int POSITION_UNCHANGED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:39.808 -0400", hash_original_field = "BCEE9D8504FFEB6ACF568816B6F1BF9F", hash_generated_field = "A46559075D518D4933C3AFA6B991A88C")

    public static final int POSITION_NONE = -2;
}

