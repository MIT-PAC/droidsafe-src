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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.780 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.780 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.780 -0400", hash_original_field = "8F580A9F881BD5248ABCF6CA4C789B48", hash_generated_field = "5CCBCEA64151325A8B45AD50EEEC958F")

    public int labelRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.780 -0400", hash_original_field = "C217EC6D87004328FDE9713C8BDFACF1", hash_generated_field = "EEEEA3B26D8CB06153CCE64BF10C94B7")

    public CharSequence nonLocalizedLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.780 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.780 -0400", hash_original_field = "96D6F2E7E1F705AB5E59C84A6DC009B2", hash_generated_field = "922885A8A44FD4A4B2D8F0B49A2EDED6")

    public int logo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.780 -0400", hash_original_field = "F39B17E1DA2AF1CD34AAE99B867A1C61", hash_generated_field = "94B83340D21CBE8DE8F4A432223AA875")

    public Bundle metaData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.780 -0400", hash_original_method = "0DA45D98B1805BAB6DB37663419819EF", hash_generated_method = "A53952B9C896D4AF9B209F1D87FED0D1")
    public  PackageItemInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.781 -0400", hash_original_method = "31AB547002878BF41C4DB5C45B98DB0F", hash_generated_method = "90B5C40131C9FAFAAF36866866BF9A45")
    public  PackageItemInfo(PackageItemInfo orig) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.781 -0400", hash_original_method = "2EB380960A16EA21F3A081E2F7A7694B", hash_generated_method = "22AEBE2055E4E604C1C7E383018418CE")
    protected  PackageItemInfo(Parcel source) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.783 -0400", hash_original_method = "7587CF1BD2560A6C6F4B753C933F3AB0", hash_generated_method = "008D85CEFE5C894A3D51263A68A34895")
    public CharSequence loadLabel(PackageManager pm) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1513300313 = null; //Variable for return #1
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_737355712 = null; //Variable for return #2
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_31684520 = null; //Variable for return #3
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_2005439968 = null; //Variable for return #4
        {
            varB4EAC82CA7396A68D541C85D26508E83_1513300313 = nonLocalizedLabel;
        } //End block
        {
            CharSequence label = pm.getText(packageName, labelRes, getApplicationInfo());
            {
                varB4EAC82CA7396A68D541C85D26508E83_737355712 = label.toString().trim();
            } //End block
        } //End block
        {
            varB4EAC82CA7396A68D541C85D26508E83_31684520 = name;
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_2005439968 = packageName;
        addTaint(pm.getTaint());
        CharSequence varA7E53CE21691AB073D9660D615818899_1896819166; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1896819166 = varB4EAC82CA7396A68D541C85D26508E83_1513300313;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1896819166 = varB4EAC82CA7396A68D541C85D26508E83_737355712;
                break;
            case 3: //Assign result for return ordinal #3
                varA7E53CE21691AB073D9660D615818899_1896819166 = varB4EAC82CA7396A68D541C85D26508E83_31684520;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1896819166 = varB4EAC82CA7396A68D541C85D26508E83_2005439968;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1896819166.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1896819166;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.784 -0400", hash_original_method = "28CAE1EAC4906E828B7AB10B1D04EBA6", hash_generated_method = "50201682588CCBAD7894905253E41A8B")
    public Drawable loadIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1032228852 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_152044181 = null; //Variable for return #2
        {
            Drawable dr = pm.getDrawable(packageName, icon, getApplicationInfo());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1032228852 = dr;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_152044181 = loadDefaultIcon(pm);
        addTaint(pm.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_2035592708; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2035592708 = varB4EAC82CA7396A68D541C85D26508E83_1032228852;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2035592708 = varB4EAC82CA7396A68D541C85D26508E83_152044181;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2035592708.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2035592708;
        // ---------- Original Method ----------
        //if (icon != 0) {
            //Drawable dr = pm.getDrawable(packageName, icon, getApplicationInfo());
            //if (dr != null) {
                //return dr;
            //}
        //}
        //return loadDefaultIcon(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.785 -0400", hash_original_method = "8E0B311EF662738B18859A93F77EBD0A", hash_generated_method = "F252FDF9FB44ABBCAC2DC20719D49BD8")
    protected Drawable loadDefaultIcon(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1163403936 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1163403936 = pm.getDefaultActivityIcon();
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1163403936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1163403936;
        // ---------- Original Method ----------
        //return pm.getDefaultActivityIcon();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.786 -0400", hash_original_method = "E08D2EB4B7AA31EEDBDC94D57D687BA7", hash_generated_method = "0E555A980726E7A7D64E53D11243C071")
    public Drawable loadLogo(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1612659166 = null; //Variable for return #1
        Drawable varB4EAC82CA7396A68D541C85D26508E83_392307235 = null; //Variable for return #2
        {
            Drawable d = pm.getDrawable(packageName, logo, getApplicationInfo());
            {
                varB4EAC82CA7396A68D541C85D26508E83_1612659166 = d;
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_392307235 = loadDefaultLogo(pm);
        addTaint(pm.getTaint());
        Drawable varA7E53CE21691AB073D9660D615818899_2024081644; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_2024081644 = varB4EAC82CA7396A68D541C85D26508E83_1612659166;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_2024081644 = varB4EAC82CA7396A68D541C85D26508E83_392307235;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_2024081644.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_2024081644;
        // ---------- Original Method ----------
        //if (logo != 0) {
            //Drawable d = pm.getDrawable(packageName, logo, getApplicationInfo());
            //if (d != null) {
                //return d;
            //}
        //}
        //return loadDefaultLogo(pm);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.787 -0400", hash_original_method = "790329C099FCB9AD7C46A077CBE50219", hash_generated_method = "316D5F65B39AC5EA15A37158C4DD1A6F")
    protected Drawable loadDefaultLogo(PackageManager pm) {
        Drawable varB4EAC82CA7396A68D541C85D26508E83_1720411762 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1720411762 = null;
        addTaint(pm.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1720411762.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1720411762;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.788 -0400", hash_original_method = "3469F3AC66BE0248CB548730284A6983", hash_generated_method = "1314EB0BF93B914D7413775BA862B18F")
    public XmlResourceParser loadXmlMetaData(PackageManager pm, String name) {
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_1701470587 = null; //Variable for return #1
        XmlResourceParser varB4EAC82CA7396A68D541C85D26508E83_604519178 = null; //Variable for return #2
        {
            int resid = metaData.getInt(name);
            {
                varB4EAC82CA7396A68D541C85D26508E83_1701470587 = pm.getXml(packageName, resid, getApplicationInfo());
            } //End block
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_604519178 = null;
        addTaint(pm.getTaint());
        addTaint(name.getTaint());
        XmlResourceParser varA7E53CE21691AB073D9660D615818899_9297596; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_9297596 = varB4EAC82CA7396A68D541C85D26508E83_1701470587;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_9297596 = varB4EAC82CA7396A68D541C85D26508E83_604519178;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_9297596.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_9297596;
        // ---------- Original Method ----------
        //if (metaData != null) {
            //int resid = metaData.getInt(name);
            //if (resid != 0) {
                //return pm.getXml(packageName, resid, getApplicationInfo());
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.788 -0400", hash_original_method = "6B8B2642A2B8BBF6D444F1A91AC9FDCB", hash_generated_method = "02417D6698EDB72ED785CBF64C239DD4")
    protected void dumpFront(Printer pw, String prefix) {
        {
            pw.println(prefix + "name=" + name);
        } //End block
        pw.println(prefix + "packageName=" + packageName);
        {
            pw.println(prefix + "labelRes=0x" + Integer.toHexString(labelRes)
                    + " nonLocalizedLabel=" + nonLocalizedLabel
                    + " icon=0x" + Integer.toHexString(icon));
        } //End block
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.789 -0400", hash_original_method = "B7061250601C1EA92C43E5184BBC6241", hash_generated_method = "D8B099546B41237AE2233D8866941249")
    protected void dumpBack(Printer pw, String prefix) {
        addTaint(pw.getTaint());
        addTaint(prefix.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.789 -0400", hash_original_method = "EBFCAD6F5CD0994BD82522BC30DB76DD", hash_generated_method = "94C02EB46824C31BE01CD94D6AA9CA38")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeString(name);
        dest.writeString(packageName);
        dest.writeInt(labelRes);
        TextUtils.writeToParcel(nonLocalizedLabel, dest, parcelableFlags);
        dest.writeInt(icon);
        dest.writeInt(logo);
        dest.writeBundle(metaData);
        addTaint(dest.getTaint());
        addTaint(parcelableFlags);
        // ---------- Original Method ----------
        //dest.writeString(name);
        //dest.writeString(packageName);
        //dest.writeInt(labelRes);
        //TextUtils.writeToParcel(nonLocalizedLabel, dest, parcelableFlags);
        //dest.writeInt(icon);
        //dest.writeInt(logo);
        //dest.writeBundle(metaData);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.790 -0400", hash_original_method = "3C095FBE28E1D0A5D79820831D5573F9", hash_generated_method = "F524BBB97562F4218AC234124D490912")
    protected ApplicationInfo getApplicationInfo() {
        ApplicationInfo varB4EAC82CA7396A68D541C85D26508E83_965782225 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_965782225 = null;
        varB4EAC82CA7396A68D541C85D26508E83_965782225.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_965782225;
        // ---------- Original Method ----------
        //return null;
    }

    
    public static class DisplayNameComparator implements Comparator<PackageItemInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.790 -0400", hash_original_field = "8535BFF02E263AB07820336F2B6CBE9E", hash_generated_field = "0F522A2F9FEC0AE6C7C0EFB2E65868E6")

        private final Collator sCollator = Collator.getInstance();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.790 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "B9590FAB3CF140F08C9CD4E0309ED58A")

        private PackageManager mPM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.790 -0400", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "00B9637435B2DF20319BD9D174F2475F")
        public  DisplayNameComparator(PackageManager pm) {
            mPM = pm;
            // ---------- Original Method ----------
            //mPM = pm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:13:26.791 -0400", hash_original_method = "2595E40DD10804FAA28D70201572BA0B", hash_generated_method = "EB745423E46EDC3F9761B0D789ECD5CE")
        public final int compare(PackageItemInfo aa, PackageItemInfo ab) {
            CharSequence sa = aa.loadLabel(mPM);
            sa = aa.name;
            CharSequence sb = ab.loadLabel(mPM);
            sb = ab.name;
            int var84BDFD4BCC4C054E649C7A0FEE1F21B0_76284331 = (sCollator.compare(sa.toString(), sb.toString()));
            addTaint(aa.getTaint());
            addTaint(ab.getTaint());
            int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074331654 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2074331654;
            // ---------- Original Method ----------
            //CharSequence  sa = aa.loadLabel(mPM);
            //if (sa == null) sa = aa.name;
            //CharSequence  sb = ab.loadLabel(mPM);
            //if (sb == null) sb = ab.name;
            //return sCollator.compare(sa.toString(), sb.toString());
        }

        
    }


    
}

