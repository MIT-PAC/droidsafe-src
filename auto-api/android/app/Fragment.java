package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.834 -0400", hash_original_field = "E0F3773C57D5A4C143336ECFEFDE9748", hash_generated_field = "6BC238A3BDD37BF1CAC26EA2CE45C508")

    String mClassName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.834 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.834 -0400", hash_original_field = "D9B77340C245436344B0149264025068", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

    boolean mFromLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.834 -0400", hash_original_field = "743B83D822DFF54AE7E24307CEF26F0C", hash_generated_field = "C628DB5A0351ABB6B2BC170D76A5FF43")

    int mFragmentId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.834 -0400", hash_original_field = "A2C9A3DA927DBE9AB0FC8FD8C7B637D9", hash_generated_field = "2072CAADE2B3735D2B37FDBC10B7F08E")

    int mContainerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.834 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

    String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.835 -0400", hash_original_field = "FC2473D51E767C5008A9D428BAFC8661", hash_generated_field = "907988FDE235BE080FDDB6DB36EF9C83")

    boolean mRetainInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.835 -0400", hash_original_field = "23906763A9631E67BD7C67265695AFF7", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

    boolean mDetached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.835 -0400", hash_original_field = "5867CE8CB088E58E6D17882F8EE91C5B", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

    Bundle mArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.835 -0400", hash_original_field = "74933D8F8D085F6D27B373C3AD9FBBC4", hash_generated_field = "F958FB3998EC484A7599A988303CD216")

    Bundle mSavedFragmentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.835 -0400", hash_original_field = "DD62467EBA66E288A1769E403146FE2D", hash_generated_field = "F83F5A158F2251FA12452672DC97E470")

    Fragment mInstance;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.835 -0400", hash_original_method = "116485142A61C36D4B47DBE9BCB45890", hash_generated_method = "9C8B1F3AA1DA7C8FAE9B803347EE426A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.837 -0400", hash_original_method = "46F838C8877526D395D980C698E03728", hash_generated_method = "1AEC5D39B1C46172E66E2ADE1F21E5F6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.839 -0400", hash_original_method = "64945B874E9F798BEAFB62D4A4B63532", hash_generated_method = "4DF7425CC736BD9209C70DA463967BB7")
    public Fragment instantiate(Activity activity) {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1825757757 = null; 
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1461407402 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1825757757 = mInstance;
        } 
        {
            mArguments.setClassLoader(activity.getClassLoader());
        } 
        mInstance = Fragment.instantiate(activity, mClassName, mArguments);
        {
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
        varB4EAC82CA7396A68D541C85D26508E83_1461407402 = mInstance;
        Fragment varA7E53CE21691AB073D9660D615818899_678042821; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_678042821 = varB4EAC82CA7396A68D541C85D26508E83_1825757757;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_678042821 = varB4EAC82CA7396A68D541C85D26508E83_1461407402;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_678042821.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_678042821;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.840 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "3DDC22198F8D6B43DFCFAE30299BD0B9")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1477920023 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1477920023;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.841 -0400", hash_original_method = "5938F2E0A344A05A5347D3909CB444C6", hash_generated_method = "3F956FAB5615EA38678EDAD56B20ED1C")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.841 -0400", hash_original_field = "20C24B13B86A2BA0167AA1764B64C330", hash_generated_field = "33682AAE42971F2215D5844A73451D2E")

    public static final Parcelable.Creator<FragmentState> CREATOR
            = new Parcelable.Creator<FragmentState>() {
        public FragmentState createFromParcel(Parcel in) {
            return new FragmentState(in);
        }
        
        public FragmentState[] newArray(int size) {
            return new FragmentState[size];
        }
    };
    
    public FragmentState createFromParcel(Parcel in) {
            return new FragmentState(in);
        }
    
    
    public FragmentState[] newArray(int size) {
            return new FragmentState[size];
        }
    
}

public class Fragment implements ComponentCallbacks2, OnCreateContextMenuListener {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.842 -0400", hash_original_field = "F6222ECFC0F3B677015F93D1974DAF06", hash_generated_field = "0294DD5CAC8ED58250DA531156A3A018")

    int mState = INITIALIZING;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.842 -0400", hash_original_field = "BDE9D2B3E8C16F6173B11304E226AD48", hash_generated_field = "ECF8328501B577B29900A98481ADA801")

    Animator mAnimatingAway;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.842 -0400", hash_original_field = "8ED4FBC10C3DA2C5D7785F68532DB880", hash_generated_field = "AA12B8E459D536EFC9893454A513D5AA")

    int mStateAfterAnimating;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.842 -0400", hash_original_field = "74933D8F8D085F6D27B373C3AD9FBBC4", hash_generated_field = "F958FB3998EC484A7599A988303CD216")

    Bundle mSavedFragmentState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.842 -0400", hash_original_field = "2B7B591D0427765FF0500D38736CF518", hash_generated_field = "03C65AC0399DBB932968B6C681CFC16A")

    SparseArray<Parcelable> mSavedViewState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.842 -0400", hash_original_field = "DBDF7BB492A85A363C47FDDA34C5BB3E", hash_generated_field = "6B9186F1D8E9AA88F21C8B70F0B9BCC7")

    int mIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.842 -0400", hash_original_field = "3908523F58561C99703A7559AB29724C", hash_generated_field = "7ECAB8F1DFD4D8C88111D51780B29562")

    String mWho;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.842 -0400", hash_original_field = "5867CE8CB088E58E6D17882F8EE91C5B", hash_generated_field = "BC54B63AEA85D845C1AC338D041E1ED5")

    Bundle mArguments;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.842 -0400", hash_original_field = "562619214306F5C11A815E975B7D2477", hash_generated_field = "14E7923C6D3468CDFB90940EBE370C56")

    Fragment mTarget;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "4FB974C217F7C6C42183BA9DEC8C9619", hash_generated_field = "B3D14A57A7194FB87F01321513F81187")

    int mTargetIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "9D7EC7B2039084EAAB4A7123EC5C6A65", hash_generated_field = "41D013C95CABF9ED0796F94F0CF16BD1")

    int mTargetRequestCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "78AB6CD708941FB2B40AE8854D535F2D", hash_generated_field = "CE47E8E592EB95BEB04FBBE625E99A8D")

    boolean mAdded;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "0F910DB84DA919CEA0C46A9368EB474F", hash_generated_field = "5C009156D3400624CB1FFDF310ECAFF1")

    boolean mRemoving;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "9933B84C738DC45A33F44AE2EFCBD30F", hash_generated_field = "23D2434AD22548E124B62AB7739838E9")

    boolean mResumed;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "D9B77340C245436344B0149264025068", hash_generated_field = "D21475690426FA39A7733914F0F3A95D")

    boolean mFromLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "02B7C51C439DA5E343271787FAA8C822", hash_generated_field = "C7463435817ABA85E5AF0081505BD656")

    boolean mInLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "F6C00A288B07FAA85B83595F41C31C30", hash_generated_field = "83846FEEE5AB5B668E6D933F96FB7819")

    boolean mRestored;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "48F5E8D87678F372810B137CFF79CDEE", hash_generated_field = "6F8CF3ED6C0707B98B23B55A256300E6")

    int mBackStackNesting;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "7D2A9E7103D695106505452E5AB8F67C", hash_generated_field = "58A45AD5F2F241F335F9B1ED7D27DC02")

    FragmentManagerImpl mFragmentManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "C145D87741EB407D6B1FF715AD484119", hash_generated_field = "3895D7E6DB5042DA7856DC78E391C7B9")

    Activity mActivity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "743B83D822DFF54AE7E24307CEF26F0C", hash_generated_field = "C628DB5A0351ABB6B2BC170D76A5FF43")

    int mFragmentId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "A2C9A3DA927DBE9AB0FC8FD8C7B637D9", hash_generated_field = "2072CAADE2B3735D2B37FDBC10B7F08E")

    int mContainerId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.843 -0400", hash_original_field = "07496860B5C53FDD66588727158D5F73", hash_generated_field = "05B32B05746742D3A5261C827E7D8852")

    String mTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "6E5D0646172E31357AC5264CFC6DCF7B", hash_generated_field = "DB81C7417E8D5BB2C252FB40F8D91CF8")

    boolean mHidden;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "23906763A9631E67BD7C67265695AFF7", hash_generated_field = "F0A7088DB55E87649B19609F5563F724")

    boolean mDetached;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "FC2473D51E767C5008A9D428BAFC8661", hash_generated_field = "907988FDE235BE080FDDB6DB36EF9C83")

    boolean mRetainInstance;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "DD825820C327E7F8D7347744CB13973E", hash_generated_field = "9B9EA230363F2EF227C5BE272DCC6838")

    boolean mRetaining;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "92B6BF5926849D268C59A8018D7DCB99", hash_generated_field = "98F2E6991F3565378DE3223CDDF9DBEB")

    boolean mHasMenu;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "6E83E1BA32D4FE911AA4EE969D8C81B5", hash_generated_field = "91D8D4C712F4EB13688BF2F27B945286")

    boolean mMenuVisible = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "8F73DC27B0DCA8E7133AEF9B7DBDC6C6", hash_generated_field = "6971FF9C6126C288092CCC2A5964E550")

    boolean mCalled;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "B87B5DA5CC417CB9E4D2331FCCCAB736", hash_generated_field = "778908554529C0B97FC9B63E5B9208AD")

    int mNextAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "C64165C1B15EB68FDC5E7135FFE5DF5B", hash_generated_field = "583453E78C87ED885A174C885F834BB6")

    ViewGroup mContainer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "7D6C73188D7990FE5A4B99F8F090B9EA", hash_generated_field = "6F4F028D1DE9C463F753A80DD0991753")

    View mView;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "E8D35768AE7CD7313BEF15C635AC96D9", hash_generated_field = "A8819B0E70BA304D51F44F47380E8807")

    boolean mDeferStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.844 -0400", hash_original_field = "2BDAE98A0CD238891DE96CFCEED42070", hash_generated_field = "149FC5E47A37645F1FE824C1875916A8")

    boolean mUserVisibleHint = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.845 -0400", hash_original_field = "780418B081227A51BFCB9EC0223B15ED", hash_generated_field = "6EE478DF5473556475C8D09C185A01BC")

    LoaderManagerImpl mLoaderManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.845 -0400", hash_original_field = "7B94EB60C9B740E67FF099B167511F7B", hash_generated_field = "D357ECA56BF47F1751443279339D50DF")

    boolean mLoadersStarted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.845 -0400", hash_original_field = "E2FDF9701AF8C008E54F63B95BC75C79", hash_generated_field = "93A369593E1CC22C7DE8D4D5C675B065")

    boolean mCheckedForLoaderManager;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.845 -0400", hash_original_method = "450DCF9C44ABD4359E904BF858920888", hash_generated_method = "AF7EF93C180462CAFE5DFDA53E9C7DDF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.847 -0400", hash_original_method = "7271436905E3847D6FDF6326194EF06D", hash_generated_method = "19CFFFB0A4498FD7457EEE7F55EF953A")
    final void restoreViewState() {
        {
            mView.restoreHierarchyState(mSavedViewState);
            mSavedViewState = null;
        } 
        
        
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.848 -0400", hash_original_method = "681200A239FE58A0DC09757C2C18A7DD", hash_generated_method = "B448BCBE36D32968D956E06826A289AB")
    final void setIndex(int index) {
        mIndex = index;
        mWho = "android:fragment:" + mIndex;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.850 -0400", hash_original_method = "B0D28796550366EF842F99A3D9D59C11", hash_generated_method = "B41EFE70BCBEC8CCC4B7BDE619CB292E")
    final boolean isInBackStack() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667143947 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_667143947;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.852 -0400", hash_original_method = "055C1CABEC6B90DB231CF8138F07B9C1", hash_generated_method = "D55CBC41666DD2B829DEE586004EA7EB")
    @Override
    final public boolean equals(Object o) {
        boolean var3B9F582BFED1483DB479DB197565FAB5_1183082683 = (super.equals(o));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2074112919 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2074112919;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.853 -0400", hash_original_method = "BBCDAD7BF06FB621822DBBAD11355700", hash_generated_method = "BEAD9F12CF991F139F2FEA322F90CB6E")
    @Override
    final public int hashCode() {
        int varC489EB7FF487A920847CC016ED55AE09_1530397190 = (super.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739601281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1739601281;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.854 -0400", hash_original_method = "5350708001683FB5244A4F612B80A27C", hash_generated_method = "93E25ABBAE11E64CE5569FDA1AA416C3")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1139974192 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_1139974192 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1139974192.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1139974192;
        
        
        
        
            
            
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.855 -0400", hash_original_method = "0D814DEC27C2F0AC661487D8C7B38979", hash_generated_method = "7F8E568D53955C5047DDB549E6F3A828")
    final public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111583165 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2111583165;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.856 -0400", hash_original_method = "ED26754F6A82B43F30EAE698B7941323", hash_generated_method = "36225DB576C3928F75742DDD4357031A")
    final public String getTag() {
        String varB4EAC82CA7396A68D541C85D26508E83_669193388 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_669193388 = mTag;
        varB4EAC82CA7396A68D541C85D26508E83_669193388.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_669193388;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.857 -0400", hash_original_method = "2D5CF4DC8DE7FCC73C8073BFA7412800", hash_generated_method = "1ED4BAF5C87366E8B439A343DBC39644")
    public void setArguments(Bundle args) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment already active");
        } 
        mArguments = args;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.859 -0400", hash_original_method = "AD916C2ECBF1A5C9327A86449330505D", hash_generated_method = "76BF87FFCBB90BBD31608D7C5BE3106F")
    final public Bundle getArguments() {
        Bundle varB4EAC82CA7396A68D541C85D26508E83_1073229934 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1073229934 = mArguments;
        varB4EAC82CA7396A68D541C85D26508E83_1073229934.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1073229934;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.862 -0400", hash_original_method = "D968C46759760C7406AC68A668D9806D", hash_generated_method = "F0337EA9BD20EA06BB854A3FCF019A9D")
    public void setInitialSavedState(SavedState state) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment already active");
        } 
        mSavedFragmentState = state != null && state.mState != null
                ? state.mState : null;
        
        
            
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.863 -0400", hash_original_method = "1E1EC1C5F204666846AC7A8EC55494F6", hash_generated_method = "A9E9A3E67F9FE2F0071A3B399678868D")
    public void setTargetFragment(Fragment fragment, int requestCode) {
        mTarget = fragment;
        mTargetRequestCode = requestCode;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.865 -0400", hash_original_method = "CBC4FCF13CA2895C8D01438D1D6F6EE8", hash_generated_method = "021219613E5D74914905996A5C57F7EE")
    final public Fragment getTargetFragment() {
        Fragment varB4EAC82CA7396A68D541C85D26508E83_1235845338 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1235845338 = mTarget;
        varB4EAC82CA7396A68D541C85D26508E83_1235845338.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1235845338;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.866 -0400", hash_original_method = "A4CEFC2C477EE57B614F4504E74127CE", hash_generated_method = "0AED0163B78A7FBED24C4AA158054839")
    final public int getTargetRequestCode() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398501670 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1398501670;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.867 -0400", hash_original_method = "3F17133E8D63AE8C7414DC58966291E3", hash_generated_method = "096C7E7EF2B827F89514755066745A06")
    final public Activity getActivity() {
        Activity varB4EAC82CA7396A68D541C85D26508E83_1996308993 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1996308993 = mActivity;
        varB4EAC82CA7396A68D541C85D26508E83_1996308993.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1996308993;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.869 -0400", hash_original_method = "A8E18DB36BC334E1CF5901C727187C18", hash_generated_method = "1B72DD20497967EFB32B1EC748685B2C")
    final public Resources getResources() {
        Resources varB4EAC82CA7396A68D541C85D26508E83_1031564864 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1031564864 = mActivity.getResources();
        varB4EAC82CA7396A68D541C85D26508E83_1031564864.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1031564864;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.871 -0400", hash_original_method = "3F649A13E84C6501035126B3FEE231F4", hash_generated_method = "BF73C9F6D0603B47E274EEB10A46D117")
    public final CharSequence getText(int resId) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_296439474 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_296439474 = getResources().getText(resId);
        addTaint(resId);
        varB4EAC82CA7396A68D541C85D26508E83_296439474.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_296439474;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.873 -0400", hash_original_method = "6096F9B7D678CAFA7D67C1784ABCB9A7", hash_generated_method = "6AF6F1FA88163A1FA4D1C20234DD075A")
    public final String getString(int resId) {
        String varB4EAC82CA7396A68D541C85D26508E83_1881537204 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1881537204 = getResources().getString(resId);
        addTaint(resId);
        varB4EAC82CA7396A68D541C85D26508E83_1881537204.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1881537204;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.875 -0400", hash_original_method = "524F00C5C13CBD3BD0D5C512A4C12294", hash_generated_method = "D57C1FD62780BDB6211BBE0A25085F64")
    public final String getString(int resId, Object... formatArgs) {
        String varB4EAC82CA7396A68D541C85D26508E83_588664528 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_588664528 = getResources().getString(resId, formatArgs);
        addTaint(resId);
        addTaint(formatArgs[0].getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_588664528.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_588664528;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.876 -0400", hash_original_method = "ED1BD18F392C2062694622C1FF4A3A44", hash_generated_method = "49346114F43D0F2E990982D72306D9D8")
    final public FragmentManager getFragmentManager() {
        FragmentManager varB4EAC82CA7396A68D541C85D26508E83_487259257 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_487259257 = mFragmentManager;
        varB4EAC82CA7396A68D541C85D26508E83_487259257.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_487259257;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.877 -0400", hash_original_method = "C0D74F5DDFD9A01C19E54F3379BA7652", hash_generated_method = "5F01E819D9C84AF7BE1DD8D8F24DCBE3")
    final public boolean isAdded() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_340970649 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_340970649;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.878 -0400", hash_original_method = "2F8509F8C4A8638224A8FC9748BC6275", hash_generated_method = "84D5AAE7AF7F68995046C4B391429813")
    final public boolean isDetached() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_475776211 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_475776211;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.878 -0400", hash_original_method = "914BD43FF0612F84BA345FA6F486595C", hash_generated_method = "9967D1AD1F62F44082DBB5A9E277B0E8")
    final public boolean isRemoving() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2146830313 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2146830313;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.879 -0400", hash_original_method = "3C6E7329283D3C6C46FB3F90EF65A4A7", hash_generated_method = "B7F62905203FF0D7897556FEDD6F3579")
    final public boolean isInLayout() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_395749323 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_395749323;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.880 -0400", hash_original_method = "58811A32FF0FF231CA3DA7AD72F98B09", hash_generated_method = "8538F16F6F37AF81985992344DB83D62")
    final public boolean isResumed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_455816359 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_455816359;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.882 -0400", hash_original_method = "72982976B71B01DF2412198462460DF0", hash_generated_method = "23A47EE303CA86A7EF44F1ADFAF0FBA2")
    final public boolean isVisible() {
        boolean var643645FADE5E75870E219C4E3A66DBAE_836924385 = (isAdded() && !isHidden() && mView != null
                && mView.getWindowToken() != null && mView.getVisibility() == View.VISIBLE);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1279084625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1279084625;
        
        
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.883 -0400", hash_original_method = "E04FD968639295CCE5F791161EDE4496", hash_generated_method = "377E8E1A1F7FD00AE8122F7133242714")
    final public boolean isHidden() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1907564882 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1907564882;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.883 -0400", hash_original_method = "FE8A5DF015D2662392185902D9D0AEDD", hash_generated_method = "764071413F7B945096A2936EA3340233")
    public void onHiddenChanged(boolean hidden) {
        
        addTaint(hidden);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.884 -0400", hash_original_method = "8E671A431463BFA7D0F399C37FBCF1E9", hash_generated_method = "B4781DA0C58D757D98DF8D51D0581302")
    public void setRetainInstance(boolean retain) {
        mRetainInstance = retain;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.885 -0400", hash_original_method = "82A17104D5864E2285E97283523AA6C5", hash_generated_method = "6A1D7DD6B76EF13E8697C9950A9B5F43")
    final public boolean getRetainInstance() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2129116154 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2129116154;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.886 -0400", hash_original_method = "A6D768E437C7421B050650CBF4A7B137", hash_generated_method = "27C3C97FE3C2D240A5130964F6E46B33")
    public void setHasOptionsMenu(boolean hasMenu) {
        {
            mHasMenu = hasMenu;
            {
                boolean var6410BF1E9EE91D719771624EE688382C_486036957 = (isAdded() && !isHidden());
                {
                    mFragmentManager.invalidateOptionsMenu();
                } 
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.886 -0400", hash_original_method = "2CD00B5529D6A4CD9554A0275473942E", hash_generated_method = "ABEA2545A79337456D67915BDC64D006")
    public void setMenuVisibility(boolean menuVisible) {
        {
            mMenuVisible = menuVisible;
            {
                boolean var63EEDD19FAB3C7E50D3EC385E85195BC_474286566 = (mHasMenu && isAdded() && !isHidden());
                {
                    mFragmentManager.invalidateOptionsMenu();
                } 
            } 
        } 
        
        
            
            
                
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.887 -0400", hash_original_method = "1B0128696FF26E02ABF181CBEC60E7DF", hash_generated_method = "6FDEB47DFBFCCF8C09B690FDC4838CA5")
    public void setUserVisibleHint(boolean isVisibleToUser) {
        {
            mFragmentManager.performPendingDeferredStart(this);
        } 
        mUserVisibleHint = isVisibleToUser;
        mDeferStart = !isVisibleToUser;
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.888 -0400", hash_original_method = "16570E728AF342CDACA5E18099682804", hash_generated_method = "25C8A3A44E5644F15CA5AAA99F938CAB")
    public boolean getUserVisibleHint() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2088180271 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2088180271;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.889 -0400", hash_original_method = "71C5851113530E9E497DE6FFC60D128C", hash_generated_method = "D0A95A7C36356A5DD19DB1B310828507")
    public LoaderManager getLoaderManager() {
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_346104976 = null; 
        LoaderManager varB4EAC82CA7396A68D541C85D26508E83_1995273594 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_346104976 = mLoaderManager;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } 
        mCheckedForLoaderManager = true;
        mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, true);
        varB4EAC82CA7396A68D541C85D26508E83_1995273594 = mLoaderManager;
        LoaderManager varA7E53CE21691AB073D9660D615818899_406431684; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_406431684 = varB4EAC82CA7396A68D541C85D26508E83_346104976;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_406431684 = varB4EAC82CA7396A68D541C85D26508E83_1995273594;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_406431684.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_406431684;
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.890 -0400", hash_original_method = "B68B30EDC5AB3BE8EF657FB7051C7F7E", hash_generated_method = "034AFFA898CD52B33567D6F4ACA58FB1")
    public void startActivity(Intent intent) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } 
        mActivity.startActivityFromFragment(this, intent, -1);
        addTaint(intent.getTaint());
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.891 -0400", hash_original_method = "849399EB62F8B6EE6A6E550D7989B87C", hash_generated_method = "FA0152001483243EABA7E04774885D8D")
    public void startActivityForResult(Intent intent, int requestCode) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        } 
        mActivity.startActivityFromFragment(this, intent, requestCode);
        addTaint(intent.getTaint());
        addTaint(requestCode);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.893 -0400", hash_original_method = "6D8F676326F7C192A2903AC6F4C36AC9", hash_generated_method = "13FACCD4A154E6B91F08CDAC9AEA6EFF")
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        
        addTaint(requestCode);
        addTaint(resultCode);
        addTaint(data.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.895 -0400", hash_original_method = "8FF008E86C71DF2CF57F1B9E3E9D8CD9", hash_generated_method = "FB9E16B90555C47B047BB40FB4B79B1A")
    public LayoutInflater getLayoutInflater(Bundle savedInstanceState) {
        LayoutInflater varB4EAC82CA7396A68D541C85D26508E83_222590474 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_222590474 = mActivity.getLayoutInflater();
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_222590474.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_222590474;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.896 -0400", hash_original_method = "B81B691062FF851E8B34D981FF83329F", hash_generated_method = "498694040B91B59F0575A214CD07081D")
    @Deprecated
    public void onInflate(AttributeSet attrs, Bundle savedInstanceState) {
        
        mCalled = true;
        addTaint(attrs.getTaint());
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.897 -0400", hash_original_method = "295D90877B0CE50D1EC7F89F1D4EC254", hash_generated_method = "7D7A598DE5898C3AA4F019C95ACD5F1A")
    public void onInflate(Activity activity, AttributeSet attrs, Bundle savedInstanceState) {
        
        onInflate(attrs, savedInstanceState);
        mCalled = true;
        addTaint(activity.getTaint());
        addTaint(attrs.getTaint());
        addTaint(savedInstanceState.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.898 -0400", hash_original_method = "7FCB8118913FF635CB1CDE717E61023E", hash_generated_method = "8D44122C10CCAD99B6B0F3E7B51550CD")
    public void onAttach(Activity activity) {
        
        mCalled = true;
        addTaint(activity.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.899 -0400", hash_original_method = "EB97CF4ACDD4FD35B8071D1AF529F576", hash_generated_method = "0C5F9C330E35FA77EE3D1291A5D7FC19")
    public Animator onCreateAnimator(int transit, boolean enter, int nextAnim) {
        
        Animator varB4EAC82CA7396A68D541C85D26508E83_938169553 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_938169553 = null;
        addTaint(transit);
        addTaint(enter);
        addTaint(nextAnim);
        varB4EAC82CA7396A68D541C85D26508E83_938169553.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_938169553;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.900 -0400", hash_original_method = "00494AECA41C1730DF6E82548FC2C3D5", hash_generated_method = "A703DECD1A13E142CAFC14CA278F8464")
    public void onCreate(Bundle savedInstanceState) {
        
        mCalled = true;
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.900 -0400", hash_original_method = "F4318A499F9B06ABC9CCF0644AE6DC10", hash_generated_method = "0AC185C4D1405DA07D13BEEEF3A63E65")
    public void onViewCreated(View view, Bundle savedInstanceState) {
        
        addTaint(view.getTaint());
        addTaint(savedInstanceState.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.902 -0400", hash_original_method = "57C338AB393ED440CE12C76B2627A085", hash_generated_method = "E992D839EB6616EC10DBD46122C015A8")
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        
        View varB4EAC82CA7396A68D541C85D26508E83_313333517 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_313333517 = null;
        addTaint(inflater.getTaint());
        addTaint(container.getTaint());
        addTaint(savedInstanceState.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_313333517.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_313333517;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.904 -0400", hash_original_method = "23562CAF30DEA91689886E5D0DFB3D0F", hash_generated_method = "FFC369CB90847F34CCBA8569637E42CF")
    public View getView() {
        View varB4EAC82CA7396A68D541C85D26508E83_1902927388 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1902927388 = mView;
        varB4EAC82CA7396A68D541C85D26508E83_1902927388.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1902927388;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.905 -0400", hash_original_method = "C52625884C98429BE8DE42F4FBFE7367", hash_generated_method = "7167642356FF710749355DABB699B2F5")
    public void onActivityCreated(Bundle savedInstanceState) {
        
        mCalled = true;
        addTaint(savedInstanceState.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.905 -0400", hash_original_method = "4BDF3B44AFE0C3B519B659689A5EE977", hash_generated_method = "82BBEA71FE07BC526918356C3508B55F")
    public void onStart() {
        
        mCalled = true;
        {
            mLoadersStarted = true;
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
            } 
            {
                mLoaderManager.doStart();
            } 
        } 
        
        
        
            
            
                
                
            
            
                
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.906 -0400", hash_original_method = "3B8608ED59C2663D271D57F8D8F534C0", hash_generated_method = "A35C9648644440B1AB73336CCB6DEAB5")
    public void onResume() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.907 -0400", hash_original_method = "9C4F98F3F5A4FCEFF66E261EDA5693F3", hash_generated_method = "AD15648AB8B6357D84B3060587BAA98F")
    public void onSaveInstanceState(Bundle outState) {
        
        addTaint(outState.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.907 -0400", hash_original_method = "16A05561D5415124B893EA7E2AFB953D", hash_generated_method = "F6F68BCCFBFEF8D06BF8C744D4370BE8")
    public void onConfigurationChanged(Configuration newConfig) {
        
        mCalled = true;
        addTaint(newConfig.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.908 -0400", hash_original_method = "CEF2FF1DA31E7EE9D761807A037B37B2", hash_generated_method = "637684B70754E8D79E076DC6A513E031")
    public void onPause() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.908 -0400", hash_original_method = "FC062A9ECA017F6E5D455E8C973942F9", hash_generated_method = "7E26AAA6FA11DEDE75C340853A5FC7A3")
    public void onStop() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.909 -0400", hash_original_method = "28328842E1AEC7ECF313405184622A29", hash_generated_method = "A607A7A5A4E7888F4F9DD46B7BE5C1AF")
    public void onLowMemory() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.909 -0400", hash_original_method = "E1E8CF8B1FBB3E8165C3219A9D0BB675", hash_generated_method = "790D26A8E39DDBBF6B7C713D90722C1C")
    public void onTrimMemory(int level) {
        
        mCalled = true;
        addTaint(level);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.910 -0400", hash_original_method = "E54F17C7BAFD082A48D2152349C1815A", hash_generated_method = "D6DBBF3121DDE73B3DDC3BCBF558AE8E")
    public void onDestroyView() {
        
        mCalled = true;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.911 -0400", hash_original_method = "AA4E137E24C2C382652C9FBA94B1ED31", hash_generated_method = "48CA08A8C2091A4D6902AC10492213F1")
    public void onDestroy() {
        
        mCalled = true;
        {
            mCheckedForLoaderManager = true;
            mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
        } 
        {
            mLoaderManager.doDestroy();
        } 
        
        
        
            
            
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.912 -0400", hash_original_method = "04633BF5293F80973E1AA355DB2C35EF", hash_generated_method = "4C027456133F87915A9EF12926708CE0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.913 -0400", hash_original_method = "EF609D2FD1394DFBC19807CB21AD7D10", hash_generated_method = "CD3AD86EF54BB27DA72F7E9F9B9DEA15")
    public void onDetach() {
        
        mCalled = true;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.914 -0400", hash_original_method = "B3C5F3D019B47C47E6111F1C7C38CA5D", hash_generated_method = "A2AC01879561E76B9598F6018B2688B1")
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        
        addTaint(menu.getTaint());
        addTaint(inflater.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.915 -0400", hash_original_method = "4CE703F4C1FA6FC474411DFE6A3F5275", hash_generated_method = "32B650DEFAD74BF60D957C3D22EC9F79")
    public void onPrepareOptionsMenu(Menu menu) {
        
        addTaint(menu.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.915 -0400", hash_original_method = "0E8C037F224061747BFFD0611606AAB6", hash_generated_method = "EF044D3D33EBB476DBBCFB32576782C1")
    public void onDestroyOptionsMenu() {
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.916 -0400", hash_original_method = "8EF9A1828892EFEBF4B93362A866125C", hash_generated_method = "2E1DEE0F4597E12AC22AA569CC6A7CF4")
    public boolean onOptionsItemSelected(MenuItem item) {
        
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1576087833 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1576087833;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.917 -0400", hash_original_method = "D53E4189B6E7F0EC0F9883E9844F2140", hash_generated_method = "CC9F879215C8D6911F3F43FE45124EF9")
    public void onOptionsMenuClosed(Menu menu) {
        
        addTaint(menu.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.917 -0400", hash_original_method = "68082EA0714CB57B78AC95D3FF2A7AC8", hash_generated_method = "B68B5B7B29E7468FD3122292CC31611A")
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
        
        getActivity().onCreateContextMenu(menu, v, menuInfo);
        addTaint(menu.getTaint());
        addTaint(v.getTaint());
        addTaint(menuInfo.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.918 -0400", hash_original_method = "1A123249F7C2C892EA53E2F44D60C1FB", hash_generated_method = "0FEECD9EF1102B65D35844FDFD151864")
    public void registerForContextMenu(View view) {
        
        view.setOnCreateContextMenuListener(this);
        addTaint(view.getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.918 -0400", hash_original_method = "6A7E2B106BB1CEE7C3B668A773DE5A5B", hash_generated_method = "344591114B98358744F7FCF1C426D7AD")
    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
        addTaint(view.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.919 -0400", hash_original_method = "801D77DFDCCE5570587CA592634E3D3B", hash_generated_method = "AE48928D6E62EA5D50424080824DA882")
    public boolean onContextItemSelected(MenuItem item) {
        
        addTaint(item.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509140669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_509140669;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.920 -0400", hash_original_method = "C78D4ECAA9BAFBCD9E78657D4224F582", hash_generated_method = "FC3C87E9EA969979524334F1ACE79A97")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
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
        } 
        {
            writer.print(prefix);
            writer.print("mActivity=");
            writer.println(mActivity);
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
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.921 -0400", hash_original_method = "A194798DFC3B633DD6139CF302E65474", hash_generated_method = "C7D46B9A2E02F09936071460030005C7")
     void performStart() {
        onStart();
        {
            mLoaderManager.doReportStart();
        } 
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.922 -0400", hash_original_method = "DF7E450C96FF033A1F96B7AC1D56EC13", hash_generated_method = "4F7CA6019DB5663F248E69C84C2C6777")
     void performStop() {
        onStop();
        {
            mLoadersStarted = false;
            {
                mCheckedForLoaderManager = true;
                mLoaderManager = mActivity.getLoaderManager(mIndex, mLoadersStarted, false);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.922 -0400", hash_original_method = "3EF3D6E87A549E78C03CB36A1B3A62F5", hash_generated_method = "8A65612313EFDA11D182CED36DAAE8D0")
     void performDestroyView() {
        onDestroyView();
        {
            mLoaderManager.doReportNextStart();
        } 
        
        
        
            
        
    }

    
    public static class SavedState implements Parcelable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.923 -0400", hash_original_field = "48A902C1D749B47EBC75C77370D5A1F0", hash_generated_field = "AA4A80FE6E8C28CFC04031C8CFFC3C9D")

        Bundle mState;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.923 -0400", hash_original_method = "7D4CB1BC3C04B99DC21EA19CB6BAF4D3", hash_generated_method = "BAE726BCB2EFD4A0280978447E5417B6")
          SavedState(Bundle state) {
            mState = state;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.924 -0400", hash_original_method = "E611F4C5C5E159704631D93ABD994DEF", hash_generated_method = "2C9CB5FE3CDE5ABA795E1EBDDA05A7F3")
          SavedState(Parcel in, ClassLoader loader) {
            mState = in.readBundle();
            {
                mState.setClassLoader(loader);
            } 
            addTaint(loader.getTaint());
            
            
            
                
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.926 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B144F8507C9EB1704E0F23E26AF17540")
        @Override
        public int describeContents() {
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1758488937 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1758488937;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.926 -0400", hash_original_method = "ACF88B4EF312D321A4777388A96F3566", hash_generated_method = "09F2B398AE4A3BD919542940FA9DB2FB")
        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeBundle(mState);
            addTaint(dest.getTaint());
            addTaint(flags);
            
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.927 -0400", hash_original_field = "8C0168FE172D1D9B33F36BA223FF422A", hash_generated_field = "2999E0A81FA5064B37A7DD9A52DB7607")

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
        
        public SavedState createFromParcel(Parcel in) {
                return new SavedState(in, null);
            }
        
        
        public SavedState createFromParcel(Parcel in, ClassLoader loader) {
                return new SavedState(in, loader);
            }
        
        
        public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        
    }


    
    static public class InstantiationException extends AndroidRuntimeException {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.927 -0400", hash_original_method = "9A59F9C8F177B5B07F720376B1CE8BCE", hash_generated_method = "AF08BB7903F079548F45BF553D77E4CE")
        public  InstantiationException(String msg, Exception cause) {
            super(msg, cause);
            addTaint(msg.getTaint());
            addTaint(cause.getTaint());
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.927 -0400", hash_original_field = "24A48BEA88D09CCBC63A8677385B95A8", hash_generated_field = "EB0A976F34844AD55F975EEF50A2B1A3")

    private static final HashMap<String, Class<?>> sClassMap = new HashMap<String, Class<?>>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.927 -0400", hash_original_field = "5F5168BFEDD28A94E86FDF26F95BEA11", hash_generated_field = "5C75B850D43361B9311F957A4D0AF174")

    static final int INVALID_STATE = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.928 -0400", hash_original_field = "403EB1653B87B88BD21AEF72194EF5E0", hash_generated_field = "B9FFABD80C3D80703D84376667A75609")

    static final int INITIALIZING = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.928 -0400", hash_original_field = "6EFDDF5DE9E2142D56B3E098F844AE40", hash_generated_field = "97B36236CFE06BD1C50B96E10CE241B6")

    static final int CREATED = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.928 -0400", hash_original_field = "18C3D4E620F8352BDF3CA097C14B87F7", hash_generated_field = "00E5F9933DCF6CD0A60E606E52C7FADE")

    static final int ACTIVITY_CREATED = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.928 -0400", hash_original_field = "456918D615E944292D78BC88E852291C", hash_generated_field = "2CEA28884A245A0CE49FCF31D0D6588D")

    static final int STOPPED = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.928 -0400", hash_original_field = "C604B9D3F56F632433E5FA0C79127BB7", hash_generated_field = "4F033F865040D83003D856BED757C437")

    static final int STARTED = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:17.928 -0400", hash_original_field = "FF953E97A61C82A8BD259E088591325D", hash_generated_field = "562F93666D34FFE3A5D8899053C80C4E")

    static final int RESUMED = 5;
}

