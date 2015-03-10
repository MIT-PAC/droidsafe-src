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
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;






public class TBSCertificateStructure extends ASN1Encodable implements X509ObjectIdentifiers, PKCSObjectIdentifiers {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.282 -0500", hash_original_method = "DA73FF9513EFF87082C74F1C9F718AFA", hash_generated_method = "A7317B52DEF7D04448ED8093DF31D145")
    
public static TBSCertificateStructure getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.285 -0500", hash_original_method = "43D91FF35D1E121301BBF3472E30067F", hash_generated_method = "88CE3986BA030CF6A8A4E0D731D435F0")
    
public static TBSCertificateStructure getInstance(
        Object  obj)
    {
        if (obj instanceof TBSCertificateStructure)
        {
            return (TBSCertificateStructure)obj;
        }
        else if (obj != null)
        {
            return new TBSCertificateStructure(ASN1Sequence.getInstance(obj));
        }

        return null;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.259 -0500", hash_original_field = "67B66723C4558F27E19029159A09253A", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence            seq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.261 -0500", hash_original_field = "E228CDE1667030A19BE9074EE632C2E6", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")


    DERInteger              version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.263 -0500", hash_original_field = "61F6E9A806268A4DFEFDDB24EB7F542C", hash_generated_field = "61F6E9A806268A4DFEFDDB24EB7F542C")

    DERInteger              serialNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.266 -0500", hash_original_field = "A9C2427A585DE5C2846E517FA208C326", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier     signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.268 -0500", hash_original_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name                issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "E4DFB3F5DD911DC868EB4F2C2A836D64", hash_generated_field = "DE01625B0FD536262A10F3B23586D456")

    Time startDate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.944 -0400", hash_original_field = "813E94378D42501D835B2ED6253DC463", hash_generated_field = "368D4323F52DEF40161D12727D58B4F3")

    Time endDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.272 -0500", hash_original_field = "4344A061EE66BE44C834258CE9FA8F22", hash_generated_field = "4344A061EE66BE44C834258CE9FA8F22")

    X509Name                subject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.274 -0500", hash_original_field = "B0B8278CF79DE1BD38516FAC424CAD16", hash_generated_field = "B0B8278CF79DE1BD38516FAC424CAD16")

    SubjectPublicKeyInfo    subjectPublicKeyInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.276 -0500", hash_original_field = "88D9B3E531838E1A98E9372502638388", hash_generated_field = "88D9B3E531838E1A98E9372502638388")

    DERBitString            issuerUniqueId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.278 -0500", hash_original_field = "2C76406ED67582A5FA081A7A2D9B2868", hash_generated_field = "2C76406ED67582A5FA081A7A2D9B2868")

    DERBitString            subjectUniqueId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.280 -0500", hash_original_field = "2BA375987D179ECB55F007F92DADE11C", hash_generated_field = "2BA375987D179ECB55F007F92DADE11C")

    X509Extensions          extensions;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.288 -0500", hash_original_method = "F026064B24F5E7FC18B81DFF22C18AC9", hash_generated_method = "81101C28E1887C0DA06985087C55B18B")
    
public TBSCertificateStructure(
        ASN1Sequence  seq)
    {
        int         seqStart = 0;

        this.seq = seq;

        //
        // some certficates don't include a version number - we assume v1
        //
        if (seq.getObjectAt(0) instanceof DERTaggedObject)
        {
            version = DERInteger.getInstance((ASN1TaggedObject)seq.getObjectAt(0), true);
        }
        else
        {
            seqStart = -1;          // field 0 is missing!
            version = new DERInteger(0);
        }

        serialNumber = DERInteger.getInstance(seq.getObjectAt(seqStart + 1));

        signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(seqStart + 2));
        issuer = X509Name.getInstance(seq.getObjectAt(seqStart + 3));

        //
        // before and after dates
        //
        ASN1Sequence  dates = (ASN1Sequence)seq.getObjectAt(seqStart + 4);

        startDate = Time.getInstance(dates.getObjectAt(0));
        endDate = Time.getInstance(dates.getObjectAt(1));

        subject = X509Name.getInstance(seq.getObjectAt(seqStart + 5));

        //
        // public key info.
        //
        subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(seq.getObjectAt(seqStart + 6));

        for (int extras = seq.size() - (seqStart + 6) - 1; extras > 0; extras--)
        {
            DERTaggedObject extra = (DERTaggedObject)seq.getObjectAt(seqStart + 6 + extras);

            switch (extra.getTagNo())
            {
            case 1:
                issuerUniqueId = DERBitString.getInstance(extra, false);
                break;
            case 2:
                subjectUniqueId = DERBitString.getInstance(extra, false);
                break;
            case 3:
                extensions = X509Extensions.getInstance(extra);
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.290 -0500", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "DE8FED9B20C0D4D5E140851265C30B7C")
    
public int getVersion()
    {
        return version.getValue().intValue() + 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.293 -0500", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "F02FEF6B8DE588BFC25BDD1A8118B89B")
    
public DERInteger getVersionNumber()
    {
        return version;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.295 -0500", hash_original_method = "FB637D35FB72ECF5302334390BEEB5AC", hash_generated_method = "B4C3507C7CA5004E71D41514D5FECB65")
    
public DERInteger getSerialNumber()
    {
        return serialNumber;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.297 -0500", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "8983DBF8FD7CF97E2F3DB5F36F4DEF72")
    
public AlgorithmIdentifier getSignature()
    {
        return signature;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.299 -0500", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "F5DBEEDCEA1A500B1EB6EDD76F7FF386")
    
public X509Name getIssuer()
    {
        return issuer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.301 -0500", hash_original_method = "909D374C3F5E114020E1939F16D3CF76", hash_generated_method = "26438D779D5E9A6C7D057224D4F9920A")
    
public Time getStartDate()
    {
        return startDate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.303 -0500", hash_original_method = "B4A95AF8DCBBCB951EF2EC33D2077725", hash_generated_method = "160E426B68033BC634084C54E461E53F")
    
public Time getEndDate()
    {
        return endDate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.305 -0500", hash_original_method = "CA422C660E8CA6347A77201218B988AE", hash_generated_method = "01C75A005E9EEB132C88E397D8B89741")
    
public X509Name getSubject()
    {
        return subject;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.308 -0500", hash_original_method = "EE5B5FDD20BC2C4F67CD8D0C39F17B3D", hash_generated_method = "481470C7D7406472BB4A98FC1A53DE7B")
    
public SubjectPublicKeyInfo getSubjectPublicKeyInfo()
    {
        return subjectPublicKeyInfo;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.310 -0500", hash_original_method = "6F6E1D43C4C5F3E57DDB874B276B463E", hash_generated_method = "A78CB2977D69235D23C12D3F92F90FD5")
    
public DERBitString getIssuerUniqueId()
    {
        return issuerUniqueId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.312 -0500", hash_original_method = "9788F7D9ABBC525B6D86ECC001203156", hash_generated_method = "C5A192C9568F68DCA5432781E6D8F13C")
    
public DERBitString getSubjectUniqueId()
    {
        return subjectUniqueId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.314 -0500", hash_original_method = "0A664DE086A2ED08A47FCC7544F0D12E", hash_generated_method = "732ED8B11FCC424D21ECD48504DDD415")
    
public X509Extensions getExtensions()
    {
        return extensions;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:19.317 -0500", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "DA3C9DFD280268761F4161BB76907E1D")
    
public DERObject toASN1Object()
    {
        return seq;
    }

    
}

