package android.content.pm;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Printer;
import java.text.Collator;
import java.util.Comparator;

public class ResolveInfo implements Parcelable {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.380 -0400", hash_original_field = "D189E59358BD9D02DDCA24FC5ED15564", hash_generated_field = "FCA2A130861F7E80B0DB4D7C0D3F6C7C")

    public ActivityInfo activityInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.381 -0400", hash_original_field = "3F2E979E1975888EE11D3A07AD851781", hash_generated_field = "8A9FCE2913AD168B1F16362320563799")

    public ServiceInfo serviceInfo;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.381 -0400", hash_original_field = "B2C97AE425DD751B0E48A3ACAE79CF4A", hash_generated_field = "FC5A6BB8CDC12E61FC38F3539A900F50")

    public IntentFilter filter;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.381 -0400", hash_original_field = "B988295C268025B49DFB3DF26171DDC3", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

    public int priority;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.381 -0400", hash_original_field = "523BF488C23258C50382C9FC4A33463E", hash_generated_field = "CC2809918299E4A2861E7C50D76F09CD")

    public int preferredOrder;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.381 -0400", hash_original_field = "E3CC92C14A5E6DD1A7D94B6FF634D7FC", hash_generated_field = "69002FAD26F29F956AB6551745577EC8")

    public int match;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.382 -0400", hash_original_field = "7ADB8F3553FF0211E87EA9FC9269B4AF", hash_generated_field = "B0695D23967AED8DE288087FB5582005")

    public int specificIndex = -1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.382 -0400", hash_original_field = "E558E63F3083922542D8745224A66EEA", hash_generated_field = "0D9B319BE2E837F574E088E42B45ECAA")

    public boolean isDefault;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.382 -0400", hash_original_field = "8F580A9F881BD5248ABCF6CA4C789B48", hash_generated_field = "5CCBCEA64151325A8B45AD50EEEC958F")

    public int labelRes;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.382 -0400", hash_original_field = "C217EC6D87004328FDE9713C8BDFACF1", hash_generated_field = "EEEEA3B26D8CB06153CCE64BF10C94B7")

    public CharSequence nonLocalizedLabel;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.382 -0400", hash_original_field = "BAEC6461B0D69DDE1B861AEFBE375D8A", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.383 -0400", hash_original_field = "746B34F4CCCD992C890FF9632ACC49F3", hash_generated_field = "5DA56F7664A4B97B3B98FFC1A1281F6E")

    public String resolvePackageName;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.383 -0400", hash_original_field = "54B53072540EEEB8F8E9343E71F28176", hash_generated_field = "D1DBA00001B7F415431AD6FCAB5BAA5D")

    public boolean system;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.384 -0400", hash_original_method = "C76263445BA130B9E024AB7275119550", hash_generated_method = "9AD240A988A931517E58A7D3FB28D552")
    public  ResolveInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.388 -0400", hash_original_method = "D76D30C905C95224DB17E633EB6195C1", hash_generated_method = "0F6125C05464BE9DA404484F88A2D1BC")
    private  ResolveInfo(Parcel source) {
switch(source.readInt()){
        case 1:
        activityInfo = ActivityInfo.CREATOR.createFromParcel(source);
        serviceInfo = null;
        break;
        case 2:
        serviceInfo = ServiceInfo.CREATOR.createFromParcel(source);
        activityInfo = null;
        break;
        default:
        activityInfo = null;
        serviceInfo = null;
        break;
}    if(source.readInt() != 0)        
        {
            filter = IntentFilter.CREATOR.createFromParcel(source);
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.389 -0400", hash_original_method = "A33400D9D27D1859CAE2B97E545C2635", hash_generated_method = "F9361C42EBE36C025F3C8DBD2F5D108D")
    public CharSequence loadLabel(PackageManager pm) {
        addTaint(pm.getTaint());
    if(nonLocalizedLabel != null)        
        {
CharSequence varBE906C9C8D8F58EFBFC8C81E44574921_50190098 =             nonLocalizedLabel;
            varBE906C9C8D8F58EFBFC8C81E44574921_50190098.addTaint(taint);
            return varBE906C9C8D8F58EFBFC8C81E44574921_50190098;
        } //End block
        CharSequence label;
    if(resolvePackageName != null && labelRes != 0)        
        {
            label = pm.getText(resolvePackageName, labelRes, null);
    if(label != null)            
            {
CharSequence var6A0C0BC3872CAFE02E69329DEB10F42C_1629226320 =                 label.toString().trim();
                var6A0C0BC3872CAFE02E69329DEB10F42C_1629226320.addTaint(taint);
                return var6A0C0BC3872CAFE02E69329DEB10F42C_1629226320;
            } //End block
        } //End block
        ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        ApplicationInfo ai = ci.applicationInfo;
    if(labelRes != 0)        
        {
            label = pm.getText(ci.packageName, labelRes, ai);
    if(label != null)            
            {
CharSequence var6A0C0BC3872CAFE02E69329DEB10F42C_1888545789 =                 label.toString().trim();
                var6A0C0BC3872CAFE02E69329DEB10F42C_1888545789.addTaint(taint);
                return var6A0C0BC3872CAFE02E69329DEB10F42C_1888545789;
            } //End block
        } //End block
        CharSequence data = ci.loadLabel(pm);
    if(data != null)        
        data = data.toString().trim();
CharSequence var0C8B2C9585EB05DD9CD70726CF8CBC07_824094641 =         data;
        var0C8B2C9585EB05DD9CD70726CF8CBC07_824094641.addTaint(taint);
        return var0C8B2C9585EB05DD9CD70726CF8CBC07_824094641;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.390 -0400", hash_original_method = "D0D8D8B431D77A14F0DBD9F876D36006", hash_generated_method = "CFF3194B9727F6348D8D2EF13AF1A858")
    public Drawable loadIcon(PackageManager pm) {
        addTaint(pm.getTaint());
        Drawable dr;
    if(resolvePackageName != null && icon != 0)        
        {
            dr = pm.getDrawable(resolvePackageName, icon, null);
    if(dr != null)            
            {
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_7154070 =                 dr;
                varDA2FE1A9D9D8285A7F4D54668C2E4AE3_7154070.addTaint(taint);
                return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_7154070;
            } //End block
        } //End block
        ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        ApplicationInfo ai = ci.applicationInfo;
    if(icon != 0)        
        {
            dr = pm.getDrawable(ci.packageName, icon, ai);
    if(dr != null)            
            {
Drawable varDA2FE1A9D9D8285A7F4D54668C2E4AE3_2124694696 =                 dr;
                varDA2FE1A9D9D8285A7F4D54668C2E4AE3_2124694696.addTaint(taint);
                return varDA2FE1A9D9D8285A7F4D54668C2E4AE3_2124694696;
            } //End block
        } //End block
Drawable varAC1ABD151EC02B2A0CF6C484334129EB_1054254554 =         ci.loadIcon(pm);
        varAC1ABD151EC02B2A0CF6C484334129EB_1054254554.addTaint(taint);
        return varAC1ABD151EC02B2A0CF6C484334129EB_1054254554;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.390 -0400", hash_original_method = "A025A0B4AEE2574644D8C11C73D3261F", hash_generated_method = "070CFF4BE6AF62CD6C4DC1EF9F20B0DE")
    public final int getIconResource() {
    if(icon != 0)        
        {
        int varBAEC6461B0D69DDE1B861AEFBE375D8A_1077094321 = (icon);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916823302 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1916823302;
        }
    if(activityInfo != null)        
        {
        int varDE037353441F8B637B2F0B59B4C559D4_162324516 = (activityInfo.getIconResource());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827639199 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1827639199;
        }
    if(serviceInfo != null)        
        {
        int var31A6B0252AFD5064955AD71C9DE84292_388076482 = (serviceInfo.getIconResource());
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224480656 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1224480656;
        }
        int varCFCD208495D565EF66E7DFF9F98764DA_970408895 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014137147 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2014137147;
        // ---------- Original Method ----------
        //if (icon != 0) return icon;
        //if (activityInfo != null) return activityInfo.getIconResource();
        //if (serviceInfo != null) return serviceInfo.getIconResource();
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.391 -0400", hash_original_method = "64245509A5FC137877FB50AC88C4351E", hash_generated_method = "C6E4CCBF83B7AA29B4668FE8CE407623")
    public void dump(Printer pw, String prefix) {
        addTaint(prefix.getTaint());
        addTaint(pw.getTaint());
    if(filter != null)        
        {
            pw.println(prefix + "Filter:");
            filter.dump(pw, prefix + "  ");
        } //End block
        pw.println(prefix + "priority=" + priority
                + " preferredOrder=" + preferredOrder
                + " match=0x" + Integer.toHexString(match)
                + " specificIndex=" + specificIndex
                + " isDefault=" + isDefault);
    if(resolvePackageName != null)        
        {
            pw.println(prefix + "resolvePackageName=" + resolvePackageName);
        } //End block
    if(labelRes != 0 || nonLocalizedLabel != null || icon != 0)        
        {
            pw.println(prefix + "labelRes=0x" + Integer.toHexString(labelRes)
                    + " nonLocalizedLabel=" + nonLocalizedLabel
                    + " icon=0x" + Integer.toHexString(icon));
        } //End block
    if(activityInfo != null)        
        {
            pw.println(prefix + "ActivityInfo:");
            activityInfo.dump(pw, prefix + "  ");
        } //End block
        else
    if(serviceInfo != null)        
        {
            pw.println(prefix + "ServiceInfo:");
            serviceInfo.dump(pw, prefix + "  ");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.416 -0400", hash_original_method = "E9277D5F5F8618A42CE604147E3605E2", hash_generated_method = "56662A3833525C67E354069A486976B2")
    public String toString() {
        ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
String var2E81D21F4BB04749CB49DF2B60E0DD5F_43156326 =         "ResolveInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + ci.name + " p=" + priority + " o="
            + preferredOrder + " m=0x" + Integer.toHexString(match) + "}";
        var2E81D21F4BB04749CB49DF2B60E0DD5F_43156326.addTaint(taint);
        return var2E81D21F4BB04749CB49DF2B60E0DD5F_43156326;
        // ---------- Original Method ----------
        //ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        //return "ResolveInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + ci.name + " p=" + priority + " o="
            //+ preferredOrder + " m=0x" + Integer.toHexString(match) + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.417 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "EA118DF32A6B46BC25DFAADDACE8F957")
    public int describeContents() {
        int varCFCD208495D565EF66E7DFF9F98764DA_1654366279 = (0);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_741165443 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_741165443;
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.417 -0400", hash_original_method = "C265C7C58C207232A576E6DBECFC3E71", hash_generated_method = "46CDDE1FEA46B227CC48ED7F8EC9B512")
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        addTaint(parcelableFlags);
        addTaint(dest.getTaint());
    if(activityInfo != null)        
        {
            dest.writeInt(1);
            activityInfo.writeToParcel(dest, parcelableFlags);
        } //End block
        else
    if(serviceInfo != null)        
        {
            dest.writeInt(2);
            serviceInfo.writeToParcel(dest, parcelableFlags);
        } //End block
        else
        {
            dest.writeInt(0);
        } //End block
    if(filter != null)        
        {
            dest.writeInt(1);
            filter.writeToParcel(dest, parcelableFlags);
        } //End block
        else
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class DisplayNameComparator implements Comparator<ResolveInfo> {
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.418 -0400", hash_original_field = "8535BFF02E263AB07820336F2B6CBE9E", hash_generated_field = "0F522A2F9FEC0AE6C7C0EFB2E65868E6")

        private final Collator sCollator = Collator.getInstance();
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.418 -0400", hash_original_field = "3D87516393C6B091D0B0E6C38455BD37", hash_generated_field = "B9590FAB3CF140F08C9CD4E0309ED58A")

        private PackageManager mPM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.418 -0400", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "00B9637435B2DF20319BD9D174F2475F")
        public  DisplayNameComparator(PackageManager pm) {
            mPM = pm;
            // ---------- Original Method ----------
            //mPM = pm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.419 -0400", hash_original_method = "75BF6E8997D323222280B816426CA9D8", hash_generated_method = "191DED94B46BBFBEB7059387C40CC7AF")
        public final int compare(ResolveInfo a, ResolveInfo b) {
            addTaint(b.getTaint());
            addTaint(a.getTaint());
            CharSequence sa = a.loadLabel(mPM);
    if(sa == null)            
            sa = a.activityInfo.name;
            CharSequence sb = b.loadLabel(mPM);
    if(sb == null)            
            sb = b.activityInfo.name;
            int var7A8EA953ABC7951DF47FDA1BDAC98D15_415661434 = (sCollator.compare(sa.toString(), sb.toString()));
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355071046 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1355071046;
            // ---------- Original Method ----------
            //CharSequence  sa = a.loadLabel(mPM);
            //if (sa == null) sa = a.activityInfo.name;
            //CharSequence  sb = b.loadLabel(mPM);
            //if (sb == null) sb = b.activityInfo.name;
            //return sCollator.compare(sa.toString(), sb.toString());
        }

        
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:47:14.419 -0400", hash_original_field = "C8E3508AADB06B7F78F470F3288D5470", hash_generated_field = "699B00262ABFFA011EC34065A2FBCAFD")

    public static final Creator<ResolveInfo> CREATOR
            = new Creator<ResolveInfo>() {
        public ResolveInfo createFromParcel(Parcel source) {
            return new ResolveInfo(source);
        }
        public ResolveInfo[] newArray(int size) {
            return new ResolveInfo[size];
        }
    };
    // orphaned legacy method
    public ResolveInfo createFromParcel(Parcel source) {
            return new ResolveInfo(source);
        }
    
    // orphaned legacy method
    public ResolveInfo[] newArray(int size) {
            return new ResolveInfo[size];
        }
    
}

