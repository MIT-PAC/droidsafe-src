package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.062 -0400", hash_original_field = "51EF5995AD6B82C50AE546C1599EFFFA", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private Context mContext;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.062 -0400", hash_original_field = "0AA6A27FDD2FC4686B0130DC2EF1F1A6", hash_generated_field = "FBAD2745825D1B222348829BBBC8E895")

    private WspTypeDecoder pduDecoder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.062 -0400", hash_original_field = "F11105C2360034694823CFE7B5E6E57A", hash_generated_field = "8A503E14FA7AF8D4DA2D53FAF75ACC91")

    private SMSDispatcher mSmsDispatcher;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.062 -0400", hash_original_field = "B59EE70074140F54FE9A40B8C9352A9F", hash_generated_field = "13F904337FC0CFFAC686B97782F492B2")

    private final int WAKE_LOCK_TIMEOUT = 5000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.062 -0400", hash_original_field = "4979845A35EE0C8B32FFD337F10C9BAB", hash_generated_field = "12DDD756FBB753EEF6004C34AE7CA6CD")

    private final int BIND_RETRY_INTERVAL = 1000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.062 -0400", hash_original_field = "6071D8563814B2E940C241A34283E2C4", hash_generated_field = "3B39AAC7E4A10A6ACE8511A3256C9AEB")

    private WapPushConnection mWapConn = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.063 -0400", hash_original_method = "7408CC3A8D1F62FE40C38A48E5413064", hash_generated_method = "ACDB8A63C6AB0F97DDE14EB0A53DC58A")
    public  WapPushOverSms(Phone phone, SMSDispatcher smsDispatcher) {
        mSmsDispatcher = smsDispatcher;
        mContext = phone.getContext();
        mWapConn = new WapPushConnection(mContext);
        mWapConn.bindWapPushManager();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.064 -0400", hash_original_method = "B943BA9A516C7D27398DA677689F619E", hash_generated_method = "339797C43465407A25BD9A51775CF9AB")
    public int dispatchWapPdu(byte[] pdu) {
        Log.d(LOG_TAG, "Rx: " + IccUtils.bytesToHexString(pdu));
        int index = 0;
        int transactionId = pdu[index++] & 0xFF;
        int pduType = pdu[index++] & 0xFF;
        int headerLength = 0;
        pduDecoder = new WspTypeDecoder(pdu);
        {
            boolean var35052BC982F7CCDBF4CA85F6551C0695_1513959773 = (pduDecoder.decodeUintvarInteger(index) == false);
        } 
        headerLength = (int)pduDecoder.getValue32();
        index += pduDecoder.getDecodedDataLength();
        int headerStartIndex = index;
        {
            boolean varDC974DB11A37B499191291CB84F1A7AB_1223155772 = (pduDecoder.decodeContentType(index) == false);
        } 
        String mimeType = pduDecoder.getValueString();
        long binaryContentType = pduDecoder.getValue32();
        index += pduDecoder.getDecodedDataLength();
        byte[] header = new byte[headerLength];
        System.arraycopy(pdu, headerStartIndex, header, 0, header.length);
        byte[] intentData;
        {
            boolean varEA723A1CF765924E9A1722B0423C4C7B_832430861 = (mimeType != null && mimeType.equals(WspTypeDecoder.CONTENT_TYPE_B_PUSH_CO));
            {
                intentData = pdu;
            } 
            {
                int dataIndex = headerStartIndex + headerLength;
                intentData = new byte[pdu.length - dataIndex];
                System.arraycopy(pdu, dataIndex, intentData, 0, intentData.length);
            } 
        } 
        {
            boolean var73A914DEAFC4E11C193B04C5E1414436_1700652578 = (pduDecoder.seekXWapApplicationId(index, index + headerLength - 1));
            {
                index = (int) pduDecoder.getValue32();
                pduDecoder.decodeXWapApplicationId(index);
                String wapAppId = pduDecoder.getValueString();
                {
                    wapAppId = Integer.toString((int) pduDecoder.getValue32());
                } 
                String contentType = ((mimeType == null) ?
                                  Long.toString(binaryContentType) : mimeType);
                try 
                {
                    boolean processFurther = true;
                    IWapPushManager wapPushMan = mWapConn.getWapPushManager();
                    {
                        Intent intent = new Intent();
                        intent.putExtra("transactionId", transactionId);
                        intent.putExtra("pduType", pduType);
                        intent.putExtra("header", header);
                        intent.putExtra("data", intentData);
                        intent.putExtra("contentTypeParameters",
                            pduDecoder.getContentParameters());
                        int procRet = wapPushMan.processMessage(wapAppId, contentType, intent);
                        {
                            processFurther = false;
                        } 
                    } 
                } 
                catch (RemoteException e)
                { }
            } 
        } 
        String permission;
        {
            boolean var8A3CC5996CA16A71178112B420F9FE7A_82543359 = (mimeType.equals(WspTypeDecoder.CONTENT_TYPE_B_MMS));
            {
                permission = "android.permission.RECEIVE_MMS";
            } 
            {
                permission = "android.permission.RECEIVE_WAP_PUSH";
            } 
        } 
        Intent intent = new Intent(Intents.WAP_PUSH_RECEIVED_ACTION);
        intent.setType(mimeType);
        intent.putExtra("transactionId", transactionId);
        intent.putExtra("pduType", pduType);
        intent.putExtra("header", header);
        intent.putExtra("data", intentData);
        intent.putExtra("contentTypeParameters", pduDecoder.getContentParameters());
        mSmsDispatcher.dispatch(intent, permission);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345003969 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_345003969;
        
        
    }

    
    private class WapPushConnection implements ServiceConnection {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.065 -0400", hash_original_field = "CCA62189095B8E2A2A60E84892187701", hash_generated_field = "A8578F8CE8534FC6D53552C1463CAA5B")

        private IWapPushManager mWapPushMan;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.065 -0400", hash_original_field = "4AA3D5C224CE197897B9C6F17BF367CD", hash_generated_field = "21FCFBF4943D37471C748C457AFF3D5B")

        private Context mOwner;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.065 -0400", hash_original_method = "0BE0ADFB7F6B93B695220B7DE6F98A35", hash_generated_method = "6773F021BC021CF2B844CE5946D38111")
        public  WapPushConnection(Context ownerContext) {
            mOwner = ownerContext;
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.065 -0400", hash_original_method = "D2C26FA4308EBF4ECDE771359B9348B6", hash_generated_method = "0500CED13690ED913CC525185DA34B63")
        public void onServiceConnected(ComponentName name, IBinder service) {
            
            mWapPushMan = IWapPushManager.Stub.asInterface(service);
            addTaint(name.getTaint());
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.066 -0400", hash_original_method = "645B7220F43862050D99493B740CC6E9", hash_generated_method = "08D88AC5FFE531ACE9128776DECC72D1")
        public void onServiceDisconnected(ComponentName name) {
            
            mWapPushMan = null;
            rebindWapPushManager();
            addTaint(name.getTaint());
            
            
            
            
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.066 -0400", hash_original_method = "A9E3FC2EB163E786A448AD9CCAE84A6D", hash_generated_method = "57F3F05EB53CE00CFDB98C74C7253186")
        public void bindWapPushManager() {
            final ServiceConnection wapPushConnection = this;
            mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                    wapPushConnection, Context.BIND_AUTO_CREATE);
            
            
            
            
                    
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.067 -0400", hash_original_method = "701141D5EA76AC5255B679005307FF1D", hash_generated_method = "11DD3F1AE888A969E8F024F072B2CC14")
        private void rebindWapPushManager() {
            final ServiceConnection wapPushConnection = this;
            new Thread() {                
                @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.067 -0400", hash_original_method = "D137F80D797649529A6233BF034F00A3", hash_generated_method = "6F4F99E976DDC8A426C7946B8B2429BB")
                public void run() {
                    {
                        mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                                wapPushConnection, Context.BIND_AUTO_CREATE);
                        try 
                        {
                            Thread.sleep(BIND_RETRY_INTERVAL);
                        } 
                        catch (InterruptedException e)
                        { }
                    } 
                    
                    
                        
                                
                        
                            
                        
                            
                        
                    
                }
}.start();
            
            
            
            
                
                    
                        
                                
                        
                            
                        
                            
                        
                    
                
            
        }

        
        @DSModeled(DSC.SAFE)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.068 -0400", hash_original_method = "12BA8034F310D7C3159CADAC53085388", hash_generated_method = "09E37F9B5AF99076F337DB57FE0D464E")
        public IWapPushManager getWapPushManager() {
            IWapPushManager varB4EAC82CA7396A68D541C85D26508E83_1692295721 = null; 
            varB4EAC82CA7396A68D541C85D26508E83_1692295721 = mWapPushMan;
            varB4EAC82CA7396A68D541C85D26508E83_1692295721.addTaint(getTaint()); 
            return varB4EAC82CA7396A68D541C85D26508E83_1692295721;
            
            
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:25.068 -0400", hash_original_field = "F65C4BFC2898CC57B0F9A23376622D99", hash_generated_field = "D83C831CD0AB23E53B0E52B2C0EB27F8")

    private static final String LOG_TAG = "WAP PUSH";
}

