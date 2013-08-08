package java.net;

// Droidsafe Imports
import droidsafe.annotations.*;
import static libcore.io.OsConstants.AF_INET6;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.util.Arrays;
import java.util.Enumeration;






public final class Inet6Address extends InetAddress {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.573 -0400", hash_original_field = "4053739BB83B56A1ED1EFBD07BF580A5", hash_generated_field = "540B1C4E03CB3F83CE53991B800AA5B4")

    private boolean scope_id_set;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.573 -0400", hash_original_field = "945206A2664A2B0E39A9E7EC3D6C8BE0", hash_generated_field = "351D02D0A0BDA8B744D0089144674D8B")

    private int scope_id;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.573 -0400", hash_original_field = "BA3879874E52AA7A4341FD1D23ADA187", hash_generated_field = "D87D8B960AE4DD5A16D6F3BEBE7DE96B")

    private boolean scope_ifname_set;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.573 -0400", hash_original_field = "B1A5412C2B4EF5FC64890EE3803EBED5", hash_generated_field = "9CB9BAC1E4A6ACB09F6AABB6B922D3F0")

    private String ifname;
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.574 -0400", hash_original_method = "FCC74B21AAC45508B8719673A0766005", hash_generated_method = "CC74BD41AB3E931080E766B9DDC712C4")
      Inet6Address(byte[] ipaddress, String hostName, int scope_id) {
        super(AF_INET6, ipaddress, hostName);
        addTaint(hostName.getTaint());
        addTaint(ipaddress[0]);
        this.scope_id = scope_id;
        this.scope_id_set = (scope_id != 0);
        // ---------- Original Method ----------
        //this.scope_id = scope_id;
        //this.scope_id_set = (scope_id != 0);
    }

    
    @DSModeled(DSC.SAFE)
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.576 -0400", hash_original_method = "5C85837CE4C7853B5C8DB05F5798B94D", hash_generated_method = "23EF5A1DB78C3C94EF88F22C72CD03E4")
    private boolean compareLocalType(Inet6Address ia) {
        addTaint(ia.getTaint());
        if(ia.isSiteLocalAddress() && isSiteLocalAddress())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1694022983 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1720674118 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1720674118;
        } //End block
        if(ia.isLinkLocalAddress() && isLinkLocalAddress())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1573790482 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_865717472 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_865717472;
        } //End block
        if(!ia.isSiteLocalAddress() && !ia.isLinkLocalAddress())        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1907875981 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2092941801 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_2092941801;
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_1452706452 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_595942306 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_595942306;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.577 -0400", hash_original_method = "CB6B527FFA2A204FDEA9D4C37A9B03D5", hash_generated_method = "8C87B13A0991AAC082E0EEE73AA3136F")
    @Override
    public boolean isAnyLocalAddress() {
        boolean varF0BCD000C3B68BC2094721CF537784DA_1052175674 = (Arrays.equals(ipaddress, Inet6Address.ANY.ipaddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_451523045 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_451523045;
        // ---------- Original Method ----------
        //return Arrays.equals(ipaddress, Inet6Address.ANY.ipaddress);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.578 -0400", hash_original_method = "0048D9C1E27FFD1D482DB9672EA3AE03", hash_generated_method = "A1C665107EF3DF95079E1BD404F63CE0")
    public boolean isIPv4CompatibleAddress() {
for(int i = 0;i < 12;i++)
        {
            if(ipaddress[i] != 0)            
            {
                boolean var68934A3E9455FA72420237EB05902327_801432338 = (false);
                                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_922672378 = getTaintBoolean();
                return var84E2C64F38F78BA3EA5C905AB5A2DA27_922672378;
            } //End block
        } //End block
        boolean varB326B5062B2F0E69046810717534CB09_1838569401 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_958102515 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_958102515;
        // ---------- Original Method ----------
        //for (int i = 0; i < 12; i++) {
            //if (ipaddress[i] != 0) {
                //return false;
            //}
        //}
        //return true;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.580 -0400", hash_original_method = "9F5F5CEBE580C822E7F3125E303D498E", hash_generated_method = "AB897BFB80620B16303D56B8B31169C6")
    @Override
    public boolean isLinkLocalAddress() {
        boolean var1B7806100EF7DF9D115FB5C25F7F477B_2088947170 = (((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0x80));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056651069 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056651069;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0x80);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.580 -0400", hash_original_method = "29BC59263985E8B6D4DC540BD2555DBE", hash_generated_method = "8A43ED63EAE4A4C48B464C10F4A28EE8")
    @Override
    public boolean isLoopbackAddress() {
        boolean varB815A8AE0F4ADE1C8715B51E2243ECAE_528610773 = (Arrays.equals(ipaddress, Inet6Address.LOOPBACK.ipaddress));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2076328826 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2076328826;
        // ---------- Original Method ----------
        //return Arrays.equals(ipaddress, Inet6Address.LOOPBACK.ipaddress);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.581 -0400", hash_original_method = "54D483B8739F01A2815B2B8F656686DE", hash_generated_method = "5C2C07EEFE9F1500D1B3E384CBFBA7AB")
    @Override
    public boolean isMCGlobal() {
        boolean varCDA0726ADC94A41FEECEA90D24B3ED14_840617298 = (((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x0e));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1928000328 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1928000328;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x0e);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.582 -0400", hash_original_method = "DCFE2D7DF3B86ED730BA1C809E9E7D4A", hash_generated_method = "4FE9675D40096D7288B618220A127983")
    @Override
    public boolean isMCLinkLocal() {
        boolean var5E6297AE587703DC72935A39DC50861A_1186356859 = (((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x02));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1439712831 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1439712831;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x02);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.582 -0400", hash_original_method = "A2CA5CB23BE5DDD68CAA7DA2135DB2EA", hash_generated_method = "B3904EA8B292E343E0E60904CE9D3ADD")
    @Override
    public boolean isMCNodeLocal() {
        boolean var0490226B8466FDAB8E6C2D510B76FF2E_304702160 = (((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x01));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1518244383 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1518244383;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x01);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.583 -0400", hash_original_method = "54DE0BED5AB4157674DB2DAF2389E694", hash_generated_method = "3479E0B096563505617E7CAE3EACD359")
    @Override
    public boolean isMCOrgLocal() {
        boolean var83211C213A7B34829FB45804A60011B7_207951202 = (((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x08));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1942325007 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1942325007;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x08);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.584 -0400", hash_original_method = "F3FC244CCF2BE8692CC93BDBE33FAF7E", hash_generated_method = "7C7B417A1E8C7685B48EF5914EB6E007")
    @Override
    public boolean isMCSiteLocal() {
        boolean var3EFB650162BA17F8BDEF653AECD716C1_1207559995 = (((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x05));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_773075924 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_773075924;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff) && ((ipaddress[1] & 0x0f) == 0x05);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.584 -0400", hash_original_method = "421AE0BE80F642901B6D5A89B5DB9DC1", hash_generated_method = "40C685C5FEC3784C3DAF6FDDC06D688A")
    @Override
    public boolean isMulticastAddress() {
        boolean varF403369D5FA9239E89AE6DC89879B832_211860558 = (((ipaddress[0] & 0xff) == 0xff));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_191275415 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_191275415;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xff);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.585 -0400", hash_original_method = "3C2D74882AEFA2EBBC23E3A728C5AE01", hash_generated_method = "CF4FCDD7075A983148B3B6CDF0880B23")
    @Override
    public boolean isSiteLocalAddress() {
        boolean var3F9F96271FB6CCEA6DEA05DDB46E74D5_1100625715 = (((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0xc0));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2037349112 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2037349112;
        // ---------- Original Method ----------
        //return ((ipaddress[0] & 0xff) == 0xfe) && ((ipaddress[1] & 0xc0) == 0xc0);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.585 -0400", hash_original_method = "50E705BC98343A8115E00AFCB06615D7", hash_generated_method = "813138D881468B0B4A5A85A7345E20C6")
    public int getScopeId() {
        int varBB72CB804BAAB3F6631DAC16FDDF0A60_537529122 = (scope_id_set ? scope_id : 0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097559608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2097559608;
        // ---------- Original Method ----------
        //return scope_id_set ? scope_id : 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.586 -0400", hash_original_method = "F4AA364893CE5E0A3EC053A0FC0AB68A", hash_generated_method = "59DE5967F7B2F3695E9D3B0FFA74DC95")
    public NetworkInterface getScopedInterface() {
        try 
        {
NetworkInterface var670F0207639AADBD1A2638194C71812C_940052033 =             (scope_ifname_set && ifname != null) ? NetworkInterface.getByName(ifname) : null;
            var670F0207639AADBD1A2638194C71812C_940052033.addTaint(taint);
            return var670F0207639AADBD1A2638194C71812C_940052033;
        } //End block
        catch (SocketException ex)
        {
NetworkInterface var540C13E9E156B687226421B24F2DF178_114362307 =             null;
            var540C13E9E156B687226421B24F2DF178_114362307.addTaint(taint);
            return var540C13E9E156B687226421B24F2DF178_114362307;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return (scope_ifname_set && ifname != null) ? NetworkInterface.getByName(ifname) : null;
        //} catch (SocketException ex) {
            //return null;
        //}
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.587 -0400", hash_original_method = "080327AC5673C5B50BEA99966675EA0A", hash_generated_method = "183CD4E1701B0FCE236E7B16111BB19B")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        addTaint(stream.getTaint());
        ObjectOutputStream.PutField fields = stream.putFields();
        if(ipaddress == null)        
        {
            fields.put("ipaddress", null);
        } //End block
        else
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.588 -0400", hash_original_method = "6B9730D7168B0E96ABCC55BBF7E32967", hash_generated_method = "68D3888C49FC9CBA826C41D110806B7B")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        addTaint(stream.getTaint());
        ObjectInputStream.GetField fields = stream.readFields();
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.589 -0400", hash_original_method = "3CCDE4F93DD898D7C7483D8BBE2EDADA", hash_generated_method = "020C88E99F76B861A0E9A6EE8411745E")
    @Override
    public String toString() {
        if(ifname != null)        
        {
String var513E1C9C97BE616BBA449C00266EF245_1241129034 =             super.toString() + "%" + ifname;
            var513E1C9C97BE616BBA449C00266EF245_1241129034.addTaint(taint);
            return var513E1C9C97BE616BBA449C00266EF245_1241129034;
        } //End block
        if(scope_id != 0)        
        {
String var7DFC9E25F05AAB46CA8381F63C666066_609847483 =             super.toString() + "%" + scope_id;
            var7DFC9E25F05AAB46CA8381F63C666066_609847483.addTaint(taint);
            return var7DFC9E25F05AAB46CA8381F63C666066_609847483;
        } //End block
String varD8287C6801A4C167675BF9EBA9EC2C1B_2012835140 =         super.toString();
        varD8287C6801A4C167675BF9EBA9EC2C1B_2012835140.addTaint(taint);
        return varD8287C6801A4C167675BF9EBA9EC2C1B_2012835140;
        // ---------- Original Method ----------
        //if (ifname != null) {
            //return super.toString() + "%" + ifname;
        //}
        //if (scope_id != 0) {
            //return super.toString() + "%" + scope_id;
        //}
        //return super.toString();
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.589 -0400", hash_original_field = "569165E5FD36BE01148D4A59F328A2B1", hash_generated_field = "33860EDD36D3C15C684CA6291D57C5F3")

    private static final long serialVersionUID = 6880410070516793377L;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.589 -0400", hash_original_field = "4F54F398366A8A75C39C9AA9782CBE3E", hash_generated_field = "0DD864D68660257C63399D6AE1C39774")

    public static final InetAddress ANY =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, null, 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.589 -0400", hash_original_field = "B621C0EA8E0C5A5ADAF6B2654665DD50", hash_generated_field = "6D8F13795697A62907A482E35E916FD1")

    public static final InetAddress LOOPBACK =
            new Inet6Address(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                    "localhost", 0);
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.590 -0400", hash_original_field = "8B28DD0C39F68AE321A9E40E75021549", hash_generated_field = "80F683DFFB1443818A3133094A7F3E44")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("ipaddress", byte[].class),
        new ObjectStreamField("scope_id", int.class),
        new ObjectStreamField("scope_id_set", boolean.class),
        new ObjectStreamField("scope_ifname_set", boolean.class),
        new ObjectStreamField("ifname", String.class),
    };
}

