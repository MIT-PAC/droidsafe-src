package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;

import com.google.android.gms.maps.model.CameraPosition;

import droidsafe.annotations.DSCat;
import droidsafe.annotations.DSComment;
import droidsafe.annotations.DSSafe;
import droidsafe.annotations.DSSpec;
import droidsafe.concrete.DroidSafeBinder;
import droidsafe.helpers.DSOnlyType;
import droidsafe.runtime.DroidSafeAndroidRuntime;

public class DroidsafeGoogleMapDelegate implements IGoogleMapDelegate {

	IBinder selfBinder = null;
	public DroidsafeGoogleMapDelegate(IBinder binder) {
		selfBinder = binder; 
	}

	@Override
	@DSComment("Abstract Method")
	@DSSafe
	public IBinder asBinder() {
		// TODO Auto-generated method stub
		return selfBinder;
	}

	@DSSafe
	@Override
	public void setPadding(int i0, int i1, int i2, int i3)
			throws RemoteException {
		// TODO Auto-generated method stub
		addTaint(i0 + i1 + i2 + i3);
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}

		
	}
	
	boolean buildingsEnabled = false;

	@Override
	@DSSafe
	public boolean isBuildingsEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return buildingsEnabled;
	}

	@Override
	@DSSafe
	public void setBuildingsEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
        buildingsEnabled = z0;
		
	}

	@Override
	@DSSafe
	public void setWatermarkEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		addTaint(z0);
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		
	}

	@Override
	public void stopAnimation() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getMaxZoomLevel() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return getTaintFloat();
	}

	@Override
	public float getMinZoomLevel() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return getTaintFloat();
	}

	@Override
	public void clear() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	int mapType;
	@Override
	public int getMapType() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return mapType;
	}

	@Override
	public void setMapType(int i0) throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		mapType = i0;
		
	}
	
	boolean trafficEnabled = false;

	@Override
	public boolean isTrafficEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return trafficEnabled;
	}

	@Override
	public void setTrafficEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		trafficEnabled = z0;
		
	}
	
	boolean indoorEnabled;

	@Override
	public boolean isIndoorEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return indoorEnabled;
	}

	@Override
	public boolean setIndoorEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		indoorEnabled = z0;
		return indoorEnabled;
	}

	boolean locationEnabled;
	@Override
	public boolean isMyLocationEnabled() throws RemoteException {
		// TODO Auto-generated method stub
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		return locationEnabled;
	}

	@Override
	public void setMyLocationEnabled(boolean z0) throws RemoteException {
		// TODO Auto-generated method stub
		
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(getTaint());
			throw ex;
		}
		locationEnabled = z0;
	}

	@Override
	public Location getMyLocation() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CameraPosition getCameraPosition() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	IUiSettingsDelegate uiSettings;
	@Override
	public IUiSettingsDelegate getUiSettings() throws RemoteException {
		// TODO Auto-generated method stub
		if (uiSettings == null)
			uiSettings = new DroidsafeUiSettingsDelegate(selfBinder);
		return uiSettings;
	}

}
