package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import com.android.org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import com.android.org.bouncycastle.jce.netscape.NetscapeCertRequest;
import com.android.org.bouncycastle.util.encoders.Base64;
import android.content.Context;
import android.security.Credentials;
import android.security.KeyChain;
import android.util.Log;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;

final class CertTool {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.933 -0400", hash_original_method = "1838D0FEFA9E4F93A3624A1092DC54F1", hash_generated_method = "A2E73AC90715BF3F494182DD5E1CE810")
    @DSModeled(DSC.SAFE)
    private CertTool() {
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

    
    private static final String LOGTAG = "CertTool";
    private static final AlgorithmIdentifier MD5_WITH_RSA =
            new AlgorithmIdentifier(PKCSObjectIdentifiers.md5WithRSAEncryption);
    private static HashMap<String, String> sCertificateTypeMap;
    static {
        sCertificateTypeMap = new HashMap<String, String>();
        sCertificateTypeMap.put("application/x-x509-ca-cert", KeyChain.EXTRA_CERTIFICATE);
        sCertificateTypeMap.put("application/x-x509-user-cert", KeyChain.EXTRA_CERTIFICATE);
        sCertificateTypeMap.put("application/x-pkcs12", KeyChain.EXTRA_PKCS12);
    }
    
}

