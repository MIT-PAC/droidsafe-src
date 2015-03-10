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


package android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class ListView extends AbsListView {

	public ListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public ListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	@DSModeled(DSC.SAFE)
	public ListView(Context context) {
		super(context);
	}

	@DSModeled(DSC.SAFE)
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
	}
	
	@Override
	@DSModeled(DSC.SAFE)
	public void setAdapter(ListAdapter adapter) {
		super.setAdapter(adapter); // Taint in AbsListView
	}
	
	@Override
	void fillGap(boolean down) {
		// TODO Auto-generated method stub
		
	}

	@Override
	int findMotionRow(int y) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	void setSelectionInt(int position) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateViewLayout(View view,
			android.view.ViewGroup.LayoutParams params) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListAdapter getAdapter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSelection(int position) {
		// TODO Auto-generated method stub
		
	}

}
