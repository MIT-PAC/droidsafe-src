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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.664 -0400", hash_original_field = "34BC11BD1D0CE270E57C98CEA00E8D5F", hash_generated_field = "76B8D8E0781BF84AACE2DA76A4001EFB")

    protected long timeStamp = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.664 -0400", hash_original_field = "0316FC507CBCBB3AD4149CBE7BD6690A", hash_generated_field = "DE842D8221161CACA08CA06721E2F557")

    protected int delay = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.664 -0400", hash_original_field = "50B1B1B2ABCE021919EBA7EE1A5A2E37", hash_generated_field = "C6AE286F90939B3ECC1A3783181F9CAA")

    protected float delayFloat = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.664 -0400", hash_original_field = "E436B60B7078C5CB4603A1005F41D95B", hash_generated_field = "496F7FE859855CC3A1459131085C2D33")

    private float timeStampFloat = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.673 -0400", hash_original_method = "02FBDC0E6C2AA0154E61A684C5364628", hash_generated_method = "178E8182DE940535EF9B1562E25AC807")
    public  TimeStamp() {
        super(TIMESTAMP);
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.678 -0400", hash_original_method = "A6A60BDDB9B869E20670F0D4B71173B1", hash_generated_method = "765D42AFFF08489D7D1DD6D00D160F54")
    private String getTimeStampAsString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1900224192 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1821039040 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1445979479 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1900224192 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1821039040 = Long.toString(timeStamp);
        varB4EAC82CA7396A68D541C85D26508E83_1445979479 = Float.toString(timeStampFloat);
        String varA7E53CE21691AB073D9660D615818899_1621057729; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1621057729 = varB4EAC82CA7396A68D541C85D26508E83_1900224192;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1621057729 = varB4EAC82CA7396A68D541C85D26508E83_1821039040;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1621057729 = varB4EAC82CA7396A68D541C85D26508E83_1445979479;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1621057729.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1621057729;
        // ---------- Original Method ----------
        //if (timeStamp == -1 && timeStampFloat == -1)
            //return "";
        //else if (timeStamp != -1)
            //return Long.toString(timeStamp);
        //else
            //return Float.toString(timeStampFloat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.678 -0400", hash_original_method = "BFD0E29F8DBDA29B6D5527F4C53FF1F0", hash_generated_method = "91BB63B31B0598403AF6B4352167EC4E")
    private String getDelayAsString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2004562534 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1924159028 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1163633602 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_2004562534 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1924159028 = Integer.toString(delay);
        varB4EAC82CA7396A68D541C85D26508E83_1163633602 = Float.toString(delayFloat);
        String varA7E53CE21691AB073D9660D615818899_169298517; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_169298517 = varB4EAC82CA7396A68D541C85D26508E83_2004562534;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_169298517 = varB4EAC82CA7396A68D541C85D26508E83_1924159028;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_169298517 = varB4EAC82CA7396A68D541C85D26508E83_1163633602;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_169298517.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_169298517;
        // ---------- Original Method ----------
        //if (delay == -1 && delayFloat == -1)
            //return "";
        //else if (delay != -1)
            //return Integer.toString(delay);
        //else
            //return Float.toString(delayFloat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.679 -0400", hash_original_method = "9C6948D2F9ACB5C855CB1B70AF4DF1F8", hash_generated_method = "19F752855CE58F2C86BD42CC2CDD8034")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_680304109 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_251728154 = null; //Variable for return #2
        StringBuffer retval;
        retval = new StringBuffer();
        String s1;
        s1 = getTimeStampAsString();
        String s2;
        s2 = getDelayAsString();
        {
            boolean var81C7EA9FAD10D7D3C274F0586EC42ECB_2057364111 = (s1.equals("") && s2.equals(""));
            varB4EAC82CA7396A68D541C85D26508E83_680304109 = "";
        } //End collapsed parenthetic
        {
            boolean var6A95086A562350B1D99FB5F81DE148DD_2079417549 = (!s1.equals(""));
            retval.append(s1);
        } //End collapsed parenthetic
        {
            boolean varCC6D2C1FA2BF7CECF1EF67337F074D00_1459235174 = (!s2.equals(""));
            retval.append(" ").append(s2);
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_251728154 = retval.toString();
        String varA7E53CE21691AB073D9660D615818899_264883741; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_264883741 = varB4EAC82CA7396A68D541C85D26508E83_680304109;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_264883741 = varB4EAC82CA7396A68D541C85D26508E83_251728154;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_264883741.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_264883741;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.679 -0400", hash_original_method = "085907F485A51FAD6B2086211DEE0B83", hash_generated_method = "6F7C098F076F4CC34FB472B37DDD221B")
    public boolean hasDelay() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1708077089 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1708077089;
        // ---------- Original Method ----------
        //return delay != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.689 -0400", hash_original_method = "EEC7FFF2C35A5C091F00D880A66433E4", hash_generated_method = "4957208ED2900548BE9C2858F9A52B7B")
    public void removeDelay() {
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.691 -0400", hash_original_method = "4E9675E31226E40B31535DE558B43882", hash_generated_method = "5658C8A3C71FE29B565BCA2BBA1E0DAB")
    public void setTimeStamp(float timeStamp) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                    "JAIN-SIP Exception, TimeStamp, "
                            + "setTimeStamp(), the timeStamp parameter is <0");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.691 -0400", hash_original_method = "01E7C97794DF2BDF54B9432179BAF6F0", hash_generated_method = "BC66EFE5C8F5AA8BB5788F6A839262AC")
    public float getTimeStamp() {
        {
            Object var518C0BE319A4F073F4271A6A9A965DE9_1213502001 = (Float.valueOf(timeStamp).floatValue());
        } //End flattened ternary
        float var546ADE640B6EDFBC8A086EF31347E768_963500675 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_963500675;
        // ---------- Original Method ----------
        //return this.timeStampFloat == -1 ? Float.valueOf(timeStamp).floatValue()
                //: this.timeStampFloat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.692 -0400", hash_original_method = "E76077CCC1CFE0A65C8B9469FD12F639", hash_generated_method = "FAB44EDD54B13D2E833D9B5B4092E0CF")
    public float getDelay() {
        {
            Object varCE7EBC85748B44202C795390FDACDDD1_1880874938 = (Float.valueOf(delay).floatValue());
        } //End flattened ternary
        float var546ADE640B6EDFBC8A086EF31347E768_1369160818 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1369160818;
        // ---------- Original Method ----------
        //return delayFloat == -1 ? Float.valueOf(delay).floatValue() : delayFloat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.692 -0400", hash_original_method = "614287DF965A55EC9CE805B49E8E8F7E", hash_generated_method = "C1FFB39E75ACF979624CB01C600DE508")
    public void setDelay(float delay) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                    "JAIN-SIP Exception, TimeStamp, "
                            + "setDelay(), the delay parameter is <0");
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.692 -0400", hash_original_method = "21D089BD1FDC44EC84A18CFADDD04289", hash_generated_method = "5EFA879049B30A0EF81036EA3F95E837")
    public long getTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1870950603 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1870950603;
        // ---------- Original Method ----------
        //return this.timeStamp == -1 ? (long) timeStampFloat : timeStamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.705 -0400", hash_original_method = "BF53496596C6E194CBAA97C816B19B22", hash_generated_method = "E5EFF533001D61D5061F9878101F383B")
    public int getTimeDelay() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_871896914 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_871896914;
        // ---------- Original Method ----------
        //return this.delay == -1 ? (int) delayFloat : delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.705 -0400", hash_original_method = "930714F3CC3A7BF7C1984F60EB3E864F", hash_generated_method = "624A8DEB49980A308CB5535894DCCBA9")
    public void setTime(long timeStamp) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Illegal timestamp");
        this.timeStamp = timeStamp;
        this.timeStampFloat = -1;
        // ---------- Original Method ----------
        //if (timeStamp < -1)
            //throw new InvalidArgumentException("Illegal timestamp");
        //this.timeStamp = timeStamp;
        //this.timeStampFloat = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.706 -0400", hash_original_method = "D3E64583B8501E5C3510C5471B1277F7", hash_generated_method = "CE70CE4659D2331754497CDDE492C6A8")
    public void setTimeDelay(int delay) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("Value out of range " + delay);
        this.delay = delay;
        this.delayFloat = -1;
        // ---------- Original Method ----------
        //if (delay < -1)
            //throw new InvalidArgumentException("Value out of range " + delay);
        //this.delay = delay;
        //this.delayFloat = -1;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.706 -0400", hash_original_field = "F1F76523D309971C49C86D95AD395F1F", hash_generated_field = "62CC8D9297F23AD0A0BF4EFE99B48159")

    private static long serialVersionUID = -3711322366481232720L;
}

