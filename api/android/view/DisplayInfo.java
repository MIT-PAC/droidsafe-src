/*
 * Copyright (C) 2012 The Android Open Source Project
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

package android.view;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.res.CompatibilityInfo;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.util.DisplayMetrics;

import libcore.util.Objects;

/**
 * Describes the characteristics of a particular logical display.
 * @hide
 */
public final class DisplayInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.051 -0500", hash_original_field = "6E0D7442AB053AE9DB6EF3D772972E65", hash_generated_field = "3F7429CDD0E8C84C58A4ECC0FCEBD655")

    public static final Creator<DisplayInfo> CREATOR = new Creator<DisplayInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @Override
        public DisplayInfo createFromParcel(Parcel source) {
            return new DisplayInfo(source);
        }

        @Override
        public DisplayInfo[] newArray(int size) {
            return new DisplayInfo[size];
        }
    };

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.115 -0500", hash_original_method = "E0AB45C699C50677F8DC926076C7040C", hash_generated_method = "CD450D55AA135D5B7ECCD40671E17CED")
    
private static String flagsToString(int flags) {
        StringBuilder result = new StringBuilder();
        if ((flags & Display.FLAG_SECURE) != 0) {
            result.append(", FLAG_SECURE");
        }
        if ((flags & Display.FLAG_SUPPORTS_PROTECTED_BUFFERS) != 0) {
            result.append(", FLAG_SUPPORTS_PROTECTED_BUFFERS");
        }
        if ((flags & Display.FLAG_PRIVATE) != 0) {
            result.append(", FLAG_PRIVATE");
        }
        if ((flags & Display.FLAG_PRESENTATION) != 0) {
            result.append(", FLAG_PRESENTATION");
        }
        return result.toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:43.970 -0500", hash_original_field = "F4FBF937CBF6E193197F0B8595121D28", hash_generated_field = "83FB42AE4826133209DE201C1E870AB7")

    public int layerStack;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:43.973 -0500", hash_original_field = "E0CDE1A38A40425C446F52269E5723DC", hash_generated_field = "06C062A47B4E980AE7B4928732A7AB14")

    public int flags;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:43.976 -0500", hash_original_field = "961B4204667A4AE2FF8DD374E6728ADE", hash_generated_field = "6AC5CE4BE311ED1283E9BD812937901E")

    public int type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:43.979 -0500", hash_original_field = "815EECE17AF4BC840D4544A9ECB9EACD", hash_generated_field = "94F51CF62708E9C4165D74975525630C")

    public String address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:43.982 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "D29EB809CD7E712070B86A449A5F2E82")

    public String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:43.990 -0500", hash_original_field = "7CE807E36BC75AA0D5264CFE21852310", hash_generated_field = "DF73B984374B918D6598D5DBE7607D31")

    public int appWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:43.993 -0500", hash_original_field = "80709587F2351351AD6FCDF6BE2105D1", hash_generated_field = "A092D0C23D7784A02AF0091B7263A5D6")

    public int appHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:43.997 -0500", hash_original_field = "664A3B8CBF0022283460AE88D25F9DC2", hash_generated_field = "4D0D089AA3CA024A8555D1AD21EEE51F")

    public int smallestNominalAppWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.000 -0500", hash_original_field = "86F7408E2D8BEAA3A393B302B00364EF", hash_generated_field = "3717F96AD67C666755ED1780FC4A2720")

    public int smallestNominalAppHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.002 -0500", hash_original_field = "12B42CD6DB9D53BAF97837206BDA52EB", hash_generated_field = "07FDE64550EE522C8BEF6E2FCD3CF2F9")

    public int largestNominalAppWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.005 -0500", hash_original_field = "997054BCC9ED94547BC57A4384F67631", hash_generated_field = "9FE594762DD23E397A1ADC363E44E61A")

    public int largestNominalAppHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.008 -0500", hash_original_field = "232AD502A05F52D16C4FACD99AC4D78E", hash_generated_field = "DE274DD1D7B4603A70777750A87BA7E2")

    public int logicalWidth;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.010 -0500", hash_original_field = "50AB90A17511F2A9C09F732C6C619729", hash_generated_field = "B59282D5FECDCCF8B699F6708C949E60")

    public int logicalHeight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.013 -0500", hash_original_field = "91A8EA4C7683046DCD106985F190F36B", hash_generated_field = "492080E4819082962FA53DC5FC57187F")

    public int overscanLeft;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.016 -0500", hash_original_field = "FF0FD7E13AF1F040E68AE7CEA3AA63E4", hash_generated_field = "23EC5BD3D76B55B9ABB3C026A130F75F")

    public int overscanTop;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.018 -0500", hash_original_field = "0BEB98DF44970CF5F8E04DF72EA308F9", hash_generated_field = "5DDD088BB8B159AE8C6167A23C166B9A")

    public int overscanRight;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.020 -0500", hash_original_field = "597A80DFEA24F7C67490CFFDE133D1FF", hash_generated_field = "EBCFCB2EE4B6F5A4D6035B834B124A02")

    public int overscanBottom;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.023 -0500", hash_original_field = "166F903FDFE4F9FAB53262B76DA7C884", hash_generated_field = "F3B3FA4B8371A0544AFC2FFDB04D5643")

    public int rotation;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.026 -0500", hash_original_field = "D69E7D41FE269765CA46446594C58900", hash_generated_field = "851111ED78FD90BFE1F9F0CD61FA529C")

    public float refreshRate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.029 -0500", hash_original_field = "8494C53C97FC79B6311FA8750C5726ED", hash_generated_field = "A3FBD8EFDAFE72385B3F35DC44682C86")

    public int logicalDensityDpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.032 -0500", hash_original_field = "8E93F091DBCD28501D362F84F4555467", hash_generated_field = "31E33DD33261DBC3B5701CE78A4DEEE9")

    public float physicalXDpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.034 -0500", hash_original_field = "4D1846217F780640DDAC27495C51F21C", hash_generated_field = "7BEADE0943D9083797BCAAAD1428A33F")

    public float physicalYDpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.037 -0500", hash_original_field = "E4FE91BC8CC38E7C58D3AED0B34FA884", hash_generated_field = "5D11A13DA6B3BCC0B46946580D0FAFF7")

    public int ownerUid;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.040 -0500", hash_original_field = "89BA640168F750B1770AEE5923827AB5", hash_generated_field = "95EE976995B0B35F49CDE52918FEAFAB")

    public String ownerPackageName;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.054 -0500", hash_original_method = "829DBAA73FC1CCEDA7BADF755A27DB9E", hash_generated_method = "DA9C2247A03A298DF6647E2AFD073050")
    
public DisplayInfo() {
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.057 -0500", hash_original_method = "8774F386B8A1CF611C6A8DADD08DB8A7", hash_generated_method = "940A4BCF7DAF9662DAC76DF13730BDEC")
    
public DisplayInfo(DisplayInfo other) {
        copyFrom(other);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.059 -0500", hash_original_method = "EB68D930E74B4A7AD61B929DAEEB41D4", hash_generated_method = "48A81244548CF111E6EAC191F5483E21")
    
private DisplayInfo(Parcel source) {
        readFromParcel(source);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.062 -0500", hash_original_method = "F9482B41F815001270AA3007F3191ACF", hash_generated_method = "F7BB18D4A2E3F001FB976545DD1000FC")
    
@Override
    public boolean equals(Object o) {
        return o instanceof DisplayInfo && equals((DisplayInfo)o);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.068 -0500", hash_original_method = "A06C395832BF7C387F17237D6E575B82", hash_generated_method = "CA547CCD4771079F7500FCF44B9AF6E6")
    
public boolean equals(DisplayInfo other) {
        return other != null
                && layerStack == other.layerStack
                && flags == other.flags
                && type == other.type
                && Objects.equal(address, other.address)
                && Objects.equal(name, other.name)
                && appWidth == other.appWidth
                && appHeight == other.appHeight
                && smallestNominalAppWidth == other.smallestNominalAppWidth
                && smallestNominalAppHeight == other.smallestNominalAppHeight
                && largestNominalAppWidth == other.largestNominalAppWidth
                && largestNominalAppHeight == other.largestNominalAppHeight
                && logicalWidth == other.logicalWidth
                && logicalHeight == other.logicalHeight
                && overscanLeft == other.overscanLeft
                && overscanTop == other.overscanTop
                && overscanRight == other.overscanRight
                && overscanBottom == other.overscanBottom
                && rotation == other.rotation
                && refreshRate == other.refreshRate
                && logicalDensityDpi == other.logicalDensityDpi
                && physicalXDpi == other.physicalXDpi
                && physicalYDpi == other.physicalYDpi
                && ownerUid == other.ownerUid
                && Objects.equal(ownerPackageName, other.ownerPackageName);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.071 -0500", hash_original_method = "F6E3B6A783333C3A4408872B5A375F65", hash_generated_method = "45D4026AD4A176ACAB5C423377387D4B")
    
@Override
    public int hashCode() {
        return 0; // don't care
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.076 -0500", hash_original_method = "404FCE1FA7929463C012BEE11490C803", hash_generated_method = "E2114227E6F4946C06FCF5E07C814A39")
    
public void copyFrom(DisplayInfo other) {
        layerStack = other.layerStack;
        flags = other.flags;
        type = other.type;
        address = other.address;
        name = other.name;
        appWidth = other.appWidth;
        appHeight = other.appHeight;
        smallestNominalAppWidth = other.smallestNominalAppWidth;
        smallestNominalAppHeight = other.smallestNominalAppHeight;
        largestNominalAppWidth = other.largestNominalAppWidth;
        largestNominalAppHeight = other.largestNominalAppHeight;
        logicalWidth = other.logicalWidth;
        logicalHeight = other.logicalHeight;
        overscanLeft = other.overscanLeft;
        overscanTop = other.overscanTop;
        overscanRight = other.overscanRight;
        overscanBottom = other.overscanBottom;
        rotation = other.rotation;
        refreshRate = other.refreshRate;
        logicalDensityDpi = other.logicalDensityDpi;
        physicalXDpi = other.physicalXDpi;
        physicalYDpi = other.physicalYDpi;
        ownerUid = other.ownerUid;
        ownerPackageName = other.ownerPackageName;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.081 -0500", hash_original_method = "7543AFECA4B0D687BB7A089D811A7FA3", hash_generated_method = "CDAFBE165D3B52D8394E3655C2926682")
    
public void readFromParcel(Parcel source) {
        layerStack = source.readInt();
        flags = source.readInt();
        type = source.readInt();
        address = source.readString();
        name = source.readString();
        appWidth = source.readInt();
        appHeight = source.readInt();
        smallestNominalAppWidth = source.readInt();
        smallestNominalAppHeight = source.readInt();
        largestNominalAppWidth = source.readInt();
        largestNominalAppHeight = source.readInt();
        logicalWidth = source.readInt();
        logicalHeight = source.readInt();
        overscanLeft = source.readInt();
        overscanTop = source.readInt();
        overscanRight = source.readInt();
        overscanBottom = source.readInt();
        rotation = source.readInt();
        refreshRate = source.readFloat();
        logicalDensityDpi = source.readInt();
        physicalXDpi = source.readFloat();
        physicalYDpi = source.readFloat();
        ownerUid = source.readInt();
        ownerPackageName = source.readString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.086 -0500", hash_original_method = "E495FA22FB88D260D0CEB0858D563519", hash_generated_method = "C83B9ACBE6C35CAD8AC0B7FA7392805B")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(layerStack);
        dest.writeInt(this.flags);
        dest.writeInt(type);
        dest.writeString(address);
        dest.writeString(name);
        dest.writeInt(appWidth);
        dest.writeInt(appHeight);
        dest.writeInt(smallestNominalAppWidth);
        dest.writeInt(smallestNominalAppHeight);
        dest.writeInt(largestNominalAppWidth);
        dest.writeInt(largestNominalAppHeight);
        dest.writeInt(logicalWidth);
        dest.writeInt(logicalHeight);
        dest.writeInt(overscanLeft);
        dest.writeInt(overscanTop);
        dest.writeInt(overscanRight);
        dest.writeInt(overscanBottom);
        dest.writeInt(rotation);
        dest.writeFloat(refreshRate);
        dest.writeInt(logicalDensityDpi);
        dest.writeFloat(physicalXDpi);
        dest.writeFloat(physicalYDpi);
        dest.writeInt(ownerUid);
        dest.writeString(ownerPackageName);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.088 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.091 -0500", hash_original_method = "EFC14EDB2BC787B81EAB16D35E905FF1", hash_generated_method = "F2F2DFA2CAF34F8316A762F1C201DD71")
    
public void getAppMetrics(DisplayMetrics outMetrics) {
        getAppMetrics(outMetrics, CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO, null);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.093 -0500", hash_original_method = "6AD70BC62F7676F58ABA18AE79723944", hash_generated_method = "12916E73A395E7F94BF5C0CA11B70D92")
    
public void getAppMetrics(DisplayMetrics outMetrics, DisplayAdjustments displayAdjustments) {
        getMetricsWithSize(outMetrics, displayAdjustments.getCompatibilityInfo(),
                displayAdjustments.getActivityToken(), appWidth, appHeight);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.096 -0500", hash_original_method = "97174EBD4113A6F15E6A548D179E53E3", hash_generated_method = "048546CDF56F3C000538BED3400C9400")
    
public void getAppMetrics(DisplayMetrics outMetrics, CompatibilityInfo ci, IBinder token) {
        getMetricsWithSize(outMetrics, ci, token, appWidth, appHeight);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.098 -0500", hash_original_method = "D747375DFCBF860A899661F35DB49883", hash_generated_method = "96FFE7E92836E4FD6D7E28F9664F84BD")
    
public void getLogicalMetrics(DisplayMetrics outMetrics, CompatibilityInfo compatInfo,
            IBinder token) {
        getMetricsWithSize(outMetrics, compatInfo, token, logicalWidth, logicalHeight);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.101 -0500", hash_original_method = "10E3771031D4118FF68627B607BB1E7D", hash_generated_method = "9440E637850E1D85CD3BC599BE66107D")
    
public int getNaturalWidth() {
        return rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180 ?
                logicalWidth : logicalHeight;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.103 -0500", hash_original_method = "82B4F9C1F4321163900068EC344F5BFD", hash_generated_method = "2CDDF05BA9088A6A965BDA802050FBA3")
    
public int getNaturalHeight() {
        return rotation == Surface.ROTATION_0 || rotation == Surface.ROTATION_180 ?
                logicalHeight : logicalWidth;
    }

    /**
     * Returns true if the specified UID has access to this display.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.105 -0500", hash_original_method = "1BC421727B0F94C50EAEE7BC616B5B58", hash_generated_method = "CE01F05C6786045C2F7150FEB6BADB2E")
    
public boolean hasAccess(int uid) {
        return Display.hasAccess(uid, flags, ownerUid);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.108 -0500", hash_original_method = "E85A104DDD8FAFEA8E1F464E16D00709", hash_generated_method = "D7434D3F06716FD7693D4EB8ED2045F4")
    
private void getMetricsWithSize(DisplayMetrics outMetrics, CompatibilityInfo compatInfo,
            IBinder token, int width, int height) {
        outMetrics.densityDpi = outMetrics.noncompatDensityDpi = logicalDensityDpi;
        outMetrics.noncompatWidthPixels  = outMetrics.widthPixels = width;
        outMetrics.noncompatHeightPixels = outMetrics.heightPixels = height;

        /*
        outMetrics.density = outMetrics.noncompatDensity =
                logicalDensityDpi * DisplayMetrics.DENSITY_DEFAULT_SCALE;
        outMetrics.scaledDensity = outMetrics.noncompatScaledDensity = outMetrics.density;
        outMetrics.xdpi = outMetrics.noncompatXdpi = physicalXDpi;
        outMetrics.ydpi = outMetrics.noncompatYdpi = physicalYDpi;
        */

        if (!compatInfo.equals(CompatibilityInfo.DEFAULT_COMPATIBILITY_INFO)) {
            compatInfo.applyToDisplayMetrics(outMetrics);
        }
    }

    // For debugging purposes
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 13:02:44.113 -0500", hash_original_method = "51AAC4AB5857ED4DE4B2DB711E0D339C", hash_generated_method = "BBA6A87D15C42FF287428CEFEA10EE51")
    
@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DisplayInfo{\"");
        sb.append(name);
        sb.append("\", app ");
        sb.append(appWidth);
        sb.append(" x ");
        sb.append(appHeight);
        sb.append(", real ");
        sb.append(logicalWidth);
        sb.append(" x ");
        sb.append(logicalHeight);
        if (overscanLeft != 0 || overscanTop != 0 || overscanRight != 0 || overscanBottom != 0) {
            sb.append(", overscan (");
            sb.append(overscanLeft);
            sb.append(",");
            sb.append(overscanTop);
            sb.append(",");
            sb.append(overscanRight);
            sb.append(",");
            sb.append(overscanBottom);
            sb.append(")");
        }
        sb.append(", largest app ");
        sb.append(largestNominalAppWidth);
        sb.append(" x ");
        sb.append(largestNominalAppHeight);
        sb.append(", smallest app ");
        sb.append(smallestNominalAppWidth);
        sb.append(" x ");
        sb.append(smallestNominalAppHeight);
        sb.append(", ");
        sb.append(refreshRate);
        sb.append(" fps, rotation");
        sb.append(rotation);
        sb.append(", density ");
        sb.append(logicalDensityDpi);
        sb.append(" (");
        sb.append(physicalXDpi);
        sb.append(" x ");
        sb.append(physicalYDpi);
        sb.append(") dpi, layerStack ");
        sb.append(layerStack);
        sb.append(", type ");
        //sb.append(Display.typeToString(type));
        if (address != null) {
            sb.append(", address ").append(address);
        }
        if (ownerUid != 0 || ownerPackageName != null) {
            sb.append(", owner ").append(ownerPackageName);
            sb.append(" (uid ").append(ownerUid).append(")");
        }
        sb.append(flagsToString(flags));
        sb.append("}");
        return sb.toString();
    }
}
