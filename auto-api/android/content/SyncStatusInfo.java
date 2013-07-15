package android.content;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import java.util.ArrayList;

public class SyncStatusInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "A6E80D6465C4F39AC517335BD9346D44", hash_generated_field = "A9902B6EC2628AF68CD4117B511E65F0")

    public int authorityId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "072EF0DEB7B5649E8D92095E16548F4B", hash_generated_field = "5D7384269F724CBADC7F9E403A55C48C")

    public long totalElapsedTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "5C3F9AEC1EEC6A8D58D0F35EBBB148ED", hash_generated_field = "45FA19DB50FC1AFC3AFA9748BF15F97C")

    public int numSyncs;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "7960319A52EA176C2E46FB1A188DF721", hash_generated_field = "297E9C7A23835F11C9957370D1ED8A75")

    public int numSourcePoll;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "65AD40135E6AC0A04BFDAE0720755F59", hash_generated_field = "F9A2FDC9C88FCD806F4525422EF10BF1")

    public int numSourceServer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "EEEF2E9CE1829E04CD1CCD49E93B4A03", hash_generated_field = "B0F48BB93F3B5FE342F20AE3FB948F58")

    public int numSourceLocal;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "EFE172CBF9DA51B5C518E95BD4D6ADD3", hash_generated_field = "8CF18E48FF0658748266846505863C84")

    public int numSourceUser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "3DE03DF8466AB4181915B3E119165C5D", hash_generated_field = "12AEAE23203E6890D332E062563C0CF9")

    public int numSourcePeriodic;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "9E00B89B90E2C6619D333C68F79C172B", hash_generated_field = "D1DD70D28F5DEB94EE2F4546FE50674D")

    public long lastSuccessTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "A0536E5A332D10C1056BC83AB6BDB9EE", hash_generated_field = "FA28C0FBC143DEA0A6029269A23776E9")

    public int lastSuccessSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "4198638D1E0CD82D03DB43CE9B1A3930", hash_generated_field = "6AFA009245A986652AE38EE5259B6ED5")

    public long lastFailureTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "DC729020C8D4C52C7845A7987D20F3ED", hash_generated_field = "073927D6239FA4A9D397F9C6F6FB3874")

    public int lastFailureSource;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "7596EC8D2962CDE8243E8FED37600135", hash_generated_field = "29147D591F50D9505557E1B4326C0CB8")

    public String lastFailureMesg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "C4B1A7F06E1C04E56B1B464F72897662", hash_generated_field = "A4E8436F857C29CAAE565EB026B82BBE")

    public long initialFailureTime;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "7C6C2E5D48AB37A007CBF70D3EA25FA4", hash_generated_field = "C4E7D79FB8FE79DA47A44B5030EA64A2")

    public boolean pending;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "30DB597822C6E06C6737052260426F45", hash_generated_field = "906CA71C20CC6AD4C27A4C720CE75383")

    public boolean initialize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.356 -0400", hash_original_field = "071AEBC5CEC33253679B86192112D6DB", hash_generated_field = "191FD4C3F411078AF38A8B10F0164DAD")

    public ArrayList<Long> periodicSyncTimes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.357 -0400", hash_original_method = "A601236BC9972CD1DA6DEFC9BDCCDDF9", hash_generated_method = "BB787ACFE6D55BF74960948674FE5AEC")
      SyncStatusInfo(int authorityId) {
        this.authorityId = authorityId;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.358 -0400", hash_original_method = "48BE1C9789126DF2BDCDE38D758F27DD", hash_generated_method = "4ABBC610CB1340907E29D73DA750462D")
      SyncStatusInfo(Parcel parcel) {
        int version = parcel.readInt();
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
        {
            periodicSyncTimes = null;
        } 
        {
            int N = parcel.readInt();
            {
                periodicSyncTimes = null;
            } 
            {
                periodicSyncTimes = new ArrayList<Long>();
                {
                    int i = 0;
                    {
                        periodicSyncTimes.add(parcel.readLong());
                    } 
                } 
            } 
        } 
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.359 -0400", hash_original_method = "7E33E8226B73A02621B31754517607B3", hash_generated_method = "0B26B2817DE5FCD97B2F7F17148AD58D")
    public int getLastFailureMesgAsInt(int def) {
        try 
        {
            {
                int var561DC7C18702C0DB19E8BC0A90987BBD_318533114 = (Integer.parseInt(lastFailureMesg));
            } 
        } 
        catch (NumberFormatException e)
        {
            Log.d(TAG, "error parsing lastFailureMesg of " + lastFailureMesg, e);
        } 
        addTaint(def);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274536398 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_274536398;
        
        
            
                
            
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.360 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "B7BCF5741930AA8AE74E923AC422DF57")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962513902 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1962513902;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.368 -0400", hash_original_method = "9461760C81A4DFF607A36CA2D6370E1C", hash_generated_method = "2616D5051F4191B95A247703500531E0")
    public void writeToParcel(Parcel parcel, int flags) {
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
        {
            parcel.writeInt(periodicSyncTimes.size());
            {
                Iterator<Long> var137A3BFEF4662131991E3E9E8AB91E39_2066040649 = (periodicSyncTimes).iterator();
                var137A3BFEF4662131991E3E9E8AB91E39_2066040649.hasNext();
                long periodicSyncTime = var137A3BFEF4662131991E3E9E8AB91E39_2066040649.next();
                {
                    parcel.writeLong(periodicSyncTime);
                } 
            } 
        } 
        {
            parcel.writeInt(-1);
        } 
        addTaint(parcel.getTaint());
        addTaint(flags);
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.368 -0400", hash_original_method = "BB3C22BCE01837AA4BAC40A0B35F8BC2", hash_generated_method = "008AFFFAE8F7DF09372AA39021AFA4EA")
    public void setPeriodicSyncTime(int index, long when) {
        ensurePeriodicSyncTimeSize(index);
        periodicSyncTimes.set(index, when);
        addTaint(index);
        addTaint(when);
        
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.369 -0400", hash_original_method = "CB3B6F2BD6B69A04BBE5B4B8321ED55E", hash_generated_method = "778373E314AAE70599C0EA71E8F780BE")
    private void ensurePeriodicSyncTimeSize(int index) {
        {
            periodicSyncTimes = new ArrayList<Long>(0);
        } 
        final int requiredSize = index + 1;
        {
            boolean varDA8A1799F2E947514B7F61D918481AF0_1493933449 = (periodicSyncTimes.size() < requiredSize);
            {
                {
                    int i = periodicSyncTimes.size();
                    {
                        periodicSyncTimes.add((long) 0);
                    } 
                } 
            } 
        } 
        addTaint(index);
        
        
            
        
        
        
            
                
            
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.370 -0400", hash_original_method = "E0266DD4F289B692F6E7B79E10E75B20", hash_generated_method = "E415B5C275BE024F6D8EAC21D902192A")
    public long getPeriodicSyncTime(int index) {
        {
            boolean varB9564E21A396D957116506C1AEF43D3C_1349841579 = (periodicSyncTimes == null || periodicSyncTimes.size() < (index + 1));
        } 
        long varE430967A1E3A0EE477B628D1A0973895_398512008 = (periodicSyncTimes.get(index));
        addTaint(index);
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1141222350 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1141222350;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.371 -0400", hash_original_method = "5D5F49D9C483CE201F8BB2B6D37F0FB1", hash_generated_method = "EA5040F06ECF2809A7E9957C6A1356F9")
    public void removePeriodicSyncTime(int index) {
        ensurePeriodicSyncTimeSize(index);
        periodicSyncTimes.remove(index);
        addTaint(index);
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.371 -0400", hash_original_field = "DCF658CEB87B1871C682CB06BA67C24E", hash_generated_field = "78D7348159FCA08FC47896DADC9A6ECC")

    static final int VERSION = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.371 -0400", hash_original_field = "4B899671566F88F7105998C18EA46A1D", hash_generated_field = "4CCB2F73BD98045FB7A49DC531F6A5B0")

    private static final String TAG = "Sync";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:25.371 -0400", hash_original_field = "4B380E2AA31D16D86BF89F8EE0A58282", hash_generated_field = "34F7BA97EC5F779445C9A58D21D7DF7D")

    public static final Creator<SyncStatusInfo> CREATOR = new Creator<SyncStatusInfo>() {
        public SyncStatusInfo createFromParcel(Parcel in) {
            return new SyncStatusInfo(in);
        }

        public SyncStatusInfo[] newArray(int size) {
            return new SyncStatusInfo[size];
        }
    };
    
    public SyncStatusInfo createFromParcel(Parcel in) {
            return new SyncStatusInfo(in);
        }
    
    
    public SyncStatusInfo[] newArray(int size) {
            return new SyncStatusInfo[size];
        }
    
}

