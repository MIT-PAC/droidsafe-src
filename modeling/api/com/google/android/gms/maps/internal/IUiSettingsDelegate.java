package com.google.android.gms.maps.internal;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.IInterface;
import android.os.RemoteException;

public abstract interface IUiSettingsDelegate extends android.os.IInterface
{

    public abstract void setZoomControlsEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract void setCompassEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract void setMyLocationButtonEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract void setScrollGesturesEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract void setZoomGesturesEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract void setTiltGesturesEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract void setRotateGesturesEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract void setAllGesturesEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract boolean isZoomControlsEnabled() throws android.os.RemoteException;

    public abstract boolean isCompassEnabled() throws android.os.RemoteException;

    public abstract boolean isMyLocationButtonEnabled() throws android.os.RemoteException;

    public abstract boolean isScrollGesturesEnabled() throws android.os.RemoteException;

    public abstract boolean isZoomGesturesEnabled() throws android.os.RemoteException;

    public abstract boolean isTiltGesturesEnabled() throws android.os.RemoteException;

    public abstract boolean isRotateGesturesEnabled() throws android.os.RemoteException;

    public abstract void setIndoorLevelPickerEnabled(boolean  z0) throws android.os.RemoteException;

    public abstract boolean isIndoorLevelPickerEnabled() throws android.os.RemoteException;
}
