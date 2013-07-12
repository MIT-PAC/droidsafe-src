package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class DERGeneralizedTime extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.053 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.054 -0400", hash_original_method = "5EF6ACB57D96EC76628792297A2B7108", hash_generated_method = "9152F1511F077CEAC279C9C615C599BF")
    public  DERGeneralizedTime(
        String  time) {
        this.time = time;
        try 
        {
            this.getDate();
        } //End block
        catch (ParseException e)
        {
            IllegalArgumentException var1CFFC49FF7908DF4E838225C96EC0E1A_1004173602 = new IllegalArgumentException("invalid date string: " + e.getMessage());
            var1CFFC49FF7908DF4E838225C96EC0E1A_1004173602.addTaint(taint);
            throw var1CFFC49FF7908DF4E838225C96EC0E1A_1004173602;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.054 -0400", hash_original_method = "5D85DC02B66532E4C85C7A2666266463", hash_generated_method = "5D4888C3595C69940C82F4750021F758")
    public  DERGeneralizedTime(
        Date time) {
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        this.time = dateF.format(time);
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
        //dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        //this.time = dateF.format(time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.055 -0400", hash_original_method = "552D223548319DB52C5B3EC786733650", hash_generated_method = "56D6BB29CF435A66E80BD5304E438519")
      DERGeneralizedTime(
        byte[]  bytes) {
        addTaint(bytes[0]);
        char[] dateC = new char[bytes.length];
for(int i = 0;i != dateC.length;i++)
        {
            dateC[i] = (char)(bytes[i] & 0xff);
        } //End block
        this.time = new String(dateC);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.056 -0400", hash_original_method = "FFD2475F957538109629A734D2087930", hash_generated_method = "A9A15B3E42A5A3F815E6D106C3D288C3")
    public String getTimeString() {
String varA66D020F4BCAB26A12562312D8A04DED_125222305 =         time;
        varA66D020F4BCAB26A12562312D8A04DED_125222305.addTaint(taint);
        return varA66D020F4BCAB26A12562312D8A04DED_125222305;
        // ---------- Original Method ----------
        //return time;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.056 -0400", hash_original_method = "C3D7FF56BCEB461182F81161FEBABFED", hash_generated_method = "D63A6707E4168B2961A09788AF9D2C37")
    public String getTime() {
    if(time.charAt(time.length() - 1) == 'Z')        
        {
String varC6BCCFB76527D51C7DBD6D13D81074C3_1113401105 =             time.substring(0, time.length() - 1) + "GMT+00:00";
            varC6BCCFB76527D51C7DBD6D13D81074C3_1113401105.addTaint(taint);
            return varC6BCCFB76527D51C7DBD6D13D81074C3_1113401105;
        } //End block
        else
        {
            int signPos = time.length() - 5;
            char sign = time.charAt(signPos);
    if(sign == '-' || sign == '+')            
            {
String var3D22A5EB1007801001C40A4BAE54B28C_1779177264 =                 time.substring(0, signPos)
                    + "GMT"
                    + time.substring(signPos, signPos + 3)
                    + ":"
                    + time.substring(signPos + 3);
                var3D22A5EB1007801001C40A4BAE54B28C_1779177264.addTaint(taint);
                return var3D22A5EB1007801001C40A4BAE54B28C_1779177264;
            } //End block
            else
            {
                signPos = time.length() - 3;
                sign = time.charAt(signPos);
    if(sign == '-' || sign == '+')                
                {
String var285F4ED6044387CBC8F35180E07CA9A7_1658840386 =                     time.substring(0, signPos)
                        + "GMT"
                        + time.substring(signPos)
                        + ":00";
                    var285F4ED6044387CBC8F35180E07CA9A7_1658840386.addTaint(taint);
                    return var285F4ED6044387CBC8F35180E07CA9A7_1658840386;
                } //End block
            } //End block
        } //End block
String var764FB26AB938608CFF815DA1893107ED_807641062 =         time + calculateGMTOffset();
        var764FB26AB938608CFF815DA1893107ED_807641062.addTaint(taint);
        return var764FB26AB938608CFF815DA1893107ED_807641062;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.057 -0400", hash_original_method = "EB1651DAB0D660D6B18E01CA950AD828", hash_generated_method = "1D868B4605597FA299191C40839B9650")
    private String calculateGMTOffset() {
        String sign = "+";
        TimeZone timeZone = TimeZone.getDefault();
        int offset = timeZone.getRawOffset();
    if(offset < 0)        
        {
            sign = "-";
            offset = -offset;
        } //End block
        int hours = offset / (60 * 60 * 1000);
        int minutes = (offset - (hours * 60 * 60 * 1000)) / (60 * 1000);
        try 
        {
    if(timeZone.useDaylightTime() && timeZone.inDaylightTime(this.getDate()))            
            {
                hours += sign.equals("+") ? 1 : -1;
            } //End block
        } //End block
        catch (ParseException e)
        {
        } //End block
String var2C086C598863E0349F310FCA1BDEDBDA_1859223284 =         "GMT" + sign + convert(hours) + ":" + convert(minutes);
        var2C086C598863E0349F310FCA1BDEDBDA_1859223284.addTaint(taint);
        return var2C086C598863E0349F310FCA1BDEDBDA_1859223284;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.058 -0400", hash_original_method = "17817B80FDAA9A144B025AECDD509966", hash_generated_method = "B7217059E2DF6F4E1BF53DE590A796EC")
    private String convert(int time) {
        addTaint(time);
    if(time < 10)        
        {
String var7345ECA479F2762411480436225A22CB_42119343 =             "0" + time;
            var7345ECA479F2762411480436225A22CB_42119343.addTaint(taint);
            return var7345ECA479F2762411480436225A22CB_42119343;
        } //End block
String var6A3BBCB0E6B7481E73D549A5BA968D95_271381250 =         Integer.toString(time);
        var6A3BBCB0E6B7481E73D549A5BA968D95_271381250.addTaint(taint);
        return var6A3BBCB0E6B7481E73D549A5BA968D95_271381250;
        // ---------- Original Method ----------
        //if (time < 10)
        //{
            //return "0" + time;
        //}
        //return Integer.toString(time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.060 -0400", hash_original_method = "6889666E48E5F8883310FD63C4807DBB", hash_generated_method = "A8701054F41D19B01AFC9767AE376BD5")
    public Date getDate() throws ParseException {
        SimpleDateFormat dateF;
        String d = time;
    if(time.endsWith("Z"))        
        {
    if(hasFractionalSeconds())            
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            } //End block
            else
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss'Z'");
            } //End block
            dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        } //End block
        else
    if(time.indexOf('-') > 0 || time.indexOf('+') > 0)        
        {
            d = this.getTime();
    if(hasFractionalSeconds())            
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSSz");
            } //End block
            else
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
            } //End block
            dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        } //End block
        else
        {
    if(hasFractionalSeconds())            
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss.SSS");
            } //End block
            else
            {
                dateF = new SimpleDateFormat("yyyyMMddHHmmss");
            } //End block
            dateF.setTimeZone(new SimpleTimeZone(0, TimeZone.getDefault().getID()));
        } //End block
    if(hasFractionalSeconds())        
        {
            String frac = d.substring(14);
            int index;
for(index = 1;index < frac.length();index++)
            {
                char ch = frac.charAt(index);
    if(!('0' <= ch && ch <= '9'))                
                {
                    break;
                } //End block
            } //End block
    if(index - 1 > 3)            
            {
                frac = frac.substring(0, 4) + frac.substring(index);
                d = d.substring(0, 14) + frac;
            } //End block
            else
    if(index - 1 == 1)            
            {
                frac = frac.substring(0, index) + "00" + frac.substring(index);
                d = d.substring(0, 14) + frac;
            } //End block
            else
    if(index - 1 == 2)            
            {
                frac = frac.substring(0, index) + "0" + frac.substring(index);
                d = d.substring(0, 14) + frac;
            } //End block
        } //End block
Date varC894E815AA82318FD33F469B86EDD99E_622946845 =         dateF.parse(d);
        varC894E815AA82318FD33F469B86EDD99E_622946845.addTaint(taint);
        return varC894E815AA82318FD33F469B86EDD99E_622946845;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.061 -0400", hash_original_method = "5EC472F8945A730F12ABB53C050C6A0C", hash_generated_method = "3E1EFB27703929005E28E09A51360FD2")
    private boolean hasFractionalSeconds() {
        boolean varD5D5351CBD88B9A84FD689FA6E5C6AF1_577916158 = (time.indexOf('.') == 14);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_636692903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_636692903;
        // ---------- Original Method ----------
        //return time.indexOf('.') == 14;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.062 -0400", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "7F43D4FC6DB8FC0A79AF79FFF4DFAA0B")
    private byte[] getOctets() {
        char[] cs = time.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte)cs[i];
        } //End block
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_1164365856 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1329905642 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1329905642;
        // ---------- Original Method ----------
        //char[]  cs = time.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.062 -0400", hash_original_method = "C3570560B057E7DF0510746F3C613D12", hash_generated_method = "B878DA8C8BC44E3A1D1BA2729D4B2E92")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(GENERALIZED_TIME, this.getOctets());
        // ---------- Original Method ----------
        //out.writeEncoded(GENERALIZED_TIME, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.063 -0400", hash_original_method = "F335EAF093E47550844C4E3B7BAA9B7A", hash_generated_method = "06D5EC870900C587FE501734C990828E")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERGeneralizedTime))        
        {
            boolean var68934A3E9455FA72420237EB05902327_986663603 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1446308647 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1446308647;
        } //End block
        boolean var30C675A1B918B9BBC4EE808A642E5232_716557265 = (time.equals(((DERGeneralizedTime)o).time));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_152137361 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_152137361;
        // ---------- Original Method ----------
        //if (!(o instanceof DERGeneralizedTime))
        //{
            //return false;
        //}
        //return time.equals(((DERGeneralizedTime)o).time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.063 -0400", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "F1837EEBA99339944D6785EE9CE9D017")
    public int hashCode() {
        int varCE1F3110113ADDA600B9294B4A8B4BC4_927026413 = (time.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1185212119 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1185212119;
        // ---------- Original Method ----------
        //return time.hashCode();
    }

    
}

