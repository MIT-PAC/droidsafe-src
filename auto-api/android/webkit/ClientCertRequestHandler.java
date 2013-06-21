package android.webkit;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Handler;
import java.security.PrivateKey;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509Certificate;
import org.apache.harmony.xnet.provider.jsse.NativeCrypto;

public final class ClientCertRequestHandler extends Handler {
    private BrowserFrame mBrowserFrame;
    private int mHandle;
    private String mHostAndPort;
    private SslClientCertLookupTable mTable;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.935 -0400", hash_original_method = "AEE151B717737CBCB7A587EF1854CBAA", hash_generated_method = "C2663DA2A02CA6EB2A359C8A1DA237E8")
    @DSModeled(DSC.SAFE)
     ClientCertRequestHandler(BrowserFrame browserFrame,
                             int handle,
                             String host_and_port,
                             SslClientCertLookupTable table) {
        dsTaint.addTaint(browserFrame.dsTaint);
        dsTaint.addTaint(handle);
        dsTaint.addTaint(host_and_port);
        dsTaint.addTaint(table.dsTaint);
        // ---------- Original Method ----------
        //mBrowserFrame = browserFrame;
        //mHandle = handle;
        //mHostAndPort = host_and_port;
        //mTable = table;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.936 -0400", hash_original_method = "64FCEA7134B3A4AE970AB02F9B621DE7", hash_generated_method = "4F7E146EAF4891CC9C2A0A2DBDCE85DE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void proceed(PrivateKey privateKey, X509Certificate[] chain) {
        dsTaint.addTaint(privateKey.dsTaint);
        dsTaint.addTaint(chain[0].dsTaint);
        byte[] privateKeyBytes;
        privateKeyBytes = privateKey.getEncoded();
        byte[][] chainBytes;
        try 
        {
            chainBytes = NativeCrypto.encodeCertificates(chain);
            mTable.Allow(mHostAndPort, privateKeyBytes, chainBytes);
            post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.936 -0400", hash_original_method = "B783D24C2F939DF8028A233F34F0F9F9", hash_generated_method = "D92F82C405C819DB2827FFC3EADB1009")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    mBrowserFrame.nativeSslClientCert(mHandle, privateKeyBytes, chainBytes);
                    // ---------- Original Method ----------
                    //mBrowserFrame.nativeSslClientCert(mHandle, privateKeyBytes, chainBytes);
                }
});
        } //End block
        catch (CertificateEncodingException e)
        {
            post(new Runnable() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.936 -0400", hash_original_method = "48C98BC672A8EB6C152B87088219F859", hash_generated_method = "7767B03BCEC5D1B0E62B335AB6A80FE6")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    mBrowserFrame.nativeSslClientCert(mHandle, null, null);
                    // ---------- Original Method ----------
                    //mBrowserFrame.nativeSslClientCert(mHandle, null, null);
                    //return;
                }
});
        } //End block
        // ---------- Original Method ----------
        //final byte[] privateKeyBytes = privateKey.getEncoded();
        //final byte[][] chainBytes;
        //try {
            //chainBytes = NativeCrypto.encodeCertificates(chain);
            //mTable.Allow(mHostAndPort, privateKeyBytes, chainBytes);
            //post(new Runnable() {
                    //public void run() {
                        //mBrowserFrame.nativeSslClientCert(mHandle, privateKeyBytes, chainBytes);
                    //}
                //});
        //} catch (CertificateEncodingException e) {
            //post(new Runnable() {
                    //public void run() {
                        //mBrowserFrame.nativeSslClientCert(mHandle, null, null);
                        //return;
                    //}
                //});
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.936 -0400", hash_original_method = "AA04DE2AFE7C82BDE74635A960EE7DC7", hash_generated_method = "D94A23EA3A30A8E6DC6AB3164D337B35")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void ignore() {
        post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.936 -0400", hash_original_method = "3777CFF7C72EE86A4FC72740E3E33E8F", hash_generated_method = "C8DBCA26DE8B7ABB70690327AC7DF1A7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                mBrowserFrame.nativeSslClientCert(mHandle, null, null);
                // ---------- Original Method ----------
                //mBrowserFrame.nativeSslClientCert(mHandle, null, null);
            }
});
        // ---------- Original Method ----------
        //post(new Runnable() {
                //public void run() {
                    //mBrowserFrame.nativeSslClientCert(mHandle, null, null);
                //}
            //});
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.937 -0400", hash_original_method = "12481701A92D26DDA1AD94835896CDC2", hash_generated_method = "B444BF37B2DE28738273C4AACB8AAA02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void cancel() {
        mTable.Deny(mHostAndPort);
        post(new Runnable() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:02.937 -0400", hash_original_method = "3777CFF7C72EE86A4FC72740E3E33E8F", hash_generated_method = "C8DBCA26DE8B7ABB70690327AC7DF1A7")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            public void run() {
                mBrowserFrame.nativeSslClientCert(mHandle, null, null);
                // ---------- Original Method ----------
                //mBrowserFrame.nativeSslClientCert(mHandle, null, null);
            }
});
        // ---------- Original Method ----------
        //mTable.Deny(mHostAndPort);
        //post(new Runnable() {
                //public void run() {
                    //mBrowserFrame.nativeSslClientCert(mHandle, null, null);
                //}
            //});
    }

    
}

