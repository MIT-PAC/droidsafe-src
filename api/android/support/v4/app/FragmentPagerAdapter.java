package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.895 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "F8BD8E8005099844A113591459546070")

    private FragmentManager mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.895 -0400", hash_original_field = "F059B80392FC866852597EAF19CC7B60", hash_generated_field = "45681C0640ABED8BB32E7E47A23478AF")

    private FragmentTransaction mCurTransaction = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.895 -0400", hash_original_field = "49FB18B1876842494DD756909F545BE4", hash_generated_field = "3FD1F349465E20607A1ACB2506873721")

    private Fragment mCurrentPrimaryItem = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.895 -0400", hash_original_method = "0907AC653AA851CA26FCA5C2C0476634", hash_generated_method = "B527D72706B763A256C0CF54E42D3B10")
    public  FragmentPagerAdapter(FragmentManager fm) {
        mFragmentManager = fm;
        
        
    }

    
    public abstract Fragment getItem(int position);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.896 -0400", hash_original_method = "40E78EFA38F0994EA71F26DADE781C52", hash_generated_method = "369CD737611E25F82302A46324A3B366")
    @Override
    public void startUpdate(ViewGroup container) {
        addTaint(container.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.896 -0400", hash_original_method = "0570BF37939320089381A7FFC8719F89", hash_generated_method = "A2C4A282B0CF375CF30E42594BABDC47")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        addTaint(position);
        addTaint(container.getTaint());
    if(mCurTransaction == null)        
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } 
        final long itemId = getItemId(position);
        String name = makeFragmentName(container.getId(), itemId);
        Fragment fragment = mFragmentManager.findFragmentByTag(name);
    if(fragment != null)        
        {
    if(DEBUG){ }            mCurTransaction.attach(fragment);
        } 
        else
        {
            fragment = getItem(position);
    if(DEBUG){ }            mCurTransaction.add(container.getId(), fragment,
                    makeFragmentName(container.getId(), itemId));
        } 
    if(fragment != mCurrentPrimaryItem)        
        {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        } 
Object varD266FB1A901BB0D9A16D45416C785B25_683036394 =         fragment;
        varD266FB1A901BB0D9A16D45416C785B25_683036394.addTaint(taint);
        return varD266FB1A901BB0D9A16D45416C785B25_683036394;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.897 -0400", hash_original_method = "721682626C0409D5023CB58AAAA50BDD", hash_generated_method = "A4401C75A829561E816FEE8F7A0C9F9B")
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
    if(mCurTransaction == null)        
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } 
    if(DEBUG){ }        mCurTransaction.detach((Fragment)object);
        
        
            
        
        
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.899 -0400", hash_original_method = "C523B4C098494E2FCA3311FDB475454B", hash_generated_method = "412D8BD48DCAADD45552AFB80A4221A4")
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        addTaint(object.getTaint());
        addTaint(position);
        addTaint(container.getTaint());
        Fragment fragment = (Fragment)object;
    if(fragment != mCurrentPrimaryItem)        
        {
    if(mCurrentPrimaryItem != null)            
            {
                mCurrentPrimaryItem.setMenuVisibility(false);
                mCurrentPrimaryItem.setUserVisibleHint(false);
            } 
    if(fragment != null)            
            {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            } 
            mCurrentPrimaryItem = fragment;
        } 
        
        
        
            
                
                
            
            
                
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.900 -0400", hash_original_method = "82B7432FA4441721C4132291867EEFCE", hash_generated_method = "685D42234C04229A62EAD30179248403")
    @Override
    public void finishUpdate(ViewGroup container) {
        addTaint(container.getTaint());
    if(mCurTransaction != null)        
        {
            mCurTransaction.commitAllowingStateLoss();
            mCurTransaction = null;
            mFragmentManager.executePendingTransactions();
        } 
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.900 -0400", hash_original_method = "326A6E6DDD52502D387B1D32B8739E1F", hash_generated_method = "C12C6E3033964FAD00871F4F02FBB21D")
    @Override
    public boolean isViewFromObject(View view, Object object) {
        addTaint(object.getTaint());
        addTaint(view.getTaint());
        boolean var8AF204D556CE31A8DE13D08D2B417ADF_2122274836 = (((Fragment)object).getView() == view);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2086851735 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2086851735;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.901 -0400", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "F0B9971CDF77A62C317D2F906D7E04EB")
    @Override
    public Parcelable saveState() {
Parcelable var540C13E9E156B687226421B24F2DF178_719975481 =         null;
        var540C13E9E156B687226421B24F2DF178_719975481.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_719975481;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.901 -0400", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "1B90B7F57B52791DD352BA00AFEEB83C")
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        addTaint(loader.getTaint());
        addTaint(state.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.901 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "D93140DBB440DD81124A0F9B22C65F8E")
    public long getItemId(int position) {
        addTaint(position);
        long var4757FE07FD492A8BE0EA6A760D683D6E_81002821 = (position);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1142128510 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1142128510;
        
        
    }

    
        private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.902 -0400", hash_original_field = "B113DA5C12E3889B6744A91D8FCDB593", hash_generated_field = "C72FFFE22C1245A655FF987EDEF7F7D6")

    private static final String TAG = "FragmentPagerAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:38.902 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
}

