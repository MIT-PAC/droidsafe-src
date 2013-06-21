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
    public ActivityInfo activityInfo;
    public ServiceInfo serviceInfo;
    public IntentFilter filter;
    public int priority;
    public int preferredOrder;
    public int match;
    public int specificIndex = -1;
    public boolean isDefault;
    public int labelRes;
    public CharSequence nonLocalizedLabel;
    public int icon;
    public String resolvePackageName;
    public boolean system;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.951 -0400", hash_original_method = "C76263445BA130B9E024AB7275119550", hash_generated_method = "9AD240A988A931517E58A7D3FB28D552")
    @DSModeled(DSC.SAFE)
    public ResolveInfo() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.952 -0400", hash_original_method = "D76D30C905C95224DB17E633EB6195C1", hash_generated_method = "A1C78509252A6EB5B3C68BBBB337D15C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private ResolveInfo(Parcel source) {
        dsTaint.addTaint(source.dsTaint);
        {
            Object var533A8C7CD58A93D322295C6F0E68EC88_449700902 = (source.readInt());
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
            boolean varFD16828A378FD83700BE97539951F787_1358158606 = (source.readInt() != 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.953 -0400", hash_original_method = "A33400D9D27D1859CAE2B97E545C2635", hash_generated_method = "7886EC27ACA3EDD4001B7BE99622B32B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence loadLabel(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        CharSequence label;
        {
            label = pm.getText(resolvePackageName, labelRes, null);
            {
                CharSequence var5756FBB88158B13A005DD5FF5D17599B_63270780 = (label.toString().trim());
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
                CharSequence var5756FBB88158B13A005DD5FF5D17599B_2052275977 = (label.toString().trim());
            } //End block
        } //End block
        CharSequence data;
        data = ci.loadLabel(pm);
        data = data.toString().trim();
        return dsTaint.getTaintString();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.954 -0400", hash_original_method = "D0D8D8B431D77A14F0DBD9F876D36006", hash_generated_method = "E02881ABB8C89FF307DA7CDAE1AD027C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Drawable loadIcon(PackageManager pm) {
        dsTaint.addTaint(pm.dsTaint);
        Drawable dr;
        {
            dr = pm.getDrawable(resolvePackageName, icon, null);
        } //End block
        ComponentInfo ci;
        ci = activityInfo;
        ci = serviceInfo;
        ApplicationInfo ai;
        ai = ci.applicationInfo;
        {
            dr = pm.getDrawable(ci.packageName, icon, ai);
        } //End block
        Drawable var255C38383FDE8F39033EA1E0E7298FE4_1087175530 = (ci.loadIcon(pm));
        return (Drawable)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.954 -0400", hash_original_method = "A025A0B4AEE2574644D8C11C73D3261F", hash_generated_method = "EC6ABB82A0EE39B5F907A7FAB397D320")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final int getIconResource() {
        int varE23691F8C29AA1D26CC5ADD64E261A55_1347930608 = (activityInfo.getIconResource());
        int varFF6CF132766102E71E463F8C1A0179F1_1654272440 = (serviceInfo.getIconResource());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (icon != 0) return icon;
        //if (activityInfo != null) return activityInfo.getIconResource();
        //if (serviceInfo != null) return serviceInfo.getIconResource();
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.955 -0400", hash_original_method = "64245509A5FC137877FB50AC88C4351E", hash_generated_method = "65E498160112DF7035C721A38E6A4B67")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void dump(Printer pw, String prefix) {
        dsTaint.addTaint(prefix);
        dsTaint.addTaint(pw.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.955 -0400", hash_original_method = "E9277D5F5F8618A42CE604147E3605E2", hash_generated_method = "61A96B79951079941DF36D1ED1D1CFB2")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        ComponentInfo ci;
        ci = activityInfo;
        ci = serviceInfo;
        String var99F9605E2DA21407AD3C2E35ADD253BE_1619957235 = ("ResolveInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + ci.name + " p=" + priority + " o="
            + preferredOrder + " m=0x" + Integer.toHexString(match) + "}");
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        //return "ResolveInfo{"
            //+ Integer.toHexString(System.identityHashCode(this))
            //+ " " + ci.name + " p=" + priority + " o="
            //+ preferredOrder + " m=0x" + Integer.toHexString(match) + "}";
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.956 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "ED77793910767EAAB4C12F70F75B9095")
    @DSModeled(DSC.SAFE)
    public int describeContents() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.956 -0400", hash_original_method = "C265C7C58C207232A576E6DBECFC3E71", hash_generated_method = "0CDE34FB469AEAE3EA598200CB2CA48A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dsTaint.addTaint(parcelableFlags);
        dsTaint.addTaint(dest.dsTaint);
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
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static class DisplayNameComparator implements Comparator<ResolveInfo> {
        private Collator   sCollator = Collator.getInstance();
        private PackageManager   mPM;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.956 -0400", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "AF5A9D42CCA5BEF178298CF4EA0D30B4")
        @DSModeled(DSC.SAFE)
        public DisplayNameComparator(PackageManager pm) {
            dsTaint.addTaint(pm.dsTaint);
            // ---------- Original Method ----------
            //mPM = pm;
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.957 -0400", hash_original_method = "75BF6E8997D323222280B816426CA9D8", hash_generated_method = "C329292DFF6DDC98D19B1D7C33A517D0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public final int compare(ResolveInfo a, ResolveInfo b) {
            dsTaint.addTaint(b.dsTaint);
            dsTaint.addTaint(a.dsTaint);
            CharSequence sa;
            sa = a.loadLabel(mPM);
            sa = a.activityInfo.name;
            CharSequence sb;
            sb = b.loadLabel(mPM);
            sb = b.activityInfo.name;
            int var84BDFD4BCC4C054E649C7A0FEE1F21B0_1705045527 = (sCollator.compare(sa.toString(), sb.toString()));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //CharSequence  sa = a.loadLabel(mPM);
            //if (sa == null) sa = a.activityInfo.name;
            //CharSequence  sb = b.loadLabel(mPM);
            //if (sb == null) sb = b.activityInfo.name;
            //return sCollator.compare(sa.toString(), sb.toString());
        }

        
    }


    
    public static final Creator<ResolveInfo> CREATOR = new Creator<ResolveInfo>() {        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.957 -0400", hash_original_method = "2EFE85D4E7AF81E923B1CAE80AA7FDC7", hash_generated_method = "514633AC5F2F68D3234874493D22AABB")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ResolveInfo createFromParcel(Parcel source) {
            dsTaint.addTaint(source.dsTaint);
            ResolveInfo var801FB7B1D93407B88B39C6438D4E744F_2080253522 = (new ResolveInfo(source));
            return (ResolveInfo)dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ResolveInfo(source);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:44.958 -0400", hash_original_method = "465D54D44E371032227235105FA2E1BB", hash_generated_method = "A95B140C6E9631DB6E7E4D631202AA4D")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        public ResolveInfo[] newArray(int size) {
            dsTaint.addTaint(size);
            ResolveInfo[] var82FD4013D4446B5118D554010DDD881F_2067227610 = (new ResolveInfo[size]);
            return (ResolveInfo[])dsTaint.getTaint();
            // ---------- Original Method ----------
            //return new ResolveInfo[size];
        }

        
}; //Transformed anonymous class
}

