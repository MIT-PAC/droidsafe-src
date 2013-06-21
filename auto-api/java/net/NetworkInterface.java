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
    private String name;
    private int interfaceIndex;
    private List<InterfaceAddress> interfaceAddresses;
    private List<InetAddress> addresses;
    private List<NetworkInterface> children = new LinkedList<NetworkInterface>();
    private NetworkInterface parent = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.001 -0400", hash_original_method = "F3FEF51C38B27C4E9E0E3609EB93BEE8", hash_generated_method = "D8445A1DB4D2976420C1EABAB0A381B1")
    @DSModeled(DSC.SAFE)
    private NetworkInterface(String name, int interfaceIndex,
            List<InetAddress> addresses, List<InterfaceAddress> interfaceAddresses) {
        dsTaint.addTaint(interfaceAddresses.dsTaint);
        dsTaint.addTaint(name);
        dsTaint.addTaint(interfaceIndex);
        dsTaint.addTaint(addresses.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.001 -0400", hash_original_method = "BFC291A64FD07504405088442BFF58AA", hash_generated_method = "12F460AAA576203E164215D6E7D54F69")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return interfaceIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.001 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "3573899E99121C9CFE87F9DDAEE36810")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.001 -0400", hash_original_method = "8FEC8BEDC3DD9B76E3DD04718D2DB944", hash_generated_method = "8D5FECCAF898CBEFE7A89DD4FE2C4992")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<InetAddress> getInetAddresses() {
        Enumeration<InetAddress> var713CCAB3D086F36D72DCD71F891CCD82_331416111 = (Collections.enumeration(addresses));
        return (Enumeration<InetAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.enumeration(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.001 -0400", hash_original_method = "8EA44302895F236212D41E0DDEBDF9A7", hash_generated_method = "9DB595A27DDAF99E5F665377EBE08FEF")
    @DSModeled(DSC.SAFE)
    public String getDisplayName() {
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.003 -0400", hash_original_method = "BC7B763A69F6C3BA5344751878C41BC9", hash_generated_method = "8B868DE65C349C63949605F76A5B6B54")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        {
            boolean var8D1D3E5F4C020ED4FA594AED365B4BD8_1821582020 = (obj == this);
        } //End collapsed parenthetic
        NetworkInterface rhs;
        rhs = (NetworkInterface) obj;
        boolean varCFDD7FADFC3FFE902DE7F2C3CFC056FA_623739368 = (interfaceIndex == rhs.interfaceIndex &&
                name.equals(rhs.name) &&
                addresses.equals(rhs.addresses));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.003 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "916E778F42DFCB14F4D912DDB282D81A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_1135215403 = (name.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.007 -0400", hash_original_method = "620D41077AD7BF09E0A41C54CA4C93E4", hash_generated_method = "0A152D40C1AA55B76FCBA8EF55E065CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sb;
        sb = new StringBuilder(25);
        sb.append("[");
        sb.append(name);
        sb.append("][");
        sb.append(interfaceIndex);
        sb.append("]");
        {
            Iterator<InetAddress> var62595D499DF2C76ECC662655AB071B53_246559067 = (addresses).iterator();
            var62595D499DF2C76ECC662655AB071B53_246559067.hasNext();
            InetAddress address = var62595D499DF2C76ECC662655AB071B53_246559067.next();
            {
                sb.append("[");
                sb.append(address.toString());
                sb.append("]");
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_1469533721 = (sb.toString());
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.007 -0400", hash_original_method = "C190D1700F991379DD6B6FA0B56D9271", hash_generated_method = "9595BE68FE46C4795DA700BC5EAD073C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<InterfaceAddress> getInterfaceAddresses() {
        List<InterfaceAddress> var619CE1FD4C246D61F23F1688C4B0EC28_1830919833 = (Collections.unmodifiableList(interfaceAddresses));
        return (List<InterfaceAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(interfaceAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.007 -0400", hash_original_method = "8E4C110AD3B43FE2BF8CD3BA4F006B61", hash_generated_method = "D43D3688D2182E3560E78C7908592C9B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<NetworkInterface> getSubInterfaces() {
        Enumeration<NetworkInterface> var2270D0A74FDA93B45F77D94159862709_1262326576 = (Collections.enumeration(children));
        return (Enumeration<NetworkInterface>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.enumeration(children);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.007 -0400", hash_original_method = "0171D836B0B5DAF8B2EBF67B786C53D8", hash_generated_method = "B46C9C87CCEA270144EBA3F8C80B6823")
    @DSModeled(DSC.SAFE)
    public NetworkInterface getParent() {
        return (NetworkInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.007 -0400", hash_original_method = "75BA962F238E916BD53759FC06C4F3FC", hash_generated_method = "9B2B36B88DA905EB1D1E9362DA843510")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isUp() throws SocketException {
        boolean varF591EFC37B60A72A17E3CE63FBA99BEB_1791576850 = (hasFlag(IFF_UP));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasFlag(IFF_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.007 -0400", hash_original_method = "43938CC724FD99A90F694F02FE52F3C1", hash_generated_method = "BA33685EEA5A0342F94E06FDD3E17CA2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLoopback() throws SocketException {
        boolean var6A7673CBC332282894945C821D155828_703512317 = (hasFlag(IFF_LOOPBACK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasFlag(IFF_LOOPBACK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.008 -0400", hash_original_method = "23308A79A2D2396A98D81E8541E78934", hash_generated_method = "FFEF9EF2409ECA64269CE53307E7F882")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPointToPoint() throws SocketException {
        boolean var4148E911C703019273CB54FC3753B0FD_302204015 = (hasFlag(IFF_POINTOPOINT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasFlag(IFF_POINTOPOINT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.008 -0400", hash_original_method = "F3F42A79D0AC4CD032482F2E9202D65B", hash_generated_method = "9B6E96337BB471FBC4E1F0D14BFEE93C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean supportsMulticast() throws SocketException {
        boolean var9E225DE38FE74005B320C73360ECB2FA_1065445944 = (hasFlag(IFF_MULTICAST));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasFlag(IFF_MULTICAST);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.008 -0400", hash_original_method = "D18447285D6021856765D65DFF4990EE", hash_generated_method = "21CF35C2AF6C8F314E7F3541F0B9E7D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean hasFlag(int mask) throws SocketException {
        dsTaint.addTaint(mask);
        int flags;
        flags = readIntFile("/sys/class/net/" + name + "/flags");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int flags = readIntFile("/sys/class/net/" + name + "/flags");
        //return (flags & mask) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.008 -0400", hash_original_method = "38A6C5A0C86B6ED6858EFB47D652704B", hash_generated_method = "E9BDC7F7C44AD06B1F12AF88C7491A9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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
        byte[] retVal = new byte[1];
        retVal[0] = (byte)dsTaint.getTaintInt();
        return retVal;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.009 -0400", hash_original_method = "57A1E5A45121F464D5D64A55053B7665", hash_generated_method = "E6247AF29BF28B085BADB369BA17415B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMTU() throws SocketException {
        int varE7F9CEFF64D3342D8630F1AC7ACF09B3_986939858 = (readIntFile("/sys/class/net/" + name + "/mtu"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return readIntFile("/sys/class/net/" + name + "/mtu");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:28.009 -0400", hash_original_method = "8D88E2F84D40F104BBA78B3610BC12B1", hash_generated_method = "0EECD0BE35535EDA0393703FF54D9765")
    @DSModeled(DSC.SAFE)
    public boolean isVirtual() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parent != null;
    }

    
}

