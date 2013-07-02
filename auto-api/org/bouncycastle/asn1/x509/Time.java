package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.040 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "9454FEFE155A6399796F93141389DE58")

    DERObject time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.040 -0400", hash_original_method = "01C20E280B683C170EEEF3EFC0766C68", hash_generated_method = "B8DF5CE0D9E5F0B53F6FE8C13AB222B6")
    public  Time(
        DERObject   time) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("unknown object passed to Time");
        } 
        this.time = time;
        
        
            
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.041 -0400", hash_original_method = "8BBEA010362F5295A61D1C019D01CC8B", hash_generated_method = "0CFD78EC33B84499DB6A83AE8104DDCC")
    public  Time(
        Date    date) {
        SimpleTimeZone tz = new SimpleTimeZone(0, "Z");
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss");
        dateF.setTimeZone(tz);
        String d = dateF.format(date) + "Z";
        int year = Integer.parseInt(d.substring(0, 4));
        {
            time = new DERGeneralizedTime(d);
        } 
        {
            time = new DERUTCTime(d.substring(2));
        } 
        addTaint(date.getTaint());
        
        
        
        
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static Time getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(obj.getObject());
    }

    
    @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.046 -0400", hash_original_method = "BF57E645E9DF37568C2EEE61DCF61153", hash_generated_method = "643C599DCA54BB3DD544C9830EB37DCC")
    public String getTime() {
        String varB4EAC82CA7396A68D541C85D26508E83_2098564799 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1964537186 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_2098564799 = ((DERUTCTime)time).getAdjustedTime();
        } 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1964537186 = ((DERGeneralizedTime)time).getTime();
        } 
        String varA7E53CE21691AB073D9660D615818899_1836661623; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1836661623 = varB4EAC82CA7396A68D541C85D26508E83_2098564799;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1836661623 = varB4EAC82CA7396A68D541C85D26508E83_1964537186;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1836661623.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1836661623;
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.049 -0400", hash_original_method = "FDC0BE61EAA40B266A36758B51B3F270", hash_generated_method = "A4754E4979D84FCE74C515567AF1C1C1")
    public Date getDate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1399825945 = null; 
        Date varB4EAC82CA7396A68D541C85D26508E83_1615011113 = null; 
        try 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1399825945 = ((DERUTCTime)time).getAdjustedDate();
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_1615011113 = ((DERGeneralizedTime)time).getDate();
            } 
        } 
        catch (ParseException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalStateException("invalid date string: " + e.getMessage());
        } 
        Date varA7E53CE21691AB073D9660D615818899_766168414; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_766168414 = varB4EAC82CA7396A68D541C85D26508E83_1399825945;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_766168414 = varB4EAC82CA7396A68D541C85D26508E83_1615011113;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_766168414.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_766168414;
        
        
        
            
            
                
            
            
            
                
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.050 -0400", hash_original_method = "4A8C4B62F84A5603FDAAD94F25A110A4", hash_generated_method = "BD0AD406E5A6466284837A738B0FAF4E")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1694385997 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1694385997 = time;
        varB4EAC82CA7396A68D541C85D26508E83_1694385997.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1694385997;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.051 -0400", hash_original_method = "B1D8E302C2A2168C967B1C035989FAE4", hash_generated_method = "3D844A6CB4784C553747899319B9BBA2")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1108874777 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1108874777 = getTime();
        varB4EAC82CA7396A68D541C85D26508E83_1108874777.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1108874777;
        
        
    }

    
}

