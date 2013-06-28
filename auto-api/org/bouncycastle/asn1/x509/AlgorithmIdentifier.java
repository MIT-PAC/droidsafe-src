package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class AlgorithmIdentifier extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.613 -0400", hash_original_field = "16B2B26000987FACCB260B9D39DF1269", hash_generated_field = "75A30ECCFB17A30D42DFB8DB7660AF4A")

    private DERObjectIdentifier objectId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.613 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "41947DC48C64F495997946BB65CC2C26")

    private DEREncodable parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.613 -0400", hash_original_field = "F3A5FAF8ECCC2CFD16906F602223FAAB", hash_generated_field = "6ED074FF68FD154F1B7E3E532F3955CD")

    private boolean parametersDefined = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.614 -0400", hash_original_method = "93A0883FD6E1F9293F6274682F4F2B4C", hash_generated_method = "1DA8FD912619DBB1040C93CFE3399124")
    public  AlgorithmIdentifier(
        DERObjectIdentifier     objectId) {
        this.objectId = objectId;
        // ---------- Original Method ----------
        //this.objectId = objectId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.615 -0400", hash_original_method = "2C0F45B70A770504C9769255F4669C3E", hash_generated_method = "A476A63C87942A3D4251E44C5BD03CCE")
    public  AlgorithmIdentifier(
        String     objectId) {
        this.objectId = new DERObjectIdentifier(objectId);
        // ---------- Original Method ----------
        //this.objectId = new DERObjectIdentifier(objectId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.617 -0400", hash_original_method = "3ADDA70B8CE4A49F17EDAA7C48E2C341", hash_generated_method = "2A43329F4D0F38FF1AB09D21CDE10B8F")
    public  AlgorithmIdentifier(
        DERObjectIdentifier     objectId,
        DEREncodable            parameters) {
        parametersDefined = true;
        this.objectId = objectId;
        this.parameters = parameters;
        // ---------- Original Method ----------
        //parametersDefined = true;
        //this.objectId = objectId;
        //this.parameters = parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.619 -0400", hash_original_method = "DB91F54486D8AF4EDC548543A54F560A", hash_generated_method = "F41EA7D68228D2346E043DA84F8BB102")
    public  AlgorithmIdentifier(
        ASN1Sequence   seq) {
        {
            boolean var20EF5DADDEFE74257652D6C1EB58B13A_149869538 = (seq.size() < 1 || seq.size() > 2);
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            } //End block
        } //End collapsed parenthetic
        objectId = DERObjectIdentifier.getInstance(seq.getObjectAt(0));
        {
            boolean var5076DB63EBB40FD5F2A75B8F065FD702_158823793 = (seq.size() == 2);
            {
                parametersDefined = true;
                parameters = seq.getObjectAt(1);
            } //End block
            {
                parameters = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //if (seq.size() < 1 || seq.size() > 2)
        //{
            //throw new IllegalArgumentException("Bad sequence size: "
                    //+ seq.size());
        //}
        //objectId = DERObjectIdentifier.getInstance(seq.getObjectAt(0));
        //if (seq.size() == 2)
        //{
            //parametersDefined = true;
            //parameters = seq.getObjectAt(1);
        //}
        //else
        //{
            //parameters = null;
        //}
    }

    
    public static AlgorithmIdentifier getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    public static AlgorithmIdentifier getInstance(
        Object  obj) {
        if (obj== null || obj instanceof AlgorithmIdentifier)
        {
            return (AlgorithmIdentifier)obj;
        }
        if (obj instanceof DERObjectIdentifier)
        {
            return new AlgorithmIdentifier((DERObjectIdentifier)obj);
        }
        if (obj instanceof String)
        {
            return new AlgorithmIdentifier((String)obj);
        }
        if (obj instanceof ASN1Sequence)
        {
            return new AlgorithmIdentifier((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.621 -0400", hash_original_method = "CD881EFC58E30EDA4D15D9E8685CDAFE", hash_generated_method = "A5999F85530A8C0DDBAF3B476B92FF6E")
    public ASN1ObjectIdentifier getAlgorithm() {
        ASN1ObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_1869410557 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1869410557 = new ASN1ObjectIdentifier(objectId.getId());
        varB4EAC82CA7396A68D541C85D26508E83_1869410557.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1869410557;
        // ---------- Original Method ----------
        //return new ASN1ObjectIdentifier(objectId.getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.622 -0400", hash_original_method = "494BC62B0A8F124F83635D3540B715A4", hash_generated_method = "9998F8D490D822E50AAE036250EC51CF")
    public DERObjectIdentifier getObjectId() {
        DERObjectIdentifier varB4EAC82CA7396A68D541C85D26508E83_739947912 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_739947912 = objectId;
        varB4EAC82CA7396A68D541C85D26508E83_739947912.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_739947912;
        // ---------- Original Method ----------
        //return objectId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.622 -0400", hash_original_method = "89C55006FD45E6E61AF55DE1360B9A68", hash_generated_method = "E87ABCB7211975F8FE4134837F402DD2")
    public DEREncodable getParameters() {
        DEREncodable varB4EAC82CA7396A68D541C85D26508E83_1795258617 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1795258617 = parameters;
        varB4EAC82CA7396A68D541C85D26508E83_1795258617.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1795258617;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.623 -0400", hash_original_method = "51F3CA499FC5330FCCD6B589EECABC9B", hash_generated_method = "E21260F21DB015C55714FC2198EE82AA")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_586722487 = null; //Variable for return #1
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(objectId);
        {
            {
                v.add(parameters);
            } //End block
            {
                v.add(DERNull.INSTANCE);
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_586722487 = new DERSequence(v);
        varB4EAC82CA7396A68D541C85D26508E83_586722487.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_586722487;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(objectId);
        //if (parametersDefined)
        //{
            //if (parameters != null)
            //{
                //v.add(parameters);
            //}
            //else
            //{
                //v.add(DERNull.INSTANCE);
            //}
        //}
        //return new DERSequence(v);
    }

    
}

