package android.os;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.UUID;

public final class ParcelUuid implements Parcelable {
    private UUID mUuid;
    public static final Parcelable.Creator<ParcelUuid> CREATOR = new Parcelable.Creator<ParcelUuid>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.615 -0400", hash_original_method = "BE0C39B58500BBF13D262DF9616543A0", hash_generated_method = "1A99E5A31328AA990B943552C03AD9C3")
        @DSModeled(DSC.SAFE)
        public ParcelUuid createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            long mostSigBits;
            mostSigBits = source.readLong();
            long leastSigBits;
            leastSigBits = source.readLong();
            UUID uuid;
            uuid = new UUID(mostSigBits, leastSigBits);
            return (ParcelUuid)dsTaint.getTaint();
            // ---------- Original Method ----------
            //long mostSigBits = source.readLong();
            //long leastSigBits = source.readLong();
            //UUID uuid = new UUID(mostSigBits, leastSigBits);
            //return new ParcelUuid(uuid);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.615 -0400", hash_original_method = "DE9AFB44E7C5EC1F2E4B30CF11F48D0E", hash_generated_method = "C0866A51104F476F1996CE34604910E2")
        @DSModeled(DSC.SAFE)
        public ParcelUuid[] newArray(int size) {
            dsTaint.addTaint(size);
            return (ParcelUuid[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ParcelUuid[size];
        }

        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.615 -0400", hash_original_method = "CF473C61D493B6FE5C1BBCA31D442219", hash_generated_method = "D155A28EE696AF53C9212092D0BFD820")
    @DSModeled(DSC.SAFE)
    public ParcelUuid(UUID uuid) {
        dsTaint.addTaint(uuid.dsTaint);
        // ---------- Original Method ----------
        //mUuid = uuid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.615 -0400", hash_original_method = "E6B1B98CB06402B91557E2127042443C", hash_generated_method = "3B1A96151CFB5C87C502D113B6EDDB82")
    public static ParcelUuid fromString(String uuid) {
        return new ParcelUuid(UUID.fromString(uuid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.615 -0400", hash_original_method = "0CE9C43DAF663B7B5A7713ED255C5D05", hash_generated_method = "9476EAA463A9CE1A01FB0EAE25466DC2")
    @DSModeled(DSC.SAFE)
    public UUID getUuid() {
        return (UUID)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return mUuid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.616 -0400", hash_original_method = "88F1B202F7B60E8AC7861421AE6F35A5", hash_generated_method = "56A6DD19D77103D65E170053B17F6FD8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var9F97A90AE51E62B49AE13423AC17DCE2_1451750446 = (mUuid.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return mUuid.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.616 -0400", hash_original_method = "3F38019E558A882D8ACF21219C1A6CB1", hash_generated_method = "B82D132A92B909DDB7C9D201275E846F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var196667FDED9F8B89CF14F398A0BCCAFA_768174576 = (mUuid.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return mUuid.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.616 -0400", hash_original_method = "03E4868AC4B42986ECAD1235C75A1F23", hash_generated_method = "A19FC62CEC3428561E4EAA70F667ACAC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        ParcelUuid that;
        that = (ParcelUuid) object;
        boolean varDE1DBA9CD20F69F1FA5820A9CE98DF8B_1106874187 = ((this.mUuid.equals(that.mUuid)));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (object == null) {
           //return false;
       //}
        //if (this == object) {
           //return true;
       //}
        //if (!(object instanceof ParcelUuid)) {
           //return false;
       //}
        //ParcelUuid that = (ParcelUuid) object;
        //return (this.mUuid.equals(that.mUuid));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.616 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "7491C6FB42F78871A3F8EA322AF6B2FC")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:02:00.616 -0400", hash_original_method = "914E719E6FA80BA5E3F689C4DD681C77", hash_generated_method = "2CE64580D7C339F3F3A842F2EC6D06DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(dest.dsTaint);
        dsTaint.addTaint(flags);
        dest.writeLong(mUuid.getMostSignificantBits());
        dest.writeLong(mUuid.getLeastSignificantBits());
        // ---------- Original Method ----------
        //dest.writeLong(mUuid.getMostSignificantBits());
        //dest.writeLong(mUuid.getLeastSignificantBits());
    }

    
}


