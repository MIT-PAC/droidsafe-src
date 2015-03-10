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

package com.google.android.maps;
     
import droidsafe.annotations.*;

public class GeoPoint
{
    
    @DSSafe(DSCat.SAFE_OTHERS)
    public GeoPoint() {
        
    }
    
    @DSSource({DSSourceKind.LOCATION})
    @DSSafe(DSCat.LOCATION)
    public int getLatitudeE6()
    {
        return 0;
    }
    
    @DSSource({DSSourceKind.LOCATION})
    @DSSafe(DSCat.LOCATION)
    public int getLongitudeE6() 
    { 
        return 0;
    }
    
    @DSSafe(DSCat.LOCATION)
    public String toString() {
        
        return "";
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    public boolean equals(Object paramObject) { 
        return this == paramObject;
    }
    
    @DSSource({DSSourceKind.LOCATION})
    @DSSafe(DSCat.LOCATION)
    public int hashCode() { 
        return 0;
    }
}
