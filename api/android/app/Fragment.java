package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

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

final class FragmentState implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.581 -0400", hash_original_field = "20C24B13B86A2BA0167AA1764B64C330", hash_generated_field = "33682AAE42971F2215D5844A73451D2E")

    public static final Parcelable.Creator<FragmentState> CREATOR
            = new Parcelable.Creator<FragmentState>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.863 -0500", hash_original_method = "EC1ACE39B0D42EA269A848888E85A00F", hash_generated_method = "A5A88BD3A75C773BD237E8D2C9040999")
        
public FragmentState createFromParcel(Parcel in) {
            return new FragmentState(in);
        }
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.865 -0500", hash_original_method = "DC4AEAFBDB4D71B532904C285EBC6967", hash_generated_method = "19DDBB5FA0E131DAFC47ACF67B190A1C")
        
public FragmentState[] newArray(int size) {
            return new FragmentState[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.827 -0500", hash_original_field = "6BC238A3BDD37BF1CAC26EA2CE45C508", hash_generated_field = "6BC238A3BDD37BF1CAC26EA2CE45C508")

     String mClassName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.829 -0500", hash_original_field = "3FE793BBC68255EAC5B3588E7DE2E2C6", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

     int mIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.831 -0500", hash_original_field = "D21475690426FA39A7733914F0F3A95D", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

     boolean mFromLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.833 -0500", hash_original_field = "C628DB5A0351ABB6B2BC170D76A5FF43", hash_generated_field = "C628DB5A0351ABB6B2BC170D76A5FF43")

     int mFragmentId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.835 -0500", hash_original_field = "2072CAADE2B3735D2B37FDBC10B7F08E", hash_generated_field = "2072CAADE2B3735D2B37FDBC10B7F08E")

     int mContainerId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.837 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

     String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.839 -0500", hash_original_field = "907988FDE235BE080FDDB6DB36EF9C83", hash_generated_field = "907988FDE235BE080FDDB6DB36EF9C83")

     boolean mRetainInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.841 -0500", hash_original_field = "F0A7088DB55E87649B19609F5563F724", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

     boolean mDetached;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.843 -0500", hash_original_field = "BC54B63AEA85D845C1AC338D041E1ED5", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

     Bundle mArguments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.845 -0500", hash_original_field = "F958FB3998EC484A7599A988303CD216", hash_generated_field = "F958FB3998EC484A7599A988303CD216")
    
    Bundle mSavedFragmentState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.847 -0500", hash_original_field = "F83F5A158F2251FA12452672DC97E470", hash_generated_field = "F83F5A158F2251FA12452672DC97E470")
    
    Fragment mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.849 -0500", hash_original_method = "116485142A61C36D4B47DBE9BCB45890", hash_generated_method = "E45EA0218D7229ECDEC5292C2E748720")
    
public FragmentState(Fragment frag) {
        mClassName = frag.getClass().getName();
        mIndex = frag.mIndex;
        mFromLayout = frag.mFromLayout;
        mFragmentId = frag.mFragmentId;
        mContainerId = frag.mContainerId;
        mTag = frag.mTag;
        mRetainInstance = frag.mRetainInstance;
        mDetached = frag.mDetached;
        mArguments = frag.mArguments;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.853 -0500", hash_original_method = "46F838C8877526D395D980C698E03728", hash_generated_method = "08AA5B05BF40AA835C75099724DE085A")
    
public FragmentState(Parcel in) {
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
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.856 -0500", hash_original_method = "64945B874E9F798BEAFB62D4A4B63532", hash_generated_method = "6D47462346272FCFF7417F236454DE6C")
    
public Fragment instantiate(Activity activity) {
        if (mInstance != null) {
            return mInstance;
        }
        
        if (mArguments != null) {
            mArguments.setClassLoader(activity.getClassLoader());
        }
        
        mInstance = Fragment.instantiate(activity, mClassName, mArguments);
        
        if (mSavedFragmentState != null) {
            mSavedFragmentState.setClassLoader(activity.getClassLoader());
            mInstance.mSavedFragmentState = mSavedFragmentState;
        }
        mInstance.setIndex(mIndex);
        mInstance.mFromLayout = mFromLayout;
        mInstance.mRestored = true;
        mInstance.mFragmentId = mFragmentId;
        mInstance.mContainerId = mContainerId;
        mInstance.mTag = mTag;
        mInstance.mRetainInstance = mRetainInstance;
        mInstance.mDetached = mDetached;
        mInstance.mFragmentManager = activity.mFragments;
        
        return mInstance;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.858 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.860 -0500", hash_original_method = "5938F2E0A344A05A5347D3909CB444C6", hash_generated_method = "32654305C88762212E962C0496C44257")
    
public void writeToParcel(Parcel dest, int flags) {
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
    }
}

public class Fragment implements ComponentCallbacks2, OnCreateContextMenuListener {

    /**
     * Like {@link #instantiate(Context, String, Bundle)} but with a null
     * argument Bundle.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.996 -0500", hash_original_method = "0190F1BB85D8CE10E66B5514A394ABC5", hash_generated_method = "70A477C537313AA7A65AA778A77FFE25")
    
public static Fragment instantiate(Context context, String fname) {
        return instantiate(context, fname, null);
    }

    /**
     * Create a new instance of a Fragment with the given class name.  This is
     * the same as calling its empty constructor.
     *
     * @param context The calling context being used to instantiate the fragment.
     * This is currently just used to get its ClassLoader.
     * @param fname The class name of the fragment to instantiate.
     * @param args Bundle of arguments to supply to the fragment, which it
     * can retrieve with {@link #getArguments()}.  May be null.
     * @return Returns a new fragment instance.
     * @throws InstantiationException If there is a failure in instantiating
     * the given fragment class.  This is a runtime exception; it is not
     * normally expected to happen.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.999 -0500", hash_original_method = "DD532F08670F8F66F3144923B381A393", hash_generated_method = "502B97B751650EA555BDAFC8D8187866")
    
public static Fragment instantiate(Context context, String fname, Bundle args) {
        try {
            Class<?> clazz = sClassMap.get(fname);
            if (clazz == null) {
                // Class not found in the cache, see if it's real, and try to add it
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.871 -0500", hash_original_field = "53537C5D8C0F0D03BCBC5F0370AF8F24", hash_generated_field = "EB0A976F34844AD55F975EEF50A2B1A3")

    private static final HashMap<String, Class<?>> sClassMap =
            new HashMap<String, Class<?>>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.873 -0500", hash_original_field = "8FE0BC9AD82F0D6D0DE354D67F1A890A", hash_generated_field = "5C75B850D43361B9311F957A4D0AF174")
    
    static final int INVALID_STATE = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.875 -0500", hash_original_field = "BE1EF333470B1511678F5EE23F102EFC", hash_generated_field = "B9FFABD80C3D80703D84376667A75609")

    static final int INITIALIZING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.877 -0500", hash_original_field = "38DE4403767C9147B0BB36A53E837FC6", hash_generated_field = "97B36236CFE06BD1C50B96E10CE241B6")

    static final int CREATED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.880 -0500", hash_original_field = "9DF93DAFCBB15F1E8D4C7AEA24094323", hash_generated_field = "00E5F9933DCF6CD0A60E606E52C7FADE")

    static final int ACTIVITY_CREATED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.882 -0500", hash_original_field = "3EC2EAB63FB2C4E67978E2C0E1B65641", hash_generated_field = "2CEA28884A245A0CE49FCF31D0D6588D")

    static final int STOPPED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.885 -0500", hash_original_field = "C57E9D5BB5FE6806EB8587DFB40D76EB", hash_generated_field = "4F033F865040D83003D856BED757C437")

    static final int STARTED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.887 -0500", hash_original_field = "BE855505318DDB712BE49C2554E86FB5", hash_generated_field = "562F93666D34FFE3A5D8899053C80C4E")

    static final int RESUMED = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.889 -0500", hash_original_field = "0294DD5CAC8ED58250DA531156A3A018", hash_generated_field = "0294DD5CAC8ED58250DA531156A3A018")
    
    int mState = INITIALIZING;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.891 -0500", hash_original_field = "ECF8328501B577B29900A98481ADA801", hash_generated_field = "F08045B4011996E9A13E0EBACB5D4153")

    // meaning we need to wait a bit on completely destroying it.  This is the
    // animation that is running.
    Animator mAnimatingAway;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.893 -0500", hash_original_field = "AA12B8E459D536EFC9893454A513D5AA", hash_generated_field = "FE834AA73FA208DF601CF57581ABDC58")

    // animation is done.
    int mStateAfterAnimating;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.895 -0500", hash_original_field = "F958FB3998EC484A7599A988303CD216", hash_generated_field = "F958FB3998EC484A7599A988303CD216")

    Bundle mSavedFragmentState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.897 -0500", hash_original_field = "03C65AC0399DBB932968B6C681CFC16A", hash_generated_field = "03C65AC0399DBB932968B6C681CFC16A")

    SparseArray<Parcelable> mSavedViewState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.898 -0500", hash_original_field = "6B9186F1D8E9AA88F21C8B70F0B9BCC7", hash_generated_field = "6B9186F1D8E9AA88F21C8B70F0B9BCC7")

    int mIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.901 -0500", hash_original_field = "7ECAB8F1DFD4D8C88111D51780B29562", hash_generated_field = "7ECAB8F1DFD4D8C88111D51780B29562")

    String mWho;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.903 -0500", hash_original_field = "BC54B63AEA85D845C1AC338D041E1ED5", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

    Bundle mArguments;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.904 -0500", hash_original_field = "14E7923C6D3468CDFB90940EBE370C56", hash_generated_field = "14E7923C6D3468CDFB90940EBE370C56")

    Fragment mTarget;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.906 -0500", hash_original_field = "B3D14A57A7194FB87F01321513F81187", hash_generated_field = "B3D14A57A7194FB87F01321513F81187")

    int mTargetIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.908 -0500", hash_original_field = "41D013C95CABF9ED0796F94F0CF16BD1", hash_generated_field = "41D013C95CABF9ED0796F94F0CF16BD1")

    int mTargetRequestCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.910 -0500", hash_original_field = "CE47E8E592EB95BEB04FBBE625E99A8D", hash_generated_field = "CE47E8E592EB95BEB04FBBE625E99A8D")

    boolean mAdded;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.912 -0500", hash_original_field = "5C009156D3400624CB1FFDF310ECAFF1", hash_generated_field = "5C009156D3400624CB1FFDF310ECAFF1")

    boolean mRemoving;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.913 -0500", hash_original_field = "23D2434AD22548E124B62AB7739838E9", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.916 -0500", hash_original_field = "D21475690426FA39A7733914F0F3A95D", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

    boolean mFromLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.918 -0500", hash_original_field = "C7463435817ABA85E5AF0081505BD656", hash_generated_field = "C7463435817ABA85E5AF0081505BD656")

    boolean mInLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.920 -0500", hash_original_field = "83846FEEE5AB5B668E6D933F96FB7819", hash_generated_field = "83846FEEE5AB5B668E6D933F96FB7819")

    boolean mRestored;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.922 -0500", hash_original_field = "6F8CF3ED6C0707B98B23B55A256300E6", hash_generated_field = "6F8CF3ED6C0707B98B23B55A256300E6")

    int mBackStackNesting;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.924 -0500", hash_original_field = "58A45AD5F2F241F335F9B1ED7D27DC02", hash_generated_field = "53E605CA540F26D04157A794B9195F6C")

    // fragment is used in a transaction; cleared after it has been removed
    // from all transactions.
    FragmentManagerImpl mFragmentManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.925 -0500", hash_original_field = "3895D7E6DB5042DA7856DC78E391C7B9", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.928 -0500", hash_original_field = "C628DB5A0351ABB6B2BC170D76A5FF43", hash_generated_field = "CA8CD7786F0FE062B0DC3304DF6A540A")

    // was dynamically added to the view hierarchy, or the ID supplied in
    // layout.
    int mFragmentId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.929 -0500", hash_original_field = "2072CAADE2B3735D2B37FDBC10B7F08E", hash_generated_field = "EA037ED8035E325E39744A6514ED211C")

    // is the identifier of the parent container it is being added to.
    int mContainerId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.931 -0500", hash_original_field = "05B32B05746742D3A5261C827E7D8852", hash_generated_field = "5A2E9483829264A191E4554730180E2A")

    // fragments that are not part of the layout.
    String mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.933 -0500", hash_original_field = "DB81C7417E8D5BB2C252FB40F8D91CF8", hash_generated_field = "25AE71C97A2FE73BD435680E16FA92A1")

    // from the user.
    boolean mHidden;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.935 -0500", hash_original_field = "F0A7088DB55E87649B19609F5563F724", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

    boolean mDetached;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.937 -0500", hash_original_field = "907988FDE235BE080FDDB6DB36EF9C83", hash_generated_field = "947C6D8AF0F5DD8612D2D68E3964DAC8")

    // configuration changes.
    boolean mRetainInstance;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.939 -0500", hash_original_field = "9B9EA230363F2EF227C5BE272DCC6838", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.941 -0500", hash_original_field = "98F2E6991F3565378DE3223CDDF9DBEB", hash_generated_field = "98F2E6991F3565378DE3223CDDF9DBEB")

    boolean mHasMenu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.943 -0500", hash_original_field = "91D8D4C712F4EB13688BF2F27B945286", hash_generated_field = "91D8D4C712F4EB13688BF2F27B945286")

    boolean mMenuVisible = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.945 -0500", hash_original_field = "6971FF9C6126C288092CCC2A5964E550", hash_generated_field = "6971FF9C6126C288092CCC2A5964E550")

    boolean mCalled;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.947 -0500", hash_original_field = "778908554529C0B97FC9B63E5B9208AD", hash_generated_field = "778908554529C0B97FC9B63E5B9208AD")

    int mNextAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.949 -0500", hash_original_field = "583453E78C87ED885A174C885F834BB6", hash_generated_field = "583453E78C87ED885A174C885F834BB6")

    ViewGroup mContainer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.952 -0500", hash_original_field = "6F4F028D1DE9C463F753A80DD0991753", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.953 -0500", hash_original_field = "A8819B0E70BA304D51F44F47380E8807", hash_generated_field = "23E0178E1D94996509AC70E5B3988A39")

    // have been started and their loaders are finished.
    boolean mDeferStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.955 -0500", hash_original_field = "149FC5E47A37645F1FE824C1875916A8", hash_generated_field = "149FC5E47A37645F1FE824C1875916A8")

    boolean mUserVisibleHint = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.957 -0500", hash_original_field = "6EE478DF5473556475C8D09C185A01BC", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.959 -0500", hash_original_field = "D357ECA56BF47F1751443279339D50DF", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.961 -0500", hash_original_field = "93A369593E1CC22C7DE8D4D5C675B065", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;

    /**
     * Default constructor.  <strong>Every</strong> fragment must have an
     * empty constructor, so it can be instantiated when restoring its
     * activity's state.  It is strongly recommended that subclasses do not
     * have other constructors with parameters, since these constructors
     * will not be called when the fragment is re-instantiated; instead,
     * arguments can be supplied by the caller with {@link #setArguments}
     * and later retrieved by the Fragment with {@link #getArguments}.
     * 
     * <p>Applications should generally not implement a constructor.  The
     * first place application code an run where the fragment is ready to
     * be used is in {@link #onAttach(Activity)}, the point where the fragment
     * is actually associated with its activity.  Some applications may also
     * want to implement {@link #onInflate} to retrieve attributes from a
     * layout resource, though should take care here because this happens for
     * the fragment is attached to its activity.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.994 -0500", hash_original_method = "450DCF9C44ABD4359E904BF858920888", hash_generated_method = "CF5FF4F149C6CF2D53AA15104CFBDB03")
    @DSVerified
    
public Fragment() {
        droidsafeModelFragment();
    }

    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    private void droidsafeModelFragment() {
        mArguments = new Bundle();
        onPause();
        onDestroyView();
        onStop();
        onDestroy();
        onDetach();
        
        onCreate(mArguments);
        onActivityCreated(mArguments);        
        onStart();
        onResume();
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.001 -0500", hash_original_method = "7271436905E3847D6FDF6326194EF06D", hash_generated_method = "2990A88A42011BE1573652DBD364F70D")
    
final void restoreViewState() {
        if (mSavedViewState != null) {
            mView.restoreHierarchyState(mSavedViewState);
            mSavedViewState = null;
        }
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.003 -0500", hash_original_method = "681200A239FE58A0DC09757C2C18A7DD", hash_generated_method = "94F85D3397D6447CADCCAC8FB3278131")
    
final void setIndex(int index) {
        mIndex = index;
        mWho = "android:fragment:" + mIndex;
   }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.006 -0500", hash_original_method = "B0D28796550366EF842F99A3D9D59C11", hash_generated_method = "D60291057198FF92ECFB3CAF33EB7BBB")
    
final boolean isInBackStack() {
        return toTaintBoolean(mBackStackNesting + getTaintInt()); 
    }

    /**
     * Subclasses can not override equals().
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.008 -0500", hash_original_method = "055C1CABEC6B90DB231CF8138F07B9C1", hash_generated_method = "3B58C883A45626CCAC1720C76B088B94")
    
@Override final public boolean equals(Object o) {
        return super.equals(o);
    }

    /**
     * Subclasses can not override hashCode().
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.010 -0500", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "235D538D470CAF18D465A30A0FFDA613")
    
@Override final public int hashCode() {
        return super.hashCode();
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.013 -0500", hash_original_method = "5350708001683FB5244A4F612B80A27C", hash_generated_method = "9DFAD998174B68D70A89826D6E15905E")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        if (mIndex >= 0) {
            sb.append(" #");
            sb.append(mIndex);
        }
        if (mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(mFragmentId));
        }
        if (mTag != null) {
            sb.append(" ");
            sb.append(mTag);
        }
        sb.append('}');
        return sb.toString();
    }
    
    /**
     * Return the identifier this fragment is known by.  This is either
     * the android:id value supplied in a layout or the container view ID
     * supplied when adding the fragment.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.015 -0500", hash_original_method = "0D814DEC27C2F0AC661487D8C7B38979", hash_generated_method = "4DF581DD9B3C5EA1E609EFD2DFCBA011")
    
final public int getId() {
        return mFragmentId;
    }
    
    /**
     * Get the tag name of the fragment, if specified.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.017 -0500", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "CE21FCC1BEE20268D2EE36272C97D74D")
    
final public String getTag() {
        return mTag;
    }
    
    /**
     * Supply the construction arguments for this fragment.  This can only
     * be called before the fragment has been attached to its activity; that
     * is, you should call it immediately after constructing the fragment.  The
     * arguments supplied here will be retained across fragment destroy and
     * creation.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.019 -0500", hash_original_method = "2D5CF4DC8DE7FCC73C8073BFA7412800", hash_generated_method = "59F92EEADE1B17A1D49D335C8A42536E")
    
public void setArguments(Bundle args) {
        if (mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        mArguments = args;
    }

    /**
     * Return the arguments supplied when the fragment was instantiated,
     * if any.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.022 -0500", hash_original_method = "AD916C2ECBF1A5C9327A86449330505D", hash_generated_method = "41574A398FEEB791A1D529AFBDB0AB63")
    
final public Bundle getArguments() {
        return mArguments;
    }

    /**
     * Set the initial saved state that this Fragment should restore itself
     * from when first being constructed, as returned by
     * {@link FragmentManager#saveFragmentInstanceState(Fragment)
     * FragmentManager.saveFragmentInstanceState}.
     *
     * @param state The state the fragment should be restored from.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.024 -0500", hash_original_method = "D968C46759760C7406AC68A668D9806D", hash_generated_method = "CBAFDD2DA35863419A96B7EE7F5050E1")
    
public void setInitialSavedState(SavedState state) {
        if (mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        mSavedFragmentState = state != null && state.mState != null
                ? state.mState : null;
    }

    /**
     * Optional target for this fragment.  This may be used, for example,
     * if this fragment is being started by another, and when done wants to
     * give a result back to the first.  The target set here is retained
     * across instances via {@link FragmentManager#putFragment
     * FragmentManager.putFragment()}.
     *
     * @param fragment The fragment that is the target of this one.
     * @param requestCode Optional request code, for convenience if you
     * are going to call back with {@link #onActivityResult(int, int, Intent)}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.026 -0500", hash_original_method = "1E1EC1C5F204666846AC7A8EC55494F6", hash_generated_method = "7A06F3276891CD0B881378A4FBE446A5")
    
public void setTargetFragment(Fragment fragment, int requestCode) {
        mTarget = fragment;
        mTargetRequestCode = requestCode;
    }

    /**
     * Return the target fragment set by {@link #setTargetFragment}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.029 -0500", hash_original_method = "CBC4FCF13CA2895C8D01438D1D6F6EE8", hash_generated_method = "5BEA96F81F4105162E7617ED10DFC1D2")
    
final public Fragment getTargetFragment() {
        return mTarget;
    }

    /**
     * Return the target request code set by {@link #setTargetFragment}.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.031 -0500", hash_original_method = "A4CEFC2C477EE57B614F4504E74127CE", hash_generated_method = "8A962B3F6144966F3684142CE1E156AF")
    
final public int getTargetRequestCode() {
        return mTargetRequestCode;
    }

    /**
     * Return the Activity this fragment is currently associated with.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.033 -0500", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "325AD2BF1D0A0B24371BA04573D4605C")
    
final public Activity getActivity() {
        return mActivity;
    }
    
    /**
     * Return <code>getActivity().getResources()</code>.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.036 -0500", hash_original_method = "A8E18DB36BC334E1CF5901C727187C18", hash_generated_method = "E4C0928E700635ED038F7599AF52D3F4")
    
final public Resources getResources() {
        if (mActivity == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        return mActivity.getResources();
    }
    
    /**
     * Return a localized, styled CharSequence from the application's package's
     * default string table.
     *
     * @param resId Resource id for the CharSequence text
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.038 -0500", hash_original_method = "3F649A13E84C6501035126B3FEE231F4", hash_generated_method = "E2B566B00FA2AC61E50317149C5BCECD")
    
public final CharSequence getText(int resId) {
        return getResources().getText(resId);
    }

    /**
     * Return a localized string from the application's package's
     * default string table.
     *
     * @param resId Resource id for the string
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.040 -0500", hash_original_method = "6096F9B7D678CAFA7D67C1784ABCB9A7", hash_generated_method = "D37D9DF864413A58CE69AFC7CD44E2C7")
    
public final String getString(int resId) {
        return getResources().getString(resId);
    }

    /**
     * Return a localized formatted string from the application's package's
     * default string table, substituting the format arguments as defined in
     * {@link java.util.Formatter} and {@link java.lang.String#format}.
     *
     * @param resId Resource id for the format string
     * @param formatArgs The format arguments that will be used for substitution.
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.042 -0500", hash_original_method = "524F00C5C13CBD3BD0D5C512A4C12294", hash_generated_method = "D6859AF8D80E850EE17858448765ABE4")
    
public final String getString(int resId, Object... formatArgs) {
        return getResources().getString(resId, formatArgs);
    }

    /**
     * Return the FragmentManager for interacting with fragments associated
     * with this fragment's activity.  Note that this will be non-null slightly
     * before {@link #getActivity()}, during the time from when the fragment is
     * placed in a {@link FragmentTransaction} until it is committed and
     * attached to its activity.
     */
    @DSComment("Android Manager retrieved/accessed")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.044 -0500", hash_original_method = "ED1BD18F392C2062694622C1FF4A3A44", hash_generated_method = "9FB618358C5CDB15EFE3334E40CE4E04")
    
final public FragmentManager getFragmentManager() {
        return mFragmentManager;
    }

    /**
     * Return true if the fragment is currently added to its activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.046 -0500", hash_original_method = "C0D74F5DDFD9A01C19E54F3379BA7652", hash_generated_method = "618EE3A321C4FFDE67749913AA58ADE8")
    
final public boolean isAdded() {
        return toTaintBoolean(toTaintInt(mAdded) + mActivity.getTaintInt());
    }

    /**
     * Return true if the fragment has been explicitly detached from the UI.
     * That is, {@link FragmentTransaction#detach(Fragment)
     * FragmentTransaction.detach(Fragment)} has been used on it.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.049 -0500", hash_original_method = "2F8509F8C4A8638224A8FC9748BC6275", hash_generated_method = "A3DAB4791D78BFADFFEB813492AD2568")
    
final public boolean isDetached() {
        return mDetached;
    }

    /**
     * Return true if this fragment is currently being removed from its
     * activity.  This is  <em>not</em> whether its activity is finishing, but
     * rather whether it is in the process of being removed from its activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.051 -0500", hash_original_method = "914BD43FF0612F84BA345FA6F486595C", hash_generated_method = "A561E003CE14A65B9914402F4DEBD08B")
    
final public boolean isRemoving() {
        return mRemoving;
    }
    
    /**
     * Return true if the layout is included as part of an activity view
     * hierarchy via the &lt;fragment&gt; tag.  This will always be true when
     * fragments are created through the &lt;fragment&gt; tag, <em>except</em>
     * in the case where an old fragment is restored from a previous state and
     * it does not appear in the layout of the current state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.053 -0500", hash_original_method = "3C6E7329283D3C6C46FB3F90EF65A4A7", hash_generated_method = "DF69A7831BD134C7DE03F61A47C2BF23")
    
final public boolean isInLayout() {
        return mInLayout;
    }

    /**
     * Return true if the fragment is in the resumed state.  This is true
     * for the duration of {@link #onResume()} and {@link #onPause()} as well.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.055 -0500", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "455292EC01D784DABC1B1D173C232A3F")
    
final public boolean isResumed() {
        return mResumed;
    }
    
    /**
     * Return true if the fragment is currently visible to the user.  This means
     * it: (1) has been added, (2) has its view attached to the window, and 
     * (3) is not hidden.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.058 -0500", hash_original_method = "72982976B71B01DF2412198462460DF0", hash_generated_method = "3FC970F17DE45AAF7F1BC31C989BC4E0")
    
final public boolean isVisible() {
        /*
        return isAdded() && !isHidden() && mView != null
                && mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE;
        */
        return toTaintBoolean(getTaintInt() + mView.getTaintInt());
    }
    
    /**
     * Return true if the fragment has been hidden.  By default fragments
     * are shown.  You can find out about changes to this state with
     * {@link #onHiddenChanged}.  Note that the hidden state is orthogonal
     * to other states -- that is, to be visible to the user, a fragment
     * must be both started and not hidden.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.061 -0500", hash_original_method = "E04FD968639295CCE5F791161EDE4496", hash_generated_method = "95435B2E5A3E660232E391B2CA517F03")
    
final public boolean isHidden() {
        //return mHidden;
        return toTaintBoolean(getTaintInt() + toTaintInt(mHidden));
    }
    
    /**
     * Called when the hidden state (as returned by {@link #isHidden()} of
     * the fragment has changed.  Fragments start out not hidden; this will
     * be called whenever the fragment changes state from that.
     * @param hidden True if the fragment is now hidden, false if it is not
     * visible.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.063 -0500", hash_original_method = "FE8A5DF015D2662392185902D9D0AEDD", hash_generated_method = "6171B40743610647ED2639EEA99C32FF")
    
public void onHiddenChanged(boolean hidden) {
    }
    
    /**
     * Control whether a fragment instance is retained across Activity
     * re-creation (such as from a configuration change).  This can only
     * be used with fragments not in the back stack.  If set, the fragment
     * lifecycle will be slightly different when an activity is recreated:
     * <ul>
     * <li> {@link #onDestroy()} will not be called (but {@link #onDetach()} still
     * will be, because the fragment is being detached from its current activity).
     * <li> {@link #onCreate(Bundle)} will not be called since the fragment
     * is not being re-created.
     * <li> {@link #onAttach(Activity)} and {@link #onActivityCreated(Bundle)} <b>will</b>
     * still be called.
     * </ul>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.065 -0500", hash_original_method = "8E671A431463BFA7D0F399C37FBCF1E9", hash_generated_method = "747E83188A043E85BAB169E0FCB2F587")
    
public void setRetainInstance(boolean retain) {
        mRetainInstance = retain;
    }
    
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.067 -0500", hash_original_method = "82A17104D5864E2285E97283523AA6C5", hash_generated_method = "D11F75A97102EB6791F32EF78D9550B7")
    
final public boolean getRetainInstance() {
        return mRetainInstance;
    }
    
    /**
     * Report that this fragment would like to participate in populating
     * the options menu by receiving a call to {@link #onCreateOptionsMenu}
     * and related methods.
     * 
     * @param hasMenu If true, the fragment has menu items to contribute.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.069 -0500", hash_original_method = "A6D768E437C7421B050650CBF4A7B137", hash_generated_method = "33B2D2DF136C59516275F54EDA09740F")
    
public void setHasOptionsMenu(boolean hasMenu) {
        if (mHasMenu != hasMenu) {
            mHasMenu = hasMenu;
            if (isAdded() && !isHidden()) {
                mFragmentManager.invalidateOptionsMenu();
            }
        }
    }

    /**
     * Set a hint for whether this fragment's menu should be visible.  This
     * is useful if you know that a fragment has been placed in your view
     * hierarchy so that the user can not currently seen it, so any menu items
     * it has should also not be shown.
     *
     * @param menuVisible The default is true, meaning the fragment's menu will
     * be shown as usual.  If false, the user will not see the menu.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.071 -0500", hash_original_method = "2CD00B5529D6A4CD9554A0275473942E", hash_generated_method = "8ED0C3B56D7CB2C2D21A87F57ECA9DF7")
    
public void setMenuVisibility(boolean menuVisible) {
        if (mMenuVisible != menuVisible) {
            mMenuVisible = menuVisible;
            if (mHasMenu && isAdded() && !isHidden()) {
                mFragmentManager.invalidateOptionsMenu();
            }
        }
    }

    /**
     * Set a hint to the system about whether this fragment's UI is currently visible
     * to the user. This hint defaults to true and is persistent across fragment instance
     * state save and restore.
     *
     * <p>An app may set this to false to indicate that the fragment's UI is
     * scrolled out of visibility or is otherwise not directly visible to the user.
     * This may be used by the system to prioritize operations such as fragment lifecycle updates
     * or loader ordering behavior.</p>
     *
     * @param isVisibleToUser true if this fragment's UI is currently visible to the user (default),
     *                        false if it is not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.073 -0500", hash_original_method = "1B0128696FF26E02ABF181CBEC60E7DF", hash_generated_method = "1E5A540C2E02DD71EBF65E7042379446")
    
public void setUserVisibleHint(boolean isVisibleToUser) {
        if (!mUserVisibleHint && isVisibleToUser && mState < STARTED) {
            mFragmentManager.performPendingDeferredStart(this);
        }
        mUserVisibleHint = isVisibleToUser;
        mDeferStart = !isVisibleToUser;
    }

    /**
     * @return The current value of the user-visible hint on this fragment.
     * @see #setUserVisibleHint(boolean)
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.075 -0500", hash_original_method = "16570E728AF342CDACA5E18099682804", hash_generated_method = "6AB5C01BD00C9F5856A51813221F3FCB")
    
public boolean getUserVisibleHint() {
        return mUserVisibleHint;
    }

    /**
     * Return the LoaderManager for this fragment, creating it if needed.
     */
    @DSComment("Android Manager retrieved/accessed")
    @DSSpec(DSCat.ANDROID_MANAGER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.077 -0500", hash_original_method = "71C5851113530E9E497DE6FFC60D128C", hash_generated_method = "D633F92B490ADBE12B8C6B78AA25CB20")
    
public LoaderManager getLoaderManager() {
        if (mLoaderManager != null) {
            return mLoaderManager;
        }
        if (mActivity == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        mCheckedForLoaderManager = true;
        mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, true);
        return mLoaderManager;
    }
    
    /**
     * Call {@link Activity#startActivity(Intent)} on the fragment's
     * containing Activity.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.079 -0500", hash_original_method = "B68B30EDC5AB3BE8EF657FB7051C7F7E", hash_generated_method = "2653C537061CAA70FE618F1495F7C4F1")
    @DSVerified
public void startActivity(Intent intent) {
        if (mActivity == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        mActivity.startActivityFromFragment(this, intent, -1);
    }
    
    /**
     * Call {@link Activity#startActivityForResult(Intent, int)} on the fragment's
     * containing Activity.
     */
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.083 -0500", hash_original_method = "849399EB62F8B6EE6A6E550D7989B87C", hash_generated_method = "8768E2B6EA85361E6FA51CBF490464A9")
    @DSVerified
    
public void startActivityForResult(Intent intent, int requestCode) {
        if (mActivity == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        mActivity.startActivityFromFragment(this, intent, requestCode);
        onActivityResult(requestCode, 0, intent);
    }
    
    /**
     * Receive the result from a previous call to
     * {@link #startActivityForResult(Intent, int)}.  This follows the
     * related Activity API as described there in
     * {@link Activity#onActivityResult(int, int, Intent)}.
     * 
     * @param requestCode The integer request code originally supplied to
     *                    startActivityForResult(), allowing you to identify who this
     *                    result came from.
     * @param resultCode The integer result code returned by the child activity
     *                   through its setResult().
     * @param data An Intent, which can return result data to the caller
     *               (various data can be attached to Intent "extras").
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.084 -0500", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "C260DB77EAE28D217FB04A25644FEF88")
    @DSVerified("Called from Activity")
    @DSComment("Potential intent to trigger other processing")
    @DSSpec(DSCat.INTENT_EXCHANGE)
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
    
    /**
     * @hide Hack so that DialogFragment can make its Dialog before creating
     * its views, and the view construction can use the dialog's context for
     * inflation.  Maybe this should become a public API. Note sure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.086 -0500", hash_original_method = "8FF008E86C71DF2CF57F1B9E3E9D8CD9", hash_generated_method = "215582C096358607BAA8172CADB219C2")
    
public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        return mActivity.getLayoutInflater();
    }
    
    /**
     * @deprecated Use {@link #onInflate(Activity, AttributeSet, Bundle)} instead.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.089 -0500", hash_original_method = "B81B691062FF851E8B34D981FF83329F", hash_generated_method = "D61B40DBA531443E74E24D62B31EB7A1")
    
@Deprecated
    public void onInflate(AttributeSet attrs, Bundle savedInstanceState) {
        mCalled = true;
    }

    /**
     * Called when a fragment is being created as part of a view layout
     * inflation, typically from setting the content view of an activity.  This
     * may be called immediately after the fragment is created from a <fragment>
     * tag in a layout file.  Note this is <em>before</em> the fragment's
     * {@link #onAttach(Activity)} has been called; all you should do here is
     * parse the attributes and save them away.
     * 
     * <p>This is called every time the fragment is inflated, even if it is
     * being inflated into a new instance with saved state.  It typically makes
     * sense to re-parse the parameters each time, to allow them to change with
     * different configurations.</p>
     *
     * <p>Here is a typical implementation of a fragment that can take parameters
     * both through attributes supplied here as well from {@link #getArguments()}:</p>
     *
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentArguments.java
     *      fragment}
     *
     * <p>Note that parsing the XML attributes uses a "styleable" resource.  The
     * declaration for the styleable used here is:</p>
     *
     * {@sample development/samples/ApiDemos/res/values/attrs.xml fragment_arguments}
     * 
     * <p>The fragment can then be declared within its activity's content layout
     * through a tag like this:</p>
     *
     * {@sample development/samples/ApiDemos/res/layout/fragment_arguments.xml from_attributes}
     *
     * <p>This fragment can also be created dynamically from arguments given
     * at runtime in the arguments Bundle; here is an example of doing so at
     * creation of the containing activity:</p>
     *
     * {@sample development/samples/ApiDemos/src/com/example/android/apis/app/FragmentArguments.java
     *      create}
     *
     * @param activity The Activity that is inflating this fragment.
     * @param attrs The attributes at the tag where the fragment is
     * being created.
     * @param savedInstanceState If the fragment is being re-created from
     * a previous saved state, this is the state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.091 -0500", hash_original_method = "295D90877B0CE50D1EC7F89F1D4EC254", hash_generated_method = "AF95EA76CEAC97CC4184F84B5233D4C1")
    
public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        onInflate(attrs, savedInstanceState);
        mCalled = true;
    }
    
    /**
     * Called when a fragment is first attached to its activity.
     * {@link #onCreate(Bundle)} will be called after this.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.093 -0500", hash_original_method = "7FCB8118913FF635CB1CDE717E61023E", hash_generated_method = "B80B37A37F384FB495394FF2DE913216")
    @DSVerified("Called by FragmentTransaction")
public void onAttach(Activity activity) {
        mCalled = true;
    }
    
    /**
     * Called when a fragment loads an animation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.095 -0500", hash_original_method = "EB97CF4ACDD4FD35B8071D1AF529F576", hash_generated_method = "CB1C0BC3484AD50060A745ABB0C4D97D")
    
public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        return null;
    }
    
    /**
     * Called to do initial creation of a fragment.  This is called after
     * {@link #onAttach(Activity)} and before
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * 
     * <p>Note that this can be called while the fragment's activity is
     * still in the process of being created.  As such, you can not rely
     * on things like the activity's content view hierarchy being initialized
     * at this point.  If you want to do work once the activity itself is
     * created, see {@link #onActivityCreated(Bundle)}.
     * 
     * @param savedInstanceState If the fragment is being re-created from
     * a previous saved state, this is the state.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.097 -0500", hash_original_method = "00494AECA41C1730DF6E82548FC2C3D5", hash_generated_method = "16BC96174FF1001ACAD87A7C411E6383")
    @DSVerified
    
public void onCreate(Bundle savedInstanceState) {
        // onCreate is being called by activity -> FragmentMangerImpl -> Fragment
        // it is deep in changeState.  We may need to simplify the model a little bit
        mCalled = true;
    }
    
    /**
     * Called immediately after {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     * @param view The View returned by {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.099 -0500", hash_original_method = "F4318A499F9B06ABC9CCF0644AE6DC10", hash_generated_method = "7A9779D0E96BCB81E2F9B1D4F8B9E908")

    @DSVerified
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void onViewCreated(View view, Bundle savedInstanceState) {
    }
    
	@DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//return null;
		return new View(container.getContext());
	}
    
    /**
     * Get the root view for the fragment's layout (the one returned by {@link #onCreateView}),
     * if provided.
     * 
     * @return The fragment's root view, or null if it has no layout.
     */
    @DSComment("GUI, Fragment")
    @DSSafe(DSCat.GUI)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.103 -0500", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "08E70AA8D2F1647EC2EEAF8AC8218386")
    
public View getView() {
        return mView;
    }
    
    /**
     * Called when the fragment's activity has been created and this
     * fragment's view hierarchy instantiated.  It can be used to do final
     * initialization once these pieces are in place, such as retrieving
     * views or restoring state.  It is also useful for fragments that use
     * {@link #setRetainInstance(boolean)} to retain their instance,
     * as this callback tells the fragment when it is fully associated with
     * the new activity instance.  This is called after {@link #onCreateView}
     * and before {@link #onStart()}.
     * 
     * @param savedInstanceState If the fragment is being re-created from
     * a previous saved state, this is the state.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSVerified
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.105 -0500", hash_original_method = "C52625884C98429BE8DE42F4FBFE7367", hash_generated_method = "98A4E1BEF43B96D6CA75F281B713F100")
    
public void onActivityCreated(Bundle savedInstanceState) {
        mCalled = true;
    }
    
    /**
     * Called when the Fragment is visible to the user.  This is generally
     * tied to {@link Activity#onStart() Activity.onStart} of the containing
     * Activity's lifecycle.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.108 -0500", hash_original_method = "4BDF3B44AFE0C3B519B659689A5EE977", hash_generated_method = "21A0B779E04621D46D7CA82798BED555")
    
public void onStart() {
        mCalled = true;
        
        if (!mLoadersStarted) {
            mLoadersStarted = true;
            if (!mCheckedForLoaderManager) {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            }
            if (mLoaderManager != null) {
                mLoaderManager.doStart();
            }
        }
    }
    
    /**
     * Called when the fragment is visible to the user and actively running.
     * This is generally
     * tied to {@link Activity#onResume() Activity.onResume} of the containing
     * Activity's lifecycle.
     */
    @DSComment("normal android callback")
    @DSSpec(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.111 -0500", hash_original_method = "3B8608ED59C2663D271D57F8D8F534C0", hash_generated_method = "4D7A6260998C4FCE09C9F7547BB0088D")
    
public void onResume() {
        mCalled = true;
    }
    
    /**
     * Called to ask the fragment to save its current dynamic state, so it
     * can later be reconstructed in a new instance of its process is
     * restarted.  If a new instance of the fragment later needs to be
     * created, the data you place in the Bundle here will be available
     * in the Bundle given to {@link #onCreate(Bundle)},
     * {@link #onCreateView(LayoutInflater, ViewGroup, Bundle)}, and
     * {@link #onActivityCreated(Bundle)}.
     *
     * <p>This corresponds to {@link Activity#onSaveInstanceState(Bundle)
     * Activity.onSaveInstanceState(Bundle)} and most of the discussion there
     * applies here as well.  Note however: <em>this method may be called
     * at any time before {@link #onDestroy()}</em>.  There are many situations
     * where a fragment may be mostly torn down (such as when placed on the
     * back stack with no UI showing), but its state will not be saved until
     * its owning activity actually needs to save its state.
     *
     * @param outState Bundle in which to place your saved state.
     */
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.113 -0500", hash_original_method = "9C4F98F3F5A4FCEFF66E261EDA5693F3", hash_generated_method = "C04385BA6080B306978908B96949C69D")
    
public void onSaveInstanceState(Bundle outState) {
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.115 -0500", hash_original_method = "16A05561D5415124B893EA7E2AFB953D", hash_generated_method = "6329F4570B711AA91B0B56ED1E69203C")
    
public void onConfigurationChanged(Configuration newConfig) {
        mCalled = true;
    }
    
    /**
     * Called when the Fragment is no longer resumed.  This is generally
     * tied to {@link Activity#onPause() Activity.onPause} of the containing
     * Activity's lifecycle.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.117 -0500", hash_original_method = "CEF2FF1DA31E7EE9D761807A037B37B2", hash_generated_method = "51C6B5EC7B1D9F940C577FFB2B442418")
    
public void onPause() {
        mCalled = true;
    }
    
    /**
     * Called when the Fragment is no longer started.  This is generally
     * tied to {@link Activity#onStop() Activity.onStop} of the containing
     * Activity's lifecycle.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.119 -0500", hash_original_method = "FC062A9ECA017F6E5D455E8C973942F9", hash_generated_method = "74B942254A2EEF5C3A13F16A340184BC")
    
public void onStop() {
        mCalled = true;
    }
    
    @Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
	}
    
    @DSVerified
    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public void droidsafeSubFragmentHook() {
        
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.123 -0500", hash_original_method = "E1E8CF8B1FBB3E8165C3219A9D0BB675", hash_generated_method = "9F599A3EEFB4A8E50276D3B55427ECB6")
    
public void onTrimMemory(int level) {
        mCalled = true;
    }

    /**
     * Called when the view previously created by {@link #onCreateView} has
     * been detached from the fragment.  The next time the fragment needs
     * to be displayed, a new view will be created.  This is called
     * after {@link #onStop()} and before {@link #onDestroy()}.  It is called
     * <em>regardless</em> of whether {@link #onCreateView} returned a
     * non-null view.  Internally it is called after the view's state has
     * been saved but before it has been removed from its parent.
     */
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.125 -0500", hash_original_method = "E54F17C7BAFD082A48D2152349C1815A", hash_generated_method = "EF5D35A4BE966F5779FF7FF52FB51600")
    
public void onDestroyView() {
        mCalled = true;
    }
    
    /**
     * Called when the fragment is no longer in use.  This is called
     * after {@link #onStop()} and before {@link #onDetach()}.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.128 -0500", hash_original_method = "AA4E137E24C2C382652C9FBA94B1ED31", hash_generated_method = "E78CE25D23DD6E4B0B09558D826A177A")
    
public void onDestroy() {
        mCalled = true;
        //Log.v("foo", "onDestroy: mCheckedForLoaderManager=" + mCheckedForLoaderManager
        //        + " mLoaderManager=" + mLoaderManager);
        if (!mCheckedForLoaderManager) {
            mCheckedForLoaderManager = true;
            mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
        }
        if (mLoaderManager != null) {
            mLoaderManager.doDestroy();
        }
    }

    /**
     * Called by the fragment manager once this fragment has been removed,
     * so that we don't have any left-over state if the application decides
     * to re-use the instance.  This only clears state that the framework
     * internally manages, not things the application sets.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.130 -0500", hash_original_method = "04633BF5293F80973E1AA355DB2C35EF", hash_generated_method = "04633BF5293F80973E1AA355DB2C35EF")
    
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
    }

    /**
     * Called when the fragment is no longer attached to its activity.  This
     * is called after {@link #onDestroy()}.
     */
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.132 -0500", hash_original_method = "EF609D2FD1394DFBC19807CB21AD7D10", hash_generated_method = "83E23ABA3A95A944F06C58F7795DEF3A")
    
public void onDetach() {
        mCalled = true;
    }
    
    /**
     * We need to pass in the activity to associate the fragment with an activity.
     * There is no legal way of doing it through API, easier to make of type context
     * for generated soot code
     * @param activity
     */
    public void droidsafeSetContext(Context activity) {
        mActivity = (Activity)activity;
        onAttach(mActivity);
    }
    
    /**
     * Initialize the contents of the Activity's standard options menu.  You
     * should place your menu items in to <var>menu</var>.  For this method
     * to be called, you must have first called {@link #setHasOptionsMenu}.  See
     * {@link Activity#onCreateOptionsMenu(Menu) Activity.onCreateOptionsMenu}
     * for more information.
     * 
     * @param menu The options menu in which you place your items.
     * 
     * @see #setHasOptionsMenu
     * @see #onPrepareOptionsMenu
     * @see #onOptionsItemSelected
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.134 -0500", hash_original_method = "B3C5F3D019B47C47E6111F1C7C38CA5D", hash_generated_method = "029924445C1AFDCE87D15E2774C1B76B")
    @DSVerified("Called from FragmentManagerImp, which is called by droidsafeOnOthersHook")
    @DSSafe(DSCat.ANDROID_CALLBACK)
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    /**
     * Prepare the Screen's standard options menu to be displayed.  This is
     * called right before the menu is shown, every time it is shown.  You can
     * use this method to efficiently enable/disable items or otherwise
     * dynamically modify the contents.  See
     * {@link Activity#onPrepareOptionsMenu(Menu) Activity.onPrepareOptionsMenu}
     * for more information.
     * 
     * @param menu The options menu as last shown or first initialized by
     *             onCreateOptionsMenu().
     * 
     * @see #setHasOptionsMenu
     * @see #onCreateOptionsMenu
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.136 -0500", hash_original_method = "4CE703F4C1FA6FC474411DFE6A3F5275", hash_generated_method = "9325340E8223ABF193B102C1ED7D29C6")
    
public void onPrepareOptionsMenu(Menu menu) {
    }

    /**
     * Called when this fragment's option menu items are no longer being
     * included in the overall options menu.  Receiving this call means that
     * the menu needed to be rebuilt, but this fragment's items were not
     * included in the newly built menu (its {@link #onCreateOptionsMenu(Menu, MenuInflater)}
     * was not called).
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.138 -0500", hash_original_method = "0E8C037F224061747BFFD0611606AAB6", hash_generated_method = "3608219F0AAFE36F66E308DE0FF9732B")
    
public void onDestroyOptionsMenu() {
    }
    
    /**
     * This hook is called whenever an item in your options menu is selected.
     * The default implementation simply returns false to have the normal
     * processing happen (calling the item's Runnable or sending a message to
     * its Handler as appropriate).  You can use this method for any items
     * for which you would like to do processing without those other
     * facilities.
     * 
     * <p>Derived classes should call through to the base class for it to
     * perform the default menu handling.
     * 
     * @param item The menu item that was selected.
     * 
     * @return boolean Return false to allow normal menu processing to
     *         proceed, true to consume it here.
     * 
     * @see #onCreateOptionsMenu
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.140 -0500", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "69E9D8B4009D997BC9EE261646EC81E4")
    
public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    /**
     * This hook is called whenever the options menu is being closed (either by the user canceling
     * the menu with the back/menu button, or when an item is selected).
     *  
     * @param menu The options menu as last shown or first initialized by
     *             onCreateOptionsMenu().
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.142 -0500", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "105C77F54F2D3DE304E191D655D9615E")
    
public void onOptionsMenuClosed(Menu menu) {
    }
    
    public static class SavedState implements Parcelable {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.633 -0400", hash_original_field = "8C0168FE172D1D9B33F36BA223FF422A", hash_generated_field = "2999E0A81FA5064B37A7DD9A52DB7607")

        public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR
                = new Parcelable.ClassLoaderCreator<SavedState>() {
            @DSSafe(DSCat.SAFE_OTHERS)
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.977 -0500", hash_original_method = "F6A52F04C4D14500D0C1089F687B7F14", hash_generated_method = "FE85131981ECBA63EB19FB4392208C42")
            
public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, null);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.980 -0500", hash_original_method = "827740B54B4D2FB6132FF4A14CAC20AA", hash_generated_method = "83D4D634ED07A42446AB99785AFA5E39")
            
public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.983 -0500", hash_original_method = "2D31E9CBAAAE05B696D738324F87FF78", hash_generated_method = "020465B62F970B98C266AF229149E391")
            
public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.964 -0500", hash_original_field = "AA4A80FE6E8C28CFC04031C8CFFC3C9D", hash_generated_field = "AA4A80FE6E8C28CFC04031C8CFFC3C9D")

         Bundle mState;

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.967 -0500", hash_original_method = "7D4CB1BC3C04B99DC21EA19CB6BAF4D3", hash_generated_method = "7D4CB1BC3C04B99DC21EA19CB6BAF4D3")
        
SavedState(Bundle state) {
            mState = state;
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.969 -0500", hash_original_method = "E611F4C5C5E159704631D93ABD994DEF", hash_generated_method = "E611F4C5C5E159704631D93ABD994DEF")
        
SavedState(Parcel in, ClassLoader loader) {
            mState = in.readBundle();
            if (loader != null && mState != null) {
                mState.setClassLoader(loader);
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.972 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
        
@Override
        public int describeContents() {
            return 0;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.975 -0500", hash_original_method = "ACF88B4EF312D321A4777388A96F3566", hash_generated_method = "5F558454F7CB74DB501C06054FC16E11")
        
@Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeBundle(mState);
        }
    }
    
    static public class InstantiationException extends AndroidRuntimeException {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:14.989 -0500", hash_original_method = "9A59F9C8F177B5B07F720376B1CE8BCE", hash_generated_method = "E7FAD5438370C220B69593F88B644314")
        
public InstantiationException(String msg, Exception cause) {
            super(msg, cause);
        }
        
    }
    
    @Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
	}

    /**
     * Registers a context menu to be shown for the given view (multiple views
     * can show the context menu). This method will set the
     * {@link OnCreateContextMenuListener} on the view to this fragment, so
     * {@link #onCreateContextMenu(ContextMenu, View, ContextMenuInfo)} will be
     * called when it is time to show the context menu.
     * 
     * @see #unregisterForContextMenu(View)
     * @param view The view that should show a context menu.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.146 -0500", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "C1ED4C2C40B6DEE495507BA44925204D")
    
public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }
    
    /**
     * Prevents a context menu to be shown for the given view. This method will
     * remove the {@link OnCreateContextMenuListener} on the view.
     * 
     * @see #registerForContextMenu(View)
     * @param view The view that should stop showing a context menu.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.149 -0500", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "75D2DB67C93B9FA99A912C90753A67CE")
    
public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
    
    /**
     * This hook is called whenever an item in a context menu is selected. The
     * default implementation simply returns false to have the normal processing
     * happen (calling the item's Runnable or sending a message to its Handler
     * as appropriate). You can use this method for any items for which you
     * would like to do processing without those other facilities.
     * <p>
     * Use {@link MenuItem#getMenuInfo()} to get extra information set by the
     * View that added this menu item.
     * <p>
     * Derived classes should call through to the base class for it to perform
     * the default menu handling.
     * 
     * @param item The context menu item that was selected.
     * @return boolean Return false to allow normal context menu processing to
     *         proceed, true to consume it here.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.151 -0500", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "8B3B439BA7ABB6AA146B4A585B36ACCC")
    
public boolean onContextItemSelected(MenuItem item) {
        return false;
    }
    
    /**
     * Print the Fragments's state into the given stream.
     *
     * @param prefix Text to print at the front of each line.
     * @param fd The raw file descriptor that the dump is being sent to.
     * @param writer The PrintWriter to which you should dump your state.  This will be
     * closed for you after you return.
     * @param args additional arguments to the dump request.
     */
    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.155 -0500", hash_original_method = "C78D4ECAA9BAFBCD9E78657D4224F582", hash_generated_method = "5206F4499E6E026B2252E75571BF0242")
    
public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix); writer.print("mFragmentId=#");
                writer.print(Integer.toHexString(mFragmentId));
                writer.print(" mContainerId#=");
                writer.print(Integer.toHexString(mContainerId));
                writer.print(" mTag="); writer.println(mTag);
        writer.print(prefix); writer.print("mState="); writer.print(mState);
                writer.print(" mIndex="); writer.print(mIndex);
                writer.print(" mWho="); writer.print(mWho);
                writer.print(" mBackStackNesting="); writer.println(mBackStackNesting);
        writer.print(prefix); writer.print("mAdded="); writer.print(mAdded);
                writer.print(" mRemoving="); writer.print(mRemoving);
                writer.print(" mResumed="); writer.print(mResumed);
                writer.print(" mFromLayout="); writer.print(mFromLayout);
                writer.print(" mInLayout="); writer.println(mInLayout);
        writer.print(prefix); writer.print("mHidden="); writer.print(mHidden);
                writer.print(" mDetached="); writer.print(mDetached);
                writer.print(" mMenuVisible="); writer.print(mMenuVisible);
                writer.print(" mHasMenu="); writer.println(mHasMenu);
        writer.print(prefix); writer.print("mRetainInstance="); writer.print(mRetainInstance);
                writer.print(" mRetaining="); writer.print(mRetaining);
                writer.print(" mUserVisibleHint="); writer.println(mUserVisibleHint);
        if (mFragmentManager != null) {
            writer.print(prefix); writer.print("mFragmentManager=");
                    writer.println(mFragmentManager);
        }
        if (mActivity != null) {
            writer.print(prefix); writer.print("mActivity=");
                    writer.println(mActivity);
        }
        if (mArguments != null) {
            writer.print(prefix); writer.print("mArguments="); writer.println(mArguments);
        }
        if (mSavedFragmentState != null) {
            writer.print(prefix); writer.print("mSavedFragmentState=");
                    writer.println(mSavedFragmentState);
        }
        if (mSavedViewState != null) {
            writer.print(prefix); writer.print("mSavedViewState=");
                    writer.println(mSavedViewState);
        }
        if (mTarget != null) {
            writer.print(prefix); writer.print("mTarget="); writer.print(mTarget);
                    writer.print(" mTargetRequestCode=");
                    writer.println(mTargetRequestCode);
        }
        if (mNextAnim != 0) {
            writer.print(prefix); writer.print("mNextAnim="); writer.println(mNextAnim);
        }
        if (mContainer != null) {
            writer.print(prefix); writer.print("mContainer="); writer.println(mContainer);
        }
        if (mView != null) {
            writer.print(prefix); writer.print("mView="); writer.println(mView);
        }
        if (mAnimatingAway != null) {
            writer.print(prefix); writer.print("mAnimatingAway="); writer.println(mAnimatingAway);
            writer.print(prefix); writer.print("mStateAfterAnimating=");
                    writer.println(mStateAfterAnimating);
        }
        if (mLoaderManager != null) {
            writer.print(prefix); writer.println("Loader Manager:");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.157 -0500", hash_original_method = "A194798DFC3B633DD6139CF302E65474", hash_generated_method = "A194798DFC3B633DD6139CF302E65474")
    
void performStart() {
        onStart();
        if (mLoaderManager != null) {
            mLoaderManager.doReportStart();
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.159 -0500", hash_original_method = "DF7E450C96FF033A1F96B7AC1D56EC13", hash_generated_method = "DF7E450C96FF033A1F96B7AC1D56EC13")
    
void performStop() {
        onStop();
        
        if (mLoadersStarted) {
            mLoadersStarted = false;
            if (!mCheckedForLoaderManager) {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            }
            if (mLoaderManager != null) {
                if (mActivity == null || !mActivity.mChangingConfigurations) {
                    mLoaderManager.doStop();
                } else {
                    mLoaderManager.doRetain();
                }
            }
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:15.161 -0500", hash_original_method = "3EF3D6E87A549E78C03CB36A1B3A62F5", hash_generated_method = "3EF3D6E87A549E78C03CB36A1B3A62F5")
    
void performDestroyView() {
        onDestroyView();
        if (mLoaderManager != null) {
            mLoaderManager.doReportNextStart();
        }
    }
    
}

