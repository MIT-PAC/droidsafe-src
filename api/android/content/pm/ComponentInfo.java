package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.util.Printer;

public class ComponentInfo extends PackageItemInfo {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.362 -0400", hash_original_field = "15CA13E1529EAD87820F354B3BC6598E", hash_generated_field = "89C41A1178051ADE4F3D6AE74553DD49")

    public ApplicationInfo applicationInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.362 -0400", hash_original_field = "50C4156E3E05C51B1D001342A3851767", hash_generated_field = "67B21D0A5FF988F85982C8AD74E67FFF")

    public String processName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.362 -0400", hash_original_field = "392A6E47A749448B7E51283719BBB183", hash_generated_field = "7C42762252277BD13653A4A0CE44470E")

    public int descriptionRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.363 -0400", hash_original_field = "34CF7D88530CECE9FD068A5118796419", hash_generated_field = "1F483398D0B87CDABAB06F6BA44B73E7")

    public boolean enabled = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.363 -0400", hash_original_field = "07A335FC29B9F4E240CFA508D409FE2F", hash_generated_field = "30B6E49162C4492B8B607024F789E7B8")

    public boolean exported = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.363 -0400", hash_original_method = "40B8C3B7DAB12BDDED651BA5685CD836", hash_generated_method = "6F61DA8191C6FB3294C15407326E1E92")
    public  ComponentInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.365 -0400", hash_original_method = "B9EA4C4630C52812153A03C2146AF2BB", hash_generated_method = "F31039CC77FC235E716B402EC5E1D440")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.366 -0400", hash_original_method = "4EE83CF183C8886AFEBB107F6033AC9F", hash_generated_method = "03F5458FA1F9A5EA5459FC8909E69005")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.368 -0400", hash_original_method = "19CED443F16784258FF178C9AF81CAC8", hash_generated_method = "626E61432523E0E69F8E89C2FB638002")
    @Override
    public CharSequence loadLabel(PackageManager pm) {
        addTaint(pm.getTaint());
        if(nonLocalizedLabel != null)        
        {
CharSequence varBE906C9C8D8F58EFBFC8C81E44574921_2026524802 =             nonLocalizedLabel;
            varBE906C9C8D8F58EFBFC8C81E44574921_2026524802.addTaint(taint);
            return varBE906C9C8D8F58EFBFC8C81E44574921_2026524802;
        } //End block
        ApplicationInfo ai = applicationInfo;
        CharSequence label;
        if(labelRes != 0)        
        {
            label = pm.getText(packageName, labelRes, ai);
            if(label != null)            
            {
CharSequence var057F26F90053C562EFC08298AB91C2B1_1944837855 =                 label;
                var057F26F90053C562EFC08298AB91C2B1_1944837855.addTaint(taint);
                return var057F26F90053C562EFC08298AB91C2B1_1944837855;
            } //End block
        } //End block
        if(ai.nonLocalizedLabel != null)        
        {
CharSequence var14E4600E3A08FF1589E9D63C81887B5B_1552874743 =             ai.nonLocalizedLabel;
            var14E4600E3A08FF1589E9D63C81887B5B_1552874743.addTaint(taint);
            return var14E4600E3A08FF1589E9D63C81887B5B_1552874743;
        } //End block
        if(ai.labelRes != 0)        
        {
            label = pm.getText(packageName, ai.labelRes, ai);
            if(label != null)            
            {
CharSequence var057F26F90053C562EFC08298AB91C2B1_1183994224 =                 label;
                var057F26F90053C562EFC08298AB91C2B1_1183994224.addTaint(taint);
                return var057F26F90053C562EFC08298AB91C2B1_1183994224;
            } //End block
        } //End block
CharSequence varB017984728AC60AD1F0BF8734F33F15C_1552982801 =         name;
        varB017984728AC60AD1F0BF8734F33F15C_1552982801.addTaint(taint);
        return varB017984728AC60AD1F0BF8734F33F15C_1552982801;
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.369 -0400", hash_original_method = "CF29F8673A9FD20E39B97C12C8CE0496", hash_generated_method = "CF2724490D4C3B12F772A7E9BEC1B4DC")
    public boolean isEnabled() {
        boolean var13504F8DD01CAF7C3049B4351A32E559_1164920588 = (enabled && applicationInfo.enabled);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1499241602 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1499241602;
        // ---------- Original Method ----------
        //return enabled && applicationInfo.enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.370 -0400", hash_original_method = "39BF66743A5A058B0728A86B3B731327", hash_generated_method = "2F21BDAEEBF441D094CB39D9C56B3981")
    public final int getIconResource() {
        int var1D77D0584D3218E1C5EC6AB79C77BE38_562903784 = (icon != 0 ? icon : applicationInfo.icon);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871781036 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1871781036;
        // ---------- Original Method ----------
        //return icon != 0 ? icon : applicationInfo.icon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.370 -0400", hash_original_method = "C34E4D575D4D3E32714E222B7945E44B", hash_generated_method = "52A7D446E6F90E8900391018CE9DBD3F")
    protected void dumpFront(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        super.dumpFront(pw, prefix);
        pw.println(prefix + "enabled=" + enabled + " exported=" + exported
                + " processName=" + processName);
        if(descriptionRes != 0)        
        {
            pw.println(prefix + "description=" + descriptionRes);
        } //End block
        // ---------- Original Method ----------
        //super.dumpFront(pw, prefix);
        //pw.println(prefix + "enabled=" + enabled + " exported=" + exported
                //+ " processName=" + processName);
        //if (descriptionRes != 0) {
            //pw.println(prefix + "description=" + descriptionRes);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.371 -0400", hash_original_method = "A2A63684817A6733D86C3069C8C4DE2F", hash_generated_method = "37401DD33C269E884B6B88568ECBD21D")
    protected void dumpBack(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        if(applicationInfo != null)        
        {
            pw.println(prefix + "ApplicationInfo:");
            applicationInfo.dump(pw, prefix + "  ");
        } //End block
        else
        {
            pw.println(prefix + "ApplicationInfo: null");
        } //End block
        super.dumpBack(pw, prefix);
        // ---------- Original Method ----------
        //if (applicationInfo != null) {
            //pw.println(prefix + "ApplicationInfo:");
            //applicationInfo.dump(pw, prefix + "  ");
        //} else {
            //pw.println(prefix + "ApplicationInfo: null");
        //}
        //super.dumpBack(pw, prefix);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.372 -0400", hash_original_method = "7785077CB57413EF53E49F7AC7F9E06F", hash_generated_method = "049A902EDC3FC26ED84927591A344F5D")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
        super.writeToParcel(dest, parcelableFlags);
        applicationInfo.writeToParcel(dest, parcelableFlags);
        dest.writeString(processName);
        dest.writeInt(descriptionRes);
        dest.writeInt(enabled ? 1 : 0);
        dest.writeInt(exported ? 1 : 0);
        // ---------- Original Method ----------
        //super.writeToParcel(dest, parcelableFlags);
        //applicationInfo.writeToParcel(dest, parcelableFlags);
        //dest.writeString(processName);
        //dest.writeInt(descriptionRes);
        //dest.writeInt(enabled ? 1 : 0);
        //dest.writeInt(exported ? 1 : 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.373 -0400", hash_original_method = "584CAA069A59D426001F803F7AD39AAD", hash_generated_method = "735BFD7B8DB7B2140D5DA96B5B9DB089")
    @Override
    protected Drawable loadDefaultIcon(PackageManager pm) {
        addTaint(pm.getTaint());
Drawable varC09D9974726D0718A5F07B870A506296_1184767004 =         applicationInfo.loadIcon(pm);
        varC09D9974726D0718A5F07B870A506296_1184767004.addTaint(taint);
        return varC09D9974726D0718A5F07B870A506296_1184767004;
        // ---------- Original Method ----------
        //return applicationInfo.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.373 -0400", hash_original_method = "E27DEF2367944E00B3FB42CCCCC00CEB", hash_generated_method = "9EB19445B17534A92847E076FCB7B696")
    @Override
    protected Drawable loadDefaultLogo(PackageManager pm) {
        addTaint(pm.getTaint());
Drawable varC6423699DBFD54FBC0A4ED249151ECE7_868942523 =         applicationInfo.loadLogo(pm);
        varC6423699DBFD54FBC0A4ED249151ECE7_868942523.addTaint(taint);
        return varC6423699DBFD54FBC0A4ED249151ECE7_868942523;
        // ---------- Original Method ----------
        //return applicationInfo.loadLogo(pm);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:03.373 -0400", hash_original_method = "6586F246687FA42890C123804417F38B", hash_generated_method = "3ABB8B9E9A9FE7B74A2EB54996B077B1")
    @Override
    protected ApplicationInfo getApplicationInfo() {
ApplicationInfo varAA697B7AEC424C4AC924FDECC5F85C19_441848167 =         applicationInfo;
        varAA697B7AEC424C4AC924FDECC5F85C19_441848167.addTaint(taint);
        return varAA697B7AEC424C4AC924FDECC5F85C19_441848167;
        // ---------- Original Method ----------
        //return applicationInfo;
    }

    
}

