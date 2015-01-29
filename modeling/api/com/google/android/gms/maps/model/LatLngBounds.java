package com.google.android.gms.maps.model;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import android.os.Parcel;

public class LatLngBounds implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{
	public static class Builder {

		@DSSafe(DSCat.SAFE_OTHERS)
		public Builder() {
			
		}
		@DSSafe(DSCat.SAFE_LIST)
		public LatLngBounds build () {
			LatLng point = new LatLng(getTaintDouble(), getTaintDouble());
			LatLngBounds bounds = new LatLngBounds(getTaintInt(), point, point);
			return bounds;
		}
		
		@DSSafe(DSCat.SAFE_LIST)
		public LatLngBounds.Builder include (LatLng point) {
			addTaint(point.hashCode());
			return this;
		}
	}

    @DSSafe
    public static Builder builder() {
        return new Builder();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.309 -0400", hash_original_method = "0A4EF71171EB5932175D450A061F04A0", hash_generated_method = "5EDF17CAF6BC367F87FFD624799FFAF5")
    
private static double b(double  d0, double  d1)
    {

        return (d0 - d1 + 360.0) % 360.0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.312 -0400", hash_original_method = "A8F58681F7B606AD613170ED2352E74A", hash_generated_method = "1559023A251AC21104DD9FD03D9E94DE")
    
private static double c(double  d0, double  d1)
    {

        return (d1 - d0 + 360.0) % 360.0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.331 -0400", hash_original_method = "F1270632D966D96DA01905BAE1A47AFD", hash_generated_method = "9C50DEC1E6A19343E9E7DDEB36A90C18")
    
static double d(double  d0, double  d1)
    {

        return LatLngBounds.b(d0, d1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.334 -0400", hash_original_method = "085492F4DED56822285437C4CA295BC6", hash_generated_method = "786F1754E34527F187412FE8B29452C8")
    
static double e(double  d0, double  d1)
    {

        return LatLngBounds.c(d0, d1);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.270 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "D85A02ED437AD53A72DD6BC8931F0E7E")

    private  int xM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.273 -0400", hash_original_field = "8AFF8C53D64B24A512A4F50BF2CDCBC4", hash_generated_field = "B9ED5FA6C3CA104D2506DE3123E76C97")

    public  LatLng southwest;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.276 -0400", hash_original_field = "2AEA8BE44A85645A02567116CEE41E91", hash_generated_field = "9126F26F94D31AB275317988443EFF35")

    public  LatLng northeast;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.279 -0400", hash_original_method = "C68942CC976C4730F757A9CB403B3273", hash_generated_method = "C68942CC976C4730F757A9CB403B3273")
    
LatLngBounds(int  i0, LatLng  r1, LatLng  r2)
    {
        xM = i0;
        southwest = r1;
        northeast = r2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.283 -0400", hash_original_method = "C413925C28E8F777195A8C45DEF13643", hash_generated_method = "E41618AF1F9C2C82E055954B9F31BD26")
    
public LatLngBounds(LatLng  r1, LatLng  r2)
    {
        this(1, r1, r2);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.285 -0400", hash_original_method = "4085B31D8AA7B6F7F53EA4B9C215022D", hash_generated_method = "4085B31D8AA7B6F7F53EA4B9C215022D")
    
int getVersionCode()
    {

        return xM;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.288 -0400", hash_original_method = "AF1B4B04BE158F9C9CB8CCA3690ADF15", hash_generated_method = "2A87FDF8FB7CFB7C0D1BD3495359FEC3")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	northeast.writeToParcel(r1, i0);
    	southwest.writeToParcel(r1, i0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.291 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {

        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.299 -0400", hash_original_method = "BD29DCDBA2A6DABD3F74FE9AE398A628", hash_generated_method = "4DDBC2DCDC7A2E9F80CE289DA5D637A7")
    
public boolean contains(LatLng  r1)
    {

        boolean $z2;

        label_0:
        {
            if (this.c(r1.latitude) && this.d(r1.longitude))
            {
                $z2 = true;
                break label_0;
            }

            $z2 = false;
        } //end label_0:

        return $z2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.303 -0400", hash_original_method = "93655B9B4C25205E1D8D5F0830421B80", hash_generated_method = "C858B647F4557F57026B2C8B815BE327")
    
public LatLngBounds including(LatLng  r1)
    {

        double d0, d1, d2, d3, d4;
        d0 = Math.min(southwest.latitude, r1.latitude);
        d1 = Math.max(northeast.latitude, r1.latitude);
        d2 = northeast.longitude;
        d3 = southwest.longitude;
        d4 = r1.longitude;

        if ( ! (this.d(d4)))
        {
            if (LatLngBounds.b(d3, d4) - LatLngBounds.c(d2, d4) >= 0)
            {
                d2 = d4;
            }
            else
            {
                d3 = d4;
            }
        }

        return new LatLngBounds(new LatLng(d0, d3), new LatLng(d1, d2));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.306 -0400", hash_original_method = "E097C076BB43C7D69792B5B557894BED", hash_generated_method = "284B43184A652EB6636214D3DF5FC671")
    
public LatLng getCenter()
    {

        double d0, d1, d2, d3;
        d0 = (southwest.latitude + northeast.latitude) / 2.0;
        d1 = northeast.longitude;
        d2 = southwest.longitude;

        if (d2 - d1 > 0)
        {
            d3 = (d1 + 360.0 + d2) / 2.0;
        }
        else
        {
            d3 = (d1 + d2) / 2.0;
        }

        return new LatLng(d0, d3);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.315 -0400", hash_original_method = "086D7DBFC74D2D069305D445A27D4855", hash_generated_method = "2B8FE5FCD5A3E213D3E77C5E2E2220C2")
    
private boolean c(double  d0)
    {

        boolean $z0;
        label_1:
        {
            if (southwest.latitude - d0 <= 0 && d0 - northeast.latitude <= 0)
            {
                $z0 = true;
                break label_1;
            }

            $z0 = false;
        } //end label_1:

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.319 -0400", hash_original_method = "056CAF84B059739B8244748DA60907AA", hash_generated_method = "93869BCAD198E02F7B89D4ADF481760D")
    
private boolean d(double  d0)
    {

        boolean $z0, $z1;
        if (southwest.longitude - northeast.longitude > 0)
        {
            label_2:
            {
                if (southwest.longitude - d0 > 0 && d0 - northeast.longitude > 0)
                {
                    $z1 = false;
                    break label_2;
                }

                $z1 = true;
            } //end label_2:

            return $z1;
        }

        label_3:
        {
            if (southwest.longitude - d0 <= 0 && d0 - northeast.longitude <= 0)
            {
                $z0 = true;
                break label_3;
            }

            $z0 = false;
        } //end label_3:

        return $z0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.322 -0400", hash_original_method = "1B91E49C74884F25F779352E68B969EA", hash_generated_method = "F21733D582B06668BC5B37742A9794F8")
    
public int hashCode()
    {
    	return northeast.hashCode() + southwest.hashCode();
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.326 -0400", hash_original_method = "E8BA188245D31B84BB21FA1D5A71106B", hash_generated_method = "BFDEB6F3727F2663AE3127D0F9E8FBED")
    
public boolean equals(Object  r1)
    {

        LatLngBounds r2;
        boolean $z3;
        if (this != r1)
        {
            if (r1 instanceof LatLngBounds)
            {
                r2 = (LatLngBounds) r1;

                label_4:
                {
                    if (southwest.equals(r2.southwest) && northeast.equals(r2.northeast))
                    {
                        $z3 = true;
                        break label_4;
                    }

                    $z3 = false;
                } //end label_4:

                return $z3;
            }

            return false;
        }

        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.329 -0400", hash_original_method = "99A08874AFCAB8AAB1AFC909958309C4", hash_generated_method = "B49B375DDC621FEF281A75B5615082D5")
    
public String toString()
    {
    	StringBuilder builder = new StringBuilder();
    	builder.append(northeast.toString()).append(southwest.toString());
    	return builder.toString();
    }
    
}
