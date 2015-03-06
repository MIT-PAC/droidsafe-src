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


package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

import droidsafe.helpers.DSUtils;

final class NativeBN {
    
    public static int ERR_get_error() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942783130 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942783130;
	}
    
    public static String ERR_error_string(int e) {
		String ret = new String();
		ret.addTaint(e);
		return ret;
	}
    
    public static int BN_new() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212771947 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212771947;
	}
    
    public static void BN_free(int a) {
	}
    
    public static int BN_cmp(int a, int b) {
        return a + b;
	}
    
    public static boolean BN_copy(int to, int from) {
        return 1 == ((to + from));
	}
    
    public static boolean putLongInt(int a, long dw) {
        return 1 == ((a + dw));
	}
    
    public static boolean putULongInt(int a, long dw, boolean neg) {
        return  1 == (a + dw + ((neg) ? 1 : 0));
	}
    
    public static int BN_dec2bn(int a, String str) {
        return str.getTaintInt() + a;
	}
    
    public static int BN_hex2bn(int a, String str) {
        return str.getTaintInt() + a;
	}
    
    public static boolean BN_bin2bn(byte[] s, int len, boolean neg, int ret) {
        return 1 == ((s.getTaintInt() + s[0] + len + ret) + 0 + ((neg) ? 1 : 0));
	}
    
    public static boolean litEndInts2bn(int[] ints, int len, boolean neg, int ret) {
        return 1 == (((ints.getTaintInt() + ints[0] + len + ret) + 0) + ((neg) ? 1 : 0));
	}
    
    public static boolean twosComp2bn(byte[] s, int len, int ret) {
        return 1 == (((s.getTaintInt() + s[0] + len + ret) + 0));
	}
    
    public static long longInt(int a) {
        return a;
	}
    
    public static String BN_bn2dec(int a) {
		String ret = new String();
		ret.addTaint(a);
		return ret;
	}
    
    public static String BN_bn2hex(int a) {
		String ret = new String();
		ret.addTaint(a);
		return ret;
	}
    
    public static byte[] BN_bn2bin(int a) {
		byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1740515037 = { (byte)a};
		return var2F9C81BC6E497382285CD6B7A7E33DE1_1740515037;
	}
    
    public static int[] bn2litEndInts(int a) {
		int[] varB4CCCA26F9DB9189C32F33E82D425CFB_953016634 = { a };
		return varB4CCCA26F9DB9189C32F33E82D425CFB_953016634;
	}
    
    public static int sign(int a) {
		return a;
	}
    
    public static void BN_set_negative(int b, int n) {
	}
    
    public static int bitLength(int a) {
        return a;
	}
    
    public static boolean BN_is_bit_set(int a, int n) {
        return 1 == ((a + n));
	}
    
    public static boolean modifyBit(int a, int n, int op) {
        return 1 == (((a + n ) + op));
	}
    
    public static boolean BN_shift(int r, int a, int n) {
        return 1 == (((a + n ) + r));
	}
    
    public static boolean BN_add_word(int a, int w) {
        return 1 == ((a + w));
	}
    
    public static boolean BN_sub_word(int a, int w) {
        return 1 == ((a + w));
	}
    
    public static boolean BN_mul_word(int a, int w) {
        return 1 == ((a + w));
	}
    
    public static int BN_div_word(int a, int w) {
        return a + w;
	}
    
    public static int BN_mod_word(int a, int w) {
        return a + w;
	}
    
    public static boolean BN_add(int r, int a, int b) {
        return 1 == (((a + r + b) + 0));
	}
    
    public static boolean BN_sub(int r, int a, int b) {
        return 1 == (((a + r + b) + 0));
	}
    
    public static boolean BN_gcd(int r, int a, int b) {
        return 1 == (((a + r + b) + 0));
	}
    
    public static boolean BN_mul(int r, int a, int b) {
        return 1 == (((a + r + b) + 0));
	}
    
    public static boolean BN_exp(int r, int a, int p) {
        return 1 == (((a + r + p) + 0));
	}
    
    public static boolean BN_div(int dv, int rem, int m, int d) {
        return 1 == (((dv + rem + m + d) + 0));
	}
    
    public static boolean BN_nnmod(int r, int a, int m) {
        return 1 == (((a + r + m) + 0));
	}
    
    public static boolean BN_mod_exp(int r, int a, int p, int m) {
        return 1 == (((a + r + p + m) + 0));
	}
    
    public static boolean BN_mod_inverse(int ret, int a, int n) {
        return 1 == (((ret + a + n) + 0));
	}
    
    public static boolean BN_generate_prime_ex(int ret, int bits, boolean safe, int add, int rem, int cb) {
        return 1 == (0 + ret + bits + add + rem + cb + ((safe) ? 1 : 0));
	}
    
    public static boolean BN_is_prime_ex(int p, int nchecks, int cb) {
        return 1 == ((0 + (p + nchecks + cb)));
	}
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.200 -0400", hash_original_method = "E90C9F7618B8847FE731998C9CEE159F", hash_generated_method = "E90C9F7618B8847FE731998C9CEE159F")
    public NativeBN ()
    {
        //Synthesized constructor
    }
    
}

