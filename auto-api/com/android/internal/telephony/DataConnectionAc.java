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
    private String mLogTag;
    public DataConnection dataConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.997 -0400", hash_original_method = "F4260E5BFAF2E10088BF39CBA8BFFFD2", hash_generated_method = "A1BA6EE0D5724F5C55CBE24988B79A2B")
    @DSModeled(DSC.SAFE)
    public DataConnectionAc(DataConnection dc, String logTag) {
        dsTaint.addTaint(dc.dsTaint);
        dsTaint.addTaint(logTag);
        // ---------- Original Method ----------
        //dataConnection = dc;
        //mLogTag = logTag;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.998 -0400", hash_original_method = "7AA2FA115BEA9C5CC0101E6522D85688", hash_generated_method = "06A43CBE1CF0CF8AC615D6BA7631300A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqIsInactive() {
        sendMessage(REQ_IS_INACTIVE);
        log("reqIsInactive");
        // ---------- Original Method ----------
        //sendMessage(REQ_IS_INACTIVE);
        //if (DBG) log("reqIsInactive");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.999 -0400", hash_original_method = "D508FA29014931CB6CD29F8DFC756262", hash_generated_method = "A3B0DD9ED2C1C26F1149EC7DE15EE367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean rspIsInactive(Message response) {
        dsTaint.addTaint(response.dsTaint);
        boolean retVal;
        retVal = response.arg1 == 1;
        log("rspIsInactive=" + retVal);
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //boolean retVal = response.arg1 == 1;
        //if (DBG) log("rspIsInactive=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.000 -0400", hash_original_method = "5AFFFE1437681DAB31C247AD1B67F124", hash_generated_method = "474E8296BA3D1E0EAB58932FD4A0B84C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isInactiveSync() {
        Message response;
        response = sendMessageSynchronously(REQ_IS_INACTIVE);
        {
            boolean varB650A8A0D8B84B48BF0F9C39C1DE2524_1695721896 = (rspIsInactive(response));
        } //End block
        {
            log("rspIsInactive error response=" + response);
        } //End block
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_IS_INACTIVE);
        //if ((response != null) && (response.what == RSP_IS_INACTIVE)) {
            //return rspIsInactive(response);
        //} else {
            //log("rspIsInactive error response=" + response);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.000 -0400", hash_original_method = "E08DB9A60755AA94EB60896D4764AF5C", hash_generated_method = "557616FCF19CD91ECB6E61EE90498318")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqCid() {
        sendMessage(REQ_GET_CID);
        log("reqCid");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_CID);
        //if (DBG) log("reqCid");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.000 -0400", hash_original_method = "FF57B3B0C583923138679674F4E2FE25", hash_generated_method = "C471018E30AA327F46323388406617D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int rspCid(Message response) {
        dsTaint.addTaint(response.dsTaint);
        int retVal;
        retVal = response.arg1;
        log("rspCid=" + retVal);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int retVal = response.arg1;
        //if (DBG) log("rspCid=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.002 -0400", hash_original_method = "88FA920EA2D54F9DC82F8A70E10A6416", hash_generated_method = "96771CAFCD08D2B6202136122A30B67F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getCidSync() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_CID);
        {
            int var7557B1255F3B12D5499A8699601A416F_1369720498 = (rspCid(response));
        } //End block
        {
            log("rspCid error response=" + response);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_CID);
        //if ((response != null) && (response.what == RSP_GET_CID)) {
            //return rspCid(response);
        //} else {
            //log("rspCid error response=" + response);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.002 -0400", hash_original_method = "5DBEE0C11260D4E2748BF847AE297C4B", hash_generated_method = "D22C34A9299A9E2EE473346D17E2A164")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqRefCount() {
        sendMessage(REQ_GET_REFCOUNT);
        log("reqRefCount");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_REFCOUNT);
        //if (DBG) log("reqRefCount");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.002 -0400", hash_original_method = "AFE421B2404E9D3449EC1EC9B786EEAC", hash_generated_method = "93756590F3F6F703C2BABE50A3BD75BF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int rspRefCount(Message response) {
        dsTaint.addTaint(response.dsTaint);
        int retVal;
        retVal = response.arg1;
        log("rspRefCount=" + retVal);
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int retVal = response.arg1;
        //if (DBG) log("rspRefCount=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.003 -0400", hash_original_method = "82303217C6F0F47E549DB7B210318471", hash_generated_method = "5018DA27264542B42CE2BDCCCA35FDF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getRefCountSync() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_REFCOUNT);
        {
            int var033F6520642A731301C2957B189A4CDB_76912509 = (rspRefCount(response));
        } //End block
        {
            log("rspRefCount error response=" + response);
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_REFCOUNT);
        //if ((response != null) && (response.what == RSP_GET_REFCOUNT)) {
            //return rspRefCount(response);
        //} else {
            //log("rspRefCount error response=" + response);
            //return -1;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.003 -0400", hash_original_method = "C0AE060C8D213182996CE9AFC0358CCA", hash_generated_method = "1FB552CFFE6038744D13FCBC1CB17101")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqApnSetting() {
        sendMessage(REQ_GET_APNSETTING);
        log("reqApnSetting");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_APNSETTING);
        //if (DBG) log("reqApnSetting");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.003 -0400", hash_original_method = "95D7FBD84C6C38BA2D84311C3C9BEF51", hash_generated_method = "0DE1826C7ABC26578B3EBCE3221DB6AD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ApnSetting rspApnSetting(Message response) {
        dsTaint.addTaint(response.dsTaint);
        ApnSetting retVal;
        retVal = (ApnSetting) response.obj;
        log("rspApnSetting=" + retVal);
        return (ApnSetting)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ApnSetting retVal = (ApnSetting) response.obj;
        //if (DBG) log("rspApnSetting=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.003 -0400", hash_original_method = "DD32FEB19DC77901F346EA49C4C70BF1", hash_generated_method = "FD012AA7A75F6E2A3278CE3879A6789B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ApnSetting getApnSettingSync() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_APNSETTING);
        {
            ApnSetting var6FEE1A77D74D1956C5EA265A71A313F2_1257886818 = (rspApnSetting(response));
        } //End block
        {
            log("getApnSetting error response=" + response);
        } //End block
        return (ApnSetting)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_APNSETTING);
        //if ((response != null) && (response.what == RSP_GET_APNSETTING)) {
            //return rspApnSetting(response);
        //} else {
            //log("getApnSetting error response=" + response);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.004 -0400", hash_original_method = "5D3EF8F8C1412EBC1BE098FA3C540E84", hash_generated_method = "FC504B42BD36F0CBDDACE97BA09C0C94")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqLinkProperties() {
        sendMessage(REQ_GET_LINK_PROPERTIES);
        log("reqLinkProperties");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_LINK_PROPERTIES);
        //if (DBG) log("reqLinkProperties");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.004 -0400", hash_original_method = "61AC833B412EB853D23C85E2B80FFC12", hash_generated_method = "63CCBABE38191B4D725228DA9B38387F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties rspLinkProperties(Message response) {
        dsTaint.addTaint(response.dsTaint);
        LinkProperties retVal;
        retVal = (LinkProperties) response.obj;
        log("rspLinkProperties=" + retVal);
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkProperties retVal = (LinkProperties) response.obj;
        //if (DBG) log("rspLinkProperties=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.005 -0400", hash_original_method = "3F7712F482B5EE0C4EC3A4DBA0BA8D32", hash_generated_method = "3D0FDCEA80EAE5D0C5FCC25D65E8AC52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkProperties getLinkPropertiesSync() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_LINK_PROPERTIES);
        {
            LinkProperties var8D462CDFC68C883CB726072884A781F4_1023164483 = (rspLinkProperties(response));
        } //End block
        {
            log("getLinkProperties error response=" + response);
        } //End block
        return (LinkProperties)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_LINK_PROPERTIES);
        //if ((response != null) && (response.what == RSP_GET_LINK_PROPERTIES)) {
            //return rspLinkProperties(response);
        //} else {
            //log("getLinkProperties error response=" + response);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.005 -0400", hash_original_method = "52664ABA5522CB5FFA9E0304A7C81F50", hash_generated_method = "2159205574A429C9081ECD6D8A16B136")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqSetLinkPropertiesHttpProxy(ProxyProperties proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        sendMessage(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        log("reqSetLinkPropertiesHttpProxy proxy=" + proxy);
        // ---------- Original Method ----------
        //sendMessage(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        //if (DBG) log("reqSetLinkPropertiesHttpProxy proxy=" + proxy);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.005 -0400", hash_original_method = "71F35538546E3DD45C021DEA145F6AFD", hash_generated_method = "14236ECA1C4126C769067C7D60A04C50")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setLinkPropertiesHttpProxySync(ProxyProperties proxy) {
        dsTaint.addTaint(proxy.dsTaint);
        Message response;
        response = sendMessageSynchronously(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        {
            log("setLinkPropertiesHttpPoxy ok");
        } //End block
        {
            log("setLinkPropertiesHttpPoxy error response=" + response);
        } //End block
        // ---------- Original Method ----------
        //Message response =
            //sendMessageSynchronously(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        //if ((response != null) && (response.what == RSP_SET_LINK_PROPERTIES_HTTP_PROXY)) {
            //if (DBG) log("setLinkPropertiesHttpPoxy ok");
        //} else {
            //log("setLinkPropertiesHttpPoxy error response=" + response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.006 -0400", hash_original_method = "1137FFCD79265DC595F1B5AA40674EF5", hash_generated_method = "72046D112541E8BF57C1E958E39C468D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqUpdateLinkPropertiesDataCallState(DataCallState newState) {
        dsTaint.addTaint(newState.dsTaint);
        sendMessage(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        log("reqUpdateLinkPropertiesDataCallState");
        // ---------- Original Method ----------
        //sendMessage(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        //if (DBG) log("reqUpdateLinkPropertiesDataCallState");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.007 -0400", hash_original_method = "FF09E9AE970C8576F47A284FF7FFCA6D", hash_generated_method = "EDD9D9E9DDA1E38D1A3B37AF3CE572B4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UpdateLinkPropertyResult rspUpdateLinkPropertiesDataCallState(Message response) {
        dsTaint.addTaint(response.dsTaint);
        UpdateLinkPropertyResult retVal;
        retVal = (UpdateLinkPropertyResult)response.obj;
        log("rspUpdateLinkPropertiesState: retVal=" + retVal);
        return (UpdateLinkPropertyResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        //UpdateLinkPropertyResult retVal = (UpdateLinkPropertyResult)response.obj;
        //if (DBG) log("rspUpdateLinkPropertiesState: retVal=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.007 -0400", hash_original_method = "98F59EFFB83342DD2236B59D91A5E4B5", hash_generated_method = "9FB07BC2D9B13D1FB89B04253E2294B6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public UpdateLinkPropertyResult updateLinkPropertiesDataCallStateSync(DataCallState newState) {
        dsTaint.addTaint(newState.dsTaint);
        Message response;
        response = sendMessageSynchronously(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        {
            UpdateLinkPropertyResult varBE45FF7FAAC217769E1EC89BF4CDA2E2_978527154 = (rspUpdateLinkPropertiesDataCallState(response));
        } //End block
        {
            log("getLinkProperties error response=" + response);
            UpdateLinkPropertyResult varD6EA06716B5F2A1879B682F2765E47B1_22888862 = (new UpdateLinkPropertyResult(new LinkProperties()));
        } //End block
        return (UpdateLinkPropertyResult)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.008 -0400", hash_original_method = "30D60C86BD34D11FA73E7C7E67CFC7AA", hash_generated_method = "34EE40AB35A64D7C1AF90878970AB648")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqLinkCapabilities() {
        sendMessage(REQ_GET_LINK_CAPABILITIES);
        log("reqLinkCapabilities");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_LINK_CAPABILITIES);
        //if (DBG) log("reqLinkCapabilities");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.008 -0400", hash_original_method = "F187911F3801DAE69287AC09EDB743FA", hash_generated_method = "0398212B1893350B9DBDB69F042A942B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkCapabilities rspLinkCapabilities(Message response) {
        dsTaint.addTaint(response.dsTaint);
        LinkCapabilities retVal;
        retVal = (LinkCapabilities) response.obj;
        log("rspLinkCapabilities=" + retVal);
        return (LinkCapabilities)dsTaint.getTaint();
        // ---------- Original Method ----------
        //LinkCapabilities retVal = (LinkCapabilities) response.obj;
        //if (DBG) log("rspLinkCapabilities=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.008 -0400", hash_original_method = "C1F7B964512DA39EF105AA8C4B5198E6", hash_generated_method = "FB307BD07057A11B95CD53721FD1CA5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public LinkCapabilities getLinkCapabilitiesSync() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_LINK_CAPABILITIES);
        {
            LinkCapabilities var05F22A5F8FA1283D57FC58E0CC9C3B81_996563954 = (rspLinkCapabilities(response));
        } //End block
        {
            log("getLinkCapabilities error response=" + response);
        } //End block
        return (LinkCapabilities)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_LINK_CAPABILITIES);
        //if ((response != null) && (response.what == RSP_GET_LINK_CAPABILITIES)) {
            //return rspLinkCapabilities(response);
        //} else {
            //log("getLinkCapabilities error response=" + response);
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.008 -0400", hash_original_method = "9EFFE3DDD73E4A7AC997D7CA04936F41", hash_generated_method = "0A25D7986DDF3BF45A5E023040AD0D2A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqReset() {
        sendMessage(REQ_RESET);
        log("reqReset");
        // ---------- Original Method ----------
        //sendMessage(REQ_RESET);
        //if (DBG) log("reqReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.009 -0400", hash_original_method = "C179D3525D5003A50B8C9C0361938568", hash_generated_method = "A752D202959C50D6FADF7200618EB226")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.009 -0400", hash_original_method = "F3233E69134CF9902E31FB14516EC03E", hash_generated_method = "78ED347A107FB4F22B2A2240A48D3BA3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqAddApnContext(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        Message response;
        response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        log("reqAddApnContext");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        //if (DBG) log("reqAddApnContext");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.009 -0400", hash_original_method = "29B8FEA7830E2BBE9C7BBFD69E48646E", hash_generated_method = "4D70FCDC9FC2BF490B1F543D5D997DF1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void addApnContextSync(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        Message response;
        response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        {
            log("addApnContext ok");
        } //End block
        {
            log("addApnContext error response=" + response);
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        //if ((response != null) && (response.what == RSP_ADD_APNCONTEXT)) {
            //if (DBG) log("addApnContext ok");
        //} else {
            //log("addApnContext error response=" + response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.009 -0400", hash_original_method = "51B2CCF2735E77C63E82DEC17109A5B1", hash_generated_method = "9AEBCAA4D403DB5ED965EB2DB7F387A4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqRemomveApnContext(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        Message response;
        response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        log("reqRemomveApnContext");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        //if (DBG) log("reqRemomveApnContext");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.010 -0400", hash_original_method = "62E31991C2E3FEB9590AC2302F444FDA", hash_generated_method = "CEEFCC2B881A2B41DCBB6CD9510155B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void removeApnContextSync(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        Message response;
        response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        {
            log("removeApnContext ok");
        } //End block
        {
            log("removeApnContext error response=" + response);
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        //if ((response != null) && (response.what == RSP_REMOVE_APNCONTEXT)) {
            //if (DBG) log("removeApnContext ok");
        //} else {
            //log("removeApnContext error response=" + response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.010 -0400", hash_original_method = "AAD200E4835E6912540E5A2C7F9552F9", hash_generated_method = "BD0FB710F6F7BD59A47F33BD19D1D594")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqGetApnList(ApnContext apnContext) {
        dsTaint.addTaint(apnContext.dsTaint);
        Message response;
        response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        log("reqGetApnList");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        //if (DBG) log("reqGetApnList");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.010 -0400", hash_original_method = "48ABE9510A7CA4042FB5B96D41BACEB8", hash_generated_method = "49BC58C6876E584BF16C1C10D069EC8E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<ApnContext> rspApnList(Message response) {
        dsTaint.addTaint(response.dsTaint);
        Collection<ApnContext> retVal;
        retVal = (Collection<ApnContext>)response.obj;
        retVal = new ArrayList<ApnContext>();
        return (Collection<ApnContext>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //Collection<ApnContext> retVal = (Collection<ApnContext>)response.obj;
        //if (retVal == null) retVal = new ArrayList<ApnContext>();
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.010 -0400", hash_original_method = "498EAD8B319A2A3996C6AC846ACD4BE2", hash_generated_method = "980339A570393A722798B17207749DD4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Collection<ApnContext> getApnListSync() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        {
            log("getApnList ok");
            Collection<ApnContext> varD9E2572D45A2B3BE9859EFBCDF132938_2015276885 = (rspApnList(response));
        } //End block
        {
            log("getApnList error response=" + response);
            Collection<ApnContext> varC3DCAABC9457E8F25C601E9C0DC5CC65_1386186281 = (new ArrayList<ApnContext>());
        } //End block
        return (Collection<ApnContext>)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.010 -0400", hash_original_method = "408D11B7A3DFC98C0728A70ED62F0EEA", hash_generated_method = "A579F650CBF92D25602161C71BED589C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqSetReconnectIntent(PendingIntent intent) {
        dsTaint.addTaint(intent.dsTaint);
        Message response;
        response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        log("reqSetReconnectIntent");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        //if (DBG) log("reqSetReconnectIntent");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.011 -0400", hash_original_method = "D99BC1BEF330D90F2BC64CDBA6E6105B", hash_generated_method = "75CBE51D5E0948518A8DA1EA1B0A8705")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setReconnectIntentSync(PendingIntent intent) {
        dsTaint.addTaint(intent.dsTaint);
        Message response;
        response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        {
            log("setReconnectIntent ok");
        } //End block
        {
            log("setReconnectIntent error response=" + response);
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        //if ((response != null) && (response.what == RSP_SET_RECONNECT_INTENT)) {
            //if (DBG) log("setReconnectIntent ok");
        //} else {
            //log("setReconnectIntent error response=" + response);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.011 -0400", hash_original_method = "3F955D64051D380D89135CF7B70C1F05", hash_generated_method = "FBDAC78F09D752AEF0E80C854BB23C97")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void reqGetReconnectIntent() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        log("reqGetReconnectIntent");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        //if (DBG) log("reqGetReconnectIntent");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.011 -0400", hash_original_method = "9555B3D0DB27D43CC0B0BA451DA1A9D5", hash_generated_method = "3CE4F316CBC184381E0B8A37219B2D44")
    @DSModeled(DSC.SAFE)
    public PendingIntent rspReconnectIntent(Message response) {
        dsTaint.addTaint(response.dsTaint);
        PendingIntent retVal;
        retVal = (PendingIntent) response.obj;
        return (PendingIntent)dsTaint.getTaint();
        // ---------- Original Method ----------
        //PendingIntent retVal = (PendingIntent) response.obj;
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.012 -0400", hash_original_method = "D70777E4A1678D0EF0C2B7C3D53ADD58", hash_generated_method = "D07B05DEFEC084B06B10F7F7D0DC727E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PendingIntent getReconnectIntentSync() {
        Message response;
        response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        {
            log("getReconnectIntent ok");
            PendingIntent var67F8212F4417454253E87E757BFEC20B_592943352 = (rspReconnectIntent(response));
        } //End block
        {
            log("getReconnectIntent error response=" + response);
        } //End block
        return (PendingIntent)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:11.012 -0400", hash_original_method = "3340C70610FFA5D9D28FC6E77DE7CB0F", hash_generated_method = "A366AA531A04777A235EC5F68439AA9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void log(String s) {
        dsTaint.addTaint(s);
        android.util.Log.d(mLogTag, "DataConnectionAc " + s);
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

    
    private static final boolean DBG = false;
    public static final int BASE = Protocol.BASE_DATA_CONNECTION_AC;
    public static final int REQ_IS_INACTIVE = BASE + 0;
    public static final int RSP_IS_INACTIVE = BASE + 1;
    public static final int REQ_GET_CID = BASE + 2;
    public static final int RSP_GET_CID = BASE + 3;
    public static final int REQ_GET_APNSETTING = BASE + 4;
    public static final int RSP_GET_APNSETTING = BASE + 5;
    public static final int REQ_GET_LINK_PROPERTIES = BASE + 6;
    public static final int RSP_GET_LINK_PROPERTIES = BASE + 7;
    public static final int REQ_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 8;
    public static final int RSP_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 9;
    public static final int REQ_GET_LINK_CAPABILITIES = BASE + 10;
    public static final int RSP_GET_LINK_CAPABILITIES = BASE + 11;
    public static final int REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 12;
    public static final int RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 13;
    public static final int REQ_RESET = BASE + 14;
    public static final int RSP_RESET = BASE + 15;
    public static final int REQ_GET_REFCOUNT = BASE + 16;
    public static final int RSP_GET_REFCOUNT = BASE + 17;
    public static final int REQ_ADD_APNCONTEXT = BASE + 18;
    public static final int RSP_ADD_APNCONTEXT = BASE + 19;
    public static final int REQ_REMOVE_APNCONTEXT = BASE + 20;
    public static final int RSP_REMOVE_APNCONTEXT = BASE + 21;
    public static final int REQ_GET_APNCONTEXT_LIST = BASE + 22;
    public static final int RSP_GET_APNCONTEXT_LIST = BASE + 23;
    public static final int REQ_SET_RECONNECT_INTENT = BASE + 24;
    public static final int RSP_SET_RECONNECT_INTENT = BASE + 25;
    public static final int REQ_GET_RECONNECT_INTENT = BASE + 26;
    public static final int RSP_GET_RECONNECT_INTENT = BASE + 27;
}

