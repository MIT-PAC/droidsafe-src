package android.support.v4.app;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.util.LogWriter;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.937 -0400", hash_original_field = "B18521543B0A3F13E96EC9C4900EECCC", hash_generated_field = "DC6A1E8A42383143F0A42B30213419A5")

    int[] mOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.937 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.937 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.937 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.937 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.937 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.937 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.937 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.937 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.939 -0400", hash_original_method = "4BBDF5C1BE88EFC5591EA21365106208", hash_generated_method = "88EDE1F133466C324D37F1F28AD9D45C")
    public  BackStackState(FragmentManagerImpl fm, BackStackRecord bse) {
        addTaint(fm.getTaint());
        int numRemoved = 0;
        BackStackRecord.Op op = bse.mHead;
        while
(op != null)        
        {
    if(op.removed != null)            
            numRemoved += op.removed.size();
            op = op.next;
        } 
        mOps = new int[bse.mNumOp*7 + numRemoved];
    if(!bse.mAddToBackStack)        
        {
            IllegalStateException var314CBE014D5D2C8AD5652051EFBCF4AC_330648529 = new IllegalStateException("Not on back stack");
            var314CBE014D5D2C8AD5652051EFBCF4AC_330648529.addTaint(taint);
            throw var314CBE014D5D2C8AD5652051EFBCF4AC_330648529;
        } 
        op = bse.mHead;
        int pos = 0;
        while
(op != null)        
        {
            mOps[pos++] = op.cmd;
            mOps[pos++] = op.fragment != null ? op.fragment.mIndex : -1;
            mOps[pos++] = op.enterAnim;
            mOps[pos++] = op.exitAnim;
            mOps[pos++] = op.popEnterAnim;
            mOps[pos++] = op.popExitAnim;
    if(op.removed != null)            
            {
                final int N = op.removed.size();
                mOps[pos++] = N;
for(int i=0;i<N;i++)
                {
                    mOps[pos++] = op.removed.get(i).mIndex;
                } 
            } 
            else
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
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.940 -0400", hash_original_method = "B968D118C09EBADBAB257C64BF10EDFC", hash_generated_method = "2316B0F18A4F6F99AFA9D18FA79B9D5D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.941 -0400", hash_original_method = "3011E3887D3FBBD9FDB38984C5139A67", hash_generated_method = "4BD81B82E2999CF0003DB8DEB4160775")
    public BackStackRecord instantiate(FragmentManagerImpl fm) {
        addTaint(fm.getTaint());
        BackStackRecord bse = new BackStackRecord(fm);
        int pos = 0;
        int num = 0;
        while
(pos < mOps.length)        
        {
            BackStackRecord.Op op = new BackStackRecord.Op();
            op.cmd = mOps[pos++];
    if(FragmentManagerImpl.DEBUG){ }            int findex = mOps[pos++];
    if(findex >= 0)            
            {
                Fragment f = fm.mActive.get(findex);
                op.fragment = f;
            } 
            else
            {
                op.fragment = null;
            } 
            op.enterAnim = mOps[pos++];
            op.exitAnim = mOps[pos++];
            op.popEnterAnim = mOps[pos++];
            op.popExitAnim = mOps[pos++];
            final int N = mOps[pos++];
    if(N > 0)            
            {
                op.removed = new ArrayList<Fragment>(N);
for(int i=0;i<N;i++)
                {
    if(FragmentManagerImpl.DEBUG){ }                    Fragment r = fm.mActive.get(mOps[pos++]);
                    op.removed.add(r);
                } 
            } 
            bse.addOp(op);
            num++;
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
BackStackRecord varF02DDB74F3AB452E2C7DEEBC20BFE154_1016471008 =         bse;
        varF02DDB74F3AB452E2C7DEEBC20BFE154_1016471008.addTaint(taint);
        return varF02DDB74F3AB452E2C7DEEBC20BFE154_1016471008;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.942 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "636324A776B9EE436377F6B7CD268D2F")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_951597221 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313237302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1313237302;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.942 -0400", hash_original_method = "541B83E53D4985674BDE186AC23E769C", hash_generated_method = "6763825E0CFB1671364D8608AE888EA8")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.942 -0400", hash_original_field = "8B8CFB1C8824B4F8DAC46E032DB231EE", hash_generated_field = "FC56B3496DF6C62063CE25DEA3B38012")

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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.943 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "B6E40031C2D8257644CECE00AFE40458")

    FragmentManagerImpl mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.943 -0400", hash_original_field = "3910F709012F9D394BA43407D42AB0EC", hash_generated_field = "CAA200DE64F101586FA95F4FEC8429B1")

    Op mHead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.943 -0400", hash_original_field = "B2497DC9780B7282659AE377C47B70F1", hash_generated_field = "1DBFB57BC3C0C58F1CA989515A3C11B2")

    Op mTail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.943 -0400", hash_original_field = "FE7F5679DE5AB4EFCB7F73888C73482C", hash_generated_field = "7C2498E5F23A289A087BC718DE147927")

    int mNumOp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.943 -0400", hash_original_field = "1571B5D671DA2B5A71024C9969DA04AB", hash_generated_field = "25DA9A900AA8941601D4713D8643BCFF")

    int mEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "A64201543D48ED8DDD115D4151A3A908", hash_generated_field = "0403C21FF2E329089D303DA2F881AD65")

    int mExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "A606606C729A4D4BD754EB55FB1D92F2", hash_generated_field = "426B5FECE57930E7AC2A692D910E1B95")

    int mPopEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "48FF7BCE9BEDFB9C61D4EE16EAE35C46", hash_generated_field = "336F0E1CA15D2B7CFA7AB64448E9ABB4")

    int mPopExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "AB01F2F4FD691611940FB5D9DC3F4D9F", hash_generated_field = "6D620657E4B0D7E3BF4B4C9A3EA1860D")

    boolean mAddToBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "BEF2A6B0CCD60C687FB884F8E59C1EC3", hash_generated_field = "00D17B9289ED52FD64E1F76DBFE93EE5")

    boolean mAllowAddToBackStack = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "ECB201FF1883B37FDCC5CA9037698543", hash_generated_field = "34350BC5CB525FC021F5A246971120D8")

    boolean mCommitted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "DBDF7BB492A85A363C47FDDA34C5BB3E", hash_generated_field = "6B9186F1D8E9AA88F21C8B70F0B9BCC7")

    int mIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.944 -0400", hash_original_method = "8E110563CDFB79724FBA0799BF0D3C19", hash_generated_method = "222018A87C5C0AD32DB56B9265BCFEC3")
    public  BackStackRecord(FragmentManagerImpl manager) {
        mManager = manager;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.945 -0400", hash_original_method = "0F20E0B479CF0E65111306B7DA0E9ECF", hash_generated_method = "F84A4F94D5329BDC38A9F06D2F4D41A8")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("BackStackEntry{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
    if(mIndex >= 0)        
        {
            sb.append(" #");
            sb.append(mIndex);
        } 
    if(mName != null)        
        {
            sb.append(" ");
            sb.append(mName);
        } 
        sb.append("}");
String var2460B846747F8B22185AD8BE722266A5_53185224 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_53185224.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_53185224;
        
        
        
        
        
            
            
        
        
            
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.945 -0400", hash_original_method = "A173D988738B1BED0F12DBDA60D665B4", hash_generated_method = "E867740458FE22CD0B4018E39E5B5283")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
        dump(prefix, writer, true);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.947 -0400", hash_original_method = "856C187C4078543C316E968949741777", hash_generated_method = "D667E6425E8E4E1E7139F0A6FF278AC1")
    public void dump(String prefix, PrintWriter writer, boolean full) {
        addTaint(full);
        addTaint(writer.getTaint());
        addTaint(prefix.getTaint());
    if(full)        
        {
            writer.print(prefix);
            writer.print("mName=");
            writer.print(mName);
            writer.print(" mIndex=");
            writer.print(mIndex);
            writer.print(" mCommitted=");
            writer.println(mCommitted);
    if(mTransition != FragmentTransaction.TRANSIT_NONE)            
            {
                writer.print(prefix);
                writer.print("mTransition=#");
                writer.print(Integer.toHexString(mTransition));
                writer.print(" mTransitionStyle=#");
                writer.println(Integer.toHexString(mTransitionStyle));
            } 
    if(mEnterAnim != 0 || mExitAnim !=0)            
            {
                writer.print(prefix);
                writer.print("mEnterAnim=#");
                writer.print(Integer.toHexString(mEnterAnim));
                writer.print(" mExitAnim=#");
                writer.println(Integer.toHexString(mExitAnim));
            } 
    if(mPopEnterAnim != 0 || mPopExitAnim !=0)            
            {
                writer.print(prefix);
                writer.print("mPopEnterAnim=#");
                writer.print(Integer.toHexString(mPopEnterAnim));
                writer.print(" mPopExitAnim=#");
                writer.println(Integer.toHexString(mPopExitAnim));
            } 
    if(mBreadCrumbTitleRes != 0 || mBreadCrumbTitleText != null)            
            {
                writer.print(prefix);
                writer.print("mBreadCrumbTitleRes=#");
                writer.print(Integer.toHexString(mBreadCrumbTitleRes));
                writer.print(" mBreadCrumbTitleText=");
                writer.println(mBreadCrumbTitleText);
            } 
    if(mBreadCrumbShortTitleRes != 0 || mBreadCrumbShortTitleText != null)            
            {
                writer.print(prefix);
                writer.print("mBreadCrumbShortTitleRes=#");
                writer.print(Integer.toHexString(mBreadCrumbShortTitleRes));
                writer.print(" mBreadCrumbShortTitleText=");
                writer.println(mBreadCrumbShortTitleText);
            } 
        } 
    if(mHead != null)        
        {
            writer.print(prefix);
            writer.println("Operations:");
            String innerPrefix = prefix + "    ";
            Op op = mHead;
            int num = 0;
            while
(op != null)            
            {
                String cmdStr;
switch(op.cmd){
                case OP_NULL:
                cmdStr="NULL";
                break;
                case OP_ADD:
                cmdStr="ADD";
                break;
                case OP_REPLACE:
                cmdStr="REPLACE";
                break;
                case OP_REMOVE:
                cmdStr="REMOVE";
                break;
                case OP_HIDE:
                cmdStr="HIDE";
                break;
                case OP_SHOW:
                cmdStr="SHOW";
                break;
                case OP_DETACH:
                cmdStr="DETACH";
                break;
                case OP_ATTACH:
                cmdStr="ATTACH";
                break;
                default:
                cmdStr="cmd=" + op.cmd;
                break;
}                writer.print(prefix);
                writer.print("  Op #");
                writer.print(num);
                writer.print(": ");
                writer.print(cmdStr);
                writer.print(" ");
                writer.println(op.fragment);
    if(full)                
                {
    if(op.enterAnim != 0 || op.exitAnim != 0)                    
                    {
                        writer.print(prefix);
                        writer.print("enterAnim=#");
                        writer.print(Integer.toHexString(op.enterAnim));
                        writer.print(" exitAnim=#");
                        writer.println(Integer.toHexString(op.exitAnim));
                    } 
    if(op.popEnterAnim != 0 || op.popExitAnim != 0)                    
                    {
                        writer.print(prefix);
                        writer.print("popEnterAnim=#");
                        writer.print(Integer.toHexString(op.popEnterAnim));
                        writer.print(" popExitAnim=#");
                        writer.println(Integer.toHexString(op.popExitAnim));
                    } 
                } 
    if(op.removed != null && op.removed.size() > 0)                
                {
for(int i=0;i<op.removed.size();i++)
                    {
                        writer.print(innerPrefix);
    if(op.removed.size() == 1)                        
                        {
                            writer.print("Removed: ");
                        } 
                        else
                        {
    if(i == 0)                            
                            {
                                writer.println("Removed:");
                            } 
                            writer.print(innerPrefix);
                            writer.print("  #");
                            writer.print(i);
                            writer.print(": ");
                        } 
                        writer.println(op.removed.get(i));
                    } 
                } 
                op = op.next;
                num++;
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.948 -0400", hash_original_method = "15A4A4C5F4518D2E82F335984591D8BA", hash_generated_method = "424A6C7F9568680DB2454B07D38F92AC")
    public int getId() {
        int varDEC4E8A5D764B68C732DE242B685EABE_869489828 = (mIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200137827 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200137827;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.948 -0400", hash_original_method = "9339385C292A3B9874BA3EB436AA9056", hash_generated_method = "CCD5F3A4D2F5181E1D41F789CDDD2849")
    public int getBreadCrumbTitleRes() {
        int varF67D340EAA6DF8751E708FC7CBC0D7AD_6465065 = (mBreadCrumbTitleRes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611788852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1611788852;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.948 -0400", hash_original_method = "D139A03B61A4B83382000704FB0C1F23", hash_generated_method = "9EED72D1A0F9A01993D7BAEC381EC901")
    public int getBreadCrumbShortTitleRes() {
        int var0E5DA3EF1C7A293E3DB09F58D5D4153F_1998724547 = (mBreadCrumbShortTitleRes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086109211 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1086109211;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.949 -0400", hash_original_method = "C2C5B49D77ECFC3F06C4280D5C67187D", hash_generated_method = "03CEE1298BE752F697AA032FD201D6F9")
    public CharSequence getBreadCrumbTitle() {
    if(mBreadCrumbTitleRes != 0)        
        {
CharSequence var4A1C3DAD192928EDAC731D5DB2E937F1_1617789098 =             mManager.mActivity.getText(mBreadCrumbTitleRes);
            var4A1C3DAD192928EDAC731D5DB2E937F1_1617789098.addTaint(taint);
            return var4A1C3DAD192928EDAC731D5DB2E937F1_1617789098;
        } 
CharSequence var0594016917A53D2F634E7C8A7EEB3D1D_491895297 =         mBreadCrumbTitleText;
        var0594016917A53D2F634E7C8A7EEB3D1D_491895297.addTaint(taint);
        return var0594016917A53D2F634E7C8A7EEB3D1D_491895297;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.949 -0400", hash_original_method = "CEC326312BE69049B0B2FA6420FE6494", hash_generated_method = "C35CF47AB995078860DB9A7086DB4425")
    public CharSequence getBreadCrumbShortTitle() {
    if(mBreadCrumbShortTitleRes != 0)        
        {
CharSequence var8EC4BD440B9C16E072E99758ED25CDE1_1862826307 =             mManager.mActivity.getText(mBreadCrumbShortTitleRes);
            var8EC4BD440B9C16E072E99758ED25CDE1_1862826307.addTaint(taint);
            return var8EC4BD440B9C16E072E99758ED25CDE1_1862826307;
        } 
CharSequence var0FC310A778C3127194022F0B54CE2F12_1821994930 =         mBreadCrumbShortTitleText;
        var0FC310A778C3127194022F0B54CE2F12_1821994930.addTaint(taint);
        return var0FC310A778C3127194022F0B54CE2F12_1821994930;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.949 -0400", hash_original_method = "32D26C73BB31A0FE5D5A21F02980CDDD", hash_generated_method = "B48706F168CC3A42AD2FC068AEFE89BA")
     void addOp(Op op) {
    if(mHead == null)        
        {
            mHead = mTail = op;
        } 
        else
        {
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.949 -0400", hash_original_method = "C1E47B5485B0B08AA827320F8BD79938", hash_generated_method = "EF153874D7435EB3C03184BBC0F085B8")
    public FragmentTransaction add(Fragment fragment, String tag) {
        addTaint(tag.getTaint());
        addTaint(fragment.getTaint());
        doAddOp(0, fragment, tag, OP_ADD);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1077854964 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1077854964.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1077854964;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.949 -0400", hash_original_method = "F34A7243D750E416C8B46711401682C6", hash_generated_method = "5F5A435F6DC796326193A3937D2A6BBC")
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        addTaint(fragment.getTaint());
        addTaint(containerViewId);
        doAddOp(containerViewId, fragment, null, OP_ADD);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1614309306 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1614309306.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1614309306;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.950 -0400", hash_original_method = "DCEB5E0B408763C7F0E9A3376CBD91C3", hash_generated_method = "62F04D9A6EB65BC321D2E0916996638A")
    public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        addTaint(tag.getTaint());
        addTaint(fragment.getTaint());
        addTaint(containerViewId);
        doAddOp(containerViewId, fragment, tag, OP_ADD);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1612715407 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1612715407.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1612715407;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.950 -0400", hash_original_method = "F2F897C7BFD0AE6B1B051FF1D3DE8AB7", hash_generated_method = "A6216CF0D99C2E21D7C6908E4699AC28")
    private void doAddOp(int containerViewId, Fragment fragment, String tag, int opcmd) {
        addTaint(opcmd);
        addTaint(tag.getTaint());
        addTaint(fragment.getTaint());
        addTaint(containerViewId);
        fragment.mFragmentManager = mManager;
    if(tag != null)        
        {
    if(fragment.mTag != null && !tag.equals(fragment.mTag))            
            {
                IllegalStateException var3C42909973F8EA27FCEDA16CD46609CC_1158204659 = new IllegalStateException("Can't change tag of fragment "
                        + fragment + ": was " + fragment.mTag
                        + " now " + tag);
                var3C42909973F8EA27FCEDA16CD46609CC_1158204659.addTaint(taint);
                throw var3C42909973F8EA27FCEDA16CD46609CC_1158204659;
            } 
            fragment.mTag = tag;
        } 
    if(containerViewId != 0)        
        {
    if(fragment.mFragmentId != 0 && fragment.mFragmentId != containerViewId)            
            {
                IllegalStateException var66C463ECB48D6156C1348CF83035908A_1361668494 = new IllegalStateException("Can't change container ID of fragment "
                        + fragment + ": was " + fragment.mFragmentId
                        + " now " + containerViewId);
                var66C463ECB48D6156C1348CF83035908A_1361668494.addTaint(taint);
                throw var66C463ECB48D6156C1348CF83035908A_1361668494;
            } 
            fragment.mContainerId = fragment.mFragmentId = containerViewId;
        } 
        Op op = new Op();
        op.cmd = opcmd;
        op.fragment = fragment;
        addOp(op);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.950 -0400", hash_original_method = "095D291C1CAFD923EC9CB9BF06EF4676", hash_generated_method = "B312E749B239ADA4DDF7EFD5ED8C7ED6")
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        addTaint(fragment.getTaint());
        addTaint(containerViewId);
FragmentTransaction varD621F10B281EF053F3161244DE0AA321_654463312 =         replace(containerViewId, fragment, null);
        varD621F10B281EF053F3161244DE0AA321_654463312.addTaint(taint);
        return varD621F10B281EF053F3161244DE0AA321_654463312;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.951 -0400", hash_original_method = "1C07811E78071E2352BF0C170F6491CA", hash_generated_method = "EEC52570C06C29DA2DCC8ECC9C766CF5")
    public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        addTaint(tag.getTaint());
        addTaint(fragment.getTaint());
        addTaint(containerViewId);
    if(containerViewId == 0)        
        {
            IllegalArgumentException varB2BCE3EA28A3A91FB62DBF3A83B1ECC5_899033137 = new IllegalArgumentException("Must use non-zero containerViewId");
            varB2BCE3EA28A3A91FB62DBF3A83B1ECC5_899033137.addTaint(taint);
            throw varB2BCE3EA28A3A91FB62DBF3A83B1ECC5_899033137;
        } 
        doAddOp(containerViewId, fragment, tag, OP_REPLACE);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_973209178 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_973209178.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_973209178;
        
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.951 -0400", hash_original_method = "33682B1B727BD924F48FE7F483A5C004", hash_generated_method = "1447D12B249327AAB0632352DC8C6C4D")
    public FragmentTransaction remove(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_REMOVE;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_356761267 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_356761267.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_356761267;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.951 -0400", hash_original_method = "AB9058E54F9496DA8E33E643603CB0C7", hash_generated_method = "FAB79DB503EB34D3ED576413D5FE2F03")
    public FragmentTransaction hide(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_HIDE;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_803020797 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_803020797.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_803020797;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.951 -0400", hash_original_method = "2B6B1F1BD336D20AECF3763EE9DD5949", hash_generated_method = "1E5EB3031087D41086161E828D905FAE")
    public FragmentTransaction show(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_SHOW;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1080381473 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1080381473.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1080381473;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.953 -0400", hash_original_method = "60B4979E5A31C92DF6F58D0AB0599A51", hash_generated_method = "4FC8DB99125B52F1257464217921B092")
    public FragmentTransaction detach(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_DETACH;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1010562250 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1010562250.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1010562250;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.953 -0400", hash_original_method = "71B1C0469F9D1680729415A070BB9988", hash_generated_method = "1C31DC3B8EF79B46259B7AFF1BFA9866")
    public FragmentTransaction attach(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_ATTACH;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_68331845 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_68331845.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_68331845;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.953 -0400", hash_original_method = "E8FBC41447C7F5B20E8F08F3A2F7FD58", hash_generated_method = "EF1607095B8A6101FF22A5D9FE7F29B2")
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        addTaint(exit);
        addTaint(enter);
FragmentTransaction var9753E888852B084401D6F0CF07AF7002_389261626 =         setCustomAnimations(enter, exit, 0, 0);
        var9753E888852B084401D6F0CF07AF7002_389261626.addTaint(taint);
        return var9753E888852B084401D6F0CF07AF7002_389261626;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.954 -0400", hash_original_method = "A0614C8D91A2CFFC3B2827B585934661", hash_generated_method = "32596DA1EF7371E46308C18FF2BF2278")
    public FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit) {
        mEnterAnim = enter;
        mExitAnim = exit;
        mPopEnterAnim = popEnter;
        mPopExitAnim = popExit;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_2106136944 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2106136944.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2106136944;
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.959 -0400", hash_original_method = "A455FB052D79EC1710E986C50AD0D972", hash_generated_method = "CCBCABF38F95724334888A54E63E273E")
    public FragmentTransaction setTransition(int transition) {
        mTransition = transition;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_672104301 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_672104301.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_672104301;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.960 -0400", hash_original_method = "A33CAFCA32BB4FD1A454655E75F4B6CB", hash_generated_method = "493A0516413A7EC56F9A3CB6CF2E1FBA")
    public FragmentTransaction setTransitionStyle(int styleRes) {
        mTransitionStyle = styleRes;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1156689859 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1156689859.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1156689859;
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.960 -0400", hash_original_method = "438624ACF19A9F6511A0E99CD6264659", hash_generated_method = "E2AFA62E0A9237FD914E6A78B27059EF")
    public FragmentTransaction addToBackStack(String name) {
    if(!mAllowAddToBackStack)        
        {
            IllegalStateException var8EA98245B44A0AE85FE7511121F226AB_1420895423 = new IllegalStateException(
                    "This FragmentTransaction is not allowed to be added to the back stack.");
            var8EA98245B44A0AE85FE7511121F226AB_1420895423.addTaint(taint);
            throw var8EA98245B44A0AE85FE7511121F226AB_1420895423;
        } 
        mAddToBackStack = true;
        mName = name;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1170482395 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1170482395.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1170482395;
        
        
            
                    
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.960 -0400", hash_original_method = "6063A0768FB0FF8A9BC1A0D5BDF7E352", hash_generated_method = "9A1940A23BD3453DC6450181F5C23F01")
    public boolean isAddToBackStackAllowed() {
        boolean var425B6F2F7277405F45A086064CEDDBEB_270992295 = (mAllowAddToBackStack);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743829807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743829807;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.961 -0400", hash_original_method = "FA98892FC811CB8446B86919ACA0FBBA", hash_generated_method = "AA44D0A2901D84424B7098DCC714FCC2")
    public FragmentTransaction disallowAddToBackStack() {
    if(mAddToBackStack)        
        {
            IllegalStateException varD80B6A9011270545F9808727D8AC499A_1288731917 = new IllegalStateException(
                    "This transaction is already being added to the back stack");
            varD80B6A9011270545F9808727D8AC499A_1288731917.addTaint(taint);
            throw varD80B6A9011270545F9808727D8AC499A_1288731917;
        } 
        mAllowAddToBackStack = false;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1301148448 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1301148448.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1301148448;
        
        
            
                    
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.961 -0400", hash_original_method = "3ED721B4C54764795D085FCDFAF2CFED", hash_generated_method = "2AFAF52B38963C69C09E1DEE08B23DE3")
    public FragmentTransaction setBreadCrumbTitle(int res) {
        mBreadCrumbTitleRes = res;
        mBreadCrumbTitleText = null;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1324516657 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1324516657.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1324516657;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.962 -0400", hash_original_method = "27CB0DA08C946E1C367250B9E9010CF2", hash_generated_method = "16E68B799BA7125012CCE329E47C435E")
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        mBreadCrumbTitleRes = 0;
        mBreadCrumbTitleText = text;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1186988415 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1186988415.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1186988415;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.962 -0400", hash_original_method = "F0E82E7069B2F6B7E25A71F53DDE4690", hash_generated_method = "9D17992D2D6488A58F82CE284870081D")
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        mBreadCrumbShortTitleRes = res;
        mBreadCrumbShortTitleText = null;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1532971717 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1532971717.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1532971717;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.962 -0400", hash_original_method = "0432E2D3026F58B259B18084E0B71CFD", hash_generated_method = "BF2CD43AEFD18F597C11BE6F7D3CA208")
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        mBreadCrumbShortTitleRes = 0;
        mBreadCrumbShortTitleText = text;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1734527506 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1734527506.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1734527506;
        
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.962 -0400", hash_original_method = "F09A90C496A148F600E3D02A9731BC19", hash_generated_method = "80133B4B0E8027C66205B36EC4C52373")
     void bumpBackStackNesting(int amt) {
        addTaint(amt);
    if(!mAddToBackStack)        
        {
            return;
        } 
    if(FragmentManagerImpl.DEBUG){ }        Op op = mHead;
        while
(op != null)        
        {
    if(op.fragment != null)            
            {
                op.fragment.mBackStackNesting += amt;
    if(FragmentManagerImpl.DEBUG){ }
            } 
    if(op.removed != null)            
            {
for(int i=op.removed.size()-1;i>=0;i--)
                {
                    Fragment r = op.removed.get(i);
                    r.mBackStackNesting += amt;
    if(FragmentManagerImpl.DEBUG){ }
                } 
            } 
            op = op.next;
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.972 -0400", hash_original_method = "FD69B9F14C4FF1755ADA5F3EFF5DDDFB", hash_generated_method = "3612A68AF0E8F49DAABB554348399BCA")
    public int commit() {
        int var5C53E18959EF289C7CD82E409982218F_1944807305 = (commitInternal(false));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227317744 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_227317744;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.972 -0400", hash_original_method = "034B152615D8FC6D1FD7AD2899313AE6", hash_generated_method = "162B529E053BCC164BB54F5D065786C2")
    public int commitAllowingStateLoss() {
        int var20AD2F985E422E348891CFAB3CFA7DFA_2009728207 = (commitInternal(true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762412056 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1762412056;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.972 -0400", hash_original_method = "01D779364E83C28A30DD99CF6E54EB38", hash_generated_method = "53AADEC902150010CE01914446D35F68")
     int commitInternal(boolean allowStateLoss) {
        addTaint(allowStateLoss);
    if(mCommitted)        
        {
        IllegalStateException var16D6A9FC072BC4B79D8156AF08123FF9_1410317085 = new IllegalStateException("commit already called");
        var16D6A9FC072BC4B79D8156AF08123FF9_1410317085.addTaint(taint);
        throw var16D6A9FC072BC4B79D8156AF08123FF9_1410317085;
        }
    if(FragmentManagerImpl.DEBUG)        
        {
            LogWriter logw = new LogWriter(TAG);
            PrintWriter pw = new PrintWriter(logw);
            dump("  ", null, pw, null);
        } 
        mCommitted = true;
    if(mAddToBackStack)        
        {
            mIndex = mManager.allocBackStackIndex(this);
        } 
        else
        {
            mIndex = -1;
        } 
        mManager.enqueueAction(this, allowStateLoss);
        int varDEC4E8A5D764B68C732DE242B685EABE_502992056 = (mIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1351545257 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1351545257;
        
        
        
            
            
            
            
        
        
        
            
        
            
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.981 -0400", hash_original_method = "F2F4246724AFA2458C4148B16BF6293A", hash_generated_method = "9E15284CD5EC827597FECB2AF5FC09B1")
    public void run() {
    if(FragmentManagerImpl.DEBUG){ }    if(mAddToBackStack)        
        {
    if(mIndex < 0)            
            {
                IllegalStateException varAEB8987B401F394D3AE651995E3E6222_1284728185 = new IllegalStateException("addToBackStack() called after commit()");
                varAEB8987B401F394D3AE651995E3E6222_1284728185.addTaint(taint);
                throw varAEB8987B401F394D3AE651995E3E6222_1284728185;
            } 
        } 
        bumpBackStackNesting(1);
        Op op = mHead;
        while
(op != null)        
        {
switch(op.cmd){
            case OP_ADD:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.addFragment(f, false);
            } 
            break;
            case OP_REPLACE:
            {
                Fragment f = op.fragment;
    if(mManager.mAdded != null)                
                {
for(int i=0;i<mManager.mAdded.size();i++)
                    {
                        Fragment old = mManager.mAdded.get(i);
    if(FragmentManagerImpl.DEBUG){ }    if(f == null || old.mContainerId == f.mContainerId)                        
                        {
    if(old == f)                            
                            {
                                op.fragment = f = null;
                            } 
                            else
                            {
    if(op.removed == null)                                
                                {
                                    op.removed = new ArrayList<Fragment>();
                                } 
                                op.removed.add(old);
                                old.mNextAnim = op.exitAnim;
    if(mAddToBackStack)                                
                                {
                                    old.mBackStackNesting += 1;
    if(FragmentManagerImpl.DEBUG){ }
                                } 
                                mManager.removeFragment(old, mTransition, mTransitionStyle);
                            } 
                        } 
                    } 
                } 
    if(f != null)                
                {
                    f.mNextAnim = op.enterAnim;
                    mManager.addFragment(f, false);
                } 
            } 
            break;
            case OP_REMOVE:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.removeFragment(f, mTransition, mTransitionStyle);
            } 
            break;
            case OP_HIDE:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.hideFragment(f, mTransition, mTransitionStyle);
            } 
            break;
            case OP_SHOW:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.showFragment(f, mTransition, mTransitionStyle);
            } 
            break;
            case OP_DETACH:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.detachFragment(f, mTransition, mTransitionStyle);
            } 
            break;
            case OP_ATTACH:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.attachFragment(f, mTransition, mTransitionStyle);
            } 
            break;
            default:
            {
                IllegalArgumentException var2EA9A223A99C618C8A7E8033CAE12D5F_413250766 = new IllegalArgumentException("Unknown cmd: " + op.cmd);
                var2EA9A223A99C618C8A7E8033CAE12D5F_413250766.addTaint(taint);
                throw var2EA9A223A99C618C8A7E8033CAE12D5F_413250766;
            } 
}            op = op.next;
        } 
        mManager.moveToState(mManager.mCurState, mTransition,
                mTransitionStyle, true);
    if(mAddToBackStack)        
        {
            mManager.addBackStackState(this);
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.982 -0400", hash_original_method = "137917E20FC9A3B18E2DEEE98195320E", hash_generated_method = "E13B5D72D86184821543FD7F39541C01")
    public void popFromBackStack(boolean doStateMove) {
        addTaint(doStateMove);
    if(FragmentManagerImpl.DEBUG)        
        {
            LogWriter logw = new LogWriter(TAG);
            PrintWriter pw = new PrintWriter(logw);
            dump("  ", null, pw, null);
        } 
        bumpBackStackNesting(-1);
        Op op = mTail;
        while
(op != null)        
        {
switch(op.cmd){
            case OP_ADD:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.removeFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition),
                            mTransitionStyle);
            } 
            break;
            case OP_REPLACE:
            {
                Fragment f = op.fragment;
    if(f != null)                
                {
                    f.mNextAnim = op.popExitAnim;
                    mManager.removeFragment(f,
                                FragmentManagerImpl.reverseTransit(mTransition),
                                mTransitionStyle);
                } 
    if(op.removed != null)                
                {
for(int i=0;i<op.removed.size();i++)
                    {
                        Fragment old = op.removed.get(i);
                        old.mNextAnim = op.popEnterAnim;
                        mManager.addFragment(old, false);
                    } 
                } 
            } 
            break;
            case OP_REMOVE:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.addFragment(f, false);
            } 
            break;
            case OP_HIDE:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.showFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } 
            break;
            case OP_SHOW:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.hideFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } 
            break;
            case OP_DETACH:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.attachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } 
            break;
            case OP_ATTACH:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.detachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } 
            break;
            default:
            {
                IllegalArgumentException var2EA9A223A99C618C8A7E8033CAE12D5F_965555173 = new IllegalArgumentException("Unknown cmd: " + op.cmd);
                var2EA9A223A99C618C8A7E8033CAE12D5F_965555173.addTaint(taint);
                throw var2EA9A223A99C618C8A7E8033CAE12D5F_965555173;
            } 
}            op = op.prev;
        } 
    if(doStateMove)        
        {
            mManager.moveToState(mManager.mCurState,
                    FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle, true);
        } 
    if(mIndex >= 0)        
        {
            mManager.freeBackStackIndex(mIndex);
            mIndex = -1;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.983 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "5D0EAF6E358D4CD33136695C968D1010")
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_1267835706 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_1267835706.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_1267835706;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.983 -0400", hash_original_method = "78EE7FB9A966094E1E15EEF50B50E3C9", hash_generated_method = "506363DA957C44779407D8EF92BC9BC4")
    public int getTransition() {
        int varEE0B0D4CFF6B126A7F47DE6CAD24BDC6_1105143718 = (mTransition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919591254 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_919591254;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.983 -0400", hash_original_method = "0B18827E69C997D5383C8EBB7663D372", hash_generated_method = "FFD42E05A8C709CFA4464E9A961A9FCA")
    public int getTransitionStyle() {
        int varDE4B0089B15FB88D71DC24794426071D_95639870 = (mTransitionStyle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213745724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_213745724;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.983 -0400", hash_original_method = "98C448D4C76D2FE85810E0C03648865C", hash_generated_method = "5E33B9F39909F6C33F9FBC1540898EF9")
    public boolean isEmpty() {
        boolean var48E5BF95F43DB41550E9635C3B539918_16054244 = (mNumOp == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_491914304 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_491914304;
        
        
    }

    
    static final class Op {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.983 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "19BBD1601EBAF334D6AA33231EED0715")

        Op next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.983 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "BE2B15E3DCB4E20F57C5AF9432510015")

        Op prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "DFFF0A7FA1A55C8C1A4966C19F6DA452", hash_generated_field = "CBDB20FE7C0EE51482970075935C6638")

        int cmd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "CC9B687FC89CACD9827C1873C7A34AB5")

        Fragment fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "0159D9295D9A3CEFA4170895BC7BC70E", hash_generated_field = "63F1115D3C1779EA5F8AD4A1D1B38EB9")

        int enterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "376904687D6BB69F30D31E2080308CB5", hash_generated_field = "7809ED21B1AF75421C6C97CB78F83727")

        int exitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "3FC2BE4EF1C699935A6EFD7681AE3C68", hash_generated_field = "D0892F22C301BA7A61E6684B7CEDEB8C")

        int popEnterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "9006F3166491A16FEAEEB97BE8123AE1", hash_generated_field = "E32555C71C839BAA1F67752555EB6938")

        int popExitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "B07286EBBB5BC7AA91CC3EAA8BC19711", hash_generated_field = "2CECA5CBA87C574F11C3FFA8F991583A")

        ArrayList<Fragment> removed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_method = "D7B482A7C55CFA7077AB6D8147480F87", hash_generated_method = "D7B482A7C55CFA7077AB6D8147480F87")
        public Op ()
        {
            
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "A0234DA5470FDA669977BD858FDBA8F4", hash_generated_field = "60BD3437D9A30501FC86E00816D25257")

    static final String TAG = FragmentManagerImpl.TAG;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "513EEE12279766E0CBD0BA7281E878AA", hash_generated_field = "3C725A5D9DEF53B7FBA369B6031C0114")

    static final int OP_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "5634A5CA5E366F615FD0FD89F9A93C31", hash_generated_field = "D476F834444990BAEEB054A4C302249A")

    static final int OP_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "1D528934B0562AB0449E850942C5D85C", hash_generated_field = "3C4AC3DDA904059CE1649C7DA113A694")

    static final int OP_REPLACE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "7498D0EA6733EFC1AEDE214A6BEC06E6", hash_generated_field = "5D1FE84F46A8710BCAAB63F7836D62F7")

    static final int OP_REMOVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "4AC07D0DEBE4594EF69841578519CE01", hash_generated_field = "C6957BDFCD9D33DF33819EDBB2E9C30D")

    static final int OP_HIDE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "41B3AE08ACF3BA71D344049E3347E7D5", hash_generated_field = "AC2408B061BD12E29767B40B4F69C217")

    static final int OP_SHOW = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "FF1F5968DB58D39FBCF3A33AC9263A4F", hash_generated_field = "FECBA6AE06903F8549AFADF78F9ACEE7")

    static final int OP_DETACH = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:37.984 -0400", hash_original_field = "B1990BA50ED499B0CE434058FF0651AE", hash_generated_field = "BEA53C6640501A26A1D92C01B94C35E1")

    static final int OP_ATTACH = 7;
}

