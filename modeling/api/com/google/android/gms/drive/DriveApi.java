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
