package com.google.android.gms.common.api;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.TimeUnit;

public class GoogleApiClientImpl implements GoogleApiClient {

    public android.os.Looper getLooper() {
        return null;
    }

    @DSSink({DSSinkKind.GOOGLE_SERVICES})
    @DSSpec(DSCat.SPEC_OTHERS)
    public void connect() {
    }

    public ConnectionResult blockingConnect() {
        return null;
    }

    public ConnectionResult blockingConnect(long  l0, java.util.concurrent.TimeUnit  r1) {
        return null;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    public void disconnect(){}

    public void reconnect(){}

    public void stopAutoManage(){}

    @DSSafe(DSCat.SAFE_OTHERS)
    public boolean isConnected(){
        return true;
    }

    public boolean isConnecting() {
        return true;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    public void registerConnectionCallbacks(ConnectionCallbacks  r0){}

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks  r0){
        return true;
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks  r0){}

    @DSSafe(DSCat.SAFE_OTHERS)
    public void registerConnectionFailedListener(OnConnectionFailedListener  r0){}

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener  r0){
        return true;
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener  r0){}
}
