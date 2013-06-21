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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.005 -0400", hash_original_method = "82E49EA5DBBF8DF43E60D041D8EADCBA", hash_generated_method = "6A280CB9D9827E320FF38D0F71C8D0E9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ASN1Time(int tagNumber) {
        super(tagNumber);
        dsTaint.addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.005 -0400", hash_original_method = "A8543817917479A67ACF72269E42F301", hash_generated_method = "2FE75EB0117FEC33EB632D25A94CF103")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object getDecodedObject(BerInputStream in) throws IOException {
        dsTaint.addTaint(in.dsTaint);
        GregorianCalendar c;
        c = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        c.set(Calendar.YEAR, in.times[0]);
        c.set(Calendar.MONTH, in.times[1]-1);
        c.set(Calendar.DAY_OF_MONTH, in.times[2]);
        c.set(Calendar.HOUR_OF_DAY, in.times[3]);
        c.set(Calendar.MINUTE, in.times[4]);
        c.set(Calendar.SECOND, in.times[5]);
        c.set(Calendar.MILLISECOND, in.times[6]);
        Object varC5EA3C3F7CBDF6B76FEAE3576BF1290A_1363364716 = (c.getTime());
        return (Object)dsTaint.getTaint();
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

