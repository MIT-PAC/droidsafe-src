package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigInteger;

import javax.security.auth.x500.X500Principal;

import org.apache.harmony.security.asn1.ASN1BitString;
import org.apache.harmony.security.asn1.ASN1Explicit;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.asn1.BitString;
import org.apache.harmony.security.x501.Name;

public final class TBSCertificate {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:29.941 -0400", hash_original_field = "D7092AE3833E81A8348A8B7AF5B1AF9D", hash_generated_field = "6BC34EFC4439CF1F892B81CC2E73528B")

    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Explicit(0, ASN1Integer.getInstance()), ASN1Integer.getInstance(),
            AlgorithmIdentifier.ASN1, Name.ASN1,
            Validity.ASN1, Name.ASN1, SubjectPublicKeyInfo.ASN1,
            new ASN1Implicit(1, ASN1BitString.getInstance()),
            new ASN1Implicit(2, ASN1BitString.getInstance()),
            new ASN1Explicit(3, Extensions.ASN1)}) {
        {
            setDefault(new byte[] {0}, 0);
            setOptional(7);
            setOptional(8);
            setOptional(9);
        }

        @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.329 -0500", hash_original_method = "2B63D5268C80057DA518CE721B3C7CAE", hash_generated_method = "60B40A908E0C9ACD0F43DBD08FEF9097")
        
@Override protected Object getDecodedObject(BerInputStream in) {
            Object[] values = (Object[]) in.content;

            boolean[] issuerUniqueID = (values[7] == null)
                ? null : ((BitString) values[7]).toBooleanArray();
            boolean[] subjectUniqueID = (values[8] == null)
                ? null : ((BitString) values[8]).toBooleanArray();
            return new TBSCertificate(
                        ASN1Integer.toIntValue(values[0]),
                        new BigInteger((byte[]) values[1]),
                        (AlgorithmIdentifier) values[2],
                        (Name) values[3],
                        (Validity) values[4],
                        (Name) values[5],
                        (SubjectPublicKeyInfo) values[6],
                        issuerUniqueID,
                        subjectUniqueID,
                        (Extensions) values[9],
                        in.getEncoded()
                    );
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.333 -0500", hash_original_method = "C1C35476C2800076B6124D588171C03C", hash_generated_method = "056C99C2E16B8B27DECBB6779E16F7C2")
        
@Override protected void getValues(Object object, Object[] values) {
            TBSCertificate tbs = (TBSCertificate) object;
            values[0] = ASN1Integer.fromIntValue(tbs.version);
            values[1] = tbs.serialNumber.toByteArray();
            values[2] = tbs.signature;
            values[3] = tbs.issuer;
            values[4] = tbs.validity;
            values[5] = tbs.subject;
            values[6] = tbs.subjectPublicKeyInfo;
            if (tbs.issuerUniqueID != null) {
                values[7] = new BitString(tbs.issuerUniqueID);
            }
            if (tbs.subjectUniqueID != null) {
                values[8] = new BitString(tbs.subjectUniqueID);
            }
            values[9] = tbs.extensions;
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.267 -0500", hash_original_field = "971D53A5DDB5A515B8A18CE48C276387", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private  int version;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.270 -0500", hash_original_field = "357D34BE4D3F218CD8ADF717DBF7DD40", hash_generated_field = "8556E85255DE7EB3D2D59484E44C2BAC")

    private  BigInteger serialNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.273 -0500", hash_original_field = "A9C2427A585DE5C2846E517FA208C326", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private  AlgorithmIdentifier signature;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.275 -0500", hash_original_field = "C90BB51A367193960587715FDC0130BB", hash_generated_field = "808E5C397094457CB3293C5FE4742B51")

    private  Name issuer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.277 -0500", hash_original_field = "8AFCD21E0A82A716F39232B6F350DECB", hash_generated_field = "305CCE6F0AC56AE0B0EDFA664E896137")

    private  Validity validity;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.280 -0500", hash_original_field = "62128280F9439E84A11C8FD57836730A", hash_generated_field = "74A60B29582F19500BDD9E22B68B11F7")

    private  Name subject;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.282 -0500", hash_original_field = "B0B8278CF79DE1BD38516FAC424CAD16", hash_generated_field = "FFF504BB80D284CF6640975B8E382935")

    private  SubjectPublicKeyInfo subjectPublicKeyInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.284 -0500", hash_original_field = "5EEA18A90E8BCB9086637EC9E90854A7", hash_generated_field = "E32CA2DEAA17CDCC07F9B0FED2922F75")

    private  boolean[] issuerUniqueID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.287 -0500", hash_original_field = "F05230013E43A20CE8FCBD8A049DC5B4", hash_generated_field = "F9C5B6387DCF7296130E24D4E5B5E04A")

    private  boolean[] subjectUniqueID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.289 -0500", hash_original_field = "11D23A9D67ECEDEBAFCBDADBAE6E0FA1", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private  Extensions extensions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.291 -0500", hash_original_field = "B36A946B5145D992E53209BC6743765D", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.294 -0500", hash_original_method = "65C275BF923474477DF3B94B95744E3C", hash_generated_method = "05D8333B8D29E90A300F65E9D9DAE56B")
    
public TBSCertificate(int version, BigInteger serialNumber,
                          AlgorithmIdentifier signature, Name issuer,
                          Validity validity, Name subject,
                          SubjectPublicKeyInfo subjectPublicKeyInfo,
                          boolean[] issuerUniqueID, boolean[] subjectUniqueID,
                          Extensions extensions) {
        this.version = version;
        this.serialNumber = serialNumber;
        this.signature = signature;
        this.issuer = issuer;
        this.validity = validity;
        this.subject = subject;
        this.subjectPublicKeyInfo = subjectPublicKeyInfo;
        this.issuerUniqueID = issuerUniqueID;
        this.subjectUniqueID = subjectUniqueID;
        this.extensions = extensions;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.297 -0500", hash_original_method = "A222BEBABFC582354A181FFF7432BD39", hash_generated_method = "9B55C44062FA5F2C6983C28BB4BD114C")
    
private TBSCertificate(int version, BigInteger serialNumber,
                          AlgorithmIdentifier signature, Name issuer,
                          Validity validity, Name subject,
                          SubjectPublicKeyInfo subjectPublicKeyInfo,
                          boolean[] issuerUniqueID, boolean[] subjectUniqueID,
                          Extensions extensions, byte[] encoding) {
        this(version, serialNumber, signature, issuer, validity, subject,
             subjectPublicKeyInfo, issuerUniqueID, subjectUniqueID, extensions);
        this.encoding = encoding;
    }

    /**
     * Returns the value of version field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.299 -0500", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "0A6C4E4591BB9051C220BECC5445085D")
    
public int getVersion() {
        return version;
    }

    /**
     * Returns the value of serialNumber field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.302 -0500", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "207C06B8E3C7AEAA1442B3B5D400DFA7")
    
public BigInteger getSerialNumber() {
        return serialNumber;
    }

    /**
     * Returns the value of signature field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.305 -0500", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "8983DBF8FD7CF97E2F3DB5F36F4DEF72")
    
public AlgorithmIdentifier getSignature() {
        return signature;
    }

    /**
     * Returns the value of issuer field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.307 -0500", hash_original_method = "EBC299B5141657B108909E991892F54F", hash_generated_method = "F7EB58F964146EE4A9CA8F4132036285")
    
public Name getIssuer() {
        return issuer;
    }

    /**
     * Returns the value of validity field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.309 -0500", hash_original_method = "DAA501F00A793FDF912D8039C0483525", hash_generated_method = "0599A08D77F1A899D8345F9E4B253FCA")
    
public Validity getValidity() {
        return validity;
    }

    /**
     * Returns the value of subject field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.311 -0500", hash_original_method = "01CA74A643B409E53785F17175CB2AB2", hash_generated_method = "7037021A45CF98F236A339130B97E1E4")
    
public Name getSubject() {
        return subject;
    }

    /**
     * Returns the value of subjectPublicKeyInfo field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.313 -0500", hash_original_method = "EE5B5FDD20BC2C4F67CD8D0C39F17B3D", hash_generated_method = "481470C7D7406472BB4A98FC1A53DE7B")
    
public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return subjectPublicKeyInfo;
    }

    /**
     * Returns the value of issuerUniqueID field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.315 -0500", hash_original_method = "FFD3B59B457ECE2F283DE7A5AE2A1843", hash_generated_method = "DC60E3C07DD890B7189FCC8BFC8A6354")
    
public boolean[] getIssuerUniqueID() {
        return issuerUniqueID;
    }

    /**
     * Returns the value of subjectUniqueID field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.318 -0500", hash_original_method = "7A561CAD271B493C1384E3B2691AA579", hash_generated_method = "1D2B632D191FB4F7DED88CD40620BB6A")
    
public boolean[] getSubjectUniqueID() {
        return subjectUniqueID;
    }

    /**
     * Returns the value of extensions field of the structure.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.320 -0500", hash_original_method = "160E3DAB15A775FB370B26EA87125324", hash_generated_method = "AC0E4A307C58CB40EC876A42E8BF125F")
    
public Extensions getExtensions() {
        return extensions;
    }

    /**
     * Returns ASN.1 encoded form of this X.509 TBSCertificate value.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.322 -0500", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "5349B65E746CD014BDA35ADFF927FD5B")
    
public byte[] getEncoded() {
        if (encoding == null) {
            encoding = ASN1.encode(this);
        }
        return encoding;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:00:56.325 -0500", hash_original_method = "20BC4358EC88862A49105AF5BBCC5ECB", hash_generated_method = "9E9A44C75B538FF763D0750FB902A026")
    
public void dumpValue(StringBuilder sb) {
        sb.append('[');
        sb.append("\n  Version: V").append(version+1);
        sb.append("\n  Subject: ").append(subject.getName(X500Principal.RFC2253));
        sb.append("\n  Signature Algorithm: ");
        signature.dumpValue(sb);
        sb.append("\n  Key: ").append(subjectPublicKeyInfo.getPublicKey().toString());
        sb.append("\n  Validity: [From: ").append(validity.getNotBefore());
        sb.append("\n               To: ").append(validity.getNotAfter()).append(']');
        sb.append("\n  Issuer: ").append(issuer.getName(X500Principal.RFC2253));
        sb.append("\n  Serial Number: ").append(serialNumber);
        if (issuerUniqueID != null) {
            sb.append("\n  Issuer Id: ");
            for (boolean b : issuerUniqueID) {
                sb.append(b ? '1' : '0');
            }
        }
        if (subjectUniqueID != null) {
            sb.append("\n  Subject Id: ");
            for (boolean b : subjectUniqueID) {
                sb.append(b ? '1' : '0');
            }
        }
        if (extensions != null) {
            sb.append("\n\n  Extensions: ");
            sb.append("[\n");
            extensions.dumpValue(sb, "    ");
            sb.append("  ]");
        }
        sb.append("\n]");
    }
}

