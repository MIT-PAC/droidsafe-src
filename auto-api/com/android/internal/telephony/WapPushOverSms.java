package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.Activity;
import android.content.Context;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.provider.Telephony;
import android.provider.Telephony.Sms.Intents;
import android.util.Log;
import android.os.IBinder;
import android.os.RemoteException;

public class WapPushOverSms {
    private Context mContext;
    private WspTypeDecoder pduDecoder;
    private SMSDispatcher mSmsDispatcher;
    private int WAKE_LOCK_TIMEOUT = 5000;
    private int BIND_RETRY_INTERVAL = 1000;
    private WapPushConnection mWapConn = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.564 -0400", hash_original_method = "7408CC3A8D1F62FE40C38A48E5413064", hash_generated_method = "455BB483360559BAFD03C63335C9EEE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WapPushOverSms(Phone phone, SMSDispatcher smsDispatcher) {
        dsTaint.addTaint(phone.dsTaint);
        dsTaint.addTaint(smsDispatcher.dsTaint);
        mContext = phone.getContext();
        mWapConn = new WapPushConnection(mContext);
        mWapConn.bindWapPushManager();
        // ---------- Original Method ----------
        //mSmsDispatcher = smsDispatcher;
        //mContext = phone.getContext();
        //mWapConn = new WapPushConnection(mContext);
        //mWapConn.bindWapPushManager();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.566 -0400", hash_original_method = "B943BA9A516C7D27398DA677689F619E", hash_generated_method = "3F4B9CBB5476A7CBBEE6EBD89B6870EE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int dispatchWapPdu(byte[] pdu) {
        dsTaint.addTaint(pdu[0]);
        Log.d(LOG_TAG, "Rx: " + IccUtils.bytesToHexString(pdu));
        int index;
        index = 0;
        int transactionId;
        transactionId = pdu[index++] & 0xFF;
        int pduType;
        pduType = pdu[index++] & 0xFF;
        int headerLength;
        headerLength = 0;
        pduDecoder = new WspTypeDecoder(pdu);
        {
            boolean var35052BC982F7CCDBF4CA85F6551C0695_1160439112 = (pduDecoder.decodeUintvarInteger(index) == false);
        } //End collapsed parenthetic
        headerLength = (int)pduDecoder.getValue32();
        index += pduDecoder.getDecodedDataLength();
        int headerStartIndex;
        headerStartIndex = index;
        {
            boolean varDC974DB11A37B499191291CB84F1A7AB_1495684265 = (pduDecoder.decodeContentType(index) == false);
        } //End collapsed parenthetic
        String mimeType;
        mimeType = pduDecoder.getValueString();
        long binaryContentType;
        binaryContentType = pduDecoder.getValue32();
        index += pduDecoder.getDecodedDataLength();
        byte[] header;
        header = new byte[headerLength];
        System.arraycopy(pdu, headerStartIndex, header, 0, header.length);
        byte[] intentData;
        {
            boolean varEA723A1CF765924E9A1722B0423C4C7B_713720446 = (mimeType != null && mimeType.equals(WspTypeDecoder.CONTENT_TYPE_B_PUSH_CO));
            {
                intentData = pdu;
            } //End block
            {
                int dataIndex;
                dataIndex = headerStartIndex + headerLength;
                intentData = new byte[pdu.length - dataIndex];
                System.arraycopy(pdu, dataIndex, intentData, 0, intentData.length);
            } //End block
        } //End collapsed parenthetic
        {
            boolean var73A914DEAFC4E11C193B04C5E1414436_992063368 = (pduDecoder.seekXWapApplicationId(index, index + headerLength - 1));
            {
                index = (int) pduDecoder.getValue32();
                pduDecoder.decodeXWapApplicationId(index);
                String wapAppId;
                wapAppId = pduDecoder.getValueString();
                {
                    wapAppId = Integer.toString((int) pduDecoder.getValue32());
                } //End block
                String contentType;
                contentType = ((mimeType == null) ?
                                  Long.toString(binaryContentType) : mimeType);//DSFIXME:  CODE0008: Nested ternary operator in expression
                try 
                {
                    boolean processFurther;
                    processFurther = true;
                    IWapPushManager wapPushMan;
                    wapPushMan = mWapConn.getWapPushManager();
                    {
                        Intent intent;
                        intent = new Intent();
                        intent.putExtra("transactionId", transactionId);
                        intent.putExtra("pduType", pduType);
                        intent.putExtra("header", header);
                        intent.putExtra("data", intentData);
                        intent.putExtra("contentTypeParameters",
                            pduDecoder.getContentParameters());
                        int procRet;
                        procRet = wapPushMan.processMessage(wapAppId, contentType, intent);
                        {
                            processFurther = false;
                        } //End block
                    } //End block
                } //End block
                catch (RemoteException e)
                { }
            } //End block
        } //End collapsed parenthetic
        String permission;
        {
            boolean var8A3CC5996CA16A71178112B420F9FE7A_659157924 = (mimeType.equals(WspTypeDecoder.CONTENT_TYPE_B_MMS));
            {
                permission = "android.permission.RECEIVE_MMS";
            } //End block
            {
                permission = "android.permission.RECEIVE_WAP_PUSH";
            } //End block
        } //End collapsed parenthetic
        Intent intent;
        intent = new Intent(Intents.WAP_PUSH_RECEIVED_ACTION);
        intent.setType(mimeType);
        intent.putExtra("transactionId", transactionId);
        intent.putExtra("pduType", pduType);
        intent.putExtra("header", header);
        intent.putExtra("data", intentData);
        intent.putExtra("contentTypeParameters", pduDecoder.getContentParameters());
        mSmsDispatcher.dispatch(intent, permission);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private class WapPushConnection implements ServiceConnection {
        private IWapPushManager mWapPushMan;
        private Context mOwner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.567 -0400", hash_original_method = "0BE0ADFB7F6B93B695220B7DE6F98A35", hash_generated_method = "C03857BAEC9DCB969CE13B4DE4A94640")
        @DSModeled(DSC.SAFE)
        public WapPushConnection(Context ownerContext) {
            dsTaint.addTaint(ownerContext.dsTaint);
            // ---------- Original Method ----------
            //mOwner = ownerContext;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.567 -0400", hash_original_method = "D2C26FA4308EBF4ECDE771359B9348B6", hash_generated_method = "DC91A3A5CACA0179FAEABFAAC7410EE1")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceConnected(ComponentName name, IBinder service) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name.dsTaint);
            dsTaint.addTaint(service.dsTaint);
            mWapPushMan = IWapPushManager.Stub.asInterface(service);
            // ---------- Original Method ----------
            //mWapPushMan = IWapPushManager.Stub.asInterface(service);
            //if (false) Log.v(LOG_TAG, "wappush manager connected to " +
                    //mOwner.hashCode());
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.568 -0400", hash_original_method = "645B7220F43862050D99493B740CC6E9", hash_generated_method = "32AD0EFB89CAD19BE7B08D7FC83DFAB3")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void onServiceDisconnected(ComponentName name) {
            //DSFIXME:  CODE0009: Possible callback target function detected
            dsTaint.addTaint(name.dsTaint);
            mWapPushMan = null;
            rebindWapPushManager();
            // ---------- Original Method ----------
            //mWapPushMan = null;
            //if (false) Log.v(LOG_TAG, "wappush manager disconnected.");
            //rebindWapPushManager();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.568 -0400", hash_original_method = "A9E3FC2EB163E786A448AD9CCAE84A6D", hash_generated_method = "1BAC95B31D0AB236183A43D15202264F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public void bindWapPushManager() {
            ServiceConnection wapPushConnection;
            wapPushConnection = this;
            mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                    wapPushConnection, Context.BIND_AUTO_CREATE);
            // ---------- Original Method ----------
            //if (mWapPushMan != null) return;
            //final ServiceConnection wapPushConnection = this;
            //mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                    //wapPushConnection, Context.BIND_AUTO_CREATE);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.569 -0400", hash_original_method = "701141D5EA76AC5255B679005307FF1D", hash_generated_method = "9B50524F2EAE21785A549E22B2B538A0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        private void rebindWapPushManager() {
            ServiceConnection wapPushConnection;
            wapPushConnection = this;
            new Thread() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.569 -0400", hash_original_method = "D137F80D797649529A6233BF034F00A3", hash_generated_method = "6F4F99E976DDC8A426C7946B8B2429BB")
                //DSFIXME:  CODE0002: Requires DSC value to be set
                public void run() {
                    {
                        mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                                wapPushConnection, Context.BIND_AUTO_CREATE);
                        try 
                        {
                            Thread.sleep(BIND_RETRY_INTERVAL);
                        } //End block
                        catch (InterruptedException e)
                        { }
                    } //End block
                    // ---------- Original Method ----------
                    //while (mWapPushMan == null) {
                        //mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                                //wapPushConnection, Context.BIND_AUTO_CREATE);
                        //try {
                            //Thread.sleep(BIND_RETRY_INTERVAL);
                        //} catch (InterruptedException e) {
                            //if (false) Log.v(LOG_TAG, "sleep interrupted.");
                        //}
                    //}
                }
}.start();
            // ---------- Original Method ----------
            //if (mWapPushMan != null) return;
            //final ServiceConnection wapPushConnection = this;
            //new Thread() {
                //public void run() {
                    //while (mWapPushMan == null) {
                        //mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                                //wapPushConnection, Context.BIND_AUTO_CREATE);
                        //try {
                            //Thread.sleep(BIND_RETRY_INTERVAL);
                        //} catch (InterruptedException e) {
                            //if (false) Log.v(LOG_TAG, "sleep interrupted.");
                        //}
                    //}
                //}
            //}.start();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:12.569 -0400", hash_original_method = "12BA8034F310D7C3159CADAC53085388", hash_generated_method = "B44B8F7AE5EE17D33046E1871D5AEE0D")
        @DSModeled(DSC.SAFE)
        public IWapPushManager getWapPushManager() {
            return (IWapPushManager)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return mWapPushMan;
        }

        
    }


    
    private static final String LOG_TAG = "WAP PUSH";
}

