package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.317 -0400", hash_original_method = "0D3FEDE97BC3242ED64134E1F014EA11", hash_generated_method = "0D3FEDE97BC3242ED64134E1F014EA11")
    public FragmentManager ()
    {
        
    }


    public abstract FragmentTransaction beginTransaction();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.318 -0400", hash_original_method = "0DA67415D41DB3C4C9D7AB80CD2D78FE", hash_generated_method = "4A827D0E8DD3CA160A1C5BDC63AA19A0")
    @Deprecated
    public FragmentTransaction openTransaction() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_415194655 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_415194655 = beginTransaction();
        varB4EAC82CA7396A68D541C85D26508E83_415194655.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_415194655;
        
        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.323 -0400", hash_original_method = "15ED404039200ACA8749491C77846D3D", hash_generated_method = "DBB7CD62A7EC5E14380DEAAF62A330E3")
    public void invalidateOptionsMenu() {
        
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.323 -0400", hash_original_field = "F2813E5BD6A379A2985E370BE1887EDA", hash_generated_field = "3F74866CBC8F49655F2B8BB97CC17F5E")

    public static final int POP_BACK_STACK_INCLUSIVE = 1<<0;
}

final class FragmentManagerState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.324 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "0C91046A014C3ABDDA41BA020BEE7D35")

    FragmentState[] mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.324 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "4D5C3ED026B5D0195A6077AFCD696836")

    int[] mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.324 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "EEA20C5C67D270067553BCDE313A7B27")

    BackStackState[] mBackStack;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.324 -0400", hash_original_method = "4ADB2DBBD6899E89144480A7958A6490", hash_generated_method = "252DFEAE0ECB79838960A8B564DE42F6")
    public  FragmentManagerState() {
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.325 -0400", hash_original_method = "020574327F1D57965B67553DD6F7D979", hash_generated_method = "F858C24C16C6DB16663BD3817D53ADD9")
    public  FragmentManagerState(Parcel in) {
        mActive = in.createTypedArray(FragmentState.CREATOR);
        mAdded = in.createIntArray();
        mBackStack = in.createTypedArray(BackStackState.CREATOR);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.325 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "E1307046F5698284B6C57BCC264EF22E")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1137779282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1137779282;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_method = "B6654BF7A24842DC15E6AD3A5F27203C", hash_generated_method = "755001DC0FEE505DA71D76177C4F11BA")
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(mActive, flags);
        dest.writeIntArray(mAdded);
        dest.writeTypedArray(mBackStack, flags);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "D29AA2723BAE7915447DC2F30F3AAA56", hash_generated_field = "EE9672AF4023C35BB0D72B0356E5DA5C")

    public static final Parcelable.Creator<FragmentManagerState> CREATOR
            = new Parcelable.Creator<FragmentManagerState>() {
        public FragmentManagerState createFromParcel(Parcel in) {
            return new FragmentManagerState(in);
        }
        
        public FragmentManagerState[] newArray(int size) {
            return new FragmentManagerState[size];
        }
    };
    
    public FragmentManagerState createFromParcel(Parcel in) {
            return new FragmentManagerState(in);
        }
    
    
    public FragmentManagerState[] newArray(int size) {
            return new FragmentManagerState[size];
        }
    
}

final class FragmentManagerImpl extends FragmentManager {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "327C9FAD23CE4030098BE2DE91837CF7", hash_generated_field = "11FD18D208B09E922FC03FBF68E7335B")

    ArrayList<Runnable> mPendingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "E3843751CB2154B155E225749A18D620", hash_generated_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3")

    Runnable[] mTmpActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "CDD41116A3EE1465C2308845599CA08D", hash_generated_field = "CD4485F6F525738DAA0EA0DC245911AB")

    boolean mExecutingActions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "A94EB756C33921574C3064C98AF96788", hash_generated_field = "A1650882FA43FC001601740ED87DBA1F")

    ArrayList<Fragment> mActive;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "FF37605B8D813171195C0EBF92B2A116")

    ArrayList<Fragment> mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "CD7D957830B65DDE14B44534836CDCFA", hash_generated_field = "5441838D07CA3D72A0FE3BB98FAAC33E")

    ArrayList<Integer> mAvailIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "AF7A6AFC6841E10A94129285977CF562", hash_generated_field = "A66A7C10189C949E8CDC007D4D07280E")

    ArrayList<BackStackRecord> mBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "07EBA043D3FF90523B37550E5D9B91E4", hash_generated_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7")

    ArrayList<Fragment> mCreatedMenus;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "A06EFC21545AC26226ABF57556E73291", hash_generated_field = "89571A39B2AB736200FBD57A213BDB4D")

    ArrayList<BackStackRecord> mBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.326 -0400", hash_original_field = "A96F62FC59DD2FAE4327C1E7855AE979", hash_generated_field = "27AED91E8586753C6865FA558A4716C8")

    ArrayList<Integer> mAvailBackStackIndices;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "D0295B7D6BE1788760CAFE41F824D774", hash_generated_field = "078DA2C7CA0D4289F90F664D0B3EDB3B")

    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "C81B2F53A65D169421FFBC0C3AC986EE", hash_generated_field = "9521C64640071A41BA8B18982DEC3BE2")

    int mCurState = Fragment.INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "1ED82791F588E1B933718ECC0041EE63", hash_generated_field = "19DD0E42F9FC244F37062274E8F2012D")

    boolean mNeedMenuInvalidate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "5C1552B132EB06695090E74F8854ED21", hash_generated_field = "E68067DB35DA8BD96BFB5C858DBE74BF")

    boolean mStateSaved;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "C724374D1A8B3D38592BCBAA64034D32", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

    boolean mDestroyed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "1ECE9D4CB2FBE961BEE64D8760E25D34", hash_generated_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE")

    String mNoTransactionsBecause;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "20E894967D971C1F65FB2EA61F367BAE", hash_generated_field = "79BC4D349D09DCA85692E9FAD9D9C6F7")

    boolean mHavePendingDeferredStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "D0B68049F76228FB1A7F03664CE569DE", hash_generated_field = "92A56B8032395A53760143DE797F97FA")

    Bundle mStateBundle = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_field = "EA03FEC1D1BDCAB5D2BD8A3D0ADCF67E", hash_generated_field = "280BE7FE9228C6CA67328AF4B4B28047")

    SparseArray<Parcelable> mStateArray = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.328 -0400", hash_original_field = "BB4C35BD7F2BC82D3F4C38422B568E9B", hash_generated_field = "E35D464208931599FA6E66C3119300C4")

    Runnable mExecCommit = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_method = "C2BA1C69EB0B4CCFF1A319535DB79508", hash_generated_method = "FEDC918E58215E12D8175F59CA2BA6B4")
        @Override
        public void run() {
            execPendingActions();
            
            
        }

        
};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.328 -0400", hash_original_method = "57A648A59831AB7BB1637AFC6125C81E", hash_generated_method = "57A648A59831AB7BB1637AFC6125C81E")
    public FragmentManagerImpl ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.328 -0400", hash_original_method = "FD4DF6D1DA8CD9545895F43FA5CF7B0B", hash_generated_method = "AEA5AC8F2E74FF46A4EBE6C167E10EA4")
    @Override
    public FragmentTransaction beginTransaction() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_609981772 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_609981772 = new BackStackRecord(this);
        varB4EAC82CA7396A68D541C85D26508E83_609981772.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_609981772;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.329 -0400", hash_original_method = "082964FFA3913D960E19EEB76BD9505B", hash_generated_method = "3D6032FED5784E78A5D12B653BCD522A")
    @Override
    public boolean executePendingTransactions() {
        boolean varDEC74AD03B6C92C5F58BDD6F9B78062F_30104829 = (execPendingActions());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1839850443 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1839850443;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.330 -0400", hash_original_method = "5CB88371A39240A7C2FB2F2041C5DD0D", hash_generated_method = "CC62AFBB61E5FBA917D8C75F6DF79AB6")
    @Override
    public void popBackStack() {
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.329 -0400", hash_original_method = "C15C9D80C4BF4FB6B2AF0B93A4449441", hash_generated_method = "B3F70B584C16FE3B98A16E26008D78C3")
            @Override
            public void run() {
                popBackStackState(mActivity.mHandler, null, -1, 0);
                
                
            }
}, false);
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.330 -0400", hash_original_method = "B7072E2D8E1B8CAC03251D641D234641", hash_generated_method = "1E1234FF73A0477D1CD252B2840074A2")
    @Override
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        boolean varE659918100A3B568A6F3D267CDA15217_1727515399 = (popBackStackState(mActivity.mHandler, null, -1, 0));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1894865932 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1894865932;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.334 -0400", hash_original_method = "9E86D2BA46D98A91B2D43097CFA7F639", hash_generated_method = "34DBB921264FBD3DD2C28728EDC65487")
    @Override
    public void popBackStack(final String name, final int flags) {
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.333 -0400", hash_original_method = "22FC8A6DB6B4AB9E651D01E64BEED72A", hash_generated_method = "3FE29178F98A070A5E0ED21762A74700")
            @Override
            public void run() {
                popBackStackState(mActivity.mHandler, name, -1, flags);
                
                
            }
}, false);
        addTaint(name.getTaint());
        addTaint(flags);
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.334 -0400", hash_original_method = "4DEC43188CEAB5FA4EF2839673649ECC", hash_generated_method = "555E3038A888C6D78366507C7DD1A7BA")
    @Override
    public boolean popBackStackImmediate(String name, int flags) {
        checkStateLoss();
        executePendingTransactions();
        boolean var8537C2C3238620E29A2DABFDDEEAED83_1305055646 = (popBackStackState(mActivity.mHandler, name, -1, flags));
        addTaint(name.getTaint());
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1272337030 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1272337030;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.336 -0400", hash_original_method = "DA57C1B5DA7DBD65A6FF7556F6C0B827", hash_generated_method = "FB0D3AF3C7906604A1ABDAD6A80BE050")
    @Override
    public void popBackStack(final int id, final int flags) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } 
        enqueueAction(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.335 -0400", hash_original_method = "DBCE7037D51EB5153CDA373E6D392F0E", hash_generated_method = "905DCE3DB8D6804FD0D561A3F3EB2065")
            @Override
            public void run() {
                popBackStackState(mActivity.mHandler, null, id, flags);
                
                
            }
}, false);
        addTaint(id);
        addTaint(flags);
        
        
            
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.336 -0400", hash_original_method = "C28CBCAD3FA2084F032C85B006AF0CA6", hash_generated_method = "68F1E3AF396A67DA9B80F7F8E8AA04B3")
    @Override
    public boolean popBackStackImmediate(int id, int flags) {
        checkStateLoss();
        executePendingTransactions();
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad id: " + id);
        } 
        boolean var4EE663DB9CE1C64C129233E54BE6C6E6_8939058 = (popBackStackState(mActivity.mHandler, null, id, flags));
        addTaint(id);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_230954191 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_230954191;
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.337 -0400", hash_original_method = "81448DC3AD62196301F3A4A762AB09A8", hash_generated_method = "7C2A7CFBBEBB0FC140F0635DCD6B68B3")
    @Override
    public int getBackStackEntryCount() {
        {
            Object var0D23A520C4639C79F477D4746DB89D7E_310399526 = (mBackStack.size());
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871022887 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871022887;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.338 -0400", hash_original_method = "898A7E40DF942FAA7422F0070AE7C2C0", hash_generated_method = "A4EAB2BBFA24719CD0C13B05F5367691")
    @Override
    public BackStackEntry getBackStackEntryAt(int index) {
        BackStackEntry varB4EAC82CA7396A68D541C85D26508E83_1538048941 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1538048941 = mBackStack.get(index);
        addTaint(index);
        varB4EAC82CA7396A68D541C85D26508E83_1538048941.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1538048941;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.338 -0400", hash_original_method = "5B02C223CD8F1AC3632AF80A3BE5FAF1", hash_generated_method = "B50FC75A1E09A20DD3B47627FFC2F2BF")
    @Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        {
            mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        } 
        mBackStackChangeListeners.add(listener);
        addTaint(listener.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.339 -0400", hash_original_method = "0EB71E2FD8D5B96EE15FDFA4CFDC7A3A", hash_generated_method = "67C87F2824D7F39E431B9C463BEFAAFD")
    @Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        {
            mBackStackChangeListeners.remove(listener);
        } 
        addTaint(listener.getTaint());
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.339 -0400", hash_original_method = "28A5058460B6EF16DD9CEE59F403CB5D", hash_generated_method = "FCB00791B6DFB1AADBCBAFE5342A08A5")
    @Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
        } 
        bundle.putInt(key, fragment.mIndex);
        addTaint(bundle.getTaint());
        addTaint(key.getTaint());
        addTaint(fragment.getTaint());
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.341 -0400", hash_original_method = "D08899B1EE8437F622E0D7F7BA40A91F", hash_generated_method = "693491A774FE72BC52382932FCA67398")
    @Override
    public Fragment getFragment(Bundle bundle, String key) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1379505163 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1602058959 = null; 
        int index = bundle.getInt(key, -1);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1379505163 = null;
        } 
        {
            boolean var107AB73BAE9815E9603DA2E7CAF7C8B7_1563068540 = (index >= mActive.size());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index);
            } 
        } 
        Fragment f = mActive.get(index);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1602058959 = f;
        addTaint(bundle.getTaint());
        addTaint(key.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_640414023; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_640414023 = varB4EAC82CA7396A68D541C85D26508E83_1379505163;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_640414023 = varB4EAC82CA7396A68D541C85D26508E83_1602058959;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_640414023.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_640414023;
        
        
        
            
        
        
            
                    
        
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.344 -0400", hash_original_method = "CF6272FD6214D7D7484637054FD9E74F", hash_generated_method = "DD47631C728BBB8A9EF2F5ADBA38D252")
    @Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        Fragment.SavedState varB4EAC82CA7396A68D541C85D26508E83_291022518 = null; 
        Fragment.SavedState varB4EAC82CA7396A68D541C85D26508E83_594037360 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
        } 
        {
            Bundle result = saveFragmentBasicState(fragment);
            varB4EAC82CA7396A68D541C85D26508E83_291022518 = result != null ? new Fragment.SavedState(result) : null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_594037360 = null;
        addTaint(fragment.getTaint());
        Fragment.SavedState varA7E53CE21691AB073D9660D615818899_992639474; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_992639474 = varB4EAC82CA7396A68D541C85D26508E83_291022518;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_992639474 = varB4EAC82CA7396A68D541C85D26508E83_594037360;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_992639474.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_992639474;
        
        
            
                    
        
        
            
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.345 -0400", hash_original_method = "A7D5B4266978FAAC75BAC34E53BDC41B", hash_generated_method = "C3534852F58C5AFC9DCE0CD187707C3F")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1012752479 = null; 
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        varB4EAC82CA7396A68D541C85D26508E83_1012752479 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1012752479.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1012752479;
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.347 -0400", hash_original_method = "0EF991BB6A19DFA56B66936C5498080A", hash_generated_method = "5A6013927120A066E753DC398E8DB10D")
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
                        } 
                    } 
                } 
            } 
        } 
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
                    } 
                } 
            } 
        } 
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
                    } 
                } 
            } 
        } 
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
                    } 
                } 
            } 
        } 
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
                        } 
                    } 
                } 
            } 
            {
                boolean varC3EC129F2815C61E4CC968B0C16B5E00_1667690155 = (mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0);
                {
                    writer.print(prefix);
                    writer.print("mAvailBackStackIndices: ");
                    writer.println(Arrays.toString(mAvailBackStackIndices.toArray()));
                } 
            } 
        } 
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
                    } 
                } 
            } 
        } 
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
        } 
        {
            writer.print(prefix);
            writer.print("  mNoTransactionsBecause=");
            writer.println(mNoTransactionsBecause);
        } 
        {
            boolean varD0CA0404E33A0C2149F9FC712F4B1B56_959884440 = (mAvailIndices != null && mAvailIndices.size() > 0);
            {
                writer.print(prefix);
                writer.print("  mAvailIndices: ");
                writer.println(Arrays.toString(mAvailIndices.toArray()));
            } 
        } 
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.348 -0400", hash_original_method = "8FB9E657DCE437B207C489B8932863BA", hash_generated_method = "4E3381F0317190240CCB240184C8F06F")
     Animator loadAnimator(Fragment fragment, int transit, boolean enter,
            int transitionStyle) {
        Animator varB4EAC82CA7396A68D541C85D26508E83_1857101403 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_1069717656 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_1217436821 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_1621651125 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_1594484554 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_1494787663 = null; 
        Animator varB4EAC82CA7396A68D541C85D26508E83_830955116 = null; 
        Animator animObj = fragment.onCreateAnimator(transit, enter,
                fragment.mNextAnim);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1857101403 = animObj;
        } 
        {
            Animator anim = AnimatorInflater.loadAnimator(mActivity, fragment.mNextAnim);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1069717656 = anim;
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1217436821 = null;
        } 
        int styleIndex = transitToStyleIndex(transit, enter);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1621651125 = null;
        } 
        {
            boolean var7E1D31F47E4E5D9D781C22ACD7E0177E_1308594945 = (transitionStyle == 0 && mActivity.getWindow() != null);
            {
                transitionStyle = mActivity.getWindow().getAttributes().windowAnimations;
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1594484554 = null;
        } 
        TypedArray attrs = mActivity.obtainStyledAttributes(transitionStyle,
                com.android.internal.R.styleable.FragmentAnimation);
        int anim = attrs.getResourceId(styleIndex, 0);
        attrs.recycle();
        {
            varB4EAC82CA7396A68D541C85D26508E83_1494787663 = null;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_830955116 = AnimatorInflater.loadAnimator(mActivity, anim);
        addTaint(fragment.getTaint());
        addTaint(transit);
        addTaint(enter);
        addTaint(transitionStyle);
        Animator varA7E53CE21691AB073D9660D615818899_1153732589; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1153732589 = varB4EAC82CA7396A68D541C85D26508E83_1857101403;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1153732589 = varB4EAC82CA7396A68D541C85D26508E83_1069717656;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1153732589 = varB4EAC82CA7396A68D541C85D26508E83_1217436821;
                break;
            case 4: 
                varA7E53CE21691AB073D9660D615818899_1153732589 = varB4EAC82CA7396A68D541C85D26508E83_1621651125;
                break;
            case 5: 
                varA7E53CE21691AB073D9660D615818899_1153732589 = varB4EAC82CA7396A68D541C85D26508E83_1594484554;
                break;
            case 6: 
                varA7E53CE21691AB073D9660D615818899_1153732589 = varB4EAC82CA7396A68D541C85D26508E83_1494787663;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1153732589 = varB4EAC82CA7396A68D541C85D26508E83_830955116;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1153732589.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1153732589;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.349 -0400", hash_original_method = "BB58D6FD0DD6E4462529DBFA77E71E10", hash_generated_method = "0C8DA1830FF1A6DE90318C8734F01302")
    public void performPendingDeferredStart(Fragment f) {
        {
            {
                mHavePendingDeferredStart = true;
            } 
            f.mDeferStart = false;
            moveToState(f, mCurState, 0, 0);
        } 
        addTaint(f.getTaint());
        
        
            
                
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.764 -0400", hash_original_method = "EE92853A739004991ACA465267191DB6", hash_generated_method = "FC360B7A440150FC9795BE2C1F87378E")
     void moveToState(Fragment f, int newState, int transit, int transitionStyle) {
        {
            newState = Fragment.CREATED;
        } 
        {
            newState = f.mState;
        } 
        {
            newState = Fragment.STOPPED;
        } 
        {
            {
                f.mAnimatingAway = null;
                moveToState(f, f.mStateAfterAnimating, 0, 0);
            } 
            
            {
                f.mSavedViewState = f.mSavedFragmentState.getSparseParcelableArray(
                                FragmentManagerImpl.VIEW_STATE_TAG);
                f.mTarget = getFragment(f.mSavedFragmentState,
                                FragmentManagerImpl.TARGET_STATE_TAG);
                {
                    f.mTargetRequestCode = f.mSavedFragmentState.getInt(
                                    FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG, 0);
                } 
                f.mUserVisibleHint = f.mSavedFragmentState.getBoolean(
                                FragmentManagerImpl.USER_VISIBLE_HINT_TAG, true);
                {
                    f.mDeferStart = true;
                    {
                        newState = Fragment.STOPPED;
                    } 
                } 
            } 
            
            
            f.mActivity = mActivity;
            
            
            f.mFragmentManager = mActivity.mFragments;
            
            
            f.mCalled = false;
            
            
            f.onAttach(mActivity);
            
            
            {
                if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                + " did not call through to super.onAttach()");
            } 
            
            
            mActivity.onAttachFragment(f);
            
            
            {
                f.mCalled = false;
                f.onCreate(f.mSavedFragmentState);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onCreate()");
                } 
            } 
            
            
            f.mRetaining = false;
            
            
            {
                f.mView = f.onCreateView(f.getLayoutInflater(f.mSavedFragmentState),
                                null, f.mSavedFragmentState);
                {
                    f.mView.setSaveFromParentEnabled(false);
                    f.mView.setVisibility(View.GONE);
                    f.onViewCreated(f.mView, f.mSavedFragmentState);
                } 
            } 
            
            
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
                        } 
                    } 
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
                            } 
                            container.addView(f.mView);
                        } 
                        f.mView.setVisibility(View.GONE);
                        f.onViewCreated(f.mView, f.mSavedFragmentState);
                    } 
                } 
                f.mCalled = false;
                f.onActivityCreated(f.mSavedFragmentState);
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onActivityCreated()");
                } 
                {
                    f.restoreViewState();
                } 
                f.mSavedFragmentState = null;
            } 
            
            
            {
                f.mCalled = false;
                f.performStart();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onStart()");
                } 
            } 
            
            
            {
                f.mCalled = false;
                f.mResumed = true;
                f.onResume();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onResume()");
                } 
                f.mSavedFragmentState = null;
                f.mSavedViewState = null;
            } 
            
        } 
        {
            
            {
                f.mCalled = false;
                f.onPause();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onPause()");
                } 
                f.mResumed = false;
            } 
            
            
            {
                f.mCalled = false;
                f.performStop();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onStop()");
                } 
            } 
            
            
            {
                {
                    {
                        boolean var96EB76334F7F0C83DB99A12D79366153_519590972 = (!mActivity.isFinishing() && f.mSavedViewState == null);
                        {
                            saveFragmentViewState(f);
                        } 
                    } 
                } 
                f.mCalled = false;
                f.performDestroyView();
                {
                    if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                    + " did not call through to super.onDestroyView()");
                } 
                {
                    Animator anim;
                    anim = null;
                    {
                        anim = loadAnimator(f, transit, false,
                                        transitionStyle);
                    } 
                    {
                        final ViewGroup container;
                        container = f.mContainer;
                        final View view;
                        view = f.mView;
                        final Fragment fragment;
                        fragment = f;
                        container.startViewTransition(view);
                        f.mAnimatingAway = anim;
                        f.mStateAfterAnimating = newState;
                        anim.addListener(new AnimatorListenerAdapter() {                            
                            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.753 -0400", hash_original_method = "9D8EA3EF50700F2206500D8F97DFE625", hash_generated_method = "2C39711CD8A086053CAEF855ADEF4DD0")
                            @Override
                            public void onAnimationEnd(Animator anim) {
                                
                                container.endViewTransition(view);
                                {
                                    fragment.mAnimatingAway = null;
                                    moveToState(fragment, fragment.mStateAfterAnimating,
                                                    0, 0);
                                } 
                                addTaint(anim.getTaint());
                                
                                
                                
                                            
                                            
                                                    
                                        
                            }
});
                        anim.setTarget(f.mView);
                        anim.start();
                    } 
                    f.mContainer.removeView(f.mView);
                } 
                f.mContainer = null;
                f.mView = null;
            } 
            
            
            {
                {
                    {
                        Animator anim;
                        anim = f.mAnimatingAway;
                        f.mAnimatingAway = null;
                        anim.cancel();
                    } 
                } 
                {
                    f.mStateAfterAnimating = newState;
                    newState = Fragment.CREATED;
                } 
                {
                    {
                        f.mCalled = false;
                        f.onDestroy();
                        {
                            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                            + " did not call through to super.onDestroy()");
                        } 
                    } 
                    f.mCalled = false;
                    f.onDetach();
                    {
                        if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + f
                                        + " did not call through to super.onDetach()");
                    } 
                    {
                        makeInactive(f);
                    } 
                    {
                        f.mActivity = null;
                        f.mFragmentManager = null;
                    } 
                } 
            } 
            
        } 
        f.mState = newState;
        addTaint(newState);
        addTaint(transit);
        addTaint(transitionStyle);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.350 -0400", hash_original_method = "8CD289FFBEE11A8449DF6C5CC9F9ABBD", hash_generated_method = "277DA991701DD2BE06FDDDCC84DF015B")
     void moveToState(Fragment f) {
        moveToState(f, mCurState, 0, 0);
        addTaint(f.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.351 -0400", hash_original_method = "4A2DC4C23578532593EF5B01DCA60326", hash_generated_method = "9A6D3575C75AC7095BF1636094E58E4E")
     void moveToState(int newState, boolean always) {
        moveToState(newState, 0, 0, always);
        addTaint(newState);
        addTaint(always);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.352 -0400", hash_original_method = "EC27B7DF943700174166429595B46255", hash_generated_method = "5901855FC226664255026F786A75ACAC")
     void moveToState(int newState, int transit, int transitStyle, boolean always) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("No activity");
        } 
        mCurState = newState;
        {
            boolean loadersRunning = false;
            {
                int i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_1022341071 = (i<mActive.size());
                {
                    Fragment f = mActive.get(i);
                    {
                        moveToState(f, newState, transit, transitStyle);
                        {
                            loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                        } 
                    } 
                } 
            } 
            {
                startPendingDeferredFragments();
            } 
            {
                mActivity.invalidateOptionsMenu();
                mNeedMenuInvalidate = false;
            } 
        } 
        addTaint(transit);
        addTaint(transitStyle);
        addTaint(always);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.354 -0400", hash_original_method = "CCAA4C21D5B5313253593374D7FC1754", hash_generated_method = "D9D067A4BD8B14EAB7763FE32D7111A7")
     void startPendingDeferredFragments() {
        {
            int i = 0;
            boolean varBBF7D06AD5BD96085BA2B334471E7136_827582966 = (i<mActive.size());
            {
                Fragment f = mActive.get(i);
                {
                    performPendingDeferredStart(f);
                } 
            } 
        } 
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.355 -0400", hash_original_method = "D50E4D1CE651B3B8515ED7A1E81CB61B", hash_generated_method = "A92D9B1C874606AA5C1E60531FBE58C2")
     void makeActive(Fragment f) {
        {
            boolean var0C317551F6EB79301C3E3065D871C4BD_2013451841 = (mAvailIndices == null || mAvailIndices.size() <= 0);
            {
                {
                    mActive = new ArrayList<Fragment>();
                } 
                f.setIndex(mActive.size());
                mActive.add(f);
            } 
            {
                f.setIndex(mAvailIndices.remove(mAvailIndices.size()-1));
                mActive.set(f.mIndex, f);
            } 
        } 
        addTaint(f.getTaint());
        
        
            
        
        
            
                
            
            
            
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.356 -0400", hash_original_method = "21A9491D104F42D1B78CA5222CCDF2B0", hash_generated_method = "D7DA64B812E015ED428AE483E44F0981")
     void makeInactive(Fragment f) {
        mActive.set(f.mIndex, null);
        {
            mAvailIndices = new ArrayList<Integer>();
        } 
        mAvailIndices.add(f.mIndex);
        mActivity.invalidateFragmentIndex(f.mIndex);
        f.initState();
        addTaint(f.getTaint());
        
        
            
        
        
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.357 -0400", hash_original_method = "39A4C55EF4B2F4D7AD9F69C21FC91745", hash_generated_method = "9797406AD792BBF5F73C7AB254491928")
    public void addFragment(Fragment fragment, boolean moveToStateNow) {
        {
            mAdded = new ArrayList<Fragment>();
        } 
        makeActive(fragment);
        {
            mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            {
                mNeedMenuInvalidate = true;
            } 
            {
                moveToState(fragment);
            } 
        } 
        addTaint(moveToStateNow);
        
        
            
        
        
        
        
            
            
            
            
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.357 -0400", hash_original_method = "47129A78A86358373557A8CBE26A47CF", hash_generated_method = "65814DEABE6C123E800DB1A4E293E8FE")
    public void removeFragment(Fragment fragment, int transition, int transitionStyle) {
        final boolean inactive = !fragment.isInBackStack();
        {
            mAdded.remove(fragment);
            {
                mNeedMenuInvalidate = true;
            } 
            fragment.mAdded = false;
            fragment.mRemoving = true;
            moveToState(fragment, inactive ? Fragment.INITIALIZING : Fragment.CREATED,
                    transition, transitionStyle);
        } 
        addTaint(transition);
        addTaint(transitionStyle);
        
        
        
        
            
            
                
            
            
            
            
                    
        
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
                    final Fragment finalFragment;
                    finalFragment = fragment;
                    anim.addListener(new AnimatorListenerAdapter() {                        
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:52.971 -0400", hash_original_method = "FE6C0F24C850190D502A7783FD2F34FA", hash_generated_method = "0E86514C89A76C95EF0B57B18A0EE7E9")
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            
                            {
                                finalFragment.mView.setVisibility(View.GONE);
                            } 
                            addTaint(animation.getTaint());
                            
                            
                                
                            
                        }
});
                    anim.start();
                } 
                {
                    fragment.mView.setVisibility(View.GONE);
                } 
            } 
            {
                mNeedMenuInvalidate = true;
            } 
            fragment.onHiddenChanged(true);
        } 
        addTaint(fragment.getTaint());
        addTaint(transition);
        addTaint(transitionStyle);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.358 -0400", hash_original_method = "DD64B7390BAEF5796124974048F6770D", hash_generated_method = "5D5165822FAF2CFC98A5AFEE816454AB")
    public void showFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mHidden = false;
            {
                Animator anim = loadAnimator(fragment, transition, true,
                        transitionStyle);
                {
                    anim.setTarget(fragment.mView);
                    anim.start();
                } 
                fragment.mView.setVisibility(View.VISIBLE);
            } 
            {
                mNeedMenuInvalidate = true;
            } 
            fragment.onHiddenChanged(false);
        } 
        addTaint(fragment.getTaint());
        addTaint(transition);
        addTaint(transitionStyle);
        
        
        
            
            
                
                        
                
                    
                    
                
                
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.359 -0400", hash_original_method = "9E4782C1879A41669B298A15D404F278", hash_generated_method = "4554B66A48C704471498C162CBA087C8")
    public void detachFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mDetached = true;
            {
                mAdded.remove(fragment);
                {
                    mNeedMenuInvalidate = true;
                } 
                fragment.mAdded = false;
                moveToState(fragment, Fragment.CREATED, transition, transitionStyle);
            } 
        } 
        addTaint(transition);
        addTaint(transitionStyle);
        
        
        
            
            
                
                
                    
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.360 -0400", hash_original_method = "681D8A8EBC4582B35DF715CE5B5E6679", hash_generated_method = "1C0C76B2B5795A17ABAE60ACF12266AC")
    public void attachFragment(Fragment fragment, int transition, int transitionStyle) {
        {
            fragment.mDetached = false;
            {
                mAdded.add(fragment);
                fragment.mAdded = true;
                {
                    mNeedMenuInvalidate = true;
                } 
                moveToState(fragment, mCurState, transition, transitionStyle);
            } 
        } 
        addTaint(transition);
        addTaint(transitionStyle);
        
        
        
            
            
                
                
                
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.362 -0400", hash_original_method = "846CFE4E6D453F7EB47298FC794E62E7", hash_generated_method = "7EF4EDE13836BC9E299336E47363CDA4")
    public Fragment findFragmentById(int id) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_457800808 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_522505630 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_439595692 = null; 
        {
            {
                int i = mAdded.size()-1;
                {
                    Fragment f = mAdded.get(i);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_457800808 = f;
                    } 
                } 
            } 
            {
                int i = mActive.size()-1;
                {
                    Fragment f = mActive.get(i);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_522505630 = f;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_439595692 = null;
        addTaint(id);
        Fragment varA7E53CE21691AB073D9660D615818899_1596909046; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1596909046 = varB4EAC82CA7396A68D541C85D26508E83_457800808;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1596909046 = varB4EAC82CA7396A68D541C85D26508E83_522505630;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1596909046 = varB4EAC82CA7396A68D541C85D26508E83_439595692;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1596909046.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1596909046;
        
        
            
                
                
                    
                
            
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.365 -0400", hash_original_method = "5F9B0395F726C1A39BFC043E2E96E889", hash_generated_method = "F5004D870209E40474E2DE5227F65535")
    public Fragment findFragmentByTag(String tag) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_400518269 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_751258608 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_619310805 = null; 
        {
            {
                int i = mAdded.size()-1;
                {
                    Fragment f = mAdded.get(i);
                    {
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_970840771 = (f != null && tag.equals(f.mTag));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_400518269 = f;
                        } 
                    } 
                } 
            } 
            {
                int i = mActive.size()-1;
                {
                    Fragment f = mActive.get(i);
                    {
                        boolean varE3A4AACA02673214B7ADB964E9FD7FFF_991030787 = (f != null && tag.equals(f.mTag));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_751258608 = f;
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_619310805 = null;
        addTaint(tag.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_248810864; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_248810864 = varB4EAC82CA7396A68D541C85D26508E83_400518269;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_248810864 = varB4EAC82CA7396A68D541C85D26508E83_751258608;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_248810864 = varB4EAC82CA7396A68D541C85D26508E83_619310805;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_248810864.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_248810864;
        
        
            
                
                
                    
                
            
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.366 -0400", hash_original_method = "BBAAD10FC9AB450B3B7E8CD0A108A471", hash_generated_method = "7AE9C04DC5B3BD183A0A5F51FD280752")
    public Fragment findFragmentByWho(String who) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1899647684 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_418975406 = null; 
        {
            {
                int i = mActive.size()-1;
                {
                    Fragment f = mActive.get(i);
                    {
                        boolean var9326B715BF996C787D3FE61249DC42AB_1400208676 = (f != null && who.equals(f.mWho));
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1899647684 = f;
                        } 
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_418975406 = null;
        addTaint(who.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_901455107; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_901455107 = varB4EAC82CA7396A68D541C85D26508E83_1899647684;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_901455107 = varB4EAC82CA7396A68D541C85D26508E83_418975406;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_901455107.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_901455107;
        
        
            
                
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.366 -0400", hash_original_method = "B87B380B690A16EB7F37B7EE1C0A0D26", hash_generated_method = "4076EE59F13ECCD4B07230734A017E5F")
    private void checkStateLoss() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Can not perform this action after onSaveInstanceState");
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Can not perform this action inside of " + mNoTransactionsBecause);
        } 
        
        
            
                    
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.367 -0400", hash_original_method = "32359130EC903AF4E096237D1F067453", hash_generated_method = "CCD96CD9DA7E971A8DEDF1CC8446B788")
    public void enqueueAction(Runnable action, boolean allowStateLoss) {
        {
            checkStateLoss();
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Activity has been destroyed");
            } 
            {
                mPendingActions = new ArrayList<Runnable>();
            } 
            mPendingActions.add(action);
            {
                boolean varED396C6F84781DC21825B4A03F526E3B_1056501214 = (mPendingActions.size() == 1);
                {
                    mActivity.mHandler.removeCallbacks(mExecCommit);
                    mActivity.mHandler.post(mExecCommit);
                } 
            } 
        } 
        addTaint(action.getTaint());
        addTaint(allowStateLoss);
        
        
            
        
        
            
                
            
            
                
            
            
            
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.368 -0400", hash_original_method = "1503673DA6CC1FF53261337C6A89F6BE", hash_generated_method = "237F2CBCEB3E568884EB135708351BF4")
    public int allocBackStackIndex(BackStackRecord bse) {
        {
            {
                boolean var98612EE02F6CF00DE971BBFA890C1BB0_808967419 = (mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0);
                {
                    {
                        mBackStackIndices = new ArrayList<BackStackRecord>();
                    } 
                    int index = mBackStackIndices.size();
                    mBackStackIndices.add(bse);
                } 
                {
                    int index = mAvailBackStackIndices.remove(mAvailBackStackIndices.size()-1);
                    mBackStackIndices.set(index, bse);
                } 
            } 
        } 
        addTaint(bse.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045834121 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045834121;
        
        
            
                
                    
                
                
                
                
                
            
                
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.369 -0400", hash_original_method = "F0AF804A23A686630C8F5E2012EB99F7", hash_generated_method = "EBA023A4351056E75951D9F29267B91A")
    public void setBackStackIndex(int index, BackStackRecord bse) {
        {
            {
                mBackStackIndices = new ArrayList<BackStackRecord>();
            } 
            int N = mBackStackIndices.size();
            {
                mBackStackIndices.set(index, bse);
            } 
            {
                {
                    mBackStackIndices.add(null);
                    {
                        mAvailBackStackIndices = new ArrayList<Integer>();
                    } 
                    mAvailBackStackIndices.add(N);
                } 
                mBackStackIndices.add(bse);
            } 
        } 
        addTaint(index);
        addTaint(bse.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.370 -0400", hash_original_method = "A75FE5CB17552EA725360407924677A5", hash_generated_method = "AFDDA9DE97FC9DF3E5F4BF723FE82F1A")
    public void freeBackStackIndex(int index) {
        {
            mBackStackIndices.set(index, null);
            {
                mAvailBackStackIndices = new ArrayList<Integer>();
            } 
            mAvailBackStackIndices.add(index);
        } 
        addTaint(index);
        
        
            
            
                
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.371 -0400", hash_original_method = "2EC9B9D8ABC4926EA1F7FF85BE00D458", hash_generated_method = "8310F59D6BFC5F3D0C77764C2E66DB66")
    public boolean execPendingActions() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Recursive entry to executePendingTransactions");
        } 
        {
            boolean var92CCD900C583B95C908C1457DCFC97EB_582704348 = (Looper.myLooper() != mActivity.mHandler.getLooper());
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Must be called from main thread of process");
            } 
        } 
        boolean didSomething = false;
        {
            int numActions;
            {
                {
                    boolean var8F64D3B59DFFB1D978D9FFAE1E7D437D_1713827702 = (mPendingActions == null || mPendingActions.size() == 0);
                } 
                numActions = mPendingActions.size();
                {
                    mTmpActions = new Runnable[numActions];
                } 
                mPendingActions.toArray(mTmpActions);
                mPendingActions.clear();
                mActivity.mHandler.removeCallbacks(mExecCommit);
            } 
            mExecutingActions = true;
            {
                int i = 0;
                {
                    mTmpActions[i].run();
                    mTmpActions[i] = null;
                } 
            } 
            mExecutingActions = false;
            didSomething = true;
        } 
        {
            boolean loadersRunning = false;
            {
                int i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_1105492354 = (i<mActive.size());
                {
                    Fragment f = mActive.get(i);
                    {
                        loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                    } 
                } 
            } 
            {
                mHavePendingDeferredStart = false;
                startPendingDeferredFragments();
            } 
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2015590990 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2015590990;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.372 -0400", hash_original_method = "480CA24D6CDDA51ECD1DFDE903041169", hash_generated_method = "97856BD4850A00EE2EADB2C1BEAF853B")
     void reportBackStackChanged() {
        {
            {
                int i = 0;
                boolean var3737AEDF4226FD639F6461E15393E309_218479969 = (i<mBackStackChangeListeners.size());
                {
                    mBackStackChangeListeners.get(i).onBackStackChanged();
                } 
            } 
        } 
        
        
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.374 -0400", hash_original_method = "93C61FA561A07CB0E9B057A7A904C282", hash_generated_method = "FF183CDFF9871413611B0CFF67FE69C7")
     void addBackStackState(BackStackRecord state) {
        {
            mBackStack = new ArrayList<BackStackRecord>();
        } 
        mBackStack.add(state);
        reportBackStackChanged();
        addTaint(state.getTaint());
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.375 -0400", hash_original_method = "2DCA4D0949EEA78B53FF55FD7B1EE1F8", hash_generated_method = "5D2C656B1645DBE45E0BE41737FE0E78")
     boolean popBackStackState(Handler handler, String name, int id, int flags) {
        {
            int last = mBackStack.size()-1;
            final BackStackRecord bss = mBackStack.remove(last);
            bss.popFromBackStack(true);
            reportBackStackChanged();
        } 
        {
            int index = -1;
            {
                index = mBackStack.size()-1;
                {
                    BackStackRecord bss = mBackStack.get(index);
                    {
                        boolean varBEA6676FD08F9A893EB03C8E97D94F9C_1174197181 = (name != null && name.equals(bss.getName()));
                    } 
                } 
                {
                    {
                        BackStackRecord bss = mBackStack.get(index);
                        {
                            boolean varF7B12DD1A8F871B2F43DC36592D3ADBE_820594273 = ((name != null && name.equals(bss.getName()))
                                || (id >= 0 && id == bss.mIndex));
                        } 
                    } 
                } 
            } 
            {
                boolean var4A958E5CC0AD80F8568B9E8089EACA0B_1224247115 = (index == mBackStack.size()-1);
            } 
            final ArrayList<BackStackRecord> states = new ArrayList<BackStackRecord>();
            {
                int i = mBackStack.size()-1;
                {
                    states.add(mBackStack.remove(i));
                } 
            } 
            final int LAST = states.size()-1;
            {
                int i = 0;
                {
                    states.get(i).popFromBackStack(i == LAST);
                } 
            } 
            reportBackStackChanged();
        } 
        addTaint(handler.getTaint());
        addTaint(name.getTaint());
        addTaint(id);
        addTaint(flags);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_144557334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_144557334;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.376 -0400", hash_original_method = "C4579656BDDD252D61818FF4E8F19896", hash_generated_method = "6C3C2A9DBAD8258A86CDC50004349D2D")
     ArrayList<Fragment> retainNonConfig() {
        ArrayList<Fragment> varB4EAC82CA7396A68D541C85D26508E83_187019113 = null; 
        ArrayList<Fragment> fragments = null;
        {
            {
                int i = 0;
                boolean var2E483A1271BDE2FC27F0CB7948500179_1322257057 = (i<mActive.size());
                {
                    Fragment f = mActive.get(i);
                    {
                        {
                            fragments = new ArrayList<Fragment>();
                        } 
                        fragments.add(f);
                        f.mRetaining = true;
                        f.mTargetIndex = f.mTarget != null ? f.mTarget.mIndex : -1;
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_187019113 = fragments;
        varB4EAC82CA7396A68D541C85D26508E83_187019113.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_187019113;
        
        
        
            
                
                
                    
                        
                    
                    
                    
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.377 -0400", hash_original_method = "90803A489E5220D7765DFCAE4FAFF7AC", hash_generated_method = "267786C4ACC034990DF9FA64E765FB7A")
     void saveFragmentViewState(Fragment f) {
        {
            mStateArray = new SparseArray<Parcelable>();
        } 
        {
            mStateArray.clear();
        } 
        f.mView.saveHierarchyState(mStateArray);
        {
            boolean var10CB5DFFB182D477A1F1C08C2A2A4D10_258596295 = (mStateArray.size() > 0);
            {
                f.mSavedViewState = mStateArray;
                mStateArray = null;
            } 
        } 
        addTaint(f.getTaint());
        
        
            
        
        
            
        
            
        
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.378 -0400", hash_original_method = "DCA5B6BB14B617A2A3ED4183EF745130", hash_generated_method = "8283898F9F2811E4F5AA4BDAAF7DFB03")
     Bundle saveFragmentBasicState(Fragment f) {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1490538424 = null; 
        Bundle result = null;
        {
            mStateBundle = new Bundle();
        } 
        f.onSaveInstanceState(mStateBundle);
        {
            boolean var5AE1326457CED87C792B211942E81B2E_1534934641 = (!mStateBundle.isEmpty());
            {
                result = mStateBundle;
                mStateBundle = null;
            } 
        } 
        {
            saveFragmentViewState(f);
        } 
        {
            {
                result = new Bundle();
            } 
            result.putSparseParcelableArray(
                    FragmentManagerImpl.VIEW_STATE_TAG, f.mSavedViewState);
        } 
        {
            result.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, f.mUserVisibleHint);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1490538424 = result;
        addTaint(f.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1490538424.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1490538424;
        
        
        
            
        
        
        
            
            
        
        
            
        
        
            
                
            
            
                    
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.381 -0400", hash_original_method = "5A6DADDDEE90F93280222EE0F5B508C8", hash_generated_method = "32F612ED0F69941A382D3A012C879CDB")
     Parcelable saveAllState() {
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_1295063053 = null; 
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_634381032 = null; 
        Parcelable varB4EAC82CA7396A68D541C85D26508E83_375110116 = null; 
        execPendingActions();
        mStateSaved = true;
        {
            boolean var7B1A0FE06CC77C5BE5C8EE27C706FD90_996612695 = (mActive == null || mActive.size() <= 0);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1295063053 = null;
            } 
        } 
        int N = mActive.size();
        FragmentState[] active = new FragmentState[N];
        boolean haveFragments = false;
        {
            int i = 0;
            {
                Fragment f = mActive.get(i);
                {
                    haveFragments = true;
                    FragmentState fs = new FragmentState(f);
                    active[i] = fs;
                    {
                        fs.mSavedFragmentState = saveFragmentBasicState(f);
                        {
                            {
                                String msg = "Failure saving state: " + f
                                + " has target not in fragment manager: " + f.mTarget;
                                dump("  ", null, new PrintWriter(new LogWriter(
                                    Log.ERROR, TAG, Log.LOG_ID_SYSTEM)), new String[] { });
                                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(msg);
                            } 
                            {
                                fs.mSavedFragmentState = new Bundle();
                            } 
                            putFragment(fs.mSavedFragmentState,
                                FragmentManagerImpl.TARGET_STATE_TAG, f.mTarget);
                            {
                                fs.mSavedFragmentState.putInt(
                                    FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG,
                                    f.mTargetRequestCode);
                            } 
                        } 
                    } 
                    {
                        fs.mSavedFragmentState = f.mSavedFragmentState;
                    } 
                } 
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_634381032 = null;
        } 
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
                    } 
                } 
            } 
        } 
        {
            N = mBackStack.size();
            {
                backStack = new BackStackState[N];
                {
                    int i = 0;
                    {
                        backStack[i] = new BackStackState(this, mBackStack.get(i));
                    } 
                } 
            } 
        } 
        FragmentManagerState fms = new FragmentManagerState();
        fms.mActive = active;
        fms.mAdded = added;
        fms.mBackStack = backStack;
        varB4EAC82CA7396A68D541C85D26508E83_375110116 = fms;
        Parcelable varA7E53CE21691AB073D9660D615818899_1201669007; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1201669007 = varB4EAC82CA7396A68D541C85D26508E83_1295063053;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1201669007 = varB4EAC82CA7396A68D541C85D26508E83_634381032;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1201669007 = varB4EAC82CA7396A68D541C85D26508E83_375110116;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1201669007.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1201669007;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.386 -0400", hash_original_method = "CDDD12666FB804E6E56655D62533D556", hash_generated_method = "272969C20B241EC48D50D494F23E9729")
     void restoreAllState(Parcelable state, ArrayList<Fragment> nonConfig) {
        FragmentManagerState fms = (FragmentManagerState)state;
        {
            {
                int i = 0;
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_892493959 = (i<nonConfig.size());
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
                    } 
                } 
            } 
        } 
        mActive = new ArrayList<Fragment>(fms.mActive.length);
        {
            mAvailIndices.clear();
        } 
        {
            int i = 0;
            {
                FragmentState fs = fms.mActive[i];
                {
                    Fragment f = fs.instantiate(mActivity);
                    mActive.add(f);
                    fs.mInstance = null;
                } 
                {
                    mActive.add(null);
                    {
                        mAvailIndices = new ArrayList<Integer>();
                    } 
                    mAvailIndices.add(i);
                } 
            } 
        } 
        {
            {
                int i = 0;
                boolean var5CC5050FB8FEA377AFBC852C0C159F2C_394393876 = (i<nonConfig.size());
                {
                    Fragment f = nonConfig.get(i);
                    {
                        {
                            boolean var487621A5D4BD2ACED481B16F5F5948D3_69012692 = (f.mTargetIndex < mActive.size());
                            {
                                f.mTarget = mActive.get(f.mTargetIndex);
                            } 
                            {
                                f.mTarget = null;
                            } 
                        } 
                    } 
                } 
            } 
        } 
        {
            mAdded = new ArrayList<Fragment>(fms.mAdded.length);
            {
                int i = 0;
                {
                    Fragment f = mActive.get(fms.mAdded[i]);
                    {
                        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                            "No instantiated fragment for index #" + fms.mAdded[i]);
                    } 
                    f.mAdded = true;
                    mAdded.add(f);
                } 
            } 
        } 
        {
            mAdded = null;
        } 
        {
            mBackStack = new ArrayList<BackStackRecord>(fms.mBackStack.length);
            {
                int i = 0;
                {
                    BackStackRecord bse = fms.mBackStack[i].instantiate(this);
                    mBackStack.add(bse);
                    {
                        setBackStackIndex(bse.mIndex, bse);
                    } 
                } 
            } 
        } 
        {
            mBackStack = null;
        } 
        addTaint(state.getTaint());
        addTaint(nonConfig.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.387 -0400", hash_original_method = "1A90D3789635EF8BA5063E635EAF56EA", hash_generated_method = "37976AEEA763C628AAA13A4731453519")
    public void attachActivity(Activity activity) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException();
        mActivity = activity;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.388 -0400", hash_original_method = "9E4E3FCA42BDE19CBF71140223B4B8D0", hash_generated_method = "B5C7E72CCEE273A62746EE3408615591")
    public void noteStateNotSaved() {
        mStateSaved = false;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.388 -0400", hash_original_method = "4EAFC4D017ED2B44474902CD00BD047E", hash_generated_method = "21C3627E95BE86042A719066A2913EA6")
    public void dispatchCreate() {
        mStateSaved = false;
        moveToState(Fragment.CREATED, false);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.389 -0400", hash_original_method = "BB3D6B45374259B5EE70270EF5FFE721", hash_generated_method = "1F7202ED50DB7895525D3D5DD1A85A9D")
    public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(Fragment.ACTIVITY_CREATED, false);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.390 -0400", hash_original_method = "145C9AF81AEB697CB534D8E0C0F599A0", hash_generated_method = "20844DC4E325108731D69AD369D5CB9A")
    public void dispatchStart() {
        mStateSaved = false;
        moveToState(Fragment.STARTED, false);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.390 -0400", hash_original_method = "35325401D14378833F40C78A6FC3DC5D", hash_generated_method = "9E4D22D120F9A6B67EA4BB2B4DEB3341")
    public void dispatchResume() {
        mStateSaved = false;
        moveToState(Fragment.RESUMED, false);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.391 -0400", hash_original_method = "E6EE1A1408209BDB9066272C26AA9863", hash_generated_method = "806CEF702E5812DC1949A4F8EE32F575")
    public void dispatchPause() {
        moveToState(Fragment.STARTED, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.391 -0400", hash_original_method = "AF2E4C7CBE2D28416278336F31B9AFFC", hash_generated_method = "C441D21E31BC8B8A9609B8D4D6E7ECAA")
    public void dispatchStop() {
        moveToState(Fragment.STOPPED, false);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.392 -0400", hash_original_method = "A94A97B8768D84C8034BA8478DD395DC", hash_generated_method = "C5BBDC804266F378AABECFFC198DA3FC")
    public void dispatchDestroy() {
        mDestroyed = true;
        execPendingActions();
        moveToState(Fragment.INITIALIZING, false);
        mActivity = null;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.394 -0400", hash_original_method = "5117E19429D94CDE29C750CF70651BE9", hash_generated_method = "3BD5FC4643F2CA12F46692854D41FB99")
    public void dispatchConfigurationChanged(Configuration newConfig) {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_139288784 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        f.onConfigurationChanged(newConfig);
                    } 
                } 
            } 
        } 
        addTaint(newConfig.getTaint());
        
        
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.395 -0400", hash_original_method = "BC8D3EC4480A5918F3A38ABAC82A7ED6", hash_generated_method = "1B924F74230A1F47C9F3F27F44D098B3")
    public void dispatchLowMemory() {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_138734092 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        f.onLowMemory();
                    } 
                } 
            } 
        } 
        
        
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.395 -0400", hash_original_method = "81FEC8A34B79BC0E01F9FFFE05F1478B", hash_generated_method = "1CF5086AAB67870B584C8E9F5F4F8592")
    public void dispatchTrimMemory(int level) {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1330161928 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        f.onTrimMemory(level);
                    } 
                } 
            } 
        } 
        addTaint(level);
        
        
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.396 -0400", hash_original_method = "059A23578A0DB56C84349E8F783E9AC3", hash_generated_method = "73F7161EF980D8D7611824D5E37A48B3")
    public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_330070216 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        show = true;
                        f.onCreateOptionsMenu(menu, inflater);
                        {
                            newMenus = new ArrayList<Fragment>();
                        } 
                        newMenus.add(f);
                    } 
                } 
            } 
        } 
        {
            {
                int i = 0;
                boolean var829574F28570EB1E74183020953B6E4B_961918580 = (i<mCreatedMenus.size());
                {
                    Fragment f = mCreatedMenus.get(i);
                    {
                        boolean varF740BD6A5A57A11B5D73D0A67A04AEFC_956874889 = (newMenus == null || !newMenus.contains(f));
                        {
                            f.onDestroyOptionsMenu();
                        } 
                    } 
                } 
            } 
        } 
        mCreatedMenus = newMenus;
        addTaint(menu.getTaint());
        addTaint(inflater.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2130086118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2130086118;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.397 -0400", hash_original_method = "3C4E4DD19A75168CEF9873DFBC1B4179", hash_generated_method = "ACE6C39E7371AD41355CB0A704DD4E95")
    public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean show = false;
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1405671889 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        show = true;
                        f.onPrepareOptionsMenu(menu);
                    } 
                } 
            } 
        } 
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451764276 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_451764276;
        
        
        
            
                
                
                    
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.397 -0400", hash_original_method = "16456DF238276E24923F6AD552304983", hash_generated_method = "98562A877264315369481CE2313CBB38")
    public boolean dispatchOptionsItemSelected(MenuItem item) {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1088289176 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        {
                            boolean varE78EB04814153BF35CF96C1AE499F5B5_694625323 = (f.onOptionsItemSelected(item));
                        } 
                    } 
                } 
            } 
        } 
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1298561334 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1298561334;
        
        
            
                
                
                    
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.398 -0400", hash_original_method = "F1ECF21855715BC93D4867D907434D91", hash_generated_method = "15FA98A41B4F7E993CA752297CAA3F00")
    public boolean dispatchContextItemSelected(MenuItem item) {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_1703659600 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        {
                            boolean var48F0CD0D37FBD8298C20892C7FC62FDA_1515682029 = (f.onContextItemSelected(item));
                        } 
                    } 
                } 
            } 
        } 
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_586891293 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_586891293;
        
        
            
                
                
                    
                        
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.398 -0400", hash_original_method = "EA4F9A660842285D75622DB2DA97E1AE", hash_generated_method = "06D2896BC4DD7E578167C94DBCB021FE")
    public void dispatchOptionsMenuClosed(Menu menu) {
        {
            {
                int i = 0;
                boolean var42696F887AFE955548143C6A21B70BC8_870699075 = (i<mAdded.size());
                {
                    Fragment f = mAdded.get(i);
                    {
                        f.onOptionsMenuClosed(menu);
                    } 
                } 
            } 
        } 
        addTaint(menu.getTaint());
        
        
            
                
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.399 -0400", hash_original_method = "5756D303078CA095AB87E344CED6E29B", hash_generated_method = "548106A013399E869E8B72F313E0BDD1")
    @Override
    public void invalidateOptionsMenu() {
        {
            mActivity.invalidateOptionsMenu();
        } 
        {
            mNeedMenuInvalidate = true;
        } 
        
        
            
        
            
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.400 -0400", hash_original_field = "021906CCEC815FC820B74F760E7368C7", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.400 -0400", hash_original_field = "309AAD3E76F171051A35712763096DE8", hash_generated_field = "82CCA249F4AC6A9E8A18392D953FCA5D")

    static final String TAG = "FragmentManager";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.400 -0400", hash_original_field = "E58DEFB2E4C5F4C4BC898BC35F33C192", hash_generated_field = "3B27731C0E9DDDFC7028C0BFB720297D")

    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.400 -0400", hash_original_field = "A8D8A7593440E0D7D4A8A21F4BCD6D54", hash_generated_field = "9220E2EDA94C70BA7341F1BFB405D6BF")

    static final String TARGET_STATE_TAG = "android:target_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.400 -0400", hash_original_field = "03990A2696101FE20E375C710E3F3AE1", hash_generated_field = "C8F5F7A2B0A3F70631E3897CD07F0E4E")

    static final String VIEW_STATE_TAG = "android:view_state";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.400 -0400", hash_original_field = "80B57815D7CE7602226A48E51B42D058", hash_generated_field = "43219A21E686E6FEC3DF87B97E67132D")

    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
}

