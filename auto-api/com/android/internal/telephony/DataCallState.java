package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkUtils;
import android.net.RouteInfo;
import android.os.SystemProperties;
import android.util.Log;
import com.android.internal.telephony.DataConnection.FailCause;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class DataCallState {
    private boolean DBG = true;
    private String LOG_TAG = "GSM";
    public int version = 0;
    public int status = 0;
    public int cid = 0;
    public int active = 0;
    public String type = "";
    public String ifname = "";
    public String [] addresses = new String[0];
    public String [] dnses = new String[0];
    public String[] gateways = new String[0];
    public int suggestedRetryTime = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.823 -0400", hash_original_method = "E29451E4F43D781E87459CF6D67C1899", hash_generated_method = "E29451E4F43D781E87459CF6D67C1899")
        public DataCallState ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.831 -0400", hash_original_method = "CAAE2D86A06B83EE392B769B8D61B847", hash_generated_method = "4E3B6EEBAA065522084CE6AA7340525E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuffer sb;
        sb = new StringBuffer();
        sb.append("DataCallState: {")
           .append("version=").append(version)
           .append(" status=").append(status)
           .append(" retry=").append(suggestedRetryTime)
           .append(" cid=").append(cid)
           .append(" active=").append(active)
           .append(" type=").append(type)
           .append("' ifname='").append(ifname);
        sb.append("' addresses=[");
        {
            String addr = addresses[0];
            {
                sb.append(addr);
                sb.append(",");
            } //End block
        } //End collapsed parenthetic
        sb.deleteCharAt(sb.length()-1);
        sb.append("] dnses=[");
        {
            String addr = dnses[0];
            {
                sb.append(addr);
                sb.append(",");
            } //End block
        } //End collapsed parenthetic
        sb.deleteCharAt(sb.length()-1);
        sb.append("] gateways=[");
        {
            String addr = gateways[0];
            {
                sb.append(addr);
                sb.append(",");
            } //End block
        } //End collapsed parenthetic
        sb.deleteCharAt(sb.length()-1);
        sb.append("]}");
        String var806458D832AB974D230FEE4CBBDBD390_1179724186 = (sb.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.893 -0400", hash_original_method = "D215C550B13153D48FB1E7191C982EAA", hash_generated_method = "4CA8CFE76A10A648DBA74DA89241BB16")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SetupResult setLinkProperties(LinkProperties linkProperties,
            boolean okToUseSystemPropertyDns) {
        dsTaint.addTaint(okToUseSystemPropertyDns);
        dsTaint.addTaint(linkProperties.dsTaint);
        SetupResult result;
        linkProperties = new LinkProperties();
        linkProperties.clear();
        {
            boolean var898CA1FDE6CCA787B9A326BE718BB330_909286607 = (status == FailCause.NONE.getErrorCode());
            {
                String propertyPrefix;
                propertyPrefix = "net." + ifname + ".";
                try 
                {
                    linkProperties.setInterfaceName(ifname);
                    {
                        {
                            String addr = addresses[0];
                            {
                                addr = addr.trim();
                                {
                                    boolean var688A9E0C1A4BB39755E53EFB97CC9DC9_1072853689 = (addr.isEmpty());
                                } //End collapsed parenthetic
                                LinkAddress la;
                                int addrPrefixLen;
                                String [] ap;
                                ap = addr.split("/");
                                {
                                    addr = ap[0];
                                    addrPrefixLen = Integer.parseInt(ap[1]);
                                } //End block
                                {
                                    addrPrefixLen = 0;
                                } //End block
                                InetAddress ia;
                                try 
                                {
                                    ia = NetworkUtils.numericToInetAddress(addr);
                                } //End block
                                catch (IllegalArgumentException e)
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("Non-numeric ip addr=" + addr);
                                } //End block
                                {
                                    boolean var4018297529DD3FE6783E85542C17AE62_1064228916 = (! ia.isAnyLocalAddress());
                                    {
                                        {
                                            addrPrefixLen = (ia instanceof Inet4Address) ? 32 : 128;
                                        } //End block
                                        Log.d(LOG_TAG, "addr/pl=" + addr + "/" + addrPrefixLen);
                                        la = new LinkAddress(ia, addrPrefixLen);
                                        linkProperties.addLinkAddress(la);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("no address for ifname=" + ifname);
                    } //End block
                    {
                        {
                            String addr = dnses[0];
                            {
                                addr = addr.trim();
                                {
                                    boolean var688A9E0C1A4BB39755E53EFB97CC9DC9_628078107 = (addr.isEmpty());
                                } //End collapsed parenthetic
                                InetAddress ia;
                                try 
                                {
                                    ia = NetworkUtils.numericToInetAddress(addr);
                                } //End block
                                catch (IllegalArgumentException e)
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("Non-numeric dns addr=" + addr);
                                } //End block
                                {
                                    boolean var4018297529DD3FE6783E85542C17AE62_139170488 = (! ia.isAnyLocalAddress());
                                    {
                                        linkProperties.addDns(ia);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        String dnsServers[];
                        dnsServers = new String[2];
                        dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
                        dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
                        {
                            String dnsAddr = dnsServers[0];
                            {
                                dnsAddr = dnsAddr.trim();
                                {
                                    boolean varF1D7FD925482BB87366DB21E20C41D3D_1442192634 = (dnsAddr.isEmpty());
                                } //End collapsed parenthetic
                                InetAddress ia;
                                try 
                                {
                                    ia = NetworkUtils.numericToInetAddress(dnsAddr);
                                } //End block
                                catch (IllegalArgumentException e)
                                {
                                    if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("Non-numeric dns addr=" + dnsAddr);
                                } //End block
                                {
                                    boolean var4018297529DD3FE6783E85542C17AE62_1100392651 = (! ia.isAnyLocalAddress());
                                    {
                                        linkProperties.addDns(ia);
                                    } //End block
                                } //End collapsed parenthetic
                            } //End block
                        } //End collapsed parenthetic
                    } //End block
                    {
                        if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("Empty dns response and no system default dns");
                    } //End block
                    {
                        String sysGateways;
                        sysGateways = SystemProperties.get(propertyPrefix + "gw");
                        {
                            gateways = sysGateways.split(" ");
                        } //End block
                        {
                            gateways = new String[0];
                        } //End block
                    } //End block
                    {
                        String addr = gateways[0];
                        {
                            addr = addr.trim();
                            {
                                boolean var79C1ADCD7F5287CC7E8E94A297E2BE8F_1044525045 = (addr.isEmpty());
                            } //End collapsed parenthetic
                            InetAddress ia;
                            try 
                            {
                                ia = NetworkUtils.numericToInetAddress(addr);
                            } //End block
                            catch (IllegalArgumentException e)
                            {
                                if (DroidSafeAndroidRuntime.control) throw new UnknownHostException("Non-numeric gateway addr=" + addr);
                            } //End block
                            {
                                boolean varBB1F85E17F84871B2D79DF63B70EB29F_19795430 = (! ia.isAnyLocalAddress());
                                {
                                    linkProperties.addRoute(new RouteInfo(ia));
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                    } //End collapsed parenthetic
                    result = SetupResult.SUCCESS;
                } //End block
                catch (UnknownHostException e)
                {
                    Log.d(LOG_TAG, "setLinkProperties: UnknownHostException " + e);
                    e.printStackTrace();
                    result = SetupResult.ERR_UnacceptableParameter;
                } //End block
            } //End block
            {
                {
                    result = SetupResult.ERR_GetLastErrorFromRil;
                } //End block
                {
                    result = SetupResult.ERR_RilError;
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            {
                Log.d(LOG_TAG, "setLinkProperties: error clearing LinkProperties " +
                        "status=" + status + " result=" + result);
            } //End block
            linkProperties.clear();
        } //End block
        return (SetupResult)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public enum SetupResult {
        SUCCESS,
        ERR_BadCommand,
        ERR_UnacceptableParameter,
        ERR_GetLastErrorFromRil,
        ERR_Stale,
        ERR_RilError;
        public FailCause mFailCause;
        SetupResult() {
            mFailCause = FailCause.fromInt(0);
        }
        @Override
        public String toString() {
            return name() + "  SetupResult.mFailCause=" + mFailCause;
        }
    }

    
}

