package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class ASN1Encodable implements DEREncodable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.598 -0400", hash_original_method = "821D90F216C7C1EC15D73655F548D7FA", hash_generated_method = "821D90F216C7C1EC15D73655F548D7FA")
    public ASN1Encodable ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.598 -0400", hash_original_method = "C8FCAC6682497FE618C0D5AA310E3FD0", hash_generated_method = "F1EDEA5E7BF01DBE19522C48C22CB203")
    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = new ASN1OutputStream(bOut);
        aOut.writeObject(this);
        byte[] varFBF1B634B1C8DDF7D794A26F16D73A6E_47614434 = (bOut.toByteArray());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1395291488 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1395291488;
        // ---------- Original Method ----------
        //ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
        //ASN1OutputStream        aOut = new ASN1OutputStream(bOut);
        //aOut.writeObject(this);
        //return bOut.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.599 -0400", hash_original_method = "0EE5AC212F5921A1423603D1CACD3165", hash_generated_method = "14522D6D6CEB59D366748BC998C37EF1")
    public byte[] getEncoded(
        String encoding) throws IOException {
        addTaint(encoding.getTaint());
        if(encoding.equals(DER))        
        {
            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            DEROutputStream dOut = new DEROutputStream(bOut);
            dOut.writeObject(this);
            byte[] varFBF1B634B1C8DDF7D794A26F16D73A6E_419121422 = (bOut.toByteArray());
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1890947976 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1890947976;
        } //End block
        byte[] varC76385A842A5A359AF969FCD09CD618B_1480789029 = (this.getEncoded());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_472098043 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_472098043;
        // ---------- Original Method ----------
        //if (encoding.equals(DER))
        //{
            //ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
            //DEROutputStream         dOut = new DEROutputStream(bOut);
            //dOut.writeObject(this);
            //return bOut.toByteArray();
        //}
        //return this.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.599 -0400", hash_original_method = "91818EC368964F823237F12171E564CB", hash_generated_method = "4C6B1FE88F3AA63E77FA576E78F33AEC")
    public byte[] getDEREncoded() {
        try 
        {
            byte[] varBE8C154F4000F1E514F08B09FAF8EB6B_526664878 = (this.getEncoded(DER));
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1587444963 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1587444963;
        } //End block
        catch (IOException e)
        {
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_61053542 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_15033316 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_15033316;
        } //End block
        // ---------- Original Method ----------
        //try
        //{
            //return this.getEncoded(DER);
        //}
        //catch (IOException e)
        //{
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.600 -0400", hash_original_method = "E92DD8C6A04F1DEE3C1D21F3A4F15F7B", hash_generated_method = "011AD74E4C0ED2975699A2B0FC81D699")
    public int hashCode() {
        int varDF1C8DD71A594A916AF740C69638FD5A_665790304 = (this.toASN1Object().hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795302022 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1795302022;
        // ---------- Original Method ----------
        //return this.toASN1Object().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.600 -0400", hash_original_method = "234E7FC050F6E9ED95377E5CED033E83", hash_generated_method = "AB2C5612056E76BE8B803A3C209D8A7C")
    public boolean equals(
        Object  o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_210182373 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030334011 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030334011;
        } //End block
        if(!(o instanceof DEREncodable))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1128608412 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666084765 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666084765;
        } //End block
        DEREncodable other = (DEREncodable)o;
        boolean varD736946B35518D9FF86352D989427393_1094562291 = (this.toASN1Object().equals(other.getDERObject()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1809439439 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1809439439;
        // ---------- Original Method ----------
        //if (this == o)
        //{
            //return true;
        //}
        //if (!(o instanceof DEREncodable))
        //{
            //return false;
        //}
        //DEREncodable other = (DEREncodable)o;
        //return this.toASN1Object().equals(other.getDERObject());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.601 -0400", hash_original_method = "AC000C3F3D93D2894978F92780762A2E", hash_generated_method = "F80DB3490B8E9958523EECE7C54FA64A")
    public DERObject getDERObject() {
DERObject var15B299BB545D52AE6F55579E211C4634_554182251 =         this.toASN1Object();
        var15B299BB545D52AE6F55579E211C4634_554182251.addTaint(taint);
        return var15B299BB545D52AE6F55579E211C4634_554182251;
        // ---------- Original Method ----------
        //return this.toASN1Object();
    }

    
    public abstract DERObject toASN1Object();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.601 -0400", hash_original_field = "8E9E89A415729A2976CD7BEE3D029BC5", hash_generated_field = "8DAACA94B2383555B621C242CE548E3A")

    public static final String DER = "DER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.601 -0400", hash_original_field = "491DE6991F060C8B68AEBE4E4792EF09", hash_generated_field = "0FC96BF51EF2948441E6F4A0F4B732DA")

    public static final String BER = "BER";
}

