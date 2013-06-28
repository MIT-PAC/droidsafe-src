package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.util.Printer;

public class ComponentInfo extends PackageItemInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.054 -0400", hash_original_field = "15CA13E1529EAD87820F354B3BC6598E", hash_generated_field = "89C41A1178051ADE4F3D6AE74553DD49")

    public ApplicationInfo applicationInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.054 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

    public String processName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.054 -0400", hash_original_field = "392A6E47A749448B7E51283719BBB183", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.054 -0400", hash_original_field = "34CF7D88530CECE9FD068A5118796419", hash_generated_field = "1F483398D0B87CDABAB06F6BA44B73E7")

    public boolean enabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.054 -0400", hash_original_field = "07A335FC29B9F4E240CFA508D409FE2F", hash_generated_field = "30B6E49162C4492B8B607024F789E7B8")

    public boolean exported = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.055 -0400", hash_original_method = "40B8C3B7DAB12BDDED651BA5685CD836", hash_generated_method = "6F61DA8191C6FB3294C15407326E1E92")
    public  ComponentInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.055 -0400", hash_original_method = "B9EA4C4630C52812153A03C2146AF2BB", hash_generated_method = "F31039CC77FC235E716B402EC5E1D440")
    public  ComponentInfo(ComponentInfo orig) {
        super(orig);
        applicationInfo = orig.applicationInfo;
        processName = orig.processName;
        descriptionRes = orig.descriptionRes;
        enabled = orig.enabled;
        exported = orig.exported;
        // ---------- Original Method ----------
        //applicationInfo = orig.applicationInfo;
        //processName = orig.processName;
        //descriptionRes = orig.descriptionRes;
        //enabled = orig.enabled;
        //exported = orig.exported;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.056 -0400", hash_original_method = "4EE83CF183C8886AFEBB107F6033AC9F", hash_generated_method = "03F5458FA1F9A5EA5459FC8909E69005")
    protected  ComponentInfo(Parcel source) {
        super(source);
        applicationInfo = ApplicationInfo.CREATOR.createFromParcel(source);
        processName = source.readString();
        descriptionRes = source.readInt();
        enabled = (source.readInt() != 0);
        exported = (source.readInt() != 0);
        // ---------- Original Method ----------
        //applicationInfo = ApplicationInfo.CREATOR.createFromParcel(source);
        //processName = source.readString();
        //descriptionRes = source.readInt();
        //enabled = (source.readInt() != 0);
        //exported = (source.readInt() != 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.057 -0400", hash_original_method = "19CED443F16784258FF178C9AF81CAC8", hash_generated_method = "E9A2720C38C8BA9CCF99B7D158FE4997")
    @Override
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1531866385 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_109774693 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1372742992 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1935664123 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1730719604 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_1531866385 = nonLocalizedLabel;
        } //End block
        ApplicationInfo ai = applicationInfo;
        CharSequence label;
        {
            label = pm.getText(packageName, labelRes, ai);
            {
                varB4EAC82CA7396A68D541C85D26508E83_109774693 = label;
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1372742992 = ai.nonLocalizedLabel;
        } //End block
        {
            label = pm.getText(packageName, ai.labelRes, ai);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1935664123 = label;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1730719604 = name;
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_262800069; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_262800069 = varB4EAC82CA7396A68D541C85D26508E83_1531866385;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_262800069 = varB4EAC82CA7396A68D541C85D26508E83_109774693;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_262800069 = varB4EAC82CA7396A68D541C85D26508E83_1372742992;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_262800069 = varB4EAC82CA7396A68D541C85D26508E83_1935664123;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_262800069 = varB4EAC82CA7396A68D541C85D26508E83_1730719604;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_262800069.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_262800069;
        // ---------- Original Method ----------
        //if (nonLocalizedLabel != null) {
            //return nonLocalizedLabel;
        //}
        //ApplicationInfo ai = applicationInfo;
        //CharSequence label;
        //if (labelRes != 0) {
            //label = pm.getText(packageName, labelRes, ai);
            //if (label != null) {
                //return label;
            //}
        //}
        //if (ai.nonLocalizedLabel != null) {
            //return ai.nonLocalizedLabel;
        //}
        //if (ai.labelRes != 0) {
            //label = pm.getText(packageName, ai.labelRes, ai);
            //if (label != null) {
                //return label;
            //}
        //}
        //return name;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.058 -0400", hash_original_method = "CF29F8673A9FD20E39B97C12C8CE0496", hash_generated_method = "3D67D361C55DCD4F2428AB5E3719CA93")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1993975420 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1993975420;
        // ---------- Original Method ----------
        //return enabled && applicationInfo.enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.059 -0400", hash_original_method = "39BF66743A5A058B0728A86B3B731327", hash_generated_method = "92785511C78F4542F81E6A81C7679244")
    public final int getIconResource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581505321 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1581505321;
        // ---------- Original Method ----------
        //return icon != 0 ? icon : applicationInfo.icon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.059 -0400", hash_original_method = "C34E4D575D4D3E32714E222B7945E44B", hash_generated_method = "F2EE856A4F42D3DEAA058DA1E348B80E")
    protected void dumpFront(Printer pw, String prefix) {
        super.dumpFront(pw, prefix);
        pw.println(prefix + "enabled=" + enabled + " exported=" + exported
                + " processName=" + processName);
        {
            pw.println(prefix + "description=" + descriptionRes);
        } //End block
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //super.dumpFront(pw, prefix);
        //pw.println(prefix + "enabled=" + enabled + " exported=" + exported
                //+ " processName=" + processName);
        //if (descriptionRes != 0) {
            //pw.println(prefix + "description=" + descriptionRes);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.060 -0400", hash_original_method = "A2A63684817A6733D86C3069C8C4DE2F", hash_generated_method = "E497958C0390DD1B130292F56C2FD347")
    protected void dumpBack(Printer pw, String prefix) {
        {
            pw.println(prefix + "ApplicationInfo:");
            applicationInfo.dump(pw, prefix + "  ");
        } //End block
        {
            pw.println(prefix + "ApplicationInfo: null");
        } //End block
        super.dumpBack(pw, prefix);
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        //if (applicationInfo != null) {
            //pw.println(prefix + "ApplicationInfo:");
            //applicationInfo.dump(pw, prefix + "  ");
        //} else {
            //pw.println(prefix + "ApplicationInfo: null");
        //}
        //super.dumpBack(pw, prefix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.060 -0400", hash_original_method = "7785077CB57413EF53E49F7AC7F9E06F", hash_generated_method = "94B0D6FC715DBDE0EF185B3D096879E6")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        super.writeToParcel(dest, parcelableFlags);
        applicationInfo.writeToParcel(dest, parcelableFlags);
        dest.writeString(processName);
        dest.writeInt(descriptionRes);
        dest.writeInt(enabled ? 1 : 0);
        dest.writeInt(exported ? 1 : 0);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //applicationInfo.writeToParcel(dest, parcelableFlags);
        //dest.writeString(processName);
        //dest.writeInt(descriptionRes);
        //dest.writeInt(enabled ? 1 : 0);
        //dest.writeInt(exported ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.061 -0400", hash_original_method = "584CAA069A59D426001F803F7AD39AAD", hash_generated_method = "22236EF44C0F873034B6E9768D93BA96")
    @Override
    protected Drawable loadDefaultIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_473664724 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_473664724 = applicationInfo.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_473664724.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_473664724;
        // ---------- Original Method ----------
        //return applicationInfo.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.062 -0400", hash_original_method = "E27DEF2367944E00B3FB42CCCCC00CEB", hash_generated_method = "92E2179D2D858DD3DB8FF213A0D6494F")
    @Override
    protected Drawable loadDefaultLogo(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1544653475 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1544653475 = applicationInfo.loadLogo(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1544653475.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1544653475;
        // ---------- Original Method ----------
        //return applicationInfo.loadLogo(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.062 -0400", hash_original_method = "6586F246687FA42890C123804417F38B", hash_generated_method = "406CB90F4FC74735F6A5B4F9B4D23067")
    @Override
    protected ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_552104571 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_552104571 = applicationInfo;
        varB4EAC82CA7396A68D541C85D26508E83_552104571.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_552104571;
        // ---------- Original Method ----------
        //return applicationInfo;
    }

    
}

