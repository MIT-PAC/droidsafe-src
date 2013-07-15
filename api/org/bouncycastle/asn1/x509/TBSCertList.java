package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.247 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.247 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.247 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.247 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.247 -0400", hash_original_field = "5A57C2EC88FCBD38D012B98CFBA87F36", hash_generated_field = "F7307148EA192C2AC6829F3D6478616E")

    Time thisUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.247 -0400", hash_original_field = "0795B4516D5D7B11F363991643178A98", hash_generated_field = "81E26EA846E6309FDA2B763EEE4322CF")

    Time nextUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.247 -0400", hash_original_field = "0B6950E312B7638124011FB2B7D7DB5E", hash_generated_field = "AE9FB0F92F5352F3D989DA8B1E3BF6E8")

    ASN1Sequence revokedCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.247 -0400", hash_original_field = "FCA1AF483E9CDF6520BB02D488ABDB91", hash_generated_field = "32AFE711317FCCD7D6FFF9CE186DE901")

    X509Extensions crlExtensions;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.249 -0400", hash_original_method = "979311BA6EB06D915E93C36961984E0B", hash_generated_method = "86422CE3ECBE3C939591A11C3949CB81")
    public  TBSCertList(
        ASN1Sequence  seq) {
    if(seq.size() < 3 || seq.size() > 7)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_213874421 = new IllegalArgumentException("Bad sequence size: " + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_213874421.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_213874421;
        } //End block
        int seqPos = 0;
        this.seq = seq;
    if(seq.getObjectAt(seqPos) instanceof DERInteger)        
        {
            version = DERInteger.getInstance(seq.getObjectAt(seqPos++));
        } //End block
        else
        {
            version = new DERInteger(0);
        } //End block
        signature = AlgorithmIdentifier.getInstance(seq.getObjectAt(seqPos++));
        issuer = X509Name.getInstance(seq.getObjectAt(seqPos++));
        thisUpdate = Time.getInstance(seq.getObjectAt(seqPos++));
    if(seqPos < seq.size()
            && (seq.getObjectAt(seqPos) instanceof DERUTCTime
               || seq.getObjectAt(seqPos) instanceof DERGeneralizedTime
               || seq.getObjectAt(seqPos) instanceof Time))        
        {
            nextUpdate = Time.getInstance(seq.getObjectAt(seqPos++));
        } //End block
    if(seqPos < seq.size()
            && !(seq.getObjectAt(seqPos) instanceof DERTaggedObject))        
        {
            revokedCertificates = ASN1Sequence.getInstance(seq.getObjectAt(seqPos++));
        } //End block
    if(seqPos < seq.size()
            && seq.getObjectAt(seqPos) instanceof DERTaggedObject)        
        {
            crlExtensions = X509Extensions.getInstance(seq.getObjectAt(seqPos));
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        public static TBSCertList getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
        public static TBSCertList getInstance(
        Object  obj) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.250 -0400", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "AB2D018384AE874BF6760444F021B8DC")
    public int getVersion() {
        int var4E01D99371F8A746A4C58A8E9E72F05E_1768869294 = (version.getValue().intValue() + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572002694 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1572002694;
        // ---------- Original Method ----------
        //return version.getValue().intValue() + 1;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.250 -0400", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "13C95B48A5A5601093BBB3DD3C37017E")
    public DERInteger getVersionNumber() {
DERInteger varE87BEFBC04DA371DFA5B07C77A4407CB_1989650149 =         version;
        varE87BEFBC04DA371DFA5B07C77A4407CB_1989650149.addTaint(taint);
        return varE87BEFBC04DA371DFA5B07C77A4407CB_1989650149;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.251 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "80B6E4CD3F8728365B9E0D7A749073E9")
    public AlgorithmIdentifier getSignature() {
AlgorithmIdentifier varCDF7DED6F053AD37D069B3F1993A6032_514976806 =         signature;
        varCDF7DED6F053AD37D069B3F1993A6032_514976806.addTaint(taint);
        return varCDF7DED6F053AD37D069B3F1993A6032_514976806;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.251 -0400", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "7C34DF7807268A065A402668EE22E1DD")
    public X509Name getIssuer() {
X509Name var8EF52627413B91AB97DB59853805E979_368585863 =         issuer;
        var8EF52627413B91AB97DB59853805E979_368585863.addTaint(taint);
        return var8EF52627413B91AB97DB59853805E979_368585863;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.251 -0400", hash_original_method = "13C3CAE3E054BA140B8F621AE3EA7547", hash_generated_method = "7F2AED6F8A3FD43BCBB2A56E50E2DCA5")
    public Time getThisUpdate() {
Time varD1B56197E31CD050E59B70739E2BD702_352710607 =         thisUpdate;
        varD1B56197E31CD050E59B70739E2BD702_352710607.addTaint(taint);
        return varD1B56197E31CD050E59B70739E2BD702_352710607;
        // ---------- Original Method ----------
        //return thisUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.251 -0400", hash_original_method = "A77204D0766EFD8AD6F24F7F347199B2", hash_generated_method = "CDD4415AB20F95E2FB2F028452DCD6D4")
    public Time getNextUpdate() {
Time var668F801CBC2DC1072BF49CB46E481CAC_1176948121 =         nextUpdate;
        var668F801CBC2DC1072BF49CB46E481CAC_1176948121.addTaint(taint);
        return var668F801CBC2DC1072BF49CB46E481CAC_1176948121;
        // ---------- Original Method ----------
        //return nextUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.252 -0400", hash_original_method = "CEAEC6FC0ECB759CC0350D156B5BC4BE", hash_generated_method = "C2FEE6893EF38337213A3914EF78AAD8")
    public CRLEntry[] getRevokedCertificates() {
    if(revokedCertificates == null)        
        {
CRLEntry[] var48BC37704C652E7363F10E3946D90E23_1030755935 =             new CRLEntry[0];
            var48BC37704C652E7363F10E3946D90E23_1030755935.addTaint(taint);
            return var48BC37704C652E7363F10E3946D90E23_1030755935;
        } //End block
        CRLEntry[] entries = new CRLEntry[revokedCertificates.size()];
for(int i = 0;i < entries.length;i++)
        {
            entries[i] = new CRLEntry(ASN1Sequence.getInstance(revokedCertificates.getObjectAt(i)));
        } //End block
CRLEntry[] var0AAD0D341A96E603A0F87B9A9B535A71_1031537875 =         entries;
        var0AAD0D341A96E603A0F87B9A9B535A71_1031537875.addTaint(taint);
        return var0AAD0D341A96E603A0F87B9A9B535A71_1031537875;
        // ---------- Original Method ----------
        //if (revokedCertificates == null)
        //{
            //return new CRLEntry[0];
        //}
        //CRLEntry[] entries = new CRLEntry[revokedCertificates.size()];
        //for (int i = 0; i < entries.length; i++)
        //{
            //entries[i] = new CRLEntry(ASN1Sequence.getInstance(revokedCertificates.getObjectAt(i)));
        //}
        //return entries;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.252 -0400", hash_original_method = "6375844A31081D053220C645D0F9B87E", hash_generated_method = "0D3B1302B3AC639C63E9A2050CF8B20D")
    public Enumeration getRevokedCertificateEnumeration() {
    if(revokedCertificates == null)        
        {
Enumeration var7D104FFA51584557B2AF340B96DE0ED6_404781416 =             new EmptyEnumeration();
            var7D104FFA51584557B2AF340B96DE0ED6_404781416.addTaint(taint);
            return var7D104FFA51584557B2AF340B96DE0ED6_404781416;
        } //End block
Enumeration var057C4F0D1CBF03CCA9204B25301F4AF1_1676428727 =         new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
        var057C4F0D1CBF03CCA9204B25301F4AF1_1676428727.addTaint(taint);
        return var057C4F0D1CBF03CCA9204B25301F4AF1_1676428727;
        // ---------- Original Method ----------
        //if (revokedCertificates == null)
        //{
            //return new EmptyEnumeration();
        //}
        //return new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.252 -0400", hash_original_method = "CDE1CFE7081DEA43241E45471E737135", hash_generated_method = "63A6109BF9EFBDF83144744AEF5C1967")
    public X509Extensions getExtensions() {
X509Extensions varDCEFD14A175BE50B5AC0E611125816AD_1570490681 =         crlExtensions;
        varDCEFD14A175BE50B5AC0E611125816AD_1570490681.addTaint(taint);
        return varDCEFD14A175BE50B5AC0E611125816AD_1570490681;
        // ---------- Original Method ----------
        //return crlExtensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.253 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "DC98B9445975ABD187461DEF50A072F8")
    public DERObject toASN1Object() {
DERObject var42A78C062640017A329FA085150BC1B8_417030053 =         seq;
        var42A78C062640017A329FA085150BC1B8_417030053.addTaint(taint);
        return var42A78C062640017A329FA085150BC1B8_417030053;
        // ---------- Original Method ----------
        //return seq;
    }

    
    public static class CRLEntry extends ASN1Encodable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.253 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

        ASN1Sequence seq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.253 -0400", hash_original_field = "71A5BB307937C590A67CEB96CF72CF12", hash_generated_field = "2B07ABA517A3C72D4D1AE840B26D1CBC")

        DERInteger userCertificate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.253 -0400", hash_original_field = "30D935E32E2556ADF9A447D78BEC8E47", hash_generated_field = "6E03E433A7A3E5DD51EB4D05094D4199")

        Time revocationDate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.253 -0400", hash_original_field = "AD8C0148B3A586F917CF6245F9F618B8", hash_generated_field = "16E9DEFD70BF4A992A02A9F3935A2277")

        X509Extensions crlEntryExtensions;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.254 -0400", hash_original_method = "5E4E4AC1AFC14B33E134B0DE6A66EF69", hash_generated_method = "336316E2F076729EEE4A65479CF6A30D")
        public  CRLEntry(
            ASN1Sequence  seq) {
    if(seq.size() < 2 || seq.size() > 3)            
            {
                IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_720589791 = new IllegalArgumentException("Bad sequence size: " + seq.size());
                varA2072CF614C7B8C7696DD5A02DBCCE9C_720589791.addTaint(taint);
                throw varA2072CF614C7B8C7696DD5A02DBCCE9C_720589791;
            } //End block
            this.seq = seq;
            userCertificate = DERInteger.getInstance(seq.getObjectAt(0));
            revocationDate = Time.getInstance(seq.getObjectAt(1));
            // ---------- Original Method ----------
            //if (seq.size() < 2 || seq.size() > 3)
            //{
                //throw new IllegalArgumentException("Bad sequence size: " + seq.size());
            //}
            //this.seq = seq;
            //userCertificate = DERInteger.getInstance(seq.getObjectAt(0));
            //revocationDate = Time.getInstance(seq.getObjectAt(1));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.254 -0400", hash_original_method = "4F65DC188C3501616DCFC998DA7DBFCB", hash_generated_method = "F1F8D8CB3B9D1F973292A4454B72B680")
        public DERInteger getUserCertificate() {
DERInteger var29531534CAF33A30A18F3DE7015D0A7C_1296768177 =             userCertificate;
            var29531534CAF33A30A18F3DE7015D0A7C_1296768177.addTaint(taint);
            return var29531534CAF33A30A18F3DE7015D0A7C_1296768177;
            // ---------- Original Method ----------
            //return userCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.254 -0400", hash_original_method = "4B493204B476D887C77BCF51D1F57DB2", hash_generated_method = "F7CC7C9AA75065EC60AF98664BBA042E")
        public Time getRevocationDate() {
Time varBE194ECAF8C3A05947697E51EC2341D1_811903985 =             revocationDate;
            varBE194ECAF8C3A05947697E51EC2341D1_811903985.addTaint(taint);
            return varBE194ECAF8C3A05947697E51EC2341D1_811903985;
            // ---------- Original Method ----------
            //return revocationDate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.254 -0400", hash_original_method = "15344AC9965F1BCC242E7479E06915DE", hash_generated_method = "DE2500DDEAAD22A1CE6E70E2799F10CB")
        public X509Extensions getExtensions() {
    if(crlEntryExtensions == null && seq.size() == 3)            
            {
                crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
            } //End block
X509Extensions var7A7A939867039CEA4ADCB8DFD15921BF_344346801 =             crlEntryExtensions;
            var7A7A939867039CEA4ADCB8DFD15921BF_344346801.addTaint(taint);
            return var7A7A939867039CEA4ADCB8DFD15921BF_344346801;
            // ---------- Original Method ----------
            //if (crlEntryExtensions == null && seq.size() == 3)
            //{
                //crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
            //}
            //return crlEntryExtensions;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.255 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "71769A3C74B55DB769919EF8041EC988")
        public DERObject toASN1Object() {
DERObject var42A78C062640017A329FA085150BC1B8_206139203 =             seq;
            var42A78C062640017A329FA085150BC1B8_206139203.addTaint(taint);
            return var42A78C062640017A329FA085150BC1B8_206139203;
            // ---------- Original Method ----------
            //return seq;
        }

        
    }


    
    private class RevokedCertificatesEnumeration implements Enumeration {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.255 -0400", hash_original_field = "9CFEFED8FB9497BAA5CD519D7D2BB5D7", hash_generated_field = "B0D8CED81BAB00EB7CFC8DD7778DE583")

        private Enumeration en;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.255 -0400", hash_original_method = "6A29318C110C11222950EB9111D0EBEA", hash_generated_method = "CA8192B4B33D4156BE2130DE3439FDDC")
          RevokedCertificatesEnumeration(Enumeration en) {
            this.en = en;
            // ---------- Original Method ----------
            //this.en = en;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.261 -0400", hash_original_method = "FBC842E02AF9214599A6659CADABA547", hash_generated_method = "8D05E9AB9829247743A5936B24155005")
        public boolean hasMoreElements() {
            boolean varD406FAC5BAEF39557C344EC267F98583_405887765 = (en.hasMoreElements());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110026864 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_110026864;
            // ---------- Original Method ----------
            //return en.hasMoreElements();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.261 -0400", hash_original_method = "09463CFA8BEF092B2195E66AA891F38D", hash_generated_method = "1817EC7518EA3A495E4187A83739F76C")
        public Object nextElement() {
Object var8B949C02A7708A02E1F778A220F90874_196476796 =             new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
            var8B949C02A7708A02E1F778A220F90874_196476796.addTaint(taint);
            return var8B949C02A7708A02E1F778A220F90874_196476796;
            // ---------- Original Method ----------
            //return new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
        }

        
    }


    
    private class EmptyEnumeration implements Enumeration {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.261 -0400", hash_original_method = "7DE508FCF70F724013E54D107E91DAB2", hash_generated_method = "7DE508FCF70F724013E54D107E91DAB2")
        public EmptyEnumeration ()
        {
            //Synthesized constructor
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.262 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "F0EFF2071F6E14EED9A7607DDDE8E084")
        public boolean hasMoreElements() {
            boolean var68934A3E9455FA72420237EB05902327_1469459905 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1697315740 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1697315740;
            // ---------- Original Method ----------
            //return false;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.262 -0400", hash_original_method = "6A32EEF26E654AE1CD00BB3EBA8A611E", hash_generated_method = "7EB0C040FF516FCF947EB46FECABF302")
        public Object nextElement() {
Object var540C13E9E156B687226421B24F2DF178_731843821 =             null;
            var540C13E9E156B687226421B24F2DF178_731843821.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_731843821;
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
}

