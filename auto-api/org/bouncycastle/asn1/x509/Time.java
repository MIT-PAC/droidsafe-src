package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERUTCTime;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Time extends ASN1Encodable implements ASN1Choice {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.117 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "9454FEFE155A6399796F93141389DE58")

    DERObject time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.117 -0400", hash_original_method = "01C20E280B683C170EEEF3EFC0766C68", hash_generated_method = "B8DF5CE0D9E5F0B53F6FE8C13AB222B6")
    public  Time(
        DERObject   time) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown object passed to Time");
        } //End block
        this.time = time;
        // ---------- Original Method ----------
        //if (!(time instanceof DERUTCTime)
            //&& !(time instanceof DERGeneralizedTime))
        //{
            //throw new IllegalArgumentException("unknown object passed to Time");
        //}
        //this.time = time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.118 -0400", hash_original_method = "8BBEA010362F5295A61D1C019D01CC8B", hash_generated_method = "9CCDE62DBDC6B8CD3646EF7AFFD71FF3")
    public  Time(
        Date    date) {
        SimpleTimeZone tz;
        tz = new SimpleTimeZone(0, "Z");
        SimpleDateFormat dateF;
        dateF = new SimpleDateFormat("yyyyMMddHHmmss");
        dateF.setTimeZone(tz);
        String d;
        d = dateF.format(date) + "Z";
        int year;
        year = Integer.parseInt(d.substring(0, 4));
        {
            time = new DERGeneralizedTime(d);
        } //End block
        {
            time = new DERUTCTime(d.substring(2));
        } //End block
        addTaint(date.getTaint());
        // ---------- Original Method ----------
        //SimpleTimeZone      tz = new SimpleTimeZone(0, "Z");
        //SimpleDateFormat    dateF = new SimpleDateFormat("yyyyMMddHHmmss");
        //dateF.setTimeZone(tz);
        //String  d = dateF.format(date) + "Z";
        //int     year = Integer.parseInt(d.substring(0, 4));
        //if (year < 1950 || year > 2049)
        //{
            //time = new DERGeneralizedTime(d);
        //}
        //else
        //{
            //time = new DERUTCTime(d.substring(2));
        //}
    }

    
        public static Time getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(obj.getObject());
    }

    
        public static Time getInstance(
        Object  obj) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.121 -0400", hash_original_method = "BF57E645E9DF37568C2EEE61DCF61153", hash_generated_method = "60C8143BAB56F79E01C51873300FF781")
    public String getTime() {
        String varB4EAC82CA7396A68D541C85D26508E83_261498137 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2137957684 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_261498137 = ((DERUTCTime)time).getAdjustedTime();
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2137957684 = ((DERGeneralizedTime)time).getTime();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1314263821; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1314263821 = varB4EAC82CA7396A68D541C85D26508E83_261498137;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1314263821 = varB4EAC82CA7396A68D541C85D26508E83_2137957684;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1314263821.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1314263821;
        // ---------- Original Method ----------
        //if (time instanceof DERUTCTime)
        //{
            //return ((DERUTCTime)time).getAdjustedTime();
        //}
        //else
        //{
            //return ((DERGeneralizedTime)time).getTime();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.124 -0400", hash_original_method = "FDC0BE61EAA40B266A36758B51B3F270", hash_generated_method = "EA3B46C6073ECB9F159E197EBAB3A201")
    public Date getDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_790667568 = null; //Variable for return #1
        Date varB4EAC82CA7396A68D541C85D26508E83_1697635077 = null; //Variable for return #2
        try 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_790667568 = ((DERUTCTime)time).getAdjustedDate();
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_1697635077 = ((DERGeneralizedTime)time).getDate();
            } //End block
        } //End block
        catch (ParseException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("invalid date string: " + e.getMessage());
        } //End block
        Date varA7E53CE21691AB073D9660D615818899_525810970; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_525810970 = varB4EAC82CA7396A68D541C85D26508E83_790667568;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_525810970 = varB4EAC82CA7396A68D541C85D26508E83_1697635077;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_525810970.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_525810970;
        // ---------- Original Method ----------
        //try
        //{
            //if (time instanceof DERUTCTime)
            //{
                //return ((DERUTCTime)time).getAdjustedDate();
            //}
            //else
            //{
                //return ((DERGeneralizedTime)time).getDate();
            //}
        //}
        //catch (ParseException e)
        //{         
            //throw new IllegalStateException("invalid date string: " + e.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.125 -0400", hash_original_method = "4A8C4B62F84A5603FDAAD94F25A110A4", hash_generated_method = "4111DF186B478CB5DA555670CB170E46")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_677552541 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_677552541 = time;
        varB4EAC82CA7396A68D541C85D26508E83_677552541.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_677552541;
        // ---------- Original Method ----------
        //return time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:19.125 -0400", hash_original_method = "B1D8E302C2A2168C967B1C035989FAE4", hash_generated_method = "35EEB939756B59C049A602AADFB9B09D")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2011218262 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2011218262 = getTime();
        varB4EAC82CA7396A68D541C85D26508E83_2011218262.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2011218262;
        // ---------- Original Method ----------
        //return getTime();
    }

    
}

