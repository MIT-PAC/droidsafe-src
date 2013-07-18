package org.apache.http.client.methods;

// Droidsafe Imports
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.utils.CloneUtils;
import org.apache.http.conn.ClientConnectionRequest;
import org.apache.http.conn.ConnectionReleaseTrigger;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class HttpEntityEnclosingRequestBase extends HttpRequestBase implements HttpEntityEnclosingRequest {
    private HttpEntity entity;
    
    @DSModeled(DSC.SPEC)
	public HttpEntityEnclosingRequestBase() {
        super();
    }

    
    @DSModeled(DSC.SPEC)
	@Override
	   public HttpEntity getEntity() {
        return this.entity;
    }

    
    @DSModeled(DSC.SPEC)
	@Override
    public void setEntity(final HttpEntity entity) {
        this.entity = entity;
    }

    
    @Override
	public boolean expectContinue() {
		// TODO Auto-generated method stub
		return false;
	}

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-18 10:21:02.168 -0400", hash_original_method = "E7A680A098600990FE1B80B7489E8A9A", hash_generated_method = "D815820FCC8EF4C0A6C9694194C550BC")
    @Override
    public Object clone() throws CloneNotSupportedException {
        HttpEntityEnclosingRequestBase clone = (HttpEntityEnclosingRequestBase) super.clone();
        if(this.entity != null)        
        {
            clone.entity = (HttpEntity) CloneUtils.clone(this.entity);
        } //End block
Object var3DE52045BFD3C1BF3742F994ED6139AD_777496266 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_777496266.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_777496266;
        // ---------- Original Method ----------
        //HttpEntityEnclosingRequestBase clone = 
            //(HttpEntityEnclosingRequestBase) super.clone();
        //if (this.entity != null) {
            //clone.entity = (HttpEntity) CloneUtils.clone(this.entity);
        //}
        //return clone;
    }

    
    // orphaned legacy method
    @Override
	public RequestLine getRequestLine() {
		// TODO Auto-generated method stub
		return null;
	}
    
    // orphaned legacy method
    @Override
	public ProtocolVersion getProtocolVersion() {
		// TODO Auto-generated method stub
		return null;
	}
    
    // orphaned legacy method
    @Override
	public void setConnectionRequest(ClientConnectionRequest arg0)
			throws IOException {
		// TODO Auto-generated method stub
		
	}
    
    // orphaned legacy method
    @Override
	public boolean isAborted() {
		// TODO Auto-generated method stub
		return false;
	}
    
    // orphaned legacy method
    @Override
	public void setReleaseTrigger(ConnectionReleaseTrigger arg0)
			throws IOException {
		// TODO Auto-generated method stub
		
	}
    
    // orphaned legacy method
    @Override
	public void abort() throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		
	}
    
    // orphaned legacy method
    @Override
	public URI getURI() {
		// TODO Auto-generated method stub
		return null;
	}
    
    // orphaned legacy method
    @Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return null;
	}
    
}

