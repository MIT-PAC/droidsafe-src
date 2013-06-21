package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public abstract class IccServiceTable {
    protected byte[] mServiceTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.407 -0400", hash_original_method = "267DA89C5A4C09BB5FED527397C007E9", hash_generated_method = "B04DA5B0693A2D90B353403D5C54B27E")
    @DSModeled(DSC.SAFE)
    protected IccServiceTable(byte[] table) {
        dsTaint.addTaint(table[0]);
        // ---------- Original Method ----------
        //mServiceTable = table;
    }

    
    protected abstract String getTag();

    
    protected abstract Object[] getValues();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.407 -0400", hash_original_method = "6BE4E4A67F9CDE5BB71262E1760DB933", hash_generated_method = "C5C9C46758EE8DCB32D97934F683D989")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected boolean isAvailable(int service) {
        dsTaint.addTaint(service);
        int offset;
        offset = service / 8;
        int bit;
        bit = service % 8;
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int offset = service / 8;
        //if (offset >= mServiceTable.length) {
            //Log.e(getTag(), "isAvailable for service " + (service + 1) + " fails, max service is " +
                    //(mServiceTable.length * 8));
            //return false;
        //}
        //int bit = service % 8;
        //return (mServiceTable[offset] & (1 << bit)) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.408 -0400", hash_original_method = "427975D3C71DD8A8E9A905B09CF356ED", hash_generated_method = "28C340A4D3FDC888ABAA539F46497C9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        Object[] values;
        values = getValues();
        int numBytes;
        numBytes = mServiceTable.length;
        StringBuilder builder;
        builder = new StringBuilder(getTag()).append('[')
                .append(numBytes * 8).append("]={ ");
        boolean addComma;
        addComma = false;
        {
            int i;
            i = 0;
            {
                byte currentByte;
                currentByte = mServiceTable[i];
                {
                    int bit;
                    bit = 0;
                    {
                        {
                            {
                                builder.append(", ");
                            } //End block
                            {
                                addComma = true;
                            } //End block
                            int ordinal;
                            ordinal = (i * 8) + bit;
                            {
                                builder.append(values[ordinal]);
                            } //End block
                            {
                                builder.append('#').append(ordinal + 1);
                            } //End block
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String varE151F35425E95AE6A2DBB07E5B6DF757_1203348592 = (builder.append(" }").toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

