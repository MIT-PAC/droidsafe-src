package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.util.Enumeration;

public class BERTaggedObject extends DERTaggedObject {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.931 -0400", hash_original_method = "C31FB64F3B4373F22983AB0E8A924F45", hash_generated_method = "0D08009711DD3ED688791BFECA1FC98F")
    public  BERTaggedObject(
        int             tagNo,
        DEREncodable    obj) {
        super(tagNo, obj);
        addTaint(tagNo);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.948 -0400", hash_original_method = "F5B7A80AD1A003D34ED6FD9BD184C1A3", hash_generated_method = "2E6B3F2C8E346477C5E4CC91C8952011")
    public  BERTaggedObject(
        boolean         explicit,
        int             tagNo,
        DEREncodable    obj) {
        super(explicit, tagNo, obj);
        addTaint(explicit);
        addTaint(tagNo);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.948 -0400", hash_original_method = "6F574A26D6DB1C59B77D339A09CC5651", hash_generated_method = "EADAE545A6D448B2C6F1DC545BE8A8F7")
    public  BERTaggedObject(
        int             tagNo) {
        super(false, tagNo, new BERSequence());
        addTaint(tagNo);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:18.949 -0400", hash_original_method = "7D1415DBFEACA82B062C25744BEBEEC4", hash_generated_method = "B580261925CABA1629E56689F955C682")
     void encode(
        DEROutputStream  out) throws IOException {
        {
            out.writeTag(CONSTRUCTED | TAGGED, tagNo);
            out.write(0x80);
            {
                {
                    Enumeration e;
                    {
                        {
                            e = ((BERConstructedOctetString)obj).getObjects();
                        } //End block
                        {
                            ASN1OctetString octs;
                            octs = (ASN1OctetString)obj;
                            BERConstructedOctetString berO;
                            berO = new BERConstructedOctetString(octs.getOctets());
                            e = berO.getObjects();
                        } //End block
                    } //End block
                    {
                        e = ((ASN1Sequence)obj).getObjects();
                    } //End block
                    {
                        e = ((ASN1Set)obj).getObjects();
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new RuntimeException("not implemented: " + obj.getClass().getName());
                    } //End block
                    {
                        boolean varDAE76E52B86B173593FF9665A973FC54_298849525 = (e.hasMoreElements());
                        {
                            out.writeObject(e.nextElement());
                        } //End block
                    } //End collapsed parenthetic
                } //End block
                {
                    out.writeObject(obj);
                } //End block
            } //End block
            out.write(0x00);
            out.write(0x00);
        } //End block
        {
            super.encode(out);
        } //End block
        addTaint(out.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}

