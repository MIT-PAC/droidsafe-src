package android.app;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

final class BackStackState implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:51.997 -0400", hash_original_field = "8B8CFB1C8824B4F8DAC46E032DB231EE", hash_generated_field = "FC56B3496DF6C62063CE25DEA3B38012")

    public static final Parcelable.Creator<BackStackState> CREATOR
            = new Parcelable.Creator<BackStackState>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.114 -0500", hash_original_method = "446F3F0B27039EA3D28E6A300050AF77", hash_generated_method = "5332A2FD526926A85C57F88A29667898")
        
public BackStackState createFromParcel(Parcel in) {
            return new BackStackState(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.117 -0500", hash_original_method = "52EF176F83EE27DC9AB1AED05CDF3579", hash_generated_method = "AA2C2B4C369E63D7557FFA20CBD80867")
        
public BackStackState[] newArray(int size) {
            return new BackStackState[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.080 -0500", hash_original_field = "DC6A1E8A42383143F0A42B30213419A5", hash_generated_field = "DC6A1E8A42383143F0A42B30213419A5")

     int[] mOps;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.082 -0500", hash_original_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

     int mTransition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.084 -0500", hash_original_field = "CD29A9E1689EE6A16C4B15593A3A7167", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

     int mTransitionStyle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.087 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

     String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.089 -0500", hash_original_field = "3FE793BBC68255EAC5B3588E7DE2E2C6", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

     int mIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.091 -0500", hash_original_field = "E7A56D2F2469DB150849BCC5ECFF6194", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

     int mBreadCrumbTitleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.093 -0500", hash_original_field = "CD8B3A4957F7DDF6AC7443892C1BE613", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

     CharSequence mBreadCrumbTitleText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.095 -0500", hash_original_field = "AD41F410B9AC4F4C962814DDC6C33643", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

     int mBreadCrumbShortTitleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.097 -0500", hash_original_field = "7BC40397D8844D56A620FA388A9E2606", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

     CharSequence mBreadCrumbShortTitleText;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.100 -0500", hash_original_method = "DCE5061D40CBE6F430759A7A23E4D4F8", hash_generated_method = "C43779D195E8929493D79C7D1CCB92C1")
    
public BackStackState(FragmentManagerImpl fm, BackStackRecord bse) {
        int numRemoved = 0;
        BackStackRecord.Op op = bse.mHead;
        while (op != null) {
            if (op.removed != null) numRemoved += op.removed.size();
            op = op.next;
        }
        mOps = new int[bse.mNumOp*7 + numRemoved];

        if (!bse.mAddToBackStack) {
            throw new IllegalStateException("Not on back stack");
        }

        op = bse.mHead;
        int pos = 0;
        while (op != null) {
            mOps[pos++] = op.cmd;
            mOps[pos++] = op.fragment.mIndex;
            mOps[pos++] = op.enterAnim;
            mOps[pos++] = op.exitAnim;
            mOps[pos++] = op.popEnterAnim;
            mOps[pos++] = op.popExitAnim;
            if (op.removed != null) {
                final int N = op.removed.size();
                mOps[pos++] = N;
                for (int i=0; i<N; i++) {
                    mOps[pos++] = op.removed.get(i).mIndex;
                }
            } else {
                mOps[pos++] = 0;
            }
            op = op.next;
        }
        mTransition = bse.mTransition;
        mTransitionStyle = bse.mTransitionStyle;
        mName = bse.mName;
        mIndex = bse.mIndex;
        mBreadCrumbTitleRes = bse.mBreadCrumbTitleRes;
        mBreadCrumbTitleText = bse.mBreadCrumbTitleText;
        mBreadCrumbShortTitleRes = bse.mBreadCrumbShortTitleRes;
        mBreadCrumbShortTitleText = bse.mBreadCrumbShortTitleText;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.104 -0500", hash_original_method = "B968D118C09EBADBAB257C64BF10EDFC", hash_generated_method = "6E4BC9BDE8ACD1B1BF9C0A28A08D1D9F")
    
public BackStackState(Parcel in) {
        mOps = in.createIntArray();
        mTransition = in.readInt();
        mTransitionStyle = in.readInt();
        mName = in.readString();
        mIndex = in.readInt();
        mBreadCrumbTitleRes = in.readInt();
        mBreadCrumbTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        mBreadCrumbShortTitleRes = in.readInt();
        mBreadCrumbShortTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.107 -0500", hash_original_method = "F8D54BF837A015C95DFB9CC70933C9DB", hash_generated_method = "59B665239AC1F5090BC4CD43E72ACF53")
    
public BackStackRecord instantiate(FragmentManagerImpl fm) {
        BackStackRecord bse = new BackStackRecord(fm);
        int pos = 0;
        while (pos < mOps.length) {
            BackStackRecord.Op op = new BackStackRecord.Op();
            op.cmd = mOps[pos++];
            if (FragmentManagerImpl.DEBUG) Log.v(FragmentManagerImpl.TAG,
                    "BSE " + bse + " set base fragment #" + mOps[pos]);
            Fragment f = fm.mActive.get(mOps[pos++]);
            op.fragment = f;
            op.enterAnim = mOps[pos++];
            op.exitAnim = mOps[pos++];
            op.popEnterAnim = mOps[pos++];
            op.popExitAnim = mOps[pos++];
            final int N = mOps[pos++];
            if (N > 0) {
                op.removed = new ArrayList<Fragment>(N);
                for (int i=0; i<N; i++) {
                    if (FragmentManagerImpl.DEBUG) Log.v(FragmentManagerImpl.TAG,
                            "BSE " + bse + " set remove fragment #" + mOps[pos]);
                    Fragment r = fm.mActive.get(mOps[pos++]);
                    op.removed.add(r);
                }
            }
            bse.addOp(op);
        }
        bse.mTransition = mTransition;
        bse.mTransitionStyle = mTransitionStyle;
        bse.mName = mName;
        bse.mIndex = mIndex;
        bse.mAddToBackStack = true;
        bse.mBreadCrumbTitleRes = mBreadCrumbTitleRes;
        bse.mBreadCrumbTitleText = mBreadCrumbTitleText;
        bse.mBreadCrumbShortTitleRes = mBreadCrumbShortTitleRes;
        bse.mBreadCrumbShortTitleText = mBreadCrumbShortTitleText;
        bse.bumpBackStackNesting(1);
        return bse;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.109 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.111 -0500", hash_original_method = "541B83E53D4985674BDE186AC23E769C", hash_generated_method = "82A9F86696450899D7638E9FF59F623F")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(mOps);
        dest.writeInt(mTransition);
        dest.writeInt(mTransitionStyle);
        dest.writeString(mName);
        dest.writeInt(mIndex);
        dest.writeInt(mBreadCrumbTitleRes);
        TextUtils.writeToParcel(mBreadCrumbTitleText, dest, 0);
        dest.writeInt(mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(mBreadCrumbShortTitleText, dest, 0);
    }
    // orphaned legacy method
    public BackStackState createFromParcel(Parcel in) {
            return new BackStackState(in);
        }
    
    // orphaned legacy method
    public BackStackState[] newArray(int size) {
            return new BackStackState[size];
        }
    
}

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.122 -0500", hash_original_field = "DF08C805ED7A58AED0882C638CBF2EC9", hash_generated_field = "583E47895BFA5D844AD0AE16F53E746D")

    static final String TAG = "BackStackEntry";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.126 -0500", hash_original_field = "5906708AA0EC9FEEEECEE01C65ADF637", hash_generated_field = "3C725A5D9DEF53B7FBA369B6031C0114")

    static final int OP_NULL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.128 -0500", hash_original_field = "1A368FE2DF1C3A737687BEA9477073B0", hash_generated_field = "D476F834444990BAEEB054A4C302249A")

    static final int OP_ADD = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.131 -0500", hash_original_field = "B89DCE888D2688ED1FEBF3CDF0374BDC", hash_generated_field = "3C4AC3DDA904059CE1649C7DA113A694")

    static final int OP_REPLACE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.133 -0500", hash_original_field = "004D4089D3870ABCE05E8B11469557A6", hash_generated_field = "5D1FE84F46A8710BCAAB63F7836D62F7")

    static final int OP_REMOVE = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.135 -0500", hash_original_field = "B1838C5099479C7FDA04D1218DB4DC93", hash_generated_field = "C6957BDFCD9D33DF33819EDBB2E9C30D")

    static final int OP_HIDE = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.138 -0500", hash_original_field = "A2E6DF82F95DAE7AE07F45CCC0D8EB42", hash_generated_field = "AC2408B061BD12E29767B40B4F69C217")

    static final int OP_SHOW = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.140 -0500", hash_original_field = "B7A6058FBFDA6FA2490181E888001419", hash_generated_field = "FECBA6AE06903F8549AFADF78F9ACEE7")

    static final int OP_DETACH = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.142 -0500", hash_original_field = "13288DB05F6175C5F03BCC0879167F26", hash_generated_field = "BEA53C6640501A26A1D92C01B94C35E1")

    static final int OP_ATTACH = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.124 -0500", hash_original_field = "B6E40031C2D8257644CECE00AFE40458", hash_generated_field = "B6E40031C2D8257644CECE00AFE40458")

     FragmentManagerImpl mManager;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.165 -0500", hash_original_field = "CAA200DE64F101586FA95F4FEC8429B1", hash_generated_field = "CAA200DE64F101586FA95F4FEC8429B1")

    Op mHead;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.167 -0500", hash_original_field = "1DBFB57BC3C0C58F1CA989515A3C11B2", hash_generated_field = "1DBFB57BC3C0C58F1CA989515A3C11B2")

    Op mTail;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.169 -0500", hash_original_field = "7C2498E5F23A289A087BC718DE147927", hash_generated_field = "7C2498E5F23A289A087BC718DE147927")

    int mNumOp;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.171 -0500", hash_original_field = "25DA9A900AA8941601D4713D8643BCFF", hash_generated_field = "25DA9A900AA8941601D4713D8643BCFF")

    int mEnterAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.172 -0500", hash_original_field = "0403C21FF2E329089D303DA2F881AD65", hash_generated_field = "0403C21FF2E329089D303DA2F881AD65")

    int mExitAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.175 -0500", hash_original_field = "426B5FECE57930E7AC2A692D910E1B95", hash_generated_field = "426B5FECE57930E7AC2A692D910E1B95")

    int mPopEnterAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.178 -0500", hash_original_field = "336F0E1CA15D2B7CFA7AB64448E9ABB4", hash_generated_field = "336F0E1CA15D2B7CFA7AB64448E9ABB4")

    int mPopExitAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.179 -0500", hash_original_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.181 -0500", hash_original_field = "CD29A9E1689EE6A16C4B15593A3A7167", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.183 -0500", hash_original_field = "6D620657E4B0D7E3BF4B4C9A3EA1860D", hash_generated_field = "6D620657E4B0D7E3BF4B4C9A3EA1860D")

    boolean mAddToBackStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.185 -0500", hash_original_field = "00D17B9289ED52FD64E1F76DBFE93EE5", hash_generated_field = "00D17B9289ED52FD64E1F76DBFE93EE5")

    boolean mAllowAddToBackStack = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.187 -0500", hash_original_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.189 -0500", hash_original_field = "34350BC5CB525FC021F5A246971120D8", hash_generated_field = "34350BC5CB525FC021F5A246971120D8")

    boolean mCommitted;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.191 -0500", hash_original_field = "3FE793BBC68255EAC5B3588E7DE2E2C6", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.193 -0500", hash_original_field = "E7A56D2F2469DB150849BCC5ECFF6194", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.195 -0500", hash_original_field = "CD8B3A4957F7DDF6AC7443892C1BE613", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.197 -0500", hash_original_field = "AD41F410B9AC4F4C962814DDC6C33643", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.199 -0500", hash_original_field = "7BC40397D8844D56A620FA388A9E2606", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.206 -0500", hash_original_method = "8E110563CDFB79724FBA0799BF0D3C19", hash_generated_method = "B7A2608C62909F74DCC9E5243DA4C2B2")
    
public BackStackRecord(FragmentManagerImpl manager) {
        mManager = manager;
    }

    @DSSink({DSSinkKind.FILE})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.203 -0500", hash_original_method = "D2AEC534E855FE50C82F3A186CF8CD83", hash_generated_method = "B0CD556182DAF729BD1E10F2B597B1A1")
    
public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        writer.print(prefix); writer.print("mName="); writer.print(mName);
                writer.print(" mIndex="); writer.print(mIndex);
                writer.print(" mCommitted="); writer.println(mCommitted);
        if (mTransition != FragmentTransaction.TRANSIT_NONE) {
            writer.print(prefix); writer.print("mTransition=#");
                    writer.print(Integer.toHexString(mTransition));
                    writer.print(" mTransitionStyle=#");
                    writer.println(Integer.toHexString(mTransitionStyle));
        }
        if (mEnterAnim != 0 || mExitAnim !=0) {
            writer.print(prefix); writer.print("mEnterAnim=#");
                    writer.print(Integer.toHexString(mEnterAnim));
                    writer.print(" mExitAnim=#");
                    writer.println(Integer.toHexString(mExitAnim));
        }
        if (mPopEnterAnim != 0 || mPopExitAnim !=0) {
            writer.print(prefix); writer.print("mPopEnterAnim=#");
                    writer.print(Integer.toHexString(mPopEnterAnim));
                    writer.print(" mPopExitAnim=#");
                    writer.println(Integer.toHexString(mPopExitAnim));
        }
        if (mBreadCrumbTitleRes != 0 || mBreadCrumbTitleText != null) {
            writer.print(prefix); writer.print("mBreadCrumbTitleRes=#");
                    writer.print(Integer.toHexString(mBreadCrumbTitleRes));
                    writer.print(" mBreadCrumbTitleText=");
                    writer.println(mBreadCrumbTitleText);
        }
        if (mBreadCrumbShortTitleRes != 0 || mBreadCrumbShortTitleText != null) {
            writer.print(prefix); writer.print("mBreadCrumbShortTitleRes=#");
                    writer.print(Integer.toHexString(mBreadCrumbShortTitleRes));
                    writer.print(" mBreadCrumbShortTitleText=");
                    writer.println(mBreadCrumbShortTitleText);
        }

        if (mHead != null) {
            writer.print(prefix); writer.println("Operations:");
            String innerPrefix = prefix + "    ";
            Op op = mHead;
            int num = 0;
            while (op != null) {
                writer.print(prefix); writer.print("  Op #"); writer.print(num);
                        writer.println(":");
                writer.print(innerPrefix); writer.print("cmd="); writer.print(op.cmd);
                        writer.print(" fragment="); writer.println(op.fragment);
                if (op.enterAnim != 0 || op.exitAnim != 0) {
                    writer.print(prefix); writer.print("enterAnim=#");
                            writer.print(Integer.toHexString(op.enterAnim));
                            writer.print(" exitAnim=#");
                            writer.println(Integer.toHexString(op.exitAnim));
                }
                if (op.popEnterAnim != 0 || op.popExitAnim != 0) {
                    writer.print(prefix); writer.print("popEnterAnim=#");
                            writer.print(Integer.toHexString(op.popEnterAnim));
                            writer.print(" popExitAnim=#");
                            writer.println(Integer.toHexString(op.popExitAnim));
                }
                if (op.removed != null && op.removed.size() > 0) {
                    for (int i=0; i<op.removed.size(); i++) {
                        writer.print(innerPrefix);
                        if (op.removed.size() == 1) {
                            writer.print("Removed: ");
                        } else {
                            writer.println("Removed:");
                            writer.print(innerPrefix); writer.print("  #"); writer.print(num);
                                    writer.print(": "); 
                        }
                        writer.println(op.removed.get(i));
                    }
                }
                op = op.next;
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.208 -0500", hash_original_method = "15A4A4C5F4518D2E82F335984591D8BA", hash_generated_method = "61F8A923566CB1FFCD11590B8B252AA8")
    
public int getId() {
        return mIndex;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.210 -0500", hash_original_method = "9339385C292A3B9874BA3EB436AA9056", hash_generated_method = "BB6598E4F43C0F22F9AE287ABAE34691")
    
public int getBreadCrumbTitleRes() {
        return mBreadCrumbTitleRes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.212 -0500", hash_original_method = "D139A03B61A4B83382000704FB0C1F23", hash_generated_method = "6D9F3ADFE832DBFDC8CBBC857D31495B")
    
public int getBreadCrumbShortTitleRes() {
        return mBreadCrumbShortTitleRes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.214 -0500", hash_original_method = "C2C5B49D77ECFC3F06C4280D5C67187D", hash_generated_method = "03FD63B4EAB83E5FF15A37B5A9879AC4")
    
public CharSequence getBreadCrumbTitle() {
        if (mBreadCrumbTitleRes != 0) {
            return mManager.mActivity.getText(mBreadCrumbTitleRes);
        }
        return mBreadCrumbTitleText;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.216 -0500", hash_original_method = "CEC326312BE69049B0B2FA6420FE6494", hash_generated_method = "F40864F083533C9DA50190CE5A3F6DBD")
    
public CharSequence getBreadCrumbShortTitle() {
        if (mBreadCrumbShortTitleRes != 0) {
            return mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        }
        return mBreadCrumbShortTitleText;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.218 -0500", hash_original_method = "32D26C73BB31A0FE5D5A21F02980CDDD", hash_generated_method = "32D26C73BB31A0FE5D5A21F02980CDDD")
    
void addOp(Op op) {
        if (mHead == null) {
            mHead = mTail = op;
        } else {
            op.prev = mTail;
            mTail.next = op;
            mTail = op;
        }
        op.enterAnim = mEnterAnim;
        op.exitAnim = mExitAnim;
        op.popEnterAnim = mPopEnterAnim;
        op.popExitAnim = mPopExitAnim;
        mNumOp++;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.221 -0500", hash_original_method = "C1E47B5485B0B08AA827320F8BD79938", hash_generated_method = "8BF4FE0935DB7825EB77D79654A1FFE2")
    
public FragmentTransaction add(Fragment fragment, String tag) {
        doAddOp(0, fragment, tag, OP_ADD);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.223 -0500", hash_original_method = "F34A7243D750E416C8B46711401682C6", hash_generated_method = "A6C07E2B35495267F439576F66D13356")
    
public FragmentTransaction add(int containerViewId, Fragment fragment) {
        doAddOp(containerViewId, fragment, null, OP_ADD);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.225 -0500", hash_original_method = "DCEB5E0B408763C7F0E9A3376CBD91C3", hash_generated_method = "C794033F13F952369C7EF9B224F946AA")
    
public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        doAddOp(containerViewId, fragment, tag, OP_ADD);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.228 -0500", hash_original_method = "F2F897C7BFD0AE6B1B051FF1D3DE8AB7", hash_generated_method = "C95777A5F19475DA08C0B2117C0BAD16")
    
private void doAddOp(int containerViewId, Fragment fragment, String tag, int opcmd) {
        fragment.mFragmentManager = mManager;

        if (tag != null) {
            if (fragment.mTag != null && !tag.equals(fragment.mTag)) {
                throw new IllegalStateException("Can't change tag of fragment "
                        + fragment + ": was " + fragment.mTag
                        + " now " + tag);
            }
            fragment.mTag = tag;
        }

        if (containerViewId != 0) {
            if (fragment.mFragmentId != 0 && fragment.mFragmentId != containerViewId) {
                throw new IllegalStateException("Can't change container ID of fragment "
                        + fragment + ": was " + fragment.mFragmentId
                        + " now " + containerViewId);
            }
            fragment.mContainerId = fragment.mFragmentId = containerViewId;
        }

        Op op = new Op();
        op.cmd = opcmd;
        op.fragment = fragment;
        addOp(op);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.230 -0500", hash_original_method = "095D291C1CAFD923EC9CB9BF06EF4676", hash_generated_method = "637C51932EBB2EB1BF87B9364F24B476")
    
public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        return replace(containerViewId, fragment, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.232 -0500", hash_original_method = "1C07811E78071E2352BF0C170F6491CA", hash_generated_method = "E1E41EE8A4310B857B42C761ED1BE19C")
    
public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        if (containerViewId == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }

        doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.235 -0500", hash_original_method = "33682B1B727BD924F48FE7F483A5C004", hash_generated_method = "432290EF18CD72AFB8E02597304B0D1F")
    
public FragmentTransaction remove(Fragment fragment) {
        Op op = new Op();
        op.cmd = OP_REMOVE;
        op.fragment = fragment;
        addOp(op);

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.237 -0500", hash_original_method = "AB9058E54F9496DA8E33E643603CB0C7", hash_generated_method = "E620DDD5534C8134578AA99624051B05")
    
public FragmentTransaction hide(Fragment fragment) {
        Op op = new Op();
        op.cmd = OP_HIDE;
        op.fragment = fragment;
        addOp(op);

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.239 -0500", hash_original_method = "2B6B1F1BD336D20AECF3763EE9DD5949", hash_generated_method = "2C6F95C97DC14234BFFC900EC76DB232")
    
public FragmentTransaction show(Fragment fragment) {
        Op op = new Op();
        op.cmd = OP_SHOW;
        op.fragment = fragment;
        addOp(op);

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.241 -0500", hash_original_method = "60B4979E5A31C92DF6F58D0AB0599A51", hash_generated_method = "30F1941E10E79A9786D486824E899005")
    
public FragmentTransaction detach(Fragment fragment) {
        Op op = new Op();
        op.cmd = OP_DETACH;
        op.fragment = fragment;
        addOp(op);

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.243 -0500", hash_original_method = "71B1C0469F9D1680729415A070BB9988", hash_generated_method = "35F5AC6EDAB37194CB73964757E05777")
    
public FragmentTransaction attach(Fragment fragment) {
        Op op = new Op();
        op.cmd = OP_ATTACH;
        op.fragment = fragment;
        addOp(op);

        return this;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.245 -0500", hash_original_method = "E8FBC41447C7F5B20E8F08F3A2F7FD58", hash_generated_method = "1AB90CDE86714F166EBB833F0518E7AA")
    
public FragmentTransaction setCustomAnimations(int enter, int exit) {
        return setCustomAnimations(enter, exit, 0, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.247 -0500", hash_original_method = "A0614C8D91A2CFFC3B2827B585934661", hash_generated_method = "C7A01A96D5FB74D813B64608F53C8D33")
    
public FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit) {
        mEnterAnim = enter;
        mExitAnim = exit;
        mPopEnterAnim = popEnter;
        mPopExitAnim = popExit;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.250 -0500", hash_original_method = "A455FB052D79EC1710E986C50AD0D972", hash_generated_method = "5F0C4A5DA2DCD4CA7B5C4850AA45A368")
    
public FragmentTransaction setTransition(int transition) {
        mTransition = transition;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.253 -0500", hash_original_method = "A33CAFCA32BB4FD1A454655E75F4B6CB", hash_generated_method = "8153D0CE8E7C40ECC4752D18D9839DAC")
    
public FragmentTransaction setTransitionStyle(int styleRes) {
        mTransitionStyle = styleRes;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.255 -0500", hash_original_method = "438624ACF19A9F6511A0E99CD6264659", hash_generated_method = "AAEBD5F753C97969CA3C8B321779D7C0")
    
public FragmentTransaction addToBackStack(String name) {
        if (!mAllowAddToBackStack) {
            throw new IllegalStateException(
                    "This FragmentTransaction is not allowed to be added to the back stack.");
        }
        mAddToBackStack = true;
        mName = name;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.257 -0500", hash_original_method = "6063A0768FB0FF8A9BC1A0D5BDF7E352", hash_generated_method = "8EB64695330B61794F4EF5DED31F7708")
    
public boolean isAddToBackStackAllowed() {
        return mAllowAddToBackStack;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.259 -0500", hash_original_method = "FA98892FC811CB8446B86919ACA0FBBA", hash_generated_method = "FD704B45B6CBA9872E1BDB9E98AFFBB6")
    
public FragmentTransaction disallowAddToBackStack() {
        if (mAddToBackStack) {
            throw new IllegalStateException(
                    "This transaction is already being added to the back stack");
        }
        mAllowAddToBackStack = false;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.261 -0500", hash_original_method = "3ED721B4C54764795D085FCDFAF2CFED", hash_generated_method = "6750047795CDFEBB7A1EBF78707ED377")
    
public FragmentTransaction setBreadCrumbTitle(int res) {
        mBreadCrumbTitleRes = res;
        mBreadCrumbTitleText = null;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.263 -0500", hash_original_method = "27CB0DA08C946E1C367250B9E9010CF2", hash_generated_method = "77FD727D290B8ADA1F14AB39742845EE")
    
public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        mBreadCrumbTitleRes = 0;
        mBreadCrumbTitleText = text;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.265 -0500", hash_original_method = "F0E82E7069B2F6B7E25A71F53DDE4690", hash_generated_method = "F4EC53C5972F15C9949F894A4ED88262")
    
public FragmentTransaction setBreadCrumbShortTitle(int res) {
        mBreadCrumbShortTitleRes = res;
        mBreadCrumbShortTitleText = null;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.268 -0500", hash_original_method = "0432E2D3026F58B259B18084E0B71CFD", hash_generated_method = "B81B0499940BC104945C047F068F0D04")
    
public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        mBreadCrumbShortTitleRes = 0;
        mBreadCrumbShortTitleText = text;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.270 -0500", hash_original_method = "350B86C0CFAA72F059C15CB3FE1D993C", hash_generated_method = "350B86C0CFAA72F059C15CB3FE1D993C")
    
void bumpBackStackNesting(int amt) {
        if (!mAddToBackStack) {
            return;
        }
        if (FragmentManagerImpl.DEBUG) Log.v(TAG, "Bump nesting in " + this
                + " by " + amt);
        Op op = mHead;
        while (op != null) {
            op.fragment.mBackStackNesting += amt;
            if (FragmentManagerImpl.DEBUG) Log.v(TAG, "Bump nesting of "
                    + op.fragment + " to " + op.fragment.mBackStackNesting);
            if (op.removed != null) {
                for (int i=op.removed.size()-1; i>=0; i--) {
                    Fragment r = op.removed.get(i);
                    r.mBackStackNesting += amt;
                    if (FragmentManagerImpl.DEBUG) Log.v(TAG, "Bump nesting of "
                            + r + " to " + r.mBackStackNesting);
                }
            }
            op = op.next;
        }
    }
    
    static final class Op {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.145 -0500", hash_original_field = "19BBD1601EBAF334D6AA33231EED0715", hash_generated_field = "19BBD1601EBAF334D6AA33231EED0715")

        Op next;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.147 -0500", hash_original_field = "BE2B15E3DCB4E20F57C5AF9432510015", hash_generated_field = "BE2B15E3DCB4E20F57C5AF9432510015")

        Op prev;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.150 -0500", hash_original_field = "CBDB20FE7C0EE51482970075935C6638", hash_generated_field = "CBDB20FE7C0EE51482970075935C6638")

        int cmd;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.152 -0500", hash_original_field = "CC9B687FC89CACD9827C1873C7A34AB5", hash_generated_field = "CC9B687FC89CACD9827C1873C7A34AB5")

        Fragment fragment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.154 -0500", hash_original_field = "63F1115D3C1779EA5F8AD4A1D1B38EB9", hash_generated_field = "63F1115D3C1779EA5F8AD4A1D1B38EB9")

        int enterAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.156 -0500", hash_original_field = "7809ED21B1AF75421C6C97CB78F83727", hash_generated_field = "7809ED21B1AF75421C6C97CB78F83727")

        int exitAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.158 -0500", hash_original_field = "D0892F22C301BA7A61E6684B7CEDEB8C", hash_generated_field = "D0892F22C301BA7A61E6684B7CEDEB8C")

        int popEnterAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.160 -0500", hash_original_field = "E32555C71C839BAA1F67752555EB6938", hash_generated_field = "E32555C71C839BAA1F67752555EB6938")

        int popExitAnim;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.162 -0500", hash_original_field = "2CECA5CBA87C574F11C3FFA8F991583A", hash_generated_field = "2CECA5CBA87C574F11C3FFA8F991583A")

        ArrayList<Fragment> removed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:52.102 -0400", hash_original_method = "D7B482A7C55CFA7077AB6D8147480F87", hash_generated_method = "D7B482A7C55CFA7077AB6D8147480F87")
        public Op ()
        {
            //Synthesized constructor
        }

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.272 -0500", hash_original_method = "FD69B9F14C4FF1755ADA5F3EFF5DDDFB", hash_generated_method = "AE3CCF7269135DEB1B7CB727659CAE46")
    
public int commit() {
        return commitInternal(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.274 -0500", hash_original_method = "034B152615D8FC6D1FD7AD2899313AE6", hash_generated_method = "17EE5D1F85B308AF1AACAFB955676640")
    
public int commitAllowingStateLoss() {
        return commitInternal(true);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.276 -0500", hash_original_method = "9BF727F0CCA97F90C9847FCD006039C1", hash_generated_method = "9BF727F0CCA97F90C9847FCD006039C1")
    
int commitInternal(boolean allowStateLoss) {
        if (mCommitted) throw new IllegalStateException("commit already called");
        if (FragmentManagerImpl.DEBUG) Log.v(TAG, "Commit: " + this);
        mCommitted = true;
        if (mAddToBackStack) {
            mIndex = mManager.allocBackStackIndex(this);
        } else {
            mIndex = -1;
        }
        mManager.enqueueAction(this, allowStateLoss);
        return mIndex;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.280 -0500", hash_original_method = "BA0CE442AF616D2BBAA3AAFEB295CD0F", hash_generated_method = "51C81669292610193B44AF48058D938E")
    
public void run() {
        if (FragmentManagerImpl.DEBUG) Log.v(TAG, "Run: " + this);

        if (mAddToBackStack) {
            if (mIndex < 0) {
                throw new IllegalStateException("addToBackStack() called after commit()");
            }
        }

        bumpBackStackNesting(1);

        Op op = mHead;
        while (op != null) {
            switch (op.cmd) {
                case OP_ADD: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.enterAnim;
                    mManager.addFragment(f, false);
                } break;
                case OP_REPLACE: {
                    Fragment f = op.fragment;
                    if (mManager.mAdded != null) {
                        for (int i=0; i<mManager.mAdded.size(); i++) {
                            Fragment old = mManager.mAdded.get(i);
                            if (FragmentManagerImpl.DEBUG) Log.v(TAG,
                                    "OP_REPLACE: adding=" + f + " old=" + old);
                            if (old.mContainerId == f.mContainerId) {
                                if (op.removed == null) {
                                    op.removed = new ArrayList<Fragment>();
                                }
                                op.removed.add(old);
                                old.mNextAnim = op.exitAnim;
                                if (mAddToBackStack) {
                                    old.mBackStackNesting += 1;
                                    if (FragmentManagerImpl.DEBUG) Log.v(TAG, "Bump nesting of "
                                            + old + " to " + old.mBackStackNesting);
                                }
                                mManager.removeFragment(old, mTransition, mTransitionStyle);
                            }
                        }
                    }
                    f.mNextAnim = op.enterAnim;
                    mManager.addFragment(f, false);
                } break;
                case OP_REMOVE: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.exitAnim;
                    mManager.removeFragment(f, mTransition, mTransitionStyle);
                } break;
                case OP_HIDE: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.exitAnim;
                    mManager.hideFragment(f, mTransition, mTransitionStyle);
                } break;
                case OP_SHOW: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.enterAnim;
                    mManager.showFragment(f, mTransition, mTransitionStyle);
                } break;
                case OP_DETACH: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.exitAnim;
                    mManager.detachFragment(f, mTransition, mTransitionStyle);
                } break;
                case OP_ATTACH: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.enterAnim;
                    mManager.attachFragment(f, mTransition, mTransitionStyle);
                } break;
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                }
            }

            op = op.next;
        }

        mManager.moveToState(mManager.mCurState, mTransition,
                mTransitionStyle, true);

        if (mAddToBackStack) {
            mManager.addBackStackState(this);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.284 -0500", hash_original_method = "7F72D15008964B0C744517E586063B58", hash_generated_method = "7D96847CBCC2949FB6D49DC1751A7CB9")
    
public void popFromBackStack(boolean doStateMove) {
        if (FragmentManagerImpl.DEBUG) Log.v(TAG, "popFromBackStack: " + this);

        bumpBackStackNesting(-1);

        Op op = mTail;
        while (op != null) {
            switch (op.cmd) {
                case OP_ADD: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.popExitAnim;
                    mManager.removeFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition),
                            mTransitionStyle);
                } break;
                case OP_REPLACE: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.popExitAnim;
                    mManager.removeFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition),
                            mTransitionStyle);
                    if (op.removed != null) {
                        for (int i=0; i<op.removed.size(); i++) {
                            Fragment old = op.removed.get(i);
                            old.mNextAnim = op.popEnterAnim;
                            mManager.addFragment(old, false);
                        }
                    }
                } break;
                case OP_REMOVE: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.popEnterAnim;
                    mManager.addFragment(f, false);
                } break;
                case OP_HIDE: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.popEnterAnim;
                    mManager.showFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                } break;
                case OP_SHOW: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.popExitAnim;
                    mManager.hideFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                } break;
                case OP_DETACH: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.popEnterAnim;
                    mManager.attachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                } break;
                case OP_ATTACH: {
                    Fragment f = op.fragment;
                    f.mNextAnim = op.popExitAnim;
                    mManager.detachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
                } break;
                default: {
                    throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
                }
            }

            op = op.prev;
        }

        if (doStateMove) {
            mManager.moveToState(mManager.mCurState,
                    FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle, true);
        }

        if (mIndex >= 0) {
            mManager.freeBackStackIndex(mIndex);
            mIndex = -1;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.286 -0500", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "AD920925278DEAFAFBD283F9C2E39E5D")
    
public String getName() {
        return mName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.288 -0500", hash_original_method = "78EE7FB9A966094E1E15EEF50B50E3C9", hash_generated_method = "81712C69BBE6ED21857D0FD8B6B1B700")
    
public int getTransition() {
        return mTransition;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.290 -0500", hash_original_method = "0B18827E69C997D5383C8EBB7663D372", hash_generated_method = "D3E37E6A3F5AB5DC1075D0735845027E")
    
public int getTransitionStyle() {
        return mTransitionStyle;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:35:16.292 -0500", hash_original_method = "98C448D4C76D2FE85810E0C03648865C", hash_generated_method = "4C3597D03BC4A9BBC6133022DEEAE7F4")
    
public boolean isEmpty() {
        return mNumOp == 0;
    }
}

