package org.bouncycastle.asn1;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DERGeneralizedTime extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.487 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.488 -0400", hash_original_method = "5EF6ACB57D96EC76628792297A2B7108", hash_generated_method = "AD716B2CAC2AA5DEE63B8C6432497005")
    public  DERGeneralizedTime(
        String  time) {
        this.time = time;
        try 
        {
            this.getDate();
        } 
        catch (ParseException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        } 
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.488 -0400", hash_original_method = "5D85DC02B66532E4C85C7A2666266463", hash_generated_method = "5D4888C3595C69940C82F4750021F758")
    public  DERGeneralizedTime(
        Date time) {
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        this.time = dateF.format(time);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.489 -0400", hash_original_method = "552D223548319DB52C5B3EC786733650", hash_generated_method = "0AC42D5460219923342028E6633B9B0B")
      DERGeneralizedTime(
        byte[]  bytes) {
        char[] dateC = new char[bytes.length];
        {
            int i = 0;
            {
                dateC[i] = (char)(bytes[i] & 0xff);
            } 
        } 
        this.time = new String(dateC);
        addTaint(bytes[0]);
        
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static DERGeneralizedTime getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERGeneralizedTime)
        {
            return (DERGeneralizedTime)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERGeneralizedTime getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.490 -0400", hash_original_method = "FFD2475F957538109629A734D2087930", hash_generated_method = "6C790844BE7A3F7F70DE42AB01392ACF")
    public String getTimeString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1550651086 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1550651086 = time;
        varB4EAC82CA7396A68D541C85D26508E83_1550651086.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1550651086;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.492 -0400", hash_original_method = "C3D7FF56BCEB461182F81161FEBABFED", hash_generated_method = "50EC570FA17CA7FA8669F447FFB7348E")
    public String getTime() {
        String varB4EAC82CA7396A68D541C85D26508E83_1444680249 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1338593777 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_460757136 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_608357229 = null; 
        {
            boolean varF52DCA66EC9A70E5BBF37B55AD0F6C25_1077236386 = (time.charAt(time.length() - 1) == 'Z');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1444680249 = time.substring(0, time.length() - 1) + "GMT+00:00";
            } 
            {
                int signPos = time.length() - 5;
                char sign = time.charAt(signPos);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1338593777 = time.substring(0, signPos)
                    + "GMT"
                    + time.substring(signPos, signPos + 3)
                    + ":"
                    + time.substring(signPos + 3);
                } 
                {
                    signPos = time.length() - 3;
                    sign = time.charAt(signPos);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_460757136 = time.substring(0, signPos)
                        + "GMT"
                        + time.substring(signPos)
                        + ":00";
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_608357229 = time + calculateGMTOffset();
        String varA7E53CE21691AB073D9660D615818899_563327535; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_563327535 = varB4EAC82CA7396A68D541C85D26508E83_1444680249;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_563327535 = varB4EAC82CA7396A68D541C85D26508E83_1338593777;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_563327535 = varB4EAC82CA7396A68D541C85D26508E83_460757136;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_563327535 = varB4EAC82CA7396A68D541C85D26508E83_608357229;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_563327535.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_563327535;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.493 -0400", hash_original_method = "EB1651DAB0D660D6B18E01CA950AD828", hash_generated_method = "061D7F9DA16BAA9CB929951B18E9E5A2")
    private String calculateGMTOffset() {
        String varB4EAC82CA7396A68D541C85D26508E83_479416904 = null; 
        String sign = "+";
        TimeZone timeZone = TimeZone.getDefault();
        int offset = timeZone.getRawOffset();
        {
            sign = "-";
            offset = -offset;
        } 
        int hours = offset / (60 * 60 * 1000);
        int minutes = (offset - (hours * 60 * 60 * 1000)) / (60 * 1000);
        try 
        {
            {
                boolean var77529A9A1043049C5A3D1B11A0DC8BA8_1549137313 = (timeZone.useDaylightTime() && timeZone.inDaylightTime(this.getDate()));
                {
                    hours += sign.equals("+") ? 1 : -1;
                } 
            } 
        } 
        catch (ParseException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_479416904 = "GMT" + sign + convert(hours) + ":" + convert(minutes);
        varB4EAC82CA7396A68D541C85D26508E83_479416904.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_479416904;
        
        
        
        
        
        
            
            
        
        
        
        
        
            
            
                
            
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.494 -0400", hash_original_method = "17817B80FDAA9A144B025AECDD509966", hash_generated_method = "4093FE361336EA27BDE85611609430CC")
    private String convert(int time) {
        String varB4EAC82CA7396A68D541C85D26508E83_448017013 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_615989393 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_448017013 = "0" + time;
        } 
        varB4EAC82CA7396A68D541C85D26508E83_615989393 = Integer.toString(time);
        addTaint(time);
        String varA7E53CE21691AB073D9660D615818899_1294496139; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1294496139 = varB4EAC82CA7396A68D541C85D26508E83_448017013;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1294496139 = varB4EAC82CA7396A68D541C85D26508E83_615989393;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1294496139.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1294496139;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.495 -0400", hash_original_method = "6889666E48E5F8883310FD63C4807DBB", hash_generated_method = "3024E3855C74F88DEC8EFD04E8414C09")
    public Date getDate() throws ParseException {
        Date varB4EAC82CA7396A68D541C85D26508E83_1671670431 = null; 
        SimpleDateFormat dateF;
        String d = time;
        {
            boolean varAE29D816B8464E3E8182931D78B3CEA9_1164436701 = (time.endsWith("Z"));
            {
                {
                    boolean var116B589F133958A3D5275359248C7247_1267349969 = (hasFractionalSeconds());
                    {
                        dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
                    } 
                    {
                        dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
                    } 
                } 
                dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
            } 
            {
                boolean varB80B27A09D745CC3E36E5B699E07305D_1255185589 = (time.indexOf('-') > 0 || time.indexOf('+') > 0);
                {
                    d = this.getTime();
                    {
                        boolean varA90A695176A58A795899560E0D2B2EE6_1262207674 = (hasFractionalSeconds());
                        {
                            dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
                        } 
                        {
                            dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
                        } 
                    } 
                    dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
                } 
                {
                    {
                        boolean varA90A695176A58A795899560E0D2B2EE6_180436636 = (hasFractionalSeconds());
                        {
                            dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
                        } 
                        {
                            dateF = new SimpleDateFormat("yyyyMMddHHmmss");
                        } 
                    } 
                    dateF.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
                } 
            } 
        } 
        {
            boolean var739024BC88112299B6F2901A4F93B66C_850756446 = (hasFractionalSeconds());
            {
                String frac = d.substring(14);
                int index;
                {
                    index = 1;
                    boolean var35B580B03D47B175EE1AD1755A90F69B_1650853872 = (index < frac.length());
                    {
                        char ch = frac.charAt(index);
                    } 
                } 
                {
                    frac = frac.substring(0, 4) + frac.substring(index);
                    d = d.substring(0, 14) + frac;
                } 
                {
                    frac = frac.substring(0, index) + "00" + frac.substring(index);
                    d = d.substring(0, 14) + frac;
                } 
                {
                    frac = frac.substring(0, index) + "0" + frac.substring(index);
                    d = d.substring(0, 14) + frac;
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1671670431 = dateF.parse(d);
        varB4EAC82CA7396A68D541C85D26508E83_1671670431.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1671670431;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.496 -0400", hash_original_method = "5EC472F8945A730F12ABB53C050C6A0C", hash_generated_method = "0C844E820FAA685F1E723E4205D736CD")
    private boolean hasFractionalSeconds() {
        boolean varEF707AD6F16C52ABB26DAD133AE9FD46_518513194 = (time.indexOf('.') == 14);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902546620 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902546620;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.496 -0400", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "8FC53ECC047BACF760506FDC3C2F2B5E")
    private byte[] getOctets() {
        char[] cs = time.toCharArray();
        byte[] bs = new byte[cs.length];
        {
            int i = 0;
            {
                bs[i] = (byte)cs[i];
            } 
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_147166218 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_147166218;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.496 -0400", hash_original_method = "C3570560B057E7DF0510746F3C613D12", hash_generated_method = "9BC2135EEC94493B6EAA6D3ABA3B2679")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(GENERALIZED_TIME, this.getOctets());
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.497 -0400", hash_original_method = "F335EAF093E47550844C4E3B7BAA9B7A", hash_generated_method = "627FBA4AB6116847327C989C97EA3C82")
     boolean asn1Equals(
        DERObject  o) {
        boolean var6D6470CEADA77F858A5433B4E8EADFAB_927569778 = (time.equals(((DERGeneralizedTime)o).time));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_553450251 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_553450251;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.497 -0400", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "ECBE351D1C66E01249BE201440184F74")
    public int hashCode() {
        int var421F48B0AF4B7D3E0A9730349FB03970_1615846034 = (time.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747928624 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_747928624;
        
        
    }

    
}

