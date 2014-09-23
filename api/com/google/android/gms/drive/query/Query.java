package com.google.android.gms.drive.query;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import android.os.Parcel;

public class Query implements com.google.android.gms.common.internal.safeparcel.SafeParcelable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.353 -0400", hash_original_field = "038E53B698C14AE028B9C6D89683FE22", hash_generated_field = "038E53B698C14AE028B9C6D89683FE22")

     LogicalFilter KE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.357 -0400", hash_original_field = "361500D93195C59BBAE7620A96CACCF5", hash_generated_field = "361500D93195C59BBAE7620A96CACCF5")

     String KF;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.360 -0400", hash_original_field = "75C6BCD48B9D59E2198AC473FE6120AB", hash_generated_field = "75C6BCD48B9D59E2198AC473FE6120AB")

     SortOrder KG;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.371 -0400", hash_original_field = "1895632691E3D0ACD93635E7B4E629BC", hash_generated_field = "1895632691E3D0ACD93635E7B4E629BC")

     int xM;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.374 -0400", hash_original_method = "E496796F5FB85F0E59DAFBB2ABBF15B1", hash_generated_method = "E496796F5FB85F0E59DAFBB2ABBF15B1")
    
Query(LogicalFilter  r1, String  r2, SortOrder  r3)
    {
        this(1, r1, r2, r3);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.379 -0400", hash_original_method = "E5F931B0B8B471F6A7AFEBD1F3FDFD62", hash_generated_method = "E5F931B0B8B471F6A7AFEBD1F3FDFD62")
    
Query(int  i0, LogicalFilter  r1, String  r2, SortOrder  r3)
    {

        xM = i0;
        KE = r1;
        KF = r2;
        KG = r3;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.382 -0400", hash_original_method = "45D44D6E89BAB34C498968FFF31D1C40", hash_generated_method = "F965A8ECBAF93DDD424391D21FBD2FE5")
    
public Filter getFilter()
    {
        return KE;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.386 -0400", hash_original_method = "B5162D9FC13132FEC256D0C7D6AFE989", hash_generated_method = "79C2702041763D9E23F2A66328424723")
    
public String getPageToken()
    {


        return KF;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.389 -0400", hash_original_method = "16DD6AE2842070B77F82C828A567F979", hash_generated_method = "541787653D42095FF92DBB7B529B975C")
    
public SortOrder getSortOrder()
    {


        return KG;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.393 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents()
    {


        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.396 -0400", hash_original_method = "A5A23D2AA3685D8D76199C8059690279", hash_generated_method = "BC917CE6A443E0AE76AEDDE8E0D683E2")
    
public void writeToParcel(Parcel  r1, int  i0)
    {
    	r1.writeInt(i0);
    	r1.writeInt(getTaintInt());
    }

    static
    {
    }
}
