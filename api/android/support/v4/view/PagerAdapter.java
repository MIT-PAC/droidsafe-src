package android.support.v4.view;

// Droidsafe Imports
import droidsafe.annotations.*;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;





public abstract class PagerAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.317 -0400", hash_original_field = "9E7399A38DF912269AABB62597093F60", hash_generated_field = "2C795F8AF9A73C2DD35A795A42FEB9E0")

    private DataSetObservable mObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.317 -0400", hash_original_method = "FE6E138A162115EAC1384653A4B660CF", hash_generated_method = "FE6E138A162115EAC1384653A4B660CF")
    public PagerAdapter ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract int getCount();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.318 -0400", hash_original_method = "DCAE5C6F617B7B7CD0D6B0A4179A4B48", hash_generated_method = "84BE4AD075128A51B7363B05F79871FF")
    public void startUpdate(ViewGroup container) {
        addTaint(container.getTaint());
        startUpdate((View) container);
        // ---------- Original Method ----------
        //startUpdate((View) container);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.318 -0400", hash_original_method = "118A1191E1E4E1B1DC4CA223C52ECD6D", hash_generated_method = "B35C38DD30FAFBD3C4AC3C1E8BF937F7")
    public Object instantiateItem(ViewGroup container, int position) {
        addTaint(position);
        addTaint(container.getTaint());
Object varDBAD8988DF87318F1C8F9884B635F560_1868528150 =         instantiateItem((View) container, position);
        varDBAD8988DF87318F1C8F9884B635F560_1868528150.addTaint(taint);
        return varDBAD8988DF87318F1C8F9884B635F560_1868528150;
        // ---------- Original Method ----------
        //return instantiateItem((View) container, position);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.319 -0400", hash_original_method = "81B6B479C89D1904C5A685A128836D6A", hash_generated_method = "B252D9F05A3D203859A562150AAF0134")
    public void destroyItem(ViewGroup container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
        destroyItem((View) container, position, object);
        // ---------- Original Method ----------
        //destroyItem((View) container, position, object);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.319 -0400", hash_original_method = "C728F6B9404F59904D353F9FF4128613", hash_generated_method = "60FBABCB3A4D8FC55639824D85715593")
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
        setPrimaryItem((View) container, position, object);
        // ---------- Original Method ----------
        //setPrimaryItem((View) container, position, object);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.319 -0400", hash_original_method = "D14DC4EE203F14C8F1345C8D2F18FF46", hash_generated_method = "B0F663EFA60BB3B909732E1EE258681A")
    public void finishUpdate(ViewGroup container) {
        addTaint(container.getTaint());
        finishUpdate((View) container);
        // ---------- Original Method ----------
        //finishUpdate((View) container);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.320 -0400", hash_original_method = "FA1E5F7C2B2EB1EE6744E074AA1F10AB", hash_generated_method = "2AD025258BA808635F28BA1BF2B444F8")
    public void startUpdate(View container) {
        addTaint(container.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.320 -0400", hash_original_method = "30C4B19C489FA29440838961A72E4BC8", hash_generated_method = "DA5DAF92FA017DDDBD566F0D382B0883")
    public Object instantiateItem(View container, int position) {
        addTaint(position);
        addTaint(container.getTaint());
        UnsupportedOperationException var823077F1D270E2F8516CF32E0AF02BDD_1895560586 = new UnsupportedOperationException(
                "Required method instantiateItem was not overridden");
        var823077F1D270E2F8516CF32E0AF02BDD_1895560586.addTaint(taint);
        throw var823077F1D270E2F8516CF32E0AF02BDD_1895560586;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException(
                //"Required method instantiateItem was not overridden");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.320 -0400", hash_original_method = "0E7A719DFB33F3F65D1661AAD48E8CDE", hash_generated_method = "E2F9559DBC30EDD9E5C1561BCD754E3D")
    public void destroyItem(View container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
        UnsupportedOperationException var8789A9E8C56127DB67C6E1C6B1A90405_1529528688 = new UnsupportedOperationException("Required method destroyItem was not overridden");
        var8789A9E8C56127DB67C6E1C6B1A90405_1529528688.addTaint(taint);
        throw var8789A9E8C56127DB67C6E1C6B1A90405_1529528688;
        // ---------- Original Method ----------
        //throw new UnsupportedOperationException("Required method destroyItem was not overridden");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.321 -0400", hash_original_method = "BBAFE0B2C7FC305268C2EE6C04F35275", hash_generated_method = "4A808F912C2A3738AFE71F40FF60A7FE")
    public void setPrimaryItem(View container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.321 -0400", hash_original_method = "140CF544DAB4E9753AD13C5C6F7AF228", hash_generated_method = "948CEEC952AF21DF136FE0405AB0883D")
    public void finishUpdate(View container) {
        addTaint(container.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean isViewFromObject(View view, Object object);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.321 -0400", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "633A161C57C9E5F81F11F30A3D8CAB41")
    public Parcelable saveState() {
Parcelable var540C13E9E156B687226421B24F2DF178_606799600 =         null;
        var540C13E9E156B687226421B24F2DF178_606799600.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_606799600;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.322 -0400", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "F5A125A85F42CD1DC99BEBF6861BC1A8")
    public void restoreState(Parcelable state, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(state.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.322 -0400", hash_original_method = "A005A760A98AF47FB8E2DAD0B5F81664", hash_generated_method = "186F437FC65A4FFABDF408CCC6DB0D33")
    public int getItemPosition(Object object) {
        addTaint(object.getTaint());
        int var5417DE8371B88024FCCF6EE7213A9962_2077211756 = (POSITION_UNCHANGED);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302410987 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1302410987;
        // ---------- Original Method ----------
        //return POSITION_UNCHANGED;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.322 -0400", hash_original_method = "8C7965DA0630180F14A7491670F343AF", hash_generated_method = "447E40668AD17723D01B3684710E1A4F")
    public void notifyDataSetChanged() {
        mObservable.notifyChanged();
        // ---------- Original Method ----------
        //mObservable.notifyChanged();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.323 -0400", hash_original_method = "F0925616C6F47A4BCFCB9E7C14C25F57", hash_generated_method = "360ED7DC7F9F06557A86FF83CFD3E0DA")
     void registerDataSetObserver(DataSetObserver observer) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(observer.getTaint());
        mObservable.registerObserver(observer);
        // ---------- Original Method ----------
        //mObservable.registerObserver(observer);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.323 -0400", hash_original_method = "F847CF5B5DF735E7D60F86704B1D73CD", hash_generated_method = "2D4026184382555EDF54EBEA3C9E984E")
     void unregisterDataSetObserver(DataSetObserver observer) {
        addTaint(observer.getTaint());
        mObservable.unregisterObserver(observer);
        // ---------- Original Method ----------
        //mObservable.unregisterObserver(observer);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.323 -0400", hash_original_method = "D33F5CC8812E682744289E753AD4C997", hash_generated_method = "A11CCB502CA3C2BEE58CF4BFCEE01D12")
    public CharSequence getPageTitle(int position) {
        addTaint(position);
CharSequence var540C13E9E156B687226421B24F2DF178_1131586574 =         null;
        var540C13E9E156B687226421B24F2DF178_1131586574.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1131586574;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.323 -0400", hash_original_field = "DFF7F17AC1946A5436CDB483B591C036", hash_generated_field = "1095B2C860AD558A4F53332EBAEFA10E")

    public static final int POSITION_UNCHANGED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:33.323 -0400", hash_original_field = "BCEE9D8504FFEB6ACF568816B6F1BF9F", hash_generated_field = "A46559075D518D4933C3AFA6B991A88C")

    public static final int POSITION_NONE = -2;
}

