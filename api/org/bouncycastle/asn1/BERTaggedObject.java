package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.util.Enumeration;

public class BERTaggedObject extends DERTaggedObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.834 -0400", hash_original_method = "C31FB64F3B4373F22983AB0E8A924F45", hash_generated_method = "1BDFE6029FA7A9657F1B649820F56AC9")
    public  BERTaggedObject(
        int             tagNo,
        DEREncodable    obj) {
        super(tagNo, obj);
        addTaint(obj.getTaint());
        addTaint(tagNo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.834 -0400", hash_original_method = "F5B7A80AD1A003D34ED6FD9BD184C1A3", hash_generated_method = "3CD1D05A7C82A6562BE1FCDE27C07862")
    public  BERTaggedObject(
        boolean         explicit,
        int             tagNo,
        DEREncodable    obj) {
        super(explicit, tagNo, obj);
        addTaint(obj.getTaint());
        addTaint(tagNo);
        addTaint(explicit);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.834 -0400", hash_original_method = "6F574A26D6DB1C59B77D339A09CC5651", hash_generated_method = "EADAE545A6D448B2C6F1DC545BE8A8F7")
    public  BERTaggedObject(
        int             tagNo) {
        super(false, tagNo, new BERSequence());
        addTaint(tagNo);
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:20.835 -0400", hash_original_method = "7D1415DBFEACA82B062C25744BEBEEC4", hash_generated_method = "5EEBB432CC94C55B6B4B5B34267871D2")
     void encode(
        DEROutputStream  out) throws IOException {
        addTaint(out.getTaint());
    if(out instanceof ASN1OutputStream || out instanceof BEROutputStream)        
        {
            out.writeTag(CONSTRUCTED | TAGGED, tagNo);
            out.write(0x80);
    if(!empty)            
            {
    if(!explicit)                
                {
                    Enumeration e;
    if(obj instanceof ASN1OctetString)                    
                    {
    if(obj instanceof BERConstructedOctetString)                        
                        {
                            e = ((BERConstructedOctetString)obj).getObjects();
                        } //End block
                        else
                        {
                            ASN1OctetString octs = (ASN1OctetString)obj;
                            BERConstructedOctetString berO = new BERConstructedOctetString(octs.getOctets());
                            e = berO.getObjects();
                        } //End block
                    } //End block
                    else
    if(obj instanceof ASN1Sequence)                    
                    {
                        e = ((ASN1Sequence)obj).getObjects();
                    } //End block
                    else
    if(obj instanceof ASN1Set)                    
                    {
                        e = ((ASN1Set)obj).getObjects();
                    } //End block
                    else
                    {
                        RuntimeException var41BDC878CD450F8A941BC74FE9A368FD_2033865783 = new RuntimeException("not implemented: " + obj.getClass().getName());
                        var41BDC878CD450F8A941BC74FE9A368FD_2033865783.addTaint(taint);
                        throw var41BDC878CD450F8A941BC74FE9A368FD_2033865783;
                    } //End block
                    while
(e.hasMoreElements())                    
                    {
                        out.writeObject(e.nextElement());
                    } //End block
                } //End block
                else
                {
                    out.writeObject(obj);
                } //End block
            } //End block
            out.write(0x00);
            out.write(0x00);
        } //End block
        else
        {
            super.encode(out);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

