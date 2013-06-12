package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class WorkSource implements Parcelable {
    int mNum;
    int[] mUids;
    static WorkSource sTmpWorkSource = new WorkSource(0);
    static WorkSource sNewbWork;
    static WorkSource sGoneWork;
    public static final Parcelable.Creator<WorkSource> CREATOR = new Parcelable.Creator<WorkSource>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.397 -0400", hash_original_method = "15DC4ADF84BC50464361AC661C12C0D9", hash_generated_method = "C5D8BBBD63FD4A46F2E108B74473881F")
        @DSModeled(DSC.SAFE)
        public WorkSource createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            return (WorkSource)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WorkSource(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.397 -0400", hash_original_method = "45F54F9C412DC844777FD5C44253F064", hash_generated_method = "C96AB8D0CBB9A3376D6E1144ABB596D6")
        @DSModeled(DSC.SAFE)
        public WorkSource[] newArray(int size) {
            dsTaint.addTaint(size);
            return (WorkSource[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WorkSource[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.398 -0400", hash_original_method = "6347D93E04E74669648A802B7921C1D5", hash_generated_method = "A65883FDAC3F095B90D8D4619AFEFC01")
    @DSModeled(DSC.SAFE)
    public WorkSource() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.398 -0400", hash_original_method = "B6F0D388FBB618146ABF158DEC8410C2", hash_generated_method = "A0925D5ED7D05F7CE18F2B3CF1855C5B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WorkSource(WorkSource orig) {
        dsTaint.addTaint(orig.dsTaint);
        {
            mNum = 0;
        } //End block
        mNum = orig.mNum;
        {
            mUids = orig.mUids.clone();
        } //End block
        {
            mUids = null;
        } //End block
        // ---------- Original Method ----------
        //if (orig == null) {
            //mNum = 0;
            //return;
        //}
        //mNum = orig.mNum;
        //if (orig.mUids != null) {
            //mUids = orig.mUids.clone();
        //} else {
            //mUids = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.399 -0400", hash_original_method = "98AF9D8E14FDBDB8400169325402879B", hash_generated_method = "87B9FDCF69708B6DBC49A2D29177C830")
    @DSModeled(DSC.SAFE)
    public WorkSource(int uid) {
        dsTaint.addTaint(uid);
        mNum = 1;
        mUids = new int[] { uid, 0 };
        // ---------- Original Method ----------
        //mNum = 1;
        //mUids = new int[] { uid, 0 };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.399 -0400", hash_original_method = "01CB17D53B35B98697D0BEFEE05C5A5F", hash_generated_method = "61EF8568D27916BF0840547E7160C812")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     WorkSource(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mNum = in.readInt();
        mUids = in.createIntArray();
        // ---------- Original Method ----------
        //mNum = in.readInt();
        //mUids = in.createIntArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.399 -0400", hash_original_method = "FA15A7D9EE41DC68B6DF2C6C4250D26C", hash_generated_method = "3B98CA7A16EFC2538733044C496BC490")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.400 -0400", hash_original_method = "2BE27D9B96D07A7F769CE0AAEC8A3019", hash_generated_method = "EA02EEB4F3E788A05EFA403FE32788CC")
    @DSModeled(DSC.SAFE)
    public int get(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mUids[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.400 -0400", hash_original_method = "FEFE1B40777B5F58606593D185335D3A", hash_generated_method = "B2D9DF9F2099B5DE87DA2846C0148CB8")
    @DSModeled(DSC.SAFE)
    public void clear() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.400 -0400", hash_original_method = "2F8EB035FA41CD52820ED0B16262B2FB", hash_generated_method = "606AEDE961449785ED2CE7910E62978E")
    @DSModeled(DSC.SAFE)
    public boolean diff(WorkSource other) {
        dsTaint.addTaint(other.dsTaint);
        int N;
        N = mNum;
        int[] uids1;
        uids1 = mUids;
        int[] uids2;
        uids2 = other.mUids;
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int N = mNum;
        //if (N != other.mNum) {
            //return true;
        //}
        //final int[] uids1 = mUids;
        //final int[] uids2 = other.mUids;
        //for (int i=0; i<N; i++) {
            //if (uids1[i] != uids2[i]) {
                //return true;
            //}
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.401 -0400", hash_original_method = "0302228CCB49F7DB617DC3822F50D404", hash_generated_method = "BCF447CE9BF76642157F719035AA6EE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void set(WorkSource other) {
        dsTaint.addTaint(other.dsTaint);
        {
            mNum = 0;
        } //End block
        mNum = other.mNum;
        {
            {
                System.arraycopy(other.mUids, 0, mUids, 0, mNum);
            } //End block
            {
                mUids = other.mUids.clone();
            } //End block
        } //End block
        {
            mUids = null;
        } //End block
        // ---------- Original Method ----------
        //if (other == null) {
            //mNum = 0;
            //return;
        //}
        //mNum = other.mNum;
        //if (other.mUids != null) {
            //if (mUids != null && mUids.length >= mNum) {
                //System.arraycopy(other.mUids, 0, mUids, 0, mNum);
            //} else {
                //mUids = other.mUids.clone();
            //}
        //} else {
            //mUids = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.401 -0400", hash_original_method = "7924E91892F2F47DFBA42DC07794F83E", hash_generated_method = "56C9A6B47DDF17C52655F31B0708E3ED")
    @DSModeled(DSC.SAFE)
    public void set(int uid) {
        dsTaint.addTaint(uid);
        mNum = 1;
        mUids = new int[2];
        mUids[0] = uid;
        // ---------- Original Method ----------
        //mNum = 1;
        //if (mUids == null) mUids = new int[2];
        //mUids[0] = uid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.401 -0400", hash_original_method = "7CA4549360AB4144F4EE2A696452CCBF", hash_generated_method = "2DC8226855595C5EC53D4B95754E69B6")
    @DSModeled(DSC.SAFE)
    public WorkSource[] setReturningDiffs(WorkSource other) {
        dsTaint.addTaint(other.dsTaint);
        {
            sNewbWork = null;
            sGoneWork = null;
            updateLocked(other, true, true);
            {
                WorkSource[] diffs;
                diffs = new WorkSource[2];
                diffs[0] = sNewbWork;
                diffs[1] = sGoneWork;
            } //End block
        } //End block
        return (WorkSource[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sNewbWork = null;
            //sGoneWork = null;
            //updateLocked(other, true, true);
            //if (sNewbWork != null || sGoneWork != null) {
                //WorkSource[] diffs = new WorkSource[2];
                //diffs[0] = sNewbWork;
                //diffs[1] = sGoneWork;
                //return diffs;
            //}
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.402 -0400", hash_original_method = "8F95FC70B656D084C5E20FAE69C56CE9", hash_generated_method = "FEEDB663DA54B5F0B998339CDFFC5649")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(WorkSource other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varC9CC0550B53A4704EEB106ABB66202CD_1104658678 = (updateLocked(other, false, false));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //return updateLocked(other, false, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.402 -0400", hash_original_method = "3C62D026004765F6E3FE84798605B705", hash_generated_method = "8F51E90CC8394B6E56556C3041029B7C")
    @DSModeled(DSC.SAFE)
    public WorkSource addReturningNewbs(WorkSource other) {
        dsTaint.addTaint(other.dsTaint);
        {
            sNewbWork = null;
            updateLocked(other, false, true);
        } //End block
        return (WorkSource)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sNewbWork = null;
            //updateLocked(other, false, true);
            //return sNewbWork;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.403 -0400", hash_original_method = "4279F5B1CF7891D9D61E24583D3B3149", hash_generated_method = "66339D1D6240C1AB66A2B7A14FE79D04")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(int uid) {
        dsTaint.addTaint(uid);
        {
            sTmpWorkSource.mUids[0] = uid;
            boolean varAC1E11671A2944B5AF8331CDFD6C8F9E_709900447 = (updateLocked(sTmpWorkSource, false, false));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sTmpWorkSource.mUids[0] = uid;
            //return updateLocked(sTmpWorkSource, false, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.403 -0400", hash_original_method = "6E5D478DFA5CD5B5102A5F18DB42CF54", hash_generated_method = "C29D2E1629357DF49E426C458811FE6C")
    @DSModeled(DSC.SAFE)
    public WorkSource addReturningNewbs(int uid) {
        dsTaint.addTaint(uid);
        {
            sNewbWork = null;
            sTmpWorkSource.mUids[0] = uid;
            updateLocked(sTmpWorkSource, false, true);
        } //End block
        return (WorkSource)dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sNewbWork = null;
            //sTmpWorkSource.mUids[0] = uid;
            //updateLocked(sTmpWorkSource, false, true);
            //return sNewbWork;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.411 -0400", hash_original_method = "9E40782544207F8788FDA35D02E6FE4F", hash_generated_method = "3B366BE3808EB2F1F99F22A14AF1F3C1")
    @DSModeled(DSC.SAFE)
    public boolean remove(WorkSource other) {
        dsTaint.addTaint(other.dsTaint);
        int N1;
        N1 = mNum;
        int[] uids1;
        uids1 = mUids;
        int N2;
        N2 = other.mNum;
        int[] uids2;
        uids2 = other.mUids;
        boolean changed;
        changed = false;
        int i1;
        i1 = 0;
        {
            int i2;
            i2 = 0;
            {
                {
                    N1--;
                    System.arraycopy(uids1, i1+1, uids1, i1, N1-i1);
                } //End block
                {
                    i1++;
                } //End block
            } //End block
        } //End collapsed parenthetic
        mNum = N1;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int N1 = mNum;
        //final int[] uids1 = mUids;
        //final int N2 = other.mNum;
        //final int[] uids2 = other.mUids;
        //boolean changed = false;
        //int i1 = 0;
        //for (int i2=0; i2<N2 && i1<N1; i2++) {
            //if (uids2[i2] == uids1[i1]) {
                //N1--;
                //if (i1 < N1) System.arraycopy(uids1, i1+1, uids1, i1, N1-i1);
            //}
            //while (i1 < N1 && uids2[i2] > uids1[i1]) {
                //i1++;
            //}
        //}
        //mNum = N1;
        //return changed;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.417 -0400", hash_original_method = "34E034689DDCE68A5D27EE33789EB9C2", hash_generated_method = "DF1795AA02811E847A87FE6E97FCBA62")
    @DSModeled(DSC.SAFE)
    private boolean updateLocked(WorkSource other, boolean set, boolean returnNewbs) {
        dsTaint.addTaint(other.dsTaint);
        dsTaint.addTaint(set);
        dsTaint.addTaint(returnNewbs);
        int N1;
        N1 = mNum;
        int[] uids1;
        uids1 = mUids;
        int N2;
        N2 = other.mNum;
        int[] uids2;
        uids2 = other.mUids;
        boolean changed;
        changed = false;
        int i1;
        i1 = 0;
        {
            int i2;
            i2 = 0;
            {
                {
                    changed = true;
                    {
                        uids1 = new int[4];
                        uids1[0] = uids2[i2];
                    } //End block
                    {
                        int[] newuids;
                        newuids = new int[(uids1.length*3)/2];
                        System.arraycopy(uids1, 0, newuids, 0, i1);
                        System.arraycopy(uids1, i1, newuids, i1+1, N1-i1);
                        uids1 = newuids;
                        uids1[i1] = uids2[i2];
                    } //End block
                    {
                        System.arraycopy(uids1, i1, uids1, i1+1, N1-i1);
                        uids1[i1] = uids2[i2];
                    } //End block
                    {
                        {
                            sNewbWork = new WorkSource(uids2[i2]);
                        } //End block
                        {
                            sNewbWork.addLocked(uids2[i2]);
                        } //End block
                    } //End block
                    N1++;
                    i1++;
                } //End block
                {
                    {
                        {
                            i1++;
                        } //End block
                    } //End block
                    {
                        int start;
                        start = i1;
                        {
                            {
                                sGoneWork = new WorkSource(uids1[i1]);
                            } //End block
                            {
                                sGoneWork.addLocked(uids1[i1]);
                            } //End block
                            i1++;
                        } //End block
                        {
                            System.arraycopy(uids1, i1, uids1, start, i1-start);
                            N1 -= i1-start;
                            i1 = start;
                        } //End block
                        {
                            i1++;
                        } //End block
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        mNum = N1;
        mUids = uids1;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.423 -0400", hash_original_method = "E8ED9AF8451B0D2EC41EDBDBB476EE69", hash_generated_method = "5635FA8134A791BC9AA06E348CD8590D")
    @DSModeled(DSC.SAFE)
    private void addLocked(int uid) {
        dsTaint.addTaint(uid);
        {
            mUids = new int[4];
            mUids[0] = uid;
            mNum = 1;
        } //End block
        {
            int[] newuids;
            newuids = new int[(mNum*3)/2];
            System.arraycopy(mUids, 0, newuids, 0, mNum);
            mUids = newuids;
        } //End block
        mUids[mNum] = uid;
        mNum++;
        // ---------- Original Method ----------
        //if (mUids == null) {
            //mUids = new int[4];
            //mUids[0] = uid;
            //mNum = 1;
            //return;
        //}
        //if (mNum >= mUids.length) {
            //int[] newuids = new int[(mNum*3)/2];
            //System.arraycopy(mUids, 0, newuids, 0, mNum);
            //mUids = newuids;
        //}
        //mUids[mNum] = uid;
        //mNum++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.423 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "826038BB7EBD5D3C24D01F025676D20A")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:01.423 -0400", hash_original_method = "69D1EA184FE758709BC28AF0EDE2AA21", hash_generated_method = "172306EF13C4900C8B1D754019A4F5A2")
    @DSModeled(DSC.SAFE)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeInt(mNum);
        dest.writeIntArray(mUids);
        // ---------- Original Method ----------
        //dest.writeInt(mNum);
        //dest.writeIntArray(mUids);
    }

    
}


