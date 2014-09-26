package com.google.android.gms.drive;

import com.google.android.gms.common.api.DroidsafePendingResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.query.Query;

import droidsafe.annotations.*;
import droidsafe.helpers.DSOnlyType;

public class DroidsafeDriveApi implements DriveApi {

	public DroidsafeDriveApi(DSOnlyType dontcare) {
		
	}
	
	@Override
	public PendingResult query(GoogleApiClient r0, Query r1) {
		// TODO Auto-generated method stub
		PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r1.getTaint());
		res.addTaint(r0.getTaint());
		return res;
	}

	@Override
	public PendingResult newContents(GoogleApiClient r0) {
		// TODO Auto-generated method stub

		PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r0.getTaint());
		return res;
	}

	@Override
	public PendingResult discardContents(GoogleApiClient r0, Contents r1) {
		// TODO Auto-generated method stub
        PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r0.getTaint());
		res.addTaint(r1.hashCode());
		return res;
	}

	@Override
	public PendingResult fetchDriveId(GoogleApiClient r0, String r1) {
		// TODO Auto-generated method stub
        PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r0.getTaint());
		res.addTaint(r1.hashCode());
		return res;
	}

	@DSSource({DSSourceKind.GOOGLE_DRIVE})
	@Override
	public DriveFile getFile(GoogleApiClient r0, DriveId r1) {
		// TODO Auto-generated method stub
		DriveFile driveFile = new DroidsafeDriveFile(DSOnlyType.DONTCARE);
		return driveFile;
	}

	@Override
	public CreateFileActivityBuilder newCreateFileActivityBuilder() {
		// TODO Auto-generated method stub
		CreateFileActivityBuilder builder = new CreateFileActivityBuilder();
		builder.addTaint(getTaint());
		return builder;
	}

	@DSSource({DSSourceKind.GOOGLE_DRIVE})
	public DriveFolder getRootFolder(GoogleApiClient r0) {
		// TODO Auto-generated method stub
		return null;
	}

	@DSSource({DSSourceKind.GOOGLE_DRIVE})
	public DriveFolder getAppFolder(GoogleApiClient r0) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@DSSource({DSSourceKind.GOOGLE_DRIVE})
	public DriveFolder getFolder(GoogleApiClient r0, DriveId r1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpenFileActivityBuilder newOpenFileActivityBuilder() {
		// TODO Auto-generated method stub
		return null;
	}


	public PendingResult requestSync(GoogleApiClient r0) {
		// TODO Auto-generated method stub
		PendingResult res = new DroidsafePendingResult(DSOnlyType.DONTCARE);
		res.addTaint(r0.getTaint());
		return res;
	}

}
