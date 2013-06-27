package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.protocol.HTTP;

public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase implements HttpEntityEnclosingRequest {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.965 -0400", hash_original_field = "F5E638CC78DD325906C1298A0C21FB6B", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    private HttpEntity entity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.965 -0400", hash_original_method = "FDC19D27FDED1DCD2631F7F72C949E70", hash_generated_method = "73C795708289CC1CAF75D642F6C62D8C")
    public  HttpEntityEnclosingRequestBase() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.975 -0400", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "B790495D17630231F9369ABB5E7A86D0")
    public HttpEntity getEntity() {
        HttpEntity varB4EAC82CA7396A68D541C85D26508E83_798831762 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_798831762 = this.entity;
        varB4EAC82CA7396A68D541C85D26508E83_798831762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_798831762;
        // ---------- Original Method ----------
        //return this.entity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.975 -0400", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "FB3E9570D6065D0B91C8CE936F48D4CA")
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
        // ---------- Original Method ----------
        //this.entity = entity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.976 -0400", hash_original_method = "A0F17E45777A46D709253948E7008FD4", hash_generated_method = "8EF51791D6744D164D5849362FA31164")
    public boolean expectContinue() {
        Header expect;
        expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        boolean var3EF098E96725F3E61B1788AFB48A2903_1914072479 = (expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue()));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_72783679 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_72783679;
        // ---------- Original Method ----------
        //Header expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        //return expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:13.996 -0400", hash_original_method = "E7A680A098600990FE1B80B7489E8A9A", hash_generated_method = "2B7B63EA8D1CFB30C9C34C67CB56C880")
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object varB4EAC82CA7396A68D541C85D26508E83_975302157 = null; //Variable for return #1
        HttpEntityEnclosingRequestBase clone;
        clone = (HttpEntityEnclosingRequestBase) super.clone();
        {
            clone.entity = (HttpEntity) CloneUtils.clone(this.entity);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_975302157 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_975302157.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_975302157;
        // ---------- Original Method ----------
        //HttpEntityEnclosingRequestBase clone = 
            //(HttpEntityEnclosingRequestBase) super.clone();
        //if (this.entity != null) {
            //clone.entity = (HttpEntity) CloneUtils.clone(this.entity);
        //}
        //return clone;
    }

    
}

