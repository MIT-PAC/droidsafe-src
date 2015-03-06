/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.313 -0500", hash_original_method = "F58F0C73F69E507DB565BFC815954FC2", hash_generated_method = "97CC4EFCE1DBE805D99DE77CEC6BAB27")
    
public static X509Extensions getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.316 -0500", hash_original_method = "793D719FB578614D60FFB14257375B09", hash_generated_method = "11776C0374A4CC0FE2C1F66106527E8C")
    
public static X509Extensions getInstance(
        Object  obj)
    {
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.228 -0500", hash_original_field = "6ED548599283A5DB3F934E4DAFEC627F", hash_generated_field = "CBD96C0AFD6F6669C30B5B7D696F8263")

    public static final ASN1ObjectIdentifier SubjectDirectoryAttributes = new ASN1ObjectIdentifier("2.5.29.9");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.232 -0500", hash_original_field = "34FA5899B51646A19D104806BF0120E4", hash_generated_field = "604C58F1142B3AFFCE41C896FA3F7785")

    public static final ASN1ObjectIdentifier SubjectKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.14");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.234 -0500", hash_original_field = "C1A78BA1714A676EB79A2E5F814FBB38", hash_generated_field = "05E75E3CCFA630353758EEE084A656A9")

    public static final ASN1ObjectIdentifier KeyUsage = new ASN1ObjectIdentifier("2.5.29.15");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.237 -0500", hash_original_field = "8ACDC8A819FC5645BD7EB52858A5F4A8", hash_generated_field = "97E17E2E20D57D49BAB7D5659561A84A")

    public static final ASN1ObjectIdentifier PrivateKeyUsagePeriod = new ASN1ObjectIdentifier("2.5.29.16");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.239 -0500", hash_original_field = "2B622AFD60E4E14CE1AA51F1997CBE61", hash_generated_field = "C3083C3FDEDE3241523FE6E1A321569C")

    public static final ASN1ObjectIdentifier SubjectAlternativeName = new ASN1ObjectIdentifier("2.5.29.17");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.242 -0500", hash_original_field = "5DE9012E607985B455D06B713EDD84A6", hash_generated_field = "EBD3DC0BBC744C6AD9D88577D5E02689")

    public static final ASN1ObjectIdentifier IssuerAlternativeName = new ASN1ObjectIdentifier("2.5.29.18");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.244 -0500", hash_original_field = "98AF46A8AD4B536CCBCE2875A6F4BD96", hash_generated_field = "7A77EBA72C76E4C07F9AE6482E3FEDBC")

    public static final ASN1ObjectIdentifier BasicConstraints = new ASN1ObjectIdentifier("2.5.29.19");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.247 -0500", hash_original_field = "5199E1A6FE514EAC69DB0A07375D0937", hash_generated_field = "402B5C74329B052CE2282DEE9977FEC1")

    public static final ASN1ObjectIdentifier CRLNumber = new ASN1ObjectIdentifier("2.5.29.20");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.249 -0500", hash_original_field = "0B97FF6A971273308918311C49EDECAC", hash_generated_field = "26D7861BDC91BF19CC676B162DAEEDA0")

    public static final ASN1ObjectIdentifier ReasonCode = new ASN1ObjectIdentifier("2.5.29.21");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.252 -0500", hash_original_field = "3834B68807CA509D194862A96D28B1D9", hash_generated_field = "444EEB78B6224D1F10592A18145096A1")

    public static final ASN1ObjectIdentifier InstructionCode = new ASN1ObjectIdentifier("2.5.29.23");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.254 -0500", hash_original_field = "B0F81F27B6E3DD666ECF181E3A32FF5A", hash_generated_field = "50516B46D4F9AC4FF97BE9D05E44654B")

    public static final ASN1ObjectIdentifier InvalidityDate = new ASN1ObjectIdentifier("2.5.29.24");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.257 -0500", hash_original_field = "EED019EBF07227FC2BEDF71A409E4C48", hash_generated_field = "89C58CE6B202442339DACE4AF2328ACA")

    public static final ASN1ObjectIdentifier DeltaCRLIndicator = new ASN1ObjectIdentifier("2.5.29.27");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.260 -0500", hash_original_field = "1A77EC51F4DB79EA932378A8BC077A6E", hash_generated_field = "0251A098151E69428EE10210AC12C23E")

    public static final ASN1ObjectIdentifier IssuingDistributionPoint = new ASN1ObjectIdentifier("2.5.29.28");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.263 -0500", hash_original_field = "0E444361B28835C2A4B4ED3B077FE77F", hash_generated_field = "81BE99B7C7C5C728D839949081B63828")

    public static final ASN1ObjectIdentifier CertificateIssuer = new ASN1ObjectIdentifier("2.5.29.29");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.265 -0500", hash_original_field = "B59EE4FDE6B1CB362368AA52A37E0534", hash_generated_field = "F557FF2D31EAFDE0DD6D1160647E8C99")

    public static final ASN1ObjectIdentifier NameConstraints = new ASN1ObjectIdentifier("2.5.29.30");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.268 -0500", hash_original_field = "CF6CDB65C32966F155E70F2DA56E9580", hash_generated_field = "F9486D0ECD0D1C2A0815AF6CA8C70034")

    public static final ASN1ObjectIdentifier CRLDistributionPoints = new ASN1ObjectIdentifier("2.5.29.31");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.270 -0500", hash_original_field = "D4043A1CBD7AA1553A734D13ADCFA105", hash_generated_field = "473484CA2D58104F8D50FFA6A4B56BB0")

    public static final ASN1ObjectIdentifier CertificatePolicies = new ASN1ObjectIdentifier("2.5.29.32");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.272 -0500", hash_original_field = "3163AA47292F329F9909DED85078519A", hash_generated_field = "3C8FFFCFDC181F51208FECE5FE8049AE")

    public static final ASN1ObjectIdentifier PolicyMappings = new ASN1ObjectIdentifier("2.5.29.33");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.275 -0500", hash_original_field = "C4BD2887DBE313FAD5A0778AE3951D6E", hash_generated_field = "5E69B403C44943D938898F84EE2F51D6")

    public static final ASN1ObjectIdentifier AuthorityKeyIdentifier = new ASN1ObjectIdentifier("2.5.29.35");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.278 -0500", hash_original_field = "68341CCA843862071D5486586FD97604", hash_generated_field = "2AB84E72AA866EDBC358064FE9EF404C")

    public static final ASN1ObjectIdentifier PolicyConstraints = new ASN1ObjectIdentifier("2.5.29.36");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.280 -0500", hash_original_field = "5501E533E84123B91D1442B38B97546C", hash_generated_field = "0433AE9B3707F9C945BB248814BF386E")

    public static final ASN1ObjectIdentifier ExtendedKeyUsage = new ASN1ObjectIdentifier("2.5.29.37");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.283 -0500", hash_original_field = "B62561FEEB812FF21AA8DA2B995C7FAD", hash_generated_field = "075C41376A5022ACC623633C5B4A108D")

    public static final ASN1ObjectIdentifier FreshestCRL = new ASN1ObjectIdentifier("2.5.29.46");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.285 -0500", hash_original_field = "9A3E06B96EE98DDFBD1C88D6461DE9AB", hash_generated_field = "99A169313660BF483A94F60CA6D3DCD5")

    public static final ASN1ObjectIdentifier InhibitAnyPolicy = new ASN1ObjectIdentifier("2.5.29.54");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.289 -0500", hash_original_field = "D3F0C861EC060D02A166006A3E46BF2C", hash_generated_field = "46D2F70980F4DB996CAEBDE3A2F9E000")

    public static final ASN1ObjectIdentifier AuthorityInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.1");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.292 -0500", hash_original_field = "A360384213CAD91B2B27AC50247B6ABD", hash_generated_field = "77E1302EECAC5D98F1D8FD1BF5717AE6")

    public static final ASN1ObjectIdentifier SubjectInfoAccess = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.11");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.294 -0500", hash_original_field = "062B97D7C6D8A2B8864C881DABE9AB4B", hash_generated_field = "0843906B6C0CB16E312BCDA07276E20D")

    public static final ASN1ObjectIdentifier LogoType = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.12");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.296 -0500", hash_original_field = "B02DBC253E0A2473835E4B1177689D6C", hash_generated_field = "FD25CD479CE8E7DB0F7874AE4B79E7F6")

    public static final ASN1ObjectIdentifier BiometricInfo = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.2");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.299 -0500", hash_original_field = "D1D88396C9CADD752549EEED52F0E913", hash_generated_field = "76A329FB429DCE3469702D52D2D00E41")

    public static final ASN1ObjectIdentifier QCStatements = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.3");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.301 -0500", hash_original_field = "04CCD195ECF47F67534494E69FD07154", hash_generated_field = "D7FA7D7DAAA43945F26FCCF88B076927")

    public static final ASN1ObjectIdentifier AuditIdentity = new ASN1ObjectIdentifier("1.3.6.1.5.5.7.1.4");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.303 -0500", hash_original_field = "64728A156512D9FF8A40C3FEF778D99C", hash_generated_field = "6C673CF5AC60D0B1A0ED618AA5BE12FB")

    public static final ASN1ObjectIdentifier NoRevAvail = new ASN1ObjectIdentifier("2.5.29.56");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.307 -0500", hash_original_field = "CFC278EAF6DE79691DF21266C5D84C41", hash_generated_field = "84330D8B4D2561FEE534906B43F4C1DC")

    public static final ASN1ObjectIdentifier TargetInformation = new ASN1ObjectIdentifier("2.5.29.55");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.309 -0500", hash_original_field = "80192EDB4E5FD2A38E7FEBB63DD471DC", hash_generated_field = "85AC76E085157FE5A5AA3FC59E707E22")
    
    private Hashtable               extensions = new Hashtable();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.311 -0500", hash_original_field = "8370039E4421170D8B7341A1E9105E8E", hash_generated_field = "C8A65116741473EAA58816E75213B0AF")

    private Vector                  ordering = new Vector();

    /**
     * Constructor from ASN1Sequence.
     *
     * the extensions are a list of constructed sequences, either with (OID, OctetString) or (OID, Boolean, OctetString)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.319 -0500", hash_original_method = "3183DF3CA73DB6F6A8B3F75392BBEFA5", hash_generated_method = "FE8441AD814829F7D703E6704A1C1309")
    
public X509Extensions(
        ASN1Sequence  seq)
    {
        Enumeration e = seq.getObjects();

        while (e.hasMoreElements())
        {
            ASN1Sequence            s = ASN1Sequence.getInstance(e.nextElement());

            if (s.size() == 3)
            {
                extensions.put(s.getObjectAt(0), new X509Extension(DERBoolean.getInstance(s.getObjectAt(1)), ASN1OctetString.getInstance(s.getObjectAt(2))));
            }
            else if (s.size() == 2)
            {
                extensions.put(s.getObjectAt(0), new X509Extension(false, ASN1OctetString.getInstance(s.getObjectAt(1))));
            }
            else
            {
                throw new IllegalArgumentException("Bad sequence size: " + s.size());
            }

            ordering.addElement(s.getObjectAt(0));
        }
    }

    /**
     * constructor from a table of extensions.
     * <p>
     * it's is assumed the table contains OID/String pairs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.321 -0500", hash_original_method = "80ADD1BFD3CFC1BF1C6C9D5CB6EC2CCC", hash_generated_method = "59604DE0C617D6697B2ABF53ED920C97")
    
public X509Extensions(
        Hashtable  extensions)
    {
        this(null, extensions);
    }

    /**
     * Constructor from a table of extensions with ordering.
     * <p>
     * It's is assumed the table contains OID/String pairs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.324 -0500", hash_original_method = "F15F6ACF942D718DDD1781FCFE8FC099", hash_generated_method = "F095595A2A94C4D7463306276B81AF89")
    
public X509Extensions(
        Vector      ordering,
        Hashtable   extensions)
    {
        Enumeration e;

        if (ordering == null)
        {
            e = extensions.keys();
        }
        else
        {
            e = ordering.elements();
        }

        while (e.hasMoreElements())
        {
            this.ordering.addElement(new ASN1ObjectIdentifier(((DERObjectIdentifier)e.nextElement()).getId())); 
        }

        e = this.ordering.elements();

        while (e.hasMoreElements())
        {
            ASN1ObjectIdentifier     oid = new ASN1ObjectIdentifier(((DERObjectIdentifier)e.nextElement()).getId());
            X509Extension           ext = (X509Extension)extensions.get(oid);

            this.extensions.put(oid, ext);
        }
    }

    /**
     * Constructor from two vectors
     * 
     * @param objectIDs a vector of the object identifiers.
     * @param values a vector of the extension values.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.328 -0500", hash_original_method = "E35F3A8520AAABAE17BEC0E37B5A4B01", hash_generated_method = "542F5B0690A5CB833DE1BBA075EB05EE")
    
public X509Extensions(
        Vector      objectIDs,
        Vector      values)
    {
        Enumeration e = objectIDs.elements();

        while (e.hasMoreElements())
        {
            this.ordering.addElement(e.nextElement()); 
        }

        int count = 0;
        
        e = this.ordering.elements();

        while (e.hasMoreElements())
        {
            ASN1ObjectIdentifier     oid = (ASN1ObjectIdentifier)e.nextElement();
            X509Extension           ext = (X509Extension)values.elementAt(count);

            this.extensions.put(oid, ext);
            count++;
        }
    }
    
    /**
     * return an Enumeration of the extension field's object ids.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.330 -0500", hash_original_method = "0B0DE464F6E47F31BA5D76DC9E3C9FC0", hash_generated_method = "E6F25823590710C04224D290D7ECE8E3")
    
public Enumeration oids()
    {
        return ordering.elements();
    }

    /**
     * return the extension represented by the object identifier
     * passed in.
     *
     * @return the extension if it's present, null otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.333 -0500", hash_original_method = "32E3424DB018CF6D737571FE1786BD03", hash_generated_method = "0536927FEC9CDE62958A332243D6BAC4")
    
public X509Extension getExtension(
        ASN1ObjectIdentifier oid)
    {
        return (X509Extension)extensions.get(oid);
    }

    /**
     * @deprecated
     * @param oid
     * @return
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.335 -0500", hash_original_method = "A84942282634A7C86CBBB6C3F2ED59CC", hash_generated_method = "E145682FDD05DEE37ABDBD735B5692FA")
    
public X509Extension getExtension(
        DERObjectIdentifier oid)
    {
        return (X509Extension)extensions.get(oid);
    }

    /**
     * <pre>
     *     Extensions        ::=   SEQUENCE SIZE (1..MAX) OF Extension
     *
     *     Extension         ::=   SEQUENCE {
     *        extnId            EXTENSION.&amp;id ({ExtensionSet}),
     *        critical          BOOLEAN DEFAULT FALSE,
     *        extnValue         OCTET STRING }
     * </pre>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.337 -0500", hash_original_method = "06CC66F9E5522E8DB7D5C647F513DEC9", hash_generated_method = "8EA62FFBBF224D7E09EFE51BF3AE3BFB")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector     vec = new ASN1EncodableVector();
        Enumeration             e = ordering.elements();

        while (e.hasMoreElements())
        {
            ASN1ObjectIdentifier     oid = (ASN1ObjectIdentifier)e.nextElement();
            X509Extension           ext = (X509Extension)extensions.get(oid);
            ASN1EncodableVector     v = new ASN1EncodableVector();

            v.add(oid);

            if (ext.isCritical())
            {
                // BEGIN android-changed
                v.add(DERBoolean.TRUE);
                // END android-changed
            }

            v.add(ext.getValue());

            vec.add(new DERSequence(v));
        }

        return new DERSequence(vec);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.340 -0500", hash_original_method = "5431038A2FDD7EE9A832630B10E5FEE7", hash_generated_method = "85CB6B420FEDDC8EB362B1E2E7BD8681")
    
public boolean equivalent(
        X509Extensions other)
    {
        if (extensions.size() != other.extensions.size())
        {
            return false;
        }

        Enumeration     e1 = extensions.keys();

        while (e1.hasMoreElements())
        {
            Object  key = e1.nextElement();

            if (!extensions.get(key).equals(other.extensions.get(key)))
            {
                return false;
            }
        }

        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.342 -0500", hash_original_method = "0A51D0A287CCFA511D40B874C91E938D", hash_generated_method = "83B7FA9486DDCE3E33D3A9E1D69EACD7")
    
public ASN1ObjectIdentifier[] getExtensionOIDs()
    {
        return toOidArray(ordering);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.344 -0500", hash_original_method = "38FDC56695894D5E3900BA7AB78B1602", hash_generated_method = "F892041AC16D0BB5BB8EAD0F5A822827")
    
public ASN1ObjectIdentifier[] getNonCriticalExtensionOIDs()
    {
        return getExtensionOIDs(false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.346 -0500", hash_original_method = "87563EF50C27322C30E8D92768AE9E02", hash_generated_method = "900899E3A0CE47DFCA7AC9CFD3364FEC")
    
public ASN1ObjectIdentifier[] getCriticalExtensionOIDs()
    {
        return getExtensionOIDs(true);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.348 -0500", hash_original_method = "7A0D9F93C88DE50806BB985DD6BFA19B", hash_generated_method = "8D4137D182AEE19A39519A56844A180C")
    
private ASN1ObjectIdentifier[] getExtensionOIDs(boolean isCritical)
    {
        Vector oidVec = new Vector();

        for (int i = 0; i != ordering.size(); i++)
        {
            Object oid = ordering.elementAt(i);

            if (((X509Extension)extensions.get(oid)).isCritical() == isCritical)
            {
                oidVec.addElement(oid);
            }
        }

        return toOidArray(oidVec);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:21.351 -0500", hash_original_method = "4F14C515A25E2063508F233D1F460CFE", hash_generated_method = "AF2B5EB40A999D8039811FB6DC07E7C6")
    
private ASN1ObjectIdentifier[] toOidArray(Vector oidVec)
    {
        ASN1ObjectIdentifier[] oids = new ASN1ObjectIdentifier[oidVec.size()];

        for (int i = 0; i != oids.length; i++)
        {
            oids[i] = (ASN1ObjectIdentifier)oidVec.elementAt(i);
        }
        return oids;
    }
}

