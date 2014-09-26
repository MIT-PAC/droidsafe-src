package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.Collator;
import java.util.Comparator;

import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Printer;

public class PackageItemInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.304 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.306 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.308 -0500", hash_original_field = "72766807210949DB14E0A53D32EEFA42", hash_generated_field = "5CCBCEA64151325A8B45AD50EEEC958F")

    public int labelRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.310 -0500", hash_original_field = "E41FD8D985C7C7980A3E63475B8D976E", hash_generated_field = "EEEEA3B26D8CB06153CCE64BF10C94B7")

    public CharSequence nonLocalizedLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.312 -0500", hash_original_field = "107298D9FB7BD66B47A702264D3B04F5", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.315 -0500", hash_original_field = "40F1731F6DDC59241C091ACC1EFBC7B2", hash_generated_field = "922885A8A44FD4A4B2D8F0B49A2EDED6")

    public int logo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.317 -0500", hash_original_field = "28705BB70A2AE2760BB13E62CB7CCF68", hash_generated_field = "94B83340D21CBE8DE8F4A432223AA875")

    public Bundle metaData;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.319 -0500", hash_original_method = "0DA45D98B1805BAB6DB37663419819EF", hash_generated_method = "FA7F902D5212EFF50E51D00BC4A84214")
    
public PackageItemInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.322 -0500", hash_original_method = "31AB547002878BF41C4DB5C45B98DB0F", hash_generated_method = "8584BA5F0BEE6B869FCB42A2F7001824")
    
public PackageItemInfo(PackageItemInfo orig) {
        name = orig.name;
        if (name != null) name = name.trim();
        packageName = orig.packageName;
        labelRes = orig.labelRes;
        nonLocalizedLabel = orig.nonLocalizedLabel;
        if (nonLocalizedLabel != null) nonLocalizedLabel = nonLocalizedLabel.toString().trim();
        icon = orig.icon;
        logo = orig.logo;
        metaData = orig.metaData;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.344 -0500", hash_original_method = "2EB380960A16EA21F3A081E2F7A7694B", hash_generated_method = "126BA77B707EFB841D48D4AD94835B70")
    
protected PackageItemInfo(Parcel source) {
        name = source.readString();
        packageName = source.readString();
        labelRes = source.readInt();
        nonLocalizedLabel
                = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
        icon = source.readInt();
        logo = source.readInt();
        metaData = source.readBundle();
    }

    /**
     * Retrieve the current textual label associated with this item.  This
     * will call back on the given PackageManager to load the label from
     * the application.
     * 
     * @param pm A PackageManager from which the label can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     * 
     * @return Returns a CharSequence containing the item's label.  If the
     * item does not have a label, its name is returned.
     */
    @DSComment("information about package")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.324 -0500", hash_original_method = "7587CF1BD2560A6C6F4B753C933F3AB0", hash_generated_method = "F7142DA33E913DB7BEF3B8D354DCE8DC")
    
public CharSequence loadLabel(PackageManager pm) {
        if (nonLocalizedLabel != null) {
            return nonLocalizedLabel;
        }
        if (labelRes != 0) {
            CharSequence label = pm.getText(packageName, labelRes, getApplicationInfo());
            if (label != null) {
                return label.toString().trim();
            }
        }
        if (name != null) {
            return name;
        }
        return packageName;
    }
    
    /**
     * Retrieve the current graphical icon associated with this item.  This
     * will call back on the given PackageManager to load the icon from
     * the application.
     * 
     * @param pm A PackageManager from which the icon can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     * 
     * @return Returns a Drawable containing the item's icon.  If the
     * item does not have an icon, the item's default icon is returned
     * such as the default activity icon.
     */
    @DSComment("information about package")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.327 -0500", hash_original_method = "28CAE1EAC4906E828B7AB10B1D04EBA6", hash_generated_method = "EA73B7A27ACDD8CB3869132A9DA3CA2A")
    
public Drawable loadIcon(PackageManager pm) {
        if (icon != 0) {
            Drawable dr = pm.getDrawable(packageName, icon, getApplicationInfo());
            if (dr != null) {
                return dr;
            }
        }
        return loadDefaultIcon(pm);
    }
    
    /**
     * Retrieve the default graphical icon associated with this item.
     * 
     * @param pm A PackageManager from which the icon can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     * 
     * @return Returns a Drawable containing the item's default icon
     * such as the default activity icon.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.329 -0500", hash_original_method = "8E0B311EF662738B18859A93F77EBD0A", hash_generated_method = "7F3ABD94AC5707F2B693CA2A6A0497E8")
    
protected Drawable loadDefaultIcon(PackageManager pm) {
        return pm.getDefaultActivityIcon();
    }
    
    /**
     * Retrieve the current graphical logo associated with this item. This
     * will call back on the given PackageManager to load the logo from
     * the application.
     * 
     * @param pm A PackageManager from which the logo can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     * 
     * @return Returns a Drawable containing the item's logo. If the item
     * does not have a logo, this method will return null.
     */
    @DSComment("information about package")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.331 -0500", hash_original_method = "E08D2EB4B7AA31EEDBDC94D57D687BA7", hash_generated_method = "5E8227AADAE2C50C985BFE31AECFACB2")
    
public Drawable loadLogo(PackageManager pm) {
        if (logo != 0) {
            Drawable d = pm.getDrawable(packageName, logo, getApplicationInfo());
            if (d != null) {
                return d;
            }
        }
        return loadDefaultLogo(pm);
    }
    
    /**
     * Retrieve the default graphical logo associated with this item.
     * 
     * @param pm A PackageManager from which the logo can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     * 
     * @return Returns a Drawable containing the item's default logo
     * or null if no default logo is available.
     * 
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.333 -0500", hash_original_method = "790329C099FCB9AD7C46A077CBE50219", hash_generated_method = "2FAC081356342D0DF3F1550E489D8328")
    
protected Drawable loadDefaultLogo(PackageManager pm) {
        return null;
    }
    
    /**
     * Load an XML resource attached to the meta-data of this item.  This will
     * retrieved the name meta-data entry, and if defined call back on the
     * given PackageManager to load its XML file from the application.
     * 
     * @param pm A PackageManager from which the XML can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     * @param name Name of the meta-date you would like to load.
     * 
     * @return Returns an XmlPullParser you can use to parse the XML file
     * assigned as the given meta-data.  If the meta-data name is not defined
     * or the XML resource could not be found, null is returned.
     */
    @DSComment("information about package")
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.335 -0500", hash_original_method = "3469F3AC66BE0248CB548730284A6983", hash_generated_method = "2485624FC9F5EDA0944762D77FF0BA2E")
    
public XmlResourceParser loadXmlMetaData(PackageManager pm, String name) {
        if (metaData != null) {
            int resid = metaData.getInt(name);
            if (resid != 0) {
                return pm.getXml(packageName, resid, getApplicationInfo());
            }
        }
        return null;
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.337 -0500", hash_original_method = "6B8B2642A2B8BBF6D444F1A91AC9FDCB", hash_generated_method = "BF2CAC1FBFC42CCC0CE813D4DA6DE59E")
    
protected void dumpFront(Printer pw, String prefix) {
        if (name != null) {
            pw.println(prefix + "name=" + name);
        }
        pw.println(prefix + "packageName=" + packageName);
        if (labelRes != 0 || nonLocalizedLabel != null || icon != 0) {
            pw.println(prefix + "labelRes=0x" + Integer.toHexString(labelRes)
                    + " nonLocalizedLabel=" + nonLocalizedLabel
                    + " icon=0x" + Integer.toHexString(icon));
        }
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.339 -0500", hash_original_method = "B7061250601C1EA92C43E5184BBC6241", hash_generated_method = "10F0726956FC6EA401BAE896ACFFA0C2")
    
protected void dumpBack(Printer pw, String prefix) {
        // no back here
    }
    
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.342 -0500", hash_original_method = "EBFCAD6F5CD0994BD82522BC30DB76DD", hash_generated_method = "F240B07B8F98FF37957218BD5D9B3BD1")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeString(name);
        dest.writeString(packageName);
        dest.writeInt(labelRes);
        TextUtils.writeToParcel(nonLocalizedLabel, dest, parcelableFlags);
        dest.writeInt(icon);
        dest.writeInt(logo);
        dest.writeBundle(metaData);
    }

    /**
     * Get the ApplicationInfo for the application to which this item belongs,
     * if available, otherwise returns null.
     * 
     * @return Returns the ApplicationInfo of this item, or null if not known.
     * 
     * @hide
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.347 -0500", hash_original_method = "3C095FBE28E1D0A5D79820831D5573F9", hash_generated_method = "F2E8493838D7C31F6FA4B5446F237F21")
    
protected ApplicationInfo getApplicationInfo() {
        return null;
    }
    
    public static class DisplayNameComparator implements Comparator<PackageItemInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.355 -0500", hash_original_field = "EE5E44F3B728B272AD02D50E8F128A4E", hash_generated_field = "0F522A2F9FEC0AE6C7C0EFB2E65868E6")

        private final Collator   sCollator = Collator.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.358 -0500", hash_original_field = "D7E1102720CC9E76648EB86B25CA5216", hash_generated_field = "B9590FAB3CF140F08C9CD4E0309ED58A")

        private PackageManager   mPM;
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.350 -0500", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "93A18F8F07DA31EBC88951995E1C514A")
        
public DisplayNameComparator(PackageManager pm) {
            mPM = pm;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:49.352 -0500", hash_original_method = "2595E40DD10804FAA28D70201572BA0B", hash_generated_method = "EC1D9AC66743F7F0831EDFDF3E7DDE60")
        
public final int compare(PackageItemInfo aa, PackageItemInfo ab) {
            CharSequence  sa = aa.loadLabel(mPM);
            if (sa == null) sa = aa.name;
            CharSequence  sb = ab.loadLabel(mPM);
            if (sb == null) sb = ab.name;
            return sCollator.compare(sa.toString(), sb.toString());
        }
        
    }
    
}

