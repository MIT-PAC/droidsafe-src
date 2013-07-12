package org.apache.harmony.security.x509;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SequenceOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.Name;

public final class TBSCertList {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.439 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.439 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.439 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "808E5C397094457CB3293C5FE4742B51")

    private Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.440 -0400", hash_original_field = "5A57C2EC88FCBD38D012B98CFBA87F36", hash_generated_field = "5BCDC1C4FBE338293679F38DE361C5F5")

    private Date thisUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.440 -0400", hash_original_field = "0795B4516D5D7B11F363991643178A98", hash_generated_field = "542D8C0DA2CA3396EC1AD3CB8CEFD869")

    private Date nextUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.440 -0400", hash_original_field = "0B6950E312B7638124011FB2B7D7DB5E", hash_generated_field = "499B2E318C3D5C046C3561190ADE17E9")

    private List<RevokedCertificate> revokedCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.440 -0400", hash_original_field = "FCA1AF483E9CDF6520BB02D488ABDB91", hash_generated_field = "B31D18D3B9FA4394AC83C1ED391E4A68")

    private Extensions crlExtensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.440 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.441 -0400", hash_original_method = "31062813EF8734E09BA3D189CC3AAF0B", hash_generated_method = "A4ED463E22612FB239D52B5DA01F0A61")
    private  TBSCertList(int version, AlgorithmIdentifier signature,
            Name issuer, Date thisUpdate, Date nextUpdate,
            List<RevokedCertificate> revokedCertificates, Extensions crlExtensions,
            byte[] encoding) {
        this.version = version;
        this.signature = signature;
        this.issuer = issuer;
        this.thisUpdate = thisUpdate;
        this.nextUpdate = nextUpdate;
        this.revokedCertificates = revokedCertificates;
        this.crlExtensions = crlExtensions;
        this.encoding = encoding;
        
        
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.442 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "4E9B13A2BBBF06A3938377B5C8B5C24A")
    public int getVersion() {
        int var2AF72F100C356273D46284F6FD1DFC08_816233566 = (version);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718232669 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1718232669;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.442 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "8E9E5C1BC908B8E65A48A9E42BA6F1BB")
    public AlgorithmIdentifier getSignature() {
AlgorithmIdentifier varCDF7DED6F053AD37D069B3F1993A6032_697373277 =         signature;
        varCDF7DED6F053AD37D069B3F1993A6032_697373277.addTaint(taint);
        return varCDF7DED6F053AD37D069B3F1993A6032_697373277;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.442 -0400", hash_original_method = "EBC299B5141657B108909E991892F54F", hash_generated_method = "3487377467E212201BEBD3AD4ADB47F5")
    public Name getIssuer() {
Name var8EF52627413B91AB97DB59853805E979_1706063687 =         issuer;
        var8EF52627413B91AB97DB59853805E979_1706063687.addTaint(taint);
        return var8EF52627413B91AB97DB59853805E979_1706063687;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.442 -0400", hash_original_method = "3F952D48E5C3F549E0CF72E297E1768F", hash_generated_method = "0D246255C275747C6B7F94B39CD44480")
    public Date getThisUpdate() {
Date varD1B56197E31CD050E59B70739E2BD702_1333882186 =         thisUpdate;
        varD1B56197E31CD050E59B70739E2BD702_1333882186.addTaint(taint);
        return varD1B56197E31CD050E59B70739E2BD702_1333882186;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.443 -0400", hash_original_method = "F86AAF1D9B4DCB96185947A392CE29B0", hash_generated_method = "916DFA3FA292DA38456A5EDBF75327AC")
    public Date getNextUpdate() {
Date var668F801CBC2DC1072BF49CB46E481CAC_66113313 =         nextUpdate;
        var668F801CBC2DC1072BF49CB46E481CAC_66113313.addTaint(taint);
        return var668F801CBC2DC1072BF49CB46E481CAC_66113313;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.443 -0400", hash_original_method = "6BD535137A0D7C6092BE90399C5AC4FA", hash_generated_method = "FAD275FA6B7F7A33A5DF5F13D616CE0C")
    public List<RevokedCertificate> getRevokedCertificates() {
List<RevokedCertificate> var90744F4394D2E5E9BBF87444A25F95F8_1216625070 =         revokedCertificates;
        var90744F4394D2E5E9BBF87444A25F95F8_1216625070.addTaint(taint);
        return var90744F4394D2E5E9BBF87444A25F95F8_1216625070;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.443 -0400", hash_original_method = "24898D069ADDF2B72D4CC75EC979A933", hash_generated_method = "BC46A34F70AAFD61DBA0AA485923F8AB")
    public Extensions getCrlExtensions() {
Extensions varDCEFD14A175BE50B5AC0E611125816AD_990392486 =         crlExtensions;
        varDCEFD14A175BE50B5AC0E611125816AD_990392486.addTaint(taint);
        return varDCEFD14A175BE50B5AC0E611125816AD_990392486;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.443 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "9A905FF3CA0A7B7BD85B01EC01566E15")
    public byte[] getEncoded() {
    if(encoding == null)        
        {
            encoding = ASN1.encode(this);
        } 
        byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1246526068 = (encoding);
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_149086740 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_149086740;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.444 -0400", hash_original_method = "44BD020D05A989BAC123F5B223D6D101", hash_generated_method = "ED5692EE6EE5A81D7979EF0795016079")
    @Override
    public boolean equals(Object other) {
        addTaint(other.getTaint());
    if(!(other instanceof TBSCertList))        
        {
            boolean var68934A3E9455FA72420237EB05902327_265352472 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_250156491 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_250156491;
        } 
        TBSCertList that = (TBSCertList) other;
        boolean var85C112FBDCB846111D06F23453AFDD52_229176089 = (version == that.version
            && signature.equals(that.signature)
            && Arrays.equals(issuer.getEncoded(), that.issuer.getEncoded())
            && thisUpdate.getTime() / 1000
                    == that.thisUpdate.getTime() / 1000
            && (nextUpdate == null
                    ? that.nextUpdate == null
                    : nextUpdate.getTime() / 1000
                        == that.nextUpdate.getTime() / 1000)
            && ((revokedCertificates == null || that.revokedCertificates == null)
                && revokedCertificates == that.revokedCertificates
                || revokedCertificates.equals(that.revokedCertificates))
            && (crlExtensions == null
                    ? that.crlExtensions == null
                    : crlExtensions.equals(that.crlExtensions)));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_253068450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_253068450;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.444 -0400", hash_original_method = "78A1F0B8BEA4B34BD8F201B7131E5881", hash_generated_method = "0E2A2CEEAA57F73F6E838F1259A15E9C")
    @Override
    public int hashCode() {
        int var6287A106101A47C8E045A27615DA64C9_1857574939 = (((version * 37 + signature.hashCode()) * 37
                + Arrays.hashCode(issuer.getEncoded())) * 37
                + (int)thisUpdate.getTime() / 1000);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528259495 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_528259495;
        
        
                
                
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.445 -0400", hash_original_method = "8372CF0910098C0215CEE031DBAAD799", hash_generated_method = "1672F2BDD83D64B7268A33CC8DA5A13E")
    public void dumpValue(StringBuilder sb) {
        addTaint(sb.getTaint());
        sb.append("X.509 CRL v").append(version);
        sb.append("\nSignature Algorithm: [");
        signature.dumpValue(sb);
        sb.append(']');
        sb.append("\nIssuer: ").append(issuer.getName(X500Principal.RFC2253));
        sb.append("\n\nThis Update: ").append(thisUpdate);
        sb.append("\nNext Update: ").append(nextUpdate).append('\n');
    if(revokedCertificates != null)        
        {
            sb.append("\nRevoked Certificates: ").append(revokedCertificates.size()).append(" [");
            int number = 1;
for(RevokedCertificate revokedCertificate : revokedCertificates)
            {
                sb.append("\n  [").append(number++).append(']');
                revokedCertificate.dumpValue(sb, "  ");
                sb.append('\n');
            } 
            sb.append("]\n");
        } 
    if(crlExtensions != null)        
        {
            sb.append("\nCRL Extensions: ").append(crlExtensions.size()).append(" [");
            crlExtensions.dumpValue(sb, "  ");
            sb.append("]\n");
        } 
        
        
    }

    
    public static class RevokedCertificate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.445 -0400", hash_original_field = "71A5BB307937C590A67CEB96CF72CF12", hash_generated_field = "BA3F88CA120743D40A7FAC017674A8A6")

        private BigInteger userCertificate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.446 -0400", hash_original_field = "30D935E32E2556ADF9A447D78BEC8E47", hash_generated_field = "98BEBEA22AD2549C5C220A56BC4B5B48")

        private Date revocationDate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.446 -0400", hash_original_field = "AD8C0148B3A586F917CF6245F9F618B8", hash_generated_field = "2B758F6EC9C6C53EA4A9263CD866DCCF")

        private Extensions crlEntryExtensions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.446 -0400", hash_original_field = "7DA44D239270FE1C37189E2741A43B76", hash_generated_field = "99CCA543CBC7A8739D82292112850772")

        private boolean issuerRetrieved;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.446 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

        private X500Principal issuer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.446 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

        private byte[] encoding;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.447 -0400", hash_original_method = "5F12FE515CE9F47CBF71064D9DB4557F", hash_generated_method = "BC1DB00FC7FFB3D0501D51D30D51D61C")
        public  RevokedCertificate(BigInteger userCertificate,
                Date revocationDate, Extensions crlEntryExtensions) {
            this.userCertificate = userCertificate;
            this.revocationDate = revocationDate;
            this.crlEntryExtensions = crlEntryExtensions;
            
            
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.447 -0400", hash_original_method = "235B3774752183ABFC67FCFEA882E536", hash_generated_method = "2C4185CEBC2D47A711770F5710BFB3C9")
        public Extensions getCrlEntryExtensions() {
Extensions var7A7A939867039CEA4ADCB8DFD15921BF_1620036554 =             crlEntryExtensions;
            var7A7A939867039CEA4ADCB8DFD15921BF_1620036554.addTaint(taint);
            return var7A7A939867039CEA4ADCB8DFD15921BF_1620036554;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.447 -0400", hash_original_method = "95F3FA234A9F19C0F47C92249F7AFDCC", hash_generated_method = "56E460384A6ED60F2A693831EB68AA2C")
        public BigInteger getUserCertificate() {
BigInteger var29531534CAF33A30A18F3DE7015D0A7C_383161105 =             userCertificate;
            var29531534CAF33A30A18F3DE7015D0A7C_383161105.addTaint(taint);
            return var29531534CAF33A30A18F3DE7015D0A7C_383161105;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.447 -0400", hash_original_method = "0C5E7D843026F709B3652BD32A196980", hash_generated_method = "437995B589D990A0AE97640C86A44C05")
        public Date getRevocationDate() {
Date varBE194ECAF8C3A05947697E51EC2341D1_2079229786 =             revocationDate;
            varBE194ECAF8C3A05947697E51EC2341D1_2079229786.addTaint(taint);
            return varBE194ECAF8C3A05947697E51EC2341D1_2079229786;
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.448 -0400", hash_original_method = "CDE119A341F8D25B9AE6819B0711631F", hash_generated_method = "F8B0A3C9957070DD8BECC808E3BA5E24")
        public X500Principal getIssuer() {
    if(crlEntryExtensions == null)            
            {
X500Principal var540C13E9E156B687226421B24F2DF178_1214868787 =                 null;
                var540C13E9E156B687226421B24F2DF178_1214868787.addTaint(taint);
                return var540C13E9E156B687226421B24F2DF178_1214868787;
            } 
    if(!issuerRetrieved)            
            {
                try 
                {
                    issuer =
                        crlEntryExtensions.valueOfCertificateIssuerExtension();
                } 
                catch (IOException e)
                {
                    e.printStackTrace();
                } 
                issuerRetrieved = true;
            } 
X500Principal var8EF52627413B91AB97DB59853805E979_1064351769 =             issuer;
            var8EF52627413B91AB97DB59853805E979_1064351769.addTaint(taint);
            return var8EF52627413B91AB97DB59853805E979_1064351769;
            
            
                
            
            
                
                    
                        
                
                    
                
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.448 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "37455102ABCA2FC99A0E75CC1D0FEBC6")
        public byte[] getEncoded() {
    if(encoding == null)            
            {
                encoding = ASN1.encode(this);
            } 
            byte[] var84BEA1F0FD2CE16F7E562A9F06EF03D3_1698972451 = (encoding);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1501401268 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1501401268;
            
            
                
            
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.449 -0400", hash_original_method = "E8EF795929F81DA5391DEE3D693BAF7B", hash_generated_method = "9146FFA9B05C5BCAD4EB1154E224ED54")
        public boolean equals(Object rc) {
            addTaint(rc.getTaint());
    if(!(rc instanceof RevokedCertificate))            
            {
                boolean var68934A3E9455FA72420237EB05902327_1205081448 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856766244 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856766244;
            } 
            RevokedCertificate rcert = (RevokedCertificate) rc;
            boolean var2F818DFE6F1FA6529353CF90D83CD0CE_1155790587 = (userCertificate.equals(rcert.userCertificate)
                && ((revocationDate.getTime() / 1000)
                        == (rcert.revocationDate.getTime() / 1000))
                && ((crlEntryExtensions == null)
                    ? rcert.crlEntryExtensions == null
                    : crlEntryExtensions.equals(rcert.crlEntryExtensions)));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_745511342 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_745511342;
            
            
                
            
            
            
                
                        
                
                    
                    
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.449 -0400", hash_original_method = "524410A369A93135245C5EB9BC27F7C2", hash_generated_method = "85A4293CBB626459671A0F932DF8D7C8")
        public int hashCode() {
            int var02A0EC16C21900D495366D145DAA716F_2118145867 = (userCertificate.hashCode() * 37 + (int)revocationDate.getTime() / 1000
                    + (crlEntryExtensions == null ? 0 : crlEntryExtensions.hashCode()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402425570 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_402425570;
            
            
                    
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.450 -0400", hash_original_method = "8F642BB50419022F85F1FC1824E6E317", hash_generated_method = "2CDC66FCA0B8067D1E15C4C8AEF80B58")
        public void dumpValue(StringBuilder sb, String prefix) {
            addTaint(prefix.getTaint());
            addTaint(sb.getTaint());
            sb.append(prefix).append("Certificate Serial Number: ").append(userCertificate).append('\n');
            sb.append(prefix).append("Revocation Date: ").append(revocationDate);
    if(crlEntryExtensions != null)            
            {
                sb.append('\n').append(prefix).append("CRL Entry Extensions: [");
                crlEntryExtensions.dumpValue(sb, prefix + "  ");
                sb.append(prefix).append(']');
            } 
            
            
            
            
                
                
                
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.450 -0400", hash_original_field = "0EB062719792FA91CCD2C8AAE392BE5A", hash_generated_field = "82E33EB05B176947C86ABB8EA99FD282")

        public static final ASN1Sequence ASN1 = new ASN1Sequence(
                new ASN1Type[] {ASN1Integer.getInstance(), Time.ASN1,
                Extensions.ASN1}) {
            {
                setOptional(2);
            }

            @Override protected Object getDecodedObject(BerInputStream in) {
                Object[] values = (Object[]) in.content;
                return new RevokedCertificate(
                            new BigInteger((byte[]) values[0]),
                            (Date) values[1],
                            (Extensions) values[2]
                        );
            }

            @Override protected void getValues(Object object, Object[] values) {
                RevokedCertificate rcert = (RevokedCertificate) object;
                values[0] = rcert.userCertificate.toByteArray();
                values[1] = rcert.revocationDate;
                values[2] = rcert.crlEntryExtensions;
            }
        };
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:03:19.450 -0400", hash_original_field = "B99D8A08CC5C7677C59256AABCDC0E22", hash_generated_field = "49D719EDF57E2338F15D6AF8FC0620BA")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Integer.getInstance(), 
            AlgorithmIdentifier.ASN1,  
            Name.ASN1, 
            Time.ASN1, 
            Time.ASN1, 
            new ASN1SequenceOf(RevokedCertificate.ASN1), 
            new ASN1Explicit(0, Extensions.ASN1) 
                }) {
        {
            setOptional(0);
            setOptional(4);
            setOptional(5);
            setOptional(6);
        }

        @Override protected Object getDecodedObject(BerInputStream in) throws IOException {
            Object[] values = (Object[]) in.content;
            return new TBSCertList(
                        (values[0] == null)
                            ? 1
                            : ASN1Integer.toIntValue(values[0])+1,
                        (AlgorithmIdentifier) values[1],
                        (Name) values[2],
                        (Date) values[3],
                        (Date) values[4],
                        (List<RevokedCertificate>) values[5],
                        (Extensions) values[6],
                        in.getEncoded()
                    );
        }

        @Override protected void getValues(Object object, Object[] values) {
            TBSCertList tbs = (TBSCertList) object;
            values[0] = (tbs.version > 1)
                ? ASN1Integer.fromIntValue(tbs.version - 1) : null;
            values[1] = tbs.signature;
            values[2] = tbs.issuer;
            values[3] = tbs.thisUpdate;
            values[4] = tbs.nextUpdate;
            values[5] = tbs.revokedCertificates;
            values[6] = tbs.crlExtensions;
        }
    };
}

