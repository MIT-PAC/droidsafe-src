package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public abstract interface DriveResource
{

    public abstract com.google.android.gms.common.api.PendingResult getMetadata(com.google.android.gms.common.api.GoogleApiClient  r0);

    public abstract com.google.android.gms.common.api.PendingResult updateMetadata(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.MetadataChangeSet  r1);

    public abstract @DSSource({DSSourceKind.GOOGLE_DRIVE})
    @DSSafe(DSCat.SAFE_OTHERS)
    com.google.android.gms.drive.DriveId getDriveId();

//    public abstract com.google.android.gms.common.api.PendingResult listParents(com.google.android.gms.common.api.GoogleApiClient  r0);
//
//    public abstract com.google.android.gms.common.api.PendingResult addChangeListener(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.events.DriveEvent$Listener  r1);
//
//    public abstract com.google.android.gms.common.api.PendingResult removeChangeListener(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.events.DriveEvent$Listener  r1);
//}
}
