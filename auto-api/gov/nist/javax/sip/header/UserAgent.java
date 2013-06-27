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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.962 -0400", hash_original_field = "9688EFB908EECBA4C560247BC17C9D80", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.963 -0400", hash_original_method = "92D698CE7378CD097EA41B036334F01C", hash_generated_method = "96AC165CBEEAA1B39BCA167D71822187")
    public  UserAgent() {
        super(NAME);
        productTokens = new LinkedList();
        // ---------- Original Method ----------
        //productTokens = new LinkedList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.980 -0400", hash_original_method = "54509C1E79AD8AD51EA2FF1C763ECD71", hash_generated_method = "99B25E00712789FF544E8E2F9085678A")
    private String encodeProduct() {
        String varB4EAC82CA7396A68D541C85D26508E83_268007890 = null; //Variable for return #1
        StringBuffer tokens;
        tokens = new StringBuffer();
        ListIterator it;
        it = productTokens.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_16919435 = (it.hasNext());
            {
                tokens.append((String) it.next());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_268007890 = tokens.toString();
        varB4EAC82CA7396A68D541C85D26508E83_268007890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_268007890;
        // ---------- Original Method ----------
        //StringBuffer tokens = new StringBuffer();
        //ListIterator it = productTokens.listIterator();
        //while (it.hasNext()) {
            //tokens.append((String) it.next());
        //}
        //return tokens.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.980 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "CEF2772B8F413B5DE4C8BE1EE4727C42")
    public void addProductToken(String pt) {
        productTokens.add(pt);
        addTaint(pt.getTaint());
        // ---------- Original Method ----------
        //productTokens.add(pt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.981 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "384B8DEB91F63489140736C4F14ABB4C")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_536647036 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_536647036 = encodeProduct();
        varB4EAC82CA7396A68D541C85D26508E83_536647036.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_536647036;
        // ---------- Original Method ----------
        //return encodeProduct();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.982 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "660B241B037A98E18F41EC7FCE89A1BE")
    public ListIterator getProduct() {
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_714343996 = null; //Variable for return #1
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_136487139 = null; //Variable for return #2
        {
            boolean var6FC43180604DFF08774360C95FED0CF9_1130550809 = (productTokens == null || productTokens.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_714343996 = null;
            varB4EAC82CA7396A68D541C85D26508E83_136487139 = productTokens.listIterator();
        } //End collapsed parenthetic
        ListIterator varA7E53CE21691AB073D9660D615818899_67189799; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_67189799 = varB4EAC82CA7396A68D541C85D26508E83_714343996;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_67189799 = varB4EAC82CA7396A68D541C85D26508E83_136487139;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_67189799.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_67189799;
        // ---------- Original Method ----------
        //if (productTokens == null || productTokens.isEmpty())
            //return null;
        //else
            //return productTokens.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.982 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "3149F1655FD6DBB53E41037D379F9BA7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.983 -0400", hash_original_method = "094FF844CCDBF62E3E868D88E09771A9", hash_generated_method = "06843EC9D1CDFD5EB68E5891F7053F10")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_136151515 = null; //Variable for return #1
        UserAgent retval;
        retval = (UserAgent) super.clone();
        retval.productTokens = new LinkedList (productTokens);
        varB4EAC82CA7396A68D541C85D26508E83_136151515 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_136151515.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_136151515;
        // ---------- Original Method ----------
        //UserAgent retval = (UserAgent) super.clone();
        //if (productTokens != null)
            //retval.productTokens = new LinkedList (productTokens);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:31.983 -0400", hash_original_field = "628737300988B580B7DD5F8971B3688D", hash_generated_field = "BCA42D6E6C45595BA4F46267EB404D1D")

    private static long serialVersionUID = 4561239179796364295L;
}

