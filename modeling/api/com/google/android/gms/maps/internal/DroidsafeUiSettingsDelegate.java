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

import android.os.IBinder;
import android.os.RemoteException;
import droidsafe.annotations.DSBan;
import droidsafe.annotations.DSCat;
import droidsafe.annotations.DSComment;
import droidsafe.annotations.DSSpec;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class DroidsafeUiSettingsDelegate implements IUiSettingsDelegate {

	IBinder binder;

	@DSBan(DSCat.DROIDSAFE_INTERNAL)
	public DroidsafeUiSettingsDelegate(IBinder binder) {
		this.binder = binder;
	}
	
	@Override
	@DSComment("Abstract Method")
	@DSSpec(DSCat.ABSTRACT_METHOD)
	public IBinder asBinder() {
		// TODO Auto-generated method stub
		return binder;
	}

	boolean zoomControlEnabled;
	@Override
	public void setZoomControlsEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub

		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		zoomControlEnabled = z0;
		
	}

	boolean compassEnabled;
	@Override
	public void setCompassEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		compassEnabled = z0;
		
	}

	boolean locationButtonEnabled;
	@Override
	public void setMyLocationButtonEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		locationButtonEnabled = z0;
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
	}
	
	boolean scrollGesturesEnabled;

	@Override
	public void setScrollGesturesEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		scrollGesturesEnabled = z0;
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		
	}

	boolean zoomGestureEnabled;
	@Override
	public void setZoomGesturesEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		zoomGestureEnabled = z0;
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		
	}

	boolean tiltGestureEnabled;
	@Override
	public void setTiltGesturesEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		tiltGestureEnabled = z0;
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
	}

	boolean rotateGesturesEnabled;
	@Override
	public void setRotateGesturesEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		rotateGesturesEnabled = z0;
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
	}

	@Override
	public void setAllGesturesEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		rotateGesturesEnabled = z0;
		scrollGesturesEnabled = z0;
		zoomGestureEnabled = z0;
		tiltGestureEnabled = z0;
		
	}

	@Override
	public boolean isZoomControlsEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return zoomControlEnabled;
	}

	@Override
	public boolean isCompassEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return compassEnabled;
	}

	@Override
	public boolean isMyLocationButtonEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return locationButtonEnabled;
	}

	@Override
	public boolean isScrollGesturesEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return scrollGesturesEnabled;
	}

	@Override
	public boolean isZoomGesturesEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return zoomControlEnabled;
	}

	@Override
	public boolean isTiltGesturesEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return tiltGestureEnabled;
	}

	@Override
	public boolean isRotateGesturesEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return rotateGesturesEnabled;
	}

	boolean indoorLevelPickerEnabled;
	@Override
	public void setIndoorLevelPickerEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		indoorLevelPickerEnabled = z0;
		
	}

	@Override
	public boolean isIndoorLevelPickerEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return indoorLevelPickerEnabled;
	}

}
