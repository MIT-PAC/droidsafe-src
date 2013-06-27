package javax.xml.datatype;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import javax.xml.namespace.QName;

public abstract class XMLGregorianCalendar implements Cloneable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.965 -0400", hash_original_method = "0454809303A25440835D986E330D1344", hash_generated_method = "0454809303A25440835D986E330D1344")
    public XMLGregorianCalendar ()
    {
        //Synthesized constructor
    }


    public abstract void clear();

    
    public abstract void reset();

    
    public abstract void setYear(BigInteger year);

    
    public abstract void setYear(int year);

    
    public abstract void setMonth(int month);

    
    public abstract void setDay(int day);

    
    public abstract void setTimezone(int offset);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.972 -0400", hash_original_method = "4845A9375D4C6AE77C32ACAA66D778E0", hash_generated_method = "D50DE9E714F7A16EB76F83AE6BD00A7F")
    public void setTime(int hour, int minute, int second) {
        setTime(
            hour,
            minute,
            second,
            null 
        );
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        // ---------- Original Method ----------
        //setTime(
            //hour,
            //minute,
            //second,
            //null 
        //);
    }

    
    public abstract void setHour(int hour);

    
    public abstract void setMinute(int minute);

    
    public abstract void setSecond(int second);

    
    public abstract void setMillisecond(int millisecond);

    
    public abstract void setFractionalSecond(BigDecimal fractional);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.985 -0400", hash_original_method = "C7E2983DF83EA198A88C6F7AB3120E0D", hash_generated_method = "FA89D506FA37EF1B2A0B41D227C4257F")
    public void setTime(
        int hour,
        int minute,
        int second,
        BigDecimal fractional) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        setFractionalSecond(fractional);
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        addTaint(fractional.getTaint());
        // ---------- Original Method ----------
        //setHour(hour);
        //setMinute(minute);
        //setSecond(second);
        //setFractionalSecond(fractional);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.985 -0400", hash_original_method = "BE78C420671C5C86557B5E64804F4B27", hash_generated_method = "45BB8190E8EFB0BA28CA51100275CA15")
    public void setTime(int hour, int minute, int second, int millisecond) {
        setHour(hour);
        setMinute(minute);
        setSecond(second);
        setMillisecond(millisecond);
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        addTaint(millisecond);
        // ---------- Original Method ----------
        //setHour(hour);
        //setMinute(minute);
        //setSecond(second);
        //setMillisecond(millisecond);
    }

    
    public abstract BigInteger getEon();

    
    public abstract int getYear();

    
    public abstract BigInteger getEonAndYear();

    
    public abstract int getMonth();

    
    public abstract int getDay();

    
    public abstract int getTimezone();

    
    public abstract int getHour();

    
    public abstract int getMinute();

    
    public abstract int getSecond();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.996 -0400", hash_original_method = "6FEC6B2DA5D563780B89D108C7288E8E", hash_generated_method = "E213F12FBB6FF3EF9093BA99E6876DAA")
    public int getMillisecond() {
        BigDecimal fractionalSeconds;
        fractionalSeconds = getFractionalSecond();
        int var468B9241F7C50AA913DA77C7035A2D97_547217516 = (getFractionalSecond().movePointRight(3).intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953229995 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_953229995;
        // ---------- Original Method ----------
        //BigDecimal fractionalSeconds = getFractionalSecond();
        //if (fractionalSeconds == null) {
            //return DatatypeConstants.FIELD_UNDEFINED;
        //}
        //return getFractionalSecond().movePointRight(3).intValue();
    }

    
    public abstract BigDecimal getFractionalSecond();

    
    public abstract int compare(XMLGregorianCalendar xmlGregorianCalendar);

    
    public abstract XMLGregorianCalendar normalize();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.003 -0400", hash_original_method = "19B2054195AB93CB483DC675DC194860", hash_generated_method = "2B1E71062024FFE00B1DCF017A9A0620")
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_10321423 = (obj == this);
        } //End collapsed parenthetic
        {
            boolean var29D11650225B7ED5E5F4D4BE9C7F4414_1850150878 = (compare((XMLGregorianCalendar) obj) == DatatypeConstants.EQUAL);
        } //End block
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_531232182 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_531232182;
        // ---------- Original Method ----------
        //if (obj == this) {
            //return true;
        //}
        //if (obj instanceof XMLGregorianCalendar) {
            //return compare((XMLGregorianCalendar) obj) == DatatypeConstants.EQUAL;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.012 -0400", hash_original_method = "5DFDF964002E92183AFAC48B2D840C79", hash_generated_method = "837E191CBA6220B2815CA16D1347C6B8")
    public int hashCode() {
        int timezone;
        timezone = getTimezone();
        {
            timezone = 0;
        } //End block
        XMLGregorianCalendar gc;
        gc = this;
        {
            gc = this.normalize();
        } //End block
        int var82CC09B35E07A94A621FAEE70538F1A5_2063700349 = (gc.getYear()
        + gc.getMonth()
        + gc.getDay()
        + gc.getHour()
        + gc.getMinute()
        + gc.getSecond());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283053256 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283053256;
        // ---------- Original Method ----------
        //int timezone = getTimezone();
        //if (timezone == DatatypeConstants.FIELD_UNDEFINED) {
            //timezone = 0;
        //}
        //XMLGregorianCalendar gc = this;
        //if (timezone != 0) {
            //gc = this.normalize();
        //}
        //return gc.getYear()
        //+ gc.getMonth()
        //+ gc.getDay()
        //+ gc.getHour()
        //+ gc.getMinute()
        //+ gc.getSecond();
    }

    
    public abstract String toXMLFormat();

    
    public abstract QName getXMLSchemaType();

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.012 -0400", hash_original_method = "AADCE02C6BC50AA8EF2762197F8AA400", hash_generated_method = "34EBC40B6E03C4A9585AAF27BF7460D6")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1902856897 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1902856897 = toXMLFormat();
        varB4EAC82CA7396A68D541C85D26508E83_1902856897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1902856897;
        // ---------- Original Method ----------
        //return toXMLFormat();
    }

    
    public abstract boolean isValid();

    
    public abstract void add(Duration duration);

    
    public abstract GregorianCalendar toGregorianCalendar();

    
    public abstract GregorianCalendar toGregorianCalendar(
        java.util.TimeZone timezone,
        java.util.Locale aLocale,
        XMLGregorianCalendar defaults);

    
    public abstract TimeZone getTimeZone(int defaultZoneoffset);

    
    public abstract Object clone();

    
}

