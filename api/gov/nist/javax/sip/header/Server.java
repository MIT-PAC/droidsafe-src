package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.sip.header.ServerHeader;






public class Server extends SIPHeader implements ServerHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.478 -0400", hash_original_field = "9688EFB908EECBA4C560247BC17C9D80", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.479 -0400", hash_original_method = "28A485C01704A957BCAF31556583EFBE", hash_generated_method = "305518061AF0A2CB840B318B99F5BA97")
    public  Server() {
        super(NAME);
        productTokens = new LinkedList();
        // ---------- Original Method ----------
        //productTokens = new LinkedList();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.480 -0400", hash_original_method = "3BD03A3FDC86F025553E39D4B6A63060", hash_generated_method = "3EF5237ACBA698035A0FAC9F02596B1E")
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
String varD351E2BA7C978FE08B358585AC21E273_373325760 =         tokens.toString();
        varD351E2BA7C978FE08B358585AC21E273_373325760.addTaint(taint);
        return varD351E2BA7C978FE08B358585AC21E273_373325760;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.481 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "B06CFE66F7E0739FE5681D991D4815CC")
    public void addProductToken(String pt) {
        addTaint(pt.getTaint());
        productTokens.add(pt);
        // ---------- Original Method ----------
        //productTokens.add(pt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.481 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "FB55DB210262EEE20A148A95CA941C5A")
    public String encodeBody() {
String varF912B806A7ABDF5908FA63C29019CFE6_255768343 =         encodeProduct();
        varF912B806A7ABDF5908FA63C29019CFE6_255768343.addTaint(taint);
        return varF912B806A7ABDF5908FA63C29019CFE6_255768343;
        // ---------- Original Method ----------
        //return encodeProduct();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.481 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "44DAF916D55EB8141C14E196A13800E9")
    public ListIterator getProduct() {
        if(productTokens == null || productTokens.isEmpty())        
        {
ListIterator var540C13E9E156B687226421B24F2DF178_121724918 =         null;
        var540C13E9E156B687226421B24F2DF178_121724918.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_121724918;
        }
        else
        {
ListIterator var1C927566297DCD1B995549CFC5460648_1736948095 =         productTokens.listIterator();
        var1C927566297DCD1B995549CFC5460648_1736948095.addTaint(taint);
        return var1C927566297DCD1B995549CFC5460648_1736948095;
        }
        // ---------- Original Method ----------
        //if (productTokens == null || productTokens.isEmpty())
            //return null;
        //else
            //return productTokens.listIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.482 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "4901BB3B87DDB09B93E3DDA0BB531DEC")
    public void setProduct(List product) throws ParseException {
        if(product == null)        
        {
        NullPointerException var41AB9066381D97BBFD2255B25B214088_2016136305 = new NullPointerException(
                "JAIN-SIP Exception, UserAgent, "
                    + "setProduct(), the "
                    + " product parameter is null");
        var41AB9066381D97BBFD2255B25B214088_2016136305.addTaint(taint);
        throw var41AB9066381D97BBFD2255B25B214088_2016136305;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.482 -0400", hash_original_field = "C650C2D202702263731A478D25505F7E", hash_generated_field = "C0E073D0311495EC10E3519402318717")

    private static final long serialVersionUID = -3587764149383342973L;
}

