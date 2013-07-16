package gov.nist.javax.sip.header;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.*;
import java.text.ParseException;
import javax.sip.header.*;

public class UserAgent extends SIPHeader implements UserAgentHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.565 -0400", hash_original_field = "9688EFB908EECBA4C560247BC17C9D80", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.566 -0400", hash_original_method = "92D698CE7378CD097EA41B036334F01C", hash_generated_method = "96AC165CBEEAA1B39BCA167D71822187")
    public  UserAgent() {
        super(NAME);
        productTokens = new LinkedList();
        // ---------- Original Method ----------
        //productTokens = new LinkedList();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.567 -0400", hash_original_method = "54509C1E79AD8AD51EA2FF1C763ECD71", hash_generated_method = "DB9F53F666193F250480E06D0EBA09F7")
    private String encodeProduct() {
        StringBuffer tokens = new StringBuffer();
        ListIterator it = productTokens.listIterator();
        while
(it.hasNext())        
        {
            tokens.append((String) it.next());
        } //End block
String varD351E2BA7C978FE08B358585AC21E273_1797942910 =         tokens.toString();
        varD351E2BA7C978FE08B358585AC21E273_1797942910.addTaint(taint);
        return varD351E2BA7C978FE08B358585AC21E273_1797942910;
        // ---------- Original Method ----------
        //StringBuffer tokens = new StringBuffer();
        //ListIterator it = productTokens.listIterator();
        //while (it.hasNext()) {
            //tokens.append((String) it.next());
        //}
        //return tokens.toString();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.568 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "B06CFE66F7E0739FE5681D991D4815CC")
    public void addProductToken(String pt) {
        addTaint(pt.getTaint());
        productTokens.add(pt);
        // ---------- Original Method ----------
        //productTokens.add(pt);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.568 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "45E0821BD309CFB503CAC851DAA01327")
    public String encodeBody() {
String varF912B806A7ABDF5908FA63C29019CFE6_578017376 =         encodeProduct();
        varF912B806A7ABDF5908FA63C29019CFE6_578017376.addTaint(taint);
        return varF912B806A7ABDF5908FA63C29019CFE6_578017376;
        // ---------- Original Method ----------
        //return encodeProduct();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.569 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "A574CC17B60791D2E317750C970A8479")
    public ListIterator getProduct() {
    if(productTokens == null || productTokens.isEmpty())        
        {
ListIterator var540C13E9E156B687226421B24F2DF178_274507528 =         null;
        var540C13E9E156B687226421B24F2DF178_274507528.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_274507528;
        }
        else
        {
ListIterator var1C927566297DCD1B995549CFC5460648_278900981 =         productTokens.listIterator();
        var1C927566297DCD1B995549CFC5460648_278900981.addTaint(taint);
        return var1C927566297DCD1B995549CFC5460648_278900981;
        }
        // ---------- Original Method ----------
        //if (productTokens == null || productTokens.isEmpty())
            //return null;
        //else
            //return productTokens.listIterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.569 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "A9E62057A161818EE5292095FB468B9F")
    public void setProduct(List product) throws ParseException {
    if(product == null)        
        {
        NullPointerException var41AB9066381D97BBFD2255B25B214088_1688498155 = new NullPointerException(
                "JAIN-SIP Exception, UserAgent, "
                    + "setProduct(), the "
                    + " product parameter is null");
        var41AB9066381D97BBFD2255B25B214088_1688498155.addTaint(taint);
        throw var41AB9066381D97BBFD2255B25B214088_1688498155;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.570 -0400", hash_original_method = "094FF844CCDBF62E3E868D88E09771A9", hash_generated_method = "A9E07F78B13AD7C26D7BE71C8F1F4814")
    public Object clone() {
        UserAgent retval = (UserAgent) super.clone();
    if(productTokens != null)        
        retval.productTokens = new LinkedList (productTokens);
Object varF9E19AD6135C970F387F77C6F3DE4477_2027466397 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_2027466397.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_2027466397;
        // ---------- Original Method ----------
        //UserAgent retval = (UserAgent) super.clone();
        //if (productTokens != null)
            //retval.productTokens = new LinkedList (productTokens);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:37.570 -0400", hash_original_field = "628737300988B580B7DD5F8971B3688D", hash_generated_field = "2C0F80EC4F90746F4C9912D192AB89F6")

    private static final long serialVersionUID = 4561239179796364295L;
}

