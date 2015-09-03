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
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class StringBuilder {
	
	@DSModeled(DSC.SAFE)
	public StringBuilder() {
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder(int i) {
		this();
		addTaint(i);
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder(String str) {
		this();
		addTaint(str.getTaint());
	}
	
	@DSModeled(DSC.SAFE)
	public String toString() {
		//need a pta object and need to propagate information flow
        String str = new String();
        str.addTaint(getTaint());
        return str;
	}

	@DSModeled(DSC.SAFE)
	public StringBuilder append(String str) {
		addTaint(str.getTaint());
		return this;
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder append(Object obj) {
		addTaint(obj.toString().getTaint());
		return this;
	}
	
	@DSModeled(DSC.SAFE)
	public StringBuilder append(int obj) {
		addTaint(obj);
		return this;
	}

	// GITI DSModeled
	@DSModeled(DSC.SAFE)
	public String substring(int start, int end) {
		return new String();
	}

	// GITI DSModeled
	@DSModeled(DSC.SAFE)
	public void append(char[] buf, int i, int left) {
		addTaint(new String(buf).getTaint());
		addTaint(i);
		addTaint(left);
	}
	
}
