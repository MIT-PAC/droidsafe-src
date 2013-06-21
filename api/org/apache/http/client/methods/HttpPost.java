package org.apache.http.client.methods;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class HttpPost extends HttpEntityEnclosingRequestBase {

	
	@DSModeled(DSC.SPEC)
	public HttpPost(final String uri) {
        super();
        addTaint(uri);
    }
}

