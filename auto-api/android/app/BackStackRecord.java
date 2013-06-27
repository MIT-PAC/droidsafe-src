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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.728 -0400", hash_original_field = "B18521543B0A3F13E96EC9C4900EECCC", hash_generated_field = "DC6A1E8A42383143F0A42B30213419A5")

    int[] mOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.741 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.741 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.742 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.742 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.743 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.743 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.756 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.757 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.800 -0400", hash_original_method = "DCE5061D40CBE6F430759A7A23E4D4F8", hash_generated_method = "4056D36982CB216FDE54547CE3E29AC8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.834 -0400", hash_original_method = "B968D118C09EBADBAB257C64BF10EDFC", hash_generated_method = "2316B0F18A4F6F99AFA9D18FA79B9D5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.899 -0400", hash_original_method = "F8D54BF837A015C95DFB9CC70933C9DB", hash_generated_method = "EAFCC991DAF124A1ED621E0EC64F3741")
    public BackStackRecord instantiate(FragmentManagerImpl fm) {
        BackStackRecord varB4EAC82CA7396A68D541C85D26508E83_118861114 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_118861114 = bse;
        addTaint(fm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_118861114.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_118861114;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.909 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "9E9E2A7E24340059525E4448B9EEAD09")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445474140 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1445474140;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.943 -0400", hash_original_method = "541B83E53D4985674BDE186AC23E769C", hash_generated_method = "0522827BA0739F7A319A5711FF8AD49B")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.945 -0400", hash_original_field = "8B8CFB1C8824B4F8DAC46E032DB231EE", hash_generated_field = "FC56B3496DF6C62063CE25DEA3B38012")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.947 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "B6E40031C2D8257644CECE00AFE40458")

    FragmentManagerImpl mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.961 -0400", hash_original_field = "3910F709012F9D394BA43407D42AB0EC", hash_generated_field = "CAA200DE64F101586FA95F4FEC8429B1")

    Op mHead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.962 -0400", hash_original_field = "B2497DC9780B7282659AE377C47B70F1", hash_generated_field = "1DBFB57BC3C0C58F1CA989515A3C11B2")

    Op mTail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.962 -0400", hash_original_field = "FE7F5679DE5AB4EFCB7F73888C73482C", hash_generated_field = "7C2498E5F23A289A087BC718DE147927")

    int mNumOp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.963 -0400", hash_original_field = "1571B5D671DA2B5A71024C9969DA04AB", hash_generated_field = "25DA9A900AA8941601D4713D8643BCFF")

    int mEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.963 -0400", hash_original_field = "A64201543D48ED8DDD115D4151A3A908", hash_generated_field = "0403C21FF2E329089D303DA2F881AD65")

    int mExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.977 -0400", hash_original_field = "A606606C729A4D4BD754EB55FB1D92F2", hash_generated_field = "426B5FECE57930E7AC2A692D910E1B95")

    int mPopEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.978 -0400", hash_original_field = "48FF7BCE9BEDFB9C61D4EE16EAE35C46", hash_generated_field = "336F0E1CA15D2B7CFA7AB64448E9ABB4")

    int mPopExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.978 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.979 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.980 -0400", hash_original_field = "AB01F2F4FD691611940FB5D9DC3F4D9F", hash_generated_field = "6D620657E4B0D7E3BF4B4C9A3EA1860D")

    boolean mAddToBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.980 -0400", hash_original_field = "BEF2A6B0CCD60C687FB884F8E59C1EC3", hash_generated_field = "00D17B9289ED52FD64E1F76DBFE93EE5")

    boolean mAllowAddToBackStack = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.997 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.997 -0400", hash_original_field = "ECB201FF1883B37FDCC5CA9037698543", hash_generated_field = "34350BC5CB525FC021F5A246971120D8")

    boolean mCommitted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.997 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:44.998 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.005 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.013 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.014 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.023 -0400", hash_original_method = "8E110563CDFB79724FBA0799BF0D3C19", hash_generated_method = "222018A87C5C0AD32DB56B9265BCFEC3")
    public  BackStackRecord(FragmentManagerImpl manager) {
        mManager = manager;
        // ---------- Original Method ----------
        //mManager = manager;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.100 -0400", hash_original_method = "D2AEC534E855FE50C82F3A186CF8CD83", hash_generated_method = "296B79224ED57A8D6DD6C25865950540")
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
                    boolean varEDB78255635347BBB0E175782140D81C_434611683 = (op.removed != null && op.removed.size() > 0);
                    {
                        {
                            int i;
                            i = 0;
                            boolean varFC8E7A96406C64F115442DF1E688D1EE_1872688829 = (i<op.removed.size());
                            {
                                writer.print(innerPrefix);
                                {
                                    boolean var62D68A13440BF768A88904F93FC01D74_9579017 = (op.removed.size() == 1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.103 -0400", hash_original_method = "15A4A4C5F4518D2E82F335984591D8BA", hash_generated_method = "AE70201A827AD2553894FC694BAB486A")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_772542986 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_772542986;
        // ---------- Original Method ----------
        //return mIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.114 -0400", hash_original_method = "9339385C292A3B9874BA3EB436AA9056", hash_generated_method = "17A738F6747001796FB773006128F734")
    public int getBreadCrumbTitleRes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952520545 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1952520545;
        // ---------- Original Method ----------
        //return mBreadCrumbTitleRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.116 -0400", hash_original_method = "D139A03B61A4B83382000704FB0C1F23", hash_generated_method = "5EE1C9133AFF6CBEDE196B7AA49578AB")
    public int getBreadCrumbShortTitleRes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456587692 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456587692;
        // ---------- Original Method ----------
        //return mBreadCrumbShortTitleRes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.139 -0400", hash_original_method = "C2C5B49D77ECFC3F06C4280D5C67187D", hash_generated_method = "D05E47857CC6EA83DD6506B5ECAE381D")
    public CharSequence getBreadCrumbTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1270667586 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_120207586 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1270667586 = mManager.mActivity.getText(mBreadCrumbTitleRes);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_120207586 = mBreadCrumbTitleText;
        CharSequence varA7E53CE21691AB073D9660D615818899_2060735148; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2060735148 = varB4EAC82CA7396A68D541C85D26508E83_1270667586;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2060735148 = varB4EAC82CA7396A68D541C85D26508E83_120207586;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2060735148.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2060735148;
        // ---------- Original Method ----------
        //if (mBreadCrumbTitleRes != 0) {
            //return mManager.mActivity.getText(mBreadCrumbTitleRes);
        //}
        //return mBreadCrumbTitleText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.149 -0400", hash_original_method = "CEC326312BE69049B0B2FA6420FE6494", hash_generated_method = "875C626B491924AB1FBC6DB8D8175102")
    public CharSequence getBreadCrumbShortTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_683880383 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1508856437 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_683880383 = mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1508856437 = mBreadCrumbShortTitleText;
        CharSequence varA7E53CE21691AB073D9660D615818899_456465169; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_456465169 = varB4EAC82CA7396A68D541C85D26508E83_683880383;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_456465169 = varB4EAC82CA7396A68D541C85D26508E83_1508856437;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_456465169.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_456465169;
        // ---------- Original Method ----------
        //if (mBreadCrumbShortTitleRes != 0) {
            //return mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        //}
        //return mBreadCrumbShortTitleText;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.170 -0400", hash_original_method = "32D26C73BB31A0FE5D5A21F02980CDDD", hash_generated_method = "CE7C17BEEFFEA12FE826AC8922B9C5B8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.181 -0400", hash_original_method = "C1E47B5485B0B08AA827320F8BD79938", hash_generated_method = "12A7D54EDD947B85860436F82A8CEF9D")
    public FragmentTransaction add(Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_760071673 = null; //Variable for return #1
        doAddOp(0, fragment, tag, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_760071673 = this;
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_760071673.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_760071673;
        // ---------- Original Method ----------
        //doAddOp(0, fragment, tag, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.193 -0400", hash_original_method = "F34A7243D750E416C8B46711401682C6", hash_generated_method = "F096533F3D7FEB7EFD858954CC3B0A39")
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_752609460 = null; //Variable for return #1
        doAddOp(containerViewId, fragment, null, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_752609460 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_752609460.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_752609460;
        // ---------- Original Method ----------
        //doAddOp(containerViewId, fragment, null, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.207 -0400", hash_original_method = "DCEB5E0B408763C7F0E9A3376CBD91C3", hash_generated_method = "7220E9CF3D793D3C7BDA063486922FD6")
    public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1375768462 = null; //Variable for return #1
        doAddOp(containerViewId, fragment, tag, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_1375768462 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1375768462.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1375768462;
        // ---------- Original Method ----------
        //doAddOp(containerViewId, fragment, tag, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.297 -0400", hash_original_method = "F2F897C7BFD0AE6B1B051FF1D3DE8AB7", hash_generated_method = "657B7F585759D863C9E2D5374719AC47")
    private void doAddOp(int containerViewId, Fragment fragment, String tag, int opcmd) {
        fragment.mFragmentManager = mManager;
        {
            {
                boolean var61C8A6195E53C3C93A2D5BC238E04849_221186336 = (fragment.mTag != null && !tag.equals(fragment.mTag));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.323 -0400", hash_original_method = "095D291C1CAFD923EC9CB9BF06EF4676", hash_generated_method = "ECB62BAE353EBD20FED971333C60EC2D")
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_328542832 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_328542832 = replace(containerViewId, fragment, null);
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_328542832.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_328542832;
        // ---------- Original Method ----------
        //return replace(containerViewId, fragment, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.328 -0400", hash_original_method = "1C07811E78071E2352BF0C170F6491CA", hash_generated_method = "E6EF6D10ED551B5023C9A29B17251333")
    public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_822573010 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must use non-zero containerViewId");
        } //End block
        doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        varB4EAC82CA7396A68D541C85D26508E83_822573010 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_822573010.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_822573010;
        // ---------- Original Method ----------
        //if (containerViewId == 0) {
            //throw new IllegalArgumentException("Must use non-zero containerViewId");
        //}
        //doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.339 -0400", hash_original_method = "33682B1B727BD924F48FE7F483A5C004", hash_generated_method = "74A13B32957368D7B398FB849556B5FE")
    public FragmentTransaction remove(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1968004504 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_REMOVE;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_1968004504 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1968004504.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1968004504;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_REMOVE;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.362 -0400", hash_original_method = "AB9058E54F9496DA8E33E643603CB0C7", hash_generated_method = "66D691AB489EEB164BA08114B7454F74")
    public FragmentTransaction hide(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1604656890 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_HIDE;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_1604656890 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1604656890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1604656890;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_HIDE;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.379 -0400", hash_original_method = "2B6B1F1BD336D20AECF3763EE9DD5949", hash_generated_method = "F9CFB668CBB2343ED9CA8D8F7D52ED0E")
    public FragmentTransaction show(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1977668932 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_SHOW;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_1977668932 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1977668932.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1977668932;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_SHOW;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.393 -0400", hash_original_method = "60B4979E5A31C92DF6F58D0AB0599A51", hash_generated_method = "323D48BF26EA68F98453323EFFBBDFE3")
    public FragmentTransaction detach(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1512557005 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_DETACH;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_1512557005 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1512557005.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1512557005;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_DETACH;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.412 -0400", hash_original_method = "71B1C0469F9D1680729415A070BB9988", hash_generated_method = "A548C2552DADB50066A01EE607BD0D53")
    public FragmentTransaction attach(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_416880208 = null; //Variable for return #1
        Op op;
        op = new Op();
        op.cmd = OP_ATTACH;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_416880208 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_416880208.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_416880208;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_ATTACH;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.441 -0400", hash_original_method = "E8FBC41447C7F5B20E8F08F3A2F7FD58", hash_generated_method = "420D5E2C22CA7C99D350D83032221940")
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1689019369 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1689019369 = setCustomAnimations(enter, exit, 0, 0);
        addTaint(enter);
        addTaint(exit);
        varB4EAC82CA7396A68D541C85D26508E83_1689019369.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1689019369;
        // ---------- Original Method ----------
        //return setCustomAnimations(enter, exit, 0, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.462 -0400", hash_original_method = "A0614C8D91A2CFFC3B2827B585934661", hash_generated_method = "DB608F7D328535B0FD255F4A837497DF")
    public FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_412961463 = null; //Variable for return #1
        mEnterAnim = enter;
        mExitAnim = exit;
        mPopEnterAnim = popEnter;
        mPopExitAnim = popExit;
        varB4EAC82CA7396A68D541C85D26508E83_412961463 = this;
        varB4EAC82CA7396A68D541C85D26508E83_412961463.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_412961463;
        // ---------- Original Method ----------
        //mEnterAnim = enter;
        //mExitAnim = exit;
        //mPopEnterAnim = popEnter;
        //mPopExitAnim = popExit;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.477 -0400", hash_original_method = "A455FB052D79EC1710E986C50AD0D972", hash_generated_method = "2D5F3CD6FDABD2A0FCE97742BAE7AFFA")
    public FragmentTransaction setTransition(int transition) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_309366733 = null; //Variable for return #1
        mTransition = transition;
        varB4EAC82CA7396A68D541C85D26508E83_309366733 = this;
        varB4EAC82CA7396A68D541C85D26508E83_309366733.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_309366733;
        // ---------- Original Method ----------
        //mTransition = transition;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.490 -0400", hash_original_method = "A33CAFCA32BB4FD1A454655E75F4B6CB", hash_generated_method = "3D850A7B7C389E7EB274F12BB09179C4")
    public FragmentTransaction setTransitionStyle(int styleRes) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_994067585 = null; //Variable for return #1
        mTransitionStyle = styleRes;
        varB4EAC82CA7396A68D541C85D26508E83_994067585 = this;
        varB4EAC82CA7396A68D541C85D26508E83_994067585.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_994067585;
        // ---------- Original Method ----------
        //mTransitionStyle = styleRes;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.514 -0400", hash_original_method = "438624ACF19A9F6511A0E99CD6264659", hash_generated_method = "518B620A3DC295578C7791FB6CC751F9")
    public FragmentTransaction addToBackStack(String name) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1336698343 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This FragmentTransaction is not allowed to be added to the back stack.");
        } //End block
        mAddToBackStack = true;
        mName = name;
        varB4EAC82CA7396A68D541C85D26508E83_1336698343 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1336698343.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1336698343;
        // ---------- Original Method ----------
        //if (!mAllowAddToBackStack) {
            //throw new IllegalStateException(
                    //"This FragmentTransaction is not allowed to be added to the back stack.");
        //}
        //mAddToBackStack = true;
        //mName = name;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.516 -0400", hash_original_method = "6063A0768FB0FF8A9BC1A0D5BDF7E352", hash_generated_method = "9B413D83C4AD1377F2B23B2F9AF9EB74")
    public boolean isAddToBackStackAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1074098669 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1074098669;
        // ---------- Original Method ----------
        //return mAllowAddToBackStack;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.518 -0400", hash_original_method = "FA98892FC811CB8446B86919ACA0FBBA", hash_generated_method = "75195F6698E78F0F6E5A736080EB0950")
    public FragmentTransaction disallowAddToBackStack() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_557953278 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This transaction is already being added to the back stack");
        } //End block
        mAllowAddToBackStack = false;
        varB4EAC82CA7396A68D541C85D26508E83_557953278 = this;
        varB4EAC82CA7396A68D541C85D26508E83_557953278.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_557953278;
        // ---------- Original Method ----------
        //if (mAddToBackStack) {
            //throw new IllegalStateException(
                    //"This transaction is already being added to the back stack");
        //}
        //mAllowAddToBackStack = false;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.549 -0400", hash_original_method = "3ED721B4C54764795D085FCDFAF2CFED", hash_generated_method = "204C2AA1DA0872ECB78A64157A33C885")
    public FragmentTransaction setBreadCrumbTitle(int res) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1427823375 = null; //Variable for return #1
        mBreadCrumbTitleRes = res;
        mBreadCrumbTitleText = null;
        varB4EAC82CA7396A68D541C85D26508E83_1427823375 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1427823375.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1427823375;
        // ---------- Original Method ----------
        //mBreadCrumbTitleRes = res;
        //mBreadCrumbTitleText = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.555 -0400", hash_original_method = "27CB0DA08C946E1C367250B9E9010CF2", hash_generated_method = "F3CC4C27EEF76BB360F419B4761760D8")
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1515191543 = null; //Variable for return #1
        mBreadCrumbTitleRes = 0;
        mBreadCrumbTitleText = text;
        varB4EAC82CA7396A68D541C85D26508E83_1515191543 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1515191543.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1515191543;
        // ---------- Original Method ----------
        //mBreadCrumbTitleRes = 0;
        //mBreadCrumbTitleText = text;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.572 -0400", hash_original_method = "F0E82E7069B2F6B7E25A71F53DDE4690", hash_generated_method = "C948D75E1805B0B77E9403D861EAAAC8")
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1144446280 = null; //Variable for return #1
        mBreadCrumbShortTitleRes = res;
        mBreadCrumbShortTitleText = null;
        varB4EAC82CA7396A68D541C85D26508E83_1144446280 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1144446280.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1144446280;
        // ---------- Original Method ----------
        //mBreadCrumbShortTitleRes = res;
        //mBreadCrumbShortTitleText = null;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.608 -0400", hash_original_method = "0432E2D3026F58B259B18084E0B71CFD", hash_generated_method = "BDE707AF8F8E689CA7FCF2588E275DE3")
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_333408703 = null; //Variable for return #1
        mBreadCrumbShortTitleRes = 0;
        mBreadCrumbShortTitleText = text;
        varB4EAC82CA7396A68D541C85D26508E83_333408703 = this;
        varB4EAC82CA7396A68D541C85D26508E83_333408703.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_333408703;
        // ---------- Original Method ----------
        //mBreadCrumbShortTitleRes = 0;
        //mBreadCrumbShortTitleText = text;
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.636 -0400", hash_original_method = "350B86C0CFAA72F059C15CB3FE1D993C", hash_generated_method = "1685EDD86D0373874AC89D29219639B5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.657 -0400", hash_original_method = "FD69B9F14C4FF1755ADA5F3EFF5DDDFB", hash_generated_method = "A00420A9DD3626AC91ED842D93C97267")
    public int commit() {
        int varA4BCCB8ECB291B501D37CCD084E598C0_2026356233 = (commitInternal(false));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355860215 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355860215;
        // ---------- Original Method ----------
        //return commitInternal(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.659 -0400", hash_original_method = "034B152615D8FC6D1FD7AD2899313AE6", hash_generated_method = "91DF6D2964467B73E2F88AA1E2C3634D")
    public int commitAllowingStateLoss() {
        int varF7F203ED57B6AC8381E1DDB9CA29847A_1303709678 = (commitInternal(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190099852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1190099852;
        // ---------- Original Method ----------
        //return commitInternal(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.669 -0400", hash_original_method = "9BF727F0CCA97F90C9847FCD006039C1", hash_generated_method = "FDD5FA34AECBD6E92E3191938A37DDDC")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598774540 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1598774540;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.728 -0400", hash_original_method = "BA0CE442AF616D2BBAA3AAFEB295CD0F", hash_generated_method = "410F0697952D9C52DD94B7CBA213CE10")
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
                        boolean var4043C011AEA95069BE526E5C0117EEF7_1786172597 = (i<mManager.mAdded.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.785 -0400", hash_original_method = "7F72D15008964B0C744517E586063B58", hash_generated_method = "E022A7F65555238C3D8D94DB571C6FD7")
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
                        boolean var0A487E0BD4FDD947920F1BEB18753DAE_1695105917 = (i<op.removed.size());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.810 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "EF3D87A82FC63228AE36AB70D9C63527")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1932127266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1932127266 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_1932127266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1932127266;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.818 -0400", hash_original_method = "78EE7FB9A966094E1E15EEF50B50E3C9", hash_generated_method = "7302D1242FCF5813A970F92F103D85AA")
    public int getTransition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164298945 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_164298945;
        // ---------- Original Method ----------
        //return mTransition;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.820 -0400", hash_original_method = "0B18827E69C997D5383C8EBB7663D372", hash_generated_method = "0486A83E7F29B81224F9DDD78120CF57")
    public int getTransitionStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450953484 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1450953484;
        // ---------- Original Method ----------
        //return mTransitionStyle;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.822 -0400", hash_original_method = "98C448D4C76D2FE85810E0C03648865C", hash_generated_method = "8CA5A94727CE12F2F1FEDD2997209067")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1103686155 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1103686155;
        // ---------- Original Method ----------
        //return mNumOp == 0;
    }

    
    static final class Op {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.837 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "19BBD1601EBAF334D6AA33231EED0715")

        Op next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.838 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "BE2B15E3DCB4E20F57C5AF9432510015")

        Op prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.838 -0400", hash_original_field = "DFFF0A7FA1A55C8C1A4966C19F6DA452", hash_generated_field = "CBDB20FE7C0EE51482970075935C6638")

        int cmd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.839 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "CC9B687FC89CACD9827C1873C7A34AB5")

        Fragment fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.840 -0400", hash_original_field = "0159D9295D9A3CEFA4170895BC7BC70E", hash_generated_field = "63F1115D3C1779EA5F8AD4A1D1B38EB9")

        int enterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.856 -0400", hash_original_field = "376904687D6BB69F30D31E2080308CB5", hash_generated_field = "7809ED21B1AF75421C6C97CB78F83727")

        int exitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.857 -0400", hash_original_field = "3FC2BE4EF1C699935A6EFD7681AE3C68", hash_generated_field = "D0892F22C301BA7A61E6684B7CEDEB8C")

        int popEnterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.857 -0400", hash_original_field = "9006F3166491A16FEAEEB97BE8123AE1", hash_generated_field = "E32555C71C839BAA1F67752555EB6938")

        int popExitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.868 -0400", hash_original_field = "B07286EBBB5BC7AA91CC3EAA8BC19711", hash_generated_field = "2CECA5CBA87C574F11C3FFA8F991583A")

        ArrayList<Fragment> removed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.868 -0400", hash_original_method = "D7B482A7C55CFA7077AB6D8147480F87", hash_generated_method = "D7B482A7C55CFA7077AB6D8147480F87")
        public Op ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.869 -0400", hash_original_field = "E66DE76B758EE031E85F28C8BFC50283", hash_generated_field = "B1A867007200E8963F1403DDC60687DB")

    static String TAG = "BackStackEntry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.869 -0400", hash_original_field = "513EEE12279766E0CBD0BA7281E878AA", hash_generated_field = "61CF9F3FA5BD227DC3DC28241D5B0CDD")

    static int OP_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.879 -0400", hash_original_field = "5634A5CA5E366F615FD0FD89F9A93C31", hash_generated_field = "869BC0DF162E28F336943C7A42A98554")

    static int OP_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.879 -0400", hash_original_field = "1D528934B0562AB0449E850942C5D85C", hash_generated_field = "6C755E5E8573AED494D4E25D7CD83191")

    static int OP_REPLACE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.880 -0400", hash_original_field = "7498D0EA6733EFC1AEDE214A6BEC06E6", hash_generated_field = "7AA6BB9BA0AD5153869BBB01668D1AC9")

    static int OP_REMOVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.880 -0400", hash_original_field = "4AC07D0DEBE4594EF69841578519CE01", hash_generated_field = "0D830E2C3F5D25BF4923719DF01979D9")

    static int OP_HIDE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.894 -0400", hash_original_field = "41B3AE08ACF3BA71D344049E3347E7D5", hash_generated_field = "038FFBB41A58273403176E6F977DFF19")

    static int OP_SHOW = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.894 -0400", hash_original_field = "FF1F5968DB58D39FBCF3A33AC9263A4F", hash_generated_field = "D4B2DA6E8C7A161538B5454256C5A3B4")

    static int OP_DETACH = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:45.895 -0400", hash_original_field = "B1990BA50ED499B0CE434058FF0651AE", hash_generated_field = "5072F83A0C580A909B3B147493B73028")

    static int OP_ATTACH = 7;
}

