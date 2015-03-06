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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.concurrent.TimeUnit;

public abstract interface PendingResult
{

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    com.google.android.gms.common.api.Result await();

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    com.google.android.gms.common.api.Result await(long  l0, java.util.concurrent.TimeUnit  r1);

    public abstract void cancel();

    public abstract boolean isCanceled();

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void setResultCallback(com.google.android.gms.common.api.ResultCallback  r0);

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    void setResultCallback(com.google.android.gms.common.api.ResultCallback  r0, long  l1, java.util.concurrent.TimeUnit  r2);
}
