package com.google.android.gms.drive;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import java.util.List;

public final class MetadataBuffer extends DataBuffer
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.013 -0400", hash_original_field = "B8DA79D97F6877DE23BFF11AB3886D1F", hash_generated_field = "A33EF023780F972E717CCA065D077E4E")

    private static  String[] HR;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.016 -0400", hash_original_field = "3CBA7368D9DA2736DA96C0FB8DA8B0BA", hash_generated_field = "4560DCB974A5B0B923F9C1894277A218")

    private  String HS;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.024 -0400", hash_original_method = "4EA4E2D4FB10B0EC561B9445E1A014D4", hash_generated_method = "3F29E53DB4C19817C25BCF3F5F4A91E2")
    
public MetadataBuffer(DataHolder  r1, String  r2)
    {
        super(r1);

        HS = r2;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.036 -0400", hash_original_method = "08268187BF4C1D30850AF5A9C73E3D09", hash_generated_method = "E7D433DFA9AAE70FDE7F192B60B9150C")
    
public Object get(int  i0)
    {
    	Object obj = new Object();
    	obj.addTaint(getTaint());
    	return obj;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-22 10:25:49.032 -0400", hash_original_method = "16F5324F6915752C4A7BE2CE49AACA8C", hash_generated_method = "75BFE76012C60A754B7808B1F402660F")
    
public String getNextPageToken()
    {
        return HS;
    }
    
}
