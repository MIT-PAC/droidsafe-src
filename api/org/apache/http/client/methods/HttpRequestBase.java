package org.apache.http.client.methods;

import org.apache.http.message.AbstractHttpMessage;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class HttpRequestBase extends AbstractHttpMessage
	implements HttpUriRequest, AbortableHttpRequest, Cloneable {

	@DSModeled(DSC.SPEC)
	public HttpRequestBase() { 
		super();
	}
}
