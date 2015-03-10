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
 * Copyright (C) 2011 The Android Open Source Project
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


package android.view.textservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

public final class SpellCheckerSubtype implements Parcelable {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.428 -0500", hash_original_method = "8E1C6298EB66C275DF3380320723757A", hash_generated_method = "FE94C4A8FECD84D683885278E012F460")
    
private static Locale constructLocaleFromString(String localeStr) {
        if (TextUtils.isEmpty(localeStr))
            return null;
        String[] localeParams = localeStr.split("_", 3);
        // The length of localeStr is guaranteed to always return a 1 <= value <= 3
        // because localeStr is not empty.
        if (localeParams.length == 1) {
            return new Locale(localeParams[0]);
        } else if (localeParams.length == 2) {
            return new Locale(localeParams[0], localeParams[1]);
        } else if (localeParams.length == 3) {
            return new Locale(localeParams[0], localeParams[1], localeParams[2]);
        }
        return null;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.447 -0500", hash_original_method = "C3EB8F3C38068CB5E6BC8AD1B82B692A", hash_generated_method = "AAC5CB824032748E2936F1FF72846D35")
    
private static int hashCodeInternal(String locale, String extraValue) {
        return Arrays.hashCode(new Object[] {locale, extraValue});
    }

    /**
     * Sort the list of subtypes
     * @param context Context will be used for getting localized strings
     * @param flags Flags for the sort order
     * @param sci SpellCheckerInfo of which subtypes are subject to be sorted
     * @param subtypeList List which will be sorted
     * @return Sorted list of subtypes
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.449 -0500", hash_original_method = "A5A1976DCF128376F1184597AC290A44", hash_generated_method = "EFD999286E4154CC4017A058D559EA48")
    
public static List<SpellCheckerSubtype> sort(Context context, int flags, SpellCheckerInfo sci,
            List<SpellCheckerSubtype> subtypeList) {
        if (sci == null) return subtypeList;
        final HashSet<SpellCheckerSubtype> subtypesSet = new HashSet<SpellCheckerSubtype>(
                subtypeList);
        final ArrayList<SpellCheckerSubtype> sortedList = new ArrayList<SpellCheckerSubtype>();
        int N = sci.getSubtypeCount();
        for (int i = 0; i < N; ++i) {
            SpellCheckerSubtype subtype = sci.getSubtypeAt(i);
            if (subtypesSet.contains(subtype)) {
                sortedList.add(subtype);
                subtypesSet.remove(subtype);
            }
        }
        // If subtypes in subtypesSet remain, that means these subtypes are not
        // contained in sci, so the remaining subtypes will be appended.
        for (SpellCheckerSubtype subtype: subtypesSet) {
            sortedList.add(subtype);
        }
        return sortedList;
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.976 -0400", hash_original_field = "5A5854B9FB29CE0EBE5D9E127472BB34", hash_generated_field = "964CF97E5D9081BC2EF059D5B5A4010C")

    public static final Parcelable.Creator<SpellCheckerSubtype> CREATOR
            = new Parcelable.Creator<SpellCheckerSubtype>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.439 -0500", hash_original_method = "0AEF6B6A73DAA67659A967ED2D4E69A6", hash_generated_method = "9610D3FC972D8307808FFBC0303AE5BD")
        
@Override
        public SpellCheckerSubtype createFromParcel(Parcel source) {
            return new SpellCheckerSubtype(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.442 -0500", hash_original_method = "D3DF61D23BE3223F4B9216C6941BE85D", hash_generated_method = "3F6FF8E6BCC27565F0991F50B9A261B3")
        
@Override
        public SpellCheckerSubtype[] newArray(int size) {
            return new SpellCheckerSubtype[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.401 -0500", hash_original_field = "622071262F8C7323916A08E8A5FE5B0F", hash_generated_field = "1C2C808B01EBFBF48626EDEF77BDA121")

    private  int mSubtypeHashCode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.404 -0500", hash_original_field = "4B8E567964882234BB978E7260845CFE", hash_generated_field = "57FC2D78B24F52DDE6BE3F9540A84844")

    private  int mSubtypeNameResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.406 -0500", hash_original_field = "90577A26519101012AB8C79E4EBE45D5", hash_generated_field = "09B229A20252A09636BE45D10E545437")

    private  String mSubtypeLocale;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.408 -0500", hash_original_field = "5A1BB8126BCD812601DD28966BD5A486", hash_generated_field = "8C6B632ACA59D6C798D88A0425FBB914")

    private  String mSubtypeExtraValue;

    /**
     * Constructor
     * @param nameId The name of the subtype
     * @param locale The locale supported by the subtype
     * @param extraValue The extra value of the subtype
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.411 -0500", hash_original_method = "3A30DA6D8D85E7F9D6AFF40F9B2BC528", hash_generated_method = "DA06D75434107847A6D32A2567C0E192")
    
public SpellCheckerSubtype(int nameId, String locale, String extraValue) {
        mSubtypeNameResId = nameId;
        mSubtypeLocale = locale != null ? locale : "";
        mSubtypeExtraValue = extraValue != null ? extraValue : "";
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.414 -0500", hash_original_method = "3B75B8CFEB6B6700A7C113FAE634CC5F", hash_generated_method = "3B75B8CFEB6B6700A7C113FAE634CC5F")
    
SpellCheckerSubtype(Parcel source) {
        String s;
        mSubtypeNameResId = source.readInt();
        s = source.readString();
        mSubtypeLocale = s != null ? s : "";
        s = source.readString();
        mSubtypeExtraValue = s != null ? s : "";
        mSubtypeHashCode = hashCodeInternal(mSubtypeLocale, mSubtypeExtraValue);
    }

    /**
     * @return the name of the subtype
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.416 -0500", hash_original_method = "C7E80880FBF7E5F0758D048854BC1B6A", hash_generated_method = "26CBCDA99AD203B4314FE6FE708C7FDB")
    
public int getNameResId() {
        return mSubtypeNameResId;
    }

    /**
     * @return the locale of the subtype
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.418 -0500", hash_original_method = "945286B5D069547CEB4FBAF8F8B7964A", hash_generated_method = "EE03D54FF1419549D24B5FD49A307399")
    
public String getLocale() {
        return mSubtypeLocale;
    }

    /**
     * @return the extra value of the subtype
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.421 -0500", hash_original_method = "253C17894C35FFAF30C08472F23E48B8", hash_generated_method = "B0B48211E788C5E773FA1B3FFFFC18D8")
    
public String getExtraValue() {
        return mSubtypeExtraValue;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.423 -0500", hash_original_method = "BAAF551B86708907A8B178A5447B667E", hash_generated_method = "59CD8717BAF0B810679FFE0F1F02958C")
    
@Override
    public int hashCode() {
        return mSubtypeHashCode;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.425 -0500", hash_original_method = "214F55EDB23FD4CF8A5A66E21291C440", hash_generated_method = "5F829979AF5B8EC92C3AFE5F8A322D28")
    
@Override
    public boolean equals(Object o) {
        if (o instanceof SpellCheckerSubtype) {
            SpellCheckerSubtype subtype = (SpellCheckerSubtype) o;
            return (subtype.hashCode() == hashCode())
                && (subtype.getNameResId() == getNameResId())
                && (subtype.getLocale().equals(getLocale()))
                && (subtype.getExtraValue().equals(getExtraValue()));
        }
        return false;
    }

    /**
     * @param context Context will be used for getting Locale and PackageManager.
     * @param packageName The package name of the spell checker
     * @param appInfo The application info of the spell checker
     * @return a display name for this subtype. The string resource of the label (mSubtypeNameResId)
     * can have only one %s in it. If there is, the %s part will be replaced with the locale's
     * display name by the formatter. If there is not, this method simply returns the string
     * specified by mSubtypeNameResId. If mSubtypeNameResId is not specified (== 0), it's up to the
     * framework to generate an appropriate display name.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.431 -0500", hash_original_method = "968D29448AF0C4C278C68BBABC30BCB9", hash_generated_method = "D9FE477B4AE71540ABA1B09AB9219FF9")
    
public CharSequence getDisplayName(
            Context context, String packageName, ApplicationInfo appInfo) {
        final Locale locale = constructLocaleFromString(mSubtypeLocale);
        final String localeStr = locale != null ? locale.getDisplayName() : mSubtypeLocale;
        if (mSubtypeNameResId == 0) {
            return localeStr;
        }
        final CharSequence subtypeName = context.getPackageManager().getText(
                packageName, mSubtypeNameResId, appInfo);
        if (!TextUtils.isEmpty(subtypeName)) {
            return String.format(subtypeName.toString(), localeStr);
        } else {
            return localeStr;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.433 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.436 -0500", hash_original_method = "AC1CB8559B86122857E11C69298B0C2C", hash_generated_method = "22B946E482F4438DD7A016CE36C39DCE")
    
@Override
    public void writeToParcel(Parcel dest, int parcelableFlags) {
        dest.writeInt(mSubtypeNameResId);
        dest.writeString(mSubtypeLocale);
        dest.writeString(mSubtypeExtraValue);
    }
}

