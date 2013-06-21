package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DebugUtils;
import android.util.Log;
import android.util.LogWriter;
import android.util.Slog;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class FragmentManager {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.763 -0400", hash_original_method = "5053EA9E78454210D3C7CBA3ABF262AA", hash_generated_method = "5053EA9E78454210D3C7CBA3ABF262AA")
        public FragmentManager ()
    {
    }


    public abstract FragmentTransaction beginTransaction();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.764 -0400", hash_original_method = "0DA67415D41DB3C4C9D7AB80CD2D78FE", hash_generated_method = "000DF7E2BDA37FC2A8F643688D65335F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Deprecated
    public FragmentTransaction openTransaction() {
        FragmentTransaction var5484E5504D0D460F5B1995AF472EA94C_1930859226 = (beginTransaction());
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return beginTransaction();
    }

    
    public abstract boolean executePendingTransactions();

    
    public abstract Fragment findFragmentById(int id);

    
    public abstract Fragment findFragmentByTag(String tag);

    
    public abstract void popBackStack();

    
    public abstract boolean popBackStackImmediate();

    
    public abstract void popBackStack(String name, int flags);

    
    public abstract boolean popBackStackImmediate(String name, int flags);

    
    public abstract void popBackStack(int id, int flags);

    
    public abstract boolean popBackStackImmediate(int id, int flags);

    
    public abstract int getBackStackEntryCount();

    
    public abstract BackStackEntry getBackStackEntryAt(int index);

    
    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener listener);

    
    public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener listener);

    
    public abstract void putFragment(Bundle bundle, String key, Fragment fragment);

    
    public abstract Fragment getFragment(Bundle bundle, String key);

    
    public abstract Fragment.SavedState saveFragmentInstanceState(Fragment f);

    
    public abstract void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args);

    
        public static void enableDebugLogging(boolean enabled) {
        FragmentManagerImpl.DEBUG = enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.767 -0400", hash_original_method = "15ED404039200ACA8749491C77846D3D", hash_generated_method = "DBB7CD62A7EC5E14380DEAAF62A330E3")
    @DSModeled(DSC.SAFE)
    public void invalidateOptionsMenu() {
        // ---------- Original Method ----------
    }

    
    public interface BackStackEntry {
        
        public int getId();

        
        public String getName();

        
        public int getBreadCrumbTitleRes();

        
        public int getBreadCrumbShortTitleRes();

        
        public CharSequence getBreadCrumbTitle();

        
        public CharSequence getBreadCrumbShortTitle();
    }
    
    public interface OnBackStackChangedListener {
        
        public void onBackStackChanged();
    }
    
    public static final int POP_BACK_STACK_INCLUSIVE = 1<<0;
}

final class FragmentManagerState implements Parcelable {
    FragmentState[] mActive;
    int[] mAdded;
    BackStackState[] mBackStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.768 -0400", hash_original_method = "4ADB2DBBD6899E89144480A7958A6490", hash_generated_method = "252DFEAE0ECB79838960A8B564DE42F6")
    @DSModeled(DSC.SAFE)
    public FragmentManagerState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.768 -0400", hash_original_method = "020574327F1D57965B67553DD6F7D979", hash_generated_method = "9229F669E8366D67B958A9A17EAC1E11")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentManagerState(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mActive = in.createTypedArray(FragmentState.CREATOR);
        mAdded = in.createIntArray();
        mBackStack = in.createTypedArray(BackStackState.CREATOR);
        // ---------- Original Method ----------
        //mActive = in.createTypedArray(FragmentState.CREATOR);
        //mAdded = in.createIntArray();
        //mBackStack = in.createTypedArray(BackStackState.CREATOR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.769 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.769 -0400", hash_original_method = "B6654BF7A24842DC15E6AD3A5F27203C", hash_generated_method = "87638914E95084B6D39C4F4BFD57EE43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeTypedArray(mActive, flags);
        dest.writeIntArray(mAdded);
        dest.writeTypedArray(mBackStack, flags);
        // ---------- Original Method ----------
        //dest.writeTypedArray(mActive, flags);
        //dest.writeIntArray(mAdded);
        //dest.writeTypedArray(mBackStack, flags);
    }

    
    public static final Parcelable.Creator<FragmentManagerState> CREATOR = new Parcelable.Creator<FragmentManagerState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.769 -0400", hash_original_method = "ECDC6A4E7C91D1C5B65C994C4484624F", hash_generated_method = "CE2A80E7C6B3240752DC3BA8B8526F43")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FragmentManagerState createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            FragmentManagerState var8691024B34FE78200A267320E19D956F_772480541 = (new FragmentManagerState(in));
            return (FragmentManagerState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new FragmentManagerState(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.770 -0400", hash_original_method = "91265EDFBDBEA59F353323C915A4EF4F", hash_generated_method = "936BB4F4FE35F8EF83F67E30C8F9F98C")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FragmentManagerState[] newArray(int size) {
            dsTaint.addTaint(size);
            FragmentManagerState[] var9E7041DADA9B0299B12B790379894587_1956369597 = (new FragmentManagerState[size]);
            return (FragmentManagerState[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new FragmentManagerState[size];
        }

        
}; //Transformed anonymous class
}

final class FragmentManagerImpl extends FragmentManager {
    ArrayList<Runnable> mPendingActions;
    Runnable[] mTmpActions;
    boolean mExecutingActions;
    ArrayList<Fragment> mActive;
    ArrayList<Fragment> mAdded;
    ArrayList<Integer> mAvailIndices;
    ArrayList<BackStackRecord> mBackStack;
    ArrayList<Fragment> mCreatedMenus;
    ArrayList<BackStackRecord> mBackStackIndices;
    ArrayList<Integer> mAvailBackStackIndices;
    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    int mCurState = Fragment.INITIALIZING;
    Activity mActivity;
    boolean mNeedMenuInvalidate;
    boolean mStateSaved;
    boolean mDestroyed;
    String mNoTransactionsBecause;
    boolean mHavePendingDeferredStart;
    Bundle mStateBundle = null;
    SparseArray<Parcelable> mStateArray = null;
    Runnable mExecCommit = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.771 -0400", hash_original_method = "C2BA1C69EB0B4CCFF1A319535DB79508", hash_generated_method = "FEDC918E58215E12D8175F59CA2BA6B4")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void run() {
            execPendingActions();
            // ---------- Original Method ----------
            //execPendingActions();
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.771 -0400", hash_original_method = "A99DA5C824A58A1CC6BBB4936DB73E33", hash_generated_method = "A99DA5C824A58A1CC6BBB4936DB73E33")
        public FragmentManagerImpl ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.771 -0400", hash_original_method = "FD4DF6D1DA8CD9545895F43FA5CF7B0B", hash_generated_method = "778386C527094C81D19B6CC2BF1561DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public FragmentTransaction beginTransaction() {
        FragmentTransaction varF116A87DBF1136F19BE3AE696B35D983_295549362 = (new BackStackRecord(this));
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new BackStackRecord(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.771 -0400", hash_original_method = "082964FFA3913D960E19EEB76BD9505B", hash_generated_method = "28B8AD1E25809239CDBBDD23C6FDA744")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean executePendingTransactions() {
        boolean varDEC74AD03B6C92C5F58BDD6F9B78062F_351887838 = (execPendingActions());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return execPendingActions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.772 -0400", hash_original_method = "5CB88371A39240A7C2FB2F2041C5DD0D", hash_generated_method = "57CC3CC925759A206F719045C1EDB574")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void popBackStack() {
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.772 -0400", hash_original_method = "C15C9D80C4BF4FB6B2AF0B93A4449441", hash_generated_method = "B3F70B584C16FE3B98A16E26008D78C3")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                popBackStackState(mActivity.mHandler, null, -1, 0);
                // ---------- Original Method ----------
                //popBackStackState(mActivity.mHandler, null, -1, 0);
            }
}, false);
        // ---------- Original Method ----------
        //enqueueAction(new Runnable() {
            //@Override public void run() {
                //popBackStackState(mActivity.mHandler, null, -1, 0);
            //}
        //}, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.772 -0400", hash_original_method = "B7072E2D8E1B8CAC03251D641D234641", hash_generated_method = "F08B2D3769386C06FDD989512DC601B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        boolean varE659918100A3B568A6F3D267CDA15217_256120452 = (popBackStackState(mActivity.mHandler, null, -1, 0));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, null, -1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.773 -0400", hash_original_method = "9E86D2BA46D98A91B2D43097CFA7F639", hash_generated_method = "40191AD16ADD2B3204530FB88D225A0B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void popBackStack(final String name, final int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(name);
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.773 -0400", hash_original_method = "22FC8A6DB6B4AB9E651D01E64BEED72A", hash_generated_method = "3FE29178F98A070A5E0ED21762A74700")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                popBackStackState(mActivity.mHandler, name, -1, flags);
                // ---------- Original Method ----------
                //popBackStackState(mActivity.mHandler, name, -1, flags);
            }
}, false);
        // ---------- Original Method ----------
        //enqueueAction(new Runnable() {
            //@Override public void run() {
                //popBackStackState(mActivity.mHandler, name, -1, flags);
            //}
        //}, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.774 -0400", hash_original_method = "4DEC43188CEAB5FA4EF2839673649ECC", hash_generated_method = "49759708176825A51EC571D12381F2AC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(name);
        checkStateLoss();
        executePendingTransactions();
        boolean var8537C2C3238620E29A2DABFDDEEAED83_1161157881 = (popBackStackState(mActivity.mHandler, name, -1, flags));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, name, -1, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.774 -0400", hash_original_method = "DA57C1B5DA7DBD65A6FF7556F6C0B827", hash_generated_method = "757D9C3B82A3C5EAFCA84370FAF44B24")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void popBackStack(final int id, final int flags) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(flags);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } //End block
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.774 -0400", hash_original_method = "DBCE7037D51EB5153CDA373E6D392F0E", hash_generated_method = "905DCE3DB8D6804FD0D561A3F3EB2065")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                popBackStackState(mActivity.mHandler, null, id, flags);
                // ---------- Original Method ----------
                //popBackStackState(mActivity.mHandler, null, id, flags);
            }
}, false);
        // ---------- Original Method ----------
        //if (id < 0) {
            //throw new IllegalArgumentException("Bad id: " + id);
        //}
        //enqueueAction(new Runnable() {
            //@Override public void run() {
                //popBackStackState(mActivity.mHandler, null, id, flags);
            //}
        //}, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.775 -0400", hash_original_method = "C28CBCAD3FA2084F032C85B006AF0CA6", hash_generated_method = "B25203F5C1B9757CFA76F472C33189DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(flags);
        checkStateLoss();
        executePendingTransactions();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } //End block
        boolean var4EE663DB9CE1C64C129233E54BE6C6E6_566736541 = (popBackStackState(mActivity.mHandler, null, id, flags));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //if (id < 0) {
            //throw new IllegalArgumentException("Bad id: " + id);
        //}
        //return popBackStackState(mActivity.mHandler, null, id, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.775 -0400", hash_original_method = "81448DC3AD62196301F3A4A762AB09A8", hash_generated_method = "58576EE5F7D8C9077BABA24550558F00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int getBackStackEntryCount() {
        {
            Object var0D23A520C4639C79F477D4746DB89D7E_1955456309 = (mBackStack.size());
        } //End flattened ternary
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBackStack != null ? mBackStack.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.776 -0400", hash_original_method = "898A7E40DF942FAA7422F0070AE7C2C0", hash_generated_method = "9AE2B0670AAEA2FE88A50C95D4CB0E71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        dsTaint.addTaint(index);
        BackStackEntry varFD9435BDABE9FC8F6E4B4A98766B9EE0_1156329476 = (mBackStack.get(index));
        return (BackStackEntry)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mBackStack.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.776 -0400", hash_original_method = "5B02C223CD8F1AC3632AF80A3BE5FAF1", hash_generated_method = "4520B27C0438C7F58B6CFFC5C93B11A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        } //End block
        mBackStackChangeListeners.add(listener);
        // ---------- Original Method ----------
        //if (mBackStackChangeListeners == null) {
            //mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        //}
        //mBackStackChangeListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.777 -0400", hash_original_method = "0EB71E2FD8D5B96EE15FDFA4CFDC7A3A", hash_generated_method = "348960C20221D3703189CC9A0CCAD966")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        dsTaint.addTaint(listener.dsTaint);
        {
            mBackStackChangeListeners.remove(listener);
        } //End block
        // ---------- Original Method ----------
        //if (mBackStackChangeListeners != null) {
            //mBackStackChangeListeners.remove(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.777 -0400", hash_original_method = "28A5058460B6EF16DD9CEE59F403CB5D", hash_generated_method = "EE4B9FD9F47FF10C7851E3323FF1A683")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        dsTaint.addTaint(bundle.dsTaint);
        dsTaint.addTaint(fragment.dsTaint);
        dsTaint.addTaint(key);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
        } //End block
        bundle.putInt(key, fragment.mIndex);
        // ---------- Original Method ----------
        //if (fragment.mIndex < 0) {
            //throw new IllegalStateException("Fragment " + fragment
                    //+ " is not currently in the FragmentManager");
        //}
        //bundle.putInt(key, fragment.mIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.778 -0400", hash_original_method = "D08899B1EE8437F622E0D7F7BA40A91F", hash_generated_method = "B38001765B3AB10386CB448839BBED80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        dsTaint.addTaint(bundle.dsTaint);
        dsTaint.addTaint(key);
        int index;
        index = bundle.getInt(key, -1);
        {
            boolean var107AB73BAE9815E9603DA2E7CAF7C8B7_619814923 = (index >= mActive.size());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index);
            } //End block
        } //End collapsed parenthetic
        Fragment f;
        f = mActive.get(index);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index);
        } //End block
        return (Fragment)dsTaint.getTaint();
        // ---------- Original Method ----------
        //int index = bundle.getInt(key, -1);
        //if (index == -1) {
            //return null;
        //}
        //if (index >= mActive.size()) {
            //throw new IllegalStateException("Fragement no longer exists for key "
                    //+ key + ": index " + index);
        //}
        //Fragment f = mActive.get(index);
        //if (f == null) {
            //throw new IllegalStateException("Fragement no longer exists for key "
                    //+ key + ": index " + index);
        //}
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.778 -0400", hash_original_method = "CF6272FD6214D7D7484637054FD9E74F", hash_generated_method = "20CA0133C6CEC5BBFE375BDC91A84B51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        dsTaint.addTaint(fragment.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
        } //End block
        {
            Bundle result;
            result = saveFragmentBasicState(fragment);
            {
                Object var8E5CC6F50E01A4A6896BDD357578AFD6_53423584 = (new Fragment.SavedState(result));
            } //End flattened ternary
        } //End block
        return (Fragment.SavedState)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (fragment.mIndex < 0) {
            //throw new IllegalStateException("Fragment " + fragment
                    //+ " is not currently in the FragmentManager");
        //}
        //if (fragment.mState > Fragment.INITIALIZING) {
            //Bundle result = saveFragmentBasicState(fragment);
            //return result != null ? new Fragment.SavedState(result) : null;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.779 -0400", hash_original_method = "A7D5B4266978FAAC75BAC34E53BDC41B", hash_generated_method = "BF18F71C88509B7D91F502A96514742E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        String var806458D832AB974D230FEE4CBBDBD390_689784045 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("FragmentManager{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(" in ");
        //DebugUtils.buildShortClassTag(mActivity, sb);
        //sb.append("}}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.781 -0400", hash_original_method = "0EF991BB6A19DFA56B66936C5498080A", hash_generated_method = "0A4E22A9E7C7FE99D19857A748F7F904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(writer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        String innerPrefix;
        innerPrefix = prefix + "    ";
        int N;
        {
            N = mActive.size();
            {
                writer.print(prefix);
                writer.print("Active Fragments in ");
                writer.print(Integer.toHexString(System.identityHashCode(this)));
                writer.println(":");
                {
                    int i;
                    i = 0;
                    {
                        Fragment f;
                        f = mActive.get(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(i);
                        writer.print(": ");
                        writer.println(f);
                        {
                            f.dump(innerPrefix, fd, writer, args);
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            N = mAdded.size();
            {
                writer.print(prefix);
                writer.println("Added Fragments:");
                {
                    int i;
                    i = 0;
                    {
                        Fragment f;
                        f = mAdded.get(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(i);
                        writer.print(": ");
                        writer.println(f.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            N = mCreatedMenus.size();
            {
                writer.print(prefix);
                writer.println("Fragments Created Menus:");
                {
                    int i;
                    i = 0;
                    {
                        Fragment f;
                        f = mCreatedMenus.get(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(i);
                        writer.print(": ");
                        writer.println(f.toString());
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            N = mBackStack.size();
            {
                writer.print(prefix);
                writer.println("Back Stack:");
                {
                    int i;
                    i = 0;
                    {
                        BackStackRecord bs;
                        bs = mBackStack.get(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(i);
                        writer.print(": ");
                        writer.println(bs.toString());
                        bs.dump(innerPrefix, fd, writer, args);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            {
                N = mBackStackIndices.size();
                {
                    writer.print(prefix);
                    writer.println("Back Stack Indices:");
                    {
                        int i;
                        i = 0;
                        {
                            BackStackRecord bs;
                            bs = mBackStackIndices.get(i);
                            writer.print(prefix);
                            writer.print("  #");
                            writer.print(i);
                            writer.print(": ");
                            writer.println(bs);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            {
                boolean varC3EC129F2815C61E4CC968B0C16B5E00_2062605987 = (mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0);
                {
                    writer.print(prefix);
                    writer.print("mAvailBackStackIndices: ");
                    writer.println(Arrays.toString(mAvailBackStackIndices.toArray()));
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            N = mPendingActions.size();
            {
                writer.print(prefix);
                writer.println("Pending Actions:");
                {
                    int i;
                    i = 0;
                    {
                        Runnable r;
                        r = mPendingActions.get(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(i);
                        writer.print(": ");
                        writer.println(r);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        writer.print(prefix);
        writer.println("FragmentManager misc state:");
        writer.print(prefix);
        writer.print("  mCurState=");
        writer.print(mCurState);
        writer.print(" mStateSaved=");
        writer.print(mStateSaved);
        writer.print(" mDestroyed=");
        writer.println(mDestroyed);
        {
            writer.print(prefix);
            writer.print("  mNeedMenuInvalidate=");
            writer.println(mNeedMenuInvalidate);
        } //End block
        {
            writer.print(prefix);
            writer.print("  mNoTransactionsBecause=");
            writer.println(mNoTransactionsBecause);
        } //End block
        {
            boolean varD0CA0404E33A0C2149F9FC712F4B1B56_1310261426 = (mAvailIndices != null && mAvailIndices.size() > 0);
            {
                writer.print(prefix);
                writer.print("  mAvailIndices: ");
                writer.println(Arrays.toString(mAvailIndices.toArray()));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.783 -0400", hash_original_method = "8FB9E657DCE437B207C489B8932863BA", hash_generated_method = "D7A3ED0D56238A926D85B26B59EE949E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Animator loadAnimator(Fragment fragment, int transit, boolean enter,
            int transitionStyle) {
        dsTaint.addTaint(enter);
        dsTaint.addTaint(transit);
        dsTaint.addTaint(fragment.dsTaint);
        dsTaint.addTaint(transitionStyle);
        Animator animObj;
        animObj = fragment.onCreateAnimator(transit, enter,
                fragment.mNextAnim);
        {
            Animator anim;
            anim = AnimatorInflater.loadAnimator(mActivity, fragment.mNextAnim);
        } //End block
        int styleIndex;
        styleIndex = transitToStyleIndex(transit, enter);
        {
            boolean var7E1D31F47E4E5D9D781C22ACD7E0177E_603189053 = (transitionStyle == 0 && mActivity.getWindow() != null);
            {
                transitionStyle = mActivity.getWindow().getAttributes().windowAnimations;
            } //End block
        } //End collapsed parenthetic
        TypedArray attrs;
        attrs = mActivity.obtainStyledAttributes(transitionStyle,
                com.android.internal.R.styleable.FragmentAnimation);
        int anim;
        anim = attrs.getResourceId(styleIndex, 0);
        attrs.recycle();
        Animator varD214523EDE029C445A12A8470A1DAE22_126012055 = (AnimatorInflater.loadAnimator(mActivity, anim));
        return (Animator)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.783 -0400", hash_original_method = "BB58D6FD0DD6E4462529DBFA77E71E10", hash_generated_method = "7E1E1161F32DA0EB89A6DCC3D4A0CF99")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void performPendingDeferredStart(Fragment f) {
        dsTaint.addTaint(f.dsTaint);
        {
            {
                mHavePendingDeferredStart = true;
            } //End block
            f.mDeferStart = false;
            moveToState(f, mCurState, 0, 0);
        } //End block
        // ---------- Original Method ----------
        //if (f.mDeferStart) {
            //if (mExecutingActions) {
                //mHavePendingDeferredStart = true;
                //return;
            //}
            //f.mDeferStart = false;
            //moveToState(f, mCurState, 0, 0);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.786 -0400", hash_original_method = "EE92853A739004991ACA465267191DB6", hash_generated_method = "991EC30B732F12FD79E6404E4E9DB86F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void moveToState(Fragment f, int newState, int transit, int transitionStyle) {
        dsTaint.addTaint(f.dsTaint);
        dsTaint.addTaint(newState);
        dsTaint.addTaint(transit);
        dsTaint.addTaint(transitionStyle);
        {
            newState = Fragment.CREATED;
        } //End block
        {
            newState = f.mState;
        } //End block
        {
            newState = Fragment.STOPPED;
        } //End block
        {
            {
                f.mAnimatingAway = null;
                moveToState(f, f.mStateAfterAnimating, 0, 0);
            } //End block
            //Begin case Fragment.INITIALIZING 
            {
                f.mSavedViewState = f.mSavedFragmentState.getSparseParcelableArray(
                                FragmentManagerImpl.VIEW_STATE_TAG);
                f.mTarget = getFragment(f.mSavedFragmentState,
                                FragmentManagerImpl.TARGET_STATE_TAG);
                {
                    f.mTargetRequestCode = f.mSavedFragmentState.getInt(
                                    FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG, 0);
                } //End block
                f.mUserVisibleHint = f.mSavedFragmentState.getBoolean(
                                FragmentManagerImpl.USER_VISIBLE_HINT_TAG, true);
                {
                    f.mDeferStart = true;
                    {
                        newState = Fragment.STOPPED;
                    } //End block
                } //End block
            } //End block
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            f.mActivity = mActivity;
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            f.mFragmentManager = mActivity.mFragments;
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            f.mCalled = false;
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            f.onAttach(mActivity);
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            {
                if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                + " did not call through to super.onAttach()");
            } //End block
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            mActivity.onAttachFragment(f);
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            {
                f.mCalled = false;
                f.onCreate(f.mSavedFragmentState);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onCreate()");
                } //End block
            } //End block
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            f.mRetaining = false;
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            {
                f.mView = f.onCreateView(f.getLayoutInflater(f.mSavedFragmentState),
                                null, f.mSavedFragmentState);
                {
                    f.mView.setSaveFromParentEnabled(false);
                    f.mView.setVisibility(View.GONE);
                    f.onViewCreated(f.mView, f.mSavedFragmentState);
                } //End block
            } //End block
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.CREATED 
            {
                {
                    ViewGroup container;
                    container = null;
                    {
                        container = (ViewGroup)mActivity.findViewById(f.mContainerId);
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("No view found for id 0x"
                                            + Integer.toHexString(f.mContainerId)
                                            + " for fragment " + f);
                        } //End block
                    } //End block
                    f.mContainer = container;
                    f.mView = f.onCreateView(f.getLayoutInflater(f.mSavedFragmentState),
                                    container, f.mSavedFragmentState);
                    {
                        f.mView.setSaveFromParentEnabled(false);
                        {
                            Animator anim;
                            anim = loadAnimator(f, transit, true,
                                            transitionStyle);
                            {
                                anim.setTarget(f.mView);
                                anim.start();
                            } //End block
                            container.addView(f.mView);
                        } //End block
                        f.mView.setVisibility(View.GONE);
                        f.onViewCreated(f.mView, f.mSavedFragmentState);
                    } //End block
                } //End block
                f.mCalled = false;
                f.onActivityCreated(f.mSavedFragmentState);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onActivityCreated()");
                } //End block
                {
                    f.restoreViewState();
                } //End block
                f.mSavedFragmentState = null;
            } //End block
            //End case Fragment.CREATED 
            //Begin case Fragment.ACTIVITY_CREATED Fragment.STOPPED 
            {
                f.mCalled = false;
                f.performStart();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onStart()");
                } //End block
            } //End block
            //End case Fragment.ACTIVITY_CREATED Fragment.STOPPED 
            //Begin case Fragment.STARTED 
            {
                f.mCalled = false;
                f.mResumed = true;
                f.onResume();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onResume()");
                } //End block
                f.mSavedFragmentState = null;
                f.mSavedViewState = null;
            } //End block
            //End case Fragment.STARTED 
        } //End block
        {
            //Begin case Fragment.RESUMED 
            {
                f.mCalled = false;
                f.onPause();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onPause()");
                } //End block
                f.mResumed = false;
            } //End block
            //End case Fragment.RESUMED 
            //Begin case Fragment.STARTED 
            {
                f.mCalled = false;
                f.performStop();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onStop()");
                } //End block
            } //End block
            //End case Fragment.STARTED 
            //Begin case Fragment.STOPPED Fragment.ACTIVITY_CREATED 
            {
                {
                    {
                        boolean var96EB76334F7F0C83DB99A12D79366153_924545689 = (!mActivity.isFinishing() && f.mSavedViewState == null);
                        {
                            saveFragmentViewState(f);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                f.mCalled = false;
                f.performDestroyView();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onDestroyView()");
                } //End block
                {
                    Animator anim;
                    anim = null;
                    {
                        anim = loadAnimator(f, transit, false,
                                        transitionStyle);
                    } //End block
                    {
                        ViewGroup container;
                        container = f.mContainer;
                        View view;
                        view = f.mView;
                        Fragment fragment;
                        fragment = f;
                        container.startViewTransition(view);
                        f.mAnimatingAway = anim;
                        f.mStateAfterAnimating = newState;
                        anim.addListener(new AnimatorListenerAdapter() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.785 -0400", hash_original_method = "9D8EA3EF50700F2206500D8F97DFE625", hash_generated_method = "B471943800105A734C51782872C8DA21")
                            //DSFIXME:  CODE0002: Requires DSC value to be set
                            @Override
                            public void onAnimationEnd(Animator anim) {
                                //DSFIXME:  CODE0009: Possible callback target function detected
                                dsTaint.addTaint(anim.dsTaint);
                                container.endViewTransition(view);
                                {
                                    fragment.mAnimatingAway = null;
                                    moveToState(fragment, fragment.mStateAfterAnimating,
                                                    0, 0);
                                } //End block
                                // ---------- Original Method ----------
                                //container.endViewTransition(view);
                                //if (fragment.mAnimatingAway != null) {
                                            //fragment.mAnimatingAway = null;
                                            //moveToState(fragment, fragment.mStateAfterAnimating,
                                                    //0, 0);
                                        //}
                            }
});
                        anim.setTarget(f.mView);
                        anim.start();
                    } //End block
                    f.mContainer.removeView(f.mView);
                } //End block
                f.mContainer = null;
                f.mView = null;
            } //End block
            //End case Fragment.STOPPED Fragment.ACTIVITY_CREATED 
            //Begin case Fragment.CREATED 
            {
                {
                    {
                        Animator anim;
                        anim = f.mAnimatingAway;
                        f.mAnimatingAway = null;
                        anim.cancel();
                    } //End block
                } //End block
                {
                    f.mStateAfterAnimating = newState;
                    newState = Fragment.CREATED;
                } //End block
                {
                    {
                        f.mCalled = false;
                        f.onDestroy();
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                            + " did not call through to super.onDestroy()");
                        } //End block
                    } //End block
                    f.mCalled = false;
                    f.onDetach();
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                        + " did not call through to super.onDetach()");
                    } //End block
                    {
                        makeInactive(f);
                    } //End block
                    {
                        f.mActivity = null;
                        f.mFragmentManager = null;
                    } //End block
                } //End block
            } //End block
            //End case Fragment.CREATED 
        } //End block
        f.mState = newState;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.787 -0400", hash_original_method = "8CD289FFBEE11A8449DF6C5CC9F9ABBD", hash_generated_method = "8D61B36E28E74341A1A499578BAC428A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void moveToState(Fragment f) {
        dsTaint.addTaint(f.dsTaint);
        moveToState(f, mCurState, 0, 0);
        // ---------- Original Method ----------
        //moveToState(f, mCurState, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.787 -0400", hash_original_method = "4A2DC4C23578532593EF5B01DCA60326", hash_generated_method = "142A7CCCEE5B775BDC1B4177375597A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void moveToState(int newState, boolean always) {
        dsTaint.addTaint(always);
        dsTaint.addTaint(newState);
        moveToState(newState, 0, 0, always);
        // ---------- Original Method ----------
        //moveToState(newState, 0, 0, always);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.788 -0400", hash_original_method = "EC27B7DF943700174166429595B46255", hash_generated_method = "18CE4C8D92E3D95293557B4B5C9252C5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void moveToState(int newState, int transit, int transitStyle, boolean always) {
        dsTaint.addTaint(always);
        dsTaint.addTaint(newState);
        dsTaint.addTaint(transitStyle);
        dsTaint.addTaint(transit);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No activity");
        } //End block
        {
            boolean loadersRunning;
            loadersRunning = false;
            {
                int i;
                i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_877702165 = (i<mActive.size());
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        moveToState(f, newState, transit, transitStyle);
                        {
                            loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                startPendingDeferredFragments();
            } //End block
            {
                mActivity.invalidateOptionsMenu();
                mNeedMenuInvalidate = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.788 -0400", hash_original_method = "CCAA4C21D5B5313253593374D7FC1754", hash_generated_method = "BF5EB85B79F96088CC0CCE7FCFE82904")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void startPendingDeferredFragments() {
        {
            int i;
            i = 0;
            boolean varBBF7D06AD5BD96085BA2B334471E7136_27334107 = (i<mActive.size());
            {
                Fragment f;
                f = mActive.get(i);
                {
                    performPendingDeferredStart(f);
                } //End block
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (mActive == null) return;
        //for (int i=0; i<mActive.size(); i++) {
            //Fragment f = mActive.get(i);
            //if (f != null) {
                //performPendingDeferredStart(f);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.789 -0400", hash_original_method = "D50E4D1CE651B3B8515ED7A1E81CB61B", hash_generated_method = "79B38F1904CF9471B274EE5B74043A5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void makeActive(Fragment f) {
        dsTaint.addTaint(f.dsTaint);
        {
            boolean var0C317551F6EB79301C3E3065D871C4BD_2019671179 = (mAvailIndices == null || mAvailIndices.size() <= 0);
            {
                {
                    mActive = new ArrayList<Fragment>();
                } //End block
                f.setIndex(mActive.size());
                mActive.add(f);
            } //End block
            {
                f.setIndex(mAvailIndices.remove(mAvailIndices.size()-1));
                mActive.set(f.mIndex, f);
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (f.mIndex >= 0) {
            //return;
        //}
        //if (mAvailIndices == null || mAvailIndices.size() <= 0) {
            //if (mActive == null) {
                //mActive = new ArrayList<Fragment>();
            //}
            //f.setIndex(mActive.size());
            //mActive.add(f);
        //} else {
            //f.setIndex(mAvailIndices.remove(mAvailIndices.size()-1));
            //mActive.set(f.mIndex, f);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.789 -0400", hash_original_method = "21A9491D104F42D1B78CA5222CCDF2B0", hash_generated_method = "6BE8C997F2439ECE80784C61DE372726")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void makeInactive(Fragment f) {
        dsTaint.addTaint(f.dsTaint);
        mActive.set(f.mIndex, null);
        {
            mAvailIndices = new ArrayList<Integer>();
        } //End block
        mAvailIndices.add(f.mIndex);
        mActivity.invalidateFragmentIndex(f.mIndex);
        f.initState();
        // ---------- Original Method ----------
        //if (f.mIndex < 0) {
            //return;
        //}
        //if (DEBUG) Log.v(TAG, "Freeing fragment index " + f.mIndex);
        //mActive.set(f.mIndex, null);
        //if (mAvailIndices == null) {
            //mAvailIndices = new ArrayList<Integer>();
        //}
        //mAvailIndices.add(f.mIndex);
        //mActivity.invalidateFragmentIndex(f.mIndex);
        //f.initState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.790 -0400", hash_original_method = "39A4C55EF4B2F4D7AD9F69C21FC91745", hash_generated_method = "51DA14FF2D30E4B6647ED5CDA7A90E97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addFragment(Fragment fragment, boolean moveToStateNow) {
        dsTaint.addTaint(moveToStateNow);
        dsTaint.addTaint(fragment.dsTaint);
        {
            mAdded = new ArrayList<Fragment>();
        } //End block
        makeActive(fragment);
        {
            mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            {
                mNeedMenuInvalidate = true;
            } //End block
            {
                moveToState(fragment);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mAdded == null) {
            //mAdded = new ArrayList<Fragment>();
        //}
        //if (DEBUG) Log.v(TAG, "add: " + fragment);
        //makeActive(fragment);
        //if (!fragment.mDetached) {
            //mAdded.add(fragment);
            //fragment.mAdded = true;
            //fragment.mRemoving = false;
            //if (fragment.mHasMenu && fragment.mMenuVisible) {
                //mNeedMenuInvalidate = true;
            //}
            //if (moveToStateNow) {
                //moveToState(fragment);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.790 -0400", hash_original_method = "47129A78A86358373557A8CBE26A47CF", hash_generated_method = "7BA66896B4CBBB09D372292A779D220B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeFragment(Fragment fragment, int transition, int transitionStyle) {
        dsTaint.addTaint(transition);
        dsTaint.addTaint(fragment.dsTaint);
        dsTaint.addTaint(transitionStyle);
        boolean inactive;
        inactive = !fragment.isInBackStack();
        {
            mAdded.remove(fragment);
            {
                mNeedMenuInvalidate = true;
            } //End block
            fragment.mAdded = false;
            fragment.mRemoving = true;
            moveToState(fragment, inactive ? Fragment.INITIALIZING : Fragment.CREATED,
                    transition, transitionStyle);
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        //final boolean inactive = !fragment.isInBackStack();
        //if (!fragment.mDetached || inactive) {
            //mAdded.remove(fragment);
            //if (fragment.mHasMenu && fragment.mMenuVisible) {
                //mNeedMenuInvalidate = true;
            //}
            //fragment.mAdded = false;
            //fragment.mRemoving = true;
            //moveToState(fragment, inactive ? Fragment.INITIALIZING : Fragment.CREATED,
                    //transition, transitionStyle);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.791 -0400", hash_original_method = "066049DB7DB3E7A9AEFB54490F59C652", hash_generated_method = "FDE6591799A6E13B0BF5A9B916B8499F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void hideFragment(Fragment fragment, int transition, int transitionStyle) {
        dsTaint.addTaint(transition);
        dsTaint.addTaint(fragment.dsTaint);
        dsTaint.addTaint(transitionStyle);
        {
            fragment.mHidden = true;
            {
                Animator anim;
                anim = loadAnimator(fragment, transition, true,
                        transitionStyle);
                {
                    anim.setTarget(fragment.mView);
                    Fragment finalFragment;
                    finalFragment = fragment;
                    anim.addListener(new AnimatorListenerAdapter() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.791 -0400", hash_original_method = "FE6C0F24C850190D502A7783FD2F34FA", hash_generated_method = "44B518BE7D2038EAE5C39E56DA7D6AF9")
                        //DSFIXME:  CODE0002: Requires DSC value to be set
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            dsTaint.addTaint(animation.dsTaint);
                            {
                                finalFragment.mView.setVisibility(View.GONE);
                            } //End block
                            // ---------- Original Method ----------
                            //if (finalFragment.mView != null) {
                                //finalFragment.mView.setVisibility(View.GONE);
                            //}
                        }
});
                    anim.start();
                } //End block
                {
                    fragment.mView.setVisibility(View.GONE);
                } //End block
            } //End block
            {
                mNeedMenuInvalidate = true;
            } //End block
            fragment.onHiddenChanged(true);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.792 -0400", hash_original_method = "DD64B7390BAEF5796124974048F6770D", hash_generated_method = "25B0A1A159E7BC093B436032D2B6F724")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void showFragment(Fragment fragment, int transition, int transitionStyle) {
        dsTaint.addTaint(transition);
        dsTaint.addTaint(fragment.dsTaint);
        dsTaint.addTaint(transitionStyle);
        {
            fragment.mHidden = false;
            {
                Animator anim;
                anim = loadAnimator(fragment, transition, true,
                        transitionStyle);
                {
                    anim.setTarget(fragment.mView);
                    anim.start();
                } //End block
                fragment.mView.setVisibility(View.VISIBLE);
            } //End block
            {
                mNeedMenuInvalidate = true;
            } //End block
            fragment.onHiddenChanged(false);
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "show: " + fragment);
        //if (fragment.mHidden) {
            //fragment.mHidden = false;
            //if (fragment.mView != null) {
                //Animator anim = loadAnimator(fragment, transition, true,
                        //transitionStyle);
                //if (anim != null) {
                    //anim.setTarget(fragment.mView);
                    //anim.start();
                //}
                //fragment.mView.setVisibility(View.VISIBLE);
            //}
            //if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                //mNeedMenuInvalidate = true;
            //}
            //fragment.onHiddenChanged(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.792 -0400", hash_original_method = "9E4782C1879A41669B298A15D404F278", hash_generated_method = "2D9996F61DCD18A785651F746808C647")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void detachFragment(Fragment fragment, int transition, int transitionStyle) {
        dsTaint.addTaint(transition);
        dsTaint.addTaint(fragment.dsTaint);
        dsTaint.addTaint(transitionStyle);
        {
            fragment.mDetached = true;
            {
                mAdded.remove(fragment);
                {
                    mNeedMenuInvalidate = true;
                } //End block
                fragment.mAdded = false;
                moveToState(fragment, Fragment.CREATED, transition, transitionStyle);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "detach: " + fragment);
        //if (!fragment.mDetached) {
            //fragment.mDetached = true;
            //if (fragment.mAdded) {
                //mAdded.remove(fragment);
                //if (fragment.mHasMenu && fragment.mMenuVisible) {
                    //mNeedMenuInvalidate = true;
                //}
                //fragment.mAdded = false;
                //moveToState(fragment, Fragment.CREATED, transition, transitionStyle);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.793 -0400", hash_original_method = "681D8A8EBC4582B35DF715CE5B5E6679", hash_generated_method = "27E4808E705F47BEB5CCC7049F26FCF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachFragment(Fragment fragment, int transition, int transitionStyle) {
        dsTaint.addTaint(transition);
        dsTaint.addTaint(fragment.dsTaint);
        dsTaint.addTaint(transitionStyle);
        {
            fragment.mDetached = false;
            {
                mAdded.add(fragment);
                fragment.mAdded = true;
                {
                    mNeedMenuInvalidate = true;
                } //End block
                moveToState(fragment, mCurState, transition, transitionStyle);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "attach: " + fragment);
        //if (fragment.mDetached) {
            //fragment.mDetached = false;
            //if (!fragment.mAdded) {
                //mAdded.add(fragment);
                //fragment.mAdded = true;
                //if (fragment.mHasMenu && fragment.mMenuVisible) {
                    //mNeedMenuInvalidate = true;
                //}
                //moveToState(fragment, mCurState, transition, transitionStyle);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.794 -0400", hash_original_method = "846CFE4E6D453F7EB47298FC794E62E7", hash_generated_method = "5E9E62229EA614F794C764F506BEB4AB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Fragment findFragmentById(int id) {
        dsTaint.addTaint(id);
        {
            {
                int i;
                i = mAdded.size()-1;
                {
                    Fragment f;
                    f = mAdded.get(i);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = mActive.size()-1;
                {
                    Fragment f;
                    f = mActive.get(i);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Fragment)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mActive != null) {
            //for (int i=mAdded.size()-1; i>=0; i--) {
                //Fragment f = mAdded.get(i);
                //if (f != null && f.mFragmentId == id) {
                    //return f;
                //}
            //}
            //for (int i=mActive.size()-1; i>=0; i--) {
                //Fragment f = mActive.get(i);
                //if (f != null && f.mFragmentId == id) {
                    //return f;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.794 -0400", hash_original_method = "5F9B0395F726C1A39BFC043E2E96E889", hash_generated_method = "4C78F26DFFDD5AFC70353F497CF10329")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Fragment findFragmentByTag(String tag) {
        dsTaint.addTaint(tag);
        {
            {
                int i;
                i = mAdded.size()-1;
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_1989851123 = (f != null && tag.equals(f.mTag));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = mActive.size()-1;
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_1569219026 = (f != null && tag.equals(f.mTag));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Fragment)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mActive != null && tag != null) {
            //for (int i=mAdded.size()-1; i>=0; i--) {
                //Fragment f = mAdded.get(i);
                //if (f != null && tag.equals(f.mTag)) {
                    //return f;
                //}
            //}
            //for (int i=mActive.size()-1; i>=0; i--) {
                //Fragment f = mActive.get(i);
                //if (f != null && tag.equals(f.mTag)) {
                    //return f;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.795 -0400", hash_original_method = "BBAAD10FC9AB450B3B7E8CD0A108A471", hash_generated_method = "5B8C8FE806A06876E5F110226C2FBE48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Fragment findFragmentByWho(String who) {
        dsTaint.addTaint(who);
        {
            {
                int i;
                i = mActive.size()-1;
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        boolean var9326B715BF996C787D3FE61249DC42AB_402102831 = (f != null && who.equals(f.mWho));
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (Fragment)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mActive != null && who != null) {
            //for (int i=mActive.size()-1; i>=0; i--) {
                //Fragment f = mActive.get(i);
                //if (f != null && who.equals(f.mWho)) {
                    //return f;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.795 -0400", hash_original_method = "B87B380B690A16EB7F37B7EE1C0A0D26", hash_generated_method = "4076EE59F13ECCD4B07230734A017E5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void checkStateLoss() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Can not perform this action after onSaveInstanceState");
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Can not perform this action inside of " + mNoTransactionsBecause);
        } //End block
        // ---------- Original Method ----------
        //if (mStateSaved) {
            //throw new IllegalStateException(
                    //"Can not perform this action after onSaveInstanceState");
        //}
        //if (mNoTransactionsBecause != null) {
            //throw new IllegalStateException(
                    //"Can not perform this action inside of " + mNoTransactionsBecause);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.796 -0400", hash_original_method = "32359130EC903AF4E096237D1F067453", hash_generated_method = "06543B244827AD20D65AFB211E33A15C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void enqueueAction(Runnable action, boolean allowStateLoss) {
        dsTaint.addTaint(action.dsTaint);
        dsTaint.addTaint(allowStateLoss);
        {
            checkStateLoss();
        } //End block
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Activity has been destroyed");
            } //End block
            {
                mPendingActions = new ArrayList<Runnable>();
            } //End block
            mPendingActions.add(action);
            {
                boolean varED396C6F84781DC21825B4A03F526E3B_1813001400 = (mPendingActions.size() == 1);
                {
                    mActivity.mHandler.removeCallbacks(mExecCommit);
                    mActivity.mHandler.post(mExecCommit);
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (!allowStateLoss) {
            //checkStateLoss();
        //}
        //synchronized (this) {
            //if (mActivity == null) {
                //throw new IllegalStateException("Activity has been destroyed");
            //}
            //if (mPendingActions == null) {
                //mPendingActions = new ArrayList<Runnable>();
            //}
            //mPendingActions.add(action);
            //if (mPendingActions.size() == 1) {
                //mActivity.mHandler.removeCallbacks(mExecCommit);
                //mActivity.mHandler.post(mExecCommit);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.796 -0400", hash_original_method = "1503673DA6CC1FF53261337C6A89F6BE", hash_generated_method = "36EE6F00B123AAE5C08EC3B26686E578")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int allocBackStackIndex(BackStackRecord bse) {
        dsTaint.addTaint(bse.dsTaint);
        {
            {
                boolean var98612EE02F6CF00DE971BBFA890C1BB0_494835812 = (mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0);
                {
                    {
                        mBackStackIndices = new ArrayList<BackStackRecord>();
                    } //End block
                    int index;
                    index = mBackStackIndices.size();
                    mBackStackIndices.add(bse);
                } //End block
                {
                    int index;
                    index = mAvailBackStackIndices.remove(mAvailBackStackIndices.size()-1);
                    mBackStackIndices.set(index, bse);
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //synchronized (this) {
            //if (mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0) {
                //if (mBackStackIndices == null) {
                    //mBackStackIndices = new ArrayList<BackStackRecord>();
                //}
                //int index = mBackStackIndices.size();
                //if (DEBUG) Log.v(TAG, "Setting back stack index " + index + " to " + bse);
                //mBackStackIndices.add(bse);
                //return index;
            //} else {
                //int index = mAvailBackStackIndices.remove(mAvailBackStackIndices.size()-1);
                //if (DEBUG) Log.v(TAG, "Adding back stack index " + index + " with " + bse);
                //mBackStackIndices.set(index, bse);
                //return index;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.797 -0400", hash_original_method = "F0AF804A23A686630C8F5E2012EB99F7", hash_generated_method = "BB82F6659B50C856F45207C56FE9321A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setBackStackIndex(int index, BackStackRecord bse) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(bse.dsTaint);
        {
            {
                mBackStackIndices = new ArrayList<BackStackRecord>();
            } //End block
            int N;
            N = mBackStackIndices.size();
            {
                mBackStackIndices.set(index, bse);
            } //End block
            {
                {
                    mBackStackIndices.add(null);
                    {
                        mAvailBackStackIndices = new ArrayList<Integer>();
                    } //End block
                    mAvailBackStackIndices.add(N);
                } //End block
                mBackStackIndices.add(bse);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.797 -0400", hash_original_method = "A75FE5CB17552EA725360407924677A5", hash_generated_method = "6191E2A10771B8E6696AA3EB12AC33D2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void freeBackStackIndex(int index) {
        dsTaint.addTaint(index);
        {
            mBackStackIndices.set(index, null);
            {
                mAvailBackStackIndices = new ArrayList<Integer>();
            } //End block
            mAvailBackStackIndices.add(index);
        } //End block
        // ---------- Original Method ----------
        //synchronized (this) {
            //mBackStackIndices.set(index, null);
            //if (mAvailBackStackIndices == null) {
                //mAvailBackStackIndices = new ArrayList<Integer>();
            //}
            //if (DEBUG) Log.v(TAG, "Freeing back stack index " + index);
            //mAvailBackStackIndices.add(index);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.798 -0400", hash_original_method = "2EC9B9D8ABC4926EA1F7FF85BE00D458", hash_generated_method = "363C575005C32BF018F89E4DE79D0FCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean execPendingActions() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Recursive entry to executePendingTransactions");
        } //End block
        {
            boolean var92CCD900C583B95C908C1457DCFC97EB_1210126266 = (Looper.myLooper() != mActivity.mHandler.getLooper());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Must be called from main thread of process");
            } //End block
        } //End collapsed parenthetic
        boolean didSomething;
        didSomething = false;
        {
            int numActions;
            {
                {
                    boolean var8F64D3B59DFFB1D978D9FFAE1E7D437D_152119518 = (mPendingActions == null || mPendingActions.size() == 0);
                } //End collapsed parenthetic
                numActions = mPendingActions.size();
                {
                    mTmpActions = new Runnable[numActions];
                } //End block
                mPendingActions.toArray(mTmpActions);
                mPendingActions.clear();
                mActivity.mHandler.removeCallbacks(mExecCommit);
            } //End block
            mExecutingActions = true;
            {
                int i;
                i = 0;
                {
                    mTmpActions[i].run();
                    mTmpActions[i] = null;
                } //End block
            } //End collapsed parenthetic
            mExecutingActions = false;
            didSomething = true;
        } //End block
        {
            boolean loadersRunning;
            loadersRunning = false;
            {
                int i;
                i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_15188640 = (i<mActive.size());
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                mHavePendingDeferredStart = false;
                startPendingDeferredFragments();
            } //End block
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.799 -0400", hash_original_method = "480CA24D6CDDA51ECD1DFDE903041169", hash_generated_method = "4581440CA40D5EE5C3CA7C6D9215C996")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void reportBackStackChanged() {
        {
            {
                int i;
                i = 0;
                boolean var3737AEDF4226FD639F6461E15393E309_1915771331 = (i<mBackStackChangeListeners.size());
                {
                    mBackStackChangeListeners.get(i).onBackStackChanged();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mBackStackChangeListeners != null) {
            //for (int i=0; i<mBackStackChangeListeners.size(); i++) {
                //mBackStackChangeListeners.get(i).onBackStackChanged();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.800 -0400", hash_original_method = "93C61FA561A07CB0E9B057A7A904C282", hash_generated_method = "43C1A73D6717EAA95867510D95B611F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void addBackStackState(BackStackRecord state) {
        dsTaint.addTaint(state.dsTaint);
        {
            mBackStack = new ArrayList<BackStackRecord>();
        } //End block
        mBackStack.add(state);
        reportBackStackChanged();
        // ---------- Original Method ----------
        //if (mBackStack == null) {
            //mBackStack = new ArrayList<BackStackRecord>();
        //}
        //mBackStack.add(state);
        //reportBackStackChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.801 -0400", hash_original_method = "2DCA4D0949EEA78B53FF55FD7B1EE1F8", hash_generated_method = "E2308617AA588FAA8B20140A8513BEC4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     boolean popBackStackState(Handler handler, String name, int id, int flags) {
        dsTaint.addTaint(id);
        dsTaint.addTaint(flags);
        dsTaint.addTaint(name);
        dsTaint.addTaint(handler.dsTaint);
        {
            int last;
            last = mBackStack.size()-1;
            BackStackRecord bss;
            bss = mBackStack.remove(last);
            bss.popFromBackStack(true);
            reportBackStackChanged();
        } //End block
        {
            int index;
            index = -1;
            {
                index = mBackStack.size()-1;
                {
                    BackStackRecord bss;
                    bss = mBackStack.get(index);
                    {
                        boolean varBEA6676FD08F9A893EB03C8E97D94F9C_227705942 = (name != null && name.equals(bss.getName()));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        BackStackRecord bss;
                        bss = mBackStack.get(index);
                        {
                            boolean varF7B12DD1A8F871B2F43DC36592D3ADBE_197609087 = ((name != null && name.equals(bss.getName()))
                                || (id >= 0 && id == bss.mIndex));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
            {
                boolean var4A958E5CC0AD80F8568B9E8089EACA0B_1628596211 = (index == mBackStack.size()-1);
            } //End collapsed parenthetic
            ArrayList<BackStackRecord> states;
            states = new ArrayList<BackStackRecord>();
            {
                int i;
                i = mBackStack.size()-1;
                {
                    states.add(mBackStack.remove(i));
                } //End block
            } //End collapsed parenthetic
            int LAST;
            LAST = states.size()-1;
            {
                int i;
                i = 0;
                {
                    states.get(i).popFromBackStack(i == LAST);
                } //End block
            } //End collapsed parenthetic
            reportBackStackChanged();
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.802 -0400", hash_original_method = "C4579656BDDD252D61818FF4E8F19896", hash_generated_method = "1E6B2AE8290637C3B315865448B1404F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     ArrayList<Fragment> retainNonConfig() {
        ArrayList<Fragment> fragments;
        fragments = null;
        {
            {
                int i;
                i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_1139615808 = (i<mActive.size());
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        {
                            fragments = new ArrayList<Fragment>();
                        } //End block
                        fragments.add(f);
                        f.mRetaining = true;
                        f.mTargetIndex = f.mTarget != null ? f.mTarget.mIndex : -1;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return (ArrayList<Fragment>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ArrayList<Fragment> fragments = null;
        //if (mActive != null) {
            //for (int i=0; i<mActive.size(); i++) {
                //Fragment f = mActive.get(i);
                //if (f != null && f.mRetainInstance) {
                    //if (fragments == null) {
                        //fragments = new ArrayList<Fragment>();
                    //}
                    //fragments.add(f);
                    //f.mRetaining = true;
                    //f.mTargetIndex = f.mTarget != null ? f.mTarget.mIndex : -1;
                //}
            //}
        //}
        //return fragments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.802 -0400", hash_original_method = "90803A489E5220D7765DFCAE4FAFF7AC", hash_generated_method = "62913F0D95FFBE2BA1BFC090E7354DF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void saveFragmentViewState(Fragment f) {
        dsTaint.addTaint(f.dsTaint);
        {
            mStateArray = new SparseArray<Parcelable>();
        } //End block
        {
            mStateArray.clear();
        } //End block
        f.mView.saveHierarchyState(mStateArray);
        {
            boolean var10CB5DFFB182D477A1F1C08C2A2A4D10_542022970 = (mStateArray.size() > 0);
            {
                f.mSavedViewState = mStateArray;
                mStateArray = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (f.mView == null) {
            //return;
        //}
        //if (mStateArray == null) {
            //mStateArray = new SparseArray<Parcelable>();
        //} else {
            //mStateArray.clear();
        //}
        //f.mView.saveHierarchyState(mStateArray);
        //if (mStateArray.size() > 0) {
            //f.mSavedViewState = mStateArray;
            //mStateArray = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.803 -0400", hash_original_method = "DCA5B6BB14B617A2A3ED4183EF745130", hash_generated_method = "415A1369D97C1AC9C77AE458F82EFB49")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Bundle saveFragmentBasicState(Fragment f) {
        dsTaint.addTaint(f.dsTaint);
        Bundle result;
        result = null;
        {
            mStateBundle = new Bundle();
        } //End block
        f.onSaveInstanceState(mStateBundle);
        {
            boolean var5AE1326457CED87C792B211942E81B2E_195192458 = (!mStateBundle.isEmpty());
            {
                result = mStateBundle;
                mStateBundle = null;
            } //End block
        } //End collapsed parenthetic
        {
            saveFragmentViewState(f);
        } //End block
        {
            {
                result = new Bundle();
            } //End block
            result.putSparseParcelableArray(
                    FragmentManagerImpl.VIEW_STATE_TAG, f.mSavedViewState);
        } //End block
        {
            result.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, f.mUserVisibleHint);
        } //End block
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Bundle result = null;
        //if (mStateBundle == null) {
            //mStateBundle = new Bundle();
        //}
        //f.onSaveInstanceState(mStateBundle);
        //if (!mStateBundle.isEmpty()) {
            //result = mStateBundle;
            //mStateBundle = null;
        //}
        //if (f.mView != null) {
            //saveFragmentViewState(f);
        //}
        //if (f.mSavedViewState != null) {
            //if (result == null) {
                //result = new Bundle();
            //}
            //result.putSparseParcelableArray(
                    //FragmentManagerImpl.VIEW_STATE_TAG, f.mSavedViewState);
        //}
        //if (!f.mUserVisibleHint) {
            //result.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, f.mUserVisibleHint);
        //}
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.804 -0400", hash_original_method = "5A6DADDDEE90F93280222EE0F5B508C8", hash_generated_method = "2C46765CE215BAC886211ED7A793E740")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Parcelable saveAllState() {
        execPendingActions();
        mStateSaved = true;
        {
            boolean var7B1A0FE06CC77C5BE5C8EE27C706FD90_1433402816 = (mActive == null || mActive.size() <= 0);
        } //End collapsed parenthetic
        int N;
        N = mActive.size();
        FragmentState[] active;
        active = new FragmentState[N];
        boolean haveFragments;
        haveFragments = false;
        {
            int i;
            i = 0;
            {
                Fragment f;
                f = mActive.get(i);
                {
                    haveFragments = true;
                    FragmentState fs;
                    fs = new FragmentState(f);
                    active[i] = fs;
                    {
                        fs.mSavedFragmentState = saveFragmentBasicState(f);
                        {
                            {
                                String msg;
                                msg = "Failure saving state: " + f
                                + " has target not in fragment manager: " + f.mTarget;
                                dump("  ", null, new PrintWriter(new LogWriter(
                                    Log.ERROR, TAG, Log.LOG_ID_SYSTEM)), new String[] { });
                                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(msg);
                            } //End block
                            {
                                fs.mSavedFragmentState = new Bundle();
                            } //End block
                            putFragment(fs.mSavedFragmentState,
                                FragmentManagerImpl.TARGET_STATE_TAG, f.mTarget);
                            {
                                fs.mSavedFragmentState.putInt(
                                    FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG,
                                    f.mTargetRequestCode);
                            } //End block
                        } //End block
                    } //End block
                    {
                        fs.mSavedFragmentState = f.mSavedFragmentState;
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        int[] added;
        added = null;
        BackStackState[] backStack;
        backStack = null;
        {
            N = mAdded.size();
            {
                added = new int[N];
                {
                    int i;
                    i = 0;
                    {
                        added[i] = mAdded.get(i).mIndex;
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        {
            N = mBackStack.size();
            {
                backStack = new BackStackState[N];
                {
                    int i;
                    i = 0;
                    {
                        backStack[i] = new BackStackState(this, mBackStack.get(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        FragmentManagerState fms;
        fms = new FragmentManagerState();
        fms.mActive = active;
        fms.mAdded = added;
        fms.mBackStack = backStack;
        return (Parcelable)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.808 -0400", hash_original_method = "CDDD12666FB804E6E56655D62533D556", hash_generated_method = "F5116B2F2BE9D86F67B92B75388D1E13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void restoreAllState(Parcelable state, ArrayList<Fragment> nonConfig) {
        dsTaint.addTaint(state.dsTaint);
        dsTaint.addTaint(nonConfig.dsTaint);
        FragmentManagerState fms;
        fms = (FragmentManagerState)state;
        {
            {
                int i;
                i = 0;
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_1736079258 = (i<nonConfig.size());
                {
                    Fragment f;
                    f = nonConfig.get(i);
                    FragmentState fs;
                    fs = fms.mActive[f.mIndex];
                    fs.mInstance = f;
                    f.mSavedViewState = null;
                    f.mBackStackNesting = 0;
                    f.mInLayout = false;
                    f.mAdded = false;
                    f.mTarget = null;
                    {
                        fs.mSavedFragmentState.setClassLoader(mActivity.getClassLoader());
                        f.mSavedViewState = fs.mSavedFragmentState.getSparseParcelableArray(
                            FragmentManagerImpl.VIEW_STATE_TAG);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        mActive = new ArrayList<Fragment>(fms.mActive.length);
        {
            mAvailIndices.clear();
        } //End block
        {
            int i;
            i = 0;
            {
                FragmentState fs;
                fs = fms.mActive[i];
                {
                    Fragment f;
                    f = fs.instantiate(mActivity);
                    mActive.add(f);
                    fs.mInstance = null;
                } //End block
                {
                    mActive.add(null);
                    {
                        mAvailIndices = new ArrayList<Integer>();
                    } //End block
                    mAvailIndices.add(i);
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                int i;
                i = 0;
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_147970640 = (i<nonConfig.size());
                {
                    Fragment f;
                    f = nonConfig.get(i);
                    {
                        {
                            boolean var487621A5D4BD2ACED481B16F5F5948D3_60796171 = (f.mTargetIndex < mActive.size());
                            {
                                f.mTarget = mActive.get(f.mTargetIndex);
                            } //End block
                            {
                                f.mTarget = null;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mAdded = new ArrayList<Fragment>(fms.mAdded.length);
            {
                int i;
                i = 0;
                {
                    Fragment f;
                    f = mActive.get(fms.mAdded[i]);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                            "No instantiated fragment for index #" + fms.mAdded[i]);
                    } //End block
                    f.mAdded = true;
                    mAdded.add(f);
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mAdded = null;
        } //End block
        {
            mBackStack = new ArrayList<BackStackRecord>(fms.mBackStack.length);
            {
                int i;
                i = 0;
                {
                    BackStackRecord bse;
                    bse = fms.mBackStack[i].instantiate(this);
                    mBackStack.add(bse);
                    {
                        setBackStackIndex(bse.mIndex, bse);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            mBackStack = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.808 -0400", hash_original_method = "1A90D3789635EF8BA5063E635EAF56EA", hash_generated_method = "B9BDF5C4A2C206B88CAEF787AB19E55F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void attachActivity(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        // ---------- Original Method ----------
        //if (mActivity != null) throw new IllegalStateException();
        //mActivity = activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.809 -0400", hash_original_method = "9E4E3FCA42BDE19CBF71140223B4B8D0", hash_generated_method = "B5C7E72CCEE273A62746EE3408615591")
    @DSModeled(DSC.SAFE)
    public void noteStateNotSaved() {
        mStateSaved = false;
        // ---------- Original Method ----------
        //mStateSaved = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.809 -0400", hash_original_method = "4EAFC4D017ED2B44474902CD00BD047E", hash_generated_method = "21C3627E95BE86042A719066A2913EA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchCreate() {
        mStateSaved = false;
        moveToState(Fragment.CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.810 -0400", hash_original_method = "BB3D6B45374259B5EE70270EF5FFE721", hash_generated_method = "1F7202ED50DB7895525D3D5DD1A85A9D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(Fragment.ACTIVITY_CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.ACTIVITY_CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.810 -0400", hash_original_method = "145C9AF81AEB697CB534D8E0C0F599A0", hash_generated_method = "20844DC4E325108731D69AD369D5CB9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchStart() {
        mStateSaved = false;
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.810 -0400", hash_original_method = "35325401D14378833F40C78A6FC3DC5D", hash_generated_method = "9E4D22D120F9A6B67EA4BB2B4DEB3341")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchResume() {
        mStateSaved = false;
        moveToState(Fragment.RESUMED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.RESUMED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.811 -0400", hash_original_method = "E6EE1A1408209BDB9066272C26AA9863", hash_generated_method = "806CEF702E5812DC1949A4F8EE32F575")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchPause() {
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.811 -0400", hash_original_method = "AF2E4C7CBE2D28416278336F31B9AFFC", hash_generated_method = "C441D21E31BC8B8A9609B8D4D6E7ECAA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchStop() {
        moveToState(Fragment.STOPPED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.STOPPED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.811 -0400", hash_original_method = "A94A97B8768D84C8034BA8478DD395DC", hash_generated_method = "C5BBDC804266F378AABECFFC198DA3FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchDestroy() {
        mDestroyed = true;
        execPendingActions();
        moveToState(Fragment.INITIALIZING, false);
        mActivity = null;
        // ---------- Original Method ----------
        //mDestroyed = true;
        //execPendingActions();
        //moveToState(Fragment.INITIALIZING, false);
        //mActivity = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.812 -0400", hash_original_method = "5117E19429D94CDE29C750CF70651BE9", hash_generated_method = "D223DBC53DE4E2CCD42C6B0C3605645F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchConfigurationChanged(Configuration newConfig) {
        dsTaint.addTaint(newConfig.dsTaint);
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_709140094 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.onConfigurationChanged(newConfig);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mActive != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null) {
                    //f.onConfigurationChanged(newConfig);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.812 -0400", hash_original_method = "BC8D3EC4480A5918F3A38ABAC82A7ED6", hash_generated_method = "612424A53C539D0036EC665304482C7F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchLowMemory() {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_55546672 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.onLowMemory();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mActive != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null) {
                    //f.onLowMemory();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.813 -0400", hash_original_method = "81FEC8A34B79BC0E01F9FFFE05F1478B", hash_generated_method = "80C752E22BBEF7E1A33C716C3BD152BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchTrimMemory(int level) {
        dsTaint.addTaint(level);
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_26246479 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.onTrimMemory(level);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mActive != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null) {
                    //f.onTrimMemory(level);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.814 -0400", hash_original_method = "059A23578A0DB56C84349E8F783E9AC3", hash_generated_method = "09358B91D69E64A2F2C1C9A99C950579")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(inflater.dsTaint);
        boolean show;
        show = false;
        ArrayList<Fragment> newMenus;
        newMenus = null;
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1384573474 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        show = true;
                        f.onCreateOptionsMenu(menu, inflater);
                        {
                            newMenus = new ArrayList<Fragment>();
                        } //End block
                        newMenus.add(f);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = 0;
                boolean var829574F28570EB1E74183020953B6E4B_2144642068 = (i<mCreatedMenus.size());
                {
                    Fragment f;
                    f = mCreatedMenus.get(i);
                    {
                        boolean varF740BD6A5A57A11B5D73D0A67A04AEFC_823104598 = (newMenus == null || !newMenus.contains(f));
                        {
                            f.onDestroyOptionsMenu();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        mCreatedMenus = newMenus;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.814 -0400", hash_original_method = "3C4E4DD19A75168CEF9873DFBC1B4179", hash_generated_method = "DF97420B0F227EA1350FEACF2A5F0928")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        dsTaint.addTaint(menu.dsTaint);
        boolean show;
        show = false;
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_925035669 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        show = true;
                        f.onPrepareOptionsMenu(menu);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean show = false;
        //if (mActive != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible) {
                    //show = true;
                    //f.onPrepareOptionsMenu(menu);
                //}
            //}
        //}
        //return show;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.815 -0400", hash_original_method = "16456DF238276E24923F6AD552304983", hash_generated_method = "1A4B25E62086838F7AC392A15C82DCB8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchOptionsItemSelected(MenuItem item) {
        dsTaint.addTaint(item.dsTaint);
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_415913719 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        {
                            boolean varE78EB04814153BF35CF96C1AE499F5B5_1985141210 = (f.onOptionsItemSelected(item));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActive != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible) {
                    //if (f.onOptionsItemSelected(item)) {
                        //return true;
                    //}
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.815 -0400", hash_original_method = "F1ECF21855715BC93D4867D907434D91", hash_generated_method = "6F6CC7705785BDB2B3733264FB016B1E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean dispatchContextItemSelected(MenuItem item) {
        dsTaint.addTaint(item.dsTaint);
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_485838831 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        {
                            boolean var48F0CD0D37FBD8298C20892C7FC62FDA_228842249 = (f.onContextItemSelected(item));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (mActive != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null && !f.mHidden) {
                    //if (f.onContextItemSelected(item)) {
                        //return true;
                    //}
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.816 -0400", hash_original_method = "EA4F9A660842285D75622DB2DA97E1AE", hash_generated_method = "419458BF75FFA9A75D68BA6F451180A8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dispatchOptionsMenuClosed(Menu menu) {
        dsTaint.addTaint(menu.dsTaint);
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1394858162 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.onOptionsMenuClosed(menu);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mActive != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible) {
                    //f.onOptionsMenuClosed(menu);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.816 -0400", hash_original_method = "5756D303078CA095AB87E344CED6E29B", hash_generated_method = "548106A013399E869E8B72F313E0BDD1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void invalidateOptionsMenu() {
        {
            mActivity.invalidateOptionsMenu();
        } //End block
        {
            mNeedMenuInvalidate = true;
        } //End block
        // ---------- Original Method ----------
        //if (mActivity != null && mCurState == Fragment.RESUMED) {
            //mActivity.invalidateOptionsMenu();
        //} else {
            //mNeedMenuInvalidate = true;
        //}
    }

    
        public static int reverseTransit(int transit) {
        int rev = 0;
        switch (transit) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                rev = FragmentTransaction.TRANSIT_FRAGMENT_CLOSE;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                rev = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                rev = FragmentTransaction.TRANSIT_FRAGMENT_FADE;
                break;
        }
        return rev;
    }

    
        public static int transitToStyleIndex(int transit, boolean enter) {
        int animAttr = -1;
        switch (transit) {
            case FragmentTransaction.TRANSIT_FRAGMENT_OPEN:
                animAttr = enter
                    ? com.android.internal.R.styleable.FragmentAnimation_fragmentOpenEnterAnimation
                    : com.android.internal.R.styleable.FragmentAnimation_fragmentOpenExitAnimation;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                animAttr = enter
                    ? com.android.internal.R.styleable.FragmentAnimation_fragmentCloseEnterAnimation
                    : com.android.internal.R.styleable.FragmentAnimation_fragmentCloseExitAnimation;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                animAttr = enter
                    ? com.android.internal.R.styleable.FragmentAnimation_fragmentFadeEnterAnimation
                    : com.android.internal.R.styleable.FragmentAnimation_fragmentFadeExitAnimation;
                break;
        }
        return animAttr;
    }

    
    static boolean DEBUG = false;
    static final String TAG = "FragmentManager";
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    static final String TARGET_STATE_TAG = "android:target_state";
    static final String VIEW_STATE_TAG = "android:view_state";
    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
}

