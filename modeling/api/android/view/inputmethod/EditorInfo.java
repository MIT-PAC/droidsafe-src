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
 * Copyright (C) 2008 The Android Open Source Project
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


package android.view.inputmethod;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Printer;

public class EditorInfo implements InputType, Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.512 -0500", hash_original_field = "7BF4B04BD512732B1FDB8AD3EABEFE45", hash_generated_field = "A9521826A0927A20AC089A01E6C4AF30")

    public static final int IME_MASK_ACTION = 0x000000ff;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.515 -0500", hash_original_field = "E83366B3832BD802FECFAB994CB67B39", hash_generated_field = "9BE4BD94ACB2423749B8E8051B7934F0")

    public static final int IME_ACTION_UNSPECIFIED = 0x00000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.519 -0500", hash_original_field = "0F20CD1D20BF1E96980628A876A2B9D6", hash_generated_field = "5A2F1C9F852DE43BD8B39570039086CD")

    public static final int IME_ACTION_NONE = 0x00000001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.521 -0500", hash_original_field = "85A95E8791ADE61D158984C2EF5D48DE", hash_generated_field = "6721350DD9F9DE697F392C5CA60BD321")

    public static final int IME_ACTION_GO = 0x00000002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.525 -0500", hash_original_field = "5355C18B5CE9A139E82FC484FDD21233", hash_generated_field = "A1475BB88746B9DC84FAE52A4FDFDAF5")

    public static final int IME_ACTION_SEARCH = 0x00000003;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.529 -0500", hash_original_field = "818C2F43CF6E7B6868C5FBA04829DF3A", hash_generated_field = "05D8BA2A5D8C324C1C0E564DBA9CB823")

    public static final int IME_ACTION_SEND = 0x00000004;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.534 -0500", hash_original_field = "7A756184BE0E45734C62C8ADC1A18CB5", hash_generated_field = "AF60C5287F9CFBB66AC8C023716DD5B3")

    public static final int IME_ACTION_NEXT = 0x00000005;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.538 -0500", hash_original_field = "2FDFA409E2B9C5A33BEA239C61B178B5", hash_generated_field = "0C062F9E7A31E16074611D935372DAF6")

    public static final int IME_ACTION_DONE = 0x00000006;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.543 -0500", hash_original_field = "0FFD5DBA56F24EEE157D3C7201E0DB85", hash_generated_field = "603FE0A6E9B8A3B4F0E3190179EA48BE")

    public static final int IME_ACTION_PREVIOUS = 0x00000007;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.547 -0500", hash_original_field = "3A0EEEA1293274E90C85A8CAFFA3715E", hash_generated_field = "5FB13DC64A388E4F89C833A83CCE154C")

    public static final int IME_FLAG_NO_FULLSCREEN = 0x2000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.551 -0500", hash_original_field = "1C4A6DDB91E011B5409F3FD13BC686BE", hash_generated_field = "3953A6A9F2FC4D29B446D76D0C347487")

    public static final int IME_FLAG_NAVIGATE_PREVIOUS = 0x4000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.555 -0500", hash_original_field = "E90492F2B9CF33093A714D3A490929DC", hash_generated_field = "36A3C12115D9205A4ADA3234E5262F97")

    public static final int IME_FLAG_NAVIGATE_NEXT = 0x8000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.560 -0500", hash_original_field = "E19DE02D3DA57A01008CAD0EAC196CDF", hash_generated_field = "0D02B28480AA061F9EE5B50ADE7FE2D3")

    public static final int IME_FLAG_NO_EXTRACT_UI = 0x10000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.564 -0500", hash_original_field = "5EF89C3D191E97B44E5CD03AAB1A5E3C", hash_generated_field = "DEF326CADF8E3A836BEC5A1393696AC8")

    public static final int IME_FLAG_NO_ACCESSORY_ACTION = 0x20000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.569 -0500", hash_original_field = "538829136FD96542170816C1E873A5F1", hash_generated_field = "7EC82B768AAD56B70C10BA24CCA16D0B")

    public static final int IME_FLAG_NO_ENTER_ACTION = 0x40000000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.573 -0500", hash_original_field = "CCE63D9226F83A5525E63D89DD91F42B", hash_generated_field = "3A3A251668E89CBD127D44D9756AEC66")

    public static final int IME_NULL = 0x00000000;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.358 -0400", hash_original_field = "1571425679A71C2B4E211351FA79417D", hash_generated_field = "1554B4BEF2704B75DF5E855F87FA4685")

    public static final Parcelable.Creator<EditorInfo> CREATOR = new Parcelable.Creator<EditorInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.660 -0500", hash_original_method = "AD6DC78DBEA1B193A565639E1F90B5B3", hash_generated_method = "6BF91C25115F36FB3943132A91712FC0")
        
public EditorInfo createFromParcel(Parcel source) {
            EditorInfo res = new EditorInfo();
            res.inputType = source.readInt();
            res.imeOptions = source.readInt();
            res.privateImeOptions = source.readString();
            res.actionLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.actionId = source.readInt();
            res.initialSelStart = source.readInt();
            res.initialSelEnd = source.readInt();
            res.initialCapsMode = source.readInt();
            res.hintText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.label = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.packageName = source.readString();
            res.fieldId = source.readInt();
            res.fieldName = source.readString();
            res.extras = source.readBundle();
            return res;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.664 -0500", hash_original_method = "E8A969BD7C499BCF878E62F3B3C9E071", hash_generated_method = "3F9DEB4C925FC411598453654CD9FDE1")
        
public EditorInfo[] newArray(int size) {
            return new EditorInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.509 -0500", hash_original_field = "2A132101E0976B5EC795C144D64038DF", hash_generated_field = "7A2525786FE6C2DC62A764834F216E95")

    public int inputType = TYPE_NULL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.576 -0500", hash_original_field = "A1461B7847B4524FC6D347D30299B4E8", hash_generated_field = "B9721B4D0F8040EBEAFBDFD37833BD8A")

    public int imeOptions = IME_NULL;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.581 -0500", hash_original_field = "F39D85F5729B8120C3CA44F8E83AED7B", hash_generated_field = "3D48A13615BEBAA577D3FC5619F56EAF")

    public String privateImeOptions = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.584 -0500", hash_original_field = "ABB28AA772719493DBC1EEB85050C2B2", hash_generated_field = "D6DC37304F82459EA8A6E2799E09D2F6")

    public CharSequence actionLabel = null;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.588 -0500", hash_original_field = "C8810A6384E0F3624772010FCFA1B5CC", hash_generated_field = "20C71B0087691E387C1AEDDC8E93E894")

    public int actionId = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.592 -0500", hash_original_field = "6D572EC01017BD1EA530C185D2439354", hash_generated_field = "DCCD366C9A643215784258494A09792D")

    public int initialSelStart = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.596 -0500", hash_original_field = "0C041EFC4AB2F37FBA6126537AC83061", hash_generated_field = "C0C725B87DAD0525A96223FD3E49C578")

    public int initialSelEnd = -1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.599 -0500", hash_original_field = "632F50932D1ADAEF94C52834986C61D8", hash_generated_field = "CAEE083DDC412DC62EA0FC894E282993")

    public int initialCapsMode = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.604 -0500", hash_original_field = "033F024B3D71094E355B7F1293FF24A6", hash_generated_field = "A8B74B40ED191D33A95BDDAAA2524E33")

    public CharSequence hintText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.627 -0500", hash_original_field = "A370EB0E762CC6276928C19DD26086C7", hash_generated_field = "D6BF9CF13073D3E7F28EBF190C9E996E")

    public CharSequence label;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.631 -0500", hash_original_field = "6F92EE1B3BCDC0C4179CF5FD998BE046", hash_generated_field = "AEA3D3739F492530AF8FD6582FAACBD9")

    public String packageName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.634 -0500", hash_original_field = "9FCDE3C3E64D6C741CB6AEDEA7E5A9A5", hash_generated_field = "BFAFEA72A8555503FBB4009F1BC7143B")

    public int fieldId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.638 -0500", hash_original_field = "98344B3DD34054E157368C2039ADB7C6", hash_generated_field = "439706DC030051976D6434490CA8908C")

    public String fieldName;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.641 -0500", hash_original_field = "6F80A5414A80FF69E92A0BD3C0E073DC", hash_generated_field = "360651D25CBD3D75EA270BBFA49C37D4")

    public Bundle extras;
    
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:49.352 -0400", hash_original_method = "B9ADFD40DF801C34FF4D54782A68254E", hash_generated_method = "B9ADFD40DF801C34FF4D54782A68254E")
    public EditorInfo ()
    {
        //Synthesized constructor
    }
    
    /**
     * Ensure that the data in this EditorInfo is compatible with an application
     * that was developed against the given target API version.  This can
     * impact the following input types:
     * {@link InputType#TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS},
     * {@link InputType#TYPE_TEXT_VARIATION_WEB_PASSWORD},
     * {@link InputType#TYPE_NUMBER_VARIATION_NORMAL},
     * {@link InputType#TYPE_NUMBER_VARIATION_PASSWORD}.
     *
     * <p>This is called by the framework for input method implementations;
     * you should not generally need to call it yourself.
     *
     * @param targetSdkVersion The API version number that the compatible
     * application was developed against.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.645 -0500", hash_original_method = "3C6DC9D32EA44A62EDD92C5C9BF78DEF", hash_generated_method = "E51A1BDF6DF53D9433CCC9C0AFBC1F64")
    
public final void makeCompatible(int targetSdkVersion) {
        if (targetSdkVersion < android.os.Build.VERSION_CODES.HONEYCOMB) {
            switch (inputType&(TYPE_MASK_CLASS|TYPE_MASK_VARIATION)) {
                case TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_WEB_EMAIL_ADDRESS:
                    inputType = TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                            | (inputType&TYPE_MASK_FLAGS);
                    break;
                case TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_WEB_PASSWORD:
                    inputType = TYPE_CLASS_TEXT|TYPE_TEXT_VARIATION_PASSWORD
                            | (inputType&TYPE_MASK_FLAGS);
                    break;
                case TYPE_CLASS_NUMBER|TYPE_NUMBER_VARIATION_NORMAL:
                case TYPE_CLASS_NUMBER|TYPE_NUMBER_VARIATION_PASSWORD:
                    inputType = TYPE_CLASS_NUMBER
                            | (inputType&TYPE_MASK_FLAGS);
                    break;
            }
        }
    }

    /**
     * Write debug output of this object.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.650 -0500", hash_original_method = "52E48D457BDB05F3C0DFF77F15A840F2", hash_generated_method = "FB07D72B8069FE0A14A3A9637B87ABED")
    
public void dump(Printer pw, String prefix) {
        pw.println(prefix + "inputType=0x" + Integer.toHexString(inputType)
                + " imeOptions=0x" + Integer.toHexString(imeOptions)
                + " privateImeOptions=" + privateImeOptions);
        pw.println(prefix + "actionLabel=" + actionLabel
                + " actionId=" + actionId);
        pw.println(prefix + "initialSelStart=" + initialSelStart
                + " initialSelEnd=" + initialSelEnd
                + " initialCapsMode=0x"
                + Integer.toHexString(initialCapsMode));
        pw.println(prefix + "hintText=" + hintText
                + " label=" + label);
        pw.println(prefix + "packageName=" + packageName
                + " fieldId=" + fieldId
                + " fieldName=" + fieldName);
        pw.println(prefix + "extras=" + extras);
    }
    
    /**
     * Used to package this object into a {@link Parcel}.
     * 
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.654 -0500", hash_original_method = "0DCEB67BA2166B08F017930A62049273", hash_generated_method = "51094617EEA2A8D3BBFA055E5F321769")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(inputType);
        dest.writeInt(imeOptions);
        dest.writeString(privateImeOptions);
        TextUtils.writeToParcel(actionLabel, dest, flags);
        dest.writeInt(actionId);
        dest.writeInt(initialSelStart);
        dest.writeInt(initialSelEnd);
        dest.writeInt(initialCapsMode);
        TextUtils.writeToParcel(hintText, dest, flags);
        TextUtils.writeToParcel(label, dest, flags);
        dest.writeString(packageName);
        dest.writeInt(fieldId);
        dest.writeString(fieldName);
        dest.writeBundle(extras);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:20.672 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }
    // orphaned legacy method
    public EditorInfo createFromParcel(Parcel source) {
            EditorInfo res = new EditorInfo();
            res.inputType = source.readInt();
            res.imeOptions = source.readInt();
            res.privateImeOptions = source.readString();
            res.actionLabel = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.actionId = source.readInt();
            res.initialSelStart = source.readInt();
            res.initialSelEnd = source.readInt();
            res.initialCapsMode = source.readInt();
            res.hintText = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.label = TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(source);
            res.packageName = source.readString();
            res.fieldId = source.readInt();
            res.fieldName = source.readString();
            res.extras = source.readBundle();
            return res;
        }
    
    // orphaned legacy method
    public EditorInfo[] newArray(int size) {
            return new EditorInfo[size];
        }
    
}

