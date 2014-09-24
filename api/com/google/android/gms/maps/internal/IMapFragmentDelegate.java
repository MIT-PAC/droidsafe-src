package com.google.android.gms.maps.internal;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.maps.GoogleMapOptions;
import android.os.Bundle;

public abstract interface IMapFragmentDelegate extends android.os.IInterface
{

    public abstract com.google.android.gms.maps.internal.IGoogleMapDelegate getMap() throws android.os.RemoteException;

    public abstract void onCreate(android.os.Bundle  r0) throws android.os.RemoteException;


    public abstract void onResume() throws android.os.RemoteException;

    public abstract void onPause() throws android.os.RemoteException;

    public abstract void onDestroyView() throws android.os.RemoteException;

    public abstract void onDestroy() throws android.os.RemoteException;

    public abstract void onLowMemory() throws android.os.RemoteException;

    public abstract void onSaveInstanceState(android.os.Bundle  r0) throws android.os.RemoteException;

    public abstract boolean isReady() throws android.os.RemoteException;
}
