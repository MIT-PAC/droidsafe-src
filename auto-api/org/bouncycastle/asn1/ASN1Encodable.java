package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class ASN1Encodable implements DEREncodable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.801 -0400", hash_original_method = "821D90F216C7C1EC15D73655F548D7FA", hash_generated_method = "821D90F216C7C1EC15D73655F548D7FA")
    public ASN1Encodable ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.801 -0400", hash_original_method = "C8FCAC6682497FE618C0D5AA310E3FD0", hash_generated_method = "639CE3D854B7FFDB10DD0055D1B080AD")
    public byte[] getEncoded() throws IOException {
        ByteArrayOutputStream bOut = new ByteArrayOutputStream();
        ASN1OutputStream aOut = new ASN1OutputStream(bOut);
        aOut.writeObject(this);
        byte[] var16BD2DDC58D2D23DE6338127D5E7BC71_841557375 = (bOut.toByteArray());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1735971661 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1735971661;
        // ---------- Original Method ----------
        //ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
        //ASN1OutputStream        aOut = new ASN1OutputStream(bOut);
        //aOut.writeObject(this);
        //return bOut.toByteArray();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.802 -0400", hash_original_method = "0EE5AC212F5921A1423603D1CACD3165", hash_generated_method = "2AC43216CEC30F7E04529B3F55A55BBE")
    public byte[] getEncoded(
        String encoding) throws IOException {
        {
            boolean varAE0AF719388F003A8693E9263E93DCF6_1024589597 = (encoding.equals(DER));
            {
                ByteArrayOutputStream bOut = new ByteArrayOutputStream();
                DEROutputStream dOut = new DEROutputStream(bOut);
                dOut.writeObject(this);
                byte[] var5C18F3BF1D6392BDD954E4CCD698E7BC_710514420 = (bOut.toByteArray());
            } //End block
        } //End collapsed parenthetic
        byte[] var37B2A02804007496BEDC95390C25F19C_1552008769 = (this.getEncoded());
        addTaint(encoding.getTaint());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_225184769 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_225184769;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.803 -0400", hash_original_method = "91818EC368964F823237F12171E564CB", hash_generated_method = "CF59BDA43EEFE01E1D115A6BEB79E5FA")
    public byte[] getDEREncoded() {
        try 
        {
            byte[] var31F68C705D1490980169EE5146ACA6A7_850432696 = (this.getEncoded(DER));
        } //End block
        catch (IOException e)
        { }
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1106863627 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1106863627;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.803 -0400", hash_original_method = "E92DD8C6A04F1DEE3C1D21F3A4F15F7B", hash_generated_method = "E5DC2CA4670BD16D038AFB7AC9D33DBB")
    public int hashCode() {
        int var21CF2165F9A6D97B2B00A5B0FAE1D622_134390863 = (this.toASN1Object().hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_217339286 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_217339286;
        // ---------- Original Method ----------
        //return this.toASN1Object().hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.804 -0400", hash_original_method = "234E7FC050F6E9ED95377E5CED033E83", hash_generated_method = "65716969166A5A1BF9EEA2E3EE27051E")
    public boolean equals(
        Object  o) {
        DEREncodable other = (DEREncodable)o;
        boolean var6FFB4CBFFAD3DBC52A1E1B942C262DFC_1649510764 = (this.toASN1Object().equals(other.getDERObject()));
        addTaint(o.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_825468527 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_825468527;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.805 -0400", hash_original_method = "AC000C3F3D93D2894978F92780762A2E", hash_generated_method = "34C8BE5C033A792BF5C2E446DFB5A837")
    public DERObject getDERObject() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_238052307 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_238052307 = this.toASN1Object();
        varB4EAC82CA7396A68D541C85D26508E83_238052307.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_238052307;
        // ---------- Original Method ----------
        //return this.toASN1Object();
    }

    
    public abstract DERObject toASN1Object();

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.806 -0400", hash_original_field = "8E9E89A415729A2976CD7BEE3D029BC5", hash_generated_field = "8DAACA94B2383555B621C242CE548E3A")

    public static final String DER = "DER";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:42.806 -0400", hash_original_field = "491DE6991F060C8B68AEBE4E4792EF09", hash_generated_field = "0FC96BF51EF2948441E6F4A0F4B732DA")

    public static final String BER = "BER";
}

