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


package android.os;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.UUID;

public final class ParcelUuid implements Parcelable {

    /**
     * Creates a new ParcelUuid from a string representation of {@link UUID}.
     *
     * @param uuid
     *            the UUID string to parse.
     * @return an ParcelUuid instance.
     * @throws NullPointerException
     *             if {@code uuid} is {@code null}.
     * @throws IllegalArgumentException
     *             if {@code uuid} is not formatted correctly.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.529 -0500", hash_original_method = "E6B1B98CB06402B91557E2127042443C", hash_generated_method = "3B1A96151CFB5C87C502D113B6EDDB82")
    
public static ParcelUuid fromString(String uuid) {
        return new ParcelUuid(UUID.fromString(uuid));
    }
    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:23:27.158 -0400", hash_original_field = "DAF10E97A432AC719FB06B3080752505", hash_generated_field = "BB5540FFC228809144D41EB7EDD6B529")

    public static final Parcelable.Creator<ParcelUuid> CREATOR =
               new Parcelable.Creator<ParcelUuid>() {
        @DSSafe(DSCat.SAFE_OTHERS)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.541 -0500", hash_original_method = "BE0C39B58500BBF13D262DF9616543A0", hash_generated_method = "B27DC4A4AF2601AAD28EE687E1A31292")
        
public ParcelUuid createFromParcel(Parcel source) {
            long mostSigBits = source.readLong();
            long leastSigBits = source.readLong();
            UUID uuid = new UUID(mostSigBits, leastSigBits);
            return new ParcelUuid(uuid);
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.543 -0500", hash_original_method = "DE9AFB44E7C5EC1F2E4B30CF11F48D0E", hash_generated_method = "6ABB4D3C46B8D91D4AC296EB1B082071")
        
public ParcelUuid[] newArray(int size) {
            return new ParcelUuid[size];
        }
    };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.524 -0500", hash_original_field = "AFE074E0052115B31F5D8A3FD1E72383", hash_generated_field = "318090B38C1325AB0A6BDE7565479F55")

    private  UUID mUuid;

    /**
     * Constructor creates a ParcelUuid instance from the
     * given {@link UUID}.
     *
     * @param uuid UUID
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.527 -0500", hash_original_method = "CF473C61D493B6FE5C1BBCA31D442219", hash_generated_method = "459E45C76BAE7217AFBFC5C3824557F9")
    
public ParcelUuid(UUID uuid) {
        mUuid = uuid;
    }

    /**
     * Get the {@link UUID} represented by the ParcelUuid.
     *
     * @return UUID contained in the ParcelUuid.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.531 -0500", hash_original_method = "0CE9C43DAF663B7B5A7713ED255C5D05", hash_generated_method = "CD4C404E34D314168EA75627745609DF")
    
public UUID getUuid() {
        return mUuid;
    }

    /**
     * Returns a string representation of the ParcelUuid
     * For example: 0000110B-0000-1000-8000-00805F9B34FB will be the return value.
     *
     * @return a String instance.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.533 -0500", hash_original_method = "88F1B202F7B60E8AC7861421AE6F35A5", hash_generated_method = "C5FA242F4A359EC31EDD6D0EE8CF7183")
    
@Override
    public String toString() {
        return mUuid.toString();
    }

   @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.535 -0500", hash_original_method = "3F38019E558A882D8ACF21219C1A6CB1", hash_generated_method = "D482F257FB9D39C233BA23B515F5D841")
    
@Override
   public int hashCode() {
       return mUuid.hashCode();
   }

   /**
    * Compares this ParcelUuid to another object for equality. If {@code object}
    * is not {@code null}, is a ParcelUuid instance, and all bits are equal, then
    * {@code true} is returned.
    *
    * @param object
    *            the {@code Object} to compare to.
    * @return {@code true} if this ParcelUuid is equal to {@code object}
    *         or {@code false} if not.
    */
   @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.537 -0500", hash_original_method = "03E4868AC4B42986ECAD1235C75A1F23", hash_generated_method = "A3CBD1AAE0450E56A46BE79478BEA398")
    
@Override
   public boolean equals(Object object) {
       if (object == null) {
           return false;
       }

       if (this == object) {
           return true;
       }

       if (!(object instanceof ParcelUuid)) {
           return false;
       }

       ParcelUuid that = (ParcelUuid) object;

       return (this.mUuid.equals(that.mUuid));
   }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.547 -0500", hash_original_method = "00F8174F9E89D0C972FA6D3F19742382", hash_generated_method = "D90463461B2A94FF94D13FDF69BB80C9")
    
public int describeContents() {
        return 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:33:44.549 -0500", hash_original_method = "914E719E6FA80BA5E3F689C4DD681C77", hash_generated_method = "048E1DDD52B8FCBDECE0B20BD4C6AE8E")
    
public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(mUuid.getMostSignificantBits());
        dest.writeLong(mUuid.getLeastSignificantBits());
    }
}

