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

public class DERUTCTime extends ASN1Object {

    /**
     * return an UTC Time from the passed in object.
     *
     * @exception IllegalArgumentException if the object cannot be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.380 -0500", hash_original_method = "60040ED3861E665197CA369A34A2A9D7", hash_generated_method = "3EA4F1FA99C8CD6E326DE64FA937AD98")
    
public static DERUTCTime getInstance(
        Object  obj)
    {
        if (obj == null || obj instanceof DERUTCTime)
        {
            return (DERUTCTime)obj;
        }

        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    /**
     * return an UTC Time from a tagged object.
     *
     * @param obj the tagged object holding the object we want
     * @param explicit true if the object is meant to be explicitly
     *              tagged false otherwise.
     * @exception IllegalArgumentException if the tagged object cannot
     *               be converted.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.382 -0500", hash_original_method = "2A947E67537ED12E48A973BE603C7D16", hash_generated_method = "08DA190E711FB00F8F00E6722B1D41EC")
    
public static DERUTCTime getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        DERObject o = obj.getObject();

        if (explicit || o instanceof DERUTCTime)
        {
            return getInstance(o);
        }
        else
        {
            return new DERUTCTime(((ASN1OctetString)o).getOctets());
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.378 -0500", hash_original_field = "206625922693B80AD0E1ADE6B9CDD982", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String      time;
    
    /**
     * The correct format for this is YYMMDDHHMMSSZ (it used to be that seconds were
     * never encoded. When you're creating one of these objects from scratch, that's
     * what you want to use, otherwise we'll try to deal with whatever gets read from
     * the input stream... (this is why the input format is different from the getTime()
     * method output).
     * <p>
     *
     * @param time the time string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.386 -0500", hash_original_method = "1E3E40D5CDC8E036C03E11512D357967", hash_generated_method = "62E3811DA36AD04887EE581C18525045")
    
public DERUTCTime(
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.389 -0500", hash_original_method = "889E462D85EE47A04EE3B8EBB5F8A587", hash_generated_method = "AC1FAE4F660A1CD3FB5D92FDA26305C8")
    
public DERUTCTime(
        Date time)
    {
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmss'Z'");

        dateF.setTimeZone(new SimpleTimeZone(0,"Z"));

        this.time = dateF.format(time);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.392 -0500", hash_original_method = "64E72DE8C26EBEE8B82B8D6629E000CC", hash_generated_method = "8602862A4DB4222918F4044B80FE27AE")
    
DERUTCTime(
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
     * return the time as a date based on whatever a 2 digit year will return. For
     * standardised processing use getAdjustedDate().
     *
     * @return the resulting date
     * @exception ParseException if the date string cannot be parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.394 -0500", hash_original_method = "BA9EB44B4A66633868FF183B46999299", hash_generated_method = "07B1F7BF69D4F7E770E2318D5AB5EBA2")
    
public Date getDate()
        throws ParseException
    {
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmssz");

        return dateF.parse(getTime());
    }

    /**
     * return the time as an adjusted date
     * in the range of 1950 - 2049.
     *
     * @return a date in the range of 1950 to 2049.
     * @exception ParseException if the date string cannot be parsed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.397 -0500", hash_original_method = "B4832BCFF9515347D769B05CF978B8C2", hash_generated_method = "94650F37B69D1378DBEA2103CE2D4751")
    
public Date getAdjustedDate()
        throws ParseException
    {
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmssz");

        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));

        return dateF.parse(getAdjustedTime());
    }

    /**
     * return the time - always in the form of 
     *  YYMMDDhhmmssGMT(+hh:mm|-hh:mm).
     * <p>
     * Normally in a certificate we would expect "Z" rather than "GMT",
     * however adding the "GMT" means we can just use:
     * <pre>
     *     dateF = new SimpleDateFormat("yyMMddHHmmssz");
     * </pre>
     * To read in the time and get a date which is compatible with our local
     * time zone.
     * <p>
     * <b>Note:</b> In some cases, due to the local date processing, this
     * may lead to unexpected results. If you want to stick the normal
     * convention of 1950 to 2049 use the getAdjustedTime() method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.400 -0500", hash_original_method = "01C2B859B7363E454246C04CBB075287", hash_generated_method = "DD3CD3EF4462F5C613E6C07A8D6001C4")
    
public String getTime()
    {
        //
        // standardise the format.
        //
        if (time.indexOf('-') < 0 && time.indexOf('+') < 0)
        {
            if (time.length() == 11)
            {
                return time.substring(0, 10) + "00GMT+00:00";
            }
            else
            {
                return time.substring(0, 12) + "GMT+00:00";
            }
        }
        else
        {
            int index = time.indexOf('-');
            if (index < 0)
            {
                index = time.indexOf('+');
            }
            String d = time;

            if (index == time.length() - 3)
            {
                d += "00";
            }

            if (index == 10)
            {
                return d.substring(0, 10) + "00GMT" + d.substring(10, 13) + ":" + d.substring(13, 15);
            }
            else
            {
                return d.substring(0, 12) + "GMT" + d.substring(12, 15) + ":" +  d.substring(15, 17);
            }
        }
    }

    /**
     * return a time string as an adjusted date with a 4 digit year. This goes
     * in the range of 1950 - 2049.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.402 -0500", hash_original_method = "F061A0CEFEFA91AF7DA40604EA772B20", hash_generated_method = "843F9EFF9887468524FEB3545818EF0F")
    
public String getAdjustedTime()
    {
        String   d = this.getTime();

        if (d.charAt(0) < '5')
        {
            return "20" + d;
        }
        else
        {
            return "19" + d;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.404 -0500", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "D460D0912FF7E706431D993FFB050836")
    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.407 -0500", hash_original_method = "61B114EE0877AC878307DF8632824910", hash_generated_method = "61B114EE0877AC878307DF8632824910")
    
void encode(
        DEROutputStream  out)
        throws IOException
    {
        out.writeEncoded(UTC_TIME, this.getOctets());
    }
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.409 -0500", hash_original_method = "0AA77B1E8A82CB516C576E10CBE19EDE", hash_generated_method = "0AA77B1E8A82CB516C576E10CBE19EDE")
    
boolean asn1Equals(
        DERObject  o)
    {
        if (!(o instanceof DERUTCTime))
        {
            return false;
        }

        return time.equals(((DERUTCTime)o).time);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.411 -0500", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "59D726F128FC0EF1749455952581310D")
    
public int hashCode()
    {
        return time.hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:13.413 -0500", hash_original_method = "0230A74DF7F00CEFAD5D2184A68DC5A0", hash_generated_method = "3DDDB32ACB777E0E45FA1663E03C73C7")
    
public String toString() 
    {
      return time;
    }
    
}

