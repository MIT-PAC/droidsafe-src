package org.bouncycastle.asn1.x509;

// Droidsafe Imports
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

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class Time extends ASN1Encodable implements ASN1Choice {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.964 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "9454FEFE155A6399796F93141389DE58")

    DERObject time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.964 -0400", hash_original_method = "01C20E280B683C170EEEF3EFC0766C68", hash_generated_method = "86AEDB52A98DAF180650ABDAA28E6A99")
    public  Time(
        DERObject   time) {
        if(!(time instanceof DERUTCTime)
            && !(time instanceof DERGeneralizedTime))        
        {
            IllegalArgumentException varEB3AD89893BE62E8E2C248F9BE2332CE_480538400 = new IllegalArgumentException("unknown object passed to Time");
            varEB3AD89893BE62E8E2C248F9BE2332CE_480538400.addTaint(taint);
            throw varEB3AD89893BE62E8E2C248F9BE2332CE_480538400;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.965 -0400", hash_original_method = "8BBEA010362F5295A61D1C019D01CC8B", hash_generated_method = "9D1EB4E2FF0778DE3B851DE145D48D43")
    public  Time(
        Date    date) {
        addTaint(date.getTaint());
        SimpleTimeZone tz = new SimpleTimeZone(0, "Z");
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss");
        dateF.setTimeZone(tz);
        String d = dateF.format(date) + "Z";
        int year = Integer.parseInt(d.substring(0, 4));
        if(year < 1950 || year > 2049)        
        {
            time = new DERGeneralizedTime(d);
        } //End block
        else
        {
            time = new DERUTCTime(d.substring(2));
        } //End block
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

    
    @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.967 -0400", hash_original_method = "BF57E645E9DF37568C2EEE61DCF61153", hash_generated_method = "BE0E9DE7FE4501F1C472D45939BCC3C8")
    public String getTime() {
        if(time instanceof DERUTCTime)        
        {
String var6737BDEA5D416D8B776FC3237CFB7AEE_680680575 =             ((DERUTCTime)time).getAdjustedTime();
            var6737BDEA5D416D8B776FC3237CFB7AEE_680680575.addTaint(taint);
            return var6737BDEA5D416D8B776FC3237CFB7AEE_680680575;
        } //End block
        else
        {
String varF54206F6C86C22C29E8157882DDD686C_1707747037 =             ((DERGeneralizedTime)time).getTime();
            varF54206F6C86C22C29E8157882DDD686C_1707747037.addTaint(taint);
            return varF54206F6C86C22C29E8157882DDD686C_1707747037;
        } //End block
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

    
        @DSModeled(DSC.SPEC)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.967 -0400", hash_original_method = "FDC0BE61EAA40B266A36758B51B3F270", hash_generated_method = "6CBE6C16C4F40BFEF29BDA3A6432F906")
    public Date getDate() {
        try 
        {
            if(time instanceof DERUTCTime)            
            {
Date var5C4DF896594C919BFBC3B94B005A0623_1987292244 =                 ((DERUTCTime)time).getAdjustedDate();
                var5C4DF896594C919BFBC3B94B005A0623_1987292244.addTaint(taint);
                return var5C4DF896594C919BFBC3B94B005A0623_1987292244;
            } //End block
            else
            {
Date var8D783C4AB38B34C5480A243364749A59_1285248308 =                 ((DERGeneralizedTime)time).getDate();
                var8D783C4AB38B34C5480A243364749A59_1285248308.addTaint(taint);
                return var8D783C4AB38B34C5480A243364749A59_1285248308;
            } //End block
        } //End block
        catch (ParseException e)
        {
            IllegalStateException var28109244B68609BB4DDBD618A711B019_1472596386 = new IllegalStateException("invalid date string: " + e.getMessage());
            var28109244B68609BB4DDBD618A711B019_1472596386.addTaint(taint);
            throw var28109244B68609BB4DDBD618A711B019_1472596386;
        } //End block
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.968 -0400", hash_original_method = "4A8C4B62F84A5603FDAAD94F25A110A4", hash_generated_method = "BC3FCCCD35FF47B0F49CA7EE8A918BF1")
    public DERObject toASN1Object() {
DERObject varA66D020F4BCAB26A12562312D8A04DED_712409709 =         time;
        varA66D020F4BCAB26A12562312D8A04DED_712409709.addTaint(taint);
        return varA66D020F4BCAB26A12562312D8A04DED_712409709;
        // ---------- Original Method ----------
        //return time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.968 -0400", hash_original_method = "B1D8E302C2A2168C967B1C035989FAE4", hash_generated_method = "BA1855A097A7E7C43EC34AD04DA41F8C")
    public String toString() {
String varA2437939C7847B22878509056EAFE1EF_1661126395 =         getTime();
        varA2437939C7847B22878509056EAFE1EF_1661126395.addTaint(taint);
        return varA2437939C7847B22878509056EAFE1EF_1661126395;
        // ---------- Original Method ----------
        //return getTime();
    }

    
}

