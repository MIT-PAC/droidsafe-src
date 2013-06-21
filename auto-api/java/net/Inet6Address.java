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
    private boolean scope_id_set;
    private int scope_id;
    private boolean scope_ifname_set;
    private String ifname;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.843 -0400", hash_original_method = "FCC74B21AAC45508B8719673A0766005", hash_generated_method = "723D3B981D49EAE017A0049E19569619")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     Inet6Address(byte[] ipaddress, String hostName, int scope_id) {
        super(AF_INET6, ipaddress, hostName);
        dsTaint.addTaint(hostName);
        dsTaint.addTaint(scope_id);
        dsTaint.addTaint(ipaddress[0]);
        this.scope_id_set = (scope_id != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.844 -0400", hash_original_method = "5C85837CE4C7853B5C8DB05F5798B94D", hash_generated_method = "323A55B9B9A88F10DD8BBD03BEEF44B1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private boolean compareLocalType(Inet6Address ia) {
        dsTaint.addTaint(ia.dsTaint);
        {
            boolean var55ABA625F481830BD34F8B5466690BF7_743380146 = (ia.isSiteLocalAddress() && isSiteLocalAddress());
        } //End collapsed parenthetic
        {
            boolean var71EB32049A5AB07C1504847D1DCB7BE5_1078455818 = (ia.isLinkLocalAddress() && isLinkLocalAddress());
        } //End collapsed parenthetic
        {
            boolean var438C605FD4250DE117DD86CFD9F1B343_1934224979 = (!ia.isSiteLocalAddress() && !ia.isLinkLocalAddress());
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.844 -0400", hash_original_method = "CB6B527FFA2A204FDEA9D4C37A9B03D5", hash_generated_method = "8D347710B0517B4D71E012FD6CB8AE51")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isAnyLocalAddress() {
        boolean varB01692C366B404EF7C26158B42FD3EB5_162557699 = (Arrays.equals(ipaddress, Inet6Address.ANY.ipaddress));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Arrays.equals(ipaddress, Inet6Address.ANY.ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.845 -0400", hash_original_method = "0048D9C1E27FFD1D482DB9672EA3AE03", hash_generated_method = "325D1D40392A12047ECD9BA303CEC533")
    @DSModeled(DSC.SAFE)
    public boolean isIPv4CompatibleAddress() {
        {
            int i;
            i = 0;
        } //End collapsed parenthetic
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //for (int i = 0; i < 12; i++) {
            //if (ipaddress[i] != 0) {
                //return false;
            //}
        //}
        //return true;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.845 -0400", hash_original_method = "9F5F5CEBE580C822E7F3125E303D498E", hash_generated_method = "E928F4054F7842AF63091134CFAF8261")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isLinkLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0x80);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.845 -0400", hash_original_method = "29BC59263985E8B6D4DC540BD2555DBE", hash_generated_method = "80B28074A0A7E67A502CAB2E0EED72CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean isLoopbackAddress() {
        boolean var1253ED8B41F2F9545D66C1E325A06412_1061983996 = (Arrays.equals(ipaddress, Inet6Address.LOOPBACK.ipaddress));
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return Arrays.equals(ipaddress, Inet6Address.LOOPBACK.ipaddress);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.845 -0400", hash_original_method = "54D483B8739F01A2815B2B8F656686DE", hash_generated_method = "D96CA96BF90A1F3F0CF6765020AE6C3A")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCGlobal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x0e);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.846 -0400", hash_original_method = "DCFE2D7DF3B86ED730BA1C809E9E7D4A", hash_generated_method = "10CAFA204B588E9F0203A2E8494CD129")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCLinkLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x02);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.846 -0400", hash_original_method = "A2CA5CB23BE5DDD68CAA7DA2135DB2EA", hash_generated_method = "6CDE1A6174BAEB3160404EF773F26B1D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCNodeLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x01);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.846 -0400", hash_original_method = "54DE0BED5AB4157674DB2DAF2389E694", hash_generated_method = "323EB5EA616CCFECA8F00BEDB7C8408F")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCOrgLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x08);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.846 -0400", hash_original_method = "F3FC244CCF2BE8692CC93BDBE33FAF7E", hash_generated_method = "0C8C1B83E0CC2A890CB560C77CAB5D8E")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMCSiteLocal() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x05);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.846 -0400", hash_original_method = "421AE0BE80F642901B6D5A89B5DB9DC1", hash_generated_method = "EF10D2714682F8AD34DAA13480CB8C2D")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isMulticastAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.847 -0400", hash_original_method = "3C2D74882AEFA2EBBC23E3A728C5AE01", hash_generated_method = "9122789057EE6AC0381974CF9DD81C6F")
    @DSModeled(DSC.SAFE)
    @Override
    public boolean isSiteLocalAddress() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0xc0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.847 -0400", hash_original_method = "50E705BC98343A8115E00AFCB06615D7", hash_generated_method = "3861AE8C21C83AAC1AFF9EC283A6CB6D")
    @DSModeled(DSC.SAFE)
    public int getScopeId() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return scope_id_set ? scope_id : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.847 -0400", hash_original_method = "F4AA364893CE5E0A3EC053A0FC0AB68A", hash_generated_method = "786BF5F60FE251D0EB0AD3795DA1F1B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkInterface getScopedInterface() {
        try 
        {
            {
                Object var6A1A8B3CC2BCE2D0DCC6E7BB80A5AD67_1370999644 = (NetworkInterface.getByName(ifname));
            } //End flattened ternary
        } //End block
        catch (SocketException ex)
        { }
        return (NetworkInterface)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return (scope_ifname_set && ifname != null) ? NetworkInterface.getByName(ifname) : null;
        //} catch (SocketException ex) {
            //return null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.848 -0400", hash_original_method = "080327AC5673C5B50BEA99966675EA0A", hash_generated_method = "9FB13B46DF4D485DD9F3CF2C781CE576")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeObject(ObjectOutputStream stream) throws IOException {
        dsTaint.addTaint(stream.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.848 -0400", hash_original_method = "6B9730D7168B0E96ABCC55BBF7E32967", hash_generated_method = "AF4AD2E14B4C975F4CFAA74129FA72A7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        dsTaint.addTaint(stream.dsTaint);
        ObjectInputStream.GetField fields;
        fields = stream.readFields();
        ipaddress = (byte[]) fields.get("ipaddress", null);
        scope_id = fields.get("scope_id", 0);
        scope_id_set = fields.get("scope_id_set", false);
        ifname = (String) fields.get("ifname", null);
        scope_ifname_set = fields.get("scope_ifname_set", false);
        // ---------- Original Method ----------
        //ObjectInputStream.GetField fields = stream.readFields();
        //ipaddress = (byte[]) fields.get("ipaddress", null);
        //scope_id = fields.get("scope_id", 0);
        //scope_id_set = fields.get("scope_id_set", false);
        //ifname = (String) fields.get("ifname", null);
        //scope_ifname_set = fields.get("scope_ifname_set", false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:27.848 -0400", hash_original_method = "3CCDE4F93DD898D7C7483D8BBE2EDADA", hash_generated_method = "3B09BC9427DC413281FFC715924C77B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        {
            String varC03A2F8C14EEE12344CD8F1674F876C8_158969045 = (super.toString() + "%" + ifname);
        } //End block
        {
            String var7C2F65A4D8FA61FE8A45FB334EBA1A17_1913669358 = (super.toString() + "%" + scope_id);
        } //End block
        String var68E86BD9F434ADE8AAF95F248D77470C_1777291270 = (super.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (ifname != null) {
            //return super.toString() + "%" + ifname;
        //}
        //if (scope_id != 0) {
            //return super.toString() + "%" + scope_id;
        //}
        //return super.toString();
    }

    
    private static final long serialVersionUID = 6880410070516793377L;
    public static final InetAddress ANY =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, null, 0);
    public static final InetAddress LOOPBACK =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                    "localhost", 0);
    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("ipaddress", byte[].class),
        new ObjectStreamField("scope_id", int.class),
        new ObjectStreamField("scope_id_set", boolean.class),
        new ObjectStreamField("scope_ifname_set", boolean.class),
        new ObjectStreamField("ifname", String.class),
    };
}

