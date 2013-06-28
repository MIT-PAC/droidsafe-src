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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.516 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.516 -0400", hash_original_field = "FE04D40BAE669C85DC9915B41E74EBC1", hash_generated_field = "14CCD87ECEE8F75EB85BC22ABB3E01CA")

    private int interfaceIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.516 -0400", hash_original_field = "9EB03689244D48241F82A2E168771927", hash_generated_field = "9DB8B5B1A2500F2D3289DAED15877781")

    private List<InterfaceAddress> interfaceAddresses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.516 -0400", hash_original_field = "963E3A2FE559E393BAD631F3DC686F69", hash_generated_field = "4253A4C32D027B8452C3697AE17C333B")

    private List<InetAddress> addresses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.516 -0400", hash_original_field = "EE22C142A7E6F8619D6A3AE29A16C5AD", hash_generated_field = "E12F20A3F0C19D49814391AB55DB6473")

    private final List<NetworkInterface> children = new LinkedList<NetworkInterface>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.516 -0400", hash_original_field = "EB17B6F54220F5E4DBB78B0010FAEFA6", hash_generated_field = "9E46A9600719B02A7A32211C8211AD2B")

    private NetworkInterface parent = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.517 -0400", hash_original_method = "F3FEF51C38B27C4E9E0E3609EB93BEE8", hash_generated_method = "CF1D14E69302D3FB4CBE482F8E9FE53C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.518 -0400", hash_original_method = "BFC291A64FD07504405088442BFF58AA", hash_generated_method = "15AE5EA2A1175878C7CF627B21154C85")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712544714 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1712544714;
        // ---------- Original Method ----------
        //return interfaceIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.520 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "E4B32443A9781B477043B22AE6420253")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1883473351 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1883473351 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1883473351.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1883473351;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.522 -0400", hash_original_method = "8FEC8BEDC3DD9B76E3DD04718D2DB944", hash_generated_method = "755BC7A8D384627C881A6701EA8B007F")
    public Enumeration<InetAddress> getInetAddresses() {
        Enumeration<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_1068417838 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1068417838 = Collections.enumeration(addresses);
        varB4EAC82CA7396A68D541C85D26508E83_1068417838.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1068417838;
        // ---------- Original Method ----------
        //return Collections.enumeration(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.523 -0400", hash_original_method = "8EA44302895F236212D41E0DDEBDF9A7", hash_generated_method = "78E4CA2B0768D9721CBD4929E9153E1E")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_699340897 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_699340897 = name;
        varB4EAC82CA7396A68D541C85D26508E83_699340897.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_699340897;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.525 -0400", hash_original_method = "BC7B763A69F6C3BA5344751878C41BC9", hash_generated_method = "7704B1BE55AE0BCE682735A139DE75A6")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_913140302 = (obj == this);
        } //End collapsed parenthetic
        NetworkInterface rhs = (NetworkInterface) obj;
        boolean varCFDD7FADFC3FFE902DE7F2C3CFC056FA_756934304 = (interfaceIndex == rhs.interfaceIndex &&
                name.equals(rhs.name) &&
                addresses.equals(rhs.addresses));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1578410662 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1578410662;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.525 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "319C317B4F952AD62D3803EF4A291A74")
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_396386786 = (name.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125889246 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2125889246;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.529 -0400", hash_original_method = "620D41077AD7BF09E0A41C54CA4C93E4", hash_generated_method = "1FC6AC64723E03339C9925B859D33918")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1248191153 = null; //Variable for return #1
        StringBuilder sb = new StringBuilder(25);
        sb.append("[");
        sb.append(name);
        sb.append("][");
        sb.append(interfaceIndex);
        sb.append("]");
        {
            Iterator<InetAddress> var62595D499DF2C76ECC662655AB071B53_975331677 = (addresses).iterator();
            var62595D499DF2C76ECC662655AB071B53_975331677.hasNext();
            InetAddress address = var62595D499DF2C76ECC662655AB071B53_975331677.next();
            {
                sb.append("[");
                sb.append(address.toString());
                sb.append("]");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1248191153 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_1248191153.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1248191153;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.530 -0400", hash_original_method = "C190D1700F991379DD6B6FA0B56D9271", hash_generated_method = "102D2668E8EFBF640260787784EBDF97")
    public List<InterfaceAddress> getInterfaceAddresses() {
        List<InterfaceAddress> varB4EAC82CA7396A68D541C85D26508E83_149841799 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_149841799 = Collections.unmodifiableList(interfaceAddresses);
        varB4EAC82CA7396A68D541C85D26508E83_149841799.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_149841799;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(interfaceAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.530 -0400", hash_original_method = "8E4C110AD3B43FE2BF8CD3BA4F006B61", hash_generated_method = "81B8B7F3B499CFD9F1CEFDF02244EB8F")
    public Enumeration<NetworkInterface> getSubInterfaces() {
        Enumeration<NetworkInterface> varB4EAC82CA7396A68D541C85D26508E83_1803319609 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1803319609 = Collections.enumeration(children);
        varB4EAC82CA7396A68D541C85D26508E83_1803319609.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1803319609;
        // ---------- Original Method ----------
        //return Collections.enumeration(children);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.531 -0400", hash_original_method = "0171D836B0B5DAF8B2EBF67B786C53D8", hash_generated_method = "C12FD99125C8C3A419F348B5529521F1")
    public NetworkInterface getParent() {
        NetworkInterface varB4EAC82CA7396A68D541C85D26508E83_1242423314 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1242423314 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_1242423314.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1242423314;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.531 -0400", hash_original_method = "75BA962F238E916BD53759FC06C4F3FC", hash_generated_method = "7741E34588E3EA2120790F9EB80DDA2A")
    public boolean isUp() throws SocketException {
        boolean varF591EFC37B60A72A17E3CE63FBA99BEB_1349902996 = (hasFlag(IFF_UP));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2058450678 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2058450678;
        // ---------- Original Method ----------
        //return hasFlag(IFF_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.531 -0400", hash_original_method = "43938CC724FD99A90F694F02FE52F3C1", hash_generated_method = "BAF58A1BE12D0AD05BBD9B4B12F4C347")
    public boolean isLoopback() throws SocketException {
        boolean var6A7673CBC332282894945C821D155828_2107582769 = (hasFlag(IFF_LOOPBACK));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1523221957 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1523221957;
        // ---------- Original Method ----------
        //return hasFlag(IFF_LOOPBACK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.532 -0400", hash_original_method = "23308A79A2D2396A98D81E8541E78934", hash_generated_method = "8EA7C0B2F047609786F3D193C669F812")
    public boolean isPointToPoint() throws SocketException {
        boolean var4148E911C703019273CB54FC3753B0FD_2089372554 = (hasFlag(IFF_POINTOPOINT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1412503424 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1412503424;
        // ---------- Original Method ----------
        //return hasFlag(IFF_POINTOPOINT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.532 -0400", hash_original_method = "F3F42A79D0AC4CD032482F2E9202D65B", hash_generated_method = "C440E8C1FA23B9A530F47812F07FC17E")
    public boolean supportsMulticast() throws SocketException {
        boolean var9E225DE38FE74005B320C73360ECB2FA_1168370324 = (hasFlag(IFF_MULTICAST));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2008125626 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2008125626;
        // ---------- Original Method ----------
        //return hasFlag(IFF_MULTICAST);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.533 -0400", hash_original_method = "D18447285D6021856765D65DFF4990EE", hash_generated_method = "6459AAAC86A0CDD7599ACFAA08ECACB1")
    private boolean hasFlag(int mask) throws SocketException {
        int flags = readIntFile("/sys/class/net/" + name + "/flags");
        addTaint(mask);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1678241371 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1678241371;
        // ---------- Original Method ----------
        //int flags = readIntFile("/sys/class/net/" + name + "/flags");
        //return (flags & mask) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.534 -0400", hash_original_method = "38A6C5A0C86B6ED6858EFB47D652704B", hash_generated_method = "D6EC725C00F925CEFF6028EC8A30900E")
    public byte[] getHardwareAddress() throws SocketException {
        try 
        {
            String s = IoUtils.readFileAsString("/sys/class/net/" + name + "/address");
            byte[] result = new byte[s.length()/3];
            {
                int i = 0;
                {
                    result[i] = (byte) Integer.parseInt(s.substring(3*i, 3*i + 2), 16);
                } //End block
            } //End collapsed parenthetic
            {
                int i = 0;
            } //End collapsed parenthetic
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw rethrowAsSocketException(ex);
        } //End block
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1062960811 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_1062960811;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.534 -0400", hash_original_method = "57A1E5A45121F464D5D64A55053B7665", hash_generated_method = "923B9AFD47BD16CD0F5509919A0B9DC5")
    public int getMTU() throws SocketException {
        int varE7F9CEFF64D3342D8630F1AC7ACF09B3_66735998 = (readIntFile("/sys/class/net/" + name + "/mtu"));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677079722 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_677079722;
        // ---------- Original Method ----------
        //return readIntFile("/sys/class/net/" + name + "/mtu");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:53.535 -0400", hash_original_method = "8D88E2F84D40F104BBA78B3610BC12B1", hash_generated_method = "55086F6ECF6B73B471A2CA88BAFC24CF")
    public boolean isVirtual() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_696045750 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_696045750;
        // ---------- Original Method ----------
        //return parent != null;
    }

    
}

