package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.221 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "F8BD8E8005099844A113591459546070")

    private FragmentManager mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.221 -0400", hash_original_field = "F059B80392FC866852597EAF19CC7B60", hash_generated_field = "45681C0640ABED8BB32E7E47A23478AF")

    private FragmentTransaction mCurTransaction = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.221 -0400", hash_original_field = "49FB18B1876842494DD756909F545BE4", hash_generated_field = "3FD1F349465E20607A1ACB2506873721")

    private Fragment mCurrentPrimaryItem = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.225 -0400", hash_original_method = "0907AC653AA851CA26FCA5C2C0476634", hash_generated_method = "B527D72706B763A256C0CF54E42D3B10")
    public  FragmentPagerAdapter(FragmentManager fm) {
        mFragmentManager = fm;
        // ---------- Original Method ----------
        //mFragmentManager = fm;
    }

    
    public abstract Fragment getItem(int position);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.225 -0400", hash_original_method = "40E78EFA38F0994EA71F26DADE781C52", hash_generated_method = "369CD737611E25F82302A46324A3B366")
    @Override
    public void startUpdate(ViewGroup container) {
        addTaint(container.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.234 -0400", hash_original_method = "0570BF37939320089381A7FFC8719F89", hash_generated_method = "FFB7D2B46801C53D42A4A5E80F717174")
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object varB4EAC82CA7396A68D541C85D26508E83_1418910784 = null; //Variable for return #1
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } //End block
        long itemId;
        itemId = getItemId(position);
        String name;
        name = makeFragmentName(container.getId(), itemId);
        Fragment fragment;
        fragment = mFragmentManager.findFragmentByTag(name);
        {
            mCurTransaction.attach(fragment);
        } //End block
        {
            fragment = getItem(position);
            mCurTransaction.add(container.getId(), fragment,
                    makeFragmentName(container.getId(), itemId));
        } //End block
        {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1418910784 = fragment;
        addTaint(container.getTaint());
        addTaint(position);
        varB4EAC82CA7396A68D541C85D26508E83_1418910784.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1418910784;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.239 -0400", hash_original_method = "721682626C0409D5023CB58AAAA50BDD", hash_generated_method = "F049484B1D7B8BE06490DBF4E10C4E04")
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        {
            mCurTransaction = mFragmentManager.beginTransaction();
        } //End block
        mCurTransaction.detach((Fragment)object);
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //if (mCurTransaction == null) {
            //mCurTransaction = mFragmentManager.beginTransaction();
        //}
        //if (DEBUG) Log.v(TAG, "Detaching item #" + getItemId(position) + ": f=" + object
                //+ " v=" + ((Fragment)object).getView());
        //mCurTransaction.detach((Fragment)object);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.240 -0400", hash_original_method = "C523B4C098494E2FCA3311FDB475454B", hash_generated_method = "44818FB3AD150694500DADC328AABDB4")
    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment;
        fragment = (Fragment)object;
        {
            {
                mCurrentPrimaryItem.setMenuVisibility(false);
                mCurrentPrimaryItem.setUserVisibleHint(false);
            } //End block
            {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            } //End block
            mCurrentPrimaryItem = fragment;
        } //End block
        addTaint(container.getTaint());
        addTaint(position);
        addTaint(object.getTaint());
        // ---------- Original Method ----------
        //Fragment fragment = (Fragment)object;
        //if (fragment != mCurrentPrimaryItem) {
            //if (mCurrentPrimaryItem != null) {
                //mCurrentPrimaryItem.setMenuVisibility(false);
                //mCurrentPrimaryItem.setUserVisibleHint(false);
            //}
            //if (fragment != null) {
                //fragment.setMenuVisibility(true);
                //fragment.setUserVisibleHint(true);
            //}
            //mCurrentPrimaryItem = fragment;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.257 -0400", hash_original_method = "82B7432FA4441721C4132291867EEFCE", hash_generated_method = "15FE14EC160C5F3BA84D03661684293C")
    @Override
    public void finishUpdate(ViewGroup container) {
        {
            mCurTransaction.commitAllowingStateLoss();
            mCurTransaction = null;
            mFragmentManager.executePendingTransactions();
        } //End block
        addTaint(container.getTaint());
        // ---------- Original Method ----------
        //if (mCurTransaction != null) {
            //mCurTransaction.commitAllowingStateLoss();
            //mCurTransaction = null;
            //mFragmentManager.executePendingTransactions();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.258 -0400", hash_original_method = "326A6E6DDD52502D387B1D32B8739E1F", hash_generated_method = "72269BFCFD66252D78667FEC24F4AD2E")
    @Override
    public boolean isViewFromObject(View view, Object object) {
        boolean var779CA2DF34F5491A810C0B90DD7A88C3_604099385 = (((Fragment)object).getView() == view);
        addTaint(view.getTaint());
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1495269579 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1495269579;
        // ---------- Original Method ----------
        //return ((Fragment)object).getView() == view;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.258 -0400", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "3298AAB9A62128034E38C6AF25521DD9")
    @Override
    public Parcelable saveState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_663423325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_663423325 = null;
        varB4EAC82CA7396A68D541C85D26508E83_663423325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_663423325;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.259 -0400", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "39AEF52BF08FA84CF7C745447205D131")
    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
        addTaint(state.getTaint());
        addTaint(loader.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.259 -0400", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "D7ADBDCA54951B3B7C132F5D42136A59")
    public long getItemId(int position) {
        addTaint(position);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1018756216 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1018756216;
        // ---------- Original Method ----------
        //return position;
    }

    
        private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.260 -0400", hash_original_field = "B113DA5C12E3889B6744A91D8FCDB593", hash_generated_field = "4D9EE17AA28182B72E582731197AE9EF")

    private static String TAG = "FragmentPagerAdapter";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:31.260 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "E83DF1E2E661A92B1AFDA8C473D190B2")

    private static boolean DEBUG = false;
}

