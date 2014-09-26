package org.apache.http.client.methods;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.net.URI;

import droidsafe.helpers.*;

import droidsafe.runtime.*;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.conn.ConnectionReleaseTrigger;
import org.apache.http.protocol.HTTP;

public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase implements HttpEntityEnclosingRequest {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.269 -0500", hash_original_field = "84BEE3610D6DA557FD534AD24775E93F", hash_generated_field = "1845537B516494D16BEEE561F2E771CF")
    
    private HttpEntity entity;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.272 -0500", hash_original_method = "FDC19D27FDED1DCD2631F7F72C949E70", hash_generated_method = "6CA530C95A7C12D5ADD7AB7D0E86ECFD")
    @DSComment("Constructor")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)
public HttpEntityEnclosingRequestBase() {
        super();
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.274 -0500", hash_original_method = "FCFC1A07171F7DE920C85D2DD77008FA", hash_generated_method = "F26E442D152B9CF496C6F072484628AD")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public HttpEntity getEntity() {
        return this.entity;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.276 -0500", hash_original_method = "ACC3C31B4104E926438E24B159B6E3A2", hash_generated_method = "79AAFF6E92B5322E414271D0A9826A70")
    @DSVerified
    @DSSafe(DSCat.DATA_STRUCTURE)
public void setEntity(final HttpEntity entity) {
        this.entity = entity;
    }
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)

    @Override
	public boolean expectContinue() {
		// TODO Auto-generated method stub
		return false;
	}
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:44.281 -0500", hash_original_method = "E7A680A098600990FE1B80B7489E8A9A", hash_generated_method = "A02B4AE2B32DDDCA85245A69D05B6DB7")
    @DSVerified
    @DSSafe(DSCat.SAFE_OTHERS)

@Override
    public Object clone() throws CloneNotSupportedException {
        HttpEntityEnclosingRequestBase clone = 
            (HttpEntityEnclosingRequestBase) super.clone();
        if (this.entity != null) {
            clone.entity = (HttpEntity) CloneUtils.clone(this.entity);
        }
        return clone;
    }
}

