package android.content;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.text.TextUtils;
import android.os.Parcelable;
import android.os.Parcel;

public class SyncAdapterType implements Parcelable {
    public String authority;
    public String accountType;
    public boolean isKey;
    private boolean userVisible;
    private boolean supportsUploading;
    private boolean isAlwaysSyncable;
    private boolean allowParallelSyncs;
    private String settingsActivity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.101 -0400", hash_original_method = "7289662DB03EFD3B7823DCECDC339B9C", hash_generated_method = "71CD503E3912C95AAF51BB713562F319")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading) {
        dsTaint.addTaint(userVisible);
        dsTaint.addTaint(supportsUploading);
        dsTaint.addTaint(authority);
        dsTaint.addTaint(accountType);
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_364094598 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_2096878439 = (TextUtils.isEmpty(accountType));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
            } //End block
        } //End collapsed parenthetic
        this.isAlwaysSyncable = false;
        this.allowParallelSyncs = false;
        this.settingsActivity = null;
        this.isKey = false;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(authority)) {
            //throw new IllegalArgumentException("the authority must not be empty: " + authority);
        //}
        //if (TextUtils.isEmpty(accountType)) {
            //throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
        //}
        //this.authority = authority;
        //this.accountType = accountType;
        //this.userVisible = userVisible;
        //this.supportsUploading = supportsUploading;
        //this.isAlwaysSyncable = false;
        //this.allowParallelSyncs = false;
        //this.settingsActivity = null;
        //this.isKey = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.102 -0400", hash_original_method = "8EF09623074C1EE06130DE195B26B1A3", hash_generated_method = "23E4102BD4B334449C8A4F295FA41547")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncAdapterType(String authority, String accountType, boolean userVisible,
            boolean supportsUploading,
            boolean isAlwaysSyncable,
            boolean allowParallelSyncs,
            String settingsActivity) {
        dsTaint.addTaint(userVisible);
        dsTaint.addTaint(supportsUploading);
        dsTaint.addTaint(authority);
        dsTaint.addTaint(settingsActivity);
        dsTaint.addTaint(isAlwaysSyncable);
        dsTaint.addTaint(accountType);
        dsTaint.addTaint(allowParallelSyncs);
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_2042316298 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1289710577 = (TextUtils.isEmpty(accountType));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
            } //End block
        } //End collapsed parenthetic
        this.isKey = false;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(authority)) {
            //throw new IllegalArgumentException("the authority must not be empty: " + authority);
        //}
        //if (TextUtils.isEmpty(accountType)) {
            //throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
        //}
        //this.authority = authority;
        //this.accountType = accountType;
        //this.userVisible = userVisible;
        //this.supportsUploading = supportsUploading;
        //this.isAlwaysSyncable = isAlwaysSyncable;
        //this.allowParallelSyncs = allowParallelSyncs;
        //this.settingsActivity = settingsActivity;
        //this.isKey = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.102 -0400", hash_original_method = "E5F69ADC566D68AE55898AF008FDA708", hash_generated_method = "7F55BC816EE5577A0F106984CAE9DE58")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SyncAdapterType(String authority, String accountType) {
        dsTaint.addTaint(authority);
        dsTaint.addTaint(accountType);
        {
            boolean var9779973367485DB1CCDF8689D3EBF254_768774173 = (TextUtils.isEmpty(authority));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the authority must not be empty: " + authority);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var391C91EA3B1EA59E4CC01368F2E5593B_1744719082 = (TextUtils.isEmpty(accountType));
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
            } //End block
        } //End collapsed parenthetic
        this.userVisible = true;
        this.supportsUploading = true;
        this.isAlwaysSyncable = false;
        this.allowParallelSyncs = false;
        this.settingsActivity = null;
        this.isKey = true;
        // ---------- Original Method ----------
        //if (TextUtils.isEmpty(authority)) {
            //throw new IllegalArgumentException("the authority must not be empty: " + authority);
        //}
        //if (TextUtils.isEmpty(accountType)) {
            //throw new IllegalArgumentException("the accountType must not be empty: " + accountType);
        //}
        //this.authority = authority;
        //this.accountType = accountType;
        //this.userVisible = true;
        //this.supportsUploading = true;
        //this.isAlwaysSyncable = false;
        //this.allowParallelSyncs = false;
        //this.settingsActivity = null;
        //this.isKey = true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.103 -0400", hash_original_method = "7591B3B4C417B70692687F09C44AB48B", hash_generated_method = "BB32BF33211EA02822568EB82D599136")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SyncAdapterType(Parcel source) {
        this(
                source.readString(),
                source.readString(),
                source.readInt() != 0,
                source.readInt() != 0,
                source.readInt() != 0,
                source.readInt() != 0,
                source.readString());
        dsTaint.addTaint(source.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.103 -0400", hash_original_method = "1E794225B2A769540CA80516F7B50837", hash_generated_method = "C4F2F038C7D31EB5B405A927AAFFAB5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean supportsUploading() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return supportsUploading;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.104 -0400", hash_original_method = "E748D000233018148FC3D8951248BEFC", hash_generated_method = "AAEA1E26D2CC84862162E847C152DA47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isUserVisible() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return userVisible;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.104 -0400", hash_original_method = "BB6B5E7B63E7D5F5261B5E5C8991DA1B", hash_generated_method = "54878F06410E6110FF26587C6B13619F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean allowParallelSyncs() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return allowParallelSyncs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.104 -0400", hash_original_method = "3EF9FB902D552C4056546E3547411F1A", hash_generated_method = "E48730CB78A76EE9A138BAD048CCBF9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isAlwaysSyncable() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return isAlwaysSyncable;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.105 -0400", hash_original_method = "255B2528E2817C3729D95130236DCF63", hash_generated_method = "7367A912ADA174414E1DB8FF02BD150F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getSettingsActivity() {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException(
                    "this method is not allowed to be called when this is a key");
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException(
                    //"this method is not allowed to be called when this is a key");
        //}
        //return settingsActivity;
    }

    
        public static SyncAdapterType newKey(String authority, String accountType) {
        return new SyncAdapterType(authority, accountType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.105 -0400", hash_original_method = "A1CF6D87DAC8D16BD1DD7945C12C597D", hash_generated_method = "7F8900447CD74243BE02E4C97BE33410")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object o) {
        dsTaint.addTaint(o.dsTaint);
        {
            boolean var6D2CFEECAA6CC7108820D0CDDD5631C7_1242073894 = (o == this);
        } //End collapsed parenthetic
        SyncAdapterType other;
        other = (SyncAdapterType)o;
        boolean var5E7B2BE5B83770AB325FD6B40928AD13_78906891 = (authority.equals(other.authority) && accountType.equals(other.accountType));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (o == this) return true;
        //if (!(o instanceof SyncAdapterType)) return false;
        //final SyncAdapterType other = (SyncAdapterType)o;
        //return authority.equals(other.authority) && accountType.equals(other.accountType);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.106 -0400", hash_original_method = "16D7E959FAC6345A599199AFC4EA50EB", hash_generated_method = "D6F923CC7A58CF820732932F61F1FB1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int hashCode() {
        int result;
        result = 17;
        result = 31 * result + authority.hashCode();
        result = 31 * result + accountType.hashCode();
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int result = 17;
        //result = 31 * result + authority.hashCode();
        //result = 31 * result + accountType.hashCode();
        //return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.106 -0400", hash_original_method = "35ACA65A211F277218A9C2784AA8F4DE", hash_generated_method = "C9B822A86D4822EB69113521C5A6B0A4")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (isKey) {
            //return "SyncAdapterType Key {name=" + authority
                    //+ ", type=" + accountType
                    //+ "}";
        //} else {
            //return "SyncAdapterType {name=" + authority
                    //+ ", type=" + accountType
                    //+ ", userVisible=" + userVisible
                    //+ ", supportsUploading=" + supportsUploading
                    //+ ", isAlwaysSyncable=" + isAlwaysSyncable
                    //+ ", allowParallelSyncs=" + allowParallelSyncs
                    //+ ", settingsActivity=" + settingsActivity
                    //+ "}";
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.107 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.107 -0400", hash_original_method = "B6F0FAFEE232DA1C5B972583BC48E189", hash_generated_method = "D40E6AF8B34D1FAA739C35FABCF57EF9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("keys aren't parcelable");
        } //End block
        dest.writeString(authority);
        dest.writeString(accountType);
        dest.writeInt(userVisible ? 1 : 0);
        dest.writeInt(supportsUploading ? 1 : 0);
        dest.writeInt(isAlwaysSyncable ? 1 : 0);
        dest.writeInt(allowParallelSyncs ? 1 : 0);
        dest.writeString(settingsActivity);
        // ---------- Original Method ----------
        //if (isKey) {
            //throw new IllegalStateException("keys aren't parcelable");
        //}
        //dest.writeString(authority);
        //dest.writeString(accountType);
        //dest.writeInt(userVisible ? 1 : 0);
        //dest.writeInt(supportsUploading ? 1 : 0);
        //dest.writeInt(isAlwaysSyncable ? 1 : 0);
        //dest.writeInt(allowParallelSyncs ? 1 : 0);
        //dest.writeString(settingsActivity);
    }

    
    public static final Creator<SyncAdapterType> CREATOR = new Creator<SyncAdapterType>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.108 -0400", hash_original_method = "63BD8FE183983D6CDCBA016F3E24D9D5", hash_generated_method = "12ED3DB260C8999C0446390E5EE31D72")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncAdapterType createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            SyncAdapterType var775B420EE4DE8C977FCDA3378671FDA3_1117234545 = (new SyncAdapterType(source));
            return (SyncAdapterType)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncAdapterType(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:42.108 -0400", hash_original_method = "9B9CC41BB0EF0A8D0D6C6DC12ADA0165", hash_generated_method = "582BC20B41D1E55E18A0466C829FE296")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public SyncAdapterType[] newArray(int size) {
            dsTaint.addTaint(size);
            SyncAdapterType[] var340E01A1CBF54F0C681703A47BCA7EE3_1596312527 = (new SyncAdapterType[size]);
            return (SyncAdapterType[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new SyncAdapterType[size];
        }

        
}; //Transformed anonymous class
}

