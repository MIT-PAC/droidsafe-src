package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;

public abstract class ASN1Object extends DERObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.601 -0400", hash_original_method = "79A6503CF02D2BF6CA7C22C7ECE56A0E", hash_generated_method = "79A6503CF02D2BF6CA7C22C7ECE56A0E")
    public ASN1Object ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SPEC)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.601 -0400", hash_original_method = "DA81A9CF27CE7E2A8EA2EF36D7C19ED4", hash_generated_method = "0CBF7BC49FDF4C69A988A5AF049F9D68")
    public final boolean equals(Object o) {
        addTaint(o.getTaint());
    if(this == o)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_778649081 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1777982799 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1777982799;
        } //End block
        boolean varAE21F1C3C896A4F1CE4A82CF6FADAE3D_837907606 = ((o instanceof DEREncodable) && asn1Equals(((DEREncodable)o).getDERObject()));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1656809738 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1656809738;
        // ---------- Original Method ----------
        //if (this == o)
        //{
            //return true;
        //}
        //return (o instanceof DEREncodable) && asn1Equals(((DEREncodable)o).getDERObject());
    }

    
    public abstract int hashCode();

    
    abstract void encode(DEROutputStream out) throws IOException;

    
    abstract boolean asn1Equals(DERObject o);

    
}

