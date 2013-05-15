package org.apache.http.entity;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class AbstractHttpEntity implements HttpEntity {
	protected Header contentType;
    protected Header contentEncoding;
    protected boolean chunked;
    
	@DSModeled(DSC.SAFE)
	protected AbstractHttpEntity() {}
	
	public void setContentType(final Header contentType) {
        this.contentType = contentType;
    }
	
	public void setContentType(final String ctString) {
        Header h = null;
        if (ctString != null) {
            h = new BasicHeader(HTTP.CONTENT_TYPE, ctString);
        }
        setContentType(h);
    }

}
