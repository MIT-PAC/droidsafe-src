package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.915 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.917 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.917 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "808E5C397094457CB3293C5FE4742B51")

    private Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.917 -0400", hash_original_field = "5A57C2EC88FCBD38D012B98CFBA87F36", hash_generated_field = "5BCDC1C4FBE338293679F38DE361C5F5")

    private Date thisUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.917 -0400", hash_original_field = "0795B4516D5D7B11F363991643178A98", hash_generated_field = "542D8C0DA2CA3396EC1AD3CB8CEFD869")

    private Date nextUpdate;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.917 -0400", hash_original_field = "0B6950E312B7638124011FB2B7D7DB5E", hash_generated_field = "499B2E318C3D5C046C3561190ADE17E9")

    private List<RevokedCertificate> revokedCertificates;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.917 -0400", hash_original_field = "FCA1AF483E9CDF6520BB02D488ABDB91", hash_generated_field = "B31D18D3B9FA4394AC83C1ED391E4A68")

    private Extensions crlExtensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.918 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.922 -0400", hash_original_method = "31062813EF8734E09BA3D189CC3AAF0B", hash_generated_method = "A4ED463E22612FB239D52B5DA01F0A61")
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
        // ---------- Original Method ----------
        //this.version = version;
        //this.signature = signature;
        //this.issuer = issuer;
        //this.thisUpdate = thisUpdate;
        //this.nextUpdate = nextUpdate;
        //this.revokedCertificates = revokedCertificates;
        //this.crlExtensions = crlExtensions;
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.922 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "7A9272451E7358E15C810271609E4F23")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802644284 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_802644284;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.922 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "7876DD05F7171C3F4D4E47A756A2F5DA")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_161481284 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_161481284 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_161481284.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_161481284;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.923 -0400", hash_original_method = "EBC299B5141657B108909E991892F54F", hash_generated_method = "30A26068DBDB4C33247D3C7111B48192")
    public Name getIssuer() {
        Name varB4EAC82CA7396A68D541C85D26508E83_2101611287 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2101611287 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_2101611287.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2101611287;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.923 -0400", hash_original_method = "3F952D48E5C3F549E0CF72E297E1768F", hash_generated_method = "4AD27ECA85D15A01FA6C4AC7DF7AAF97")
    public Date getThisUpdate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_285905552 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_285905552 = thisUpdate;
        varB4EAC82CA7396A68D541C85D26508E83_285905552.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_285905552;
        // ---------- Original Method ----------
        //return thisUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.936 -0400", hash_original_method = "F86AAF1D9B4DCB96185947A392CE29B0", hash_generated_method = "D24C495899F8AAC348BEFA8F98B2A271")
    public Date getNextUpdate() {
        Date varB4EAC82CA7396A68D541C85D26508E83_1456568793 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1456568793 = nextUpdate;
        varB4EAC82CA7396A68D541C85D26508E83_1456568793.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1456568793;
        // ---------- Original Method ----------
        //return nextUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.936 -0400", hash_original_method = "6BD535137A0D7C6092BE90399C5AC4FA", hash_generated_method = "CF49FF5A8A48C694551AEC033DBFCAF8")
    public List<RevokedCertificate> getRevokedCertificates() {
        List<RevokedCertificate> varB4EAC82CA7396A68D541C85D26508E83_736848487 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_736848487 = revokedCertificates;
        varB4EAC82CA7396A68D541C85D26508E83_736848487.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_736848487;
        // ---------- Original Method ----------
        //return revokedCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.937 -0400", hash_original_method = "24898D069ADDF2B72D4CC75EC979A933", hash_generated_method = "3935CA4662D30373E55F4646DC1962EA")
    public Extensions getCrlExtensions() {
        Extensions varB4EAC82CA7396A68D541C85D26508E83_229120785 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_229120785 = crlExtensions;
        varB4EAC82CA7396A68D541C85D26508E83_229120785.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_229120785;
        // ---------- Original Method ----------
        //return crlExtensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.937 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "20ECF98B43BE268E7885E5EAF1B9FF1F")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_645670428 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_645670428;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.938 -0400", hash_original_method = "44BD020D05A989BAC123F5B223D6D101", hash_generated_method = "C9565F1ABC1F1DFF5841233BFD88E5F1")
    @Override
    public boolean equals(Object other) {
        TBSCertList that;
        that = (TBSCertList) other;
        boolean var51C5A2D494FCDC01798DFC15C2FF23D5_363711807 = (version == that.version
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
                    : crlExtensions.equals(that.crlExtensions))); //DSFIXME:  CODE0008: Nested ternary operator in expression
        addTaint(other.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1482264351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1482264351;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.938 -0400", hash_original_method = "78A1F0B8BEA4B34BD8F201B7131E5881", hash_generated_method = "B5E42CCA1E91572B9C10A1B8F49DE8D2")
    @Override
    public int hashCode() {
        int var8F9977831C892D0112B4161E15438FCD_1030668756 = (((version * 37 + signature.hashCode()) * 37
                + Arrays.hashCode(issuer.getEncoded())) * 37
                + (int)thisUpdate.getTime() / 1000);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328241476 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_328241476;
        // ---------- Original Method ----------
        //return ((version * 37 + signature.hashCode()) * 37
                //+ Arrays.hashCode(issuer.getEncoded())) * 37
                //+ (int)thisUpdate.getTime() / 1000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.009 -0400", hash_original_method = "8372CF0910098C0215CEE031DBAAD799", hash_generated_method = "8319D2AFBC450B4945614C148CE0618E")
    public void dumpValue(StringBuilder sb) {
        sb.append("X.509 CRL v").append(version);
        sb.append("\nSignature Algorithm: [");
        signature.dumpValue(sb);
        sb.append(']');
        sb.append("\nIssuer: ").append(issuer.getName(X500Principal.RFC2253));
        sb.append("\n\nThis Update: ").append(thisUpdate);
        sb.append("\nNext Update: ").append(nextUpdate).append('\n');
        {
            sb.append("\nRevoked Certificates: ").append(revokedCertificates.size()).append(" [");
            int number;
            number = 1;
            {
                Iterator<RevokedCertificate> var7F70FC11F3EDB995913FD1125CF6FA83_361757004 = (revokedCertificates).iterator();
                var7F70FC11F3EDB995913FD1125CF6FA83_361757004.hasNext();
                RevokedCertificate revokedCertificate = var7F70FC11F3EDB995913FD1125CF6FA83_361757004.next();
                {
                    sb.append("\n  [").append(number++).append(']');
                    revokedCertificate.dumpValue(sb, "  ");
                    sb.append('\n');
                } //End block
            } //End collapsed parenthetic
            sb.append("]\n");
        } //End block
        {
            sb.append("\nCRL Extensions: ").append(crlExtensions.size()).append(" [");
            crlExtensions.dumpValue(sb, "  ");
            sb.append("]\n");
        } //End block
        addTaint(sb.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class RevokedCertificate {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.009 -0400", hash_original_field = "71A5BB307937C590A67CEB96CF72CF12", hash_generated_field = "BA3F88CA120743D40A7FAC017674A8A6")

        private BigInteger userCertificate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.009 -0400", hash_original_field = "30D935E32E2556ADF9A447D78BEC8E47", hash_generated_field = "98BEBEA22AD2549C5C220A56BC4B5B48")

        private Date revocationDate;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.009 -0400", hash_original_field = "AD8C0148B3A586F917CF6245F9F618B8", hash_generated_field = "2B758F6EC9C6C53EA4A9263CD866DCCF")

        private Extensions crlEntryExtensions;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.009 -0400", hash_original_field = "7DA44D239270FE1C37189E2741A43B76", hash_generated_field = "99CCA543CBC7A8739D82292112850772")

        private boolean issuerRetrieved;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.009 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

        private X500Principal issuer;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.009 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

        private byte[] encoding;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.009 -0400", hash_original_method = "5F12FE515CE9F47CBF71064D9DB4557F", hash_generated_method = "BC1DB00FC7FFB3D0501D51D30D51D61C")
        public  RevokedCertificate(BigInteger userCertificate,
                Date revocationDate, Extensions crlEntryExtensions) {
            this.userCertificate = userCertificate;
            this.revocationDate = revocationDate;
            this.crlEntryExtensions = crlEntryExtensions;
            // ---------- Original Method ----------
            //this.userCertificate = userCertificate;
            //this.revocationDate = revocationDate;
            //this.crlEntryExtensions = crlEntryExtensions;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.010 -0400", hash_original_method = "235B3774752183ABFC67FCFEA882E536", hash_generated_method = "C2E5CED68F1B0EE88D953440262684FD")
        public Extensions getCrlEntryExtensions() {
            Extensions varB4EAC82CA7396A68D541C85D26508E83_80421133 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_80421133 = crlEntryExtensions;
            varB4EAC82CA7396A68D541C85D26508E83_80421133.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_80421133;
            // ---------- Original Method ----------
            //return crlEntryExtensions;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.010 -0400", hash_original_method = "95F3FA234A9F19C0F47C92249F7AFDCC", hash_generated_method = "E31361033516654C091191628CC2349E")
        public BigInteger getUserCertificate() {
            BigInteger varB4EAC82CA7396A68D541C85D26508E83_1287726458 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1287726458 = userCertificate;
            varB4EAC82CA7396A68D541C85D26508E83_1287726458.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1287726458;
            // ---------- Original Method ----------
            //return userCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.028 -0400", hash_original_method = "0C5E7D843026F709B3652BD32A196980", hash_generated_method = "97656C8ECFF3EF354B00BDE5EA1C8A23")
        public Date getRevocationDate() {
            Date varB4EAC82CA7396A68D541C85D26508E83_1421725499 = null; //Variable for return #1
            varB4EAC82CA7396A68D541C85D26508E83_1421725499 = revocationDate;
            varB4EAC82CA7396A68D541C85D26508E83_1421725499.addTaint(getTaint()); //Add taint from parent
            return varB4EAC82CA7396A68D541C85D26508E83_1421725499;
            // ---------- Original Method ----------
            //return revocationDate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.029 -0400", hash_original_method = "CDE119A341F8D25B9AE6819B0711631F", hash_generated_method = "30A1C141BBEAB319B93CD058F51BC9AB")
        public X500Principal getIssuer() {
            X500Principal varB4EAC82CA7396A68D541C85D26508E83_713898102 = null; //Variable for return #1
            X500Principal varB4EAC82CA7396A68D541C85D26508E83_1068344400 = null; //Variable for return #2
            {
                varB4EAC82CA7396A68D541C85D26508E83_713898102 = null;
            } //End block
            {
                try 
                {
                    issuer =
                        crlEntryExtensions.valueOfCertificateIssuerExtension();
                } //End block
                catch (IOException e)
                {
                    e.printStackTrace();
                } //End block
                issuerRetrieved = true;
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_1068344400 = issuer;
            X500Principal varA7E53CE21691AB073D9660D615818899_549722561; //Final return value
            switch (DroidSafeAndroidRuntime.switchControl) {
                case 1: //Assign result for return ordinal #1
                    varA7E53CE21691AB073D9660D615818899_549722561 = varB4EAC82CA7396A68D541C85D26508E83_713898102;
                    break;
                default:
                    varA7E53CE21691AB073D9660D615818899_549722561 = varB4EAC82CA7396A68D541C85D26508E83_1068344400;
                    break;
            }
            varA7E53CE21691AB073D9660D615818899_549722561.addTaint(getTaint()); //Add taint from parent
            return varA7E53CE21691AB073D9660D615818899_549722561;
            // ---------- Original Method ----------
            //if (crlEntryExtensions == null) {
                //return null;
            //}
            //if (!issuerRetrieved) {
                //try {
                    //issuer =
                        //crlEntryExtensions.valueOfCertificateIssuerExtension();
                //} catch (IOException e) {
                    //e.printStackTrace();
                //}
                //issuerRetrieved = true;
            //}
            //return issuer;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.030 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "8BF3D7DFE21A7440644155B1D26C92CF")
        public byte[] getEncoded() {
            {
                encoding = ASN1.encode(this);
            } //End block
            byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_977215213 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_977215213;
            // ---------- Original Method ----------
            //if (encoding == null) {
                //encoding = ASN1.encode(this);
            //}
            //return encoding;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.030 -0400", hash_original_method = "E8EF795929F81DA5391DEE3D693BAF7B", hash_generated_method = "284F70FF5189355979EBE24891611F56")
        public boolean equals(Object rc) {
            RevokedCertificate rcert;
            rcert = (RevokedCertificate) rc;
            boolean varE9731F2696B03E889077180FB8C83291_1935171496 = (userCertificate.equals(rcert.userCertificate)
                && ((revocationDate.getTime() / 1000)
                        == (rcert.revocationDate.getTime() / 1000))
                && ((crlEntryExtensions == null)
                    ? rcert.crlEntryExtensions == null
                    : crlEntryExtensions.equals(rcert.crlEntryExtensions))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            addTaint(rc.getTaint());
            boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_509720544 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_509720544;
            // ---------- Original Method ----------
            //if (!(rc instanceof RevokedCertificate)) {
                //return false;
            //}
            //RevokedCertificate rcert = (RevokedCertificate) rc;
            //return userCertificate.equals(rcert.userCertificate)
                //&& ((revocationDate.getTime() / 1000)
                        //== (rcert.revocationDate.getTime() / 1000))
                //&& ((crlEntryExtensions == null)
                    //? rcert.crlEntryExtensions == null
                    //: crlEntryExtensions.equals(rcert.crlEntryExtensions));
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.031 -0400", hash_original_method = "524410A369A93135245C5EB9BC27F7C2", hash_generated_method = "B45F8D842AA54D72602FCCAAB971208A")
        public int hashCode() {
            int var72DA3C28B9AFC66C53817C70139CF3EF_1049549620 = (userCertificate.hashCode() * 37 + (int)revocationDate.getTime() / 1000
                    + (crlEntryExtensions == null ? 0 : crlEntryExtensions.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981814244 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_981814244;
            // ---------- Original Method ----------
            //return userCertificate.hashCode() * 37 + (int)revocationDate.getTime() / 1000
                    //+ (crlEntryExtensions == null ? 0 : crlEntryExtensions.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.032 -0400", hash_original_method = "8F642BB50419022F85F1FC1824E6E317", hash_generated_method = "8A9DDD53D6D85B9CDDAD7A0FBDECA4D1")
        public void dumpValue(StringBuilder sb, String prefix) {
            sb.append(prefix).append("Certificate Serial Number: ").append(userCertificate).append('\n');
            sb.append(prefix).append("Revocation Date: ").append(revocationDate);
            {
                sb.append('\n').append(prefix).append("CRL Entry Extensions: [");
                crlEntryExtensions.dumpValue(sb, prefix + "  ");
                sb.append(prefix).append(']');
            } //End block
            addTaint(sb.getTaint());
            addTaint(prefix.getTaint());
            // ---------- Original Method ----------
            //sb.append(prefix).append("Certificate Serial Number: ").append(userCertificate).append('\n');
            //sb.append(prefix).append("Revocation Date: ").append(revocationDate);
            //if (crlEntryExtensions != null) {
                //sb.append('\n').append(prefix).append("CRL Entry Extensions: [");
                //crlEntryExtensions.dumpValue(sb, prefix + "  ");
                //sb.append(prefix).append(']');
            //}
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.032 -0400", hash_original_field = "0EB062719792FA91CCD2C8AAE392BE5A", hash_generated_field = "82E33EB05B176947C86ABB8EA99FD282")

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


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:11.032 -0400", hash_original_field = "B99D8A08CC5C7677C59256AABCDC0E22", hash_generated_field = "49D719EDF57E2338F15D6AF8FC0620BA")

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

