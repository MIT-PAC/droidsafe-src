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


@FindBugsSuppressWarnings("DM_NUMBER_CTOR") public final class Long extends Number implements Comparable<Long> {
	
	private static final long serialVersionUID = 4290774380558885855L;
	private final long value;
	public static final long MAX_VALUE = 0x7FFFFFFFFFFFFFFFL;
	public static final long MIN_VALUE = 0x8000000000000000L;
	@SuppressWarnings("unchecked")
    public static final Class<Long> TYPE
            = (Class<Long>) long[].class.getComponentType();
	public static final int SIZE = 64;
	
	@DSModeled(DSC.SAFE)
	Long(long value){
		addTaint(value);
		this.value = value;
		/*
		this.value = value;
		*/
	}
	
	@DSModeled(DSC.SAFE)
	Long(String string) throws NumberFormatException{
		this(parseLong(string));
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
	
	public int compareTo(Long object){
		
		// Original method
		/*
		{
        return compare(value, object.value);
    }
		*/
		return 0;
	}
	
	public static int compare(long lhs, long rhs){
		
		// Original method
		/*
		{
        return lhs < rhs ? -1 : (lhs == rhs ? 0 : 1);
    }
		*/
		return 0;
	}
	
	private static NumberFormatException invalidLong(String s){
		
		// Original method
		/*
		{
        throw new NumberFormatException("Invalid long: \"" + s + "\"");
    }
		*/
		return null;
	}
	
	public static Long decode(String string){
		
		// Original method
		/* Original Method Too Long, Refer to Original Implementation */
		return null;
	}
	
	@Override public double doubleValue(){
		return getTaintDouble();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	@Override public boolean equals(Object o){
		
		// Original method
		/*
		{
        return (o instanceof Long) && (((Long) o).value == value);
    }
		*/
		return false;
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
	
	public static Long getLong(String string){
		
		// Original method
		/*
		{
        if (string == null || string.length() == 0) {
            return null;
        }
        String prop = System.getProperty(string);
        if (prop == null) {
            return null;
        }
        try {
            return decode(prop);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
		*/
		return null;
	}
	
	public static Long getLong(String string, long defaultValue){
		
		// Original method
		/*
		{
        if (string == null || string.length() == 0) {
            return valueOf(defaultValue);
        }
        String prop = System.getProperty(string);
        if (prop == null) {
            return valueOf(defaultValue);
        }
        try {
            return decode(prop);
        } catch (NumberFormatException ex) {
            return valueOf(defaultValue);
        }
    }
		*/
		return null;
	}
	
	public static Long getLong(String string, Long defaultValue){
		
		// Original method
		/*
		{
        if (string == null || string.length() == 0) {
            return defaultValue;
        }
        String prop = System.getProperty(string);
        if (prop == null) {
            return defaultValue;
        }
        try {
            return decode(prop);
        } catch (NumberFormatException ex) {
            return defaultValue;
        }
    }
		*/
		return null;
	}
	
	@Override public int hashCode(){
		
		// Original method
		/*
		{
        return (int) (value ^ (value >>> 32));
    }
		*/
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
	
	@Override public long longValue(){
		return getTaintLong();
		
		// Original method
		/*
		{
        return value;
    }
		*/
	}
	
	public static long parseLong(String string){
		
		// Original method
		/*
		{
        return parseLong(string, 10);
    }
		*/
		return 0;
	}
	
	public static long parseLong(String string, int radix){
		
		// Original method
		/*
		{
        if (radix < Character.MIN_RADIX || radix > Character.MAX_RADIX) {
            throw new NumberFormatException("Invalid radix: " + radix);
        }
        if (string == null) {
            throw invalidLong(string);
        }
        int length = string.length(), i = 0;
        if (length == 0) {
            throw invalidLong(string);
        }
        boolean negative = string.charAt(i) == '-';
        if (negative && ++i == length) {
            throw invalidLong(string);
        }

        return parse(string, i, radix, negative);
    }
		*/
		return 0;
	}
	
	private static long parse(String string, int offset, int radix, boolean negative){
		
		// Original method
		/*
		{
        long max = Long.MIN_VALUE / radix;
        long result = 0, length = string.length();
        while (offset < length) {
            int digit = Character.digit(string.charAt(offset++), radix);
            if (digit == -1) {
                throw invalidLong(string);
            }
            if (max > result) {
                throw invalidLong(string);
            }
            long next = result * radix - digit;
            if (next > result) {
                throw invalidLong(string);
            }
            result = next;
        }
        if (!negative) {
            result = -result;
            if (result < 0) {
                throw invalidLong(string);
            }
        }
        return result;
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
	
	public static String toBinaryString(long v){
		
		// Original method
		/*
		{
        return IntegralToString.longToBinaryString(v);
    }
		*/
		return "";
	}
	
	public static String toHexString(long v){
		
		// Original method
		/*
		{
        return IntegralToString.longToHexString(v);
    }
		*/
		return "";
	}
	
	public static String toOctalString(long v){
		
		// Original method
		/*
		{
        return IntegralToString.longToOctalString(v);
    }
		*/
		return "";
	}
	
	@Override public String toString(){
		
		// Original method
		/*
		{
        return Long.toString(value);
    }
		*/
		return "";
	}
	
	public static String toString(long n){
		
		// Original method
		/*
		{
        return IntegralToString.longToString(n);
    }
		*/
		return "";
	}
	
	public static String toString(long v, int radix){
		
		// Original method
		/*
		{
        return IntegralToString.longToString(v, radix);
    }
		*/
		return "";
	}
	
	public static Long valueOf(String string){
		
		// Original method
		/*
		{
        return valueOf(parseLong(string));
    }
		*/
		return null;
	}
	
	public static Long valueOf(String string, int radix){
		
		// Original method
		/*
		{
        return valueOf(parseLong(string, radix));
    }
		*/
		return null;
	}
	
	public static long highestOneBit(long v){
		
		// Original method
		/*
		{
        
        v |= (v >> 1);
        v |= (v >> 2);
        v |= (v >> 4);
        v |= (v >> 8);
        v |= (v >> 16);
        v |= (v >> 32);
        return v - (v >>> 1);
    }
		*/
		return 0;
	}
	
	public static long lowestOneBit(long v){
		
		// Original method
		/*
		{
        return v & -v;
    }
		*/
		return 0;
	}
	
	public static int numberOfLeadingZeros(long v){
		
		// Original method
		/*
		{
        
        if (v < 0) {
            return 0;
        }
        if (v == 0) {
            return 64;
        }
        
        

        int n = 1;
        int i = (int) (v >>> 32);
        if (i == 0) {
            n +=  32;
            i = (int) v;
        }
        if (i >>> 16 == 0) {
            n +=  16;
            i <<= 16;
        }
        if (i >>> 24 == 0) {
            n +=  8;
            i <<= 8;
        }
        if (i >>> 28 == 0) {
            n +=  4;
            i <<= 4;
        }
        if (i >>> 30 == 0) {
            n +=  2;
            i <<= 2;
        }
        return n - (i >>> 31);
    }
		*/
		return 0;
	}
	
	public static int numberOfTrailingZeros(long v){
		
		// Original method
		/*
		{
        int low = (int) v;
        return low !=0 ? Integer.numberOfTrailingZeros(low)
                       : 32 + Integer.numberOfTrailingZeros((int) (v >>> 32));
    }
		*/
		return 0;
	}
	
	public static int bitCount(long v){
		
		// Original method
		/*
		{
        
        v -=  (v >>> 1) & 0x5555555555555555L;
        v = (v & 0x3333333333333333L) + ((v >>> 2) & 0x3333333333333333L);
        int i =  ((int)(v >>> 32)) + (int) v;
        i = (i & 0x0F0F0F0F) + ((i >>> 4) & 0x0F0F0F0F);
        i += i >>> 8;
        i += i >>> 16;
        return i  & 0x0000007F;
    }
		*/
		return 0;
	}
	
	public static long rotateLeft(long v, int distance){
		
		// Original method
		/*
		{
        
        return (v << distance) | (v >>> -distance);
    }
		*/
		return 0;
	}
	
	public static long rotateRight(long v, int distance){
		
		// Original method
		/*
		{
        
        return (v >>> distance) | (v << -distance);
    }
		*/
		return 0;
	}
	
	public static long reverseBytes(long v){
		
		// Original method
		/*
		{
        
        
        v = ((v >>> 8) & 0x00FF00FF00FF00FFL) | ((v & 0x00FF00FF00FF00FFL) << 8);
        v = ((v >>>16) & 0x0000FFFF0000FFFFL) | ((v & 0x0000FFFF0000FFFFL) <<16);
        return ((v >>>32)                   ) | ((v                      ) <<32);
    }
		*/
		return 0;
	}
	
	public static long reverse(long v){
		
		// Original method
		/*
		{
        
        
        v = ((v >>> 1) & 0x5555555555555555L) | ((v & 0x5555555555555555L) << 1);
        v = ((v >>> 2) & 0x3333333333333333L) | ((v & 0x3333333333333333L) << 2);
        v = ((v >>> 4) & 0x0F0F0F0F0F0F0F0FL) | ((v & 0x0F0F0F0F0F0F0F0FL) << 4);
        v = ((v >>> 8) & 0x00FF00FF00FF00FFL) | ((v & 0x00FF00FF00FF00FFL) << 8);
        v = ((v >>>16) & 0x0000FFFF0000FFFFL) | ((v & 0x0000FFFF0000FFFFL) <<16);
        return ((v >>>32)                   ) | ((v                      ) <<32);
    }
		*/
		return 0;
	}
	
	public static int signum(long v){
		
		// Original method
		/*
		{
        return v < 0 ? -1 : (v == 0 ? 0 : 1);
    }
		*/
		return 0;
	}
	
	@DSModeled(DSC.SAFE)
	public static Long valueOf(long v){
		return new Long(v);
		// Original method
		/*
		{
        return  v >= 128 || v < -128 ? new Long(v) : SMALL_VALUES[((int) v) + 128];
    }
		*/
	}
	private static final Long[] SMALL_VALUES = new Long[256];
}


