package com.android.internal.net;

// Droidsafe Imports
import java.util.List;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class VpnConfig implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.425 -0400", hash_original_field = "EE11CBB19052E40B07AAC0CA060C23EE", hash_generated_field = "0D37FB1187DC93A5CBFAB3C14B0F27FB")

    public String user;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.425 -0400", hash_original_field = "48A07652E18803812B862D8593A2A547", hash_generated_field = "9342EB91AB7C5199220A234450DF96C8")

    public String interfaze;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.425 -0400", hash_original_field = "21D6F40CFB511982E4424E0E250A9557", hash_generated_field = "CAC90C98A578DDDD3D4C2D891257A143")

    public String session;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.425 -0400", hash_original_field = "A8FC9C24BC80EA6E5B0667BA3B3B107B", hash_generated_field = "F5529878A82328FB28CC05D08BF17241")

    public int mtu = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.425 -0400", hash_original_field = "963E3A2FE559E393BAD631F3DC686F69", hash_generated_field = "687ABFAA2D8194E3A4C3CAA6DA305AD5")

    public String addresses;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.425 -0400", hash_original_field = "1755347E5F6A762B84A3F6512A3E4E53", hash_generated_field = "20DD824A8F7D017DD1D37F39CED9A870")

    public String routes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.425 -0400", hash_original_field = "77B27F8A9ED53435D1E9BD36235537AC", hash_generated_field = "C54FD7F60068D455D80ED4DC17F489C0")

    public List<String> dnsServers;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.425 -0400", hash_original_field = "7311288AE1D218C45A0BE9F318E7E20B", hash_generated_field = "460A23BC5A4BAC5B37719D50B369576E")

    public List<String> searchDomains;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.426 -0400", hash_original_field = "C98CAC1B8A8276FEB9B3F13342ECD6CF", hash_generated_field = "DEA3E94F682B79FB8D965191517A969E")

    public PendingIntent configureIntent;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.426 -0400", hash_original_field = "EDFA59C6B19494F54AAC669CFB6B758B", hash_generated_field = "DC78085E8C08FEBE821C9BA3907E0CCD")

    public long startTime = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.426 -0400", hash_original_method = "0CC41B74437C55587D7B09044ACFFB33", hash_generated_method = "0CC41B74437C55587D7B09044ACFFB33")
    public VpnConfig ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.BAN)
    public static Intent getIntentForConfirmation() {
        Intent intent = new Intent();
        intent.setClassName("com.android.vpndialogs", "com.android.vpndialogs.ConfirmDialog");
        return intent;
    }

    
    @DSModeled(DSC.BAN)
    public static PendingIntent getIntentForStatusPanel(Context context, VpnConfig config) {
        Intent intent = new Intent();
        intent.setClassName("com.android.vpndialogs", "com.android.vpndialogs.ManageDialog");
        intent.putExtra("config", config);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        return PendingIntent.getActivity(context, 0, intent, (config == null) ?
                PendingIntent.FLAG_NO_CREATE : PendingIntent.FLAG_CANCEL_CURRENT);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.427 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "A3B514FC58CE6A3B345E87C7F95566DE")
    @Override
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_416587120 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944814968 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_944814968;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.428 -0400", hash_original_method = "663713F2190B3FEEC06E42079AE10798", hash_generated_method = "9231720D234239626438B4BEF4BE7181")
    @Override
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeString(user);
        out.writeString(interfaze);
        out.writeString(session);
        out.writeInt(mtu);
        out.writeString(addresses);
        out.writeString(routes);
        out.writeStringList(dnsServers);
        out.writeStringList(searchDomains);
        out.writeParcelable(configureIntent, flags);
        out.writeLong(startTime);
        // ---------- Original Method ----------
        //out.writeString(user);
        //out.writeString(interfaze);
        //out.writeString(session);
        //out.writeInt(mtu);
        //out.writeString(addresses);
        //out.writeString(routes);
        //out.writeStringList(dnsServers);
        //out.writeStringList(searchDomains);
        //out.writeParcelable(configureIntent, flags);
        //out.writeLong(startTime);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.428 -0400", hash_original_field = "64E413D1F95D8D7AAA768FE42D3371A2", hash_generated_field = "3DE559FCCAED1098982ED547FF9663BB")

    public static final String SERVICE_INTERFACE = "android.net.VpnService";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.428 -0400", hash_original_field = "A50D6DCA42A92AEC233DAA6770AA77D7", hash_generated_field = "A23A74C292C8FC0BB1625437C9BF1187")

    public static final String LEGACY_VPN = "[Legacy VPN]";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.428 -0400", hash_original_field = "B9E25A0AC362BE835CC8488AB95C56B0", hash_generated_field = "83D1742B520DA7FD872FDBB1828AD74A")

    public static final Parcelable.Creator<VpnConfig> CREATOR =
            new Parcelable.Creator<VpnConfig>() {
        @Override
        public VpnConfig createFromParcel(Parcel in) {
            VpnConfig config = new VpnConfig();
            config.user = in.readString();
            config.interfaze = in.readString();
            config.session = in.readString();
            config.mtu = in.readInt();
            config.addresses = in.readString();
            config.routes = in.readString();
            config.dnsServers = in.createStringArrayList();
            config.searchDomains = in.createStringArrayList();
            config.configureIntent = in.readParcelable(null);
            config.startTime = in.readLong();
            return config;
        }

        @Override
        public VpnConfig[] newArray(int size) {
            return new VpnConfig[size];
        }
    };
}

