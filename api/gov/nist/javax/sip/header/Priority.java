package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;

import javax.sip.header.PriorityHeader;

public class Priority extends SIPHeader implements PriorityHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.450 -0500", hash_original_field = "848E2B3143C5F231FA6514A1307BC5FE", hash_generated_field = "08C77E58ECE13B5F92FDDB2CA5776347")

    private static final long serialVersionUID = 3837543366074322106L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.454 -0500", hash_original_field = "62931C2B164572514472A308741C0A04", hash_generated_field = "974D541B27585CA7CCC3558FD38E5F46")

    public static final String EMERGENCY = ParameterNames.EMERGENCY;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.458 -0500", hash_original_field = "1F04EBCFD74E7FD4B4F9BC878863F113", hash_generated_field = "DC111FCED25D7B0BDCFAF701C81B9E39")

    public static final String URGENT = ParameterNames.URGENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.462 -0500", hash_original_field = "837FD7EB392AFB7D4D8BE19B493CFECD", hash_generated_field = "5C1C119AD4B0CA221BA8B1EA80B22E62")

    public static final String NORMAL = ParameterNames.NORMAL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.467 -0500", hash_original_field = "C2218FA553DF484EE682050CC00D5B43", hash_generated_field = "8E6E668A799B5A2A683603F90AA71AE4")

    public static final String NON_URGENT = ParameterNames.NON_URGENT;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.470 -0500", hash_original_field = "3AFE74759F73A0F8C851062A74D90B90", hash_generated_field = "3213DCF322A558FDF513E235035DAC3E")

    protected String priority;

    /** Default constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.474 -0500", hash_original_method = "33A980E78264A96D694E0BA8D4330749", hash_generated_method = "7FF26A4D98728ABCE057147217E7CBD7")
    
public Priority() {
        super(NAME);
    }

    /**
     * Encode into canonical form.
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.478 -0500", hash_original_method = "275A06F50E7B2077A23380B094FCE956", hash_generated_method = "B8740801FE90617FA5508CD7847DB756")
    
public String encodeBody() {
        return priority;
    }

    /**
     * get the priority value.
     * @return String
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.481 -0500", hash_original_method = "6DFC1BDF5FFE5EB6A183C3674CCE0974", hash_generated_method = "53896D5026D00DD79FACC76A82BCC15D")
    
public String getPriority() {
        return priority;
    }

    /**
     * Set the priority member
     * @param p String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:54:55.485 -0500", hash_original_method = "5B52FF98236754242B91AFCB31F1DBDC", hash_generated_method = "1294EA76144DDF20E2E1D0834E0174D1")
    
public void setPriority(String p) throws ParseException {
        if (p == null)
            throw new NullPointerException(
                "JAIN-SIP Exception,"
                    + "Priority, setPriority(), the priority parameter is null");
        priority = p;
    }
}

