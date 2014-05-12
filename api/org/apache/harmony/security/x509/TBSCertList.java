package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
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
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.902 -0400", hash_original_field = "B99D8A08CC5C7677C59256AABCDC0E22", hash_generated_field = "49D719EDF57E2338F15D6AF8FC0620BA")

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

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.753 -0500", hash_original_method = "4CB52480148187F41511219623E7C6F5", hash_generated_method = "65DC9EEE6AB515127FFFE0747DB533FA")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.757 -0500", hash_original_method = "BCEEB1137AA809A3BAEFF0230EA2AF6E", hash_generated_method = "AB1B6FF6CA39AAFEB57DDE844E494F38")
        
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.655 -0500", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private  int version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.657 -0500", hash_original_field = "A9C2427A585DE5C2846E517FA208C326", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private  AlgorithmIdentifier signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.659 -0500", hash_original_field = "C90BB51A367193960587715FDC0130BB", hash_generated_field = "808E5C397094457CB3293C5FE4742B51")

    private  Name issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.661 -0500", hash_original_field = "57C884CBC6EB0B2370464E5180782C58", hash_generated_field = "5BCDC1C4FBE338293679F38DE361C5F5")

    private  Date thisUpdate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.664 -0500", hash_original_field = "9117254ED97B34C1487762CADADE6893", hash_generated_field = "542D8C0DA2CA3396EC1AD3CB8CEFD869")

    private  Date nextUpdate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.667 -0500", hash_original_field = "B88C8B04818E3AC0F97AD7A86B06ACE6", hash_generated_field = "499B2E318C3D5C046C3561190ADE17E9")

    private  List<RevokedCertificate> revokedCertificates;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.670 -0500", hash_original_field = "DDCECEC12E74305CB0FBCEB670343070", hash_generated_field = "B31D18D3B9FA4394AC83C1ED391E4A68")

    private  Extensions crlExtensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.672 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    /** Constructs the object with associated ASN.1 encoding */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.724 -0500", hash_original_method = "31062813EF8734E09BA3D189CC3AAF0B", hash_generated_method = "9C313AB700168328343E482F4B2D2542")
    
private TBSCertList(int version, AlgorithmIdentifier signature,
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

    /**
     * Returns the value of version field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.726 -0500", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    
public int getVersion() {
        return version;
    }

    /**
     * Returns the value of signature field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.729 -0500", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "8983DBF8FD7CF97E2F3DB5F36F4DEF72")
    
public AlgorithmIdentifier getSignature() {
        return signature;
    }

    /**
     * Returns the value of issuer field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.731 -0500", hash_original_method = "EBC299B5141657B108909E991892F54F", hash_generated_method = "F7EB58F964146EE4A9CA8F4132036285")
    
public Name getIssuer() {
        return issuer;
    }

    /**
     * Returns the value of thisUpdate field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.733 -0500", hash_original_method = "3F952D48E5C3F549E0CF72E297E1768F", hash_generated_method = "1053BFE347B5CFC1BE2FF0B4CC330728")
    
public Date getThisUpdate() {
        return thisUpdate;
    }

    /**
     * Returns the value of nextUpdate field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.735 -0500", hash_original_method = "F86AAF1D9B4DCB96185947A392CE29B0", hash_generated_method = "8EF2916DDD649B4F1DFF7C02C2674301")
    
public Date getNextUpdate() {
        return nextUpdate;
    }

    /**
     * Returns the value of revokedCertificates field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.737 -0500", hash_original_method = "6BD535137A0D7C6092BE90399C5AC4FA", hash_generated_method = "1096C09891762694EB90B4F4773A1B9C")
    
public List<RevokedCertificate> getRevokedCertificates() {
        return revokedCertificates;
    }

    /**
     * Returns the value of crlExtensions field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.739 -0500", hash_original_method = "24898D069ADDF2B72D4CC75EC979A933", hash_generated_method = "9A36BF4F3DDD7564B5B684465C6CD3F8")
    
public Extensions getCrlExtensions() {
        return crlExtensions;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 TBSCertList value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.742 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.745 -0500", hash_original_method = "44BD020D05A989BAC123F5B223D6D101", hash_generated_method = "4CAD0568A5417F3827CDCF765C018E7A")
    
@Override public boolean equals(Object other) {
        if (!(other instanceof TBSCertList)) {
            return false;
        }
        TBSCertList that = (TBSCertList) other;
        return version == that.version
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
                    : crlExtensions.equals(that.crlExtensions));
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.747 -0500", hash_original_method = "78A1F0B8BEA4B34BD8F201B7131E5881", hash_generated_method = "9DF2A765FD498DE607604BC6BA8B7400")
    
@Override public int hashCode() {
        return ((version * 37 + signature.hashCode()) * 37
                + Arrays.hashCode(issuer.getEncoded())) * 37
                + (int)thisUpdate.getTime() / 1000;
    }
    
    public static class RevokedCertificate {
        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.901 -0400", hash_original_field = "0EB062719792FA91CCD2C8AAE392BE5A", hash_generated_field = "82E33EB05B176947C86ABB8EA99FD282")

        public static final ASN1Sequence ASN1 = new ASN1Sequence(
                new ASN1Type[] {ASN1Integer.getInstance(), Time.ASN1,
                Extensions.ASN1}) {
            {
                setOptional(2);
            }

            @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.713 -0500", hash_original_method = "4BFBD5E87B68F249B53912C5A95A2356", hash_generated_method = "CDE79C389EF9D3528526BD3FCC32A22F")
            
@Override protected Object getDecodedObject(BerInputStream in) {
                Object[] values = (Object[]) in.content;
                return new RevokedCertificate(
                            new BigInteger((byte[]) values[0]),
                            (Date) values[1],
                            (Extensions) values[2]
                        );
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.717 -0500", hash_original_method = "1CE4AE8DA5650BCD680F10838448489A", hash_generated_method = "45F0936C41DC743DBF2B2982267B5B5B")
            
@Override protected void getValues(Object object, Object[] values) {
                RevokedCertificate rcert = (RevokedCertificate) object;
                values[0] = rcert.userCertificate.toByteArray();
                values[1] = rcert.revocationDate;
                values[2] = rcert.crlEntryExtensions;
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.675 -0500", hash_original_field = "84C6206B52AE12479D04EFFD5C91DA16", hash_generated_field = "BA3F88CA120743D40A7FAC017674A8A6")

        private  BigInteger userCertificate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.677 -0500", hash_original_field = "DD6243CFC5C36CEF9A7B0CE4BFC2EF71", hash_generated_field = "98BEBEA22AD2549C5C220A56BC4B5B48")

        private  Date revocationDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.680 -0500", hash_original_field = "B8519E04BD3A7911F8D3328C9A564E70", hash_generated_field = "2B758F6EC9C6C53EA4A9263CD866DCCF")

        private  Extensions crlEntryExtensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.682 -0500", hash_original_field = "7C212B2DE2D213C16F5E7E302DB7A9AD", hash_generated_field = "99CCA543CBC7A8739D82292112850772")

        private boolean issuerRetrieved;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.684 -0500", hash_original_field = "99BE4463DA67376AA94F7D97DDB8D7FF", hash_generated_field = "30FEA84FB35EF28DB029D29044BA91EC")

        private X500Principal issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.687 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

        private byte[] encoding;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.689 -0500", hash_original_method = "5F12FE515CE9F47CBF71064D9DB4557F", hash_generated_method = "61497A301AD0C3D803B38AB3E276AB3D")
        
public RevokedCertificate(BigInteger userCertificate,
                Date revocationDate, Extensions crlEntryExtensions) {
            this.userCertificate = userCertificate;
            this.revocationDate = revocationDate;
            this.crlEntryExtensions = crlEntryExtensions;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.692 -0500", hash_original_method = "235B3774752183ABFC67FCFEA882E536", hash_generated_method = "E97581963AB4C23AA46D49F00F863D28")
        
public Extensions getCrlEntryExtensions() {
            return crlEntryExtensions;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.694 -0500", hash_original_method = "95F3FA234A9F19C0F47C92249F7AFDCC", hash_generated_method = "B0C170F3DE50B654A431FB57711AA78E")
        
public BigInteger getUserCertificate() {
            return userCertificate;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.697 -0500", hash_original_method = "0C5E7D843026F709B3652BD32A196980", hash_generated_method = "6219B0A2F8FC49FBB88B4F220F69CBE0")
        
public Date getRevocationDate() {
            return revocationDate;
        }

        /**
         * Returns the value of Certificate Issuer Extension, if it is
         * presented.
         */
        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.699 -0500", hash_original_method = "CDE119A341F8D25B9AE6819B0711631F", hash_generated_method = "18505ECB9BD225B125A5B43CEC20B6D4")
        
public X500Principal getIssuer() {
            if (crlEntryExtensions == null) {
                return null;
            }
            if (!issuerRetrieved) {
                try {
                    issuer =
                        crlEntryExtensions.valueOfCertificateIssuerExtension();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                issuerRetrieved = true;
            }
            return issuer;
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.701 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
        
public byte[] getEncoded() {
            if (encoding == null) {
                encoding = ASN1.encode(this);
            }
            return encoding;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.704 -0500", hash_original_method = "E8EF795929F81DA5391DEE3D693BAF7B", hash_generated_method = "0E1DAB5C94C2AE9FD0379E9D2A0023FB")
        
public boolean equals(Object rc) {
            if (!(rc instanceof RevokedCertificate)) {
                return false;
            }
            RevokedCertificate rcert = (RevokedCertificate) rc;
            return userCertificate.equals(rcert.userCertificate)
                && ((revocationDate.getTime() / 1000)
                        == (rcert.revocationDate.getTime() / 1000))
                && ((crlEntryExtensions == null)
                    ? rcert.crlEntryExtensions == null
                    : crlEntryExtensions.equals(rcert.crlEntryExtensions));
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.706 -0500", hash_original_method = "524410A369A93135245C5EB9BC27F7C2", hash_generated_method = "99874272C1C1B046B94CF7FF7EF81C81")
        
public int hashCode() {
            return userCertificate.hashCode() * 37 + (int)revocationDate.getTime() / 1000
                    + (crlEntryExtensions == null ? 0 : crlEntryExtensions.hashCode());
        }

        @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.708 -0500", hash_original_method = "8F642BB50419022F85F1FC1824E6E317", hash_generated_method = "F3195D59C0687FF6BB3C4DA0D0973407")
        
public void dumpValue(StringBuilder sb, String prefix) {
            sb.append(prefix).append("Certificate Serial Number: ").append(userCertificate).append('\n');
            sb.append(prefix).append("Revocation Date: ").append(revocationDate);
            if (crlEntryExtensions != null) {
                sb.append('\n').append(prefix).append("CRL Entry Extensions: [");
                crlEntryExtensions.dumpValue(sb, prefix + "  ");
                sb.append(prefix).append(']');
            }
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:00.750 -0500", hash_original_method = "8372CF0910098C0215CEE031DBAAD799", hash_generated_method = "C425C90333443B6081176932CF3A0F4D")
    
public void dumpValue(StringBuilder sb) {
        sb.append("X.509 CRL v").append(version);
        sb.append("\nSignature Algorithm: [");
        signature.dumpValue(sb);
        sb.append(']');
        sb.append("\nIssuer: ").append(issuer.getName(X500Principal.RFC2253));
        sb.append("\n\nThis Update: ").append(thisUpdate);
        sb.append("\nNext Update: ").append(nextUpdate).append('\n');
        if (revokedCertificates != null) {
            sb.append("\nRevoked Certificates: ").append(revokedCertificates.size()).append(" [");
            int number = 1;
            for (RevokedCertificate revokedCertificate : revokedCertificates) {
                sb.append("\n  [").append(number++).append(']');
                revokedCertificate.dumpValue(sb, "  ");
                sb.append('\n');
            }
            sb.append("]\n");
        }
        if (crlExtensions != null) {
            sb.append("\nCRL Extensions: ").append(crlExtensions.size()).append(" [");
            crlExtensions.dumpValue(sb, "  ");
            sb.append("]\n");
        }
    }
}

