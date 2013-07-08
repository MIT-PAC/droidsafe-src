package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;

public class NetworkState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.454 -0400", hash_original_field = "BC303683CCB67AB9CAD099FFC4A3091E", hash_generated_field = "97BC2F6998D1E4D0DED95BC177B82BD4")

    public NetworkInfo networkInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.454 -0400", hash_original_field = "DC6DF7A05A86671C3549B5A63A5A6670", hash_generated_field = "CBFC770A2970049F6731C897B915E6C6")

    public LinkProperties linkProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.454 -0400", hash_original_field = "CA6977523CA7B34CC7E419D7BC74C6B9", hash_generated_field = "709DF8FAD9D2C0999D23D1CB1083A57F")

    public LinkCapabilities linkCapabilities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.454 -0400", hash_original_field = "D604F8CA3706BFE3334B0404EA7E69AF", hash_generated_field = "F09B47F115240A14430924B2A0765832")

    public String subscriberId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.454 -0400", hash_original_method = "D6391A7872D312C012506A6DA31DB5D3", hash_generated_method = "AE0700FDA41D8FD3ABD033B65289CDD9")
    public  NetworkState(NetworkInfo networkInfo, LinkProperties linkProperties,
            LinkCapabilities linkCapabilities) {
        this(networkInfo, linkProperties, linkCapabilities, null);
        addTaint(networkInfo.getTaint());
        addTaint(linkProperties.getTaint());
        addTaint(linkCapabilities.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.455 -0400", hash_original_method = "9B5E574B8F0C49F1D3E90E7F9E978574", hash_generated_method = "67457763AE93E14049403E64D5960DBD")
    public  NetworkState(NetworkInfo networkInfo, LinkProperties linkProperties,
            LinkCapabilities linkCapabilities, String subscriberId) {
        this.networkInfo = networkInfo;
        this.linkProperties = linkProperties;
        this.linkCapabilities = linkCapabilities;
        this.subscriberId = subscriberId;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.455 -0400", hash_original_method = "A56CA9045340CA1A085D30A3C9DD57C6", hash_generated_method = "EB8EA19A14538AF6862AF07AB6EA3AA9")
    public  NetworkState(Parcel in) {
        networkInfo = in.readParcelable(null);
        linkProperties = in.readParcelable(null);
        linkCapabilities = in.readParcelable(null);
        subscriberId = in.readString();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.456 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "4A6C465D5EA41EDA6530E7510AA44776")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960358043 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_960358043;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.456 -0400", hash_original_method = "EF66345FC72BF78BF99044E19149D234", hash_generated_method = "AF073625C65FBB2B40B40897ECFEF834")
    public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(networkInfo, flags);
        out.writeParcelable(linkProperties, flags);
        out.writeParcelable(linkCapabilities, flags);
        out.writeString(subscriberId);
        addTaint(out.getTaint());
        addTaint(flags);
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:37.456 -0400", hash_original_field = "639231E2CF24AC818C14B1454EE59F27", hash_generated_field = "8B25ACE201431313251FD6C8326EA110")

    public static final Creator<NetworkState> CREATOR = new Creator<NetworkState>() {
        public NetworkState createFromParcel(Parcel in) {
            return new NetworkState(in);
        }

        public NetworkState[] newArray(int size) {
            return new NetworkState[size];
        }
    };
    
    public NetworkState createFromParcel(Parcel in) {
            return new NetworkState(in);
        }
    
    
    public NetworkState[] newArray(int size) {
            return new NetworkState[size];
        }
    
}

