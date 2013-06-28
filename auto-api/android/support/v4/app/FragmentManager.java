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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.878 -0400", hash_original_method = "0D3FEDE97BC3242ED64134E1F014EA11", hash_generated_method = "0D3FEDE97BC3242ED64134E1F014EA11")
    public FragmentManager ()
    {
        //Synthesized constructor
    }


    public abstract FragmentTransaction beginTransaction();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.878 -0400", hash_original_method = "0DA67415D41DB3C4C9D7AB80CD2D78FE", hash_generated_method = "D9BA6CE121155855A75915D67F5D8F08")
    @Deprecated
    public FragmentTransaction openTransaction() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_890769715 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_890769715 = beginTransaction();
        varB4EAC82CA7396A68D541C85D26508E83_890769715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_890769715;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.881 -0400", hash_original_field = "F2813E5BD6A379A2985E370BE1887EDA", hash_generated_field = "3F74866CBC8F49655F2B8BB97CC17F5E")

    public static final int POP_BACK_STACK_INCLUSIVE = 1<<0;
}

final class FragmentManagerState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.881 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "0C91046A014C3ABDDA41BA020BEE7D35")

    FragmentState[] mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.881 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "4D5C3ED026B5D0195A6077AFCD696836")

    int[] mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.881 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "EEA20C5C67D270067553BCDE313A7B27")

    BackStackState[] mBackStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.882 -0400", hash_original_method = "4ADB2DBBD6899E89144480A7958A6490", hash_generated_method = "252DFEAE0ECB79838960A8B564DE42F6")
    public  FragmentManagerState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.882 -0400", hash_original_method = "020574327F1D57965B67553DD6F7D979", hash_generated_method = "F858C24C16C6DB16663BD3817D53ADD9")
    public  FragmentManagerState(Parcel in) {
        mActive = in.createTypedArray(FragmentState.CREATOR);
        mAdded = in.createIntArray();
        mBackStack = in.createTypedArray(BackStackState.CREATOR);
        // ---------- Original Method ----------
        //mActive = in.createTypedArray(FragmentState.CREATOR);
        //mAdded = in.createIntArray();
        //mBackStack = in.createTypedArray(BackStackState.CREATOR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.882 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "11F8B676BE0046D72852449599412EBD")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996846742 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1996846742;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_method = "B6654BF7A24842DC15E6AD3A5F27203C", hash_generated_method = "755001DC0FEE505DA71D76177C4F11BA")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "D29AA2723BAE7915447DC2F30F3AAA56", hash_generated_field = "EE9672AF4023C35BB0D72B0356E5DA5C")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "327C9FAD23CE4030098BE2DE91837CF7", hash_generated_field = "11FD18D208B09E922FC03FBF68E7335B")

    ArrayList<Runnable> mPendingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "E3843751CB2154B155E225749A18D620", hash_generated_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3")

    Runnable[] mTmpActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "CDD41116A3EE1465C2308845599CA08D", hash_generated_field = "CD4485F6F525738DAA0EA0DC245911AB")

    boolean mExecutingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "A1650882FA43FC001601740ED87DBA1F")

    ArrayList<Fragment> mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "FF37605B8D813171195C0EBF92B2A116")

    ArrayList<Fragment> mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "CD7D957830B65DDE14B44534836CDCFA", hash_generated_field = "5441838D07CA3D72A0FE3BB98FAAC33E")

    ArrayList<Integer> mAvailIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "A66A7C10189C949E8CDC007D4D07280E")

    ArrayList<BackStackRecord> mBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "07EBA043D3FF90523B37550E5D9B91E4", hash_generated_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7")

    ArrayList<Fragment> mCreatedMenus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "A06EFC21545AC26226ABF57556E73291", hash_generated_field = "89571A39B2AB736200FBD57A213BDB4D")

    ArrayList<BackStackRecord> mBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "A96F62FC59DD2FAE4327C1E7855AE979", hash_generated_field = "27AED91E8586753C6865FA558A4716C8")

    ArrayList<Integer> mAvailBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "D0295B7D6BE1788760CAFE41F824D774", hash_generated_field = "078DA2C7CA0D4289F90F664D0B3EDB3B")

    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "C81B2F53A65D169421FFBC0C3AC986EE", hash_generated_field = "9521C64640071A41BA8B18982DEC3BE2")

    int mCurState = Fragment.INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "DC6970CAF75184DB6DB1AAC52EA720C0")

    FragmentActivity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "4716918018B597B9E2482B529B6BAD4A")

    FragmentContainer mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "08DEDF480C56042390504EEB5F2B5C59", hash_generated_field = "D9437984C8B60662ED185FA42AA3938D")

    Fragment mParent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "1ED82791F588E1B933718ECC0041EE63", hash_generated_field = "19DD0E42F9FC244F37062274E8F2012D")

    boolean mNeedMenuInvalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "5C1552B132EB06695090E74F8854ED21", hash_generated_field = "E68067DB35DA8BD96BFB5C858DBE74BF")

    boolean mStateSaved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

    boolean mDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "1ECE9D4CB2FBE961BEE64D8760E25D34", hash_generated_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE")

    String mNoTransactionsBecause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "20E894967D971C1F65FB2EA61F367BAE", hash_generated_field = "79BC4D349D09DCA85692E9FAD9D9C6F7")

    boolean mHavePendingDeferredStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "D0B68049F76228FB1A7F03664CE569DE", hash_generated_field = "92A56B8032395A53760143DE797F97FA")

    Bundle mStateBundle = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.883 -0400", hash_original_field = "EA03FEC1D1BDCAB5D2BD8A3D0ADCF67E", hash_generated_field = "280BE7FE9228C6CA67328AF4B4B28047")

    SparseArray<Parcelable> mStateArray = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.884 -0400", hash_original_field = "BB4C35BD7F2BC82D3F4C38422B568E9B", hash_generated_field = "9126D3C716AC852A46D1963380A0CE0E")

    Runnable mExecCommit = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.884 -0400", hash_original_method = "C2BA1C69EB0B4CCFF1A319535DB79508", hash_generated_method = "FEDC918E58215E12D8175F59CA2BA6B4")
        @Override
        public void run() {
            execPendingActions();
            // ---------- Original Method ----------
            //execPendingActions();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.884 -0400", hash_original_method = "57A648A59831AB7BB1637AFC6125C81E", hash_generated_method = "57A648A59831AB7BB1637AFC6125C81E")
    public FragmentManagerImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.884 -0400", hash_original_method = "70ACCC725CBD51E4B696A7DF31DD0DB0", hash_generated_method = "1E860E516A977D3051472C798F6F58A1")
    private void throwException(RuntimeException ex) {
        LogWriter logw = new LogWriter(TAG);
        PrintWriter pw = new PrintWriter(logw);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.885 -0400", hash_original_method = "FD4DF6D1DA8CD9545895F43FA5CF7B0B", hash_generated_method = "9D643DF02CE195FFD7FA6691FABE63D2")
    @Override
    public FragmentTransaction beginTransaction() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1089141982 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1089141982 = new BackStackRecord(this);
        varB4EAC82CA7396A68D541C85D26508E83_1089141982.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1089141982;
        // ---------- Original Method ----------
        //return new BackStackRecord(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.885 -0400", hash_original_method = "082964FFA3913D960E19EEB76BD9505B", hash_generated_method = "854D60124719F65C2F690E8F015C33DD")
    @Override
    public boolean executePendingTransactions() {
        boolean varDEC74AD03B6C92C5F58BDD6F9B78062F_90083482 = (execPendingActions());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_156439309 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_156439309;
        // ---------- Original Method ----------
        //return execPendingActions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.886 -0400", hash_original_method = "5CB88371A39240A7C2FB2F2041C5DD0D", hash_generated_method = "1142D608DA8C337E36B487A8F636FC2B")
    @Override
    public void popBackStack() {
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.886 -0400", hash_original_method = "C15C9D80C4BF4FB6B2AF0B93A4449441", hash_generated_method = "B3F70B584C16FE3B98A16E26008D78C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.886 -0400", hash_original_method = "B7072E2D8E1B8CAC03251D641D234641", hash_generated_method = "D60078EC1804EA3641B0AA3FFBAC4F32")
    @Override
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        boolean varE659918100A3B568A6F3D267CDA15217_147362849 = (popBackStackState(mActivity.mHandler, null, -1, 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2084587918 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2084587918;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, null, -1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.887 -0400", hash_original_method = "9E86D2BA46D98A91B2D43097CFA7F639", hash_generated_method = "16E2622E42E5E5494EF8270FD8BFA525")
    @Override
    public void popBackStack(final String name, final int flags) {
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.887 -0400", hash_original_method = "22FC8A6DB6B4AB9E651D01E64BEED72A", hash_generated_method = "3FE29178F98A070A5E0ED21762A74700")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.887 -0400", hash_original_method = "4DEC43188CEAB5FA4EF2839673649ECC", hash_generated_method = "95D051C5EC8716D25151E53E9D71CB99")
    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        checkStateLoss();
        executePendingTransactions();
        boolean var8537C2C3238620E29A2DABFDDEEAED83_2005472989 = (popBackStackState(mActivity.mHandler, name, -1, flags));
        addTaint(name.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1782216483 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1782216483;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, name, -1, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.888 -0400", hash_original_method = "DA57C1B5DA7DBD65A6FF7556F6C0B827", hash_generated_method = "9B28807FE92000136AEC0BB45B8FF765")
    @Override
    public void popBackStack(final int id, final int flags) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } //End block
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.888 -0400", hash_original_method = "DBCE7037D51EB5153CDA373E6D392F0E", hash_generated_method = "905DCE3DB8D6804FD0D561A3F3EB2065")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.888 -0400", hash_original_method = "C28CBCAD3FA2084F032C85B006AF0CA6", hash_generated_method = "1C2D1C500146319387332B415932C0C4")
    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        checkStateLoss();
        executePendingTransactions();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } //End block
        boolean var4EE663DB9CE1C64C129233E54BE6C6E6_440097316 = (popBackStackState(mActivity.mHandler, null, id, flags));
        addTaint(id);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_19813171 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_19813171;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //if (id < 0) {
            //throw new IllegalArgumentException("Bad id: " + id);
        //}
        //return popBackStackState(mActivity.mHandler, null, id, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.889 -0400", hash_original_method = "81448DC3AD62196301F3A4A762AB09A8", hash_generated_method = "A1085EFCBB83103888A73502B20C5488")
    @Override
    public int getBackStackEntryCount() {
        {
            Object var0D23A520C4639C79F477D4746DB89D7E_1590366681 = (mBackStack.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145874124 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1145874124;
        // ---------- Original Method ----------
        //return mBackStack != null ? mBackStack.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.889 -0400", hash_original_method = "898A7E40DF942FAA7422F0070AE7C2C0", hash_generated_method = "775B2A08AE22E35957F4AABDFAC69853")
    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        BackStackEntry varB4EAC82CA7396A68D541C85D26508E83_2135060923 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2135060923 = mBackStack.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2135060923.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2135060923;
        // ---------- Original Method ----------
        //return mBackStack.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.890 -0400", hash_original_method = "5B02C223CD8F1AC3632AF80A3BE5FAF1", hash_generated_method = "B50FC75A1E09A20DD3B47627FFC2F2BF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.890 -0400", hash_original_method = "0EB71E2FD8D5B96EE15FDFA4CFDC7A3A", hash_generated_method = "67C87F2824D7F39E431B9C463BEFAAFD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.891 -0400", hash_original_method = "3F35630659DD6C09B78E73F7BD07330C", hash_generated_method = "20D42BA41D9C0C80A399BBAF15981F5C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.892 -0400", hash_original_method = "4CDB8119120F20E16B511E77159C27B3", hash_generated_method = "CABFE8670A04103E872B91EAC1B8495F")
    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_502072790 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1382529655 = null; //Variable for return #2
        int index = bundle.getInt(key, -1);
        {
            varB4EAC82CA7396A68D541C85D26508E83_502072790 = null;
        } //End block
        {
            boolean var107AB73BAE9815E9603DA2E7CAF7C8B7_944562558 = (index >= mActive.size());
            {
                throwException(new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index));
            } //End block
        } //End collapsed parenthetic
        Fragment f = mActive.get(index);
        {
            throwException(new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index));
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1382529655 = f;
        addTaint(bundle.getTaint());
        addTaint(key.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_547354487; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_547354487 = varB4EAC82CA7396A68D541C85D26508E83_502072790;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_547354487 = varB4EAC82CA7396A68D541C85D26508E83_1382529655;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_547354487.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_547354487;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.894 -0400", hash_original_method = "D25922C7B1DBFD38B1587BBC1D3E9AF4", hash_generated_method = "F1E6DF4A3F85E5C6EB8FBBB2818E7867")
    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Fragment.SavedState varB4EAC82CA7396A68D541C85D26508E83_1865577927 = null; //Variable for return #1
        Fragment.SavedState varB4EAC82CA7396A68D541C85D26508E83_2097193067 = null; //Variable for return #2
        {
            throwException( new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager"));
        } //End block
        {
            Bundle result = saveFragmentBasicState(fragment);
            varB4EAC82CA7396A68D541C85D26508E83_1865577927 = result != null ? new Fragment.SavedState(result) : null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2097193067 = null;
        addTaint(fragment.getTaint());
        Fragment.SavedState varA7E53CE21691AB073D9660D615818899_1039968672; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1039968672 = varB4EAC82CA7396A68D541C85D26508E83_1865577927;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1039968672 = varB4EAC82CA7396A68D541C85D26508E83_2097193067;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1039968672.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1039968672;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.895 -0400", hash_original_method = "809378480DC9ABFE56F2FAE2E163A583", hash_generated_method = "51DFC63CECBF58466EDD427DCF8B369E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1661423354 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder(128);
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
        varB4EAC82CA7396A68D541C85D26508E83_1661423354 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1661423354.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1661423354;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.896 -0400", hash_original_method = "69E4EB9F72755E8BD358E210AC6CFB24", hash_generated_method = "C17993DD490F85A89B4341A0E288DADB")
    @Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String innerPrefix = prefix + "    ";
        int N;
        {
            N = mActive.size();
            {
                writer.print(prefix);
                writer.print("Active Fragments in ");
                writer.print(Integer.toHexString(System.identityHashCode(this)));
                writer.println(":");
                {
                    int i = 0;
                    {
                        Fragment f = mActive.get(i);
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
                    int i = 0;
                    {
                        Fragment f = mAdded.get(i);
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
                    int i = 0;
                    {
                        Fragment f = mCreatedMenus.get(i);
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
                    int i = 0;
                    {
                        BackStackRecord bs = mBackStack.get(i);
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
                        int i = 0;
                        {
                            BackStackRecord bs = mBackStackIndices.get(i);
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
                boolean varC3EC129F2815C61E4CC968B0C16B5E00_1306151060 = (mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0);
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
                    int i = 0;
                    {
                        Runnable r = mPendingActions.get(i);
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
            boolean varD0CA0404E33A0C2149F9FC712F4B1B56_946014960 = (mAvailIndices != null && mAvailIndices.size() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.898 -0400", hash_original_method = "1D86F34E1479CAC948F0E54CF5418376", hash_generated_method = "03EFC5911FB6FA48CE2A77D51BCD4CBF")
     Animation loadAnimation(Fragment fragment, int transit, boolean enter,
            int transitionStyle) {
        Animation varB4EAC82CA7396A68D541C85D26508E83_2070574728 = null; //Variable for return #1
        Animation varB4EAC82CA7396A68D541C85D26508E83_9428701 = null; //Variable for return #2
        Animation varB4EAC82CA7396A68D541C85D26508E83_742782957 = null; //Variable for return #3
        Animation varB4EAC82CA7396A68D541C85D26508E83_1950537726 = null; //Variable for return #4
        Animation varB4EAC82CA7396A68D541C85D26508E83_64036492 = null; //Variable for return #5
        Animation varB4EAC82CA7396A68D541C85D26508E83_914760731 = null; //Variable for return #6
        Animation varB4EAC82CA7396A68D541C85D26508E83_1332841519 = null; //Variable for return #7
        Animation varB4EAC82CA7396A68D541C85D26508E83_479605113 = null; //Variable for return #8
        Animation varB4EAC82CA7396A68D541C85D26508E83_134396583 = null; //Variable for return #9
        Animation varB4EAC82CA7396A68D541C85D26508E83_341128510 = null; //Variable for return #10
        Animation varB4EAC82CA7396A68D541C85D26508E83_854935232 = null; //Variable for return #11
        Animation varB4EAC82CA7396A68D541C85D26508E83_1885972072 = null; //Variable for return #12
        Animation animObj = fragment.onCreateAnimation(transit, enter,
                fragment.mNextAnim);
        {
            varB4EAC82CA7396A68D541C85D26508E83_2070574728 = animObj;
        } //End block
        {
            Animation anim = AnimationUtils.loadAnimation(mActivity, fragment.mNextAnim);
            {
                varB4EAC82CA7396A68D541C85D26508E83_9428701 = anim;
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_742782957 = null;
        } //End block
        int styleIndex = transitToStyleIndex(transit, enter);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1950537726 = null;
        } //End block
        //Begin case ANIM_STYLE_OPEN_ENTER 
        varB4EAC82CA7396A68D541C85D26508E83_64036492 = makeOpenCloseAnimation(mActivity, 1.125f, 1.0f, 0, 1);
        //End case ANIM_STYLE_OPEN_ENTER 
        //Begin case ANIM_STYLE_OPEN_EXIT 
        varB4EAC82CA7396A68D541C85D26508E83_914760731 = makeOpenCloseAnimation(mActivity, 1.0f, .975f, 1, 0);
        //End case ANIM_STYLE_OPEN_EXIT 
        //Begin case ANIM_STYLE_CLOSE_ENTER 
        varB4EAC82CA7396A68D541C85D26508E83_1332841519 = makeOpenCloseAnimation(mActivity, .975f, 1.0f, 0, 1);
        //End case ANIM_STYLE_CLOSE_ENTER 
        //Begin case ANIM_STYLE_CLOSE_EXIT 
        varB4EAC82CA7396A68D541C85D26508E83_479605113 = makeOpenCloseAnimation(mActivity, 1.0f, 1.075f, 1, 0);
        //End case ANIM_STYLE_CLOSE_EXIT 
        //Begin case ANIM_STYLE_FADE_ENTER 
        varB4EAC82CA7396A68D541C85D26508E83_134396583 = makeFadeAnimation(mActivity, 0, 1);
        //End case ANIM_STYLE_FADE_ENTER 
        //Begin case ANIM_STYLE_FADE_EXIT 
        varB4EAC82CA7396A68D541C85D26508E83_341128510 = makeFadeAnimation(mActivity, 1, 0);
        //End case ANIM_STYLE_FADE_EXIT 
        {
            boolean var7E1D31F47E4E5D9D781C22ACD7E0177E_473283518 = (transitionStyle == 0 && mActivity.getWindow() != null);
            {
                transitionStyle = mActivity.getWindow().getAttributes().windowAnimations;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_854935232 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1885972072 = null;
        addTaint(fragment.getTaint());
        addTaint(transit);
        addTaint(enter);
        addTaint(transitionStyle);
        Animation varA7E53CE21691AB073D9660D615818899_1129053770; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_2070574728;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_9428701;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_742782957;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_1950537726;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_64036492;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_914760731;
                break;
            case 7: //Assign result for return ordinal #7
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_1332841519;
                break;
            case 8: //Assign result for return ordinal #8
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_479605113;
                break;
            case 9: //Assign result for return ordinal #9
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_134396583;
                break;
            case 10: //Assign result for return ordinal #10
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_341128510;
                break;
            case 11: //Assign result for return ordinal #11
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_854935232;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1129053770 = varB4EAC82CA7396A68D541C85D26508E83_1885972072;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1129053770.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1129053770;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.899 -0400", hash_original_method = "53A703CAB9B91DDAE05ABF1E3656A1E0", hash_generated_method = "4E2153DB46C19F03E9394F34F7A79ECF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.905 -0400", hash_original_method = "F13A9F8BA98A34618DEF4155010BA2F5", hash_generated_method = "09843F327C2B4F8335934595396C8793")
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
                    ViewGroup container = null;
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
                            Animation anim = loadAnimation(f, transit, true,
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
                        boolean var96EB76334F7F0C83DB99A12D79366153_1109868264 = (!mActivity.isFinishing() && f.mSavedViewState == null);
                        {
                            saveFragmentViewState(f);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                f.performDestroyView();
                {
                    Animation anim = null;
                    {
                        anim = loadAnimation(f, transit, false,
                                        transitionStyle);
                    } //End block
                    {
                        final Fragment fragment = f;
                        f.mAnimatingAway = f.mView;
                        f.mStateAfterAnimating = newState;
                        anim.setAnimationListener(new AnimationListener() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.902 -0400", hash_original_method = "ADB37ED087A6B8FD09A7637E04A46959", hash_generated_method = "EE60C95D2F87FAAE5A6BCFE6A53C71D7")
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
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.903 -0400", hash_original_method = "C6539FC3721A6B610C21747FF87D7A97", hash_generated_method = "58C626A9D98C5CFBF993A93EFEF59553")
                            @Override
                            public void onAnimationRepeat(Animation animation) {
                                //DSFIXME:  CODE0009: Possible callback target function detected
                                addTaint(animation.getTaint());
                                // ---------- Original Method ----------
                            }
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.904 -0400", hash_original_method = "72AD432A5D6B612A6CC4174C0C1E057D", hash_generated_method = "E455F4DC332660DC5ADFD15AC2AD6C17")
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
                        View v = f.mAnimatingAway;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.905 -0400", hash_original_method = "253ACA6E8863F76AC823063DED921CB5", hash_generated_method = "47EA51D167131DEF1620E51FBBA38ACC")
     void moveToState(Fragment f) {
        moveToState(f, mCurState, 0, 0, false);
        addTaint(f.getTaint());
        // ---------- Original Method ----------
        //moveToState(f, mCurState, 0, 0, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.906 -0400", hash_original_method = "4A2DC4C23578532593EF5B01DCA60326", hash_generated_method = "9A6D3575C75AC7095BF1636094E58E4E")
     void moveToState(int newState, boolean always) {
        moveToState(newState, 0, 0, always);
        addTaint(newState);
        addTaint(always);
        // ---------- Original Method ----------
        //moveToState(newState, 0, 0, always);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.906 -0400", hash_original_method = "5BD27BFF276D517E1379D91A3F7AF343", hash_generated_method = "FF2F125C1D0EDE50E45664B89854F420")
     void moveToState(int newState, int transit, int transitStyle, boolean always) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No activity");
        } //End block
        mCurState = newState;
        {
            boolean loadersRunning = false;
            {
                int i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_2019200423 = (i<mActive.size());
                {
                    Fragment f = mActive.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.907 -0400", hash_original_method = "CCAA4C21D5B5313253593374D7FC1754", hash_generated_method = "003528D455F3AB0DED0C2C9F88121B4B")
     void startPendingDeferredFragments() {
        {
            int i = 0;
            boolean varBBF7D06AD5BD96085BA2B334471E7136_1176826789 = (i<mActive.size());
            {
                Fragment f = mActive.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.907 -0400", hash_original_method = "47E8AE46DB9C6E9F4895918BFF9C77EF", hash_generated_method = "125521339835C08C223EC24CEB721485")
     void makeActive(Fragment f) {
        {
            boolean var0C317551F6EB79301C3E3065D871C4BD_1222751495 = (mAvailIndices == null || mAvailIndices.size() <= 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.908 -0400", hash_original_method = "2838DA3381C6FA665FE83DACB606EE48", hash_generated_method = "61DDA3377AB9651151C69BEF49F64950")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.908 -0400", hash_original_method = "A7004D7E770917F1698CC4D8DC4A636A", hash_generated_method = "D37CEFC2B6EC105993ECFC9094182FAB")
    public void addFragment(Fragment fragment, boolean moveToStateNow) {
        {
            mAdded = new ArrayList<Fragment>();
        } //End block
        makeActive(fragment);
        {
            {
                boolean varD9E3BBCE1C55EA398A02EC19B3EB59D7_1139598186 = (mAdded.contains(fragment));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.909 -0400", hash_original_method = "13B3CB0CAD8C045C67262987362B8EBE", hash_generated_method = "37F84223B6FD74F151BF4DC3F4239CAD")
    public void removeFragment(Fragment fragment, int transition, int transitionStyle) {
        final boolean inactive = !fragment.isInBackStack();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.909 -0400", hash_original_method = "BED4301A21B487BD6D143A374885F309", hash_generated_method = "96B7FC76D2A06614FC0010AA49692D12")
    public void hideFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mHidden = true;
            {
                Animation anim = loadAnimation(fragment, transition, false,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.910 -0400", hash_original_method = "5884A689188772E4B067D85FA0FE2485", hash_generated_method = "7102491CB33BC10C98F7569F08A7F769")
    public void showFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mHidden = false;
            {
                Animation anim = loadAnimation(fragment, transition, true,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.910 -0400", hash_original_method = "8ADA384A2A804F3DB8950E51751AE080", hash_generated_method = "9F640DA7E8398ABB9D4A1DE5EEF1913E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.911 -0400", hash_original_method = "C689EB45F7FDDB493496798809CCC982", hash_generated_method = "DD623ACB15728D19AB1E401EC9C2C108")
    public void attachFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mDetached = false;
            {
                {
                    mAdded = new ArrayList<Fragment>();
                } //End block
                {
                    boolean var4A590CAC6EAAD99B8C32C7FE40C0A339_1103614726 = (mAdded.contains(fragment));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.912 -0400", hash_original_method = "369BBF881289C60802E9A80BDB6F1062", hash_generated_method = "0C1F1461BF0A401511A2321B56CEB633")
    public Fragment findFragmentById(int id) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_514448648 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_767126228 = null; //Variable for return #2
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1059867159 = null; //Variable for return #3
        {
            {
                int i = mAdded.size()-1;
                {
                    Fragment f = mAdded.get(i);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_514448648 = f;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i = mActive.size()-1;
                {
                    Fragment f = mActive.get(i);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_767126228 = f;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1059867159 = null;
        addTaint(id);
        Fragment varA7E53CE21691AB073D9660D615818899_575540808; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_575540808 = varB4EAC82CA7396A68D541C85D26508E83_514448648;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_575540808 = varB4EAC82CA7396A68D541C85D26508E83_767126228;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_575540808 = varB4EAC82CA7396A68D541C85D26508E83_1059867159;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_575540808.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_575540808;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.914 -0400", hash_original_method = "A116F7F22C8FEEEBB3418EA3417C69EB", hash_generated_method = "04B708D305DF77E29396F7A8B76E926D")
    public Fragment findFragmentByTag(String tag) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1724141520 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_586914462 = null; //Variable for return #2
        Fragment varB4EAC82CA7396A68D541C85D26508E83_824452024 = null; //Variable for return #3
        {
            {
                int i = mAdded.size()-1;
                {
                    Fragment f = mAdded.get(i);
                    {
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_1172125280 = (f != null && tag.equals(f.mTag));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1724141520 = f;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            {
                int i = mActive.size()-1;
                {
                    Fragment f = mActive.get(i);
                    {
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_1436274038 = (f != null && tag.equals(f.mTag));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_586914462 = f;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_824452024 = null;
        addTaint(tag.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_149406698; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_149406698 = varB4EAC82CA7396A68D541C85D26508E83_1724141520;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_149406698 = varB4EAC82CA7396A68D541C85D26508E83_586914462;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_149406698 = varB4EAC82CA7396A68D541C85D26508E83_824452024;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_149406698.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_149406698;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.916 -0400", hash_original_method = "9082D0FF97F62C4058EE52B6A6365151", hash_generated_method = "2BB991F35E07A07A9A73823EE8ED7477")
    public Fragment findFragmentByWho(String who) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1130456043 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_915222647 = null; //Variable for return #2
        {
            {
                int i = mActive.size()-1;
                {
                    Fragment f = mActive.get(i);
                    {
                        boolean var8C929A471928159D9F345C3B4316EAE7_1874870198 = (f != null && (f=f.findFragmentByWho(who)) != null);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1130456043 = f;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_915222647 = null;
        addTaint(who.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_353897038; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_353897038 = varB4EAC82CA7396A68D541C85D26508E83_1130456043;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_353897038 = varB4EAC82CA7396A68D541C85D26508E83_915222647;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_353897038.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_353897038;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.916 -0400", hash_original_method = "B87B380B690A16EB7F37B7EE1C0A0D26", hash_generated_method = "4076EE59F13ECCD4B07230734A017E5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.917 -0400", hash_original_method = "32359130EC903AF4E096237D1F067453", hash_generated_method = "D7C4B73CD27B8A5B1386D49D6E2BABB6")
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
                boolean varED396C6F84781DC21825B4A03F526E3B_60479198 = (mPendingActions.size() == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.917 -0400", hash_original_method = "1503673DA6CC1FF53261337C6A89F6BE", hash_generated_method = "F24B1A100F07A4D1F2EB420C3874751C")
    public int allocBackStackIndex(BackStackRecord bse) {
        {
            {
                boolean var98612EE02F6CF00DE971BBFA890C1BB0_1772506730 = (mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0);
                {
                    {
                        mBackStackIndices = new ArrayList<BackStackRecord>();
                    } //End block
                    int index = mBackStackIndices.size();
                    mBackStackIndices.add(bse);
                } //End block
                {
                    int index = mAvailBackStackIndices.remove(mAvailBackStackIndices.size()-1);
                    mBackStackIndices.set(index, bse);
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(bse.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114825148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_114825148;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.918 -0400", hash_original_method = "F0AF804A23A686630C8F5E2012EB99F7", hash_generated_method = "EBA023A4351056E75951D9F29267B91A")
    public void setBackStackIndex(int index, BackStackRecord bse) {
        {
            {
                mBackStackIndices = new ArrayList<BackStackRecord>();
            } //End block
            int N = mBackStackIndices.size();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.918 -0400", hash_original_method = "A75FE5CB17552EA725360407924677A5", hash_generated_method = "AFDDA9DE97FC9DF3E5F4BF723FE82F1A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.919 -0400", hash_original_method = "2EC9B9D8ABC4926EA1F7FF85BE00D458", hash_generated_method = "8162E18DF525E3B1A721DFBD71291715")
    public boolean execPendingActions() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Recursive entry to executePendingTransactions");
        } //End block
        {
            boolean var92CCD900C583B95C908C1457DCFC97EB_1446185551 = (Looper.myLooper() != mActivity.mHandler.getLooper());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Must be called from main thread of process");
            } //End block
        } //End collapsed parenthetic
        boolean didSomething = false;
        {
            int numActions;
            {
                {
                    boolean var8F64D3B59DFFB1D978D9FFAE1E7D437D_271752804 = (mPendingActions == null || mPendingActions.size() == 0);
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
                int i = 0;
                {
                    mTmpActions[i].run();
                    mTmpActions[i] = null;
                } //End block
            } //End collapsed parenthetic
            mExecutingActions = false;
            didSomething = true;
        } //End block
        {
            boolean loadersRunning = false;
            {
                int i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_1375046188 = (i<mActive.size());
                {
                    Fragment f = mActive.get(i);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_703860431 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_703860431;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.919 -0400", hash_original_method = "480CA24D6CDDA51ECD1DFDE903041169", hash_generated_method = "DBCCAD4089B54BCB92D36CCF7E6E364B")
     void reportBackStackChanged() {
        {
            {
                int i = 0;
                boolean var3737AEDF4226FD639F6461E15393E309_1437665562 = (i<mBackStackChangeListeners.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.920 -0400", hash_original_method = "93C61FA561A07CB0E9B057A7A904C282", hash_generated_method = "FF183CDFF9871413611B0CFF67FE69C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.921 -0400", hash_original_method = "2DCA4D0949EEA78B53FF55FD7B1EE1F8", hash_generated_method = "F9F055F46F60C2F9FEFDDECEDEB86AC5")
     boolean popBackStackState(Handler handler, String name, int id, int flags) {
        {
            int last = mBackStack.size()-1;
            final BackStackRecord bss = mBackStack.remove(last);
            bss.popFromBackStack(true);
            reportBackStackChanged();
        } //End block
        {
            int index = -1;
            {
                index = mBackStack.size()-1;
                {
                    BackStackRecord bss = mBackStack.get(index);
                    {
                        boolean varBEA6676FD08F9A893EB03C8E97D94F9C_1593279717 = (name != null && name.equals(bss.getName()));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        BackStackRecord bss = mBackStack.get(index);
                        {
                            boolean varF7B12DD1A8F871B2F43DC36592D3ADBE_360150499 = ((name != null && name.equals(bss.getName()))
                                || (id >= 0 && id == bss.mIndex));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
            {
                boolean var4A958E5CC0AD80F8568B9E8089EACA0B_404129255 = (index == mBackStack.size()-1);
            } //End collapsed parenthetic
            final ArrayList<BackStackRecord> states = new ArrayList<BackStackRecord>();
            {
                int i = mBackStack.size()-1;
                {
                    states.add(mBackStack.remove(i));
                } //End block
            } //End collapsed parenthetic
            final int LAST = states.size()-1;
            {
                int i = 0;
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_355967538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_355967538;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.922 -0400", hash_original_method = "4601075007D50CE0BCD1D759D668CB84", hash_generated_method = "4469AED72CA90CB8D9AB58872EE9795D")
     ArrayList<Fragment> retainNonConfig() {
        ArrayList<Fragment> varB4EAC82CA7396A68D541C85D26508E83_436360703 = null; //Variable for return #1
        ArrayList<Fragment> fragments = null;
        {
            {
                int i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_843661591 = (i<mActive.size());
                {
                    Fragment f = mActive.get(i);
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
        varB4EAC82CA7396A68D541C85D26508E83_436360703 = fragments;
        varB4EAC82CA7396A68D541C85D26508E83_436360703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_436360703;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.923 -0400", hash_original_method = "AB64A806E53952D63B221B8A02A39B9D", hash_generated_method = "B485D88A97874546908319C1F07AA4DF")
     void saveFragmentViewState(Fragment f) {
        {
            mStateArray = new SparseArray<Parcelable>();
        } //End block
        {
            mStateArray.clear();
        } //End block
        f.mInnerView.saveHierarchyState(mStateArray);
        {
            boolean var10CB5DFFB182D477A1F1C08C2A2A4D10_677290175 = (mStateArray.size() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.925 -0400", hash_original_method = "4EAE6A1450E2744D0D17A0CBB3487A4E", hash_generated_method = "AD9E8E2554660DC296DB9CB821C05852")
     Bundle saveFragmentBasicState(Fragment f) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_625635829 = null; //Variable for return #1
        Bundle result = null;
        {
            mStateBundle = new Bundle();
        } //End block
        f.performSaveInstanceState(mStateBundle);
        {
            boolean var5AE1326457CED87C792B211942E81B2E_960926522 = (!mStateBundle.isEmpty());
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
        varB4EAC82CA7396A68D541C85D26508E83_625635829 = result;
        addTaint(f.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_625635829.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_625635829;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.927 -0400", hash_original_method = "10343325EA0A9B349A8A31D89021E4C8", hash_generated_method = "2C98357A162EE23BBF45591B1EB9AF3B")
     Parcelable saveAllState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1595042848 = null; //Variable for return #1
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_843489947 = null; //Variable for return #2
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1402414558 = null; //Variable for return #3
        execPendingActions();
        {
            mStateSaved = true;
        } //End block
        {
            boolean var7B1A0FE06CC77C5BE5C8EE27C706FD90_797041978 = (mActive == null || mActive.size() <= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1595042848 = null;
            } //End block
        } //End collapsed parenthetic
        int N = mActive.size();
        FragmentState[] active = new FragmentState[N];
        boolean haveFragments = false;
        {
            int i = 0;
            {
                Fragment f = mActive.get(i);
                {
                    {
                        throwException(new IllegalStateException(
                            "Failure saving state: active " + f
                            + " has cleared index: " + f.mIndex));
                    } //End block
                    haveFragments = true;
                    FragmentState fs = new FragmentState(f);
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
            varB4EAC82CA7396A68D541C85D26508E83_843489947 = null;
        } //End block
        int[] added = null;
        BackStackState[] backStack = null;
        {
            N = mAdded.size();
            {
                added = new int[N];
                {
                    int i = 0;
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
                    int i = 0;
                    {
                        backStack[i] = new BackStackState(this, mBackStack.get(i));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End block
        FragmentManagerState fms = new FragmentManagerState();
        fms.mActive = active;
        fms.mAdded = added;
        fms.mBackStack = backStack;
        varB4EAC82CA7396A68D541C85D26508E83_1402414558 = fms;
        Parcelable varA7E53CE21691AB073D9660D615818899_1999692244; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1999692244 = varB4EAC82CA7396A68D541C85D26508E83_1595042848;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1999692244 = varB4EAC82CA7396A68D541C85D26508E83_843489947;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1999692244 = varB4EAC82CA7396A68D541C85D26508E83_1402414558;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1999692244.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1999692244;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.929 -0400", hash_original_method = "83508419770250A244151298D1C277A7", hash_generated_method = "9F4099F1EDADD05D70C7D3603FD52B3D")
     void restoreAllState(Parcelable state, ArrayList<Fragment> nonConfig) {
        FragmentManagerState fms = (FragmentManagerState)state;
        {
            {
                int i = 0;
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_2004957431 = (i<nonConfig.size());
                {
                    Fragment f = nonConfig.get(i);
                    FragmentState fs = fms.mActive[f.mIndex];
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
            int i = 0;
            {
                FragmentState fs = fms.mActive[i];
                {
                    Fragment f = fs.instantiate(mActivity, mParent);
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
                int i = 0;
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_1311595869 = (i<nonConfig.size());
                {
                    Fragment f = nonConfig.get(i);
                    {
                        {
                            boolean var487621A5D4BD2ACED481B16F5F5948D3_1201679379 = (f.mTargetIndex < mActive.size());
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
                int i = 0;
                {
                    Fragment f = mActive.get(fms.mAdded[i]);
                    {
                        throwException(new IllegalStateException(
                            "No instantiated fragment for index #" + fms.mAdded[i]));
                    } //End block
                    f.mAdded = true;
                    {
                        boolean var9BF1C25340280F172CE0222A135FE437_613086145 = (mAdded.contains(f));
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
                int i = 0;
                {
                    BackStackRecord bse = fms.mBackStack[i].instantiate(this);
                    {
                        LogWriter logw = new LogWriter(TAG);
                        PrintWriter pw = new PrintWriter(logw);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.930 -0400", hash_original_method = "6B9797EDFBB2C38037CA64E1EEB36778", hash_generated_method = "21267ED483B445873A924C400C2D5F96")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.930 -0400", hash_original_method = "9E4E3FCA42BDE19CBF71140223B4B8D0", hash_generated_method = "B5C7E72CCEE273A62746EE3408615591")
    public void noteStateNotSaved() {
        mStateSaved = false;
        // ---------- Original Method ----------
        //mStateSaved = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.931 -0400", hash_original_method = "4EAFC4D017ED2B44474902CD00BD047E", hash_generated_method = "21C3627E95BE86042A719066A2913EA6")
    public void dispatchCreate() {
        mStateSaved = false;
        moveToState(Fragment.CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.931 -0400", hash_original_method = "BB3D6B45374259B5EE70270EF5FFE721", hash_generated_method = "1F7202ED50DB7895525D3D5DD1A85A9D")
    public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(Fragment.ACTIVITY_CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.ACTIVITY_CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.932 -0400", hash_original_method = "145C9AF81AEB697CB534D8E0C0F599A0", hash_generated_method = "20844DC4E325108731D69AD369D5CB9A")
    public void dispatchStart() {
        mStateSaved = false;
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.932 -0400", hash_original_method = "35325401D14378833F40C78A6FC3DC5D", hash_generated_method = "9E4D22D120F9A6B67EA4BB2B4DEB3341")
    public void dispatchResume() {
        mStateSaved = false;
        moveToState(Fragment.RESUMED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.RESUMED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.932 -0400", hash_original_method = "E6EE1A1408209BDB9066272C26AA9863", hash_generated_method = "806CEF702E5812DC1949A4F8EE32F575")
    public void dispatchPause() {
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.933 -0400", hash_original_method = "A6766C0F069AFB58F0A12165F2E095FC", hash_generated_method = "2DD793A778E88D54EE3A335BA8F3FB22")
    public void dispatchStop() {
        mStateSaved = true;
        moveToState(Fragment.STOPPED, false);
        // ---------- Original Method ----------
        //mStateSaved = true;
        //moveToState(Fragment.STOPPED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.933 -0400", hash_original_method = "DCD943307D69805205EE4AFFC6D1EFE3", hash_generated_method = "89E0EF721C47E2DF40831E82789D0DE5")
    public void dispatchReallyStop() {
        moveToState(Fragment.ACTIVITY_CREATED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.ACTIVITY_CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.934 -0400", hash_original_method = "69F58A9B4E2F72C0D627B376DB1A1CDC", hash_generated_method = "7C0C65D29ADA12A03B42DDDA4BE52A2A")
    public void dispatchDestroyView() {
        moveToState(Fragment.CREATED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.935 -0400", hash_original_method = "92EF0F88C8A3B3CDE2712CBD7D916058", hash_generated_method = "4183A75BEA237931F279EC68B16055AF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.935 -0400", hash_original_method = "3F9069EC8564151620B164A5CADDDD85", hash_generated_method = "87B1A1061AFE69740A7DA909BD673990")
    public void dispatchConfigurationChanged(Configuration newConfig) {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_138734712 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.936 -0400", hash_original_method = "423006F51D0218BAC00AF0FAAABB2869", hash_generated_method = "704C4E81EFCDA4CE08C075E582CCFB05")
    public void dispatchLowMemory() {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1261560763 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.952 -0400", hash_original_method = "E04D4A6462A884A432217EF1D5562FD6", hash_generated_method = "EB0CD9B2E18BF808E4A58A3CF23856E4")
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1220434486 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        {
                            boolean var2BD7DDEAB658B1A7B29311D300A3B085_164858607 = (f.performCreateOptionsMenu(menu, inflater));
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
                int i = 0;
                boolean var829574F28570EB1E74183020953B6E4B_2017053548 = (i<mCreatedMenus.size());
                {
                    Fragment f = mCreatedMenus.get(i);
                    {
                        boolean varF740BD6A5A57A11B5D73D0A67A04AEFC_1900843354 = (newMenus == null || !newMenus.contains(f));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_310603256 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_310603256;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.953 -0400", hash_original_method = "39A1BE180E5A6D21A2BE9889A37AE1EE", hash_generated_method = "8E6F431ED98C590B38663D9172491443")
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean show = false;
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_186164434 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        {
                            boolean var7A9D124B4B5ACA00D3EAF8F312D52005_617637376 = (f.performPrepareOptionsMenu(menu));
                            {
                                show = true;
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_481564870 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_481564870;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.953 -0400", hash_original_method = "40C97B67F40ABFD093891951534367FF", hash_generated_method = "714F3B22E11B23BCB5BA55CC81D8F96D")
    public boolean dispatchOptionsItemSelected(MenuItem item) {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_832338988 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        {
                            boolean var5564C9E1EB2E8953D0F00B48E89AFC17_556523297 = (f.performOptionsItemSelected(item));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_76409892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_76409892;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.954 -0400", hash_original_method = "61E677AAD1D9B7A657F2B5668ED52005", hash_generated_method = "BDFAC56A9789654AEDA4DFC4647A3E3F")
    public boolean dispatchContextItemSelected(MenuItem item) {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1866517217 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        {
                            boolean var4AA73CE006242FE3515CA0A67DA79788_1687893643 = (f.performContextItemSelected(item));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1940450684 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1940450684;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.954 -0400", hash_original_method = "6CB4593DD4D25806442B1A7EB0939595", hash_generated_method = "2C7A12C7894E59A21BDF6CABA177B26F")
    public void dispatchOptionsMenuClosed(Menu menu) {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1371632736 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "309AAD3E76F171051A35712763096DE8", hash_generated_field = "82CCA249F4AC6A9E8A18392D953FCA5D")

    static final String TAG = "FragmentManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "F97D1635AABE57FB12E9B1B2518064C6", hash_generated_field = "47802C2B46813E58B899D23FD9DC343B")

    static final boolean HONEYCOMB = android.os.Build.VERSION.SDK_INT >= 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "E58DEFB2E4C5F4C4BC898BC35F33C192", hash_generated_field = "3B27731C0E9DDDFC7028C0BFB720297D")

    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "A8D8A7593440E0D7D4A8A21F4BCD6D54", hash_generated_field = "9220E2EDA94C70BA7341F1BFB405D6BF")

    static final String TARGET_STATE_TAG = "android:target_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "03990A2696101FE20E375C710E3F3AE1", hash_generated_field = "C8F5F7A2B0A3F70631E3897CD07F0E4E")

    static final String VIEW_STATE_TAG = "android:view_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "80B57815D7CE7602226A48E51B42D058", hash_generated_field = "43219A21E686E6FEC3DF87B97E67132D")

    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "6C95BC8E2A60A9F4236FBFC95395E3A2", hash_generated_field = "3A10D2877F43112AA0B7A6A8433E95CB")

    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "D8281C96E9514BF04DE392578617576C", hash_generated_field = "1618232FF2C96BF54619A71799992CCF")

    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "D10DC5918CDE7E82CA9095D02FEF8A0C", hash_generated_field = "50DFC5BE4E88ED2E03493326FAE40E99")

    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "838B2B5AA8359A71F94BB598DD8FD304", hash_generated_field = "0650545F9518BF159E5600383DFE2395")

    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "1A243DE04BDCF448B42B90B6C7D09AB2", hash_generated_field = "71044A5396C27203930538888DCB79FC")

    static final int ANIM_DUR = 220;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "260F4A8077B41158EE5084820597CDFE", hash_generated_field = "7BB089DC1B8A242E88755BDA8C8238B9")

    public static final int ANIM_STYLE_OPEN_ENTER = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "519D0B58F7134135D9F630C9958BA2A5", hash_generated_field = "3C4C6A69EA30C5B582DE8DD757B46311")

    public static final int ANIM_STYLE_OPEN_EXIT = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "809B49B33A269DC9ED63B13FAE899E5D", hash_generated_field = "B289F5FCA54C37F25FF23F46A1D8D232")

    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "B7C90BEFCC36650797B1A5C0EAE37430", hash_generated_field = "913DA58C0421DE752A939A21044C5DD0")

    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "E8EC520365F556FDD343EE5BF52DC8EF", hash_generated_field = "6EE14C70EFD271C2B32055938BC50C20")

    public static final int ANIM_STYLE_FADE_ENTER = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.955 -0400", hash_original_field = "BDA176AA41F039DA1615DEC8A570C95D", hash_generated_field = "F489982675E5C10DFACA93BE86E50D4D")

    public static final int ANIM_STYLE_FADE_EXIT = 6;
}

