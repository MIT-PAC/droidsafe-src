package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import javax.sip.InvalidArgumentException;
import javax.sip.header.SubscriptionStateHeader;
import java.text.ParseException;

public class SubscriptionState extends ParametersHeader implements SubscriptionStateHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.476 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "E191433B1529B42724890251971016B1")

    protected int expires;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.476 -0400", hash_original_field = "73F101AD6AE954650F0124A90428047A", hash_generated_field = "BD8E0AD83785DE0B9BF49A5DC728A1DF")

    protected int retryAfter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.476 -0400", hash_original_field = "61CEA79444A662B19E9019F051E57D37", hash_generated_field = "C30D27B07549FD0A64778D166C0E4BE6")

    protected String reasonCode;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.476 -0400", hash_original_field = "9ED39E2EA931586B6A985A6942EF573E", hash_generated_field = "A196649679D02C3121333ABA58C9AA8D")

    protected String state;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.477 -0400", hash_original_method = "2AE8767260EE49A022E5D260FFA8A02D", hash_generated_method = "F9D33CC11D1A46D0CF22E4B318D53B6E")
    public  SubscriptionState() {
        super(SIPHeaderNames.SUBSCRIPTION_STATE);
        expires = -1;
        retryAfter = -1;
        // ---------- Original Method ----------
        //expires = -1;
        //retryAfter = -1;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.478 -0400", hash_original_method = "7314EC394325F26B79C36E58D3FDBB1D", hash_generated_method = "C37F24068CA6B798066BFDBBCF607A5B")
    public void setExpires(int expires) throws InvalidArgumentException {
    if(expires < 0)        
        {
        InvalidArgumentException var179D837F5822922B998328557CFA85F7_40214657 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setExpires(), the expires parameter is  < 0");
        var179D837F5822922B998328557CFA85F7_40214657.addTaint(taint);
        throw var179D837F5822922B998328557CFA85F7_40214657;
        }
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SubscriptionState, setExpires(), the expires parameter is  < 0");
        //this.expires = expires;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.478 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "9936A907DB0E86DEFBFCA44A41570208")
    public int getExpires() {
        int var09BCB72D61C0D6D1EFF5336DA6881557_1645305560 = (expires);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732632116 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1732632116;
        // ---------- Original Method ----------
        //return expires;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.479 -0400", hash_original_method = "50CA09FDB5676EA1DD99646C83E4C5FC", hash_generated_method = "CBAB7D7427FDA476432860240EDB661A")
    public void setRetryAfter(int retryAfter) throws InvalidArgumentException {
    if(retryAfter <= 0)        
        {
        InvalidArgumentException var6B746027DA1088357B613F4736BCF4D9_652596875 = new InvalidArgumentException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setRetryAfter(), the retryAfter parameter is <=0");
        var6B746027DA1088357B613F4736BCF4D9_652596875.addTaint(taint);
        throw var6B746027DA1088357B613F4736BCF4D9_652596875;
        }
        this.retryAfter = retryAfter;
        // ---------- Original Method ----------
        //if (retryAfter <= 0)
            //throw new InvalidArgumentException(
                //"JAIN-SIP "
                    //+ "Exception, SubscriptionState, setRetryAfter(), the retryAfter parameter is <=0");
        //this.retryAfter = retryAfter;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.479 -0400", hash_original_method = "8B40198517FC200CD43F6E0235CB55DB", hash_generated_method = "43C82BCE7BCFD5C443561D1050649D57")
    public int getRetryAfter() {
        int var73F101AD6AE954650F0124A90428047A_1598960533 = (retryAfter);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158946572 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_158946572;
        // ---------- Original Method ----------
        //return retryAfter;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.479 -0400", hash_original_method = "307A7F7469164C10B67FE98D6B3BB448", hash_generated_method = "AB7E016C1D308223CCC8879C6A7F266D")
    public String getReasonCode() {
String var76CB0F7D4385447325BDCB32047EE092_325796284 =         reasonCode;
        var76CB0F7D4385447325BDCB32047EE092_325796284.addTaint(taint);
        return var76CB0F7D4385447325BDCB32047EE092_325796284;
        // ---------- Original Method ----------
        //return reasonCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.480 -0400", hash_original_method = "F3FEA6AFF4A02AB2AF0C89DB66C639D9", hash_generated_method = "56802C1C8A8735797FC124F62426AEFF")
    public void setReasonCode(String reasonCode) throws ParseException {
    if(reasonCode == null)        
        {
        NullPointerException var007A92EE58333B9AD41B90CB549BC0CE_369688769 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setReasonCode(), the reasonCode parameter is null");
        var007A92EE58333B9AD41B90CB549BC0CE_369688769.addTaint(taint);
        throw var007A92EE58333B9AD41B90CB549BC0CE_369688769;
        }
        this.reasonCode = reasonCode;
        // ---------- Original Method ----------
        //if (reasonCode == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SubscriptionState, setReasonCode(), the reasonCode parameter is null");
        //this.reasonCode = reasonCode;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.480 -0400", hash_original_method = "B507B0FDA436CA05802CD34EFC971C76", hash_generated_method = "35BF153DC28E4073545FD5DA73004126")
    public String getState() {
String var37C56C9D63C623261861C16DCFB73F6D_1265322205 =         state;
        var37C56C9D63C623261861C16DCFB73F6D_1265322205.addTaint(taint);
        return var37C56C9D63C623261861C16DCFB73F6D_1265322205;
        // ---------- Original Method ----------
        //return state;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.481 -0400", hash_original_method = "26B14BBE6685B3C70475DE487DDF5C68", hash_generated_method = "616A610BC277D2C88ABE8767698236EF")
    public void setState(String state) throws ParseException {
    if(state == null)        
        {
        NullPointerException var2E7421E66D3504703486A8C710617853_460886904 = new NullPointerException(
                "JAIN-SIP "
                    + "Exception, SubscriptionState, setState(), the state parameter is null");
        var2E7421E66D3504703486A8C710617853_460886904.addTaint(taint);
        throw var2E7421E66D3504703486A8C710617853_460886904;
        }
        this.state = state;
        // ---------- Original Method ----------
        //if (state == null)
            //throw new NullPointerException(
                //"JAIN-SIP "
                    //+ "Exception, SubscriptionState, setState(), the state parameter is null");
        //this.state = state;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.481 -0400", hash_original_method = "E7A2FB4AC135D29D78CE09D5448C290F", hash_generated_method = "F2A159A16752636B0B262512AC911972")
    public String encodeBody() {
String varB9AAF3B320DC07C68A40DABE06BFAFD1_1923525746 =         encodeBody(new StringBuffer()).toString();
        varB9AAF3B320DC07C68A40DABE06BFAFD1_1923525746.addTaint(taint);
        return varB9AAF3B320DC07C68A40DABE06BFAFD1_1923525746;
        // ---------- Original Method ----------
        //return encodeBody(new StringBuffer()).toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.482 -0400", hash_original_method = "612E9F6C82A7EBFF3AE59409AADEC810", hash_generated_method = "F51471BC2E583A20874DB7CB9D03F4A9")
    protected StringBuffer encodeBody(StringBuffer buffer) {
        addTaint(buffer.getTaint());
    if(state != null)        
        buffer.append(state);
    if(reasonCode != null)        
        buffer.append(";reason=").append(reasonCode);
    if(expires != -1)        
        buffer.append(";expires=").append(expires);
    if(retryAfter != -1)        
        buffer.append(";retry-after=").append(retryAfter);
    if(!parameters.isEmpty())        
        {
            buffer.append(SEMICOLON);
            parameters.encode(buffer);
        } //End block
StringBuffer varE75BCB56CC6A0BCEED51BE38E1BB3F38_950699315 =         buffer;
        varE75BCB56CC6A0BCEED51BE38E1BB3F38_950699315.addTaint(taint);
        return varE75BCB56CC6A0BCEED51BE38E1BB3F38_950699315;
        // ---------- Original Method ----------
        //if (state != null)
            //buffer.append(state);
        //if (reasonCode != null)
            //buffer.append(";reason=").append(reasonCode);
        //if (expires != -1)
            //buffer.append(";expires=").append(expires);
        //if (retryAfter != -1)
            //buffer.append(";retry-after=").append(retryAfter);
        //if (!parameters.isEmpty()) {
            //buffer.append(SEMICOLON);
            //parameters.encode(buffer);
        //}
        //return buffer;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.482 -0400", hash_original_field = "9AA02F1D57D39BF5963615FDF8A802FA", hash_generated_field = "144874CA1FE0DC42636F7A1FA58F02E8")

    private static final long serialVersionUID = -6673833053927258745L;
}

