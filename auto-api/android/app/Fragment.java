package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.animation.Animator;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DebugUtils;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

final class FragmentState implements Parcelable {
    String mClassName;
    int mIndex;
    boolean mFromLayout;
    int mFragmentId;
    int mContainerId;
    String mTag;
    boolean mRetainInstance;
    boolean mDetached;
    Bundle mArguments;
    Bundle mSavedFragmentState;
    Fragment mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.490 -0400", hash_original_method = "116485142A61C36D4B47DBE9BCB45890", hash_generated_method = "902B27AD6A53666903D266AA920B8C87")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentState(Fragment frag) {
        dsTaint.addTaint(frag.dsTaint);
        mClassName = frag.getClass().getName();
        mIndex = frag.mIndex;
        mFromLayout = frag.mFromLayout;
        mFragmentId = frag.mFragmentId;
        mContainerId = frag.mContainerId;
        mTag = frag.mTag;
        mRetainInstance = frag.mRetainInstance;
        mDetached = frag.mDetached;
        mArguments = frag.mArguments;
        // ---------- Original Method ----------
        //mClassName = frag.getClass().getName();
        //mIndex = frag.mIndex;
        //mFromLayout = frag.mFromLayout;
        //mFragmentId = frag.mFragmentId;
        //mContainerId = frag.mContainerId;
        //mTag = frag.mTag;
        //mRetainInstance = frag.mRetainInstance;
        //mDetached = frag.mDetached;
        //mArguments = frag.mArguments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.491 -0400", hash_original_method = "46F838C8877526D395D980C698E03728", hash_generated_method = "99D1F2CFE291B47C3FF0FC71E68C5FF0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentState(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mClassName = in.readString();
        mIndex = in.readInt();
        mFromLayout = in.readInt() != 0;
        mFragmentId = in.readInt();
        mContainerId = in.readInt();
        mTag = in.readString();
        mRetainInstance = in.readInt() != 0;
        mDetached = in.readInt() != 0;
        mArguments = in.readBundle();
        mSavedFragmentState = in.readBundle();
        // ---------- Original Method ----------
        //mClassName = in.readString();
        //mIndex = in.readInt();
        //mFromLayout = in.readInt() != 0;
        //mFragmentId = in.readInt();
        //mContainerId = in.readInt();
        //mTag = in.readString();
        //mRetainInstance = in.readInt() != 0;
        //mDetached = in.readInt() != 0;
        //mArguments = in.readBundle();
        //mSavedFragmentState = in.readBundle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.492 -0400", hash_original_method = "64945B874E9F798BEAFB62D4A4B63532", hash_generated_method = "AF3239DB4B260F3638B124A60F565A48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Fragment instantiate(Activity activity) {
        dsTaint.addTaint(activity.dsTaint);
        {
            mArguments.setClassLoader(activity.getClassLoader());
        } //End block
        mInstance = Fragment.instantiate(activity, mClassName, mArguments);
        {
            mSavedFragmentState.setClassLoader(activity.getClassLoader());
            mInstance.mSavedFragmentState = mSavedFragmentState;
        } //End block
        mInstance.setIndex(mIndex);
        mInstance.mFromLayout = mFromLayout;
        mInstance.mRestored = true;
        mInstance.mFragmentId = mFragmentId;
        mInstance.mContainerId = mContainerId;
        mInstance.mTag = mTag;
        mInstance.mRetainInstance = mRetainInstance;
        mInstance.mDetached = mDetached;
        mInstance.mFragmentManager = activity.mFragments;
        return (Fragment)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.493 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.496 -0400", hash_original_method = "5938F2E0A344A05A5347D3909CB444C6", hash_generated_method = "A8A341BC5AEE1E45318D48D1507A9056")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(mClassName);
        dest.writeInt(mIndex);
        dest.writeInt(mFromLayout ? 1 : 0);
        dest.writeInt(mFragmentId);
        dest.writeInt(mContainerId);
        dest.writeString(mTag);
        dest.writeInt(mRetainInstance ? 1 : 0);
        dest.writeInt(mDetached ? 1 : 0);
        dest.writeBundle(mArguments);
        dest.writeBundle(mSavedFragmentState);
        // ---------- Original Method ----------
        //dest.writeString(mClassName);
        //dest.writeInt(mIndex);
        //dest.writeInt(mFromLayout ? 1 : 0);
        //dest.writeInt(mFragmentId);
        //dest.writeInt(mContainerId);
        //dest.writeString(mTag);
        //dest.writeInt(mRetainInstance ? 1 : 0);
        //dest.writeInt(mDetached ? 1 : 0);
        //dest.writeBundle(mArguments);
        //dest.writeBundle(mSavedFragmentState);
    }

    
    public static final Parcelable.Creator<FragmentState> CREATOR = new Parcelable.Creator<FragmentState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.497 -0400", hash_original_method = "EC1ACE39B0D42EA269A848888E85A00F", hash_generated_method = "893F94D60C14D01E08F37262F23D5844")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FragmentState createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            FragmentState var290A431D1F1C6F5D98E5D3F71E3773C6_91468787 = (new FragmentState(in));
            return (FragmentState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new FragmentState(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.497 -0400", hash_original_method = "DC4AEAFBDB4D71B532904C285EBC6967", hash_generated_method = "702F131660E7F0B12607C031DAD1570B")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public FragmentState[] newArray(int size) {
            dsTaint.addTaint(size);
            FragmentState[] var6B55318C71B61EEE3BEED102EFF6C061_1048521926 = (new FragmentState[size]);
            return (FragmentState[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new FragmentState[size];
        }

        
}; //Transformed anonymous class
}

public class Fragment implements ComponentCallbacks2, OnCreateContextMenuListener {
    int mState = INITIALIZING;
    Animator mAnimatingAway;
    int mStateAfterAnimating;
    Bundle mSavedFragmentState;
    SparseArray<Parcelable> mSavedViewState;
    int mIndex = -1;
    String mWho;
    Bundle mArguments;
    Fragment mTarget;
    int mTargetIndex = -1;
    int mTargetRequestCode;
    boolean mAdded;
    boolean mRemoving;
    boolean mResumed;
    boolean mFromLayout;
    boolean mInLayout;
    boolean mRestored;
    int mBackStackNesting;
    FragmentManagerImpl mFragmentManager;
    Activity mActivity;
    int mFragmentId;
    int mContainerId;
    String mTag;
    boolean mHidden;
    boolean mDetached;
    boolean mRetainInstance;
    boolean mRetaining;
    boolean mHasMenu;
    boolean mMenuVisible = true;
    boolean mCalled;
    int mNextAnim;
    ViewGroup mContainer;
    View mView;
    boolean mDeferStart;
    boolean mUserVisibleHint = true;
    LoaderManagerImpl mLoaderManager;
    boolean mLoadersStarted;
    boolean mCheckedForLoaderManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.498 -0400", hash_original_method = "450DCF9C44ABD4359E904BF858920888", hash_generated_method = "AF7EF93C180462CAFE5DFDA53E9C7DDF")
    @DSModeled(DSC.SAFE)
    public Fragment() {
        // ---------- Original Method ----------
    }

    
        public static Fragment instantiate(Context context, String fname) {
        return instantiate(context, fname, null);
    }

    
        public static Fragment instantiate(Context context, String fname, Bundle args) {
        try {
            Class<?> clazz = sClassMap.get(fname);
            if (clazz == null) {
                clazz = context.getClassLoader().loadClass(fname);
                sClassMap.put(fname, clazz);
            }
            Fragment f = (Fragment)clazz.newInstance();
            if (args != null) {
                args.setClassLoader(f.getClass().getClassLoader());
                f.mArguments = args;
            }
            return f;
        } catch (ClassNotFoundException e) {
            throw new InstantiationException("Unable to instantiate fragment " + fname
                    + ": make sure class name exists, is public, and has an"
                    + " empty constructor that is public", e);
        } catch (java.lang.InstantiationException e) {
            throw new InstantiationException("Unable to instantiate fragment " + fname
                    + ": make sure class name exists, is public, and has an"
                    + " empty constructor that is public", e);
        } catch (IllegalAccessException e) {
            throw new InstantiationException("Unable to instantiate fragment " + fname
                    + ": make sure class name exists, is public, and has an"
                    + " empty constructor that is public", e);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.499 -0400", hash_original_method = "7271436905E3847D6FDF6326194EF06D", hash_generated_method = "19CFFFB0A4498FD7457EEE7F55EF953A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void restoreViewState() {
        {
            mView.restoreHierarchyState(mSavedViewState);
            mSavedViewState = null;
        } //End block
        // ---------- Original Method ----------
        //if (mSavedViewState != null) {
            //mView.restoreHierarchyState(mSavedViewState);
            //mSavedViewState = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.499 -0400", hash_original_method = "681200A239FE58A0DC09757C2C18A7DD", hash_generated_method = "65C86313DAC3AFA15A8C3171FB93A90C")
    @DSModeled(DSC.SAFE)
    final void setIndex(int index) {
        dsTaint.addTaint(index);
        mWho = "android:fragment:" + mIndex;
        // ---------- Original Method ----------
        //mIndex = index;
        //mWho = "android:fragment:" + mIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.500 -0400", hash_original_method = "B0D28796550366EF842F99A3D9D59C11", hash_generated_method = "1D2ED40D7A155D98A509C218696B1DC3")
    @DSModeled(DSC.SAFE)
    final boolean isInBackStack() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mBackStackNesting > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.500 -0400", hash_original_method = "055C1CABEC6B90DB231CF8138F07B9C1", hash_generated_method = "921293ECF38A5AEED855670F18050AFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    final public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        boolean var3B9F582BFED1483DB479DB197565FAB5_645483737 = (super.equals(o));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return super.equals(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.500 -0400", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "25BE5C4B285D49CE584C264E09D84DE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    final public int hashCode() {
        int varC489EB7FF487A920847CC016ED55AE09_1925041340 = (super.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return super.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.501 -0400", hash_original_method = "5350708001683FB5244A4F612B80A27C", hash_generated_method = "089756B168AFBB175BCD3349E1269B3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        {
            sb.append(" #");
            sb.append(mIndex);
        } //End block
        {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(mFragmentId));
        } //End block
        {
            sb.append(" ");
            sb.append(mTag);
        } //End block
        sb.append('}');
        String var806458D832AB974D230FEE4CBBDBD390_2099681091 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(128);
        //DebugUtils.buildShortClassTag(this, sb);
        //if (mIndex >= 0) {
            //sb.append(" #");
            //sb.append(mIndex);
        //}
        //if (mFragmentId != 0) {
            //sb.append(" id=0x");
            //sb.append(Integer.toHexString(mFragmentId));
        //}
        //if (mTag != null) {
            //sb.append(" ");
            //sb.append(mTag);
        //}
        //sb.append('}');
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.501 -0400", hash_original_method = "0D814DEC27C2F0AC661487D8C7B38979", hash_generated_method = "06AE31368E488A2BC9035D9D05B0DC07")
    @DSModeled(DSC.SAFE)
    final public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mFragmentId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.502 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "8852AAC7EF421F1C7B1826F33951AF5A")
    @DSModeled(DSC.SAFE)
    final public String getTag() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.502 -0400", hash_original_method = "2D5CF4DC8DE7FCC73C8073BFA7412800", hash_generated_method = "6C46AF66644B87BA7A095D3590F39D02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setArguments(Bundle args) {
        dsTaint.addTaint(args.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment already active");
        } //End block
        // ---------- Original Method ----------
        //if (mIndex >= 0) {
            //throw new IllegalStateException("Fragment already active");
        //}
        //mArguments = args;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.502 -0400", hash_original_method = "AD916C2ECBF1A5C9327A86449330505D", hash_generated_method = "456AB0785E42FAEF0E6FDEE7BB4482D1")
    @DSModeled(DSC.SAFE)
    final public Bundle getArguments() {
        return (Bundle)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mArguments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.503 -0400", hash_original_method = "D968C46759760C7406AC68A668D9806D", hash_generated_method = "1DD0C42D451C96A1CFE53B83310A645A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setInitialSavedState(SavedState state) {
        dsTaint.addTaint(state.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment already active");
        } //End block
        mSavedFragmentState = state != null && state.mState != null
                ? state.mState : null;
        // ---------- Original Method ----------
        //if (mIndex >= 0) {
            //throw new IllegalStateException("Fragment already active");
        //}
        //mSavedFragmentState = state != null && state.mState != null
                //? state.mState : null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.503 -0400", hash_original_method = "1E1EC1C5F204666846AC7A8EC55494F6", hash_generated_method = "B4AC97CACFECFDBF91DBF6AFDD173692")
    @DSModeled(DSC.SAFE)
    public void setTargetFragment(Fragment fragment, int requestCode) {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(fragment.dsTaint);
        // ---------- Original Method ----------
        //mTarget = fragment;
        //mTargetRequestCode = requestCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.507 -0400", hash_original_method = "CBC4FCF13CA2895C8D01438D1D6F6EE8", hash_generated_method = "5BA5A3977C5312BBB07AEBBD8BC83934")
    @DSModeled(DSC.SAFE)
    final public Fragment getTargetFragment() {
        return (Fragment)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.508 -0400", hash_original_method = "A4CEFC2C477EE57B614F4504E74127CE", hash_generated_method = "92CB0DA583C374A0C7A473D3F49AE18D")
    @DSModeled(DSC.SAFE)
    final public int getTargetRequestCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTargetRequestCode;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.508 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "347C833EBE25F418FD2C31EE61C59A7F")
    @DSModeled(DSC.SAFE)
    final public Activity getActivity() {
        return (Activity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.509 -0400", hash_original_method = "A8E18DB36BC334E1CF5901C727187C18", hash_generated_method = "3FC986C829F7A5CCB08F5B71C6A2004A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final public Resources getResources() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } //End block
        Resources var975FCF79BE91AE7E8BD8EEE0B9743B13_467733190 = (mActivity.getResources());
        return (Resources)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //return mActivity.getResources();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.509 -0400", hash_original_method = "3F649A13E84C6501035126B3FEE231F4", hash_generated_method = "A630792915E0A8FC2659FE9AC28FEFFF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final CharSequence getText(int resId) {
        dsTaint.addTaint(resId);
        CharSequence varCE77F3EBEEF8ECEB4093243855E180E5_841295959 = (getResources().getText(resId));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getResources().getText(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.510 -0400", hash_original_method = "6096F9B7D678CAFA7D67C1784ABCB9A7", hash_generated_method = "ED9A0A31382F5868B94DF532A668D0B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getString(int resId) {
        dsTaint.addTaint(resId);
        String var4D971E738462AED5F8C202AA44008DD1_451460828 = (getResources().getString(resId));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getResources().getString(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.510 -0400", hash_original_method = "524F00C5C13CBD3BD0D5C512A4C12294", hash_generated_method = "D6AC462081DCBEB73FCB9A208D6EB47A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String getString(int resId, Object... formatArgs) {
        dsTaint.addTaint(resId);
        dsTaint.addTaint(formatArgs[0].dsTaint);
        String var3D9BFC044EEC4D309825E04863344990_386660165 = (getResources().getString(resId, formatArgs));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getResources().getString(resId, formatArgs);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.510 -0400", hash_original_method = "ED1BD18F392C2062694622C1FF4A3A44", hash_generated_method = "DBBF688FEE4B84DE6F80D03A9445A4B8")
    @DSModeled(DSC.SAFE)
    final public FragmentManager getFragmentManager() {
        return (FragmentManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mFragmentManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.511 -0400", hash_original_method = "C0D74F5DDFD9A01C19E54F3379BA7652", hash_generated_method = "5F50806B3B012CD107D07A8A8FD142F6")
    @DSModeled(DSC.SAFE)
    final public boolean isAdded() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mActivity != null && mAdded;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.511 -0400", hash_original_method = "2F8509F8C4A8638224A8FC9748BC6275", hash_generated_method = "8EAFC0A4C335AD4C9CA181E401DAAA1F")
    @DSModeled(DSC.SAFE)
    final public boolean isDetached() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mDetached;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.511 -0400", hash_original_method = "914BD43FF0612F84BA345FA6F486595C", hash_generated_method = "D59106516FDDA9A7097233DB979F6A65")
    @DSModeled(DSC.SAFE)
    final public boolean isRemoving() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRemoving;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.512 -0400", hash_original_method = "3C6E7329283D3C6C46FB3F90EF65A4A7", hash_generated_method = "128250FA7C346A1C8ABFD39B7347A96B")
    @DSModeled(DSC.SAFE)
    final public boolean isInLayout() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mInLayout;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.512 -0400", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "0BBCFB71B3D5DA83BDD697A6AC1C48E6")
    @DSModeled(DSC.SAFE)
    final public boolean isResumed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mResumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.512 -0400", hash_original_method = "72982976B71B01DF2412198462460DF0", hash_generated_method = "2AA4EC95BAD78EC35C2EDD0A69A6C7A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final public boolean isVisible() {
        boolean var643645FADE5E75870E219C4E3A66DBAE_705468001 = (isAdded() && !isHidden() && mView != null
                && mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isAdded() && !isHidden() && mView != null
                //&& mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.513 -0400", hash_original_method = "E04FD968639295CCE5F791161EDE4496", hash_generated_method = "6ED9B43F551FE5DF6828ED8606459F02")
    @DSModeled(DSC.SAFE)
    final public boolean isHidden() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mHidden;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.513 -0400", hash_original_method = "FE8A5DF015D2662392185902D9D0AEDD", hash_generated_method = "84FC971C1D74E171DBEC5C058EDB228A")
    @DSModeled(DSC.SAFE)
    public void onHiddenChanged(boolean hidden) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(hidden);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.514 -0400", hash_original_method = "8E671A431463BFA7D0F399C37FBCF1E9", hash_generated_method = "74C443E4B542994D9E657BC37CD67DDD")
    @DSModeled(DSC.SAFE)
    public void setRetainInstance(boolean retain) {
        dsTaint.addTaint(retain);
        // ---------- Original Method ----------
        //mRetainInstance = retain;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.514 -0400", hash_original_method = "82A17104D5864E2285E97283523AA6C5", hash_generated_method = "0C744064D23612E9908A432B42AD64B2")
    @DSModeled(DSC.SAFE)
    final public boolean getRetainInstance() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mRetainInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.514 -0400", hash_original_method = "A6D768E437C7421B050650CBF4A7B137", hash_generated_method = "C3103561091A5524E9A282C724B8D46F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setHasOptionsMenu(boolean hasMenu) {
        dsTaint.addTaint(hasMenu);
        {
            {
                boolean var6410BF1E9EE91D719771624EE688382C_345106605 = (isAdded() && !isHidden());
                {
                    mFragmentManager.invalidateOptionsMenu();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mHasMenu != hasMenu) {
            //mHasMenu = hasMenu;
            //if (isAdded() && !isHidden()) {
                //mFragmentManager.invalidateOptionsMenu();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.515 -0400", hash_original_method = "2CD00B5529D6A4CD9554A0275473942E", hash_generated_method = "3F448EB825501E85488E5FA8BB41A4DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMenuVisibility(boolean menuVisible) {
        dsTaint.addTaint(menuVisible);
        {
            {
                boolean var63EEDD19FAB3C7E50D3EC385E85195BC_48732297 = (mHasMenu && isAdded() && !isHidden());
                {
                    mFragmentManager.invalidateOptionsMenu();
                } //End block
            } //End collapsed parenthetic
        } //End block
        // ---------- Original Method ----------
        //if (mMenuVisible != menuVisible) {
            //mMenuVisible = menuVisible;
            //if (mHasMenu && isAdded() && !isHidden()) {
                //mFragmentManager.invalidateOptionsMenu();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.517 -0400", hash_original_method = "1B0128696FF26E02ABF181CBEC60E7DF", hash_generated_method = "2532E4CBEDA2A82CB0941C29F2562144")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setUserVisibleHint(boolean isVisibleToUser) {
        dsTaint.addTaint(isVisibleToUser);
        {
            mFragmentManager.performPendingDeferredStart(this);
        } //End block
        mDeferStart = !isVisibleToUser;
        // ---------- Original Method ----------
        //if (!mUserVisibleHint && isVisibleToUser && mState < STARTED) {
            //mFragmentManager.performPendingDeferredStart(this);
        //}
        //mUserVisibleHint = isVisibleToUser;
        //mDeferStart = !isVisibleToUser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.518 -0400", hash_original_method = "16570E728AF342CDACA5E18099682804", hash_generated_method = "C515E8C9E02313264D052E5B9ABF17D9")
    @DSModeled(DSC.SAFE)
    public boolean getUserVisibleHint() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mUserVisibleHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.530 -0400", hash_original_method = "71C5851113530E9E497DE6FFC60D128C", hash_generated_method = "C5BEE63C99B155207B44F12DBA37413D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LoaderManager getLoaderManager() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } //End block
        mCheckedForLoaderManager = true;
        mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, true);
        return (LoaderManager)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mLoaderManager != null) {
            //return mLoaderManager;
        //}
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //mCheckedForLoaderManager = true;
        //mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, true);
        //return mLoaderManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.531 -0400", hash_original_method = "B68B30EDC5AB3BE8EF657FB7051C7F7E", hash_generated_method = "7250552C8A3FD41F484397CD6C1D3403")
    @DSModeled(DSC.SPEC)
    public void startActivity(Intent intent) {
        dsTaint.addTaint(intent.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } //End block
        mActivity.startActivityFromFragment(this, intent, -1);
        // ---------- Original Method ----------
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //mActivity.startActivityFromFragment(this, intent, -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.532 -0400", hash_original_method = "849399EB62F8B6EE6A6E550D7989B87C", hash_generated_method = "4E91B99ADDFD685509BBB2426CD31FB4")
    @DSModeled(DSC.SPEC)
    public void startActivityForResult(Intent intent, int requestCode) {
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(intent.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } //End block
        mActivity.startActivityFromFragment(this, intent, requestCode);
        // ---------- Original Method ----------
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //mActivity.startActivityFromFragment(this, intent, requestCode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.533 -0400", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "86C10DC4483E032FA950B31274D50CA3")
    @DSModeled(DSC.SPEC)
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(requestCode);
        dsTaint.addTaint(data.dsTaint);
        dsTaint.addTaint(resultCode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.533 -0400", hash_original_method = "8FF008E86C71DF2CF57F1B9E3E9D8CD9", hash_generated_method = "0EBFFA793944B2D1F0385AE37C921F45")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        dsTaint.addTaint(savedInstanceState.dsTaint);
        LayoutInflater var4F060911320349AB090D6E7BAD0B48E0_538543897 = (mActivity.getLayoutInflater());
        return (LayoutInflater)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mActivity.getLayoutInflater();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.537 -0400", hash_original_method = "B81B691062FF851E8B34D981FF83329F", hash_generated_method = "FC42102672BF3235DF691FE96E7B6F27")
    @DSModeled(DSC.SAFE)
    @Deprecated
    public void onInflate(AttributeSet attrs, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(savedInstanceState.dsTaint);
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.538 -0400", hash_original_method = "295D90877B0CE50D1EC7F89F1D4EC254", hash_generated_method = "6EF017C0864FF02757DB619B3E8FFAF6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(attrs.dsTaint);
        dsTaint.addTaint(savedInstanceState.dsTaint);
        dsTaint.addTaint(activity.dsTaint);
        onInflate(attrs, savedInstanceState);
        mCalled = true;
        // ---------- Original Method ----------
        //onInflate(attrs, savedInstanceState);
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.538 -0400", hash_original_method = "7FCB8118913FF635CB1CDE717E61023E", hash_generated_method = "3C060EC620B24CF38A7C228DD6D7D1DC")
    @DSModeled(DSC.SAFE)
    public void onAttach(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(activity.dsTaint);
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.539 -0400", hash_original_method = "EB97CF4ACDD4FD35B8071D1AF529F576", hash_generated_method = "19FC9E529FB5306FA6A253D64EF0AFD1")
    @DSModeled(DSC.SAFE)
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(nextAnim);
        dsTaint.addTaint(enter);
        dsTaint.addTaint(transit);
        return (Animator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.539 -0400", hash_original_method = "00494AECA41C1730DF6E82548FC2C3D5", hash_generated_method = "B7753F69F6A48755D9EC4E288835886F")
    @DSModeled(DSC.SAFE)
    public void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.539 -0400", hash_original_method = "F4318A499F9B06ABC9CCF0644AE6DC10", hash_generated_method = "E0DF937F8D0934047295251327715138")
    @DSModeled(DSC.SAFE)
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(view.dsTaint);
        dsTaint.addTaint(savedInstanceState.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.540 -0400", hash_original_method = "57C338AB393ED440CE12C76B2627A085", hash_generated_method = "A277EAAB02EB7D8CAAEDAE9EA2158046")
    @DSModeled(DSC.SAFE)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(container.dsTaint);
        dsTaint.addTaint(inflater.dsTaint);
        dsTaint.addTaint(savedInstanceState.dsTaint);
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.540 -0400", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "EF56CAABAD12D60EAF99B804892CE0F3")
    @DSModeled(DSC.SAFE)
    public View getView() {
        return (View)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mView;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.540 -0400", hash_original_method = "C52625884C98429BE8DE42F4FBFE7367", hash_generated_method = "9DFE234ECA532E74613A605511E76E34")
    @DSModeled(DSC.SAFE)
    public void onActivityCreated(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(savedInstanceState.dsTaint);
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.541 -0400", hash_original_method = "4BDF3B44AFE0C3B519B659689A5EE977", hash_generated_method = "82BBEA71FE07BC526918356C3508B55F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        {
            mLoadersStarted = true;
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            } //End block
            {
                mLoaderManager.doStart();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //mCalled = true;
        //if (!mLoadersStarted) {
            //mLoadersStarted = true;
            //if (!mCheckedForLoaderManager) {
                //mCheckedForLoaderManager = true;
                //mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            //}
            //if (mLoaderManager != null) {
                //mLoaderManager.doStart();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.541 -0400", hash_original_method = "3B8608ED59C2663D271D57F8D8F534C0", hash_generated_method = "A35C9648644440B1AB73336CCB6DEAB5")
    @DSModeled(DSC.SAFE)
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.542 -0400", hash_original_method = "9C4F98F3F5A4FCEFF66E261EDA5693F3", hash_generated_method = "530F7D5099A6872DDA04C5DF7610FB31")
    @DSModeled(DSC.SAFE)
    public void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(outState.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.542 -0400", hash_original_method = "16A05561D5415124B893EA7E2AFB953D", hash_generated_method = "0A37DE472E63AD7798A6AA27ECB1B183")
    @DSModeled(DSC.SAFE)
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(newConfig.dsTaint);
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.542 -0400", hash_original_method = "CEF2FF1DA31E7EE9D761807A037B37B2", hash_generated_method = "637684B70754E8D79E076DC6A513E031")
    @DSModeled(DSC.SAFE)
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.543 -0400", hash_original_method = "FC062A9ECA017F6E5D455E8C973942F9", hash_generated_method = "7E26AAA6FA11DEDE75C340853A5FC7A3")
    @DSModeled(DSC.SAFE)
    public void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.543 -0400", hash_original_method = "28328842E1AEC7ECF313405184622A29", hash_generated_method = "A607A7A5A4E7888F4F9DD46B7BE5C1AF")
    @DSModeled(DSC.SAFE)
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.543 -0400", hash_original_method = "E1E8CF8B1FBB3E8165C3219A9D0BB675", hash_generated_method = "484048BFA632A5CA0BA59F2E445656A1")
    @DSModeled(DSC.SAFE)
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(level);
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.544 -0400", hash_original_method = "E54F17C7BAFD082A48D2152349C1815A", hash_generated_method = "D6DBBF3121DDE73B3DDC3BCBF558AE8E")
    @DSModeled(DSC.SAFE)
    public void onDestroyView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.545 -0400", hash_original_method = "AA4E137E24C2C382652C9FBA94B1ED31", hash_generated_method = "48CA08A8C2091A4D6902AC10492213F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
        } //End block
        {
            mLoaderManager.doDestroy();
        } //End block
        // ---------- Original Method ----------
        //mCalled = true;
        //if (!mCheckedForLoaderManager) {
            //mCheckedForLoaderManager = true;
            //mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
        //}
        //if (mLoaderManager != null) {
            //mLoaderManager.doDestroy();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.545 -0400", hash_original_method = "04633BF5293F80973E1AA355DB2C35EF", hash_generated_method = "4C027456133F87915A9EF12926708CE0")
    @DSModeled(DSC.SAFE)
     void initState() {
        mIndex = -1;
        mWho = null;
        mAdded = false;
        mRemoving = false;
        mResumed = false;
        mFromLayout = false;
        mInLayout = false;
        mRestored = false;
        mBackStackNesting = 0;
        mFragmentManager = null;
        mActivity = null;
        mFragmentId = 0;
        mContainerId = 0;
        mTag = null;
        mHidden = false;
        mDetached = false;
        mRetaining = false;
        mLoaderManager = null;
        mLoadersStarted = false;
        mCheckedForLoaderManager = false;
        // ---------- Original Method ----------
        //mIndex = -1;
        //mWho = null;
        //mAdded = false;
        //mRemoving = false;
        //mResumed = false;
        //mFromLayout = false;
        //mInLayout = false;
        //mRestored = false;
        //mBackStackNesting = 0;
        //mFragmentManager = null;
        //mActivity = null;
        //mFragmentId = 0;
        //mContainerId = 0;
        //mTag = null;
        //mHidden = false;
        //mDetached = false;
        //mRetaining = false;
        //mLoaderManager = null;
        //mLoadersStarted = false;
        //mCheckedForLoaderManager = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.546 -0400", hash_original_method = "EF609D2FD1394DFBC19807CB21AD7D10", hash_generated_method = "CD3AD86EF54BB27DA72F7E9F9B9DEA15")
    @DSModeled(DSC.SAFE)
    public void onDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.546 -0400", hash_original_method = "B3C5F3D019B47C47E6111F1C7C38CA5D", hash_generated_method = "B529088345B2C8118133C8E4E5538CD8")
    @DSModeled(DSC.SAFE)
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        dsTaint.addTaint(inflater.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.547 -0400", hash_original_method = "4CE703F4C1FA6FC474411DFE6A3F5275", hash_generated_method = "9FA04F9896E9854E6AC320861076D195")
    @DSModeled(DSC.SAFE)
    public void onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.547 -0400", hash_original_method = "0E8C037F224061747BFFD0611606AAB6", hash_generated_method = "EF044D3D33EBB476DBBCFB32576782C1")
    @DSModeled(DSC.SAFE)
    public void onDestroyOptionsMenu() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.548 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "6814944D3BF2F9192DA171F02183EF45")
    @DSModeled(DSC.SAFE)
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.548 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "3A76DA4E8EF6038718A7FF2EBAFB77BD")
    @DSModeled(DSC.SAFE)
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(menu.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.548 -0400", hash_original_method = "68082EA0714CB57B78AC95D3FF2A7AC8", hash_generated_method = "C5B0B9338C34DD5DD336445BFAFF45DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(v.dsTaint);
        dsTaint.addTaint(menuInfo.dsTaint);
        dsTaint.addTaint(menu.dsTaint);
        getActivity().onCreateContextMenu(menu, v, menuInfo);
        // ---------- Original Method ----------
        //getActivity().onCreateContextMenu(menu, v, menuInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.549 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "9303A120679EFDCECFF0557014C3F44C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        dsTaint.addTaint(view.dsTaint);
        view.setOnCreateContextMenuListener(this);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.550 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "B4C81DA9CA6119CB0B2BC57EF94EC72A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void unregisterForContextMenu(View view) {
        dsTaint.addTaint(view.dsTaint);
        view.setOnCreateContextMenuListener(null);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.550 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "FAAE04AB5046596C0BC4461D258162EB")
    @DSModeled(DSC.SAFE)
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        dsTaint.addTaint(item.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.562 -0400", hash_original_method = "C78D4ECAA9BAFBCD9E78657D4224F582", hash_generated_method = "3ADAA9A2A5B655479E6AEA0E09C8B0E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(writer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        writer.print(prefix);
        writer.print("mFragmentId=#");
        writer.print(Integer.toHexString(mFragmentId));
        writer.print(" mContainerId#=");
        writer.print(Integer.toHexString(mContainerId));
        writer.print(" mTag=");
        writer.println(mTag);
        writer.print(prefix);
        writer.print("mState=");
        writer.print(mState);
        writer.print(" mIndex=");
        writer.print(mIndex);
        writer.print(" mWho=");
        writer.print(mWho);
        writer.print(" mBackStackNesting=");
        writer.println(mBackStackNesting);
        writer.print(prefix);
        writer.print("mAdded=");
        writer.print(mAdded);
        writer.print(" mRemoving=");
        writer.print(mRemoving);
        writer.print(" mResumed=");
        writer.print(mResumed);
        writer.print(" mFromLayout=");
        writer.print(mFromLayout);
        writer.print(" mInLayout=");
        writer.println(mInLayout);
        writer.print(prefix);
        writer.print("mHidden=");
        writer.print(mHidden);
        writer.print(" mDetached=");
        writer.print(mDetached);
        writer.print(" mMenuVisible=");
        writer.print(mMenuVisible);
        writer.print(" mHasMenu=");
        writer.println(mHasMenu);
        writer.print(prefix);
        writer.print("mRetainInstance=");
        writer.print(mRetainInstance);
        writer.print(" mRetaining=");
        writer.print(mRetaining);
        writer.print(" mUserVisibleHint=");
        writer.println(mUserVisibleHint);
        {
            writer.print(prefix);
            writer.print("mFragmentManager=");
            writer.println(mFragmentManager);
        } //End block
        {
            writer.print(prefix);
            writer.print("mActivity=");
            writer.println(mActivity);
        } //End block
        {
            writer.print(prefix);
            writer.print("mArguments=");
            writer.println(mArguments);
        } //End block
        {
            writer.print(prefix);
            writer.print("mSavedFragmentState=");
            writer.println(mSavedFragmentState);
        } //End block
        {
            writer.print(prefix);
            writer.print("mSavedViewState=");
            writer.println(mSavedViewState);
        } //End block
        {
            writer.print(prefix);
            writer.print("mTarget=");
            writer.print(mTarget);
            writer.print(" mTargetRequestCode=");
            writer.println(mTargetRequestCode);
        } //End block
        {
            writer.print(prefix);
            writer.print("mNextAnim=");
            writer.println(mNextAnim);
        } //End block
        {
            writer.print(prefix);
            writer.print("mContainer=");
            writer.println(mContainer);
        } //End block
        {
            writer.print(prefix);
            writer.print("mView=");
            writer.println(mView);
        } //End block
        {
            writer.print(prefix);
            writer.print("mAnimatingAway=");
            writer.println(mAnimatingAway);
            writer.print(prefix);
            writer.print("mStateAfterAnimating=");
            writer.println(mStateAfterAnimating);
        } //End block
        {
            writer.print(prefix);
            writer.println("Loader Manager:");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.563 -0400", hash_original_method = "A194798DFC3B633DD6139CF302E65474", hash_generated_method = "C7D46B9A2E02F09936071460030005C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void performStart() {
        onStart();
        {
            mLoaderManager.doReportStart();
        } //End block
        // ---------- Original Method ----------
        //onStart();
        //if (mLoaderManager != null) {
            //mLoaderManager.doReportStart();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.564 -0400", hash_original_method = "DF7E450C96FF033A1F96B7AC1D56EC13", hash_generated_method = "4F7CA6019DB5663F248E69C84C2C6777")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void performStop() {
        onStop();
        {
            mLoadersStarted = false;
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            } //End block
            {
                {
                    mLoaderManager.doStop();
                } //End block
                {
                    mLoaderManager.doRetain();
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //onStop();
        //if (mLoadersStarted) {
            //mLoadersStarted = false;
            //if (!mCheckedForLoaderManager) {
                //mCheckedForLoaderManager = true;
                //mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            //}
            //if (mLoaderManager != null) {
                //if (mActivity == null || !mActivity.mChangingConfigurations) {
                    //mLoaderManager.doStop();
                //} else {
                    //mLoaderManager.doRetain();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.564 -0400", hash_original_method = "3EF3D6E87A549E78C03CB36A1B3A62F5", hash_generated_method = "8A65612313EFDA11D182CED36DAAE8D0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void performDestroyView() {
        onDestroyView();
        {
            mLoaderManager.doReportNextStart();
        } //End block
        // ---------- Original Method ----------
        //onDestroyView();
        //if (mLoaderManager != null) {
            //mLoaderManager.doReportNextStart();
        //}
    }

    
    public static class SavedState implements Parcelable {
        Bundle mState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.565 -0400", hash_original_method = "7D4CB1BC3C04B99DC21EA19CB6BAF4D3", hash_generated_method = "3865CC3B18A7E5918EE5CF38662C0518")
        @DSModeled(DSC.SAFE)
         SavedState(Bundle state) {
            dsTaint.addTaint(state.dsTaint);
            // ---------- Original Method ----------
            //mState = state;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.565 -0400", hash_original_method = "E611F4C5C5E159704631D93ABD994DEF", hash_generated_method = "B4C97472E0C8016DA6896F19EB7A9698")
        @DSModeled(DSC.BAN)
         SavedState(Parcel in, ClassLoader loader) {
            dsTaint.addTaint(loader.dsTaint);
            dsTaint.addTaint(in.dsTaint);
            mState = in.readBundle();
            {
                mState.setClassLoader(loader);
            } //End block
            // ---------- Original Method ----------
            //mState = in.readBundle();
            //if (loader != null && mState != null) {
                //mState.setClassLoader(loader);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.573 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
        @DSModeled(DSC.SAFE)
        @Override
        public int describeContents() {
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.577 -0400", hash_original_method = "ACF88B4EF312D321A4777388A96F3566", hash_generated_method = "4D4F45EDD803AE3E364FEB495B18BE35")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dsTaint.addTaint(flags);
            dsTaint.addTaint(dest.dsTaint);
            dest.writeBundle(mState);
            // ---------- Original Method ----------
            //dest.writeBundle(mState);
        }

        
        public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.580 -0400", hash_original_method = "F6A52F04C4D14500D0C1089F687B7F14", hash_generated_method = "4CE5F71DA824F277A37E8D2F7880D725")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState createFromParcel(Parcel in) {
                dsTaint.addTaint(in.dsTaint);
                SavedState varB445F24176D51FDABDF2EC6507F392BE_2052374365 = (new SavedState(in, null));
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in, null);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.587 -0400", hash_original_method = "827740B54B4D2FB6132FF4A14CAC20AA", hash_generated_method = "19FB0AD60CA23D70A7C09E6EA36D88DC")
            @DSModeled(DSC.BAN)
            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                dsTaint.addTaint(loader.dsTaint);
                dsTaint.addTaint(in.dsTaint);
                SavedState varD04AE4A6C281303A33A52DC044C7FA7F_418880110 = (new SavedState(in, loader));
                return (SavedState)dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState(in, loader);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.589 -0400", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "64C89001A9E541E9B0798DD183C29F84")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public SavedState[] newArray(int size) {
                dsTaint.addTaint(size);
                SavedState[] varB5C72E5BBB181D4CA93D7BAA0B8B5E3D_1447337662 = (new SavedState[size]);
                return (SavedState[])dsTaint.getTaint();
                // ---------- Original Method ----------
                //return new SavedState[size];
            }

            
}; //Transformed anonymous class
    }


    
    static public class InstantiationException extends AndroidRuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:37.591 -0400", hash_original_method = "9A59F9C8F177B5B07F720376B1CE8BCE", hash_generated_method = "AEE1224DCB3C337F161219D0C09F92A9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public InstantiationException(String msg, Exception cause) {
            super(msg, cause);
            dsTaint.addTaint(cause.dsTaint);
            dsTaint.addTaint(msg);
            // ---------- Original Method ----------
        }

        
    }


    
    private static final HashMap<String, Class<?>> sClassMap =
            new HashMap<String, Class<?>>();
    static final int INVALID_STATE = -1;
    static final int INITIALIZING = 0;
    static final int CREATED = 1;
    static final int ACTIVITY_CREATED = 2;
    static final int STOPPED = 3;
    static final int STARTED = 4;
    static final int RESUMED = 5;
}

