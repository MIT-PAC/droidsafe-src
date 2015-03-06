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
import droidsafe.annotations.*;
import android.os.Parcel;
import android.os.Parcelable;

import com.android.internal.util.ArrayUtils;

public final class SuggestionsInfo implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.162 -0500", hash_original_field = "B114FB122CDA18833AD315AAF80FA513", hash_generated_field = "2D3D0D0351BF8AB635A0C02B8A36EDBE")

    private static final String[] EMPTY = ArrayUtils.emptyArray(String.class);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.165 -0500", hash_original_field = "697B1CEFE251D9683F578F9F9F164281", hash_generated_field = "1B01F5B80758F8517026C18547BAF7C6")

    public static final int RESULT_ATTR_IN_THE_DICTIONARY = 0x0001;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.168 -0500", hash_original_field = "A35F8CDBCEB17A6B8D9E4A8676F8C3E3", hash_generated_field = "62708B506BBFFF949F1CE8EDF196B42B")

    public static final int RESULT_ATTR_LOOKS_LIKE_TYPO = 0x0002;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.170 -0500", hash_original_field = "619EEB699326D247887C089B8DBB6A2B", hash_generated_field = "319837AF46D02D94C46D8330FB323380")

    public static final int RESULT_ATTR_HAS_RECOMMENDED_SUGGESTIONS = 0x0004;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:50.001 -0400", hash_original_field = "C2528F28EE8C2B797601B9AAA3764A2B", hash_generated_field = "A1262BBCBC0A40327218E2B9D15365C4")

    public static final Parcelable.Creator<SuggestionsInfo> CREATOR
            = new Parcelable.Creator<SuggestionsInfo>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.209 -0500", hash_original_method = "F97F550CBFC4BB9C72B2E6BDB6B999E6", hash_generated_method = "3EA9808572723A85D4BB42C2B93DB39F")
        
@Override
        public SuggestionsInfo createFromParcel(Parcel source) {
            return new SuggestionsInfo(source);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.212 -0500", hash_original_method = "F02A74E3784170B5B2B3A7C1C66F7DCB", hash_generated_method = "362663F87F486F70DC5B0C6B673F8425")
        
@Override
        public SuggestionsInfo[] newArray(int size) {
            return new SuggestionsInfo[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.173 -0500", hash_original_field = "20654996EA728A22A6F4F781B92F913B", hash_generated_field = "390932DA60837BE0A47579CAD7C0B1B8")

    private  int mSuggestionsAttributes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.175 -0500", hash_original_field = "D25184D4A2C602FEC3892EB70177EB91", hash_generated_field = "5DB4DA08FB0C173A250A5596D6A803F5")

    private  String[] mSuggestions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.177 -0500", hash_original_field = "FF3E8A39D6A68272C768698CA35787A9", hash_generated_field = "4EA9B3C35E806BD03C8EAA998321A5D4")

    private  boolean mSuggestionsAvailable;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.179 -0500", hash_original_field = "17C86C09C6C4D7B6E875B4525EC536C5", hash_generated_field = "02A3A9994454C1152633199C0FF9DCC4")

    private int mCookie;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.181 -0500", hash_original_field = "C28E864EAE17A45901F02FA70D5B732C", hash_generated_field = "8F50649AA652CE4330E55AC6A68FCB0E")

    private int mSequence;

    /**
     * Constructor.
     * @param suggestionsAttributes from the text service
     * @param suggestions from the text service
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.184 -0500", hash_original_method = "F72366BA0EDF1634C1AA3C488E109E33", hash_generated_method = "1B13D46DDC3DB185A27909CF81E2081C")
    
public SuggestionsInfo(int suggestionsAttributes, String[] suggestions) {
        mSuggestionsAttributes = suggestionsAttributes;
        if (suggestions == null) {
            mSuggestions = EMPTY;
            mSuggestionsAvailable = false;
        } else {
            mSuggestions = suggestions;
            mSuggestionsAvailable = true;
        }
        mCookie = 0;
        mSequence = 0;
    }

    /**
     * Constructor.
     * @param suggestionsAttributes from the text service
     * @param suggestions from the text service
     * @param cookie the cookie of the input TextInfo
     * @param sequence the cookie of the input TextInfo
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.188 -0500", hash_original_method = "F344476C9AC73EBE1631CA25EF553262", hash_generated_method = "C55D4D8943B47280884A2C5D9A3D858E")
    
public SuggestionsInfo(
            int suggestionsAttributes, String[] suggestions, int cookie, int sequence) {
        if (suggestions == null) {
            mSuggestions = EMPTY;
            mSuggestionsAvailable = false;
        } else {
            mSuggestions = suggestions;
            mSuggestionsAvailable = true;
        }
        mSuggestionsAttributes = suggestionsAttributes;
        mCookie = cookie;
        mSequence = sequence;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.190 -0500", hash_original_method = "A8076752A4CBE1F29691F498A5186710", hash_generated_method = "12950DF4A06A0D64A680D8A5EA6ACE14")
    
public SuggestionsInfo(Parcel source) {
        mSuggestionsAttributes = source.readInt();
        mSuggestions = source.readStringArray();
        mCookie = source.readInt();
        mSequence = source.readInt();
        mSuggestionsAvailable = source.readInt() == 1;
    }

    /**
     * Used to package this object into a {@link Parcel}.
     *
     * @param dest The {@link Parcel} to be written.
     * @param flags The flags used for parceling.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.193 -0500", hash_original_method = "D6F7E488E85F5F73C07F51AB39369D4C", hash_generated_method = "CD9A0C9C83B1779DD55D8FCBE2F0BD12")
    
@Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSuggestionsAttributes);
        dest.writeStringArray(mSuggestions);
        dest.writeInt(mCookie);
        dest.writeInt(mSequence);
        dest.writeInt(mSuggestionsAvailable ? 1 : 0);
    }

    /**
     * Set the cookie and the sequence of SuggestionsInfo which are set to TextInfo from a client
     * application
     * @param cookie the cookie of an input TextInfo
     * @param sequence the cookie of an input TextInfo
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.195 -0500", hash_original_method = "BC94DA38979C8D1C8B1C739567CEFAB2", hash_generated_method = "11AFE355E8AD4B3713636E79E284FE21")
    
public void setCookieAndSequence(int cookie, int sequence) {
        mCookie = cookie;
        mSequence = sequence;
    }

    /**
     * @return the cookie which may be set by a client application
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.197 -0500", hash_original_method = "AC1EDA43FC7023F4D4E1DFBFEFAF3924", hash_generated_method = "409946859A12F6C3A6BC121010CF938D")
    
public int getCookie() {
        return mCookie;
    }

    /**
     * @return the sequence which may be set by a client application
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.200 -0500", hash_original_method = "FE2AB8ECE26FD7A4F1B7769F13B3F465", hash_generated_method = "9FB850F0F91CCC9108C608E4BE6ED809")
    
public int getSequence() {
        return mSequence;
    }

    /**
     * @return the attributes of suggestions. This includes whether the spell checker has the word
     * in its dictionary or not and whether the spell checker has confident suggestions for the
     * word or not.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.202 -0500", hash_original_method = "CAB4876CFD4A091BA905BB4AD514BA41", hash_generated_method = "039C4751A7B69D68DB223D50D7C7FAFB")
    
public int getSuggestionsAttributes() {
        return mSuggestionsAttributes;
    }

    /**
     * @return the count of the suggestions. If there's no suggestions at all, this method returns
     * -1. Even if this method returns 0, it doesn't necessarily mean that there are no suggestions
     * for the requested word. For instance, the caller could have been asked to limit the maximum
     * number of suggestions returned.
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.204 -0500", hash_original_method = "F830DF6AFB67D9BA96245AE6E3B04D1C", hash_generated_method = "744E87FB2D3F19FD277BD61E6C441E3E")
    
public int getSuggestionsCount() {
        if (!mSuggestionsAvailable) {
            return -1;
        }
        return mSuggestions.length;
    }

    /**
     * @param i the id of suggestions
     * @return the suggestion at the specified id
     */
    @DSSource({DSSourceKind.NETWORK})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.206 -0500", hash_original_method = "303722B2FF6B72DC10F6A88905A65E92", hash_generated_method = "F3918EED0601E77138200300D1DAAB04")
    
public String getSuggestionAt(int i) {
        return mSuggestions[i];
    }

    /**
     * Used to make this class parcelable.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:29:47.217 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }
}

