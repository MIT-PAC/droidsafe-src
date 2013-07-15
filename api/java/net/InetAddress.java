package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.757 -0400", hash_original_field = "0D3FDA0BDBB9D619E09CDF3EECBA7999", hash_generated_field = "630495C0099FA460C912B67A0FCAD3C7")

    private int family;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.757 -0400", hash_original_field = "59FBC8DF7B0BEA3A26A2FB6771EA3EEE", hash_generated_field = "90EA25AB4D338372155DC6F7EC59D04E")

    byte[] ipaddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.757 -0400", hash_original_field = "018531A6FE3834353217DBF6A6634DCF", hash_generated_field = "1B7A53B08CE768344D84B69A12503624")

    String hostName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.758 -0400", hash_original_method = "D743789B4770A2F65AD981CCEDC5E9F2", hash_generated_method = "2E1DC10CC44AF4781FBC49399E601EDD")
      InetAddress(int family, byte[] ipaddress, String hostName) {
        this.family = family;
        this.ipaddress = ipaddress;
        this.hostName = hostName;
        // ---------- Original Method ----------
        //this.family = family;
        //this.ipaddress = ipaddress;
        //this.hostName = hostName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.759 -0400", hash_original_method = "3AAFCD043D3971ACCC1BC5F122FB0BE0", hash_generated_method = "DA8BF92A0D2896E83523E79D1B2DBFF5")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
    if(!(obj instanceof InetAddress))        
        {
            boolean var68934A3E9455FA72420237EB05902327_449920298 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1276535714 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1276535714;
        } //End block
        boolean varC5E9D453415357B813701C1D86581040_1008659251 = (Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1277870254 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1277870254;
        // ---------- Original Method ----------
        //if (!(obj instanceof InetAddress)) {
            //return false;
        //}
        //return Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.759 -0400", hash_original_method = "0983A0B23668071C038C0A3F8002A354", hash_generated_method = "9A021208407259391B517769258CCEE9")
    public byte[] getAddress() {
        byte[] varDAA91FF7D217FFDF2AB7DA6C0DDE0182_17081493 = (ipaddress.clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_375797892 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_375797892;
        // ---------- Original Method ----------
        //return ipaddress.clone();
    }

    
        private static InetAddress[] bytesToInetAddresses(byte[][] rawAddresses, String hostName) throws UnknownHostException {
        InetAddress[] returnedAddresses = new InetAddress[rawAddresses.length];
        for (int i = 0; i < rawAddresses.length; i++) {
            returnedAddresses[i] = makeInetAddress(rawAddresses[i], hostName);
        }
        return returnedAddresses;
    }

    
        public static InetAddress[] getAllByName(String host) throws UnknownHostException {
        return getAllByNameImpl(host).clone();
    }

    
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

    
        public static InetAddress getByName(String host) throws UnknownHostException {
        return getAllByNameImpl(host)[0];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.762 -0400", hash_original_method = "A1139ABF91D0374599D7EB888F5DB646", hash_generated_method = "EC3C8BF4B3342495467EE4B4BE55BDE1")
    public String getHostAddress() {
String var838FEAF92DF51A1B9F4858C49A1A49FB_1244989349 =         Libcore.os.getnameinfo(this, NI_NUMERICHOST);
        var838FEAF92DF51A1B9F4858C49A1A49FB_1244989349.addTaint(taint);
        return var838FEAF92DF51A1B9F4858C49A1A49FB_1244989349;
        // ---------- Original Method ----------
        //return Libcore.os.getnameinfo(this, NI_NUMERICHOST);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.762 -0400", hash_original_method = "4F443763E78EE7A4BDC306A79DFCDBBC", hash_generated_method = "21168C0C5D91C1B9EB68E18F991A968F")
    public String getHostName() {
    if(hostName == null)        
        {
            try 
            {
                hostName = getHostByAddrImpl(this).hostName;
            } //End block
            catch (UnknownHostException ex)
            {
                hostName = getHostAddress();
            } //End block
        } //End block
String varC40F9E8A38603ED931114F963CC6797A_1837727150 =         hostName;
        varC40F9E8A38603ED931114F963CC6797A_1837727150.addTaint(taint);
        return varC40F9E8A38603ED931114F963CC6797A_1837727150;
        // ---------- Original Method ----------
        //if (hostName == null) {
            //try {
                //hostName = getHostByAddrImpl(this).hostName;
            //} catch (UnknownHostException ex) {
                //hostName = getHostAddress();
            //}
        //}
        //return hostName;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.763 -0400", hash_original_method = "A5A62CAEFD7FCA56AB200DB74BB59546", hash_generated_method = "4A4A1A9671E33D3476FCDEE85E27038A")
    public String getCanonicalHostName() {
        try 
        {
String var11FDBC95F966A5128D2BAA13EED30FE6_457707826 =             getHostByAddrImpl(this).hostName;
            var11FDBC95F966A5128D2BAA13EED30FE6_457707826.addTaint(taint);
            return var11FDBC95F966A5128D2BAA13EED30FE6_457707826;
        } //End block
        catch (UnknownHostException ex)
        {
String varE0844D2E3199657F6D45A77AB24C4989_1222459354 =             getHostAddress();
            varE0844D2E3199657F6D45A77AB24C4989_1222459354.addTaint(taint);
            return varE0844D2E3199657F6D45A77AB24C4989_1222459354;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getHostByAddrImpl(this).hostName;
        //} catch (UnknownHostException ex) {
            //return getHostAddress();
        //}
    }

    
        public static InetAddress getLocalHost() throws UnknownHostException {
        String host = Libcore.os.uname().nodename;
        return lookupHostByName(host)[0];
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.764 -0400", hash_original_method = "70D58F36ADD2B32D6B4870D6C7A22922", hash_generated_method = "BD270F74641D0E1D563804D272717403")
    @Override
    public int hashCode() {
        int varF86830CDF0B20C65856183AD3D3D6BE7_1170845869 = (Arrays.hashCode(ipaddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000126805 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2000126805;
        // ---------- Original Method ----------
        //return Arrays.hashCode(ipaddress);
    }

    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.765 -0400", hash_original_method = "0306D8C3E43590D820E89D43080D7C82", hash_generated_method = "4E82E3F534CB16D5211A51E9401DE44C")
    @Override
    public String toString() {
String varB06D9EDD0D0090AFCAB701EB4BB083B1_1380594351 =         (hostName == null ? "" : hostName) + "/" + getHostAddress();
        varB06D9EDD0D0090AFCAB701EB4BB083B1_1380594351.addTaint(taint);
        return varB06D9EDD0D0090AFCAB701EB4BB083B1_1380594351;
        // ---------- Original Method ----------
        //return (hostName == null ? "" : hostName) + "/" + getHostAddress();
    }

    
        public static boolean isNumeric(String address) {
        InetAddress inetAddress = parseNumericAddressNoThrow(address);
        return inetAddress != null && disallowDeprecatedFormats(address, inetAddress) != null;
    }

    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.767 -0400", hash_original_method = "0DFB661E6E123FAAEACDB840E13652D3", hash_generated_method = "B0996EA09346EFE9EDB15656A158F93A")
    public boolean isAnyLocalAddress() {
        boolean var68934A3E9455FA72420237EB05902327_1618394139 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1318110807 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1318110807;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.767 -0400", hash_original_method = "C2C85D69F5C8114C53B505B2C48FBA38", hash_generated_method = "10C82BB865E73FDA6416759671AE132D")
    public boolean isLinkLocalAddress() {
        boolean var68934A3E9455FA72420237EB05902327_264637037 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_861112903 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_861112903;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.768 -0400", hash_original_method = "F4A838CB0E6897A23081D395162E9DA1", hash_generated_method = "C7386E95C6E0A4BE2A2A80F4732F2D53")
    public boolean isLoopbackAddress() {
        boolean var68934A3E9455FA72420237EB05902327_1770659323 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1256093700 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1256093700;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.768 -0400", hash_original_method = "FDE6DFC941C3F6CDB3A8E59F11467602", hash_generated_method = "EE24349BFCCA6AA7F2C00208F89623F6")
    public boolean isMCGlobal() {
        boolean var68934A3E9455FA72420237EB05902327_420798005 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1287042347 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1287042347;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.769 -0400", hash_original_method = "633857E8ABB2714E861E7CC407521B8A", hash_generated_method = "F66A17A2949E6A157382BB697DAF57FC")
    public boolean isMCLinkLocal() {
        boolean var68934A3E9455FA72420237EB05902327_1902142239 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_44210175 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_44210175;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.769 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "D617CCCC520FA76DFB6ED98E3D9EE204")
    public boolean isMCNodeLocal() {
        boolean var68934A3E9455FA72420237EB05902327_344705922 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110593648 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_110593648;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.769 -0400", hash_original_method = "8083E84E7FB8B51C8E4E9091B5CE2BBD", hash_generated_method = "96FD070BEE671AC0E81E7DCF12922715")
    public boolean isMCOrgLocal() {
        boolean var68934A3E9455FA72420237EB05902327_173954657 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_975420732 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_975420732;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.770 -0400", hash_original_method = "5286F1AFCB89409D5250A9F370D7AC47", hash_generated_method = "1234705F8475A92EFBA6446B79664AB4")
    public boolean isMCSiteLocal() {
        boolean var68934A3E9455FA72420237EB05902327_2076864295 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2052795956 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2052795956;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.770 -0400", hash_original_method = "93032F84680D1BDFF6DF524AE8984C63", hash_generated_method = "ABF6C4E943CF8A77F983A2DE459189D8")
    public boolean isMulticastAddress() {
        boolean var68934A3E9455FA72420237EB05902327_1554290304 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_839057874 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_839057874;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.771 -0400", hash_original_method = "34E7BECA5A41D39726D6E4A4A4838C8A", hash_generated_method = "AE3A211C586AA94CF8E8F28659BA4155")
    public boolean isSiteLocalAddress() {
        boolean var68934A3E9455FA72420237EB05902327_591445623 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_16431204 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_16431204;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.771 -0400", hash_original_method = "C5AA36E6C7DFD1C45750A6D7AE21AFCC", hash_generated_method = "6458DFCFA9E6E9568AAE1F7DCD9252FE")
    public boolean isReachable(int timeout) throws IOException {
        addTaint(timeout);
        boolean varCAFF3DA9FA51F8EDB46919292BA58294_1380321703 = (isReachable(null, 0, timeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1609877819 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1609877819;
        // ---------- Original Method ----------
        //return isReachable(null, 0, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.773 -0400", hash_original_method = "A1A0F0207714140D12E9E4AE2187615D", hash_generated_method = "DA703A9943F73B00CF0C811D2AFDC4FE")
    public boolean isReachable(NetworkInterface networkInterface, final int ttl, final int timeout) throws IOException {
        addTaint(timeout);
        addTaint(ttl);
        addTaint(networkInterface.getTaint());
    if(ttl < 0 || timeout < 0)        
        {
            IllegalArgumentException var40D35409B98F9E8BB904703A1693CF05_433979614 = new IllegalArgumentException("ttl < 0 || timeout < 0");
            var40D35409B98F9E8BB904703A1693CF05_433979614.addTaint(taint);
            throw var40D35409B98F9E8BB904703A1693CF05_433979614;
        } //End block
    if(networkInterface == null)        
        {
            boolean varB86BAA1C1B0CF97B2EBB38AFE10F09AD_1138132022 = (isReachable(this, null, timeout));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221267299 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_221267299;
        } //End block
        List<InetAddress> sourceAddresses = Collections.list(networkInterface.getInetAddresses());
    if(sourceAddresses.isEmpty())        
        {
            boolean var68934A3E9455FA72420237EB05902327_981190091 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2061619282 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2061619282;
        } //End block
        final InetAddress destinationAddress = this;
        final CountDownLatch latch = new CountDownLatch(sourceAddresses.size());
        final AtomicBoolean isReachable = new AtomicBoolean(false);
for(final InetAddress sourceAddress : sourceAddresses)
        {
            new Thread() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.772 -0400", hash_original_method = "B701C9C990A30C345CD440F261C9D387", hash_generated_method = "9357EB29098C0F6085C6E2354A74E7BA")
        @Override
        public void run() {
            try 
            {
    if(isReachable(destinationAddress, sourceAddress, timeout))                
                {
                    isReachable.set(true);
                    while
(latch.getCount() > 0)                    
                    {
                        latch.countDown();
                    } //End block
                } //End block
            } //End block
            catch (IOException ignored)
            {
            } //End block
            latch.countDown();
            // ---------- Original Method ----------
            //try {
                        //if (isReachable(destinationAddress, sourceAddress, timeout)) {
                            //isReachable.set(true);
                            //while (latch.getCount() > 0) {
                                //latch.countDown();
                            //}
                        //}
                    //} catch (IOException ignored) {
                    //}
            //latch.countDown();
        }
}.start();
        } //End block
        try 
        {
            latch.await();
        } //End block
        catch (InterruptedException ignored)
        {
            Thread.currentThread().interrupt();
        } //End block
        boolean varDB618C60CB26BA9BBAD361D92C0E612B_243901591 = (isReachable.get());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_713818910 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_713818910;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.774 -0400", hash_original_method = "296F60C65F61166BD9A8DF4CB4E70272", hash_generated_method = "5EE3ED06BE93151FD550FAFFCFC3809E")
    private boolean isReachable(InetAddress destination, InetAddress source, int timeout) throws IOException {
        addTaint(timeout);
        addTaint(source.getTaint());
        addTaint(destination.getTaint());
        FileDescriptor fd = IoBridge.socket(true);
        boolean reached = false;
        try 
        {
    if(source != null)            
            {
                IoBridge.bind(fd, source, 0);
            } //End block
            IoBridge.connect(fd, destination, 7, timeout);
            reached = true;
        } //End block
        catch (IOException e)
        {
    if(e.getCause() instanceof ErrnoException)            
            {
                reached = (((ErrnoException) e.getCause()).errno == ECONNREFUSED);
            } //End block
        } //End block
        IoBridge.closeSocket(fd);
        boolean varF910FF3A8628EBDA9C67ED678703FD7D_2003979269 = (reached);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1666717339 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1666717339;
        // ---------- Original Method ----------
        //FileDescriptor fd = IoBridge.socket(true);
        //boolean reached = false;
        //try {
            //if (source != null) {
                //IoBridge.bind(fd, source, 0);
            //}
            //IoBridge.connect(fd, destination, 7, timeout);
            //reached = true;
        //} catch (IOException e) {
            //if (e.getCause() instanceof ErrnoException) {
                //reached = (((ErrnoException) e.getCause()).errno == ECONNREFUSED);
            //}
        //}
        //IoBridge.closeSocket(fd);
        //return reached;
    }

    
        @DSModeled(DSC.SAFE)
    public static InetAddress getByAddress(byte[] ipAddress) throws UnknownHostException {
        return getByAddress(null, ipAddress, 0);
    }

    
        public static InetAddress getByAddress(String hostName, byte[] ipAddress) throws UnknownHostException {
        return getByAddress(hostName, ipAddress, 0);
    }

    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.779 -0400", hash_original_method = "EA85F511D24184DD59F5742DCBE8C620", hash_generated_method = "83A9B893A905C564398789A8BC9F3B76")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
    if(ipaddress == null)        
        {
            fields.put("address", 0);
        } //End block
        else
        {
            fields.put("address", Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN));
        } //End block
        fields.put("family", family);
        fields.put("hostName", hostName);
        stream.writeFields();
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = stream.putFields();
        //if (ipaddress == null) {
            //fields.put("address", 0);
        //} else {
            //fields.put("address", Memory.peekInt(ipaddress, 0, ByteOrder.BIG_ENDIAN));
        //}
        //fields.put("family", family);
        //fields.put("hostName", hostName);
        //stream.writeFields();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.780 -0400", hash_original_method = "8E54F0F7AE1E424107F71EAAF0F6F90C", hash_generated_method = "272B148085B5A64AE6603FF5D112E1D3")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectInputStream.GetField fields = stream.readFields();
        int addr = fields.get("address", 0);
        ipaddress = new byte[4];
        Memory.pokeInt(ipaddress, 0, addr, ByteOrder.BIG_ENDIAN);
        hostName = (String) fields.get("hostName", null);
        family = fields.get("family", 2);
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = stream.readFields();
        //int addr = fields.get("address", 0);
        //ipaddress = new byte[4];
        //Memory.pokeInt(ipaddress, 0, addr, ByteOrder.BIG_ENDIAN);
        //hostName = (String) fields.get("hostName", null);
        //family = fields.get("family", 2);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.780 -0400", hash_original_method = "08DCB3CBD406BD7814E8362202DC0D50", hash_generated_method = "9FFFF4B0D5036E449FF85CE05B035529")
    private Object readResolve() throws ObjectStreamException {
Object var018746D7CDD66E0C0F2B4CEA8F394772_1000642284 =         new Inet4Address(ipaddress, hostName);
        var018746D7CDD66E0C0F2B4CEA8F394772_1000642284.addTaint(taint);
        return var018746D7CDD66E0C0F2B4CEA8F394772_1000642284;
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.781 -0400", hash_original_field = "06D3EFD07AE631BF7A16FDDC7793B09D", hash_generated_field = "B26AF2805292D25D065DC27D7F380542")

    private static final AddressCache addressCache = new AddressCache();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.781 -0400", hash_original_field = "6457221FED36AEA41AF6CB769203E35C", hash_generated_field = "D810DA6D1E5ECCA9B74B4757EAD39B08")

    private static final long serialVersionUID = 3286316764910316507L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.781 -0400", hash_original_field = "AD70106DDC81CA0C32DA24B6870F6537", hash_generated_field = "119C92FDA430C8C47E72137BCDA943A4")

    public static final InetAddress UNSPECIFIED = new InetAddress(AF_UNSPEC, null, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.781 -0400", hash_original_field = "56295EAA1211F6276AB88DEF534334A7", hash_generated_field = "550C29BECD712FE70617B34B15180466")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("address", int.class),
        new ObjectStreamField("family", int.class),
        new ObjectStreamField("hostName", String.class),
    };
}

