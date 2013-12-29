package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.util.Printer;





public class ComponentInfo extends PackageItemInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.365 -0500", hash_original_field = "E1F5069A4C4BF89A2D890A883EC45793", hash_generated_field = "89C41A1178051ADE4F3D6AE74553DD49")

    public ApplicationInfo applicationInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.366 -0500", hash_original_field = "182AC29DC74CEB0C6C89C5576E47A4DD", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

    public String processName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.367 -0500", hash_original_field = "1C23F3ABB5154D4340D3FAF2DBF4B754", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.368 -0500", hash_original_field = "F820890665F7FBF0C08C507B72EF4704", hash_generated_field = "1F483398D0B87CDABAB06F6BA44B73E7")

    public boolean enabled = true;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.368 -0500", hash_original_field = "92E52A4307B95CA7B932EBE03EBE6162", hash_generated_field = "30B6E49162C4492B8B607024F789E7B8")

    public boolean exported = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.369 -0500", hash_original_method = "40B8C3B7DAB12BDDED651BA5685CD836", hash_generated_method = "FEDD4837038806A793BB3B640CA381C3")
    public ComponentInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.370 -0500", hash_original_method = "B9EA4C4630C52812153A03C2146AF2BB", hash_generated_method = "9C013CB6F42DB1128A952258D8E00D86")
    public ComponentInfo(ComponentInfo orig) {
        super(orig);
        applicationInfo = orig.applicationInfo;
        processName = orig.processName;
        descriptionRes = orig.descriptionRes;
        enabled = orig.enabled;
        exported = orig.exported;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.377 -0500", hash_original_method = "4EE83CF183C8886AFEBB107F6033AC9F", hash_generated_method = "02DFB0E929FC803C7CFB762B24DDB40B")
    protected ComponentInfo(Parcel source) {
        super(source);
        applicationInfo = ApplicationInfo.CREATOR.createFromParcel(source);
        processName = source.readString();
        descriptionRes = source.readInt();
        enabled = (source.readInt() != 0);
        exported = (source.readInt() != 0);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.371 -0500", hash_original_method = "19CED443F16784258FF178C9AF81CAC8", hash_generated_method = "9A57E4A78540DAAB33B0079D1160C5F7")
    @Override
public CharSequence loadLabel(PackageManager pm) {
        if (nonLocalizedLabel != null) {
            return nonLocalizedLabel;
        }
        ApplicationInfo ai = applicationInfo;
        CharSequence label;
        if (labelRes != 0) {
            label = pm.getText(packageName, labelRes, ai);
            if (label != null) {
                return label;
            }
        }
        if (ai.nonLocalizedLabel != null) {
            return ai.nonLocalizedLabel;
        }
        if (ai.labelRes != 0) {
            label = pm.getText(packageName, ai.labelRes, ai);
            if (label != null) {
                return label;
            }
        }
        return name;
    }

    /**
     * Return whether this component and its enclosing application are enabled.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.372 -0500", hash_original_method = "CF29F8673A9FD20E39B97C12C8CE0496", hash_generated_method = "C9F8B26C82EDB70FBC40AAAFB8FA016B")
    public boolean isEnabled() {
        return enabled && applicationInfo.enabled;
    }
    
    /**
     * Return the icon resource identifier to use for this component.  If
     * the component defines an icon, that is used; else, the application
     * icon is used.
     * 
     * @return The icon associated with this component.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.373 -0500", hash_original_method = "39BF66743A5A058B0728A86B3B731327", hash_generated_method = "2063D75F4BECC5EC9C4AE3DBCB9FC602")
    public final int getIconResource() {
        return icon != 0 ? icon : applicationInfo.icon;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.374 -0500", hash_original_method = "C34E4D575D4D3E32714E222B7945E44B", hash_generated_method = "88A32FF114FCE8B9658C1A8CC4560277")
    protected void dumpFront(Printer pw, String prefix) {
        super.dumpFront(pw, prefix);
        pw.println(prefix + "enabled=" + enabled + " exported=" + exported
                + " processName=" + processName);
        if (descriptionRes != 0) {
            pw.println(prefix + "description=" + descriptionRes);
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.374 -0500", hash_original_method = "A2A63684817A6733D86C3069C8C4DE2F", hash_generated_method = "45BCCB196CEAE146E63FEFAA9F2BE603")
    protected void dumpBack(Printer pw, String prefix) {
        if (applicationInfo != null) {
            pw.println(prefix + "ApplicationInfo:");
            applicationInfo.dump(pw, prefix + "  ");
        } else {
            pw.println(prefix + "ApplicationInfo: null");
        }
        super.dumpBack(pw, prefix);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.376 -0500", hash_original_method = "7785077CB57413EF53E49F7AC7F9E06F", hash_generated_method = "AE78DC4E309D2167A029CE47E2B1549B")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        applicationInfo.writeToParcel(dest, parcelableFlags);
        dest.writeString(processName);
        dest.writeInt(descriptionRes);
        dest.writeInt(enabled ? 1 : 0);
        dest.writeInt(exported ? 1 : 0);
    }
    
    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.377 -0500", hash_original_method = "584CAA069A59D426001F803F7AD39AAD", hash_generated_method = "6F0B1F9A6B07FECD018C6589BD2FBF43")
    @Override
protected Drawable loadDefaultIcon(PackageManager pm) {
        return applicationInfo.loadIcon(pm);
    }
    
    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.378 -0500", hash_original_method = "E27DEF2367944E00B3FB42CCCCC00CEB", hash_generated_method = "25D3A1E02308AA93E9335D0B8FF03F18")
    @Override
protected Drawable loadDefaultLogo(PackageManager pm) {
        return applicationInfo.loadLogo(pm);
    }
    
    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:50:04.379 -0500", hash_original_method = "6586F246687FA42890C123804417F38B", hash_generated_method = "005A1C2B4309D356346549BE409C61D5")
    @Override
protected ApplicationInfo getApplicationInfo() {
        return applicationInfo;
    }

    
}

