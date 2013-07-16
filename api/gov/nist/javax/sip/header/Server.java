package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import javax.sip.header.*;
import java.util.*;

public class Server extends SIPHeader implements ServerHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.417 -0400", hash_original_field = "9688EFB908EECBA4C560247BC17C9D80", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.418 -0400", hash_original_method = "28A485C01704A957BCAF31556583EFBE", hash_generated_method = "305518061AF0A2CB840B318B99F5BA97")
    public  Server() {
        super(NAME);
        productTokens = new LinkedList();
        // ---------- Original Method ----------
        //productTokens = new LinkedList();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.418 -0400", hash_original_method = "3BD03A3FDC86F025553E39D4B6A63060", hash_generated_method = "7E3246CB4EE47BE861BB5382651D6E14")
    private String encodeProduct() {
        StringBuffer tokens = new StringBuffer();
        ListIterator it = productTokens.listIterator();
        while
(it.hasNext())        
        {
            tokens.append((String) it.next());
    if(it.hasNext())            
            tokens.append('/');
            else
            break;
        } //End block
String varD351E2BA7C978FE08B358585AC21E273_2066152546 =         tokens.toString();
        varD351E2BA7C978FE08B358585AC21E273_2066152546.addTaint(taint);
        return varD351E2BA7C978FE08B358585AC21E273_2066152546;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.418 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "B06CFE66F7E0739FE5681D991D4815CC")
    public void addProductToken(String pt) {
        addTaint(pt.getTaint());
        productTokens.add(pt);
        // ---------- Original Method ----------
        //productTokens.add(pt);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.419 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "1957C1B5A7330F5D446B57AE72F6D790")
    public String encodeBody() {
String varF912B806A7ABDF5908FA63C29019CFE6_149947166 =         encodeProduct();
        varF912B806A7ABDF5908FA63C29019CFE6_149947166.addTaint(taint);
        return varF912B806A7ABDF5908FA63C29019CFE6_149947166;
        // ---------- Original Method ----------
        //return encodeProduct();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.419 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "69A0FD218E946154B8D9B5318BA97A8A")
    public ListIterator getProduct() {
    if(productTokens == null || productTokens.isEmpty())        
        {
ListIterator var540C13E9E156B687226421B24F2DF178_2055329942 =         null;
        var540C13E9E156B687226421B24F2DF178_2055329942.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2055329942;
        }
        else
        {
ListIterator var1C927566297DCD1B995549CFC5460648_1888693802 =         productTokens.listIterator();
        var1C927566297DCD1B995549CFC5460648_1888693802.addTaint(taint);
        return var1C927566297DCD1B995549CFC5460648_1888693802;
        }
        // ---------- Original Method ----------
        //if (productTokens == null || productTokens.isEmpty())
            //return null;
        //else
            //return productTokens.listIterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.420 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "A10ED6CA123EED4DA1CAC4515F1F6CC1")
    public void setProduct(List product) throws ParseException {
    if(product == null)        
        {
        NullPointerException var41AB9066381D97BBFD2255B25B214088_1012173221 = new NullPointerException(
                "JAIN-SIP Exception, UserAgent, "
                    + "setProduct(), the "
                    + " product parameter is null");
        var41AB9066381D97BBFD2255B25B214088_1012173221.addTaint(taint);
        throw var41AB9066381D97BBFD2255B25B214088_1012173221;
        }
        productTokens = product;
        // ---------- Original Method ----------
        //if (product == null)
            //throw new NullPointerException(
                //"JAIN-SIP Exception, UserAgent, "
                    //+ "setProduct(), the "
                    //+ " product parameter is null");
        //productTokens = product;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.420 -0400", hash_original_field = "C650C2D202702263731A478D25505F7E", hash_generated_field = "C0E073D0311495EC10E3519402318717")

    private static final long serialVersionUID = -3587764149383342973L;
}

