package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import static libcore.io.OsConstants.AF_INET6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.util.Arrays;
import java.util.Enumeration;

public final class Inet6Address extends InetAddress {

    /**
     * Constructs an IPv6 address according to the given {@code host}, {@code
     * addr} and {@code scope_id}.
     *
     * @param host
     *            the host name associated with the address.
     * @param addr
     *            the network address.
     * @param scope_id
     *            the scope id for link- or site-local addresses.
     * @return the Inet6Address instance representing the IP address.
     * @throws UnknownHostException
     *             if the address is null or has an invalid length.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.041 -0500", hash_original_method = "3EBBCEDEC56E7AB88FDFBBA10A7277EC", hash_generated_method = "2738A3A2DB880FE1666B91390E102972")
    
public static Inet6Address getByAddress(String host, byte[] addr, int scope_id)
            throws UnknownHostException {
        if (addr == null || addr.length != 16) {
            throw new UnknownHostException("Not an IPv6 address: " + Arrays.toString(addr));
        }
        if (scope_id < 0) {
            scope_id = 0;
        }
        // TODO: should we clone 'addr'?
        return new Inet6Address(addr, host, scope_id);
    }

    /**
     * Gets an IPv6 address instance according to the given {@code host},
     * {@code addr} and {@code nif}. {@code scope_id} is set according to the
     * given {@code nif} and the {@code addr} type (for example site-local or
     * link-local).
     *
     * @param host
     *            the hostname associated with the address.
     * @param addr
     *            the network address.
     * @param nif
     *            the network interface that this address is associated with.
     * @return the Inet6Address instance representing the IP address.
     * @throws UnknownHostException
     *             if the address is {@code null} or has an invalid length or
     *             the interface doesn't have a numeric scope id for the given
     *             address type.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.044 -0500", hash_original_method = "A49AD0F17226A2518E05AA9E7B3D7401", hash_generated_method = "67B4E32FD9EB6997BB0F70F75774D53B")
    
public static Inet6Address getByAddress(String host, byte[] addr,
            NetworkInterface nif) throws UnknownHostException {

        Inet6Address address = Inet6Address.getByAddress(host, addr, 0);

        // if nif is null, nothing needs to be set.
        if (nif == null) {
            return address;
        }

        // find the first address which matches the type addr,
        // then set the scope_id and ifname.
        Enumeration<InetAddress> addressList = nif.getInetAddresses();
        while (addressList.hasMoreElements()) {
            InetAddress ia = addressList.nextElement();
            if (ia.getAddress().length == 16) {
                Inet6Address v6ia = (Inet6Address) ia;
                boolean isSameType = v6ia.compareLocalType(address);
                if (isSameType) {
                    address.scope_id_set = true;
                    address.scope_id = v6ia.scope_id;
                    address.scope_ifname_set = true;
                    address.ifname = nif.getName();
                    break;
                }
            }
        }
        // if no address matches the type of addr, throws an
        // UnknownHostException.
        if (!address.scope_id_set) {
            throw new UnknownHostException("Scope id not found for address: " + Arrays.toString(addr));
        }
        return address;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.020 -0500", hash_original_field = "509D2649D0720A019A3BE5787623729D", hash_generated_field = "33860EDD36D3C15C684CA6291D57C5F3")

    private static final long serialVersionUID = 6880410070516793377L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.023 -0500", hash_original_field = "9C7983317A96F8730EC0A215D9D0A39D", hash_generated_field = "0DD864D68660257C63399D6AE1C39774")

    public static final InetAddress ANY =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, null, 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.026 -0500", hash_original_field = "BCF7CEEC932A549A74800C1C9CC92FF5", hash_generated_field = "6D8F13795697A62907A482E35E916FD1")

    public static final InetAddress LOOPBACK =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                    "localhost", 0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.083 -0500", hash_original_field = "E792A6F412FC9AC97BBBBC4217A1546B", hash_generated_field = "80F683DFFB1443818A3133094A7F3E44")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("ipaddress", byte[].class),
        new ObjectStreamField("scope_id", int.class),
        new ObjectStreamField("scope_id_set", boolean.class),
        new ObjectStreamField("scope_ifname_set", boolean.class),
        new ObjectStreamField("ifname", String.class),
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.028 -0500", hash_original_field = "41D33BD5BE32E6D2C28DE3661CB62483", hash_generated_field = "540B1C4E03CB3F83CE53991B800AA5B4")

    private boolean scope_id_set;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.031 -0500", hash_original_field = "19DDBB0A8C50D0B5A5DEE29BDEA199B1", hash_generated_field = "351D02D0A0BDA8B744D0089144674D8B")

    private int scope_id;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.034 -0500", hash_original_field = "DB075635A538B553B15510156131F1A4", hash_generated_field = "D87D8B960AE4DD5A16D6F3BEBE7DE96B")

    private boolean scope_ifname_set;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.036 -0500", hash_original_field = "0D91B529E87429372316008C4CCB0D9A", hash_generated_field = "9CB9BAC1E4A6ACB09F6AABB6B922D3F0")

    private String ifname;

    /**
     * Constructs an {@code InetAddress} representing the {@code address} and
     * {@code name} and {@code scope_id}.
     *
     * @param address
     *            the network address.
     * @param name
     *            the name associated with the address.
     * @param scope_id
     *            the scope id for link- or site-local addresses.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.039 -0500", hash_original_method = "FCC74B21AAC45508B8719673A0766005", hash_generated_method = "FCC74B21AAC45508B8719673A0766005")
    
Inet6Address(byte[] ipaddress, String hostName, int scope_id) {
        super(AF_INET6, ipaddress, hostName);
        this.scope_id = scope_id;
        this.scope_id_set = (scope_id != 0);
    }

    /**
     * Returns {@code true} if one of following cases applies:
     * <p>
     * <ol>
     *  <li>both addresses are site local</li>
     *  <li>both addresses are link local</li>
     *  <li>{@code ia} is neither site local nor link local</li>
     * </ol>
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.047 -0500", hash_original_method = "5C85837CE4C7853B5C8DB05F5798B94D", hash_generated_method = "8C2971746F0F55CF6492A89EEA04D160")
    
private boolean compareLocalType(Inet6Address ia) {
        if (ia.isSiteLocalAddress() && isSiteLocalAddress()) {
            return true;
        }
        if (ia.isLinkLocalAddress() && isLinkLocalAddress()) {
            return true;
        }
        if (!ia.isSiteLocalAddress() && !ia.isLinkLocalAddress()) {
            return true;
        }
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.049 -0500", hash_original_method = "CB6B527FFA2A204FDEA9D4C37A9B03D5", hash_generated_method = "96DF98950713363A10ADD10A0C79E2D8")
    
@Override public boolean isAnyLocalAddress() {
        return Arrays.equals(ipaddress, Inet6Address.ANY.ipaddress);
    }

    /**
     * Returns whether this IPv6 address is an IPv4-compatible address or not.
     * An IPv4-compatible address has the prefix {@code ::/96} and is a deprecated
     * and no-longer used equivalent of the modern IPv4-mapped IPv6 addresses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.052 -0500", hash_original_method = "0048D9C1E27FFD1D482DB9672EA3AE03", hash_generated_method = "94E548496A9D7FE8D1DC255D156D6886")
    
public boolean isIPv4CompatibleAddress() {
        for (int i = 0; i < 12; i++) {
            if (ipaddress[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.054 -0500", hash_original_method = "9F5F5CEBE580C822E7F3125E303D498E", hash_generated_method = "26FA5D5536EE35DFA834E07C64B6B38A")
    
@Override public boolean isLinkLocalAddress() {
        return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0x80); // fe80:/10
    }

    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.057 -0500", hash_original_method = "29BC59263985E8B6D4DC540BD2555DBE", hash_generated_method = "965DAE95F907BCE29B1C9EF571ED8119")
    
@Override public boolean isLoopbackAddress() {
        return Arrays.equals(ipaddress, Inet6Address.LOOPBACK.ipaddress);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.059 -0500", hash_original_method = "54D483B8739F01A2815B2B8F656686DE", hash_generated_method = "24CD7A91D4B81E35074A5F8F0F615F6A")
    
@Override public boolean isMCGlobal() {
        return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x0e); // ffxe:/16
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.063 -0500", hash_original_method = "DCFE2D7DF3B86ED730BA1C809E9E7D4A", hash_generated_method = "2D935E7118B1EAAE3AF421381EDE2F4E")
    
@Override public boolean isMCLinkLocal() {
        return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x02); // ffx2:/16
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.065 -0500", hash_original_method = "A2CA5CB23BE5DDD68CAA7DA2135DB2EA", hash_generated_method = "353AEF3A8B4B688D1F292E3F83F4A992")
    
@Override public boolean isMCNodeLocal() {
        return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x01); // ffx1:/16
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.068 -0500", hash_original_method = "54DE0BED5AB4157674DB2DAF2389E694", hash_generated_method = "D57A165C839CF85577C05AC03A14AFEF")
    
@Override public boolean isMCOrgLocal() {
        return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x08); // ffx8:/16
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.070 -0500", hash_original_method = "F3FC244CCF2BE8692CC93BDBE33FAF7E", hash_generated_method = "B218B05DA37A5CAA651BFE83D3761BBA")
    
@Override public boolean isMCSiteLocal() {
        return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x05); // ffx5:/16
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.072 -0500", hash_original_method = "421AE0BE80F642901B6D5A89B5DB9DC1", hash_generated_method = "324C230C8ED3F2AFB234466CAC2E21CC")
    
@Override public boolean isMulticastAddress() {
        return ((ipaddress[0] & 0xff) == 0xff); // ff::/8
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.075 -0500", hash_original_method = "3C2D74882AEFA2EBBC23E3A728C5AE01", hash_generated_method = "4D9EB56990296204A00787DB6525AF62")
    
@Override public boolean isSiteLocalAddress() {
        return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0xc0); // fec0:/10
    }

    /**
     * Returns the scope id if this address is scoped to an interface, 0 otherwise.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.078 -0500", hash_original_method = "50E705BC98343A8115E00AFCB06615D7", hash_generated_method = "DECC39A89226EC4FC1F204C8768F2743")
    
public int getScopeId() {
        return scope_id_set ? scope_id : 0;
    }

    /**
     * Returns the network interface if this address is instanced with a scoped
     * network interface, null otherwise.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.080 -0500", hash_original_method = "F4AA364893CE5E0A3EC053A0FC0AB68A", hash_generated_method = "055B24A17F8AA39219A32393030DFE99")
    
public NetworkInterface getScopedInterface() {
        try {
            return (scope_ifname_set && ifname != null) ? NetworkInterface.getByName(ifname) : null;
        } catch (SocketException ex) {
            return null;
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.085 -0500", hash_original_method = "080327AC5673C5B50BEA99966675EA0A", hash_generated_method = "363498BFDD91D4945194EA14E382328A")
    
private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields = stream.putFields();
        if (ipaddress == null) {
            fields.put("ipaddress", null);
        } else {
            fields.put("ipaddress", ipaddress);
        }

        fields.put("scope_id", scope_id);
        fields.put("scope_id_set", scope_id_set);
        fields.put("scope_ifname_set", scope_ifname_set);
        fields.put("ifname", ifname);
        stream.writeFields();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.088 -0500", hash_original_method = "6B9730D7168B0E96ABCC55BBF7E32967", hash_generated_method = "443011ED754375420CE541E7FB7A0EE6")
    
private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields = stream.readFields();
        ipaddress = (byte[]) fields.get("ipaddress", null);
        scope_id = fields.get("scope_id", 0);
        scope_id_set = fields.get("scope_id_set", false);
        ifname = (String) fields.get("ifname", null);
        scope_ifname_set = fields.get("scope_ifname_set", false);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSSource({DSSourceKind.NETWORK_INFORMATION})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:08.090 -0500", hash_original_method = "3CCDE4F93DD898D7C7483D8BBE2EDADA", hash_generated_method = "3AF9A5A7C6181A2E1E6D977A7BEEF253")
    
@Override public String toString() {
        if (ifname != null) {
            return super.toString() + "%" + ifname;
        }
        if (scope_id != 0) {
            return super.toString() + "%" + scope_id;
        }
        return super.toString();
    }
}

