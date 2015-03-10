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
