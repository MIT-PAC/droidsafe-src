package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import javax.sip.header.*;
import java.text.ParseException;
import javax.sip.InvalidArgumentException;

public class Warning extends SIPHeader implements WarningHeader {
    protected int code;
    protected String agent;
    protected String text;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.489 -0400", hash_original_method = "EC205AAA0E57D7457805C01D650D3D4C", hash_generated_method = "4BBA6FE432398CF7B15E3E65F123726B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Warning() {
        super(WARNING);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.490 -0400", hash_original_method = "F1B6F008CE79EB2FBE5188D2B8BB2F2C", hash_generated_method = "0F88B407C2348E995AA85F5DB1DFEE1F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        {
            Object var975BB82B53DA3D975562C0FC47D2767E_1785278632 = (Integer.toString(code)
                + SP
                + agent
                + SP
                + DOUBLE_QUOTE
                + text
                + DOUBLE_QUOTE);
            Object var33E8D97989B2B8AFAFCF3F983748BF19_1664571784 = (Integer.toString(code) + SP + agent);
        } //End flattened ternary
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return text != null
            //? Integer.toString(code)
                //+ SP
                //+ agent
                //+ SP
                //+ DOUBLE_QUOTE
                //+ text
                //+ DOUBLE_QUOTE
            //: Integer.toString(code) + SP + agent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.490 -0400", hash_original_method = "0DCDBA7E30E559B2571A09070ED05380", hash_generated_method = "9B4591DAA91BF5A5849A673356B6C493")
    @DSModeled(DSC.SAFE)
    public int getCode() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return code;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.490 -0400", hash_original_method = "7B2F86C2E403FA4426A7AF0306AE1B67", hash_generated_method = "857BA19DE232846A8AD82B30C8EFEA92")
    @DSModeled(DSC.SAFE)
    public String getAgent() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return agent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.490 -0400", hash_original_method = "C0F9B3C9D6FFAEB2F99491C721442157", hash_generated_method = "C61541341E3547D68FAC27F67D25C68B")
    @DSModeled(DSC.SAFE)
    public String getText() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return text;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.491 -0400", hash_original_method = "741202B8F1CEFA0CCA05AB4A3FC24738", hash_generated_method = "675A7E307DF3E7A7940310E57599561B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCode(int code) throws InvalidArgumentException {
        dsTaint.addTaint(code);
        if (DroidSafeAndroidRuntime.control) throw new InvalidArgumentException(
                "Code parameter in the Warning header is invalid: code="
                    + code);
        // ---------- Original Method ----------
        //if (code >99  && code < 1000) { 
            //this.code = code;
        //} else
            //throw new InvalidArgumentException(
                //"Code parameter in the Warning header is invalid: code="
                    //+ code);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.491 -0400", hash_original_method = "25CC32B68A77A53B595C551260404BAA", hash_generated_method = "9E3CDBEADAD07B7BB60B4BFF8D55E92A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setAgent(String host) throws ParseException {
        dsTaint.addTaint(host);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException("the host parameter in the Warning header is null");
        // ---------- Original Method ----------
        //if (host == null)
            //throw new NullPointerException("the host parameter in the Warning header is null");
        //else {
            //this.agent = host;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.491 -0400", hash_original_method = "8DD43A4484C9753D191B662ECF9B8CD6", hash_generated_method = "5D4B2A71F1F3CFBCE66D4E665C13B37E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setText(String text) throws ParseException {
        dsTaint.addTaint(text);
        {
            if (DroidSafeAndroidRuntime.control) throw new ParseException(
                "The text parameter in the Warning header is null",
                0);
        } //End block
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new ParseException(
                //"The text parameter in the Warning header is null",
                //0);
        //} else
            //this.text = text;
    }

    
    private static final long serialVersionUID = -3433328864230783899L;
}

