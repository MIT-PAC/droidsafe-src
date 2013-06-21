package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

public class PackageItemInfo {
    public String name;
    public String packageName;
    public int labelRes;
    public CharSequence nonLocalizedLabel;
    public int icon;
    public int logo;
    public Bundle metaData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.079 -0400", hash_original_method = "0DA45D98B1805BAB6DB37663419819EF", hash_generated_method = "A53952B9C896D4AF9B209F1D87FED0D1")
    @DSModeled(DSC.SAFE)
    public PackageItemInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.080 -0400", hash_original_method = "31AB547002878BF41C4DB5C45B98DB0F", hash_generated_method = "5AA9FEDAA4414D13931BB93CE8B307D7")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public PackageItemInfo(PackageItemInfo orig) {
        dsTaint.addTaint(orig.dsTaint);
        name = orig.name;
        name = name.trim();
        packageName = orig.packageName;
        labelRes = orig.labelRes;
        nonLocalizedLabel = orig.nonLocalizedLabel;
        nonLocalizedLabel = nonLocalizedLabel.toString().trim();
        icon = orig.icon;
        logo = orig.logo;
        metaData = orig.metaData;
        // ---------- Original Method ----------
        //name = orig.name;
        //if (name != null) name = name.trim();
        //packageName = orig.packageName;
        //labelRes = orig.labelRes;
        //nonLocalizedLabel = orig.nonLocalizedLabel;
        //if (nonLocalizedLabel != null) nonLocalizedLabel = nonLocalizedLabel.toString().trim();
        //icon = orig.icon;
        //logo = orig.logo;
        //metaData = orig.metaData;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.080 -0400", hash_original_method = "2EB380960A16EA21F3A081E2F7A7694B", hash_generated_method = "AC40175F6488B7587F37522ADCC01C98")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected PackageItemInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        name = source.readString();
        packageName = source.readString();
        labelRes = source.readInt();
        nonLocalizedLabel
                = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        icon = source.readInt();
        logo = source.readInt();
        metaData = source.readBundle();
        // ---------- Original Method ----------
        //name = source.readString();
        //packageName = source.readString();
        //labelRes = source.readInt();
        //nonLocalizedLabel
                //= TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        //icon = source.readInt();
        //logo = source.readInt();
        //metaData = source.readBundle();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.081 -0400", hash_original_method = "7587CF1BD2560A6C6F4B753C933F3AB0", hash_generated_method = "11C1FD8597A57A7A22916AD565D01474")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadLabel(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        {
            CharSequence label;
            label = pm.getText(packageName, labelRes, getApplicationInfo());
            {
                CharSequence var5756FBB88158B13A005DD5FF5D17599B_14619885 = (label.toString().trim());
            } //End block
        } //End block
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (nonLocalizedLabel != null) {
            //return nonLocalizedLabel;
        //}
        //if (labelRes != 0) {
            //CharSequence label = pm.getText(packageName, labelRes, getApplicationInfo());
            //if (label != null) {
                //return label.toString().trim();
            //}
        //}
        //if (name != null) {
            //return name;
        //}
        //return packageName;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.081 -0400", hash_original_method = "28CAE1EAC4906E828B7AB10B1D04EBA6", hash_generated_method = "378380D97F43A84FD980C2A705E9D2F0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable loadIcon(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        {
            Drawable dr;
            dr = pm.getDrawable(packageName, icon, getApplicationInfo());
        } //End block
        Drawable var7410BD4E60CF80A79ACA23C8D90F03F3_2082385176 = (loadDefaultIcon(pm));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (icon != 0) {
            //Drawable dr = pm.getDrawable(packageName, icon, getApplicationInfo());
            //if (dr != null) {
                //return dr;
            //}
        //}
        //return loadDefaultIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.081 -0400", hash_original_method = "8E0B311EF662738B18859A93F77EBD0A", hash_generated_method = "1E6557EDBE5CD354403778C4A422EDD5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected Drawable loadDefaultIcon(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        Drawable var0DE00E38B87CF4E9B9F8F8B0CA523BE3_1552442717 = (pm.getDefaultActivityIcon());
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return pm.getDefaultActivityIcon();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.082 -0400", hash_original_method = "E08D2EB4B7AA31EEDBDC94D57D687BA7", hash_generated_method = "2B8A9D5F3A2A5FED632DAED7B49DE346")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable loadLogo(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        {
            Drawable d;
            d = pm.getDrawable(packageName, logo, getApplicationInfo());
        } //End block
        Drawable var02EDF78292CAAA4025C3884D16694070_1137979237 = (loadDefaultLogo(pm));
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (logo != 0) {
            //Drawable d = pm.getDrawable(packageName, logo, getApplicationInfo());
            //if (d != null) {
                //return d;
            //}
        //}
        //return loadDefaultLogo(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.082 -0400", hash_original_method = "790329C099FCB9AD7C46A077CBE50219", hash_generated_method = "D25E86F8AA2EFC90C7B62C814A69C3AA")
    @DSModeled(DSC.SAFE)
    protected Drawable loadDefaultLogo(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        return (Drawable)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.082 -0400", hash_original_method = "3469F3AC66BE0248CB548730284A6983", hash_generated_method = "D5C58560D7D99BDAA296587A34FE648A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public XmlResourceParser loadXmlMetaData(PackageManager pm, String name) {
        dsTaint.addTaint(name);
        dsTaint.addTaint(pm.dsTaint);
        {
            int resid;
            resid = metaData.getInt(name);
            {
                XmlResourceParser varF5E224A1873DB6AD62E6DDD6EEB0FF64_1808557688 = (pm.getXml(packageName, resid, getApplicationInfo()));
            } //End block
        } //End block
        return (XmlResourceParser)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (metaData != null) {
            //int resid = metaData.getInt(name);
            //if (resid != 0) {
                //return pm.getXml(packageName, resid, getApplicationInfo());
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.083 -0400", hash_original_method = "6B8B2642A2B8BBF6D444F1A91AC9FDCB", hash_generated_method = "C924782325734E331FB9E512D9FDEB6F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dumpFront(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        {
            pw.println(prefix + "name=" + name);
        } //End block
        pw.println(prefix + "packageName=" + packageName);
        {
            pw.println(prefix + "labelRes=0x" + Integer.toHexString(labelRes)
                    + " nonLocalizedLabel=" + nonLocalizedLabel
                    + " icon=0x" + Integer.toHexString(icon));
        } //End block
        // ---------- Original Method ----------
        //if (name != null) {
            //pw.println(prefix + "name=" + name);
        //}
        //pw.println(prefix + "packageName=" + packageName);
        //if (labelRes != 0 || nonLocalizedLabel != null || icon != 0) {
            //pw.println(prefix + "labelRes=0x" + Integer.toHexString(labelRes)
                    //+ " nonLocalizedLabel=" + nonLocalizedLabel
                    //+ " icon=0x" + Integer.toHexString(icon));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.083 -0400", hash_original_method = "B7061250601C1EA92C43E5184BBC6241", hash_generated_method = "99A581C994C0F805DE2A9A7EF38446FF")
    @DSModeled(DSC.SAFE)
    protected void dumpBack(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.083 -0400", hash_original_method = "EBFCAD6F5CD0994BD82522BC30DB76DD", hash_generated_method = "E6F4316AADED463839828044FD48BA90")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
        dest.writeString(name);
        dest.writeString(packageName);
        dest.writeInt(labelRes);
        TextUtils.writeToParcel(nonLocalizedLabel, dest, parcelableFlags);
        dest.writeInt(icon);
        dest.writeInt(logo);
        dest.writeBundle(metaData);
        // ---------- Original Method ----------
        //dest.writeString(name);
        //dest.writeString(packageName);
        //dest.writeInt(labelRes);
        //TextUtils.writeToParcel(nonLocalizedLabel, dest, parcelableFlags);
        //dest.writeInt(icon);
        //dest.writeInt(logo);
        //dest.writeBundle(metaData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.084 -0400", hash_original_method = "3C095FBE28E1D0A5D79820831D5573F9", hash_generated_method = "79EFC11B0E86283C6ED73E358F4C0AD7")
    @DSModeled(DSC.SAFE)
    protected ApplicationInfo getApplicationInfo() {
        return (ApplicationInfo)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    public static class DisplayNameComparator implements Comparator<PackageItemInfo> {
        private Collator   sCollator = Collator.getInstance();
        private PackageManager   mPM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.084 -0400", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "AF5A9D42CCA5BEF178298CF4EA0D30B4")
        @DSModeled(DSC.SAFE)
        public DisplayNameComparator(PackageManager pm) {
            dsTaint.addTaint(pm.dsTaint);
            // ---------- Original Method ----------
            //mPM = pm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.084 -0400", hash_original_method = "2595E40DD10804FAA28D70201572BA0B", hash_generated_method = "EB1A87FA46B6AD4188CF8813A22061F9")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int compare(PackageItemInfo aa, PackageItemInfo ab) {
            dsTaint.addTaint(aa.dsTaint);
            dsTaint.addTaint(ab.dsTaint);
            CharSequence sa;
            sa = aa.loadLabel(mPM);
            sa = aa.name;
            CharSequence sb;
            sb = ab.loadLabel(mPM);
            sb = ab.name;
            int var84BDFD4BCC4C054E649C7A0FEE1F21B0_223960705 = (sCollator.compare(sa.toString(), sb.toString()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //CharSequence  sa = aa.loadLabel(mPM);
            //if (sa == null) sa = aa.name;
            //CharSequence  sb = ab.loadLabel(mPM);
            //if (sb == null) sb = ab.name;
            //return sCollator.compare(sa.toString(), sb.toString());
        }

        
    }


    
}

