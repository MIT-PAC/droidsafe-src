package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.CallIdentifier;
import gov.nist.javax.sip.header.ParameterNames;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;






public class Replaces extends ParametersHeader implements ExtensionHeader, ReplacesHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.938 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.938 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.938 -0400", hash_original_method = "573D7C3C26F3FDBFC64B6AAA9C0FB261", hash_generated_method = "E109DF2046FCB28298FD5EAEEDF43CFC")
    public  Replaces() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.938 -0400", hash_original_method = "FC3FC3684A022FA26474BF29AC78B1CA", hash_generated_method = "9D6712590EF6EE91F7F5D49A3617C968")
    public  Replaces(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.939 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "B43807C0DE4BB4DE547A27872CEB0D2D")
    public String encodeBody() {
        if(callId == null)        
        {
String var540C13E9E156B687226421B24F2DF178_499113386 =         null;
        var540C13E9E156B687226421B24F2DF178_499113386.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_499113386;
        }
        else
        {
            String retVal = callId;
            if(!parameters.isEmpty())            
            {
                retVal += SEMICOLON + parameters.encode();
            } //End block
String var906583DF257E5B26DD99AC8582D137B0_1800456365 =             retVal;
            var906583DF257E5B26DD99AC8582D137B0_1800456365.addTaint(taint);
            return var906583DF257E5B26DD99AC8582D137B0_1800456365;
        } //End block
        // ---------- Original Method ----------
        //if (callId == null)
            //return null;
        //else {
            //String retVal = callId;
            //if (!parameters.isEmpty()) {
                //retVal += SEMICOLON + parameters.encode();
            //}
            //return retVal;
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.939 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "208E7C862DFE9E38E2283B9EDD4D3F86")
    public String getCallId() {
String var5E6A5595C014DC7657F3E7EDB5AB9AD0_1763390653 =         callId;
        var5E6A5595C014DC7657F3E7EDB5AB9AD0_1763390653.addTaint(taint);
        return var5E6A5595C014DC7657F3E7EDB5AB9AD0_1763390653;
        // ---------- Original Method ----------
        //return callId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.939 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "91A90AB49D44815A5FA1843F7B6FAAB0")
    public CallIdentifier getCallIdentifer() {
CallIdentifier varA526B294D67900709C29EF73993671CB_840262971 =         callIdentifier;
        varA526B294D67900709C29EF73993671CB_840262971.addTaint(taint);
        return varA526B294D67900709C29EF73993671CB_840262971;
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.940 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "6992A879D69ED0B331E4999AE9EC11CE")
    public void setCallId(String cid) {
        callId = cid;
        // ---------- Original Method ----------
        //callId = cid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.940 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.940 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "3B68EA13BAB07E2E7D993C23CBF54F99")
    public String getToTag() {
        if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_2089458602 =         null;
        var540C13E9E156B687226421B24F2DF178_2089458602.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2089458602;
        }
String varBC9E54483CF9A23A50F4FB068EFADA5A_497736556 =         getParameter(ParameterNames.TO_TAG);
        varBC9E54483CF9A23A50F4FB068EFADA5A_497736556.addTaint(taint);
        return varBC9E54483CF9A23A50F4FB068EFADA5A_497736556;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TO_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.941 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "631A9A48EAD32F01A1CE8A20B5DA2DEA")
    public void setToTag(String t) throws ParseException {
        addTaint(t.getTaint());
        if(t == null)        
        {
        NullPointerException var48536841AF8A8D08B60B532DE4DC695E_161670741 = new NullPointerException("null tag ");
        var48536841AF8A8D08B60B532DE4DC695E_161670741.addTaint(taint);
        throw var48536841AF8A8D08B60B532DE4DC695E_161670741;
        }
        else
        if(t.trim().equals(""))        
        {
        ParseException var28F5653882E2920E8BE15B723E3915FE_1456927463 = new ParseException("bad tag", 0);
        var28F5653882E2920E8BE15B723E3915FE_1456927463.addTaint(taint);
        throw var28F5653882E2920E8BE15B723E3915FE_1456927463;
        }
        this.setParameter(ParameterNames.TO_TAG, t);
        // ---------- Original Method ----------
        //if (t == null)
            //throw new NullPointerException("null tag ");
        //else if (t.trim().equals(""))
            //throw new ParseException("bad tag", 0);
        //this.setParameter(ParameterNames.TO_TAG, t);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.941 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "475CECC2E1B5C06E68F105E6A7333DAC")
    public boolean hasToTag() {
        boolean var70CBDDB41017F054700046FE795EF3BF_515436112 = (hasParameter(ParameterNames.TO_TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_28876147 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_28876147;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.TO_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.941 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.TO_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.941 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "D35E78359A4E55D2BE57B08079681A2F")
    public String getFromTag() {
        if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_664927568 =         null;
        var540C13E9E156B687226421B24F2DF178_664927568.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_664927568;
        }
String varD6615A55A79DDF4AB00B28EDFDDE0CF2_1734041851 =         getParameter(ParameterNames.FROM_TAG);
        varD6615A55A79DDF4AB00B28EDFDDE0CF2_1734041851.addTaint(taint);
        return varD6615A55A79DDF4AB00B28EDFDDE0CF2_1734041851;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.FROM_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.942 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "FDEB4E89F4EBACBCD97CF84CA391DA09")
    public void setFromTag(String t) throws ParseException {
        addTaint(t.getTaint());
        if(t == null)        
        {
        NullPointerException var48536841AF8A8D08B60B532DE4DC695E_1568063145 = new NullPointerException("null tag ");
        var48536841AF8A8D08B60B532DE4DC695E_1568063145.addTaint(taint);
        throw var48536841AF8A8D08B60B532DE4DC695E_1568063145;
        }
        else
        if(t.trim().equals(""))        
        {
        ParseException var28F5653882E2920E8BE15B723E3915FE_1480084641 = new ParseException("bad tag", 0);
        var28F5653882E2920E8BE15B723E3915FE_1480084641.addTaint(taint);
        throw var28F5653882E2920E8BE15B723E3915FE_1480084641;
        }
        this.setParameter(ParameterNames.FROM_TAG, t);
        // ---------- Original Method ----------
        //if (t == null)
            //throw new NullPointerException("null tag ");
        //else if (t.trim().equals(""))
            //throw new ParseException("bad tag", 0);
        //this.setParameter(ParameterNames.FROM_TAG, t);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.942 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "DFE0AAF67ECCC62FC9AE7B1C097FDC99")
    public boolean hasFromTag() {
        boolean var49E814D07FF38DAE7998C7FEF2B9AB27_1166811574 = (hasParameter(ParameterNames.FROM_TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1267687246 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1267687246;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.FROM_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.942 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.FROM_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.943 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "4F1ED01CBC27C91D8835CADF87E18C17")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_253488746 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_253488746.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_253488746;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.943 -0400", hash_original_field = "1A90250BEA22A34094D11017692E5A52", hash_generated_field = "F2330FF32F2F9FA993B883D22A1E4D56")

    private static final long serialVersionUID = 8765762413224043300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.943 -0400", hash_original_field = "4403168D63862D2494FF603BBD9AC891", hash_generated_field = "6C314597CB78321B5F749A310B2C1B23")

    public static final String NAME = "Replaces";
}

