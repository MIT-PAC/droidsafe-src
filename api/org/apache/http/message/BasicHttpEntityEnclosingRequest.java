package org.apache.http.message;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.protocol.HTTP;

public class BasicHttpEntityEnclosingRequest extends BasicHttpRequest implements HttpEntityEnclosingRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.473 -0400", hash_original_field = "F5E638CC78DD325906C1298A0C21FB6B", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    private HttpEntity entity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.473 -0400", hash_original_method = "3B9AEA8ADDBEE1D3D457706DB0027555", hash_generated_method = "5A221AB4F918295D6C96B40163436F64")
    public  BasicHttpEntityEnclosingRequest(final String method, final String uri) {
        super(method, uri);
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.474 -0400", hash_original_method = "81663ABF166B6EF77CF828F0FBB9FCD0", hash_generated_method = "889882ADBA9A82FD7E7E8E88B2936F00")
    public  BasicHttpEntityEnclosingRequest(final String method, final String uri, 
            final ProtocolVersion ver) {
        this(new BasicRequestLine(method, uri, ver));
        addTaint(ver.getTaint());
        addTaint(uri.getTaint());
        addTaint(method.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.475 -0400", hash_original_method = "411AD89842852D4D934BE04E93AC495C", hash_generated_method = "859E7C832CEFE5C5AB9DA47E5E03C9FF")
    public  BasicHttpEntityEnclosingRequest(final RequestLine requestline) {
        super(requestline);
        addTaint(requestline.getTaint());
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.475 -0400", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "47F9447E532AD1D9C3B9356A7E990E23")
    public HttpEntity getEntity() {
HttpEntity varB0390008473457B24431D383C02B7BE2_1774602571 =         this.entity;
        varB0390008473457B24431D383C02B7BE2_1774602571.addTaint(taint);
        return varB0390008473457B24431D383C02B7BE2_1774602571;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.476 -0400", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "FB3E9570D6065D0B91C8CE936F48D4CA")
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:37.476 -0400", hash_original_method = "A0F17E45777A46D709253948E7008FD4", hash_generated_method = "48215C10E8468FD03CE1BDF337B5FA92")
    public boolean expectContinue() {
        Header expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        boolean varBD99B96B93C1B43067A5D22A1607F29C_295984578 = (expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_389847354 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_389847354;
        
        
        
    }

    
}

