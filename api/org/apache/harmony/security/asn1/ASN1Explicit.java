package org.apache.harmony.security.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public final class ASN1Explicit extends ASN1Constructed {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.587 -0400", hash_original_field = "599DCCE2998A6B40B1E38E8C6006CB0A", hash_generated_field = "AC7D2E3EF11E777F80843D5021489F8A")

    public ASN1Type type;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.588 -0400", hash_original_method = "B0F7BA820AB1A580DEB9F8D4C1B1D195", hash_generated_method = "8400C7DFCCC28DC069879BA416A6411D")
    public  ASN1Explicit(int tagNumber, ASN1Type type) {
        this(CLASS_CONTEXTSPECIFIC, tagNumber, type);
        addTaint(type.getTaint());
        addTaint(tagNumber);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.588 -0400", hash_original_method = "3F0FA66BFD46DABED8E86D16322A75CE", hash_generated_method = "A772C1132E1161798F83F3B6D3D1D46C")
    public  ASN1Explicit(int tagClass, int tagNumber, ASN1Type type) {
        super(tagClass, tagNumber);
        addTaint(tagNumber);
        addTaint(tagClass);
        this.type = type;
        // ---------- Original Method ----------
        //this.type = type;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.589 -0400", hash_original_method = "BF5194A9A90A1C345CA0C933EC20C89E", hash_generated_method = "BCAA1C3327D86DC612F57AB7AB96C8E3")
    public Object decode(BerInputStream in) throws IOException {
        addTaint(in.getTaint());
    if(constrId != in.tag)        
        {
            ASN1Exception var302D11138C35F46EB154744A76B3748E_1891086929 = new ASN1Exception("ASN.1 explicitly tagged type is expected at [" +
                    in.tagOffset + "]. Expected tag: " + Integer.toHexString(constrId) + ", " +
                    "but encountered tag " + Integer.toHexString(in.tag));
            var302D11138C35F46EB154744A76B3748E_1891086929.addTaint(taint);
            throw var302D11138C35F46EB154744A76B3748E_1891086929;
        } //End block
        in.next();
        in.content = type.decode(in);
    if(in.isVerify)        
        {
Object var540C13E9E156B687226421B24F2DF178_2021558308 =             null;
            var540C13E9E156B687226421B24F2DF178_2021558308.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_2021558308;
        } //End block
Object var6AD043AF0280111F31D0D60A6CD70863_2074098184 =         getDecodedObject(in);
        var6AD043AF0280111F31D0D60A6CD70863_2074098184.addTaint(taint);
        return var6AD043AF0280111F31D0D60A6CD70863_2074098184;
        // ---------- Original Method ----------
        //if (constrId != in.tag) {
            //throw new ASN1Exception("ASN.1 explicitly tagged type is expected at [" +
                    //in.tagOffset + "]. Expected tag: " + Integer.toHexString(constrId) + ", " +
                    //"but encountered tag " + Integer.toHexString(in.tag));
        //}
        //in.next();
        //in.content = type.decode(in);
        //if (in.isVerify) {
            //return null;
        //}
        //return getDecodedObject(in);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.589 -0400", hash_original_method = "185B9650CC00F76A6008982D1539FA31", hash_generated_method = "A7D08E67C26C573634E3EEFCBAA61B2A")
    public void encodeContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.encodeExplicit(this);
        // ---------- Original Method ----------
        //out.encodeExplicit(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.590 -0400", hash_original_method = "8EE64F8332C91721514C0E16F4A7E840", hash_generated_method = "AB3F9776D0F77F0EC23D8597949630CF")
    public void setEncodingContent(BerOutputStream out) {
        addTaint(out.getTaint());
        out.getExplicitLength(this);
        // ---------- Original Method ----------
        //out.getExplicitLength(this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:17.590 -0400", hash_original_method = "8627A6334FE9B6784BD6CB87A9255671", hash_generated_method = "2E6540786BC439F4B7A4AAD87328F817")
    @Override
    public String toString() {
String var85EB69DE4D40021680FD60AD8F4CCC91_371082833 =         super.toString() + " for type " + type;
        var85EB69DE4D40021680FD60AD8F4CCC91_371082833.addTaint(taint);
        return var85EB69DE4D40021680FD60AD8F4CCC91_371082833;
        // ---------- Original Method ----------
        //return super.toString() + " for type " + type;
    }

    
}

