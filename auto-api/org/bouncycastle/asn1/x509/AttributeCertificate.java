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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.864 -0400", hash_original_field = "EDA2B26CC47ACE67E5CC2E518DCDA626", hash_generated_field = "B5AE372EF54AD09B5DE33BF4EF964975")

    AttributeCertificateInfo acinfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.864 -0400", hash_original_field = "0C3D482A41621822B95C4386FD1F1FC2", hash_generated_field = "2F7BE616514E885F71195FC5A07117B0")

    AlgorithmIdentifier signatureAlgorithm;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.865 -0400", hash_original_field = "A83E026224A6F552557EF9C7ABF67D37", hash_generated_field = "4A7A5C247FCE2D566D9AC9C1B8CED914")

    DERBitString signatureValue;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.865 -0400", hash_original_method = "2BEC4272F0342CC60C1E5750AB362553", hash_generated_method = "80C212D7054336F30DC20FF180FC8C79")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.866 -0400", hash_original_method = "B4D994B87261FFD4B0816002B55F0788", hash_generated_method = "9CBE4B6A53BCBA78D40D9BEAA8A0C828")
    public  AttributeCertificate(
        ASN1Sequence    seq) {
        {
            boolean var01335131BE2224430AFFE0AC95254DF2_290019437 = (seq.size() != 3);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.871 -0400", hash_original_method = "B550BE2A3120BC2739AC35C67600D16E", hash_generated_method = "354F8243EE87209A301E72C1F5078CAF")
    public AttributeCertificateInfo getAcinfo() {
        AttributeCertificateInfo varB4EAC82CA7396A68D541C85D26508E83_1103821870 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1103821870 = acinfo;
        varB4EAC82CA7396A68D541C85D26508E83_1103821870.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1103821870;
        // ---------- Original Method ----------
        //return acinfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.874 -0400", hash_original_method = "7848C69970B1A1FD0A4AF2994EC6E56B", hash_generated_method = "13CF9C48BD245962A6CE8E7FE3735E41")
    public AlgorithmIdentifier getSignatureAlgorithm() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_1357676390 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1357676390 = signatureAlgorithm;
        varB4EAC82CA7396A68D541C85D26508E83_1357676390.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1357676390;
        // ---------- Original Method ----------
        //return signatureAlgorithm;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.879 -0400", hash_original_method = "C8410B5B4D26900579B7A994FFDFFA14", hash_generated_method = "196E5FA49BDBA2403BBA0675449E4A69")
    public DERBitString getSignatureValue() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1655972684 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1655972684 = signatureValue;
        varB4EAC82CA7396A68D541C85D26508E83_1655972684.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1655972684;
        // ---------- Original Method ----------
        //return signatureValue;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.879 -0400", hash_original_method = "EEF14432CC16BDD5140583520373DF2D", hash_generated_method = "EB0FE1641EAA7E4F0792FEBBF2FE5609")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1342801898 = null; //Variable for return #1
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(acinfo);
        v.add(signatureAlgorithm);
        v.add(signatureValue);
        varB4EAC82CA7396A68D541C85D26508E83_1342801898 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_1342801898.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1342801898;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(acinfo);
        //v.add(signatureAlgorithm);
        //v.add(signatureValue);
        //return new DERSequence(v);
    }

    
}

