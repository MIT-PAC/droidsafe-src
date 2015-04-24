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


package android.net;

import java.util.LinkedList;
import java.util.List;

import android.os.Parcel;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

//public abstract class Uri implements Parcelable, Comparable<Uri> {
public class Uri {
	private String uriString;
	
	@DSModeled(DSC.SAFE)
	public int hashCode() {
        return toString().hashCode();
    }

	@DSModeled(DSC.SAFE)
	private Uri() {}  //Prevents external subclassing.
	
	@DSModeled(DSC.SAFE)
	private Uri(String uri) {
		this();
		uriString = uri;
	}
	
	@DSModeled(DSC.SAFE)
	public boolean equals(Object o) {
		return true;
	}
	
	@DSModeled(DSC.SAFE)
	public boolean isOpaque() {
        return getTaintBoolean();
    }
	
	@DSModeled(DSC.SAFE)
	public boolean isAbsolute() {
        return getTaintBoolean();
    }
	
	 
	@DSModeled(DSC.SAFE)
        public static Uri parse(String uriString) {
            return new Uri(uriString);
        }

	@DSModeled()
	public int describeContents() {
		return getTaintInt();
	}

	@DSModeled()
	public void writeToParcel(Parcel dest, int flags) {
		dest.addTaint(getTaint());
	}

	@DSModeled(DSC.SAFE)
	public int compareTo(Uri arg0) {
		// TODO Auto-generated method stub
		return getTaintInt();
	}

	@DSModeled(DSC.SAFE)
	public String getScheme() {
		// TODO Auto-generated method stub
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public boolean isHierarchical() {
		return getTaintBoolean();
	}

	@DSModeled(DSC.SAFE)
	public boolean isRelative() {
		// TODO Auto-generated method stub
		return getTaintBoolean();
	}

	@DSModeled(DSC.SAFE)
	public String getSchemeSpecificPart() {
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String getEncodedSchemeSpecificPart() {
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String getAuthority() {
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String getEncodedAuthority() {
		// TODO Auto-generated method stub
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String getUserInfo() {
		// TODO Auto-generated method stub
		return DSUtils.UNKNOWN_STRING;
	}

	@DSModeled(DSC.SAFE)
	public String getEncodedUserInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@DSModeled(DSC.SAFE)
	public String getHost() {
		// TODO Auto-generated method stub
		return null;
	}

	@DSModeled(DSC.SAFE)
	public int getPort() {
		return getTaintInt();
	}

	@DSModeled(DSC.SAFE)
	public String getPath() {
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String getEncodedPath() {
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String getQuery() {
		// TODO Auto-generated method stub
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String getEncodedQuery() {
		// TODO Auto-generated method stub
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String getFragment() {
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String getEncodedFragment() {
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public List<String> getPathSegments() {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		list.add(uriString);
		return list;
	}

	@DSModeled(DSC.SAFE)
	public String getLastPathSegment() {
		return uriString;
	}

	@DSModeled(DSC.SAFE)
	public String toString() {
                String str = new String();
                str.addTaint(this.getTaint());
		return str;
	}
	
	public static class Builder { 
		public Builder() {}
	}

	@DSModeled()
	public Builder buildUpon() {
		return new Builder();
	}
}
