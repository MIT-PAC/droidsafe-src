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

public class DERUTCTime extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.770 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.771 -0400", hash_original_method = "1E3E40D5CDC8E036C03E11512D357967", hash_generated_method = "154BA191290811D68B5CB843424A9E52")
    public  DERUTCTime(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.771 -0400", hash_original_method = "889E462D85EE47A04EE3B8EBB5F8A587", hash_generated_method = "B19451CF21E769F4102167FB36DDE638")
    public  DERUTCTime(
        Date time) {
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmss'Z'");
        dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        this.time = dateF.format(time);
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.771 -0400", hash_original_method = "64E72DE8C26EBEE8B82B8D6629E000CC", hash_generated_method = "55219E373B6B1082BF6C76C1167A1581")
      DERUTCTime(
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
    public static DERUTCTime getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERUTCTime)
        {
            return (DERUTCTime)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    public static DERUTCTime getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.772 -0400", hash_original_method = "BA9EB44B4A66633868FF183B46999299", hash_generated_method = "A7CEAD42C3B36D6A02BBC84F04A6B645")
    public Date getDate() throws ParseException {
        Date varB4EAC82CA7396A68D541C85D26508E83_1075130096 = null; 
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmssz");
        varB4EAC82CA7396A68D541C85D26508E83_1075130096 = dateF.parse(getTime());
        varB4EAC82CA7396A68D541C85D26508E83_1075130096.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1075130096;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.772 -0400", hash_original_method = "B4832BCFF9515347D769B05CF978B8C2", hash_generated_method = "1A29C644A65817E2B92298F9CE19808C")
    public Date getAdjustedDate() throws ParseException {
        Date varB4EAC82CA7396A68D541C85D26508E83_719959723 = null; 
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        varB4EAC82CA7396A68D541C85D26508E83_719959723 = dateF.parse(getAdjustedTime());
        varB4EAC82CA7396A68D541C85D26508E83_719959723.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_719959723;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.774 -0400", hash_original_method = "01C2B859B7363E454246C04CBB075287", hash_generated_method = "D98E4FAC8FEEF89E79D34263C46874BD")
    public String getTime() {
        String varB4EAC82CA7396A68D541C85D26508E83_1844238782 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1712151983 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1319491207 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_837229670 = null; 
        {
            boolean varE84A38707D676F93B203A9F26B0234DD_531372442 = (time.indexOf('-') < 0 && time.indexOf('+') < 0);
            {
                {
                    boolean varF88B5C54DA5B797C7AD8FC18F3F53C62_524389170 = (time.length() == 11);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1844238782 = time.substring(0, 10) + "00GMT+00:00";
                    } 
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1712151983 = time.substring(0, 12) + "GMT+00:00";
                    } 
                } 
            } 
            {
                int index = time.indexOf('-');
                {
                    index = time.indexOf('+');
                } 
                String d = time;
                {
                    boolean var49F1ED3C0BA6C75FBE7105F6B3FB6B36_1161092472 = (index == time.length() - 3);
                    {
                        d += "00";
                    } 
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1319491207 = d.substring(0, 10) + "00GMT" + d.substring(10, 13) + ":" + d.substring(13, 15);
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_837229670 = d.substring(0, 12) + "GMT" + d.substring(12, 15) + ":" +  d.substring(15, 17);
                } 
            } 
        } 
        String varA7E53CE21691AB073D9660D615818899_382172749; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_382172749 = varB4EAC82CA7396A68D541C85D26508E83_1844238782;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_382172749 = varB4EAC82CA7396A68D541C85D26508E83_1712151983;
                break;
            case 3: 
                varA7E53CE21691AB073D9660D615818899_382172749 = varB4EAC82CA7396A68D541C85D26508E83_1319491207;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_382172749 = varB4EAC82CA7396A68D541C85D26508E83_837229670;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_382172749.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_382172749;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.775 -0400", hash_original_method = "F061A0CEFEFA91AF7DA40604EA772B20", hash_generated_method = "5D661FDB20A24BFA655FAD745D10C19F")
    public String getAdjustedTime() {
        String varB4EAC82CA7396A68D541C85D26508E83_430793906 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_716824550 = null; 
        String d = this.getTime();
        {
            boolean varA1C79C1143A1144BAE7CC1EC9A8AE587_1794553112 = (d.charAt(0) < '5');
            {
                varB4EAC82CA7396A68D541C85D26508E83_430793906 = "20" + d;
            } 
            {
                varB4EAC82CA7396A68D541C85D26508E83_716824550 = "19" + d;
            } 
        } 
        String varA7E53CE21691AB073D9660D615818899_760257967; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_760257967 = varB4EAC82CA7396A68D541C85D26508E83_430793906;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_760257967 = varB4EAC82CA7396A68D541C85D26508E83_716824550;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_760257967.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_760257967;
        
        
        
        
            
        
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.776 -0400", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "24A305DEAB8940F6C1D354E40CEFB4EE")
    private byte[] getOctets() {
        char[] cs = time.toCharArray();
        byte[] bs = new byte[cs.length];
        {
            int i = 0;
            {
                bs[i] = (byte)cs[i];
            } 
        } 
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1623300112 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1623300112;
        
        
        
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.776 -0400", hash_original_method = "61B114EE0877AC878307DF8632824910", hash_generated_method = "F875E20A5FA8E670702F7A8981211B19")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(UTC_TIME, this.getOctets());
        addTaint(out.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.776 -0400", hash_original_method = "0AA77B1E8A82CB516C576E10CBE19EDE", hash_generated_method = "B4D7FC42E6F258EE25D05AE759462E53")
     boolean asn1Equals(
        DERObject  o) {
        boolean varC56883A51314BEDB12E27663C377790A_227769079 = (time.equals(((DERUTCTime)o).time));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1382718876 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1382718876;
        
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.777 -0400", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "A87D912A48E29BB01977063C84E16689")
    public int hashCode() {
        int var421F48B0AF4B7D3E0A9730349FB03970_1546981320 = (time.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989110469 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1989110469;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:43.777 -0400", hash_original_method = "0230A74DF7F00CEFAD5D2184A68DC5A0", hash_generated_method = "272262DBD6ABB040891037D70FD71AF4")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_975428110 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_975428110 = time;
        varB4EAC82CA7396A68D541C85D26508E83_975428110.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_975428110;
        
        
    }

    
}

