package com.android.internal.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.List;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

public class VpnConfig implements Parcelable {

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.684 -0500", hash_original_method = "E2B4F190A55D7785794B0646C1BF8F7C", hash_generated_method = "26557B87479877086733CABEA875BFAE")
    
public static Intent getIntentForConfirmation() {
        Intent intent = new Intent();
        intent.setClassName("com.android.vpndialogs", "com.android.vpndialogs.ConfirmDialog");
        return intent;
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.686 -0500", hash_original_method = "A6FDE7EDEB3EAB44B9B5F7A984EB3D92", hash_generated_method = "2B739E0228AA7A1F25D9878623F65BC9")
    
public static PendingIntent getIntentForStatusPanel(Context context, VpnConfig config) {
        Intent intent = new Intent();
        intent.setClassName("com.android.vpndialogs", "com.android.vpndialogs.ManageDialog");
        intent.putExtra("config", config);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        return PendingIntent.getActivity(context, 0, intent, (config == null) ?
                PendingIntent.FLAG_NO_CREATE : PendingIntent.FLAG_CANCEL_CURRENT);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.679 -0500", hash_original_field = "B1AFFBC88325DD4A5AEF1E3345A659BB", hash_generated_field = "3DE559FCCAED1098982ED547FF9663BB")

    public static final String SERVICE_INTERFACE = "android.net.VpnService";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.682 -0500", hash_original_field = "7972CCA224CB5964D80307847E8E0B9F", hash_generated_field = "A23A74C292C8FC0BB1625437C9BF1187")

    public static final String LEGACY_VPN = "[Legacy VPN]";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.428 -0400", hash_original_field = "B9E25A0AC362BE835CC8488AB95C56B0", hash_generated_field = "83D1742B520DA7FD872FDBB1828AD74A")

    public static final Parcelable.Creator<VpnConfig> CREATOR =
            new Parcelable.Creator<VpnConfig>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.718 -0500", hash_original_method = "AA8C9FD320C0310F391F554F5F034C68", hash_generated_method = "A8DE41ED76390B1F742A6E5AF75D6CFB")
        
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

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.721 -0500", hash_original_method = "6F41DF8A4C35C6701EDCFA57545C6084", hash_generated_method = "02B91117323844FEAAA422BD17C025E6")
        
@Override
        public VpnConfig[] newArray(int size) {
            return new VpnConfig[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.688 -0500", hash_original_field = "B37EB1ED61432756B8E994D3D7BA4599", hash_generated_field = "0D37FB1187DC93A5CBFAB3C14B0F27FB")

    public String user;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.691 -0500", hash_original_field = "A87999D214C9DBBDD0ECE4E5580D9C1E", hash_generated_field = "9342EB91AB7C5199220A234450DF96C8")

    public String interfaze;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.694 -0500", hash_original_field = "06EAABB630B26F22C79F8C0216AAF39C", hash_generated_field = "CAC90C98A578DDDD3D4C2D891257A143")

    public String session;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.696 -0500", hash_original_field = "229E7A91CADB1318F4905717BE32CDC9", hash_generated_field = "F5529878A82328FB28CC05D08BF17241")

    public int mtu = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.699 -0500", hash_original_field = "DC30A1601B5C9304EA9DA84E6B271498", hash_generated_field = "687ABFAA2D8194E3A4C3CAA6DA305AD5")

    public String addresses;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.701 -0500", hash_original_field = "60375ED550F44DFB213CC92C0B4868A6", hash_generated_field = "20DD824A8F7D017DD1D37F39CED9A870")

    public String routes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.703 -0500", hash_original_field = "8CE1EA61FCFAC447DA966F6D9200F93D", hash_generated_field = "C54FD7F60068D455D80ED4DC17F489C0")

    public List<String> dnsServers;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.705 -0500", hash_original_field = "593EFB0EB1629CCD0ECA46309C5E390F", hash_generated_field = "460A23BC5A4BAC5B37719D50B369576E")

    public List<String> searchDomains;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.707 -0500", hash_original_field = "C4CC92CA1F22E201D8B7199F29F45F5C", hash_generated_field = "DEA3E94F682B79FB8D965191517A969E")

    public PendingIntent configureIntent;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.709 -0500", hash_original_field = "40C7281C4007EC21E641A5C6511B0BB3", hash_generated_field = "DC78085E8C08FEBE821C9BA3907E0CCD")

    public long startTime = -1;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:10.426 -0400", hash_original_method = "0CC41B74437C55587D7B09044ACFFB33", hash_generated_method = "0CC41B74437C55587D7B09044ACFFB33")
    public VpnConfig ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.712 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:59:59.714 -0500", hash_original_method = "663713F2190B3FEEC06E42079AE10798", hash_generated_method = "656F39201885A701FF9786452503BBC5")
    
@Override
    public void writeToParcel(Parcel out, int flags) {
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
    }
}

