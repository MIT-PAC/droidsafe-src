package com.google.android.gms.drive.metadata;


import java.util.Collection;
import java.util.LinkedList;

import android.os.Bundle;

import com.google.android.gms.common.data.DataHolder;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public abstract interface SearchableMetadataField extends com.google.android.gms.drive.metadata.MetadataField
{
	
	public static class DroidsafeSearchableMetadataField implements SearchableMetadataField {

		public DroidsafeSearchableMetadataField() {
			
		}

		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "<some-name>";
		}

		@Override
		public Collection gC() {
			// TODO Auto-generated method stub
			return new LinkedList<Object>();
		}

		@Override
		public Object e(Bundle r0) {
			// TODO Auto-generated method stub
			Object o = new Object();
			o.addTaint(r0.getTaint());
			return o;
		}

		@Override
		public Object a(DataHolder r0, int i1, int i2) {
			// TODO Auto-generated method stub

			Object o = new Object();
			o.addTaint(r0.getTaintInt() + i1 + i2);
			return null;
		}

		@Override
		public void a(Object r0, Bundle r1) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
