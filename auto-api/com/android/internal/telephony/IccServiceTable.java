package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.util.Log;

public abstract class IccServiceTable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.054 -0400", hash_original_field = "EDB4040133B03486A6F10C28E39C7F9F", hash_generated_field = "890B9A5DF783AEB82BFD936CDBEA6DB7")

    protected byte[] mServiceTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.055 -0400", hash_original_method = "267DA89C5A4C09BB5FED527397C007E9", hash_generated_method = "6C2507E3F5C81255379CE53C88536A64")
    protected  IccServiceTable(byte[] table) {
        mServiceTable = table;
        // ---------- Original Method ----------
        //mServiceTable = table;
    }

    
    protected abstract String getTag();

    
    protected abstract Object[] getValues();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.055 -0400", hash_original_method = "6BE4E4A67F9CDE5BB71262E1760DB933", hash_generated_method = "95D18ED3CD43E770462729C0508CC6BD")
    protected boolean isAvailable(int service) {
        int offset = service / 8;
        int bit = service % 8;
        addTaint(service);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_269119186 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_269119186;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:22.056 -0400", hash_original_method = "427975D3C71DD8A8E9A905B09CF356ED", hash_generated_method = "E118DDB7CF29FF5D27370D86357FC71F")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1050506170 = null; //Variable for return #1
        Object[] values = getValues();
        int numBytes = mServiceTable.length;
        StringBuilder builder = new StringBuilder(getTag()).append('[')
                .append(numBytes * 8).append("]={ ");
        boolean addComma = false;
        {
            int i = 0;
            {
                byte currentByte = mServiceTable[i];
                {
                    int bit = 0;
                    {
                        {
                            {
                                builder.append(", ");
                            } //End block
                            {
                                addComma = true;
                            } //End block
                            int ordinal = (i * 8) + bit;
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
        varB4EAC82CA7396A68D541C85D26508E83_1050506170 = builder.append(" }").toString();
        varB4EAC82CA7396A68D541C85D26508E83_1050506170.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1050506170;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

