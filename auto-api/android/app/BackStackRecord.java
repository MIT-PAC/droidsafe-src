package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    int[] mOps;
    int mTransition;
    int mTransitionStyle;
    String mName;
    int mIndex;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.926 -0400", hash_original_method = "DCE5061D40CBE6F430759A7A23E4D4F8", hash_generated_method = "AEDB8867AC16B17AABC7567AF50491CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BackStackState(FragmentManagerImpl fm, BackStackRecord bse) {
        dsTaint.addTaint(fm.dsTaint);
        dsTaint.addTaint(bse.dsTaint);
        int numRemoved;
        numRemoved = 0;
        BackStackRecord.Op op;
        op = bse.mHead;
        {
            numRemoved += op.removed.size();
            op = op.next;
        } //End block
        mOps = new int[bse.mNumOp*7 + numRemoved];
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Not on back stack");
        } //End block
        op = bse.mHead;
        int pos;
        pos = 0;
        {
            mOps[pos++] = op.cmd;
            mOps[pos++] = op.fragment.mIndex;
            mOps[pos++] = op.enterAnim;
            mOps[pos++] = op.exitAnim;
            mOps[pos++] = op.popEnterAnim;
            mOps[pos++] = op.popExitAnim;
            {
                int N;
                N = op.removed.size();
                mOps[pos++] = N;
                {
                    int i;
                    i = 0;
                    {
                        mOps[pos++] = op.removed.get(i).mIndex;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                mOps[pos++] = 0;
            } //End block
            op = op.next;
        } //End block
        mTransition = bse.mTransition;
        mTransitionStyle = bse.mTransitionStyle;
        mName = bse.mName;
        mIndex = bse.mIndex;
        mBreadCrumbTitleRes = bse.mBreadCrumbTitleRes;
        mBreadCrumbTitleText = bse.mBreadCrumbTitleText;
        mBreadCrumbShortTitleRes = bse.mBreadCrumbShortTitleRes;
        mBreadCrumbShortTitleText = bse.mBreadCrumbShortTitleText;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.927 -0400", hash_original_method = "B968D118C09EBADBAB257C64BF10EDFC", hash_generated_method = "7BD6674E9A783E49DBE14C18BC1EA7D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BackStackState(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mOps = in.createIntArray();
        mTransition = in.readInt();
        mTransitionStyle = in.readInt();
        mName = in.readString();
        mIndex = in.readInt();
        mBreadCrumbTitleRes = in.readInt();
        mBreadCrumbTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        mBreadCrumbShortTitleRes = in.readInt();
        mBreadCrumbShortTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        // ---------- Original Method ----------
        //mOps = in.createIntArray();
        //mTransition = in.readInt();
        //mTransitionStyle = in.readInt();
        //mName = in.readString();
        //mIndex = in.readInt();
        //mBreadCrumbTitleRes = in.readInt();
        //mBreadCrumbTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
        //mBreadCrumbShortTitleRes = in.readInt();
        //mBreadCrumbShortTitleText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.928 -0400", hash_original_method = "F8D54BF837A015C95DFB9CC70933C9DB", hash_generated_method = "907991FEB337E316754BDC0BC18F42C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public BackStackRecord instantiate(FragmentManagerImpl fm) {
        dsTaint.addTaint(fm.dsTaint);
        BackStackRecord bse;
        bse = new BackStackRecord(fm);
        int pos;
        pos = 0;
        {
            BackStackRecord.Op op;
            op = new BackStackRecord.Op();
            op.cmd = mOps[pos++];
            Fragment f;
            f = fm.mActive.get(mOps[pos++]);
            op.fragment = f;
            op.enterAnim = mOps[pos++];
            op.exitAnim = mOps[pos++];
            op.popEnterAnim = mOps[pos++];
            op.popExitAnim = mOps[pos++];
            int N;
            N = mOps[pos++];
            {
                op.removed = new ArrayList<Fragment>(N);
                {
                    int i;
                    i = 0;
                    {
                        Fragment r;
                        r = fm.mActive.get(mOps[pos++]);
                        op.removed.add(r);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            bse.addOp(op);
        } //End block
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
        return (BackStackRecord)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.929 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.929 -0400", hash_original_method = "541B83E53D4985674BDE186AC23E769C", hash_generated_method = "9F832421A07E365B651E7F08BC9F31F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeIntArray(mOps);
        dest.writeInt(mTransition);
        dest.writeInt(mTransitionStyle);
        dest.writeString(mName);
        dest.writeInt(mIndex);
        dest.writeInt(mBreadCrumbTitleRes);
        TextUtils.writeToParcel(mBreadCrumbTitleText, dest, 0);
        dest.writeInt(mBreadCrumbShortTitleRes);
        TextUtils.writeToParcel(mBreadCrumbShortTitleText, dest, 0);
        // ---------- Original Method ----------
        //dest.writeIntArray(mOps);
        //dest.writeInt(mTransition);
        //dest.writeInt(mTransitionStyle);
        //dest.writeString(mName);
        //dest.writeInt(mIndex);
        //dest.writeInt(mBreadCrumbTitleRes);
        //TextUtils.writeToParcel(mBreadCrumbTitleText, dest, 0);
        //dest.writeInt(mBreadCrumbShortTitleRes);
        //TextUtils.writeToParcel(mBreadCrumbShortTitleText, dest, 0);
    }

    
    public static final Parcelable.Creator<BackStackState> CREATOR = new Parcelable.Creator<BackStackState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.930 -0400", hash_original_method = "446F3F0B27039EA3D28E6A300050AF77", hash_generated_method = "A947EA43C6CBC61070497AAF3B394E78")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BackStackState createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            BackStackState varEC511D34334A3F38F5E71398101FA92A_2096564823 = (new BackStackState(in));
            return (BackStackState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BackStackState(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.931 -0400", hash_original_method = "52EF176F83EE27DC9AB1AED05CDF3579", hash_generated_method = "1D13EE1D73BB431616BE68D69CA2BDDC")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public BackStackState[] newArray(int size) {
            dsTaint.addTaint(size);
            BackStackState[] var2B9C9674C32DE7FBBCA1C579C6389955_929674506 = (new BackStackState[size]);
            return (BackStackState[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new BackStackState[size];
        }

        
}; //Transformed anonymous class
}

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
    FragmentManagerImpl mManager;
    Op mHead;
    Op mTail;
    int mNumOp;
    int mEnterAnim;
    int mExitAnim;
    int mPopEnterAnim;
    int mPopExitAnim;
    int mTransition;
    int mTransitionStyle;
    boolean mAddToBackStack;
    boolean mAllowAddToBackStack = true;
    String mName;
    boolean mCommitted;
    int mIndex;
    int mBreadCrumbTitleRes;
    CharSequence mBreadCrumbTitleText;
    int mBreadCrumbShortTitleRes;
    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.931 -0400", hash_original_method = "8E110563CDFB79724FBA0799BF0D3C19", hash_generated_method = "B8D724D4CEC9182BAB937909547613A4")
    @DSModeled(DSC.SAFE)
    public BackStackRecord(FragmentManagerImpl manager) {
        dsTaint.addTaint(manager.dsTaint);
        // ---------- Original Method ----------
        //mManager = manager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.933 -0400", hash_original_method = "D2AEC534E855FE50C82F3A186CF8CD83", hash_generated_method = "A57C7035C27188E0C00794D93F412344")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dsTaint.addTaint(args[0]);
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(writer.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        writer.print(prefix);
        writer.print("mName=");
        writer.print(mName);
        writer.print(" mIndex=");
        writer.print(mIndex);
        writer.print(" mCommitted=");
        writer.println(mCommitted);
        {
            writer.print(prefix);
            writer.print("mTransition=#");
            writer.print(Integer.toHexString(mTransition));
            writer.print(" mTransitionStyle=#");
            writer.println(Integer.toHexString(mTransitionStyle));
        } //End block
        {
            writer.print(prefix);
            writer.print("mEnterAnim=#");
            writer.print(Integer.toHexString(mEnterAnim));
            writer.print(" mExitAnim=#");
            writer.println(Integer.toHexString(mExitAnim));
        } //End block
        {
            writer.print(prefix);
            writer.print("mPopEnterAnim=#");
            writer.print(Integer.toHexString(mPopEnterAnim));
            writer.print(" mPopExitAnim=#");
            writer.println(Integer.toHexString(mPopExitAnim));
        } //End block
        {
            writer.print(prefix);
            writer.print("mBreadCrumbTitleRes=#");
            writer.print(Integer.toHexString(mBreadCrumbTitleRes));
            writer.print(" mBreadCrumbTitleText=");
            writer.println(mBreadCrumbTitleText);
        } //End block
        {
            writer.print(prefix);
            writer.print("mBreadCrumbShortTitleRes=#");
            writer.print(Integer.toHexString(mBreadCrumbShortTitleRes));
            writer.print(" mBreadCrumbShortTitleText=");
            writer.println(mBreadCrumbShortTitleText);
        } //End block
        {
            writer.print(prefix);
            writer.println("Operations:");
            String innerPrefix;
            innerPrefix = prefix + "    ";
            Op op;
            op = mHead;
            int num;
            num = 0;
            {
                writer.print(prefix);
                writer.print("  Op #");
                writer.print(num);
                writer.println(":");
                writer.print(innerPrefix);
                writer.print("cmd=");
                writer.print(op.cmd);
                writer.print(" fragment=");
                writer.println(op.fragment);
                {
                    writer.print(prefix);
                    writer.print("enterAnim=#");
                    writer.print(Integer.toHexString(op.enterAnim));
                    writer.print(" exitAnim=#");
                    writer.println(Integer.toHexString(op.exitAnim));
                } //End block
                {
                    writer.print(prefix);
                    writer.print("popEnterAnim=#");
                    writer.print(Integer.toHexString(op.popEnterAnim));
                    writer.print(" popExitAnim=#");
                    writer.println(Integer.toHexString(op.popExitAnim));
                } //End block
                {
                    boolean varEDB78255635347BBB0E175782140D81C_1825463537 = (op.removed != null && op.removed.size() > 0);
                    {
                        {
                            int i;
                            i = 0;
                            boolean varFC8E7A96406C64F115442DF1E688D1EE_1354830590 = (i<op.removed.size());
                            {
                                writer.print(innerPrefix);
                                {
                                    boolean var62D68A13440BF768A88904F93FC01D74_1293937245 = (op.removed.size() == 1);
                                    {
                                        writer.print("Removed: ");
                                    } //End block
                                    {
                                        writer.println("Removed:");
                                        writer.print(innerPrefix);
                                        writer.print("  #");
                                        writer.print(num);
                                        writer.print(": ");
                                    } //End block
                                } //End collapsed parenthetic
                                writer.println(op.removed.get(i));
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                } //End collapsed parenthetic
                op = op.next;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.934 -0400", hash_original_method = "15A4A4C5F4518D2E82F335984591D8BA", hash_generated_method = "678EEA91321847F9411657961D2411FB")
    @DSModeled(DSC.SAFE)
    public int getId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.934 -0400", hash_original_method = "9339385C292A3B9874BA3EB436AA9056", hash_generated_method = "75FBD338CCEE722DAF864BCFFCAE7B21")
    @DSModeled(DSC.SAFE)
    public int getBreadCrumbTitleRes() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBreadCrumbTitleRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.935 -0400", hash_original_method = "D139A03B61A4B83382000704FB0C1F23", hash_generated_method = "807EB54CCD1123DAB289F5887E990185")
    @DSModeled(DSC.SAFE)
    public int getBreadCrumbShortTitleRes() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mBreadCrumbShortTitleRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.935 -0400", hash_original_method = "C2C5B49D77ECFC3F06C4280D5C67187D", hash_generated_method = "D9F638B17A14F8FE6346B1B1D6C5FCCD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getBreadCrumbTitle() {
        {
            CharSequence var3D309D4E803D3B25A178282DE0CF9433_1022886921 = (mManager.mActivity.getText(mBreadCrumbTitleRes));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mBreadCrumbTitleRes != 0) {
            //return mManager.mActivity.getText(mBreadCrumbTitleRes);
        //}
        //return mBreadCrumbTitleText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.937 -0400", hash_original_method = "CEC326312BE69049B0B2FA6420FE6494", hash_generated_method = "36E6ECA6FDAD7C4B3EF59459EBDB1D13")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence getBreadCrumbShortTitle() {
        {
            CharSequence var754853857E0E655B8130F56823813855_571553554 = (mManager.mActivity.getText(mBreadCrumbShortTitleRes));
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (mBreadCrumbShortTitleRes != 0) {
            //return mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        //}
        //return mBreadCrumbShortTitleText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.938 -0400", hash_original_method = "32D26C73BB31A0FE5D5A21F02980CDDD", hash_generated_method = "87E9F6AAE668C8BC3FB7FB745925570E")
    @DSModeled(DSC.SAFE)
     void addOp(Op op) {
        dsTaint.addTaint(op.dsTaint);
        {
            mHead = mTail = op;
        } //End block
        {
            op.prev = mTail;
            mTail.next = op;
        } //End block
        op.enterAnim = mEnterAnim;
        op.exitAnim = mExitAnim;
        op.popEnterAnim = mPopEnterAnim;
        op.popExitAnim = mPopExitAnim;
        // ---------- Original Method ----------
        //if (mHead == null) {
            //mHead = mTail = op;
        //} else {
            //op.prev = mTail;
            //mTail.next = op;
            //mTail = op;
        //}
        //op.enterAnim = mEnterAnim;
        //op.exitAnim = mExitAnim;
        //op.popEnterAnim = mPopEnterAnim;
        //op.popExitAnim = mPopExitAnim;
        //mNumOp++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.940 -0400", hash_original_method = "C1E47B5485B0B08AA827320F8BD79938", hash_generated_method = "32D4B3B72C993DA944BBB5A8A8A9FB8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction add(Fragment fragment, String tag) {
        dsTaint.addTaint(tag);
        dsTaint.addTaint(fragment.dsTaint);
        doAddOp(0, fragment, tag, OP_ADD);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //doAddOp(0, fragment, tag, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.941 -0400", hash_original_method = "F34A7243D750E416C8B46711401682C6", hash_generated_method = "A2836D68D21C020ED758E6A0A1143234")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        dsTaint.addTaint(containerViewId);
        dsTaint.addTaint(fragment.dsTaint);
        doAddOp(containerViewId, fragment, null, OP_ADD);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //doAddOp(containerViewId, fragment, null, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.942 -0400", hash_original_method = "DCEB5E0B408763C7F0E9A3376CBD91C3", hash_generated_method = "E292F21C2E80A6D7F75D19E823EC454E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        dsTaint.addTaint(containerViewId);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(fragment.dsTaint);
        doAddOp(containerViewId, fragment, tag, OP_ADD);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //doAddOp(containerViewId, fragment, tag, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.943 -0400", hash_original_method = "F2F897C7BFD0AE6B1B051FF1D3DE8AB7", hash_generated_method = "D0FDCF2C700D4FC27C84593DEC2E574D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void doAddOp(int containerViewId, Fragment fragment, String tag, int opcmd) {
        dsTaint.addTaint(containerViewId);
        dsTaint.addTaint(opcmd);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(fragment.dsTaint);
        fragment.mFragmentManager = mManager;
        {
            {
                boolean var61C8A6195E53C3C93A2D5BC238E04849_975576909 = (fragment.mTag != null && !tag.equals(fragment.mTag));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can't change tag of fragment "
                        + fragment + ": was " + fragment.mTag
                        + " now " + tag);
                } //End block
            } //End collapsed parenthetic
            fragment.mTag = tag;
        } //End block
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can't change container ID of fragment "
                        + fragment + ": was " + fragment.mFragmentId
                        + " now " + containerViewId);
            } //End block
            fragment.mContainerId = fragment.mFragmentId = containerViewId;
        } //End block
        Op op;
        op = new Op();
        op.cmd = opcmd;
        op.fragment = fragment;
        addOp(op);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.944 -0400", hash_original_method = "095D291C1CAFD923EC9CB9BF06EF4676", hash_generated_method = "BF32D39DD756AE751204B8FE3C366B01")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        dsTaint.addTaint(containerViewId);
        dsTaint.addTaint(fragment.dsTaint);
        FragmentTransaction var8794FA5D6F54D05DD081141427ED4CA9_406822801 = (replace(containerViewId, fragment, null));
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return replace(containerViewId, fragment, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.945 -0400", hash_original_method = "1C07811E78071E2352BF0C170F6491CA", hash_generated_method = "9FD6C961C738DC20F4E4D391D791F1DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        dsTaint.addTaint(containerViewId);
        dsTaint.addTaint(tag);
        dsTaint.addTaint(fragment.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must use non-zero containerViewId");
        } //End block
        doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (containerViewId == 0) {
            //throw new IllegalArgumentException("Must use non-zero containerViewId");
        //}
        //doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.945 -0400", hash_original_method = "33682B1B727BD924F48FE7F483A5C004", hash_generated_method = "F8636F07549436006350FFF4F348FB55")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction remove(Fragment fragment) {
        dsTaint.addTaint(fragment.dsTaint);
        Op op;
        op = new Op();
        op.cmd = OP_REMOVE;
        op.fragment = fragment;
        addOp(op);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_REMOVE;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.946 -0400", hash_original_method = "AB9058E54F9496DA8E33E643603CB0C7", hash_generated_method = "A92A7999BBF33D681DF1A0334B549C8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction hide(Fragment fragment) {
        dsTaint.addTaint(fragment.dsTaint);
        Op op;
        op = new Op();
        op.cmd = OP_HIDE;
        op.fragment = fragment;
        addOp(op);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_HIDE;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.946 -0400", hash_original_method = "2B6B1F1BD336D20AECF3763EE9DD5949", hash_generated_method = "FA3C48D33094E2AA841C94E61B4679B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction show(Fragment fragment) {
        dsTaint.addTaint(fragment.dsTaint);
        Op op;
        op = new Op();
        op.cmd = OP_SHOW;
        op.fragment = fragment;
        addOp(op);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_SHOW;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.947 -0400", hash_original_method = "60B4979E5A31C92DF6F58D0AB0599A51", hash_generated_method = "4456978E9593779E4B985B8023EFA3A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction detach(Fragment fragment) {
        dsTaint.addTaint(fragment.dsTaint);
        Op op;
        op = new Op();
        op.cmd = OP_DETACH;
        op.fragment = fragment;
        addOp(op);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_DETACH;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.947 -0400", hash_original_method = "71B1C0469F9D1680729415A070BB9988", hash_generated_method = "0BD77988EFA913520CB3312E9D84DF6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction attach(Fragment fragment) {
        dsTaint.addTaint(fragment.dsTaint);
        Op op;
        op = new Op();
        op.cmd = OP_ATTACH;
        op.fragment = fragment;
        addOp(op);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_ATTACH;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.948 -0400", hash_original_method = "E8FBC41447C7F5B20E8F08F3A2F7FD58", hash_generated_method = "977F780E2F36F8F40223612D5693C22E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        dsTaint.addTaint(enter);
        dsTaint.addTaint(exit);
        FragmentTransaction var43AFEC1CBC06D37F056374DEB55047D1_2086520120 = (setCustomAnimations(enter, exit, 0, 0));
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return setCustomAnimations(enter, exit, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.948 -0400", hash_original_method = "A0614C8D91A2CFFC3B2827B585934661", hash_generated_method = "9D04F5A62CF1F0CD6590AD92696C1723")
    @DSModeled(DSC.SAFE)
    public FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit) {
        dsTaint.addTaint(popExit);
        dsTaint.addTaint(popEnter);
        dsTaint.addTaint(enter);
        dsTaint.addTaint(exit);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mEnterAnim = enter;
        //mExitAnim = exit;
        //mPopEnterAnim = popEnter;
        //mPopExitAnim = popExit;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.949 -0400", hash_original_method = "A455FB052D79EC1710E986C50AD0D972", hash_generated_method = "9736EC3D1144339EFE3FA89788BC6B54")
    @DSModeled(DSC.SAFE)
    public FragmentTransaction setTransition(int transition) {
        dsTaint.addTaint(transition);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTransition = transition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.949 -0400", hash_original_method = "A33CAFCA32BB4FD1A454655E75F4B6CB", hash_generated_method = "D17F7E8AFFB22C490C09347DE8408009")
    @DSModeled(DSC.SAFE)
    public FragmentTransaction setTransitionStyle(int styleRes) {
        dsTaint.addTaint(styleRes);
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mTransitionStyle = styleRes;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.950 -0400", hash_original_method = "438624ACF19A9F6511A0E99CD6264659", hash_generated_method = "A8C206742D345A67AC7338B4C9298A4A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction addToBackStack(String name) {
        dsTaint.addTaint(name);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This FragmentTransaction is not allowed to be added to the back stack.");
        } //End block
        mAddToBackStack = true;
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (!mAllowAddToBackStack) {
            //throw new IllegalStateException(
                    //"This FragmentTransaction is not allowed to be added to the back stack.");
        //}
        //mAddToBackStack = true;
        //mName = name;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.951 -0400", hash_original_method = "6063A0768FB0FF8A9BC1A0D5BDF7E352", hash_generated_method = "19B04D21065276799D9D7F86A6BD98FA")
    @DSModeled(DSC.SAFE)
    public boolean isAddToBackStackAllowed() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mAllowAddToBackStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.961 -0400", hash_original_method = "FA98892FC811CB8446B86919ACA0FBBA", hash_generated_method = "DA68268BBFB6372B2A4E1B4A99CF7B46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public FragmentTransaction disallowAddToBackStack() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This transaction is already being added to the back stack");
        } //End block
        mAllowAddToBackStack = false;
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (mAddToBackStack) {
            //throw new IllegalStateException(
                    //"This transaction is already being added to the back stack");
        //}
        //mAllowAddToBackStack = false;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.962 -0400", hash_original_method = "3ED721B4C54764795D085FCDFAF2CFED", hash_generated_method = "F8D6A6FC5E8CCFD75B568972230CDEE0")
    @DSModeled(DSC.SAFE)
    public FragmentTransaction setBreadCrumbTitle(int res) {
        dsTaint.addTaint(res);
        mBreadCrumbTitleText = null;
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mBreadCrumbTitleRes = res;
        //mBreadCrumbTitleText = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.964 -0400", hash_original_method = "27CB0DA08C946E1C367250B9E9010CF2", hash_generated_method = "D3BC885093FBDC75D64A6300D3591AC6")
    @DSModeled(DSC.SAFE)
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        dsTaint.addTaint(text);
        mBreadCrumbTitleRes = 0;
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mBreadCrumbTitleRes = 0;
        //mBreadCrumbTitleText = text;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.965 -0400", hash_original_method = "F0E82E7069B2F6B7E25A71F53DDE4690", hash_generated_method = "095C0EB0E5DB660F8353F1678BC03595")
    @DSModeled(DSC.SAFE)
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        dsTaint.addTaint(res);
        mBreadCrumbShortTitleText = null;
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mBreadCrumbShortTitleRes = res;
        //mBreadCrumbShortTitleText = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.966 -0400", hash_original_method = "0432E2D3026F58B259B18084E0B71CFD", hash_generated_method = "306107C87F1F8939C54EF61E623238B3")
    @DSModeled(DSC.SAFE)
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        dsTaint.addTaint(text);
        mBreadCrumbShortTitleRes = 0;
        return (FragmentTransaction)dsTaint.getTaint();
        // ---------- Original Method ----------
        //mBreadCrumbShortTitleRes = 0;
        //mBreadCrumbShortTitleText = text;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.967 -0400", hash_original_method = "350B86C0CFAA72F059C15CB3FE1D993C", hash_generated_method = "051D73C462272AA4C17A35E2F96FC2ED")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     void bumpBackStackNesting(int amt) {
        dsTaint.addTaint(amt);
        Op op;
        op = mHead;
        {
            op.fragment.mBackStackNesting += amt;
            {
                {
                    int i;
                    i = op.removed.size()-1;
                    {
                        Fragment r;
                        r = op.removed.get(i);
                        r.mBackStackNesting += amt;
                    } //End block
                } //End collapsed parenthetic
            } //End block
            op = op.next;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.969 -0400", hash_original_method = "FD69B9F14C4FF1755ADA5F3EFF5DDDFB", hash_generated_method = "1D6B58C59AAA732042B71DD225F1A1C6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int commit() {
        int varA4BCCB8ECB291B501D37CCD084E598C0_1937065664 = (commitInternal(false));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return commitInternal(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.970 -0400", hash_original_method = "034B152615D8FC6D1FD7AD2899313AE6", hash_generated_method = "8821D2D9089D2C22D861F4ACFC7FCDCE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int commitAllowingStateLoss() {
        int varF7F203ED57B6AC8381E1DDB9CA29847A_1035800492 = (commitInternal(true));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return commitInternal(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.971 -0400", hash_original_method = "9BF727F0CCA97F90C9847FCD006039C1", hash_generated_method = "CB94B8536AEB48375CC3A856BC503DB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     int commitInternal(boolean allowStateLoss) {
        dsTaint.addTaint(allowStateLoss);
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("commit already called");
        mCommitted = true;
        {
            mIndex = mManager.allocBackStackIndex(this);
        } //End block
        {
            mIndex = -1;
        } //End block
        mManager.enqueueAction(this, allowStateLoss);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (mCommitted) throw new IllegalStateException("commit already called");
        //if (FragmentManagerImpl.DEBUG) Log.v(TAG, "Commit: " + this);
        //mCommitted = true;
        //if (mAddToBackStack) {
            //mIndex = mManager.allocBackStackIndex(this);
        //} else {
            //mIndex = -1;
        //}
        //mManager.enqueueAction(this, allowStateLoss);
        //return mIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.973 -0400", hash_original_method = "BA0CE442AF616D2BBAA3AAFEB295CD0F", hash_generated_method = "6D619D3230FAE1DB7D6919DD10A9746C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void run() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("addToBackStack() called after commit()");
            } //End block
        } //End block
        bumpBackStackNesting(1);
        Op op;
        op = mHead;
        {
            //Begin case OP_ADD 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.addFragment(f, false);
            } //End block
            //End case OP_ADD 
            //Begin case OP_REPLACE 
            {
                Fragment f;
                f = op.fragment;
                {
                    {
                        int i;
                        i = 0;
                        boolean var4043C011AEA95069BE526E5C0117EEF7_1922018325 = (i<mManager.mAdded.size());
                        {
                            Fragment old;
                            old = mManager.mAdded.get(i);
                            {
                                {
                                    op.removed = new ArrayList<Fragment>();
                                } //End block
                                op.removed.add(old);
                                old.mNextAnim = op.exitAnim;
                                {
                                    old.mBackStackNesting += 1;
                                } //End block
                                mManager.removeFragment(old, mTransition, mTransitionStyle);
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                f.mNextAnim = op.enterAnim;
                mManager.addFragment(f, false);
            } //End block
            //End case OP_REPLACE 
            //Begin case OP_REMOVE 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.removeFragment(f, mTransition, mTransitionStyle);
            } //End block
            //End case OP_REMOVE 
            //Begin case OP_HIDE 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.hideFragment(f, mTransition, mTransitionStyle);
            } //End block
            //End case OP_HIDE 
            //Begin case OP_SHOW 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.showFragment(f, mTransition, mTransitionStyle);
            } //End block
            //End case OP_SHOW 
            //Begin case OP_DETACH 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.detachFragment(f, mTransition, mTransitionStyle);
            } //End block
            //End case OP_DETACH 
            //Begin case OP_ATTACH 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.attachFragment(f, mTransition, mTransitionStyle);
            } //End block
            //End case OP_ATTACH 
            //Begin case default 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
            } //End block
            //End case default 
            op = op.next;
        } //End block
        mManager.moveToState(mManager.mCurState, mTransition,
                mTransitionStyle, true);
        {
            mManager.addBackStackState(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.974 -0400", hash_original_method = "7F72D15008964B0C744517E586063B58", hash_generated_method = "8B548EEACF20F3E3995FBE5497A657AA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void popFromBackStack(boolean doStateMove) {
        dsTaint.addTaint(doStateMove);
        bumpBackStackNesting(-1);
        Op op;
        op = mTail;
        {
            //Begin case OP_ADD 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.removeFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition),
                            mTransitionStyle);
            } //End block
            //End case OP_ADD 
            //Begin case OP_REPLACE 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.removeFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition),
                            mTransitionStyle);
                {
                    {
                        int i;
                        i = 0;
                        boolean var0A487E0BD4FDD947920F1BEB18753DAE_1010890727 = (i<op.removed.size());
                        {
                            Fragment old;
                            old = op.removed.get(i);
                            old.mNextAnim = op.popEnterAnim;
                            mManager.addFragment(old, false);
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
            //End case OP_REPLACE 
            //Begin case OP_REMOVE 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.addFragment(f, false);
            } //End block
            //End case OP_REMOVE 
            //Begin case OP_HIDE 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.showFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } //End block
            //End case OP_HIDE 
            //Begin case OP_SHOW 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.hideFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } //End block
            //End case OP_SHOW 
            //Begin case OP_DETACH 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.attachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } //End block
            //End case OP_DETACH 
            //Begin case OP_ATTACH 
            {
                Fragment f;
                f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.detachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } //End block
            //End case OP_ATTACH 
            //Begin case default 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
            } //End block
            //End case default 
            op = op.prev;
        } //End block
        {
            mManager.moveToState(mManager.mCurState,
                    FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle, true);
        } //End block
        {
            mManager.freeBackStackIndex(mIndex);
            mIndex = -1;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.975 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "1698AF415E3250D582962C1A88D4A564")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.976 -0400", hash_original_method = "78EE7FB9A966094E1E15EEF50B50E3C9", hash_generated_method = "9C38DA4409855731D419143C033CF0FE")
    @DSModeled(DSC.SAFE)
    public int getTransition() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTransition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.976 -0400", hash_original_method = "0B18827E69C997D5383C8EBB7663D372", hash_generated_method = "6220D7D4B421C95BC30CC0687A229841")
    @DSModeled(DSC.SAFE)
    public int getTransitionStyle() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mTransitionStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.977 -0400", hash_original_method = "98C448D4C76D2FE85810E0C03648865C", hash_generated_method = "F0D41510391306A6AD82D7AFF5EE796D")
    @DSModeled(DSC.SAFE)
    public boolean isEmpty() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return mNumOp == 0;
    }

    
    static final class Op {
        Op next;
        Op prev;
        int cmd;
        Fragment fragment;
        int enterAnim;
        int exitAnim;
        int popEnterAnim;
        int popExitAnim;
        ArrayList<Fragment> removed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:36.977 -0400", hash_original_method = "FAD1F1240114573845BBFF53E74C46DC", hash_generated_method = "FAD1F1240114573845BBFF53E74C46DC")
                public Op ()
        {
        }


    }


    
    static final String TAG = "BackStackEntry";
    static final int OP_NULL = 0;
    static final int OP_ADD = 1;
    static final int OP_REPLACE = 2;
    static final int OP_REMOVE = 3;
    static final int OP_HIDE = 4;
    static final int OP_SHOW = 5;
    static final int OP_DETACH = 6;
    static final int OP_ATTACH = 7;
}

