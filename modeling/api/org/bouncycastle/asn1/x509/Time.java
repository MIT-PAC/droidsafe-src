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


package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERUTCTime;

public class Time extends ASN1Encodable implements ASN1Choice {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.056 -0500", hash_original_method = "B37BC1B36F5E6A9ABA24A45CBD3FE691", hash_generated_method = "ACED46F7E3ACA317DA4C8EE039BBBA8F")
    
public static Time getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(obj.getObject()); // must be explicitly tagged
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.065 -0500", hash_original_method = "237950956A00631275886D322655310C", hash_generated_method = "4C8D4C4A253E3B4FC45909275BFA1DF5")
    
public static Time getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof Time)
        {
            return (Time)obj;
        }
        else if (obj instanceof DERUTCTime)
        {
            return new Time((DERUTCTime)obj);
        }
        else if (obj instanceof DERGeneralizedTime)
        {
            return new Time((DERGeneralizedTime)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.054 -0500", hash_original_field = "9454FEFE155A6399796F93141389DE58", hash_generated_field = "9454FEFE155A6399796F93141389DE58")

    DERObject   time;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.059 -0500", hash_original_method = "01C20E280B683C170EEEF3EFC0766C68", hash_generated_method = "D6EFD18FE2097BAA10BC168EF3FA2142")
    
public Time(
        DERObject   time)
    {
        if (!(time instanceof DERUTCTime)
            && !(time instanceof DERGeneralizedTime))
        {
            throw new IllegalArgumentException("unknown object passed to Time");
        }

        this.time = time; 
    }

    /**
     * creates a time object from a given date - if the date is between 1950
     * and 2049 a UTCTime object is generated, otherwise a GeneralizedTime
     * is used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.062 -0500", hash_original_method = "8BBEA010362F5295A61D1C019D01CC8B", hash_generated_method = "E6257857295F6B2249220AB672C4A441")
    
public Time(
        Date    date)
    {
        SimpleTimeZone      tz = new SimpleTimeZone(0, "Z");
        SimpleDateFormat    dateF = new SimpleDateFormat("yyyyMMddHHmmss");

        dateF.setTimeZone(tz);

        String  d = dateF.format(date) + "Z";
        int     year = Integer.parseInt(d.substring(0, 4));

        if (year < 1950 || year > 2049)
        {
            time = new DERGeneralizedTime(d);
        }
        else
        {
            time = new DERUTCTime(d.substring(2));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.067 -0500", hash_original_method = "BF57E645E9DF37568C2EEE61DCF61153", hash_generated_method = "2CAFC59938315002501ACFC493B08254")
    
public String getTime()
    {
        if (time instanceof DERUTCTime)
        {
            return ((DERUTCTime)time).getAdjustedTime();
        }
        else
        {
            return ((DERGeneralizedTime)time).getTime();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.069 -0500", hash_original_method = "FDC0BE61EAA40B266A36758B51B3F270", hash_generated_method = "28D72284CF0EDED24018CA0AB2C60FFA")
    
public Date getDate()
    {
        try
        {
            if (time instanceof DERUTCTime)
            {
                return ((DERUTCTime)time).getAdjustedDate();
            }
            else
            {
                return ((DERGeneralizedTime)time).getDate();
            }
        }
        catch (ParseException e)
        {         // this should never happen
            throw new IllegalStateException("invalid date string: " + e.getMessage());
        }
    }

    /**
     * Produce an object suitable for an ASN1OutputStream.
     * <pre>
     * Time ::= CHOICE {
     *             utcTime        UTCTime,
     *             generalTime    GeneralizedTime }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.072 -0500", hash_original_method = "4A8C4B62F84A5603FDAAD94F25A110A4", hash_generated_method = "36AF32E132FC34B4855AA58770404BB5")
    
public DERObject toASN1Object()
    {
        return time;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.074 -0500", hash_original_method = "B1D8E302C2A2168C967B1C035989FAE4", hash_generated_method = "30ABA8BCDD0F3EECE8F4AAE300E6F0F1")
    
public String toString()
    {
        return getTime();
    }
    
}

