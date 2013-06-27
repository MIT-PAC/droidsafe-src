package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public abstract class ASN1Time extends ASN1StringType {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.447 -0400", hash_original_method = "82E49EA5DBBF8DF43E60D041D8EADCBA", hash_generated_method = "5910C74D0DA9D50869787EA00524B4A2")
    public  ASN1Time(int tagNumber) {
        super(tagNumber);
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:09.451 -0400", hash_original_method = "A8543817917479A67ACF72269E42F301", hash_generated_method = "0EC1A8FDCC5E483CDCA107F622B2EA3A")
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        Object varB4EAC82CA7396A68D541C85D26508E83_2029870168 = null; //Variable for return #1
        GregorianCalendar c;
        c = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        c.set(Calendar.YEAR, in.times[0]);
        c.set(Calendar.MONTH, in.times[1]-1);
        c.set(Calendar.DAY_OF_MONTH, in.times[2]);
        c.set(Calendar.HOUR_OF_DAY, in.times[3]);
        c.set(Calendar.MINUTE, in.times[4]);
        c.set(Calendar.SECOND, in.times[5]);
        c.set(Calendar.MILLISECOND, in.times[6]);
        varB4EAC82CA7396A68D541C85D26508E83_2029870168 = c.getTime();
        addTaint(in.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2029870168.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2029870168;
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

