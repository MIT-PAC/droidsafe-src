package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public abstract interface DriveFolder extends com.google.android.gms.drive.DriveResource
{
    public static final String MIME_TYPE = "application/vnd.google-apps.folder";

    public abstract com.google.android.gms.common.api.PendingResult listChildren(com.google.android.gms.common.api.GoogleApiClient  r0);

    public abstract com.google.android.gms.common.api.PendingResult queryChildren(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.query.Query  r1);

    public abstract com.google.android.gms.common.api.PendingResult createFile(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.MetadataChangeSet  r1, com.google.android.gms.drive.Contents  r2);

    public abstract com.google.android.gms.common.api.PendingResult createFolder(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.MetadataChangeSet  r1);
}
