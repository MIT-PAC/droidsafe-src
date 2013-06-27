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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.577 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "37E06257AFCE21CC4EDFE67F34DC271C")

    private ASN1Sequence seq;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.578 -0400", hash_original_method = "D12821E856A648EC440CD525D918157C", hash_generated_method = "045B9F4D1DB3350862A92FABEBA11593")
    public  ECPrivateKeyStructure(
        ASN1Sequence  seq) {
        this.seq = seq;
        // ---------- Original Method ----------
        //this.seq = seq;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.579 -0400", hash_original_method = "722B9EB1887267D3DC7C06AD31EE54C1", hash_generated_method = "F7AB907F160219F216497E1C8BF3CCBD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.584 -0400", hash_original_method = "407D07F6896B0C0E44D96F389E9D6F27", hash_generated_method = "D4E9A760240B8E5C8CE0E4F4FF963196")
    public  ECPrivateKeyStructure(
        BigInteger    key,
        ASN1Encodable parameters) {
        this(key, null, parameters);
        addTaint(key.getTaint());
        addTaint(parameters.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.584 -0400", hash_original_method = "C18ECEEFE6A75682B0803E3F34C5782F", hash_generated_method = "A066C542036F56D594A6ABEF6CC2CEBE")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.587 -0400", hash_original_method = "3364DFDFDAE0C599569065625E34DFA6", hash_generated_method = "DA5736BE59BE8AAB5FB87608B83A2A40")
    public BigInteger getKey() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1514408210 = null; //Variable for return #1
        ASN1OctetString octs;
        octs = (ASN1OctetString)seq.getObjectAt(1);
        varB4EAC82CA7396A68D541C85D26508E83_1514408210 = new BigInteger(1, octs.getOctets());
        varB4EAC82CA7396A68D541C85D26508E83_1514408210.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1514408210;
        // ---------- Original Method ----------
        //ASN1OctetString  octs = (ASN1OctetString)seq.getObjectAt(1);
        //return new BigInteger(1, octs.getOctets());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.596 -0400", hash_original_method = "DEBAFCE224E8193448683CCA3427311E", hash_generated_method = "1DC4620BA326949D24DDED1A1C5032BE")
    public DERBitString getPublicKey() {
        DERBitString varB4EAC82CA7396A68D541C85D26508E83_1845565738 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1845565738 = (DERBitString)getObjectInTag(1);
        varB4EAC82CA7396A68D541C85D26508E83_1845565738.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1845565738;
        // ---------- Original Method ----------
        //return (DERBitString)getObjectInTag(1);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.596 -0400", hash_original_method = "6CC550729D926E5F97154297F8F1FBC7", hash_generated_method = "BE7E50DB2095BDA1BF7E8D50535EDCB4")
    public ASN1Object getParameters() {
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_839437493 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_839437493 = getObjectInTag(0);
        varB4EAC82CA7396A68D541C85D26508E83_839437493.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_839437493;
        // ---------- Original Method ----------
        //return getObjectInTag(0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.598 -0400", hash_original_method = "F319A866ECD7F1BB5BF305B540FF9ADA", hash_generated_method = "7F142904B5F0A61E3CD048DA7DD4FA07")
    private ASN1Object getObjectInTag(int tagNo) {
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_1558749364 = null; //Variable for return #1
        ASN1Object varB4EAC82CA7396A68D541C85D26508E83_1053046393 = null; //Variable for return #2
        Enumeration e;
        e = seq.getObjects();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1205284034 = (e.hasMoreElements());
            {
                DEREncodable obj;
                obj = (DEREncodable)e.nextElement();
                {
                    ASN1TaggedObject tag;
                    tag = (ASN1TaggedObject)obj;
                    {
                        boolean varF75F79C9765056EBB1C119BE9C2CBA7C_767103488 = (tag.getTagNo() == tagNo);
                        {
                            varB4EAC82CA7396A68D541C85D26508E83_1558749364 = (ASN1Object)((DEREncodable)tag.getObject()).getDERObject();
                        } //End block
                    } //End collapsed parenthetic
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1053046393 = null;
        addTaint(tagNo);
        ASN1Object varA7E53CE21691AB073D9660D615818899_479363960; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_479363960 = varB4EAC82CA7396A68D541C85D26508E83_1558749364;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_479363960 = varB4EAC82CA7396A68D541C85D26508E83_1053046393;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_479363960.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_479363960;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:18.598 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "8FA5C7FD83D3A22FF5418B784278BDF0")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_2006612223 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2006612223 = seq;
        varB4EAC82CA7396A68D541C85D26508E83_2006612223.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2006612223;
        // ---------- Original Method ----------
        //return seq;
    }

    
}

