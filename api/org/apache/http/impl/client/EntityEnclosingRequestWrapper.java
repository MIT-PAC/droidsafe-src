package org.apache.http.impl.client;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.ProtocolException;
import org.apache.http.protocol.HTTP;






public class EntityEnclosingRequestWrapper extends RequestWrapper implements HttpEntityEnclosingRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.338 -0500", hash_original_field = "84BEE3610D6DA557FD534AD24775E93F", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")

    
    private HttpEntity entity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.341 -0500", hash_original_method = "88CBAA7B24A092901AFE36A2F3DCB57C", hash_generated_method = "2F19AD4FC90EB225ED3728841BFD308A")
    
public EntityEnclosingRequestWrapper(final HttpEntityEnclosingRequest request) 
        throws ProtocolException {
        super(request);
        this.entity = request.getEntity();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.343 -0500", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "F26E442D152B9CF496C6F072484628AD")
    
public HttpEntity getEntity() {
        return this.entity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.345 -0500", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "79AAFF6E92B5322E414271D0A9826A70")
    
public void setEntity(final HttpEntity entity) {
        this.entity = entity;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.347 -0500", hash_original_method = "A0F17E45777A46D709253948E7008FD4", hash_generated_method = "EC2F72FE5FD316F8F025D2DEB714BBEF")
    
public boolean expectContinue() {
        Header expect = getFirstHeader(HTTP.EXPECT_DIRECTIVE);
        return expect != null && HTTP.EXPECT_CONTINUE.equalsIgnoreCase(expect.getValue());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:39.349 -0500", hash_original_method = "AEA1B1291DB01B3F8E06B03994A3FDB3", hash_generated_method = "48B68AF12FCD74255D21DD8664231B38")
    
@Override
    public boolean isRepeatable() {
        return this.entity == null || this.entity.isRepeatable();
    }

    
}

