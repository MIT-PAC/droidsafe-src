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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.363 -0400", hash_original_field = "9E9F3D70BD8C8957627EADA96D967706", hash_generated_field = "C0C8252EB397029DCC49105E549FECC7")

    public ComponentName provider;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.364 -0400", hash_original_field = "A97D36BDAAF6AB5695CD91D529306A52", hash_generated_field = "4A8C8EE9F9093ACCF2554C39165777C8")

    public int minWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.364 -0400", hash_original_field = "0B102646706765EBE27E75CCB99EA651", hash_generated_field = "94A6AD506DB0192037B7FEA62EEA0310")

    public int minHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.365 -0400", hash_original_field = "432C8A2DD729D392EE0E955D33674DAC", hash_generated_field = "6A00628B36E0CA6B1171CBF84B7D68EE")

    public int minResizeWidth;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.365 -0400", hash_original_field = "7F9E685A6981A713968C7402995D6816", hash_generated_field = "A95B2398F84B7E45B0C04EBC4FC4E731")

    public int minResizeHeight;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.365 -0400", hash_original_field = "AD43512B11D2EED508F1878A1B9E1B03", hash_generated_field = "9C59ED0DEF9FFC4F5B04AC47EFDE9D7D")

    public int updatePeriodMillis;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.366 -0400", hash_original_field = "1784EB394192608D381EE1754DD965E9", hash_generated_field = "90CA0E07A98BA43D2AB97B34EB05C3BC")

    public int initialLayout;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.366 -0400", hash_original_field = "E2D5A00791BCE9A01F99BC6FD613A39D", hash_generated_field = "DE832F6EBB73FD953588ABC18B17B6B8")

    public ComponentName configure;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.366 -0400", hash_original_field = "D304BA20E96D87411588EEABAC850E34", hash_generated_field = "B1C3A1439C6538148E2C8C0A71DA201D")

    public String label;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.376 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.376 -0400", hash_original_field = "95E777EA807863DF13B0707EA9595502", hash_generated_field = "3D2ED809846AE50195B7D99124001491")

    public int autoAdvanceViewId;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.377 -0400", hash_original_field = "393692F6BA7F266440AC8B3E5F7A37D4", hash_generated_field = "F7CCEF6695BD3F2FFC9D92260E3C39C3")

    public int previewImage;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.377 -0400", hash_original_field = "95C42E5719F32957418EBD69B3321263", hash_generated_field = "2B262CFF3800BE09CBF37D5C49423DD0")

    public int resizeMode;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.378 -0400", hash_original_method = "420920366E9BF4F133486E6ABF721531", hash_generated_method = "3BD10E1799DA4EF032CBAC6937E1F518")
    public  AppWidgetProviderInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.415 -0400", hash_original_method = "C4FA8622C3713DE17EDD96169B7EDA22", hash_generated_method = "9272D0E2D9B6CB9042E05C8AD737E53C")
    public  AppWidgetProviderInfo(Parcel in) {
        {
            boolean var29DAD321C473403081C6A5A2E382533E_119453047 = (0 != in.readInt());
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
            boolean var29DAD321C473403081C6A5A2E382533E_1614916438 = (0 != in.readInt());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.421 -0400", hash_original_method = "7CC4DB09B3683A39C68E5073BD221953", hash_generated_method = "DA697ADB412A0D4CB4D9B2EA24BCD5DD")
    public void writeToParcel(android.os.Parcel out, int flags) {
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
        addTaint(out.getTaint());
        addTaint(flags);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.423 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "2840FA4EF429673252443D2D05674D1D")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_259175803 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_259175803;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.439 -0400", hash_original_method = "53CD7F02665BA9CCD92FD799E19E76A8", hash_generated_method = "69F168792011A298C4F61766AA70801C")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1459193719 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1459193719 = "AppWidgetProviderInfo(provider=" + this.provider + ")";
        varB4EAC82CA7396A68D541C85D26508E83_1459193719.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1459193719;
        // ---------- Original Method ----------
        //return "AppWidgetProviderInfo(provider=" + this.provider + ")";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.440 -0400", hash_original_field = "ABE248333D7EF758BE237D19D1971694", hash_generated_field = "5E95298B54F00B76D69F1540A6AB4F69")

    public static final int RESIZE_NONE             = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.440 -0400", hash_original_field = "694D1A72802BC2A5C39DF0E8366FD3C1", hash_generated_field = "FE40FA22E3B57D57EC76B08154902D36")

    public static final int RESIZE_HORIZONTAL       = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.440 -0400", hash_original_field = "6FFFC937516D74062159017FA0445035", hash_generated_field = "207FA112EFBD894FDA50F5AEB6DE193C")

    public static final int RESIZE_VERTICAL         = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.440 -0400", hash_original_field = "5D626302FA4B4C37A9C990CFA6D40CD2", hash_generated_field = "EEC423C4BCE7BE8BEFBE09B29CE89201")

    public static final int RESIZE_BOTH = RESIZE_HORIZONTAL | RESIZE_VERTICAL;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:11:56.441 -0400", hash_original_field = "883A81E470E5C7E159E2B31AE79A7AE4", hash_generated_field = "DD08E9F769B7A2C28D9ADFCF2C938257")

    public static final Parcelable.Creator<AppWidgetProviderInfo> CREATOR
            = new Parcelable.Creator<AppWidgetProviderInfo>()
    {
        public AppWidgetProviderInfo createFromParcel(Parcel parcel)
        {
            return new AppWidgetProviderInfo(parcel);
        }

        public AppWidgetProviderInfo[] newArray(int size)
        {
            return new AppWidgetProviderInfo[size];
        }
    };
}

