package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;

public class MimeVersion extends SIPHeader implements MimeVersionHeader {
    protected int minorVersion;
    protected int majorVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.016 -0400", hash_original_method = "30624564A4AC1D2B636F927C84B1D79A", hash_generated_method = "C6BA224CEF520B3A9E4A8C4E87900489")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MimeVersion() {
        super(MIME_VERSION);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.016 -0400", hash_original_method = "D7FCE27D9AEC3742DED8FD71AF804648", hash_generated_method = "63B923AE09B6F73B7E9880CAACC0A5C2")
    @DSModeled(DSC.SAFE)
    public int getMinorVersion() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return minorVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.016 -0400", hash_original_method = "634F243B87354520E8F28C8C2539E93B", hash_generated_method = "29362B84BE9018C7495EF0EF94E47E48")
    @DSModeled(DSC.SAFE)
    public int getMajorVersion() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return majorVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.017 -0400", hash_original_method = "6BBEE0FD6D45D5567C0156A66B800B02", hash_generated_method = "41F98122A2C075344D47E7638B04DC62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMinorVersion(int minorVersion) throws InvalidArgumentException {
        dsTaint.addTaint(minorVersion);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", MimeVersion, setMinorVersion(), the minorVersion parameter is null");
        // ---------- Original Method ----------
        //if (minorVersion < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", MimeVersion, setMinorVersion(), the minorVersion parameter is null");
        //this.minorVersion = minorVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.017 -0400", hash_original_method = "D3EA6112924A8CE6932EA7AE61D5C665", hash_generated_method = "D058C260AB3F3233A7AD84A10294BF80")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setMajorVersion(int majorVersion) throws InvalidArgumentException {
        dsTaint.addTaint(majorVersion);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", MimeVersion, setMajorVersion(), the majorVersion parameter is null");
        // ---------- Original Method ----------
        //if (majorVersion < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", MimeVersion, setMajorVersion(), the majorVersion parameter is null");
        //this.majorVersion = majorVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.017 -0400", hash_original_method = "C604A793DAEAE92DAC99FA0862A74B19", hash_generated_method = "C3BDEAD97A9CBE5237EE3A2E1B4D7F32")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String varC181FC9C1D303FAC8422422E9EB72934_1921339238 = (Integer.toString(majorVersion)
            + DOT
            + Integer.toString(minorVersion));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Integer.toString(majorVersion)
            //+ DOT
            //+ Integer.toString(minorVersion);
    }

    
    private static final long serialVersionUID = -7951589626435082068L;
}

