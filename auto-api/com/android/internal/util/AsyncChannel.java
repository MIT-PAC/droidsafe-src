package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
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
import java.util.Stack;

public class AsyncChannel {
    private static String TAG = "AsyncChannel";
    private static boolean DBG = false;
    private static int BASE = Protocol.BASE_SYSTEM_ASYNC_CHANNEL;
    public static int CMD_CHANNEL_HALF_CONNECTED = BASE + 0;
    public static int CMD_CHANNEL_FULL_CONNECTION = BASE + 1;
    public static int CMD_CHANNEL_FULLY_CONNECTED = BASE + 2;
    public static int CMD_CHANNEL_DISCONNECT = BASE + 3;
    public static int CMD_CHANNEL_DISCONNECTED = BASE + 4;
    public static int STATUS_SUCCESSFUL = 0;
    public static int STATUS_BINDING_UNSUCCESSFUL = 1;
    public static int STATUS_SEND_UNSUCCESSFUL = 2;
    public static int STATUS_FULL_CONNECTION_REFUSED_ALREADY_CONNECTED = 3;
    private AsyncChannelConnection mConnection;
    private Context mSrcContext;
    private Handler mSrcHandler;
    private Messenger mSrcMessenger;
    private Messenger mDstMessenger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.113 -0400", hash_original_method = "FDD6D3EF5F7BC7D6883E0BF7536BB913", hash_generated_method = "F593C2CA8EBB33C1A5AAA2C2C1E294F5")
    @DSModeled(DSC.SAFE)
    public AsyncChannel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.151 -0400", hash_original_method = "89C8C4B82DB5AC36CAD55D59C7A76E33", hash_generated_method = "822FDF893CAA7F84AEA9994A5861DA62")
    @DSModeled(DSC.SAFE)
    public int connectSrcHandlerToPackageSync(
            Context srcContext, Handler srcHandler, String dstPackageName, String dstClassName) {
        dsTaint.addTaint(dstClassName);
        dsTaint.addTaint(dstPackageName);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        log("connect srcHandler to dst Package & class E");
        mConnection = new AsyncChannelConnection();
        mSrcMessenger = new Messenger(srcHandler);
        mDstMessenger = null;
        Intent intent;
        intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(dstPackageName, dstClassName);
        boolean result;
        result = srcContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        log("connect srcHandler to dst Package & class X result=" + result);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("connect srcHandler to dst Package & class E");
        //mConnection = new AsyncChannelConnection();
        //mSrcContext = srcContext;
        //mSrcHandler = srcHandler;
        //mSrcMessenger = new Messenger(srcHandler);
        //mDstMessenger = null;
        //Intent intent = new Intent(Intent.ACTION_MAIN);
        //intent.setClassName(dstPackageName, dstClassName);
        //boolean result = srcContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        //if (DBG) log("connect srcHandler to dst Package & class X result=" + result);
        //return result ? STATUS_SUCCESSFUL : STATUS_BINDING_UNSUCCESSFUL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.198 -0400", hash_original_method = "ABB64391FEF3212581FCE62A24663F37", hash_generated_method = "DE9F31FEAA87AEC49F96C8FBFD71E69C")
    @DSModeled(DSC.SAFE)
    public int connectSync(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(dstMessenger.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        log("halfConnectSync srcHandler to the dstMessenger  E");
        connected(srcContext, srcHandler, dstMessenger);
        log("halfConnectSync srcHandler to the dstMessenger X");
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (DBG) log("halfConnectSync srcHandler to the dstMessenger  E");
        //connected(srcContext, srcHandler, dstMessenger);
        //if (DBG) log("halfConnectSync srcHandler to the dstMessenger X");
        //return STATUS_SUCCESSFUL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.238 -0400", hash_original_method = "E8061690950B5AC4037948D29BFD7764", hash_generated_method = "EE17FEF391F7F8C5DB2128CBB7CFDE84")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int connectSync(Context srcContext, Handler srcHandler, Handler dstHandler) {
        dsTaint.addTaint(dstHandler.dsTaint);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        int var7FE2AFB5B5AD5922F86CFFB068593226_2115290734 = (connectSync(srcContext, srcHandler, new Messenger(dstHandler)));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return connectSync(srcContext, srcHandler, new Messenger(dstHandler));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.276 -0400", hash_original_method = "47E7CF94088222D35244DD2A346F6D10", hash_generated_method = "D700C91A1D075AB5E1B2ED53E49183FA")
    @DSModeled(DSC.SAFE)
    public int fullyConnectSync(Context srcContext, Handler srcHandler, Handler dstHandler) {
        dsTaint.addTaint(dstHandler.dsTaint);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        int status;
        status = connectSync(srcContext, srcHandler, dstHandler);
        {
            Message response;
            response = sendMessageSynchronously(CMD_CHANNEL_FULL_CONNECTION);
            status = response.arg1;
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int status = connectSync(srcContext, srcHandler, dstHandler);
        //if (status == STATUS_SUCCESSFUL) {
            //Message response = sendMessageSynchronously(CMD_CHANNEL_FULL_CONNECTION);
            //status = response.arg1;
        //}
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.324 -0400", hash_original_method = "D2A6022ADF54D8001301F184CF4606D0", hash_generated_method = "519753AF8B6901D22F8CA6CED7D07391")
    @DSModeled(DSC.SAFE)
    public void connect(Context srcContext, Handler srcHandler, String dstPackageName,
            String dstClassName) {
        dsTaint.addTaint(dstClassName);
        dsTaint.addTaint(dstPackageName);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        final class ConnectAsync implements Runnable {
            Context mSrcCtx;
            Handler mSrcHdlr;
            String mDstPackageName;
            String mDstClassName;
            ConnectAsync(Context srcContext, Handler srcHandler, String dstPackageName,
                    String dstClassName) {
                dsTaint.addTaint(srcContext.dsTaint);
                dsTaint.addTaint(srcHandler);
                dsTaint.addTaint(dstPackageName);
                dsTaint.addTaint(dstClassName);
            }
            @Override
            public void run() {
                int result = connectSrcHandlerToPackageSync(mSrcCtx, mSrcHdlr, mDstPackageName,
                        mDstClassName);
                replyHalfConnected(result);
            }
        }
        ConnectAsync ca;
        ca = new ConnectAsync(srcContext, srcHandler, dstPackageName, dstClassName);
        new Thread(ca).start();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.345 -0400", hash_original_method = "EF115B092B0444968DFDE421B1D070CE", hash_generated_method = "F967E16E82C54808CE97392943BB34C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(Context srcContext, Handler srcHandler, Class<?> klass) {
        dsTaint.addTaint(klass.dsTaint);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        connect(srcContext, srcHandler, klass.getPackage().getName(), klass.getName());
        // ---------- Original Method ----------
        //connect(srcContext, srcHandler, klass.getPackage().getName(), klass.getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.368 -0400", hash_original_method = "D9A9DAD002038F54D59084B945A008ED", hash_generated_method = "FAAE5C0022B0FAB563A4B961C9639DE3")
    @DSModeled(DSC.SAFE)
    public void connect(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(dstMessenger.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        log("connect srcHandler to the dstMessenger  E");
        connected(srcContext, srcHandler, dstMessenger);
        replyHalfConnected(STATUS_SUCCESSFUL);
        log("connect srcHandler to the dstMessenger X");
        // ---------- Original Method ----------
        //if (DBG) log("connect srcHandler to the dstMessenger  E");
        //connected(srcContext, srcHandler, dstMessenger);
        //replyHalfConnected(STATUS_SUCCESSFUL);
        //if (DBG) log("connect srcHandler to the dstMessenger X");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.407 -0400", hash_original_method = "6B74CB8285045DC3058688AFD39174C7", hash_generated_method = "B4B2B879D0628BFB105AD2CF0248B8A2")
    @DSModeled(DSC.SAFE)
    public void connected(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(dstMessenger.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        log("connected srcHandler to the dstMessenger  E");
        mSrcMessenger = new Messenger(mSrcHandler);
        log("connected srcHandler to the dstMessenger X");
        // ---------- Original Method ----------
        //if (DBG) log("connected srcHandler to the dstMessenger  E");
        //mSrcContext = srcContext;
        //mSrcHandler = srcHandler;
        //mSrcMessenger = new Messenger(mSrcHandler);
        //mDstMessenger = dstMessenger;
        //if (DBG) log("connected srcHandler to the dstMessenger X");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.456 -0400", hash_original_method = "30351ACDB73035A90D0CFF564E4380CE", hash_generated_method = "9321E948DBCDAF01364F1E8154DC6F9E")
    @DSModeled(DSC.SAFE)
    public void connect(Context srcContext, Handler srcHandler, Handler dstHandler) {
        dsTaint.addTaint(dstHandler.dsTaint);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        connect(srcContext, srcHandler, new Messenger(dstHandler));
        // ---------- Original Method ----------
        //connect(srcContext, srcHandler, new Messenger(dstHandler));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.481 -0400", hash_original_method = "AB6DAC74FF8B2E5B9FEB974F6DCFF3D6", hash_generated_method = "C950631E1AB316EAAE52392D8156A90B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(AsyncService srcAsyncService, Messenger dstMessenger) {
        dsTaint.addTaint(srcAsyncService.dsTaint);
        dsTaint.addTaint(dstMessenger.dsTaint);
        connect(srcAsyncService, srcAsyncService.getHandler(), dstMessenger);
        // ---------- Original Method ----------
        //connect(srcAsyncService, srcAsyncService.getHandler(), dstMessenger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.502 -0400", hash_original_method = "C231E33C68F8FEC3C6EDCF993CA1BD7A", hash_generated_method = "F371EBED69A408321AA44F09F965646F")
    @DSModeled(DSC.SAFE)
    public void disconnected() {
        mSrcContext = null;
        mSrcHandler = null;
        mSrcMessenger = null;
        mDstMessenger = null;
        mConnection = null;
        // ---------- Original Method ----------
        //mSrcContext = null;
        //mSrcHandler = null;
        //mSrcMessenger = null;
        //mDstMessenger = null;
        //mConnection = null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.542 -0400", hash_original_method = "206D442C26BC964C7153F638F49072D1", hash_generated_method = "0199D9C59CE980B35673D7E72F139B4D")
    @DSModeled(DSC.SAFE)
    public void disconnect() {
        {
            mSrcContext.unbindService(mConnection);
        } //End block
        {
            replyDisconnected(STATUS_SUCCESSFUL);
        } //End block
        // ---------- Original Method ----------
        //if ((mConnection != null) && (mSrcContext != null)) {
            //mSrcContext.unbindService(mConnection);
        //}
        //if (mSrcHandler != null) {
            //replyDisconnected(STATUS_SUCCESSFUL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.574 -0400", hash_original_method = "9DAC7AFA4C14A1022E9DEC304018391F", hash_generated_method = "6F609A0E8046EFDB0C5525E32478912A")
    @DSModeled(DSC.SAFE)
    public void sendMessage(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        msg.replyTo = mSrcMessenger;
        try 
        {
            mDstMessenger.send(msg);
        } //End block
        catch (RemoteException e)
        {
            replyDisconnected(STATUS_SEND_UNSUCCESSFUL);
        } //End block
        // ---------- Original Method ----------
        //msg.replyTo = mSrcMessenger;
        //try {
            //mDstMessenger.send(msg);
        //} catch (RemoteException e) {
            //replyDisconnected(STATUS_SEND_UNSUCCESSFUL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.606 -0400", hash_original_method = "C8C31043DDFE26EC3BE146F1B2B418E3", hash_generated_method = "6ACC74A4F3F194140BD668391D0B1321")
    @DSModeled(DSC.SAFE)
    public void sendMessage(int what) {
        dsTaint.addTaint(what);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.660 -0400", hash_original_method = "6C3F9593FC3095346100149D0CBBAD3F", hash_generated_method = "71FB551557E5839562CE3C72A16EB678")
    @DSModeled(DSC.SAFE)
    public void sendMessage(int what, int arg1) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.686 -0400", hash_original_method = "23E4A4D5EBFE681605B0582F17F8E799", hash_generated_method = "37B5C5464EE28C9BEC3AE2B8B9B438D0")
    @DSModeled(DSC.SAFE)
    public void sendMessage(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.717 -0400", hash_original_method = "066946089A5EEE9700468FE67EE373C2", hash_generated_method = "5858C4D8BD5027D8BF043111A32B7952")
    @DSModeled(DSC.SAFE)
    public void sendMessage(int what, int arg1, int arg2, Object obj) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //msg.obj = obj;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.748 -0400", hash_original_method = "D262961B9C2C88432C23CE1E616C0D35", hash_generated_method = "6C744C0C9437CBACA8B461D358EC3850")
    @DSModeled(DSC.SAFE)
    public void sendMessage(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.obj = obj;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.781 -0400", hash_original_method = "9F609FC4DF465EEA0A9F2C3A79A2C6B4", hash_generated_method = "BF8D5988F4DDE2135660656BA2E0B211")
    @DSModeled(DSC.SAFE)
    public void replyToMessage(Message srcMsg, Message dstMsg) {
        dsTaint.addTaint(dstMsg.dsTaint);
        dsTaint.addTaint(srcMsg.dsTaint);
        try 
        {
            dstMsg.replyTo = mSrcMessenger;
            srcMsg.replyTo.send(dstMsg);
        } //End block
        catch (RemoteException e)
        {
            log("TODO: handle replyToMessage RemoteException" + e);
            e.printStackTrace();
        } //End block
        // ---------- Original Method ----------
        //try {
            //dstMsg.replyTo = mSrcMessenger;
            //srcMsg.replyTo.send(dstMsg);
        //} catch (RemoteException e) {
            //log("TODO: handle replyToMessage RemoteException" + e);
            //e.printStackTrace();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.809 -0400", hash_original_method = "BD4B3A181E1CE5BF498106AFACED886D", hash_generated_method = "4C9C18CF5DEC2A36C7F9D66DBA9099A1")
    @DSModeled(DSC.SAFE)
    public void replyToMessage(Message srcMsg, int what) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(srcMsg.dsTaint);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        replyToMessage(srcMsg, msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.834 -0400", hash_original_method = "3044254AB71061FF974CD0BBDD0D9BC5", hash_generated_method = "BD6DF73178C4C7CD77DC79B498EA6B2F")
    @DSModeled(DSC.SAFE)
    public void replyToMessage(Message srcMsg, int what, int arg1) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(srcMsg.dsTaint);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        replyToMessage(srcMsg, msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.874 -0400", hash_original_method = "DA98F71F7AF234EE48D27745943E51D8", hash_generated_method = "48B17106990F7473B3046854F38A2B26")
    @DSModeled(DSC.SAFE)
    public void replyToMessage(Message srcMsg, int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(srcMsg.dsTaint);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        replyToMessage(srcMsg, msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.904 -0400", hash_original_method = "69829FBE15E20ADBF8C45DA9DA2D1745", hash_generated_method = "426467BBE64488E4FA00DD310887545E")
    @DSModeled(DSC.SAFE)
    public void replyToMessage(Message srcMsg, int what, int arg1, int arg2, Object obj) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(srcMsg.dsTaint);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        replyToMessage(srcMsg, msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //msg.obj = obj;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.928 -0400", hash_original_method = "7A8712370119BFFFB8554DE52F815A80", hash_generated_method = "42810E81D8F578F316A80F36EE9381EA")
    @DSModeled(DSC.SAFE)
    public void replyToMessage(Message srcMsg, int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        dsTaint.addTaint(srcMsg.dsTaint);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        replyToMessage(srcMsg, msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.obj = obj;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.941 -0400", hash_original_method = "44E20F477AE4DBE39F2143CAA1307C1F", hash_generated_method = "FDCFC0FEC52CFAB74C25B5CF73B01C12")
    @DSModeled(DSC.SAFE)
    public Message sendMessageSynchronously(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        Message resultMsg;
        resultMsg = SyncMessenger.sendMessageSynchronously(mDstMessenger, msg);
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message resultMsg = SyncMessenger.sendMessageSynchronously(mDstMessenger, msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.968 -0400", hash_original_method = "42BD69B2114459AD691B3AEBDAE73546", hash_generated_method = "86E8C88C40860FBE041752B16C57AE21")
    @DSModeled(DSC.SAFE)
    public Message sendMessageSynchronously(int what) {
        dsTaint.addTaint(what);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:46.996 -0400", hash_original_method = "69DA3E1B323882B9D4B744C6E35751A3", hash_generated_method = "CD931D2ADC7918BDFA34F081C817D2BA")
    @DSModeled(DSC.SAFE)
    public Message sendMessageSynchronously(int what, int arg1) {
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.037 -0400", hash_original_method = "AFDADB0B0E37C71FB8D4BE31CA39F990", hash_generated_method = "9C4425E67655D07617F400C3B8CA6B79")
    @DSModeled(DSC.SAFE)
    public Message sendMessageSynchronously(int what, int arg1, int arg2) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.055 -0400", hash_original_method = "EEAA69B320108852E46A6304535CC9F5", hash_generated_method = "F17B78103944507E4AAC2DAE342FCA74")
    @DSModeled(DSC.SAFE)
    public Message sendMessageSynchronously(int what, int arg1, int arg2, Object obj) {
        dsTaint.addTaint(arg2);
        dsTaint.addTaint(arg1);
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //msg.obj = obj;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.069 -0400", hash_original_method = "35A5E39A8A1820326BDEA32FA9EDD100", hash_generated_method = "7315ACB5F4759ABED28FAEED35E22F08")
    @DSModeled(DSC.SAFE)
    public Message sendMessageSynchronously(int what, Object obj) {
        dsTaint.addTaint(what);
        dsTaint.addTaint(obj.dsTaint);
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.obj = obj;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.088 -0400", hash_original_method = "DECE161063975CD41C076FDB9612D509", hash_generated_method = "094B50EEF96B0CAF7D37BD2D611EE830")
    @DSModeled(DSC.SAFE)
    private void replyHalfConnected(int status) {
        dsTaint.addTaint(status);
        Message msg;
        msg = mSrcHandler.obtainMessage(CMD_CHANNEL_HALF_CONNECTED);
        msg.arg1 = status;
        msg.obj = this;
        msg.replyTo = mDstMessenger;
        mSrcHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = mSrcHandler.obtainMessage(CMD_CHANNEL_HALF_CONNECTED);
        //msg.arg1 = status;
        //msg.obj = this;
        //msg.replyTo = mDstMessenger;
        //mSrcHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.093 -0400", hash_original_method = "6CA7282E928AA840C6D25E995C5EBFEA", hash_generated_method = "6066D0687EB6F887F8A9CE1FB2276990")
    @DSModeled(DSC.SAFE)
    private void replyDisconnected(int status) {
        dsTaint.addTaint(status);
        Message msg;
        msg = mSrcHandler.obtainMessage(CMD_CHANNEL_DISCONNECTED);
        msg.arg1 = status;
        msg.obj = this;
        msg.replyTo = mDstMessenger;
        mSrcHandler.sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = mSrcHandler.obtainMessage(CMD_CHANNEL_DISCONNECTED);
        //msg.arg1 = status;
        //msg.obj = this;
        //msg.replyTo = mDstMessenger;
        //mSrcHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.117 -0400", hash_original_method = "6FCA9AA6353D4B452135E8444180D2C6", hash_generated_method = "BDA28BABE71D91786DFE8D4E9E911424")
    private static void log(String s) {
        Slog.d(TAG, s);
    }

    
    private static class SyncMessenger {
        private static Stack<SyncMessenger> sStack = new Stack<SyncMessenger>();
        private static int sCount = 0;
        private HandlerThread mHandlerThread;
        private SyncHandler mHandler;
        private Messenger mMessenger;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.120 -0400", hash_original_method = "836D007993A4B13DC1AF265962B161E2", hash_generated_method = "59C5AC2AC43342510CAAE6D41A0ED076")
        @DSModeled(DSC.SAFE)
        private SyncMessenger() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.148 -0400", hash_original_method = "6842F7631484B475B06161058D6842E6", hash_generated_method = "59982E7C0D8FDD0B2B29D39E7BB14C2B")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.161 -0400", hash_original_method = "FF57C371186B795A0CEFC17D6A21913E", hash_generated_method = "5885EB3CB86F3D34E45B7DFF34CBBB40")
        @DSModeled(DSC.SAFE)
        private void recycle() {
            {
                sStack.push(this);
            } //End block
            // ---------- Original Method ----------
            //synchronized (sStack) {
                //sStack.push(this);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.182 -0400", hash_original_method = "73417FF22870072B41D9E8892C6ACEAF", hash_generated_method = "98D30C9AEE1B66AD2FCFA7D7A2E2B430")
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

        
        private class SyncHandler extends Handler {
            private Object mLockObject = new Object();
            private Message mResultMsg;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.221 -0400", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "59E66CF4868FD8BD0D1E3EF687D46CD6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            private SyncHandler(Looper looper) {
                super(looper);
                dsTaint.addTaint(looper.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.227 -0400", hash_original_method = "2469457C965E8FC7C139A1D414384428", hash_generated_method = "706AA6B6510D4E8D567571967AF4CFF6")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void handleMessage(Message msg) {
                dsTaint.addTaint(msg.dsTaint);
                mResultMsg = Message.obtain();
                mResultMsg.copyFrom(msg);
                {
                    mLockObject.notify();
                } //End block
                // ---------- Original Method ----------
                //mResultMsg = Message.obtain();
                //mResultMsg.copyFrom(msg);
                //synchronized(mLockObject) {
                    //mLockObject.notify();
                //}
            }

            
        }


        
    }


    
    class AsyncChannelConnection implements ServiceConnection {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.248 -0400", hash_original_method = "5CA2E7F994E5D5CA10120B6A293C36BC", hash_generated_method = "9951AFD3481782B46C3CE4F199F14381")
        @DSModeled(DSC.SAFE)
         AsyncChannelConnection() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.274 -0400", hash_original_method = "0E2027B9824173FAE83BA1B2B965BB96", hash_generated_method = "63BA0E9314E11F764AAF2613766ACC54")
        @DSModeled(DSC.SAFE)
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(service.dsTaint);
            dsTaint.addTaint(className.dsTaint);
            mDstMessenger = new Messenger(service);
            replyHalfConnected(STATUS_SUCCESSFUL);
            // ---------- Original Method ----------
            //mDstMessenger = new Messenger(service);
            //replyHalfConnected(STATUS_SUCCESSFUL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-12 12:28:47.312 -0400", hash_original_method = "050AF9875EBB5531901E44E1327B5019", hash_generated_method = "E046D98EF9ED02CA90C07AC915D844CB")
        @DSModeled(DSC.SAFE)
        @Override
        public void onServiceDisconnected(ComponentName className) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(className.dsTaint);
            replyDisconnected(STATUS_SUCCESSFUL);
            // ---------- Original Method ----------
            //replyDisconnected(STATUS_SUCCESSFUL);
        }

        
    }


    
}


