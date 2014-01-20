package java.math;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

final class BigInt {

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.475 -0500", hash_original_method = "43115F58BFFF7F5154CF32A9B68E359E", hash_generated_method = "90ADC5D097839776282E03BB5D369577")
    
static int consumeErrors(StringBuilder sb) {
        int cnt = 0;
        int e, reason;
        while ((e = NativeBN.ERR_get_error()) != 0) {
            reason = e & 255;
            if (reason == 103) {
                throw new ArithmeticException("BigInteger division by zero");
            }
            if (reason == 108) {
                throw new ArithmeticException("BigInteger not invertible");
            }
            if (reason == 65) {
                throw new OutOfMemoryError();
            }
            sb.append(e).append(": ");
            String s = NativeBN.ERR_error_string(e);
            sb.append(s);
            cnt++;
        }
        return cnt;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.477 -0500", hash_original_method = "1DC9F728E5C31E3B2746DA0BBB8AC6AE", hash_generated_method = "5C17FE8DB05B6D2F58A2A4F76BB86EE1")
    
private static void Check(boolean success) {
        if (!success) {
            StringBuilder sb = new StringBuilder("(openssl)ERR: ");
            int cnt = consumeErrors(sb);
            if (cnt > 0)
                throw new ArithmeticException(sb.toString());
        }
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.482 -0500", hash_original_method = "C76913961CB59EAF110C57E3F5040D8B", hash_generated_method = "52C6A1A96713D68BDD8EDD1D29E3CA6B")
    
private static BigInt newBigInt() {
        BigInt bi = new BigInt();
        bi.bignum = NativeBN.BN_new();
        Check(bi.bignum != 0);
        return bi;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.484 -0500", hash_original_method = "0F6340ADF5245C54CBF49A235DDD47A4", hash_generated_method = "D1A09455E2647805342EFF34857AE908")
    
static int cmp(BigInt a, BigInt b) {
        return NativeBN.BN_cmp(a.bignum, b.bignum);
    }

    // Java supports non-ASCII decimal digits, but OpenSSL doesn't.
    // We need to translate the decimal digits but leave any other characters alone.
    // This method assumes it's being called on a string that has already been validated.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.506 -0500", hash_original_method = "DD65BCC470599E1A79A6070EA120A573", hash_generated_method = "E1591BBB0F521A39A8200C2C3BAEC871")
    
private static String toAscii(String s, int base) {
        int length = s.length();
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; ++i) {
            char ch = s.charAt(i);
            int value = Character.digit(ch, base);
            if (value >= 0 && value <= 9) {
                ch = (char) ('0' + value);
            }
            result.append(ch);
        }
        return result.toString();
    }

    // n > 0: shift left (multiply)
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.538 -0500", hash_original_method = "0AD1A78C21070B07B4A98ACE15E69C65", hash_generated_method = "5C2ECAF6E39C4BF9C41652483392D20D")
    
static BigInt shift(BigInt a, int n) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_shift(r.bignum, a.bignum, n));
        return r;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.547 -0500", hash_original_method = "99C410CBC822EAA6B5E4747B4306B77B", hash_generated_method = "03FB991B0698FEE05AE8F866B2332FBB")
    
static int remainderByPositiveInt(BigInt a, int w) {
        int rem = NativeBN.BN_mod_word(a.bignum, w);
        Check(rem != -1);
        return rem;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.549 -0500", hash_original_method = "2122DEE5125BEE800740F7ED81F7D5C1", hash_generated_method = "E9AF9F9945DED0ADFACD864BC6D92651")
    
static BigInt addition(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_add(r.bignum, a.bignum, b.bignum));
        return r;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.553 -0500", hash_original_method = "50AD0863DB2B7066BEE4813E08389A35", hash_generated_method = "0E55E785DB30C0EC79BBDF4204C9721E")
    
static BigInt subtraction(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_sub(r.bignum, a.bignum, b.bignum));
        return r;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.556 -0500", hash_original_method = "AE1A417A9F001E92DAC0DB8BB82136F8", hash_generated_method = "025AA1AA5C37F4D26517838AE17A885F")
    
static BigInt gcd(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_gcd(r.bignum, a.bignum, b.bignum));
        return r;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.559 -0500", hash_original_method = "11E54269A115B95D584D6C63AE8B0435", hash_generated_method = "9ED183264A9910C813DF476D436AF7CD")
    
static BigInt product(BigInt a, BigInt b) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_mul(r.bignum, a.bignum, b.bignum));
        return r;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.561 -0500", hash_original_method = "A81851418C7DFA739F6953B43B77180F", hash_generated_method = "BF4C7CDF29E6F2332EDC1DEB46D9ED15")
    
static BigInt bigExp(BigInt a, BigInt p) {
        // Sign of p is ignored!
        BigInt r = newBigInt();
        Check(NativeBN.BN_exp(r.bignum, a.bignum, p.bignum));
        return r;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.563 -0500", hash_original_method = "AA283AD3158CC12F9F70F80868A3EB88", hash_generated_method = "2DA24398B3516ACF58ACD163B3A6B4C8")
    
static BigInt exp(BigInt a, int p) {
        // Sign of p is ignored!
        BigInt power = new BigInt();
        power.putLongInt(p);
        return bigExp(a, power);
        // OPTIONAL:
        // int BN_sqr(BigInteger r, BigInteger a, BN_CTX ctx);
        // int BN_sqr(BIGNUM *r, const BIGNUM *a,BN_CTX *ctx);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.566 -0500", hash_original_method = "597741CD98A0499A52DFAC42AB7336B4", hash_generated_method = "B8C6320F3E410F172078C270FE7B2743")
    
static void division(BigInt dividend, BigInt divisor,
            BigInt quotient, BigInt remainder) {
        int quot, rem;
        if (quotient != null) {
            quotient.makeValid();
            quot = quotient.bignum;
        } else {
            quot = 0;
        }
        if (remainder != null) {
            remainder.makeValid();
            rem = remainder.bignum;
        } else {
            rem = 0;
        }
        Check(NativeBN.BN_div(quot, rem, dividend.bignum, divisor.bignum));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.568 -0500", hash_original_method = "BA0D96E6134396663A4C5F950127446B", hash_generated_method = "B8E036ABE29B8ABF368ED54D991E6374")
    
static BigInt modulus(BigInt a, BigInt m) {
        // Sign of p is ignored! ?
        BigInt r = newBigInt();
        Check(NativeBN.BN_nnmod(r.bignum, a.bignum, m.bignum));
        return r;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.571 -0500", hash_original_method = "F098B8E99014EAD669D30E342A049E44", hash_generated_method = "4E95226E95AD35A6A1488110E0FC7DFD")
    
static BigInt modExp(BigInt a, BigInt p, BigInt m) {
        // Sign of p is ignored!
        BigInt r = newBigInt();
        Check(NativeBN.BN_mod_exp(r.bignum, a.bignum, p.bignum, m.bignum));

        // OPTIONAL:
        // int BN_mod_sqr(BIGNUM *r, const BIGNUM *a, const BIGNUM *m, BN_CTX *ctx);
        return r;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.573 -0500", hash_original_method = "7B172DFB94DBDDE79ECEDD19F7E4326A", hash_generated_method = "5449CD2B19BDBA83104809E2DB563CB3")
    
static BigInt modInverse(BigInt a, BigInt m) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_mod_inverse(r.bignum, a.bignum, m.bignum));
        return r;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.575 -0500", hash_original_method = "D06807C9C7C05CDFACAD1E5643882856", hash_generated_method = "06A2B579B482C5351F5050BC6F120704")
    
static BigInt generatePrimeDefault(int bitLength) {
        BigInt r = newBigInt();
        Check(NativeBN.BN_generate_prime_ex(r.bignum, bitLength, false, 0, 0, 0));
        return r;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.464 -0500", hash_original_field = "75451BD190C0F78B0EFEA1F174EFFB73", hash_generated_field = "2E7F69903943700473696173A4E00017")

    transient int bignum = 0;
    
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:49.670 -0400", hash_original_method = "1310F12C90284BE28EAEC322C36620BE", hash_generated_method = "1310F12C90284BE28EAEC322C36620BE")
    public BigInt ()
    {
        //Synthesized constructor
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.467 -0500", hash_original_method = "BE6B93B7FDC95635F38722D58894F3B6", hash_generated_method = "A99084A230951F5154A5D35EFCC346C2")
    
@Override protected void finalize() throws Throwable {
        try {
            if (this.bignum != 0) {
                NativeBN.BN_free(this.bignum);
                this.bignum = 0;
            }
        } finally {
            super.finalize();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.470 -0500", hash_original_method = "AE4D2CED095C616381028CC9DA4809A2", hash_generated_method = "BAE86047FB8DEA778BCC9D0B2869F9E5")
    
@Override
    public String toString() {
        return this.decString();
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.472 -0500", hash_original_method = "5BE7FB396EC56810A84432A49B351D93", hash_generated_method = "5BE7FB396EC56810A84432A49B351D93")
    
int getNativeBIGNUM() {
        return this.bignum;
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.480 -0500", hash_original_method = "271E8D5D7DE583053F26E9ECE2A9ACB3", hash_generated_method = "83D210F878162A054F5D5207ECA3A607")
    
private void makeValid() {
        if (this.bignum == 0) {
            this.bignum = NativeBN.BN_new();
            Check(this.bignum != 0);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.487 -0500", hash_original_method = "8941EBA58E329563221FF533A53A6CC6", hash_generated_method = "8941EBA58E329563221FF533A53A6CC6")
    
void putCopy(BigInt from) {
        this.makeValid();
        Check(NativeBN.BN_copy(this.bignum, from.bignum));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.489 -0500", hash_original_method = "05F85FC1363853C2D04A531626254DA4", hash_generated_method = "05F85FC1363853C2D04A531626254DA4")
    
BigInt copy() {
        BigInt bi = new BigInt();
        bi.putCopy(this);
        return bi;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.492 -0500", hash_original_method = "30A332A63D32AA82B1909AFA5FBB53FE", hash_generated_method = "30A332A63D32AA82B1909AFA5FBB53FE")
    
void putLongInt(long val) {
        this.makeValid();
        Check(NativeBN.putLongInt(this.bignum, val));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.494 -0500", hash_original_method = "2D149BF96A898165FFEB2983CC63FA56", hash_generated_method = "2D149BF96A898165FFEB2983CC63FA56")
    
void putULongInt(long val, boolean neg) {
        this.makeValid();
        Check(NativeBN.putULongInt(this.bignum, val, neg));
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.497 -0500", hash_original_method = "9B61495EA965D6A6D5A899C3BAA9567B", hash_generated_method = "F0F0866AAD7A2DF8486A7696F43DDE21")
    
private NumberFormatException invalidBigInteger(String s) {
        throw new NumberFormatException("Invalid BigInteger: " + s);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.499 -0500", hash_original_method = "6076EA670724B5FC9E7D900E17BB8270", hash_generated_method = "6076EA670724B5FC9E7D900E17BB8270")
    
void putDecString(String original) {
        String s = checkString(original, 10);
        this.makeValid();
        int usedLen = NativeBN.BN_dec2bn(this.bignum, s);
        Check((usedLen > 0));
        if (usedLen < s.length()) {
            throw invalidBigInteger(original);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.501 -0500", hash_original_method = "77EC4D791D3A431E14DA888080E50FCA", hash_generated_method = "77EC4D791D3A431E14DA888080E50FCA")
    
void putHexString(String original) {
        String s = checkString(original, 16);
        this.makeValid();
        int usedLen = NativeBN.BN_hex2bn(this.bignum, s);
        Check((usedLen > 0));
        if (usedLen < s.length()) {
            throw invalidBigInteger(original);
        }
    }

    /**
     * Returns a string suitable for passing to OpenSSL.
     * Throws if 's' doesn't match Java's rules for valid BigInteger strings.
     * BN_dec2bn and BN_hex2bn do very little checking, so we need to manually
     * ensure we comply with Java's rules.
     * http://code.google.com/p/android/issues/detail?id=7036
     */
    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.504 -0500", hash_original_method = "509B8D432808DFEEDB9A2530ACB4E595", hash_generated_method = "C716B16F4C7B37D4606F4D39D268B8A6")
    
String checkString(String s, int base) {
        if (s == null) {
            throw new NullPointerException();
        }
        // A valid big integer consists of an optional '-' or '+' followed by
        // one or more digit characters appropriate to the given base,
        // and no other characters.
        int charCount = s.length();
        int i = 0;
        if (charCount > 0) {
            char ch = s.charAt(0);
            if (ch == '+') {
                // Java supports leading +, but OpenSSL doesn't, so we need to strip it.
                s = s.substring(1);
                --charCount;
            } else if (ch == '-') {
                ++i;
            }
        }
        if (charCount - i == 0) {
            throw invalidBigInteger(s);
        }
        boolean nonAscii = false;
        for (; i < charCount; ++i) {
            char ch = s.charAt(i);
            if (Character.digit(ch, base) == -1) {
                throw invalidBigInteger(s);
            }
            if (ch > 128) {
                nonAscii = true;
            }
        }
        return nonAscii ? toAscii(s, base) : s;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.508 -0500", hash_original_method = "ACDB63EFF9B325E839800C11A6F974A8", hash_generated_method = "ACDB63EFF9B325E839800C11A6F974A8")
    
void putBigEndian(byte[] a, boolean neg) {
        this.makeValid();
        Check(NativeBN.BN_bin2bn(a, a.length, neg, this.bignum));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.511 -0500", hash_original_method = "F46F553C794EFAECC5CBB83791E423EA", hash_generated_method = "F46F553C794EFAECC5CBB83791E423EA")
    
void putLittleEndianInts(int[] a, boolean neg) {
        this.makeValid();
        Check(NativeBN.litEndInts2bn(a, a.length, neg, this.bignum));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.513 -0500", hash_original_method = "78A05CDDAF5055249AF6E8FAF4BFB01A", hash_generated_method = "78A05CDDAF5055249AF6E8FAF4BFB01A")
    
void putBigEndianTwosComplement(byte[] a) {
        this.makeValid();
        Check(NativeBN.twosComp2bn(a, a.length, this.bignum));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.516 -0500", hash_original_method = "27EA3CFBEF77EFE881C6E2FB553F4CC2", hash_generated_method = "27EA3CFBEF77EFE881C6E2FB553F4CC2")
    
long longInt() {
        return NativeBN.longInt(this.bignum);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.518 -0500", hash_original_method = "91D15DC45533D4FB86FF476EA9D84EB9", hash_generated_method = "91D15DC45533D4FB86FF476EA9D84EB9")
    
String decString() {
        return NativeBN.BN_bn2dec(this.bignum);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.520 -0500", hash_original_method = "41C3EB22F67E33809F4134B2F2306A6C", hash_generated_method = "41C3EB22F67E33809F4134B2F2306A6C")
    
String hexString() {
        return NativeBN.BN_bn2hex(this.bignum);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.523 -0500", hash_original_method = "5BFAE0D787CB740802A929B95296D76B", hash_generated_method = "5BFAE0D787CB740802A929B95296D76B")
    
byte[] bigEndianMagnitude() {
        return NativeBN.BN_bn2bin(this.bignum);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.525 -0500", hash_original_method = "9306CD68F08E506A6F565B6B5DE53B97", hash_generated_method = "9306CD68F08E506A6F565B6B5DE53B97")
    
int[] littleEndianIntsMagnitude() {
        return NativeBN.bn2litEndInts(this.bignum);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.527 -0500", hash_original_method = "20C3F9921E8308474D657B401A5C4926", hash_generated_method = "20C3F9921E8308474D657B401A5C4926")
    
int sign() {
        return NativeBN.sign(this.bignum);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.529 -0500", hash_original_method = "D1EC3F455E1B2B87D60E54F4D60552ED", hash_generated_method = "D1EC3F455E1B2B87D60E54F4D60552ED")
    
void setSign(int val) {
        if (val > 0) {
            NativeBN.BN_set_negative(this.bignum, 0);
        } else {
            if (val < 0) NativeBN.BN_set_negative(this.bignum, 1);
        }
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.531 -0500", hash_original_method = "0C4139075DA080C92B767C8D6DDC4F59", hash_generated_method = "0C4139075DA080C92B767C8D6DDC4F59")
    
boolean twosCompFitsIntoBytes(int desiredByteCount) {
        int actualByteCount = (NativeBN.bitLength(this.bignum) + 7) / 8;
        return actualByteCount <= desiredByteCount;
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.533 -0500", hash_original_method = "06E4028740CFBC5E8F4DC5B6A30B93E1", hash_generated_method = "06E4028740CFBC5E8F4DC5B6A30B93E1")
    
int bitLength() {
        return NativeBN.bitLength(this.bignum);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.535 -0500", hash_original_method = "7AF9A4C10272398CEA0DB42D124E2F09", hash_generated_method = "7AF9A4C10272398CEA0DB42D124E2F09")
    
boolean isBitSet(int n) {
        return NativeBN.BN_is_bit_set(this.bignum, n);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.540 -0500", hash_original_method = "E387E2D423D242DA7510EDC2247E6A5C", hash_generated_method = "E387E2D423D242DA7510EDC2247E6A5C")
    
void shift(int n) {
        Check(NativeBN.BN_shift(this.bignum, this.bignum, n));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.543 -0500", hash_original_method = "3376DF594C58E0E875033FD1F81D1456", hash_generated_method = "3376DF594C58E0E875033FD1F81D1456")
    
void addPositiveInt(int w) {
        Check(NativeBN.BN_add_word(this.bignum, w));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.545 -0500", hash_original_method = "5EBBBBFBA0490D7B09CF7B986217857B", hash_generated_method = "5EBBBBFBA0490D7B09CF7B986217857B")
    
void multiplyByPositiveInt(int w) {
        Check(NativeBN.BN_mul_word(this.bignum, w));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.551 -0500", hash_original_method = "0051E42AE39953CC88EC24F561CB2DC4", hash_generated_method = "0051E42AE39953CC88EC24F561CB2DC4")
    
void add(BigInt a) {
        Check(NativeBN.BN_add(this.bignum, this.bignum, a.bignum));
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:38.578 -0500", hash_original_method = "E070D8C138AEEC2CD37718FB0D1B5E61", hash_generated_method = "E070D8C138AEEC2CD37718FB0D1B5E61")
    
boolean isPrime(int certainty) {
        return NativeBN.BN_is_prime_ex(bignum, certainty, 0);
    }
    
}

