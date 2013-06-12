package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
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
    private final List<NetworkInterface> children = new LinkedList<NetworkInterface>();
    private NetworkInterface parent = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "F3FEF51C38B27C4E9E0E3609EB93BEE8", hash_generated_method = "9F0410E68085AE9FF95794A34B68A60D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "B221CC75BF34BFBFBAF89FBF07707022", hash_generated_method = "0752D32F31678D8755903DCA96AE4833")
    static NetworkInterface forUnboundMulticastSocket() {
        return new NetworkInterface(null, -1,
                Arrays.asList(Inet6Address.ANY), Collections.<InterfaceAddress>emptyList());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "BFC291A64FD07504405088442BFF58AA", hash_generated_method = "EB74AE740352B17580A4D424E7D879D2")
    @DSModeled(DSC.SAFE)
    public int getIndex() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return interfaceIndex;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "F47755EA38582EE7C3877DD72123E9B0")
    @DSModeled(DSC.SAFE)
    public String getName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "8FEC8BEDC3DD9B76E3DD04718D2DB944", hash_generated_method = "E040C0FF01E9FD09F5D1FC0C84EF556C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<InetAddress> getInetAddresses() {
        Enumeration<InetAddress> var713CCAB3D086F36D72DCD71F891CCD82_1101615826 = (Collections.enumeration(addresses));
        return (Enumeration<InetAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.enumeration(addresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "8EA44302895F236212D41E0DDEBDF9A7", hash_generated_method = "98E8D003CA105B161A11AE9D6F58EDC5")
    @DSModeled(DSC.SAFE)
    public String getDisplayName() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "EC81104C8006573D0B5015A0AF9F06F0", hash_generated_method = "EF8E107A0F265E928EBACFC41E9A3312")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "DF0FB38845F1D102FDFDE7ACAB39C1AC", hash_generated_method = "8199DB0787024E803CA6C9A687822110")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "94D78D0B75F8342178E142C0650C9826", hash_generated_method = "9EE183E1277D3050FBBF20289E6C062F")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.258 -0400", hash_original_method = "A493AF52D537772EC9DA5C5C6A13B9D1", hash_generated_method = "0CBFBBB15936C88C1C743408B1BDA3EB")
    @FindBugsSuppressWarnings("DMI_HARDCODED_ABSOLUTE_FILENAME")
    private static boolean isValidInterfaceName(String interfaceName) {
        for (String validName : new File("/sys/class/net").list()) {
            if (interfaceName.equals(validName)) {
                return true;
            }
        }
        return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "7D3B21C401D86D194908014A1A22C808", hash_generated_method = "B96482B7707A80DAE8234FBBB9DCA39A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "FB6FEE373D57A234CE759121C2A038EA", hash_generated_method = "E266CE47973441E942358FEAD2C9DB4C")
    private static SocketException rethrowAsSocketException(Exception ex) throws SocketException {
        SocketException result = new SocketException();
        result.initCause(ex);
        throw result;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "C5BED01285EEC8C891B8D4941E84B7EA", hash_generated_method = "442F63E2864AF74B9727B2ACEF63732A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "41AD8406050560C493DEC740B62499BB", hash_generated_method = "F8DC51E5076697007446F2CCEEAE6E70")
    public static NetworkInterface getByIndex(int index) throws SocketException {
        String name = Libcore.os.if_indextoname(index);
        if (name == null) {
            return null;
        }
        return NetworkInterface.getByName(name);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "5454C5CAD241A70EC9EE91DB383A2F54", hash_generated_method = "0CEDC7EDC80F26805703027D51D30853")
    public static Enumeration<NetworkInterface> getNetworkInterfaces() throws SocketException {
        return Collections.enumeration(getNetworkInterfacesList());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "368E4D7FC14C0E393EC78EE372126951", hash_generated_method = "090D8ED9AD9CAC186B227AE9943F4B7E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "BC7B763A69F6C3BA5344751878C41BC9", hash_generated_method = "C6B98E966FA0CBF280A942A2DAB5754B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object obj) {
        dsTaint.addTaint(obj.dsTaint);
        NetworkInterface rhs;
        rhs = (NetworkInterface) obj;
        boolean varCFDD7FADFC3FFE902DE7F2C3CFC056FA_123323973 = (interfaceIndex == rhs.interfaceIndex &&
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "9BFA3D82AC3D0B7501E03B595DCA2169")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int var8EF65A1839C36EED6A25646011513717_2126398389 = (name.hashCode());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "620D41077AD7BF09E0A41C54CA4C93E4", hash_generated_method = "07C9D45151DFCCDDFCF9E13850228111")
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
            Iterator<InetAddress> seatecAstronomy42 = addresses.iterator();
            seatecAstronomy42.hasNext();
            InetAddress address = seatecAstronomy42.next();
            {
                sb.append("[");
                sb.append(address.toString());
                sb.append("]");
            } //End block
        } //End collapsed parenthetic
        String var806458D832AB974D230FEE4CBBDBD390_1588263170 = (sb.toString());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "C190D1700F991379DD6B6FA0B56D9271", hash_generated_method = "0E8F0FB2E9EC70C0F09A041843A8F76B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public List<InterfaceAddress> getInterfaceAddresses() {
        List<InterfaceAddress> var619CE1FD4C246D61F23F1688C4B0EC28_1199672701 = (Collections.unmodifiableList(interfaceAddresses));
        return (List<InterfaceAddress>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(interfaceAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "8E4C110AD3B43FE2BF8CD3BA4F006B61", hash_generated_method = "CE70FCC5FE0091840A0F389D11AE116B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Enumeration<NetworkInterface> getSubInterfaces() {
        Enumeration<NetworkInterface> var2270D0A74FDA93B45F77D94159862709_1297875777 = (Collections.enumeration(children));
        return (Enumeration<NetworkInterface>)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return Collections.enumeration(children);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "0171D836B0B5DAF8B2EBF67B786C53D8", hash_generated_method = "88B50C8C467D74355C057277A066AD7C")
    @DSModeled(DSC.SAFE)
    public NetworkInterface getParent() {
        return (NetworkInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "75BA962F238E916BD53759FC06C4F3FC", hash_generated_method = "F2C88ACFF73B2E4F9FDCD5D4FDF94860")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isUp() throws SocketException {
        boolean varF591EFC37B60A72A17E3CE63FBA99BEB_1426069163 = (hasFlag(IFF_UP));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasFlag(IFF_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.259 -0400", hash_original_method = "43938CC724FD99A90F694F02FE52F3C1", hash_generated_method = "9AF6AF5937C7C0BF0C99254C3C549CFC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isLoopback() throws SocketException {
        boolean var6A7673CBC332282894945C821D155828_1098481392 = (hasFlag(IFF_LOOPBACK));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasFlag(IFF_LOOPBACK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.260 -0400", hash_original_method = "23308A79A2D2396A98D81E8541E78934", hash_generated_method = "C3FE4038F278C2142E19576344449D3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean isPointToPoint() throws SocketException {
        boolean var4148E911C703019273CB54FC3753B0FD_1482805126 = (hasFlag(IFF_POINTOPOINT));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasFlag(IFF_POINTOPOINT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.260 -0400", hash_original_method = "F3F42A79D0AC4CD032482F2E9202D65B", hash_generated_method = "4D3AEAC51A2C23A4476EAFA10EFCDEC5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean supportsMulticast() throws SocketException {
        boolean var9E225DE38FE74005B320C73360ECB2FA_669401746 = (hasFlag(IFF_MULTICAST));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return hasFlag(IFF_MULTICAST);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.260 -0400", hash_original_method = "D18447285D6021856765D65DFF4990EE", hash_generated_method = "906F5BFEA01E3FA639070B022380F0E2")
    @DSModeled(DSC.SAFE)
    private boolean hasFlag(int mask) throws SocketException {
        dsTaint.addTaint(mask);
        int flags;
        flags = readIntFile("/sys/class/net/" + name + "/flags");
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //int flags = readIntFile("/sys/class/net/" + name + "/flags");
        //return (flags & mask) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.260 -0400", hash_original_method = "38A6C5A0C86B6ED6858EFB47D652704B", hash_generated_method = "09E989F0E8F4282071C5A7779DC0E82C")
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
            throw rethrowAsSocketException(ex);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.260 -0400", hash_original_method = "57A1E5A45121F464D5D64A55053B7665", hash_generated_method = "532CB634CA5B95FAFD6410E0EF8D46A9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getMTU() throws SocketException {
        int varE7F9CEFF64D3342D8630F1AC7ACF09B3_1168768705 = (readIntFile("/sys/class/net/" + name + "/mtu"));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return readIntFile("/sys/class/net/" + name + "/mtu");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:12.260 -0400", hash_original_method = "8D88E2F84D40F104BBA78B3610BC12B1", hash_generated_method = "5788C5674184E04DCF85E19BE8C10F42")
    @DSModeled(DSC.SAFE)
    public boolean isVirtual() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return parent != null;
    }

    
}


