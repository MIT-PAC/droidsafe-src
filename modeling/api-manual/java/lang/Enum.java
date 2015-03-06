/* Licensed to the Apache Software Foundation (ASF) under one or more
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


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.lang;

import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;

public abstract class Enum<E extends Enum<E>> implements Serializable, Comparable<E> {
	private static final long serialVersionUID = -4300926546619394005L;
	
	//private final String name;

    //private final int ordinal;
    
	
    @DSModeled(DSC.SAFE)
	protected Enum(String name, int ordinal) {
		addTaint(name.getTaint());
		addTaint(ordinal);
    }
	
	public final int compareTo(E o) {
		return -1;
		/*
		 * the enum constant's ordinal, which corresponds to its position
		 * in the enum declaration, starting at zero.
		 */
        //return ordinal - o.ordinal;
    }
	
	public static <T extends Enum<T>> T valueOf(Class<T> enumType, String name) {
		return getSharedConstants(enumType)[0];  //Should be OK to send back fudged value for the purposes of modeling
		/*
        if (enumType == null || name == null) {
            throw new NullPointerException("enumType == null || name == null");
        }
        if (!enumType.isEnum()) {
            throw new IllegalArgumentException(enumType + " is not an enum type");
        }
        for (T value : getSharedConstants(enumType)) {
            if (name.equals(value.name())) {
                return value;
            }
        }
        throw new IllegalArgumentException(name + " is not a constant in " + enumType.getName());
        */
    }
	
	@SuppressWarnings("unchecked") // the cache always returns the type matching enumType
    public static <T extends Enum<T>> T[] getSharedConstants(Class<T> enumType) {
		return (T[])new Object[0];  //Short circuit the complexity
        //return (T[]) sharedConstantsCache.get(enumType);
    }
	
	/*
    private static final BasicLruCache<Class<? extends Enum>, Object[]> sharedConstantsCache
	    = new BasicLruCache<Class<? extends Enum>, Object[]>(64) {
	@Override protected Object[] create(Class<? extends Enum> enumType) {
	    Method method = (Method) Class.getDeclaredConstructorOrMethod(
	            enumType, "values", EmptyArray.CLASS);
	    try {
	        return (Object[]) method.invoke((Object[]) null);
	    } catch (IllegalAccessException impossible) {
	        throw new AssertionError();
	    } catch (InvocationTargetException impossible) {
	        throw new AssertionError();
	    }
	}
	};
	*/
	
	@DSModeled(DSC.SAFE)
	@Override
    @SuppressWarnings("FinalizeDoesntCallSuperFinalize")
    protected final void finalize() {
    }
	
	@DSModeled(DSC.SAFE)
	@Override
	public String toString() {
                String str = new String();
                str.addTaint(getTaint());
		return str;
	}
	
}
