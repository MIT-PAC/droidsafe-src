package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.HashMap;

import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.jce.netscape.NetscapeCertRequest;
import org.bouncycastle.util.encoders.Base64;

import android.content.Context;
import android.security.Credentials;
import android.security.KeyChain;
import android.util.Log;





final class CertTool {

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.998 -0500", hash_original_method = "CB2D35D966CD710A64E9BD9F45549511", hash_generated_method = "16A514B58BB4148859FC4ED301091CD7")
    static String[] getKeyStrengthList() {
        return new String[] {"High Grade", "Medium Grade"};
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.999 -0500", hash_original_method = "0C31F22EE5605896C042A9554E5E2F85", hash_generated_method = "D56FBDE3293A63C7B233422532D7DC04")
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

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:24.000 -0500", hash_original_method = "7A8048437C17E24F9A892E4FDE33D0BB", hash_generated_method = "61BC1E53B23D221FD5FE580A86EE5C50")
    static void addCertificate(Context context, String type, byte[] value) {
        Credentials.getInstance().install(context, type, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:24.001 -0500", hash_original_method = "D4AF6F68FC296225D479C322C857B353", hash_generated_method = "1491190F75D0EB25846273129E9B3152")
    static String getCertType(String mimeType) {
        return sCertificateTypeMap.get(mimeType);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.996 -0500", hash_original_field = "39E2DED3B53A8EDEC2FD565F9B8E87E0", hash_generated_field = "205D15FAC42FD8B1401CE817A71B270D")

    private static final String LOGTAG = "CertTool";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.996 -0500", hash_original_field = "C922C1E0E587BAE42337D813D01973D3", hash_generated_field = "CD5933C3A9B5A26C387D6522BB21C57D")


    private static final AlgorithmIdentifier MD5_WITH_RSA =
            new AlgorithmIdentifier(PKCSObjectIdentifiers.md5WithRSAEncryption);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:23.997 -0500", hash_original_field = "38906D82A9901FB743C573D20E88064E", hash_generated_field = "4B6102789B0D3F567AE83CB481B398FF")


    private static HashMap<String, String> sCertificateTypeMap;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:49:24.002 -0500", hash_original_method = "1838D0FEFA9E4F93A3624A1092DC54F1", hash_generated_method = "FD3B0B368FFB59B33F5C094D6E914C6F")
    private CertTool() {}
    static {
        sCertificateTypeMap = new HashMap<String, String>();
        sCertificateTypeMap.put("application/x-x509-ca-cert", KeyChain.EXTRA_CERTIFICATE);
        sCertificateTypeMap.put("application/x-x509-user-cert", KeyChain.EXTRA_CERTIFICATE);
        sCertificateTypeMap.put("application/x-pkcs12", KeyChain.EXTRA_PKCS12);
    }
    
}

