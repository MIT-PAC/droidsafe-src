package org.apache.harmony.security.pkcs7;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import javax.security.auth.x500.X500Principal;
import org.apache.harmony.security.asn1.ASN1Implicit;
import org.apache.harmony.security.asn1.ASN1Integer;
import org.apache.harmony.security.asn1.ASN1OctetString;
import org.apache.harmony.security.asn1.ASN1Sequence;
import org.apache.harmony.security.asn1.ASN1SetOf;
import org.apache.harmony.security.asn1.ASN1Type;
import org.apache.harmony.security.asn1.BerInputStream;
import org.apache.harmony.security.x501.AttributeTypeAndValue;
import org.apache.harmony.security.x501.Name;
import org.apache.harmony.security.x509.AlgorithmIdentifier;

public final class SignerInfo {
    private int version;
    private X500Principal issuer;
    private BigInteger serialNumber;
    private AlgorithmIdentifier digestAlgorithm;
    private AuthenticatedAttributes authenticatedAttributes;
    private AlgorithmIdentifier digestEncryptionAlgorithm;
    private byte[] encryptedDigest;
    private List<?> unauthenticatedAttributes;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.188 -0400", hash_original_method = "27DB92A863E4BE605C04757E557D0CAB", hash_generated_method = "FEC0CB03BD731C8EF65D9A02746E23D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private SignerInfo(int version,
            Object[] issuerAndSerialNumber,
            AlgorithmIdentifier digestAlgorithm,
            AuthenticatedAttributes authenticatedAttributes,
            AlgorithmIdentifier digestEncryptionAlgorithm,
            byte[] encryptedDigest,
            List<?> unauthenticatedAttributes) {
        dsTaint.addTaint(unauthenticatedAttributes.dsTaint);
        dsTaint.addTaint(digestEncryptionAlgorithm.dsTaint);
        dsTaint.addTaint(authenticatedAttributes.dsTaint);
        dsTaint.addTaint(encryptedDigest[0]);
        dsTaint.addTaint(digestAlgorithm.dsTaint);
        dsTaint.addTaint(issuerAndSerialNumber[0].dsTaint);
        dsTaint.addTaint(version);
        this.issuer = ((Name)issuerAndSerialNumber[0]).getX500Principal();
        this.serialNumber = ASN1Integer.toBigIntegerValue(issuerAndSerialNumber[1]);
        // ---------- Original Method ----------
        //this.version = version;
        //this.issuer = ((Name)issuerAndSerialNumber[0]).getX500Principal();
        //this.serialNumber = ASN1Integer.toBigIntegerValue(issuerAndSerialNumber[1]);
        //this.digestAlgorithm = digestAlgorithm;
        //this.authenticatedAttributes = authenticatedAttributes;
        //this.digestEncryptionAlgorithm = digestEncryptionAlgorithm;
        //this.encryptedDigest = encryptedDigest;
        //this.unauthenticatedAttributes = unauthenticatedAttributes;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.214 -0400", hash_original_method = "4521AB691538FE3E0581DA96E2D306DA", hash_generated_method = "772FA8446FAE2420A4CF1798E92AD70C")
    @DSModeled(DSC.SAFE)
    public X500Principal getIssuer() {
        return (X500Principal)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.215 -0400", hash_original_method = "9420C2CEA2A6F47D515C0AB0605412CD", hash_generated_method = "7DCEC9E3A3B46B60FD0C19429AF904E7")
    @DSModeled(DSC.SAFE)
    public BigInteger getSerialNumber() {
        return (BigInteger)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return serialNumber;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.215 -0400", hash_original_method = "E49EED34625AA0C2EE5919DE429AB631", hash_generated_method = "E61F2476600D4BD85BC7460B87296134")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDigestAlgorithm() {
        String varE3AD79C39F49C8029214D5526356F5DD_175573913 = (digestAlgorithm.getAlgorithm());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return digestAlgorithm.getAlgorithm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.215 -0400", hash_original_method = "C6CE7835E1C3757C7439121AECC2E59C", hash_generated_method = "5CD735CAAB0C145CA523D04EEDB165AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getDigestEncryptionAlgorithm() {
        String var85D474914B1056CC83F5ABB3E54DF103_623922948 = (digestEncryptionAlgorithm.getAlgorithm());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return digestEncryptionAlgorithm.getAlgorithm();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.215 -0400", hash_original_method = "AEBE4A58A31E26ADF89831B320BDD2E7", hash_generated_method = "0656ACF770538C2E8EAF25D1FC0578CF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<AttributeTypeAndValue> getAuthenticatedAttributes() {
        List<AttributeTypeAndValue> varEF04F2978012B7CC5DDB894E31958EC8_1801964149 = (authenticatedAttributes.getAttributes());
        return (List<AttributeTypeAndValue>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (authenticatedAttributes == null) {
            //return null;
        //}
        //return authenticatedAttributes.getAttributes();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.215 -0400", hash_original_method = "807A0AFC068DD73DE0C4C3C2177CA7D2", hash_generated_method = "E02A55C9CC10C5945E88D46E73FB4969")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getEncodedAuthenticatedAttributes() {
        byte[] varA8038B53264A40706041C0C5ED41E28E_1473798816 = (authenticatedAttributes.getEncoded());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //if (authenticatedAttributes == null) {
            //return null;
        //}
        //return authenticatedAttributes.getEncoded();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.216 -0400", hash_original_method = "14A08E1AF72E02B64CEDF5DA67544611", hash_generated_method = "6BBE8AF655D701B074DC91FB298713FE")
    @DSModeled(DSC.SAFE)
    public byte[] getEncryptedDigest() {
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return encryptedDigest;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.216 -0400", hash_original_method = "1FB56313E7A9E641FD4CA0515EC1DCD9", hash_generated_method = "5E66BFDF0A59A1C2CBD87EDCB97E4769")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        StringBuilder res;
        res = new StringBuilder();
        res.append("-- SignerInfo:");
        res.append("\n version : ");
        res.append(version);
        res.append("\nissuerAndSerialNumber:  ");
        res.append(issuer);
        res.append("   ");
        res.append(serialNumber);
        res.append("\ndigestAlgorithm:  ");
        res.append(digestAlgorithm.toString());
        res.append("\nauthenticatedAttributes:  ");
        {
            res.append(authenticatedAttributes.toString());
        } //End block
        res.append("\ndigestEncryptionAlgorithm: ");
        res.append(digestEncryptionAlgorithm.toString());
        res.append("\nunauthenticatedAttributes: ");
        {
            res.append(unauthenticatedAttributes.toString());
        } //End block
        res.append("\n-- SignerInfo End\n");
        String var3F7A63C0290A7D59CE78DF2F46EB4AAE_1515975310 = (res.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static final ASN1Sequence ISSUER_AND_SERIAL_NUMBER = new ASN1Sequence(new ASN1Type[] {
                Name.ASN1,                       
                ASN1Integer.getInstance(),       
            }) {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.217 -0400", hash_original_method = "6CC9A4ABC185E3CC2B765CE7717989A1", hash_generated_method = "B7C22F3EB889FD4A4EF9693595A247A0")
        @DSModeled(DSC.SAFE)
        @Override
        public void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            Object [] issAndSerial;
            issAndSerial = (Object[])object;
            values[0] = issAndSerial[0];
            values[1] = issAndSerial[1];
            // ---------- Original Method ----------
            //Object [] issAndSerial = (Object[])object;
            //values[0] = issAndSerial[0];
            //values[1] = issAndSerial[1];
        }

        
}; //Transformed anonymous class
    public static final ASN1Sequence ASN1 = new ASN1Sequence(new ASN1Type[] {
                ASN1Integer.getInstance(),         
                ISSUER_AND_SERIAL_NUMBER,
                AlgorithmIdentifier.ASN1,           
                new ASN1Implicit(0, AuthenticatedAttributes.ASN1),
                AlgorithmIdentifier.ASN1,            
                ASN1OctetString.getInstance(),       
                 new ASN1Implicit(1, new ASN1SetOf(
                         AttributeTypeAndValue.ASN1)),
                }) {        {
            setOptional(3); 
            setOptional(6); 
        }
        
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.218 -0400", hash_original_method = "13D15A258F917C8B4D03BB0946061652", hash_generated_method = "759B29F89A2BB00EC06E4E0DF6F89CAD")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected void getValues(Object object, Object[] values) {
            dsTaint.addTaint(values[0].dsTaint);
            dsTaint.addTaint(object.dsTaint);
            SignerInfo si;
            si = (SignerInfo) object;
            values[0] = new byte[] {(byte)si.version};
            try 
            {
                values[1] = new Object[] { new Name(si.issuer.getName()),
                        si.serialNumber.toByteArray() };
            } //End block
            catch (IOException e)
            {
                if (DroidSafeAndroidRuntime.control) throw new RuntimeException("Failed to encode issuer name", e);
            } //End block
            values[2] = si.digestAlgorithm;
            values[3] = si.authenticatedAttributes;
            values[4] = si.digestEncryptionAlgorithm;
            values[5] = si.encryptedDigest;
            values[6] = si.unauthenticatedAttributes;
            // ---------- Original Method ----------
            //SignerInfo si = (SignerInfo) object;
            //values[0] = new byte[] {(byte)si.version};
            //try {
                //values[1] = new Object[] { new Name(si.issuer.getName()),
                        //si.serialNumber.toByteArray() };
            //} catch (IOException e) {
                //throw new RuntimeException("Failed to encode issuer name", e);
            //}
            //values[2] = si.digestAlgorithm;
            //values[3] = si.authenticatedAttributes;
            //values[4] = si.digestEncryptionAlgorithm;
            //values[5] = si.encryptedDigest;
            //values[6] = si.unauthenticatedAttributes;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:40.219 -0400", hash_original_method = "2E0301E2837E45CD6DC61EE3304DFEA2", hash_generated_method = "EA2E78D203E2E7393974B86E183B376F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        protected Object getDecodedObject(BerInputStream in) {
            dsTaint.addTaint(in.dsTaint);
            Object[] values;
            values = (Object[]) in.content;
            Object var3F9B7AF99A902AA12E641054F41161CE_1782424095 = (new SignerInfo(
                        ASN1Integer.toIntValue(values[0]),
                        (Object[]) values[1],
                        (AlgorithmIdentifier) values[2],
                        (AuthenticatedAttributes) values[3],
                        (AlgorithmIdentifier) values[4],
                        (byte[]) values[5],
                        (List) values[6]
                    ));
            return (Object)dsTaint.getTaint();
            // ---------- Original Method ----------
            //Object[] values = (Object[]) in.content;
            //return new SignerInfo(
                        //ASN1Integer.toIntValue(values[0]),
                        //(Object[]) values[1],
                        //(AlgorithmIdentifier) values[2],
                        //(AuthenticatedAttributes) values[3],
                        //(AlgorithmIdentifier) values[4],
                        //(byte[]) values[5],
                        //(List) values[6]
                    //);
        }

        
}; //Transformed anonymous class
}

