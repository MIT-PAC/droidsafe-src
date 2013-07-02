package org.bouncycastle.asn1.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBoolean;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERObjectIdentifier;
import org.bouncycastle.asn1.DERSequence;

public class X509Extensions extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.140 -0400", hash_original_field = "105BE7A9FF7D6C5D5059B1EFF7AB1646", hash_generated_field = "85AC76E085157FE5A5AA3FC59E707E22")

    private Hashtable extensions = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.140 -0400", hash_original_field = "1E8C32F4C6EEE7D3CD7F8426CD048BA3", hash_generated_field = "C8A65116741473EAA58816E75213B0AF")

    private Vector ordering = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.141 -0400", hash_original_method = "3183DF3CA73DB6F6A8B3F75392BBEFA5", hash_generated_method = "B5C678FF677D5DBF983EAA26672DC859")
    public  X509Extensions(
        ASN1Sequence  seq) {
        Enumeration e = seq.getObjects();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1708867452 = (e.hasMoreElements());
            {
                ASN1Sequence s = ASN1Sequence.getInstance(e.nextElement());
                {
                    boolean varA107F5BCC7EBE889658901554639B935_2032326702 = (s.size() == 3);
                    {
                        extensions.put(s.getObjectAt(0), new X509Extension(DERBoolean.getInstance(s.getObjectAt(1)), ASN1OctetString.getInstance(s.getObjectAt(2))));
                    } 
                    {
                        boolean var7A8DD9C81B4A19F5C9875366AA9E843A_437389202 = (s.size() == 2);
                        {
                            extensions.put(s.getObjectAt(0), new X509Extension(false, ASN1OctetString.getInstance(s.getObjectAt(1))));
                        } 
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + s.size());
                        } 
                    } 
                } 
                ordering.addElement(s.getObjectAt(0));
            } 
        } 
        addTaint(seq.getTaint());
        
        
        
        
            
            
            
                
            
            
            
                
            
            
            
                
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.142 -0400", hash_original_method = "80ADD1BFD3CFC1BF1C6C9D5CB6EC2CCC", hash_generated_method = "4B67402AB24333194B3BF1B465C71AEC")
    public  X509Extensions(
        Hashtable  extensions) {
        this(null, extensions);
        addTaint(extensions.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.143 -0400", hash_original_method = "F15F6ACF942D718DDD1781FCFE8FC099", hash_generated_method = "769DB1975B1DB36EBF94CDCE2B245E6F")
    public  X509Extensions(
        Vector      ordering,
        Hashtable   extensions) {
        Enumeration e;
        {
            e = extensions.keys();
        } 
        {
            e = ordering.elements();
        } 
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1448836909 = (e.hasMoreElements());
            {
                this.ordering.addElement(new ASN1ObjectIdentifier(((DERObjectIdentifier)e.nextElement()).getId()));
            } 
        } 
        e = this.ordering.elements();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1332029197 = (e.hasMoreElements());
            {
                ASN1ObjectIdentifier oid = new ASN1ObjectIdentifier(((DERObjectIdentifier)e.nextElement()).getId());
                X509Extension ext = (X509Extension)extensions.get(oid);
                this.extensions.put(oid, ext);
            } 
        } 
        addTaint(ordering.getTaint());
        addTaint(extensions.getTaint());
        
        
        
        
            
        
        
        
            
        
        
        
            
        
        
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.144 -0400", hash_original_method = "E35F3A8520AAABAE17BEC0E37B5A4B01", hash_generated_method = "F031B4A1912D002EDF0A84DF00907BC8")
    public  X509Extensions(
        Vector      objectIDs,
        Vector      values) {
        Enumeration e = objectIDs.elements();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_676462737 = (e.hasMoreElements());
            {
                this.ordering.addElement(e.nextElement());
            } 
        } 
        int count = 0;
        e = this.ordering.elements();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_22143115 = (e.hasMoreElements());
            {
                ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier)e.nextElement();
                X509Extension ext = (X509Extension)values.elementAt(count);
                this.extensions.put(oid, ext);
            } 
        } 
        addTaint(objectIDs.getTaint());
        addTaint(values.getTaint());
        
        
        
        
            
        
        
        
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SPEC)
    public static X509Extensions getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSModeled(DSC.SPEC)
    public static X509Extensions getInstance(
        Object  obj) {
        if (obj == null || obj instanceof X509Extensions)
        {
            return (X509Extensions)obj;
        }
        if (obj instanceof ASN1Sequence)
        {
            return new X509Extensions((ASN1Sequence)obj);
        }
        if (obj instanceof ASN1TaggedObject)
        {
            return getInstance(((ASN1TaggedObject)obj).getObject());
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.147 -0400", hash_original_method = "0B0DE464F6E47F31BA5D76DC9E3C9FC0", hash_generated_method = "5FE250B8116D9AAE1BA9F2A57FE4A18C")
    public Enumeration oids() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_751686496 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_751686496 = ordering.elements();
        varB4EAC82CA7396A68D541C85D26508E83_751686496.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_751686496;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.148 -0400", hash_original_method = "32E3424DB018CF6D737571FE1786BD03", hash_generated_method = "62F65D7D729364B6DB317B64D5A5F6CC")
    public X509Extension getExtension(
        ASN1ObjectIdentifier oid) {
        X509Extension varB4EAC82CA7396A68D541C85D26508E83_955734228 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_955734228 = (X509Extension)extensions.get(oid);
        addTaint(oid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_955734228.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_955734228;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.148 -0400", hash_original_method = "A84942282634A7C86CBBB6C3F2ED59CC", hash_generated_method = "151589F7F2BE31549DF553C7215BF3AE")
    public X509Extension getExtension(
        DERObjectIdentifier oid) {
        X509Extension varB4EAC82CA7396A68D541C85D26508E83_442088528 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_442088528 = (X509Extension)extensions.get(oid);
        addTaint(oid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_442088528.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_442088528;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.149 -0400", hash_original_method = "06CC66F9E5522E8DB7D5C647F513DEC9", hash_generated_method = "6D27312B8C3ED31275E1A706B8B16FF3")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_440642181 = null; 
        ASN1EncodableVector vec = new ASN1EncodableVector();
        Enumeration e = ordering.elements();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_126963308 = (e.hasMoreElements());
            {
                ASN1ObjectIdentifier oid = (ASN1ObjectIdentifier)e.nextElement();
                X509Extension ext = (X509Extension)extensions.get(oid);
                ASN1EncodableVector v = new ASN1EncodableVector();
                v.add(oid);
                {
                    boolean var7816F0C62AA0E520BF389863355D343E_1411340718 = (ext.isCritical());
                    {
                        v.add(DERBoolean.TRUE);
                    } 
                } 
                v.add(ext.getValue());
                vec.add(new DERSequence(v));
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_440642181 = new DERSequence(vec);
        varB4EAC82CA7396A68D541C85D26508E83_440642181.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_440642181;
        
        
        
        
        
            
            
            
            
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.149 -0400", hash_original_method = "5431038A2FDD7EE9A832630B10E5FEE7", hash_generated_method = "EFCE5395C3605D3D572F76C029485354")
    public boolean equivalent(
        X509Extensions other) {
        {
            boolean var78427A5A023D2089CAA0C625730BEE72_1970765254 = (extensions.size() != other.extensions.size());
        } 
        Enumeration e1 = extensions.keys();
        {
            boolean var4A02C0381DCCD850A4E226B0348EBD6A_176238934 = (e1.hasMoreElements());
            {
                Object key = e1.nextElement();
                {
                    boolean var0C796A4D8E08159D770F40CD4DD21F36_1896433157 = (!extensions.get(key).equals(other.extensions.get(key)));
                } 
            } 
        } 
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_538503120 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_538503120;
        
        
        
            
        
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.150 -0400", hash_original_method = "0A51D0A287CCFA511D40B874C91E938D", hash_generated_method = "62BEAE4D5E4540BD05C601586BC6FA0F")
    public ASN1ObjectIdentifier[] getExtensionOIDs() {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_1884650136 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1884650136 = toOidArray(ordering);
        varB4EAC82CA7396A68D541C85D26508E83_1884650136.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1884650136;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.150 -0400", hash_original_method = "38FDC56695894D5E3900BA7AB78B1602", hash_generated_method = "8882719A061DF3568E20AFD0586B8B79")
    public ASN1ObjectIdentifier[] getNonCriticalExtensionOIDs() {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_166085394 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_166085394 = getExtensionOIDs(false);
        varB4EAC82CA7396A68D541C85D26508E83_166085394.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_166085394;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.151 -0400", hash_original_method = "87563EF50C27322C30E8D92768AE9E02", hash_generated_method = "E2B4731FB360A8B757B7144933DD9894")
    public ASN1ObjectIdentifier[] getCriticalExtensionOIDs() {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_534601198 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_534601198 = getExtensionOIDs(true);
        varB4EAC82CA7396A68D541C85D26508E83_534601198.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_534601198;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.151 -0400", hash_original_method = "7A0D9F93C88DE50806BB985DD6BFA19B", hash_generated_method = "0B10881873CAF373B6299031410E1647")
    private ASN1ObjectIdentifier[] getExtensionOIDs(boolean isCritical) {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_198388677 = null; 
        Vector oidVec = new Vector();
        {
            int i = 0;
            boolean varB7FED1061E2523A61273B96DF514EF18_1919841129 = (i != ordering.size());
            {
                Object oid = ordering.elementAt(i);
                {
                    boolean var3E669AEF33CBA3BE6B5229508236DA62_987275970 = (((X509Extension)extensions.get(oid)).isCritical() == isCritical);
                    {
                        oidVec.addElement(oid);
                    } 
                } 
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_198388677 = toOidArray(oidVec);
        addTaint(isCritical);
        varB4EAC82CA7396A68D541C85D26508E83_198388677.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_198388677;
        
        
        
        
            
            
            
                
            
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_method = "4F14C515A25E2063508F233D1F460CFE", hash_generated_method = "92E1D1A68EDF3287A7D4692087B7F8EE")
    private ASN1ObjectIdentifier[] toOidArray(Vector oidVec) {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_586392646 = null; 
        ASN1ObjectIdentifier[] oids = new ASN1ObjectIdentifier[oidVec.size()];
        {
            int i = 0;
            {
                oids[i] = (ASN1ObjectIdentifier)oidVec.elementAt(i);
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_586392646 = oids;
        addTaint(oidVec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_586392646.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_586392646;
        
        
        
        
            
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "43772979E1D5C8391401228E38D68D3F", hash_generated_field = "CBD96C0AFD6F6669C30B5B7D696F8263")

    public static final ASN1ObjectIdentifier SubjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "9B94FEAC1FF0BCE3DC5FA6CFBF12AA79", hash_generated_field = "604C58F1142B3AFFCE41C896FA3F7785")

    public static final ASN1ObjectIdentifier SubjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "A5FCCADDD8804096F751A07C2C6DCF99", hash_generated_field = "05E75E3CCFA630353758EEE084A656A9")

    public static final ASN1ObjectIdentifier KeyUsage = new ASN1ObjectIdentifier("2.5.29.15");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "A98043E1BE5AA70B43A0DE7A18D9A395", hash_generated_field = "97E17E2E20D57D49BAB7D5659561A84A")

    public static final ASN1ObjectIdentifier PrivateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "AEC0DA0872050AC1528270A13269BCB6", hash_generated_field = "C3083C3FDEDE3241523FE6E1A321569C")

    public static final ASN1ObjectIdentifier SubjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "80AA7012E7C88F0D8E491271B583C587", hash_generated_field = "EBD3DC0BBC744C6AD9D88577D5E02689")

    public static final ASN1ObjectIdentifier IssuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "425C0A53325372896A614F043A8F1751", hash_generated_field = "7A77EBA72C76E4C07F9AE6482E3FEDBC")

    public static final ASN1ObjectIdentifier BasicConstraints = new ASN1ObjectIdentifier("2.5.29.19");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "A2BD7C97E4A4B1A88266E1952A71064E", hash_generated_field = "402B5C74329B052CE2282DEE9977FEC1")

    public static final ASN1ObjectIdentifier CRLNumber = new ASN1ObjectIdentifier("2.5.29.20");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "51B1B468F48D7024ADB33432B898547C", hash_generated_field = "26D7861BDC91BF19CC676B162DAEEDA0")

    public static final ASN1ObjectIdentifier ReasonCode = new ASN1ObjectIdentifier("2.5.29.21");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "66039CFEE667C1B0E7DFFFFD07BE1B2A", hash_generated_field = "444EEB78B6224D1F10592A18145096A1")

    public static final ASN1ObjectIdentifier InstructionCode = new ASN1ObjectIdentifier("2.5.29.23");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "1D7473A63C038E5CAFD37B9332DCCA8C", hash_generated_field = "50516B46D4F9AC4FF97BE9D05E44654B")

    public static final ASN1ObjectIdentifier InvalidityDate = new ASN1ObjectIdentifier("2.5.29.24");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "2C08D28FC3EB2279A28F06193738CCD9", hash_generated_field = "89C58CE6B202442339DACE4AF2328ACA")

    public static final ASN1ObjectIdentifier DeltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "925527ED9C54DE252BC87911700C6FA5", hash_generated_field = "0251A098151E69428EE10210AC12C23E")

    public static final ASN1ObjectIdentifier IssuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "6F978570D316714B09C8762A9D898BF9", hash_generated_field = "81BE99B7C7C5C728D839949081B63828")

    public static final ASN1ObjectIdentifier CertificateIssuer = new ASN1ObjectIdentifier("2.5.29.29");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "22F8E9CEAAC7FDAAEE8123B165D30796", hash_generated_field = "F557FF2D31EAFDE0DD6D1160647E8C99")

    public static final ASN1ObjectIdentifier NameConstraints = new ASN1ObjectIdentifier("2.5.29.30");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "8A4B5AE1725E2D051C2861C1D57BE0BA", hash_generated_field = "F9486D0ECD0D1C2A0815AF6CA8C70034")

    public static final ASN1ObjectIdentifier CRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "539CEE4DF562DBCB675A4BB878FFF648", hash_generated_field = "473484CA2D58104F8D50FFA6A4B56BB0")

    public static final ASN1ObjectIdentifier CertificatePolicies = new ASN1ObjectIdentifier("2.5.29.32");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "C51213D1050551677B59DF984F9E03E5", hash_generated_field = "3C8FFFCFDC181F51208FECE5FE8049AE")

    public static final ASN1ObjectIdentifier PolicyMappings = new ASN1ObjectIdentifier("2.5.29.33");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "3EA85AB7F30457EA95DB76BECA3EE950", hash_generated_field = "5E69B403C44943D938898F84EE2F51D6")

    public static final ASN1ObjectIdentifier AuthorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "7A91A63B9AAA247F7F804E1E9F716B6F", hash_generated_field = "2AB84E72AA866EDBC358064FE9EF404C")

    public static final ASN1ObjectIdentifier PolicyConstraints = new ASN1ObjectIdentifier("2.5.29.36");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "25085A8AC47B675BF5D730A32DF39EBA", hash_generated_field = "0433AE9B3707F9C945BB248814BF386E")

    public static final ASN1ObjectIdentifier ExtendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "391DCFE70906E30EDADBFA8ADF559F8B", hash_generated_field = "075C41376A5022ACC623633C5B4A108D")

    public static final ASN1ObjectIdentifier FreshestCRL = new ASN1ObjectIdentifier("2.5.29.46");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.152 -0400", hash_original_field = "F320B9137049E8A2AF44776B8BDE5149", hash_generated_field = "99A169313660BF483A94F60CA6D3DCD5")

    public static final ASN1ObjectIdentifier InhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.153 -0400", hash_original_field = "F1020F4794F2203A09B101D18C9344F9", hash_generated_field = "46D2F70980F4DB996CAEBDE3A2F9E000")

    public static final ASN1ObjectIdentifier AuthorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.153 -0400", hash_original_field = "C48D00DACF4688093BF474E027C5C966", hash_generated_field = "77E1302EECAC5D98F1D8FD1BF5717AE6")

    public static final ASN1ObjectIdentifier SubjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.153 -0400", hash_original_field = "7D8055A16AAEE31FF27A55FB30B1CE03", hash_generated_field = "0843906B6C0CB16E312BCDA07276E20D")

    public static final ASN1ObjectIdentifier LogoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.153 -0400", hash_original_field = "A5A10CB92D2DD3C65936B082E34C3F1B", hash_generated_field = "FD25CD479CE8E7DB0F7874AE4B79E7F6")

    public static final ASN1ObjectIdentifier BiometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.153 -0400", hash_original_field = "278A2A567B973E386FAEFC097B70214B", hash_generated_field = "76A329FB429DCE3469702D52D2D00E41")

    public static final ASN1ObjectIdentifier QCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.153 -0400", hash_original_field = "3F4E97497DA08B9C39FD95F7C1AB5F69", hash_generated_field = "D7FA7D7DAAA43945F26FCCF88B076927")

    public static final ASN1ObjectIdentifier AuditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.153 -0400", hash_original_field = "ACBEC409904466ED850DD2BA22773FB2", hash_generated_field = "6C673CF5AC60D0B1A0ED618AA5BE12FB")

    public static final ASN1ObjectIdentifier NoRevAvail = new ASN1ObjectIdentifier("2.5.29.56");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:15:45.153 -0400", hash_original_field = "9948D50C46D1F9018FC1B5660187A85E", hash_generated_field = "84330D8B4D2561FEE534906B43F4C1DC")

    public static final ASN1ObjectIdentifier TargetInformation = new ASN1ObjectIdentifier("2.5.29.55");
}

