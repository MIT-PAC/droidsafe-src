package android.support.v4.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentPagerAdapter extends PagerAdapter {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.650 -0500", hash_original_method = "AC2C72A04607F3A9AA867C30F63B471C", hash_generated_method = "3586D9B72C71532D4919EBB53FEDDE2D")
    
private static String makeFragmentName(int viewId, long id) {
        return "android:switcher:" + viewId + ":" + id;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.611 -0500", hash_original_field = "EEFCF03736638EEB326A8DCA25421DBC", hash_generated_field = "C72FFFE22C1245A655FF987EDEF7F7D6")

    private static final String TAG = "FragmentPagerAdapter";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.613 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "58EDF43BA541A4D47EECFEC3901C7AED")

    private static final boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.616 -0500", hash_original_field = "0C27EED22F6A82BBBA86D53215B0BF17", hash_generated_field = "F8BD8E8005099844A113591459546070")

    private  FragmentManager mFragmentManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.618 -0500", hash_original_field = "27F3AB6E6051E5201188AA916E2866AC", hash_generated_field = "45681C0640ABED8BB32E7E47A23478AF")

    private FragmentTransaction mCurTransaction = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.620 -0500", hash_original_field = "B76431ECCE6EF00430DFE1A892C233F1", hash_generated_field = "3FD1F349465E20607A1ACB2506873721")

    private Fragment mCurrentPrimaryItem = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.623 -0500", hash_original_method = "0907AC653AA851CA26FCA5C2C0476634", hash_generated_method = "ABB82874FFE5A7CC950EC2328BD1AC79")
    
public FragmentPagerAdapter(FragmentManager fm) {
        mFragmentManager = fm;
    }

    /**
     * Return the Fragment associated with a specified position.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.625 -0500", hash_original_method = "0C9300C8E0F0C0E8B44008DC047CEFF9", hash_generated_method = "918C6D014DB9AA643E9330669120C48C")
    
public abstract Fragment getItem(int position);

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.627 -0500", hash_original_method = "40E78EFA38F0994EA71F26DADE781C52", hash_generated_method = "C451CD9BEC048C5D65EB3785ED5E5CC8")
    
@Override
    public void startUpdate(ViewGroup container) {
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.630 -0500", hash_original_method = "0570BF37939320089381A7FFC8719F89", hash_generated_method = "1369904EB0FCDDD99FA8EBF2BC8A2733")
    
@Override
    public Object instantiateItem(ViewGroup container, int position) {
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }

        final long itemId = getItemId(position);

        // Do we already have this fragment?
        String name = makeFragmentName(container.getId(), itemId);
        Fragment fragment = mFragmentManager.findFragmentByTag(name);
        if (fragment != null) {
            if (DEBUG) Log.v(TAG, "Attaching item #" + itemId + ": f=" + fragment);
            mCurTransaction.attach(fragment);
        } else {
            fragment = getItem(position);
            if (DEBUG) Log.v(TAG, "Adding item #" + itemId + ": f=" + fragment);
            mCurTransaction.add(container.getId(), fragment,
                    makeFragmentName(container.getId(), itemId));
        }
        if (fragment != mCurrentPrimaryItem) {
            fragment.setMenuVisibility(false);
            fragment.setUserVisibleHint(false);
        }

        return fragment;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.633 -0500", hash_original_method = "721682626C0409D5023CB58AAAA50BDD", hash_generated_method = "0AD87F386A59B71A6CF6FFB8D51F419A")
    
@Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        if (mCurTransaction == null) {
            mCurTransaction = mFragmentManager.beginTransaction();
        }
        if (DEBUG) Log.v(TAG, "Detaching item #" + getItemId(position) + ": f=" + object
                + " v=" + ((Fragment)object).getView());
        mCurTransaction.detach((Fragment)object);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.635 -0500", hash_original_method = "C523B4C098494E2FCA3311FDB475454B", hash_generated_method = "C8DEAABE46D0926222ABF1BD53906953")
    
@Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        Fragment fragment = (Fragment)object;
        if (fragment != mCurrentPrimaryItem) {
            if (mCurrentPrimaryItem != null) {
                mCurrentPrimaryItem.setMenuVisibility(false);
                mCurrentPrimaryItem.setUserVisibleHint(false);
            }
            if (fragment != null) {
                fragment.setMenuVisibility(true);
                fragment.setUserVisibleHint(true);
            }
            mCurrentPrimaryItem = fragment;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.638 -0500", hash_original_method = "82B7432FA4441721C4132291867EEFCE", hash_generated_method = "CE61AFE2F603793B40738C76BEDE2639")
    
@Override
    public void finishUpdate(ViewGroup container) {
        if (mCurTransaction != null) {
            mCurTransaction.commitAllowingStateLoss();
            mCurTransaction = null;
            mFragmentManager.executePendingTransactions();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.641 -0500", hash_original_method = "326A6E6DDD52502D387B1D32B8739E1F", hash_generated_method = "AF3559343D13818878146CEE853F63B6")
    
@Override
    public boolean isViewFromObject(View view, Object object) {
        return ((Fragment)object).getView() == view;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.643 -0500", hash_original_method = "9C10790C9B509FF6855ECD7BB4443BBC", hash_generated_method = "C0F3FD7EB0D4B4DDD2361F02930CFABF")
    
@Override
    public Parcelable saveState() {
        return null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.645 -0500", hash_original_method = "17638DDA6DE27E971DE60A544D06348C", hash_generated_method = "CA86982BBD297ECE9BC8A03BE9E0BFBA")
    
@Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    /**
     * Return a unique identifier for the item at the given position.
     *
     * <p>The default implementation returns the given position.
     * Subclasses should override this method if the positions of items can change.</p>
     *
     * @param position Position within this adapter
     * @return Unique identifier for the item at position
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:32.648 -0500", hash_original_method = "7144EF990F660E75AA61001CF21A1CD5", hash_generated_method = "86EF76D6295D66F6DBBE39DCDBA9A1C9")
    
public long getItemId(int position) {
        return position;
    }
}

