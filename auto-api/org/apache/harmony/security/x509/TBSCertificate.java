package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

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
    private final int version;
    private final BigInteger serialNumber;
    private final AlgorithmIdentifier signature;
    private final Name issuer;
    private final Validity validity;
    private final Name subject;
    private final SubjectPublicKeyInfo subjectPublicKeyInfo;
    private final boolean[] issuerUniqueID;
    private final boolean[] subjectUniqueID;
    private final Extensions extensions;
    private byte[] encoding;
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
            new ASN1Explicit(0, ASN1Integer.getInstance()), ASN1Integer.getInstance(),
            AlgorithmIdentifier.ASN1, Name.ASN1,
            Validity.ASN1, Name.ASN1, SubjectPublicKeyInfo.ASN1,
            new ASN1Implicit(1, ASN1BitString.getInstance()),
            new ASN1Implicit(2, ASN1BitString.getInstance()),
            new ASN1Explicit(3, Extensions.ASN1)}) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.936 -0400", hash_original_method = "2B63D5268C80057DA518CE721B3C7CAE", hash_generated_method = "E5EA8EC3B37696E6E70AF1C1A97EDC08")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            boolean[] issuerUniqueID;
            issuerUniqueID = null;
            issuerUniqueID = ((BitString) values[7]).toBooleanArray();
            boolean[] subjectUniqueID;
            subjectUniqueID = null;
            subjectUniqueID = ((BitString) values[8]).toBooleanArray();
            Object var2547009DC4EEC77CF8A5281C93F19210_1424567057 = (new TBSCertificate(
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
                    ));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.936 -0400", hash_original_method = "C1C35476C2800076B6124D588171C03C", hash_generated_method = "DE7CA9E66D22FD9B93E2B257864F3206")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values.dsTaint);
            dsTaint.addTaint(object.dsTaint);
            TBSCertificate tbs;
            tbs = (TBSCertificate) object;
            values[0] = ASN1Integer.fromIntValue(tbs.version);
            values[1] = tbs.serialNumber.toByteArray();
            values[2] = tbs.signature;
            values[3] = tbs.issuer;
            values[4] = tbs.validity;
            values[5] = tbs.subject;
            values[6] = tbs.subjectPublicKeyInfo;
            {
                values[7] = new BitString(tbs.issuerUniqueID);
            } //End block
            {
                values[8] = new BitString(tbs.subjectUniqueID);
            } //End block
            values[9] = tbs.extensions;
            // ---------- Original Method ----------
            //TBSCertificate tbs = (TBSCertificate) object;
            //values[0] = ASN1Integer.fromIntValue(tbs.version);
            //values[1] = tbs.serialNumber.toByteArray();
            //values[2] = tbs.signature;
            //values[3] = tbs.issuer;
            //values[4] = tbs.validity;
            //values[5] = tbs.subject;
            //values[6] = tbs.subjectPublicKeyInfo;
            //if (tbs.issuerUniqueID != null) {
                //values[7] = new BitString(tbs.issuerUniqueID);
            //}
            //if (tbs.subjectUniqueID != null) {
                //values[8] = new BitString(tbs.subjectUniqueID);
            //}
            //values[9] = tbs.extensions;
        }

        
        static {
            setDefault(new byte[] {0}, 0);
            setOptional(7);
            setOptional(8);
            setOptional(9);
        }
        
}; //Transformed anonymous class
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "65C275BF923474477DF3B94B95744E3C", hash_generated_method = "6B95933688D6DF5FF7CFD6EA6FAE87BE")
    @DSModeled(DSC.SAFE)
    public TBSCertificate(int version, BigInteger serialNumber,
                          AlgorithmIdentifier signature, Name issuer,
                          Validity validity, Name subject,
                          SubjectPublicKeyInfo subjectPublicKeyInfo,
                          boolean[] issuerUniqueID, boolean[] subjectUniqueID,
                          Extensions extensions) {
        dsTaint.addTaint(subjectPublicKeyInfo.dsTaint);
        dsTaint.addTaint(subjectUniqueID);
        dsTaint.addTaint(issuer.dsTaint);
        dsTaint.addTaint(issuerUniqueID);
        dsTaint.addTaint(validity.dsTaint);
        dsTaint.addTaint(subject.dsTaint);
        dsTaint.addTaint(serialNumber.dsTaint);
        dsTaint.addTaint(extensions.dsTaint);
        dsTaint.addTaint(signature.dsTaint);
        dsTaint.addTaint(version);
        // ---------- Original Method ----------
        //this.version = version;
        //this.serialNumber = serialNumber;
        //this.signature = signature;
        //this.issuer = issuer;
        //this.validity = validity;
        //this.subject = subject;
        //this.subjectPublicKeyInfo = subjectPublicKeyInfo;
        //this.issuerUniqueID = issuerUniqueID;
        //this.subjectUniqueID = subjectUniqueID;
        //this.extensions = extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "A222BEBABFC582354A181FFF7432BD39", hash_generated_method = "F04D4597FC0C811F80D39CC9F99D9E4D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private TBSCertificate(int version, BigInteger serialNumber,
                          AlgorithmIdentifier signature, Name issuer,
                          Validity validity, Name subject,
                          SubjectPublicKeyInfo subjectPublicKeyInfo,
                          boolean[] issuerUniqueID, boolean[] subjectUniqueID,
                          Extensions extensions, byte[] encoding) {
        this(version, serialNumber, signature, issuer, validity, subject,
             subjectPublicKeyInfo, issuerUniqueID, subjectUniqueID, extensions);
        dsTaint.addTaint(subjectPublicKeyInfo.dsTaint);
        dsTaint.addTaint(subjectUniqueID);
        dsTaint.addTaint(issuer.dsTaint);
        dsTaint.addTaint(issuerUniqueID);
        dsTaint.addTaint(validity.dsTaint);
        dsTaint.addTaint(subject.dsTaint);
        dsTaint.addTaint(encoding);
        dsTaint.addTaint(serialNumber.dsTaint);
        dsTaint.addTaint(extensions.dsTaint);
        dsTaint.addTaint(signature.dsTaint);
        dsTaint.addTaint(version);
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "93B33FB42B073B0DE6AED2AEFC59BFD5")
    @DSModeled(DSC.SAFE)
    public int getVersion() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "0F646FD3F492F751E0878590CBC02F24")
    @DSModeled(DSC.SAFE)
    public BigInteger getSerialNumber() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "55E85844ED01884D9890A3A457B78E4B")
    @DSModeled(DSC.SAFE)
    public AlgorithmIdentifier getSignature() {
        return (AlgorithmIdentifier)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "EBC299B5141657B108909E991892F54F", hash_generated_method = "0BA93454B79B9161AC90F46DAF830E9D")
    @DSModeled(DSC.SAFE)
    public Name getIssuer() {
        return (Name)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "DAA501F00A793FDF912D8039C0483525", hash_generated_method = "F2E7B5A7EC852C6A7C3221F302525E69")
    @DSModeled(DSC.SAFE)
    public Validity getValidity() {
        return (Validity)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return validity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "01CA74A643B409E53785F17175CB2AB2", hash_generated_method = "F13356E2C0127EB0F85596350825FBB5")
    @DSModeled(DSC.SAFE)
    public Name getSubject() {
        return (Name)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return subject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "EE5B5FDD20BC2C4F67CD8D0C39F17B3D", hash_generated_method = "B9286906F48B4B4C5AA131EFE2216A68")
    @DSModeled(DSC.SAFE)
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return (SubjectPublicKeyInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return subjectPublicKeyInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "FFD3B59B457ECE2F283DE7A5AE2A1843", hash_generated_method = "9AABC636329781C236C1336331964159")
    @DSModeled(DSC.SAFE)
    public boolean[] getIssuerUniqueID() {
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //return issuerUniqueID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "7A561CAD271B493C1384E3B2691AA579", hash_generated_method = "EC1E21A8E310CB380E50F7FECB4E7E57")
    @DSModeled(DSC.SAFE)
    public boolean[] getSubjectUniqueID() {
        boolean[] retVal = new boolean[1];
        retVal[0] = dsTaint.getTaintBoolean();
        return retVal;
        // ---------- Original Method ----------
        //return subjectUniqueID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "160E3DAB15A775FB370B26EA87125324", hash_generated_method = "4872B1AEA997777BBB12D9775B597102")
    @DSModeled(DSC.SAFE)
    public Extensions getExtensions() {
        return (Extensions)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "789A9934736C48653FD65A6445A80FAF")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:17.937 -0400", hash_original_method = "20BC4358EC88862A49105AF5BBCC5ECB", hash_generated_method = "CD5769C0CFC10D3E5992D9D7520B7144")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dumpValue(StringBuilder sb) {
        dsTaint.addTaint(sb.dsTaint);
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
        {
            sb.append("\n  Issuer Id: ");
            {
                boolean b = issuerUniqueID[0];
                {
                    sb.append(b ? '1' : '0');
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            sb.append("\n  Subject Id: ");
            {
                boolean b = subjectUniqueID[0];
                {
                    sb.append(b ? '1' : '0');
                } //End block
            } //End collapsed parenthetic
        } //End block
        {
            sb.append("\n\n  Extensions: ");
            sb.append("[\n");
            extensions.dumpValue(sb, "    ");
            sb.append("  ]");
        } //End block
        sb.append("\n]");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
}


