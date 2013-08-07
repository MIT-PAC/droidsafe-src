package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import static libcore.io.OsConstants.AF_INET;
import static libcore.io.OsConstants.EADDRNOTAVAIL;
import static libcore.io.OsConstants.IFF_LOOPBACK;
import static libcore.io.OsConstants.IFF_MULTICAST;
import static libcore.io.OsConstants.IFF_POINTOPOINT;
import static libcore.io.OsConstants.IFF_UP;
import static libcore.io.OsConstants.SIOCGIFADDR;
import static libcore.io.OsConstants.SIOCGIFBRDADDR;
import static libcore.io.OsConstants.SIOCGIFNETMASK;
import static libcore.io.OsConstants.SOCK_DGRAM;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;

import libcore.io.ErrnoException;
import libcore.io.IoUtils;
import libcore.io.Libcore;





public final class NetworkInterface extends Object {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.890 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.890 -0400", hash_original_field = "FE04D40BAE669C85DC9915B41E74EBC1", hash_generated_field = "14CCD87ECEE8F75EB85BC22ABB3E01CA")

    private int interfaceIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.890 -0400", hash_original_field = "9EB03689244D48241F82A2E168771927", hash_generated_field = "9DB8B5B1A2500F2D3289DAED15877781")

    private List<InterfaceAddress> interfaceAddresses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.891 -0400", hash_original_field = "963E3A2FE559E393BAD631F3DC686F69", hash_generated_field = "4253A4C32D027B8452C3697AE17C333B")

    private List<InetAddress> addresses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.891 -0400", hash_original_field = "EE22C142A7E6F8619D6A3AE29A16C5AD", hash_generated_field = "E12F20A3F0C19D49814391AB55DB6473")

    private final List<NetworkInterface> children = new LinkedList<NetworkInterface>();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.891 -0400", hash_original_field = "EB17B6F54220F5E4DBB78B0010FAEFA6", hash_generated_field = "9E46A9600719B02A7A32211C8211AD2B")

    private NetworkInterface parent = null;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.892 -0400", hash_original_method = "F3FEF51C38B27C4E9E0E3609EB93BEE8", hash_generated_method = "CF1D14E69302D3FB4CBE482F8E9FE53C")
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.893 -0400", hash_original_method = "BFC291A64FD07504405088442BFF58AA", hash_generated_method = "DAE52D04EDB6774999043A3A733EAD6B")
    public int getIndex() {
        int varFE04D40BAE669C85DC9915B41E74EBC1_1959380206 = (interfaceIndex);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23540949 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_23540949;
        // ---------- Original Method ----------
        //return interfaceIndex;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.893 -0400", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "EC12CBDD048482C5A9EDC083A0CF48C6")
    public String getName() {
String varB017984728AC60AD1F0BF8734F33F15C_981283183 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_981283183.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_981283183;
        // ---------- Original Method ----------
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.894 -0400", hash_original_method = "8FEC8BEDC3DD9B76E3DD04718D2DB944", hash_generated_method = "291A2F6CE85FD6C06E23BCC121D9381F")
    public Enumeration<InetAddress> getInetAddresses() {
Enumeration<InetAddress> varD3B470D483B8F9354A0737BFC5858998_1221450591 =         Collections.enumeration(addresses);
        varD3B470D483B8F9354A0737BFC5858998_1221450591.addTaint(taint);
        return varD3B470D483B8F9354A0737BFC5858998_1221450591;
        // ---------- Original Method ----------
        //return Collections.enumeration(addresses);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.894 -0400", hash_original_method = "8EA44302895F236212D41E0DDEBDF9A7", hash_generated_method = "02B0306C409CB761A7436A77F382F73C")
    public String getDisplayName() {
String varB017984728AC60AD1F0BF8734F33F15C_818013052 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_818013052.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_818013052;
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

    
    @DSModeled(DSC.BAN)
    private static boolean isValidInterfaceName(String interfaceName) {
        for (String validName : new File("/sys/class/net").list()) {
            if (interfaceName.equals(validName)) {
                return true;
            }
        }
        return false;
    }

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSModeled(DSC.BAN)
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.895 -0400", hash_original_method = "BC7B763A69F6C3BA5344751878C41BC9", hash_generated_method = "AF2E7640E673B5F48D5FC87DDEA36A32")
    @Override
    public boolean equals(Object obj) {
        addTaint(obj.getTaint());
        if(obj == this)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_794651455 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1293069120 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1293069120;
        } //End block
        if(!(obj instanceof NetworkInterface))        
        {
            boolean var68934A3E9455FA72420237EB05902327_814412119 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_827552137 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_827552137;
        } //End block
        NetworkInterface rhs = (NetworkInterface) obj;
        boolean var93A2255EF5D2F61EF98EF817A72B3CFF_968838479 = (interfaceIndex == rhs.interfaceIndex &&
                name.equals(rhs.name) &&
                addresses.equals(rhs.addresses));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_698562398 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_698562398;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.896 -0400", hash_original_method = "EF5D8B81A9E09E0C38DFC15BA422ECA1", hash_generated_method = "684440426377BDE06C71474F97DEF18F")
    @Override
    public int hashCode() {
        int var5715838B66EDF423F24A871806972EB3_1797538566 = (name.hashCode());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288772907 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1288772907;
        // ---------- Original Method ----------
        //return name.hashCode();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.896 -0400", hash_original_method = "620D41077AD7BF09E0A41C54CA4C93E4", hash_generated_method = "23C26006B5C51C135C1E6D238A1713AA")
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(25);
        sb.append("[");
        sb.append(name);
        sb.append("][");
        sb.append(interfaceIndex);
        sb.append("]");
for(InetAddress address : addresses)
        {
            sb.append("[");
            sb.append(address.toString());
            sb.append("]");
        } //End block
String var2460B846747F8B22185AD8BE722266A5_741317479 =         sb.toString();
        var2460B846747F8B22185AD8BE722266A5_741317479.addTaint(taint);
        return var2460B846747F8B22185AD8BE722266A5_741317479;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.896 -0400", hash_original_method = "C190D1700F991379DD6B6FA0B56D9271", hash_generated_method = "72B3BA77E541ECB3C28F5AADD14A28B7")
    public List<InterfaceAddress> getInterfaceAddresses() {
List<InterfaceAddress> var1AE6140156ED59D7B38A38420D0276CF_1802201865 =         Collections.unmodifiableList(interfaceAddresses);
        var1AE6140156ED59D7B38A38420D0276CF_1802201865.addTaint(taint);
        return var1AE6140156ED59D7B38A38420D0276CF_1802201865;
        // ---------- Original Method ----------
        //return Collections.unmodifiableList(interfaceAddresses);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.896 -0400", hash_original_method = "8E4C110AD3B43FE2BF8CD3BA4F006B61", hash_generated_method = "6C7AE7B059212BAC8A081B9794D0677F")
    public Enumeration<NetworkInterface> getSubInterfaces() {
Enumeration<NetworkInterface> varFB917036CF4C112A6E28D983C9E7D865_1402198101 =         Collections.enumeration(children);
        varFB917036CF4C112A6E28D983C9E7D865_1402198101.addTaint(taint);
        return varFB917036CF4C112A6E28D983C9E7D865_1402198101;
        // ---------- Original Method ----------
        //return Collections.enumeration(children);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.896 -0400", hash_original_method = "0171D836B0B5DAF8B2EBF67B786C53D8", hash_generated_method = "C558A4D9C75E1C89A76A9AE23BE320C8")
    public NetworkInterface getParent() {
NetworkInterface var0F49909EA73F8892C338E4DCA6EB9906_686297012 =         parent;
        var0F49909EA73F8892C338E4DCA6EB9906_686297012.addTaint(taint);
        return var0F49909EA73F8892C338E4DCA6EB9906_686297012;
        // ---------- Original Method ----------
        //return parent;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.896 -0400", hash_original_method = "75BA962F238E916BD53759FC06C4F3FC", hash_generated_method = "E3A5BB9EEB4B8077698A2FD6CB08315F")
    public boolean isUp() throws SocketException {
        boolean var26DF8EC98758B1380AC5855D3A8FEF83_1057693276 = (hasFlag(IFF_UP));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1183329667 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1183329667;
        // ---------- Original Method ----------
        //return hasFlag(IFF_UP);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.896 -0400", hash_original_method = "43938CC724FD99A90F694F02FE52F3C1", hash_generated_method = "2BD6954B5F75F13182B025C0F0A21F72")
    public boolean isLoopback() throws SocketException {
        boolean var9AB8438077177BEA1D608C258B4B8B26_1342266003 = (hasFlag(IFF_LOOPBACK));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_70046341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_70046341;
        // ---------- Original Method ----------
        //return hasFlag(IFF_LOOPBACK);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.896 -0400", hash_original_method = "23308A79A2D2396A98D81E8541E78934", hash_generated_method = "8A09A34DC6F6E5D17A1BA6C622E5A522")
    public boolean isPointToPoint() throws SocketException {
        boolean var5E74952569B8C838CE61A4AB61CD82BC_1182581060 = (hasFlag(IFF_POINTOPOINT));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1488961004 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1488961004;
        // ---------- Original Method ----------
        //return hasFlag(IFF_POINTOPOINT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.896 -0400", hash_original_method = "F3F42A79D0AC4CD032482F2E9202D65B", hash_generated_method = "2C1788D7881B508A5C19703273036297")
    public boolean supportsMulticast() throws SocketException {
        boolean varCAF320F4BB75DE7DCBCC3CDA3F430534_1905375120 = (hasFlag(IFF_MULTICAST));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1464300811 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1464300811;
        // ---------- Original Method ----------
        //return hasFlag(IFF_MULTICAST);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.897 -0400", hash_original_method = "D18447285D6021856765D65DFF4990EE", hash_generated_method = "480A56EB1B5B33DBF44FE84F30D90341")
    private boolean hasFlag(int mask) throws SocketException {
        addTaint(mask);
        int flags = readIntFile("/sys/class/net/" + name + "/flags");
        boolean varF56F93CDAFC8ABFF067CEB42438DE12B_1288596408 = ((flags & mask) != 0);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_763941445 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_763941445;
        // ---------- Original Method ----------
        //int flags = readIntFile("/sys/class/net/" + name + "/flags");
        //return (flags & mask) != 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:49.939 -0400", hash_original_method = "38A6C5A0C86B6ED6858EFB47D652704B", hash_generated_method = "03D3756D0CCE283A6BBA95B14F88554B")
    public byte[] getHardwareAddress() throws SocketException {
        try 
        {
            String s = IoUtils.readFileAsString("/sys/class/net/" + name + "/address");
            byte[] result = new byte[s.length()/3];
for(int i = 0;i < result.length;++i)
            {
                result[i] = (byte) Integer.parseInt(s.substring(3*i, 3*i + 2), 16);
            } //End block
for(int i = 0;i < result.length;++i)
            {
    if(result[i] != 0)                
                {
                    byte[] varB4A88417B3D0170D754C647C30B7216A_1103439529 = (result);
                                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_174632909 = {getTaintByte()};
                    return var2F9C81BC6E497382285CD6B7A7E33DE1_174632909;
                } //End block
            } //End block
            byte[] var37A6259CC0C1DAE299A7866489DFF0BD_283865565 = (null);
                        byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1335534166 = {getTaintByte()};
            return var2F9C81BC6E497382285CD6B7A7E33DE1_1335534166;
        } //End block
        catch (Exception ex)
        {
            SocketException var8E41BFA796BE9F8FB9DC270405E20F86_1814482532 = rethrowAsSocketException(ex);
            var8E41BFA796BE9F8FB9DC270405E20F86_1814482532.addTaint(taint);
            throw var8E41BFA796BE9F8FB9DC270405E20F86_1814482532;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.932 -0400", hash_original_method = "57A1E5A45121F464D5D64A55053B7665", hash_generated_method = "47A96A9C040229DEBE358B1CFF0C91F3")
    public int getMTU() throws SocketException {
        int varBC4143F5BD08A4B8EF95741872F7167D_867435652 = (readIntFile("/sys/class/net/" + name + "/mtu"));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213887990 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1213887990;
        // ---------- Original Method ----------
        //return readIntFile("/sys/class/net/" + name + "/mtu");
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.932 -0400", hash_original_method = "8D88E2F84D40F104BBA78B3610BC12B1", hash_generated_method = "E344D6B89816D6CA0A6E48CE733694AB")
    public boolean isVirtual() {
        boolean var01B1E92D3155F4DF341F8D5C1B791189_1118370472 = (parent != null);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_817879556 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_817879556;
        // ---------- Original Method ----------
        //return parent != null;
    }

    
}

