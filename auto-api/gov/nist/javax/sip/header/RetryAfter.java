package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.*;
import java.text.ParseException;
import javax.sip.header.*;

public class RetryAfter extends ParametersHeader implements RetryAfterHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.124 -0400", hash_original_field = "0852B2C20D192468F9E7BBE9BC8DDB50", hash_generated_field = "7E62DE420E31BD45BF50074711B37EB1")

    protected Integer retryAfter = new Integer(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.124 -0400", hash_original_field = "06D4CD63BDE972FC66A0AED41D2F5C51", hash_generated_field = "F67D9B9E386FB326EF97E9813CA35FC6")

    protected String comment;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.125 -0400", hash_original_method = "5EF666CD25CA3C0D16B00CF8EC3126E1", hash_generated_method = "11165192A4B29AE963502E735055EFFA")
    public  RetryAfter() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.125 -0400", hash_original_method = "1D294A58F2AF56C9FF5AA47948D4FB5C", hash_generated_method = "2061938CE754F759F879B522CD8CEC86")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_1887583131 = null; //Variable for return #1
        StringBuffer s = new StringBuffer();
        s.append(retryAfter);
        s.append(SP + LPAREN + comment + RPAREN);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1273492672 = (!parameters.isEmpty());
            {
                s.append(SEMICOLON + parameters.encode());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1887583131 = s.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1887583131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1887583131;
        // ---------- Original Method ----------
        //StringBuffer s = new StringBuffer();
        //if (retryAfter != null)
            //s.append(retryAfter);
        //if (comment != null)
            //s.append(SP + LPAREN + comment + RPAREN);
        //if (!parameters.isEmpty()) {
            //s.append(SEMICOLON + parameters.encode());
        //}
        //return s.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.126 -0400", hash_original_method = "B8E38931A483485D5D42DADC8F66AFA1", hash_generated_method = "B700AAFF75D30A6CE937828B065749BD")
    public boolean hasComment() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_496488243 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_496488243;
        // ---------- Original Method ----------
        //return comment != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.126 -0400", hash_original_method = "2FDA3671927B417EA64F28FFDD680773", hash_generated_method = "61BD4B46829E380C1561798A83B14603")
    public void removeComment() {
        comment = null;
        // ---------- Original Method ----------
        //comment = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.127 -0400", hash_original_method = "D3E525F6B574030796E656911FFC55CD", hash_generated_method = "D3DC81067D307533C1753B1018243A5F")
    public void removeDuration() {
        super.removeParameter(DURATION);
        // ---------- Original Method ----------
        //super.removeParameter(DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.127 -0400", hash_original_method = "F25BCD66BB29500F6C458D690EB883C8", hash_generated_method = "D2F19DA1401EA392DFC1A0BE958D6298")
    public void setRetryAfter(int retryAfter) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "invalid parameter " + retryAfter);
        this.retryAfter = Integer.valueOf(retryAfter);
        // ---------- Original Method ----------
        //if (retryAfter < 0)
            //throw new InvalidArgumentException(
                //"invalid parameter " + retryAfter);
        //this.retryAfter = Integer.valueOf(retryAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.128 -0400", hash_original_method = "2986C3BA8F6864799163ED0F6663DF18", hash_generated_method = "6B9D0E95DDD9655EB632427C7685ACE9")
    public int getRetryAfter() {
        int var0013CD8BBCA9D71AD4D94A5E100A3D78_1387946367 = (retryAfter.intValue());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541061829 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_541061829;
        // ---------- Original Method ----------
        //return retryAfter.intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.130 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "E3DFD2960BBE3ED7DD4034E2D1CBD346")
    public String getComment() {
        String varB4EAC82CA7396A68D541C85D26508E83_1740124245 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1740124245 = comment;
        varB4EAC82CA7396A68D541C85D26508E83_1740124245.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1740124245;
        // ---------- Original Method ----------
        //return comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.132 -0400", hash_original_method = "3E03F4EDAEEF7A953B18FA1E34879AC1", hash_generated_method = "75A4838641B30517AEAD92BC40A1AD95")
    public void setComment(String comment) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("the comment parameter is null");
        this.comment = comment;
        // ---------- Original Method ----------
        //if (comment == null)
            //throw new NullPointerException("the comment parameter is null");
        //this.comment = comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.133 -0400", hash_original_method = "7BA99CB446FF1B0F64CCC86D40E4D1B9", hash_generated_method = "330BE3BC5E182E52A1276F78D56EBAD4")
    public void setDuration(int duration) throws InvalidArgumentException {
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("the duration parameter is <0");
        this.setParameter(DURATION, duration);
        addTaint(duration);
        // ---------- Original Method ----------
        //if (duration < 0)
            //throw new InvalidArgumentException("the duration parameter is <0");
        //this.setParameter(DURATION, duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.133 -0400", hash_original_method = "B3E153B821BFB44B99CC6101FC6E67A6", hash_generated_method = "C90F823342E879A2CFE15C67F4C9047F")
    public int getDuration() {
        {
            boolean var5760E6C863B93047465C401C736C8630_458555728 = (this.getParameter(DURATION) == null);
            int var8BF120EA788EBD810BCE83291F3C7FA8_1318084252 = (super.getParameterAsInt(DURATION));
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984863656 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_984863656;
        // ---------- Original Method ----------
        //if (this.getParameter(DURATION) == null) return -1;
      //else return super.getParameterAsInt(DURATION);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.134 -0400", hash_original_field = "E62CCE9B262D4A1D34CCE9958F1B3ED7", hash_generated_field = "B2AC1F82873AC3043D2A9F969B88DCB0")

    private static final long serialVersionUID = -1029458515616146140L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.134 -0400", hash_original_field = "16A0A7EEC64CF042FCA4FA1878115EAE", hash_generated_field = "78034668ED13E4C36E5EDE2705F12AE3")

    public static final String DURATION = ParameterNames.DURATION;
}

