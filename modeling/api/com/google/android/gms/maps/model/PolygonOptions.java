package com.google.android.gms.maps.model;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import java.util.Arrays;
import java.util.Iterator;

public final class PolygonOptions implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.168 -0400", hash_original_field = "3A7B82C03B566D05ACE13CF810A0B196", hash_generated_field = "E00450F4C7795AF0CE9A3F89AB23EBC5")

    public static  PolygonOptionsCreator CREATOR;

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.171 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "D85A02ED437AD53A72DD6BC8931F0E7E")

    private  int xM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.174 -0400", hash_original_field = "6E9B680EB0FEB2F2E1203C3C67386D45", hash_generated_field = "3D2F4AA1CA2AC398CB860B6B69DD5F40")

    private  List aaX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.176 -0400", hash_original_field = "6136E3100F94EE893B803D5D7EC2FD87", hash_generated_field = "98FA6EDC3F01E3456E1580D9887906C3")

    private  List aaY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.179 -0400", hash_original_field = "147EE4DC6ECB3FD726C35D7896DD62CD", hash_generated_field = "A57F4BA28993327A18C0928969885375")

    private float aau;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.181 -0400", hash_original_field = "B7ADBAD1495B2AD84380F06CEF4A1C27", hash_generated_field = "E317407BDBBEDEE72319B136D02E6D5B")

    private int aav;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.185 -0400", hash_original_field = "21046F1DE5DA79D53456F720556DD39E", hash_generated_field = "0AC14DB4AE61A592380D8135EB17A05F")

    private int aaw;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.187 -0400", hash_original_field = "C4B1C79FFD64F0520A9B3256EE5621D6", hash_generated_field = "621708BBD5D6F44C6290B5DB2987CD91")

    private float aax;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.190 -0400", hash_original_field = "4AE4A6580A29D7E0465DC188A977FCA5", hash_generated_field = "C8995896E97699121D16DEA85A61BB42")

    private boolean aay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.192 -0400", hash_original_field = "743DC9DE42A944799452CC9CFD9F6717", hash_generated_field = "2B775E84ADB4B12253E6EA1A51F9D39B")

    private boolean aaZ;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.196 -0400", hash_original_method = "8C790BAB021E9B6C9615AB42081089AB", hash_generated_method = "7C6DB58D6A28A27BB45E545BC7238D8D")
    
public PolygonOptions()
    {

        aau = 10.0F;
        aav = -16777216;
        aaw = 0;
        aax = 0.0F;
        aay = true;
        aaZ = false;
        xM = 1;
        aaX = new ArrayList();
        aaY = new ArrayList();
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.200 -0400", hash_original_method = "61219631F29515E0231C327DA8AB796A", hash_generated_method = "61219631F29515E0231C327DA8AB796A")
    
PolygonOptions(int  i0, List  r1, List  r2, float  f0, int  i1, int  i2, float  f1, boolean  z0, boolean  z1)
    {

        aau = 10.0F;
        aav = -16777216;
        aaw = 0;
        aax = 0.0F;
        aay = true;
        aaZ = false;
        xM = i0;
        aaX = r1;
        aaY = r2;
        aau = f0;
        aav = i1;
        aaw = i2;
        aax = f1;
        aay = z0;
        aaZ = z1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.203 -0400", hash_original_method = "4085B31D8AA7B6F7F53EA4B9C215022D", hash_generated_method = "4085B31D8AA7B6F7F53EA4B9C215022D")
    
int getVersionCode()
    {

        return xM;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.206 -0400", hash_original_method = "06D19D4C0A608DC878512080DC364437", hash_generated_method = "06D19D4C0A608DC878512080DC364437")
    
List jP()
    {

        return aaY;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.209 -0400", hash_original_method = "0E28BB7FA1418F3093274B2F276C936C", hash_generated_method = "021AA734C9C98CC2945273997AD380C7")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	r1.writeInt(i0);
    	r1.writeDouble(aau + aav + aaw + xM + ((aay && aaZ) ? 1.0f : 0.0f));
    	r1.addTaint(aaX.get(0).getTaint());
    	r1.addTaint(aaY.get(0).getTaint());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.212 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {

        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.215 -0400", hash_original_method = "7B8FD7506217C89039CBB4723F9C8EB9", hash_generated_method = "D9C622DAC19DAA994EC9A2828FE41BC8")
    
public PolygonOptions add(LatLng  r1)
    {

        aaX.add(r1);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.218 -0400", hash_original_method = "7E8478473382775A573E857435553EA7", hash_generated_method = "797F80DDC2F4DB82A0D423420267C00E")
    
public PolygonOptions add(LatLng[]  r1)
    {

        aaX.addAll(Arrays.asList(r1));
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.221 -0400", hash_original_method = "C22FD3528A9F032A145FEFCF168739E6", hash_generated_method = "2E076E4062EBD3B222FB23C0CB85C697")
    
public PolygonOptions addAll(Iterable  r1)
    {

        Iterator r2;
        LatLng r3;
        r2 = r1.iterator();

        while (r2.hasNext())
        {
            r3 = (LatLng) r2.next();
            aaX.add(r3);
        }

        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.224 -0400", hash_original_method = "40B14B52524DB4D35186E7ED0A1753B9", hash_generated_method = "A2C077D2F34B6A29DFCA13032E3EC92C")
    
public PolygonOptions addHole(Iterable  r1)
    {

        ArrayList r3;
        Iterator r4;
        LatLng r5;
        r3 = new ArrayList();
        r4 = r1.iterator();

        while (r4.hasNext())
        {
            r5 = (LatLng) r4.next();
            r3.add(r5);
        }

        aaY.add(r3);
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.227 -0400", hash_original_method = "C760C07D51A23F099BE25073F346F149", hash_generated_method = "6F983768E68E5929C6EFE310B6A55ED1")
    
public PolygonOptions strokeWidth(float  f0)
    {

        aau = f0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.230 -0400", hash_original_method = "896AD43383C9BCA7B7EF2D002C6FC692", hash_generated_method = "A29AB49FD75715029D0A1A188EFA5292")
    
public PolygonOptions strokeColor(int  i0)
    {

        aav = i0;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.233 -0400", hash_original_method = "D255E86BD3D35673710E0C572CA40374", hash_generated_method = "B43D758FB0052485B281DE743FD2F096")
    
public PolygonOptions fillColor(int  i0)
    {

        aaw = i0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.235 -0400", hash_original_method = "C89C31E82E7338C4B74C8300DE1F1575", hash_generated_method = "48A0DC967AB69B0233665BC607D44D12")
    
public PolygonOptions zIndex(float  f0)
    {

        aax = f0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.238 -0400", hash_original_method = "10D55E1E617D9336BCE3B015192043AE", hash_generated_method = "0B40F35421C408C778130B713F5E9CA4")
    
public PolygonOptions visible(boolean  z0)
    {

        aay = z0;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.241 -0400", hash_original_method = "3BA1604699C98FDF8652B6A785CF97E8", hash_generated_method = "6090E100E8CDEC1B4515E83F104231C7")
    
public PolygonOptions geodesic(boolean  z0)
    {

        aaZ = z0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.243 -0400", hash_original_method = "FBBC99ECA2C347F6E9ABE4577DA1CB6F", hash_generated_method = "0611305A9061B6B2FC194171F285AA91")
    
public List getPoints()
    {

        return aaX;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.246 -0400", hash_original_method = "A6F0E3E5662BC634EF06C695AB52D1D2", hash_generated_method = "DB0676B1B6C7FAE8AA608E9D4990B445")
    
public List getHoles()
    {

        return aaY;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.249 -0400", hash_original_method = "D8DC104B40970A1024068A5CC101444E", hash_generated_method = "37C6AAFF6314B3C8DE6D63524C30F38F")
    
public float getStrokeWidth()
    {

        return aau;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.251 -0400", hash_original_method = "A38A7947234015F4F89996DA7080B05C", hash_generated_method = "D72C9ADD79E69F4EB5D64649A0269C1B")
    
public int getStrokeColor()
    {

        return aav;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.255 -0400", hash_original_method = "3D73B46B0276B44C0D1AD2F598AB7671", hash_generated_method = "1AA9BE22D2FC02F3C0FFC8495D98B8DB")
    
public int getFillColor()
    {

        return aaw;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.257 -0400", hash_original_method = "859BD56F5F0EB7701912A69428AEEC3F", hash_generated_method = "0616F3003EB6787DD9BAFE587E60ADB8")
    
public float getZIndex()
    {

        return aax;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.260 -0400", hash_original_method = "C631437258AB2153FDCAE32648986693", hash_generated_method = "7790099E413C9AD0DFE5CF2E7E83ABD8")
    
public boolean isVisible()
    {

        return aay;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:52.263 -0400", hash_original_method = "CBB33321C6688146E8FB187C0DDC9D05", hash_generated_method = "8D5CF1A486EDBBB2496201CB932333F1")
    
public boolean isGeodesic()
    {

        return aaZ;
    }

    static
    {
        CREATOR = new PolygonOptionsCreator();
    }
}
