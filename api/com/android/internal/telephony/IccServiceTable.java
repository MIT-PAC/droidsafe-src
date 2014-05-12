package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;

public abstract class IccServiceTable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.349 -0500", hash_original_field = "63FE8CC83BB64485B90E615C6ABD7104", hash_generated_field = "890B9A5DF783AEB82BFD936CDBEA6DB7")

    protected  byte[] mServiceTable;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.356 -0500", hash_original_method = "267DA89C5A4C09BB5FED527397C007E9", hash_generated_method = "CAC40169CA1A799E37E2F3BA75AD37E5")
    
protected IccServiceTable(byte[] table) {
        mServiceTable = table;
    }

    // Get the class name to use for log strings
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.362 -0500", hash_original_method = "E0ACE28639D243FCBBC6F27206A0F369", hash_generated_method = "F29540E07ED4EC147D26C77AF493C0DE")
    
protected abstract String getTag();

    // Get the array of enums to use for toString
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.366 -0500", hash_original_method = "B6D39BF2602DAFF66318E7E94226FB88", hash_generated_method = "B933DA98CDDB6E6B03BDBF547C264F1E")
    
protected abstract Object[] getValues();

    /**
     * Returns if the specified service is available.
     * @param service the service number as a zero-based offset (the enum ordinal)
     * @return true if the service is available; false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.371 -0500", hash_original_method = "6BE4E4A67F9CDE5BB71262E1760DB933", hash_generated_method = "740645221AE2E415DCA1DA2209B82EEA")
    
protected boolean isAvailable(int service) {
        int offset = service / 8;
        if (offset >= mServiceTable.length) {
            // Note: Enums are zero-based, but the TS service numbering is one-based
            Log.e(getTag(), "isAvailable for service " + (service + 1) + " fails, max service is " +
                    (mServiceTable.length * 8));
            return false;
        }
        int bit = service % 8;
        return (mServiceTable[offset] & (1 << bit)) != 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:19.383 -0500", hash_original_method = "427975D3C71DD8A8E9A905B09CF356ED", hash_generated_method = "363CE653C852FFB0A718CF56B3A3D420")
    
public String toString() {
        Object[] values = getValues();
        int numBytes = mServiceTable.length;
        StringBuilder builder = new StringBuilder(getTag()).append('[')
                .append(numBytes * 8).append("]={ ");

        boolean addComma = false;
        for (int i = 0; i < numBytes; i++) {
            byte currentByte = mServiceTable[i];
            for (int bit = 0; bit < 8; bit++) {
                if ((currentByte & (1 << bit)) != 0) {
                    if (addComma) {
                        builder.append(", ");
                    } else {
                        addComma = true;
                    }
                    int ordinal = (i * 8) + bit;
                    if (ordinal < values.length) {
                        builder.append(values[ordinal]);
                    } else {
                        builder.append('#').append(ordinal + 1);    // service number (one-based)
                    }
                }
            }
        }
        return builder.append(" }").toString();
    }
    
}

