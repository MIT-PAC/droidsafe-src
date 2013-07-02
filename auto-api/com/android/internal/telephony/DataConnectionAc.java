package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.818 -0400", hash_original_field = "503F6607C959C61B036C1484733875DB", hash_generated_field = "59F9615F1046A159253328ABFF9EBAC4")

    private String mLogTag;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.818 -0400", hash_original_field = "720D2EF97C9F7A0E2C3E644C6885F670", hash_generated_field = "4C14AF3C02F6F482DB5C38C18F17056F")

    public DataConnection dataConnection;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.818 -0400", hash_original_method = "F4260E5BFAF2E10088BF39CBA8BFFFD2", hash_generated_method = "5A9866AB81164D05ED976FFB69238A22")
    public  DataConnectionAc(DataConnection dc, String logTag) {
        dataConnection = dc;
        mLogTag = logTag;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.819 -0400", hash_original_method = "7AA2FA115BEA9C5CC0101E6522D85688", hash_generated_method = "06A43CBE1CF0CF8AC615D6BA7631300A")
    public void reqIsInactive() {
        sendMessage(REQ_IS_INACTIVE);
        log("reqIsInactive");
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.819 -0400", hash_original_method = "D508FA29014931CB6CD29F8DFC756262", hash_generated_method = "C73B53CBCE8350E9D3DB2870D165D9B4")
    public boolean rspIsInactive(Message response) {
        boolean retVal = response.arg1 == 1;
        log("rspIsInactive=" + retVal);
        addTaint(response.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1028680611 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1028680611;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.819 -0400", hash_original_method = "5AFFFE1437681DAB31C247AD1B67F124", hash_generated_method = "DD778276246A4191279A392616AA89A2")
    public boolean isInactiveSync() {
        Message response = sendMessageSynchronously(REQ_IS_INACTIVE);
        {
            boolean varB650A8A0D8B84B48BF0F9C39C1DE2524_1728597508 = (rspIsInactive(response));
        } 
        {
            log("rspIsInactive error response=" + response);
        } 
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1520804867 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1520804867;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.819 -0400", hash_original_method = "E08DB9A60755AA94EB60896D4764AF5C", hash_generated_method = "557616FCF19CD91ECB6E61EE90498318")
    public void reqCid() {
        sendMessage(REQ_GET_CID);
        log("reqCid");
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.820 -0400", hash_original_method = "FF57B3B0C583923138679674F4E2FE25", hash_generated_method = "3D5B4A8F93A55076C14DCA5EFA5AC530")
    public int rspCid(Message response) {
        int retVal = response.arg1;
        log("rspCid=" + retVal);
        addTaint(response.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027548797 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1027548797;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.820 -0400", hash_original_method = "88FA920EA2D54F9DC82F8A70E10A6416", hash_generated_method = "0363C4DA1D8F169CD6A2518F76DCEC25")
    public int getCidSync() {
        Message response = sendMessageSynchronously(REQ_GET_CID);
        {
            int var7557B1255F3B12D5499A8699601A416F_1073571086 = (rspCid(response));
        } 
        {
            log("rspCid error response=" + response);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619879592 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1619879592;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.820 -0400", hash_original_method = "5DBEE0C11260D4E2748BF847AE297C4B", hash_generated_method = "D22C34A9299A9E2EE473346D17E2A164")
    public void reqRefCount() {
        sendMessage(REQ_GET_REFCOUNT);
        log("reqRefCount");
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.821 -0400", hash_original_method = "AFE421B2404E9D3449EC1EC9B786EEAC", hash_generated_method = "6BB4CA4DE3B6A02BBB60EFE5CC6B7D0F")
    public int rspRefCount(Message response) {
        int retVal = response.arg1;
        log("rspRefCount=" + retVal);
        addTaint(response.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886097933 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1886097933;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.821 -0400", hash_original_method = "82303217C6F0F47E549DB7B210318471", hash_generated_method = "B08CF1D368A9B047E65090D0895C0327")
    public int getRefCountSync() {
        Message response = sendMessageSynchronously(REQ_GET_REFCOUNT);
        {
            int var033F6520642A731301C2957B189A4CDB_1196169444 = (rspRefCount(response));
        } 
        {
            log("rspRefCount error response=" + response);
        } 
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053921853 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2053921853;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.822 -0400", hash_original_method = "C0AE060C8D213182996CE9AFC0358CCA", hash_generated_method = "1FB552CFFE6038744D13FCBC1CB17101")
    public void reqApnSetting() {
        sendMessage(REQ_GET_APNSETTING);
        log("reqApnSetting");
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.823 -0400", hash_original_method = "95D7FBD84C6C38BA2D84311C3C9BEF51", hash_generated_method = "0391E6BD1613D59F451C8E3690B5DC41")
    public ApnSetting rspApnSetting(Message response) {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_866852571 = null; 
        ApnSetting retVal = (ApnSetting) response.obj;
        log("rspApnSetting=" + retVal);
        varB4EAC82CA7396A68D541C85D26508E83_866852571 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_866852571.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_866852571;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.823 -0400", hash_original_method = "DD32FEB19DC77901F346EA49C4C70BF1", hash_generated_method = "9347CA73612EFEFCB6E5A70C9E0425B7")
    public ApnSetting getApnSettingSync() {
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_1667845158 = null; 
        ApnSetting varB4EAC82CA7396A68D541C85D26508E83_440542319 = null; 
        Message response = sendMessageSynchronously(REQ_GET_APNSETTING);
        {
            varB4EAC82CA7396A68D541C85D26508E83_1667845158 = rspApnSetting(response);
        } 
        {
            log("getApnSetting error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_440542319 = null;
        } 
        ApnSetting varA7E53CE21691AB073D9660D615818899_1193399784; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1193399784 = varB4EAC82CA7396A68D541C85D26508E83_1667845158;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1193399784 = varB4EAC82CA7396A68D541C85D26508E83_440542319;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1193399784.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1193399784;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.824 -0400", hash_original_method = "5D3EF8F8C1412EBC1BE098FA3C540E84", hash_generated_method = "FC504B42BD36F0CBDDACE97BA09C0C94")
    public void reqLinkProperties() {
        sendMessage(REQ_GET_LINK_PROPERTIES);
        log("reqLinkProperties");
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.824 -0400", hash_original_method = "61AC833B412EB853D23C85E2B80FFC12", hash_generated_method = "BD01DE614065EA6AFCDC315C36723C95")
    public LinkProperties rspLinkProperties(Message response) {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1689631426 = null; 
        LinkProperties retVal = (LinkProperties) response.obj;
        log("rspLinkProperties=" + retVal);
        varB4EAC82CA7396A68D541C85D26508E83_1689631426 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1689631426.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1689631426;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.825 -0400", hash_original_method = "3F7712F482B5EE0C4EC3A4DBA0BA8D32", hash_generated_method = "AD6B5722FC58E0C57BE6E5A1533C8F39")
    public LinkProperties getLinkPropertiesSync() {
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_682391241 = null; 
        LinkProperties varB4EAC82CA7396A68D541C85D26508E83_1956926201 = null; 
        Message response = sendMessageSynchronously(REQ_GET_LINK_PROPERTIES);
        {
            varB4EAC82CA7396A68D541C85D26508E83_682391241 = rspLinkProperties(response);
        } 
        {
            log("getLinkProperties error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_1956926201 = null;
        } 
        LinkProperties varA7E53CE21691AB073D9660D615818899_1063385986; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1063385986 = varB4EAC82CA7396A68D541C85D26508E83_682391241;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1063385986 = varB4EAC82CA7396A68D541C85D26508E83_1956926201;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1063385986.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1063385986;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.825 -0400", hash_original_method = "52664ABA5522CB5FFA9E0304A7C81F50", hash_generated_method = "819B95639F22B38F6028E968178C3194")
    public void reqSetLinkPropertiesHttpProxy(ProxyProperties proxy) {
        sendMessage(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        log("reqSetLinkPropertiesHttpProxy proxy=" + proxy);
        addTaint(proxy.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.825 -0400", hash_original_method = "71F35538546E3DD45C021DEA145F6AFD", hash_generated_method = "D8327C404DC3AE249E122F6AD0A8E75B")
    public void setLinkPropertiesHttpProxySync(ProxyProperties proxy) {
        Message response = sendMessageSynchronously(REQ_SET_LINK_PROPERTIES_HTTP_PROXY, proxy);
        {
            log("setLinkPropertiesHttpPoxy ok");
        } 
        {
            log("setLinkPropertiesHttpPoxy error response=" + response);
        } 
        addTaint(proxy.getTaint());
        
        
            
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.826 -0400", hash_original_method = "1137FFCD79265DC595F1B5AA40674EF5", hash_generated_method = "3C2CB583023F436EE2C2DE0950AA0DB4")
    public void reqUpdateLinkPropertiesDataCallState(DataCallState newState) {
        sendMessage(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        log("reqUpdateLinkPropertiesDataCallState");
        addTaint(newState.getTaint());
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.826 -0400", hash_original_method = "FF09E9AE970C8576F47A284FF7FFCA6D", hash_generated_method = "3550779B69419F5DBD65D89087E7396C")
    public UpdateLinkPropertyResult rspUpdateLinkPropertiesDataCallState(Message response) {
        UpdateLinkPropertyResult varB4EAC82CA7396A68D541C85D26508E83_585844325 = null; 
        UpdateLinkPropertyResult retVal = (UpdateLinkPropertyResult)response.obj;
        log("rspUpdateLinkPropertiesState: retVal=" + retVal);
        varB4EAC82CA7396A68D541C85D26508E83_585844325 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_585844325.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_585844325;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.827 -0400", hash_original_method = "98F59EFFB83342DD2236B59D91A5E4B5", hash_generated_method = "0B416AEFC31358F502A308AAE0BC52C6")
    public UpdateLinkPropertyResult updateLinkPropertiesDataCallStateSync(DataCallState newState) {
        UpdateLinkPropertyResult varB4EAC82CA7396A68D541C85D26508E83_824841122 = null; 
        UpdateLinkPropertyResult varB4EAC82CA7396A68D541C85D26508E83_680522176 = null; 
        Message response = sendMessageSynchronously(REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE, newState);
        {
            varB4EAC82CA7396A68D541C85D26508E83_824841122 = rspUpdateLinkPropertiesDataCallState(response);
        } 
        {
            log("getLinkProperties error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_680522176 = new UpdateLinkPropertyResult(new LinkProperties());
        } 
        addTaint(newState.getTaint());
        UpdateLinkPropertyResult varA7E53CE21691AB073D9660D615818899_365301242; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_365301242 = varB4EAC82CA7396A68D541C85D26508E83_824841122;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_365301242 = varB4EAC82CA7396A68D541C85D26508E83_680522176;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_365301242.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_365301242;
        
        
            
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.827 -0400", hash_original_method = "30D60C86BD34D11FA73E7C7E67CFC7AA", hash_generated_method = "34EE40AB35A64D7C1AF90878970AB648")
    public void reqLinkCapabilities() {
        sendMessage(REQ_GET_LINK_CAPABILITIES);
        log("reqLinkCapabilities");
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.828 -0400", hash_original_method = "F187911F3801DAE69287AC09EDB743FA", hash_generated_method = "3A06F51CB2F85B91E105DA0551121344")
    public LinkCapabilities rspLinkCapabilities(Message response) {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_1261503501 = null; 
        LinkCapabilities retVal = (LinkCapabilities) response.obj;
        log("rspLinkCapabilities=" + retVal);
        varB4EAC82CA7396A68D541C85D26508E83_1261503501 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1261503501.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1261503501;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.829 -0400", hash_original_method = "C1F7B964512DA39EF105AA8C4B5198E6", hash_generated_method = "4A2B72DBB9B4056E676D280726E0AADA")
    public LinkCapabilities getLinkCapabilitiesSync() {
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_663455079 = null; 
        LinkCapabilities varB4EAC82CA7396A68D541C85D26508E83_390566598 = null; 
        Message response = sendMessageSynchronously(REQ_GET_LINK_CAPABILITIES);
        {
            varB4EAC82CA7396A68D541C85D26508E83_663455079 = rspLinkCapabilities(response);
        } 
        {
            log("getLinkCapabilities error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_390566598 = null;
        } 
        LinkCapabilities varA7E53CE21691AB073D9660D615818899_1336883183; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1336883183 = varB4EAC82CA7396A68D541C85D26508E83_663455079;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1336883183 = varB4EAC82CA7396A68D541C85D26508E83_390566598;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1336883183.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1336883183;
        
        
        
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.829 -0400", hash_original_method = "9EFFE3DDD73E4A7AC997D7CA04936F41", hash_generated_method = "0A25D7986DDF3BF45A5E023040AD0D2A")
    public void reqReset() {
        sendMessage(REQ_RESET);
        log("reqReset");
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.830 -0400", hash_original_method = "C179D3525D5003A50B8C9C0361938568", hash_generated_method = "3F523BD8702CDE146AD4EEE29B038FC1")
    public void resetSync() {
        Message response = sendMessageSynchronously(REQ_RESET);
        {
            log("restSync ok");
        } 
        {
            log("restSync error response=" + response);
        } 
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.830 -0400", hash_original_method = "F3233E69134CF9902E31FB14516EC03E", hash_generated_method = "AE6153BD72816C38E9959DBE4B52B3A6")
    public void reqAddApnContext(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        log("reqAddApnContext");
        addTaint(apnContext.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.831 -0400", hash_original_method = "29B8FEA7830E2BBE9C7BBFD69E48646E", hash_generated_method = "5F4FCFE4CB69B7C84A4EE0233FBAADCB")
    public void addApnContextSync(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_ADD_APNCONTEXT, apnContext);
        {
            log("addApnContext ok");
        } 
        {
            log("addApnContext error response=" + response);
        } 
        addTaint(apnContext.getTaint());
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.831 -0400", hash_original_method = "51B2CCF2735E77C63E82DEC17109A5B1", hash_generated_method = "25511F6D28160303E94440588D6264F1")
    public void reqRemomveApnContext(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        log("reqRemomveApnContext");
        addTaint(apnContext.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.832 -0400", hash_original_method = "62E31991C2E3FEB9590AC2302F444FDA", hash_generated_method = "0C3E1BD8D15E817EE036311093D4B3D3")
    public void removeApnContextSync(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_REMOVE_APNCONTEXT, apnContext);
        {
            log("removeApnContext ok");
        } 
        {
            log("removeApnContext error response=" + response);
        } 
        addTaint(apnContext.getTaint());
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.832 -0400", hash_original_method = "AAD200E4835E6912540E5A2C7F9552F9", hash_generated_method = "72A6F677F1372B00949939E56DB38AF9")
    public void reqGetApnList(ApnContext apnContext) {
        Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        log("reqGetApnList");
        addTaint(apnContext.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.834 -0400", hash_original_method = "48ABE9510A7CA4042FB5B96D41BACEB8", hash_generated_method = "F251BC353ED064832327095549E0A572")
    public Collection<ApnContext> rspApnList(Message response) {
        Collection<ApnContext> varB4EAC82CA7396A68D541C85D26508E83_1598579741 = null; 
        Collection<ApnContext> retVal = (Collection<ApnContext>)response.obj;
        retVal = new ArrayList<ApnContext>();
        varB4EAC82CA7396A68D541C85D26508E83_1598579741 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1598579741.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1598579741;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.836 -0400", hash_original_method = "498EAD8B319A2A3996C6AC846ACD4BE2", hash_generated_method = "C676F0AC9BC4B72D8D061A15CAA4B969")
    public Collection<ApnContext> getApnListSync() {
        Collection<ApnContext> varB4EAC82CA7396A68D541C85D26508E83_1010663678 = null; 
        Collection<ApnContext> varB4EAC82CA7396A68D541C85D26508E83_905881527 = null; 
        Message response = sendMessageSynchronously(REQ_GET_APNCONTEXT_LIST);
        {
            log("getApnList ok");
            varB4EAC82CA7396A68D541C85D26508E83_1010663678 = rspApnList(response);
        } 
        {
            log("getApnList error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_905881527 = new ArrayList<ApnContext>();
        } 
        Collection<ApnContext> varA7E53CE21691AB073D9660D615818899_574075194; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_574075194 = varB4EAC82CA7396A68D541C85D26508E83_1010663678;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_574075194 = varB4EAC82CA7396A68D541C85D26508E83_905881527;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_574075194.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_574075194;
        
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.838 -0400", hash_original_method = "408D11B7A3DFC98C0728A70ED62F0EEA", hash_generated_method = "10DD8D35FFFB973D4939B580E671E4B7")
    public void reqSetReconnectIntent(PendingIntent intent) {
        Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        log("reqSetReconnectIntent");
        addTaint(intent.getTaint());
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.839 -0400", hash_original_method = "D99BC1BEF330D90F2BC64CDBA6E6105B", hash_generated_method = "63EF01EBDC4DA01BB80D8EB6F56B5DFA")
    public void setReconnectIntentSync(PendingIntent intent) {
        Message response = sendMessageSynchronously(REQ_SET_RECONNECT_INTENT, intent);
        {
            log("setReconnectIntent ok");
        } 
        {
            log("setReconnectIntent error response=" + response);
        } 
        addTaint(intent.getTaint());
        
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.840 -0400", hash_original_method = "3F955D64051D380D89135CF7B70C1F05", hash_generated_method = "54651B6D19BFE89ED0CF1556F2B4343A")
    public void reqGetReconnectIntent() {
        Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        log("reqGetReconnectIntent");
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.842 -0400", hash_original_method = "9555B3D0DB27D43CC0B0BA451DA1A9D5", hash_generated_method = "E2D5E9531FCEF32EE970E59440681914")
    public PendingIntent rspReconnectIntent(Message response) {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_970435745 = null; 
        PendingIntent retVal = (PendingIntent) response.obj;
        varB4EAC82CA7396A68D541C85D26508E83_970435745 = retVal;
        addTaint(response.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_970435745.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_970435745;
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.843 -0400", hash_original_method = "D70777E4A1678D0EF0C2B7C3D53ADD58", hash_generated_method = "45B71ECA68CA7246702A526B311ECB31")
    public PendingIntent getReconnectIntentSync() {
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_1980399189 = null; 
        PendingIntent varB4EAC82CA7396A68D541C85D26508E83_938659112 = null; 
        Message response = sendMessageSynchronously(REQ_GET_RECONNECT_INTENT);
        {
            log("getReconnectIntent ok");
            varB4EAC82CA7396A68D541C85D26508E83_1980399189 = rspReconnectIntent(response);
        } 
        {
            log("getReconnectIntent error response=" + response);
            varB4EAC82CA7396A68D541C85D26508E83_938659112 = null;
        } 
        PendingIntent varA7E53CE21691AB073D9660D615818899_1041394972; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1041394972 = varB4EAC82CA7396A68D541C85D26508E83_1980399189;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1041394972 = varB4EAC82CA7396A68D541C85D26508E83_938659112;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1041394972.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1041394972;
        
        
        
            
            
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.844 -0400", hash_original_method = "3340C70610FFA5D9D28FC6E77DE7CB0F", hash_generated_method = "8B71FEEF08A72DF7241D84A13E8D8BDC")
    private void log(String s) {
        android.util.Log.d(mLogTag, "DataConnectionAc " + s);
        addTaint(s.getTaint());
        
        
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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "0F6F0EB642B3F46DE2B2DF48DA4427EF", hash_generated_field = "1A61763F9CABC9206BB5AE6E570AB8AE")

    private static final boolean DBG = false;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "06E844B888ED9045894B2B8636373495", hash_generated_field = "6BCB0AA355104F156D0A2B3A91BB070E")

    public static final int BASE = Protocol.BASE_DATA_CONNECTION_AC;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "EADBD9ECE62C98E1D8E918128B3CA096", hash_generated_field = "1475D2F355264F68EEAD5DE0DC64E4C1")

    public static final int REQ_IS_INACTIVE = BASE + 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "1B158D124EED34F8B028A91607C881D2", hash_generated_field = "4EF0EE195500EDBC396F404FB857CFCE")

    public static final int RSP_IS_INACTIVE = BASE + 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "D8F3245683A6ECB00974E58E4A8A6249", hash_generated_field = "100ADE81533B5A145526EE17F8BCF7F6")

    public static final int REQ_GET_CID = BASE + 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "F6D68F5B120AFF550917C4B5568E2EAB", hash_generated_field = "4AADBE311B5CBD53B22C258FD0BC5894")

    public static final int RSP_GET_CID = BASE + 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "451E9EC325AB2136FBF344263AC13FB4", hash_generated_field = "4556E2B1BBE8565148BB1897F4F1FFF2")

    public static final int REQ_GET_APNSETTING = BASE + 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "67C1D26E2877CD8726F9AC202269D341", hash_generated_field = "075D97CF7AE01BA14B82937FAB85E17C")

    public static final int RSP_GET_APNSETTING = BASE + 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "44E8E021E38F9F4957C80CC8005AF125", hash_generated_field = "6B2177B63C14A3D8C4A0465DF7EDA57B")

    public static final int REQ_GET_LINK_PROPERTIES = BASE + 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "500C1AC91FB838581568984E44550968", hash_generated_field = "B073222C67C8387DA84D52E09C649C5B")

    public static final int RSP_GET_LINK_PROPERTIES = BASE + 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "2BF1A9BBA19C9A658F6D0B42DAED1E41", hash_generated_field = "AA7EDD6DEA7FBE6E6DEDC341AE2566AA")

    public static final int REQ_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "9DFC37643183DE61DD9F1BC7337883B3", hash_generated_field = "2BD71056213661FD69459E151EB320F2")

    public static final int RSP_SET_LINK_PROPERTIES_HTTP_PROXY = BASE + 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "065018769EB6CC7F7373CA6BED8F7643", hash_generated_field = "42BC94DC23936D5550B2F12E94B801F3")

    public static final int REQ_GET_LINK_CAPABILITIES = BASE + 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "9F9D88D4A8B28546FEE157032AC8B70A", hash_generated_field = "7C871C282AED07B5AFD51BB60DC58B87")

    public static final int RSP_GET_LINK_CAPABILITIES = BASE + 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "16010B85948823BF66211764D7B5283B", hash_generated_field = "410DC65F191E667E05E1C26996344ED6")

    public static final int REQ_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "3DD80A27FF8D61C2D2E8816651BAC0E4", hash_generated_field = "EABD1A19ECDA7C315E74E3BB10C8AA34")

    public static final int RSP_UPDATE_LINK_PROPERTIES_DATA_CALL_STATE = BASE + 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "F6491F3C8DCD8733232690FB3896BF47", hash_generated_field = "FA6D9E30AD45F04695E898045922860A")

    public static final int REQ_RESET = BASE + 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.845 -0400", hash_original_field = "CF1337BD01D40550D657AF71D5457B15", hash_generated_field = "669F769EC139E98CB3AFB220D6A1C9FE")

    public static final int RSP_RESET = BASE + 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "C3E5268DDA9CBD4AD8CA1F06BAC6941B", hash_generated_field = "76D19A23EEE2DE297833D58F70073A84")

    public static final int REQ_GET_REFCOUNT = BASE + 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "E6E62475054FEEC765CEF64603D3A70D", hash_generated_field = "BD8C38909076EDBB350F0534D3158B5A")

    public static final int RSP_GET_REFCOUNT = BASE + 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "2E82E5CB120F76BE1E9AABB7166660B5", hash_generated_field = "8F3EC990CEC19BF924C0C83E473DF703")

    public static final int REQ_ADD_APNCONTEXT = BASE + 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "5FFC50DC4F0DF7544490909AD3D8DB3D", hash_generated_field = "D05330977465F7AF4E384E150213096A")

    public static final int RSP_ADD_APNCONTEXT = BASE + 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "86AFFBEDA03B70DE11F7AFE2EE19B988", hash_generated_field = "FC2140507E1C1E4A862E984C6536D33F")

    public static final int REQ_REMOVE_APNCONTEXT = BASE + 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "452A4337B6E6F3036095C684213134BF", hash_generated_field = "F6C5D6966EFACD969BB347661AD8098A")

    public static final int RSP_REMOVE_APNCONTEXT = BASE + 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "842D49F350462A667AD2590CE93489B0", hash_generated_field = "7CADBAFCB6C4D553E00439A92A77399A")

    public static final int REQ_GET_APNCONTEXT_LIST = BASE + 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "63393ADC62ADB8086F1A9106D4DA73F7", hash_generated_field = "08CEE76E523CBFA9615E63AE42E97282")

    public static final int RSP_GET_APNCONTEXT_LIST = BASE + 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "F83139694F8C75C29041CAD82805FBC0", hash_generated_field = "AEDC94BDC63CFCBD1EE247E113E0B2BD")

    public static final int REQ_SET_RECONNECT_INTENT = BASE + 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "1A21029CD633D0CA53EB46E887F9DCE0", hash_generated_field = "50977DA17634FA6287626111506AF1F5")

    public static final int RSP_SET_RECONNECT_INTENT = BASE + 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "E9DEE9E0E0EB4253C7E41D3E57891BB2", hash_generated_field = "E050F9150348EB87E92AA17BEF7AA6F1")

    public static final int REQ_GET_RECONNECT_INTENT = BASE + 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.846 -0400", hash_original_field = "9440C9722A4FB872C7E1976D00F575DE", hash_generated_field = "B47C4AB7C8CEFA3E66A64CE4AF15F148")

    public static final int RSP_GET_RECONNECT_INTENT = BASE + 27;
}

