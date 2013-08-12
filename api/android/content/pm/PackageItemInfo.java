package android.content.pm;

// Droidsafe Imports
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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.242 -0400", hash_original_field = "B068931CC450442B63F5B3D276EA4297", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.242 -0400", hash_original_field = "387F1FA6FC99B8AE187C010A06120611", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.242 -0400", hash_original_field = "8F580A9F881BD5248ABCF6CA4C789B48", hash_generated_field = "5CCBCEA64151325A8B45AD50EEEC958F")

    public int labelRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.242 -0400", hash_original_field = "C217EC6D87004328FDE9713C8BDFACF1", hash_generated_field = "EEEEA3B26D8CB06153CCE64BF10C94B7")

    public CharSequence nonLocalizedLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.242 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.242 -0400", hash_original_field = "96D6F2E7E1F705AB5E59C84A6DC009B2", hash_generated_field = "922885A8A44FD4A4B2D8F0B49A2EDED6")

    public int logo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.243 -0400", hash_original_field = "F39B17E1DA2AF1CD34AAE99B867A1C61", hash_generated_field = "94B83340D21CBE8DE8F4A432223AA875")

    public Bundle metaData;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.243 -0400", hash_original_method = "0DA45D98B1805BAB6DB37663419819EF", hash_generated_method = "A53952B9C896D4AF9B209F1D87FED0D1")
    public  PackageItemInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.244 -0400", hash_original_method = "31AB547002878BF41C4DB5C45B98DB0F", hash_generated_method = "A215D05FC72E691F04139ABEF7F69CC7")
    public  PackageItemInfo(PackageItemInfo orig) {
        name = orig.name;
        if(name != null)        
        name = name.trim();
        packageName = orig.packageName;
        labelRes = orig.labelRes;
        nonLocalizedLabel = orig.nonLocalizedLabel;
        if(nonLocalizedLabel != null)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.246 -0400", hash_original_method = "2EB380960A16EA21F3A081E2F7A7694B", hash_generated_method = "22AEBE2055E4E604C1C7E383018418CE")
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.246 -0400", hash_original_method = "7587CF1BD2560A6C6F4B753C933F3AB0", hash_generated_method = "19A24B19DE8F094D2FD243A5EBE64B56")
    public CharSequence loadLabel(PackageManager pm) {
        addTaint(pm.getTaint());
        if(nonLocalizedLabel != null)        
        {
CharSequence varBE906C9C8D8F58EFBFC8C81E44574921_794088166 =             nonLocalizedLabel;
            varBE906C9C8D8F58EFBFC8C81E44574921_794088166.addTaint(taint);
            return varBE906C9C8D8F58EFBFC8C81E44574921_794088166;
        } //End block
        if(labelRes != 0)        
        {
            CharSequence label = pm.getText(packageName, labelRes, getApplicationInfo());
            if(label != null)            
            {
CharSequence var6A0C0BC3872CAFE02E69329DEB10F42C_1878615486 =                 label.toString().trim();
                var6A0C0BC3872CAFE02E69329DEB10F42C_1878615486.addTaint(taint);
                return var6A0C0BC3872CAFE02E69329DEB10F42C_1878615486;
            } //End block
        } //End block
        if(name != null)        
        {
CharSequence varB017984728AC60AD1F0BF8734F33F15C_1610032190 =             name;
            varB017984728AC60AD1F0BF8734F33F15C_1610032190.addTaint(taint);
            return varB017984728AC60AD1F0BF8734F33F15C_1610032190;
        } //End block
CharSequence varC56556E908F763F1A1F55590F97A185E_1818688751 =         packageName;
        varC56556E908F763F1A1F55590F97A185E_1818688751.addTaint(taint);
        return varC56556E908F763F1A1F55590F97A185E_1818688751;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.248 -0400", hash_original_method = "28CAE1EAC4906E828B7AB10B1D04EBA6", hash_generated_method = "6748CB78FCE7B71F2CFA85113F0147BD")
    public Drawable loadIcon(PackageManager pm) {
        addTaint(pm.getTaint());
        if(icon != 0)        
        {
            Drawable dr = pm.getDrawable(packageName, icon, getApplicationInfo());
            if(dr != null)            
            {
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1828284224 =                 dr;
                varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1828284224.addTaint(taint);
                return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_1828284224;
            } //End block
        } //End block
Drawable varB77E3BDD223F0ECAD6D8B57AE6CCEB66_1733270520 =         loadDefaultIcon(pm);
        varB77E3BDD223F0ECAD6D8B57AE6CCEB66_1733270520.addTaint(taint);
        return varB77E3BDD223F0ECAD6D8B57AE6CCEB66_1733270520;
        // ---------- Original Method ----------
        //if (icon != 0) {
            //Drawable dr = pm.getDrawable(packageName, icon, getApplicationInfo());
            //if (dr != null) {
                //return dr;
            //}
        //}
        //return loadDefaultIcon(pm);
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.248 -0400", hash_original_method = "8E0B311EF662738B18859A93F77EBD0A", hash_generated_method = "770ABEBCDCE5C726BEA1CA33E7FC148C")
    protected Drawable loadDefaultIcon(PackageManager pm) {
        addTaint(pm.getTaint());
Drawable varAD0C68E9FDEBCDCC559AABA877077272_989753011 =         pm.getDefaultActivityIcon();
        varAD0C68E9FDEBCDCC559AABA877077272_989753011.addTaint(taint);
        return varAD0C68E9FDEBCDCC559AABA877077272_989753011;
        // ---------- Original Method ----------
        //return pm.getDefaultActivityIcon();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.249 -0400", hash_original_method = "E08D2EB4B7AA31EEDBDC94D57D687BA7", hash_generated_method = "B46B88C9FF27FDFA4951AB37C5EE9791")
    public Drawable loadLogo(PackageManager pm) {
        addTaint(pm.getTaint());
        if(logo != 0)        
        {
            Drawable d = pm.getDrawable(packageName, logo, getApplicationInfo());
            if(d != null)            
            {
Drawable varBE245B24E7ED509FDFAAA6CD39E35D89_1485216149 =                 d;
                varBE245B24E7ED509FDFAAA6CD39E35D89_1485216149.addTaint(taint);
                return varBE245B24E7ED509FDFAAA6CD39E35D89_1485216149;
            } //End block
        } //End block
Drawable var3716CCA1FFFC9EFA2CF03E314A8A1A27_837026196 =         loadDefaultLogo(pm);
        var3716CCA1FFFC9EFA2CF03E314A8A1A27_837026196.addTaint(taint);
        return var3716CCA1FFFC9EFA2CF03E314A8A1A27_837026196;
        // ---------- Original Method ----------
        //if (logo != 0) {
            //Drawable d = pm.getDrawable(packageName, logo, getApplicationInfo());
            //if (d != null) {
                //return d;
            //}
        //}
        //return loadDefaultLogo(pm);
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.250 -0400", hash_original_method = "790329C099FCB9AD7C46A077CBE50219", hash_generated_method = "782A9BC2CD89E7BE939D1758B86D147F")
    protected Drawable loadDefaultLogo(PackageManager pm) {
        addTaint(pm.getTaint());
Drawable var540C13E9E156B687226421B24F2DF178_1321898739 =         null;
        var540C13E9E156B687226421B24F2DF178_1321898739.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_1321898739;
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.251 -0400", hash_original_method = "3469F3AC66BE0248CB548730284A6983", hash_generated_method = "6E0289619C805FB164BE315F28638A4F")
    public XmlResourceParser loadXmlMetaData(PackageManager pm, String name) {
        addTaint(name.getTaint());
        addTaint(pm.getTaint());
        if(metaData != null)        
        {
            int resid = metaData.getInt(name);
            if(resid != 0)            
            {
XmlResourceParser var2E55A1CF770686CBBF2A21A4D0335E15_524110765 =                 pm.getXml(packageName, resid, getApplicationInfo());
                var2E55A1CF770686CBBF2A21A4D0335E15_524110765.addTaint(taint);
                return var2E55A1CF770686CBBF2A21A4D0335E15_524110765;
            } //End block
        } //End block
XmlResourceParser var540C13E9E156B687226421B24F2DF178_684238922 =         null;
        var540C13E9E156B687226421B24F2DF178_684238922.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_684238922;
        // ---------- Original Method ----------
        //if (metaData != null) {
            //int resid = metaData.getInt(name);
            //if (resid != 0) {
                //return pm.getXml(packageName, resid, getApplicationInfo());
            //}
        //}
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.251 -0400", hash_original_method = "6B8B2642A2B8BBF6D444F1A91AC9FDCB", hash_generated_method = "C69823C8C0B8018FC8EF92FC3E631086")
    protected void dumpFront(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        if(name != null)        
        {
            pw.println(prefix + "name=" + name);
        } //End block
        pw.println(prefix + "packageName=" + packageName);
        if(labelRes != 0 || nonLocalizedLabel != null || icon != 0)        
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

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.252 -0400", hash_original_method = "B7061250601C1EA92C43E5184BBC6241", hash_generated_method = "E7500C2A6335C8EBED547E7514F82CE5")
    protected void dumpBack(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.253 -0400", hash_original_method = "EBFCAD6F5CD0994BD82522BC30DB76DD", hash_generated_method = "8FE55B7ADC8F1F6AEF2BD3A9D4B3B2AA")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.253 -0400", hash_original_method = "3C095FBE28E1D0A5D79820831D5573F9", hash_generated_method = "C917DFC50DA984F6ECD5D325C0097FBD")
    protected ApplicationInfo getApplicationInfo() {
ApplicationInfo var540C13E9E156B687226421B24F2DF178_698361942 =         null;
        var540C13E9E156B687226421B24F2DF178_698361942.addTaint(taint);
        return var540C13E9E156B687226421B24F2DF178_698361942;
        // ---------- Original Method ----------
        //return null;
    }

    
    public static class DisplayNameComparator implements Comparator<PackageItemInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.253 -0400", hash_original_field = "8535BFF02E263AB07820336F2B6CBE9E", hash_generated_field = "0F522A2F9FEC0AE6C7C0EFB2E65868E6")

        private final Collator sCollator = Collator.getInstance();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.254 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "B9590FAB3CF140F08C9CD4E0309ED58A")

        private PackageManager mPM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.254 -0400", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "00B9637435B2DF20319BD9D174F2475F")
        public  DisplayNameComparator(PackageManager pm) {
            mPM = pm;
            // ---------- Original Method ----------
            //mPM = pm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:04.255 -0400", hash_original_method = "2595E40DD10804FAA28D70201572BA0B", hash_generated_method = "BA8D55F0C3A2C706CE8E68CC8D35F93C")
        public final int compare(PackageItemInfo aa, PackageItemInfo ab) {
            addTaint(ab.getTaint());
            addTaint(aa.getTaint());
            CharSequence sa = aa.loadLabel(mPM);
            if(sa == null)            
            sa = aa.name;
            CharSequence sb = ab.loadLabel(mPM);
            if(sb == null)            
            sb = ab.name;
            int var7A8EA953ABC7951DF47FDA1BDAC98D15_1066856343 = (sCollator.compare(sa.toString(), sb.toString()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200938723 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_200938723;
            // ---------- Original Method ----------
            //CharSequence  sa = aa.loadLabel(mPM);
            //if (sa == null) sa = aa.name;
            //CharSequence  sb = ab.loadLabel(mPM);
            //if (sb == null) sb = ab.name;
            //return sCollator.compare(sa.toString(), sb.toString());
        }

        
    }


    
}

