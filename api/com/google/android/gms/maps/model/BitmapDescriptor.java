package com.google.android.gms.maps.model;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;

public final class BitmapDescriptor
{
	public BitmapDescriptor(DSOnlyType dontcare)
    {
    }

	public BitmapDescriptor(DSOnlyType dontcare, double value) {
		addTaint(value);
	}
}
