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
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.281 -0400", hash_original_method = "F24963EF187BB1F8C634FCD3043DEC7F", hash_generated_method = "6095E38714E723CF4021E2B80F418044")
    public  PChargingVector() {
        super(P_CHARGING_VECTOR);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.283 -0400", hash_original_method = "28145672492296ED345E3C0B325C1523", hash_generated_method = "FB6CFD91CC50658F98400B1AF63CE46B")
    protected String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_152261109 = null; //Variable for return #1
        StringBuffer encoding = new StringBuffer();
        gov.nist.core.NameValue nv = getNameValue( ParameterNamesIms.ICID_VALUE );
        nv.encode( encoding );
        {
            boolean var365EECA05BB94B1D3EE2B7A27CE75BC5_1765335283 = (parameters.containsKey(ParameterNamesIms.ICID_GENERATED_AT));
            encoding.append(SEMICOLON).append(
                    ParameterNamesIms.ICID_GENERATED_AT).append(EQUALS).append(
                    getICIDGeneratedAt());
        } //End collapsed parenthetic
        {
            boolean var3CC7D78860486207BDF218E5BB0FBFF9_1715198147 = (parameters.containsKey(ParameterNamesIms.TERM_IOI));
            encoding.append(SEMICOLON).append(ParameterNamesIms.TERM_IOI)
                    .append(EQUALS).append(getTerminatingIOI());
        } //End collapsed parenthetic
        {
            boolean varD04222CB942016251A12306783266E31_1311274756 = (parameters.containsKey(ParameterNamesIms.ORIG_IOI));
            encoding.append(SEMICOLON).append(ParameterNamesIms.ORIG_IOI)
                    .append(EQUALS).append(getOriginatingIOI());
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_152261109 = encoding.toString();
        varB4EAC82CA7396A68D541C85D26508E83_152261109.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_152261109;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.285 -0400", hash_original_method = "B80431D54E690B860FD3339F406AB025", hash_generated_method = "E3DACD1093B84893408B75BF2FD1238D")
    public String getICID() {
        String varB4EAC82CA7396A68D541C85D26508E83_395588996 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_395588996 = getParameter(ParameterNamesIms.ICID_VALUE);
        varB4EAC82CA7396A68D541C85D26508E83_395588996.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_395588996;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ICID_VALUE);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.287 -0400", hash_original_method = "EBEB68B63CE22995F9427EDD0E4E07CA", hash_generated_method = "BF114006E67821E439D5BCDA19FCEDE2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.289 -0400", hash_original_method = "E03F1FEEE570AA8D71D705B8C23619DF", hash_generated_method = "D797EC7FFAE890005FA3D1898D37FDA5")
    public String getICIDGeneratedAt() {
        String varB4EAC82CA7396A68D541C85D26508E83_335745749 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_335745749 = getParameter(ParameterNamesIms.ICID_GENERATED_AT);
        varB4EAC82CA7396A68D541C85D26508E83_335745749.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_335745749;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ICID_GENERATED_AT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.290 -0400", hash_original_method = "F4508B4C04B9B92ED2D0B6FD3FCDD70F", hash_generated_method = "02E8850E20792337D964848D34BC0404")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.291 -0400", hash_original_method = "9C58F34D8EC32A5F098899E01B3677E3", hash_generated_method = "FBB4F3CAA9F84C998F64E091DD7C2AD1")
    public String getOriginatingIOI() {
        String varB4EAC82CA7396A68D541C85D26508E83_772898266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_772898266 = getParameter(ParameterNamesIms.ORIG_IOI);
        varB4EAC82CA7396A68D541C85D26508E83_772898266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_772898266;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.ORIG_IOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.291 -0400", hash_original_method = "4D1174A0C4FD1D4621AAA8C5BA456558", hash_generated_method = "CF165EA8AF19EEE067F7C6B7C2563209")
    public void setOriginatingIOI(String origIOI) throws ParseException {
        {
            boolean var92D070AC95721983DC0013EE99F4F26F_2042726473 = (origIOI == null || origIOI.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.292 -0400", hash_original_method = "D0795F3899C65FBD8AF4B39D420CBFCA", hash_generated_method = "141463DA54754808E59F644E14E078AD")
    public String getTerminatingIOI() {
        String varB4EAC82CA7396A68D541C85D26508E83_1672308243 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1672308243 = getParameter(ParameterNamesIms.TERM_IOI);
        varB4EAC82CA7396A68D541C85D26508E83_1672308243.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1672308243;
        // ---------- Original Method ----------
        //return getParameter(ParameterNamesIms.TERM_IOI);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.292 -0400", hash_original_method = "9F4DF1C8B170A0213F28AE6F8C15C36E", hash_generated_method = "85D91116BD0D4AE9C8A1A9066E417EE0")
    public void setTerminatingIOI(String termIOI) throws ParseException {
        {
            boolean var37A47FB02DC54A02839143740CF28C52_503565902 = (termIOI == null || termIOI.length() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:41.293 -0400", hash_original_method = "4B92A49D74A1215E0C3EC12D290AF61B", hash_generated_method = "263BB18DC54AB83D62E13F134B9FEB9D")
    public void setValue(String value) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new ParseException(value, 0);
        addTaint(value.getTaint());
        // ---------- Original Method ----------
        //throw new ParseException(value, 0);
    }

    
}

