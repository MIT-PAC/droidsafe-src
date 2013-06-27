package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolException;
import org.apache.http.protocol.HTTP;

public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.456 -0400", hash_original_field = "F5E638CC78DD325906C1298A0C21FB6B", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    private HttpEntity entity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.457 -0400", hash_original_method = "88CBAA7B24A092901AFE36A2F3DCB57C", hash_generated_method = "71E4F64AC35EE8B5EA69812641731FEB")
    public  EntityEnclosingRequestWrapper(final HttpEntityEnclosingRequest request) throws ProtocolException {
        super(request);
        this.entity = request.getEntity();
        // ---------- Original Method ----------
        //this.entity = request.getEntity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.457 -0400", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "C4693C67410C6E31BB7B290FE1E0AFB4")
    public HttpEntity getEntity() {
        HttpEntity varB4EAC82CA7396A68D541C85D26508E83_1044268570 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1044268570 = this.entity;
        varB4EAC82CA7396A68D541C85D26508E83_1044268570.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1044268570;
        // ---------- Original Method ----------
        //return this.entity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.458 -0400", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "FB3E9570D6065D0B91C8CE936F48D4CA")
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
        // ---------- Original Method ----------
        //this.entity = entity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.458 -0400", hash_original_method = "A0F17E45777A46D709253948E7008FD4", hash_generated_method = "C63BE83F749284DE1A89B5573C7B8704")
    public boolean expectContinue() {
        Header expect;
        expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        boolean var3EF098E96725F3E61B1788AFB48A2903_543834834 = (expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1507127848 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1507127848;
        // ---------- Original Method ----------
        //Header expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        //return expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:15.469 -0400", hash_original_method = "AEA1B1291DB01B3F8E06B03994A3FDB3", hash_generated_method = "DD1784C5C3356FBE6500362D4CDB150F")
    @Override
    public boolean isRepeatable() {
        boolean var9A8594905BA60694862272C27C406423_1023895355 = (this.entity == null || this.entity.isRepeatable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1877841311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1877841311;
        // ---------- Original Method ----------
        //return this.entity == null || this.entity.isRepeatable();
    }

    
}

