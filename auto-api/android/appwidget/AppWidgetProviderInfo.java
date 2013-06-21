package android.appwidget;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.os.Parcel;
import android.os.Parcelable;
import android.content.ComponentName;

public class AppWidgetProviderInfo implements Parcelable {
    public ComponentName provider;
    public int minWidth;
    public int minHeight;
    public int minResizeWidth;
    public int minResizeHeight;
    public int updatePeriodMillis;
    public int initialLayout;
    public ComponentName configure;
    public String label;
    public int icon;
    public int autoAdvanceViewId;
    public int previewImage;
    public int resizeMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.973 -0400", hash_original_method = "420920366E9BF4F133486E6ABF721531", hash_generated_method = "3BD10E1799DA4EF032CBAC6937E1F518")
    @DSModeled(DSC.SAFE)
    public AppWidgetProviderInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.974 -0400", hash_original_method = "C4FA8622C3713DE17EDD96169B7EDA22", hash_generated_method = "AB5AA328B8480388951B30DC05766569")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AppWidgetProviderInfo(Parcel in) {
        dsTaint.addTaint(in.dsTaint);
        {
            boolean var29DAD321C473403081C6A5A2E382533E_892853990 = (0 != in.readInt());
            {
                this.provider = new ComponentName(in);
            } //End block
        } //End collapsed parenthetic
        this.minWidth = in.readInt();
        this.minHeight = in.readInt();
        this.minResizeWidth = in.readInt();
        this.minResizeHeight = in.readInt();
        this.updatePeriodMillis = in.readInt();
        this.initialLayout = in.readInt();
        {
            boolean var29DAD321C473403081C6A5A2E382533E_1912448534 = (0 != in.readInt());
            {
                this.configure = new ComponentName(in);
            } //End block
        } //End collapsed parenthetic
        this.label = in.readString();
        this.icon = in.readInt();
        this.previewImage = in.readInt();
        this.autoAdvanceViewId = in.readInt();
        this.resizeMode = in.readInt();
        // ---------- Original Method ----------
        //if (0 != in.readInt()) {
            //this.provider = new ComponentName(in);
        //}
        //this.minWidth = in.readInt();
        //this.minHeight = in.readInt();
        //this.minResizeWidth = in.readInt();
        //this.minResizeHeight = in.readInt();
        //this.updatePeriodMillis = in.readInt();
        //this.initialLayout = in.readInt();
        //if (0 != in.readInt()) {
            //this.configure = new ComponentName(in);
        //}
        //this.label = in.readString();
        //this.icon = in.readInt();
        //this.previewImage = in.readInt();
        //this.autoAdvanceViewId = in.readInt();
        //this.resizeMode = in.readInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.976 -0400", hash_original_method = "7CC4DB09B3683A39C68E5073BD221953", hash_generated_method = "E99F8BE76D74DE1C60D77B7A7A93D191")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(android.os.Parcel out, int flags) {
        dsTaint.addTaint(flags);
        dsTaint.addTaint(out.dsTaint);
        {
            out.writeInt(1);
            this.provider.writeToParcel(out, flags);
        } //End block
        {
            out.writeInt(0);
        } //End block
        out.writeInt(this.minWidth);
        out.writeInt(this.minHeight);
        out.writeInt(this.minResizeWidth);
        out.writeInt(this.minResizeHeight);
        out.writeInt(this.updatePeriodMillis);
        out.writeInt(this.initialLayout);
        {
            out.writeInt(1);
            this.configure.writeToParcel(out, flags);
        } //End block
        {
            out.writeInt(0);
        } //End block
        out.writeString(this.label);
        out.writeInt(this.icon);
        out.writeInt(this.previewImage);
        out.writeInt(this.autoAdvanceViewId);
        out.writeInt(this.resizeMode);
        // ---------- Original Method ----------
        //if (this.provider != null) {
            //out.writeInt(1);
            //this.provider.writeToParcel(out, flags);
        //} else {
            //out.writeInt(0);
        //}
        //out.writeInt(this.minWidth);
        //out.writeInt(this.minHeight);
        //out.writeInt(this.minResizeWidth);
        //out.writeInt(this.minResizeHeight);
        //out.writeInt(this.updatePeriodMillis);
        //out.writeInt(this.initialLayout);
        //if (this.configure != null) {
            //out.writeInt(1);
            //this.configure.writeToParcel(out, flags);
        //} else {
            //out.writeInt(0);
        //}
        //out.writeString(this.label);
        //out.writeInt(this.icon);
        //out.writeInt(this.previewImage);
        //out.writeInt(this.autoAdvanceViewId);
        //out.writeInt(this.resizeMode);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.977 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.977 -0400", hash_original_method = "53CD7F02665BA9CCD92FD799E19E76A8", hash_generated_method = "C08495BF5A2EFC38EB8DE9028B92CF5F")
    @DSModeled(DSC.SAFE)
    public String toString() {
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return "AppWidgetProviderInfo(provider=" + this.provider + ")";
    }

    
    public static final int RESIZE_NONE             = 0;
    public static final int RESIZE_HORIZONTAL       = 1;
    public static final int RESIZE_VERTICAL         = 2;
    public static final int RESIZE_BOTH = RESIZE_HORIZONTAL | RESIZE_VERTICAL;
    public static final Parcelable.Creator<AppWidgetProviderInfo> CREATOR = new Parcelable.Creator<AppWidgetProviderInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.977 -0400", hash_original_method = "9F6E2268C17C614C77BDB86A1C281911", hash_generated_method = "2E503A8BCDEA73F9A37DB0652D71DFEE")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AppWidgetProviderInfo createFromParcel(Parcel parcel) {
            dsTaint.addTaint(parcel.dsTaint);
            AppWidgetProviderInfo varE62189E526E47CD78C55B42DF3608408_1982937299 = (new AppWidgetProviderInfo(parcel));
            return (AppWidgetProviderInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AppWidgetProviderInfo(parcel);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:39.978 -0400", hash_original_method = "0A81BD77D4C4F83726D5720A5DAB8762", hash_generated_method = "7B8BF0704803E761B354B36CD48B4B44")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public AppWidgetProviderInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            AppWidgetProviderInfo[] varBCF21ACC0C220B55B5A6433FD995C1DA_1402525417 = (new AppWidgetProviderInfo[size]);
            return (AppWidgetProviderInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new AppWidgetProviderInfo[size];
        }

        
}; //Transformed anonymous class
}

