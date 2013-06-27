package java.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.util.Arrays;
import java.util.Enumeration;
import static libcore.io.OsConstants.*;

public final class Inet6Address extends InetAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.453 -0400", hash_original_field = "4053739BB83B56A1ED1EFBD07BF580A5", hash_generated_field = "540B1C4E03CB3F83CE53991B800AA5B4")

    private boolean scope_id_set;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.453 -0400", hash_original_field = "945206A2664A2B0E39A9E7EC3D6C8BE0", hash_generated_field = "351D02D0A0BDA8B744D0089144674D8B")

    private int scope_id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.453 -0400", hash_original_field = "BA3879874E52AA7A4341FD1D23ADA187", hash_generated_field = "D87D8B960AE4DD5A16D6F3BEBE7DE96B")

    private boolean scope_ifname_set;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.453 -0400", hash_original_field = "B1A5412C2B4EF5FC64890EE3803EBED5", hash_generated_field = "9CB9BAC1E4A6ACB09F6AABB6B922D3F0")

    private String ifname;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.454 -0400", hash_original_method = "FCC74B21AAC45508B8719673A0766005", hash_generated_method = "1527F698E7CAFC60095FA392DE499276")
      Inet6Address(byte[] ipaddress, String hostName, int scope_id) {
        super(AF_INET6, ipaddress, hostName);
        this.scope_id = scope_id;
        this.scope_id_set = (scope_id != 0);
        addTaint(ipaddress[0]);
        addTaint(hostName.getTaint());
        // ---------- Original Method ----------
        //this.scope_id = scope_id;
        //this.scope_id_set = (scope_id != 0);
    }

    
        public static Inet6Address getByAddress(String host, byte[] addr, int scope_id) throws UnknownHostException {
        if (addr == null || addr.length != 16) {
            throw new UnknownHostException("Not an IPv6 address: " + Arrays.toString(addr));
        }
        if (scope_id < 0) {
            scope_id = 0;
        }
        return new Inet6Address(addr, host, scope_id);
    }

    
        public static Inet6Address getByAddress(String host, byte[] addr,
            NetworkInterface nif) throws UnknownHostException {
        Inet6Address address = Inet6Address.getByAddress(host, addr, 0);
        if (nif == null) {
            return address;
        }
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
        if (!address.scope_id_set) {
            throw new UnknownHostException("Scope id not found for address: " + Arrays.toString(addr));
        }
        return address;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.471 -0400", hash_original_method = "5C85837CE4C7853B5C8DB05F5798B94D", hash_generated_method = "25797911C901B600FFE65F1429A0816A")
    private boolean compareLocalType(Inet6Address ia) {
        {
            boolean var55ABA625F481830BD34F8B5466690BF7_378183498 = (ia.isSiteLocalAddress() && isSiteLocalAddress());
        } //End collapsed parenthetic
        {
            boolean var71EB32049A5AB07C1504847D1DCB7BE5_1458718842 = (ia.isLinkLocalAddress() && isLinkLocalAddress());
        } //End collapsed parenthetic
        {
            boolean var438C605FD4250DE117DD86CFD9F1B343_122887877 = (!ia.isSiteLocalAddress() && !ia.isLinkLocalAddress());
        } //End collapsed parenthetic
        addTaint(ia.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1509125643 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1509125643;
        // ---------- Original Method ----------
        //if (ia.isSiteLocalAddress() && isSiteLocalAddress()) {
            //return true;
        //}
        //if (ia.isLinkLocalAddress() && isLinkLocalAddress()) {
            //return true;
        //}
        //if (!ia.isSiteLocalAddress() && !ia.isLinkLocalAddress()) {
            //return true;
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.471 -0400", hash_original_method = "CB6B527FFA2A204FDEA9D4C37A9B03D5", hash_generated_method = "7C063A173DF0234A9199AEC547B57FB6")
    @Override
    public boolean isAnyLocalAddress() {
        boolean varB01692C366B404EF7C26158B42FD3EB5_142466863 = (Arrays.equals(ipaddress, Inet6Address.ANY.ipaddress));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1281468427 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1281468427;
        // ---------- Original Method ----------
        //return Arrays.equals(ipaddress, Inet6Address.ANY.ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.472 -0400", hash_original_method = "0048D9C1E27FFD1D482DB9672EA3AE03", hash_generated_method = "D00F4C6D51BA1F1ABB2111FF8BF35617")
    public boolean isIPv4CompatibleAddress() {
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1070132062 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1070132062;
        // ---------- Original Method ----------
        //for (int i = 0; i < 12; i++) {
            //if (ipaddress[i] != 0) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.472 -0400", hash_original_method = "9F5F5CEBE580C822E7F3125E303D498E", hash_generated_method = "EE821A6288C45B22AE4DA257EADF55F5")
    @Override
    public boolean isLinkLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1775128351 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1775128351;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0x80);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.477 -0400", hash_original_method = "29BC59263985E8B6D4DC540BD2555DBE", hash_generated_method = "D43063B86219D22F50072B83BCB7BD7A")
    @Override
    public boolean isLoopbackAddress() {
        boolean var1253ED8B41F2F9545D66C1E325A06412_677292968 = (Arrays.equals(ipaddress, Inet6Address.LOOPBACK.ipaddress));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1918738126 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1918738126;
        // ---------- Original Method ----------
        //return Arrays.equals(ipaddress, Inet6Address.LOOPBACK.ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.487 -0400", hash_original_method = "54D483B8739F01A2815B2B8F656686DE", hash_generated_method = "78A4280B7C3609F7268DEE7E0FA88724")
    @Override
    public boolean isMCGlobal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1557009709 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1557009709;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x0e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.487 -0400", hash_original_method = "DCFE2D7DF3B86ED730BA1C809E9E7D4A", hash_generated_method = "B5D778508F694DACB9751A1CF19041DF")
    @Override
    public boolean isMCLinkLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1474392562 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1474392562;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x02);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.487 -0400", hash_original_method = "A2CA5CB23BE5DDD68CAA7DA2135DB2EA", hash_generated_method = "7D16F932108DDE955BF372352972BB03")
    @Override
    public boolean isMCNodeLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2002076704 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2002076704;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x01);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.488 -0400", hash_original_method = "54DE0BED5AB4157674DB2DAF2389E694", hash_generated_method = "3BB6CD34E7EF0441E1D8DFB1F071B529")
    @Override
    public boolean isMCOrgLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1723069231 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1723069231;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x08);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.488 -0400", hash_original_method = "F3FC244CCF2BE8692CC93BDBE33FAF7E", hash_generated_method = "2C260B8612A1AA5297FF370C6BE3152F")
    @Override
    public boolean isMCSiteLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1408595025 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1408595025;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x05);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.488 -0400", hash_original_method = "421AE0BE80F642901B6D5A89B5DB9DC1", hash_generated_method = "C3123A6760FF9992A8F40FA6A73E6BC4")
    @Override
    public boolean isMulticastAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2021052358 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2021052358;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.489 -0400", hash_original_method = "3C2D74882AEFA2EBBC23E3A728C5AE01", hash_generated_method = "D1C331A23861921EE3EF0AB89BF5F967")
    @Override
    public boolean isSiteLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499854516 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499854516;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0xc0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.489 -0400", hash_original_method = "50E705BC98343A8115E00AFCB06615D7", hash_generated_method = "C34EAAE6DEF4CB41E7A1206005EE7C4E")
    public int getScopeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997185024 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1997185024;
        // ---------- Original Method ----------
        //return scope_id_set ? scope_id : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.489 -0400", hash_original_method = "F4AA364893CE5E0A3EC053A0FC0AB68A", hash_generated_method = "11FDFD4944CE909EFF655675BA90A03D")
    public NetworkInterface getScopedInterface() {
        NetworkInterface varB4EAC82CA7396A68D541C85D26508E83_618154599 = null; //Variable for return #1
        NetworkInterface varB4EAC82CA7396A68D541C85D26508E83_1366275533 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_618154599 = (scope_ifname_set && ifname != null) ? NetworkInterface.getByName(ifname) : null;
        } //End block
        catch (SocketException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1366275533 = null;
        } //End block
        NetworkInterface varA7E53CE21691AB073D9660D615818899_159062691; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_159062691 = varB4EAC82CA7396A68D541C85D26508E83_618154599;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_159062691 = varB4EAC82CA7396A68D541C85D26508E83_1366275533;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_159062691.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_159062691;
        // ---------- Original Method ----------
        //try {
            //return (scope_ifname_set && ifname != null) ? NetworkInterface.getByName(ifname) : null;
        //} catch (SocketException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.490 -0400", hash_original_method = "080327AC5673C5B50BEA99966675EA0A", hash_generated_method = "D60ABA30E8041352614DBCEDB2845BA2")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        ObjectOutputStream.PutField fields;
        fields = stream.putFields();
        {
            fields.put("ipaddress", null);
        } //End block
        {
            fields.put("ipaddress", ipaddress);
        } //End block
        fields.put("scope_id", scope_id);
        fields.put("scope_id_set", scope_id_set);
        fields.put("scope_ifname_set", scope_ifname_set);
        fields.put("ifname", ifname);
        stream.writeFields();
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //ObjectOutputStream.PutField fields = stream.putFields();
        //if (ipaddress == null) {
            //fields.put("ipaddress", null);
        //} else {
            //fields.put("ipaddress", ipaddress);
        //}
        //fields.put("scope_id", scope_id);
        //fields.put("scope_id_set", scope_id_set);
        //fields.put("scope_ifname_set", scope_ifname_set);
        //fields.put("ifname", ifname);
        //stream.writeFields();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.490 -0400", hash_original_method = "6B9730D7168B0E96ABCC55BBF7E32967", hash_generated_method = "4B416658357249A879E059E2AFE5CD9D")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        ipaddress = (byte[]) fields.get("ipaddress", null);
        scope_id = fields.get("scope_id", 0);
        scope_id_set = fields.get("scope_id_set", false);
        ifname = (String) fields.get("ifname", null);
        scope_ifname_set = fields.get("scope_ifname_set", false);
        addTaint(stream.getTaint());
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = stream.readFields();
        //ipaddress = (byte[]) fields.get("ipaddress", null);
        //scope_id = fields.get("scope_id", 0);
        //scope_id_set = fields.get("scope_id_set", false);
        //ifname = (String) fields.get("ifname", null);
        //scope_ifname_set = fields.get("scope_ifname_set", false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.497 -0400", hash_original_method = "3CCDE4F93DD898D7C7483D8BBE2EDADA", hash_generated_method = "6D920383DD131BD41E596D4437E38321")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1490163234 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_2119995125 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1082342384 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_1490163234 = super.toString() + "%" + ifname;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_2119995125 = super.toString() + "%" + scope_id;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1082342384 = super.toString();
        String varA7E53CE21691AB073D9660D615818899_113903969; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_113903969 = varB4EAC82CA7396A68D541C85D26508E83_1490163234;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_113903969 = varB4EAC82CA7396A68D541C85D26508E83_2119995125;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_113903969 = varB4EAC82CA7396A68D541C85D26508E83_1082342384;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_113903969.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_113903969;
        // ---------- Original Method ----------
        //if (ifname != null) {
            //return super.toString() + "%" + ifname;
        //}
        //if (scope_id != 0) {
            //return super.toString() + "%" + scope_id;
        //}
        //return super.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.497 -0400", hash_original_field = "569165E5FD36BE01148D4A59F328A2B1", hash_generated_field = "33D5B764101CB1D00D682F17A2C7646C")

    private static long serialVersionUID = 6880410070516793377L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.497 -0400", hash_original_field = "4F54F398366A8A75C39C9AA9782CBE3E", hash_generated_field = "0DD864D68660257C63399D6AE1C39774")

    public static final InetAddress ANY =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, null, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.497 -0400", hash_original_field = "B621C0EA8E0C5A5ADAF6B2654665DD50", hash_generated_field = "6D8F13795697A62907A482E35E916FD1")

    public static final InetAddress LOOPBACK =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                    "localhost", 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:42.497 -0400", hash_original_field = "8B28DD0C39F68AE321A9E40E75021549", hash_generated_field = "61AD71F30112D5019891E0E37C6F7ACB")

    private static ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("ipaddress", byte[].class),
        new ObjectStreamField("scope_id", int.class),
        new ObjectStreamField("scope_id_set", boolean.class),
        new ObjectStreamField("scope_ifname_set", boolean.class),
        new ObjectStreamField("ifname", String.class),
    };
}

