package java.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import dalvik.system.BlockGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import libcore.io.ErrnoException;
import libcore.io.GaiException;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.Memory;
import libcore.io.StructAddrinfo;
import static libcore.io.OsConstants.*;

public class InetAddress implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.304 -0400", hash_original_field = "0D3FDA0BDBB9D619E09CDF3EECBA7999", hash_generated_field = "630495C0099FA460C912B67A0FCAD3C7")

    private int family;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.304 -0400", hash_original_field = "59FBC8DF7B0BEA3A26A2FB6771EA3EEE", hash_generated_field = "90EA25AB4D338372155DC6F7EC59D04E")

    byte[] ipaddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.304 -0400", hash_original_field = "018531A6FE3834353217DBF6A6634DCF", hash_generated_field = "1B7A53B08CE768344D84B69A12503624")

    String hostName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.305 -0400", hash_original_method = "D743789B4770A2F65AD981CCEDC5E9F2", hash_generated_method = "2E1DC10CC44AF4781FBC49399E601EDD")
      InetAddress(int family, byte[] ipaddress, String hostName) {
        this.family = family;
        this.ipaddress = ipaddress;
        this.hostName = hostName;
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.305 -0400", hash_original_method = "3AAFCD043D3971ACCC1BC5F122FB0BE0", hash_generated_method = "810AB7E85CF5541A973D94986EDA8D54")
    @Override
    public boolean equals(Object obj) {
        boolean var736C841577D8C25E47C4A18B061F61D3_573301378 = (Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_38982059 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_38982059;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.305 -0400", hash_original_method = "0983A0B23668071C038C0A3F8002A354", hash_generated_method = "D69B31DD7D7145A22AC998BB07D84487")
    public byte[] getAddress() {
        byte[] var2347CEE6C132BC5594CEE5BBD0F30A9A_473749414 = (ipaddress.clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1827030782 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1827030782;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static InetAddress[] bytesToInetAddresses(byte[][] rawAddresses, String hostName) throws UnknownHostException {
        InetAddress[] returnedAddresses = new InetAddress[rawAddresses.length];
        for (int i = 0; i < rawAddresses.length; i++) {
            returnedAddresses[i] = makeInetAddress(rawAddresses[i], hostName);
        }
        return returnedAddresses;
    }

    
    @DSModeled(DSC.SAFE)
    public static InetAddress[] getAllByName(String host) throws UnknownHostException {
        return getAllByNameImpl(host).clone();
    }

    
    @DSModeled(DSC.SAFE)
    private static InetAddress[] getAllByNameImpl(String host) throws UnknownHostException {
        if (host == null || host.isEmpty()) {
            return loopbackAddresses();
        }
        InetAddress result = parseNumericAddressNoThrow(host);
        if (result != null) {
            result = disallowDeprecatedFormats(host, result);
            if (result == null) {
                throw new UnknownHostException("Deprecated IPv4 address format: " + host);
            }
            return new InetAddress[] { result };
        }
        return lookupHostByName(host).clone();
    }

    
    @DSModeled(DSC.SAFE)
    private static InetAddress makeInetAddress(byte[] bytes, String hostName) throws UnknownHostException {
        if (bytes.length == 4) {
            return new Inet4Address(bytes, hostName);
        } else if (bytes.length == 16) {
            return new Inet6Address(bytes, hostName, 0);
        } else {
            throw badAddressLength(bytes);
        }
    }

    
    @DSModeled(DSC.SAFE)
    private static InetAddress disallowDeprecatedFormats(String address, InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet4Address) || address.indexOf(':') != -1) {
            return inetAddress;
        }
        return Libcore.os.inet_pton(AF_INET, address);
    }

    
    @DSModeled(DSC.SAFE)
    private static InetAddress parseNumericAddressNoThrow(String address) {
        if (address.startsWith("[") && address.endsWith("]") && address.indexOf(':') != -1) {
            address = address.substring(1, address.length() - 1);
        }
        StructAddrinfo hints = new StructAddrinfo();
        hints.ai_flags = AI_NUMERICHOST;
        InetAddress[] addresses = null;
        try {
            addresses = Libcore.os.getaddrinfo(address, hints);
        } catch (GaiException ignored) {
        }
        return (addresses != null) ? addresses[0] : null;
    }

    
    @DSModeled(DSC.SAFE)
    public static InetAddress getByName(String host) throws UnknownHostException {
        return getAllByNameImpl(host)[0];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.307 -0400", hash_original_method = "A1139ABF91D0374599D7EB888F5DB646", hash_generated_method = "C89FB1B5781680283E5BEF3A7AF61513")
    public String getHostAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_280225534 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_280225534 = Libcore.os.getnameinfo(this, NI_NUMERICHOST);
        varB4EAC82CA7396A68D541C85D26508E83_280225534.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_280225534;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.308 -0400", hash_original_method = "4F443763E78EE7A4BDC306A79DFCDBBC", hash_generated_method = "8B6D40A8BC5D0BDAE0D981DB7947FD8C")
    public String getHostName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1971414047 = null; 
        {
            try 
            {
                hostName = getHostByAddrImpl(this).hostName;
            } 
            catch (UnknownHostException ex)
            {
                hostName = getHostAddress();
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_1971414047 = hostName;
        varB4EAC82CA7396A68D541C85D26508E83_1971414047.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1971414047;
        
        
            
                
            
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.309 -0400", hash_original_method = "A5A62CAEFD7FCA56AB200DB74BB59546", hash_generated_method = "3A09A60104C15149CBD9D31ECBE9AA8C")
    public String getCanonicalHostName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1348687704 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1085817577 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1348687704 = getHostByAddrImpl(this).hostName;
        } 
        catch (UnknownHostException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1085817577 = getHostAddress();
        } 
        String varA7E53CE21691AB073D9660D615818899_890828437; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_890828437 = varB4EAC82CA7396A68D541C85D26508E83_1348687704;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_890828437 = varB4EAC82CA7396A68D541C85D26508E83_1085817577;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_890828437.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_890828437;
        
        
            
        
            
        
    }

    
    @DSModeled(DSC.SAFE)
    public static InetAddress getLocalHost() throws UnknownHostException {
        String host = Libcore.os.uname().nodename;
        return lookupHostByName(host)[0];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.310 -0400", hash_original_method = "70D58F36ADD2B32D6B4870D6C7A22922", hash_generated_method = "3B8324D3972E6B396B047B0760A52291")
    @Override
    public int hashCode() {
        int var7810AFBE6CE34C4D0D867B5084406399_686876972 = (Arrays.hashCode(ipaddress));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640165748 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1640165748;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    private static InetAddress[] lookupHostByName(String host) throws UnknownHostException {
        BlockGuard.getThreadPolicy().onNetwork();
        Object cachedResult = addressCache.get(host);
        if (cachedResult != null) {
            if (cachedResult instanceof InetAddress[]) {
                return (InetAddress[]) cachedResult;
            } else {
                throw new UnknownHostException((String) cachedResult);
            }
        }
        try {
            StructAddrinfo hints = new StructAddrinfo();
            hints.ai_flags = AI_ADDRCONFIG;
            hints.ai_family = AF_UNSPEC;
            hints.ai_socktype = SOCK_STREAM;
            InetAddress[] addresses = Libcore.os.getaddrinfo(host, hints);
            for (InetAddress address : addresses) {
                address.hostName = host;
            }
            addressCache.put(host, addresses);
            return addresses;
        } catch (GaiException gaiException) {
            String detailMessage = "Unable to resolve host \"" + host + "\": " + Libcore.os.gai_strerror(gaiException.error);
            addressCache.putUnknownHost(host, detailMessage);
            throw gaiException.rethrowAsUnknownHostException(detailMessage);
        }
    }

    
    @DSModeled(DSC.SAFE)
    public static void clearDnsCache() {
        addressCache.clear();
    }

    
    @DSModeled(DSC.SAFE)
    private static InetAddress getHostByAddrImpl(InetAddress address) throws UnknownHostException {
        BlockGuard.getThreadPolicy().onNetwork();
        try {
            String hostname = Libcore.os.getnameinfo(address, NI_NAMEREQD);
            return makeInetAddress(address.ipaddress.clone(), hostname);
        } catch (GaiException gaiException) {
            throw gaiException.rethrowAsUnknownHostException();
        }
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.311 -0400", hash_original_method = "0306D8C3E43590D820E89D43080D7C82", hash_generated_method = "96EC4CC30D2393F2C17BFF1EB1D3C6E5")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1411645163 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1411645163 = (hostName == null ? "" : hostName) + "/" + getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_1411645163.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1411645163;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isNumeric(String address) {
        InetAddress inetAddress = parseNumericAddressNoThrow(address);
        return inetAddress != null && disallowDeprecatedFormats(address, inetAddress) != null;
    }

    
    @DSModeled(DSC.SAFE)
    public static InetAddress parseNumericAddress(String numericAddress) {
        if (numericAddress == null || numericAddress.isEmpty()) {
            return Inet6Address.LOOPBACK;
        }
        InetAddress result = parseNumericAddressNoThrow(numericAddress);
        result = disallowDeprecatedFormats(numericAddress, result);
        if (result == null) {
            throw new IllegalArgumentException("Not a numeric address: " + numericAddress);
        }
        return result;
    }

    
    @DSModeled(DSC.SAFE)
    private static InetAddress[] loopbackAddresses() {
        return new InetAddress[] { Inet6Address.LOOPBACK, Inet4Address.LOOPBACK };
    }

    
    @DSModeled(DSC.SAFE)
    public static InetAddress getLoopbackAddress() {
        return Inet6Address.LOOPBACK;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.312 -0400", hash_original_method = "0DFB661E6E123FAAEACDB840E13652D3", hash_generated_method = "AE97447B0ED1BFED4B90BDC9BD0FE393")
    public boolean isAnyLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_162807180 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_162807180;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.312 -0400", hash_original_method = "C2C85D69F5C8114C53B505B2C48FBA38", hash_generated_method = "0AF11685BA819A62E3D04678E3E0CE0E")
    public boolean isLinkLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_64687892 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_64687892;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.313 -0400", hash_original_method = "F4A838CB0E6897A23081D395162E9DA1", hash_generated_method = "0EF4AF4323EDF2198986676B60DB586D")
    public boolean isLoopbackAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_55812026 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_55812026;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.313 -0400", hash_original_method = "FDE6DFC941C3F6CDB3A8E59F11467602", hash_generated_method = "55F0CE456D6466A8C7A57080AAA9CC84")
    public boolean isMCGlobal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_220491909 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_220491909;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.313 -0400", hash_original_method = "633857E8ABB2714E861E7CC407521B8A", hash_generated_method = "0797BAE18A7ACB0DBBED5DF33FE94975")
    public boolean isMCLinkLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_895852998 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_895852998;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.313 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "2537EABB11F60963D6C582C69D2092EF")
    public boolean isMCNodeLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1400633899 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1400633899;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.313 -0400", hash_original_method = "8083E84E7FB8B51C8E4E9091B5CE2BBD", hash_generated_method = "8432B77EB7691F15A5C7915620E701D4")
    public boolean isMCOrgLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_787574688 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_787574688;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.314 -0400", hash_original_method = "5286F1AFCB89409D5250A9F370D7AC47", hash_generated_method = "9B39E6D3546533B46B93EAB43B997610")
    public boolean isMCSiteLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_27933923 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_27933923;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.314 -0400", hash_original_method = "93032F84680D1BDFF6DF524AE8984C63", hash_generated_method = "547AE1E6C24D460CD086960D8A1E6D8F")
    public boolean isMulticastAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_965899403 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_965899403;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.314 -0400", hash_original_method = "34E7BECA5A41D39726D6E4A4A4838C8A", hash_generated_method = "DC31856B194A6A910603A7BA5207A7F9")
    public boolean isSiteLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513391450 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_513391450;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.314 -0400", hash_original_method = "C5AA36E6C7DFD1C45750A6D7AE21AFCC", hash_generated_method = "81F923A1D33CAA39D44507B5798753C6")
    public boolean isReachable(int timeout) throws IOException {
        boolean var79CB746A93A3D3E65B7122FECE6F9BB8_1034102872 = (isReachable(null, 0, timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201531937 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201531937;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.322 -0400", hash_original_method = "A1A0F0207714140D12E9E4AE2187615D", hash_generated_method = "45D7529510DDE4EC0BB6EB7BAE79A180")
    public boolean isReachable(NetworkInterface networkInterface, final int ttl, final int timeout) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ttl < 0 || timeout < 0");
        } 
        {
            boolean varE90BF27773AA71DDBE5F32BAE585508C_1598869420 = (isReachable(this, null, timeout));
        } 
        List<InetAddress> sourceAddresses = Collections.list(networkInterface.getInetAddresses());
        {
            boolean var62C2047A8A14391C51272AF278381770_1928047546 = (sourceAddresses.isEmpty());
        } 
        final InetAddress destinationAddress = this;
        final CountDownLatch latch = new CountDownLatch(sourceAddresses.size());
        final AtomicBoolean isReachable = new AtomicBoolean(false);
        {
            Iterator<InetAddress> varBD264B6AB6F51D0C5A90F893347FF495_1517953380 = (sourceAddresses).iterator();
            varBD264B6AB6F51D0C5A90F893347FF495_1517953380.hasNext();
            final InetAddress sourceAddress = varBD264B6AB6F51D0C5A90F893347FF495_1517953380.next();
            {
                new Thread() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.322 -0400", hash_original_method = "B701C9C990A30C345CD440F261C9D387", hash_generated_method = "967801C6C64B4F69F530D03EC1271971")
                    @Override
                    public void run() {
                        try 
                        {
                            {
                                boolean var41C8F9D0A375DDBE03CBB8B034FCFB59_1213764672 = (isReachable(destinationAddress, sourceAddress, timeout));
                                {
                                    isReachable.set(true);
                                    {
                                        boolean var8847E7E96F1F56F28816D013D8F8553D_753670740 = (latch.getCount() > 0);
                                        {
                                            latch.countDown();
                                        } 
                                    } 
                                } 
                            } 
                        } 
                        catch (IOException ignored)
                        { }
                        latch.countDown();
                        
                        
                        
                            
                            
                                
                            
                        
                    
                    
                        
                    }
}.start();
            } 
        } 
        try 
        {
            latch.await();
        } 
        catch (InterruptedException ignored)
        {
            Thread.currentThread().interrupt();
        } 
        boolean varA1124C2A3F7643822A53302B8D28AC66_650536437 = (isReachable.get());
        addTaint(networkInterface.getTaint());
        addTaint(ttl);
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_511676818 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_511676818;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.323 -0400", hash_original_method = "296F60C65F61166BD9A8DF4CB4E70272", hash_generated_method = "3206BF0F24AC02C1C2BBE0EDD22293AF")
    private boolean isReachable(InetAddress destination, InetAddress source, int timeout) throws IOException {
        FileDescriptor fd = IoBridge.socket(true);
        boolean reached = false;
        try 
        {
            {
                IoBridge.bind(fd, source, 0);
            } 
            IoBridge.connect(fd, destination, 7, timeout);
            reached = true;
        } 
        catch (IOException e)
        {
            {
                boolean varF7A18AD86880F63E4E9705AC2F05468E_443201510 = (e.getCause() instanceof ErrnoException);
                {
                    reached = (((ErrnoException) e.getCause()).errno == ECONNREFUSED);
                } 
            } 
        } 
        IoBridge.closeSocket(fd);
        addTaint(destination.getTaint());
        addTaint(source.getTaint());
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1752999150 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1752999150;
        
        
        
        
            
                
            
            
            
        
            
                
            
        
        
        
    }

    
        @DSModeled(DSC.SAFE)
    public static InetAddress getByAddress(byte[] ipAddress) throws UnknownHostException {
        return getByAddress(null, ipAddress, 0);
    }

    
        @DSModeled(DSC.SAFE)
    public static InetAddress getByAddress(String hostName, byte[] ipAddress) throws UnknownHostException {
        return getByAddress(hostName, ipAddress, 0);
    }

    
        @DSModeled(DSC.SAFE)
    private static InetAddress getByAddress(String hostName, byte[] ipAddress, int scopeId) throws UnknownHostException {
        if (ipAddress == null) {
            throw new UnknownHostException("ipAddress == null");
        }
        if (ipAddress.length == 4) {
            return new Inet4Address(ipAddress.clone(), hostName);
        } else if (ipAddress.length == 16) {
            if (isIPv4MappedAddress(ipAddress)) {
                return new Inet4Address(ipv4MappedToIPv4(ipAddress), hostName);
            } else {
                return new Inet6Address(ipAddress.clone(), hostName, scopeId);
            }
        } else {
            throw badAddressLength(ipAddress);
        }
    }

    
        @DSModeled(DSC.SAFE)
    private static UnknownHostException badAddressLength(byte[] bytes) throws UnknownHostException {
        throw new UnknownHostException("Address is neither 4 or 16 bytes: " + Arrays.toString(bytes));
    }

    
        @DSModeled(DSC.SAFE)
    private static boolean isIPv4MappedAddress(byte[] ipAddress) {
        if (ipAddress == null || ipAddress.length != 16) {
            return false;
        }
        for (int i = 0; i < 10; i++) {
            if (ipAddress[i] != 0) {
                return false;
            }
        }
        if (ipAddress[10] != -1 || ipAddress[11] != -1) {
            return false;
        }
        return true;
    }

    
        @DSModeled(DSC.SAFE)
    private static byte[] ipv4MappedToIPv4(byte[] mappedAddress) {
        byte[] ipv4Address = new byte[4];
        for (int i = 0; i < 4; i++) {
            ipv4Address[i] = mappedAddress[12 + i];
        }
        return ipv4Address;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.325 -0400", hash_original_method = "EA85F511D24184DD59F5742DCBE8C620", hash_generated_method = "A6374255963FDB94D51B73B315AA2E2B")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        {
            fields.put("address", 0);
        } 
        {
            fields.put("address", Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN));
        } 
        fields.put("family", family);
        fields.put("hostName", hostName);
        stream.writeFields();
        addTaint(stream.getTaint());
        
        
        
            
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.325 -0400", hash_original_method = "8E54F0F7AE1E424107F71EAAF0F6F90C", hash_generated_method = "B00FBD496D915F53997BCB065006CF22")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        int addr = fields.get("address", 0);
        ipaddress = new byte[4];
        Memory.pokeInt(ipaddress, 0, addr, ByteOrder.BIG_ENDIAN);
        hostName = (String) fields.get("hostName", null);
        family = fields.get("family", 2);
        addTaint(stream.getTaint());
        
        
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.325 -0400", hash_original_method = "08DCB3CBD406BD7814E8362202DC0D50", hash_generated_method = "CD0DAE8C04F35CE92D5A12BCD8002279")
    private Object readResolve() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_652245341 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_652245341 = new Inet4Address(ipaddress, hostName);
        varB4EAC82CA7396A68D541C85D26508E83_652245341.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_652245341;
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.326 -0400", hash_original_field = "06D3EFD07AE631BF7A16FDDC7793B09D", hash_generated_field = "B26AF2805292D25D065DC27D7F380542")

    private static final AddressCache addressCache = new AddressCache();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.326 -0400", hash_original_field = "6457221FED36AEA41AF6CB769203E35C", hash_generated_field = "D810DA6D1E5ECCA9B74B4757EAD39B08")

    private static final long serialVersionUID = 3286316764910316507L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.326 -0400", hash_original_field = "AD70106DDC81CA0C32DA24B6870F6537", hash_generated_field = "119C92FDA430C8C47E72137BCDA943A4")

    public static final InetAddress UNSPECIFIED = new InetAddress(AF_UNSPEC, null, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.326 -0400", hash_original_field = "56295EAA1211F6276AB88DEF534334A7", hash_generated_field = "550C29BECD712FE70617B34B15180466")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("address", int.class),
        new ObjectStreamField("family", int.class),
        new ObjectStreamField("hostName", String.class),
    };
}

