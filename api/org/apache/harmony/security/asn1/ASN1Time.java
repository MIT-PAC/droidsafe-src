package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;





public abstract class ASN1Time extends ASN1StringType {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.243 -0500", hash_original_method = "82E49EA5DBBF8DF43E60D041D8EADCBA", hash_generated_method = "CAF48723FCBF29B116EFEA04AB7A8424")
    public ASN1Time(int tagNumber) {
        super(tagNumber);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:04.244 -0500", hash_original_method = "A8543817917479A67ACF72269E42F301", hash_generated_method = "57D628B029E551897A68C605BC923CD0")
    @Override
public Object getDecodedObject(BerInputStream in) throws IOException {
        GregorianCalendar c = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        c.set(Calendar.YEAR, in.times[0]);
        c.set(Calendar.MONTH, in.times[1]-1);
        c.set(Calendar.DAY_OF_MONTH, in.times[2]);
        c.set(Calendar.HOUR_OF_DAY, in.times[3]);
        c.set(Calendar.MINUTE, in.times[4]);
        c.set(Calendar.SECOND, in.times[5]);
        c.set(Calendar.MILLISECOND, in.times[6]);
        return c.getTime();
    }

    
}

