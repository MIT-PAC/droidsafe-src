/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DERGeneralizedTime extends ASN1Object {

    /**
     * return a generalized time from the passed in object
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.541 -0500", hash_original_method = "85F05324D681E81CE692F7BFF73A4329", hash_generated_method = "431758A9CEA43D39A584B29AE6495EBF")
    
public static DERGeneralizedTime getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERGeneralizedTime)
        {
            return (DERGeneralizedTime)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return a Generalized Time object from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.544 -0500", hash_original_method = "80AA951B80307EE63B89C2CEA90F28AF", hash_generated_method = "B09B7425BAFB2B3801ABE64E5D96BD14")
    
public static DERGeneralizedTime getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERGeneralizedTime)
        {
            return getInstance(o);
        }
        else
        {
            return new DERGeneralizedTime(((ASN1OctetString)o).getOctets());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.539 -0500", hash_original_field = "206625922693B80AD0E1ADE6B9CDD982", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String      time;
    
    /**
     * The correct format for this is YYYYMMDDHHMMSS[.f]Z, or without the Z
     * for local time, or Z+-HHMM on the end, for difference between local
     * time and UTC time. The fractional second amount f must consist of at
     * least one number with trailing zeroes removed.
     *
     * @param time the time string.
     * @exception IllegalArgumentException if String is an illegal format.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.547 -0500", hash_original_method = "5EF6ACB57D96EC76628792297A2B7108", hash_generated_method = "B08D25B23B7C0FE695D1FFB0CCA12B49")
    
public DERGeneralizedTime(
        String  time)
    {
        this.time = time;
        try
        {
            this.getDate();
        }
        catch (ParseException e)
        {
            throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        }
    }

    /**
     * base constructer from a java.util.date object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.551 -0500", hash_original_method = "5D85DC02B66532E4C85C7A2666266463", hash_generated_method = "83C4751FEB7E63363FEE390ABE3499E1")
    
public DERGeneralizedTime(
        Date time)
    {
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");

        dateF.setTimeZone(new SimpleTimeZone(0,"Z"));

        this.time = dateF.format(time);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.554 -0500", hash_original_method = "552D223548319DB52C5B3EC786733650", hash_generated_method = "29C94538B6992AC71CB13237D01F688C")
    
DERGeneralizedTime(
        byte[]  bytes)
    {
        //
        // explicitly convert to characters
        //
        char[]  dateC = new char[bytes.length];

        for (int i = 0; i != dateC.length; i++)
        {
            dateC[i] = (char)(bytes[i] & 0xff);
        }

        this.time = new String(dateC);
    }

    /**
     * Return the time.
     * @return The time string as it appeared in the encoded object.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.556 -0500", hash_original_method = "FFD2475F957538109629A734D2087930", hash_generated_method = "662D262A10F01332269275C3CAAA9988")
    
public String getTimeString()
    {
        return time;
    }
    
    /**
     * return the time - always in the form of 
     *  YYYYMMDDhhmmssGMT(+hh:mm|-hh:mm).
     * <p>
     * Normally in a certificate we would expect "Z" rather than "GMT",
     * however adding the "GMT" means we can just use:
     * <pre>
     *     dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
     * </pre>
     * To read in the time and get a date which is compatible with our local
     * time zone.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.559 -0500", hash_original_method = "C3D7FF56BCEB461182F81161FEBABFED", hash_generated_method = "7093941BF1B463EC1E8B8C6E37D3EE39")
    
public String getTime()
    {
        //
        // standardise the format.
        //             
        if (time.charAt(time.length() - 1) == 'Z')
        {
            return time.substring(0, time.length() - 1) + "GMT+00:00";
        }
        else
        {
            int signPos = time.length() - 5;
            char sign = time.charAt(signPos);
            if (sign == '-' || sign == '+')
            {
                return time.substring(0, signPos)
                    + "GMT"
                    + time.substring(signPos, signPos + 3)
                    + ":"
                    + time.substring(signPos + 3);
            }
            else
            {
                signPos = time.length() - 3;
                sign = time.charAt(signPos);
                if (sign == '-' || sign == '+')
                {
                    return time.substring(0, signPos)
                        + "GMT"
                        + time.substring(signPos)
                        + ":00";
                }
            }
        }            
        return time + calculateGMTOffset();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.561 -0500", hash_original_method = "EB1651DAB0D660D6B18E01CA950AD828", hash_generated_method = "0FC3C65E759C23DA14F59D604C7C4750")
    
private String calculateGMTOffset()
    {
        String sign = "+";
        TimeZone timeZone = TimeZone.getDefault();
        int offset = timeZone.getRawOffset();
        if (offset < 0)
        {
            sign = "-";
            offset = -offset;
        }
        int hours = offset / (60 * 60 * 1000);
        int minutes = (offset - (hours * 60 * 60 * 1000)) / (60 * 1000);

        try
        {
            if (timeZone.useDaylightTime() && timeZone.inDaylightTime(this.getDate()))
            {
                hours += sign.equals("+") ? 1 : -1;
            }
        }
        catch (ParseException e)
        {
            // we'll do our best and ignore daylight savings
        }

        return "GMT" + sign + convert(hours) + ":" + convert(minutes);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.564 -0500", hash_original_method = "17817B80FDAA9A144B025AECDD509966", hash_generated_method = "E38FCE191E57EA9B89EF2F22FE7E4354")
    
private String convert(int time)
    {
        if (time < 10)
        {
            return "0" + time;
        }

        return Integer.toString(time);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.567 -0500", hash_original_method = "6889666E48E5F8883310FD63C4807DBB", hash_generated_method = "9BAF3A763EA32BF8758374CE795894A1")
    
public Date getDate()
        throws ParseException
    {
        SimpleDateFormat dateF;
        String d = time;

        if (time.endsWith("Z"))
        {
            if (hasFractionalSeconds())
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            }
            else
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            }

            dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        }
        else if (time.indexOf('-') > 0 || time.indexOf('+') > 0)
        {
            d = this.getTime();
            if (hasFractionalSeconds())
            { 
                dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
            }
            else
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
            }

            dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        }
        else
        {
            if (hasFractionalSeconds())
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            }
            else
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss");
            }

            dateF.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        }

        if (hasFractionalSeconds())
        {
            // java misinterprets extra digits as being milliseconds...
            String frac = d.substring(14);
            int    index;
            for (index = 1; index < frac.length(); index++)
            {
                char ch = frac.charAt(index);
                if (!('0' <= ch && ch <= '9'))
                {
                    break;        
                }
            }

            if (index - 1 > 3)
            {
                frac = frac.substring(0, 4) + frac.substring(index);
                d = d.substring(0, 14) + frac;
            }
            else if (index - 1 == 1)
            {
                frac = frac.substring(0, index) + "00" + frac.substring(index);
                d = d.substring(0, 14) + frac;
            }
            else if (index - 1 == 2)
            {
                frac = frac.substring(0, index) + "0" + frac.substring(index);
                d = d.substring(0, 14) + frac;
            }
        }

        return dateF.parse(d);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.570 -0500", hash_original_method = "5EC472F8945A730F12ABB53C050C6A0C", hash_generated_method = "BF83E0CEC3BC8951896256286F016C05")
    
private boolean hasFractionalSeconds()
    {
        return time.indexOf('.') == 14;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.572 -0500", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "D460D0912FF7E706431D993FFB050836")
    
private byte[] getOctets()
    {
        char[]  cs = time.toCharArray();
        byte[]  bs = new byte[cs.length];

        for (int i = 0; i != cs.length; i++)
        {
            bs[i] = (byte)cs[i];
        }

        return bs;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.574 -0500", hash_original_method = "C3570560B057E7DF0510746F3C613D12", hash_generated_method = "C3570560B057E7DF0510746F3C613D12")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(GENERALIZED_TIME, this.getOctets());
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.577 -0500", hash_original_method = "F335EAF093E47550844C4E3B7BAA9B7A", hash_generated_method = "F335EAF093E47550844C4E3B7BAA9B7A")
    
boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DERGeneralizedTime))
        {
            return false;
        }

        return time.equals(((DERGeneralizedTime)o).time);
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:27.580 -0500", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "59D726F128FC0EF1749455952581310D")
    
public int hashCode()
    {
        return time.hashCode();
    }
    
}

