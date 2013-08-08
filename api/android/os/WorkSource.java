package android.os;

// Droidsafe Imports
import droidsafe.annotations.*;





public class WorkSource implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.852 -0400", hash_original_field = "1B2924E0CDC894FEA7E3856870275E70", hash_generated_field = "95F99CF2E70DB79AD069A36B506646F2")

    int mNum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.852 -0400", hash_original_field = "BAB32F5501A71BA4F005B5ED6F9F8852", hash_generated_field = "B112C188ED4E9EAAFE4ADD6E54143C39")

    int[] mUids;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.853 -0400", hash_original_method = "6347D93E04E74669648A802B7921C1D5", hash_generated_method = "34579F464897EDC33F63C29271A0F20D")
    public  WorkSource() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.854 -0400", hash_original_method = "B6F0D388FBB618146ABF158DEC8410C2", hash_generated_method = "FE79A4DE0F4EA4AABF8FDF0AC241D7C9")
    public  WorkSource(WorkSource orig) {
        if(orig == null)        
        {
            mNum = 0;
            return;
        } //End block
        mNum = orig.mNum;
        if(orig.mUids != null)        
        {
            mUids = orig.mUids.clone();
        } //End block
        else
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.855 -0400", hash_original_method = "98AF9D8E14FDBDB8400169325402879B", hash_generated_method = "70A6251886E48ABB203ED54B374D6A2A")
    public  WorkSource(int uid) {
        addTaint(uid);
        mNum = 1;
        mUids = new int[] { uid, 0 };
        // ---------- Original Method ----------
        //mNum = 1;
        //mUids = new int[] { uid, 0 };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.855 -0400", hash_original_method = "01CB17D53B35B98697D0BEFEE05C5A5F", hash_generated_method = "CE554C44E884E79AE7BC84A4662B79EE")
      WorkSource(Parcel in) {
        mNum = in.readInt();
        mUids = in.createIntArray();
        // ---------- Original Method ----------
        //mNum = in.readInt();
        //mUids = in.createIntArray();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.856 -0400", hash_original_method = "FA15A7D9EE41DC68B6DF2C6C4250D26C", hash_generated_method = "90128746F04DC1F5A49BF7B9DF7ED585")
    public int size() {
        int var1B2924E0CDC894FEA7E3856870275E70_1307816162 = (mNum);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142739116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2142739116;
        // ---------- Original Method ----------
        //return mNum;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.860 -0400", hash_original_method = "2BE27D9B96D07A7F769CE0AAEC8A3019", hash_generated_method = "1728C6D2C7BFA34668F4E74E3181F919")
    public int get(int index) {
        addTaint(index);
        int varDE43819065CB28B552F19C596ACE8947_526940779 = (mUids[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138109889 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2138109889;
        // ---------- Original Method ----------
        //return mUids[index];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.860 -0400", hash_original_method = "FEFE1B40777B5F58606593D185335D3A", hash_generated_method = "1EAEB237ED25FBCAA4FB93E520500649")
    public void clear() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.861 -0400", hash_original_method = "2F8EB035FA41CD52820ED0B16262B2FB", hash_generated_method = "A1EFF3B8C9322AC5255D523312412AF0")
    public boolean diff(WorkSource other) {
        addTaint(other.getTaint());
        int N = mNum;
        if(N != other.mNum)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1718762421 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1273001371 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1273001371;
        } //End block
        final int[] uids1 = mUids;
        final int[] uids2 = other.mUids;
for(int i=0;i<N;i++)
        {
            if(uids1[i] != uids2[i])            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1758921688 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_311591458 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_311591458;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_967018584 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1996248083 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1996248083;
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.862 -0400", hash_original_method = "0302228CCB49F7DB617DC3822F50D404", hash_generated_method = "0F36242A985A561E721DB568C000ADC7")
    public void set(WorkSource other) {
        if(other == null)        
        {
            mNum = 0;
            return;
        } //End block
        mNum = other.mNum;
        if(other.mUids != null)        
        {
            if(mUids != null && mUids.length >= mNum)            
            {
                System.arraycopy(other.mUids, 0, mUids, 0, mNum);
            } //End block
            else
            {
                mUids = other.mUids.clone();
            } //End block
        } //End block
        else
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.863 -0400", hash_original_method = "7924E91892F2F47DFBA42DC07794F83E", hash_generated_method = "78EFCF29562F90693664726E525F5973")
    public void set(int uid) {
        mNum = 1;
        if(mUids == null)        
        mUids = new int[2];
        mUids[0] = uid;
        // ---------- Original Method ----------
        //mNum = 1;
        //if (mUids == null) mUids = new int[2];
        //mUids[0] = uid;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.864 -0400", hash_original_method = "7CA4549360AB4144F4EE2A696452CCBF", hash_generated_method = "E53A2F23DA039C3A062D88E416AAEE90")
    public WorkSource[] setReturningDiffs(WorkSource other) {
        addTaint(other.getTaint());
        synchronized
(sTmpWorkSource)        {
            sNewbWork = null;
            sGoneWork = null;
            updateLocked(other, true, true);
            if(sNewbWork != null || sGoneWork != null)            
            {
                WorkSource[] diffs = new WorkSource[2];
                diffs[0] = sNewbWork;
                diffs[1] = sGoneWork;
WorkSource[] var69C1831EE4720879730C65B2CE39ABC2_1594490499 =                 diffs;
                var69C1831EE4720879730C65B2CE39ABC2_1594490499.addTaint(taint);
                return var69C1831EE4720879730C65B2CE39ABC2_1594490499;
            } //End block
WorkSource[] var540C13E9E156B687226421B24F2DF178_1530849350 =             null;
            var540C13E9E156B687226421B24F2DF178_1530849350.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1530849350;
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.864 -0400", hash_original_method = "8F95FC70B656D084C5E20FAE69C56CE9", hash_generated_method = "C5BA14C8ECA3A450FA3FE0D4F5E3963B")
    public boolean add(WorkSource other) {
        addTaint(other.getTaint());
        synchronized
(sTmpWorkSource)        {
            boolean var237E08BF78304A26A5118BE477DFD479_1848276304 = (updateLocked(other, false, false));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435842252 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_435842252;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //return updateLocked(other, false, false);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.865 -0400", hash_original_method = "3C62D026004765F6E3FE84798605B705", hash_generated_method = "6939F95DC7F62C367079BD5E0DC2F8C2")
    public WorkSource addReturningNewbs(WorkSource other) {
        addTaint(other.getTaint());
        synchronized
(sTmpWorkSource)        {
            sNewbWork = null;
            updateLocked(other, false, true);
WorkSource var58A621AD92B821B849DEFCA427B300B1_201676370 =             sNewbWork;
            var58A621AD92B821B849DEFCA427B300B1_201676370.addTaint(taint);
            return var58A621AD92B821B849DEFCA427B300B1_201676370;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sNewbWork = null;
            //updateLocked(other, false, true);
            //return sNewbWork;
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.865 -0400", hash_original_method = "4279F5B1CF7891D9D61E24583D3B3149", hash_generated_method = "C53A14FAD3E930F799F8E9C712BAFD1D")
    public boolean add(int uid) {
        synchronized
(sTmpWorkSource)        {
            sTmpWorkSource.mUids[0] = uid;
            boolean varE99FB989667A43EEE38DCDDD4E4D43B3_934077848 = (updateLocked(sTmpWorkSource, false, false));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1080823712 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1080823712;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sTmpWorkSource.mUids[0] = uid;
            //return updateLocked(sTmpWorkSource, false, false);
        //}
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.866 -0400", hash_original_method = "6E5D478DFA5CD5B5102A5F18DB42CF54", hash_generated_method = "08B3EC7E3C3BDFEE002B3655D1F6ED48")
    public WorkSource addReturningNewbs(int uid) {
        synchronized
(sTmpWorkSource)        {
            sNewbWork = null;
            sTmpWorkSource.mUids[0] = uid;
            updateLocked(sTmpWorkSource, false, true);
WorkSource var58A621AD92B821B849DEFCA427B300B1_67516878 =             sNewbWork;
            var58A621AD92B821B849DEFCA427B300B1_67516878.addTaint(taint);
            return var58A621AD92B821B849DEFCA427B300B1_67516878;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sNewbWork = null;
            //sTmpWorkSource.mUids[0] = uid;
            //updateLocked(sTmpWorkSource, false, true);
            //return sNewbWork;
        //}
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.867 -0400", hash_original_method = "9E40782544207F8788FDA35D02E6FE4F", hash_generated_method = "21C29B5239B0E531D2CD82F1CCEDF451")
    public boolean remove(WorkSource other) {
        addTaint(other.getTaint());
        int N1 = mNum;
        final int[] uids1 = mUids;
        final int N2 = other.mNum;
        final int[] uids2 = other.mUids;
        boolean changed = false;
        int i1 = 0;
for(int i2=0;i2<N2 && i1<N1;i2++)
        {
            if(uids2[i2] == uids1[i1])            
            {
                N1--;
                if(i1 < N1)                
                System.arraycopy(uids1, i1+1, uids1, i1, N1-i1);
            } //End block
            while
(i1 < N1 && uids2[i2] > uids1[i1])            
            {
                i1++;
            } //End block
        } //End block
        mNum = N1;
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_343776171 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578866376 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578866376;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.870 -0400", hash_original_method = "34E034689DDCE68A5D27EE33789EB9C2", hash_generated_method = "C2698EB48AEFA931FC6D33D9A35D84A2")
    private boolean updateLocked(WorkSource other, boolean set, boolean returnNewbs) {
        addTaint(returnNewbs);
        addTaint(set);
        addTaint(other.getTaint());
        int N1 = mNum;
        int[] uids1 = mUids;
        final int N2 = other.mNum;
        final int[] uids2 = other.mUids;
        boolean changed = false;
        int i1 = 0;
for(int i2=0;i2<N2;i2++)
        {
            if(i1 >= N1 || uids2[i2] < uids1[i1])            
            {
                changed = true;
                if(uids1 == null)                
                {
                    uids1 = new int[4];
                    uids1[0] = uids2[i2];
                } //End block
                else
                if(i1 >= uids1.length)                
                {
                    int[] newuids = new int[(uids1.length*3)/2];
                    if(i1 > 0)                    
                    System.arraycopy(uids1, 0, newuids, 0, i1);
                    if(i1 < N1)                    
                    System.arraycopy(uids1, i1, newuids, i1+1, N1-i1);
                    uids1 = newuids;
                    uids1[i1] = uids2[i2];
                } //End block
                else
                {
                    if(i1 < N1)                    
                    System.arraycopy(uids1, i1, uids1, i1+1, N1-i1);
                    uids1[i1] = uids2[i2];
                } //End block
                if(returnNewbs)                
                {
                    if(sNewbWork == null)                    
                    {
                        sNewbWork = new WorkSource(uids2[i2]);
                    } //End block
                    else
                    {
                        sNewbWork.addLocked(uids2[i2]);
                    } //End block
                } //End block
                N1++;
                i1++;
            } //End block
            else
            {
                if(!set)                
                {
                    do {
                        {
                            i1++;
                        } //End block
} while (i1 < N1 && uids2[i2] >= uids1[i1]);
                } //End block
                else
                {
                    int start = i1;
                    while
(i1 < N1 && uids2[i2] > uids1[i1])                    
                    {
                        if(sGoneWork == null)                        
                        {
                            sGoneWork = new WorkSource(uids1[i1]);
                        } //End block
                        else
                        {
                            sGoneWork.addLocked(uids1[i1]);
                        } //End block
                        i1++;
                    } //End block
                    if(start < i1)                    
                    {
                        System.arraycopy(uids1, i1, uids1, start, i1-start);
                        N1 -= i1-start;
                        i1 = start;
                    } //End block
                    if(i1 < N1 && uids2[i1] == uids1[i1])                    
                    {
                        i1++;
                    } //End block
                } //End block
            } //End block
        } //End block
        mNum = N1;
        mUids = uids1;
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_264721163 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_672955093 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_672955093;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.871 -0400", hash_original_method = "E8ED9AF8451B0D2EC41EDBDBB476EE69", hash_generated_method = "CE7EDB869AF3E643B1197828FBC4EAE8")
    private void addLocked(int uid) {
        if(mUids == null)        
        {
            mUids = new int[4];
            mUids[0] = uid;
            mNum = 1;
            return;
        } //End block
        if(mNum >= mUids.length)        
        {
            int[] newuids = new int[(mNum*3)/2];
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.871 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "48F97FD31AEA549D25F8BDCFD7FD71E4")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_928655967 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572242470 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572242470;
        // ---------- Original Method ----------
        //return 0;
    }

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.872 -0400", hash_original_method = "69D1EA184FE758709BC28AF0EDE2AA21", hash_generated_method = "5F09EAF7E01851276CB975FD08DA122B")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(mNum);
        dest.writeIntArray(mUids);
        // ---------- Original Method ----------
        //dest.writeInt(mNum);
        //dest.writeIntArray(mUids);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.872 -0400", hash_original_field = "BA27BF38D3D82A5155F46269BC4D8A25", hash_generated_field = "AA8D498AF94840F5BEE625F2A0A49393")

    static final WorkSource sTmpWorkSource = new WorkSource(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.872 -0400", hash_original_field = "EC546D444E8E4921F1FBFBDF842DA624", hash_generated_field = "FB46B752A7E983AAF6CE799134A085F8")

    static WorkSource sNewbWork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.872 -0400", hash_original_field = "532D9BF1C1FD87F06BA4D428C5AF4B54", hash_generated_field = "05AD48EE2A9CAE7DE8142D70F4AB9C4F")

    static WorkSource sGoneWork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.872 -0400", hash_original_field = "84CCBAA21E7B3524C16103FCC24A43F9", hash_generated_field = "54615A019D4B817EB6436269428289F0")

    public static final Parcelable.Creator<WorkSource> CREATOR
            = new Parcelable.Creator<WorkSource>() {
        public WorkSource createFromParcel(Parcel in) {
            return new WorkSource(in);
        }
        public WorkSource[] newArray(int size) {
            return new WorkSource[size];
        }
    };
    // orphaned legacy method
    public WorkSource createFromParcel(Parcel in) {
            return new WorkSource(in);
        }
    
    // orphaned legacy method
    public WorkSource[] newArray(int size) {
            return new WorkSource[size];
        }
    
}

