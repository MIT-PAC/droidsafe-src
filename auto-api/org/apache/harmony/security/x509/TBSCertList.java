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
    private int version;
    private AlgorithmIdentifier signature;
    private Name issuer;
    private Date thisUpdate;
    private Date nextUpdate;
    private List<RevokedCertificate> revokedCertificates;
    private Extensions crlExtensions;
    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.011 -0400", hash_original_method = "31062813EF8734E09BA3D189CC3AAF0B", hash_generated_method = "C428B0C5D48727FEFFD697B516FF189A")
    @DSModeled(DSC.SAFE)
    private TBSCertList(int version, AlgorithmIdentifier signature,
            Name issuer, Date thisUpdate, Date nextUpdate,
            List<RevokedCertificate> revokedCertificates, Extensions crlExtensions,
            byte[] encoding) {
        dsTaint.addTaint(revokedCertificates.dsTaint);
        dsTaint.addTaint(issuer.dsTaint);
        dsTaint.addTaint(thisUpdate.dsTaint);
        dsTaint.addTaint(encoding[0]);
        dsTaint.addTaint(crlExtensions.dsTaint);
        dsTaint.addTaint(nextUpdate.dsTaint);
        dsTaint.addTaint(signature.dsTaint);
        dsTaint.addTaint(version);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.011 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0E228D4E97C578C96F5A709D7390E3F7")
    @DSModeled(DSC.SAFE)
    public int getVersion() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.011 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "1B2F07883687CEA7AA2415D8324D2CF2")
    @DSModeled(DSC.SAFE)
    public AlgorithmIdentifier getSignature() {
        return (AlgorithmIdentifier)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.011 -0400", hash_original_method = "EBC299B5141657B108909E991892F54F", hash_generated_method = "D5FF3F0AAA66D029F983875C33555B87")
    @DSModeled(DSC.SAFE)
    public Name getIssuer() {
        return (Name)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.011 -0400", hash_original_method = "3F952D48E5C3F549E0CF72E297E1768F", hash_generated_method = "3FFEA7D637543E1DC5809CD913C4E583")
    @DSModeled(DSC.SAFE)
    public Date getThisUpdate() {
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return thisUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.012 -0400", hash_original_method = "F86AAF1D9B4DCB96185947A392CE29B0", hash_generated_method = "31374A306A902C9FE4B93013E7B86794")
    @DSModeled(DSC.SAFE)
    public Date getNextUpdate() {
        return (Date)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nextUpdate;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.012 -0400", hash_original_method = "6BD535137A0D7C6092BE90399C5AC4FA", hash_generated_method = "E9E196DFEFD57F41063B5B73FAF82EB2")
    @DSModeled(DSC.SAFE)
    public List<RevokedCertificate> getRevokedCertificates() {
        return (List<RevokedCertificate>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return revokedCertificates;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.012 -0400", hash_original_method = "24898D069ADDF2B72D4CC75EC979A933", hash_generated_method = "F95FAA3B852991DC72C933CEE77E9EE4")
    @DSModeled(DSC.SAFE)
    public Extensions getCrlExtensions() {
        return (Extensions)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return crlExtensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.012 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.012 -0400", hash_original_method = "44BD020D05A989BAC123F5B223D6D101", hash_generated_method = "E5213A01AA9B5C387CC1CB4DA71D3FC2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object other) {
        dsTaint.addTaint(other.dsTaint);
        TBSCertList that;
        that = (TBSCertList) other;
        boolean var51C5A2D494FCDC01798DFC15C2FF23D5_383437585 = (version == that.version
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
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.013 -0400", hash_original_method = "78A1F0B8BEA4B34BD8F201B7131E5881", hash_generated_method = "B51EDD16E9C7AD0F43AD8D2A5BC33139")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8F9977831C892D0112B4161E15438FCD_333179981 = (((version * 37 + signature.hashCode()) * 37
                + Arrays.hashCode(issuer.getEncoded())) * 37
                + (int)thisUpdate.getTime() / 1000);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return ((version * 37 + signature.hashCode()) * 37
                //+ Arrays.hashCode(issuer.getEncoded())) * 37
                //+ (int)thisUpdate.getTime() / 1000;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.018 -0400", hash_original_method = "8372CF0910098C0215CEE031DBAAD799", hash_generated_method = "4635BD61978B7A0FF6D62339E0BC9F28")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
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
                Iterator<RevokedCertificate> var7F70FC11F3EDB995913FD1125CF6FA83_1135688664 = (revokedCertificates).iterator();
                var7F70FC11F3EDB995913FD1125CF6FA83_1135688664.hasNext();
                RevokedCertificate revokedCertificate = var7F70FC11F3EDB995913FD1125CF6FA83_1135688664.next();
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class RevokedCertificate {
        private BigInteger userCertificate;
        private Date revocationDate;
        private Extensions crlEntryExtensions;
        private boolean issuerRetrieved;
        private X500Principal issuer;
        private byte[] encoding;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.018 -0400", hash_original_method = "5F12FE515CE9F47CBF71064D9DB4557F", hash_generated_method = "8A4BBB4FAB067D7AB86AB22BF35DE2B6")
        @DSModeled(DSC.SAFE)
        public RevokedCertificate(BigInteger userCertificate,
                Date revocationDate, Extensions crlEntryExtensions) {
            dsTaint.addTaint(crlEntryExtensions.dsTaint);
            dsTaint.addTaint(userCertificate.dsTaint);
            dsTaint.addTaint(revocationDate.dsTaint);
            // ---------- Original Method ----------
            //this.userCertificate = userCertificate;
            //this.revocationDate = revocationDate;
            //this.crlEntryExtensions = crlEntryExtensions;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.019 -0400", hash_original_method = "235B3774752183ABFC67FCFEA882E536", hash_generated_method = "724CCA575F7A980D0D01CB86B30F1D11")
        @DSModeled(DSC.SAFE)
        public Extensions getCrlEntryExtensions() {
            return (Extensions)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return crlEntryExtensions;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.019 -0400", hash_original_method = "95F3FA234A9F19C0F47C92249F7AFDCC", hash_generated_method = "37B1A5EA0334D22A0247A91BFE320386")
        @DSModeled(DSC.SAFE)
        public BigInteger getUserCertificate() {
            return (BigInteger)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return userCertificate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.019 -0400", hash_original_method = "0C5E7D843026F709B3652BD32A196980", hash_generated_method = "0598F3DAB455BF4C4CAA92073E462BB0")
        @DSModeled(DSC.SAFE)
        public Date getRevocationDate() {
            return (Date)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return revocationDate;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.019 -0400", hash_original_method = "CDE119A341F8D25B9AE6819B0711631F", hash_generated_method = "FCFD13016AC43C1C785561E16704162A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public X500Principal getIssuer() {
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
            return (X500Principal)dsTaint.getTaint();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.019 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "94FDBB09C313C97C9EDC6BBF307FBE8A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public byte[] getEncoded() {
            {
                encoding = ASN1.encode(this);
            } //End block
            byte[] retVal = new byte[1];
            retVal[0] = (byte)dsTaint.getTaintInt();
            return retVal;
            // ---------- Original Method ----------
            //if (encoding == null) {
                //encoding = ASN1.encode(this);
            //}
            //return encoding;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.020 -0400", hash_original_method = "E8EF795929F81DA5391DEE3D693BAF7B", hash_generated_method = "DFC18D3B24DAD440855B33195BD2D907")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public boolean equals(Object rc) {
            dsTaint.addTaint(rc.dsTaint);
            RevokedCertificate rcert;
            rcert = (RevokedCertificate) rc;
            boolean varE9731F2696B03E889077180FB8C83291_1235262148 = (userCertificate.equals(rcert.userCertificate)
                && ((revocationDate.getTime() / 1000)
                        == (rcert.revocationDate.getTime() / 1000))
                && ((crlEntryExtensions == null)
                    ? rcert.crlEntryExtensions == null
                    : crlEntryExtensions.equals(rcert.crlEntryExtensions))); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintBoolean();
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.020 -0400", hash_original_method = "524410A369A93135245C5EB9BC27F7C2", hash_generated_method = "94D6893D5D34294C7959CD608DD6B734")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public int hashCode() {
            int var72DA3C28B9AFC66C53817C70139CF3EF_1314640911 = (userCertificate.hashCode() * 37 + (int)revocationDate.getTime() / 1000
                    + (crlEntryExtensions == null ? 0 : crlEntryExtensions.hashCode())); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return userCertificate.hashCode() * 37 + (int)revocationDate.getTime() / 1000
                    //+ (crlEntryExtensions == null ? 0 : crlEntryExtensions.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.020 -0400", hash_original_method = "8F642BB50419022F85F1FC1824E6E317", hash_generated_method = "AF4D5360A173A11CE2E7199A11F708C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void dumpValue(StringBuilder sb, String prefix) {
            dsTaint.addTaint(prefix);
            dsTaint.addTaint(sb.dsTaint);
            sb.append(prefix).append("Certificate Serial Number: ").append(userCertificate).append('\n');
            sb.append(prefix).append("Revocation Date: ").append(revocationDate);
            {
                sb.append('\n').append(prefix).append("CRL Entry Extensions: [");
                crlEntryExtensions.dumpValue(sb, prefix + "  ");
                sb.append(prefix).append(']');
            } //End block
            // ---------- Original Method ----------
            //sb.append(prefix).append("Certificate Serial Number: ").append(userCertificate).append('\n');
            //sb.append(prefix).append("Revocation Date: ").append(revocationDate);
            //if (crlEntryExtensions != null) {
                //sb.append('\n').append(prefix).append("CRL Entry Extensions: [");
                //crlEntryExtensions.dumpValue(sb, prefix + "  ");
                //sb.append(prefix).append(']');
            //}
        }

        
        public static final ASN1Sequence ASN1 = new ASN1Sequence(
                new ASN1Type[] {ASN1Integer.getInstance(), Time.ASN1,
                Extensions.ASN1}) {            {
                setOptional(2);
            }
            
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.021 -0400", hash_original_method = "4BFBD5E87B68F249B53912C5A95A2356", hash_generated_method = "409F7CED1234F86ABA5375CE1FB04305")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected Object getDecodedObject(BerInputStream in) {
                dsTaint.addTaint(in.dsTaint);
                Object[] values;
                values = (Object[]) in.content;
                Object var00400EFC69BFCE558D367B8156A61D38_1063033891 = (new RevokedCertificate(
                            new BigInteger((byte[]) values[0]),
                            (Date) values[1],
                            (Extensions) values[2]
                        ));
                return (Object)dsTaint.getTaint();
                // ---------- Original Method ----------
                //Object[] values = (Object[]) in.content;
                //return new RevokedCertificate(
                            //new BigInteger((byte[]) values[0]),
                            //(Date) values[1],
                            //(Extensions) values[2]
                        //);
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.021 -0400", hash_original_method = "1CE4AE8DA5650BCD680F10838448489A", hash_generated_method = "71F017FADD44CDEDC5D3225380AF8D75")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            protected void getValues(Object object, Object[] values) {
                dsTaint.addTaint(values[0].dsTaint);
                dsTaint.addTaint(object.dsTaint);
                RevokedCertificate rcert;
                rcert = (RevokedCertificate) object;
                values[0] = rcert.userCertificate.toByteArray();
                values[1] = rcert.revocationDate;
                values[2] = rcert.crlEntryExtensions;
                // ---------- Original Method ----------
                //RevokedCertificate rcert = (RevokedCertificate) object;
                //values[0] = rcert.userCertificate.toByteArray();
                //values[1] = rcert.revocationDate;
                //values[2] = rcert.crlEntryExtensions;
            }

            
}; //Transformed anonymous class
    }


    
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            ASN1Integer.getInstance(), 
            AlgorithmIdentifier.ASN1,  
            Name.ASN1, 
            Time.ASN1, 
            Time.ASN1, 
            new ASN1SequenceOf(RevokedCertificate.ASN1), 
            new ASN1Explicit(0, Extensions.ASN1) 
                }) {        {
            setOptional(0);
            setOptional(4);
            setOptional(5);
            setOptional(6);
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.021 -0400", hash_original_method = "4CB52480148187F41511219623E7C6F5", hash_generated_method = "B266A86FE715DB77BECAFC66EFBD9B71")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) throws IOException {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object var591C80330FF539A9AA07A1281CDB256E_2017543974 = (new TBSCertList(
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
                    )); //DSFIXME:  CODE0008: Nested ternary operator in expression
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new TBSCertList(
                        //(values[0] == null)
                            //? 1
                            //: ASN1Integer.toIntValue(values[0])+1,
                        //(AlgorithmIdentifier) values[1],
                        //(Name) values[2],
                        //(Date) values[3],
                        //(Date) values[4],
                        //(List<RevokedCertificate>) values[5],
                        //(Extensions) values[6],
                        //in.getEncoded()
                    //);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:41.022 -0400", hash_original_method = "BCEEB1137AA809A3BAEFF0230EA2AF6E", hash_generated_method = "C3DDBE3E811DBF6AD4DC7B2BAE407E56")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            TBSCertList tbs;
            tbs = (TBSCertList) object;
            values[0] = (tbs.version > 1)
                ? ASN1Integer.fromIntValue(tbs.version - 1) : null;
            values[1] = tbs.signature;
            values[2] = tbs.issuer;
            values[3] = tbs.thisUpdate;
            values[4] = tbs.nextUpdate;
            values[5] = tbs.revokedCertificates;
            values[6] = tbs.crlExtensions;
            // ---------- Original Method ----------
            //TBSCertList tbs = (TBSCertList) object;
            //values[0] = (tbs.version > 1)
                //? ASN1Integer.fromIntValue(tbs.version - 1) : null;
            //values[1] = tbs.signature;
            //values[2] = tbs.issuer;
            //values[3] = tbs.thisUpdate;
            //values[4] = tbs.nextUpdate;
            //values[5] = tbs.revokedCertificates;
            //values[6] = tbs.crlExtensions;
        }

        
}; //Transformed anonymous class
}

