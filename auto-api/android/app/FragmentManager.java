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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.145 -0400", hash_original_method = "0D3FEDE97BC3242ED64134E1F014EA11", hash_generated_method = "0D3FEDE97BC3242ED64134E1F014EA11")
    public FragmentManager ()
    {
        //Synthesized constructor
    }


    public abstract FragmentTransaction beginTransaction();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.154 -0400", hash_original_method = "0DA67415D41DB3C4C9D7AB80CD2D78FE", hash_generated_method = "D34E787DA79921E7F77C4D229314D74A")
    @Deprecated
    public FragmentTransaction openTransaction() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_2128183756 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2128183756 = beginTransaction();
        varB4EAC82CA7396A68D541C85D26508E83_2128183756.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2128183756;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.259 -0400", hash_original_method = "15ED404039200ACA8749491C77846D3D", hash_generated_method = "DBB7CD62A7EC5E14380DEAAF62A330E3")
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.273 -0400", hash_original_field = "F2813E5BD6A379A2985E370BE1887EDA", hash_generated_field = "3F74866CBC8F49655F2B8BB97CC17F5E")

    public static final int POP_BACK_STACK_INCLUSIVE = 1<<0;
}

final class FragmentManagerState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.273 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "0C91046A014C3ABDDA41BA020BEE7D35")

    FragmentState[] mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.274 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "4D5C3ED026B5D0195A6077AFCD696836")

    int[] mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.274 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "EEA20C5C67D270067553BCDE313A7B27")

    BackStackState[] mBackStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.282 -0400", hash_original_method = "4ADB2DBBD6899E89144480A7958A6490", hash_generated_method = "252DFEAE0ECB79838960A8B564DE42F6")
    public  FragmentManagerState() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.305 -0400", hash_original_method = "020574327F1D57965B67553DD6F7D979", hash_generated_method = "F858C24C16C6DB16663BD3817D53ADD9")
    public  FragmentManagerState(Parcel in) {
        mActive = in.createTypedArray(FragmentState.CREATOR);
        mAdded = in.createIntArray();
        mBackStack = in.createTypedArray(BackStackState.CREATOR);
        // ---------- Original Method ----------
        //mActive = in.createTypedArray(FragmentState.CREATOR);
        //mAdded = in.createIntArray();
        //mBackStack = in.createTypedArray(BackStackState.CREATOR);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.308 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C1A5A905E6F91D760CC8B3EF8DA1D1B7")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959449980 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1959449980;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.309 -0400", hash_original_method = "B6654BF7A24842DC15E6AD3A5F27203C", hash_generated_method = "755001DC0FEE505DA71D76177C4F11BA")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.309 -0400", hash_original_field = "D29AA2723BAE7915447DC2F30F3AAA56", hash_generated_field = "EE9672AF4023C35BB0D72B0356E5DA5C")

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

final class FragmentManagerImpl extends FragmentManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.315 -0400", hash_original_field = "327C9FAD23CE4030098BE2DE91837CF7", hash_generated_field = "11FD18D208B09E922FC03FBF68E7335B")

    ArrayList<Runnable> mPendingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.315 -0400", hash_original_field = "E3843751CB2154B155E225749A18D620", hash_generated_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3")

    Runnable[] mTmpActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.316 -0400", hash_original_field = "CDD41116A3EE1465C2308845599CA08D", hash_generated_field = "CD4485F6F525738DAA0EA0DC245911AB")

    boolean mExecutingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.317 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "A1650882FA43FC001601740ED87DBA1F")

    ArrayList<Fragment> mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.322 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "FF37605B8D813171195C0EBF92B2A116")

    ArrayList<Fragment> mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.322 -0400", hash_original_field = "CD7D957830B65DDE14B44534836CDCFA", hash_generated_field = "5441838D07CA3D72A0FE3BB98FAAC33E")

    ArrayList<Integer> mAvailIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.323 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "A66A7C10189C949E8CDC007D4D07280E")

    ArrayList<BackStackRecord> mBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.323 -0400", hash_original_field = "07EBA043D3FF90523B37550E5D9B91E4", hash_generated_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7")

    ArrayList<Fragment> mCreatedMenus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.332 -0400", hash_original_field = "A06EFC21545AC26226ABF57556E73291", hash_generated_field = "89571A39B2AB736200FBD57A213BDB4D")

    ArrayList<BackStackRecord> mBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.350 -0400", hash_original_field = "A96F62FC59DD2FAE4327C1E7855AE979", hash_generated_field = "27AED91E8586753C6865FA558A4716C8")

    ArrayList<Integer> mAvailBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.351 -0400", hash_original_field = "D0295B7D6BE1788760CAFE41F824D774", hash_generated_field = "078DA2C7CA0D4289F90F664D0B3EDB3B")

    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.352 -0400", hash_original_field = "C81B2F53A65D169421FFBC0C3AC986EE", hash_generated_field = "9521C64640071A41BA8B18982DEC3BE2")

    int mCurState = Fragment.INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.352 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.357 -0400", hash_original_field = "1ED82791F588E1B933718ECC0041EE63", hash_generated_field = "19DD0E42F9FC244F37062274E8F2012D")

    boolean mNeedMenuInvalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.358 -0400", hash_original_field = "5C1552B132EB06695090E74F8854ED21", hash_generated_field = "E68067DB35DA8BD96BFB5C858DBE74BF")

    boolean mStateSaved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.358 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

    boolean mDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.359 -0400", hash_original_field = "1ECE9D4CB2FBE961BEE64D8760E25D34", hash_generated_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE")

    String mNoTransactionsBecause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.374 -0400", hash_original_field = "20E894967D971C1F65FB2EA61F367BAE", hash_generated_field = "79BC4D349D09DCA85692E9FAD9D9C6F7")

    boolean mHavePendingDeferredStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.375 -0400", hash_original_field = "D0B68049F76228FB1A7F03664CE569DE", hash_generated_field = "92A56B8032395A53760143DE797F97FA")

    Bundle mStateBundle = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.375 -0400", hash_original_field = "EA03FEC1D1BDCAB5D2BD8A3D0ADCF67E", hash_generated_field = "280BE7FE9228C6CA67328AF4B4B28047")

    SparseArray<Parcelable> mStateArray = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.387 -0400", hash_original_field = "BB4C35BD7F2BC82D3F4C38422B568E9B", hash_generated_field = "4DE854002F67C22E0D1608D86BF878E6")

    Runnable mExecCommit = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.377 -0400", hash_original_method = "C2BA1C69EB0B4CCFF1A319535DB79508", hash_generated_method = "FEDC918E58215E12D8175F59CA2BA6B4")
        @Override
        public void run() {
            execPendingActions();
            // ---------- Original Method ----------
            //execPendingActions();
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.388 -0400", hash_original_method = "57A648A59831AB7BB1637AFC6125C81E", hash_generated_method = "57A648A59831AB7BB1637AFC6125C81E")
    public FragmentManagerImpl ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.403 -0400", hash_original_method = "FD4DF6D1DA8CD9545895F43FA5CF7B0B", hash_generated_method = "2619E209871B6F821C1F41C59363B5D9")
    @Override
    public FragmentTransaction beginTransaction() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1550195203 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1550195203 = new BackStackRecord(this);
        varB4EAC82CA7396A68D541C85D26508E83_1550195203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1550195203;
        // ---------- Original Method ----------
        //return new BackStackRecord(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.405 -0400", hash_original_method = "082964FFA3913D960E19EEB76BD9505B", hash_generated_method = "0ED13773753920EB1339CAB9964DA412")
    @Override
    public boolean executePendingTransactions() {
        boolean varDEC74AD03B6C92C5F58BDD6F9B78062F_1320538308 = (execPendingActions());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_189279175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_189279175;
        // ---------- Original Method ----------
        //return execPendingActions();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.422 -0400", hash_original_method = "5CB88371A39240A7C2FB2F2041C5DD0D", hash_generated_method = "403BBF4BE90522AB9C8142CCD88383B9")
    @Override
    public void popBackStack() {
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.421 -0400", hash_original_method = "C15C9D80C4BF4FB6B2AF0B93A4449441", hash_generated_method = "B3F70B584C16FE3B98A16E26008D78C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.436 -0400", hash_original_method = "B7072E2D8E1B8CAC03251D641D234641", hash_generated_method = "0684014C005DC0BCB509E3C9410DD9AF")
    @Override
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        boolean varE659918100A3B568A6F3D267CDA15217_1305676604 = (popBackStackState(mActivity.mHandler, null, -1, 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_185756475 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_185756475;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, null, -1, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.441 -0400", hash_original_method = "9E86D2BA46D98A91B2D43097CFA7F639", hash_generated_method = "DEFAA96F0AD7B9098379216EDDFE6405")
    @Override
    public void popBackStack(final String name, final int flags) {
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.441 -0400", hash_original_method = "22FC8A6DB6B4AB9E651D01E64BEED72A", hash_generated_method = "3FE29178F98A070A5E0ED21762A74700")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.459 -0400", hash_original_method = "4DEC43188CEAB5FA4EF2839673649ECC", hash_generated_method = "CC837D15B469281822925F42CB1B80C8")
    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        checkStateLoss();
        executePendingTransactions();
        boolean var8537C2C3238620E29A2DABFDDEEAED83_565182947 = (popBackStackState(mActivity.mHandler, name, -1, flags));
        addTaint(name.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1676425439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1676425439;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //return popBackStackState(mActivity.mHandler, name, -1, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.466 -0400", hash_original_method = "DA57C1B5DA7DBD65A6FF7556F6C0B827", hash_generated_method = "03045A86B75581742E58B4B314D46A5C")
    @Override
    public void popBackStack(final int id, final int flags) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } //End block
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.466 -0400", hash_original_method = "DBCE7037D51EB5153CDA373E6D392F0E", hash_generated_method = "905DCE3DB8D6804FD0D561A3F3EB2065")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.471 -0400", hash_original_method = "C28CBCAD3FA2084F032C85B006AF0CA6", hash_generated_method = "C70265D5A6C9B4A6121BE5043FF30E0B")
    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        checkStateLoss();
        executePendingTransactions();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } //End block
        boolean var4EE663DB9CE1C64C129233E54BE6C6E6_622524035 = (popBackStackState(mActivity.mHandler, null, id, flags));
        addTaint(id);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1866358103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1866358103;
        // ---------- Original Method ----------
        //checkStateLoss();
        //executePendingTransactions();
        //if (id < 0) {
            //throw new IllegalArgumentException("Bad id: " + id);
        //}
        //return popBackStackState(mActivity.mHandler, null, id, flags);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.486 -0400", hash_original_method = "81448DC3AD62196301F3A4A762AB09A8", hash_generated_method = "C2DA22F38F28FA7F19F230BD07016817")
    @Override
    public int getBackStackEntryCount() {
        {
            Object var0D23A520C4639C79F477D4746DB89D7E_1588280443 = (mBackStack.size());
        } //End flattened ternary
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907610849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_907610849;
        // ---------- Original Method ----------
        //return mBackStack != null ? mBackStack.size() : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.505 -0400", hash_original_method = "898A7E40DF942FAA7422F0070AE7C2C0", hash_generated_method = "E3CD3C32E31F0421DE6FCE01901EAE1E")
    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        BackStackEntry varB4EAC82CA7396A68D541C85D26508E83_2101387354 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2101387354 = mBackStack.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_2101387354.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2101387354;
        // ---------- Original Method ----------
        //return mBackStack.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.509 -0400", hash_original_method = "5B02C223CD8F1AC3632AF80A3BE5FAF1", hash_generated_method = "B50FC75A1E09A20DD3B47627FFC2F2BF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.525 -0400", hash_original_method = "0EB71E2FD8D5B96EE15FDFA4CFDC7A3A", hash_generated_method = "67C87F2824D7F39E431B9C463BEFAAFD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.543 -0400", hash_original_method = "28A5058460B6EF16DD9CEE59F403CB5D", hash_generated_method = "FCB00791B6DFB1AADBCBAFE5342A08A5")
    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
        } //End block
        bundle.putInt(key, fragment.mIndex);
        addTaint(bundle.getTaint());
        addTaint(key.getTaint());
        addTaint(fragment.getTaint());
        // ---------- Original Method ----------
        //if (fragment.mIndex < 0) {
            //throw new IllegalStateException("Fragment " + fragment
                    //+ " is not currently in the FragmentManager");
        //}
        //bundle.putInt(key, fragment.mIndex);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.570 -0400", hash_original_method = "D08899B1EE8437F622E0D7F7BA40A91F", hash_generated_method = "021FFEAD6DA5406C4A1D6236F7D05CF2")
    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_452352793 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_580740009 = null; //Variable for return #2
        int index;
        index = bundle.getInt(key, -1);
        {
            varB4EAC82CA7396A68D541C85D26508E83_452352793 = null;
        } //End block
        {
            boolean var107AB73BAE9815E9603DA2E7CAF7C8B7_1846034193 = (index >= mActive.size());
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
        varB4EAC82CA7396A68D541C85D26508E83_580740009 = f;
        addTaint(bundle.getTaint());
        addTaint(key.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_1706387963; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1706387963 = varB4EAC82CA7396A68D541C85D26508E83_452352793;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1706387963 = varB4EAC82CA7396A68D541C85D26508E83_580740009;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1706387963.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1706387963;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.578 -0400", hash_original_method = "CF6272FD6214D7D7484637054FD9E74F", hash_generated_method = "29EC10B12371920482853B62F537525F")
    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Fragment.SavedState varB4EAC82CA7396A68D541C85D26508E83_1281993150 = null; //Variable for return #1
        Fragment.SavedState varB4EAC82CA7396A68D541C85D26508E83_666286555 = null; //Variable for return #2
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
        } //End block
        {
            Bundle result;
            result = saveFragmentBasicState(fragment);
            varB4EAC82CA7396A68D541C85D26508E83_1281993150 = result != null ? new Fragment.SavedState(result) : null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_666286555 = null;
        addTaint(fragment.getTaint());
        Fragment.SavedState varA7E53CE21691AB073D9660D615818899_56686837; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_56686837 = varB4EAC82CA7396A68D541C85D26508E83_1281993150;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_56686837 = varB4EAC82CA7396A68D541C85D26508E83_666286555;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_56686837.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_56686837;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.591 -0400", hash_original_method = "A7D5B4266978FAAC75BAC34E53BDC41B", hash_generated_method = "B3C1F509F719A8CA3AB06482E2EE357B")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1528395719 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        varB4EAC82CA7396A68D541C85D26508E83_1528395719 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1528395719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1528395719;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //sb.append("FragmentManager{");
        //sb.append(Integer.toHexString(System.identityHashCode(this)));
        //sb.append(" in ");
        //DebugUtils.buildShortClassTag(mActivity, sb);
        //sb.append("}}");
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.637 -0400", hash_original_method = "0EF991BB6A19DFA56B66936C5498080A", hash_generated_method = "458902A2FA901A771EF6AD644F7C8795")
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
                boolean varC3EC129F2815C61E4CC968B0C16B5E00_1763352958 = (mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0);
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
            boolean varD0CA0404E33A0C2149F9FC712F4B1B56_2004972471 = (mAvailIndices != null && mAvailIndices.size() > 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.666 -0400", hash_original_method = "8FB9E657DCE437B207C489B8932863BA", hash_generated_method = "1D17CF5464010027F48D51CB859443B7")
     Animator loadAnimator(Fragment fragment, int transit, boolean enter,
            int transitionStyle) {
        Animator varB4EAC82CA7396A68D541C85D26508E83_258667233 = null; //Variable for return #1
        Animator varB4EAC82CA7396A68D541C85D26508E83_165170034 = null; //Variable for return #2
        Animator varB4EAC82CA7396A68D541C85D26508E83_1238010169 = null; //Variable for return #3
        Animator varB4EAC82CA7396A68D541C85D26508E83_477835204 = null; //Variable for return #4
        Animator varB4EAC82CA7396A68D541C85D26508E83_60064253 = null; //Variable for return #5
        Animator varB4EAC82CA7396A68D541C85D26508E83_1648260651 = null; //Variable for return #6
        Animator varB4EAC82CA7396A68D541C85D26508E83_1595021982 = null; //Variable for return #7
        Animator animObj;
        animObj = fragment.onCreateAnimator(transit, enter,
                fragment.mNextAnim);
        {
            varB4EAC82CA7396A68D541C85D26508E83_258667233 = animObj;
        } //End block
        {
            Animator anim;
            anim = AnimatorInflater.loadAnimator(mActivity, fragment.mNextAnim);
            {
                varB4EAC82CA7396A68D541C85D26508E83_165170034 = anim;
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1238010169 = null;
        } //End block
        int styleIndex;
        styleIndex = transitToStyleIndex(transit, enter);
        {
            varB4EAC82CA7396A68D541C85D26508E83_477835204 = null;
        } //End block
        {
            boolean var7E1D31F47E4E5D9D781C22ACD7E0177E_1851815871 = (transitionStyle == 0 && mActivity.getWindow() != null);
            {
                transitionStyle = mActivity.getWindow().getAttributes().windowAnimations;
            } //End block
        } //End collapsed parenthetic
        {
            varB4EAC82CA7396A68D541C85D26508E83_60064253 = null;
        } //End block
        TypedArray attrs;
        attrs = mActivity.obtainStyledAttributes(transitionStyle,
                com.android.internal.R.styleable.FragmentAnimation);
        int anim;
        anim = attrs.getResourceId(styleIndex, 0);
        attrs.recycle();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1648260651 = null;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1595021982 = AnimatorInflater.loadAnimator(mActivity, anim);
        addTaint(fragment.getTaint());
        addTaint(transit);
        addTaint(enter);
        addTaint(transitionStyle);
        Animator varA7E53CE21691AB073D9660D615818899_1263416459; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1263416459 = varB4EAC82CA7396A68D541C85D26508E83_258667233;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1263416459 = varB4EAC82CA7396A68D541C85D26508E83_165170034;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1263416459 = varB4EAC82CA7396A68D541C85D26508E83_1238010169;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1263416459 = varB4EAC82CA7396A68D541C85D26508E83_477835204;
                break;
            case 5: //Assign result for return ordinal #5
                varA7E53CE21691AB073D9660D615818899_1263416459 = varB4EAC82CA7396A68D541C85D26508E83_60064253;
                break;
            case 6: //Assign result for return ordinal #6
                varA7E53CE21691AB073D9660D615818899_1263416459 = varB4EAC82CA7396A68D541C85D26508E83_1648260651;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1263416459 = varB4EAC82CA7396A68D541C85D26508E83_1595021982;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1263416459.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1263416459;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.687 -0400", hash_original_method = "BB58D6FD0DD6E4462529DBFA77E71E10", hash_generated_method = "0C8DA1830FF1A6DE90318C8734F01302")
    public void performPendingDeferredStart(Fragment f) {
        {
            {
                mHavePendingDeferredStart = true;
            } //End block
            f.mDeferStart = false;
            moveToState(f, mCurState, 0, 0);
        } //End block
        addTaint(f.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.764 -0400", hash_original_method = "EE92853A739004991ACA465267191DB6", hash_generated_method = "FC360B7A440150FC9795BE2C1F87378E")
     void moveToState(Fragment f, int newState, int transit, int transitionStyle) {
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
                        boolean var96EB76334F7F0C83DB99A12D79366153_519590972 = (!mActivity.isFinishing() && f.mSavedViewState == null);
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
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.753 -0400", hash_original_method = "9D8EA3EF50700F2206500D8F97DFE625", hash_generated_method = "2C39711CD8A086053CAEF855ADEF4DD0")
                            @Override
                            public void onAnimationEnd(Animator anim) {
                                //DSFIXME:  CODE0009: Possible callback target function detected
                                container.endViewTransition(view);
                                {
                                    fragment.mAnimatingAway = null;
                                    moveToState(fragment, fragment.mStateAfterAnimating,
                                                    0, 0);
                                } //End block
                                addTaint(anim.getTaint());
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
        addTaint(newState);
        addTaint(transit);
        addTaint(transitionStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.784 -0400", hash_original_method = "8CD289FFBEE11A8449DF6C5CC9F9ABBD", hash_generated_method = "277DA991701DD2BE06FDDDCC84DF015B")
     void moveToState(Fragment f) {
        moveToState(f, mCurState, 0, 0);
        addTaint(f.getTaint());
        // ---------- Original Method ----------
        //moveToState(f, mCurState, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.802 -0400", hash_original_method = "4A2DC4C23578532593EF5B01DCA60326", hash_generated_method = "9A6D3575C75AC7095BF1636094E58E4E")
     void moveToState(int newState, boolean always) {
        moveToState(newState, 0, 0, always);
        addTaint(newState);
        addTaint(always);
        // ---------- Original Method ----------
        //moveToState(newState, 0, 0, always);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.805 -0400", hash_original_method = "EC27B7DF943700174166429595B46255", hash_generated_method = "457A6544A649341EBC7F2770633D846D")
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
                boolean var2E483A1271BDE2FC27F0CB7948500179_489286731 = (i<mActive.size());
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
        addTaint(transit);
        addTaint(transitStyle);
        addTaint(always);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.823 -0400", hash_original_method = "CCAA4C21D5B5313253593374D7FC1754", hash_generated_method = "9D430A4CF2CB3E2D916796BCCDD6BCD4")
     void startPendingDeferredFragments() {
        {
            int i;
            i = 0;
            boolean varBBF7D06AD5BD96085BA2B334471E7136_2128397869 = (i<mActive.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.828 -0400", hash_original_method = "D50E4D1CE651B3B8515ED7A1E81CB61B", hash_generated_method = "97DEFAD558E5D0C4A1B28D8253BD6A1B")
     void makeActive(Fragment f) {
        {
            boolean var0C317551F6EB79301C3E3065D871C4BD_1468947728 = (mAvailIndices == null || mAvailIndices.size() <= 0);
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
        addTaint(f.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.849 -0400", hash_original_method = "21A9491D104F42D1B78CA5222CCDF2B0", hash_generated_method = "D7DA64B812E015ED428AE483E44F0981")
     void makeInactive(Fragment f) {
        mActive.set(f.mIndex, null);
        {
            mAvailIndices = new ArrayList<Integer>();
        } //End block
        mAvailIndices.add(f.mIndex);
        mActivity.invalidateFragmentIndex(f.mIndex);
        f.initState();
        addTaint(f.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.934 -0400", hash_original_method = "39A4C55EF4B2F4D7AD9F69C21FC91745", hash_generated_method = "9797406AD792BBF5F73C7AB254491928")
    public void addFragment(Fragment fragment, boolean moveToStateNow) {
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
        addTaint(moveToStateNow);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.948 -0400", hash_original_method = "47129A78A86358373557A8CBE26A47CF", hash_generated_method = "AA37DCFD61FE2C43F2D65DA9299C22D1")
    public void removeFragment(Fragment fragment, int transition, int transitionStyle) {
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
        addTaint(transition);
        addTaint(transitionStyle);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.973 -0400", hash_original_method = "066049DB7DB3E7A9AEFB54490F59C652", hash_generated_method = "03213198BE3CA2E91BED98BABCC3BE5E")
    public void hideFragment(Fragment fragment, int transition, int transitionStyle) {
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.971 -0400", hash_original_method = "FE6C0F24C850190D502A7783FD2F34FA", hash_generated_method = "0E86514C89A76C95EF0B57B18A0EE7E9")
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            //DSFIXME:  CODE0009: Possible callback target function detected
                            {
                                finalFragment.mView.setVisibility(View.GONE);
                            } //End block
                            addTaint(animation.getTaint());
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
        addTaint(fragment.getTaint());
        addTaint(transition);
        addTaint(transitionStyle);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.997 -0400", hash_original_method = "DD64B7390BAEF5796124974048F6770D", hash_generated_method = "2F1B160409135B3A4E5A5E473CEECA06")
    public void showFragment(Fragment fragment, int transition, int transitionStyle) {
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
        addTaint(fragment.getTaint());
        addTaint(transition);
        addTaint(transitionStyle);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.021 -0400", hash_original_method = "9E4782C1879A41669B298A15D404F278", hash_generated_method = "4554B66A48C704471498C162CBA087C8")
    public void detachFragment(Fragment fragment, int transition, int transitionStyle) {
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
        addTaint(transition);
        addTaint(transitionStyle);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.046 -0400", hash_original_method = "681D8A8EBC4582B35DF715CE5B5E6679", hash_generated_method = "1C0C76B2B5795A17ABAE60ACF12266AC")
    public void attachFragment(Fragment fragment, int transition, int transitionStyle) {
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
        addTaint(transition);
        addTaint(transitionStyle);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.063 -0400", hash_original_method = "846CFE4E6D453F7EB47298FC794E62E7", hash_generated_method = "15879134708B2ED97F3FDE7C4EFA9C17")
    public Fragment findFragmentById(int id) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1220114144 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_516506983 = null; //Variable for return #2
        Fragment varB4EAC82CA7396A68D541C85D26508E83_2705051 = null; //Variable for return #3
        {
            {
                int i;
                i = mAdded.size()-1;
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1220114144 = f;
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = mActive.size()-1;
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_516506983 = f;
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2705051 = null;
        addTaint(id);
        Fragment varA7E53CE21691AB073D9660D615818899_1630385032; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1630385032 = varB4EAC82CA7396A68D541C85D26508E83_1220114144;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1630385032 = varB4EAC82CA7396A68D541C85D26508E83_516506983;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1630385032 = varB4EAC82CA7396A68D541C85D26508E83_2705051;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1630385032.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1630385032;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.095 -0400", hash_original_method = "5F9B0395F726C1A39BFC043E2E96E889", hash_generated_method = "A85729D91EF89AC8F6A4F064EE8D5295")
    public Fragment findFragmentByTag(String tag) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1456661808 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1018221393 = null; //Variable for return #2
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1667671976 = null; //Variable for return #3
        {
            {
                int i;
                i = mAdded.size()-1;
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_1712163452 = (f != null && tag.equals(f.mTag));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1456661808 = f;
                        } //End block
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
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_1375267274 = (f != null && tag.equals(f.mTag));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1018221393 = f;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1667671976 = null;
        addTaint(tag.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_416470240; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_416470240 = varB4EAC82CA7396A68D541C85D26508E83_1456661808;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_416470240 = varB4EAC82CA7396A68D541C85D26508E83_1018221393;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_416470240 = varB4EAC82CA7396A68D541C85D26508E83_1667671976;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_416470240.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_416470240;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.114 -0400", hash_original_method = "BBAAD10FC9AB450B3B7E8CD0A108A471", hash_generated_method = "F8979BC51D4C71E1F27AF5634D7A802B")
    public Fragment findFragmentByWho(String who) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_982332457 = null; //Variable for return #1
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1265275116 = null; //Variable for return #2
        {
            {
                int i;
                i = mActive.size()-1;
                {
                    Fragment f;
                    f = mActive.get(i);
                    {
                        boolean var9326B715BF996C787D3FE61249DC42AB_635576370 = (f != null && who.equals(f.mWho));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_982332457 = f;
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End collapsed parenthetic
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1265275116 = null;
        addTaint(who.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_1807136797; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1807136797 = varB4EAC82CA7396A68D541C85D26508E83_982332457;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1807136797 = varB4EAC82CA7396A68D541C85D26508E83_1265275116;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1807136797.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1807136797;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.124 -0400", hash_original_method = "B87B380B690A16EB7F37B7EE1C0A0D26", hash_generated_method = "4076EE59F13ECCD4B07230734A017E5F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.143 -0400", hash_original_method = "32359130EC903AF4E096237D1F067453", hash_generated_method = "FFA79CD095737C32DF30F4EC8A2C2573")
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
                boolean varED396C6F84781DC21825B4A03F526E3B_344907847 = (mPendingActions.size() == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.152 -0400", hash_original_method = "1503673DA6CC1FF53261337C6A89F6BE", hash_generated_method = "C17D4D7B9C964C0EBD0E05A56504DBBE")
    public int allocBackStackIndex(BackStackRecord bse) {
        {
            {
                boolean var98612EE02F6CF00DE971BBFA890C1BB0_88953754 = (mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0);
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994486029 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1994486029;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.168 -0400", hash_original_method = "F0AF804A23A686630C8F5E2012EB99F7", hash_generated_method = "CEAFBE3D0FE56865A9ED0AD5353818A0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.191 -0400", hash_original_method = "A75FE5CB17552EA725360407924677A5", hash_generated_method = "AFDDA9DE97FC9DF3E5F4BF723FE82F1A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.218 -0400", hash_original_method = "2EC9B9D8ABC4926EA1F7FF85BE00D458", hash_generated_method = "D2F70982206814B9CB1AF9C30038D9C6")
    public boolean execPendingActions() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Recursive entry to executePendingTransactions");
        } //End block
        {
            boolean var92CCD900C583B95C908C1457DCFC97EB_1055960746 = (Looper.myLooper() != mActivity.mHandler.getLooper());
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
                    boolean var8F64D3B59DFFB1D978D9FFAE1E7D437D_353574707 = (mPendingActions == null || mPendingActions.size() == 0);
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
                boolean var2E483A1271BDE2FC27F0CB7948500179_1111540993 = (i<mActive.size());
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1220293144 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1220293144;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.220 -0400", hash_original_method = "480CA24D6CDDA51ECD1DFDE903041169", hash_generated_method = "9492443F7CF01BF04C4E350E659DE322")
     void reportBackStackChanged() {
        {
            {
                int i;
                i = 0;
                boolean var3737AEDF4226FD639F6461E15393E309_575890159 = (i<mBackStackChangeListeners.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.222 -0400", hash_original_method = "93C61FA561A07CB0E9B057A7A904C282", hash_generated_method = "FF183CDFF9871413611B0CFF67FE69C7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.233 -0400", hash_original_method = "2DCA4D0949EEA78B53FF55FD7B1EE1F8", hash_generated_method = "E08A275D6733F91EF7C0E2C5A4F6801F")
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
                        boolean varBEA6676FD08F9A893EB03C8E97D94F9C_1149125025 = (name != null && name.equals(bss.getName()));
                    } //End collapsed parenthetic
                } //End block
                {
                    {
                        BackStackRecord bss;
                        bss = mBackStack.get(index);
                        {
                            boolean varF7B12DD1A8F871B2F43DC36592D3ADBE_2037345952 = ((name != null && name.equals(bss.getName()))
                                || (id >= 0 && id == bss.mIndex));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End block
            {
                boolean var4A958E5CC0AD80F8568B9E8089EACA0B_701375536 = (index == mBackStack.size()-1);
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_680405112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_680405112;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.260 -0400", hash_original_method = "C4579656BDDD252D61818FF4E8F19896", hash_generated_method = "9D458FE54EB80B18E734234B55F8FFA2")
     ArrayList<Fragment> retainNonConfig() {
        ArrayList<Fragment> varB4EAC82CA7396A68D541C85D26508E83_1777825640 = null; //Variable for return #1
        ArrayList<Fragment> fragments;
        fragments = null;
        {
            {
                int i;
                i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_1902741703 = (i<mActive.size());
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
        varB4EAC82CA7396A68D541C85D26508E83_1777825640 = fragments;
        varB4EAC82CA7396A68D541C85D26508E83_1777825640.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1777825640;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.286 -0400", hash_original_method = "90803A489E5220D7765DFCAE4FAFF7AC", hash_generated_method = "26B567B4CCA1F4FD3F302FBCFE0E9EFF")
     void saveFragmentViewState(Fragment f) {
        {
            mStateArray = new SparseArray<Parcelable>();
        } //End block
        {
            mStateArray.clear();
        } //End block
        f.mView.saveHierarchyState(mStateArray);
        {
            boolean var10CB5DFFB182D477A1F1C08C2A2A4D10_668158293 = (mStateArray.size() > 0);
            {
                f.mSavedViewState = mStateArray;
                mStateArray = null;
            } //End block
        } //End collapsed parenthetic
        addTaint(f.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.324 -0400", hash_original_method = "DCA5B6BB14B617A2A3ED4183EF745130", hash_generated_method = "07B94C39F1D85BF0CB4A2AE5859245F5")
     Bundle saveFragmentBasicState(Fragment f) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1300296563 = null; //Variable for return #1
        Bundle result;
        result = null;
        {
            mStateBundle = new Bundle();
        } //End block
        f.onSaveInstanceState(mStateBundle);
        {
            boolean var5AE1326457CED87C792B211942E81B2E_404313171 = (!mStateBundle.isEmpty());
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
        varB4EAC82CA7396A68D541C85D26508E83_1300296563 = result;
        addTaint(f.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1300296563.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1300296563;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.378 -0400", hash_original_method = "5A6DADDDEE90F93280222EE0F5B508C8", hash_generated_method = "58D9F261B7CE2FD7325A7C7C80BF4FCA")
     Parcelable saveAllState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_761540640 = null; //Variable for return #1
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_700836521 = null; //Variable for return #2
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1664571835 = null; //Variable for return #3
        execPendingActions();
        mStateSaved = true;
        {
            boolean var7B1A0FE06CC77C5BE5C8EE27C706FD90_299176032 = (mActive == null || mActive.size() <= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_761540640 = null;
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
        {
            varB4EAC82CA7396A68D541C85D26508E83_700836521 = null;
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
        varB4EAC82CA7396A68D541C85D26508E83_1664571835 = fms;
        Parcelable varA7E53CE21691AB073D9660D615818899_202075980; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_202075980 = varB4EAC82CA7396A68D541C85D26508E83_761540640;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_202075980 = varB4EAC82CA7396A68D541C85D26508E83_700836521;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_202075980 = varB4EAC82CA7396A68D541C85D26508E83_1664571835;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_202075980.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_202075980;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.418 -0400", hash_original_method = "CDDD12666FB804E6E56655D62533D556", hash_generated_method = "4E498DC20ABFE6D7940EB28BAF0FCDBB")
     void restoreAllState(Parcelable state, ArrayList<Fragment> nonConfig) {
        FragmentManagerState fms;
        fms = (FragmentManagerState)state;
        {
            {
                int i;
                i = 0;
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_1109023702 = (i<nonConfig.size());
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
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_1407468373 = (i<nonConfig.size());
                {
                    Fragment f;
                    f = nonConfig.get(i);
                    {
                        {
                            boolean var487621A5D4BD2ACED481B16F5F5948D3_6245411 = (f.mTargetIndex < mActive.size());
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
        addTaint(state.getTaint());
        addTaint(nonConfig.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.433 -0400", hash_original_method = "1A90D3789635EF8BA5063E635EAF56EA", hash_generated_method = "37976AEEA763C628AAA13A4731453519")
    public void attachActivity(Activity activity) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        mActivity = activity;
        // ---------- Original Method ----------
        //if (mActivity != null) throw new IllegalStateException();
        //mActivity = activity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.435 -0400", hash_original_method = "9E4E3FCA42BDE19CBF71140223B4B8D0", hash_generated_method = "B5C7E72CCEE273A62746EE3408615591")
    public void noteStateNotSaved() {
        mStateSaved = false;
        // ---------- Original Method ----------
        //mStateSaved = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.436 -0400", hash_original_method = "4EAFC4D017ED2B44474902CD00BD047E", hash_generated_method = "21C3627E95BE86042A719066A2913EA6")
    public void dispatchCreate() {
        mStateSaved = false;
        moveToState(Fragment.CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.454 -0400", hash_original_method = "BB3D6B45374259B5EE70270EF5FFE721", hash_generated_method = "1F7202ED50DB7895525D3D5DD1A85A9D")
    public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(Fragment.ACTIVITY_CREATED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.ACTIVITY_CREATED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.455 -0400", hash_original_method = "145C9AF81AEB697CB534D8E0C0F599A0", hash_generated_method = "20844DC4E325108731D69AD369D5CB9A")
    public void dispatchStart() {
        mStateSaved = false;
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.473 -0400", hash_original_method = "35325401D14378833F40C78A6FC3DC5D", hash_generated_method = "9E4D22D120F9A6B67EA4BB2B4DEB3341")
    public void dispatchResume() {
        mStateSaved = false;
        moveToState(Fragment.RESUMED, false);
        // ---------- Original Method ----------
        //mStateSaved = false;
        //moveToState(Fragment.RESUMED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.475 -0400", hash_original_method = "E6EE1A1408209BDB9066272C26AA9863", hash_generated_method = "806CEF702E5812DC1949A4F8EE32F575")
    public void dispatchPause() {
        moveToState(Fragment.STARTED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.STARTED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.482 -0400", hash_original_method = "AF2E4C7CBE2D28416278336F31B9AFFC", hash_generated_method = "C441D21E31BC8B8A9609B8D4D6E7ECAA")
    public void dispatchStop() {
        moveToState(Fragment.STOPPED, false);
        // ---------- Original Method ----------
        //moveToState(Fragment.STOPPED, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.578 -0400", hash_original_method = "A94A97B8768D84C8034BA8478DD395DC", hash_generated_method = "C5BBDC804266F378AABECFFC198DA3FC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.599 -0400", hash_original_method = "5117E19429D94CDE29C750CF70651BE9", hash_generated_method = "4F18FDDE863A92278AB5485AB2989581")
    public void dispatchConfigurationChanged(Configuration newConfig) {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1048509065 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.onConfigurationChanged(newConfig);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(newConfig.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.601 -0400", hash_original_method = "BC8D3EC4480A5918F3A38ABAC82A7ED6", hash_generated_method = "D5A2624E26D6684F3DD45FBA45FB94AF")
    public void dispatchLowMemory() {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1140432879 = (i<mAdded.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.621 -0400", hash_original_method = "81FEC8A34B79BC0E01F9FFFE05F1478B", hash_generated_method = "6C54F084FF2A214680DC048FD82BA8BD")
    public void dispatchTrimMemory(int level) {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1094210784 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.onTrimMemory(level);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(level);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.642 -0400", hash_original_method = "059A23578A0DB56C84349E8F783E9AC3", hash_generated_method = "4607DA1FD6C2DCF3C712A8D83EE4E5A7")
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean show;
        show = false;
        ArrayList<Fragment> newMenus;
        newMenus = null;
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_2005847308 = (i<mAdded.size());
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
                boolean var829574F28570EB1E74183020953B6E4B_1640053510 = (i<mCreatedMenus.size());
                {
                    Fragment f;
                    f = mCreatedMenus.get(i);
                    {
                        boolean varF740BD6A5A57A11B5D73D0A67A04AEFC_857336426 = (newMenus == null || !newMenus.contains(f));
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
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_641296061 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_641296061;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.658 -0400", hash_original_method = "3C4E4DD19A75168CEF9873DFBC1B4179", hash_generated_method = "9D923918FEE5DCE9D395D100A3BAA8CB")
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean show;
        show = false;
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1018889478 = (i<mAdded.size());
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
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_60150283 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_60150283;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.678 -0400", hash_original_method = "16456DF238276E24923F6AD552304983", hash_generated_method = "1C526E3F329298DDC50CB12124626BBC")
    public boolean dispatchOptionsItemSelected(MenuItem item) {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_60162030 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        {
                            boolean varE78EB04814153BF35CF96C1AE499F5B5_1019180031 = (f.onOptionsItemSelected(item));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1715374831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1715374831;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.693 -0400", hash_original_method = "F1ECF21855715BC93D4867D907434D91", hash_generated_method = "0F61C622F92BAD5C7CC4608E52A4DEB4")
    public boolean dispatchContextItemSelected(MenuItem item) {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1251084021 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        {
                            boolean var48F0CD0D37FBD8298C20892C7FC62FDA_1920393836 = (f.onContextItemSelected(item));
                        } //End collapsed parenthetic
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1467839460 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1467839460;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.697 -0400", hash_original_method = "EA4F9A660842285D75622DB2DA97E1AE", hash_generated_method = "7D8BE61889AB576D5D55E36C5CB01B71")
    public void dispatchOptionsMenuClosed(Menu menu) {
        {
            {
                int i;
                i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_854294239 = (i<mAdded.size());
                {
                    Fragment f;
                    f = mAdded.get(i);
                    {
                        f.onOptionsMenuClosed(menu);
                    } //End block
                } //End block
            } //End collapsed parenthetic
        } //End block
        addTaint(menu.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.710 -0400", hash_original_method = "5756D303078CA095AB87E344CED6E29B", hash_generated_method = "548106A013399E869E8B72F313E0BDD1")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.730 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.730 -0400", hash_original_field = "309AAD3E76F171051A35712763096DE8", hash_generated_field = "1EA3A5C5FC69D5714D9768796013BDF7")

    static String TAG = "FragmentManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.731 -0400", hash_original_field = "E58DEFB2E4C5F4C4BC898BC35F33C192", hash_generated_field = "BC915678C8B05A455B6EFF9197D144CC")

    static String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.731 -0400", hash_original_field = "A8D8A7593440E0D7D4A8A21F4BCD6D54", hash_generated_field = "B989DF0B503591D35BE57CF1B243AE35")

    static String TARGET_STATE_TAG = "android:target_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.743 -0400", hash_original_field = "03990A2696101FE20E375C710E3F3AE1", hash_generated_field = "E26DCEE01F3AD04324A06084305D6B42")

    static String VIEW_STATE_TAG = "android:view_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:53.743 -0400", hash_original_field = "80B57815D7CE7602226A48E51B42D058", hash_generated_field = "8482DED8AA15BDE9E6D81579BC59E4AB")

    static String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
}

