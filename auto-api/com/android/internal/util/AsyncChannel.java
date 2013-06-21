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
    private AsyncChannelConnection mConnection;
    private Context mSrcContext;
    private Handler mSrcHandler;
    private Messenger mSrcMessenger;
    private Messenger mDstMessenger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.579 -0400", hash_original_method = "FDD6D3EF5F7BC7D6883E0BF7536BB913", hash_generated_method = "CBC4A48158E97A41700C96C588786574")
    @DSModeled(DSC.SAFE)
    public AsyncChannel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.580 -0400", hash_original_method = "89C8C4B82DB5AC36CAD55D59C7A76E33", hash_generated_method = "CE0D7176488C0F75E187C5E60B8FD3D5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.580 -0400", hash_original_method = "ABB64391FEF3212581FCE62A24663F37", hash_generated_method = "DA0E5DA2992E442A879263F680A2BF74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.580 -0400", hash_original_method = "E8061690950B5AC4037948D29BFD7764", hash_generated_method = "20486C6D5425EF462B629512B71480EC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int connectSync(Context srcContext, Handler srcHandler, Handler dstHandler) {
        dsTaint.addTaint(dstHandler.dsTaint);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        int var7FE2AFB5B5AD5922F86CFFB068593226_1655408656 = (connectSync(srcContext, srcHandler, new Messenger(dstHandler)));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return connectSync(srcContext, srcHandler, new Messenger(dstHandler));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.581 -0400", hash_original_method = "47E7CF94088222D35244DD2A346F6D10", hash_generated_method = "A1D45C6DF8553BB836AD8E0E6F88D53E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.582 -0400", hash_original_method = "D2A6022ADF54D8001301F184CF4606D0", hash_generated_method = "4D7F0EB88FF1DE504DE2F4AD7FF19D3D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(Context srcContext, Handler srcHandler, String dstPackageName,
            String dstClassName) {
        dsTaint.addTaint(dstClassName);
        dsTaint.addTaint(dstPackageName);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        log("connect srcHandler to dst Package & class E");
        final class ConnectAsync implements Runnable {
            Context mSrcCtx;
            Handler mSrcHdlr;
            String mDstPackageName;
            String mDstClassName;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.581 -0400", hash_original_method = "26202A470B4739436FF7E15729D19468", hash_generated_method = "DBDF1551EF178696B3CE9BC964E14273")
            @DSModeled(DSC.SAFE)
             ConnectAsync(Context srcContext, Handler srcHandler, String dstPackageName,
                    String dstClassName) {
                dsTaint.addTaint(dstClassName);
                dsTaint.addTaint(dstPackageName);
                dsTaint.addTaint(srcContext.dsTaint);
                dsTaint.addTaint(srcHandler.dsTaint);
                // ---------- Original Method ----------
                //mSrcCtx = srcContext;
                //mSrcHdlr = srcHandler;
                //mDstPackageName = dstPackageName;
                //mDstClassName = dstClassName;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.582 -0400", hash_original_method = "16F182387C74E8BFEA3B17CE5A08CAA0", hash_generated_method = "AFB423E97B9B80099D12E8D20549C59B")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            @Override
            public void run() {
                int result;
                result = connectSrcHandlerToPackageSync(mSrcCtx, mSrcHdlr, mDstPackageName,
                        mDstClassName);
                replyHalfConnected(result);
                // ---------- Original Method ----------
                //int result = connectSrcHandlerToPackageSync(mSrcCtx, mSrcHdlr, mDstPackageName,
                        //mDstClassName);
                //replyHalfConnected(result);
            }
        }
        ConnectAsync ca;
        ca = new ConnectAsync(srcContext, srcHandler, dstPackageName, dstClassName);
        new Thread(ca).start();
        log("connect srcHandler to dst Package & class X");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.582 -0400", hash_original_method = "EF115B092B0444968DFDE421B1D070CE", hash_generated_method = "7C911BEB6B95CF630E5F1F0F09D99907")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(Context srcContext, Handler srcHandler, Class<?> klass) {
        dsTaint.addTaint(klass.dsTaint);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        connect(srcContext, srcHandler, klass.getPackage().getName(), klass.getName());
        // ---------- Original Method ----------
        //connect(srcContext, srcHandler, klass.getPackage().getName(), klass.getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.582 -0400", hash_original_method = "D9A9DAD002038F54D59084B945A008ED", hash_generated_method = "FD2662F142012477E8200128CDFE2E37")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.583 -0400", hash_original_method = "6B74CB8285045DC3058688AFD39174C7", hash_generated_method = "0EF474319033BCBC5959E52D0E6D42E1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.583 -0400", hash_original_method = "30351ACDB73035A90D0CFF564E4380CE", hash_generated_method = "DB19965A104BB49C3BC24DC9640D2DD9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(Context srcContext, Handler srcHandler, Handler dstHandler) {
        dsTaint.addTaint(dstHandler.dsTaint);
        dsTaint.addTaint(srcContext.dsTaint);
        dsTaint.addTaint(srcHandler.dsTaint);
        connect(srcContext, srcHandler, new Messenger(dstHandler));
        // ---------- Original Method ----------
        //connect(srcContext, srcHandler, new Messenger(dstHandler));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.583 -0400", hash_original_method = "AB6DAC74FF8B2E5B9FEB974F6DCFF3D6", hash_generated_method = "CDC04DB3C5878BA039887B2150C601EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void connect(AsyncService srcAsyncService, Messenger dstMessenger) {
        dsTaint.addTaint(srcAsyncService.dsTaint);
        dsTaint.addTaint(dstMessenger.dsTaint);
        connect(srcAsyncService, srcAsyncService.getHandler(), dstMessenger);
        // ---------- Original Method ----------
        //connect(srcAsyncService, srcAsyncService.getHandler(), dstMessenger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.583 -0400", hash_original_method = "C231E33C68F8FEC3C6EDCF993CA1BD7A", hash_generated_method = "F0979877F363BD7302AAF19A7B022C1A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.584 -0400", hash_original_method = "206D442C26BC964C7153F638F49072D1", hash_generated_method = "B4943B8B50DC239C5F34A2F3FE872EDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.584 -0400", hash_original_method = "9DAC7AFA4C14A1022E9DEC304018391F", hash_generated_method = "95A2EA1069B3FA0AD6DC181054E793C7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.585 -0400", hash_original_method = "C8C31043DDFE26EC3BE146F1B2B418E3", hash_generated_method = "60B80825BAB05754CF57DFFC18D7645F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.585 -0400", hash_original_method = "6C3F9593FC3095346100149D0CBBAD3F", hash_generated_method = "3AED53966A9D8BB28A9606C57E5EF74C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.585 -0400", hash_original_method = "23E4A4D5EBFE681605B0582F17F8E799", hash_generated_method = "F62A710C048E59981B72B23BABC8E9D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.594 -0400", hash_original_method = "066946089A5EEE9700468FE67EE373C2", hash_generated_method = "B62953526BF8A4281FFED45F4A736ABE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.596 -0400", hash_original_method = "D262961B9C2C88432C23CE1E616C0D35", hash_generated_method = "F8952D228E1CE84D8AAB4E3128412748")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.597 -0400", hash_original_method = "9F609FC4DF465EEA0A9F2C3A79A2C6B4", hash_generated_method = "3891C910EEBF2361C3F44B00EA2B53BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.600 -0400", hash_original_method = "BD4B3A181E1CE5BF498106AFACED886D", hash_generated_method = "B968295C87164EB3796ACC2BD9E7823F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.600 -0400", hash_original_method = "3044254AB71061FF974CD0BBDD0D9BC5", hash_generated_method = "AF3F9CD846BB84FF6D7AEA068024C6E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.601 -0400", hash_original_method = "DA98F71F7AF234EE48D27745943E51D8", hash_generated_method = "BA86155BB808910993851618F1905837")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.601 -0400", hash_original_method = "69829FBE15E20ADBF8C45DA9DA2D1745", hash_generated_method = "8B8A8300015BDA3A857908283E2AEDF2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.601 -0400", hash_original_method = "7A8712370119BFFFB8554DE52F815A80", hash_generated_method = "F99AA48CF67B7067692176A0B0402B74")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.602 -0400", hash_original_method = "44E20F477AE4DBE39F2143CAA1307C1F", hash_generated_method = "4682C51260AB19FEFE9A18A26C42DFA9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Message sendMessageSynchronously(Message msg) {
        dsTaint.addTaint(msg.dsTaint);
        Message resultMsg;
        resultMsg = SyncMessenger.sendMessageSynchronously(mDstMessenger, msg);
        return (Message)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message resultMsg = SyncMessenger.sendMessageSynchronously(mDstMessenger, msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.602 -0400", hash_original_method = "42BD69B2114459AD691B3AEBDAE73546", hash_generated_method = "4DDB9684316B4C80667AA2FAD766ED47")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.602 -0400", hash_original_method = "69DA3E1B323882B9D4B744C6E35751A3", hash_generated_method = "7CFC63E635A672DCB7E32BE9453B1D2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.603 -0400", hash_original_method = "AFDADB0B0E37C71FB8D4BE31CA39F990", hash_generated_method = "4CCE8E6A2984B1D623E19D85CCCD2CFA")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.604 -0400", hash_original_method = "EEAA69B320108852E46A6304535CC9F5", hash_generated_method = "A66107581FDBFDB913017B600C3E8EDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.605 -0400", hash_original_method = "35A5E39A8A1820326BDEA32FA9EDD100", hash_generated_method = "779B28414458759AAC0BE784C0BDAB48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.605 -0400", hash_original_method = "DECE161063975CD41C076FDB9612D509", hash_generated_method = "6CC889C8FE2B4CA9D04D1E23644DE259")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.606 -0400", hash_original_method = "6CA7282E928AA840C6D25E995C5EBFEA", hash_generated_method = "AA3AF803F0E3CF2DC101B87F606E6FE4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
        private static void log(String s) {
        Slog.d(TAG, s);
    }

    
    private static class SyncMessenger {
        private HandlerThread mHandlerThread;
        private SyncHandler mHandler;
        private Messenger mMessenger;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.606 -0400", hash_original_method = "836D007993A4B13DC1AF265962B161E2", hash_generated_method = "C3453B046382A1E37BE69572B5A5208C")
        @DSModeled(DSC.SAFE)
        private SyncMessenger() {
            // ---------- Original Method ----------
        }

        
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.606 -0400", hash_original_method = "FF57C371186B795A0CEFC17D6A21913E", hash_generated_method = "CF1A985945995C6EE9DD3727475CF54A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void recycle() {
            {
                sStack.push(this);
            } //End block
            // ---------- Original Method ----------
            //synchronized (sStack) {
                //sStack.push(this);
            //}
        }

        
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
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.607 -0400", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "88CEC1AD6C6EACC36EDB691B37710C8C")
            //DSFIXME:  CODE0002: Requires DSC value to be set
            private SyncHandler(Looper looper) {
                super(looper);
                dsTaint.addTaint(looper.dsTaint);
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.607 -0400", hash_original_method = "2469457C965E8FC7C139A1D414384428", hash_generated_method = "43835B4B6EF1858B74A3096BB3544C5D")
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


        
        private static Stack<SyncMessenger> sStack = new Stack<SyncMessenger>();
        private static int sCount = 0;
    }


    
    class AsyncChannelConnection implements ServiceConnection {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.608 -0400", hash_original_method = "5CA2E7F994E5D5CA10120B6A293C36BC", hash_generated_method = "A6BACC4CE181C0EB5D92D381782508F2")
        @DSModeled(DSC.SAFE)
         AsyncChannelConnection() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.608 -0400", hash_original_method = "0E2027B9824173FAE83BA1B2B965BB96", hash_generated_method = "9BE2FDD3BEA12A2BF324F5767FD01964")
        //DSFIXME:  CODE0002: Requires DSC value to be set
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:17.608 -0400", hash_original_method = "050AF9875EBB5531901E44E1327B5019", hash_generated_method = "AA9C1E953744C5A34B2496918CEC51F9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void onServiceDisconnected(ComponentName className) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(className.dsTaint);
            replyDisconnected(STATUS_SUCCESSFUL);
            // ---------- Original Method ----------
            //replyDisconnected(STATUS_SUCCESSFUL);
        }

        
    }


    
    private static final String TAG = "AsyncChannel";
    private static final boolean DBG = false;
    private static final int BASE = Protocol.BASE_SYSTEM_ASYNC_CHANNEL;
    public static final int CMD_CHANNEL_HALF_CONNECTED = BASE + 0;
    public static final int CMD_CHANNEL_FULL_CONNECTION = BASE + 1;
    public static final int CMD_CHANNEL_FULLY_CONNECTED = BASE + 2;
    public static final int CMD_CHANNEL_DISCONNECT = BASE + 3;
    public static final int CMD_CHANNEL_DISCONNECTED = BASE + 4;
    public static final int STATUS_SUCCESSFUL = 0;
    public static final int STATUS_BINDING_UNSUCCESSFUL = 1;
    public static final int STATUS_SEND_UNSUCCESSFUL = 2;
    public static final int STATUS_FULL_CONNECTION_REFUSED_ALREADY_CONNECTED = 3;
}

