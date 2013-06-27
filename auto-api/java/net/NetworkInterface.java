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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.624 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.624 -0400", hash_original_field = "FE04D40BAE669C85DC9915B41E74EBC1", hash_generated_field = "14CCD87ECEE8F75EB85BC22ABB3E01CA")

    private int interfaceIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.624 -0400", hash_original_field = "9EB03689244D48241F82A2E168771927", hash_generated_field = "9DB8B5B1A2500F2D3289DAED15877781")

    private List<InterfaceAddress> interfaceAddresses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.624 -0400", hash_original_field = "963E3A2FE559E393BAD631F3DC686F69", hash_generated_field = "4253A4C32D027B8452C3697AE17C333B")

    private List<InetAddress> addresses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.624 -0400", hash_original_field = "EE22C142A7E6F8619D6A3AE29A16C5AD", hash_generated_field = "657209968F75C20CDFB234C03EEB03D5")

    private List<NetworkInterface> children = new LinkedList<NetworkInterface>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.625 -0400", hash_original_field = "EB17B6F54220F5E4DBB78B0010FAEFA6", hash_generated_field = "9E46A9600719B02A7A32211C8211AD2B")

    private NetworkInterface parent = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.626 -0400", hash_original_method = "F3FEF51C38B27C4E9E0E3609EB93BEE8", hash_generated_method = "CF1D14E69302D3FB4CBE482F8E9FE53C")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.627 -0400", hash_original_method = "BFC291A64FD07504405088442BFF58AA", hash_generated_method = "69152AA0D5F6BCFB7B8EE99221C257E1")
    public int getIndex() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423169397 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1423169397;
        // ---------- Original Method ----------
        //return interfaceIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.627 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "8F7B9A4245941B950B1FB375D547FBE3")
    public String getName() {
        String varB4EAC82CA7396A68D541C85D26508E83_1521540097 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1521540097 = name;
        varB4EAC82CA7396A68D541C85D26508E83_1521540097.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1521540097;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.629 -0400", hash_original_method = "8FEC8BEDC3DD9B76E3DD04718D2DB944", hash_generated_method = "BA793338D80E4C74C1FAD06505A1C5CA")
    public Enumeration<InetAddress> getInetAddresses() {
        Enumeration<InetAddress> varB4EAC82CA7396A68D541C85D26508E83_1779067512 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1779067512 = Collections.enumeration(addresses);
        varB4EAC82CA7396A68D541C85D26508E83_1779067512.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1779067512;
        // ---------- Original Method ----------
        //return Collections.enumeration(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.636 -0400", hash_original_method = "8EA44302895F236212D41E0DDEBDF9A7", hash_generated_method = "149E9ABED2932A593A4EB1F41B6BE800")
    public String getDisplayName() {
        String varB4EAC82CA7396A68D541C85D26508E83_952395590 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_952395590 = name;
        varB4EAC82CA7396A68D541C85D26508E83_952395590.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_952395590;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.669 -0400", hash_original_method = "BC7B763A69F6C3BA5344751878C41BC9", hash_generated_method = "FA00068AD947292B395AAA929D71BC05")
    @Override
    public boolean equals(Object obj) {
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_808740710 = (obj == this);
        } //End collapsed parenthetic
        NetworkInterface rhs;
        rhs = (NetworkInterface) obj;
        boolean varCFDD7FADFC3FFE902DE7F2C3CFC056FA_1559483234 = (interfaceIndex == rhs.interfaceIndex &&
                name.equals(rhs.name) &&
                addresses.equals(rhs.addresses));
        addTaint(obj.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1633415551 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1633415551;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.673 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "9C952D69494F24A7FD0751D1BC93724A")
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_905496562 = (name.hashCode());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982412440 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1982412440;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.712 -0400", hash_original_method = "620D41077AD7BF09E0A41C54CA4C93E4", hash_generated_method = "C72842AF731770CB09CD88957DA4684D")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_204457522 = null; //Variable for return #1
        StringBuilder sb;
        sb = new StringBuilder(25);
        sb.append("[");
        sb.append(name);
        sb.append("][");
        sb.append(interfaceIndex);
        sb.append("]");
        {
            Iterator<InetAddress> var62595D499DF2C76ECC662655AB071B53_1732281419 = (addresses).iterator();
            var62595D499DF2C76ECC662655AB071B53_1732281419.hasNext();
            InetAddress address = var62595D499DF2C76ECC662655AB071B53_1732281419.next();
            {
                sb.append("[");
                sb.append(address.toString());
                sb.append("]");
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_204457522 = sb.toString();
        varB4EAC82CA7396A68D541C85D26508E83_204457522.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_204457522;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.713 -0400", hash_original_method = "C190D1700F991379DD6B6FA0B56D9271", hash_generated_method = "EADE03B7794C925C75484CF12F1AF592")
    public List<InterfaceAddress> getInterfaceAddresses() {
        List<InterfaceAddress> varB4EAC82CA7396A68D541C85D26508E83_2041231832 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_2041231832 = Collections.unmodifiableList(interfaceAddresses);
        varB4EAC82CA7396A68D541C85D26508E83_2041231832.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2041231832;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(interfaceAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.713 -0400", hash_original_method = "8E4C110AD3B43FE2BF8CD3BA4F006B61", hash_generated_method = "CF13724C6121249DC31F319D7677642A")
    public Enumeration<NetworkInterface> getSubInterfaces() {
        Enumeration<NetworkInterface> varB4EAC82CA7396A68D541C85D26508E83_1722065887 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1722065887 = Collections.enumeration(children);
        varB4EAC82CA7396A68D541C85D26508E83_1722065887.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1722065887;
        // ---------- Original Method ----------
        //return Collections.enumeration(children);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.714 -0400", hash_original_method = "0171D836B0B5DAF8B2EBF67B786C53D8", hash_generated_method = "24433334672863A419936411494515DC")
    public NetworkInterface getParent() {
        NetworkInterface varB4EAC82CA7396A68D541C85D26508E83_958932936 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_958932936 = parent;
        varB4EAC82CA7396A68D541C85D26508E83_958932936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_958932936;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.714 -0400", hash_original_method = "75BA962F238E916BD53759FC06C4F3FC", hash_generated_method = "A34B18AA706C2051F5225B3B5F0143F8")
    public boolean isUp() throws SocketException {
        boolean varF591EFC37B60A72A17E3CE63FBA99BEB_1625787852 = (hasFlag(IFF_UP));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1478283198 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1478283198;
        // ---------- Original Method ----------
        //return hasFlag(IFF_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.725 -0400", hash_original_method = "43938CC724FD99A90F694F02FE52F3C1", hash_generated_method = "4BE7E6D543578FB01BB8752D80FDBDCC")
    public boolean isLoopback() throws SocketException {
        boolean var6A7673CBC332282894945C821D155828_665903146 = (hasFlag(IFF_LOOPBACK));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_292598493 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_292598493;
        // ---------- Original Method ----------
        //return hasFlag(IFF_LOOPBACK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.725 -0400", hash_original_method = "23308A79A2D2396A98D81E8541E78934", hash_generated_method = "78F80F5BF2FF0D8B780344FD66FFF5F4")
    public boolean isPointToPoint() throws SocketException {
        boolean var4148E911C703019273CB54FC3753B0FD_533787722 = (hasFlag(IFF_POINTOPOINT));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1009620090 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1009620090;
        // ---------- Original Method ----------
        //return hasFlag(IFF_POINTOPOINT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.726 -0400", hash_original_method = "F3F42A79D0AC4CD032482F2E9202D65B", hash_generated_method = "A72A41166AC71EFDB147B7309EC8BE8F")
    public boolean supportsMulticast() throws SocketException {
        boolean var9E225DE38FE74005B320C73360ECB2FA_1688989685 = (hasFlag(IFF_MULTICAST));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_425403799 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_425403799;
        // ---------- Original Method ----------
        //return hasFlag(IFF_MULTICAST);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.727 -0400", hash_original_method = "D18447285D6021856765D65DFF4990EE", hash_generated_method = "000908E51CA286C1276D6FB4CC4B96C4")
    private boolean hasFlag(int mask) throws SocketException {
        int flags;
        flags = readIntFile("/sys/class/net/" + name + "/flags");
        addTaint(mask);
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1248299783 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1248299783;
        // ---------- Original Method ----------
        //int flags = readIntFile("/sys/class/net/" + name + "/flags");
        //return (flags & mask) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.740 -0400", hash_original_method = "38A6C5A0C86B6ED6858EFB47D652704B", hash_generated_method = "AB8C69444F7386D1012053C99174E6CE")
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
        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_555647185 = {getTaintByte()};
        return var2F9C81BC6E497382285CD6B7A7E33DE1_555647185;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.740 -0400", hash_original_method = "57A1E5A45121F464D5D64A55053B7665", hash_generated_method = "75B7A7FF97D82AF1F999F08E9DD29C65")
    public int getMTU() throws SocketException {
        int varE7F9CEFF64D3342D8630F1AC7ACF09B3_2127160851 = (readIntFile("/sys/class/net/" + name + "/mtu"));
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312459619 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_312459619;
        // ---------- Original Method ----------
        //return readIntFile("/sys/class/net/" + name + "/mtu");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.741 -0400", hash_original_method = "8D88E2F84D40F104BBA78B3610BC12B1", hash_generated_method = "0BBD5B6668E6D8E468891581C4C7479D")
    public boolean isVirtual() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1917596170 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1917596170;
        // ---------- Original Method ----------
        //return parent != null;
    }

    
}

