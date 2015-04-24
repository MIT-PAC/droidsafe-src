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
 * Copyright (C) 2010 The Android Open Source Project
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


package android.app;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class Fragment implements ComponentCallbacks2, OnCreateContextMenuListener {

	@DSModeled	
	public Fragment() {
		onCreateView(new LayoutInflater(), null, null);
	}
	
	@DSModeled
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		//return null;
		return new View(container.getContext());
		
	}
	
	@Override
	public void onConfigurationChanged(Configuration arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLowMemory() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTrimMemory(int arg0) {
		// TODO Auto-generated method stub
		
	}

	@DSModeled
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		
	}
	
	@DSModeled(DSC.SAFE)
	public final String getString(int resId) {
		String str = new String();
        str.addTaint(resId);
        return str;
	}
	
	@DSModeled(DSC.SAFE)
	public final CharSequence getText(int resId) {
        String str = new String();
        str.addTaint(resId);
        return str;
	}

}
