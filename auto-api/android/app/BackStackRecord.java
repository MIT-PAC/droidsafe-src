package android.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.901 -0400", hash_original_field = "B18521543B0A3F13E96EC9C4900EECCC", hash_generated_field = "DC6A1E8A42383143F0A42B30213419A5")

    int[] mOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.901 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.901 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.901 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.901 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.901 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.901 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.901 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.902 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.903 -0400", hash_original_method = "DCE5061D40CBE6F430759A7A23E4D4F8", hash_generated_method = "1F65E613B110045FF99191CEC30A0E0D")
    public  BackStackState(FragmentManagerImpl fm, BackStackRecord bse) {
        int numRemoved = 0;
        BackStackRecord.Op op = bse.mHead;
        {
            numRemoved += op.removed.size();
            op = op.next;
        } 
        mOps = new int[bse.mNumOp*7 + numRemoved];
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Not on back stack");
        } 
        op = bse.mHead;
        int pos = 0;
        {
            mOps[pos++] = op.cmd;
            mOps[pos++] = op.fragment.mIndex;
            mOps[pos++] = op.enterAnim;
            mOps[pos++] = op.exitAnim;
            mOps[pos++] = op.popEnterAnim;
            mOps[pos++] = op.popExitAnim;
            {
                final int N = op.removed.size();
                mOps[pos++] = N;
                {
                    int i = 0;
                    {
                        mOps[pos++] = op.removed.get(i).mIndex;
                    } 
                } 
            } 
            {
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
        addTaint(fm.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.904 -0400", hash_original_method = "B968D118C09EBADBAB257C64BF10EDFC", hash_generated_method = "2316B0F18A4F6F99AFA9D18FA79B9D5D")
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
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.907 -0400", hash_original_method = "F8D54BF837A015C95DFB9CC70933C9DB", hash_generated_method = "A7195FF39E9B8A0AA250364CD65EF419")
    public BackStackRecord instantiate(FragmentManagerImpl fm) {
        BackStackRecord varB4EAC82CA7396A68D541C85D26508E83_2090493320 = null; 
        BackStackRecord bse = new BackStackRecord(fm);
        int pos = 0;
        {
            BackStackRecord.Op op = new BackStackRecord.Op();
            op.cmd = mOps[pos++];
            Fragment f = fm.mActive.get(mOps[pos++]);
            op.fragment = f;
            op.enterAnim = mOps[pos++];
            op.exitAnim = mOps[pos++];
            op.popEnterAnim = mOps[pos++];
            op.popExitAnim = mOps[pos++];
            final int N = mOps[pos++];
            {
                op.removed = new ArrayList<Fragment>(N);
                {
                    int i = 0;
                    {
                        Fragment r = fm.mActive.get(mOps[pos++]);
                        op.removed.add(r);
                    } 
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
        varB4EAC82CA7396A68D541C85D26508E83_2090493320 = bse;
        addTaint(fm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2090493320.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2090493320;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.907 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "55AE95F2EE5E278746170C88FE1FDDF9")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229598302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_229598302;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.908 -0400", hash_original_method = "541B83E53D4985674BDE186AC23E769C", hash_generated_method = "0522827BA0739F7A319A5711FF8AD49B")
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
        
        
        
        
        
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.908 -0400", hash_original_field = "8B8CFB1C8824B4F8DAC46E032DB231EE", hash_generated_field = "FC56B3496DF6C62063CE25DEA3B38012")

    public static final Parcelable.Creator<BackStackState> CREATOR
            = new Parcelable.Creator<BackStackState>() {
        public BackStackState createFromParcel(Parcel in) {
            return new BackStackState(in);
        }

        public BackStackState[] newArray(int size) {
            return new BackStackState[size];
        }
    };
    
    public BackStackState createFromParcel(Parcel in) {
            return new BackStackState(in);
        }
    
    
    public BackStackState[] newArray(int size) {
            return new BackStackState[size];
        }
    
}

final class BackStackRecord extends FragmentTransaction implements FragmentManager.BackStackEntry, Runnable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.909 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "B6E40031C2D8257644CECE00AFE40458")

    FragmentManagerImpl mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.909 -0400", hash_original_field = "3910F709012F9D394BA43407D42AB0EC", hash_generated_field = "CAA200DE64F101586FA95F4FEC8429B1")

    Op mHead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.909 -0400", hash_original_field = "B2497DC9780B7282659AE377C47B70F1", hash_generated_field = "1DBFB57BC3C0C58F1CA989515A3C11B2")

    Op mTail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.909 -0400", hash_original_field = "FE7F5679DE5AB4EFCB7F73888C73482C", hash_generated_field = "7C2498E5F23A289A087BC718DE147927")

    int mNumOp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.909 -0400", hash_original_field = "1571B5D671DA2B5A71024C9969DA04AB", hash_generated_field = "25DA9A900AA8941601D4713D8643BCFF")

    int mEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.909 -0400", hash_original_field = "A64201543D48ED8DDD115D4151A3A908", hash_generated_field = "0403C21FF2E329089D303DA2F881AD65")

    int mExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.909 -0400", hash_original_field = "A606606C729A4D4BD754EB55FB1D92F2", hash_generated_field = "426B5FECE57930E7AC2A692D910E1B95")

    int mPopEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.909 -0400", hash_original_field = "48FF7BCE9BEDFB9C61D4EE16EAE35C46", hash_generated_field = "336F0E1CA15D2B7CFA7AB64448E9ABB4")

    int mPopExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.910 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.910 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.910 -0400", hash_original_field = "AB01F2F4FD691611940FB5D9DC3F4D9F", hash_generated_field = "6D620657E4B0D7E3BF4B4C9A3EA1860D")

    boolean mAddToBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.910 -0400", hash_original_field = "BEF2A6B0CCD60C687FB884F8E59C1EC3", hash_generated_field = "00D17B9289ED52FD64E1F76DBFE93EE5")

    boolean mAllowAddToBackStack = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.910 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.910 -0400", hash_original_field = "ECB201FF1883B37FDCC5CA9037698543", hash_generated_field = "34350BC5CB525FC021F5A246971120D8")

    boolean mCommitted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.910 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.910 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.910 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.911 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.911 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.911 -0400", hash_original_method = "8E110563CDFB79724FBA0799BF0D3C19", hash_generated_method = "222018A87C5C0AD32DB56B9265BCFEC3")
    public  BackStackRecord(FragmentManagerImpl manager) {
        mManager = manager;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.913 -0400", hash_original_method = "D2AEC534E855FE50C82F3A186CF8CD83", hash_generated_method = "D738606A537FE27B7F4749C8B5AE19B6")
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
        } 
        {
            writer.print(prefix);
            writer.print("mEnterAnim=#");
            writer.print(Integer.toHexString(mEnterAnim));
            writer.print(" mExitAnim=#");
            writer.println(Integer.toHexString(mExitAnim));
        } 
        {
            writer.print(prefix);
            writer.print("mPopEnterAnim=#");
            writer.print(Integer.toHexString(mPopEnterAnim));
            writer.print(" mPopExitAnim=#");
            writer.println(Integer.toHexString(mPopExitAnim));
        } 
        {
            writer.print(prefix);
            writer.print("mBreadCrumbTitleRes=#");
            writer.print(Integer.toHexString(mBreadCrumbTitleRes));
            writer.print(" mBreadCrumbTitleText=");
            writer.println(mBreadCrumbTitleText);
        } 
        {
            writer.print(prefix);
            writer.print("mBreadCrumbShortTitleRes=#");
            writer.print(Integer.toHexString(mBreadCrumbShortTitleRes));
            writer.print(" mBreadCrumbShortTitleText=");
            writer.println(mBreadCrumbShortTitleText);
        } 
        {
            writer.print(prefix);
            writer.println("Operations:");
            String innerPrefix = prefix + "    ";
            Op op = mHead;
            int num = 0;
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
                } 
                {
                    writer.print(prefix);
                    writer.print("popEnterAnim=#");
                    writer.print(Integer.toHexString(op.popEnterAnim));
                    writer.print(" popExitAnim=#");
                    writer.println(Integer.toHexString(op.popExitAnim));
                } 
                {
                    boolean varEDB78255635347BBB0E175782140D81C_142779209 = (op.removed != null && op.removed.size() > 0);
                    {
                        {
                            int i = 0;
                            boolean varFC8E7A96406C64F115442DF1E688D1EE_187683953 = (i<op.removed.size());
                            {
                                writer.print(innerPrefix);
                                {
                                    boolean var62D68A13440BF768A88904F93FC01D74_356186119 = (op.removed.size() == 1);
                                    {
                                        writer.print("Removed: ");
                                    } 
                                    {
                                        writer.println("Removed:");
                                        writer.print(innerPrefix);
                                        writer.print("  #");
                                        writer.print(num);
                                        writer.print(": ");
                                    } 
                                } 
                                writer.println(op.removed.get(i));
                            } 
                        } 
                    } 
                } 
                op = op.next;
            } 
        } 
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.914 -0400", hash_original_method = "15A4A4C5F4518D2E82F335984591D8BA", hash_generated_method = "020B1B0B2A8CD224458EC8E929CDC79A")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339464090 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_339464090;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.914 -0400", hash_original_method = "9339385C292A3B9874BA3EB436AA9056", hash_generated_method = "54FD9504178048FC47ED45CD152FCD49")
    public int getBreadCrumbTitleRes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941703829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1941703829;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.915 -0400", hash_original_method = "D139A03B61A4B83382000704FB0C1F23", hash_generated_method = "D41A814768B2A83DAFCCA53BE7B78CC8")
    public int getBreadCrumbShortTitleRes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43992722 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_43992722;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.916 -0400", hash_original_method = "C2C5B49D77ECFC3F06C4280D5C67187D", hash_generated_method = "CD0942FB5DE8208941C8F3FF68FCEB54")
    public CharSequence getBreadCrumbTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1297876317 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_791954943 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1297876317 = mManager.mActivity.getText(mBreadCrumbTitleRes);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_791954943 = mBreadCrumbTitleText;
        CharSequence varA7E53CE21691AB073D9660D615818899_241786214; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_241786214 = varB4EAC82CA7396A68D541C85D26508E83_1297876317;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_241786214 = varB4EAC82CA7396A68D541C85D26508E83_791954943;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_241786214.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_241786214;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.919 -0400", hash_original_method = "CEC326312BE69049B0B2FA6420FE6494", hash_generated_method = "C6DEE75F9AE0C5D61A575C18360954BA")
    public CharSequence getBreadCrumbShortTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_207432090 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_765201236 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_207432090 = mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_765201236 = mBreadCrumbShortTitleText;
        CharSequence varA7E53CE21691AB073D9660D615818899_1410715196; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1410715196 = varB4EAC82CA7396A68D541C85D26508E83_207432090;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1410715196 = varB4EAC82CA7396A68D541C85D26508E83_765201236;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1410715196.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1410715196;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.920 -0400", hash_original_method = "32D26C73BB31A0FE5D5A21F02980CDDD", hash_generated_method = "CE7C17BEEFFEA12FE826AC8922B9C5B8")
     void addOp(Op op) {
        {
            mHead = mTail = op;
        } 
        {
            op.prev = mTail;
            mTail.next = op;
            mTail = op;
        } 
        op.enterAnim = mEnterAnim;
        op.exitAnim = mExitAnim;
        op.popEnterAnim = mPopEnterAnim;
        op.popExitAnim = mPopExitAnim;
        
        
            
        
            
            
            
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.922 -0400", hash_original_method = "C1E47B5485B0B08AA827320F8BD79938", hash_generated_method = "06062CA78795DBB76279E186F5A89008")
    public FragmentTransaction add(Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1863569908 = null; 
        doAddOp(0, fragment, tag, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_1863569908 = this;
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1863569908.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1863569908;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.922 -0400", hash_original_method = "F34A7243D750E416C8B46711401682C6", hash_generated_method = "F13C050ACD2A885DDEE20A103F015E04")
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1127595244 = null; 
        doAddOp(containerViewId, fragment, null, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_1127595244 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1127595244.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1127595244;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.923 -0400", hash_original_method = "DCEB5E0B408763C7F0E9A3376CBD91C3", hash_generated_method = "1962D5FFB9D779E683916970F1D654A8")
    public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1578757810 = null; 
        doAddOp(containerViewId, fragment, tag, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_1578757810 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1578757810.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1578757810;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.925 -0400", hash_original_method = "F2F897C7BFD0AE6B1B051FF1D3DE8AB7", hash_generated_method = "AE812949DC2FD5EBF6ACEDBE58A3817C")
    private void doAddOp(int containerViewId, Fragment fragment, String tag, int opcmd) {
        fragment.mFragmentManager = mManager;
        {
            {
                boolean var61C8A6195E53C3C93A2D5BC238E04849_1160692537 = (fragment.mTag != null && !tag.equals(fragment.mTag));
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can't change tag of fragment "
                        + fragment + ": was " + fragment.mTag
                        + " now " + tag);
                } 
            } 
            fragment.mTag = tag;
        } 
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("Can't change container ID of fragment "
                        + fragment + ": was " + fragment.mFragmentId
                        + " now " + containerViewId);
            } 
            fragment.mContainerId = fragment.mFragmentId = containerViewId;
        } 
        Op op = new Op();
        op.cmd = opcmd;
        op.fragment = fragment;
        addOp(op);
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        addTaint(opcmd);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.926 -0400", hash_original_method = "095D291C1CAFD923EC9CB9BF06EF4676", hash_generated_method = "09497A3A6CFE29DBCD000A778CF59C26")
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1909709271 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1909709271 = replace(containerViewId, fragment, null);
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1909709271.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1909709271;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.930 -0400", hash_original_method = "1C07811E78071E2352BF0C170F6491CA", hash_generated_method = "7C04D02E1A9116A6948406F96E50D25A")
    public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1397500017 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must use non-zero containerViewId");
        } 
        doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        varB4EAC82CA7396A68D541C85D26508E83_1397500017 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1397500017.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1397500017;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.931 -0400", hash_original_method = "33682B1B727BD924F48FE7F483A5C004", hash_generated_method = "25C8ACD25C523FF3BD3B0F8EC6DE6850")
    public FragmentTransaction remove(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_220590926 = null; 
        Op op = new Op();
        op.cmd = OP_REMOVE;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_220590926 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_220590926.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_220590926;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.933 -0400", hash_original_method = "AB9058E54F9496DA8E33E643603CB0C7", hash_generated_method = "DD39CB54A891D1EA4F2716CB0E8E7089")
    public FragmentTransaction hide(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1853705909 = null; 
        Op op = new Op();
        op.cmd = OP_HIDE;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_1853705909 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1853705909.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1853705909;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.934 -0400", hash_original_method = "2B6B1F1BD336D20AECF3763EE9DD5949", hash_generated_method = "B02C8B1AD43FB734E426520F57DAA6C2")
    public FragmentTransaction show(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_2012757337 = null; 
        Op op = new Op();
        op.cmd = OP_SHOW;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_2012757337 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2012757337.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2012757337;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.935 -0400", hash_original_method = "60B4979E5A31C92DF6F58D0AB0599A51", hash_generated_method = "3445514D50DFDA3561731A392BB22082")
    public FragmentTransaction detach(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1488340757 = null; 
        Op op = new Op();
        op.cmd = OP_DETACH;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_1488340757 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1488340757.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1488340757;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.938 -0400", hash_original_method = "71B1C0469F9D1680729415A070BB9988", hash_generated_method = "7FE6A788AD9B1CAC1AB1593C63A83C9A")
    public FragmentTransaction attach(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1270987965 = null; 
        Op op = new Op();
        op.cmd = OP_ATTACH;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_1270987965 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1270987965.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1270987965;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.940 -0400", hash_original_method = "E8FBC41447C7F5B20E8F08F3A2F7FD58", hash_generated_method = "32CF0945A94E89AF9AFA9B0B70AB8AF0")
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_161556616 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_161556616 = setCustomAnimations(enter, exit, 0, 0);
        addTaint(enter);
        addTaint(exit);
        varB4EAC82CA7396A68D541C85D26508E83_161556616.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_161556616;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.941 -0400", hash_original_method = "A0614C8D91A2CFFC3B2827B585934661", hash_generated_method = "D6556A620997FCBB3D089CFE4E58D285")
    public FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1959285494 = null; 
        mEnterAnim = enter;
        mExitAnim = exit;
        mPopEnterAnim = popEnter;
        mPopExitAnim = popExit;
        varB4EAC82CA7396A68D541C85D26508E83_1959285494 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1959285494.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1959285494;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.942 -0400", hash_original_method = "A455FB052D79EC1710E986C50AD0D972", hash_generated_method = "E00B3ACC33893D2904C2199318E051D6")
    public FragmentTransaction setTransition(int transition) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1841901252 = null; 
        mTransition = transition;
        varB4EAC82CA7396A68D541C85D26508E83_1841901252 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1841901252.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1841901252;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.943 -0400", hash_original_method = "A33CAFCA32BB4FD1A454655E75F4B6CB", hash_generated_method = "2BB9CC14569BAB88ABC1B004A71E7DCB")
    public FragmentTransaction setTransitionStyle(int styleRes) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1407507910 = null; 
        mTransitionStyle = styleRes;
        varB4EAC82CA7396A68D541C85D26508E83_1407507910 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1407507910.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1407507910;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.945 -0400", hash_original_method = "438624ACF19A9F6511A0E99CD6264659", hash_generated_method = "EA3EF74D2BAFA616C0F92A67EAD8B8C3")
    public FragmentTransaction addToBackStack(String name) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1977394391 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This FragmentTransaction is not allowed to be added to the back stack.");
        } 
        mAddToBackStack = true;
        mName = name;
        varB4EAC82CA7396A68D541C85D26508E83_1977394391 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1977394391.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1977394391;
        
        
            
                    
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.946 -0400", hash_original_method = "6063A0768FB0FF8A9BC1A0D5BDF7E352", hash_generated_method = "DCD037A4B28EA77B8E5D211D7B02E754")
    public boolean isAddToBackStackAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_160941668 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_160941668;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.948 -0400", hash_original_method = "FA98892FC811CB8446B86919ACA0FBBA", hash_generated_method = "28F447506E7C1376B4B2756F6A4EB24A")
    public FragmentTransaction disallowAddToBackStack() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1489121672 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This transaction is already being added to the back stack");
        } 
        mAllowAddToBackStack = false;
        varB4EAC82CA7396A68D541C85D26508E83_1489121672 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1489121672.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1489121672;
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.950 -0400", hash_original_method = "3ED721B4C54764795D085FCDFAF2CFED", hash_generated_method = "F509C56887C06090CFC45486A0775DCE")
    public FragmentTransaction setBreadCrumbTitle(int res) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_106312973 = null; 
        mBreadCrumbTitleRes = res;
        mBreadCrumbTitleText = null;
        varB4EAC82CA7396A68D541C85D26508E83_106312973 = this;
        varB4EAC82CA7396A68D541C85D26508E83_106312973.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_106312973;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.951 -0400", hash_original_method = "27CB0DA08C946E1C367250B9E9010CF2", hash_generated_method = "E9B3E47B6C456A52DAA7CAA5079D1B5C")
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_859864290 = null; 
        mBreadCrumbTitleRes = 0;
        mBreadCrumbTitleText = text;
        varB4EAC82CA7396A68D541C85D26508E83_859864290 = this;
        varB4EAC82CA7396A68D541C85D26508E83_859864290.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_859864290;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.952 -0400", hash_original_method = "F0E82E7069B2F6B7E25A71F53DDE4690", hash_generated_method = "2B9822BFD28CFECCFE4581BFD5F8B121")
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_729063908 = null; 
        mBreadCrumbShortTitleRes = res;
        mBreadCrumbShortTitleText = null;
        varB4EAC82CA7396A68D541C85D26508E83_729063908 = this;
        varB4EAC82CA7396A68D541C85D26508E83_729063908.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_729063908;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.953 -0400", hash_original_method = "0432E2D3026F58B259B18084E0B71CFD", hash_generated_method = "7E9D55B0351CE7B0269CCA9B7EB6AE71")
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_695784844 = null; 
        mBreadCrumbShortTitleRes = 0;
        mBreadCrumbShortTitleText = text;
        varB4EAC82CA7396A68D541C85D26508E83_695784844 = this;
        varB4EAC82CA7396A68D541C85D26508E83_695784844.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_695784844;
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.954 -0400", hash_original_method = "350B86C0CFAA72F059C15CB3FE1D993C", hash_generated_method = "478422F3C20F6BE1F1160C350C8B5A25")
     void bumpBackStackNesting(int amt) {
        Op op = mHead;
        {
            op.fragment.mBackStackNesting += amt;
            {
                {
                    int i = op.removed.size()-1;
                    {
                        Fragment r = op.removed.get(i);
                        r.mBackStackNesting += amt;
                    } 
                } 
            } 
            op = op.next;
        } 
        addTaint(amt);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.955 -0400", hash_original_method = "FD69B9F14C4FF1755ADA5F3EFF5DDDFB", hash_generated_method = "9EE58A771815F9064B4E8C583FF995BB")
    public int commit() {
        int varA4BCCB8ECB291B501D37CCD084E598C0_1008009150 = (commitInternal(false));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740778913 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1740778913;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.956 -0400", hash_original_method = "034B152615D8FC6D1FD7AD2899313AE6", hash_generated_method = "330BB4BB3926EA390F9DF4EB9A52EEDC")
    public int commitAllowingStateLoss() {
        int varF7F203ED57B6AC8381E1DDB9CA29847A_1873343438 = (commitInternal(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659497064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_659497064;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.957 -0400", hash_original_method = "9BF727F0CCA97F90C9847FCD006039C1", hash_generated_method = "5B54D21F7D5E4AC75BAFEC4C844F0EE9")
     int commitInternal(boolean allowStateLoss) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("commit already called");
        mCommitted = true;
        {
            mIndex = mManager.allocBackStackIndex(this);
        } 
        {
            mIndex = -1;
        } 
        mManager.enqueueAction(this, allowStateLoss);
        addTaint(allowStateLoss);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029851861 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1029851861;
        
        
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.959 -0400", hash_original_method = "BA0CE442AF616D2BBAA3AAFEB295CD0F", hash_generated_method = "B05C782F80F5D3C791C05DED0A253799")
    public void run() {
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("addToBackStack() called after commit()");
            } 
        } 
        bumpBackStackNesting(1);
        Op op = mHead;
        {
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.addFragment(f, false);
            } 
            
            
            {
                Fragment f = op.fragment;
                {
                    {
                        int i = 0;
                        boolean var4043C011AEA95069BE526E5C0117EEF7_2009139714 = (i<mManager.mAdded.size());
                        {
                            Fragment old = mManager.mAdded.get(i);
                            {
                                {
                                    op.removed = new ArrayList<Fragment>();
                                } 
                                op.removed.add(old);
                                old.mNextAnim = op.exitAnim;
                                {
                                    old.mBackStackNesting += 1;
                                } 
                                mManager.removeFragment(old, mTransition, mTransitionStyle);
                            } 
                        } 
                    } 
                } 
                f.mNextAnim = op.enterAnim;
                mManager.addFragment(f, false);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.removeFragment(f, mTransition, mTransitionStyle);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.hideFragment(f, mTransition, mTransitionStyle);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.showFragment(f, mTransition, mTransitionStyle);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.detachFragment(f, mTransition, mTransitionStyle);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.attachFragment(f, mTransition, mTransitionStyle);
            } 
            
            
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
            } 
            
            op = op.next;
        } 
        mManager.moveToState(mManager.mCurState, mTransition,
                mTransitionStyle, true);
        {
            mManager.addBackStackState(this);
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.961 -0400", hash_original_method = "7F72D15008964B0C744517E586063B58", hash_generated_method = "3176EBC2CFC9CD3C8B2F18B9302713A0")
    public void popFromBackStack(boolean doStateMove) {
        bumpBackStackNesting(-1);
        Op op = mTail;
        {
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.removeFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition),
                            mTransitionStyle);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.removeFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition),
                            mTransitionStyle);
                {
                    {
                        int i = 0;
                        boolean var0A487E0BD4FDD947920F1BEB18753DAE_72874043 = (i<op.removed.size());
                        {
                            Fragment old = op.removed.get(i);
                            old.mNextAnim = op.popEnterAnim;
                            mManager.addFragment(old, false);
                        } 
                    } 
                } 
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.addFragment(f, false);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.showFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.hideFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.attachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } 
            
            
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.detachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } 
            
            
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Unknown cmd: " + op.cmd);
            } 
            
            op = op.prev;
        } 
        {
            mManager.moveToState(mManager.mCurState,
                    FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle, true);
        } 
        {
            mManager.freeBackStackIndex(mIndex);
            mIndex = -1;
        } 
        addTaint(doStateMove);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.962 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "2878F5ED8A2A2E71D5185665C61EFA0E")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_72484855 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_72484855 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_72484855.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_72484855;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.962 -0400", hash_original_method = "78EE7FB9A966094E1E15EEF50B50E3C9", hash_generated_method = "6BBEDC5AEBE568EC7AD19561D21B754A")
    public int getTransition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024092473 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1024092473;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.963 -0400", hash_original_method = "0B18827E69C997D5383C8EBB7663D372", hash_generated_method = "C4F410CF5AE0DD1C829DE46CB024E8E2")
    public int getTransitionStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004256561 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1004256561;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.963 -0400", hash_original_method = "98C448D4C76D2FE85810E0C03648865C", hash_generated_method = "82462FEECF07D929CE61689B5A1B1F69")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1328943548 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1328943548;
        
        
    }

    
    static final class Op {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.963 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "19BBD1601EBAF334D6AA33231EED0715")

        Op next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.963 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "BE2B15E3DCB4E20F57C5AF9432510015")

        Op prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.964 -0400", hash_original_field = "DFFF0A7FA1A55C8C1A4966C19F6DA452", hash_generated_field = "CBDB20FE7C0EE51482970075935C6638")

        int cmd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.964 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "CC9B687FC89CACD9827C1873C7A34AB5")

        Fragment fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.964 -0400", hash_original_field = "0159D9295D9A3CEFA4170895BC7BC70E", hash_generated_field = "63F1115D3C1779EA5F8AD4A1D1B38EB9")

        int enterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.964 -0400", hash_original_field = "376904687D6BB69F30D31E2080308CB5", hash_generated_field = "7809ED21B1AF75421C6C97CB78F83727")

        int exitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.964 -0400", hash_original_field = "3FC2BE4EF1C699935A6EFD7681AE3C68", hash_generated_field = "D0892F22C301BA7A61E6684B7CEDEB8C")

        int popEnterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.964 -0400", hash_original_field = "9006F3166491A16FEAEEB97BE8123AE1", hash_generated_field = "E32555C71C839BAA1F67752555EB6938")

        int popExitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.964 -0400", hash_original_field = "B07286EBBB5BC7AA91CC3EAA8BC19711", hash_generated_field = "2CECA5CBA87C574F11C3FFA8F991583A")

        ArrayList<Fragment> removed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.964 -0400", hash_original_method = "D7B482A7C55CFA7077AB6D8147480F87", hash_generated_method = "D7B482A7C55CFA7077AB6D8147480F87")
        public Op ()
        {
            
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.965 -0400", hash_original_field = "E66DE76B758EE031E85F28C8BFC50283", hash_generated_field = "583E47895BFA5D844AD0AE16F53E746D")

    static final String TAG = "BackStackEntry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.965 -0400", hash_original_field = "513EEE12279766E0CBD0BA7281E878AA", hash_generated_field = "3C725A5D9DEF53B7FBA369B6031C0114")

    static final int OP_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.965 -0400", hash_original_field = "5634A5CA5E366F615FD0FD89F9A93C31", hash_generated_field = "D476F834444990BAEEB054A4C302249A")

    static final int OP_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.965 -0400", hash_original_field = "1D528934B0562AB0449E850942C5D85C", hash_generated_field = "3C4AC3DDA904059CE1649C7DA113A694")

    static final int OP_REPLACE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.965 -0400", hash_original_field = "7498D0EA6733EFC1AEDE214A6BEC06E6", hash_generated_field = "5D1FE84F46A8710BCAAB63F7836D62F7")

    static final int OP_REMOVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.965 -0400", hash_original_field = "4AC07D0DEBE4594EF69841578519CE01", hash_generated_field = "C6957BDFCD9D33DF33819EDBB2E9C30D")

    static final int OP_HIDE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.965 -0400", hash_original_field = "41B3AE08ACF3BA71D344049E3347E7D5", hash_generated_field = "AC2408B061BD12E29767B40B4F69C217")

    static final int OP_SHOW = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.965 -0400", hash_original_field = "FF1F5968DB58D39FBCF3A33AC9263A4F", hash_generated_field = "FECBA6AE06903F8549AFADF78F9ACEE7")

    static final int OP_DETACH = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:16.966 -0400", hash_original_field = "B1990BA50ED499B0CE434058FF0651AE", hash_generated_field = "BEA53C6640501A26A1D92C01B94C35E1")

    static final int OP_ATTACH = 7;
}

