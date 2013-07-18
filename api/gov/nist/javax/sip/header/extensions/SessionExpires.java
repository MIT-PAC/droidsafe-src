package gov.nist.javax.sip.header.extensions;

// Droidsafe Imports
import gov.nist.javax.sip.header.ParametersHeader;

import java.text.ParseException;

import javax.sip.InvalidArgumentException;
import javax.sip.header.ExtensionHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public final class SessionExpires extends ParametersHeader implements ExtensionHeader, SessionExpiresHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.958 -0400", hash_original_field = "09BCB72D61C0D6D1EFF5336DA6881557", hash_generated_field = "C13B9F005337F50619E5092E1337E1D0")

    public int expires;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.958 -0400", hash_original_method = "A8246024A4BBDCEF318DB7F6B74C4E64", hash_generated_method = "0E464BB06220F15972D6EA6681E34A06")
    public  SessionExpires() {
        super(NAME);
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.959 -0400", hash_original_method = "47881175D7C463BCCB25030D767AD658", hash_generated_method = "01B378D53E61514F937A3E68D59BF400")
    public int getExpires() {
        int var09BCB72D61C0D6D1EFF5336DA6881557_1161617197 = (expires);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038655468 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2038655468;
        // ---------- Original Method ----------
        //return expires;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.959 -0400", hash_original_method = "A313D6724829247498596D0326F894CE", hash_generated_method = "2EEFC0D5D991DBAFC8C5EDD94562E8DA")
    public void setExpires(int expires) throws InvalidArgumentException {
        if(expires < 0)        
        {
        InvalidArgumentException var0A30DEF68A266FAAF2201026044A20DF_191963798 = new InvalidArgumentException("bad argument " + expires);
        var0A30DEF68A266FAAF2201026044A20DF_191963798.addTaint(taint);
        throw var0A30DEF68A266FAAF2201026044A20DF_191963798;
        }
        this.expires = expires;
        // ---------- Original Method ----------
        //if (expires < 0)
            //throw new InvalidArgumentException("bad argument " + expires);
        //this.expires = expires;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.960 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "76F32670AA3F29429266E7F5522C75F4")
    public void setValue(String value) throws ParseException {
        addTaint(value.getTaint());
        ParseException varADC68F4409F245E41BA5DDA0F06CA1BA_1316350936 = new ParseException(value,0);
        varADC68F4409F245E41BA5DDA0F06CA1BA_1316350936.addTaint(taint);
        throw varADC68F4409F245E41BA5DDA0F06CA1BA_1316350936;
        // ---------- Original Method ----------
        //throw new ParseException(value,0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.960 -0400", hash_original_method = "B1D6BF5FEA5681AEA45EA9D4CACD9FB8", hash_generated_method = "29D817DFC3163094869101824A97C277")
    protected String encodeBody() {
        String retval = Integer.toString(expires);
        if(!parameters.isEmpty())        
        {
            retval += SEMICOLON + parameters.encode();
        } //End block
String varF9E19AD6135C970F387F77C6F3DE4477_1158766719 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1158766719.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1158766719;
        // ---------- Original Method ----------
        //String retval = Integer.toString(expires);
        //if (!parameters.isEmpty()) {
            //retval += SEMICOLON + parameters.encode();
        //}
        //return retval;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.960 -0400", hash_original_method = "5E6D9C5D9628C8E8194658511D516C38", hash_generated_method = "6D82A6EA510EC08A47B6E84ADF38E589")
    public String getRefresher() {
String varEF9621B7FF8DF6825B9E53C230E10CCF_607735452 =         parameters.getParameter(REFRESHER);
        varEF9621B7FF8DF6825B9E53C230E10CCF_607735452.addTaint(taint);
        return varEF9621B7FF8DF6825B9E53C230E10CCF_607735452;
        // ---------- Original Method ----------
        //return parameters.getParameter(REFRESHER);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.961 -0400", hash_original_method = "B765158B109DFF1FFF87124C5A68F884", hash_generated_method = "57D499A4BBAA0B11EDD404AE43BEDEE3")
    public void setRefresher(String refresher) {
        addTaint(refresher.getTaint());
        this.parameters.set(REFRESHER,refresher);
        // ---------- Original Method ----------
        //this.parameters.set(REFRESHER,refresher);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.961 -0400", hash_original_field = "1A90250BEA22A34094D11017692E5A52", hash_generated_field = "F2330FF32F2F9FA993B883D22A1E4D56")

    private static final long serialVersionUID = 8765762413224043300L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.961 -0400", hash_original_field = "9BF636FEEC8D4B6523EE9B98ABA0A950", hash_generated_field = "440D53375B5C86D3B1C0A993DC1D1A5F")

    public static final String NAME = "Session-Expires";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.961 -0400", hash_original_field = "52C1E472405D97BD87845AB341E0D9DF", hash_generated_field = "D51D2CDCC34D9E34598982CCDA37DCD7")

    public static final String REFRESHER = "refresher";
}

