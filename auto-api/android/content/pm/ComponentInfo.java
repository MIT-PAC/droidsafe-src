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
    public ApplicationInfo applicationInfo;
    public String processName;
    public int descriptionRes;
    public boolean enabled = true;
    public boolean exported = false;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.701 -0400", hash_original_method = "40B8C3B7DAB12BDDED651BA5685CD836", hash_generated_method = "6F61DA8191C6FB3294C15407326E1E92")
    @DSModeled(DSC.SAFE)
    public ComponentInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.701 -0400", hash_original_method = "B9EA4C4630C52812153A03C2146AF2BB", hash_generated_method = "6D1AB8E9B69536EF8784D1C0B631D6FD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ComponentInfo(ComponentInfo orig) {
        super(orig);
        dsTaint.addTaint(orig.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.701 -0400", hash_original_method = "4EE83CF183C8886AFEBB107F6033AC9F", hash_generated_method = "0C6521241727846AC340A92ECAB1B80E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected ComponentInfo(Parcel source) {
        super(source);
        dsTaint.addTaint(source.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.702 -0400", hash_original_method = "19CED443F16784258FF178C9AF81CAC8", hash_generated_method = "23F9652C374E62FA3CAD843EAD9CDC9E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public CharSequence loadLabel(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        ApplicationInfo ai;
        ai = applicationInfo;
        CharSequence label;
        {
            label = pm.getText(packageName, labelRes, ai);
        } //End block
        {
            label = pm.getText(packageName, ai.labelRes, ai);
        } //End block
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.702 -0400", hash_original_method = "CF29F8673A9FD20E39B97C12C8CE0496", hash_generated_method = "281F95C49E308459CDDE09753F760701")
    @DSModeled(DSC.SAFE)
    public boolean isEnabled() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return enabled && applicationInfo.enabled;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.702 -0400", hash_original_method = "39BF66743A5A058B0728A86B3B731327", hash_generated_method = "00FE687F30113DE1F544BB0C79BC431F")
    @DSModeled(DSC.SAFE)
    public final int getIconResource() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return icon != 0 ? icon : applicationInfo.icon;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.703 -0400", hash_original_method = "C34E4D575D4D3E32714E222B7945E44B", hash_generated_method = "B15FD1F7301FFA73F4B3B76A1EC29BEE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dumpFront(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        super.dumpFront(pw, prefix);
        pw.println(prefix + "enabled=" + enabled + " exported=" + exported
                + " processName=" + processName);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.703 -0400", hash_original_method = "A2A63684817A6733D86C3069C8C4DE2F", hash_generated_method = "0C6FA3B8FE336BB659F4628161FE8EC8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dumpBack(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        {
            pw.println(prefix + "ApplicationInfo:");
            applicationInfo.dump(pw, prefix + "  ");
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.703 -0400", hash_original_method = "7785077CB57413EF53E49F7AC7F9E06F", hash_generated_method = "58D0EA06ACC65C78C53BE06E07232E4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.703 -0400", hash_original_method = "584CAA069A59D426001F803F7AD39AAD", hash_generated_method = "A964FF39BCE20FE393F10467675408D3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Drawable loadDefaultIcon(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        Drawable var8EB38846611D6ED1D5E995C26BF5C028_1771734504 = (applicationInfo.loadIcon(pm));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return applicationInfo.loadIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.704 -0400", hash_original_method = "E27DEF2367944E00B3FB42CCCCC00CEB", hash_generated_method = "225CB09028D4C613CA35095E83FA8DE6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected Drawable loadDefaultLogo(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        Drawable varEE57CDE8FA1BEE03314C585F486F9C16_1357756913 = (applicationInfo.loadLogo(pm));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return applicationInfo.loadLogo(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:43.704 -0400", hash_original_method = "6586F246687FA42890C123804417F38B", hash_generated_method = "EE5FA5D4BA16608FB27B1AC6532DF6A0")
    @DSModeled(DSC.SAFE)
    @Override
    protected ApplicationInfo getApplicationInfo() {
        return (ApplicationInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return applicationInfo;
    }

    
}

