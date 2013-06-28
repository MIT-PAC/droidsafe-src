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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.282 -0400", hash_original_field = "F5E638CC78DD325906C1298A0C21FB6B", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    private HttpEntity entity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.283 -0400", hash_original_method = "88CBAA7B24A092901AFE36A2F3DCB57C", hash_generated_method = "71E4F64AC35EE8B5EA69812641731FEB")
    public  EntityEnclosingRequestWrapper(final HttpEntityEnclosingRequest request) throws ProtocolException {
        super(request);
        this.entity = request.getEntity();
        // ---------- Original Method ----------
        //this.entity = request.getEntity();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.283 -0400", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "010AA24BB9FC2EC2AAD4C881EEEDBCC9")
    public HttpEntity getEntity() {
        HttpEntity varB4EAC82CA7396A68D541C85D26508E83_1479611416 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1479611416 = this.entity;
        varB4EAC82CA7396A68D541C85D26508E83_1479611416.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1479611416;
        // ---------- Original Method ----------
        //return this.entity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.283 -0400", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "FB3E9570D6065D0B91C8CE936F48D4CA")
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
        // ---------- Original Method ----------
        //this.entity = entity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.284 -0400", hash_original_method = "A0F17E45777A46D709253948E7008FD4", hash_generated_method = "02130602F5D45FC1CC948F968FA63316")
    public boolean expectContinue() {
        Header expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        boolean var3EF098E96725F3E61B1788AFB48A2903_1232739568 = (expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1709755407 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1709755407;
        // ---------- Original Method ----------
        //Header expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        //return expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:40.284 -0400", hash_original_method = "AEA1B1291DB01B3F8E06B03994A3FDB3", hash_generated_method = "97C3E05C2D6BE23685165B88E1A44E39")
    @Override
    public boolean isRepeatable() {
        boolean var9A8594905BA60694862272C27C406423_2142916072 = (this.entity == null || this.entity.isRepeatable());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1655511221 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1655511221;
        // ---------- Original Method ----------
        //return this.entity == null || this.entity.isRepeatable();
    }

    
}

