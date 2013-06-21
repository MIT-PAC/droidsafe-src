package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import javax.sip.header.*;
import java.util.*;

public class Server extends SIPHeader implements ServerHeader {
    protected List productTokens;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.404 -0400", hash_original_method = "28A485C01704A957BCAF31556583EFBE", hash_generated_method = "305518061AF0A2CB840B318B99F5BA97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Server() {
        super(NAME);
        productTokens = new LinkedList();
        // ---------- Original Method ----------
        //productTokens = new LinkedList();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.405 -0400", hash_original_method = "3BD03A3FDC86F025553E39D4B6A63060", hash_generated_method = "D4A628EEF3263464E77683AA330D4577")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private String encodeProduct() {
        StringBuffer tokens;
        tokens = new StringBuffer();
        ListIterator it;
        it = productTokens.listIterator();
        {
            boolean var03729FD53960D8DCA3A41A13A0229637_825437619 = (it.hasNext());
            {
                tokens.append((String) it.next());
                {
                    boolean var3DEC40B862508A9A2151C7EC9CE55CF3_2040483374 = (it.hasNext());
                    tokens.append('/');
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        String var7DBC0F2E4AEDC48970B4989A3308D8BE_722201054 = (tokens.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //StringBuffer tokens = new StringBuffer();
        //ListIterator it = productTokens.listIterator();
        //while (it.hasNext()) {
            //tokens.append((String) it.next());
            //if (it.hasNext())
                //tokens.append('/');
            //else
                //break;
        //}
        //return tokens.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.405 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "6E10DB1ACE154C02AD2F26B35AED4225")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addProductToken(String pt) {
        dsTaint.addTaint(pt);
        productTokens.add(pt);
        // ---------- Original Method ----------
        //productTokens.add(pt);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.405 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "2853E64EC4EA6E826B70B5B1BA4E6878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String encodeBody() {
        String var984163E8FCEB355C5D2B1D89AEFA14BA_1229072640 = (encodeProduct());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return encodeProduct();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.405 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "D5E0569E8CBC925B74350BE0EA44006F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ListIterator getProduct() {
        {
            boolean var6FC43180604DFF08774360C95FED0CF9_543301348 = (productTokens == null || productTokens.isEmpty());
            ListIterator var846D9087D1B8085D500F0D550A98BAC7_1574168688 = (productTokens.listIterator());
        } //End collapsed parenthetic
        return (ListIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (productTokens == null || productTokens.isEmpty())
            //return null;
        //else
            //return productTokens.listIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:21.405 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "AC58FC4AF910AA90AB217241A3C17762")
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

    
    private static final long serialVersionUID = -3587764149383342973L;
}

