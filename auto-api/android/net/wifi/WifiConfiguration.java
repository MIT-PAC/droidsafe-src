package android.net.wifi;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.net.LinkProperties;
import android.os.Parcelable;
import android.os.Parcel;
import java.util.BitSet;

public class WifiConfiguration implements Parcelable {
    public EnterpriseField eap = new EnterpriseField("eap");
    public EnterpriseField phase2 = new EnterpriseField("phase2");
    public EnterpriseField identity = new EnterpriseField("identity");
    public EnterpriseField anonymous_identity = new EnterpriseField("anonymous_identity");
    public EnterpriseField password = new EnterpriseField("password");
    public EnterpriseField client_cert = new EnterpriseField("client_cert");
    public EnterpriseField private_key = new EnterpriseField("private_key");
    public EnterpriseField ca_cert = new EnterpriseField("ca_cert");
    public EnterpriseField[] enterpriseFields = {
            eap, phase2, identity, anonymous_identity, password, client_cert,
            private_key, ca_cert };
    public int networkId;
    public int status;
    public int disableReason;
    public String SSID;
    public String BSSID;
    public String preSharedKey;
    public String[] wepKeys;
    public int wepTxKeyIndex;
    public int priority;
    public boolean hiddenSSID;
    public BitSet allowedKeyManagement;
    public BitSet allowedProtocols;
    public BitSet allowedAuthAlgorithms;
    public BitSet allowedPairwiseCiphers;
    public BitSet allowedGroupCiphers;
    public IpAssignment ipAssignment;
    public ProxySettings proxySettings;
    public LinkProperties linkProperties;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.580 -0400", hash_original_method = "D3E8F62AB6837E859D554E7D52419BA9", hash_generated_method = "2830C72733C94CA893A03BD369A6D4E2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiConfiguration() {
        networkId = INVALID_NETWORK_ID;
        SSID = null;
        BSSID = null;
        priority = 0;
        hiddenSSID = false;
        disableReason = DISABLED_UNKNOWN_REASON;
        allowedKeyManagement = new BitSet();
        allowedProtocols = new BitSet();
        allowedAuthAlgorithms = new BitSet();
        allowedPairwiseCiphers = new BitSet();
        allowedGroupCiphers = new BitSet();
        wepKeys = new String[4];
        {
            int i;
            i = 0;
            wepKeys[i] = null;
        } //End collapsed parenthetic
        {
            Iterator<EnterpriseField> var678F2F58729F4ED0BC9B36F9AFA65128_776279516 = (enterpriseFields).iterator();
            var678F2F58729F4ED0BC9B36F9AFA65128_776279516.hasNext();
            EnterpriseField field = var678F2F58729F4ED0BC9B36F9AFA65128_776279516.next();
            {
                field.setValue(null);
            } //End block
        } //End collapsed parenthetic
        ipAssignment = IpAssignment.UNASSIGNED;
        proxySettings = ProxySettings.UNASSIGNED;
        linkProperties = new LinkProperties();
        // ---------- Original Method ----------
        //networkId = INVALID_NETWORK_ID;
        //SSID = null;
        //BSSID = null;
        //priority = 0;
        //hiddenSSID = false;
        //disableReason = DISABLED_UNKNOWN_REASON;
        //allowedKeyManagement = new BitSet();
        //allowedProtocols = new BitSet();
        //allowedAuthAlgorithms = new BitSet();
        //allowedPairwiseCiphers = new BitSet();
        //allowedGroupCiphers = new BitSet();
        //wepKeys = new String[4];
        //for (int i = 0; i < wepKeys.length; i++)
            //wepKeys[i] = null;
        //for (EnterpriseField field : enterpriseFields) {
            //field.setValue(null);
        //}
        //ipAssignment = IpAssignment.UNASSIGNED;
        //proxySettings = ProxySettings.UNASSIGNED;
        //linkProperties = new LinkProperties();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.580 -0400", hash_original_method = "C987CC483E64718E2FB8D8B4A4E18BC6", hash_generated_method = "096EEF9579FB29B66AC81E10DCBAC4B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public WifiConfiguration(WifiConfiguration source) {
        dsTaint.addTaint(source.dsTaint);
        {
            networkId = source.networkId;
            status = source.status;
            disableReason = source.disableReason;
            SSID = source.SSID;
            BSSID = source.BSSID;
            preSharedKey = source.preSharedKey;
            wepKeys = new String[4];
            {
                int i;
                i = 0;
                wepKeys[i] = source.wepKeys[i];
            } //End collapsed parenthetic
            wepTxKeyIndex = source.wepTxKeyIndex;
            priority = source.priority;
            hiddenSSID = source.hiddenSSID;
            allowedKeyManagement   = (BitSet) source.allowedKeyManagement.clone();
            allowedProtocols       = (BitSet) source.allowedProtocols.clone();
            allowedAuthAlgorithms  = (BitSet) source.allowedAuthAlgorithms.clone();
            allowedPairwiseCiphers = (BitSet) source.allowedPairwiseCiphers.clone();
            allowedGroupCiphers    = (BitSet) source.allowedGroupCiphers.clone();
            {
                int i;
                i = 0;
                {
                    enterpriseFields[i].setValue(source.enterpriseFields[i].value());
                } //End block
            } //End collapsed parenthetic
            ipAssignment = source.ipAssignment;
            proxySettings = source.proxySettings;
            linkProperties = new LinkProperties(source.linkProperties);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.602 -0400", hash_original_method = "97D3C3FCC664C1BBD8134CCAC12AD4F6", hash_generated_method = "7C7C7D1DC23CB3D58F895BFF11F441A5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        StringBuilder sbuf;
        sbuf = new StringBuilder();
        {
            sbuf.append("* ");
        } //End block
        {
            sbuf.append("- DSBLE: ").append(this.disableReason).append(" ");
        } //End block
        sbuf.append("ID: ").append(this.networkId).append(" SSID: ").append(this.SSID).
                append(" BSSID: ").append(this.BSSID).append(" PRIO: ").append(this.priority).
                append('\n');
        sbuf.append(" KeyMgmt:");
        {
            int k;
            k = 0;
            boolean var6344AE5E4D51EF86F9E69D2509FF3F53_1928428807 = (k < this.allowedKeyManagement.size());
            {
                {
                    boolean var6538540D77E95514BEA29E885917E7A6_60831428 = (this.allowedKeyManagement.get(k));
                    {
                        sbuf.append(" ");
                        {
                            sbuf.append(KeyMgmt.strings[k]);
                        } //End block
                        {
                            sbuf.append("??");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sbuf.append(" Protocols:");
        {
            int p;
            p = 0;
            boolean varF89C4384F1946F0835919298E15824BA_1207825236 = (p < this.allowedProtocols.size());
            {
                {
                    boolean var18524E6DA066A52B7DFEEC0FE2031CD8_812008326 = (this.allowedProtocols.get(p));
                    {
                        sbuf.append(" ");
                        {
                            sbuf.append(Protocol.strings[p]);
                        } //End block
                        {
                            sbuf.append("??");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sbuf.append('\n');
        sbuf.append(" AuthAlgorithms:");
        {
            int a;
            a = 0;
            boolean varB378BB2E4222125FCFFE884AA66C7852_1331124405 = (a < this.allowedAuthAlgorithms.size());
            {
                {
                    boolean var32D89327DB56FDB8753508CC35A87BA5_1037194837 = (this.allowedAuthAlgorithms.get(a));
                    {
                        sbuf.append(" ");
                        {
                            sbuf.append(AuthAlgorithm.strings[a]);
                        } //End block
                        {
                            sbuf.append("??");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sbuf.append('\n');
        sbuf.append(" PairwiseCiphers:");
        {
            int pc;
            pc = 0;
            boolean var86C60C5F9C326935F7741053A7747DDE_745248055 = (pc < this.allowedPairwiseCiphers.size());
            {
                {
                    boolean var19A5405B85D009D1415BE39086A3A78B_1620932206 = (this.allowedPairwiseCiphers.get(pc));
                    {
                        sbuf.append(" ");
                        {
                            sbuf.append(PairwiseCipher.strings[pc]);
                        } //End block
                        {
                            sbuf.append("??");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sbuf.append('\n');
        sbuf.append(" GroupCiphers:");
        {
            int gc;
            gc = 0;
            boolean varC0901A757B0FC9D1DD6D07D335CD9157_1966768478 = (gc < this.allowedGroupCiphers.size());
            {
                {
                    boolean var61B47E87EA5FFE08A10FD5A483104120_2011571020 = (this.allowedGroupCiphers.get(gc));
                    {
                        sbuf.append(" ");
                        {
                            sbuf.append(GroupCipher.strings[gc]);
                        } //End block
                        {
                            sbuf.append("??");
                        } //End block
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        sbuf.append('\n').append(" PSK: ");
        {
            sbuf.append('*');
        } //End block
        {
            EnterpriseField field = enterpriseFields[0];
            {
                sbuf.append('\n').append(" " + field.varName() + ": ");
                String value;
                value = field.value();
                sbuf.append(value);
            } //End block
        } //End collapsed parenthetic
        sbuf.append('\n');
        sbuf.append("IP assignment: " + ipAssignment.toString());
        sbuf.append("\n");
        sbuf.append("Proxy settings: " + proxySettings.toString());
        sbuf.append("\n");
        sbuf.append(linkProperties.toString());
        sbuf.append("\n");
        String var0826C75FB1499484A6621049C9E9DB4E_1443901227 = (sbuf.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        private static BitSet readBitSet(Parcel src) {
        int cardinality = src.readInt();
        BitSet set = new BitSet();
        for (int i = 0; i < cardinality; i++)
            set.set(src.readInt());
        return set;
    }

    
        private static void writeBitSet(Parcel dest, BitSet set) {
        int nextSetBit = -1;
        dest.writeInt(set.cardinality());
        while ((nextSetBit = set.nextSetBit(nextSetBit + 1)) != -1)
            dest.writeInt(nextSetBit);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.603 -0400", hash_original_method = "9AFA2ED3E118B7190C0E7E9D5FFF2220", hash_generated_method = "C71120861E8D9743CC4AA0B49DCD4C1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int getAuthType() {
        {
            boolean varE93DC8655EF0DD69E686AF06F14E0918_1113674262 = (allowedKeyManagement.get(KeyMgmt.WPA_PSK));
            {
                boolean var42CF8460E8D6F6A47D2CA7872F5362AA_417006040 = (allowedKeyManagement.get(KeyMgmt.WPA2_PSK));
                {
                    boolean var4487495D93A95B2C963D38511EB68D01_828308592 = (allowedKeyManagement.get(KeyMgmt.WPA_EAP));
                    {
                        boolean var4D4EA5960C97B479E7F35032E5647B64_1358498953 = (allowedKeyManagement.get(KeyMgmt.IEEE8021X));
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (allowedKeyManagement.get(KeyMgmt.WPA_PSK)) {
            //return KeyMgmt.WPA_PSK;
        //} else if (allowedKeyManagement.get(KeyMgmt.WPA2_PSK)) {
            //return KeyMgmt.WPA2_PSK;
        //} else if (allowedKeyManagement.get(KeyMgmt.WPA_EAP)) {
            //return KeyMgmt.WPA_EAP;
        //} else if (allowedKeyManagement.get(KeyMgmt.IEEE8021X)) {
            //return KeyMgmt.IEEE8021X;
        //}
        //return KeyMgmt.NONE;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.603 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.611 -0400", hash_original_method = "AEDB33EEF5EAFBB380DF78B8CF162994", hash_generated_method = "A967017C5F2B6B43F6A05B18EF5FB33B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeInt(networkId);
        dest.writeInt(status);
        dest.writeInt(disableReason);
        dest.writeString(SSID);
        dest.writeString(BSSID);
        dest.writeString(preSharedKey);
        {
            String wepKey = wepKeys[0];
            dest.writeString(wepKey);
        } //End collapsed parenthetic
        dest.writeInt(wepTxKeyIndex);
        dest.writeInt(priority);
        dest.writeInt(hiddenSSID ? 1 : 0);
        writeBitSet(dest, allowedKeyManagement);
        writeBitSet(dest, allowedProtocols);
        writeBitSet(dest, allowedAuthAlgorithms);
        writeBitSet(dest, allowedPairwiseCiphers);
        writeBitSet(dest, allowedGroupCiphers);
        {
            EnterpriseField field = enterpriseFields[0];
            {
                dest.writeString(field.value());
            } //End block
        } //End collapsed parenthetic
        dest.writeString(ipAssignment.name());
        dest.writeString(proxySettings.name());
        dest.writeParcelable(linkProperties, flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public class EnterpriseField {
        private String varName;
        private String value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.612 -0400", hash_original_method = "8BFEE65AD67A1E932B47390435D592EC", hash_generated_method = "B5A7CEEEF11D107EB37157CD698EFCB3")
        @DSModeled(DSC.SAFE)
        private EnterpriseField(String varName) {
            dsTaint.addTaint(varName);
            this.value = null;
            // ---------- Original Method ----------
            //this.varName = varName;
            //this.value = null;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.612 -0400", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "4F4F7F37856EA1BF8C0BF221B2AF5ABB")
        @DSModeled(DSC.SAFE)
        public void setValue(String value) {
            dsTaint.addTaint(value);
            // ---------- Original Method ----------
            //this.value = value;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.612 -0400", hash_original_method = "1FBB233886BBDFBC3AF13BD83F42443E", hash_generated_method = "FED610ECAFBC0340505676C88989DD38")
        @DSModeled(DSC.SAFE)
        public String varName() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return varName;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.613 -0400", hash_original_method = "75F20E3AB28F2448BFFE64E6D18AFDB6", hash_generated_method = "496892A34BB691AAF7D193076ACF2F9B")
        @DSModeled(DSC.SAFE)
        public String value() {
            return dsTaint.getTaintString();
            // ---------- Original Method ----------
            //return value;
        }

        
    }


    
    public static class KeyMgmt {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.613 -0400", hash_original_method = "3C24C7AE0F0A09BE18E455DF08BF91AE", hash_generated_method = "84233618D069A8DDF728C3B1AD79C9CD")
        @DSModeled(DSC.SAFE)
        private KeyMgmt() {
            // ---------- Original Method ----------
        }

        
        public static final int NONE = 0;
        public static final int WPA_PSK = 1;
        public static final int WPA_EAP = 2;
        public static final int IEEE8021X = 3;
        public static final int WPA2_PSK = 4;
        public static final String varName = "key_mgmt";
        public static final String[] strings = { "NONE", "WPA_PSK", "WPA_EAP", "IEEE8021X",
                "WPA2_PSK" };
    }


    
    public static class Protocol {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.613 -0400", hash_original_method = "FEC0085CF7FD0AE9B8536A4264422A72", hash_generated_method = "BDFBDD91E12BC6AB0AC098F24E528B8C")
        @DSModeled(DSC.SAFE)
        private Protocol() {
            // ---------- Original Method ----------
        }

        
        public static final int WPA = 0;
        public static final int RSN = 1;
        public static final String varName = "proto";
        public static final String[] strings = { "WPA", "RSN" };
    }


    
    public static class AuthAlgorithm {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.613 -0400", hash_original_method = "02B498F2C9B084569031A4C2852FE733", hash_generated_method = "0DC3E2E4C06E7A517A353243CDD6C6F7")
        @DSModeled(DSC.SAFE)
        private AuthAlgorithm() {
            // ---------- Original Method ----------
        }

        
        public static final int OPEN = 0;
        public static final int SHARED = 1;
        public static final int LEAP = 2;
        public static final String varName = "auth_alg";
        public static final String[] strings = { "OPEN", "SHARED", "LEAP" };
    }


    
    public static class PairwiseCipher {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.613 -0400", hash_original_method = "D49801CF041AD620DA06D49E02E3EE50", hash_generated_method = "80B019872D8101A5104B248737E04786")
        @DSModeled(DSC.SAFE)
        private PairwiseCipher() {
            // ---------- Original Method ----------
        }

        
        public static final int NONE = 0;
        public static final int TKIP = 1;
        public static final int CCMP = 2;
        public static final String varName = "pairwise";
        public static final String[] strings = { "NONE", "TKIP", "CCMP" };
    }


    
    public static class GroupCipher {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.614 -0400", hash_original_method = "A10BFAF56809802940D7EFFA4240EAB0", hash_generated_method = "65BD6B7E2641A28A143BE5DB0E9B6215")
        @DSModeled(DSC.SAFE)
        private GroupCipher() {
            // ---------- Original Method ----------
        }

        
        public static final int WEP40 = 0;
        public static final int WEP104 = 1;
        public static final int TKIP = 2;
        public static final int CCMP = 3;
        public static final String varName = "group";
        public static final String[] strings = { "WEP40", "WEP104", "TKIP", "CCMP" };
    }


    
    public static class Status {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.614 -0400", hash_original_method = "FE406DC4CFD00C0AE0BFBAA724FB9F50", hash_generated_method = "7E294D2CADE3312347600003F64067B6")
        @DSModeled(DSC.SAFE)
        private Status() {
            // ---------- Original Method ----------
        }

        
        public static final int CURRENT = 0;
        public static final int DISABLED = 1;
        public static final int ENABLED = 2;
        public static final String[] strings = { "current", "disabled", "enabled" };
    }


    
    public enum IpAssignment {
        STATIC,
        DHCP,
        UNASSIGNED
    }

    
    public enum ProxySettings {
        NONE,
        STATIC,
        UNASSIGNED
    }

    
    public static final String ssidVarName = "ssid";
    public static final String bssidVarName = "bssid";
    public static final String pskVarName = "psk";
    public static final String[] wepKeyVarNames = { "wep_key0", "wep_key1", "wep_key2", "wep_key3" };
    public static final String wepTxKeyIdxVarName = "wep_tx_keyidx";
    public static final String priorityVarName = "priority";
    public static final String hiddenSSIDVarName = "scan_ssid";
    public static final int INVALID_NETWORK_ID = -1;
    public static final int DISABLED_UNKNOWN_REASON                         = 0;
    public static final int DISABLED_DNS_FAILURE                            = 1;
    public static final int DISABLED_DHCP_FAILURE                           = 2;
    public static final int DISABLED_AUTH_FAILURE                           = 3;
    public static final Creator<WifiConfiguration> CREATOR = new Creator<WifiConfiguration>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.615 -0400", hash_original_method = "20D1CB558DAB6A81BAFA1424EC8D2FB7", hash_generated_method = "6985A44BE85B80BD6673FA3503ED4239")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiConfiguration createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            WifiConfiguration config;
            config = new WifiConfiguration();
            config.networkId = in.readInt();
            config.status = in.readInt();
            config.disableReason = in.readInt();
            config.SSID = in.readString();
            config.BSSID = in.readString();
            config.preSharedKey = in.readString();
            {
                int i;
                i = 0;
                config.wepKeys[i] = in.readString();
            } //End collapsed parenthetic
            config.wepTxKeyIndex = in.readInt();
            config.priority = in.readInt();
            config.hiddenSSID = in.readInt() != 0;
            config.allowedKeyManagement   = readBitSet(in);
            config.allowedProtocols       = readBitSet(in);
            config.allowedAuthAlgorithms  = readBitSet(in);
            config.allowedPairwiseCiphers = readBitSet(in);
            config.allowedGroupCiphers    = readBitSet(in);
            {
                Iterator<EnterpriseField> var1A6EB7A4488D54D14117D9B44CEAF780_281335446 = (config.enterpriseFields).iterator();
                var1A6EB7A4488D54D14117D9B44CEAF780_281335446.hasNext();
                EnterpriseField field = var1A6EB7A4488D54D14117D9B44CEAF780_281335446.next();
                {
                    field.setValue(in.readString());
                } //End block
            } //End collapsed parenthetic
            config.ipAssignment = IpAssignment.valueOf(in.readString());
            config.proxySettings = ProxySettings.valueOf(in.readString());
            config.linkProperties = in.readParcelable(null);
            return (WifiConfiguration)dsTaint.getTaint();
            // ---------- Original Method ----------
            // Original Method Too Long, Refer to Original Implementation
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:52.616 -0400", hash_original_method = "9695315CC5B8495CD0481DA1F47B5482", hash_generated_method = "F5DE4B25E0FDF109660C47B9929E94DB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public WifiConfiguration[] newArray(int size) {
            dsTaint.addTaint(size);
            WifiConfiguration[] varED4E7F729AC6444BB2CA00624A2C96DD_1011816475 = (new WifiConfiguration[size]);
            return (WifiConfiguration[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new WifiConfiguration[size];
        }

        
}; //Transformed anonymous class
}

