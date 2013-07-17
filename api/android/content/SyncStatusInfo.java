package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;

public class SyncStatusInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.804 -0400", hash_original_field = "A6E80D6465C4F39AC517335BD9346D44", hash_generated_field = "A9902B6EC2628AF68CD4117B511E65F0")

    public int authorityId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.804 -0400", hash_original_field = "072EF0DEB7B5649E8D92095E16548F4B", hash_generated_field = "5D7384269F724CBADC7F9E403A55C48C")

    public long totalElapsedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.804 -0400", hash_original_field = "5C3F9AEC1EEC6A8D58D0F35EBBB148ED", hash_generated_field = "45FA19DB50FC1AFC3AFA9748BF15F97C")

    public int numSyncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.804 -0400", hash_original_field = "7960319A52EA176C2E46FB1A188DF721", hash_generated_field = "297E9C7A23835F11C9957370D1ED8A75")

    public int numSourcePoll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.804 -0400", hash_original_field = "65AD40135E6AC0A04BFDAE0720755F59", hash_generated_field = "F9A2FDC9C88FCD806F4525422EF10BF1")

    public int numSourceServer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.804 -0400", hash_original_field = "EEEF2E9CE1829E04CD1CCD49E93B4A03", hash_generated_field = "B0F48BB93F3B5FE342F20AE3FB948F58")

    public int numSourceLocal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.804 -0400", hash_original_field = "EFE172CBF9DA51B5C518E95BD4D6ADD3", hash_generated_field = "8CF18E48FF0658748266846505863C84")

    public int numSourceUser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.804 -0400", hash_original_field = "3DE03DF8466AB4181915B3E119165C5D", hash_generated_field = "12AEAE23203E6890D332E062563C0CF9")

    public int numSourcePeriodic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.804 -0400", hash_original_field = "9E00B89B90E2C6619D333C68F79C172B", hash_generated_field = "D1DD70D28F5DEB94EE2F4546FE50674D")

    public long lastSuccessTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.805 -0400", hash_original_field = "A0536E5A332D10C1056BC83AB6BDB9EE", hash_generated_field = "FA28C0FBC143DEA0A6029269A23776E9")

    public int lastSuccessSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.805 -0400", hash_original_field = "4198638D1E0CD82D03DB43CE9B1A3930", hash_generated_field = "6AFA009245A986652AE38EE5259B6ED5")

    public long lastFailureTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.805 -0400", hash_original_field = "DC729020C8D4C52C7845A7987D20F3ED", hash_generated_field = "073927D6239FA4A9D397F9C6F6FB3874")

    public int lastFailureSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.805 -0400", hash_original_field = "7596EC8D2962CDE8243E8FED37600135", hash_generated_field = "29147D591F50D9505557E1B4326C0CB8")

    public String lastFailureMesg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.805 -0400", hash_original_field = "C4B1A7F06E1C04E56B1B464F72897662", hash_generated_field = "A4E8436F857C29CAAE565EB026B82BBE")

    public long initialFailureTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.805 -0400", hash_original_field = "7C6C2E5D48AB37A007CBF70D3EA25FA4", hash_generated_field = "C4E7D79FB8FE79DA47A44B5030EA64A2")

    public boolean pending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.805 -0400", hash_original_field = "30DB597822C6E06C6737052260426F45", hash_generated_field = "906CA71C20CC6AD4C27A4C720CE75383")

    public boolean initialize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.805 -0400", hash_original_field = "071AEBC5CEC33253679B86192112D6DB", hash_generated_field = "191FD4C3F411078AF38A8B10F0164DAD")

    public ArrayList<Long> periodicSyncTimes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.806 -0400", hash_original_method = "A601236BC9972CD1DA6DEFC9BDCCDDF9", hash_generated_method = "BB787ACFE6D55BF74960948674FE5AEC")
      SyncStatusInfo(int authorityId) {
        this.authorityId = authorityId;
        // ---------- Original Method ----------
        //this.authorityId = authorityId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.810 -0400", hash_original_method = "48BE1C9789126DF2BDCDE38D758F27DD", hash_generated_method = "5C6FD6F693A1FD0582E03F8012F5B23F")
      SyncStatusInfo(Parcel parcel) {
        int version = parcel.readInt();
        if(version != VERSION && version != 1)        
        {
        } //End block
        authorityId = parcel.readInt();
        totalElapsedTime = parcel.readLong();
        numSyncs = parcel.readInt();
        numSourcePoll = parcel.readInt();
        numSourceServer = parcel.readInt();
        numSourceLocal = parcel.readInt();
        numSourceUser = parcel.readInt();
        lastSuccessTime = parcel.readLong();
        lastSuccessSource = parcel.readInt();
        lastFailureTime = parcel.readLong();
        lastFailureSource = parcel.readInt();
        lastFailureMesg = parcel.readString();
        initialFailureTime = parcel.readLong();
        pending = parcel.readInt() != 0;
        initialize = parcel.readInt() != 0;
        if(version == 1)        
        {
            periodicSyncTimes = null;
        } //End block
        else
        {
            int N = parcel.readInt();
            if(N < 0)            
            {
                periodicSyncTimes = null;
            } //End block
            else
            {
                periodicSyncTimes = new ArrayList<Long>();
for(int i=0;i<N;i++)
                {
                    periodicSyncTimes.add(parcel.readLong());
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.812 -0400", hash_original_method = "7E33E8226B73A02621B31754517607B3", hash_generated_method = "63C73553ECB7047E4F838377AD4C75EB")
    public int getLastFailureMesgAsInt(int def) {
        addTaint(def);
        try 
        {
            if(lastFailureMesg != null)            
            {
                int var55EBAB0FC4F003568978448002173F2F_23148324 = (Integer.parseInt(lastFailureMesg));
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694511151 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694511151;
            } //End block
        } //End block
        catch (NumberFormatException e)
        {
            Log.d(TAG, "error parsing lastFailureMesg of " + lastFailureMesg, e);
        } //End block
        int var4ED9407630EB1000C0F6B63842DEFA7D_740196683 = (def);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716692819 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_716692819;
        // ---------- Original Method ----------
        //try {
            //if (lastFailureMesg != null) {
                //return Integer.parseInt(lastFailureMesg);
            //}
        //} catch (NumberFormatException e) {
            //Log.d(TAG, "error parsing lastFailureMesg of " + lastFailureMesg, e);
        //}
        //return def;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.813 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "C037295706E9C356D00432F03EE84288")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_389396590 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535771779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_535771779;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.814 -0400", hash_original_method = "9461760C81A4DFF607A36CA2D6370E1C", hash_generated_method = "B73DC814B2E25AEEF2DEEAA6B8CD1C80")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeInt(VERSION);
        parcel.writeInt(authorityId);
        parcel.writeLong(totalElapsedTime);
        parcel.writeInt(numSyncs);
        parcel.writeInt(numSourcePoll);
        parcel.writeInt(numSourceServer);
        parcel.writeInt(numSourceLocal);
        parcel.writeInt(numSourceUser);
        parcel.writeLong(lastSuccessTime);
        parcel.writeInt(lastSuccessSource);
        parcel.writeLong(lastFailureTime);
        parcel.writeInt(lastFailureSource);
        parcel.writeString(lastFailureMesg);
        parcel.writeLong(initialFailureTime);
        parcel.writeInt(pending ? 1 : 0);
        parcel.writeInt(initialize ? 1 : 0);
        if(periodicSyncTimes != null)        
        {
            parcel.writeInt(periodicSyncTimes.size());
for(long periodicSyncTime : periodicSyncTimes)
            {
                parcel.writeLong(periodicSyncTime);
            } //End block
        } //End block
        else
        {
            parcel.writeInt(-1);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.815 -0400", hash_original_method = "BB3C22BCE01837AA4BAC40A0B35F8BC2", hash_generated_method = "9155ACA81EB7FC21ED9DB68D6505F41C")
    public void setPeriodicSyncTime(int index, long when) {
        addTaint(when);
        addTaint(index);
        ensurePeriodicSyncTimeSize(index);
        periodicSyncTimes.set(index, when);
        // ---------- Original Method ----------
        //ensurePeriodicSyncTimeSize(index);
        //periodicSyncTimes.set(index, when);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.816 -0400", hash_original_method = "CB3B6F2BD6B69A04BBE5B4B8321ED55E", hash_generated_method = "2A8281D36F44955C2A9A236F83302204")
    private void ensurePeriodicSyncTimeSize(int index) {
        addTaint(index);
        if(periodicSyncTimes == null)        
        {
            periodicSyncTimes = new ArrayList<Long>(0);
        } //End block
        final int requiredSize = index + 1;
        if(periodicSyncTimes.size() < requiredSize)        
        {
for(int i = periodicSyncTimes.size();i < requiredSize;i++)
            {
                periodicSyncTimes.add((long) 0);
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (periodicSyncTimes == null) {
            //periodicSyncTimes = new ArrayList<Long>(0);
        //}
        //final int requiredSize = index + 1;
        //if (periodicSyncTimes.size() < requiredSize) {
            //for (int i = periodicSyncTimes.size(); i < requiredSize; i++) {
                //periodicSyncTimes.add((long) 0);
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.817 -0400", hash_original_method = "E0266DD4F289B692F6E7B79E10E75B20", hash_generated_method = "93E8A3EE5FEF002A9EC7100CC7EED256")
    public long getPeriodicSyncTime(int index) {
        addTaint(index);
        if(periodicSyncTimes == null || periodicSyncTimes.size() < (index + 1))        
        {
            long varCFCD208495D565EF66E7DFF9F98764DA_678816888 = (0);
                        long var0F5264038205EDFB1AC05FBB0E8C5E94_250491414 = getTaintLong();
            return var0F5264038205EDFB1AC05FBB0E8C5E94_250491414;
        } //End block
        long varCF6DE9198A0036FA9FFE77A46BC50C51_2025370796 = (periodicSyncTimes.get(index));
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1962371943 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1962371943;
        // ---------- Original Method ----------
        //if (periodicSyncTimes == null || periodicSyncTimes.size() < (index + 1)) {
            //return 0;
        //}
        //return periodicSyncTimes.get(index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.817 -0400", hash_original_method = "5D5F49D9C483CE201F8BB2B6D37F0FB1", hash_generated_method = "2AB20A703E54688395AB54626C12F81F")
    public void removePeriodicSyncTime(int index) {
        addTaint(index);
        ensurePeriodicSyncTimeSize(index);
        periodicSyncTimes.remove(index);
        // ---------- Original Method ----------
        //ensurePeriodicSyncTimeSize(index);
        //periodicSyncTimes.remove(index);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.818 -0400", hash_original_field = "DCF658CEB87B1871C682CB06BA67C24E", hash_generated_field = "78D7348159FCA08FC47896DADC9A6ECC")

    static final int VERSION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.818 -0400", hash_original_field = "4B899671566F88F7105998C18EA46A1D", hash_generated_field = "4CCB2F73BD98045FB7A49DC531F6A5B0")

    private static final String TAG = "Sync";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:02.818 -0400", hash_original_field = "4B380E2AA31D16D86BF89F8EE0A58282", hash_generated_field = "34F7BA97EC5F779445C9A58D21D7DF7D")

    public static final Creator<SyncStatusInfo> CREATOR = new Creator<SyncStatusInfo>() {
        public SyncStatusInfo createFromParcel(Parcel in) {
            return new SyncStatusInfo(in);
        }

        public SyncStatusInfo[] newArray(int size) {
            return new SyncStatusInfo[size];
        }
    };
    // orphaned legacy method
    public SyncStatusInfo createFromParcel(Parcel in) {
            return new SyncStatusInfo(in);
        }
    
    // orphaned legacy method
    public SyncStatusInfo[] newArray(int size) {
            return new SyncStatusInfo[size];
        }
    
}

