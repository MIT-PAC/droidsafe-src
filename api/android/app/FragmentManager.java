package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.606 -0400", hash_original_method = "0D3FEDE97BC3242ED64134E1F014EA11", hash_generated_method = "0D3FEDE97BC3242ED64134E1F014EA11")
    public FragmentManager ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public abstract FragmentTransaction beginTransaction();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.607 -0400", hash_original_method = "0DA67415D41DB3C4C9D7AB80CD2D78FE", hash_generated_method = "473D9BD0AF2AD982CF0C2A03A9BEE39E")
    @Deprecated
    public FragmentTransaction openTransaction() {
FragmentTransaction var0C52C1DD23EDCBCDDE04269B6A21160A_1066549475 =         beginTransaction();
        var0C52C1DD23EDCBCDDE04269B6A21160A_1066549475.addTaint(taint);
        return var0C52C1DD23EDCBCDDE04269B6A21160A_1066549475;
        // ---------- Original Method ----------
        //return beginTransaction();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract boolean executePendingTransactions();

    
    @DSModeled(DSC.SAFE)
    public abstract Fragment findFragmentById(int id);

    
    @DSModeled(DSC.SAFE)
    public abstract Fragment findFragmentByTag(String tag);

    
    @DSModeled(DSC.SAFE)
    public abstract void popBackStack();

    
    @DSModeled(DSC.SAFE)
    public abstract boolean popBackStackImmediate();

    
    @DSModeled(DSC.SAFE)
    public abstract void popBackStack(String name, int flags);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean popBackStackImmediate(String name, int flags);

    
    @DSModeled(DSC.SAFE)
    public abstract void popBackStack(int id, int flags);

    
    @DSModeled(DSC.SAFE)
    public abstract boolean popBackStackImmediate(int id, int flags);

    
    @DSModeled(DSC.SAFE)
    public abstract int getBackStackEntryCount();

    
    @DSModeled(DSC.SAFE)
    public abstract BackStackEntry getBackStackEntryAt(int index);

    
    @DSModeled(DSC.SAFE)
    public abstract void addOnBackStackChangedListener(OnBackStackChangedListener listener);

    
    @DSModeled(DSC.SAFE)
    public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener listener);

    
    @DSModeled(DSC.SAFE)
    public abstract void putFragment(Bundle bundle, String key, Fragment fragment);

    
    @DSModeled(DSC.SAFE)
    public abstract Fragment getFragment(Bundle bundle, String key);

    
    @DSModeled(DSC.SAFE)
    public abstract Fragment.SavedState saveFragmentInstanceState(Fragment f);

    
    @DSModeled(DSC.SAFE)
    public abstract void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args);

    
    @DSModeled(DSC.SAFE)
    public static void enableDebugLogging(boolean enabled) {
        FragmentManagerImpl.DEBUG = enabled;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.611 -0400", hash_original_method = "15ED404039200ACA8749491C77846D3D", hash_generated_method = "DBB7CD62A7EC5E14380DEAAF62A330E3")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.611 -0400", hash_original_field = "F2813E5BD6A379A2985E370BE1887EDA", hash_generated_field = "3F74866CBC8F49655F2B8BB97CC17F5E")

    public static final int POP_BACK_STACK_INCLUSIVE = 1<<0;
}

final class FragmentManagerState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.612 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "0C91046A014C3ABDDA41BA020BEE7D35")

    FragmentState[] mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.612 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "4D5C3ED026B5D0195A6077AFCD696836")

    int[] mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.612 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "EEA20C5C67D270067553BCDE313A7B27")

    BackStackState[] mBackStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.612 -0400", hash_original_method = "4ADB2DBBD6899E89144480A7958A6490", hash_generated_method = "252DFEAE0ECB79838960A8B564DE42F6")
    public  FragmentManagerState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.616 -0400", hash_original_method = "020574327F1D57965B67553DD6F7D979", hash_generated_method = "F858C24C16C6DB16663BD3817D53ADD9")
    public  FragmentManagerState(Parcel in) {
        mActive = in.createTypedArray(FragmentState.CREATOR);
        mAdded = in.createIntArray();
        mBackStack = in.createTypedArray(BackStackState.CREATOR);
        // ---------- Original Method ----------
        //mActive = in.createTypedArray(FragmentState.CREATOR);
        //mAdded = in.createIntArray();
        //mBackStack = in.createTypedArray(BackStackState.CREATOR);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.617 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0455E06BE524E87771CE7CA07BDB645D")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2113898603 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802992585 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1802992585;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.618 -0400", hash_original_method = "B6654BF7A24842DC15E6AD3A5F27203C", hash_generated_method = "47E7D112A1A5E715EE53E5F5D06C9F8F")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeTypedArray(mActive, flags);
        dest.writeIntArray(mAdded);
        dest.writeTypedArray(mBackStack, flags);
        // ---------- Original Method ----------
        //dest.writeTypedArray(mActive, flags);
        //dest.writeIntArray(mAdded);
        //dest.writeTypedArray(mBackStack, flags);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.618 -0400", hash_original_field = "D29AA2723BAE7915447DC2F30F3AAA56", hash_generated_field = "EE9672AF4023C35BB0D72B0356E5DA5C")

    public static final Parcelable.Creator<FragmentManagerState> CREATOR
            = new Parcelable.Creator<FragmentManagerState>() {
        public FragmentManagerState createFromParcel(Parcel in) {
            return new FragmentManagerState(in);
        }
        
        public FragmentManagerState[] newArray(int size) {
            return new FragmentManagerState[size];
        }
    };
    // orphaned legacy method
    public FragmentManagerState createFromParcel(Parcel in) {
            return new FragmentManagerState(in);
        }
    
    // orphaned legacy method
    public FragmentManagerState[] newArray(int size) {
            return new FragmentManagerState[size];
        }
    
}

final class FragmentManagerImpl extends FragmentManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.620 -0400", hash_original_field = "327C9FAD23CE4030098BE2DE91837CF7", hash_generated_field = "11FD18D208B09E922FC03FBF68E7335B")

    ArrayList<Runnable> mPendingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.620 -0400", hash_original_field = "E3843751CB2154B155E225749A18D620", hash_generated_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3")

    Runnable[] mTmpActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.620 -0400", hash_original_field = "CDD41116A3EE1465C2308845599CA08D", hash_generated_field = "CD4485F6F525738DAA0EA0DC245911AB")

    boolean mExecutingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.620 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "A1650882FA43FC001601740ED87DBA1F")

    ArrayList<Fragment> mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.620 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "FF37605B8D813171195C0EBF92B2A116")

    ArrayList<Fragment> mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.620 -0400", hash_original_field = "CD7D957830B65DDE14B44534836CDCFA", hash_generated_field = "5441838D07CA3D72A0FE3BB98FAAC33E")

    ArrayList<Integer> mAvailIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.621 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "A66A7C10189C949E8CDC007D4D07280E")

    ArrayList<BackStackRecord> mBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.621 -0400", hash_original_field = "07EBA043D3FF90523B37550E5D9B91E4", hash_generated_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7")

    ArrayList<Fragment> mCreatedMenus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.621 -0400", hash_original_field = "A06EFC21545AC26226ABF57556E73291", hash_generated_field = "89571A39B2AB736200FBD57A213BDB4D")

    ArrayList<BackStackRecord> mBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.621 -0400", hash_original_field = "A96F62FC59DD2FAE4327C1E7855AE979", hash_generated_field = "27AED91E8586753C6865FA558A4716C8")

    ArrayList<Integer> mAvailBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.621 -0400", hash_original_field = "D0295B7D6BE1788760CAFE41F824D774", hash_generated_field = "078DA2C7CA0D4289F90F664D0B3EDB3B")

    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.622 -0400", hash_original_field = "C81B2F53A65D169421FFBC0C3AC986EE", hash_generated_field = "9521C64640071A41BA8B18982DEC3BE2")

    int mCurState = Fragment.INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.622 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.622 -0400", hash_original_field = "1ED82791F588E1B933718ECC0041EE63", hash_generated_field = "19DD0E42F9FC244F37062274E8F2012D")

    boolean mNeedMenuInvalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.622 -0400", hash_original_field = "5C1552B132EB06695090E74F8854ED21", hash_generated_field = "E68067DB35DA8BD96BFB5C858DBE74BF")

    boolean mStateSaved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.622 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

    boolean mDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.622 -0400", hash_original_field = "1ECE9D4CB2FBE961BEE64D8760E25D34", hash_generated_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE")

    String mNoTransactionsBecause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.622 -0400", hash_original_field = "20E894967D971C1F65FB2EA61F367BAE", hash_generated_field = "79BC4D349D09DCA85692E9FAD9D9C6F7")

    boolean mHavePendingDeferredStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.622 -0400", hash_original_field = "D0B68049F76228FB1A7F03664CE569DE", hash_generated_field = "92A56B8032395A53760143DE797F97FA")

    Bundle mStateBundle = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.623 -0400", hash_original_field = "EA03FEC1D1BDCAB5D2BD8A3D0ADCF67E", hash_generated_field = "280BE7FE9228C6CA67328AF4B4B28047")

    SparseArray<Parcelable> mStateArray = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.328 -0400", hash_original_field = "BB4C35BD7F2BC82D3F4C38422B568E9B", hash_generated_field = "E35D464208931599FA6E66C3119300C4")

    Runnable mExecCommit = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_method = "C2BA1C69EB0B4CCFF1A319535DB79508", hash_generated_method = "FEDC918E58215E12D8175F59CA2BA6B4")
        @Override
        public void run() {
            execPendingActions();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.623 -0400", hash_original_method = "57A648A59831AB7BB1637AFC6125C81E", hash_generated_method = "57A648A59831AB7BB1637AFC6125C81E")
    public FragmentManagerImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.624 -0400", hash_original_method = "FD4DF6D1DA8CD9545895F43FA5CF7B0B", hash_generated_method = "677D827A6D266A8B12450BF6ABCC4139")
    @Override
    public FragmentTransaction beginTransaction() {
FragmentTransaction var693A23640A091F7A17064797B040A100_74342500 =         new BackStackRecord(this);
        var693A23640A091F7A17064797B040A100_74342500.addTaint(taint);
        return var693A23640A091F7A17064797B040A100_74342500;
        // ---------- Original Method ----------
        //return new BackStackRecord(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.625 -0400", hash_original_method = "082964FFA3913D960E19EEB76BD9505B", hash_generated_method = "20C92141C8F20FE30CC1B0D9B6705BAF")
    @Override
    public boolean executePendingTransactions() {
        boolean var4856074EF8DA58D94BE6E89BEEA5036C_1400592506 = (execPendingActions());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_486980476 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_486980476;
        // ---------- Original Method ----------
        //return execPendingActions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.626 -0400", hash_original_method = "5CB88371A39240A7C2FB2F2041C5DD0D", hash_generated_method = "E7FDEBCE3B02ADD5DE51623FB74EC8CA")
    @Override
    public void popBackStack() {
        enqueueAction(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.626 -0400", hash_original_method = "C15C9D80C4BF4FB6B2AF0B93A4449441", hash_generated_method = "B3F70B584C16FE3B98A16E26008D78C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.626 -0400", hash_original_method = "B7072E2D8E1B8CAC03251D641D234641", hash_generated_method = "9A6D9AC319E820E31FA03FF399740505")
    @Override
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        boolean var9954826F15E8D28E4DBF1B5D9A7FCE6F_2014623110 = (popBackStackState(mActivity.mHandler, null, -1, 0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_705605592 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_705605592;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, null, -1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.628 -0400", hash_original_method = "9E86D2BA46D98A91B2D43097CFA7F639", hash_generated_method = "7C9B72AECD81CF2249C98605D4FADED1")
    @Override
    public void popBackStack(final String name, final int flags) {
        addTaint(flags);
        addTaint(name.getTaint());
        enqueueAction(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.627 -0400", hash_original_method = "22FC8A6DB6B4AB9E651D01E64BEED72A", hash_generated_method = "3FE29178F98A070A5E0ED21762A74700")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.628 -0400", hash_original_method = "4DEC43188CEAB5FA4EF2839673649ECC", hash_generated_method = "9B9797E4B6DD58DD4B44B8DEEE5C78E9")
    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        addTaint(flags);
        addTaint(name.getTaint());
        checkStateLoss();
        executePendingTransactions();
        boolean varA92FEAD33A189EAD0299E8FE391444CD_12796103 = (popBackStackState(mActivity.mHandler, name, -1, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1865991604 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1865991604;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, name, -1, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.630 -0400", hash_original_method = "DA57C1B5DA7DBD65A6FF7556F6C0B827", hash_generated_method = "59E96AD31C7538C60254112B234AF445")
    @Override
    public void popBackStack(final int id, final int flags) {
        addTaint(flags);
        addTaint(id);
        if(id < 0)        
        {
            IllegalArgumentException var9E36F4D6900BCA3CCA42D845F29CB5B0_888134530 = new IllegalArgumentException("Bad id: " + id);
            var9E36F4D6900BCA3CCA42D845F29CB5B0_888134530.addTaint(taint);
            throw var9E36F4D6900BCA3CCA42D845F29CB5B0_888134530;
        } //End block
        enqueueAction(new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.629 -0400", hash_original_method = "DBCE7037D51EB5153CDA373E6D392F0E", hash_generated_method = "905DCE3DB8D6804FD0D561A3F3EB2065")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.630 -0400", hash_original_method = "C28CBCAD3FA2084F032C85B006AF0CA6", hash_generated_method = "F32635E664BE70DA761912A539DE9B84")
    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        addTaint(flags);
        addTaint(id);
        checkStateLoss();
        executePendingTransactions();
        if(id < 0)        
        {
            IllegalArgumentException var9E36F4D6900BCA3CCA42D845F29CB5B0_522090609 = new IllegalArgumentException("Bad id: " + id);
            var9E36F4D6900BCA3CCA42D845F29CB5B0_522090609.addTaint(taint);
            throw var9E36F4D6900BCA3CCA42D845F29CB5B0_522090609;
        } //End block
        boolean varDBA39B5EE3A31103A5F0342C6B326731_725343283 = (popBackStackState(mActivity.mHandler, null, id, flags));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_82129750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_82129750;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //if (id < 0) {
            //throw new IllegalArgumentException("Bad id: " + id);
        //}
        //return popBackStackState(mActivity.mHandler, null, id, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.631 -0400", hash_original_method = "81448DC3AD62196301F3A4A762AB09A8", hash_generated_method = "2BA7DE2208129788716CB3F3C0B78ADC")
    @Override
    public int getBackStackEntryCount() {
        int var6DAE2CE6A7F553D663688107A90FA4CC_965932068 = (mBackStack != null ? mBackStack.size() : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1156490304 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1156490304;
        // ---------- Original Method ----------
        //return mBackStack != null ? mBackStack.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.639 -0400", hash_original_method = "898A7E40DF942FAA7422F0070AE7C2C0", hash_generated_method = "8FF12C5FBEB494CB0E8B5647E6F9C026")
    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        addTaint(index);
BackStackEntry var74F933A734514BD5EE40CF9077B41749_1793411911 =         mBackStack.get(index);
        var74F933A734514BD5EE40CF9077B41749_1793411911.addTaint(taint);
        return var74F933A734514BD5EE40CF9077B41749_1793411911;
        // ---------- Original Method ----------
        //return mBackStack.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.639 -0400", hash_original_method = "5B02C223CD8F1AC3632AF80A3BE5FAF1", hash_generated_method = "F3449B7B6237A3D0492048F76360807C")
    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        addTaint(listener.getTaint());
        if(mBackStackChangeListeners == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.640 -0400", hash_original_method = "0EB71E2FD8D5B96EE15FDFA4CFDC7A3A", hash_generated_method = "61303AE4BE82E0861B28C3954E733BCB")
    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        addTaint(listener.getTaint());
        if(mBackStackChangeListeners != null)        
        {
            mBackStackChangeListeners.remove(listener);
        } //End block
        // ---------- Original Method ----------
        //if (mBackStackChangeListeners != null) {
            //mBackStackChangeListeners.remove(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.640 -0400", hash_original_method = "28A5058460B6EF16DD9CEE59F403CB5D", hash_generated_method = "D8305445F413B21EFF2D5FADF863AEDD")
    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        addTaint(fragment.getTaint());
        addTaint(key.getTaint());
        addTaint(bundle.getTaint());
        if(fragment.mIndex < 0)        
        {
            IllegalStateException var7B5E405E5306E3613D283869376F9163_928229558 = new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
            var7B5E405E5306E3613D283869376F9163_928229558.addTaint(taint);
            throw var7B5E405E5306E3613D283869376F9163_928229558;
        } //End block
        bundle.putInt(key, fragment.mIndex);
        // ---------- Original Method ----------
        //if (fragment.mIndex < 0) {
            //throw new IllegalStateException("Fragment " + fragment
                    //+ " is not currently in the FragmentManager");
        //}
        //bundle.putInt(key, fragment.mIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.640 -0400", hash_original_method = "D08899B1EE8437F622E0D7F7BA40A91F", hash_generated_method = "EAFEB96A85E1FD0001F83B902FC970E2")
    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        addTaint(key.getTaint());
        addTaint(bundle.getTaint());
        int index = bundle.getInt(key, -1);
        if(index == -1)        
        {
Fragment var540C13E9E156B687226421B24F2DF178_669097237 =             null;
            var540C13E9E156B687226421B24F2DF178_669097237.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_669097237;
        } //End block
        if(index >= mActive.size())        
        {
            IllegalStateException var6B58AEB9BDB699058A25F6FBB7F2A67B_1450680103 = new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index);
            var6B58AEB9BDB699058A25F6FBB7F2A67B_1450680103.addTaint(taint);
            throw var6B58AEB9BDB699058A25F6FBB7F2A67B_1450680103;
        } //End block
        Fragment f = mActive.get(index);
        if(f == null)        
        {
            IllegalStateException var6B58AEB9BDB699058A25F6FBB7F2A67B_1895369728 = new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index);
            var6B58AEB9BDB699058A25F6FBB7F2A67B_1895369728.addTaint(taint);
            throw var6B58AEB9BDB699058A25F6FBB7F2A67B_1895369728;
        } //End block
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_1106328228 =         f;
        varABE3CFB53FE4A79F34CB25BC80BFD6E2_1106328228.addTaint(taint);
        return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1106328228;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.641 -0400", hash_original_method = "CF6272FD6214D7D7484637054FD9E74F", hash_generated_method = "0510F6F1F60C51012F7FE36DE2C8929C")
    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        addTaint(fragment.getTaint());
        if(fragment.mIndex < 0)        
        {
            IllegalStateException var7B5E405E5306E3613D283869376F9163_550194103 = new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
            var7B5E405E5306E3613D283869376F9163_550194103.addTaint(taint);
            throw var7B5E405E5306E3613D283869376F9163_550194103;
        } //End block
        if(fragment.mState > Fragment.INITIALIZING)        
        {
            Bundle result = saveFragmentBasicState(fragment);
Fragment.SavedState varDF3960AB579B5B5C742EF8D42A1CE853_763702391 =             result != null ? new Fragment.SavedState(result) : null;
            varDF3960AB579B5B5C742EF8D42A1CE853_763702391.addTaint(taint);
            return varDF3960AB579B5B5C742EF8D42A1CE853_763702391;
        } //End block
Fragment.SavedState var540C13E9E156B687226421B24F2DF178_936546756 =         null;
        var540C13E9E156B687226421B24F2DF178_936546756.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_936546756;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.641 -0400", hash_original_method = "A7D5B4266978FAAC75BAC34E53BDC41B", hash_generated_method = "0361C55B99E87AD4488175D10EE3CF64")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
String var2460B846747F8B22185AD8BE722266A5_1320543241 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1320543241.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1320543241;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("FragmentManager{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(" in ");
        //DebugUtils.buildShortClassTag(mActivity, sb);
        //sb.append("}}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.643 -0400", hash_original_method = "0EF991BB6A19DFA56B66936C5498080A", hash_generated_method = "8EEEBB4ED378B8D4B41B20E1D5B100AD")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
        String innerPrefix = prefix + "    ";
        int N;
        if(mActive != null)        
        {
            N = mActive.size();
            if(N > 0)            
            {
                writer.print(prefix);
                writer.print("Active Fragments in ");
                writer.print(Integer.toHexString(System.identityHashCode(this)));
                writer.println(":");
for(int i=0;i<N;i++)
                {
                    Fragment f = mActive.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f);
                    if(f != null)                    
                    {
                        f.dump(innerPrefix, fd, writer, args);
                    } //End block
                } //End block
            } //End block
        } //End block
        if(mAdded != null)        
        {
            N = mAdded.size();
            if(N > 0)            
            {
                writer.print(prefix);
                writer.println("Added Fragments:");
for(int i=0;i<N;i++)
                {
                    Fragment f = mAdded.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f.toString());
                } //End block
            } //End block
        } //End block
        if(mCreatedMenus != null)        
        {
            N = mCreatedMenus.size();
            if(N > 0)            
            {
                writer.print(prefix);
                writer.println("Fragments Created Menus:");
for(int i=0;i<N;i++)
                {
                    Fragment f = mCreatedMenus.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(f.toString());
                } //End block
            } //End block
        } //End block
        if(mBackStack != null)        
        {
            N = mBackStack.size();
            if(N > 0)            
            {
                writer.print(prefix);
                writer.println("Back Stack:");
for(int i=0;i<N;i++)
                {
                    BackStackRecord bs = mBackStack.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(bs.toString());
                    bs.dump(innerPrefix, fd, writer, args);
                } //End block
            } //End block
        } //End block
        synchronized
(this)        {
            if(mBackStackIndices != null)            
            {
                N = mBackStackIndices.size();
                if(N > 0)                
                {
                    writer.print(prefix);
                    writer.println("Back Stack Indices:");
for(int i=0;i<N;i++)
                    {
                        BackStackRecord bs = mBackStackIndices.get(i);
                        writer.print(prefix);
                        writer.print("  #");
                        writer.print(i);
                        writer.print(": ");
                        writer.println(bs);
                    } //End block
                } //End block
            } //End block
            if(mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0)            
            {
                writer.print(prefix);
                writer.print("mAvailBackStackIndices: ");
                writer.println(Arrays.toString(mAvailBackStackIndices.toArray()));
            } //End block
        } //End block
        if(mPendingActions != null)        
        {
            N = mPendingActions.size();
            if(N > 0)            
            {
                writer.print(prefix);
                writer.println("Pending Actions:");
for(int i=0;i<N;i++)
                {
                    Runnable r = mPendingActions.get(i);
                    writer.print(prefix);
                    writer.print("  #");
                    writer.print(i);
                    writer.print(": ");
                    writer.println(r);
                } //End block
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
        if(mNeedMenuInvalidate)        
        {
            writer.print(prefix);
            writer.print("  mNeedMenuInvalidate=");
            writer.println(mNeedMenuInvalidate);
        } //End block
        if(mNoTransactionsBecause != null)        
        {
            writer.print(prefix);
            writer.print("  mNoTransactionsBecause=");
            writer.println(mNoTransactionsBecause);
        } //End block
        if(mAvailIndices != null && mAvailIndices.size() > 0)        
        {
            writer.print(prefix);
            writer.print("  mAvailIndices: ");
            writer.println(Arrays.toString(mAvailIndices.toArray()));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.644 -0400", hash_original_method = "8FB9E657DCE437B207C489B8932863BA", hash_generated_method = "18EC499430BBD37DB6D1BA24E3F3F6F7")
     Animator loadAnimator(Fragment fragment, int transit, boolean enter,
            int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(enter);
        addTaint(transit);
        addTaint(fragment.getTaint());
        Animator animObj = fragment.onCreateAnimator(transit, enter,
                fragment.mNextAnim);
        if(animObj != null)        
        {
Animator varD2C3244304F8F6616E0E174A4084F820_1165621081 =             animObj;
            varD2C3244304F8F6616E0E174A4084F820_1165621081.addTaint(taint);
            return varD2C3244304F8F6616E0E174A4084F820_1165621081;
        } //End block
        if(fragment.mNextAnim != 0)        
        {
            Animator anim = AnimatorInflater.loadAnimator(mActivity, fragment.mNextAnim);
            if(anim != null)            
            {
Animator var6E2178F33F884BED37C5DEBCD18F9A96_1931660027 =                 anim;
                var6E2178F33F884BED37C5DEBCD18F9A96_1931660027.addTaint(taint);
                return var6E2178F33F884BED37C5DEBCD18F9A96_1931660027;
            } //End block
        } //End block
        if(transit == 0)        
        {
Animator var540C13E9E156B687226421B24F2DF178_928027260 =             null;
            var540C13E9E156B687226421B24F2DF178_928027260.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_928027260;
        } //End block
        int styleIndex = transitToStyleIndex(transit, enter);
        if(styleIndex < 0)        
        {
Animator var540C13E9E156B687226421B24F2DF178_1121489835 =             null;
            var540C13E9E156B687226421B24F2DF178_1121489835.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1121489835;
        } //End block
        if(transitionStyle == 0 && mActivity.getWindow() != null)        
        {
            transitionStyle = mActivity.getWindow().getAttributes().windowAnimations;
        } //End block
        if(transitionStyle == 0)        
        {
Animator var540C13E9E156B687226421B24F2DF178_1631145136 =             null;
            var540C13E9E156B687226421B24F2DF178_1631145136.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1631145136;
        } //End block
        TypedArray attrs = mActivity.obtainStyledAttributes(transitionStyle,
                com.android.internal.R.styleable.FragmentAnimation);
        int anim = attrs.getResourceId(styleIndex, 0);
        attrs.recycle();
        if(anim == 0)        
        {
Animator var540C13E9E156B687226421B24F2DF178_692574661 =             null;
            var540C13E9E156B687226421B24F2DF178_692574661.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_692574661;
        } //End block
Animator varC35B10EB16A065F611B9B0A64CB84395_10492370 =         AnimatorInflater.loadAnimator(mActivity, anim);
        varC35B10EB16A065F611B9B0A64CB84395_10492370.addTaint(taint);
        return varC35B10EB16A065F611B9B0A64CB84395_10492370;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.644 -0400", hash_original_method = "BB58D6FD0DD6E4462529DBFA77E71E10", hash_generated_method = "A9DB7A21A692F90CDDB3B78BC4818F23")
    public void performPendingDeferredStart(Fragment f) {
        addTaint(f.getTaint());
        if(f.mDeferStart)        
        {
            if(mExecutingActions)            
            {
                mHavePendingDeferredStart = true;
                return;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.650 -0400", hash_original_method = "EE92853A739004991ACA465267191DB6", hash_generated_method = "58D333F274C152A4FE282A740040F414")
     void moveToState(Fragment f, int newState, int transit, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transit);
        addTaint(newState);
        if(!f.mAdded && newState > Fragment.CREATED)        
        {
            newState = Fragment.CREATED;
        } //End block
        if(f.mRemoving && newState > f.mState)        
        {
            newState = f.mState;
        } //End block
        if(f.mDeferStart && f.mState < Fragment.STARTED && newState > Fragment.STOPPED)        
        {
            newState = Fragment.STOPPED;
        } //End block
        if(f.mState < newState)        
        {
            if(f.mFromLayout && !f.mInLayout)            
            {
                return;
            } //End block
            if(f.mAnimatingAway != null)            
            {
                f.mAnimatingAway = null;
                moveToState(f, f.mStateAfterAnimating, 0, 0);
            } //End block
switch(f.mState){
            case Fragment.INITIALIZING:
            if(DEBUG){ }            if(f.mSavedFragmentState != null)            
            {
                f.mSavedViewState = f.mSavedFragmentState.getSparseParcelableArray(
                                FragmentManagerImpl.VIEW_STATE_TAG);
                f.mTarget = getFragment(f.mSavedFragmentState,
                                FragmentManagerImpl.TARGET_STATE_TAG);
                if(f.mTarget != null)                
                {
                    f.mTargetRequestCode = f.mSavedFragmentState.getInt(
                                    FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG, 0);
                } //End block
                f.mUserVisibleHint = f.mSavedFragmentState.getBoolean(
                                FragmentManagerImpl.USER_VISIBLE_HINT_TAG, true);
                if(!f.mUserVisibleHint)                
                {
                    f.mDeferStart = true;
                    if(newState > Fragment.STOPPED)                    
                    {
                        newState = Fragment.STOPPED;
                    } //End block
                } //End block
            } //End block
            f.mActivity = mActivity;
            f.mFragmentManager = mActivity.mFragments;
            f.mCalled = false;
            f.onAttach(mActivity);
            if(!f.mCalled)            
            {
                SuperNotCalledException var3B21D72FE3B78DA21309B053881BE5E5_238902641 = new SuperNotCalledException("Fragment " + f
                                + " did not call through to super.onAttach()");
                var3B21D72FE3B78DA21309B053881BE5E5_238902641.addTaint(taint);
                throw var3B21D72FE3B78DA21309B053881BE5E5_238902641;
            } //End block
            mActivity.onAttachFragment(f);
            if(!f.mRetaining)            
            {
                f.mCalled = false;
                f.onCreate(f.mSavedFragmentState);
                if(!f.mCalled)                
                {
                    SuperNotCalledException varDCB548427EBCECA4CC9F6862AC507FF3_12691253 = new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onCreate()");
                    varDCB548427EBCECA4CC9F6862AC507FF3_12691253.addTaint(taint);
                    throw varDCB548427EBCECA4CC9F6862AC507FF3_12691253;
                } //End block
            } //End block
            f.mRetaining = false;
            if(f.mFromLayout)            
            {
                f.mView = f.onCreateView(f.getLayoutInflater(f.mSavedFragmentState),
                                null, f.mSavedFragmentState);
                if(f.mView != null)                
                {
                    f.mView.setSaveFromParentEnabled(false);
                    if(f.mHidden)                    
                    f.mView.setVisibility(View.GONE);
                    f.onViewCreated(f.mView, f.mSavedFragmentState);
                } //End block
            } //End block
            case Fragment.CREATED:
            if(newState > Fragment.CREATED)            
            {
                if(DEBUG){ }                if(!f.mFromLayout)                
                {
                    ViewGroup container = null;
                    if(f.mContainerId != 0)                    
                    {
                        container = (ViewGroup)mActivity.findViewById(f.mContainerId);
                        if(container == null && !f.mRestored)                        
                        {
                            IllegalArgumentException var0353385A08CCE5D7465C38B4F1D7C17E_442916768 = new IllegalArgumentException("No view found for id 0x"
                                            + Integer.toHexString(f.mContainerId)
                                            + " for fragment " + f);
                            var0353385A08CCE5D7465C38B4F1D7C17E_442916768.addTaint(taint);
                            throw var0353385A08CCE5D7465C38B4F1D7C17E_442916768;
                        } //End block
                    } //End block
                    f.mContainer = container;
                    f.mView = f.onCreateView(f.getLayoutInflater(f.mSavedFragmentState),
                                    container, f.mSavedFragmentState);
                    if(f.mView != null)                    
                    {
                        f.mView.setSaveFromParentEnabled(false);
                        if(container != null)                        
                        {
                            Animator anim = loadAnimator(f, transit, true,
                                            transitionStyle);
                            if(anim != null)                            
                            {
                                anim.setTarget(f.mView);
                                anim.start();
                            } //End block
                            container.addView(f.mView);
                        } //End block
                        if(f.mHidden)                        
                        f.mView.setVisibility(View.GONE);
                        f.onViewCreated(f.mView, f.mSavedFragmentState);
                    } //End block
                } //End block
                f.mCalled = false;
                f.onActivityCreated(f.mSavedFragmentState);
                if(!f.mCalled)                
                {
                    SuperNotCalledException var45C194242DE43412EAC556A63F1E43D7_462847951 = new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onActivityCreated()");
                    var45C194242DE43412EAC556A63F1E43D7_462847951.addTaint(taint);
                    throw var45C194242DE43412EAC556A63F1E43D7_462847951;
                } //End block
                if(f.mView != null)                
                {
                    f.restoreViewState();
                } //End block
                f.mSavedFragmentState = null;
            } //End block
            case Fragment.ACTIVITY_CREATED:
            case Fragment.STOPPED:
            if(newState > Fragment.STOPPED)            
            {
                if(DEBUG){ }                f.mCalled = false;
                f.performStart();
                if(!f.mCalled)                
                {
                    SuperNotCalledException varF07429FD2D04E52714B8713F40AFC9DD_1672170067 = new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onStart()");
                    varF07429FD2D04E52714B8713F40AFC9DD_1672170067.addTaint(taint);
                    throw varF07429FD2D04E52714B8713F40AFC9DD_1672170067;
                } //End block
            } //End block
            case Fragment.STARTED:
            if(newState > Fragment.STARTED)            
            {
                if(DEBUG){ }                f.mCalled = false;
                f.mResumed = true;
                f.onResume();
                if(!f.mCalled)                
                {
                    SuperNotCalledException var2F03BD78E4921B7BE5C850B804B95C39_1948517605 = new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onResume()");
                    var2F03BD78E4921B7BE5C850B804B95C39_1948517605.addTaint(taint);
                    throw var2F03BD78E4921B7BE5C850B804B95C39_1948517605;
                } //End block
                f.mSavedFragmentState = null;
                f.mSavedViewState = null;
            } //End block
}
        } //End block
        else
        if(f.mState > newState)        
        {
switch(f.mState){
            case Fragment.RESUMED:
            if(newState < Fragment.RESUMED)            
            {
                if(DEBUG){ }                f.mCalled = false;
                f.onPause();
                if(!f.mCalled)                
                {
                    SuperNotCalledException var55DB580FC19CB339D914E96405A6FFDF_1507103059 = new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onPause()");
                    var55DB580FC19CB339D914E96405A6FFDF_1507103059.addTaint(taint);
                    throw var55DB580FC19CB339D914E96405A6FFDF_1507103059;
                } //End block
                f.mResumed = false;
            } //End block
            case Fragment.STARTED:
            if(newState < Fragment.STARTED)            
            {
                if(DEBUG){ }                f.mCalled = false;
                f.performStop();
                if(!f.mCalled)                
                {
                    SuperNotCalledException var240380EDA5D49D36DA90F7CBC00728AE_1059908555 = new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onStop()");
                    var240380EDA5D49D36DA90F7CBC00728AE_1059908555.addTaint(taint);
                    throw var240380EDA5D49D36DA90F7CBC00728AE_1059908555;
                } //End block
            } //End block
            case Fragment.STOPPED:
            case Fragment.ACTIVITY_CREATED:
            if(newState < Fragment.ACTIVITY_CREATED)            
            {
                if(DEBUG){ }                if(f.mView != null)                
                {
                    if(!mActivity.isFinishing() && f.mSavedViewState == null)                    
                    {
                        saveFragmentViewState(f);
                    } //End block
                } //End block
                f.mCalled = false;
                f.performDestroyView();
                if(!f.mCalled)                
                {
                    SuperNotCalledException var7FE18600505ECC477FD177AC364738B8_970899931 = new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onDestroyView()");
                    var7FE18600505ECC477FD177AC364738B8_970899931.addTaint(taint);
                    throw var7FE18600505ECC477FD177AC364738B8_970899931;
                } //End block
                if(f.mView != null && f.mContainer != null)                
                {
                    Animator anim = null;
                    if(mCurState > Fragment.INITIALIZING && !mDestroyed)                    
                    {
                        anim = loadAnimator(f, transit, false,
                                        transitionStyle);
                    } //End block
                    if(anim != null)                    
                    {
                        final ViewGroup container = f.mContainer;
                        final View view = f.mView;
                        final Fragment fragment = f;
                        container.startViewTransition(view);
                        f.mAnimatingAway = anim;
                        f.mStateAfterAnimating = newState;
                        anim.addListener(new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.649 -0400", hash_original_method = "9D8EA3EF50700F2206500D8F97DFE625", hash_generated_method = "F98049BF17DC3CF1A936A8C90F9DB5ED")
        @Override
        public void onAnimationEnd(Animator anim) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(anim.getTaint());
            container.endViewTransition(view);
            if(fragment.mAnimatingAway != null)            
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
            case Fragment.CREATED:
            if(newState < Fragment.CREATED)            
            {
                if(mDestroyed)                
                {
                    if(f.mAnimatingAway != null)                    
                    {
                        Animator anim = f.mAnimatingAway;
                        f.mAnimatingAway = null;
                        anim.cancel();
                    } //End block
                } //End block
                if(f.mAnimatingAway != null)                
                {
                    f.mStateAfterAnimating = newState;
                    newState = Fragment.CREATED;
                } //End block
                else
                {
                    if(DEBUG){ }                    if(!f.mRetaining)                    
                    {
                        f.mCalled = false;
                        f.onDestroy();
                        if(!f.mCalled)                        
                        {
                            SuperNotCalledException var996818535D410BFCADDBA6185941AB67_1303038861 = new SuperNotCalledException("Fragment " + f
                                            + " did not call through to super.onDestroy()");
                            var996818535D410BFCADDBA6185941AB67_1303038861.addTaint(taint);
                            throw var996818535D410BFCADDBA6185941AB67_1303038861;
                        } //End block
                    } //End block
                    f.mCalled = false;
                    f.onDetach();
                    if(!f.mCalled)                    
                    {
                        SuperNotCalledException varA1E86A4AD3397A3A1F40BAC562CFC4E0_1331780739 = new SuperNotCalledException("Fragment " + f
                                        + " did not call through to super.onDetach()");
                        varA1E86A4AD3397A3A1F40BAC562CFC4E0_1331780739.addTaint(taint);
                        throw varA1E86A4AD3397A3A1F40BAC562CFC4E0_1331780739;
                    } //End block
                    if(!f.mRetaining)                    
                    {
                        makeInactive(f);
                    } //End block
                    else
                    {
                        f.mActivity = null;
                        f.mFragmentManager = null;
                    } //End block
                } //End block
            } //End block
}
        } //End block
        f.mState = newState;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.651 -0400", hash_original_method = "8CD289FFBEE11A8449DF6C5CC9F9ABBD", hash_generated_method = "D34879424FD6E5535F6944A8155F4D79")
     void moveToState(Fragment f) {
        addTaint(f.getTaint());
        moveToState(f, mCurState, 0, 0);
        // ---------- Original Method ----------
        //moveToState(f, mCurState, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.651 -0400", hash_original_method = "4A2DC4C23578532593EF5B01DCA60326", hash_generated_method = "53B9318E7A6D27AF1F540337F095D441")
     void moveToState(int newState, boolean always) {
        addTaint(always);
        addTaint(newState);
        moveToState(newState, 0, 0, always);
        // ---------- Original Method ----------
        //moveToState(newState, 0, 0, always);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.652 -0400", hash_original_method = "EC27B7DF943700174166429595B46255", hash_generated_method = "4016D9DF912D019CAE9697EFD12463A3")
     void moveToState(int newState, int transit, int transitStyle, boolean always) {
        addTaint(always);
        addTaint(transitStyle);
        addTaint(transit);
        if(mActivity == null && newState != Fragment.INITIALIZING)        
        {
            IllegalStateException varC7A3C53EE722E6B94E737EE4538375FA_1648282581 = new IllegalStateException("No activity");
            varC7A3C53EE722E6B94E737EE4538375FA_1648282581.addTaint(taint);
            throw varC7A3C53EE722E6B94E737EE4538375FA_1648282581;
        } //End block
        if(!always && mCurState == newState)        
        {
            return;
        } //End block
        mCurState = newState;
        if(mActive != null)        
        {
            boolean loadersRunning = false;
for(int i=0;i<mActive.size();i++)
            {
                Fragment f = mActive.get(i);
                if(f != null)                
                {
                    moveToState(f, newState, transit, transitStyle);
                    if(f.mLoaderManager != null)                    
                    {
                        loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                    } //End block
                } //End block
            } //End block
            if(!loadersRunning)            
            {
                startPendingDeferredFragments();
            } //End block
            if(mNeedMenuInvalidate && mActivity != null && mCurState == Fragment.RESUMED)            
            {
                mActivity.invalidateOptionsMenu();
                mNeedMenuInvalidate = false;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.652 -0400", hash_original_method = "CCAA4C21D5B5313253593374D7FC1754", hash_generated_method = "DA1D2CEA990D2C426A9BF529124CB3B6")
     void startPendingDeferredFragments() {
        if(mActive == null)        
        return;
for(int i=0;i<mActive.size();i++)
        {
            Fragment f = mActive.get(i);
            if(f != null)            
            {
                performPendingDeferredStart(f);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mActive == null) return;
        //for (int i=0; i<mActive.size(); i++) {
            //Fragment f = mActive.get(i);
            //if (f != null) {
                //performPendingDeferredStart(f);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.653 -0400", hash_original_method = "D50E4D1CE651B3B8515ED7A1E81CB61B", hash_generated_method = "945C587618F70182EAE668E3F5BADE47")
     void makeActive(Fragment f) {
        addTaint(f.getTaint());
        if(f.mIndex >= 0)        
        {
            return;
        } //End block
        if(mAvailIndices == null || mAvailIndices.size() <= 0)        
        {
            if(mActive == null)            
            {
                mActive = new ArrayList<Fragment>();
            } //End block
            f.setIndex(mActive.size());
            mActive.add(f);
        } //End block
        else
        {
            f.setIndex(mAvailIndices.remove(mAvailIndices.size()-1));
            mActive.set(f.mIndex, f);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.653 -0400", hash_original_method = "21A9491D104F42D1B78CA5222CCDF2B0", hash_generated_method = "D66849BA2606698D479212FDE55861D9")
     void makeInactive(Fragment f) {
        addTaint(f.getTaint());
        if(f.mIndex < 0)        
        {
            return;
        } //End block
        if(DEBUG){ }        mActive.set(f.mIndex, null);
        if(mAvailIndices == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.654 -0400", hash_original_method = "39A4C55EF4B2F4D7AD9F69C21FC91745", hash_generated_method = "040AD9C0104395D167DC3D3D199DCA8E")
    public void addFragment(Fragment fragment, boolean moveToStateNow) {
        addTaint(moveToStateNow);
        if(mAdded == null)        
        {
            mAdded = new ArrayList<Fragment>();
        } //End block
        if(DEBUG){ }        makeActive(fragment);
        if(!fragment.mDetached)        
        {
            mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if(fragment.mHasMenu && fragment.mMenuVisible)            
            {
                mNeedMenuInvalidate = true;
            } //End block
            if(moveToStateNow)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.655 -0400", hash_original_method = "47129A78A86358373557A8CBE26A47CF", hash_generated_method = "AA83381A1ECD3E7CA0D5AC073949C2EB")
    public void removeFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
        if(DEBUG){ }        final boolean inactive = !fragment.isInBackStack();
        if(!fragment.mDetached || inactive)        
        {
            mAdded.remove(fragment);
            if(fragment.mHasMenu && fragment.mMenuVisible)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.656 -0400", hash_original_method = "066049DB7DB3E7A9AEFB54490F59C652", hash_generated_method = "27F2569BA54EB3CB1FC527671FBCE191")
    public void hideFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
        addTaint(fragment.getTaint());
        if(DEBUG){ }        if(!fragment.mHidden)        
        {
            fragment.mHidden = true;
            if(fragment.mView != null)            
            {
                Animator anim = loadAnimator(fragment, transition, true,
                        transitionStyle);
                if(anim != null)                
                {
                    anim.setTarget(fragment.mView);
                    final Fragment finalFragment = fragment;
                    anim.addListener(new AnimatorListenerAdapter() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.655 -0400", hash_original_method = "FE6C0F24C850190D502A7783FD2F34FA", hash_generated_method = "9F66710E4025C8ED7E86A5AD00DC4DC7")
        @Override
        public void onAnimationEnd(Animator animation) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(animation.getTaint());
            if(finalFragment.mView != null)            
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
                else
                {
                    fragment.mView.setVisibility(View.GONE);
                } //End block
            } //End block
            if(fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)            
            {
                mNeedMenuInvalidate = true;
            } //End block
            fragment.onHiddenChanged(true);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.656 -0400", hash_original_method = "DD64B7390BAEF5796124974048F6770D", hash_generated_method = "C7437A71644CBC40E3BF4BC0905C3FC4")
    public void showFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
        addTaint(fragment.getTaint());
        if(DEBUG){ }        if(fragment.mHidden)        
        {
            fragment.mHidden = false;
            if(fragment.mView != null)            
            {
                Animator anim = loadAnimator(fragment, transition, true,
                        transitionStyle);
                if(anim != null)                
                {
                    anim.setTarget(fragment.mView);
                    anim.start();
                } //End block
                fragment.mView.setVisibility(View.VISIBLE);
            } //End block
            if(fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible)            
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.657 -0400", hash_original_method = "9E4782C1879A41669B298A15D404F278", hash_generated_method = "0B65B603632E9275410C62A3FE1B30C1")
    public void detachFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
        if(DEBUG){ }        if(!fragment.mDetached)        
        {
            fragment.mDetached = true;
            if(fragment.mAdded)            
            {
                mAdded.remove(fragment);
                if(fragment.mHasMenu && fragment.mMenuVisible)                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.658 -0400", hash_original_method = "681D8A8EBC4582B35DF715CE5B5E6679", hash_generated_method = "7AC38C51A369C4A90FEFC961276E9E9A")
    public void attachFragment(Fragment fragment, int transition, int transitionStyle) {
        addTaint(transitionStyle);
        addTaint(transition);
        if(DEBUG){ }        if(fragment.mDetached)        
        {
            fragment.mDetached = false;
            if(!fragment.mAdded)            
            {
                mAdded.add(fragment);
                fragment.mAdded = true;
                if(fragment.mHasMenu && fragment.mMenuVisible)                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.658 -0400", hash_original_method = "846CFE4E6D453F7EB47298FC794E62E7", hash_generated_method = "98BEE188B0E5DEF98FAB70273637B185")
    public Fragment findFragmentById(int id) {
        addTaint(id);
        if(mActive != null)        
        {
for(int i=mAdded.size()-1;i>=0;i--)
            {
                Fragment f = mAdded.get(i);
                if(f != null && f.mFragmentId == id)                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_1365691587 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_1365691587.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1365691587;
                } //End block
            } //End block
for(int i=mActive.size()-1;i>=0;i--)
            {
                Fragment f = mActive.get(i);
                if(f != null && f.mFragmentId == id)                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_1504960841 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_1504960841.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1504960841;
                } //End block
            } //End block
        } //End block
Fragment var540C13E9E156B687226421B24F2DF178_1154003137 =         null;
        var540C13E9E156B687226421B24F2DF178_1154003137.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1154003137;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.659 -0400", hash_original_method = "5F9B0395F726C1A39BFC043E2E96E889", hash_generated_method = "F21C4F3CCCB08078FBCD4FE5F9082F5F")
    public Fragment findFragmentByTag(String tag) {
        addTaint(tag.getTaint());
        if(mActive != null && tag != null)        
        {
for(int i=mAdded.size()-1;i>=0;i--)
            {
                Fragment f = mAdded.get(i);
                if(f != null && tag.equals(f.mTag))                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_1829530081 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_1829530081.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1829530081;
                } //End block
            } //End block
for(int i=mActive.size()-1;i>=0;i--)
            {
                Fragment f = mActive.get(i);
                if(f != null && tag.equals(f.mTag))                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_1164111171 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_1164111171.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_1164111171;
                } //End block
            } //End block
        } //End block
Fragment var540C13E9E156B687226421B24F2DF178_1602529471 =         null;
        var540C13E9E156B687226421B24F2DF178_1602529471.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1602529471;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.660 -0400", hash_original_method = "BBAAD10FC9AB450B3B7E8CD0A108A471", hash_generated_method = "C2BFD65FEAB0196C75025CDF182E1E44")
    public Fragment findFragmentByWho(String who) {
        addTaint(who.getTaint());
        if(mActive != null && who != null)        
        {
for(int i=mActive.size()-1;i>=0;i--)
            {
                Fragment f = mActive.get(i);
                if(f != null && who.equals(f.mWho))                
                {
Fragment varABE3CFB53FE4A79F34CB25BC80BFD6E2_374209196 =                     f;
                    varABE3CFB53FE4A79F34CB25BC80BFD6E2_374209196.addTaint(taint);
                    return varABE3CFB53FE4A79F34CB25BC80BFD6E2_374209196;
                } //End block
            } //End block
        } //End block
Fragment var540C13E9E156B687226421B24F2DF178_1083043815 =         null;
        var540C13E9E156B687226421B24F2DF178_1083043815.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1083043815;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.660 -0400", hash_original_method = "B87B380B690A16EB7F37B7EE1C0A0D26", hash_generated_method = "D489883131C51FCDABE6BA43AD3FE06A")
    private void checkStateLoss() {
        if(mStateSaved)        
        {
            IllegalStateException var23A2D8DE9FCE1D4473820F88EF278183_769980164 = new IllegalStateException(
                    "Can not perform this action after onSaveInstanceState");
            var23A2D8DE9FCE1D4473820F88EF278183_769980164.addTaint(taint);
            throw var23A2D8DE9FCE1D4473820F88EF278183_769980164;
        } //End block
        if(mNoTransactionsBecause != null)        
        {
            IllegalStateException varD5A6267DF986948EB71369DC13B836F0_1432331592 = new IllegalStateException(
                    "Can not perform this action inside of " + mNoTransactionsBecause);
            varD5A6267DF986948EB71369DC13B836F0_1432331592.addTaint(taint);
            throw varD5A6267DF986948EB71369DC13B836F0_1432331592;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.660 -0400", hash_original_method = "32359130EC903AF4E096237D1F067453", hash_generated_method = "6B223BD434F6E2AA5B7684AF1D28693D")
    public void enqueueAction(Runnable action, boolean allowStateLoss) {
        addTaint(allowStateLoss);
        addTaint(action.getTaint());
        if(!allowStateLoss)        
        {
            checkStateLoss();
        } //End block
        synchronized
(this)        {
            if(mActivity == null)            
            {
                IllegalStateException var49610257A997B6EC5B28B22BBA4534E2_94515691 = new IllegalStateException("Activity has been destroyed");
                var49610257A997B6EC5B28B22BBA4534E2_94515691.addTaint(taint);
                throw var49610257A997B6EC5B28B22BBA4534E2_94515691;
            } //End block
            if(mPendingActions == null)            
            {
                mPendingActions = new ArrayList<Runnable>();
            } //End block
            mPendingActions.add(action);
            if(mPendingActions.size() == 1)            
            {
                mActivity.mHandler.removeCallbacks(mExecCommit);
                mActivity.mHandler.post(mExecCommit);
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.661 -0400", hash_original_method = "1503673DA6CC1FF53261337C6A89F6BE", hash_generated_method = "15BC062811EAC40A6CA741461A65A951")
    public int allocBackStackIndex(BackStackRecord bse) {
        addTaint(bse.getTaint());
        synchronized
(this)        {
            if(mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0)            
            {
                if(mBackStackIndices == null)                
                {
                    mBackStackIndices = new ArrayList<BackStackRecord>();
                } //End block
                int index = mBackStackIndices.size();
                if(DEBUG){ }                mBackStackIndices.add(bse);
                int var6A992D5529F459A44FEE58C733255E86_668968151 = (index);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104424156 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1104424156;
            } //End block
            else
            {
                int index = mAvailBackStackIndices.remove(mAvailBackStackIndices.size()-1);
                if(DEBUG){ }                mBackStackIndices.set(index, bse);
                int var6A992D5529F459A44FEE58C733255E86_573285338 = (index);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325844739 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_325844739;
            } //End block
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.662 -0400", hash_original_method = "F0AF804A23A686630C8F5E2012EB99F7", hash_generated_method = "B84519E754B96726FC67860D93265690")
    public void setBackStackIndex(int index, BackStackRecord bse) {
        addTaint(bse.getTaint());
        addTaint(index);
        synchronized
(this)        {
            if(mBackStackIndices == null)            
            {
                mBackStackIndices = new ArrayList<BackStackRecord>();
            } //End block
            int N = mBackStackIndices.size();
            if(index < N)            
            {
                if(DEBUG){ }                mBackStackIndices.set(index, bse);
            } //End block
            else
            {
                while
(N < index)                
                {
                    mBackStackIndices.add(null);
                    if(mAvailBackStackIndices == null)                    
                    {
                        mAvailBackStackIndices = new ArrayList<Integer>();
                    } //End block
                    if(DEBUG){ }                    mAvailBackStackIndices.add(N);
                    N++;
                } //End block
                if(DEBUG){ }                mBackStackIndices.add(bse);
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.663 -0400", hash_original_method = "A75FE5CB17552EA725360407924677A5", hash_generated_method = "BADE6125AC1A3E42ECD0633B6FD273F9")
    public void freeBackStackIndex(int index) {
        addTaint(index);
        synchronized
(this)        {
            mBackStackIndices.set(index, null);
            if(mAvailBackStackIndices == null)            
            {
                mAvailBackStackIndices = new ArrayList<Integer>();
            } //End block
            if(DEBUG){ }            mAvailBackStackIndices.add(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.664 -0400", hash_original_method = "2EC9B9D8ABC4926EA1F7FF85BE00D458", hash_generated_method = "71CCE022E57DE0A8D6CE6BA905EFE59A")
    public boolean execPendingActions() {
        if(mExecutingActions)        
        {
            IllegalStateException var61DF877DA999CC3CF0E0D581264CFF4D_866786301 = new IllegalStateException("Recursive entry to executePendingTransactions");
            var61DF877DA999CC3CF0E0D581264CFF4D_866786301.addTaint(taint);
            throw var61DF877DA999CC3CF0E0D581264CFF4D_866786301;
        } //End block
        if(Looper.myLooper() != mActivity.mHandler.getLooper())        
        {
            IllegalStateException var40716AFC80613C23595006B91BE64761_1723129938 = new IllegalStateException("Must be called from main thread of process");
            var40716AFC80613C23595006B91BE64761_1723129938.addTaint(taint);
            throw var40716AFC80613C23595006B91BE64761_1723129938;
        } //End block
        boolean didSomething = false;
        while
(true)        
        {
            int numActions;
            synchronized
(this)            {
                if(mPendingActions == null || mPendingActions.size() == 0)                
                {
                    break;
                } //End block
                numActions = mPendingActions.size();
                if(mTmpActions == null || mTmpActions.length < numActions)                
                {
                    mTmpActions = new Runnable[numActions];
                } //End block
                mPendingActions.toArray(mTmpActions);
                mPendingActions.clear();
                mActivity.mHandler.removeCallbacks(mExecCommit);
            } //End block
            mExecutingActions = true;
for(int i=0;i<numActions;i++)
            {
                mTmpActions[i].run();
                mTmpActions[i] = null;
            } //End block
            mExecutingActions = false;
            didSomething = true;
        } //End block
        if(mHavePendingDeferredStart)        
        {
            boolean loadersRunning = false;
for(int i=0;i<mActive.size();i++)
            {
                Fragment f = mActive.get(i);
                if(f != null && f.mLoaderManager != null)                
                {
                    loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                } //End block
            } //End block
            if(!loadersRunning)            
            {
                mHavePendingDeferredStart = false;
                startPendingDeferredFragments();
            } //End block
        } //End block
        boolean var5E507AE975F73329F3FD0F0DC8E6DE07_296127680 = (didSomething);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641659352 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_641659352;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.665 -0400", hash_original_method = "480CA24D6CDDA51ECD1DFDE903041169", hash_generated_method = "48F7B93763F7745B9B8D7EDBE4BD21AF")
     void reportBackStackChanged() {
        if(mBackStackChangeListeners != null)        
        {
for(int i=0;i<mBackStackChangeListeners.size();i++)
            {
                mBackStackChangeListeners.get(i).onBackStackChanged();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mBackStackChangeListeners != null) {
            //for (int i=0; i<mBackStackChangeListeners.size(); i++) {
                //mBackStackChangeListeners.get(i).onBackStackChanged();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.666 -0400", hash_original_method = "93C61FA561A07CB0E9B057A7A904C282", hash_generated_method = "F851EE881748A573E0434BC86BF3F067")
     void addBackStackState(BackStackRecord state) {
        addTaint(state.getTaint());
        if(mBackStack == null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.668 -0400", hash_original_method = "2DCA4D0949EEA78B53FF55FD7B1EE1F8", hash_generated_method = "0F8E36D17D0207DFBE08D5671521DA9A")
     boolean popBackStackState(Handler handler, String name, int id, int flags) {
        addTaint(flags);
        addTaint(id);
        addTaint(name.getTaint());
        addTaint(handler.getTaint());
        if(mBackStack == null)        
        {
            boolean var68934A3E9455FA72420237EB05902327_995119664 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_429738013 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_429738013;
        } //End block
        if(name == null && id < 0 && (flags&POP_BACK_STACK_INCLUSIVE) == 0)        
        {
            int last = mBackStack.size()-1;
            if(last < 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_1119846502 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_772560719 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_772560719;
            } //End block
            final BackStackRecord bss = mBackStack.remove(last);
            bss.popFromBackStack(true);
            reportBackStackChanged();
        } //End block
        else
        {
            int index = -1;
            if(name != null || id >= 0)            
            {
                index = mBackStack.size()-1;
                while
(index >= 0)                
                {
                    BackStackRecord bss = mBackStack.get(index);
                    if(name != null && name.equals(bss.getName()))                    
                    {
                        break;
                    } //End block
                    if(id >= 0 && id == bss.mIndex)                    
                    {
                        break;
                    } //End block
                    index--;
                } //End block
                if(index < 0)                
                {
                    boolean var68934A3E9455FA72420237EB05902327_693486965 = (false);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715551830 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715551830;
                } //End block
                if((flags&POP_BACK_STACK_INCLUSIVE) != 0)                
                {
                    index--;
                    while
(index >= 0)                    
                    {
                        BackStackRecord bss = mBackStack.get(index);
                        if((name != null && name.equals(bss.getName()))
                                || (id >= 0 && id == bss.mIndex))                        
                        {
                            index--;
                            continue;
                        } //End block
                        break;
                    } //End block
                } //End block
            } //End block
            if(index == mBackStack.size()-1)            
            {
                boolean var68934A3E9455FA72420237EB05902327_701939606 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1536267590 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1536267590;
            } //End block
            final ArrayList<BackStackRecord> states = new ArrayList<BackStackRecord>();
for(int i=mBackStack.size()-1;i>index;i--)
            {
                states.add(mBackStack.remove(i));
            } //End block
            final int LAST = states.size()-1;
for(int i=0;i<=LAST;i++)
            {
                if(DEBUG){ }                states.get(i).popFromBackStack(i == LAST);
            } //End block
            reportBackStackChanged();
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1948983309 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598087764 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598087764;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.670 -0400", hash_original_method = "C4579656BDDD252D61818FF4E8F19896", hash_generated_method = "F37EEE3D4A983FBF98788A456FBC1F9A")
     ArrayList<Fragment> retainNonConfig() {
        ArrayList<Fragment> fragments = null;
        if(mActive != null)        
        {
for(int i=0;i<mActive.size();i++)
            {
                Fragment f = mActive.get(i);
                if(f != null && f.mRetainInstance)                
                {
                    if(fragments == null)                    
                    {
                        fragments = new ArrayList<Fragment>();
                    } //End block
                    fragments.add(f);
                    f.mRetaining = true;
                    f.mTargetIndex = f.mTarget != null ? f.mTarget.mIndex : -1;
                } //End block
            } //End block
        } //End block
ArrayList<Fragment> varFEBBCC2DAA2DE5E47E180E56AA61ABE9_1308771092 =         fragments;
        varFEBBCC2DAA2DE5E47E180E56AA61ABE9_1308771092.addTaint(taint);
        return varFEBBCC2DAA2DE5E47E180E56AA61ABE9_1308771092;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.671 -0400", hash_original_method = "90803A489E5220D7765DFCAE4FAFF7AC", hash_generated_method = "2A11C837272CE5D0690987C66C1DB64D")
     void saveFragmentViewState(Fragment f) {
        addTaint(f.getTaint());
        if(f.mView == null)        
        {
            return;
        } //End block
        if(mStateArray == null)        
        {
            mStateArray = new SparseArray<Parcelable>();
        } //End block
        else
        {
            mStateArray.clear();
        } //End block
        f.mView.saveHierarchyState(mStateArray);
        if(mStateArray.size() > 0)        
        {
            f.mSavedViewState = mStateArray;
            mStateArray = null;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.671 -0400", hash_original_method = "DCA5B6BB14B617A2A3ED4183EF745130", hash_generated_method = "E28DB04A5B1F9170291C7EF18A9DEBA2")
     Bundle saveFragmentBasicState(Fragment f) {
        addTaint(f.getTaint());
        Bundle result = null;
        if(mStateBundle == null)        
        {
            mStateBundle = new Bundle();
        } //End block
        f.onSaveInstanceState(mStateBundle);
        if(!mStateBundle.isEmpty())        
        {
            result = mStateBundle;
            mStateBundle = null;
        } //End block
        if(f.mView != null)        
        {
            saveFragmentViewState(f);
        } //End block
        if(f.mSavedViewState != null)        
        {
            if(result == null)            
            {
                result = new Bundle();
            } //End block
            result.putSparseParcelableArray(
                    FragmentManagerImpl.VIEW_STATE_TAG, f.mSavedViewState);
        } //End block
        if(!f.mUserVisibleHint)        
        {
            result.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, f.mUserVisibleHint);
        } //End block
Bundle varDC838461EE2FA0CA4C9BBB70A15456B0_288969281 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_288969281.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_288969281;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.673 -0400", hash_original_method = "5A6DADDDEE90F93280222EE0F5B508C8", hash_generated_method = "B8ABCEE3F723B9AC424843F48DA3C687")
     Parcelable saveAllState() {
        execPendingActions();
        mStateSaved = true;
        if(mActive == null || mActive.size() <= 0)        
        {
Parcelable var540C13E9E156B687226421B24F2DF178_1019111250 =             null;
            var540C13E9E156B687226421B24F2DF178_1019111250.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1019111250;
        } //End block
        int N = mActive.size();
        FragmentState[] active = new FragmentState[N];
        boolean haveFragments = false;
for(int i=0;i<N;i++)
        {
            Fragment f = mActive.get(i);
            if(f != null)            
            {
                haveFragments = true;
                FragmentState fs = new FragmentState(f);
                active[i] = fs;
                if(f.mState > Fragment.INITIALIZING && fs.mSavedFragmentState == null)                
                {
                    fs.mSavedFragmentState = saveFragmentBasicState(f);
                    if(f.mTarget != null)                    
                    {
                        if(f.mTarget.mIndex < 0)                        
                        {
                            String msg = "Failure saving state: " + f
                                + " has target not in fragment manager: " + f.mTarget;
                            dump("  ", null, new PrintWriter(new LogWriter(
                                    Log.ERROR, TAG, Log.LOG_ID_SYSTEM)), new String[] { });
                            IllegalStateException var7F2D17CA90B318AA0541B6F6070295DF_2014769821 = new IllegalStateException(msg);
                            var7F2D17CA90B318AA0541B6F6070295DF_2014769821.addTaint(taint);
                            throw var7F2D17CA90B318AA0541B6F6070295DF_2014769821;
                        } //End block
                        if(fs.mSavedFragmentState == null)                        
                        {
                            fs.mSavedFragmentState = new Bundle();
                        } //End block
                        putFragment(fs.mSavedFragmentState,
                                FragmentManagerImpl.TARGET_STATE_TAG, f.mTarget);
                        if(f.mTargetRequestCode != 0)                        
                        {
                            fs.mSavedFragmentState.putInt(
                                    FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG,
                                    f.mTargetRequestCode);
                        } //End block
                    } //End block
                } //End block
                else
                {
                    fs.mSavedFragmentState = f.mSavedFragmentState;
                } //End block
                if(DEBUG){ }
            } //End block
        } //End block
        if(!haveFragments)        
        {
            if(DEBUG){ }Parcelable var540C13E9E156B687226421B24F2DF178_1622839914 =             null;
            var540C13E9E156B687226421B24F2DF178_1622839914.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1622839914;
        } //End block
        int[] added = null;
        BackStackState[] backStack = null;
        if(mAdded != null)        
        {
            N = mAdded.size();
            if(N > 0)            
            {
                added = new int[N];
for(int i=0;i<N;i++)
                {
                    added[i] = mAdded.get(i).mIndex;
                    if(DEBUG){ }
                } //End block
            } //End block
        } //End block
        if(mBackStack != null)        
        {
            N = mBackStack.size();
            if(N > 0)            
            {
                backStack = new BackStackState[N];
for(int i=0;i<N;i++)
                {
                    backStack[i] = new BackStackState(this, mBackStack.get(i));
                    if(DEBUG){ }
                } //End block
            } //End block
        } //End block
        FragmentManagerState fms = new FragmentManagerState();
        fms.mActive = active;
        fms.mAdded = added;
        fms.mBackStack = backStack;
Parcelable var7CFA6661E623A7ACE6CCCD8D42B74674_1485654021 =         fms;
        var7CFA6661E623A7ACE6CCCD8D42B74674_1485654021.addTaint(taint);
        return var7CFA6661E623A7ACE6CCCD8D42B74674_1485654021;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.675 -0400", hash_original_method = "CDDD12666FB804E6E56655D62533D556", hash_generated_method = "19B9C907B61F60138CBDC41ED0BDF0EA")
     void restoreAllState(Parcelable state, ArrayList<Fragment> nonConfig) {
        addTaint(nonConfig.getTaint());
        addTaint(state.getTaint());
        if(state == null)        
        return;
        FragmentManagerState fms = (FragmentManagerState)state;
        if(fms.mActive == null)        
        return;
        if(nonConfig != null)        
        {
for(int i=0;i<nonConfig.size();i++)
            {
                Fragment f = nonConfig.get(i);
                if(DEBUG){ }                FragmentState fs = fms.mActive[f.mIndex];
                fs.mInstance = f;
                f.mSavedViewState = null;
                f.mBackStackNesting = 0;
                f.mInLayout = false;
                f.mAdded = false;
                f.mTarget = null;
                if(fs.mSavedFragmentState != null)                
                {
                    fs.mSavedFragmentState.setClassLoader(mActivity.getClassLoader());
                    f.mSavedViewState = fs.mSavedFragmentState.getSparseParcelableArray(
                            FragmentManagerImpl.VIEW_STATE_TAG);
                } //End block
            } //End block
        } //End block
        mActive = new ArrayList<Fragment>(fms.mActive.length);
        if(mAvailIndices != null)        
        {
            mAvailIndices.clear();
        } //End block
for(int i=0;i<fms.mActive.length;i++)
        {
            FragmentState fs = fms.mActive[i];
            if(fs != null)            
            {
                Fragment f = fs.instantiate(mActivity);
                if(DEBUG){ }                mActive.add(f);
                fs.mInstance = null;
            } //End block
            else
            {
                if(DEBUG){ }                mActive.add(null);
                if(mAvailIndices == null)                
                {
                    mAvailIndices = new ArrayList<Integer>();
                } //End block
                if(DEBUG){ }                mAvailIndices.add(i);
            } //End block
        } //End block
        if(nonConfig != null)        
        {
for(int i=0;i<nonConfig.size();i++)
            {
                Fragment f = nonConfig.get(i);
                if(f.mTargetIndex >= 0)                
                {
                    if(f.mTargetIndex < mActive.size())                    
                    {
                        f.mTarget = mActive.get(f.mTargetIndex);
                    } //End block
                    else
                    {
                        f.mTarget = null;
                    } //End block
                } //End block
            } //End block
        } //End block
        if(fms.mAdded != null)        
        {
            mAdded = new ArrayList<Fragment>(fms.mAdded.length);
for(int i=0;i<fms.mAdded.length;i++)
            {
                Fragment f = mActive.get(fms.mAdded[i]);
                if(f == null)                
                {
                    IllegalStateException varA364CF9D8AEA5F64DE66342D082D9E88_1337175209 = new IllegalStateException(
                            "No instantiated fragment for index #" + fms.mAdded[i]);
                    varA364CF9D8AEA5F64DE66342D082D9E88_1337175209.addTaint(taint);
                    throw varA364CF9D8AEA5F64DE66342D082D9E88_1337175209;
                } //End block
                f.mAdded = true;
                if(DEBUG){ }                mAdded.add(f);
            } //End block
        } //End block
        else
        {
            mAdded = null;
        } //End block
        if(fms.mBackStack != null)        
        {
            mBackStack = new ArrayList<BackStackRecord>(fms.mBackStack.length);
for(int i=0;i<fms.mBackStack.length;i++)
            {
                BackStackRecord bse = fms.mBackStack[i].instantiate(this);
                if(DEBUG){ }                mBackStack.add(bse);
                if(bse.mIndex >= 0)                
                {
                    setBackStackIndex(bse.mIndex, bse);
                } //End block
            } //End block
        } //End block
        else
        {
            mBackStack = null;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.675 -0400", hash_original_method = "1A90D3789635EF8BA5063E635EAF56EA", hash_generated_method = "B8713865BA9FB12F77CC0E5A2B89787D")
    public void attachActivity(Activity activity) {
        if(mActivity != null)        
        {
        IllegalStateException varC311A989A119B96A6232C22ABFE87C25_1781333301 = new IllegalStateException();
        varC311A989A119B96A6232C22ABFE87C25_1781333301.addTaint(taint);
        throw varC311A989A119B96A6232C22ABFE87C25_1781333301;
        }
        mActivity = activity;
        // ---------- Original Method ----------
        //if (mActivity != null) throw new IllegalStateException();
        //mActivity = activity;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.676 -0400", hash_original_method = "9E4E3FCA42BDE19CBF71140223B4B8D0", hash_generated_method = "B5C7E72CCEE273A62746EE3408615591")
    public void noteStateNotSaved() {
        mStateSaved = false;
        // ---------- Original Method ----------
        //mStateSaved = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.676 -0400", hash_original_method = "4EAFC4D017ED2B44474902CD00BD047E", hash_generated_method = "21C3627E95BE86042A719066A2913EA6")
    public void dispatchCreate() {
        mStateSaved = false;
        moveToState(Fragment.CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.676 -0400", hash_original_method = "BB3D6B45374259B5EE70270EF5FFE721", hash_generated_method = "1F7202ED50DB7895525D3D5DD1A85A9D")
    public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(Fragment.ACTIVITY_CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.ACTIVITY_CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.676 -0400", hash_original_method = "145C9AF81AEB697CB534D8E0C0F599A0", hash_generated_method = "20844DC4E325108731D69AD369D5CB9A")
    public void dispatchStart() {
        mStateSaved = false;
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.677 -0400", hash_original_method = "35325401D14378833F40C78A6FC3DC5D", hash_generated_method = "9E4D22D120F9A6B67EA4BB2B4DEB3341")
    public void dispatchResume() {
        mStateSaved = false;
        moveToState(Fragment.RESUMED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.RESUMED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.677 -0400", hash_original_method = "E6EE1A1408209BDB9066272C26AA9863", hash_generated_method = "806CEF702E5812DC1949A4F8EE32F575")
    public void dispatchPause() {
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.677 -0400", hash_original_method = "AF2E4C7CBE2D28416278336F31B9AFFC", hash_generated_method = "C441D21E31BC8B8A9609B8D4D6E7ECAA")
    public void dispatchStop() {
        moveToState(Fragment.STOPPED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.STOPPED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.677 -0400", hash_original_method = "A94A97B8768D84C8034BA8478DD395DC", hash_generated_method = "C5BBDC804266F378AABECFFC198DA3FC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.678 -0400", hash_original_method = "5117E19429D94CDE29C750CF70651BE9", hash_generated_method = "913918AF97C107F4C0F2EC9BB67E1901")
    public void dispatchConfigurationChanged(Configuration newConfig) {
        addTaint(newConfig.getTaint());
        if(mActive != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
                if(f != null)                
                {
                    f.onConfigurationChanged(newConfig);
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.678 -0400", hash_original_method = "BC8D3EC4480A5918F3A38ABAC82A7ED6", hash_generated_method = "4B8CB7ADC37149492438038AC0868F5E")
    public void dispatchLowMemory() {
        if(mActive != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
                if(f != null)                
                {
                    f.onLowMemory();
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.678 -0400", hash_original_method = "81FEC8A34B79BC0E01F9FFFE05F1478B", hash_generated_method = "2E10CAED89954CD5520934CA37E13789")
    public void dispatchTrimMemory(int level) {
        addTaint(level);
        if(mActive != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
                if(f != null)                
                {
                    f.onTrimMemory(level);
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.696 -0400", hash_original_method = "059A23578A0DB56C84349E8F783E9AC3", hash_generated_method = "5886491EB1B0392A05F537CF7D07C699")
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        addTaint(inflater.getTaint());
        addTaint(menu.getTaint());
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
        if(mActive != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
                if(f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible)                
                {
                    show = true;
                    f.onCreateOptionsMenu(menu, inflater);
                    if(newMenus == null)                    
                    {
                        newMenus = new ArrayList<Fragment>();
                    } //End block
                    newMenus.add(f);
                } //End block
            } //End block
        } //End block
        if(mCreatedMenus != null)        
        {
for(int i=0;i<mCreatedMenus.size();i++)
            {
                Fragment f = mCreatedMenus.get(i);
                if(newMenus == null || !newMenus.contains(f))                
                {
                    f.onDestroyOptionsMenu();
                } //End block
            } //End block
        } //End block
        mCreatedMenus = newMenus;
        boolean varA7DD12B1DAB17D25467B0B0A4C8D4A92_820662636 = (show);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1973315502 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1973315502;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.697 -0400", hash_original_method = "3C4E4DD19A75168CEF9873DFBC1B4179", hash_generated_method = "A6555E691BE0AD3EAF0B8AB0F18A325D")
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        addTaint(menu.getTaint());
        boolean show = false;
        if(mActive != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
                if(f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible)                
                {
                    show = true;
                    f.onPrepareOptionsMenu(menu);
                } //End block
            } //End block
        } //End block
        boolean varA7DD12B1DAB17D25467B0B0A4C8D4A92_1430677562 = (show);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1782837104 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1782837104;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.697 -0400", hash_original_method = "16456DF238276E24923F6AD552304983", hash_generated_method = "0563CDAB957FFD91BB86EFD2C996A1FC")
    public boolean dispatchOptionsItemSelected(MenuItem item) {
        addTaint(item.getTaint());
        if(mActive != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
                if(f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible)                
                {
                    if(f.onOptionsItemSelected(item))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_1573534949 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_59540122 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_59540122;
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_28306909 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_613623984 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_613623984;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.698 -0400", hash_original_method = "F1ECF21855715BC93D4867D907434D91", hash_generated_method = "A763FC4173C53DDED7B8C178813FF500")
    public boolean dispatchContextItemSelected(MenuItem item) {
        addTaint(item.getTaint());
        if(mActive != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
                if(f != null && !f.mHidden)                
                {
                    if(f.onContextItemSelected(item))                    
                    {
                        boolean varB326B5062B2F0E69046810717534CB09_742818149 = (true);
                                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2126876488 = getTaintBoolean();
                        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2126876488;
                    } //End block
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_5812788 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_565439342 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_565439342;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.698 -0400", hash_original_method = "EA4F9A660842285D75622DB2DA97E1AE", hash_generated_method = "19D41E911BA0C44C0997E8A93B8363C3")
    public void dispatchOptionsMenuClosed(Menu menu) {
        addTaint(menu.getTaint());
        if(mActive != null)        
        {
for(int i=0;i<mAdded.size();i++)
            {
                Fragment f = mAdded.get(i);
                if(f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible)                
                {
                    f.onOptionsMenuClosed(menu);
                } //End block
            } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.698 -0400", hash_original_method = "5756D303078CA095AB87E344CED6E29B", hash_generated_method = "27A479895EA112C4641DDC6D5CCB4B70")
    @Override
    public void invalidateOptionsMenu() {
        if(mActivity != null && mCurState == Fragment.RESUMED)        
        {
            mActivity.invalidateOptionsMenu();
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.699 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.699 -0400", hash_original_field = "309AAD3E76F171051A35712763096DE8", hash_generated_field = "82CCA249F4AC6A9E8A18392D953FCA5D")

    static final String TAG = "FragmentManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.699 -0400", hash_original_field = "E58DEFB2E4C5F4C4BC898BC35F33C192", hash_generated_field = "3B27731C0E9DDDFC7028C0BFB720297D")

    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.699 -0400", hash_original_field = "A8D8A7593440E0D7D4A8A21F4BCD6D54", hash_generated_field = "9220E2EDA94C70BA7341F1BFB405D6BF")

    static final String TARGET_STATE_TAG = "android:target_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.699 -0400", hash_original_field = "03990A2696101FE20E375C710E3F3AE1", hash_generated_field = "C8F5F7A2B0A3F70631E3897CD07F0E4E")

    static final String VIEW_STATE_TAG = "android:view_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.699 -0400", hash_original_field = "80B57815D7CE7602226A48E51B42D058", hash_generated_field = "43219A21E686E6FEC3DF87B97E67132D")

    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
}

