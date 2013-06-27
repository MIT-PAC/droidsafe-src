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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.534 -0400", hash_original_method = "6AA3D0D92E54B6A7BA707A3B727E668C", hash_generated_method = "0558D3C965ED9BE449CE780E5E411E47")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.542 -0400", hash_original_method = "0411875E7E9416CDC69781A523A9E7BE", hash_generated_method = "ACC93338D190873A80099EF276C58166")
    public Duration newDuration(
            final boolean isPositive,
            final int years,
            final int months,
            final int days,
            final int hours,
            final int minutes,
            final int seconds) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1687186353 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1687186353 = newDuration(
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
        varB4EAC82CA7396A68D541C85D26508E83_1687186353.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1687186353;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.543 -0400", hash_original_method = "53DC4E20BA01B9A5F54EFBBB0F7676DB", hash_generated_method = "EC7795739DCEA17E9B030F6814538394")
    public Duration newDurationDayTime(final String lexicalRepresentation) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_173977914 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_173977914 = newDuration(lexicalRepresentation);
        addTaint(lexicalRepresentation.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_173977914.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_173977914;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.548 -0400", hash_original_method = "D4082C7434AC7344FED55B715B9658DF", hash_generated_method = "870E11EF56EB735ED7F2417A6DA77D29")
    public Duration newDurationDayTime(final long durationInMilliseconds) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_2005400037 = null; //Variable for return #1
        Duration varB4EAC82CA7396A68D541C85D26508E83_1233898037 = null; //Variable for return #2
        Duration varB4EAC82CA7396A68D541C85D26508E83_580614623 = null; //Variable for return #3
        Duration varB4EAC82CA7396A68D541C85D26508E83_379152141 = null; //Variable for return #4
        long _durationInMilliseconds;
        _durationInMilliseconds = durationInMilliseconds;
        {
            varB4EAC82CA7396A68D541C85D26508E83_2005400037 = newDuration(true, DatatypeConstants.FIELD_UNDEFINED,
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
                varB4EAC82CA7396A68D541C85D26508E83_1233898037 = newDuration(isPositive, DatatypeConstants.FIELD_UNDEFINED,
                        DatatypeConstants.FIELD_UNDEFINED, (int) days, hours, minutes, seconds);
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_580614623 = newDuration(isPositive, null, null,
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
        varB4EAC82CA7396A68D541C85D26508E83_379152141 = newDuration(isPositive, null, null, days, hours, minutes, seconds);
        addTaint(durationInMilliseconds);
        Duration varA7E53CE21691AB073D9660D615818899_1897035354; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1897035354 = varB4EAC82CA7396A68D541C85D26508E83_2005400037;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1897035354 = varB4EAC82CA7396A68D541C85D26508E83_1233898037;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1897035354 = varB4EAC82CA7396A68D541C85D26508E83_580614623;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1897035354 = varB4EAC82CA7396A68D541C85D26508E83_379152141;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1897035354.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1897035354;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.555 -0400", hash_original_method = "6B6A6A22BBF17FD376AF1DBB2EA2AFC0", hash_generated_method = "09E6EF3119410DF916F7194145AE0C3C")
    public Duration newDurationDayTime(
            final boolean isPositive,
            final BigInteger day,
            final BigInteger hour,
            final BigInteger minute,
            final BigInteger second) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1102220231 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1102220231 = newDuration(
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
        varB4EAC82CA7396A68D541C85D26508E83_1102220231.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1102220231;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.566 -0400", hash_original_method = "C2B5E3B114408400012B36FAE716B74D", hash_generated_method = "286E7B252100DB1EEAC42875296771CE")
    public Duration newDurationDayTime(
            final boolean isPositive,
            final int day,
            final int hour,
            final int minute,
            final int second) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1333487717 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1333487717 = newDuration(isPositive,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                day, hour, minute, second);
        addTaint(isPositive);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        varB4EAC82CA7396A68D541C85D26508E83_1333487717.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1333487717;
        // ---------- Original Method ----------
        //return newDuration(isPositive,
                //DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                //day, hour, minute, second);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.568 -0400", hash_original_method = "846082B3412BDC6279D2A475B2E6526F", hash_generated_method = "405EC8AAD985EC6C2CB52F4E305BD44C")
    public Duration newDurationYearMonth(final String lexicalRepresentation) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1251239049 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_1251239049 = newDuration(lexicalRepresentation);
        addTaint(lexicalRepresentation.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1251239049.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1251239049;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.569 -0400", hash_original_method = "056A5041DE6AEBE035AD076AE760E408", hash_generated_method = "9312E3CAE1B9E2DE81C067E36342CD65")
    public Duration newDurationYearMonth(final long durationInMilliseconds) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_23948914 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_23948914 = newDuration(durationInMilliseconds);
        addTaint(durationInMilliseconds);
        varB4EAC82CA7396A68D541C85D26508E83_23948914.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_23948914;
        // ---------- Original Method ----------
        //return newDuration(durationInMilliseconds);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.570 -0400", hash_original_method = "4B21C678040027406BF85976F89C7B54", hash_generated_method = "AC4473CD1B3E5857E97F989C14ACCF9A")
    public Duration newDurationYearMonth(
            final boolean isPositive,
            final BigInteger year,
            final BigInteger month) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1683413418 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1683413418 = newDuration(
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
        varB4EAC82CA7396A68D541C85D26508E83_1683413418.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1683413418;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.570 -0400", hash_original_method = "C5590381C9E7B3EA48F5709CED7F72BF", hash_generated_method = "F36589D20E0BE23923A823B6C27F66F7")
    public Duration newDurationYearMonth(
            final boolean isPositive,
            final int year,
            final int month) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1487046668 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1487046668 = newDuration(isPositive, year, month,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
        addTaint(isPositive);
        addTaint(year);
        addTaint(month);
        varB4EAC82CA7396A68D541C85D26508E83_1487046668.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1487046668;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.581 -0400", hash_original_method = "8A3498A1338596D8B749E79A1AFF033B", hash_generated_method = "BF6D212BC5DF93F6A46BFAEB5EEEE2D9")
    public XMLGregorianCalendar newXMLGregorianCalendar(
            final int year,
            final int month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int millisecond,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_739692810 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_739692810 = newXMLGregorianCalendar(
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
        varB4EAC82CA7396A68D541C85D26508E83_739692810.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_739692810;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.582 -0400", hash_original_method = "6ED4795EE71DC061A554DCC049589B7F", hash_generated_method = "C8F8896581E746992EB2F809518DD4A8")
    public XMLGregorianCalendar newXMLGregorianCalendarDate(
            final int year,
            final int month,
            final int day,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_414476121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_414476121 = newXMLGregorianCalendar(
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
        varB4EAC82CA7396A68D541C85D26508E83_414476121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_414476121;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.582 -0400", hash_original_method = "1E346DFC9A40C730EDE4FF1E673B8E12", hash_generated_method = "4C1DF8EB1E53DB7CD428E6D28C62B048")
    public XMLGregorianCalendar newXMLGregorianCalendarTime(
            final int hours,
            final int minutes,
            final int seconds,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_1936861452 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1936861452 = newXMLGregorianCalendar(
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
        varB4EAC82CA7396A68D541C85D26508E83_1936861452.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1936861452;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.583 -0400", hash_original_method = "F351AA210E9E98B5592EE4A1FD395A9B", hash_generated_method = "6D16975E10F377B9C5C1BBEEA1A5D1BB")
    public XMLGregorianCalendar newXMLGregorianCalendarTime(
            final int hours,
            final int minutes,
            final int seconds,
            final BigDecimal fractionalSecond,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_393367415 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_393367415 = newXMLGregorianCalendar(
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
        varB4EAC82CA7396A68D541C85D26508E83_393367415.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_393367415;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.583 -0400", hash_original_method = "2B05C064D85FF3588769E9C14DEF6EB8", hash_generated_method = "29FB391A62EDAD04AFA7BB1D0224F87A")
    public XMLGregorianCalendar newXMLGregorianCalendarTime(
            final int hours,
            final int minutes,
            final int seconds,
            final int milliseconds,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_905662424 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_905662424 = newXMLGregorianCalendarTime(
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
        varB4EAC82CA7396A68D541C85D26508E83_905662424.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_905662424;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.600 -0400", hash_original_field = "8A643B8E76E57C0958A72BBB8DDAED03", hash_generated_field = "1F1E8E0A96B491EB9D4E8354A783E019")

    public static final String DATATYPEFACTORY_PROPERTY = "javax.xml.datatype.DatatypeFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:01.600 -0400", hash_original_field = "C6B08B0490B961EE292603BF75BB45A8", hash_generated_field = "E99494A37A07F4D4D964C3B6A0C3C783")

    public static final String DATATYPEFACTORY_IMPLEMENTATION_CLASS = new String("org.apache.xerces.jaxp.datatype.DatatypeFactoryImpl");
}

