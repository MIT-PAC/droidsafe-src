package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkUtils;
import android.net.RouteInfo;
import android.os.SystemProperties;
import android.util.Log;

import com.android.internal.telephony.DataConnection.FailCause;






public class DataCallState {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.562 -0500", hash_original_field = "95D5733A0C83DB3D047D109C028C9F02", hash_generated_field = "7A94A86038D93EBBF047FD36678A7A07")

    private final boolean DBG = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.563 -0500", hash_original_field = "28DECCA9F494133CD6F61BCA99A50ECA", hash_generated_field = "5BBC5E9DDE806745C40B89AE2D778A92")

    private final String LOG_TAG = "GSM";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.564 -0500", hash_original_field = "4A57C041D9A7B4C6067DB09D0C7831F4", hash_generated_field = "86EB4D9378DBDAFCDCF6A04185238499")


    public int version = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.565 -0500", hash_original_field = "E32E8D8C27E399D4E50FABD41DE37761", hash_generated_field = "37B5BCF0BCD2F93BD4AA15407BF7DBA3")

    public int status = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.566 -0500", hash_original_field = "4D976076F564E26795C86B297AF0BA54", hash_generated_field = "2EF50DAD06B60CB00722667F904C5E27")

    public int cid = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.567 -0500", hash_original_field = "E6084C81C8E38FAB2CE0ECDEDAE9C92E", hash_generated_field = "BAA831B1264A2BC6C645E9888B97BBF7")

    public int active = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.568 -0500", hash_original_field = "31C62AFBAFC52353C9287305BC7B0D00", hash_generated_field = "4E81F998F44759442ED704F68E8E7FD7")

    public String type = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.569 -0500", hash_original_field = "2E6CD8BFEB8CFEAFF698032AF6CACF58", hash_generated_field = "B60C656CC37E056A85BB8FC04F122945")

    public String ifname = "";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.570 -0500", hash_original_field = "EFA867F332BE93BAE9E0C731C30D1059", hash_generated_field = "0AE759B139BF13E410E57C78040C38A1")

    public String [] addresses = new String[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.571 -0500", hash_original_field = "C036587F38B5B0367DD064B0EAF2D56A", hash_generated_field = "A868FF3FEC6A925E9D99748B84CDB989")

    public String [] dnses = new String[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.572 -0500", hash_original_field = "906B6667C6BE1A48531EEB3A40FF6A22", hash_generated_field = "B011EEECDCFB601B72F42A2830075BBE")

    public String[] gateways = new String[0];
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.573 -0500", hash_original_field = "209B5584AB51D9BEDA71EE08B7B2AF63", hash_generated_field = "7052EC282782F5FC34BAEDB134C88C47")

    public int suggestedRetryTime = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:15.745 -0400", hash_original_method = "F9C84E8FBBA5D2B599538814C0144DA0", hash_generated_method = "F9C84E8FBBA5D2B599538814C0144DA0")
    public DataCallState ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.578 -0500", hash_original_method = "CAAE2D86A06B83EE392B769B8D61B847", hash_generated_method = "4D6FF0647DDF910FB4E7699D22BB705B")
    @Override
public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("DataCallState: {")
           .append("version=").append(version)
           .append(" status=").append(status)
           .append(" retry=").append(suggestedRetryTime)
           .append(" cid=").append(cid)
           .append(" active=").append(active)
           .append(" type=").append(type)
           .append("' ifname='").append(ifname);
        sb.append("' addresses=[");
        for (String addr : addresses) {
            sb.append(addr);
            sb.append(",");
        }
        if (addresses.length > 0) sb.deleteCharAt(sb.length()-1);
        sb.append("] dnses=[");
        for (String addr : dnses) {
            sb.append(addr);
            sb.append(",");
        }
        if (dnses.length > 0) sb.deleteCharAt(sb.length()-1);
        sb.append("] gateways=[");
        for (String addr : gateways) {
            sb.append(addr);
            sb.append(",");
        }
        if (gateways.length > 0) sb.deleteCharAt(sb.length()-1);
        sb.append("]}");
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.581 -0500", hash_original_method = "D215C550B13153D48FB1E7191C982EAA", hash_generated_method = "413330FDCAF71E6D3951AB24B8A7E1D3")
    public SetupResult setLinkProperties(LinkProperties linkProperties,
            boolean okToUseSystemPropertyDns) {
        SetupResult result;

        // Start with clean network properties and if we have
        // a failure we'll clear again at the bottom of this code.
        if (linkProperties == null)
            linkProperties = new LinkProperties();
        else
            linkProperties.clear();

        if (status == FailCause.NONE.getErrorCode()) {
            String propertyPrefix = "net." + ifname + ".";

            try {
                // set interface name
                linkProperties.setInterfaceName(ifname);

                // set link addresses
                if (addresses != null && addresses.length > 0) {
                    for (String addr : addresses) {
                        addr = addr.trim();
                        if (addr.isEmpty()) continue;
                        LinkAddress la;
                        int addrPrefixLen;

                        String [] ap = addr.split("/");
                        if (ap.length == 2) {
                            addr = ap[0];
                            addrPrefixLen = Integer.parseInt(ap[1]);
                        } else {
                            addrPrefixLen = 0;
                        }
                        InetAddress ia;
                        try {
                            ia = NetworkUtils.numericToInetAddress(addr);
                        } catch (IllegalArgumentException e) {
                            throw new UnknownHostException("Non-numeric ip addr=" + addr);
                        }
                        if (! ia.isAnyLocalAddress()) {
                            if (addrPrefixLen == 0) {
                                // Assume point to point
                                addrPrefixLen = (ia instanceof Inet4Address) ? 32 : 128;
                            }
                            if (DBG) Log.d(LOG_TAG, "addr/pl=" + addr + "/" + addrPrefixLen);
                            la = new LinkAddress(ia, addrPrefixLen);
                            linkProperties.addLinkAddress(la);
                        }
                    }
                } else {
                    throw new UnknownHostException("no address for ifname=" + ifname);
                }

                // set dns servers
                if (dnses != null && dnses.length > 0) {
                    for (String addr : dnses) {
                        addr = addr.trim();
                        if (addr.isEmpty()) continue;
                        InetAddress ia;
                        try {
                            ia = NetworkUtils.numericToInetAddress(addr);
                        } catch (IllegalArgumentException e) {
                            throw new UnknownHostException("Non-numeric dns addr=" + addr);
                        }
                        if (! ia.isAnyLocalAddress()) {
                            linkProperties.addDns(ia);
                        }
                    }
                } else if (okToUseSystemPropertyDns){
                    String dnsServers[] = new String[2];
                    dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
                    dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
                    for (String dnsAddr : dnsServers) {
                        dnsAddr = dnsAddr.trim();
                        if (dnsAddr.isEmpty()) continue;
                        InetAddress ia;
                        try {
                            ia = NetworkUtils.numericToInetAddress(dnsAddr);
                        } catch (IllegalArgumentException e) {
                            throw new UnknownHostException("Non-numeric dns addr=" + dnsAddr);
                        }
                        if (! ia.isAnyLocalAddress()) {
                            linkProperties.addDns(ia);
                        }
                    }
                } else {
                    throw new UnknownHostException("Empty dns response and no system default dns");
                }

                // set gateways
                if ((gateways == null) || (gateways.length == 0)) {
                    String sysGateways = SystemProperties.get(propertyPrefix + "gw");
                    if (sysGateways != null) {
                        gateways = sysGateways.split(" ");
                    } else {
                        gateways = new String[0];
                    }
                }
                for (String addr : gateways) {
                    addr = addr.trim();
                    if (addr.isEmpty()) continue;
                    InetAddress ia;
                    try {
                        ia = NetworkUtils.numericToInetAddress(addr);
                    } catch (IllegalArgumentException e) {
                        throw new UnknownHostException("Non-numeric gateway addr=" + addr);
                    }
                    if (! ia.isAnyLocalAddress()) {
                        linkProperties.addRoute(new RouteInfo(ia));
                    }
                }

                result = SetupResult.SUCCESS;
            } catch (UnknownHostException e) {
                Log.d(LOG_TAG, "setLinkProperties: UnknownHostException " + e);
                e.printStackTrace();
                result = SetupResult.ERR_UnacceptableParameter;
            }
        } else {
            if (version < 4) {
                result = SetupResult.ERR_GetLastErrorFromRil;
            } else {
                result = SetupResult.ERR_RilError;
            }
        }

        // An error occurred so clear properties
        if (result != SetupResult.SUCCESS) {
            if(DBG) {
                Log.d(LOG_TAG, "setLinkProperties: error clearing LinkProperties " +
                        "status=" + status + " result=" + result);
            }
            linkProperties.clear();
        }

        return result;
    }

    
    public enum SetupResult {
        SUCCESS,
        ERR_BadCommand,
        ERR_UnacceptableParameter,
        ERR_GetLastErrorFromRil,
        ERR_Stale,
        ERR_RilError;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.574 -0500", hash_original_field = "C29D8CA47A6232BA935F4E94D32CF5E3", hash_generated_field = "4ED90328C936AFECF6596A638B2DEDB0")


        public FailCause mFailCause;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.575 -0500", hash_original_method = "805CED56FDEBB7FE50D69F98A335F4EF", hash_generated_method = "805CED56FDEBB7FE50D69F98A335F4EF")
            SetupResult() {
            mFailCause = FailCause.fromInt(0);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.576 -0500", hash_original_method = "5F26F82C9A88D8418FA108D7C7A8A2D4", hash_generated_method = "64C3FEA450DED716E1BA34FB24E75F15")
            @Override
public String toString() {
            return name() + "  SetupResult.mFailCause=" + mFailCause;
        }
    }

    
}

