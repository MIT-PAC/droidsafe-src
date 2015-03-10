/*
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright (C) 2007 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.content.pm;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.text.Collator;
import java.util.Comparator;

import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Printer;

public class ResolveInfo implements Parcelable {
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:05.678 -0400", hash_original_field = "C8E3508AADB06B7F78F470F3288D5470", hash_generated_field = "699B00262ABFFA011EC34065A2FBCAFD")

    public static final Creator<ResolveInfo> CREATOR
            = new Creator<ResolveInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.616 -0500", hash_original_method = "2EFE85D4E7AF81E923B1CAE80AA7FDC7", hash_generated_method = "F224919CC590333341253A2679D1F1C0")
        
public ResolveInfo createFromParcel(Parcel source) {
            return new ResolveInfo(source);
        }
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.618 -0500", hash_original_method = "465D54D44E371032227235105FA2E1BB", hash_generated_method = "12A3058F2BB845A304E467C0DF012A07")
        
public ResolveInfo[] newArray(int size) {
            return new ResolveInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.568 -0500", hash_original_field = "9CFCA1B7F8752ABB79A9EED9367C413A", hash_generated_field = "FCA2A130861F7E80B0DB4D7C0D3F6C7C")

    public ActivityInfo activityInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.570 -0500", hash_original_field = "0A54488E7DE02A84F7B3958FCC5F6C55", hash_generated_field = "8A9FCE2913AD168B1F16362320563799")

    public ServiceInfo serviceInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.572 -0500", hash_original_field = "7DA86C636503E600C04786FD252B8201", hash_generated_field = "FC5A6BB8CDC12E61FC38F3539A900F50")

    public IntentFilter filter;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.574 -0500", hash_original_field = "4AD9F2E37B35E313CD211FBAFDADA238", hash_generated_field = "748E38F248BB72B76836AB36AB4B68BF")

    public int priority;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.576 -0500", hash_original_field = "779D80D745B00F64BDB9B50AE8B2EDE6", hash_generated_field = "CC2809918299E4A2861E7C50D76F09CD")

    public int preferredOrder;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.578 -0500", hash_original_field = "950B74CA38103976444EB475231250E0", hash_generated_field = "69002FAD26F29F956AB6551745577EC8")

    public int match;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.580 -0500", hash_original_field = "9CB9F7F1E0FBC623887C9B68F9D60027", hash_generated_field = "B0695D23967AED8DE288087FB5582005")

    public int specificIndex = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.582 -0500", hash_original_field = "6B3A143F97C72E73C238003FB11FA94E", hash_generated_field = "0D9B319BE2E837F574E088E42B45ECAA")

    public boolean isDefault;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.584 -0500", hash_original_field = "72766807210949DB14E0A53D32EEFA42", hash_generated_field = "5CCBCEA64151325A8B45AD50EEEC958F")

    public int labelRes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.587 -0500", hash_original_field = "E41FD8D985C7C7980A3E63475B8D976E", hash_generated_field = "EEEEA3B26D8CB06153CCE64BF10C94B7")

    public CharSequence nonLocalizedLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.589 -0500", hash_original_field = "107298D9FB7BD66B47A702264D3B04F5", hash_generated_field = "CB969AD5516AE5767E5AFFB8BD6B4D43")

    public int icon;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.591 -0500", hash_original_field = "1049ACBB4B0D641EB93AA22273884E1A", hash_generated_field = "5DA56F7664A4B97B3B98FFC1A1281F6E")

    public String resolvePackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.593 -0500", hash_original_field = "016E96A32B19F608119986960AC1140B", hash_generated_field = "D1DBA00001B7F415431AD6FCAB5BAA5D")

    public boolean system;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.606 -0500", hash_original_method = "C76263445BA130B9E024AB7275119550", hash_generated_method = "2D789C4B3776F6A12FC3B9469B05CDC9")
    
public ResolveInfo() {
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.623 -0500", hash_original_method = "D76D30C905C95224DB17E633EB6195C1", hash_generated_method = "0932C4CA4B78A5E26DF6C9D29B6A1E1D")
    
private ResolveInfo(Parcel source) {
        switch (source.readInt()) {
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
        }
        if (source.readInt() != 0) {
            filter = IntentFilter.CREATOR.createFromParcel(source);
        }
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
    }

    /**
     * Retrieve the current textual label associated with this resolution.  This
     * will call back on the given PackageManager to load the label from
     * the application.
     * 
     * @param pm A PackageManager from which the label can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     * 
     * @return Returns a CharSequence containing the resolutions's label.  If the
     * item does not have a label, its name is returned.
     */
    @DSComment("get string associated resolution")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.595 -0500", hash_original_method = "A33400D9D27D1859CAE2B97E545C2635", hash_generated_method = "42C3E3BCE3653378560C9036E33DF328")
    
public CharSequence loadLabel(PackageManager pm) {
        if (nonLocalizedLabel != null) {
            return nonLocalizedLabel;
        }
        CharSequence label;
        if (resolvePackageName != null && labelRes != 0) {
            label = pm.getText(resolvePackageName, labelRes, null);
            if (label != null) {
                return label.toString().trim();
            }
        }
        ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        ApplicationInfo ai = ci.applicationInfo;
        if (labelRes != 0) {
            label = pm.getText(ci.packageName, labelRes, ai);
            if (label != null) {
                return label.toString().trim();
            }
        }

        CharSequence data = ci.loadLabel(pm);
        // Make the data safe
        if (data != null) data = data.toString().trim();
        return data;
    }
    
    /**
     * Retrieve the current graphical icon associated with this resolution.  This
     * will call back on the given PackageManager to load the icon from
     * the application.
     * 
     * @param pm A PackageManager from which the icon can be loaded; usually
     * the PackageManager from which you originally retrieved this item.
     * 
     * @return Returns a Drawable containing the resolution's icon.  If the
     * item does not have an icon, the default activity icon is returned.
     */
    @DSComment("Accessing App Resource")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.598 -0500", hash_original_method = "D0D8D8B431D77A14F0DBD9F876D36006", hash_generated_method = "FB44EDEB4A97D53F1E4B44FF2793ABA6")
    
public Drawable loadIcon(PackageManager pm) {
        Drawable dr;
        if (resolvePackageName != null && icon != 0) {
            dr = pm.getDrawable(resolvePackageName, icon, null);
            if (dr != null) {
                return dr;
            }
        }
        ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        ApplicationInfo ai = ci.applicationInfo;
        if (icon != 0) {
            dr = pm.getDrawable(ci.packageName, icon, ai);
            if (dr != null) {
                return dr;
            }
        }
        return ci.loadIcon(pm);
    }
    
    /**
     * Return the icon resource identifier to use for this match.  If the
     * match defines an icon, that is used; else if the activity defines
     * an icon, that is used; else, the application icon is used.
     * 
     * @return The icon associated with this match.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.600 -0500", hash_original_method = "A025A0B4AEE2574644D8C11C73D3261F", hash_generated_method = "83F53CEDFC4E582C85161F5611B1829E")
    
public final int getIconResource() {
        if (icon != 0) return icon;
        if (activityInfo != null) return activityInfo.getIconResource();
        if (serviceInfo != null) return serviceInfo.getIconResource();
        return 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.604 -0500", hash_original_method = "64245509A5FC137877FB50AC88C4351E", hash_generated_method = "0F66FE95F8591EFB1AC1F94F7B759082")
    
public void dump(Printer pw, String prefix) {
        if (filter != null) {
            pw.println(prefix + "Filter:");
            filter.dump(pw, prefix + "  ");
        }
        pw.println(prefix + "priority=" + priority
                + " preferredOrder=" + preferredOrder
                + " match=0x" + Integer.toHexString(match)
                + " specificIndex=" + specificIndex
                + " isDefault=" + isDefault);
        if (resolvePackageName != null) {
            pw.println(prefix + "resolvePackageName=" + resolvePackageName);
        }
        if (labelRes != 0 || nonLocalizedLabel != null || icon != 0) {
            pw.println(prefix + "labelRes=0x" + Integer.toHexString(labelRes)
                    + " nonLocalizedLabel=" + nonLocalizedLabel
                    + " icon=0x" + Integer.toHexString(icon));
        }
        if (activityInfo != null) {
            pw.println(prefix + "ActivityInfo:");
            activityInfo.dump(pw, prefix + "  ");
        } else if (serviceInfo != null) {
            pw.println(prefix + "ServiceInfo:");
            serviceInfo.dump(pw, prefix + "  ");
        }
    }

    @DSComment("string out of intent resolution, safe")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.608 -0500", hash_original_method = "E9277D5F5F8618A42CE604147E3605E2", hash_generated_method = "0D2A4E70211D71BA8C1449AEED9CBAE2")
    
public String toString() {
        ComponentInfo ci = activityInfo != null ? activityInfo : serviceInfo;
        return "ResolveInfo{"
            + Integer.toHexString(System.identityHashCode(this))
            + " " + ci.name + " p=" + priority + " o="
            + preferredOrder + " m=0x" + Integer.toHexString(match) + "}";
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.610 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    
    public static class DisplayNameComparator implements Comparator<ResolveInfo> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.632 -0500", hash_original_field = "EE5E44F3B728B272AD02D50E8F128A4E", hash_generated_field = "0F522A2F9FEC0AE6C7C0EFB2E65868E6")

        private final Collator   sCollator = Collator.getInstance();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.635 -0500", hash_original_field = "D7E1102720CC9E76648EB86B25CA5216", hash_generated_field = "B9590FAB3CF140F08C9CD4E0309ED58A")

        private PackageManager   mPM;
        @DSComment("only compare method available, not too useful")
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.626 -0500", hash_original_method = "01BC6A405956ED34F2FEA27AD8C34186", hash_generated_method = "93A18F8F07DA31EBC88951995E1C514A")
        
public DisplayNameComparator(PackageManager pm) {
            mPM = pm;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.629 -0500", hash_original_method = "75BF6E8997D323222280B816426CA9D8", hash_generated_method = "F07A48D24789F9CB4DFB3ABD988D9595")
        
public final int compare(ResolveInfo a, ResolveInfo b) {
            CharSequence  sa = a.loadLabel(mPM);
            if (sa == null) sa = a.activityInfo.name;
            CharSequence  sb = b.loadLabel(mPM);
            if (sb == null) sb = b.activityInfo.name;
            
            return sCollator.compare(sa.toString(), sb.toString());
        }
        
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:34:56.613 -0500", hash_original_method = "C265C7C58C207232A576E6DBECFC3E71", hash_generated_method = "D7C990A0F582AB30875ADB820A7D0F47")
    
public void writeToParcel(Parcel dest, int parcelableFlags) {
        if (activityInfo != null) {
            dest.writeInt(1);
            activityInfo.writeToParcel(dest, parcelableFlags);
        } else if (serviceInfo != null) {
            dest.writeInt(2);
            serviceInfo.writeToParcel(dest, parcelableFlags);
        } else {
            dest.writeInt(0);
        }
        if (filter != null) {
            dest.writeInt(1);
            filter.writeToParcel(dest, parcelableFlags);
        } else {
            dest.writeInt(0);
        }
        dest.writeInt(priority);
        dest.writeInt(preferredOrder);
        dest.writeInt(match);
        dest.writeInt(specificIndex);
        dest.writeInt(labelRes);
        TextUtils.writeToParcel(nonLocalizedLabel, dest, parcelableFlags);
        dest.writeInt(icon);
        dest.writeString(resolvePackageName);
        dest.writeInt(system ? 1 : 0);
    }
    // orphaned legacy method
    public ResolveInfo createFromParcel(Parcel source) {
            return new ResolveInfo(source);
        }
    
    // orphaned legacy method
    public ResolveInfo[] newArray(int size) {
            return new ResolveInfo[size];
        }
    
}

