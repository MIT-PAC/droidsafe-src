package gov.nist.javax.sip.header.extensions;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;
import javax.sip.header.ExtensionHeader;

public class Join extends ParametersHeader implements ExtensionHeader, JoinHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.697 -0400", hash_original_field = "88C34851730939F0BFDB6F7071BED407", hash_generated_field = "64120D09C2B0721B310316A22E4103F4")

    public CallIdentifier callIdentifier;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.697 -0400", hash_original_field = "0CD10A72F684313DCE7B6EF5F7F41411", hash_generated_field = "B530B3F06EB2C57DA5D10CD3EC3286F9")

    public String callId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.697 -0400", hash_original_method = "87F4B3791A773FA2D819A20B11BB86DF", hash_generated_method = "23B37B63F5C24397936779F145AE090F")
    public  Join() {
        super(NAME);
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.698 -0400", hash_original_method = "873C342CB455582A93D9F186CC2FD1CC", hash_generated_method = "EC235DE55FAB4BA862DA3EC36BAA7583")
    public  Join(String callId) throws IllegalArgumentException {
        super(NAME);
        this.callIdentifier = new CallIdentifier(callId);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.698 -0400", hash_original_method = "62D967C94A5AE3381329492B03B8E183", hash_generated_method = "30429FFEBB1F39E5BF15A5F6E96F4E33")
    public String encodeBody() {
    if(callId == null)        
        {
String var540C13E9E156B687226421B24F2DF178_558422749 =         null;
        var540C13E9E156B687226421B24F2DF178_558422749.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_558422749;
        }
        else
        {
            String retVal = callId;
    if(!parameters.isEmpty())            
            {
                retVal += SEMICOLON + parameters.encode();
            } 
String var906583DF257E5B26DD99AC8582D137B0_1616671218 =             retVal;
            var906583DF257E5B26DD99AC8582D137B0_1616671218.addTaint(taint);
            return var906583DF257E5B26DD99AC8582D137B0_1616671218;
        } 
        
        
            
        
            
            
                
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.698 -0400", hash_original_method = "EEE15C2182CFD7EA9CBDBFC60D7CEB59", hash_generated_method = "4100DF9667D1CB31915877A5BBA31AD8")
    public String getCallId() {
String var5E6A5595C014DC7657F3E7EDB5AB9AD0_1998201629 =         callId;
        var5E6A5595C014DC7657F3E7EDB5AB9AD0_1998201629.addTaint(taint);
        return var5E6A5595C014DC7657F3E7EDB5AB9AD0_1998201629;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.699 -0400", hash_original_method = "B5581A57A5C5C2AEBCF8449C03245AE9", hash_generated_method = "88EECF618B045E3ED53F182E440D3C72")
    public CallIdentifier getCallIdentifer() {
CallIdentifier varA526B294D67900709C29EF73993671CB_233584768 =         callIdentifier;
        varA526B294D67900709C29EF73993671CB_233584768.addTaint(taint);
        return varA526B294D67900709C29EF73993671CB_233584768;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.699 -0400", hash_original_method = "18B0F6F776471BD79AF2D65BB23B3FDC", hash_generated_method = "6992A879D69ED0B331E4999AE9EC11CE")
    public void setCallId(String cid) {
        callId = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.700 -0400", hash_original_method = "76D6B9E3FB2D7381056714796D175A19", hash_generated_method = "BC500CAB746BFEA9CABDC759AB4FDB6D")
    public void setCallIdentifier(CallIdentifier cid) {
        callIdentifier = cid;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.700 -0400", hash_original_method = "B211B6A9EDFBB72196EA1C1405552E2E", hash_generated_method = "8FF8FBC26B85CED6EB7E3615C8CFE204")
    public String getToTag() {
    if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_35542125 =         null;
        var540C13E9E156B687226421B24F2DF178_35542125.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_35542125;
        }
String varBC9E54483CF9A23A50F4FB068EFADA5A_1705158872 =         getParameter(ParameterNames.TO_TAG);
        varBC9E54483CF9A23A50F4FB068EFADA5A_1705158872.addTaint(taint);
        return varBC9E54483CF9A23A50F4FB068EFADA5A_1705158872;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.700 -0400", hash_original_method = "11B74AD04734B3C61566E9250AEBA382", hash_generated_method = "E0DA3B602400900E3E1240423A4560CD")
    public void setToTag(String t) throws ParseException {
        addTaint(t.getTaint());
    if(t == null)        
        {
        NullPointerException var48536841AF8A8D08B60B532DE4DC695E_1764067908 = new NullPointerException("null tag ");
        var48536841AF8A8D08B60B532DE4DC695E_1764067908.addTaint(taint);
        throw var48536841AF8A8D08B60B532DE4DC695E_1764067908;
        }
        else
    if(t.trim().equals(""))        
        {
        ParseException var28F5653882E2920E8BE15B723E3915FE_1259493269 = new ParseException("bad tag", 0);
        var28F5653882E2920E8BE15B723E3915FE_1259493269.addTaint(taint);
        throw var28F5653882E2920E8BE15B723E3915FE_1259493269;
        }
        this.setParameter(ParameterNames.TO_TAG, t);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.701 -0400", hash_original_method = "8119C72F0478CFCCBAF29A53C28985A0", hash_generated_method = "0ABAA92698A3C9D5F774E4F40474B063")
    public boolean hasToTag() {
        boolean var70CBDDB41017F054700046FE795EF3BF_1397757458 = (hasParameter(ParameterNames.TO_TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1088953973 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1088953973;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.701 -0400", hash_original_method = "C0C59EBD9F5AF1603D81C107186D4E66", hash_generated_method = "8F5C24D1B4E10E96F090DB388EB7CB97")
    public void removeToTag() {
        parameters.delete(ParameterNames.TO_TAG);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.701 -0400", hash_original_method = "31D6F2518E32939467AAA449E3B07BF0", hash_generated_method = "9F32A6409BB6346F7B4CD22DCC5053AD")
    public String getFromTag() {
    if(parameters == null)        
        {
String var540C13E9E156B687226421B24F2DF178_1014292589 =         null;
        var540C13E9E156B687226421B24F2DF178_1014292589.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1014292589;
        }
String varD6615A55A79DDF4AB00B28EDFDDE0CF2_1654651909 =         getParameter(ParameterNames.FROM_TAG);
        varD6615A55A79DDF4AB00B28EDFDDE0CF2_1654651909.addTaint(taint);
        return varD6615A55A79DDF4AB00B28EDFDDE0CF2_1654651909;
        
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.702 -0400", hash_original_method = "06D289B84B93DB0101D64879F61C1049", hash_generated_method = "44B34249971E645C5C35CA1BB5C35D81")
    public void setFromTag(String t) throws ParseException {
        addTaint(t.getTaint());
    if(t == null)        
        {
        NullPointerException var48536841AF8A8D08B60B532DE4DC695E_1496405079 = new NullPointerException("null tag ");
        var48536841AF8A8D08B60B532DE4DC695E_1496405079.addTaint(taint);
        throw var48536841AF8A8D08B60B532DE4DC695E_1496405079;
        }
        else
    if(t.trim().equals(""))        
        {
        ParseException var28F5653882E2920E8BE15B723E3915FE_1198635573 = new ParseException("bad tag", 0);
        var28F5653882E2920E8BE15B723E3915FE_1198635573.addTaint(taint);
        throw var28F5653882E2920E8BE15B723E3915FE_1198635573;
        }
        this.setParameter(ParameterNames.FROM_TAG, t);
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.702 -0400", hash_original_method = "0268276F0AF2F185A8A983DF4EA54EFF", hash_generated_method = "559DC92A94AB48B3EF0A7D6E2699E578")
    public boolean hasFromTag() {
        boolean var49E814D07FF38DAE7998C7FEF2B9AB27_1001338924 = (hasParameter(ParameterNames.FROM_TAG));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1792446422 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1792446422;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.702 -0400", hash_original_method = "77DF4F38C27826586F02F5EEDFEC8C8D", hash_generated_method = "B61172F24259436FBA34D6DD3E3FE321")
    public void removeFromTag() {
        parameters.delete(ParameterNames.FROM_TAG);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.703 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "142A9BDDB720AB9D0361BDB0D8D98C01")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_377836676 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_377836676.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_377836676;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.703 -0400", hash_original_field = "458D5CDFA53BA618A9930E93AC7CDE95", hash_generated_field = "6CB5FD5185865CE37770D9CE36F56865")

    private static final long serialVersionUID = -840116548918120056L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.703 -0400", hash_original_field = "BD7843C2FC1C4934D2D46FD2DD982DF8", hash_generated_field = "13095D8F107AFC77A4F003D089C600F0")

    public static final String NAME = "Join";
}

