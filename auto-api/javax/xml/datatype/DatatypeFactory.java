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

public abstract class DatatypeFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.973 -0400", hash_original_method = "6AA3D0D92E54B6A7BA707A3B727E668C", hash_generated_method = "0558D3C965ED9BE449CE780E5E411E47")
    protected  DatatypeFactory() {
        // ---------- Original Method ----------
    }

    
        public static DatatypeFactory newInstance() throws DatatypeConfigurationException {
        try {
            return (DatatypeFactory) FactoryFinder.find(
                    DATATYPEFACTORY_PROPERTY,
                    DATATYPEFACTORY_IMPLEMENTATION_CLASS);
        }
        catch (FactoryFinder.ConfigurationError e) {
            throw new DatatypeConfigurationException(e.getMessage(), e.getException());
        }
    }

    
        public static DatatypeFactory newInstance(String factoryClassName, ClassLoader classLoader) throws DatatypeConfigurationException {
        if (factoryClassName == null) {
            throw new DatatypeConfigurationException("factoryClassName == null");
        }
        if (classLoader == null) {
            classLoader = Thread.currentThread().getContextClassLoader();
        }
        try {
            Class<?> type = classLoader != null
                    ? classLoader.loadClass(factoryClassName)
                    : Class.forName(factoryClassName);
            return (DatatypeFactory) type.newInstance();
        } catch (ClassNotFoundException e) {
            throw new DatatypeConfigurationException(e);
        } catch (InstantiationException e) {
            throw new DatatypeConfigurationException(e);
        } catch (IllegalAccessException e) {
            throw new DatatypeConfigurationException(e);
        }
    }

    
    public abstract Duration newDuration(final String lexicalRepresentation);

    
    public abstract Duration newDuration(final long durationInMilliSeconds);

    
    public abstract Duration newDuration(
            final boolean isPositive,
            final BigInteger years,
            final BigInteger months,
            final BigInteger days,
            final BigInteger hours,
            final BigInteger minutes,
            final BigDecimal seconds);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.975 -0400", hash_original_method = "0411875E7E9416CDC69781A523A9E7BE", hash_generated_method = "3247CE008DD006F1D0549DA78B0B02C9")
    public Duration newDuration(
            final boolean isPositive,
            final int years,
            final int months,
            final int days,
            final int hours,
            final int minutes,
            final int seconds) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1698368118 = null; //Variable for return #1
        BigInteger realYears;
        realYears = BigInteger.valueOf((long) years);
        realYears = null;
        BigInteger realMonths;
        realMonths = BigInteger.valueOf((long) months);
        realMonths = null;
        BigInteger realDays;
        realDays = BigInteger.valueOf((long) days);
        realDays = null;
        BigInteger realHours;
        realHours = BigInteger.valueOf((long) hours);
        realHours = null;
        BigInteger realMinutes;
        realMinutes = BigInteger.valueOf((long) minutes);
        realMinutes = null;
        BigDecimal realSeconds;
        realSeconds = BigDecimal.valueOf((long) seconds);
        realSeconds = null;
        varB4EAC82CA7396A68D541C85D26508E83_1698368118 = newDuration(
                isPositive,
                realYears,
                realMonths,
                realDays,
                realHours,
                realMinutes,
                realSeconds
        );
        addTaint(isPositive);
        addTaint(years);
        addTaint(months);
        addTaint(days);
        addTaint(hours);
        addTaint(minutes);
        addTaint(seconds);
        varB4EAC82CA7396A68D541C85D26508E83_1698368118.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1698368118;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.987 -0400", hash_original_method = "53DC4E20BA01B9A5F54EFBBB0F7676DB", hash_generated_method = "4F5D79C27E735C639A79BA1170EA2F1E")
    public Duration newDurationDayTime(final String lexicalRepresentation) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1206646864 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The lexical representation cannot be null.");
        } //End block
        int pos;
        pos = lexicalRepresentation.indexOf('T');
        int length;
        length = pos;
        length = lexicalRepresentation.length();
        {
            int i;
            i = 0;
            {
                char c;
                c = lexicalRepresentation.charAt(i);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid dayTimeDuration value: " + lexicalRepresentation);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1206646864 = newDuration(lexicalRepresentation);
        addTaint(lexicalRepresentation.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1206646864.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1206646864;
        // ---------- Original Method ----------
        //if (lexicalRepresentation == null) {
            //throw new NullPointerException("The lexical representation cannot be null.");
        //}
        //int pos = lexicalRepresentation.indexOf('T');
        //int length = (pos >= 0) ? pos : lexicalRepresentation.length();
        //for (int i = 0; i < length; ++i) {
            //char c = lexicalRepresentation.charAt(i);
            //if (c == 'Y' || c == 'M') {
                //throw new IllegalArgumentException("Invalid dayTimeDuration value: " + lexicalRepresentation);
            //}
        //}
        //return newDuration(lexicalRepresentation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.989 -0400", hash_original_method = "D4082C7434AC7344FED55B715B9658DF", hash_generated_method = "AD14E2B749E27F76BE488D2C9055856B")
    public Duration newDurationDayTime(final long durationInMilliseconds) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1838985107 = null; //Variable for return #1
        Duration varB4EAC82CA7396A68D541C85D26508E83_107367403 = null; //Variable for return #2
        Duration varB4EAC82CA7396A68D541C85D26508E83_442233511 = null; //Variable for return #3
        Duration varB4EAC82CA7396A68D541C85D26508E83_821173148 = null; //Variable for return #4
        long _durationInMilliseconds;
        _durationInMilliseconds = durationInMilliseconds;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1838985107 = newDuration(true, DatatypeConstants.FIELD_UNDEFINED,
                    DatatypeConstants.FIELD_UNDEFINED, 0, 0, 0, 0);
        } //End block
        boolean tooLong;
        tooLong = false;
        boolean isPositive;
        {
            isPositive = false;
            {
                tooLong = true;
            } //End block
            _durationInMilliseconds *= -1;
        } //End block
        {
            isPositive = true;
        } //End block
        long val;
        val = _durationInMilliseconds;
        int milliseconds;
        milliseconds = (int) (val % 60000L);
        {
            int seconds;
            seconds = milliseconds / 1000;
            val = val / 60000L;
            int minutes;
            minutes = (int) (val % 60L);
            val = val / 60L;
            int hours;
            hours = (int) (val % 24L);
            long days;
            days = val / 24L;
            {
                varB4EAC82CA7396A68D541C85D26508E83_107367403 = newDuration(isPositive, DatatypeConstants.FIELD_UNDEFINED,
                        DatatypeConstants.FIELD_UNDEFINED, (int) days, hours, minutes, seconds);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_442233511 = newDuration(isPositive, null, null,
                        BigInteger.valueOf(days), BigInteger.valueOf(hours),
                        BigInteger.valueOf(minutes), BigDecimal.valueOf(milliseconds, 3));
            } //End block
        } //End block
        BigDecimal seconds;
        seconds = BigDecimal.valueOf(milliseconds, 3);
        val = val / 60000L;
        BigInteger minutes;
        minutes = BigInteger.valueOf(val % 60L);
        val = val / 60L;
        BigInteger hours;
        hours = BigInteger.valueOf(val % 24L);
        val = val / 24L;
        BigInteger days;
        days = BigInteger.valueOf(val);
        varB4EAC82CA7396A68D541C85D26508E83_821173148 = newDuration(isPositive, null, null, days, hours, minutes, seconds);
        addTaint(durationInMilliseconds);
        Duration varA7E53CE21691AB073D9660D615818899_806966814; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_806966814 = varB4EAC82CA7396A68D541C85D26508E83_1838985107;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_806966814 = varB4EAC82CA7396A68D541C85D26508E83_107367403;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_806966814 = varB4EAC82CA7396A68D541C85D26508E83_442233511;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_806966814 = varB4EAC82CA7396A68D541C85D26508E83_821173148;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_806966814.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_806966814;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.990 -0400", hash_original_method = "6B6A6A22BBF17FD376AF1DBB2EA2AFC0", hash_generated_method = "851D5D63F18E9E235B5787614E95BBF0")
    public Duration newDurationDayTime(
            final boolean isPositive,
            final BigInteger day,
            final BigInteger hour,
            final BigInteger minute,
            final BigInteger second) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_512322633 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_512322633 = newDuration(
                isPositive,
                null,  
                null, 
                day,
                hour,
                minute,
                (second != null)? new BigDecimal(second):null
        );
        addTaint(isPositive);
        addTaint(day.getTaint());
        addTaint(hour.getTaint());
        addTaint(minute.getTaint());
        addTaint(second.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_512322633.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_512322633;
        // ---------- Original Method ----------
        //return newDuration(
                //isPositive,
                //null,  
                //null, 
                //day,
                //hour,
                //minute,
                //(second != null)? new BigDecimal(second):null
        //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:00.990 -0400", hash_original_method = "C2B5E3B114408400012B36FAE716B74D", hash_generated_method = "F1C94392EBA676BA3956F4264B0F63F7")
    public Duration newDurationDayTime(
            final boolean isPositive,
            final int day,
            final int hour,
            final int minute,
            final int second) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1519040069 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1519040069 = newDuration(isPositive,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                day, hour, minute, second);
        addTaint(isPositive);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        varB4EAC82CA7396A68D541C85D26508E83_1519040069.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1519040069;
        // ---------- Original Method ----------
        //return newDuration(isPositive,
                //DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                //day, hour, minute, second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.001 -0400", hash_original_method = "846082B3412BDC6279D2A475B2E6526F", hash_generated_method = "C6F2389495603F7EB824E71C7750DDF6")
    public Duration newDurationYearMonth(final String lexicalRepresentation) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_108666388 = null; //Variable for return #1
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The lexical representation cannot be null.");
        } //End block
        int length;
        length = lexicalRepresentation.length();
        {
            int i;
            i = 0;
            {
                char c;
                c = lexicalRepresentation.charAt(i);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid yearMonthDuration value: " + lexicalRepresentation);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_108666388 = newDuration(lexicalRepresentation);
        addTaint(lexicalRepresentation.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_108666388.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_108666388;
        // ---------- Original Method ----------
        //if (lexicalRepresentation == null) {
            //throw new NullPointerException("The lexical representation cannot be null.");
        //}
        //int length = lexicalRepresentation.length();
        //for (int i = 0; i < length; ++i) {
            //char c = lexicalRepresentation.charAt(i);
            //if (c == 'D' || c == 'T') {
                //throw new IllegalArgumentException("Invalid yearMonthDuration value: " + lexicalRepresentation);
            //}
        //}
        //return newDuration(lexicalRepresentation);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.014 -0400", hash_original_method = "056A5041DE6AEBE035AD076AE760E408", hash_generated_method = "C693208529E6CE76CDB932848375F7AF")
    public Duration newDurationYearMonth(final long durationInMilliseconds) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_979934940 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_979934940 = newDuration(durationInMilliseconds);
        addTaint(durationInMilliseconds);
        varB4EAC82CA7396A68D541C85D26508E83_979934940.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_979934940;
        // ---------- Original Method ----------
        //return newDuration(durationInMilliseconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.014 -0400", hash_original_method = "4B21C678040027406BF85976F89C7B54", hash_generated_method = "810A67C8BBBABCC34FB85EA6F3E64856")
    public Duration newDurationYearMonth(
            final boolean isPositive,
            final BigInteger year,
            final BigInteger month) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_2141959593 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2141959593 = newDuration(
                isPositive,
                year,
                month,
                null, 
                null, 
                null, 
                null  
        );
        addTaint(isPositive);
        addTaint(year.getTaint());
        addTaint(month.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2141959593.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2141959593;
        // ---------- Original Method ----------
        //return newDuration(
                //isPositive,
                //year,
                //month,
                //null, 
                //null, 
                //null, 
                //null  
        //);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.015 -0400", hash_original_method = "C5590381C9E7B3EA48F5709CED7F72BF", hash_generated_method = "B063270DEFC76258B2B73BF23B238246")
    public Duration newDurationYearMonth(
            final boolean isPositive,
            final int year,
            final int month) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_367851265 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_367851265 = newDuration(isPositive, year, month,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
        addTaint(isPositive);
        addTaint(year);
        addTaint(month);
        varB4EAC82CA7396A68D541C85D26508E83_367851265.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_367851265;
        // ---------- Original Method ----------
        //return newDuration(isPositive, year, month,
                //DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                //DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
    }

    
    public abstract XMLGregorianCalendar newXMLGregorianCalendar();

    
    public abstract XMLGregorianCalendar newXMLGregorianCalendar(final String lexicalRepresentation);

    
    public abstract XMLGregorianCalendar newXMLGregorianCalendar(final GregorianCalendar cal);

    
    public abstract XMLGregorianCalendar newXMLGregorianCalendar(
            final BigInteger year,
            final int month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final BigDecimal fractionalSecond,
            final int timezone);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.016 -0400", hash_original_method = "8A3498A1338596D8B749E79A1AFF033B", hash_generated_method = "1A3B659B12979BE9241F9081600C14BF")
    public XMLGregorianCalendar newXMLGregorianCalendar(
            final int year,
            final int month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int millisecond,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_1004053723 = null; //Variable for return #1
        BigInteger realYear;
        realYear = BigInteger.valueOf((long) year);
        realYear = null;
        BigDecimal realMillisecond;
        realMillisecond = null;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "javax.xml.datatype.DatatypeFactory#newXMLGregorianCalendar("
                        + "int year, int month, int day, int hour, int minute, int second, int millisecond, int timezone)"
                        + "with invalid millisecond: " + millisecond
                );
            } //End block
            realMillisecond = BigDecimal.valueOf((long) millisecond, 3);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1004053723 = newXMLGregorianCalendar(
                realYear,
                month,
                day,
                hour,
                minute,
                second,
                realMillisecond,
                timezone
        );
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        addTaint(millisecond);
        addTaint(timezone);
        varB4EAC82CA7396A68D541C85D26508E83_1004053723.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1004053723;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.025 -0400", hash_original_method = "6ED4795EE71DC061A554DCC049589B7F", hash_generated_method = "87E2843CFB0ED019BEC4327779E4838E")
    public XMLGregorianCalendar newXMLGregorianCalendarDate(
            final int year,
            final int month,
            final int day,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_409180598 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_409180598 = newXMLGregorianCalendar(
                year,
                month,
                day,
                DatatypeConstants.FIELD_UNDEFINED, 
                DatatypeConstants.FIELD_UNDEFINED, 
                DatatypeConstants.FIELD_UNDEFINED, 
                DatatypeConstants.FIELD_UNDEFINED, 
                timezone);
        addTaint(year);
        addTaint(month);
        addTaint(day);
        addTaint(timezone);
        varB4EAC82CA7396A68D541C85D26508E83_409180598.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_409180598;
        // ---------- Original Method ----------
        //return newXMLGregorianCalendar(
                //year,
                //month,
                //day,
                //DatatypeConstants.FIELD_UNDEFINED, 
                //DatatypeConstants.FIELD_UNDEFINED, 
                //DatatypeConstants.FIELD_UNDEFINED, 
                //DatatypeConstants.FIELD_UNDEFINED, 
                //timezone);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.025 -0400", hash_original_method = "1E346DFC9A40C730EDE4FF1E673B8E12", hash_generated_method = "D091B7C4F1F5C7BCD1516A9C1131B457")
    public XMLGregorianCalendar newXMLGregorianCalendarTime(
            final int hours,
            final int minutes,
            final int seconds,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_892006443 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_892006443 = newXMLGregorianCalendar(
                DatatypeConstants.FIELD_UNDEFINED, 
                DatatypeConstants.FIELD_UNDEFINED, 
                DatatypeConstants.FIELD_UNDEFINED, 
                hours,
                minutes,
                seconds,
                DatatypeConstants.FIELD_UNDEFINED, 
                timezone);
        addTaint(hours);
        addTaint(minutes);
        addTaint(seconds);
        addTaint(timezone);
        varB4EAC82CA7396A68D541C85D26508E83_892006443.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_892006443;
        // ---------- Original Method ----------
        //return newXMLGregorianCalendar(
                //DatatypeConstants.FIELD_UNDEFINED, 
                //DatatypeConstants.FIELD_UNDEFINED, 
                //DatatypeConstants.FIELD_UNDEFINED, 
                //hours,
                //minutes,
                //seconds,
                //DatatypeConstants.FIELD_UNDEFINED, 
                //timezone);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.026 -0400", hash_original_method = "F351AA210E9E98B5592EE4A1FD395A9B", hash_generated_method = "752E07EB8036D05A46074C884E29F610")
    public XMLGregorianCalendar newXMLGregorianCalendarTime(
            final int hours,
            final int minutes,
            final int seconds,
            final BigDecimal fractionalSecond,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_98828292 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_98828292 = newXMLGregorianCalendar(
                null, 
                DatatypeConstants.FIELD_UNDEFINED, 
                DatatypeConstants.FIELD_UNDEFINED, 
                hours,
                minutes,
                seconds,
                fractionalSecond,
                timezone);
        addTaint(hours);
        addTaint(minutes);
        addTaint(seconds);
        addTaint(fractionalSecond.getTaint());
        addTaint(timezone);
        varB4EAC82CA7396A68D541C85D26508E83_98828292.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_98828292;
        // ---------- Original Method ----------
        //return newXMLGregorianCalendar(
                //null, 
                //DatatypeConstants.FIELD_UNDEFINED, 
                //DatatypeConstants.FIELD_UNDEFINED, 
                //hours,
                //minutes,
                //seconds,
                //fractionalSecond,
                //timezone);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.027 -0400", hash_original_method = "2B05C064D85FF3588769E9C14DEF6EB8", hash_generated_method = "17F0510D0DAF7D6E6C180EFC5461141E")
    public XMLGregorianCalendar newXMLGregorianCalendarTime(
            final int hours,
            final int minutes,
            final int seconds,
            final int milliseconds,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_1638552393 = null; //Variable for return #1
        BigDecimal realMilliseconds;
        realMilliseconds = null;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "javax.xml.datatype.DatatypeFactory#newXMLGregorianCalendarTime("
                        + "int hours, int minutes, int seconds, int milliseconds, int timezone)"
                        + "with invalid milliseconds: " + milliseconds
                );
            } //End block
            realMilliseconds = BigDecimal.valueOf((long) milliseconds, 3);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1638552393 = newXMLGregorianCalendarTime(
                hours,
                minutes,
                seconds,
                realMilliseconds,
                timezone
        );
        addTaint(hours);
        addTaint(minutes);
        addTaint(seconds);
        addTaint(milliseconds);
        addTaint(timezone);
        varB4EAC82CA7396A68D541C85D26508E83_1638552393.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1638552393;
        // ---------- Original Method ----------
        //BigDecimal realMilliseconds = null;
        //if (milliseconds != DatatypeConstants.FIELD_UNDEFINED) {
            //if (milliseconds < 0 || milliseconds > 1000) {
                //throw new IllegalArgumentException(
                        //"javax.xml.datatype.DatatypeFactory#newXMLGregorianCalendarTime("
                        //+ "int hours, int minutes, int seconds, int milliseconds, int timezone)"
                        //+ "with invalid milliseconds: " + milliseconds
                //);
            //}
            //realMilliseconds = BigDecimal.valueOf((long) milliseconds, 3);
        //}
        //return newXMLGregorianCalendarTime(
                //hours,
                //minutes,
                //seconds,
                //realMilliseconds,
                //timezone
        //);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.027 -0400", hash_original_field = "8A643B8E76E57C0958A72BBB8DDAED03", hash_generated_field = "1F1E8E0A96B491EB9D4E8354A783E019")

    public static final String DATATYPEFACTORY_PROPERTY = "javax.xml.datatype.DatatypeFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:01.027 -0400", hash_original_field = "C6B08B0490B961EE292603BF75BB45A8", hash_generated_field = "E99494A37A07F4D4D964C3B6A0C3C783")

    public static final String DATATYPEFACTORY_IMPLEMENTATION_CLASS = new String("org.apache.xerces.jaxp.datatype.DatatypeFactoryImpl");
}

