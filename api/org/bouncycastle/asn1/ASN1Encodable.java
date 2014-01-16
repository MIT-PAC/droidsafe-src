package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public abstract class ASN1Encodable implements DEREncodable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.888 -0500", hash_original_field = "C2DFC7BA8E3848A66D0A9E632D48E16B", hash_generated_field = "8DAACA94B2383555B621C242CE548E3A")

    public static final String DER = "DER";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.891 -0500", hash_original_field = "A65C3750D44AF5835DB03119EE69969B", hash_generated_field = "0FC96BF51EF2948441E6F4A0F4B732DA")

    public static final String BER = "BER";
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.598 -0400", hash_original_method = "821D90F216C7C1EC15D73655F548D7FA", hash_generated_method = "821D90F216C7C1EC15D73655F548D7FA")
    public ASN1Encodable ()
    {
        //Synthesized constructor
    }

    /**
     * Return the default BER or DER encoding for this object.
     *
     * @return BER/DER byte encoded object.
     * @throws IOException on encoding error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.893 -0500", hash_original_method = "C8FCAC6682497FE618C0D5AA310E3FD0", hash_generated_method = "1140B4B7825BDF5D27147E8726C84A88")
    
public byte[] getEncoded() 
        throws IOException
    {
        ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
        ASN1OutputStream        aOut = new ASN1OutputStream(bOut);
        
        aOut.writeObject(this);
        
        return bOut.toByteArray();
    }

    /**
     * Return either the default for "BER" or a DER encoding if "DER" is specified.
     *
     * @param encoding name of encoding to use.
     * @return byte encoded object.
     * @throws IOException on encoding error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.896 -0500", hash_original_method = "0EE5AC212F5921A1423603D1CACD3165", hash_generated_method = "7D498E9E2CD98A25AC71BA7C61534737")
    
public byte[] getEncoded(
        String encoding) 
        throws IOException
    {
        if (encoding.equals(DER))
        {
            ByteArrayOutputStream   bOut = new ByteArrayOutputStream();
            DEROutputStream         dOut = new DEROutputStream(bOut);
            
            dOut.writeObject(this);
            
            return bOut.toByteArray();
        }
        
        return this.getEncoded();
    }
    
    /**
     * Return the DER encoding of the object, null if the DER encoding can not be made.
     * 
     * @return a DER byte array, null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.898 -0500", hash_original_method = "91818EC368964F823237F12171E564CB", hash_generated_method = "B475F0D38F377A66A470D77A37C0BE70")
    
public byte[] getDEREncoded()
    {
        try
        {
            return this.getEncoded(DER);
        }
        catch (IOException e)
        {
            return null;
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.900 -0500", hash_original_method = "E92DD8C6A04F1DEE3C1D21F3A4F15F7B", hash_generated_method = "0E5FF77A20E0BDDD542BB483A03A75B0")
    
public int hashCode()
    {
        return this.toASN1Object().hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.902 -0500", hash_original_method = "234E7FC050F6E9ED95377E5CED033E83", hash_generated_method = "1665C0E1E74F8C60265D7BE2159EF11F")
    
public boolean equals(
        Object  o)
    {
        if (this == o)
        {
            return true;
        }
        
        if (!(o instanceof DEREncodable))
        {
            return false;
        }

        DEREncodable other = (DEREncodable)o;

        return this.toASN1Object().equals(other.getDERObject());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.904 -0500", hash_original_method = "AC000C3F3D93D2894978F92780762A2E", hash_generated_method = "F6A761A7CD8A0885A8E41BF0DA720ECD")
    
public DERObject getDERObject()
    {        
        return this.toASN1Object();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:18.907 -0500", hash_original_method = "0B429B07F7E2CEA8F8A51A82F4B78CF1", hash_generated_method = "CEA674D766057DD98BA91620AB48A54A")
    
public abstract DERObject toASN1Object();
}

