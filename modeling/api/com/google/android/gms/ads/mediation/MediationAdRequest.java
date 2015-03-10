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

package com.google.android.gms.ads.mediation;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Date;
import java.util.Set;
import droidsafe.annotations.*;

public abstract interface MediationAdRequest
{
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;

    public abstract @DSSource({DSSourceKind.AD})
    @DSSafe(DSCat.SAFE_OTHERS)
    java.util.Date getBirthday();

    public abstract @DSSource({DSSourceKind.AD})
    @DSSafe(DSCat.SAFE_OTHERS)
    int getGender();

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    java.util.Set getKeywords();

    public abstract int taggedForChildDirectedTreatment();

    public abstract @DSSafe(DSCat.SAFE_OTHERS)
    boolean isTesting();
}
