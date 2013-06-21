package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.InvalidArgumentException;
import javax.sip.header.*;

public class TimeStamp extends SIPHeader implements TimeStampHeader {
    protected long timeStamp = -1;
    protected int delay = -1;
    protected float delayFloat = -1;
    private float timeStampFloat = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.434 -0400", hash_original_method = "02FBDC0E6C2AA0154E61A684C5364628", hash_generated_method = "178E8182DE940535EF9B1562E25AC807")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public TimeStamp() {
        super(TIMESTAMP);
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.434 -0400", hash_original_method = "A6A60BDDB9B869E20670F0D4B71173B1", hash_generated_method = "DDA7D2E69E058264AE5A36F42070B481")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getTimeStampAsString() {
        String varD8F9FE5B4BF3B932694D05B21E18A11F_1844283030 = (Long.toString(timeStamp));
        String var5873D16A79D5DD5E46013062A46D67C4_384455933 = (Float.toString(timeStampFloat));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (timeStamp == -1 && timeStampFloat == -1)
            //return "";
        //else if (timeStamp != -1)
            //return Long.toString(timeStamp);
        //else
            //return Float.toString(timeStampFloat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.434 -0400", hash_original_method = "BFD0E29F8DBDA29B6D5527F4C53FF1F0", hash_generated_method = "162DA02C3148E01DA5EF4BAB056690FA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String getDelayAsString() {
        String var3E8D0A36F62121A27571BEF487D1FA6F_1926354614 = (Integer.toString(delay));
        String varB8E25AE7697CF2E0639A79D35CE38765_1278039566 = (Float.toString(delayFloat));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (delay == -1 && delayFloat == -1)
            //return "";
        //else if (delay != -1)
            //return Integer.toString(delay);
        //else
            //return Float.toString(delayFloat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.434 -0400", hash_original_method = "9C6948D2F9ACB5C855CB1B70AF4DF1F8", hash_generated_method = "A3C31DC26ED22F8C21F8DDFC723396BA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        StringBuffer retval;
        retval = new StringBuffer();
        String s1;
        s1 = getTimeStampAsString();
        String s2;
        s2 = getDelayAsString();
        {
            boolean var81C7EA9FAD10D7D3C274F0586EC42ECB_1483768486 = (s1.equals("") && s2.equals(""));
        } //End collapsed parenthetic
        {
            boolean var6A95086A562350B1D99FB5F81DE148DD_1384030040 = (!s1.equals(""));
            retval.append(s1);
        } //End collapsed parenthetic
        {
            boolean varCC6D2C1FA2BF7CECF1EF67337F074D00_2039151061 = (!s2.equals(""));
            retval.append(" ").append(s2);
        } //End collapsed parenthetic
        String var0F1F65BA89BF920BA1A29FC87F91B969_1223758523 = (retval.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.435 -0400", hash_original_method = "085907F485A51FAD6B2086211DEE0B83", hash_generated_method = "3E15825A682C76748083D89A25258B9C")
    @DSModeled(DSC.SAFE)
    public boolean hasDelay() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return delay != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.435 -0400", hash_original_method = "EEC7FFF2C35A5C091F00D880A66433E4", hash_generated_method = "4957208ED2900548BE9C2858F9A52B7B")
    @DSModeled(DSC.SAFE)
    public void removeDelay() {
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.435 -0400", hash_original_method = "4E9675E31226E40B31535DE558B43882", hash_generated_method = "A3265F75EE85F49B3C2A33A1968737B2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeStamp(float timeStamp) throws InvalidArgumentException {
        dsTaint.addTaint(timeStamp);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                    "JAIN-SIP Exception, TimeStamp, "
                            + "setTimeStamp(), the timeStamp parameter is <0");
        this.timeStamp = -1;
        // ---------- Original Method ----------
        //if (timeStamp < 0)
            //throw new InvalidArgumentException(
                    //"JAIN-SIP Exception, TimeStamp, "
                            //+ "setTimeStamp(), the timeStamp parameter is <0");
        //this.timeStamp = -1;
        //this.timeStampFloat = timeStamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.436 -0400", hash_original_method = "01E7C97794DF2BDF54B9432179BAF6F0", hash_generated_method = "EFAB633DFB5CD98224C460653C1F878B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getTimeStamp() {
        {
            Object var518C0BE319A4F073F4271A6A9A965DE9_1995349363 = (Float.valueOf(timeStamp).floatValue());
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return this.timeStampFloat == -1 ? Float.valueOf(timeStamp).floatValue()
                //: this.timeStampFloat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.436 -0400", hash_original_method = "E76077CCC1CFE0A65C8B9469FD12F639", hash_generated_method = "9238B45C565D9D9EDFCA1330FFAF75E8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public float getDelay() {
        {
            Object varCE7EBC85748B44202C795390FDACDDD1_1794751862 = (Float.valueOf(delay).floatValue());
        } //End flattened ternary
        return dsTaint.getTaintFloat();
        // ---------- Original Method ----------
        //return delayFloat == -1 ? Float.valueOf(delay).floatValue() : delayFloat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.436 -0400", hash_original_method = "614287DF965A55EC9CE805B49E8E8F7E", hash_generated_method = "F3C2F9B1E1794630B58FBA8E47B9E797")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDelay(float delay) throws InvalidArgumentException {
        dsTaint.addTaint(delay);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                    "JAIN-SIP Exception, TimeStamp, "
                            + "setDelay(), the delay parameter is <0");
        this.delay = -1;
        // ---------- Original Method ----------
        //if (delay < 0 && delay != -1)
            //throw new InvalidArgumentException(
                    //"JAIN-SIP Exception, TimeStamp, "
                            //+ "setDelay(), the delay parameter is <0");
        //this.delayFloat = delay;
        //this.delay = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.436 -0400", hash_original_method = "21D089BD1FDC44EC84A18CFADDD04289", hash_generated_method = "67947E5D3A762A681EC097D6326D154A")
    @DSModeled(DSC.SAFE)
    public long getTime() {
        return dsTaint.getTaintLong();
        // ---------- Original Method ----------
        //return this.timeStamp == -1 ? (long) timeStampFloat : timeStamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.437 -0400", hash_original_method = "BF53496596C6E194CBAA97C816B19B22", hash_generated_method = "BBA1B2C0EC7026853410D074D03276CB")
    @DSModeled(DSC.SAFE)
    public int getTimeDelay() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return this.delay == -1 ? (int) delayFloat : delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.438 -0400", hash_original_method = "930714F3CC3A7BF7C1984F60EB3E864F", hash_generated_method = "7F4B39E136A0079C61739DD577895FA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTime(long timeStamp) throws InvalidArgumentException {
        dsTaint.addTaint(timeStamp);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Illegal timestamp");
        this.timeStampFloat = -1;
        // ---------- Original Method ----------
        //if (timeStamp < -1)
            //throw new InvalidArgumentException("Illegal timestamp");
        //this.timeStamp = timeStamp;
        //this.timeStampFloat = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.438 -0400", hash_original_method = "D3E64583B8501E5C3510C5471B1277F7", hash_generated_method = "72647872B653162B8F2F1C99D1962A36")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTimeDelay(int delay) throws InvalidArgumentException {
        dsTaint.addTaint(delay);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Value out of range " + delay);
        this.delayFloat = -1;
        // ---------- Original Method ----------
        //if (delay < -1)
            //throw new InvalidArgumentException("Value out of range " + delay);
        //this.delay = delay;
        //this.delayFloat = -1;
    }

    
    private static final long serialVersionUID = -3711322366481232720L;
}

