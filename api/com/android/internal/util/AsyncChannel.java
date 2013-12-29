package com.android.internal.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Stack;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Slog;





public class AsyncChannel {

    /**
     * Log the string.
     *
     * @param s
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.371 -0500", hash_original_method = "6FCA9AA6353D4B452135E8444180D2C6", hash_generated_method = "BDA28BABE71D91786DFE8D4E9E911424")
    private static void log(String s) {
        Slog.d(TAG, s);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.302 -0500", hash_original_field = "95A8D559154803A1416476EBC0AF2D32", hash_generated_field = "ED89618E6E1B400B84A83667045BD90E")

    private static final String TAG = "AsyncChannel";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.303 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.304 -0500", hash_original_field = "2047023046CD71CF4AAF6B2B3DA0FA39", hash_generated_field = "080FE22C2EA5E5AA1B11A1E7CA05F0C9")


    private static final int BASE = Protocol.BASE_SYSTEM_ASYNC_CHANNEL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.305 -0500", hash_original_field = "3480C29848F7CC2D4F1A632387FA28BE", hash_generated_field = "5922F98D688E75A7DA6D8670F04E1B69")

    public static final int CMD_CHANNEL_HALF_CONNECTED = BASE + 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.306 -0500", hash_original_field = "DB2AB601D2852F7271410A5E57662D22", hash_generated_field = "09022465BCC7090283436B7B026D0301")

    public static final int CMD_CHANNEL_FULL_CONNECTION = BASE + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.307 -0500", hash_original_field = "54CB95D77CCCF845D73D9692B7CFFC87", hash_generated_field = "08BDA67F386A31687D7F2E728CCB59EF")

    public static final int CMD_CHANNEL_FULLY_CONNECTED = BASE + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.308 -0500", hash_original_field = "8EA595A253E0AEF90BF7320DC78E1FC6", hash_generated_field = "5CF66347F536B38BA730A7CEF6E0CFE9")

    public static final int CMD_CHANNEL_DISCONNECT = BASE + 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.308 -0500", hash_original_field = "C497168A3DCC02CA3C5B705C9036FCBA", hash_generated_field = "6D1D7878C43DD2115A6EF5986CC11811")

    public static final int CMD_CHANNEL_DISCONNECTED = BASE + 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.309 -0500", hash_original_field = "89692847E6BD0F83A12707A04DBD5FCA", hash_generated_field = "BE2B5B401DA0D15F4F87FD186400D2D9")

    public static final int STATUS_SUCCESSFUL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.310 -0500", hash_original_field = "6E8176F9BC447172AE9E461B283D8B55", hash_generated_field = "B8538B9846A8FDBE9642FF7E31DD496A")

    public static final int STATUS_BINDING_UNSUCCESSFUL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.311 -0500", hash_original_field = "6A81C204E1119C0E075B6140442C7BBD", hash_generated_field = "CB11C33E8E76C086F8C44E0468197078")

    public static final int STATUS_SEND_UNSUCCESSFUL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.312 -0500", hash_original_field = "482E69F0E1A82A5C7C3C4B9F83A7A30E", hash_generated_field = "E6FE28BA2B9755538A9039337B98C62B")

    public static final int STATUS_FULL_CONNECTION_REFUSED_ALREADY_CONNECTED = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.313 -0500", hash_original_field = "F4471023D55D85B2ED3D88D3F14E604B", hash_generated_field = "E0FE31041D4B400F1ECC0924DC307F23")

    private AsyncChannelConnection mConnection;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.314 -0500", hash_original_field = "5917DF89E53660C9A2AFB2773E027958", hash_generated_field = "D92C09EC63748E6484EE8DFEB808CFD6")

    private Context mSrcContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.314 -0500", hash_original_field = "6BB20412E591A6DA226F8B270B002CC6", hash_generated_field = "BD0D117ED673366AC3516437E5A4C86B")

    private Handler mSrcHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.316 -0500", hash_original_field = "1F1D6034E598F0E0F1B4062DC6C5520C", hash_generated_field = "ADFCAC580CFA427EE53B41262D89A4AC")

    private Messenger mSrcMessenger;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.316 -0500", hash_original_field = "78711A7D09B1AE1F7B43A7045E087D16", hash_generated_field = "12D94F9D13B393CF02D9A14BBEC89054")

    private Messenger mDstMessenger;

    /**
     * AsyncChannel constructor
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.317 -0500", hash_original_method = "FDD6D3EF5F7BC7D6883E0BF7536BB913", hash_generated_method = "7B270163FB00B2D668E83F5F3AC47A37")
    public AsyncChannel() {
    }

    /**
     * Connect handler to named package/class synchronously.
     *
     * @param srcContext is the context of the source
     * @param srcHandler is the hander to receive CONNECTED & DISCONNECTED
     *            messages
     * @param dstPackageName is the destination package name
     * @param dstClassName is the fully qualified class name (i.e. contains
     *            package name)
     *
     * @return STATUS_SUCCESSFUL on success any other value is an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.318 -0500", hash_original_method = "89C8C4B82DB5AC36CAD55D59C7A76E33", hash_generated_method = "1F9346CADD06FBFF3294E9C4A4C60388")
    public int connectSrcHandlerToPackageSync(
            Context srcContext, Handler srcHandler, String dstPackageName, String dstClassName) {
        if (DBG) log("connect srcHandler to dst Package & class E");

        mConnection = new AsyncChannelConnection();

        /* Initialize the source information */
        mSrcContext = srcContext;
        mSrcHandler = srcHandler;
        mSrcMessenger = new Messenger(srcHandler);

        /*
         * Initialize destination information to null they will
         * be initialized when the AsyncChannelConnection#onServiceConnected
         * is called
         */
        mDstMessenger = null;

        /* Send intent to create the connection */
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(dstPackageName, dstClassName);
        boolean result = srcContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        if (DBG) log("connect srcHandler to dst Package & class X result=" + result);
        return result ? STATUS_SUCCESSFUL : STATUS_BINDING_UNSUCCESSFUL;
    }

    /**
     * Connect a handler to Messenger synchronously.
     *
     * @param srcContext is the context of the source
     * @param srcHandler is the hander to receive CONNECTED & DISCONNECTED
     *            messages
     * @param dstMessenger is the hander to send messages to.
     *
     * @return STATUS_SUCCESSFUL on success any other value is an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.319 -0500", hash_original_method = "ABB64391FEF3212581FCE62A24663F37", hash_generated_method = "5D650CF88D5D3982DDC619DAC8596630")
    public int connectSync(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        if (DBG) log("halfConnectSync srcHandler to the dstMessenger  E");

        // We are connected
        connected(srcContext, srcHandler, dstMessenger);

        if (DBG) log("halfConnectSync srcHandler to the dstMessenger X");
        return STATUS_SUCCESSFUL;
    }

    /**
     * connect two local Handlers synchronously.
     *
     * @param srcContext is the context of the source
     * @param srcHandler is the hander to receive CONNECTED & DISCONNECTED
     *            messages
     * @param dstHandler is the hander to send messages to.
     *
     * @return STATUS_SUCCESSFUL on success any other value is an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.320 -0500", hash_original_method = "E8061690950B5AC4037948D29BFD7764", hash_generated_method = "8302A676A8C20EDE123C534A387EF955")
    public int connectSync(Context srcContext, Handler srcHandler, Handler dstHandler) {
        return connectSync(srcContext, srcHandler, new Messenger(dstHandler));
    }

    /**
     * Fully connect two local Handlers synchronously.
     *
     * @param srcContext is the context of the source
     * @param srcHandler is the hander to receive CONNECTED & DISCONNECTED
     *            messages
     * @param dstHandler is the hander to send messages to.
     *
     * @return STATUS_SUCCESSFUL on success any other value is an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.321 -0500", hash_original_method = "47E7CF94088222D35244DD2A346F6D10", hash_generated_method = "E19E8E64771431B6C6256E770157CA8B")
    public int fullyConnectSync(Context srcContext, Handler srcHandler, Handler dstHandler) {
        int status = connectSync(srcContext, srcHandler, dstHandler);
        if (status == STATUS_SUCCESSFUL) {
            Message response = sendMessageSynchronously(CMD_CHANNEL_FULL_CONNECTION);
            status = response.arg1;
        }
        return status;
    }

    /**
     * Connect handler to named package/class.
     *
     * Sends a CMD_CHANNEL_HALF_CONNECTED message to srcHandler when complete.
     *      msg.arg1 = status
     *      msg.obj = the AsyncChannel
     *
     * @param srcContext is the context of the source
     * @param srcHandler is the hander to receive CONNECTED & DISCONNECTED
     *            messages
     * @param dstPackageName is the destination package name
     * @param dstClassName is the fully qualified class name (i.e. contains
     *            package name)
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.327 -0500", hash_original_method = "D2A6022ADF54D8001301F184CF4606D0", hash_generated_method = "2E6273C4271CC00F55FB791C2B3B78E7")
    public void connect(Context srcContext, Handler srcHandler, String dstPackageName,
            String dstClassName) {
        if (DBG) log("connect srcHandler to dst Package & class E");

        final class ConnectAsync implements Runnable {
            Context mSrcCtx;
            Handler mSrcHdlr;
            String mDstPackageName;
            String mDstClassName;

            ConnectAsync(Context srcContext, Handler srcHandler, String dstPackageName,
                    String dstClassName) {
                mSrcCtx = srcContext;
                mSrcHdlr = srcHandler;
                mDstPackageName = dstPackageName;
                mDstClassName = dstClassName;
            }

            @Override
            public void run() {
                int result = connectSrcHandlerToPackageSync(mSrcCtx, mSrcHdlr, mDstPackageName,
                        mDstClassName);
                replyHalfConnected(result);
            }
        }

        ConnectAsync ca = new ConnectAsync(srcContext, srcHandler, dstPackageName, dstClassName);
        new Thread(ca).start();

        if (DBG) log("connect srcHandler to dst Package & class X");
    }

    /**
     * Connect handler to a class
     *
     * Sends a CMD_CHANNEL_HALF_CONNECTED message to srcHandler when complete.
     *      msg.arg1 = status
     *      msg.obj = the AsyncChannel
     *
     * @param srcContext
     * @param srcHandler
     * @param klass is the class to send messages to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.328 -0500", hash_original_method = "EF115B092B0444968DFDE421B1D070CE", hash_generated_method = "C7D761A604DCC217929B7918AB961994")
    public void connect(Context srcContext, Handler srcHandler, Class<?> klass) {
        connect(srcContext, srcHandler, klass.getPackage().getName(), klass.getName());
    }

    /**
     * Connect handler and messenger.
     *
     * Sends a CMD_CHANNEL_HALF_CONNECTED message to srcHandler when complete.
     *      msg.arg1 = status
     *      msg.obj = the AsyncChannel
     *
     * @param srcContext
     * @param srcHandler
     * @param dstMessenger
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.329 -0500", hash_original_method = "D9A9DAD002038F54D59084B945A008ED", hash_generated_method = "4C9173AD3605BE46EEB06DBE1A2B9E52")
    public void connect(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        if (DBG) log("connect srcHandler to the dstMessenger  E");

        // We are connected
        connected(srcContext, srcHandler, dstMessenger);

        // Tell source we are half connected
        replyHalfConnected(STATUS_SUCCESSFUL);

        if (DBG) log("connect srcHandler to the dstMessenger X");
    }

    /**
     * Connect handler to messenger. This method is typically called
     * when a server receives a CMD_CHANNEL_FULL_CONNECTION request
     * and initializes the internal instance variables to allow communication
     * with the dstMessenger.
     *
     * @param srcContext
     * @param srcHandler
     * @param dstMessenger
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.330 -0500", hash_original_method = "6B74CB8285045DC3058688AFD39174C7", hash_generated_method = "D21EC7D6F55E6DDB571DC2CC93C25E59")
    public void connected(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        if (DBG) log("connected srcHandler to the dstMessenger  E");

        // Initialize source fields
        mSrcContext = srcContext;
        mSrcHandler = srcHandler;
        mSrcMessenger = new Messenger(mSrcHandler);

        // Initialize destination fields
        mDstMessenger = dstMessenger;

        if (DBG) log("connected srcHandler to the dstMessenger X");
    }

    /**
     * Connect two local Handlers.
     *
     * @param srcContext is the context of the source
     * @param srcHandler is the hander to receive CONNECTED & DISCONNECTED
     *            messages
     * @param dstHandler is the hander to send messages to.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.331 -0500", hash_original_method = "30351ACDB73035A90D0CFF564E4380CE", hash_generated_method = "48DADB4CE0ACD3C0C678FBD72552DA66")
    public void connect(Context srcContext, Handler srcHandler, Handler dstHandler) {
        connect(srcContext, srcHandler, new Messenger(dstHandler));
    }

    /**
     * Connect service and messenger.
     *
     * Sends a CMD_CHANNEL_HALF_CONNECTED message to srcAsyncService when complete.
     *      msg.arg1 = status
     *      msg.obj = the AsyncChannel
     *
     * @param srcAsyncService
     * @param dstMessenger
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.332 -0500", hash_original_method = "AB6DAC74FF8B2E5B9FEB974F6DCFF3D6", hash_generated_method = "87BDA9A9972ECA7310DB39F217B483FA")
    public void connect(AsyncService srcAsyncService, Messenger dstMessenger) {
        connect(srcAsyncService, srcAsyncService.getHandler(), dstMessenger);
    }

    /**
     * To close the connection call when handler receives CMD_CHANNEL_DISCONNECTED
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.333 -0500", hash_original_method = "C231E33C68F8FEC3C6EDCF993CA1BD7A", hash_generated_method = "60AE8F641AB448C2AE7DFA7C6F9FF823")
    public void disconnected() {
        mSrcContext = null;
        mSrcHandler = null;
        mSrcMessenger = null;
        mDstMessenger = null;
        mConnection = null;
    }

    /**
     * Disconnect
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.334 -0500", hash_original_method = "206D442C26BC964C7153F638F49072D1", hash_generated_method = "2C42D0809BF4810FABDA72F0A6E05C53")
    public void disconnect() {
        if ((mConnection != null) && (mSrcContext != null)) {
            mSrcContext.unbindService(mConnection);
        }
        if (mSrcHandler != null) {
            replyDisconnected(STATUS_SUCCESSFUL);
        }
    }

    /**
     * Send a message to the destination handler.
     *
     * @param msg
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.335 -0500", hash_original_method = "9DAC7AFA4C14A1022E9DEC304018391F", hash_generated_method = "B2E7772166FCACAF852F55F44CB46D51")
    public void sendMessage(Message msg) {
        msg.replyTo = mSrcMessenger;
        try {
            mDstMessenger.send(msg);
        } catch (RemoteException e) {
            replyDisconnected(STATUS_SEND_UNSUCCESSFUL);
        }
    }

    /**
     * Send a message to the destination handler
     *
     * @param what
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.336 -0500", hash_original_method = "C8C31043DDFE26EC3BE146F1B2B418E3", hash_generated_method = "4278121A770EE39DDEB6E37D007DBBC8")
    public void sendMessage(int what) {
        Message msg = Message.obtain();
        msg.what = what;
        sendMessage(msg);
    }

    /**
     * Send a message to the destination handler
     *
     * @param what
     * @param arg1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.337 -0500", hash_original_method = "6C3F9593FC3095346100149D0CBBAD3F", hash_generated_method = "74BFDE300F5DD4E078EA04A4A8181904")
    public void sendMessage(int what, int arg1) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        sendMessage(msg);
    }

    /**
     * Send a message to the destination handler
     *
     * @param what
     * @param arg1
     * @param arg2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.337 -0500", hash_original_method = "23E4A4D5EBFE681605B0582F17F8E799", hash_generated_method = "2407FCFDBD809792EEC39AD82D87DDCA")
    public void sendMessage(int what, int arg1, int arg2) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        sendMessage(msg);
    }

    /**
     * Send a message to the destination handler
     *
     * @param what
     * @param arg1
     * @param arg2
     * @param obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.338 -0500", hash_original_method = "066946089A5EEE9700468FE67EE373C2", hash_generated_method = "39D30A18E3CBA1A0CA0CA065CE6FFE58")
    public void sendMessage(int what, int arg1, int arg2, Object obj) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        sendMessage(msg);
    }

    /**
     * Send a message to the destination handler
     *
     * @param what
     * @param obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.339 -0500", hash_original_method = "D262961B9C2C88432C23CE1E616C0D35", hash_generated_method = "E58A9FC8C58B34F13DDC5C274B23CB07")
    public void sendMessage(int what, Object obj) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        sendMessage(msg);
    }

    /**
     * Reply to srcMsg sending dstMsg
     *
     * @param srcMsg
     * @param dstMsg
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.340 -0500", hash_original_method = "9F609FC4DF465EEA0A9F2C3A79A2C6B4", hash_generated_method = "B9D65B71D31F113C9D169E78F4EAE96E")
    public void replyToMessage(Message srcMsg, Message dstMsg) {
        try {
            dstMsg.replyTo = mSrcMessenger;
            srcMsg.replyTo.send(dstMsg);
        } catch (RemoteException e) {
            log("TODO: handle replyToMessage RemoteException" + e);
            e.printStackTrace();
        }
    }

    /**
     * Reply to srcMsg
     *
     * @param srcMsg
     * @param what
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.341 -0500", hash_original_method = "BD4B3A181E1CE5BF498106AFACED886D", hash_generated_method = "30CA07B05F86A174B85EE2CBAC1889BC")
    public void replyToMessage(Message srcMsg, int what) {
        Message msg = Message.obtain();
        msg.what = what;
        replyToMessage(srcMsg, msg);
    }

    
    private static class SyncMessenger {

        /**
         * @return the SyncMessenger
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.362 -0500", hash_original_method = "6842F7631484B475B06161058D6842E6", hash_generated_method = "59982E7C0D8FDD0B2B29D39E7BB14C2B")
        private static SyncMessenger obtain() {
            SyncMessenger sm;
            synchronized (sStack) {
                if (sStack.isEmpty()) {
                    sm = new SyncMessenger();
                    sm.mHandlerThread = new HandlerThread("SyncHandler-" + sCount++);
                    sm.mHandlerThread.start();
                    sm.mHandler = sm.new SyncHandler(sm.mHandlerThread.getLooper());
                    sm.mMessenger = new Messenger(sm.mHandler);
                } else {
                    sm = sStack.pop();
                }
            }
            return sm;
        }

        /**
         * Send a message synchronously.
         *
         * @param msg to send
         * @return result message or null if an error occurs
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.364 -0500", hash_original_method = "73417FF22870072B41D9E8892C6ACEAF", hash_generated_method = "98D30C9AEE1B66AD2FCFA7D7A2E2B430")
        private static Message sendMessageSynchronously(Messenger dstMessenger, Message msg) {
            SyncMessenger sm = SyncMessenger.obtain();
            try {
                if (dstMessenger != null && msg != null) {
                    msg.replyTo = sm.mMessenger;
                    synchronized (sm.mHandler.mLockObject) {
                        dstMessenger.send(msg);
                        sm.mHandler.mLockObject.wait();
                    }
                } else {
                    sm.mHandler.mResultMsg = null;
                }
            } catch (InterruptedException e) {
                sm.mHandler.mResultMsg = null;
            } catch (RemoteException e) {
                sm.mHandler.mResultMsg = null;
            }
            Message resultMsg = sm.mHandler.mResultMsg;
            sm.recycle();
            return resultMsg;
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.351 -0500", hash_original_field = "44D8B304FF0825ED15C01664A684AE43", hash_generated_field = "F3416F3570137CC324435FDCE21F667F")

        private static Stack<SyncMessenger> sStack = new Stack<SyncMessenger>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.352 -0500", hash_original_field = "FB6343B76EE64852803F4660B30FE5B9", hash_generated_field = "0416DF7181AEB41469BF60FA4A630909")

        private static int sCount = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.353 -0500", hash_original_field = "7832E10F24770DD5CAC6B982304E164E", hash_generated_field = "3DDB918E56B395BB39CEA1B60967B4FA")

        private HandlerThread mHandlerThread;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.354 -0500", hash_original_field = "D1D93C6A9AA80D42503B85A2E5071210", hash_generated_field = "F1B2A09EB6C60E9B00FCB576607A28F3")

        private SyncHandler mHandler;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.355 -0500", hash_original_field = "8B6DF3488BAD8021770FD91E0323D045", hash_generated_field = "EF6FF2C2BD8A30E297033DA686E82F32")

        private Messenger mMessenger;

        
        private class SyncHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.357 -0500", hash_original_field = "A30922BDA37A1ABC6EAFB02E5CFDF21E", hash_generated_field = "F4ED03908BB0903225C1F23BCCA22B59")

            private Object mLockObject = new Object();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.358 -0500", hash_original_field = "F104CEF064CE711A728BFA78771B4DB7", hash_generated_field = "1581C98D68E5DB7A76672FB90829B905")

            private Message mResultMsg;

            /** Constructor */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.359 -0500", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "162EE86AD77E39FC7FB5466CD2B2FA31")
            private SyncHandler(Looper looper) {
                super(looper);
            }

            /** Handle of the reply message */
            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.361 -0500", hash_original_method = "2469457C965E8FC7C139A1D414384428", hash_generated_method = "42C86E9B0B120923F19E3F5FDF13C046")
            @Override
public void handleMessage(Message msg) {
                mResultMsg = Message.obtain();
                mResultMsg.copyFrom(msg);
                synchronized(mLockObject) {
                    mLockObject.notify();
                }
            }

            
        }

        /** private constructor */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.356 -0500", hash_original_method = "836D007993A4B13DC1AF265962B161E2", hash_generated_method = "CE56A48956738928E715C01B16E44A32")
        private SyncMessenger() {
        }

        /**
         * Recycle this object
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.363 -0500", hash_original_method = "FF57C371186B795A0CEFC17D6A21913E", hash_generated_method = "611CD75D4F68FA4F8A749A0A3935CD3E")
        private void recycle() {
            synchronized (sStack) {
                sStack.push(this);
            }
        }
    }


    
    class AsyncChannelConnection implements ServiceConnection {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.368 -0500", hash_original_method = "5CA2E7F994E5D5CA10120B6A293C36BC", hash_generated_method = "5CA2E7F994E5D5CA10120B6A293C36BC")
        AsyncChannelConnection() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.369 -0500", hash_original_method = "0E2027B9824173FAE83BA1B2B965BB96", hash_generated_method = "83656E4DC5DA7B5C38300C15CF4CEDC9")
        @Override
public void onServiceConnected(ComponentName className, IBinder service) {
            mDstMessenger = new Messenger(service);
            replyHalfConnected(STATUS_SUCCESSFUL);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.369 -0500", hash_original_method = "050AF9875EBB5531901E44E1327B5019", hash_generated_method = "4820F9F47CB085274AF4F450BDE93F1D")
        @Override
public void onServiceDisconnected(ComponentName className) {
            replyDisconnected(STATUS_SUCCESSFUL);
        }

        
    }

    /**
     * Reply to srcMsg
     *
     * @param srcMsg
     * @param what
     * @param arg1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.342 -0500", hash_original_method = "3044254AB71061FF974CD0BBDD0D9BC5", hash_generated_method = "AB88D3EC467AC5EB0755042C58CA48D6")
    public void replyToMessage(Message srcMsg, int what, int arg1) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        replyToMessage(srcMsg, msg);
    }

    /**
     * Reply to srcMsg
     *
     * @param srcMsg
     * @param what
     * @param arg1
     * @param arg2
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.342 -0500", hash_original_method = "DA98F71F7AF234EE48D27745943E51D8", hash_generated_method = "10C67902A1722E17522D578EE4DF0395")
    public void replyToMessage(Message srcMsg, int what, int arg1, int arg2) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        replyToMessage(srcMsg, msg);
    }

    /**
     * Reply to srcMsg
     *
     * @param srcMsg
     * @param what
     * @param arg1
     * @param arg2
     * @param obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.343 -0500", hash_original_method = "69829FBE15E20ADBF8C45DA9DA2D1745", hash_generated_method = "6825C0FB6336688E464A7DD79DC4298D")
    public void replyToMessage(Message srcMsg, int what, int arg1, int arg2, Object obj) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        replyToMessage(srcMsg, msg);
    }

    /**
     * Reply to srcMsg
     *
     * @param srcMsg
     * @param what
     * @param obj
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.344 -0500", hash_original_method = "7A8712370119BFFFB8554DE52F815A80", hash_generated_method = "FE54F644B4F66941ECFA28250BF16714")
    public void replyToMessage(Message srcMsg, int what, Object obj) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        replyToMessage(srcMsg, msg);
    }

    /**
     * Send the Message synchronously.
     *
     * @param msg to send
     * @return reply message or null if an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.345 -0500", hash_original_method = "44E20F477AE4DBE39F2143CAA1307C1F", hash_generated_method = "36868A8632F5BB2EF68675431B9B2D63")
    public Message sendMessageSynchronously(Message msg) {
        Message resultMsg = SyncMessenger.sendMessageSynchronously(mDstMessenger, msg);
        return resultMsg;
    }

    /**
     * Send the Message synchronously.
     *
     * @param what
     * @return reply message or null if an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.346 -0500", hash_original_method = "42BD69B2114459AD691B3AEBDAE73546", hash_generated_method = "C285A4D23EAB85D82915D70E1F66F84C")
    public Message sendMessageSynchronously(int what) {
        Message msg = Message.obtain();
        msg.what = what;
        Message resultMsg = sendMessageSynchronously(msg);
        return resultMsg;
    }

    /**
     * Send the Message synchronously.
     *
     * @param what
     * @param arg1
     * @return reply message or null if an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.347 -0500", hash_original_method = "69DA3E1B323882B9D4B744C6E35751A3", hash_generated_method = "60004DC4003AFFE42822995754840E35")
    public Message sendMessageSynchronously(int what, int arg1) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        Message resultMsg = sendMessageSynchronously(msg);
        return resultMsg;
    }

    /**
     * Send the Message synchronously.
     *
     * @param what
     * @param arg1
     * @param arg2
     * @return reply message or null if an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.347 -0500", hash_original_method = "AFDADB0B0E37C71FB8D4BE31CA39F990", hash_generated_method = "B6827FF2C6A650BBE4692173D7372E8C")
    public Message sendMessageSynchronously(int what, int arg1, int arg2) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        Message resultMsg = sendMessageSynchronously(msg);
        return resultMsg;
    }

    /**
     * Send the Message synchronously.
     *
     * @param what
     * @param arg1
     * @param arg2
     * @param obj
     * @return reply message or null if an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.348 -0500", hash_original_method = "EEAA69B320108852E46A6304535CC9F5", hash_generated_method = "D642B9F06D082255CC2F6570E4A84B40")
    public Message sendMessageSynchronously(int what, int arg1, int arg2, Object obj) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        Message resultMsg = sendMessageSynchronously(msg);
        return resultMsg;
    }

    /**
     * Send the Message synchronously.
     *
     * @param what
     * @param obj
     * @return reply message or null if an error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.349 -0500", hash_original_method = "35A5E39A8A1820326BDEA32FA9EDD100", hash_generated_method = "CE016FA9F8D335C8879BF83223FA7CD6")
    public Message sendMessageSynchronously(int what, Object obj) {
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        Message resultMsg = sendMessageSynchronously(msg);
        return resultMsg;
    }

    /**
     * Reply to the src handler that we're half connected.
     * see: CMD_CHANNEL_HALF_CONNECTED for message contents
     *
     * @param status to be stored in msg.arg1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.366 -0500", hash_original_method = "DECE161063975CD41C076FDB9612D509", hash_generated_method = "F774B739C33D0D5630FC3BFA9F4F988D")
    private void replyHalfConnected(int status) {
        Message msg = mSrcHandler.obtainMessage(CMD_CHANNEL_HALF_CONNECTED);
        msg.arg1 = status;
        msg.obj = this;
        msg.replyTo = mDstMessenger;
        mSrcHandler.sendMessage(msg);
    }

    /**
     * Reply to the src handler that we are disconnected
     * see: CMD_CHANNEL_DISCONNECTED for message contents
     *
     * @param status to be stored in msg.arg1
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:40.367 -0500", hash_original_method = "6CA7282E928AA840C6D25E995C5EBFEA", hash_generated_method = "EE2364AE0179C423F2BD973FF5B92F49")
    private void replyDisconnected(int status) {
        Message msg = mSrcHandler.obtainMessage(CMD_CHANNEL_DISCONNECTED);
        msg.arg1 = status;
        msg.obj = this;
        msg.replyTo = mDstMessenger;
        mSrcHandler.sendMessage(msg);
    }
}

