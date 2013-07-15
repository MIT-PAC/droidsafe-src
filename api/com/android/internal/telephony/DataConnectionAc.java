package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.422 -0400", hash_original_field = "503F6607C959C61B036C1484733875DB", hash_generated_field = "59F9615F1046A159253328ABFF9EBAC4")

    private String mLogTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.422 -0400", hash_original_field = "720D2EF97C9F7A0E2C3E644C6885F670", hash_generated_field = "4C14AF3C02F6F482DB5C38C18F17056F")

    public DataConnection dataConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.423 -0400", hash_original_method = "F4260E5BFAF2E10088BF39CBA8BFFFD2", hash_generated_method = "5A9866AB81164D05ED976FFB69238A22")
    public  DataConnectionAc(DataConnection dc, String logTag) {
        dataConnection = dc;
        mLogTag = logTag;
        // ---------- Original Method ----------
        //dataConnection = dc;
        //mLogTag = logTag;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.423 -0400", hash_original_method = "7AA2FA115BEA9C5CC0101E6522D85688", hash_generated_method = "9CBF6DC31CA306C429284D02147725A9")
    public void reqIsInactive() {
        sendMessage(REQ_IS_INACTIVE);
    if(DBG)        
        log("reqIsInactive");
        // ---------- Original Method ----------
        //sendMessage(REQ_IS_INACTIVE);
        //if (DBG) log("reqIsInactive");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.424 -0400", hash_original_method = "D508FA29014931CB6CD29F8DFC756262", hash_generated_method = "FC1DB4CAD9406ABA1028E9579BC07191")
    public boolean rspIsInactive(Message response) {
        addTaint(response.getTaint());
        boolean retVal = response.arg1 == 1;
    if(DBG)        
        log("rspIsInactive=" + retVal);
        boolean var1E6151782509B2C92750CFF962B742CD_1429845405 = (retVal);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_689613632 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_689613632;
        // ---------- Original Method ----------
        //boolean retVal = response.arg1 == 1;
        //if (DBG) log("rspIsInactive=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.424 -0400", hash_original_method = "5AFFFE1437681DAB31C247AD1B67F124", hash_generated_method = "86B3C3D35757939B95940A8C64ACE9F6")
    public boolean isInactiveSync() {
        Message response = sendMessageSynchronously(REQ_IS_INACTIVE);
    if((response != null) && (response.what == RSP_IS_INACTIVE))        
        {
            boolean varE4A24757A4A7005E41244B3A91788C69_583561453 = (rspIsInactive(response));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1859958811 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1859958811;
        } //End block
        else
        {
            log("rspIsInactive error response=" + response);
            boolean var68934A3E9455FA72420237EB05902327_724684015 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1417312476 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1417312476;
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_IS_INACTIVE);
        //if ((response != null) && (response.what == RSP_IS_INACTIVE)) {
            //return rspIsInactive(response);
        //} else {
            //log("rspIsInactive error response=" + response);
            //return false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.424 -0400", hash_original_method = "E08DB9A60755AA94EB60896D4764AF5C", hash_generated_method = "4726F544E23D26445A691CA09822A118")
    public void reqCid() {
        sendMessage(REQ_GET_CID);
    if(DBG)        
        log("reqCid");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_CID);
        //if (DBG) log("reqCid");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.425 -0400", hash_original_method = "FF57B3B0C583923138679674F4E2FE25", hash_generated_method = "EA4365608998F5C701A6A962CAFEEA90")
    public int rspCid(Message response) {
        addTaint(response.getTaint());
        int retVal = response.arg1;
    if(DBG)        
        log("rspCid=" + retVal);
        int var1E6151782509B2C92750CFF962B742CD_838204813 = (retVal);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521195405 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1521195405;
        // ---------- Original Method ----------
        //int retVal = response.arg1;
        //if (DBG) log("rspCid=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.425 -0400", hash_original_method = "88FA920EA2D54F9DC82F8A70E10A6416", hash_generated_method = "276E717EE56CE6235EB3FC0CB7AD4CA6")
    public int getCidSync() {
        Message response = sendMessageSynchronously(REQ_GET_CID);
    if((response != null) && (response.what == RSP_GET_CID))        
        {
            int varE7C4DF071847317C1DC5B0F326E8B307_1768362517 = (rspCid(response));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902127250 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1902127250;
        } //End block
        else
        {
            log("rspCid error response=" + response);
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1368579287 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630327088 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_630327088;
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_CID);
        //if ((response != null) && (response.what == RSP_GET_CID)) {
            //return rspCid(response);
        //} else {
            //log("rspCid error response=" + response);
            //return -1;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.425 -0400", hash_original_method = "5DBEE0C11260D4E2748BF847AE297C4B", hash_generated_method = "431F0B148F157282F6A4DF25F323D8FD")
    public void reqRefCount() {
        sendMessage(REQ_GET_REFCOUNT);
    if(DBG)        
        log("reqRefCount");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_REFCOUNT);
        //if (DBG) log("reqRefCount");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.426 -0400", hash_original_method = "AFE421B2404E9D3449EC1EC9B786EEAC", hash_generated_method = "79A91AE65C38D5D2F2F70D909A92608E")
    public int rspRefCount(Message response) {
        addTaint(response.getTaint());
        int retVal = response.arg1;
    if(DBG)        
        log("rspRefCount=" + retVal);
        int var1E6151782509B2C92750CFF962B742CD_1697097724 = (retVal);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432374643 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1432374643;
        // ---------- Original Method ----------
        //int retVal = response.arg1;
        //if (DBG) log("rspRefCount=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.426 -0400", hash_original_method = "82303217C6F0F47E549DB7B210318471", hash_generated_method = "4143CDA81F2F44E77AB0F18870408C20")
    public int getRefCountSync() {
        Message response = sendMessageSynchronously(REQ_GET_REFCOUNT);
    if((response != null) && (response.what == RSP_GET_REFCOUNT))        
        {
            int varDC92A1137FCE5F23CA78CFB1DF576BEF_1721657483 = (rspRefCount(response));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1710226584 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1710226584;
        } //End block
        else
        {
            log("rspRefCount error response=" + response);
            int var6BB61E3B7BCE0931DA574D19D1D82C88_1562965546 = (-1);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204665144 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1204665144;
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_REFCOUNT);
        //if ((response != null) && (response.what == RSP_GET_REFCOUNT)) {
            //return rspRefCount(response);
        //} else {
            //log("rspRefCount error response=" + response);
            //return -1;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.427 -0400", hash_original_method = "C0AE060C8D213182996CE9AFC0358CCA", hash_generated_method = "254C0843325875257689B17192621249")
    public void reqApnSetting() {
        sendMessage(REQ_GET_APNSETTING);
    if(DBG)        
        log("reqApnSetting");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_APNSETTING);
        //if (DBG) log("reqApnSetting");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.427 -0400", hash_original_method = "95D7FBD84C6C38BA2D84311C3C9BEF51", hash_generated_method = "5181957B7D94C0B172514816E01BA0E7")
    public ApnSetting rspApnSetting(Message response) {
        addTaint(response.getTaint());
        ApnSetting retVal = (ApnSetting) response.obj;
    if(DBG)        
        log("rspApnSetting=" + retVal);
ApnSetting var906583DF257E5B26DD99AC8582D137B0_1823855377 =         retVal;
        var906583DF257E5B26DD99AC8582D137B0_1823855377.addTaint(taint);
        return var906583DF257E5B26DD99AC8582D137B0_1823855377;
        // ---------- Original Method ----------
        //ApnSetting retVal = (ApnSetting) response.obj;
        //if (DBG) log("rspApnSetting=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.428 -0400", hash_original_method = "DD32FEB19DC77901F346EA49C4C70BF1", hash_generated_method = "42E71AAA7B93DB78BAAE62066FCF16F9")
    public ApnSetting getApnSettingSync() {
        Message response = sendMessageSynchronously(REQ_GET_APNSETTING);
    if((response != null) && (response.what == RSP_GET_APNSETTING))        
        {
ApnSetting var68363292812822BB3936049C42BCC748_768169796 =             rspApnSetting(response);
            var68363292812822BB3936049C42BCC748_768169796.addTaint(taint);
            return var68363292812822BB3936049C42BCC748_768169796;
        } //End block
        else
        {
            log("getApnSetting error response=" + response);
ApnSetting var540C13E9E156B687226421B24F2DF178_370495786 =             null;
            var540C13E9E156B687226421B24F2DF178_370495786.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_370495786;
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_APNSETTING);
        //if ((response != null) && (response.what == RSP_GET_APNSETTING)) {
            //return rspApnSetting(response);
        //} else {
            //log("getApnSetting error response=" + response);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.429 -0400", hash_original_method = "5D3EF8F8C1412EBC1BE098FA3C540E84", hash_generated_method = "10D2B27469209AAAB47BB68B4987AF29")
    public void reqLinkProperties() {
        sendMessage(REQ_GET_LINK_PROPERTIES);
    if(DBG)        
        log("reqLinkProperties");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_LINK_PROPERTIES);
        //if (DBG) log("reqLinkProperties");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.429 -0400", hash_original_method = "61AC833B412EB853D23C85E2B80FFC12", hash_generated_method = "98B26073D0CC790E0E590639581926E7")
    public LinkProperties rspLinkProperties(Message response) {
        addTaint(response.getTaint());
        LinkProperties retVal = (LinkProperties) response.obj;
    if(DBG)        
        log("rspLinkProperties=" + retVal);
LinkProperties var906583DF257E5B26DD99AC8582D137B0_2118799705 =         retVal;
        var906583DF257E5B26DD99AC8582D137B0_2118799705.addTaint(taint);
        return var906583DF257E5B26DD99AC8582D137B0_2118799705;
        // ---------- Original Method ----------
        //LinkProperties retVal = (LinkProperties) response.obj;
        //if (DBG) log("rspLinkProperties=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.430 -0400", hash_original_method = "3F7712F482B5EE0C4EC3A4DBA0BA8D32", hash_generated_method = "353F397290F7040B363D5EDCFDE3F65B")
    public LinkProperties getLinkPropertiesSync() {
        Message response = sendMessageSynchronously(REQ_GET_LINK_PROPERTIES);
    if((response != null) && (response.what == RSP_GET_LINK_PROPERTIES))        
        {
LinkProperties varAF8C4A11AC5A212E634D72BCA7FACB23_83824764 =             rspLinkProperties(response);
            varAF8C4A11AC5A212E634D72BCA7FACB23_83824764.addTaint(taint);
            return varAF8C4A11AC5A212E634D72BCA7FACB23_83824764;
        } //End block
        else
        {
            log("getLinkProperties error response=" + response);
LinkProperties var540C13E9E156B687226421B24F2DF178_143418299 =             null;
            var540C13E9E156B687226421B24F2DF178_143418299.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_143418299;
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_LINK_PROPERTIES);
        //if ((response != null) && (response.what == RSP_GET_LINK_PROPERTIES)) {
            //return rspLinkProperties(response);
        //} else {
            //log("getLinkProperties error response=" + response);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.430 -0400", hash_original_method = "52664ABA5522CB5FFA9E0304A7C81F50", hash_generated_method = "0FD2E382BDDD9AE407A7694F720C2109")
    public void reqSetLinkPropertiesHttpProxy(ProxyProperties proxy) {
        addTaint(proxy.getTaint());
        sendMessage(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
    if(DBG)        
        log("reqSetLinkPropertiesHttpProxy proxy=" + proxy);
        // ---------- Original Method ----------
        //sendMessage(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        //if (DBG) log("reqSetLinkPropertiesHttpProxy proxy=" + proxy);
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.431 -0400", hash_original_method = "71F35538546E3DD45C021DEA145F6AFD", hash_generated_method = "2938BD44633207DF741AA7490C5F4336")
    public void setLinkPropertiesHttpProxySync(ProxyProperties proxy) {
        addTaint(proxy.getTaint());
        Message response = sendMessageSynchronously(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
    if((response != null) && (response.what == RSP_SET_LINK_PROPERTIES_HTTP_PROXY))        
        {
    if(DBG)            
            log("setLinkPropertiesHttpPoxy ok");
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.431 -0400", hash_original_method = "1137FFCD79265DC595F1B5AA40674EF5", hash_generated_method = "CC425A18F7232BAB6867ADBFD4E18DED")
    public void reqUpdateLinkPropertiesDataCallState(DataCallState newState) {
        addTaint(newState.getTaint());
        sendMessage(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
    if(DBG)        
        log("reqUpdateLinkPropertiesDataCallState");
        // ---------- Original Method ----------
        //sendMessage(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        //if (DBG) log("reqUpdateLinkPropertiesDataCallState");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.431 -0400", hash_original_method = "FF09E9AE970C8576F47A284FF7FFCA6D", hash_generated_method = "9CFC74AF8AD0312D7E185C9B9AA8E282")
    public UpdateLinkPropertyResult rspUpdateLinkPropertiesDataCallState(Message response) {
        addTaint(response.getTaint());
        UpdateLinkPropertyResult retVal = (UpdateLinkPropertyResult)response.obj;
    if(DBG)        
        log("rspUpdateLinkPropertiesState: retVal=" + retVal);
UpdateLinkPropertyResult var906583DF257E5B26DD99AC8582D137B0_2098174443 =         retVal;
        var906583DF257E5B26DD99AC8582D137B0_2098174443.addTaint(taint);
        return var906583DF257E5B26DD99AC8582D137B0_2098174443;
        // ---------- Original Method ----------
        //UpdateLinkPropertyResult retVal = (UpdateLinkPropertyResult)response.obj;
        //if (DBG) log("rspUpdateLinkPropertiesState: retVal=" + retVal);
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.432 -0400", hash_original_method = "98F59EFFB83342DD2236B59D91A5E4B5", hash_generated_method = "1C999303F800CD1018B427EF426A23DB")
    public UpdateLinkPropertyResult updateLinkPropertiesDataCallStateSync(DataCallState newState) {
        addTaint(newState.getTaint());
        Message response = sendMessageSynchronously(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
    if((response != null) &&
            (response.what == RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE))        
        {
UpdateLinkPropertyResult varA641E5C6710D96B5E3E6998AB7728A22_1110437047 =             rspUpdateLinkPropertiesDataCallState(response);
            varA641E5C6710D96B5E3E6998AB7728A22_1110437047.addTaint(taint);
            return varA641E5C6710D96B5E3E6998AB7728A22_1110437047;
        } //End block
        else
        {
            log("getLinkProperties error response=" + response);
UpdateLinkPropertyResult var705B5710E3C3DA3E1BF96D2C3612E3E7_1093209701 =             new UpdateLinkPropertyResult(new LinkProperties());
            var705B5710E3C3DA3E1BF96D2C3612E3E7_1093209701.addTaint(taint);
            return var705B5710E3C3DA3E1BF96D2C3612E3E7_1093209701;
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.432 -0400", hash_original_method = "30D60C86BD34D11FA73E7C7E67CFC7AA", hash_generated_method = "D4F531D4955CFF6D8770B0B4B5F6FCF5")
    public void reqLinkCapabilities() {
        sendMessage(REQ_GET_LINK_CAPABILITIES);
    if(DBG)        
        log("reqLinkCapabilities");
        // ---------- Original Method ----------
        //sendMessage(REQ_GET_LINK_CAPABILITIES);
        //if (DBG) log("reqLinkCapabilities");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.433 -0400", hash_original_method = "F187911F3801DAE69287AC09EDB743FA", hash_generated_method = "5B49E1B180813D5A727D8B764420A0F0")
    public LinkCapabilities rspLinkCapabilities(Message response) {
        addTaint(response.getTaint());
        LinkCapabilities retVal = (LinkCapabilities) response.obj;
    if(DBG)        
        log("rspLinkCapabilities=" + retVal);
LinkCapabilities var906583DF257E5B26DD99AC8582D137B0_593644622 =         retVal;
        var906583DF257E5B26DD99AC8582D137B0_593644622.addTaint(taint);
        return var906583DF257E5B26DD99AC8582D137B0_593644622;
        // ---------- Original Method ----------
        //LinkCapabilities retVal = (LinkCapabilities) response.obj;
        //if (DBG) log("rspLinkCapabilities=" + retVal);
        //return retVal;
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.433 -0400", hash_original_method = "C1F7B964512DA39EF105AA8C4B5198E6", hash_generated_method = "5DAD8B0E9B8774A1F7B82A5CFE34ED20")
    public LinkCapabilities getLinkCapabilitiesSync() {
        Message response = sendMessageSynchronously(REQ_GET_LINK_CAPABILITIES);
    if((response != null) && (response.what == RSP_GET_LINK_CAPABILITIES))        
        {
LinkCapabilities var8FD28919A2834F86012562434B04C052_2016425556 =             rspLinkCapabilities(response);
            var8FD28919A2834F86012562434B04C052_2016425556.addTaint(taint);
            return var8FD28919A2834F86012562434B04C052_2016425556;
        } //End block
        else
        {
            log("getLinkCapabilities error response=" + response);
LinkCapabilities var540C13E9E156B687226421B24F2DF178_1377037453 =             null;
            var540C13E9E156B687226421B24F2DF178_1377037453.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1377037453;
        } //End block
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_LINK_CAPABILITIES);
        //if ((response != null) && (response.what == RSP_GET_LINK_CAPABILITIES)) {
            //return rspLinkCapabilities(response);
        //} else {
            //log("getLinkCapabilities error response=" + response);
            //return null;
        //}
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.434 -0400", hash_original_method = "9EFFE3DDD73E4A7AC997D7CA04936F41", hash_generated_method = "965E6733CE5021911266CF7CA6477732")
    public void reqReset() {
        sendMessage(REQ_RESET);
    if(DBG)        
        log("reqReset");
        // ---------- Original Method ----------
        //sendMessage(REQ_RESET);
        //if (DBG) log("reqReset");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.434 -0400", hash_original_method = "C179D3525D5003A50B8C9C0361938568", hash_generated_method = "746688ABF6FF04EB844E4EFF378A08D1")
    public void resetSync() {
        Message response = sendMessageSynchronously(REQ_RESET);
    if((response != null) && (response.what == RSP_RESET))        
        {
    if(DBG)            
            log("restSync ok");
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.434 -0400", hash_original_method = "F3233E69134CF9902E31FB14516EC03E", hash_generated_method = "93772BCF4BFB3B144A5006936E3AC304")
    public void reqAddApnContext(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
    if(DBG)        
        log("reqAddApnContext");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        //if (DBG) log("reqAddApnContext");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.435 -0400", hash_original_method = "29B8FEA7830E2BBE9C7BBFD69E48646E", hash_generated_method = "24EEA55381AF2B10370FB7DCEC97B02B")
    public void addApnContextSync(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
    if((response != null) && (response.what == RSP_ADD_APNCONTEXT))        
        {
    if(DBG)            
            log("addApnContext ok");
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.435 -0400", hash_original_method = "51B2CCF2735E77C63E82DEC17109A5B1", hash_generated_method = "621DB6C5909D4C54DB183B82ACDFB535")
    public void reqRemomveApnContext(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
    if(DBG)        
        log("reqRemomveApnContext");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        //if (DBG) log("reqRemomveApnContext");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.435 -0400", hash_original_method = "62E31991C2E3FEB9590AC2302F444FDA", hash_generated_method = "875456AD58B5281A2CA5066A5B655E71")
    public void removeApnContextSync(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
    if((response != null) && (response.what == RSP_REMOVE_APNCONTEXT))        
        {
    if(DBG)            
            log("removeApnContext ok");
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.436 -0400", hash_original_method = "AAD200E4835E6912540E5A2C7F9552F9", hash_generated_method = "4504103463BE740F8BE6643EF4557CCB")
    public void reqGetApnList(ApnContext apnContext) {
        addTaint(apnContext.getTaint());
        Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
    if(DBG)        
        log("reqGetApnList");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        //if (DBG) log("reqGetApnList");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.436 -0400", hash_original_method = "48ABE9510A7CA4042FB5B96D41BACEB8", hash_generated_method = "3186E5F1A53188C7DFBCFFBE7DEB5663")
    public Collection<ApnContext> rspApnList(Message response) {
        addTaint(response.getTaint());
        Collection<ApnContext> retVal = (Collection<ApnContext>)response.obj;
    if(retVal == null)        
        retVal = new ArrayList<ApnContext>();
Collection<ApnContext> var906583DF257E5B26DD99AC8582D137B0_1362196738 =         retVal;
        var906583DF257E5B26DD99AC8582D137B0_1362196738.addTaint(taint);
        return var906583DF257E5B26DD99AC8582D137B0_1362196738;
        // ---------- Original Method ----------
        //Collection<ApnContext> retVal = (Collection<ApnContext>)response.obj;
        //if (retVal == null) retVal = new ArrayList<ApnContext>();
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.436 -0400", hash_original_method = "498EAD8B319A2A3996C6AC846ACD4BE2", hash_generated_method = "914A43FE3A705ED0E49E2B17C54F9B99")
    public Collection<ApnContext> getApnListSync() {
        Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
    if((response != null) && (response.what == RSP_GET_APNCONTEXT_LIST))        
        {
    if(DBG)            
            log("getApnList ok");
Collection<ApnContext> var276E16B39246B293D010CA134207AE5E_80510315 =             rspApnList(response);
            var276E16B39246B293D010CA134207AE5E_80510315.addTaint(taint);
            return var276E16B39246B293D010CA134207AE5E_80510315;
        } //End block
        else
        {
            log("getApnList error response=" + response);
Collection<ApnContext> var1AAB482EE4DBE9E61066979E07ECDC94_901636781 =             new ArrayList<ApnContext>();
            var1AAB482EE4DBE9E61066979E07ECDC94_901636781.addTaint(taint);
            return var1AAB482EE4DBE9E61066979E07ECDC94_901636781;
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.437 -0400", hash_original_method = "408D11B7A3DFC98C0728A70ED62F0EEA", hash_generated_method = "7331C6C43628B2DEFE0F489940CBE958")
    public void reqSetReconnectIntent(PendingIntent intent) {
        addTaint(intent.getTaint());
        Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
    if(DBG)        
        log("reqSetReconnectIntent");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        //if (DBG) log("reqSetReconnectIntent");
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.437 -0400", hash_original_method = "D99BC1BEF330D90F2BC64CDBA6E6105B", hash_generated_method = "28BA9FE14A123BA0D5A32158994B7644")
    public void setReconnectIntentSync(PendingIntent intent) {
        addTaint(intent.getTaint());
        Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
    if((response != null) && (response.what == RSP_SET_RECONNECT_INTENT))        
        {
    if(DBG)            
            log("setReconnectIntent ok");
        } //End block
        else
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.437 -0400", hash_original_method = "3F955D64051D380D89135CF7B70C1F05", hash_generated_method = "55CD94C30D42F73DB678447F20978650")
    public void reqGetReconnectIntent() {
        Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
    if(DBG)        
        log("reqGetReconnectIntent");
        // ---------- Original Method ----------
        //Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        //if (DBG) log("reqGetReconnectIntent");
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.438 -0400", hash_original_method = "9555B3D0DB27D43CC0B0BA451DA1A9D5", hash_generated_method = "C91593E2BEFDF4BC059CD55053E298BC")
    public PendingIntent rspReconnectIntent(Message response) {
        addTaint(response.getTaint());
        PendingIntent retVal = (PendingIntent) response.obj;
PendingIntent var906583DF257E5B26DD99AC8582D137B0_1582625863 =         retVal;
        var906583DF257E5B26DD99AC8582D137B0_1582625863.addTaint(taint);
        return var906583DF257E5B26DD99AC8582D137B0_1582625863;
        // ---------- Original Method ----------
        //PendingIntent retVal = (PendingIntent) response.obj;
        //return retVal;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.438 -0400", hash_original_method = "D70777E4A1678D0EF0C2B7C3D53ADD58", hash_generated_method = "B6EEBAFC11A250116163B20C588C9C18")
    public PendingIntent getReconnectIntentSync() {
        Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
    if((response != null) && (response.what == RSP_GET_RECONNECT_INTENT))        
        {
    if(DBG)            
            log("getReconnectIntent ok");
PendingIntent var27338765CFC102E229AB027D2CF8ABE9_952846428 =             rspReconnectIntent(response);
            var27338765CFC102E229AB027D2CF8ABE9_952846428.addTaint(taint);
            return var27338765CFC102E229AB027D2CF8ABE9_952846428;
        } //End block
        else
        {
            log("getReconnectIntent error response=" + response);
PendingIntent var540C13E9E156B687226421B24F2DF178_1515707116 =             null;
            var540C13E9E156B687226421B24F2DF178_1515707116.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_1515707116;
        } //End block
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

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.438 -0400", hash_original_method = "3340C70610FFA5D9D28FC6E77DE7CB0F", hash_generated_method = "03146726C72A54D3150569648E131B16")
    private void log(String s) {
        addTaint(s.getTaint());
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "06E844B888ED9045894B2B8636373495", hash_generated_field = "6BCB0AA355104F156D0A2B3A91BB070E")

    public static final int BASE = Protocol.BASE_DATA_CONNECTION_AC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "EADBD9ECE62C98E1D8E918128B3CA096", hash_generated_field = "1475D2F355264F68EEAD5DE0DC64E4C1")

    public static final int REQ_IS_INACTIVE = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "1B158D124EED34F8B028A91607C881D2", hash_generated_field = "4EF0EE195500EDBC396F404FB857CFCE")

    public static final int RSP_IS_INACTIVE = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "D8F3245683A6ECB00974E58E4A8A6249", hash_generated_field = "100ADE81533B5A145526EE17F8BCF7F6")

    public static final int REQ_GET_CID = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "F6D68F5B120AFF550917C4B5568E2EAB", hash_generated_field = "4AADBE311B5CBD53B22C258FD0BC5894")

    public static final int RSP_GET_CID = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "451E9EC325AB2136FBF344263AC13FB4", hash_generated_field = "4556E2B1BBE8565148BB1897F4F1FFF2")

    public static final int REQ_GET_APNSETTING = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "67C1D26E2877CD8726F9AC202269D341", hash_generated_field = "075D97CF7AE01BA14B82937FAB85E17C")

    public static final int RSP_GET_APNSETTING = BASE + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "44E8E021E38F9F4957C80CC8005AF125", hash_generated_field = "6B2177B63C14A3D8C4A0465DF7EDA57B")

    public static final int REQ_GET_LINK_PROPERTIES = BASE + 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "500C1AC91FB838581568984E44550968", hash_generated_field = "B073222C67C8387DA84D52E09C649C5B")

    public static final int RSP_GET_LINK_PROPERTIES = BASE + 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "2BF1A9BBA19C9A658F6D0B42DAED1E41", hash_generated_field = "AA7EDD6DEA7FBE6E6DEDC341AE2566AA")

    public static final int REQ_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "9DFC37643183DE61DD9F1BC7337883B3", hash_generated_field = "2BD71056213661FD69459E151EB320F2")

    public static final int RSP_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "065018769EB6CC7F7373CA6BED8F7643", hash_generated_field = "42BC94DC23936D5550B2F12E94B801F3")

    public static final int REQ_GET_LINK_CAPABILITIES = BASE + 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "9F9D88D4A8B28546FEE157032AC8B70A", hash_generated_field = "7C871C282AED07B5AFD51BB60DC58B87")

    public static final int RSP_GET_LINK_CAPABILITIES = BASE + 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "16010B85948823BF66211764D7B5283B", hash_generated_field = "410DC65F191E667E05E1C26996344ED6")

    public static final int REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.439 -0400", hash_original_field = "3DD80A27FF8D61C2D2E8816651BAC0E4", hash_generated_field = "EABD1A19ECDA7C315E74E3BB10C8AA34")

    public static final int RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "F6491F3C8DCD8733232690FB3896BF47", hash_generated_field = "FA6D9E30AD45F04695E898045922860A")

    public static final int REQ_RESET = BASE + 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "CF1337BD01D40550D657AF71D5457B15", hash_generated_field = "669F769EC139E98CB3AFB220D6A1C9FE")

    public static final int RSP_RESET = BASE + 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "C3E5268DDA9CBD4AD8CA1F06BAC6941B", hash_generated_field = "76D19A23EEE2DE297833D58F70073A84")

    public static final int REQ_GET_REFCOUNT = BASE + 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "E6E62475054FEEC765CEF64603D3A70D", hash_generated_field = "BD8C38909076EDBB350F0534D3158B5A")

    public static final int RSP_GET_REFCOUNT = BASE + 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "2E82E5CB120F76BE1E9AABB7166660B5", hash_generated_field = "8F3EC990CEC19BF924C0C83E473DF703")

    public static final int REQ_ADD_APNCONTEXT = BASE + 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "5FFC50DC4F0DF7544490909AD3D8DB3D", hash_generated_field = "D05330977465F7AF4E384E150213096A")

    public static final int RSP_ADD_APNCONTEXT = BASE + 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "86AFFBEDA03B70DE11F7AFE2EE19B988", hash_generated_field = "FC2140507E1C1E4A862E984C6536D33F")

    public static final int REQ_REMOVE_APNCONTEXT = BASE + 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "452A4337B6E6F3036095C684213134BF", hash_generated_field = "F6C5D6966EFACD969BB347661AD8098A")

    public static final int RSP_REMOVE_APNCONTEXT = BASE + 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "842D49F350462A667AD2590CE93489B0", hash_generated_field = "7CADBAFCB6C4D553E00439A92A77399A")

    public static final int REQ_GET_APNCONTEXT_LIST = BASE + 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "63393ADC62ADB8086F1A9106D4DA73F7", hash_generated_field = "08CEE76E523CBFA9615E63AE42E97282")

    public static final int RSP_GET_APNCONTEXT_LIST = BASE + 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "F83139694F8C75C29041CAD82805FBC0", hash_generated_field = "AEDC94BDC63CFCBD1EE247E113E0B2BD")

    public static final int REQ_SET_RECONNECT_INTENT = BASE + 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "1A21029CD633D0CA53EB46E887F9DCE0", hash_generated_field = "50977DA17634FA6287626111506AF1F5")

    public static final int RSP_SET_RECONNECT_INTENT = BASE + 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "E9DEE9E0E0EB4253C7E41D3E57891BB2", hash_generated_field = "E050F9150348EB87E92AA17BEF7AA6F1")

    public static final int REQ_GET_RECONNECT_INTENT = BASE + 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.440 -0400", hash_original_field = "9440C9722A4FB872C7E1976D00F575DE", hash_generated_field = "B47C4AB7C8CEFA3E66A64CE4AF15F148")

    public static final int RSP_GET_RECONNECT_INTENT = BASE + 27;
}

