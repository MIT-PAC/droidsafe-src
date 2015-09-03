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
 */

package com.google.android.gms.ads;
import droidsafe.annotations.DSSafe;
import android.content.Context;

import droidsafe.annotations.*;
public class AdSize {

	private int width;
	private int height;

	@DSSafe(DSCat.SAFE_LIST)
	public int getWidthInPixels(Context r3) {
		// TODO Auto-generated method stub
		return width;
	}
	
	@DSSafe(DSCat.SAFE_LIST)
	public int getWidth() {
		return width;
	}

	@DSSafe(DSCat.SAFE_LIST)
	public int getHeightInPixels(Context r3) {
		// TODO Auto-generated method stub
		return height;
	}
	
	@DSSafe(DSCat.SAFE_LIST)
	public int getHeight() {
		return height;
	}
	
	@DSSafe(DSCat.SAFE_OTHERS)
	public AdSize(int w, int h) {
		width = w;
		height = h;
	}

	@DSSafe(DSCat.SAFE_LIST)
	public boolean isAutoHeight() {
		return ((width + height) == 1);
	}

	@DSSafe(DSCat.SAFE_LIST)
	public boolean isFullWidth() {
		return ((width + height) == 1);
		
	}
	
	 public static final int FULL_WIDTH = -1;
	  public static final int AUTO_HEIGHT = -2;
	  private static final AdSize defaultSize = new AdSize(0, 0);

	  public static final AdSize BANNER = defaultSize;
	  public static final AdSize FULL_BANNER = defaultSize;
	  public static final AdSize LARGE_BANNER = defaultSize;
	  public static final AdSize LEADERBOARD = defaultSize;
	  public static final AdSize MEDIUM_RECTANGLE = defaultSize;
	  public static final AdSize WIDE_SKYSCRAPER = defaultSize;
	  public static final AdSize SMART_BANNER = defaultSize;

}
