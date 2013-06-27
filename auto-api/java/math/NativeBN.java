package java.math;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

final class NativeBN {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:42.745 -0400", hash_original_method = "E90C9F7618B8847FE731998C9CEE159F", hash_generated_method = "E90C9F7618B8847FE731998C9CEE159F")
    public NativeBN ()
    {
        //Synthesized constructor
    }


        public static int ERR_get_error() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static String ERR_error_string(int e) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static int BN_new() {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void BN_free(int a) {
    }

    
        public static int BN_cmp(int a, int b) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static boolean BN_copy(int to, int from) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean putLongInt(int a, long dw) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean putULongInt(int a, long dw, boolean neg) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static int BN_dec2bn(int a, String str) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int BN_hex2bn(int a, String str) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static boolean BN_bin2bn(byte[] s, int len, boolean neg, int ret) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean litEndInts2bn(int[] ints, int len, boolean neg, int ret) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean twosComp2bn(byte[] s, int len, int ret) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static long longInt(int a) {
        return DSUtils.UNKNOWN_LONG;
    }

    
        public static String BN_bn2dec(int a) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static String BN_bn2hex(int a) {
        //DSFIXME:  CODE0012: Native static method requires manual modeling
    }

    
        public static byte[] BN_bn2bin(int a) {
        return {DSUtils.UNKNOWN_BYTE};
    }

    
        public static int[] bn2litEndInts(int a) {
        return {DSUtils.UNKNOWN_INT};
    }

    
        public static int sign(int a) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static void BN_set_negative(int b, int n) {
    }

    
        public static int bitLength(int a) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static boolean BN_is_bit_set(int a, int n) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean modifyBit(int a, int n, int op) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_shift(int r, int a, int n) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_add_word(int a, int w) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_sub_word(int a, int w) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_mul_word(int a, int w) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static int BN_div_word(int a, int w) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static int BN_mod_word(int a, int w) {
        return DSUtils.UNKNOWN_INT;
    }

    
        public static boolean BN_add(int r, int a, int b) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_sub(int r, int a, int b) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_gcd(int r, int a, int b) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_mul(int r, int a, int b) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_exp(int r, int a, int p) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_div(int dv, int rem, int m, int d) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_nnmod(int r, int a, int m) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_mod_exp(int r, int a, int p, int m) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_mod_inverse(int ret, int a, int n) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_generate_prime_ex(int ret, int bits, boolean safe,
            int add, int rem, int cb) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
        public static boolean BN_is_prime_ex(int p, int nchecks, int cb) {
        return DSUtils.UNKNOWN_BOOLEAN;
    }

    
}

