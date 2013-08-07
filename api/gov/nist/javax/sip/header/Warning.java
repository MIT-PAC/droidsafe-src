package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.WarningHeader;






public class Warning extends SIPHeader implements WarningHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.767 -0400", hash_original_field = "C13367945D5D4C91047B3B50234AA7AB", hash_generated_field = "F5A70E4F98FA3F77B9B0CD95DEE2E30D")

    protected int code;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.767 -0400", hash_original_field = "B33AED8F3134996703DC39F9A7C95783", hash_generated_field = "14267456FD4CBBE9D66A8DE4A6C42A36")

    protected String agent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.767 -0400", hash_original_field = "1CB251EC0D568DE6A929B520C4AED8D1", hash_generated_field = "66B33F01239E8E09E0B8D1D466F29BFA")

    protected String text;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.767 -0400", hash_original_method = "EC205AAA0E57D7457805C01D650D3D4C", hash_generated_method = "4BBA6FE432398CF7B15E3E65F123726B")
    public  Warning() {
        super(WARNING);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.767 -0400", hash_original_method = "F1B6F008CE79EB2FBE5188D2B8BB2F2C", hash_generated_method = "09972D235AD55D5CCF648AB7E827CF27")
    public String encodeBody() {
String var11EAF17437950272B831FF213CDE88DD_940386811 =         text != null
            ? Integer.toString(code)
                + SP
                + agent
                + SP
                + DOUBLE_QUOTE
                + text
                + DOUBLE_QUOTE
            : Integer.toString(code) + SP + agent;
        var11EAF17437950272B831FF213CDE88DD_940386811.addTaint(taint);
        return var11EAF17437950272B831FF213CDE88DD_940386811;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.768 -0400", hash_original_method = "0DCDBA7E30E559B2571A09070ED05380", hash_generated_method = "7C7042AAB4596BD9C33914A3A1D93719")
    public int getCode() {
        int varC13367945D5D4C91047B3B50234AA7AB_666190834 = (code);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262409274 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_262409274;
        // ---------- Original Method ----------
        //return code;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.768 -0400", hash_original_method = "7B2F86C2E403FA4426A7AF0306AE1B67", hash_generated_method = "D3402FEF35997D760BB50098BBDE0246")
    public String getAgent() {
String var1EB77813C3300980563FC972DA0DB3A8_1733566083 =         agent;
        var1EB77813C3300980563FC972DA0DB3A8_1733566083.addTaint(taint);
        return var1EB77813C3300980563FC972DA0DB3A8_1733566083;
        // ---------- Original Method ----------
        //return agent;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.768 -0400", hash_original_method = "C0F9B3C9D6FFAEB2F99491C721442157", hash_generated_method = "AC667CA645D73855E45DA2E96A7505CD")
    public String getText() {
String var79CC641C1148018540A26F7ADC424893_230576119 =         text;
        var79CC641C1148018540A26F7ADC424893_230576119.addTaint(taint);
        return var79CC641C1148018540A26F7ADC424893_230576119;
        // ---------- Original Method ----------
        //return text;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.769 -0400", hash_original_method = "741202B8F1CEFA0CCA05AB4A3FC24738", hash_generated_method = "1CB98A2D4889522E9BE067BDCB3AAD86")
    public void setCode(int code) throws InvalidArgumentException {
        if(code >99  && code < 1000)        
        {
            this.code = code;
        } //End block
        else
        {
        InvalidArgumentException var3C1D93B211F5F35EA854AF40896D0EDC_1761150230 = new InvalidArgumentException(
                "Code parameter in the Warning header is invalid: code="
                    + code);
        var3C1D93B211F5F35EA854AF40896D0EDC_1761150230.addTaint(taint);
        throw var3C1D93B211F5F35EA854AF40896D0EDC_1761150230;
        }
        // ---------- Original Method ----------
        //if (code >99  && code < 1000) { 
            //this.code = code;
        //} else
            //throw new InvalidArgumentException(
                //"Code parameter in the Warning header is invalid: code="
                    //+ code);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.770 -0400", hash_original_method = "25CC32B68A77A53B595C551260404BAA", hash_generated_method = "4B015C2ED25F8125A6F4359B717D9373")
    public void setAgent(String host) throws ParseException {
        if(host == null)        
        {
        NullPointerException varC1046F00D8099B68E0BA11B1F28EE230_600399512 = new NullPointerException("the host parameter in the Warning header is null");
        varC1046F00D8099B68E0BA11B1F28EE230_600399512.addTaint(taint);
        throw varC1046F00D8099B68E0BA11B1F28EE230_600399512;
        }
        else
        {
            this.agent = host;
        } //End block
        // ---------- Original Method ----------
        //if (host == null)
            //throw new NullPointerException("the host parameter in the Warning header is null");
        //else {
            //this.agent = host;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.770 -0400", hash_original_method = "8DD43A4484C9753D191B662ECF9B8CD6", hash_generated_method = "25F439CBA23F2601AD6F56E088ADA9B1")
    public void setText(String text) throws ParseException {
        if(text == null)        
        {
            ParseException var5E3E00C1761DB3108D1289FF9CBB3186_190840081 = new ParseException(
                "The text parameter in the Warning header is null",
                0);
            var5E3E00C1761DB3108D1289FF9CBB3186_190840081.addTaint(taint);
            throw var5E3E00C1761DB3108D1289FF9CBB3186_190840081;
        } //End block
        else
        this.text = text;
        // ---------- Original Method ----------
        //if (text == null) {
            //throw new ParseException(
                //"The text parameter in the Warning header is null",
                //0);
        //} else
            //this.text = text;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.770 -0400", hash_original_field = "B9E067B1DFF38FD35FE190DEFEBC01C6", hash_generated_field = "04331AE451A81F964F3C29BAAEBC8E2A")

    private static final long serialVersionUID = -3433328864230783899L;
}

