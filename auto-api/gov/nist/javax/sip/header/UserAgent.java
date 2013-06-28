package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.*;
import java.text.ParseException;
import javax.sip.header.*;

public class UserAgent extends SIPHeader implements UserAgentHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.845 -0400", hash_original_field = "9688EFB908EECBA4C560247BC17C9D80", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.845 -0400", hash_original_method = "92D698CE7378CD097EA41B036334F01C", hash_generated_method = "96AC165CBEEAA1B39BCA167D71822187")
    public  UserAgent() {
        super(NAME);
        productTokens = new LinkedList();
        // ---------- Original Method ----------
        //productTokens = new LinkedList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.846 -0400", hash_original_method = "54509C1E79AD8AD51EA2FF1C763ECD71", hash_generated_method = "2884F30F0B3A7A574866C566E9210E15")
    private String encodeProduct() {
        String varB4EAC82CA7396A68D541C85D26508E83_193805878 = null; //Variable for return #1
        StringBuffer tokens = new StringBuffer();
        ListIterator it = productTokens.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_2136380416 = (it.hasNext());
            {
                tokens.append((String) it.next());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_193805878 = tokens.toString();
        varB4EAC82CA7396A68D541C85D26508E83_193805878.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_193805878;
        // ---------- Original Method ----------
        //StringBuffer tokens = new StringBuffer();
        //ListIterator it = productTokens.listIterator();
        //while (it.hasNext()) {
            //tokens.append((String) it.next());
        //}
        //return tokens.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.846 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "CEF2772B8F413B5DE4C8BE1EE4727C42")
    public void addProductToken(String pt) {
        productTokens.add(pt);
        addTaint(pt.getTaint());
        // ---------- Original Method ----------
        //productTokens.add(pt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.846 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "229A64653F1B958150E9049CE47490F7")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_508301447 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_508301447 = encodeProduct();
        varB4EAC82CA7396A68D541C85D26508E83_508301447.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_508301447;
        // ---------- Original Method ----------
        //return encodeProduct();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.847 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "69250FF7A5191C977053AD15C0E5B1A6")
    public ListIterator getProduct() {
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_422183373 = null; //Variable for return #1
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_2047217627 = null; //Variable for return #2
        {
            boolean var6FC43180604DFF08774360C95FED0CF9_503422475 = (productTokens == null || productTokens.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_422183373 = null;
            varB4EAC82CA7396A68D541C85D26508E83_2047217627 = productTokens.listIterator();
        } //End collapsed parenthetic
        ListIterator varA7E53CE21691AB073D9660D615818899_1886079247; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1886079247 = varB4EAC82CA7396A68D541C85D26508E83_422183373;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1886079247 = varB4EAC82CA7396A68D541C85D26508E83_2047217627;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1886079247.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1886079247;
        // ---------- Original Method ----------
        //if (productTokens == null || productTokens.isEmpty())
            //return null;
        //else
            //return productTokens.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.847 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "3149F1655FD6DBB53E41037D379F9BA7")
    public void setProduct(List product) throws ParseException {
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, UserAgent, "
                    + "setProduct(), the "
                    + " product parameter is null");
        productTokens = product;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, UserAgent, "
                    //+ "setProduct(), the "
                    //+ " product parameter is null");
        //productTokens = product;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.848 -0400", hash_original_method = "094FF844CCDBF62E3E868D88E09771A9", hash_generated_method = "070E487FF53C31D5299A3510AD3AEA5D")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1695047779 = null; //Variable for return #1
        UserAgent retval = (UserAgent) super.clone();
        retval.productTokens = new LinkedList (productTokens);
        varB4EAC82CA7396A68D541C85D26508E83_1695047779 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1695047779.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1695047779;
        // ---------- Original Method ----------
        //UserAgent retval = (UserAgent) super.clone();
        //if (productTokens != null)
            //retval.productTokens = new LinkedList (productTokens);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:40.848 -0400", hash_original_field = "628737300988B580B7DD5F8971B3688D", hash_generated_field = "2C0F80EC4F90746F4C9912D192AB89F6")

    private static final long serialVersionUID = 4561239179796364295L;
}

