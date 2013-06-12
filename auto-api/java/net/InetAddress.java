package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private static final AddressCache addressCache = new AddressCache();
    private static final long serialVersionUID = 3286316764910316507L;
    private int family;
    byte[] ipaddress;
    String hostName;
    public static final InetAddress UNSPECIFIED = new InetAddress(AF_UNSPEC, null, null);
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("address", int.class),
        new ObjectStreamField("family", int.class),
        new ObjectStreamField("hostName", String.class),
    };
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.233 -0400", hash_original_method = "D743789B4770A2F65AD981CCEDC5E9F2", hash_generated_method = "789953BF6B6A19D537F5C1EC557C9AC5")
    @DSModeled(DSC.SAFE)
     InetAddress(int family, byte[] ipaddress, String hostName) {
        dsTaint.addTaint(family);
        dsTaint.addTaint(hostName);
        dsTaint.addTaint(ipaddress);
        // ---------- Original Method ----------
        //this.family = family;
        //this.ipaddress = ipaddress;
        //this.hostName = hostName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "3AAFCD043D3971ACCC1BC5F122FB0BE0", hash_generated_method = "DBBD8B65118B9BDBF41501E342D65688")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        boolean var736C841577D8C25E47C4A18B061F61D3_1692549718 = (Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //if (!(obj instanceof InetAddress)) {
            //return false;
        //}
        //return Arrays.equals(this.ipaddress, ((InetAddress) obj).ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "0983A0B23668071C038C0A3F8002A354", hash_generated_method = "A023719645DF80E499C4C540B8F52291")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public byte[] getAddress() {
        byte[] var2347CEE6C132BC5594CEE5BBD0F30A9A_531709458 = (ipaddress.clone());
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
        // ---------- Original Method ----------
        //return ipaddress.clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "C098D3724E09EEC45853C7E5DAED7824", hash_generated_method = "6312CAEB0113DE8B1DE1B451BC465061")
    private static InetAddress[] bytesToInetAddresses(byte[][] rawAddresses, String hostName) throws UnknownHostException {
        InetAddress[] returnedAddresses = new InetAddress[rawAddresses.length];
        for (int i = 0; i < rawAddresses.length; i++) {
            returnedAddresses[i] = makeInetAddress(rawAddresses[i], hostName);
        }
        return returnedAddresses;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "FB551EC28630FE6F0C2EF7814F81623E", hash_generated_method = "ACE15F490E4BD0A3B86FEF53D4EFC7AC")
    public static InetAddress[] getAllByName(String host) throws UnknownHostException {
        return getAllByNameImpl(host).clone();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "246D92EAF0F98E04427CC0512E8DD56F", hash_generated_method = "D656745FF3246A48A72AD660EDE5F4C3")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "CB8F6EAC24B3C3F95717D807E1D14C33", hash_generated_method = "FBE29A04B92154FCDCE4BABDD598B24E")
    private static InetAddress makeInetAddress(byte[] bytes, String hostName) throws UnknownHostException {
        if (bytes.length == 4) {
            return new Inet4Address(bytes, hostName);
        } else if (bytes.length == 16) {
            return new Inet6Address(bytes, hostName, 0);
        } else {
            throw badAddressLength(bytes);
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "7257BB04AFE16B3CCE24EF2723A03805", hash_generated_method = "53BAB7A29DD44CEF7F1A7296433E43FB")
    private static InetAddress disallowDeprecatedFormats(String address, InetAddress inetAddress) {
        if (!(inetAddress instanceof Inet4Address) || address.indexOf(':') != -1) {
            return inetAddress;
        }
        return Libcore.os.inet_pton(AF_INET, address);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "13D428EED9E34243733FECE30A32A88B", hash_generated_method = "F74CACAD6D9939B36687A0368EFBF421")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "DD1533442534100575D70C182ADE1C96", hash_generated_method = "042C59E72021E1834F301CC5C89036C8")
    public static InetAddress getByName(String host) throws UnknownHostException {
        return getAllByNameImpl(host)[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "A1139ABF91D0374599D7EB888F5DB646", hash_generated_method = "0751388192116D18599429DCAA5D7C22")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getHostAddress() {
        String var0E380FC3360C8D458EA12B91EF7DDC01_2089150591 = (Libcore.os.getnameinfo(this, NI_NUMERICHOST));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return Libcore.os.getnameinfo(this, NI_NUMERICHOST);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "4F443763E78EE7A4BDC306A79DFCDBBC", hash_generated_method = "D987F1C2A4788FA8C3F2495B11C34BC1")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "A5A62CAEFD7FCA56AB200DB74BB59546", hash_generated_method = "0A6922BB57360A6144AEAEF251F89A52")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String getCanonicalHostName() {
        try 
        {
            String var458502783EE6656EC089C4CA0AEE7E93_804146454 = (getHostByAddrImpl(this).hostName);
        } //End block
        catch (UnknownHostException ex)
        {
            String var7EC7536219943C3F11F282FF183651CB_1431894469 = (getHostAddress());
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //try {
            //return getHostByAddrImpl(this).hostName;
        //} catch (UnknownHostException ex) {
            //return getHostAddress();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "E79319E7983FFD892480819C6E838DC2", hash_generated_method = "42A32443A0500AD60A3EF761DA43EF92")
    public static InetAddress getLocalHost() throws UnknownHostException {
        String host = Libcore.os.uname().nodename;
        return lookupHostByName(host)[0];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "70D58F36ADD2B32D6B4870D6C7A22922", hash_generated_method = "8DFB9FF696A9BC53279CD5969C0BA400")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var7810AFBE6CE34C4D0D867B5084406399_2022581654 = (Arrays.hashCode(ipaddress));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Arrays.hashCode(ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "9A18BDA9B7320ADFBD057B8A639BF335", hash_generated_method = "27B509AFE4BDCD39064ADB974EC8401B")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.234 -0400", hash_original_method = "10AA1BA0464BE4692583736E1FB9D6CA", hash_generated_method = "A3387316C83FBF149BB8EE16153566EB")
    public static void clearDnsCache() {
        addressCache.clear();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "52AE02939059AD17567A159306895CC4", hash_generated_method = "FAB60AFCEE7C37B239B874D1CAF9F245")
    private static InetAddress getHostByAddrImpl(InetAddress address) throws UnknownHostException {
        BlockGuard.getThreadPolicy().onNetwork();
        try {
            String hostname = Libcore.os.getnameinfo(address, NI_NAMEREQD);
            return makeInetAddress(address.ipaddress.clone(), hostname);
        } catch (GaiException gaiException) {
            throw gaiException.rethrowAsUnknownHostException();
        }
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "0306D8C3E43590D820E89D43080D7C82", hash_generated_method = "4B7A9990C3A934B64ADAD2322D5A8069")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        String var922B49EAB65266BF3D56B9861CB06013_698882224 = ((hostName == null ? "" : hostName) + "/" + getHostAddress()); //DSFIXME:  CODE0008: Nested ternary operator in expression
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return (hostName == null ? "" : hostName) + "/" + getHostAddress();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "AB06389E4D3099E4980AF28625DCA9DF", hash_generated_method = "DEF063CE0317DDDAF52DF39E0A608218")
    public static boolean isNumeric(String address) {
        InetAddress inetAddress = parseNumericAddressNoThrow(address);
        return inetAddress != null && disallowDeprecatedFormats(address, inetAddress) != null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "9B702BA41E49A0B2D54CFA8AA4B75EEF", hash_generated_method = "C13DCB4F953031846E02483ABE8CCBC4")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "89B71749F6D1ED2E70A746BF0E6C21BC", hash_generated_method = "720D5C7EF54D55F3A03C431CCB43DEB2")
    private static InetAddress[] loopbackAddresses() {
        return new InetAddress[] { Inet6Address.LOOPBACK, Inet4Address.LOOPBACK };
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "7F38E98A384441E9C595E5B09E3332A9", hash_generated_method = "2684BAE775A83394D81BEA27B9D16514")
    public static InetAddress getLoopbackAddress() {
        return Inet6Address.LOOPBACK;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "0DFB661E6E123FAAEACDB840E13652D3", hash_generated_method = "049428EAC9DD7A5387B47AA4745590FD")
    @DSModeled(DSC.SAFE)
    public boolean isAnyLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "C2C85D69F5C8114C53B505B2C48FBA38", hash_generated_method = "F4C0E3B6385564AD0199B78C5E0C5A7A")
    @DSModeled(DSC.SAFE)
    public boolean isLinkLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "F4A838CB0E6897A23081D395162E9DA1", hash_generated_method = "35144D69CC395B2946582544B9C63720")
    @DSModeled(DSC.SAFE)
    public boolean isLoopbackAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "FDE6DFC941C3F6CDB3A8E59F11467602", hash_generated_method = "6E5B084D6E2332E34F93D9E04BA61F92")
    @DSModeled(DSC.SAFE)
    public boolean isMCGlobal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "633857E8ABB2714E861E7CC407521B8A", hash_generated_method = "37559A6F60499BCD0234741DB987ED32")
    @DSModeled(DSC.SAFE)
    public boolean isMCLinkLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "B0B42DF39D7CC893DB97C3031173A44B", hash_generated_method = "FF47A6DA96CFE483EC6863AF599AB190")
    @DSModeled(DSC.SAFE)
    public boolean isMCNodeLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "8083E84E7FB8B51C8E4E9091B5CE2BBD", hash_generated_method = "9676108BD00DA85580DF7DED87527DE4")
    @DSModeled(DSC.SAFE)
    public boolean isMCOrgLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "5286F1AFCB89409D5250A9F370D7AC47", hash_generated_method = "4451B164147FF11334411454ED17EBDE")
    @DSModeled(DSC.SAFE)
    public boolean isMCSiteLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "93032F84680D1BDFF6DF524AE8984C63", hash_generated_method = "061E4D3BD9E2973A2FA8755B2A4A735E")
    @DSModeled(DSC.SAFE)
    public boolean isMulticastAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "34E7BECA5A41D39726D6E4A4A4838C8A", hash_generated_method = "31AEB0F67968FBB3715E514DE83054F1")
    @DSModeled(DSC.SAFE)
    public boolean isSiteLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.235 -0400", hash_original_method = "C5AA36E6C7DFD1C45750A6D7AE21AFCC", hash_generated_method = "B3F693E8F6D08F9C3C6F052355D8C0B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReachable(int timeout) throws IOException {
        dsTaint.addTaint(timeout);
        boolean var79CB746A93A3D3E65B7122FECE6F9BB8_1561958428 = (isReachable(null, 0, timeout));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return isReachable(null, 0, timeout);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "A1A0F0207714140D12E9E4AE2187615D", hash_generated_method = "8ED3E4F8065774CD60098478C21CB050")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isReachable(NetworkInterface networkInterface, final int ttl, final int timeout) throws IOException {
        dsTaint.addTaint(networkInterface.dsTaint);
        dsTaint.addTaint(ttl);
        dsTaint.addTaint(timeout);
        {
            if (DroidSafeAndroidRuntime.control)throw new IllegalArgumentException("ttl < 0 || timeout < 0");
        } //End block
        {
            boolean varE90BF27773AA71DDBE5F32BAE585508C_655677548 = (isReachable(this, null, timeout));
        } //End block
        List<InetAddress> sourceAddresses;
        sourceAddresses = Collections.list(networkInterface.getInetAddresses());
        {
            boolean var62C2047A8A14391C51272AF278381770_860115990 = (sourceAddresses.isEmpty());
        } //End collapsed parenthetic
        final InetAddress destinationAddress;
        destinationAddress = this;
        final CountDownLatch latch;
        latch = new CountDownLatch(sourceAddresses.size());
        final AtomicBoolean isReachable;
        isReachable = new AtomicBoolean(false);
        {
            Iterator<InetAddress> seatecAstronomy42 = sourceAddresses.iterator();
            seatecAstronomy42.hasNext();
            final InetAddress sourceAddress = seatecAstronomy42.next();
            {
                new Thread() {
                @Override public void run() {
                    try {
                        if (isReachable(destinationAddress, sourceAddress, timeout)) {
                            isReachable.set(true);
                            while (latch.getCount() > 0) {
                                latch.countDown();
                            }
                        }
                    } catch (IOException ignored) {
                    }
                    latch.countDown();
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
        boolean varA1124C2A3F7643822A53302B8D28AC66_456946599 = (isReachable.get());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "296F60C65F61166BD9A8DF4CB4E70272", hash_generated_method = "1A09C698C38BB438979B215E03F2A199")
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
                boolean varF7A18AD86880F63E4E9705AC2F05468E_978972000 = (e.getCause() instanceof ErrnoException);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "62A7C11189E68648BE032AAAC357AEAD", hash_generated_method = "6640896F14B26720B73658FB0E72D38B")
    public static InetAddress getByAddress(byte[] ipAddress) throws UnknownHostException {
        return getByAddress(null, ipAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "AB1313B483280B6D95EFD60881636E2E", hash_generated_method = "B1DCEB660FD15C7469EB114D8BBE6FC4")
    public static InetAddress getByAddress(String hostName, byte[] ipAddress) throws UnknownHostException {
        return getByAddress(hostName, ipAddress, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "92BD61B54A32FD10D3456FBE907A2602", hash_generated_method = "61722EA374EFACA9C43C4CF8667B01D9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "816D2EFAAEB973A2F6F408B300A22DDF", hash_generated_method = "6765381FFF68B17C9B4D8BFF63CC0A6A")
    private static UnknownHostException badAddressLength(byte[] bytes) throws UnknownHostException {
        throw new UnknownHostException("Address is neither 4 or 16 bytes: " + Arrays.toString(bytes));
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "976F5692DBFDF51A2ADCA4E3FA07B136", hash_generated_method = "124977BF134EF2E6561536764983CED5")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "76C3DB48DD3809B5557BF6F40359BC2C", hash_generated_method = "61CAD9059146DB1956372921747CDB86")
    private static byte[] ipv4MappedToIPv4(byte[] mappedAddress) {
        byte[] ipv4Address = new byte[4];
        for (int i = 0; i < 4; i++) {
            ipv4Address[i] = mappedAddress[12 + i];
        }
        return ipv4Address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "EA85F511D24184DD59F5742DCBE8C620", hash_generated_method = "1D287362E3D5EFB2DB7BDB2509F6EF02")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "8E54F0F7AE1E424107F71EAAF0F6F90C", hash_generated_method = "BE513C3D3831032156AC8806D3E9B841")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.236 -0400", hash_original_method = "08DCB3CBD406BD7814E8362202DC0D50", hash_generated_method = "AB55752F464ABD03EFBBD60BDC42C914")
    @DSModeled(DSC.SAFE)
    private Object readResolve() throws ObjectStreamException {
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new Inet4Address(ipaddress, hostName);
    }

    
}


