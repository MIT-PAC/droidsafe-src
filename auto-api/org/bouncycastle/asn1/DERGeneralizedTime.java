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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.159 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.161 -0400", hash_original_method = "5EF6ACB57D96EC76628792297A2B7108", hash_generated_method = "AD716B2CAC2AA5DEE63B8C6432497005")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.162 -0400", hash_original_method = "5D85DC02B66532E4C85C7A2666266463", hash_generated_method = "42DEA420065DB8656872B25BBFA0556D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.162 -0400", hash_original_method = "552D223548319DB52C5B3EC786733650", hash_generated_method = "F19D3F9B986414E970D4A88E29656C55")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.171 -0400", hash_original_method = "FFD2475F957538109629A734D2087930", hash_generated_method = "8842CDDFCD1E621AFD68AE5807A13D4E")
    public String getTimeString() {
        String varB4EAC82CA7396A68D541C85D26508E83_740370337 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_740370337 = time;
        varB4EAC82CA7396A68D541C85D26508E83_740370337.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_740370337;
        // ---------- Original Method ----------
        //return time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.173 -0400", hash_original_method = "C3D7FF56BCEB461182F81161FEBABFED", hash_generated_method = "47656C1E7B866B6657A2FF428616D3E2")
    public String getTime() {
        String varB4EAC82CA7396A68D541C85D26508E83_102292047 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1589036676 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_205286217 = null; //Variable for return #3
        String varB4EAC82CA7396A68D541C85D26508E83_438050597 = null; //Variable for return #4
        {
            boolean varF52DCA66EC9A70E5BBF37B55AD0F6C25_1939038038 = (time.charAt(time.length() - 1) == 'Z');
            {
                varB4EAC82CA7396A68D541C85D26508E83_102292047 = time.substring(0, time.length() - 1) + "GMT+00:00";
            } //End block
            {
                int signPos;
                signPos = time.length() - 5;
                char sign;
                sign = time.charAt(signPos);
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1589036676 = time.substring(0, signPos)
                    + "GMT"
                    + time.substring(signPos, signPos + 3)
                    + ":"
                    + time.substring(signPos + 3);
                } //End block
                {
                    signPos = time.length() - 3;
                    sign = time.charAt(signPos);
                    {
                        varB4EAC82CA7396A68D541C85D26508E83_205286217 = time.substring(0, signPos)
                        + "GMT"
                        + time.substring(signPos)
                        + ":00";
                    } //End block
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_438050597 = time + calculateGMTOffset();
        String varA7E53CE21691AB073D9660D615818899_2053411151; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2053411151 = varB4EAC82CA7396A68D541C85D26508E83_102292047;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_2053411151 = varB4EAC82CA7396A68D541C85D26508E83_1589036676;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_2053411151 = varB4EAC82CA7396A68D541C85D26508E83_205286217;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2053411151 = varB4EAC82CA7396A68D541C85D26508E83_438050597;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2053411151.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2053411151;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.184 -0400", hash_original_method = "EB1651DAB0D660D6B18E01CA950AD828", hash_generated_method = "8B7662BADE7B8516F70E47F612CFF65C")
    private String calculateGMTOffset() {
        String varB4EAC82CA7396A68D541C85D26508E83_680282565 = null; //Variable for return #1
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
                boolean var77529A9A1043049C5A3D1B11A0DC8BA8_1438310561 = (timeZone.useDaylightTime() && timeZone.inDaylightTime(this.getDate()));
                {
                    hours += sign.equals("+") ? 1 : -1;
                } //End block
            } //End collapsed parenthetic
        } //End block
        catch (ParseException e)
        { }
        varB4EAC82CA7396A68D541C85D26508E83_680282565 = "GMT" + sign + convert(hours) + ":" + convert(minutes);
        varB4EAC82CA7396A68D541C85D26508E83_680282565.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_680282565;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.198 -0400", hash_original_method = "17817B80FDAA9A144B025AECDD509966", hash_generated_method = "07862747F902BBF44271B93FF56567E8")
    private String convert(int time) {
        String varB4EAC82CA7396A68D541C85D26508E83_1925542620 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2100894710 = null; //Variable for return #2
        {
            varB4EAC82CA7396A68D541C85D26508E83_1925542620 = "0" + time;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2100894710 = Integer.toString(time);
        addTaint(time);
        String varA7E53CE21691AB073D9660D615818899_117679510; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_117679510 = varB4EAC82CA7396A68D541C85D26508E83_1925542620;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_117679510 = varB4EAC82CA7396A68D541C85D26508E83_2100894710;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_117679510.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_117679510;
        // ---------- Original Method ----------
        //if (time < 10)
        //{
            //return "0" + time;
        //}
        //return Integer.toString(time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.211 -0400", hash_original_method = "6889666E48E5F8883310FD63C4807DBB", hash_generated_method = "40DDA6866FA72BA372A5C53C8ADA8ADE")
    public Date getDate() throws ParseException {
        Date varB4EAC82CA7396A68D541C85D26508E83_1525383098 = null; //Variable for return #1
        SimpleDateFormat dateF;
        String d;
        d = time;
        {
            boolean varAE29D816B8464E3E8182931D78B3CEA9_1218196154 = (time.endsWith("Z"));
            {
                {
                    boolean var116B589F133958A3D5275359248C7247_1974058837 = (hasFractionalSeconds());
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
                boolean varB80B27A09D745CC3E36E5B699E07305D_1517107285 = (time.indexOf('-') > 0 || time.indexOf('+') > 0);
                {
                    d = this.getTime();
                    {
                        boolean varA90A695176A58A795899560E0D2B2EE6_2000409341 = (hasFractionalSeconds());
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
                        boolean varA90A695176A58A795899560E0D2B2EE6_1775742624 = (hasFractionalSeconds());
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
            boolean var739024BC88112299B6F2901A4F93B66C_2060517252 = (hasFractionalSeconds());
            {
                String frac;
                frac = d.substring(14);
                int index;
                {
                    index = 1;
                    boolean var35B580B03D47B175EE1AD1755A90F69B_1876489650 = (index < frac.length());
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
        varB4EAC82CA7396A68D541C85D26508E83_1525383098 = dateF.parse(d);
        varB4EAC82CA7396A68D541C85D26508E83_1525383098.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1525383098;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.213 -0400", hash_original_method = "5EC472F8945A730F12ABB53C050C6A0C", hash_generated_method = "83D8D85F01F0E1D1BC8C0B84E1CB93E2")
    private boolean hasFractionalSeconds() {
        boolean varEF707AD6F16C52ABB26DAD133AE9FD46_1742883715 = (time.indexOf('.') == 14);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_824471172 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_824471172;
        // ---------- Original Method ----------
        //return time.indexOf('.') == 14;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.271 -0400", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "C27C221B2FBD4B9DCBB4EB741840824B")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_496965026 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_496965026;
        // ---------- Original Method ----------
        //char[]  cs = time.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.272 -0400", hash_original_method = "C3570560B057E7DF0510746F3C613D12", hash_generated_method = "9BC2135EEC94493B6EAA6D3ABA3B2679")
     void encode(
        DEROutputStream  out) throws IOException {
        out.writeEncoded(GENERALIZED_TIME, this.getOctets());
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        //out.writeEncoded(GENERALIZED_TIME, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.272 -0400", hash_original_method = "F335EAF093E47550844C4E3B7BAA9B7A", hash_generated_method = "4EE8EA9A1B05509C7D05318F6C23EFBA")
     boolean asn1Equals(
        DERObject  o) {
        boolean var6D6470CEADA77F858A5433B4E8EADFAB_1653678445 = (time.equals(((DERGeneralizedTime)o).time));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_205654345 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_205654345;
        // ---------- Original Method ----------
        //if (!(o instanceof DERGeneralizedTime))
        //{
            //return false;
        //}
        //return time.equals(((DERGeneralizedTime)o).time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.274 -0400", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "4ACB27C81A15A64C85C17362C393962D")
    public int hashCode() {
        int var421F48B0AF4B7D3E0A9730349FB03970_162101640 = (time.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818431640 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1818431640;
        // ---------- Original Method ----------
        //return time.hashCode();
    }

    
}

