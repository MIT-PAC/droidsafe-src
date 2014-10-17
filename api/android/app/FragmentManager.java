package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Slog;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

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
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public abstract class FragmentManager {

    /**
     * Control whether the framework's internal fragment manager debugging
     * logs are turned on.  If enabled, you will see output in logcat as
     * the framework performs fragment operations.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.328 -0500", hash_original_method = "F85B69D8648CC374BBF72D9494B795E2", hash_generated_method = "1B390773BA665B18CA47C23EB9D733ED")
    
public static void enableDebugLogging(boolean enabled) {
        FragmentManagerImpl.DEBUG = enabled;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.293 -0500", hash_original_field = "A37EC55D90220D1054C63CAEF06B11D6", hash_generated_field = "3F74866CBC8F49655F2B8BB97CC17F5E")

    public static final int POP_BACK_STACK_INCLUSIVE = 1<<0;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.606 -0400", hash_original_method = "0D3FEDE97BC3242ED64134E1F014EA11", hash_generated_method = "0D3FEDE97BC3242ED64134E1F014EA11")
    
    public FragmentManager ()
    {
        //Synthesized constructor
    }

    /**
     * Start a series of edit operations on the Fragments associated with
     * this FragmentManager.
     * 
     * <p>Note: A fragment transaction can only be created/committed prior
     * to an activity saving its state.  If you try to commit a transaction
     * after {@link Activity#onSaveInstanceState Activity.onSaveInstanceState()}
     * (and prior to a following {@link Activity#onStart Activity.onStart}
     * or {@link Activity#onResume Activity.onResume()}, you will get an error.
     * This is because the framework takes care of saving your current fragments
     * in the state, and if changes are made after the state is saved then they
     * will be lost.</p>
     */
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.282 -0500", hash_original_method = "BE048CD13A2D9177864E9AE5CA89385C", hash_generated_method = "179BF9392A437EED545CF6A3F093EC20")
    
public abstract FragmentTransaction beginTransaction();

    /** @hide -- remove once prebuilts are in. */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.285 -0500", hash_original_method = "0DA67415D41DB3C4C9D7AB80CD2D78FE", hash_generated_method = "7B5BD006136DB217141D24C35BA0CCDB")
    
@Deprecated
    public FragmentTransaction openTransaction() {
        return beginTransaction();
    }
    
    /**
     * After a {@link FragmentTransaction} is committed with
     * {@link FragmentTransaction#commit FragmentTransaction.commit()}, it
     * is scheduled to be executed asynchronously on the process's main thread.
     * If you want to immediately executing any such pending operations, you
     * can call this function (only from the main thread) to do so.  Note that
     * all callbacks and other related behavior will be done from within this
     * call, so be careful about where this is called from.
     *
     * @return Returns true if there were any pending transactions to be
     * executed.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.287 -0500", hash_original_method = "5B9A3D87E7345C957FA5717C0C10C635", hash_generated_method = "66BAE45C691B1AB5E9BB1A84AE41D8A2")
    
public abstract boolean executePendingTransactions();

    /**
     * Finds a fragment that was identified by the given id either when inflated
     * from XML or as the container ID when added in a transaction.  This first
     * searches through fragments that are currently added to the manager's
     * activity; if no such fragment is found, then all fragments currently
     * on the back stack associated with this ID are searched.
     * @return The fragment if found or null otherwise.
     */
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.289 -0500", hash_original_method = "F331A49B0DAC9D1709118DA3B3769DC9", hash_generated_method = "4C6F6CF41EE287D45A81567EBA8CB5D6")
    
public abstract Fragment findFragmentById(int id);

    /**
     * Finds a fragment that was identified by the given tag either when inflated
     * from XML or as supplied when added in a transaction.  This first
     * searches through fragments that are currently added to the manager's
     * activity; if no such fragment is found, then all fragments currently
     * on the back stack are searched.
     * @return The fragment if found or null otherwise.
     */
    
    @DSComment("Abstract Method")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.291 -0500", hash_original_method = "06F2C60B02B6436122252A9A18FF6B5B", hash_generated_method = "8A748374863BCFCFE22454ABCA2FE261")
    
public abstract Fragment findFragmentByTag(String tag);

    /**
     * Pop the top state off the back stack.  This function is asynchronous -- it
     * enqueues the request to pop, but the action will not be performed until the
     * application returns to its event loop.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.296 -0500", hash_original_method = "8DD8850C5659D39934906ED127571123", hash_generated_method = "06152C82F0BE43992BE41413F4D5A3F1")
    
public abstract void popBackStack();

    /**
     * Like {@link #popBackStack()}, but performs the operation immediately
     * inside of the call.  This is like calling {@link #executePendingTransactions()}
     * afterwards.
     * @return Returns true if there was something popped, else false.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.298 -0500", hash_original_method = "7B6675A0CB9AF3263371BDE096DAF2A9", hash_generated_method = "2C3F7FF8856F557CE69F0CF46B2F4937")
    
public abstract boolean popBackStackImmediate();

    /**
     * Pop the last fragment transition from the manager's fragment
     * back stack.  If there is nothing to pop, false is returned.
     * This function is asynchronous -- it enqueues the
     * request to pop, but the action will not be performed until the application
     * returns to its event loop.
     * 
     * @param name If non-null, this is the name of a previous back state
     * to look for; if found, all states up to that state will be popped.  The
     * {@link #POP_BACK_STACK_INCLUSIVE} flag can be used to control whether
     * the named state itself is popped. If null, only the top state is popped.
     * @param flags Either 0 or {@link #POP_BACK_STACK_INCLUSIVE}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.300 -0500", hash_original_method = "7371282EB954218CB5BB647DBEFB9C4D", hash_generated_method = "DA4FB7A38FD1A9723E0C9FB977608D32")
    
public abstract void popBackStack(String name, int flags);

    /**
     * Like {@link #popBackStack(String, int)}, but performs the operation immediately
     * inside of the call.  This is like calling {@link #executePendingTransactions()}
     * afterwards.
     * @return Returns true if there was something popped, else false.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.302 -0500", hash_original_method = "E1C9735BC76D749F9AAB42E9F89374F3", hash_generated_method = "ADFC94D0AAB8081D7BCE139575F65351")
    
public abstract boolean popBackStackImmediate(String name, int flags);

    /**
     * Pop all back stack states up to the one with the given identifier.
     * This function is asynchronous -- it enqueues the
     * request to pop, but the action will not be performed until the application
     * returns to its event loop.
     * 
     * @param id Identifier of the stated to be popped. If no identifier exists,
     * false is returned.
     * The identifier is the number returned by
     * {@link FragmentTransaction#commit() FragmentTransaction.commit()}.  The
     * {@link #POP_BACK_STACK_INCLUSIVE} flag can be used to control whether
     * the named state itself is popped.
     * @param flags Either 0 or {@link #POP_BACK_STACK_INCLUSIVE}.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.304 -0500", hash_original_method = "5DFB5C2F3CB06A536CC67665FD5A1850", hash_generated_method = "AFB34329D29F80428B05B6ACD88A1183")
    
public abstract void popBackStack(int id, int flags);

    /**
     * Like {@link #popBackStack(int, int)}, but performs the operation immediately
     * inside of the call.  This is like calling {@link #executePendingTransactions()}
     * afterwards.
     * @return Returns true if there was something popped, else false.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.306 -0500", hash_original_method = "4468A20E5A85CF532490B1BC373EE3E6", hash_generated_method = "B7D3372DC7597245DDCCDC11FB8C5F74")
    
public abstract boolean popBackStackImmediate(int id, int flags);

    /**
     * Return the number of entries currently in the back stack.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.309 -0500", hash_original_method = "8EAEBBF64A73FEF70E3B2DC6C5497EE9", hash_generated_method = "F5E4FA5B0AAD9A1C436033C01C3AAABD")
    
public abstract int getBackStackEntryCount();

    /**
     * Return the BackStackEntry at index <var>index</var> in the back stack;
     * entries start index 0 being the bottom of the stack.
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.312 -0500", hash_original_method = "C6BA46BCDC4C883DD39DC808512584CC", hash_generated_method = "79204E9430B6FA67CEF534DB5F847CAE")
    
public abstract BackStackEntry getBackStackEntryAt(int index);

    /**
     * Add a new listener for changes to the fragment back stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.314 -0500", hash_original_method = "4677CACA63B2CFD2A78E39C8A8FB92BF", hash_generated_method = "728832396021C02BD842F607945CFEC0")
    
public abstract void addOnBackStackChangedListener(OnBackStackChangedListener listener);

    /**
     * Remove a listener that was previously added with
     * {@link #addOnBackStackChangedListener(OnBackStackChangedListener)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.316 -0500", hash_original_method = "75368BB8382567FE8CD9BFB84C582622", hash_generated_method = "69736F023C3DB7E029FFFB58A3A4877E")
    
public abstract void removeOnBackStackChangedListener(OnBackStackChangedListener listener);

    /**
     * Put a reference to a fragment in a Bundle.  This Bundle can be
     * persisted as saved state, and when later restoring
     * {@link #getFragment(Bundle, String)} will return the current
     * instance of the same fragment.
     *
     * @param bundle The bundle in which to put the fragment reference.
     * @param key The name of the entry in the bundle.
     * @param fragment The Fragment whose reference is to be stored.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.318 -0500", hash_original_method = "8451101D4DDA3AE9BA2F091778F6ACC9", hash_generated_method = "C529CCC132EFEB14EBA38652ABAFD702")
    
public abstract void putFragment(Bundle bundle, String key, Fragment fragment);

    /**
     * Retrieve the current Fragment instance for a reference previously
     * placed with {@link #putFragment(Bundle, String, Fragment)}.
     *
     * @param bundle The bundle from which to retrieve the fragment reference.
     * @param key The name of the entry in the bundle.
     * @return Returns the current Fragment instance that is associated with
     * the given reference.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.320 -0500", hash_original_method = "1FBEC41A2754AD4627511B440BD8CDF6", hash_generated_method = "0F634E6958A473C8D2E8404CF8C8DB24")
    
public abstract Fragment getFragment(Bundle bundle, String key);

    /**
     * Save the current instance state of the given Fragment.  This can be
     * used later when creating a new instance of the Fragment and adding
     * it to the fragment manager, to have it create itself to match the
     * current state returned here.  Note that there are limits on how
     * this can be used:
     *
     * <ul>
     * <li>The Fragment must currently be attached to the FragmentManager.
     * <li>A new Fragment created using this saved state must be the same class
     * type as the Fragment it was created from.
     * <li>The saved state can not contain dependencies on other fragments --
     * that is it can't use {@link #putFragment(Bundle, String, Fragment)} to
     * store a fragment reference because that reference may not be valid when
     * this saved state is later used.  Likewise the Fragment's target and
     * result code are not included in this state.
     * </ul>
     *
     * @param f The Fragment whose state is to be saved.
     * @return The generated state.  This will be null if there was no
     * interesting state created by the fragment.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.323 -0500", hash_original_method = "70232028C6041780F1572B4693E04940", hash_generated_method = "D7143037D7EB1134407060B9E85E5B14")
    
public abstract Fragment.SavedState saveFragmentInstanceState(Fragment f);

    /**
     * Print the FragmentManager's state into the given stream.
     *
     * @param prefix Text to print at the front of each line.
     * @param fd The raw file descriptor that the dump is being sent to.
     * @param writer A PrintWriter to which the dump is to be set.
     * @param args Additional arguments to the dump request.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.325 -0500", hash_original_method = "9309E77AA4047B9B8316706781ED0A27", hash_generated_method = "3FF3D3380483C9ADF611F5CA2E5A6D00")
    
public abstract void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args);
    
    public interface BackStackEntry {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int getId();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public String getName();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int getBreadCrumbTitleRes();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public int getBreadCrumbShortTitleRes();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public CharSequence getBreadCrumbTitle();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public CharSequence getBreadCrumbShortTitle();
    }
    
    public interface OnBackStackChangedListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onBackStackChanged();
    }

    /**
     * Invalidate the attached activity's options menu as necessary.
     * This may end up being deferred until we move to the resumed state.
     */
    @DSComment("GUI, Fragment Manager")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.330 -0500", hash_original_method = "15ED404039200ACA8749491C77846D3D", hash_generated_method = "DE6B424A8F77F63D6BB0CDF1DD7295F2")
    
public void invalidateOptionsMenu() { }
}

final class FragmentManagerState implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.618 -0400", hash_original_field = "D29AA2723BAE7915447DC2F30F3AAA56", hash_generated_field = "EE9672AF4023C35BB0D72B0356E5DA5C")

    public static final Parcelable.Creator<FragmentManagerState> CREATOR
            = new Parcelable.Creator<FragmentManagerState>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.348 -0500", hash_original_method = "ECDC6A4E7C91D1C5B65C994C4484624F", hash_generated_method = "C02CF7F6521D674473A0622E67866AE4")
        
        @DSSafe(DSCat.SAFE_LIST)
public FragmentManagerState createFromParcel(Parcel in) {
            return new FragmentManagerState(in);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.351 -0500", hash_original_method = "91265EDFBDBEA59F353323C915A4EF4F", hash_generated_method = "BC21AC906A7818F48F75A0EFD7490E16")
        
        @DSSafe(DSCat.SAFE_LIST)
public FragmentManagerState[] newArray(int size) {
            return new FragmentManagerState[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.333 -0500", hash_original_field = "0C91046A014C3ABDDA41BA020BEE7D35", hash_generated_field = "0C91046A014C3ABDDA41BA020BEE7D35")

    FragmentState[] mActive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.334 -0500", hash_original_field = "4D5C3ED026B5D0195A6077AFCD696836", hash_generated_field = "4D5C3ED026B5D0195A6077AFCD696836")

    int[] mAdded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.336 -0500", hash_original_field = "EEA20C5C67D270067553BCDE313A7B27", hash_generated_field = "EEA20C5C67D270067553BCDE313A7B27")

    BackStackState[] mBackStack;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.339 -0500", hash_original_method = "4ADB2DBBD6899E89144480A7958A6490", hash_generated_method = "001680BC3C0AA33814887A60387200FC")
    
public FragmentManagerState() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.342 -0500", hash_original_method = "020574327F1D57965B67553DD6F7D979", hash_generated_method = "0BC13CF9A5CCCFDAA729B873E1891B0B")
    
public FragmentManagerState(Parcel in) {
        mActive = in.createTypedArray(FragmentState.CREATOR);
        mAdded = in.createIntArray();
        mBackStack = in.createTypedArray(BackStackState.CREATOR);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.344 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.346 -0500", hash_original_method = "B6654BF7A24842DC15E6AD3A5F27203C", hash_generated_method = "EE219290863A0576BAFED6B568C39258")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(mActive, flags);
        dest.writeIntArray(mAdded);
        dest.writeTypedArray(mBackStack, flags);
    }
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

    public FragmentManagerImpl(Activity activity) {
        super();
        this.mActivity = activity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.613 -0500", hash_original_method = "EF9B1EDACB3DF8AEB2756354C0AEFEDD", hash_generated_method = "2C6BD9C0C59EEBA564136501810F7E77")
    
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.616 -0500", hash_original_method = "1B9AF6569EDBEE9C994609E040377556", hash_generated_method = "E2FC603D483EADF772EAD2D746AF3B27")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.359 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.361 -0500", hash_original_field = "78B476A2173683CB2946F3D345781AC1", hash_generated_field = "82CCA249F4AC6A9E8A18392D953FCA5D")

    static final String TAG = "FragmentManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.363 -0500", hash_original_field = "F787E82ABD38F2EA55518D5879BC4223", hash_generated_field = "3B27731C0E9DDDFC7028C0BFB720297D")
    
    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.365 -0500", hash_original_field = "93ACE05EC658CB34C742740556D4AAD2", hash_generated_field = "9220E2EDA94C70BA7341F1BFB405D6BF")

    static final String TARGET_STATE_TAG = "android:target_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.367 -0500", hash_original_field = "B99484934BE95489FACF4231321AED62", hash_generated_field = "C8F5F7A2B0A3F70631E3897CD07F0E4E")

    static final String VIEW_STATE_TAG = "android:view_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.369 -0500", hash_original_field = "4511CE3F50A8FB9DD8837073E45C13C9", hash_generated_field = "43219A21E686E6FEC3DF87B97E67132D")

    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.371 -0500", hash_original_field = "11FD18D208B09E922FC03FBF68E7335B", hash_generated_field = "11FD18D208B09E922FC03FBF68E7335B")

    ArrayList<Runnable> mPendingActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.373 -0500", hash_original_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3", hash_generated_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3")

    Runnable[] mTmpActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.375 -0500", hash_original_field = "CD4485F6F525738DAA0EA0DC245911AB", hash_generated_field = "CD4485F6F525738DAA0EA0DC245911AB")

    boolean mExecutingActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.377 -0500", hash_original_field = "A1650882FA43FC001601740ED87DBA1F", hash_generated_field = "A1650882FA43FC001601740ED87DBA1F")
    
    ArrayList<Fragment> mActive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.379 -0500", hash_original_field = "FF37605B8D813171195C0EBF92B2A116", hash_generated_field = "FF37605B8D813171195C0EBF92B2A116")

    ArrayList<Fragment> mAdded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.381 -0500", hash_original_field = "5441838D07CA3D72A0FE3BB98FAAC33E", hash_generated_field = "5441838D07CA3D72A0FE3BB98FAAC33E")

    ArrayList<Integer> mAvailIndices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.383 -0500", hash_original_field = "A66A7C10189C949E8CDC007D4D07280E", hash_generated_field = "A66A7C10189C949E8CDC007D4D07280E")

    ArrayList<BackStackRecord> mBackStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.385 -0500", hash_original_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7", hash_generated_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7")

    ArrayList<Fragment> mCreatedMenus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.387 -0500", hash_original_field = "89571A39B2AB736200FBD57A213BDB4D", hash_generated_field = "89571A39B2AB736200FBD57A213BDB4D")

    ArrayList<BackStackRecord> mBackStackIndices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.389 -0500", hash_original_field = "27AED91E8586753C6865FA558A4716C8", hash_generated_field = "27AED91E8586753C6865FA558A4716C8")

    ArrayList<Integer> mAvailBackStackIndices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.391 -0500", hash_original_field = "078DA2C7CA0D4289F90F664D0B3EDB3B", hash_generated_field = "078DA2C7CA0D4289F90F664D0B3EDB3B")

    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.393 -0500", hash_original_field = "9521C64640071A41BA8B18982DEC3BE2", hash_generated_field = "9521C64640071A41BA8B18982DEC3BE2")

    int mCurState = Fragment.INITIALIZING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.394 -0500", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.396 -0500", hash_original_field = "19DD0E42F9FC244F37062274E8F2012D", hash_generated_field = "19DD0E42F9FC244F37062274E8F2012D")
    
    boolean mNeedMenuInvalidate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.398 -0500", hash_original_field = "E68067DB35DA8BD96BFB5C858DBE74BF", hash_generated_field = "E68067DB35DA8BD96BFB5C858DBE74BF")

    boolean mStateSaved;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.401 -0500", hash_original_field = "708F9D94DA99CD83DBB18AAAFBA8C49F", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

    boolean mDestroyed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.403 -0500", hash_original_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE", hash_generated_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE")

    String mNoTransactionsBecause;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.404 -0500", hash_original_field = "79BC4D349D09DCA85692E9FAD9D9C6F7", hash_generated_field = "79BC4D349D09DCA85692E9FAD9D9C6F7")

    boolean mHavePendingDeferredStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.406 -0500", hash_original_field = "92A56B8032395A53760143DE797F97FA", hash_generated_field = "92A56B8032395A53760143DE797F97FA")

    Bundle mStateBundle = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.408 -0500", hash_original_field = "280BE7FE9228C6CA67328AF4B4B28047", hash_generated_field = "280BE7FE9228C6CA67328AF4B4B28047")

    SparseArray<Parcelable> mStateArray = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.328 -0400", hash_original_field = "BB4C35BD7F2BC82D3F4C38422B568E9B", hash_generated_field = "E35D464208931599FA6E66C3119300C4")

    Runnable mExecCommit = new Runnable() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:18.327 -0400", hash_original_method = "C2BA1C69EB0B4CCFF1A319535DB79508", hash_generated_method = "FEDC918E58215E12D8175F59CA2BA6B4")
        @Override
        @DSSafe(DSCat.SAFE_LIST)
        public void run() {
            execPendingActions();
            
        }
        
};
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.623 -0400", hash_original_method = "57A648A59831AB7BB1637AFC6125C81E", hash_generated_method = "57A648A59831AB7BB1637AFC6125C81E")
    public FragmentManagerImpl ()
    {
        //Synthesized constructor
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.416 -0500", hash_original_method = "FD4DF6D1DA8CD9545895F43FA5CF7B0B", hash_generated_method = "901C9AD0A2A75ECA10E98E593A7AB045")
    
@Override
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.418 -0500", hash_original_method = "082964FFA3913D960E19EEB76BD9505B", hash_generated_method = "1711C57317FEF53BD66DBCDCF1F50005")
    
@Override
    public boolean executePendingTransactions() {
        return execPendingActions();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.424 -0500", hash_original_method = "5CB88371A39240A7C2FB2F2041C5DD0D", hash_generated_method = "045B9A2FE36B9056EDAE06521EEDFC5E")
    
@Override
    public void popBackStack() {
        enqueueAction(new Runnable() {
        	@DSSafe(DSCat.SAFE_LIST)
            @Override public void run() {
                popBackStackState(mActivity.mHandler, null, -1, 0);
            }
        }, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.426 -0500", hash_original_method = "B7072E2D8E1B8CAC03251D641D234641", hash_generated_method = "3B7E724402B0B26FE28D78D5E2981544")
    
@Override
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(mActivity.mHandler, null, -1, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.432 -0500", hash_original_method = "9E86D2BA46D98A91B2D43097CFA7F639", hash_generated_method = "25AC695BADCB95EC6033649501BF1614")
    
@Override
    public void popBackStack(final String name, final int flags) {
        enqueueAction(new Runnable() {
        @DSSafe(DSCat.SAFE_LIST)
            @Override public void run() {
                popBackStackState(mActivity.mHandler, name, -1, flags);
            }
        }, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.434 -0500", hash_original_method = "4DEC43188CEAB5FA4EF2839673649ECC", hash_generated_method = "E65ED40E729BFDE74201D6481EDD2229")
    
@Override
    public boolean popBackStackImmediate(String name, int flags) {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(mActivity.mHandler, name, -1, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.439 -0500", hash_original_method = "DA57C1B5DA7DBD65A6FF7556F6C0B827", hash_generated_method = "645643CDB361BBE23BA78834F510A0DB")
    
@Override
    public void popBackStack(final int id, final int flags) {
        if (id < 0) {
            throw new IllegalArgumentException("Bad id: " + id);
        }
        enqueueAction(new Runnable() {
        @DSSafe(DSCat.SAFE_LIST)
            @Override public void run() {
                popBackStackState(mActivity.mHandler, null, id, flags);
            }
        }, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.441 -0500", hash_original_method = "C28CBCAD3FA2084F032C85B006AF0CA6", hash_generated_method = "A853E3468A25B84DB29E4E0195D577D6")
    
@Override
    public boolean popBackStackImmediate(int id, int flags) {
        checkStateLoss();
        executePendingTransactions();
        if (id < 0) {
            throw new IllegalArgumentException("Bad id: " + id);
        }
        return popBackStackState(mActivity.mHandler, null, id, flags);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.443 -0500", hash_original_method = "81448DC3AD62196301F3A4A762AB09A8", hash_generated_method = "87FA987464062DB67C94A14CF163F8A8")
    
@Override
    public int getBackStackEntryCount() {
        return mBackStack != null ? mBackStack.size() : 0;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.446 -0500", hash_original_method = "898A7E40DF942FAA7422F0070AE7C2C0", hash_generated_method = "936D529282443088BF02B3FA798849A8")
    
@Override
    public BackStackEntry getBackStackEntryAt(int index) {
        return mBackStack.get(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.448 -0500", hash_original_method = "5B02C223CD8F1AC3632AF80A3BE5FAF1", hash_generated_method = "CD42180E56219A3E765F41507C27AA02")
    
@Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        if (mBackStackChangeListeners == null) {
            mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        }
        mBackStackChangeListeners.add(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.450 -0500", hash_original_method = "0EB71E2FD8D5B96EE15FDFA4CFDC7A3A", hash_generated_method = "4B9CBF708A93EE1CAF39BC728D2E0AAD")
    
@Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        if (mBackStackChangeListeners != null) {
            mBackStackChangeListeners.remove(listener);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.453 -0500", hash_original_method = "28A5058460B6EF16DD9CEE59F403CB5D", hash_generated_method = "6409864029149BCCB09C4BA39AC6D910")
    
@Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        if (fragment.mIndex < 0) {
            throw new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
        }
        bundle.putInt(key, fragment.mIndex);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.455 -0500", hash_original_method = "D08899B1EE8437F622E0D7F7BA40A91F", hash_generated_method = "E72D7A82F24A2DF001B4EAF81636EED9")
    
@Override
    public Fragment getFragment(Bundle bundle, String key) {
        int index = bundle.getInt(key, -1);
        if (index == -1) {
            return null;
        }
        if (index >= mActive.size()) {
            throw new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index);
        }
        Fragment f = mActive.get(index);
        if (f == null) {
            throw new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index);
        }
        return f;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.458 -0500", hash_original_method = "CF6272FD6214D7D7484637054FD9E74F", hash_generated_method = "6A0FDFEC139CB40178BD20A64AE77337")
    
@Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        if (fragment.mIndex < 0) {
            throw new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager");
        }
        if (fragment.mState > Fragment.INITIALIZING) {
            Bundle result = saveFragmentBasicState(fragment);
            return result != null ? new Fragment.SavedState(result) : null;
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.460 -0500", hash_original_method = "A7D5B4266978FAAC75BAC34E53BDC41B", hash_generated_method = "9E28CDC062765D4B518503BD010A8D2B")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.buildShortClassTag(mActivity, sb);
        sb.append("}}");
        return sb.toString();
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.464 -0500", hash_original_method = "0EF991BB6A19DFA56B66936C5498080A", hash_generated_method = "1C833A54848E055F0F7D8ACE291CCE84")
    
@Override
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        String innerPrefix = prefix + "    ";

        int N;
        if (mActive != null) {
            N = mActive.size();
            if (N > 0) {
                writer.print(prefix); writer.print("Active Fragments in ");
                        writer.print(Integer.toHexString(System.identityHashCode(this)));
                        writer.println(":");
                for (int i=0; i<N; i++) {
                    Fragment f = mActive.get(i);
                    writer.print(prefix); writer.print("  #"); writer.print(i);
                            writer.print(": "); writer.println(f);
                    if (f != null) {
                        f.dump(innerPrefix, fd, writer, args);
                    }
                }
            }
        }

        if (mAdded != null) {
            N = mAdded.size();
            if (N > 0) {
                writer.print(prefix); writer.println("Added Fragments:");
                for (int i=0; i<N; i++) {
                    Fragment f = mAdded.get(i);
                    writer.print(prefix); writer.print("  #"); writer.print(i);
                            writer.print(": "); writer.println(f.toString());
                }
            }
        }

        if (mCreatedMenus != null) {
            N = mCreatedMenus.size();
            if (N > 0) {
                writer.print(prefix); writer.println("Fragments Created Menus:");
                for (int i=0; i<N; i++) {
                    Fragment f = mCreatedMenus.get(i);
                    writer.print(prefix); writer.print("  #"); writer.print(i);
                            writer.print(": "); writer.println(f.toString());
                }
            }
        }

        if (mBackStack != null) {
            N = mBackStack.size();
            if (N > 0) {
                writer.print(prefix); writer.println("Back Stack:");
                for (int i=0; i<N; i++) {
                    BackStackRecord bs = mBackStack.get(i);
                    writer.print(prefix); writer.print("  #"); writer.print(i);
                            writer.print(": "); writer.println(bs.toString());
                    bs.dump(innerPrefix, fd, writer, args);
                }
            }
        }

        synchronized (this) {
            if (mBackStackIndices != null) {
                N = mBackStackIndices.size();
                if (N > 0) {
                    writer.print(prefix); writer.println("Back Stack Indices:");
                    for (int i=0; i<N; i++) {
                        BackStackRecord bs = mBackStackIndices.get(i);
                        writer.print(prefix); writer.print("  #"); writer.print(i);
                                writer.print(": "); writer.println(bs);
                    }
                }
            }

            if (mAvailBackStackIndices != null && mAvailBackStackIndices.size() > 0) {
                writer.print(prefix); writer.print("mAvailBackStackIndices: ");
                        writer.println(Arrays.toString(mAvailBackStackIndices.toArray()));
            }
        }

        if (mPendingActions != null) {
            N = mPendingActions.size();
            if (N > 0) {
                writer.print(prefix); writer.println("Pending Actions:");
                for (int i=0; i<N; i++) {
                    Runnable r = mPendingActions.get(i);
                    writer.print(prefix); writer.print("  #"); writer.print(i);
                            writer.print(": "); writer.println(r);
                }
            }
        }

        writer.print(prefix); writer.println("FragmentManager misc state:");
        writer.print(prefix); writer.print("  mCurState="); writer.print(mCurState);
                writer.print(" mStateSaved="); writer.print(mStateSaved);
                writer.print(" mDestroyed="); writer.println(mDestroyed);
        if (mNeedMenuInvalidate) {
            writer.print(prefix); writer.print("  mNeedMenuInvalidate=");
                    writer.println(mNeedMenuInvalidate);
        }
        if (mNoTransactionsBecause != null) {
            writer.print(prefix); writer.print("  mNoTransactionsBecause=");
                    writer.println(mNoTransactionsBecause);
        }
        if (mAvailIndices != null && mAvailIndices.size() > 0) {
            writer.print(prefix); writer.print("  mAvailIndices: ");
                    writer.println(Arrays.toString(mAvailIndices.toArray()));
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.467 -0500", hash_original_method = "8FB9E657DCE437B207C489B8932863BA", hash_generated_method = "8FB9E657DCE437B207C489B8932863BA")
    
Animator loadAnimator(Fragment fragment, int transit, boolean enter,
            int transitionStyle) {
        Animator animObj = fragment.onCreateAnimator(transit, enter,
                fragment.mNextAnim);
        if (animObj != null) {
            return animObj;
        }
        
        if (fragment.mNextAnim != 0) {
            Animator anim = AnimatorInflater.loadAnimator(mActivity, fragment.mNextAnim);
            if (anim != null) {
                return anim;
            }
        }
        
        if (transit == 0) {
            return null;
        }
        
        int styleIndex = transitToStyleIndex(transit, enter);
        if (styleIndex < 0) {
            return null;
        }
        
        if (transitionStyle == 0 && mActivity.getWindow() != null) {
            transitionStyle = mActivity.getWindow().getAttributes().windowAnimations;
        }
        if (transitionStyle == 0) {
            return null;
        }
        
        TypedArray attrs = mActivity.obtainStyledAttributes(transitionStyle,
                com.android.internal.R.styleable.FragmentAnimation);
        int anim = attrs.getResourceId(styleIndex, 0);
        attrs.recycle();
        
        if (anim == 0) {
            return null;
        }
        
        return AnimatorInflater.loadAnimator(mActivity, anim);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.469 -0500", hash_original_method = "BB58D6FD0DD6E4462529DBFA77E71E10", hash_generated_method = "90B4E42047946FEF63C99FDA0CCC69DC")
    
public void performPendingDeferredStart(Fragment f) {
        if (f.mDeferStart) {
            if (mExecutingActions) {
                // Wait until we're done executing our pending transactions
                mHavePendingDeferredStart = true;
                return;
            }
            f.mDeferStart = false;
            moveToState(f, mCurState, 0, 0);
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.650 -0400", hash_original_method = "EE92853A739004991ACA465267191DB6", hash_generated_method = "58D333F274C152A4FE282A740040F414")
    
     void moveToState(Fragment f, int newState, int transit, int transitionStyle) {
        //addTaint(transitionStyle);
        //addTaint(transit);
        //addTaint(newState);
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
                //var3B21D72FE3B78DA21309B053881BE5E5_238902641.addTaint(getTaint());
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
                    //varDCB548427EBCECA4CC9F6862AC507FF3_12691253.addTaint(getTaint());
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
                            //var0353385A08CCE5D7465C38B4F1D7C17E_442916768.addTaint(getTaint());
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
                    //var45C194242DE43412EAC556A63F1E43D7_462847951.addTaint(getTaint());
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
                    //varF07429FD2D04E52714B8713F40AFC9DD_1672170067.addTaint(getTaint());
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
                    //var2F03BD78E4921B7BE5C850B804B95C39_1948517605.addTaint(getTaint());
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
                    //var55DB580FC19CB339D914E96405A6FFDF_1507103059.addTaint(getTaint());
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
                    //var240380EDA5D49D36DA90F7CBC00728AE_1059908555.addTaint(getTaint());
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
                    //var7FE18600505ECC477FD177AC364738B8_970899931.addTaint(getTaint());
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
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.476 -0500", hash_original_method = "9D8EA3EF50700F2206500D8F97DFE625", hash_generated_method = "797676F2F0FFE37D9904E07195EA32BE")
                                
@Override
        							@DSSafe(DSCat.SAFE_LIST)
                                    public void onAnimationEnd(Animator anim) {
                                        container.endViewTransition(view);
                                        if (fragment.mAnimatingAway != null) {
                                            fragment.mAnimatingAway = null;
                                            moveToState(fragment, fragment.mStateAfterAnimating,
                                                    0, 0);
                                        }
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
                            //var996818535D410BFCADDBA6185941AB67_1303038861.addTaint(getTaint());
                            throw var996818535D410BFCADDBA6185941AB67_1303038861;
                        } //End block
                    } //End block
                    f.mCalled = false;
                    f.onDetach();
                    if(!f.mCalled)                    
                    {
                        SuperNotCalledException varA1E86A4AD3397A3A1F40BAC562CFC4E0_1331780739 = new SuperNotCalledException("Fragment " + f
                                        + " did not call through to super.onDetach()");
                        //varA1E86A4AD3397A3A1F40BAC562CFC4E0_1331780739.addTaint(getTaint());
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
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.484 -0500", hash_original_method = "8CD289FFBEE11A8449DF6C5CC9F9ABBD", hash_generated_method = "8CD289FFBEE11A8449DF6C5CC9F9ABBD")
    
void moveToState(Fragment f) {
        moveToState(f, mCurState, 0, 0);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.486 -0500", hash_original_method = "4A2DC4C23578532593EF5B01DCA60326", hash_generated_method = "4A2DC4C23578532593EF5B01DCA60326")
    
void moveToState(int newState, boolean always) {
        moveToState(newState, 0, 0, always);
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.488 -0500", hash_original_method = "EC27B7DF943700174166429595B46255", hash_generated_method = "EC27B7DF943700174166429595B46255")
    
void moveToState(int newState, int transit, int transitStyle, boolean always) {
        if (mActivity == null && newState != Fragment.INITIALIZING) {
            throw new IllegalStateException("No activity");
        }
        
        if (!always && mCurState == newState) {
            return;
        }
        
        mCurState = newState;
        if (mActive != null) {
            boolean loadersRunning = false;
            for (int i=0; i<mActive.size(); i++) {
                Fragment f = mActive.get(i);
                if (f != null) {
                    moveToState(f, newState, transit, transitStyle);
                    if (f.mLoaderManager != null) {
                        loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                    }
                }
            }

            if (!loadersRunning) {
                startPendingDeferredFragments();
            }

            if (mNeedMenuInvalidate && mActivity != null && mCurState == Fragment.RESUMED) {
                mActivity.invalidateOptionsMenu();
                mNeedMenuInvalidate = false;
            }
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.491 -0500", hash_original_method = "CCAA4C21D5B5313253593374D7FC1754", hash_generated_method = "CCAA4C21D5B5313253593374D7FC1754")
    
void startPendingDeferredFragments() {
        if (mActive == null) return;

        for (int i=0; i<mActive.size(); i++) {
            Fragment f = mActive.get(i);
            if (f != null) {
                performPendingDeferredStart(f);
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.493 -0500", hash_original_method = "D50E4D1CE651B3B8515ED7A1E81CB61B", hash_generated_method = "D50E4D1CE651B3B8515ED7A1E81CB61B")
    
void makeActive(Fragment f) {
        if (f.mIndex >= 0) {
            return;
        }
        
        if (mAvailIndices == null || mAvailIndices.size() <= 0) {
            if (mActive == null) {
                mActive = new ArrayList<Fragment>();
            }
            f.setIndex(mActive.size());
            mActive.add(f);
            
        } else {
            f.setIndex(mAvailIndices.remove(mAvailIndices.size()-1));
            mActive.set(f.mIndex, f);
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.495 -0500", hash_original_method = "21A9491D104F42D1B78CA5222CCDF2B0", hash_generated_method = "21A9491D104F42D1B78CA5222CCDF2B0")
    
void makeInactive(Fragment f) {
        if (f.mIndex < 0) {
            return;
        }
        
        if (DEBUG) Log.v(TAG, "Freeing fragment index " + f.mIndex);
        mActive.set(f.mIndex, null);
        if (mAvailIndices == null) {
            mAvailIndices = new ArrayList<Integer>();
        }
        mAvailIndices.add(f.mIndex);
        mActivity.invalidateFragmentIndex(f.mIndex);
        f.initState();
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.498 -0500", hash_original_method = "39A4C55EF4B2F4D7AD9F69C21FC91745", hash_generated_method = "A812848089C1BC248BEDB9D66AB9124D")
    
public void addFragment(Fragment fragment, boolean moveToStateNow) {
        if (mAdded == null) {
            mAdded = new ArrayList<Fragment>();
        }
        if (DEBUG) Log.v(TAG, "add: " + fragment);
        makeActive(fragment);
        if (!fragment.mDetached) {
            mAdded.add(fragment);
            fragment.mAdded = true;
            fragment.mRemoving = false;
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            if (moveToStateNow) {
                moveToState(fragment);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.500 -0500", hash_original_method = "47129A78A86358373557A8CBE26A47CF", hash_generated_method = "EDDDA39CC9B739828774CC5B3F5D9F4F")
    
public void removeFragment(Fragment fragment, int transition, int transitionStyle) {
        if (DEBUG) Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        final boolean inactive = !fragment.isInBackStack();
        if (!fragment.mDetached || inactive) {
            mAdded.remove(fragment);
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            moveToState(fragment, inactive ? Fragment.INITIALIZING : Fragment.CREATED,
                    transition, transitionStyle);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:53.656 -0400", hash_original_method = "066049DB7DB3E7A9AEFB54490F59C652", hash_generated_method = "27F2569BA54EB3CB1FC527671FBCE191")
    public void hideFragment(Fragment fragment, int transition, int transitionStyle) {
        //addTaint(transitionStyle);
        //addTaint(transition);
        //addTaint(fragment.getTaint());
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
                        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.505 -0500", hash_original_method = "FE6C0F24C850190D502A7783FD2F34FA", hash_generated_method = "BD771F6592A189A6BCABA5F150D1DF17")
                        
@Override
        @DSSafe(DSCat.SAFE_LIST)
                        public void onAnimationEnd(Animator animation) {
                            if (finalFragment.mView != null) {
                                finalFragment.mView.setVisibility(View.GONE);
                            }
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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.509 -0500", hash_original_method = "DD64B7390BAEF5796124974048F6770D", hash_generated_method = "DFC0DCA8C116DDA018879DE5FD1A1FE4")
    
public void showFragment(Fragment fragment, int transition, int transitionStyle) {
        if (DEBUG) Log.v(TAG, "show: " + fragment);
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animator anim = loadAnimator(fragment, transition, true,
                        transitionStyle);
                if (anim != null) {
                    anim.setTarget(fragment.mView);
                    anim.start();
                }
                fragment.mView.setVisibility(View.VISIBLE);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(false);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.512 -0500", hash_original_method = "9E4782C1879A41669B298A15D404F278", hash_generated_method = "4AC46861A0002BA9870129F65DB9AF8E")
    
public void detachFragment(Fragment fragment, int transition, int transitionStyle) {
        if (DEBUG) Log.v(TAG, "detach: " + fragment);
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                // We are not already in back stack, so need to remove the fragment.
                mAdded.remove(fragment);
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    mNeedMenuInvalidate = true;
                }
                fragment.mAdded = false;
                moveToState(fragment, Fragment.CREATED, transition, transitionStyle);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.514 -0500", hash_original_method = "681D8A8EBC4582B35DF715CE5B5E6679", hash_generated_method = "A2095AED52B2665FD5E7D91E81424A2D")
    
public void attachFragment(Fragment fragment, int transition, int transitionStyle) {
        if (DEBUG) Log.v(TAG, "attach: " + fragment);
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                mAdded.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    mNeedMenuInvalidate = true;
                }
                moveToState(fragment, mCurState, transition, transitionStyle);
            }
        }
    }

    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.517 -0500", hash_original_method = "846CFE4E6D453F7EB47298FC794E62E7", hash_generated_method = "21D2CD95F031D04F17D8A8EDF7F0C2EE")
    
public Fragment findFragmentById(int id) {
        if (mActive != null) {
            // First look through added fragments.
            for (int i=mAdded.size()-1; i>=0; i--) {
                Fragment f = mAdded.get(i);
                if (f != null && f.mFragmentId == id) {
                    return f;
                }
            }
            // Now for any known fragment.
            for (int i=mActive.size()-1; i>=0; i--) {
                Fragment f = mActive.get(i);
                if (f != null && f.mFragmentId == id) {
                    return f;
                }
            }
        }
        return null;
    }
    
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.520 -0500", hash_original_method = "5F9B0395F726C1A39BFC043E2E96E889", hash_generated_method = "5A9448D48735E8A336F9FFD7325CB2B4")
    
public Fragment findFragmentByTag(String tag) {
        if (mActive != null && tag != null) {
            // First look through added fragments.
            for (int i=mAdded.size()-1; i>=0; i--) {
                Fragment f = mAdded.get(i);
                if (f != null && tag.equals(f.mTag)) {
                    return f;
                }
            }
            // Now for any known fragment.
            for (int i=mActive.size()-1; i>=0; i--) {
                Fragment f = mActive.get(i);
                if (f != null && tag.equals(f.mTag)) {
                    return f;
                }
            }
        }
        return null;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.522 -0500", hash_original_method = "BBAAD10FC9AB450B3B7E8CD0A108A471", hash_generated_method = "5B46A578E9321BA7C79182C183ABE48F")
    
public Fragment findFragmentByWho(String who) {
        if (mActive != null && who != null) {
            for (int i=mActive.size()-1; i>=0; i--) {
                Fragment f = mActive.get(i);
                if (f != null && who.equals(f.mWho)) {
                    return f;
                }
            }
        }
        return null;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.525 -0500", hash_original_method = "B87B380B690A16EB7F37B7EE1C0A0D26", hash_generated_method = "AD151F1BDA94909FC4C898DCA0920366")
    
private void checkStateLoss() {
        if (mStateSaved) {
            throw new IllegalStateException(
                    "Can not perform this action after onSaveInstanceState");
        }
        if (mNoTransactionsBecause != null) {
            throw new IllegalStateException(
                    "Can not perform this action inside of " + mNoTransactionsBecause);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.527 -0500", hash_original_method = "32359130EC903AF4E096237D1F067453", hash_generated_method = "A32C82F2A4A576D4BCE79316882D08F9")
    
public void enqueueAction(Runnable action, boolean allowStateLoss) {
        if (!allowStateLoss) {
            checkStateLoss();
        }
        synchronized (this) {
            if (mActivity == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (mPendingActions == null) {
                mPendingActions = new ArrayList<Runnable>();
            }
            mPendingActions.add(action);
            if (mPendingActions.size() == 1) {
                mActivity.mHandler.removeCallbacks(mExecCommit);
                mActivity.mHandler.post(mExecCommit);
            }
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.529 -0500", hash_original_method = "1503673DA6CC1FF53261337C6A89F6BE", hash_generated_method = "8EAB5C9686F912917B3BCA15DDEA45E8")
    
public int allocBackStackIndex(BackStackRecord bse) {
        synchronized (this) {
            if (mAvailBackStackIndices == null || mAvailBackStackIndices.size() <= 0) {
                if (mBackStackIndices == null) {
                    mBackStackIndices = new ArrayList<BackStackRecord>();
                }
                int index = mBackStackIndices.size();
                if (DEBUG) Log.v(TAG, "Setting back stack index " + index + " to " + bse);
                mBackStackIndices.add(bse);
                return index;

            } else {
                int index = mAvailBackStackIndices.remove(mAvailBackStackIndices.size()-1);
                if (DEBUG) Log.v(TAG, "Adding back stack index " + index + " with " + bse);
                mBackStackIndices.set(index, bse);
                return index;
            }
        }
    }

    @DSSink({DSSinkKind.LOG})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.532 -0500", hash_original_method = "F0AF804A23A686630C8F5E2012EB99F7", hash_generated_method = "4E2FDC94FAD3569E5524DEE3B958EFF6")
    
public void setBackStackIndex(int index, BackStackRecord bse) {
        synchronized (this) {
            if (mBackStackIndices == null) {
                mBackStackIndices = new ArrayList<BackStackRecord>();
            }
            int N = mBackStackIndices.size();
            if (index < N) {
                if (DEBUG) Log.v(TAG, "Setting back stack index " + index + " to " + bse);
                mBackStackIndices.set(index, bse);
            } else {
                while (N < index) {
                    mBackStackIndices.add(null);
                    if (mAvailBackStackIndices == null) {
                        mAvailBackStackIndices = new ArrayList<Integer>();
                    }
                    if (DEBUG) Log.v(TAG, "Adding available back stack index " + N);
                    mAvailBackStackIndices.add(N);
                    N++;
                }
                if (DEBUG) Log.v(TAG, "Adding back stack index " + index + " with " + bse);
                mBackStackIndices.add(bse);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.534 -0500", hash_original_method = "A75FE5CB17552EA725360407924677A5", hash_generated_method = "34DE1872754C72E290FC496AAAF34C8D")
    
public void freeBackStackIndex(int index) {
        synchronized (this) {
            mBackStackIndices.set(index, null);
            if (mAvailBackStackIndices == null) {
                mAvailBackStackIndices = new ArrayList<Integer>();
            }
            if (DEBUG) Log.v(TAG, "Freeing back stack index " + index);
            mAvailBackStackIndices.add(index);
        }
    }

    /**
     * Only call from main thread!
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.538 -0500", hash_original_method = "2EC9B9D8ABC4926EA1F7FF85BE00D458", hash_generated_method = "204D2702904F445488B280B0FF1C4460")
    
public boolean execPendingActions() {
        if (mExecutingActions) {
            throw new IllegalStateException("Recursive entry to executePendingTransactions");
        }
        
        if (Looper.myLooper() != mActivity.mHandler.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of process");
        }

        boolean didSomething = false;

        while (true) {
            int numActions;
            
            synchronized (this) {
                if (mPendingActions == null || mPendingActions.size() == 0) {
                    break;
                }
                
                numActions = mPendingActions.size();
                if (mTmpActions == null || mTmpActions.length < numActions) {
                    mTmpActions = new Runnable[numActions];
                }
                mPendingActions.toArray(mTmpActions);
                mPendingActions.clear();
                mActivity.mHandler.removeCallbacks(mExecCommit);
            }
            
            mExecutingActions = true;
            for (int i=0; i<numActions; i++) {
                mTmpActions[i].run();
                mTmpActions[i] = null;
            }
            mExecutingActions = false;
            didSomething = true;
        }

        if (mHavePendingDeferredStart) {
            boolean loadersRunning = false;
            for (int i=0; i<mActive.size(); i++) {
                Fragment f = mActive.get(i);
                if (f != null && f.mLoaderManager != null) {
                    loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                }
            }
            if (!loadersRunning) {
                mHavePendingDeferredStart = false;
                startPendingDeferredFragments();
            }
        }
        return didSomething;
    }

    @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.540 -0500", hash_original_method = "480CA24D6CDDA51ECD1DFDE903041169", hash_generated_method = "480CA24D6CDDA51ECD1DFDE903041169")
    
void reportBackStackChanged() {
        if (mBackStackChangeListeners != null) {
            for (int i=0; i<mBackStackChangeListeners.size(); i++) {
                mBackStackChangeListeners.get(i).onBackStackChanged();
            }
        }
    }

    @DSVerified
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.542 -0500", hash_original_method = "93C61FA561A07CB0E9B057A7A904C282", hash_generated_method = "93C61FA561A07CB0E9B057A7A904C282")
    
void addBackStackState(BackStackRecord state) {
        if (mBackStack == null) {
            mBackStack = new ArrayList<BackStackRecord>();
        }
        mBackStack.add(state);
        reportBackStackChanged();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.555 -0500", hash_original_method = "2DCA4D0949EEA78B53FF55FD7B1EE1F8", hash_generated_method = "77498A76B367759D221EC394B1246D3C")
    
boolean popBackStackState(Handler handler, String name, int id, int flags) {
        if (mBackStack == null) {
            return false;
        }
        if (name == null && id < 0 && (flags&POP_BACK_STACK_INCLUSIVE) == 0) {
            int last = mBackStack.size()-1;
            if (last < 0) {
                return false;
            }
            final BackStackRecord bss = mBackStack.remove(last);
            bss.popFromBackStack(true);
            reportBackStackChanged();
        } else {
            int index = -1;
            if (name != null || id >= 0) {
                // If a name or ID is specified, look for that place in
                // the stack.
                index = mBackStack.size()-1;
                while (index >= 0) {
                    BackStackRecord bss = mBackStack.get(index);
                    if (name != null && name.equals(bss.getName())) {
                        break;
                    }
                    if (id >= 0 && id == bss.mIndex) {
                        break;
                    }
                    index--;
                }
                if (index < 0) {
                    return false;
                }
                if ((flags&POP_BACK_STACK_INCLUSIVE) != 0) {
                    index--;
                    // Consume all following entries that match.
                    while (index >= 0) {
                        BackStackRecord bss = mBackStack.get(index);
                        if ((name != null && name.equals(bss.getName()))
                                || (id >= 0 && id == bss.mIndex)) {
                            index--;
                            continue;
                        }
                        break;
                    }
                }
            }
            if (index == mBackStack.size()-1) {
                return false;
            }
            final ArrayList<BackStackRecord> states
                    = new ArrayList<BackStackRecord>();
            for (int i=mBackStack.size()-1; i>index; i--) {
                states.add(mBackStack.remove(i));
            }
            final int LAST = states.size()-1;
            for (int i=0; i<=LAST; i++) {
                if (DEBUG) Log.v(TAG, "Popping back stack state: " + states.get(i));
                states.get(i).popFromBackStack(i == LAST);
            }
            reportBackStackChanged();
        }
        return true;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.557 -0500", hash_original_method = "C4579656BDDD252D61818FF4E8F19896", hash_generated_method = "C4579656BDDD252D61818FF4E8F19896")
    
ArrayList<Fragment> retainNonConfig() {
        ArrayList<Fragment> fragments = null;
        if (mActive != null) {
            for (int i=0; i<mActive.size(); i++) {
                Fragment f = mActive.get(i);
                if (f != null && f.mRetainInstance) {
                    if (fragments == null) {
                        fragments = new ArrayList<Fragment>();
                    }
                    fragments.add(f);
                    f.mRetaining = true;
                    f.mTargetIndex = f.mTarget != null ? f.mTarget.mIndex : -1;
                }
            }
        }
        return fragments;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.560 -0500", hash_original_method = "90803A489E5220D7765DFCAE4FAFF7AC", hash_generated_method = "90803A489E5220D7765DFCAE4FAFF7AC")
    
void saveFragmentViewState(Fragment f) {
        if (f.mView == null) {
            return;
        }
        if (mStateArray == null) {
            mStateArray = new SparseArray<Parcelable>();
        } else {
            mStateArray.clear();
        }
        f.mView.saveHierarchyState(mStateArray);
        if (mStateArray.size() > 0) {
            f.mSavedViewState = mStateArray;
            mStateArray = null;
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.562 -0500", hash_original_method = "DCA5B6BB14B617A2A3ED4183EF745130", hash_generated_method = "17444C25358CBBFD26D40A84158EE0F8")
    
Bundle saveFragmentBasicState(Fragment f) {
        Bundle result = null;

        if (mStateBundle == null) {
            mStateBundle = new Bundle();
        }
        f.onSaveInstanceState(mStateBundle);
        if (!mStateBundle.isEmpty()) {
            result = mStateBundle;
            mStateBundle = null;
        }

        if (f.mView != null) {
            saveFragmentViewState(f);
        }
        if (f.mSavedViewState != null) {
            if (result == null) {
                result = new Bundle();
            }
            result.putSparseParcelableArray(
                    FragmentManagerImpl.VIEW_STATE_TAG, f.mSavedViewState);
        }
        if (!f.mUserVisibleHint) {
            // Only add this if it's not the default value
            result.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, f.mUserVisibleHint);
        }

        return result;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.566 -0500", hash_original_method = "5A6DADDDEE90F93280222EE0F5B508C8", hash_generated_method = "2E340D768973FCE1D399EFB0A0AFB2FA")
    
Parcelable saveAllState() {
        // Make sure all pending operations have now been executed to get
        // our state update-to-date.
        execPendingActions();

        mStateSaved = true;

        if (mActive == null || mActive.size() <= 0) {
            return null;
        }
        
        // First collect all active fragments.
        int N = mActive.size();
        FragmentState[] active = new FragmentState[N];
        boolean haveFragments = false;
        for (int i=0; i<N; i++) {
            Fragment f = mActive.get(i);
            if (f != null) {
                haveFragments = true;
                
                FragmentState fs = new FragmentState(f);
                active[i] = fs;
                
                if (f.mState > Fragment.INITIALIZING && fs.mSavedFragmentState == null) {
                    fs.mSavedFragmentState = saveFragmentBasicState(f);

                    if (f.mTarget != null) {
                        if (f.mTarget.mIndex < 0) {
                            String msg = "Failure saving state: " + f
                                + " has target not in fragment manager: " + f.mTarget;
                            Slog.e(TAG, msg);
                            dump("  ", null, new PrintWriter(new LogWriter(
                                    Log.ERROR, TAG, Log.LOG_ID_SYSTEM)), new String[] { });
                            throw new IllegalStateException(msg);
                        }
                        if (fs.mSavedFragmentState == null) {
                            fs.mSavedFragmentState = new Bundle();
                        }
                        putFragment(fs.mSavedFragmentState,
                                FragmentManagerImpl.TARGET_STATE_TAG, f.mTarget);
                        if (f.mTargetRequestCode != 0) {
                            fs.mSavedFragmentState.putInt(
                                    FragmentManagerImpl.TARGET_REQUEST_CODE_STATE_TAG,
                                    f.mTargetRequestCode);
                        }
                    }

                } else {
                    fs.mSavedFragmentState = f.mSavedFragmentState;
                }
                
                if (DEBUG) Log.v(TAG, "Saved state of " + f + ": "
                        + fs.mSavedFragmentState);
            }
        }
        
        if (!haveFragments) {
            if (DEBUG) Log.v(TAG, "saveAllState: no fragments!");
            return null;
        }
        
        int[] added = null;
        BackStackState[] backStack = null;
        
        // Build list of currently added fragments.
        if (mAdded != null) {
            N = mAdded.size();
            if (N > 0) {
                added = new int[N];
                for (int i=0; i<N; i++) {
                    added[i] = mAdded.get(i).mIndex;
                    if (DEBUG) Log.v(TAG, "saveAllState: adding fragment #" + i
                            + ": " + mAdded.get(i));
                }
            }
        }
        
        // Now save back stack.
        if (mBackStack != null) {
            N = mBackStack.size();
            if (N > 0) {
                backStack = new BackStackState[N];
                for (int i=0; i<N; i++) {
                    backStack[i] = new BackStackState(this, mBackStack.get(i));
                    if (DEBUG) Log.v(TAG, "saveAllState: adding back stack #" + i
                            + ": " + mBackStack.get(i));
                }
            }
        }
        
        FragmentManagerState fms = new FragmentManagerState();
        fms.mActive = active;
        fms.mAdded = added;
        fms.mBackStack = backStack;
        return fms;
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.570 -0500", hash_original_method = "CDDD12666FB804E6E56655D62533D556", hash_generated_method = "D72C1D66EC6730C522F5A98E59772996")
    
void restoreAllState(Parcelable state, ArrayList<Fragment> nonConfig) {
        // If there is no saved state at all, then there can not be
        // any nonConfig fragments either, so that is that.
        if (state == null) return;
        FragmentManagerState fms = (FragmentManagerState)state;
        if (fms.mActive == null) return;
        
        // First re-attach any non-config instances we are retaining back
        // to their saved state, so we don't try to instantiate them again.
        if (nonConfig != null) {
            for (int i=0; i<nonConfig.size(); i++) {
                Fragment f = nonConfig.get(i);
                if (DEBUG) Log.v(TAG, "restoreAllState: re-attaching retained " + f);
                FragmentState fs = fms.mActive[f.mIndex];
                fs.mInstance = f;
                f.mSavedViewState = null;
                f.mBackStackNesting = 0;
                f.mInLayout = false;
                f.mAdded = false;
                f.mTarget = null;
                if (fs.mSavedFragmentState != null) {
                    fs.mSavedFragmentState.setClassLoader(mActivity.getClassLoader());
                    f.mSavedViewState = fs.mSavedFragmentState.getSparseParcelableArray(
                            FragmentManagerImpl.VIEW_STATE_TAG);
                }
            }
        }
        
        // Build the full list of active fragments, instantiating them from
        // their saved state.
        mActive = new ArrayList<Fragment>(fms.mActive.length);
        if (mAvailIndices != null) {
            mAvailIndices.clear();
        }
        for (int i=0; i<fms.mActive.length; i++) {
            FragmentState fs = fms.mActive[i];
            if (fs != null) {
                Fragment f = fs.instantiate(mActivity);
                if (DEBUG) Log.v(TAG, "restoreAllState: adding #" + i + ": " + f);
                mActive.add(f);
                // Now that the fragment is instantiated (or came from being
                // retained above), clear mInstance in case we end up re-restoring
                // from this FragmentState again.
                fs.mInstance = null;
            } else {
                if (DEBUG) Log.v(TAG, "restoreAllState: adding #" + i + ": (null)");
                mActive.add(null);
                if (mAvailIndices == null) {
                    mAvailIndices = new ArrayList<Integer>();
                }
                if (DEBUG) Log.v(TAG, "restoreAllState: adding avail #" + i);
                mAvailIndices.add(i);
            }
        }
        
        // Update the target of all retained fragments.
        if (nonConfig != null) {
            for (int i=0; i<nonConfig.size(); i++) {
                Fragment f = nonConfig.get(i);
                if (f.mTargetIndex >= 0) {
                    if (f.mTargetIndex < mActive.size()) {
                        f.mTarget = mActive.get(f.mTargetIndex);
                    } else {
                        Log.w(TAG, "Re-attaching retained fragment " + f
                                + " target no longer exists: " + f.mTargetIndex);
                        f.mTarget = null;
                    }
                }
            }
        }

        // Build the list of currently added fragments.
        if (fms.mAdded != null) {
            mAdded = new ArrayList<Fragment>(fms.mAdded.length);
            for (int i=0; i<fms.mAdded.length; i++) {
                Fragment f = mActive.get(fms.mAdded[i]);
                if (f == null) {
                    throw new IllegalStateException(
                            "No instantiated fragment for index #" + fms.mAdded[i]);
                }
                f.mAdded = true;
                if (DEBUG) Log.v(TAG, "restoreAllState: making added #" + i + ": " + f);
                mAdded.add(f);
            }
        } else {
            mAdded = null;
        }
        
        // Build the back stack.
        if (fms.mBackStack != null) {
            mBackStack = new ArrayList<BackStackRecord>(fms.mBackStack.length);
            for (int i=0; i<fms.mBackStack.length; i++) {
                BackStackRecord bse = fms.mBackStack[i].instantiate(this);
                if (DEBUG) Log.v(TAG, "restoreAllState: adding bse #" + i
                        + " (index " + bse.mIndex + "): " + bse);
                mBackStack.add(bse);
                if (bse.mIndex >= 0) {
                    setBackStackIndex(bse.mIndex, bse);
                }
            }
        } else {
            mBackStack = null;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.572 -0500", hash_original_method = "1A90D3789635EF8BA5063E635EAF56EA", hash_generated_method = "D86258A762A7AC6C3A2A4183328B640C")
    @DSVerified
    @DSSpec(DSCat.ANDROID_ACTIVITY_STARTING)
public void attachActivity(Activity activity) {
        if (mActivity != null) throw new IllegalStateException();
        mActivity = activity;
        for (Fragment f: mAdded) {
            f.droidsafeSetContext(activity);
            //calling all subfragment callbacks
            f.droidsafeSubFragmentHook();
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.574 -0500", hash_original_method = "9E4E3FCA42BDE19CBF71140223B4B8D0", hash_generated_method = "AF7BA1CF9453ACC672FADB789538767F")
    
public void noteStateNotSaved() {
        mStateSaved = false;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.576 -0500", hash_original_method = "4EAFC4D017ED2B44474902CD00BD047E", hash_generated_method = "F80410DFB4B166184E53850E51F367FE")
    
public void dispatchCreate() {
        mStateSaved = false;
        moveToState(Fragment.CREATED, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.578 -0500", hash_original_method = "BB3D6B45374259B5EE70270EF5FFE721", hash_generated_method = "C71E1EE3F6A998E19E9FF1B016F6CD0C")
    
public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(Fragment.ACTIVITY_CREATED, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.581 -0500", hash_original_method = "145C9AF81AEB697CB534D8E0C0F599A0", hash_generated_method = "6ED9E59AB5D969020DDB728A38951921")
    
public void dispatchStart() {
        mStateSaved = false;
        moveToState(Fragment.STARTED, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.583 -0500", hash_original_method = "35325401D14378833F40C78A6FC3DC5D", hash_generated_method = "48FF97841DA5605FE7E2DED074D18BF8")
    
public void dispatchResume() {
        mStateSaved = false;
        moveToState(Fragment.RESUMED, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.586 -0500", hash_original_method = "E6EE1A1408209BDB9066272C26AA9863", hash_generated_method = "9AC18B023C47D577819D4FA2F4EA2E8A")
    
public void dispatchPause() {
        moveToState(Fragment.STARTED, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.588 -0500", hash_original_method = "AF2E4C7CBE2D28416278336F31B9AFFC", hash_generated_method = "180BCEE46330F840BD04295BE5D034D8")
    
public void dispatchStop() {
        moveToState(Fragment.STOPPED, false);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.590 -0500", hash_original_method = "A94A97B8768D84C8034BA8478DD395DC", hash_generated_method = "25313A2BED214AA6CF941600EB015032")
    
public void dispatchDestroy() {
        mDestroyed = true;
        execPendingActions();
        moveToState(Fragment.INITIALIZING, false);
        mActivity = null;
    }
    
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.592 -0500", hash_original_method = "5117E19429D94CDE29C750CF70651BE9", hash_generated_method = "AE630A01B20C5802C555F656A054747D")
    
public void dispatchConfigurationChanged(Configuration newConfig) {
        if (mActive != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    f.onConfigurationChanged(newConfig);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.594 -0500", hash_original_method = "BC8D3EC4480A5918F3A38ABAC82A7ED6", hash_generated_method = "F935F7CB7F740CFF479E0B440443B108")
    
public void dispatchLowMemory() {
        if (mActive != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    f.onLowMemory();
                }
            }
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.596 -0500", hash_original_method = "81FEC8A34B79BC0E01F9FFFE05F1478B", hash_generated_method = "14CA1C7F24A34843C11EC1D88DFA5370")
    
public void dispatchTrimMemory(int level) {
        if (mActive != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    f.onTrimMemory(level);
                }
            }
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.599 -0500", hash_original_method = "059A23578A0DB56C84349E8F783E9AC3", hash_generated_method = "75E6340F244539A764DD64732C96ED9E")
    @DSVerified("may need to inflate menu")
    @DSSpec(DSCat.SPEC_OTHERS)
public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
        if (mActive != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible) {
                    show = true;
                    f.onCreateOptionsMenu(menu, inflater);
                    if (newMenus == null) {
                        newMenus = new ArrayList<Fragment>();
                    }
                    newMenus.add(f);
                }
            }
        }
        
        if (mCreatedMenus != null) {
            for (int i=0; i<mCreatedMenus.size(); i++) {
                Fragment f = mCreatedMenus.get(i);
                if (newMenus == null || !newMenus.contains(f)) {
                    f.onDestroyOptionsMenu();
                }
            }
        }
        
        mCreatedMenus = newMenus;
        
        return show;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.601 -0500", hash_original_method = "3C4E4DD19A75168CEF9873DFBC1B4179", hash_generated_method = "C119226AFAE3661F60FEA4F7676F6DB4")
    
public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean show = false;
        if (mActive != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible) {
                    show = true;
                    f.onPrepareOptionsMenu(menu);
                }
            }
        }
        return show;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.604 -0500", hash_original_method = "16456DF238276E24923F6AD552304983", hash_generated_method = "18AA798D96E1C2674A800C23C72C887D")
    
public boolean dispatchOptionsItemSelected(MenuItem item) {
        if (mActive != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible) {
                    if (f.onOptionsItemSelected(item)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.606 -0500", hash_original_method = "F1ECF21855715BC93D4867D907434D91", hash_generated_method = "06C8F576CD5204BA8BEA691F18F57A00")
    
public boolean dispatchContextItemSelected(MenuItem item) {
        if (mActive != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null && !f.mHidden) {
                    if (f.onContextItemSelected(item)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.608 -0500", hash_original_method = "EA4F9A660842285D75622DB2DA97E1AE", hash_generated_method = "4AFFAEAAD26C507E1A33312308C49EAA")
    
public void dispatchOptionsMenuClosed(Menu menu) {
        if (mActive != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null && !f.mHidden && f.mHasMenu && f.mMenuVisible) {
                    f.onOptionsMenuClosed(menu);
                }
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:25.611 -0500", hash_original_method = "5756D303078CA095AB87E344CED6E29B", hash_generated_method = "05F86DA81EADE4AFA9562A3966157342")
    
@Override
    public void invalidateOptionsMenu() {
        if (mActivity != null && mCurState == Fragment.RESUMED) {
            mActivity.invalidateOptionsMenu();
        } else {
            mNeedMenuInvalidate = true;
        }
    }
}

