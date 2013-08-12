package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.*;





public abstract class IccServiceTable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.263 -0400", hash_original_field = "EDB4040133B03486A6F10C28E39C7F9F", hash_generated_field = "890B9A5DF783AEB82BFD936CDBEA6DB7")

    protected byte[] mServiceTable;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.264 -0400", hash_original_method = "267DA89C5A4C09BB5FED527397C007E9", hash_generated_method = "6C2507E3F5C81255379CE53C88536A64")
    protected  IccServiceTable(byte[] table) {
        mServiceTable = table;
        // ---------- Original Method ----------
        //mServiceTable = table;
    }

    
    @DSModeled(DSC.SAFE)
    protected abstract String getTag();

    
    @DSModeled(DSC.SAFE)
    protected abstract Object[] getValues();

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.265 -0400", hash_original_method = "6BE4E4A67F9CDE5BB71262E1760DB933", hash_generated_method = "30A0E11039A70486739561AF281FF9AE")
    protected boolean isAvailable(int service) {
        addTaint(service);
        int offset = service / 8;
        if(offset >= mServiceTable.length)        
        {
            boolean var68934A3E9455FA72420237EB05902327_1815089260 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746039417 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746039417;
        } //End block
        int bit = service % 8;
        boolean varB345937E40A8A0014E6B02C6F9646B71_322056545 = ((mServiceTable[offset] & (1 << bit)) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_9084872 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_9084872;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:17.267 -0400", hash_original_method = "427975D3C71DD8A8E9A905B09CF356ED", hash_generated_method = "C1A98935575B8C8B2C482659861A3999")
    public String toString() {
        Object[] values = getValues();
        int numBytes = mServiceTable.length;
        StringBuilder builder = new StringBuilder(getTag()).append('[')
                .append(numBytes * 8).append("]={ ");
        boolean addComma = false;
for(int i = 0;i < numBytes;i++)
        {
            byte currentByte = mServiceTable[i];
for(int bit = 0;bit < 8;bit++)
            {
                if((currentByte & (1 << bit)) != 0)                
                {
                    if(addComma)                    
                    {
                        builder.append(", ");
                    } //End block
                    else
                    {
                        addComma = true;
                    } //End block
                    int ordinal = (i * 8) + bit;
                    if(ordinal < values.length)                    
                    {
                        builder.append(values[ordinal]);
                    } //End block
                    else
                    {
                        builder.append('#').append(ordinal + 1);
                    } //End block
                } //End block
            } //End block
        } //End block
String varE73F52FBE730D91DF2815386BE1EE641_1589861383 =         builder.append(" }").toString();
        varE73F52FBE730D91DF2815386BE1EE641_1589861383.addTaint(taint);
        return varE73F52FBE730D91DF2815386BE1EE641_1589861383;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

