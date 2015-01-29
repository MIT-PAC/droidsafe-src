package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;
import droidsafe.annotations.*;
import droidsafe.helpers.DSOnlyType;

import android.os.Bundle;
import android.os.Looper;

import com.google.android.gms.common.ConnectionResult;

public class DroidsafeGoogleApiClient implements GoogleApiClient {

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public Looper getLooper() {
		// TODO Auto-generated method stub
		return Looper.myLooper();
	}

	@DSSpec(DSCat.SPEC_OTHERS)
    @Override
	@DSSink({DSSinkKind.GOOGLE_SERVICES})
	public void connect() {
		// TODO Auto-generated method stub
		
	}

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public ConnectionResult blockingConnect() {
		// TODO Auto-generated method stub
		ConnectionResult result = new ConnectionResult(DSOnlyType.DONTCARE);
		result.addTaint(getTaint());
		return result;
	}

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public ConnectionResult blockingConnect(long l0, TimeUnit r1) {
		// TODO Auto-generated method stub
		ConnectionResult result = new ConnectionResult(DSOnlyType.DONTCARE);
		result.addTaint(getTaintInt() + l0 + r1.getTaintInt());
		return result;
	}

	@DSSafe(DSCat.SAFE_LIST)
	@Override
	public void disconnect() {
		// TODO Auto-generated method stub
		
	}

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public void reconnect() {
		// TODO Auto-generated method stub
		
	}

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public void stopAutoManage() {
		// TODO Auto-generated method stub
		
	}

	@DSSafe(DSCat.SAFE_LIST)
	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return getTaintBoolean();
	}

	@Override
	public boolean isConnecting() {
		// TODO Auto-generated method stub
		return getTaintBoolean();
	}

	@DSSafe(DSCat.SAFE_LIST)
	@Override
	public void registerConnectionCallbacks(ConnectionCallbacks r0) {
		// TODO Auto-generated method stub
		Bundle b = new Bundle();
		r0.onConnected(b);
		r0.onConnectionSuspended(getTaintInt());
		
	}

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public boolean isConnectionCallbacksRegistered(ConnectionCallbacks r0) {
		// TODO Auto-generated method stub
		return (r0.getTaintBoolean() && getTaintBoolean());
	}

	@Override
	@DSSafe(DSCat.SAFE_OTHERS)
	public void unregisterConnectionCallbacks(ConnectionCallbacks r0) {
		// TODO Auto-generated method stub
		
	}

	@DSSafe(DSCat.SAFE_LIST)
	@Override
	public void registerConnectionFailedListener(OnConnectionFailedListener r0) {
		// TODO Auto-generated method stub
		ConnectionResult result = new ConnectionResult(DSOnlyType.DONTCARE);
		result.addTaint(getTaint());		
		r0.onConnectionFailed(result);
		
	}

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public boolean isConnectionFailedListenerRegistered(
			OnConnectionFailedListener r0) {
		// TODO Auto-generated method stub
		return (r0.getTaintBoolean() && getTaintBoolean());
	}

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public void unregisterConnectionFailedListener(OnConnectionFailedListener r0) {
		// TODO Auto-generated method stub
		
	}
}
