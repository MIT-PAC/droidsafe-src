package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.LogWriter;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.553 -0400", hash_original_field = "B18521543B0A3F13E96EC9C4900EECCC", hash_generated_field = "DC6A1E8A42383143F0A42B30213419A5")

    int[] mOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.554 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.554 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.554 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.554 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.554 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.554 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.554 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.554 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.555 -0400", hash_original_method = "4BBDF5C1BE88EFC5591EA21365106208", hash_generated_method = "3D6A064676E44AE66A3658B813E8BEB4")
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
            mOps[pos++] = op.fragment != null ? op.fragment.mIndex : -1;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.555 -0400", hash_original_method = "B968D118C09EBADBAB257C64BF10EDFC", hash_generated_method = "2316B0F18A4F6F99AFA9D18FA79B9D5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.557 -0400", hash_original_method = "3011E3887D3FBBD9FDB38984C5139A67", hash_generated_method = "14C32AC0FF1F2BA905973A89548A66AF")
    public BackStackRecord instantiate(FragmentManagerImpl fm) {
        BackStackRecord varB4EAC82CA7396A68D541C85D26508E83_117681609 = null; 
        BackStackRecord bse = new BackStackRecord(fm);
        int pos = 0;
        int num = 0;
        {
            BackStackRecord.Op op = new BackStackRecord.Op();
            op.cmd = mOps[pos++];
            int findex = mOps[pos++];
            {
                Fragment f = fm.mActive.get(findex);
                op.fragment = f;
            } 
            {
                op.fragment = null;
            } 
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
        varB4EAC82CA7396A68D541C85D26508E83_117681609 = bse;
        addTaint(fm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_117681609.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_117681609;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.558 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7C952D4C4E90002A19986E1410463592")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002405707 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2002405707;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.558 -0400", hash_original_method = "541B83E53D4985674BDE186AC23E769C", hash_generated_method = "0522827BA0739F7A319A5711FF8AD49B")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.558 -0400", hash_original_field = "8B8CFB1C8824B4F8DAC46E032DB231EE", hash_generated_field = "FC56B3496DF6C62063CE25DEA3B38012")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "B6E40031C2D8257644CECE00AFE40458")

    FragmentManagerImpl mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "3910F709012F9D394BA43407D42AB0EC", hash_generated_field = "CAA200DE64F101586FA95F4FEC8429B1")

    Op mHead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "B2497DC9780B7282659AE377C47B70F1", hash_generated_field = "1DBFB57BC3C0C58F1CA989515A3C11B2")

    Op mTail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "FE7F5679DE5AB4EFCB7F73888C73482C", hash_generated_field = "7C2498E5F23A289A087BC718DE147927")

    int mNumOp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "1571B5D671DA2B5A71024C9969DA04AB", hash_generated_field = "25DA9A900AA8941601D4713D8643BCFF")

    int mEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "A64201543D48ED8DDD115D4151A3A908", hash_generated_field = "0403C21FF2E329089D303DA2F881AD65")

    int mExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "A606606C729A4D4BD754EB55FB1D92F2", hash_generated_field = "426B5FECE57930E7AC2A692D910E1B95")

    int mPopEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "48FF7BCE9BEDFB9C61D4EE16EAE35C46", hash_generated_field = "336F0E1CA15D2B7CFA7AB64448E9ABB4")

    int mPopExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "AB01F2F4FD691611940FB5D9DC3F4D9F", hash_generated_field = "6D620657E4B0D7E3BF4B4C9A3EA1860D")

    boolean mAddToBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "BEF2A6B0CCD60C687FB884F8E59C1EC3", hash_generated_field = "00D17B9289ED52FD64E1F76DBFE93EE5")

    boolean mAllowAddToBackStack = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "ECB201FF1883B37FDCC5CA9037698543", hash_generated_field = "34350BC5CB525FC021F5A246971120D8")

    boolean mCommitted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "DBDF7BB492A85A363C47FDDA34C5BB3E", hash_generated_field = "6B9186F1D8E9AA88F21C8B70F0B9BCC7")

    int mIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.559 -0400", hash_original_method = "8E110563CDFB79724FBA0799BF0D3C19", hash_generated_method = "222018A87C5C0AD32DB56B9265BCFEC3")
    public  BackStackRecord(FragmentManagerImpl manager) {
        mManager = manager;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.560 -0400", hash_original_method = "0F20E0B479CF0E65111306B7DA0E9ECF", hash_generated_method = "E534FBBC9E4379DB07E4666297E8DC83")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1361128536 = null; 
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        {
            sb.append(" #");
            sb.append(mIndex);
        } 
        {
            sb.append(" ");
            sb.append(mName);
        } 
        sb.append("}");
        varB4EAC82CA7396A68D541C85D26508E83_1361128536 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1361128536.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1361128536;
        
        
        
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.560 -0400", hash_original_method = "A173D988738B1BED0F12DBDA60D665B4", hash_generated_method = "43AC4FED1074F3C3447929A0B7A4C78C")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        dump(prefix, writer, true);
        addTaint(prefix.getTaint());
        addTaint(fd.getTaint());
        addTaint(writer.getTaint());
        addTaint(args[0].getTaint());
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.562 -0400", hash_original_method = "856C187C4078543C316E968949741777", hash_generated_method = "0285FF93C917367F681EBC9271D816F3")
    public void dump(String prefix, PrintWriter writer, boolean full) {
        {
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
        } 
        {
            writer.print(prefix);
            writer.println("Operations:");
            String innerPrefix = prefix + "    ";
            Op op = mHead;
            int num = 0;
            {
                String cmdStr;
                
                cmdStr="NULL";
                
                
                cmdStr="ADD";
                
                
                cmdStr="REPLACE";
                
                
                cmdStr="REMOVE";
                
                
                cmdStr="HIDE";
                
                
                cmdStr="SHOW";
                
                
                cmdStr="DETACH";
                
                
                cmdStr="ATTACH";
                
                
                cmdStr="cmd=" + op.cmd;
                
                writer.print(prefix);
                writer.print("  Op #");
                writer.print(num);
                writer.print(": ");
                writer.print(cmdStr);
                writer.print(" ");
                writer.println(op.fragment);
                {
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
                } 
                {
                    boolean varEDB78255635347BBB0E175782140D81C_881337891 = (op.removed != null && op.removed.size() > 0);
                    {
                        {
                            int i = 0;
                            boolean varFC8E7A96406C64F115442DF1E688D1EE_571309899 = (i<op.removed.size());
                            {
                                writer.print(innerPrefix);
                                {
                                    boolean var62D68A13440BF768A88904F93FC01D74_469494572 = (op.removed.size() == 1);
                                    {
                                        writer.print("Removed: ");
                                    } 
                                    {
                                        {
                                            writer.println("Removed:");
                                        } 
                                        writer.print(innerPrefix);
                                        writer.print("  #");
                                        writer.print(i);
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
        addTaint(writer.getTaint());
        addTaint(full);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.562 -0400", hash_original_method = "15A4A4C5F4518D2E82F335984591D8BA", hash_generated_method = "C3F4E2DD8844FF49309D7982D3489AE2")
    public int getId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116014907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_116014907;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.563 -0400", hash_original_method = "9339385C292A3B9874BA3EB436AA9056", hash_generated_method = "43CCC2C4F7140AFD2EE12E67ADDEBA18")
    public int getBreadCrumbTitleRes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003797545 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2003797545;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.563 -0400", hash_original_method = "D139A03B61A4B83382000704FB0C1F23", hash_generated_method = "89834E3798DFCFDEE82553F169D1F1F0")
    public int getBreadCrumbShortTitleRes() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178907736 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_178907736;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.564 -0400", hash_original_method = "C2C5B49D77ECFC3F06C4280D5C67187D", hash_generated_method = "F86219C5404CDEFFAB4FB8992D267FAD")
    public CharSequence getBreadCrumbTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2031780914 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1172653542 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2031780914 = mManager.mActivity.getText(mBreadCrumbTitleRes);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1172653542 = mBreadCrumbTitleText;
        CharSequence varA7E53CE21691AB073D9660D615818899_2076315378; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_2076315378 = varB4EAC82CA7396A68D541C85D26508E83_2031780914;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2076315378 = varB4EAC82CA7396A68D541C85D26508E83_1172653542;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2076315378.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_2076315378;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.564 -0400", hash_original_method = "CEC326312BE69049B0B2FA6420FE6494", hash_generated_method = "E8D5290F4F82637593AD085D9752B534")
    public CharSequence getBreadCrumbShortTitle() {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1402542303 = null; 
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_305879906 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1402542303 = mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_305879906 = mBreadCrumbShortTitleText;
        CharSequence varA7E53CE21691AB073D9660D615818899_1629215716; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1629215716 = varB4EAC82CA7396A68D541C85D26508E83_1402542303;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1629215716 = varB4EAC82CA7396A68D541C85D26508E83_305879906;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1629215716.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1629215716;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.565 -0400", hash_original_method = "32D26C73BB31A0FE5D5A21F02980CDDD", hash_generated_method = "CE7C17BEEFFEA12FE826AC8922B9C5B8")
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.565 -0400", hash_original_method = "C1E47B5485B0B08AA827320F8BD79938", hash_generated_method = "3927354840F1FB13AFE3DDA9828BCBFA")
    public FragmentTransaction add(Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_2132324906 = null; 
        doAddOp(0, fragment, tag, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_2132324906 = this;
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2132324906.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2132324906;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.566 -0400", hash_original_method = "F34A7243D750E416C8B46711401682C6", hash_generated_method = "9A818DD7213698962CFF1393E8CA747D")
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_836377674 = null; 
        doAddOp(containerViewId, fragment, null, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_836377674 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_836377674.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_836377674;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.567 -0400", hash_original_method = "DCEB5E0B408763C7F0E9A3376CBD91C3", hash_generated_method = "16F92F473CE5DE2F94014B16540B0A4C")
    public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_490276518 = null; 
        doAddOp(containerViewId, fragment, tag, OP_ADD);
        varB4EAC82CA7396A68D541C85D26508E83_490276518 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_490276518.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_490276518;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.568 -0400", hash_original_method = "F2F897C7BFD0AE6B1B051FF1D3DE8AB7", hash_generated_method = "A48157F3EF58F41A90DC4AAC07E1DCE8")
    private void doAddOp(int containerViewId, Fragment fragment, String tag, int opcmd) {
        fragment.mFragmentManager = mManager;
        {
            {
                boolean var61C8A6195E53C3C93A2D5BC238E04849_1203079037 = (fragment.mTag != null && !tag.equals(fragment.mTag));
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.571 -0400", hash_original_method = "095D291C1CAFD923EC9CB9BF06EF4676", hash_generated_method = "488C5F264DE720A019C7C60290FB53E3")
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1049381159 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1049381159 = replace(containerViewId, fragment, null);
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1049381159.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1049381159;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.572 -0400", hash_original_method = "1C07811E78071E2352BF0C170F6491CA", hash_generated_method = "EEEDFEC7CB784653CE0423D8206FB884")
    public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_586295788 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Must use non-zero containerViewId");
        } 
        doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        varB4EAC82CA7396A68D541C85D26508E83_586295788 = this;
        addTaint(containerViewId);
        addTaint(fragment.getTaint());
        addTaint(tag.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_586295788.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_586295788;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.572 -0400", hash_original_method = "33682B1B727BD924F48FE7F483A5C004", hash_generated_method = "9C345984067EC70D7D0273818F21AF28")
    public FragmentTransaction remove(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1700948859 = null; 
        Op op = new Op();
        op.cmd = OP_REMOVE;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_1700948859 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1700948859.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1700948859;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.572 -0400", hash_original_method = "AB9058E54F9496DA8E33E643603CB0C7", hash_generated_method = "3789389741EB8300219E3B425B33A337")
    public FragmentTransaction hide(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_177213694 = null; 
        Op op = new Op();
        op.cmd = OP_HIDE;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_177213694 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_177213694.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_177213694;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.573 -0400", hash_original_method = "2B6B1F1BD336D20AECF3763EE9DD5949", hash_generated_method = "E0190D8CA1FF683516A8A2471ED4FA78")
    public FragmentTransaction show(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_146740593 = null; 
        Op op = new Op();
        op.cmd = OP_SHOW;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_146740593 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_146740593.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_146740593;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.573 -0400", hash_original_method = "60B4979E5A31C92DF6F58D0AB0599A51", hash_generated_method = "D05D6DF3D852BC8C2D96A1B2FA42C2A7")
    public FragmentTransaction detach(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_805169762 = null; 
        Op op = new Op();
        op.cmd = OP_DETACH;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_805169762 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_805169762.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_805169762;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.574 -0400", hash_original_method = "71B1C0469F9D1680729415A070BB9988", hash_generated_method = "54706991E00AF428935F949EC61BEA51")
    public FragmentTransaction attach(Fragment fragment) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_158514897 = null; 
        Op op = new Op();
        op.cmd = OP_ATTACH;
        op.fragment = fragment;
        addOp(op);
        varB4EAC82CA7396A68D541C85D26508E83_158514897 = this;
        addTaint(fragment.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_158514897.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_158514897;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.574 -0400", hash_original_method = "E8FBC41447C7F5B20E8F08F3A2F7FD58", hash_generated_method = "2B6C336D4C73B2B38B4CC3E3EEE4FAE5")
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1847015222 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1847015222 = setCustomAnimations(enter, exit, 0, 0);
        addTaint(enter);
        addTaint(exit);
        varB4EAC82CA7396A68D541C85D26508E83_1847015222.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1847015222;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.575 -0400", hash_original_method = "A0614C8D91A2CFFC3B2827B585934661", hash_generated_method = "53F117CC12E72F9A64FDA0F93A2B4FCD")
    public FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1040582365 = null; 
        mEnterAnim = enter;
        mExitAnim = exit;
        mPopEnterAnim = popEnter;
        mPopExitAnim = popExit;
        varB4EAC82CA7396A68D541C85D26508E83_1040582365 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1040582365.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1040582365;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.575 -0400", hash_original_method = "A455FB052D79EC1710E986C50AD0D972", hash_generated_method = "1B6EB51EF78D6778F79CC8168550EE58")
    public FragmentTransaction setTransition(int transition) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1601810057 = null; 
        mTransition = transition;
        varB4EAC82CA7396A68D541C85D26508E83_1601810057 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1601810057.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1601810057;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.576 -0400", hash_original_method = "A33CAFCA32BB4FD1A454655E75F4B6CB", hash_generated_method = "20CD4C7721D669AFBDF3925EA3AF3610")
    public FragmentTransaction setTransitionStyle(int styleRes) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_2086932406 = null; 
        mTransitionStyle = styleRes;
        varB4EAC82CA7396A68D541C85D26508E83_2086932406 = this;
        varB4EAC82CA7396A68D541C85D26508E83_2086932406.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2086932406;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.576 -0400", hash_original_method = "438624ACF19A9F6511A0E99CD6264659", hash_generated_method = "09CCB94C6D2199E670F892C24AE71BEF")
    public FragmentTransaction addToBackStack(String name) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_380021851 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This FragmentTransaction is not allowed to be added to the back stack.");
        } 
        mAddToBackStack = true;
        mName = name;
        varB4EAC82CA7396A68D541C85D26508E83_380021851 = this;
        varB4EAC82CA7396A68D541C85D26508E83_380021851.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_380021851;
        
        
            
                    
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.577 -0400", hash_original_method = "6063A0768FB0FF8A9BC1A0D5BDF7E352", hash_generated_method = "3CAE7FFC4E38CBE39B67FF6C997BE3B3")
    public boolean isAddToBackStackAllowed() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2073546458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2073546458;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.577 -0400", hash_original_method = "FA98892FC811CB8446B86919ACA0FBBA", hash_generated_method = "F3782EB0ADB5BB26F0A9A3D824854D4D")
    public FragmentTransaction disallowAddToBackStack() {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_490671200 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "This transaction is already being added to the back stack");
        } 
        mAllowAddToBackStack = false;
        varB4EAC82CA7396A68D541C85D26508E83_490671200 = this;
        varB4EAC82CA7396A68D541C85D26508E83_490671200.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_490671200;
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.578 -0400", hash_original_method = "3ED721B4C54764795D085FCDFAF2CFED", hash_generated_method = "3E437FE329451DEC0F87512B70092217")
    public FragmentTransaction setBreadCrumbTitle(int res) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1640171654 = null; 
        mBreadCrumbTitleRes = res;
        mBreadCrumbTitleText = null;
        varB4EAC82CA7396A68D541C85D26508E83_1640171654 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1640171654.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1640171654;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.579 -0400", hash_original_method = "27CB0DA08C946E1C367250B9E9010CF2", hash_generated_method = "D897DBBF5404B983A49D56E24477C563")
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_723714316 = null; 
        mBreadCrumbTitleRes = 0;
        mBreadCrumbTitleText = text;
        varB4EAC82CA7396A68D541C85D26508E83_723714316 = this;
        varB4EAC82CA7396A68D541C85D26508E83_723714316.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_723714316;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.580 -0400", hash_original_method = "F0E82E7069B2F6B7E25A71F53DDE4690", hash_generated_method = "282EF1F55BBF460031AF1FD5CDC6C550")
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1346983178 = null; 
        mBreadCrumbShortTitleRes = res;
        mBreadCrumbShortTitleText = null;
        varB4EAC82CA7396A68D541C85D26508E83_1346983178 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1346983178.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1346983178;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.580 -0400", hash_original_method = "0432E2D3026F58B259B18084E0B71CFD", hash_generated_method = "13B7829616286DF5009DB733FC1B4AA5")
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        FragmentTransaction varB4EAC82CA7396A68D541C85D26508E83_1698952289 = null; 
        mBreadCrumbShortTitleRes = 0;
        mBreadCrumbShortTitleText = text;
        varB4EAC82CA7396A68D541C85D26508E83_1698952289 = this;
        varB4EAC82CA7396A68D541C85D26508E83_1698952289.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1698952289;
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.581 -0400", hash_original_method = "F09A90C496A148F600E3D02A9731BC19", hash_generated_method = "3E167B4580A2092826C96F6BA634716F")
     void bumpBackStackNesting(int amt) {
        Op op = mHead;
        {
            {
                op.fragment.mBackStackNesting += amt;
            } 
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.581 -0400", hash_original_method = "FD69B9F14C4FF1755ADA5F3EFF5DDDFB", hash_generated_method = "14E2F075AAD6A1ED42389EA59C65188C")
    public int commit() {
        int varA4BCCB8ECB291B501D37CCD084E598C0_1734968754 = (commitInternal(false));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1743225335 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1743225335;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.582 -0400", hash_original_method = "034B152615D8FC6D1FD7AD2899313AE6", hash_generated_method = "6B74C806CB3BAABC5353768A17963E20")
    public int commitAllowingStateLoss() {
        int varF7F203ED57B6AC8381E1DDB9CA29847A_29647124 = (commitInternal(true));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658182667 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658182667;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.582 -0400", hash_original_method = "01D779364E83C28A30DD99CF6E54EB38", hash_generated_method = "8982AFD2B748AE618F66781031B7AAB1")
     int commitInternal(boolean allowStateLoss) {
        if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("commit already called");
        {
            LogWriter logw = new LogWriter(TAG);
            PrintWriter pw = new PrintWriter(logw);
            dump("  ", null, pw, null);
        } 
        mCommitted = true;
        {
            mIndex = mManager.allocBackStackIndex(this);
        } 
        {
            mIndex = -1;
        } 
        mManager.enqueueAction(this, allowStateLoss);
        addTaint(allowStateLoss);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_15551683 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_15551683;
        
        
        
            
            
            
            
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.583 -0400", hash_original_method = "F2F4246724AFA2458C4148B16BF6293A", hash_generated_method = "2824EB39DF79767F5615CA9D815596B6")
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
                        boolean var4043C011AEA95069BE526E5C0117EEF7_1265303124 = (i<mManager.mAdded.size());
                        {
                            Fragment old = mManager.mAdded.get(i);
                            {
                                {
                                    op.fragment = f = null;
                                } 
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
                } 
                {
                    f.mNextAnim = op.enterAnim;
                    mManager.addFragment(f, false);
                } 
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.584 -0400", hash_original_method = "137917E20FC9A3B18E2DEEE98195320E", hash_generated_method = "22292F15CB8F629CFA6F7713005DC348")
    public void popFromBackStack(boolean doStateMove) {
        {
            LogWriter logw = new LogWriter(TAG);
            PrintWriter pw = new PrintWriter(logw);
            dump("  ", null, pw, null);
        } 
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
                {
                    f.mNextAnim = op.popExitAnim;
                    mManager.removeFragment(f,
                                FragmentManagerImpl.reverseTransit(mTransition),
                                mTransitionStyle);
                } 
                {
                    {
                        int i = 0;
                        boolean var0A487E0BD4FDD947920F1BEB18753DAE_1432449608 = (i<op.removed.size());
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
                f.mNextAnim = op.popEnterAnim;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.585 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "A536D214A9B8C9784FB8C889B120EC69")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_167673757 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_167673757 = mName;
        varB4EAC82CA7396A68D541C85D26508E83_167673757.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_167673757;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.585 -0400", hash_original_method = "78EE7FB9A966094E1E15EEF50B50E3C9", hash_generated_method = "0D5D1CA740AD3AECCA3F43569F8D3941")
    public int getTransition() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263784076 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_263784076;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.585 -0400", hash_original_method = "0B18827E69C997D5383C8EBB7663D372", hash_generated_method = "2D23425F968C3201A454944FD8D61D1A")
    public int getTransitionStyle() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565297479 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_565297479;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_method = "98C448D4C76D2FE85810E0C03648865C", hash_generated_method = "D9243D87EBE9661BBEDAB762087324D1")
    public boolean isEmpty() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_779888349 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_779888349;
        
        
    }

    
    static final class Op {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "19BBD1601EBAF334D6AA33231EED0715")

        Op next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "BE2B15E3DCB4E20F57C5AF9432510015")

        Op prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "DFFF0A7FA1A55C8C1A4966C19F6DA452", hash_generated_field = "CBDB20FE7C0EE51482970075935C6638")

        int cmd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "CC9B687FC89CACD9827C1873C7A34AB5")

        Fragment fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "0159D9295D9A3CEFA4170895BC7BC70E", hash_generated_field = "63F1115D3C1779EA5F8AD4A1D1B38EB9")

        int enterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "376904687D6BB69F30D31E2080308CB5", hash_generated_field = "7809ED21B1AF75421C6C97CB78F83727")

        int exitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "3FC2BE4EF1C699935A6EFD7681AE3C68", hash_generated_field = "D0892F22C301BA7A61E6684B7CEDEB8C")

        int popEnterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "9006F3166491A16FEAEEB97BE8123AE1", hash_generated_field = "E32555C71C839BAA1F67752555EB6938")

        int popExitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "B07286EBBB5BC7AA91CC3EAA8BC19711", hash_generated_field = "2CECA5CBA87C574F11C3FFA8F991583A")

        ArrayList<Fragment> removed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_method = "D7B482A7C55CFA7077AB6D8147480F87", hash_generated_method = "D7B482A7C55CFA7077AB6D8147480F87")
        public Op ()
        {
            
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "A0234DA5470FDA669977BD858FDBA8F4", hash_generated_field = "60BD3437D9A30501FC86E00816D25257")

    static final String TAG = FragmentManagerImpl.TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "513EEE12279766E0CBD0BA7281E878AA", hash_generated_field = "3C725A5D9DEF53B7FBA369B6031C0114")

    static final int OP_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "5634A5CA5E366F615FD0FD89F9A93C31", hash_generated_field = "D476F834444990BAEEB054A4C302249A")

    static final int OP_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "1D528934B0562AB0449E850942C5D85C", hash_generated_field = "3C4AC3DDA904059CE1649C7DA113A694")

    static final int OP_REPLACE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "7498D0EA6733EFC1AEDE214A6BEC06E6", hash_generated_field = "5D1FE84F46A8710BCAAB63F7836D62F7")

    static final int OP_REMOVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "4AC07D0DEBE4594EF69841578519CE01", hash_generated_field = "C6957BDFCD9D33DF33819EDBB2E9C30D")

    static final int OP_HIDE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "41B3AE08ACF3BA71D344049E3347E7D5", hash_generated_field = "AC2408B061BD12E29767B40B4F69C217")

    static final int OP_SHOW = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "FF1F5968DB58D39FBCF3A33AC9263A4F", hash_generated_field = "FECBA6AE06903F8549AFADF78F9ACEE7")

    static final int OP_DETACH = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:45.586 -0400", hash_original_field = "B1990BA50ED499B0CE434058FF0651AE", hash_generated_field = "BEA53C6640501A26A1D92C01B94C35E1")

    static final int OP_ATTACH = 7;
}

