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

import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import android.os.IBinder;
import android.os.Parcel;

public final class MarkerOptions implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.695 -0400", hash_original_field = "DAE1FB92484A78B94232FBC3AB586426", hash_generated_field = "5879BA85152CAC666DCD070768BE622C")

    public static  MarkerOptionsCreator CREATOR;

@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.697 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "D85A02ED437AD53A72DD6BC8931F0E7E")

    private  int xM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.700 -0400", hash_original_field = "EFEC90FD7314B01CA41EC23C129207B7", hash_generated_field = "789CBD0BA1F616D60EA91420585C10DB")

    private LatLng ZX;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.703 -0400", hash_original_field = "467ABBEF78ED5B2886D11A7730B5DEC2", hash_generated_field = "827DF17AAC1EE2076940BBE8CAD0910B")

    private String HY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.707 -0400", hash_original_field = "F01CE6D8423B395241F746CCC2BAB190", hash_generated_field = "C94A42231321397E0B2759934DDEE420")

    private String aaP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.710 -0400", hash_original_field = "059153F0526C4C3AAD31D5940622F438", hash_generated_field = "4454DF48CCD2E4E9129FA47AD9AD854C")

    private BitmapDescriptor aaQ;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.714 -0400", hash_original_field = "F6CA9D6B1E0F4CA70E9159FA51961447", hash_generated_field = "80CA4E4EB93C6DA23F2249E84738BFF1")

    private float aaG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.718 -0400", hash_original_field = "B397C9F1478BFC7AA92DEAC01A446A13", hash_generated_field = "3466FADEF1D13ADD5471C903D3374B4C")

    private float aaH;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.722 -0400", hash_original_field = "5CD00A9D40DC10057E379B2F2CB8D275", hash_generated_field = "81E6B1A35965073397DB9FAF6478419C")

    private boolean aaR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.725 -0400", hash_original_field = "4AE4A6580A29D7E0465DC188A977FCA5", hash_generated_field = "C8995896E97699121D16DEA85A61BB42")

    private boolean aay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.728 -0400", hash_original_field = "F6DF86AEC25FA413B704AFBCDA20D450", hash_generated_field = "54F2DEADECAB57E8D281E09F15E3B5FC")

    private boolean aaS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.732 -0400", hash_original_field = "A81793796D4C649CEB45F00343D8BAA4", hash_generated_field = "EEAEF1F593BECAE1783C2A94D045FF0F")

    private float aaT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.738 -0400", hash_original_field = "4629940D4442774101C2653A5562D11C", hash_generated_field = "FD9A2CC25E62FEBF09A3E121AF3CDDC2")

    private float aaU;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.741 -0400", hash_original_field = "FDF92194A412DC39FB923F3CB071D0F0", hash_generated_field = "93B9892D20180234ED5B185BBE8F1484")

    private float aaV;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.744 -0400", hash_original_field = "1109060D01B8BF804FF00B533C2F6EC9", hash_generated_field = "DA5596C46B557E79B97BD1600C24BBB3")

    private float mAlpha;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.747 -0400", hash_original_method = "0007B450FE3F7EC0567D1F5DB28C1371", hash_generated_method = "210CEC04505D5CAA51F732984858123B")
    
public MarkerOptions()
    {

        aaG = 0.5F;
        aaH = 1.0F;
        aay = true;
        aaS = false;
        aaT = 0.0F;
        aaU = 0.5F;
        aaV = 0.0F;
        mAlpha = 1.0F;
        xM = 1;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.753 -0400", hash_original_method = "2E4D0F126265F1BFAB13236C9DF255B6", hash_generated_method = "2E4D0F126265F1BFAB13236C9DF255B6")
    
MarkerOptions(int  i0, LatLng  r1, String  r2, String  r3, IBinder  r4, float  f0, float  f1, boolean  z0, boolean  z1, boolean  z2, float  f2, float  f3, float  f4, float  f5)
    {

        BitmapDescriptor $r6;
        aaG = 0.5F;
        aaH = 1.0F;
        aay = true;
        aaS = false;
        aaT = 0.0F;
        aaU = 0.5F;
        aaV = 0.0F;
        mAlpha = 1.0F;
        xM = i0;
        ZX = r1;
        HY = r2;
        aaP = r3;

        if (r4 != null)
        {
            $r6 = new BitmapDescriptor(DSOnlyType.DONTCARE, r4.getTaintInt());
        }
        else
        {
            $r6 = null;
        }

        aaQ = $r6;
        aaG = f0;
        aaH = f1;
        aaR = z0;
        aay = z1;
        aaS = z2;
        aaT = f2;
        aaU = f3;
        aaV = f4;
        mAlpha = f5;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.757 -0400", hash_original_method = "5E3821035F8BDB59B2F9E2E6B94E8942", hash_generated_method = "F5E0FE4D9E65CAE01C27734E651E18E7")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	r1.writeInt(hashCode());
    	r1.writeInt(i0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.760 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.763 -0400", hash_original_method = "4085B31D8AA7B6F7F53EA4B9C215022D", hash_generated_method = "4085B31D8AA7B6F7F53EA4B9C215022D")
    
int getVersionCode()
    {

        return xM;
    }
/*
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.767 -0400", hash_original_method = "19FD8339AB4DF2CCA691D9C86B0D022A", hash_generated_method = "19FD8339AB4DF2CCA691D9C86B0D022A")
    
IBinder jO()
    {

        IBinder $r2;
        if (aaQ != null)
        {
            $r2 = aaQ.jn().asBinder();
        }
        else
        {
            $r2 = null;
        }

        return $r2;
    }
*/
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.771 -0400", hash_original_method = "787473D886233214E6C1460F60C72FB8", hash_generated_method = "BAA3C20E8226856C339F891FBF55437A")
    
public MarkerOptions position(LatLng  r1)
    {

        ZX = r1;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.774 -0400", hash_original_method = "75816E698B1BA3B9131865E2B1F751F2", hash_generated_method = "6DA32A2E32A29CD985FB7D726F0B6CB2")
    
public MarkerOptions icon(BitmapDescriptor  r1)
    {

        aaQ = r1;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.777 -0400", hash_original_method = "F5D2B38FB43CD4A644864D60EB5BA6EE", hash_generated_method = "8BE7F8F7B16547E0757E4D44490C80B7")
    
public MarkerOptions anchor(float  f0, float  f1)
    {

        aaG = f0;
        aaH = f1;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.780 -0400", hash_original_method = "23C98FC37F85DE01061ABEDBC9BEC028", hash_generated_method = "9FE66ACFB175420D8CCA29A4B4C0E769")
    
public MarkerOptions infoWindowAnchor(float  f0, float  f1)
    {

        aaU = f0;
        aaV = f1;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.784 -0400", hash_original_method = "64129FC055965C7612AF6D4D8998EFBA", hash_generated_method = "75238C35BCD25F4D96D9BF0741600137")
    
public MarkerOptions title(String  r1)
    {

        HY = r1;
        return this;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.786 -0400", hash_original_method = "6FB1DB0B9C4A9AA37015D7384CD9B73C", hash_generated_method = "DB8597D9D0BFCC7C3D5642B64F9A67AD")
    
public MarkerOptions snippet(String  r1)
    {

        aaP = r1;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.789 -0400", hash_original_method = "917908558DBC048E011FCBD1632669A9", hash_generated_method = "95C965D1FAA533C296ECE375D2CACB56")
    
public MarkerOptions draggable(boolean  z0)
    {

        aaR = z0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.792 -0400", hash_original_method = "3D470CA40A7CCAAAD219EC1B983E501D", hash_generated_method = "5B7FCEEF61CC3A1DA502DC2BF9E07026")
    
public MarkerOptions visible(boolean  z0)
    {

        aay = z0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.795 -0400", hash_original_method = "806CE806403EF7DE27DDFB57DD2B6623", hash_generated_method = "2D497E8090AF8F3528F73EDB7286658D")
    
public MarkerOptions flat(boolean  z0)
    {

        aaS = z0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.799 -0400", hash_original_method = "88E8289D2A2690793885BA81C6860895", hash_generated_method = "DD18963A6906269A0A302739D391AAC7")
    
public MarkerOptions rotation(float  f0)
    {

        aaT = f0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.802 -0400", hash_original_method = "5653F4AA89EC059D703446A063ED33E4", hash_generated_method = "FF7CDC9145800C9DD4D6FC8BE19C7EB2")
    
public MarkerOptions alpha(float  f0)
    {

        mAlpha = f0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.804 -0400", hash_original_method = "C79049C38AC11A0FDD9CB941958BA1B1", hash_generated_method = "8FB4CB2F7480090C68308B4C7D32D3AC")
    
public LatLng getPosition()
    {

        return ZX;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.807 -0400", hash_original_method = "769588723E0EFB23437398B7128EFA0E", hash_generated_method = "DDD5C86375662EFAC479D3399175196C")
    
public String getTitle()
    {

        return HY;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.810 -0400", hash_original_method = "C4C80694839D6371DA28B4412A2346F5", hash_generated_method = "5772A071505FA4F5A955E84768AFD7FD")
    
public String getSnippet()
    {

        return aaP;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.813 -0400", hash_original_method = "099DAE0067AE5C0FFDD1EA45F2EC4D99", hash_generated_method = "582A046943455C4D2CCF8C572CBF9309")
    
public BitmapDescriptor getIcon()
    {

        return aaQ;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.815 -0400", hash_original_method = "587382F5B57B1333545FBBE4456A62B5", hash_generated_method = "8755E04DDC9022A097F97BA8B0E35768")
    
public float getAnchorU()
    {

        return aaG;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.819 -0400", hash_original_method = "BA1A3AA07053747B68154B7D221A774E", hash_generated_method = "BA36824503E276BB0067CFC1DE9F6EB6")
    
public float getAnchorV()
    {

        return aaH;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.821 -0400", hash_original_method = "80F7D31E9C7F3F0055C24FF4490972AF", hash_generated_method = "7350A435E04B4AA9403FE8F6C715DD0B")
    
public boolean isDraggable()
    {

        return aaR;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.824 -0400", hash_original_method = "C631437258AB2153FDCAE32648986693", hash_generated_method = "7790099E413C9AD0DFE5CF2E7E83ABD8")
    
public boolean isVisible()
    {

        return aay;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.826 -0400", hash_original_method = "1B6CF5D373019F8B4890BA79AB088004", hash_generated_method = "B6B19616C0685AA7D9F4D8EB506408CC")
    
public boolean isFlat()
    {

        return aaS;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.829 -0400", hash_original_method = "654B26B2B496E2CB3B4628C73683935F", hash_generated_method = "A39FD96F5960EC3EE1D88C00F8BABCF7")
    
public float getRotation()
    {

        return aaT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.831 -0400", hash_original_method = "6905BD2E8AF8E7CD054CA8175E866AF1", hash_generated_method = "8D2A5CF4F6020A190ED4531D725DA326")
    
public float getInfoWindowAnchorU()
    {

        return aaU;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.834 -0400", hash_original_method = "B6A8E1FFF596D7EAAA38F489874A8E94", hash_generated_method = "F7928D5FB4CA1F6F74FE6C0F1C291063")
    
public float getInfoWindowAnchorV()
    {

        return aaV;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:51.836 -0400", hash_original_method = "84CA63CC358414A9CD87B6516C604402", hash_generated_method = "BB0D60558DFDFA2BC395B22614DE6493")
    
public float getAlpha()
    {

        return mAlpha;
    }
    
    static {
    	CREATOR = new MarkerOptionsCreator(DSOnlyType.DONTCARE);
    }
}
