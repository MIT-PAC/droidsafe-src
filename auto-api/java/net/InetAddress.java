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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.591 -0400", hash_original_field = "0D3FDA0BDBB9D619E09CDF3EECBA7999", hash_generated_field = "630495C0099FA460C912B67A0FCAD3C7")

    private int family;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.591 -0400", hash_original_field = "59FBC8DF7B0BEA3A26A2FB6771EA3EEE", hash_generated_field = "90EA25AB4D338372155DC6F7EC59D04E")

    byte[] ipaddress;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.591 -0400", hash_original_field = "018531A6FE3834353217DBF6A6634DCF", hash_generated_field = "1B7A53B08CE768344D84B69A12503624")

    String hostName;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.591 -0400", hash_original_method = "D743789B4770A2F65AD981CCEDC5E9F2", hash_generated_method = "2E1DC10CC44AF4781FBC49399E601EDD")
      InetAddress(int family, byte[] ipaddress, String hostName) {
        this.family = family;
        this.ipaddress = ipaddress;
        this.hostName = hostName;
        // ---------- Original Method ----------
        //this.family = family;
        //this.ipaddress = ipaddress;
        //this.hostName = hostName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.592 -0400", hash_original_method = "3AAFCD043D3971ACCC1BC5F122FB0BE0", hash_generated_method = "609CDECB372B317C8DAAFE9B5D94FCBE")
    @Override
    public boolean equals(Object obj) {
        boolean var736C841577D8C25E47C4A18B061F61D3_458698899 = (Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_693284390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_693284390;
        // ---------- Original Method ----------
        //if (!(obj instanceof InetAddress)) {
            //return false;
        //}
        //return Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.592 -0400", hash_original_method = "0983A0B23668071C038C0A3F8002A354", hash_generated_method = "6E67440A5D1C0959D6C45A693A32D766")
    public byte[] getAddress() {
        byte[] var2347CEE6C132BC5594CEE5BBD0F30A9A_1541741409 = (ipaddress.clone());
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1370666787 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1370666787;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.601 -0400", hash_original_method = "A1139ABF91D0374599D7EB888F5DB646", hash_generated_method = "72454ED2E6800FD9FD028503633DD18A")
    public String getHostAddress() {
        String varB4EAC82CA7396A68D541C85D26508E83_1431218778 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1431218778 = Libcore.os.getnameinfo(this, NI_NUMERICHOST);
        varB4EAC82CA7396A68D541C85D26508E83_1431218778.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1431218778;
        // ---------- Original Method ----------
        //return Libcore.os.getnameinfo(this, NI_NUMERICHOST);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.603 -0400", hash_original_method = "4F443763E78EE7A4BDC306A79DFCDBBC", hash_generated_method = "DE240D8A3F820CCA18B9D3C7C143F041")
    public String getHostName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2003319726 = null; //Variable for return #1
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
        varB4EAC82CA7396A68D541C85D26508E83_2003319726 = hostName;
        varB4EAC82CA7396A68D541C85D26508E83_2003319726.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2003319726;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.626 -0400", hash_original_method = "A5A62CAEFD7FCA56AB200DB74BB59546", hash_generated_method = "CFBFEE050461893DB0F92B9D5A72A8BF")
    public String getCanonicalHostName() {
        String varB4EAC82CA7396A68D541C85D26508E83_519698752 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_305163782 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_519698752 = getHostByAddrImpl(this).hostName;
        } //End block
        catch (UnknownHostException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_305163782 = getHostAddress();
        } //End block
        String varA7E53CE21691AB073D9660D615818899_1148304963; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1148304963 = varB4EAC82CA7396A68D541C85D26508E83_519698752;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1148304963 = varB4EAC82CA7396A68D541C85D26508E83_305163782;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1148304963.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1148304963;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.627 -0400", hash_original_method = "70D58F36ADD2B32D6B4870D6C7A22922", hash_generated_method = "C96B8A563E34751D60D5660E763D5D4D")
    @Override
    public int hashCode() {
        int var7810AFBE6CE34C4D0D867B5084406399_533194378 = (Arrays.hashCode(ipaddress));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058431628 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2058431628;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.628 -0400", hash_original_method = "0306D8C3E43590D820E89D43080D7C82", hash_generated_method = "8DD57079F64AC45A9E37665CFF7DA1D9")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_383573101 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_383573101 = (hostName == null ? "" : hostName) + "/" + getHostAddress();
        varB4EAC82CA7396A68D541C85D26508E83_383573101.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_383573101;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.630 -0400", hash_original_method = "0DFB661E6E123FAAEACDB840E13652D3", hash_generated_method = "11024E59A7A5FBFB39C50B69C6B7A5B9")
    public boolean isAnyLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2059842822 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2059842822;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.630 -0400", hash_original_method = "C2C85D69F5C8114C53B505B2C48FBA38", hash_generated_method = "53E15CD5A3B1C6244C60A42EBA032885")
    public boolean isLinkLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_756707412 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_756707412;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.631 -0400", hash_original_method = "F4A838CB0E6897A23081D395162E9DA1", hash_generated_method = "298A9B644EC6FF510CEE27A5F35CBE3B")
    public boolean isLoopbackAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_397315205 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_397315205;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.631 -0400", hash_original_method = "FDE6DFC941C3F6CDB3A8E59F11467602", hash_generated_method = "55CB2D14F9C779146C7C32CA4F89AC2E")
    public boolean isMCGlobal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_945176426 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_945176426;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.631 -0400", hash_original_method = "633857E8ABB2714E861E7CC407521B8A", hash_generated_method = "1F70CD3C19288A7FF122DA333D6A3091")
    public boolean isMCLinkLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_544585953 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_544585953;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.650 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "D4E7C75005E7A926C710662321837732")
    public boolean isMCNodeLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1104833055 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1104833055;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.651 -0400", hash_original_method = "8083E84E7FB8B51C8E4E9091B5CE2BBD", hash_generated_method = "2D67AD37FDC447AAF42ADAE4BB6F1DC6")
    public boolean isMCOrgLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1397427184 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1397427184;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.651 -0400", hash_original_method = "5286F1AFCB89409D5250A9F370D7AC47", hash_generated_method = "CD7122A6668494785287B10A439AD1B9")
    public boolean isMCSiteLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1773680190 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1773680190;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.651 -0400", hash_original_method = "93032F84680D1BDFF6DF524AE8984C63", hash_generated_method = "46F3FA898F45252770A1ED2E2B632480")
    public boolean isMulticastAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_88802157 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_88802157;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.652 -0400", hash_original_method = "34E7BECA5A41D39726D6E4A4A4838C8A", hash_generated_method = "2D24F10DFE75D3F08DDA11975BA500DF")
    public boolean isSiteLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_495579458 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_495579458;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.652 -0400", hash_original_method = "C5AA36E6C7DFD1C45750A6D7AE21AFCC", hash_generated_method = "91F87F685FF9C0C6D5319E1679A4B8E3")
    public boolean isReachable(int timeout) throws IOException {
        boolean var79CB746A93A3D3E65B7122FECE6F9BB8_189304736 = (isReachable(null, 0, timeout));
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_17427142 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_17427142;
        // ---------- Original Method ----------
        //return isReachable(null, 0, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.729 -0400", hash_original_method = "A1A0F0207714140D12E9E4AE2187615D", hash_generated_method = "FCB305CDDBB3E306277E0EC3530BDB79")
    public boolean isReachable(NetworkInterface networkInterface, final int ttl, final int timeout) throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException("ttl < 0 || timeout < 0");
        } //End block
        {
            boolean varE90BF27773AA71DDBE5F32BAE585508C_884876635 = (isReachable(this, null, timeout));
        } //End block
        List<InetAddress> sourceAddresses;
        sourceAddresses = Collections.list(networkInterface.getInetAddresses());
        {
            boolean var62C2047A8A14391C51272AF278381770_108668457 = (sourceAddresses.isEmpty());
        } //End collapsed parenthetic
        InetAddress destinationAddress;
        destinationAddress = this;
        CountDownLatch latch;
        latch = new CountDownLatch(sourceAddresses.size());
        AtomicBoolean isReachable;
        isReachable = new AtomicBoolean(false);
        {
            Iterator<InetAddress> varBD264B6AB6F51D0C5A90F893347FF495_1929309495 = (sourceAddresses).iterator();
            varBD264B6AB6F51D0C5A90F893347FF495_1929309495.hasNext();
            final InetAddress sourceAddress = varBD264B6AB6F51D0C5A90F893347FF495_1929309495.next();
            {
                new Thread() {                    
                    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.725 -0400", hash_original_method = "B701C9C990A30C345CD440F261C9D387", hash_generated_method = "222AF584E727A985E6DBA2FBEDDB988A")
                    @Override
                    public void run() {
                        try 
                        {
                            {
                                boolean var41C8F9D0A375DDBE03CBB8B034FCFB59_919079637 = (isReachable(destinationAddress, sourceAddress, timeout));
                                {
                                    isReachable.set(true);
                                    {
                                        boolean var8847E7E96F1F56F28816D013D8F8553D_248584010 = (latch.getCount() > 0);
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
        boolean varA1124C2A3F7643822A53302B8D28AC66_940677289 = (isReachable.get());
        addTaint(networkInterface.getTaint());
        addTaint(ttl);
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1776252543 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1776252543;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.734 -0400", hash_original_method = "296F60C65F61166BD9A8DF4CB4E70272", hash_generated_method = "37F690974BB6BD1BAB78DEA9C9B5BC1A")
    private boolean isReachable(InetAddress destination, InetAddress source, int timeout) throws IOException {
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
                boolean varF7A18AD86880F63E4E9705AC2F05468E_295759534 = (e.getCause() instanceof ErrnoException);
                {
                    reached = (((ErrnoException) e.getCause()).errno == ECONNREFUSED);
                } //End block
            } //End collapsed parenthetic
        } //End block
        IoBridge.closeSocket(fd);
        addTaint(destination.getTaint());
        addTaint(source.getTaint());
        addTaint(timeout);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1695070396 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1695070396;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.746 -0400", hash_original_method = "EA85F511D24184DD59F5742DCBE8C620", hash_generated_method = "86D6C5354575E037DAA2D7C5347E0EF0")
    private void writeObject(ObjectOutputStream stream) throws IOException {
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
        addTaint(stream.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.747 -0400", hash_original_method = "8E54F0F7AE1E424107F71EAAF0F6F90C", hash_generated_method = "51F27159B3F02F4AD21A47EB6544F4A5")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        int addr;
        addr = fields.get("address", 0);
        ipaddress = new byte[4];
        Memory.pokeInt(ipaddress, 0, addr, ByteOrder.BIG_ENDIAN);
        hostName = (String) fields.get("hostName", null);
        family = fields.get("family", 2);
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = stream.readFields();
        //int addr = fields.get("address", 0);
        //ipaddress = new byte[4];
        //Memory.pokeInt(ipaddress, 0, addr, ByteOrder.BIG_ENDIAN);
        //hostName = (String) fields.get("hostName", null);
        //family = fields.get("family", 2);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.747 -0400", hash_original_method = "08DCB3CBD406BD7814E8362202DC0D50", hash_generated_method = "4E0D43D36D111C1C070AFB4FC6DB1EF6")
    private Object readResolve() throws ObjectStreamException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1382140439 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1382140439 = new Inet4Address(ipaddress, hostName);
        varB4EAC82CA7396A68D541C85D26508E83_1382140439.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1382140439;
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.747 -0400", hash_original_field = "06D3EFD07AE631BF7A16FDDC7793B09D", hash_generated_field = "4D5FBC220B6413D051E58000DC22B512")

    private static AddressCache addressCache = new AddressCache();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.748 -0400", hash_original_field = "6457221FED36AEA41AF6CB769203E35C", hash_generated_field = "FB607DA6C774EC8A3CC3DADFB3E8AC93")

    private static long serialVersionUID = 3286316764910316507L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.748 -0400", hash_original_field = "AD70106DDC81CA0C32DA24B6870F6537", hash_generated_field = "119C92FDA430C8C47E72137BCDA943A4")

    public static final InetAddress UNSPECIFIED = new InetAddress(AF_UNSPEC, null, null);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.748 -0400", hash_original_field = "56295EAA1211F6276AB88DEF534334A7", hash_generated_field = "2AD8942E4F27C97546091085CFEE4FF4")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("address", int.class),
        new ObjectStreamField("family", int.class),
        new ObjectStreamField("hostName", String.class),
    };
}

