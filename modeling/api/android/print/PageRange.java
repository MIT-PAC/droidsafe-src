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
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents a range of pages. The start and end page indices of
 * the range are zero based and inclusive.
 */
public final class PageRange implements Parcelable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.123 -0400", hash_original_field = "834B11A828DFE3E76DF3E368DF2D11A3", hash_generated_field = "D81D9A1D8D4F33301391E9DEC1B036F0")

    public static final PageRange ALL_PAGES = new PageRange(0, Integer.MAX_VALUE);
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.142 -0400", hash_original_field = "BC0463E52D51BBF51ABCB05F5A24D7F1", hash_generated_field = "11DD40E2D9F7F053786213483A5BBDB8")

    public static final Parcelable.Creator<PageRange> CREATOR =
            new Creator<PageRange>() {
        @DSSafe(DSCat.SAFE_LIST)
        @Override
        public PageRange createFromParcel(Parcel parcel) {
            return new PageRange(parcel);
        }

        @Override
        public PageRange[] newArray(int size) {
            return new PageRange[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.126 -0400", hash_original_field = "83A19D93B82C07A79F54E265C2077EC6", hash_generated_field = "D233E3389CE5D79EE6040D6A855ED4FF")

    private  int mStart;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.128 -0400", hash_original_field = "6FAA56F5628A0F1DAAFED98EBDB1C99E", hash_generated_field = "EA295975CAF8E42F4C28A87EADB358DF")

    private  int mEnd;

    /**
     * Creates a new instance.
     *
     * @param start The start page index (zero based and inclusive).
     * @param end The end page index (zero based and inclusive).
     *
     * @throws IllegalArgumentException If start is less than zero or end
     * is less than zero or start greater than end.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.129 -0400", hash_original_method = "B49C6B2E83F2DCB55E37911881CD4AF6", hash_generated_method = "9235383EF0F54745C5E594F02936B401")
    
public PageRange(int start, int end) {
        if (start < 0) {
            throw new IllegalArgumentException("start cannot be less than zero.");
        }
        if (end < 0) {
            throw new IllegalArgumentException("end cannot be less than zero.");
        }
        if (start > end) {
            throw new IllegalArgumentException("start must be lesser than end.");
        }
        mStart = start;
        mEnd = end;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.130 -0400", hash_original_method = "387C919CB72133C7F5E9264E64F5B54A", hash_generated_method = "ACFE5EE5C2E541284CC5740C3CD31CE1")
    
private PageRange (Parcel parcel) {
        this(parcel.readInt(), parcel.readInt());
    }

    /**
     * Gets the start page index (zero based and inclusive).
     *
     * @return The start page index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.131 -0400", hash_original_method = "06A9461DEE13B0EC6684E5999EFA43FD", hash_generated_method = "AE824E786DD99F20340A535DB0B3E0D5")
    
public int getStart() {
        return mStart;
    }

    /**
     * Gets the end page index (zero based and inclusive).
     *
     * @return The end page index.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.132 -0400", hash_original_method = "AA6B342CA54FC46C4E66406F1E1F514B", hash_generated_method = "F1B95460B4AE6305472354D3A950A59E")
    
public int getEnd() {
        return mEnd;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.133 -0400", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "8188008AC9C80E87937FE73DCA905200")
    
@Override
    public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.134 -0400", hash_original_method = "1FE7B8B79A5949E4BA0F96EF694CD3E1", hash_generated_method = "C036306FFD2F3D1DAAAB3F58FDB8C898")
    
@Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(mStart);
        parcel.writeInt(mEnd);
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.135 -0400", hash_original_method = "C8F086F6D05439D5EB8D567E91FF7BB2", hash_generated_method = "81F41E70303077E7B8DDDF8C749913C7")
    
@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + mEnd;
        result = prime * result + mStart;
        return result;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.136 -0400", hash_original_method = "06D3CB01D0ED6D0A2FD3EF15377F76C9", hash_generated_method = "3B9F6E66AD549257E60E4C1EEDCE6DD4")
    
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
        PageRange other = (PageRange) obj;
        if (mEnd != other.mEnd) {
            return false;
        }
        if (mStart != other.mStart) {
            return false;
        }
        return true;
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-06 12:51:00.137 -0400", hash_original_method = "49458D88F683CFC562519CCC6028F4B9", hash_generated_method = "4B5E547FB6FFD5603EAB17A33A903C56")
    
@Override
    public String toString() {
        if (mStart == 0 && mEnd == Integer.MAX_VALUE) {
            return "PageRange[<all pages>]";
        }
        StringBuilder builder = new StringBuilder();
        builder.append("PageRange[")
            .append(mStart)
            .append(" - ")
            .append(mEnd)
            .append("]");
        return builder.toString();
    }
}
