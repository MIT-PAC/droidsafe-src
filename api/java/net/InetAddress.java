package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import static libcore.io.OsConstants.AF_INET;
import static libcore.io.OsConstants.AF_UNSPEC;
import static libcore.io.OsConstants.AI_ADDRCONFIG;
import static libcore.io.OsConstants.AI_NUMERICHOST;
import static libcore.io.OsConstants.ECONNREFUSED;
import static libcore.io.OsConstants.NI_NAMEREQD;
import static libcore.io.OsConstants.NI_NUMERICHOST;
import static libcore.io.OsConstants.SOCK_STREAM;

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
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

import libcore.io.ErrnoException;
import libcore.io.GaiException;
import libcore.io.IoBridge;
import libcore.io.Libcore;
import libcore.io.Memory;
import libcore.io.StructAddrinfo;
import dalvik.system.BlockGuard;





public class InetAddress implements Serializable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.661 -0400", hash_original_field = "0D3FDA0BDBB9D619E09CDF3EECBA7999", hash_generated_field = "630495C0099FA460C912B67A0FCAD3C7")

    private int family;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.662 -0400", hash_original_field = "59FBC8DF7B0BEA3A26A2FB6771EA3EEE", hash_generated_field = "90EA25AB4D338372155DC6F7EC59D04E")

    byte[] ipaddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.662 -0400", hash_original_field = "018531A6FE3834353217DBF6A6634DCF", hash_generated_field = "1B7A53B08CE768344D84B69A12503624")

    String hostName;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.662 -0400", hash_original_method = "D743789B4770A2F65AD981CCEDC5E9F2", hash_generated_method = "2E1DC10CC44AF4781FBC49399E601EDD")
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.663 -0400", hash_original_method = "3AAFCD043D3971ACCC1BC5F122FB0BE0", hash_generated_method = "8578B44AA7D63D8DF7C3B920CE127189")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(!(obj instanceof InetAddress))        
        {
            boolean var68934A3E9455FA72420237EB05902327_2139307428 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_72382054 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_72382054;
        } //End block
        boolean varC5E9D453415357B813701C1D86581040_528788479 = (Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_881155724 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_881155724;
        // ---------- Original Method ----------
        //if (!(obj instanceof InetAddress)) {
            //return false;
        //}
        //return Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.663 -0400", hash_original_method = "0983A0B23668071C038C0A3F8002A354", hash_generated_method = "9E2FC56FBAAA68AAC5D3FB1961F045CE")
    public byte[] getAddress() {
        byte[] varDAA91FF7D217FFDF2AB7DA6C0DDE0182_648665031 = (ipaddress.clone());
                byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_953314817 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_953314817;
        // ---------- Original Method ----------
        //return ipaddress.clone();
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    private static InetAddress makeInetAddress(byte[] bytes, String hostName) throws UnknownHostException {
        if (bytes.length == 4) {
            return new Inet4Address(bytes, hostName);
        } else if (bytes.length == 16) {
            return new Inet6Address(bytes, hostName, 0);
        } else {
            throw badAddressLength(bytes);
        }
    }

    
    @DSModeled(DSC.BAN)
    private static InetAddress disallowDeprecatedFormats(String address, InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet4Address) || address.indexOf(':') != -1) {
            return inetAddress;
        }
        return Libcore.os.inet_pton(AF_INET, address);
    }

    
    @DSModeled(DSC.BAN)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.664 -0400", hash_original_method = "A1139ABF91D0374599D7EB888F5DB646", hash_generated_method = "C51CA9727451D63506C79686D475A13C")
    public String getHostAddress() {
String var838FEAF92DF51A1B9F4858C49A1A49FB_51188697 =         Libcore.os.getnameinfo(this, NI_NUMERICHOST);
        var838FEAF92DF51A1B9F4858C49A1A49FB_51188697.addTaint(taint);
        return var838FEAF92DF51A1B9F4858C49A1A49FB_51188697;
        // ---------- Original Method ----------
        //return Libcore.os.getnameinfo(this, NI_NUMERICHOST);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.664 -0400", hash_original_method = "4F443763E78EE7A4BDC306A79DFCDBBC", hash_generated_method = "8B4A40B063B7310B1216CC82DB4F0576")
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
String varC40F9E8A38603ED931114F963CC6797A_2034643983 =         hostName;
        varC40F9E8A38603ED931114F963CC6797A_2034643983.addTaint(taint);
        return varC40F9E8A38603ED931114F963CC6797A_2034643983;
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.665 -0400", hash_original_method = "A5A62CAEFD7FCA56AB200DB74BB59546", hash_generated_method = "03893258F835C3EE2AA610C1E218F16F")
    public String getCanonicalHostName() {
        try 
        {
String var11FDBC95F966A5128D2BAA13EED30FE6_1634082492 =             getHostByAddrImpl(this).hostName;
            var11FDBC95F966A5128D2BAA13EED30FE6_1634082492.addTaint(taint);
            return var11FDBC95F966A5128D2BAA13EED30FE6_1634082492;
        } //End block
        catch (UnknownHostException ex)
        {
String varE0844D2E3199657F6D45A77AB24C4989_1837194654 =             getHostAddress();
            varE0844D2E3199657F6D45A77AB24C4989_1837194654.addTaint(taint);
            return varE0844D2E3199657F6D45A77AB24C4989_1837194654;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return getHostByAddrImpl(this).hostName;
        //} catch (UnknownHostException ex) {
            //return getHostAddress();
        //}
    }

    
    @DSModeled(DSC.SAFE)
    public static InetAddress getLocalHost() throws UnknownHostException {
        String host = Libcore.os.uname().nodename;
        return lookupHostByName(host)[0];
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.665 -0400", hash_original_method = "70D58F36ADD2B32D6B4870D6C7A22922", hash_generated_method = "99798F526E52A5134FCA2A0E874F38D7")
    @Override
    public int hashCode() {
        int varF86830CDF0B20C65856183AD3D3D6BE7_100830051 = (Arrays.hashCode(ipaddress));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694831543 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_694831543;
        // ---------- Original Method ----------
        //return Arrays.hashCode(ipaddress);
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    public static void clearDnsCache() {
        addressCache.clear();
    }

    
    @DSModeled(DSC.BAN)
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
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.666 -0400", hash_original_method = "0306D8C3E43590D820E89D43080D7C82", hash_generated_method = "29290121845C111166BE7B49D63EE3D6")
    @Override
    public String toString() {
String varB06D9EDD0D0090AFCAB701EB4BB083B1_937533407 =         (hostName == null ? "" : hostName) + "/" + getHostAddress();
        varB06D9EDD0D0090AFCAB701EB4BB083B1_937533407.addTaint(taint);
        return varB06D9EDD0D0090AFCAB701EB4BB083B1_937533407;
        // ---------- Original Method ----------
        //return (hostName == null ? "" : hostName) + "/" + getHostAddress();
    }

    
    @DSModeled(DSC.BAN)
    public static boolean isNumeric(String address) {
        InetAddress inetAddress = parseNumericAddressNoThrow(address);
        return inetAddress != null && disallowDeprecatedFormats(address, inetAddress) != null;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    private static InetAddress[] loopbackAddresses() {
        return new InetAddress[] { Inet6Address.LOOPBACK, Inet4Address.LOOPBACK };
    }

    
    @DSModeled(DSC.BAN)
    public static InetAddress getLoopbackAddress() {
        return Inet6Address.LOOPBACK;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.666 -0400", hash_original_method = "0DFB661E6E123FAAEACDB840E13652D3", hash_generated_method = "D9D7E0D2FD3FC28D6631103DB5F805BA")
    public boolean isAnyLocalAddress() {
        boolean var68934A3E9455FA72420237EB05902327_206774712 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1430180122 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1430180122;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.666 -0400", hash_original_method = "C2C85D69F5C8114C53B505B2C48FBA38", hash_generated_method = "740D74C923CFA23AFDCE4F5929703381")
    public boolean isLinkLocalAddress() {
        boolean var68934A3E9455FA72420237EB05902327_129636507 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1324864630 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1324864630;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.667 -0400", hash_original_method = "F4A838CB0E6897A23081D395162E9DA1", hash_generated_method = "758836C35D037936F58ADA31D8726D84")
    public boolean isLoopbackAddress() {
        boolean var68934A3E9455FA72420237EB05902327_731995139 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1736302551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1736302551;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.667 -0400", hash_original_method = "FDE6DFC941C3F6CDB3A8E59F11467602", hash_generated_method = "1A62EE342B1862D426984B23EE568E24")
    public boolean isMCGlobal() {
        boolean var68934A3E9455FA72420237EB05902327_652690273 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_776838796 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_776838796;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.667 -0400", hash_original_method = "633857E8ABB2714E861E7CC407521B8A", hash_generated_method = "D5D0D9EE60C9FFE0CE02009CD372439C")
    public boolean isMCLinkLocal() {
        boolean var68934A3E9455FA72420237EB05902327_865400839 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_346594033 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_346594033;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.667 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "E24CEF2AA1B1AAF712295492483D853D")
    public boolean isMCNodeLocal() {
        boolean var68934A3E9455FA72420237EB05902327_133319530 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1493579664 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1493579664;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.667 -0400", hash_original_method = "8083E84E7FB8B51C8E4E9091B5CE2BBD", hash_generated_method = "0A939C7D2CBF6EAB774D01DFC96F4649")
    public boolean isMCOrgLocal() {
        boolean var68934A3E9455FA72420237EB05902327_1956373358 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_625391311 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_625391311;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.667 -0400", hash_original_method = "5286F1AFCB89409D5250A9F370D7AC47", hash_generated_method = "CFFB06B1987A18A072A003C4689F8FF2")
    public boolean isMCSiteLocal() {
        boolean var68934A3E9455FA72420237EB05902327_554918289 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1658655572 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1658655572;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.667 -0400", hash_original_method = "93032F84680D1BDFF6DF524AE8984C63", hash_generated_method = "D063A9F73F1EBA2DD8AC154C0C847EC0")
    public boolean isMulticastAddress() {
        boolean var68934A3E9455FA72420237EB05902327_1881698689 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1916097160 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1916097160;
        // ---------- Original Method ----------
        //return false;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.667 -0400", hash_original_method = "34E7BECA5A41D39726D6E4A4A4838C8A", hash_generated_method = "30CD3A4192413806EAC652D7D45EC4E1")
    public boolean isSiteLocalAddress() {
        boolean var68934A3E9455FA72420237EB05902327_632040383 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_60081382 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_60081382;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.667 -0400", hash_original_method = "C5AA36E6C7DFD1C45750A6D7AE21AFCC", hash_generated_method = "BCDBBA550D0DF4324A76C6900000A3AD")
    public boolean isReachable(int timeout) throws IOException {
        addTaint(timeout);
        boolean varCAFF3DA9FA51F8EDB46919292BA58294_334860926 = (isReachable(null, 0, timeout));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_207626950 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_207626950;
        // ---------- Original Method ----------
        //return isReachable(null, 0, timeout);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.669 -0400", hash_original_method = "296F60C65F61166BD9A8DF4CB4E70272", hash_generated_method = "3735180CC123ED5B80CD4FD6CB42D170")
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
        boolean varF910FF3A8628EBDA9C67ED678703FD7D_2011923710 = (reached);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1090826269 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1090826269;
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

    
    @DSModeled(DSC.SAFE)
    public static InetAddress getByAddress(String hostName, byte[] ipAddress) throws UnknownHostException {
        return getByAddress(hostName, ipAddress, 0);
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    private static UnknownHostException badAddressLength(byte[] bytes) throws UnknownHostException {
        throw new UnknownHostException("Address is neither 4 or 16 bytes: " + Arrays.toString(bytes));
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
    private static byte[] ipv4MappedToIPv4(byte[] mappedAddress) {
        byte[] ipv4Address = new byte[4];
        for (int i = 0; i < 4; i++) {
            ipv4Address[i] = mappedAddress[12 + i];
        }
        return ipv4Address;
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.670 -0400", hash_original_method = "EA85F511D24184DD59F5742DCBE8C620", hash_generated_method = "83A9B893A905C564398789A8BC9F3B76")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.670 -0400", hash_original_method = "8E54F0F7AE1E424107F71EAAF0F6F90C", hash_generated_method = "272B148085B5A64AE6603FF5D112E1D3")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.670 -0400", hash_original_method = "08DCB3CBD406BD7814E8362202DC0D50", hash_generated_method = "EFAEFD7616AC948ED0A11726BE0068DD")
    private Object readResolve() throws ObjectStreamException {
Object var018746D7CDD66E0C0F2B4CEA8F394772_156095607 =         new Inet4Address(ipaddress, hostName);
        var018746D7CDD66E0C0F2B4CEA8F394772_156095607.addTaint(taint);
        return var018746D7CDD66E0C0F2B4CEA8F394772_156095607;
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.670 -0400", hash_original_field = "06D3EFD07AE631BF7A16FDDC7793B09D", hash_generated_field = "B26AF2805292D25D065DC27D7F380542")

    private static final AddressCache addressCache = new AddressCache();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.671 -0400", hash_original_field = "6457221FED36AEA41AF6CB769203E35C", hash_generated_field = "D810DA6D1E5ECCA9B74B4757EAD39B08")

    private static final long serialVersionUID = 3286316764910316507L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.671 -0400", hash_original_field = "AD70106DDC81CA0C32DA24B6870F6537", hash_generated_field = "119C92FDA430C8C47E72137BCDA943A4")

    public static final InetAddress UNSPECIFIED = new InetAddress(AF_UNSPEC, null, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.671 -0400", hash_original_field = "56295EAA1211F6276AB88DEF534334A7", hash_generated_field = "550C29BECD712FE70617B34B15180466")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("address", int.class),
        new ObjectStreamField("family", int.class),
        new ObjectStreamField("hostName", String.class),
    };
}

