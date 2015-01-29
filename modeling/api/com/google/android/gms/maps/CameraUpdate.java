package com.google.android.gms.maps;

import android.os.RemoteException;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;

public final class CameraUpdate
{
	@DSBan(DSCat.DROIDSAFE_INTERNAL)
	public CameraUpdate(DSOnlyType dontcare) {
		
	}
	

	@DSBan(DSCat.DROIDSAFE_INTERNAL)
	public CameraUpdate(DSOnlyType dontcare, double type) throws RemoteException {
		addTaint(type);
		if (DroidSafeAndroidRuntime.control) {
			RemoteException ex = new RemoteException();
			ex.addTaint(type);
			throw ex;
		}

	}
}
