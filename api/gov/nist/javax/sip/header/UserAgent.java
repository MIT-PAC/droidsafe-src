package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.sip.header.UserAgentHeader;






public class UserAgent extends SIPHeader implements UserAgentHeader {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.733 -0500", hash_original_field = "B8CCD547FBEB7B061170555E48F0C532", hash_generated_field = "2C0F80EC4F90746F4C9912D192AB89F6")

    private static final long serialVersionUID = 4561239179796364295L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.736 -0500", hash_original_field = "653407BF74D72644FCAA011418913E1D", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;

    /**
     * Constructor.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.744 -0500", hash_original_method = "92D698CE7378CD097EA41B036334F01C", hash_generated_method = "B26AE426956163A1512FF8A689376196")
    
public UserAgent() {
        super(NAME);
        productTokens = new LinkedList();
    }

    /**
     * Return canonical form.
     * pmusgrave - put a space between products (preserves format of header)
     * @return String
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.738 -0500", hash_original_method = "54509C1E79AD8AD51EA2FF1C763ECD71", hash_generated_method = "A4A0537B9EE87D097717447006422A87")
    
private String encodeProduct() {
        StringBuffer tokens = new StringBuffer();
        ListIterator it = productTokens.listIterator();

        while (it.hasNext()) {
            tokens.append((String) it.next());

        }
        return tokens.toString();
    }

    /** set the productToken field
     * @param pt String to set
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.741 -0500", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "783A8969227B068302CF8EEB89CF506B")
    
public void addProductToken(String pt) {
        productTokens.add(pt);
    }

    /** Encode only the body of this header.
    *@return encoded value of the header.
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.747 -0500", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "21389218728DC2B181D1950BEC50F95B")
    
public String encodeBody() {
        return encodeProduct();
    }

    /**
    * Returns the list value of the product parameter.
    *
    * @return the software of this UserAgentHeader
    */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.750 -0500", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "C9C3D2F5F5748D4E71625F3B55C13941")
    
public ListIterator getProduct() {
        if (productTokens == null || productTokens.isEmpty())
            return null;
        else
            return productTokens.listIterator();
    }

    /**
     * Sets the product value of the UserAgentHeader.
     *
     * @param product - a List specifying the product value
     * @throws ParseException which signals that an error has been reached
     * unexpectedly while parsing the product value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.753 -0500", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "A1C0FB2108C269FB3ADADC9F9320B0E3")
    
public void setProduct(List product) throws ParseException {
        if (product == null)
            throw new NullPointerException(
                "JAIN-SIP Exception, UserAgent, "
                    + "setProduct(), the "
                    + " product parameter is null");
        productTokens = product;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:11.755 -0500", hash_original_method = "094FF844CCDBF62E3E868D88E09771A9", hash_generated_method = "520A720000C75579FBEBB115919D7403")
    
public Object clone() {
        UserAgent retval = (UserAgent) super.clone();
        if (productTokens != null)
            retval.productTokens = new LinkedList (productTokens);
        return retval;
    }
}

