package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jce.netscape.NetscapeCertRequest;
import org.bouncycastle.util.encoders.Base64;
import android.content.Context;
import android.security.Credentials;
import android.security.KeyChain;
import android.util.Log;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;

final class CertTool {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.836 -0400", hash_original_method = "1838D0FEFA9E4F93A3624A1092DC54F1", hash_generated_method = "A2E73AC90715BF3F494182DD5E1CE810")
    private  CertTool() {
        // ---------- Original Method ----------
    }

    
        static String[] getKeyStrengthList() {
        return new String[] {"High Grade", "Medium Grade"};
    }

    
        static String getSignedPublicKey(Context context, int index, String challenge) {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize((index == 0) ? 2048 : 1024);
            KeyPair pair = generator.genKeyPair();
            NetscapeCertRequest request = new NetscapeCertRequest(challenge,
                    MD5_WITH_RSA, pair.getPublic());
            request.sign(pair.getPrivate());
            byte[] signed = request.toASN1Object().getDEREncoded();
            Credentials.getInstance().install(context, pair);
            return new String(Base64.encode(signed));
        } catch (Exception e) {
            Log.w(LOGTAG, e);
        }
        return null;
    }

    
        static void addCertificate(Context context, String type, byte[] value) {
        Credentials.getInstance().install(context, type, value);
    }

    
        static String getCertType(String mimeType) {
        return sCertificateTypeMap.get(mimeType);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.845 -0400", hash_original_field = "89C8B1A9F5BADC5D1ADAA84ED60862F8", hash_generated_field = "9C91797B1157E17A79A818C80022B6CA")

    private static String LOGTAG = "CertTool";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.845 -0400", hash_original_field = "318F1DC73517352936F4221B8029EA95", hash_generated_field = "9334A87EB4C3AF54880CCD6E2B04F87E")

    private static AlgorithmIdentifier MD5_WITH_RSA = new AlgorithmIdentifier(PKCSObjectIdentifiers.md5WithRSAEncryption);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:57.845 -0400", hash_original_field = "A8C5B10CBD5CDBF8A9F516DE7ACC2826", hash_generated_field = "4B6102789B0D3F567AE83CB481B398FF")

    private static HashMap<String, String> sCertificateTypeMap;
    static {
        sCertificateTypeMap = new HashMap<String, String>();
        sCertificateTypeMap.put("application/x-x509-ca-cert", KeyChain.EXTRA_CERTIFICATE);
        sCertificateTypeMap.put("application/x-x509-user-cert", KeyChain.EXTRA_CERTIFICATE);
        sCertificateTypeMap.put("application/x-pkcs12", KeyChain.EXTRA_PKCS12);
    }
    
}

