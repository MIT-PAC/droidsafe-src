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

public class DERUTCTime extends ASN1Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.231 -0400", hash_original_field = "07CC694B9B3FC636710FA08B6922C42B", hash_generated_field = "206625922693B80AD0E1ADE6B9CDD982")

    String time;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.231 -0400", hash_original_method = "1E3E40D5CDC8E036C03E11512D357967", hash_generated_method = "03B4BD9A0819EA892B23246A82CBF9E7")
    public  DERUTCTime(
        String  time) {
        this.time = time;
        try 
        {
            this.getDate();
        } //End block
        catch (ParseException e)
        {
            IllegalArgumentException var1CFFC49FF7908DF4E838225C96EC0E1A_1683895062 = new IllegalArgumentException("invalid date string: " + e.getMessage());
            var1CFFC49FF7908DF4E838225C96EC0E1A_1683895062.addTaint(taint);
            throw var1CFFC49FF7908DF4E838225C96EC0E1A_1683895062;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.232 -0400", hash_original_method = "889E462D85EE47A04EE3B8EBB5F8A587", hash_generated_method = "B19451CF21E769F4102167FB36DDE638")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.232 -0400", hash_original_method = "64E72DE8C26EBEE8B82B8D6629E000CC", hash_generated_method = "363763BB25808D15D47F93A918110CF7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.233 -0400", hash_original_method = "BA9EB44B4A66633868FF183B46999299", hash_generated_method = "058BC2AB3AFD842DA9DF71BF1EF37C8A")
    public Date getDate() throws ParseException {
        SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmssz");
Date var9869773FC2095A9C1BA07B0C752D5651_1002217606 =         dateF.parse(getTime());
        var9869773FC2095A9C1BA07B0C752D5651_1002217606.addTaint(taint);
        return var9869773FC2095A9C1BA07B0C752D5651_1002217606;
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyMMddHHmmssz");
        //return dateF.parse(getTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.234 -0400", hash_original_method = "B4832BCFF9515347D769B05CF978B8C2", hash_generated_method = "7EDE9B92F828BC6E1DE9CF654208A6FA")
    public Date getAdjustedDate() throws ParseException {
        SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
        dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
Date var3C50E339E97B3792A42581E9E5DF5253_983318412 =         dateF.parse(getAdjustedTime());
        var3C50E339E97B3792A42581E9E5DF5253_983318412.addTaint(taint);
        return var3C50E339E97B3792A42581E9E5DF5253_983318412;
        // ---------- Original Method ----------
        //SimpleDateFormat dateF = new SimpleDateFormat("yyyyMMddHHmmssz");
        //dateF.setTimeZone(new SimpleTimeZone(0, "Z"));
        //return dateF.parse(getAdjustedTime());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.244 -0400", hash_original_method = "01C2B859B7363E454246C04CBB075287", hash_generated_method = "39EC754B1F41CE2301308520981D6564")
    public String getTime() {
    if(time.indexOf('-') < 0 && time.indexOf('+') < 0)        
        {
    if(time.length() == 11)            
            {
String var8B14FD01E8FEF4E8CEEA076EDA1FC17D_339811464 =                 time.substring(0, 10) + "00GMT+00:00";
                var8B14FD01E8FEF4E8CEEA076EDA1FC17D_339811464.addTaint(taint);
                return var8B14FD01E8FEF4E8CEEA076EDA1FC17D_339811464;
            } //End block
            else
            {
String var73714280A2AB9CC323BB9396B15BEA9E_2049722062 =                 time.substring(0, 12) + "GMT+00:00";
                var73714280A2AB9CC323BB9396B15BEA9E_2049722062.addTaint(taint);
                return var73714280A2AB9CC323BB9396B15BEA9E_2049722062;
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
String var0891F9607C6951B4E77FFC09CF424608_1264975577 =                 d.substring(0, 10) + "00GMT" + d.substring(10, 13) + ":" + d.substring(13, 15);
                var0891F9607C6951B4E77FFC09CF424608_1264975577.addTaint(taint);
                return var0891F9607C6951B4E77FFC09CF424608_1264975577;
            } //End block
            else
            {
String var519C08293EE0B442111F7C58479E6A8C_350871226 =                 d.substring(0, 12) + "GMT" + d.substring(12, 15) + ":" +  d.substring(15, 17);
                var519C08293EE0B442111F7C58479E6A8C_350871226.addTaint(taint);
                return var519C08293EE0B442111F7C58479E6A8C_350871226;
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.244 -0400", hash_original_method = "F061A0CEFEFA91AF7DA40604EA772B20", hash_generated_method = "801DCAB1425571D3D072E15336D3E0E4")
    public String getAdjustedTime() {
        String d = this.getTime();
    if(d.charAt(0) < '5')        
        {
String var6DC08B51B98FB69DCD28EB23BB7DC76A_460297860 =             "20" + d;
            var6DC08B51B98FB69DCD28EB23BB7DC76A_460297860.addTaint(taint);
            return var6DC08B51B98FB69DCD28EB23BB7DC76A_460297860;
        } //End block
        else
        {
String varD4EDA08CA536CF631A011C40783D0E59_1022413893 =             "19" + d;
            varD4EDA08CA536CF631A011C40783D0E59_1022413893.addTaint(taint);
            return varD4EDA08CA536CF631A011C40783D0E59_1022413893;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.245 -0400", hash_original_method = "8BA225FFF1B0D4854B6BEDB73124ABD2", hash_generated_method = "5687472133D7BE90FEBE6DCD4EC28413")
    private byte[] getOctets() {
        char[] cs = time.toCharArray();
        byte[] bs = new byte[cs.length];
for(int i = 0;i != cs.length;i++)
        {
            bs[i] = (byte)cs[i];
        } //End block
        byte[] var7C9DF801238ABE28CAE2675FD3166A1A_411267884 = (bs);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1838959788 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1838959788;
        // ---------- Original Method ----------
        //char[]  cs = time.toCharArray();
        //byte[]  bs = new byte[cs.length];
        //for (int i = 0; i != cs.length; i++)
        //{
            //bs[i] = (byte)cs[i];
        //}
        //return bs;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.245 -0400", hash_original_method = "61B114EE0877AC878307DF8632824910", hash_generated_method = "0118C7A8D6413B02D0AB6B5CFBD2358B")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
        out.writeEncoded(UTC_TIME, this.getOctets());
        // ---------- Original Method ----------
        //out.writeEncoded(UTC_TIME, this.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.246 -0400", hash_original_method = "0AA77B1E8A82CB516C576E10CBE19EDE", hash_generated_method = "2928E8CF62DEBEB486931839AF68B5F6")
     boolean asn1Equals(
        DERObject  o) {
        addTaint(o.getTaint());
    if(!(o instanceof DERUTCTime))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1849689694 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344676767 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344676767;
        } //End block
        boolean var274E69F51AADAE51ACC4073E30E341D5_1031069469 = (time.equals(((DERUTCTime)o).time));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1306974258 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1306974258;
        // ---------- Original Method ----------
        //if (!(o instanceof DERUTCTime))
        //{
            //return false;
        //}
        //return time.equals(((DERUTCTime)o).time);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.246 -0400", hash_original_method = "12943BCCC2961451B97E26F622F40AB3", hash_generated_method = "96AFAFDBF9C09F8376F2AD9F17A6693F")
    public int hashCode() {
        int varCE1F3110113ADDA600B9294B4A8B4BC4_924555338 = (time.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989234927 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_989234927;
        // ---------- Original Method ----------
        //return time.hashCode();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.246 -0400", hash_original_method = "0230A74DF7F00CEFAD5D2184A68DC5A0", hash_generated_method = "E1E3C078E479BEEA96DE4EFA4486521D")
    public String toString() {
String varA66D020F4BCAB26A12562312D8A04DED_1470693643 =         time;
        varA66D020F4BCAB26A12562312D8A04DED_1470693643.addTaint(taint);
        return varA66D020F4BCAB26A12562312D8A04DED_1470693643;
        // ---------- Original Method ----------
        //return time;
    }

    
}

