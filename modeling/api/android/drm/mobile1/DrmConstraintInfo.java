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
 * Copyright (C) 2007 The Android Open Source Project
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


package android.drm.mobile1;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Date;

public class DrmConstraintInfo {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.040 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.043 -0500", hash_original_field = "2A053A5B64928AF2EEE297FDDCC581EE", hash_generated_field = "06B1C308557811937D11804124198C4C")

    private long startDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.045 -0500", hash_original_field = "76C698AA2DEDDD233ACDCF077E9DAA8A", hash_generated_field = "007E58F684D95FF371B0E147049B4F3F")

    private long endDate;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.048 -0500", hash_original_field = "848F9DFF1502BD12C449CA1D6F930427", hash_generated_field = "A187678ED22D20A3185A905AC22BB781")

    private long interval;

    /**
     * Construct the DrmConstraint.
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.050 -0500", hash_original_method = "9EDFB4E9C7052BBC86DC69FD90E3B91B", hash_generated_method = "9EDFB4E9C7052BBC86DC69FD90E3B91B")
    
DrmConstraintInfo() {
        count = -1;
        startDate = -1;
        endDate = -1;
        interval = -1;
    }

    /**
     * Get the count constraint.
     *
     * @return the count or -1 if no limit.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.052 -0500", hash_original_method = "992035D2E84A01D01ECB6C67BA762BA7", hash_generated_method = "9A86852F51AAE1FC1A5D83AF3E4A7264")
    
public int getCount() {
        return count;
    }

    /**
     * Get the start date constraint.
     *
     * @return the start date or null if no limit.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.055 -0500", hash_original_method = "EF2100393B586A67476383923E9A11D6", hash_generated_method = "0A15BEC513001629FBF5AB27F966C299")
    
public Date getStartDate() {
        if (startDate == -1)
            return null;

        return new Date(startDate);
    }

    /**
     * Get the end date constraint.
     *
     * @return the end date or null if no limit.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.057 -0500", hash_original_method = "53A3C4742E83A3AEE0A9A0D2D307AB00", hash_generated_method = "90778F21B5C9E2BEB4AC328DB57625C8")
    
public Date getEndDate() {
        if (endDate == -1)
            return null;

        return new Date(endDate);
    }

    /**
     * Get the Interval constraint.
     *
     * @return the interval or -1 if no limit.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:30:02.059 -0500", hash_original_method = "8CAC42DB459590AAD476B56FC6D4D691", hash_generated_method = "E67FF152803801BFA2AB41BED284C3F8")
    
public long getInterval() {
        return interval;
    }
    
}

