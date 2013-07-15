package org.bouncycastle.asn1.x509;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERInteger;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;

public class IssuerSerial extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.124 -0400", hash_original_field = "3E6C2BC1E7F7E5E8C450394C747A8E9F", hash_generated_field = "FBA189AA1CCDF885E2BAFE3258EFE992")

    GeneralNames issuer;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.124 -0400", hash_original_field = "74136B24217CB75599440E6E1D807CF7", hash_generated_field = "B567171129E718B07996A791966D9A47")

    DERInteger serial;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.124 -0400", hash_original_field = "CE6DDC63C62D781984F661A1BC02AA1B", hash_generated_field = "3D9E898FBB0D3A6964BB9F619F1BE32F")

    DERBitString issuerUID;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.124 -0400", hash_original_method = "6A7E42DF8EF9B09B844C872DFCA023C7", hash_generated_method = "81A12530CE78D83707DC999FC53C83E0")
    public  IssuerSerial(
        ASN1Sequence    seq) {
    if(seq.size() != 2 && seq.size() != 3)        
        {
            IllegalArgumentException varA2072CF614C7B8C7696DD5A02DBCCE9C_738515351 = new IllegalArgumentException("Bad sequence size: " + seq.size());
            varA2072CF614C7B8C7696DD5A02DBCCE9C_738515351.addTaint(taint);
            throw varA2072CF614C7B8C7696DD5A02DBCCE9C_738515351;
        } //End block
        issuer = GeneralNames.getInstance(seq.getObjectAt(0));
        serial = DERInteger.getInstance(seq.getObjectAt(1));
    if(seq.size() == 3)        
        {
            issuerUID = DERBitString.getInstance(seq.getObjectAt(2));
        } //End block
        // ---------- Original Method ----------
        //if (seq.size() != 2 && seq.size() != 3)
        //{
            //throw new IllegalArgumentException("Bad sequence size: " + seq.size());
        //}
        //issuer = GeneralNames.getInstance(seq.getObjectAt(0));
        //serial = DERInteger.getInstance(seq.getObjectAt(1));
        //if (seq.size() == 3)
        //{
            //issuerUID = DERBitString.getInstance(seq.getObjectAt(2));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.125 -0400", hash_original_method = "B838D7E53D177DFF65C1A291EEAEEEE1", hash_generated_method = "D4EC88DF2D8A028D56F6AF5E2A27DDE6")
    public  IssuerSerial(
        GeneralNames    issuer,
        DERInteger      serial) {
        this.issuer = issuer;
        this.serial = serial;
        // ---------- Original Method ----------
        //this.issuer = issuer;
        //this.serial = serial;
    }

    
        public static IssuerSerial getInstance(
            Object  obj) {
        if (obj == null || obj instanceof IssuerSerial)
        {
            return (IssuerSerial)obj;
        }
        if (obj instanceof ASN1Sequence)
        {
            return new IssuerSerial((ASN1Sequence)obj);
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    
        public static IssuerSerial getInstance(
        ASN1TaggedObject obj,
        boolean          explicit) {
        return getInstance(ASN1Sequence.getInstance(obj, explicit));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.126 -0400", hash_original_method = "C6A01CC056B505ECB1961F3D46D5E125", hash_generated_method = "4E581FF7D88EEF02F5E8BD40D66AD5BA")
    public GeneralNames getIssuer() {
GeneralNames var8EF52627413B91AB97DB59853805E979_90335660 =         issuer;
        var8EF52627413B91AB97DB59853805E979_90335660.addTaint(taint);
        return var8EF52627413B91AB97DB59853805E979_90335660;
        // ---------- Original Method ----------
        //return issuer;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.127 -0400", hash_original_method = "4A26172B3E4E9D1CBD95C0010541030C", hash_generated_method = "070DB87715416938A451B19FC32DDB0B")
    public DERInteger getSerial() {
DERInteger var071C6561B4B2655A6920B0B7F1E6ECD0_1909554665 =         serial;
        var071C6561B4B2655A6920B0B7F1E6ECD0_1909554665.addTaint(taint);
        return var071C6561B4B2655A6920B0B7F1E6ECD0_1909554665;
        // ---------- Original Method ----------
        //return serial;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.127 -0400", hash_original_method = "6FC86B4935E8EDEA9326972109BFF43A", hash_generated_method = "752999F3D4A5508548F86EFCE9B79272")
    public DERBitString getIssuerUID() {
DERBitString var81B1BFDC984EDD98A3FFF7ED3A8DDFA3_541272309 =         issuerUID;
        var81B1BFDC984EDD98A3FFF7ED3A8DDFA3_541272309.addTaint(taint);
        return var81B1BFDC984EDD98A3FFF7ED3A8DDFA3_541272309;
        // ---------- Original Method ----------
        //return issuerUID;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:40.127 -0400", hash_original_method = "91432FD7FC59DB0CA5EF9903A7843F73", hash_generated_method = "53714C3EEF2C56E769DB1A31E89AB73D")
    public DERObject toASN1Object() {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(issuer);
        v.add(serial);
    if(issuerUID != null)        
        {
            v.add(issuerUID);
        } //End block
DERObject var0B338F106E3279986C87B595B0F4A439_1024731792 =         new DERSequence(v);
        var0B338F106E3279986C87B595B0F4A439_1024731792.addTaint(taint);
        return var0B338F106E3279986C87B595B0F4A439_1024731792;
        // ---------- Original Method ----------
        //ASN1EncodableVector  v = new ASN1EncodableVector();
        //v.add(issuer);
        //v.add(serial);
        //if (issuerUID != null)
        //{
            //v.add(issuerUID);
        //}
        //return new DERSequence(v);
    }

    
}

