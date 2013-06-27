package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import com.android.internal.telephony.DataConnection.UpdateLinkPropertyResult;
import com.android.internal.util.AsyncChannel;
import com.android.internal.util.Protocol;
import android.app.PendingIntent;
import android.net.LinkCapabilities;
import android.net.LinkProperties;
import android.net.ProxyProperties;
import android.os.Message;
import java.util.ArrayList;
import java.util.Collection;

public class DataConnectionAc extends AsyncChannel {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.630 -0400", hash_original_field = "503F6607C959C61B036C1484733875DB", hash_generated_field = "59F9615F1046A159253328ABFF9EBAC4")

    private String mLogTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.630 -0400", hash_original_field = "720D2EF97C9F7A0E2C3E644C6885F670", hash_generated_field = "4C14AF3C02F6F482DB5C38C18F17056F")

    public DataConnection dataConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.644 -0400", hash_original_method = "F4260E5BFAF2E10088BF39CBA8BFFFD2", hash_generated_method = "5A9866AB81164D05ED976FFB69238A22")
    public  DataConnectionAc(DataConnection dc, String logTag) {
        dataConnection = dc;
        mLogTag = logTag;
        // ---------- Original Method ----------
        //dataConnection = dc;
        //mLogTag = logTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.644 -0400", hash_original_method = "7AA2FA115BEA9C5CC0101E6522D85688", hash_generated_method = "06A43CBE1CF0CF8AC615D6BA7631300A")
    public void reqIsInactive() {
        sendMessage(REQ_IS_INACTIVE);
        log("reqIsInactive");
        // ---------- Original Method ----------
        //sendMessage(REQ_IS_INACTIVE);
        //if (DBG) log("reqIsInactive");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.644 -0400", hash_original_method = "D508FA29014931CB6CD29F8DFC756262", hash_generated_method = "F8C6BB310634B6CE682BDE4600E86BCB")
    public boolean rspIsInactive(Message response) {
        boolean retVal;
        retVal = response.arg1 == 1;
        log("rspIsInactive=" + retVal);
        addTaint(response.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_206151479 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_206151479;
        // ---------- Original Method ----------
        //boolean retVal = response.arg1 == 1;
        //if (DBG) log("rspIsInactive=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.649 -0400", hash_original_method = "5AFFFE1437681DAB31C247AD1B67F124", hash_generated_method = "E81A12A3E7D944DC86F5779DB48869A8")
    public boolean isInactiveSync() {
        Message response;
        response = sendMessageSynchronously(REQ_IS_INACTIVE);
        {
            boolean varB650A8A0D8B84B48BF0F9C39C1DE2524_738108748 = (rspIsInactive(response));
        } //End block
        {
            log("rspIsInactive error response=" + response);
        } //End block
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1849345101 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1849345101;
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_IS_INACTIVE);
        //if ((response != null) && (response.what == RSP_IS_INACTIVE)) {
            //return rspIsInactive(response);
        //} else {
            //log("rspIsInactive error response=" + response);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.649 -0400", hash_original_method = "E08DB9A60755AA94EB60896D4764AF5C", hash_generated_method = "557616FCF19CD91ECB6E61EE90498318")
    public void reqCid() {
        sendMessage(REQ_GET_CID);
        log("reqCid");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_CID);
        //if (DBG) log("reqCid");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.649 -0400", hash_original_method = "FF57B3B0C583923138679674F4E2FE25", hash_generated_method = "C08B0C10AAC8B848FFD522DA12F21A33")
    public int rspCid(Message response) {
        int retVal;
        retVal = response.arg1;
        log("rspCid=" + retVal);
        addTaint(response.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182342880 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1182342880;
        // ---------- Original Method ----------
        //int retVal = response.arg1;
        //if (DBG) log("rspCid=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.656 -0400", hash_original_method = "88FA920EA2D54F9DC82F8A70E10A6416", hash_generated_method = "6FCDE20BBA183331B4A15246ADBD225D")
    public int getCidSync() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_CID);
        {
            int var7557B1255F3B12D5499A8699601A416F_120064067 = (rspCid(response));
        } //End block
        {
            log("rspCid error response=" + response);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653066281 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_653066281;
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_CID);
        //if ((response != null) && (response.what == RSP_GET_CID)) {
            //return rspCid(response);
        //} else {
            //log("rspCid error response=" + response);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.657 -0400", hash_original_method = "5DBEE0C11260D4E2748BF847AE297C4B", hash_generated_method = "D22C34A9299A9E2EE473346D17E2A164")
    public void reqRefCount() {
        sendMessage(REQ_GET_REFCOUNT);
        log("reqRefCount");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_REFCOUNT);
        //if (DBG) log("reqRefCount");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.662 -0400", hash_original_method = "AFE421B2404E9D3449EC1EC9B786EEAC", hash_generated_method = "5BCD48FA8D3086BDAE07982A95CAA705")
    public int rspRefCount(Message response) {
        int retVal;
        retVal = response.arg1;
        log("rspRefCount=" + retVal);
        addTaint(response.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426806631 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1426806631;
        // ---------- Original Method ----------
        //int retVal = response.arg1;
        //if (DBG) log("rspRefCount=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.666 -0400", hash_original_method = "82303217C6F0F47E549DB7B210318471", hash_generated_method = "C1AE9CB543B5129E9B4F8E1A411AFC2E")
    public int getRefCountSync() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_REFCOUNT);
        {
            int var033F6520642A731301C2957B189A4CDB_1203693634 = (rspRefCount(response));
        } //End block
        {
            log("rspRefCount error response=" + response);
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_177611330 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_177611330;
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_REFCOUNT);
        //if ((response != null) && (response.what == RSP_GET_REFCOUNT)) {
            //return rspRefCount(response);
        //} else {
            //log("rspRefCount error response=" + response);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.667 -0400", hash_original_method = "C0AE060C8D213182996CE9AFC0358CCA", hash_generated_method = "1FB552CFFE6038744D13FCBC1CB17101")
    public void reqApnSetting() {
        sendMessage(REQ_GET_APNSETTING);
        log("reqApnSetting");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_APNSETTING);
        //if (DBG) log("reqApnSetting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.674 -0400", hash_original_method = "95D7FBD84C6C38BA2D84311C3C9BEF51", hash_generated_method = "7B61772CECDFA1ACA4393A167F7765A4")
    public ApnSetting rspApnSetting(Message response) {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_1182304522 = null; //Variable for return #1
        ApnSetting retVal;
        retVal = (ApnSetting) response.obj;
        log("rspApnSetting=" + retVal);
        varB4EAC82CA7396A68D541C85D26508E83_1182304522 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1182304522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1182304522;
        // ---------- Original Method ----------
        //ApnSetting retVal = (ApnSetting) response.obj;
        //if (DBG) log("rspApnSetting=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.675 -0400", hash_original_method = "DD32FEB19DC77901F346EA49C4C70BF1", hash_generated_method = "C72D141A5B817396BC72F526F67286EF")
    public ApnSetting getApnSettingSync() {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_438729629 = null; //Variable for return #1
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_1660865552 = null; //Variable for return #2
        Message response;
        response = sendMessageSynchronously(REQ_GET_APNSETTING);
        {
            varB4EAC82CA7396A68D541C85D26508E83_438729629 = rspApnSetting(response);
        } //End block
        {
            log("getApnSetting error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_1660865552 = null;
        } //End block
        ApnSetting varA7E53CE21691AB073D9660D615818899_704531690; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_704531690 = varB4EAC82CA7396A68D541C85D26508E83_438729629;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_704531690 = varB4EAC82CA7396A68D541C85D26508E83_1660865552;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_704531690.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_704531690;
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_APNSETTING);
        //if ((response != null) && (response.what == RSP_GET_APNSETTING)) {
            //return rspApnSetting(response);
        //} else {
            //log("getApnSetting error response=" + response);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.675 -0400", hash_original_method = "5D3EF8F8C1412EBC1BE098FA3C540E84", hash_generated_method = "FC504B42BD36F0CBDDACE97BA09C0C94")
    public void reqLinkProperties() {
        sendMessage(REQ_GET_LINK_PROPERTIES);
        log("reqLinkProperties");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_LINK_PROPERTIES);
        //if (DBG) log("reqLinkProperties");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.692 -0400", hash_original_method = "61AC833B412EB853D23C85E2B80FFC12", hash_generated_method = "F4CF274474252EB747E1D5ECBE607A7A")
    public LinkProperties rspLinkProperties(Message response) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_641759121 = null; //Variable for return #1
        LinkProperties retVal;
        retVal = (LinkProperties) response.obj;
        log("rspLinkProperties=" + retVal);
        varB4EAC82CA7396A68D541C85D26508E83_641759121 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_641759121.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_641759121;
        // ---------- Original Method ----------
        //LinkProperties retVal = (LinkProperties) response.obj;
        //if (DBG) log("rspLinkProperties=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.694 -0400", hash_original_method = "3F7712F482B5EE0C4EC3A4DBA0BA8D32", hash_generated_method = "BCD30C45A7FFAB18AA0E59D137FB7589")
    public LinkProperties getLinkPropertiesSync() {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1913521032 = null; //Variable for return #1
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1708405684 = null; //Variable for return #2
        Message response;
        response = sendMessageSynchronously(REQ_GET_LINK_PROPERTIES);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1913521032 = rspLinkProperties(response);
        } //End block
        {
            log("getLinkProperties error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_1708405684 = null;
        } //End block
        LinkProperties varA7E53CE21691AB073D9660D615818899_165975306; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_165975306 = varB4EAC82CA7396A68D541C85D26508E83_1913521032;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_165975306 = varB4EAC82CA7396A68D541C85D26508E83_1708405684;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_165975306.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_165975306;
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_LINK_PROPERTIES);
        //if ((response != null) && (response.what == RSP_GET_LINK_PROPERTIES)) {
            //return rspLinkProperties(response);
        //} else {
            //log("getLinkProperties error response=" + response);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.694 -0400", hash_original_method = "52664ABA5522CB5FFA9E0304A7C81F50", hash_generated_method = "819B95639F22B38F6028E968178C3194")
    public void reqSetLinkPropertiesHttpProxy(ProxyProperties proxy) {
        sendMessage(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        log("reqSetLinkPropertiesHttpProxy proxy=" + proxy);
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
        //sendMessage(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        //if (DBG) log("reqSetLinkPropertiesHttpProxy proxy=" + proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.697 -0400", hash_original_method = "71F35538546E3DD45C021DEA145F6AFD", hash_generated_method = "661DEF00D4EFAE52A8E2FA6A670C6B48")
    public void setLinkPropertiesHttpProxySync(ProxyProperties proxy) {
        Message response;
        response = sendMessageSynchronously(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        {
            log("setLinkPropertiesHttpPoxy ok");
        } //End block
        {
            log("setLinkPropertiesHttpPoxy error response=" + response);
        } //End block
        addTaint(proxy.getTaint());
        // ---------- Original Method ----------
        //Message response =
            //sendMessageSynchronously(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        //if ((response != null) && (response.what == RSP_SET_LINK_PROPERTIES_HTTP_PROXY)) {
            //if (DBG) log("setLinkPropertiesHttpPoxy ok");
        //} else {
            //log("setLinkPropertiesHttpPoxy error response=" + response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.698 -0400", hash_original_method = "1137FFCD79265DC595F1B5AA40674EF5", hash_generated_method = "3C2CB583023F436EE2C2DE0950AA0DB4")
    public void reqUpdateLinkPropertiesDataCallState(DataCallState newState) {
        sendMessage(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        log("reqUpdateLinkPropertiesDataCallState");
        addTaint(newState.getTaint());
        // ---------- Original Method ----------
        //sendMessage(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        //if (DBG) log("reqUpdateLinkPropertiesDataCallState");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.700 -0400", hash_original_method = "FF09E9AE970C8576F47A284FF7FFCA6D", hash_generated_method = "9764DBED4ED67BB46D2F669A88841B8B")
    public UpdateLinkPropertyResult rspUpdateLinkPropertiesDataCallState(Message response) {
        UpdateLinkPropertyResult varB4EAC82CA7396A68D541C85D26508E83_1933631772 = null; //Variable for return #1
        UpdateLinkPropertyResult retVal;
        retVal = (UpdateLinkPropertyResult)response.obj;
        log("rspUpdateLinkPropertiesState: retVal=" + retVal);
        varB4EAC82CA7396A68D541C85D26508E83_1933631772 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1933631772.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1933631772;
        // ---------- Original Method ----------
        //UpdateLinkPropertyResult retVal = (UpdateLinkPropertyResult)response.obj;
        //if (DBG) log("rspUpdateLinkPropertiesState: retVal=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.716 -0400", hash_original_method = "98F59EFFB83342DD2236B59D91A5E4B5", hash_generated_method = "95A62AFEDB3B6D6AEC273EED7C455DD4")
    public UpdateLinkPropertyResult updateLinkPropertiesDataCallStateSync(DataCallState newState) {
        UpdateLinkPropertyResult varB4EAC82CA7396A68D541C85D26508E83_1219130276 = null; //Variable for return #1
        UpdateLinkPropertyResult varB4EAC82CA7396A68D541C85D26508E83_2037512479 = null; //Variable for return #2
        Message response;
        response = sendMessageSynchronously(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1219130276 = rspUpdateLinkPropertiesDataCallState(response);
        } //End block
        {
            log("getLinkProperties error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_2037512479 = new UpdateLinkPropertyResult(new LinkProperties());
        } //End block
        addTaint(newState.getTaint());
        UpdateLinkPropertyResult varA7E53CE21691AB073D9660D615818899_2055188665; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2055188665 = varB4EAC82CA7396A68D541C85D26508E83_1219130276;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2055188665 = varB4EAC82CA7396A68D541C85D26508E83_2037512479;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2055188665.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2055188665;
        // ---------- Original Method ----------
        //Message response =
            //sendMessageSynchronously(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        //if ((response != null) &&
            //(response.what == RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE)) {
            //return rspUpdateLinkPropertiesDataCallState(response);
        //} else {
            //log("getLinkProperties error response=" + response);
            //return new UpdateLinkPropertyResult(new LinkProperties());
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.716 -0400", hash_original_method = "30D60C86BD34D11FA73E7C7E67CFC7AA", hash_generated_method = "34EE40AB35A64D7C1AF90878970AB648")
    public void reqLinkCapabilities() {
        sendMessage(REQ_GET_LINK_CAPABILITIES);
        log("reqLinkCapabilities");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_LINK_CAPABILITIES);
        //if (DBG) log("reqLinkCapabilities");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.800 -0400", hash_original_method = "F187911F3801DAE69287AC09EDB743FA", hash_generated_method = "4E67F195BBB2468624E86461FA249110")
    public LinkCapabilities rspLinkCapabilities(Message response) {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_2098627234 = null; //Variable for return #1
        LinkCapabilities retVal;
        retVal = (LinkCapabilities) response.obj;
        log("rspLinkCapabilities=" + retVal);
        varB4EAC82CA7396A68D541C85D26508E83_2098627234 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_2098627234.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2098627234;
        // ---------- Original Method ----------
        //LinkCapabilities retVal = (LinkCapabilities) response.obj;
        //if (DBG) log("rspLinkCapabilities=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.800 -0400", hash_original_method = "C1F7B964512DA39EF105AA8C4B5198E6", hash_generated_method = "56DF32AE8B7B2C52680230544AAE558D")
    public LinkCapabilities getLinkCapabilitiesSync() {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_1334350708 = null; //Variable for return #1
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_63604149 = null; //Variable for return #2
        Message response;
        response = sendMessageSynchronously(REQ_GET_LINK_CAPABILITIES);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1334350708 = rspLinkCapabilities(response);
        } //End block
        {
            log("getLinkCapabilities error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_63604149 = null;
        } //End block
        LinkCapabilities varA7E53CE21691AB073D9660D615818899_132816202; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_132816202 = varB4EAC82CA7396A68D541C85D26508E83_1334350708;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_132816202 = varB4EAC82CA7396A68D541C85D26508E83_63604149;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_132816202.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_132816202;
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_LINK_CAPABILITIES);
        //if ((response != null) && (response.what == RSP_GET_LINK_CAPABILITIES)) {
            //return rspLinkCapabilities(response);
        //} else {
            //log("getLinkCapabilities error response=" + response);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.801 -0400", hash_original_method = "9EFFE3DDD73E4A7AC997D7CA04936F41", hash_generated_method = "0A25D7986DDF3BF45A5E023040AD0D2A")
    public void reqReset() {
        sendMessage(REQ_RESET);
        log("reqReset");
        // ---------- Original Method ----------
        //sendMessage(REQ_RESET);
        //if (DBG) log("reqReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.801 -0400", hash_original_method = "C179D3525D5003A50B8C9C0361938568", hash_generated_method = "A752D202959C50D6FADF7200618EB226")
    public void resetSync() {
        Message response;
        response = sendMessageSynchronously(REQ_RESET);
        {
            log("restSync ok");
        } //End block
        {
            log("restSync error response=" + response);
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_RESET);
        //if ((response != null) && (response.what == RSP_RESET)) {
            //if (DBG) log("restSync ok");
        //} else {
            //log("restSync error response=" + response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.802 -0400", hash_original_method = "F3233E69134CF9902E31FB14516EC03E", hash_generated_method = "0F1EBD5095243AFEC3D6E7830B506217")
    public void reqAddApnContext(ApnContext apnContext) {
        Message response;
        response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        log("reqAddApnContext");
        addTaint(apnContext.getTaint());
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        //if (DBG) log("reqAddApnContext");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.802 -0400", hash_original_method = "29B8FEA7830E2BBE9C7BBFD69E48646E", hash_generated_method = "058C56BE92329EA9DD08F8AAB873D55F")
    public void addApnContextSync(ApnContext apnContext) {
        Message response;
        response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        {
            log("addApnContext ok");
        } //End block
        {
            log("addApnContext error response=" + response);
        } //End block
        addTaint(apnContext.getTaint());
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        //if ((response != null) && (response.what == RSP_ADD_APNCONTEXT)) {
            //if (DBG) log("addApnContext ok");
        //} else {
            //log("addApnContext error response=" + response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.802 -0400", hash_original_method = "51B2CCF2735E77C63E82DEC17109A5B1", hash_generated_method = "BDE9A57D8545BF621127F6F1DD186CA4")
    public void reqRemomveApnContext(ApnContext apnContext) {
        Message response;
        response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        log("reqRemomveApnContext");
        addTaint(apnContext.getTaint());
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        //if (DBG) log("reqRemomveApnContext");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.803 -0400", hash_original_method = "62E31991C2E3FEB9590AC2302F444FDA", hash_generated_method = "9DAEBFADA2259B6DE4074AB00B80C7E8")
    public void removeApnContextSync(ApnContext apnContext) {
        Message response;
        response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        {
            log("removeApnContext ok");
        } //End block
        {
            log("removeApnContext error response=" + response);
        } //End block
        addTaint(apnContext.getTaint());
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        //if ((response != null) && (response.what == RSP_REMOVE_APNCONTEXT)) {
            //if (DBG) log("removeApnContext ok");
        //} else {
            //log("removeApnContext error response=" + response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.803 -0400", hash_original_method = "AAD200E4835E6912540E5A2C7F9552F9", hash_generated_method = "E87896B46AC8250984A1B153345D0202")
    public void reqGetApnList(ApnContext apnContext) {
        Message response;
        response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        log("reqGetApnList");
        addTaint(apnContext.getTaint());
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        //if (DBG) log("reqGetApnList");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.804 -0400", hash_original_method = "48ABE9510A7CA4042FB5B96D41BACEB8", hash_generated_method = "2BEDEB47A200CE4C761EFA84280BD0A3")
    public Collection<ApnContext> rspApnList(Message response) {
        Collection<ApnContext> varB4EAC82CA7396A68D541C85D26508E83_55651195 = null; //Variable for return #1
        Collection<ApnContext> retVal;
        retVal = (Collection<ApnContext>)response.obj;
        retVal = new ArrayList<ApnContext>();
        varB4EAC82CA7396A68D541C85D26508E83_55651195 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_55651195.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_55651195;
        // ---------- Original Method ----------
        //Collection<ApnContext> retVal = (Collection<ApnContext>)response.obj;
        //if (retVal == null) retVal = new ArrayList<ApnContext>();
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.804 -0400", hash_original_method = "498EAD8B319A2A3996C6AC846ACD4BE2", hash_generated_method = "9B4DFDBFB8AC8C6B961F2C8A04B17F5E")
    public Collection<ApnContext> getApnListSync() {
        Collection<ApnContext> varB4EAC82CA7396A68D541C85D26508E83_352479292 = null; //Variable for return #1
        Collection<ApnContext> varB4EAC82CA7396A68D541C85D26508E83_957217006 = null; //Variable for return #2
        Message response;
        response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        {
            log("getApnList ok");
            varB4EAC82CA7396A68D541C85D26508E83_352479292 = rspApnList(response);
        } //End block
        {
            log("getApnList error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_957217006 = new ArrayList<ApnContext>();
        } //End block
        Collection<ApnContext> varA7E53CE21691AB073D9660D615818899_1239501345; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1239501345 = varB4EAC82CA7396A68D541C85D26508E83_352479292;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1239501345 = varB4EAC82CA7396A68D541C85D26508E83_957217006;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1239501345.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1239501345;
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        //if ((response != null) && (response.what == RSP_GET_APNCONTEXT_LIST)) {
            //if (DBG) log("getApnList ok");
            //return rspApnList(response);
        //} else {
            //log("getApnList error response=" + response);
            //return new ArrayList<ApnContext>();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.807 -0400", hash_original_method = "408D11B7A3DFC98C0728A70ED62F0EEA", hash_generated_method = "7957597C7F992E574A637C4B65997842")
    public void reqSetReconnectIntent(PendingIntent intent) {
        Message response;
        response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        log("reqSetReconnectIntent");
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        //if (DBG) log("reqSetReconnectIntent");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.811 -0400", hash_original_method = "D99BC1BEF330D90F2BC64CDBA6E6105B", hash_generated_method = "39F4B16DB635596FAB26ACDA0DAE336C")
    public void setReconnectIntentSync(PendingIntent intent) {
        Message response;
        response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        {
            log("setReconnectIntent ok");
        } //End block
        {
            log("setReconnectIntent error response=" + response);
        } //End block
        addTaint(intent.getTaint());
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        //if ((response != null) && (response.what == RSP_SET_RECONNECT_INTENT)) {
            //if (DBG) log("setReconnectIntent ok");
        //} else {
            //log("setReconnectIntent error response=" + response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.812 -0400", hash_original_method = "3F955D64051D380D89135CF7B70C1F05", hash_generated_method = "FBDAC78F09D752AEF0E80C854BB23C97")
    public void reqGetReconnectIntent() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        log("reqGetReconnectIntent");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        //if (DBG) log("reqGetReconnectIntent");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.813 -0400", hash_original_method = "9555B3D0DB27D43CC0B0BA451DA1A9D5", hash_generated_method = "B64B704DDBCA7082538EE793CD225B4C")
    public PendingIntent rspReconnectIntent(Message response) {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_348601018 = null; //Variable for return #1
        PendingIntent retVal;
        retVal = (PendingIntent) response.obj;
        varB4EAC82CA7396A68D541C85D26508E83_348601018 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_348601018.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_348601018;
        // ---------- Original Method ----------
        //PendingIntent retVal = (PendingIntent) response.obj;
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.814 -0400", hash_original_method = "D70777E4A1678D0EF0C2B7C3D53ADD58", hash_generated_method = "F6ED98BB1A20FB41A57B15BBE9D77A12")
    public PendingIntent getReconnectIntentSync() {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1959736113 = null; //Variable for return #1
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1724052700 = null; //Variable for return #2
        Message response;
        response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        {
            log("getReconnectIntent ok");
            varB4EAC82CA7396A68D541C85D26508E83_1959736113 = rspReconnectIntent(response);
        } //End block
        {
            log("getReconnectIntent error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_1724052700 = null;
        } //End block
        PendingIntent varA7E53CE21691AB073D9660D615818899_355485976; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_355485976 = varB4EAC82CA7396A68D541C85D26508E83_1959736113;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_355485976 = varB4EAC82CA7396A68D541C85D26508E83_1724052700;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_355485976.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_355485976;
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        //if ((response != null) && (response.what == RSP_GET_RECONNECT_INTENT)) {
            //if (DBG) log("getReconnectIntent ok");
            //return rspReconnectIntent(response);
        //} else {
            //log("getReconnectIntent error response=" + response);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_method = "3340C70610FFA5D9D28FC6E77DE7CB0F", hash_generated_method = "8B71FEEF08A72DF7241D84A13E8D8BDC")
    private void log(String s) {
        android.util.Log.d(mLogTag, "DataConnectionAc " + s);
        addTaint(s.getTaint());
        // ---------- Original Method ----------
        //android.util.Log.d(mLogTag, "DataConnectionAc " + s);
    }

    
    public enum LinkPropertyChangeAction {
        NONE, CHANGED, RESET;
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "B7C4E93D97D072890A37A56076D870F8")

    private static boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "06E844B888ED9045894B2B8636373495", hash_generated_field = "6BCB0AA355104F156D0A2B3A91BB070E")

    public static final int BASE = Protocol.BASE_DATA_CONNECTION_AC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "EADBD9ECE62C98E1D8E918128B3CA096", hash_generated_field = "1475D2F355264F68EEAD5DE0DC64E4C1")

    public static final int REQ_IS_INACTIVE = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "1B158D124EED34F8B028A91607C881D2", hash_generated_field = "4EF0EE195500EDBC396F404FB857CFCE")

    public static final int RSP_IS_INACTIVE = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "D8F3245683A6ECB00974E58E4A8A6249", hash_generated_field = "100ADE81533B5A145526EE17F8BCF7F6")

    public static final int REQ_GET_CID = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "F6D68F5B120AFF550917C4B5568E2EAB", hash_generated_field = "4AADBE311B5CBD53B22C258FD0BC5894")

    public static final int RSP_GET_CID = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "451E9EC325AB2136FBF344263AC13FB4", hash_generated_field = "4556E2B1BBE8565148BB1897F4F1FFF2")

    public static final int REQ_GET_APNSETTING = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "67C1D26E2877CD8726F9AC202269D341", hash_generated_field = "075D97CF7AE01BA14B82937FAB85E17C")

    public static final int RSP_GET_APNSETTING = BASE + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "44E8E021E38F9F4957C80CC8005AF125", hash_generated_field = "6B2177B63C14A3D8C4A0465DF7EDA57B")

    public static final int REQ_GET_LINK_PROPERTIES = BASE + 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "500C1AC91FB838581568984E44550968", hash_generated_field = "B073222C67C8387DA84D52E09C649C5B")

    public static final int RSP_GET_LINK_PROPERTIES = BASE + 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "2BF1A9BBA19C9A658F6D0B42DAED1E41", hash_generated_field = "AA7EDD6DEA7FBE6E6DEDC341AE2566AA")

    public static final int REQ_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "9DFC37643183DE61DD9F1BC7337883B3", hash_generated_field = "2BD71056213661FD69459E151EB320F2")

    public static final int RSP_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "065018769EB6CC7F7373CA6BED8F7643", hash_generated_field = "42BC94DC23936D5550B2F12E94B801F3")

    public static final int REQ_GET_LINK_CAPABILITIES = BASE + 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "9F9D88D4A8B28546FEE157032AC8B70A", hash_generated_field = "7C871C282AED07B5AFD51BB60DC58B87")

    public static final int RSP_GET_LINK_CAPABILITIES = BASE + 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "16010B85948823BF66211764D7B5283B", hash_generated_field = "410DC65F191E667E05E1C26996344ED6")

    public static final int REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "3DD80A27FF8D61C2D2E8816651BAC0E4", hash_generated_field = "EABD1A19ECDA7C315E74E3BB10C8AA34")

    public static final int RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.815 -0400", hash_original_field = "F6491F3C8DCD8733232690FB3896BF47", hash_generated_field = "FA6D9E30AD45F04695E898045922860A")

    public static final int REQ_RESET = BASE + 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.816 -0400", hash_original_field = "CF1337BD01D40550D657AF71D5457B15", hash_generated_field = "669F769EC139E98CB3AFB220D6A1C9FE")

    public static final int RSP_RESET = BASE + 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.816 -0400", hash_original_field = "C3E5268DDA9CBD4AD8CA1F06BAC6941B", hash_generated_field = "76D19A23EEE2DE297833D58F70073A84")

    public static final int REQ_GET_REFCOUNT = BASE + 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.816 -0400", hash_original_field = "E6E62475054FEEC765CEF64603D3A70D", hash_generated_field = "BD8C38909076EDBB350F0534D3158B5A")

    public static final int RSP_GET_REFCOUNT = BASE + 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.821 -0400", hash_original_field = "2E82E5CB120F76BE1E9AABB7166660B5", hash_generated_field = "8F3EC990CEC19BF924C0C83E473DF703")

    public static final int REQ_ADD_APNCONTEXT = BASE + 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.821 -0400", hash_original_field = "5FFC50DC4F0DF7544490909AD3D8DB3D", hash_generated_field = "D05330977465F7AF4E384E150213096A")

    public static final int RSP_ADD_APNCONTEXT = BASE + 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.821 -0400", hash_original_field = "86AFFBEDA03B70DE11F7AFE2EE19B988", hash_generated_field = "FC2140507E1C1E4A862E984C6536D33F")

    public static final int REQ_REMOVE_APNCONTEXT = BASE + 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.822 -0400", hash_original_field = "452A4337B6E6F3036095C684213134BF", hash_generated_field = "F6C5D6966EFACD969BB347661AD8098A")

    public static final int RSP_REMOVE_APNCONTEXT = BASE + 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.822 -0400", hash_original_field = "842D49F350462A667AD2590CE93489B0", hash_generated_field = "7CADBAFCB6C4D553E00439A92A77399A")

    public static final int REQ_GET_APNCONTEXT_LIST = BASE + 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.822 -0400", hash_original_field = "63393ADC62ADB8086F1A9106D4DA73F7", hash_generated_field = "08CEE76E523CBFA9615E63AE42E97282")

    public static final int RSP_GET_APNCONTEXT_LIST = BASE + 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.822 -0400", hash_original_field = "F83139694F8C75C29041CAD82805FBC0", hash_generated_field = "AEDC94BDC63CFCBD1EE247E113E0B2BD")

    public static final int REQ_SET_RECONNECT_INTENT = BASE + 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.822 -0400", hash_original_field = "1A21029CD633D0CA53EB46E887F9DCE0", hash_generated_field = "50977DA17634FA6287626111506AF1F5")

    public static final int RSP_SET_RECONNECT_INTENT = BASE + 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.822 -0400", hash_original_field = "E9DEE9E0E0EB4253C7E41D3E57891BB2", hash_generated_field = "E050F9150348EB87E92AA17BEF7AA6F1")

    public static final int REQ_GET_RECONNECT_INTENT = BASE + 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:13.822 -0400", hash_original_field = "9440C9722A4FB872C7E1976D00F575DE", hash_generated_field = "B47C4AB7C8CEFA3E66A64CE4AF15F148")

    public static final int RSP_GET_RECONNECT_INTENT = BASE + 27;
}

