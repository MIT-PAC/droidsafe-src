package android.support.v4.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.DebugUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnCreateContextMenuListener;
import android.view.animation.Animation;
import android.widget.AdapterView;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;

final class FragmentState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "6BC238A3BDD37BF1CAC26EA2CE45C508")

    String mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "D9B77340C245436344B0149264025068", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

    boolean mFromLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "743B83D822DFF54AE7E24307CEF26F0C", hash_generated_field = "C628DB5A0351ABB6B2BC170D76A5FF43")

    int mFragmentId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "A2C9A3DA927DBE9AB0FC8FD8C7B637D9", hash_generated_field = "2072CAADE2B3735D2B37FDBC10B7F08E")

    int mContainerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

    String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "FC2473D51E767C5008A9D428BAFC8661", hash_generated_field = "907988FDE235BE080FDDB6DB36EF9C83")

    boolean mRetainInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "23906763A9631E67BD7C67265695AFF7", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

    boolean mDetached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "5867CE8CB088E58E6D17882F8EE91C5B", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

    Bundle mArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "74933D8F8D085F6D27B373C3AD9FBBC4", hash_generated_field = "F958FB3998EC484A7599A988303CD216")

    Bundle mSavedFragmentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.922 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "F83F5A158F2251FA12452672DC97E470")

    Fragment mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.924 -0400", hash_original_method = "116485142A61C36D4B47DBE9BCB45890", hash_generated_method = "9C8B1F3AA1DA7C8FAE9B803347EE426A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.925 -0400", hash_original_method = "46F838C8877526D395D980C698E03728", hash_generated_method = "1AEC5D39B1C46172E66E2ADE1F21E5F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.927 -0400", hash_original_method = "929295C14EE92A06097EEC5737CFE8E9", hash_generated_method = "4DDBACDB7C511477851976ABF232A58E")
    public Fragment instantiate(FragmentActivity activity, Fragment parent) {
        addTaint(parent.getTaint());
        if(mInstance != null)        
        {
Fragment var01A4E1572BEF98558ED7F4E845C07CFE_642766112 =             mInstance;
            var01A4E1572BEF98558ED7F4E845C07CFE_642766112.addTaint(taint);
            return var01A4E1572BEF98558ED7F4E845C07CFE_642766112;
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
        mInstance.setIndex(mIndex, parent);
        mInstance.mFromLayout = mFromLayout;
        mInstance.mRestored = true;
        mInstance.mFragmentId = mFragmentId;
        mInstance.mContainerId = mContainerId;
        mInstance.mTag = mTag;
        mInstance.mRetainInstance = mRetainInstance;
        mInstance.mDetached = mDetached;
        mInstance.mFragmentManager = activity.mFragments;
        if(FragmentManagerImpl.DEBUG){ }Fragment var01A4E1572BEF98558ED7F4E845C07CFE_676918776 =         mInstance;
        var01A4E1572BEF98558ED7F4E845C07CFE_676918776.addTaint(taint);
        return var01A4E1572BEF98558ED7F4E845C07CFE_676918776;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.927 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "1324CFD1E5ACFAB12CFC532780B28DCE")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_55336600 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890109021 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_890109021;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.927 -0400", hash_original_method = "5938F2E0A344A05A5347D3909CB444C6", hash_generated_method = "7021DC69993F7F0B884899058516CB7A")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.927 -0400", hash_original_field = "20C24B13B86A2BA0167AA1764B64C330", hash_generated_field = "33682AAE42971F2215D5844A73451D2E")

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

public class Fragment implements ComponentCallbacks, OnCreateContextMenuListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.928 -0400", hash_original_field = "F6222ECFC0F3B677015F93D1974DAF06", hash_generated_field = "0294DD5CAC8ED58250DA531156A3A018")

    int mState = INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.928 -0400", hash_original_field = "BDE9D2B3E8C16F6173B11304E226AD48", hash_generated_field = "5A7CC416AE8E502EE87A452D06D4A6F4")

    View mAnimatingAway;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.928 -0400", hash_original_field = "8ED4FBC10C3DA2C5D7785F68532DB880", hash_generated_field = "AA12B8E459D536EFC9893454A513D5AA")

    int mStateAfterAnimating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.928 -0400", hash_original_field = "74933D8F8D085F6D27B373C3AD9FBBC4", hash_generated_field = "F958FB3998EC484A7599A988303CD216")

    Bundle mSavedFragmentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.928 -0400", hash_original_field = "2B7B591D0427765FF0500D38736CF518", hash_generated_field = "03C65AC0399DBB932968B6C681CFC16A")

    SparseArray<Parcelable> mSavedViewState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "DBDF7BB492A85A363C47FDDA34C5BB3E", hash_generated_field = "6B9186F1D8E9AA88F21C8B70F0B9BCC7")

    int mIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "7ECAB8F1DFD4D8C88111D51780B29562")

    String mWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "5867CE8CB088E58E6D17882F8EE91C5B", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

    Bundle mArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "14E7923C6D3468CDFB90940EBE370C56")

    Fragment mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "4FB974C217F7C6C42183BA9DEC8C9619", hash_generated_field = "B3D14A57A7194FB87F01321513F81187")

    int mTargetIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "9D7EC7B2039084EAAB4A7123EC5C6A65", hash_generated_field = "41D013C95CABF9ED0796F94F0CF16BD1")

    int mTargetRequestCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "CE47E8E592EB95BEB04FBBE625E99A8D")

    boolean mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "0F910DB84DA919CEA0C46A9368EB474F", hash_generated_field = "5C009156D3400624CB1FFDF310ECAFF1")

    boolean mRemoving;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "D9B77340C245436344B0149264025068", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

    boolean mFromLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "02B7C51C439DA5E343271787FAA8C822", hash_generated_field = "C7463435817ABA85E5AF0081505BD656")

    boolean mInLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "F6C00A288B07FAA85B83595F41C31C30", hash_generated_field = "83846FEEE5AB5B668E6D933F96FB7819")

    boolean mRestored;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "48F5E8D87678F372810B137CFF79CDEE", hash_generated_field = "6F8CF3ED6C0707B98B23B55A256300E6")

    int mBackStackNesting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "58A45AD5F2F241F335F9B1ED7D27DC02")

    FragmentManagerImpl mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "DC6970CAF75184DB6DB1AAC52EA720C0")

    FragmentActivity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "16580FFD258A8A6FD12273C56DB3BF65", hash_generated_field = "AE50D4C4DA0E1D5FC77314F7EF03878D")

    FragmentManagerImpl mChildFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.929 -0400", hash_original_field = "B718B1EF16C11B894ED91B7026350839", hash_generated_field = "9348AE179085F33BE67C4C84253837E6")

    Fragment mParentFragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "743B83D822DFF54AE7E24307CEF26F0C", hash_generated_field = "C628DB5A0351ABB6B2BC170D76A5FF43")

    int mFragmentId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "A2C9A3DA927DBE9AB0FC8FD8C7B637D9", hash_generated_field = "2072CAADE2B3735D2B37FDBC10B7F08E")

    int mContainerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

    String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "6E5D0646172E31357AC5264CFC6DCF7B", hash_generated_field = "DB81C7417E8D5BB2C252FB40F8D91CF8")

    boolean mHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "23906763A9631E67BD7C67265695AFF7", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

    boolean mDetached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "FC2473D51E767C5008A9D428BAFC8661", hash_generated_field = "907988FDE235BE080FDDB6DB36EF9C83")

    boolean mRetainInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "92B6BF5926849D268C59A8018D7DCB99", hash_generated_field = "98F2E6991F3565378DE3223CDDF9DBEB")

    boolean mHasMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "6E83E1BA32D4FE911AA4EE969D8C81B5", hash_generated_field = "91D8D4C712F4EB13688BF2F27B945286")

    boolean mMenuVisible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "8F73DC27B0DCA8E7133AEF9B7DBDC6C6", hash_generated_field = "6971FF9C6126C288092CCC2A5964E550")

    boolean mCalled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "B87B5DA5CC417CB9E4D2331FCCCAB736", hash_generated_field = "778908554529C0B97FC9B63E5B9208AD")

    int mNextAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "583453E78C87ED885A174C885F834BB6")

    ViewGroup mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "77F7C832CCC3D571F9FC590C7CFA715C", hash_generated_field = "02054D032013112C607BBD1766707DC1")

    View mInnerView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "E8D35768AE7CD7313BEF15C635AC96D9", hash_generated_field = "A8819B0E70BA304D51F44F47380E8807")

    boolean mDeferStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "2BDAE98A0CD238891DE96CFCEED42070", hash_generated_field = "149FC5E47A37645F1FE824C1875916A8")

    boolean mUserVisibleHint = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.930 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.931 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.931 -0400", hash_original_method = "450DCF9C44ABD4359E904BF858920888", hash_generated_method = "AF7EF93C180462CAFE5DFDA53E9C7DDF")
    public  Fragment() {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.932 -0400", hash_original_method = "245153A377A25A4032F77A4E144CB5DC", hash_generated_method = "17602F604F6F56AC538B531B7F2302CD")
    final void restoreViewState(Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        if(mSavedViewState != null)        
        {
            mInnerView.restoreHierarchyState(mSavedViewState);
            mSavedViewState = null;
        } //End block
        mCalled = false;
        onViewStateRestored(savedInstanceState);
        if(!mCalled)        
        {
            SuperNotCalledException varDBA29A0AE0F369EE974A1B62EAC77C4F_828316810 = new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onViewStateRestored()");
            varDBA29A0AE0F369EE974A1B62EAC77C4F_828316810.addTaint(taint);
            throw varDBA29A0AE0F369EE974A1B62EAC77C4F_828316810;
        } //End block
        // ---------- Original Method ----------
        //if (mSavedViewState != null) {
            //mInnerView.restoreHierarchyState(mSavedViewState);
            //mSavedViewState = null;
        //}
        //mCalled = false;
        //onViewStateRestored(savedInstanceState);
        //if (!mCalled) {
            //throw new SuperNotCalledException("Fragment " + this
                    //+ " did not call through to super.onViewStateRestored()");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.933 -0400", hash_original_method = "57A747EE3041ECA2E14E3727F10963D8", hash_generated_method = "DBB0188AE9379D299ADEC0BEA637A956")
    final void setIndex(int index, Fragment parent) {
        mIndex = index;
        if(parent != null)        
        {
            mWho = parent.mWho + ":" + mIndex;
        } //End block
        else
        {
            mWho = "android:fragment:" + mIndex;
        } //End block
        // ---------- Original Method ----------
        //mIndex = index;
        //if (parent != null) {
            //mWho = parent.mWho + ":" + mIndex;
        //} else {
            //mWho = "android:fragment:" + mIndex;
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.933 -0400", hash_original_method = "B0D28796550366EF842F99A3D9D59C11", hash_generated_method = "9804D2645561EE85CDD985D54486B62F")
    final boolean isInBackStack() {
        boolean var62BC1991A682A21912C45ABC1AD98464_50180168 = (mBackStackNesting > 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1244875791 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1244875791;
        // ---------- Original Method ----------
        //return mBackStackNesting > 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.933 -0400", hash_original_method = "055C1CABEC6B90DB231CF8138F07B9C1", hash_generated_method = "E0FE1C3575074E3D551DBC25CA1BE9E7")
    @Override
    final public boolean equals(Object o) {
        addTaint(o.getTaint());
        boolean varDBD7B5E32CCD38E45E29A8227EF381FE_194338361 = (super.equals(o));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1691219939 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1691219939;
        // ---------- Original Method ----------
        //return super.equals(o);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.933 -0400", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "0D4A7D8C98E3AF98A5355D45F12A9101")
    @Override
    final public int hashCode() {
        int var805ED14872F1C08E5C4314680FD405F0_1107365089 = (super.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692635237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1692635237;
        // ---------- Original Method ----------
        //return super.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.934 -0400", hash_original_method = "5350708001683FB5244A4F612B80A27C", hash_generated_method = "75C34B507B7FA902D0E2ED407CDCA979")
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
String var2460B846747F8B22185AD8BE722266A5_1437115054 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1437115054.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1437115054;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.934 -0400", hash_original_method = "0D814DEC27C2F0AC661487D8C7B38979", hash_generated_method = "B9BEC09707D96C5D0EA64EAB9450F689")
    final public int getId() {
        int var743B83D822DFF54AE7E24307CEF26F0C_1494752473 = (mFragmentId);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_362720121 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_362720121;
        // ---------- Original Method ----------
        //return mFragmentId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.934 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "FB77CC358A646B4C62EB5BE9DD8FF2A5")
    final public String getTag() {
String varD6A25044F8E609F6CD67330C1523D33D_398587615 =         mTag;
        varD6A25044F8E609F6CD67330C1523D33D_398587615.addTaint(taint);
        return varD6A25044F8E609F6CD67330C1523D33D_398587615;
        // ---------- Original Method ----------
        //return mTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.934 -0400", hash_original_method = "2D5CF4DC8DE7FCC73C8073BFA7412800", hash_generated_method = "153361B2F87B5F2C549A6264694D63D0")
    public void setArguments(Bundle args) {
        if(mIndex >= 0)        
        {
            IllegalStateException varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_619708822 = new IllegalStateException("Fragment already active");
            varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_619708822.addTaint(taint);
            throw varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_619708822;
        } //End block
        mArguments = args;
        // ---------- Original Method ----------
        //if (mIndex >= 0) {
            //throw new IllegalStateException("Fragment already active");
        //}
        //mArguments = args;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.934 -0400", hash_original_method = "AD916C2ECBF1A5C9327A86449330505D", hash_generated_method = "43EC829EE444A17F6955F069CA4D8D3A")
    final public Bundle getArguments() {
Bundle varA1A5383052F874A8109F2B0284C0CCF1_484649020 =         mArguments;
        varA1A5383052F874A8109F2B0284C0CCF1_484649020.addTaint(taint);
        return varA1A5383052F874A8109F2B0284C0CCF1_484649020;
        // ---------- Original Method ----------
        //return mArguments;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.934 -0400", hash_original_method = "D968C46759760C7406AC68A668D9806D", hash_generated_method = "4D6B3F4E9C344B4A0A05637C82D728A4")
    public void setInitialSavedState(SavedState state) {
        if(mIndex >= 0)        
        {
            IllegalStateException varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_160260641 = new IllegalStateException("Fragment already active");
            varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_160260641.addTaint(taint);
            throw varDE71ABC2C56EA5E7A2AE33BAFF59F1E4_160260641;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.934 -0400", hash_original_method = "1E1EC1C5F204666846AC7A8EC55494F6", hash_generated_method = "A9E9A3E67F9FE2F0071A3B399678868D")
    public void setTargetFragment(Fragment fragment, int requestCode) {
        mTarget = fragment;
        mTargetRequestCode = requestCode;
        // ---------- Original Method ----------
        //mTarget = fragment;
        //mTargetRequestCode = requestCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.934 -0400", hash_original_method = "CBC4FCF13CA2895C8D01438D1D6F6EE8", hash_generated_method = "C5C64004E0107BC3B5ACDC7B879D2A79")
    final public Fragment getTargetFragment() {
Fragment var1FC339B2A7C7BA226929CA8B7CC3A063_425877671 =         mTarget;
        var1FC339B2A7C7BA226929CA8B7CC3A063_425877671.addTaint(taint);
        return var1FC339B2A7C7BA226929CA8B7CC3A063_425877671;
        // ---------- Original Method ----------
        //return mTarget;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.935 -0400", hash_original_method = "A4CEFC2C477EE57B614F4504E74127CE", hash_generated_method = "6C03F56ADCA7BB7F0B29B7C52D21B130")
    final public int getTargetRequestCode() {
        int var9D7EC7B2039084EAAB4A7123EC5C6A65_1851310600 = (mTargetRequestCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443716068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1443716068;
        // ---------- Original Method ----------
        //return mTargetRequestCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.935 -0400", hash_original_method = "A48A2A81AB5F981679BE8C3496B55E59", hash_generated_method = "4FD5483870C41CF02FC829A0DA28CFDE")
    final public FragmentActivity getActivity() {
FragmentActivity var3D4F4FFFAA1A051817B4856E624EDB92_1489595360 =         mActivity;
        var3D4F4FFFAA1A051817B4856E624EDB92_1489595360.addTaint(taint);
        return var3D4F4FFFAA1A051817B4856E624EDB92_1489595360;
        // ---------- Original Method ----------
        //return mActivity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.935 -0400", hash_original_method = "A8E18DB36BC334E1CF5901C727187C18", hash_generated_method = "512D238CDF426830C410ED9DA2F56BD0")
    final public Resources getResources() {
        if(mActivity == null)        
        {
            IllegalStateException varE10E059A0DCA5D38245E5AD84C394857_709006124 = new IllegalStateException("Fragment " + this + " not attached to Activity");
            varE10E059A0DCA5D38245E5AD84C394857_709006124.addTaint(taint);
            throw varE10E059A0DCA5D38245E5AD84C394857_709006124;
        } //End block
Resources varAFF945874E0C096C77A2573F43D5E066_1090600867 =         mActivity.getResources();
        varAFF945874E0C096C77A2573F43D5E066_1090600867.addTaint(taint);
        return varAFF945874E0C096C77A2573F43D5E066_1090600867;
        // ---------- Original Method ----------
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //return mActivity.getResources();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.935 -0400", hash_original_method = "3F649A13E84C6501035126B3FEE231F4", hash_generated_method = "F4DA898DCD7E083EDED67C84F1A475F1")
    public final CharSequence getText(int resId) {
        addTaint(resId);
CharSequence var45D0E050A7463DA4235EAAF453BDEF8D_969315113 =         getResources().getText(resId);
        var45D0E050A7463DA4235EAAF453BDEF8D_969315113.addTaint(taint);
        return var45D0E050A7463DA4235EAAF453BDEF8D_969315113;
        // ---------- Original Method ----------
        //return getResources().getText(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.935 -0400", hash_original_method = "6096F9B7D678CAFA7D67C1784ABCB9A7", hash_generated_method = "FFE7A415AC880C88B075249FEAC0A392")
    public final String getString(int resId) {
        addTaint(resId);
String varE43003255E2CDFE3A3F854C99DB3C345_511716956 =         getResources().getString(resId);
        varE43003255E2CDFE3A3F854C99DB3C345_511716956.addTaint(taint);
        return varE43003255E2CDFE3A3F854C99DB3C345_511716956;
        // ---------- Original Method ----------
        //return getResources().getString(resId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.935 -0400", hash_original_method = "524F00C5C13CBD3BD0D5C512A4C12294", hash_generated_method = "1F15E5305BB5260F619F232B14DDAD32")
    public final String getString(int resId, Object... formatArgs) {
        addTaint(formatArgs[0].getTaint());
        addTaint(resId);
String var3E6B52F63767621631F101D027EAE3AD_561553166 =         getResources().getString(resId, formatArgs);
        var3E6B52F63767621631F101D027EAE3AD_561553166.addTaint(taint);
        return var3E6B52F63767621631F101D027EAE3AD_561553166;
        // ---------- Original Method ----------
        //return getResources().getString(resId, formatArgs);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.935 -0400", hash_original_method = "ED1BD18F392C2062694622C1FF4A3A44", hash_generated_method = "F069BC6BD1818751B781B54880EBCAE4")
    final public FragmentManager getFragmentManager() {
FragmentManager var6B50C8B57F5F4DEB31C36FD27D426C18_1950320259 =         mFragmentManager;
        var6B50C8B57F5F4DEB31C36FD27D426C18_1950320259.addTaint(taint);
        return var6B50C8B57F5F4DEB31C36FD27D426C18_1950320259;
        // ---------- Original Method ----------
        //return mFragmentManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.935 -0400", hash_original_method = "CC97C175240EBBDE3DE45127B977288B", hash_generated_method = "FBA4508C43D0AACCBAC08F7586B00CDF")
    final public FragmentManager getChildFragmentManager() {
        if(mChildFragmentManager == null)        
        {
            instantiateChildFragmentManager();
            if(mState >= RESUMED)            
            {
                mChildFragmentManager.dispatchResume();
            } //End block
            else
            if(mState >= STARTED)            
            {
                mChildFragmentManager.dispatchStart();
            } //End block
            else
            if(mState >= ACTIVITY_CREATED)            
            {
                mChildFragmentManager.dispatchActivityCreated();
            } //End block
            else
            if(mState >= CREATED)            
            {
                mChildFragmentManager.dispatchCreate();
            } //End block
        } //End block
FragmentManager var3493CF387537729524962FC6B360BFAD_1666147175 =         mChildFragmentManager;
        var3493CF387537729524962FC6B360BFAD_1666147175.addTaint(taint);
        return var3493CF387537729524962FC6B360BFAD_1666147175;
        // ---------- Original Method ----------
        //if (mChildFragmentManager == null) {
            //instantiateChildFragmentManager();
            //if (mState >= RESUMED) {
                //mChildFragmentManager.dispatchResume();
            //} else if (mState >= STARTED) {
                //mChildFragmentManager.dispatchStart();
            //} else if (mState >= ACTIVITY_CREATED) {
                //mChildFragmentManager.dispatchActivityCreated();
            //} else if (mState >= CREATED) {
                //mChildFragmentManager.dispatchCreate();
            //}
        //}
        //return mChildFragmentManager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.936 -0400", hash_original_method = "B31DB62F63300A3D3A62AFCA68722969", hash_generated_method = "FD10FB82062A802A13575C171DAE7FDD")
    final public Fragment getParentFragment() {
Fragment var6FE00532201F4F3521B45CD9E3F73725_43323493 =         mParentFragment;
        var6FE00532201F4F3521B45CD9E3F73725_43323493.addTaint(taint);
        return var6FE00532201F4F3521B45CD9E3F73725_43323493;
        // ---------- Original Method ----------
        //return mParentFragment;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.936 -0400", hash_original_method = "C0D74F5DDFD9A01C19E54F3379BA7652", hash_generated_method = "F146ADF0E555EB681F0C45908A1ED0F7")
    final public boolean isAdded() {
        boolean var74BA28E0570A59B6D3A6A2107C73D4CF_249151528 = (mActivity != null && mAdded);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1636161280 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1636161280;
        // ---------- Original Method ----------
        //return mActivity != null && mAdded;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.936 -0400", hash_original_method = "2F8509F8C4A8638224A8FC9748BC6275", hash_generated_method = "4093A2E9808FA4AD656B68364C1FDFDC")
    final public boolean isDetached() {
        boolean var23906763A9631E67BD7C67265695AFF7_918612931 = (mDetached);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2023166748 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2023166748;
        // ---------- Original Method ----------
        //return mDetached;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.936 -0400", hash_original_method = "914BD43FF0612F84BA345FA6F486595C", hash_generated_method = "0620936395A64155F5347DBC7DE9377C")
    final public boolean isRemoving() {
        boolean var0F910DB84DA919CEA0C46A9368EB474F_549489233 = (mRemoving);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_461467703 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_461467703;
        // ---------- Original Method ----------
        //return mRemoving;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.936 -0400", hash_original_method = "3C6E7329283D3C6C46FB3F90EF65A4A7", hash_generated_method = "8B3E45F8A16D767E9C6C242CDC14F525")
    final public boolean isInLayout() {
        boolean var02B7C51C439DA5E343271787FAA8C822_274647623 = (mInLayout);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1936412788 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1936412788;
        // ---------- Original Method ----------
        //return mInLayout;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.936 -0400", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "4326AADD0F58036B5F0F907D27F42B57")
    final public boolean isResumed() {
        boolean var9933B84C738DC45A33F44AE2EFCBD30F_1605331968 = (mResumed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1764807146 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1764807146;
        // ---------- Original Method ----------
        //return mResumed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.936 -0400", hash_original_method = "72982976B71B01DF2412198462460DF0", hash_generated_method = "EE3ECCD69988E1E8D299E7C8EEB3A231")
    final public boolean isVisible() {
        boolean var68AFE6655C73AC0D5127DCFD89019FE3_860480528 = (isAdded() && !isHidden() && mView != null
                && mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1624277053 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1624277053;
        // ---------- Original Method ----------
        //return isAdded() && !isHidden() && mView != null
                //&& mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.936 -0400", hash_original_method = "E04FD968639295CCE5F791161EDE4496", hash_generated_method = "6141A22F58CC7D6C8DE87C511DC66DF5")
    final public boolean isHidden() {
        boolean var6E5D0646172E31357AC5264CFC6DCF7B_877006237 = (mHidden);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681115392 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_681115392;
        // ---------- Original Method ----------
        //return mHidden;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.936 -0400", hash_original_method = "FE8A5DF015D2662392185902D9D0AEDD", hash_generated_method = "764071413F7B945096A2936EA3340233")
    public void onHiddenChanged(boolean hidden) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(hidden);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.937 -0400", hash_original_method = "DD8E6A20AB766DE2DFF904C4C63DFDE5", hash_generated_method = "6A16929111850789710E55E0D8749E6E")
    public void setRetainInstance(boolean retain) {
        if(retain && mParentFragment != null)        
        {
            IllegalStateException var05E0ED4B64EAA9EF38CA3E09B18CD2D8_1744543854 = new IllegalStateException(
                    "Can't retain fragements that are nested in other fragments");
            var05E0ED4B64EAA9EF38CA3E09B18CD2D8_1744543854.addTaint(taint);
            throw var05E0ED4B64EAA9EF38CA3E09B18CD2D8_1744543854;
        } //End block
        mRetainInstance = retain;
        // ---------- Original Method ----------
        //if (retain && mParentFragment != null) {
            //throw new IllegalStateException(
                    //"Can't retain fragements that are nested in other fragments");
        //}
        //mRetainInstance = retain;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.937 -0400", hash_original_method = "82A17104D5864E2285E97283523AA6C5", hash_generated_method = "238A89A9A895FF0E807C863DDFD568BA")
    final public boolean getRetainInstance() {
        boolean varFC2473D51E767C5008A9D428BAFC8661_515083916 = (mRetainInstance);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1317996016 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1317996016;
        // ---------- Original Method ----------
        //return mRetainInstance;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.937 -0400", hash_original_method = "8AC8C0F5EC4C557D4FB057E17EB98486", hash_generated_method = "1144D774F77ACCFCA4A944514932044F")
    public void setHasOptionsMenu(boolean hasMenu) {
        if(mHasMenu != hasMenu)        
        {
            mHasMenu = hasMenu;
            if(isAdded() && !isHidden())            
            {
                mActivity.supportInvalidateOptionsMenu();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mHasMenu != hasMenu) {
            //mHasMenu = hasMenu;
            //if (isAdded() && !isHidden()) {
                //mActivity.supportInvalidateOptionsMenu();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.938 -0400", hash_original_method = "356D4C9378C3D90FECF449857449A450", hash_generated_method = "B5801917BC692141E36F8FB7AD8FB165")
    public void setMenuVisibility(boolean menuVisible) {
        if(mMenuVisible != menuVisible)        
        {
            mMenuVisible = menuVisible;
            if(mHasMenu && isAdded() && !isHidden())            
            {
                mActivity.supportInvalidateOptionsMenu();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mMenuVisible != menuVisible) {
            //mMenuVisible = menuVisible;
            //if (mHasMenu && isAdded() && !isHidden()) {
                //mActivity.supportInvalidateOptionsMenu();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.938 -0400", hash_original_method = "1B0128696FF26E02ABF181CBEC60E7DF", hash_generated_method = "3217C29CFE54AADE49CE3CAC00762C1C")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.938 -0400", hash_original_method = "16570E728AF342CDACA5E18099682804", hash_generated_method = "10B52483C3D98BD90D764088130ACC41")
    public boolean getUserVisibleHint() {
        boolean varB03D0E0FBB5C01B36684AC0EA4771924_700380793 = (mUserVisibleHint);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856670936 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856670936;
        // ---------- Original Method ----------
        //return mUserVisibleHint;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.938 -0400", hash_original_method = "F00ECADA9A0E38D0B8B713B009F5D3F7", hash_generated_method = "1E036DA4F700E1B9B35B3A91AC0C5300")
    public LoaderManager getLoaderManager() {
        if(mLoaderManager != null)        
        {
LoaderManager var805CC3710F0829AF609E93E575C2DA90_610207310 =             mLoaderManager;
            var805CC3710F0829AF609E93E575C2DA90_610207310.addTaint(taint);
            return var805CC3710F0829AF609E93E575C2DA90_610207310;
        } //End block
        if(mActivity == null)        
        {
            IllegalStateException varE10E059A0DCA5D38245E5AD84C394857_246212938 = new IllegalStateException("Fragment " + this + " not attached to Activity");
            varE10E059A0DCA5D38245E5AD84C394857_246212938.addTaint(taint);
            throw varE10E059A0DCA5D38245E5AD84C394857_246212938;
        } //End block
        mCheckedForLoaderManager = true;
        mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, true);
LoaderManager var805CC3710F0829AF609E93E575C2DA90_1740282117 =         mLoaderManager;
        var805CC3710F0829AF609E93E575C2DA90_1740282117.addTaint(taint);
        return var805CC3710F0829AF609E93E575C2DA90_1740282117;
        // ---------- Original Method ----------
        //if (mLoaderManager != null) {
            //return mLoaderManager;
        //}
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //mCheckedForLoaderManager = true;
        //mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, true);
        //return mLoaderManager;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.939 -0400", hash_original_method = "B68B30EDC5AB3BE8EF657FB7051C7F7E", hash_generated_method = "48BED25359A5F54B23B4D561BB076DF9")
    public void startActivity(Intent intent) {
        addTaint(intent.getTaint());
        if(mActivity == null)        
        {
            IllegalStateException varE10E059A0DCA5D38245E5AD84C394857_183421768 = new IllegalStateException("Fragment " + this + " not attached to Activity");
            varE10E059A0DCA5D38245E5AD84C394857_183421768.addTaint(taint);
            throw varE10E059A0DCA5D38245E5AD84C394857_183421768;
        } //End block
        mActivity.startActivityFromFragment(this, intent, -1);
        // ---------- Original Method ----------
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //mActivity.startActivityFromFragment(this, intent, -1);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.939 -0400", hash_original_method = "849399EB62F8B6EE6A6E550D7989B87C", hash_generated_method = "6CA6F8E0EEDA2AADF3063796223CBC99")
    public void startActivityForResult(Intent intent, int requestCode) {
        addTaint(requestCode);
        addTaint(intent.getTaint());
        if(mActivity == null)        
        {
            IllegalStateException varE10E059A0DCA5D38245E5AD84C394857_1880800794 = new IllegalStateException("Fragment " + this + " not attached to Activity");
            varE10E059A0DCA5D38245E5AD84C394857_1880800794.addTaint(taint);
            throw varE10E059A0DCA5D38245E5AD84C394857_1880800794;
        } //End block
        mActivity.startActivityFromFragment(this, intent, requestCode);
        // ---------- Original Method ----------
        //if (mActivity == null) {
            //throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        //}
        //mActivity.startActivityFromFragment(this, intent, requestCode);
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.939 -0400", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "13D54DC5D1A0400A81A53CF735ABCCE1")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(data.getTaint());
        addTaint(resultCode);
        addTaint(requestCode);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.940 -0400", hash_original_method = "8FF008E86C71DF2CF57F1B9E3E9D8CD9", hash_generated_method = "78C2D4F593E7237DAB1C7DF1AA8ADF93")
    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
LayoutInflater varC8F1AD9F765410CD70DB0833DE90DA27_1064722571 =         mActivity.getLayoutInflater();
        varC8F1AD9F765410CD70DB0833DE90DA27_1064722571.addTaint(taint);
        return varC8F1AD9F765410CD70DB0833DE90DA27_1064722571;
        // ---------- Original Method ----------
        //return mActivity.getLayoutInflater();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.940 -0400", hash_original_method = "6B431F4170E83AA9D07B8C377544B225", hash_generated_method = "73638075985B771AB2C99D5EAADC91FC")
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(attrs.getTaint());
        addTaint(activity.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.940 -0400", hash_original_method = "7FCB8118913FF635CB1CDE717E61023E", hash_generated_method = "800CFB085D8824BBFB5C33269F30F63C")
    public void onAttach(Activity activity) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(activity.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.940 -0400", hash_original_method = "273C1CEA731372543F92C5C1B99E7FBF", hash_generated_method = "1E3A18A3E0474AE1DE17CE68CBEA6DF1")
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(nextAnim);
        addTaint(enter);
        addTaint(transit);
Animation var540C13E9E156B687226421B24F2DF178_1877889736 =         null;
        var540C13E9E156B687226421B24F2DF178_1877889736.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1877889736;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.940 -0400", hash_original_method = "00494AECA41C1730DF6E82548FC2C3D5", hash_generated_method = "4CCDB0DCFFB66173622F366FF1BCFCBE")
    public void onCreate(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.940 -0400", hash_original_method = "57C338AB393ED440CE12C76B2627A085", hash_generated_method = "D17433B5EDDF760C201321E0354CAF11")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(container.getTaint());
        addTaint(inflater.getTaint());
View var540C13E9E156B687226421B24F2DF178_227147087 =         null;
        var540C13E9E156B687226421B24F2DF178_227147087.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_227147087;
        // ---------- Original Method ----------
        //return null;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.941 -0400", hash_original_method = "F4318A499F9B06ABC9CCF0644AE6DC10", hash_generated_method = "52769EFA20AE14D9C5042204CED1C380")
    public void onViewCreated(View view, Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        addTaint(view.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.941 -0400", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "B6C02B5F316625A2365E2F1C3F59A5E8")
    public View getView() {
View var2A050D4EA4182130A6C1E6806618CCD0_174818966 =         mView;
        var2A050D4EA4182130A6C1E6806618CCD0_174818966.addTaint(taint);
        return var2A050D4EA4182130A6C1E6806618CCD0_174818966;
        // ---------- Original Method ----------
        //return mView;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.941 -0400", hash_original_method = "C52625884C98429BE8DE42F4FBFE7367", hash_generated_method = "E2F05B6742F9D7E8DC9825D8FC2D9F9A")
    public void onActivityCreated(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.941 -0400", hash_original_method = "01C4E5BCA343F9B21B52342AACDB7055", hash_generated_method = "9F3F9CB12391666B738CAD822238CD91")
    public void onViewStateRestored(Bundle savedInstanceState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(savedInstanceState.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.941 -0400", hash_original_method = "EDAB2E7FCE4E0A13012A045AB5CD29D5", hash_generated_method = "2784F02B7E0F1140A98BEA666572A292")
    public void onStart() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        if(!mLoadersStarted)        
        {
            mLoadersStarted = true;
            if(!mCheckedForLoaderManager)            
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, false);
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
                //mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, false);
            //}
            //if (mLoaderManager != null) {
                //mLoaderManager.doStart();
            //}
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.942 -0400", hash_original_method = "3B8608ED59C2663D271D57F8D8F534C0", hash_generated_method = "A35C9648644440B1AB73336CCB6DEAB5")
    public void onResume() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.942 -0400", hash_original_method = "9C4F98F3F5A4FCEFF66E261EDA5693F3", hash_generated_method = "AD15648AB8B6357D84B3060587BAA98F")
    public void onSaveInstanceState(Bundle outState) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(outState.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.942 -0400", hash_original_method = "16A05561D5415124B893EA7E2AFB953D", hash_generated_method = "A984469EBDCC0902B8851BB94C61A9EF")
    public void onConfigurationChanged(Configuration newConfig) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(newConfig.getTaint());
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.942 -0400", hash_original_method = "CEF2FF1DA31E7EE9D761807A037B37B2", hash_generated_method = "637684B70754E8D79E076DC6A513E031")
    public void onPause() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.942 -0400", hash_original_method = "FC062A9ECA017F6E5D455E8C973942F9", hash_generated_method = "7E26AAA6FA11DEDE75C340853A5FC7A3")
    public void onStop() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.942 -0400", hash_original_method = "28328842E1AEC7ECF313405184622A29", hash_generated_method = "A607A7A5A4E7888F4F9DD46B7BE5C1AF")
    public void onLowMemory() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.942 -0400", hash_original_method = "E54F17C7BAFD082A48D2152349C1815A", hash_generated_method = "D6DBBF3121DDE73B3DDC3BCBF558AE8E")
    public void onDestroyView() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.943 -0400", hash_original_method = "FBD8F2B4105FF1952BBC9E4FBE11F6B2", hash_generated_method = "5BB6608BC4D823CFB54AB12DF218F391")
    public void onDestroy() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        if(!mCheckedForLoaderManager)        
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, false);
        } //End block
        if(mLoaderManager != null)        
        {
            mLoaderManager.doDestroy();
        } //End block
        // ---------- Original Method ----------
        //mCalled = true;
        //if (!mCheckedForLoaderManager) {
            //mCheckedForLoaderManager = true;
            //mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, false);
        //}
        //if (mLoaderManager != null) {
            //mLoaderManager.doDestroy();
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.944 -0400", hash_original_method = "04633BF5293F80973E1AA355DB2C35EF", hash_generated_method = "4C027456133F87915A9EF12926708CE0")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.944 -0400", hash_original_method = "EF609D2FD1394DFBC19807CB21AD7D10", hash_generated_method = "CD3AD86EF54BB27DA72F7E9F9B9DEA15")
    public void onDetach() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        mCalled = true;
        // ---------- Original Method ----------
        //mCalled = true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.944 -0400", hash_original_method = "B3C5F3D019B47C47E6111F1C7C38CA5D", hash_generated_method = "CD3DE4D46F4897BB6058BF519EF6DB27")
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(inflater.getTaint());
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.944 -0400", hash_original_method = "4CE703F4C1FA6FC474411DFE6A3F5275", hash_generated_method = "32B650DEFAD74BF60D957C3D22EC9F79")
    public void onPrepareOptionsMenu(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.944 -0400", hash_original_method = "0E8C037F224061747BFFD0611606AAB6", hash_generated_method = "EF044D3D33EBB476DBBCFB32576782C1")
    public void onDestroyOptionsMenu() {
        //DSFIXME:  CODE0009: Possible callback target function detected
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.945 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "D4BAB97B908F2625D78369F78E9C8074")
    public boolean onOptionsItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_468560988 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1645521651 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1645521651;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.945 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "CC9F879215C8D6911F3F43FE45124EF9")
    public void onOptionsMenuClosed(Menu menu) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menu.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.945 -0400", hash_original_method = "68082EA0714CB57B78AC95D3FF2A7AC8", hash_generated_method = "C9CB67D34E1446359FA2B8208D2404BA")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(menuInfo.getTaint());
        addTaint(v.getTaint());
        addTaint(menu.getTaint());
        getActivity().onCreateContextMenu(menu, v, menuInfo);
        // ---------- Original Method ----------
        //getActivity().onCreateContextMenu(menu, v, menuInfo);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.945 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "A6804032F4A398F98AB72F29BB096EED")
    public void registerForContextMenu(View view) {
        //DSFIXME: CODE0010: Possible callback registration function detected
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(this);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.945 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "00514E90EA9081E765956475D78499EF")
    public void unregisterForContextMenu(View view) {
        addTaint(view.getTaint());
        view.setOnCreateContextMenuListener(null);
        // ---------- Original Method ----------
        //view.setOnCreateContextMenuListener(null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.946 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "EDC5FA30F7A92868C9416917228C808F")
    public boolean onContextItemSelected(MenuItem item) {
        //DSFIXME:  CODE0009: Possible callback target function detected
        addTaint(item.getTaint());
        boolean var68934A3E9455FA72420237EB05902327_1250871075 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1371026155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1371026155;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.948 -0400", hash_original_method = "4506E0F094FC2CBE2D517E6D81344EC6", hash_generated_method = "EA637258B388AE08EEE97193515211EA")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
        writer.print(prefix);
        writer.print("mFragmentId=#");
        writer.print(Integer.toHexString(mFragmentId));
        writer.print(" mContainerId=#");
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
        if(mParentFragment != null)        
        {
            writer.print(prefix);
            writer.print("mParentFragment=");
            writer.println(mParentFragment);
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
        if(mInnerView != null)        
        {
            writer.print(prefix);
            writer.print("mInnerView=");
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
        if(mChildFragmentManager != null)        
        {
            writer.print(prefix);
            writer.println("Child " + mChildFragmentManager + ":");
            mChildFragmentManager.dump(prefix + "  ", fd, writer, args);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.949 -0400", hash_original_method = "61D88876092ADD5F15473E2AB4FA77D3", hash_generated_method = "C312CF357D45BF73BD2D519BE0324060")
     Fragment findFragmentByWho(String who) {
        addTaint(who.getTaint());
        if(who.equals(mWho))        
        {
Fragment var72A74007B2BE62B849F475C7BDA4658B_611068038 =             this;
            var72A74007B2BE62B849F475C7BDA4658B_611068038.addTaint(taint);
            return var72A74007B2BE62B849F475C7BDA4658B_611068038;
        } //End block
        if(mChildFragmentManager != null)        
        {
Fragment varE4E796C070526C4023CFADE235949210_1493569118 =             mChildFragmentManager.findFragmentByWho(who);
            varE4E796C070526C4023CFADE235949210_1493569118.addTaint(taint);
            return varE4E796C070526C4023CFADE235949210_1493569118;
        } //End block
Fragment var540C13E9E156B687226421B24F2DF178_1100651388 =         null;
        var540C13E9E156B687226421B24F2DF178_1100651388.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1100651388;
        // ---------- Original Method ----------
        //if (who.equals(mWho)) {
            //return this;
        //}
        //if (mChildFragmentManager != null) {
            //return mChildFragmentManager.findFragmentByWho(who);
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.950 -0400", hash_original_method = "EDAB121E0E9B6E6FAA5680C6215916BF", hash_generated_method = "902ED28151D6180022DD6238221AE4E1")
     void instantiateChildFragmentManager() {
        mChildFragmentManager = new FragmentManagerImpl();
        mChildFragmentManager.attachActivity(mActivity, new FragmentContainer() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.950 -0400", hash_original_method = "5BED041A00050D47AD1342402B9985BC", hash_generated_method = "B5DF880D844F3E68B1196916D8605853")
        @Override
        public View findViewById(int id) {
            addTaint(id);
            if(mView == null)            
            {
                IllegalStateException var17176FF7F0F6567E065E4E04A3F68422_1359180333 = new IllegalStateException("Fragment does not have a view");
                var17176FF7F0F6567E065E4E04A3F68422_1359180333.addTaint(taint);
                throw var17176FF7F0F6567E065E4E04A3F68422_1359180333;
            } //End block
View var1DBA67C28D1712900AAB33CEBE91AA27_187194884 =             mView.findViewById(id);
            var1DBA67C28D1712900AAB33CEBE91AA27_187194884.addTaint(taint);
            return var1DBA67C28D1712900AAB33CEBE91AA27_187194884;
            // ---------- Original Method ----------
            //if (mView == null) {
                    //throw new IllegalStateException("Fragment does not have a view");
                //}
            //return mView.findViewById(id);
        }
}, this);
        // ---------- Original Method ----------
        //mChildFragmentManager = new FragmentManagerImpl();
        //mChildFragmentManager.attachActivity(mActivity, new FragmentContainer() {
            //@Override
            //public View findViewById(int id) {
                //if (mView == null) {
                    //throw new IllegalStateException("Fragment does not have a view");
                //}
                //return mView.findViewById(id);
            //}
        //}, this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.951 -0400", hash_original_method = "3EE407E16277E3B3A8635005B5A0DEC4", hash_generated_method = "298A8F41E7091DA48B0C37EE0285A6F1")
     void performCreate(Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.noteStateNotSaved();
        } //End block
        mCalled = false;
        onCreate(savedInstanceState);
        if(!mCalled)        
        {
            SuperNotCalledException varBE0A4D376E4570441529D086C97D4D84_1855570780 = new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onCreate()");
            varBE0A4D376E4570441529D086C97D4D84_1855570780.addTaint(taint);
            throw varBE0A4D376E4570441529D086C97D4D84_1855570780;
        } //End block
        if(savedInstanceState != null)        
        {
            Parcelable p = savedInstanceState.getParcelable(
                    FragmentActivity.FRAGMENTS_TAG);
            if(p != null)            
            {
                if(mChildFragmentManager == null)                
                {
                    instantiateChildFragmentManager();
                } //End block
                mChildFragmentManager.restoreAllState(p, null);
                mChildFragmentManager.dispatchCreate();
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.noteStateNotSaved();
        //}
        //mCalled = false;
        //onCreate(savedInstanceState);
        //if (!mCalled) {
            //throw new SuperNotCalledException("Fragment " + this
                    //+ " did not call through to super.onCreate()");
        //}
        //if (savedInstanceState != null) {
            //Parcelable p = savedInstanceState.getParcelable(
                    //FragmentActivity.FRAGMENTS_TAG);
            //if (p != null) {
                //if (mChildFragmentManager == null) {
                    //instantiateChildFragmentManager();
                //}
                //mChildFragmentManager.restoreAllState(p, null);
                //mChildFragmentManager.dispatchCreate();
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.951 -0400", hash_original_method = "C9098E0ABE3DD99AEB89FC060D15CE33", hash_generated_method = "5F4826C1E30D4D3A3E7C33DBBC3884C0")
     View performCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        addTaint(container.getTaint());
        addTaint(inflater.getTaint());
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.noteStateNotSaved();
        } //End block
View var0099E201860CA496C23576A81894B76F_847457861 =         onCreateView(inflater, container, savedInstanceState);
        var0099E201860CA496C23576A81894B76F_847457861.addTaint(taint);
        return var0099E201860CA496C23576A81894B76F_847457861;
        // ---------- Original Method ----------
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.noteStateNotSaved();
        //}
        //return onCreateView(inflater, container, savedInstanceState);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.951 -0400", hash_original_method = "6B9A0B76E81212CD14FFC5CCF383D5D3", hash_generated_method = "82C481EDA1857A7F1169250818FA5F8D")
     void performActivityCreated(Bundle savedInstanceState) {
        addTaint(savedInstanceState.getTaint());
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.noteStateNotSaved();
        } //End block
        mCalled = false;
        onActivityCreated(savedInstanceState);
        if(!mCalled)        
        {
            SuperNotCalledException varAA10F13A28BD5D1EE5385FB0FB4FE616_239239911 = new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onActivityCreated()");
            varAA10F13A28BD5D1EE5385FB0FB4FE616_239239911.addTaint(taint);
            throw varAA10F13A28BD5D1EE5385FB0FB4FE616_239239911;
        } //End block
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchActivityCreated();
        } //End block
        // ---------- Original Method ----------
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.noteStateNotSaved();
        //}
        //mCalled = false;
        //onActivityCreated(savedInstanceState);
        //if (!mCalled) {
            //throw new SuperNotCalledException("Fragment " + this
                    //+ " did not call through to super.onActivityCreated()");
        //}
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchActivityCreated();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.953 -0400", hash_original_method = "FAC6959B7963C55ED04FD140D265CD92", hash_generated_method = "9119E4103210EAA37A0D8FA9DDB1B00D")
     void performStart() {
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.noteStateNotSaved();
            mChildFragmentManager.execPendingActions();
        } //End block
        mCalled = false;
        onStart();
        if(!mCalled)        
        {
            SuperNotCalledException varACA66D0FE98CBE2E2016C8325317EB55_60187690 = new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onStart()");
            varACA66D0FE98CBE2E2016C8325317EB55_60187690.addTaint(taint);
            throw varACA66D0FE98CBE2E2016C8325317EB55_60187690;
        } //End block
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchStart();
        } //End block
        if(mLoaderManager != null)        
        {
            mLoaderManager.doReportStart();
        } //End block
        // ---------- Original Method ----------
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.noteStateNotSaved();
            //mChildFragmentManager.execPendingActions();
        //}
        //mCalled = false;
        //onStart();
        //if (!mCalled) {
            //throw new SuperNotCalledException("Fragment " + this
                    //+ " did not call through to super.onStart()");
        //}
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchStart();
        //}
        //if (mLoaderManager != null) {
            //mLoaderManager.doReportStart();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.953 -0400", hash_original_method = "225800A7AAA9ACBE89033DE187291152", hash_generated_method = "8F57FE0AA494459D23C2E42C39BEE151")
     void performResume() {
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.noteStateNotSaved();
            mChildFragmentManager.execPendingActions();
        } //End block
        mCalled = false;
        onResume();
        if(!mCalled)        
        {
            SuperNotCalledException varB24AF118A41EF4AFD42D258387A331CB_516982671 = new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onResume()");
            varB24AF118A41EF4AFD42D258387A331CB_516982671.addTaint(taint);
            throw varB24AF118A41EF4AFD42D258387A331CB_516982671;
        } //End block
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchResume();
            mChildFragmentManager.execPendingActions();
        } //End block
        // ---------- Original Method ----------
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.noteStateNotSaved();
            //mChildFragmentManager.execPendingActions();
        //}
        //mCalled = false;
        //onResume();
        //if (!mCalled) {
            //throw new SuperNotCalledException("Fragment " + this
                    //+ " did not call through to super.onResume()");
        //}
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchResume();
            //mChildFragmentManager.execPendingActions();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.953 -0400", hash_original_method = "4CF76F87E5378DAC79600BD4B0530AEF", hash_generated_method = "0E8CDEC495ED121B2EEBD697E4795157")
     void performConfigurationChanged(Configuration newConfig) {
        addTaint(newConfig.getTaint());
        onConfigurationChanged(newConfig);
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchConfigurationChanged(newConfig);
        } //End block
        // ---------- Original Method ----------
        //onConfigurationChanged(newConfig);
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchConfigurationChanged(newConfig);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.953 -0400", hash_original_method = "F077F2C753E805161BC608B27E561A9B", hash_generated_method = "5B789E70B3B1CAD6F3C94986A50BC9E7")
     void performLowMemory() {
        onLowMemory();
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchLowMemory();
        } //End block
        // ---------- Original Method ----------
        //onLowMemory();
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchLowMemory();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.971 -0400", hash_original_method = "EDE9801703CADFBAB935432E700FE9D4", hash_generated_method = "5B0FE2FA7838CDB25228DDF1705E50FB")
     boolean performCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        addTaint(inflater.getTaint());
        addTaint(menu.getTaint());
        boolean show = false;
        if(!mHidden)        
        {
            if(mHasMenu && mMenuVisible)            
            {
                show = true;
                onCreateOptionsMenu(menu, inflater);
            } //End block
            if(mChildFragmentManager != null)            
            {
                show |= mChildFragmentManager.dispatchCreateOptionsMenu(menu, inflater);
            } //End block
        } //End block
        boolean varA7DD12B1DAB17D25467B0B0A4C8D4A92_1470413848 = (show);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340338197 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340338197;
        // ---------- Original Method ----------
        //boolean show = false;
        //if (!mHidden) {
            //if (mHasMenu && mMenuVisible) {
                //show = true;
                //onCreateOptionsMenu(menu, inflater);
            //}
            //if (mChildFragmentManager != null) {
                //show |= mChildFragmentManager.dispatchCreateOptionsMenu(menu, inflater);
            //}
        //}
        //return show;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.971 -0400", hash_original_method = "27D1E8CFF71284C61956522356EF62A1", hash_generated_method = "FA3957AC6B908E258604CEDF719FF658")
     boolean performPrepareOptionsMenu(Menu menu) {
        addTaint(menu.getTaint());
        boolean show = false;
        if(!mHidden)        
        {
            if(mHasMenu && mMenuVisible)            
            {
                show = true;
                onPrepareOptionsMenu(menu);
            } //End block
            if(mChildFragmentManager != null)            
            {
                show |= mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
            } //End block
        } //End block
        boolean varA7DD12B1DAB17D25467B0B0A4C8D4A92_1771231006 = (show);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557865005 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557865005;
        // ---------- Original Method ----------
        //boolean show = false;
        //if (!mHidden) {
            //if (mHasMenu && mMenuVisible) {
                //show = true;
                //onPrepareOptionsMenu(menu);
            //}
            //if (mChildFragmentManager != null) {
                //show |= mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
            //}
        //}
        //return show;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.972 -0400", hash_original_method = "AB066317960C5B7A87CEEFD90F19CB53", hash_generated_method = "C1C5251117A10D5B3A3469457170D7E8")
     boolean performOptionsItemSelected(MenuItem item) {
        addTaint(item.getTaint());
        if(!mHidden)        
        {
            if(mHasMenu && mMenuVisible)            
            {
                if(onOptionsItemSelected(item))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_123668414 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1997708151 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1997708151;
                } //End block
            } //End block
            if(mChildFragmentManager != null)            
            {
                if(mChildFragmentManager.dispatchOptionsItemSelected(item))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_1436064459 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_232865781 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_232865781;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1879510253 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1096816075 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1096816075;
        // ---------- Original Method ----------
        //if (!mHidden) {
            //if (mHasMenu && mMenuVisible) {
                //if (onOptionsItemSelected(item)) {
                    //return true;
                //}
            //}
            //if (mChildFragmentManager != null) {
                //if (mChildFragmentManager.dispatchOptionsItemSelected(item)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.972 -0400", hash_original_method = "78AAFDAC6C7C01B066E741BD144002F2", hash_generated_method = "AD7A6C272252735D289E2F413B33EF86")
     boolean performContextItemSelected(MenuItem item) {
        addTaint(item.getTaint());
        if(!mHidden)        
        {
            if(onContextItemSelected(item))            
            {
                boolean varB326B5062B2F0E69046810717534CB09_340315059 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_403240611 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_403240611;
            } //End block
            if(mChildFragmentManager != null)            
            {
                if(mChildFragmentManager.dispatchContextItemSelected(item))                
                {
                    boolean varB326B5062B2F0E69046810717534CB09_923709366 = (true);
                                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1598567 = getTaintBoolean();
                    return var84E2C64F38F78BA3EA5C905AB5A2DA27_1598567;
                } //End block
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_740858746 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1335823640 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1335823640;
        // ---------- Original Method ----------
        //if (!mHidden) {
            //if (onContextItemSelected(item)) {
                //return true;
            //}
            //if (mChildFragmentManager != null) {
                //if (mChildFragmentManager.dispatchContextItemSelected(item)) {
                    //return true;
                //}
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.973 -0400", hash_original_method = "4DDEE08146B46D76D3DC17885A5DDDC2", hash_generated_method = "37FB003F6EED67FF00DE182998950D81")
     void performOptionsMenuClosed(Menu menu) {
        addTaint(menu.getTaint());
        if(!mHidden)        
        {
            if(mHasMenu && mMenuVisible)            
            {
                onOptionsMenuClosed(menu);
            } //End block
            if(mChildFragmentManager != null)            
            {
                mChildFragmentManager.dispatchOptionsMenuClosed(menu);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (!mHidden) {
            //if (mHasMenu && mMenuVisible) {
                //onOptionsMenuClosed(menu);
            //}
            //if (mChildFragmentManager != null) {
                //mChildFragmentManager.dispatchOptionsMenuClosed(menu);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.973 -0400", hash_original_method = "229F45787776B9C5A3449A8AF116842B", hash_generated_method = "162BEEC8BBCA6A51FD4922DA9A5EF4B6")
     void performSaveInstanceState(Bundle outState) {
        addTaint(outState.getTaint());
        onSaveInstanceState(outState);
        if(mChildFragmentManager != null)        
        {
            Parcelable p = mChildFragmentManager.saveAllState();
            if(p != null)            
            {
                outState.putParcelable(FragmentActivity.FRAGMENTS_TAG, p);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //onSaveInstanceState(outState);
        //if (mChildFragmentManager != null) {
            //Parcelable p = mChildFragmentManager.saveAllState();
            //if (p != null) {
                //outState.putParcelable(FragmentActivity.FRAGMENTS_TAG, p);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.973 -0400", hash_original_method = "E981410A628A778E5EC5758D81394A36", hash_generated_method = "5FBE8AD3A99B09D1298EF1FE586D82F1")
     void performPause() {
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchPause();
        } //End block
        mCalled = false;
        onPause();
        if(!mCalled)        
        {
            SuperNotCalledException var4E40642D20001435ACBEFC0E625248F8_2114251088 = new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onPause()");
            var4E40642D20001435ACBEFC0E625248F8_2114251088.addTaint(taint);
            throw var4E40642D20001435ACBEFC0E625248F8_2114251088;
        } //End block
        // ---------- Original Method ----------
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchPause();
        //}
        //mCalled = false;
        //onPause();
        //if (!mCalled) {
            //throw new SuperNotCalledException("Fragment " + this
                    //+ " did not call through to super.onPause()");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.973 -0400", hash_original_method = "A54D340AC4C554E09C318AFC86BC07BD", hash_generated_method = "023E64B7A939412C84A7954254C0801B")
     void performStop() {
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchStop();
        } //End block
        mCalled = false;
        onStop();
        if(!mCalled)        
        {
            SuperNotCalledException varDD4F51460A820CA7A94DAB45AC592BF8_946376510 = new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onStop()");
            varDD4F51460A820CA7A94DAB45AC592BF8_946376510.addTaint(taint);
            throw varDD4F51460A820CA7A94DAB45AC592BF8_946376510;
        } //End block
        // ---------- Original Method ----------
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchStop();
        //}
        //mCalled = false;
        //onStop();
        //if (!mCalled) {
            //throw new SuperNotCalledException("Fragment " + this
                    //+ " did not call through to super.onStop()");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.973 -0400", hash_original_method = "E7DDF1CA54A3F6D13CAA1A65082611F8", hash_generated_method = "D75A757707206B56FDC681F4CBC30FC5")
     void performReallyStop() {
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchReallyStop();
        } //End block
        if(mLoadersStarted)        
        {
            mLoadersStarted = false;
            if(!mCheckedForLoaderManager)            
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, false);
            } //End block
            if(mLoaderManager != null)            
            {
                if(!mActivity.mRetaining)                
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
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchReallyStop();
        //}
        //if (mLoadersStarted) {
            //mLoadersStarted = false;
            //if (!mCheckedForLoaderManager) {
                //mCheckedForLoaderManager = true;
                //mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, false);
            //}
            //if (mLoaderManager != null) {
                //if (!mActivity.mRetaining) {
                    //mLoaderManager.doStop();
                //} else {
                    //mLoaderManager.doRetain();
                //}
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.974 -0400", hash_original_method = "A7577DB153B8A046DC326874EE7B0A4B", hash_generated_method = "F776D33D39EA675B22EEDFCC8C59153E")
     void performDestroyView() {
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchDestroyView();
        } //End block
        mCalled = false;
        onDestroyView();
        if(!mCalled)        
        {
            SuperNotCalledException var6204EB1226E09974771B004D67DBAA9A_108821386 = new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onDestroyView()");
            var6204EB1226E09974771B004D67DBAA9A_108821386.addTaint(taint);
            throw var6204EB1226E09974771B004D67DBAA9A_108821386;
        } //End block
        if(mLoaderManager != null)        
        {
            mLoaderManager.doReportNextStart();
        } //End block
        // ---------- Original Method ----------
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchDestroyView();
        //}
        //mCalled = false;
        //onDestroyView();
        //if (!mCalled) {
            //throw new SuperNotCalledException("Fragment " + this
                    //+ " did not call through to super.onDestroyView()");
        //}
        //if (mLoaderManager != null) {
            //mLoaderManager.doReportNextStart();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.975 -0400", hash_original_method = "6BD30978B327739DC7CB2841A03C0980", hash_generated_method = "786E238CD8156FD8F5BF19A27174AB15")
     void performDestroy() {
        if(mChildFragmentManager != null)        
        {
            mChildFragmentManager.dispatchDestroy();
        } //End block
        mCalled = false;
        onDestroy();
        if(!mCalled)        
        {
            SuperNotCalledException var5C247E0C9EA17BB059A221D75C46EA6A_1777890628 = new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onDestroy()");
            var5C247E0C9EA17BB059A221D75C46EA6A_1777890628.addTaint(taint);
            throw var5C247E0C9EA17BB059A221D75C46EA6A_1777890628;
        } //End block
        // ---------- Original Method ----------
        //if (mChildFragmentManager != null) {
            //mChildFragmentManager.dispatchDestroy();
        //}
        //mCalled = false;
        //onDestroy();
        //if (!mCalled) {
            //throw new SuperNotCalledException("Fragment " + this
                    //+ " did not call through to super.onDestroy()");
        //}
    }

    
    public static class SavedState implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.975 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "AA4A80FE6E8C28CFC04031C8CFFC3C9D")

        Bundle mState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.975 -0400", hash_original_method = "7D4CB1BC3C04B99DC21EA19CB6BAF4D3", hash_generated_method = "BAE726BCB2EFD4A0280978447E5417B6")
          SavedState(Bundle state) {
            mState = state;
            // ---------- Original Method ----------
            //mState = state;
        }

        
                @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.975 -0400", hash_original_method = "E611F4C5C5E159704631D93ABD994DEF", hash_generated_method = "D25353096B5344EC0F39CEF0AD4F19B4")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.975 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A51588F773C51E3CEFC718B0A0F4BAC8")
        @Override
        public int describeContents() {
            int varCFCD208495D565EF66E7DFF9F98764DA_1393683432 = (0);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665665912 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_665665912;
            // ---------- Original Method ----------
            //return 0;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.977 -0400", hash_original_method = "ACF88B4EF312D321A4777388A96F3566", hash_generated_method = "1C039FAE169046CF463468B90B998E91")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            addTaint(flags);
            addTaint(dest.getTaint());
            dest.writeBundle(mState);
            // ---------- Original Method ----------
            //dest.writeBundle(mState);
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.977 -0400", hash_original_field = "A42D60237D21D4808CE78C5691FA3200", hash_generated_field = "FB9BD5541F55208F5BC20C32E5AB0F3E")

        public static final Parcelable.Creator<SavedState> CREATOR
                = new Parcelable.Creator<SavedState>() {
            public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, null);
            }

            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }


    
    static public class InstantiationException extends RuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.978 -0400", hash_original_method = "9A59F9C8F177B5B07F720376B1CE8BCE", hash_generated_method = "49CEDFFAD9ABDDBE0ED0991ADFD6BC85")
        public  InstantiationException(String msg, Exception cause) {
            super(msg, cause);
            addTaint(cause.getTaint());
            addTaint(msg.getTaint());
            // ---------- Original Method ----------
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.978 -0400", hash_original_field = "24A48BEA88D09CCBC63A8677385B95A8", hash_generated_field = "EB0A976F34844AD55F975EEF50A2B1A3")

    private static final HashMap<String, Class<?>> sClassMap = new HashMap<String, Class<?>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.978 -0400", hash_original_field = "403EB1653B87B88BD21AEF72194EF5E0", hash_generated_field = "B9FFABD80C3D80703D84376667A75609")

    static final int INITIALIZING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.978 -0400", hash_original_field = "6EFDDF5DE9E2142D56B3E098F844AE40", hash_generated_field = "97B36236CFE06BD1C50B96E10CE241B6")

    static final int CREATED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.978 -0400", hash_original_field = "18C3D4E620F8352BDF3CA097C14B87F7", hash_generated_field = "00E5F9933DCF6CD0A60E606E52C7FADE")

    static final int ACTIVITY_CREATED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.978 -0400", hash_original_field = "456918D615E944292D78BC88E852291C", hash_generated_field = "2CEA28884A245A0CE49FCF31D0D6588D")

    static final int STOPPED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.978 -0400", hash_original_field = "C604B9D3F56F632433E5FA0C79127BB7", hash_generated_field = "4F033F865040D83003D856BED757C437")

    static final int STARTED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:31.978 -0400", hash_original_field = "FF953E97A61C82A8BD259E088591325D", hash_generated_field = "562F93666D34FFE3A5D8899053C80C4E")

    static final int RESUMED = 5;
}

