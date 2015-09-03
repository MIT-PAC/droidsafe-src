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
 * Copyright (C) 2006 The Android Open Source Project
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


package android.content;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

/*
 * New model generated on 4/16/13 by GITI.  The original model had 
 * "too much" in it which was making it difficult to focus on a clean
 * model for some of the initial set of target applications.  The model 
 * was a ground up build using the Android SDK source and the original MIT 
 * model as reference and as such should be reflective of the markup and 
 * the functionality of the originals.
 * @author sgraf
 */

public class Intent implements Parcelable, Cloneable {
	
	private String mAction;
    private Uri mData;
    private String mType;
    private String mPackage;
    private ComponentName mComponent;
    private int mFlags;
    private HashSet<String> mCategories;
    private Bundle mExtras;
    private Rect mSourceBounds;
    private Intent mSelector;
	
	
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		
	}
	
	@DSModeled() // Marked as SPEC per the original implementation from MIT
	public Intent(String action, Uri uri) {
        setAction(action);
        mData = uri;
    }
	
	@DSModeled() // Marked as SPEC per the original implementation from MIT
	public Intent() {
		//Do Nothing
	}
	
	@DSModeled() // Marked as SPEC per the original implementation from MIT
	public Intent(String action) {
        setAction(action);
    }
	
	@DSModeled() // Marked as SPEC per the original implementation from MIT
	private Intent(Intent o, boolean all) {
		/*
		 * Piggyback on the setters to track the taint.  The desire here
		 * is to "inherit" the taint from the Intent that is passed in
		 */
		this.setAction(o.getAction());
		this.setData(o.getData());
		this.setType(o.getType());
		this.setPackage(o.getPackage());
		this.setComponent(o.getComponent());
		for (String category : o.getCategories()) {
			this.addCategory(category);
		}
		/*
		this.setCategories
        this.mAction = o.mAction;
        this.mData = o.mData;
        this.mType = o.mType;
        this.mPackage = o.mPackage;
        this.mComponent = o.mComponent;
        if (o.mCategories != null) {
            this.mCategories = new HashSet<String>(o.mCategories);
        }
        */
    }

    /**
     * Make a clone of only the parts of the Intent that are relevant for
     * filter matching: the action, data, type, component, and categories.
     */
    @DSModeled // Marked as SPEC per the original implementation from MIT
    public Intent cloneFilter() {
        return new Intent(this, false);
    }
	
	@DSModeled(DSC.SAFE) // Marked as SPEC per the original implementation from MIT
	public String getAction() {
		return mAction;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Intent setAction(String action) {
		mAction = action;
        //mAction = action != null ? action.intern() : null;
        return this;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Intent addFlags(int flags) {
        addTaint(flags);
        return this;
    }
	
	@DSModeled(DSC.SAFE) // Marked as SPEC per the original implementation from MIT
	public String getType() {
        return mType;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Intent setType(String type) {
            mData=null;
            mType = type;
            return this;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Uri getData() {
        return mData;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Intent setData(Uri data) {
        mData = data;
		/*
        mType = null;
        */
        return this;
    }
	
	@DSModeled(value = DSC.SAFE)
	public ComponentName getComponent() {
		return mComponent;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Intent setComponent(ComponentName component) {
        mComponent = component;
        return this;
    }
	
	@DSModeled(value = DSC.SAFE)
	public void setAllowFds(boolean allowFds) {
		// NOTE:  mExtras is a Bundle, perhaps it is best to push the taint down to that level
		addTaint(allowFds);
		/*
        if (mExtras != null) {
            mExtras.setAllowFds(allowFds);
        }
        */
    }
	
	@DSModeled(value = DSC.SAFE)
	public String resolveTypeIfNeeded(ContentResolver resolver) {
		/*
		if (mComponent != null) {
		    return getType();
		}
		return resolveType(resolver);
		*/
		return getType();  //At the end of the day, it's a string, and we are doing static analysis
    }
	
	@DSModeled(value = DSC.SAFE)
	public String resolveType(ContentResolver resolver) {
		/*
        if (mType != null) {
            return mType;
        }
        if (mData != null) { 
            if ("content".equals(mData.getScheme())) {
                return resolver.getType(mData);
            }
        }
        return null;
        */
		return getType();  //At the end of the day, it's a string, and we are doing static analysis
    }
	
	@DSModeled(value = DSC.SAFE)
	public String getPackage() {
		return mPackage;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Intent setPackage(String packageName) {
        if (packageName != null && mSelector != null) {
            throw new IllegalArgumentException(
                    "Can't set package name when selector is already set");
        }
        mPackage = packageName;
        return this;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Set<String> getCategories() {
		return mCategories;
    }
	
	public Intent addCategory(String category) {
		mCategories.addTaint(category.getTaint());
		/*
        if (mCategories == null) {
            mCategories = new HashSet<String>();
        }
        mCategories.add(category.intern());
        */
        return this;
    }
	
	@DSModeled(value = DSC.SAFE)
	public Intent putExtra(String name, Serializable value) {
        mExtras = new Bundle();
        mExtras.putSerializable(name, value);
        return this;
    }
	
	@DSModeled(value = DSC.SAFE)
	public String getDataString() {
		return mData.toString();
        //return mData != null ? mData.toString() : null;
    }
}
