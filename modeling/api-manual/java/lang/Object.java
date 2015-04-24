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
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * Copyright (C) 2008 The Android Open Source Project
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


package java.lang;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSTaintObject;

public class Object {
    //do not create DSTaintObject, allocations of DSTaintObject are added to the code by 
    //the DroidSafe tool when needed.
	public DSTaintObject taint;

	@DSModeled(DSC.SAFE)
	public Object() {
    }
	
	@DSModeled(DSC.SAFE)
	public int hashCode() {
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	protected void finalize() throws Throwable {
    }
	
	@DSModeled(DSC.SAFE)
	public boolean equals(Object o) {
		return true;
        //return this == o;
    }
	
	//Since this is a fundamental JVM generated item, we will not cut it over to a non-native implementation
	@DSModeled(DSC.SAFE)
	public final native Class<?> getClass();
	
	//Since this is a fundamental JVM generated item, we will not cut it over to a non-native implementation
	@DSModeled(DSC.SAFE)
	private native Object internalClone(Cloneable o);
	
	@DSModeled(DSC.SAFE)
	protected Object clone() throws CloneNotSupportedException {
        if (!(this instanceof Cloneable)) {
            throw new CloneNotSupportedException("Class doesn't implement Cloneable");
        }

        return internalClone((Cloneable) this);
    }
	
	@DSModeled(DSC.SAFE)
	public String toString() {
		return "woot!";
        //return getClass().getName() + '@' + Integer.toHexString(hashCode());
    }
	
	  @DSModeled(DSC.BAN)
	    public void addTaint(double taint) {
	        //this.taint = taint
	        
	    }

	    @DSModeled(DSC.BAN)
	    public void addTaint(boolean taint) {
	      //this.taint = taint
	    }

	    @DSModeled(DSC.BAN)
	    public void addTaint(DSTaintObject taint) {
	        //this.taint = taint
	    }

	    @DSModeled(DSC.BAN)
	    public byte getTaintByte() {
	        //return this.taint
	        return 0;
	    }

	    @DSModeled(DSC.BAN)
	    public short getTaintShort() {
	        //return this.taint
            return 0;
        }

	    @DSModeled(DSC.BAN)
	    public int getTaintInt() {
	        //return this.taint
            return 0;
        }


	    @DSModeled(DSC.BAN)
	    public long getTaintLong() {
	        //return this.taint
            return 0;
        }


	    @DSModeled(DSC.BAN)
	    public float getTaintFloat() {
	        //return this.taint
            return 0;
        }


	    @DSModeled(DSC.BAN)
	    public double getTaintDouble() {
	        //return this.taint
            return 0;
        }


	    @DSModeled(DSC.BAN)
	    public boolean getTaintBoolean() {
	        //return this.taint
	        return true;
	    }

	    @DSModeled(DSC.BAN)
	    public char getTaintChar() {
	        //return this.taint
            return 0;
        }

	    @DSModeled(DSC.BAN)
	    public DSTaintObject getTaint() {
	        //return this.taint
            return taint;
        }


}
