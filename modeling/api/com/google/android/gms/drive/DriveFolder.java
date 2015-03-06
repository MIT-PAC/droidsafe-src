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

public abstract interface DriveFolder extends com.google.android.gms.drive.DriveResource
{
    public static final String MIME_TYPE = "application/vnd.google-apps.folder";

    public abstract com.google.android.gms.common.api.PendingResult listChildren(com.google.android.gms.common.api.GoogleApiClient  r0);

    public abstract com.google.android.gms.common.api.PendingResult queryChildren(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.query.Query  r1);

    public abstract com.google.android.gms.common.api.PendingResult createFile(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.MetadataChangeSet  r1, com.google.android.gms.drive.Contents  r2);

    public abstract com.google.android.gms.common.api.PendingResult createFolder(com.google.android.gms.common.api.GoogleApiClient  r0, com.google.android.gms.drive.MetadataChangeSet  r1);
}
