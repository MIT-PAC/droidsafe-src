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
    protected List productTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.450 -0400", hash_original_method = "92D698CE7378CD097EA41B036334F01C", hash_generated_method = "96AC165CBEEAA1B39BCA167D71822187")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UserAgent() {
        super(NAME);
        productTokens = new LinkedList();
        // ---------- Original Method ----------
        //productTokens = new LinkedList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.450 -0400", hash_original_method = "54509C1E79AD8AD51EA2FF1C763ECD71", hash_generated_method = "B72B741A98F3E692889F091994C0F942")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String encodeProduct() {
        StringBuffer tokens;
        tokens = new StringBuffer();
        ListIterator it;
        it = productTokens.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_104435962 = (it.hasNext());
            {
                tokens.append((String) it.next());
            } //End block
        } //End collapsed parenthetic
        String var7DBC0F2E4AEDC48970B4989A3308D8BE_1545212352 = (tokens.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer tokens = new StringBuffer();
        //ListIterator it = productTokens.listIterator();
        //while (it.hasNext()) {
            //tokens.append((String) it.next());
        //}
        //return tokens.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.451 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "6E10DB1ACE154C02AD2F26B35AED4225")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addProductToken(String pt) {
        dsTaint.addTaint(pt);
        productTokens.add(pt);
        // ---------- Original Method ----------
        //productTokens.add(pt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.451 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "37ABEF3094B078FC31C0FA0C94D47D71")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var984163E8FCEB355C5D2B1D89AEFA14BA_608832209 = (encodeProduct());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeProduct();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.451 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "C8EC61A8708A7C4DB38B19C493DA1C18")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator getProduct() {
        {
            boolean var6FC43180604DFF08774360C95FED0CF9_98937474 = (productTokens == null || productTokens.isEmpty());
            ListIterator var846D9087D1B8085D500F0D550A98BAC7_1777888768 = (productTokens.listIterator());
        } //End collapsed parenthetic
        return (ListIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (productTokens == null || productTokens.isEmpty())
            //return null;
        //else
            //return productTokens.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.451 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "AC58FC4AF910AA90AB217241A3C17762")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setProduct(List product) throws ParseException {
        dsTaint.addTaint(product.dsTaint);
        if (DroidSafeAndroidRuntime.control) throw new NullPointerException(
                "JAIN-SIP Exception, UserAgent, "
                    + "setProduct(), the "
                    + " product parameter is null");
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, UserAgent, "
                    //+ "setProduct(), the "
                    //+ " product parameter is null");
        //productTokens = product;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.451 -0400", hash_original_method = "094FF844CCDBF62E3E868D88E09771A9", hash_generated_method = "8EDDC275BC2CB46ECF2A5FB9757AFE39")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object clone() {
        UserAgent retval;
        retval = (UserAgent) super.clone();
        retval.productTokens = new LinkedList (productTokens);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //UserAgent retval = (UserAgent) super.clone();
        //if (productTokens != null)
            //retval.productTokens = new LinkedList (productTokens);
        //return retval;
    }

    
    private static final long serialVersionUID = 4561239179796364295L;
}

