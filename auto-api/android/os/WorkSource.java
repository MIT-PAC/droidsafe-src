package android.os;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;

public class WorkSource implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.451 -0400", hash_original_field = "1B2924E0CDC894FEA7E3856870275E70", hash_generated_field = "95F99CF2E70DB79AD069A36B506646F2")

    int mNum;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.451 -0400", hash_original_field = "BAB32F5501A71BA4F005B5ED6F9F8852", hash_generated_field = "B112C188ED4E9EAAFE4ADD6E54143C39")

    int[] mUids;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.451 -0400", hash_original_method = "6347D93E04E74669648A802B7921C1D5", hash_generated_method = "34579F464897EDC33F63C29271A0F20D")
    public  WorkSource() {
        mNum = 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.452 -0400", hash_original_method = "B6F0D388FBB618146ABF158DEC8410C2", hash_generated_method = "2B2CBDD7050CD0D2B280BEFC95F6F92D")
    public  WorkSource(WorkSource orig) {
        {
            mNum = 0;
        } 
        mNum = orig.mNum;
        {
            mUids = orig.mUids.clone();
        } 
        {
            mUids = null;
        } 
        
        
            
            
        
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.452 -0400", hash_original_method = "98AF9D8E14FDBDB8400169325402879B", hash_generated_method = "F6CE4DF01FE9468953E5D5394F6AB656")
    public  WorkSource(int uid) {
        mNum = 1;
        mUids = new int[] { uid, 0 };
        addTaint(uid);
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.453 -0400", hash_original_method = "01CB17D53B35B98697D0BEFEE05C5A5F", hash_generated_method = "CE554C44E884E79AE7BC84A4662B79EE")
      WorkSource(Parcel in) {
        mNum = in.readInt();
        mUids = in.createIntArray();
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.454 -0400", hash_original_method = "FA15A7D9EE41DC68B6DF2C6C4250D26C", hash_generated_method = "B7C66B4B4CD30AA50A635B997C8519A3")
    public int size() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370521782 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_370521782;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.454 -0400", hash_original_method = "2BE27D9B96D07A7F769CE0AAEC8A3019", hash_generated_method = "16325A26267F1CFC70B4C1F395D35799")
    public int get(int index) {
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_383279622 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_383279622;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.454 -0400", hash_original_method = "FEFE1B40777B5F58606593D185335D3A", hash_generated_method = "1EAEB237ED25FBCAA4FB93E520500649")
    public void clear() {
        mNum = 0;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.455 -0400", hash_original_method = "2F8EB035FA41CD52820ED0B16262B2FB", hash_generated_method = "942DC45A7BD3830136A8A073E825DF9A")
    public boolean diff(WorkSource other) {
        int N = mNum;
        final int[] uids1 = mUids;
        final int[] uids2 = other.mUids;
        {
            int i = 0;
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1568482517 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1568482517;
        
        
        
            
        
        
        
        
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.455 -0400", hash_original_method = "0302228CCB49F7DB617DC3822F50D404", hash_generated_method = "1C9DD11F7FBA5A43E0FA65F5B6D485F6")
    public void set(WorkSource other) {
        {
            mNum = 0;
        } 
        mNum = other.mNum;
        {
            {
                System.arraycopy(other.mUids, 0, mUids, 0, mNum);
            } 
            {
                mUids = other.mUids.clone();
            } 
        } 
        {
            mUids = null;
        } 
        
        
            
            
        
        
        
            
                
            
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.456 -0400", hash_original_method = "7924E91892F2F47DFBA42DC07794F83E", hash_generated_method = "43B6F6A796D183939A9CD97942DF4639")
    public void set(int uid) {
        mNum = 1;
        mUids = new int[2];
        mUids[0] = uid;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.457 -0400", hash_original_method = "7CA4549360AB4144F4EE2A696452CCBF", hash_generated_method = "6E299E7210EE947243D120732855083B")
    public WorkSource[] setReturningDiffs(WorkSource other) {
        WorkSource[] varB4EAC82CA7396A68D541C85D26508E83_1985392344 = null; 
        WorkSource[] varB4EAC82CA7396A68D541C85D26508E83_1020866987 = null; 
        {
            sNewbWork = null;
            sGoneWork = null;
            updateLocked(other, true, true);
            {
                WorkSource[] diffs = new WorkSource[2];
                diffs[0] = sNewbWork;
                diffs[1] = sGoneWork;
                varB4EAC82CA7396A68D541C85D26508E83_1985392344 = diffs;
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1020866987 = null;
        } 
        addTaint(other.getTaint());
        WorkSource[] varA7E53CE21691AB073D9660D615818899_1056253449; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1056253449 = varB4EAC82CA7396A68D541C85D26508E83_1985392344;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1056253449 = varB4EAC82CA7396A68D541C85D26508E83_1020866987;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1056253449.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1056253449;
        
        
            
            
            
            
                
                
                
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.457 -0400", hash_original_method = "8F95FC70B656D084C5E20FAE69C56CE9", hash_generated_method = "FAC96EBEAA2F25C440B42C009A93AF74")
    public boolean add(WorkSource other) {
        {
            boolean varC9CC0550B53A4704EEB106ABB66202CD_1721250670 = (updateLocked(other, false, false));
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1436226796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1436226796;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.458 -0400", hash_original_method = "3C62D026004765F6E3FE84798605B705", hash_generated_method = "1B2E2B4F3C0CCA1D8D80751DDD08284D")
    public WorkSource addReturningNewbs(WorkSource other) {
        WorkSource varB4EAC82CA7396A68D541C85D26508E83_623238090 = null; 
        {
            sNewbWork = null;
            updateLocked(other, false, true);
            varB4EAC82CA7396A68D541C85D26508E83_623238090 = sNewbWork;
        } 
        addTaint(other.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_623238090.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_623238090;
        
        
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.459 -0400", hash_original_method = "4279F5B1CF7891D9D61E24583D3B3149", hash_generated_method = "49C612889AA3A77493F56DB821626CC8")
    public boolean add(int uid) {
        {
            sTmpWorkSource.mUids[0] = uid;
            boolean varAC1E11671A2944B5AF8331CDFD6C8F9E_230961224 = (updateLocked(sTmpWorkSource, false, false));
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_955925185 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_955925185;
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.461 -0400", hash_original_method = "6E5D478DFA5CD5B5102A5F18DB42CF54", hash_generated_method = "91AEB7FEFC119B487DEACB4AF6E8FACA")
    public WorkSource addReturningNewbs(int uid) {
        WorkSource varB4EAC82CA7396A68D541C85D26508E83_1788797513 = null; 
        {
            sNewbWork = null;
            sTmpWorkSource.mUids[0] = uid;
            updateLocked(sTmpWorkSource, false, true);
            varB4EAC82CA7396A68D541C85D26508E83_1788797513 = sNewbWork;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1788797513.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1788797513;
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.462 -0400", hash_original_method = "9E40782544207F8788FDA35D02E6FE4F", hash_generated_method = "731F0CA06F3CB1A4D1BD5BEE86A229A2")
    public boolean remove(WorkSource other) {
        int N1 = mNum;
        final int[] uids1 = mUids;
        final int N2 = other.mNum;
        final int[] uids2 = other.mUids;
        boolean changed = false;
        int i1 = 0;
        {
            int i2 = 0;
            {
                {
                    System.arraycopy(uids1, i1+1, uids1, i1, N1-i1);
                } 
            } 
        } 
        mNum = N1;
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1573465747 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1573465747;
        
        
        
        
        
        
        
        
            
                
                
            
            
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.464 -0400", hash_original_method = "34E034689DDCE68A5D27EE33789EB9C2", hash_generated_method = "6408D2ABFB584E551DF27175DAF9C30A")
    private boolean updateLocked(WorkSource other, boolean set, boolean returnNewbs) {
        int N1 = mNum;
        int[] uids1 = mUids;
        final int N2 = other.mNum;
        final int[] uids2 = other.mUids;
        boolean changed = false;
        int i1 = 0;
        {
            int i2 = 0;
            {
                {
                    changed = true;
                    {
                        uids1 = new int[4];
                        uids1[0] = uids2[i2];
                    } 
                    {
                        int[] newuids = new int[(uids1.length*3)/2];
                        System.arraycopy(uids1, 0, newuids, 0, i1);
                        System.arraycopy(uids1, i1, newuids, i1+1, N1-i1);
                        uids1 = newuids;
                        uids1[i1] = uids2[i2];
                    } 
                    {
                        System.arraycopy(uids1, i1, uids1, i1+1, N1-i1);
                        uids1[i1] = uids2[i2];
                    } 
                    {
                        {
                            sNewbWork = new WorkSource(uids2[i2]);
                        } 
                        {
                            sNewbWork.addLocked(uids2[i2]);
                        } 
                    } 
                } 
                {
                    {
                        int start = i1;
                        {
                            {
                                sGoneWork = new WorkSource(uids1[i1]);
                            } 
                            {
                                sGoneWork.addLocked(uids1[i1]);
                            } 
                        } 
                        {
                            System.arraycopy(uids1, i1, uids1, start, i1-start);
                            N1 -= i1-start;
                            i1 = start;
                        } 
                    } 
                } 
            } 
        } 
        mNum = N1;
        mUids = uids1;
        addTaint(other.getTaint());
        addTaint(set);
        addTaint(returnNewbs);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1120900482 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1120900482;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.464 -0400", hash_original_method = "E8ED9AF8451B0D2EC41EDBDBB476EE69", hash_generated_method = "1BB3249CF9083B2FB3F2147F833FD17D")
    private void addLocked(int uid) {
        {
            mUids = new int[4];
            mUids[0] = uid;
            mNum = 1;
        } 
        {
            int[] newuids = new int[(mNum*3)/2];
            System.arraycopy(mUids, 0, newuids, 0, mNum);
            mUids = newuids;
        } 
        mUids[mNum] = uid;
        
        
            
            
            
            
        
        
            
            
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.465 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "66CF402C1AC9465ABEE574C1C0AEC852")
    @Override
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298678166 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_298678166;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.465 -0400", hash_original_method = "69D1EA184FE758709BC28AF0EDE2AA21", hash_generated_method = "D36CFE4D17370B8DA9D2845BDF895235")
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNum);
        dest.writeIntArray(mUids);
        addTaint(dest.getTaint());
        addTaint(flags);
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.465 -0400", hash_original_field = "BA27BF38D3D82A5155F46269BC4D8A25", hash_generated_field = "AA8D498AF94840F5BEE625F2A0A49393")

    static final WorkSource sTmpWorkSource = new WorkSource(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.466 -0400", hash_original_field = "EC546D444E8E4921F1FBFBDF842DA624", hash_generated_field = "FB46B752A7E983AAF6CE799134A085F8")

    static WorkSource sNewbWork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.466 -0400", hash_original_field = "532D9BF1C1FD87F06BA4D428C5AF4B54", hash_generated_field = "05AD48EE2A9CAE7DE8142D70F4AB9C4F")

    static WorkSource sGoneWork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:43.466 -0400", hash_original_field = "84CCBAA21E7B3524C16103FCC24A43F9", hash_generated_field = "54615A019D4B817EB6436269428289F0")

    public static final Parcelable.Creator<WorkSource> CREATOR
            = new Parcelable.Creator<WorkSource>() {
        public WorkSource createFromParcel(Parcel in) {
            return new WorkSource(in);
        }
        public WorkSource[] newArray(int size) {
            return new WorkSource[size];
        }
    };
    
    public WorkSource createFromParcel(Parcel in) {
            return new WorkSource(in);
        }
    
    
    public WorkSource[] newArray(int size) {
            return new WorkSource[size];
        }
    
}

