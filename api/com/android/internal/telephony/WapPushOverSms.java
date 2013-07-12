package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.581 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.581 -0400", hash_original_field = "0AA6A27FDD2FC4686B0130DC2EF1F1A6", hash_generated_field = "FBAD2745825D1B222348829BBBC8E895")

    private WspTypeDecoder pduDecoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.581 -0400", hash_original_field = "F11105C2360034694823CFE7B5E6E57A", hash_generated_field = "8A503E14FA7AF8D4DA2D53FAF75ACC91")

    private SMSDispatcher mSmsDispatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.581 -0400", hash_original_field = "B59EE70074140F54FE9A40B8C9352A9F", hash_generated_field = "13F904337FC0CFFAC686B97782F492B2")

    private final int WAKE_LOCK_TIMEOUT = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.581 -0400", hash_original_field = "4979845A35EE0C8B32FFD337F10C9BAB", hash_generated_field = "12DDD756FBB753EEF6004C34AE7CA6CD")

    private final int BIND_RETRY_INTERVAL = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.581 -0400", hash_original_field = "6071D8563814B2E940C241A34283E2C4", hash_generated_field = "3B39AAC7E4A10A6ACE8511A3256C9AEB")

    private WapPushConnection mWapConn = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.582 -0400", hash_original_method = "7408CC3A8D1F62FE40C38A48E5413064", hash_generated_method = "ACDB8A63C6AB0F97DDE14EB0A53DC58A")
    public  WapPushOverSms(Phone phone, SMSDispatcher smsDispatcher) {
        mSmsDispatcher = smsDispatcher;
        mContext = phone.getContext();
        mWapConn = new WapPushConnection(mContext);
        mWapConn.bindWapPushManager();
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.585 -0400", hash_original_method = "B943BA9A516C7D27398DA677689F619E", hash_generated_method = "C8769F39EF21DAED03F96D4E82C29D5B")
    public int dispatchWapPdu(byte[] pdu) {
    if(false)        
        Log.d(LOG_TAG, "Rx: " + IccUtils.bytesToHexString(pdu));
        int index = 0;
        int transactionId = pdu[index++] & 0xFF;
        int pduType = pdu[index++] & 0xFF;
        int headerLength = 0;
    if((pduType != WspTypeDecoder.PDU_TYPE_PUSH) &&
                (pduType != WspTypeDecoder.PDU_TYPE_CONFIRMED_PUSH))        
        {
    if(false){ }            int var0A0A6D68560CC5EF46A3B9603DD175AA_1406350221 = (Intents.RESULT_SMS_HANDLED);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359856520 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1359856520;
        } 
        pduDecoder = new WspTypeDecoder(pdu);
    if(pduDecoder.decodeUintvarInteger(index) == false)        
        {
    if(false){ }            int varFCC16322707A95E5743FED9CA64177EC_1519801118 = (Intents.RESULT_SMS_GENERIC_ERROR);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052947014 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2052947014;
        } 
        headerLength = (int)pduDecoder.getValue32();
        index += pduDecoder.getDecodedDataLength();
        int headerStartIndex = index;
    if(pduDecoder.decodeContentType(index) == false)        
        {
    if(false){ }            int varFCC16322707A95E5743FED9CA64177EC_160860967 = (Intents.RESULT_SMS_GENERIC_ERROR);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505257795 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_505257795;
        } 
        String mimeType = pduDecoder.getValueString();
        long binaryContentType = pduDecoder.getValue32();
        index += pduDecoder.getDecodedDataLength();
        byte[] header = new byte[headerLength];
        System.arraycopy(pdu, headerStartIndex, header, 0, header.length);
        byte[] intentData;
    if(mimeType != null && mimeType.equals(WspTypeDecoder.CONTENT_TYPE_B_PUSH_CO))        
        {
            intentData = pdu;
        } 
        else
        {
            int dataIndex = headerStartIndex + headerLength;
            intentData = new byte[pdu.length - dataIndex];
            System.arraycopy(pdu, dataIndex, intentData, 0, intentData.length);
        } 
    if(pduDecoder.seekXWapApplicationId(index, index + headerLength - 1))        
        {
            index = (int) pduDecoder.getValue32();
            pduDecoder.decodeXWapApplicationId(index);
            String wapAppId = pduDecoder.getValueString();
    if(wapAppId == null)            
            {
                wapAppId = Integer.toString((int) pduDecoder.getValue32());
            } 
            String contentType = ((mimeType == null) ?
                                  Long.toString(binaryContentType) : mimeType);
    if(false){ }            try 
            {
                boolean processFurther = true;
                IWapPushManager wapPushMan = mWapConn.getWapPushManager();
    if(wapPushMan == null)                
                {
    if(false){ }
                } 
                else
                {
                    Intent intent = new Intent();
                    intent.putExtra("transactionId", transactionId);
                    intent.putExtra("pduType", pduType);
                    intent.putExtra("header", header);
                    intent.putExtra("data", intentData);
                    intent.putExtra("contentTypeParameters",
                            pduDecoder.getContentParameters());
                    int procRet = wapPushMan.processMessage(wapAppId, contentType, intent);
    if(false){ }    if((procRet & WapPushManagerParams.MESSAGE_HANDLED) > 0
                        && (procRet & WapPushManagerParams.FURTHER_PROCESSING) == 0)                    
                    {
                        processFurther = false;
                    } 
                } 
    if(!processFurther)                
                {
                    int var0A0A6D68560CC5EF46A3B9603DD175AA_1755048248 = (Intents.RESULT_SMS_HANDLED);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51165101 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_51165101;
                } 
            } 
            catch (RemoteException e)
            {
    if(false){ }
            } 
        } 
    if(false){ }    if(mimeType == null)        
        {
    if(false){ }            int varFCC16322707A95E5743FED9CA64177EC_154623763 = (Intents.RESULT_SMS_GENERIC_ERROR);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938456150 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_938456150;
        } 
        String permission;
    if(mimeType.equals(WspTypeDecoder.CONTENT_TYPE_B_MMS))        
        {
            permission = "android.permission.RECEIVE_MMS";
        } 
        else
        {
            permission = "android.permission.RECEIVE_WAP_PUSH";
        } 
        Intent intent = new Intent(Intents.WAP_PUSH_RECEIVED_ACTION);
        intent.setType(mimeType);
        intent.putExtra("transactionId", transactionId);
        intent.putExtra("pduType", pduType);
        intent.putExtra("header", header);
        intent.putExtra("data", intentData);
        intent.putExtra("contentTypeParameters", pduDecoder.getContentParameters());
        mSmsDispatcher.dispatch(intent, permission);
        int var4C0737507AD994723C875A6D0646D112_120545607 = (Activity.RESULT_OK);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372930462 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_372930462;
        
        
    }

    
    private class WapPushConnection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.587 -0400", hash_original_field = "CCA62189095B8E2A2A60E84892187701", hash_generated_field = "A8578F8CE8534FC6D53552C1463CAA5B")

        private IWapPushManager mWapPushMan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.587 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "21FCFBF4943D37471C748C457AFF3D5B")

        private Context mOwner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.587 -0400", hash_original_method = "0BE0ADFB7F6B93B695220B7DE6F98A35", hash_generated_method = "6773F021BC021CF2B844CE5946D38111")
        public  WapPushConnection(Context ownerContext) {
            mOwner = ownerContext;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.587 -0400", hash_original_method = "D2C26FA4308EBF4ECDE771359B9348B6", hash_generated_method = "BA01D31387E9E544C417CDE93BF74D3B")
        public void onServiceConnected(ComponentName name, IBinder service) {
            
            addTaint(name.getTaint());
            mWapPushMan = IWapPushManager.Stub.asInterface(service);
    if(false){ }
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.588 -0400", hash_original_method = "645B7220F43862050D99493B740CC6E9", hash_generated_method = "87B539341ED60A91E0FF00E74F73D6E0")
        public void onServiceDisconnected(ComponentName name) {
            
            addTaint(name.getTaint());
            mWapPushMan = null;
    if(false){ }            rebindWapPushManager();
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.588 -0400", hash_original_method = "A9E3FC2EB163E786A448AD9CCAE84A6D", hash_generated_method = "DA76A9D86BC32FCA02677E35464696A9")
        public void bindWapPushManager() {
    if(mWapPushMan != null)            
            return;
            final ServiceConnection wapPushConnection = this;
            mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                    wapPushConnection, Context.BIND_AUTO_CREATE);
            
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.589 -0400", hash_original_method = "701141D5EA76AC5255B679005307FF1D", hash_generated_method = "25A2823DF511C45AE01CB5C9EE7AFDBB")
        private void rebindWapPushManager() {
    if(mWapPushMan != null)            
            return;
            final ServiceConnection wapPushConnection = this;
            new Thread() {            
            @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.589 -0400", hash_original_method = "D137F80D797649529A6233BF034F00A3", hash_generated_method = "1CCA105E185A52B120ADF38133E95DE3")
            public void run() {
                while
(mWapPushMan == null)                
                {
                    mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                                wapPushConnection, Context.BIND_AUTO_CREATE);
                    try 
                    {
                        Thread.sleep(BIND_RETRY_INTERVAL);
                    } 
                    catch (InterruptedException e)
                    {
    if(false){ }
                    } 
                } 
                
                
                        
                                
                        
                            
                        
                            
                        
                    
            }
}.start();
            
            
            
            
                
                    
                        
                                
                        
                            
                        
                            
                        
                    
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.590 -0400", hash_original_method = "12BA8034F310D7C3159CADAC53085388", hash_generated_method = "A5FE12ECD2C3498F7A80B826CA020BD8")
        public IWapPushManager getWapPushManager() {
IWapPushManager var28BA9EE784314DA2EAA57CCAF5310288_281883517 =             mWapPushMan;
            var28BA9EE784314DA2EAA57CCAF5310288_281883517.addTaint(taint);
            return var28BA9EE784314DA2EAA57CCAF5310288_281883517;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:23.590 -0400", hash_original_field = "F65C4BFC2898CC57B0F9A23376622D99", hash_generated_field = "D83C831CD0AB23E53B0E52B2C0EB27F8")

    private static final String LOG_TAG = "WAP PUSH";
}

