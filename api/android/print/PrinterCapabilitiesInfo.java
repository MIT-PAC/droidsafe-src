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

package android.print;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcel;
import android.os.Parcelable;
import android.print.PrintAttributes.Margins;
import android.print.PrintAttributes.MediaSize;
import android.print.PrintAttributes.Resolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * This class represents the capabilities of a printer. Instances
 * of this class are created by a print service to report the
 * capabilities of a printer it manages. The capabilities of a
 * printer specify how it can print content. For example, what
 * are the media sizes supported by the printer, what are the
 * minimal margins of the printer based on its technical design,
 * etc.
 */
public final class PrinterCapabilitiesInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.662 -0400", hash_original_field = "44D98F50438138C4AC7FD77935688089", hash_generated_field = "AB447CE9F376575BF8AECBD4CA862D13")

    public static final int DEFAULT_UNDEFINED = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.663 -0400", hash_original_field = "D3BB328B79546F00CAA7B7B172799950", hash_generated_field = "C35DCEE9A703EA15037E1493174739D6")

    private static final int PROPERTY_MEDIA_SIZE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.664 -0400", hash_original_field = "331F9C961E06F15DF4F7CE892CFD8278", hash_generated_field = "06AC2CF275E0A5FA1D206F37F0EABB8B")

    private static final int PROPERTY_RESOLUTION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.665 -0400", hash_original_field = "1D8305A782F16EF1BBF42DE09C729B6B", hash_generated_field = "8774CEFD5FA25DF8243D49263F68C96C")

    private static final int PROPERTY_COLOR_MODE = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.666 -0400", hash_original_field = "5CB239801A716752634001EDCA81E2BA", hash_generated_field = "6FE1718D6037B5B9C55188B6D92247DD")

    private static final int PROPERTY_COUNT = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.667 -0400", hash_original_field = "136AA0BD562114C86FDDCBE567EED048", hash_generated_field = "8F5AA93191EF40D19F781D0FC42918E3")

    private static final Margins DEFAULT_MARGINS = new Margins(0,  0,  0,  0);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.709 -0400", hash_original_field = "649B01D06AC443C7C21AE584A8AEE182", hash_generated_field = "281B277F0AE2D24C19B75B84622ED63A")

    public static final Parcelable.Creator<PrinterCapabilitiesInfo> CREATOR =
            new Parcelable.Creator<PrinterCapabilitiesInfo>() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public PrinterCapabilitiesInfo createFromParcel(Parcel parcel) {
            return new PrinterCapabilitiesInfo(parcel);
        }

        @Override
        public PrinterCapabilitiesInfo[] newArray(int size) {
            return new PrinterCapabilitiesInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.668 -0400", hash_original_field = "50DC960BA53A486C445B2CE30CB30B1F", hash_generated_field = "F8A2F5706C56FEE25DCBA3C51B1F2285")

    private Margins mMinMargins = DEFAULT_MARGINS;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.668 -0400", hash_original_field = "63D61E1A91D71FEAE4EA788A6AC4B01B", hash_generated_field = "17DCFB7B9C8EE0AE2398B57EC4578544")

    private List<MediaSize> mMediaSizes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.669 -0400", hash_original_field = "33D0A5AC1AFA6A620980B8C3BC0738D2", hash_generated_field = "A573A2A15859AD964F2FE2368558DB45")

    private List<Resolution> mResolutions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.670 -0400", hash_original_field = "F2B4942F18C9C52AFD18681D816170E3", hash_generated_field = "218529E0A1A5714B4B3704D3CA749B93")

    private int mColorModes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.671 -0400", hash_original_field = "E2F9A7EF349300BD2E23FFF1A8CB6275", hash_generated_field = "C440BB2FAC897E2AAD750875FC59A383")

    private final int[] mDefaults = new int[PROPERTY_COUNT];

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.672 -0400", hash_original_method = "D47D5CAC883F4A6857ADCCF9EB2805AF", hash_generated_method = "67D3EA4B98A13D1EF6C7FF8EB9E327A0")
    
public PrinterCapabilitiesInfo() {
        Arrays.fill(mDefaults, DEFAULT_UNDEFINED);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.673 -0400", hash_original_method = "CC662E53936A059DE5787029E3A94F0D", hash_generated_method = "1254ED62DFB4FC41F6DE1B8251B4280E")
    
public PrinterCapabilitiesInfo(PrinterCapabilitiesInfo prototype) {
        copyFrom(prototype);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.680 -0400", hash_original_method = "7DB98ED976A12EFED7C8579DA0AA1DE8", hash_generated_method = "C4EF6C5191E9052CB7FB0DDE4B413044")
    
private PrinterCapabilitiesInfo(Parcel parcel) {
        mMinMargins = readMargins(parcel);
        readMediaSizes(parcel);
        readResolutions(parcel);

        mColorModes = parcel.readInt();

        readDefaults(parcel);
    }

    /**
     * @hide
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.674 -0400", hash_original_method = "9D2C28D86B6F23D5EC063FA32ED09C34", hash_generated_method = "D2B640D67ECB015FADEF4C3370D46480")
    
public void copyFrom(PrinterCapabilitiesInfo other) {
        if (this == other) {
            return;
        }

        mMinMargins = other.mMinMargins;

        if (other.mMediaSizes != null) {
            if (mMediaSizes != null) {
                mMediaSizes.clear();
                mMediaSizes.addAll(other.mMediaSizes);
            } else {
                mMediaSizes = new ArrayList<MediaSize>(other.mMediaSizes);
            }
        } else {
            mMediaSizes = null;
        }

        if (other.mResolutions != null) {
            if (mResolutions != null) {
                mResolutions.clear();
                mResolutions.addAll(other.mResolutions);
            } else {
                mResolutions = new ArrayList<Resolution>(other.mResolutions);
            }
        } else {
            mResolutions = null;
        }

        mColorModes = other.mColorModes;

        final int defaultCount = other.mDefaults.length;
        for (int i = 0; i < defaultCount; i++) {
            mDefaults[i] = other.mDefaults[i];
        }
    }

    /**
     * Gets the supported media sizes.
     *
     * @return The media sizes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.675 -0400", hash_original_method = "8133E6345029D04CFDD33E08E4905576", hash_generated_method = "CB917C2B8751F324BBD3B9603250E0A5")
    
public List<MediaSize> getMediaSizes() {
        return Collections.unmodifiableList(mMediaSizes);
    }

    /**
     * Gets the supported resolutions.
     *
     * @return The resolutions.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.676 -0400", hash_original_method = "FE6705C6F4A890DFDB7A8E26AC0DA6AF", hash_generated_method = "B41A22D4FB0CC4F26F0BD11882EEE7B2")
    
public List<Resolution> getResolutions() {
        return Collections.unmodifiableList(mResolutions);
    }

    /**
     * Gets the minimal margins. These are the minimal margins
     * the printer physically supports.
     *
     * @return The minimal margins.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.677 -0400", hash_original_method = "5851BF7D0A85DE81A964937AAF572493", hash_generated_method = "707780F4E52B8BE18394035F9CB157A9")
    
public Margins getMinMargins() {
        return mMinMargins;
    }

    /**
     * Gets the bit mask of supported color modes.
     *
     * @return The bit mask of supported color modes.
     *
     * @see PrintAttributes#COLOR_MODE_COLOR
     * @see PrintAttributes#COLOR_MODE_MONOCHROME
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.678 -0400", hash_original_method = "FDD20B7B51276995B97F4E1535DFB107", hash_generated_method = "E8E1E6A73848F9C20FACF2CD6FECC0EF")
    
public int getColorModes() {
        return mColorModes;
    }

    /**
     * Gets the default print attributes.
     *
     * @return The default attributes.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.679 -0400", hash_original_method = "D90B5C68297C3B1C0DF4F56A24BA8671", hash_generated_method = "38ED4978076F61A185543DA713A77FA5")
    
public PrintAttributes getDefaults() {
        PrintAttributes.Builder builder = new PrintAttributes.Builder();

        builder.setMinMargins(mMinMargins);

        final int mediaSizeIndex = mDefaults[PROPERTY_MEDIA_SIZE];
        if (mediaSizeIndex >= 0) {
            builder.setMediaSize(mMediaSizes.get(mediaSizeIndex));
        }

        final int resolutionIndex = mDefaults[PROPERTY_RESOLUTION];
        if (resolutionIndex >= 0) {
            builder.setResolution(mResolutions.get(resolutionIndex));
        }

        final int colorMode = mDefaults[PROPERTY_COLOR_MODE];
        if (colorMode > 0) {
            builder.setColorMode(colorMode);
        }

        return builder.build();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.681 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.682 -0400", hash_original_method = "810D51C0638F7319970BAEDCB76B1D8B", hash_generated_method = "932B3B050DD3DEBDD6F1C3022E1ED0E3")
    
@Override
    public void writeToParcel(Parcel parcel, int flags) {
        writeMargins(mMinMargins, parcel);
        writeMediaSizes(parcel);
        writeResolutions(parcel);

        parcel.writeInt(mColorModes);

        writeDefaults(parcel);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.683 -0400", hash_original_method = "E0FE5288294E6EEB587DA5B669808851", hash_generated_method = "0847A631963B7906A1A45162E62512E5")
    
@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((mMinMargins == null) ? 0 : mMinMargins.hashCode());
        result = prime * result + ((mMediaSizes == null) ? 0 : mMediaSizes.hashCode());
        result = prime * result + ((mResolutions == null) ? 0 : mResolutions.hashCode());
        result = prime * result + mColorModes;
        result = prime * result + Arrays.hashCode(mDefaults);
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.684 -0400", hash_original_method = "5626FD0A0CD0E848382824F6DD00EBD6", hash_generated_method = "786E9A08A3D3F76EBE265250927668A6")
    
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
        PrinterCapabilitiesInfo other = (PrinterCapabilitiesInfo) obj;
        if (mMinMargins == null) {
            if (other.mMinMargins != null) {
                return false;
            }
        } else if (!mMinMargins.equals(other.mMinMargins)) {
            return false;
        }
        if (mMediaSizes == null) {
            if (other.mMediaSizes != null) {
                return false;
            }
        } else if (!mMediaSizes.equals(other.mMediaSizes)) {
            return false;
        }
        if (mResolutions == null) {
            if (other.mResolutions != null) {
                return false;
            }
        } else if (!mResolutions.equals(other.mResolutions)) {
            return false;
        }
        if (mColorModes != other.mColorModes) {
            return false;
        }
        if (!Arrays.equals(mDefaults, other.mDefaults)) {
            return false;
        }
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.685 -0400", hash_original_method = "68D75E252DA482DD6C9F15FEE10994B3", hash_generated_method = "D69C0CCBA87944DA8C9D5855080283B8")
    
@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PrinterInfo{");
        builder.append("minMargins=").append(mMinMargins);
        builder.append(", mediaSizes=").append(mMediaSizes);
        builder.append(", resolutions=").append(mResolutions);
        builder.append(", colorModes=").append(colorModesToString());
        builder.append("\"}");
        return builder.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.686 -0400", hash_original_method = "465B6824EE6970385F77B0731953E2B1", hash_generated_method = "B7F039ACB273085B8D21B87C86921C4B")
    
private String colorModesToString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        int colorModes = mColorModes;
        while (colorModes != 0) {
            final int colorMode = 1 << Integer.numberOfTrailingZeros(colorModes);
            colorModes &= ~colorMode;
            if (builder.length() > 1) {
                builder.append(", ");
            }
            builder.append(PrintAttributes.colorModeToString(colorMode));
        }
        builder.append(']');
        return builder.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.687 -0400", hash_original_method = "E4967392EE34B080DA96769504E07156", hash_generated_method = "656BF70AACCA3A4529DB63EAEF16A551")
    
private void writeMediaSizes(Parcel parcel) {
        if (mMediaSizes == null) {
            parcel.writeInt(0);
            return;
        }
        final int mediaSizeCount = mMediaSizes.size();
        parcel.writeInt(mediaSizeCount);
        for (int i = 0; i < mediaSizeCount; i++) {
            mMediaSizes.get(i).writeToParcel(parcel);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.688 -0400", hash_original_method = "B29A965F77B15BAD4A2D41DA19B1DB36", hash_generated_method = "36C0CA8060BD18715E3F4F7161A5A667")
    
private void readMediaSizes(Parcel parcel) {
        final int mediaSizeCount = parcel.readInt();
        if (mediaSizeCount > 0 && mMediaSizes == null) {
            mMediaSizes = new ArrayList<MediaSize>();
        }
        for (int i = 0; i < mediaSizeCount; i++) {
            mMediaSizes.add(MediaSize.createFromParcel(parcel));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.689 -0400", hash_original_method = "EE15685636097D72488197B85D007FD8", hash_generated_method = "98693FA31C4D5B9055CC34BE0F9346C6")
    
private void writeResolutions(Parcel parcel) {
        if (mResolutions == null) {
            parcel.writeInt(0);
            return;
        }
        final int resolutionCount = mResolutions.size();
        parcel.writeInt(resolutionCount);
        for (int i = 0; i < resolutionCount; i++) {
            mResolutions.get(i).writeToParcel(parcel);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.690 -0400", hash_original_method = "6D9D966C4DF5F8B9C9F85035294FFD2C", hash_generated_method = "9CEE2378B697BFCA6EB587DE39C144ED")
    
private void readResolutions(Parcel parcel) {
        final int resolutionCount = parcel.readInt();
        if (resolutionCount > 0 && mResolutions == null) {
            mResolutions = new ArrayList<Resolution>();
        }
        for (int i = 0; i < resolutionCount; i++) {
            mResolutions.add(Resolution.createFromParcel(parcel));
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.691 -0400", hash_original_method = "9A331E1093A745AC64815CDA7017CA2E", hash_generated_method = "E5A301CF06EF02B9CD018F4569693F43")
    
private void writeMargins(Margins margins, Parcel parcel) {
        if (margins == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            margins.writeToParcel(parcel);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.692 -0400", hash_original_method = "93073BCCEBEA2C9C55CCA73C1BABF6C4", hash_generated_method = "862BD7C0D39AE6551825BCCA3113E63F")
    
private Margins readMargins(Parcel parcel) {
        return (parcel.readInt() == 1) ? Margins.createFromParcel(parcel) : null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.693 -0400", hash_original_method = "4E5A1363498E925D323EA0C3D93AA681", hash_generated_method = "9310CB86E477E89CE2880530A6C4ECA3")
    
private void readDefaults(Parcel parcel) {
        final int defaultCount = parcel.readInt();
        for (int i = 0; i < defaultCount; i++) {
            mDefaults[i] = parcel.readInt();
        }
    }

    /**
     * Builder for creating of a {@link PrinterCapabilitiesInfo}. This class is
     * responsible to enforce that all required attributes have at least one
     * default value. In other words, this class creates only well-formed {@link
     * PrinterCapabilitiesInfo}s.
     * <p>
     * Look at the individual methods for a reference whether a property is
     * required or if it is optional.
     * </p>
     */
    public static final class Builder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.695 -0400", hash_original_field = "D8988A81DE6821EB12B019439F0950DF", hash_generated_field = "29228C22013DF928CE35A06FB3CC34CB")

        private  PrinterCapabilitiesInfo mPrototype;

        /**
         * Creates a new instance.
         *
         * @param printerId The printer id. Cannot be <code>null</code>.
         *
         * @throws IllegalArgumentException If the printer id is <code>null</code>.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.697 -0400", hash_original_method = "2F02B6F65586A11020FE3540EEEA7F40", hash_generated_method = "A2AD53157041DF2DC4EFBC9AFCA32A23")
        
public Builder(PrinterId printerId) {
            if (printerId == null) {
                throw new IllegalArgumentException("printerId cannot be null.");
            }
            mPrototype = new PrinterCapabilitiesInfo();
        }

        /**
         * Adds a supported media size.
         * <p>
         * <strong>Required:</strong> Yes
         * </p>
         *
         * @param mediaSize A media size.
         * @param isDefault Whether this is the default.
         * @return This builder.
         * @throws IllegalArgumentException If set as default and there
         *     is already a default.
         *
         * @see PrintAttributes.MediaSize
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.698 -0400", hash_original_method = "89F7BEBA96D28BF6226033A5C6E3AB22", hash_generated_method = "7D13CB052E4C45E86CBA189872B09F98")
        
public Builder addMediaSize(MediaSize mediaSize, boolean isDefault) {
            if (mPrototype.mMediaSizes == null) {
                mPrototype.mMediaSizes = new ArrayList<MediaSize>();
            }
            final int insertionIndex = mPrototype.mMediaSizes.size();
            mPrototype.mMediaSizes.add(mediaSize);
            if (isDefault) {
                throwIfDefaultAlreadySpecified(PROPERTY_MEDIA_SIZE);
                mPrototype.mDefaults[PROPERTY_MEDIA_SIZE] = insertionIndex;
            }
            return this;
        }

        /**
         * Adds a supported resolution.
         * <p>
         * <strong>Required:</strong> Yes
         * </p>
         *
         * @param resolution A resolution.
         * @param isDefault Whether this is the default.
         * @return This builder.
         *
         * @throws IllegalArgumentException If set as default and there
         *     is already a default.
         *
         * @see PrintAttributes.Resolution
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.699 -0400", hash_original_method = "B1F285D54415632FC56349CB92E5EDC4", hash_generated_method = "EBFB6F552F5D0378D591888D173AEE16")
        
public Builder addResolution(Resolution resolution, boolean isDefault) {
            if (mPrototype.mResolutions == null) {
                mPrototype.mResolutions = new ArrayList<Resolution>();
            }
            final int insertionIndex = mPrototype.mResolutions.size();
            mPrototype.mResolutions.add(resolution);
            if (isDefault) {
                throwIfDefaultAlreadySpecified(PROPERTY_RESOLUTION);
                mPrototype.mDefaults[PROPERTY_RESOLUTION] = insertionIndex;
            }
            return this;
        }

        /**
         * Sets the minimal margins. These are the minimal margins
         * the printer physically supports.
         *
         * <p>
         * <strong>Required:</strong> Yes
         * </p>
         *
         * @param margins The margins.
         * @return This builder.
         *
         * @throws IllegalArgumentException If margins are <code>null</code>.
         *
         * @see PrintAttributes.Margins
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.700 -0400", hash_original_method = "1620DC42930A5129302D4634215B0025", hash_generated_method = "BBEDB63D491C62DDF82C803B1AD74966")
        
public Builder setMinMargins(Margins margins) {
            if (margins == null) {
                throw new IllegalArgumentException("margins cannot be null");
            }
            mPrototype.mMinMargins = margins;
            return this;
        }

        /**
         * Sets the color modes.
         * <p>
         * <strong>Required:</strong> Yes
         * </p>
         *
         * @param colorModes The color mode bit mask.
         * @param defaultColorMode The default color mode.
         * @return This builder.
         * <p>
         * <strong>Note:</strong> On platform version 19 (Kitkat) specifying
         * only PrintAttributes#COLOR_MODE_MONOCHROME leads to a print spooler
         * crash. Hence, you should declare either both color modes or
         * PrintAttributes#COLOR_MODE_COLOR.
         * </p>
         *
         * @throws IllegalArgumentException If color modes contains an invalid
         *         mode bit or if the default color mode is invalid.
         *
         * @see PrintAttributes#COLOR_MODE_COLOR
         * @see PrintAttributes#COLOR_MODE_MONOCHROME
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.702 -0400", hash_original_method = "7B8F2B7B42346691EFF6EAE7B98D4028", hash_generated_method = "1238BD7C664F93BB599AE885CFFB7196")
        
public Builder setColorModes(int colorModes, int defaultColorMode) {
            int currentModes = colorModes;
            while (currentModes > 0) {
                final int currentMode = (1 << Integer.numberOfTrailingZeros(currentModes));
                currentModes &= ~currentMode;
                PrintAttributes.enforceValidColorMode(currentMode);
            }
            if ((colorModes & defaultColorMode) == 0) {
                throw new IllegalArgumentException("Default color mode not in color modes.");
            }
            PrintAttributes.enforceValidColorMode(colorModes);
            mPrototype.mColorModes = colorModes;
            mPrototype.mDefaults[PROPERTY_COLOR_MODE] = defaultColorMode;
            return this;
        }

        /**
         * Crates a new {@link PrinterCapabilitiesInfo} enforcing that all
         * required properties have been specified. See individual methods
         * in this class for reference about required attributes.
         *
         * @return A new {@link PrinterCapabilitiesInfo}.
         *
         * @throws IllegalStateException If a required attribute was not specified.
         */
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.704 -0400", hash_original_method = "1D096EC75F34D455B1B7A5FADE2B71DD", hash_generated_method = "10ABA61C055193636F808D29F3D39D04")
        
public PrinterCapabilitiesInfo build() {
            if (mPrototype.mMediaSizes == null || mPrototype.mMediaSizes.isEmpty()) {
                throw new IllegalStateException("No media size specified.");
            }
            if (mPrototype.mDefaults[PROPERTY_MEDIA_SIZE] == DEFAULT_UNDEFINED) {
                throw new IllegalStateException("No default media size specified.");
            }
            if (mPrototype.mResolutions == null || mPrototype.mResolutions.isEmpty()) {
                throw new IllegalStateException("No resolution specified.");
            }
            if (mPrototype.mDefaults[PROPERTY_RESOLUTION] == DEFAULT_UNDEFINED) {
                throw new IllegalStateException("No default resolution specified.");
            }
            if (mPrototype.mColorModes == 0) {
                throw new IllegalStateException("No color mode specified.");
            }
            if (mPrototype.mDefaults[PROPERTY_COLOR_MODE] == DEFAULT_UNDEFINED) {
                throw new IllegalStateException("No default color mode specified.");
            }
            if (mPrototype.mMinMargins == null) {
                throw new IllegalArgumentException("margins cannot be null");
            }
            return mPrototype;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.705 -0400", hash_original_method = "2E0B9E37D484CC68ACA9C5CD52F560C8", hash_generated_method = "B28456EC9FD6387D3E8F41B96AF911BA")
        
private void throwIfDefaultAlreadySpecified(int propertyIndex) {
            if (mPrototype.mDefaults[propertyIndex] != DEFAULT_UNDEFINED) {
                throw new IllegalArgumentException("Default already specified.");
            }
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.694 -0400", hash_original_method = "459D926F9E5671E60D165DF6ACC216AA", hash_generated_method = "AD370173F71A48AD50483EF69FE5D28E")
    
private void writeDefaults(Parcel parcel) {
        final int defaultCount = mDefaults.length;
        parcel.writeInt(defaultCount);
        for (int i = 0; i < defaultCount; i++) {
            parcel.writeInt(mDefaults[i]);
        }
    }
}

