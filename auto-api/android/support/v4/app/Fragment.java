package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "6BC238A3BDD37BF1CAC26EA2CE45C508")

    String mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "D9B77340C245436344B0149264025068", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

    boolean mFromLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "743B83D822DFF54AE7E24307CEF26F0C", hash_generated_field = "C628DB5A0351ABB6B2BC170D76A5FF43")

    int mFragmentId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "A2C9A3DA927DBE9AB0FC8FD8C7B637D9", hash_generated_field = "2072CAADE2B3735D2B37FDBC10B7F08E")

    int mContainerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

    String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "FC2473D51E767C5008A9D428BAFC8661", hash_generated_field = "907988FDE235BE080FDDB6DB36EF9C83")

    boolean mRetainInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "23906763A9631E67BD7C67265695AFF7", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

    boolean mDetached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "5867CE8CB088E58E6D17882F8EE91C5B", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

    Bundle mArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "74933D8F8D085F6D27B373C3AD9FBBC4", hash_generated_field = "F958FB3998EC484A7599A988303CD216")

    Bundle mSavedFragmentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.646 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "F83F5A158F2251FA12452672DC97E470")

    Fragment mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.647 -0400", hash_original_method = "116485142A61C36D4B47DBE9BCB45890", hash_generated_method = "9C8B1F3AA1DA7C8FAE9B803347EE426A")
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
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.648 -0400", hash_original_method = "46F838C8877526D395D980C698E03728", hash_generated_method = "1AEC5D39B1C46172E66E2ADE1F21E5F6")
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
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.649 -0400", hash_original_method = "929295C14EE92A06097EEC5737CFE8E9", hash_generated_method = "5F72A74AA0CEA828968ABF4D62811809")
    public Fragment instantiate(FragmentActivity activity, Fragment parent) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1543065375 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1349882814 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1543065375 = mInstance;
        } 
        {
            mArguments.setClassLoader(activity.getClassLoader());
        } 
        mInstance = Fragment.instantiate(activity, mClassName, mArguments);
        {
            mSavedFragmentState.setClassLoader(activity.getClassLoader());
            mInstance.mSavedFragmentState = mSavedFragmentState;
        } 
        mInstance.setIndex(mIndex, parent);
        mInstance.mFromLayout = mFromLayout;
        mInstance.mRestored = true;
        mInstance.mFragmentId = mFragmentId;
        mInstance.mContainerId = mContainerId;
        mInstance.mTag = mTag;
        mInstance.mRetainInstance = mRetainInstance;
        mInstance.mDetached = mDetached;
        mInstance.mFragmentManager = activity.mFragments;
        varB4EAC82CA7396A68D541C85D26508E83_1349882814 = mInstance;
        addTaint(parent.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_1476597954; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1476597954 = varB4EAC82CA7396A68D541C85D26508E83_1543065375;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1476597954 = varB4EAC82CA7396A68D541C85D26508E83_1349882814;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1476597954.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1476597954;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.650 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8933693103947E1E7F3E4DB72B8CA8D5")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_835342645 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_835342645;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.650 -0400", hash_original_method = "5938F2E0A344A05A5347D3909CB444C6", hash_generated_method = "3F956FAB5615EA38678EDAD56B20ED1C")
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
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.650 -0400", hash_original_field = "20C24B13B86A2BA0167AA1764B64C330", hash_generated_field = "33682AAE42971F2215D5844A73451D2E")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "F6222ECFC0F3B677015F93D1974DAF06", hash_generated_field = "0294DD5CAC8ED58250DA531156A3A018")

    int mState = INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "BDE9D2B3E8C16F6173B11304E226AD48", hash_generated_field = "5A7CC416AE8E502EE87A452D06D4A6F4")

    View mAnimatingAway;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "8ED4FBC10C3DA2C5D7785F68532DB880", hash_generated_field = "AA12B8E459D536EFC9893454A513D5AA")

    int mStateAfterAnimating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "74933D8F8D085F6D27B373C3AD9FBBC4", hash_generated_field = "F958FB3998EC484A7599A988303CD216")

    Bundle mSavedFragmentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "2B7B591D0427765FF0500D38736CF518", hash_generated_field = "03C65AC0399DBB932968B6C681CFC16A")

    SparseArray<Parcelable> mSavedViewState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "DBDF7BB492A85A363C47FDDA34C5BB3E", hash_generated_field = "6B9186F1D8E9AA88F21C8B70F0B9BCC7")

    int mIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "7ECAB8F1DFD4D8C88111D51780B29562")

    String mWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "5867CE8CB088E58E6D17882F8EE91C5B", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

    Bundle mArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "14E7923C6D3468CDFB90940EBE370C56")

    Fragment mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "4FB974C217F7C6C42183BA9DEC8C9619", hash_generated_field = "B3D14A57A7194FB87F01321513F81187")

    int mTargetIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "9D7EC7B2039084EAAB4A7123EC5C6A65", hash_generated_field = "41D013C95CABF9ED0796F94F0CF16BD1")

    int mTargetRequestCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "CE47E8E592EB95BEB04FBBE625E99A8D")

    boolean mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "0F910DB84DA919CEA0C46A9368EB474F", hash_generated_field = "5C009156D3400624CB1FFDF310ECAFF1")

    boolean mRemoving;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "D9B77340C245436344B0149264025068", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

    boolean mFromLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "02B7C51C439DA5E343271787FAA8C822", hash_generated_field = "C7463435817ABA85E5AF0081505BD656")

    boolean mInLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "F6C00A288B07FAA85B83595F41C31C30", hash_generated_field = "83846FEEE5AB5B668E6D933F96FB7819")

    boolean mRestored;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "48F5E8D87678F372810B137CFF79CDEE", hash_generated_field = "6F8CF3ED6C0707B98B23B55A256300E6")

    int mBackStackNesting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "58A45AD5F2F241F335F9B1ED7D27DC02")

    FragmentManagerImpl mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "DC6970CAF75184DB6DB1AAC52EA720C0")

    FragmentActivity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "16580FFD258A8A6FD12273C56DB3BF65", hash_generated_field = "AE50D4C4DA0E1D5FC77314F7EF03878D")

    FragmentManagerImpl mChildFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "B718B1EF16C11B894ED91B7026350839", hash_generated_field = "9348AE179085F33BE67C4C84253837E6")

    Fragment mParentFragment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "743B83D822DFF54AE7E24307CEF26F0C", hash_generated_field = "C628DB5A0351ABB6B2BC170D76A5FF43")

    int mFragmentId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "A2C9A3DA927DBE9AB0FC8FD8C7B637D9", hash_generated_field = "2072CAADE2B3735D2B37FDBC10B7F08E")

    int mContainerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

    String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "6E5D0646172E31357AC5264CFC6DCF7B", hash_generated_field = "DB81C7417E8D5BB2C252FB40F8D91CF8")

    boolean mHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "23906763A9631E67BD7C67265695AFF7", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

    boolean mDetached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "FC2473D51E767C5008A9D428BAFC8661", hash_generated_field = "907988FDE235BE080FDDB6DB36EF9C83")

    boolean mRetainInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "92B6BF5926849D268C59A8018D7DCB99", hash_generated_field = "98F2E6991F3565378DE3223CDDF9DBEB")

    boolean mHasMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "6E83E1BA32D4FE911AA4EE969D8C81B5", hash_generated_field = "91D8D4C712F4EB13688BF2F27B945286")

    boolean mMenuVisible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "8F73DC27B0DCA8E7133AEF9B7DBDC6C6", hash_generated_field = "6971FF9C6126C288092CCC2A5964E550")

    boolean mCalled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "B87B5DA5CC417CB9E4D2331FCCCAB736", hash_generated_field = "778908554529C0B97FC9B63E5B9208AD")

    int mNextAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "583453E78C87ED885A174C885F834BB6")

    ViewGroup mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "77F7C832CCC3D571F9FC590C7CFA715C", hash_generated_field = "02054D032013112C607BBD1766707DC1")

    View mInnerView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "E8D35768AE7CD7313BEF15C635AC96D9", hash_generated_field = "A8819B0E70BA304D51F44F47380E8807")

    boolean mDeferStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.651 -0400", hash_original_field = "2BDAE98A0CD238891DE96CFCEED42070", hash_generated_field = "149FC5E47A37645F1FE824C1875916A8")

    boolean mUserVisibleHint = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.652 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.652 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.652 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.652 -0400", hash_original_method = "450DCF9C44ABD4359E904BF858920888", hash_generated_method = "AF7EF93C180462CAFE5DFDA53E9C7DDF")
    public  Fragment() {
        
    }

    
        @DSModeled(DSC.SAFE)
    public static Fragment instantiate(Context context, String fname) {
        return instantiate(context, fname, null);
    }

    
        @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.653 -0400", hash_original_method = "245153A377A25A4032F77A4E144CB5DC", hash_generated_method = "536527893A8656B55D666018E47B3360")
    final void restoreViewState(Bundle savedInstanceState) {
        {
            mInnerView.restoreHierarchyState(mSavedViewState);
            mSavedViewState = null;
        } 
        mCalled = false;
        onViewStateRestored(savedInstanceState);
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onViewStateRestored()");
        } 
        addTaint(savedInstanceState.getTaint());
        
        
            
            
        
        
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.653 -0400", hash_original_method = "57A747EE3041ECA2E14E3727F10963D8", hash_generated_method = "1D17DDC30F55072C5F4F15D7C7F7F0BD")
    final void setIndex(int index, Fragment parent) {
        mIndex = index;
        {
            mWho = parent.mWho + ":" + mIndex;
        } 
        {
            mWho = "android:fragment:" + mIndex;
        } 
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.654 -0400", hash_original_method = "B0D28796550366EF842F99A3D9D59C11", hash_generated_method = "76DE19DB7899FD51DE1981EA0854D369")
    final boolean isInBackStack() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_288327310 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_288327310;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.654 -0400", hash_original_method = "055C1CABEC6B90DB231CF8138F07B9C1", hash_generated_method = "5B1965FF7B4E76C4BB963525909796D8")
    @Override
    final public boolean equals(Object o) {
        boolean var3B9F582BFED1483DB479DB197565FAB5_395239860 = (super.equals(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1231440198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1231440198;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.654 -0400", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "6F626BDC32A0CC1E3D60CC3C8A9D2FCE")
    @Override
    final public int hashCode() {
        int varC489EB7FF487A920847CC016ED55AE09_1401067812 = (super.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281600047 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_281600047;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.655 -0400", hash_original_method = "5350708001683FB5244A4F612B80A27C", hash_generated_method = "BB98292C2C071390FE0599671A44084E")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2051933670 = null; 
        StringBuilder sb = new StringBuilder(128);
        DebugUtils.buildShortClassTag(this, sb);
        {
            sb.append(" #");
            sb.append(mIndex);
        } 
        {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(mFragmentId));
        } 
        {
            sb.append(" ");
            sb.append(mTag);
        } 
        sb.append('}');
        varB4EAC82CA7396A68D541C85D26508E83_2051933670 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_2051933670.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2051933670;
        
        
        
        
            
            
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.655 -0400", hash_original_method = "0D814DEC27C2F0AC661487D8C7B38979", hash_generated_method = "5AD13E1994641942AAC9A4521F517F5D")
    final public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012956471 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1012956471;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.656 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "B5992DA1B7FD74D21947E093D9CA4AC7")
    final public String getTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_977531952 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_977531952 = mTag;
        varB4EAC82CA7396A68D541C85D26508E83_977531952.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_977531952;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.656 -0400", hash_original_method = "2D5CF4DC8DE7FCC73C8073BFA7412800", hash_generated_method = "1ED4BAF5C87366E8B439A343DBC39644")
    public void setArguments(Bundle args) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment already active");
        } 
        mArguments = args;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.657 -0400", hash_original_method = "AD916C2ECBF1A5C9327A86449330505D", hash_generated_method = "727F17A6190D5BAF4AAF81A3940F8415")
    final public Bundle getArguments() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_739125725 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_739125725 = mArguments;
        varB4EAC82CA7396A68D541C85D26508E83_739125725.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_739125725;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.657 -0400", hash_original_method = "D968C46759760C7406AC68A668D9806D", hash_generated_method = "F0337EA9BD20EA06BB854A3FCF019A9D")
    public void setInitialSavedState(SavedState state) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment already active");
        } 
        mSavedFragmentState = state != null && state.mState != null
                ? state.mState : null;
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.657 -0400", hash_original_method = "1E1EC1C5F204666846AC7A8EC55494F6", hash_generated_method = "A9E9A3E67F9FE2F0071A3B399678868D")
    public void setTargetFragment(Fragment fragment, int requestCode) {
        mTarget = fragment;
        mTargetRequestCode = requestCode;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.658 -0400", hash_original_method = "CBC4FCF13CA2895C8D01438D1D6F6EE8", hash_generated_method = "6642D37ABBE51FC10DE6E26F1C66C77D")
    final public Fragment getTargetFragment() {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1915794714 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1915794714 = mTarget;
        varB4EAC82CA7396A68D541C85D26508E83_1915794714.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1915794714;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.658 -0400", hash_original_method = "A4CEFC2C477EE57B614F4504E74127CE", hash_generated_method = "3168C195EBD271F51496513098C7F01C")
    final public int getTargetRequestCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_726883590 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_726883590;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.659 -0400", hash_original_method = "A48A2A81AB5F981679BE8C3496B55E59", hash_generated_method = "BB4C64929A1C52EDF469660420E82B39")
    final public FragmentActivity getActivity() {
        FragmentActivity varB4EAC82CA7396A68D541C85D26508E83_957926572 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_957926572 = mActivity;
        varB4EAC82CA7396A68D541C85D26508E83_957926572.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_957926572;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.659 -0400", hash_original_method = "A8E18DB36BC334E1CF5901C727187C18", hash_generated_method = "B69757ADCFB21620FE449094B74602E1")
    final public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_107616241 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_107616241 = mActivity.getResources();
        varB4EAC82CA7396A68D541C85D26508E83_107616241.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_107616241;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.661 -0400", hash_original_method = "3F649A13E84C6501035126B3FEE231F4", hash_generated_method = "A38688604D5A01DB240A66B4818C996C")
    public final CharSequence getText(int resId) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1130058655 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1130058655 = getResources().getText(resId);
        addTaint(resId);
        varB4EAC82CA7396A68D541C85D26508E83_1130058655.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1130058655;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.662 -0400", hash_original_method = "6096F9B7D678CAFA7D67C1784ABCB9A7", hash_generated_method = "64EDE1A6B1DBBEAD2F962BDBDE547004")
    public final String getString(int resId) {
        String varB4EAC82CA7396A68D541C85D26508E83_382042551 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_382042551 = getResources().getString(resId);
        addTaint(resId);
        varB4EAC82CA7396A68D541C85D26508E83_382042551.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_382042551;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.663 -0400", hash_original_method = "524F00C5C13CBD3BD0D5C512A4C12294", hash_generated_method = "156D3ECD5DEF23550D9E40800F2BBB85")
    public final String getString(int resId, Object... formatArgs) {
        String varB4EAC82CA7396A68D541C85D26508E83_1063245710 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1063245710 = getResources().getString(resId, formatArgs);
        addTaint(resId);
        addTaint(formatArgs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1063245710.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1063245710;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.664 -0400", hash_original_method = "ED1BD18F392C2062694622C1FF4A3A44", hash_generated_method = "A621E02CB500FF4E5FE6D4234E136806")
    final public FragmentManager getFragmentManager() {
        FragmentManager varB4EAC82CA7396A68D541C85D26508E83_686797452 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_686797452 = mFragmentManager;
        varB4EAC82CA7396A68D541C85D26508E83_686797452.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_686797452;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.664 -0400", hash_original_method = "CC97C175240EBBDE3DE45127B977288B", hash_generated_method = "3E83D9D584FBAFFFC2A4E8BC36A23DF7")
    final public FragmentManager getChildFragmentManager() {
        FragmentManager varB4EAC82CA7396A68D541C85D26508E83_22712800 = null; 
        {
            instantiateChildFragmentManager();
            {
                mChildFragmentManager.dispatchResume();
            } 
            {
                mChildFragmentManager.dispatchStart();
            } 
            {
                mChildFragmentManager.dispatchActivityCreated();
            } 
            {
                mChildFragmentManager.dispatchCreate();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_22712800 = mChildFragmentManager;
        varB4EAC82CA7396A68D541C85D26508E83_22712800.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_22712800;
        
        
            
            
                
            
                
            
                
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.665 -0400", hash_original_method = "B31DB62F63300A3D3A62AFCA68722969", hash_generated_method = "72B6BFF2FDCBBA7AEC82DB7FC547A02C")
    final public Fragment getParentFragment() {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_312295300 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_312295300 = mParentFragment;
        varB4EAC82CA7396A68D541C85D26508E83_312295300.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_312295300;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.665 -0400", hash_original_method = "C0D74F5DDFD9A01C19E54F3379BA7652", hash_generated_method = "F7EAA6DD5521ED4C93AB625A49840213")
    final public boolean isAdded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1258933119 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1258933119;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.666 -0400", hash_original_method = "2F8509F8C4A8638224A8FC9748BC6275", hash_generated_method = "D3EE00E433D6F714977862BB31D98689")
    final public boolean isDetached() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_53597074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_53597074;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.666 -0400", hash_original_method = "914BD43FF0612F84BA345FA6F486595C", hash_generated_method = "595DE114AA03F24377D7EEAD1041CE8B")
    final public boolean isRemoving() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1003874108 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1003874108;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.666 -0400", hash_original_method = "3C6E7329283D3C6C46FB3F90EF65A4A7", hash_generated_method = "DCEDD6E3A61CC8FF798FFB4801117B8C")
    final public boolean isInLayout() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1379115452 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1379115452;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.667 -0400", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "17958869D438811A4818B1CB4E84C75A")
    final public boolean isResumed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_674520884 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_674520884;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.667 -0400", hash_original_method = "72982976B71B01DF2412198462460DF0", hash_generated_method = "998ADF4EA4B84352D18B66ADCCDDE51C")
    final public boolean isVisible() {
        boolean var643645FADE5E75870E219C4E3A66DBAE_1393699235 = (isAdded() && !isHidden() && mView != null
                && mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1735097854 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1735097854;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.667 -0400", hash_original_method = "E04FD968639295CCE5F791161EDE4496", hash_generated_method = "A1EDC5B111262B85248A087A551FB477")
    final public boolean isHidden() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_511627074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_511627074;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.667 -0400", hash_original_method = "FE8A5DF015D2662392185902D9D0AEDD", hash_generated_method = "764071413F7B945096A2936EA3340233")
    public void onHiddenChanged(boolean hidden) {
        
        addTaint(hidden);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.668 -0400", hash_original_method = "DD8E6A20AB766DE2DFF904C4C63DFDE5", hash_generated_method = "B609BAEF1B936256B05D620F42F6AFE5")
    public void setRetainInstance(boolean retain) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "Can't retain fragements that are nested in other fragments");
        } 
        mRetainInstance = retain;
        
        
            
                    
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.668 -0400", hash_original_method = "82A17104D5864E2285E97283523AA6C5", hash_generated_method = "F23C89DCE19FEC15B5B9E02C4AE833F8")
    final public boolean getRetainInstance() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_610521128 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_610521128;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.669 -0400", hash_original_method = "8AC8C0F5EC4C557D4FB057E17EB98486", hash_generated_method = "F2287A704E3B5DCA6C07CCD4C1857225")
    public void setHasOptionsMenu(boolean hasMenu) {
        {
            mHasMenu = hasMenu;
            {
                boolean var6410BF1E9EE91D719771624EE688382C_822761911 = (isAdded() && !isHidden());
                {
                    mActivity.supportInvalidateOptionsMenu();
                } 
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.669 -0400", hash_original_method = "356D4C9378C3D90FECF449857449A450", hash_generated_method = "F277A83C28FB1325B567B572808B9CB7")
    public void setMenuVisibility(boolean menuVisible) {
        {
            mMenuVisible = menuVisible;
            {
                boolean var63EEDD19FAB3C7E50D3EC385E85195BC_1027719265 = (mHasMenu && isAdded() && !isHidden());
                {
                    mActivity.supportInvalidateOptionsMenu();
                } 
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.670 -0400", hash_original_method = "1B0128696FF26E02ABF181CBEC60E7DF", hash_generated_method = "6FDEB47DFBFCCF8C09B690FDC4838CA5")
    public void setUserVisibleHint(boolean isVisibleToUser) {
        {
            mFragmentManager.performPendingDeferredStart(this);
        } 
        mUserVisibleHint = isVisibleToUser;
        mDeferStart = !isVisibleToUser;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.670 -0400", hash_original_method = "16570E728AF342CDACA5E18099682804", hash_generated_method = "6AD4ECCCB67F59404F5C432CE2873900")
    public boolean getUserVisibleHint() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1239409861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1239409861;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.672 -0400", hash_original_method = "F00ECADA9A0E38D0B8B713B009F5D3F7", hash_generated_method = "CDAAB0AC079AEBF055FB905D51D8734C")
    public LoaderManager getLoaderManager() {
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_1661219651 = null; 
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_367216618 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1661219651 = mLoaderManager;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } 
        mCheckedForLoaderManager = true;
        mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, true);
        varB4EAC82CA7396A68D541C85D26508E83_367216618 = mLoaderManager;
        LoaderManager varA7E53CE21691AB073D9660D615818899_775168534; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_775168534 = varB4EAC82CA7396A68D541C85D26508E83_1661219651;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_775168534 = varB4EAC82CA7396A68D541C85D26508E83_367216618;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_775168534.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_775168534;
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.673 -0400", hash_original_method = "B68B30EDC5AB3BE8EF657FB7051C7F7E", hash_generated_method = "034AFFA898CD52B33567D6F4ACA58FB1")
    public void startActivity(Intent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } 
        mActivity.startActivityFromFragment(this, intent, -1);
        addTaint(intent.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.673 -0400", hash_original_method = "849399EB62F8B6EE6A6E550D7989B87C", hash_generated_method = "FA0152001483243EABA7E04774885D8D")
    public void startActivityForResult(Intent intent, int requestCode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } 
        mActivity.startActivityFromFragment(this, intent, requestCode);
        addTaint(intent.getTaint());
        addTaint(requestCode);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.673 -0400", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "13FACCD4A154E6B91F08CDAC9AEA6EFF")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.674 -0400", hash_original_method = "8FF008E86C71DF2CF57F1B9E3E9D8CD9", hash_generated_method = "599EC3B43FB5440B712E002762FBB476")
    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_239616461 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_239616461 = mActivity.getLayoutInflater();
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_239616461.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_239616461;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.675 -0400", hash_original_method = "6B431F4170E83AA9D07B8C377544B225", hash_generated_method = "9DA4C20C8A19E611A8973863DB823C49")
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        
        mCalled = true;
        addTaint(activity.getTaint());
        addTaint(attrs.getTaint());
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.675 -0400", hash_original_method = "7FCB8118913FF635CB1CDE717E61023E", hash_generated_method = "8D44122C10CCAD99B6B0F3E7B51550CD")
    public void onAttach(Activity activity) {
        
        mCalled = true;
        addTaint(activity.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.676 -0400", hash_original_method = "273C1CEA731372543F92C5C1B99E7FBF", hash_generated_method = "9B1A1D6EC20E11AA39EC1169F07F07B8")
    public Animation onCreateAnimation(int transit, boolean enter, int nextAnim) {
        
        Animation varB4EAC82CA7396A68D541C85D26508E83_1064040800 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1064040800 = null;
        addTaint(transit);
        addTaint(enter);
        addTaint(nextAnim);
        varB4EAC82CA7396A68D541C85D26508E83_1064040800.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1064040800;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.676 -0400", hash_original_method = "00494AECA41C1730DF6E82548FC2C3D5", hash_generated_method = "A703DECD1A13E142CAFC14CA278F8464")
    public void onCreate(Bundle savedInstanceState) {
        
        mCalled = true;
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.676 -0400", hash_original_method = "57C338AB393ED440CE12C76B2627A085", hash_generated_method = "230CF08797FB94603D0FD29E094801B5")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
        View varB4EAC82CA7396A68D541C85D26508E83_1991250200 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1991250200 = null;
        addTaint(inflater.getTaint());
        addTaint(container.getTaint());
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1991250200.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1991250200;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.677 -0400", hash_original_method = "F4318A499F9B06ABC9CCF0644AE6DC10", hash_generated_method = "0AC185C4D1405DA07D13BEEEF3A63E65")
    public void onViewCreated(View view, Bundle savedInstanceState) {
        
        addTaint(view.getTaint());
        addTaint(savedInstanceState.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.677 -0400", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "D4C3BBF4EDAC27A6B843719CED0261C4")
    public View getView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1424671868 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1424671868 = mView;
        varB4EAC82CA7396A68D541C85D26508E83_1424671868.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1424671868;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.678 -0400", hash_original_method = "C52625884C98429BE8DE42F4FBFE7367", hash_generated_method = "7167642356FF710749355DABB699B2F5")
    public void onActivityCreated(Bundle savedInstanceState) {
        
        mCalled = true;
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.678 -0400", hash_original_method = "01C4E5BCA343F9B21B52342AACDB7055", hash_generated_method = "89724E38A912BE849724EECB293ACDC9")
    public void onViewStateRestored(Bundle savedInstanceState) {
        
        mCalled = true;
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.678 -0400", hash_original_method = "EDAB2E7FCE4E0A13012A045AB5CD29D5", hash_generated_method = "8E60C60FEE8764EDA2458ADD05B31E92")
    public void onStart() {
        
        mCalled = true;
        {
            mLoadersStarted = true;
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, false);
            } 
            {
                mLoaderManager.doStart();
            } 
        } 
        
        
        
            
            
                
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.679 -0400", hash_original_method = "3B8608ED59C2663D271D57F8D8F534C0", hash_generated_method = "A35C9648644440B1AB73336CCB6DEAB5")
    public void onResume() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.679 -0400", hash_original_method = "9C4F98F3F5A4FCEFF66E261EDA5693F3", hash_generated_method = "AD15648AB8B6357D84B3060587BAA98F")
    public void onSaveInstanceState(Bundle outState) {
        
        addTaint(outState.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.679 -0400", hash_original_method = "16A05561D5415124B893EA7E2AFB953D", hash_generated_method = "F6F68BCCFBFEF8D06BF8C744D4370BE8")
    public void onConfigurationChanged(Configuration newConfig) {
        
        mCalled = true;
        addTaint(newConfig.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.680 -0400", hash_original_method = "CEF2FF1DA31E7EE9D761807A037B37B2", hash_generated_method = "637684B70754E8D79E076DC6A513E031")
    public void onPause() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.680 -0400", hash_original_method = "FC062A9ECA017F6E5D455E8C973942F9", hash_generated_method = "7E26AAA6FA11DEDE75C340853A5FC7A3")
    public void onStop() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.681 -0400", hash_original_method = "28328842E1AEC7ECF313405184622A29", hash_generated_method = "A607A7A5A4E7888F4F9DD46B7BE5C1AF")
    public void onLowMemory() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.681 -0400", hash_original_method = "E54F17C7BAFD082A48D2152349C1815A", hash_generated_method = "D6DBBF3121DDE73B3DDC3BCBF558AE8E")
    public void onDestroyView() {
        
        mCalled = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.682 -0400", hash_original_method = "FBD8F2B4105FF1952BBC9E4FBE11F6B2", hash_generated_method = "5C724FDB233E5FE07CB5E0C6677110F6")
    public void onDestroy() {
        
        mCalled = true;
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, false);
        } 
        {
            mLoaderManager.doDestroy();
        } 
        
        
        
            
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.683 -0400", hash_original_method = "04633BF5293F80973E1AA355DB2C35EF", hash_generated_method = "4C027456133F87915A9EF12926708CE0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.683 -0400", hash_original_method = "EF609D2FD1394DFBC19807CB21AD7D10", hash_generated_method = "CD3AD86EF54BB27DA72F7E9F9B9DEA15")
    public void onDetach() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.684 -0400", hash_original_method = "B3C5F3D019B47C47E6111F1C7C38CA5D", hash_generated_method = "A2AC01879561E76B9598F6018B2688B1")
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        
        addTaint(menu.getTaint());
        addTaint(inflater.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.684 -0400", hash_original_method = "4CE703F4C1FA6FC474411DFE6A3F5275", hash_generated_method = "32B650DEFAD74BF60D957C3D22EC9F79")
    public void onPrepareOptionsMenu(Menu menu) {
        
        addTaint(menu.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.684 -0400", hash_original_method = "0E8C037F224061747BFFD0611606AAB6", hash_generated_method = "EF044D3D33EBB476DBBCFB32576782C1")
    public void onDestroyOptionsMenu() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.685 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "F191E4851510682B96AAA00A27AC6071")
    public boolean onOptionsItemSelected(MenuItem item) {
        
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_469394286 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_469394286;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.685 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "CC9F879215C8D6911F3F43FE45124EF9")
    public void onOptionsMenuClosed(Menu menu) {
        
        addTaint(menu.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.685 -0400", hash_original_method = "68082EA0714CB57B78AC95D3FF2A7AC8", hash_generated_method = "B68B5B7B29E7468FD3122292CC31611A")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        
        getActivity().onCreateContextMenu(menu, v, menuInfo);
        addTaint(menu.getTaint());
        addTaint(v.getTaint());
        addTaint(menuInfo.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.686 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "0FEECD9EF1102B65D35844FDFD151864")
    public void registerForContextMenu(View view) {
        
        view.setOnCreateContextMenuListener(this);
        addTaint(view.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.686 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "344591114B98358744F7FCF1C426D7AD")
    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
        addTaint(view.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.686 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "6DD4E56B5C76994CFDE4293F27681901")
    public boolean onContextItemSelected(MenuItem item) {
        
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1869942699 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1869942699;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.687 -0400", hash_original_method = "4506E0F094FC2CBE2D517E6D81344EC6", hash_generated_method = "F030835EA25D27D80D17DE3F33D93CAC")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
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
        {
            writer.print(prefix);
            writer.print("mFragmentManager=");
            writer.println(mFragmentManager);
        } 
        {
            writer.print(prefix);
            writer.print("mActivity=");
            writer.println(mActivity);
        } 
        {
            writer.print(prefix);
            writer.print("mParentFragment=");
            writer.println(mParentFragment);
        } 
        {
            writer.print(prefix);
            writer.print("mArguments=");
            writer.println(mArguments);
        } 
        {
            writer.print(prefix);
            writer.print("mSavedFragmentState=");
            writer.println(mSavedFragmentState);
        } 
        {
            writer.print(prefix);
            writer.print("mSavedViewState=");
            writer.println(mSavedViewState);
        } 
        {
            writer.print(prefix);
            writer.print("mTarget=");
            writer.print(mTarget);
            writer.print(" mTargetRequestCode=");
            writer.println(mTargetRequestCode);
        } 
        {
            writer.print(prefix);
            writer.print("mNextAnim=");
            writer.println(mNextAnim);
        } 
        {
            writer.print(prefix);
            writer.print("mContainer=");
            writer.println(mContainer);
        } 
        {
            writer.print(prefix);
            writer.print("mView=");
            writer.println(mView);
        } 
        {
            writer.print(prefix);
            writer.print("mInnerView=");
            writer.println(mView);
        } 
        {
            writer.print(prefix);
            writer.print("mAnimatingAway=");
            writer.println(mAnimatingAway);
            writer.print(prefix);
            writer.print("mStateAfterAnimating=");
            writer.println(mStateAfterAnimating);
        } 
        {
            writer.print(prefix);
            writer.println("Loader Manager:");
            mLoaderManager.dump(prefix + "  ", fd, writer, args);
        } 
        {
            writer.print(prefix);
            writer.println("Child " + mChildFragmentManager + ":");
            mChildFragmentManager.dump(prefix + "  ", fd, writer, args);
        } 
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.688 -0400", hash_original_method = "61D88876092ADD5F15473E2AB4FA77D3", hash_generated_method = "90DC5E90DA10D128B9BF80B9121C7BD5")
     Fragment findFragmentByWho(String who) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1790362132 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1876134641 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1044384832 = null; 
        {
            boolean varC7146AD42A60BAFDF58E0A6181ED7187_1437058467 = (who.equals(mWho));
            {
                varB4EAC82CA7396A68D541C85D26508E83_1790362132 = this;
            } 
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1876134641 = mChildFragmentManager.findFragmentByWho(who);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1044384832 = null;
        addTaint(who.getTaint());
        Fragment varA7E53CE21691AB073D9660D615818899_712014213; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_712014213 = varB4EAC82CA7396A68D541C85D26508E83_1790362132;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_712014213 = varB4EAC82CA7396A68D541C85D26508E83_1876134641;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_712014213 = varB4EAC82CA7396A68D541C85D26508E83_1044384832;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_712014213.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_712014213;
        
        
            
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.690 -0400", hash_original_method = "EDAB121E0E9B6E6FAA5680C6215916BF", hash_generated_method = "7EA4F3D42F3757EA6FE346E72676B20A")
     void instantiateChildFragmentManager() {
        mChildFragmentManager = new FragmentManagerImpl();
        mChildFragmentManager.attachActivity(mActivity, new FragmentContainer() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.689 -0400", hash_original_method = "5BED041A00050D47AD1342402B9985BC", hash_generated_method = "3230D7BD355CDF3CA47D48DAEC7FE20A")
            @Override
            public View findViewById(int id) {
                View varB4EAC82CA7396A68D541C85D26508E83_154361188 = null; 
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment does not have a view");
                } 
                varB4EAC82CA7396A68D541C85D26508E83_154361188 = mView.findViewById(id);
                addTaint(id);
                varB4EAC82CA7396A68D541C85D26508E83_154361188.addTaint(getTaint()); 
                return varB4EAC82CA7396A68D541C85D26508E83_154361188;
                
                
                    
                
                
            }
}, this);
        
        
        
            
            
                
                    
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.690 -0400", hash_original_method = "3EE407E16277E3B3A8635005B5A0DEC4", hash_generated_method = "5C5C195657C3AEAEA211576ABAB3F9BF")
     void performCreate(Bundle savedInstanceState) {
        {
            mChildFragmentManager.noteStateNotSaved();
        } 
        mCalled = false;
        onCreate(savedInstanceState);
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onCreate()");
        } 
        {
            Parcelable p = savedInstanceState.getParcelable(
                    FragmentActivity.FRAGMENTS_TAG);
            {
                {
                    instantiateChildFragmentManager();
                } 
                mChildFragmentManager.restoreAllState(p, null);
                mChildFragmentManager.dispatchCreate();
            } 
        } 
        addTaint(savedInstanceState.getTaint());
        
        
            
        
        
        
        
            
                    
        
        
            
                    
            
                
                    
                
                
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.692 -0400", hash_original_method = "C9098E0ABE3DD99AEB89FC060D15CE33", hash_generated_method = "4D9C44922694105E4889F24EF7143409")
     View performCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View varB4EAC82CA7396A68D541C85D26508E83_1605505140 = null; 
        {
            mChildFragmentManager.noteStateNotSaved();
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1605505140 = onCreateView(inflater, container, savedInstanceState);
        addTaint(inflater.getTaint());
        addTaint(container.getTaint());
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1605505140.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1605505140;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.693 -0400", hash_original_method = "6B9A0B76E81212CD14FFC5CCF383D5D3", hash_generated_method = "E65D9F2477C9069011B9E80BBB53A499")
     void performActivityCreated(Bundle savedInstanceState) {
        {
            mChildFragmentManager.noteStateNotSaved();
        } 
        mCalled = false;
        onActivityCreated(savedInstanceState);
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onActivityCreated()");
        } 
        {
            mChildFragmentManager.dispatchActivityCreated();
        } 
        addTaint(savedInstanceState.getTaint());
        
        
            
        
        
        
        
            
                    
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.693 -0400", hash_original_method = "FAC6959B7963C55ED04FD140D265CD92", hash_generated_method = "07BEAD395370EA3EC0727F1F6038B075")
     void performStart() {
        {
            mChildFragmentManager.noteStateNotSaved();
            mChildFragmentManager.execPendingActions();
        } 
        mCalled = false;
        onStart();
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onStart()");
        } 
        {
            mChildFragmentManager.dispatchStart();
        } 
        {
            mLoaderManager.doReportStart();
        } 
        
        
            
            
        
        
        
        
            
                    
        
        
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.694 -0400", hash_original_method = "225800A7AAA9ACBE89033DE187291152", hash_generated_method = "B3F7593B0FEB6D6784493B39DBF02580")
     void performResume() {
        {
            mChildFragmentManager.noteStateNotSaved();
            mChildFragmentManager.execPendingActions();
        } 
        mCalled = false;
        onResume();
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onResume()");
        } 
        {
            mChildFragmentManager.dispatchResume();
            mChildFragmentManager.execPendingActions();
        } 
        
        
            
            
        
        
        
        
            
                    
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.694 -0400", hash_original_method = "4CF76F87E5378DAC79600BD4B0530AEF", hash_generated_method = "F765779D44D11859B1FEF5EB95F0986F")
     void performConfigurationChanged(Configuration newConfig) {
        onConfigurationChanged(newConfig);
        {
            mChildFragmentManager.dispatchConfigurationChanged(newConfig);
        } 
        addTaint(newConfig.getTaint());
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.695 -0400", hash_original_method = "F077F2C753E805161BC608B27E561A9B", hash_generated_method = "490F5AA86629811DBE459BE9E49EAC59")
     void performLowMemory() {
        onLowMemory();
        {
            mChildFragmentManager.dispatchLowMemory();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.695 -0400", hash_original_method = "EDE9801703CADFBAB935432E700FE9D4", hash_generated_method = "50B81C811D13B36FF92571E4B8239AFE")
     boolean performCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        boolean show = false;
        {
            {
                show = true;
                onCreateOptionsMenu(menu, inflater);
            } 
            {
                show |= mChildFragmentManager.dispatchCreateOptionsMenu(menu, inflater);
            } 
        } 
        addTaint(menu.getTaint());
        addTaint(inflater.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1370217580 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1370217580;
        
        
        
            
                
                
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.696 -0400", hash_original_method = "27D1E8CFF71284C61956522356EF62A1", hash_generated_method = "860585DE13B92CB9A0DD9734C8C4E153")
     boolean performPrepareOptionsMenu(Menu menu) {
        boolean show = false;
        {
            {
                show = true;
                onPrepareOptionsMenu(menu);
            } 
            {
                show |= mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
            } 
        } 
        addTaint(menu.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_464408187 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_464408187;
        
        
        
            
                
                
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.696 -0400", hash_original_method = "AB066317960C5B7A87CEEFD90F19CB53", hash_generated_method = "8E14C969E115F5A58C6A1413FCF02034")
     boolean performOptionsItemSelected(MenuItem item) {
        {
            {
                {
                    boolean var0E7B279FC9BEB736499E8251F8A1A024_448418645 = (onOptionsItemSelected(item));
                } 
            } 
            {
                {
                    boolean var15D8FEAD3E350BF8342201E9382C0D38_1962955207 = (mChildFragmentManager.dispatchOptionsItemSelected(item));
                } 
            } 
        } 
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1897462767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1897462767;
        
        
            
                
                    
                
            
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.697 -0400", hash_original_method = "78AAFDAC6C7C01B066E741BD144002F2", hash_generated_method = "73E9E31E9A17CBB2BA638CE6B8C5FC70")
     boolean performContextItemSelected(MenuItem item) {
        {
            {
                boolean varD3737DE067E0588EDBE81C81E1C8DB66_1832059955 = (onContextItemSelected(item));
            } 
            {
                {
                    boolean var388B538438B883A53469174C8FD0D9B2_1598085545 = (mChildFragmentManager.dispatchContextItemSelected(item));
                } 
            } 
        } 
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_987593051 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_987593051;
        
        
            
                
            
            
                
                    
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.697 -0400", hash_original_method = "4DDEE08146B46D76D3DC17885A5DDDC2", hash_generated_method = "7C3BF09B170E9F4C6F74A155EBCDB10B")
     void performOptionsMenuClosed(Menu menu) {
        {
            {
                onOptionsMenuClosed(menu);
            } 
            {
                mChildFragmentManager.dispatchOptionsMenuClosed(menu);
            } 
        } 
        addTaint(menu.getTaint());
        
        
            
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.697 -0400", hash_original_method = "229F45787776B9C5A3449A8AF116842B", hash_generated_method = "0F6E160E4055E385DD1D2B2943D2FE3B")
     void performSaveInstanceState(Bundle outState) {
        onSaveInstanceState(outState);
        {
            Parcelable p = mChildFragmentManager.saveAllState();
            {
                outState.putParcelable(FragmentActivity.FRAGMENTS_TAG, p);
            } 
        } 
        addTaint(outState.getTaint());
        
        
        
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.698 -0400", hash_original_method = "E981410A628A778E5EC5758D81394A36", hash_generated_method = "653C8309A85CE9A8EA17024DE0FC9080")
     void performPause() {
        {
            mChildFragmentManager.dispatchPause();
        } 
        mCalled = false;
        onPause();
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onPause()");
        } 
        
        
            
        
        
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.698 -0400", hash_original_method = "A54D340AC4C554E09C318AFC86BC07BD", hash_generated_method = "C822ED615142AFDBC1201FA4E5CACA07")
     void performStop() {
        {
            mChildFragmentManager.dispatchStop();
        } 
        mCalled = false;
        onStop();
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onStop()");
        } 
        
        
            
        
        
        
        
            
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.698 -0400", hash_original_method = "E7DDF1CA54A3F6D13CAA1A65082611F8", hash_generated_method = "370166331D9A90701F6726520AB981D5")
     void performReallyStop() {
        {
            mChildFragmentManager.dispatchReallyStop();
        } 
        {
            mLoadersStarted = false;
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mWho, mLoadersStarted, false);
            } 
            {
                {
                    mLoaderManager.doStop();
                } 
                {
                    mLoaderManager.doRetain();
                } 
            } 
        } 
        
        
            
        
        
            
            
                
                
            
            
                
                    
                
                    
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.699 -0400", hash_original_method = "A7577DB153B8A046DC326874EE7B0A4B", hash_generated_method = "79A13FE3BB7BF947AC0DD31F6530258D")
     void performDestroyView() {
        {
            mChildFragmentManager.dispatchDestroyView();
        } 
        mCalled = false;
        onDestroyView();
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onDestroyView()");
        } 
        {
            mLoaderManager.doReportNextStart();
        } 
        
        
            
        
        
        
        
            
                    
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.699 -0400", hash_original_method = "6BD30978B327739DC7CB2841A03C0980", hash_generated_method = "CF3D78B284A299AFB33800D46BF0936D")
     void performDestroy() {
        {
            mChildFragmentManager.dispatchDestroy();
        } 
        mCalled = false;
        onDestroy();
        {
            if (DroidSafeAndroidRuntime.control) throw new SuperNotCalledException("Fragment " + this
                    + " did not call through to super.onDestroy()");
        } 
        
        
            
        
        
        
        
            
                    
        
    }

    
    public static class SavedState implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.699 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "AA4A80FE6E8C28CFC04031C8CFFC3C9D")

        Bundle mState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.700 -0400", hash_original_method = "7D4CB1BC3C04B99DC21EA19CB6BAF4D3", hash_generated_method = "BAE726BCB2EFD4A0280978447E5417B6")
          SavedState(Bundle state) {
            mState = state;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.700 -0400", hash_original_method = "E611F4C5C5E159704631D93ABD994DEF", hash_generated_method = "2C9CB5FE3CDE5ABA795E1EBDDA05A7F3")
          SavedState(Parcel in, ClassLoader loader) {
            mState = in.readBundle();
            {
                mState.setClassLoader(loader);
            } 
            addTaint(loader.getTaint());
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.701 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7D5604A4B2B9A09C7A6C855230E49FA2")
        @Override
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717045484 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1717045484;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.701 -0400", hash_original_method = "ACF88B4EF312D321A4777388A96F3566", hash_generated_method = "09F2B398AE4A3BD919542940FA9DB2FB")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeBundle(mState);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.702 -0400", hash_original_field = "A42D60237D21D4808CE78C5691FA3200", hash_generated_field = "FB9BD5541F55208F5BC20C32E5AB0F3E")

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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.702 -0400", hash_original_method = "9A59F9C8F177B5B07F720376B1CE8BCE", hash_generated_method = "AF08BB7903F079548F45BF553D77E4CE")
        public  InstantiationException(String msg, Exception cause) {
            super(msg, cause);
            addTaint(msg.getTaint());
            addTaint(cause.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.702 -0400", hash_original_field = "24A48BEA88D09CCBC63A8677385B95A8", hash_generated_field = "EB0A976F34844AD55F975EEF50A2B1A3")

    private static final HashMap<String, Class<?>> sClassMap = new HashMap<String, Class<?>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.703 -0400", hash_original_field = "403EB1653B87B88BD21AEF72194EF5E0", hash_generated_field = "B9FFABD80C3D80703D84376667A75609")

    static final int INITIALIZING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.703 -0400", hash_original_field = "6EFDDF5DE9E2142D56B3E098F844AE40", hash_generated_field = "97B36236CFE06BD1C50B96E10CE241B6")

    static final int CREATED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.703 -0400", hash_original_field = "18C3D4E620F8352BDF3CA097C14B87F7", hash_generated_field = "00E5F9933DCF6CD0A60E606E52C7FADE")

    static final int ACTIVITY_CREATED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.703 -0400", hash_original_field = "456918D615E944292D78BC88E852291C", hash_generated_field = "2CEA28884A245A0CE49FCF31D0D6588D")

    static final int STOPPED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.703 -0400", hash_original_field = "C604B9D3F56F632433E5FA0C79127BB7", hash_generated_field = "4F033F865040D83003D856BED757C437")

    static final int STARTED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.703 -0400", hash_original_field = "FF953E97A61C82A8BD259E088591325D", hash_generated_field = "562F93666D34FFE3A5D8899053C80C4E")

    static final int RESUMED = 5;
}

