package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class DERUTCTime extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.299 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.305 -0400", hash_original_method = "1E3E40D5CDC8E036C03E11512D357967", hash_generated_method = "154BA191290811D68B5CB843424A9E52")
    public  DERUTCTime(
        String  time) {
        this.time = time;
        try 
        {
            this.getDate();
        } //End block
        catch (ParseException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        } //End block
        // ---------- Original Method ----------
        //this.time = time;
        //try
        //{
            //this.getDate();
        //}
        //catch (ParseException e)
        //{
            //throw new IllegalArgumentException("invalid date string: " + e.getMessage());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.313 -0400", hash_original_method = "889E462D85EE47A04EE3B8EBB5F8A587", hash_generated_method = "8AEBE92E0A8CA702F4D803EE872683EF")
    public  DERUTCTime(
        Date time) {
        SimpleDateFormat dateF;
        dateF = new SimpleDateFormat("yyMMddHHmmss'Z'");
        dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        this.time = dateF.format(time);
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmss'Z'");
        //dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        //this.time = dateF.format(time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.313 -0400", hash_original_method = "64E72DE8C26EBEE8B82B8D6629E000CC", hash_generated_method = "369BF951B0E1E714EB0DFDAB59C53004")
      DERUTCTime(
        byte[]  bytes) {
        char[] dateC;
        dateC = new char[bytes.length];
        {
            int i;
            i = 0;
            {
                dateC[i] = (char)(bytes[i] & 0xff);
            } //End block
        } //End collapsed parenthetic
        this.time = new String(dateC);
        addTaint(bytes[0]);
        // ---------- Original Method ----------
        //char[]  dateC = new char[bytes.length];
        //for (int i = 0; i != dateC.length; i++)
        //{
            //dateC[i] = (char)(bytes[i] & 0xff);
        //}
        //this.time = new String(dateC);
    }

    
        public static DERUTCTime getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERUTCTime)
        {
            return (DERUTCTime)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.314 -0400", hash_original_method = "BA9EB44B4A66633868FF183B46999299", hash_generated_method = "64C01409824E3EBFC40F3A2ECB9449BF")
    public Date getDate() throws ParseException {
        Date varB4EAC82CA7396A68D541C85D26508E83_1797789004 = null; //Variable for return #1
        SimpleDateFormat dateF;
        dateF = new SimpleDateFormat("yyMMddHHmmssz");
        varB4EAC82CA7396A68D541C85D26508E83_1797789004 = dateF.parse(getTime());
        varB4EAC82CA7396A68D541C85D26508E83_1797789004.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1797789004;
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmssz");
        //return dateF.parse(getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.315 -0400", hash_original_method = "B4832BCFF9515347D769B05CF978B8C2", hash_generated_method = "1860ACF6B867A9F937A23529F14AFE90")
    public Date getAdjustedDate() throws ParseException {
        Date varB4EAC82CA7396A68D541C85D26508E83_1799653048 = null; //Variable for return #1
        SimpleDateFormat dateF;
        dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        varB4EAC82CA7396A68D541C85D26508E83_1799653048 = dateF.parse(getAdjustedTime());
        varB4EAC82CA7396A68D541C85D26508E83_1799653048.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1799653048;
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
        //dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        //return dateF.parse(getAdjustedTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.318 -0400", hash_original_method = "01C2B859B7363E454246C04CBB075287", hash_generated_method = "DD06C8867F4795E59FDD3BB03432294F")
    public String getTime() {
        String varB4EAC82CA7396A68D541C85D26508E83_1037485225 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_197754093 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_608431922 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1653592491 = null; //Variable for return #4
        {
            boolean varE84A38707D676F93B203A9F26B0234DD_1921216062 = (time.indexOf('-') < 0 && time.indexOf('+') < 0);
            {
                {
                    boolean varF88B5C54DA5B797C7AD8FC18F3F53C62_1218272812 = (time.length() == 11);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_1037485225 = time.substring(0, 10) + "00GMT+00:00";
                    } //End block
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_197754093 = time.substring(0, 12) + "GMT+00:00";
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                int index;
                index = time.indexOf('-');
                {
                    index = time.indexOf('+');
                } //End block
                String d;
                d = time;
                {
                    boolean var49F1ED3C0BA6C75FBE7105F6B3FB6B36_1893655683 = (index == time.length() - 3);
                    {
                        d += "00";
                    } //End block
                } //End collapsed parenthetic
                {
                    varB4EAC82CA7396A68D541C85D26508E83_608431922 = d.substring(0, 10) + "00GMT" + d.substring(10, 13) + ":" + d.substring(13, 15);
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1653592491 = d.substring(0, 12) + "GMT" + d.substring(12, 15) + ":" +  d.substring(15, 17);
                } //End block
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_911775299; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_911775299 = varB4EAC82CA7396A68D541C85D26508E83_1037485225;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_911775299 = varB4EAC82CA7396A68D541C85D26508E83_197754093;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_911775299 = varB4EAC82CA7396A68D541C85D26508E83_608431922;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_911775299 = varB4EAC82CA7396A68D541C85D26508E83_1653592491;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_911775299.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_911775299;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.337 -0400", hash_original_method = "F061A0CEFEFA91AF7DA40604EA772B20", hash_generated_method = "B281474343205F135537BCAB13187BDC")
    public String getAdjustedTime() {
        String varB4EAC82CA7396A68D541C85D26508E83_1140693219 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_428442220 = null; //Variable for return #2
        String d;
        d = this.getTime();
        {
            boolean varA1C79C1143A1144BAE7CC1EC9A8AE587_550603288 = (d.charAt(0) < '5');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1140693219 = "20" + d;
            } //End block
            {
                varB4EAC82CA7396A68D541C85D26508E83_428442220 = "19" + d;
            } //End block
        } //End collapsed parenthetic
        String varA7E53CE21691AB073D9660D615818899_94173982; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_94173982 = varB4EAC82CA7396A68D541C85D26508E83_1140693219;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_94173982 = varB4EAC82CA7396A68D541C85D26508E83_428442220;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_94173982.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_94173982;
        // ---------- Original Method ----------
        //String   d = this.getTime();
        //if (d.charAt(0) < '5')
        //{
            //return "20" + d;
        //}
        //else
        //{
            //return "19" + d;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.338 -0400", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "370455DC3D3B75E22D8CF27F9EE56AF5")
    private byte[] getOctets() {
        char[] cs;
        cs = time.toCharArray();
        byte[] bs;
        bs = new byte[cs.length];
        {
            int i;
            i = 0;
            {
                bs[i] = (byte)cs[i];
            } //End block
        } //End collapsed parenthetic
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_268745475 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_268745475;
        // ---------- Original Method ----------
        //char[]  cs = time.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.338 -0400", hash_original_method = "61B114EE0877AC878307DF8632824910", hash_generated_method = "F875E20A5FA8E670702F7A8981211B19")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(UTC_TIME, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(UTC_TIME, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.339 -0400", hash_original_method = "0AA77B1E8A82CB516C576E10CBE19EDE", hash_generated_method = "4D6D31B8FDA264D621A0718BF1E891C7")
     boolean asn1Equals(
        DERObject  o) {
        boolean varC56883A51314BEDB12E27663C377790A_232102065 = (time.equals(((DERUTCTime)o).time));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_138036302 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_138036302;
        // ---------- Original Method ----------
        //if (!(o instanceof DERUTCTime))
        //{
            //return false;
        //}
        //return time.equals(((DERUTCTime)o).time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.339 -0400", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "28E5AB517C635F6CC43957C23F6B1920")
    public int hashCode() {
        int var421F48B0AF4B7D3E0A9730349FB03970_1337859430 = (time.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047459595 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1047459595;
        // ---------- Original Method ----------
        //return time.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.340 -0400", hash_original_method = "0230A74DF7F00CEFAD5D2184A68DC5A0", hash_generated_method = "A1F0EF70FE65AA31F1C4DD3C440421F4")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1654526395 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1654526395 = time;
        varB4EAC82CA7396A68D541C85D26508E83_1654526395.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1654526395;
        // ---------- Original Method ----------
        //return time;
    }

    
}

