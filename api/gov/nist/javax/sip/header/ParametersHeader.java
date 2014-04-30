package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.core.DuplicateNameValueList;
import gov.nist.core.NameValue;
import gov.nist.core.NameValueList;
import gov.nist.javax.sip.address.GenericURI;

import java.io.Serializable;
import java.text.ParseException;
import java.util.Iterator;

import javax.sip.header.Parameters;

public abstract class ParametersHeader extends SIPHeader implements javax.sip.header.Parameters, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.665 -0500", hash_original_field = "C664820D6996E8B6AE3D3EE9831870E4", hash_generated_field = "B548841E6A98CD05129EEE1E20049B8B")

    protected NameValueList parameters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.668 -0500", hash_original_field = "B025CE6F0FCD256B20032C6DF23F4DBA", hash_generated_field = "2A6C410AA135B90D8494B5D88641CA12")
    
    protected DuplicateNameValueList duplicates;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.672 -0500", hash_original_method = "F0D4DB9CA1B200FF922CDFAC26AB7615", hash_generated_method = "91FA51006E0B9AB91F2A71115C8E62B5")
    
protected ParametersHeader() {
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.675 -0500", hash_original_method = "E4E2AFF581813A14FAEFEBD8E59AE8BB", hash_generated_method = "4E7E13D660C8B3FE82081B874E63C794")
    
protected ParametersHeader(String hdrName) {
        super(hdrName);
        this.parameters = new NameValueList();
        this.duplicates = new DuplicateNameValueList();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.679 -0500", hash_original_method = "768F25D8932AE20C63265B0976D807A2", hash_generated_method = "222D71199A93AE384209B5E35D93E627")
    
protected ParametersHeader(String hdrName, boolean sync) {
        super(hdrName);
        this.parameters = new NameValueList(sync);
        this.duplicates = new DuplicateNameValueList();
    }

    /**
     * Returns the value of the named parameter, or null if it is not set. A
     * zero-length String indicates flag parameter.
     *
     * @param name name of parameter to retrieve
     * @return the value of specified parameter
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.681 -0500", hash_original_method = "26B228E241B115E8361AA59B6E98DF15", hash_generated_method = "31EFF6210CF37131C11D083B7519391C")
    
public String getParameter(String name) {
        return this.parameters.getParameter(name);

    }

    /**
     * Return the parameter as an object (dont convert to string).
     *
     * @param name is the name of the parameter to get.
     * @return the object associated with the name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.685 -0500", hash_original_method = "950E84B179C4A06D00A5F96F379F35ED", hash_generated_method = "E7BC0F66294219D683B38F0CDBF3EC75")
    
public Object getParameterValue(String name) {
        return this.parameters.getValue(name);
    }

    /**
     * Returns an Iterator over the names (Strings) of all parameters present
     * in this ParametersHeader.
     *
     * @return an Iterator over all the parameter names
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.688 -0500", hash_original_method = "73DEE1BD3D15BA621CE057B5FCA7616C", hash_generated_method = "031CF79A9E4C2FEE480AFEEAF1A2F5BE")
    
public Iterator<String> getParameterNames() {
        return parameters.getNames();
    }

    /** Return true if you have a parameter and false otherwise.
     *
     *@return true if the parameters list is non-empty.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.691 -0500", hash_original_method = "FADD6078F02861D57363D501F4F9C95B", hash_generated_method = "69142FAA89E0F86E9E4838FE38673FA8")
    
public boolean hasParameters() {
        return parameters != null && !parameters.isEmpty();
    }

    /**
    * Removes the specified parameter from Parameters of this ParametersHeader.
    * This method returns silently if the parameter is not part of the
    * ParametersHeader.
    *
    * @param name - a String specifying the parameter name
    */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.693 -0500", hash_original_method = "8227CAC727290506BDAB40EEA1175C4E", hash_generated_method = "D94FC4EE0C4B4D7127D6943B54D618DF")
    
public void removeParameter(String name) {
        this.parameters.delete(name);
    }

    /**
     * Sets the value of the specified parameter. If the parameter already had
     *
     * a value it will be overwritten. A zero-length String indicates flag
     *
     * parameter.
     *
     *
     *
     * @param name - a String specifying the parameter name
     *
     * @param value - a String specifying the parameter value
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the parameter name or value.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.697 -0500", hash_original_method = "DC6AABD6CB8C91F923D2D5F7703B6CF1", hash_generated_method = "8417AC290EAECFB45642310E36775B2F")
    
public void setParameter(String name, String value) throws ParseException {
        NameValue nv = parameters.getNameValue(name);
        if (nv != null) {
            nv.setValueAsObject(value);
        } else {
            nv = new NameValue(name, value);
            this.parameters.set(nv);
        }
    }
    
    /**
     * Sets the value of the specified parameter. If the parameter already had
     *
     * a value it will be overwritten. A zero-length String indicates flag
     *
     * parameter.
     *
     *
     *
     * @param name - a String specifying the parameter name
     *
     * @param value - a String specifying the parameter value
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the parameter name or value.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.700 -0500", hash_original_method = "982C7BF5F52C5CB066896B5A4FF02FB5", hash_generated_method = "8F4A6F3FE6F1FD8A29C2BD76F253CD44")
    
public void setQuotedParameter(String name, String value)
        throws ParseException {
        NameValue nv = parameters.getNameValue(name);
        if (nv != null) {
            nv.setValueAsObject(value);
            nv.setQuotedValue();
        } else {
            nv = new NameValue(name, value);
            nv.setQuotedValue();
            this.parameters.set(nv);
        }
    }

    /**
     * Sets the value of the specified parameter. If the parameter already had
     *
     * a value it will be overwritten.
     *
     *
     * @param name - a String specifying the parameter name
     *
     * @param value - an int specifying the parameter value
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the parameter name or value.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.703 -0500", hash_original_method = "8F6FACDCF2BE80409FBAB3E7E4602B1E", hash_generated_method = "A9C0399F6FA043C3E09831D594342EA9")
    
protected void setParameter(String name, int value) {
        Integer val = Integer.valueOf(value);
        this.parameters.set(name,val);

    }

    /**
     * Sets the value of the specified parameter. If the parameter already had
     *
     * a value it will be overwritten.
     *
     *
     * @param name - a String specifying the parameter name
     *
     * @param value - a boolean specifying the parameter value
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the parameter name or value.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.705 -0500", hash_original_method = "A43053EB8AE25416B5AFA5C2C0F13D2F", hash_generated_method = "366BE33E21F4621C8CE2C0209C1FD4A9")
    
protected void setParameter(String name, boolean value) {
        Boolean val = Boolean.valueOf(value);
        this.parameters.set(name,val);
    }

    /**
     * Sets the value of the specified parameter. If the parameter already had
     *
     * a value it will be overwritten.
     *
     * @param name - a String specifying the parameter name
     *
     * @param value - a boolean specifying the parameter value
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the parameter name or value.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.708 -0500", hash_original_method = "9588AB5C73A4CC192FA4DE06D052A58D", hash_generated_method = "DFD33741AD27187D5646FFCF41923255")
    
protected void setParameter(String name, float value) {
        Float val = Float.valueOf(value);
        NameValue nv = parameters.getNameValue(name);
        if (nv != null) {
            nv.setValueAsObject(val);
        } else {
            nv = new NameValue(name, val);
            this.parameters.set(nv);
        }
    }

    /**
     * Sets the value of the specified parameter. If the parameter already had
     *
     * a value it will be overwritten. A zero-length String indicates flag
     *
     * parameter.
     *
     *
     *
     * @param name - a String specifying the parameter name
     *
     * @param value - a String specifying the parameter value
     *
     * @throws ParseException which signals that an error has been reached
     *
     * unexpectedly while parsing the parameter name or value.
     *
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.711 -0500", hash_original_method = "69DF71CB140C2C1EC9DCD8B4F4E0A5EC", hash_generated_method = "E73066686DDAFDAEC1E193249D3CE259")
    
protected void setParameter(String name, Object value) {
        this.parameters.set(name,value);
    }

    /**
     * Return true if has a parameter.
     *
     * @param parameterName is the name of the parameter.
     *
     * @return true if the parameter exists and false if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.714 -0500", hash_original_method = "0E176A220CDCDA920F0996E000E16A8D", hash_generated_method = "6A80AF7EB8043AA7CA7462D51645060B")
    
public boolean hasParameter(String parameterName) {
        return this.parameters.hasNameValue(parameterName);
    }

    /**
     *Remove all parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.717 -0500", hash_original_method = "65E5BFE21C1CDA8F26E2E41D0A6B9EA1", hash_generated_method = "FEB19BDF6C48318BE0B58F89BDED0DC6")
    
public void removeParameters() {
        this.parameters = new NameValueList();
    }

    /**
     * get the parameter list.
     * @return parameter list
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.721 -0500", hash_original_method = "49747860C8C48A5B3F7CFA7B7258A693", hash_generated_method = "C29AE1FE64FECC89D737FDDB367A0855")
    
public NameValueList getParameters() {
        return parameters;
    }

    /** Set the parameter given a name and value.
     *
     * @param nameValue - the name value of the parameter to set.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.724 -0500", hash_original_method = "D7D233790E2C90411F60E8102439D486", hash_generated_method = "F56D1A4B7D39B03A6600C9ACED254E2F")
    
public void setParameter(NameValue nameValue) {
        this.parameters.set(nameValue);
    }

    /**
     * Set the parameter list.
     *
     * @param parameters The name value list to set as the parameter list.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.727 -0500", hash_original_method = "4B4FC4972A60A318528A3B65D835B0D7", hash_generated_method = "47E0966AB1ECC2B51A9E1E02DD61E113")
    
public void setParameters(NameValueList parameters) {
        this.parameters = parameters;
    }

    /**
     * Get the parameter as an integer value.
     *
     * @param parameterName -- the parameter name to fetch.
     *
     * @return -1 if the parameter is not defined in the header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.730 -0500", hash_original_method = "65FA1152003E641D893D3A6B303652A1", hash_generated_method = "C949BE3D1C7809C46595142264C62F0A")
    
protected int getParameterAsInt(String parameterName) {
        if (this.getParameterValue(parameterName) != null) {
            try {
                if (this.getParameterValue(parameterName) instanceof String) {
                    return Integer.parseInt(this.getParameter(parameterName));
                } else {
                    return ((Integer) getParameterValue(parameterName))
                        .intValue();
                }
            } catch (NumberFormatException ex) {
                return -1;
            }
        } else
            return -1;
    }

    /** Get the parameter as an integer when it is entered as a hex.
     *
     *@param parameterName -- The parameter name to fetch.
     *
     *@return -1 if the parameter is not defined in the header.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.733 -0500", hash_original_method = "9C527B386FBBF95319BB18882D2DDAF1", hash_generated_method = "08B2339A2E7F1E6C305DC750B48660FF")
    
protected int getParameterAsHexInt(String parameterName) {
        if (this.getParameterValue(parameterName) != null) {
            try {
                if (this.getParameterValue(parameterName) instanceof String) {
                    return Integer.parseInt(
                        this.getParameter(parameterName),
                        16);
                } else {
                    return ((Integer) getParameterValue(parameterName))
                        .intValue();
                }
            } catch (NumberFormatException ex) {
                return -1;
            }
        } else
            return -1;
    }

    /** Get the parameter as a float value.
     *
     *@param parameterName -- the parameter name to fetch
     *
     *@return -1 if the parameter is not defined or the parameter as a float.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.736 -0500", hash_original_method = "B4454BBF4B067318BED7FA4306F23669", hash_generated_method = "36EF1C098CABD38F973CFAF33B0DC073")
    
protected float getParameterAsFloat(String parameterName) {

        if (this.getParameterValue(parameterName) != null) {
            try {
                if (this.getParameterValue(parameterName) instanceof String) {
                    return Float.parseFloat(this.getParameter(parameterName));
                } else {
                    return ((Float) getParameterValue(parameterName))
                        .floatValue();
                }
            } catch (NumberFormatException ex) {
                return -1;
            }
        } else
            return -1;
    }

    /**
     * Get the parameter as a long value.
     *
     * @param parameterName -- the parameter name to fetch.
     *
     * @return -1 if the parameter is not defined or the parameter as a long.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.739 -0500", hash_original_method = "82A00B489AC355D0514D4F867ADC7246", hash_generated_method = "9BF42E6BACFACF05A2BBB756983582E0")
    
protected long getParameterAsLong(String parameterName) {
        if (this.getParameterValue(parameterName) != null) {
            try {
                if (this.getParameterValue(parameterName) instanceof String) {
                    return Long.parseLong(this.getParameter(parameterName));
                } else {
                    return ((Long) getParameterValue(parameterName))
                        .longValue();
                }
            } catch (NumberFormatException ex) {
                return -1;
            }
        } else
            return -1;
    }

    /**
     * Get the parameter value as a URI.
     *
     * @param parameterName -- the parameter name
     *
     * @return value of the parameter as a URI or null if the parameter
     *  not present.
     */
    @DSSource({DSSourceKind.FILE_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.742 -0500", hash_original_method = "2454B831ED2FA559675B54C9AA305ADF", hash_generated_method = "1A543E6EE869FA57023DD015B7F804AB")
    
protected GenericURI getParameterAsURI(String parameterName) {
        Object val = getParameterValue(parameterName);
        if (val instanceof GenericURI)
            return (GenericURI) val;
        else {
            try {
                return new GenericURI((String) val);
            } catch (ParseException ex) {
                //catch ( URISyntaxException ex) {
                return null;
            }
        }
    }

    /**
     * Get the parameter value as a boolean.
     *
     * @param parameterName -- the parameter name
     * @return boolean value of the parameter.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.745 -0500", hash_original_method = "1DB3A708311EDCC43D7A461B84D39940", hash_generated_method = "D2480EA822512FE505A1020F99874388")
    
protected boolean getParameterAsBoolean(String parameterName) {
        Object val = getParameterValue(parameterName);
        if (val == null) {
            return false;
        } else if (val instanceof Boolean) {
            return ((Boolean) val).booleanValue();
        } else if (val instanceof String) {
            return Boolean.valueOf((String) val).booleanValue();
        } else
            return false;
    }

    /**
     * This is for the benifit of the TCK.
     *
     * @return the name value pair for the given parameter name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.748 -0500", hash_original_method = "E1D4D51519E24D2E630FAA93B019FD38", hash_generated_method = "077DA06C42B11F06351811EC2A8B27D8")
    
public NameValue getNameValue(String parameterName) {
        return parameters.getNameValue(parameterName);
    }
 
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.752 -0500", hash_original_method = "F88B366B00368248D268BF74B5E64B34", hash_generated_method = "47E75B2A211C27917A050BCF7BCF4612")
    
public Object clone() {
        ParametersHeader retval = (ParametersHeader) super.clone();
        if (this.parameters != null)
            retval.parameters = (NameValueList) this.parameters.clone();
        return retval;
    }

    //-------------------------
    /**
     * Introduced specifically for the P-Charging-Function-Addresses Header and 
     * all other headers that may have multiple header parameters of the same name, but 
     * with multiple possible values.
     * 
     * Example: P-Charging-Function-Addresses: ccf=[5555::b99:c88:d77:e66]; ccf=[5555::a55:b44:c33:d22]; 
     *                                         ecf=[5555::1ff:2ee:3dd:4cc]; ecf=[5555::6aa:7bb:8cc:9dd]
     * @param name of the parameter
     * @param value of the parameter
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.755 -0500", hash_original_method = "386D6A280C48B0DE53357DBAEAE91419", hash_generated_method = "71CB24B84DF255AA1F7CFCE56DFE598A")
    
public void setMultiParameter(String name, String value)
    {
    	NameValue nv = new NameValue();
    	nv.setName(name);
    	nv.setValue(value);
    	duplicates.set(nv);
    }
    
    /** Set the parameter given a name and value.
    *
    * @param nameValue - the name value of the parameter to set.
    */
   @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.757 -0500", hash_original_method = "7EC6FF3874184BDFD4677A471AD4F84B", hash_generated_method = "32F76180954C621FEA4A01FE9A15C460")
    
public void setMultiParameter(NameValue nameValue) {
       this.duplicates.set(nameValue);
   }
    
    /**
     * Returns the parameter name
     * @param name
     * @return
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.761 -0500", hash_original_method = "AA35E6B35A009A15DE022941ACB0B490", hash_generated_method = "8921DA316EB3F30B6AE8F1585F335385")
    
public String getMultiParameter(String name) {
        return this.duplicates.getParameter(name);

    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.763 -0500", hash_original_method = "5A021F5792300443FECC73E0DD310EC6", hash_generated_method = "E56CD5221D22EA2D809209CA392371E4")
    
public DuplicateNameValueList getMultiParameters() {
        return duplicates;
    }
    
    /**
     * Return the parameter as an object (dont convert to string).
     *
     * @param name is the name of the parameter to get.
     * @return the object associated with the name.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.766 -0500", hash_original_method = "19E7E271B86B1511C96CA4313B229FF4", hash_generated_method = "5F03D3C93B87358A0264993FA39DE8ED")
    
public Object getMultiParameterValue(String name) {
        return this.duplicates.getValue(name);
    }

    /**
     * Returns an Iterator over the names (Strings) of all parameters present
     * in this ParametersHeader.
     *
     * @return an Iterator over all the parameter names
     */

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.770 -0500", hash_original_method = "66D882806A955FACE11E379F1822F80D", hash_generated_method = "BE27918254B85DAF20CE42FC0F6812E9")
    
public Iterator<String> getMultiParameterNames() {
        return duplicates.getNames();
    }

    /** Return true if you have a parameter and false otherwise.
     *
     *@return true if the parameters list is non-empty.
     */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.773 -0500", hash_original_method = "99BB2C1C0575811C3E3EF00DA4E34F61", hash_generated_method = "255C39A11AD0447319A5339DA4561809")
    
public boolean hasMultiParameters() {
        return duplicates != null && !duplicates.isEmpty();
    }

    /**
    * Removes the specified parameter from Parameters of this ParametersHeader.
    * This method returns silently if the parameter is not part of the
    * ParametersHeader.
    *
    * @param name - a String specifying the parameter name
    */

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.775 -0500", hash_original_method = "7FB2DD7BAF4E3CE7B6C756EF57D6475D", hash_generated_method = "B82C888A0A87DEC25615F0098C29A0E5")
    
public void removeMultiParameter(String name) {
        this.duplicates.delete(name);
    }
    
    /**
     * Return true if has a parameter.
     *
     * @param parameterName is the name of the parameter.
     *
     * @return true if the parameter exists and false if not.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.778 -0500", hash_original_method = "4900377F50A662E0A9B40AE1199FCE72", hash_generated_method = "B42DFAC02BE2A306764B1A1BD3B3E79B")
    
public boolean hasMultiParameter(String parameterName) {
        return this.duplicates.hasNameValue(parameterName);
    }

    /**
     *Remove all parameters.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.781 -0500", hash_original_method = "2530F738F22D5C4CA96462C28290A063", hash_generated_method = "5EF3A68B6A1637E02156D7B38A535879")
    
public void removeMultiParameters() {
        this.duplicates = new DuplicateNameValueList();
    }

    //-------------------------------
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.785 -0500", hash_original_method = "A37B23ECE5B3E77BF1561677FE6ED233", hash_generated_method = "1B28013159E483AD42721FC6A9869196")
    
@SuppressWarnings("unchecked")
    protected final boolean equalParameters( Parameters other ) {
        if (this==other) return true;

        for ( Iterator i = this.getParameterNames(); i.hasNext();) {
            String pname = (String) i.next();

            String p1 = this.getParameter( pname );
            String p2 = other.getParameter( pname );

            // getting them based on this.getParameterNames. Note that p1 may be null
            // if this is a name-only parameter like rport or lr.
            if (p1 == null ^ p2 == null) return false;
            else if (p1 != null && !p1.equalsIgnoreCase(p2) ) return false;
        }

        // Also compare other's parameters; some duplicate testing here...
        for ( Iterator i = other.getParameterNames(); i.hasNext();) {
            String pname = (String) i.next();

            String p1 = other.getParameter( pname );
            String p2 = this.getParameter( pname );

                // assert( p1 != null );
            // if ( p1 == null ) throw new RuntimeException("Assertion check failed!");
            // if (p2==null) return false;

            // getting them based on this.getParameterNames. Note that p1 may be null
            // if this is a name-only parameter like rport or lr.

            if (p1 == null ^ p2 == null) return false;
            else if (p1 != null && !p1.equalsIgnoreCase(p2) ) return false;
        }

        return true;
    }
    
    // ----------- Abstract methods --------------
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:04.788 -0500", hash_original_method = "174EBB1808D17B56AB5E004277B62194", hash_generated_method = "67C6A1D41F49045B75F8C639C65C4404")
    
protected abstract String encodeBody();
    
}

