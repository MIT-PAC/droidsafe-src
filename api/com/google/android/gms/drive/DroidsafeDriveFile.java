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

	@DSSafe(DSCat.SAFE_OTHERS)
	@Override
	public PendingResult discardContents(GoogleApiClient r0, Contents r1) {
		// TODO Auto-generated method stub
		PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r1.getTaint());
		res.addTaint(r0.getTaint());
		return res;
	}
}
