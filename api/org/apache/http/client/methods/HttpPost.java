package org.apache.http.client.methods;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class HttpPost extends HttpEntityEnclosingRequestBase {

	private DSTaintObject taint = new DSTaintObject();
	
	@DSModeled(DSC.SPEC)
	public HttpPost(final String uri) {
        super();
        taint.addTaint(uri);
    }
}

