/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */

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
