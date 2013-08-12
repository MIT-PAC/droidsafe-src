package android.net.wifi;

// Droidsafe Imports
import droidsafe.annotations.*;
import java.util.BitSet;

import android.net.LinkProperties;
import android.os.Parcel;
import android.os.Parcelable;





public class WifiConfiguration implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "19C847337F720E130F334CF33214EB73", hash_generated_field = "63CFF92B16B0D9FC501D58CB0D039ADA")

    public EnterpriseField eap = new EnterpriseField("eap");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "C8010D9E4D9ADFFC3A67FCAEEE4B2F7F", hash_generated_field = "C8014B353F4BBCC425B9E3D43030F74B")

    public EnterpriseField phase2 = new EnterpriseField("phase2");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "F3C5B19468ABD47D3A5AB9C37FACCAD8", hash_generated_field = "3165AC610B2795CD4688187B42B9DE86")

    public EnterpriseField identity = new EnterpriseField("identity");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "FA8B96A60D9F35E68590BC86596A83B8", hash_generated_field = "5BF5368078755DBD6F2A6A5815F96BD3")

    public EnterpriseField anonymous_identity = new EnterpriseField("anonymous_identity");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "F25C1F1784F1C7D143A8F5257880F5FA", hash_generated_field = "6EB992D8D7E75F1248CC80E5A8576A4A")

    public EnterpriseField password = new EnterpriseField("password");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "30FFABAAD0535A8F04E9CF1BB74C9722", hash_generated_field = "A3F9CE9CE44333453A41E81608DF8DCA")

    public EnterpriseField client_cert = new EnterpriseField("client_cert");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "B7B8EE851736A1B5E67AA806A08EB4A2", hash_generated_field = "D93CB3E43A1B8A764DECCA316EE5FB35")

    public EnterpriseField private_key = new EnterpriseField("private_key");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "37DC42AB29A535168F29D3C613DCA8A7", hash_generated_field = "2BFD15B8B97111332E40870339C68662")

    public EnterpriseField ca_cert = new EnterpriseField("ca_cert");
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "8B615E7488C8A582FB96C419A2A89A17", hash_generated_field = "A3B4CA2C8A2BFD4E4D6BECEE6B877564")

    public EnterpriseField[] enterpriseFields = {
            eap, phase2, identity, anonymous_identity, password, client_cert,
            private_key, ca_cert };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "42C64341469D29885852FCC8A451F115", hash_generated_field = "2478403B68B36CEA1D31569B90E2A4F9")

    public int networkId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "9ACB44549B41563697BB490144EC6258", hash_generated_field = "E9243AA6ACDC688110619DDCF59ACF0B")

    public int status;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "BDE15B21096A097FC7112E7FCC3B2895", hash_generated_field = "C37D62585904D7C8691BB50E3D7D57B9")

    public int disableReason;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "0D09D7B23E604623465E83B0DC113F4D", hash_generated_field = "F7FE1695EF676C936EDB74F734CEDF60")

    public String SSID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "4EB26185F9AD8B5D6AFBADC09D7D5096", hash_generated_field = "2B401C010EEC74A39C75E8EEE69DE741")

    public String BSSID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "4C43F64E4374CE164633CE9748050DEB", hash_generated_field = "FFEEC90F43833727C8445B4C32C23309")

    public String preSharedKey;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "E25447F5590A6E9158237FBCE2C208D9", hash_generated_field = "401685BB959BB2BEE4E974632483E8EF")

    public String[] wepKeys;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.174 -0400", hash_original_field = "893A2B6D379EA1E819ED69113396CEA1", hash_generated_field = "B740993C2A06ED1B3E60DBC5B416DD39")

    public int wepTxKeyIndex;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

    public int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "69F45D42D6DE8064993EA84DD551C6B6", hash_generated_field = "2A955E0592743CCD9ADEF1F8EEFF70E7")

    public boolean hiddenSSID;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "6FEF103E0BC715186BF14B042ACE4B1B", hash_generated_field = "5020200E94DE8EF17AE8B5090464742A")

    public BitSet allowedKeyManagement;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "7884CF9BEB2F6B72D0AAB9B8FDDC4C89", hash_generated_field = "9BBBCBD5CE855C45639B537B3B0E333A")

    public BitSet allowedProtocols;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "E8918D762F91A828A60B435E5A8D401F", hash_generated_field = "5A00EF9DFBA579FDF62B43781AE42AB1")

    public BitSet allowedAuthAlgorithms;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "5D81A7104AE51B68F512BF74084D524D", hash_generated_field = "33993136E5554C8B2A13EE05526BE021")

    public BitSet allowedPairwiseCiphers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "2F9B151DF0DD7E7C43BB0784C052829E", hash_generated_field = "78C0458676A36458435700BD9317329B")

    public BitSet allowedGroupCiphers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "838CC520104C69FBA98A39DB9EFE43F1", hash_generated_field = "C1EFC69F0F66BC7E2AE1ACA8AFD736AF")

    public IpAssignment ipAssignment;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "A5084A3D50776BBFDB0FC2D1F3EB8365", hash_generated_field = "3732C125EE5045D5223FCD22DE8771B8")

    public ProxySettings proxySettings;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_field = "DC6DF7A05A86671C3549B5A63A5A6670", hash_generated_field = "CBFC770A2970049F6731C897B915E6C6")

    public LinkProperties linkProperties;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.175 -0400", hash_original_method = "D3E8F62AB6837E859D554E7D52419BA9", hash_generated_method = "7A9E376FEFD631718632AF53786A34B4")
    public  WifiConfiguration() {
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
for(int i = 0;i < wepKeys.length;i++)
        wepKeys[i] = null;
for(EnterpriseField field : enterpriseFields)
        {
            field.setValue(null);
        } //End block
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

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.176 -0400", hash_original_method = "C987CC483E64718E2FB8D8B4A4E18BC6", hash_generated_method = "35F0D3CADD3BDE7D2FC3F459602EC24C")
    public  WifiConfiguration(WifiConfiguration source) {
        if(source != null)        
        {
            networkId = source.networkId;
            status = source.status;
            disableReason = source.disableReason;
            SSID = source.SSID;
            BSSID = source.BSSID;
            preSharedKey = source.preSharedKey;
            wepKeys = new String[4];
for(int i = 0;i < wepKeys.length;i++)
            wepKeys[i] = source.wepKeys[i];
            wepTxKeyIndex = source.wepTxKeyIndex;
            priority = source.priority;
            hiddenSSID = source.hiddenSSID;
            allowedKeyManagement   = (BitSet) source.allowedKeyManagement.clone();
            allowedProtocols       = (BitSet) source.allowedProtocols.clone();
            allowedAuthAlgorithms  = (BitSet) source.allowedAuthAlgorithms.clone();
            allowedPairwiseCiphers = (BitSet) source.allowedPairwiseCiphers.clone();
            allowedGroupCiphers    = (BitSet) source.allowedGroupCiphers.clone();
for(int i = 0;i < source.enterpriseFields.length;i++)
            {
                enterpriseFields[i].setValue(source.enterpriseFields[i].value());
            } //End block
            ipAssignment = source.ipAssignment;
            proxySettings = source.proxySettings;
            linkProperties = new LinkProperties(source.linkProperties);
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.177 -0400", hash_original_method = "97D3C3FCC664C1BBD8134CCAC12AD4F6", hash_generated_method = "E43D95F7000BA5B60E9B40AE493CE6DC")
    @Override
    public String toString() {
        StringBuilder sbuf = new StringBuilder();
        if(this.status == WifiConfiguration.Status.CURRENT)        
        {
            sbuf.append("* ");
        } //End block
        else
        if(this.status == WifiConfiguration.Status.DISABLED)        
        {
            sbuf.append("- DSBLE: ").append(this.disableReason).append(" ");
        } //End block
        sbuf.append("ID: ").append(this.networkId).append(" SSID: ").append(this.SSID).
                append(" BSSID: ").append(this.BSSID).append(" PRIO: ").append(this.priority).
                append('\n');
        sbuf.append(" KeyMgmt:");
for(int k = 0;k < this.allowedKeyManagement.size();k++)
        {
            if(this.allowedKeyManagement.get(k))            
            {
                sbuf.append(" ");
                if(k < KeyMgmt.strings.length)                
                {
                    sbuf.append(KeyMgmt.strings[k]);
                } //End block
                else
                {
                    sbuf.append("??");
                } //End block
            } //End block
        } //End block
        sbuf.append(" Protocols:");
for(int p = 0;p < this.allowedProtocols.size();p++)
        {
            if(this.allowedProtocols.get(p))            
            {
                sbuf.append(" ");
                if(p < Protocol.strings.length)                
                {
                    sbuf.append(Protocol.strings[p]);
                } //End block
                else
                {
                    sbuf.append("??");
                } //End block
            } //End block
        } //End block
        sbuf.append('\n');
        sbuf.append(" AuthAlgorithms:");
for(int a = 0;a < this.allowedAuthAlgorithms.size();a++)
        {
            if(this.allowedAuthAlgorithms.get(a))            
            {
                sbuf.append(" ");
                if(a < AuthAlgorithm.strings.length)                
                {
                    sbuf.append(AuthAlgorithm.strings[a]);
                } //End block
                else
                {
                    sbuf.append("??");
                } //End block
            } //End block
        } //End block
        sbuf.append('\n');
        sbuf.append(" PairwiseCiphers:");
for(int pc = 0;pc < this.allowedPairwiseCiphers.size();pc++)
        {
            if(this.allowedPairwiseCiphers.get(pc))            
            {
                sbuf.append(" ");
                if(pc < PairwiseCipher.strings.length)                
                {
                    sbuf.append(PairwiseCipher.strings[pc]);
                } //End block
                else
                {
                    sbuf.append("??");
                } //End block
            } //End block
        } //End block
        sbuf.append('\n');
        sbuf.append(" GroupCiphers:");
for(int gc = 0;gc < this.allowedGroupCiphers.size();gc++)
        {
            if(this.allowedGroupCiphers.get(gc))            
            {
                sbuf.append(" ");
                if(gc < GroupCipher.strings.length)                
                {
                    sbuf.append(GroupCipher.strings[gc]);
                } //End block
                else
                {
                    sbuf.append("??");
                } //End block
            } //End block
        } //End block
        sbuf.append('\n').append(" PSK: ");
        if(this.preSharedKey != null)        
        {
            sbuf.append('*');
        } //End block
for(EnterpriseField field : enterpriseFields)
        {
            sbuf.append('\n').append(" " + field.varName() + ": ");
            String value = field.value();
            if(value != null)            
            sbuf.append(value);
        } //End block
        sbuf.append('\n');
        sbuf.append("IP assignment: " + ipAssignment.toString());
        sbuf.append("\n");
        sbuf.append("Proxy settings: " + proxySettings.toString());
        sbuf.append("\n");
        sbuf.append(linkProperties.toString());
        sbuf.append("\n");
String var69222FFA45D1268AEE1923C5558B0BD5_1592928268 =         sbuf.toString();
        var69222FFA45D1268AEE1923C5558B0BD5_1592928268.addTaint(taint);
        return var69222FFA45D1268AEE1923C5558B0BD5_1592928268;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.BAN)
    private static BitSet readBitSet(Parcel src) {
        int cardinality = src.readInt();
        BitSet set = new BitSet();
        for (int i = 0; i < cardinality; i++)
            set.set(src.readInt());
        return set;
    }

    
    @DSModeled(DSC.BAN)
    private static void writeBitSet(Parcel dest, BitSet set) {
        int nextSetBit = -1;
        dest.writeInt(set.cardinality());
        while ((nextSetBit = set.nextSetBit(nextSetBit + 1)) != -1)
            dest.writeInt(nextSetBit);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.178 -0400", hash_original_method = "9AFA2ED3E118B7190C0E7E9D5FFF2220", hash_generated_method = "4EB5D35CEFA9E45A2289847D4C068DAB")
    public int getAuthType() {
        if(allowedKeyManagement.get(KeyMgmt.WPA_PSK))        
        {
            int var0FCBC2BC4EA0A7BD12D738E0CD302719_829651312 = (KeyMgmt.WPA_PSK);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347216777 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_347216777;
        } //End block
        else
        if(allowedKeyManagement.get(KeyMgmt.WPA2_PSK))        
        {
            int varF9CBF8139662CAD7B4EB206418DE77D1_1489927027 = (KeyMgmt.WPA2_PSK);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335777562 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_335777562;
        } //End block
        else
        if(allowedKeyManagement.get(KeyMgmt.WPA_EAP))        
        {
            int var2D34AB68C108758198684ED0F780659F_1116104828 = (KeyMgmt.WPA_EAP);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481367306 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1481367306;
        } //End block
        else
        if(allowedKeyManagement.get(KeyMgmt.IEEE8021X))        
        {
            int varC375F7ABD12E1AF90B3CCCB84AD13499_1608549802 = (KeyMgmt.IEEE8021X);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364072518 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1364072518;
        } //End block
        int varF1820F3956FE24C963DD1B07397D572A_1544041893 = (KeyMgmt.NONE);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004867661 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2004867661;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.178 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0EE93D929D5E0B883E9A1AD14F406EBB")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_863167922 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259562568 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1259562568;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.178 -0400", hash_original_method = "AEDB33EEF5EAFBB380DF78B8CF162994", hash_generated_method = "BC5C67E037B797080F929BA02D404A03")
    public void writeToParcel(Parcel dest, int flags) {
        addTaint(flags);
        addTaint(dest.getTaint());
        dest.writeInt(networkId);
        dest.writeInt(status);
        dest.writeInt(disableReason);
        dest.writeString(SSID);
        dest.writeString(BSSID);
        dest.writeString(preSharedKey);
for(String wepKey : wepKeys)
        dest.writeString(wepKey);
        dest.writeInt(wepTxKeyIndex);
        dest.writeInt(priority);
        dest.writeInt(hiddenSSID ? 1 : 0);
        writeBitSet(dest, allowedKeyManagement);
        writeBitSet(dest, allowedProtocols);
        writeBitSet(dest, allowedAuthAlgorithms);
        writeBitSet(dest, allowedPairwiseCiphers);
        writeBitSet(dest, allowedGroupCiphers);
for(EnterpriseField field : enterpriseFields)
        {
            dest.writeString(field.value());
        } //End block
        dest.writeString(ipAssignment.name());
        dest.writeString(proxySettings.name());
        dest.writeParcelable(linkProperties, flags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public class EnterpriseField {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.178 -0400", hash_original_field = "51746FC9CFAAF892E94C2D56D7508B37", hash_generated_field = "CE71BBB6A16F0409D8B629E0561562FE")

        private String varName;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.178 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "424F4435B9052E77589D30873B9A7D2B")

        private String value;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.178 -0400", hash_original_method = "8BFEE65AD67A1E932B47390435D592EC", hash_generated_method = "0D3459E13A7E98E4294DC1B096D96E42")
        private  EnterpriseField(String varName) {
            this.varName = varName;
            this.value = null;
            // ---------- Original Method ----------
            //this.varName = varName;
            //this.value = null;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.179 -0400", hash_original_method = "54A096BDAB783365763903A518BE6C1A", hash_generated_method = "811C079A212601355D5034023F0D4C0B")
        public void setValue(String value) {
            this.value = value;
            // ---------- Original Method ----------
            //this.value = value;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.183 -0400", hash_original_method = "1FBB233886BBDFBC3AF13BD83F42443E", hash_generated_method = "45E151FCA0129B5E6EAD88B1E7281FD5")
        public String varName() {
String var01CEF6CAB564B83EC5A19C54824001C0_542730923 =             varName;
            var01CEF6CAB564B83EC5A19C54824001C0_542730923.addTaint(taint);
            return var01CEF6CAB564B83EC5A19C54824001C0_542730923;
            // ---------- Original Method ----------
            //return varName;
        }

        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_method = "75F20E3AB28F2448BFFE64E6D18AFDB6", hash_generated_method = "E4BBEE2A287867872A26C8850B8E5D52")
        public String value() {
String varAF280DA2BC37D8BE783D8499160168DE_800297803 =             value;
            varAF280DA2BC37D8BE783D8499160168DE_800297803.addTaint(taint);
            return varAF280DA2BC37D8BE783D8499160168DE_800297803;
            // ---------- Original Method ----------
            //return value;
        }

        
    }


    
    public static class KeyMgmt {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_method = "3C24C7AE0F0A09BE18E455DF08BF91AE", hash_generated_method = "84233618D069A8DDF728C3B1AD79C9CD")
        private  KeyMgmt() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "4F2536D0D627A82B4C8A0BFFFEFBF7DA", hash_generated_field = "39BEE14A82B6AA5C26F3A7D333C62B69")

        public static final int NONE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "8952D45B0535DDA01FFA580EFB68B26A", hash_generated_field = "5A8DD20C572E90A3C50E05624FC27543")

        public static final int WPA_PSK = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "769B8210DD96CF81BF2AA7E35D3D448A", hash_generated_field = "570A01351150B63A3FBA2AB4C5BD4A91")

        public static final int WPA_EAP = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "A8468CF5A141630F5211076F831E402E", hash_generated_field = "284ED8D8AECCD247EE88553D6A7FE5B9")

        public static final int IEEE8021X = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "D3F29ECE465B44409F9B2505BCD27977", hash_generated_field = "7EC518044DBCFFDA413DC8AD2E910FE1")

        public static final int WPA2_PSK = 4;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "839F8BB18D7FDCB1A05BD3F4B06D9EEC", hash_generated_field = "FB67A25C3E29CB04CC946DD6AF64AC5D")

        public static final String varName = "key_mgmt";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "C0C0E65BED07A1955FDEB56277817D99", hash_generated_field = "969ABCB73500B46A06CBD99C05DDB550")

        public static final String[] strings = { "NONE", "WPA_PSK", "WPA_EAP", "IEEE8021X",
                "WPA2_PSK" };
    }


    
    public static class Protocol {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_method = "FEC0085CF7FD0AE9B8536A4264422A72", hash_generated_method = "BDFBDD91E12BC6AB0AC098F24E528B8C")
        private  Protocol() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "BF24DB40484AAF755F0DDAB26F69C320", hash_generated_field = "C4FCC760800C3B8A80D20A1F91464A1D")

        public static final int WPA = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "4EF44F02766859B24401F7049CC2E075", hash_generated_field = "CB765A19544CF62B1EF9E0924312EF87")

        public static final int RSN = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.184 -0400", hash_original_field = "977F89C7BFD09789A9D47167D3E85C66", hash_generated_field = "712594087B08829168C0C91650D695A8")

        public static final String varName = "proto";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "E116FB5B99CF9EF075A04A2CF8803EBD", hash_generated_field = "DB80E946188BE2FD72D1ACBC2C2FADF4")

        public static final String[] strings = { "WPA", "RSN" };
    }


    
    public static class AuthAlgorithm {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_method = "02B498F2C9B084569031A4C2852FE733", hash_generated_method = "0DC3E2E4C06E7A517A353243CDD6C6F7")
        private  AuthAlgorithm() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "43717087C14CDCDCFDB18BD5D73ABF14", hash_generated_field = "74FD01C2F32F716051AE3C3EE63F3028")

        public static final int OPEN = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "AFED42F86FAB6133191C5B118A0DFC73", hash_generated_field = "4AEB79C0B519CA86E9DD427627C46DE1")

        public static final int SHARED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "F66442A64ED932EE1DD751D6421077A5", hash_generated_field = "2856437D705217468DD05705D3046BCB")

        public static final int LEAP = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "8CFDF7D5CAF925AE8C5140C75377B8B7", hash_generated_field = "DAAF184B6741B2F8DC099AC0722E9276")

        public static final String varName = "auth_alg";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "B1BDC49C4770A26E79F817DDA1094DB1", hash_generated_field = "C2B57707331863ED3E749A8C13017BF0")

        public static final String[] strings = { "OPEN", "SHARED", "LEAP" };
    }


    
    public static class PairwiseCipher {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_method = "D49801CF041AD620DA06D49E02E3EE50", hash_generated_method = "80B019872D8101A5104B248737E04786")
        private  PairwiseCipher() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "4F2536D0D627A82B4C8A0BFFFEFBF7DA", hash_generated_field = "39BEE14A82B6AA5C26F3A7D333C62B69")

        public static final int NONE = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "D910CF5C728EA26A8CE91EEBE7D04EFB", hash_generated_field = "CA31D0B1E60715BF3EFAD2478266404B")

        public static final int TKIP = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "DF01CA2BF700B036C9C3C76213BCAF4C", hash_generated_field = "2B194FF3D4A4AEEE33B5E446B2B9B7C8")

        public static final int CCMP = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.185 -0400", hash_original_field = "8FDB0DE7C9A49D5983BB8EC9D50DF694", hash_generated_field = "EA61BD8522E2039FE52481DAAEE07F74")

        public static final String varName = "pairwise";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.186 -0400", hash_original_field = "79809102924AD86AF3D84B0257A08F42", hash_generated_field = "A91EB39D642BD98C7B47552D558E16D2")

        public static final String[] strings = { "NONE", "TKIP", "CCMP" };
    }


    
    public static class GroupCipher {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.186 -0400", hash_original_method = "A10BFAF56809802940D7EFFA4240EAB0", hash_generated_method = "65BD6B7E2641A28A143BE5DB0E9B6215")
        private  GroupCipher() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.186 -0400", hash_original_field = "6E4C415B83574A64D27809AE91928DF5", hash_generated_field = "9862762FAE4FFC1E46BE57F66CD7FCC9")

        public static final int WEP40 = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.186 -0400", hash_original_field = "4CBE97F81EF75C2AC1F2080181F20797", hash_generated_field = "74B64F4A27EC6CEAFE46CAD8B2454AF8")

        public static final int WEP104 = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.186 -0400", hash_original_field = "D61A09A2330E41B0E50AB754612325E6", hash_generated_field = "5D1C36BE57D611F687158D1A19C131AF")

        public static final int TKIP = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.186 -0400", hash_original_field = "4635DEC9CBFD53EA490023964CC1E2FC", hash_generated_field = "0E9C98C23820E0B24641603D6B1FF2B1")

        public static final int CCMP = 3;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.186 -0400", hash_original_field = "8B543F279450D329B2E46990C625D552", hash_generated_field = "7B39334B920E5EA14F51FD7555B37897")

        public static final String varName = "group";
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.187 -0400", hash_original_field = "0C10C2EFDF236F058CDA908F5DFE4043", hash_generated_field = "76C93678C789D0070307271216BEB38A")

        public static final String[] strings = { "WEP40", "WEP104", "TKIP", "CCMP" };
    }


    
    public static class Status {
        
        @DSModeled(DSC.BAN)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.187 -0400", hash_original_method = "FE406DC4CFD00C0AE0BFBAA724FB9F50", hash_generated_method = "7E294D2CADE3312347600003F64067B6")
        private  Status() {
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.187 -0400", hash_original_field = "C8BE5C7839F1E6E916EDE2AA991E270D", hash_generated_field = "9F21697F3CC99987017D14F9FA37CF9B")

        public static final int CURRENT = 0;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.187 -0400", hash_original_field = "DFECBA4FD1C9828EA2E22F2E74B8E75D", hash_generated_field = "41F007FEB047BE15B2BB85BBC8567636")

        public static final int DISABLED = 1;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.187 -0400", hash_original_field = "DFC3EC1112539EE1CD52399A8C1D49EB", hash_generated_field = "0CBCED92CEDA0BE994FF8B2EF0F63EA7")

        public static final int ENABLED = 2;
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.187 -0400", hash_original_field = "F8F6310E9A6F20491DB28D6A61BC4F65", hash_generated_field = "2E406B892260D5B86778765F2C6E9A2C")

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

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.187 -0400", hash_original_field = "0868A890D501D57BDEEDB46AC847BCDE", hash_generated_field = "E8CDBB9FFFFA56D2FC6AC1E012086750")

    public static final String ssidVarName = "ssid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "698E241BAF22C814131094BC4D0D727B", hash_generated_field = "615F5954486556CB6899ABD6591FA7EC")

    public static final String bssidVarName = "bssid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "0CD13764F576344B5B08A5FE65D6832C", hash_generated_field = "1B32B7500DA776F594AF591AD38ADF09")

    public static final String pskVarName = "psk";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "42D550C4F68F6A702C5C55B6FC2F7C6D", hash_generated_field = "3C109CD4376827B0B51775920D7B5E49")

    public static final String[] wepKeyVarNames = { "wep_key0", "wep_key1", "wep_key2", "wep_key3" };
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "11C3988529344A97B47196877C7FF458", hash_generated_field = "497D813681D10F1C98649D37176DB0A6")

    public static final String wepTxKeyIdxVarName = "wep_tx_keyidx";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "E1C34D83AA8BE8803B67D7261E086F07", hash_generated_field = "F48977730924B86CFDE19A6DA78032DE")

    public static final String priorityVarName = "priority";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "9A739208944AB16D065EB91E972DB69A", hash_generated_field = "83B29577FAED6521D3BD2C10843003AA")

    public static final String hiddenSSIDVarName = "scan_ssid";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "7F6BA1F0D2CFADFF4D3B81B9A4174A73", hash_generated_field = "E98E26B683887569FD48A42ACA39238A")

    public static final int INVALID_NETWORK_ID = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "EF6FB852E9F85D8BA99809A64C9B77E9", hash_generated_field = "878758D4FB34E68AD92F0EDD7633E64F")

    public static final int DISABLED_UNKNOWN_REASON                         = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "EF90AFB99847D87174EB20844817E983", hash_generated_field = "A8D81D6825F23932A154B3789D1BD3A0")

    public static final int DISABLED_DNS_FAILURE                            = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "ED9AB33C9F6E7AAC5332F2FDDA0E6B8C", hash_generated_field = "9A10C8990B427407B6AD5F3BDDD4298A")

    public static final int DISABLED_DHCP_FAILURE                           = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "552A6ABDD4D3835C377D30BC130B837E", hash_generated_field = "3F557AE832B42CA826B4874D6700B5A8")

    public static final int DISABLED_AUTH_FAILURE                           = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:22.188 -0400", hash_original_field = "29DE5D785DDF3E0B678AB79BFAA5F61D", hash_generated_field = "FB95A826D45756F45E5A04857A49C5C5")

    public static final Creator<WifiConfiguration> CREATOR =
        new Creator<WifiConfiguration>() {
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

            @DSModeled(DSC.SAFE)
        public WifiConfiguration[] newArray(int size) {
                return new WifiConfiguration[size];
            }
        };
}

