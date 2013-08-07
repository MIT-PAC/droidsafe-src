package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.CallIdentifier;
import gov.nist.javax.sip.header.ParameterNames;
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;

import javax.sip.header.ExtensionHeader;






public class Join extends ParametersHeader implements ExtensionHeader, JoinHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.791 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.791 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.791 -0400", hash_original_method = "87F4B3791A773FA2D819A20B11BB86DF", hash_generated_method = "23B37B63F5C24397936779F145AE090F")
    public  Join() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.792 -0400", hash_original_method = "873C342CB455582A93D9F186CC2FD1CC", hash_generated_method = "EC235DE55FAB4BA862DA3EC36BAA7583")
    public  Join(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        // ---------- Original Method ----------
        //this.callIdentifier = new CallIdentifier(callId);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.793 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "A0930BDAA435C82373275C4604BF609A")
    public String encodeBody() {
        if(callId == null)        
        {
String var540C13E9E156B687226421B24F2DF178_849312442 =         null;
        var540C13E9E156B687226421B24F2DF178_849312442.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_849312442;
        }
        else
        {
            String retVal = callId;
            if(!parameters.isEmpty())            
            {
                retVal += SEMICOLON + parameters.encode();
            } //End block
String var906583DF257E5B26DD99AC8582D137B0_1051747884 =             retVal;
            var906583DF257E5B26DD99AC8582D137B0_1051747884.addTaint(taint);
            return var906583DF257E5B26DD99AC8582D137B0_1051747884;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.793 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "DFE2ACE0F820F7110D93DA3BFCC0419A")
    public String getCallId() {
String var5E6A5595C014DC7657F3E7EDB5AB9AD0_399701581 =         callId;
        var5E6A5595C014DC7657F3E7EDB5AB9AD0_399701581.addTaint(taint);
        return var5E6A5595C014DC7657F3E7EDB5AB9AD0_399701581;
        // ---------- Original Method ----------
        //return callId;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.794 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "0D0EEB2480041F0D1E6359410A445689")
    public CallIdentifier getCallIdentifer() {
CallIdentifier varA526B294D67900709C29EF73993671CB_1303711318 =         callIdentifier;
        varA526B294D67900709C29EF73993671CB_1303711318.addTaint(taint);
        return varA526B294D67900709C29EF73993671CB_1303711318;
        // ---------- Original Method ----------
        //return callIdentifier;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.794 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "6992A879D69ED0B331E4999AE9EC11CE")
    public void setCallId(String cid) {
        callId = cid;
        // ---------- Original Method ----------
        //callId = cid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.795 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        // ---------- Original Method ----------
        //callIdentifier = cid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.795 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "11BE929094FEE6B798E4538F72EDB3D8")
    public String getToTag() {
        if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_121885219 =         null;
        var540C13E9E156B687226421B24F2DF178_121885219.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_121885219;
        }
String varBC9E54483CF9A23A50F4FB068EFADA5A_484599207 =         getParameter(ParameterNames.TO_TAG);
        varBC9E54483CF9A23A50F4FB068EFADA5A_484599207.addTaint(taint);
        return varBC9E54483CF9A23A50F4FB068EFADA5A_484599207;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.TO_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.796 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "4734785B8C40C71F1172FC4BF5CE4E5C")
    public void setToTag(String t) throws ParseException {
        addTaint(t.getTaint());
        if(t == null)        
        {
        NullPointerException var48536841AF8A8D08B60B532DE4DC695E_1653809923 = new NullPointerException("null tag ");
        var48536841AF8A8D08B60B532DE4DC695E_1653809923.addTaint(taint);
        throw var48536841AF8A8D08B60B532DE4DC695E_1653809923;
        }
        else
        if(t.trim().equals(""))        
        {
        ParseException var28F5653882E2920E8BE15B723E3915FE_948355073 = new ParseException("bad tag", 0);
        var28F5653882E2920E8BE15B723E3915FE_948355073.addTaint(taint);
        throw var28F5653882E2920E8BE15B723E3915FE_948355073;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.796 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "CF5F75D75A64DD855C46118ACEE457B1")
    public boolean hasToTag() {
        boolean var70CBDDB41017F054700046FE795EF3BF_306529314 = (hasParameter(ParameterNames.TO_TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1394844685 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1394844685;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.TO_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.796 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.TO_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.797 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "44DD749486C432431599049EB81C7545")
    public String getFromTag() {
        if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1182229170 =         null;
        var540C13E9E156B687226421B24F2DF178_1182229170.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1182229170;
        }
String varD6615A55A79DDF4AB00B28EDFDDE0CF2_2110700606 =         getParameter(ParameterNames.FROM_TAG);
        varD6615A55A79DDF4AB00B28EDFDDE0CF2_2110700606.addTaint(taint);
        return varD6615A55A79DDF4AB00B28EDFDDE0CF2_2110700606;
        // ---------- Original Method ----------
        //if (parameters == null)
            //return null;
        //return getParameter(ParameterNames.FROM_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.797 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "05D5329EBDB2DA2975CEE32AAA2DC6B3")
    public void setFromTag(String t) throws ParseException {
        addTaint(t.getTaint());
        if(t == null)        
        {
        NullPointerException var48536841AF8A8D08B60B532DE4DC695E_632917078 = new NullPointerException("null tag ");
        var48536841AF8A8D08B60B532DE4DC695E_632917078.addTaint(taint);
        throw var48536841AF8A8D08B60B532DE4DC695E_632917078;
        }
        else
        if(t.trim().equals(""))        
        {
        ParseException var28F5653882E2920E8BE15B723E3915FE_1846161955 = new ParseException("bad tag", 0);
        var28F5653882E2920E8BE15B723E3915FE_1846161955.addTaint(taint);
        throw var28F5653882E2920E8BE15B723E3915FE_1846161955;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.797 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "29F67633B941D0C09F78436D47753BCF")
    public boolean hasFromTag() {
        boolean var49E814D07FF38DAE7998C7FEF2B9AB27_937513175 = (hasParameter(ParameterNames.FROM_TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_948498497 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_948498497;
        // ---------- Original Method ----------
        //return hasParameter(ParameterNames.FROM_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.798 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        // ---------- Original Method ----------
        //parameters.delete(ParameterNames.FROM_TAG);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.798 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "A22A37ABF291821AB91CD065AA5CBE9E")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1097802978 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1097802978.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1097802978;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.798 -0400", hash_original_field = "458D5CDFA53BA618A9930E93AC7CDE95", hash_generated_field = "6CB5FD5185865CE37770D9CE36F56865")

    private static final long serialVersionUID = -840116548918120056L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.798 -0400", hash_original_field = "BD7843C2FC1C4934D2D46FD2DD982DF8", hash_generated_field = "13095D8F107AFC77A4F003D089C600F0")

    public static final String NAME = "Join";
}

