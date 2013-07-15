package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class SyncInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.432 -0400", hash_original_field = "A6E80D6465C4F39AC517335BD9346D44", hash_generated_field = "A9902B6EC2628AF68CD4117B511E65F0")

    public int authorityId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.432 -0400", hash_original_field = "E268443E43D93DAB7EBEF303BBE9642F", hash_generated_field = "48DCC252B03FBCBEDBDE2E34968668DF")

    public Account account;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.433 -0400", hash_original_field = "873E9C0B50183B613336EEA1020F4369", hash_generated_field = "FB6B5528A361C1A6848B87F8DAC52043")

    public String authority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.433 -0400", hash_original_field = "5B2A579F62087D17D79CE59F3DE5F6D1", hash_generated_field = "48AB5BE3A45BACCF7E8CB1591E803C43")

    public long startTime;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.435 -0400", hash_original_method = "08CB15341E378B91930C38215FF9CE0F", hash_generated_method = "E4A50A663AFC7854E79A004CB1D284BE")
      SyncInfo(int authorityId, Account account, String authority,
            long startTime) {
        this.authorityId = authorityId;
        this.account = account;
        this.authority = authority;
        this.startTime = startTime;
        // ---------- Original Method ----------
        //this.authorityId = authorityId;
        //this.account = account;
        //this.authority = authority;
        //this.startTime = startTime;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.437 -0400", hash_original_method = "C517E1FF2489673370FA690A620D127C", hash_generated_method = "E03442F5CEB20545221B8CC457780884")
      SyncInfo(Parcel parcel) {
        authorityId = parcel.readInt();
        account = new Account(parcel);
        authority = parcel.readString();
        startTime = parcel.readLong();
        // ---------- Original Method ----------
        //authorityId = parcel.readInt();
        //account = new Account(parcel);
        //authority = parcel.readString();
        //startTime = parcel.readLong();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.438 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "52B8B122713C58AB697584E38ABC0360")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_859157093 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287623772 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1287623772;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.440 -0400", hash_original_method = "1C5B91DE7E7E8D04DC252E4EE5F1DBAA", hash_generated_method = "3A08AB990C036BE215594BA3B7F9A0CC")
    public void writeToParcel(Parcel parcel, int flags) {
        addTaint(flags);
        addTaint(parcel.getTaint());
        parcel.writeInt(authorityId);
        account.writeToParcel(parcel, 0);
        parcel.writeString(authority);
        parcel.writeLong(startTime);
        // ---------- Original Method ----------
        //parcel.writeInt(authorityId);
        //account.writeToParcel(parcel, 0);
        //parcel.writeString(authority);
        //parcel.writeLong(startTime);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:10.441 -0400", hash_original_field = "A01FEEA498E9DC325074E88D0BA2C977", hash_generated_field = "5C265E4318FC6B04FC842570ABED2BA1")

    public static final Creator<SyncInfo> CREATOR = new Creator<SyncInfo>() {
        public SyncInfo createFromParcel(Parcel in) {
            return new SyncInfo(in);
        }

        public SyncInfo[] newArray(int size) {
            return new SyncInfo[size];
        }
    };
    // orphaned legacy method
    public SyncInfo createFromParcel(Parcel in) {
            return new SyncInfo(in);
        }
    
    // orphaned legacy method
    public SyncInfo[] newArray(int size) {
            return new SyncInfo[size];
        }
    
}

