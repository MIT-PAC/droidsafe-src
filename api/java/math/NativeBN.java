package java.math;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;
import droidsafe.helpers.DSUtils;

final class NativeBN {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:50.200 -0400", hash_original_method = "E90C9F7618B8847FE731998C9CEE159F", hash_generated_method = "E90C9F7618B8847FE731998C9CEE159F")
    public NativeBN ()
    {
        //Synthesized constructor
    }


    @DSModeled(DSC.SAFE)
    public static int ERR_get_error() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942783130 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1942783130;
	}

    
    @DSModeled(DSC.SAFE)
    public static String ERR_error_string(int e) {
		String ret = new String();
		ret.addTaint(e);
		return ret;
	}

    
    @DSModeled(DSC.SAFE)
    public static int BN_new() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212771947 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_212771947;
	}

    
    @DSModeled(DSC.SAFE)
    public static void BN_free(int a) {
	}

    
    @DSModeled(DSC.SAFE)
    public static int BN_cmp(int a, int b) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1875451071 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1875451071;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_copy(int to, int from) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_657776117 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_657776117;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean putLongInt(int a, long dw) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1201338112 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1201338112;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean putULongInt(int a, long dw, boolean neg) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1030268529 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1030268529;
	}

    
    @DSModeled(DSC.SAFE)
    public static int BN_dec2bn(int a, String str) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036448648 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2036448648;
	}

    
    @DSModeled(DSC.SAFE)
    public static int BN_hex2bn(int a, String str) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709942013 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_709942013;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_bin2bn(byte[] s, int len, boolean neg, int ret) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_982942158 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_982942158;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean litEndInts2bn(int[] ints, int len, boolean neg, int ret) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1803420550 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1803420550;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean twosComp2bn(byte[] s, int len, int ret) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_475279098 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_475279098;
	}

    
    @DSModeled(DSC.SAFE)
    public static long longInt(int a) {
		long var0F5264038205EDFB1AC05FBB0E8C5E94_896840564 = DSUtils.UNKNOWN_LONG;
		return var0F5264038205EDFB1AC05FBB0E8C5E94_896840564;
	}

    
    @DSModeled(DSC.SAFE)
    public static String BN_bn2dec(int a) {
		String ret = new String();
		ret.addTaint(a);
		return ret;
	}

    
    @DSModeled(DSC.SAFE)
    public static String BN_bn2hex(int a) {
		String ret = new String();
		ret.addTaint(a);
		return ret;
	}

    
    @DSModeled(DSC.SAFE)
    public static byte[] BN_bn2bin(int a) {
		byte[] var2F9C81BC6E497382285CD6B7A7E33DE1_1740515037 = { DSUtils.UNKNOWN_BYTE };
		return var2F9C81BC6E497382285CD6B7A7E33DE1_1740515037;
	}

    
    @DSModeled(DSC.SAFE)
    public static int[] bn2litEndInts(int a) {
		int[] varB4CCCA26F9DB9189C32F33E82D425CFB_953016634 = { DSUtils.UNKNOWN_INT };
		return varB4CCCA26F9DB9189C32F33E82D425CFB_953016634;
	}

    
    @DSModeled(DSC.SAFE)
    public static int sign(int a) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353803006 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_353803006;
	}

    
    @DSModeled(DSC.SAFE)
    public static void BN_set_negative(int b, int n) {
	}

    
    @DSModeled(DSC.SAFE)
    public static int bitLength(int a) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430614000 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1430614000;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_is_bit_set(int a, int n) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1626736539 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1626736539;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean modifyBit(int a, int n, int op) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_601002990 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_601002990;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_shift(int r, int a, int n) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1877253673 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1877253673;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_add_word(int a, int w) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1705601107 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1705601107;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_sub_word(int a, int w) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1344256189 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1344256189;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_mul_word(int a, int w) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_893227870 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_893227870;
	}

    
    @DSModeled(DSC.SAFE)
    public static int BN_div_word(int a, int w) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555341471 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1555341471;
	}

    
    @DSModeled(DSC.SAFE)
    public static int BN_mod_word(int a, int w) {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915024053 = DSUtils.UNKNOWN_INT;
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_915024053;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_add(int r, int a, int b) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_136987320 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_136987320;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_sub(int r, int a, int b) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1115903411 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1115903411;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_gcd(int r, int a, int b) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_858846462 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_858846462;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_mul(int r, int a, int b) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2056879701 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_2056879701;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_exp(int r, int a, int p) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_91495089 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_91495089;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_div(int dv, int rem, int m, int d) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016071072 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016071072;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_nnmod(int r, int a, int m) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1730842218 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1730842218;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_mod_exp(int r, int a, int p, int m) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2012885287 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_2012885287;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_mod_inverse(int ret, int a, int n) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1713208304 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1713208304;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_generate_prime_ex(int ret, int bits, boolean safe, int add, int rem, int cb) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_371194294 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_371194294;
	}

    
    @DSModeled(DSC.SAFE)
    public static boolean BN_is_prime_ex(int p, int nchecks, int cb) {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2011020564 = DSUtils.UNKNOWN_BOOLEAN;
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_2011020564;
	}

    
}

