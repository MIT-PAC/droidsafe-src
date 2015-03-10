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

package com.google.android.gms.drive.query;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import android.os.Parcel;

public class SortOrder implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-23 10:24:29.097 -0400", hash_original_field = "1EFD6A1B3F4F2DBDF02B9960B2A079E5", hash_generated_field = "1EFD6A1B3F4F2DBDF02B9960B2A079E5")

     List KK;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-23 10:24:29.105 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "1895632691E3D0ACD93635E7B4E629BC")

     int xM;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-23 10:24:29.117 -0400", hash_original_method = "7AF2128D30AFD6729BF18D87CB1F6A35", hash_generated_method = "23CF7E773B5D10D37648FA879033AD18")
    
private SortOrder(List  r1)
    {
        this(1, r1);

        this.KK = null;
        this.xM = 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-23 10:24:29.125 -0400", hash_original_method = "A8795830091A7EC0686C6BEE4A1B8EBB", hash_generated_method = "A8795830091A7EC0686C6BEE4A1B8EBB")
    
SortOrder(int  i0, List  r1)
    {

        xM = i0;
        KK = r1;
    }

   
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-23 10:24:29.134 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {


        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-23 10:24:29.157 -0400", hash_original_method = "8ED83E57AEC56F2D206860B0476D19E0", hash_generated_method = "482DCB1E8BB4CA1750EDE8C61733DD20")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	r1.writeInt(i0 + getTaintInt());
    }

    static
    {

     /*   b r1;
        Parcelable$Creator r2;
        r1 = new b();
        r2 = (Parcelable$Creator) r1;
        CREATOR = r2;*/
    }
}
