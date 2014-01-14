package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public class WorkSource implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.533 -0500", hash_original_field = "92DF17FEEC783F6E98B6D93E0935841C", hash_generated_field = "AA8D498AF94840F5BEE625F2A0A49393")

    static final WorkSource sTmpWorkSource = new WorkSource(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.535 -0500", hash_original_field = "C09F9054A0AF58D746969EF4718EA503", hash_generated_field = "FB46B752A7E983AAF6CE799134A085F8")

    static WorkSource sNewbWork;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.537 -0500", hash_original_field = "A2DEBE6FDBF9C8575E50004F0D77D80D", hash_generated_field = "05AD48EE2A9CAE7DE8142D70F4AB9C4F")

    static WorkSource sGoneWork;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.872 -0400", hash_original_field = "84CCBAA21E7B3524C16103FCC24A43F9", hash_generated_field = "54615A019D4B817EB6436269428289F0")

    public static final Parcelable.Creator<WorkSource> CREATOR
            = new Parcelable.Creator<WorkSource>() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.588 -0500", hash_original_method = "15DC4ADF84BC50464361AC661C12C0D9", hash_generated_method = "B1A6C98EC67832DD002B1B97BB857AB8")
        
public WorkSource createFromParcel(Parcel in) {
            return new WorkSource(in);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.590 -0500", hash_original_method = "45F54F9C412DC844777FD5C44253F064", hash_generated_method = "C44D760F0901EAF99E96950805ACE0B1")
        
public WorkSource[] newArray(int size) {
            return new WorkSource[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.528 -0500", hash_original_field = "95F99CF2E70DB79AD069A36B506646F2", hash_generated_field = "95F99CF2E70DB79AD069A36B506646F2")

    int mNum;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.531 -0500", hash_original_field = "B112C188ED4E9EAAFE4ADD6E54143C39", hash_generated_field = "B112C188ED4E9EAAFE4ADD6E54143C39")

    int[] mUids;

    /**
     * Create an empty work source.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.540 -0500", hash_original_method = "6347D93E04E74669648A802B7921C1D5", hash_generated_method = "4E7EA45BA0A36F9382B93B520D4AEA66")
    
public WorkSource() {
        mNum = 0;
    }

    /**
     * Create a new WorkSource that is a copy of an existing one.
     * If <var>orig</var> is null, an empty WorkSource is created.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.543 -0500", hash_original_method = "B6F0D388FBB618146ABF158DEC8410C2", hash_generated_method = "8EC19A50623036B687B4171603518257")
    
public WorkSource(WorkSource orig) {
        if (orig == null) {
            mNum = 0;
            return;
        }
        mNum = orig.mNum;
        if (orig.mUids != null) {
            mUids = orig.mUids.clone();
        } else {
            mUids = null;
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.545 -0500", hash_original_method = "98AF9D8E14FDBDB8400169325402879B", hash_generated_method = "FA46108A99A3013F7C8DE0462AF9DC98")
    
public WorkSource(int uid) {
        mNum = 1;
        mUids = new int[] { uid, 0 };
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.547 -0500", hash_original_method = "01CB17D53B35B98697D0BEFEE05C5A5F", hash_generated_method = "01CB17D53B35B98697D0BEFEE05C5A5F")
    
WorkSource(Parcel in) {
        mNum = in.readInt();
        mUids = in.createIntArray();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.549 -0500", hash_original_method = "FA15A7D9EE41DC68B6DF2C6C4250D26C", hash_generated_method = "BBA397DEA2ED8AE06615F36EA6436080")
    
public int size() {
        return mNum;
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.551 -0500", hash_original_method = "2BE27D9B96D07A7F769CE0AAEC8A3019", hash_generated_method = "7D5AEA3260FB38A576CE71FD6B892EB6")
    
public int get(int index) {
        return mUids[index];
    }

    /**
     * Clear this WorkSource to be empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.553 -0500", hash_original_method = "FEFE1B40777B5F58606593D185335D3A", hash_generated_method = "8FFBB5AFF6C1B48BDA2E2D9101D20C7A")
    
public void clear() {
        mNum = 0;
    }

    /**
     * Compare this WorkSource with another.
     * @param other The WorkSource to compare against.
     * @return If there is a difference, true is returned.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.556 -0500", hash_original_method = "2F8EB035FA41CD52820ED0B16262B2FB", hash_generated_method = "D7BCE97E898F8816BB517278F6C61E70")
    
public boolean diff(WorkSource other) {
        int N = mNum;
        if (N != other.mNum) {
            return true;
        }
        final int[] uids1 = mUids;
        final int[] uids2 = other.mUids;
        for (int i=0; i<N; i++) {
            if (uids1[i] != uids2[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Replace the current contents of this work source with the given
     * work source.  If <var>other</var> is null, the current work source
     * will be made empty.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.558 -0500", hash_original_method = "0302228CCB49F7DB617DC3822F50D404", hash_generated_method = "1C9FC984F5D8779C72B02AC57F227ED9")
    
public void set(WorkSource other) {
        if (other == null) {
            mNum = 0;
            return;
        }
        mNum = other.mNum;
        if (other.mUids != null) {
            if (mUids != null && mUids.length >= mNum) {
                System.arraycopy(other.mUids, 0, mUids, 0, mNum);
            } else {
                mUids = other.mUids.clone();
            }
        } else {
            mUids = null;
        }
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.561 -0500", hash_original_method = "7924E91892F2F47DFBA42DC07794F83E", hash_generated_method = "1F98821148EA42E4BEB37FF360612333")
    
public void set(int uid) {
        mNum = 1;
        if (mUids == null) mUids = new int[2];
        mUids[0] = uid;
    }

    /** @hide */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.563 -0500", hash_original_method = "7CA4549360AB4144F4EE2A696452CCBF", hash_generated_method = "3C1F0E8BD99C0BAE23DBC6A6B186C219")
    
public WorkSource[] setReturningDiffs(WorkSource other) {
        synchronized (sTmpWorkSource) {
            sNewbWork = null;
            sGoneWork = null;
            updateLocked(other, true, true);
            if (sNewbWork != null || sGoneWork != null) {
                WorkSource[] diffs = new WorkSource[2];
                diffs[0] = sNewbWork;
                diffs[1] = sGoneWork;
                return diffs;
            }
            return null;
        }
    }

    /**
     * Merge the contents of <var>other</var> WorkSource in to this one.
     *
     * @param other The other WorkSource whose contents are to be merged.
     * @return Returns true if any new sources were added.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.565 -0500", hash_original_method = "8F95FC70B656D084C5E20FAE69C56CE9", hash_generated_method = "4D020F8E048BBBAD0CFCC7AE746BF3E2")
    
public boolean add(WorkSource other) {
        synchronized (sTmpWorkSource) {
            return updateLocked(other, false, false);
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.567 -0500", hash_original_method = "3C62D026004765F6E3FE84798605B705", hash_generated_method = "658CCB4AA1CDC494BFC6106BAAA40EE0")
    
public WorkSource addReturningNewbs(WorkSource other) {
        synchronized (sTmpWorkSource) {
            sNewbWork = null;
            updateLocked(other, false, true);
            return sNewbWork;
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.569 -0500", hash_original_method = "4279F5B1CF7891D9D61E24583D3B3149", hash_generated_method = "9533150DD2957494237C3F4ADA0B5DEC")
    
public boolean add(int uid) {
        synchronized (sTmpWorkSource) {
            sTmpWorkSource.mUids[0] = uid;
            return updateLocked(sTmpWorkSource, false, false);
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.571 -0500", hash_original_method = "6E5D478DFA5CD5B5102A5F18DB42CF54", hash_generated_method = "98C8F9FBF1B79B8A69FEA8294E2638CF")
    
public WorkSource addReturningNewbs(int uid) {
        synchronized (sTmpWorkSource) {
            sNewbWork = null;
            sTmpWorkSource.mUids[0] = uid;
            updateLocked(sTmpWorkSource, false, true);
            return sNewbWork;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.574 -0500", hash_original_method = "9E40782544207F8788FDA35D02E6FE4F", hash_generated_method = "DF5241B2AED5996BBC20E7E1905F6070")
    
public boolean remove(WorkSource other) {
        int N1 = mNum;
        final int[] uids1 = mUids;
        final int N2 = other.mNum;
        final int[] uids2 = other.mUids;
        boolean changed = false;
        int i1 = 0;
        for (int i2=0; i2<N2 && i1<N1; i2++) {
            if (uids2[i2] == uids1[i1]) {
                N1--;
                if (i1 < N1) System.arraycopy(uids1, i1+1, uids1, i1, N1-i1);
            }
            while (i1 < N1 && uids2[i2] > uids1[i1]) {
                i1++;
            }
        }

        mNum = N1;

        return changed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.577 -0500", hash_original_method = "34E034689DDCE68A5D27EE33789EB9C2", hash_generated_method = "5512EFB0DA8CD027C4FD8432344BAA39")
    
private boolean updateLocked(WorkSource other, boolean set, boolean returnNewbs) {
        int N1 = mNum;
        int[] uids1 = mUids;
        final int N2 = other.mNum;
        final int[] uids2 = other.mUids;
        boolean changed = false;
        int i1 = 0;
        for (int i2=0; i2<N2; i2++) {
            if (i1 >= N1 || uids2[i2] < uids1[i1]) {
                // Need to insert a new uid.
                changed = true;
                if (uids1 == null) {
                    uids1 = new int[4];
                    uids1[0] = uids2[i2];
                } else if (i1 >= uids1.length) {
                    int[] newuids = new int[(uids1.length*3)/2];
                    if (i1 > 0) System.arraycopy(uids1, 0, newuids, 0, i1);
                    if (i1 < N1) System.arraycopy(uids1, i1, newuids, i1+1, N1-i1);
                    uids1 = newuids;
                    uids1[i1] = uids2[i2];
                } else {
                    if (i1 < N1) System.arraycopy(uids1, i1, uids1, i1+1, N1-i1);
                    uids1[i1] = uids2[i2];
                }
                if (returnNewbs) {
                    if (sNewbWork == null) {
                        sNewbWork = new WorkSource(uids2[i2]);
                    } else {
                        sNewbWork.addLocked(uids2[i2]);
                    }
                }
                N1++;
                i1++;
            } else {
                if (!set) {
                    // Skip uids that already exist or are not in 'other'.
                    do {
                        i1++;
                    } while (i1 < N1 && uids2[i2] >= uids1[i1]);
                } else {
                    // Remove any uids that don't exist in 'other'.
                    int start = i1;
                    while (i1 < N1 && uids2[i2] > uids1[i1]) {
                        if (sGoneWork == null) {
                            sGoneWork = new WorkSource(uids1[i1]);
                        } else {
                            sGoneWork.addLocked(uids1[i1]);
                        }
                        i1++;
                    }
                    if (start < i1) {
                        System.arraycopy(uids1, i1, uids1, start, i1-start);
                        N1 -= i1-start;
                        i1 = start;
                    }
                    // If there is a matching uid, skip it.
                    if (i1 < N1 && uids2[i1] == uids1[i1]) {
                        i1++;
                    }
                }
            }
        }

        mNum = N1;
        mUids = uids1;

        return changed;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.580 -0500", hash_original_method = "E8ED9AF8451B0D2EC41EDBDBB476EE69", hash_generated_method = "F94CDBE8C163C76FB6B259C5873B4C40")
    
private void addLocked(int uid) {
        if (mUids == null) {
            mUids = new int[4];
            mUids[0] = uid;
            mNum = 1;
            return;
        }
        if (mNum >= mUids.length) {
            int[] newuids = new int[(mNum*3)/2];
            System.arraycopy(mUids, 0, newuids, 0, mNum);
            mUids = newuids;
        }

        mUids[mNum] = uid;
        mNum++;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.582 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:38.584 -0500", hash_original_method = "69D1EA184FE758709BC28AF0EDE2AA21", hash_generated_method = "D4746D7AD8A3A4FD2CEEDE5CEFEDE25E")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mNum);
        dest.writeIntArray(mUids);
    }
    // orphaned legacy method
    public WorkSource createFromParcel(Parcel in) {
            return new WorkSource(in);
        }
    
    // orphaned legacy method
    public WorkSource[] newArray(int size) {
            return new WorkSource[size];
        }
    
}

