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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.202 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "37E06257AFCE21CC4EDFE67F34DC271C")

    private ASN1Sequence seq;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.203 -0400", hash_original_method = "D12821E856A648EC440CD525D918157C", hash_generated_method = "045B9F4D1DB3350862A92FABEBA11593")
    public  ECPrivateKeyStructure(
        ASN1Sequence  seq) {
        this.seq = seq;
        // ---------- Original Method ----------
        //this.seq = seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.203 -0400", hash_original_method = "722B9EB1887267D3DC7C06AD31EE54C1", hash_generated_method = "770B6D228127F6B6DCF9AC1706BC7B67")
    public  ECPrivateKeyStructure(
        BigInteger  key) {
        byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        ASN1EncodableVector v = new ASN1EncodableVector();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.203 -0400", hash_original_method = "407D07F6896B0C0E44D96F389E9D6F27", hash_generated_method = "D4E9A760240B8E5C8CE0E4F4FF963196")
    public  ECPrivateKeyStructure(
        BigInteger    key,
        ASN1Encodable parameters) {
        this(key, null, parameters);
        addTaint(key.getTaint());
        addTaint(parameters.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.204 -0400", hash_original_method = "C18ECEEFE6A75682B0803E3F34C5782F", hash_generated_method = "143AAB36FCEEA926AFE6A6504489B779")
    public  ECPrivateKeyStructure(
        BigInteger    key,
        DERBitString  publicKey,
        ASN1Encodable parameters) {
        byte[] bytes = BigIntegers.asUnsignedByteArray(key);
        ASN1EncodableVector v = new ASN1EncodableVector();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.204 -0400", hash_original_method = "3364DFDFDAE0C599569065625E34DFA6", hash_generated_method = "EBC87F61A4E0B62E8C37308F715CB95B")
    public BigInteger getKey() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1471966077 = null; //Variable for return #1
        ASN1OctetString octs = (ASN1OctetString)seq.getObjectAt(1);
        varB4EAC82CA7396A68D541C85D26508E83_1471966077 = new BigInteger(1, octs.getOctets());
        varB4EAC82CA7396A68D541C85D26508E83_1471966077.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1471966077;
        // ---------- Original Method ----------
        //ASN1OctetString  octs = (ASN1OctetString)seq.getObjectAt(1);
        //return new BigInteger(1, octs.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.205 -0400", hash_original_method = "DEBAFCE224E8193448683CCA3427311E", hash_generated_method = "B701CDB2F7AFE3011F3FFBEB4D01FEDA")
    public DERBitString getPublicKey() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_592267222 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_592267222 = (DERBitString)getObjectInTag(1);
        varB4EAC82CA7396A68D541C85D26508E83_592267222.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_592267222;
        // ---------- Original Method ----------
        //return (DERBitString)getObjectInTag(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.206 -0400", hash_original_method = "6CC550729D926E5F97154297F8F1FBC7", hash_generated_method = "4027523A773E5CEEAF431CBF24AEF588")
    public ASN1Object getParameters() {
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_381596266 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_381596266 = getObjectInTag(0);
        varB4EAC82CA7396A68D541C85D26508E83_381596266.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_381596266;
        // ---------- Original Method ----------
        //return getObjectInTag(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.206 -0400", hash_original_method = "F319A866ECD7F1BB5BF305B540FF9ADA", hash_generated_method = "B1E8409DD63E3440B7C904EBA58D0E9B")
    private ASN1Object getObjectInTag(int tagNo) {
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_136258265 = null; //Variable for return #1
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_841617466 = null; //Variable for return #2
        Enumeration e = seq.getObjects();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1194277877 = (e.hasMoreElements());
            {
                DEREncodable obj = (DEREncodable)e.nextElement();
                {
                    ASN1TaggedObject tag = (ASN1TaggedObject)obj;
                    {
                        boolean varF75F79C9765056EBB1C119BE9C2CBA7C_610014599 = (tag.getTagNo() == tagNo);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_136258265 = (ASN1Object)((DEREncodable)tag.getObject()).getDERObject();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_841617466 = null;
        addTaint(tagNo);
        ASN1Object varA7E53CE21691AB073D9660D615818899_2072233296; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2072233296 = varB4EAC82CA7396A68D541C85D26508E83_136258265;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2072233296 = varB4EAC82CA7396A68D541C85D26508E83_841617466;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2072233296.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2072233296;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:44.208 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "B1E5F2A0276F30AC759652A524940BA1")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_1508724292 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1508724292 = seq;
        varB4EAC82CA7396A68D541C85D26508E83_1508724292.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1508724292;
        // ---------- Original Method ----------
        //return seq;
    }

    
}

