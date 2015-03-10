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
 * Copyright (C) 2007-2008 The Android Open Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Printer;
import android.util.Xml;

public final class InputMethodInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.816 -0500", hash_original_field = "62F67574D8C9259CD42961B61108D9EF", hash_generated_field = "0D3F383A8AE37AD4A1E896720B0C8651")

    static final String TAG = "InputMethodInfo";
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.618 -0400", hash_original_field = "DEB12F1F6F201D41FBA42CC969CA4837", hash_generated_field = "0C5D3B1B4FDD1347C21CE5B24224A6EF")

    public static final Parcelable.Creator<InputMethodInfo> CREATOR
            = new Parcelable.Creator<InputMethodInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.892 -0500", hash_original_method = "34C1AEE140730DF166077C8E73F0BE76", hash_generated_method = "C27F28F17D48C099A99B45AE9B5CC4F1")
        
@Override
        public InputMethodInfo createFromParcel(Parcel source) {
            return new InputMethodInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.895 -0500", hash_original_method = "49600A5A1FFDA7DAE900783B5989229D", hash_generated_method = "40DA08E9974021036A6A4AED04C66173")
        
@Override
        public InputMethodInfo[] newArray(int size) {
            return new InputMethodInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.819 -0500", hash_original_field = "6778D731BF0BE2E5E9F46404EEE44664", hash_generated_field = "6778D731BF0BE2E5E9F46404EEE44664")

     ResolveInfo mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.821 -0500", hash_original_field = "5AB31FF91690EC0315884BA04F6C543E", hash_generated_field = "5AB31FF91690EC0315884BA04F6C543E")

     String mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.823 -0500", hash_original_field = "1E356AACEE2D50E0C905EA0627229FF1", hash_generated_field = "1E356AACEE2D50E0C905EA0627229FF1")

     String mSettingsActivityName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.826 -0500", hash_original_field = "8430CEC44BF27F97FC3604538A03E5EA", hash_generated_field = "8430CEC44BF27F97FC3604538A03E5EA")

     int mIsDefaultResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.829 -0500", hash_original_field = "5AF8DB68B8B206DB8BE0A0DC07B384C7", hash_generated_field = "21F533BA3E9571D81DF5BF77269CE919")

    private final ArrayList<InputMethodSubtype> mSubtypes = new ArrayList<InputMethodSubtype>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.831 -0500", hash_original_field = "D369A816C7F82094E9D0F8D580327CDB", hash_generated_field = "EB108F753B89051896699C9D79AA6EB9")

    private boolean mIsAuxIme;

    /**
     * Constructor.
     *
     * @param context The Context in which we are parsing the input method.
     * @param service The ResolveInfo returned from the package manager about
     * this input method's component.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.834 -0500", hash_original_method = "89874ED803E39B5F353BEED5B6B29424", hash_generated_method = "A5331662ABD87EC62216535EC54D7A9C")
    
public InputMethodInfo(Context context, ResolveInfo service)
            throws XmlPullParserException, IOException {
        this(context, service, null);
    }

    /**
     * Constructor.
     *
     * @param context The Context in which we are parsing the input method.
     * @param service The ResolveInfo returned from the package manager about
     * this input method's component.
     * @param additionalSubtypes additional subtypes being added to this InputMethodInfo
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.840 -0500", hash_original_method = "889D0140370752FE888ACF7EA3C15BF9", hash_generated_method = "4D259BE7E68CA81255701D6F69117C93")
    
public InputMethodInfo(Context context, ResolveInfo service,
            Map<String, List<InputMethodSubtype>> additionalSubtypesMap)
            throws XmlPullParserException, IOException {
        mService = service;
        ServiceInfo si = service.serviceInfo;
        mId = new ComponentName(si.packageName, si.name).flattenToShortString();
        mIsAuxIme = true;

        PackageManager pm = context.getPackageManager();
        String settingsActivityComponent = null;
        int isDefaultResId = 0;

        XmlResourceParser parser = null;
        try {
            parser = si.loadXmlMetaData(pm, InputMethod.SERVICE_META_DATA);
            if (parser == null) {
                throw new XmlPullParserException("No "
                        + InputMethod.SERVICE_META_DATA + " meta-data");
            }
        
            Resources res = pm.getResourcesForApplication(si.applicationInfo);
            
            AttributeSet attrs = Xml.asAttributeSet(parser);
            
            int type;
            while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG) {
            }
            
            String nodeName = parser.getName();
            if (!"input-method".equals(nodeName)) {
                throw new XmlPullParserException(
                        "Meta-data does not start with input-method tag");
            }
            
            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.InputMethod);
            settingsActivityComponent = sa.getString(
                    com.android.internal.R.styleable.InputMethod_settingsActivity);
            isDefaultResId = sa.getResourceId(
                    com.android.internal.R.styleable.InputMethod_isDefault, 0);
            sa.recycle();

            final int depth = parser.getDepth();
            // Parse all subtypes
            while (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT) {
                if (type == XmlPullParser.START_TAG) {
                    nodeName = parser.getName();
                    if (!"subtype".equals(nodeName)) {
                        throw new XmlPullParserException(
                                "Meta-data in input-method does not start with subtype tag");
                    }
                    final TypedArray a = res.obtainAttributes(
                            attrs, com.android.internal.R.styleable.InputMethod_Subtype);
                    InputMethodSubtype subtype = new InputMethodSubtype(
                            a.getResourceId(com.android.internal.R.styleable
                                    .InputMethod_Subtype_label, 0),
                            a.getResourceId(com.android.internal.R.styleable
                                    .InputMethod_Subtype_icon, 0),
                            a.getString(com.android.internal.R.styleable
                                    .InputMethod_Subtype_imeSubtypeLocale),
                            a.getString(com.android.internal.R.styleable
                                    .InputMethod_Subtype_imeSubtypeMode),
                            a.getString(com.android.internal.R.styleable
                                    .InputMethod_Subtype_imeSubtypeExtraValue),
                            a.getBoolean(com.android.internal.R.styleable
                                    .InputMethod_Subtype_isAuxiliary, false),
                            a.getBoolean(com.android.internal.R.styleable
                                    .InputMethod_Subtype_overridesImplicitlyEnabledSubtype, false));
                    if (!subtype.isAuxiliary()) {
                        mIsAuxIme = false;
                    }
                    mSubtypes.add(subtype);
                }
            }
        } catch (NameNotFoundException e) {
            throw new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
        } finally {
            if (parser != null) parser.close();
        }

        if (mSubtypes.size() == 0) {
            mIsAuxIme = false;
        }

        if (additionalSubtypesMap != null && additionalSubtypesMap.containsKey(mId)) {
            final List<InputMethodSubtype> additionalSubtypes = additionalSubtypesMap.get(mId);
            final int N = additionalSubtypes.size();
            for (int i = 0; i < N; ++i) {
                final InputMethodSubtype subtype = additionalSubtypes.get(i);
                if (!mSubtypes.contains(subtype)) {
                    mSubtypes.add(subtype);
                }
            }
        }
        mSettingsActivityName = settingsActivityComponent;
        mIsDefaultResId = isDefaultResId;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.843 -0500", hash_original_method = "408133FF0ACC2482487194D0CAB563F8", hash_generated_method = "408133FF0ACC2482487194D0CAB563F8")
    
InputMethodInfo(Parcel source) {
        mId = source.readString();
        mSettingsActivityName = source.readString();
        mIsDefaultResId = source.readInt();
        mIsAuxIme = source.readInt() == 1;
        mService = ResolveInfo.CREATOR.createFromParcel(source);
        source.readTypedList(mSubtypes, InputMethodSubtype.CREATOR);
    }

    /**
     * Temporary API for creating a built-in input method.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.847 -0500", hash_original_method = "530FB6E934B0A6A853BD43F0002757A2", hash_generated_method = "1DCF57B9E315E1DD99D42F4C4F004439")
    
public InputMethodInfo(String packageName, String className,
            CharSequence label, String settingsActivity) {
        ResolveInfo ri = new ResolveInfo();
        ServiceInfo si = new ServiceInfo();
        ApplicationInfo ai = new ApplicationInfo();
        ai.packageName = packageName;
        ai.enabled = true;
        si.applicationInfo = ai;
        si.enabled = true;
        si.packageName = packageName;
        si.name = className;
        si.exported = true;
        si.nonLocalizedLabel = label;
        ri.serviceInfo = si;
        mService = ri;
        mId = new ComponentName(si.packageName, si.name).flattenToShortString();
        mSettingsActivityName = settingsActivity;
        mIsDefaultResId = 0;
        mIsAuxIme = false;
    }

    /**
     * Return a unique ID for this input method.  The ID is generated from
     * the package and class name implementing the method.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.849 -0500", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "8F9FC8944DF69B66CB8D7A8B6ABB6416")
    
public String getId() {
        return mId;
    }

    /**
     * Return the .apk package that implements this input method.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.851 -0500", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "6994E25AD1E96805A7C2A499125900C0")
    
public String getPackageName() {
        return mService.serviceInfo.packageName;
    }

    /**
     * Return the class name of the service component that implements
     * this input method.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.854 -0500", hash_original_method = "E07B8397F26D2C3A4747E56AC8F0D204", hash_generated_method = "41E20EE2BC25C2B6141BF6F906B02B30")
    
public String getServiceName() {
        return mService.serviceInfo.name;
    }

    /**
     * Return the raw information about the Service implementing this
     * input method.  Do not modify the returned object.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.856 -0500", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "1E6E8EA06F8EE7CE7231791DBE1C3740")
    
public ServiceInfo getServiceInfo() {
        return mService.serviceInfo;
    }

    /**
     * Return the component of the service that implements this input
     * method.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.858 -0500", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "2B97835D1618C71F40A014490410F857")
    
public ComponentName getComponent() {
        return new ComponentName(mService.serviceInfo.packageName,
                mService.serviceInfo.name);
    }

    /**
     * Load the user-displayed label for this input method.
     * 
     * @param pm Supply a PackageManager used to load the input method's
     * resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.861 -0500", hash_original_method = "DC118FA5C7EE28B6AE7273376F31713A", hash_generated_method = "EEB9E79FEAEC952302B9A8639AC3433B")
    
public CharSequence loadLabel(PackageManager pm) {
        return mService.loadLabel(pm);
    }

    /**
     * Load the user-displayed icon for this input method.
     * 
     * @param pm Supply a PackageManager used to load the input method's
     * resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.864 -0500", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "510880B85D007E14A841E542571C558E")
    
public Drawable loadIcon(PackageManager pm) {
        return mService.loadIcon(pm);
    }

    /**
     * Return the class name of an activity that provides a settings UI for
     * the input method.  You can launch this activity be starting it with
     * an {@link android.content.Intent} whose action is MAIN and with an
     * explicit {@link android.content.ComponentName}
     * composed of {@link #getPackageName} and the class name returned here.
     * 
     * <p>A null will be returned if there is no settings activity associated
     * with the input method.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.866 -0500", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "B6031419836B6E01A163B6457817552A")
    
public String getSettingsActivity() {
        return mSettingsActivityName;
    }

    /**
     * Return the count of the subtypes of Input Method.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.868 -0500", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "BF3C4168A920856FD17636F2E32450ED")
    
public int getSubtypeCount() {
        return mSubtypes.size();
    }

    /**
     * Return the Input Method's subtype at the specified index.
     *
     * @param index the index of the subtype to return.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.871 -0500", hash_original_method = "8DB3E81066DAFF6D6FC518E613D3324D", hash_generated_method = "807F31B73B8D3E51E45512DA80BDAA5E")
    
public InputMethodSubtype getSubtypeAt(int index) {
        return mSubtypes.get(index);
    }

    /**
     * Return the resource identifier of a resource inside of this input
     * method's .apk that determines whether it should be considered a
     * default input method for the system.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.873 -0500", hash_original_method = "D40E950149CD5654CB7133AFB587F871", hash_generated_method = "B5C8A54E71077A04975F58760FA22EF8")
    
public int getIsDefaultResourceId() {
        return mIsDefaultResId;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.875 -0500", hash_original_method = "117DA0E6EED582D5768D87F87FE31C9D", hash_generated_method = "DF96D1CAC5BB279D1DF7727A972DF059")
    
public void dump(Printer pw, String prefix) {
        pw.println(prefix + "mId=" + mId
                + " mSettingsActivityName=" + mSettingsActivityName);
        pw.println(prefix + "mIsDefaultResId=0x"
                + Integer.toHexString(mIsDefaultResId));
        pw.println(prefix + "Service:");
        mService.dump(pw, prefix + "  ");
    }
    
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.878 -0500", hash_original_method = "B1E623174B0D17462D77E01C624BA9A3", hash_generated_method = "0E092B0C4ADC9F686A0086F5A5B939B9")
    
@Override
    public String toString() {
        return "InputMethodInfo{" + mId
                + ", settings: "
                + mSettingsActivityName + "}";
    }

    /**
     * Used to test whether the given parameter object is an
     * {@link InputMethodInfo} and its Id is the same to this one.
     * 
     * @return true if the given parameter object is an
     *         {@link InputMethodInfo} and its Id is the same to this one.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.881 -0500", hash_original_method = "138C64F4407505D90DB7ED842C7A62A7", hash_generated_method = "6A610D9E81F934459216596C533A7934")
    
@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null) return false;

        if (!(o instanceof InputMethodInfo)) return false;

        InputMethodInfo obj = (InputMethodInfo) o;
        return mId.equals(obj.mId);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.883 -0500", hash_original_method = "703EF4DB2908CB7D83260BB6EC0F610D", hash_generated_method = "4FCD02FE98D3F92434A96BCBA49D3148")
    
@Override
    public int hashCode() {
        return mId.hashCode();
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.886 -0500", hash_original_method = "14EC3F96E0FE12EE22A064553C434BBF", hash_generated_method = "8A64FCBA96C7EE38C9CACC4B1BD34E1E")
    
public boolean isAuxiliaryIme() {
        return mIsAuxIme;
    }

    /**
     * Used to package this object into a {@link Parcel}.
     * 
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.889 -0500", hash_original_method = "A776E868EB44985D1E2E0042801983B1", hash_generated_method = "C2DE9E0F9A9BD8C2FF912B558DAB160B")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mId);
        dest.writeString(mSettingsActivityName);
        dest.writeInt(mIsDefaultResId);
        dest.writeInt(mIsAuxIme ? 1 : 0);
        mService.writeToParcel(dest, flags);
        dest.writeTypedList(mSubtypes);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:18.900 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }
}

