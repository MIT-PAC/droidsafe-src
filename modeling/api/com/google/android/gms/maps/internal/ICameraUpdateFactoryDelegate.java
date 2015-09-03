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
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;

public abstract interface ICameraUpdateFactoryDelegate extends android.os.IInterface
{

/*    public abstract com.google.android.gms.dynamic.d zoomIn() throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d zoomOut() throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d scrollBy(float  f0, float  f1) throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d zoomTo(float  f0) throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d zoomBy(float  f0) throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d zoomByWithFocus(float  f0, int  i1, int  i2) throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d newCameraPosition(com.google.android.gms.maps.model.CameraPosition  r0) throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d newLatLng(com.google.android.gms.maps.model.LatLng  r0) throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d newLatLngZoom(com.google.android.gms.maps.model.LatLng  r0, float  f1) throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d newLatLngBounds(com.google.android.gms.maps.model.LatLngBounds  r0, int  i1) throws android.os.RemoteException;

    public abstract com.google.android.gms.dynamic.d newLatLngBoundsWithSize(com.google.android.gms.maps.model.LatLngBounds  r0, int  i1, int  i2, int  i3) throws android.os.RemoteException;
    */
}
