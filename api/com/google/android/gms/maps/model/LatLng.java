package com.google.android.gms.maps.model;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import android.os.Parcel;

public final class LatLng implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.110 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "D85A02ED437AD53A72DD6BC8931F0E7E")

    private  int xM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.113 -0400", hash_original_field = "8252F2624ADBF196C106EA18112EB507", hash_generated_field = "413B5E9E01B44872B3BB3EC22E3C907F")

    public  double latitude;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.116 -0400", hash_original_field = "BB3E0D698EC9A0078EA4D66874628515", hash_generated_field = "CA8463BA7249CF7626042291B7622732")

    public  double longitude;

	public static final LatLngCreator CREATOR = new LatLngCreator();
	
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.119 -0400", hash_original_method = "E98817C1CC1CA6A57ACE02E90274E49A", hash_generated_method = "C861BA6E4661C805CA73B258D874E65D")
    
LatLng(int  i0, double  d0, double  d1)
    {

        xM = i0;

        label_0:
        {
            if (-180.0 - d1 <= 0 && d1 - 180.0 < 0)
            {
                longitude = d1;
                break label_0;
            }

            longitude = ((d1 - 180.0) % 360.0 + 360.0) % 360.0 - 180.0;
        } //end label_0:

        latitude = Math.max(-90.0, Math.min(90.0, d0));
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.123 -0400", hash_original_method = "E154E90AAB9F0EE5663295A88D557CE3", hash_generated_method = "92AA5E7B7D590279427F0A3137B8DCFC")
    
public LatLng(double  d0, double  d1)
    {
        this(1, d0, d1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.125 -0400", hash_original_method = "4085B31D8AA7B6F7F53EA4B9C215022D", hash_generated_method = "4085B31D8AA7B6F7F53EA4B9C215022D")
    
int getVersionCode()
    {
        return xM;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.128 -0400", hash_original_method = "33FE99E6236F22A9B5E3FA545B37951E", hash_generated_method = "7F5F408AA24C70ABE700CC1A1820FFEA")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	r1.writeInt(i0);
    	r1.writeDouble(latitude + longitude);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.132 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {

        return 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.136 -0400", hash_original_method = "924D566E2610DEB903A0D704763612AB", hash_generated_method = "6489EB560641CE0B3ED9577F3CE811FD")
    
public int hashCode()
    {

        byte b0, b1;
        long l2, l8;
        int i7, i13;
        b0 = (byte) (byte) 31;
        b1 = (byte) (byte) 1;
        l2 = Double.doubleToLongBits(latitude);
        i7 = 31 * b1 + (int) (l2 ^ l2 >>> 32);
        l8 = Double.doubleToLongBits(longitude);
        i13 = 31 * i7 + (int) (l8 ^ l8 >>> 32);
        return i13;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.139 -0400", hash_original_method = "2A79FB6B998BE5CB4C03180A324B1C02", hash_generated_method = "9D59168594521823948404AE4C106675")
    
public boolean equals(Object  r1)
    {

        LatLng r2;
        boolean $z1;
        if (this != r1)
        {
            if (r1 instanceof LatLng)
            {
                r2 = (LatLng) r1;

                label_1:
                {
                    if (Double.doubleToLongBits(latitude) - Double.doubleToLongBits(r2.latitude) == 0 && Double.doubleToLongBits(longitude) - Double.doubleToLongBits(r2.longitude) == 0)
                    {
                        $z1 = true;
                        break label_1;
                    }

                    $z1 = false;
                } //end label_1:

                return $z1;
            }

            return false;
        }

        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.143 -0400", hash_original_method = "42AB49A97A2BBFC62018BC5FF630D158", hash_generated_method = "2E2925DF89DB72D60EB294EB52D939F8")
public String toString()
    {
        return (new StringBuilder()).append("lat/lng: (").append(latitude).append(",").append(longitude).append(")").toString();
    }

    
}
