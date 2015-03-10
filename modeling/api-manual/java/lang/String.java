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

import java.util.Arrays;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public class String implements java.io.Serializable, Comparable<String>, CharSequence {
	
	public static final Class<String> TYPE = new Class<String>();
	
    private final char value[];
	
	@DSModeled(DSC.SAFE)
	public String() {
		value = new char[0];
    }
	
	@DSModeled(DSC.SAFE)
	public String(String s) {
		value = new char[0];
        addTaint(s.getTaint());
    }
	
	@DSModeled(DSC.SAFE)
	public char[] toCharArray() {
        char[] charArray = new char[0];
        charArray.addTaint(getTaint());
        return charArray;
	}
	
	@DSModeled(DSC.SAFE)
	public int hashCode() {
		return 0;
	}

	@DSModeled(DSC.SAFE)
	public int length() {
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public String toString() {
        return this;
    }

	@Override
	@DSModeled(DSC.SAFE)
	public char charAt(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int compareTo(String o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public static String valueOf(char[] data) {
		return new String();
        //return new String(data, 0, data.length);
    }
	
	@DSModeled(DSC.SAFE)
	public static String valueOf(char value) {
		return new String();
		/*
        String s;
        if (value < 128) {
            s = new String(value, 1, ASCII);
        } else {
            s = new String(0, 1, new char[] { value });
        }
        s.hashCode = value;
        return s;
        */
    }
	
	@DSModeled(DSC.SAFE)
	public static String valueOf(Object value) {
		return value.toString(); 
	}
	
	@DSModeled(DSC.SAFE)
	public static String valueOf(int i) {
        return new String();
    }
	
	@DSModeled(DSC.SAFE)
	public String(char value[]) {
        this.value = Arrays.copyOf(value, value.length);
    }

}
