/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.support.v4.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.LogWriter;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;

public abstract class FragmentManager {

    /**
     * Control whether the framework's internal fragment manager debugging
     * logs are turned on.  If enabled, you will see output in logcat as
     * the framework performs fragment operations.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.190 -0500", hash_original_method = "F85B69D8648CC374BBF72D9494B795E2", hash_generated_method = "1B390773BA665B18CA47C23EB9D733ED")
    
public static void enableDebugLogging(boolean enabled) {
        FragmentManagerImpl.DEBUG = enabled;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.155 -0500", hash_original_field = "A37EC55D90220D1054C63CAEF06B11D6", hash_generated_field = "3F74866CBC8F49655F2B8BB97CC17F5E")

    public static final int POP_BACK_STACK_INCLUSIVE = 1<<0;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.334 -0400", hash_original_method = "0D3FEDE97BC3242ED64134E1F014EA11", hash_generated_method = "0D3FEDE97BC3242ED64134E1F014EA11")
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
     * after {@link FragmentActivity#onSaveInstanceState FragmentActivity.onSaveInstanceState()}
     * (and prior to a following {@link FragmentActivity#onStart FragmentActivity.onStart}
     * or {@link FragmentActivity#onResume FragmentActivity.onResume()}, you will get an error.
     * This is because the framework takes care of saving your current fragments
     * in the state, and if changes are made after the state is saved then they
     * will be lost.</p>
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.144 -0500", hash_original_method = "BE048CD13A2D9177864E9AE5CA89385C", hash_generated_method = "179BF9392A437EED545CF6A3F093EC20")
    
public abstract FragmentTransaction beginTransaction();

    /** @hide -- remove once prebuilts are in. */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.146 -0500", hash_original_method = "0DA67415D41DB3C4C9D7AB80CD2D78FE", hash_generated_method = "7B5BD006136DB217141D24C35BA0CCDB")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.148 -0500", hash_original_method = "5B9A3D87E7345C957FA5717C0C10C635", hash_generated_method = "66BAE45C691B1AB5E9BB1A84AE41D8A2")
    
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
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.151 -0500", hash_original_method = "F331A49B0DAC9D1709118DA3B3769DC9", hash_generated_method = "4C6F6CF41EE287D45A81567EBA8CB5D6")
    @DSVAMethod
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.153 -0500", hash_original_method = "06F2C60B02B6436122252A9A18FF6B5B", hash_generated_method = "8A748374863BCFCFE22454ABCA2FE261")
    
public abstract Fragment findFragmentByTag(String tag);

    /**
     * Pop the top state off the back stack.  Returns true if there was one
     * to pop, else false.  This function is asynchronous -- it enqueues the
     * request to pop, but the action will not be performed until the application
     * returns to its event loop.
     */
    @DSComment("Abstract Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.157 -0500", hash_original_method = "8DD8850C5659D39934906ED127571123", hash_generated_method = "06152C82F0BE43992BE41413F4D5A3F1")
    
public abstract void popBackStack();

    /**
     * Like {@link #popBackStack()}, but performs the operation immediately
     * inside of the call.  This is like calling {@link #executePendingTransactions()}
     * afterwards.
     * @return Returns true if there was something popped, else false.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.160 -0500", hash_original_method = "7B6675A0CB9AF3263371BDE096DAF2A9", hash_generated_method = "2C3F7FF8856F557CE69F0CF46B2F4937")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.162 -0500", hash_original_method = "7371282EB954218CB5BB647DBEFB9C4D", hash_generated_method = "DA4FB7A38FD1A9723E0C9FB977608D32")
    
public abstract void popBackStack(String name, int flags);

    /**
     * Like {@link #popBackStack(String, int)}, but performs the operation immediately
     * inside of the call.  This is like calling {@link #executePendingTransactions()}
     * afterwards.
     * @return Returns true if there was something popped, else false.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.165 -0500", hash_original_method = "E1C9735BC76D749F9AAB42E9F89374F3", hash_generated_method = "ADFC94D0AAB8081D7BCE139575F65351")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.167 -0500", hash_original_method = "5DFB5C2F3CB06A536CC67665FD5A1850", hash_generated_method = "AFB34329D29F80428B05B6ACD88A1183")
    
public abstract void popBackStack(int id, int flags);

    /**
     * Like {@link #popBackStack(int, int)}, but performs the operation immediately
     * inside of the call.  This is like calling {@link #executePendingTransactions()}
     * afterwards.
     * @return Returns true if there was something popped, else false.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.169 -0500", hash_original_method = "4468A20E5A85CF532490B1BC373EE3E6", hash_generated_method = "B7D3372DC7597245DDCCDC11FB8C5F74")
    
public abstract boolean popBackStackImmediate(int id, int flags);

    /**
     * Return the number of entries currently in the back stack.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.171 -0500", hash_original_method = "8EAEBBF64A73FEF70E3B2DC6C5497EE9", hash_generated_method = "F5E4FA5B0AAD9A1C436033C01C3AAABD")
    
public abstract int getBackStackEntryCount();

    /**
     * Return the BackStackEntry at index <var>index</var> in the back stack;
     * entries start index 0 being the bottom of the stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.174 -0500", hash_original_method = "C6BA46BCDC4C883DD39DC808512584CC", hash_generated_method = "79204E9430B6FA67CEF534DB5F847CAE")
    
public abstract BackStackEntry getBackStackEntryAt(int index);

    /**
     * Add a new listener for changes to the fragment back stack.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.176 -0500", hash_original_method = "4677CACA63B2CFD2A78E39C8A8FB92BF", hash_generated_method = "728832396021C02BD842F607945CFEC0")
    
public abstract void addOnBackStackChangedListener(OnBackStackChangedListener listener);

    /**
     * Remove a listener that was previously added with
     * {@link #addOnBackStackChangedListener(OnBackStackChangedListener)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.178 -0500", hash_original_method = "75368BB8382567FE8CD9BFB84C582622", hash_generated_method = "69736F023C3DB7E029FFFB58A3A4877E")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.180 -0500", hash_original_method = "8451101D4DDA3AE9BA2F091778F6ACC9", hash_generated_method = "C529CCC132EFEB14EBA38652ABAFD702")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.183 -0500", hash_original_method = "1FBEC41A2754AD4627511B440BD8CDF6", hash_generated_method = "0F634E6958A473C8D2E8404CF8C8DB24")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.185 -0500", hash_original_method = "70232028C6041780F1572B4693E04940", hash_generated_method = "D7143037D7EB1134407060B9E85E5B14")
    
public abstract Fragment.SavedState saveFragmentInstanceState(Fragment f);
    
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
     * Print the FragmentManager's state into the given stream.
     *
     * @param prefix Text to print at the front of each line.
     * @param fd The raw file descriptor that the dump is being sent to.
     * @param writer A PrintWriter to which the dump is to be set.
     * @param args Additional arguments to the dump request.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.188 -0500", hash_original_method = "9309E77AA4047B9B8316706781ED0A27", hash_generated_method = "3FF3D3380483C9ADF611F5CA2E5A6D00")
    
public abstract void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args);
}

final class FragmentManagerState implements Parcelable {

    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.353 -0400", hash_original_field = "D29AA2723BAE7915447DC2F30F3AAA56", hash_generated_field = "EE9672AF4023C35BB0D72B0356E5DA5C")

    public static final Parcelable.Creator<FragmentManagerState> CREATOR
            = new Parcelable.Creator<FragmentManagerState>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.209 -0500", hash_original_method = "ECDC6A4E7C91D1C5B65C994C4484624F", hash_generated_method = "C02CF7F6521D674473A0622E67866AE4")
        
public FragmentManagerState createFromParcel(Parcel in) {
            return new FragmentManagerState(in);
        }
        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.212 -0500", hash_original_method = "91265EDFBDBEA59F353323C915A4EF4F", hash_generated_method = "BC21AC906A7818F48F75A0EFD7490E16")
        
public FragmentManagerState[] newArray(int size) {
            return new FragmentManagerState[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.193 -0500", hash_original_field = "0C91046A014C3ABDDA41BA020BEE7D35", hash_generated_field = "0C91046A014C3ABDDA41BA020BEE7D35")

    FragmentState[] mActive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.195 -0500", hash_original_field = "4D5C3ED026B5D0195A6077AFCD696836", hash_generated_field = "4D5C3ED026B5D0195A6077AFCD696836")

    int[] mAdded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.197 -0500", hash_original_field = "EEA20C5C67D270067553BCDE313A7B27", hash_generated_field = "EEA20C5C67D270067553BCDE313A7B27")

    BackStackState[] mBackStack;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.199 -0500", hash_original_method = "4ADB2DBBD6899E89144480A7958A6490", hash_generated_method = "001680BC3C0AA33814887A60387200FC")
    
public FragmentManagerState() {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.201 -0500", hash_original_method = "020574327F1D57965B67553DD6F7D979", hash_generated_method = "0BC13CF9A5CCCFDAA729B873E1891B0B")
    
public FragmentManagerState(Parcel in) {
        mActive = in.createTypedArray(FragmentState.CREATOR);
        mAdded = in.createIntArray();
        mBackStack = in.createTypedArray(BackStackState.CREATOR);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.204 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.206 -0500", hash_original_method = "B6654BF7A24842DC15E6AD3A5F27203C", hash_generated_method = "EE219290863A0576BAFED6B568C39258")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedArray(mActive, flags);
        dest.writeIntArray(mAdded);
        dest.writeTypedArray(mBackStack, flags);
    }
}
final class FragmentManagerImpl extends FragmentManager {
    
    public FragmentManagerImpl(FragmentActivity activity) {
        super();
        this.mActivity = activity;
    }

    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.353 -0500", hash_original_method = "4341065D769972007048C06B6A820CF6", hash_generated_method = "AAEB003EE5CA3BDFC2234E2D6D00CFBC")
    
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
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.356 -0500", hash_original_method = "90F479F8F611DA10970396B1160BE850", hash_generated_method = "5E695FDA875E0A6653234B0A231739F0")
    
static Animation makeFadeAnimation(Context context, float start, float end) {
        AlphaAnimation anim = new AlphaAnimation(start, end);
        anim.setInterpolator(DECELERATE_CUBIC);
        anim.setDuration(ANIM_DUR);
        return anim;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.499 -0500", hash_original_method = "EF9B1EDACB3DF8AEB2756354C0AEFEDD", hash_generated_method = "2C6BD9C0C59EEBA564136501810F7E77")
    
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
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.517 -0500", hash_original_method = "1F375F46460B6BDD0777AC7E3A51D7A3", hash_generated_method = "7E675738F6ECD0733DD235E14DD6F080")
    
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.220 -0500", hash_original_field = "81DD852ECBE07BA98A61C8F3D0C85F01", hash_generated_field = "99DFF1318F5BF79C590B7B00A696225C")

    static boolean DEBUG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.222 -0500", hash_original_field = "78B476A2173683CB2946F3D345781AC1", hash_generated_field = "82CCA249F4AC6A9E8A18392D953FCA5D")

    static final String TAG = "FragmentManager";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.225 -0500", hash_original_field = "32BF68B99F21EB3682A35A598CF8A71A", hash_generated_field = "47802C2B46813E58B899D23FD9DC343B")
    
    static final boolean HONEYCOMB = android.os.Build.VERSION.SDK_INT >= 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.227 -0500", hash_original_field = "F787E82ABD38F2EA55518D5879BC4223", hash_generated_field = "3B27731C0E9DDDFC7028C0BFB720297D")

    static final String TARGET_REQUEST_CODE_STATE_TAG = "android:target_req_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.229 -0500", hash_original_field = "93ACE05EC658CB34C742740556D4AAD2", hash_generated_field = "9220E2EDA94C70BA7341F1BFB405D6BF")

    static final String TARGET_STATE_TAG = "android:target_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.232 -0500", hash_original_field = "B99484934BE95489FACF4231321AED62", hash_generated_field = "C8F5F7A2B0A3F70631E3897CD07F0E4E")

    static final String VIEW_STATE_TAG = "android:view_state";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.234 -0500", hash_original_field = "4511CE3F50A8FB9DD8837073E45C13C9", hash_generated_field = "43219A21E686E6FEC3DF87B97E67132D")

    static final String USER_VISIBLE_HINT_TAG = "android:user_visible_hint";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.342 -0500", hash_original_field = "DBE88DA536863F5E1852D5C0B17397C0", hash_generated_field = "3A10D2877F43112AA0B7A6A8433E95CB")

    static final Interpolator DECELERATE_QUINT = new DecelerateInterpolator(2.5f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.344 -0500", hash_original_field = "F24520F51F599A0D5367EFF4AA0763C9", hash_generated_field = "1618232FF2C96BF54619A71799992CCF")

    static final Interpolator DECELERATE_CUBIC = new DecelerateInterpolator(1.5f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.346 -0500", hash_original_field = "36FB535971BE228AC055A9B904AAAFE6", hash_generated_field = "50DFC5BE4E88ED2E03493326FAE40E99")

    static final Interpolator ACCELERATE_QUINT = new AccelerateInterpolator(2.5f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.349 -0500", hash_original_field = "4A0D62FBAAD9179677ADCF693A7D4F5A", hash_generated_field = "0650545F9518BF159E5600383DFE2395")

    static final Interpolator ACCELERATE_CUBIC = new AccelerateInterpolator(1.5f);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.351 -0500", hash_original_field = "539442A9D6C409C991FFED1C4320E7CF", hash_generated_field = "71044A5396C27203930538888DCB79FC")
    
    static final int ANIM_DUR = 220;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.502 -0500", hash_original_field = "070544131F0D684DCD03A48F95E567E9", hash_generated_field = "7BB089DC1B8A242E88755BDA8C8238B9")
    
    public static final int ANIM_STYLE_OPEN_ENTER = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.504 -0500", hash_original_field = "801447442A6349F42ECEBC29356305B2", hash_generated_field = "3C4C6A69EA30C5B582DE8DD757B46311")

    public static final int ANIM_STYLE_OPEN_EXIT = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.507 -0500", hash_original_field = "94F9664423A38963123B705F50E91B69", hash_generated_field = "B289F5FCA54C37F25FF23F46A1D8D232")

    public static final int ANIM_STYLE_CLOSE_ENTER = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.509 -0500", hash_original_field = "362CB3B6E64E31A8813BFD69F042BDD4", hash_generated_field = "913DA58C0421DE752A939A21044C5DD0")

    public static final int ANIM_STYLE_CLOSE_EXIT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.513 -0500", hash_original_field = "80DE70A8F64B4FA590EECB2D1A42D1F8", hash_generated_field = "6EE14C70EFD271C2B32055938BC50C20")

    public static final int ANIM_STYLE_FADE_ENTER = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.515 -0500", hash_original_field = "67406C1745F62333EF8CBF7A692B93CF", hash_generated_field = "F489982675E5C10DFACA93BE86E50D4D")

    public static final int ANIM_STYLE_FADE_EXIT = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.236 -0500", hash_original_field = "11FD18D208B09E922FC03FBF68E7335B", hash_generated_field = "11FD18D208B09E922FC03FBF68E7335B")

    ArrayList<Runnable> mPendingActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.238 -0500", hash_original_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3", hash_generated_field = "3A7F97DF5485B6AB6EA8FB5E99EA1CA3")

    Runnable[] mTmpActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.240 -0500", hash_original_field = "CD4485F6F525738DAA0EA0DC245911AB", hash_generated_field = "CD4485F6F525738DAA0EA0DC245911AB")

    boolean mExecutingActions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.242 -0500", hash_original_field = "A1650882FA43FC001601740ED87DBA1F", hash_generated_field = "A1650882FA43FC001601740ED87DBA1F")
    
    ArrayList<Fragment> mActive;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.244 -0500", hash_original_field = "FF37605B8D813171195C0EBF92B2A116", hash_generated_field = "FF37605B8D813171195C0EBF92B2A116")

    ArrayList<Fragment> mAdded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.246 -0500", hash_original_field = "5441838D07CA3D72A0FE3BB98FAAC33E", hash_generated_field = "5441838D07CA3D72A0FE3BB98FAAC33E")

    ArrayList<Integer> mAvailIndices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.248 -0500", hash_original_field = "A66A7C10189C949E8CDC007D4D07280E", hash_generated_field = "A66A7C10189C949E8CDC007D4D07280E")

    ArrayList<BackStackRecord> mBackStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.249 -0500", hash_original_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7", hash_generated_field = "9F6E7D7F78C72C3E1BF132D62E1BFDF7")

    ArrayList<Fragment> mCreatedMenus;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.252 -0500", hash_original_field = "89571A39B2AB736200FBD57A213BDB4D", hash_generated_field = "89571A39B2AB736200FBD57A213BDB4D")

    ArrayList<BackStackRecord> mBackStackIndices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.254 -0500", hash_original_field = "27AED91E8586753C6865FA558A4716C8", hash_generated_field = "27AED91E8586753C6865FA558A4716C8")

    ArrayList<Integer> mAvailBackStackIndices;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.256 -0500", hash_original_field = "078DA2C7CA0D4289F90F664D0B3EDB3B", hash_generated_field = "078DA2C7CA0D4289F90F664D0B3EDB3B")

    ArrayList<OnBackStackChangedListener> mBackStackChangeListeners;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.258 -0500", hash_original_field = "9521C64640071A41BA8B18982DEC3BE2", hash_generated_field = "9521C64640071A41BA8B18982DEC3BE2")

    int mCurState = Fragment.INITIALIZING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.261 -0500", hash_original_field = "DC6970CAF75184DB6DB1AAC52EA720C0", hash_generated_field = "DC6970CAF75184DB6DB1AAC52EA720C0")

    FragmentActivity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.263 -0500", hash_original_field = "4716918018B597B9E2482B529B6BAD4A", hash_generated_field = "4716918018B597B9E2482B529B6BAD4A")

    FragmentContainer mContainer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.265 -0500", hash_original_field = "D9437984C8B60662ED185FA42AA3938D", hash_generated_field = "D9437984C8B60662ED185FA42AA3938D")

    Fragment mParent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.267 -0500", hash_original_field = "19DD0E42F9FC244F37062274E8F2012D", hash_generated_field = "19DD0E42F9FC244F37062274E8F2012D")
    
    boolean mNeedMenuInvalidate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.268 -0500", hash_original_field = "E68067DB35DA8BD96BFB5C858DBE74BF", hash_generated_field = "E68067DB35DA8BD96BFB5C858DBE74BF")

    boolean mStateSaved;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.271 -0500", hash_original_field = "708F9D94DA99CD83DBB18AAAFBA8C49F", hash_generated_field = "708F9D94DA99CD83DBB18AAAFBA8C49F")

    boolean mDestroyed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.272 -0500", hash_original_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE", hash_generated_field = "77A8D08C6FF564B2CE5BCBBFE4C849FE")

    String mNoTransactionsBecause;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.275 -0500", hash_original_field = "79BC4D349D09DCA85692E9FAD9D9C6F7", hash_generated_field = "79BC4D349D09DCA85692E9FAD9D9C6F7")

    boolean mHavePendingDeferredStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.276 -0500", hash_original_field = "92A56B8032395A53760143DE797F97FA", hash_generated_field = "92A56B8032395A53760143DE797F97FA")

    Bundle mStateBundle = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.278 -0500", hash_original_field = "280BE7FE9228C6CA67328AF4B4B28047", hash_generated_field = "280BE7FE9228C6CA67328AF4B4B28047")

    SparseArray<Parcelable> mStateArray = null;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.884 -0400", hash_original_field = "BB4C35BD7F2BC82D3F4C38422B568E9B", hash_generated_field = "9126D3C716AC852A46D1963380A0CE0E")

    Runnable mExecCommit = new Runnable() {        
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.884 -0400", hash_original_method = "C2BA1C69EB0B4CCFF1A319535DB79508", hash_generated_method = "FEDC918E58215E12D8175F59CA2BA6B4")
        @Override
        public void run() {
            execPendingActions();
            
        }
        
};
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.354 -0400", hash_original_method = "57A648A59831AB7BB1637AFC6125C81E", hash_generated_method = "57A648A59831AB7BB1637AFC6125C81E")
    public FragmentManagerImpl ()
    {
        //Synthesized constructor
    }

    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.286 -0500", hash_original_method = "70ACCC725CBD51E4B696A7DF31DD0DB0", hash_generated_method = "C16DE2EC9D0E5F4F1C992757277ACCC3")
    
private void throwException(RuntimeException ex) {
        Log.e(TAG, ex.getMessage());
        Log.e(TAG, "Activity state:");
        LogWriter logw = new LogWriter(TAG);
        PrintWriter pw = new PrintWriter(logw);
        if (mActivity != null) {
            try {
                mActivity.dump("  ", null, pw, new String[] { });
            } catch (Exception e) {
                Log.e(TAG, "Failed dumping state", e);
            }
        } else {
            try {
                dump("  ", null, pw, new String[] { });
            } catch (Exception e) {
                Log.e(TAG, "Failed dumping state", e);
            }
        }
        throw ex;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.288 -0500", hash_original_method = "FD4DF6D1DA8CD9545895F43FA5CF7B0B", hash_generated_method = "901C9AD0A2A75ECA10E98E593A7AB045")
    
@Override
    public FragmentTransaction beginTransaction() {
        return new BackStackRecord(this);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.290 -0500", hash_original_method = "082964FFA3913D960E19EEB76BD9505B", hash_generated_method = "1711C57317FEF53BD66DBCDCF1F50005")
    
@Override
    public boolean executePendingTransactions() {
        return execPendingActions();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.296 -0500", hash_original_method = "5CB88371A39240A7C2FB2F2041C5DD0D", hash_generated_method = "045B9A2FE36B9056EDAE06521EEDFC5E")
    
@Override
    public void popBackStack() {
        enqueueAction(new Runnable() {
            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 10:56:05.495 -0500", hash_original_method = "C15C9D80C4BF4FB6B2AF0B93A4449441", hash_generated_method = "1E775B2913B07D2EF0E46F6FF2B9DCB4")
            
@Override public void run() {
                popBackStackState(mActivity.mHandler, null, -1, 0);
            }
        }, false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.299 -0500", hash_original_method = "B7072E2D8E1B8CAC03251D641D234641", hash_generated_method = "3B7E724402B0B26FE28D78D5E2981544")
    
@Override
    public boolean popBackStackImmediate() {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(mActivity.mHandler, null, -1, 0);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.304 -0500", hash_original_method = "9E86D2BA46D98A91B2D43097CFA7F639", hash_generated_method = "25AC695BADCB95EC6033649501BF1614")
    
@Override
    public void popBackStack(final String name, final int flags) {
        enqueueAction(new Runnable() {
            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 10:56:05.500 -0500", hash_original_method = "22FC8A6DB6B4AB9E651D01E64BEED72A", hash_generated_method = "D4F166516CD2906CC8BDAB23FF969A06")
            
@Override public void run() {
                popBackStackState(mActivity.mHandler, name, -1, flags);
            }
        }, false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.306 -0500", hash_original_method = "4DEC43188CEAB5FA4EF2839673649ECC", hash_generated_method = "E65ED40E729BFDE74201D6481EDD2229")
    
@Override
    public boolean popBackStackImmediate(String name, int flags) {
        checkStateLoss();
        executePendingTransactions();
        return popBackStackState(mActivity.mHandler, name, -1, flags);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.312 -0500", hash_original_method = "DA57C1B5DA7DBD65A6FF7556F6C0B827", hash_generated_method = "645643CDB361BBE23BA78834F510A0DB")
    
@Override
    public void popBackStack(final int id, final int flags) {
        if (id < 0) {
            throw new IllegalArgumentException("Bad id: " + id);
        }
        enqueueAction(new Runnable() {
            @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-01-27 10:56:05.507 -0500", hash_original_method = "DBCE7037D51EB5153CDA373E6D392F0E", hash_generated_method = "44E0DD65D7D6454CB2701D75E88FE657")
            
@Override public void run() {
                popBackStackState(mActivity.mHandler, null, id, flags);
            }
        }, false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.314 -0500", hash_original_method = "C28CBCAD3FA2084F032C85B006AF0CA6", hash_generated_method = "A853E3468A25B84DB29E4E0195D577D6")
    
@Override
    public boolean popBackStackImmediate(int id, int flags) {
        checkStateLoss();
        executePendingTransactions();
        if (id < 0) {
            throw new IllegalArgumentException("Bad id: " + id);
        }
        return popBackStackState(mActivity.mHandler, null, id, flags);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.316 -0500", hash_original_method = "81448DC3AD62196301F3A4A762AB09A8", hash_generated_method = "87FA987464062DB67C94A14CF163F8A8")
    
@Override
    public int getBackStackEntryCount() {
        return mBackStack != null ? mBackStack.size() : 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.319 -0500", hash_original_method = "898A7E40DF942FAA7422F0070AE7C2C0", hash_generated_method = "936D529282443088BF02B3FA798849A8")
    
@Override
    public BackStackEntry getBackStackEntryAt(int index) {
        return mBackStack.get(index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.321 -0500", hash_original_method = "5B02C223CD8F1AC3632AF80A3BE5FAF1", hash_generated_method = "CD42180E56219A3E765F41507C27AA02")
    
@Override
    public void addOnBackStackChangedListener(OnBackStackChangedListener listener) {
        if (mBackStackChangeListeners == null) {
            mBackStackChangeListeners = new ArrayList<OnBackStackChangedListener>();
        }
        mBackStackChangeListeners.add(listener);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.323 -0500", hash_original_method = "0EB71E2FD8D5B96EE15FDFA4CFDC7A3A", hash_generated_method = "4B9CBF708A93EE1CAF39BC728D2E0AAD")
    
@Override
    public void removeOnBackStackChangedListener(OnBackStackChangedListener listener) {
        if (mBackStackChangeListeners != null) {
            mBackStackChangeListeners.remove(listener);
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.326 -0500", hash_original_method = "3F35630659DD6C09B78E73F7BD07330C", hash_generated_method = "F8877F0026C40E0DE0A6BF307016E509")
    
@Override
    public void putFragment(Bundle bundle, String key, Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException(new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager"));
        }
        bundle.putInt(key, fragment.mIndex);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.329 -0500", hash_original_method = "4CDB8119120F20E16B511E77159C27B3", hash_generated_method = "E17E6A66A2A49A4D03E0EAB5BC904E20")
    
@Override
    public Fragment getFragment(Bundle bundle, String key) {
        int index = bundle.getInt(key, -1);
        if (index == -1) {
            return null;
        }
        if (index >= mActive.size()) {
            throwException(new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index));
        }
        Fragment f = mActive.get(index);
        if (f == null) {
            throwException(new IllegalStateException("Fragement no longer exists for key "
                    + key + ": index " + index));
        }
        return f;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.332 -0500", hash_original_method = "D25922C7B1DBFD38B1587BBC1D3E9AF4", hash_generated_method = "D54FEC4264809A7589A69D11E59B97A8")
    
@Override
    public Fragment.SavedState saveFragmentInstanceState(Fragment fragment) {
        if (fragment.mIndex < 0) {
            throwException( new IllegalStateException("Fragment " + fragment
                    + " is not currently in the FragmentManager"));
        }
        if (fragment.mState > Fragment.INITIALIZING) {
            Bundle result = saveFragmentBasicState(fragment);
            return result != null ? new Fragment.SavedState(result) : null;
        }
        return null;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.334 -0500", hash_original_method = "809378480DC9ABFE56F2FAE2E163A583", hash_generated_method = "DA521A7DEB85214D3168FC663436EB63")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        if (mParent != null) {
            DebugUtils.buildShortClassTag(mParent, sb);
        } else {
            DebugUtils.buildShortClassTag(mActivity, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.339 -0500", hash_original_method = "69E4EB9F72755E8BD358E210AC6CFB24", hash_generated_method = "78C69E761850140AC9D9B5C0B0A94B56")
    
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
        writer.print(prefix); writer.print("  mActivity="); writer.println(mActivity);
        writer.print(prefix); writer.print("  mContainer="); writer.println(mContainer);
        if (mParent != null) {
            writer.print(prefix); writer.print("  mParent="); writer.println(mParent);
        }
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.358 -0500", hash_original_method = "1D86F34E1479CAC948F0E54CF5418376", hash_generated_method = "363C790134E488257F21F18B160FC8D3")
    
Animation loadAnimation(Fragment fragment, int transit, boolean enter,
            int transitionStyle) {
        Animation animObj = fragment.onCreateAnimation(transit, enter,
                fragment.mNextAnim);
        if (animObj != null) {
            return animObj;
        }
        
        if (fragment.mNextAnim != 0) {
            Animation anim = AnimationUtils.loadAnimation(mActivity, fragment.mNextAnim);
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
        
        switch (styleIndex) {
            case ANIM_STYLE_OPEN_ENTER:
                return makeOpenCloseAnimation(mActivity, 1.125f, 1.0f, 0, 1);
            case ANIM_STYLE_OPEN_EXIT:
                return makeOpenCloseAnimation(mActivity, 1.0f, .975f, 1, 0);
            case ANIM_STYLE_CLOSE_ENTER:
                return makeOpenCloseAnimation(mActivity, .975f, 1.0f, 0, 1);
            case ANIM_STYLE_CLOSE_EXIT:
                return makeOpenCloseAnimation(mActivity, 1.0f, 1.075f, 1, 0);
            case ANIM_STYLE_FADE_ENTER:
                return makeFadeAnimation(mActivity, 0, 1);
            case ANIM_STYLE_FADE_EXIT:
                return makeFadeAnimation(mActivity, 1, 0);
        }
        
        if (transitionStyle == 0 && mActivity.getWindow() != null) {
            transitionStyle = mActivity.getWindow().getAttributes().windowAnimations;
        }
        if (transitionStyle == 0) {
            return null;
        }
        
        //TypedArray attrs = mActivity.obtainStyledAttributes(transitionStyle,
        //        com.android.internal.R.styleable.FragmentAnimation);
        //int anim = attrs.getResourceId(styleIndex, 0);
        //attrs.recycle();
        
        //if (anim == 0) {
        //    return null;
        //}
        
        //return AnimatorInflater.loadAnimator(mActivity, anim);
        return null;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.361 -0500", hash_original_method = "53A703CAB9B91DDAE05ABF1E3656A1E0", hash_generated_method = "90E358B51EA9A9C0CD1F76745C968E1C")
    
public void performPendingDeferredStart(Fragment f) {
        if (f.mDeferStart) {
            if (mExecutingActions) {
                // Wait until we're done executing our pending transactions
                mHavePendingDeferredStart = true;
                return;
            }
            f.mDeferStart = false;
            moveToState(f, mCurState, 0, 0, false);
        }
    }
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:32.364 -0400", hash_original_method = "F13A9F8BA98A34618DEF4155010BA2F5", hash_generated_method = "8CA88B4CA243176602395A315F8F4613")
     void moveToState(Fragment f, int newState, int transit, int transitionStyle,
            boolean keepActive) {
        addTaint(keepActive);
        addTaint(transitionStyle);
        addTaint(transit);
        addTaint(newState);
        if((!f.mAdded || f.mDetached) && newState > Fragment.CREATED)        
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
                moveToState(f, f.mStateAfterAnimating, 0, 0, true);
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
            f.mParentFragment = mParent;
            f.mFragmentManager = mParent != null
                            ? mParent.mChildFragmentManager : mActivity.mFragments;
            f.mCalled = false;
            f.onAttach(mActivity);
            if(!f.mCalled)            
            {
                SuperNotCalledException var3B21D72FE3B78DA21309B053881BE5E5_1575770204 = new SuperNotCalledException("Fragment " + f
                                + " did not call through to super.onAttach()");
                var3B21D72FE3B78DA21309B053881BE5E5_1575770204.addTaint(getTaint());
                throw var3B21D72FE3B78DA21309B053881BE5E5_1575770204;
            } //End block
            if(f.mParentFragment == null)            
            {
                mActivity.onAttachFragment(f);
            } //End block
            if(!f.mRetaining)            
            {
                f.performCreate(f.mSavedFragmentState);
            } //End block
            f.mRetaining = false;
            if(f.mFromLayout)            
            {
                f.mView = f.performCreateView(f.getLayoutInflater(
                                f.mSavedFragmentState), null, f.mSavedFragmentState);
                if(f.mView != null)                
                {
                    f.mInnerView = f.mView;
                    f.mView = NoSaveStateFrameLayout.wrap(f.mView);
                    if(f.mHidden)                    
                    f.mView.setVisibility(View.GONE);
                    f.onViewCreated(f.mView, f.mSavedFragmentState);
                } //End block
                else
                {
                    f.mInnerView = null;
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
                        container = (ViewGroup)mContainer.findViewById(f.mContainerId);
                        if(container == null && !f.mRestored)                        
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
                    if(f.mView != null)                    
                    {
                        f.mInnerView = f.mView;
                        f.mView = NoSaveStateFrameLayout.wrap(f.mView);
                        if(container != null)                        
                        {
                            Animation anim = loadAnimation(f, transit, true,
                                            transitionStyle);
                            if(anim != null)                            
                            {
                                f.mView.startAnimation(anim);
                            } //End block
                            container.addView(f.mView);
                        } //End block
                        if(f.mHidden)                        
                        f.mView.setVisibility(View.GONE);
                        f.onViewCreated(f.mView, f.mSavedFragmentState);
                    } //End block
                    else
                    {
                        f.mInnerView = null;
                    } //End block
                } //End block
                f.performActivityCreated(f.mSavedFragmentState);
                if(f.mView != null)                
                {
                    f.restoreViewState(f.mSavedFragmentState);
                } //End block
                f.mSavedFragmentState = null;
            } //End block
            case Fragment.ACTIVITY_CREATED:
            case Fragment.STOPPED:
            if(newState > Fragment.STOPPED)            
            {
                if(DEBUG){ }                f.performStart();
            } //End block
            case Fragment.STARTED:
            if(newState > Fragment.STARTED)            
            {
                if(DEBUG){ }                f.mResumed = true;
                f.performResume();
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
                if(DEBUG){ }                f.performPause();
                f.mResumed = false;
            } //End block
            case Fragment.STARTED:
            if(newState < Fragment.STARTED)            
            {
                if(DEBUG){ }                f.performStop();
            } //End block
            case Fragment.STOPPED:
            if(newState < Fragment.STOPPED)            
            {
                if(DEBUG){ }                f.performReallyStop();
            } //End block
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
                f.performDestroyView();
                if(f.mView != null && f.mContainer != null)                
                {
                    Animation anim = null;
                    if(mCurState > Fragment.INITIALIZING && !mDestroyed)                    
                    {
                        anim = loadAnimation(f, transit, false,
                                        transitionStyle);
                    } //End block
                    if(anim != null)                    
                    {
                        final Fragment fragment = f;
                        f.mAnimatingAway = f.mView;
                        f.mStateAfterAnimating = newState;
                        anim.setAnimationListener(new AnimationListener() {
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.366 -0500", hash_original_method = "ADB37ED087A6B8FD09A7637E04A46959", hash_generated_method = "053CF852A702205FC2C67D728C4DE83C")
                                
@Override
                                    public void onAnimationEnd(Animation animation) {
                                        if (fragment.mAnimatingAway != null) {
                                            fragment.mAnimatingAway = null;
                                            moveToState(fragment, fragment.mStateAfterAnimating,
                                                    0, 0, false);
                                        }
                                    }
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.369 -0500", hash_original_method = "C6539FC3721A6B610C21747FF87D7A97", hash_generated_method = "725FC2A3344A4EFF255A4B9E3BABFD36")
                                
@Override
                                    public void onAnimationRepeat(Animation animation) {
                                    }
                                    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.373 -0500", hash_original_method = "72AD432A5D6B612A6CC4174C0C1E057D", hash_generated_method = "A6AC1F92BDB133FFE34989B712783586")
                                
@Override
                                    public void onAnimationStart(Animation animation) {
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
            case Fragment.CREATED:
            if(newState < Fragment.CREATED)            
            {
                if(mDestroyed)                
                {
                    if(f.mAnimatingAway != null)                    
                    {
                        View v = f.mAnimatingAway;
                        f.mAnimatingAway = null;
                        v.clearAnimation();
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
                        f.performDestroy();
                    } //End block
                    f.mCalled = false;
                    f.onDetach();
                    if(!f.mCalled)                    
                    {
                        SuperNotCalledException varA1E86A4AD3397A3A1F40BAC562CFC4E0_1132341421 = new SuperNotCalledException("Fragment " + f
                                        + " did not call through to super.onDetach()");
                        varA1E86A4AD3397A3A1F40BAC562CFC4E0_1132341421.addTaint(getTaint());
                        throw varA1E86A4AD3397A3A1F40BAC562CFC4E0_1132341421;
                    } //End block
                    if(!keepActive)                    
                    {
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
            } //End block
}
        } //End block
        f.mState = newState;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.381 -0500", hash_original_method = "253ACA6E8863F76AC823063DED921CB5", hash_generated_method = "253ACA6E8863F76AC823063DED921CB5")
    
void moveToState(Fragment f) {
        moveToState(f, mCurState, 0, 0, false);
    }

    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.383 -0500", hash_original_method = "4A2DC4C23578532593EF5B01DCA60326", hash_generated_method = "4A2DC4C23578532593EF5B01DCA60326")
    
void moveToState(int newState, boolean always) {
        moveToState(newState, 0, 0, always);
    }
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.386 -0500", hash_original_method = "5BD27BFF276D517E1379D91A3F7AF343", hash_generated_method = "5BD27BFF276D517E1379D91A3F7AF343")
    
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
                    moveToState(f, newState, transit, transitStyle, false);
                    if (f.mLoaderManager != null) {
                        loadersRunning |= f.mLoaderManager.hasRunningLoaders();
                    }
                }
            }

            if (!loadersRunning) {
                startPendingDeferredFragments();
            }

            if (mNeedMenuInvalidate && mActivity != null && mCurState == Fragment.RESUMED) {
                mActivity.supportInvalidateOptionsMenu();
                mNeedMenuInvalidate = false;
            }
        }
    }

    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.388 -0500", hash_original_method = "CCAA4C21D5B5313253593374D7FC1754", hash_generated_method = "CCAA4C21D5B5313253593374D7FC1754")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.390 -0500", hash_original_method = "47E8AE46DB9C6E9F4895918BFF9C77EF", hash_generated_method = "47E8AE46DB9C6E9F4895918BFF9C77EF")
    
void makeActive(Fragment f) {
        if (f.mIndex >= 0) {
            return;
        }
        
        if (mAvailIndices == null || mAvailIndices.size() <= 0) {
            if (mActive == null) {
                mActive = new ArrayList<Fragment>();
            }
            f.setIndex(mActive.size(), mParent);
            mActive.add(f);
            
        } else {
            f.setIndex(mAvailIndices.remove(mAvailIndices.size()-1), mParent);
            mActive.set(f.mIndex, f);
        }
        if (DEBUG) Log.v(TAG, "Allocated fragment index " + f);
    }
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.393 -0500", hash_original_method = "2838DA3381C6FA665FE83DACB606EE48", hash_generated_method = "2838DA3381C6FA665FE83DACB606EE48")
    
void makeInactive(Fragment f) {
        if (f.mIndex < 0) {
            return;
        }
        
        if (DEBUG) Log.v(TAG, "Freeing fragment index " + f);
        mActive.set(f.mIndex, null);
        if (mAvailIndices == null) {
            mAvailIndices = new ArrayList<Integer>();
        }
        mAvailIndices.add(f.mIndex);
        mActivity.invalidateSupportFragment(f.mWho);
        f.initState();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.396 -0500", hash_original_method = "A7004D7E770917F1698CC4D8DC4A636A", hash_generated_method = "5D45CD6D3E99FF60725B0A5E5430390F")
    
public void addFragment(Fragment fragment, boolean moveToStateNow) {
        fragment.onAttach(mActivity);

        if (mAdded == null) {
            mAdded = new ArrayList<Fragment>();
        }
        if (DEBUG) Log.v(TAG, "add: " + fragment);
        makeActive(fragment);
        if (!fragment.mDetached) {
            if (mAdded.contains(fragment)) {
                throw new IllegalStateException("Fragment already added: " + fragment);
            }
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
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.398 -0500", hash_original_method = "13B3CB0CAD8C045C67262987362B8EBE", hash_generated_method = "845DE82CC508519CDA5C39A0AB602C5E")
    
public void removeFragment(Fragment fragment, int transition, int transitionStyle) {
        if (DEBUG) Log.v(TAG, "remove: " + fragment + " nesting=" + fragment.mBackStackNesting);
        final boolean inactive = !fragment.isInBackStack();
        if (!fragment.mDetached || inactive) {
            if (mAdded != null) {
                mAdded.remove(fragment);
            }
            if (fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            fragment.mAdded = false;
            fragment.mRemoving = true;
            moveToState(fragment, inactive ? Fragment.INITIALIZING : Fragment.CREATED,
                    transition, transitionStyle, false);
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.401 -0500", hash_original_method = "BED4301A21B487BD6D143A374885F309", hash_generated_method = "E028155D11E6141129253F8A0FCB33CB")
    
public void hideFragment(Fragment fragment, int transition, int transitionStyle) {
        if (DEBUG) Log.v(TAG, "hide: " + fragment);
        if (!fragment.mHidden) {
            fragment.mHidden = true;
            if (fragment.mView != null) {
                Animation anim = loadAnimation(fragment, transition, false,
                        transitionStyle);
                if (anim != null) {
                    fragment.mView.startAnimation(anim);
                }
                fragment.mView.setVisibility(View.GONE);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(true);
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.403 -0500", hash_original_method = "5884A689188772E4B067D85FA0FE2485", hash_generated_method = "A4C8B7377C9F34FB70B82BC0F478C522")
    
public void showFragment(Fragment fragment, int transition, int transitionStyle) {
 
        if (DEBUG) Log.v(TAG, "show: " + fragment);
        if (fragment.mHidden) {
            fragment.mHidden = false;
            if (fragment.mView != null) {
                Animation anim = loadAnimation(fragment, transition, true,
                        transitionStyle);
                if (anim != null) {
                    fragment.mView.startAnimation(anim);
                }
                fragment.mView.setVisibility(View.VISIBLE);
            }
            if (fragment.mAdded && fragment.mHasMenu && fragment.mMenuVisible) {
                mNeedMenuInvalidate = true;
            }
            fragment.onHiddenChanged(false);
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.406 -0500", hash_original_method = "8ADA384A2A804F3DB8950E51751AE080", hash_generated_method = "8FEE67764484A2C0857EC0E768956DF6")
    
public void detachFragment(Fragment fragment, int transition, int transitionStyle) {
        if (DEBUG) Log.v(TAG, "detach: " + fragment);
        if (!fragment.mDetached) {
            fragment.mDetached = true;
            if (fragment.mAdded) {
                // We are not already in back stack, so need to remove the fragment.
                if (mAdded != null) {
                    if (DEBUG) Log.v(TAG, "remove from detach: " + fragment);
                    mAdded.remove(fragment);
                }
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    mNeedMenuInvalidate = true;
                }
                fragment.mAdded = false;
                moveToState(fragment, Fragment.CREATED, transition, transitionStyle, false);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.408 -0500", hash_original_method = "C689EB45F7FDDB493496798809CCC982", hash_generated_method = "241454DBAFC49A612A7BCF6A616F6F81")
    
public void attachFragment(Fragment fragment, int transition, int transitionStyle) {
         fragment.onAttach(mActivity);
        if (DEBUG) Log.v(TAG, "attach: " + fragment);
        if (fragment.mDetached) {
            fragment.mDetached = false;
            if (!fragment.mAdded) {
                if (mAdded == null) {
                    mAdded = new ArrayList<Fragment>();
                }
                if (mAdded.contains(fragment)) {
                    throw new IllegalStateException("Fragment already added: " + fragment);
                }
                if (DEBUG) Log.v(TAG, "add from attach: " + fragment);
                mAdded.add(fragment);
                fragment.mAdded = true;
                if (fragment.mHasMenu && fragment.mMenuVisible) {
                    mNeedMenuInvalidate = true;
                }
                moveToState(fragment, mCurState, transition, transitionStyle, false);
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.411 -0500", hash_original_method = "369BBF881289C60802E9A80BDB6F1062", hash_generated_method = "9736C645D83BDCF63F853870AD11DBCE")
    @DSVAMethod
public Fragment findFragmentById(int id) {
        if (mAdded != null) {
            // First look through added fragments.
            for (int i=mAdded.size()-1; i>=0; i--) {
                Fragment f = mAdded.get(i);
                if (f != null && f.mFragmentId == id) {
                    return f;
                }
            }
        }
        if (mActive != null) {
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
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.414 -0500", hash_original_method = "A116F7F22C8FEEEBB3418EA3417C69EB", hash_generated_method = "1A1DDE994C81088F0B8A437B3EB43E78")
    
public Fragment findFragmentByTag(String tag) {
        if (mAdded != null && tag != null) {
            // First look through added fragments.
            for (int i=mAdded.size()-1; i>=0; i--) {
                Fragment f = mAdded.get(i);
                if (f != null && tag.equals(f.mTag)) {
                    return f;
                }
            }
        }
        if (mActive != null && tag != null) {
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
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.416 -0500", hash_original_method = "9082D0FF97F62C4058EE52B6A6365151", hash_generated_method = "81870B04F09304DD497F7A14051F7370")
    
public Fragment findFragmentByWho(String who) {
        if (mActive != null && who != null) {
            for (int i=mActive.size()-1; i>=0; i--) {
                Fragment f = mActive.get(i);
                if (f != null && (f=f.findFragmentByWho(who)) != null) {
                    return f;
                }
            }
        }
        return null;
    }
    
    @DSComment("Private Method")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.418 -0500", hash_original_method = "B87B380B690A16EB7F37B7EE1C0A0D26", hash_generated_method = "AD151F1BDA94909FC4C898DCA0920366")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.421 -0500", hash_original_method = "32359130EC903AF4E096237D1F067453", hash_generated_method = "A32C82F2A4A576D4BCE79316882D08F9")
    
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
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.424 -0500", hash_original_method = "1503673DA6CC1FF53261337C6A89F6BE", hash_generated_method = "8EAB5C9686F912917B3BCA15DDEA45E8")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.426 -0500", hash_original_method = "F0AF804A23A686630C8F5E2012EB99F7", hash_generated_method = "4E2FDC94FAD3569E5524DEE3B958EFF6")
    
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

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.428 -0500", hash_original_method = "A75FE5CB17552EA725360407924677A5", hash_generated_method = "34DE1872754C72E290FC496AAAF34C8D")
    
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
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.432 -0500", hash_original_method = "2EC9B9D8ABC4926EA1F7FF85BE00D458", hash_generated_method = "204D2702904F445488B280B0FF1C4460")
    
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

    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.434 -0500", hash_original_method = "480CA24D6CDDA51ECD1DFDE903041169", hash_generated_method = "480CA24D6CDDA51ECD1DFDE903041169")
    
void reportBackStackChanged() {
        if (mBackStackChangeListeners != null) {
            for (int i=0; i<mBackStackChangeListeners.size(); i++) {
                mBackStackChangeListeners.get(i).onBackStackChanged();
            }
        }
    }

    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.436 -0500", hash_original_method = "93C61FA561A07CB0E9B057A7A904C282", hash_generated_method = "93C61FA561A07CB0E9B057A7A904C282")
    
void addBackStackState(BackStackRecord state) {
        if (mBackStack == null) {
            mBackStack = new ArrayList<BackStackRecord>();
        }
        mBackStack.add(state);
        reportBackStackChanged();
    }
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.439 -0500", hash_original_method = "2DCA4D0949EEA78B53FF55FD7B1EE1F8", hash_generated_method = "77498A76B367759D221EC394B1246D3C")
    
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.442 -0500", hash_original_method = "4601075007D50CE0BCD1D759D668CB84", hash_generated_method = "4601075007D50CE0BCD1D759D668CB84")
    
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
                    if (DEBUG) Log.v(TAG, "retainNonConfig: keeping retained " + f);
                }
            }
        }
        return fragments;
    }
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.444 -0500", hash_original_method = "AB64A806E53952D63B221B8A02A39B9D", hash_generated_method = "AB64A806E53952D63B221B8A02A39B9D")
    
void saveFragmentViewState(Fragment f) {
        if (f.mInnerView == null) {
            return;
        }
        if (mStateArray == null) {
            mStateArray = new SparseArray<Parcelable>();
        } else {
            mStateArray.clear();
        }
        f.mInnerView.saveHierarchyState(mStateArray);
        if (mStateArray.size() > 0) {
            f.mSavedViewState = mStateArray;
            mStateArray = null;
        }
    }
    
    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.446 -0500", hash_original_method = "4EAE6A1450E2744D0D17A0CBB3487A4E", hash_generated_method = "E9031779BAB51B2450D4E6B808902980")
    
Bundle saveFragmentBasicState(Fragment f) {
        Bundle result = null;

        if (mStateBundle == null) {
            mStateBundle = new Bundle();
        }
        f.performSaveInstanceState(mStateBundle);
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
            if (result == null) {
                result = new Bundle();
            }
            // Only add this if it's not the default value
            result.putBoolean(FragmentManagerImpl.USER_VISIBLE_HINT_TAG, f.mUserVisibleHint);
        }

        return result;
    }

    @DSComment("Package priviledge")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.450 -0500", hash_original_method = "10343325EA0A9B349A8A31D89021E4C8", hash_generated_method = "AFB6B001EDEBA5C553B21A06475C8774")
    
Parcelable saveAllState() {
        // Make sure all pending operations have now been executed to get
        // our state update-to-date.
        execPendingActions();

        if (HONEYCOMB) {
            // As of Honeycomb, we save state after pausing.  Prior to that
            // it is before pausing.  With fragments this is an issue, since
            // there are many things you may do after pausing but before
            // stopping that change the fragment state.  For those older
            // devices, we will not at this point say that we have saved
            // the state, so we will allow them to continue doing fragment
            // transactions.  This retains the same semantics as Honeycomb,
            // though you do have the risk of losing the very most recent state
            // if the process is killed...  we'll live with that.
            mStateSaved = true;
        }

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
                if (f.mIndex < 0) {
                    throwException(new IllegalStateException(
                            "Failure saving state: active " + f
                            + " has cleared index: " + f.mIndex));
                }

                haveFragments = true;
                
                FragmentState fs = new FragmentState(f);
                active[i] = fs;
                
                if (f.mState > Fragment.INITIALIZING && fs.mSavedFragmentState == null) {
                    fs.mSavedFragmentState = saveFragmentBasicState(f);

                    if (f.mTarget != null) {
                        if (f.mTarget.mIndex < 0) {
                            throwException(new IllegalStateException(
                                    "Failure saving state: " + f
                                    + " has target not in fragment manager: " + f.mTarget));
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
                    if (added[i] < 0) {
                        throwException(new IllegalStateException(
                                "Failure saving state: active " + mAdded.get(i)
                                + " has cleared index: " + added[i]));
                    }
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
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.456 -0500", hash_original_method = "83508419770250A244151298D1C277A7", hash_generated_method = "B9306D1C9433F0BD1CAFE7B04830BDC9")
    
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
                Fragment f = fs.instantiate(mActivity, mParent);
                if (DEBUG) Log.v(TAG, "restoreAllState: active #" + i + ": " + f);
                mActive.add(f);
                // Now that the fragment is instantiated (or came from being
                // retained above), clear mInstance in case we end up re-restoring
                // from this FragmentState again.
                fs.mInstance = null;
            } else {
                mActive.add(null);
                if (mAvailIndices == null) {
                    mAvailIndices = new ArrayList<Integer>();
                }
                if (DEBUG) Log.v(TAG, "restoreAllState: avail #" + i);
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
                    throwException(new IllegalStateException(
                            "No instantiated fragment for index #" + fms.mAdded[i]));
                }
                f.mAdded = true;
                if (DEBUG) Log.v(TAG, "restoreAllState: added #" + i + ": " + f);
                if (mAdded.contains(f)) {
                    throw new IllegalStateException("Already added!");
                }
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
                if (DEBUG) {
                    Log.v(TAG, "restoreAllState: back stack #" + i
                        + " (index " + bse.mIndex + "): " + bse);
                    LogWriter logw = new LogWriter(TAG);
                    PrintWriter pw = new PrintWriter(logw);
                    bse.dump("  ", pw, false);
                }
                mBackStack.add(bse);
                if (bse.mIndex >= 0) {
                    setBackStackIndex(bse.mIndex, bse);
                }
            }
        } else {
            mBackStack = null;
        }
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.458 -0500", hash_original_method = "6B9797EDFBB2C38037CA64E1EEB36778", hash_generated_method = "0D93A72AFEDFA47ABE55B8BCD69E758E")
    
public void attachActivity(FragmentActivity activity,
            FragmentContainer container, Fragment parent) {
        if (mActivity != null) throw new IllegalStateException("Already attached");
        mActivity = activity;
        mContainer = container;
        mParent = parent;
    }
    
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.460 -0500", hash_original_method = "9E4E3FCA42BDE19CBF71140223B4B8D0", hash_generated_method = "AF7BA1CF9453ACC672FADB789538767F")
    
public void noteStateNotSaved() {
        mStateSaved = false;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.462 -0500", hash_original_method = "4EAFC4D017ED2B44474902CD00BD047E", hash_generated_method = "F80410DFB4B166184E53850E51F367FE")
    
public void dispatchCreate() {
        mStateSaved = false;
        moveToState(Fragment.CREATED, false);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.464 -0500", hash_original_method = "BB3D6B45374259B5EE70270EF5FFE721", hash_generated_method = "C71E1EE3F6A998E19E9FF1B016F6CD0C")
    
public void dispatchActivityCreated() {
        mStateSaved = false;
        moveToState(Fragment.ACTIVITY_CREATED, false);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.466 -0500", hash_original_method = "145C9AF81AEB697CB534D8E0C0F599A0", hash_generated_method = "6ED9E59AB5D969020DDB728A38951921")
    
public void dispatchStart() {
        mStateSaved = false;
        moveToState(Fragment.STARTED, false);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.468 -0500", hash_original_method = "35325401D14378833F40C78A6FC3DC5D", hash_generated_method = "48FF97841DA5605FE7E2DED074D18BF8")
    
public void dispatchResume() {
        mStateSaved = false;
        moveToState(Fragment.RESUMED, false);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.470 -0500", hash_original_method = "E6EE1A1408209BDB9066272C26AA9863", hash_generated_method = "9AC18B023C47D577819D4FA2F4EA2E8A")
    
public void dispatchPause() {
        moveToState(Fragment.STARTED, false);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.472 -0500", hash_original_method = "A6766C0F069AFB58F0A12165F2E095FC", hash_generated_method = "C74F34DF95389EFF82BC807B3C799F2A")
    
public void dispatchStop() {
        // See saveAllState() for the explanation of this.  We do this for
        // all platform versions, to keep our behavior more consistent between
        // them.
        mStateSaved = true;

        moveToState(Fragment.STOPPED, false);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.475 -0500", hash_original_method = "DCD943307D69805205EE4AFFC6D1EFE3", hash_generated_method = "2A0F13191FA233B5356099F97A636B11")
    
public void dispatchReallyStop() {
        moveToState(Fragment.ACTIVITY_CREATED, false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.477 -0500", hash_original_method = "69F58A9B4E2F72C0D627B376DB1A1CDC", hash_generated_method = "FF7F1FCF352E28EDEC256EC8D6B3999D")
    
public void dispatchDestroyView() {
        moveToState(Fragment.CREATED, false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.479 -0500", hash_original_method = "92EF0F88C8A3B3CDE2712CBD7D916058", hash_generated_method = "7461DD6A949B6E13C5E5CFFD743C3381")
    
public void dispatchDestroy() {
        mDestroyed = true;
        execPendingActions();
        moveToState(Fragment.INITIALIZING, false);
        mActivity = null;
        mContainer = null;
        mParent = null;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.482 -0500", hash_original_method = "3F9069EC8564151620B164A5CADDDD85", hash_generated_method = "8D087FF2B777B03F3987C3C1F7A8C59F")
    
public void dispatchConfigurationChanged(Configuration newConfig) {
        if (mAdded != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    f.performConfigurationChanged(newConfig);
                }
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.484 -0500", hash_original_method = "423006F51D0218BAC00AF0FAAABB2869", hash_generated_method = "56410E843CF3C28ACE8632A3BFC44512")
    
public void dispatchLowMemory() {
        if (mAdded != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    f.performLowMemory();
                }
            }
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.487 -0500", hash_original_method = "E04D4A6462A884A432217EF1D5562FD6", hash_generated_method = "54DA81345F51ECC604B74FCE4CBC7BD8")
    
public boolean dispatchCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean show = false;
        ArrayList<Fragment> newMenus = null;
        if (mAdded != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    if (f.performCreateOptionsMenu(menu, inflater)) {
                        show = true;
                        if (newMenus == null) {
                            newMenus = new ArrayList<Fragment>();
                        }
                        newMenus.add(f);
                    }
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
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.490 -0500", hash_original_method = "39A1BE180E5A6D21A2BE9889A37AE1EE", hash_generated_method = "CA10F0D096C3095D1B614DDEB28C4E4E")
    
public boolean dispatchPrepareOptionsMenu(Menu menu) {
        boolean show = false;
        if (mAdded != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    if (f.performPrepareOptionsMenu(menu)) {
                        show = true;
                    }
                }
            }
        }
        return show;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.492 -0500", hash_original_method = "40C97B67F40ABFD093891951534367FF", hash_generated_method = "BA5E1824278B227BC5BF7B4DFAFC68B6")
    
public boolean dispatchOptionsItemSelected(MenuItem item) {
        if (mAdded != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    if (f.performOptionsItemSelected(item)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.494 -0500", hash_original_method = "61E677AAD1D9B7A657F2B5668ED52005", hash_generated_method = "563463A683F9B91706506BEF0D4E0EC3")
    
public boolean dispatchContextItemSelected(MenuItem item) {
        if (mAdded != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    if (f.performContextItemSelected(item)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:34.497 -0500", hash_original_method = "6CB4593DD4D25806442B1A7EB0939595", hash_generated_method = "407DFF5A417A6E6AA48CE8599FBD23EC")
    
public void dispatchOptionsMenuClosed(Menu menu) {
        if (mAdded != null) {
            for (int i=0; i<mAdded.size(); i++) {
                Fragment f = mAdded.get(i);
                if (f != null) {
                    f.performOptionsMenuClosed(menu);
                }
            }
        }
    }
}

interface FragmentContainer {
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    public View findViewById(int id);
}

