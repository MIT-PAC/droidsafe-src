package gov.nist.javax.sip.header;

// Droidsafe Imports
import javax.sip.InvalidArgumentException;
import javax.sip.header.ContentLengthHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ContentLength extends SIPHeader implements javax.sip.header.ContentLengthHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.277 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "8B32F0E2687755E2873F555A7E264239")

    protected Integer contentLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.277 -0400", hash_original_method = "6E8A391CB1CB04739D58E661944CCFB0", hash_generated_method = "BEA878E6A814B0FF9D7761D669FAB007")
    public  ContentLength() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.277 -0400", hash_original_method = "2D2F8FB9FD0DE4D4C70B238FD2D4C88B", hash_generated_method = "D12872C2D47D49B4D77E9FE423C6010C")
    public  ContentLength(int length) {
        super(NAME);
        this.contentLength = Integer.valueOf(length);
        // ---------- Original Method ----------
        //this.contentLength = Integer.valueOf(length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.278 -0400", hash_original_method = "071F13E55E71377D8D1F79D63D84EB7C", hash_generated_method = "121685A09F2F67D6C5222C5ADB379D17")
    public int getContentLength() {
        int varF49B5C25837FC0D6E55799E76F51E4AC_443730503 = (contentLength.intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2145628492 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2145628492;
        // ---------- Original Method ----------
        //return contentLength.intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.278 -0400", hash_original_method = "D2E39B4328F6A55D8ECA212C37A06119", hash_generated_method = "6F32F064A2096F9249A891CF041197DA")
    public void setContentLength(int contentLength) throws InvalidArgumentException {
        if(contentLength < 0)        
        {
        InvalidArgumentException var7BEA9B099681F4B52A513D65C998EB27_1060618393 = new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", ContentLength, setContentLength(), the contentLength parameter is <0");
        var7BEA9B099681F4B52A513D65C998EB27_1060618393.addTaint(taint);
        throw var7BEA9B099681F4B52A513D65C998EB27_1060618393;
        }
        this.contentLength = Integer.valueOf(contentLength);
        // ---------- Original Method ----------
        //if (contentLength < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP Exception"
                    //+ ", ContentLength, setContentLength(), the contentLength parameter is <0");
        //this.contentLength = Integer.valueOf(contentLength);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.279 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "D8978FAA81673B87C08C962953AEF16B")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_625145024 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_625145024.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_625145024;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.279 -0400", hash_original_method = "5B96EE656807643EA726005E8D24EEAD", hash_generated_method = "C07D035E14E1035B97A1F3EA5997FAD6")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
        if(contentLength == null)        
        buffer.append("0");
        else
        buffer.append(contentLength.toString());
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_1893868538 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_1893868538.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_1893868538;
        // ---------- Original Method ----------
        //if (contentLength == null)
            //buffer.append("0");
        //else
            //buffer.append(contentLength.toString());
        //return buffer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.280 -0400", hash_original_method = "9921BFF09FACC23B6D23BD0D026EB023", hash_generated_method = "A4989151681AC56332F40BE91ABEED3D")
    public boolean match(Object other) {
        addTaint(other.getTaint());
        if(other instanceof ContentLength)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_161241353 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_928126228 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_928126228;
        }
        else
        {
        boolean var68934A3E9455FA72420237EB05902327_1649174224 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1166081834 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1166081834;
        }
        // ---------- Original Method ----------
        //if (other instanceof ContentLength)
            //return true;
        //else
            //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.281 -0400", hash_original_method = "B4957EC40AAAC0570CBC84EE1092BF02", hash_generated_method = "ABE19B76BC6A8EB41DD501E1E3D73A78")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
        if(other instanceof ContentLengthHeader)        
        {
            final ContentLengthHeader o = (ContentLengthHeader) other;
            boolean var5CDEA77036187634C36DF20CD1326BCC_422077975 = (this.getContentLength() == o.getContentLength());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1327057261 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1327057261;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1615918261 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1292265558 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1292265558;
        // ---------- Original Method ----------
        //if (other instanceof ContentLengthHeader) {
            //final ContentLengthHeader o = (ContentLengthHeader) other;
            //return this.getContentLength() == o.getContentLength();
        //}
        //return false;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:33.281 -0400", hash_original_field = "0A8F14B7447B017C5FFCEC85C0E796E8", hash_generated_field = "0DAE05D7BF9A340249D2F42939DD9CA2")

    private static final long serialVersionUID = 1187190542411037027L;
}

