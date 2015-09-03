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

package com.google.android.gms.common.api;

import java.util.concurrent.TimeUnit;

import com.google.android.gms.drive.DroidsafeDriveApiMultiResult;

import droidsafe.annotations.*;
import droidsafe.helpers.DSOnlyType;

public class DroidsafePendingResult implements PendingResult {

	@DSBan(DSCat.DROIDSAFE_INTERNAL)
	public DroidsafePendingResult(DSOnlyType dontcare) {
		
	}
	
	@DSSafe(DSCat.SAFE_LIST)
	@Override
	public Result await() {
		// TODO Auto-generated method stub
		Result res = new DroidsafeDriveApiMultiResult(DSOnlyType.DONTCARE, getTaintInt());
		return res;
	}

	@DSSafe(DSCat.SAFE_LIST)
	@Override
	public Result await(long l0, TimeUnit r1) {
		// TODO Auto-generated method stub
		Result res = new Status(getTaintInt());
		res.addTaint(l0);
		res.addTaint(r1.getTaintInt());
		return res;

	}

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isCanceled() {
		// TODO Auto-generated method stub
		return getTaintBoolean();
	}

	 @DSSafe(DSCat.SAFE_LIST)
	 public void setResultCallback(ResultCallback  r0) {
		 if (r0 != null) {
			 Result res = new Status(getTaintInt());
			 r0.onResult(res);
		 }
	 }

	 @DSSafe(DSCat.SAFE_LIST)
     public void setResultCallback(ResultCallback  r0, long  l1, TimeUnit  r2) {
    	 if (r0 != null) {
    		 int code = (int)(l1 + r2.hashCode() + getTaintInt());
			 Result res = new Status(code);
			 r0.onResult(res);
		 }
    	 
     }
}
