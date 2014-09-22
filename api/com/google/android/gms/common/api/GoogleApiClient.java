package com.google.android.gms.common.api;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.TimeUnit;

public abstract interface GoogleApiClient
{

	public interface ConnectionCallbacks {
		public static final int CAUSE_NETWORK_LOST = 2;
		public static final int CAUSE_SERVICE_DISCONNECTED = 1;
		public abstract void onConnected (Bundle connectionHint);
		public abstract void onConnectionSuspended (int cause);
	}
	public interface OnConnectionFailedListener {
		public abstract void onConnectionFailed (ConnectionResult result);
	}

    public abstract android.os.Looper getLooper();

    public abstract void connect();

    public abstract ConnectionResult blockingConnect();

    public abstract ConnectionResult blockingConnect(long  l0, java.util.concurrent.TimeUnit  r1);

    public abstract void disconnect();

    public abstract void reconnect();

    public abstract void stopAutoManage();

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void registerConnectionCallbacks(ConnectionCallbacks  r0);

    public abstract boolean isConnectionCallbacksRegistered(ConnectionCallbacks  r0);

    public abstract void unregisterConnectionCallbacks(ConnectionCallbacks  r0);

    public abstract void registerConnectionFailedListener(OnConnectionFailedListener  r0);

    public abstract boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener  r0);

    public abstract void unregisterConnectionFailedListener(OnConnectionFailedListener  r0);
}
