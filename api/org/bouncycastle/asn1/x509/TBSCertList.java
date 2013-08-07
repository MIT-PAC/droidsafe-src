package org.bouncycastle.asn1.x509;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.902 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

    ASN1Sequence seq;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.903 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "E228CDE1667030A19BE9074EE632C2E6")

    DERInteger version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.903 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "A9C2427A585DE5C2846E517FA208C326")

    AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.903 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "5D6D7F9E9DB3838227A35E0CE4DA4A40")

    X509Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.903 -0400", hash_original_field = "5A57C2EC88FCBD38D012B98CFBA87F36", hash_generated_field = "F7307148EA192C2AC6829F3D6478616E")

    Time thisUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.903 -0400", hash_original_field = "0795B4516D5D7B11F363991643178A98", hash_generated_field = "81E26EA846E6309FDA2B763EEE4322CF")

    Time nextUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.903 -0400", hash_original_field = "0B6950E312B7638124011FB2B7D7DB5E", hash_generated_field = "AE9FB0F92F5352F3D989DA8B1E3BF6E8")

    ASN1Sequence revokedCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.903 -0400", hash_original_field = "FCA1AF483E9CDF6520BB02D488ABDB91", hash_generated_field = "32AFE711317FCCD7D6FFF9CE186DE901")

    X509Extensions crlExtensions;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.905 -0400", hash_original_method = "979311BA6EB06D915E93C36961984E0B", hash_generated_method = "8A2D37E963CB60F303AF935C1457CC82")
    public  TBSCertList(
        ASN1Sequence  seq) {
        if(seq.size() < 3 || seq.size() > 7)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1670324337 = new IllegalArgumentException("Bad sequence size: " + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_1670324337.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1670324337;
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

    
    @DSModeled(DSC.SAFE)
    public static TBSCertList getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSModeled(DSC.SAFE)
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.906 -0400", hash_original_method = "FDACF2D9FDD982F7370FC1531628D869", hash_generated_method = "B9467CB3FEDE5EF589F963CD617127DE")
    public int getVersion() {
        int var4E01D99371F8A746A4C58A8E9E72F05E_1711176432 = (version.getValue().intValue() + 1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1195017522 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1195017522;
        // ---------- Original Method ----------
        //return version.getValue().intValue() + 1;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.906 -0400", hash_original_method = "AC16A6F43E56B222CBB33342980501D7", hash_generated_method = "8234FD49BA242AE2E669B7FC4FA9CA55")
    public DERInteger getVersionNumber() {
DERInteger varE87BEFBC04DA371DFA5B07C77A4407CB_610815215 =         version;
        varE87BEFBC04DA371DFA5B07C77A4407CB_610815215.addTaint(taint);
        return varE87BEFBC04DA371DFA5B07C77A4407CB_610815215;
        // ---------- Original Method ----------
        //return version;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.906 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "CB6A5B7CB80738862802D6ACA711351A")
    public AlgorithmIdentifier getSignature() {
AlgorithmIdentifier varCDF7DED6F053AD37D069B3F1993A6032_1660798613 =         signature;
        varCDF7DED6F053AD37D069B3F1993A6032_1660798613.addTaint(taint);
        return varCDF7DED6F053AD37D069B3F1993A6032_1660798613;
        // ---------- Original Method ----------
        //return signature;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.906 -0400", hash_original_method = "45BDDD2025565616026FAE1CCD324C0F", hash_generated_method = "63782DFE465F3F1D4F28C0B4DD42EB03")
    public X509Name getIssuer() {
X509Name var8EF52627413B91AB97DB59853805E979_406331149 =         issuer;
        var8EF52627413B91AB97DB59853805E979_406331149.addTaint(taint);
        return var8EF52627413B91AB97DB59853805E979_406331149;
        // ---------- Original Method ----------
        //return issuer;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.907 -0400", hash_original_method = "13C3CAE3E054BA140B8F621AE3EA7547", hash_generated_method = "D79E68BD41F51F08787451D34672699C")
    public Time getThisUpdate() {
Time varD1B56197E31CD050E59B70739E2BD702_1618047953 =         thisUpdate;
        varD1B56197E31CD050E59B70739E2BD702_1618047953.addTaint(taint);
        return varD1B56197E31CD050E59B70739E2BD702_1618047953;
        // ---------- Original Method ----------
        //return thisUpdate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.907 -0400", hash_original_method = "A77204D0766EFD8AD6F24F7F347199B2", hash_generated_method = "50F43ABDEA2C9B7183DDC257EACC2F41")
    public Time getNextUpdate() {
Time var668F801CBC2DC1072BF49CB46E481CAC_877618808 =         nextUpdate;
        var668F801CBC2DC1072BF49CB46E481CAC_877618808.addTaint(taint);
        return var668F801CBC2DC1072BF49CB46E481CAC_877618808;
        // ---------- Original Method ----------
        //return nextUpdate;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.908 -0400", hash_original_method = "CEAEC6FC0ECB759CC0350D156B5BC4BE", hash_generated_method = "67DC4E5871AE50A26D5A6B4ADB0631F2")
    public CRLEntry[] getRevokedCertificates() {
        if(revokedCertificates == null)        
        {
CRLEntry[] var48BC37704C652E7363F10E3946D90E23_604452333 =             new CRLEntry[0];
            var48BC37704C652E7363F10E3946D90E23_604452333.addTaint(taint);
            return var48BC37704C652E7363F10E3946D90E23_604452333;
        } //End block
        CRLEntry[] entries = new CRLEntry[revokedCertificates.size()];
for(int i = 0;i < entries.length;i++)
        {
            entries[i] = new CRLEntry(ASN1Sequence.getInstance(revokedCertificates.getObjectAt(i)));
        } //End block
CRLEntry[] var0AAD0D341A96E603A0F87B9A9B535A71_832500384 =         entries;
        var0AAD0D341A96E603A0F87B9A9B535A71_832500384.addTaint(taint);
        return var0AAD0D341A96E603A0F87B9A9B535A71_832500384;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.908 -0400", hash_original_method = "6375844A31081D053220C645D0F9B87E", hash_generated_method = "051EF977B377237922EE9B3A4FCF74FA")
    public Enumeration getRevokedCertificateEnumeration() {
        if(revokedCertificates == null)        
        {
Enumeration var7D104FFA51584557B2AF340B96DE0ED6_1144389899 =             new EmptyEnumeration();
            var7D104FFA51584557B2AF340B96DE0ED6_1144389899.addTaint(taint);
            return var7D104FFA51584557B2AF340B96DE0ED6_1144389899;
        } //End block
Enumeration var057C4F0D1CBF03CCA9204B25301F4AF1_1713553176 =         new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
        var057C4F0D1CBF03CCA9204B25301F4AF1_1713553176.addTaint(taint);
        return var057C4F0D1CBF03CCA9204B25301F4AF1_1713553176;
        // ---------- Original Method ----------
        //if (revokedCertificates == null)
        //{
            //return new EmptyEnumeration();
        //}
        //return new RevokedCertificatesEnumeration(revokedCertificates.getObjects());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.909 -0400", hash_original_method = "CDE1CFE7081DEA43241E45471E737135", hash_generated_method = "D351514700AA163DE2A3E92935CA397D")
    public X509Extensions getExtensions() {
X509Extensions varDCEFD14A175BE50B5AC0E611125816AD_363738277 =         crlExtensions;
        varDCEFD14A175BE50B5AC0E611125816AD_363738277.addTaint(taint);
        return varDCEFD14A175BE50B5AC0E611125816AD_363738277;
        // ---------- Original Method ----------
        //return crlExtensions;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.909 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "753F04F86029A46FE8A48EE9A6D9D03B")
    public DERObject toASN1Object() {
DERObject var42A78C062640017A329FA085150BC1B8_1695634015 =         seq;
        var42A78C062640017A329FA085150BC1B8_1695634015.addTaint(taint);
        return var42A78C062640017A329FA085150BC1B8_1695634015;
        // ---------- Original Method ----------
        //return seq;
    }

    
    public static class CRLEntry extends ASN1Encodable {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.909 -0400", hash_original_field = "E068C2DE26D760F20CF10AFC4B87EF0F", hash_generated_field = "67B66723C4558F27E19029159A09253A")

        ASN1Sequence seq;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.909 -0400", hash_original_field = "71A5BB307937C590A67CEB96CF72CF12", hash_generated_field = "2B07ABA517A3C72D4D1AE840B26D1CBC")

        DERInteger userCertificate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.909 -0400", hash_original_field = "30D935E32E2556ADF9A447D78BEC8E47", hash_generated_field = "6E03E433A7A3E5DD51EB4D05094D4199")

        Time revocationDate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.910 -0400", hash_original_field = "AD8C0148B3A586F917CF6245F9F618B8", hash_generated_field = "16E9DEFD70BF4A992A02A9F3935A2277")

        X509Extensions crlEntryExtensions;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.910 -0400", hash_original_method = "5E4E4AC1AFC14B33E134B0DE6A66EF69", hash_generated_method = "F5B51316F986AB13F94E3D2329D428D1")
        public  CRLEntry(
            ASN1Sequence  seq) {
            if(seq.size() < 2 || seq.size() > 3)            
            {
                IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_1395882115 = new IllegalArgumentException("Bad sequence size: " + seq.size());
                varA2072CF614C7B8C7696DD5A02DBCCE9C_1395882115.addTaint(taint);
                throw varA2072CF614C7B8C7696DD5A02DBCCE9C_1395882115;
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

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.910 -0400", hash_original_method = "4F65DC188C3501616DCFC998DA7DBFCB", hash_generated_method = "F9E63BBB80BD7C7CABCA0D38A4BC53E1")
        public DERInteger getUserCertificate() {
DERInteger var29531534CAF33A30A18F3DE7015D0A7C_227403980 =             userCertificate;
            var29531534CAF33A30A18F3DE7015D0A7C_227403980.addTaint(taint);
            return var29531534CAF33A30A18F3DE7015D0A7C_227403980;
            // ---------- Original Method ----------
            //return userCertificate;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.911 -0400", hash_original_method = "4B493204B476D887C77BCF51D1F57DB2", hash_generated_method = "B58694700CEC0A2FCA68B3A564235703")
        public Time getRevocationDate() {
Time varBE194ECAF8C3A05947697E51EC2341D1_2103790759 =             revocationDate;
            varBE194ECAF8C3A05947697E51EC2341D1_2103790759.addTaint(taint);
            return varBE194ECAF8C3A05947697E51EC2341D1_2103790759;
            // ---------- Original Method ----------
            //return revocationDate;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.911 -0400", hash_original_method = "15344AC9965F1BCC242E7479E06915DE", hash_generated_method = "FD0ABE29C8A2145933A2EF4D226EA2CA")
        public X509Extensions getExtensions() {
            if(crlEntryExtensions == null && seq.size() == 3)            
            {
                crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
            } //End block
X509Extensions var7A7A939867039CEA4ADCB8DFD15921BF_2006704999 =             crlEntryExtensions;
            var7A7A939867039CEA4ADCB8DFD15921BF_2006704999.addTaint(taint);
            return var7A7A939867039CEA4ADCB8DFD15921BF_2006704999;
            // ---------- Original Method ----------
            //if (crlEntryExtensions == null && seq.size() == 3)
            //{
                //crlEntryExtensions = X509Extensions.getInstance(seq.getObjectAt(2));
            //}
            //return crlEntryExtensions;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.911 -0400", hash_original_method = "0BE753B103EB5E27F0AD9CE4B67E8D14", hash_generated_method = "D233BB4ECB329BA41A7B57A9F94F0732")
        public DERObject toASN1Object() {
DERObject var42A78C062640017A329FA085150BC1B8_726834411 =             seq;
            var42A78C062640017A329FA085150BC1B8_726834411.addTaint(taint);
            return var42A78C062640017A329FA085150BC1B8_726834411;
            // ---------- Original Method ----------
            //return seq;
        }

        
    }


    
    private class RevokedCertificatesEnumeration implements Enumeration {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.911 -0400", hash_original_field = "9CFEFED8FB9497BAA5CD519D7D2BB5D7", hash_generated_field = "B0D8CED81BAB00EB7CFC8DD7778DE583")

        private Enumeration en;
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.911 -0400", hash_original_method = "6A29318C110C11222950EB9111D0EBEA", hash_generated_method = "CA8192B4B33D4156BE2130DE3439FDDC")
          RevokedCertificatesEnumeration(Enumeration en) {
            this.en = en;
            // ---------- Original Method ----------
            //this.en = en;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.911 -0400", hash_original_method = "FBC842E02AF9214599A6659CADABA547", hash_generated_method = "EE8F79DF9739D1D8713E9FE87432EEB6")
        public boolean hasMoreElements() {
            boolean varD406FAC5BAEF39557C344EC267F98583_1646963175 = (en.hasMoreElements());
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1345017593 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1345017593;
            // ---------- Original Method ----------
            //return en.hasMoreElements();
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.911 -0400", hash_original_method = "09463CFA8BEF092B2195E66AA891F38D", hash_generated_method = "BC3AE1A190E4A5F5EF8E8A75D5BB87DA")
        public Object nextElement() {
Object var8B949C02A7708A02E1F778A220F90874_983336445 =             new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
            var8B949C02A7708A02E1F778A220F90874_983336445.addTaint(taint);
            return var8B949C02A7708A02E1F778A220F90874_983336445;
            // ---------- Original Method ----------
            //return new CRLEntry(ASN1Sequence.getInstance(en.nextElement()));
        }

        
    }


    
    private class EmptyEnumeration implements Enumeration {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.912 -0400", hash_original_method = "7DE508FCF70F724013E54D107E91DAB2", hash_generated_method = "7DE508FCF70F724013E54D107E91DAB2")
        public EmptyEnumeration ()
        {
            //Synthesized constructor
        }


                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.912 -0400", hash_original_method = "50CD0E92886EDA5BEE0164B092B351EC", hash_generated_method = "D3CC5C3DA94126CC2FB4B1F71A5AD6B2")
        public boolean hasMoreElements() {
            boolean var68934A3E9455FA72420237EB05902327_380741116 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1746681723 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1746681723;
            // ---------- Original Method ----------
            //return false;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:39.912 -0400", hash_original_method = "6A32EEF26E654AE1CD00BB3EBA8A611E", hash_generated_method = "9131CDD9148D7414FFC38C04DC8116EC")
        public Object nextElement() {
Object var540C13E9E156B687226421B24F2DF178_31411949 =             null;
            var540C13E9E156B687226421B24F2DF178_31411949.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_31411949;
            // ---------- Original Method ----------
            //return null;
        }

        
    }


    
}

