package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.io.IOException;





public abstract class ASN1Object extends DERObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.695 -0400", hash_original_method = "79A6503CF02D2BF6CA7C22C7ECE56A0E", hash_generated_method = "79A6503CF02D2BF6CA7C22C7ECE56A0E")
    public ASN1Object ()
    {
        //Synthesized constructor
    }


    public static ASN1Object fromByteArray(byte[] data) throws IOException {
        ASN1InputStream aIn = new ASN1InputStream(data);
        try
        {
            return (ASN1Object)aIn.readObject();
        }
        catch (ClassCastException e)
        {
            throw new IOException("cannot recognise object in stream");    
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.696 -0400", hash_original_method = "DA81A9CF27CE7E2A8EA2EF36D7C19ED4", hash_generated_method = "E405D2B6B57199E8F5A713C04EAE5F12")
    public final boolean equals(Object o) {
        addTaint(o.getTaint());
        if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_642652255 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_667348400 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_667348400;
        } //End block
        boolean varAE21F1C3C896A4F1CE4A82CF6FADAE3D_429359821 = ((o instanceof DEREncodable) && asn1Equals(((DEREncodable)o).getDERObject()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1081309861 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1081309861;
        // ---------- Original Method ----------
        //if (this == o)
        //{
            //return true;
        //}
        //return (o instanceof DEREncodable) && asn1Equals(((DEREncodable)o).getDERObject());
    }

    
    @DSModeled(DSC.SAFE)
    public abstract int hashCode();

    
    @DSModeled(DSC.SAFE)
    abstract void encode(DEROutputStream out) throws IOException;

    
    @DSModeled(DSC.SAFE)
    abstract boolean asn1Equals(DERObject o);

    
}

