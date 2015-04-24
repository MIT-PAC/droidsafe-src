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


package libcore.icu;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.DecimalFormatSymbols;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.Currency;
import java.util.NoSuchElementException;

import droidsafe.helpers.DSUtils;

public final class NativeDecimalFormat {

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.152 -0500", hash_original_method = "B8DBC7D049D3B4F244E4AF6EDA028CBA", hash_generated_method = "BFE675F82DDB4D186B8A5179A21EF157")
    
private static void applyPattern(int addr, boolean localized, String pattern) {
        try {
            applyPatternImpl(addr, localized, pattern);
        } catch (NullPointerException npe) {
            throw npe;
        } catch (RuntimeException re) {
            throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
        }
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void applyPatternImpl(int addr, boolean localized, String pattern) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int cloneImpl(int addr) {
        return addr;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void close(int addr) {
    }
    
    private static char[] formatLong(int addr, long value, FieldPositionIterator iter) {
        char[] chars = new char[10];
        chars.addTaint(addr);
        chars.addTaint(value);
        chars.addTaint(iter.getTaint());
        return chars;
    }
    
    private static char[] formatDouble(int addr, double value, FieldPositionIterator iter) {
        char[] chars = new char[10];
        chars.addTaint(addr);
        chars.addTaint(value);
        chars.addTaint(iter.getTaint());
        return chars;

    }
    
    private static char[] formatDigitList(int addr, String value, FieldPositionIterator iter) {
        char[] chars = new char[10];
        chars.addTaint(addr);
        chars.addTaint(value.getTaint());
        chars.addTaint(iter.getTaint());
        return chars;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int getAttribute(int addr, int symbol) {
        return (addr + symbol);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String getTextAttribute(int addr, int symbol) {
    	String s = new String();
    	s.addTaint(symbol);
    	return s;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static int open(String pattern, String currencySymbol,
            char decimalSeparator, char digit, String exponentSeparator, char groupingSeparator,
            String infinity, String internationalCurrencySymbol, char minusSign,
            char monetaryDecimalSeparator, String nan, char patternSeparator, char percent,
            char perMill, char zeroDigit) {
        return (pattern.getTaintInt() + currencySymbol.getTaintInt() + 
                decimalSeparator + digit + exponentSeparator.getTaintInt() +
                groupingSeparator + infinity.getTaintInt() + internationalCurrencySymbol.getTaintInt() +
                minusSign + monetaryDecimalSeparator + nan.getTaintInt() + patternSeparator +
                percent + perMill + zeroDigit);
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static Number parse(int addr, String string, ParsePosition position, boolean parseBigDecimal) {
    	Number ret;
    	if (parseBigDecimal) {
    		ret = new BigDecimal(1.0);
    		ret.addTaint(parseBigDecimal);
    		ret.addTaint(addr);
    		ret.addTaint(position.getTaint());
    		ret.addTaint(string.getTaint());
    	} else {
    		ret = new BigInteger("");
    		ret.addTaint(parseBigDecimal);
    		ret.addTaint(addr);
    		ret.addTaint(position.getTaint());
    		ret.addTaint(string.getTaint());
    	}
    	return ret;
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void setDecimalFormatSymbols(int addr, String currencySymbol,
            char decimalSeparator, char digit, String exponentSeparator, char groupingSeparator,
            String infinity, String internationalCurrencySymbol, char minusSign,
            char monetaryDecimalSeparator, String nan, char patternSeparator, char percent,
            char perMill, char zeroDigit) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void setSymbol(int addr, int symbol, String str) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void setAttribute(int addr, int symbol, int i) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void setRoundingMode(int addr, int roundingMode, double roundingIncrement) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static void setTextAttribute(int addr, int symbol, String str) {
    }
    
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    private static String toPatternImpl(int addr, boolean localized) {
    	String s = new String();
    	s.addTaint(localized);
    	return s;
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.893 -0500", hash_original_field = "9CB2842578EDD3FB5DA7444C77B879D7", hash_generated_field = "38F9165B0D1718351C70E64071CF49B4")

    private static final int UNUM_DECIMAL_SEPARATOR_SYMBOL = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.896 -0500", hash_original_field = "962E9C4AA174BE8AE4409402C456ED76", hash_generated_field = "A28375963190DB6399778744725103E6")

    private static final int UNUM_GROUPING_SEPARATOR_SYMBOL = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.898 -0500", hash_original_field = "9469705126C7B7D8B53290DE0C3370F8", hash_generated_field = "0ECCE7421BEB7BB4F15F8631211E592E")

    private static final int UNUM_PATTERN_SEPARATOR_SYMBOL = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.901 -0500", hash_original_field = "DC447404F38B9E2CC9772C5D8B7C5A42", hash_generated_field = "83D35D18C1BB99CFDB91DD1A86FC9678")

    private static final int UNUM_PERCENT_SYMBOL = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.903 -0500", hash_original_field = "E2E399F85493C08FEA606574E36962F8", hash_generated_field = "A137593AB67428AD25B40E8D7662626C")

    private static final int UNUM_ZERO_DIGIT_SYMBOL = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.906 -0500", hash_original_field = "83355554F4A9EC130402831D399C4BF9", hash_generated_field = "0BF7C44A4D4E7A6FCFBDC966AC9A3476")

    private static final int UNUM_DIGIT_SYMBOL = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.908 -0500", hash_original_field = "EB937E9C0E69430ED4221B82EF188807", hash_generated_field = "17518293119C4123ADB20C78B6AFF1D9")

    private static final int UNUM_MINUS_SIGN_SYMBOL = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.911 -0500", hash_original_field = "CC689B765B05E48015C0132B610BB79F", hash_generated_field = "1DCA6AC28B3EA63C4A4D4065F3445F3E")

    private static final int UNUM_PLUS_SIGN_SYMBOL = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.913 -0500", hash_original_field = "1BA5991B9021D32C59E5ED67FBA161AA", hash_generated_field = "13D25F549CCD80A7958357D90F76BF36")

    private static final int UNUM_CURRENCY_SYMBOL = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.916 -0500", hash_original_field = "7844E5512D59E071E9DBD997018E557B", hash_generated_field = "871E41AB05FA295AFDB080EA0ED3BFC5")

    private static final int UNUM_INTL_CURRENCY_SYMBOL = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.919 -0500", hash_original_field = "45330068B3BCB4F5DD40D7032916E059", hash_generated_field = "EEE69206D44FBEDEC2F848E246637D7D")

    private static final int UNUM_MONETARY_SEPARATOR_SYMBOL = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.922 -0500", hash_original_field = "0623CD48F73AADCAD2C480E71077D195", hash_generated_field = "5DD2C0F9414476738084073736C6DD24")

    private static final int UNUM_EXPONENTIAL_SYMBOL = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.924 -0500", hash_original_field = "FB55EBB2D81C551820638E76E94179D1", hash_generated_field = "E328F5A776A1D9EA915373443B4D1D36")

    private static final int UNUM_PERMILL_SYMBOL = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.927 -0500", hash_original_field = "391122BA3F21FFA4E710F5753771324E", hash_generated_field = "FDD5FB07C1A11F2186831D8D8D4B07C5")

    private static final int UNUM_PAD_ESCAPE_SYMBOL = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.929 -0500", hash_original_field = "0EB83ED3ECF900F687AB0D7D0FFB2A5C", hash_generated_field = "00A8062220A299E144D758B6640F827D")

    private static final int UNUM_INFINITY_SYMBOL = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.932 -0500", hash_original_field = "A2C68422A845B3BA304F8002A88890BA", hash_generated_field = "FF98C79010DA951498FB4C5A5099EC0F")

    private static final int UNUM_NAN_SYMBOL = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.934 -0500", hash_original_field = "E8198724C578047E1CB5F8BF7225300E", hash_generated_field = "C24949E7E71025158E3BECC52FE6AEE8")

    private static final int UNUM_SIGNIFICANT_DIGIT_SYMBOL = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.937 -0500", hash_original_field = "CA0B169D06F2937FF5DF091B1539C221", hash_generated_field = "217B639C06D518F013EA3AFBC1159BEA")

    private static final int UNUM_MONETARY_GROUPING_SEPARATOR_SYMBOL = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.940 -0500", hash_original_field = "BC045DB6D8F430B26D16457F1592CCB2", hash_generated_field = "445837AD1924D5714BE388A67163A553")

    private static final int UNUM_FORMAT_SYMBOL_COUNT = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.942 -0500", hash_original_field = "5B82B746D91C1C497BA72E9B0E986E10", hash_generated_field = "8BADA870B3144CAE14BC1B1303AFD2E0")

    private static final int UNUM_PARSE_INT_ONLY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.945 -0500", hash_original_field = "9C717655CF486B6A51AEC3D9AA344881", hash_generated_field = "7D1C329BEE2B035F9F233564C570028F")

    private static final int UNUM_GROUPING_USED = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.947 -0500", hash_original_field = "78B277F2B44571E61DAAD8FD21591CBC", hash_generated_field = "7A36CC1B192B3B1AADAF3A7C042D87DC")

    private static final int UNUM_DECIMAL_ALWAYS_SHOWN = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.950 -0500", hash_original_field = "10AB9E3938819FCE7A6F054B61233513", hash_generated_field = "619A906F0DBD204A3D5EF39E61783952")

    private static final int UNUM_MAX_INTEGER_DIGITS = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.952 -0500", hash_original_field = "8B56CD884D682820A672EEF09817A720", hash_generated_field = "AD2EFDD3044D52B7569692F528421BFA")

    private static final int UNUM_MIN_INTEGER_DIGITS = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.955 -0500", hash_original_field = "624A54E4F5FB6D6E67BC4323E47352FA", hash_generated_field = "D3D4DF73C2432699E2CED910F4AC2552")

    private static final int UNUM_INTEGER_DIGITS = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.957 -0500", hash_original_field = "36726788607EACEBE555B5E41148AD6B", hash_generated_field = "F0171186645CD6B003F45EE6BD32357E")

    private static final int UNUM_MAX_FRACTION_DIGITS = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.960 -0500", hash_original_field = "EEF422E3507AD42E9800090D23E85587", hash_generated_field = "C0FAFB0D9C2B9DDEC85E66C9595CE14D")

    private static final int UNUM_MIN_FRACTION_DIGITS = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.963 -0500", hash_original_field = "E698FD25E4CC994E46500564EAF5B739", hash_generated_field = "77B731D6D431A67B9FBD265D21C6B4E3")

    private static final int UNUM_FRACTION_DIGITS = 8;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.965 -0500", hash_original_field = "DB6BAAE4823CDF6963FF7311CD133206", hash_generated_field = "D7D1DB6D490350ED0F56C66BA87D59DB")

    private static final int UNUM_MULTIPLIER = 9;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.968 -0500", hash_original_field = "5FAB7B5B524FF601EF66C3160AFBD4C6", hash_generated_field = "05CB2CE6529FD0E1150F6A0CE43ECDDA")

    private static final int UNUM_GROUPING_SIZE = 10;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.970 -0500", hash_original_field = "DE8B5FB1CC7CF51BA4F71EAF2021859D", hash_generated_field = "AE8E7BB146CFC987266EF6FCBEEA9CFA")

    private static final int UNUM_ROUNDING_MODE = 11;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.973 -0500", hash_original_field = "DB64FA06EC2C0E378664F967B308FF33", hash_generated_field = "D211C7D2DA9A6A02C05730209957713D")

    private static final int UNUM_ROUNDING_INCREMENT = 12;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.975 -0500", hash_original_field = "FAA4A2496D3474720E28CBF1CB434F1C", hash_generated_field = "1BEE2F7A86DF9CC0CF422419F6C7E6AC")

    private static final int UNUM_FORMAT_WIDTH = 13;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.978 -0500", hash_original_field = "1D93BB8E70E72C0E50D2EE875ADBFD82", hash_generated_field = "1137CDEF8C77585315595AE0160B7096")

    private static final int UNUM_PADDING_POSITION = 14;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.981 -0500", hash_original_field = "A046793284EADB53BBA14627A9C4ACDA", hash_generated_field = "06F7E6232D5F36D4B36C8F433D1A4815")

    private static final int UNUM_SECONDARY_GROUPING_SIZE = 15;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.983 -0500", hash_original_field = "C15BA1F4EBB74C0528088BBD5D8E9428", hash_generated_field = "B6C735B849850BC33558BDF5305AFBDF")

    private static final int UNUM_SIGNIFICANT_DIGITS_USED = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.986 -0500", hash_original_field = "EAF1FD9B73EF3F3DCDA01DF89C515AEA", hash_generated_field = "6A53E30035D626AEBE7319CC56976B5E")

    private static final int UNUM_MIN_SIGNIFICANT_DIGITS = 17;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.989 -0500", hash_original_field = "9761070A32C1DA9D915B17A1199721F2", hash_generated_field = "60312495E62249A683DE9D887813078C")

    private static final int UNUM_MAX_SIGNIFICANT_DIGITS = 18;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.992 -0500", hash_original_field = "B717CBB0B9C66B6026DF7F1408144CA3", hash_generated_field = "17FDB153D06831EFA445923876F0F9CD")

    private static final int UNUM_LENIENT_PARSE = 19;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.995 -0500", hash_original_field = "9344614151AD299E955706FB4D2441EE", hash_generated_field = "CB0BDBA3DAAC06D26A2A81C71F65DE46")

    private static final int UNUM_POSITIVE_PREFIX = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:06.997 -0500", hash_original_field = "28D7518027A66C5483C4D26808727DE0", hash_generated_field = "BA1D392F17BF7442D6C4A8ED2218F953")

    private static final int UNUM_POSITIVE_SUFFIX = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.000 -0500", hash_original_field = "2160EF08E720288DF8B7E06499A937E9", hash_generated_field = "3B7B2C3FEE6B7373D124C61F621AAECB")

    private static final int UNUM_NEGATIVE_PREFIX = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.002 -0500", hash_original_field = "211B618F1359D4A59DC3A12F53257525", hash_generated_field = "7ADB5843D6F5347E296883E0AD4E2AC6")

    private static final int UNUM_NEGATIVE_SUFFIX = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.005 -0500", hash_original_field = "051EA2767AA965C02316952C831347AD", hash_generated_field = "EA8C72D1176DA844AB8FAB8C5B840969")

    private static final int UNUM_PADDING_CHARACTER = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.007 -0500", hash_original_field = "B4B6B5BC91C26CA0F7364E783586CD37", hash_generated_field = "F54C128E1E1EA1DBED16FA7AC15596DC")

    private static final int UNUM_CURRENCY_CODE = 5;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.010 -0500", hash_original_field = "8A63C2591C5D6C783566E161773FEB03", hash_generated_field = "C71921E41D4DB8B96035181BECB3F4C9")

    private static final int UNUM_DEFAULT_RULESET = 6;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.012 -0500", hash_original_field = "47279E3645B2C6275A946CA88F4255CB", hash_generated_field = "0401D7F0EFF53BBDD616982052AEAE8F")

    private static final int UNUM_PUBLIC_RULESETS = 7;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.015 -0500", hash_original_field = "0EFD4B56D5F68F850B84173C34758709", hash_generated_field = "849BAB492558B51E7BC4F1C331A435E4")

    private int address;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.017 -0500", hash_original_field = "B6683792C2F051EBE6B423DF4DD890DA", hash_generated_field = "5F7D5D3D7F66CE031779F4BACE74C549")

    private String lastPattern;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.019 -0500", hash_original_field = "0C32A202AEA13081C0A6BC96179C1F22", hash_generated_field = "A56A7DCB118482C05DDF4AEBE99FDB15")

    private boolean negPrefNull;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.021 -0500", hash_original_field = "CBB9DC734CA95520AD84DE6ACC37608A", hash_generated_field = "2505E1D75E0C167EE76E4EF5DDA36BE9")

    private boolean negSuffNull;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.024 -0500", hash_original_field = "666E1C60B4EA7EB652B2E13B9DC7ED9C", hash_generated_field = "CDAAA116F4BD28B5162A921B2B1BA25F")

    private boolean posPrefNull;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.027 -0500", hash_original_field = "B03B1CEC4E9A4722BAC92B915FCA39D2", hash_generated_field = "E9F9066E16BD9AB176D3C016B62231F0")

    private boolean posSuffNull;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.029 -0500", hash_original_field = "99ACF7EB6D845EB724490D8054444ABA", hash_generated_field = "622CB2D56C22AE9A04568955FFFF4B33")

    private transient boolean parseBigDecimal;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.031 -0500", hash_original_field = "E0D58B61CF4284776E7655FB1B0BA417", hash_generated_field = "C24355A01F90DF3021CC166940F4BB14")

    private BigDecimal multiplierBigDecimal = null;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.034 -0500", hash_original_method = "D8AEBC26DB4CF2E0C933D0F5B84F659E", hash_generated_method = "F7886A5218F16F5930EC8123F13A1719")
    
public NativeDecimalFormat(String pattern, DecimalFormatSymbols dfs) {
        try {
            this.address = open(pattern, dfs.getCurrencySymbol(),
                    dfs.getDecimalSeparator(), dfs.getDigit(), dfs.getExponentSeparator(),
                    dfs.getGroupingSeparator(), dfs.getInfinity(),
                    dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                    dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                    dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
            this.lastPattern = pattern;
        } catch (NullPointerException npe) {
            throw npe;
        } catch (RuntimeException re) {
            throw new IllegalArgumentException("syntax error: " + re.getMessage() + ": " + pattern);
        }
    }

    // Used so java.util.Formatter doesn't need to allocate DecimalFormatSymbols instances.
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.037 -0500", hash_original_method = "03415942CECEA3C928FA024ACF038523", hash_generated_method = "116DF46E87A53C7D4BFDBC120787B411")
    
public NativeDecimalFormat(String pattern, LocaleData data) {
        this.address = open(pattern, data.currencySymbol,
                data.decimalSeparator, '#', data.exponentSeparator, data.groupingSeparator,
                data.infinity, data.internationalCurrencySymbol, data.minusSign,
                data.monetarySeparator, data.NaN, data.patternSeparator,
                data.percent, data.perMill, data.zeroDigit);
        this.lastPattern = pattern;
    }

    // Used to implement clone.
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.040 -0500", hash_original_method = "F2FB63D256AD622AD0AA1906E5944DB2", hash_generated_method = "735F77143D45E347FF4196C5A2A8A0BB")
    
private NativeDecimalFormat(NativeDecimalFormat other) {
        this.address = cloneImpl(other.address);
        this.lastPattern = other.lastPattern;
        this.negPrefNull = other.negPrefNull;
        this.negSuffNull = other.negSuffNull;
        this.posPrefNull = other.posPrefNull;
        this.posSuffNull = other.posSuffNull;
    }
    
    private static class FieldPositionIterator {

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.166 -0500", hash_original_method = "384C091DF106F888683239832F6FD964", hash_generated_method = "6E57EE53987910BAFF7C36723A8DA958")
        
public static FieldPositionIterator forFieldPosition(FieldPosition fp) {
            if (fp != null && fp.getField() != -1) {
                return new FieldPositionIterator();
            }
            return null;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.169 -0500", hash_original_method = "FD8765DDE780B1145300BBF4C2302309", hash_generated_method = "A3876A91F7329AEC3A874017AC874AA9")
        
private static int getNativeFieldPositionId(FieldPosition fp) {
            // NOTE: -1, 0, and 1 were the only valid original java field values
            // for NumberFormat.  They take precedence.  This assumes any other
            // value is a mistake and the actual value is in the attribute.
            // Clients can construct FieldPosition combining any attribute with any field
            // value, which is just wrong, but there you go.

            int id = fp.getField();
            if (id < -1 || id > 1) {
                id = -1;
            }
            if (id == -1) {
                Format.Field attr = fp.getFieldAttribute();
                if (attr != null) {
                    for (int i = 0; i < fields.length; ++i) {
                        if (fields[i].equals(attr)) {
                            id = i;
                            break;
                        }
                    }
                }
            }
            return id;
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.172 -0500", hash_original_method = "13170E88DCF158569D1B5B022C52EFDB", hash_generated_method = "F504E1C940AD6AE890288E0944365B7A")
        
private static void setFieldPosition(FieldPositionIterator fpi, FieldPosition fp) {
            if (fpi != null && fp != null) {
                int field = getNativeFieldPositionId(fp);
                if (field != -1) {
                    while (fpi.next()) {
                        if (fpi.fieldId() == field) {
                            fp.setBeginIndex(fpi.start());
                            fp.setEndIndex(fpi.limit());
                            break;
                        }
                    }
                }
            }
        }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.189 -0500", hash_original_field = "0663C0A318A54D2F7BD30BD3419B9957", hash_generated_field = "0F6C76C1706BCC332B6920605F5320B1")

        private static Format.Field fields[] = {
            // The old java field values were 0 for integer and 1 for fraction.
            // The new java field attributes are all objects.  ICU assigns the values
            // starting from 0 in the following order; note that integer and
            // fraction positions match the old field values.
            NumberFormat.Field.INTEGER,
            NumberFormat.Field.FRACTION,
            NumberFormat.Field.DECIMAL_SEPARATOR,
            NumberFormat.Field.EXPONENT_SYMBOL,
            NumberFormat.Field.EXPONENT_SIGN,
            NumberFormat.Field.EXPONENT,
            NumberFormat.Field.GROUPING_SEPARATOR,
            NumberFormat.Field.CURRENCY,
            NumberFormat.Field.PERCENT,
            NumberFormat.Field.PERMILLE,
            NumberFormat.Field.SIGN,
        };
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.157 -0500", hash_original_field = "C2FD81789164853775E4A0ECE59CD3D2", hash_generated_field = "2F322A4CCA87DBF62C5291F2FA6D1538")

        private int[] data;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.160 -0500", hash_original_field = "F2F9E431FFE55442A73D334D2E83F34C", hash_generated_field = "C812BD0A950A53E451CF78B187BCF580")

        private int pos = -3; // so first call to next() leaves pos at 0

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.163 -0500", hash_original_method = "3872533C5F4C6DF8E9B47456E87ABB09", hash_generated_method = "395118F450ACB18CEA23FBED606507A8")
        
private FieldPositionIterator() {
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.175 -0500", hash_original_method = "F9CA7CA9C759396A69CAFCECCE3A38CE", hash_generated_method = "E1EE2E811B0471448D54903E34D1EA99")
        
public boolean next() {
            // if pos == data.length, we've already returned false once
            if (data == null || pos == data.length) {
                throw new NoSuchElementException();
            }
            pos += 3;
            return pos < data.length;
        }

        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.177 -0500", hash_original_method = "28A52A04516ACAEA5CBE057E7005DC29", hash_generated_method = "0CC9F874E8C0D5A53F7FE184744A2F39")
        
private void checkValid() {
            if (data == null || pos < 0 || pos == data.length) {
                throw new NoSuchElementException();
            }
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.179 -0500", hash_original_method = "F481D50CCC1AB38B4CA6D00583ECCD74", hash_generated_method = "EDC3F73B43B3187E2374D41B8782CB4A")
        
public int fieldId() {
            return data[pos];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.182 -0500", hash_original_method = "B152D64258DA85AB1020B78F45482139", hash_generated_method = "F33EDE613E9347D1BC3D054AE1FF8B5E")
        
public Format.Field field() {
            checkValid();
            return fields[data[pos]];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.184 -0500", hash_original_method = "573D89586F74B4B2EDB6530AAE1DEC79", hash_generated_method = "B9EEBD16593C4289FDF12284F8892DAB")
        
public int start() {
            checkValid();
            return data[pos + 1];
        }

        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.186 -0500", hash_original_method = "431D149304BC1F14DB944F0790F3E8B8", hash_generated_method = "B4EC6DBB152B183F30D2F0FDE9C7F19D")
        
public int limit() {
            checkValid();
            return data[pos + 2];
        }

        // called by native
        @DSComment("Private Method")
        @DSBan(DSCat.PRIVATE_METHOD)
        @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.192 -0500", hash_original_method = "E1A3B20A4A62E5F6661DF7F73A635F7C", hash_generated_method = "D561088973FEA1999548879FCC5D3A31")
        
private void setData(int[] data) {
            this.data = data;
            this.pos = -3;
        }
    }

    // TODO: remove this and just have DecimalFormat.hashCode do the right thing itself.
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.042 -0500", hash_original_method = "C197288C8DD3954567266901B60BE5B8", hash_generated_method = "295C67594166BCBC697EFE7B957B662D")
    
@Override
    public int hashCode() {
        return this.getPositivePrefix().hashCode();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.045 -0500", hash_original_method = "5C171A463B7BB08FCE40648C7CE8F861", hash_generated_method = "8849BDB79BAE9DE7F140ACB3CEF55725")
    
public synchronized void close() {
        if (address != 0) {
            close(address);
            address = 0;
        }
    }

    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.047 -0500", hash_original_method = "D252F6FD4E111780C248C256B2516FF2", hash_generated_method = "D66716E4E733F1F25FC9977DE671987D")
    
@Override
    public Object clone() {
        return new NativeDecimalFormat(this);
    }

    /**
     * Note: this doesn't check that the underlying native DecimalFormat objects' configured
     * native DecimalFormatSymbols objects are equal. It is assumed that the
     * caller (DecimalFormat) will check the DecimalFormatSymbols objects
     * instead, for performance.
     *
     * This is also unreasonably expensive, calling down to JNI multiple times.
     *
     * TODO: remove this and just have DecimalFormat.equals do the right thing itself.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.050 -0500", hash_original_method = "220130DBC584D5B5D45771D972950D18", hash_generated_method = "9A5787370DD2B664E63383C7AA2A5BCE")
    
@Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof NativeDecimalFormat)) {
            return false;
        }
        NativeDecimalFormat obj = (NativeDecimalFormat) object;
        if (obj.address == this.address) {
            return true;
        }
        return obj.toPattern().equals(this.toPattern()) &&
                obj.isDecimalSeparatorAlwaysShown() == this.isDecimalSeparatorAlwaysShown() &&
                obj.getGroupingSize() == this.getGroupingSize() &&
                obj.getMultiplier() == this.getMultiplier() &&
                obj.getNegativePrefix().equals(this.getNegativePrefix()) &&
                obj.getNegativeSuffix().equals(this.getNegativeSuffix()) &&
                obj.getPositivePrefix().equals(this.getPositivePrefix()) &&
                obj.getPositiveSuffix().equals(this.getPositiveSuffix()) &&
                obj.getMaximumIntegerDigits() == this.getMaximumIntegerDigits() &&
                obj.getMaximumFractionDigits() == this.getMaximumFractionDigits() &&
                obj.getMinimumIntegerDigits() == this.getMinimumIntegerDigits() &&
                obj.getMinimumFractionDigits() == this.getMinimumFractionDigits() &&
                obj.isGroupingUsed() == this.isGroupingUsed();
    }

    /**
     * Copies the DecimalFormatSymbols settings into our native peer in bulk.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.053 -0500", hash_original_method = "6B8DF144F51335DB9B33B1BD0598F087", hash_generated_method = "1DF8E1638E3A0618589C0A2E51F2E7B8")
    
public void setDecimalFormatSymbols(final DecimalFormatSymbols dfs) {
        setDecimalFormatSymbols(this.address, dfs.getCurrencySymbol(), dfs.getDecimalSeparator(),
                dfs.getDigit(), dfs.getExponentSeparator(), dfs.getGroupingSeparator(),
                dfs.getInfinity(), dfs.getInternationalCurrencySymbol(), dfs.getMinusSign(),
                dfs.getMonetaryDecimalSeparator(), dfs.getNaN(), dfs.getPatternSeparator(),
                dfs.getPercent(), dfs.getPerMill(), dfs.getZeroDigit());
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.056 -0500", hash_original_method = "5FE0177EB5130C508ECEC468A64D96E3", hash_generated_method = "7AA33466FEDC1D77F4DDBD2D7E729662")
    
public void setDecimalFormatSymbols(final LocaleData localeData) {
        setDecimalFormatSymbols(this.address, localeData.currencySymbol, localeData.decimalSeparator,
                '#', localeData.exponentSeparator, localeData.groupingSeparator,
                localeData.infinity, localeData.internationalCurrencySymbol, localeData.minusSign,
                localeData.monetarySeparator, localeData.NaN, localeData.patternSeparator,
                localeData.percent, localeData.perMill, localeData.zeroDigit);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.058 -0500", hash_original_method = "E3DC36059DBEEA918EB4DAC2E3F69056", hash_generated_method = "20CFAAD50EC056F38489D52F6EA43457")
    
public char[] formatBigDecimal(BigDecimal value, FieldPosition field) {
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatDigitList(this.address, value.toString(), fpi);
        if (fpi != null) {
            FieldPositionIterator.setFieldPosition(fpi, field);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.060 -0500", hash_original_method = "AB58B0DEED1650663505F868BCDB9A76", hash_generated_method = "BCFA17AFFF413869D7509D428EA12DBF")
    
public char[] formatBigInteger(BigInteger value, FieldPosition field) {
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatDigitList(this.address, value.toString(10), fpi);
        if (fpi != null) {
            FieldPositionIterator.setFieldPosition(fpi, field);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.062 -0500", hash_original_method = "E280C21CEDC9C41E32AB3781E6354849", hash_generated_method = "E33F8937E3ABF10847B598FCD4541CA7")
    
public char[] formatLong(long value, FieldPosition field) {
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatLong(this.address, value, fpi);
        if (fpi != null) {
            FieldPositionIterator.setFieldPosition(fpi, field);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.065 -0500", hash_original_method = "2B822D9FBF334F04026E765F63D8EA7D", hash_generated_method = "A66B7A9F85D6C7E5C492E2ED234CDA8B")
    
public char[] formatDouble(double value, FieldPosition field) {
        FieldPositionIterator fpi = FieldPositionIterator.forFieldPosition(field);
        char[] result = formatDouble(this.address, value, fpi);
        if (fpi != null) {
            FieldPositionIterator.setFieldPosition(fpi, field);
        }
        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.068 -0500", hash_original_method = "521D68694A0F2FF9FD004D1F044248B6", hash_generated_method = "37C14E77CF324B92505AF903F3A8B55D")
    
public void applyLocalizedPattern(String pattern) {
        applyPattern(this.address, true, pattern);
        lastPattern = null;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.070 -0500", hash_original_method = "105E6A8350C3ECD2CBDC93E6E74AA17C", hash_generated_method = "29A5E38A74B1EBDB80B1196490AA0978")
    
public void applyPattern(String pattern) {
        if (lastPattern != null && pattern.equals(lastPattern)) {
            return;
        }
        applyPattern(this.address, false, pattern);
        lastPattern = pattern;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.073 -0500", hash_original_method = "9FEF3AE5E61C347D525A9585FBE19ECF", hash_generated_method = "DB1D1ADE29D0BE866247046B35FB4E97")
    
public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        if (!(object instanceof Number)) {
            throw new IllegalArgumentException();
        }
        Number number = (Number) object;
        FieldPositionIterator fpIter = new FieldPositionIterator();
        String text;
        if (number instanceof BigInteger || number instanceof BigDecimal) {
            text = new String(formatDigitList(this.address, number.toString(), fpIter));
        } else if (number instanceof Double || number instanceof Float) {
            double dv = number.doubleValue();
            text = new String(formatDouble(this.address, dv, fpIter));
        } else {
            long lv = number.longValue();
            text = new String(formatLong(this.address, lv, fpIter));
        }

        AttributedString as = new AttributedString(text);

        while (fpIter.next()) {
            Format.Field field = fpIter.field();
            as.addAttribute(field, field, fpIter.start(), fpIter.limit());
        }

        // return the CharacterIterator from AttributedString
        return as.getIterator();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.075 -0500", hash_original_method = "E9B105AB178BFBFEB280AF82F381CE84", hash_generated_method = "BA89376827AA93357D46FEF42969A48F")
    
private int makeScalePositive(int scale, StringBuilder val) {
        if (scale < 0) {
            scale = -scale;
            for (int i = scale; i > 0; i--) {
                val.append('0');
            }
            scale = 0;
        }
        return scale;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.077 -0500", hash_original_method = "1F42A3AAFB142AE620B1A14F6DE6CCC5", hash_generated_method = "66A1BAF4B33AFC5C4D72DF84F3BD71FE")
    
public String toLocalizedPattern() {
        return toPatternImpl(this.address, true);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.080 -0500", hash_original_method = "D90F2C106608034D601A7F076DF301BD", hash_generated_method = "2D481423320839AD83890346080658D9")
    
public String toPattern() {
        return toPatternImpl(this.address, false);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.083 -0500", hash_original_method = "C24C75386265F50BCF75B046D9BE3ACC", hash_generated_method = "C7EBB4AC0B12F113B52B39E6BCEC8A66")
    
public Number parse(String string, ParsePosition position) {
        return parse(address, string, position, parseBigDecimal);
    }

    // start getter and setter

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.085 -0500", hash_original_method = "00B4402833BBD0AA4B8B3DAC69045BF5", hash_generated_method = "B2662FB8B99A8C5B38B89D73473B0BA5")
    
public int getMaximumFractionDigits() {
        return getAttribute(this.address, UNUM_MAX_FRACTION_DIGITS);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.087 -0500", hash_original_method = "39458F699020062C4A2A7E5A13FEC803", hash_generated_method = "22B96A153816792B7A99EBF121EE662C")
    
public int getMaximumIntegerDigits() {
        return getAttribute(this.address, UNUM_MAX_INTEGER_DIGITS);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.090 -0500", hash_original_method = "2493C2169723FB0932E2841ED5413767", hash_generated_method = "13310C94F2DFBF68121807003654C58E")
    
public int getMinimumFractionDigits() {
        return getAttribute(this.address, UNUM_MIN_FRACTION_DIGITS);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.092 -0500", hash_original_method = "C287E89D9CA249987BAB41DA58A603BE", hash_generated_method = "B233C2DB383B5818E549A7A18C9E5900")
    
public int getMinimumIntegerDigits() {
        return getAttribute(this.address, UNUM_MIN_INTEGER_DIGITS);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.094 -0500", hash_original_method = "C63E831A66DAEA25345E39BD0E8C902A", hash_generated_method = "30646B17E7411D8BCFEF92520FDEA587")
    
public int getGroupingSize() {
        return getAttribute(this.address, UNUM_GROUPING_SIZE);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.096 -0500", hash_original_method = "195B15A30ECFDD2DA316EFD7F1135C74", hash_generated_method = "DAE7BEB0745C821EA6FAA80FAA1010E4")
    
public int getMultiplier() {
        return getAttribute(this.address, UNUM_MULTIPLIER);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.099 -0500", hash_original_method = "6BE8F2BF8B3A5604EA6D6E250F279823", hash_generated_method = "C21FA945572C99B3FB2BD4406C13049B")
    
public String getNegativePrefix() {
        if (negPrefNull) {
            return null;
        }
        return getTextAttribute(this.address, UNUM_NEGATIVE_PREFIX);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.101 -0500", hash_original_method = "3B3EF8E26C12E3D51B48D0C30732D5F5", hash_generated_method = "9D83E94F8039F3F4C2AE361821E2AA0C")
    
public String getNegativeSuffix() {
        if (negSuffNull) {
            return null;
        }
        return getTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.104 -0500", hash_original_method = "8D4D6B90A746E09AE36173ABA0AB4B15", hash_generated_method = "581950C2496A1A514954A3A78FA8B01C")
    
public String getPositivePrefix() {
        if (posPrefNull) {
            return null;
        }
        return getTextAttribute(this.address, UNUM_POSITIVE_PREFIX);
    }

    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.106 -0500", hash_original_method = "6CFE84E5B71B94B0DE7447BA68FEA246", hash_generated_method = "3AD35C82D539F299DB02940C94F83D19")
    
public String getPositiveSuffix() {
        if (posSuffNull) {
            return null;
        }
        return getTextAttribute(this.address, UNUM_POSITIVE_SUFFIX);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.108 -0500", hash_original_method = "F9B59ECC893A5B014F6155ABE9703BF1", hash_generated_method = "7B47A0BAA45FBCCD4AA2CFD85C5CF72A")
    
public boolean isDecimalSeparatorAlwaysShown() {
        return getAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.110 -0500", hash_original_method = "84561142CC409560F18895112EB228ED", hash_generated_method = "899EE8471708EBFF937AB7ED92A7D857")
    
public boolean isParseBigDecimal() {
        return parseBigDecimal;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.112 -0500", hash_original_method = "1D326E5349B9E5A9AED64258AB68CB41", hash_generated_method = "23A8B75D67F6E2796AB4F631141BEE19")
    
public boolean isParseIntegerOnly() {
        return getAttribute(this.address, UNUM_PARSE_INT_ONLY) != 0;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.114 -0500", hash_original_method = "00E8502D2DA3C0C73215E5BC5979A07C", hash_generated_method = "6DA75B740AECFF4342DDF5400CA2EDDA")
    
public boolean isGroupingUsed() {
        return getAttribute(this.address, UNUM_GROUPING_USED) != 0;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.118 -0500", hash_original_method = "4515EB7BD614742B3D0DDD5748BC74D6", hash_generated_method = "F824E4C2B31DD3ADDC931DE4B5A5DE6D")
    
public void setDecimalSeparatorAlwaysShown(boolean value) {
        int i = value ? -1 : 0;
        setAttribute(this.address, UNUM_DECIMAL_ALWAYS_SHOWN, i);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.120 -0500", hash_original_method = "27959CC6793546F59976E7DBD15119DA", hash_generated_method = "572864D753B150107BBD826FF9D38DA4")
    
public void setCurrency(Currency currency) {
        setSymbol(this.address, UNUM_CURRENCY_SYMBOL, currency.getSymbol());
        setSymbol(this.address, UNUM_INTL_CURRENCY_SYMBOL, currency.getCurrencyCode());
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.122 -0500", hash_original_method = "49FEA0DFBB56F17CB90E68E0F78CE577", hash_generated_method = "A2A66CC1A7A2CC0DE057B28E019594C0")
    
public void setGroupingSize(int value) {
        setAttribute(this.address, UNUM_GROUPING_SIZE, value);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.125 -0500", hash_original_method = "E302CDF79A67421C2D7FEEF4C305D93F", hash_generated_method = "4801CF0DC25F5324D492D79B75A42453")
    
public void setGroupingUsed(boolean value) {
        int i = value ? -1 : 0;
        setAttribute(this.address, UNUM_GROUPING_USED, i);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.127 -0500", hash_original_method = "758C6DB93C92764527C1135AD7160507", hash_generated_method = "659F9EA029DD1061E016733E46211287")
    
public void setMaximumFractionDigits(int value) {
        setAttribute(this.address, UNUM_MAX_FRACTION_DIGITS, value);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.129 -0500", hash_original_method = "89C5389B02F633081323A23C8FB84870", hash_generated_method = "E5D10E3F9F635E6536CEAE0003121469")
    
public void setMaximumIntegerDigits(int value) {
        setAttribute(this.address, UNUM_MAX_INTEGER_DIGITS, value);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.131 -0500", hash_original_method = "62DF7CF1343955ADCD931CBCC029C545", hash_generated_method = "59E8792979AB2E0BA077A717839DA237")
    
public void setMinimumFractionDigits(int value) {
        setAttribute(this.address, UNUM_MIN_FRACTION_DIGITS, value);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.134 -0500", hash_original_method = "5D466EF26E9A120396C63069DE20CEB4", hash_generated_method = "7D321FFF357990AE690771749696B2A5")
    
public void setMinimumIntegerDigits(int value) {
        setAttribute(this.address, UNUM_MIN_INTEGER_DIGITS, value);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.136 -0500", hash_original_method = "B169BA3B31B9F8AB850C7AD451D65C7F", hash_generated_method = "4E50AB491F58A05AC782B00F0C2877BD")
    
public void setMultiplier(int value) {
        setAttribute(this.address, UNUM_MULTIPLIER, value);
        // Update the cached BigDecimal for multiplier.
        multiplierBigDecimal = BigDecimal.valueOf(value);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.138 -0500", hash_original_method = "74BB5921C2CC61F7BCF8D1B8841FD51E", hash_generated_method = "D0A979A926B677EB433F5025ED5E068A")
    
public void setNegativePrefix(String value) {
        negPrefNull = value == null;
        if (!negPrefNull) {
            setTextAttribute(this.address, UNUM_NEGATIVE_PREFIX, value);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.140 -0500", hash_original_method = "0FF0A51DFB17D23D2B0F182081F1472B", hash_generated_method = "C8A4F5BCBFD0EFE22965E3DAA359544E")
    
public void setNegativeSuffix(String value) {
        negSuffNull = value == null;
        if (!negSuffNull) {
            setTextAttribute(this.address, UNUM_NEGATIVE_SUFFIX, value);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.143 -0500", hash_original_method = "FC20737C410620F82F4CED74F1142CF3", hash_generated_method = "0C309F46A1CB233E54484CF6A12D35B4")
    
public void setPositivePrefix(String value) {
        posPrefNull = value == null;
        if (!posPrefNull) {
            setTextAttribute(this.address, UNUM_POSITIVE_PREFIX, value);
        }
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.145 -0500", hash_original_method = "48A175BA83D370BA86128EC6BAC61CB5", hash_generated_method = "811D97BA9744150A93D023AE3F4D2A87")
    
public void setPositiveSuffix(String value) {
        posSuffNull = value == null;
        if (!posSuffNull) {
            setTextAttribute(this.address, UNUM_POSITIVE_SUFFIX, value);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.148 -0500", hash_original_method = "16B3A7386DF3851CB73D32D9A838D98B", hash_generated_method = "5BF92FE0AB1045DC339EE01001529A38")
    
public void setParseBigDecimal(boolean value) {
        parseBigDecimal = value;
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.150 -0500", hash_original_method = "7FF47C5BC2EFAEE27B26A852A846EAFB", hash_generated_method = "3DDC9E84EC911D2A8519173C58E82CB0")
    
public void setParseIntegerOnly(boolean value) {
        int i = value ? -1 : 0;
        setAttribute(this.address, UNUM_PARSE_INT_ONLY, i);
    }

    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:02:07.155 -0500", hash_original_method = "D542BB733096020C1E39876D678697A7", hash_generated_method = "D2C92D9CC4C42E1B94E73107ED7B1DC9")
    
public void setRoundingMode(RoundingMode roundingMode, double roundingIncrement) {
        final int nativeRoundingMode;
        switch (roundingMode) {
        case CEILING: nativeRoundingMode = 0; break;
        case FLOOR: nativeRoundingMode = 1; break;
        case DOWN: nativeRoundingMode = 2; break;
        case UP: nativeRoundingMode = 3; break;
        case HALF_EVEN: nativeRoundingMode = 4; break;
        case HALF_DOWN: nativeRoundingMode = 5; break;
        case HALF_UP: nativeRoundingMode = 6; break;
        default: throw new AssertionError();
        }
        setRoundingMode(address, nativeRoundingMode, roundingIncrement);
    }
}

