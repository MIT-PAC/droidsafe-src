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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.233 -0400", hash_original_field = "2AF72F100C356273D46284F6FD1DFC08", hash_generated_field = "605FE2D9A0C9E94D1E2D3DAEDB658980")

    private int version;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.233 -0400", hash_original_field = "071878F85C90E53E15AAC400B22E48B5", hash_generated_field = "8556E85255DE7EB3D2D59484E44C2BAC")

    private BigInteger serialNumber;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.233 -0400", hash_original_field = "AC201FD270C3B96BEAB24F2829780AB2", hash_generated_field = "783386BC2A99F90E6BCFC976FA88180B")

    private AlgorithmIdentifier signature;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.234 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "808E5C397094457CB3293C5FE4742B51")

    private Name issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.234 -0400", hash_original_field = "3889F81B063D15C6C5AC2FA7AFC3A8EF", hash_generated_field = "305CCE6F0AC56AE0B0EDFA664E896137")

    private Validity validity;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.234 -0400", hash_original_field = "B5E3374E43F6544852F7751DFC529100", hash_generated_field = "74A60B29582F19500BDD9E22B68B11F7")

    private Name subject;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.234 -0400", hash_original_field = "EC8B3961E3C6839FC6F3EA0F5AA3F1BE", hash_generated_field = "FFF504BB80D284CF6640975B8E382935")

    private SubjectPublicKeyInfo subjectPublicKeyInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.234 -0400", hash_original_field = "0080B5239E0054A7EDCFA6529FB5BBF8", hash_generated_field = "E32CA2DEAA17CDCC07F9B0FED2922F75")

    private boolean[] issuerUniqueID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.234 -0400", hash_original_field = "3DDCCCBC1E8014C0606B1C63EBE7D4A2", hash_generated_field = "F9C5B6387DCF7296130E24D4E5B5E04A")

    private boolean[] subjectUniqueID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.234 -0400", hash_original_field = "2AC737D240FC746CEF37129B7569F08E", hash_generated_field = "85FCB044EB3BC544E06DEC3DDF20CB7B")

    private Extensions extensions;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.234 -0400", hash_original_field = "84BEA1F0FD2CE16F7E562A9F06EF03D3", hash_generated_field = "ACB189C73E1A6432570001B3B9D3D516")

    private byte[] encoding;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.235 -0400", hash_original_method = "65C275BF923474477DF3B94B95744E3C", hash_generated_method = "D32BC3034AF72749EAC9CAB5AB060502")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.235 -0400", hash_original_method = "A222BEBABFC582354A181FFF7432BD39", hash_generated_method = "89DCBB1A3DF597C0475FCEDC6BDE7AD6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.236 -0400", hash_original_method = "00A0A81AB162D0816192A8848BD6F0D6", hash_generated_method = "E8EB6CD226E75387214E008D9BACAFBE")
    public int getVersion() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1147221761 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1147221761;
        // ---------- Original Method ----------
        //return version;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.236 -0400", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "E9CB9F016DA82814C62178396A72741A")
    public BigInteger getSerialNumber() {
        BigInteger varB4EAC82CA7396A68D541C85D26508E83_1658642272 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1658642272 = serialNumber;
        varB4EAC82CA7396A68D541C85D26508E83_1658642272.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1658642272;
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.236 -0400", hash_original_method = "DD6542667BFDE70B879F723105C92A71", hash_generated_method = "D149CD4F558B04E823F3902410FC1357")
    public AlgorithmIdentifier getSignature() {
        AlgorithmIdentifier varB4EAC82CA7396A68D541C85D26508E83_69682571 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_69682571 = signature;
        varB4EAC82CA7396A68D541C85D26508E83_69682571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_69682571;
        // ---------- Original Method ----------
        //return signature;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.237 -0400", hash_original_method = "EBC299B5141657B108909E991892F54F", hash_generated_method = "DB4EB3FDC0F7AF6F531EB3D655CCC0E3")
    public Name getIssuer() {
        Name varB4EAC82CA7396A68D541C85D26508E83_535527890 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_535527890 = issuer;
        varB4EAC82CA7396A68D541C85D26508E83_535527890.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_535527890;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.237 -0400", hash_original_method = "DAA501F00A793FDF912D8039C0483525", hash_generated_method = "D6A5E49FDFD1FF894339D76F6F8A17A2")
    public Validity getValidity() {
        Validity varB4EAC82CA7396A68D541C85D26508E83_1473744823 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1473744823 = validity;
        varB4EAC82CA7396A68D541C85D26508E83_1473744823.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1473744823;
        // ---------- Original Method ----------
        //return validity;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.238 -0400", hash_original_method = "01CA74A643B409E53785F17175CB2AB2", hash_generated_method = "E465C4C3AB69DBAB891396D216D027D7")
    public Name getSubject() {
        Name varB4EAC82CA7396A68D541C85D26508E83_453948132 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_453948132 = subject;
        varB4EAC82CA7396A68D541C85D26508E83_453948132.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_453948132;
        // ---------- Original Method ----------
        //return subject;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.245 -0400", hash_original_method = "EE5B5FDD20BC2C4F67CD8D0C39F17B3D", hash_generated_method = "AE0097843338F3BAC87A2E0B7D6FA7E9")
    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        SubjectPublicKeyInfo varB4EAC82CA7396A68D541C85D26508E83_777933181 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_777933181 = subjectPublicKeyInfo;
        varB4EAC82CA7396A68D541C85D26508E83_777933181.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_777933181;
        // ---------- Original Method ----------
        //return subjectPublicKeyInfo;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.245 -0400", hash_original_method = "FFD3B59B457ECE2F283DE7A5AE2A1843", hash_generated_method = "B1165B13AE73A1CD2AD71F5ECDE399C1")
    public boolean[] getIssuerUniqueID() {
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1259220430 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1259220430;
        // ---------- Original Method ----------
        //return issuerUniqueID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.245 -0400", hash_original_method = "7A561CAD271B493C1384E3B2691AA579", hash_generated_method = "81FD0D1B41106978D51A584618F20C3B")
    public boolean[] getSubjectUniqueID() {
        boolean[] var503EB2F420079C4024483971CE5EDEA8_1931640880 = {getTaintBoolean()};
        return var503EB2F420079C4024483971CE5EDEA8_1931640880;
        // ---------- Original Method ----------
        //return subjectUniqueID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.246 -0400", hash_original_method = "160E3DAB15A775FB370B26EA87125324", hash_generated_method = "EEF1276A98C231D05A6F5EDA765765DF")
    public Extensions getExtensions() {
        Extensions varB4EAC82CA7396A68D541C85D26508E83_380968775 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_380968775 = extensions;
        varB4EAC82CA7396A68D541C85D26508E83_380968775.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_380968775;
        // ---------- Original Method ----------
        //return extensions;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.246 -0400", hash_original_method = "8CF73AB8FE0E45F61A0A453F52513BE8", hash_generated_method = "6E26FCE9B9C6A8B1A07C828B08BA0179")
    public byte[] getEncoded() {
        {
            encoding = ASN1.encode(this);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_2002134597 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_2002134597;
        // ---------- Original Method ----------
        //if (encoding == null) {
            //encoding = ASN1.encode(this);
        //}
        //return encoding;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.309 -0400", hash_original_method = "20BC4358EC88862A49105AF5BBCC5ECB", hash_generated_method = "73067555237F19E3FE40A6E0FA9D6DC1")
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:39:11.309 -0400", hash_original_field = "D7092AE3833E81A8348A8B7AF5B1AF9D", hash_generated_field = "6BC34EFC4439CF1F892B81CC2E73528B")

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

