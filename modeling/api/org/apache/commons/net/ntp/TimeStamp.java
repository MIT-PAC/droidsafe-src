package org.apache.commons.net.ntp;
/*
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.TimeZone;
import java.util.Date;
import java.util.Locale;
import java.lang.ref.SoftReference;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

/***
 * TimeStamp class represents the Network Time Protocol (NTP) timestamp
 * as defined in RFC-1305 and SNTP (RFC-2030). It is represented as a
 * 64-bit unsigned fixed-point number in seconds relative to 0-hour on 1-January-1900.
 * The 32-bit low-order bits are the fractional seconds whose precision is
 * about 200 picoseconds. Assumes overflow date when date passes MAX_LONG
 * and reverts back to 0 is 2036 and not 1900. Test for most significant
 * bit: if MSB=0 then 2036 basis is used otherwise 1900 if MSB=1.
 * <p>
 * Methods exist to convert NTP timestamps to and from the equivalent Java date
 * representation, which is the number of milliseconds since the standard base
 * time known as "the epoch", namely January 1, 1970, 00:00:00 GMT.
 * </p>
 *
 * @author Jason Mathews, MITRE Corp
 * @version $Revision: 165675 $ $Date: 2005-05-02 15:09:55 -0500 (Mon, 02 May 2005) $
 * @see java.util.Date
 */
public class TimeStamp implements java.io.Serializable, Comparable
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.527 -0500", hash_original_field = "060594ADAB533D1790D0024DC9BCFD2A", hash_generated_field = "F583E34DF0A21A3B49EB2D0615CE7712")

    protected static final long msb0baseTime = 2085978496000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.534 -0500", hash_original_field = "1F11C1BA7BE5441B392A68CF7101ABC9", hash_generated_field = "D0445E29969CAC6BE9A3DD5B520B5D00")

    protected static final long msb1baseTime = -2208988800000L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.541 -0500", hash_original_field = "BFF111443D7E70E5E8925F4971184939", hash_generated_field = "EA6A6A69FA2CD4AFA660808FCEE0C301")

    public final static String NTP_DATE_FORMAT = "EEE, MMM dd yyyy HH:mm:ss.SSS";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.547 -0500", hash_original_field = "036528EB64158A2D759B8EC74CA4B59E", hash_generated_field = "2DF26430D3170CE249828CAD552EC91B")

    private static SoftReference simpleFormatter = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.554 -0500", hash_original_field = "E3F5858EB50B11DDB4B8DD9D9A4F75DB", hash_generated_field = "3E58A1D8ABDF1D6F45ACD84FBF2F1F68")

    private static SoftReference utcFormatter = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.569 -0500", hash_original_field = "62E36A902B75294BC3BD92777512C431", hash_generated_field = "76F724EFCF3CCC11DA3A4803D321DE3B")

    private static final long serialVersionUID = 8139806907588338737L;

    /***
     * Convert 64-bit NTP timestamp to Java standard time.
     *
     * Note that java time (milliseconds) by definition has less precision
     * then NTP time (picoseconds) so converting NTP timestamp to java time and back
     * to NTP timestamp loses precision. For example, Tue, Dec 17 2002 09:07:24.810 EST
     * is represented by a single Java-based time value of f22cd1fc8a, but its
     * NTP equivalent are all values ranging from c1a9ae1c.cf5c28f5 to c1a9ae1c.cf9db22c.
     *
     * @param ntpTimeValue
     * @return the number of milliseconds since January 1, 1970, 00:00:00 GMT
     * represented by this NTP timestamp value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.818 -0500", hash_original_method = "65A1D403DF3DADCBF58AEFA91D37A51C", hash_generated_method = "50D4A64540FC04E44538C452F493CDE0")
    
public static long getTime(long ntpTimeValue)
    {
        long seconds = (ntpTimeValue >>> 32) & 0xffffffffL;	// high-order 32-bits
        long fraction = ntpTimeValue & 0xffffffffL;		// low-order 32-bits

        // Use round-off on fractional part to preserve going to lower precision
        fraction = Math.round(1000D * fraction / 0x100000000L);

        /*
         * If the most significant bit (MSB) on the seconds field is set we use
         * a different time base. The following text is a quote from RFC-2030 (SNTP v4):
         *
         *  If bit 0 is set, the UTC time is in the range 1968-2036 and UTC time
         *  is reckoned from 0h 0m 0s UTC on 1 January 1900. If bit 0 is not set,
         *  the time is in the range 2036-2104 and UTC time is reckoned from
         *  6h 28m 16s UTC on 7 February 2036.
         */
        long msb = seconds & 0x80000000L;
        if (msb == 0) {
            // use base: 7-Feb-2036 @ 06:28:16 UTC
            return msb0baseTime + (seconds * 1000) + fraction;
        } else {
            // use base: 1-Jan-1900 @ 01:00:00 UTC
            return msb1baseTime + (seconds * 1000) + fraction;
        }
    }

    /***
     * Helper method to convert Java time to NTP timestamp object.
     * Note that Java time (milliseconds) by definition has less precision
     * then NTP time (picoseconds) so converting Ntptime to Javatime and back
     * to Ntptime loses precision. For example, Tue, Dec 17 2002 09:07:24.810
     * is represented by a single Java-based time value of f22cd1fc8a, but its
     * NTP equivalent are all values from c1a9ae1c.cf5c28f5 to c1a9ae1c.cf9db22c.
     * @param   date   the milliseconds since January 1, 1970, 00:00:00 GMT.
     * @return NTP timestamp object at the specified date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.824 -0500", hash_original_method = "F2FF975B28F3AED1A3CF0C5240EA7E82", hash_generated_method = "F1BBC6C30CAED5C58B062C0C2228EBA5")
    
public static TimeStamp getNtpTime(long date)
    {
        return new TimeStamp(toNtpTime(date));
    }

    /***
     * Constructs a NTP timestamp object and initializes it so that
     * it represents the time at which it was allocated, measured to the
     * nearest millisecond.
     * @return NTP timestamp object set to the current time.
     * @see     java.lang.System#currentTimeMillis()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.829 -0500", hash_original_method = "FD90B881D3FD62D82A43D49DF84544AC", hash_generated_method = "246BA47A7028933F281E2822FB1FE168")
    
public static TimeStamp getCurrentTime()
    {
        return getNtpTime(System.currentTimeMillis());
    }

    /***
     * Convert NTP timestamp hexstring (e.g. "c1a089bd.fc904f6d") to the NTP
     * 64-bit unsigned fixed-point number.
     *
     * @return NTP 64-bit timestamp value.
     * @throws NumberFormatException - if the string does not contain a parsable timestamp.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.835 -0500", hash_original_method = "24B49B0CD5ACD1DC256CEA429DC25DA6", hash_generated_method = "BC23817EC7C8DFCF50BD1B83AA72EB21")
    
protected static long decodeNtpHexString(String s)
            throws NumberFormatException
    {
        if (s == null) {
            throw new NumberFormatException("null");
        }
        int ind = s.indexOf('.');
        if (ind == -1) {
            if (s.length() == 0) return 0;
            return Long.parseLong(s, 16) << 32; // no decimal
        }

        return Long.parseLong(s.substring(0, ind), 16) << 32 |
                Long.parseLong(s.substring(ind + 1), 16);
    }

    /***
     * Parses the string argument as a NTP hexidecimal timestamp representation string
     * (e.g. "c1a089bd.fc904f6d").
     *
     * @param s - hexstring.
     * @return the Timestamp represented by the argument in hexidecimal.
     * @throws NumberFormatException - if the string does not contain a parsable timestamp.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.841 -0500", hash_original_method = "A434717C5E1CC7DE726BE44ADF4AB233", hash_generated_method = "A2512A3FF7754651D7570861EEC907B9")
    
public static TimeStamp parseNtpString(String s)
            throws NumberFormatException
    {
        return new TimeStamp(decodeNtpHexString(s));
    }

    /***
     * Converts Java time to 64-bit NTP time representation.
     *
     * @param t Java time
     * @return NTP timestamp representation of Java time value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.848 -0500", hash_original_method = "925F30C66D72EC6F79C9BA5892CFF1DD", hash_generated_method = "558B5397C621FBF92D8EECC0FC621376")
    
protected static long toNtpTime(long t)
    {
        boolean useBase1 = t < msb0baseTime;	// time < Feb-2036
        long baseTime;
        if (useBase1) {
            baseTime = t - msb1baseTime; // dates <= Feb-2036
        } else {
            // if base0 needed for dates >= Feb-2036
            baseTime = t - msb0baseTime;
        }

        long seconds = baseTime / 1000;
        long fraction = ((baseTime % 1000) * 0x100000000L) / 1000;

        if (useBase1) {
            seconds |= 0x80000000L; // set high-order bit if msb1baseTime 1900 used
        }

        long time = seconds << 32 | fraction;
        return time;
    }

    /***
     * Left-pad 8-character hex string with 0's
     *
     * @param buf - StringBuffer which is appended with leading 0's.
     * @param l - a long.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.868 -0500", hash_original_method = "6F68B6CD71FAD40FB94A8A34B90682BB", hash_generated_method = "A8626659567E2DA931BE81C97349C783")
    
private static void appendHexString(StringBuffer buf, long l)
    {
        String s = Long.toHexString(l);
        for (int i = s.length(); i < 8; i++)
            buf.append('0');
        buf.append(s);
    }

    /***
     * Converts 64-bit NTP timestamp value to a <code>String</code>.
     * The NTP timestamp value is represented as hex string with
     * seconds separated by fractional seconds by a decimal point;
     * e.g. c1a089bd.fc904f6d <=> Tue, Dec 10 2002 10:41:49.986
     *
     * @return NTP timestamp 64-bit long value as hex string with seconds
     * separated by fractional seconds.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.874 -0500", hash_original_method = "8D01996EB7B68AD896BC3623C3BCF2F5", hash_generated_method = "E3B8323B4E1DE71A252FFB148966DCBC")
    
public static String toString(long ntpTime)
    {
        StringBuffer buf = new StringBuffer();
        // high-order second bits (32..63) as hexstring
        appendHexString(buf, (ntpTime >>> 32) & 0xffffffffL);

        // low-order fractional seconds bits (0..31) as hexstring
        buf.append('.');
        appendHexString(buf, ntpTime & 0xffffffffL);

        return buf.toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.562 -0500", hash_original_field = "628664DA65AF1A08D259AB7A8DBAA39C", hash_generated_field = "86141BF61B59F00B4CDAEA8A1D149CDA")

    private long ntpTime;

    // initialization of static time bases
    /*
    static {
        TimeZone utcZone = TimeZone.getTimeZone("UTC");
        Calendar calendar = Calendar.getInstance(utcZone);
        calendar.set(1900, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        msb1baseTime = calendar.getTime().getTime();
        calendar.set(2036, Calendar.FEBRUARY, 7, 6, 28, 16);
        calendar.set(Calendar.MILLISECOND, 0);
        msb0baseTime = calendar.getTime().getTime();
    }
    */

    /***
     * Constructs a newly allocated NTP timestamp object
     * that represents the native 64-bit long argument.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.771 -0500", hash_original_method = "F8FDE5CCF948AA765FD3A63854787123", hash_generated_method = "B265104B01E034D703A46D2765BEA6C5")
    
public TimeStamp(long ntpTime)
    {
        this.ntpTime = ntpTime;
    }

    /***
     * Constructs a newly allocated NTP timestamp object
     * that represents the value represented by the string
     * in hexdecimal form (e.g. "c1a089bd.fc904f6d").
     *
     * @throws NumberFormatException - if the string does not contain a parsable timestamp.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.778 -0500", hash_original_method = "373684D9576771B4880AF9E0BF951044", hash_generated_method = "523653B449FB51034EEBFF1147E5BD55")
    
public TimeStamp(String s) throws NumberFormatException
    {
        ntpTime = decodeNtpHexString(s);
    }

    /***
     * Constructs a newly allocated NTP timestamp object
     * that represents the Java Date argument.
     *
     * @param d - the Date to be represented by the Timestamp object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.784 -0500", hash_original_method = "7FE7A3338730D66992FED5507DFFCCC7", hash_generated_method = "75C27C046264D60F350FE6AF36283750")
    
public TimeStamp(Date d)
    {
        ntpTime = (d == null) ? 0 : toNtpTime(d.getTime());
    }

    /***
     * Returns the value of this Timestamp as a long value.
     *
     * @return the 64-bit long value represented by this object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.789 -0500", hash_original_method = "08B1FFF12F3A2A6B1FA7AE4A9CD9EAF5", hash_generated_method = "2F247EB8C788F3DF8092119537308E70")
    
public long ntpValue()
    {
        return ntpTime;
    }

    /***
     * Returns high-order 32-bits representing the seconds of this NTP timestamp.
     *
     * @return seconds represented by this NTP timestamp.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.795 -0500", hash_original_method = "96623CF98FB62A740C74715EF69DF9C4", hash_generated_method = "4EEC74460950AF27CF7D5A20034F1F74")
    
public long getSeconds()
    {
        return (ntpTime >>> 32) & 0xffffffffL;
    }

    /***
     * Returns low-order 32-bits representing the fractional seconds.
     *
     * @return fractional seconds represented by this NTP timestamp.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.800 -0500", hash_original_method = "4540D7F7B879E08EE60043E1275E24B6", hash_generated_method = "B11E8E57E6BB6B44FF5F1A52AD440573")
    
public long getFraction()
    {
        return ntpTime & 0xffffffffL;
    }

    /***
     * Convert NTP timestamp to Java standard time.
     *
     * @return NTP Timestamp in Java time
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.805 -0500", hash_original_method = "4CC8AC753B8E97D83AA4BFA4D454E01A", hash_generated_method = "618AF55296B865FFB4BA32723B63FC94")
    
public long getTime()
    {
        return getTime(ntpTime);
    }

    /***
     * Convert NTP timestamp to Java Date object.
     *
     * @return NTP Timestamp in Java Date
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.809 -0500", hash_original_method = "F3AAE1744AC199919B0B5FB2E11FDE16", hash_generated_method = "BF81B5BDFA3A07F86742E02844A6048E")
    
public Date getDate()
    {
        long time = getTime(ntpTime);
        return new Date(time);
    }

    /***
     * Computes a hashcode for this Timestamp. The result is the exclusive
     * OR of the two halves of the primitive <code>long</code> value
     * represented by this <code>TimeStamp</code> object. That is, the hashcode
     * is the value of the expression:
     * <blockquote><pre>
     * (int)(this.ntpValue()^(this.ntpValue() >>> 32))
     * </pre></blockquote>
     *
     * @return  a hash code value for this object.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.853 -0500", hash_original_method = "CEE737EA9770EEB8C0C4A77F707911F5", hash_generated_method = "A7F81B9D6A28C25355952EB87CD718E0")
    
public int hashCode()
    {
        return (int) (ntpTime ^ (ntpTime >>> 32));
    }

    /***
     * Compares this object against the specified object.
     * The result is <code>true</code> if and only if the argument is
     * not <code>null</code> and is a <code>Long</code> object that
     * contains the same <code>long</code> value as this object.
     *
     * @param   obj   the object to compare with.
     * @return  <code>true</code> if the objects are the same;
     *          <code>false</code> otherwise.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.858 -0500", hash_original_method = "1E825B982EDCD87AA4529BBFDCDBA2F1", hash_generated_method = "0B022ADB77E9F842F6D3E66104DE289B")
    
public boolean equals(Object obj)
    {
        if (obj instanceof TimeStamp) {
            return ntpTime == ((TimeStamp) obj).ntpValue();
        }
        return false;
    }

    /***
     * Converts this <code>TimeStamp</code> object to a <code>String</code>.
     * The NTP timestamp 64-bit long value is represented as hex string with
     * seconds separated by fractional seconds by a decimal point;
     * e.g. c1a089bd.fc904f6d <=> Tue, Dec 10 2002 10:41:49.986
     *
     * @return NTP timestamp 64-bit long value as hex string with seconds
     * separated by fractional seconds.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.863 -0500", hash_original_method = "7FBFA5DF7A2D6014C9CA2F913F0914FC", hash_generated_method = "F39600EBE8DF940850F3163642F0ABA9")
    
public String toString()
    {
        return toString(ntpTime);
    }

    /***
     * Converts this <code>TimeStamp</code> object to a <code>String</code>
     * of the form:
     * <blockquote><pre>
     * EEE, MMM dd yyyy HH:mm:ss.SSS</pre></blockquote>
     * See java.text.SimpleDataFormat for code descriptions.
     *
     * @return  a string representation of this date.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.880 -0500", hash_original_method = "DB175667028EEA0CA3219C62B00F7652", hash_generated_method = "67542DC7E3F3B9AC2A81F829455030FB")
    
public String toDateString()
    {
        DateFormat formatter = null;
        if (simpleFormatter != null) {
            formatter = (DateFormat) simpleFormatter.get();
        }
        if (formatter == null) {
            // No cache yet, or cached formatter GC'd
            formatter = new SimpleDateFormat(NTP_DATE_FORMAT, Locale.US);
            formatter.setTimeZone(TimeZone.getDefault());
            simpleFormatter = new SoftReference(formatter);
        }
        Date ntpDate = getDate();
        synchronized (formatter) {
            return formatter.format(ntpDate);
        }
    }

    /***
     * Converts this <code>TimeStamp</code> object to a <code>String</code>
     * of the form:
     * <blockquote><pre>
     * EEE, MMM dd yyyy HH:mm:ss.SSS UTC</pre></blockquote>
     * See java.text.SimpleDataFormat for code descriptions.
     *
     * @return  a string representation of this date in UTC.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.885 -0500", hash_original_method = "46653CE555A124E4EA927F5441674BF4", hash_generated_method = "C03BFCFAF8B698FAF3BCE574B23B0C4B")
    
public String toUTCString()
    {
        DateFormat formatter = null;
        if (utcFormatter != null)
            formatter = (DateFormat) utcFormatter.get();
        if (formatter == null) {
            // No cache yet, or cached formatter GC'd
            formatter = new SimpleDateFormat(NTP_DATE_FORMAT + " 'UTC'",
                    Locale.US);
            formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
            utcFormatter = new SoftReference(formatter);
        }
        Date ntpDate = getDate();
        synchronized (formatter) {
            return formatter.format(ntpDate);
        }
    }

    /***
     * Compares two Timestamps numerically.
     *
     * @param   anotherTimeStamp - the <code>TimeStamp</code> to be compared.
     * @return  the value <code>0</code> if the argument TimeStamp is equal to
     *          this TimeStamp; a value less than <code>0</code> if this TimeStamp
     *          is numerically less than the TimeStamp argument; and a
     *          value greater than <code>0</code> if this TimeStamp is
     *          numerically greater than the TimeStamp argument
     *		(signed comparison).
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.890 -0500", hash_original_method = "6C9BE2FDA6A6DE8BDC29D06750EF7E58", hash_generated_method = "9B240D65625C603E270174F90B22BFA3")
    
public int compareTo(TimeStamp anotherTimeStamp)
    {
        long thisVal = this.ntpTime;
        long anotherVal = anotherTimeStamp.ntpTime;
        return (thisVal < anotherVal ? -1 : (thisVal == anotherVal ? 0 : 1));
    }

    /***
     * Compares this TimeStamp to another Object.  If the Object is a TimeStamp,
     * this function behaves like <code>compareTo(TimeStamp)</code>.  Otherwise,
     * it throws a <code>ClassCastException</code> (as TimeStamps are comparable
     * only to other TimeStamps).
     *
     * @param   o the <code>Object</code> to be compared.
     * @return  the value <code>0</code> if the argument is a TimeStamp
     *		numerically equal to this TimeStamp; a value less than
     *		<code>0</code> if the argument is a TimeStamp numerically
     *		greater than this TimeStamp; and a value greater than
     *		<code>0</code> if the argument is a TimeStamp numerically
     *		less than this TimeStamp.
     * @exception ClassCastException if the argument is not a
     *		  <code>TimeStamp</code>.
     * @see     java.lang.Comparable
     */
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:37:54.895 -0500", hash_original_method = "C9691A632D85B9C742B4A7081A303F66", hash_generated_method = "63A86E000F5624B8F5BC47110EB2C926")
    
public int compareTo(Object o)
    {
        return compareTo((TimeStamp) o);
    }

}
