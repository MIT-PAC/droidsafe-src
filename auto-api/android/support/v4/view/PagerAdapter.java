package android.support.v4.view;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

public abstract class PagerAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.551 -0400", hash_original_field = "9E7399A38DF912269AABB62597093F60", hash_generated_field = "2C795F8AF9A73C2DD35A795A42FEB9E0")

    private DataSetObservable mObservable = new DataSetObservable();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.552 -0400", hash_original_method = "FE6E138A162115EAC1384653A4B660CF", hash_generated_method = "FE6E138A162115EAC1384653A4B660CF")
    public PagerAdapter ()
    {
        
    }


    public abstract int getCount();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.553 -0400", hash_original_method = "DCAE5C6F617B7B7CD0D6B0A4179A4B48", hash_generated_method = "0B9BE1A9D46E4037CFF378415FE3E09D")
    public void startUpdate(ViewGroup container) {
        startUpdate((View) container);
        addTaint(container.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.555 -0400", hash_original_method = "118A1191E1E4E1B1DC4CA223C52ECD6D", hash_generated_method = "52CA064471D3897CF1B0E39E4A1DFF38")
    public Object instantiateItem(ViewGroup container, int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1876050488 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1876050488 = instantiateItem((View) container, position);
        addTaint(container.getTaint());
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_1876050488.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1876050488;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.556 -0400", hash_original_method = "81B6B479C89D1904C5A685A128836D6A", hash_generated_method = "D876CA1930DB094B891CC9CE27BED5DF")
    public void destroyItem(ViewGroup container, int position, Object object) {
        destroyItem((View) container, position, object);
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.558 -0400", hash_original_method = "C728F6B9404F59904D353F9FF4128613", hash_generated_method = "03FECA77CBB83A3B9696D3A5162D5BBD")
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        setPrimaryItem((View) container, position, object);
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.559 -0400", hash_original_method = "D14DC4EE203F14C8F1345C8D2F18FF46", hash_generated_method = "CD734AC84208DE6777AE339C7CF84254")
    public void finishUpdate(ViewGroup container) {
        finishUpdate((View) container);
        addTaint(container.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.559 -0400", hash_original_method = "FA1E5F7C2B2EB1EE6744E074AA1F10AB", hash_generated_method = "2AD025258BA808635F28BA1BF2B444F8")
    public void startUpdate(View container) {
        addTaint(container.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.561 -0400", hash_original_method = "30C4B19C489FA29440838961A72E4BC8", hash_generated_method = "6FAEBFEE1E4086C8F6910D2C2004A680")
    public Object instantiateItem(View container, int position) {
        addTaint(container.getTaint());
        addTaint(position);
        throw new UnsupportedOperationException("Required method instantiateItem was not overridden");
        
        
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.562 -0400", hash_original_method = "0E7A719DFB33F3F65D1661AAD48E8CDE", hash_generated_method = "B1429C1F9F4348A32F5D48E47002C661")
    public void destroyItem(View container, int position, Object object) {
        if (DroidSafeAndroidRuntime.control) throw new UnsupportedOperationException("Required method destroyItem was not overridden");
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.563 -0400", hash_original_method = "BBAFE0B2C7FC305268C2EE6C04F35275", hash_generated_method = "CEA8EBC13644FFA35AB96D24A3AB6665")
    public void setPrimaryItem(View container, int position, Object object) {
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.564 -0400", hash_original_method = "140CF544DAB4E9753AD13C5C6F7AF228", hash_generated_method = "948CEEC952AF21DF136FE0405AB0883D")
    public void finishUpdate(View container) {
        addTaint(container.getTaint());
        
    }

    
    public abstract boolean isViewFromObject(View view, Object object);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.566 -0400", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "22AE52290065EF6F15569DBB8B9CDFC0")
    public Parcelable saveState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1306609286 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1306609286 = null;
        varB4EAC82CA7396A68D541C85D26508E83_1306609286.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1306609286;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.567 -0400", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "6AB167AF42206126083AB281296F5839")
    public void restoreState(Parcelable state, ClassLoader loader) {
        addTaint(state.getTaint());
        addTaint(loader.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.568 -0400", hash_original_method = "A005A760A98AF47FB8E2DAD0B5F81664", hash_generated_method = "603C99B670ABE1C414370A34D1B720B2")
    public int getItemPosition(Object object) {
        addTaint(object.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921628043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_921628043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.570 -0400", hash_original_method = "8C7965DA0630180F14A7491670F343AF", hash_generated_method = "447E40668AD17723D01B3684710E1A4F")
    public void notifyDataSetChanged() {
        mObservable.notifyChanged();
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.574 -0400", hash_original_method = "F0925616C6F47A4BCFCB9E7C14C25F57", hash_generated_method = "2418715006DC7B6887CB8AB595381D3D")
     void registerDataSetObserver(DataSetObserver observer) {
        
        mObservable.registerObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.576 -0400", hash_original_method = "F847CF5B5DF735E7D60F86704B1D73CD", hash_generated_method = "044DB7E857DDAA4BEA4AA1F5E01F1E35")
     void unregisterDataSetObserver(DataSetObserver observer) {
        mObservable.unregisterObserver(observer);
        addTaint(observer.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.578 -0400", hash_original_method = "D33F5CC8812E682744289E753AD4C997", hash_generated_method = "DEFF940ACE206D24063CAA77661582A8")
    public CharSequence getPageTitle(int position) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_885770857 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_885770857 = null;
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_885770857.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_885770857;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.579 -0400", hash_original_field = "DFF7F17AC1946A5436CDB483B591C036", hash_generated_field = "1095B2C860AD558A4F53332EBAEFA10E")

    public static final int POSITION_UNCHANGED = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-01 14:03:03.580 -0400", hash_original_field = "BCEE9D8504FFEB6ACF568816B6F1BF9F", hash_generated_field = "A46559075D518D4933C3AFA6B991A88C")

    public static final int POSITION_NONE = -2;
}

