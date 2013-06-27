package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;
import static libcore.io.OsConstants.*;

public final class NetworkInterface extends Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.721 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.721 -0400", hash_original_field = "FE04D40BAE669C85DC9915B41E74EBC1", hash_generated_field = "14CCD87ECEE8F75EB85BC22ABB3E01CA")

    private int interfaceIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.721 -0400", hash_original_field = "9EB03689244D48241F82A2E168771927", hash_generated_field = "9DB8B5B1A2500F2D3289DAED15877781")

    private List<InterfaceAddress> interfaceAddresses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.721 -0400", hash_original_field = "963E3A2FE559E393BAD631F3DC686F69", hash_generated_field = "4253A4C32D027B8452C3697AE17C333B")

    private List<InetAddress> addresses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.722 -0400", hash_original_field = "EE22C142A7E6F8619D6A3AE29A16C5AD", hash_generated_field = "657209968F75C20CDFB234C03EEB03D5")

    private List<NetworkInterface> children = new LinkedList<NetworkInterface>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.722 -0400", hash_original_field = "EB17B6F54220F5E4DBB78B0010FAEFA6", hash_generated_field = "9E46A9600719B02A7A32211C8211AD2B")

    private NetworkInterface parent = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.736 -0400", hash_original_method = "F3FEF51C38B27C4E9E0E3609EB93BEE8", hash_generated_method = "CF1D14E69302D3FB4CBE482F8E9FE53C")
    private  NetworkInterface(String name, int interfaceIndex,
            List<InetAddress> addresses, List<InterfaceAddress> interfaceAddresses) {
        this.name = name;
        this.interfaceIndex = interfaceIndex;
        this.addresses = addresses;
        this.interfaceAddresses = interfaceAddresses;
        // ---------- Original Method ----------
        //this.name = name;
        //this.interfaceIndex = interfaceIndex;
        //this.addresses = addresses;
        //this.interfaceAddresses = interfaceAddresses;
    }

    
        static NetworkInterface forUnboundMulticastSocket() {
        return new NetworkInterface(null, -1,
                Arrays.asList(Inet6Address.ANY), Collections.<InterfaceAddress>emptyList());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.740 -0400", hash_original_method = "BFC291A64FD07504405088442BFF58AA", hash_generated_method = "EBAE3841543D0A4DB99AE0B7D58F6569")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826728220 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1826728220;
        // ---------- Original Method ----------
        //return interfaceIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.741 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "2DFE8B89BFD4C4F2306482B899BF51F9")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_2068771103 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2068771103 = name;
        varB4EAC82CA7396A68D541C85D26508E83_2068771103.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2068771103;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.741 -0400", hash_original_method = "8FEC8BEDC3DD9B76E3DD04718D2DB944", hash_generated_method = "235BEB3070EB7037CC05F769D5CEF38B")
    public Enumeration<InetAddress> getInetAddresses() {
        Enumeration<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_1858695582 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1858695582 = Collections.enumeration(addresses);
        varB4EAC82CA7396A68D541C85D26508E83_1858695582.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1858695582;
        // ---------- Original Method ----------
        //return Collections.enumeration(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.742 -0400", hash_original_method = "8EA44302895F236212D41E0DDEBDF9A7", hash_generated_method = "B0641369FBBD1EC70902F1767A537E35")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1398831958 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1398831958 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1398831958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1398831958;
        // ---------- Original Method ----------
        //return name;
    }

    
        public static NetworkInterface getByName(String interfaceName) throws SocketException {
        if (interfaceName == null) {
            throw new NullPointerException("interfaceName == null");
        }
        if (!isValidInterfaceName(interfaceName)) {
            return null;
        }
        int interfaceIndex = readIntFile("/sys/class/net/" + interfaceName + "/ifindex");
        List<InetAddress> addresses = new ArrayList<InetAddress>();
        List<InterfaceAddress> interfaceAddresses = new ArrayList<InterfaceAddress>();
        collectIpv6Addresses(interfaceName, interfaceIndex, addresses, interfaceAddresses);
        collectIpv4Address(interfaceName, addresses, interfaceAddresses);
        return new NetworkInterface(interfaceName, interfaceIndex, addresses, interfaceAddresses);
    }

    
        private static void collectIpv6Addresses(String interfaceName, int interfaceIndex,
            List<InetAddress> addresses, List<InterfaceAddress> interfaceAddresses) throws SocketException {
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader("/proc/net/if_inet6"));
            String suffix = " " + interfaceName;
            String line;
            while ((line = in.readLine()) != null) {
                if (!line.endsWith(suffix)) {
                    continue;
                }
                byte[] addressBytes = new byte[16];
                for (int i = 0; i < addressBytes.length; ++i) {
                    addressBytes[i] = (byte) Integer.parseInt(line.substring(2*i, 2*i + 2), 16);
                }
                short prefixLength = Short.parseShort(line.substring(36, 38), 16);
                Inet6Address inet6Address = new Inet6Address(addressBytes, null, interfaceIndex);
                addresses.add(inet6Address);
                interfaceAddresses.add(new InterfaceAddress(inet6Address, prefixLength));
            }
        } catch (Exception ex) {
            throw rethrowAsSocketException(ex);
        } finally {
            IoUtils.closeQuietly(in);
        }
    }

    
        private static void collectIpv4Address(String interfaceName, List<InetAddress> addresses,
            List<InterfaceAddress> interfaceAddresses) throws SocketException {
        FileDescriptor fd = null;
        try {
            fd = Libcore.os.socket(AF_INET, SOCK_DGRAM, 0);
            InetAddress address = Libcore.os.ioctlInetAddress(fd, SIOCGIFADDR, interfaceName);
            InetAddress broadcast = Libcore.os.ioctlInetAddress(fd, SIOCGIFBRDADDR, interfaceName);
            InetAddress netmask = Libcore.os.ioctlInetAddress(fd, SIOCGIFNETMASK, interfaceName);
            if (broadcast.equals(Inet4Address.ANY)) {
                broadcast = null;
            }
            addresses.add(address);
            interfaceAddresses.add(new InterfaceAddress((Inet4Address) address,
                    (Inet4Address) broadcast, (Inet4Address) netmask));
        } catch (ErrnoException errnoException) {
            if (errnoException.errno != EADDRNOTAVAIL) {
                throw rethrowAsSocketException(errnoException);
            }
        } catch (Exception ex) {
            throw rethrowAsSocketException(ex);
        } finally {
            IoUtils.closeQuietly(fd);
        }
    }

    
        @FindBugsSuppressWarnings("DMI_HARDCODED_ABSOLUTE_FILENAME")
    private static boolean isValidInterfaceName(String interfaceName) {
        for (String validName : new File("/sys/class/net").list()) {
            if (interfaceName.equals(validName)) {
                return true;
            }
        }
        return false;
    }

    
        private static int readIntFile(String path) throws SocketException {
        try {
            String s = IoUtils.readFileAsString(path).trim();
            if (s.startsWith("0x")) {
                return Integer.parseInt(s.substring(2), 16);
            } else {
                return Integer.parseInt(s);
            }
        } catch (Exception ex) {
            throw rethrowAsSocketException(ex);
        }
    }

    
        private static SocketException rethrowAsSocketException(Exception ex) throws SocketException {
        SocketException result = new SocketException();
        result.initCause(ex);
        throw result;
    }

    
        public static NetworkInterface getByInetAddress(InetAddress address) throws SocketException {
        if (address == null) {
            throw new NullPointerException("address == null");
        }
        for (NetworkInterface networkInterface : getNetworkInterfacesList()) {
            if (networkInterface.addresses.contains(address)) {
                return networkInterface;
            }
        }
        return null;
    }

    
        public static NetworkInterface getByIndex(int index) throws SocketException {
        String name = Libcore.os.if_indextoname(index);
        if (name == null) {
            return null;
        }
        return NetworkInterface.getByName(name);
    }

    
        public static Enumeration<NetworkInterface> getNetworkInterfaces() throws SocketException {
        return Collections.enumeration(getNetworkInterfacesList());
    }

    
        @FindBugsSuppressWarnings("DMI_HARDCODED_ABSOLUTE_FILENAME")
    private static List<NetworkInterface> getNetworkInterfacesList() throws SocketException {
        String[] interfaceNames = new File("/sys/class/net").list();
        NetworkInterface[] interfaces = new NetworkInterface[interfaceNames.length];
        for (int i = 0; i < interfaceNames.length; ++i) {
            interfaces[i] = NetworkInterface.getByName(interfaceNames[i]);
        }
        List<NetworkInterface> result = new ArrayList<NetworkInterface>();
        boolean[] peeked = new boolean[interfaces.length];
        for (int counter = 0; counter < interfaces.length; counter++) {
            if (peeked[counter]) {
                continue;
            }
            int counter2 = counter;
            for (; counter2 < interfaces.length; counter2++) {
                if (peeked[counter2]) {
                    continue;
                }
                if (interfaces[counter2].name.startsWith(interfaces[counter].name + ":")) {
                    peeked[counter2] = true;
                    interfaces[counter].children.add(interfaces[counter2]);
                    interfaces[counter2].parent = interfaces[counter];
                    interfaces[counter].addresses.addAll(interfaces[counter2].addresses);
                }
            }
            result.add(interfaces[counter]);
            peeked[counter] = true;
        }
        return result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.762 -0400", hash_original_method = "BC7B763A69F6C3BA5344751878C41BC9", hash_generated_method = "F19561406FE111B1546EEA0EA02B1BE2")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_575336723 = (obj == this);
        } //End collapsed parenthetic
        NetworkInterface rhs;
        rhs = (NetworkInterface) obj;
        boolean varCFDD7FADFC3FFE902DE7F2C3CFC056FA_393954975 = (interfaceIndex == rhs.interfaceIndex &&
                name.equals(rhs.name) &&
                addresses.equals(rhs.addresses));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1926939969 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1926939969;
        // ---------- Original Method ----------
        //if (obj == this) {
            //return true;
        //}
        //if (!(obj instanceof NetworkInterface)) {
            //return false;
        //}
        //NetworkInterface rhs = (NetworkInterface) obj;
        //return interfaceIndex == rhs.interfaceIndex &&
                //name.equals(rhs.name) &&
                //addresses.equals(rhs.addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.763 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "8CD49684C30D625AD9A068E6D60F88C2")
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_356744620 = (name.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628179504 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628179504;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.877 -0400", hash_original_method = "620D41077AD7BF09E0A41C54CA4C93E4", hash_generated_method = "E12E2CA4E7FE7C6BB82E8109E1709763")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_234330125 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(25);
        sb.append("[");
        sb.append(name);
        sb.append("][");
        sb.append(interfaceIndex);
        sb.append("]");
        {
            Iterator<InetAddress> var62595D499DF2C76ECC662655AB071B53_1503870836 = (addresses).iterator();
            var62595D499DF2C76ECC662655AB071B53_1503870836.hasNext();
            InetAddress address = var62595D499DF2C76ECC662655AB071B53_1503870836.next();
            {
                sb.append("[");
                sb.append(address.toString());
                sb.append("]");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_234330125 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_234330125.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_234330125;
        // ---------- Original Method ----------
        //StringBuilder sb = new StringBuilder(25);
        //sb.append("[");
        //sb.append(name);
        //sb.append("][");
        //sb.append(interfaceIndex);
        //sb.append("]");
        //for (InetAddress address : addresses) {
            //sb.append("[");
            //sb.append(address.toString());
            //sb.append("]");
        //}
        //return sb.toString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.878 -0400", hash_original_method = "C190D1700F991379DD6B6FA0B56D9271", hash_generated_method = "6F6F2AC397AF41BEE48A7585782BA8C9")
    public List<InterfaceAddress> getInterfaceAddresses() {
        List<InterfaceAddress> varB4EAC82CA7396A68D541C85D26508E83_1992031518 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1992031518 = Collections.unmodifiableList(interfaceAddresses);
        varB4EAC82CA7396A68D541C85D26508E83_1992031518.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1992031518;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(interfaceAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.879 -0400", hash_original_method = "8E4C110AD3B43FE2BF8CD3BA4F006B61", hash_generated_method = "BB8B21C78DFA28D3E98527F6635BAA5F")
    public Enumeration<NetworkInterface> getSubInterfaces() {
        Enumeration<NetworkInterface> varB4EAC82CA7396A68D541C85D26508E83_1490535340 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1490535340 = Collections.enumeration(children);
        varB4EAC82CA7396A68D541C85D26508E83_1490535340.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1490535340;
        // ---------- Original Method ----------
        //return Collections.enumeration(children);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.880 -0400", hash_original_method = "0171D836B0B5DAF8B2EBF67B786C53D8", hash_generated_method = "D8342BBD52C250A40FF06E5301DC22E7")
    public NetworkInterface getParent() {
        NetworkInterface varB4EAC82CA7396A68D541C85D26508E83_1069962928 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1069962928 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1069962928.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1069962928;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.888 -0400", hash_original_method = "75BA962F238E916BD53759FC06C4F3FC", hash_generated_method = "3285235ECBAF9BEB908D91F6865D94D6")
    public boolean isUp() throws SocketException {
        boolean varF591EFC37B60A72A17E3CE63FBA99BEB_1410573017 = (hasFlag(IFF_UP));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_435662911 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_435662911;
        // ---------- Original Method ----------
        //return hasFlag(IFF_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.901 -0400", hash_original_method = "43938CC724FD99A90F694F02FE52F3C1", hash_generated_method = "033C55F890B84D6946699E8D64B19701")
    public boolean isLoopback() throws SocketException {
        boolean var6A7673CBC332282894945C821D155828_1733690593 = (hasFlag(IFF_LOOPBACK));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1180249074 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1180249074;
        // ---------- Original Method ----------
        //return hasFlag(IFF_LOOPBACK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.901 -0400", hash_original_method = "23308A79A2D2396A98D81E8541E78934", hash_generated_method = "7F9B8B3E75DE1CB7E717CE20CFACACC2")
    public boolean isPointToPoint() throws SocketException {
        boolean var4148E911C703019273CB54FC3753B0FD_1407946768 = (hasFlag(IFF_POINTOPOINT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_790821964 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_790821964;
        // ---------- Original Method ----------
        //return hasFlag(IFF_POINTOPOINT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.901 -0400", hash_original_method = "F3F42A79D0AC4CD032482F2E9202D65B", hash_generated_method = "3D6A499DC220E988B0BD072AAEF5BF07")
    public boolean supportsMulticast() throws SocketException {
        boolean var9E225DE38FE74005B320C73360ECB2FA_363346256 = (hasFlag(IFF_MULTICAST));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_660738111 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_660738111;
        // ---------- Original Method ----------
        //return hasFlag(IFF_MULTICAST);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.902 -0400", hash_original_method = "D18447285D6021856765D65DFF4990EE", hash_generated_method = "CEE8A064C0F7515F5E805E648ED78AA2")
    private boolean hasFlag(int mask) throws SocketException {
        int flags;
        flags = readIntFile("/sys/class/net/" + name + "/flags");
        addTaint(mask);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1879072538 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1879072538;
        // ---------- Original Method ----------
        //int flags = readIntFile("/sys/class/net/" + name + "/flags");
        //return (flags & mask) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.903 -0400", hash_original_method = "38A6C5A0C86B6ED6858EFB47D652704B", hash_generated_method = "7CB308051CC2D4F70867D446FD061725")
    public byte[] getHardwareAddress() throws SocketException {
        try 
        {
            String s;
            s = IoUtils.readFileAsString("/sys/class/net/" + name + "/address");
            byte[] result;
            result = new byte[s.length()/3];
            {
                int i;
                i = 0;
                {
                    result[i] = (byte) Integer.parseInt(s.substring(3*i, 3*i + 2), 16);
                } //End block
            } //End collapsed parenthetic
            {
                int i;
                i = 0;
            } //End collapsed parenthetic
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw rethrowAsSocketException(ex);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_223590537 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_223590537;
        // ---------- Original Method ----------
        //try {
            //String s = IoUtils.readFileAsString("/sys/class/net/" + name + "/address");
            //byte[] result = new byte[s.length()/3];
            //for (int i = 0; i < result.length; ++i) {
                //result[i] = (byte) Integer.parseInt(s.substring(3*i, 3*i + 2), 16);
            //}
            //for (int i = 0; i < result.length; ++i) {
                //if (result[i] != 0) {
                    //return result;
                //}
            //}
            //return null;
        //} catch (Exception ex) {
            //throw rethrowAsSocketException(ex);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.908 -0400", hash_original_method = "57A1E5A45121F464D5D64A55053B7665", hash_generated_method = "5A7389CE7E0C65241D990BC1C9CD137E")
    public int getMTU() throws SocketException {
        int varE7F9CEFF64D3342D8630F1AC7ACF09B3_135425940 = (readIntFile("/sys/class/net/" + name + "/mtu"));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381794964 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1381794964;
        // ---------- Original Method ----------
        //return readIntFile("/sys/class/net/" + name + "/mtu");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.909 -0400", hash_original_method = "8D88E2F84D40F104BBA78B3610BC12B1", hash_generated_method = "0B1BB3C4CB98F4713B5B1D6A8C1FA211")
    public boolean isVirtual() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1902044982 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1902044982;
        // ---------- Original Method ----------
        //return parent != null;
    }

    
}

