package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.apache.harmony.security.asn1.ASN1Choice;
import org.apache.harmony.security.asn1.ASN1GeneralizedTime;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.ASN1UTCTime;

public final class Time {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.044 -0400", hash_original_method = "C0662425013CF2CE61C48C4C28B674A6", hash_generated_method = "C0662425013CF2CE61C48C4C28B674A6")
        public Time ()
    {
    }


    private static final long JAN_01_2050 = 2524608000000L;
    public static final ASN1Choice ASN1 = new ASN1Choice(new ASN1Type[] {
            ASN1GeneralizedTime.getInstance(), ASN1UTCTime.getInstance() }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.044 -0400", hash_original_method = "27F8E5451C765B5FECADBB8DC1A06F26", hash_generated_method = "88B78FBEA096C3C4CB59808A43AE783D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int getIndex(java.lang.Object object) {
            dsTaint.addTaint(object.dsTaint);
            {
                boolean var875DEB4D07E3629A5328127F761F7AA3_2135364644 = (((java.util.Date) object).getTime() < JAN_01_2050);
            } //End collapsed parenthetic
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //if (((java.util.Date) object).getTime() < JAN_01_2050) {
                //return 1; 
            //} else {
                //return 0; 
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.044 -0400", hash_original_method = "75F68B3A16DBDA02F9B0A49BA52B584E", hash_generated_method = "034259263D6A1DB22C3247102039B9A1")
        @DSModeled(DSC.SAFE)
        public Object getObjectToEncode(Object object) {
            dsTaint.addTaint(object.dsTaint);
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return object;
        }

        
}; //Transformed anonymous class
}

