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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.130 -0400", hash_original_field = "B7BA36A0E18534FEF756461FEA28AA33", hash_generated_field = "159C0D69174BAFEC3E75C8954E429BCB")

    protected int minorVersion;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.130 -0400", hash_original_field = "C307DCAC851A344568C2B1FAF6525AF1", hash_generated_field = "06A9400313FF659F56CC228B2F050E47")

    protected int majorVersion;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.130 -0400", hash_original_method = "30624564A4AC1D2B636F927C84B1D79A", hash_generated_method = "C6BA224CEF520B3A9E4A8C4E87900489")
    public  MimeVersion() {
        super(MIME_VERSION);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.131 -0400", hash_original_method = "D7FCE27D9AEC3742DED8FD71AF804648", hash_generated_method = "117A4B22D47AB2E369172EB95084B40E")
    public int getMinorVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5966418 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_5966418;
        // ---------- Original Method ----------
        //return minorVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.131 -0400", hash_original_method = "634F243B87354520E8F28C8C2539E93B", hash_generated_method = "8CC166C735FC3BBBADA6D122C607BC31")
    public int getMajorVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427183034 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_427183034;
        // ---------- Original Method ----------
        //return majorVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.131 -0400", hash_original_method = "6BBEE0FD6D45D5567C0156A66B800B02", hash_generated_method = "DAF4FDFEF43F025F7A1A1B96CF5B23AF")
    public void setMinorVersion(int minorVersion) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", MimeVersion, setMinorVersion(), the minorVersion parameter is null");
        this.minorVersion = minorVersion;
        // ---------- Original Method ----------
        //if (minorVersion < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", MimeVersion, setMinorVersion(), the minorVersion parameter is null");
        //this.minorVersion = minorVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.132 -0400", hash_original_method = "D3EA6112924A8CE6932EA7AE61D5C665", hash_generated_method = "67D22676AE5A95F3620DFEFD90B8D68D")
    public void setMajorVersion(int majorVersion) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", MimeVersion, setMajorVersion(), the majorVersion parameter is null");
        this.majorVersion = majorVersion;
        // ---------- Original Method ----------
        //if (majorVersion < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", MimeVersion, setMajorVersion(), the majorVersion parameter is null");
        //this.majorVersion = majorVersion;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.133 -0400", hash_original_method = "C604A793DAEAE92DAC99FA0862A74B19", hash_generated_method = "0FF97E3ABE524E7146DB60F36F209074")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_699954618 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_699954618 = Integer.toString(majorVersion)
            + DOT
            + Integer.toString(minorVersion);
        varB4EAC82CA7396A68D541C85D26508E83_699954618.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_699954618;
        // ---------- Original Method ----------
        //return Integer.toString(majorVersion)
            //+ DOT
            //+ Integer.toString(minorVersion);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.133 -0400", hash_original_field = "49394961FB7729CA6EB0F26EE1BF48EB", hash_generated_field = "854E743750801DE2367BBED4E64CFB38")

    private static long serialVersionUID = -7951589626435082068L;
}

