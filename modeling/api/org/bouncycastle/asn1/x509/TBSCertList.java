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

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.DERUTCTime;

public class TBSCertList extends ASN1Encodable {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.239 -0500", hash_original_method = "2B7FC96E3864C0783582A15F9AFDEE89", hash_generated_method = "370AC8AE507B3DE0C02B7825ED66EF0D")
    
public static TBSCertList getInstance(
        ASN1TaggedObject obj,
        boolean          explicit)
    {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.241 -0500", hash_original_method = "C4E8E199405970149BE3784C30B72ABB", hash_generated_method = "51D19E0FD2ED8701CBB4B33D3B039CEA")
    
public static TBSCertList getInstance(
        Object  obj)
    {
        if (obj instanceof TBSCertList)
        {
            return (TBSCertList)obj;
        }
        else if (obj instanceof ASN1Sequence)
        {
            return new TBSCertList((ASN1Sequence)obj);
        }

        throw new IllegalArgumentException("unknown object in factory: " + obj.getClass().getName());
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.221 -0500", hash_original_field = "67B66723C4558F27E19029159A09253A", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence     seq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.223 -0500", hash_original_field = "E228CDE1667030A19BE9074EE632C2E6", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger              version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.226 -0500", hash_original_field = "A9C2427A585DE5C2846E517FA208C326", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier     signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.228 -0500", hash_original_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name                issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.230 -0500", hash_original_field = "F7307148EA192C2AC6829F3D6478616E", hash_generated_field = "F7307148EA192C2AC6829F3D6478616E")

    Time                    thisUpdate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.232 -0500", hash_original_field = "81E26EA846E6309FDA2B763EEE4322CF", hash_generated_field = "81E26EA846E6309FDA2B763EEE4322CF")

    Time                    nextUpdate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.234 -0500", hash_original_field = "AE9FB0F92F5352F3D989DA8B1E3BF6E8", hash_generated_field = "AE9FB0F92F5352F3D989DA8B1E3BF6E8")

    ASN1Sequence            revokedCertificates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.236 -0500", hash_original_field = "32AFE711317FCCD7D6FFF9CE186DE901", hash_generated_field = "32AFE711317FCCD7D6FFF9CE186DE901")

    X509Extensions          crlExtensions;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.245 -0500", hash_original_method = "979311BA6EB06D915E93C36961984E0B", hash_generated_method = "A1A95781758B82FB882C5A30EDF99E9B")
    
public TBSCertList(
        ASN1Sequence  seq)
    {
        if (seq.size() < 3 || seq.size() > 7)
        {
            throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        }

        int seqPos = 0;

        this.seq = seq;

        if (seq.getObjectAt(seqPos) instanceof DERInteger)
        {
            version = DERInteger.getInstance(seq.getObjectAt(seqPos++));
        }
        else
        {
            version = new DERInteger(0);
        }

        signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(seqPos++));
        issuer = X509Name.getInstance(seq.getObjectAt(seqPos++));
        thisUpdate = Time.getInstance(seq.getObjectAt(seqPos++));

        if (seqPos < seq.size()
            && (seq.getObjectAt(seqPos) instanceof DERUTCTime
               || seq.getObjectAt(seqPos) instanceof DERGeneralizedTime
               || seq.getObjectAt(seqPos) instanceof Time))
        {
            nextUpdate = Time.getInstance(seq.getObjectAt(seqPos++));
        }

        if (seqPos < seq.size()
            && !(seq.getObjectAt(seqPos) instanceof DERTaggedObject))
        {
            revokedCertificates = ASN1Sequence.getInstance(seq.getObjectAt(seqPos++));
        }

        if (seqPos < seq.size()
            && seq.getObjectAt(seqPos) instanceof DERTaggedObject)
        {
            crlExtensions = X509Extensions.getInstance(seq.getObjectAt(seqPos));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.247 -0500", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "DE8FED9B20C0D4D5E140851265C30B7C")
    
public int getVersion()
    {
        return version.getValue().intValue() + 1;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.249 -0500", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "F02FEF6B8DE588BFC25BDD1A8118B89B")
    
public DERInteger getVersionNumber()
    {
        return version;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.251 -0500", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "8983DBF8FD7CF97E2F3DB5F36F4DEF72")
    
public AlgorithmIdentifier getSignature()
    {
        return signature;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.253 -0500", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "F5DBEEDCEA1A500B1EB6EDD76F7FF386")
    
public X509Name getIssuer()
    {
        return issuer;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.256 -0500", hash_original_method = "13C3CAE3E054BA140B8F621AE3EA7547", hash_generated_method = "BA5ACC4FF64310EF85D09C936A5479C0")
    
public Time getThisUpdate()
    {
        return thisUpdate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.258 -0500", hash_original_method = "A77204D0766EFD8AD6F24F7F347199B2", hash_generated_method = "A274A3E3B1A4F69DCF0BD0D90C449D84")
    
public Time getNextUpdate()
    {
        return nextUpdate;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.260 -0500", hash_original_method = "CEAEC6FC0ECB759CC0350D156B5BC4BE", hash_generated_method = "CEAEE9FDE61B88203FB9BA1809E47C3C")
    
public CRLEntry[] getRevokedCertificates()
    {
        if (revokedCertificates == null)
        {
            return new CRLEntry[0];
        }

        CRLEntry[] entries = new CRLEntry[revokedCertificates.size()];

        for (int i = 0; i < entries.length; i++)
        {
            entries[i] = new CRLEntry(ASN1Sequence.getInstance(revokedCertificates.getObjectAt(i)));
        }
        
        return entries;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.262 -0500", hash_original_method = "6375844A31081D053220C645D0F9B87E", hash_generated_method = "B1357BB23303B28E78D9E982A1CA7D3F")
    
public Enumeration getRevokedCertificateEnumeration()
    {
        if (revokedCertificates == null)
        {
            return new EmptyEnumeration();
        }

        return new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.264 -0500", hash_original_method = "CDE1CFE7081DEA43241E45471E737135", hash_generated_method = "479B9F46675FACDF176606624A6962DD")
    
public X509Extensions getExtensions()
    {
        return crlExtensions;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.266 -0500", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "DA3C9DFD280268761F4161BB76907E1D")
    
public DERObject toASN1Object()
    {
        return seq;
    }
    
    public static class CRLEntry extends ASN1Encodable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.179 -0500", hash_original_field = "67B66723C4558F27E19029159A09253A", hash_generated_field = "67B66723C4558F27E19029159A09253A")

        ASN1Sequence  seq;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.182 -0500", hash_original_field = "2B07ABA517A3C72D4D1AE840B26D1CBC", hash_generated_field = "2B07ABA517A3C72D4D1AE840B26D1CBC")

        DERInteger          userCertificate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.184 -0500", hash_original_field = "6E03E433A7A3E5DD51EB4D05094D4199", hash_generated_field = "6E03E433A7A3E5DD51EB4D05094D4199")

        Time                revocationDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.186 -0500", hash_original_field = "16E9DEFD70BF4A992A02A9F3935A2277", hash_generated_field = "16E9DEFD70BF4A992A02A9F3935A2277")

        X509Extensions      crlEntryExtensions;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.189 -0500", hash_original_method = "5E4E4AC1AFC14B33E134B0DE6A66EF69", hash_generated_method = "54299378E90E09C8D2D565DDD44648DC")
        
public CRLEntry(
            ASN1Sequence  seq)
        {
            if (seq.size() < 2 || seq.size() > 3)
            {
                throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            }
            
            this.seq = seq;

            userCertificate = DERInteger.getInstance(seq.getObjectAt(0));
            revocationDate = Time.getInstance(seq.getObjectAt(1));
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.192 -0500", hash_original_method = "4F65DC188C3501616DCFC998DA7DBFCB", hash_generated_method = "C19848F7DE9984B02D25110B543C3EEF")
        
public DERInteger getUserCertificate()
        {
            return userCertificate;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.195 -0500", hash_original_method = "4B493204B476D887C77BCF51D1F57DB2", hash_generated_method = "D75D773DD2D52C9329845ECA778008E3")
        
public Time getRevocationDate()
        {
            return revocationDate;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.198 -0500", hash_original_method = "15344AC9965F1BCC242E7479E06915DE", hash_generated_method = "21C7DB96245EA4127E9DD397CCDD81CC")
        
public X509Extensions getExtensions()
        {
            if (crlEntryExtensions == null && seq.size() == 3)
            {
                crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
            }
            
            return crlEntryExtensions;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.200 -0500", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "DA3C9DFD280268761F4161BB76907E1D")
        
public DERObject toASN1Object()
        {
            return seq;
        }
        
    }
    
    private class RevokedCertificatesEnumeration implements Enumeration {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.204 -0500", hash_original_field = "B735AEAFD527E582CE7F6A25E23202C6", hash_generated_field = "B0D8CED81BAB00EB7CFC8DD7778DE583")

        private  Enumeration en;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.207 -0500", hash_original_method = "6A29318C110C11222950EB9111D0EBEA", hash_generated_method = "6A29318C110C11222950EB9111D0EBEA")
        
RevokedCertificatesEnumeration(Enumeration en)
        {
            this.en = en;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.209 -0500", hash_original_method = "FBC842E02AF9214599A6659CADABA547", hash_generated_method = "42C3F6AFECCFF38DDF9B6CD323C5DD24")
        
public boolean hasMoreElements()
        {
            return en.hasMoreElements();
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.212 -0500", hash_original_method = "09463CFA8BEF092B2195E66AA891F38D", hash_generated_method = "B7C30A3A8828630412C17029CDD57588")
        
public Object nextElement()
        {
            return new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
        }
        
    }
    
    private class EmptyEnumeration implements Enumeration {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.912 -0400", hash_original_method = "7DE508FCF70F724013E54D107E91DAB2", hash_generated_method = "7DE508FCF70F724013E54D107E91DAB2")
        public EmptyEnumeration ()
        {
            //Synthesized constructor
        }
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.216 -0500", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "09B05EFBEE1C6D55350683F6624DF863")
        
public boolean hasMoreElements()
        {
            return false;
        }

        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:23.218 -0500", hash_original_method = "6A32EEF26E654AE1CD00BB3EBA8A611E", hash_generated_method = "1F2D8CE2FE354928B2AFA4255171FA33")
        
public Object nextElement()
        {
            return null;   // TODO: check exception handling
        }
        
    }
    
}

