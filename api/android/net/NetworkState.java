package android.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

public class NetworkState implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:18.548 -0400", hash_original_field = "639231E2CF24AC818C14B1454EE59F27", hash_generated_field = "8B25ACE201431313251FD6C8326EA110")

    public static final Creator<NetworkState> CREATOR = new Creator<NetworkState>() {
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.836 -0500", hash_original_method = "15EBC0DC5CBC737927737366BF6F583B", hash_generated_method = "4551183C47257C0E12461AF767F8E520")
        
public NetworkState createFromParcel(Parcel in) {
            return new NetworkState(in);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.839 -0500", hash_original_method = "04BD08A70BEFD05228EA4DFDCF34FD97", hash_generated_method = "631A6EB060FE2057E9584AAA07A62486")
        
public NetworkState[] newArray(int size) {
            return new NetworkState[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.815 -0500", hash_original_field = "783575A388C9A34EBCFC54A057A5B9A4", hash_generated_field = "97BC2F6998D1E4D0DED95BC177B82BD4")

    public  NetworkInfo networkInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.818 -0500", hash_original_field = "9710D51B67527C9083778B928FD16963", hash_generated_field = "CBFC770A2970049F6731C897B915E6C6")

    public  LinkProperties linkProperties;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.820 -0500", hash_original_field = "C3CB226F194F6F6DD63A64B73871FC3A", hash_generated_field = "709DF8FAD9D2C0999D23D1CB1083A57F")

    public  LinkCapabilities linkCapabilities;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.822 -0500", hash_original_field = "62600314E5CA5D1B5FEE830E1C48563A", hash_generated_field = "F09B47F115240A14430924B2A0765832")

    public  String subscriberId;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.824 -0500", hash_original_method = "D6391A7872D312C012506A6DA31DB5D3", hash_generated_method = "CEFD1C208A71975537A558EC3C6312CF")
    
public NetworkState(NetworkInfo networkInfo, LinkProperties linkProperties,
            LinkCapabilities linkCapabilities) {
        this(networkInfo, linkProperties, linkCapabilities, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.826 -0500", hash_original_method = "9B5E574B8F0C49F1D3E90E7F9E978574", hash_generated_method = "5A30959C97E9F724A96F7F66FA703037")
    
public NetworkState(NetworkInfo networkInfo, LinkProperties linkProperties,
            LinkCapabilities linkCapabilities, String subscriberId) {
        this.networkInfo = networkInfo;
        this.linkProperties = linkProperties;
        this.linkCapabilities = linkCapabilities;
        this.subscriberId = subscriberId;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.829 -0500", hash_original_method = "A56CA9045340CA1A085D30A3C9DD57C6", hash_generated_method = "D724FD02B76C9F056A9BCAA20AEF8380")
    
public NetworkState(Parcel in) {
        networkInfo = in.readParcelable(null);
        linkProperties = in.readParcelable(null);
        linkCapabilities = in.readParcelable(null);
        subscriberId = in.readString();
    }

    /** {@inheritDoc} */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.831 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    /** {@inheritDoc} */
    @DSSink({DSSinkKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:36:21.833 -0500", hash_original_method = "EF66345FC72BF78BF99044E19149D234", hash_generated_method = "3FBB245BDE9928E253253C2856C3D731")
    
public void writeToParcel(Parcel out, int flags) {
        out.writeParcelable(networkInfo, flags);
        out.writeParcelable(linkProperties, flags);
        out.writeParcelable(linkCapabilities, flags);
        out.writeString(subscriberId);
    }
    // orphaned legacy method
    public NetworkState createFromParcel(Parcel in) {
            return new NetworkState(in);
        }
    
    // orphaned legacy method
    public NetworkState[] newArray(int size) {
            return new NetworkState[size];
        }
    
}

