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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package android.print;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.HashMap;
import android.util.Log;

import com.android.internal.R;

import java.util.Map;

/**
 * This class represents the attributes of a print job. These attributes
 * describe how the printed content should be laid out. For example, the
 * print attributes may state that the content should be laid out on a
 * letter size with 300 DPI (dots per inch) resolution, have a margin of
 * 10 mills (thousand of an inch) on all sides, and be black and white.
 */
public final class PrintAttributes implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.955 -0400", hash_original_field = "ADADD0C48681BEF5AE5F3AD2515B0F6E", hash_generated_field = "5A98D6AD8D4C98DD7652443E08527395")

    public static final int COLOR_MODE_MONOCHROME = 1 << 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.958 -0400", hash_original_field = "9F620498676E4DF8213127543BDA14DE", hash_generated_field = "1FDDB6044B8D3A247DD4C83589C300E9")

    public static final int COLOR_MODE_COLOR = 1 << 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.961 -0400", hash_original_field = "020733994C172E06268CD54104AA14E2", hash_generated_field = "6FBA2E9E899826583290AD232F15A8A9")

    private static final int VALID_COLOR_MODES =
            COLOR_MODE_MONOCHROME | COLOR_MODE_COLOR;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.372 -0400", hash_original_method = "42E2581142CC722D8D25CB73E7A142B4", hash_generated_method = "0A060E958F44099FF85F1FC0367351FE")
    
static String colorModeToString(int colorMode) {
        switch (colorMode) {
            case COLOR_MODE_MONOCHROME: {
                return "COLOR_MODE_MONOCHROME";
            }
            case COLOR_MODE_COLOR: {
                return "COLOR_MODE_COLOR";
            }
            default:
                return "COLOR_MODE_UNKNOWN";
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.375 -0400", hash_original_method = "3F159CB0DB7780AA68D44A3503B89314", hash_generated_method = "15C1693D599E4F2C0CDEED36A50A2182")
    
static void enforceValidColorMode(int colorMode) {
        if ((colorMode & VALID_COLOR_MODES) == 0 && Integer.bitCount(colorMode) == 1) {
            throw new IllegalArgumentException("invalid color mode: " + colorMode);
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.396 -0400", hash_original_field = "6A9B10F26D12E4C55FA4107BC5DC6330", hash_generated_field = "ED3A86D42748AF19D1430D80810C7758")

    public static final Parcelable.Creator<PrintAttributes> CREATOR =
            new Creator<PrintAttributes>() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public PrintAttributes createFromParcel(Parcel parcel) {
            return new PrintAttributes(parcel);
        }

        @Override
        public PrintAttributes[] newArray(int size) {
            return new PrintAttributes[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.963 -0400", hash_original_field = "8BF484702E2D3461C7D2B38FDD2DD887", hash_generated_field = "A50116D8EFE8D61893A4FB9B1723B5DD")

    private MediaSize mMediaSize;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.966 -0400", hash_original_field = "CA74262ED44761F78DA2933CDD202859", hash_generated_field = "7826E50CB5343C095D071D04E7D1F288")

    private Resolution mResolution;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.968 -0400", hash_original_field = "F5F5695328092EAD015C7E15EA9A68E5", hash_generated_field = "F71C213823FA53BD272F2984637C7076")

    private Margins mMinMargins;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.971 -0400", hash_original_field = "093091989534ED4D7253A5BB2841A4A2", hash_generated_field = "DFF1F8BB6230BEB93A26CDC12D777AFA")

    private int mColorMode;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.973 -0400", hash_original_method = "579888F98B8C6769DE8C64C62058C9D9", hash_generated_method = "75B1410AF7F8E99DDCC27E42AAD9EFBF")
    
PrintAttributes() {
        /* hide constructor */
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.975 -0400", hash_original_method = "67F3A9910972F9694E064857A3E4F47B", hash_generated_method = "BDD11B95BDA85AC9969C0D92C2D4E286")
    
private PrintAttributes(Parcel parcel) {
        mMediaSize = (parcel.readInt() ==  1) ? MediaSize.createFromParcel(parcel) : null;
        mResolution = (parcel.readInt() ==  1) ? Resolution.createFromParcel(parcel) : null;
        mMinMargins = (parcel.readInt() ==  1) ? Margins.createFromParcel(parcel) : null;
        mColorMode = parcel.readInt();
    }

    /**
     * Gets the media size.
     *
     * @return The media size or <code>null</code> if not set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.977 -0400", hash_original_method = "A28E690CFB7D4E84A724DF445CBA89DF", hash_generated_method = "1DBC4B665E9B3B016CBCF3DA933B9861")
    
public MediaSize getMediaSize() {
        return mMediaSize;
    }

    /**
     * Sets the media size.
     *
     * @param The media size.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.980 -0400", hash_original_method = "9A7B8BAD8B46735CD655906251848ADF", hash_generated_method = "53F5AE130661CD489B492F42C59A79C3")
    
public void setMediaSize(MediaSize mediaSize) {
        mMediaSize = mediaSize;
    }

    /**
     * Gets the resolution.
     *
     * @return The resolution or <code>null</code> if not set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.982 -0400", hash_original_method = "26382198FFEE755D1C4EC4BDC4D14E1C", hash_generated_method = "00D77715AD1378AECD56A6A051B8E392")
    
public Resolution getResolution() {
        return mResolution;
    }

    /**
     * Sets the resolution.
     *
     * @param The resolution.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.984 -0400", hash_original_method = "F0DDA5CFC646101201B5B855E52CF6F3", hash_generated_method = "DECD6339E5C4CFBBB65CAFCC2973DF94")
    
public void setResolution(Resolution resolution) {
        mResolution = resolution;
    }

    /**
     * Gets the minimal margins. If the content does not fit
     * these margins it will be clipped.
     *
     * @return The margins or <code>null</code> if not set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.986 -0400", hash_original_method = "5851BF7D0A85DE81A964937AAF572493", hash_generated_method = "707780F4E52B8BE18394035F9CB157A9")
    
public Margins getMinMargins() {
        return mMinMargins;
    }

    /**
     * Sets the minimal margins. If the content does not fit
     * these margins it will be clipped.
     *
     * @param The margins.
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.989 -0400", hash_original_method = "BF7619E0C094B0DEA0968785FA9F5B92", hash_generated_method = "478FE8DFE13288BB743D88BE378D9627")
    
public void setMinMargins(Margins margins) {
        mMinMargins = margins;
    }

    /**
     * Gets the color mode.
     *
     * @return The color mode or zero if not set.
     *
     * @see #COLOR_MODE_COLOR
     * @see #COLOR_MODE_MONOCHROME
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.991 -0400", hash_original_method = "36D12AF97D8587DD3CA677862F4AAD34", hash_generated_method = "994FA1D223BDF2E3402F4149BDD61803")
    
public int getColorMode() {
        return mColorMode;
    }

    /**
     * Sets the color mode.
     *
     * @param The color mode.
     *
     * @see #COLOR_MODE_MONOCHROME
     * @see #COLOR_MODE_COLOR
     *
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.994 -0400", hash_original_method = "CDF564FA286EC99EB8360B13A7F3CE35", hash_generated_method = "FE945225D8C343E92D2498FF988EF98A")
    
public void setColorMode(int colorMode) {
        enforceValidColorMode(colorMode);
        mColorMode = colorMode;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.996 -0400", hash_original_method = "709575250CA6F957ED97C1788C3E08EA", hash_generated_method = "CD0193E028B86292834455BF31891B3C")
    
@Override
    public void writeToParcel(Parcel parcel, int flags) {
        if (mMediaSize != null) {
            parcel.writeInt(1);
            mMediaSize.writeToParcel(parcel);
        } else {
            parcel.writeInt(0);
        }
        if (mResolution != null) {
            parcel.writeInt(1);
            mResolution.writeToParcel(parcel);
        } else {
            parcel.writeInt(0);
        }
        if (mMinMargins != null) {
            parcel.writeInt(1);
            mMinMargins.writeToParcel(parcel);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(mColorMode);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:09.998 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.001 -0400", hash_original_method = "85B4FA9FB2AF66CF71386CFACF9CDD00", hash_generated_method = "CB1A131B0D6B5E412F3B2F06A1C34D6F")
    
@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + mColorMode;
        result = prime * result + ((mMinMargins == null) ? 0 : mMinMargins.hashCode());
        result = prime * result + ((mMediaSize == null) ? 0 : mMediaSize.hashCode());
        result = prime * result + ((mResolution == null) ? 0 : mResolution.hashCode());
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.005 -0400", hash_original_method = "9F49CB3CE4BB5B5C69AB9FFDD3CD133C", hash_generated_method = "E9FFD32A1D7DA3BDDDADACDDE8E6322E")
    
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
        PrintAttributes other = (PrintAttributes) obj;
        if (mColorMode != other.mColorMode) {
            return false;
        }
        if (mMinMargins == null) {
            if (other.mMinMargins != null) {
                return false;
            }
        } else if (!mMinMargins.equals(other.mMinMargins)) {
            return false;
        }
        if (mMediaSize == null) {
            if (other.mMediaSize != null) {
                return false;
            }
        } else if (!mMediaSize.equals(other.mMediaSize)) {
            return false;
        }
        if (mResolution == null) {
            if (other.mResolution != null) {
                return false;
            }
        } else if (!mResolution.equals(other.mResolution)) {
            return false;
        }
        return true;
    }

    /**
     * This class specifies a supported media size. Media size is the
     * dimension of the media on which the content is printed. For
     * example, the {@link #NA_LETTER} media size designates a page
     * with size 8.5" x 11".
     */
    public static final class MediaSize {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.016 -0400", hash_original_field = "2D13CE5A746A7FDD414B6A38BCAC588F", hash_generated_field = "65C555D3E876BDCEC616A16B33011713")

        private static final String LOG_TAG = "MediaSize";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.019 -0400", hash_original_field = "00CA22D7868B54687925CE009BE16159", hash_generated_field = "BC0F269C48FDB05B579DAEFD7251D102")

        private static final Map<String, MediaSize> sIdToMediaSizeMap =
                new HashMap<String, MediaSize>();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.027 -0400", hash_original_field = "926F783369B8B1390736B1CE3718BAA8", hash_generated_field = "DF65CD1BFFB8CE56499C0A58B6A1D93D")

        public static final MediaSize UNKNOWN_PORTRAIT =
                new MediaSize("UNKNOWN_PORTRAIT", "android",
                        R.string.mediasize_unknown_portrait, 1, Integer.MAX_VALUE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.030 -0400", hash_original_field = "7ED8C666E86A02A364A60CA348263F33", hash_generated_field = "833DB8884849DD3472B95E0FC8549D70")

        public static final MediaSize UNKNOWN_LANDSCAPE =
                new MediaSize("UNKNOWN_LANDSCAPE", "android",
                        R.string.mediasize_unknown_landscape, Integer.MAX_VALUE, 1);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.034 -0400", hash_original_field = "EF4EA1AB2318D29B0517276CBEA011BB", hash_generated_field = "92815A03C01B499AA9EF35B077E2ADC1")

        /** ISO A0 media size: 841mm x 1189mm (33.11" x 46.81") */
        public static final MediaSize ISO_A0 =
                new MediaSize("ISO_A0", "android", R.string.mediasize_iso_a0, 33110, 46810);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.036 -0400", hash_original_field = "8E5D1D2534C98625B165D9B5FFF88EF4", hash_generated_field = "420D56B88D8D671141F66FF5B82FDBAD")

        public static final MediaSize ISO_A1 =
                new MediaSize("ISO_A1", "android", R.string.mediasize_iso_a1, 23390, 33110);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.039 -0400", hash_original_field = "2BE6EB971C5EB437802FD4DCC8B3552E", hash_generated_field = "C7C66F98D31C83C9B4CDF45E632B5CFF")

        public static final MediaSize ISO_A2 =
                new MediaSize("ISO_A2", "android", R.string.mediasize_iso_a2, 16540, 23390);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.042 -0400", hash_original_field = "77185E36066E578411D2ED1EDA4536D6", hash_generated_field = "077DE32270906885B7C36C687A3082D2")

        public static final MediaSize ISO_A3 =
                new MediaSize("ISO_A3", "android", R.string.mediasize_iso_a3, 11690, 16540);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.044 -0400", hash_original_field = "7687701A02AB1B1949F8499A81A93279", hash_generated_field = "EC93EB8DADF0D190E5B43F579E0AE9B7")

        public static final MediaSize ISO_A4 =
                new MediaSize("ISO_A4", "android", R.string.mediasize_iso_a4, 8270, 11690);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.047 -0400", hash_original_field = "CD802E33E1E9B2C9B0034FE4D2FF23BB", hash_generated_field = "C0CAA28D9F7AFA93AC848D716AB56B91")

        public static final MediaSize ISO_A5 =
                new MediaSize("ISO_A5", "android", R.string.mediasize_iso_a5, 5830, 8270);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.049 -0400", hash_original_field = "FE37D67434D522953D2B51CE83BB4525", hash_generated_field = "945E0013BBC023BC24F6625F03EBD0BA")

        public static final MediaSize ISO_A6 =
                new MediaSize("ISO_A6", "android", R.string.mediasize_iso_a6, 4130, 5830);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.052 -0400", hash_original_field = "BE71450BB4F2E0EF5569B080ECBB0A30", hash_generated_field = "62D774CFFF703CA4686E5C96ABD35F18")

        public static final MediaSize ISO_A7 =
                new MediaSize("ISO_A7", "android", R.string.mediasize_iso_a7, 2910, 4130);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.055 -0400", hash_original_field = "D24D0637874F0CABAF5BF08C978E364A", hash_generated_field = "B22017074472AF497C8ED89708759B78")

        public static final MediaSize ISO_A8 =
                new MediaSize("ISO_A8", "android", R.string.mediasize_iso_a8, 2050, 2910);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.057 -0400", hash_original_field = "5693B232679A665D276DBF8FAAA731E9", hash_generated_field = "5A0FC4256389F123C9447B69C20DF2A7")

        public static final MediaSize ISO_A9 =
                new MediaSize("ISO_A9", "android", R.string.mediasize_iso_a9, 1460, 2050);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.060 -0400", hash_original_field = "040A1322EE56A0082CF95A0FCF628613", hash_generated_field = "438491BCF3A02F49AC8E19B3C3292EB3")

        public static final MediaSize ISO_A10 =
                new MediaSize("ISO_A10", "android", R.string.mediasize_iso_a10, 1020, 1460);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.063 -0400", hash_original_field = "46E02F3495268BE6656E9DB0521B57F1", hash_generated_field = "C2D02EDC25DB5E4722A0E72EBE5F23CD")

        public static final MediaSize ISO_B0 =
                new MediaSize("ISO_B0", "android", R.string.mediasize_iso_b0, 39370, 55670);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.065 -0400", hash_original_field = "6B3ED5E487A69E821EB66698529D7100", hash_generated_field = "0427ED6C8C7604C0B5BF7A86E0248FA6")

        public static final MediaSize ISO_B1 =
                new MediaSize("ISO_B1", "android", R.string.mediasize_iso_b1, 27830, 39370);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.068 -0400", hash_original_field = "6770CC9F94EEFCCD06F2C33317D556E3", hash_generated_field = "6C3E3FD3126DCEF69EA69C029EF53871")

        public static final MediaSize ISO_B2 =
                new MediaSize("ISO_B2", "android", R.string.mediasize_iso_b2, 19690, 27830);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.070 -0400", hash_original_field = "C5B6FD93264E1B6D1E01DA975358E459", hash_generated_field = "47B01CFADA135259A6053025D5CDF83E")

        public static final MediaSize ISO_B3 =
                new MediaSize("ISO_B3", "android", R.string.mediasize_iso_b3, 13900, 19690);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.073 -0400", hash_original_field = "D7F337ED0B307D338F36145D7DD22387", hash_generated_field = "302EDCE3BB903EA74FAC8CD560D4555C")

        public static final MediaSize ISO_B4 =
                new MediaSize("ISO_B4", "android", R.string.mediasize_iso_b4, 9840, 13900);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.076 -0400", hash_original_field = "89B5D171237D0B12D24F556926422536", hash_generated_field = "E6D29924413F290A51C15B8B57A71534")

        public static final MediaSize ISO_B5 =
                new MediaSize("ISO_B5", "android", R.string.mediasize_iso_b5, 6930, 9840);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.079 -0400", hash_original_field = "3E29697C9DEF2E9C5E100272A0BBED03", hash_generated_field = "B33845FC980CC3CC5F05D073FB5C552A")

        public static final MediaSize ISO_B6 =
                new MediaSize("ISO_B6", "android", R.string.mediasize_iso_b6, 4920, 6930);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.081 -0400", hash_original_field = "B4204F6CE339F4387BFE30702F3CD73F", hash_generated_field = "E30B2668062BC30BBAAA00D760CB5EFE")

        public static final MediaSize ISO_B7 =
                new MediaSize("ISO_B7", "android", R.string.mediasize_iso_b7, 3460, 4920);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.083 -0400", hash_original_field = "D7392BF243A9EC6C6978146AB36B7787", hash_generated_field = "A4BAF190F127FA35B0466C0A679109EC")

        public static final MediaSize ISO_B8 =
                new MediaSize("ISO_B8", "android", R.string.mediasize_iso_b8, 2440, 3460);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.087 -0400", hash_original_field = "7173A8AD1C49A565199F26FA5C658BE9", hash_generated_field = "EFC8AB40DD267BB930E484E13B737E56")

        public static final MediaSize ISO_B9 =
                new MediaSize("ISO_B9", "android", R.string.mediasize_iso_b9, 1730, 2440);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.089 -0400", hash_original_field = "8115C045BF2B184072EEC9822AB8E32D", hash_generated_field = "B9CE308AC63627FAF316AC25CFC56889")

        public static final MediaSize ISO_B10 =
                new MediaSize("ISO_B10", "android", R.string.mediasize_iso_b10, 1220, 1730);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.091 -0400", hash_original_field = "2DE0632C5F9A8B9711116CBC3A34EA4F", hash_generated_field = "CCC683CE60128BAAD0D350228A951A32")

        public static final MediaSize ISO_C0 =
                new MediaSize("ISO_C0", "android", R.string.mediasize_iso_c0, 36100, 51060);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.094 -0400", hash_original_field = "E330442629B30FE9226E866E05EE9B23", hash_generated_field = "3B2896EE87FBBA6E1442E1B2AAB4BFCE")

        public static final MediaSize ISO_C1 =
                new MediaSize("ISO_C1", "android", R.string.mediasize_iso_c1, 25510, 36100);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.096 -0400", hash_original_field = "836311C0A1EB086A521D8BCB9A07246A", hash_generated_field = "C4BA47F4AAD68106A22548F72278C8C4")

        public static final MediaSize ISO_C2 =
                new MediaSize("ISO_C2", "android", R.string.mediasize_iso_c2, 18030, 25510);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.099 -0400", hash_original_field = "F14B1C53949EB9ECE892DAAC64EBD588", hash_generated_field = "CF07A2CF2154E49703CD3C7690EBFA04")

        public static final MediaSize ISO_C3 =
                new MediaSize("ISO_C3", "android", R.string.mediasize_iso_c3, 12760, 18030);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.101 -0400", hash_original_field = "8DF80C7B7349A152095E37FCD23EB8B2", hash_generated_field = "B2C6886FD5BFB45591A4F8E8AB253624")

        public static final MediaSize ISO_C4 =
                new MediaSize("ISO_C4", "android", R.string.mediasize_iso_c4, 9020, 12760);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.104 -0400", hash_original_field = "66345419B005C98523FDEC61083E0161", hash_generated_field = "8821B9E5C682AA3A910B92BCE5A0DFBE")

        public static final MediaSize ISO_C5 =
                new MediaSize("ISO_C5", "android", R.string.mediasize_iso_c5, 6380, 9020);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.107 -0400", hash_original_field = "9652F1D0666AFE0830ACFF74A8C85809", hash_generated_field = "F6F2622A0096A8C7E24AA176AE8D0D57")

        public static final MediaSize ISO_C6 =
                new MediaSize("ISO_C6", "android", R.string.mediasize_iso_c6, 4490, 6380);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.109 -0400", hash_original_field = "62176D8DE252C730F9E728FE4E23101C", hash_generated_field = "9310C3B2305F79C414A8C7FA4B15E30F")

        public static final MediaSize ISO_C7 =
                new MediaSize("ISO_C7", "android", R.string.mediasize_iso_c7, 3190, 4490);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.112 -0400", hash_original_field = "2D7E7FA14F2F50AAE82389807B80E0E6", hash_generated_field = "77369678FB397C1BC28D1C853AFD7287")

        public static final MediaSize ISO_C8 =
                new MediaSize("ISO_C8", "android", R.string.mediasize_iso_c8, 2240, 3190);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.114 -0400", hash_original_field = "E33FFC32BE21F34DE146620ACBEBAEAE", hash_generated_field = "A02FDEA91661E4ABC8CC9889C824A9A4")

        public static final MediaSize ISO_C9 =
                new MediaSize("ISO_C9", "android", R.string.mediasize_iso_c9, 1570, 2240);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.116 -0400", hash_original_field = "7B3C9FEE3B5497A3CFED4F59943C5478", hash_generated_field = "F11C6521741A1661DCB97D7D5C960FB8")

        public static final MediaSize ISO_C10 =
                new MediaSize("ISO_C10", "android", R.string.mediasize_iso_c10, 1100, 1570);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.119 -0400", hash_original_field = "CCEA5FE2BB1BA87B09DEB4413B7FA764", hash_generated_field = "1CEB16DF36F8C499348DFF33BBBF8C3D")

        /** North America Letter media size: 8.5" x 11" (279mm x 216mm) */
        public static final MediaSize NA_LETTER =
                new MediaSize("NA_LETTER", "android", R.string.mediasize_na_letter, 8500, 11000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.121 -0400", hash_original_field = "BC380F29AA196B70B8AC424B53D1A0BE", hash_generated_field = "473349D6533ED9F9C63BADB2142A1BE2")

        public static final MediaSize NA_GOVT_LETTER =
                new MediaSize("NA_GOVT_LETTER", "android",
                        R.string.mediasize_na_gvrnmt_letter, 8000, 10500);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.124 -0400", hash_original_field = "F45CE7E9E0A76E370D2DCE8FA770D9AF", hash_generated_field = "11CE07DEB05D6320CE5892D3E148AE70")

        public static final MediaSize NA_LEGAL =
                new MediaSize("NA_LEGAL", "android", R.string.mediasize_na_legal, 8500, 14000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.126 -0400", hash_original_field = "15EE1E1FF9B9F5FFE2BA5547E5677C28", hash_generated_field = "44CFE67A2A8EB38674352DACE9ACE84C")

        public static final MediaSize NA_JUNIOR_LEGAL =
                new MediaSize("NA_JUNIOR_LEGAL", "android",
                        R.string.mediasize_na_junior_legal, 8000, 5000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.128 -0400", hash_original_field = "E4FD05F9ADF1289B79E122FF7C3BECF4", hash_generated_field = "2632001963F3A098AFCB800F788FBA96")

        public static final MediaSize NA_LEDGER =
                new MediaSize("NA_LEDGER", "android", R.string.mediasize_na_ledger, 17000, 11000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.130 -0400", hash_original_field = "00D4D0BEECD56B2C69FC7EE3887A3E0C", hash_generated_field = "B51A179B9FDAE3AC69CF7F47E4963303")

        public static final MediaSize NA_TABLOID =
                new MediaSize("NA_TABLOID", "android",
                        R.string.mediasize_na_tabloid, 11000, 17000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.132 -0400", hash_original_field = "8F23DDFB05A33D747819E8B290F9ADE6", hash_generated_field = "E22217D695627E25EA7361B549B11BAE")

        public static final MediaSize NA_INDEX_3X5 =
                new MediaSize("NA_INDEX_3X5", "android",
                        R.string.mediasize_na_index_3x5, 3000, 5000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.135 -0400", hash_original_field = "F87AFFFF66F100644ADA85FF30708F03", hash_generated_field = "99E92098C1976FDDC8F383DB2E75CDB3")

        public static final MediaSize NA_INDEX_4X6 =
                new MediaSize("NA_INDEX_4X6", "android",
                        R.string.mediasize_na_index_4x6, 4000, 6000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.138 -0400", hash_original_field = "ADE65DA90B11ED45D05152680F9A3C2B", hash_generated_field = "378B95E742152CED80B0496B4359C208")

        public static final MediaSize NA_INDEX_5X8 =
                new MediaSize("NA_INDEX_5X8", "android",
                        R.string.mediasize_na_index_5x8, 5000, 8000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.140 -0400", hash_original_field = "685900209FCE8053FCC905AFDB659C52", hash_generated_field = "1F354ACFB79CEF35327EED24F69E8F8E")

        public static final MediaSize NA_MONARCH =
                new MediaSize("NA_MONARCH", "android",
                        R.string.mediasize_na_monarch, 7250, 10500);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.143 -0400", hash_original_field = "FAA9F0E58173D081F61B38B2BFD55C1C", hash_generated_field = "6A943C0B92BDA320321EC8C7519E3764")

        public static final MediaSize NA_QUARTO =
                new MediaSize("NA_QUARTO", "android",
                        R.string.mediasize_na_quarto, 8000, 10000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.145 -0400", hash_original_field = "DD1FFF8D6A2C404AE8ED7E85A5C4E687", hash_generated_field = "AFDD58F579DF8439B9BB28C50DEBCF2F")

        public static final MediaSize NA_FOOLSCAP =
                new MediaSize("NA_FOOLSCAP", "android",
                        R.string.mediasize_na_foolscap, 8000, 13000);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.147 -0400", hash_original_field = "E9845053A59FAE7C0D99CCB7BBC2215B", hash_generated_field = "B6B426DB276168838E9B0BD21C35E5EF")

        /** Chinese ROC 8K media size: 270mm x 390mm (10.629" x 15.3543") */
        public static final MediaSize ROC_8K =
                new MediaSize("ROC_8K", "android",
                        R.string.mediasize_chinese_roc_8k, 10629, 15354);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.150 -0400", hash_original_field = "E26B4AA59AA9C41E06A1440F927D55A3", hash_generated_field = "9C87322CDD41D1C923655B7EB14A2564")

        public static final MediaSize ROC_16K =
                new MediaSize("ROC_16K", "android",
                        R.string.mediasize_chinese_roc_16k, 7677, 10629);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.152 -0400", hash_original_field = "4B1EA7D80BBC73CC776D1B3B5BCB1B86", hash_generated_field = "625970C4789945F3D3DABE983003A44B")

        public static final MediaSize PRC_1 =
                new MediaSize("PRC_1", "android",
                        R.string.mediasize_chinese_prc_1, 4015, 6496);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.154 -0400", hash_original_field = "6C05C2FD67A8456BA60019771F3662AB", hash_generated_field = "741C4E58EA2C46607B3ABF844F75DC44")

        public static final MediaSize PRC_2 =
                new MediaSize("PRC_2", "android",
                        R.string.mediasize_chinese_prc_2, 4015, 6929);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.157 -0400", hash_original_field = "C1373E6031C0AB26BAB3BEED525F05AD", hash_generated_field = "76684A5DE9AF13DEFE0D2581B573F4B9")

        public static final MediaSize PRC_3 =
                new MediaSize("PRC_3", "android",
                        R.string.mediasize_chinese_prc_3, 4921, 6929);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.160 -0400", hash_original_field = "66D588193B30CF0439DE3318F8E37AB6", hash_generated_field = "7FACA225868CDE2718626D44EDBF9C73")

        public static final MediaSize PRC_4 =
                new MediaSize("PRC_4", "android",
                        R.string.mediasize_chinese_prc_4, 4330, 8189);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.162 -0400", hash_original_field = "AB3144BA13F36C10E90F347B1BA33DA9", hash_generated_field = "0E4DE9CF4F994D5641C4340549163D33")

        public static final MediaSize PRC_5 =
                new MediaSize("PRC_5", "android",
                        R.string.mediasize_chinese_prc_5, 4330, 8661);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.165 -0400", hash_original_field = "98D5CFA4454F8BCA8A3E1940B944BF5D", hash_generated_field = "CD7EAB8DAEDB72CEBC217ADBC7ECD8D5")

        public static final MediaSize PRC_6 =
                new MediaSize("PRC_6", "android",
                        R.string.mediasize_chinese_prc_6, 4724, 12599);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.167 -0400", hash_original_field = "B91B7280BD023D828823A5C1D0A9A1E8", hash_generated_field = "427B4A55FA1A08F1940788FB5B2511A0")

        public static final MediaSize PRC_7 =
                new MediaSize("PRC_7", "android",
                        R.string.mediasize_chinese_prc_7, 6299, 9055);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.169 -0400", hash_original_field = "B5D06F95B33D8CA949D92008FBB56040", hash_generated_field = "4933DDF754BEEF7F24953B5AF00C97FB")

        public static final MediaSize PRC_8 =
                new MediaSize("PRC_8", "android",
                        R.string.mediasize_chinese_prc_8, 4724, 12165);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.172 -0400", hash_original_field = "DC52A0DC159A3BC8FC892075AEAC1F8B", hash_generated_field = "0E9A0038BF5E5C9E605EDC671269E11A")

        public static final MediaSize PRC_9 =
                new MediaSize("PRC_9", "android",
                        R.string.mediasize_chinese_prc_9, 9016, 12756);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.174 -0400", hash_original_field = "5C6C8539DA0BE495022C1A911104673A", hash_generated_field = "EBA7DBEEC3BD446633214FF23DD9BE84")

        public static final MediaSize PRC_10 =
                new MediaSize("PRC_10", "android",
                        R.string.mediasize_chinese_prc_10, 12756, 18032);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.176 -0400", hash_original_field = "DA7F1DAEB9FEDA25FEDB646A3497C6BA", hash_generated_field = "B6C71368BD87EF9C174514400E7279C5")

        public static final MediaSize PRC_16K =
                new MediaSize("PRC_16K", "android",
                        R.string.mediasize_chinese_prc_16k, 5749, 8465);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.179 -0400", hash_original_field = "5969D85231F29C8140081B0F475F7891", hash_generated_field = "A15C6512AD03F0C93334A68F392CA768")

        public static final MediaSize OM_PA_KAI =
                new MediaSize("OM_PA_KAI", "android",
                        R.string.mediasize_chinese_om_pa_kai, 10512, 15315);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.181 -0400", hash_original_field = "A703AE2B5C50902753C07630C04AF373", hash_generated_field = "A683663FB19E14AF2CD4A83F16E96ABE")

        public static final MediaSize OM_DAI_PA_KAI =
                new MediaSize("OM_DAI_PA_KAI", "android",
                        R.string.mediasize_chinese_om_dai_pa_kai, 10827, 15551);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.184 -0400", hash_original_field = "44475981A5E5EF81EA071CF1CF669A40", hash_generated_field = "7E9691C845BD8D1FDC0C00A8B15EBE3C")

        public static final MediaSize OM_JUURO_KU_KAI =
                new MediaSize("OM_JUURO_KU_KAI", "android",
                        R.string.mediasize_chinese_om_jurro_ku_kai, 7796, 10827);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.186 -0400", hash_original_field = "A8564DD3A7007B2D2718EECDFBD6E147", hash_generated_field = "71EC20BFD8AA51094A7D28ADEF055418")

        /** Japanese JIS B10 media size: 32mm x 45mm (1.259" x 1.772") */
        public static final MediaSize JIS_B10 =
                new MediaSize("JIS_B10", "android",
                        R.string.mediasize_japanese_jis_b10, 1259, 1772);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.200 -0400", hash_original_field = "0101FB77826AD1FFC5A0C592C25558B4", hash_generated_field = "E1F3BD8958474D186947ECD9FD2995AA")

        public static final MediaSize JIS_B9 =
                new MediaSize("JIS_B9", "android",
                        R.string.mediasize_japanese_jis_b9, 1772, 2520);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.202 -0400", hash_original_field = "EE9EE028690822C8F400F2D5242A4769", hash_generated_field = "E083F4697AF9F0C3CB51028B1A4746A0")

        public static final MediaSize JIS_B8 =
                new MediaSize("JIS_B8", "android",
                        R.string.mediasize_japanese_jis_b8, 2520, 3583);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.205 -0400", hash_original_field = "D15092E3F4EE3D00921DCE0EBB6E0A98", hash_generated_field = "D0B697301EDADD911A80647D4731BC0F")

        public static final MediaSize JIS_B7 =
                new MediaSize("JIS_B7", "android",
                        R.string.mediasize_japanese_jis_b7, 3583, 5049);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.207 -0400", hash_original_field = "77033D1C9ADC6428F033F26BD3AD550C", hash_generated_field = "064C65A471FC354DE27DA1AB2F2DF14A")

        public static final MediaSize JIS_B6 =
                new MediaSize("JIS_B6", "android",
                        R.string.mediasize_japanese_jis_b6, 5049, 7165);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.209 -0400", hash_original_field = "8F066E35B8DDA931AA7C70FA44807BF5", hash_generated_field = "C15A72B61E82BF2A659BB5C835F97071")

        public static final MediaSize JIS_B5 =
                new MediaSize("JIS_B5", "android",
                        R.string.mediasize_japanese_jis_b5, 7165, 10118);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.212 -0400", hash_original_field = "6A879AF300C8E05DF4132F6A624ABDF7", hash_generated_field = "D780F3E82A4F22916D112D17F76DFF18")

        public static final MediaSize JIS_B4 =
                new MediaSize("JIS_B4", "android",
                        R.string.mediasize_japanese_jis_b4, 10118, 14331);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.215 -0400", hash_original_field = "9E326EF900EDD5C4AE6D31DFC90A1FFE", hash_generated_field = "39207A4D28ED09B3986A88BF7EADBE82")

        public static final MediaSize JIS_B3 =
                new MediaSize("JIS_B3", "android",
                        R.string.mediasize_japanese_jis_b3, 14331, 20276);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.217 -0400", hash_original_field = "701D9AB150FEE2788903DFB648ACF518", hash_generated_field = "46D1521E7B2A0AED4CEA3FE6B7B69289")

        public static final MediaSize JIS_B2 =
                new MediaSize("JIS_B2", "android",
                        R.string.mediasize_japanese_jis_b2, 20276, 28661);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.219 -0400", hash_original_field = "FCB1B10A803DF5985482ED7D387DE2BE", hash_generated_field = "2ADBBEF8C34A32D3D08CA64E84453853")

        public static final MediaSize JIS_B1 =
                new MediaSize("JIS_B1", "android",
                        R.string.mediasize_japanese_jis_b1, 28661, 40551);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.221 -0400", hash_original_field = "2DCF6F828681F4A8D8D6C18C88C09FDA", hash_generated_field = "AAA7EFCDB45551D16BB113C63C2895FD")

        public static final MediaSize JIS_B0 =
                new MediaSize("JIS_B0", "android",
                        R.string.mediasize_japanese_jis_b0, 40551, 57323);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.223 -0400", hash_original_field = "D6F8CF8CE9479AF7BE860B44E12DAA52", hash_generated_field = "64C82CA389A181BBFFD73B8B4CC6916A")

        public static final MediaSize JIS_EXEC =
                new MediaSize("JIS_EXEC", "android",
                        R.string.mediasize_japanese_jis_exec, 8504, 12992);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.226 -0400", hash_original_field = "A308ED2CCB6FA2BB2EB646AD4B13C942", hash_generated_field = "8AC8182AE78900A68433B74F21E303AB")

        public static final MediaSize JPN_CHOU4 =
                new MediaSize("JPN_CHOU4", "android",
                        R.string.mediasize_japanese_chou4, 3543, 8071);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.230 -0400", hash_original_field = "DBE4EE62AA63EC1D4AAE6293F2D26174", hash_generated_field = "1E11C934CE0AECF653930E86A3E41FB0")

        public static final MediaSize JPN_CHOU3 =
                new MediaSize("JPN_CHOU3", "android",
                        R.string.mediasize_japanese_chou3, 4724, 9252);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.232 -0400", hash_original_field = "31FE65324BC1FBD823D208774F9A46FE", hash_generated_field = "8BF1F5564724E386A8B0DBA22AAA5AD5")

        public static final MediaSize JPN_CHOU2 =
                new MediaSize("JPN_CHOU2", "android",
                        R.string.mediasize_japanese_chou2, 4374, 5748);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.234 -0400", hash_original_field = "E8C767D51E8FA6EE3F8699AE47CEB6FD", hash_generated_field = "F90E006E85B42FE72338801A109E9E0F")

        public static final MediaSize JPN_HAGAKI =
                new MediaSize("JPN_HAGAKI", "android",
                        R.string.mediasize_japanese_hagaki, 3937, 5827);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.237 -0400", hash_original_field = "860AEF2484E7AB66CCC7363345CE6F60", hash_generated_field = "7666D28283C9380F279302AA66FA6C17")

        public static final MediaSize JPN_OUFUKU =
                new MediaSize("JPN_OUFUKU", "android",
                        R.string.mediasize_japanese_oufuku, 5827, 7874);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.239 -0400", hash_original_field = "A630D9F6FD4B254742FA2596220F897E", hash_generated_field = "CAAB522E3BC647CEC9FF9A163D0F4A5D")

        public static final MediaSize JPN_KAHU =
                new MediaSize("JPN_KAHU", "android",
                        R.string.mediasize_japanese_kahu, 9449, 12681);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.242 -0400", hash_original_field = "D621A284D68E26D42E39C80FEA038970", hash_generated_field = "D91FA8B9F4609503D02FE6F326A881C8")

        public static final MediaSize JPN_KAKU2 =
                new MediaSize("JPN_KAKU2", "android",
                        R.string.mediasize_japanese_kaku2, 9449, 13071);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.244 -0400", hash_original_field = "E1AD9AB9D0324507ACB45E59B30C7C90", hash_generated_field = "D7D11A78405D563DD19EB6AF3C1B325F")

        public static final MediaSize JPN_YOU4 =
                new MediaSize("JPN_YOU4", "android",
                        R.string.mediasize_japanese_you4, 4134, 9252);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.285 -0400", hash_original_method = "D9D3A7E9D09722DFDE2B52CBAD7BF814", hash_generated_method = "816B90FB9247FB71C598B45AF5008DEC")
        
static MediaSize createFromParcel(Parcel parcel) {
            return new MediaSize(
                    parcel.readString(),
                    parcel.readString(),
                    parcel.readString(),
                    parcel.readInt(),
                    parcel.readInt(),
                    parcel.readInt());
        }

        /**
         * Gets a standard media size given its id.
         *
         * @param id The media size id.
         * @return The media size for the given id or null.
         *
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.294 -0400", hash_original_method = "D20B668A19FC61D5B999AE0796551562", hash_generated_method = "60823D54096D3A15DED6114F2780F8F9")
        
public static MediaSize getStandardMediaSizeById(String id) {
            return sIdToMediaSizeMap.get(id);
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.246 -0400", hash_original_field = "5AB31FF91690EC0315884BA04F6C543E", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

        private  String mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.248 -0400", hash_original_field = "5D623CBCF86992E0D7786DE12566196C", hash_generated_field = "7652D99469DF3C047DFF79EA17D51D4F")

        public  String mLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.250 -0400", hash_original_field = "7A5990DF4A54BF373C395B6501E20B02", hash_generated_field = "082250E8650A50C15AA8A23F7E9582D3")

        public  String mPackageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.252 -0400", hash_original_field = "526C5F443F3F1154457A2E6238D0A82F", hash_generated_field = "FAD7658229A4421E79AFD38CD1AAC248")

        public  int mLabelResId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.254 -0400", hash_original_field = "25BA3E5274A1ACDD5088FFF06E744B92", hash_generated_field = "E515A9CFBAB6C2F36FB223DC15CD172B")

        private  int mWidthMils;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.256 -0400", hash_original_field = "16DC8A13945A8C1D25C41A7500520782", hash_generated_field = "054A78D8FF0226C23F71B198FB03EF47")

        private  int mHeightMils;

        /**
         * Creates a new instance.
         *
         * @param id The unique media size id.
         * @param packageName The name of the creating package.
         * @param labelResId The resource if of a human readable label.
         * @param widthMils The width in mils (thousands of an inch).
         * @param heightMils The height in mils (thousands of an inch).
         *
         * @throws IllegalArgumentException If the id is empty or the label
         * is empty or the widthMils is less than or equal to zero or the
         * heightMils is less than or equal to zero.
         *
         * @hide
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.260 -0400", hash_original_method = "DBEC9AC5A3B34AE6BBC13F1EAAFA0FDB", hash_generated_method = "E7C02AA8E45A37D67C7D4898A9DC3500")
        
public MediaSize(String id, String packageName, int labelResId,
                int widthMils, int heightMils) {
            if (TextUtils.isEmpty(id)) {
                throw new IllegalArgumentException("id cannot be empty.");
            }
            if (TextUtils.isEmpty(packageName)) {
                throw new IllegalArgumentException("packageName cannot be empty.");
            }
            if (labelResId <= 0) {
                throw new IllegalArgumentException("labelResId must be greater than zero.");
            }
            if (widthMils <= 0) {
                throw new IllegalArgumentException("widthMils "
                        + "cannot be less than or equal to zero.");
            }
            if (heightMils <= 0) {
                throw new IllegalArgumentException("heightMils "
                       + "cannot be less than or euqual to zero.");
            }
            mPackageName = packageName;
            mId = id;
            mLabelResId = labelResId;
            mWidthMils = widthMils;
            mHeightMils = heightMils;
            mLabel = null;

            // Build this mapping only for predefined media sizes.
            sIdToMediaSizeMap.put(mId, this);
        }

        /**
         * Creates a new instance.
         *
         * @param id The unique media size id. It is unique amongst other media sizes
         *        supported by the printer.
         * @param label The <strong>localized</strong> human readable label.
         * @param widthMils The width in mils (thousands of an inch).
         * @param heightMils The height in mils (thousands of an inch).
         *
         * @throws IllegalArgumentException If the id is empty or the label is empty
         * or the widthMils is less than or equal to zero or the heightMils is less
         * than or equal to zero.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.264 -0400", hash_original_method = "BFC6FDCDD15FDA47B15A63C97E605E05", hash_generated_method = "E7FAAFC0A00F060C36DADC3B1DED7FE6")
        
public MediaSize(String id, String label, int widthMils, int heightMils) {
            if (TextUtils.isEmpty(id)) {
                throw new IllegalArgumentException("id cannot be empty.");
            }
            if (TextUtils.isEmpty(label)) {
                throw new IllegalArgumentException("label cannot be empty.");
            }
            if (widthMils <= 0) {
                throw new IllegalArgumentException("widthMils "
                        + "cannot be less than or equal to zero.");
            }
            if (heightMils <= 0) {
                throw new IllegalArgumentException("heightMils "
                       + "cannot be less than or euqual to zero.");
            }
            mId = id;
            mLabel = label;
            mWidthMils = widthMils;
            mHeightMils = heightMils;
            mLabelResId = 0;
            mPackageName = null;
        }

        /** @hide */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.266 -0400", hash_original_method = "4EEFA2FFB14C5938C12E0B493F279B0F", hash_generated_method = "847EE7080ABF2F68A8FFF83CACEEFC41")
        
public MediaSize(String id, String label, String packageName,
                int widthMils, int heightMils, int labelResId) {
            mPackageName = packageName;
            mId = id;
            mLabelResId = labelResId;
            mWidthMils = widthMils;
            mHeightMils = heightMils;
            mLabel = label;
        }

        /**
         * Gets the unique media size id. It is unique amongst other media sizes
         * supported by the printer.
         * <p>
         * This id is defined by the client that generated the media size
         * instance and should not be interpreted by other parties.
         * </p>
         *
         * @return The unique media size id.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.268 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "8F9FC8944DF69B66CB8D7A8B6ABB6416")
        
public String getId() {
            return mId;
        }

        /**
         * Gets the human readable media size label.
         *
         * @param packageManager The package manager for loading the label.
         * @return The human readable label.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.271 -0400", hash_original_method = "679483DD9937EF5B5D0A4DFC1F252ADE", hash_generated_method = "1CBEB8EEF97C7BD06ACF0091962B2E14")
        
public String getLabel(PackageManager packageManager) {
            if (!TextUtils.isEmpty(mPackageName) && mLabelResId > 0) {
                try {
                    return packageManager.getResourcesForApplication(
                            mPackageName).getString(mLabelResId);
                } catch (NotFoundException nfe) {
                    Log.w(LOG_TAG, "Could not load resouce" + mLabelResId
                            + " from package " + mPackageName);
                } catch (NameNotFoundException nnfee) {
                    Log.w(LOG_TAG, "Could not load resouce" + mLabelResId
                            + " from package " + mPackageName);
                }
            }
            return mLabel;
        }

        /**
         * Gets the media width in mils (thousands of an inch).
         *
         * @return The media width.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.273 -0400", hash_original_method = "CAC4F9247C9504E09EA66DEA1BB1ED1A", hash_generated_method = "8F83D9C488AB6B4409A9FFEF0488E24A")
        
public int getWidthMils() {
            return mWidthMils;
        }

        /**
         * Gets the media height in mils (thousands of an inch).
         *
         * @return The media height.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.274 -0400", hash_original_method = "AEB174CD8E809F3B0D3524F91D83E34E", hash_generated_method = "9D49DDF19A83D16CA5B9E7B3E0E911F2")
        
public int getHeightMils() {
            return mHeightMils;
        }

        /**
         * Gets whether this media size is in portrait which is the
         * height is greater or equal to the width.
         *
         * @return True if the media size is in portrait, false if
         * it is in landscape.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.276 -0400", hash_original_method = "08C317BDC8285190F2AC301E6C0D0898", hash_generated_method = "B137EE2164366D1C4100E2586B9D52DF")
        
public boolean isPortrait() {
            return mHeightMils >= mWidthMils;
        }

        /**
         * Returns a new media size instance in a portrait orientation,
         * which is the height is the greater dimension.
         *
         * @return New instance in landscape orientation if this one
         * is in landscape, otherwise this instance.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.279 -0400", hash_original_method = "DA4C09BDA6B054227417A77E4BD22C5C", hash_generated_method = "59B33FBE6FEB2F39476D20162A46CCAF")
        
public MediaSize asPortrait() {
            if (isPortrait()) {
                return this;
            }
            return new MediaSize(mId, mLabel, mPackageName,
                    Math.min(mWidthMils, mHeightMils),
                    Math.max(mWidthMils, mHeightMils),
                    mLabelResId);
        }

        /**
         * Returns a new media size instance in a landscape orientation,
         * which is the height is the lesser dimension.
         *
         * @return New instance in landscape orientation if this one
         * is in portrait, otherwise this instance.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.281 -0400", hash_original_method = "94C7CB9923A91019CD46D1D318199A81", hash_generated_method = "5F31D4D19317A8E4B5AF030A72090CB3")
        
public MediaSize asLandscape() {
            if (!isPortrait()) {
                return this;
            }
            return new MediaSize(mId, mLabel, mPackageName,
                    Math.max(mWidthMils, mHeightMils),
                    Math.min(mWidthMils, mHeightMils),
                    mLabelResId);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.283 -0400", hash_original_method = "701DF914B112FAC312E879FC1ADB5FEB", hash_generated_method = "701DF914B112FAC312E879FC1ADB5FEB")
        
void writeToParcel(Parcel parcel) {
            parcel.writeString(mId);
            parcel.writeString(mLabel);
            parcel.writeString(mPackageName);
            parcel.writeInt(mWidthMils);
            parcel.writeInt(mHeightMils);
            parcel.writeInt(mLabelResId);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.287 -0400", hash_original_method = "7531984B00547FD3991B9CB62AD08F3E", hash_generated_method = "506A1CCF795B5383BF62D4C5E2854A79")
        
@Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + mWidthMils;
            result = prime * result + mHeightMils;
            return result;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.290 -0400", hash_original_method = "03D597ED7E98885AF9A90C57B588B58B", hash_generated_method = "6C7472F117952C58BDB9F172A3ED4DFE")
        
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
            MediaSize other = (MediaSize) obj;
            if (mWidthMils != other.mWidthMils) {
                return false;
            }
            if (mHeightMils != other.mHeightMils) {
                return false;
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.292 -0400", hash_original_method = "49741E838D0B14A6AF9325B9D185FB93", hash_generated_method = "63FC56CBD1981D901E2AA25804EFA1F7")
        
@Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("MediaSize{");
            builder.append("id: ").append(mId);
            builder.append(", label: ").append(mLabel);
            builder.append(", packageName: ").append(mPackageName);
            builder.append(", heightMils: ").append(mHeightMils);
            builder.append(", widthMils: ").append(mWidthMils);
            builder.append(", labelResId: ").append(mLabelResId);
            builder.append("}");
            return builder.toString();
        }
    }

    /**
     * This class specifies a supported resolution in DPI (dots per inch).
     * Resolution defines how many points with different color can be placed
     * on one inch in horizontal or vertical direction of the target media.
     * For example, a printer with 600 DPI can produce higher quality images
     * the one with 300 DPI resolution.
     */
    public static final class Resolution {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.329 -0400", hash_original_method = "A0D24BFBAD92B95CD502CB71F699F132", hash_generated_method = "AB3A6FD7C6310B80FE01DC2D16DC12E5")
        
static Resolution createFromParcel(Parcel parcel) {
            return new Resolution(
                    parcel.readString(),
                    parcel.readString(),
                    parcel.readInt(),
                    parcel.readInt());
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.309 -0400", hash_original_field = "5AB31FF91690EC0315884BA04F6C543E", hash_generated_field = "34D624C7CD290D72B15AB814BF1BA854")

        private  String mId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.311 -0400", hash_original_field = "5D623CBCF86992E0D7786DE12566196C", hash_generated_field = "E99BBC07DBFDC8DED9A95F9F182A2FA4")

        private  String mLabel;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.313 -0400", hash_original_field = "2D10BF4A8D4D2A109D73DC339231942D", hash_generated_field = "36594BA7DE0102BAB3DCF90E70A325E9")

        private  int mHorizontalDpi;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.315 -0400", hash_original_field = "C6DDF48241AD0731685F615EE78C98A0", hash_generated_field = "E7C8A32029594F9B7607D717FF074966")

        private  int mVerticalDpi;

        /**
         * Creates a new instance.
         *
         * @param id The unique resolution id. It is unique amongst other resolutions
         *        supported by the printer.
         * @param label The <strong>localized</strong> human readable label.
         * @param horizontalDpi The horizontal resolution in DPI (dots per inch).
         * @param verticalDpi The vertical resolution in DPI (dots per inch).
         *
         * @throws IllegalArgumentException If the id is empty or the label is empty
         * or the horizontalDpi is less than or equal to zero or the verticalDpi is
         * less than or equal to zero.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.318 -0400", hash_original_method = "6ED420CF552A86625F93410A37AE84F2", hash_generated_method = "2F8A160491D2810787A3AB449FF5BB11")
        
public Resolution(String id, String label, int horizontalDpi, int verticalDpi) {
            if (TextUtils.isEmpty(id)) {
                throw new IllegalArgumentException("id cannot be empty.");
            }
            if (TextUtils.isEmpty(label)) {
                throw new IllegalArgumentException("label cannot be empty.");
            }
            if (horizontalDpi <= 0) {
                throw new IllegalArgumentException("horizontalDpi "
                        + "cannot be less than or equal to zero.");
            }
            if (verticalDpi <= 0) {
                throw new IllegalArgumentException("verticalDpi"
                       + " cannot be less than or equal to zero.");
            }
            mId = id;
            mLabel = label;
            mHorizontalDpi = horizontalDpi;
            mVerticalDpi = verticalDpi;
        }

        /**
         * Gets the unique resolution id. It is unique amongst other resolutions
         * supported by the printer.
         * <p>
         * This id is defined by the client that generated the resolution
         * instance and should not be interpreted by other parties.
         * </p>
         *
         * @return The unique resolution id.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.319 -0400", hash_original_method = "89A68E81BC93C5F428177630DB2A624A", hash_generated_method = "8F9FC8944DF69B66CB8D7A8B6ABB6416")
        
public String getId() {
            return mId;
        }

        /**
         * Gets the resolution human readable label.
         *
         * @return The human readable label.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.321 -0400", hash_original_method = "D24F8C43FDA8FA651CC7D7CBC2E3D58B", hash_generated_method = "54E4D5CEB2CD6C4618FA3D2B41721D50")
        
public String getLabel() {
            return mLabel;
        }

        /**
         * Gets the horizontal resolution in DPI (dots per inch).
         *
         * @return The horizontal resolution.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.323 -0400", hash_original_method = "AE5C2A92F334C6B07001F3D5C989B376", hash_generated_method = "D7F70F72138C0FAA03BADDABEC7AC9F1")
        
public int getHorizontalDpi() {
            return mHorizontalDpi;
        }

        /**
         * Gets the vertical resolution in DPI (dots per inch).
         *
         * @return The vertical resolution.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.325 -0400", hash_original_method = "F3419F4373F922FCF9750CEF11967D5F", hash_generated_method = "54123661806D1AA49888FA7FE53FC9A4")
        
public int getVerticalDpi() {
            return mVerticalDpi;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.327 -0400", hash_original_method = "B5AD401ADE0BE7069974430025CA074B", hash_generated_method = "B5AD401ADE0BE7069974430025CA074B")
        
void writeToParcel(Parcel parcel) {
            parcel.writeString(mId);
            parcel.writeString(mLabel);
            parcel.writeInt(mHorizontalDpi);
            parcel.writeInt(mVerticalDpi);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.331 -0400", hash_original_method = "DB1592A93195C1BD59772D6EF9B01E2B", hash_generated_method = "D29C25ECF5304704E319D1E02ADE6092")
        
@Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + mHorizontalDpi;
            result = prime * result + mVerticalDpi;
            return result;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.334 -0400", hash_original_method = "B8866F3A9BEA2B26716170ADB7CAEFB6", hash_generated_method = "27B21D6633FC4A08722A4CCAE4FCFECE")
        
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
            Resolution other = (Resolution) obj;
            if (mHorizontalDpi != other.mHorizontalDpi) {
                return false;
            }
            if (mVerticalDpi != other.mVerticalDpi) {
                return false;
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.336 -0400", hash_original_method = "CFCE5F40738ECE6A34C7BA4293905F9E", hash_generated_method = "2D032B24BA8EC19CDA58B8AB386DB77C")
        
@Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Resolution{");
            builder.append("id: ").append(mId);
            builder.append(", label: ").append(mLabel);
            builder.append(", horizontalDpi: ").append(mHorizontalDpi);
            builder.append(", verticalDpi: ").append(mVerticalDpi);
            builder.append("}");
            return builder.toString();
        }
    }

    /**
     * This class specifies content margins. Margins define the white space
     * around the content where the left margin defines the amount of white
     * space on the left of the content and so on.
     */
    public static final class Margins {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.341 -0400", hash_original_field = "2CF669DBEF3D8B957DC1B7502DD1948E", hash_generated_field = "754D4700176350BD4F2862EF038C9F8C")

        public static final Margins NO_MARGINS = new Margins(0,  0,  0,  0);

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.362 -0400", hash_original_method = "56936B279E049ACA746A9638D86D9683", hash_generated_method = "F5776918642BEF75335DC3BD15CC4220")
        
static Margins createFromParcel(Parcel parcel) {
            return new Margins(
                    parcel.readInt(),
                    parcel.readInt(),
                    parcel.readInt(),
                    parcel.readInt());
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.343 -0400", hash_original_field = "DD8CCE654CE927B232BDBEC2F40C4C2F", hash_generated_field = "7A699D4D3400442235CB1FA67AADAC41")

        private  int mLeftMils;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.345 -0400", hash_original_field = "899CE36BED98E0DB67E534B58F330AE6", hash_generated_field = "6A607DD8D891066A04F075825B1C0FA8")

        private  int mTopMils;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.346 -0400", hash_original_field = "D1082A43BBF4FFB5A00D256A2D881F9D", hash_generated_field = "276327311A0F79C86616DFA92FB70EAD")

        private  int mRightMils;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.349 -0400", hash_original_field = "ABB7E8346BDCC5173F6A5C893C71DA4E", hash_generated_field = "7F9D12B39758B5BA90C2FE939CF2AE33")

        private  int mBottomMils;

        /**
         * Creates a new instance.
         *
         * @param leftMils The left margin in mils (thousands of an inch).
         * @param topMils The top margin in mils (thousands of an inch).
         * @param rightMils The right margin in mils (thousands of an inch).
         * @param bottomMils The bottom margin in mils (thousands of an inch).
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.351 -0400", hash_original_method = "700D599D8FCCF9508C63F0B3E10B4D0F", hash_generated_method = "2429F5976B0374845A4A492DA80D5599")
        
public Margins(int leftMils, int topMils, int rightMils, int bottomMils) {
            mTopMils = topMils;
            mLeftMils = leftMils;
            mRightMils = rightMils;
            mBottomMils = bottomMils;
        }

        /**
         * Gets the left margin in mils (thousands of an inch).
         *
         * @return The left margin.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.353 -0400", hash_original_method = "429C90F0CF6A278BED292BDDD706F3A5", hash_generated_method = "B4BB7F916E6F6643660CC8768A04E022")
        
public int getLeftMils() {
            return mLeftMils;
        }

        /**
         * Gets the top margin in mils (thousands of an inch).
         *
         * @return The top margin.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.355 -0400", hash_original_method = "1EC2D2DC240C79361B2A37DABBBFC87F", hash_generated_method = "E069D639883FD334A85A8C0949808809")
        
public int getTopMils() {
            return mTopMils;
        }

        /**
         * Gets the right margin in mils (thousands of an inch).
         *
         * @return The right margin.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.357 -0400", hash_original_method = "EA6A14FC131C0A6E404E17DC8E8A74E2", hash_generated_method = "1D3556208AD7A64EBD9B02CCA59B5540")
        
public int getRightMils() {
            return mRightMils;
        }

        /**
         * Gets the bottom margin in mils (thousands of an inch).
         *
         * @return The bottom margin.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.358 -0400", hash_original_method = "23C9EBA245176B411F03B98E5381E75F", hash_generated_method = "FA345AAFF59E828CD006231F5CA9D2B3")
        
public int getBottomMils() {
            return mBottomMils;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.360 -0400", hash_original_method = "E1067143D494238C437121D8A84AF190", hash_generated_method = "E1067143D494238C437121D8A84AF190")
        
void writeToParcel(Parcel parcel) {
            parcel.writeInt(mLeftMils);
            parcel.writeInt(mTopMils);
            parcel.writeInt(mRightMils);
            parcel.writeInt(mBottomMils);
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.364 -0400", hash_original_method = "4A789B7BAA0784FB93ACA2738F83408C", hash_generated_method = "FDDB7C0075EFC3E69DB7523C6D7327AD")
        
@Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + mBottomMils;
            result = prime * result + mLeftMils;
            result = prime * result + mRightMils;
            result = prime * result + mTopMils;
            return result;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.366 -0400", hash_original_method = "C222FF0142CA43047EAA74CB6053BFB2", hash_generated_method = "1FD041C179857AF59DED4709CEE84C17")
        
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
            Margins other = (Margins) obj;
            if (mBottomMils != other.mBottomMils) {
                return false;
            }
            if (mLeftMils != other.mLeftMils) {
                return false;
            }
            if (mRightMils != other.mRightMils) {
                return false;
            }
            if (mTopMils != other.mTopMils) {
                return false;
            }
            return true;
        }

        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.369 -0400", hash_original_method = "408D385BED488693019463AF396AB966", hash_generated_method = "DD24E2E617FE15491B35B2C44C399970")
        
@Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("Margins{");
            builder.append("leftMils: ").append(mLeftMils);
            builder.append(", topMils: ").append(mTopMils);
            builder.append(", rightMils: ").append(mRightMils);
            builder.append(", bottomMils: ").append(mBottomMils);
            builder.append("}");
            return builder.toString();
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.008 -0400", hash_original_method = "4E7C4CD856EE63829D72B62A3F0A77D7", hash_generated_method = "389CEBC8EF22D9758A2712C552731816")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PrintAttributes{");
        builder.append("mediaSize: ").append(mMediaSize);
        if (mMediaSize != null) {
            builder.append(", orientation: ").append(mMediaSize.isPortrait()
                    ? "portrait" : "landscape");
        } else {
            builder.append(", orientation: ").append("null");
        }
        builder.append(", resolution: ").append(mResolution);
        builder.append(", minMargins: ").append(mMinMargins);
        builder.append(", colorMode: ").append(colorModeToString(mColorMode));
        builder.append("}");
        return builder.toString();
    }

    /** @hide */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.010 -0400", hash_original_method = "3CEE95034D5FAD61D0B16577386DE00A", hash_generated_method = "837AFE40D1EC0F9EB237867B84FE0337")
    
public void clear() {
        mMediaSize = null;
        mResolution = null;
        mMinMargins = null;
        mColorMode = 0;
    }

    /**
     * Builder for creating {@link PrintAttributes}.
     */
    public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.378 -0400", hash_original_field = "E39ECD079607463AF221EA2B981A49EF", hash_generated_field = "BBB88E3B33AEC8A3A85169502EAB7674")

        private final PrintAttributes mAttributes = new PrintAttributes();

        /**
         * Sets the media size.
         *
         * @param mediaSize The media size.
         * @return This builder.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.380 -0400", hash_original_method = "6BE538D23A8C81E86D1C3376A5E7D30C", hash_generated_method = "6A7A250E619E5DE31BFE72AB57079650")
        
public Builder setMediaSize(MediaSize mediaSize) {
            mAttributes.setMediaSize(mediaSize);
            return this;
        }

        /**
         * Sets the resolution.
         *
         * @param resolution The resolution.
         * @return This builder.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.382 -0400", hash_original_method = "DECB5A7922F59C370C13545FB76489FC", hash_generated_method = "5724417060231C9F92137E8E46D167FC")
        
public Builder setResolution(Resolution resolution) {
            mAttributes.setResolution(resolution);
            return this;
        }

        /**
         * Sets the minimal margins. If the content does not fit
         * these margins it will be clipped.
         *
         * @param margins The margins.
         * @return This builder.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.384 -0400", hash_original_method = "CE74C737B353CCA2F20A907074CD11BB", hash_generated_method = "20EC382FDFFA93834C7780E1D5CAAB66")
        
public Builder setMinMargins(Margins margins) {
            mAttributes.setMinMargins(margins);
            return this;
        }

        /**
         * Sets the color mode.
         *
         * @param colorMode A valid color mode or zero.
         * @return This builder.
         *
         * @see PrintAttributes#COLOR_MODE_MONOCHROME
         * @see PrintAttributes#COLOR_MODE_COLOR
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.386 -0400", hash_original_method = "106C9A08C183715955BABC2F6BE00730", hash_generated_method = "E190833F03822356DACFE4BEECB6B1DF")
        
public Builder setColorMode(int colorMode) {
            if (Integer.bitCount(colorMode) > 1) {
                throw new IllegalArgumentException("can specify at most one colorMode bit.");
            }
            mAttributes.setColorMode(colorMode);
            return this;
        }

        /**
         * Creates a new {@link PrintAttributes} instance.
         *
         * @return The new instance.
         */
        @DSSafe(DSCat.SAFE_LIST)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.387 -0400", hash_original_method = "DA3684E3D16470606958F88F1E26F4AB", hash_generated_method = "DC9F6299A21C8E4FF32DDC441ED986DE")
        
public PrintAttributes build() {
            return mAttributes;
        }
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 08:48:10.012 -0400", hash_original_method = "2FF45C542C3F0DCE8523FAAB87A0BEC7", hash_generated_method = "81A0FF950EA38A4AF579B7971509533F")
    
public void copyFrom(PrintAttributes other) {
        mMediaSize = other.mMediaSize;
        mResolution = other.mResolution;
        mMinMargins = other.mMinMargins;
        mColorMode = other.mColorMode;
    }
}
