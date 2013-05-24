package org.apache.http.impl.client;

import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class DefaultHttpClient extends AbstractHttpClient {

	private DSTaintObject taint = new DSTaintObject();
	
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
