package com.android.internal.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public class VpnConfig implements Parcelable {
    public String user;
    public String interfaze;
    public String session;
    public int mtu = -1;
    public String addresses;
    public String routes;
    public List<String> dnsServers;
    public List<String> searchDomains;
    public PendingIntent configureIntent;
    public long startTime = -1;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.185 -0400", hash_original_method = "452DB6015A203ED2BB55340043DD5357", hash_generated_method = "452DB6015A203ED2BB55340043DD5357")
        public VpnConfig ()
    {
    }


        public static Intent getIntentForConfirmation() {
        Intent intent = new Intent();
        intent.setClassName("com.android.vpndialogs", "com.android.vpndialogs.ConfirmDialog");
        return intent;
    }

    
        public static PendingIntent getIntentForStatusPanel(Context context, VpnConfig config) {
        Intent intent = new Intent();
        intent.setClassName("com.android.vpndialogs", "com.android.vpndialogs.ManageDialog");
        intent.putExtra("config", config);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        return PendingIntent.getActivity(context, 0, intent, (config == null) ?
                PendingIntent.FLAG_NO_CREATE : PendingIntent.FLAG_CANCEL_CURRENT);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.185 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "0DB50BC0CCE4711867E95DEC1B2117C7")
    @DSModeled(DSC.SAFE)
    @Override
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.186 -0400", hash_original_method = "663713F2190B3FEEC06E42079AE10798", hash_generated_method = "F404184717F9D8474356DC3A147AC78B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
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

    
    public static final String SERVICE_INTERFACE = "android.net.VpnService";
    public static final String LEGACY_VPN = "[Legacy VPN]";
    public static final Parcelable.Creator<VpnConfig> CREATOR = new Parcelable.Creator<VpnConfig>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.186 -0400", hash_original_method = "AA8C9FD320C0310F391F554F5F034C68", hash_generated_method = "AAAAF263F4378FDDB79DFF571F3B3AA7")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public VpnConfig createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            VpnConfig config;
            config = new VpnConfig();
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
            return (VpnConfig)dsTaint.getTaint();
            // ---------- Original Method ----------
            //VpnConfig config = new VpnConfig();
            //config.user = in.readString();
            //config.interfaze = in.readString();
            //config.session = in.readString();
            //config.mtu = in.readInt();
            //config.addresses = in.readString();
            //config.routes = in.readString();
            //config.dnsServers = in.createStringArrayList();
            //config.searchDomains = in.createStringArrayList();
            //config.configureIntent = in.readParcelable(null);
            //config.startTime = in.readLong();
            //return config;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.186 -0400", hash_original_method = "6F41DF8A4C35C6701EDCFA57545C6084", hash_generated_method = "778BAE94E07F84B59F624C73F5C25E8A")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public VpnConfig[] newArray(int size) {
            dsTaint.addTaint(size);
            VpnConfig[] var7815BBBC4A2FFDDD1F1F3556D805A93C_738088962 = (new VpnConfig[size]);
            return (VpnConfig[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new VpnConfig[size];
        }

        
}; //Transformed anonymous class
}

