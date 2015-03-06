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

package com.google.android.gms.maps;

import com.google.android.gms.maps.internal.DroidsafeGoogleMapDelegate;
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

import droidsafe.annotations.*;
import droidsafe.concrete.DroidSafeBinder;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.app.Activity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

public class MapFragment extends Fragment
{

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.709 -0400", hash_original_method = "CC44EBC287319B4B8DC3DF4F5504C61E", hash_generated_method = "4DA35F8E4562B5347E79D1577EF2D825")
    
public static MapFragment newInstance()
    {
        return new MapFragment();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.714 -0400", hash_original_method = "CFC71E2DB30AF44827EE73A6A797018A", hash_generated_method = "459D7C92431BD4919AB51BC9B76A3394")
    
public static MapFragment newInstance(GoogleMapOptions  r0)
    {

        MapFragment r5;
        Bundle r6;
        Parcelable r7;
        r5 = new MapFragment();
        r6 = new Bundle();
        r7 = (Parcelable) r0;
        r6.putParcelable("MapOptions", r7);
        r5.setArguments(r6);
        return r5;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.706 -0400", hash_original_field = "16473B2F56949AF6A49BB0FF31CE05A1", hash_generated_field = "2A243FBA6C87A6254B4FB4601B0DBF32")

    private GoogleMap ZD;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.717 -0400", hash_original_method = "10A7D34200874188239A1C6259A77C74", hash_generated_method = "71C7E017C243F7EF2039CE58FD5BE70A")
    
public MapFragment()
    {
    	DroidSafeBinder binder = new DroidSafeBinder(DSOnlyType.DONTCARE);
    	googleMap = new GoogleMap(new DroidsafeGoogleMapDelegate(binder));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.720 -0400", hash_original_method = "16D3C4B072E7E43928E7ADC13182C174", hash_generated_method = "7A67C5B61903B9F5A9E535AA4120C9CD")
    
protected IMapFragmentDelegate fragementDelegate()
    {
        return null;
    }

    GoogleMap googleMap;
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.725 -0400", hash_original_method = "40D16AF3AD525A505DCF522054434A6E", hash_generated_method = "553FBC2F1B7E69328D7336D81FCFF3C0")
    
public final GoogleMap getMap()
    {
    	return googleMap;
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.730 -0400", hash_original_method = "5F2C3381706F5A7C85E1E0E652EA6D95", hash_generated_method = "7F3037BC47BCD5E1BCE13DA4A1470892")
    
public void onAttach(Activity  r1)
    {
        super.onAttach(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.737 -0400", hash_original_method = "7DAEF8F35C2FE3E2047D5802E0967BF6", hash_generated_method = "079466DC2281CA58655CA32E5183C3F8")
    
public void onInflate(Activity  r1, AttributeSet  r2, Bundle  r3)
    {
        super.onInflate(r1, r2, r3);
        GoogleMapOptions r4;
        Bundle r9;
        Parcelable r10;
        r4 = GoogleMapOptions.createFromAttributes(r1, r2);
        r9 = new Bundle();
        r10 = (Parcelable) r4;
        r9.putParcelable("MapOptions", r10);
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.743 -0400", hash_original_method = "F0C1DD10C068EF145E655CC853186BDA", hash_generated_method = "EA66CA934D06B2B652D8C0D5F46F5118")
    
public void onCreate(Bundle  r1)
    {
        super.onCreate(r1);
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.750 -0400", hash_original_method = "621F5CFCEF36307A2F667B7B746DD466", hash_generated_method = "2DEB2523251D25731148FBD76198B768")
    
public View onCreateView(LayoutInflater  r1, ViewGroup  r2, Bundle  r3)
    {

        return super.onCreateView(r1, r2, r3);
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.753 -0400", hash_original_method = "8A5943792A631AC0907EC67FD2B96764", hash_generated_method = "4F13E4CDAECEE57914B2BBE6F4CBD411")
    
public void onResume()
    {
    	super.onResume();
    }

    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.756 -0400", hash_original_method = "369EAE0B495D0B5CB3640443718195A9", hash_generated_method = "6CD8E07DA238124587A962813BD2D300")
    
public void onPause()
    {
    	super.onPause();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.759 -0400", hash_original_method = "EE80E6B1D8591BAADC50FD48D448A5F7", hash_generated_method = "006362B995E4FC2F29B0716087D64EF0")
    
public void onDestroyView()
    {
    	super.onDestroyView();

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.762 -0400", hash_original_method = "D84D039E674097BACFAD7A90E1B9D844", hash_generated_method = "1AF113E79F115B783EAD7202A10F71B2")
    
public void onDestroy()
    {
    	super.onDestroy();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.767 -0400", hash_original_method = "563476AFB33B67BEF38DEAFEF12700DA", hash_generated_method = "CEC2B894D6BFB45F22B85594CD342C90")
    
public void onLowMemory()
    {
        super.onLowMemory();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.772 -0400", hash_original_method = "8233618D96C0B024A8BB307DA746C158", hash_generated_method = "2E8B0C97330021961F269FD7D7738C45")
    
public void onActivityCreated(Bundle  r1)
    {
        super.onActivityCreated(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.776 -0400", hash_original_method = "B12752C9171E8E9B24E21C580AC1A171", hash_generated_method = "3E6E0997681B398FBE69713F74A50EB9")
    
public void onSaveInstanceState(Bundle  r1)
    {
        super.onSaveInstanceState(r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:50.779 -0400", hash_original_method = "D76282C62A93CE875451E21488810DB0", hash_generated_method = "F50CCF7F38312349B17D5842B9F8249E")
    
public void setArguments(Bundle  r1)
    {

        super.setArguments(r1);
    }
}
