/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2008 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.provider.Telephony.Sms.Intents;
import android.util.Log;

public class WapPushOverSms {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.767 -0500", hash_original_field = "85CC68C3A5EDE562AE97B9341E829CBB", hash_generated_field = "D83C831CD0AB23E53B0E52B2C0EB27F8")

    private static final String LOG_TAG = "WAP PUSH";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.770 -0500", hash_original_field = "B997E37019471EC8FC5B98148C7A8AD7", hash_generated_field = "C458E619396054F78BC926FB81B4386D")

    private  Context mContext;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.772 -0500", hash_original_field = "1B4082614F898F1FF2AD2C831A38F19A", hash_generated_field = "FBAD2745825D1B222348829BBBC8E895")

    private WspTypeDecoder pduDecoder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.774 -0500", hash_original_field = "C8FE6578494C231B743C9C1EA246FA58", hash_generated_field = "8A503E14FA7AF8D4DA2D53FAF75ACC91")

    private SMSDispatcher mSmsDispatcher;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.776 -0500", hash_original_field = "65EAEBF48EC2BD9FC227F227DB04505F", hash_generated_field = "13F904337FC0CFFAC686B97782F492B2")

    private final int WAKE_LOCK_TIMEOUT = 5000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.779 -0500", hash_original_field = "E56C4EABE2BBC91E0B9CFA0D3B38E10B", hash_generated_field = "12DDD756FBB753EEF6004C34AE7CA6CD")

    private final int BIND_RETRY_INTERVAL = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.781 -0500", hash_original_field = "7A83276FAA2520390E1A3F73EB912AC9", hash_generated_field = "3B39AAC7E4A10A6ACE8511A3256C9AEB")

    private WapPushConnection mWapConn = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.811 -0500", hash_original_method = "7408CC3A8D1F62FE40C38A48E5413064", hash_generated_method = "C53A8DCBFDEAACEC48A627AEEF68DCF1")
    
public WapPushOverSms(Phone phone, SMSDispatcher smsDispatcher) {
        mSmsDispatcher = smsDispatcher;
        mContext = phone.getContext();
        mWapConn = new WapPushConnection(mContext);
        mWapConn.bindWapPushManager();
    }
    
    private class WapPushConnection implements ServiceConnection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.784 -0500", hash_original_field = "FF42D57D225A7A9CD1DC06929143A36F", hash_generated_field = "A8578F8CE8534FC6D53552C1463CAA5B")

        private IWapPushManager mWapPushMan;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.786 -0500", hash_original_field = "9B508B3FD5C5AA8153F426F3B8A40D4C", hash_generated_field = "21FCFBF4943D37471C748C457AFF3D5B")

        private Context mOwner;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.789 -0500", hash_original_method = "0BE0ADFB7F6B93B695220B7DE6F98A35", hash_generated_method = "9E371D0715DFE0D9B7F52215C1806AB2")
        
public WapPushConnection(Context ownerContext) {
            mOwner = ownerContext;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.792 -0500", hash_original_method = "D2C26FA4308EBF4ECDE771359B9348B6", hash_generated_method = "E135E608FA487F7F33C718CD19447E08")
        
public void onServiceConnected(ComponentName name, IBinder service) {
            mWapPushMan = IWapPushManager.Stub.asInterface(service);
            if (false) Log.v(LOG_TAG, "wappush manager connected to " +
                    mOwner.hashCode());
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.795 -0500", hash_original_method = "645B7220F43862050D99493B740CC6E9", hash_generated_method = "C66970BFB63742D267B0EEF1F3F61CFA")
        
public void onServiceDisconnected(ComponentName name) {
            mWapPushMan = null;
            if (false) Log.v(LOG_TAG, "wappush manager disconnected.");
            // WapPushManager must be always attached.
            rebindWapPushManager();
        }

        /**
         * bind WapPushManager
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.797 -0500", hash_original_method = "A9E3FC2EB163E786A448AD9CCAE84A6D", hash_generated_method = "C54848E78054E85DFE1AED8613ED028C")
        
public void bindWapPushManager() {
            if (mWapPushMan != null) return;

            final ServiceConnection wapPushConnection = this;

            mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                    wapPushConnection, Context.BIND_AUTO_CREATE);
        }

        /**
         * rebind WapPushManager
         * This method is called when WapPushManager is disconnected unexpectedly.
         */
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.803 -0500", hash_original_method = "701141D5EA76AC5255B679005307FF1D", hash_generated_method = "3573F6A47326F70B456013249D3568B2")
        
private void rebindWapPushManager() {
            if (mWapPushMan != null) return;

            final ServiceConnection wapPushConnection = this;
            new Thread() {
                @DSSafe(DSCat.SAFE_LIST)
            public void run() {
                    while (mWapPushMan == null) {
                        mOwner.bindService(new Intent(IWapPushManager.class.getName()),
                                wapPushConnection, Context.BIND_AUTO_CREATE);
                        try {
                            Thread.sleep(BIND_RETRY_INTERVAL);
                        } catch (InterruptedException e) {
                            if (false) Log.v(LOG_TAG, "sleep interrupted.");
                        }
                    }
                }
            }.start();
        }

        /**
         * Returns interface to WapPushManager
         */
        @DSSource({DSSourceKind.NETWORK})
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.806 -0500", hash_original_method = "12BA8034F310D7C3159CADAC53085388", hash_generated_method = "0978255B4A9C6F66D3DBBD2273DF1954")
        
public IWapPushManager getWapPushManager() {
            return mWapPushMan;
        }
        
    }

    /**
     * Dispatches inbound messages that are in the WAP PDU format. See
     * wap-230-wsp-20010705-a section 8 for details on the WAP PDU format.
     *
     * @param pdu The WAP PDU, made up of one or more SMS PDUs
     * @return a result code from {@link Telephony.Sms.Intents}, or
     *         {@link Activity#RESULT_OK} if the message has been broadcast
     *         to applications
     */
    @DSSink({DSSinkKind.SMS_MMS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:34.815 -0500", hash_original_method = "B943BA9A516C7D27398DA677689F619E", hash_generated_method = "AF61DDA6338265B622ECA4BC7473512D")
    
public int dispatchWapPdu(byte[] pdu) {

        if (false) Log.d(LOG_TAG, "Rx: " + IccUtils.bytesToHexString(pdu));

        int index = 0;
        int transactionId = pdu[index++] & 0xFF;
        int pduType = pdu[index++] & 0xFF;
        int headerLength = 0;

        if ((pduType != WspTypeDecoder.PDU_TYPE_PUSH) &&
                (pduType != WspTypeDecoder.PDU_TYPE_CONFIRMED_PUSH)) {
            if (false) Log.w(LOG_TAG, "Received non-PUSH WAP PDU. Type = " + pduType);
            return Intents.RESULT_SMS_HANDLED;
        }

        pduDecoder = new WspTypeDecoder(pdu);

        /**
         * Parse HeaderLen(unsigned integer).
         * From wap-230-wsp-20010705-a section 8.1.2
         * The maximum size of a uintvar is 32 bits.
         * So it will be encoded in no more than 5 octets.
         */
        if (pduDecoder.decodeUintvarInteger(index) == false) {
            if (false) Log.w(LOG_TAG, "Received PDU. Header Length error.");
            return Intents.RESULT_SMS_GENERIC_ERROR;
        }
        headerLength = (int)pduDecoder.getValue32();
        index += pduDecoder.getDecodedDataLength();

        int headerStartIndex = index;

        /**
         * Parse Content-Type.
         * From wap-230-wsp-20010705-a section 8.4.2.24
         *
         * Content-type-value = Constrained-media | Content-general-form
         * Content-general-form = Value-length Media-type
         * Media-type = (Well-known-media | Extension-Media) *(Parameter)
         * Value-length = Short-length | (Length-quote Length)
         * Short-length = <Any octet 0-30>   (octet <= WAP_PDU_SHORT_LENGTH_MAX)
         * Length-quote = <Octet 31>         (WAP_PDU_LENGTH_QUOTE)
         * Length = Uintvar-integer
         */
        if (pduDecoder.decodeContentType(index) == false) {
            if (false) Log.w(LOG_TAG, "Received PDU. Header Content-Type error.");
            return Intents.RESULT_SMS_GENERIC_ERROR;
        }

        String mimeType = pduDecoder.getValueString();
        long binaryContentType = pduDecoder.getValue32();
        index += pduDecoder.getDecodedDataLength();

        byte[] header = new byte[headerLength];
        System.arraycopy(pdu, headerStartIndex, header, 0, header.length);

        byte[] intentData;

        if (mimeType != null && mimeType.equals(WspTypeDecoder.CONTENT_TYPE_B_PUSH_CO)) {
            intentData = pdu;
        } else {
            int dataIndex = headerStartIndex + headerLength;
            intentData = new byte[pdu.length - dataIndex];
            System.arraycopy(pdu, dataIndex, intentData, 0, intentData.length);
        }

        /**
         * Seek for application ID field in WSP header.
         * If application ID is found, WapPushManager substitute the message
         * processing. Since WapPushManager is optional module, if WapPushManager
         * is not found, legacy message processing will be continued.
         */
        if (pduDecoder.seekXWapApplicationId(index, index + headerLength - 1)) {
            index = (int) pduDecoder.getValue32();
            pduDecoder.decodeXWapApplicationId(index);
            String wapAppId = pduDecoder.getValueString();
            if (wapAppId == null) {
                wapAppId = Integer.toString((int) pduDecoder.getValue32());
            }

            String contentType = ((mimeType == null) ?
                                  Long.toString(binaryContentType) : mimeType);
            if (false) Log.v(LOG_TAG, "appid found: " + wapAppId + ":" + contentType);

            try {
                boolean processFurther = true;
                IWapPushManager wapPushMan = mWapConn.getWapPushManager();

                if (wapPushMan == null) {
                    if (false) Log.w(LOG_TAG, "wap push manager not found!");
                } else {
                    Intent intent = new Intent();
                    intent.putExtra("transactionId", transactionId);
                    intent.putExtra("pduType", pduType);
                    intent.putExtra("header", header);
                    intent.putExtra("data", intentData);
                    intent.putExtra("contentTypeParameters",
                            pduDecoder.getContentParameters());

                    int procRet = wapPushMan.processMessage(wapAppId, contentType, intent);
                    if (false) Log.v(LOG_TAG, "procRet:" + procRet);
                    if ((procRet & WapPushManagerParams.MESSAGE_HANDLED) > 0
                        && (procRet & WapPushManagerParams.FURTHER_PROCESSING) == 0) {
                        processFurther = false;
                    }
                }
                if (!processFurther) {
                    return Intents.RESULT_SMS_HANDLED;
                }
            } catch (RemoteException e) {
                if (false) Log.w(LOG_TAG, "remote func failed...");
            }
        }
        if (false) Log.v(LOG_TAG, "fall back to existing handler");

        if (mimeType == null) {
            if (false) Log.w(LOG_TAG, "Header Content-Type error.");
            return Intents.RESULT_SMS_GENERIC_ERROR;
        }

        String permission;

        if (mimeType.equals(WspTypeDecoder.CONTENT_TYPE_B_MMS)) {
            permission = "android.permission.RECEIVE_MMS";
        } else {
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

        return Activity.RESULT_OK;
    }
}

