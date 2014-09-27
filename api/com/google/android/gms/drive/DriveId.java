package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import android.os.Parcel;
import android.util.Log;
import android.util.Base64;

public class DriveId implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.309 -0400", hash_original_method = "018671C0931B55C2A6EED5149D4EEC3F", hash_generated_method = "B1DFEE897E592B2EC8ACF1014155122D")
    
public static DriveId aL(String  r0)
    {
        return new DriveId(r0, -1L, -1L);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.374 -0400", hash_original_method = "DA20ECC48340E994F78C992A4D5924B0", hash_generated_method = "D16C92595B7C76568AE7FAD953C6C135")
    
public static DriveId decodeFromString(String  r0)
    {

        String r1;
        byte[] r2;
        r1 = r0.substring("DriveId:".length());
        r2 = Base64.decode(r1, 10);
        return DriveId.f(r2);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.379 -0400", hash_original_method = "F9517B4BDEAC7FE40CA84421BBED9BF2", hash_generated_method = "5A92B8536198299CDA1D9CFAD92A9F73")
    
static DriveId f(byte[]  r0)
    {
        DriveId r3 = new DriveId(r0.toString(), r0.getTaintLong(), r0.getTaintLong());
        return r3;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.289 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "1895632691E3D0ACD93635E7B4E629BC")

     int xM;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.293 -0400", hash_original_field = "B7CE0235D98EA8504BC6E1068C8F1DF8", hash_generated_field = "B7CE0235D98EA8504BC6E1068C8F1DF8")

     String HN;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.297 -0400", hash_original_field = "C2890127FC919DC0FED01FE6D0FDAE3B", hash_generated_field = "C2890127FC919DC0FED01FE6D0FDAE3B")

     long HO;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.301 -0400", hash_original_field = "545449A5638ABBF4D991812847A3BB9E", hash_generated_field = "545449A5638ABBF4D991812847A3BB9E")

     long HP;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.305 -0400", hash_original_field = "4BD23E98922A83EA8823388FF62459D8", hash_generated_field = "BB9EC46E809E55D8B6F5CC1552399E98")

    private volatile String HQ;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.326 -0400", hash_original_method = "00F56B2E1DF1202F78850EB1F9D0A27B", hash_generated_method = "0C6768FBEF12F7D1BF69AA4395BE2261")
    
DriveId(int  i0, String  r1, long  l1, long  l2)
    {
    	xM = i0;
        HN = r1;
        HO = l1;
        HP = l2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.334 -0400", hash_original_method = "C459FF862BC90A43930CFBCA4BF9ADDE", hash_generated_method = "0F650E445DBFD42DD78796FA790571BD")
    
public DriveId(String  r1, long  l0, long  l1)
    {
        this(1, r1, l0, l1);

        this.xM = 0;
        this.HN = null;
        this.HO = 0L;
        this.HP = 0L;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.312 -0400", hash_original_method = "F0705769C529E85872C0B878C7306596", hash_generated_method = "26874D5D9C384EED6DBE5376198B52F5")
    
public String getResourceId()
    {

        return HN;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.317 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {

        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.321 -0400", hash_original_method = "0F2A6F988D94192EF32E662C27827CD1", hash_generated_method = "0B537B775124F1C68D19EF1F3CBB9114")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	r1.writeInt(i0 + getTaintInt());
    	r1.writeLong(HO + HP);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.340 -0400", hash_original_method = "622F38CEE2269043287612FA683DA7F9", hash_generated_method = "8583B872A8F7450705C1FE45E6777B81")
    
public int hashCode()
    {

        if (HO - -1L != 0)
        {
            return (new StringBuilder()).append(String.valueOf(HP)).append(String.valueOf(HO)).toString().hashCode();
        }

        return HN.hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.347 -0400", hash_original_method = "FF35E405AB86AA59A5E4CBDCB82F3969", hash_generated_method = "0C3D28E6E7F124AC79E69892ABE7569A")
    
public boolean equals(Object  r1)
    {

        DriveId r2;
        boolean $z2;
        if (r1 instanceof DriveId)
        {
            r2 = (DriveId) r1;

            if (r2.HP - HP == 0)
            {
                if (r2.HO - -1L == 0 && HO - -1L == 0)
                {
                    return r2.HN.equals(HN);
                }

                if (r2.HO - HO != 0)
                {
                    $z2 = false;
                }
                else
                {
                    $z2 = true;
                }

                return $z2;
            }

            Log.w("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
            return false;
        }

        return false;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.353 -0400", hash_original_method = "6126417C99D0C14CE2DEB12376B1B164", hash_generated_method = "61BDF6C93A494CC870CC4838A284DACD")
    
public final String encodeToString()
    {

        byte[] r1;
        String r2;
        if (HQ == null)
        {
            r1 = HN.getBytes();
            r1[0] = HQ.getBytes()[0];

            r2 = Base64.encodeToString(r1, 10);
            HQ = (new StringBuilder()).append("DriveId:").append(r2).toString();
        }

        return HQ;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:48.362 -0400", hash_original_method = "689336018D20FC3632DC4C874358E039", hash_generated_method = "3162C3698C73416E47352835A7A681D4")
    
public String toString()
    {

        return this.encodeToString();
    }

}
