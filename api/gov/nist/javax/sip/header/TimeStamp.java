package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;

public class TimeStamp extends SIPHeader implements TimeStampHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.593 -0400", hash_original_field = "34BC11BD1D0CE270E57C98CEA00E8D5F", hash_generated_field = "76B8D8E0781BF84AACE2DA76A4001EFB")

    protected long timeStamp = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.594 -0400", hash_original_field = "0316FC507CBCBB3AD4149CBE7BD6690A", hash_generated_field = "DE842D8221161CACA08CA06721E2F557")

    protected int delay = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.594 -0400", hash_original_field = "50B1B1B2ABCE021919EBA7EE1A5A2E37", hash_generated_field = "C6AE286F90939B3ECC1A3783181F9CAA")

    protected float delayFloat = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.594 -0400", hash_original_field = "E436B60B7078C5CB4603A1005F41D95B", hash_generated_field = "496F7FE859855CC3A1459131085C2D33")

    private float timeStampFloat = -1;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.594 -0400", hash_original_method = "02FBDC0E6C2AA0154E61A684C5364628", hash_generated_method = "178E8182DE940535EF9B1562E25AC807")
    public  TimeStamp() {
        super(TIMESTAMP);
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.595 -0400", hash_original_method = "A6A60BDDB9B869E20670F0D4B71173B1", hash_generated_method = "CFCB346FD14771E35EA1305C9DF3133E")
    private String getTimeStampAsString() {
        if(timeStamp == -1 && timeStampFloat == -1)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1723356211 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1723356211.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1723356211;
        }
        else
        if(timeStamp != -1)        
        {
String var26CB82EC9A04D975CA5F59CA7FFD2F85_1408601205 =         Long.toString(timeStamp);
        var26CB82EC9A04D975CA5F59CA7FFD2F85_1408601205.addTaint(taint);
        return var26CB82EC9A04D975CA5F59CA7FFD2F85_1408601205;
        }
        else
        {
String var7989E3F135E688AB6BA1B117FE333CA6_1613933718 =         Float.toString(timeStampFloat);
        var7989E3F135E688AB6BA1B117FE333CA6_1613933718.addTaint(taint);
        return var7989E3F135E688AB6BA1B117FE333CA6_1613933718;
        }
        // ---------- Original Method ----------
        //if (timeStamp == -1 && timeStampFloat == -1)
            //return "";
        //else if (timeStamp != -1)
            //return Long.toString(timeStamp);
        //else
            //return Float.toString(timeStampFloat);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.596 -0400", hash_original_method = "BFD0E29F8DBDA29B6D5527F4C53FF1F0", hash_generated_method = "8046B6D9D62D833792C9BC273E5A9A48")
    private String getDelayAsString() {
        if(delay == -1 && delayFloat == -1)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1579277879 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1579277879.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1579277879;
        }
        else
        if(delay != -1)        
        {
String var7CC92AADBA289299CA649446AE38826B_2068471485 =         Integer.toString(delay);
        var7CC92AADBA289299CA649446AE38826B_2068471485.addTaint(taint);
        return var7CC92AADBA289299CA649446AE38826B_2068471485;
        }
        else
        {
String varD42ABEA32CCCF01A1859876730865E96_2044720069 =         Float.toString(delayFloat);
        varD42ABEA32CCCF01A1859876730865E96_2044720069.addTaint(taint);
        return varD42ABEA32CCCF01A1859876730865E96_2044720069;
        }
        // ---------- Original Method ----------
        //if (delay == -1 && delayFloat == -1)
            //return "";
        //else if (delay != -1)
            //return Integer.toString(delay);
        //else
            //return Float.toString(delayFloat);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.597 -0400", hash_original_method = "9C6948D2F9ACB5C855CB1B70AF4DF1F8", hash_generated_method = "952BDE43E1245259A42115FA33592995")
    public String encodeBody() {
        StringBuffer retval = new StringBuffer();
        String s1 = getTimeStampAsString();
        String s2 = getDelayAsString();
        if(s1.equals("") && s2.equals(""))        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1498247877 =         "";
        var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1498247877.addTaint(taint);
        return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1498247877;
        }
        if(!s1.equals(""))        
        retval.append(s1);
        if(!s2.equals(""))        
        retval.append(" ").append(s2);
String var1B324365A764C077A55854483509F4AB_1076902443 =         retval.toString();
        var1B324365A764C077A55854483509F4AB_1076902443.addTaint(taint);
        return var1B324365A764C077A55854483509F4AB_1076902443;
        // ---------- Original Method ----------
        //StringBuffer retval = new StringBuffer();
        //String s1 = getTimeStampAsString();
        //String s2 = getDelayAsString();
        //if (s1.equals("") && s2.equals(""))
            //return "";
        //if (!s1.equals(""))
            //retval.append(s1);
        //if (!s2.equals(""))
            //retval.append(" ").append(s2);
        //return retval.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.597 -0400", hash_original_method = "085907F485A51FAD6B2086211DEE0B83", hash_generated_method = "7DEC71C1194282982A4CF6760DA5ACA2")
    public boolean hasDelay() {
        boolean var5170D6C26EF26E11B67739BB10040110_2084078269 = (delay != -1);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1040281118 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1040281118;
        // ---------- Original Method ----------
        //return delay != -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.598 -0400", hash_original_method = "EEC7FFF2C35A5C091F00D880A66433E4", hash_generated_method = "4957208ED2900548BE9C2858F9A52B7B")
    public void removeDelay() {
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.598 -0400", hash_original_method = "4E9675E31226E40B31535DE558B43882", hash_generated_method = "D77E9680B02D62CE1C32545847355D15")
    public void setTimeStamp(float timeStamp) throws InvalidArgumentException {
        if(timeStamp < 0)        
        {
        InvalidArgumentException varEE33A8B1F1CA3E8C6B1416BFAEFC6E08_1966017523 = new InvalidArgumentException(
                    "JAIN-SIP Exception, TimeStamp, "
                            + "setTimeStamp(), the timeStamp parameter is <0");
        varEE33A8B1F1CA3E8C6B1416BFAEFC6E08_1966017523.addTaint(taint);
        throw varEE33A8B1F1CA3E8C6B1416BFAEFC6E08_1966017523;
        }
        this.timeStamp = -1;
        this.timeStampFloat = timeStamp;
        // ---------- Original Method ----------
        //if (timeStamp < 0)
            //throw new InvalidArgumentException(
                    //"JAIN-SIP Exception, TimeStamp, "
                            //+ "setTimeStamp(), the timeStamp parameter is <0");
        //this.timeStamp = -1;
        //this.timeStampFloat = timeStamp;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.599 -0400", hash_original_method = "01E7C97794DF2BDF54B9432179BAF6F0", hash_generated_method = "4A637C17ACA7F162732D19D6BF68B552")
    public float getTimeStamp() {
        float varA1D55C2097A168DE135F7BC9CC5E7C55_70056567 = (this.timeStampFloat == -1 ? Float.valueOf(timeStamp).floatValue()
                : this.timeStampFloat);
                float var546ADE640B6EDFBC8A086EF31347E768_1308723064 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1308723064;
        // ---------- Original Method ----------
        //return this.timeStampFloat == -1 ? Float.valueOf(timeStamp).floatValue()
                //: this.timeStampFloat;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.600 -0400", hash_original_method = "E76077CCC1CFE0A65C8B9469FD12F639", hash_generated_method = "0C0C89F78DF41AEF97FB27F906867A7E")
    public float getDelay() {
        float varF8E7D13292243AEE217733300B912A7F_1518060287 = (delayFloat == -1 ? Float.valueOf(delay).floatValue() : delayFloat);
                float var546ADE640B6EDFBC8A086EF31347E768_144408847 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_144408847;
        // ---------- Original Method ----------
        //return delayFloat == -1 ? Float.valueOf(delay).floatValue() : delayFloat;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.601 -0400", hash_original_method = "614287DF965A55EC9CE805B49E8E8F7E", hash_generated_method = "B5BFD09ECE8C3007F710687ACBF1A60D")
    public void setDelay(float delay) throws InvalidArgumentException {
        if(delay < 0 && delay != -1)        
        {
        InvalidArgumentException var2F71C1947B7063DEE9ED3A8FA5FF661D_2137756993 = new InvalidArgumentException(
                    "JAIN-SIP Exception, TimeStamp, "
                            + "setDelay(), the delay parameter is <0");
        var2F71C1947B7063DEE9ED3A8FA5FF661D_2137756993.addTaint(taint);
        throw var2F71C1947B7063DEE9ED3A8FA5FF661D_2137756993;
        }
        this.delayFloat = delay;
        this.delay = -1;
        // ---------- Original Method ----------
        //if (delay < 0 && delay != -1)
            //throw new InvalidArgumentException(
                    //"JAIN-SIP Exception, TimeStamp, "
                            //+ "setDelay(), the delay parameter is <0");
        //this.delayFloat = delay;
        //this.delay = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.602 -0400", hash_original_method = "21D089BD1FDC44EC84A18CFADDD04289", hash_generated_method = "3B52C5E7D1AECF0175BD213332172D9B")
    public long getTime() {
        long var53282C9BBBF7B78DB63E8EBD606128BC_1339225895 = (this.timeStamp == -1 ? (long) timeStampFloat : timeStamp);
                long var0F5264038205EDFB1AC05FBB0E8C5E94_1157088650 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1157088650;
        // ---------- Original Method ----------
        //return this.timeStamp == -1 ? (long) timeStampFloat : timeStamp;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.602 -0400", hash_original_method = "BF53496596C6E194CBAA97C816B19B22", hash_generated_method = "A9D81C70883F07829C9241C03894846A")
    public int getTimeDelay() {
        int varA586C7CA5165EB205CF69A2F0D1397B0_1286368610 = (this.delay == -1 ? (int) delayFloat : delay);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2854646 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2854646;
        // ---------- Original Method ----------
        //return this.delay == -1 ? (int) delayFloat : delay;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.603 -0400", hash_original_method = "930714F3CC3A7BF7C1984F60EB3E864F", hash_generated_method = "1B338279444BB2CF1C26B67FFD6A8DCF")
    public void setTime(long timeStamp) throws InvalidArgumentException {
        if(timeStamp < -1)        
        {
        InvalidArgumentException varC44C945D430D7EDCAD861D89CC79B6AE_577878443 = new InvalidArgumentException("Illegal timestamp");
        varC44C945D430D7EDCAD861D89CC79B6AE_577878443.addTaint(taint);
        throw varC44C945D430D7EDCAD861D89CC79B6AE_577878443;
        }
        this.timeStamp = timeStamp;
        this.timeStampFloat = -1;
        // ---------- Original Method ----------
        //if (timeStamp < -1)
            //throw new InvalidArgumentException("Illegal timestamp");
        //this.timeStamp = timeStamp;
        //this.timeStampFloat = -1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.605 -0400", hash_original_method = "D3E64583B8501E5C3510C5471B1277F7", hash_generated_method = "F4623E9A428853C5342C37A2E25FD96A")
    public void setTimeDelay(int delay) throws InvalidArgumentException {
        if(delay < -1)        
        {
        InvalidArgumentException var5080785A38295082BBA52E6C0CBD0C15_582895575 = new InvalidArgumentException("Value out of range " + delay);
        var5080785A38295082BBA52E6C0CBD0C15_582895575.addTaint(taint);
        throw var5080785A38295082BBA52E6C0CBD0C15_582895575;
        }
        this.delay = delay;
        this.delayFloat = -1;
        // ---------- Original Method ----------
        //if (delay < -1)
            //throw new InvalidArgumentException("Value out of range " + delay);
        //this.delay = delay;
        //this.delayFloat = -1;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.605 -0400", hash_original_field = "F1F76523D309971C49C86D95AD395F1F", hash_generated_field = "5580840BB5EA0CAD9750B3DAADA2FC56")

    private static final long serialVersionUID = -3711322366481232720L;
}

