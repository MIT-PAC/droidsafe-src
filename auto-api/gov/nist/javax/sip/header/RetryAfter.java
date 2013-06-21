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
    protected Integer retryAfter = new Integer(0);
    protected String comment;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.158 -0400", hash_original_method = "5EF666CD25CA3C0D16B00CF8EC3126E1", hash_generated_method = "11165192A4B29AE963502E735055EFFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public RetryAfter() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.159 -0400", hash_original_method = "1D294A58F2AF56C9FF5AA47948D4FB5C", hash_generated_method = "663A14955171F49AB6AC26DAF4D2AB64")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        StringBuffer s;
        s = new StringBuffer();
        s.append(retryAfter);
        s.append(SP + LPAREN + comment + RPAREN);
        {
            boolean varB381AD842454BDB2397F4C2DAD0B3FA1_1976201713 = (!parameters.isEmpty());
            {
                s.append(SEMICOLON + parameters.encode());
            } //End block
        } //End collapsed parenthetic
        String var2C8CBC592926D123231717329230B287_1577341250 = (s.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.159 -0400", hash_original_method = "B8E38931A483485D5D42DADC8F66AFA1", hash_generated_method = "28EDF70094F4F88DC18410853BD0C212")
    @DSModeled(DSC.SAFE)
    public boolean hasComment() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return comment != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.159 -0400", hash_original_method = "2FDA3671927B417EA64F28FFDD680773", hash_generated_method = "61BD4B46829E380C1561798A83B14603")
    @DSModeled(DSC.SAFE)
    public void removeComment() {
        comment = null;
        // ---------- Original Method ----------
        //comment = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.160 -0400", hash_original_method = "D3E525F6B574030796E656911FFC55CD", hash_generated_method = "D3DC81067D307533C1753B1018243A5F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeDuration() {
        super.removeParameter(DURATION);
        // ---------- Original Method ----------
        //super.removeParameter(DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.160 -0400", hash_original_method = "F25BCD66BB29500F6C458D690EB883C8", hash_generated_method = "7354EFC895FBC7C87CCC86CB958DFC25")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setRetryAfter(int retryAfter) throws InvalidArgumentException {
        dsTaint.addTaint(retryAfter);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "invalid parameter " + retryAfter);
        this.retryAfter = Integer.valueOf(retryAfter);
        // ---------- Original Method ----------
        //if (retryAfter < 0)
            //throw new InvalidArgumentException(
                //"invalid parameter " + retryAfter);
        //this.retryAfter = Integer.valueOf(retryAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.160 -0400", hash_original_method = "2986C3BA8F6864799163ED0F6663DF18", hash_generated_method = "194C5A5D1B5694E79FF9C7AAE6A072EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRetryAfter() {
        int var0013CD8BBCA9D71AD4D94A5E100A3D78_1845976712 = (retryAfter.intValue());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return retryAfter.intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.160 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "E5CCC5133F55EB384CCE0D646E5A9DAF")
    @DSModeled(DSC.SAFE)
    public String getComment() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.160 -0400", hash_original_method = "3E03F4EDAEEF7A953B18FA1E34879AC1", hash_generated_method = "B34346AC3781C929B54AE949248703FB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setComment(String comment) throws ParseException {
        dsTaint.addTaint(comment);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("the comment parameter is null");
        // ---------- Original Method ----------
        //if (comment == null)
            //throw new NullPointerException("the comment parameter is null");
        //this.comment = comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.161 -0400", hash_original_method = "7BA99CB446FF1B0F64CCC86D40E4D1B9", hash_generated_method = "22C794B9DBC290EDA8BC573016A22376")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setDuration(int duration) throws InvalidArgumentException {
        dsTaint.addTaint(duration);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException("the duration parameter is <0");
        this.setParameter(DURATION, duration);
        // ---------- Original Method ----------
        //if (duration < 0)
            //throw new InvalidArgumentException("the duration parameter is <0");
        //this.setParameter(DURATION, duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.161 -0400", hash_original_method = "B3E153B821BFB44B99CC6101FC6E67A6", hash_generated_method = "D7EF5FB482B36F9B8BA4F9C229D60D35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getDuration() {
        {
            boolean var5760E6C863B93047465C401C736C8630_1677199351 = (this.getParameter(DURATION) == null);
            int var8BF120EA788EBD810BCE83291F3C7FA8_23763075 = (super.getParameterAsInt(DURATION));
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (this.getParameter(DURATION) == null) return -1;
      //else return super.getParameterAsInt(DURATION);
    }

    
    private static final long serialVersionUID = -1029458515616146140L;
    public static final String DURATION = ParameterNames.DURATION;
}

