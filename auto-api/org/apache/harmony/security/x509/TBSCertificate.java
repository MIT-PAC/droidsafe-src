package org.apache.harmony.security.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "8556E85255DE7EB3D2D59484E44C2BAC")

    private BigInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "808E5C397094457CB3293C5FE4742B51")

    private Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "3889F81B063D15C6C5AC2FA7AFC3A8EF", hash_generated_field = "305CCE6F0AC56AE0B0EDFA664E896137")

    private Validity validity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "74A60B29582F19500BDD9E22B68B11F7")

    private Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "EC8B3961E3C6839FC6F3EA0F5AA3F1BE", hash_generated_field = "FFF504BB80D284CF6640975B8E382935")

    private SubjectPublicKeyInfo subjectPublicKeyInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "0080B5239E0054A7EDCFA6529FB5BBF8", hash_generated_field = "E32CA2DEAA17CDCC07F9B0FED2922F75")

    private boolean[] issuerUniqueID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "3DDCCCBC1E8014C0606B1C63EBE7D4A2", hash_generated_field = "F9C5B6387DCF7296130E24D4E5B5E04A")

    private boolean[] subjectUniqueID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private Extensions extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.318 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.319 -0400", hash_original_method = "65C275BF923474477DF3B94B95744E3C", hash_generated_method = "D32BC3034AF72749EAC9CAB5AB060502")
    public  TBSCertificate(int version, BigInteger serialNumber,
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.331 -0400", hash_original_method = "A222BEBABFC582354A181FFF7432BD39", hash_generated_method = "89DCBB1A3DF597C0475FCEDC6BDE7AD6")
    private  TBSCertificate(int version, BigInteger serialNumber,
                          AlgorithmIdentifier signature, Name issuer,
                          Validity validity, Name subject,
                          SubjectPublicKeyInfo subjectPublicKeyInfo,
                          boolean[] issuerUniqueID, boolean[] subjectUniqueID,
                          Extensions extensions, byte[] encoding) {
        this(version, serialNumber, signature, issuer, validity, subject,
             subjectPublicKeyInfo, issuerUniqueID, subjectUniqueID, extensions);
        this.encoding = encoding;
        addTaint(version);
        addTaint(serialNumber.getTaint());
        addTaint(signature.getTaint());
        addTaint(issuer.getTaint());
        addTaint(validity.getTaint());
        addTaint(subject.getTaint());
        addTaint(subjectPublicKeyInfo.getTaint());
        addTaint(issuerUniqueID[0]);
        addTaint(subjectUniqueID[0]);
        addTaint(extensions.getTaint());
        // ---------- Original Method ----------
        //this.encoding = encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.331 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "B2D70355E77D0046B9D089E3DED41B14")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432566126 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432566126;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.332 -0400", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "C1DDA919793C03DC1E76F8FC09BA046B")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_672282411 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_672282411 = serialNumber;
        varB4EAC82CA7396A68D541C85D26508E83_672282411.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_672282411;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.333 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "B854B6680BC8BBD64D83CA6D751F35DE")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_153201220 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_153201220 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_153201220.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_153201220;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.333 -0400", hash_original_method = "EBC299B5141657B108909E991892F54F", hash_generated_method = "CACE4F18EBD7784CCAAD3F1AA483C1E9")
    public Name getIssuer() {
        Name varB4EAC82CA7396A68D541C85D26508E83_547072948 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_547072948 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_547072948.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_547072948;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.334 -0400", hash_original_method = "DAA501F00A793FDF912D8039C0483525", hash_generated_method = "87C6392368CA9095CE975734F600AE30")
    public Validity getValidity() {
        Validity varB4EAC82CA7396A68D541C85D26508E83_1348778715 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1348778715 = validity;
        varB4EAC82CA7396A68D541C85D26508E83_1348778715.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1348778715;
        // ---------- Original Method ----------
        //return validity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.345 -0400", hash_original_method = "01CA74A643B409E53785F17175CB2AB2", hash_generated_method = "95B21734204CE93D68A216A4B90F0A49")
    public Name getSubject() {
        Name varB4EAC82CA7396A68D541C85D26508E83_733329989 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_733329989 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_733329989.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_733329989;
        // ---------- Original Method ----------
        //return subject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.346 -0400", hash_original_method = "EE5B5FDD20BC2C4F67CD8D0C39F17B3D", hash_generated_method = "2546F85726B62ED87C5422A2AF3EA9A6")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        SubjectPublicKeyInfo varB4EAC82CA7396A68D541C85D26508E83_554332839 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_554332839 = subjectPublicKeyInfo;
        varB4EAC82CA7396A68D541C85D26508E83_554332839.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_554332839;
        // ---------- Original Method ----------
        //return subjectPublicKeyInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.346 -0400", hash_original_method = "FFD3B59B457ECE2F283DE7A5AE2A1843", hash_generated_method = "132517E45C2C8C4892F49E232A3E56AA")
    public boolean[] getIssuerUniqueID() {
        boolean[] var503EB2F420079C4024483971CE5EDEA8_187732807 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_187732807;
        // ---------- Original Method ----------
        //return issuerUniqueID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.346 -0400", hash_original_method = "7A561CAD271B493C1384E3B2691AA579", hash_generated_method = "DCF6EDA5285ACAACC75775A3F5686EFE")
    public boolean[] getSubjectUniqueID() {
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1602756678 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1602756678;
        // ---------- Original Method ----------
        //return subjectUniqueID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.347 -0400", hash_original_method = "160E3DAB15A775FB370B26EA87125324", hash_generated_method = "D96F24E17ABBEB052188C003A0D6FB11")
    public Extensions getExtensions() {
        Extensions varB4EAC82CA7396A68D541C85D26508E83_292852467 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_292852467 = extensions;
        varB4EAC82CA7396A68D541C85D26508E83_292852467.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_292852467;
        // ---------- Original Method ----------
        //return extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.347 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "B4EFD367DC57934F8203AAEA8EBFF17D")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1067680890 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1067680890;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.390 -0400", hash_original_method = "20BC4358EC88862A49105AF5BBCC5ECB", hash_generated_method = "73067555237F19E3FE40A6E0FA9D6DC1")
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
        addTaint(sb.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:10.391 -0400", hash_original_field = "D7092AE3833E81A8348A8B7AF5B1AF9D", hash_generated_field = "6BC34EFC4439CF1F892B81CC2E73528B")

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
}

