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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.036 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "E0FE31041D4B400F1ECC0924DC307F23")

    private AsyncChannelConnection mConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.036 -0400", hash_original_field = "87C08AEB5A3D17BF072E78C95BF6609A", hash_generated_field = "D92C09EC63748E6484EE8DFEB808CFD6")

    private Context mSrcContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.036 -0400", hash_original_field = "25F77AD5B1AB9A0784B314E923CD2968", hash_generated_field = "BD0D117ED673366AC3516437E5A4C86B")

    private Handler mSrcHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.036 -0400", hash_original_field = "2CD378F6D7DA03699B005770FABF01BA", hash_generated_field = "ADFCAC580CFA427EE53B41262D89A4AC")

    private Messenger mSrcMessenger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.036 -0400", hash_original_field = "E889B286B5240397E7C14C0C448740E9", hash_generated_field = "12D94F9D13B393CF02D9A14BBEC89054")

    private Messenger mDstMessenger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.036 -0400", hash_original_method = "FDD6D3EF5F7BC7D6883E0BF7536BB913", hash_generated_method = "CBC4A48158E97A41700C96C588786574")
    public  AsyncChannel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.041 -0400", hash_original_method = "89C8C4B82DB5AC36CAD55D59C7A76E33", hash_generated_method = "BD2C8F464E33CBEF9F5935340D8D0ED4")
    public int connectSrcHandlerToPackageSync(
            Context srcContext, Handler srcHandler, String dstPackageName, String dstClassName) {
        log("connect srcHandler to dst Package & class E");
        mConnection = new AsyncChannelConnection();
        mSrcContext = srcContext;
        mSrcHandler = srcHandler;
        mSrcMessenger = new Messenger(srcHandler);
        mDstMessenger = null;
        Intent intent;
        intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(dstPackageName, dstClassName);
        boolean result;
        result = srcContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        log("connect srcHandler to dst Package & class X result=" + result);
        addTaint(dstPackageName.getTaint());
        addTaint(dstClassName.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223145111 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1223145111;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.041 -0400", hash_original_method = "ABB64391FEF3212581FCE62A24663F37", hash_generated_method = "91E40ED90E313A01E582EBD6DF214AB6")
    public int connectSync(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        log("halfConnectSync srcHandler to the dstMessenger  E");
        connected(srcContext, srcHandler, dstMessenger);
        log("halfConnectSync srcHandler to the dstMessenger X");
        addTaint(srcContext.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(dstMessenger.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838064045 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_838064045;
        // ---------- Original Method ----------
        //if (DBG) log("halfConnectSync srcHandler to the dstMessenger  E");
        //connected(srcContext, srcHandler, dstMessenger);
        //if (DBG) log("halfConnectSync srcHandler to the dstMessenger X");
        //return STATUS_SUCCESSFUL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.042 -0400", hash_original_method = "E8061690950B5AC4037948D29BFD7764", hash_generated_method = "EA00B3B970BB3A03A358B3B5F149A792")
    public int connectSync(Context srcContext, Handler srcHandler, Handler dstHandler) {
        int var7FE2AFB5B5AD5922F86CFFB068593226_941716322 = (connectSync(srcContext, srcHandler, new Messenger(dstHandler)));
        addTaint(srcContext.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(dstHandler.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476653857 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_476653857;
        // ---------- Original Method ----------
        //return connectSync(srcContext, srcHandler, new Messenger(dstHandler));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.042 -0400", hash_original_method = "47E7CF94088222D35244DD2A346F6D10", hash_generated_method = "048990B331F42ADB2F06068ADDF47245")
    public int fullyConnectSync(Context srcContext, Handler srcHandler, Handler dstHandler) {
        int status;
        status = connectSync(srcContext, srcHandler, dstHandler);
        {
            Message response;
            response = sendMessageSynchronously(CMD_CHANNEL_FULL_CONNECTION);
            status = response.arg1;
        } //End block
        addTaint(srcContext.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(dstHandler.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859713432 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1859713432;
        // ---------- Original Method ----------
        //int status = connectSync(srcContext, srcHandler, dstHandler);
        //if (status == STATUS_SUCCESSFUL) {
            //Message response = sendMessageSynchronously(CMD_CHANNEL_FULL_CONNECTION);
            //status = response.arg1;
        //}
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.049 -0400", hash_original_method = "D2A6022ADF54D8001301F184CF4606D0", hash_generated_method = "1D8BE0372304FFAE940BFF2CE60B1029")
    public void connect(Context srcContext, Handler srcHandler, String dstPackageName,
            String dstClassName) {
        log("connect srcHandler to dst Package & class E");
        final class ConnectAsync implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.043 -0400", hash_original_field = "8B4484FBC1FE4E9FD584DAC7346C7CEC", hash_generated_field = "4B9A8ADECB00B1FBBEDF74A87B7B2E14")
            Context mSrcCtx;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.043 -0400", hash_original_field = "E96852DA8247712DB7EB401462C40821", hash_generated_field = "F848A9BC15E1D508EFDE78836A1E1229")
            Handler mSrcHdlr;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.043 -0400", hash_original_field = "0F52918D1CA58D31CA1BF2218A89271C", hash_generated_field = "09F25A8665AE8101339100B925E40D3B")
            String mDstPackageName;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.043 -0400", hash_original_field = "07A7F28D26F6AA9DDDAB0EA14CDCA2B4", hash_generated_field = "0B219ED940AA101E1553BAC3E721EBE1")
            String mDstClassName;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.043 -0400", hash_original_method = "26202A470B4739436FF7E15729D19468", hash_generated_method = "FAA1C1EEB7ED522D3810785DA72A55B9")
              ConnectAsync(Context srcContext, Handler srcHandler, String dstPackageName,
                    String dstClassName) {
                mSrcCtx = srcContext;
                mSrcHdlr = srcHandler;
                mDstPackageName = dstPackageName;
                mDstClassName = dstClassName;
                // ---------- Original Method ----------
                //mSrcCtx = srcContext;
                //mSrcHdlr = srcHandler;
                //mDstPackageName = dstPackageName;
                //mDstClassName = dstClassName;
            }
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.049 -0400", hash_original_method = "16F182387C74E8BFEA3B17CE5A08CAA0", hash_generated_method = "AFB423E97B9B80099D12E8D20549C59B")
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
        addTaint(srcContext.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(dstPackageName.getTaint());
        addTaint(dstClassName.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.050 -0400", hash_original_method = "EF115B092B0444968DFDE421B1D070CE", hash_generated_method = "142810E128058B950891AD2BB62EC180")
    public void connect(Context srcContext, Handler srcHandler, Class<?> klass) {
        connect(srcContext, srcHandler, klass.getPackage().getName(), klass.getName());
        addTaint(srcContext.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(klass.getTaint());
        // ---------- Original Method ----------
        //connect(srcContext, srcHandler, klass.getPackage().getName(), klass.getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.050 -0400", hash_original_method = "D9A9DAD002038F54D59084B945A008ED", hash_generated_method = "24400120905B2DBB1321C00C7F53FEBA")
    public void connect(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        log("connect srcHandler to the dstMessenger  E");
        connected(srcContext, srcHandler, dstMessenger);
        replyHalfConnected(STATUS_SUCCESSFUL);
        log("connect srcHandler to the dstMessenger X");
        addTaint(srcContext.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(dstMessenger.getTaint());
        // ---------- Original Method ----------
        //if (DBG) log("connect srcHandler to the dstMessenger  E");
        //connected(srcContext, srcHandler, dstMessenger);
        //replyHalfConnected(STATUS_SUCCESSFUL);
        //if (DBG) log("connect srcHandler to the dstMessenger X");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.054 -0400", hash_original_method = "6B74CB8285045DC3058688AFD39174C7", hash_generated_method = "C82FE51E8CEDA9C6130BC32748318835")
    public void connected(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        log("connected srcHandler to the dstMessenger  E");
        mSrcContext = srcContext;
        mSrcHandler = srcHandler;
        mSrcMessenger = new Messenger(mSrcHandler);
        mDstMessenger = dstMessenger;
        log("connected srcHandler to the dstMessenger X");
        // ---------- Original Method ----------
        //if (DBG) log("connected srcHandler to the dstMessenger  E");
        //mSrcContext = srcContext;
        //mSrcHandler = srcHandler;
        //mSrcMessenger = new Messenger(mSrcHandler);
        //mDstMessenger = dstMessenger;
        //if (DBG) log("connected srcHandler to the dstMessenger X");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.055 -0400", hash_original_method = "30351ACDB73035A90D0CFF564E4380CE", hash_generated_method = "A0747B03F2323C476EA5D6A0E6ACD9AE")
    public void connect(Context srcContext, Handler srcHandler, Handler dstHandler) {
        connect(srcContext, srcHandler, new Messenger(dstHandler));
        addTaint(srcContext.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(dstHandler.getTaint());
        // ---------- Original Method ----------
        //connect(srcContext, srcHandler, new Messenger(dstHandler));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.056 -0400", hash_original_method = "AB6DAC74FF8B2E5B9FEB974F6DCFF3D6", hash_generated_method = "14AF0C6F6AAEE9C41AD98BE18130FEDD")
    public void connect(AsyncService srcAsyncService, Messenger dstMessenger) {
        connect(srcAsyncService, srcAsyncService.getHandler(), dstMessenger);
        addTaint(srcAsyncService.getTaint());
        addTaint(dstMessenger.getTaint());
        // ---------- Original Method ----------
        //connect(srcAsyncService, srcAsyncService.getHandler(), dstMessenger);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.056 -0400", hash_original_method = "C231E33C68F8FEC3C6EDCF993CA1BD7A", hash_generated_method = "F0979877F363BD7302AAF19A7B022C1A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.069 -0400", hash_original_method = "206D442C26BC964C7153F638F49072D1", hash_generated_method = "B4943B8B50DC239C5F34A2F3FE872EDD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.070 -0400", hash_original_method = "9DAC7AFA4C14A1022E9DEC304018391F", hash_generated_method = "27A09594B524B56AA8B65D073AFBCF00")
    public void sendMessage(Message msg) {
        msg.replyTo = mSrcMessenger;
        try 
        {
            mDstMessenger.send(msg);
        } //End block
        catch (RemoteException e)
        {
            replyDisconnected(STATUS_SEND_UNSUCCESSFUL);
        } //End block
        addTaint(msg.getTaint());
        // ---------- Original Method ----------
        //msg.replyTo = mSrcMessenger;
        //try {
            //mDstMessenger.send(msg);
        //} catch (RemoteException e) {
            //replyDisconnected(STATUS_SEND_UNSUCCESSFUL);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.071 -0400", hash_original_method = "C8C31043DDFE26EC3BE146F1B2B418E3", hash_generated_method = "960BB9C52D98C05046649075DB62F097")
    public void sendMessage(int what) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        sendMessage(msg);
        addTaint(what);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.071 -0400", hash_original_method = "6C3F9593FC3095346100149D0CBBAD3F", hash_generated_method = "036800D00FA1ECDE4B33F28539FA4221")
    public void sendMessage(int what, int arg1) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        sendMessage(msg);
        addTaint(what);
        addTaint(arg1);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.086 -0400", hash_original_method = "23E4A4D5EBFE681605B0582F17F8E799", hash_generated_method = "C094B1DFEED92F3E403C698941B4626E")
    public void sendMessage(int what, int arg1, int arg2) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        sendMessage(msg);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.087 -0400", hash_original_method = "066946089A5EEE9700468FE67EE373C2", hash_generated_method = "51200B104893D64EB3BBCCF120222811")
    public void sendMessage(int what, int arg1, int arg2, Object obj) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        sendMessage(msg);
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //msg.obj = obj;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.087 -0400", hash_original_method = "D262961B9C2C88432C23CE1E616C0D35", hash_generated_method = "0D1178FFA6E450AC5E2318511F95A3EB")
    public void sendMessage(int what, Object obj) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        sendMessage(msg);
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.obj = obj;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.087 -0400", hash_original_method = "9F609FC4DF465EEA0A9F2C3A79A2C6B4", hash_generated_method = "47862C8300BC35CC4739D9400884BE76")
    public void replyToMessage(Message srcMsg, Message dstMsg) {
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
        addTaint(srcMsg.getTaint());
        addTaint(dstMsg.getTaint());
        // ---------- Original Method ----------
        //try {
            //dstMsg.replyTo = mSrcMessenger;
            //srcMsg.replyTo.send(dstMsg);
        //} catch (RemoteException e) {
            //log("TODO: handle replyToMessage RemoteException" + e);
            //e.printStackTrace();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.095 -0400", hash_original_method = "BD4B3A181E1CE5BF498106AFACED886D", hash_generated_method = "C03D7080DDF8CD3E49B56111826E544D")
    public void replyToMessage(Message srcMsg, int what) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        replyToMessage(srcMsg, msg);
        addTaint(srcMsg.getTaint());
        addTaint(what);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.100 -0400", hash_original_method = "3044254AB71061FF974CD0BBDD0D9BC5", hash_generated_method = "A545F70EB53A6E78346E060718A4FA15")
    public void replyToMessage(Message srcMsg, int what, int arg1) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        replyToMessage(srcMsg, msg);
        addTaint(srcMsg.getTaint());
        addTaint(what);
        addTaint(arg1);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.100 -0400", hash_original_method = "DA98F71F7AF234EE48D27745943E51D8", hash_generated_method = "1548778F3CB397AAB91F024834ECA0B2")
    public void replyToMessage(Message srcMsg, int what, int arg1, int arg2) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        replyToMessage(srcMsg, msg);
        addTaint(srcMsg.getTaint());
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.101 -0400", hash_original_method = "69829FBE15E20ADBF8C45DA9DA2D1745", hash_generated_method = "B8BFFAC9C343D685766C0D56721ACFEE")
    public void replyToMessage(Message srcMsg, int what, int arg1, int arg2, Object obj) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        replyToMessage(srcMsg, msg);
        addTaint(srcMsg.getTaint());
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //msg.obj = obj;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.101 -0400", hash_original_method = "7A8712370119BFFFB8554DE52F815A80", hash_generated_method = "0209B5AE246163FCEF98571BAB063E4A")
    public void replyToMessage(Message srcMsg, int what, Object obj) {
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        replyToMessage(srcMsg, msg);
        addTaint(srcMsg.getTaint());
        addTaint(what);
        addTaint(obj.getTaint());
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.obj = obj;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.102 -0400", hash_original_method = "44E20F477AE4DBE39F2143CAA1307C1F", hash_generated_method = "AFC4715175CE9BAC48394C0C861C56AE")
    public Message sendMessageSynchronously(Message msg) {
        Message varB4EAC82CA7396A68D541C85D26508E83_2082411150 = null; //Variable for return #1
        Message resultMsg;
        resultMsg = SyncMessenger.sendMessageSynchronously(mDstMessenger, msg);
        varB4EAC82CA7396A68D541C85D26508E83_2082411150 = resultMsg;
        addTaint(msg.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2082411150.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2082411150;
        // ---------- Original Method ----------
        //Message resultMsg = SyncMessenger.sendMessageSynchronously(mDstMessenger, msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.111 -0400", hash_original_method = "42BD69B2114459AD691B3AEBDAE73546", hash_generated_method = "1A0EAF385F7D9E1D73158ACA945F222F")
    public Message sendMessageSynchronously(int what) {
        Message varB4EAC82CA7396A68D541C85D26508E83_863953224 = null; //Variable for return #1
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        varB4EAC82CA7396A68D541C85D26508E83_863953224 = resultMsg;
        addTaint(what);
        varB4EAC82CA7396A68D541C85D26508E83_863953224.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_863953224;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.111 -0400", hash_original_method = "69DA3E1B323882B9D4B744C6E35751A3", hash_generated_method = "1E30A045DE1E05CC7DA5F154F4ED7AAA")
    public Message sendMessageSynchronously(int what, int arg1) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1804210382 = null; //Variable for return #1
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        varB4EAC82CA7396A68D541C85D26508E83_1804210382 = resultMsg;
        addTaint(what);
        addTaint(arg1);
        varB4EAC82CA7396A68D541C85D26508E83_1804210382.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1804210382;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.112 -0400", hash_original_method = "AFDADB0B0E37C71FB8D4BE31CA39F990", hash_generated_method = "26461481877AB8D8851DABB2D3EDC284")
    public Message sendMessageSynchronously(int what, int arg1, int arg2) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1538044998 = null; //Variable for return #1
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        varB4EAC82CA7396A68D541C85D26508E83_1538044998 = resultMsg;
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        varB4EAC82CA7396A68D541C85D26508E83_1538044998.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1538044998;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.113 -0400", hash_original_method = "EEAA69B320108852E46A6304535CC9F5", hash_generated_method = "15EFF466EC07041226B4A39906C0C0B4")
    public Message sendMessageSynchronously(int what, int arg1, int arg2, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_2142238578 = null; //Variable for return #1
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        varB4EAC82CA7396A68D541C85D26508E83_2142238578 = resultMsg;
        addTaint(what);
        addTaint(arg1);
        addTaint(arg2);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2142238578.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2142238578;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //msg.obj = obj;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.123 -0400", hash_original_method = "35A5E39A8A1820326BDEA32FA9EDD100", hash_generated_method = "23C641A807A074683A1F19FE401632A4")
    public Message sendMessageSynchronously(int what, Object obj) {
        Message varB4EAC82CA7396A68D541C85D26508E83_1592346870 = null; //Variable for return #1
        Message msg;
        msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        Message resultMsg;
        resultMsg = sendMessageSynchronously(msg);
        varB4EAC82CA7396A68D541C85D26508E83_1592346870 = resultMsg;
        addTaint(what);
        addTaint(obj.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1592346870.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1592346870;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.obj = obj;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.124 -0400", hash_original_method = "DECE161063975CD41C076FDB9612D509", hash_generated_method = "B9D1831BFFD1B69DD1B6FE733C7B6C26")
    private void replyHalfConnected(int status) {
        Message msg;
        msg = mSrcHandler.obtainMessage(CMD_CHANNEL_HALF_CONNECTED);
        msg.arg1 = status;
        msg.obj = this;
        msg.replyTo = mDstMessenger;
        mSrcHandler.sendMessage(msg);
        addTaint(status);
        // ---------- Original Method ----------
        //Message msg = mSrcHandler.obtainMessage(CMD_CHANNEL_HALF_CONNECTED);
        //msg.arg1 = status;
        //msg.obj = this;
        //msg.replyTo = mDstMessenger;
        //mSrcHandler.sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.124 -0400", hash_original_method = "6CA7282E928AA840C6D25E995C5EBFEA", hash_generated_method = "88C9CD753B8BE61B3A4363A4C1780B2D")
    private void replyDisconnected(int status) {
        Message msg;
        msg = mSrcHandler.obtainMessage(CMD_CHANNEL_DISCONNECTED);
        msg.arg1 = status;
        msg.obj = this;
        msg.replyTo = mDstMessenger;
        mSrcHandler.sendMessage(msg);
        addTaint(status);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.124 -0400", hash_original_field = "4EEFCD2A2A4035CCD511CEED7C58DB1C", hash_generated_field = "3DDB918E56B395BB39CEA1B60967B4FA")

        private HandlerThread mHandlerThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.124 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "F1B2A09EB6C60E9B00FCB576607A28F3")

        private SyncHandler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.125 -0400", hash_original_field = "83FE717B4B643B5D605C868F0E136C03", hash_generated_field = "EF6FF2C2BD8A30E297033DA686E82F32")

        private Messenger mMessenger;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.125 -0400", hash_original_method = "836D007993A4B13DC1AF265962B161E2", hash_generated_method = "C3453B046382A1E37BE69572B5A5208C")
        private  SyncMessenger() {
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.125 -0400", hash_original_method = "FF57C371186B795A0CEFC17D6A21913E", hash_generated_method = "CF1A985945995C6EE9DD3727475CF54A")
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.126 -0400", hash_original_field = "A45638FBBD363E7511A7CC55752D99A2", hash_generated_field = "F4ED03908BB0903225C1F23BCCA22B59")

            private Object mLockObject = new Object();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.126 -0400", hash_original_field = "821BEB084D776D7083F53B82D8CA446F", hash_generated_field = "1581C98D68E5DB7A76672FB90829B905")

            private Message mResultMsg;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.126 -0400", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "8AE03423E5A017F61CD2095B7940F6AD")
            private  SyncHandler(Looper looper) {
                super(looper);
                addTaint(looper.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.126 -0400", hash_original_method = "2469457C965E8FC7C139A1D414384428", hash_generated_method = "44C7D82A06D8AFB626B1DF5CD5302034")
            @Override
            public void handleMessage(Message msg) {
                mResultMsg = Message.obtain();
                mResultMsg.copyFrom(msg);
                {
                    mLockObject.notify();
                } //End block
                addTaint(msg.getTaint());
                // ---------- Original Method ----------
                //mResultMsg = Message.obtain();
                //mResultMsg.copyFrom(msg);
                //synchronized(mLockObject) {
                    //mLockObject.notify();
                //}
            }

            
        }


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.126 -0400", hash_original_field = "32E0B371970B38DE7A4C70F0A6D4ADB2", hash_generated_field = "F3416F3570137CC324435FDCE21F667F")

        private static Stack<SyncMessenger> sStack = new Stack<SyncMessenger>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.126 -0400", hash_original_field = "AB4B446C9A519117945C332D08F2B3AA", hash_generated_field = "0416DF7181AEB41469BF60FA4A630909")

        private static int sCount = 0;
    }


    
    class AsyncChannelConnection implements ServiceConnection {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.126 -0400", hash_original_method = "5CA2E7F994E5D5CA10120B6A293C36BC", hash_generated_method = "A6BACC4CE181C0EB5D92D381782508F2")
          AsyncChannelConnection() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.127 -0400", hash_original_method = "0E2027B9824173FAE83BA1B2B965BB96", hash_generated_method = "66B72A417E647BAA070C9A9AA5588F46")
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            mDstMessenger = new Messenger(service);
            replyHalfConnected(STATUS_SUCCESSFUL);
            addTaint(className.getTaint());
            addTaint(service.getTaint());
            // ---------- Original Method ----------
            //mDstMessenger = new Messenger(service);
            //replyHalfConnected(STATUS_SUCCESSFUL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_method = "050AF9875EBB5531901E44E1327B5019", hash_generated_method = "DB30AD5EA293A01D62B5B8D15B541F3F")
        @Override
        public void onServiceDisconnected(ComponentName className) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            replyDisconnected(STATUS_SUCCESSFUL);
            addTaint(className.getTaint());
            // ---------- Original Method ----------
            //replyDisconnected(STATUS_SUCCESSFUL);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "E3C3F9FDF6D9AEB53E9CF9AD9B38D9F9", hash_generated_field = "C011301214789E186216487AFD25C0C6")

    private static String TAG = "AsyncChannel";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "779C1F1D3686E0AC3092BEEC135D9001", hash_generated_field = "5E2D176F391F66641EF4C65CA8E7A0A4")

    private static int BASE = Protocol.BASE_SYSTEM_ASYNC_CHANNEL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "95A07A59335AACDE68585393F863D004", hash_generated_field = "5922F98D688E75A7DA6D8670F04E1B69")

    public static final int CMD_CHANNEL_HALF_CONNECTED = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "B7BEE252F0BD8FC3350488CD3CBB6812", hash_generated_field = "09022465BCC7090283436B7B026D0301")

    public static final int CMD_CHANNEL_FULL_CONNECTION = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "EFD5B8353E29D041ACBB294F825761D6", hash_generated_field = "08BDA67F386A31687D7F2E728CCB59EF")

    public static final int CMD_CHANNEL_FULLY_CONNECTED = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "CD9064240D73E3135EB494A9D1ED8316", hash_generated_field = "5CF66347F536B38BA730A7CEF6E0CFE9")

    public static final int CMD_CHANNEL_DISCONNECT = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "3FC9A07CB962A7C0A1A7EE392FF6D160", hash_generated_field = "6D1D7878C43DD2115A6EF5986CC11811")

    public static final int CMD_CHANNEL_DISCONNECTED = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "707DC8BC3F4CF3FAADE6DDC746417FF4", hash_generated_field = "BE2B5B401DA0D15F4F87FD186400D2D9")

    public static final int STATUS_SUCCESSFUL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "E872BA8C35702738E004C4886AAB6262", hash_generated_field = "B8538B9846A8FDBE9642FF7E31DD496A")

    public static final int STATUS_BINDING_UNSUCCESSFUL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "93ADC6BE18B0207C4C575F755F0A4A5A", hash_generated_field = "CB11C33E8E76C086F8C44E0468197078")

    public static final int STATUS_SEND_UNSUCCESSFUL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:25.138 -0400", hash_original_field = "529684E8A613CD3A83BD8105CA8E2B95", hash_generated_field = "E6FE28BA2B9755538A9039337B98C62B")

    public static final int STATUS_FULL_CONNECTION_REFUSED_ALREADY_CONNECTED = 3;
}

