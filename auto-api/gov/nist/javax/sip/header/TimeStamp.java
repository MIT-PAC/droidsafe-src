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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.843 -0400", hash_original_field = "34BC11BD1D0CE270E57C98CEA00E8D5F", hash_generated_field = "76B8D8E0781BF84AACE2DA76A4001EFB")

    protected long timeStamp = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.843 -0400", hash_original_field = "0316FC507CBCBB3AD4149CBE7BD6690A", hash_generated_field = "DE842D8221161CACA08CA06721E2F557")

    protected int delay = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.843 -0400", hash_original_field = "50B1B1B2ABCE021919EBA7EE1A5A2E37", hash_generated_field = "C6AE286F90939B3ECC1A3783181F9CAA")

    protected float delayFloat = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.843 -0400", hash_original_field = "E436B60B7078C5CB4603A1005F41D95B", hash_generated_field = "496F7FE859855CC3A1459131085C2D33")

    private float timeStampFloat = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.844 -0400", hash_original_method = "02FBDC0E6C2AA0154E61A684C5364628", hash_generated_method = "178E8182DE940535EF9B1562E25AC807")
    public  TimeStamp() {
        super(TIMESTAMP);
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.844 -0400", hash_original_method = "A6A60BDDB9B869E20670F0D4B71173B1", hash_generated_method = "27AF9CE972FCDD74E01354445DBC7344")
    private String getTimeStampAsString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1611026478 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1134615399 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_181605164 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1611026478 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1134615399 = Long.toString(timeStamp);
        varB4EAC82CA7396A68D541C85D26508E83_181605164 = Float.toString(timeStampFloat);
        String varA7E53CE21691AB073D9660D615818899_1217729370; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1217729370 = varB4EAC82CA7396A68D541C85D26508E83_1611026478;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1217729370 = varB4EAC82CA7396A68D541C85D26508E83_1134615399;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1217729370 = varB4EAC82CA7396A68D541C85D26508E83_181605164;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1217729370.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1217729370;
        // ---------- Original Method ----------
        //if (timeStamp == -1 && timeStampFloat == -1)
            //return "";
        //else if (timeStamp != -1)
            //return Long.toString(timeStamp);
        //else
            //return Float.toString(timeStampFloat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.867 -0400", hash_original_method = "BFD0E29F8DBDA29B6D5527F4C53FF1F0", hash_generated_method = "BC43B0F308C595FFBA63F9E1504EA24B")
    private String getDelayAsString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1629922375 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1308350824 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1124688275 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_1629922375 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1308350824 = Integer.toString(delay);
        varB4EAC82CA7396A68D541C85D26508E83_1124688275 = Float.toString(delayFloat);
        String varA7E53CE21691AB073D9660D615818899_1777516324; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1777516324 = varB4EAC82CA7396A68D541C85D26508E83_1629922375;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1777516324 = varB4EAC82CA7396A68D541C85D26508E83_1308350824;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1777516324 = varB4EAC82CA7396A68D541C85D26508E83_1124688275;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1777516324.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1777516324;
        // ---------- Original Method ----------
        //if (delay == -1 && delayFloat == -1)
            //return "";
        //else if (delay != -1)
            //return Integer.toString(delay);
        //else
            //return Float.toString(delayFloat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.869 -0400", hash_original_method = "9C6948D2F9ACB5C855CB1B70AF4DF1F8", hash_generated_method = "D0184B77E713D2D2EACDD05CB296F175")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_476541368 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1284126400 = null; //Variable for return #2
        StringBuffer retval;
        retval = new StringBuffer();
        String s1;
        s1 = getTimeStampAsString();
        String s2;
        s2 = getDelayAsString();
        {
            boolean var81C7EA9FAD10D7D3C274F0586EC42ECB_1330025299 = (s1.equals("") && s2.equals(""));
            varB4EAC82CA7396A68D541C85D26508E83_476541368 = "";
        } //End collapsed parenthetic
        {
            boolean var6A95086A562350B1D99FB5F81DE148DD_2118857 = (!s1.equals(""));
            retval.append(s1);
        } //End collapsed parenthetic
        {
            boolean varCC6D2C1FA2BF7CECF1EF67337F074D00_1943769420 = (!s2.equals(""));
            retval.append(" ").append(s2);
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1284126400 = retval.toString();
        String varA7E53CE21691AB073D9660D615818899_1446783213; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1446783213 = varB4EAC82CA7396A68D541C85D26508E83_476541368;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1446783213 = varB4EAC82CA7396A68D541C85D26508E83_1284126400;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1446783213.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1446783213;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.870 -0400", hash_original_method = "085907F485A51FAD6B2086211DEE0B83", hash_generated_method = "4953C6C6E0E06B6E7B78DAFFAE629298")
    public boolean hasDelay() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1144959662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1144959662;
        // ---------- Original Method ----------
        //return delay != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.872 -0400", hash_original_method = "EEC7FFF2C35A5C091F00D880A66433E4", hash_generated_method = "4957208ED2900548BE9C2858F9A52B7B")
    public void removeDelay() {
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.873 -0400", hash_original_method = "4E9675E31226E40B31535DE558B43882", hash_generated_method = "5658C8A3C71FE29B565BCA2BBA1E0DAB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.874 -0400", hash_original_method = "01E7C97794DF2BDF54B9432179BAF6F0", hash_generated_method = "0D46AC08D90A95D2389E269F09A1D0C0")
    public float getTimeStamp() {
        {
            Object var518C0BE319A4F073F4271A6A9A965DE9_1482448893 = (Float.valueOf(timeStamp).floatValue());
        } //End flattened ternary
        float var546ADE640B6EDFBC8A086EF31347E768_667846329 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_667846329;
        // ---------- Original Method ----------
        //return this.timeStampFloat == -1 ? Float.valueOf(timeStamp).floatValue()
                //: this.timeStampFloat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.891 -0400", hash_original_method = "E76077CCC1CFE0A65C8B9469FD12F639", hash_generated_method = "7DE8C8FEEA02BFD44F658EA20969BDF9")
    public float getDelay() {
        {
            Object varCE7EBC85748B44202C795390FDACDDD1_1391539966 = (Float.valueOf(delay).floatValue());
        } //End flattened ternary
        float var546ADE640B6EDFBC8A086EF31347E768_814760725 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_814760725;
        // ---------- Original Method ----------
        //return delayFloat == -1 ? Float.valueOf(delay).floatValue() : delayFloat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.900 -0400", hash_original_method = "614287DF965A55EC9CE805B49E8E8F7E", hash_generated_method = "C1FFB39E75ACF979624CB01C600DE508")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.900 -0400", hash_original_method = "21D089BD1FDC44EC84A18CFADDD04289", hash_generated_method = "19B9F484FFEA4EFC439C67C393E237D7")
    public long getTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_2028870573 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_2028870573;
        // ---------- Original Method ----------
        //return this.timeStamp == -1 ? (long) timeStampFloat : timeStamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.900 -0400", hash_original_method = "BF53496596C6E194CBAA97C816B19B22", hash_generated_method = "ABF03940811EC70F43F96799D154D8BB")
    public int getTimeDelay() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044623031 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2044623031;
        // ---------- Original Method ----------
        //return this.delay == -1 ? (int) delayFloat : delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.901 -0400", hash_original_method = "930714F3CC3A7BF7C1984F60EB3E864F", hash_generated_method = "624A8DEB49980A308CB5535894DCCBA9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.901 -0400", hash_original_method = "D3E64583B8501E5C3510C5471B1277F7", hash_generated_method = "CE70CE4659D2331754497CDDE492C6A8")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.901 -0400", hash_original_field = "F1F76523D309971C49C86D95AD395F1F", hash_generated_field = "62CC8D9297F23AD0A0BF4EFE99B48159")

    private static long serialVersionUID = -3711322366481232720L;
}

