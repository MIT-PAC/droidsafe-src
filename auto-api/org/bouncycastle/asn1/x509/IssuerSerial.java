package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class IssuerSerial extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.017 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "FBA189AA1CCDF885E2BAFE3258EFE992")

    GeneralNames issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.017 -0400", hash_original_field = "74136B24217CB75599440E6E1D807CF7", hash_generated_field = "B567171129E718B07996A791966D9A47")

    DERInteger serial;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.017 -0400", hash_original_field = "CE6DDC63C62D781984F661A1BC02AA1B", hash_generated_field = "3D9E898FBB0D3A6964BB9F619F1BE32F")

    DERBitString issuerUID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.037 -0400", hash_original_method = "6A7E42DF8EF9B09B844C872DFCA023C7", hash_generated_method = "DE6D2CFD6B8F13A200639C826466DAD6")
    public  IssuerSerial(
        ASN1Sequence    seq) {
        {
            boolean varE66FC7BCB62D6129C3B052068045942B_1638789832 = (seq.size() != 2 && seq.size() != 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            } //End block
        } //End collapsed parenthetic
        issuer = GeneralNames.getInstance(seq.getObjectAt(0));
        serial = DERInteger.getInstance(seq.getObjectAt(1));
        {
            boolean varB84C8522B025613859E5A51D2B72F1B8_1585799368 = (seq.size() == 3);
            {
                issuerUID = DERBitString.getInstance(seq.getObjectAt(2));
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (seq.size() != 2 && seq.size() != 3)
        //{
            //throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        //}
        //issuer = GeneralNames.getInstance(seq.getObjectAt(0));
        //serial = DERInteger.getInstance(seq.getObjectAt(1));
        //if (seq.size() == 3)
        //{
            //issuerUID = DERBitString.getInstance(seq.getObjectAt(2));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.038 -0400", hash_original_method = "B838D7E53D177DFF65C1A291EEAEEEE1", hash_generated_method = "D4EC88DF2D8A028D56F6AF5E2A27DDE6")
    public  IssuerSerial(
        GeneralNames    issuer,
        DERInteger      serial) {
        this.issuer = issuer;
        this.serial = serial;
        // ---------- Original Method ----------
        //this.issuer = issuer;
        //this.serial = serial;
    }

    
        public static IssuerSerial getInstance(
            Object  obj) {
        if (obj == null || obj instanceof IssuerSerial)
        {
            return (IssuerSerial)obj;
        }
        if (obj instanceof ASN1Sequence)
        {
            return new IssuerSerial((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static IssuerSerial getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.038 -0400", hash_original_method = "C6A01CC056B505ECB1961F3D46D5E125", hash_generated_method = "D94C9A70D884395783DDA2B04732F3F7")
    public GeneralNames getIssuer() {
        GeneralNames varB4EAC82CA7396A68D541C85D26508E83_552033963 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_552033963 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_552033963.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_552033963;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.039 -0400", hash_original_method = "4A26172B3E4E9D1CBD95C0010541030C", hash_generated_method = "B365D9B557EA10E986F9D6C6C7C99022")
    public DERInteger getSerial() {
        DERInteger varB4EAC82CA7396A68D541C85D26508E83_511587654 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_511587654 = serial;
        varB4EAC82CA7396A68D541C85D26508E83_511587654.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_511587654;
        // ---------- Original Method ----------
        //return serial;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.039 -0400", hash_original_method = "6FC86B4935E8EDEA9326972109BFF43A", hash_generated_method = "80978C3D4D61C9A9EAB98D45F838AC3C")
    public DERBitString getIssuerUID() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1741039427 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1741039427 = issuerUID;
        varB4EAC82CA7396A68D541C85D26508E83_1741039427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1741039427;
        // ---------- Original Method ----------
        //return issuerUID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.043 -0400", hash_original_method = "91432FD7FC59DB0CA5EF9903A7843F73", hash_generated_method = "7D72969050452F8EC8F33FDD05B7C59B")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_493493423 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(issuer);
        v.add(serial);
        {
            v.add(issuerUID);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_493493423 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_493493423.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_493493423;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(issuer);
        //v.add(serial);
        //if (issuerUID != null)
        //{
            //v.add(issuerUID);
        //}
        //return new DERSequence(v);
    }

    
}

