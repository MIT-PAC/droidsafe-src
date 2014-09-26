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

package android.hardware.display;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

/**
 * Describes the current global state of Wifi display connectivity, including the
 * currently connected display and all available or remembered displays.
 * <p>
 * This object is immutable.
 * </p>
 *
 * @hide
 */
public final class WifiDisplayStatus implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.596 -0500", hash_original_field = "34F05038DE3E33E1C3B7ADA883D5C3E1", hash_generated_field = "C08FA24FBD391937A30A167265F60989")

    public static final int FEATURE_STATE_UNAVAILABLE = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.598 -0500", hash_original_field = "B0AACE0CFEB097F8C04F9D1F70AE57B4", hash_generated_field = "8D4BBD23A5B2C56E75206A5BF8D50C68")

    public static final int FEATURE_STATE_DISABLED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.601 -0500", hash_original_field = "DF314D3EC4E61284BFCD267D5B7AA247", hash_generated_field = "824402A71EB08F8EBC74BC3808409B63")

    public static final int FEATURE_STATE_OFF = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.603 -0500", hash_original_field = "0390F5C4A7A494F77C4B7089056980FA", hash_generated_field = "A47A17F63F1FF2B8DD3AB3E23DD2D4E7")

    public static final int FEATURE_STATE_ON = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.605 -0500", hash_original_field = "85060DA1FEE8BAD6709239972CB94DEA", hash_generated_field = "4F183EEFD6B65D77AC181778C958FA1E")

    public static final int SCAN_STATE_NOT_SCANNING = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.607 -0500", hash_original_field = "C614A270BBBC5992FAA373C7003C768B", hash_generated_field = "C8A3896E1F00915D42F01710A1553C0F")

    public static final int SCAN_STATE_SCANNING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.609 -0500", hash_original_field = "8493E414E298F8F74F8B4D8F06EBD868", hash_generated_field = "D19A11F515FBC81471C5765D689D731D")

    public static final int DISPLAY_STATE_NOT_CONNECTED = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.611 -0500", hash_original_field = "3415A4974BE994813E074FE274CDA974", hash_generated_field = "67B34096001C8EF61B18C2BBFF0A02BD")

    public static final int DISPLAY_STATE_CONNECTING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.614 -0500", hash_original_field = "5FB8F45250EDA8374C7501CC0BBC48DF", hash_generated_field = "3FF87FB159A7FC1752362EDECDFFF3D3")

    public static final int DISPLAY_STATE_CONNECTED = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.623 -0500", hash_original_field = "C539E0051879D95CBDADC52D1399D651", hash_generated_field = "75AD64CDC97AF06206F1EC18BB0C1FDE")

    public static final Creator<WifiDisplayStatus> CREATOR = new Creator<WifiDisplayStatus>() {
        @DSSafe(DSCat.SAFE_LIST)
        public WifiDisplayStatus createFromParcel(Parcel in) {
            int featureState = in.readInt();
            int scanState = in.readInt();
            int activeDisplayState= in.readInt();

            WifiDisplay activeDisplay = null;
            if (in.readInt() != 0) {
                activeDisplay = WifiDisplay.CREATOR.createFromParcel(in);
            }

            WifiDisplay[] availableDisplays = WifiDisplay.CREATOR.newArray(in.readInt());
            for (int i = 0; i < availableDisplays.length; i++) {
                availableDisplays[i] = WifiDisplay.CREATOR.createFromParcel(in);
            }

            WifiDisplay[] rememberedDisplays = WifiDisplay.CREATOR.newArray(in.readInt());
            for (int i = 0; i < rememberedDisplays.length; i++) {
                rememberedDisplays[i] = WifiDisplay.CREATOR.createFromParcel(in);
            }

            return new WifiDisplayStatus(featureState, scanState, activeDisplayState,
                    activeDisplay, availableDisplays, rememberedDisplays);
        }

        public WifiDisplayStatus[] newArray(int size) {
            return new WifiDisplayStatus[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.584 -0500", hash_original_field = "3711184F83AF9815E8E5561AD05CAE8C", hash_generated_field = "EA864B1D4E6DA800577400310B92E29F")

    private  int mFeatureState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.586 -0500", hash_original_field = "081265323CB4838A5F419833FD727870", hash_generated_field = "D49A6CC5F7F8D612D87E768F6777D884")

    private  int mScanState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.588 -0500", hash_original_field = "FE64DFD0D8CE59DB6BDD776FAC06C239", hash_generated_field = "58B72A1BC8C35605F4D9478EB6616AB0")

    private  int mActiveDisplayState;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.590 -0500", hash_original_field = "318CC59CE4D19DC297A2EAD9D4F36576", hash_generated_field = "2CCF423977EC6B66C074D1735532EEDE")

    private  WifiDisplay mActiveDisplay;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.592 -0500", hash_original_field = "97A67BDAFBA948B0EC5FDE3ECAF39AD1", hash_generated_field = "6AE072A630441249BD24708F6D65C4F6")

    private  WifiDisplay[] mAvailableDisplays;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.594 -0500", hash_original_field = "5B2A75FDBEC815B5771E2B9C57F7C177", hash_generated_field = "4AA3F1174A6164709D4ABF36FDD8E217")

    private  WifiDisplay[] mRememberedDisplays;

    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.625 -0500", hash_original_method = "A0D325FCF84D7CC5C132C65EBBD5AD4F", hash_generated_method = "D3CFCC2983B8942E6423E7676611123C")
    
public WifiDisplayStatus() {
        this(FEATURE_STATE_UNAVAILABLE, SCAN_STATE_NOT_SCANNING, DISPLAY_STATE_NOT_CONNECTED,
                null, WifiDisplay.EMPTY_ARRAY, WifiDisplay.EMPTY_ARRAY);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.627 -0500", hash_original_method = "76BBA285B800513B0AEB4A1DABECE550", hash_generated_method = "455286493A959DC28F1E6630CF08FB02")
    
public WifiDisplayStatus(int featureState, int scanState,
            int activeDisplayState, WifiDisplay activeDisplay,
            WifiDisplay[] availableDisplays, WifiDisplay[] rememberedDisplays) {
        if (availableDisplays == null) {
            throw new IllegalArgumentException("availableDisplays must not be null");
        }
        if (rememberedDisplays == null) {
            throw new IllegalArgumentException("rememberedDisplays must not be null");
        }

        mFeatureState = featureState;
        mScanState = scanState;
        mActiveDisplayState = activeDisplayState;
        mActiveDisplay = activeDisplay;
        mAvailableDisplays = availableDisplays;
        mRememberedDisplays = rememberedDisplays;
    }

    /**
     * Returns the state of the Wifi display feature on this device.
     * <p>
     * The value of this property reflects whether the device supports the Wifi display,
     * whether it has been enabled by the user and whether the prerequisites for
     * connecting to displays have been met.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.629 -0500", hash_original_method = "92E21A25C9F8346BE234A0BBC065B835", hash_generated_method = "46CF4403CAF988EE76FDA423F57644A9")
    
public int getFeatureState() {
        return mFeatureState;
    }

    /**
     * Returns the current state of the Wifi display scan.
     *
     * @return One of: {@link #SCAN_STATE_NOT_SCANNING} or {@link #SCAN_STATE_SCANNING}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.631 -0500", hash_original_method = "800A40E7A90A1E959F3876E5DFE79032", hash_generated_method = "FBFCBA9A20C6485E1992CA2230880CFD")
    
public int getScanState() {
        return mScanState;
    }

    /**
     * Get the state of the currently active display.
     *
     * @return One of: {@link #DISPLAY_STATE_NOT_CONNECTED}, {@link #DISPLAY_STATE_CONNECTING},
     * or {@link #DISPLAY_STATE_CONNECTED}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.633 -0500", hash_original_method = "831A45243EE101E6A098DFA8E7C1D017", hash_generated_method = "9900CB3BE7FF543D55535270C563CB00")
    
public int getActiveDisplayState() {
        return mActiveDisplayState;
    }

    /**
     * Gets the Wifi display that is currently active.  It may be connecting or
     * connected.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.634 -0500", hash_original_method = "5270837BC666157B44856BF607D7D622", hash_generated_method = "EF7E4818CF8CCBA8F5F6AE08730FC1E0")
    
public WifiDisplay getActiveDisplay() {
        return mActiveDisplay;
    }

    /**
     * Gets the list of all available Wifi displays as reported by the most recent
     * scan, never null.
     * <p>
     * Some of these displays may already be remembered, others may be unknown.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.636 -0500", hash_original_method = "99B029E317E39B6AAC9683485BD30B26", hash_generated_method = "8E8FA8CF53D1C10D14B6DAF398C1E9C4")
    
public WifiDisplay[] getAvailableDisplays() {
        return mAvailableDisplays;
    }

    /**
     * Gets the list of all remembered Wifi displays, never null.
     * <p>
     * Not all remembered displays will necessarily be available.
     * </p>
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.638 -0500", hash_original_method = "1167B9B55586D3746AB4389CF1BE7B21", hash_generated_method = "D66DA4300775B5F2171B5D6ECED76AD7")
    
public WifiDisplay[] getRememberedDisplays() {
        return mRememberedDisplays;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.640 -0500", hash_original_method = "02F28466C146A6FB1A0B1EF67FA0F063", hash_generated_method = "E3E8641A7824F200781391C8B108E47A")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mFeatureState);
        dest.writeInt(mScanState);
        dest.writeInt(mActiveDisplayState);

        if (mActiveDisplay != null) {
            dest.writeInt(1);
            mActiveDisplay.writeToParcel(dest, flags);
        } else {
            dest.writeInt(0);
        }

        dest.writeInt(mAvailableDisplays.length);
        for (WifiDisplay display : mAvailableDisplays) {
            display.writeToParcel(dest, flags);
        }

        dest.writeInt(mRememberedDisplays.length);
        for (WifiDisplay display : mRememberedDisplays) {
            display.writeToParcel(dest, flags);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.642 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    // For debugging purposes only.
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-26 11:24:09.644 -0500", hash_original_method = "5D3BBF2D48BBB644EA140D257129234C", hash_generated_method = "A18BA4B6AAA621E8F7FB1B1872ECF896")
    
@Override
    public String toString() {
        return "WifiDisplayStatus{featureState=" + mFeatureState
                + ", scanState=" + mScanState
                + ", activeDisplayState=" + mActiveDisplayState
                + ", activeDisplay=" + mActiveDisplay
                + ", availableDisplays=" + Arrays.toString(mAvailableDisplays)
                + ", rememberedDisplays=" + Arrays.toString(mRememberedDisplays)
                + "}";
    }
}
