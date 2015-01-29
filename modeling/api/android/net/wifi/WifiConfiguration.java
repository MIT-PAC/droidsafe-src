package android.net.wifi;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.BitSet;

import android.net.LinkProperties;
import android.os.Parcel;
import android.os.Parcelable;

public class WifiConfiguration implements Parcelable {

    /**
     * Construct a WifiConfiguration from a scanned network
     * @param scannedAP the scan result used to construct the config entry
     * TODO: figure out whether this is a useful way to construct a new entry.
     *
    public WifiConfiguration(ScanResult scannedAP) {
        networkId = -1;
        SSID = scannedAP.SSID;
        BSSID = scannedAP.BSSID;
    }
    */

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.002 -0500", hash_original_method = "DBF96D5200F7739E62BF98EED93355B3", hash_generated_method = "C5F3532563C170E7C786BD2894B50C43")
    
private static BitSet readBitSet(Parcel src) {
        int cardinality = src.readInt();

        BitSet set = new BitSet();
        for (int i = 0; i < cardinality; i++)
            set.set(src.readInt());

        return set;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.005 -0500", hash_original_method = "BC9E300E984E6DE1FCAF87B1F38C37A1", hash_generated_method = "616E59AD828D6F0D008AEA7A05B462EF")
    
private static void writeBitSet(Parcel dest, BitSet set) {
        int nextSetBit = -1;

        dest.writeInt(set.cardinality());

        while ((nextSetBit = set.nextSetBit(nextSetBit + 1)) != -1)
            dest.writeInt(nextSetBit);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.783 -0500", hash_original_field = "2CC4FDA77EC6552665C925E45401ED02", hash_generated_field = "E8CDBB9FFFFA56D2FC6AC1E012086750")

    public static final String ssidVarName = "ssid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.786 -0500", hash_original_field = "270C1EB1136EF99AFC330866E6DB5320", hash_generated_field = "615F5954486556CB6899ABD6591FA7EC")

    public static final String bssidVarName = "bssid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.788 -0500", hash_original_field = "511D6B1B37616FE092FFAB3B07C67F0B", hash_generated_field = "1B32B7500DA776F594AF591AD38ADF09")

    public static final String pskVarName = "psk";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.790 -0500", hash_original_field = "BCDBF3254C11E65D89A59215C47BC8FE", hash_generated_field = "3C109CD4376827B0B51775920D7B5E49")

    public static final String[] wepKeyVarNames = { "wep_key0", "wep_key1", "wep_key2", "wep_key3" };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.793 -0500", hash_original_field = "18C833A5EDF640F86FC1C5FC7BE1DE5C", hash_generated_field = "497D813681D10F1C98649D37176DB0A6")

    public static final String wepTxKeyIdxVarName = "wep_tx_keyidx";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.795 -0500", hash_original_field = "96973B690AD6C574104FC9068E2C60DE", hash_generated_field = "F48977730924B86CFDE19A6DA78032DE")

    public static final String priorityVarName = "priority";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.797 -0500", hash_original_field = "24ABFE76B5BBED739CF1A6BA19B1C239", hash_generated_field = "83B29577FAED6521D3BD2C10843003AA")

    public static final String hiddenSSIDVarName = "scan_ssid";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.799 -0500", hash_original_field = "1A9C633345422553B12EE38909A1A0CD", hash_generated_field = "E98E26B683887569FD48A42ACA39238A")

    public static final int INVALID_NETWORK_ID = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.943 -0500", hash_original_field = "214247C64B9699C2365366D21228CCBC", hash_generated_field = "878758D4FB34E68AD92F0EDD7633E64F")

    public static final int DISABLED_UNKNOWN_REASON                         = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.945 -0500", hash_original_field = "4C5FC9AE6414B0A6E8B66664A16D22C2", hash_generated_field = "A8D81D6825F23932A154B3789D1BD3A0")

    public static final int DISABLED_DNS_FAILURE                            = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.947 -0500", hash_original_field = "E2414BEB295299DB9B03E291F1D2C97B", hash_generated_field = "9A10C8990B427407B6AD5F3BDDD4298A")

    public static final int DISABLED_DHCP_FAILURE                           = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.950 -0500", hash_original_field = "3532861D50D9BA5AE8A3465D527BC9B1", hash_generated_field = "3F557AE832B42CA826B4874D6700B5A8")

    public static final int DISABLED_AUTH_FAILURE                           = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "29DE5D785DDF3E0B678AB79BFAA5F61D", hash_generated_field = "FB95A826D45756F45E5A04857A49C5C5")

    public static final Creator<WifiConfiguration> CREATOR =
        new Creator<WifiConfiguration>() {
            @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.018 -0500", hash_original_method = "20D1CB558DAB6A81BAFA1424EC8D2FB7", hash_generated_method = "147C6B7DBEC536F5A3EED99B00F66B98")
        
public WifiConfiguration createFromParcel(Parcel in) {
                WifiConfiguration config = new WifiConfiguration();
                config.networkId = in.readInt();
                config.status = in.readInt();
                config.disableReason = in.readInt();
                config.SSID = in.readString();
                config.BSSID = in.readString();
                config.preSharedKey = in.readString();
                for (int i = 0; i < config.wepKeys.length; i++)
                    config.wepKeys[i] = in.readString();
                config.wepTxKeyIndex = in.readInt();
                config.priority = in.readInt();
                config.hiddenSSID = in.readInt() != 0;
                config.allowedKeyManagement   = readBitSet(in);
                config.allowedProtocols       = readBitSet(in);
                config.allowedAuthAlgorithms  = readBitSet(in);
                config.allowedPairwiseCiphers = readBitSet(in);
                config.allowedGroupCiphers    = readBitSet(in);

                for (EnterpriseField field : config.enterpriseFields) {
                    field.setValue(in.readString());
                }

                config.ipAssignment = IpAssignment.valueOf(in.readString());
                config.proxySettings = ProxySettings.valueOf(in.readString());
                config.linkProperties = in.readParcelable(null);
                return config;
            }

            @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.021 -0500", hash_original_method = "9695315CC5B8495CD0481DA1F47B5482", hash_generated_method = "6EE63C519C7451B76B676236FD0D6E53")
        
public WifiConfiguration[] newArray(int size) {
                return new WifiConfiguration[size];
            }
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.818 -0500", hash_original_field = "6E146A896CA0AFA28A738E54F917347B", hash_generated_field = "63CFF92B16B0D9FC501D58CB0D039ADA")

    public EnterpriseField eap = new EnterpriseField("eap");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.820 -0500", hash_original_field = "7D3A7190350DC8DB412E5B13BF04E6FB", hash_generated_field = "C8014B353F4BBCC425B9E3D43030F74B")

    public EnterpriseField phase2 = new EnterpriseField("phase2");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.822 -0500", hash_original_field = "30F2B002050DA3994D005D8C7605BE54", hash_generated_field = "3165AC610B2795CD4688187B42B9DE86")

    public EnterpriseField identity = new EnterpriseField("identity");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.824 -0500", hash_original_field = "040921194A159A66C22E5E0D569A42E9", hash_generated_field = "5BF5368078755DBD6F2A6A5815F96BD3")

    public EnterpriseField anonymous_identity = new EnterpriseField("anonymous_identity");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.826 -0500", hash_original_field = "33D72774D9C63CF832422EA71CE7B6AE", hash_generated_field = "6EB992D8D7E75F1248CC80E5A8576A4A")

    public EnterpriseField password = new EnterpriseField("password");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.828 -0500", hash_original_field = "856C000EAA746220BB8E1B623EF8D047", hash_generated_field = "A3F9CE9CE44333453A41E81608DF8DCA")

    public EnterpriseField client_cert = new EnterpriseField("client_cert");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.830 -0500", hash_original_field = "693587C8298A650CFF4A108E18445C02", hash_generated_field = "D93CB3E43A1B8A764DECCA316EE5FB35")

    public EnterpriseField private_key = new EnterpriseField("private_key");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.832 -0500", hash_original_field = "917B331D6245EDB51AD22A46305AE58E", hash_generated_field = "2BFD15B8B97111332E40870339C68662")

    public EnterpriseField ca_cert = new EnterpriseField("ca_cert");
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.835 -0500", hash_original_field = "1230ECE35643F8BA895736B0450FC401", hash_generated_field = "A3B4CA2C8A2BFD4E4D6BECEE6B877564")

    public EnterpriseField[] enterpriseFields = {
            eap, phase2, identity, anonymous_identity, password, client_cert,
            private_key, ca_cert };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.952 -0500", hash_original_field = "22E61E2EE4D32D3EF8E814A74929B3BC", hash_generated_field = "2478403B68B36CEA1D31569B90E2A4F9")

    public int networkId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.955 -0500", hash_original_field = "72D62D1933050B7AC2D9DFC43782C64E", hash_generated_field = "E9243AA6ACDC688110619DDCF59ACF0B")

    public int status;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.957 -0500", hash_original_field = "2D42BF67806A4E6DA250B066E86B8C40", hash_generated_field = "C37D62585904D7C8691BB50E3D7D57B9")

    public int disableReason;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.959 -0500", hash_original_field = "D51FFCCB8BC400B151A7DB122CC667EF", hash_generated_field = "F7FE1695EF676C936EDB74F734CEDF60")

    public String SSID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.961 -0500", hash_original_field = "570781433B420D8B8DC7F4BA85DC7D9F", hash_generated_field = "2B401C010EEC74A39C75E8EEE69DE741")

    public String BSSID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.963 -0500", hash_original_field = "5C8E975A24359CE49035CB2A49081A9A", hash_generated_field = "FFEEC90F43833727C8445B4C32C23309")

    public String preSharedKey;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.965 -0500", hash_original_field = "220B2B3B759F25B5600DC4EF82457E7B", hash_generated_field = "401685BB959BB2BEE4E974632483E8EF")

    public String[] wepKeys;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.967 -0500", hash_original_field = "36F773D501C22EA4027D9A6ACE67ACA7", hash_generated_field = "B740993C2A06ED1B3E60DBC5B416DD39")

    public int wepTxKeyIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.969 -0500", hash_original_field = "4AD9F2E37B35E313CD211FBAFDADA238", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

    public int priority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.971 -0500", hash_original_field = "30E6A02C5B0A1CB4D580717C475DBB7A", hash_generated_field = "2A955E0592743CCD9ADEF1F8EEFF70E7")

    public boolean hiddenSSID;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.973 -0500", hash_original_field = "062AD4BDB58232031300B63CFBC86221", hash_generated_field = "5020200E94DE8EF17AE8B5090464742A")

    public BitSet allowedKeyManagement;
    
    public class EnterpriseField {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.802 -0500", hash_original_field = "758552C9D5610981921ED28774EB2F82", hash_generated_field = "CE71BBB6A16F0409D8B629E0561562FE")

        private String varName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.804 -0500", hash_original_field = "EE6B270D979EDA88DA18EA680B9EE570", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

        private String value;

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.807 -0500", hash_original_method = "8BFEE65AD67A1E932B47390435D592EC", hash_generated_method = "10A3FEDB6B3170CB7EE531A5F7ECA15F")
        
private EnterpriseField(String varName) {
            this.varName = varName;
            this.value = null;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.809 -0500", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "75AA9597DE892B8BCB023CCA090F290A")
        
public void setValue(String value) {
            this.value = value;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.812 -0500", hash_original_method = "1FBB233886BBDFBC3AF13BD83F42443E", hash_generated_method = "84D385482EA38F572E2D3D102662AD7F")
        
public String varName() {
            return varName;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.814 -0500", hash_original_method = "75F20E3AB28F2448BFFE64E6D18AFDB6", hash_generated_method = "C0CA006B8C428A862330ECDF9AB6589B")
        
public String value() {
            return value;
        }
        
    }
    
    public static class KeyMgmt {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.840 -0500", hash_original_field = "7C4B952C35E23AE77935AAAD9F8920DF", hash_generated_field = "39BEE14A82B6AA5C26F3A7D333C62B69")

        public static final int NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.844 -0500", hash_original_field = "12471B471BC0AC0EE45007CA1E5629CB", hash_generated_field = "5A8DD20C572E90A3C50E05624FC27543")

        public static final int WPA_PSK = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.846 -0500", hash_original_field = "F165A56FFB3572AEF188AD263F60889A", hash_generated_field = "570A01351150B63A3FBA2AB4C5BD4A91")

        public static final int WPA_EAP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.849 -0500", hash_original_field = "C14883BBE659A0474C917605D9323D03", hash_generated_field = "284ED8D8AECCD247EE88553D6A7FE5B9")

        public static final int IEEE8021X = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.851 -0500", hash_original_field = "9DD84068DEF9E754700B5EB52B8C43CD", hash_generated_field = "7EC518044DBCFFDA413DC8AD2E910FE1")

        public static final int WPA2_PSK = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.854 -0500", hash_original_field = "C6D86D25C849C3ACF64EFC591A28CDAC", hash_generated_field = "FB67A25C3E29CB04CC946DD6AF64AC5D")

        public static final String varName = "key_mgmt";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.856 -0500", hash_original_field = "6B75DFFA29DEAFF0A7EF0C673F212608", hash_generated_field = "969ABCB73500B46A06CBD99C05DDB550")

        public static final String[] strings = { "NONE", "WPA_PSK", "WPA_EAP", "IEEE8021X",
                "WPA2_PSK" };
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.838 -0500", hash_original_method = "3C24C7AE0F0A09BE18E455DF08BF91AE", hash_generated_method = "CCA88AA886D376BE91496A4A94AFEFFD")
        
private KeyMgmt() { }
    }
    
    public static class Protocol {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.863 -0500", hash_original_field = "0B9F982AD72AC0F0D4386F5FAF5E4FBD", hash_generated_field = "C4FCC760800C3B8A80D20A1F91464A1D")

        public static final int WPA = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.866 -0500", hash_original_field = "3F833AFA1561731C83F091C2A1A46177", hash_generated_field = "CB765A19544CF62B1EF9E0924312EF87")

        public static final int RSN = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.868 -0500", hash_original_field = "CD691DEEEF9E78D83116C6E5D97756D2", hash_generated_field = "712594087B08829168C0C91650D695A8")

        public static final String varName = "proto";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.870 -0500", hash_original_field = "CFCA90357A9B9BC86CF9ABDA1CF67F3F", hash_generated_field = "DB80E946188BE2FD72D1ACBC2C2FADF4")

        public static final String[] strings = { "WPA", "RSN" };
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.861 -0500", hash_original_method = "FEC0085CF7FD0AE9B8536A4264422A72", hash_generated_method = "A26F7A49CBC7A5B120EBA5A69FA43E7F")
        
private Protocol() { }
    }
    
    public static class AuthAlgorithm {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.878 -0500", hash_original_field = "050305D36072878F0238F8BF54B855BF", hash_generated_field = "74FD01C2F32F716051AE3C3EE63F3028")

        public static final int OPEN = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.880 -0500", hash_original_field = "2A11D195C776DEE8746DB664FF7CC752", hash_generated_field = "4AEB79C0B519CA86E9DD427627C46DE1")

        public static final int SHARED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.883 -0500", hash_original_field = "EC7961AB79E3E06F1D5FF41D5F43703B", hash_generated_field = "2856437D705217468DD05705D3046BCB")

        public static final int LEAP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.885 -0500", hash_original_field = "50CB58294AC79F65154F89D0400ED972", hash_generated_field = "DAAF184B6741B2F8DC099AC0722E9276")

        public static final String varName = "auth_alg";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.888 -0500", hash_original_field = "40A3D21B53864E048C8E8AC5C7E57AC6", hash_generated_field = "C2B57707331863ED3E749A8C13017BF0")

        public static final String[] strings = { "OPEN", "SHARED", "LEAP" };
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.875 -0500", hash_original_method = "02B498F2C9B084569031A4C2852FE733", hash_generated_method = "876D277586CD4C13203D4D414FD1CC7F")
        
private AuthAlgorithm() { }
    }
    
    public static class PairwiseCipher {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.895 -0500", hash_original_field = "7C4B952C35E23AE77935AAAD9F8920DF", hash_generated_field = "39BEE14A82B6AA5C26F3A7D333C62B69")

        public static final int NONE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.898 -0500", hash_original_field = "3B546967D20BE6B0006AFA3124048DBA", hash_generated_field = "CA31D0B1E60715BF3EFAD2478266404B")

        public static final int TKIP = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.900 -0500", hash_original_field = "4233081126F69745747B84F05B74EAD2", hash_generated_field = "2B194FF3D4A4AEEE33B5E446B2B9B7C8")

        public static final int CCMP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.903 -0500", hash_original_field = "081993AF3DECF65A411D84E634EE9BAE", hash_generated_field = "EA61BD8522E2039FE52481DAAEE07F74")

        public static final String varName = "pairwise";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.906 -0500", hash_original_field = "1A05D73B36F520C4DE3E08CC24F24882", hash_generated_field = "A91EB39D642BD98C7B47552D558E16D2")

        public static final String[] strings = { "NONE", "TKIP", "CCMP" };
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.892 -0500", hash_original_method = "D49801CF041AD620DA06D49E02E3EE50", hash_generated_method = "EAB7F0333857C61D17E9F428DB839DFE")
        
private PairwiseCipher() { }
    }
    
    public static class GroupCipher {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.912 -0500", hash_original_field = "7D12547DEB9D5517D1B22CAE7DF4C772", hash_generated_field = "9862762FAE4FFC1E46BE57F66CD7FCC9")

        public static final int WEP40 = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.914 -0500", hash_original_field = "1942854DDB5510C2BB189D1E1A6E90D3", hash_generated_field = "74B64F4A27EC6CEAFE46CAD8B2454AF8")

        public static final int WEP104 = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.917 -0500", hash_original_field = "1C625FE55B30FA9597B075CD40A36C58", hash_generated_field = "5D1C36BE57D611F687158D1A19C131AF")

        public static final int TKIP = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.919 -0500", hash_original_field = "929907449F65E21565DCE54EDE312E26", hash_generated_field = "0E9C98C23820E0B24641603D6B1FF2B1")

        public static final int CCMP = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.922 -0500", hash_original_field = "0ACA6BAD74C7E625A761D299DA1D8885", hash_generated_field = "7B39334B920E5EA14F51FD7555B37897")

        public static final String varName = "group";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.924 -0500", hash_original_field = "24F2B38506E2B750E97AAA65A6BA87BE", hash_generated_field = "76C93678C789D0070307271216BEB38A")

        public static final String[] strings = { "WEP40", "WEP104", "TKIP", "CCMP" };
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.910 -0500", hash_original_method = "A10BFAF56809802940D7EFFA4240EAB0", hash_generated_method = "F2994989ED9382CEE2817849B24F6D1F")
        
private GroupCipher() { }
    }
    
    public static class Status {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.932 -0500", hash_original_field = "C0A841932F5E91F1735F1509EF2F6AB7", hash_generated_field = "9F21697F3CC99987017D14F9FA37CF9B")

        public static final int CURRENT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.935 -0500", hash_original_field = "C281E7DB3E33B169C43625657B5F02B7", hash_generated_field = "41F007FEB047BE15B2BB85BBC8567636")

        public static final int DISABLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.937 -0500", hash_original_field = "22E26BDE5A13E0D96D72D31291BE5D15", hash_generated_field = "0CBCED92CEDA0BE994FF8B2EF0F63EA7")

        public static final int ENABLED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.940 -0500", hash_original_field = "3705B64F2ED8E5526F2261F27FFD37AF", hash_generated_field = "2E406B892260D5B86778765F2C6E9A2C")

        public static final String[] strings = { "current", "disabled", "enabled" };
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.929 -0500", hash_original_method = "FE406DC4CFD00C0AE0BFBAA724FB9F50", hash_generated_method = "89692357FB3E1429AE9E6AB10C62C23A")
        
private Status() { }
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
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.975 -0500", hash_original_field = "4B6ADEF16032211EB8739F6CBD12CD76", hash_generated_field = "9BBBCBD5CE855C45639B537B3B0E333A")

    public BitSet allowedProtocols;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.977 -0500", hash_original_field = "1B62EE1CB19F27C3E9BE7512C83C243C", hash_generated_field = "5A00EF9DFBA579FDF62B43781AE42AB1")

    public BitSet allowedAuthAlgorithms;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.979 -0500", hash_original_field = "8332B8B56D97B26B11E093AA1B2C682B", hash_generated_field = "33993136E5554C8B2A13EE05526BE021")

    public BitSet allowedPairwiseCiphers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.982 -0500", hash_original_field = "52C04E8ACF7F999FE45B078E536F2A85", hash_generated_field = "78C0458676A36458435700BD9317329B")

    public BitSet allowedGroupCiphers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.985 -0500", hash_original_field = "4E9BD50EC280DD19C374FE4A096DCC3F", hash_generated_field = "C1EFC69F0F66BC7E2AE1ACA8AFD736AF")

    public IpAssignment ipAssignment;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.989 -0500", hash_original_field = "2FDA0639350F6E92F47DBD4A5B7C62C6", hash_generated_field = "3732C125EE5045D5223FCD22DE8771B8")

    public ProxySettings proxySettings;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.991 -0500", hash_original_field = "9710D51B67527C9083778B928FD16963", hash_generated_field = "CBFC770A2970049F6731C897B915E6C6")

    public LinkProperties linkProperties;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:03.994 -0500", hash_original_method = "D3E8F62AB6837E859D554E7D52419BA9", hash_generated_method = "EE6B001ACF00E83FA0ABDD66A7DF337B")
    
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
        for (int i = 0; i < wepKeys.length; i++)
            wepKeys[i] = null;
        for (EnterpriseField field : enterpriseFields) {
            field.setValue(null);
        }
        ipAssignment = IpAssignment.UNASSIGNED;
        proxySettings = ProxySettings.UNASSIGNED;
        linkProperties = new LinkProperties();
    }

    /** copy constructor {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.012 -0500", hash_original_method = "C987CC483E64718E2FB8D8B4A4E18BC6", hash_generated_method = "313E9E1B20DBB3F73179418DA7D91D3E")
    
public WifiConfiguration(WifiConfiguration source) {
        if (source != null) {
            networkId = source.networkId;
            status = source.status;
            disableReason = source.disableReason;
            SSID = source.SSID;
            BSSID = source.BSSID;
            preSharedKey = source.preSharedKey;

            wepKeys = new String[4];
            for (int i = 0; i < wepKeys.length; i++)
                wepKeys[i] = source.wepKeys[i];

            wepTxKeyIndex = source.wepTxKeyIndex;
            priority = source.priority;
            hiddenSSID = source.hiddenSSID;
            allowedKeyManagement   = (BitSet) source.allowedKeyManagement.clone();
            allowedProtocols       = (BitSet) source.allowedProtocols.clone();
            allowedAuthAlgorithms  = (BitSet) source.allowedAuthAlgorithms.clone();
            allowedPairwiseCiphers = (BitSet) source.allowedPairwiseCiphers.clone();
            allowedGroupCiphers    = (BitSet) source.allowedGroupCiphers.clone();

            for (int i = 0; i < source.enterpriseFields.length; i++) {
                enterpriseFields[i].setValue(source.enterpriseFields[i].value());
            }
            ipAssignment = source.ipAssignment;
            proxySettings = source.proxySettings;
            linkProperties = new LinkProperties(source.linkProperties);
        }
    }

    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.000 -0500", hash_original_method = "97D3C3FCC664C1BBD8134CCAC12AD4F6", hash_generated_method = "604B03D24FF61983A38980528F3D6549")
    
@Override
    public String toString() {
        StringBuilder sbuf = new StringBuilder();
        if (this.status == WifiConfiguration.Status.CURRENT) {
            sbuf.append("* ");
        } else if (this.status == WifiConfiguration.Status.DISABLED) {
            sbuf.append("- DSBLE: ").append(this.disableReason).append(" ");
        }
        sbuf.append("ID: ").append(this.networkId).append(" SSID: ").append(this.SSID).
                append(" BSSID: ").append(this.BSSID).append(" PRIO: ").append(this.priority).
                append('\n');
        sbuf.append(" KeyMgmt:");
        for (int k = 0; k < this.allowedKeyManagement.size(); k++) {
            if (this.allowedKeyManagement.get(k)) {
                sbuf.append(" ");
                if (k < KeyMgmt.strings.length) {
                    sbuf.append(KeyMgmt.strings[k]);
                } else {
                    sbuf.append("??");
                }
            }
        }
        sbuf.append(" Protocols:");
        for (int p = 0; p < this.allowedProtocols.size(); p++) {
            if (this.allowedProtocols.get(p)) {
                sbuf.append(" ");
                if (p < Protocol.strings.length) {
                    sbuf.append(Protocol.strings[p]);
                } else {
                    sbuf.append("??");
                }
            }
        }
        sbuf.append('\n');
        sbuf.append(" AuthAlgorithms:");
        for (int a = 0; a < this.allowedAuthAlgorithms.size(); a++) {
            if (this.allowedAuthAlgorithms.get(a)) {
                sbuf.append(" ");
                if (a < AuthAlgorithm.strings.length) {
                    sbuf.append(AuthAlgorithm.strings[a]);
                } else {
                    sbuf.append("??");
                }
            }
        }
        sbuf.append('\n');
        sbuf.append(" PairwiseCiphers:");
        for (int pc = 0; pc < this.allowedPairwiseCiphers.size(); pc++) {
            if (this.allowedPairwiseCiphers.get(pc)) {
                sbuf.append(" ");
                if (pc < PairwiseCipher.strings.length) {
                    sbuf.append(PairwiseCipher.strings[pc]);
                } else {
                    sbuf.append("??");
                }
            }
        }
        sbuf.append('\n');
        sbuf.append(" GroupCiphers:");
        for (int gc = 0; gc < this.allowedGroupCiphers.size(); gc++) {
            if (this.allowedGroupCiphers.get(gc)) {
                sbuf.append(" ");
                if (gc < GroupCipher.strings.length) {
                    sbuf.append(GroupCipher.strings[gc]);
                } else {
                    sbuf.append("??");
                }
            }
        }
        sbuf.append('\n').append(" PSK: ");
        if (this.preSharedKey != null) {
            sbuf.append('*');
        }

        for (EnterpriseField field : enterpriseFields) {
            sbuf.append('\n').append(" " + field.varName() + ": ");
            String value = field.value();
            if (value != null) sbuf.append(value);
        }
        sbuf.append('\n');
        sbuf.append("IP assignment: " + ipAssignment.toString());
        sbuf.append("\n");
        sbuf.append("Proxy settings: " + proxySettings.toString());
        sbuf.append("\n");
        sbuf.append(linkProperties.toString());
        sbuf.append("\n");

        return sbuf.toString();
    }

    /** @hide */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.007 -0500", hash_original_method = "9AFA2ED3E118B7190C0E7E9D5FFF2220", hash_generated_method = "76ECF00D1675A34E05C62D6DA70DC7E5")
    
public int getAuthType() {
        if (allowedKeyManagement.get(KeyMgmt.WPA_PSK)) {
            return KeyMgmt.WPA_PSK;
        } else if (allowedKeyManagement.get(KeyMgmt.WPA2_PSK)) {
            return KeyMgmt.WPA2_PSK;
        } else if (allowedKeyManagement.get(KeyMgmt.WPA_EAP)) {
            return KeyMgmt.WPA_EAP;
        } else if (allowedKeyManagement.get(KeyMgmt.IEEE8021X)) {
            return KeyMgmt.IEEE8021X;
        }
        return KeyMgmt.NONE;
    }

    /** Implement the Parcelable interface {@hide} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.009 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** Implement the Parcelable interface {@hide} */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:04.015 -0500", hash_original_method = "AEDB33EEF5EAFBB380DF78B8CF162994", hash_generated_method = "D5271A13E52789404A1AE58845C0857A")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(networkId);
        dest.writeInt(status);
        dest.writeInt(disableReason);
        dest.writeString(SSID);
        dest.writeString(BSSID);
        dest.writeString(preSharedKey);
        for (String wepKey : wepKeys)
            dest.writeString(wepKey);
        dest.writeInt(wepTxKeyIndex);
        dest.writeInt(priority);
        dest.writeInt(hiddenSSID ? 1 : 0);

        writeBitSet(dest, allowedKeyManagement);
        writeBitSet(dest, allowedProtocols);
        writeBitSet(dest, allowedAuthAlgorithms);
        writeBitSet(dest, allowedPairwiseCiphers);
        writeBitSet(dest, allowedGroupCiphers);

        for (EnterpriseField field : enterpriseFields) {
            dest.writeString(field.value());
        }
        dest.writeString(ipAssignment.name());
        dest.writeString(proxySettings.name());
        dest.writeParcelable(linkProperties, flags);
    }
}

