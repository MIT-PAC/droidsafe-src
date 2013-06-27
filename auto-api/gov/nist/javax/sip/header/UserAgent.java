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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.756 -0400", hash_original_field = "9688EFB908EECBA4C560247BC17C9D80", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.757 -0400", hash_original_method = "92D698CE7378CD097EA41B036334F01C", hash_generated_method = "96AC165CBEEAA1B39BCA167D71822187")
    public  UserAgent() {
        super(NAME);
        productTokens = new LinkedList();
        // ---------- Original Method ----------
        //productTokens = new LinkedList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.757 -0400", hash_original_method = "54509C1E79AD8AD51EA2FF1C763ECD71", hash_generated_method = "DA39909CCDB891E1F66285D8CF042178")
    private String encodeProduct() {
        String varB4EAC82CA7396A68D541C85D26508E83_585110806 = null; //Variable for return #1
        StringBuffer tokens;
        tokens = new StringBuffer();
        ListIterator it;
        it = productTokens.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_828792063 = (it.hasNext());
            {
                tokens.append((String) it.next());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_585110806 = tokens.toString();
        varB4EAC82CA7396A68D541C85D26508E83_585110806.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_585110806;
        // ---------- Original Method ----------
        //StringBuffer tokens = new StringBuffer();
        //ListIterator it = productTokens.listIterator();
        //while (it.hasNext()) {
            //tokens.append((String) it.next());
        //}
        //return tokens.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.758 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "CEF2772B8F413B5DE4C8BE1EE4727C42")
    public void addProductToken(String pt) {
        productTokens.add(pt);
        addTaint(pt.getTaint());
        // ---------- Original Method ----------
        //productTokens.add(pt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.758 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "59E8D3DFF332E3DAE9BE8DADD1B831DB")
    public String encodeBody() {
        String varB4EAC82CA7396A68D541C85D26508E83_34227121 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_34227121 = encodeProduct();
        varB4EAC82CA7396A68D541C85D26508E83_34227121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_34227121;
        // ---------- Original Method ----------
        //return encodeProduct();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.772 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "7B42E72E6613B5F216D20C2DB7D3A5F0")
    public ListIterator getProduct() {
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_1648041578 = null; //Variable for return #1
        ListIterator varB4EAC82CA7396A68D541C85D26508E83_2059724817 = null; //Variable for return #2
        {
            boolean var6FC43180604DFF08774360C95FED0CF9_597742873 = (productTokens == null || productTokens.isEmpty());
            varB4EAC82CA7396A68D541C85D26508E83_1648041578 = null;
            varB4EAC82CA7396A68D541C85D26508E83_2059724817 = productTokens.listIterator();
        } //End collapsed parenthetic
        ListIterator varA7E53CE21691AB073D9660D615818899_181558405; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_181558405 = varB4EAC82CA7396A68D541C85D26508E83_1648041578;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_181558405 = varB4EAC82CA7396A68D541C85D26508E83_2059724817;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_181558405.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_181558405;
        // ---------- Original Method ----------
        //if (productTokens == null || productTokens.isEmpty())
            //return null;
        //else
            //return productTokens.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.772 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "3149F1655FD6DBB53E41037D379F9BA7")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.772 -0400", hash_original_method = "094FF844CCDBF62E3E868D88E09771A9", hash_generated_method = "5FF16E74EB8BACB2690FBCB28B46762B")
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1156950405 = null; //Variable for return #1
        UserAgent retval;
        retval = (UserAgent) super.clone();
        retval.productTokens = new LinkedList (productTokens);
        varB4EAC82CA7396A68D541C85D26508E83_1156950405 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1156950405.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1156950405;
        // ---------- Original Method ----------
        //UserAgent retval = (UserAgent) super.clone();
        //if (productTokens != null)
            //retval.productTokens = new LinkedList (productTokens);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:32.773 -0400", hash_original_field = "628737300988B580B7DD5F8971B3688D", hash_generated_field = "BCA42D6E6C45595BA4F46267EB404D1D")

    private static long serialVersionUID = 4561239179796364295L;
}

