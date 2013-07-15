package com.android.internal.util;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.608 -0400", hash_original_field = "8FB9CEDC14BF8DE9558825242E11E275", hash_generated_field = "E0FE31041D4B400F1ECC0924DC307F23")

    private AsyncChannelConnection mConnection;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.608 -0400", hash_original_field = "87C08AEB5A3D17BF072E78C95BF6609A", hash_generated_field = "D92C09EC63748E6484EE8DFEB808CFD6")

    private Context mSrcContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.608 -0400", hash_original_field = "25F77AD5B1AB9A0784B314E923CD2968", hash_generated_field = "BD0D117ED673366AC3516437E5A4C86B")

    private Handler mSrcHandler;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.608 -0400", hash_original_field = "2CD378F6D7DA03699B005770FABF01BA", hash_generated_field = "ADFCAC580CFA427EE53B41262D89A4AC")

    private Messenger mSrcMessenger;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.608 -0400", hash_original_field = "E889B286B5240397E7C14C0C448740E9", hash_generated_field = "12D94F9D13B393CF02D9A14BBEC89054")

    private Messenger mDstMessenger;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.608 -0400", hash_original_method = "FDD6D3EF5F7BC7D6883E0BF7536BB913", hash_generated_method = "CBC4A48158E97A41700C96C588786574")
    public  AsyncChannel() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.608 -0400", hash_original_method = "89C8C4B82DB5AC36CAD55D59C7A76E33", hash_generated_method = "FF904E36AA5B39D83F063CEB72D41589")
    public int connectSrcHandlerToPackageSync(
            Context srcContext, Handler srcHandler, String dstPackageName, String dstClassName) {
        addTaint(dstClassName.getTaint());
        addTaint(dstPackageName.getTaint());
    if(DBG)        
        log("connect srcHandler to dst Package & class E");
        mConnection = new AsyncChannelConnection();
        mSrcContext = srcContext;
        mSrcHandler = srcHandler;
        mSrcMessenger = new Messenger(srcHandler);
        mDstMessenger = null;
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(dstPackageName, dstClassName);
        boolean result = srcContext.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    if(DBG)        
        log("connect srcHandler to dst Package & class X result=" + result);
        int var1AC7C9796BC1520CC7268C33CB683A44_1197773481 = (result ? STATUS_SUCCESSFUL : STATUS_BINDING_UNSUCCESSFUL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479735053 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_479735053;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.609 -0400", hash_original_method = "ABB64391FEF3212581FCE62A24663F37", hash_generated_method = "2F4783141C20DF20D4FCA643EEC7637F")
    public int connectSync(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        addTaint(dstMessenger.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(srcContext.getTaint());
    if(DBG)        
        log("halfConnectSync srcHandler to the dstMessenger  E");
        connected(srcContext, srcHandler, dstMessenger);
    if(DBG)        
        log("halfConnectSync srcHandler to the dstMessenger X");
        int varD23D9492A3BD1374EC1F40BED7C7B412_830205050 = (STATUS_SUCCESSFUL);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877524464 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_877524464;
        // ---------- Original Method ----------
        //if (DBG) log("halfConnectSync srcHandler to the dstMessenger  E");
        //connected(srcContext, srcHandler, dstMessenger);
        //if (DBG) log("halfConnectSync srcHandler to the dstMessenger X");
        //return STATUS_SUCCESSFUL;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.609 -0400", hash_original_method = "E8061690950B5AC4037948D29BFD7764", hash_generated_method = "842E219C46E3AF7C56FB6B9A910030E7")
    public int connectSync(Context srcContext, Handler srcHandler, Handler dstHandler) {
        addTaint(dstHandler.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(srcContext.getTaint());
        int var3A3611EEEC27DF63C067ACCB07382B70_1791917136 = (connectSync(srcContext, srcHandler, new Messenger(dstHandler)));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126969118 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1126969118;
        // ---------- Original Method ----------
        //return connectSync(srcContext, srcHandler, new Messenger(dstHandler));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.609 -0400", hash_original_method = "47E7CF94088222D35244DD2A346F6D10", hash_generated_method = "F9D78476AA79F0FA926CA2333702EED8")
    public int fullyConnectSync(Context srcContext, Handler srcHandler, Handler dstHandler) {
        addTaint(dstHandler.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(srcContext.getTaint());
        int status = connectSync(srcContext, srcHandler, dstHandler);
    if(status == STATUS_SUCCESSFUL)        
        {
            Message response = sendMessageSynchronously(CMD_CHANNEL_FULL_CONNECTION);
            status = response.arg1;
        } //End block
        int var9ACB44549B41563697BB490144EC6258_1324180665 = (status);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594409779 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1594409779;
        // ---------- Original Method ----------
        //int status = connectSync(srcContext, srcHandler, dstHandler);
        //if (status == STATUS_SUCCESSFUL) {
            //Message response = sendMessageSynchronously(CMD_CHANNEL_FULL_CONNECTION);
            //status = response.arg1;
        //}
        //return status;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.610 -0400", hash_original_method = "D2A6022ADF54D8001301F184CF4606D0", hash_generated_method = "AA5D38BAC65BB83D17F547C7E8F14880")
    public void connect(Context srcContext, Handler srcHandler, String dstPackageName,
            String dstClassName) {
        addTaint(dstClassName.getTaint());
        addTaint(dstPackageName.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(srcContext.getTaint());
    if(DBG)        
        log("connect srcHandler to dst Package & class E");
        final class ConnectAsync implements Runnable {
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.609 -0400", hash_original_field = "8B4484FBC1FE4E9FD584DAC7346C7CEC", hash_generated_field = "4B9A8ADECB00B1FBBEDF74A87B7B2E14")
            Context mSrcCtx;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.609 -0400", hash_original_field = "E96852DA8247712DB7EB401462C40821", hash_generated_field = "F848A9BC15E1D508EFDE78836A1E1229")
            Handler mSrcHdlr;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.609 -0400", hash_original_field = "0F52918D1CA58D31CA1BF2218A89271C", hash_generated_field = "09F25A8665AE8101339100B925E40D3B")
            String mDstPackageName;
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.609 -0400", hash_original_field = "07A7F28D26F6AA9DDDAB0EA14CDCA2B4", hash_generated_field = "0B219ED940AA101E1553BAC3E721EBE1")
            String mDstClassName;
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.609 -0400", hash_original_method = "26202A470B4739436FF7E15729D19468", hash_generated_method = "FAA1C1EEB7ED522D3810785DA72A55B9")
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
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.610 -0400", hash_original_method = "16F182387C74E8BFEA3B17CE5A08CAA0", hash_generated_method = "C4A4854D1D30E31E416BAF5B738DF7AC")
            @Override
            public void run() {
                int result = connectSrcHandlerToPackageSync(mSrcCtx, mSrcHdlr, mDstPackageName,
                        mDstClassName);
                replyHalfConnected(result);
                // ---------- Original Method ----------
                //int result = connectSrcHandlerToPackageSync(mSrcCtx, mSrcHdlr, mDstPackageName,
                        //mDstClassName);
                //replyHalfConnected(result);
            }
        }
        ConnectAsync ca = new ConnectAsync(srcContext, srcHandler, dstPackageName, dstClassName);
        new Thread(ca).start();
    if(DBG)        
        log("connect srcHandler to dst Package & class X");
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.610 -0400", hash_original_method = "EF115B092B0444968DFDE421B1D070CE", hash_generated_method = "28F461CC57C0714BB9A1229645B242B1")
    public void connect(Context srcContext, Handler srcHandler, Class<?> klass) {
        addTaint(klass.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(srcContext.getTaint());
        connect(srcContext, srcHandler, klass.getPackage().getName(), klass.getName());
        // ---------- Original Method ----------
        //connect(srcContext, srcHandler, klass.getPackage().getName(), klass.getName());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.610 -0400", hash_original_method = "D9A9DAD002038F54D59084B945A008ED", hash_generated_method = "247E05EC0A294D4C3408E354B226366A")
    public void connect(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
        addTaint(dstMessenger.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(srcContext.getTaint());
    if(DBG)        
        log("connect srcHandler to the dstMessenger  E");
        connected(srcContext, srcHandler, dstMessenger);
        replyHalfConnected(STATUS_SUCCESSFUL);
    if(DBG)        
        log("connect srcHandler to the dstMessenger X");
        // ---------- Original Method ----------
        //if (DBG) log("connect srcHandler to the dstMessenger  E");
        //connected(srcContext, srcHandler, dstMessenger);
        //replyHalfConnected(STATUS_SUCCESSFUL);
        //if (DBG) log("connect srcHandler to the dstMessenger X");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.610 -0400", hash_original_method = "6B74CB8285045DC3058688AFD39174C7", hash_generated_method = "75AEF2C85985F1C59D0D5965095183A9")
    public void connected(Context srcContext, Handler srcHandler, Messenger dstMessenger) {
    if(DBG)        
        log("connected srcHandler to the dstMessenger  E");
        mSrcContext = srcContext;
        mSrcHandler = srcHandler;
        mSrcMessenger = new Messenger(mSrcHandler);
        mDstMessenger = dstMessenger;
    if(DBG)        
        log("connected srcHandler to the dstMessenger X");
        // ---------- Original Method ----------
        //if (DBG) log("connected srcHandler to the dstMessenger  E");
        //mSrcContext = srcContext;
        //mSrcHandler = srcHandler;
        //mSrcMessenger = new Messenger(mSrcHandler);
        //mDstMessenger = dstMessenger;
        //if (DBG) log("connected srcHandler to the dstMessenger X");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.610 -0400", hash_original_method = "30351ACDB73035A90D0CFF564E4380CE", hash_generated_method = "BFF984F76E2467320702BBB5CFDD4355")
    public void connect(Context srcContext, Handler srcHandler, Handler dstHandler) {
        addTaint(dstHandler.getTaint());
        addTaint(srcHandler.getTaint());
        addTaint(srcContext.getTaint());
        connect(srcContext, srcHandler, new Messenger(dstHandler));
        // ---------- Original Method ----------
        //connect(srcContext, srcHandler, new Messenger(dstHandler));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.610 -0400", hash_original_method = "AB6DAC74FF8B2E5B9FEB974F6DCFF3D6", hash_generated_method = "5000A075795BE8819ABC84CEC6ECCF16")
    public void connect(AsyncService srcAsyncService, Messenger dstMessenger) {
        addTaint(dstMessenger.getTaint());
        addTaint(srcAsyncService.getTaint());
        connect(srcAsyncService, srcAsyncService.getHandler(), dstMessenger);
        // ---------- Original Method ----------
        //connect(srcAsyncService, srcAsyncService.getHandler(), dstMessenger);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.611 -0400", hash_original_method = "C231E33C68F8FEC3C6EDCF993CA1BD7A", hash_generated_method = "F0979877F363BD7302AAF19A7B022C1A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.611 -0400", hash_original_method = "206D442C26BC964C7153F638F49072D1", hash_generated_method = "C6EFEACF7B5174667D908753F2F7939F")
    public void disconnect() {
    if((mConnection != null) && (mSrcContext != null))        
        {
            mSrcContext.unbindService(mConnection);
        } //End block
    if(mSrcHandler != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.611 -0400", hash_original_method = "9DAC7AFA4C14A1022E9DEC304018391F", hash_generated_method = "71120F6F2CE7AD5B93EF5EC6250C0885")
    public void sendMessage(Message msg) {
        addTaint(msg.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.611 -0400", hash_original_method = "C8C31043DDFE26EC3BE146F1B2B418E3", hash_generated_method = "06398CE67DCE7135B7A87BF66738FAAA")
    public void sendMessage(int what) {
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.611 -0400", hash_original_method = "6C3F9593FC3095346100149D0CBBAD3F", hash_generated_method = "C613A983AF76765536AE52487EF30E89")
    public void sendMessage(int what, int arg1) {
        addTaint(arg1);
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.611 -0400", hash_original_method = "23E4A4D5EBFE681605B0582F17F8E799", hash_generated_method = "FFB99DE4DDB7E6EB7F4D25F9E91E4BE0")
    public void sendMessage(int what, int arg1, int arg2) {
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        Message msg = Message.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.611 -0400", hash_original_method = "066946089A5EEE9700468FE67EE373C2", hash_generated_method = "FB309C453F4A437ECAD66C01B67215B7")
    public void sendMessage(int what, int arg1, int arg2, Object obj) {
        addTaint(obj.getTaint());
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        Message msg = Message.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.612 -0400", hash_original_method = "D262961B9C2C88432C23CE1E616C0D35", hash_generated_method = "8F88B37C63740F741D5A5BEE52256A61")
    public void sendMessage(int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        sendMessage(msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.obj = obj;
        //sendMessage(msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.612 -0400", hash_original_method = "9F609FC4DF465EEA0A9F2C3A79A2C6B4", hash_generated_method = "068E07885C442793CBD2FE3EF0AFB093")
    public void replyToMessage(Message srcMsg, Message dstMsg) {
        addTaint(dstMsg.getTaint());
        addTaint(srcMsg.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.612 -0400", hash_original_method = "BD4B3A181E1CE5BF498106AFACED886D", hash_generated_method = "4AE15D31F02E7AC85CC871A73AF8E54C")
    public void replyToMessage(Message srcMsg, int what) {
        addTaint(what);
        addTaint(srcMsg.getTaint());
        Message msg = Message.obtain();
        msg.what = what;
        replyToMessage(srcMsg, msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.612 -0400", hash_original_method = "3044254AB71061FF974CD0BBDD0D9BC5", hash_generated_method = "F3ED75FCA64C73C17E7B6B341D2CFD63")
    public void replyToMessage(Message srcMsg, int what, int arg1) {
        addTaint(arg1);
        addTaint(what);
        addTaint(srcMsg.getTaint());
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        replyToMessage(srcMsg, msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.612 -0400", hash_original_method = "DA98F71F7AF234EE48D27745943E51D8", hash_generated_method = "4B0E48CA17934D8321C47F6E44812103")
    public void replyToMessage(Message srcMsg, int what, int arg1, int arg2) {
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        addTaint(srcMsg.getTaint());
        Message msg = Message.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.612 -0400", hash_original_method = "69829FBE15E20ADBF8C45DA9DA2D1745", hash_generated_method = "C40F2D1C923EE5E365997AACB2B21AE3")
    public void replyToMessage(Message srcMsg, int what, int arg1, int arg2, Object obj) {
        addTaint(obj.getTaint());
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        addTaint(srcMsg.getTaint());
        Message msg = Message.obtain();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.613 -0400", hash_original_method = "7A8712370119BFFFB8554DE52F815A80", hash_generated_method = "96C0B74E039C516DA95EBF538BE32A36")
    public void replyToMessage(Message srcMsg, int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        addTaint(srcMsg.getTaint());
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        replyToMessage(srcMsg, msg);
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.obj = obj;
        //replyToMessage(srcMsg, msg);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.613 -0400", hash_original_method = "44E20F477AE4DBE39F2143CAA1307C1F", hash_generated_method = "8BA608D869E60CDBDB40FE8BF6AEA4B5")
    public Message sendMessageSynchronously(Message msg) {
        addTaint(msg.getTaint());
        Message resultMsg = SyncMessenger.sendMessageSynchronously(mDstMessenger, msg);
Message varB356C499DD5E97FACB94A386F09DEB99_62572991 =         resultMsg;
        varB356C499DD5E97FACB94A386F09DEB99_62572991.addTaint(taint);
        return varB356C499DD5E97FACB94A386F09DEB99_62572991;
        // ---------- Original Method ----------
        //Message resultMsg = SyncMessenger.sendMessageSynchronously(mDstMessenger, msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.613 -0400", hash_original_method = "42BD69B2114459AD691B3AEBDAE73546", hash_generated_method = "86B24F2166E818828A40BB7C5DFEF9CF")
    public Message sendMessageSynchronously(int what) {
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        Message resultMsg = sendMessageSynchronously(msg);
Message varB356C499DD5E97FACB94A386F09DEB99_218215309 =         resultMsg;
        varB356C499DD5E97FACB94A386F09DEB99_218215309.addTaint(taint);
        return varB356C499DD5E97FACB94A386F09DEB99_218215309;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.613 -0400", hash_original_method = "69DA3E1B323882B9D4B744C6E35751A3", hash_generated_method = "9D7AB1457F74CA8CAC5B1E63F7B61F12")
    public Message sendMessageSynchronously(int what, int arg1) {
        addTaint(arg1);
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        Message resultMsg = sendMessageSynchronously(msg);
Message varB356C499DD5E97FACB94A386F09DEB99_1702424420 =         resultMsg;
        varB356C499DD5E97FACB94A386F09DEB99_1702424420.addTaint(taint);
        return varB356C499DD5E97FACB94A386F09DEB99_1702424420;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.613 -0400", hash_original_method = "AFDADB0B0E37C71FB8D4BE31CA39F990", hash_generated_method = "CD3F3B508B90CC6FEDCB179E8127D676")
    public Message sendMessageSynchronously(int what, int arg1, int arg2) {
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        Message resultMsg = sendMessageSynchronously(msg);
Message varB356C499DD5E97FACB94A386F09DEB99_1205224704 =         resultMsg;
        varB356C499DD5E97FACB94A386F09DEB99_1205224704.addTaint(taint);
        return varB356C499DD5E97FACB94A386F09DEB99_1205224704;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.614 -0400", hash_original_method = "EEAA69B320108852E46A6304535CC9F5", hash_generated_method = "069211001D1B75336711B1D4173E22A8")
    public Message sendMessageSynchronously(int what, int arg1, int arg2, Object obj) {
        addTaint(obj.getTaint());
        addTaint(arg2);
        addTaint(arg1);
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        msg.arg1 = arg1;
        msg.arg2 = arg2;
        msg.obj = obj;
        Message resultMsg = sendMessageSynchronously(msg);
Message varB356C499DD5E97FACB94A386F09DEB99_1656322970 =         resultMsg;
        varB356C499DD5E97FACB94A386F09DEB99_1656322970.addTaint(taint);
        return varB356C499DD5E97FACB94A386F09DEB99_1656322970;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.arg1 = arg1;
        //msg.arg2 = arg2;
        //msg.obj = obj;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.614 -0400", hash_original_method = "35A5E39A8A1820326BDEA32FA9EDD100", hash_generated_method = "BFE83329A71F8A5741CA15D157217384")
    public Message sendMessageSynchronously(int what, Object obj) {
        addTaint(obj.getTaint());
        addTaint(what);
        Message msg = Message.obtain();
        msg.what = what;
        msg.obj = obj;
        Message resultMsg = sendMessageSynchronously(msg);
Message varB356C499DD5E97FACB94A386F09DEB99_1394197526 =         resultMsg;
        varB356C499DD5E97FACB94A386F09DEB99_1394197526.addTaint(taint);
        return varB356C499DD5E97FACB94A386F09DEB99_1394197526;
        // ---------- Original Method ----------
        //Message msg = Message.obtain();
        //msg.what = what;
        //msg.obj = obj;
        //Message resultMsg = sendMessageSynchronously(msg);
        //return resultMsg;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.614 -0400", hash_original_method = "DECE161063975CD41C076FDB9612D509", hash_generated_method = "3F55CE226FF42AC005882C002699E92C")
    private void replyHalfConnected(int status) {
        addTaint(status);
        Message msg = mSrcHandler.obtainMessage(CMD_CHANNEL_HALF_CONNECTED);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.614 -0400", hash_original_method = "6CA7282E928AA840C6D25E995C5EBFEA", hash_generated_method = "5BE3C2E2B91740B7EE24A0C23E43AEED")
    private void replyDisconnected(int status) {
        addTaint(status);
        Message msg = mSrcHandler.obtainMessage(CMD_CHANNEL_DISCONNECTED);
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
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.614 -0400", hash_original_field = "4EEFCD2A2A4035CCD511CEED7C58DB1C", hash_generated_field = "3DDB918E56B395BB39CEA1B60967B4FA")

        private HandlerThread mHandlerThread;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.614 -0400", hash_original_field = "C78BEDFC523DB73DF63EFB071AF1C35B", hash_generated_field = "F1B2A09EB6C60E9B00FCB576607A28F3")

        private SyncHandler mHandler;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_field = "83FE717B4B643B5D605C868F0E136C03", hash_generated_field = "EF6FF2C2BD8A30E297033DA686E82F32")

        private Messenger mMessenger;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_method = "836D007993A4B13DC1AF265962B161E2", hash_generated_method = "C3453B046382A1E37BE69572B5A5208C")
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

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_method = "FF57C371186B795A0CEFC17D6A21913E", hash_generated_method = "CAF6CD4E18F4A1C91FFBF693F6326B2C")
        private void recycle() {
            synchronized
(sStack)            {
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
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_field = "A45638FBBD363E7511A7CC55752D99A2", hash_generated_field = "F4ED03908BB0903225C1F23BCCA22B59")

            private Object mLockObject = new Object();
            @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_field = "821BEB084D776D7083F53B82D8CA446F", hash_generated_field = "1581C98D68E5DB7A76672FB90829B905")

            private Message mResultMsg;
            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_method = "483F6356A2D06E95B4EBFBB05049FAB5", hash_generated_method = "8AE03423E5A017F61CD2095B7940F6AD")
            private  SyncHandler(Looper looper) {
                super(looper);
                addTaint(looper.getTaint());
                // ---------- Original Method ----------
            }

            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_method = "2469457C965E8FC7C139A1D414384428", hash_generated_method = "B68F6F5AFC2CC313B0558FB987D81D3F")
            @Override
            public void handleMessage(Message msg) {
                addTaint(msg.getTaint());
                mResultMsg = Message.obtain();
                mResultMsg.copyFrom(msg);
                synchronized
(mLockObject)                {
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


        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_field = "32E0B371970B38DE7A4C70F0A6D4ADB2", hash_generated_field = "F3416F3570137CC324435FDCE21F667F")

        private static Stack<SyncMessenger> sStack = new Stack<SyncMessenger>();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_field = "AB4B446C9A519117945C332D08F2B3AA", hash_generated_field = "0416DF7181AEB41469BF60FA4A630909")

        private static int sCount = 0;
    }


    
    class AsyncChannelConnection implements ServiceConnection {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_method = "5CA2E7F994E5D5CA10120B6A293C36BC", hash_generated_method = "A6BACC4CE181C0EB5D92D381782508F2")
          AsyncChannelConnection() {
            // ---------- Original Method ----------
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.615 -0400", hash_original_method = "0E2027B9824173FAE83BA1B2B965BB96", hash_generated_method = "AF4832D931480F2287E43C9F8D5B6162")
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(service.getTaint());
            addTaint(className.getTaint());
            mDstMessenger = new Messenger(service);
            replyHalfConnected(STATUS_SUCCESSFUL);
            // ---------- Original Method ----------
            //mDstMessenger = new Messenger(service);
            //replyHalfConnected(STATUS_SUCCESSFUL);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_method = "050AF9875EBB5531901E44E1327B5019", hash_generated_method = "9B68FC3708EF5E8A7003120A0B0EC98A")
        @Override
        public void onServiceDisconnected(ComponentName className) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            addTaint(className.getTaint());
            replyDisconnected(STATUS_SUCCESSFUL);
            // ---------- Original Method ----------
            //replyDisconnected(STATUS_SUCCESSFUL);
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "E3C3F9FDF6D9AEB53E9CF9AD9B38D9F9", hash_generated_field = "ED89618E6E1B400B84A83667045BD90E")

    private static final String TAG = "AsyncChannel";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "779C1F1D3686E0AC3092BEEC135D9001", hash_generated_field = "080FE22C2EA5E5AA1B11A1E7CA05F0C9")

    private static final int BASE = Protocol.BASE_SYSTEM_ASYNC_CHANNEL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "95A07A59335AACDE68585393F863D004", hash_generated_field = "5922F98D688E75A7DA6D8670F04E1B69")

    public static final int CMD_CHANNEL_HALF_CONNECTED = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "B7BEE252F0BD8FC3350488CD3CBB6812", hash_generated_field = "09022465BCC7090283436B7B026D0301")

    public static final int CMD_CHANNEL_FULL_CONNECTION = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "EFD5B8353E29D041ACBB294F825761D6", hash_generated_field = "08BDA67F386A31687D7F2E728CCB59EF")

    public static final int CMD_CHANNEL_FULLY_CONNECTED = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "CD9064240D73E3135EB494A9D1ED8316", hash_generated_field = "5CF66347F536B38BA730A7CEF6E0CFE9")

    public static final int CMD_CHANNEL_DISCONNECT = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "3FC9A07CB962A7C0A1A7EE392FF6D160", hash_generated_field = "6D1D7878C43DD2115A6EF5986CC11811")

    public static final int CMD_CHANNEL_DISCONNECTED = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "707DC8BC3F4CF3FAADE6DDC746417FF4", hash_generated_field = "BE2B5B401DA0D15F4F87FD186400D2D9")

    public static final int STATUS_SUCCESSFUL = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "E872BA8C35702738E004C4886AAB6262", hash_generated_field = "B8538B9846A8FDBE9642FF7E31DD496A")

    public static final int STATUS_BINDING_UNSUCCESSFUL = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "93ADC6BE18B0207C4C575F755F0A4A5A", hash_generated_field = "CB11C33E8E76C086F8C44E0468197078")

    public static final int STATUS_SEND_UNSUCCESSFUL = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:29.616 -0400", hash_original_field = "529684E8A613CD3A83BD8105CA8E2B95", hash_generated_field = "E6FE28BA2B9755538A9039337B98C62B")

    public static final int STATUS_FULL_CONNECTION_REFUSED_ALREADY_CONNECTED = 3;
}

