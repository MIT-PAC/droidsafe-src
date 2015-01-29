package com.google.android.gms.maps.model;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import android.os.Parcel;
import android.content.Context;
import android.util.AttributeSet;
import android.content.res.TypedArray;
import android.content.res.Resources;

public final class CameraPosition implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.469 -0400", hash_original_field = "9EA9CDE421BAA75B6EA225C36823C43F", hash_generated_field = "FE1B57FACE876911C0D1F78DF7D8458E")

    public static  CameraPositionCreator CREATOR;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.584 -0400", hash_original_method = "68A2022F9590DA82447F06299C1EDEFE", hash_generated_method = "2859A08BA106A2538EB37FBBC283EFF3")
    
public static final CameraPosition fromLatLngZoom(LatLng  r0, float  f0)
    {

        return new CameraPosition(r0, f0, 0.0F, 0.0F);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.592 -0400", hash_original_method = "A734F1C3FA62139BE0F2FF05E1EEBBE7", hash_generated_method = "58DEB46C50E0DC97DA4BD9E62A3FB673")
    
public static CameraPosition.Builder builder()
    {

        return new CameraPosition.Builder();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.600 -0400", hash_original_method = "42D4DE9FA471A9AA589DA215FA82C7CD", hash_generated_method = "8BBD14FF44DF9F5C372FC0B36EE6BEE8")
    
public static CameraPosition.Builder builder(CameraPosition  r0)
    {
        return new CameraPosition.Builder(r0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.640 -0400", hash_original_method = "56D8CC63BD220A1965F5B2C30D5220E2", hash_generated_method = "43FDFD1E409FC66532F71EAF52F5CC45")
    
public static CameraPosition createFromAttributes(Context  r0, AttributeSet  r1)
    {

        TypedArray r3;
        float f0, f1;
        LatLng r4;
        CameraPosition.Builder r5;
        if (r1 != null)
        {
            r3 = r0.getResources().obtainAttributes(r1, DSUtils.FAKE_INT_ARRAY);
            f0 = 0.0F;
            f1 = 0.0F;

            if (r3.hasValue(2))
            {
                f0 = r3.getFloat(2, 0.0F);
            }

            if (r3.hasValue(3))
            {
                f1 = r3.getFloat(3, 0.0F);
            }

            r4 = new LatLng((double) f0, (double) f1);
            r5 = CameraPosition.builder();
            r5.target(r4);

            if (r3.hasValue(5))
            {
                r5.zoom(r3.getFloat(5, 0.0F));
            }

            if (r3.hasValue(1))
            {
                r5.bearing(r3.getFloat(1, 0.0F));
            }

            if (r3.hasValue(4))
            {
                r5.tilt(r3.getFloat(4, 0.0F));
            }

            return r5.build();
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.479 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "D85A02ED437AD53A72DD6BC8931F0E7E")

    private  int xM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.486 -0400", hash_original_field = "9A6867BECE556A939197CE0E83A26DD6", hash_generated_field = "F3C0A6A024B2BD845C2B3EE270FC8D58")

    public  LatLng target;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.493 -0400", hash_original_field = "9A82144D596A63CB702E8C6BE0EDFC6E", hash_generated_field = "E85C336E19203E6C28659DC5AEB18CC6")

    public  float zoom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.499 -0400", hash_original_field = "AE973C2C15251739BC3A8B1E3E722B5E", hash_generated_field = "76957AE09F118F559E7F0E0ADBA6C6EB")

    public  float tilt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.516 -0400", hash_original_field = "7E9C4CEA69140E5E666716FEF9A870FA", hash_generated_field = "F9487F370110CB0AA65064E5432DF3C5")

    public  float bearing;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.532 -0400", hash_original_method = "256EF3E4C749D3A933929F700E1470A4", hash_generated_method = "DBB746D3407BE3A70F74167EE93872C6")
    
public CameraPosition(int  i0, LatLng  r1, float  f0, float  f1, float  f2)
    {
        this.xM = i0;
        this.target = r1;
        this.zoom = f0;
        this.tilt = f1;
        this.bearing = f2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.543 -0400", hash_original_method = "CFB3C4C9D68679F25BB8D8D58B80E3C2", hash_generated_method = "A1FFFC2C9B210CE7FDC626F81598D430")
    
public CameraPosition(LatLng  r1, float  f0, float  f1, float  f2)
    {
        this(1, r1, f0, f1, f2);

    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.552 -0400", hash_original_method = "C0784B1BCD51B96EDB949E6604E7089A", hash_generated_method = "C370EB33ABE9BB2FE2C28FF6532A5A32")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.560 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {

        return 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.569 -0400", hash_original_method = "D3DB49F02EFCE01530531C1081DFF9FF", hash_generated_method = "B76AB81E74AB82C13DE8281FC98BCC3D")
    
public int hashCode()
    {
    	return (int)(bearing + tilt + xM + zoom + target.hashCode());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.575 -0400", hash_original_method = "4085B31D8AA7B6F7F53EA4B9C215022D", hash_generated_method = "4085B31D8AA7B6F7F53EA4B9C215022D")
    
int getVersionCode()
    {
        return xM;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.613 -0400", hash_original_method = "98D7EFCEB2F065459601698299791F05", hash_generated_method = "FABF3A0A18B633447ADF351B30D26468")
    
public boolean equals(Object  r1)
    {
    	return (((hashCode() + r1.hashCode())) == 1);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 12:12:25.621 -0400", hash_original_method = "8D2817BB5CC33FE15796743BB64CFB64", hash_generated_method = "193FEC672B46B6A4590A68AE6072BDDF")
    
public String toString()
    {
    	String str = new String();
    	str.addTaint(hashCode());
    	return str;
    }

    static
    {
        CREATOR = new CameraPositionCreator(DSOnlyType.DONTCARE);
    }
    
    private static class Builder {

    	private float bearing, tilt, zoom;
    	
		public Builder() {
		}

		public Builder(CameraPosition r0) {
			// TODO Auto-generated constructor stub
		}
		
		public Builder bearing(float bearing){
			this.bearing = bearing;
			return this;
		}

		public Builder tilt(float tilt){
			this.tilt = tilt;
			return this;
		}
		
        public Builder zoom(float zoom){
        	this.zoom = zoom;
			return this;
		}

        LatLng target;
        public Builder target(LatLng target){
        	this.target = target;
			return this;
		}
        
        public CameraPosition build(){
        	CameraPosition camPos = new CameraPosition(target, zoom, tilt, bearing); 
        	return camPos;
        }
    	
    }
}
