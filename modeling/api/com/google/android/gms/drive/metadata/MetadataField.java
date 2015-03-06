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

package com.google.android.gms.drive.metadata;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Collection;
import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;

public abstract interface MetadataField
{

    public abstract java.lang.String getName();

    public abstract java.util.Collection gC();

    public abstract java.lang.Object e(android.os.Bundle  r0);

    public abstract java.lang.Object a(com.google.android.gms.common.data.DataHolder  r0, int  i1, int  i2);

    public abstract void a(java.lang.Object  r0, android.os.Bundle  r1);

    //public abstract void a(com.google.android.gms.common.data.DataHolder  r0, com.google.android.gms.drive.metadata.internal.MetadataBundle  r1, int  i2, int  i3);
}
