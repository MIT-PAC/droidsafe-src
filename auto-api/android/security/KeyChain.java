package android.security;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.security.KeyPair;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import libcore.util.Objects;
import org.apache.harmony.xnet.provider.jsse.TrustedCertificateStore;

public final class KeyChain {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.138 -0400", hash_original_method = "040D92193EBCC3E900B271B4A53EB28C", hash_generated_method = "040D92193EBCC3E900B271B4A53EB28C")
        public KeyChain ()
    {
    }


        public static Intent createInstallIntent() {
        Intent intent = new Intent(ACTION_INSTALL);
        intent.setClassName("com.android.certinstaller",
                            "com.android.certinstaller.CertInstallerMain");
        return intent;
    }

    
        public static void choosePrivateKeyAlias(Activity activity, KeyChainAliasCallback response,
                                             String[] keyTypes, Principal[] issuers,
                                             String host, int port,
                                             String alias) {
        if (activity == null) {
            throw new NullPointerException("activity == null");
        }
        if (response == null) {
            throw new NullPointerException("response == null");
        }
        Intent intent = new Intent(ACTION_CHOOSER);
        intent.putExtra(EXTRA_RESPONSE, new AliasResponse(response));
        intent.putExtra(EXTRA_HOST, host);
        intent.putExtra(EXTRA_PORT, port);
        intent.putExtra(EXTRA_ALIAS, alias);
        intent.putExtra(EXTRA_SENDER, PendingIntent.getActivity(activity, 0, new Intent(), 0));
        activity.startActivity(intent);
    }

    
        public static PrivateKey getPrivateKey(Context context, String alias) throws KeyChainException, InterruptedException {
        if (alias == null) {
            throw new NullPointerException("alias == null");
        }
        KeyChainConnection keyChainConnection = bind(context);
        try {
            IKeyChainService keyChainService = keyChainConnection.getService();
            byte[] privateKeyBytes = keyChainService.getPrivateKey(alias);
            return toPrivateKey(privateKeyBytes);
        } catch (RemoteException e) {
            throw new KeyChainException(e);
        } catch (RuntimeException e) {
            throw new KeyChainException(e);
        } finally {
            keyChainConnection.close();
        }
    }

    
        public static X509Certificate[] getCertificateChain(Context context, String alias) throws KeyChainException, InterruptedException {
        if (alias == null) {
            throw new NullPointerException("alias == null");
        }
        KeyChainConnection keyChainConnection = bind(context);
        try {
            IKeyChainService keyChainService = keyChainConnection.getService();
            byte[] certificateBytes = keyChainService.getCertificate(alias);
            List<X509Certificate> chain = new ArrayList<X509Certificate>();
            chain.add(toCertificate(certificateBytes));
            TrustedCertificateStore store = new TrustedCertificateStore();
            for (int i = 0; true; i++) {
                X509Certificate cert = chain.get(i);
                if (Objects.equal(cert.getSubjectX500Principal(), cert.getIssuerX500Principal())) {
                    break;
                }
                X509Certificate issuer = store.findIssuer(cert);
                if (issuer == null) {
                    break;
                }
                chain.add(issuer);
            }
            return chain.toArray(new X509Certificate[chain.size()]);
        } catch (RemoteException e) {
            throw new KeyChainException(e);
        } catch (RuntimeException e) {
            throw new KeyChainException(e);
        } finally {
            keyChainConnection.close();
        }
    }

    
        private static PrivateKey toPrivateKey(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("bytes == null");
        }
        try {
            KeyPair keyPair = (KeyPair) Credentials.convertFromPem(bytes).get(0);
            return keyPair.getPrivate();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    
        private static X509Certificate toCertificate(byte[] bytes) {
        if (bytes == null) {
            throw new IllegalArgumentException("bytes == null");
        }
        try {
            CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
            Certificate cert = certFactory.generateCertificate(new ByteArrayInputStream(bytes));
            return (X509Certificate) cert;
        } catch (CertificateException e) {
            throw new AssertionError(e);
        }
    }

    
        public static KeyChainConnection bind(Context context) throws InterruptedException {
        if (context == null) {
            throw new NullPointerException("context == null");
        }
        ensureNotOnMainThread(context);
        final BlockingQueue<IKeyChainService> q = new LinkedBlockingQueue<IKeyChainService>(1);
        ServiceConnection keyChainServiceConnection = new ServiceConnection() {
            volatile boolean mConnectedAtLeastOnce = false;
            @Override public void onServiceConnected(ComponentName name, IBinder service) {
                if (!mConnectedAtLeastOnce) {
                    mConnectedAtLeastOnce = true;
                    try {
                        q.put(IKeyChainService.Stub.asInterface(service));
                    } catch (InterruptedException e) {
                    }
                }
            }
            @Override public void onServiceDisconnected(ComponentName name) {}
        };
        boolean isBound = context.bindService(new Intent(IKeyChainService.class.getName()),
                                              keyChainServiceConnection,
                                              Context.BIND_AUTO_CREATE);
        if (!isBound) {
            throw new AssertionError("could not bind to KeyChainService");
        }
        return new KeyChainConnection(context, keyChainServiceConnection, q.take());
    }

    
        private static void ensureNotOnMainThread(Context context) {
        Looper looper = Looper.myLooper();
        if (looper != null && looper == context.getMainLooper()) {
            throw new IllegalStateException(
                    "calling this from your main thread can lead to deadlock");
        }
    }

    
    private static class AliasResponse extends IKeyChainAliasCallback.Stub {
        private KeyChainAliasCallback keyChainAliasResponse;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.140 -0400", hash_original_method = "C9AAF5E97D9880605AC7CEDD0F5EF602", hash_generated_method = "627A38E59683C428C5555E3F2C463635")
        @DSModeled(DSC.SAFE)
        private AliasResponse(KeyChainAliasCallback keyChainAliasResponse) {
            dsTaint.addTaint(keyChainAliasResponse.dsTaint);
            // ---------- Original Method ----------
            //this.keyChainAliasResponse = keyChainAliasResponse;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.140 -0400", hash_original_method = "253185D367E73ED341795E1D21B0472E", hash_generated_method = "9FC96B0F8BD24BD81B5CF39DD854F456")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void alias(String alias) {
            dsTaint.addTaint(alias);
            keyChainAliasResponse.alias(alias);
            // ---------- Original Method ----------
            //keyChainAliasResponse.alias(alias);
        }

        
    }


    
    public final static class KeyChainConnection implements Closeable {
        private Context context;
        private ServiceConnection serviceConnection;
        private IKeyChainService service;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.140 -0400", hash_original_method = "0B75A6D253D58C29BB28E672713E5120", hash_generated_method = "2049723FFC44DE649895DE9C5459A8C7")
        @DSModeled(DSC.SAFE)
        private KeyChainConnection(Context context,
                                   ServiceConnection serviceConnection,
                                   IKeyChainService service) {
            dsTaint.addTaint(serviceConnection.dsTaint);
            dsTaint.addTaint(service.dsTaint);
            dsTaint.addTaint(context.dsTaint);
            // ---------- Original Method ----------
            //this.context = context;
            //this.serviceConnection = serviceConnection;
            //this.service = service;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.140 -0400", hash_original_method = "5F7D82BAE91D9994EB60B4EFC2ED07C1", hash_generated_method = "9F50B99A37D6B57C2CD3AB13B97D7FC3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() {
            context.unbindService(serviceConnection);
            // ---------- Original Method ----------
            //context.unbindService(serviceConnection);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:55.141 -0400", hash_original_method = "954EE7241574324971051CDC9EEAAD50", hash_generated_method = "DD208FF156DFD0C19520B53047E37629")
        @DSModeled(DSC.SAFE)
        public IKeyChainService getService() {
            return (IKeyChainService)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return service;
        }

        
    }


    
    private static final String TAG = "KeyChain";
    public static final String ACCOUNT_TYPE = "com.android.keychain";
    private static final String ACTION_CHOOSER = "com.android.keychain.CHOOSER";
    public static final String EXTRA_RESPONSE = "response";
    public static final String EXTRA_HOST = "host";
    public static final String EXTRA_PORT = "port";
    public static final String EXTRA_ALIAS = "alias";
    public static final String EXTRA_SENDER = "sender";
    private static final String ACTION_INSTALL = "android.credentials.INSTALL";
    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_CERTIFICATE = "CERT";
    public static final String EXTRA_PKCS12 = "PKCS12";
}

