package org.bouncycastle.jce.netscape;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class NetscapeCertRequest extends ASN1Encodable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.316 -0400", hash_original_field = "8710B712D6001BE6B1DFD7058DD60BA8", hash_generated_field = "EE2A131D5158CEBBA9141A6C94018250")

    AlgorithmIdentifier sigAlg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.316 -0400", hash_original_field = "C1DFA50174835A6BC19B08413D162AF0", hash_generated_field = "F8E5474138E75785580EBCE50F8F784A")

    AlgorithmIdentifier keyAlg;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.316 -0400", hash_original_field = "25E4726A06FDFB58BDAB77A972B4E29E", hash_generated_field = "121838C7870C129075D9A1E92F7A9839")

    byte sigBits[];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.316 -0400", hash_original_field = "B04EC0ADE3D49B4A079F0E207D5E2821", hash_generated_field = "250DD14315DBA25631465B27752AA1F4")

    String challenge;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.316 -0400", hash_original_field = "9A0364B9E99BB480DD25E1F0284C8555", hash_generated_field = "A2F3DA20BD1CF27986C84C664A50FCF1")

    DERBitString content;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.316 -0400", hash_original_field = "41CE59683FBBDF3F03B9D3AEF66BC3C9", hash_generated_field = "EC14682B5D712C02F4760CDD94DCE324")

    PublicKey pubkey;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.316 -0400", hash_original_method = "E784D2D6D9424F9738F1550A3283A21D", hash_generated_method = "578731D7077838229C848DAEA84ED2C9")
    public  NetscapeCertRequest(
        byte[]  req) throws IOException {
        this(getReq(req));
        addTaint(req[0]);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.318 -0400", hash_original_method = "F4E8ED02C3015EE5D86AD4E86AD94BA5", hash_generated_method = "EB952299A5D2CF75E32D87EF36553636")
    public  NetscapeCertRequest(ASN1Sequence spkac) {
        try 
        {
            if(spkac.size() != 3)            
            {
                IllegalArgumentException varE1C1D59A46AAEE56D24B051E95FA4A6A_856671863 = new IllegalArgumentException("invalid SPKAC (size):"
                        + spkac.size());
                varE1C1D59A46AAEE56D24B051E95FA4A6A_856671863.addTaint(taint);
                throw varE1C1D59A46AAEE56D24B051E95FA4A6A_856671863;
            } //End block
            sigAlg = new AlgorithmIdentifier((ASN1Sequence)spkac
                    .getObjectAt(1));
            sigBits = ((DERBitString)spkac.getObjectAt(2)).getBytes();
            ASN1Sequence pkac = (ASN1Sequence)spkac.getObjectAt(0);
            if(pkac.size() != 2)            
            {
                IllegalArgumentException var1F9CF8D5CEA54AEB11D03E82F013FDA6_1566724719 = new IllegalArgumentException("invalid PKAC (len): "
                        + pkac.size());
                var1F9CF8D5CEA54AEB11D03E82F013FDA6_1566724719.addTaint(taint);
                throw var1F9CF8D5CEA54AEB11D03E82F013FDA6_1566724719;
            } //End block
            challenge = ((DERIA5String)pkac.getObjectAt(1)).getString();
            content = new DERBitString(pkac);
            SubjectPublicKeyInfo pubkeyinfo = new SubjectPublicKeyInfo(
                    (ASN1Sequence)pkac.getObjectAt(0));
            X509EncodedKeySpec xspec = new X509EncodedKeySpec(new DERBitString(
                    pubkeyinfo).getBytes());
            keyAlg = pubkeyinfo.getAlgorithmId();
            pubkey = KeyFactory.getInstance(keyAlg.getObjectId().getId(), "BC")
                    .generatePublic(xspec);
        } //End block
        catch (Exception e)
        {
            IllegalArgumentException var9F2D2307FB3407E9BCF003CA82D66F4E_2138041097 = new IllegalArgumentException(e.toString());
            var9F2D2307FB3407E9BCF003CA82D66F4E_2138041097.addTaint(taint);
            throw var9F2D2307FB3407E9BCF003CA82D66F4E_2138041097;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.319 -0400", hash_original_method = "1A82B1619517E26DD541E9FF2CF124F1", hash_generated_method = "DEE91FCADDA2612A8DF8A00CEF4A8771")
    public  NetscapeCertRequest(
        String challenge,
        AlgorithmIdentifier signing_alg,
        PublicKey pub_key) throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchProviderException {
        this.challenge = challenge;
        sigAlg = signing_alg;
        pubkey = pub_key;
        ASN1EncodableVector content_der = new ASN1EncodableVector();
        content_der.add(getKeySpec());
        content_der.add(new DERIA5String(challenge));
        content = new DERBitString(new DERSequence(content_der));
        // ---------- Original Method ----------
        //this.challenge = challenge;
        //sigAlg = signing_alg;
        //pubkey = pub_key;
        //ASN1EncodableVector content_der = new ASN1EncodableVector();
        //content_der.add(getKeySpec());
        //content_der.add(new DERIA5String(challenge));
        //content = new DERBitString(new DERSequence(content_der));
    }

    
    @DSModeled(DSC.SAFE)
    private static ASN1Sequence getReq(
        byte[]  r) throws IOException {
        ASN1InputStream aIn = new ASN1InputStream(new ByteArrayInputStream(r));
        return ASN1Sequence.getInstance(aIn.readObject());
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.320 -0400", hash_original_method = "ED4D5D58119D3F853ED82C63E0533A7D", hash_generated_method = "0BE6EC8925C01B1D88B93415448D7910")
    public String getChallenge() {
String var74568D0557DDB639C8E08A8EFDFC6344_1718143827 =         challenge;
        var74568D0557DDB639C8E08A8EFDFC6344_1718143827.addTaint(taint);
        return var74568D0557DDB639C8E08A8EFDFC6344_1718143827;
        // ---------- Original Method ----------
        //return challenge;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.320 -0400", hash_original_method = "301D77BA94E757D10A3FA603DC1F3204", hash_generated_method = "ED44293D30BFB95C03F13A1DC78A5455")
    public void setChallenge(String value) {
        challenge = value;
        // ---------- Original Method ----------
        //challenge = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.321 -0400", hash_original_method = "DEA71583AADCBA6F6FCA4AF03E02FF7E", hash_generated_method = "D3F699BE740421F3B746766FA292BC10")
    public AlgorithmIdentifier getSigningAlgorithm() {
AlgorithmIdentifier var022F107D9C043A7C0CB3A1D1ADABDDCF_1270950760 =         sigAlg;
        var022F107D9C043A7C0CB3A1D1ADABDDCF_1270950760.addTaint(taint);
        return var022F107D9C043A7C0CB3A1D1ADABDDCF_1270950760;
        // ---------- Original Method ----------
        //return sigAlg;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.321 -0400", hash_original_method = "8DECC6DE401A18CABE51772A2768CD3E", hash_generated_method = "4234E9F4B9918E8F387A0E2A48DC8A2C")
    public void setSigningAlgorithm(AlgorithmIdentifier value) {
        sigAlg = value;
        // ---------- Original Method ----------
        //sigAlg = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.321 -0400", hash_original_method = "FE7B6AD2AAFCEFF19EF5259C1AEF0E0B", hash_generated_method = "CC018C76D9FC21EB1299FD03016D7D8A")
    public AlgorithmIdentifier getKeyAlgorithm() {
AlgorithmIdentifier var42D430F33AA4FB0A37995C8217D3BF09_247286319 =         keyAlg;
        var42D430F33AA4FB0A37995C8217D3BF09_247286319.addTaint(taint);
        return var42D430F33AA4FB0A37995C8217D3BF09_247286319;
        // ---------- Original Method ----------
        //return keyAlg;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.322 -0400", hash_original_method = "A707B494F7BE2B273065A846BD08233F", hash_generated_method = "3EAE43A81A989F21379DEDADCC255BDB")
    public void setKeyAlgorithm(AlgorithmIdentifier value) {
        keyAlg = value;
        // ---------- Original Method ----------
        //keyAlg = value;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.322 -0400", hash_original_method = "B14D7737A8CCC155007C211714C134B9", hash_generated_method = "FD6AD8A425CACFEEC5A117E4E7E41345")
    public PublicKey getPublicKey() {
PublicKey varF4E785CAC4E37DDA6682AE974579280B_1178187371 =         pubkey;
        varF4E785CAC4E37DDA6682AE974579280B_1178187371.addTaint(taint);
        return varF4E785CAC4E37DDA6682AE974579280B_1178187371;
        // ---------- Original Method ----------
        //return pubkey;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.322 -0400", hash_original_method = "524BDADC1CE3625FA3734945CD591C94", hash_generated_method = "2D5D732B22E00431248C23383E075117")
    public void setPublicKey(PublicKey value) {
        pubkey = value;
        // ---------- Original Method ----------
        //pubkey = value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.323 -0400", hash_original_method = "E3E7D887F34AE4BB0FD59D717AA1E296", hash_generated_method = "30131091EAAEA79BA67ED2485E88DC3F")
    public boolean verify(String challenge) throws NoSuchAlgorithmException,
            InvalidKeyException, SignatureException, NoSuchProviderException {
        addTaint(challenge.getTaint());
        if(!challenge.equals(this.challenge))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2015967673 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1743310962 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1743310962;
        } //End block
        Signature sig = Signature.getInstance(sigAlg.getObjectId().getId(),
                "BC");
        sig.initVerify(pubkey);
        sig.update(content.getBytes());
        boolean var226E3CAE6C979B8981AC13976AA4BDA5_407817746 = (sig.verify(sigBits));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_726466852 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_726466852;
        // ---------- Original Method ----------
        //if (!challenge.equals(this.challenge))
        //{
            //return false;
        //}
        //Signature sig = Signature.getInstance(sigAlg.getObjectId().getId(),
                //"BC");
        //sig.initVerify(pubkey);
        //sig.update(content.getBytes());
        //return sig.verify(sigBits);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.324 -0400", hash_original_method = "69BFD65CBC2833C297505F1023C7598F", hash_generated_method = "FC089958E771ACE857E0D0436B1B1767")
    public void sign(PrivateKey priv_key) throws NoSuchAlgorithmException,
            InvalidKeyException, SignatureException, NoSuchProviderException,
            InvalidKeySpecException {
        addTaint(priv_key.getTaint());
        sign(priv_key, null);
        // ---------- Original Method ----------
        //sign(priv_key, null);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.326 -0400", hash_original_method = "D4E72A005612CE8E458CA009F1575A62", hash_generated_method = "1DA880C270468EF8AF73FCF906821D89")
    public void sign(PrivateKey priv_key, SecureRandom rand) throws NoSuchAlgorithmException, InvalidKeyException,
            SignatureException, NoSuchProviderException,
            InvalidKeySpecException {
        addTaint(rand.getTaint());
        addTaint(priv_key.getTaint());
        Signature sig = Signature.getInstance(sigAlg.getObjectId().getId(),
                "BC");
        if(rand != null)        
        {
            sig.initSign(priv_key, rand);
        } //End block
        else
        {
            sig.initSign(priv_key);
        } //End block
        ASN1EncodableVector pkac = new ASN1EncodableVector();
        pkac.add(getKeySpec());
        pkac.add(new DERIA5String(challenge));
        try 
        {
            sig.update(new DERSequence(pkac).getEncoded(ASN1Encodable.DER));
        } //End block
        catch (IOException ioe)
        {
            SignatureException varF12D36EC3CE4BAE0DC54BF8AAF2AE18C_424803580 = new SignatureException(ioe.getMessage());
            varF12D36EC3CE4BAE0DC54BF8AAF2AE18C_424803580.addTaint(taint);
            throw varF12D36EC3CE4BAE0DC54BF8AAF2AE18C_424803580;
        } //End block
        sigBits = sig.sign();
        // ---------- Original Method ----------
        //Signature sig = Signature.getInstance(sigAlg.getObjectId().getId(),
                //"BC");
        //if (rand != null)
        //{
            //sig.initSign(priv_key, rand);
        //}
        //else
        //{
            //sig.initSign(priv_key);
        //}
        //ASN1EncodableVector pkac = new ASN1EncodableVector();
        //pkac.add(getKeySpec());
        //pkac.add(new DERIA5String(challenge));
        //try
        //{
            //sig.update(new DERSequence(pkac).getEncoded(ASN1Encodable.DER));
        //}
        //catch (IOException ioe)
        //{
            //throw new SignatureException(ioe.getMessage());
        //}
        //sigBits = sig.sign();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.327 -0400", hash_original_method = "500EEF6D5B4EBED065BB69A7AF04B4E9", hash_generated_method = "A717DBB8F4E9C18D95E77365ABB676C5")
    private DERObject getKeySpec() throws NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchProviderException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DERObject obj = null;
        try 
        {
            baos.write(pubkey.getEncoded());
            baos.close();
            ASN1InputStream derin = new ASN1InputStream(
                    new ByteArrayInputStream(baos.toByteArray()));
            obj = derin.readObject();
        } //End block
        catch (IOException ioe)
        {
            InvalidKeySpecException var0F923734045C069E60E594CD073FA529_1772088200 = new InvalidKeySpecException(ioe.getMessage());
            var0F923734045C069E60E594CD073FA529_1772088200.addTaint(taint);
            throw var0F923734045C069E60E594CD073FA529_1772088200;
        } //End block
DERObject var2FDE1120F80AA4E8798ECDBDB1C0E85C_2032015780 =         obj;
        var2FDE1120F80AA4E8798ECDBDB1C0E85C_2032015780.addTaint(taint);
        return var2FDE1120F80AA4E8798ECDBDB1C0E85C_2032015780;
        // ---------- Original Method ----------
        //ByteArrayOutputStream baos = new ByteArrayOutputStream();
        //DERObject obj = null;
        //try
        //{
            //baos.write(pubkey.getEncoded());
            //baos.close();
            //ASN1InputStream derin = new ASN1InputStream(
                    //new ByteArrayInputStream(baos.toByteArray()));
            //obj = derin.readObject();
        //}
        //catch (IOException ioe)
        //{
            //throw new InvalidKeySpecException(ioe.getMessage());
        //}
        //return obj;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:41.327 -0400", hash_original_method = "B0EE724D7F7552AF427D32E04334786D", hash_generated_method = "1D120F43FF4439B6AF7A0EC0D13F6CDC")
    public DERObject toASN1Object() {
        ASN1EncodableVector spkac = new ASN1EncodableVector();
        ASN1EncodableVector pkac = new ASN1EncodableVector();
        try 
        {
            pkac.add(getKeySpec());
        } //End block
        catch (Exception e)
        {
        } //End block
        pkac.add(new DERIA5String(challenge));
        spkac.add(new DERSequence(pkac));
        spkac.add(sigAlg);
        spkac.add(new DERBitString(sigBits));
DERObject var65E1702433DC1E5B8ECBD428174A1E3A_112185872 =         new DERSequence(spkac);
        var65E1702433DC1E5B8ECBD428174A1E3A_112185872.addTaint(taint);
        return var65E1702433DC1E5B8ECBD428174A1E3A_112185872;
        // ---------- Original Method ----------
        //ASN1EncodableVector spkac = new ASN1EncodableVector();
        //ASN1EncodableVector pkac = new ASN1EncodableVector();
        //try
        //{
            //pkac.add(getKeySpec());
        //}
        //catch (Exception e)
        //{
        //}
        //pkac.add(new DERIA5String(challenge));
        //spkac.add(new DERSequence(pkac));
        //spkac.add(sigAlg);
        //spkac.add(new DERBitString(sigBits));
        //return new DERSequence(spkac);
    }

    
}

