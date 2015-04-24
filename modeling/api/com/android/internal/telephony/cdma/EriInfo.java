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
 * Copyright (C) 2009 The Android Open Source Project
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


package com.android.internal.telephony.cdma;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;



public final class EriInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.440 -0500", hash_original_field = "F371533A774E16C1A5360339412C4F13", hash_generated_field = "6A0C5051C33E7D62E3BAF75434822FCE")


    public static final int ROAMING_INDICATOR_ON    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.442 -0500", hash_original_field = "282FAF324C6410CA4E874561860991FB", hash_generated_field = "B441B006A0E3257CFC8305CBE2F710DB")

    public static final int ROAMING_INDICATOR_OFF   = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.445 -0500", hash_original_field = "4563396DF0ABFF60EBF3D5BD622E37BA", hash_generated_field = "EA6ED0A49AE9F77563EC3ECE4C3C2780")

    public static final int ROAMING_INDICATOR_FLASH = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.447 -0500", hash_original_field = "88EF6C7E51C8DD21913CDD9E8B902008", hash_generated_field = "FC0E5CFD9FEFA0E41F62137E2DAF8F8F")


    public static final int ROAMING_ICON_MODE_NORMAL    = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.450 -0500", hash_original_field = "469F9A74436532AEBA91FFCC64F0C358", hash_generated_field = "BC4536C4233A950573945B34EC6B5CB8")

    public static final int ROAMING_ICON_MODE_FLASH     = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.453 -0500", hash_original_field = "6B45D71C85146A160D302F25109C9229", hash_generated_field = "C85059890CBCB114354FFAC076E01974")


    public int mRoamingIndicator;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.455 -0500", hash_original_field = "163BC3DB44D266D2E0D599969FE1A091", hash_generated_field = "E2D3138AC87B2928B6D9F7D3E2806194")

    public int mIconIndex;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.457 -0500", hash_original_field = "4FDF93BDA88F02959E0A7BC3ACE5E29B", hash_generated_field = "E2573C2723080B8CA6F6E83E7C9B5FCA")

    public int mIconMode;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.459 -0500", hash_original_field = "B5669539133B8C51E2A694C3908B5533", hash_generated_field = "6B94FFC7AEAAEC33DBD862020F0D8889")

    public String mEriText;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.461 -0500", hash_original_field = "2D45C2865ADA224B1C43C9966460E739", hash_generated_field = "5A1D3B3CD1A43B21BB897437159982AE")

    public int mCallPromptId;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.463 -0500", hash_original_field = "5E39647DCF5CA63D51159C8F85ADC430", hash_generated_field = "F11A924874A31CA1797A8BE7FCA7E429")

    public int mAlertId;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:57.466 -0500", hash_original_method = "523A7CAAB1F3203BD5E6C41D254336C4", hash_generated_method = "E84685C2D0CE4AD1890EB9EDF8993FE3")
    
public EriInfo (int roamingIndicator, int iconIndex, int iconMode, String eriText,
            int callPromptId, int alertId) {

        this.mRoamingIndicator = roamingIndicator;
        this.mIconIndex = iconIndex;
        this.mIconMode = iconMode;
        this.mEriText = eriText;
        this.mCallPromptId = callPromptId;
        this.mAlertId = alertId;
    }
}

