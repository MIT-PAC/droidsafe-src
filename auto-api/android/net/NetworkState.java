package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class NetworkState implements Parcelable {
    public NetworkInfo networkInfo;
    public LinkProperties linkProperties;
    public LinkCapabilities linkCapabilities;
    public String subscriberId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.131 -0400", hash_original_method = "D6391A7872D312C012506A6DA31DB5D3", hash_generated_method = "140689251D1622CB0B6921F0067C690A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkState(NetworkInfo networkInfo, LinkProperties linkProperties,
            LinkCapabilities linkCapabilities) {
        this(networkInfo, linkProperties, linkCapabilities, null);
        dsTaint.addTaint(linkCapabilities.dsTaint);
        dsTaint.addTaint(linkProperties.dsTaint);
        dsTaint.addTaint(networkInfo.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.131 -0400", hash_original_method = "9B5E574B8F0C49F1D3E90E7F9E978574", hash_generated_method = "805840C3BAB51A00AEC78FF31A93883D")
    @DSModeled(DSC.SAFE)
    public NetworkState(NetworkInfo networkInfo, LinkProperties linkProperties,
            LinkCapabilities linkCapabilities, String subscriberId) {
        dsTaint.addTaint(linkCapabilities.dsTaint);
        dsTaint.addTaint(subscriberId);
        dsTaint.addTaint(linkProperties.dsTaint);
        dsTaint.addTaint(networkInfo.dsTaint);
        // ---------- Original Method ----------
        //this.networkInfo = networkInfo;
        //this.linkProperties = linkProperties;
        //this.linkCapabilities = linkCapabilities;
        //this.subscriberId = subscriberId;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.132 -0400", hash_original_method = "A56CA9045340CA1A085D30A3C9DD57C6", hash_generated_method = "65AE92E0F0D02C4A1A802A4101B1F1DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public NetworkState(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        networkInfo = in.readParcelable(null);
        linkProperties = in.readParcelable(null);
        linkCapabilities = in.readParcelable(null);
        subscriberId = in.readString();
        // ---------- Original Method ----------
        //networkInfo = in.readParcelable(null);
        //linkProperties = in.readParcelable(null);
        //linkCapabilities = in.readParcelable(null);
        //subscriberId = in.readString();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.132 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.132 -0400", hash_original_method = "EF66345FC72BF78BF99044E19149D234", hash_generated_method = "C50AEDB5288E1D5339F556FEC254BB5C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        out.writeParcelable(networkInfo, flags);
        out.writeParcelable(linkProperties, flags);
        out.writeParcelable(linkCapabilities, flags);
        out.writeString(subscriberId);
        // ---------- Original Method ----------
        //out.writeParcelable(networkInfo, flags);
        //out.writeParcelable(linkProperties, flags);
        //out.writeParcelable(linkCapabilities, flags);
        //out.writeString(subscriberId);
    }

    
    public static final Creator<NetworkState> CREATOR = new Creator<NetworkState>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.133 -0400", hash_original_method = "15EBC0DC5CBC737927737366BF6F583B", hash_generated_method = "10D288812541070EF1286AE9EE503C64")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkState createFromParcel(Parcel in) {
            dsTaint.addTaint(in.dsTaint);
            NetworkState var3442A7EB079CD9CA79BE38A87F68F5CB_2141387257 = (new NetworkState(in));
            return (NetworkState)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkState(in);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.133 -0400", hash_original_method = "04BD08A70BEFD05228EA4DFDCF34FD97", hash_generated_method = "F2BF380C1FCD61B1D1BD55AD50A10806")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public NetworkState[] newArray(int size) {
            dsTaint.addTaint(size);
            NetworkState[] varFD45664D01708C50AB3515C7D3219B9A_253683446 = (new NetworkState[size]);
            return (NetworkState[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new NetworkState[size];
        }

        
}; //Transformed anonymous class
}

