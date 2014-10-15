package com.google.android.gms.maps;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

import android.os.Parcel;
import android.content.Context;
import android.util.AttributeSet;
import android.content.res.TypedArray;
import android.content.res.Resources;

public final class GoogleMapOptions implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.491 -0400", hash_original_field = "43DA8FFC65E7014DEC9EA453A9554545", hash_generated_field = "E4DAFE6B615C3692ED0D05604A83092D")

    public static  GoogleMapOptionsCreator CREATOR;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.858 -0400", hash_original_method = "B69E44D2ACA9E23B05D7A43116C85829", hash_generated_method = "D4245B0295E9BF6F2088E19B031FD266")
    
public static GoogleMapOptions createFromAttributes(Context  r0, AttributeSet  r1)
    {

        TypedArray r3;
        GoogleMapOptions r4;
        CameraPosition r5;
        if (r1 != null)
        {
            r3 = r0.getResources().obtainAttributes(r1, DSUtils.FAKE_INT_ARRAY);
            r4 = new GoogleMapOptions();

            if (r3.hasValue(0))
            {
                r4.mapType(r3.getInt(0, -1));
            }

            if (r3.hasValue(13))
            {
                r4.zOrderOnTop(r3.getBoolean(13, false));
            }

            if (r3.hasValue(12))
            {
                r4.useViewLifecycleInFragment(r3.getBoolean(12, false));
            }

            if (r3.hasValue(6))
            {
                r4.compassEnabled(r3.getBoolean(6, true));
            }

            if (r3.hasValue(7))
            {
                r4.rotateGesturesEnabled(r3.getBoolean(7, true));
            }

            if (r3.hasValue(8))
            {
                r4.scrollGesturesEnabled(r3.getBoolean(8, true));
            }

            if (r3.hasValue(9))
            {
                r4.tiltGesturesEnabled(r3.getBoolean(9, true));
            }

            if (r3.hasValue(11))
            {
                r4.zoomGesturesEnabled(r3.getBoolean(11, true));
            }

            if (r3.hasValue(10))
            {
                r4.zoomControlsEnabled(r3.getBoolean(10, true));
            }

            r5 = CameraPosition.createFromAttributes(r0, r1);
            r4.camera(r5);
            r3.recycle();
            return r4;
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.500 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "D85A02ED437AD53A72DD6BC8931F0E7E")

    private  int xM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.508 -0400", hash_original_field = "BBC47BD75F2257F5958F968743E8D4B0", hash_generated_field = "B70AD3723C48A3C3813B14838AB657C3")

    private Boolean Zs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.515 -0400", hash_original_field = "E0EAAE6D89FA85E6D14968359E2B45A6", hash_generated_field = "BADFCD8B1A1BBB7F432B3CF6482A02D7")

    private Boolean Zt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.522 -0400", hash_original_field = "594D78733181D71CF613C026B75877F9", hash_generated_field = "6BF1FD0CF21D2DE7789D35DB270883C7")

    private int Zu;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.540 -0400", hash_original_field = "CB863B79491A028EA5397AF75B3DB932", hash_generated_field = "0B2AC6BF6E0629C225423EDCC65F27A5")

    private CameraPosition Zv;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.546 -0400", hash_original_field = "B3D091E37CF628F340F7A252EBFD7F8A", hash_generated_field = "E26CF6182D55BD2D25185FDCC0864BD1")

    private Boolean Zw;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.553 -0400", hash_original_field = "E23655137B7C1D5FAD818B76B42763E8", hash_generated_field = "825491038130B746AD6AE1AB5AA10C73")

    private Boolean Zx;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.559 -0400", hash_original_field = "051004E6B61CF77B9E6389A82B5F4046", hash_generated_field = "F80395AF31472D1D2086B955A733914F")

    private Boolean Zy;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.565 -0400", hash_original_field = "11EF65F8EF140A8CDAF5FB0D65EB99D1", hash_generated_field = "1F7D21C6114B46490F9A52E14BE97916")

    private Boolean Zz;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.573 -0400", hash_original_field = "97A08C151B262E36FE8020DD8A080359", hash_generated_field = "3844BA44DD0EBF21A8562F1DF17F956B")

    private Boolean ZA;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.579 -0400", hash_original_field = "2ABBB527A0C2AE945CD3409D3F4ABDE2", hash_generated_field = "A20F2F0FB42A62861A482CA59547F180")

    private Boolean ZB;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.594 -0400", hash_original_method = "2888E395D37AAC0EBB1F03E19254BF15", hash_generated_method = "2888E395D37AAC0EBB1F03E19254BF15")
    
GoogleMapOptions(int  i0, byte  b1, byte  b2, int  i3, CameraPosition  r1, byte  b4, byte  b5, byte  b6, byte  b7, byte  b8, byte  b9)
    {

        Zu = -1;
        xM = i0;
        Zs = ((b1) == 1);
        Zt = ((b2) == 1);
        Zu = i3;
        Zv = r1;
        Zw = ((b4) == 1);
        Zx = ((b5) == 1);
        Zy = ((b6) == 1);
        Zz = ((b7) == 1);
        ZA = ((b8) == 1);
        ZB = ((b9) == 1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.673 -0400", hash_original_method = "E166DD72784D578DDB0C6FD3849289D7", hash_generated_method = "B4A8E2134DD214A6ECAD6A336AB8301B")
    
public GoogleMapOptions()
    {

        Zu = -1;
        xM = 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.602 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {

        return 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    public int hashCode() {
    	return (int) (((ZA && ZB && Zs && Zt && Zw && Zx && Zy && Zz) ? 1 : 0) +
    				xM + Zu + Zv.hashCode());
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.611 -0400", hash_original_method = "ADCF644B903FDC636E69177B74C71541", hash_generated_method = "66EB4B9ED1D6254AA6D0BA5BB072C3F4")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	r1.writeInt(i0 + hashCode());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.617 -0400", hash_original_method = "4085B31D8AA7B6F7F53EA4B9C215022D", hash_generated_method = "4085B31D8AA7B6F7F53EA4B9C215022D")
    
int getVersionCode()
    {
        return xM;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.680 -0400", hash_original_method = "CB0F0B2D8FB08148537D790C5A1DA2FE", hash_generated_method = "EA06390D0999736B2AA8C51AB96C8C57")
    
public GoogleMapOptions zOrderOnTop(boolean  z0)
    {

        Zs = Boolean.valueOf(z0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.689 -0400", hash_original_method = "0C67CD7CC3E3D7829741F50259154E58", hash_generated_method = "10F8DF347C7C340FEA5E69B4C32D9520")
    
public GoogleMapOptions useViewLifecycleInFragment(boolean  z0)
    {

        Zt = Boolean.valueOf(z0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.696 -0400", hash_original_method = "5CD3DD784F0E5FE20C8898858FF40D99", hash_generated_method = "306408D35E7A471197859FD190AF72F6")
    
public GoogleMapOptions mapType(int  i0)
    {

        Zu = i0;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.703 -0400", hash_original_method = "0417CB834C60F6587F5DBC35417F5F4A", hash_generated_method = "2863BC57FC574A1FF90EC72F192FFD60")
    
public GoogleMapOptions camera(CameraPosition  r1)
    {

        Zv = r1;
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.710 -0400", hash_original_method = "D436C5951F5E87AE2D03FBE06A35BE4D", hash_generated_method = "24E104FD33C39E06BA660C0A99FCC060")
    
public GoogleMapOptions zoomControlsEnabled(boolean  z0)
    {

        Zw = Boolean.valueOf(z0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.718 -0400", hash_original_method = "3F43352806BD68656F0D42357BF8AFE6", hash_generated_method = "9C1D1C32058E0574E6473DD162089C3D")
    
public GoogleMapOptions compassEnabled(boolean  z0)
    {

        Zx = Boolean.valueOf(z0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.725 -0400", hash_original_method = "20A53573806650EA02A06D1F8F2C0260", hash_generated_method = "65AD468E8B3770194B5E23E0D5EEE831")
    
public GoogleMapOptions scrollGesturesEnabled(boolean  z0)
    {

        Zy = Boolean.valueOf(z0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.732 -0400", hash_original_method = "EE9DAAA5605E3FDDA8D1717C1F8FA7D7", hash_generated_method = "4458763EAB06D0C7503DA67C5F3A85F9")
    
public GoogleMapOptions zoomGesturesEnabled(boolean  z0)
    {

        Zz = Boolean.valueOf(z0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.740 -0400", hash_original_method = "1B265E6DCD6B837274438E25EFACD68F", hash_generated_method = "57B54DB005030E2EA78FDA0601BB2DBE")
    
public GoogleMapOptions tiltGesturesEnabled(boolean  z0)
    {

        ZA = Boolean.valueOf(z0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.747 -0400", hash_original_method = "4EF7574177DDA27A7CEE5A3B5B7B937B", hash_generated_method = "06BA6509B23E450F1DFD344BCE54C982")
    
public GoogleMapOptions rotateGesturesEnabled(boolean  z0)
    {

        ZB = Boolean.valueOf(z0);
        return this;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.753 -0400", hash_original_method = "9AF5F05AD44E9D560081B3A42D5D1A8C", hash_generated_method = "63355F66EAD5733E54EE807CDD7383DE")
    
public Boolean getZOrderOnTop()
    {

        return Zs;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.759 -0400", hash_original_method = "DE4B415B7F3DBCC177F64197E83670D7", hash_generated_method = "CE641A254C29D14F35F02C444518396B")
    
public Boolean getUseViewLifecycleInFragment()
    {

        return Zt;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.766 -0400", hash_original_method = "C617900508361FF5760BF464C9790115", hash_generated_method = "2FB4FA7FA3F9AD86B881833D70BB70AD")
    
public int getMapType()
    {

        return Zu;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.772 -0400", hash_original_method = "97B0F8EBDB5DADDA3CB98867B7F8A4E6", hash_generated_method = "6C597E323552F4AB3ED47AE012FDB2C5")
    
public CameraPosition getCamera()
    {

        return Zv;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.812 -0400", hash_original_method = "61350352BE657D79FCCA5BD0AC028D6C", hash_generated_method = "44A82082C342A709AB5E6610EE32D3AA")
    
public Boolean getZoomControlsEnabled()
    {

        return Zw;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.818 -0400", hash_original_method = "FDF4A4269D0889380AC6F96AAE199ABB", hash_generated_method = "858FF5BF4616613F47B0F06AAE75A944")
    
public Boolean getCompassEnabled()
    {

        return Zx;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.824 -0400", hash_original_method = "764F245C49AF30C0E0076233086B96B0", hash_generated_method = "F05B1709666583A8E1053178EF22FDF1")
    
public Boolean getScrollGesturesEnabled()
    {

        return Zy;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.830 -0400", hash_original_method = "C3B6A666E8B26F9AF6584EABE4153C6E", hash_generated_method = "7325EF2E3C669D44DFCA5EC8143FB899")
    
public Boolean getZoomGesturesEnabled()
    {

        return Zz;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.836 -0400", hash_original_method = "BD1F944FF3D15F8F51A0FE17DC274F60", hash_generated_method = "4A6B21EC9F97326C46EAE45B255C2597")
    
public Boolean getTiltGesturesEnabled()
    {

        return ZA;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-24 13:46:48.841 -0400", hash_original_method = "B7244E943CDACE407C9A174EAF5553FA", hash_generated_method = "80F564F32D5425C2511F0DFA2EAD67A7")
    
public Boolean getRotateGesturesEnabled()
    {

        return ZB;
    }

    static
    {

        CREATOR = new GoogleMapOptionsCreator();
    }
}
