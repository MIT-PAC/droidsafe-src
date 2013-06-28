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
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class AttributeCertificate extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.676 -0400", hash_original_field = "EDA2B26CC47ACE67E5CC2E518DCDA626", hash_generated_field = "B5AE372EF54AD09B5DE33BF4EF964975")

    AttributeCertificateInfo acinfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.676 -0400", hash_original_field = "0C3D482A41621822B95C4386FD1F1FC2", hash_generated_field = "2F7BE616514E885F71195FC5A07117B0")

    AlgorithmIdentifier signatureAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.676 -0400", hash_original_field = "A83E026224A6F552557EF9C7ABF67D37", hash_generated_field = "4A7A5C247FCE2D566D9AC9C1B8CED914")

    DERBitString signatureValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.676 -0400", hash_original_method = "2BEC4272F0342CC60C1E5750AB362553", hash_generated_method = "80C212D7054336F30DC20FF180FC8C79")
    public  AttributeCertificate(
        AttributeCertificateInfo    acinfo,
        AlgorithmIdentifier         signatureAlgorithm,
        DERBitString                signatureValue) {
        this.acinfo = acinfo;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signatureValue = signatureValue;
        // ---------- Original Method ----------
        //this.acinfo = acinfo;
        //this.signatureAlgorithm = signatureAlgorithm;
        //this.signatureValue = signatureValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.677 -0400", hash_original_method = "B4D994B87261FFD4B0816002B55F0788", hash_generated_method = "2E6279333857AEDCCDEA11440AB2416B")
    public  AttributeCertificate(
        ASN1Sequence    seq) {
        {
            boolean var01335131BE2224430AFFE0AC95254DF2_1709352474 = (seq.size() != 3);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            } //End block
        } //End collapsed parenthetic
        this.acinfo = AttributeCertificateInfo.getInstance(seq.getObjectAt(0));
        this.signatureAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(1));
        this.signatureValue = DERBitString.getInstance(seq.getObjectAt(2));
        // ---------- Original Method ----------
        //if (seq.size() != 3)
        //{
            //throw new IllegalArgumentException("Bad sequence size: "
                    //+ seq.size());
        //}
        //this.acinfo = AttributeCertificateInfo.getInstance(seq.getObjectAt(0));
        //this.signatureAlgorithm = AlgorithmIdentifier.getInstance(seq.getObjectAt(1));
        //this.signatureValue = DERBitString.getInstance(seq.getObjectAt(2));
    }

    
    public static AttributeCertificate getInstance(Object obj) {
        if (obj instanceof AttributeCertificate)
        {
            return (AttributeCertificate)obj;
        }
        else if (obj != null)
        {
            return new AttributeCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.678 -0400", hash_original_method = "B550BE2A3120BC2739AC35C67600D16E", hash_generated_method = "0CD218E8D21663E8713F3DC7F87D01CC")
    public AttributeCertificateInfo getAcinfo() {
        AttributeCertificateInfo varB4EAC82CA7396A68D541C85D26508E83_1737130972 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1737130972 = acinfo;
        varB4EAC82CA7396A68D541C85D26508E83_1737130972.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1737130972;
        // ---------- Original Method ----------
        //return acinfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.678 -0400", hash_original_method = "7848C69970B1A1FD0A4AF2994EC6E56B", hash_generated_method = "43E31F87F80876E8AF3114F620E6FC5B")
    public AlgorithmIdentifier getSignatureAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1690562427 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1690562427 = signatureAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1690562427.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1690562427;
        // ---------- Original Method ----------
        //return signatureAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.679 -0400", hash_original_method = "C8410B5B4D26900579B7A994FFDFFA14", hash_generated_method = "9A8B5484CC3E3298F7E7A6AEE4041951")
    public DERBitString getSignatureValue() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_590532681 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_590532681 = signatureValue;
        varB4EAC82CA7396A68D541C85D26508E83_590532681.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_590532681;
        // ---------- Original Method ----------
        //return signatureValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.679 -0400", hash_original_method = "EEF14432CC16BDD5140583520373DF2D", hash_generated_method = "F59C7C7F869C0D3112565DECF2084C67")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1047713365 = null; //Variable for return #1
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(acinfo);
        v.add(signatureAlgorithm);
        v.add(signatureValue);
        varB4EAC82CA7396A68D541C85D26508E83_1047713365 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1047713365.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1047713365;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(acinfo);
        //v.add(signatureAlgorithm);
        //v.add(signatureValue);
        //return new DERSequence(v);
    }

    
}

