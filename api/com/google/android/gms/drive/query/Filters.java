package com.google.android.gms.drive.query;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.query.ComparisonFilter.Operator;

public class Filters
{

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.231 -0400", hash_original_method = "F3C83DBC4B34C4AE694997F27063CE47", hash_generated_method = "6E0585FBB5D44D594FA3B3121AAC8503")
    
public static Filter eq(SearchableMetadataField  r0, Object  r1)
    {
        return new ComparisonFilter(Operator.Equal, r0, r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.235 -0400", hash_original_method = "9E31145010FCBE710F312F7790E7603B", hash_generated_method = "8FAA4B6454E98B03A91E97D4B1C79A9A")
    
public static Filter lessThan(SearchableOrderedMetadataField  r0, Comparable  r1)
    {


        return new ComparisonFilter(Operator.LessThan, r0, r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.240 -0400", hash_original_method = "F6E25CDB20A39F4975CA34C7D97DB986", hash_generated_method = "0DFDBE64DD8B1AF9330200C21760DFBE")
    
public static Filter greaterThan(SearchableOrderedMetadataField  r0, Comparable  r1)
    {

        return new ComparisonFilter(Operator.GreaterThan, r0, r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.245 -0400", hash_original_method = "05A7F54457AD958E35EE6DEF6DDF4BE6", hash_generated_method = "B4230A33A2959E9BDF9890CAB30EFCEE")
    
public static Filter lessThanEquals(SearchableOrderedMetadataField  r0, Comparable  r1)
    {
        return new ComparisonFilter(Operator.LessThan, r0, r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.249 -0400", hash_original_method = "3CCDDD55AC2FE41C78878B9C12D95513", hash_generated_method = "36ED0550BFE78B2C2CFF455660EA9D82")
    
public static Filter greaterThanEquals(SearchableOrderedMetadataField  r0, Comparable  r1)
    {

        return new ComparisonFilter(Operator.GreaterThan, r0, r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.253 -0400", hash_original_method = "D750465CC31A866B60E36266A45CDCF9", hash_generated_method = "0B6146D006BD52AD49B25923BD139AFF")
    
public static Filter in(SearchableCollectionMetadataField  r0, Object  r1)
    {
        return new ComparisonFilter(Operator.Other, r0, r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.258 -0400", hash_original_method = "03AC4EE939D68242EF051DE9AD946CE4", hash_generated_method = "D57527C3647400599ECAF1189AB2CF68")
    
public static Filter contains(SearchableMetadataField  r0, String  r1)
    {
        return new ComparisonFilter(Operator.Other, r0, r1);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.263 -0400", hash_original_method = "F4A0D2EC5D99B622A849FF35912E90BD", hash_generated_method = "F8410BC421746D4A91976134CB2F4A1F")
    
public static Filter and(Filter  r0, Filter[]  r1)
    {
        return new ComparisonFilter(Operator.Other, r0, r1[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.267 -0400", hash_original_method = "781A5160895E1FF3F580FD6E51C39134", hash_generated_method = "7F5A5C0B4ABEF1A755C8DC33ADE0AD32")
    
public static Filter and(Iterable  r0)
    {
        return new ComparisonFilter(Operator.Other, r0, DSUtils.FAKE_STRING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.272 -0400", hash_original_method = "FCDA8BF8A3EB45443A5267AB4A11E6FB", hash_generated_method = "005636B0732ACE3068D9EDF5D7F9FA5D")
    
public static Filter or(Filter  r0, Filter[]  r1)
    {
        return new ComparisonFilter(Operator.Other, r0, r1[0]);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.277 -0400", hash_original_method = "72C4E3CB53DF97994CDB7C54966F3398", hash_generated_method = "C3E07ACA3345FB2E5D6D2CC29CA86192")
    
public static Filter or(Iterable  r0)
    {
        return new ComparisonFilter(Operator.Other, r0, DSUtils.FAKE_STRING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.281 -0400", hash_original_method = "3686F899728D82D966A073F7D2F52139", hash_generated_method = "F5E2CC1E14779CACBB94AB83A0328C70")
    
public static Filter not(Filter  r0)
    {
        return new ComparisonFilter(Operator.Other, r0, DSUtils.FAKE_STRING);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.285 -0400", hash_original_method = "8F8FD063B226C8C11F67CDBC268BDB9E", hash_generated_method = "C17C1E64F756BEE1753C768937AE4025")
    
public static Filter sharedWithMe()
    {
        return new ComparisonFilter(Operator.Other, DSUtils.FAKE_STRING, DSUtils.FAKE_STRING);
    }
}
