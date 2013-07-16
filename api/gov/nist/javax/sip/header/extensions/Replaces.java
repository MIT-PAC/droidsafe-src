package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import javax.sip.header.ExtensionHeader;

public class Replaces extends ParametersHeader implements ExtensionHeader, ReplacesHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.788 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.788 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.788 -0400", hash_original_method = "573D7C3C26F3FDBFC64B6AAA9C0FB261", hash_generated_method = "E109DF2046FCB28298FD5EAEEDF43CFC")
    public  Replaces() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.788 -0400", hash_original_method = "FC3FC3684A022FA26474BF29AC78B1CA", hash_generated_method = "9D6712590EF6EE91F7F5D49A3617C968")
    public  Replaces(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.788 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "1402EABD3114EA99BA3F793E79C7CADE")
    public String encodeBody() {
    if(callId == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1615917140 =         null;
        var540C13E9E156B687226421B24F2DF178_1615917140.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1615917140;
        }
        else
        {
            String retVal = callId;
    if(!parameters.isEmpty())            
            {
                retVal += SEMICOLON + parameters.encode();
            } //End block
String var906583DF257E5B26DD99AC8582D137B0_1027921769 =             retVal;
            var906583DF257E5B26DD99AC8582D137B0_1027921769.addTaint(taint);
            return var906583DF257E5B26DD99AC8582D137B0_1027921769;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.789 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "AFB46B3435E423B17D0A02B9596447B5")
    public String getCallId() {
String var5E6A5595C014DC7657F3E7EDB5AB9AD0_1031313507 =         callId;
        var5E6A5595C014DC7657F3E7EDB5AB9AD0_1031313507.addTaint(taint);
        return var5E6A5595C014DC7657F3E7EDB5AB9AD0_1031313507;
        // ---------- Original Method ----------
        //return callId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.789 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "78C84648FD5A2DB048938CBC5C51E43C")
    public CallIdentifier getCallIdentifer() {
CallIdentifier varA526B294D67900709C29EF73993671CB_989920987 =         callIdentifier;
        varA526B294D67900709C29EF73993671CB_989920987.addTaint(taint);
        return varA526B294D67900709C29EF73993671CB_989920987;
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.789 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "6992A879D69ED0B331E4999AE9EC11CE")
    public void setCallId(String cid) {
        callId = cid;
        // ---------- Original Method ----------
        //callId = cid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.789 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.789 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "52E202DFA06CA32DD315B9AACC2DB574")
    public String getToTag() {
    if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_2054289671 =         null;
        var540C13E9E156B687226421B24F2DF178_2054289671.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2054289671;
        }
String varBC9E54483CF9A23A50F4FB068EFADA5A_1685982201 =         getParameter(ParameterNames.TO_TAG);
        varBC9E54483CF9A23A50F4FB068EFADA5A_1685982201.addTaint(taint);
        return varBC9E54483CF9A23A50F4FB068EFADA5A_1685982201;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TO_TAG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.789 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "DEA0C10146F97ADAFE2E844F8533FAB7")
    public void setToTag(String t) throws ParseException {
        addTaint(t.getTaint());
    if(t == null)        
        {
        NullPointerException var48536841AF8A8D08B60B532DE4DC695E_2061171075 = new NullPointerException("null tag ");
        var48536841AF8A8D08B60B532DE4DC695E_2061171075.addTaint(taint);
        throw var48536841AF8A8D08B60B532DE4DC695E_2061171075;
        }
        else
    if(t.trim().equals(""))        
        {
        ParseException var28F5653882E2920E8BE15B723E3915FE_638390860 = new ParseException("bad tag", 0);
        var28F5653882E2920E8BE15B723E3915FE_638390860.addTaint(taint);
        throw var28F5653882E2920E8BE15B723E3915FE_638390860;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.789 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "06CF780FCCECD52D56F093DB058F1E4F")
    public boolean hasToTag() {
        boolean var70CBDDB41017F054700046FE795EF3BF_2071173916 = (hasParameter(ParameterNames.TO_TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1533857434 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1533857434;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.TO_TAG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.790 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.TO_TAG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.790 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "72F3C69C8450FB9F403EF358CCE776DC")
    public String getFromTag() {
    if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1659228187 =         null;
        var540C13E9E156B687226421B24F2DF178_1659228187.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1659228187;
        }
String varD6615A55A79DDF4AB00B28EDFDDE0CF2_666374388 =         getParameter(ParameterNames.FROM_TAG);
        varD6615A55A79DDF4AB00B28EDFDDE0CF2_666374388.addTaint(taint);
        return varD6615A55A79DDF4AB00B28EDFDDE0CF2_666374388;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.FROM_TAG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.790 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "415CC4885D48AD972DCA9C05EB52D499")
    public void setFromTag(String t) throws ParseException {
        addTaint(t.getTaint());
    if(t == null)        
        {
        NullPointerException var48536841AF8A8D08B60B532DE4DC695E_943825491 = new NullPointerException("null tag ");
        var48536841AF8A8D08B60B532DE4DC695E_943825491.addTaint(taint);
        throw var48536841AF8A8D08B60B532DE4DC695E_943825491;
        }
        else
    if(t.trim().equals(""))        
        {
        ParseException var28F5653882E2920E8BE15B723E3915FE_568105183 = new ParseException("bad tag", 0);
        var28F5653882E2920E8BE15B723E3915FE_568105183.addTaint(taint);
        throw var28F5653882E2920E8BE15B723E3915FE_568105183;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.790 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "6B026C18525D85508F3F5D668FEB96D3")
    public boolean hasFromTag() {
        boolean var49E814D07FF38DAE7998C7FEF2B9AB27_1981333861 = (hasParameter(ParameterNames.FROM_TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439594756 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439594756;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.FROM_TAG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.790 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.FROM_TAG);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.790 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "CACE42183F8C56C8B2083CE6E007BE24")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_2032757067 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_2032757067.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_2032757067;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.790 -0400", hash_original_field = "1A90250BEA22A34094D11017692E5A52", hash_generated_field = "F2330FF32F2F9FA993B883D22A1E4D56")

    private static final long serialVersionUID = 8765762413224043300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.790 -0400", hash_original_field = "4403168D63862D2494FF603BBD9AC891", hash_generated_field = "6C314597CB78321B5F749A310B2C1B23")

    public static final String NAME = "Replaces";
}

