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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.286 -0400", hash_original_field = "4053739BB83B56A1ED1EFBD07BF580A5", hash_generated_field = "540B1C4E03CB3F83CE53991B800AA5B4")

    private boolean scope_id_set;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.286 -0400", hash_original_field = "945206A2664A2B0E39A9E7EC3D6C8BE0", hash_generated_field = "351D02D0A0BDA8B744D0089144674D8B")

    private int scope_id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.286 -0400", hash_original_field = "BA3879874E52AA7A4341FD1D23ADA187", hash_generated_field = "D87D8B960AE4DD5A16D6F3BEBE7DE96B")

    private boolean scope_ifname_set;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.286 -0400", hash_original_field = "B1A5412C2B4EF5FC64890EE3803EBED5", hash_generated_field = "9CB9BAC1E4A6ACB09F6AABB6B922D3F0")

    private String ifname;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.287 -0400", hash_original_method = "FCC74B21AAC45508B8719673A0766005", hash_generated_method = "1527F698E7CAFC60095FA392DE499276")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.302 -0400", hash_original_method = "5C85837CE4C7853B5C8DB05F5798B94D", hash_generated_method = "5471F90600660357CE315E0031FD95E2")
    private boolean compareLocalType(Inet6Address ia) {
        {
            boolean var55ABA625F481830BD34F8B5466690BF7_1418971602 = (ia.isSiteLocalAddress() && isSiteLocalAddress());
        } //End collapsed parenthetic
        {
            boolean var71EB32049A5AB07C1504847D1DCB7BE5_526809014 = (ia.isLinkLocalAddress() && isLinkLocalAddress());
        } //End collapsed parenthetic
        {
            boolean var438C605FD4250DE117DD86CFD9F1B343_461641817 = (!ia.isSiteLocalAddress() && !ia.isLinkLocalAddress());
        } //End collapsed parenthetic
        addTaint(ia.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_373176164 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_373176164;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.302 -0400", hash_original_method = "CB6B527FFA2A204FDEA9D4C37A9B03D5", hash_generated_method = "1AB8D3929274036E70BC840DCF9B5A52")
    @Override
    public boolean isAnyLocalAddress() {
        boolean varB01692C366B404EF7C26158B42FD3EB5_763531786 = (Arrays.equals(ipaddress, Inet6Address.ANY.ipaddress));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713262645 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713262645;
        // ---------- Original Method ----------
        //return Arrays.equals(ipaddress, Inet6Address.ANY.ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.303 -0400", hash_original_method = "0048D9C1E27FFD1D482DB9672EA3AE03", hash_generated_method = "1C2EBC7269685EC0AE0684276940747B")
    public boolean isIPv4CompatibleAddress() {
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1770273763 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1770273763;
        // ---------- Original Method ----------
        //for (int i = 0; i < 12; i++) {
            //if (ipaddress[i] != 0) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.303 -0400", hash_original_method = "9F5F5CEBE580C822E7F3125E303D498E", hash_generated_method = "86842A405C20C839E7C84054E2CDC1A9")
    @Override
    public boolean isLinkLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_563890156 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_563890156;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0x80);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.303 -0400", hash_original_method = "29BC59263985E8B6D4DC540BD2555DBE", hash_generated_method = "6711977F1DB7114204B596B3BC452071")
    @Override
    public boolean isLoopbackAddress() {
        boolean var1253ED8B41F2F9545D66C1E325A06412_773816988 = (Arrays.equals(ipaddress, Inet6Address.LOOPBACK.ipaddress));
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1319646148 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1319646148;
        // ---------- Original Method ----------
        //return Arrays.equals(ipaddress, Inet6Address.LOOPBACK.ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.304 -0400", hash_original_method = "54D483B8739F01A2815B2B8F656686DE", hash_generated_method = "F55DC67A1D57658706192E6F053D8E43")
    @Override
    public boolean isMCGlobal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1015906429 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1015906429;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x0e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.304 -0400", hash_original_method = "DCFE2D7DF3B86ED730BA1C809E9E7D4A", hash_generated_method = "6F3E6B890F0C9110273E3DC10D96FC1C")
    @Override
    public boolean isMCLinkLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1740029573 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1740029573;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x02);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.314 -0400", hash_original_method = "A2CA5CB23BE5DDD68CAA7DA2135DB2EA", hash_generated_method = "488C10338E2DA184E20C744C03166093")
    @Override
    public boolean isMCNodeLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1958117492 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1958117492;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x01);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.314 -0400", hash_original_method = "54DE0BED5AB4157674DB2DAF2389E694", hash_generated_method = "7B6FECE3CA4641B282847F54F8E93E53")
    @Override
    public boolean isMCOrgLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1356072829 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1356072829;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x08);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.315 -0400", hash_original_method = "F3FC244CCF2BE8692CC93BDBE33FAF7E", hash_generated_method = "77C6AEEE8D665FD422793D438C7E95A2")
    @Override
    public boolean isMCSiteLocal() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_110293113 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_110293113;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x05);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.315 -0400", hash_original_method = "421AE0BE80F642901B6D5A89B5DB9DC1", hash_generated_method = "CEFE03649F5C61EA2634600677A3ECD2")
    @Override
    public boolean isMulticastAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1856990612 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1856990612;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.315 -0400", hash_original_method = "3C2D74882AEFA2EBBC23E3A728C5AE01", hash_generated_method = "66B4796684D115A64F27D22BB6D4D816")
    @Override
    public boolean isSiteLocalAddress() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_631979335 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_631979335;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0xc0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.316 -0400", hash_original_method = "50E705BC98343A8115E00AFCB06615D7", hash_generated_method = "8F47E99B6C5A43AA24CF053D55C6C74F")
    public int getScopeId() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048735626 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1048735626;
        // ---------- Original Method ----------
        //return scope_id_set ? scope_id : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.316 -0400", hash_original_method = "F4AA364893CE5E0A3EC053A0FC0AB68A", hash_generated_method = "D1AC7F13ED9089A2D76D675ABB133E65")
    public NetworkInterface getScopedInterface() {
        NetworkInterface varB4EAC82CA7396A68D541C85D26508E83_1731669805 = null; //Variable for return #1
        NetworkInterface varB4EAC82CA7396A68D541C85D26508E83_1786691609 = null; //Variable for return #2
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_1731669805 = (scope_ifname_set && ifname != null) ? NetworkInterface.getByName(ifname) : null;
        } //End block
        catch (SocketException ex)
        {
            varB4EAC82CA7396A68D541C85D26508E83_1786691609 = null;
        } //End block
        NetworkInterface varA7E53CE21691AB073D9660D615818899_27462603; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_27462603 = varB4EAC82CA7396A68D541C85D26508E83_1731669805;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_27462603 = varB4EAC82CA7396A68D541C85D26508E83_1786691609;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_27462603.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_27462603;
        // ---------- Original Method ----------
        //try {
            //return (scope_ifname_set && ifname != null) ? NetworkInterface.getByName(ifname) : null;
        //} catch (SocketException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.320 -0400", hash_original_method = "080327AC5673C5B50BEA99966675EA0A", hash_generated_method = "D60ABA30E8041352614DBCEDB2845BA2")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.329 -0400", hash_original_method = "6B9730D7168B0E96ABCC55BBF7E32967", hash_generated_method = "4B416658357249A879E059E2AFE5CD9D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.329 -0400", hash_original_method = "3CCDE4F93DD898D7C7483D8BBE2EDADA", hash_generated_method = "0D351A04BA4B1CFF3CF4372540EEB675")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2077035073 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1087097473 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_1320836455 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_2077035073 = super.toString() + "%" + ifname;
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1087097473 = super.toString() + "%" + scope_id;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1320836455 = super.toString();
        String varA7E53CE21691AB073D9660D615818899_1825194329; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1825194329 = varB4EAC82CA7396A68D541C85D26508E83_2077035073;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1825194329 = varB4EAC82CA7396A68D541C85D26508E83_1087097473;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1825194329 = varB4EAC82CA7396A68D541C85D26508E83_1320836455;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1825194329.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1825194329;
        // ---------- Original Method ----------
        //if (ifname != null) {
            //return super.toString() + "%" + ifname;
        //}
        //if (scope_id != 0) {
            //return super.toString() + "%" + scope_id;
        //}
        //return super.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.340 -0400", hash_original_field = "569165E5FD36BE01148D4A59F328A2B1", hash_generated_field = "33D5B764101CB1D00D682F17A2C7646C")

    private static long serialVersionUID = 6880410070516793377L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.340 -0400", hash_original_field = "4F54F398366A8A75C39C9AA9782CBE3E", hash_generated_field = "0DD864D68660257C63399D6AE1C39774")

    public static final InetAddress ANY =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, null, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.341 -0400", hash_original_field = "B621C0EA8E0C5A5ADAF6B2654665DD50", hash_generated_field = "6D8F13795697A62907A482E35E916FD1")

    public static final InetAddress LOOPBACK =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                    "localhost", 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:43.341 -0400", hash_original_field = "8B28DD0C39F68AE321A9E40E75021549", hash_generated_field = "DF3B779AC65293AACA2C768A9CD43464")

    private static ObjectStreamField[] serialPersistentFields = ;
}

