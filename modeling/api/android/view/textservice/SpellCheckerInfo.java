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


package android.view.textservice;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.util.Slog;
import droidsafe.annotations.*;
import java.io.IOException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Xml;

public final class SpellCheckerInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.760 -0500", hash_original_field = "CAFE3ED6B053B310C3D2FEEBC0BE5344", hash_generated_field = "B9C780B55162E0EEA102B93C8BE1103A")

    private static final String TAG = SpellCheckerInfo.class.getSimpleName();
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.869 -0400", hash_original_field = "7A612228AEBA5D53B0643FEBD5AE3BB8", hash_generated_field = "3A3EE9B5EE70A014F29E533D3D1BDF90")

    public static final Parcelable.Creator<SpellCheckerInfo> CREATOR
            = new Parcelable.Creator<SpellCheckerInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.793 -0500", hash_original_method = "B57052E05D31390D8AC825C45000906A", hash_generated_method = "0657642A1B5397DC3654D5996FDE0020")
        
@Override
        public SpellCheckerInfo createFromParcel(Parcel source) {
            return new SpellCheckerInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.795 -0500", hash_original_method = "923FE0033E87D54E7EAC06D455D52BFB", hash_generated_method = "86D6B807CA3BDC9F1A8EBD2F31BF73F8")
        
@Override
        public SpellCheckerInfo[] newArray(int size) {
            return new SpellCheckerInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.763 -0500", hash_original_field = "6778D731BF0BE2E5E9F46404EEE44664", hash_generated_field = "47A49524DB3D9D5011E27A061CD906FB")

    private  ResolveInfo mService;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.765 -0500", hash_original_field = "5AB31FF91690EC0315884BA04F6C543E", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

    private  String mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.767 -0500", hash_original_field = "52EEF292DE7E8E903809AEE9B517553D", hash_generated_field = "288F27297FDE0055206DB25B18D34AF5")

    private  int mLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.770 -0500", hash_original_field = "1E356AACEE2D50E0C905EA0627229FF1", hash_generated_field = "3227A556BB8D91CC368DE162089FC968")

    private  String mSettingsActivityName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.772 -0500", hash_original_field = "05D4DE1C8543976BB152FA0EF57B7FEE", hash_generated_field = "116F12542346011C049323E2C901D79E")

    private final ArrayList<SpellCheckerSubtype> mSubtypes = new ArrayList<SpellCheckerSubtype>();

    /**
     * Constructor.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.776 -0500", hash_original_method = "6A25F08819F54F2E6B313A58A8CE6D90", hash_generated_method = "9D35229F7D6A115BE581B534FCE2A4B2")
    
public SpellCheckerInfo(Context context, ResolveInfo service)
            throws XmlPullParserException, IOException {
        mService = service;
        ServiceInfo si = service.serviceInfo;
        mId = new ComponentName(si.packageName, si.name).flattenToShortString();

        final PackageManager pm = context.getPackageManager();
        int label = 0;
        String settingsActivityComponent = null;

        XmlResourceParser parser = null;
        try {
            parser = si.loadXmlMetaData(pm, SpellCheckerSession.SERVICE_META_DATA);
            if (parser == null) {
                throw new XmlPullParserException("No "
                        + SpellCheckerSession.SERVICE_META_DATA + " meta-data");
            }

            final Resources res = pm.getResourcesForApplication(si.applicationInfo);
            final AttributeSet attrs = Xml.asAttributeSet(parser);
            int type;
            while ((type=parser.next()) != XmlPullParser.END_DOCUMENT
                    && type != XmlPullParser.START_TAG) {
            }

            final String nodeName = parser.getName();
            if (!"spell-checker".equals(nodeName)) {
                throw new XmlPullParserException(
                        "Meta-data does not start with spell-checker tag");
            }

            TypedArray sa = res.obtainAttributes(attrs,
                    com.android.internal.R.styleable.SpellChecker);
            label = sa.getResourceId(com.android.internal.R.styleable.SpellChecker_label, 0);
            settingsActivityComponent = sa.getString(
                    com.android.internal.R.styleable.SpellChecker_settingsActivity);
            sa.recycle();

            final int depth = parser.getDepth();
            // Parse all subtypes
            while (((type = parser.next()) != XmlPullParser.END_TAG || parser.getDepth() > depth)
                    && type != XmlPullParser.END_DOCUMENT) {
                if (type == XmlPullParser.START_TAG) {
                    final String subtypeNodeName = parser.getName();
                    if (!"subtype".equals(subtypeNodeName)) {
                        throw new XmlPullParserException(
                                "Meta-data in spell-checker does not start with subtype tag");
                    }
                    final TypedArray a = res.obtainAttributes(
                            attrs, com.android.internal.R.styleable.SpellChecker_Subtype);
                    SpellCheckerSubtype subtype = new SpellCheckerSubtype(
                            a.getResourceId(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_label, 0),
                            a.getString(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_subtypeLocale),
                            a.getString(com.android.internal.R.styleable
                                    .SpellChecker_Subtype_subtypeExtraValue));
                    mSubtypes.add(subtype);
                }
            }
        } catch (Exception e) {
            Slog.e(TAG, "Caught exception: " + e);
            throw new XmlPullParserException(
                    "Unable to create context for: " + si.packageName);
        } finally {
            if (parser != null) parser.close();
        }
        mLabel = label;
        mSettingsActivityName = settingsActivityComponent;
    }

    /**
     * Constructor.
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.779 -0500", hash_original_method = "D0DF2452D02A3DC9C8E7C8BB825D11D4", hash_generated_method = "4AB8433D1CB945B91127E8B1113CEEDF")
    
public SpellCheckerInfo(Parcel source) {
        mLabel = source.readInt();
        mId = source.readString();
        mSettingsActivityName = source.readString();
        mService = ResolveInfo.CREATOR.createFromParcel(source);
        source.readTypedList(mSubtypes, SpellCheckerSubtype.CREATOR);
    }

    /**
     * Return a unique ID for this spell checker.  The ID is generated from
     * the package and class name implementing the method.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.781 -0500", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "8F9FC8944DF69B66CB8D7A8B6ABB6416")
    
public String getId() {
        return mId;
    }

    /**
     * Return the component of the service that implements.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.784 -0500", hash_original_method = "A035D08443F3F9853C50476F9CD3E50F", hash_generated_method = "2B97835D1618C71F40A014490410F857")
    
public ComponentName getComponent() {
        return new ComponentName(
                mService.serviceInfo.packageName, mService.serviceInfo.name);
    }

    /**
     * Return the .apk package that implements this.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.786 -0500", hash_original_method = "0C90B853C75D6A321E7BDA40C2595177", hash_generated_method = "6994E25AD1E96805A7C2A499125900C0")
    
public String getPackageName() {
        return mService.serviceInfo.packageName;
    }

    /**
     * Used to package this object into a {@link Parcel}.
     *
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.788 -0500", hash_original_method = "2F472510FA9E87ADC65F29887FB84501", hash_generated_method = "D4D43B62E449729D0528B748A3BE6CB3")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mLabel);
        dest.writeString(mId);
        dest.writeString(mSettingsActivityName);
        mService.writeToParcel(dest, flags);
        dest.writeTypedList(mSubtypes);
    }

    /**
     * Load the user-displayed label for this spell checker.
     *
     * @param pm Supply a PackageManager used to load the spell checker's resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.800 -0500", hash_original_method = "440496C0C039EAF57937C0E12546E16A", hash_generated_method = "23DC341BBB50BCBF088F63F20F68D85D")
    
public CharSequence loadLabel(PackageManager pm) {
        if (mLabel == 0 || pm == null) return "";
        return pm.getText(getPackageName(), mLabel, mService.serviceInfo.applicationInfo);
    }

    /**
     * Load the user-displayed icon for this spell checker.
     *
     * @param pm Supply a PackageManager used to load the spell checker's resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.802 -0500", hash_original_method = "0598EE9DB236F7268C8A7877021962D5", hash_generated_method = "510880B85D007E14A841E542571C558E")
    
public Drawable loadIcon(PackageManager pm) {
        return mService.loadIcon(pm);
    }

    /**
     * Return the raw information about the Service implementing this
     * spell checker.  Do not modify the returned object.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.804 -0500", hash_original_method = "543F99CB65CBDD66082E6D4B92910AC5", hash_generated_method = "1E6E8EA06F8EE7CE7231791DBE1C3740")
    
public ServiceInfo getServiceInfo() {
        return mService.serviceInfo;
    }

    /**
     * Return the class name of an activity that provides a settings UI.
     * You can launch this activity be starting it with
     * an {@link android.content.Intent} whose action is MAIN and with an
     * explicit {@link android.content.ComponentName}
     * composed of {@link #getPackageName} and the class name returned here.
     *
     * <p>A null will be returned if there is no settings activity.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.807 -0500", hash_original_method = "EE56873026FFE7A9D4435487CEBA8D19", hash_generated_method = "B6031419836B6E01A163B6457817552A")
    
public String getSettingsActivity() {
        return mSettingsActivityName;
    }

    /**
     * Return the count of the subtypes.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.809 -0500", hash_original_method = "CC228A570F36729F1778728092FDBD7B", hash_generated_method = "BF3C4168A920856FD17636F2E32450ED")
    
public int getSubtypeCount() {
        return mSubtypes.size();
    }

    /**
     * Return the subtype at the specified index.
     *
     * @param index the index of the subtype to return.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.811 -0500", hash_original_method = "A5CD061EE9765DD17A95FDAD389682DB", hash_generated_method = "3AA7C2644DB0FB4B71EE84D46A25EEFB")
    
public SpellCheckerSubtype getSubtypeAt(int index) {
        return mSubtypes.get(index);
    }

    /**
     * Used to make this class parcelable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:46.814 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }
}

