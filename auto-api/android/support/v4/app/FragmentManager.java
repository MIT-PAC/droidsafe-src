package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.Log;
import android.util.SparseArray;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Animation.AnimationListener;
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.609 -0400", hash_original_method = "0D3FEDE97BC3242ED64134E1F014EA11", hash_generated_method = "0D3FEDE97BC3242ED64134E1F014EA11")
    public FragmentManager ()
    {
        //Synthesized constructor
    }


    public abstract FragmentTransaction beginTransaction();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.610 -0400", hash_original_method = "0DA67415D41DB3C4C9D7AB80CD2D78FE", hash_generated_method = "CAA43B62EC0D543BB67E2E266ADBC9FC")
    @Deprecated
    public FragmentTransaction openTransaction() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1291719090 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1291719090 = beginTransaction();
        varB4EAC82CA7396A68D541C85D26508E83_1291719090.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1291719090;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.630 -0400", hash_original_field = "F2813E5BD6A379A2985E370BE1887EDA", hash_generated_field = "3F74866CBC8F49655F2B8BB97CC17F5E")

    public static final int POP_BACK_STACK_INCLUSIVE = 1<<0;
}

final class FragmentManagerState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.630 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "0C91046A014C3ABDDA41BA020BEE7D35")

    FragmentState[] mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.630 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "4D5C3ED026B5D0195A6077AFCD696836")

    int[] mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.630 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "EEA20C5C67D270067553BCDE313A7B27")

    BackStackState[] mBackStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.642 -0400", hash_original_method = "4ADB2DBBD6899E89144480A7958A6490", hash_generated_method = "252DFEAE0ECB79838960A8B564DE42F6")
    public  FragmentManagerState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.655 -0400", hash_original_method = "020574327F1D57965B67553DD6F7D979", hash_generated_method = "F858C24C16C6DB16663BD3817D53ADD9")
    public  FragmentManagerState(Parcel in) {
        mActive = in.createTypedArray(FragmentState.CREATOR);
        mAdded = in.createIntArray();
        mBackStack = in.createTypedArray(BackStackState.CREATOR);
        // ---------- Original Method ----------
        //mActive = in.createTypedArray(FragmentState.CREATOR);
        //mAdded = in.createIntArray();
        //mBackStack = in.createTypedArray(BackStackState.CREATOR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.655 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "DC154536877924530E828955FA983947")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675104134 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1675104134;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.660 -0400", hash_original_method = "B6654BF7A24842DC15E6AD3A5F27203C", hash_generated_method = "755001DC0FEE505DA71D76177C4F11BA")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(mActive, flags);
        dest.writeIntArray(mAdded);
        dest.writeTypedArray(mBackStack, flags);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeTypedArray(mActive, flags);
        //dest.writeIntArray(mAdded);
        //dest.writeTypedArray(mBackStack, flags);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.660 -0400", hash_original_field = "D29AA2723BAE7915447DC2F30F3AAA56", hash_generated_field = "EE9672AF4023C35BB0D72B0356E5DA5C")

    public static final Parcelable.Creator<FragmentManagerState> CREATOR
            = new Parcelable.Creator<FragmentManagerState>() {
        public FragmentManagerState createFromParcel(Parcel in) {
            return new FragmentManagerState(in);
        }
        
        public FragmentManagerState[] newArray(int size) {
            return new FragmentManagerState[size];
        }
    };
}

interface FragmentContainer {
    public View findViewById(int id);
}
final class FragmentManagerImpl extends FragmentManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "327C9FAD23CE4030098BE2DE91837CF7", hash_generated_field = "11FD18D208B09E922FC03FBF68E7335B")

    ArrayList<Runnable> mPendingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "E3843751CB2154B155E225749A18D620", hash_generated_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3")

    Runnable[] mTmpActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "CDD41116A3EE1465C2308845599CA08D", hash_generated_field = "CD4485F6F525738DAA0EA0DC245911AB")

    boolean mExecutingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "A1650882FA43FC001601740ED87DBA1F")

    ArrayList<Fragment> mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "FF37605B8D813171195C0EBF92B2A116")

    ArrayList<Fragment> mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "CD7D957830B65DDE14B44534836CDCFA", hash_generated_field = "5441838D07CA3D72A0FE3BB98FAAC33E")

    ArrayList<Integer> mAvailIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "A66A7C10189C949E8CDC007D4D07280E")

    ArrayList<BackStackRecord> mBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "07EBA043D3FF90523B37550E5D9B91E4", hash_generated_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7")

    ArrayList<Fragment> mCreatedMenus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "A06EFC21545AC26226ABF57556E73291", hash_generated_field = "89571A39B2AB736200FBD57A213BDB4D")

    ArrayList<BackStackRecord> mBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "A96F62FC59DD2FAE4327C1E7855AE979", hash_generated_field = "27AED91E8586753C6865FA558A4716C8")

    ArrayList<Integer> mAvailBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "D0295B7D6BE1788760CAFE41F824D774", hash_generated_field = "078DA2C7CA0D4289F90F664D0B3EDB3B")

    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "C81B2F53A65D169421FFBC0C3AC986EE", hash_generated_field = "9521C64640071A41BA8B18982DEC3BE2")

    int mCurState = Fragment.INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.662 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "DC6970CAF75184DB6DB1AAC52EA720C0")

    FragmentActivity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.663 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "4716918018B597B9E2482B529B6BAD4A")

    FragmentContainer mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.671 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "D9437984C8B60662ED185FA42AA3938D")

    Fragment mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.671 -0400", hash_original_field = "1ED82791F588E1B933718ECC0041EE63", hash_generated_field = "19DD0E42F9FC244F37062274E8F2012D")

    boolean mNeedMenuInvalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.671 -0400", hash_original_field = "5C1552B132EB06695090E74F8854ED21", hash_generated_field = "E68067DB35DA8BD96BFB5C858DBE74BF")

    boolean mStateSaved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.671 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

    boolean mDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.671 -0400", hash_original_field = "1ECE9D4CB2FBE961BEE64D8760E25D34", hash_generated_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE")

    String mNoTransactionsBecause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.671 -0400", hash_original_field = "20E894967D971C1F65FB2EA61F367BAE", hash_generated_field = "79BC4D349D09DCA85692E9FAD9D9C6F7")

    boolean mHavePendingDeferredStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.671 -0400", hash_original_field = "D0B68049F76228FB1A7F03664CE569DE", hash_generated_field = "92A56B8032395A53760143DE797F97FA")

    Bundle mStateBundle = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.671 -0400", hash_original_field = "EA03FEC1D1BDCAB5D2BD8A3D0ADCF67E", hash_generated_field = "280BE7FE9228C6CA67328AF4B4B28047")

    SparseArray<Parcelable> mStateArray = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.673 -0400", hash_original_field = "BB4C35BD7F2BC82D3F4C38422B568E9B", hash_generated_field = "16CCA9D759D5437E3DE397888C084A9F")

    Runnable mExecCommit = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.673 -0400", hash_original_method = "C2BA1C69EB0B4CCFF1A319535DB79508", hash_generated_method = "FEDC918E58215E12D8175F59CA2BA6B4")
        @Override
        public void run() {
            execPendingActions();
            // ---------- Original Method ----------
            //execPendingActions();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.673 -0400", hash_original_method = "57A648A59831AB7BB1637AFC6125C81E", hash_generated_method = "57A648A59831AB7BB1637AFC6125C81E")
    public FragmentManagerImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.698 -0400", hash_original_method = "70ACCC725CBD51E4B696A7DF31DD0DB0", hash_generated_method = "42ECA9C3A32DE2B9CB1736C6779CCCD6")
    private void throwException(RuntimeException ex) {
        LogWriter logw;
        logw = new LogWriter(TAG);
        PrintWriter pw;
        pw = new PrintWriter(logw);
        {
            try 
            {
                mActivity.dump("  ", null, pw, new String[] { });
            } //End block
            catch (Exception e)
            { }
        } //End block
        {
            try 
            {
                dump("  ", null, pw, new String[] { });
            } //End block
            catch (Exception e)
            { }
        } //End block
        if (DroidSafeAndroidRuntime.control) throw ex;
        addTaint(ex.getTaint());
        // ---------- Original Method ----------
        //Log.e(TAG, ex.getMessage());
        //Log.e(TAG, "Activity state:");
        //LogWriter logw = new LogWriter(TAG);
        //PrintWriter pw = new PrintWriter(logw);
        //if (mActivity != null) {
            //try {
                //mActivity.dump("  ", null, pw, new String[] { });
            //} catch (Exception e) {
                //Log.e(TAG, "Failed dumping state", e);
            //}
        //} else {
            //try {
                //dump("  ", null, pw, new String[] { });
            //} catch (Exception e) {
                //Log.e(TAG, "Failed dumping state", e);
            //}
        //}
        //throw ex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.707 -0400", hash_original_method = "FD4DF6D1DA8CD9545895F43FA5CF7B0B", hash_generated_method = "4FDAD37A6FB6AC018F16FE452D8663C2")
    @Override
    public FragmentTransaction beginTransaction() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_172050619 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_172050619 = new BackStackRecord(this);
        varB4EAC82CA7396A68D541C85D26508E83_172050619.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_172050619;
        // ---------- Original Method ----------
        //return new BackStackRecord(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.709 -0400", hash_original_method = "082964FFA3913D960E19EEB76BD9505B", hash_generated_method = "55C08910C7D26177F5B1E08BC547CF38")
    @Override
    public boolean executePendingTransactions() {
        boolean varDEC74AD03B6C92C5F58BDD6F9B78062F_1269773805 = (execPendingActions());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_416689528 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_416689528;
        // ---------- Original Method ----------
        //return execPendingActions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.712 -0400", hash_original_method = "5CB88371A39240A7C2FB2F2041C5DD0D", hash_generated_method = "889B45A954D792DEE69AFDC674F77AA2")
    @Override
    public void popBackStack() {
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.712 -0400", hash_original_method = "C15C9D80C4BF4FB6B2AF0B93A4449441", hash_generated_method = "B3F70B584C16FE3B98A16E26008D78C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.714 -0400", hash_original_method = "B7072E2D8E1B8CAC03251D641D234641", hash_generated_method = "5062B258EAB40326772FD1064EB55746")
    @Override
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        boolean varE659918100A3B568A6F3D267CDA15217_1341726400 = (popBackStackState(mActivity.mHandler, null, -1, 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1240819351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1240819351;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, null, -1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.731 -0400", hash_original_method = "9E86D2BA46D98A91B2D43097CFA7F639", hash_generated_method = "08BEABB5AF4AF72EDEB032258459E7E2")
    @Override
    public void popBackStack(final String name, final int flags) {
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.731 -0400", hash_original_method = "22FC8A6DB6B4AB9E651D01E64BEED72A", hash_generated_method = "3FE29178F98A070A5E0ED21762A74700")
            @Override
            public void run() {
                popBackStackState(mActivity.mHandler, name, -1, flags);
                // ---------- Original Method ----------
                //popBackStackState(mActivity.mHandler, name, -1, flags);
            }
}, false);
        addTaint(name.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //enqueueAction(new Runnable() {
            //@Override public void run() {
                //popBackStackState(mActivity.mHandler, name, -1, flags);
            //}
        //}, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.734 -0400", hash_original_method = "4DEC43188CEAB5FA4EF2839673649ECC", hash_generated_method = "E1B5ACE729505F575447470A89A9C2EF")
    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        checkStateLoss();
        executePendingTransactions();
        boolean var8537C2C3238620E29A2DABFDDEEAED83_1199562290 = (popBackStackState(mActivity.mHandler, name, -1, flags));
        addTaint(name.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_847389012 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_847389012;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, name, -1, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.736 -0400", hash_original_method = "DA57C1B5DA7DBD65A6FF7556F6C0B827", hash_generated_method = "DF4E4FC7E07B5083F60E995ACBB437B4")
    @Override
    public void popBackStack(final int id, final int flags) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } //End block
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.736 -0400", hash_original_method = "DBCE7037D51EB5153CDA373E6D392F0E", hash_generated_method = "905DCE3DB8D6804FD0D561A3F3EB2065")
            @Override
            public void run() {
                popBackStackState(mActivity.mHandler, null, id, flags);
                // ---------- Original Method ----------
                //popBackStackState(mActivity.mHandler, null, id, flags);
            }
}, false);
        addTaint(id);
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.736 -0400", hash_original_method = "C28CBCAD3FA2084F032C85B006AF0CA6", hash_generated_method = "092C82266C8519941249A705483F1579")
    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        checkStateLoss();
        executePendingTransactions();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } //End block
        boolean var4EE663DB9CE1C64C129233E54BE6C6E6_1032694125 = (popBackStackState(mActivity.mHandler, null, id, flags));
        addTaint(id);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_957618977 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_957618977;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //if (id < 0) {
            //throw new IllegalArgumentException("Bad id: " + id);
        //}
        //return popBackStackState(mActivity.mHandler, null, id, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.737 -0400", hash_original_method = "81448DC3AD62196301F3A4A762AB09A8", hash_generated_method = "3516B7CD5248B2A14632E42DD828AC9B")
    @Override
    public int getBackStackEntryCount() {
        {
            Object var0D23A520C4639C79F477D4746DB89D7E_263261933 = (mBackStack.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977905119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_977905119;
        // ---------- Original Method ----------
        //return mBackStack != null ? mBackStack.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.737 -0400", hash_original_method = "898A7E40DF942FAA7422F0070AE7C2C0", hash_generated_method = "28191FE1C35B9748B2A7E96B2ABF8EB2")
    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        BackStackEntry varB4EAC82CA7396A68D541C85D26508E83_898395249 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_898395249 = mBackStack.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_898395249.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_898395249;
        // ---------- Original Method ----------
        //return mBackStack.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.754 -0400", hash_original_method = "5B02C223CD8F1AC3632AF80A3BE5FAF1", hash_generated_method = "B50FC75A1E09A20DD3B47627FFC2F2BF")
    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        {
            mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        } //End block
        mBackStackChangeListeners.add(listener);
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mBackStackChangeListeners == null) {
            //mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        //}
        //mBackStackChangeListeners.add(listener);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.755 -0400", hash_original_method = "0EB71E2FD8D5B96EE15FDFA4CFDC7A3A", hash_generated_method = "67C87F2824D7F39E431B9C463BEFAAFD")
    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        {
            mBackStackChangeListeners.remove(listener);
        } //End block
        addTaint(listener.getTaint());
        // ---------- Original Method ----------
        //if (mBackStackChangeListeners != null) {
            //mBackStackChangeListeners.remove(listener);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.768 -0400", hash_original_method = "3F35630659DD6C09B78E73F7BD07330C", hash_generated_method = "20D42BA41D9C0C80A399BBAF15981F5C")
    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        {
            throwException(new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager"));
        } //End block
        bundle.putInt(key, fragment.mIndex);
        addTaint(bundle.getTaint());
        addTaint(key.getTaint());
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
        //if (fragment.mIndex < 0) {
            //throwException(new IllegalStateException("Fragment " + fragment
                    //+ " is not currently in the FragmentManager"));
        //}
        //bundle.putInt(key, fragment.mIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.769 -0400", hash_original_method = "4CDB8119120F20E16B511E77159C27B3", hash_generated_method = "5859773FFBBEC99B3C24CA1D7DF56A2D")
    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1865242967 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1336678424 = null; //Variable for return #2
        int index;
        index = bundle.getInt(key, -1);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1865242967 = null;
        } //End block
        {
            boolean var107AB73BAE9815E9603DA2E7CAF7C8B7_1412803932 = (index >= mActive.size());
            {
                throwException(new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index));
            } //End block
        } //End collapsed parenthetic
        Fragment f;
        f = mActive.get(index);
        {
            throwException(new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1336678424 = f;
        addTaint(bundle.getTaint());
        addTaint(key.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_1076188300; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1076188300 = varB4EAC82CA7396A68D541C85D26508E83_1865242967;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1076188300 = varB4EAC82CA7396A68D541C85D26508E83_1336678424;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1076188300.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1076188300;
        // ---------- Original Method ----------
        //int index = bundle.getInt(key, -1);
        //if (index == -1) {
            //return null;
        //}
        //if (index >= mActive.size()) {
            //throwException(new IllegalStateException("Fragement no longer exists for key "
                    //+ key + ": index " + index));
        //}
        //Fragment f = mActive.get(index);
        //if (f == null) {
            //throwException(new IllegalStateException("Fragement no longer exists for key "
                    //+ key + ": index " + index));
        //}
        //return f;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.771 -0400", hash_original_method = "D25922C7B1DBFD38B1587BBC1D3E9AF4", hash_generated_method = "4D615D1699FB12B9C36E6139205B0D6B")
    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Fragment.SavedState varB4EAC82CA7396A68D541C85D26508E83_2050123527 = null; //Variable for return #1
        Fragment.SavedState varB4EAC82CA7396A68D541C85D26508E83_898910273 = null; //Variable for return #2
        {
            throwException( new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager"));
        } //End block
        {
            Bundle result;
            result = saveFragmentBasicState(fragment);
            varB4EAC82CA7396A68D541C85D26508E83_2050123527 = result != null ? new Fragment.SavedState(result) : null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_898910273 = null;
        addTaint(fragment.getTaint());
        Fragment.SavedState varA7E53CE21691AB073D9660D615818899_1155636579; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1155636579 = varB4EAC82CA7396A68D541C85D26508E83_2050123527;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1155636579 = varB4EAC82CA7396A68D541C85D26508E83_898910273;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1155636579.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1155636579;
        // ---------- Original Method ----------
        //if (fragment.mIndex < 0) {
            //throwException( new IllegalStateException("Fragment " + fragment
                    //+ " is not currently in the FragmentManager"));
        //}
        //if (fragment.mState > Fragment.INITIALIZING) {
            //Bundle result = saveFragmentBasicState(fragment);
            //return result != null ? new Fragment.SavedState(result) : null;
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.777 -0400", hash_original_method = "809378480DC9ABFE56F2FAE2E163A583", hash_generated_method = "8A562DD1C034746D4CB00034F501652F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1582349751 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        {
            DebugUtils.buildShortClassTag(mParent, sb);
        } //End block
        {
            DebugUtils.buildShortClassTag(mActivity, sb);
        } //End block
        sb.append("}}");
        varB4EAC82CA7396A68D541C85D26508E83_1582349751 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1582349751.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1582349751;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("FragmentManager{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(" in ");
        //if (mParent != null) {
            //DebugUtils.buildShortClassTag(mParent, sb);
        //} else {
            //DebugUtils.buildShortClassTag(mActivity, sb);
        //}
        //sb.append("}}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.781 -0400", hash_original_method = "69E4EB9F72755E8BD358E210AC6CFB24", hash_generated_method = "2CECC9B4F4A8D8EEEDE4E9F41DF59ED2")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
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
                boolean varC3EC129F2815C61E4CC968B0C16B5E00_1847255822 = (mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0);
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
        writer.print("  mActivity=");
        writer.println(mActivity);
        writer.print(prefix);
        writer.print("  mContainer=");
        writer.println(mContainer);
        {
            writer.print(prefix);
            writer.print("  mParent=");
            writer.println(mParent);
        } //End block
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
            boolean varD0CA0404E33A0C2149F9FC712F4B1B56_1464120451 = (mAvailIndices != null && mAvailIndices.size() > 0);
            {
                writer.print(prefix);
                writer.print("  mAvailIndices: ");
                writer.println(Arrays.toString(mAvailIndices.toArray()));
            } //End block
        } //End collapsed parenthetic
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        static Animation makeOpenCloseAnimation(Context context, float startScale,
            float endScale, float startAlpha, float endAlpha) {
        AnimationSet set = new AnimationSet(false);
        ScaleAnimation scale = new ScaleAnimation(startScale, endScale, startScale, endScale,
                Animation.RELATIVE_TO_SELF, .5f, Animation.RELATIVE_TO_SELF, .5f);
        scale.setInterpolator(DECELERATE_QUINT);
        scale.setDuration(ANIM_DUR);
        set.addAnimation(scale);
        AlphaAnimation alpha = new AlphaAnimation(startAlpha, endAlpha);
        alpha.setInterpolator(DECELERATE_CUBIC);
        alpha.setDuration(ANIM_DUR);
        set.addAnimation(alpha);
        return set;
    }

    
        static Animation makeFadeAnimation(Context context, float start, float end) {
        AlphaAnimation anim = new AlphaAnimation(start, end);
        anim.setInterpolator(DECELERATE_CUBIC);
        anim.setDuration(ANIM_DUR);
        return anim;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.799 -0400", hash_original_method = "1D86F34E1479CAC948F0E54CF5418376", hash_generated_method = "8EB4EC61ED82D3B0C9AFBE48EF8F4E1F")
     Animation loadAnimation(Fragment fragment, int transit, boolean enter,
            int transitionStyle) {
        Animation varB4EAC82CA7396A68D541C85D26508E83_1542967519 = null; //Variable for return #1
        Animation varB4EAC82CA7396A68D541C85D26508E83_1405774145 = null; //Variable for return #2
        Animation varB4EAC82CA7396A68D541C85D26508E83_1086383489 = null; //Variable for return #3
        Animation varB4EAC82CA7396A68D541C85D26508E83_1984668432 = null; //Variable for return #4
        Animation varB4EAC82CA7396A68D541C85D26508E83_2025532216 = null; //Variable for return #5
        Animation varB4EAC82CA7396A68D541C85D26508E83_752730336 = null; //Variable for return #6
        Animation varB4EAC82CA7396A68D541C85D26508E83_349091899 = null; //Variable for return #7
        Animation varB4EAC82CA7396A68D541C85D26508E83_1960543448 = null; //Variable for return #8
        Animation varB4EAC82CA7396A68D541C85D26508E83_348273332 = null; //Variable for return #9
        Animation varB4EAC82CA7396A68D541C85D26508E83_1559351316 = null; //Variable for return #10
        Animation varB4EAC82CA7396A68D541C85D26508E83_340465515 = null; //Variable for return #11
        Animation varB4EAC82CA7396A68D541C85D26508E83_978460560 = null; //Variable for return #12
        Animation animObj;
        animObj = fragment.onCreateAnimation(transit, enter,
                fragment.mNextAnim);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1542967519 = animObj;
        } //End block
        {
            Animation anim;
            anim = AnimationUtils.loadAnimation(mActivity, fragment.mNextAnim);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1405774145 = anim;
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1086383489 = null;
        } //End block
        int styleIndex;
        styleIndex = transitToStyleIndex(transit, enter);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1984668432 = null;
        } //End block
        //Begin case ANIM_STYLE_OPEN_ENTER 
        varB4EAC82CA7396A68D541C85D26508E83_2025532216 = makeOpenCloseAnimation(mActivity, 1.125f, 1.0f, 0, 1);
        //End case ANIM_STYLE_OPEN_ENTER 
        //Begin case ANIM_STYLE_OPEN_EXIT 
        varB4EAC82CA7396A68D541C85D26508E83_752730336 = makeOpenCloseAnimation(mActivity, 1.0f, .975f, 1, 0);
        //End case ANIM_STYLE_OPEN_EXIT 
        //Begin case ANIM_STYLE_CLOSE_ENTER 
        varB4EAC82CA7396A68D541C85D26508E83_349091899 = makeOpenCloseAnimation(mActivity, .975f, 1.0f, 0, 1);
        //End case ANIM_STYLE_CLOSE_ENTER 
        //Begin case ANIM_STYLE_CLOSE_EXIT 
        varB4EAC82CA7396A68D541C85D26508E83_1960543448 = makeOpenCloseAnimation(mActivity, 1.0f, 1.075f, 1, 0);
        //End case ANIM_STYLE_CLOSE_EXIT 
        //Begin case ANIM_STYLE_FADE_ENTER 
        varB4EAC82CA7396A68D541C85D26508E83_348273332 = makeFadeAnimation(mActivity, 0, 1);
        //End case ANIM_STYLE_FADE_ENTER 
        //Begin case ANIM_STYLE_FADE_EXIT 
        varB4EAC82CA7396A68D541C85D26508E83_1559351316 = makeFadeAnimation(mActivity, 1, 0);
        //End case ANIM_STYLE_FADE_EXIT 
        {
            boolean var7E1D31F47E4E5D9D781C22ACD7E0177E_1841728438 = (transitionStyle == 0 && mActivity.getWindow() != null);
            {
                transitionStyle = mActivity.getWindow().getAttributes().windowAnimations;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_340465515 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_978460560 = null;
        addTaint(fragment.getTaint());
        addTaint(transit);
        addTaint(enter);
        addTaint(transitionStyle);
        Animation varA7E53CE21691AB073D9660D615818899_1020149572; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_1542967519;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_1405774145;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_1086383489;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_1984668432;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_2025532216;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_752730336;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_349091899;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_1960543448;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_348273332;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_1559351316;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_340465515;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1020149572 = varB4EAC82CA7396A68D541C85D26508E83_978460560;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1020149572.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1020149572;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.800 -0400", hash_original_method = "53A703CAB9B91DDAE05ABF1E3656A1E0", hash_generated_method = "4E2153DB46C19F03E9394F34F7A79ECF")
    public void performPendingDeferredStart(Fragment f) {
        {
            {
                mHavePendingDeferredStart = true;
            } //End block
            f.mDeferStart = false;
            moveToState(f, mCurState, 0, 0, false);
        } //End block
        addTaint(f.getTaint());
        // ---------- Original Method ----------
        //if (f.mDeferStart) {
            //if (mExecutingActions) {
                //mHavePendingDeferredStart = true;
                //return;
            //}
            //f.mDeferStart = false;
            //moveToState(f, mCurState, 0, 0, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.839 -0400", hash_original_method = "F13A9F8BA98A34618DEF4155010BA2F5", hash_generated_method = "601B9CF2B8E09A37BE3AAA8A0A4AE6B7")
     void moveToState(Fragment f, int newState, int transit, int transitionStyle,
            boolean keepActive) {
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
                moveToState(f, f.mStateAfterAnimating, 0, 0, true);
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
            f.mParentFragment = mParent;
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            f.mFragmentManager = mParent != null
                            ? mParent.mChildFragmentManager : mActivity.mFragments;
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
            {
                mActivity.onAttachFragment(f);
            } //End block
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            {
                f.performCreate(f.mSavedFragmentState);
            } //End block
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            f.mRetaining = false;
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.INITIALIZING 
            {
                f.mView = f.performCreateView(f.getLayoutInflater(
                                f.mSavedFragmentState), null, f.mSavedFragmentState);
                {
                    f.mInnerView = f.mView;
                    f.mView = NoSaveStateFrameLayout.wrap(f.mView);
                    f.mView.setVisibility(View.GONE);
                    f.onViewCreated(f.mView, f.mSavedFragmentState);
                } //End block
                {
                    f.mInnerView = null;
                } //End block
            } //End block
            //End case Fragment.INITIALIZING 
            //Begin case Fragment.CREATED 
            {
                {
                    ViewGroup container;
                    container = null;
                    {
                        container = (ViewGroup)mContainer.findViewById(f.mContainerId);
                        {
                            throwException(new IllegalArgumentException(
                                            "No view found for id 0x"
                                            + Integer.toHexString(f.mContainerId) + " ("
                                            + f.getResources().getResourceName(f.mContainerId)
                                            + ") for fragment " + f));
                        } //End block
                    } //End block
                    f.mContainer = container;
                    f.mView = f.performCreateView(f.getLayoutInflater(
                                    f.mSavedFragmentState), container, f.mSavedFragmentState);
                    {
                        f.mInnerView = f.mView;
                        f.mView = NoSaveStateFrameLayout.wrap(f.mView);
                        {
                            Animation anim;
                            anim = loadAnimation(f, transit, true,
                                            transitionStyle);
                            {
                                f.mView.startAnimation(anim);
                            } //End block
                            container.addView(f.mView);
                        } //End block
                        f.mView.setVisibility(View.GONE);
                        f.onViewCreated(f.mView, f.mSavedFragmentState);
                    } //End block
                    {
                        f.mInnerView = null;
                    } //End block
                } //End block
                f.performActivityCreated(f.mSavedFragmentState);
                {
                    f.restoreViewState(f.mSavedFragmentState);
                } //End block
                f.mSavedFragmentState = null;
            } //End block
            //End case Fragment.CREATED 
            //Begin case Fragment.ACTIVITY_CREATED Fragment.STOPPED 
            {
                f.performStart();
            } //End block
            //End case Fragment.ACTIVITY_CREATED Fragment.STOPPED 
            //Begin case Fragment.STARTED 
            {
                f.mResumed = true;
                f.performResume();
                f.mSavedFragmentState = null;
                f.mSavedViewState = null;
            } //End block
            //End case Fragment.STARTED 
        } //End block
        {
            //Begin case Fragment.RESUMED 
            {
                f.performPause();
                f.mResumed = false;
            } //End block
            //End case Fragment.RESUMED 
            //Begin case Fragment.STARTED 
            {
                f.performStop();
            } //End block
            //End case Fragment.STARTED 
            //Begin case Fragment.STOPPED 
            {
                f.performReallyStop();
            } //End block
            //End case Fragment.STOPPED 
            //Begin case Fragment.ACTIVITY_CREATED 
            {
                {
                    {
                        boolean var96EB76334F7F0C83DB99A12D79366153_1739400229 = (!mActivity.isFinishing() && f.mSavedViewState == null);
                        {
                            saveFragmentViewState(f);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                f.performDestroyView();
                {
                    Animation anim;
                    anim = null;
                    {
                        anim = loadAnimation(f, transit, false,
                                        transitionStyle);
                    } //End block
                    {
                        Fragment fragment;
                        fragment = f;
                        f.mAnimatingAway = f.mView;
                        f.mStateAfterAnimating = newState;
                        anim.setAnimationListener(new AnimationListener() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.836 -0400", hash_original_method = "ADB37ED087A6B8FD09A7637E04A46959", hash_generated_method = "EE60C95D2F87FAAE5A6BCFE6A53C71D7")
                            @Override
                            public void onAnimationEnd(Animation animation) {
                                //DSFIXME:  CODE0009: Possible callback target function detected
                                {
                                    fragment.mAnimatingAway = null;
                                    moveToState(fragment, fragment.mStateAfterAnimating,
                                                    0, 0, false);
                                } //End block
                                addTaint(animation.getTaint());
                                // ---------- Original Method ----------
                                //if (fragment.mAnimatingAway != null) {
                                            //fragment.mAnimatingAway = null;
                                            //moveToState(fragment, fragment.mStateAfterAnimating,
                                                    //0, 0, false);
                                        //}
                            }
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.836 -0400", hash_original_method = "C6539FC3721A6B610C21747FF87D7A97", hash_generated_method = "58C626A9D98C5CFBF993A93EFEF59553")
                            @Override
                            public void onAnimationRepeat(Animation animation) {
                                //DSFIXME:  CODE0009: Possible callback target function detected
                                addTaint(animation.getTaint());
                                // ---------- Original Method ----------
                            }
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.838 -0400", hash_original_method = "72AD432A5D6B612A6CC4174C0C1E057D", hash_generated_method = "E455F4DC332660DC5ADFD15AC2AD6C17")
                            @Override
                            public void onAnimationStart(Animation animation) {
                                //DSFIXME:  CODE0009: Possible callback target function detected
                                addTaint(animation.getTaint());
                                // ---------- Original Method ----------
                            }
});
                        f.mView.startAnimation(anim);
                    } //End block
                    f.mContainer.removeView(f.mView);
                } //End block
                f.mContainer = null;
                f.mView = null;
                f.mInnerView = null;
            } //End block
            //End case Fragment.ACTIVITY_CREATED 
            //Begin case Fragment.CREATED 
            {
                {
                    {
                        View v;
                        v = f.mAnimatingAway;
                        f.mAnimatingAway = null;
                        v.clearAnimation();
                    } //End block
                } //End block
                {
                    f.mStateAfterAnimating = newState;
                    newState = Fragment.CREATED;
                } //End block
                {
                    {
                        f.performDestroy();
                    } //End block
                    f.mCalled = false;
                    f.onDetach();
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                        + " did not call through to super.onDetach()");
                    } //End block
                    {
                        {
                            makeInactive(f);
                        } //End block
                        {
                            f.mActivity = null;
                            f.mFragmentManager = null;
                        } //End block
                    } //End block
                } //End block
            } //End block
            //End case Fragment.CREATED 
        } //End block
        f.mState = newState;
        addTaint(newState);
        addTaint(transit);
        addTaint(transitionStyle);
        addTaint(keepActive);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.856 -0400", hash_original_method = "253ACA6E8863F76AC823063DED921CB5", hash_generated_method = "47EA51D167131DEF1620E51FBBA38ACC")
     void moveToState(Fragment f) {
        moveToState(f, mCurState, 0, 0, false);
        addTaint(f.getTaint());
        // ---------- Original Method ----------
        //moveToState(f, mCurState, 0, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.856 -0400", hash_original_method = "4A2DC4C23578532593EF5B01DCA60326", hash_generated_method = "9A6D3575C75AC7095BF1636094E58E4E")
     void moveToState(int newState, boolean always) {
        moveToState(newState, 0, 0, always);
        addTaint(newState);
        addTaint(always);
        // ---------- Original Method ----------
        //moveToState(newState, 0, 0, always);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.865 -0400", hash_original_method = "5BD27BFF276D517E1379D91A3F7AF343", hash_generated_method = "7DB106A86419B913775BBBB942607E9E")
     void moveToState(int newState, int transit, int transitStyle, boolean always) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No activity");
        } //End block
        mCurState = newState;
        {
            boolean loadersRunning;
            loadersRunning = false;
            {
                int i;
                i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_1419098644 = (i<mActive.size());
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        moveToState(f, newState, transit, transitStyle, false);
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
                mActivity.supportInvalidateOptionsMenu();
                mNeedMenuInvalidate = false;
            } //End block
        } //End block
        addTaint(transit);
        addTaint(transitStyle);
        addTaint(always);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.866 -0400", hash_original_method = "CCAA4C21D5B5313253593374D7FC1754", hash_generated_method = "2CF0E321051788ADFB4D0F83C51C8EFA")
     void startPendingDeferredFragments() {
        {
            int i;
            i = 0;
            boolean varBBF7D06AD5BD96085BA2B334471E7136_936599042 = (i<mActive.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.871 -0400", hash_original_method = "47E8AE46DB9C6E9F4895918BFF9C77EF", hash_generated_method = "94C4F02068DA9945363FCE19996EA303")
     void makeActive(Fragment f) {
        {
            boolean var0C317551F6EB79301C3E3065D871C4BD_37867432 = (mAvailIndices == null || mAvailIndices.size() <= 0);
            {
                {
                    mActive = new ArrayList<Fragment>();
                } //End block
                f.setIndex(mActive.size(), mParent);
                mActive.add(f);
            } //End block
            {
                f.setIndex(mAvailIndices.remove(mAvailIndices.size()-1), mParent);
                mActive.set(f.mIndex, f);
            } //End block
        } //End collapsed parenthetic
        addTaint(f.getTaint());
        // ---------- Original Method ----------
        //if (f.mIndex >= 0) {
            //return;
        //}
        //if (mAvailIndices == null || mAvailIndices.size() <= 0) {
            //if (mActive == null) {
                //mActive = new ArrayList<Fragment>();
            //}
            //f.setIndex(mActive.size(), mParent);
            //mActive.add(f);
        //} else {
            //f.setIndex(mAvailIndices.remove(mAvailIndices.size()-1), mParent);
            //mActive.set(f.mIndex, f);
        //}
        //if (DEBUG) Log.v(TAG, "Allocated fragment index " + f);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.872 -0400", hash_original_method = "2838DA3381C6FA665FE83DACB606EE48", hash_generated_method = "61DDA3377AB9651151C69BEF49F64950")
     void makeInactive(Fragment f) {
        mActive.set(f.mIndex, null);
        {
            mAvailIndices = new ArrayList<Integer>();
        } //End block
        mAvailIndices.add(f.mIndex);
        mActivity.invalidateSupportFragment(f.mWho);
        f.initState();
        addTaint(f.getTaint());
        // ---------- Original Method ----------
        //if (f.mIndex < 0) {
            //return;
        //}
        //if (DEBUG) Log.v(TAG, "Freeing fragment index " + f);
        //mActive.set(f.mIndex, null);
        //if (mAvailIndices == null) {
            //mAvailIndices = new ArrayList<Integer>();
        //}
        //mAvailIndices.add(f.mIndex);
        //mActivity.invalidateSupportFragment(f.mWho);
        //f.initState();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.890 -0400", hash_original_method = "A7004D7E770917F1698CC4D8DC4A636A", hash_generated_method = "31040AEBC774199D4FA73C3C6C14E6C4")
    public void addFragment(Fragment fragment, boolean moveToStateNow) {
        {
            mAdded = new ArrayList<Fragment>();
        } //End block
        makeActive(fragment);
        {
            {
                boolean varD9E3BBCE1C55EA398A02EC19B3EB59D7_2131394396 = (mAdded.contains(fragment));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment already added: " + fragment);
                } //End block
            } //End collapsed parenthetic
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
        addTaint(moveToStateNow);
        // ---------- Original Method ----------
        //if (mAdded == null) {
            //mAdded = new ArrayList<Fragment>();
        //}
        //if (DEBUG) Log.v(TAG, "add: " + fragment);
        //makeActive(fragment);
        //if (!fragment.mDetached) {
            //if (mAdded.contains(fragment)) {
                //throw new IllegalStateException("Fragment already added: " + fragment);
            //}
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.892 -0400", hash_original_method = "13B3CB0CAD8C045C67262987362B8EBE", hash_generated_method = "D886363BBEBF9A9F9BB24D28F187DA89")
    public void removeFragment(Fragment fragment, int transition, int transitionStyle) {
        boolean inactive;
        inactive = !fragment.isInBackStack();
        {
            {
                mAdded.remove(fragment);
            } //End block
            {
                mNeedMenuInvalidate = true;
            } //End block
            fragment.mAdded = false;
            fragment.mRemoving = true;
            moveToState(fragment, inactive ? Fragment.INITIALIZING : Fragment.CREATED,
                    transition, transitionStyle, false);
        } //End block
        addTaint(transition);
        addTaint(transitionStyle);
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        //final boolean inactive = !fragment.isInBackStack();
        //if (!fragment.mDetached || inactive) {
            //if (mAdded != null) {
                //mAdded.remove(fragment);
            //}
            //if (fragment.mHasMenu && fragment.mMenuVisible) {
                //mNeedMenuInvalidate = true;
            //}
            //fragment.mAdded = false;
            //fragment.mRemoving = true;
            //moveToState(fragment, inactive ? Fragment.INITIALIZING : Fragment.CREATED,
                    //transition, transitionStyle, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.897 -0400", hash_original_method = "BED4301A21B487BD6D143A374885F309", hash_generated_method = "C400E08D1F1760064BB811529928F7B5")
    public void hideFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mHidden = true;
            {
                Animation anim;
                anim = loadAnimation(fragment, transition, false,
                        transitionStyle);
                {
                    fragment.mView.startAnimation(anim);
                } //End block
                fragment.mView.setVisibility(View.GONE);
            } //End block
            {
                mNeedMenuInvalidate = true;
            } //End block
            fragment.onHiddenChanged(true);
        } //End block
        addTaint(fragment.getTaint());
        addTaint(transition);
        addTaint(transitionStyle);
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "hide: " + fragment);
        //if (!fragment.mHidden) {
            //fragment.mHidden = true;
            //if (fragment.mView != null) {
                //Animation anim = loadAnimation(fragment, transition, false,
                        //transitionStyle);
                //if (anim != null) {
                    //fragment.mView.startAnimation(anim);
                //}
                //fragment.mView.setVisibility(View.GONE);
            //}
            //if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                //mNeedMenuInvalidate = true;
            //}
            //fragment.onHiddenChanged(true);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.911 -0400", hash_original_method = "5884A689188772E4B067D85FA0FE2485", hash_generated_method = "5D1E861F9E992904384AF441A640E263")
    public void showFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mHidden = false;
            {
                Animation anim;
                anim = loadAnimation(fragment, transition, true,
                        transitionStyle);
                {
                    fragment.mView.startAnimation(anim);
                } //End block
                fragment.mView.setVisibility(View.VISIBLE);
            } //End block
            {
                mNeedMenuInvalidate = true;
            } //End block
            fragment.onHiddenChanged(false);
        } //End block
        addTaint(fragment.getTaint());
        addTaint(transition);
        addTaint(transitionStyle);
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "show: " + fragment);
        //if (fragment.mHidden) {
            //fragment.mHidden = false;
            //if (fragment.mView != null) {
                //Animation anim = loadAnimation(fragment, transition, true,
                        //transitionStyle);
                //if (anim != null) {
                    //fragment.mView.startAnimation(anim);
                //}
                //fragment.mView.setVisibility(View.VISIBLE);
            //}
            //if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                //mNeedMenuInvalidate = true;
            //}
            //fragment.onHiddenChanged(false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.915 -0400", hash_original_method = "8ADA384A2A804F3DB8950E51751AE080", hash_generated_method = "9F640DA7E8398ABB9D4A1DE5EEF1913E")
    public void detachFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mDetached = true;
            {
                {
                    mAdded.remove(fragment);
                } //End block
                {
                    mNeedMenuInvalidate = true;
                } //End block
                fragment.mAdded = false;
                moveToState(fragment, Fragment.CREATED, transition, transitionStyle, false);
            } //End block
        } //End block
        addTaint(transition);
        addTaint(transitionStyle);
        // ---------- Original Method ----------
        //if (DEBUG) Log.v(TAG, "detach: " + fragment);
        //if (!fragment.mDetached) {
            //fragment.mDetached = true;
            //if (fragment.mAdded) {
                //if (mAdded != null) {
                    //if (DEBUG) Log.v(TAG, "remove from detach: " + fragment);
                    //mAdded.remove(fragment);
                //}
                //if (fragment.mHasMenu && fragment.mMenuVisible) {
                    //mNeedMenuInvalidate = true;
                //}
                //fragment.mAdded = false;
                //moveToState(fragment, Fragment.CREATED, transition, transitionStyle, false);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.916 -0400", hash_original_method = "C689EB45F7FDDB493496798809CCC982", hash_generated_method = "8D176F98EB8F8D61157AAA87F0D01EC2")
    public void attachFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mDetached = false;
            {
                {
                    mAdded = new ArrayList<Fragment>();
                } //End block
                {
                    boolean var4A590CAC6EAAD99B8C32C7FE40C0A339_823429845 = (mAdded.contains(fragment));
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment already added: " + fragment);
                    } //End block
                } //End collapsed parenthetic
                mAdded.add(fragment);
                fragment.mAdded = true;
                {
                    mNeedMenuInvalidate = true;
                } //End block
                moveToState(fragment, mCurState, transition, transitionStyle, false);
            } //End block
        } //End block
        addTaint(transition);
        addTaint(transitionStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.936 -0400", hash_original_method = "369BBF881289C60802E9A80BDB6F1062", hash_generated_method = "E48768319B067F1CA5499585D6625F57")
    public Fragment findFragmentById(int id) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_920319311 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_318454020 = null; //Variable for return #2
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1805949299 = null; //Variable for return #3
        {
            {
                int i;
                i = mAdded.size()-1;
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_920319311 = f;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = mActive.size()-1;
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_318454020 = f;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1805949299 = null;
        addTaint(id);
        Fragment varA7E53CE21691AB073D9660D615818899_291936702; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_291936702 = varB4EAC82CA7396A68D541C85D26508E83_920319311;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_291936702 = varB4EAC82CA7396A68D541C85D26508E83_318454020;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_291936702 = varB4EAC82CA7396A68D541C85D26508E83_1805949299;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_291936702.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_291936702;
        // ---------- Original Method ----------
        //if (mAdded != null) {
            //for (int i=mAdded.size()-1; i>=0; i--) {
                //Fragment f = mAdded.get(i);
                //if (f != null && f.mFragmentId == id) {
                    //return f;
                //}
            //}
        //}
        //if (mActive != null) {
            //for (int i=mActive.size()-1; i>=0; i--) {
                //Fragment f = mActive.get(i);
                //if (f != null && f.mFragmentId == id) {
                    //return f;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.938 -0400", hash_original_method = "A116F7F22C8FEEEBB3418EA3417C69EB", hash_generated_method = "351143CA4611B706DA87641B63F10DF3")
    public Fragment findFragmentByTag(String tag) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_814086956 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_68416978 = null; //Variable for return #2
        Fragment varB4EAC82CA7396A68D541C85D26508E83_625217036 = null; //Variable for return #3
        {
            {
                int i;
                i = mAdded.size()-1;
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_941583756 = (f != null && tag.equals(f.mTag));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_814086956 = f;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = mActive.size()-1;
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_370509086 = (f != null && tag.equals(f.mTag));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_68416978 = f;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_625217036 = null;
        addTaint(tag.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_2077597061; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2077597061 = varB4EAC82CA7396A68D541C85D26508E83_814086956;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2077597061 = varB4EAC82CA7396A68D541C85D26508E83_68416978;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2077597061 = varB4EAC82CA7396A68D541C85D26508E83_625217036;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2077597061.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2077597061;
        // ---------- Original Method ----------
        //if (mAdded != null && tag != null) {
            //for (int i=mAdded.size()-1; i>=0; i--) {
                //Fragment f = mAdded.get(i);
                //if (f != null && tag.equals(f.mTag)) {
                    //return f;
                //}
            //}
        //}
        //if (mActive != null && tag != null) {
            //for (int i=mActive.size()-1; i>=0; i--) {
                //Fragment f = mActive.get(i);
                //if (f != null && tag.equals(f.mTag)) {
                    //return f;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.940 -0400", hash_original_method = "9082D0FF97F62C4058EE52B6A6365151", hash_generated_method = "73FC14326B472C8C25AEFB5B23F66369")
    public Fragment findFragmentByWho(String who) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_133551393 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1034910563 = null; //Variable for return #2
        {
            {
                int i;
                i = mActive.size()-1;
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        boolean var8C929A471928159D9F345C3B4316EAE7_1530545720 = (f != null && (f=f.findFragmentByWho(who)) != null);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_133551393 = f;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1034910563 = null;
        addTaint(who.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_1296745557; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1296745557 = varB4EAC82CA7396A68D541C85D26508E83_133551393;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1296745557 = varB4EAC82CA7396A68D541C85D26508E83_1034910563;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1296745557.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1296745557;
        // ---------- Original Method ----------
        //if (mActive != null && who != null) {
            //for (int i=mActive.size()-1; i>=0; i--) {
                //Fragment f = mActive.get(i);
                //if (f != null && (f=f.findFragmentByWho(who)) != null) {
                    //return f;
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.960 -0400", hash_original_method = "B87B380B690A16EB7F37B7EE1C0A0D26", hash_generated_method = "4076EE59F13ECCD4B07230734A017E5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.961 -0400", hash_original_method = "32359130EC903AF4E096237D1F067453", hash_generated_method = "410DC0CBEEB103B1080749640316417F")
    public void enqueueAction(Runnable action, boolean allowStateLoss) {
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
                boolean varED396C6F84781DC21825B4A03F526E3B_194834390 = (mPendingActions.size() == 1);
                {
                    mActivity.mHandler.removeCallbacks(mExecCommit);
                    mActivity.mHandler.post(mExecCommit);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(action.getTaint());
        addTaint(allowStateLoss);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.962 -0400", hash_original_method = "1503673DA6CC1FF53261337C6A89F6BE", hash_generated_method = "D0F0E1482313190D63BE7E576B00EA0E")
    public int allocBackStackIndex(BackStackRecord bse) {
        {
            {
                boolean var98612EE02F6CF00DE971BBFA890C1BB0_1264347437 = (mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0);
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
        addTaint(bse.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499432537 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1499432537;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.964 -0400", hash_original_method = "F0AF804A23A686630C8F5E2012EB99F7", hash_generated_method = "CEAFBE3D0FE56865A9ED0AD5353818A0")
    public void setBackStackIndex(int index, BackStackRecord bse) {
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
        addTaint(index);
        addTaint(bse.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.965 -0400", hash_original_method = "A75FE5CB17552EA725360407924677A5", hash_generated_method = "AFDDA9DE97FC9DF3E5F4BF723FE82F1A")
    public void freeBackStackIndex(int index) {
        {
            mBackStackIndices.set(index, null);
            {
                mAvailBackStackIndices = new ArrayList<Integer>();
            } //End block
            mAvailBackStackIndices.add(index);
        } //End block
        addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.985 -0400", hash_original_method = "2EC9B9D8ABC4926EA1F7FF85BE00D458", hash_generated_method = "23525D512E6B258B6E4292274CABABD3")
    public boolean execPendingActions() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Recursive entry to executePendingTransactions");
        } //End block
        {
            boolean var92CCD900C583B95C908C1457DCFC97EB_351333772 = (Looper.myLooper() != mActivity.mHandler.getLooper());
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
                    boolean var8F64D3B59DFFB1D978D9FFAE1E7D437D_869828537 = (mPendingActions == null || mPendingActions.size() == 0);
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
                boolean var2E483A1271BDE2FC27F0CB7948500179_861971873 = (i<mActive.size());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1192463217 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1192463217;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.986 -0400", hash_original_method = "480CA24D6CDDA51ECD1DFDE903041169", hash_generated_method = "53EC7B1A1B513181D567B03EA5A67F65")
     void reportBackStackChanged() {
        {
            {
                int i;
                i = 0;
                boolean var3737AEDF4226FD639F6461E15393E309_973727596 = (i<mBackStackChangeListeners.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:33.999 -0400", hash_original_method = "93C61FA561A07CB0E9B057A7A904C282", hash_generated_method = "FF183CDFF9871413611B0CFF67FE69C7")
     void addBackStackState(BackStackRecord state) {
        {
            mBackStack = new ArrayList<BackStackRecord>();
        } //End block
        mBackStack.add(state);
        reportBackStackChanged();
        addTaint(state.getTaint());
        // ---------- Original Method ----------
        //if (mBackStack == null) {
            //mBackStack = new ArrayList<BackStackRecord>();
        //}
        //mBackStack.add(state);
        //reportBackStackChanged();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.015 -0400", hash_original_method = "2DCA4D0949EEA78B53FF55FD7B1EE1F8", hash_generated_method = "9780A219F8F59ED09D98003748BC8894")
     boolean popBackStackState(Handler handler, String name, int id, int flags) {
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
                        boolean varBEA6676FD08F9A893EB03C8E97D94F9C_1818895393 = (name != null && name.equals(bss.getName()));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        BackStackRecord bss;
                        bss = mBackStack.get(index);
                        {
                            boolean varF7B12DD1A8F871B2F43DC36592D3ADBE_1334969843 = ((name != null && name.equals(bss.getName()))
                                || (id >= 0 && id == bss.mIndex));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
            {
                boolean var4A958E5CC0AD80F8568B9E8089EACA0B_307492740 = (index == mBackStack.size()-1);
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
        addTaint(handler.getTaint());
        addTaint(name.getTaint());
        addTaint(id);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1213926359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1213926359;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.016 -0400", hash_original_method = "4601075007D50CE0BCD1D759D668CB84", hash_generated_method = "F363A23F528B7E019F962A7432232F86")
     ArrayList<Fragment> retainNonConfig() {
        ArrayList<Fragment> varB4EAC82CA7396A68D541C85D26508E83_1731810781 = null; //Variable for return #1
        ArrayList<Fragment> fragments;
        fragments = null;
        {
            {
                int i;
                i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_1250790224 = (i<mActive.size());
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
        varB4EAC82CA7396A68D541C85D26508E83_1731810781 = fragments;
        varB4EAC82CA7396A68D541C85D26508E83_1731810781.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1731810781;
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
                    //if (DEBUG) Log.v(TAG, "retainNonConfig: keeping retained " + f);
                //}
            //}
        //}
        //return fragments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.023 -0400", hash_original_method = "AB64A806E53952D63B221B8A02A39B9D", hash_generated_method = "32C3CCB6AD2732297E1D3D387E3DBCAD")
     void saveFragmentViewState(Fragment f) {
        {
            mStateArray = new SparseArray<Parcelable>();
        } //End block
        {
            mStateArray.clear();
        } //End block
        f.mInnerView.saveHierarchyState(mStateArray);
        {
            boolean var10CB5DFFB182D477A1F1C08C2A2A4D10_1460836401 = (mStateArray.size() > 0);
            {
                f.mSavedViewState = mStateArray;
                mStateArray = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(f.getTaint());
        // ---------- Original Method ----------
        //if (f.mInnerView == null) {
            //return;
        //}
        //if (mStateArray == null) {
            //mStateArray = new SparseArray<Parcelable>();
        //} else {
            //mStateArray.clear();
        //}
        //f.mInnerView.saveHierarchyState(mStateArray);
        //if (mStateArray.size() > 0) {
            //f.mSavedViewState = mStateArray;
            //mStateArray = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.028 -0400", hash_original_method = "4EAE6A1450E2744D0D17A0CBB3487A4E", hash_generated_method = "EF9F31988DD28E3DA5A976995CD41CB4")
     Bundle saveFragmentBasicState(Fragment f) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_261070912 = null; //Variable for return #1
        Bundle result;
        result = null;
        {
            mStateBundle = new Bundle();
        } //End block
        f.performSaveInstanceState(mStateBundle);
        {
            boolean var5AE1326457CED87C792B211942E81B2E_1714911814 = (!mStateBundle.isEmpty());
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
            {
                result = new Bundle();
            } //End block
            result.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, f.mUserVisibleHint);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_261070912 = result;
        addTaint(f.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_261070912.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_261070912;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.040 -0400", hash_original_method = "10343325EA0A9B349A8A31D89021E4C8", hash_generated_method = "0070EF0E55EB3BCDD6C1861597429F0B")
     Parcelable saveAllState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1266027982 = null; //Variable for return #1
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_651843413 = null; //Variable for return #2
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1890927275 = null; //Variable for return #3
        execPendingActions();
        {
            mStateSaved = true;
        } //End block
        {
            boolean var7B1A0FE06CC77C5BE5C8EE27C706FD90_1958363524 = (mActive == null || mActive.size() <= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1266027982 = null;
            } //End block
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
                    {
                        throwException(new IllegalStateException(
                            "Failure saving state: active " + f
                            + " has cleared index: " + f.mIndex));
                    } //End block
                    haveFragments = true;
                    FragmentState fs;
                    fs = new FragmentState(f);
                    active[i] = fs;
                    {
                        fs.mSavedFragmentState = saveFragmentBasicState(f);
                        {
                            {
                                throwException(new IllegalStateException(
                                    "Failure saving state: " + f
                                    + " has target not in fragment manager: " + f.mTarget));
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_651843413 = null;
        } //End block
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
                        {
                            throwException(new IllegalStateException(
                                "Failure saving state: active " + mAdded.get(i)
                                + " has cleared index: " + added[i]));
                        } //End block
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
        varB4EAC82CA7396A68D541C85D26508E83_1890927275 = fms;
        Parcelable varA7E53CE21691AB073D9660D615818899_186170938; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_186170938 = varB4EAC82CA7396A68D541C85D26508E83_1266027982;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_186170938 = varB4EAC82CA7396A68D541C85D26508E83_651843413;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_186170938 = varB4EAC82CA7396A68D541C85D26508E83_1890927275;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_186170938.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_186170938;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.060 -0400", hash_original_method = "83508419770250A244151298D1C277A7", hash_generated_method = "E5C3021686EC4F152492CE3C936BB61E")
     void restoreAllState(Parcelable state, ArrayList<Fragment> nonConfig) {
        FragmentManagerState fms;
        fms = (FragmentManagerState)state;
        {
            {
                int i;
                i = 0;
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_7452818 = (i<nonConfig.size());
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
                    f = fs.instantiate(mActivity, mParent);
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
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_710828252 = (i<nonConfig.size());
                {
                    Fragment f;
                    f = nonConfig.get(i);
                    {
                        {
                            boolean var487621A5D4BD2ACED481B16F5F5948D3_1425640429 = (f.mTargetIndex < mActive.size());
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
                        throwException(new IllegalStateException(
                            "No instantiated fragment for index #" + fms.mAdded[i]));
                    } //End block
                    f.mAdded = true;
                    {
                        boolean var9BF1C25340280F172CE0222A135FE437_1350471844 = (mAdded.contains(f));
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already added!");
                        } //End block
                    } //End collapsed parenthetic
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
                    {
                        LogWriter logw;
                        logw = new LogWriter(TAG);
                        PrintWriter pw;
                        pw = new PrintWriter(logw);
                        bse.dump("  ", pw, false);
                    } //End block
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
        addTaint(state.getTaint());
        addTaint(nonConfig.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.069 -0400", hash_original_method = "6B9797EDFBB2C38037CA64E1EEB36778", hash_generated_method = "21267ED483B445873A924C400C2D5F96")
    public void attachActivity(FragmentActivity activity,
            FragmentContainer container, Fragment parent) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Already attached");
        mActivity = activity;
        mContainer = container;
        mParent = parent;
        // ---------- Original Method ----------
        //if (mActivity != null) throw new IllegalStateException("Already attached");
        //mActivity = activity;
        //mContainer = container;
        //mParent = parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.069 -0400", hash_original_method = "9E4E3FCA42BDE19CBF71140223B4B8D0", hash_generated_method = "B5C7E72CCEE273A62746EE3408615591")
    public void noteStateNotSaved() {
        mStateSaved = false;
        // ---------- Original Method ----------
        //mStateSaved = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.070 -0400", hash_original_method = "4EAFC4D017ED2B44474902CD00BD047E", hash_generated_method = "21C3627E95BE86042A719066A2913EA6")
    public void dispatchCreate() {
        mStateSaved = false;
        moveToState(Fragment.CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.071 -0400", hash_original_method = "BB3D6B45374259B5EE70270EF5FFE721", hash_generated_method = "1F7202ED50DB7895525D3D5DD1A85A9D")
    public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(Fragment.ACTIVITY_CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.ACTIVITY_CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.072 -0400", hash_original_method = "145C9AF81AEB697CB534D8E0C0F599A0", hash_generated_method = "20844DC4E325108731D69AD369D5CB9A")
    public void dispatchStart() {
        mStateSaved = false;
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.072 -0400", hash_original_method = "35325401D14378833F40C78A6FC3DC5D", hash_generated_method = "9E4D22D120F9A6B67EA4BB2B4DEB3341")
    public void dispatchResume() {
        mStateSaved = false;
        moveToState(Fragment.RESUMED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.RESUMED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.073 -0400", hash_original_method = "E6EE1A1408209BDB9066272C26AA9863", hash_generated_method = "806CEF702E5812DC1949A4F8EE32F575")
    public void dispatchPause() {
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.073 -0400", hash_original_method = "A6766C0F069AFB58F0A12165F2E095FC", hash_generated_method = "2DD793A778E88D54EE3A335BA8F3FB22")
    public void dispatchStop() {
        mStateSaved = true;
        moveToState(Fragment.STOPPED, false);
        // ---------- Original Method ----------
        //mStateSaved = true;
        //moveToState(Fragment.STOPPED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.073 -0400", hash_original_method = "DCD943307D69805205EE4AFFC6D1EFE3", hash_generated_method = "89E0EF721C47E2DF40831E82789D0DE5")
    public void dispatchReallyStop() {
        moveToState(Fragment.ACTIVITY_CREATED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.ACTIVITY_CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.087 -0400", hash_original_method = "69F58A9B4E2F72C0D627B376DB1A1CDC", hash_generated_method = "7C0C65D29ADA12A03B42DDDA4BE52A2A")
    public void dispatchDestroyView() {
        moveToState(Fragment.CREATED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.088 -0400", hash_original_method = "92EF0F88C8A3B3CDE2712CBD7D916058", hash_generated_method = "4183A75BEA237931F279EC68B16055AF")
    public void dispatchDestroy() {
        mDestroyed = true;
        execPendingActions();
        moveToState(Fragment.INITIALIZING, false);
        mActivity = null;
        mContainer = null;
        mParent = null;
        // ---------- Original Method ----------
        //mDestroyed = true;
        //execPendingActions();
        //moveToState(Fragment.INITIALIZING, false);
        //mActivity = null;
        //mContainer = null;
        //mParent = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.092 -0400", hash_original_method = "3F9069EC8564151620B164A5CADDDD85", hash_generated_method = "5F0AD07ABEDF6CC113E4AD36849D5B95")
    public void dispatchConfigurationChanged(Configuration newConfig) {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_666786070 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.performConfigurationChanged(newConfig);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(newConfig.getTaint());
        // ---------- Original Method ----------
        //if (mAdded != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null) {
                    //f.performConfigurationChanged(newConfig);
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.093 -0400", hash_original_method = "423006F51D0218BAC00AF0FAAABB2869", hash_generated_method = "1FF73EEEAC433BA064B645B2DE48285E")
    public void dispatchLowMemory() {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_883215384 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.performLowMemory();
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mAdded != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null) {
                    //f.performLowMemory();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.094 -0400", hash_original_method = "E04D4A6462A884A432217EF1D5562FD6", hash_generated_method = "3AB9072116C0E0D9713EFCF39526F0BC")
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean show;
        show = false;
        ArrayList<Fragment> newMenus;
        newMenus = null;
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1858014194 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        {
                            boolean var2BD7DDEAB658B1A7B29311D300A3B085_437439367 = (f.performCreateOptionsMenu(menu, inflater));
                            {
                                show = true;
                                {
                                    newMenus = new ArrayList<Fragment>();
                                } //End block
                                newMenus.add(f);
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i;
                i = 0;
                boolean var829574F28570EB1E74183020953B6E4B_514594933 = (i<mCreatedMenus.size());
                {
                    Fragment f;
                    f = mCreatedMenus.get(i);
                    {
                        boolean varF740BD6A5A57A11B5D73D0A67A04AEFC_686194146 = (newMenus == null || !newMenus.contains(f));
                        {
                            f.onDestroyOptionsMenu();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        mCreatedMenus = newMenus;
        addTaint(menu.getTaint());
        addTaint(inflater.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_305920989 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_305920989;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.107 -0400", hash_original_method = "39A1BE180E5A6D21A2BE9889A37AE1EE", hash_generated_method = "AEAD96EFCE27B4347466C62A346284CE")
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean show;
        show = false;
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1138416145 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        {
                            boolean var7A9D124B4B5ACA00D3EAF8F312D52005_1280167855 = (f.performPrepareOptionsMenu(menu));
                            {
                                show = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1786636160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1786636160;
        // ---------- Original Method ----------
        //boolean show = false;
        //if (mAdded != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null) {
                    //if (f.performPrepareOptionsMenu(menu)) {
                        //show = true;
                    //}
                //}
            //}
        //}
        //return show;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.108 -0400", hash_original_method = "40C97B67F40ABFD093891951534367FF", hash_generated_method = "94B5616F395E07840917A57F3608598C")
    public boolean dispatchOptionsItemSelected(MenuItem item) {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1711717996 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        {
                            boolean var5564C9E1EB2E8953D0F00B48E89AFC17_301693272 = (f.performOptionsItemSelected(item));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_668618625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_668618625;
        // ---------- Original Method ----------
        //if (mAdded != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null) {
                    //if (f.performOptionsItemSelected(item)) {
                        //return true;
                    //}
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.109 -0400", hash_original_method = "61E677AAD1D9B7A657F2B5668ED52005", hash_generated_method = "FC8D7931B7A493F0833B35B4606400B0")
    public boolean dispatchContextItemSelected(MenuItem item) {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_24341752 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        {
                            boolean var4AA73CE006242FE3515CA0A67DA79788_884623336 = (f.performContextItemSelected(item));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856491299 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856491299;
        // ---------- Original Method ----------
        //if (mAdded != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null) {
                    //if (f.performContextItemSelected(item)) {
                        //return true;
                    //}
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.110 -0400", hash_original_method = "6CB4593DD4D25806442B1A7EB0939595", hash_generated_method = "7F08879D00276CBAD2AD2C926251D832")
    public void dispatchOptionsMenuClosed(Menu menu) {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_780995436 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.performOptionsMenuClosed(menu);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
        //if (mAdded != null) {
            //for (int i=0; i<mAdded.size(); i++) {
                //Fragment f = mAdded.get(i);
                //if (f != null) {
                    //f.performOptionsMenuClosed(menu);
                //}
            //}
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
                animAttr = enter ? ANIM_STYLE_OPEN_ENTER : ANIM_STYLE_OPEN_EXIT;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_CLOSE:
                animAttr = enter ? ANIM_STYLE_CLOSE_ENTER : ANIM_STYLE_CLOSE_EXIT;
                break;
            case FragmentTransaction.TRANSIT_FRAGMENT_FADE:
                animAttr = enter ? ANIM_STYLE_FADE_ENTER : ANIM_STYLE_FADE_EXIT;
                break;
        }
        return animAttr;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.118 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.118 -0400", hash_original_field = "309AAD3E76F171051A35712763096DE8", hash_generated_field = "1EA3A5C5FC69D5714D9768796013BDF7")

    static String TAG = "FragmentManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.118 -0400", hash_original_field = "F97D1635AABE57FB12E9B1B2518064C6", hash_generated_field = "5B8616AA57FA0DE1705E5CF42ED833D1")

    static boolean HONEYCOMB = android.os.Build.VERSION.SDK_INT >= 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.118 -0400", hash_original_field = "E58DEFB2E4C5F4C4BC898BC35F33C192", hash_generated_field = "BC915678C8B05A455B6EFF9197D144CC")

    static String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.119 -0400", hash_original_field = "A8D8A7593440E0D7D4A8A21F4BCD6D54", hash_generated_field = "B989DF0B503591D35BE57CF1B243AE35")

    static String TARGET_STATE_TAG = "android:target_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.119 -0400", hash_original_field = "03990A2696101FE20E375C710E3F3AE1", hash_generated_field = "E26DCEE01F3AD04324A06084305D6B42")

    static String VIEW_STATE_TAG = "android:view_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.122 -0400", hash_original_field = "80B57815D7CE7602226A48E51B42D058", hash_generated_field = "8482DED8AA15BDE9E6D81579BC59E4AB")

    static String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.122 -0400", hash_original_field = "6C95BC8E2A60A9F4236FBFC95395E3A2", hash_generated_field = "40A030D32BDE1D83A6C0D2A64CCA0013")

    static Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.122 -0400", hash_original_field = "D8281C96E9514BF04DE392578617576C", hash_generated_field = "E57DFB8D08E48225401B7253C507DAE0")

    static Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.123 -0400", hash_original_field = "D10DC5918CDE7E82CA9095D02FEF8A0C", hash_generated_field = "61B9D63A921E7D3856B940E5F591A4CF")

    static Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.123 -0400", hash_original_field = "838B2B5AA8359A71F94BB598DD8FD304", hash_generated_field = "A915EC9C711124474A7036365AA5FF44")

    static Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.123 -0400", hash_original_field = "1A243DE04BDCF448B42B90B6C7D09AB2", hash_generated_field = "3E3CBD62EE79D73BB22EFBB511D7B70B")

    static int ANIM_DUR = 220;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.123 -0400", hash_original_field = "260F4A8077B41158EE5084820597CDFE", hash_generated_field = "7BB089DC1B8A242E88755BDA8C8238B9")

    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.123 -0400", hash_original_field = "519D0B58F7134135D9F630C9958BA2A5", hash_generated_field = "3C4C6A69EA30C5B582DE8DD757B46311")

    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.123 -0400", hash_original_field = "809B49B33A269DC9ED63B13FAE899E5D", hash_generated_field = "B289F5FCA54C37F25FF23F46A1D8D232")

    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.123 -0400", hash_original_field = "B7C90BEFCC36650797B1A5C0EAE37430", hash_generated_field = "913DA58C0421DE752A939A21044C5DD0")

    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.123 -0400", hash_original_field = "E8EC520365F556FDD343EE5BF52DC8EF", hash_generated_field = "6EE14C70EFD271C2B32055938BC50C20")

    public static final int ANIM_STYLE_FADE_ENTER = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:34.123 -0400", hash_original_field = "BDA176AA41F039DA1615DEC8A570C95D", hash_generated_field = "F489982675E5C10DFACA93BE86E50D4D")

    public static final int ANIM_STYLE_FADE_EXIT = 6;
}

