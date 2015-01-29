package android.media;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MediaScannerConnection implements ServiceConnection {

    /**
     * Convenience for constructing a {@link MediaScannerConnection}, calling
     * {@link #connect} on it, and calling {@link #scanFile} with the given
     * <var>path</var> and <var>mimeType</var> when the connection is
     * established.
     * @param context The caller's Context, required for establishing a connection to
     * the media scanner service.
     * Success or failure of the scanning operation cannot be determined until
     * {@link MediaScannerConnectionClient#onScanCompleted(String, Uri)} is called.
     * @param paths Array of paths to be scanned.
     * @param mimeTypes Optional array of MIME types for each path.
     * If mimeType is null, then the mimeType will be inferred from the file extension.
     * @param callback Optional callback through which you can receive the
     * scanned URI and MIME type; If null, the file will be scanned but
     * you will not get a result back.
     * @see scanFile(String, String)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.474 -0500", hash_original_method = "6A8A3DFD6D856A5795C5FD21267D8D29", hash_generated_method = "69E7460543CC37A8784FCB54B6EED605")
    
public static void scanFile(Context context, String[] paths, String[] mimeTypes,
            OnScanCompletedListener callback) {
        ClientProxy client = new ClientProxy(paths, mimeTypes, callback);
        MediaScannerConnection connection = new MediaScannerConnection(context, client);
        client.mConnection = connection;
        connection.connect();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.409 -0500", hash_original_field = "FA9088997C8326B29A310512882D81CA", hash_generated_field = "4C0BB6EBD7CFC593F55CEDF09E4F4A6A")

    private static final String TAG = "MediaScannerConnection";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.411 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.413 -0500", hash_original_field = "4CD54E75D77FFDB6723D212BB5D7AB75", hash_generated_field = "A9DE3A256FB264536B7E2E88DEACCB5D")

    private MediaScannerConnectionClient mClient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.416 -0500", hash_original_field = "B631D8AAF022E6B5099E061BBD4C0EB0", hash_generated_field = "2C76700CD7092FEC4FFAC484D89086E3")

    private IMediaScannerService mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.418 -0500", hash_original_field = "88D3A3B5F5EB5B71EDFBF64080CB77BC", hash_generated_field = "C3BBE48193464DA79FD826E783212B6D")

    private boolean mConnected;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:16.818 -0400", hash_original_field = "32E089CCEEBCB20211A6736666324364", hash_generated_field = "08875F2CE3C391FDC01CF4BC15F196A4")

    private IMediaScannerListener.Stub mListener = new IMediaScannerListener.Stub() {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.422 -0500", hash_original_method = "C8B58EDBD06F8EA7FBE41DD6A9CB7A63", hash_generated_method = "8F61206D9AB71A68AE33F8D10971F64D")
        
public void scanCompleted(String path, Uri uri) {
            MediaScannerConnectionClient client = mClient;
            if (client != null) {
                client.onScanCompleted(path, uri);
            }
        }
        
};

    /**
     * Constructs a new MediaScannerConnection object.
     * @param context the Context object, required for establishing a connection to
     * the media scanner service.
     * @param client an optional object implementing the MediaScannerConnectionClient
     * interface, for receiving notifications from the media scanner.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.433 -0500", hash_original_method = "02F68DBADAE09ADC564FCBE9896B1B21", hash_generated_method = "11BEE8129D21412A4ED41CA85B7B6808")
    
public MediaScannerConnection(Context context, MediaScannerConnectionClient client) {
        mContext = context;
        mClient = client;
    }

    /**
     * Initiates a connection to the media scanner service.
     * {@link MediaScannerConnectionClient#onMediaScannerConnected()}
     * will be called when the connection is established.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.437 -0500", hash_original_method = "103FF067C05F73BE25406E08AD5060BA", hash_generated_method = "F798A231F5738AA5B2E94D50413DAE94")
    
public void connect() {
        synchronized (this) {
            if (!mConnected) {
                Intent intent = new Intent(IMediaScannerService.class.getName());
                mContext.bindService(intent, this, Context.BIND_AUTO_CREATE);
                mConnected = true;
            }
        }
    }

    /**
     * Releases the connection to the media scanner service.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.440 -0500", hash_original_method = "34ACB974A6A90DB83EA01EBFF6ED0425", hash_generated_method = "D1D7E23D42A1DC71816D22051AB21482")
    
public void disconnect() {
        synchronized (this) {
            if (mConnected) {
                if (false) {
                    Log.v(TAG, "Disconnecting from Media Scanner");
                }
                try {
                    mContext.unbindService(this);
                } catch (IllegalArgumentException ex) {
                    if (false) {
                        Log.v(TAG, "disconnect failed: " + ex);
                    }
                }
                mConnected = false;
            }
        }
    }

    /**
     * Returns whether we are connected to the media scanner service
     * @return true if we are connected, false otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.442 -0500", hash_original_method = "585F124B91F8E6FD252A74E28C966933", hash_generated_method = "DE5506E0619C5D55A57989C7F13D26BD")
    
public synchronized boolean isConnected() {
        return (mService != null && mConnected);
    }

    /**
     * Requests the media scanner to scan a file.
     * Success or failure of the scanning operation cannot be determined until
     * {@link MediaScannerConnectionClient#onScanCompleted(String, Uri)} is called.
     *
     * @param path the path to the file to be scanned.
     * @param mimeType  an optional mimeType for the file.
     * If mimeType is null, then the mimeType will be inferred from the file extension.
     */
     @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.445 -0500", hash_original_method = "44D1DDF3433D1A77012EDDEA6B43D1B6", hash_generated_method = "297F495E8CE90656B562A8C878B10DBF")
    
public void scanFile(String path, String mimeType) {
        synchronized (this) {
            if (mService == null || !mConnected) {
                throw new IllegalStateException("not connected to MediaScannerService");
            }
            try {
                if (false) {
                    Log.v(TAG, "Scanning file " + path);
                }
                mService.requestScanFile(path, mimeType, mListener);
            } catch (RemoteException e) {
                if (false) {
                    Log.d(TAG, "Failed to scan file " + path);
                }
            }
        }
    }

    /**
     * Part of the ServiceConnection interface.  Do not call.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.476 -0500", hash_original_method = "7C78D6E78099891228F7F6E86F5F98DF", hash_generated_method = "8AF5D4C75C1210AB1230727C3B21FC1E")
    
public void onServiceConnected(ComponentName className, IBinder service) {
        if (false) {
            Log.v(TAG, "Connected to Media Scanner");
        }
        synchronized (this) {
            mService = IMediaScannerService.Stub.asInterface(service);
            if (mService != null && mClient != null) {
                mClient.onMediaScannerConnected();
            }
        }
    }
    
    static class ClientProxy implements MediaScannerConnectionClient {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.448 -0500", hash_original_field = "EF5B6E8084A495EAE41C937C524F43C7", hash_generated_field = "EF5B6E8084A495EAE41C937C524F43C7")

         String[] mPaths;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.450 -0500", hash_original_field = "97CE940966C9ECB62D16CE8136A149A4", hash_generated_field = "97CE940966C9ECB62D16CE8136A149A4")

         String[] mMimeTypes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.453 -0500", hash_original_field = "964F174AE8F48E2B1464BEF981E40142", hash_generated_field = "964F174AE8F48E2B1464BEF981E40142")

         OnScanCompletedListener mClient;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.455 -0500", hash_original_field = "3482B5DC69035E590153D933BCD94862", hash_generated_field = "3482B5DC69035E590153D933BCD94862")

        MediaScannerConnection mConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.458 -0500", hash_original_field = "E574DF4683F79023C0C7ECB451E7D391", hash_generated_field = "E574DF4683F79023C0C7ECB451E7D391")

        int mNextPath;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.461 -0500", hash_original_method = "507FCB3FA9852F504BF395AA069F1AE5", hash_generated_method = "507FCB3FA9852F504BF395AA069F1AE5")
        
ClientProxy(String[] paths, String[] mimeTypes, OnScanCompletedListener client) {
            mPaths = paths;
            mMimeTypes = mimeTypes;
            mClient = client;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.463 -0500", hash_original_method = "8C081453672AFB7A10A4B295346319E3", hash_generated_method = "4400FE60A3F2E474352349CF175D9C7F")
        
public void onMediaScannerConnected() {
            scanNextPath();
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.467 -0500", hash_original_method = "D5B152CD911B45918F84440EF851975F", hash_generated_method = "F0C40E338243C755C12F525E31F4F8B0")
        
public void onScanCompleted(String path, Uri uri) {
            if (mClient != null) {
                mClient.onScanCompleted(path, uri);
            }
            scanNextPath();
        }

        @DSComment("Package priviledge")
        @DSBan(DSCat.DEFAULT_MODIFIER)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.469 -0500", hash_original_method = "867E90DE2F95BCDF3C69A0A29D034AD3", hash_generated_method = "867E90DE2F95BCDF3C69A0A29D034AD3")
        
void scanNextPath() {
            if (mNextPath >= mPaths.length) {
                mConnection.disconnect();
                return;
            }
            String mimeType = mMimeTypes != null ? mMimeTypes[mNextPath] : null;
            mConnection.scanFile(mPaths[mNextPath], mimeType);
            mNextPath++;
        }
        
    }
    
    public interface OnScanCompletedListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onScanCompleted(String path, Uri uri);
    }
    
    public interface MediaScannerConnectionClient extends OnScanCompletedListener {
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onMediaScannerConnected();
        
        @DSComment("Abstract Method")
        @DSSpec(DSCat.ABSTRACT_METHOD)
        public void onScanCompleted(String path, Uri uri);
    }

    /**
     * Part of the ServiceConnection interface.  Do not call.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:28:23.479 -0500", hash_original_method = "95A47EFDF43A33BA0DC593830BA12E50", hash_generated_method = "A3E2EA943B41CE8C60AD013D989943EF")
    
public void onServiceDisconnected(ComponentName className) {
        if (false) {
            Log.v(TAG, "Disconnected from Media Scanner");
        }
        synchronized (this) {
            mService = null;
        }
    }
}

