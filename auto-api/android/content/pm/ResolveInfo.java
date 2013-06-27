package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

public class ResolveInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.128 -0400", hash_original_field = "D189E59358BD9D02DDCA24FC5ED15564", hash_generated_field = "FCA2A130861F7E80B0DB4D7C0D3F6C7C")

    public ActivityInfo activityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.128 -0400", hash_original_field = "3F2E979E1975888EE11D3A07AD851781", hash_generated_field = "8A9FCE2913AD168B1F16362320563799")

    public ServiceInfo serviceInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.128 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "FC5A6BB8CDC12E61FC38F3539A900F50")

    public IntentFilter filter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.129 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

    public int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.129 -0400", hash_original_field = "523BF488C23258C50382C9FC4A33463E", hash_generated_field = "CC2809918299E4A2861E7C50D76F09CD")

    public int preferredOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.129 -0400", hash_original_field = "E3CC92C14A5E6DD1A7D94B6FF634D7FC", hash_generated_field = "69002FAD26F29F956AB6551745577EC8")

    public int match;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.129 -0400", hash_original_field = "7ADB8F3553FF0211E87EA9FC9269B4AF", hash_generated_field = "B0695D23967AED8DE288087FB5582005")

    public int specificIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.129 -0400", hash_original_field = "E558E63F3083922542D8745224A66EEA", hash_generated_field = "0D9B319BE2E837F574E088E42B45ECAA")

    public boolean isDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.129 -0400", hash_original_field = "8F580A9F881BD5248ABCF6CA4C789B48", hash_generated_field = "5CCBCEA64151325A8B45AD50EEEC958F")

    public int labelRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.129 -0400", hash_original_field = "C217EC6D87004328FDE9713C8BDFACF1", hash_generated_field = "EEEEA3B26D8CB06153CCE64BF10C94B7")

    public CharSequence nonLocalizedLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.129 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.130 -0400", hash_original_field = "746B34F4CCCD992C890FF9632ACC49F3", hash_generated_field = "5DA56F7664A4B97B3B98FFC1A1281F6E")

    public String resolvePackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.130 -0400", hash_original_field = "54B53072540EEEB8F8E9343E71F28176", hash_generated_field = "D1DBA00001B7F415431AD6FCAB5BAA5D")

    public boolean system;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.130 -0400", hash_original_method = "C76263445BA130B9E024AB7275119550", hash_generated_method = "9AD240A988A931517E58A7D3FB28D552")
    public  ResolveInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.163 -0400", hash_original_method = "D76D30C905C95224DB17E633EB6195C1", hash_generated_method = "60C8E8EC23753267AAE9F6FAA69472E7")
    private  ResolveInfo(Parcel source) {
        {
            Object var533A8C7CD58A93D322295C6F0E68EC88_496766184 = (source.readInt());
            //Begin case 1 
            activityInfo = ActivityInfo.CREATOR.createFromParcel(source);
            //End case 1 
            //Begin case 1 
            serviceInfo = null;
            //End case 1 
            //Begin case 2 
            serviceInfo = ServiceInfo.CREATOR.createFromParcel(source);
            //End case 2 
            //Begin case 2 
            activityInfo = null;
            //End case 2 
            //Begin case default 
            activityInfo = null;
            //End case default 
            //Begin case default 
            serviceInfo = null;
            //End case default 
        } //End collapsed parenthetic
        {
            boolean varFD16828A378FD83700BE97539951F787_814455516 = (source.readInt() != 0);
            {
                filter = IntentFilter.CREATOR.createFromParcel(source);
            } //End block
        } //End collapsed parenthetic
        priority = source.readInt();
        preferredOrder = source.readInt();
        match = source.readInt();
        specificIndex = source.readInt();
        labelRes = source.readInt();
        nonLocalizedLabel
                = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        icon = source.readInt();
        resolvePackageName = source.readString();
        system = source.readInt() != 0;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.187 -0400", hash_original_method = "A33400D9D27D1859CAE2B97E545C2635", hash_generated_method = "B4561B96C6B4B15151C825881C2FE9B8")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1154481023 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1960689055 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2085244066 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1353567733 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1154481023 = nonLocalizedLabel;
        } //End block
        CharSequence label;
        {
            label = pm.getText(resolvePackageName, labelRes, null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1960689055 = label.toString().trim();
            } //End block
        } //End block
        ComponentInfo ci;
        ci = activityInfo;
        ci = serviceInfo;
        ApplicationInfo ai;
        ai = ci.applicationInfo;
        {
            label = pm.getText(ci.packageName, labelRes, ai);
            {
                varB4EAC82CA7396A68D541C85D26508E83_2085244066 = label.toString().trim();
            } //End block
        } //End block
        CharSequence data;
        data = ci.loadLabel(pm);
        data = data.toString().trim();
        varB4EAC82CA7396A68D541C85D26508E83_1353567733 = data;
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1693151941; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1693151941 = varB4EAC82CA7396A68D541C85D26508E83_1154481023;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1693151941 = varB4EAC82CA7396A68D541C85D26508E83_1960689055;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1693151941 = varB4EAC82CA7396A68D541C85D26508E83_2085244066;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1693151941 = varB4EAC82CA7396A68D541C85D26508E83_1353567733;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1693151941.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1693151941;
        // ---------- Original Method ----------
        //if (nonLocalizedLabel != null) {
            //return nonLocalizedLabel;
        //}
        //CharSequence label;
        //if (resolvePackageName != null && labelRes != 0) {
            //label = pm.getText(resolvePackageName, labelRes, null);
            //if (label != null) {
                //return label.toString().trim();
            //}
        //}
        //ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        //ApplicationInfo ai = ci.applicationInfo;
        //if (labelRes != 0) {
            //label = pm.getText(ci.packageName, labelRes, ai);
            //if (label != null) {
                //return label.toString().trim();
            //}
        //}
        //CharSequence data = ci.loadLabel(pm);
        //if (data != null) data = data.toString().trim();
        //return data;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.209 -0400", hash_original_method = "D0D8D8B431D77A14F0DBD9F876D36006", hash_generated_method = "58113C7D877F904783FCF4DF76EFB1B2")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_608275542 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1453979312 = null; //Variable for return #2
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1905296517 = null; //Variable for return #3
        Drawable dr;
        {
            dr = pm.getDrawable(resolvePackageName, icon, null);
            {
                varB4EAC82CA7396A68D541C85D26508E83_608275542 = dr;
            } //End block
        } //End block
        ComponentInfo ci;
        ci = activityInfo;
        ci = serviceInfo;
        ApplicationInfo ai;
        ai = ci.applicationInfo;
        {
            dr = pm.getDrawable(ci.packageName, icon, ai);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1453979312 = dr;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1905296517 = ci.loadIcon(pm);
        addTaint(pm.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_121424703; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_121424703 = varB4EAC82CA7396A68D541C85D26508E83_608275542;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_121424703 = varB4EAC82CA7396A68D541C85D26508E83_1453979312;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_121424703 = varB4EAC82CA7396A68D541C85D26508E83_1905296517;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_121424703.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_121424703;
        // ---------- Original Method ----------
        //Drawable dr;
        //if (resolvePackageName != null && icon != 0) {
            //dr = pm.getDrawable(resolvePackageName, icon, null);
            //if (dr != null) {
                //return dr;
            //}
        //}
        //ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        //ApplicationInfo ai = ci.applicationInfo;
        //if (icon != 0) {
            //dr = pm.getDrawable(ci.packageName, icon, ai);
            //if (dr != null) {
                //return dr;
            //}
        //}
        //return ci.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.211 -0400", hash_original_method = "A025A0B4AEE2574644D8C11C73D3261F", hash_generated_method = "CCEC78D94B6818BE518465BA3D52F2E1")
    public final int getIconResource() {
        int varE23691F8C29AA1D26CC5ADD64E261A55_1758798187 = (activityInfo.getIconResource());
        int varFF6CF132766102E71E463F8C1A0179F1_1971428461 = (serviceInfo.getIconResource());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487190761 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_487190761;
        // ---------- Original Method ----------
        //if (icon != 0) return icon;
        //if (activityInfo != null) return activityInfo.getIconResource();
        //if (serviceInfo != null) return serviceInfo.getIconResource();
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.230 -0400", hash_original_method = "64245509A5FC137877FB50AC88C4351E", hash_generated_method = "570C727D27D0B555E978349344B8654D")
    public void dump(Printer pw, String prefix) {
        {
            pw.println(prefix + "Filter:");
            filter.dump(pw, prefix + "  ");
        } //End block
        pw.println(prefix + "priority=" + priority
                + " preferredOrder=" + preferredOrder
                + " match=0x" + Integer.toHexString(match)
                + " specificIndex=" + specificIndex
                + " isDefault=" + isDefault);
        {
            pw.println(prefix + "resolvePackageName=" + resolvePackageName);
        } //End block
        {
            pw.println(prefix + "labelRes=0x" + Integer.toHexString(labelRes)
                    + " nonLocalizedLabel=" + nonLocalizedLabel
                    + " icon=0x" + Integer.toHexString(icon));
        } //End block
        {
            pw.println(prefix + "ActivityInfo:");
            activityInfo.dump(pw, prefix + "  ");
        } //End block
        {
            pw.println(prefix + "ServiceInfo:");
            serviceInfo.dump(pw, prefix + "  ");
        } //End block
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.240 -0400", hash_original_method = "E9277D5F5F8618A42CE604147E3605E2", hash_generated_method = "D7CA8DF1514CC32524CE538B0E658A90")
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_1075912180 = null; //Variable for return #1
        ComponentInfo ci;
        ci = activityInfo;
        ci = serviceInfo;
        varB4EAC82CA7396A68D541C85D26508E83_1075912180 = "ResolveInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + ci.name + " p=" + priority + " o="
            + preferredOrder + " m=0x" + Integer.toHexString(match) + "}";
        varB4EAC82CA7396A68D541C85D26508E83_1075912180.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1075912180;
        // ---------- Original Method ----------
        //ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        //return "ResolveInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + ci.name + " p=" + priority + " o="
            //+ preferredOrder + " m=0x" + Integer.toHexString(match) + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.247 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "01FAE7403D584FBA296149E58AF8EFA4")
    public int describeContents() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665546107 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1665546107;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.281 -0400", hash_original_method = "C265C7C58C207232A576E6DBECFC3E71", hash_generated_method = "E00F068A39C25E4784CF2AE6C18244E3")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        {
            dest.writeInt(1);
            activityInfo.writeToParcel(dest, parcelableFlags);
        } //End block
        {
            dest.writeInt(2);
            serviceInfo.writeToParcel(dest, parcelableFlags);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        {
            dest.writeInt(1);
            filter.writeToParcel(dest, parcelableFlags);
        } //End block
        {
            dest.writeInt(0);
        } //End block
        dest.writeInt(priority);
        dest.writeInt(preferredOrder);
        dest.writeInt(match);
        dest.writeInt(specificIndex);
        dest.writeInt(labelRes);
        TextUtils.writeToParcel(nonLocalizedLabel, dest, parcelableFlags);
        dest.writeInt(icon);
        dest.writeString(resolvePackageName);
        dest.writeInt(system ? 1 : 0);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class DisplayNameComparator implements Comparator<ResolveInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.281 -0400", hash_original_field = "8535BFF02E263AB07820336F2B6CBE9E", hash_generated_field = "58991AE2EDDF0E27B2F7FBCBF97D013F")

        private Collator sCollator = Collator.getInstance();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.282 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "B9590FAB3CF140F08C9CD4E0309ED58A")

        private PackageManager mPM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.283 -0400", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "00B9637435B2DF20319BD9D174F2475F")
        public  DisplayNameComparator(PackageManager pm) {
            mPM = pm;
            // ---------- Original Method ----------
            //mPM = pm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.284 -0400", hash_original_method = "75BF6E8997D323222280B816426CA9D8", hash_generated_method = "BF5813044A1BD676948D1736018F6675")
        public final int compare(ResolveInfo a, ResolveInfo b) {
            CharSequence sa;
            sa = a.loadLabel(mPM);
            sa = a.activityInfo.name;
            CharSequence sb;
            sb = b.loadLabel(mPM);
            sb = b.activityInfo.name;
            int var84BDFD4BCC4C054E649C7A0FEE1F21B0_886942324 = (sCollator.compare(sa.toString(), sb.toString()));
            addTaint(a.getTaint());
            addTaint(b.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668867789 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_668867789;
            // ---------- Original Method ----------
            //CharSequence  sa = a.loadLabel(mPM);
            //if (sa == null) sa = a.activityInfo.name;
            //CharSequence  sb = b.loadLabel(mPM);
            //if (sb == null) sb = b.activityInfo.name;
            //return sCollator.compare(sa.toString(), sb.toString());
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:37:06.285 -0400", hash_original_field = "C8E3508AADB06B7F78F470F3288D5470", hash_generated_field = "699B00262ABFFA011EC34065A2FBCAFD")

    public static final Creator<ResolveInfo> CREATOR
            = new Creator<ResolveInfo>() {
        public ResolveInfo createFromParcel(Parcel source) {
            return new ResolveInfo(source);
        }
        public ResolveInfo[] newArray(int size) {
            return new ResolveInfo[size];
        }
    };
}

