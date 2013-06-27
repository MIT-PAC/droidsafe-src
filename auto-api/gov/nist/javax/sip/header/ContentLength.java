package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.*;
import javax.sip.header.ContentLengthHeader;

public class ContentLength extends SIPHeader implements javax.sip.header.ContentLengthHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.821 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "8B32F0E2687755E2873F555A7E264239")

    protected Integer contentLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.822 -0400", hash_original_method = "6E8A391CB1CB04739D58E661944CCFB0", hash_generated_method = "BEA878E6A814B0FF9D7761D669FAB007")
    public  ContentLength() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.822 -0400", hash_original_method = "2D2F8FB9FD0DE4D4C70B238FD2D4C88B", hash_generated_method = "D12872C2D47D49B4D77E9FE423C6010C")
    public  ContentLength(int length) {
        super(NAME);
        this.contentLength = Integer.valueOf(length);
        // ---------- Original Method ----------
        //this.contentLength = Integer.valueOf(length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.822 -0400", hash_original_method = "071F13E55E71377D8D1F79D63D84EB7C", hash_generated_method = "F58A22A508AD908070822695FC24E6D8")
    public int getContentLength() {
        int var959B9E91EDB949EF182CA415D001798B_1381653579 = (contentLength.intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327895188 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1327895188;
        // ---------- Original Method ----------
        //return contentLength.intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.832 -0400", hash_original_method = "D2E39B4328F6A55D8ECA212C37A06119", hash_generated_method = "7E264BD81ABF5DD5CE2C02AA30F647EC")
    public void setContentLength(int contentLength) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", ContentLength, setContentLength(), the contentLength parameter is <0");
        this.contentLength = Integer.valueOf(contentLength);
        // ---------- Original Method ----------
        //if (contentLength < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", ContentLength, setContentLength(), the contentLength parameter is <0");
        //this.contentLength = Integer.valueOf(contentLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.843 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "41654688307509A41D9C6F12B9E12929")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_897227480 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_897227480 = encodeBody(new StringBuffer()).toString();
        varB4EAC82CA7396A68D541C85D26508E83_897227480.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_897227480;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.844 -0400", hash_original_method = "5B96EE656807643EA726005E8D24EEAD", hash_generated_method = "1319E2E8981670B27E4583AC60FF2F5B")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_251834007 = null; //Variable for return #1
        buffer.append("0");
        buffer.append(contentLength.toString());
        varB4EAC82CA7396A68D541C85D26508E83_251834007 = buffer;
        addTaint(buffer.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_251834007.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_251834007;
        // ---------- Original Method ----------
        //if (contentLength == null)
            //buffer.append("0");
        //else
            //buffer.append(contentLength.toString());
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.844 -0400", hash_original_method = "9921BFF09FACC23B6D23BD0D026EB023", hash_generated_method = "2F6C1D47B41A016DB3C742907053988A")
    public boolean match(Object other) {
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_58704625 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_58704625;
        // ---------- Original Method ----------
        //if (other instanceof ContentLength)
            //return true;
        //else
            //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.845 -0400", hash_original_method = "B4957EC40AAAC0570CBC84EE1092BF02", hash_generated_method = "C43B36C2DD050A8F791C861F6C13D6D3")
    public boolean equals(Object other) {
        {
            ContentLengthHeader o;
            o = (ContentLengthHeader) other;
            boolean varB67ADC09111838E0523E2E12184F643D_87608334 = (this.getContentLength() == o.getContentLength());
        } //End block
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1500278718 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1500278718;
        // ---------- Original Method ----------
        //if (other instanceof ContentLengthHeader) {
            //final ContentLengthHeader o = (ContentLengthHeader) other;
            //return this.getContentLength() == o.getContentLength();
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:30.845 -0400", hash_original_field = "0A8F14B7447B017C5FFCEC85C0E796E8", hash_generated_field = "467A3A07CB2BF29215C78B30BD1B5BC3")

    private static long serialVersionUID = 1187190542411037027L;
}

