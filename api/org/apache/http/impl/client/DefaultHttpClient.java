package org.apache.http.impl.client;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class DefaultHttpClient extends AbstractHttpClient {

	
	@DSModeled(DSC.SAFE)
	public DefaultHttpClient() {
        super(null, null);
    }
	
	protected DefaultHttpClient(ClientConnectionManager conman,
			HttpParams params) {
		super(conman, params);
		// TODO Auto-generated constructor stub
	}

}
