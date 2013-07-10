package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.981 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "F8BD8E8005099844A113591459546070")

    private FragmentManager mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.981 -0400", hash_original_field = "F059B80392FC866852597EAF19CC7B60", hash_generated_field = "45681C0640ABED8BB32E7E47A23478AF")

    private FragmentTransaction mCurTransaction = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.982 -0400", hash_original_field = "49FB18B1876842494DD756909F545BE4", hash_generated_field = "3FD1F349465E20607A1ACB2506873721")

    private Fragment mCurrentPrimaryItem = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.982 -0400", hash_original_method = "0907AC653AA851CA26FCA5C2C0476634", hash_generated_method = "B527D72706B763A256C0CF54E42D3B10")
    public  FragmentPagerAdapter(FragmentManager fm) {
        mFragmentManager = fm;
        
        
    }

    
    public abstract Fragment getItem(int position);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.982 -0400", hash_original_method = "40E78EFA38F0994EA71F26DADE781C52", hash_generated_method = "369CD737611E25F82302A46324A3B366")
    @Override
    public void startUpdate(ViewGroup container) {
        addTaint(container.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.983 -0400", hash_original_method = "0570BF37939320089381A7FFC8719F89", hash_generated_method = "998FD915CF5BD1E1AAB5239C50AB79BE")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1699261279 = null; 
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } 
        final long itemId = getItemId(position);
        String name = makeFragmentName(container.getId(), itemId);
        Fragment fragment = mFragmentManager.findFragmentByTag(name);
        {
            mCurTransaction.attach(fragment);
        } 
        {
            fragment = getItem(position);
            mCurTransaction.add(container.getId(), fragment,
                    makeFragmentName(container.getId(), itemId));
        } 
        {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1699261279 = fragment;
        addTaint(container.getTaint());
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_1699261279.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1699261279;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.984 -0400", hash_original_method = "721682626C0409D5023CB58AAAA50BDD", hash_generated_method = "F049484B1D7B8BE06490DBF4E10C4E04")
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } 
        mCurTransaction.detach((Fragment)object);
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        
        
            
        
        
                
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.985 -0400", hash_original_method = "C523B4C098494E2FCA3311FDB475454B", hash_generated_method = "C20525D3EEA39CC49C821323CEC33BAF")
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment)object;
        {
            {
                mCurrentPrimaryItem.setMenuVisibility(false);
                mCurrentPrimaryItem.setUserVisibleHint(false);
            } 
            {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            } 
            mCurrentPrimaryItem = fragment;
        } 
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        
        
        
            
                
                
            
            
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.985 -0400", hash_original_method = "82B7432FA4441721C4132291867EEFCE", hash_generated_method = "15FE14EC160C5F3BA84D03661684293C")
    @Override
    public void finishUpdate(ViewGroup container) {
        {
            mCurTransaction.commitAllowingStateLoss();
            mCurTransaction = null;
            mFragmentManager.executePendingTransactions();
        } 
        addTaint(container.getTaint());
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.985 -0400", hash_original_method = "326A6E6DDD52502D387B1D32B8739E1F", hash_generated_method = "53BFC9AF7891D54C0DB87DBAF1958BC3")
    @Override
    public boolean isViewFromObject(View view, Object object) {
        boolean var779CA2DF34F5491A810C0B90DD7A88C3_800040995 = (((Fragment)object).getView() == view);
        addTaint(view.getTaint());
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1465307014 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1465307014;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.986 -0400", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "D349C03AC5240D44F65C535F02E19E3E")
    @Override
    public Parcelable saveState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_954453050 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_954453050 = null;
        varB4EAC82CA7396A68D541C85D26508E83_954453050.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_954453050;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.986 -0400", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "39AEF52BF08FA84CF7C745447205D131")
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        addTaint(state.getTaint());
        addTaint(loader.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.987 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "C45E0B2287D4FF1A2FEA8980413B0F6B")
    public long getItemId(int position) {
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1907092388 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1907092388;
        
        
    }

    
        @DSModeled(DSC.SAFE)
    private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.987 -0400", hash_original_field = "B113DA5C12E3889B6744A91D8FCDB593", hash_generated_field = "C72FFFE22C1245A655FF987EDEF7F7D6")

    private static final String TAG = "FragmentPagerAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.987 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

