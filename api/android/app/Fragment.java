<<<<<<< HEAD
package android.app;

// Droidsafe Imports
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
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

final class FragmentState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.576 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "6BC238A3BDD37BF1CAC26EA2CE45C508")

    String mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "D9B77340C245436344B0149264025068", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

    boolean mFromLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "743B83D822DFF54AE7E24307CEF26F0C", hash_generated_field = "C628DB5A0351ABB6B2BC170D76A5FF43")

    int mFragmentId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "A2C9A3DA927DBE9AB0FC8FD8C7B637D9", hash_generated_field = "2072CAADE2B3735D2B37FDBC10B7F08E")

    int mContainerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

    String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "FC2473D51E767C5008A9D428BAFC8661", hash_generated_field = "907988FDE235BE080FDDB6DB36EF9C83")

    boolean mRetainInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "23906763A9631E67BD7C67265695AFF7", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

    boolean mDetached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "5867CE8CB088E58E6D17882F8EE91C5B", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

    Bundle mArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "74933D8F8D085F6D27B373C3AD9FBBC4", hash_generated_field = "F958FB3998EC484A7599A988303CD216")

    Bundle mSavedFragmentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.577 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "F83F5A158F2251FA12452672DC97E470")

    Fragment mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.579 -0400", hash_original_method = "116485142A61C36D4B47DBE9BCB45890", hash_generated_method = "9C8B1F3AA1DA7C8FAE9B803347EE426A")
    public  FragmentState(Fragment frag) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.579 -0400", hash_original_method = "46F838C8877526D395D980C698E03728", hash_generated_method = "1AEC5D39B1C46172E66E2ADE1F21E5F6")
    public  FragmentState(Parcel in) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.580 -0400", hash_original_method = "64945B874E9F798BEAFB62D4A4B63532", hash_generated_method = "F29129878658C039268C31C2D8308FC6")
    public Fragment instantiate(Activity activity) {
        if(mInstance != null)        
        {
Fragment var01A4E1572BEF98558ED7F4E845C07CFE_2057984697 =             mInstance;
            var01A4E1572BEF98558ED7F4E845C07CFE_2057984697.addTaint(taint);
            return var01A4E1572BEF98558ED7F4E845C07CFE_2057984697;
        } //End block
        if(mArguments != null)        
        {
            mArguments.setClassLoader(activity.getClassLoader());
        } //End block
        mInstance = Fragment.instantiate(activity, mClassName, mArguments);
        if(mSavedFragmentState != null)        
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
Fragment var01A4E1572BEF98558ED7F4E845C07CFE_852537653 =         mInstance;
        var01A4E1572BEF98558ED7F4E845C07CFE_852537653.addTaint(taint);
        return var01A4E1572BEF98558ED7F4E845C07CFE_852537653;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.580 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2E11588451CCCF7C5375466243348443")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1443360195 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286193425 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286193425;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.581 -0400", hash_original_method = "5938F2E0A344A05A5347D3909CB444C6", hash_generated_method = "7021DC69993F7F0B884899058516CB7A")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.581 -0400", hash_original_field = "20C24B13B86A2BA0167AA1764B64C330", hash_generated_field = "33682AAE42971F2215D5844A73451D2E")

    public static final Parcelable.Creator<FragmentState> CREATOR
            = new Parcelable.Creator<FragmentState>() {
        public FragmentState createFromParcel(Parcel in) {
            return new FragmentState(in);
        }
        
        public FragmentState[] newArray(int size) {
            return new FragmentState[size];
        }
    };
}

public class Fragment implements ComponentCallbacks2, OnCreateContextMenuListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "F6222ECFC0F3B677015F93D1974DAF06", hash_generated_field = "0294DD5CAC8ED58250DA531156A3A018")

    int mState = INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "BDE9D2B3E8C16F6173B11304E226AD48", hash_generated_field = "ECF8328501B577B29900A98481ADA801")

    Animator mAnimatingAway;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "8ED4FBC10C3DA2C5D7785F68532DB880", hash_generated_field = "AA12B8E459D536EFC9893454A513D5AA")

    int mStateAfterAnimating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "74933D8F8D085F6D27B373C3AD9FBBC4", hash_generated_field = "F958FB3998EC484A7599A988303CD216")

    Bundle mSavedFragmentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "2B7B591D0427765FF0500D38736CF518", hash_generated_field = "03C65AC0399DBB932968B6C681CFC16A")

    SparseArray<Parcelable> mSavedViewState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "DBDF7BB492A85A363C47FDDA34C5BB3E", hash_generated_field = "6B9186F1D8E9AA88F21C8B70F0B9BCC7")

    int mIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "7ECAB8F1DFD4D8C88111D51780B29562")

    String mWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "5867CE8CB088E58E6D17882F8EE91C5B", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

    Bundle mArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "14E7923C6D3468CDFB90940EBE370C56")

    Fragment mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "4FB974C217F7C6C42183BA9DEC8C9619", hash_generated_field = "B3D14A57A7194FB87F01321513F81187")

    int mTargetIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "9D7EC7B2039084EAAB4A7123EC5C6A65", hash_generated_field = "41D013C95CABF9ED0796F94F0CF16BD1")

    int mTargetRequestCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "CE47E8E592EB95BEB04FBBE625E99A8D")

    boolean mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.582 -0400", hash_original_field = "0F910DB84DA919CEA0C46A9368EB474F", hash_generated_field = "5C009156D3400624CB1FFDF310ECAFF1")

    boolean mRemoving;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "D9B77340C245436344B0149264025068", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

    boolean mFromLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "02B7C51C439DA5E343271787FAA8C822", hash_generated_field = "C7463435817ABA85E5AF0081505BD656")

    boolean mInLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "F6C00A288B07FAA85B83595F41C31C30", hash_generated_field = "83846FEEE5AB5B668E6D933F96FB7819")

    boolean mRestored;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "48F5E8D87678F372810B137CFF79CDEE", hash_generated_field = "6F8CF3ED6C0707B98B23B55A256300E6")

    int mBackStackNesting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "58A45AD5F2F241F335F9B1ED7D27DC02")

    FragmentManagerImpl mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "743B83D822DFF54AE7E24307CEF26F0C", hash_generated_field = "C628DB5A0351ABB6B2BC170D76A5FF43")

    int mFragmentId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "A2C9A3DA927DBE9AB0FC8FD8C7B637D9", hash_generated_field = "2072CAADE2B3735D2B37FDBC10B7F08E")

    int mContainerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

    String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "6E5D0646172E31357AC5264CFC6DCF7B", hash_generated_field = "DB81C7417E8D5BB2C252FB40F8D91CF8")

    boolean mHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "23906763A9631E67BD7C67265695AFF7", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

    boolean mDetached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "FC2473D51E767C5008A9D428BAFC8661", hash_generated_field = "907988FDE235BE080FDDB6DB36EF9C83")

    boolean mRetainInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.583 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "92B6BF5926849D268C59A8018D7DCB99", hash_generated_field = "98F2E6991F3565378DE3223CDDF9DBEB")

    boolean mHasMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "6E83E1BA32D4FE911AA4EE969D8C81B5", hash_generated_field = "91D8D4C712F4EB13688BF2F27B945286")

    boolean mMenuVisible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "8F73DC27B0DCA8E7133AEF9B7DBDC6C6", hash_generated_field = "6971FF9C6126C288092CCC2A5964E550")

    boolean mCalled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "B87B5DA5CC417CB9E4D2331FCCCAB736", hash_generated_field = "778908554529C0B97FC9B63E5B9208AD")

    int mNextAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "583453E78C87ED885A174C885F834BB6")

    ViewGroup mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "E8D35768AE7CD7313BEF15C635AC96D9", hash_generated_field = "A8819B0E70BA304D51F44F47380E8807")

    boolean mDeferStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "2BDAE98A0CD238891DE96CFCEED42070", hash_generated_field = "149FC5E47A37645F1FE824C1875916A8")

    boolean mUserVisibleHint = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.584 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    
    @DSModeled(DSC.SPEC)
	public Fragment() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.586 -0400", hash_original_method = "7271436905E3847D6FDF6326194EF06D", hash_generated_method = "7EB9B8EC75197E57FE61D13CEE5D39CF")
    final void restoreViewState() {
        if(mSavedViewState != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.586 -0400", hash_original_method = "681200A239FE58A0DC09757C2C18A7DD", hash_generated_method = "B448BCBE36D32968D956E06826A289AB")
    final void setIndex(int index) {
        mIndex = index;
        mWho = "android:fragment:" + mIndex;
        // ---------- Original Method ----------
        //mIndex = index;
        //mWho = "android:fragment:" + mIndex;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.586 -0400", hash_original_method = "B0D28796550366EF842F99A3D9D59C11", hash_generated_method = "EEC6C35D51B0289B102D8C452898BD99")
    final boolean isInBackStack() {
        boolean var62BC1991A682A21912C45ABC1AD98464_242342379 = (mBackStackNesting > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_300605436 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_300605436;
        // ---------- Original Method ----------
        //return mBackStackNesting > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.587 -0400", hash_original_method = "055C1CABEC6B90DB231CF8138F07B9C1", hash_generated_method = "43365B9C92566F98FAD322E5FD9A41F8")
    @Override
    final public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean varDBD7B5E32CCD38E45E29A8227EF381FE_1866068297 = (super.equals(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1168356467 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1168356467;
        // ---------- Original Method ----------
        //return super.equals(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.587 -0400", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "07B16D831330720B90A7BA5330C202B0")
    @Override
    final public int hashCode() {
        int var805ED14872F1C08E5C4314680FD405F0_1734127728 = (super.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515835909 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_515835909;
        // ---------- Original Method ----------
        //return super.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.588 -0400", hash_original_method = "5350708001683FB5244A4F612B80A27C", hash_generated_method = "87B4CAE0F467FA530292CCC983594E0B")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        if(mIndex >= 0)        
        {
            sb.append(" #");
            sb.append(mIndex);
        } //End block
        if(mFragmentId != 0)        
        {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(mFragmentId));
        } //End block
        if(mTag != null)        
        {
            sb.append(" ");
            sb.append(mTag);
        } //End block
        sb.append('}');
String var2460B846747F8B22185AD8BE722266A5_831737041 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_831737041.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_831737041;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.588 -0400", hash_original_method = "0D814DEC27C2F0AC661487D8C7B38979", hash_generated_method = "B571568042376A3A7030A36F4D53F661")
    final public int getId() {
        int var743B83D822DFF54AE7E24307CEF26F0C_650160804 = (mFragmentId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101649729 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1101649729;
        // ---------- Original Method ----------
        //return mFragmentId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.590 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "FA3FEC4EE31582C04D90CE91A32C5248")
    final public String getTag() {
String varD6A25044F8E609F6CD67330C1523D33D_1954454767 =         mTag;
        varD6A25044F8E609F6CD67330C1523D33D_1954454767.addTaint(taint);
        return varD6A25044F8E609F6CD67330C1523D33D_1954454767;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.590 -0400", hash_original_method = "2D5CF4DC8DE7FCC73C8073BFA7412800", hash_generated_method = "ED67BEF0D5495CBA1B01719F45D6DC36")
    public void setArguments(Bundle args) {
        if(mIndex >= 0)        
        {
            IllegalStateException varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_417777994 = new IllegalStateException("Fragment already active");
            varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_417777994.addTaint(taint);
            throw varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_417777994;
        } //End block
        mArguments = args;
        // ---------- Original Method ----------
        //if (mIndex >= 0) {
            //throw new IllegalStateException("Fragment already active");
        //}
        //mArguments = args;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.590 -0400", hash_original_method = "AD916C2ECBF1A5C9327A86449330505D", hash_generated_method = "E5CD936122B8D54B4A53EFFDC05A3D50")
    final public Bundle getArguments() {
Bundle varA1A5383052F874A8109F2B0284C0CCF1_943190428 =         mArguments;
        varA1A5383052F874A8109F2B0284C0CCF1_943190428.addTaint(taint);
        return varA1A5383052F874A8109F2B0284C0CCF1_943190428;
        // ---------- Original Method ----------
        //return mArguments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.592 -0400", hash_original_method = "D968C46759760C7406AC68A668D9806D", hash_generated_method = "CC4A261593AFA8861DD312F5FA2F3842")
    public void setInitialSavedState(SavedState state) {
        if(mIndex >= 0)        
        {
            IllegalStateException varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_1221774616 = new IllegalStateException("Fragment already active");
            varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_1221774616.addTaint(taint);
            throw varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_1221774616;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.593 -0400", hash_original_method = "1E1EC1C5F204666846AC7A8EC55494F6", hash_generated_method = "A9E9A3E67F9FE2F0071A3B399678868D")
    public void setTargetFragment(Fragment fragment, int requestCode) {
        mTarget = fragment;
        mTargetRequestCode = requestCode;
        // ---------- Original Method ----------
        //mTarget = fragment;
        //mTargetRequestCode = requestCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.594 -0400", hash_original_method = "CBC4FCF13CA2895C8D01438D1D6F6EE8", hash_generated_method = "8469EEA2E3CDE8A3B6ABF17DAD521A09")
    final public Fragment getTargetFragment() {
Fragment var1FC339B2A7C7BA226929CA8B7CC3A063_1038572251 =         mTarget;
        var1FC339B2A7C7BA226929CA8B7CC3A063_1038572251.addTaint(taint);
        return var1FC339B2A7C7BA226929CA8B7CC3A063_1038572251;
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.594 -0400", hash_original_method = "A4CEFC2C477EE57B614F4504E74127CE", hash_generated_method = "66869A5E86356D6392840A80B72A52F9")
    final public int getTargetRequestCode() {
        int var9D7EC7B2039084EAAB4A7123EC5C6A65_614161819 = (mTargetRequestCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440853818 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_440853818;
        // ---------- Original Method ----------
        //return mTargetRequestCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.594 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "497A9322D5464719835F24F0DE2DF38A")
    final public Activity getActivity() {
Activity var3D4F4FFFAA1A051817B4856E624EDB92_1422764358 =         mActivity;
        var3D4F4FFFAA1A051817B4856E624EDB92_1422764358.addTaint(taint);
        return var3D4F4FFFAA1A051817B4856E624EDB92_1422764358;
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.595 -0400", hash_original_method = "A8E18DB36BC334E1CF5901C727187C18", hash_generated_method = "6E3E4431F955216459126911E789BC5B")
    final public Resources getResources() {
        if(mActivity == null)        
        {
            IllegalStateException varE10E059A0DCA5D38245E5AD84C394857_273271268 = new IllegalStateException("Fragment " + this + " not attached to Activity");
            varE10E059A0DCA5D38245E5AD84C394857_273271268.addTaint(taint);
            throw varE10E059A0DCA5D38245E5AD84C394857_273271268;
        } //End block
Resources varAFF945874E0C096C77A2573F43D5E066_382424549 =         mActivity.getResources();
        varAFF945874E0C096C77A2573F43D5E066_382424549.addTaint(taint);
        return varAFF945874E0C096C77A2573F43D5E066_382424549;
        // ---------- Original Method ----------
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //return mActivity.getResources();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.595 -0400", hash_original_method = "3F649A13E84C6501035126B3FEE231F4", hash_generated_method = "B6B22E7940A0712B30810409F186D747")
    public final CharSequence getText(int resId) {
        addTaint(resId);
CharSequence var45D0E050A7463DA4235EAAF453BDEF8D_109861954 =         getResources().getText(resId);
        var45D0E050A7463DA4235EAAF453BDEF8D_109861954.addTaint(taint);
        return var45D0E050A7463DA4235EAAF453BDEF8D_109861954;
        // ---------- Original Method ----------
        //return getResources().getText(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.595 -0400", hash_original_method = "6096F9B7D678CAFA7D67C1784ABCB9A7", hash_generated_method = "3C77C26D7EF74C4617FB833856BD6E27")
    public final String getString(int resId) {
        addTaint(resId);
String varE43003255E2CDFE3A3F854C99DB3C345_925038652 =         getResources().getString(resId);
        varE43003255E2CDFE3A3F854C99DB3C345_925038652.addTaint(taint);
        return varE43003255E2CDFE3A3F854C99DB3C345_925038652;
        // ---------- Original Method ----------
        //return getResources().getString(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.596 -0400", hash_original_method = "524F00C5C13CBD3BD0D5C512A4C12294", hash_generated_method = "B119389EDE46FE66AEDCA67D331FAC77")
    public final String getString(int resId, Object... formatArgs) {
        addTaint(formatArgs[0].getTaint());
        addTaint(resId);
String var3E6B52F63767621631F101D027EAE3AD_1170993369 =         getResources().getString(resId, formatArgs);
        var3E6B52F63767621631F101D027EAE3AD_1170993369.addTaint(taint);
        return var3E6B52F63767621631F101D027EAE3AD_1170993369;
        // ---------- Original Method ----------
        //return getResources().getString(resId, formatArgs);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.596 -0400", hash_original_method = "ED1BD18F392C2062694622C1FF4A3A44", hash_generated_method = "6CAC85832F3F9E043CE33BFF17C17C08")
    final public FragmentManager getFragmentManager() {
FragmentManager var6B50C8B57F5F4DEB31C36FD27D426C18_764040067 =         mFragmentManager;
        var6B50C8B57F5F4DEB31C36FD27D426C18_764040067.addTaint(taint);
        return var6B50C8B57F5F4DEB31C36FD27D426C18_764040067;
        // ---------- Original Method ----------
        //return mFragmentManager;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.597 -0400", hash_original_method = "C0D74F5DDFD9A01C19E54F3379BA7652", hash_generated_method = "2130143EA2FC17F983E3B3A29AF882BC")
    final public boolean isAdded() {
        boolean var74BA28E0570A59B6D3A6A2107C73D4CF_860067140 = (mActivity != null && mAdded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_412474745 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_412474745;
        // ---------- Original Method ----------
        //return mActivity != null && mAdded;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.598 -0400", hash_original_method = "2F8509F8C4A8638224A8FC9748BC6275", hash_generated_method = "4AF66240DBBDFDF22912A006A4CD80E5")
    final public boolean isDetached() {
        boolean var23906763A9631E67BD7C67265695AFF7_1160266422 = (mDetached);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_833895367 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_833895367;
        // ---------- Original Method ----------
        //return mDetached;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.598 -0400", hash_original_method = "914BD43FF0612F84BA345FA6F486595C", hash_generated_method = "DBA60E06A27C49637C1587DA75E45A6E")
    final public boolean isRemoving() {
        boolean var0F910DB84DA919CEA0C46A9368EB474F_263675579 = (mRemoving);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1185502185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1185502185;
        // ---------- Original Method ----------
        //return mRemoving;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.599 -0400", hash_original_method = "3C6E7329283D3C6C46FB3F90EF65A4A7", hash_generated_method = "AACFF0FF9BC4301DB6307A7C6B7E4BEE")
    final public boolean isInLayout() {
        boolean var02B7C51C439DA5E343271787FAA8C822_2019660188 = (mInLayout);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1606161429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1606161429;
        // ---------- Original Method ----------
        //return mInLayout;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.599 -0400", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "1FC279F090CEC3C4A859F17EF08EF8AC")
    final public boolean isResumed() {
        boolean var9933B84C738DC45A33F44AE2EFCBD30F_1131302768 = (mResumed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_670646114 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_670646114;
        // ---------- Original Method ----------
        //return mResumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.599 -0400", hash_original_method = "72982976B71B01DF2412198462460DF0", hash_generated_method = "20F6F907B1E246F1D0256913271DB843")
    final public boolean isVisible() {
        boolean var68AFE6655C73AC0D5127DCFD89019FE3_1939168973 = (isAdded() && !isHidden() && mView != null
                && mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_334223401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_334223401;
        // ---------- Original Method ----------
        //return isAdded() && !isHidden() && mView != null
                //&& mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.600 -0400", hash_original_method = "E04FD968639295CCE5F791161EDE4496", hash_generated_method = "50A8BFAA8B540CF1C5A6678F395ACC91")
    final public boolean isHidden() {
        boolean var6E5D0646172E31357AC5264CFC6DCF7B_995214217 = (mHidden);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_684751053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_684751053;
        // ---------- Original Method ----------
        //return mHidden;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.600 -0400", hash_original_method = "FE8A5DF015D2662392185902D9D0AEDD", hash_generated_method = "764071413F7B945096A2936EA3340233")
    public void onHiddenChanged(boolean hidden) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hidden);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.600 -0400", hash_original_method = "8E671A431463BFA7D0F399C37FBCF1E9", hash_generated_method = "B4781DA0C58D757D98DF8D51D0581302")
    public void setRetainInstance(boolean retain) {
        mRetainInstance = retain;
        // ---------- Original Method ----------
        //mRetainInstance = retain;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.601 -0400", hash_original_method = "82A17104D5864E2285E97283523AA6C5", hash_generated_method = "80906ADE350E2A5ECC1E2778BDF8A807")
    final public boolean getRetainInstance() {
        boolean varFC2473D51E767C5008A9D428BAFC8661_1301571440 = (mRetainInstance);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713248691 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713248691;
        // ---------- Original Method ----------
        //return mRetainInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.601 -0400", hash_original_method = "A6D768E437C7421B050650CBF4A7B137", hash_generated_method = "F7881627FCD009171070D50385FA54DC")
    public void setHasOptionsMenu(boolean hasMenu) {
        if(mHasMenu != hasMenu)        
        {
            mHasMenu = hasMenu;
            if(isAdded() && !isHidden())            
            {
                mFragmentManager.invalidateOptionsMenu();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mHasMenu != hasMenu) {
            //mHasMenu = hasMenu;
            //if (isAdded() && !isHidden()) {
                //mFragmentManager.invalidateOptionsMenu();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.602 -0400", hash_original_method = "2CD00B5529D6A4CD9554A0275473942E", hash_generated_method = "B6E00C099B1CECD78D833EBEFD9049BE")
    public void setMenuVisibility(boolean menuVisible) {
        if(mMenuVisible != menuVisible)        
        {
            mMenuVisible = menuVisible;
            if(mHasMenu && isAdded() && !isHidden())            
            {
                mFragmentManager.invalidateOptionsMenu();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mMenuVisible != menuVisible) {
            //mMenuVisible = menuVisible;
            //if (mHasMenu && isAdded() && !isHidden()) {
                //mFragmentManager.invalidateOptionsMenu();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.602 -0400", hash_original_method = "1B0128696FF26E02ABF181CBEC60E7DF", hash_generated_method = "3217C29CFE54AADE49CE3CAC00762C1C")
    public void setUserVisibleHint(boolean isVisibleToUser) {
        if(!mUserVisibleHint && isVisibleToUser && mState < STARTED)        
        {
            mFragmentManager.performPendingDeferredStart(this);
        } //End block
        mUserVisibleHint = isVisibleToUser;
        mDeferStart = !isVisibleToUser;
        // ---------- Original Method ----------
        //if (!mUserVisibleHint && isVisibleToUser && mState < STARTED) {
            //mFragmentManager.performPendingDeferredStart(this);
        //}
        //mUserVisibleHint = isVisibleToUser;
        //mDeferStart = !isVisibleToUser;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.602 -0400", hash_original_method = "16570E728AF342CDACA5E18099682804", hash_generated_method = "DB1EF4BAB36897E7913E8F9D5D19620D")
    public boolean getUserVisibleHint() {
        boolean varB03D0E0FBB5C01B36684AC0EA4771924_1292467958 = (mUserVisibleHint);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239020405 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239020405;
        // ---------- Original Method ----------
        //return mUserVisibleHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.603 -0400", hash_original_method = "71C5851113530E9E497DE6FFC60D128C", hash_generated_method = "4CA2EDB9121B7AD4FB1258D2193FA181")
    public LoaderManager getLoaderManager() {
        if(mLoaderManager != null)        
        {
LoaderManager var805CC3710F0829AF609E93E575C2DA90_152214479 =             mLoaderManager;
            var805CC3710F0829AF609E93E575C2DA90_152214479.addTaint(taint);
            return var805CC3710F0829AF609E93E575C2DA90_152214479;
        } //End block
        if(mActivity == null)        
        {
            IllegalStateException varE10E059A0DCA5D38245E5AD84C394857_2123475968 = new IllegalStateException("Fragment " + this + " not attached to Activity");
            varE10E059A0DCA5D38245E5AD84C394857_2123475968.addTaint(taint);
            throw varE10E059A0DCA5D38245E5AD84C394857_2123475968;
        } //End block
        mCheckedForLoaderManager = true;
        mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, true);
LoaderManager var805CC3710F0829AF609E93E575C2DA90_579500914 =         mLoaderManager;
        var805CC3710F0829AF609E93E575C2DA90_579500914.addTaint(taint);
        return var805CC3710F0829AF609E93E575C2DA90_579500914;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.603 -0400", hash_original_method = "B68B30EDC5AB3BE8EF657FB7051C7F7E", hash_generated_method = "07342A9EC2CDFBE6FB1D0EC1FA995D99")
    public void startActivity(Intent intent) {
        addTaint(intent.getTaint());
        if(mActivity == null)        
        {
            IllegalStateException varE10E059A0DCA5D38245E5AD84C394857_1180930510 = new IllegalStateException("Fragment " + this + " not attached to Activity");
            varE10E059A0DCA5D38245E5AD84C394857_1180930510.addTaint(taint);
            throw varE10E059A0DCA5D38245E5AD84C394857_1180930510;
        } //End block
        mActivity.startActivityFromFragment(this, intent, -1);
        // ---------- Original Method ----------
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //mActivity.startActivityFromFragment(this, intent, -1);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.608 -0400", hash_original_method = "849399EB62F8B6EE6A6E550D7989B87C", hash_generated_method = "3DAFAD57D6797B6AFA24CE142495DEC4")
    public void startActivityForResult(Intent intent, int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
        if(mActivity == null)        
        {
            IllegalStateException varE10E059A0DCA5D38245E5AD84C394857_1202900523 = new IllegalStateException("Fragment " + this + " not attached to Activity");
            varE10E059A0DCA5D38245E5AD84C394857_1202900523.addTaint(taint);
            throw varE10E059A0DCA5D38245E5AD84C394857_1202900523;
        } //End block
        mActivity.startActivityFromFragment(this, intent, requestCode);
        // ---------- Original Method ----------
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //mActivity.startActivityFromFragment(this, intent, requestCode);
    }

    
    @DSModeled(DSC.SPEC)
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.611 -0400", hash_original_method = "8FF008E86C71DF2CF57F1B9E3E9D8CD9", hash_generated_method = "C6C39EB4CCA4D8B7580440C89EAF15CF")
    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
LayoutInflater varC8F1AD9F765410CD70DB0833DE90DA27_1175352203 =         mActivity.getLayoutInflater();
        varC8F1AD9F765410CD70DB0833DE90DA27_1175352203.addTaint(taint);
        return varC8F1AD9F765410CD70DB0833DE90DA27_1175352203;
        // ---------- Original Method ----------
        //return mActivity.getLayoutInflater();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.612 -0400", hash_original_method = "B81B691062FF851E8B34D981FF83329F", hash_generated_method = "34714B2D26F8F12A9BEA730EF5CE9995")
    @Deprecated
    public void onInflate(AttributeSet attrs, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(attrs.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.612 -0400", hash_original_method = "295D90877B0CE50D1EC7F89F1D4EC254", hash_generated_method = "CF67F2C79409671D1399EE55A473BEC4")
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(attrs.getTaint());
        addTaint(activity.getTaint());
        onInflate(attrs, savedInstanceState);
        mCalled = true;
        // ---------- Original Method ----------
        //onInflate(attrs, savedInstanceState);
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.613 -0400", hash_original_method = "7FCB8118913FF635CB1CDE717E61023E", hash_generated_method = "800CFB085D8824BBFB5C33269F30F63C")
    public void onAttach(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(activity.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.613 -0400", hash_original_method = "EB97CF4ACDD4FD35B8071D1AF529F576", hash_generated_method = "C5ACF5AC8984D0AA18EC2DC5547A06C5")
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(nextAnim);
        addTaint(enter);
        addTaint(transit);
Animator var540C13E9E156B687226421B24F2DF178_1614417778 =         null;
        var540C13E9E156B687226421B24F2DF178_1614417778.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1614417778;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.614 -0400", hash_original_method = "00494AECA41C1730DF6E82548FC2C3D5", hash_generated_method = "4CCDB0DCFFB66173622F366FF1BCFCBE")
    public void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.614 -0400", hash_original_method = "F4318A499F9B06ABC9CCF0644AE6DC10", hash_generated_method = "52769EFA20AE14D9C5042204CED1C380")
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SPEC)
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//return null;
		return new View(container.getContext());
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.615 -0400", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "148CB6EF88EBFF98445993AE0E6615C4")
    public View getView() {
View var2A050D4EA4182130A6C1E6806618CCD0_1645929206 =         mView;
        var2A050D4EA4182130A6C1E6806618CCD0_1645929206.addTaint(taint);
        return var2A050D4EA4182130A6C1E6806618CCD0_1645929206;
        // ---------- Original Method ----------
        //return mView;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.616 -0400", hash_original_method = "C52625884C98429BE8DE42F4FBFE7367", hash_generated_method = "E2F05B6742F9D7E8DC9825D8FC2D9F9A")
    public void onActivityCreated(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.617 -0400", hash_original_method = "4BDF3B44AFE0C3B519B659689A5EE977", hash_generated_method = "D4A312E73DF67FA0FF56CF85862ADBB8")
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        if(!mLoadersStarted)        
        {
            mLoadersStarted = true;
            if(!mCheckedForLoaderManager)            
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            } //End block
            if(mLoaderManager != null)            
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.617 -0400", hash_original_method = "3B8608ED59C2663D271D57F8D8F534C0", hash_generated_method = "A35C9648644440B1AB73336CCB6DEAB5")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.618 -0400", hash_original_method = "9C4F98F3F5A4FCEFF66E261EDA5693F3", hash_generated_method = "AD15648AB8B6357D84B3060587BAA98F")
    public void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.618 -0400", hash_original_method = "16A05561D5415124B893EA7E2AFB953D", hash_generated_method = "A984469EBDCC0902B8851BB94C61A9EF")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.618 -0400", hash_original_method = "CEF2FF1DA31E7EE9D761807A037B37B2", hash_generated_method = "637684B70754E8D79E076DC6A513E031")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.619 -0400", hash_original_method = "FC062A9ECA017F6E5D455E8C973942F9", hash_generated_method = "7E26AAA6FA11DEDE75C340853A5FC7A3")
    public void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
	}

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.620 -0400", hash_original_method = "E1E8CF8B1FBB3E8165C3219A9D0BB675", hash_generated_method = "A78B21B429C60FF0208280A2579E86CA")
    public void onTrimMemory(int level) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(level);
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.620 -0400", hash_original_method = "E54F17C7BAFD082A48D2152349C1815A", hash_generated_method = "D6DBBF3121DDE73B3DDC3BCBF558AE8E")
    public void onDestroyView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.620 -0400", hash_original_method = "AA4E137E24C2C382652C9FBA94B1ED31", hash_generated_method = "D2B1A11FFA3E12AD4D6638D4EEE374A3")
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        if(!mCheckedForLoaderManager)        
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
        } //End block
        if(mLoaderManager != null)        
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.623 -0400", hash_original_method = "04633BF5293F80973E1AA355DB2C35EF", hash_generated_method = "4C027456133F87915A9EF12926708CE0")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.624 -0400", hash_original_method = "EF609D2FD1394DFBC19807CB21AD7D10", hash_generated_method = "CD3AD86EF54BB27DA72F7E9F9B9DEA15")
    public void onDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.625 -0400", hash_original_method = "B3C5F3D019B47C47E6111F1C7C38CA5D", hash_generated_method = "CD3DE4D46F4897BB6058BF519EF6DB27")
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(inflater.getTaint());
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.625 -0400", hash_original_method = "4CE703F4C1FA6FC474411DFE6A3F5275", hash_generated_method = "32B650DEFAD74BF60D957C3D22EC9F79")
    public void onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.626 -0400", hash_original_method = "0E8C037F224061747BFFD0611606AAB6", hash_generated_method = "EF044D3D33EBB476DBBCFB32576782C1")
    public void onDestroyOptionsMenu() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.626 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "31F672E3D68D5474B943C02E5E403DB2")
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1966755619 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590542407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_590542407;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.627 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "CC9F879215C8D6911F3F43FE45124EF9")
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.627 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "A6804032F4A398F98AB72F29BB096EED")
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(this);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.628 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "00514E90EA9081E765956475D78499EF")
    public void unregisterForContextMenu(View view) {
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(null);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.628 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "2A554FFC0739959BF74D8E38264664E7")
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_2011894615 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_793136772 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_793136772;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.630 -0400", hash_original_method = "C78D4ECAA9BAFBCD9E78657D4224F582", hash_generated_method = "57F9E93EF57DD9E26535A7181D3B3FAC")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
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
        if(mFragmentManager != null)        
        {
            writer.print(prefix);
            writer.print("mFragmentManager=");
            writer.println(mFragmentManager);
        } //End block
        if(mActivity != null)        
        {
            writer.print(prefix);
            writer.print("mActivity=");
            writer.println(mActivity);
        } //End block
        if(mArguments != null)        
        {
            writer.print(prefix);
            writer.print("mArguments=");
            writer.println(mArguments);
        } //End block
        if(mSavedFragmentState != null)        
        {
            writer.print(prefix);
            writer.print("mSavedFragmentState=");
            writer.println(mSavedFragmentState);
        } //End block
        if(mSavedViewState != null)        
        {
            writer.print(prefix);
            writer.print("mSavedViewState=");
            writer.println(mSavedViewState);
        } //End block
        if(mTarget != null)        
        {
            writer.print(prefix);
            writer.print("mTarget=");
            writer.print(mTarget);
            writer.print(" mTargetRequestCode=");
            writer.println(mTargetRequestCode);
        } //End block
        if(mNextAnim != 0)        
        {
            writer.print(prefix);
            writer.print("mNextAnim=");
            writer.println(mNextAnim);
        } //End block
        if(mContainer != null)        
        {
            writer.print(prefix);
            writer.print("mContainer=");
            writer.println(mContainer);
        } //End block
        if(mView != null)        
        {
            writer.print(prefix);
            writer.print("mView=");
            writer.println(mView);
        } //End block
        if(mAnimatingAway != null)        
        {
            writer.print(prefix);
            writer.print("mAnimatingAway=");
            writer.println(mAnimatingAway);
            writer.print(prefix);
            writer.print("mStateAfterAnimating=");
            writer.println(mStateAfterAnimating);
        } //End block
        if(mLoaderManager != null)        
        {
            writer.print(prefix);
            writer.println("Loader Manager:");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.630 -0400", hash_original_method = "A194798DFC3B633DD6139CF302E65474", hash_generated_method = "DE050DE790A8F52418E86D0E14817090")
     void performStart() {
        onStart();
        if(mLoaderManager != null)        
        {
            mLoaderManager.doReportStart();
        } //End block
        // ---------- Original Method ----------
        //onStart();
        //if (mLoaderManager != null) {
            //mLoaderManager.doReportStart();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.631 -0400", hash_original_method = "DF7E450C96FF033A1F96B7AC1D56EC13", hash_generated_method = "B6DD8723BA598962065C4841BB80BA98")
     void performStop() {
        onStop();
        if(mLoadersStarted)        
        {
            mLoadersStarted = false;
            if(!mCheckedForLoaderManager)            
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            } //End block
            if(mLoaderManager != null)            
            {
                if(mActivity == null || !mActivity.mChangingConfigurations)                
                {
                    mLoaderManager.doStop();
                } //End block
                else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.631 -0400", hash_original_method = "3EF3D6E87A549E78C03CB36A1B3A62F5", hash_generated_method = "3A1181A2EBF492EB97B9ED1B3E9FDD30")
     void performDestroyView() {
        onDestroyView();
        if(mLoaderManager != null)        
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.631 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "AA4A80FE6E8C28CFC04031C8CFFC3C9D")

        Bundle mState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.632 -0400", hash_original_method = "7D4CB1BC3C04B99DC21EA19CB6BAF4D3", hash_generated_method = "BAE726BCB2EFD4A0280978447E5417B6")
          SavedState(Bundle state) {
            mState = state;
            // ---------- Original Method ----------
            //mState = state;
        }

        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.632 -0400", hash_original_method = "E611F4C5C5E159704631D93ABD994DEF", hash_generated_method = "D25353096B5344EC0F39CEF0AD4F19B4")
          SavedState(Parcel in, ClassLoader loader) {
            addTaint(loader.getTaint());
            mState = in.readBundle();
            if(loader != null && mState != null)            
            {
                mState.setClassLoader(loader);
            } //End block
            // ---------- Original Method ----------
            //mState = in.readBundle();
            //if (loader != null && mState != null) {
                //mState.setClassLoader(loader);
            //}
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.633 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C6DD93393C96B3AF9FC69BEEB6AD7DAD")
        @Override
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1294451877 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608130096 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1608130096;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.633 -0400", hash_original_method = "ACF88B4EF312D321A4777388A96F3566", hash_generated_method = "1C039FAE169046CF463468B90B998E91")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeBundle(mState);
            // ---------- Original Method ----------
            //dest.writeBundle(mState);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.633 -0400", hash_original_field = "8C0168FE172D1D9B33F36BA223FF422A", hash_generated_field = "2999E0A81FA5064B37A7DD9A52DB7607")

        public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR
                = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, null);
            }

            public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    static public class InstantiationException extends AndroidRuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.634 -0400", hash_original_method = "9A59F9C8F177B5B07F720376B1CE8BCE", hash_generated_method = "49CEDFFAD9ABDDBE0ED0991ADFD6BC85")
        public  InstantiationException(String msg, Exception cause) {
            super(msg, cause);
            addTaint(cause.getTaint());
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.634 -0400", hash_original_field = "24A48BEA88D09CCBC63A8677385B95A8", hash_generated_field = "EB0A976F34844AD55F975EEF50A2B1A3")

    private static final HashMap<String, Class<?>> sClassMap = new HashMap<String, Class<?>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.634 -0400", hash_original_field = "5F5168BFEDD28A94E86FDF26F95BEA11", hash_generated_field = "5C75B850D43361B9311F957A4D0AF174")

    static final int INVALID_STATE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.634 -0400", hash_original_field = "403EB1653B87B88BD21AEF72194EF5E0", hash_generated_field = "B9FFABD80C3D80703D84376667A75609")

    static final int INITIALIZING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.634 -0400", hash_original_field = "6EFDDF5DE9E2142D56B3E098F844AE40", hash_generated_field = "97B36236CFE06BD1C50B96E10CE241B6")

    static final int CREATED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.634 -0400", hash_original_field = "18C3D4E620F8352BDF3CA097C14B87F7", hash_generated_field = "00E5F9933DCF6CD0A60E606E52C7FADE")

    static final int ACTIVITY_CREATED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.634 -0400", hash_original_field = "456918D615E944292D78BC88E852291C", hash_generated_field = "2CEA28884A245A0CE49FCF31D0D6588D")

    static final int STOPPED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.634 -0400", hash_original_field = "C604B9D3F56F632433E5FA0C79127BB7", hash_generated_field = "4F033F865040D83003D856BED757C437")

    static final int STARTED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:32.634 -0400", hash_original_field = "FF953E97A61C82A8BD259E088591325D", hash_generated_field = "562F93666D34FFE3A5D8899053C80C4E")

    static final int RESUMED = 5;
    
}

=======
package android.app;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Fragment implements ComponentCallbacks2, OnCreateContextMenuListener {

	@DSModeled	
	public Fragment() {
		onCreateView(new LayoutInflater(), null, null);
	}
	
	@DSModeled
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//return null;
		return new View(container.getContext());
		
	}
	
	@Override
	public void onConfigurationChanged(Configuration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTrimMemory(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@DSModeled
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
	}
	
	@DSModeled(DSC.SAFE)
	public final String getString(int resId) {
		String str = new String();
        str.addTaint(resId);
        return str;
	}
	
	@DSModeled(DSC.SAFE)
	public final CharSequence getText(int resId) {
        String str = new String();
        str.addTaint(resId);
        return str;
	}

}
>>>>>>> 8fdd67c83362d24a856c797451a83e8b845ae472
