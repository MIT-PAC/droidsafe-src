package gov.nist.javax.sip.header;

// Droidsafe Imports
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import javax.sip.header.UserAgentHeader;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class UserAgent extends SIPHeader implements UserAgentHeader {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.655 -0400", hash_original_field = "9688EFB908EECBA4C560247BC17C9D80", hash_generated_field = "23BE30BA77F76A348892FB57EBB6010B")

    protected List productTokens;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.655 -0400", hash_original_method = "92D698CE7378CD097EA41B036334F01C", hash_generated_method = "96AC165CBEEAA1B39BCA167D71822187")
    public  UserAgent() {
        super(NAME);
        productTokens = new LinkedList();
        // ---------- Original Method ----------
        //productTokens = new LinkedList();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.656 -0400", hash_original_method = "54509C1E79AD8AD51EA2FF1C763ECD71", hash_generated_method = "D0AC26C727A1FACF5F6CBB6436F25855")
    private String encodeProduct() {
        StringBuffer tokens = new StringBuffer();
        ListIterator it = productTokens.listIterator();
        while
(it.hasNext())        
        {
            tokens.append((String) it.next());
        } //End block
String varD351E2BA7C978FE08B358585AC21E273_1586133777 =         tokens.toString();
        varD351E2BA7C978FE08B358585AC21E273_1586133777.addTaint(taint);
        return varD351E2BA7C978FE08B358585AC21E273_1586133777;
        // ---------- Original Method ----------
        //StringBuffer tokens = new StringBuffer();
        //ListIterator it = productTokens.listIterator();
        //while (it.hasNext()) {
            //tokens.append((String) it.next());
        //}
        //return tokens.toString();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.656 -0400", hash_original_method = "ABC17F5FB7BD95EF5278D9B937F06D5F", hash_generated_method = "B06CFE66F7E0739FE5681D991D4815CC")
    public void addProductToken(String pt) {
        addTaint(pt.getTaint());
        productTokens.add(pt);
        // ---------- Original Method ----------
        //productTokens.add(pt);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.656 -0400", hash_original_method = "C0BFA4AD92D4DEF654107ADD12EA3FEE", hash_generated_method = "87A7E2ED78C3ED0B176D46D247A938D0")
    public String encodeBody() {
String varF912B806A7ABDF5908FA63C29019CFE6_1841098915 =         encodeProduct();
        varF912B806A7ABDF5908FA63C29019CFE6_1841098915.addTaint(taint);
        return varF912B806A7ABDF5908FA63C29019CFE6_1841098915;
        // ---------- Original Method ----------
        //return encodeProduct();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.657 -0400", hash_original_method = "FCFEA9A6A04C032A17913D323F8D82A6", hash_generated_method = "C2F3026A51D719737824C2E471AC236F")
    public ListIterator getProduct() {
        if(productTokens == null || productTokens.isEmpty())        
        {
ListIterator var540C13E9E156B687226421B24F2DF178_2067972535 =         null;
        var540C13E9E156B687226421B24F2DF178_2067972535.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_2067972535;
        }
        else
        {
ListIterator var1C927566297DCD1B995549CFC5460648_1613635187 =         productTokens.listIterator();
        var1C927566297DCD1B995549CFC5460648_1613635187.addTaint(taint);
        return var1C927566297DCD1B995549CFC5460648_1613635187;
        }
        // ---------- Original Method ----------
        //if (productTokens == null || productTokens.isEmpty())
            //return null;
        //else
            //return productTokens.listIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.658 -0400", hash_original_method = "3D9ECE8DAEA4B32C617B95DA481A8348", hash_generated_method = "05155FC31A0FD7B547FBA8994A723048")
    public void setProduct(List product) throws ParseException {
        if(product == null)        
        {
        NullPointerException var41AB9066381D97BBFD2255B25B214088_1647859260 = new NullPointerException(
                "JAIN-SIP Exception, UserAgent, "
                    + "setProduct(), the "
                    + " product parameter is null");
        var41AB9066381D97BBFD2255B25B214088_1647859260.addTaint(taint);
        throw var41AB9066381D97BBFD2255B25B214088_1647859260;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.658 -0400", hash_original_method = "094FF844CCDBF62E3E868D88E09771A9", hash_generated_method = "A1E4D6EF45EC2E4D752C2B41277D6D20")
    public Object clone() {
        UserAgent retval = (UserAgent) super.clone();
        if(productTokens != null)        
        retval.productTokens = new LinkedList (productTokens);
Object varF9E19AD6135C970F387F77C6F3DE4477_1466794910 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_1466794910.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_1466794910;
        // ---------- Original Method ----------
        //UserAgent retval = (UserAgent) super.clone();
        //if (productTokens != null)
            //retval.productTokens = new LinkedList (productTokens);
        //return retval;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:34.658 -0400", hash_original_field = "628737300988B580B7DD5F8971B3688D", hash_generated_field = "2C0F80EC4F90746F4C9912D192AB89F6")

    private static final long serialVersionUID = 4561239179796364295L;
}

