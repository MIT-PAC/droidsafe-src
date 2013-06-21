package gov.nist.javax.sip.header.ims;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.ExtensionHeader;
import gov.nist.javax.sip.header.ims.PChargingVectorHeader;
import gov.nist.javax.sip.header.ims.ParameterNamesIms;

public class PChargingVector extends gov.nist.javax.sip.header.ParametersHeader implements PChargingVectorHeader, SIPHeaderNamesIms, ExtensionHeader {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.579 -0400", hash_original_method = "F24963EF187BB1F8C634FCD3043DEC7F", hash_generated_method = "6095E38714E723CF4021E2B80F418044")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PChargingVector() {
        super(P_CHARGING_VECTOR);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.579 -0400", hash_original_method = "28145672492296ED345E3C0B325C1523", hash_generated_method = "0D28E7CAC7D1CD3FF54A290B8BCE2B6E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected String encodeBody() {
        StringBuffer encoding;
        encoding = new StringBuffer();
        gov.nist.core.NameValue nv;
        nv = getNameValue( ParameterNamesIms.ICID_VALUE );
        nv.encode( encoding );
        {
            boolean var365EECA05BB94B1D3EE2B7A27CE75BC5_274076536 = (parameters.containsKey(ParameterNamesIms.ICID_GENERATED_AT));
            encoding.append(SEMICOLON).append(
                    ParameterNamesIms.ICID_GENERATED_AT).append(EQUALS).append(
                    getICIDGeneratedAt());
        } //End collapsed parenthetic
        {
            boolean var3CC7D78860486207BDF218E5BB0FBFF9_201827589 = (parameters.containsKey(ParameterNamesIms.TERM_IOI));
            encoding.append(SEMICOLON).append(ParameterNamesIms.TERM_IOI)
                    .append(EQUALS).append(getTerminatingIOI());
        } //End collapsed parenthetic
        {
            boolean varD04222CB942016251A12306783266E31_1848109933 = (parameters.containsKey(ParameterNamesIms.ORIG_IOI));
            encoding.append(SEMICOLON).append(ParameterNamesIms.ORIG_IOI)
                    .append(EQUALS).append(getOriginatingIOI());
        } //End collapsed parenthetic
        String varB81683B37658DAABB0D3F9E81B4869CA_1033899179 = (encoding.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.579 -0400", hash_original_method = "B80431D54E690B860FD3339F406AB025", hash_generated_method = "0293B083E4EA6E0B500390CCAB410EDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getICID() {
        String var0035A2C97A201F5AFB98166404038D31_789716970 = (getParameter(ParameterNamesIms.ICID_VALUE));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ICID_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.580 -0400", hash_original_method = "EBEB68B63CE22995F9427EDD0E4E07CA", hash_generated_method = "0D21F84EFB7CF915D7547E1D31F38BA6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setICID(String icid) throws ParseException {
        dsTaint.addTaint(icid);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICID(), the icid parameter is null.");
        setParameter(ParameterNamesIms.ICID_VALUE, icid);
        // ---------- Original Method ----------
        //if (icid == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Charging-Vector, setICID(), the icid parameter is null.");
        //setParameter(ParameterNamesIms.ICID_VALUE, icid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.580 -0400", hash_original_method = "E03F1FEEE570AA8D71D705B8C23619DF", hash_generated_method = "E8ABBD6BBFEFDB468FABEC1006173CDA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getICIDGeneratedAt() {
        String var9697451F92B8155F81A79BBEDFF7E02B_1452003184 = (getParameter(ParameterNamesIms.ICID_GENERATED_AT));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ICID_GENERATED_AT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.580 -0400", hash_original_method = "F4508B4C04B9B92ED2D0B6FD3FCDD70F", hash_generated_method = "6450CA75CE7CD0D6373EEEDC6090A70F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setICIDGeneratedAt(String host) throws ParseException {
        dsTaint.addTaint(host);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICIDGeneratedAt(), the host parameter is null.");
        setParameter(ParameterNamesIms.ICID_GENERATED_AT, host);
        // ---------- Original Method ----------
        //if (host == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Charging-Vector, setICIDGeneratedAt(), the host parameter is null.");
        //setParameter(ParameterNamesIms.ICID_GENERATED_AT, host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.580 -0400", hash_original_method = "9C58F34D8EC32A5F098899E01B3677E3", hash_generated_method = "0F96593FEE75E934B6285B1078C04FA5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getOriginatingIOI() {
        String var8BB3D26BC57BF774265ADA70F73FD16C_249656252 = (getParameter(ParameterNamesIms.ORIG_IOI));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ORIG_IOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.580 -0400", hash_original_method = "4D1174A0C4FD1D4621AAA8C5BA456558", hash_generated_method = "19AFF3E5E54729E67149020B37F6AA2D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOriginatingIOI(String origIOI) throws ParseException {
        dsTaint.addTaint(origIOI);
        {
            boolean var92D070AC95721983DC0013EE99F4F26F_368839689 = (origIOI == null || origIOI.length() == 0);
            {
                removeParameter(ParameterNamesIms.ORIG_IOI);
            } //End block
            setParameter(ParameterNamesIms.ORIG_IOI, origIOI);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (origIOI == null || origIOI.length() == 0) {
            //removeParameter(ParameterNamesIms.ORIG_IOI);
        //} else
            //setParameter(ParameterNamesIms.ORIG_IOI, origIOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.580 -0400", hash_original_method = "D0795F3899C65FBD8AF4B39D420CBFCA", hash_generated_method = "3730BC371EEA0221AE25C7A84ABE5AFD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getTerminatingIOI() {
        String var20BCCFBA375F35DE7837E836B8C02189_2107200297 = (getParameter(ParameterNamesIms.TERM_IOI));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.TERM_IOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.581 -0400", hash_original_method = "9F4DF1C8B170A0213F28AE6F8C15C36E", hash_generated_method = "64EDADF6F772625C374A08EBB8AAC989")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setTerminatingIOI(String termIOI) throws ParseException {
        dsTaint.addTaint(termIOI);
        {
            boolean var37A47FB02DC54A02839143740CF28C52_1287192265 = (termIOI == null || termIOI.length() == 0);
            {
                removeParameter(ParameterNamesIms.TERM_IOI);
            } //End block
            setParameter(ParameterNamesIms.TERM_IOI, termIOI);
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (termIOI == null || termIOI.length() == 0) {
            //removeParameter(ParameterNamesIms.TERM_IOI);
        //} else
            //setParameter(ParameterNamesIms.TERM_IOI, termIOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.581 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "3173C219DBD7EAE475390DAFD6FD461B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setValue(String value) throws ParseException {
        dsTaint.addTaint(value);
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value, 0);
        // ---------- Original Method ----------
        //throw new ParseException(value, 0);
    }

    
}

