package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.406 -0400", hash_original_field = "16B2B26000987FACCB260B9D39DF1269", hash_generated_field = "75A30ECCFB17A30D42DFB8DB7660AF4A")

    private DERObjectIdentifier objectId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.406 -0400", hash_original_field = "166E64F6C3677D0C513901242A3E702D", hash_generated_field = "41947DC48C64F495997946BB65CC2C26")

    private DEREncodable parameters;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.406 -0400", hash_original_field = "F3A5FAF8ECCC2CFD16906F602223FAAB", hash_generated_field = "6ED074FF68FD154F1B7E3E532F3955CD")

    private boolean parametersDefined = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.407 -0400", hash_original_method = "93A0883FD6E1F9293F6274682F4F2B4C", hash_generated_method = "1DA8FD912619DBB1040C93CFE3399124")
    public  AlgorithmIdentifier(
        DERObjectIdentifier     objectId) {
        this.objectId = objectId;
        // ---------- Original Method ----------
        //this.objectId = objectId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.407 -0400", hash_original_method = "2C0F45B70A770504C9769255F4669C3E", hash_generated_method = "A476A63C87942A3D4251E44C5BD03CCE")
    public  AlgorithmIdentifier(
        String     objectId) {
        this.objectId = new DERObjectIdentifier(objectId);
        // ---------- Original Method ----------
        //this.objectId = new DERObjectIdentifier(objectId);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.408 -0400", hash_original_method = "3ADDA70B8CE4A49F17EDAA7C48E2C341", hash_generated_method = "2A43329F4D0F38FF1AB09D21CDE10B8F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.409 -0400", hash_original_method = "DB91F54486D8AF4EDC548543A54F560A", hash_generated_method = "9E1A992678E99A8C6AF73AF66DECF04E")
    public  AlgorithmIdentifier(
        ASN1Sequence   seq) {
    if(seq.size() < 1 || seq.size() > 2)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1607612515 = new IllegalArgumentException("Bad sequence size: "
                    + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_1607612515.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1607612515;
        } //End block
        objectId = DERObjectIdentifier.getInstance(seq.getObjectAt(0));
    if(seq.size() == 2)        
        {
            parametersDefined = true;
            parameters = seq.getObjectAt(1);
        } //End block
        else
        {
            parameters = null;
        } //End block
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

    
        @DSModeled(DSC.SPEC)
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.410 -0400", hash_original_method = "CD881EFC58E30EDA4D15D9E8685CDAFE", hash_generated_method = "D423C9463CC8537329727323F60ACD0B")
    public ASN1ObjectIdentifier getAlgorithm() {
ASN1ObjectIdentifier var554FF09B66A4F1AE1E145F3ACDB8AE2B_740864200 =         new ASN1ObjectIdentifier(objectId.getId());
        var554FF09B66A4F1AE1E145F3ACDB8AE2B_740864200.addTaint(taint);
        return var554FF09B66A4F1AE1E145F3ACDB8AE2B_740864200;
        // ---------- Original Method ----------
        //return new ASN1ObjectIdentifier(objectId.getId());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.410 -0400", hash_original_method = "494BC62B0A8F124F83635D3540B715A4", hash_generated_method = "F492981BE9CCF4A2124A29B74FA48D1E")
    public DERObjectIdentifier getObjectId() {
DERObjectIdentifier varDDC1E4C9E86BED9BF72D472958F53326_915821536 =         objectId;
        varDDC1E4C9E86BED9BF72D472958F53326_915821536.addTaint(taint);
        return varDDC1E4C9E86BED9BF72D472958F53326_915821536;
        // ---------- Original Method ----------
        //return objectId;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.410 -0400", hash_original_method = "89C55006FD45E6E61AF55DE1360B9A68", hash_generated_method = "7D8B90A063B57304D394016CD15D15D0")
    public DEREncodable getParameters() {
DEREncodable var3CB0A38B794BDEDADB1F50256E0AE35B_2055964195 =         parameters;
        var3CB0A38B794BDEDADB1F50256E0AE35B_2055964195.addTaint(taint);
        return var3CB0A38B794BDEDADB1F50256E0AE35B_2055964195;
        // ---------- Original Method ----------
        //return parameters;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:21.410 -0400", hash_original_method = "51F3CA499FC5330FCCD6B589EECABC9B", hash_generated_method = "F57882D20CA010A53C0DC6C40624E46B")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(objectId);
    if(parametersDefined)        
        {
    if(parameters != null)            
            {
                v.add(parameters);
            } //End block
            else
            {
                v.add(DERNull.INSTANCE);
            } //End block
        } //End block
DERObject var0B338F106E3279986C87B595B0F4A439_1746914944 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1746914944.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1746914944;
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

