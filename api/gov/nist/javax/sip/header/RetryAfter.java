package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.*;
import java.text.ParseException;
import javax.sip.header.*;

public class RetryAfter extends ParametersHeader implements RetryAfterHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.922 -0400", hash_original_field = "0852B2C20D192468F9E7BBE9BC8DDB50", hash_generated_field = "7E62DE420E31BD45BF50074711B37EB1")

    protected Integer retryAfter = new Integer(0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.922 -0400", hash_original_field = "06D4CD63BDE972FC66A0AED41D2F5C51", hash_generated_field = "F67D9B9E386FB326EF97E9813CA35FC6")

    protected String comment;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.922 -0400", hash_original_method = "5EF666CD25CA3C0D16B00CF8EC3126E1", hash_generated_method = "11165192A4B29AE963502E735055EFFA")
    public  RetryAfter() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.922 -0400", hash_original_method = "1D294A58F2AF56C9FF5AA47948D4FB5C", hash_generated_method = "D4695F9078C0FA682D7922C041CED6D0")
    public String encodeBody() {
        StringBuffer s = new StringBuffer();
    if(retryAfter != null)        
        s.append(retryAfter);
    if(comment != null)        
        s.append(SP + LPAREN + comment + RPAREN);
    if(!parameters.isEmpty())        
        {
            s.append(SEMICOLON + parameters.encode());
        } //End block
String varDE99EC39359AC6BE0E416433FFBB9F13_1419670281 =         s.toString();
        varDE99EC39359AC6BE0E416433FFBB9F13_1419670281.addTaint(taint);
        return varDE99EC39359AC6BE0E416433FFBB9F13_1419670281;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.923 -0400", hash_original_method = "B8E38931A483485D5D42DADC8F66AFA1", hash_generated_method = "FD92DF0BC26BBC24EBFDD2F8685ED094")
    public boolean hasComment() {
        boolean varE97A402AF2F516ADC47A295F69DB4C37_524853614 = (comment != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_377399617 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_377399617;
        // ---------- Original Method ----------
        //return comment != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.923 -0400", hash_original_method = "2FDA3671927B417EA64F28FFDD680773", hash_generated_method = "61BD4B46829E380C1561798A83B14603")
    public void removeComment() {
        comment = null;
        // ---------- Original Method ----------
        //comment = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.923 -0400", hash_original_method = "D3E525F6B574030796E656911FFC55CD", hash_generated_method = "D3DC81067D307533C1753B1018243A5F")
    public void removeDuration() {
        super.removeParameter(DURATION);
        // ---------- Original Method ----------
        //super.removeParameter(DURATION);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.924 -0400", hash_original_method = "F25BCD66BB29500F6C458D690EB883C8", hash_generated_method = "A7717FCB42610B942171912FF7A56050")
    public void setRetryAfter(int retryAfter) throws InvalidArgumentException {
    if(retryAfter < 0)        
        {
        InvalidArgumentException varC9EA5411DAA9933EB492EAA8CE954E84_897540159 = new InvalidArgumentException(
                "invalid parameter " + retryAfter);
        varC9EA5411DAA9933EB492EAA8CE954E84_897540159.addTaint(taint);
        throw varC9EA5411DAA9933EB492EAA8CE954E84_897540159;
        }
        this.retryAfter = Integer.valueOf(retryAfter);
        // ---------- Original Method ----------
        //if (retryAfter < 0)
            //throw new InvalidArgumentException(
                //"invalid parameter " + retryAfter);
        //this.retryAfter = Integer.valueOf(retryAfter);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.924 -0400", hash_original_method = "2986C3BA8F6864799163ED0F6663DF18", hash_generated_method = "87696599F9BF84C283CB2DDD77869D44")
    public int getRetryAfter() {
        int var062984ACC73151E8CBC6F209C8CA1653_1967295265 = (retryAfter.intValue());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666616403 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1666616403;
        // ---------- Original Method ----------
        //return retryAfter.intValue();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.924 -0400", hash_original_method = "D7C1F8AAD3D2F40DD04B72C74A7D0B69", hash_generated_method = "9ED8906A4A90FCFADF8A949F8C8D234A")
    public String getComment() {
String var20FC6A677850B0D1A8135B6A0BB12A1F_1030624576 =         comment;
        var20FC6A677850B0D1A8135B6A0BB12A1F_1030624576.addTaint(taint);
        return var20FC6A677850B0D1A8135B6A0BB12A1F_1030624576;
        // ---------- Original Method ----------
        //return comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.925 -0400", hash_original_method = "3E03F4EDAEEF7A953B18FA1E34879AC1", hash_generated_method = "253E9E9B748F7718BE75BE35CB2C1673")
    public void setComment(String comment) throws ParseException {
    if(comment == null)        
        {
        NullPointerException var34A1F1F10C1F18E3BADA460286F8E850_1165249096 = new NullPointerException("the comment parameter is null");
        var34A1F1F10C1F18E3BADA460286F8E850_1165249096.addTaint(taint);
        throw var34A1F1F10C1F18E3BADA460286F8E850_1165249096;
        }
        this.comment = comment;
        // ---------- Original Method ----------
        //if (comment == null)
            //throw new NullPointerException("the comment parameter is null");
        //this.comment = comment;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.925 -0400", hash_original_method = "7BA99CB446FF1B0F64CCC86D40E4D1B9", hash_generated_method = "EBED674C797CD6F2CC81DCA26F874113")
    public void setDuration(int duration) throws InvalidArgumentException {
        addTaint(duration);
    if(duration < 0)        
        {
        InvalidArgumentException varC82829AA8147727393833B37696F186B_1672063532 = new InvalidArgumentException("the duration parameter is <0");
        varC82829AA8147727393833B37696F186B_1672063532.addTaint(taint);
        throw varC82829AA8147727393833B37696F186B_1672063532;
        }
        this.setParameter(DURATION, duration);
        // ---------- Original Method ----------
        //if (duration < 0)
            //throw new InvalidArgumentException("the duration parameter is <0");
        //this.setParameter(DURATION, duration);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.926 -0400", hash_original_method = "B3E153B821BFB44B99CC6101FC6E67A6", hash_generated_method = "81B41D747D583D812D5A8D05324F075E")
    public int getDuration() {
    if(this.getParameter(DURATION) == null)        
        {
        int var6BB61E3B7BCE0931DA574D19D1D82C88_431042325 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2075211168 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2075211168;
        }
        else
        {
        int var8A2CA86BB82A7B407DE8EE754B4B2B85_956312598 = (super.getParameterAsInt(DURATION));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778803243 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1778803243;
        }
        // ---------- Original Method ----------
        //if (this.getParameter(DURATION) == null) return -1;
      //else return super.getParameterAsInt(DURATION);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.926 -0400", hash_original_field = "E62CCE9B262D4A1D34CCE9958F1B3ED7", hash_generated_field = "B2AC1F82873AC3043D2A9F969B88DCB0")

    private static final long serialVersionUID = -1029458515616146140L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:36.926 -0400", hash_original_field = "16A0A7EEC64CF042FCA4FA1878115EAE", hash_generated_field = "78034668ED13E4C36E5EDE2705F12AE3")

    public static final String DURATION = ParameterNames.DURATION;
}

