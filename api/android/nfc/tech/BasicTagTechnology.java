package android.nfc.tech;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Log;
import droidsafe.annotations.*;
import java.io.IOException;

import android.nfc.ErrorCodes;
import android.nfc.Tag;
import android.nfc.TransceiveResult;
import android.os.RemoteException;

abstract class BasicTagTechnology implements TagTechnology {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.939 -0500", hash_original_field = "76B42502A850F1BA8F9A78C316486025", hash_generated_field = "BC8F11E4AEAD11E0412B7B53DF0CA6C8")

    private static final String TAG = "NFC";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.941 -0500", hash_original_field = "26F2563105474DD2A79B3C79190EB5BE", hash_generated_field = "26F2563105474DD2A79B3C79190EB5BE")
  Tag mTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.943 -0500", hash_original_field = "C55D9286978463BA48249377B65E8F9B", hash_generated_field = "C55D9286978463BA48249377B65E8F9B")
 boolean mIsConnected;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.945 -0500", hash_original_field = "14A56D04133B1EA444C84A98B6F4BAF8", hash_generated_field = "14A56D04133B1EA444C84A98B6F4BAF8")
 int mSelectedTechnology;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.948 -0500", hash_original_method = "D572C74E7520ED5167A849EF718161FC", hash_generated_method = "D572C74E7520ED5167A849EF718161FC")
    
BasicTagTechnology(Tag tag, int tech) throws RemoteException {
        mTag = tag;
        mSelectedTechnology = tech;
    }

    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.950 -0500", hash_original_method = "FC84E29499397B8918F938A8205313A1", hash_generated_method = "509C94592268C673EF77C66918B38D54")
    
@Override
    public Tag getTag() {
        return mTag;
    }

    /** Internal helper to throw IllegalStateException if the technology isn't connected */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.952 -0500", hash_original_method = "740AD223006A949AE0C5FC9EABD0A7B2", hash_generated_method = "740AD223006A949AE0C5FC9EABD0A7B2")
    
void checkConnected() {
       if ((mTag.getConnectedTechnology() != mSelectedTechnology) ||
               (mTag.getConnectedTechnology() == -1)) {
           throw new IllegalStateException("Call connect() first!");
       }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.954 -0500", hash_original_method = "627518FDA5BCF854C6C8A282AA02DD65", hash_generated_method = "2CF5AC6A9AA8D850AF0F2948A33A1BBB")
    
@Override
    public boolean isConnected() {
        if (!mIsConnected) {
            return false;
        }

        try {
            return mTag.getTagService().isPresent(mTag.getServiceHandle());
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return false;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.957 -0500", hash_original_method = "804D2A1436436AD53D4E3C21667A8A7D", hash_generated_method = "56A6598857DDBB1E31119C2682BDD7F1")
    
@Override
    public void connect() throws IOException {
        try {
            int errorCode = mTag.getTagService().connect(mTag.getServiceHandle(),
                    mSelectedTechnology);

            if (errorCode == ErrorCodes.SUCCESS) {
                // Store this in the tag object
                mTag.setConnectedTechnology(mSelectedTechnology);
                mIsConnected = true;
            } else if (errorCode == ErrorCodes.ERROR_NOT_SUPPORTED) {
                throw new UnsupportedOperationException("Connecting to " +
                        "this technology is not supported by the NFC " +
                        "adapter.");
            } else {
                throw new IOException();
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            throw new IOException("NFC service died");
        }
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.959 -0500", hash_original_method = "9693ABC23B7E982FA8E766A116B1D439", hash_generated_method = "7114F971726AE8B77FBABB277A3AC7C8")
    
@Override
    public void reconnect() throws IOException {
        if (!mIsConnected) {
            throw new IllegalStateException("Technology not connected yet");
        }

        try {
            int errorCode = mTag.getTagService().reconnect(mTag.getServiceHandle());

            if (errorCode != ErrorCodes.SUCCESS) {
                mIsConnected = false;
                mTag.setTechnologyDisconnected();
                throw new IOException();
            }
        } catch (RemoteException e) {
            mIsConnected = false;
            mTag.setTechnologyDisconnected();
            Log.e(TAG, "NFC service dead", e);
            throw new IOException("NFC service died");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.962 -0500", hash_original_method = "DDF274A17EF36B6492A33A14797987DB", hash_generated_method = "581A73B3DE4AC015F592D8F37409570F")
    
@Override
    public void close() throws IOException {
        try {
            /* Note that we don't want to physically disconnect the tag,
             * but just reconnect to it to reset its state
             */
            mTag.getTagService().resetTimeouts();
            mTag.getTagService().reconnect(mTag.getServiceHandle());
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
        } finally {
            mIsConnected = false;
            mTag.setTechnologyDisconnected();
        }
    }

    /** Internal getMaxTransceiveLength() */
    @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.965 -0500", hash_original_method = "34B3E57F39840A6B37FC716C1405DA5D", hash_generated_method = "34B3E57F39840A6B37FC716C1405DA5D")
    
int getMaxTransceiveLengthInternal() {
        try {
            return mTag.getTagService().getMaxTransceiveLength(mSelectedTechnology);
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            return 0;
        }
    }
    /** Internal transceive */
    /*package*/ @DSSource({DSSourceKind.NFC})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:48.967 -0500", hash_original_method = "8FB7A232CD74B358E0C2332FDF0D5629", hash_generated_method = "8FB7A232CD74B358E0C2332FDF0D5629")
    
byte[] transceive(byte[] data, boolean raw) throws IOException {
        checkConnected();

        try {
            TransceiveResult result = mTag.getTagService().transceive(mTag.getServiceHandle(),
                    data, raw);
            if (result == null) {
                throw new IOException("transceive failed");
            } else {
                return result.getResponseOrThrow();
            }
        } catch (RemoteException e) {
            Log.e(TAG, "NFC service dead", e);
            throw new IOException("NFC service died");
        }
    }
}

