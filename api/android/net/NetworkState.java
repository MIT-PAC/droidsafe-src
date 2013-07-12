package android.net;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.os.Parcel;
import android.os.Parcelable;

public class NetworkState implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.858 -0400", hash_original_field = "BC303683CCB67AB9CAD099FFC4A3091E", hash_generated_field = "97BC2F6998D1E4D0DED95BC177B82BD4")

    public NetworkInfo networkInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.858 -0400", hash_original_field = "DC6DF7A05A86671C3549B5A63A5A6670", hash_generated_field = "CBFC770A2970049F6731C897B915E6C6")

    public LinkProperties linkProperties;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.858 -0400", hash_original_field = "CA6977523CA7B34CC7E419D7BC74C6B9", hash_generated_field = "709DF8FAD9D2C0999D23D1CB1083A57F")

    public LinkCapabilities linkCapabilities;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.858 -0400", hash_original_field = "D604F8CA3706BFE3334B0404EA7E69AF", hash_generated_field = "F09B47F115240A14430924B2A0765832")

    public String subscriberId;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.859 -0400", hash_original_method = "D6391A7872D312C012506A6DA31DB5D3", hash_generated_method = "EC0F42F4E0307B6126DF6332390DADB8")
    public  NetworkState(NetworkInfo networkInfo, LinkProperties linkProperties,
            LinkCapabilities linkCapabilities) {
        this(networkInfo, linkProperties, linkCapabilities, null);
        addTaint(linkCapabilities.getTaint());
        addTaint(linkProperties.getTaint());
        addTaint(networkInfo.getTaint());
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.860 -0400", hash_original_method = "9B5E574B8F0C49F1D3E90E7F9E978574", hash_generated_method = "67457763AE93E14049403E64D5960DBD")
    public  NetworkState(NetworkInfo networkInfo, LinkProperties linkProperties,
            LinkCapabilities linkCapabilities, String subscriberId) {
        this.networkInfo = networkInfo;
        this.linkProperties = linkProperties;
        this.linkCapabilities = linkCapabilities;
        this.subscriberId = subscriberId;
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.861 -0400", hash_original_method = "A56CA9045340CA1A085D30A3C9DD57C6", hash_generated_method = "EB8EA19A14538AF6862AF07AB6EA3AA9")
    public  NetworkState(Parcel in) {
        networkInfo = in.readParcelable(null);
        linkProperties = in.readParcelable(null);
        linkCapabilities = in.readParcelable(null);
        subscriberId = in.readString();
        
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.861 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "BF984915C2516708770973A7C48AB7E9")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_2117948349 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215297583 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215297583;
        
        
    }

    
    @DSModeled(DSC.SPEC)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.862 -0400", hash_original_method = "EF66345FC72BF78BF99044E19149D234", hash_generated_method = "48A4DC19AEE40DD53090FA15BD129CC8")
    public void writeToParcel(Parcel out, int flags) {
        addTaint(flags);
        addTaint(out.getTaint());
        out.writeParcelable(networkInfo, flags);
        out.writeParcelable(linkProperties, flags);
        out.writeParcelable(linkCapabilities, flags);
        out.writeString(subscriberId);
        
        
        
        
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:25.862 -0400", hash_original_field = "639231E2CF24AC818C14B1454EE59F27", hash_generated_field = "8B25ACE201431313251FD6C8326EA110")

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

