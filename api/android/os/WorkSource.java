package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class WorkSource implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.898 -0400", hash_original_field = "1B2924E0CDC894FEA7E3856870275E70", hash_generated_field = "95F99CF2E70DB79AD069A36B506646F2")

    int mNum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.898 -0400", hash_original_field = "BAB32F5501A71BA4F005B5ED6F9F8852", hash_generated_field = "B112C188ED4E9EAAFE4ADD6E54143C39")

    int[] mUids;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.898 -0400", hash_original_method = "6347D93E04E74669648A802B7921C1D5", hash_generated_method = "34579F464897EDC33F63C29271A0F20D")
    public  WorkSource() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.898 -0400", hash_original_method = "B6F0D388FBB618146ABF158DEC8410C2", hash_generated_method = "FE79A4DE0F4EA4AABF8FDF0AC241D7C9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.899 -0400", hash_original_method = "98AF9D8E14FDBDB8400169325402879B", hash_generated_method = "70A6251886E48ABB203ED54B374D6A2A")
    public  WorkSource(int uid) {
        addTaint(uid);
        mNum = 1;
        mUids = new int[] { uid, 0 };
        // ---------- Original Method ----------
        //mNum = 1;
        //mUids = new int[] { uid, 0 };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.899 -0400", hash_original_method = "01CB17D53B35B98697D0BEFEE05C5A5F", hash_generated_method = "CE554C44E884E79AE7BC84A4662B79EE")
      WorkSource(Parcel in) {
        mNum = in.readInt();
        mUids = in.createIntArray();
        // ---------- Original Method ----------
        //mNum = in.readInt();
        //mUids = in.createIntArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.899 -0400", hash_original_method = "FA15A7D9EE41DC68B6DF2C6C4250D26C", hash_generated_method = "7A2990DB0011E43AD1827962DC987F41")
    public int size() {
        int var1B2924E0CDC894FEA7E3856870275E70_1442227490 = (mNum);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924706258 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_924706258;
        // ---------- Original Method ----------
        //return mNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.899 -0400", hash_original_method = "2BE27D9B96D07A7F769CE0AAEC8A3019", hash_generated_method = "7B26DA2FEB2DBF8FFC1600268CE3DCB1")
    public int get(int index) {
        addTaint(index);
        int varDE43819065CB28B552F19C596ACE8947_789719460 = (mUids[index]);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981826064 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1981826064;
        // ---------- Original Method ----------
        //return mUids[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.899 -0400", hash_original_method = "FEFE1B40777B5F58606593D185335D3A", hash_generated_method = "1EAEB237ED25FBCAA4FB93E520500649")
    public void clear() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.900 -0400", hash_original_method = "2F8EB035FA41CD52820ED0B16262B2FB", hash_generated_method = "14FC433526316B8D71A0A632A835C05D")
    public boolean diff(WorkSource other) {
        addTaint(other.getTaint());
        int N = mNum;
    if(N != other.mNum)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_143648117 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_364647137 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_364647137;
        } //End block
        final int[] uids1 = mUids;
        final int[] uids2 = other.mUids;
for(int i=0;i<N;i++)
        {
    if(uids1[i] != uids2[i])            
            {
                boolean varB326B5062B2F0E69046810717534CB09_1266991657 = (true);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1901051114 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1901051114;
            } //End block
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_2137179436 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1234025220 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1234025220;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.900 -0400", hash_original_method = "0302228CCB49F7DB617DC3822F50D404", hash_generated_method = "0F36242A985A561E721DB568C000ADC7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.901 -0400", hash_original_method = "7924E91892F2F47DFBA42DC07794F83E", hash_generated_method = "78EFCF29562F90693664726E525F5973")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.902 -0400", hash_original_method = "7CA4549360AB4144F4EE2A696452CCBF", hash_generated_method = "2E4BC9E6DA25081D90920A79AF38422D")
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
WorkSource[] var69C1831EE4720879730C65B2CE39ABC2_170835226 =                 diffs;
                var69C1831EE4720879730C65B2CE39ABC2_170835226.addTaint(taint);
                return var69C1831EE4720879730C65B2CE39ABC2_170835226;
            } //End block
WorkSource[] var540C13E9E156B687226421B24F2DF178_1705049198 =             null;
            var540C13E9E156B687226421B24F2DF178_1705049198.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1705049198;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.902 -0400", hash_original_method = "8F95FC70B656D084C5E20FAE69C56CE9", hash_generated_method = "A4B09E539231A07FB5605D76BE18F16A")
    public boolean add(WorkSource other) {
        addTaint(other.getTaint());
        synchronized
(sTmpWorkSource)        {
            boolean var237E08BF78304A26A5118BE477DFD479_1809867147 = (updateLocked(other, false, false));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_442416760 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_442416760;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //return updateLocked(other, false, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.903 -0400", hash_original_method = "3C62D026004765F6E3FE84798605B705", hash_generated_method = "1D255FBC5A8012FC57C4B9F35F2D24D3")
    public WorkSource addReturningNewbs(WorkSource other) {
        addTaint(other.getTaint());
        synchronized
(sTmpWorkSource)        {
            sNewbWork = null;
            updateLocked(other, false, true);
WorkSource var58A621AD92B821B849DEFCA427B300B1_1841001280 =             sNewbWork;
            var58A621AD92B821B849DEFCA427B300B1_1841001280.addTaint(taint);
            return var58A621AD92B821B849DEFCA427B300B1_1841001280;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sNewbWork = null;
            //updateLocked(other, false, true);
            //return sNewbWork;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.904 -0400", hash_original_method = "4279F5B1CF7891D9D61E24583D3B3149", hash_generated_method = "1AE4D6F1545F52E3FB424C85E55C73FB")
    public boolean add(int uid) {
        synchronized
(sTmpWorkSource)        {
            sTmpWorkSource.mUids[0] = uid;
            boolean varE99FB989667A43EEE38DCDDD4E4D43B3_1203472583 = (updateLocked(sTmpWorkSource, false, false));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_891253782 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_891253782;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sTmpWorkSource.mUids[0] = uid;
            //return updateLocked(sTmpWorkSource, false, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.905 -0400", hash_original_method = "6E5D478DFA5CD5B5102A5F18DB42CF54", hash_generated_method = "B5B6CB13E5C8DF479153056A7AE4B36F")
    public WorkSource addReturningNewbs(int uid) {
        synchronized
(sTmpWorkSource)        {
            sNewbWork = null;
            sTmpWorkSource.mUids[0] = uid;
            updateLocked(sTmpWorkSource, false, true);
WorkSource var58A621AD92B821B849DEFCA427B300B1_699677174 =             sNewbWork;
            var58A621AD92B821B849DEFCA427B300B1_699677174.addTaint(taint);
            return var58A621AD92B821B849DEFCA427B300B1_699677174;
        } //End block
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sNewbWork = null;
            //sTmpWorkSource.mUids[0] = uid;
            //updateLocked(sTmpWorkSource, false, true);
            //return sNewbWork;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.907 -0400", hash_original_method = "9E40782544207F8788FDA35D02E6FE4F", hash_generated_method = "B749C6FE64F6CD35EAD0592DFB7C8D80")
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
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_2897333 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509542679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509542679;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.909 -0400", hash_original_method = "34E034689DDCE68A5D27EE33789EB9C2", hash_generated_method = "49C2D83B3877A958CF4B95050F675D06")
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
        boolean var8977DFAC2F8E04CB96E66882235F5ABA_325906891 = (changed);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_122596103 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_122596103;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.910 -0400", hash_original_method = "E8ED9AF8451B0D2EC41EDBDBB476EE69", hash_generated_method = "CE7EDB869AF3E643B1197828FBC4EAE8")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.911 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7F348BD175DD20F7650FD44F99E6586A")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_25137625 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509006852 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1509006852;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.911 -0400", hash_original_method = "69D1EA184FE758709BC28AF0EDE2AA21", hash_generated_method = "5F09EAF7E01851276CB975FD08DA122B")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.911 -0400", hash_original_field = "BA27BF38D3D82A5155F46269BC4D8A25", hash_generated_field = "AA8D498AF94840F5BEE625F2A0A49393")

    static final WorkSource sTmpWorkSource = new WorkSource(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.912 -0400", hash_original_field = "EC546D444E8E4921F1FBFBDF842DA624", hash_generated_field = "FB46B752A7E983AAF6CE799134A085F8")

    static WorkSource sNewbWork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.912 -0400", hash_original_field = "532D9BF1C1FD87F06BA4D428C5AF4B54", hash_generated_field = "05AD48EE2A9CAE7DE8142D70F4AB9C4F")

    static WorkSource sGoneWork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:33.912 -0400", hash_original_field = "84CCBAA21E7B3524C16103FCC24A43F9", hash_generated_field = "54615A019D4B817EB6436269428289F0")

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

