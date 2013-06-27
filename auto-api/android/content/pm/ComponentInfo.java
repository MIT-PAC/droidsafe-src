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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.508 -0400", hash_original_field = "15CA13E1529EAD87820F354B3BC6598E", hash_generated_field = "89C41A1178051ADE4F3D6AE74553DD49")

    public ApplicationInfo applicationInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.508 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

    public String processName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.508 -0400", hash_original_field = "392A6E47A749448B7E51283719BBB183", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.509 -0400", hash_original_field = "34CF7D88530CECE9FD068A5118796419", hash_generated_field = "1F483398D0B87CDABAB06F6BA44B73E7")

    public boolean enabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.517 -0400", hash_original_field = "07A335FC29B9F4E240CFA508D409FE2F", hash_generated_field = "30B6E49162C4492B8B607024F789E7B8")

    public boolean exported = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.517 -0400", hash_original_method = "40B8C3B7DAB12BDDED651BA5685CD836", hash_generated_method = "6F61DA8191C6FB3294C15407326E1E92")
    public  ComponentInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.518 -0400", hash_original_method = "B9EA4C4630C52812153A03C2146AF2BB", hash_generated_method = "F31039CC77FC235E716B402EC5E1D440")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.537 -0400", hash_original_method = "4EE83CF183C8886AFEBB107F6033AC9F", hash_generated_method = "03F5458FA1F9A5EA5459FC8909E69005")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.558 -0400", hash_original_method = "19CED443F16784258FF178C9AF81CAC8", hash_generated_method = "F982EAED7C6382A3BB006DC658FB3C31")
    @Override
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1383788889 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_976953093 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1845038683 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_523908068 = null; //Variable for return #4
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_146047622 = null; //Variable for return #5
        {
            varB4EAC82CA7396A68D541C85D26508E83_1383788889 = nonLocalizedLabel;
        } //End block
        ApplicationInfo ai;
        ai = applicationInfo;
        CharSequence label;
        {
            label = pm.getText(packageName, labelRes, ai);
            {
                varB4EAC82CA7396A68D541C85D26508E83_976953093 = label;
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_1845038683 = ai.nonLocalizedLabel;
        } //End block
        {
            label = pm.getText(packageName, ai.labelRes, ai);
            {
                varB4EAC82CA7396A68D541C85D26508E83_523908068 = label;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_146047622 = name;
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1789031391; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1789031391 = varB4EAC82CA7396A68D541C85D26508E83_1383788889;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1789031391 = varB4EAC82CA7396A68D541C85D26508E83_976953093;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1789031391 = varB4EAC82CA7396A68D541C85D26508E83_1845038683;
                break;
            case 4: //Assign result for return ordinal #4
                varA7E53CE21691AB073D9660D615818899_1789031391 = varB4EAC82CA7396A68D541C85D26508E83_523908068;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1789031391 = varB4EAC82CA7396A68D541C85D26508E83_146047622;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1789031391.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1789031391;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.559 -0400", hash_original_method = "CF29F8673A9FD20E39B97C12C8CE0496", hash_generated_method = "E45D55BA3649D297A122C8BCE983C260")
    public boolean isEnabled() {
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_659104995 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_659104995;
        // ---------- Original Method ----------
        //return enabled && applicationInfo.enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.559 -0400", hash_original_method = "39BF66743A5A058B0728A86B3B731327", hash_generated_method = "65863510A3D5AB52EACF0BD1ABEC9F4D")
    public final int getIconResource() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1201256978 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1201256978;
        // ---------- Original Method ----------
        //return icon != 0 ? icon : applicationInfo.icon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.581 -0400", hash_original_method = "C34E4D575D4D3E32714E222B7945E44B", hash_generated_method = "F2EE856A4F42D3DEAA058DA1E348B80E")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.582 -0400", hash_original_method = "A2A63684817A6733D86C3069C8C4DE2F", hash_generated_method = "E497958C0390DD1B130292F56C2FD347")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.600 -0400", hash_original_method = "7785077CB57413EF53E49F7AC7F9E06F", hash_generated_method = "94B0D6FC715DBDE0EF185B3D096879E6")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.604 -0400", hash_original_method = "584CAA069A59D426001F803F7AD39AAD", hash_generated_method = "D2D07B96CA428859C75006803159CCA9")
    @Override
    protected Drawable loadDefaultIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1934735481 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1934735481 = applicationInfo.loadIcon(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1934735481.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1934735481;
        // ---------- Original Method ----------
        //return applicationInfo.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.608 -0400", hash_original_method = "E27DEF2367944E00B3FB42CCCCC00CEB", hash_generated_method = "BE06C1FAA7F186081C1C59D6E3630AFF")
    @Override
    protected Drawable loadDefaultLogo(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1369624161 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1369624161 = applicationInfo.loadLogo(pm);
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1369624161.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1369624161;
        // ---------- Original Method ----------
        //return applicationInfo.loadLogo(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:12:00.630 -0400", hash_original_method = "6586F246687FA42890C123804417F38B", hash_generated_method = "5CD0D578ACC9243C04BF1191AFD86EB8")
    @Override
    protected ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_345634412 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_345634412 = applicationInfo;
        varB4EAC82CA7396A68D541C85D26508E83_345634412.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_345634412;
        // ---------- Original Method ----------
        //return applicationInfo;
    }

    
}

