package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;

public abstract interface DriveApi
{
	public interface ContentsResult  extends Result{
		
		@DSSource({DSSourceKind.GOOGLE_DRIVE})
		@DSSafe(DSCat.SAFE_OTHERS)
		abstract Contents	getContents();
	}
	public interface DriveIdResult extends Result{
		@DSSource({DSSourceKind.GOOGLE_DRIVE})
		@DSSafe(DSCat.SAFE_OTHERS)
		abstract DriveId	getDriveId();
	}
	public interface MetadataBufferResult extends Result{
		abstract @DSSafe(DSCat.SAFE_OTHERS)
        MetadataBuffer	getMetadataBuffer();
	}
	
    public abstract @DSSink({DSSinkKind.GOOGLE_SERVICES})
    @DSSpec(DSCat.SPEC_OTHERS)
    com.google.android.gms.common.api.PendingResult query(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.query.Query  r1);

    public abstract @DSSpec(DSCat.SPEC_OTHERS)
    com.google.android.gms.common.api.PendingResult newContents(com.google.android.gms.common.api.GoogleApiClient  r0);

    public abstract com.google.android.gms.common.api.PendingResult discardContents(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.Contents  r1);

    public abstract com.google.android.gms.common.api.PendingResult fetchDriveId(com.google.android.gms.common.api.GoogleApiClient  r0, java.lang.String  r1);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    com.google.android.gms.drive.DriveFile getFile(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.DriveId  r1);

    public abstract com.google.android.gms.drive.OpenFileActivityBuilder newOpenFileActivityBuilder();

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    com.google.android.gms.drive.CreateFileActivityBuilder newCreateFileActivityBuilder();
    
   /* public abstract com.google.android.gms.common.api.PendingResult requestSync(com.google.android.gms.common.api.GoogleApiClient  r0);

    public abstract com.google.android.gms.drive.DriveFolder getRootFolder(com.google.android.gms.common.api.GoogleApiClient  r0);

    public abstract com.google.android.gms.drive.DriveFolder getAppFolder(com.google.android.gms.common.api.GoogleApiClient  r0);

    public abstract com.google.android.gms.drive.DriveFolder getFolder(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.DriveId  r1);
*/

}
