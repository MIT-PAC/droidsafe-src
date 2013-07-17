package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;

public class MimeVersion extends SIPHeader implements MimeVersionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.573 -0400", hash_original_field = "B7BA36A0E18534FEF756461FEA28AA33", hash_generated_field = "159C0D69174BAFEC3E75C8954E429BCB")

    protected int minorVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.574 -0400", hash_original_field = "C307DCAC851A344568C2B1FAF6525AF1", hash_generated_field = "06A9400313FF659F56CC228B2F050E47")

    protected int majorVersion;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.574 -0400", hash_original_method = "30624564A4AC1D2B636F927C84B1D79A", hash_generated_method = "C6BA224CEF520B3A9E4A8C4E87900489")
    public  MimeVersion() {
        super(MIME_VERSION);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.575 -0400", hash_original_method = "D7FCE27D9AEC3742DED8FD71AF804648", hash_generated_method = "E4395675E9324ADCD44A5F1D12B7C796")
    public int getMinorVersion() {
        int varB7BA36A0E18534FEF756461FEA28AA33_1473968143 = (minorVersion);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813442341 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1813442341;
        // ---------- Original Method ----------
        //return minorVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.576 -0400", hash_original_method = "634F243B87354520E8F28C8C2539E93B", hash_generated_method = "12CA57BA5EE05DC7CD4FB9308DA31751")
    public int getMajorVersion() {
        int varC307DCAC851A344568C2B1FAF6525AF1_1214916978 = (majorVersion);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466601864 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_466601864;
        // ---------- Original Method ----------
        //return majorVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.577 -0400", hash_original_method = "6BBEE0FD6D45D5567C0156A66B800B02", hash_generated_method = "5FC139D44B2501BDCDECF5F0B388B3E5")
    public void setMinorVersion(int minorVersion) throws InvalidArgumentException {
        if(minorVersion < 0)        
        {
        InvalidArgumentException var11B353161A6320C02D20911B078EF4EC_1745479321 = new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", MimeVersion, setMinorVersion(), the minorVersion parameter is null");
        var11B353161A6320C02D20911B078EF4EC_1745479321.addTaint(taint);
        throw var11B353161A6320C02D20911B078EF4EC_1745479321;
        }
        this.minorVersion = minorVersion;
        // ---------- Original Method ----------
        //if (minorVersion < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", MimeVersion, setMinorVersion(), the minorVersion parameter is null");
        //this.minorVersion = minorVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.578 -0400", hash_original_method = "D3EA6112924A8CE6932EA7AE61D5C665", hash_generated_method = "BC890A26E915A87FAC9D197DE9D9B0B1")
    public void setMajorVersion(int majorVersion) throws InvalidArgumentException {
        if(majorVersion < 0)        
        {
        InvalidArgumentException varBCDD8A8BE6C8783416C42277FA3BA153_276773388 = new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", MimeVersion, setMajorVersion(), the majorVersion parameter is null");
        varBCDD8A8BE6C8783416C42277FA3BA153_276773388.addTaint(taint);
        throw varBCDD8A8BE6C8783416C42277FA3BA153_276773388;
        }
        this.majorVersion = majorVersion;
        // ---------- Original Method ----------
        //if (majorVersion < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", MimeVersion, setMajorVersion(), the majorVersion parameter is null");
        //this.majorVersion = majorVersion;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.578 -0400", hash_original_method = "C604A793DAEAE92DAC99FA0862A74B19", hash_generated_method = "F509FA5DB8A75AF71D50134FD7D1B98B")
    public String encodeBody() {
String var48AEC22F1C2C1AFC10DB4A26BBF578AB_1189232566 =         Integer.toString(majorVersion)
            + DOT
            + Integer.toString(minorVersion);
        var48AEC22F1C2C1AFC10DB4A26BBF578AB_1189232566.addTaint(taint);
        return var48AEC22F1C2C1AFC10DB4A26BBF578AB_1189232566;
        // ---------- Original Method ----------
        //return Integer.toString(majorVersion)
            //+ DOT
            //+ Integer.toString(minorVersion);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.578 -0400", hash_original_field = "49394961FB7729CA6EB0F26EE1BF48EB", hash_generated_field = "55326010FCF59323AF113A86CEA19744")

    private static final long serialVersionUID = -7951589626435082068L;
}

