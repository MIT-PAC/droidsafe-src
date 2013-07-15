package android.app;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;

final class BackStackState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.187 -0400", hash_original_field = "B18521543B0A3F13E96EC9C4900EECCC", hash_generated_field = "DC6A1E8A42383143F0A42B30213419A5")

    int[] mOps;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.187 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.187 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.187 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.188 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.188 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.188 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.189 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.189 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.195 -0400", hash_original_method = "DCE5061D40CBE6F430759A7A23E4D4F8", hash_generated_method = "5786C8AF628CECBB2F53E169C3CBC6F3")
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
        } //End block
        mOps = new int[bse.mNumOp*7 + numRemoved];
    if(!bse.mAddToBackStack)        
        {
            IllegalStateException var314CBE014D5D2C8AD5652051EFBCF4AC_2018623159 = new IllegalStateException("Not on back stack");
            var314CBE014D5D2C8AD5652051EFBCF4AC_2018623159.addTaint(taint);
            throw var314CBE014D5D2C8AD5652051EFBCF4AC_2018623159;
        } //End block
        op = bse.mHead;
        int pos = 0;
        while
(op != null)        
        {
            mOps[pos++] = op.cmd;
            mOps[pos++] = op.fragment.mIndex;
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
                } //End block
            } //End block
            else
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.198 -0400", hash_original_method = "B968D118C09EBADBAB257C64BF10EDFC", hash_generated_method = "2316B0F18A4F6F99AFA9D18FA79B9D5D")
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.202 -0400", hash_original_method = "F8D54BF837A015C95DFB9CC70933C9DB", hash_generated_method = "BFD8FED0DFA9D833FB6C7133C2EE7C70")
    public BackStackRecord instantiate(FragmentManagerImpl fm) {
        addTaint(fm.getTaint());
        BackStackRecord bse = new BackStackRecord(fm);
        int pos = 0;
        while
(pos < mOps.length)        
        {
            BackStackRecord.Op op = new BackStackRecord.Op();
            op.cmd = mOps[pos++];
    if(FragmentManagerImpl.DEBUG){ }            Fragment f = fm.mActive.get(mOps[pos++]);
            op.fragment = f;
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
                } //End block
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
BackStackRecord varF02DDB74F3AB452E2C7DEEBC20BFE154_387063953 =         bse;
        varF02DDB74F3AB452E2C7DEEBC20BFE154_387063953.addTaint(taint);
        return varF02DDB74F3AB452E2C7DEEBC20BFE154_387063953;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.203 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B44EB1FE189A1D52F073563F7E38BD43")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1318255102 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_765522895 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_765522895;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.204 -0400", hash_original_method = "541B83E53D4985674BDE186AC23E769C", hash_generated_method = "6763825E0CFB1671364D8608AE888EA8")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.205 -0400", hash_original_field = "8B8CFB1C8824B4F8DAC46E032DB231EE", hash_generated_field = "FC56B3496DF6C62063CE25DEA3B38012")

    public static final Parcelable.Creator<BackStackState> CREATOR
            = new Parcelable.Creator<BackStackState>() {
        public BackStackState createFromParcel(Parcel in) {
            return new BackStackState(in);
        }

        public BackStackState[] newArray(int size) {
            return new BackStackState[size];
        }
    };
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.206 -0400", hash_original_field = "1D4FD4FBF6080AF66D4D90562FE06036", hash_generated_field = "B6E40031C2D8257644CECE00AFE40458")

    FragmentManagerImpl mManager;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.206 -0400", hash_original_field = "3910F709012F9D394BA43407D42AB0EC", hash_generated_field = "CAA200DE64F101586FA95F4FEC8429B1")

    Op mHead;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.206 -0400", hash_original_field = "B2497DC9780B7282659AE377C47B70F1", hash_generated_field = "1DBFB57BC3C0C58F1CA989515A3C11B2")

    Op mTail;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.206 -0400", hash_original_field = "FE7F5679DE5AB4EFCB7F73888C73482C", hash_generated_field = "7C2498E5F23A289A087BC718DE147927")

    int mNumOp;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.206 -0400", hash_original_field = "1571B5D671DA2B5A71024C9969DA04AB", hash_generated_field = "25DA9A900AA8941601D4713D8643BCFF")

    int mEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.207 -0400", hash_original_field = "A64201543D48ED8DDD115D4151A3A908", hash_generated_field = "0403C21FF2E329089D303DA2F881AD65")

    int mExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.207 -0400", hash_original_field = "A606606C729A4D4BD754EB55FB1D92F2", hash_generated_field = "426B5FECE57930E7AC2A692D910E1B95")

    int mPopEnterAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.207 -0400", hash_original_field = "48FF7BCE9BEDFB9C61D4EE16EAE35C46", hash_generated_field = "336F0E1CA15D2B7CFA7AB64448E9ABB4")

    int mPopExitAnim;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.207 -0400", hash_original_field = "EE0B0D4CFF6B126A7F47DE6CAD24BDC6", hash_generated_field = "CDDEA472DEC90B76AD0D6CF5B4A2A040")

    int mTransition;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.207 -0400", hash_original_field = "DE4B0089B15FB88D71DC24794426071D", hash_generated_field = "CD29A9E1689EE6A16C4B15593A3A7167")

    int mTransitionStyle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.207 -0400", hash_original_field = "AB01F2F4FD691611940FB5D9DC3F4D9F", hash_generated_field = "6D620657E4B0D7E3BF4B4C9A3EA1860D")

    boolean mAddToBackStack;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.208 -0400", hash_original_field = "BEF2A6B0CCD60C687FB884F8E59C1EC3", hash_generated_field = "00D17B9289ED52FD64E1F76DBFE93EE5")

    boolean mAllowAddToBackStack = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.208 -0400", hash_original_field = "311C2C8498DF6A626CBDB8AA4193499C", hash_generated_field = "ED29A5CAC2A4A14894CD28BA3B1CE29C")

    String mName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.208 -0400", hash_original_field = "ECB201FF1883B37FDCC5CA9037698543", hash_generated_field = "34350BC5CB525FC021F5A246971120D8")

    boolean mCommitted;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.208 -0400", hash_original_field = "DEC4E8A5D764B68C732DE242B685EABE", hash_generated_field = "3FE793BBC68255EAC5B3588E7DE2E2C6")

    int mIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.208 -0400", hash_original_field = "F67D340EAA6DF8751E708FC7CBC0D7AD", hash_generated_field = "E7A56D2F2469DB150849BCC5ECFF6194")

    int mBreadCrumbTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.208 -0400", hash_original_field = "D708D50541666BAC3B19AABF4EE454C8", hash_generated_field = "CD8B3A4957F7DDF6AC7443892C1BE613")

    CharSequence mBreadCrumbTitleText;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.209 -0400", hash_original_field = "0E5DA3EF1C7A293E3DB09F58D5D4153F", hash_generated_field = "AD41F410B9AC4F4C962814DDC6C33643")

    int mBreadCrumbShortTitleRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.209 -0400", hash_original_field = "4D6894456E715F462908BB115BBF3348", hash_generated_field = "7BC40397D8844D56A620FA388A9E2606")

    CharSequence mBreadCrumbShortTitleText;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.209 -0400", hash_original_method = "8E110563CDFB79724FBA0799BF0D3C19", hash_generated_method = "222018A87C5C0AD32DB56B9265BCFEC3")
    public  BackStackRecord(FragmentManagerImpl manager) {
        mManager = manager;
        // ---------- Original Method ----------
        //mManager = manager;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.213 -0400", hash_original_method = "D2AEC534E855FE50C82F3A186CF8CD83", hash_generated_method = "98B7062DCD45BC4B7111AE594386168F")
    public void dump(String prefix, FileDescriptor fd, PrintWriter writer, String[] args) {
        addTaint(args[0].getTaint());
        addTaint(writer.getTaint());
        addTaint(fd.getTaint());
        addTaint(prefix.getTaint());
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
        } //End block
    if(mEnterAnim != 0 || mExitAnim !=0)        
        {
            writer.print(prefix);
            writer.print("mEnterAnim=#");
            writer.print(Integer.toHexString(mEnterAnim));
            writer.print(" mExitAnim=#");
            writer.println(Integer.toHexString(mExitAnim));
        } //End block
    if(mPopEnterAnim != 0 || mPopExitAnim !=0)        
        {
            writer.print(prefix);
            writer.print("mPopEnterAnim=#");
            writer.print(Integer.toHexString(mPopEnterAnim));
            writer.print(" mPopExitAnim=#");
            writer.println(Integer.toHexString(mPopExitAnim));
        } //End block
    if(mBreadCrumbTitleRes != 0 || mBreadCrumbTitleText != null)        
        {
            writer.print(prefix);
            writer.print("mBreadCrumbTitleRes=#");
            writer.print(Integer.toHexString(mBreadCrumbTitleRes));
            writer.print(" mBreadCrumbTitleText=");
            writer.println(mBreadCrumbTitleText);
        } //End block
    if(mBreadCrumbShortTitleRes != 0 || mBreadCrumbShortTitleText != null)        
        {
            writer.print(prefix);
            writer.print("mBreadCrumbShortTitleRes=#");
            writer.print(Integer.toHexString(mBreadCrumbShortTitleRes));
            writer.print(" mBreadCrumbShortTitleText=");
            writer.println(mBreadCrumbShortTitleText);
        } //End block
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
                writer.print(prefix);
                writer.print("  Op #");
                writer.print(num);
                writer.println(":");
                writer.print(innerPrefix);
                writer.print("cmd=");
                writer.print(op.cmd);
                writer.print(" fragment=");
                writer.println(op.fragment);
    if(op.enterAnim != 0 || op.exitAnim != 0)                
                {
                    writer.print(prefix);
                    writer.print("enterAnim=#");
                    writer.print(Integer.toHexString(op.enterAnim));
                    writer.print(" exitAnim=#");
                    writer.println(Integer.toHexString(op.exitAnim));
                } //End block
    if(op.popEnterAnim != 0 || op.popExitAnim != 0)                
                {
                    writer.print(prefix);
                    writer.print("popEnterAnim=#");
                    writer.print(Integer.toHexString(op.popEnterAnim));
                    writer.print(" popExitAnim=#");
                    writer.println(Integer.toHexString(op.popExitAnim));
                } //End block
    if(op.removed != null && op.removed.size() > 0)                
                {
for(int i=0;i<op.removed.size();i++)
                    {
                        writer.print(innerPrefix);
    if(op.removed.size() == 1)                        
                        {
                            writer.print("Removed: ");
                        } //End block
                        else
                        {
                            writer.println("Removed:");
                            writer.print(innerPrefix);
                            writer.print("  #");
                            writer.print(num);
                            writer.print(": ");
                        } //End block
                        writer.println(op.removed.get(i));
                    } //End block
                } //End block
                op = op.next;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.215 -0400", hash_original_method = "15A4A4C5F4518D2E82F335984591D8BA", hash_generated_method = "24AFC36C26BC247E510F878DBCE10206")
    public int getId() {
        int varDEC4E8A5D764B68C732DE242B685EABE_667320359 = (mIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335101541 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335101541;
        // ---------- Original Method ----------
        //return mIndex;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.215 -0400", hash_original_method = "9339385C292A3B9874BA3EB436AA9056", hash_generated_method = "DA0738478015EAC8C262F9C28D34923E")
    public int getBreadCrumbTitleRes() {
        int varF67D340EAA6DF8751E708FC7CBC0D7AD_467734184 = (mBreadCrumbTitleRes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694537997 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694537997;
        // ---------- Original Method ----------
        //return mBreadCrumbTitleRes;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.216 -0400", hash_original_method = "D139A03B61A4B83382000704FB0C1F23", hash_generated_method = "40A76A04038BA481AAC9262DCC787148")
    public int getBreadCrumbShortTitleRes() {
        int var0E5DA3EF1C7A293E3DB09F58D5D4153F_1382363856 = (mBreadCrumbShortTitleRes);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223019099 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223019099;
        // ---------- Original Method ----------
        //return mBreadCrumbShortTitleRes;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.217 -0400", hash_original_method = "C2C5B49D77ECFC3F06C4280D5C67187D", hash_generated_method = "5C35632B2ED2D7E4AB484AC6F72E987A")
    public CharSequence getBreadCrumbTitle() {
    if(mBreadCrumbTitleRes != 0)        
        {
CharSequence var4A1C3DAD192928EDAC731D5DB2E937F1_1173317954 =             mManager.mActivity.getText(mBreadCrumbTitleRes);
            var4A1C3DAD192928EDAC731D5DB2E937F1_1173317954.addTaint(taint);
            return var4A1C3DAD192928EDAC731D5DB2E937F1_1173317954;
        } //End block
CharSequence var0594016917A53D2F634E7C8A7EEB3D1D_1161918106 =         mBreadCrumbTitleText;
        var0594016917A53D2F634E7C8A7EEB3D1D_1161918106.addTaint(taint);
        return var0594016917A53D2F634E7C8A7EEB3D1D_1161918106;
        // ---------- Original Method ----------
        //if (mBreadCrumbTitleRes != 0) {
            //return mManager.mActivity.getText(mBreadCrumbTitleRes);
        //}
        //return mBreadCrumbTitleText;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.217 -0400", hash_original_method = "CEC326312BE69049B0B2FA6420FE6494", hash_generated_method = "5E643CEF6A277F18903634484D587F88")
    public CharSequence getBreadCrumbShortTitle() {
    if(mBreadCrumbShortTitleRes != 0)        
        {
CharSequence var8EC4BD440B9C16E072E99758ED25CDE1_944691325 =             mManager.mActivity.getText(mBreadCrumbShortTitleRes);
            var8EC4BD440B9C16E072E99758ED25CDE1_944691325.addTaint(taint);
            return var8EC4BD440B9C16E072E99758ED25CDE1_944691325;
        } //End block
CharSequence var0FC310A778C3127194022F0B54CE2F12_1966044279 =         mBreadCrumbShortTitleText;
        var0FC310A778C3127194022F0B54CE2F12_1966044279.addTaint(taint);
        return var0FC310A778C3127194022F0B54CE2F12_1966044279;
        // ---------- Original Method ----------
        //if (mBreadCrumbShortTitleRes != 0) {
            //return mManager.mActivity.getText(mBreadCrumbShortTitleRes);
        //}
        //return mBreadCrumbShortTitleText;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.225 -0400", hash_original_method = "32D26C73BB31A0FE5D5A21F02980CDDD", hash_generated_method = "B48706F168CC3A42AD2FC068AEFE89BA")
     void addOp(Op op) {
    if(mHead == null)        
        {
            mHead = mTail = op;
        } //End block
        else
        {
            op.prev = mTail;
            mTail.next = op;
            mTail = op;
        } //End block
        op.enterAnim = mEnterAnim;
        op.exitAnim = mExitAnim;
        op.popEnterAnim = mPopEnterAnim;
        op.popExitAnim = mPopExitAnim;
        mNumOp++;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.227 -0400", hash_original_method = "C1E47B5485B0B08AA827320F8BD79938", hash_generated_method = "3DE1892700A34F56D39EE032C7ACD001")
    public FragmentTransaction add(Fragment fragment, String tag) {
        addTaint(tag.getTaint());
        addTaint(fragment.getTaint());
        doAddOp(0, fragment, tag, OP_ADD);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1548424905 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1548424905.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1548424905;
        // ---------- Original Method ----------
        //doAddOp(0, fragment, tag, OP_ADD);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.228 -0400", hash_original_method = "F34A7243D750E416C8B46711401682C6", hash_generated_method = "D8A2F93AC84B5BABD4C51330EDECB221")
    public FragmentTransaction add(int containerViewId, Fragment fragment) {
        addTaint(fragment.getTaint());
        addTaint(containerViewId);
        doAddOp(containerViewId, fragment, null, OP_ADD);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_488362893 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_488362893.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_488362893;
        // ---------- Original Method ----------
        //doAddOp(containerViewId, fragment, null, OP_ADD);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.229 -0400", hash_original_method = "DCEB5E0B408763C7F0E9A3376CBD91C3", hash_generated_method = "8C5F5DF1B6D027497253C298B3828179")
    public FragmentTransaction add(int containerViewId, Fragment fragment, String tag) {
        addTaint(tag.getTaint());
        addTaint(fragment.getTaint());
        addTaint(containerViewId);
        doAddOp(containerViewId, fragment, tag, OP_ADD);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_510313529 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_510313529.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_510313529;
        // ---------- Original Method ----------
        //doAddOp(containerViewId, fragment, tag, OP_ADD);
        //return this;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.234 -0400", hash_original_method = "F2F897C7BFD0AE6B1B051FF1D3DE8AB7", hash_generated_method = "90FF1F19A8348940C63E3ACAA4908455")
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
                IllegalStateException var3C42909973F8EA27FCEDA16CD46609CC_589237087 = new IllegalStateException("Can't change tag of fragment "
                        + fragment + ": was " + fragment.mTag
                        + " now " + tag);
                var3C42909973F8EA27FCEDA16CD46609CC_589237087.addTaint(taint);
                throw var3C42909973F8EA27FCEDA16CD46609CC_589237087;
            } //End block
            fragment.mTag = tag;
        } //End block
    if(containerViewId != 0)        
        {
    if(fragment.mFragmentId != 0 && fragment.mFragmentId != containerViewId)            
            {
                IllegalStateException var66C463ECB48D6156C1348CF83035908A_1196304420 = new IllegalStateException("Can't change container ID of fragment "
                        + fragment + ": was " + fragment.mFragmentId
                        + " now " + containerViewId);
                var66C463ECB48D6156C1348CF83035908A_1196304420.addTaint(taint);
                throw var66C463ECB48D6156C1348CF83035908A_1196304420;
            } //End block
            fragment.mContainerId = fragment.mFragmentId = containerViewId;
        } //End block
        Op op = new Op();
        op.cmd = opcmd;
        op.fragment = fragment;
        addOp(op);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.235 -0400", hash_original_method = "095D291C1CAFD923EC9CB9BF06EF4676", hash_generated_method = "EB051C5C7634A06F79217DB148DA487C")
    public FragmentTransaction replace(int containerViewId, Fragment fragment) {
        addTaint(fragment.getTaint());
        addTaint(containerViewId);
FragmentTransaction varD621F10B281EF053F3161244DE0AA321_15090705 =         replace(containerViewId, fragment, null);
        varD621F10B281EF053F3161244DE0AA321_15090705.addTaint(taint);
        return varD621F10B281EF053F3161244DE0AA321_15090705;
        // ---------- Original Method ----------
        //return replace(containerViewId, fragment, null);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.237 -0400", hash_original_method = "1C07811E78071E2352BF0C170F6491CA", hash_generated_method = "DB0A26737FD67A90C1DF4226DBFBA9B2")
    public FragmentTransaction replace(int containerViewId, Fragment fragment, String tag) {
        addTaint(tag.getTaint());
        addTaint(fragment.getTaint());
        addTaint(containerViewId);
    if(containerViewId == 0)        
        {
            IllegalArgumentException varB2BCE3EA28A3A91FB62DBF3A83B1ECC5_1022376716 = new IllegalArgumentException("Must use non-zero containerViewId");
            varB2BCE3EA28A3A91FB62DBF3A83B1ECC5_1022376716.addTaint(taint);
            throw varB2BCE3EA28A3A91FB62DBF3A83B1ECC5_1022376716;
        } //End block
        doAddOp(containerViewId, fragment, tag, OP_REPLACE);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_871921360 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_871921360.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_871921360;
        // ---------- Original Method ----------
        //if (containerViewId == 0) {
            //throw new IllegalArgumentException("Must use non-zero containerViewId");
        //}
        //doAddOp(containerViewId, fragment, tag, OP_REPLACE);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.239 -0400", hash_original_method = "33682B1B727BD924F48FE7F483A5C004", hash_generated_method = "7608EBBEAA0206111173CEC1F4676462")
    public FragmentTransaction remove(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_REMOVE;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1556790026 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1556790026.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1556790026;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_REMOVE;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.241 -0400", hash_original_method = "AB9058E54F9496DA8E33E643603CB0C7", hash_generated_method = "42D47FA4E4886AFF3986E2046532FB08")
    public FragmentTransaction hide(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_HIDE;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_2096523448 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2096523448.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2096523448;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_HIDE;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.243 -0400", hash_original_method = "2B6B1F1BD336D20AECF3763EE9DD5949", hash_generated_method = "B76F9CF55A5B9608D01D701292E0FF7B")
    public FragmentTransaction show(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_SHOW;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_430113099 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_430113099.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_430113099;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_SHOW;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.248 -0400", hash_original_method = "60B4979E5A31C92DF6F58D0AB0599A51", hash_generated_method = "AF7C945550777B528C354887A3791525")
    public FragmentTransaction detach(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_DETACH;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1050007923 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1050007923.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1050007923;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_DETACH;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.250 -0400", hash_original_method = "71B1C0469F9D1680729415A070BB9988", hash_generated_method = "512886A258E7589AAAA7F3AEE9C3B85B")
    public FragmentTransaction attach(Fragment fragment) {
        addTaint(fragment.getTaint());
        Op op = new Op();
        op.cmd = OP_ATTACH;
        op.fragment = fragment;
        addOp(op);
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1849171896 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1849171896.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1849171896;
        // ---------- Original Method ----------
        //Op op = new Op();
        //op.cmd = OP_ATTACH;
        //op.fragment = fragment;
        //addOp(op);
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.251 -0400", hash_original_method = "E8FBC41447C7F5B20E8F08F3A2F7FD58", hash_generated_method = "CB5871E42290CAB164072E030B663800")
    public FragmentTransaction setCustomAnimations(int enter, int exit) {
        addTaint(exit);
        addTaint(enter);
FragmentTransaction var9753E888852B084401D6F0CF07AF7002_1131113572 =         setCustomAnimations(enter, exit, 0, 0);
        var9753E888852B084401D6F0CF07AF7002_1131113572.addTaint(taint);
        return var9753E888852B084401D6F0CF07AF7002_1131113572;
        // ---------- Original Method ----------
        //return setCustomAnimations(enter, exit, 0, 0);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.254 -0400", hash_original_method = "A0614C8D91A2CFFC3B2827B585934661", hash_generated_method = "1DE038788CBD3D50850AEABC18CC9060")
    public FragmentTransaction setCustomAnimations(int enter, int exit,
            int popEnter, int popExit) {
        mEnterAnim = enter;
        mExitAnim = exit;
        mPopEnterAnim = popEnter;
        mPopExitAnim = popExit;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_2135551200 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2135551200.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2135551200;
        // ---------- Original Method ----------
        //mEnterAnim = enter;
        //mExitAnim = exit;
        //mPopEnterAnim = popEnter;
        //mPopExitAnim = popExit;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.257 -0400", hash_original_method = "A455FB052D79EC1710E986C50AD0D972", hash_generated_method = "FB40F8EEAC9D956BB8C059180ECF7289")
    public FragmentTransaction setTransition(int transition) {
        mTransition = transition;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_2134060647 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_2134060647.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_2134060647;
        // ---------- Original Method ----------
        //mTransition = transition;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.258 -0400", hash_original_method = "A33CAFCA32BB4FD1A454655E75F4B6CB", hash_generated_method = "008C8191767C536419B634F443E3E324")
    public FragmentTransaction setTransitionStyle(int styleRes) {
        mTransitionStyle = styleRes;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1367851201 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1367851201.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1367851201;
        // ---------- Original Method ----------
        //mTransitionStyle = styleRes;
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.260 -0400", hash_original_method = "438624ACF19A9F6511A0E99CD6264659", hash_generated_method = "568B7D926DCB5015ED42E91003878F5E")
    public FragmentTransaction addToBackStack(String name) {
    if(!mAllowAddToBackStack)        
        {
            IllegalStateException var8EA98245B44A0AE85FE7511121F226AB_1166481541 = new IllegalStateException(
                    "This FragmentTransaction is not allowed to be added to the back stack.");
            var8EA98245B44A0AE85FE7511121F226AB_1166481541.addTaint(taint);
            throw var8EA98245B44A0AE85FE7511121F226AB_1166481541;
        } //End block
        mAddToBackStack = true;
        mName = name;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1250947066 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1250947066.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1250947066;
        // ---------- Original Method ----------
        //if (!mAllowAddToBackStack) {
            //throw new IllegalStateException(
                    //"This FragmentTransaction is not allowed to be added to the back stack.");
        //}
        //mAddToBackStack = true;
        //mName = name;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.261 -0400", hash_original_method = "6063A0768FB0FF8A9BC1A0D5BDF7E352", hash_generated_method = "8B1B1042FEEDC3311FF726B4548C4000")
    public boolean isAddToBackStackAllowed() {
        boolean var425B6F2F7277405F45A086064CEDDBEB_1103227587 = (mAllowAddToBackStack);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1537393767 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1537393767;
        // ---------- Original Method ----------
        //return mAllowAddToBackStack;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.262 -0400", hash_original_method = "FA98892FC811CB8446B86919ACA0FBBA", hash_generated_method = "0C30F8FA5D83977A77DBB4F9E96245C5")
    public FragmentTransaction disallowAddToBackStack() {
    if(mAddToBackStack)        
        {
            IllegalStateException varD80B6A9011270545F9808727D8AC499A_1272635759 = new IllegalStateException(
                    "This transaction is already being added to the back stack");
            varD80B6A9011270545F9808727D8AC499A_1272635759.addTaint(taint);
            throw varD80B6A9011270545F9808727D8AC499A_1272635759;
        } //End block
        mAllowAddToBackStack = false;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1367057013 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1367057013.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1367057013;
        // ---------- Original Method ----------
        //if (mAddToBackStack) {
            //throw new IllegalStateException(
                    //"This transaction is already being added to the back stack");
        //}
        //mAllowAddToBackStack = false;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.263 -0400", hash_original_method = "3ED721B4C54764795D085FCDFAF2CFED", hash_generated_method = "E06A425A74ECDDF090BD28D87637E1B2")
    public FragmentTransaction setBreadCrumbTitle(int res) {
        mBreadCrumbTitleRes = res;
        mBreadCrumbTitleText = null;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_1157883456 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_1157883456.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_1157883456;
        // ---------- Original Method ----------
        //mBreadCrumbTitleRes = res;
        //mBreadCrumbTitleText = null;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.264 -0400", hash_original_method = "27CB0DA08C946E1C367250B9E9010CF2", hash_generated_method = "95E115CDCFB0331BAF722AA1BE60D544")
    public FragmentTransaction setBreadCrumbTitle(CharSequence text) {
        mBreadCrumbTitleRes = 0;
        mBreadCrumbTitleText = text;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_537659937 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_537659937.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_537659937;
        // ---------- Original Method ----------
        //mBreadCrumbTitleRes = 0;
        //mBreadCrumbTitleText = text;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.265 -0400", hash_original_method = "F0E82E7069B2F6B7E25A71F53DDE4690", hash_generated_method = "0E7E96B263FCD3E495CF998A0BC435E5")
    public FragmentTransaction setBreadCrumbShortTitle(int res) {
        mBreadCrumbShortTitleRes = res;
        mBreadCrumbShortTitleText = null;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_120174623 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_120174623.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_120174623;
        // ---------- Original Method ----------
        //mBreadCrumbShortTitleRes = res;
        //mBreadCrumbShortTitleText = null;
        //return this;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.266 -0400", hash_original_method = "0432E2D3026F58B259B18084E0B71CFD", hash_generated_method = "EAB653FE11A48E4DD9916CB11BFFC967")
    public FragmentTransaction setBreadCrumbShortTitle(CharSequence text) {
        mBreadCrumbShortTitleRes = 0;
        mBreadCrumbShortTitleText = text;
FragmentTransaction var72A74007B2BE62B849F475C7BDA4658B_252807672 =         this;
        var72A74007B2BE62B849F475C7BDA4658B_252807672.addTaint(taint);
        return var72A74007B2BE62B849F475C7BDA4658B_252807672;
        // ---------- Original Method ----------
        //mBreadCrumbShortTitleRes = 0;
        //mBreadCrumbShortTitleText = text;
        //return this;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.267 -0400", hash_original_method = "350B86C0CFAA72F059C15CB3FE1D993C", hash_generated_method = "4F15796A08BAC404995DD855016EA47C")
     void bumpBackStackNesting(int amt) {
        addTaint(amt);
    if(!mAddToBackStack)        
        {
            return;
        } //End block
    if(FragmentManagerImpl.DEBUG){ }        Op op = mHead;
        while
(op != null)        
        {
            op.fragment.mBackStackNesting += amt;
    if(FragmentManagerImpl.DEBUG){ }    if(op.removed != null)            
            {
for(int i=op.removed.size()-1;i>=0;i--)
                {
                    Fragment r = op.removed.get(i);
                    r.mBackStackNesting += amt;
    if(FragmentManagerImpl.DEBUG){ }
                } //End block
            } //End block
            op = op.next;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.268 -0400", hash_original_method = "FD69B9F14C4FF1755ADA5F3EFF5DDDFB", hash_generated_method = "90038A5805B413894A54E4AE2A5A919C")
    public int commit() {
        int var5C53E18959EF289C7CD82E409982218F_1236610776 = (commitInternal(false));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623559827 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_623559827;
        // ---------- Original Method ----------
        //return commitInternal(false);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.271 -0400", hash_original_method = "034B152615D8FC6D1FD7AD2899313AE6", hash_generated_method = "6E4ACD22FD2275B556513D81CD6E92AD")
    public int commitAllowingStateLoss() {
        int var20AD2F985E422E348891CFAB3CFA7DFA_1603446797 = (commitInternal(true));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302219569 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_302219569;
        // ---------- Original Method ----------
        //return commitInternal(true);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.275 -0400", hash_original_method = "9BF727F0CCA97F90C9847FCD006039C1", hash_generated_method = "59879518098F120626C0B3E32922F533")
     int commitInternal(boolean allowStateLoss) {
        addTaint(allowStateLoss);
    if(mCommitted)        
        {
        IllegalStateException var16D6A9FC072BC4B79D8156AF08123FF9_864951195 = new IllegalStateException("commit already called");
        var16D6A9FC072BC4B79D8156AF08123FF9_864951195.addTaint(taint);
        throw var16D6A9FC072BC4B79D8156AF08123FF9_864951195;
        }
    if(FragmentManagerImpl.DEBUG){ }        mCommitted = true;
    if(mAddToBackStack)        
        {
            mIndex = mManager.allocBackStackIndex(this);
        } //End block
        else
        {
            mIndex = -1;
        } //End block
        mManager.enqueueAction(this, allowStateLoss);
        int varDEC4E8A5D764B68C732DE242B685EABE_1188646623 = (mIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93751724 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_93751724;
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.282 -0400", hash_original_method = "BA0CE442AF616D2BBAA3AAFEB295CD0F", hash_generated_method = "EEB9277B049F0A817FC191A4138B17E2")
    public void run() {
    if(FragmentManagerImpl.DEBUG){ }    if(mAddToBackStack)        
        {
    if(mIndex < 0)            
            {
                IllegalStateException varAEB8987B401F394D3AE651995E3E6222_1194888417 = new IllegalStateException("addToBackStack() called after commit()");
                varAEB8987B401F394D3AE651995E3E6222_1194888417.addTaint(taint);
                throw varAEB8987B401F394D3AE651995E3E6222_1194888417;
            } //End block
        } //End block
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
            } //End block
            break;
            case OP_REPLACE:
            {
                Fragment f = op.fragment;
    if(mManager.mAdded != null)                
                {
for(int i=0;i<mManager.mAdded.size();i++)
                    {
                        Fragment old = mManager.mAdded.get(i);
    if(FragmentManagerImpl.DEBUG){ }    if(old.mContainerId == f.mContainerId)                        
                        {
    if(op.removed == null)                            
                            {
                                op.removed = new ArrayList<Fragment>();
                            } //End block
                            op.removed.add(old);
                            old.mNextAnim = op.exitAnim;
    if(mAddToBackStack)                            
                            {
                                old.mBackStackNesting += 1;
    if(FragmentManagerImpl.DEBUG){ }
                            } //End block
                            mManager.removeFragment(old, mTransition, mTransitionStyle);
                        } //End block
                    } //End block
                } //End block
                f.mNextAnim = op.enterAnim;
                mManager.addFragment(f, false);
            } //End block
            break;
            case OP_REMOVE:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.removeFragment(f, mTransition, mTransitionStyle);
            } //End block
            break;
            case OP_HIDE:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.hideFragment(f, mTransition, mTransitionStyle);
            } //End block
            break;
            case OP_SHOW:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.showFragment(f, mTransition, mTransitionStyle);
            } //End block
            break;
            case OP_DETACH:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.exitAnim;
                mManager.detachFragment(f, mTransition, mTransitionStyle);
            } //End block
            break;
            case OP_ATTACH:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.enterAnim;
                mManager.attachFragment(f, mTransition, mTransitionStyle);
            } //End block
            break;
            default:
            {
                IllegalArgumentException var2EA9A223A99C618C8A7E8033CAE12D5F_1844125337 = new IllegalArgumentException("Unknown cmd: " + op.cmd);
                var2EA9A223A99C618C8A7E8033CAE12D5F_1844125337.addTaint(taint);
                throw var2EA9A223A99C618C8A7E8033CAE12D5F_1844125337;
            } //End block
}            op = op.next;
        } //End block
        mManager.moveToState(mManager.mCurState, mTransition,
                mTransitionStyle, true);
    if(mAddToBackStack)        
        {
            mManager.addBackStackState(this);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.288 -0400", hash_original_method = "7F72D15008964B0C744517E586063B58", hash_generated_method = "65E5580D89BB546061464E09BF427EFA")
    public void popFromBackStack(boolean doStateMove) {
        addTaint(doStateMove);
    if(FragmentManagerImpl.DEBUG){ }        bumpBackStackNesting(-1);
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
            } //End block
            break;
            case OP_REPLACE:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.removeFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition),
                            mTransitionStyle);
    if(op.removed != null)                
                {
for(int i=0;i<op.removed.size();i++)
                    {
                        Fragment old = op.removed.get(i);
                        old.mNextAnim = op.popEnterAnim;
                        mManager.addFragment(old, false);
                    } //End block
                } //End block
            } //End block
            break;
            case OP_REMOVE:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.addFragment(f, false);
            } //End block
            break;
            case OP_HIDE:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.showFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } //End block
            break;
            case OP_SHOW:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.hideFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } //End block
            break;
            case OP_DETACH:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popEnterAnim;
                mManager.attachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } //End block
            break;
            case OP_ATTACH:
            {
                Fragment f = op.fragment;
                f.mNextAnim = op.popExitAnim;
                mManager.detachFragment(f,
                            FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle);
            } //End block
            break;
            default:
            {
                IllegalArgumentException var2EA9A223A99C618C8A7E8033CAE12D5F_1920358294 = new IllegalArgumentException("Unknown cmd: " + op.cmd);
                var2EA9A223A99C618C8A7E8033CAE12D5F_1920358294.addTaint(taint);
                throw var2EA9A223A99C618C8A7E8033CAE12D5F_1920358294;
            } //End block
}            op = op.prev;
        } //End block
    if(doStateMove)        
        {
            mManager.moveToState(mManager.mCurState,
                    FragmentManagerImpl.reverseTransit(mTransition), mTransitionStyle, true);
        } //End block
    if(mIndex >= 0)        
        {
            mManager.freeBackStackIndex(mIndex);
            mIndex = -1;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.289 -0400", hash_original_method = "9194A7433912D38B9A3F1171AC921C56", hash_generated_method = "1D0CDA9BBE8628154B6031164E070441")
    public String getName() {
String varDBF15A5FB8102A5C28D5046A0E92E443_1946942103 =         mName;
        varDBF15A5FB8102A5C28D5046A0E92E443_1946942103.addTaint(taint);
        return varDBF15A5FB8102A5C28D5046A0E92E443_1946942103;
        // ---------- Original Method ----------
        //return mName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.289 -0400", hash_original_method = "78EE7FB9A966094E1E15EEF50B50E3C9", hash_generated_method = "F382CBBD715635D199CDD7286E4D9B4D")
    public int getTransition() {
        int varEE0B0D4CFF6B126A7F47DE6CAD24BDC6_1170919654 = (mTransition);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9009028 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_9009028;
        // ---------- Original Method ----------
        //return mTransition;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.290 -0400", hash_original_method = "0B18827E69C997D5383C8EBB7663D372", hash_generated_method = "1CB896D7897107B0C73E7F73EF52AAE6")
    public int getTransitionStyle() {
        int varDE4B0089B15FB88D71DC24794426071D_1476435858 = (mTransitionStyle);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516716326 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_516716326;
        // ---------- Original Method ----------
        //return mTransitionStyle;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.290 -0400", hash_original_method = "98C448D4C76D2FE85810E0C03648865C", hash_generated_method = "85F6198F704EB8D7BD336F749363AD14")
    public boolean isEmpty() {
        boolean var48E5BF95F43DB41550E9635C3B539918_178549988 = (mNumOp == 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2024948401 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2024948401;
        // ---------- Original Method ----------
        //return mNumOp == 0;
    }

    
    static final class Op {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.291 -0400", hash_original_field = "D0CAB90D8D20D57E2F2B9BE52F7DD25D", hash_generated_field = "19BBD1601EBAF334D6AA33231EED0715")

        Op next;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.291 -0400", hash_original_field = "FCB08B164AC83E09964DEB24F2D2E80B", hash_generated_field = "BE2B15E3DCB4E20F57C5AF9432510015")

        Op prev;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.291 -0400", hash_original_field = "DFFF0A7FA1A55C8C1A4966C19F6DA452", hash_generated_field = "CBDB20FE7C0EE51482970075935C6638")

        int cmd;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.292 -0400", hash_original_field = "02E918FC72837D7C2689BE88684DCEB1", hash_generated_field = "CC9B687FC89CACD9827C1873C7A34AB5")

        Fragment fragment;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.292 -0400", hash_original_field = "0159D9295D9A3CEFA4170895BC7BC70E", hash_generated_field = "63F1115D3C1779EA5F8AD4A1D1B38EB9")

        int enterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.292 -0400", hash_original_field = "376904687D6BB69F30D31E2080308CB5", hash_generated_field = "7809ED21B1AF75421C6C97CB78F83727")

        int exitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.292 -0400", hash_original_field = "3FC2BE4EF1C699935A6EFD7681AE3C68", hash_generated_field = "D0892F22C301BA7A61E6684B7CEDEB8C")

        int popEnterAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.292 -0400", hash_original_field = "9006F3166491A16FEAEEB97BE8123AE1", hash_generated_field = "E32555C71C839BAA1F67752555EB6938")

        int popExitAnim;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.293 -0400", hash_original_field = "B07286EBBB5BC7AA91CC3EAA8BC19711", hash_generated_field = "2CECA5CBA87C574F11C3FFA8F991583A")

        ArrayList<Fragment> removed;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.293 -0400", hash_original_method = "D7B482A7C55CFA7077AB6D8147480F87", hash_generated_method = "D7B482A7C55CFA7077AB6D8147480F87")
        public Op ()
        {
            //Synthesized constructor
        }


    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.293 -0400", hash_original_field = "E66DE76B758EE031E85F28C8BFC50283", hash_generated_field = "583E47895BFA5D844AD0AE16F53E746D")

    static final String TAG = "BackStackEntry";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.293 -0400", hash_original_field = "513EEE12279766E0CBD0BA7281E878AA", hash_generated_field = "3C725A5D9DEF53B7FBA369B6031C0114")

    static final int OP_NULL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.294 -0400", hash_original_field = "5634A5CA5E366F615FD0FD89F9A93C31", hash_generated_field = "D476F834444990BAEEB054A4C302249A")

    static final int OP_ADD = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.294 -0400", hash_original_field = "1D528934B0562AB0449E850942C5D85C", hash_generated_field = "3C4AC3DDA904059CE1649C7DA113A694")

    static final int OP_REPLACE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.294 -0400", hash_original_field = "7498D0EA6733EFC1AEDE214A6BEC06E6", hash_generated_field = "5D1FE84F46A8710BCAAB63F7836D62F7")

    static final int OP_REMOVE = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.294 -0400", hash_original_field = "4AC07D0DEBE4594EF69841578519CE01", hash_generated_field = "C6957BDFCD9D33DF33819EDBB2E9C30D")

    static final int OP_HIDE = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.295 -0400", hash_original_field = "41B3AE08ACF3BA71D344049E3347E7D5", hash_generated_field = "AC2408B061BD12E29767B40B4F69C217")

    static final int OP_SHOW = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.295 -0400", hash_original_field = "FF1F5968DB58D39FBCF3A33AC9263A4F", hash_generated_field = "FECBA6AE06903F8549AFADF78F9ACEE7")

    static final int OP_DETACH = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:01.295 -0400", hash_original_field = "B1990BA50ED499B0CE434058FF0651AE", hash_generated_field = "BEA53C6640501A26A1D92C01B94C35E1")

    static final int OP_ATTACH = 7;
}

