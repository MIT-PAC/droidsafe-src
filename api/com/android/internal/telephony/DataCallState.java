package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.234 -0400", hash_original_field = "A4622F7F72162611C8E075EE443BC26E", hash_generated_field = "7A94A86038D93EBBF047FD36678A7A07")

    private final boolean DBG = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.234 -0400", hash_original_field = "41EBE7F32B96C1E2E9C209710486A443", hash_generated_field = "5BBC5E9DDE806745C40B89AE2D778A92")

    private final String LOG_TAG = "GSM";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.234 -0400", hash_original_field = "E4D9C90D170874FA2D2EEBFCE87692A7", hash_generated_field = "86EB4D9378DBDAFCDCF6A04185238499")

    public int version = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.234 -0400", hash_original_field = "11AA1CC800DDD43A042F03964DDE0860", hash_generated_field = "37B5BCF0BCD2F93BD4AA15407BF7DBA3")

    public int status = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.234 -0400", hash_original_field = "6B5C7A4B82D4D944889929EC20A02521", hash_generated_field = "2EF50DAD06B60CB00722667F904C5E27")

    public int cid = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.234 -0400", hash_original_field = "C4E9AD029D5B7FF6E6731F011ECA16D4", hash_generated_field = "BAA831B1264A2BC6C645E9888B97BBF7")

    public int active = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.235 -0400", hash_original_field = "B9E65EA3442DC1B079E97EFC2DFD99B8", hash_generated_field = "4E81F998F44759442ED704F68E8E7FD7")

    public String type = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.235 -0400", hash_original_field = "97C8B8D2CD6624719AF310BF49270E44", hash_generated_field = "B60C656CC37E056A85BB8FC04F122945")

    public String ifname = "";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.235 -0400", hash_original_field = "3A84D7E6072758A29E00FB6FF211A091", hash_generated_field = "0AE759B139BF13E410E57C78040C38A1")

    public String [] addresses = new String[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.235 -0400", hash_original_field = "A960F775C1514D7112543863175FD6E2", hash_generated_field = "A868FF3FEC6A925E9D99748B84CDB989")

    public String [] dnses = new String[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.235 -0400", hash_original_field = "E216C57D2AB1239A85729B5EBD119238", hash_generated_field = "B011EEECDCFB601B72F42A2830075BBE")

    public String[] gateways = new String[0];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.235 -0400", hash_original_field = "DE88CB31022A76252599F1E5500A1C92", hash_generated_field = "7052EC282782F5FC34BAEDB134C88C47")

    public int suggestedRetryTime = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.235 -0400", hash_original_method = "F9C84E8FBBA5D2B599538814C0144DA0", hash_generated_method = "F9C84E8FBBA5D2B599538814C0144DA0")
    public DataCallState ()
    {
        
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.236 -0400", hash_original_method = "CAAE2D86A06B83EE392B769B8D61B847", hash_generated_method = "D7D9AA9E48A84B287807F328C794EFC2")
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
for(String addr : addresses)
        {
            sb.append(addr);
            sb.append(",");
        } 
    if(addresses.length > 0)        
        sb.deleteCharAt(sb.length()-1);
        sb.append("] dnses=[");
for(String addr : dnses)
        {
            sb.append(addr);
            sb.append(",");
        } 
    if(dnses.length > 0)        
        sb.deleteCharAt(sb.length()-1);
        sb.append("] gateways=[");
for(String addr : gateways)
        {
            sb.append(addr);
            sb.append(",");
        } 
    if(gateways.length > 0)        
        sb.deleteCharAt(sb.length()-1);
        sb.append("]}");
String var2460B846747F8B22185AD8BE722266A5_1899049508 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_1899049508.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_1899049508;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:20.240 -0400", hash_original_method = "D215C550B13153D48FB1E7191C982EAA", hash_generated_method = "3E546E6D95562AC743C363C1CC44E897")
    public SetupResult setLinkProperties(LinkProperties linkProperties,
            boolean okToUseSystemPropertyDns) {
        addTaint(okToUseSystemPropertyDns);
        addTaint(linkProperties.getTaint());
        SetupResult result;
    if(linkProperties == null)        
        linkProperties = new LinkProperties();
        else
        linkProperties.clear();
    if(status == FailCause.NONE.getErrorCode())        
        {
            String propertyPrefix = "net." + ifname + ".";
            try 
            {
                linkProperties.setInterfaceName(ifname);
    if(addresses != null && addresses.length > 0)                
                {
for(String addr : addresses)
                    {
                        addr = addr.trim();
    if(addr.isEmpty())                        
                        continue;
                        LinkAddress la;
                        int addrPrefixLen;
                        String [] ap = addr.split("/");
    if(ap.length == 2)                        
                        {
                            addr = ap[0];
                            addrPrefixLen = Integer.parseInt(ap[1]);
                        } 
                        else
                        {
                            addrPrefixLen = 0;
                        } 
                        InetAddress ia;
                        try 
                        {
                            ia = NetworkUtils.numericToInetAddress(addr);
                        } 
                        catch (IllegalArgumentException e)
                        {
                            UnknownHostException varA863B3F84BD56088AAA8F44EFF6E49F6_1800039004 = new UnknownHostException("Non-numeric ip addr=" + addr);
                            varA863B3F84BD56088AAA8F44EFF6E49F6_1800039004.addTaint(taint);
                            throw varA863B3F84BD56088AAA8F44EFF6E49F6_1800039004;
                        } 
    if(! ia.isAnyLocalAddress())                        
                        {
    if(addrPrefixLen == 0)                            
                            {
                                addrPrefixLen = (ia instanceof Inet4Address) ? 32 : 128;
                            } 
    if(DBG)                            
                            Log.d(LOG_TAG, "addr/pl=" + addr + "/" + addrPrefixLen);
                            la = new LinkAddress(ia, addrPrefixLen);
                            linkProperties.addLinkAddress(la);
                        } 
                    } 
                } 
                else
                {
                    UnknownHostException var8830AF8A7DDFCDD36201D20B007C6E34_44180512 = new UnknownHostException("no address for ifname=" + ifname);
                    var8830AF8A7DDFCDD36201D20B007C6E34_44180512.addTaint(taint);
                    throw var8830AF8A7DDFCDD36201D20B007C6E34_44180512;
                } 
    if(dnses != null && dnses.length > 0)                
                {
for(String addr : dnses)
                    {
                        addr = addr.trim();
    if(addr.isEmpty())                        
                        continue;
                        InetAddress ia;
                        try 
                        {
                            ia = NetworkUtils.numericToInetAddress(addr);
                        } 
                        catch (IllegalArgumentException e)
                        {
                            UnknownHostException varD0095A75DA8702AE4D4D3B78CCC5B0CB_1170799569 = new UnknownHostException("Non-numeric dns addr=" + addr);
                            varD0095A75DA8702AE4D4D3B78CCC5B0CB_1170799569.addTaint(taint);
                            throw varD0095A75DA8702AE4D4D3B78CCC5B0CB_1170799569;
                        } 
    if(! ia.isAnyLocalAddress())                        
                        {
                            linkProperties.addDns(ia);
                        } 
                    } 
                } 
                else
    if(okToUseSystemPropertyDns)                
                {
                    String dnsServers[] = new String[2];
                    dnsServers[0] = SystemProperties.get(propertyPrefix + "dns1");
                    dnsServers[1] = SystemProperties.get(propertyPrefix + "dns2");
for(String dnsAddr : dnsServers)
                    {
                        dnsAddr = dnsAddr.trim();
    if(dnsAddr.isEmpty())                        
                        continue;
                        InetAddress ia;
                        try 
                        {
                            ia = NetworkUtils.numericToInetAddress(dnsAddr);
                        } 
                        catch (IllegalArgumentException e)
                        {
                            UnknownHostException varE41797D41F7C89C430CA771BCC2B0728_145583884 = new UnknownHostException("Non-numeric dns addr=" + dnsAddr);
                            varE41797D41F7C89C430CA771BCC2B0728_145583884.addTaint(taint);
                            throw varE41797D41F7C89C430CA771BCC2B0728_145583884;
                        } 
    if(! ia.isAnyLocalAddress())                        
                        {
                            linkProperties.addDns(ia);
                        } 
                    } 
                } 
                else
                {
                    UnknownHostException var0835286BE85D052BDAD1CAB9A5069C3F_585028363 = new UnknownHostException("Empty dns response and no system default dns");
                    var0835286BE85D052BDAD1CAB9A5069C3F_585028363.addTaint(taint);
                    throw var0835286BE85D052BDAD1CAB9A5069C3F_585028363;
                } 
    if((gateways == null) || (gateways.length == 0))                
                {
                    String sysGateways = SystemProperties.get(propertyPrefix + "gw");
    if(sysGateways != null)                    
                    {
                        gateways = sysGateways.split(" ");
                    } 
                    else
                    {
                        gateways = new String[0];
                    } 
                } 
for(String addr : gateways)
                {
                    addr = addr.trim();
    if(addr.isEmpty())                    
                    continue;
                    InetAddress ia;
                    try 
                    {
                        ia = NetworkUtils.numericToInetAddress(addr);
                    } 
                    catch (IllegalArgumentException e)
                    {
                        UnknownHostException var5D525328A510081430DE4D78C09B2CC0_1745697797 = new UnknownHostException("Non-numeric gateway addr=" + addr);
                        var5D525328A510081430DE4D78C09B2CC0_1745697797.addTaint(taint);
                        throw var5D525328A510081430DE4D78C09B2CC0_1745697797;
                    } 
    if(! ia.isAnyLocalAddress())                    
                    {
                        linkProperties.addRoute(new RouteInfo(ia));
                    } 
                } 
                result = SetupResult.SUCCESS;
            } 
            catch (UnknownHostException e)
            {
                Log.d(LOG_TAG, "setLinkProperties: UnknownHostException " + e);
                e.printStackTrace();
                result = SetupResult.ERR_UnacceptableParameter;
            } 
        } 
        else
        {
    if(version < 4)            
            {
                result = SetupResult.ERR_GetLastErrorFromRil;
            } 
            else
            {
                result = SetupResult.ERR_RilError;
            } 
        } 
    if(result != SetupResult.SUCCESS)        
        {
    if(DBG)            
            {
                Log.d(LOG_TAG, "setLinkProperties: error clearing LinkProperties " +
                        "status=" + status + " result=" + result);
            } 
            linkProperties.clear();
        } 
SetupResult varDC838461EE2FA0CA4C9BBB70A15456B0_2087173888 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_2087173888.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_2087173888;
        
        
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

