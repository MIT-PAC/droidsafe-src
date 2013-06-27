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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.121 -0400", hash_original_field = "B18521543B0A3F13E96EC9C4900EECCC", hash_generated_field = "DC6A1E8A42383143F0A42B30213419A5")

    int[] mOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.122 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.122 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.138 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.139 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.140 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.140 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.151 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.151 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.170 -0400", hash_original_method = "DCE5061D40CBE6F430759A7A23E4D4F8", hash_generated_method = "4056D36982CB216FDE54547CE3E29AC8")
    public  BackStackState(FragmentManagerImpl fm, BackStackRecord bse) {
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
        addTaint(fm.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.194 -0400", hash_original_method = "B968D118C09EBADBAB257C64BF10EDFC", hash_generated_method = "2316B0F18A4F6F99AFA9D18FA79B9D5D")
    public  BackStackState(Parcel in) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.232 -0400", hash_original_method = "F8D54BF837A015C95DFB9CC70933C9DB", hash_generated_method = "781730CCFFB4838AD65BD92A75E1469F")
    public BackStackRecord instantiate(FragmentManagerImpl fm) {
        BackStackRecord varB4EAC82CA7396A68D541C85D26508E83_26202954 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_26202954 = bse;
        addTaint(fm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_26202954.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_26202954;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.234 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2F9675051CFAE0A8105C400D647D99DE")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995553659 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1995553659;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.322 -0400", hash_original_method = "541B83E53D4985674BDE186AC23E769C", hash_generated_method = "0522827BA0739F7A319A5711FF8AD49B")
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
        addTaint(dest.getTaint());
        addTaint(flags);
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.322 -0400", hash_original_field = "8B8CFB1C8824B4F8DAC46E032DB231EE", hash_generated_field = "FC56B3496DF6C62063CE25DEA3B38012")

    public static final Parcelable.Creator<BackStackState> CREATOR
            = new Parcelable.Creator<BackStackState>() {
        public BackStackState createFromParcel(Parcel in) {
            return new BackStackState(in);
        }

        public BackStackState[] newArray(int size) {
            return new BackStackState[size];
        }
    };
}

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.323 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "B6E40031C2D8257644CECE00AFE40458")

    FragmentManagerImpl mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.334 -0400", hash_original_field = "3910F709012F9D394BA43407D42AB0EC", hash_generated_field = "CAA200DE64F101586FA95F4FEC8429B1")

    Op mHead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.334 -0400", hash_original_field = "B2497DC9780B7282659AE377C47B70F1", hash_generated_field = "1DBFB57BC3C0C58F1CA989515A3C11B2")

    Op mTail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.335 -0400", hash_original_field = "FE7F5679DE5AB4EFCB7F73888C73482C", hash_generated_field = "7C2498E5F23A289A087BC718DE147927")

    int mNumOp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.335 -0400", hash_original_field = "1571B5D671DA2B5A71024C9969DA04AB", hash_generated_field = "25DA9A900AA8941601D4713D8643BCFF")

    int mEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.359 -0400", hash_original_field = "A64201543D48ED8DDD115D4151A3A908", hash_generated_field = "0403C21FF2E329089D303DA2F881AD65")

    int mExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.359 -0400", hash_original_field = "A606606C729A4D4BD754EB55FB1D92F2", hash_generated_field = "426B5FECE57930E7AC2A692D910E1B95")

    int mPopEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.360 -0400", hash_original_field = "48FF7BCE9BEDFB9C61D4EE16EAE35C46", hash_generated_field = "336F0E1CA15D2B7CFA7AB64448E9ABB4")

    int mPopExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.377 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.377 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.378 -0400", hash_original_field = "AB01F2F4FD691611940FB5D9DC3F4D9F", hash_generated_field = "6D620657E4B0D7E3BF4B4C9A3EA1860D")

    boolean mAddToBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.379 -0400", hash_original_field = "BEF2A6B0CCD60C687FB884F8E59C1EC3", hash_generated_field = "00D17B9289ED52FD64E1F76DBFE93EE5")

    boolean mAllowAddToBackStack = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.396 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.397 -0400", hash_original_field = "ECB201FF1883B37FDCC5CA9037698543", hash_generated_field = "34350BC5CB525FC021F5A246971120D8")

    boolean mCommitted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.398 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.398 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.422 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.422 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.423 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.438 -0400", hash_original_method = "8E110563CDFB79724FBA0799BF0D3C19", hash_generated_method = "222018A87C5C0AD32DB56B9265BCFEC3")
    public  BackStackRecord(FragmentManagerImpl manager) {
        mManager = manager;
        // ---------- Original Method ----------
        //mManager = manager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.500 -0400", hash_original_method = "D2AEC534E855FE50C82F3A186CF8CD83", hash_generated_method = "A70C3193101B2C18C1E25260F2E01A88")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
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
                    boolean varEDB78255635347BBB0E175782140D81C_385047799 = (op.removed != null && op.removed.size() > 0);
                    {
                        {
                            int i;
                            i = 0;
                            boolean varFC8E7A96406C64F115442DF1E688D1EE_1851460824 = (i<op.removed.size());
                            {
                                writer.print(innerPrefix);
                                {
                                    boolean var62D68A13440BF768A88904F93FC01D74_758964686 = (op.removed.size() == 1);
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
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.514 -0400", hash_original_method = "15A4A4C5F4518D2E82F335984591D8BA", hash_generated_method = "3D993ACAB84A11319E7E741089BEE663")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877175387 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877175387;
        // ---------- Original Method ----------
        //return mIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.540 -0400", hash_original_method = "9339385C292A3B9874BA3EB436AA9056", hash_generated_method = "EE32765363E69D0B1CA4216AD24C1193")
    public int getBreadCrumbTitleRes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169422336 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_169422336;
        // ---------- Original Method ----------
        //return mBreadCrumbTitleRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.542 -0400", hash_original_method = "D139A03B61A4B83382000704FB0C1F23", hash_generated_method = "D4D3E36B1ED896764FF2C7FE5C0D36E6")
    public int getBreadCrumbShortTitleRes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1147573187 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1147573187;
        // ---------- Original Method ----------
        //return mBreadCrumbShortTitleRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.590 -0400", hash_original_method = "C2C5B49D77ECFC3F06C4280D5C67187D", hash_generated_method = "ACA133BB4F908E731603CE784083A270")
    public CharSequence getBreadCrumbTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2100759387 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_383967788 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_2100759387 = mManager.mActivity.getText(mBreadCrumbTitleRes);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_383967788 = mBreadCrumbTitleText;
        CharSequence varA7E53CE21691AB073D9660D615818899_578814494; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_578814494 = varB4EAC82CA7396A68D541C85D26508E83_2100759387;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_578814494 = varB4EAC82CA7396A68D541C85D26508E83_383967788;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_578814494.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_578814494;
        // ---------- Original Method ----------
        //if (mBreadCrumbTitleRes != 0) {
            //return mManager.mActivity.getText(mBreadCrumbTitleRes);
        //}
        //return mBreadCrumbTitleText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.595 -0400", hash_original_method = "CEC326312BE69049B0B2FA6420FE6494", hash_generated_method = "2045977CE26BF3D45A839BE397A289F9")
    public CharSequence getBreadCrumbShortTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1135970128 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_413964354 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1135970128 = mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_413964354 = mBreadCrumbShortTitleText;
        CharSequence varA7E53CE21691AB073D9660D615818899_635818233; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_635818233 = varB4EAC82CA7396A68D541C85D26508E83_1135970128;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_635818233 = varB4EAC82CA7396A68D541C85D26508E83_413964354;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_635818233.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_635818233;
        // ---------- Original Method ----------
        //if (mBreadCrumbShortTitleRes != 0) {
            //return mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        //}
        //return mBreadCrumbShortTitleText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.635 -0400", hash_original_method = "32D26C73BB31A0FE5D5A21F02980CDDD", hash_generated_method = "CE7C17BEEFFEA12FE826AC8922B9C5B8")
     void addOp(Op op) {
        {
            mHead = mTail = op;
        } //End block
        {
            op.prev = mTail;
            mTail.next = op;
            mTail = op;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.651 -0400", hash_original_method = "C1E47B5485B0B08AA827320F8BD79938", hash_generated_method = "1A002D75966347EFCCEA4021BDF814E2")
    public FragmentTransaction add(Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_2136321720 = null; //Variable for return #1
        doAddOp(0, fragment, tag, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_2136321720 = this;
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2136321720.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2136321720;
        // ---------- Original Method ----------
        //doAddOp(0, fragment, tag, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.655 -0400", hash_original_method = "F34A7243D750E416C8B46711401682C6", hash_generated_method = "6B4382E49EA2C3327D16647A9DEEAB8C")
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_960425700 = null; //Variable for return #1
        doAddOp(containerViewId, fragment, null, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_960425700 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_960425700.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_960425700;
        // ---------- Original Method ----------
        //doAddOp(containerViewId, fragment, null, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.678 -0400", hash_original_method = "DCEB5E0B408763C7F0E9A3376CBD91C3", hash_generated_method = "CD068F77D0D07F8CDCF51B38A5383BF4")
    public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_25068892 = null; //Variable for return #1
        doAddOp(containerViewId, fragment, tag, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_25068892 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_25068892.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_25068892;
        // ---------- Original Method ----------
        //doAddOp(containerViewId, fragment, tag, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.706 -0400", hash_original_method = "F2F897C7BFD0AE6B1B051FF1D3DE8AB7", hash_generated_method = "137FB399FFD6F6B45C38CA1557C8DA48")
    private void doAddOp(int containerViewId, Fragment fragment, String tag, int opcmd) {
        fragment.mFragmentManager = mManager;
        {
            {
                boolean var61C8A6195E53C3C93A2D5BC238E04849_1971319173 = (fragment.mTag != null && !tag.equals(fragment.mTag));
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
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        addTaint(opcmd);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.716 -0400", hash_original_method = "095D291C1CAFD923EC9CB9BF06EF4676", hash_generated_method = "E595121AFB61B60E111192C661723128")
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1744216645 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1744216645 = replace(containerViewId, fragment, null);
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1744216645.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1744216645;
        // ---------- Original Method ----------
        //return replace(containerViewId, fragment, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.758 -0400", hash_original_method = "1C07811E78071E2352BF0C170F6491CA", hash_generated_method = "92C64453C57205F5D96584ECBE1C08BD")
    public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1098403799 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must use non-zero containerViewId");
        } //End block
        doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        varB4EAC82CA7396A68D541C85D26508E83_1098403799 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1098403799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1098403799;
        // ---------- Original Method ----------
        //if (containerViewId == 0) {
            //throw new IllegalArgumentException("Must use non-zero containerViewId");
        //}
        //doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.780 -0400", hash_original_method = "33682B1B727BD924F48FE7F483A5C004", hash_generated_method = "EE267378C64759864814987E99359F05")
    public FragmentTransaction remove(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_293489423 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_REMOVE;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_293489423 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_293489423.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_293489423;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_REMOVE;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.798 -0400", hash_original_method = "AB9058E54F9496DA8E33E643603CB0C7", hash_generated_method = "434C7662D907D84F841F5DD939275DF5")
    public FragmentTransaction hide(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_484227610 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_HIDE;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_484227610 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_484227610.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_484227610;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_HIDE;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.800 -0400", hash_original_method = "2B6B1F1BD336D20AECF3763EE9DD5949", hash_generated_method = "61CEF0939CD2062036443A442330F7F8")
    public FragmentTransaction show(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_713789578 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_SHOW;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_713789578 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_713789578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_713789578;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_SHOW;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.830 -0400", hash_original_method = "60B4979E5A31C92DF6F58D0AB0599A51", hash_generated_method = "D2EAC652456A11883B821B7FD0EEB919")
    public FragmentTransaction detach(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_697869114 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_DETACH;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_697869114 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_697869114.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_697869114;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_DETACH;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.862 -0400", hash_original_method = "71B1C0469F9D1680729415A070BB9988", hash_generated_method = "83DFF874CFC394A72C6D092D00D11902")
    public FragmentTransaction attach(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_863296955 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_ATTACH;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_863296955 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_863296955.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_863296955;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_ATTACH;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.880 -0400", hash_original_method = "E8FBC41447C7F5B20E8F08F3A2F7FD58", hash_generated_method = "BC5585D8C6E646E8DFD120BE3CA8F503")
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_933313545 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_933313545 = setCustomAnimations(enter, exit, 0, 0);
        addTaint(enter);
        addTaint(exit);
        varB4EAC82CA7396A68D541C85D26508E83_933313545.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_933313545;
        // ---------- Original Method ----------
        //return setCustomAnimations(enter, exit, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.900 -0400", hash_original_method = "A0614C8D91A2CFFC3B2827B585934661", hash_generated_method = "51B9D5C65B239EB15C12C12FE98663E6")
    public FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1513293821 = null; //Variable for return #1
        mEnterAnim = enter;
        mExitAnim = exit;
        mPopEnterAnim = popEnter;
        mPopExitAnim = popExit;
        varB4EAC82CA7396A68D541C85D26508E83_1513293821 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1513293821.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1513293821;
        // ---------- Original Method ----------
        //mEnterAnim = enter;
        //mExitAnim = exit;
        //mPopEnterAnim = popEnter;
        //mPopExitAnim = popExit;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.925 -0400", hash_original_method = "A455FB052D79EC1710E986C50AD0D972", hash_generated_method = "D797E323E28EACA3D9F805B4FB8F2FC0")
    public FragmentTransaction setTransition(int transition) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_843395275 = null; //Variable for return #1
        mTransition = transition;
        varB4EAC82CA7396A68D541C85D26508E83_843395275 = this;
        varB4EAC82CA7396A68D541C85D26508E83_843395275.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_843395275;
        // ---------- Original Method ----------
        //mTransition = transition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.947 -0400", hash_original_method = "A33CAFCA32BB4FD1A454655E75F4B6CB", hash_generated_method = "C8945CE070B67BADEF40AC6662F78DFF")
    public FragmentTransaction setTransitionStyle(int styleRes) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_344339618 = null; //Variable for return #1
        mTransitionStyle = styleRes;
        varB4EAC82CA7396A68D541C85D26508E83_344339618 = this;
        varB4EAC82CA7396A68D541C85D26508E83_344339618.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_344339618;
        // ---------- Original Method ----------
        //mTransitionStyle = styleRes;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.968 -0400", hash_original_method = "438624ACF19A9F6511A0E99CD6264659", hash_generated_method = "C668FC9DB097ECA44DFFDCEF9B77BD74")
    public FragmentTransaction addToBackStack(String name) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_63933977 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This FragmentTransaction is not allowed to be added to the back stack.");
        } //End block
        mAddToBackStack = true;
        mName = name;
        varB4EAC82CA7396A68D541C85D26508E83_63933977 = this;
        varB4EAC82CA7396A68D541C85D26508E83_63933977.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_63933977;
        // ---------- Original Method ----------
        //if (!mAllowAddToBackStack) {
            //throw new IllegalStateException(
                    //"This FragmentTransaction is not allowed to be added to the back stack.");
        //}
        //mAddToBackStack = true;
        //mName = name;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.988 -0400", hash_original_method = "6063A0768FB0FF8A9BC1A0D5BDF7E352", hash_generated_method = "BCA7BC04F51BD34C678503674B97A8DB")
    public boolean isAddToBackStackAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_767810646 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_767810646;
        // ---------- Original Method ----------
        //return mAllowAddToBackStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:47.994 -0400", hash_original_method = "FA98892FC811CB8446B86919ACA0FBBA", hash_generated_method = "5B2E78281F4D3D7C0671E1677A4333A8")
    public FragmentTransaction disallowAddToBackStack() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_2077579904 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This transaction is already being added to the back stack");
        } //End block
        mAllowAddToBackStack = false;
        varB4EAC82CA7396A68D541C85D26508E83_2077579904 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2077579904.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2077579904;
        // ---------- Original Method ----------
        //if (mAddToBackStack) {
            //throw new IllegalStateException(
                    //"This transaction is already being added to the back stack");
        //}
        //mAllowAddToBackStack = false;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.026 -0400", hash_original_method = "3ED721B4C54764795D085FCDFAF2CFED", hash_generated_method = "8091D06876F4DF87D98A459422647A67")
    public FragmentTransaction setBreadCrumbTitle(int res) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_785123779 = null; //Variable for return #1
        mBreadCrumbTitleRes = res;
        mBreadCrumbTitleText = null;
        varB4EAC82CA7396A68D541C85D26508E83_785123779 = this;
        varB4EAC82CA7396A68D541C85D26508E83_785123779.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_785123779;
        // ---------- Original Method ----------
        //mBreadCrumbTitleRes = res;
        //mBreadCrumbTitleText = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.028 -0400", hash_original_method = "27CB0DA08C946E1C367250B9E9010CF2", hash_generated_method = "547AA1EB3DB0065629BCDB35428891D4")
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_139653120 = null; //Variable for return #1
        mBreadCrumbTitleRes = 0;
        mBreadCrumbTitleText = text;
        varB4EAC82CA7396A68D541C85D26508E83_139653120 = this;
        varB4EAC82CA7396A68D541C85D26508E83_139653120.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_139653120;
        // ---------- Original Method ----------
        //mBreadCrumbTitleRes = 0;
        //mBreadCrumbTitleText = text;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.060 -0400", hash_original_method = "F0E82E7069B2F6B7E25A71F53DDE4690", hash_generated_method = "9B51F5A68A03A909EF4C16F9F83B0D18")
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1656237220 = null; //Variable for return #1
        mBreadCrumbShortTitleRes = res;
        mBreadCrumbShortTitleText = null;
        varB4EAC82CA7396A68D541C85D26508E83_1656237220 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1656237220.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1656237220;
        // ---------- Original Method ----------
        //mBreadCrumbShortTitleRes = res;
        //mBreadCrumbShortTitleText = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.084 -0400", hash_original_method = "0432E2D3026F58B259B18084E0B71CFD", hash_generated_method = "C5F5047D8733215783187954148297F1")
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1167326385 = null; //Variable for return #1
        mBreadCrumbShortTitleRes = 0;
        mBreadCrumbShortTitleText = text;
        varB4EAC82CA7396A68D541C85D26508E83_1167326385 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1167326385.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1167326385;
        // ---------- Original Method ----------
        //mBreadCrumbShortTitleRes = 0;
        //mBreadCrumbShortTitleText = text;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.086 -0400", hash_original_method = "350B86C0CFAA72F059C15CB3FE1D993C", hash_generated_method = "1685EDD86D0373874AC89D29219639B5")
     void bumpBackStackNesting(int amt) {
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
        addTaint(amt);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.120 -0400", hash_original_method = "FD69B9F14C4FF1755ADA5F3EFF5DDDFB", hash_generated_method = "B50C457158FC23BBCE0DF3EEFF38B7F3")
    public int commit() {
        int varA4BCCB8ECB291B501D37CCD084E598C0_1147651327 = (commitInternal(false));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1667673997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1667673997;
        // ---------- Original Method ----------
        //return commitInternal(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.121 -0400", hash_original_method = "034B152615D8FC6D1FD7AD2899313AE6", hash_generated_method = "AE55C7CD8C83C3E0D5FE534A4FF4A760")
    public int commitAllowingStateLoss() {
        int varF7F203ED57B6AC8381E1DDB9CA29847A_2055340067 = (commitInternal(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926961792 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_926961792;
        // ---------- Original Method ----------
        //return commitInternal(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.144 -0400", hash_original_method = "9BF727F0CCA97F90C9847FCD006039C1", hash_generated_method = "DA5112B2AB5362259F30FD3A3160228B")
     int commitInternal(boolean allowStateLoss) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("commit already called");
        mCommitted = true;
        {
            mIndex = mManager.allocBackStackIndex(this);
        } //End block
        {
            mIndex = -1;
        } //End block
        mManager.enqueueAction(this, allowStateLoss);
        addTaint(allowStateLoss);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521401905 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_521401905;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.172 -0400", hash_original_method = "BA0CE442AF616D2BBAA3AAFEB295CD0F", hash_generated_method = "BA5353FF301B0096906F0777BD1E462F")
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
                        boolean var4043C011AEA95069BE526E5C0117EEF7_989693489 = (i<mManager.mAdded.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.237 -0400", hash_original_method = "7F72D15008964B0C744517E586063B58", hash_generated_method = "9D7E947808A1B187EA5EE24E273B460C")
    public void popFromBackStack(boolean doStateMove) {
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
                        boolean var0A487E0BD4FDD947920F1BEB18753DAE_51031600 = (i<op.removed.size());
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
        addTaint(doStateMove);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.260 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "DB367358751356F91A4E83715EB7E114")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1739745111 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1739745111 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1739745111.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1739745111;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.261 -0400", hash_original_method = "78EE7FB9A966094E1E15EEF50B50E3C9", hash_generated_method = "54417FF230F5E07F2B919BD051F7761F")
    public int getTransition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882020815 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_882020815;
        // ---------- Original Method ----------
        //return mTransition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.282 -0400", hash_original_method = "0B18827E69C997D5383C8EBB7663D372", hash_generated_method = "59F249E6BE7F7E2BAEB635D791B6A5AB")
    public int getTransitionStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309284087 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_309284087;
        // ---------- Original Method ----------
        //return mTransitionStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.287 -0400", hash_original_method = "98C448D4C76D2FE85810E0C03648865C", hash_generated_method = "6936BD014E3D2D144A494B39C17E5C52")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1415408080 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1415408080;
        // ---------- Original Method ----------
        //return mNumOp == 0;
    }

    
    static final class Op {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.287 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "19BBD1601EBAF334D6AA33231EED0715")

        Op next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.287 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "BE2B15E3DCB4E20F57C5AF9432510015")

        Op prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.288 -0400", hash_original_field = "DFFF0A7FA1A55C8C1A4966C19F6DA452", hash_generated_field = "CBDB20FE7C0EE51482970075935C6638")

        int cmd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.367 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "CC9B687FC89CACD9827C1873C7A34AB5")

        Fragment fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.368 -0400", hash_original_field = "0159D9295D9A3CEFA4170895BC7BC70E", hash_generated_field = "63F1115D3C1779EA5F8AD4A1D1B38EB9")

        int enterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.369 -0400", hash_original_field = "376904687D6BB69F30D31E2080308CB5", hash_generated_field = "7809ED21B1AF75421C6C97CB78F83727")

        int exitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.369 -0400", hash_original_field = "3FC2BE4EF1C699935A6EFD7681AE3C68", hash_generated_field = "D0892F22C301BA7A61E6684B7CEDEB8C")

        int popEnterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.370 -0400", hash_original_field = "9006F3166491A16FEAEEB97BE8123AE1", hash_generated_field = "E32555C71C839BAA1F67752555EB6938")

        int popExitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.375 -0400", hash_original_field = "B07286EBBB5BC7AA91CC3EAA8BC19711", hash_generated_field = "2CECA5CBA87C574F11C3FFA8F991583A")

        ArrayList<Fragment> removed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.376 -0400", hash_original_method = "D7B482A7C55CFA7077AB6D8147480F87", hash_generated_method = "D7B482A7C55CFA7077AB6D8147480F87")
        public Op ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.377 -0400", hash_original_field = "E66DE76B758EE031E85F28C8BFC50283", hash_generated_field = "B1A867007200E8963F1403DDC60687DB")

    static String TAG = "BackStackEntry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.377 -0400", hash_original_field = "513EEE12279766E0CBD0BA7281E878AA", hash_generated_field = "61CF9F3FA5BD227DC3DC28241D5B0CDD")

    static int OP_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.378 -0400", hash_original_field = "5634A5CA5E366F615FD0FD89F9A93C31", hash_generated_field = "869BC0DF162E28F336943C7A42A98554")

    static int OP_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.388 -0400", hash_original_field = "1D528934B0562AB0449E850942C5D85C", hash_generated_field = "6C755E5E8573AED494D4E25D7CD83191")

    static int OP_REPLACE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.389 -0400", hash_original_field = "7498D0EA6733EFC1AEDE214A6BEC06E6", hash_generated_field = "7AA6BB9BA0AD5153869BBB01668D1AC9")

    static int OP_REMOVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.389 -0400", hash_original_field = "4AC07D0DEBE4594EF69841578519CE01", hash_generated_field = "0D830E2C3F5D25BF4923719DF01979D9")

    static int OP_HIDE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.390 -0400", hash_original_field = "41B3AE08ACF3BA71D344049E3347E7D5", hash_generated_field = "038FFBB41A58273403176E6F977DFF19")

    static int OP_SHOW = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.390 -0400", hash_original_field = "FF1F5968DB58D39FBCF3A33AC9263A4F", hash_generated_field = "D4B2DA6E8C7A161538B5454256C5A3B4")

    static int OP_DETACH = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:36:48.391 -0400", hash_original_field = "B1990BA50ED499B0CE434058FF0651AE", hash_generated_field = "5072F83A0C580A909B3B147493B73028")

    static int OP_ATTACH = 7;
}

