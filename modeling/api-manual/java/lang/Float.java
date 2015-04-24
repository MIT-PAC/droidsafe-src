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

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSModeled;


public final class Float extends Number implements Comparable<Float> {
	
	static final int EXPONENT_BIAS = 127;
	static final int EXPONENT_BITS = 9;
	static final int MANTISSA_BITS = 23;
	static final int NON_MANTISSA_BITS = 9;
	static final int SIGN_MASK     = 0x80000000;
	static final int EXPONENT_MASK = 0x7f800000;
	static final int MANTISSA_MASK = 0x007fffff;
	private static final long serialVersionUID = -2671257302660747028L;
	private final float value;
	public static final float MAX_VALUE = 3.40282346638528860e+38f;
	public static final float MIN_VALUE = 1.40129846432481707e-45f;
	public static final float NaN = 0.0f / 0.0f;
	public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
	public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
	public static final float MIN_NORMAL = 1.1754943508222875E-38f;
	public static final int MAX_EXPONENT = 127;
	public static final int MIN_EXPONENT = -126;
	@SuppressWarnings("unchecked")
    public static final Class<Float> TYPE
            = (Class<Float>) float[].class.getComponentType();
	public static final int SIZE = 32;
	
	@DSModeled(DSC.SAFE)
	public Float(float value){
		addTaint(value);
		this.value = value;
		
		/*
		this.value = value;
		*/
	}
	
	public Float(double value){
		addTaint((float)value);
		this.value = (float)value;
		/*
		this.value = (float) value;
		*/
	}
	
	Float(String string) throws NumberFormatException{
		this(parseFloat(string));
	}
	
	public int compareTo(Float object){
		
		// Original method
		/*
		{
        return compare(value, object.value);
    }
		*/
		return 0;
	}
	
	@Override public byte byteValue(){
		
		// Original method
		/*
		{
        return (byte) value;
    }
		*/
		return 0;
	}
	
	@Override public double doubleValue(){
		return (double)getTaintFloat();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	@Override public boolean equals(Object object){
		
		// Original method
		/*
		{
        return (object instanceof Float) &&
                (floatToIntBits(this.value) == floatToIntBits(((Float) object).value));
    }
		*/
		return false;
	}
	
	public static int floatToIntBits(float value){
		
		// Original method
		return 0;
	}
	
	public static int floatToRawIntBits(float value){
		
		// Original method
		return 0;
	}
	
	@Override public float floatValue(){
		return getTaintFloat();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	@DSModeled(DSC.SAFE)
	@Override public int hashCode(){
		return getTaintInt();
		// Original method
		/*
		{
        return floatToIntBits(value);
    }
		*/
	}
	
	public static float intBitsToFloat(int bits){
		
		// Original method
		return 0;
	}
	
	@Override public int intValue(){
		
		// Original method
		/*
		{
        return (int) value;
    }
		*/
		return 0;
	}
	
	public boolean isInfinite(){
		
		// Original method
		/*
		{
        return isInfinite(value);
    }
		*/
		return false;
	}
	
	public static boolean isInfinite(float f){
		
		// Original method
		/*
		{
        return (f == POSITIVE_INFINITY) || (f == NEGATIVE_INFINITY);
    }
		*/
		return false;
	}
	
	public boolean isNaN(){
		
		// Original method
		/*
		{
        return isNaN(value);
    }
		*/
		return false;
	}
	
	public static boolean isNaN(float f){
		
		// Original method
		/*
		{
        return f != f;
    }
		*/
		return false;
	}
	
	@Override public long longValue(){
		
		// Original method
		/*
		{
        return (long) value;
    }
		*/
		return 0;
	}
	
	public static float parseFloat(String string){
		
		// Original method
		/*
		{
        return StringToReal.parseFloat(string);
    }
		*/
		return 0;
	}
	
	@Override public short shortValue(){
		
		// Original method
		/*
		{
        return (short) value;
    }
		*/
		return 0;
	}
	
	@Override public String toString(){
		
		// Original method
		/*
		{
        return Float.toString(value);
    }
		*/
		return "";
	}
	
	public static String toString(float f){
		
		// Original method
		/*
		{
        return RealToString.getInstance().floatToString(f);
    }
		*/
		return "";
	}
	
	public static Float valueOf(String string){
		
		// Original method
		/*
		{
        return parseFloat(string);
    }
		*/
		return null;
	}
	
	public static int compare(float float1, float float2){
		
		// Original method
		/*
		{
        
        if (float1 > float2) {
            return 1;
        }
        if (float2 > float1) {
            return -1;
        }
        if (float1 == float2 && 0.0f != float1) {
            return 0;
        }

        
        if (isNaN(float1)) {
            if (isNaN(float2)) {
                return 0;
            }
            return 1;
        } else if (isNaN(float2)) {
            return -1;
        }

        
        int f1 = floatToRawIntBits(float1);
        int f2 = floatToRawIntBits(float2);
        
        
        
        return (f1 >> 31) - (f2 >> 31);
    }
		*/
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public static Float valueOf(float f){
		return new Float(f);
		// Original method
		/*
		{
        return new Float(f);
    }
		*/
	}
	
	public static String toHexString(float f){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return "";
	}
}


