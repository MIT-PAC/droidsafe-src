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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.748 -0400", hash_original_field = "34BC11BD1D0CE270E57C98CEA00E8D5F", hash_generated_field = "76B8D8E0781BF84AACE2DA76A4001EFB")

    protected long timeStamp = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.748 -0400", hash_original_field = "0316FC507CBCBB3AD4149CBE7BD6690A", hash_generated_field = "DE842D8221161CACA08CA06721E2F557")

    protected int delay = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.748 -0400", hash_original_field = "50B1B1B2ABCE021919EBA7EE1A5A2E37", hash_generated_field = "C6AE286F90939B3ECC1A3783181F9CAA")

    protected float delayFloat = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.748 -0400", hash_original_field = "E436B60B7078C5CB4603A1005F41D95B", hash_generated_field = "496F7FE859855CC3A1459131085C2D33")

    private float timeStampFloat = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.749 -0400", hash_original_method = "02FBDC0E6C2AA0154E61A684C5364628", hash_generated_method = "178E8182DE940535EF9B1562E25AC807")
    public  TimeStamp() {
        super(TIMESTAMP);
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.749 -0400", hash_original_method = "A6A60BDDB9B869E20670F0D4B71173B1", hash_generated_method = "4D76381848A0E012FD5137A01EAA9F8E")
    private String getTimeStampAsString() {
        String varB4EAC82CA7396A68D541C85D26508E83_878073641 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1257488755 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1406345225 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_878073641 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1257488755 = Long.toString(timeStamp);
        varB4EAC82CA7396A68D541C85D26508E83_1406345225 = Float.toString(timeStampFloat);
        String varA7E53CE21691AB073D9660D615818899_374335956; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_374335956 = varB4EAC82CA7396A68D541C85D26508E83_878073641;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_374335956 = varB4EAC82CA7396A68D541C85D26508E83_1257488755;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_374335956 = varB4EAC82CA7396A68D541C85D26508E83_1406345225;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_374335956.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_374335956;
        // ---------- Original Method ----------
        //if (timeStamp == -1 && timeStampFloat == -1)
            //return "";
        //else if (timeStamp != -1)
            //return Long.toString(timeStamp);
        //else
            //return Float.toString(timeStampFloat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.750 -0400", hash_original_method = "BFD0E29F8DBDA29B6D5527F4C53FF1F0", hash_generated_method = "A192A096A5533A0A0A9FF6F18828180E")
    private String getDelayAsString() {
        String varB4EAC82CA7396A68D541C85D26508E83_339690547 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1345690171 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_795217874 = null; //Variable for return #3
        varB4EAC82CA7396A68D541C85D26508E83_339690547 = "";
        varB4EAC82CA7396A68D541C85D26508E83_1345690171 = Integer.toString(delay);
        varB4EAC82CA7396A68D541C85D26508E83_795217874 = Float.toString(delayFloat);
        String varA7E53CE21691AB073D9660D615818899_1540435992; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1540435992 = varB4EAC82CA7396A68D541C85D26508E83_339690547;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1540435992 = varB4EAC82CA7396A68D541C85D26508E83_1345690171;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1540435992 = varB4EAC82CA7396A68D541C85D26508E83_795217874;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1540435992.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1540435992;
        // ---------- Original Method ----------
        //if (delay == -1 && delayFloat == -1)
            //return "";
        //else if (delay != -1)
            //return Integer.toString(delay);
        //else
            //return Float.toString(delayFloat);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.751 -0400", hash_original_method = "9C6948D2F9ACB5C855CB1B70AF4DF1F8", hash_generated_method = "75513793D8BF73F8F803DB3702080C73")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_543690169 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1520847914 = null; //Variable for return #2
        StringBuffer retval = new StringBuffer();
        String s1 = getTimeStampAsString();
        String s2 = getDelayAsString();
        {
            boolean var81C7EA9FAD10D7D3C274F0586EC42ECB_608585582 = (s1.equals("") && s2.equals(""));
            varB4EAC82CA7396A68D541C85D26508E83_543690169 = "";
        } //End collapsed parenthetic
        {
            boolean var6A95086A562350B1D99FB5F81DE148DD_1190813104 = (!s1.equals(""));
            retval.append(s1);
        } //End collapsed parenthetic
        {
            boolean varCC6D2C1FA2BF7CECF1EF67337F074D00_2070905052 = (!s2.equals(""));
            retval.append(" ").append(s2);
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1520847914 = retval.toString();
        String varA7E53CE21691AB073D9660D615818899_1539253781; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1539253781 = varB4EAC82CA7396A68D541C85D26508E83_543690169;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1539253781 = varB4EAC82CA7396A68D541C85D26508E83_1520847914;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1539253781.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1539253781;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.751 -0400", hash_original_method = "085907F485A51FAD6B2086211DEE0B83", hash_generated_method = "EE5F7CB8F37AF713887DD10AAC7C1A6C")
    public boolean hasDelay() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_345334830 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_345334830;
        // ---------- Original Method ----------
        //return delay != -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.752 -0400", hash_original_method = "EEC7FFF2C35A5C091F00D880A66433E4", hash_generated_method = "4957208ED2900548BE9C2858F9A52B7B")
    public void removeDelay() {
        delay = -1;
        // ---------- Original Method ----------
        //delay = -1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.753 -0400", hash_original_method = "4E9675E31226E40B31535DE558B43882", hash_generated_method = "5658C8A3C71FE29B565BCA2BBA1E0DAB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.754 -0400", hash_original_method = "01E7C97794DF2BDF54B9432179BAF6F0", hash_generated_method = "43BB5D3EDB53450E871F26E2556726E6")
    public float getTimeStamp() {
        {
            Object var518C0BE319A4F073F4271A6A9A965DE9_1760559309 = (Float.valueOf(timeStamp).floatValue());
        } //End flattened ternary
        float var546ADE640B6EDFBC8A086EF31347E768_1040507592 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1040507592;
        // ---------- Original Method ----------
        //return this.timeStampFloat == -1 ? Float.valueOf(timeStamp).floatValue()
                //: this.timeStampFloat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.755 -0400", hash_original_method = "E76077CCC1CFE0A65C8B9469FD12F639", hash_generated_method = "E1E0ED33BEB9D491F15A629FA39D09DE")
    public float getDelay() {
        {
            Object varCE7EBC85748B44202C795390FDACDDD1_182075666 = (Float.valueOf(delay).floatValue());
        } //End flattened ternary
        float var546ADE640B6EDFBC8A086EF31347E768_1215289421 = getTaintFloat();
        return var546ADE640B6EDFBC8A086EF31347E768_1215289421;
        // ---------- Original Method ----------
        //return delayFloat == -1 ? Float.valueOf(delay).floatValue() : delayFloat;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.755 -0400", hash_original_method = "614287DF965A55EC9CE805B49E8E8F7E", hash_generated_method = "C1FFB39E75ACF979624CB01C600DE508")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.756 -0400", hash_original_method = "21D089BD1FDC44EC84A18CFADDD04289", hash_generated_method = "08DF6D48DE4993DE5AD307D05036C528")
    public long getTime() {
        long var0F5264038205EDFB1AC05FBB0E8C5E94_1034402375 = getTaintLong();
        return var0F5264038205EDFB1AC05FBB0E8C5E94_1034402375;
        // ---------- Original Method ----------
        //return this.timeStamp == -1 ? (long) timeStampFloat : timeStamp;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.756 -0400", hash_original_method = "BF53496596C6E194CBAA97C816B19B22", hash_generated_method = "FE2A2332699F4F9E0D3864ACC2146F3D")
    public int getTimeDelay() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998123920 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1998123920;
        // ---------- Original Method ----------
        //return this.delay == -1 ? (int) delayFloat : delay;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.757 -0400", hash_original_method = "930714F3CC3A7BF7C1984F60EB3E864F", hash_generated_method = "624A8DEB49980A308CB5535894DCCBA9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.757 -0400", hash_original_method = "D3E64583B8501E5C3510C5471B1277F7", hash_generated_method = "CE70CE4659D2331754497CDDE492C6A8")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.757 -0400", hash_original_field = "F1F76523D309971C49C86D95AD395F1F", hash_generated_field = "5580840BB5EA0CAD9750B3DAADA2FC56")

    private static final long serialVersionUID = -3711322366481232720L;
}

