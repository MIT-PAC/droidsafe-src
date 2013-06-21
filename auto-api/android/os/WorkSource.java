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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.404 -0400", hash_original_method = "6347D93E04E74669648A802B7921C1D5", hash_generated_method = "34579F464897EDC33F63C29271A0F20D")
    @DSModeled(DSC.SAFE)
    public WorkSource() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.405 -0400", hash_original_method = "B6F0D388FBB618146ABF158DEC8410C2", hash_generated_method = "D026A720604DC0018DBCD70DD2783DCB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.405 -0400", hash_original_method = "98AF9D8E14FDBDB8400169325402879B", hash_generated_method = "13E72749896DAEE256188D4F3C7DEEA7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WorkSource(int uid) {
        dsTaint.addTaint(uid);
        mNum = 1;
        mUids = new int[] { uid, 0 };
        // ---------- Original Method ----------
        //mNum = 1;
        //mUids = new int[] { uid, 0 };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.405 -0400", hash_original_method = "01CB17D53B35B98697D0BEFEE05C5A5F", hash_generated_method = "13754C889F9FEEF27178EAE47AA02726")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     WorkSource(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        mNum = in.readInt();
        mUids = in.createIntArray();
        // ---------- Original Method ----------
        //mNum = in.readInt();
        //mUids = in.createIntArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.406 -0400", hash_original_method = "FA15A7D9EE41DC68B6DF2C6C4250D26C", hash_generated_method = "D2D5B2C131810065B47BCF1A5F55900D")
    @DSModeled(DSC.SAFE)
    public int size() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.406 -0400", hash_original_method = "2BE27D9B96D07A7F769CE0AAEC8A3019", hash_generated_method = "0CB1FB5B7973260419EE58325894C0DC")
    @DSModeled(DSC.SAFE)
    public int get(int index) {
        dsTaint.addTaint(index);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mUids[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.406 -0400", hash_original_method = "FEFE1B40777B5F58606593D185335D3A", hash_generated_method = "1EAEB237ED25FBCAA4FB93E520500649")
    @DSModeled(DSC.SAFE)
    public void clear() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.406 -0400", hash_original_method = "2F8EB035FA41CD52820ED0B16262B2FB", hash_generated_method = "EF84B45911D10510112D01E14FB6F6A4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.407 -0400", hash_original_method = "0302228CCB49F7DB617DC3822F50D404", hash_generated_method = "7E838C9908AA201DD94513CA679492D8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.407 -0400", hash_original_method = "7924E91892F2F47DFBA42DC07794F83E", hash_generated_method = "C4AFC38FBFA352D3ADF779B00DE8C11C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.407 -0400", hash_original_method = "7CA4549360AB4144F4EE2A696452CCBF", hash_generated_method = "F8AE30F54D2DFF788ED893CC4442F0BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.408 -0400", hash_original_method = "8F95FC70B656D084C5E20FAE69C56CE9", hash_generated_method = "800FC854DD659F0F7CB59B2EA2F55F43")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(WorkSource other) {
        dsTaint.addTaint(other.dsTaint);
        {
            boolean varC9CC0550B53A4704EEB106ABB66202CD_1690371872 = (updateLocked(other, false, false));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //return updateLocked(other, false, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.408 -0400", hash_original_method = "3C62D026004765F6E3FE84798605B705", hash_generated_method = "585ABF1AD28F3FDACB3820592C3BBFFE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.408 -0400", hash_original_method = "4279F5B1CF7891D9D61E24583D3B3149", hash_generated_method = "3EB40D92C175023A5875B61192FDE8BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean add(int uid) {
        dsTaint.addTaint(uid);
        {
            sTmpWorkSource.mUids[0] = uid;
            boolean varAC1E11671A2944B5AF8331CDFD6C8F9E_1952953194 = (updateLocked(sTmpWorkSource, false, false));
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sTmpWorkSource.mUids[0] = uid;
            //return updateLocked(sTmpWorkSource, false, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.409 -0400", hash_original_method = "6E5D478DFA5CD5B5102A5F18DB42CF54", hash_generated_method = "CBE9793BF4CA5B8F83CA1A91A835CE6D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.410 -0400", hash_original_method = "9E40782544207F8788FDA35D02E6FE4F", hash_generated_method = "1374CF3A51940C0DB00E1AB3A57B6B4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                    System.arraycopy(uids1, i1+1, uids1, i1, N1-i1);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.411 -0400", hash_original_method = "34E034689DDCE68A5D27EE33789EB9C2", hash_generated_method = "B5886D20F95D79DE3F14950C421208EB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
                } //End block
                {
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
                        } //End block
                        {
                            System.arraycopy(uids1, i1, uids1, start, i1-start);
                            N1 -= i1-start;
                            i1 = start;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.413 -0400", hash_original_method = "E8ED9AF8451B0D2EC41EDBDBB476EE69", hash_generated_method = "5C82B2133E11DFA09F137D1C16F23570")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.413 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.413 -0400", hash_original_method = "69D1EA184FE758709BC28AF0EDE2AA21", hash_generated_method = "03586B851B0503F2B2E6FD6F9E685BB3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(mNum);
        dest.writeIntArray(mUids);
        // ---------- Original Method ----------
        //dest.writeInt(mNum);
        //dest.writeIntArray(mUids);
    }

    
    static final WorkSource sTmpWorkSource = new WorkSource(0);
    static WorkSource sNewbWork;
    static WorkSource sGoneWork;
    public static final Parcelable.Creator<WorkSource> CREATOR = new Parcelable.Creator<WorkSource>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.414 -0400", hash_original_method = "15DC4ADF84BC50464361AC661C12C0D9", hash_generated_method = "6DE0E10E755ABD539DF940765A604305")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WorkSource createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            WorkSource varD4B8DEEB59F89AC3E2F636968F1B9008_210374802 = (new WorkSource(in));
            return (WorkSource)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WorkSource(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:54.414 -0400", hash_original_method = "45F54F9C412DC844777FD5C44253F064", hash_generated_method = "22B8A10C0BB91E0868C44452C05EC2B2")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WorkSource[] newArray(int size) {
            dsTaint.addTaint(size);
            WorkSource[] varD3E61AECAAC2FA334B930BCD8EFADBD6_887570912 = (new WorkSource[size]);
            return (WorkSource[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WorkSource[size];
        }

        
}; //Transformed anonymous class
}

