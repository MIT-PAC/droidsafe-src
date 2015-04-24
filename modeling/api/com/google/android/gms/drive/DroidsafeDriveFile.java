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

package com.google.android.gms.drive;

import com.google.android.gms.common.api.DroidsafePendingResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

import droidsafe.annotations.*;
import droidsafe.helpers.DSOnlyType;

public class DroidsafeDriveFile implements DriveFile {

	@DSBan(DSCat.DROIDSAFE_INTERNAL)
	public DroidsafeDriveFile(DSOnlyType dontcare) {
	}

	@Override
	@DSSource({DSSourceKind.GOOGLE_DRIVE})
	public PendingResult getMetadata(GoogleApiClient r0) {
		// TODO Auto-generated method stub

		PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r0.getTaint());
		return res;
	}

	@DSSource({DSSourceKind.GOOGLE_DRIVE})
	@Override
	public PendingResult updateMetadata(GoogleApiClient r0, MetadataChangeSet r1) {
		// TODO Auto-generated method stub
		PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r1.getTaint());
		res.addTaint(r0.getTaint());
		return res;
	}

	@DSSafe(DSCat.SAFE_LIST)
    @Override
	public DriveId getDriveId() {
		// TODO Auto-generated method stub
		String idStr = new String();
		idStr.addTaint(getTaint());
		DriveId id = DriveId.decodeFromString(idStr);
		return id;
	}

	@DSSink({DSSinkKind.GOOGLE_SERVICES})
	@Override
	public PendingResult commitAndCloseContents(GoogleApiClient r0, Contents r1) {
		// TODO Auto-generated method stub
		PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r1.getTaint());
		res.addTaint(r0.getTaint());
		return res;
	}

	@DSSink({DSSinkKind.GOOGLE_SERVICES})
	@Override
	public PendingResult commitAndCloseContents(GoogleApiClient r0,
			Contents r1, MetadataChangeSet r2) {
		// TODO Auto-generated method stub
		PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r2.getTaint());
		res.addTaint(r1.getTaint());
		res.addTaint(r0.getTaint());
		return res;
	}

	@DSSafe(DSCat.SAFE_LIST)
	@Override
	public PendingResult discardContents(GoogleApiClient r0, Contents r1) {
		// TODO Auto-generated method stub
		PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r1.getTaint());
		res.addTaint(r0.getTaint());
		return res;
	}
}
