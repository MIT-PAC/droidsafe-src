package com.google.android.gms.common;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.app.PendingIntent;
import android.app.Activity;
import android.content.IntentSender.SendIntentException;

public final class ConnectionResult
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.252 -0400", hash_original_field = "746609D22FCF0D7F2FA5575D91BB0797", hash_generated_field = "9B986A2CF4CE0B3870A44EA118A88E9A")

    public static final int SUCCESS = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.257 -0400", hash_original_field = "0598DA7EE1DB0BC0C6AC975B2A22133F", hash_generated_field = "A175A905A092F8AAB26AD4B7F9926ECB")

    public static final int SERVICE_MISSING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.262 -0400", hash_original_field = "73D06F11EA22D7378B9D8708D241BA99", hash_generated_field = "0C5D995EF7910DC009393A970D2C9342")

    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.267 -0400", hash_original_field = "0EDE5186ED31E49A3F9F9B6B9D07C1E9", hash_generated_field = "766FBE2CF73A1BD7CE32A7935E102F33")

    public static final int SERVICE_DISABLED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.272 -0400", hash_original_field = "0088DC5FE6E641B1124366DF4D056093", hash_generated_field = "F26243A246F2546DC8BB5E4908CBB97B")

    public static final int SIGN_IN_REQUIRED = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.278 -0400", hash_original_field = "221A0C108A73ACCCD1AA57E46FBFE6F9", hash_generated_field = "6C496AD6E3CB5C849B3755E8DE073429")

    public static final int INVALID_ACCOUNT = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.283 -0400", hash_original_field = "6FADACABCE4E0E101E0B2358F882557B", hash_generated_field = "B5B7CAB333337867C834970EEF09FED9")

    public static final int RESOLUTION_REQUIRED = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.289 -0400", hash_original_field = "59D8F7F03284685861992589358CEFD8", hash_generated_field = "463744E0EE1965B67F0454D73962F233")

    public static final int NETWORK_ERROR = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.313 -0400", hash_original_field = "3BE2A5A062AE171AEABF2514EC22B7BE", hash_generated_field = "94FAC71CAB7A0443E88F370A470CBE4A")

    public static final int INTERNAL_ERROR = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.318 -0400", hash_original_field = "73EADCDC1F87BA36668F8C64ADD43271", hash_generated_field = "699EF6EB8F710B8CB8A00E9A6118595F")

    public static final int SERVICE_INVALID = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.323 -0400", hash_original_field = "0F000F2ECD5A34013F049B2F4BA336BF", hash_generated_field = "D2A6716549C23D47341CE1D590182944")

    public static final int DEVELOPER_ERROR = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.354 -0400", hash_original_field = "B68E8D864FD1CA2278AE43A67EA8EAC4", hash_generated_field = "AE6A487ECC953154832716ED06FD6FCB")

    public static final int LICENSE_CHECK_FAILED = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.359 -0400", hash_original_field = "F39D9E59B673C181DFE717FD941223CF", hash_generated_field = "94F0672B8269D3F4ABF16125B02F9C02")

    public static final int DATE_INVALID = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.371 -0400", hash_original_field = "1DA885270B1BCD710F47A942C03D5BF6", hash_generated_field = "9E0472720290F0AA011A230EABE8803C")

    public static final int CANCELED = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.376 -0400", hash_original_field = "77C1FF4CA574026B13646DFF0479C9AD", hash_generated_field = "2B56D5FD1C394436B6CDF9DD5DB4C792")

    public static final int TIMEOUT = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.381 -0400", hash_original_field = "88B417CD2DA252D3C900CB41EB9F975E", hash_generated_field = "198E62490FCC638A2EFC187AC7F3147D")

    public static final int INTERRUPTED = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.386 -0400", hash_original_field = "1B05F04B59EECE8126F785834E129CF2", hash_generated_field = "2FA4C802398FB4F1E41DAEF8AE73A66A")

    public static final int API_UNAVAILABLE = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.392 -0400", hash_original_field = "DBAFDB5945BDAED0DBF43D044550D601", hash_generated_field = "4A912C5B76F9B08D986593CE2BECDE39")

    public static final int DRIVE_EXTERNAL_STORAGE_REQUIRED = 1500;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.397 -0400", hash_original_field = "8367786940ED2DBE91EC19CD434C2D23", hash_generated_field = "9C2D4808BA20A9FF537C9174FA90D472")

    public static  ConnectionResult CS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.402 -0400", hash_original_field = "7B47F6D668EAC8B29A4C2C64F0EA44AC", hash_generated_field = "094D5D79D03F65D4515938385B22FFF9")

    private  PendingIntent mPendingIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.408 -0400", hash_original_field = "EB6FA11735981CE0D22EEA25EEDA5A58", hash_generated_field = "EA19679A9BC271DCE3C542A4FC964D8A")

    private  int CT;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.413 -0400", hash_original_method = "4582012686B7D0AF8DEC33C8F64C872E", hash_generated_method = "0607A28755AFC4145DC2E9443BBC809B")
    
public ConnectionResult(int  i0, PendingIntent  r1)
    {

        CT = i0;
        mPendingIntent = r1;
    }

    @DSBan(DSCat.DROIDSAFE_INTERNAL)
    public ConnectionResult(DSOnlyType type) {
    	
    }

    @DSSink({DSSinkKind.GOOGLE_SERVICES})
    @DSSpec(DSCat.SPEC_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.418 -0400", hash_original_method = "028B8274BBC2718BC829EDDECF21C0E6", hash_generated_method = "BBFB693008C0E47BF79059FAF63F7BEA")
    
public void startResolutionForResult(Activity  r1, int  i0) throws SendIntentException
    {

        if (this.hasResolution())
        {
            r1.startIntentSenderForResult(mPendingIntent.getIntentSender(), i0, null, SUCCESS, SUCCESS, SUCCESS);
            return;
        }
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.423 -0400", hash_original_method = "D872AF8F90B549081F5E206766F7A552", hash_generated_method = "3D05E793BEFA92EBFFA5345471603245")
    
public boolean hasResolution()
    {

        boolean $z0;
        label_0:
        {
            if (CT != SUCCESS && mPendingIntent != null)
            {
                $z0 = true;
                break label_0;
            }

            $z0 = false;
        } //end label_0:

        return $z0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.428 -0400", hash_original_method = "12414A7C9DCCE408ED3D9F1BDAD0F931", hash_generated_method = "65402805A0C221436050D8533EB83E6B")
    
public boolean isSuccess()
    {

        boolean $z0;
        if (CT != SUCCESS)
        {
            $z0 = false;
        }
        else
        {
            $z0 = true;
        }

        return $z0;
    }

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.432 -0400", hash_original_method = "3B2E75A568883E051F3AA54B3AF20855", hash_generated_method = "3AD23A285090A69864D5105798732ACE")
    
public int getErrorCode()
    {

        return CT;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.437 -0400", hash_original_method = "EA4CBA41218F1080855FDC7F39114923", hash_generated_method = "5096182068449B15D7727E28EF8BB6CC")
    
public PendingIntent getResolution()
    {

        return mPendingIntent;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.443 -0400", hash_original_method = "5D0AC069E27ACF913BABC1E62039E0FC", hash_generated_method = "1E27069295C766E79AB0E83E3F64F077")
    
private String ex()
    {

        switch (CT)
        {
            case 0:
                return "SUCCESS";

            case 1:
                return "SERVICE_MISSING";

            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";

            case 3:
                return "SERVICE_DISABLED";

            case 4:
                return "SIGN_IN_REQUIRED";

            case 5:
                return "INVALID_ACCOUNT";

            case 6:
                return "RESOLUTION_REQUIRED";

            case 7:
                return "NETWORK_ERROR";

            case 8:
                return "INTERNAL_ERROR";

            case 9:
                return "SERVICE_INVALID";

            case 10:
                return "DEVELOPER_ERROR";

            case 11:
                return "LICENSE_CHECK_FAILED";

            case 13:
                return "CANCELED";

            case 14:
                return "TIMEOUT";

            case 15:
                return "INTERRUPTED";

            case 12:
            default:
                return (new StringBuilder()).append("unknown status code ").append(CT).toString();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:46.450 -0400", hash_original_method = "599DF267E463A4D561BCF288B0A4175C", hash_generated_method = "54E8A05F8159ED89386EA2CABED2B4BD")
    
public String toString()
    {
    	String newStr = new String();
    	newStr.addTaint(getTaint());
    	return newStr;
    }

    static
    {

        CS = new ConnectionResult(SUCCESS, null);
    }
}
