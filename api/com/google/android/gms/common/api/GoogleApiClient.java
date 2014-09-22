package com.google.android.gms.common.api;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import java.util.concurrent.TimeUnit;

public abstract interface GoogleApiClient
{

    public abstract com.google.android.gms.common.api.a$b a(com.google.android.gms.common.api.a$b  r0);

    public abstract com.google.android.gms.common.api.a$b b(com.google.android.gms.common.api.a$b  r0);

    public abstract com.google.android.gms.common.api.Api$a a(com.google.android.gms.common.api.Api$c  r0);

    public abstract android.os.Looper getLooper();

    public abstract void connect();

    public abstract com.google.android.gms.common.ConnectionResult blockingConnect();

    public abstract com.google.android.gms.common.ConnectionResult blockingConnect(long  l0, java.util.concurrent.TimeUnit  r1);

    public abstract void disconnect();

    public abstract void reconnect();

    public abstract void stopAutoManage();

    public abstract boolean isConnected();

    public abstract boolean isConnecting();

    public abstract void registerConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks  r0);

    public abstract boolean isConnectionCallbacksRegistered(com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks  r0);

    public abstract void unregisterConnectionCallbacks(com.google.android.gms.common.api.GoogleApiClient$ConnectionCallbacks  r0);

    public abstract void registerConnectionFailedListener(com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener  r0);

    public abstract boolean isConnectionFailedListenerRegistered(com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener  r0);

    public abstract void unregisterConnectionFailedListener(com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener  r0);
}
