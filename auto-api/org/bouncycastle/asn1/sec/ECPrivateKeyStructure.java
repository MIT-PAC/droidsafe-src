package org.bouncycastle.asn1.sec;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DEREncodable;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.util.BigIntegers;

public class ECPrivateKeyStructure extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.659 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "37E06257AFCE21CC4EDFE67F34DC271C")

    private ASN1Sequence seq;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.660 -0400", hash_original_method = "D12821E856A648EC440CD525D918157C", hash_generated_method = "045B9F4D1DB3350862A92FABEBA11593")
    public  ECPrivateKeyStructure(
        ASN1Sequence  seq) {
        this.seq = seq;
        // ---------- Original Method ----------
        //this.seq = seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.660 -0400", hash_original_method = "722B9EB1887267D3DC7C06AD31EE54C1", hash_generated_method = "F7AB907F160219F216497E1C8BF3CCBD")
    public  ECPrivateKeyStructure(
        BigInteger  key) {
        byte[] bytes;
        bytes = BigIntegers.asUnsignedByteArray(key);
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(new DERInteger(1));
        v.add(new DEROctetString(bytes));
        seq = new DERSequence(v);
        addTaint(key.getTaint());
        // ---------- Original Method ----------
        //byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(new DERInteger(1));
        //v.add(new DEROctetString(bytes));
        //seq = new DERSequence(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.671 -0400", hash_original_method = "407D07F6896B0C0E44D96F389E9D6F27", hash_generated_method = "D4E9A760240B8E5C8CE0E4F4FF963196")
    public  ECPrivateKeyStructure(
        BigInteger    key,
        ASN1Encodable parameters) {
        this(key, null, parameters);
        addTaint(key.getTaint());
        addTaint(parameters.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.671 -0400", hash_original_method = "C18ECEEFE6A75682B0803E3F34C5782F", hash_generated_method = "A066C542036F56D594A6ABEF6CC2CEBE")
    public  ECPrivateKeyStructure(
        BigInteger    key,
        DERBitString  publicKey,
        ASN1Encodable parameters) {
        byte[] bytes;
        bytes = BigIntegers.asUnsignedByteArray(key);
        ASN1EncodableVector v;
        v = new ASN1EncodableVector();
        v.add(new DERInteger(1));
        v.add(new DEROctetString(bytes));
        {
            v.add(new DERTaggedObject(true, 0, parameters));
        } //End block
        {
            v.add(new DERTaggedObject(true, 1, publicKey));
        } //End block
        seq = new DERSequence(v);
        addTaint(key.getTaint());
        addTaint(publicKey.getTaint());
        addTaint(parameters.getTaint());
        // ---------- Original Method ----------
        //byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        //ASN1EncodableVector v = new ASN1EncodableVector();
        //v.add(new DERInteger(1));
        //v.add(new DEROctetString(bytes));
        //if (parameters != null)
        //{
            //v.add(new DERTaggedObject(true, 0, parameters));
        //}
        //if (publicKey != null)
        //{
            //v.add(new DERTaggedObject(true, 1, publicKey));
        //}
        //seq = new DERSequence(v);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.672 -0400", hash_original_method = "3364DFDFDAE0C599569065625E34DFA6", hash_generated_method = "2A69123932236849D5CE46C11E89B46B")
    public BigInteger getKey() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_425452203 = null; //Variable for return #1
        ASN1OctetString octs;
        octs = (ASN1OctetString)seq.getObjectAt(1);
        varB4EAC82CA7396A68D541C85D26508E83_425452203 = new BigInteger(1, octs.getOctets());
        varB4EAC82CA7396A68D541C85D26508E83_425452203.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_425452203;
        // ---------- Original Method ----------
        //ASN1OctetString  octs = (ASN1OctetString)seq.getObjectAt(1);
        //return new BigInteger(1, octs.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.672 -0400", hash_original_method = "DEBAFCE224E8193448683CCA3427311E", hash_generated_method = "ECD7312A0D9E0E83D5648DAE50DC3AF6")
    public DERBitString getPublicKey() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_671106175 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_671106175 = (DERBitString)getObjectInTag(1);
        varB4EAC82CA7396A68D541C85D26508E83_671106175.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_671106175;
        // ---------- Original Method ----------
        //return (DERBitString)getObjectInTag(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.672 -0400", hash_original_method = "6CC550729D926E5F97154297F8F1FBC7", hash_generated_method = "A76E1092C45784C179EB4C787D490EC6")
    public ASN1Object getParameters() {
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_294530631 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_294530631 = getObjectInTag(0);
        varB4EAC82CA7396A68D541C85D26508E83_294530631.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_294530631;
        // ---------- Original Method ----------
        //return getObjectInTag(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.673 -0400", hash_original_method = "F319A866ECD7F1BB5BF305B540FF9ADA", hash_generated_method = "F552304CA07E45F2E213C0970734618A")
    private ASN1Object getObjectInTag(int tagNo) {
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_979977321 = null; //Variable for return #1
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_175084691 = null; //Variable for return #2
        Enumeration e;
        e = seq.getObjects();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_855038445 = (e.hasMoreElements());
            {
                DEREncodable obj;
                obj = (DEREncodable)e.nextElement();
                {
                    ASN1TaggedObject tag;
                    tag = (ASN1TaggedObject)obj;
                    {
                        boolean varF75F79C9765056EBB1C119BE9C2CBA7C_954447885 = (tag.getTagNo() == tagNo);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_979977321 = (ASN1Object)((DEREncodable)tag.getObject()).getDERObject();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_175084691 = null;
        addTaint(tagNo);
        ASN1Object varA7E53CE21691AB073D9660D615818899_856984102; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_856984102 = varB4EAC82CA7396A68D541C85D26508E83_979977321;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_856984102 = varB4EAC82CA7396A68D541C85D26508E83_175084691;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_856984102.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_856984102;
        // ---------- Original Method ----------
        //Enumeration e = seq.getObjects();
        //while (e.hasMoreElements())
        //{
            //DEREncodable obj = (DEREncodable)e.nextElement();
            //if (obj instanceof ASN1TaggedObject)
            //{
                //ASN1TaggedObject tag = (ASN1TaggedObject)obj;
                //if (tag.getTagNo() == tagNo)
                //{
                    //return (ASN1Object)((DEREncodable)tag.getObject()).getDERObject();
                //}
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:19.685 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "4785FF99B4000BFFAE20776F2CBDBF83")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_138628340 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_138628340 = seq;
        varB4EAC82CA7396A68D541C85D26508E83_138628340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_138628340;
        // ---------- Original Method ----------
        //return seq;
    }

    
}

