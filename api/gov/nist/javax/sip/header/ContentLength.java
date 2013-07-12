package gov.nist.javax.sip.header;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.*;
import javax.sip.header.ContentLengthHeader;

public class ContentLength extends SIPHeader implements javax.sip.header.ContentLengthHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.287 -0400", hash_original_field = "C22384F3ABFE57BC648B6E1701C98123", hash_generated_field = "8B32F0E2687755E2873F555A7E264239")

    protected Integer contentLength;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.288 -0400", hash_original_method = "6E8A391CB1CB04739D58E661944CCFB0", hash_generated_method = "BEA878E6A814B0FF9D7761D669FAB007")
    public  ContentLength() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.288 -0400", hash_original_method = "2D2F8FB9FD0DE4D4C70B238FD2D4C88B", hash_generated_method = "D12872C2D47D49B4D77E9FE423C6010C")
    public  ContentLength(int length) {
        super(NAME);
        this.contentLength = Integer.valueOf(length);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.289 -0400", hash_original_method = "071F13E55E71377D8D1F79D63D84EB7C", hash_generated_method = "AB623830250D48D1E0C38E257CE2EAD9")
    public int getContentLength() {
        int varF49B5C25837FC0D6E55799E76F51E4AC_990637881 = (contentLength.intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1454653475 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1454653475;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.289 -0400", hash_original_method = "D2E39B4328F6A55D8ECA212C37A06119", hash_generated_method = "558CB72769A77DA1666F9B30BB124B3C")
    public void setContentLength(int contentLength) throws InvalidArgumentException {
    if(contentLength < 0)        
        {
        InvalidArgumentException var7BEA9B099681F4B52A513D65C998EB27_216062383 = new InvalidArgumentException(
                "JAIN-SIP Exception"
                    + ", ContentLength, setContentLength(), the contentLength parameter is <0");
        var7BEA9B099681F4B52A513D65C998EB27_216062383.addTaint(taint);
        throw var7BEA9B099681F4B52A513D65C998EB27_216062383;
        }
        this.contentLength = Integer.valueOf(contentLength);
        
        
            
                
                    
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.290 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "09DCA9F45D75B9BB327B09B18FD75232")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_999184745 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_999184745.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_999184745;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.290 -0400", hash_original_method = "5B96EE656807643EA726005E8D24EEAD", hash_generated_method = "522D2865B0FA5202958886BDA19FC7DC")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(contentLength == null)        
        buffer.append("0");
        else
        buffer.append(contentLength.toString());
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_875511075 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_875511075.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_875511075;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.290 -0400", hash_original_method = "9921BFF09FACC23B6D23BD0D026EB023", hash_generated_method = "A3B0572A072BB6030D67CA40FED2302A")
    public boolean match(Object other) {
        addTaint(other.getTaint());
    if(other instanceof ContentLength)        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1183171410 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1097871218 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1097871218;
        }
        else
        {
        boolean var68934A3E9455FA72420237EB05902327_258879490 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1832880497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1832880497;
        }
        
        
            
        
            
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.291 -0400", hash_original_method = "B4957EC40AAAC0570CBC84EE1092BF02", hash_generated_method = "6D0EEEEB24F533FCB3D25F86CD3B963D")
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(other instanceof ContentLengthHeader)        
        {
            final ContentLengthHeader o = (ContentLengthHeader) other;
            boolean var5CDEA77036187634C36DF20CD1326BCC_2117988726 = (this.getContentLength() == o.getContentLength());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1017264750 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1017264750;
        } 
        boolean var68934A3E9455FA72420237EB05902327_604761481 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1107757449 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1107757449;
        
        
            
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.291 -0400", hash_original_field = "0A8F14B7447B017C5FFCEC85C0E796E8", hash_generated_field = "0DAE05D7BF9A340249D2F42939DD9CA2")

    private static final long serialVersionUID = 1187190542411037027L;
}

