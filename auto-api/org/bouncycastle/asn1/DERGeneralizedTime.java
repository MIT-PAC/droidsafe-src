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
import java.util.TimeZone;

public class DERGeneralizedTime extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.298 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.299 -0400", hash_original_method = "5EF6ACB57D96EC76628792297A2B7108", hash_generated_method = "AD716B2CAC2AA5DEE63B8C6432497005")
    public  DERGeneralizedTime(
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.302 -0400", hash_original_method = "5D85DC02B66532E4C85C7A2666266463", hash_generated_method = "42DEA420065DB8656872B25BBFA0556D")
    public  DERGeneralizedTime(
        Date time) {
        SimpleDateFormat dateF;
        dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        this.time = dateF.format(time);
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        //dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        //this.time = dateF.format(time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.302 -0400", hash_original_method = "552D223548319DB52C5B3EC786733650", hash_generated_method = "F19D3F9B986414E970D4A88E29656C55")
      DERGeneralizedTime(
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

    
        public static DERGeneralizedTime getInstance(
        Object  obj) {
        if (obj == null || obj instanceof DERGeneralizedTime)
        {
            return (DERGeneralizedTime)obj;
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.309 -0400", hash_original_method = "FFD2475F957538109629A734D2087930", hash_generated_method = "09288F55D2060821B5A570E1B2A22112")
    public String getTimeString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1228688361 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1228688361 = time;
        varB4EAC82CA7396A68D541C85D26508E83_1228688361.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1228688361;
        // ---------- Original Method ----------
        //return time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.328 -0400", hash_original_method = "C3D7FF56BCEB461182F81161FEBABFED", hash_generated_method = "6E4FB842C7CFF54F9913D96FEDDE0E79")
    public String getTime() {
        String varB4EAC82CA7396A68D541C85D26508E83_1830249278 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_357768813 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_719469346 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_1835357349 = null; //Variable for return #4
        {
            boolean varF52DCA66EC9A70E5BBF37B55AD0F6C25_1337055567 = (time.charAt(time.length() - 1) == 'Z');
            {
                varB4EAC82CA7396A68D541C85D26508E83_1830249278 = time.substring(0, time.length() - 1) + "GMT+00:00";
            } //End block
            {
                int signPos;
                signPos = time.length() - 5;
                char sign;
                sign = time.charAt(signPos);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_357768813 = time.substring(0, signPos)
                    + "GMT"
                    + time.substring(signPos, signPos + 3)
                    + ":"
                    + time.substring(signPos + 3);
                } //End block
                {
                    signPos = time.length() - 3;
                    sign = time.charAt(signPos);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_719469346 = time.substring(0, signPos)
                        + "GMT"
                        + time.substring(signPos)
                        + ":00";
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1835357349 = time + calculateGMTOffset();
        String varA7E53CE21691AB073D9660D615818899_1418050217; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1418050217 = varB4EAC82CA7396A68D541C85D26508E83_1830249278;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1418050217 = varB4EAC82CA7396A68D541C85D26508E83_357768813;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1418050217 = varB4EAC82CA7396A68D541C85D26508E83_719469346;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1418050217 = varB4EAC82CA7396A68D541C85D26508E83_1835357349;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1418050217.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1418050217;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.330 -0400", hash_original_method = "EB1651DAB0D660D6B18E01CA950AD828", hash_generated_method = "E07158F9CBE1F2913251B975AD64BC8E")
    private String calculateGMTOffset() {
        String varB4EAC82CA7396A68D541C85D26508E83_466282075 = null; //Variable for return #1
        String sign;
        sign = "+";
        TimeZone timeZone;
        timeZone = TimeZone.getDefault();
        int offset;
        offset = timeZone.getRawOffset();
        {
            sign = "-";
            offset = -offset;
        } //End block
        int hours;
        hours = offset / (60 * 60 * 1000);
        int minutes;
        minutes = (offset - (hours * 60 * 60 * 1000)) / (60 * 1000);
        try 
        {
            {
                boolean var77529A9A1043049C5A3D1B11A0DC8BA8_1751951763 = (timeZone.useDaylightTime() && timeZone.inDaylightTime(this.getDate()));
                {
                    hours += sign.equals("+") ? 1 : -1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ParseException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_466282075 = "GMT" + sign + convert(hours) + ":" + convert(minutes);
        varB4EAC82CA7396A68D541C85D26508E83_466282075.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_466282075;
        // ---------- Original Method ----------
        //String sign = "+";
        //TimeZone timeZone = TimeZone.getDefault();
        //int offset = timeZone.getRawOffset();
        //if (offset < 0)
        //{
            //sign = "-";
            //offset = -offset;
        //}
        //int hours = offset / (60 * 60 * 1000);
        //int minutes = (offset - (hours * 60 * 60 * 1000)) / (60 * 1000);
        //try
        //{
            //if (timeZone.useDaylightTime() && timeZone.inDaylightTime(this.getDate()))
            //{
                //hours += sign.equals("+") ? 1 : -1;
            //}
        //}
        //catch (ParseException e)
        //{
        //}
        //return "GMT" + sign + convert(hours) + ":" + convert(minutes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.331 -0400", hash_original_method = "17817B80FDAA9A144B025AECDD509966", hash_generated_method = "328A0BDF4FCA7B2BF11A332B86D86534")
    private String convert(int time) {
        String varB4EAC82CA7396A68D541C85D26508E83_1045100729 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_816906279 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1045100729 = "0" + time;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_816906279 = Integer.toString(time);
        addTaint(time);
        String varA7E53CE21691AB073D9660D615818899_1783974937; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1783974937 = varB4EAC82CA7396A68D541C85D26508E83_1045100729;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1783974937 = varB4EAC82CA7396A68D541C85D26508E83_816906279;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1783974937.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1783974937;
        // ---------- Original Method ----------
        //if (time < 10)
        //{
            //return "0" + time;
        //}
        //return Integer.toString(time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.347 -0400", hash_original_method = "6889666E48E5F8883310FD63C4807DBB", hash_generated_method = "7352085E6E53D7A5C46EBD34615E3356")
    public Date getDate() throws ParseException {
        Date varB4EAC82CA7396A68D541C85D26508E83_1123258249 = null; //Variable for return #1
        SimpleDateFormat dateF;
        String d;
        d = time;
        {
            boolean varAE29D816B8464E3E8182931D78B3CEA9_1074564831 = (time.endsWith("Z"));
            {
                {
                    boolean var116B589F133958A3D5275359248C7247_716461970 = (hasFractionalSeconds());
                    {
                        dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
                    } //End block
                    {
                        dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
                    } //End block
                } //End collapsed parenthetic
                dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
            } //End block
            {
                boolean varB80B27A09D745CC3E36E5B699E07305D_547493425 = (time.indexOf('-') > 0 || time.indexOf('+') > 0);
                {
                    d = this.getTime();
                    {
                        boolean varA90A695176A58A795899560E0D2B2EE6_1593659007 = (hasFractionalSeconds());
                        {
                            dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
                        } //End block
                        {
                            dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
                        } //End block
                    } //End collapsed parenthetic
                    dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
                } //End block
                {
                    {
                        boolean varA90A695176A58A795899560E0D2B2EE6_1906647847 = (hasFractionalSeconds());
                        {
                            dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
                        } //End block
                        {
                            dateF = new SimpleDateFormat("yyyyMMddHHmmss");
                        } //End block
                    } //End collapsed parenthetic
                    dateF.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
                } //End block
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        {
            boolean var739024BC88112299B6F2901A4F93B66C_1649130067 = (hasFractionalSeconds());
            {
                String frac;
                frac = d.substring(14);
                int index;
                {
                    index = 1;
                    boolean var35B580B03D47B175EE1AD1755A90F69B_860057829 = (index < frac.length());
                    {
                        char ch;
                        ch = frac.charAt(index);
                    } //End block
                } //End collapsed parenthetic
                {
                    frac = frac.substring(0, 4) + frac.substring(index);
                    d = d.substring(0, 14) + frac;
                } //End block
                {
                    frac = frac.substring(0, index) + "00" + frac.substring(index);
                    d = d.substring(0, 14) + frac;
                } //End block
                {
                    frac = frac.substring(0, index) + "0" + frac.substring(index);
                    d = d.substring(0, 14) + frac;
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1123258249 = dateF.parse(d);
        varB4EAC82CA7396A68D541C85D26508E83_1123258249.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1123258249;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.348 -0400", hash_original_method = "5EC472F8945A730F12ABB53C050C6A0C", hash_generated_method = "25407AA7DB12FC197F4A59F5E7677C48")
    private boolean hasFractionalSeconds() {
        boolean varEF707AD6F16C52ABB26DAD133AE9FD46_829152035 = (time.indexOf('.') == 14);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1284833245 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1284833245;
        // ---------- Original Method ----------
        //return time.indexOf('.') == 14;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.360 -0400", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "D7A00B3F7761E2AB68E13A0A8160AB66")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_395294868 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_395294868;
        // ---------- Original Method ----------
        //char[]  cs = time.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.362 -0400", hash_original_method = "C3570560B057E7DF0510746F3C613D12", hash_generated_method = "9BC2135EEC94493B6EAA6D3ABA3B2679")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(GENERALIZED_TIME, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(GENERALIZED_TIME, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.362 -0400", hash_original_method = "F335EAF093E47550844C4E3B7BAA9B7A", hash_generated_method = "7099195A6F78BCA9897275C686802AB4")
     boolean asn1Equals(
        DERObject  o) {
        boolean var6D6470CEADA77F858A5433B4E8EADFAB_1260272869 = (time.equals(((DERGeneralizedTime)o).time));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1878112204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1878112204;
        // ---------- Original Method ----------
        //if (!(o instanceof DERGeneralizedTime))
        //{
            //return false;
        //}
        //return time.equals(((DERGeneralizedTime)o).time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.362 -0400", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "F5CC0566642F2112DB2BC403F08EB11B")
    public int hashCode() {
        int var421F48B0AF4B7D3E0A9730349FB03970_1068183502 = (time.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443355778 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_443355778;
        // ---------- Original Method ----------
        //return time.hashCode();
    }

    
}

