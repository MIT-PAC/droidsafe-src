package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
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
    private int family;
    byte[] ipaddress;
    String hostName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.873 -0400", hash_original_method = "D743789B4770A2F65AD981CCEDC5E9F2", hash_generated_method = "8A8A36A4EBAE3254A151FD55A87554D5")
    @DSModeled(DSC.SAFE)
     InetAddress(int family, byte[] ipaddress, String hostName) {
        dsTaint.addTaint(family);
        dsTaint.addTaint(hostName);
        dsTaint.addTaint(ipaddress[0]);
        // ---------- Original Method ----------
        //this.family = family;
        //this.ipaddress = ipaddress;
        //this.hostName = hostName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.874 -0400", hash_original_method = "3AAFCD043D3971ACCC1BC5F122FB0BE0", hash_generated_method = "DCA2B641690D2F402E3F7B8DB5C62E2B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        boolean var736C841577D8C25E47C4A18B061F61D3_1297592287 = (Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(obj instanceof InetAddress)) {
            //return false;
        //}
        //return Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.874 -0400", hash_original_method = "0983A0B23668071C038C0A3F8002A354", hash_generated_method = "C965572AFC559796A4C41E30004C627B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getAddress() {
        byte[] var2347CEE6C132BC5594CEE5BBD0F30A9A_1505553716 = (ipaddress.clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.875 -0400", hash_original_method = "A1139ABF91D0374599D7EB888F5DB646", hash_generated_method = "7FA71F85825D47E06F61D9F076936B59")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHostAddress() {
        String var0E380FC3360C8D458EA12B91EF7DDC01_87492876 = (Libcore.os.getnameinfo(this, NI_NUMERICHOST));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Libcore.os.getnameinfo(this, NI_NUMERICHOST);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.875 -0400", hash_original_method = "4F443763E78EE7A4BDC306A79DFCDBBC", hash_generated_method = "5173E0D8CF0122D51452D090191F325E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHostName() {
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
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.875 -0400", hash_original_method = "A5A62CAEFD7FCA56AB200DB74BB59546", hash_generated_method = "8EC14FCAB85F1A38B5E790952640C5FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCanonicalHostName() {
        try 
        {
            String var458502783EE6656EC089C4CA0AEE7E93_2047595589 = (getHostByAddrImpl(this).hostName);
        } //End block
        catch (UnknownHostException ex)
        {
            String var7EC7536219943C3F11F282FF183651CB_475598506 = (getHostAddress());
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.876 -0400", hash_original_method = "70D58F36ADD2B32D6B4870D6C7A22922", hash_generated_method = "2188BA75F1F1B62D8C275DC5B208FC69")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var7810AFBE6CE34C4D0D867B5084406399_2032479646 = (Arrays.hashCode(ipaddress));
        return dsTaint.getTaintInt();
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

    
        private static InetAddress getHostByAddrImpl(InetAddress address) throws UnknownHostException {
        BlockGuard.getThreadPolicy().onNetwork();
        try {
            String hostname = Libcore.os.getnameinfo(address, NI_NAMEREQD);
            return makeInetAddress(address.ipaddress.clone(), hostname);
        } catch (GaiException gaiException) {
            throw gaiException.rethrowAsUnknownHostException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.876 -0400", hash_original_method = "0306D8C3E43590D820E89D43080D7C82", hash_generated_method = "A2CFF878DB4FC1F439EF10C7529A515F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var922B49EAB65266BF3D56B9861CB06013_5564767 = ((hostName == null ? "" : hostName) + "/" + getHostAddress()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
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

    
        private static InetAddress[] loopbackAddresses() {
        return new InetAddress[] { Inet6Address.LOOPBACK, Inet4Address.LOOPBACK };
    }

    
        public static InetAddress getLoopbackAddress() {
        return Inet6Address.LOOPBACK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.877 -0400", hash_original_method = "0DFB661E6E123FAAEACDB840E13652D3", hash_generated_method = "5C80A506BF20F69CCEA976545E8ECB08")
    @DSModeled(DSC.SAFE)
    public boolean isAnyLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.877 -0400", hash_original_method = "C2C85D69F5C8114C53B505B2C48FBA38", hash_generated_method = "8CB3ED27AC3ED132BC2451E542B749E0")
    @DSModeled(DSC.SAFE)
    public boolean isLinkLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.877 -0400", hash_original_method = "F4A838CB0E6897A23081D395162E9DA1", hash_generated_method = "9D5FA8BAA6CBDF8A280C3087D5569D77")
    @DSModeled(DSC.SAFE)
    public boolean isLoopbackAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.877 -0400", hash_original_method = "FDE6DFC941C3F6CDB3A8E59F11467602", hash_generated_method = "C5526ED549E52358C2014BD0C1AE30F8")
    @DSModeled(DSC.SAFE)
    public boolean isMCGlobal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.877 -0400", hash_original_method = "633857E8ABB2714E861E7CC407521B8A", hash_generated_method = "676AD1CFCC7113DBEA0FF5A003918D93")
    @DSModeled(DSC.SAFE)
    public boolean isMCLinkLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.878 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "520A3477B9010B759F32B7E36F6D82FB")
    @DSModeled(DSC.SAFE)
    public boolean isMCNodeLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.878 -0400", hash_original_method = "8083E84E7FB8B51C8E4E9091B5CE2BBD", hash_generated_method = "7A965C2C9E89A29EFF3B967F2CFDF48B")
    @DSModeled(DSC.SAFE)
    public boolean isMCOrgLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.878 -0400", hash_original_method = "5286F1AFCB89409D5250A9F370D7AC47", hash_generated_method = "4DB170A74DA593F61F44AF8B98653396")
    @DSModeled(DSC.SAFE)
    public boolean isMCSiteLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.878 -0400", hash_original_method = "93032F84680D1BDFF6DF524AE8984C63", hash_generated_method = "7AA65F80B0B4AC3873D57A992DC662BA")
    @DSModeled(DSC.SAFE)
    public boolean isMulticastAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.878 -0400", hash_original_method = "34E7BECA5A41D39726D6E4A4A4838C8A", hash_generated_method = "A4A5B76452E5E4A6A4FD34F98BBED05C")
    @DSModeled(DSC.SAFE)
    public boolean isSiteLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.879 -0400", hash_original_method = "C5AA36E6C7DFD1C45750A6D7AE21AFCC", hash_generated_method = "162E6772DAB2FDD3DA67CD058C96D776")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReachable(int timeout) throws IOException {
        dsTaint.addTaint(timeout);
        boolean var79CB746A93A3D3E65B7122FECE6F9BB8_532268080 = (isReachable(null, 0, timeout));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isReachable(null, 0, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.888 -0400", hash_original_method = "A1A0F0207714140D12E9E4AE2187615D", hash_generated_method = "326252D6D24931FB747E9CEE9D32A0A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReachable(NetworkInterface networkInterface, final int ttl, final int timeout) throws IOException {
        dsTaint.addTaint(networkInterface.dsTaint);
        dsTaint.addTaint(ttl);
        dsTaint.addTaint(timeout);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ttl < 0 || timeout < 0");
        } //End block
        {
            boolean varE90BF27773AA71DDBE5F32BAE585508C_295716568 = (isReachable(this, null, timeout));
        } //End block
        List<InetAddress> sourceAddresses;
        sourceAddresses = Collections.list(networkInterface.getInetAddresses());
        {
            boolean var62C2047A8A14391C51272AF278381770_1354201076 = (sourceAddresses.isEmpty());
        } //End collapsed parenthetic
        InetAddress destinationAddress;
        destinationAddress = this;
        CountDownLatch latch;
        latch = new CountDownLatch(sourceAddresses.size());
        AtomicBoolean isReachable;
        isReachable = new AtomicBoolean(false);
        {
            Iterator<InetAddress> varBD264B6AB6F51D0C5A90F893347FF495_2034602331 = (sourceAddresses).iterator();
            varBD264B6AB6F51D0C5A90F893347FF495_2034602331.hasNext();
            final InetAddress sourceAddress = varBD264B6AB6F51D0C5A90F893347FF495_2034602331.next();
            {
                new Thread() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.888 -0400", hash_original_method = "B701C9C990A30C345CD440F261C9D387", hash_generated_method = "515E2C4043735922C4DBDF5BEDA72516")
                    //DSFIXME:  CODE0002: Requires DSC value to be set
                    @Override
                    public void run() {
                        try 
                        {
                            {
                                boolean var41C8F9D0A375DDBE03CBB8B034FCFB59_132081453 = (isReachable(destinationAddress, sourceAddress, timeout));
                                {
                                    isReachable.set(true);
                                    {
                                        boolean var8847E7E96F1F56F28816D013D8F8553D_1413340503 = (latch.getCount() > 0);
                                        {
                                            latch.countDown();
                                        } //End block
                                    } //End collapsed parenthetic
                                } //End block
                            } //End collapsed parenthetic
                        } //End block
                        catch (IOException ignored)
                        { }
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
        } //End collapsed parenthetic
        try 
        {
            latch.await();
        } //End block
        catch (InterruptedException ignored)
        {
            Thread.currentThread().interrupt();
        } //End block
        boolean varA1124C2A3F7643822A53302B8D28AC66_1319553604 = (isReachable.get());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.888 -0400", hash_original_method = "296F60C65F61166BD9A8DF4CB4E70272", hash_generated_method = "493DE96E9B9E28E2977E587D70AEA930")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean isReachable(InetAddress destination, InetAddress source, int timeout) throws IOException {
        dsTaint.addTaint(source.dsTaint);
        dsTaint.addTaint(timeout);
        dsTaint.addTaint(destination.dsTaint);
        FileDescriptor fd;
        fd = IoBridge.socket(true);
        boolean reached;
        reached = false;
        try 
        {
            {
                IoBridge.bind(fd, source, 0);
            } //End block
            IoBridge.connect(fd, destination, 7, timeout);
            reached = true;
        } //End block
        catch (IOException e)
        {
            {
                boolean varF7A18AD86880F63E4E9705AC2F05468E_527863755 = (e.getCause() instanceof ErrnoException);
                {
                    reached = (((ErrnoException) e.getCause()).errno == ECONNREFUSED);
                } //End block
            } //End collapsed parenthetic
        } //End block
        IoBridge.closeSocket(fd);
        return dsTaint.getTaintBoolean();
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

    
        private static UnknownHostException badAddressLength(byte[] bytes) throws UnknownHostException {
        throw new UnknownHostException("Address is neither 4 or 16 bytes: " + Arrays.toString(bytes));
    }

    
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

    
        private static byte[] ipv4MappedToIPv4(byte[] mappedAddress) {
        byte[] ipv4Address = new byte[4];
        for (int i = 0; i < 4; i++) {
            ipv4Address[i] = mappedAddress[12 + i];
        }
        return ipv4Address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.890 -0400", hash_original_method = "EA85F511D24184DD59F5742DCBE8C620", hash_generated_method = "4537D911417B6AA12089F40D271AAA8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        {
            fields.put("address", 0);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.891 -0400", hash_original_method = "8E54F0F7AE1E424107F71EAAF0F6F90C", hash_generated_method = "F0B91659BD864201ADEF42331BB89239")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        int addr;
        addr = fields.get("address", 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.891 -0400", hash_original_method = "08DCB3CBD406BD7814E8362202DC0D50", hash_generated_method = "976FD1073810400DE19787BA1F8E400D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Object readResolve() throws ObjectStreamException {
        Object varDDF12B0D9770160307F932778BB004F2_1143635343 = (new Inet4Address(ipaddress, hostName));
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
    private static final AddressCache addressCache = new AddressCache();
    private static final long serialVersionUID = 3286316764910316507L;
    public static final InetAddress UNSPECIFIED = new InetAddress(AF_UNSPEC, null, null);
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("address", int.class),
        new ObjectStreamField("family", int.class),
        new ObjectStreamField("hostName", String.class),
    };
}

