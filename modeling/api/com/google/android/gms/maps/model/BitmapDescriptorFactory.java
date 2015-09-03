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

package com.google.android.gms.maps.model;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.RemoteException;
import android.graphics.Bitmap;

public final class BitmapDescriptorFactory
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.875 -0400", hash_original_field = "F4741765AC38569CBE4F369ECC58B8F1", hash_generated_field = "46616BB72AB54BEA8BBBA355F0F7F6C9")

    public static final float HUE_RED = 0.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.879 -0400", hash_original_field = "5C4FF4D0A291F1421D72523E05CE1953", hash_generated_field = "AF47DBB2A67A3ACF79D95FBACFA18BC0")

    public static final float HUE_ORANGE = 30.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.882 -0400", hash_original_field = "E89B174211300D6DA36EF2FEB9AD902B", hash_generated_field = "92905B31B09BED992C642865CF2FB303")

    public static final float HUE_YELLOW = 60.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.885 -0400", hash_original_field = "705BCB29ACA25959E57C38DF640250DF", hash_generated_field = "9508DF4DFABD83A1D9CD10C196C5FC54")

    public static final float HUE_GREEN = 120.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.888 -0400", hash_original_field = "D98D491E61103FE66B6373DB2F553D83", hash_generated_field = "60B7239EA464C8298E50794D6F951720")

    public static final float HUE_CYAN = 180.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.891 -0400", hash_original_field = "050C6A09D2847DB070065E0530985E37", hash_generated_field = "EE4E37BC89FFF65EF08F6C6BFFC707DE")

    public static final float HUE_AZURE = 210.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.895 -0400", hash_original_field = "28EED0C236FFF851B7BECEEC8F2454C2", hash_generated_field = "F3B5185643E245C1BBA123F754A404E0")

    public static final float HUE_BLUE = 240.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.898 -0400", hash_original_field = "E8A7022783C05D9DAD7564F44171B4E4", hash_generated_field = "30823F07A24D4230B5889454D338690C")

    public static final float HUE_VIOLET = 270.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.902 -0400", hash_original_field = "ADAE5DA3B406BCB7C1BA9865615B345E", hash_generated_field = "EED7284468124AFB47573F62F91AD405")

    public static final float HUE_MAGENTA = 300.0f;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.905 -0400", hash_original_field = "647E6B0F2438245505F615DA36A3370C", hash_generated_field = "6F340B29F1812B6566A5DB9AD0A1957C")

    public static final float HUE_ROSE = 330.0f;

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.919 -0400", hash_original_method = "34C8904662AF6CED033FBA7DF5A64AA5", hash_generated_method = "9244C9F05CF221BB150A14B201E82E39")
    
public static BitmapDescriptor fromResource(int  i0)
    {
        return new BitmapDescriptor(DSOnlyType.DONTCARE, i0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.923 -0400", hash_original_method = "58138B23A297CB6E631448ECBFB9769E", hash_generated_method = "DEAB33A143BC7CCBA7D3930D9021FB1B")
    
public static BitmapDescriptor fromAsset(String  r0)
    {
        return new BitmapDescriptor(DSOnlyType.DONTCARE, r0.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.927 -0400", hash_original_method = "2900DBC1FACA53DC716984ABC5FA34C2", hash_generated_method = "C3DEEE4C5B2C3DED9D3518AC93785ECD")
    
public static BitmapDescriptor fromFile(String  r0)
    {
        return new BitmapDescriptor(DSOnlyType.DONTCARE, r0.length());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.931 -0400", hash_original_method = "D2C97EE4CB27C1EC8B00E6BE0D5C4260", hash_generated_method = "74CC91B5E4354BD3053E7295732C7E68")
    
public static BitmapDescriptor fromPath(String  r0)
    {
        return new BitmapDescriptor(DSOnlyType.DONTCARE, r0.length());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.935 -0400", hash_original_method = "80C38EE9AE082C14857009286386EAD1", hash_generated_method = "53E973361CA9E86AFED7C3B05D04B660")
    
public static BitmapDescriptor defaultMarker()
    {
        return new BitmapDescriptor(DSOnlyType.DONTCARE, 0);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.940 -0400", hash_original_method = "E860CDC83BC4CAB223150EAC469DDECE", hash_generated_method = "F4B7F1B66BFC53CB8154B435C6E7DB89")
    
public static BitmapDescriptor defaultMarker(float  f0)
    {
        return new BitmapDescriptor(DSOnlyType.DONTCARE, 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.945 -0400", hash_original_method = "D9CB2B022CC93B4A2039B5C3D20F0D75", hash_generated_method = "CF4C4F314DD7F431F1BB5F4A839C0541")
    
public static BitmapDescriptor fromBitmap(Bitmap  r0)
    {
        return new BitmapDescriptor(DSOnlyType.DONTCARE, r0.getTaintInt());
    }
}
