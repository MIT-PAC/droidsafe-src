package android.webkit;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.net.http.EventHandler;
import android.net.http.Headers;
import android.os.Handler;
import android.os.Message;





abstract class StreamLoader implements Handler.Callback {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.448 -0500", hash_original_field = "BA0608C6B11945797C746BA9FCD1FB67", hash_generated_field = "116567EA42424CED6A518F03ECAEF9D0")


    private static final int MSG_STATUS = 100;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.451 -0500", hash_original_field = "E2A18147AC49D79948BBF5BF0A7BB520", hash_generated_field = "2560EAA9C0C83E19C62565F808C069B9")

    private static final int MSG_HEADERS = 101;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.453 -0500", hash_original_field = "D3A2E8BBFD02A172394991DABC4F1D7F", hash_generated_field = "B7C277C22A8740A16DB4ABF4E167CE64")

    private static final int MSG_DATA = 102;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.456 -0500", hash_original_field = "A3E984D8827653138F204025DF2828A5", hash_generated_field = "02484FCE1BED4E8C22849757523483A9")

    private static final int MSG_END = 103;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.458 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "B3359F86E29A965BC1436888E98C55A8")


    protected  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.460 -0500", hash_original_field = "469095379AEB9651D259E87F1B97E396", hash_generated_field = "E2AC94C6534F51915562E9E51CE4D893")

    protected  LoadListener mLoadListener;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.462 -0500", hash_original_field = "320B4C89537218FDC93BB66C3CDD2A79", hash_generated_field = "F182CEB3CE562DC3186CF7BAB9AD8EC7")

    protected InputStream mDataStream;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.464 -0500", hash_original_field = "43FA6B89410ACDDFB4B89F954A0B5BF7", hash_generated_field = "D56DA25B404AFDA8695ED0F36A7C56D4")

    protected long mContentLength;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.466 -0500", hash_original_field = "5D97F7C0534662C5183D05D4FFD1A145", hash_generated_field = "04254C7D5555806109D3DE22B9918A82")

    private byte [] mData;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.468 -0500", hash_original_field = "A163099B522120C606A3CA562F90E927", hash_generated_field = "0288BD825793D674670D619CC8A17A15")


    // Handler which will be initialized in the thread where load() is called.
    private Handler mHandler;

    /**
     * Constructor. Although this class calls the LoadListener, it only calls
     * the EventHandler Interface methods. LoadListener concrete class is used
     * to avoid the penality of calling an interface.
     *
     * @param loadlistener The LoadListener to call with the data.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.470 -0500", hash_original_method = "5C97985D356D0B8BED26A67B0D8173AD", hash_generated_method = "5C97985D356D0B8BED26A67B0D8173AD")
    
StreamLoader(LoadListener loadlistener) {
        mLoadListener = loadlistener;
        mContext = loadlistener.getContext();
    }

    /**
     * This method is called when the derived class should setup mDataStream,
     * and call mLoadListener.status() to indicate that the load can occur. If it
     * fails to setup, it should still call status() with the error code.
     *
     * @return true if stream was successfully setup
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.473 -0500", hash_original_method = "E85C43EBDEF851A6A0ECD12470692B56", hash_generated_method = "375CFDB1CC5CBA05F3B9BF82FC309522")
    
protected abstract boolean setupStreamAndSendStatus();

    /**
     * This method is called when the headers are about to be sent to the
     * load framework. The derived class has the opportunity to add addition
     * headers.
     *
     * @param headers Map of HTTP headers that will be sent to the loader.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.475 -0500", hash_original_method = "F5DF79E852C25F3930CA8E9B0C3908D7", hash_generated_method = "2EDFB7C27FECF21F038ACFC3824E7E29")
    
abstract protected void buildHeaders(Headers headers);

    /**
     * Calling this method starts the load of the content for this StreamLoader.
     * This method simply creates a Handler in the current thread and posts a
     * message to send the status and returns immediately.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.477 -0500", hash_original_method = "9A005467E60C2D9227C099A6A0EA45F6", hash_generated_method = "6A3D2FCA161C2CAC23E96A8966B1DEF7")
    
final void load() {
        synchronized (this) {
            if (mHandler == null) {
                mHandler = new Handler(this);
            }
        }

        if (!mLoadListener.isSynchronous()) {
            mHandler.sendEmptyMessage(MSG_STATUS);
        } else {
            // Load the stream synchronously.
            if (setupStreamAndSendStatus()) {
                // We were able to open the stream, create the array
                // to pass data to the loader
                mData = new byte[8192];
                sendHeaders();
                while (!sendData() && !mLoadListener.cancelled());
                closeStreamAndSendEndData();
                mLoadListener.loadSynchronousMessages();
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.480 -0500", hash_original_method = "00FB85FDD84A2FA0A52746CD7D8A6203", hash_generated_method = "242A5A5E63A12E7A78FEFB6E31CB9BDB")
    
public boolean handleMessage(Message msg) {
        if (mLoadListener.isSynchronous()) {
            throw new AssertionError();
        }
        if (mLoadListener.cancelled()) {
            closeStreamAndSendEndData();
            return true;
        }
        switch(msg.what) {
            case MSG_STATUS:
                if (setupStreamAndSendStatus()) {
                    // We were able to open the stream, create the array
                    // to pass data to the loader
                    mData = new byte[8192];
                    mHandler.sendEmptyMessage(MSG_HEADERS);
                }
                break;
            case MSG_HEADERS:
                sendHeaders();
                mHandler.sendEmptyMessage(MSG_DATA);
                break;
            case MSG_DATA:
                if (sendData()) {
                    mHandler.sendEmptyMessage(MSG_END);
                } else {
                    mHandler.sendEmptyMessage(MSG_DATA);
                }
                break;
            case MSG_END:
                closeStreamAndSendEndData();
                break;
            default:
                return false;
        }
        return true;
    }

    /**
     * Construct the headers and pass them to the EventHandler.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.482 -0500", hash_original_method = "65A84C3A774E903513B92EB5B550F331", hash_generated_method = "74B1B6A78C0F26CEA1A577531FB96C5B")
    
private void sendHeaders() {
        Headers headers = new Headers();
        if (mContentLength > 0) {
            headers.setContentLength(mContentLength);
        }
        buildHeaders(headers);
        mLoadListener.headers(headers);
    }

    /**
     * Read data from the stream and pass it to the EventHandler.
     * If an error occurs reading the stream, then an error is sent to the
     * EventHandler, and moves onto the next state - end of data.
     * @return True if all the data has been read. False if sendData should be
     *         called again.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.485 -0500", hash_original_method = "4C4D4DF9D04A987F005277A578061144", hash_generated_method = "629106C0C894E0B189989BB0005C5456")
    
private boolean sendData() {
        if (mDataStream != null) {
            try {
                int amount = mDataStream.read(mData);
                if (amount > 0) {
                    mLoadListener.data(mData, amount);
                    return false;
                }
            } catch (IOException ex) {
                mLoadListener.error(EventHandler.FILE_ERROR, ex.getMessage());
            }
        }
        return true;
    }

    /**
     * Close the stream and inform the EventHandler that load is complete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:32:47.487 -0500", hash_original_method = "1E3300194DB856434710C1AC838853B7", hash_generated_method = "B74557C5D73AC0B9A0C54F5C177F3878")
    
private void closeStreamAndSendEndData() {
        if (mDataStream != null) {
            try {
                mDataStream.close();
            } catch (IOException ex) {
                // ignore.
            }
        }
        mLoadListener.endData();
    }
}

