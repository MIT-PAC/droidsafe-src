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
 * Copyright (C) 2011 The Android Open Source Project
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
import android.util.Log;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Collection;

import android.app.PendingIntent;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.ProxyProperties;
import android.os.Message;

import com.android.internal.telephony.DataConnection.UpdateLinkPropertyResult;
import com.android.internal.util.AsyncChannel;
import com.android.internal.util.Protocol;

public class DataConnectionAc extends AsyncChannel {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.576 -0500", hash_original_field = "B2601CA7445F6BA19FA7884763D82281", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.583 -0500", hash_original_field = "D31676FE673D1865F5666E81617F1FF5", hash_generated_field = "6BCB0AA355104F156D0A2B3A91BB070E")

    public static final int BASE = Protocol.BASE_DATA_CONNECTION_AC;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.586 -0500", hash_original_field = "1700B4348A7ED5B60D6517535BE794D2", hash_generated_field = "1475D2F355264F68EEAD5DE0DC64E4C1")

    public static final int REQ_IS_INACTIVE = BASE + 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.589 -0500", hash_original_field = "26AAA288AF99CD263D38F405C783E26C", hash_generated_field = "4EF0EE195500EDBC396F404FB857CFCE")

    public static final int RSP_IS_INACTIVE = BASE + 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.591 -0500", hash_original_field = "1383E5283886D0BC9DE3CD544957A335", hash_generated_field = "100ADE81533B5A145526EE17F8BCF7F6")

    public static final int REQ_GET_CID = BASE + 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.594 -0500", hash_original_field = "E05F7B841877276FA2EDD6C7301D7B89", hash_generated_field = "4AADBE311B5CBD53B22C258FD0BC5894")

    public static final int RSP_GET_CID = BASE + 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.597 -0500", hash_original_field = "7F3BEECA97CAEE5D62F2FD2124DEAAC9", hash_generated_field = "4556E2B1BBE8565148BB1897F4F1FFF2")

    public static final int REQ_GET_APNSETTING = BASE + 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.600 -0500", hash_original_field = "4931E5115CCBF0DD6FB4074AAD2A8E1E", hash_generated_field = "075D97CF7AE01BA14B82937FAB85E17C")

    public static final int RSP_GET_APNSETTING = BASE + 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.603 -0500", hash_original_field = "63321D058EBFEC84A0CA8AEE55AEA493", hash_generated_field = "6B2177B63C14A3D8C4A0465DF7EDA57B")

    public static final int REQ_GET_LINK_PROPERTIES = BASE + 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.606 -0500", hash_original_field = "5462F0C5952138C701356C42D1A993D9", hash_generated_field = "B073222C67C8387DA84D52E09C649C5B")

    public static final int RSP_GET_LINK_PROPERTIES = BASE + 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.609 -0500", hash_original_field = "06A43CF922D828804D9B33274427735A", hash_generated_field = "AA7EDD6DEA7FBE6E6DEDC341AE2566AA")

    public static final int REQ_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.612 -0500", hash_original_field = "5FE5402C1087F7C581B0E62C08F1B5A7", hash_generated_field = "2BD71056213661FD69459E151EB320F2")

    public static final int RSP_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.615 -0500", hash_original_field = "AEABFAFB2C90D2D9286557D2457F5850", hash_generated_field = "42BC94DC23936D5550B2F12E94B801F3")

    public static final int REQ_GET_LINK_CAPABILITIES = BASE + 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.617 -0500", hash_original_field = "5B6E86890023216E8DD573CA0C0C3E87", hash_generated_field = "7C871C282AED07B5AFD51BB60DC58B87")

    public static final int RSP_GET_LINK_CAPABILITIES = BASE + 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.620 -0500", hash_original_field = "82B8D198F883A0F4AD6604E501823CCC", hash_generated_field = "410DC65F191E667E05E1C26996344ED6")

    public static final int REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.623 -0500", hash_original_field = "3F3690029483CC32E7B4E0090D52A2A4", hash_generated_field = "EABD1A19ECDA7C315E74E3BB10C8AA34")

    public static final int RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.625 -0500", hash_original_field = "4B0ABB76CDCC45AFD2ED74F48231D4F1", hash_generated_field = "FA6D9E30AD45F04695E898045922860A")

    public static final int REQ_RESET = BASE + 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.629 -0500", hash_original_field = "F81F8CB703087E008BC355FA53614617", hash_generated_field = "669F769EC139E98CB3AFB220D6A1C9FE")

    public static final int RSP_RESET = BASE + 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.632 -0500", hash_original_field = "34A19474B7CB3D1DC82A4D73A31ADFD5", hash_generated_field = "76D19A23EEE2DE297833D58F70073A84")

    public static final int REQ_GET_REFCOUNT = BASE + 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.635 -0500", hash_original_field = "0F28FF5E756876BBBB5A77EF5408C996", hash_generated_field = "BD8C38909076EDBB350F0534D3158B5A")

    public static final int RSP_GET_REFCOUNT = BASE + 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.638 -0500", hash_original_field = "DCBBD47A8604015D0BE0A4B4F4D7842C", hash_generated_field = "8F3EC990CEC19BF924C0C83E473DF703")

    public static final int REQ_ADD_APNCONTEXT = BASE + 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.640 -0500", hash_original_field = "6078F599BF45E794D68B34E1FCC8C2CC", hash_generated_field = "D05330977465F7AF4E384E150213096A")

    public static final int RSP_ADD_APNCONTEXT = BASE + 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.643 -0500", hash_original_field = "6AC512B87ABE61987F54F2AAB70D3619", hash_generated_field = "FC2140507E1C1E4A862E984C6536D33F")

    public static final int REQ_REMOVE_APNCONTEXT = BASE + 20;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.646 -0500", hash_original_field = "0D26313506058C52001F8E3DC26A4D5B", hash_generated_field = "F6C5D6966EFACD969BB347661AD8098A")

    public static final int RSP_REMOVE_APNCONTEXT = BASE + 21;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.649 -0500", hash_original_field = "FEBFD1CAE3F0913E35DCB066204AA33B", hash_generated_field = "7CADBAFCB6C4D553E00439A92A77399A")

    public static final int REQ_GET_APNCONTEXT_LIST = BASE + 22;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.652 -0500", hash_original_field = "3BF712C1870C6CB1C802B1350AA6F31F", hash_generated_field = "08CEE76E523CBFA9615E63AE42E97282")

    public static final int RSP_GET_APNCONTEXT_LIST = BASE + 23;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.654 -0500", hash_original_field = "9F6A93F261CB5989F2E28F2D395D4C92", hash_generated_field = "AEDC94BDC63CFCBD1EE247E113E0B2BD")

    public static final int REQ_SET_RECONNECT_INTENT = BASE + 24;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.657 -0500", hash_original_field = "0210A72B483C5D5172C09EA9B02CB0CD", hash_generated_field = "50977DA17634FA6287626111506AF1F5")

    public static final int RSP_SET_RECONNECT_INTENT = BASE + 25;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.659 -0500", hash_original_field = "7FC85EF22C48D4FFF5FBC50B081F79CD", hash_generated_field = "E050F9150348EB87E92AA17BEF7AA6F1")

    public static final int REQ_GET_RECONNECT_INTENT = BASE + 26;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.662 -0500", hash_original_field = "3C1FE5EAB0B817661803531EC738C5A6", hash_generated_field = "B47C4AB7C8CEFA3E66A64CE4AF15F148")

    public static final int RSP_GET_RECONNECT_INTENT = BASE + 27;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.578 -0500", hash_original_field = "18BDC329C18DD371A79CC5D2B91C72D1", hash_generated_field = "59F9615F1046A159253328ABFF9EBAC4")

    private String mLogTag;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.580 -0500", hash_original_field = "2BA7EB3E16C6C8284C07A8382AC85F57", hash_generated_field = "4C14AF3C02F6F482DB5C38C18F17056F")

    public DataConnection dataConnection;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.670 -0500", hash_original_method = "F4260E5BFAF2E10088BF39CBA8BFFFD2", hash_generated_method = "56BB3F3D1263742125AFBDB1059AFA1F")
    
public DataConnectionAc(DataConnection dc, String logTag) {
        dataConnection = dc;
        mLogTag = logTag;
    }

    /**
     * Request if the state machine is in the inactive state.
     * Response {@link #rspIsInactive}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.672 -0500", hash_original_method = "7AA2FA115BEA9C5CC0101E6522D85688", hash_generated_method = "38DB8D35EF0923B57A265C6B655A9A31")
    
public void reqIsInactive() {
        sendMessage(REQ_IS_INACTIVE);
        if (DBG) log("reqIsInactive");
    }

    /**
     * Evaluate RSP_IS_INACTIVE.
     *
     * @return true if the state machine is in the inactive state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.675 -0500", hash_original_method = "D508FA29014931CB6CD29F8DFC756262", hash_generated_method = "82DEBC56EC102C62B4D2895CE19E9638")
    
public boolean rspIsInactive(Message response) {
        boolean retVal = response.arg1 == 1;
        if (DBG) log("rspIsInactive=" + retVal);
        return retVal;
    }

    /**
     * @return true if the state machine is in the inactive state.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.678 -0500", hash_original_method = "5AFFFE1437681DAB31C247AD1B67F124", hash_generated_method = "D76830E99B405D23AE139B272238C1CF")
    
public boolean isInactiveSync() {
        Message response = sendMessageSynchronously(REQ_IS_INACTIVE);
        if ((response != null) && (response.what == RSP_IS_INACTIVE)) {
            return rspIsInactive(response);
        } else {
            log("rspIsInactive error response=" + response);
            return false;
        }
    }

    /**
     * Request the Connection ID.
     * Response {@link #rspCid}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.680 -0500", hash_original_method = "E08DB9A60755AA94EB60896D4764AF5C", hash_generated_method = "02E4743960A4F4FD909E92AB66F9402C")
    
public void reqCid() {
        sendMessage(REQ_GET_CID);
        if (DBG) log("reqCid");
    }

    /**
     * Evaluate a RSP_GET_CID message and return the cid.
     *
     * @param response Message
     * @return connection id or -1 if an error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.682 -0500", hash_original_method = "FF57B3B0C583923138679674F4E2FE25", hash_generated_method = "4D7D32FD10AEDBFD723DC815365E48EE")
    
public int rspCid(Message response) {
        int retVal = response.arg1;
        if (DBG) log("rspCid=" + retVal);
        return retVal;
    }

    /**
     * @return connection id or -1 if an error
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.685 -0500", hash_original_method = "88FA920EA2D54F9DC82F8A70E10A6416", hash_generated_method = "B672B987749AA82984557368333C8C0A")
    
public int getCidSync() {
        Message response = sendMessageSynchronously(REQ_GET_CID);
        if ((response != null) && (response.what == RSP_GET_CID)) {
            return rspCid(response);
        } else {
            log("rspCid error response=" + response);
            return -1;
        }
    }

    /**
     * Request the Reference Count.
     * Response {@link #rspRefCount}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.687 -0500", hash_original_method = "5DBEE0C11260D4E2748BF847AE297C4B", hash_generated_method = "D2715532CE659B26F87B12259BDAE9D5")
    
public void reqRefCount() {
        sendMessage(REQ_GET_REFCOUNT);
        if (DBG) log("reqRefCount");
    }

    /**
     * Evaluate a RSP_GET_REFCOUNT message and return the refCount.
     *
     * @param response Message
     * @return ref count or -1 if an error
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.689 -0500", hash_original_method = "AFE421B2404E9D3449EC1EC9B786EEAC", hash_generated_method = "651144D5A2067F7374D2A7B2A2228594")
    
public int rspRefCount(Message response) {
        int retVal = response.arg1;
        if (DBG) log("rspRefCount=" + retVal);
        return retVal;
    }
    
    public enum LinkPropertyChangeAction {
        NONE, CHANGED, RESET;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.665 -0500", hash_original_method = "ECD4DBE81D7EB8EBF15AF2859E88776B", hash_generated_method = "3D464F1EB79AACBC49FC878B1763A942")
            
public static LinkPropertyChangeAction fromInt(int value) {
            if (value == NONE.ordinal()) {
                return NONE;
            } else if (value == CHANGED.ordinal()) {
                return CHANGED;
            } else if (value == RESET.ordinal()) {
                return RESET;
            } else {
                throw new RuntimeException("LinkPropertyChangeAction.fromInt: bad value=" + value);
            }
        }
    }

    /**
     * @return connection id or -1 if an error
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.692 -0500", hash_original_method = "82303217C6F0F47E549DB7B210318471", hash_generated_method = "6355F190B7933E0AAAE4C30E4F407F7B")
    
public int getRefCountSync() {
        Message response = sendMessageSynchronously(REQ_GET_REFCOUNT);
        if ((response != null) && (response.what == RSP_GET_REFCOUNT)) {
            return rspRefCount(response);
        } else {
            log("rspRefCount error response=" + response);
            return -1;
        }
    }

    /**
     * Request the connections ApnSetting.
     * Response {@link #rspApnSetting}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.694 -0500", hash_original_method = "C0AE060C8D213182996CE9AFC0358CCA", hash_generated_method = "5FA52A6E5C768380AF521C134C6FB1A2")
    
public void reqApnSetting() {
        sendMessage(REQ_GET_APNSETTING);
        if (DBG) log("reqApnSetting");
    }

    /**
     * Evaluate a RSP_APN_SETTING message and return the ApnSetting.
     *
     * @param response Message
     * @return ApnSetting, maybe null
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.696 -0500", hash_original_method = "95D7FBD84C6C38BA2D84311C3C9BEF51", hash_generated_method = "B8E9354FF2CC6187E51B7768F0C1932A")
    
public ApnSetting rspApnSetting(Message response) {
        ApnSetting retVal = (ApnSetting) response.obj;
        if (DBG) log("rspApnSetting=" + retVal);
        return retVal;
    }

    /**
     * Get the connections ApnSetting.
     *
     * @return ApnSetting or null if an error
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.700 -0500", hash_original_method = "DD32FEB19DC77901F346EA49C4C70BF1", hash_generated_method = "26FCD65C22B3708A586C438DCE030E63")
    
public ApnSetting getApnSettingSync() {
        Message response = sendMessageSynchronously(REQ_GET_APNSETTING);
        if ((response != null) && (response.what == RSP_GET_APNSETTING)) {
            return rspApnSetting(response);
        } else {
            log("getApnSetting error response=" + response);
            return null;
        }
    }

    /**
     * Request the connections LinkProperties.
     * Response {@link #rspLinkProperties}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.702 -0500", hash_original_method = "5D3EF8F8C1412EBC1BE098FA3C540E84", hash_generated_method = "4686AD3871B3FBDFBB22E37A2AF61F31")
    
public void reqLinkProperties() {
        sendMessage(REQ_GET_LINK_PROPERTIES);
        if (DBG) log("reqLinkProperties");
    }

    /**
     * Evaluate RSP_GET_LINK_PROPERTIES
     *
     * @param response
     * @return LinkProperties, maybe null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.704 -0500", hash_original_method = "61AC833B412EB853D23C85E2B80FFC12", hash_generated_method = "D48D459DC0052CF8C262EB9FE6AB3011")
    
public LinkProperties rspLinkProperties(Message response) {
        LinkProperties retVal = (LinkProperties) response.obj;
        if (DBG) log("rspLinkProperties=" + retVal);
        return retVal;
    }

    /**
     * Get the connections LinkProperties.
     *
     * @return LinkProperties or null if an error
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.707 -0500", hash_original_method = "3F7712F482B5EE0C4EC3A4DBA0BA8D32", hash_generated_method = "FF79B0AD65617CB5A1186B97CD35A7DF")
    
public LinkProperties getLinkPropertiesSync() {
        Message response = sendMessageSynchronously(REQ_GET_LINK_PROPERTIES);
        if ((response != null) && (response.what == RSP_GET_LINK_PROPERTIES)) {
            return rspLinkProperties(response);
        } else {
            log("getLinkProperties error response=" + response);
            return null;
        }
    }

    /**
     * Request setting the connections LinkProperties.HttpProxy.
     * Response RSP_SET_LINK_PROPERTIES when complete.
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.709 -0500", hash_original_method = "52664ABA5522CB5FFA9E0304A7C81F50", hash_generated_method = "220CCCBBDAD09D90895077D5898F7F38")
    
public void reqSetLinkPropertiesHttpProxy(ProxyProperties proxy) {
        sendMessage(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        if (DBG) log("reqSetLinkPropertiesHttpProxy proxy=" + proxy);
    }

    /**
     * Set the connections LinkProperties.HttpProxy
     */
    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.712 -0500", hash_original_method = "71F35538546E3DD45C021DEA145F6AFD", hash_generated_method = "048577F0A15DAE88F58A3B40BBA571E1")
    
public void setLinkPropertiesHttpProxySync(ProxyProperties proxy) {
        Message response =
            sendMessageSynchronously(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        if ((response != null) && (response.what == RSP_SET_LINK_PROPERTIES_HTTP_PROXY)) {
            if (DBG) log("setLinkPropertiesHttpPoxy ok");
        } else {
            log("setLinkPropertiesHttpPoxy error response=" + response);
        }
    }

    /**
     * Request update LinkProperties from DataCallState
     * Response {@link #rspUpdateLinkPropertiesDataCallState}
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.714 -0500", hash_original_method = "1137FFCD79265DC595F1B5AA40674EF5", hash_generated_method = "1BA3EAC15E6072C7645043939C73FD4C")
    
public void reqUpdateLinkPropertiesDataCallState(DataCallState newState) {
        sendMessage(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        if (DBG) log("reqUpdateLinkPropertiesDataCallState");
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.716 -0500", hash_original_method = "FF09E9AE970C8576F47A284FF7FFCA6D", hash_generated_method = "615EB136521D13B130890EFEB29D16AD")
    
public UpdateLinkPropertyResult rspUpdateLinkPropertiesDataCallState(Message response) {
        UpdateLinkPropertyResult retVal = (UpdateLinkPropertyResult)response.obj;
        if (DBG) log("rspUpdateLinkPropertiesState: retVal=" + retVal);
        return retVal;
    }

    /**
     * Update link properties in the data connection
     *
     * @return the removed and added addresses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.719 -0500", hash_original_method = "98F59EFFB83342DD2236B59D91A5E4B5", hash_generated_method = "BC0D2AE19D2DC7555F63320B9322EFB5")
    
public UpdateLinkPropertyResult updateLinkPropertiesDataCallStateSync(DataCallState newState) {
        Message response =
            sendMessageSynchronously(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        if ((response != null) &&
            (response.what == RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE)) {
            return rspUpdateLinkPropertiesDataCallState(response);
        } else {
            log("getLinkProperties error response=" + response);
            return new UpdateLinkPropertyResult(new LinkProperties());
        }
    }

    /**
     * Request the connections LinkCapabilities.
     * Response {@link #rspLinkCapabilities}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.722 -0500", hash_original_method = "30D60C86BD34D11FA73E7C7E67CFC7AA", hash_generated_method = "7CE67C75D4ED29C9B107DF79347452DE")
    
public void reqLinkCapabilities() {
        sendMessage(REQ_GET_LINK_CAPABILITIES);
        if (DBG) log("reqLinkCapabilities");
    }

    /**
     * Evaluate RSP_GET_LINK_CAPABILITIES
     *
     * @param response
     * @return LinkCapabilites, maybe null.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.724 -0500", hash_original_method = "F187911F3801DAE69287AC09EDB743FA", hash_generated_method = "C99150D9B74C6E2E6A13C966A9BD4ACD")
    
public LinkCapabilities rspLinkCapabilities(Message response) {
        LinkCapabilities retVal = (LinkCapabilities) response.obj;
        if (DBG) log("rspLinkCapabilities=" + retVal);
        return retVal;
    }

    /**
     * Get the connections LinkCapabilities.
     *
     * @return LinkCapabilities or null if an error
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.726 -0500", hash_original_method = "C1F7B964512DA39EF105AA8C4B5198E6", hash_generated_method = "1F458C9E78F24005EDFA86A34F295F62")
    
public LinkCapabilities getLinkCapabilitiesSync() {
        Message response = sendMessageSynchronously(REQ_GET_LINK_CAPABILITIES);
        if ((response != null) && (response.what == RSP_GET_LINK_CAPABILITIES)) {
            return rspLinkCapabilities(response);
        } else {
            log("getLinkCapabilities error response=" + response);
            return null;
        }
    }

    /**
     * Request the connections LinkCapabilities.
     * Response RSP_RESET when complete
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.728 -0500", hash_original_method = "9EFFE3DDD73E4A7AC997D7CA04936F41", hash_generated_method = "4468C8BD7B27D8F1A187A01662EC1BFC")
    
public void reqReset() {
        sendMessage(REQ_RESET);
        if (DBG) log("reqReset");
    }

    /**
     * Reset the connection and wait for it to complete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.731 -0500", hash_original_method = "C179D3525D5003A50B8C9C0361938568", hash_generated_method = "E0441F7BCCFA454A6F9B18F539E83028")
    
public void resetSync() {
        Message response = sendMessageSynchronously(REQ_RESET);
        if ((response != null) && (response.what == RSP_RESET)) {
            if (DBG) log("restSync ok");
        } else {
            log("restSync error response=" + response);
        }
    }

    /**
     * Request to add ApnContext association.
     * Response RSP_ADD_APNCONTEXT when complete.
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.733 -0500", hash_original_method = "F3233E69134CF9902E31FB14516EC03E", hash_generated_method = "3BDA4F3791893CE28474E7EF4881A9B8")
    
public void reqAddApnContext(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        if (DBG) log("reqAddApnContext");
    }

    /**
     * Add ApnContext association synchronoulsy.
     *
     * @param ApnContext to associate
     */
    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.736 -0500", hash_original_method = "29B8FEA7830E2BBE9C7BBFD69E48646E", hash_generated_method = "34B3C845585366C8DB83B5DC6D722767")
    
public void addApnContextSync(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        if ((response != null) && (response.what == RSP_ADD_APNCONTEXT)) {
            if (DBG) log("addApnContext ok");
        } else {
            log("addApnContext error response=" + response);
        }
    }

    /**
     * Request to remove ApnContext association.
     * Response RSP_REMOVE_APNCONTEXT when complete.
     */
    @DSSink({DSSinkKind.SYSTEM_SETTINGS})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.738 -0500", hash_original_method = "51B2CCF2735E77C63E82DEC17109A5B1", hash_generated_method = "00D5E1A38930FCC8E9B47A738DBEB5B5")
    
public void reqRemomveApnContext(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        if (DBG) log("reqRemomveApnContext");
    }

    /**
     * Remove ApnContext associateion.
     *
     * @param ApnContext to dissociate
     */
    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.741 -0500", hash_original_method = "62E31991C2E3FEB9590AC2302F444FDA", hash_generated_method = "06B122E6D993D7E683ED8C9B5FC895A8")
    
public void removeApnContextSync(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        if ((response != null) && (response.what == RSP_REMOVE_APNCONTEXT)) {
            if (DBG) log("removeApnContext ok");
        } else {
            log("removeApnContext error response=" + response);
        }
    }

    /**
     * Request to retrive ApnContext List associated with DC.
     * Response RSP_GET_APNCONTEXT_LIST when complete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.744 -0500", hash_original_method = "AAD200E4835E6912540E5A2C7F9552F9", hash_generated_method = "9901A624D879B442C50B5CD979A1224F")
    
public void reqGetApnList(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        if (DBG) log("reqGetApnList");
    }

    /**
     * Retrieve Collection of ApnContext from the response message.
     *
     * @param Message sent from DC in response to REQ_GET_APNCONTEXT_LIST.
     * @return Collection of ApnContext
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.746 -0500", hash_original_method = "48ABE9510A7CA4042FB5B96D41BACEB8", hash_generated_method = "DF078C4F845878968FF429F8740C3228")
    
public Collection<ApnContext> rspApnList(Message response) {
        Collection<ApnContext> retVal = (Collection<ApnContext>)response.obj;
        if (retVal == null) retVal = new ArrayList<ApnContext>();
        return retVal;
    }

    /**
     * Retrieve collection of ApnContext currently associated with
     * the DataConnectionA synchronously.
     *
     * @return Collection of ApnContext
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.749 -0500", hash_original_method = "498EAD8B319A2A3996C6AC846ACD4BE2", hash_generated_method = "502F83993D3FC6EE0D18D20C357FD78D")
    
public Collection<ApnContext> getApnListSync() {
        Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        if ((response != null) && (response.what == RSP_GET_APNCONTEXT_LIST)) {
            if (DBG) log("getApnList ok");
            return rspApnList(response);
        } else {
            log("getApnList error response=" + response);
            // return dummy list with no entry
            return new ArrayList<ApnContext>();
        }
    }

    /**
     * Request to set Pending ReconnectIntent to DC.
     * Response RSP_SET_RECONNECT_INTENT when complete.
     */
    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.752 -0500", hash_original_method = "408D11B7A3DFC98C0728A70ED62F0EEA", hash_generated_method = "B88DF5F3CAE8626407681D6E71BCC297")
    
public void reqSetReconnectIntent(PendingIntent intent) {
        Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        if (DBG) log("reqSetReconnectIntent");
    }

    /**
     * Set pending reconnect intent to DC synchronously.
     *
     * @param PendingIntent to set.
     */
    @DSSink({DSSinkKind.PHONE_CONNECTION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.754 -0500", hash_original_method = "D99BC1BEF330D90F2BC64CDBA6E6105B", hash_generated_method = "AD6B542286D1442E604FB85C79D02B3B")
    
public void setReconnectIntentSync(PendingIntent intent) {
        Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        if ((response != null) && (response.what == RSP_SET_RECONNECT_INTENT)) {
            if (DBG) log("setReconnectIntent ok");
        } else {
            log("setReconnectIntent error response=" + response);
        }
    }

    /**
     * Request to get Pending ReconnectIntent to DC.
     * Response RSP_GET_RECONNECT_INTENT when complete.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.756 -0500", hash_original_method = "3F955D64051D380D89135CF7B70C1F05", hash_generated_method = "0EC25BC15D68F1E59DA0282A4EDDD537")
    
public void reqGetReconnectIntent() {
        Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        if (DBG) log("reqGetReconnectIntent");
    }

    /**
     * Retrieve reconnect intent from response message from DC.
     *
     * @param Message which contains the reconnect intent.
     * @return PendingIntent from the response.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.758 -0500", hash_original_method = "9555B3D0DB27D43CC0B0BA451DA1A9D5", hash_generated_method = "25B7A8A174AB1484FCBADD07D4D57006")
    
public PendingIntent rspReconnectIntent(Message response) {
        PendingIntent retVal = (PendingIntent) response.obj;
        return retVal;
    }

    /**
     * Retrieve reconnect intent currently set in DC synchronously.
     *
     * @return PendingIntent reconnect intent current ly set in DC
     */
    @DSSource({DSSourceKind.SYNCHRONIZATION_DATA})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.761 -0500", hash_original_method = "D70777E4A1678D0EF0C2B7C3D53ADD58", hash_generated_method = "DFC029D22F6A96D11B2F13A4E1E1A35B")
    
public PendingIntent getReconnectIntentSync() {
        Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        if ((response != null) && (response.what == RSP_GET_RECONNECT_INTENT)) {
            if (DBG) log("getReconnectIntent ok");
            return rspReconnectIntent(response);
        } else {
            log("getReconnectIntent error response=" + response);
            return null;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:26.763 -0500", hash_original_method = "3340C70610FFA5D9D28FC6E77DE7CB0F", hash_generated_method = "53EF0579E11A699B6468ECD12F78E1EC")
    
private void log(String s) {
        android.util.Log.d(mLogTag, "DataConnectionAc " + s);
    }
}

