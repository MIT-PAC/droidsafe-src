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


package android.media;

import java.io.IOException;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
/*
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
*/

public class ExifInterface {
	
	@DSModeled() //Decided to go with SPEC because in theory be used for covert data storage
	private void loadAttributes() throws IOException {
		addTaint("string attribute taint".getTaint()); //Implicit taint for getAttribute
		//addTaint(-1.getTaint()); //Implicit taint for getAttributeInt
		//addTaint(-2.getTaint()); //Implicit taint for getAttributeDouble
	}
	
	@DSModeled(value = DSC.SAFE)
	public ExifInterface(String filename) throws IOException {
		addTaint(filename.getTaint());
        //mFilename = filename;
		/*
		 * DSFIXME:  loadAttributes will parse and load values obtained from a
		 * native call that pulls image attributes from the file itself and stores
		 * them in the HashMap mAttributes.  Effectively this is causing an implicit
		 * taint on attributes, since they are being loaded through a native call
		 * which is returning back a series of properties serialized as a space
		 * delimited string (ghetto!).  Access to values stored in
		 * mAttributes is controlled through the getAttribute* series of methods.
		 * This is a first stab at trying to actually taint the attributes themselves
		 */
        loadAttributes();
    }
	
	@DSModeled(value = DSC.SPEC)
	public String getAttribute(String tag) {
        String str = new String();
        str.addTaint(getTaint());
        return str;
        //return mAttributes.get(tag);
    }
	
	public int getAttributeInt(String tag, int defaultValue) {
		return getTaintInt();
	}
	
	/*
	 * Not quite sure how to model this, but nothing is calling it (yet) so
	 * we'll hold off on this.
	public double getAttributeDouble(String tag, double defaultValue) {
		return (double)getTaintInt();
	}
	*/
}
