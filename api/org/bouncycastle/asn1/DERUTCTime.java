package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;






public class DERUTCTime extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.622 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String time;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.622 -0400", hash_original_method = "1E3E40D5CDC8E036C03E11512D357967", hash_generated_method = "A0601868DA19978BC74D10E8C93D37A4")
    public  DERUTCTime(
        String  time) {
        this.time = time;
        try 
        {
            this.getDate();
        } //End block
        catch (ParseException e)
        {
            IllegalArgumentException var1CFFC49FF7908DF4E838225C96EC0E1A_1732332976 = new IllegalArgumentException("invalid date string: " + e.getMessage());
            var1CFFC49FF7908DF4E838225C96EC0E1A_1732332976.addTaint(taint);
            throw var1CFFC49FF7908DF4E838225C96EC0E1A_1732332976;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.623 -0400", hash_original_method = "889E462D85EE47A04EE3B8EBB5F8A587", hash_generated_method = "B19451CF21E769F4102167FB36DDE638")
    public  DERUTCTime(
        Date time) {
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmss'Z'");
        dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        this.time = dateF.format(time);
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmss'Z'");
        //dateF.setTimeZone(new SimpleTimeZone(0,"Z"));
        //this.time = dateF.format(time);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.623 -0400", hash_original_method = "64E72DE8C26EBEE8B82B8D6629E000CC", hash_generated_method = "363763BB25808D15D47F93A918110CF7")
      DERUTCTime(
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.624 -0400", hash_original_method = "BA9EB44B4A66633868FF183B46999299", hash_generated_method = "9194236F81DC9BD5961EF0052A6EEBE0")
    public Date getDate() throws ParseException {
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmssz");
Date var9869773FC2095A9C1BA07B0C752D5651_500316629 =         dateF.parse(getTime());
        var9869773FC2095A9C1BA07B0C752D5651_500316629.addTaint(taint);
        return var9869773FC2095A9C1BA07B0C752D5651_500316629;
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmssz");
        //return dateF.parse(getTime());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.625 -0400", hash_original_method = "B4832BCFF9515347D769B05CF978B8C2", hash_generated_method = "8F240DE912FE73F0A744E1EC1E9C424C")
    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
Date var3C50E339E97B3792A42581E9E5DF5253_1524666040 =         dateF.parse(getAdjustedTime());
        var3C50E339E97B3792A42581E9E5DF5253_1524666040.addTaint(taint);
        return var3C50E339E97B3792A42581E9E5DF5253_1524666040;
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
        //dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        //return dateF.parse(getAdjustedTime());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.625 -0400", hash_original_method = "01C2B859B7363E454246C04CBB075287", hash_generated_method = "481D6EA6ECB787F44E657987A120CC0E")
    public String getTime() {
        if(time.indexOf('-') < 0 && time.indexOf('+') < 0)        
        {
            if(time.length() == 11)            
            {
String var8B14FD01E8FEF4E8CEEA076EDA1FC17D_1346967444 =                 time.substring(0, 10) + "00GMT+00:00";
                var8B14FD01E8FEF4E8CEEA076EDA1FC17D_1346967444.addTaint(taint);
                return var8B14FD01E8FEF4E8CEEA076EDA1FC17D_1346967444;
            } //End block
            else
            {
String var73714280A2AB9CC323BB9396B15BEA9E_2119326680 =                 time.substring(0, 12) + "GMT+00:00";
                var73714280A2AB9CC323BB9396B15BEA9E_2119326680.addTaint(taint);
                return var73714280A2AB9CC323BB9396B15BEA9E_2119326680;
            } //End block
        } //End block
        else
        {
            int index = time.indexOf('-');
            if(index < 0)            
            {
                index = time.indexOf('+');
            } //End block
            String d = time;
            if(index == time.length() - 3)            
            {
                d += "00";
            } //End block
            if(index == 10)            
            {
String var0891F9607C6951B4E77FFC09CF424608_1024466887 =                 d.substring(0, 10) + "00GMT" + d.substring(10, 13) + ":" + d.substring(13, 15);
                var0891F9607C6951B4E77FFC09CF424608_1024466887.addTaint(taint);
                return var0891F9607C6951B4E77FFC09CF424608_1024466887;
            } //End block
            else
            {
String var519C08293EE0B442111F7C58479E6A8C_1478116474 =                 d.substring(0, 12) + "GMT" + d.substring(12, 15) + ":" +  d.substring(15, 17);
                var519C08293EE0B442111F7C58479E6A8C_1478116474.addTaint(taint);
                return var519C08293EE0B442111F7C58479E6A8C_1478116474;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.626 -0400", hash_original_method = "F061A0CEFEFA91AF7DA40604EA772B20", hash_generated_method = "762E40159534DD26D009F142DD8FBCC8")
    public String getAdjustedTime() {
        String d = this.getTime();
        if(d.charAt(0) < '5')        
        {
String var6DC08B51B98FB69DCD28EB23BB7DC76A_979630478 =             "20" + d;
            var6DC08B51B98FB69DCD28EB23BB7DC76A_979630478.addTaint(taint);
            return var6DC08B51B98FB69DCD28EB23BB7DC76A_979630478;
        } //End block
        else
        {
String varD4EDA08CA536CF631A011C40783D0E59_1326996696 =             "19" + d;
            varD4EDA08CA536CF631A011C40783D0E59_1326996696.addTaint(taint);
            return varD4EDA08CA536CF631A011C40783D0E59_1326996696;
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.628 -0400", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "33F19F4A3C0EB94A8C6D9AC44E566A66")
    private byte[] getOctets() {
        char[] cs = time.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte)cs[i];
        } //End block
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_2096781030 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_40294240 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_40294240;
        // ---------- Original Method ----------
        //char[]  cs = time.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.629 -0400", hash_original_method = "61B114EE0877AC878307DF8632824910", hash_generated_method = "0118C7A8D6413B02D0AB6B5CFBD2358B")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(UTC_TIME, this.getOctets());
        // ---------- Original Method ----------
        //out.writeEncoded(UTC_TIME, this.getOctets());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.630 -0400", hash_original_method = "0AA77B1E8A82CB516C576E10CBE19EDE", hash_generated_method = "3E25B7523E760E6E2304079616C40E9A")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
        if(!(o instanceof DERUTCTime))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1593071872 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_277775637 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_277775637;
        } //End block
        boolean var274E69F51AADAE51ACC4073E30E341D5_1342279356 = (time.equals(((DERUTCTime)o).time));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708059780 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708059780;
        // ---------- Original Method ----------
        //if (!(o instanceof DERUTCTime))
        //{
            //return false;
        //}
        //return time.equals(((DERUTCTime)o).time);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.630 -0400", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "12AD047F49D9C759C16688E2FDD7633C")
    public int hashCode() {
        int varCE1F3110113ADDA600B9294B4A8B4BC4_280244450 = (time.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150079090 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1150079090;
        // ---------- Original Method ----------
        //return time.hashCode();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.631 -0400", hash_original_method = "0230A74DF7F00CEFAD5D2184A68DC5A0", hash_generated_method = "E18988FFC2E17D3713034C4BDE5D950E")
    public String toString() {
String varA66D020F4BCAB26A12562312D8A04DED_1130147298 =         time;
        varA66D020F4BCAB26A12562312D8A04DED_1130147298.addTaint(taint);
        return varA66D020F4BCAB26A12562312D8A04DED_1130147298;
        // ---------- Original Method ----------
        //return time;
    }

    
}

