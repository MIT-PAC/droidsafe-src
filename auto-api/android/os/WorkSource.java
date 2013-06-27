package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class WorkSource implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.733 -0400", hash_original_field = "1B2924E0CDC894FEA7E3856870275E70", hash_generated_field = "95F99CF2E70DB79AD069A36B506646F2")

    int mNum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.733 -0400", hash_original_field = "BAB32F5501A71BA4F005B5ED6F9F8852", hash_generated_field = "B112C188ED4E9EAAFE4ADD6E54143C39")

    int[] mUids;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.734 -0400", hash_original_method = "6347D93E04E74669648A802B7921C1D5", hash_generated_method = "34579F464897EDC33F63C29271A0F20D")
    public  WorkSource() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.734 -0400", hash_original_method = "B6F0D388FBB618146ABF158DEC8410C2", hash_generated_method = "2B2CBDD7050CD0D2B280BEFC95F6F92D")
    public  WorkSource(WorkSource orig) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.745 -0400", hash_original_method = "98AF9D8E14FDBDB8400169325402879B", hash_generated_method = "F6CE4DF01FE9468953E5D5394F6AB656")
    public  WorkSource(int uid) {
        mNum = 1;
        mUids = new int[] { uid, 0 };
        addTaint(uid);
        // ---------- Original Method ----------
        //mNum = 1;
        //mUids = new int[] { uid, 0 };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.746 -0400", hash_original_method = "01CB17D53B35B98697D0BEFEE05C5A5F", hash_generated_method = "CE554C44E884E79AE7BC84A4662B79EE")
      WorkSource(Parcel in) {
        mNum = in.readInt();
        mUids = in.createIntArray();
        // ---------- Original Method ----------
        //mNum = in.readInt();
        //mUids = in.createIntArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.746 -0400", hash_original_method = "FA15A7D9EE41DC68B6DF2C6C4250D26C", hash_generated_method = "3122A8E5DF72CAB88C360F5F64B6BB12")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188054422 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_188054422;
        // ---------- Original Method ----------
        //return mNum;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.746 -0400", hash_original_method = "2BE27D9B96D07A7F769CE0AAEC8A3019", hash_generated_method = "2644B0F8144F45929B3D809A8F0E6BE9")
    public int get(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052486091 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052486091;
        // ---------- Original Method ----------
        //return mUids[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.751 -0400", hash_original_method = "FEFE1B40777B5F58606593D185335D3A", hash_generated_method = "1EAEB237ED25FBCAA4FB93E520500649")
    public void clear() {
        mNum = 0;
        // ---------- Original Method ----------
        //mNum = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.751 -0400", hash_original_method = "2F8EB035FA41CD52820ED0B16262B2FB", hash_generated_method = "206F62E14A3768A1D4BCC271BAA0E13A")
    public boolean diff(WorkSource other) {
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
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_121554864 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_121554864;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.752 -0400", hash_original_method = "0302228CCB49F7DB617DC3822F50D404", hash_generated_method = "1C9DD11F7FBA5A43E0FA65F5B6D485F6")
    public void set(WorkSource other) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.758 -0400", hash_original_method = "7924E91892F2F47DFBA42DC07794F83E", hash_generated_method = "43B6F6A796D183939A9CD97942DF4639")
    public void set(int uid) {
        mNum = 1;
        mUids = new int[2];
        mUids[0] = uid;
        // ---------- Original Method ----------
        //mNum = 1;
        //if (mUids == null) mUids = new int[2];
        //mUids[0] = uid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.759 -0400", hash_original_method = "7CA4549360AB4144F4EE2A696452CCBF", hash_generated_method = "80BA5F1C4F2AC4C17EA0F43A8DCED9AD")
    public WorkSource[] setReturningDiffs(WorkSource other) {
        WorkSource[] varB4EAC82CA7396A68D541C85D26508E83_1077533879 = null; //Variable for return #1
        WorkSource[] varB4EAC82CA7396A68D541C85D26508E83_1833087732 = null; //Variable for return #2
        {
            sNewbWork = null;
            sGoneWork = null;
            updateLocked(other, true, true);
            {
                WorkSource[] diffs;
                diffs = new WorkSource[2];
                diffs[0] = sNewbWork;
                diffs[1] = sGoneWork;
                varB4EAC82CA7396A68D541C85D26508E83_1077533879 = diffs;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1833087732 = null;
        } //End block
        addTaint(other.getTaint());
        WorkSource[] varA7E53CE21691AB073D9660D615818899_2032607862; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2032607862 = varB4EAC82CA7396A68D541C85D26508E83_1077533879;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2032607862 = varB4EAC82CA7396A68D541C85D26508E83_1833087732;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2032607862.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2032607862;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.765 -0400", hash_original_method = "8F95FC70B656D084C5E20FAE69C56CE9", hash_generated_method = "129A15D88B5EE783CFF9970D36D5F11E")
    public boolean add(WorkSource other) {
        {
            boolean varC9CC0550B53A4704EEB106ABB66202CD_2696922 = (updateLocked(other, false, false));
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573258231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573258231;
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //return updateLocked(other, false, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.770 -0400", hash_original_method = "3C62D026004765F6E3FE84798605B705", hash_generated_method = "B945126F2E79D5A007A9CA94310A2EAD")
    public WorkSource addReturningNewbs(WorkSource other) {
        WorkSource varB4EAC82CA7396A68D541C85D26508E83_1577963509 = null; //Variable for return #1
        {
            sNewbWork = null;
            updateLocked(other, false, true);
            varB4EAC82CA7396A68D541C85D26508E83_1577963509 = sNewbWork;
        } //End block
        addTaint(other.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1577963509.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1577963509;
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sNewbWork = null;
            //updateLocked(other, false, true);
            //return sNewbWork;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.771 -0400", hash_original_method = "4279F5B1CF7891D9D61E24583D3B3149", hash_generated_method = "7CAABCEAF4B099762534D10314B5CA60")
    public boolean add(int uid) {
        {
            sTmpWorkSource.mUids[0] = uid;
            boolean varAC1E11671A2944B5AF8331CDFD6C8F9E_1337059151 = (updateLocked(sTmpWorkSource, false, false));
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_67949922 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_67949922;
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sTmpWorkSource.mUids[0] = uid;
            //return updateLocked(sTmpWorkSource, false, false);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.777 -0400", hash_original_method = "6E5D478DFA5CD5B5102A5F18DB42CF54", hash_generated_method = "9A7608D27CEEFEE8CBA25D4B447548A4")
    public WorkSource addReturningNewbs(int uid) {
        WorkSource varB4EAC82CA7396A68D541C85D26508E83_1349359008 = null; //Variable for return #1
        {
            sNewbWork = null;
            sTmpWorkSource.mUids[0] = uid;
            updateLocked(sTmpWorkSource, false, true);
            varB4EAC82CA7396A68D541C85D26508E83_1349359008 = sNewbWork;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1349359008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1349359008;
        // ---------- Original Method ----------
        //synchronized (sTmpWorkSource) {
            //sNewbWork = null;
            //sTmpWorkSource.mUids[0] = uid;
            //updateLocked(sTmpWorkSource, false, true);
            //return sNewbWork;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.780 -0400", hash_original_method = "9E40782544207F8788FDA35D02E6FE4F", hash_generated_method = "FA1CAC9146D5EEA498B217ACA0734215")
    public boolean remove(WorkSource other) {
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
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_649786950 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_649786950;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.793 -0400", hash_original_method = "34E034689DDCE68A5D27EE33789EB9C2", hash_generated_method = "3FBDD8C3670905357347ADEE3E4B86A5")
    private boolean updateLocked(WorkSource other, boolean set, boolean returnNewbs) {
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
        addTaint(other.getTaint());
        addTaint(set);
        addTaint(returnNewbs);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1860714325 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1860714325;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.795 -0400", hash_original_method = "E8ED9AF8451B0D2EC41EDBDBB476EE69", hash_generated_method = "84413536F996A2FDFFCB3A6BED63EADB")
    private void addLocked(int uid) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.801 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8A9CF5C534183D1F410CFF9CA1D4714C")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785467987 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1785467987;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.801 -0400", hash_original_method = "69D1EA184FE758709BC28AF0EDE2AA21", hash_generated_method = "D36CFE4D17370B8DA9D2845BDF895235")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNum);
        dest.writeIntArray(mUids);
        addTaint(dest.getTaint());
        addTaint(flags);
        // ---------- Original Method ----------
        //dest.writeInt(mNum);
        //dest.writeIntArray(mUids);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.802 -0400", hash_original_field = "BA27BF38D3D82A5155F46269BC4D8A25", hash_generated_field = "5FB5E9D063B5DF0AC96A8C4475D188AD")

    static WorkSource sTmpWorkSource = new WorkSource(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.802 -0400", hash_original_field = "EC546D444E8E4921F1FBFBDF842DA624", hash_generated_field = "FB46B752A7E983AAF6CE799134A085F8")

    static WorkSource sNewbWork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.802 -0400", hash_original_field = "532D9BF1C1FD87F06BA4D428C5AF4B54", hash_generated_field = "05AD48EE2A9CAE7DE8142D70F4AB9C4F")

    static WorkSource sGoneWork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:28.802 -0400", hash_original_field = "84CCBAA21E7B3524C16103FCC24A43F9", hash_generated_field = "54615A019D4B817EB6436269428289F0")

    public static final Parcelable.Creator<WorkSource> CREATOR
            = new Parcelable.Creator<WorkSource>() {
        public WorkSource createFromParcel(Parcel in) {
            return new WorkSource(in);
        }
        public WorkSource[] newArray(int size) {
            return new WorkSource[size];
        }
    };
}

