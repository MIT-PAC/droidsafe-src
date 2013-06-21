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
    protected Integer contentLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.903 -0400", hash_original_method = "6E8A391CB1CB04739D58E661944CCFB0", hash_generated_method = "BEA878E6A814B0FF9D7761D669FAB007")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLength() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.903 -0400", hash_original_method = "2D2F8FB9FD0DE4D4C70B238FD2D4C88B", hash_generated_method = "FC5F65BAA32C85A14A66468E1293DC35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ContentLength(int length) {
        super(NAME);
        dsTaint.addTaint(length);
        this.contentLength = Integer.valueOf(length);
        // ---------- Original Method ----------
        //this.contentLength = Integer.valueOf(length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.904 -0400", hash_original_method = "071F13E55E71377D8D1F79D63D84EB7C", hash_generated_method = "2DD526DFD1472C632098ADAA6F7B8D0A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getContentLength() {
        int var959B9E91EDB949EF182CA415D001798B_1057955437 = (contentLength.intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return contentLength.intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.904 -0400", hash_original_method = "D2E39B4328F6A55D8ECA212C37A06119", hash_generated_method = "1131A950F56537C27E18A3800C77BA3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setContentLength(int contentLength) throws InvalidArgumentException {
        dsTaint.addTaint(contentLength);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.904 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "95FF6C393BE736F9D28AD6E982E4B754")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var1FB3D4520BF100042DCF9757D0219988_1834740035 = (encodeBody(new StringBuffer()).toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.904 -0400", hash_original_method = "5B96EE656807643EA726005E8D24EEAD", hash_generated_method = "A4654452F9EBBD4D56E56A6D06D821B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected StringBuffer encodeBody(StringBuffer buffer) {
        dsTaint.addTaint(buffer.dsTaint);
        buffer.append("0");
        buffer.append(contentLength.toString());
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (contentLength == null)
            //buffer.append("0");
        //else
            //buffer.append(contentLength.toString());
        //return buffer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.904 -0400", hash_original_method = "9921BFF09FACC23B6D23BD0D026EB023", hash_generated_method = "73DBDFD01B34E4369AEAE684FA4326D5")
    @DSModeled(DSC.SAFE)
    public boolean match(Object other) {
        dsTaint.addTaint(other.dsTaint);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other instanceof ContentLength)
            //return true;
        //else
            //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:20.905 -0400", hash_original_method = "B4957EC40AAAC0570CBC84EE1092BF02", hash_generated_method = "EFD70E86FBA9D7ECC1857C8D483EB1DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        {
            ContentLengthHeader o;
            o = (ContentLengthHeader) other;
            boolean varB67ADC09111838E0523E2E12184F643D_1982013690 = (this.getContentLength() == o.getContentLength());
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (other instanceof ContentLengthHeader) {
            //final ContentLengthHeader o = (ContentLengthHeader) other;
            //return this.getContentLength() == o.getContentLength();
        //}
        //return false;
    }

    
    private static final long serialVersionUID = 1187190542411037027L;
}

