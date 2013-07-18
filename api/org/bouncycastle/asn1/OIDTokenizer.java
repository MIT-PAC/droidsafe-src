package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class OIDTokenizer {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.796 -0400", hash_original_field = "130F43112BB8A7A7790EBFC08EE9D6AF", hash_generated_field = "D745B114B0A51171DAD36F87C0CC38B4")

    private String oid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.797 -0400", hash_original_field = "6A992D5529F459A44FEE58C733255E86", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")

    private int index;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.797 -0400", hash_original_method = "88D58AFE0405FCD9AB8F5CA4BE2D1534", hash_generated_method = "6B1A3C9995A277DCE6532E1EED87F5DC")
    public  OIDTokenizer(
        String oid) {
        this.oid = oid;
        this.index = 0;
        // ---------- Original Method ----------
        //this.oid = oid;
        //this.index = 0;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.797 -0400", hash_original_method = "F35D489C40702BC97B5927032D797DB7", hash_generated_method = "162CADA7AC629BF331CBED90B5CA13DD")
    public boolean hasMoreTokens() {
        boolean varE5F4E98AA57F17F27119AAE61ABF5CD9_601603791 = ((index != -1));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_90290298 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_90290298;
        // ---------- Original Method ----------
        //return (index != -1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.798 -0400", hash_original_method = "4BAC87A2A9C681CC296BE2241CAA6D87", hash_generated_method = "820050E3CCE0AE69CE398440A2A3220C")
    public String nextToken() {
        if(index == -1)        
        {
String var540C13E9E156B687226421B24F2DF178_1909067198 =             null;
            var540C13E9E156B687226421B24F2DF178_1909067198.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1909067198;
        } //End block
        String token;
        int end = oid.indexOf('.', index);
        if(end == -1)        
        {
            token = oid.substring(index);
            index = -1;
String var84AE1F94A3CF2A5D8DE4571F3693A75E_978702346 =             token;
            var84AE1F94A3CF2A5D8DE4571F3693A75E_978702346.addTaint(taint);
            return var84AE1F94A3CF2A5D8DE4571F3693A75E_978702346;
        } //End block
        token = oid.substring(index, end);
        index = end + 1;
String var84AE1F94A3CF2A5D8DE4571F3693A75E_1509887381 =         token;
        var84AE1F94A3CF2A5D8DE4571F3693A75E_1509887381.addTaint(taint);
        return var84AE1F94A3CF2A5D8DE4571F3693A75E_1509887381;
        // ---------- Original Method ----------
        //if (index == -1)
        //{
            //return null;
        //}
        //String  token;
        //int     end = oid.indexOf('.', index);
        //if (end == -1)
        //{
            //token = oid.substring(index);
            //index = -1;
            //return token;
        //}
        //token = oid.substring(index, end);
        //index = end + 1;
        //return token;
    }

    
}

