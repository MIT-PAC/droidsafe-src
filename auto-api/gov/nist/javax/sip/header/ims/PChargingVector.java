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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.280 -0400", hash_original_method = "F24963EF187BB1F8C634FCD3043DEC7F", hash_generated_method = "6095E38714E723CF4021E2B80F418044")
    public  PChargingVector() {
        super(P_CHARGING_VECTOR);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.282 -0400", hash_original_method = "28145672492296ED345E3C0B325C1523", hash_generated_method = "37C1C134465400E314338CA7DFC35D3A")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_330178258 = null; //Variable for return #1
        StringBuffer encoding;
        encoding = new StringBuffer();
        gov.nist.core.NameValue nv;
        nv = getNameValue( ParameterNamesIms.ICID_VALUE );
        nv.encode( encoding );
        {
            boolean var365EECA05BB94B1D3EE2B7A27CE75BC5_1204419879 = (parameters.containsKey(ParameterNamesIms.ICID_GENERATED_AT));
            encoding.append(SEMICOLON).append(
                    ParameterNamesIms.ICID_GENERATED_AT).append(EQUALS).append(
                    getICIDGeneratedAt());
        } //End collapsed parenthetic
        {
            boolean var3CC7D78860486207BDF218E5BB0FBFF9_2043200293 = (parameters.containsKey(ParameterNamesIms.TERM_IOI));
            encoding.append(SEMICOLON).append(ParameterNamesIms.TERM_IOI)
                    .append(EQUALS).append(getTerminatingIOI());
        } //End collapsed parenthetic
        {
            boolean varD04222CB942016251A12306783266E31_237308545 = (parameters.containsKey(ParameterNamesIms.ORIG_IOI));
            encoding.append(SEMICOLON).append(ParameterNamesIms.ORIG_IOI)
                    .append(EQUALS).append(getOriginatingIOI());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_330178258 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_330178258.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_330178258;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.292 -0400", hash_original_method = "B80431D54E690B860FD3339F406AB025", hash_generated_method = "6BF9120EEC569EC7DECF8A80DC6C821C")
    public String getICID() {
        String varB4EAC82CA7396A68D541C85D26508E83_2115176695 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2115176695 = getParameter(ParameterNamesIms.ICID_VALUE);
        varB4EAC82CA7396A68D541C85D26508E83_2115176695.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2115176695;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ICID_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.292 -0400", hash_original_method = "EBEB68B63CE22995F9427EDD0E4E07CA", hash_generated_method = "BF114006E67821E439D5BCDA19FCEDE2")
    public void setICID(String icid) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICID(), the icid parameter is null.");
        setParameter(ParameterNamesIms.ICID_VALUE, icid);
        addTaint(icid.getTaint());
        // ---------- Original Method ----------
        //if (icid == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Charging-Vector, setICID(), the icid parameter is null.");
        //setParameter(ParameterNamesIms.ICID_VALUE, icid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.293 -0400", hash_original_method = "E03F1FEEE570AA8D71D705B8C23619DF", hash_generated_method = "CA9E44ECE5642AC77A48441401684DB1")
    public String getICIDGeneratedAt() {
        String varB4EAC82CA7396A68D541C85D26508E83_1659260471 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1659260471 = getParameter(ParameterNamesIms.ICID_GENERATED_AT);
        varB4EAC82CA7396A68D541C85D26508E83_1659260471.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1659260471;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ICID_GENERATED_AT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.294 -0400", hash_original_method = "F4508B4C04B9B92ED2D0B6FD3FCDD70F", hash_generated_method = "02E8850E20792337D964848D34BC0404")
    public void setICIDGeneratedAt(String host) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                    "JAIN-SIP Exception, "
                            + "P-Charging-Vector, setICIDGeneratedAt(), the host parameter is null.");
        setParameter(ParameterNamesIms.ICID_GENERATED_AT, host);
        addTaint(host.getTaint());
        // ---------- Original Method ----------
        //if (host == null)
            //throw new NullPointerException(
                    //"JAIN-SIP Exception, "
                            //+ "P-Charging-Vector, setICIDGeneratedAt(), the host parameter is null.");
        //setParameter(ParameterNamesIms.ICID_GENERATED_AT, host);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.304 -0400", hash_original_method = "9C58F34D8EC32A5F098899E01B3677E3", hash_generated_method = "4A11C8AADF5CE5C47138CE75AFBD09EB")
    public String getOriginatingIOI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1340716333 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1340716333 = getParameter(ParameterNamesIms.ORIG_IOI);
        varB4EAC82CA7396A68D541C85D26508E83_1340716333.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1340716333;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ORIG_IOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.305 -0400", hash_original_method = "4D1174A0C4FD1D4621AAA8C5BA456558", hash_generated_method = "CA46C1E82011EE516E2D3299D37C8B92")
    public void setOriginatingIOI(String origIOI) throws ParseException {
        {
            boolean var92D070AC95721983DC0013EE99F4F26F_1530830469 = (origIOI == null || origIOI.length() == 0);
            {
                removeParameter(ParameterNamesIms.ORIG_IOI);
            } //End block
            setParameter(ParameterNamesIms.ORIG_IOI, origIOI);
        } //End collapsed parenthetic
        addTaint(origIOI.getTaint());
        // ---------- Original Method ----------
        //if (origIOI == null || origIOI.length() == 0) {
            //removeParameter(ParameterNamesIms.ORIG_IOI);
        //} else
            //setParameter(ParameterNamesIms.ORIG_IOI, origIOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.305 -0400", hash_original_method = "D0795F3899C65FBD8AF4B39D420CBFCA", hash_generated_method = "948BF45B2648C5FE42E8E6CA0A6165E0")
    public String getTerminatingIOI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1321281965 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1321281965 = getParameter(ParameterNamesIms.TERM_IOI);
        varB4EAC82CA7396A68D541C85D26508E83_1321281965.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1321281965;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.TERM_IOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.305 -0400", hash_original_method = "9F4DF1C8B170A0213F28AE6F8C15C36E", hash_generated_method = "82F413381EA242A3D809F3CA51550FED")
    public void setTerminatingIOI(String termIOI) throws ParseException {
        {
            boolean var37A47FB02DC54A02839143740CF28C52_2126458432 = (termIOI == null || termIOI.length() == 0);
            {
                removeParameter(ParameterNamesIms.TERM_IOI);
            } //End block
            setParameter(ParameterNamesIms.TERM_IOI, termIOI);
        } //End collapsed parenthetic
        addTaint(termIOI.getTaint());
        // ---------- Original Method ----------
        //if (termIOI == null || termIOI.length() == 0) {
            //removeParameter(ParameterNamesIms.TERM_IOI);
        //} else
            //setParameter(ParameterNamesIms.TERM_IOI, termIOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:33.306 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value, 0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value, 0);
    }

    
}

