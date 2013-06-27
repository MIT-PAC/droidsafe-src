package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.291 -0400", hash_original_field = "105BE7A9FF7D6C5D5059B1EFF7AB1646", hash_generated_field = "85AC76E085157FE5A5AA3FC59E707E22")

    private Hashtable extensions = new Hashtable();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.291 -0400", hash_original_field = "1E8C32F4C6EEE7D3CD7F8426CD048BA3", hash_generated_field = "C8A65116741473EAA58816E75213B0AF")

    private Vector ordering = new Vector();
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.297 -0400", hash_original_method = "3183DF3CA73DB6F6A8B3F75392BBEFA5", hash_generated_method = "E58EE7B0D87D4DD12202BBBEE54A56BD")
    public  X509Extensions(
        ASN1Sequence  seq) {
        Enumeration e;
        e = seq.getObjects();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_154429974 = (e.hasMoreElements());
            {
                ASN1Sequence s;
                s = ASN1Sequence.getInstance(e.nextElement());
                {
                    boolean varA107F5BCC7EBE889658901554639B935_455799499 = (s.size() == 3);
                    {
                        extensions.put(s.getObjectAt(0), new X509Extension(DERBoolean.getInstance(s.getObjectAt(1)), ASN1OctetString.getInstance(s.getObjectAt(2))));
                    } //End block
                    {
                        boolean var7A8DD9C81B4A19F5C9875366AA9E843A_157366395 = (s.size() == 2);
                        {
                            extensions.put(s.getObjectAt(0), new X509Extension(false, ASN1OctetString.getInstance(s.getObjectAt(1))));
                        } //End block
                        {
                            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("Bad sequence size: " + s.size());
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
                ordering.addElement(s.getObjectAt(0));
            } //End block
        } //End collapsed parenthetic
        addTaint(seq.getTaint());
        // ---------- Original Method ----------
        //Enumeration e = seq.getObjects();
        //while (e.hasMoreElements())
        //{
            //ASN1Sequence            s = ASN1Sequence.getInstance(e.nextElement());
            //if (s.size() == 3)
            //{
                //extensions.put(s.getObjectAt(0), new X509Extension(DERBoolean.getInstance(s.getObjectAt(1)), ASN1OctetString.getInstance(s.getObjectAt(2))));
            //}
            //else if (s.size() == 2)
            //{
                //extensions.put(s.getObjectAt(0), new X509Extension(false, ASN1OctetString.getInstance(s.getObjectAt(1))));
            //}
            //else
            //{
                //throw new IllegalArgumentException("Bad sequence size: " + s.size());
            //}
            //ordering.addElement(s.getObjectAt(0));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.299 -0400", hash_original_method = "80ADD1BFD3CFC1BF1C6C9D5CB6EC2CCC", hash_generated_method = "4B67402AB24333194B3BF1B465C71AEC")
    public  X509Extensions(
        Hashtable  extensions) {
        this(null, extensions);
        addTaint(extensions.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.313 -0400", hash_original_method = "F15F6ACF942D718DDD1781FCFE8FC099", hash_generated_method = "C8DBA2B361C7310DEA7955F63DEDDC6B")
    public  X509Extensions(
        Vector      ordering,
        Hashtable   extensions) {
        Enumeration e;
        {
            e = extensions.keys();
        } //End block
        {
            e = ordering.elements();
        } //End block
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1996565838 = (e.hasMoreElements());
            {
                this.ordering.addElement(new ASN1ObjectIdentifier(((DERObjectIdentifier)e.nextElement()).getId()));
            } //End block
        } //End collapsed parenthetic
        e = this.ordering.elements();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1017515569 = (e.hasMoreElements());
            {
                ASN1ObjectIdentifier oid;
                oid = new ASN1ObjectIdentifier(((DERObjectIdentifier)e.nextElement()).getId());
                X509Extension ext;
                ext = (X509Extension)extensions.get(oid);
                this.extensions.put(oid, ext);
            } //End block
        } //End collapsed parenthetic
        addTaint(ordering.getTaint());
        addTaint(extensions.getTaint());
        // ---------- Original Method ----------
        //Enumeration e;
        //if (ordering == null)
        //{
            //e = extensions.keys();
        //}
        //else
        //{
            //e = ordering.elements();
        //}
        //while (e.hasMoreElements())
        //{
            //this.ordering.addElement(new ASN1ObjectIdentifier(((DERObjectIdentifier)e.nextElement()).getId())); 
        //}
        //e = this.ordering.elements();
        //while (e.hasMoreElements())
        //{
            //ASN1ObjectIdentifier     oid = new ASN1ObjectIdentifier(((DERObjectIdentifier)e.nextElement()).getId());
            //X509Extension           ext = (X509Extension)extensions.get(oid);
            //this.extensions.put(oid, ext);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.314 -0400", hash_original_method = "E35F3A8520AAABAE17BEC0E37B5A4B01", hash_generated_method = "83617F078C999BFADF2B795B90ACAD42")
    public  X509Extensions(
        Vector      objectIDs,
        Vector      values) {
        Enumeration e;
        e = objectIDs.elements();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1938852706 = (e.hasMoreElements());
            {
                this.ordering.addElement(e.nextElement());
            } //End block
        } //End collapsed parenthetic
        int count;
        count = 0;
        e = this.ordering.elements();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1343125174 = (e.hasMoreElements());
            {
                ASN1ObjectIdentifier oid;
                oid = (ASN1ObjectIdentifier)e.nextElement();
                X509Extension ext;
                ext = (X509Extension)values.elementAt(count);
                this.extensions.put(oid, ext);
            } //End block
        } //End collapsed parenthetic
        addTaint(objectIDs.getTaint());
        addTaint(values.getTaint());
        // ---------- Original Method ----------
        //Enumeration e = objectIDs.elements();
        //while (e.hasMoreElements())
        //{
            //this.ordering.addElement(e.nextElement()); 
        //}
        //int count = 0;
        //e = this.ordering.elements();
        //while (e.hasMoreElements())
        //{
            //ASN1ObjectIdentifier     oid = (ASN1ObjectIdentifier)e.nextElement();
            //X509Extension           ext = (X509Extension)values.elementAt(count);
            //this.extensions.put(oid, ext);
            //count++;
        //}
    }

    
        public static X509Extensions getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.315 -0400", hash_original_method = "0B0DE464F6E47F31BA5D76DC9E3C9FC0", hash_generated_method = "737BD794E747F203A3C1B3BD0D0D5F40")
    public Enumeration oids() {
        Enumeration varB4EAC82CA7396A68D541C85D26508E83_1868107976 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1868107976 = ordering.elements();
        varB4EAC82CA7396A68D541C85D26508E83_1868107976.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1868107976;
        // ---------- Original Method ----------
        //return ordering.elements();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.315 -0400", hash_original_method = "32E3424DB018CF6D737571FE1786BD03", hash_generated_method = "126090C68F988567B1FA468EE4AA1FB8")
    public X509Extension getExtension(
        ASN1ObjectIdentifier oid) {
        X509Extension varB4EAC82CA7396A68D541C85D26508E83_164459811 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_164459811 = (X509Extension)extensions.get(oid);
        addTaint(oid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_164459811.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_164459811;
        // ---------- Original Method ----------
        //return (X509Extension)extensions.get(oid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.316 -0400", hash_original_method = "A84942282634A7C86CBBB6C3F2ED59CC", hash_generated_method = "A0D1ADA8548F9267DB7308F24FEF4FA5")
    public X509Extension getExtension(
        DERObjectIdentifier oid) {
        X509Extension varB4EAC82CA7396A68D541C85D26508E83_1840962227 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1840962227 = (X509Extension)extensions.get(oid);
        addTaint(oid.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1840962227.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1840962227;
        // ---------- Original Method ----------
        //return (X509Extension)extensions.get(oid);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.316 -0400", hash_original_method = "06CC66F9E5522E8DB7D5C647F513DEC9", hash_generated_method = "1C8A2F361782B93BAAC97726A7A6ACCC")
    public DERObject toASN1Object() {
        DERObject varB4EAC82CA7396A68D541C85D26508E83_342574825 = null; //Variable for return #1
        ASN1EncodableVector vec;
        vec = new ASN1EncodableVector();
        Enumeration e;
        e = ordering.elements();
        {
            boolean var3EB0A96682EDBE15308427BAC1EC4A4E_1735727630 = (e.hasMoreElements());
            {
                ASN1ObjectIdentifier oid;
                oid = (ASN1ObjectIdentifier)e.nextElement();
                X509Extension ext;
                ext = (X509Extension)extensions.get(oid);
                ASN1EncodableVector v;
                v = new ASN1EncodableVector();
                v.add(oid);
                {
                    boolean var7816F0C62AA0E520BF389863355D343E_1643790084 = (ext.isCritical());
                    {
                        v.add(DERBoolean.TRUE);
                    } //End block
                } //End collapsed parenthetic
                v.add(ext.getValue());
                vec.add(new DERSequence(v));
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_342574825 = new DERSequence(vec);
        varB4EAC82CA7396A68D541C85D26508E83_342574825.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_342574825;
        // ---------- Original Method ----------
        //ASN1EncodableVector     vec = new ASN1EncodableVector();
        //Enumeration             e = ordering.elements();
        //while (e.hasMoreElements())
        //{
            //ASN1ObjectIdentifier     oid = (ASN1ObjectIdentifier)e.nextElement();
            //X509Extension           ext = (X509Extension)extensions.get(oid);
            //ASN1EncodableVector     v = new ASN1EncodableVector();
            //v.add(oid);
            //if (ext.isCritical())
            //{
                //v.add(DERBoolean.TRUE);
            //}
            //v.add(ext.getValue());
            //vec.add(new DERSequence(v));
        //}
        //return new DERSequence(vec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.320 -0400", hash_original_method = "5431038A2FDD7EE9A832630B10E5FEE7", hash_generated_method = "B5A76793EB54636B8BA1BBC726A3FA83")
    public boolean equivalent(
        X509Extensions other) {
        {
            boolean var78427A5A023D2089CAA0C625730BEE72_1282121057 = (extensions.size() != other.extensions.size());
        } //End collapsed parenthetic
        Enumeration e1;
        e1 = extensions.keys();
        {
            boolean var4A02C0381DCCD850A4E226B0348EBD6A_1880252699 = (e1.hasMoreElements());
            {
                Object key;
                key = e1.nextElement();
                {
                    boolean var0C796A4D8E08159D770F40CD4DD21F36_466767879 = (!extensions.get(key).equals(other.extensions.get(key)));
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1827742542 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1827742542;
        // ---------- Original Method ----------
        //if (extensions.size() != other.extensions.size())
        //{
            //return false;
        //}
        //Enumeration     e1 = extensions.keys();
        //while (e1.hasMoreElements())
        //{
            //Object  key = e1.nextElement();
            //if (!extensions.get(key).equals(other.extensions.get(key)))
            //{
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.321 -0400", hash_original_method = "0A51D0A287CCFA511D40B874C91E938D", hash_generated_method = "0A03577C3A4298FC98CA605A9456D023")
    public ASN1ObjectIdentifier[] getExtensionOIDs() {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_1782634123 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1782634123 = toOidArray(ordering);
        varB4EAC82CA7396A68D541C85D26508E83_1782634123.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1782634123;
        // ---------- Original Method ----------
        //return toOidArray(ordering);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.321 -0400", hash_original_method = "38FDC56695894D5E3900BA7AB78B1602", hash_generated_method = "E0830B0721CD96E6F0236E70DA1F5501")
    public ASN1ObjectIdentifier[] getNonCriticalExtensionOIDs() {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_2006122429 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2006122429 = getExtensionOIDs(false);
        varB4EAC82CA7396A68D541C85D26508E83_2006122429.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2006122429;
        // ---------- Original Method ----------
        //return getExtensionOIDs(false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.332 -0400", hash_original_method = "87563EF50C27322C30E8D92768AE9E02", hash_generated_method = "0E46E219FDE06125E2C900FC263C54F7")
    public ASN1ObjectIdentifier[] getCriticalExtensionOIDs() {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_2097564164 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2097564164 = getExtensionOIDs(true);
        varB4EAC82CA7396A68D541C85D26508E83_2097564164.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2097564164;
        // ---------- Original Method ----------
        //return getExtensionOIDs(true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.334 -0400", hash_original_method = "7A0D9F93C88DE50806BB985DD6BFA19B", hash_generated_method = "9DA7684AD1B69C569CE650204C1E6B13")
    private ASN1ObjectIdentifier[] getExtensionOIDs(boolean isCritical) {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_599427814 = null; //Variable for return #1
        Vector oidVec;
        oidVec = new Vector();
        {
            int i;
            i = 0;
            boolean varB7FED1061E2523A61273B96DF514EF18_1818919318 = (i != ordering.size());
            {
                Object oid;
                oid = ordering.elementAt(i);
                {
                    boolean var3E669AEF33CBA3BE6B5229508236DA62_1235868337 = (((X509Extension)extensions.get(oid)).isCritical() == isCritical);
                    {
                        oidVec.addElement(oid);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_599427814 = toOidArray(oidVec);
        addTaint(isCritical);
        varB4EAC82CA7396A68D541C85D26508E83_599427814.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_599427814;
        // ---------- Original Method ----------
        //Vector oidVec = new Vector();
        //for (int i = 0; i != ordering.size(); i++)
        //{
            //Object oid = ordering.elementAt(i);
            //if (((X509Extension)extensions.get(oid)).isCritical() == isCritical)
            //{
                //oidVec.addElement(oid);
            //}
        //}
        //return toOidArray(oidVec);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_method = "4F14C515A25E2063508F233D1F460CFE", hash_generated_method = "C503CAE142FC121BBB0E65662839D054")
    private ASN1ObjectIdentifier[] toOidArray(Vector oidVec) {
        ASN1ObjectIdentifier[] varB4EAC82CA7396A68D541C85D26508E83_850985131 = null; //Variable for return #1
        ASN1ObjectIdentifier[] oids;
        oids = new ASN1ObjectIdentifier[oidVec.size()];
        {
            int i;
            i = 0;
            {
                oids[i] = (ASN1ObjectIdentifier)oidVec.elementAt(i);
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_850985131 = oids;
        addTaint(oidVec.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_850985131.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_850985131;
        // ---------- Original Method ----------
        //ASN1ObjectIdentifier[] oids = new ASN1ObjectIdentifier[oidVec.size()];
        //for (int i = 0; i != oids.length; i++)
        //{
            //oids[i] = (ASN1ObjectIdentifier)oidVec.elementAt(i);
        //}
        //return oids;
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "43772979E1D5C8391401228E38D68D3F", hash_generated_field = "CBD96C0AFD6F6669C30B5B7D696F8263")

    public static final ASN1ObjectIdentifier SubjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "9B94FEAC1FF0BCE3DC5FA6CFBF12AA79", hash_generated_field = "604C58F1142B3AFFCE41C896FA3F7785")

    public static final ASN1ObjectIdentifier SubjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "A5FCCADDD8804096F751A07C2C6DCF99", hash_generated_field = "05E75E3CCFA630353758EEE084A656A9")

    public static final ASN1ObjectIdentifier KeyUsage = new ASN1ObjectIdentifier("2.5.29.15");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "A98043E1BE5AA70B43A0DE7A18D9A395", hash_generated_field = "97E17E2E20D57D49BAB7D5659561A84A")

    public static final ASN1ObjectIdentifier PrivateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "AEC0DA0872050AC1528270A13269BCB6", hash_generated_field = "C3083C3FDEDE3241523FE6E1A321569C")

    public static final ASN1ObjectIdentifier SubjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "80AA7012E7C88F0D8E491271B583C587", hash_generated_field = "EBD3DC0BBC744C6AD9D88577D5E02689")

    public static final ASN1ObjectIdentifier IssuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "425C0A53325372896A614F043A8F1751", hash_generated_field = "7A77EBA72C76E4C07F9AE6482E3FEDBC")

    public static final ASN1ObjectIdentifier BasicConstraints = new ASN1ObjectIdentifier("2.5.29.19");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "A2BD7C97E4A4B1A88266E1952A71064E", hash_generated_field = "402B5C74329B052CE2282DEE9977FEC1")

    public static final ASN1ObjectIdentifier CRLNumber = new ASN1ObjectIdentifier("2.5.29.20");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "51B1B468F48D7024ADB33432B898547C", hash_generated_field = "26D7861BDC91BF19CC676B162DAEEDA0")

    public static final ASN1ObjectIdentifier ReasonCode = new ASN1ObjectIdentifier("2.5.29.21");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "66039CFEE667C1B0E7DFFFFD07BE1B2A", hash_generated_field = "444EEB78B6224D1F10592A18145096A1")

    public static final ASN1ObjectIdentifier InstructionCode = new ASN1ObjectIdentifier("2.5.29.23");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "1D7473A63C038E5CAFD37B9332DCCA8C", hash_generated_field = "50516B46D4F9AC4FF97BE9D05E44654B")

    public static final ASN1ObjectIdentifier InvalidityDate = new ASN1ObjectIdentifier("2.5.29.24");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "2C08D28FC3EB2279A28F06193738CCD9", hash_generated_field = "89C58CE6B202442339DACE4AF2328ACA")

    public static final ASN1ObjectIdentifier DeltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "925527ED9C54DE252BC87911700C6FA5", hash_generated_field = "0251A098151E69428EE10210AC12C23E")

    public static final ASN1ObjectIdentifier IssuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "6F978570D316714B09C8762A9D898BF9", hash_generated_field = "81BE99B7C7C5C728D839949081B63828")

    public static final ASN1ObjectIdentifier CertificateIssuer = new ASN1ObjectIdentifier("2.5.29.29");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.341 -0400", hash_original_field = "22F8E9CEAAC7FDAAEE8123B165D30796", hash_generated_field = "F557FF2D31EAFDE0DD6D1160647E8C99")

    public static final ASN1ObjectIdentifier NameConstraints = new ASN1ObjectIdentifier("2.5.29.30");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "8A4B5AE1725E2D051C2861C1D57BE0BA", hash_generated_field = "F9486D0ECD0D1C2A0815AF6CA8C70034")

    public static final ASN1ObjectIdentifier CRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "539CEE4DF562DBCB675A4BB878FFF648", hash_generated_field = "473484CA2D58104F8D50FFA6A4B56BB0")

    public static final ASN1ObjectIdentifier CertificatePolicies = new ASN1ObjectIdentifier("2.5.29.32");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "C51213D1050551677B59DF984F9E03E5", hash_generated_field = "3C8FFFCFDC181F51208FECE5FE8049AE")

    public static final ASN1ObjectIdentifier PolicyMappings = new ASN1ObjectIdentifier("2.5.29.33");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "3EA85AB7F30457EA95DB76BECA3EE950", hash_generated_field = "5E69B403C44943D938898F84EE2F51D6")

    public static final ASN1ObjectIdentifier AuthorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "7A91A63B9AAA247F7F804E1E9F716B6F", hash_generated_field = "2AB84E72AA866EDBC358064FE9EF404C")

    public static final ASN1ObjectIdentifier PolicyConstraints = new ASN1ObjectIdentifier("2.5.29.36");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "25085A8AC47B675BF5D730A32DF39EBA", hash_generated_field = "0433AE9B3707F9C945BB248814BF386E")

    public static final ASN1ObjectIdentifier ExtendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "391DCFE70906E30EDADBFA8ADF559F8B", hash_generated_field = "075C41376A5022ACC623633C5B4A108D")

    public static final ASN1ObjectIdentifier FreshestCRL = new ASN1ObjectIdentifier("2.5.29.46");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "F320B9137049E8A2AF44776B8BDE5149", hash_generated_field = "99A169313660BF483A94F60CA6D3DCD5")

    public static final ASN1ObjectIdentifier InhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "F1020F4794F2203A09B101D18C9344F9", hash_generated_field = "46D2F70980F4DB996CAEBDE3A2F9E000")

    public static final ASN1ObjectIdentifier AuthorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "C48D00DACF4688093BF474E027C5C966", hash_generated_field = "77E1302EECAC5D98F1D8FD1BF5717AE6")

    public static final ASN1ObjectIdentifier SubjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "7D8055A16AAEE31FF27A55FB30B1CE03", hash_generated_field = "0843906B6C0CB16E312BCDA07276E20D")

    public static final ASN1ObjectIdentifier LogoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "A5A10CB92D2DD3C65936B082E34C3F1B", hash_generated_field = "FD25CD479CE8E7DB0F7874AE4B79E7F6")

    public static final ASN1ObjectIdentifier BiometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "278A2A567B973E386FAEFC097B70214B", hash_generated_field = "76A329FB429DCE3469702D52D2D00E41")

    public static final ASN1ObjectIdentifier QCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "3F4E97497DA08B9C39FD95F7C1AB5F69", hash_generated_field = "D7FA7D7DAAA43945F26FCCF88B076927")

    public static final ASN1ObjectIdentifier AuditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "ACBEC409904466ED850DD2BA22773FB2", hash_generated_field = "6C673CF5AC60D0B1A0ED618AA5BE12FB")

    public static final ASN1ObjectIdentifier NoRevAvail = new ASN1ObjectIdentifier("2.5.29.56");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:20.342 -0400", hash_original_field = "9948D50C46D1F9018FC1B5660187A85E", hash_generated_field = "84330D8B4D2561FEE534906B43F4C1DC")

    public static final ASN1ObjectIdentifier TargetInformation = new ASN1ObjectIdentifier("2.5.29.55");
}

