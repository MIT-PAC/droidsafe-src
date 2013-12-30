package android.appwidget;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.content.ComponentName;
import android.os.Parcel;
import android.os.Parcelable;





public class AppWidgetProviderInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.148 -0500", hash_original_field = "8966F04F3441BA555C3A470D4262D50F", hash_generated_field = "5E95298B54F00B76D69F1540A6AB4F69")

    public static final int RESIZE_NONE             = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.152 -0500", hash_original_field = "67EFBB0A946E64A222E47FD45FBB7D92", hash_generated_field = "FE40FA22E3B57D57EC76B08154902D36")

    public static final int RESIZE_HORIZONTAL       = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.155 -0500", hash_original_field = "95A70EEF6B58F748BB8819BDAD32281E", hash_generated_field = "207FA112EFBD894FDA50F5AEB6DE193C")

    public static final int RESIZE_VERTICAL         = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.158 -0500", hash_original_field = "75DFD656287702B14031578B8C1A8937", hash_generated_field = "EEC423C4BCE7BE8BEFBE09B29CE89201")

    public static final int RESIZE_BOTH = RESIZE_HORIZONTAL | RESIZE_VERTICAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:22:57.822 -0400", hash_original_field = "883A81E470E5C7E159E2B31AE79A7AE4", hash_generated_field = "DD08E9F769B7A2C28D9ADFCF2C938257")

    public static final Parcelable.Creator<AppWidgetProviderInfo> CREATOR
            = new Parcelable.Creator<AppWidgetProviderInfo>()
    {
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.213 -0500", hash_original_method = "9F6E2268C17C614C77BDB86A1C281911", hash_generated_method = "7CF35D729B98B4ABDC4961BF9B28064A")
        
public AppWidgetProviderInfo createFromParcel(Parcel parcel)
        {
            return new AppWidgetProviderInfo(parcel);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.216 -0500", hash_original_method = "0A81BD77D4C4F83726D5720A5DAB8762", hash_generated_method = "9B257D1C40E990303CBF453332E91145")
        
public AppWidgetProviderInfo[] newArray(int size)
        {
            return new AppWidgetProviderInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.161 -0500", hash_original_field = "D82520D660F9F2F6721C8E642F801158", hash_generated_field = "C0C8252EB397029DCC49105E549FECC7")

    public ComponentName provider;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.164 -0500", hash_original_field = "BBEBF85B9F772987A16CB5E94A1403C2", hash_generated_field = "4A8C8EE9F9093ACCF2554C39165777C8")

    public int minWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.167 -0500", hash_original_field = "058F8CEF26A8FB0B9816D79B31126248", hash_generated_field = "94A6AD506DB0192037B7FEA62EEA0310")

    public int minHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.170 -0500", hash_original_field = "986C05D632B8F77ED9F72BA58160EAD3", hash_generated_field = "6A00628B36E0CA6B1171CBF84B7D68EE")

    public int minResizeWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.173 -0500", hash_original_field = "EA63F3A8D63EF3744CE8FB8655EE7797", hash_generated_field = "A95B2398F84B7E45B0C04EBC4FC4E731")

    public int minResizeHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.176 -0500", hash_original_field = "FB1F4DB44F42C1415C51AADC254F160E", hash_generated_field = "9C59ED0DEF9FFC4F5B04AC47EFDE9D7D")

    public int updatePeriodMillis;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.179 -0500", hash_original_field = "6ED7FEEFA231DFD0EC03FA1B08CA711C", hash_generated_field = "90CA0E07A98BA43D2AB97B34EB05C3BC")

    public int initialLayout;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.181 -0500", hash_original_field = "D76367E031F6FDA609340259ED7233EE", hash_generated_field = "DE832F6EBB73FD953588ABC18B17B6B8")

    public ComponentName configure;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.184 -0500", hash_original_field = "70D504428E5C639AB422D258A4592324", hash_generated_field = "B1C3A1439C6538148E2C8C0A71DA201D")

    public String label;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.188 -0500", hash_original_field = "107298D9FB7BD66B47A702264D3B04F5", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.191 -0500", hash_original_field = "8C1BDF83BE48974DF7D91E16F2AEFF02", hash_generated_field = "3D2ED809846AE50195B7D99124001491")

    public int autoAdvanceViewId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.194 -0500", hash_original_field = "8BAD8F1B133115086A90181FC251BD47", hash_generated_field = "F7CCEF6695BD3F2FFC9D92260E3C39C3")

	public int previewImage;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.197 -0500", hash_original_field = "4C99FACADE5BA309650CEAC65277E597", hash_generated_field = "2B262CFF3800BE09CBF37D5C49423DD0")

    public int resizeMode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.200 -0500", hash_original_method = "420920366E9BF4F133486E6ABF721531", hash_generated_method = "0CF797CC9D9CFB9D6846EB1CCE858995")
    
public AppWidgetProviderInfo() {
    }

    /**
     * Unflatten the AppWidgetProviderInfo from a parcel.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.203 -0500", hash_original_method = "C4FA8622C3713DE17EDD96169B7EDA22", hash_generated_method = "AD64F3275ECFC1471BF78525F8BEF3BD")
    
public AppWidgetProviderInfo(Parcel in) {
        if (0 != in.readInt()) {
            this.provider = new ComponentName(in);
        }
        this.minWidth = in.readInt();
        this.minHeight = in.readInt();
        this.minResizeWidth = in.readInt();
        this.minResizeHeight = in.readInt();
        this.updatePeriodMillis = in.readInt();
        this.initialLayout = in.readInt();
        if (0 != in.readInt()) {
            this.configure = new ComponentName(in);
        }
        this.label = in.readString();
        this.icon = in.readInt();
        this.previewImage = in.readInt();
        this.autoAdvanceViewId = in.readInt();
        this.resizeMode = in.readInt();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.206 -0500", hash_original_method = "7CC4DB09B3683A39C68E5073BD221953", hash_generated_method = "F89991952A92DEFD6A2EEDE81A03A135")
    
public void writeToParcel(android.os.Parcel out, int flags) {
        if (this.provider != null) {
            out.writeInt(1);
            this.provider.writeToParcel(out, flags);
        } else {
            out.writeInt(0);
        }
        out.writeInt(this.minWidth);
        out.writeInt(this.minHeight);
        out.writeInt(this.minResizeWidth);
        out.writeInt(this.minResizeHeight);
        out.writeInt(this.updatePeriodMillis);
        out.writeInt(this.initialLayout);
        if (this.configure != null) {
            out.writeInt(1);
            this.configure.writeToParcel(out, flags);
        } else {
            out.writeInt(0);
        }
        out.writeString(this.label);
        out.writeInt(this.icon);
        out.writeInt(this.previewImage);
        out.writeInt(this.autoAdvanceViewId);
        out.writeInt(this.resizeMode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.209 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:27:56.223 -0500", hash_original_method = "53CD7F02665BA9CCD92FD799E19E76A8", hash_generated_method = "97ACDA7264E8914778E17C6A0277CAB0")
    
public String toString() {
        return "AppWidgetProviderInfo(provider=" + this.provider + ")";
    }
    // orphaned legacy method
    public AppWidgetProviderInfo createFromParcel(Parcel parcel)
        {
            return new AppWidgetProviderInfo(parcel);
        }
    
    // orphaned legacy method
    public AppWidgetProviderInfo[] newArray(int size)
        {
            return new AppWidgetProviderInfo[size];
        }
    
}

