package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;

public class MimeVersion extends SIPHeader implements MimeVersionHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.596 -0400", hash_original_field = "B7BA36A0E18534FEF756461FEA28AA33", hash_generated_field = "159C0D69174BAFEC3E75C8954E429BCB")

    protected int minorVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.596 -0400", hash_original_field = "C307DCAC851A344568C2B1FAF6525AF1", hash_generated_field = "06A9400313FF659F56CC228B2F050E47")

    protected int majorVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.596 -0400", hash_original_method = "30624564A4AC1D2B636F927C84B1D79A", hash_generated_method = "C6BA224CEF520B3A9E4A8C4E87900489")
    public  MimeVersion() {
        super(MIME_VERSION);
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.597 -0400", hash_original_method = "D7FCE27D9AEC3742DED8FD71AF804648", hash_generated_method = "E389B33420AD3F441E10DECB74F4C208")
    public int getMinorVersion() {
        int varB7BA36A0E18534FEF756461FEA28AA33_73587180 = (minorVersion);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175073535 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1175073535;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.597 -0400", hash_original_method = "634F243B87354520E8F28C8C2539E93B", hash_generated_method = "FF2CD2D06B96C6FDCDC27165983C1ADE")
    public int getMajorVersion() {
        int varC307DCAC851A344568C2B1FAF6525AF1_591937632 = (majorVersion);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837474357 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1837474357;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.597 -0400", hash_original_method = "6BBEE0FD6D45D5567C0156A66B800B02", hash_generated_method = "7FA5438B8969485D12679CCE0FB6315E")
    public void setMinorVersion(int minorVersion) throws InvalidArgumentException {
    if(minorVersion < 0)        
        {
        InvalidArgumentException var11B353161A6320C02D20911B078EF4EC_222585730 = new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", MimeVersion, setMinorVersion(), the minorVersion parameter is null");
        var11B353161A6320C02D20911B078EF4EC_222585730.addTaint(taint);
        throw var11B353161A6320C02D20911B078EF4EC_222585730;
        }
        this.minorVersion = minorVersion;
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.598 -0400", hash_original_method = "D3EA6112924A8CE6932EA7AE61D5C665", hash_generated_method = "51F48CFAE25580B56EA165041BE9D148")
    public void setMajorVersion(int majorVersion) throws InvalidArgumentException {
    if(majorVersion < 0)        
        {
        InvalidArgumentException varBCDD8A8BE6C8783416C42277FA3BA153_1128558782 = new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", MimeVersion, setMajorVersion(), the majorVersion parameter is null");
        varBCDD8A8BE6C8783416C42277FA3BA153_1128558782.addTaint(taint);
        throw varBCDD8A8BE6C8783416C42277FA3BA153_1128558782;
        }
        this.majorVersion = majorVersion;
        
        
            
                
                    
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.598 -0400", hash_original_method = "C604A793DAEAE92DAC99FA0862A74B19", hash_generated_method = "8105C1D84E7E30F93A7F8BB3C0D44888")
    public String encodeBody() {
String var48AEC22F1C2C1AFC10DB4A26BBF578AB_1051112220 =         Integer.toString(majorVersion)
            + DOT
            + Integer.toString(minorVersion);
        var48AEC22F1C2C1AFC10DB4A26BBF578AB_1051112220.addTaint(taint);
        return var48AEC22F1C2C1AFC10DB4A26BBF578AB_1051112220;
        
        
            
            
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.599 -0400", hash_original_field = "49394961FB7729CA6EB0F26EE1BF48EB", hash_generated_field = "55326010FCF59323AF113A86CEA19744")

    private static final long serialVersionUID = -7951589626435082068L;
}

