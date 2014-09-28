/*
 * Copyright (C) 2013 The Android Open Source Project
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

package android.printservice;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;

/**
 * This class describes a {@link PrintService}. A print service knows
 * how to communicate with one or more printers over one or more protocols
 * and exposes printers for use by the applications via the platform print
 * APIs.
 *
 * @see PrintService
 * @see android.print.PrintManager
 *
 * @hide
 */
public final class PrintServiceInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.428 -0400", hash_original_field = "65C12B47A4A9F5F276084FA8762D3BCE", hash_generated_field = "6D0A7B717E1E64C3C8B456CE01C58717")

    private static final String LOG_TAG = PrintServiceInfo.class.getSimpleName();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.429 -0400", hash_original_field = "7EC862BA8E6EE5E7CFD466AC46B869E8", hash_generated_field = "5DDAF0D3F385B5C5F779BF9CFDD89DCD")

    private static final String TAG_PRINT_SERVICE = "print-service";

    /**
     * Creates a new instance.
     *
     * @param resolveInfo The service resolve info.
     * @param context Context for accessing resources.
     * @throws XmlPullParserException If a XML parsing error occurs.
     * @throws IOException If a I/O error occurs.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.437 -0400", hash_original_method = "C0F28EFFA12EB925946E5A09D033B9DF", hash_generated_method = "C4670C3CAAA247B824E4F50CA5B3F75B")
    
public static PrintServiceInfo create(ResolveInfo resolveInfo, Context context) {
        String settingsActivityName = null;
        String addPrintersActivityName = null;
        String advancedPrintOptionsActivityName = null;

        XmlResourceParser parser = null;
        PackageManager packageManager = context.getPackageManager();
        parser = resolveInfo.serviceInfo.loadXmlMetaData(packageManager,
                PrintService.SERVICE_META_DATA);
        if (parser != null) {
            try {
                int type = 0;
                while (type != XmlPullParser.END_DOCUMENT && type != XmlPullParser.START_TAG) {
                    type = parser.next();
                }

                String nodeName = parser.getName();
                if (!TAG_PRINT_SERVICE.equals(nodeName)) {
                    Log.e(LOG_TAG, "Ignoring meta-data that does not start with "
                            + TAG_PRINT_SERVICE + " tag");
                } else {
                    Resources resources = packageManager.getResourcesForApplication(
                            resolveInfo.serviceInfo.applicationInfo);
                    AttributeSet allAttributes = Xml.asAttributeSet(parser);
                    TypedArray attributes = resources.obtainAttributes(allAttributes,
                            com.android.internal.R.styleable.PrintService);

                    settingsActivityName = attributes.getString(
                            com.android.internal.R.styleable.PrintService_settingsActivity);

                    addPrintersActivityName = attributes.getString(
                            com.android.internal.R.styleable.PrintService_addPrintersActivity);

                    advancedPrintOptionsActivityName = attributes.getString(com.android.internal
                            .R.styleable.PrintService_advancedPrintOptionsActivity);

                    attributes.recycle();
                }
            } catch (IOException ioe) {
                Log.w(LOG_TAG, "Error reading meta-data:" + ioe);
            } catch (XmlPullParserException xppe) {
                Log.w(LOG_TAG, "Error reading meta-data:" + xppe);
            } catch (NameNotFoundException e) {
                Log.e(LOG_TAG, "Unable to load resources for: "
                        + resolveInfo.serviceInfo.packageName);
            } finally {
                if (parser != null) {
                    parser.close();
                }
            }
        }

        return new PrintServiceInfo(resolveInfo, settingsActivityName,
                addPrintersActivityName, advancedPrintOptionsActivityName);
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.451 -0400", hash_original_field = "2A40D2822EDE7D6F78CF5ED47AC394EC", hash_generated_field = "CFE2FF218F21A03FFDF0A0963CD46562")

    public static final Parcelable.Creator<PrintServiceInfo> CREATOR =
            new Parcelable.Creator<PrintServiceInfo>() {
        @DSSafe(DSCat.SAFE_LIST)
        public PrintServiceInfo createFromParcel(Parcel parcel) {
            return new PrintServiceInfo(parcel);
        }

        public PrintServiceInfo[] newArray(int size) {
            return new PrintServiceInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.430 -0400", hash_original_field = "5AB31FF91690EC0315884BA04F6C543E", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

    private  String mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.431 -0400", hash_original_field = "FE81B4A254792E0F53E0C9AF36C8B686", hash_generated_field = "6B33B1DC79BC09883016E8729764237B")

    private  ResolveInfo mResolveInfo;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.432 -0400", hash_original_field = "1E356AACEE2D50E0C905EA0627229FF1", hash_generated_field = "3227A556BB8D91CC368DE162089FC968")

    private  String mSettingsActivityName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.433 -0400", hash_original_field = "9818E196B5F999EDE237CBAD2D5DCE36", hash_generated_field = "0276D1DE43ADD6012D5E8E81C08F1F0D")

    private  String mAddPrintersActivityName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.434 -0400", hash_original_field = "C27AC3DCA7AB9CA7AC870959C3112C8B", hash_generated_field = "2B673D6C304871E1C9855EEB39DF75BA")

    private  String mAdvancedPrintOptionsActivityName;

    /**
     * Creates a new instance.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.435 -0400", hash_original_method = "0AC7BC23ACF69EF74E5E86783450B001", hash_generated_method = "531FA8041DB3A2DB01E0493F2258E306")
    
public PrintServiceInfo(Parcel parcel) {
        mId = parcel.readString();
        mResolveInfo = parcel.readParcelable(null);
        mSettingsActivityName = parcel.readString();
        mAddPrintersActivityName = parcel.readString();
        mAdvancedPrintOptionsActivityName = parcel.readString();
    }

    /**
     * Creates a new instance.
     *
     * @param resolveInfo The service resolve info.
     * @param settingsActivityName Optional settings activity name.
     * @param addPrintersActivityName Optional add printers activity name.
     * @param advancedPrintOptionsActivityName Optional advanced print options activity.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.436 -0400", hash_original_method = "FCF1FEF981EDB1C83E31C9BD11054CAA", hash_generated_method = "5A8F03B8B34D99EE547B7AC5146576B5")
    
public PrintServiceInfo(ResolveInfo resolveInfo, String settingsActivityName,
            String addPrintersActivityName, String advancedPrintOptionsActivityName) {
        mId = new ComponentName(resolveInfo.serviceInfo.packageName,
                resolveInfo.serviceInfo.name).flattenToString();
        mResolveInfo = resolveInfo;
        mSettingsActivityName = settingsActivityName;
        mAddPrintersActivityName = addPrintersActivityName;
        mAdvancedPrintOptionsActivityName = advancedPrintOptionsActivityName;
    }

    /**
     * The accessibility service id.
     * <p>
     * <strong>Generated by the system.</strong>
     * </p>
     *
     * @return The id.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.438 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "8F9FC8944DF69B66CB8D7A8B6ABB6416")
    
public String getId() {
        return mId;
    }

    /**
     * The service {@link ResolveInfo}.
     *
     * @return The info.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.439 -0400", hash_original_method = "CD70F9B024F94168959F7F67ECCC2D46", hash_generated_method = "C9D0D45F7969AB2459018B24DB336946")
    
public ResolveInfo getResolveInfo() {
        return mResolveInfo;
    }

    /**
     * The settings activity name.
     * <p>
     * <strong>Statically set from
     * {@link PrintService#SERVICE_META_DATA meta-data}.</strong>
     * </p>
     *
     * @return The settings activity name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.440 -0400", hash_original_method = "193585B262D581003491A72A585CC7AB", hash_generated_method = "4412660C2BE872F360536E29B777FE85")
    
public String getSettingsActivityName() {
        return mSettingsActivityName;
    }

    /**
     * The add printers activity name.
     * <p>
     * <strong>Statically set from
     * {@link PrintService#SERVICE_META_DATA meta-data}.</strong>
     * </p>
     *
     * @return The add printers activity name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.441 -0400", hash_original_method = "92AC74E8B6D7726E7F34A8671C1C8346", hash_generated_method = "2EE7F042AA1445A7D04B9B3C6CAA4CF5")
    
public String getAddPrintersActivityName() {
        return mAddPrintersActivityName;
    }

    /**
     * The advanced print options activity name.
     * <p>
     * <strong>Statically set from
     * {@link PrintService#SERVICE_META_DATA meta-data}.</strong>
     * </p>
     *
     * @return The advanced print options activity name.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.442 -0400", hash_original_method = "B13AAE4C66683ABFA06EDB3952357576", hash_generated_method = "05B20D7E69E43E7301969DDCD4266F41")
    
public String getAdvancedOptionsActivityName() {
        return mAdvancedPrintOptionsActivityName;
    }

    /**
     * {@inheritDoc}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.442 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.443 -0400", hash_original_method = "504E961236B35AEDDBC5F43290EB985B", hash_generated_method = "C915BCB2628B4A10B580214E7FDF2C7B")
    
public void writeToParcel(Parcel parcel, int flagz) {
        parcel.writeString(mId);
        parcel.writeParcelable(mResolveInfo, 0);
        parcel.writeString(mSettingsActivityName);
        parcel.writeString(mAddPrintersActivityName);
        parcel.writeString(mAdvancedPrintOptionsActivityName);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.444 -0400", hash_original_method = "E135425950FF107F7B7125D84F0457E8", hash_generated_method = "A46C5793BF9FE3D3B3B16D14744B9A42")
    
@Override
    public int hashCode() {
        return 31 + ((mId == null) ? 0 : mId.hashCode());
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.446 -0400", hash_original_method = "A79EA19CD1269F63FA3E06483C64C58E", hash_generated_method = "206D5E0A50EB17A92EDF05F210DBC2BB")
    
@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        PrintServiceInfo other = (PrintServiceInfo) obj;
        if (mId == null) {
            if (other.mId != null) {
                return false;
            }
        } else if (!mId.equals(other.mId)) {
            return false;
        }
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:50:10.447 -0400", hash_original_method = "BDC863D9269FF01D0114F899DBCAFFA7", hash_generated_method = "E3EAF1237AA8BF7D37696606E301F825")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PrintServiceInfo{");
        builder.append("id=").append(mId);
        builder.append(", resolveInfo=").append(mResolveInfo);
        builder.append(", settingsActivityName=").append(mSettingsActivityName);
        builder.append(", addPrintersActivityName=").append(mAddPrintersActivityName);
        builder.append(", advancedPrintOptionsActivityName=")
                .append(mAdvancedPrintOptionsActivityName);
        builder.append("}");
        return builder.toString();
    }
}
