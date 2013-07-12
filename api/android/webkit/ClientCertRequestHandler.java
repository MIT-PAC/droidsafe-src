package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.apache.harmony.xnet.provider.jsse.NativeCrypto;

public final class ClientCertRequestHandler {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.496 -0400", hash_original_field = "210C1862D81E3FCC2FD87A83EA255D40", hash_generated_field = "076F5BF2A47D119E2704BFAF413B4749")

    private BrowserFrame mBrowserFrame;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.496 -0400", hash_original_field = "D82B253C7CDC2B84A5A684E7A5D691F6", hash_generated_field = "24C6DFC54244C0ECB3E13AC2BDE66375")

    private int mHandle;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.496 -0400", hash_original_field = "D6618C492513A6BC98F42D28E568A6FC", hash_generated_field = "906B3EAB5ED48B1D91170F5670978988")

    private String mHostAndPort;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.496 -0400", hash_original_field = "C6E937A240129F0FBCF94F4D1E6EA204", hash_generated_field = "CEA12ECAAA37536F06C699DA1C7C1084")

    private SslClientCertLookupTable mTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.497 -0400", hash_original_method = "AEE151B717737CBCB7A587EF1854CBAA", hash_generated_method = "CC9D3356029648C4CD59FE8F430B2C69")
      ClientCertRequestHandler(BrowserFrame browserFrame,
                             int handle,
                             String host_and_port,
                             SslClientCertLookupTable table) {
        mBrowserFrame = browserFrame;
        mHandle = handle;
        mHostAndPort = host_and_port;
        mTable = table;
        // ---------- Original Method ----------
        //mBrowserFrame = browserFrame;
        //mHandle = handle;
        //mHostAndPort = host_and_port;
        //mTable = table;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.498 -0400", hash_original_method = "FD9D9C54290793DEF25EE96780FA43D9", hash_generated_method = "C4A66D5ED40536FD239EBE37E2A0923B")
    public void proceed(PrivateKey privateKey, X509Certificate[] chain) {
        addTaint(chain[0].getTaint());
        addTaint(privateKey.getTaint());
        byte[] privateKeyBytes = privateKey.getEncoded();
        byte[][] chainBytes;
        try 
        {
            chainBytes = NativeCrypto.encodeCertificates(chain);
        } //End block
        catch (CertificateEncodingException e)
        {
            mBrowserFrame.nativeSslClientCert(mHandle, null, null);
            return;
        } //End block
        mTable.Allow(mHostAndPort, privateKeyBytes, chainBytes);
        mBrowserFrame.nativeSslClientCert(mHandle, privateKeyBytes, chainBytes);
        // ---------- Original Method ----------
        //byte[] privateKeyBytes = privateKey.getEncoded();
        //byte[][] chainBytes;
        //try {
            //chainBytes = NativeCrypto.encodeCertificates(chain);
        //} catch (CertificateEncodingException e) {
            //mBrowserFrame.nativeSslClientCert(mHandle, null, null);
            //return;
        //}
        //mTable.Allow(mHostAndPort, privateKeyBytes, chainBytes);
        //mBrowserFrame.nativeSslClientCert(mHandle, privateKeyBytes, chainBytes);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.499 -0400", hash_original_method = "FA404A4E1A97322F22CB23ECA9545548", hash_generated_method = "6C467D92C3B4D0C786BB58115DA32A26")
    public void ignore() {
        mBrowserFrame.nativeSslClientCert(mHandle, null, null);
        // ---------- Original Method ----------
        //mBrowserFrame.nativeSslClientCert(mHandle, null, null);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:57.499 -0400", hash_original_method = "E250E51CEC55FC558312A1D8553D2784", hash_generated_method = "990D36A655D7C75AC901D12157190C1E")
    public void cancel() {
        mTable.Deny(mHostAndPort);
        mBrowserFrame.nativeSslClientCert(mHandle, null, null);
        // ---------- Original Method ----------
        //mTable.Deny(mHostAndPort);
        //mBrowserFrame.nativeSslClientCert(mHandle, null, null);
    }

    
}

