package javax.xml.datatype;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.GregorianCalendar;

public abstract class DatatypeFactory {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.400 -0400", hash_original_method = "6AA3D0D92E54B6A7BA707A3B727E668C", hash_generated_method = "0558D3C965ED9BE449CE780E5E411E47")
    protected  DatatypeFactory() {
        
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.401 -0400", hash_original_method = "0411875E7E9416CDC69781A523A9E7BE", hash_generated_method = "0A271AF7A58E9BFDE4AC9191F65655A0")
    public Duration newDuration(
            final boolean isPositive,
            final int years,
            final int months,
            final int days,
            final int hours,
            final int minutes,
            final int seconds) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1175150263 = null; 
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
        varB4EAC82CA7396A68D541C85D26508E83_1175150263 = newDuration(
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
        varB4EAC82CA7396A68D541C85D26508E83_1175150263.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1175150263;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.402 -0400", hash_original_method = "53DC4E20BA01B9A5F54EFBBB0F7676DB", hash_generated_method = "7696F9C44FB1533BF80E5AF1D3DDB0A7")
    public Duration newDurationDayTime(final String lexicalRepresentation) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_654164714 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The lexical representation cannot be null.");
        } 
        int pos = lexicalRepresentation.indexOf('T');
        int length;
        length = pos;
        length = lexicalRepresentation.length();
        {
            int i = 0;
            {
                char c = lexicalRepresentation.charAt(i);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid dayTimeDuration value: " + lexicalRepresentation);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_654164714 = newDuration(lexicalRepresentation);
        addTaint(lexicalRepresentation.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_654164714.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_654164714;
        
        
            
        
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.404 -0400", hash_original_method = "D4082C7434AC7344FED55B715B9658DF", hash_generated_method = "8D1ABEC9BFEBF4DA00F2953C17C663DB")
    public Duration newDurationDayTime(final long durationInMilliseconds) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1470935516 = null; 
        Duration varB4EAC82CA7396A68D541C85D26508E83_1864216395 = null; 
        Duration varB4EAC82CA7396A68D541C85D26508E83_775067169 = null; 
        Duration varB4EAC82CA7396A68D541C85D26508E83_1319661279 = null; 
        long _durationInMilliseconds = durationInMilliseconds;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1470935516 = newDuration(true, DatatypeConstants.FIELD_UNDEFINED,
                    DatatypeConstants.FIELD_UNDEFINED, 0, 0, 0, 0);
        } 
        boolean tooLong = false;
        boolean isPositive;
        {
            isPositive = false;
            {
                tooLong = true;
            } 
            _durationInMilliseconds *= -1;
        } 
        {
            isPositive = true;
        } 
        long val = _durationInMilliseconds;
        int milliseconds = (int) (val % 60000L);
        {
            int seconds = milliseconds / 1000;
            val = val / 60000L;
            int minutes = (int) (val % 60L);
            val = val / 60L;
            int hours = (int) (val % 24L);
            long days = val / 24L;
            {
                varB4EAC82CA7396A68D541C85D26508E83_1864216395 = newDuration(isPositive, DatatypeConstants.FIELD_UNDEFINED,
                        DatatypeConstants.FIELD_UNDEFINED, (int) days, hours, minutes, seconds);
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_775067169 = newDuration(isPositive, null, null,
                        BigInteger.valueOf(days), BigInteger.valueOf(hours),
                        BigInteger.valueOf(minutes), BigDecimal.valueOf(milliseconds, 3));
            } 
        } 
        BigDecimal seconds = BigDecimal.valueOf(milliseconds, 3);
        val = val / 60000L;
        BigInteger minutes = BigInteger.valueOf(val % 60L);
        val = val / 60L;
        BigInteger hours = BigInteger.valueOf(val % 24L);
        val = val / 24L;
        BigInteger days = BigInteger.valueOf(val);
        varB4EAC82CA7396A68D541C85D26508E83_1319661279 = newDuration(isPositive, null, null, days, hours, minutes, seconds);
        addTaint(durationInMilliseconds);
        Duration varA7E53CE21691AB073D9660D615818899_1600750479; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1600750479 = varB4EAC82CA7396A68D541C85D26508E83_1470935516;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1600750479 = varB4EAC82CA7396A68D541C85D26508E83_1864216395;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_1600750479 = varB4EAC82CA7396A68D541C85D26508E83_775067169;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1600750479 = varB4EAC82CA7396A68D541C85D26508E83_1319661279;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1600750479.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1600750479;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.405 -0400", hash_original_method = "6B6A6A22BBF17FD376AF1DBB2EA2AFC0", hash_generated_method = "7099BF71D550233082443E02013B54C8")
    public Duration newDurationDayTime(
            final boolean isPositive,
            final BigInteger day,
            final BigInteger hour,
            final BigInteger minute,
            final BigInteger second) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_28522541 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_28522541 = newDuration(
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
        varB4EAC82CA7396A68D541C85D26508E83_28522541.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_28522541;
        
        
                
                
                
                
                
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.406 -0400", hash_original_method = "C2B5E3B114408400012B36FAE716B74D", hash_generated_method = "22839A348605A48DD6C479C580F9CD71")
    public Duration newDurationDayTime(
            final boolean isPositive,
            final int day,
            final int hour,
            final int minute,
            final int second) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_275871020 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_275871020 = newDuration(isPositive,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                day, hour, minute, second);
        addTaint(isPositive);
        addTaint(day);
        addTaint(hour);
        addTaint(minute);
        addTaint(second);
        varB4EAC82CA7396A68D541C85D26508E83_275871020.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_275871020;
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.408 -0400", hash_original_method = "846082B3412BDC6279D2A475B2E6526F", hash_generated_method = "E74B608BDBA1136C16D71A95BB3C249E")
    public Duration newDurationYearMonth(final String lexicalRepresentation) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_679065758 = null; 
        {
            if (DroidSafeAndroidRuntime.control) throw new NullPointerException("The lexical representation cannot be null.");
        } 
        int length = lexicalRepresentation.length();
        {
            int i = 0;
            {
                char c = lexicalRepresentation.charAt(i);
                {
                    if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Invalid yearMonthDuration value: " + lexicalRepresentation);
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_679065758 = newDuration(lexicalRepresentation);
        addTaint(lexicalRepresentation.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_679065758.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_679065758;
        
        
            
        
        
        
            
            
                
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.408 -0400", hash_original_method = "056A5041DE6AEBE035AD076AE760E408", hash_generated_method = "EE62777EE9307EFC64081ED5467407E8")
    public Duration newDurationYearMonth(final long durationInMilliseconds) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_1626161266 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1626161266 = newDuration(durationInMilliseconds);
        addTaint(durationInMilliseconds);
        varB4EAC82CA7396A68D541C85D26508E83_1626161266.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1626161266;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.409 -0400", hash_original_method = "4B21C678040027406BF85976F89C7B54", hash_generated_method = "2C62F99046F8F2AA3F2E71D552F89904")
    public Duration newDurationYearMonth(
            final boolean isPositive,
            final BigInteger year,
            final BigInteger month) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_2212803 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_2212803 = newDuration(
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
        varB4EAC82CA7396A68D541C85D26508E83_2212803.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_2212803;
        
        
                
                
                
                
                
                
                
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.410 -0400", hash_original_method = "C5590381C9E7B3EA48F5709CED7F72BF", hash_generated_method = "5D1E401ED58F129FDCED20719505C3CF")
    public Duration newDurationYearMonth(
            final boolean isPositive,
            final int year,
            final int month) {
        Duration varB4EAC82CA7396A68D541C85D26508E83_74675047 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_74675047 = newDuration(isPositive, year, month,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED,
                DatatypeConstants.FIELD_UNDEFINED, DatatypeConstants.FIELD_UNDEFINED);
        addTaint(isPositive);
        addTaint(year);
        addTaint(month);
        varB4EAC82CA7396A68D541C85D26508E83_74675047.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_74675047;
        
        
                
                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.412 -0400", hash_original_method = "8A3498A1338596D8B749E79A1AFF033B", hash_generated_method = "82B164FA9A250129FA09F36185B0988B")
    public XMLGregorianCalendar newXMLGregorianCalendar(
            final int year,
            final int month,
            final int day,
            final int hour,
            final int minute,
            final int second,
            final int millisecond,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_1271214775 = null; 
        BigInteger realYear;
        realYear = BigInteger.valueOf((long) year);
        realYear = null;
        BigDecimal realMillisecond = null;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "javax.xml.datatype.DatatypeFactory#newXMLGregorianCalendar("
                        + "int year, int month, int day, int hour, int minute, int second, int millisecond, int timezone)"
                        + "with invalid millisecond: " + millisecond
                );
            } 
            realMillisecond = BigDecimal.valueOf((long) millisecond, 3);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1271214775 = newXMLGregorianCalendar(
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
        varB4EAC82CA7396A68D541C85D26508E83_1271214775.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1271214775;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.418 -0400", hash_original_method = "6ED4795EE71DC061A554DCC049589B7F", hash_generated_method = "03D36DE8429227B42DC5B307BD1ACF95")
    public XMLGregorianCalendar newXMLGregorianCalendarDate(
            final int year,
            final int month,
            final int day,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_36272839 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_36272839 = newXMLGregorianCalendar(
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
        varB4EAC82CA7396A68D541C85D26508E83_36272839.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_36272839;
        
        
                
                
                
                
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.420 -0400", hash_original_method = "1E346DFC9A40C730EDE4FF1E673B8E12", hash_generated_method = "50E50292A1132BCFF32A3C77DC7BAC48")
    public XMLGregorianCalendar newXMLGregorianCalendarTime(
            final int hours,
            final int minutes,
            final int seconds,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_607212023 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_607212023 = newXMLGregorianCalendar(
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
        varB4EAC82CA7396A68D541C85D26508E83_607212023.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_607212023;
        
        
                
                
                
                
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.421 -0400", hash_original_method = "F351AA210E9E98B5592EE4A1FD395A9B", hash_generated_method = "15492A9AB179FE0CCC57C5713E5F0ED1")
    public XMLGregorianCalendar newXMLGregorianCalendarTime(
            final int hours,
            final int minutes,
            final int seconds,
            final BigDecimal fractionalSecond,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_919843864 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_919843864 = newXMLGregorianCalendar(
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
        varB4EAC82CA7396A68D541C85D26508E83_919843864.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_919843864;
        
        
                
                
                
                
                
                
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.422 -0400", hash_original_method = "2B05C064D85FF3588769E9C14DEF6EB8", hash_generated_method = "66F36ACFBBB246728F0B40BFEB0B6174")
    public XMLGregorianCalendar newXMLGregorianCalendarTime(
            final int hours,
            final int minutes,
            final int seconds,
            final int milliseconds,
            final int timezone) {
        XMLGregorianCalendar varB4EAC82CA7396A68D541C85D26508E83_865650735 = null; 
        BigDecimal realMilliseconds = null;
        {
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException(
                        "javax.xml.datatype.DatatypeFactory#newXMLGregorianCalendarTime("
                        + "int hours, int minutes, int seconds, int milliseconds, int timezone)"
                        + "with invalid milliseconds: " + milliseconds
                );
            } 
            realMilliseconds = BigDecimal.valueOf((long) milliseconds, 3);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_865650735 = newXMLGregorianCalendarTime(
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
        varB4EAC82CA7396A68D541C85D26508E83_865650735.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_865650735;
        
        
        
            
                
                        
                        
                        
                
            
            
        
        
                
                
                
                
                
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.422 -0400", hash_original_field = "8A643B8E76E57C0958A72BBB8DDAED03", hash_generated_field = "1F1E8E0A96B491EB9D4E8354A783E019")

    public static final String DATATYPEFACTORY_PROPERTY = "javax.xml.datatype.DatatypeFactory";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:18.422 -0400", hash_original_field = "C6B08B0490B961EE292603BF75BB45A8", hash_generated_field = "E99494A37A07F4D4D964C3B6A0C3C783")

    public static final String DATATYPEFACTORY_IMPLEMENTATION_CLASS = new String("org.apache.xerces.jaxp.datatype.DatatypeFactoryImpl");
}

