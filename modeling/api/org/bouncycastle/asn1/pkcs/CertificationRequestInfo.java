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


package org.bouncycastle.asn1.pkcs;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Name;






public class CertificationRequestInfo extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.037 -0500", hash_original_method = "183AA0399A052A9E9C9F05D1DF40DDA6", hash_generated_method = "C67BE97F23F386F15C92D33A50797ABC")
    
public static CertificationRequestInfo getInstance(
        Object  obj)
    {
        if (obj instanceof CertificationRequestInfo)
        {
            return (CertificationRequestInfo)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new CertificationRequestInfo((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.028 -0500", hash_original_field = "E5AD0B91EEAC333294A87988907D98F4", hash_generated_field = "E5AD0B91EEAC333294A87988907D98F4")

    DERInteger              version = new DERInteger(0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.030 -0500", hash_original_field = "4344A061EE66BE44C834258CE9FA8F22", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name                subject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.032 -0500", hash_original_field = "F7829ABD2DC66F67AB9A43F8086B0231", hash_generated_field = "F7829ABD2DC66F67AB9A43F8086B0231")

    SubjectPublicKeyInfo    subjectPKInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.035 -0500", hash_original_field = "E579ABB775930056E729CE38818A2767", hash_generated_field = "E579ABB775930056E729CE38818A2767")

    ASN1Set                 attributes = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.040 -0500", hash_original_method = "3FEF08A37E0D9141B7E2C5E10AC22D85", hash_generated_method = "140A26890BA89D9468D269852B49BCD0")
    
public CertificationRequestInfo(
        X500Name subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes)
    {
        this.subject = X509Name.getInstance(subject.getDERObject());
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;

        if ((subject == null) || (version == null) || (subjectPKInfo == null))
        {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.044 -0500", hash_original_method = "8A394FF3547B9E5B97402324215DFF8C", hash_generated_method = "1A5FEBA6A6CA7F29289895F04DBC7B32")
    
public CertificationRequestInfo(
        X509Name                subject,
        SubjectPublicKeyInfo    pkInfo,
        ASN1Set                 attributes)
    {
        this.subject = subject;
        this.subjectPKInfo = pkInfo;
        this.attributes = attributes;

        if ((subject == null) || (version == null) || (subjectPKInfo == null))
        {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.048 -0500", hash_original_method = "C4672867714D5EDD4217814EF96CA715", hash_generated_method = "A2B9776CAEF23F9294A5C5A32C41DA47")
    
public CertificationRequestInfo(
        ASN1Sequence  seq)
    {
        version = (DERInteger)seq.getObjectAt(0);

        subject = X509Name.getInstance(seq.getObjectAt(1));
        subjectPKInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(2));

        //
        // some CertificationRequestInfo objects seem to treat this field
        // as optional.
        //
        if (seq.size() > 3)
        {
            DERTaggedObject tagobj = (DERTaggedObject)seq.getObjectAt(3);
            attributes = ASN1Set.getInstance(tagobj, false);
        }

        if ((subject == null) || (version == null) || (subjectPKInfo == null))
        {
            throw new IllegalArgumentException("Not all mandatory fields set in CertificationRequestInfo generator.");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.050 -0500", hash_original_method = "C14C6949EA2D9724014BC15AB24B85D9", hash_generated_method = "78B2DE65AC516EF0C8AEDCD6952A1B97")
    
public DERInteger getVersion()
    {
        return version;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.053 -0500", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "01C75A005E9EEB132C88E397D8B89741")
    
public X509Name getSubject()
    {
        return subject;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.055 -0500", hash_original_method = "9158BC4B5A10C8DD7FADE51069C303FC", hash_generated_method = "481A4E480C3E9C1EEB74A3B1788DD367")
    
public SubjectPublicKeyInfo getSubjectPublicKeyInfo()
    {
        return subjectPKInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.057 -0500", hash_original_method = "2B5879FE48F35BA3284D87B378AFE5E1", hash_generated_method = "88749F298E39DB3FA6191BA8C9C90717")
    
public ASN1Set getAttributes()
    {
        return attributes;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:15.060 -0500", hash_original_method = "0D1C10082A06DC50A0BCC9BE2BA5F1A2", hash_generated_method = "138A7781B6A6F92BFA8B98FB3B16D327")
    
public DERObject toASN1Object()
    {
        ASN1EncodableVector  v = new ASN1EncodableVector();

        v.add(version);
        v.add(subject);
        v.add(subjectPKInfo);

        if (attributes != null)
        {
            v.add(new DERTaggedObject(false, 0, attributes));
        }

        return new DERSequence(v);
    }

    
}

