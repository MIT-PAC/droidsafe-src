package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public abstract interface DriveFile extends com.google.android.gms.drive.DriveResource
{
    public static final int MODE_READ_ONLY = 268435456;
    public static final int MODE_READ_WRITE = 805306368;
    public static final int MODE_WRITE_ONLY = 536870912;

    //public abstract com.google.android.gms.common.api.PendingResult openContents(com.google.android.gms.common.api.GoogleApiClient  r0, int  i1, com.google.android.gms.drive.DriveFile$DownloadProgressListener  r2);

    public abstract com.google.android.gms.common.api.PendingResult commitAndCloseContents(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.Contents  r1);

    public abstract com.google.android.gms.common.api.PendingResult commitAndCloseContents(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.Contents  r1, com.google.android.gms.drive.MetadataChangeSet  r2);

    public abstract com.google.android.gms.common.api.PendingResult discardContents(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.Contents  r1);
}
