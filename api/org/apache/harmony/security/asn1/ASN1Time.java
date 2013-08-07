package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;





public abstract class ASN1Time extends ASN1StringType {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.433 -0400", hash_original_method = "82E49EA5DBBF8DF43E60D041D8EADCBA", hash_generated_method = "5910C74D0DA9D50869787EA00524B4A2")
    public  ASN1Time(int tagNumber) {
        super(tagNumber);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:27.434 -0400", hash_original_method = "A8543817917479A67ACF72269E42F301", hash_generated_method = "DDC678ED9638E3589BCF176925A7574C")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
        GregorianCalendar c = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        c.set(Calendar.YEAR, in.times[0]);
        c.set(Calendar.MONTH, in.times[1]-1);
        c.set(Calendar.DAY_OF_MONTH, in.times[2]);
        c.set(Calendar.HOUR_OF_DAY, in.times[3]);
        c.set(Calendar.MINUTE, in.times[4]);
        c.set(Calendar.SECOND, in.times[5]);
        c.set(Calendar.MILLISECOND, in.times[6]);
Object var197708C17D513E5D6CAAC0A9EC1B5DCE_1627596577 =         c.getTime();
        var197708C17D513E5D6CAAC0A9EC1B5DCE_1627596577.addTaint(taint);
        return var197708C17D513E5D6CAAC0A9EC1B5DCE_1627596577;
        // ---------- Original Method ----------
        //GregorianCalendar c = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        //c.set(Calendar.YEAR, in.times[0]);
        //c.set(Calendar.MONTH, in.times[1]-1);
        //c.set(Calendar.DAY_OF_MONTH, in.times[2]);
        //c.set(Calendar.HOUR_OF_DAY, in.times[3]);
        //c.set(Calendar.MINUTE, in.times[4]);
        //c.set(Calendar.SECOND, in.times[5]);
        //c.set(Calendar.MILLISECOND, in.times[6]);
        //return c.getTime();
    }

    
}

