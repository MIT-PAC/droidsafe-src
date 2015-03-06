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
 * Copyright (C) 2010 The Android Open Source Project
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


package com.android.internal.telephony.sip;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.net.sip.SipAudioCall;
import android.os.SystemClock;
import android.telephony.PhoneNumberUtils;
import android.util.Log;

import com.android.internal.telephony.Call;
import com.android.internal.telephony.Connection;
import com.android.internal.telephony.Phone;
import com.android.internal.telephony.UUSInfo;

abstract class SipConnectionBase extends Connection {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.220 -0500", hash_original_field = "FF283BE8EF85D40349EF8EE4F589EF18", hash_generated_field = "A3F8AA293EF1D8E9E944DD7FF4AA0255")

    private static final String LOG_TAG = "SIP_CONN";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.222 -0500", hash_original_field = "2344A847B81308841F673AA2C93047DC", hash_generated_field = "D1359B5A0587476130FC171DA764AC68")

    private SipAudioCall mSipAudioCall;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.224 -0500", hash_original_field = "F515901190E6B9979D62CEFE77655CD0", hash_generated_field = "E672830D2E0B106901DACBA6E0B923A6")

    private String dialString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.227 -0500", hash_original_field = "8276078622B570793705E396A0D7F62F", hash_generated_field = "6F94828D80A08223A3D2C4840C810E5C")

    private String postDialString;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.229 -0500", hash_original_field = "6EBA36FD71F695F0A7004724AFD9D8F8", hash_generated_field = "A0D8F46E603AB3E7C2624AFEC4BCC56F")

    private int nextPostDialChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.232 -0500", hash_original_field = "4C77869A4C7C09DEF349ED266B2A3A42", hash_generated_field = "899B35935BADAD00E40EEE48034FA777")

    private boolean isIncoming;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.234 -0500", hash_original_field = "88A71A811D0CFD868BD514D9A7A9DADE", hash_generated_field = "2B7C094BB4119A5846E4078843652104")

    private long createTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.236 -0500", hash_original_field = "4688FD5CCB150978DDBAC76460D6A697", hash_generated_field = "3A10CD6DE0D1F8841131E8E3B55CDF17")

    private long connectTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.238 -0500", hash_original_field = "6F4281795E649655EEAED8CC4AFFA7C4", hash_generated_field = "4A468F625B3893CC4E044A175513CACE")

    private long disconnectTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.241 -0500", hash_original_field = "FB007E1B198D105ABB5DFCFDF540B71E", hash_generated_field = "BD81C614EFF599A99945A7CA6F0301ED")

    private long connectTimeReal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.243 -0500", hash_original_field = "A7ED9F02A166F79FDA7CB05217E7FC57", hash_generated_field = "B71E8F5397B52F575D65D0F3A413011B")

    private long duration = -1L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.245 -0500", hash_original_field = "39B3C41F5817B2E3B391281A0E9E890F", hash_generated_field = "0C720B6C915AEB7736CF4596137134F0")

    private long holdingStartTime;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.248 -0500", hash_original_field = "69815C132432FCFC615231F985F7CB21", hash_generated_field = "68B5F3FEFFA2BBDBE0BAAC63B722BFE0")

                            // into HOLDING

    private DisconnectCause mCause = DisconnectCause.NOT_DISCONNECTED;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.250 -0500", hash_original_field = "12225F767E33A7C05BECAD37785471A6", hash_generated_field = "D20AEA8FE258625EB4F340AF843F84F8")

    private PostDialState postDialState = PostDialState.NOT_STARTED;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.252 -0500", hash_original_method = "D12ADA666E21FFAC81BC845F1B1B388F", hash_generated_method = "D12ADA666E21FFAC81BC845F1B1B388F")
    
SipConnectionBase(String dialString) {
        this.dialString = dialString;

        postDialString = PhoneNumberUtils.extractPostDialPortion(dialString);

        isIncoming = false;
        createTime = System.currentTimeMillis();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.255 -0500", hash_original_method = "9D87CB1ACC156683FA215308BE25D1D9", hash_generated_method = "3DDC9B648402323EA47AE9D4B18C9E3E")
    
protected void setState(Call.State state) {
        switch (state) {
            case ACTIVE:
                if (connectTime == 0) {
                    connectTimeReal = SystemClock.elapsedRealtime();
                    connectTime = System.currentTimeMillis();
                }
                break;
            case DISCONNECTED:
                duration = getDurationMillis();
                disconnectTime = System.currentTimeMillis();
                break;
            case HOLDING:
                holdingStartTime = SystemClock.elapsedRealtime();
                break;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.258 -0500", hash_original_method = "A8956DD6ACAC2731E62816490C646631", hash_generated_method = "B1A1FA6B39A06DC717D428ED095C0FFF")
    
@Override
    public long getCreateTime() {
        return createTime;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.261 -0500", hash_original_method = "540CF01EF64CF5C6BAC1246743ECA8F1", hash_generated_method = "9FDC297BE29AC7A51F39BB908DDC6457")
    
@Override
    public long getConnectTime() {
        return connectTime;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.264 -0500", hash_original_method = "D17BC9E58BABC2D5CE1B7492B59E2165", hash_generated_method = "28814308B62ED222C43D328969EB2BFC")
    
@Override
    public long getDisconnectTime() {
        return disconnectTime;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.266 -0500", hash_original_method = "8E0034C90F1E75659D16C0CDCE6F5793", hash_generated_method = "14D360010D46309FCCF2DEC011B6578D")
    
@Override
    public long getDurationMillis() {
        if (connectTimeReal == 0) {
            return 0;
        } else if (duration < 0) {
            return SystemClock.elapsedRealtime() - connectTimeReal;
        } else {
            return duration;
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.269 -0500", hash_original_method = "2CFF5FB4AC83B238AC9B892D795EB1DE", hash_generated_method = "C27E3D8B3D0F244CDF6E0242B67E0CF1")
    
@Override
    public long getHoldDurationMillis() {
        if (getState() != Call.State.HOLDING) {
            // If not holding, return 0
            return 0;
        } else {
            return SystemClock.elapsedRealtime() - holdingStartTime;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.271 -0500", hash_original_method = "28455B27DA94996FB17C07BF72898FB4", hash_generated_method = "9CD48A8F7EA6FABBF3A27C3EF14D1EAB")
    
@Override
    public DisconnectCause getDisconnectCause() {
        return mCause;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.273 -0500", hash_original_method = "04AFA3AB4AAFB99A0A1522AC045EFCCB", hash_generated_method = "04AFA3AB4AAFB99A0A1522AC045EFCCB")
    
void setDisconnectCause(DisconnectCause cause) {
        mCause = cause;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.276 -0500", hash_original_method = "4EE87D2E41D94C18F614BA2D1494AD36", hash_generated_method = "49495F02A8FC5A98AD774A1F18F38B7F")
    
@Override
    public PostDialState getPostDialState() {
        return postDialState;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.278 -0500", hash_original_method = "0751315CA6FC4E16145F947C7FEC6A28", hash_generated_method = "FD31D08AE60E9DEABC18125E6F2F9C51")
    
@Override
    public void proceedAfterWaitChar() {
        // TODO
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.281 -0500", hash_original_method = "1CC81519C3754B491F6AACE2E776B1AA", hash_generated_method = "A1DB04F30AFDD8958E7D1155F88DB1DB")
    
@Override
    public void proceedAfterWildChar(String str) {
        // TODO
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.283 -0500", hash_original_method = "A990DB72552DFD3D94264491EEB59CEC", hash_generated_method = "3020D3225283B4938464E09A1BB85324")
    
@Override
    public void cancelPostDial() {
        // TODO
    }

    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.286 -0500", hash_original_method = "2934325051523620DCD2F62BF84383AD", hash_generated_method = "E0532074FC3B4F0149E2689F81019F86")
    
protected abstract Phone getPhone();

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.288 -0500", hash_original_method = "0D579DEEA4ADF8476D536663A83CC650", hash_generated_method = "6B6193B09C1F95FF7144F4A8F0D20ACE")
    
@Override
    public String getRemainingPostDialString() {
        if (postDialState == PostDialState.CANCELLED
            || postDialState == PostDialState.COMPLETE
            || postDialString == null
            || postDialString.length() <= nextPostDialChar) {
            return "";
        }

        return postDialString.substring(nextPostDialChar);
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.290 -0500", hash_original_method = "780D5AE6347C99C37A99BA1F1D4E1D8E", hash_generated_method = "5B243B4AC5A2917C420361F3F8717D57")
    
private void log(String msg) {
        Log.d(LOG_TAG, "[SipConn] " + msg);
    }

    @DSSource({DSSourceKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.293 -0500", hash_original_method = "6B6F8D6F29C0FEAF9C52CC30010D6FE2", hash_generated_method = "187AEC75467D1195067FE1DFF850EC0D")
    
@Override
    public int getNumberPresentation() {
        // TODO: add PRESENTATION_URL
        return Connection.PRESENTATION_ALLOWED;
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.295 -0500", hash_original_method = "8B171385F62C7AA97B0882209EC3A206", hash_generated_method = "A7CDB321431F80E4F7558E868C9870D5")
    
@Override
    public UUSInfo getUUSInfo() {
        // FIXME: what's this for SIP?
        return null;
    }
}

