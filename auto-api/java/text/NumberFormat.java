package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Currency;
import java.util.Locale;
import libcore.icu.ICU;
import libcore.icu.LocaleData;

public abstract class NumberFormat extends Format {
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.935 -0400", hash_original_field = "A8297487699539E2F81FB26EFCAE4926", hash_generated_field = "BA0A3C716E8972AFDE20CB1849A202C5")
	private boolean groupingUsed = true;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.935 -0400", hash_original_field = "1B0360C18BB931B3601366AE793BA160", hash_generated_field = "B8A513C59F0250621283D2DE9187B85C")
	private boolean parseIntegerOnly = false;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.935 -0400", hash_original_field = "1B64E19FB2AD8A96A43F15BDB5C977BC", hash_generated_field = "A77FA56511D100D0E8370E5AA6626E49")
	private int maximumIntegerDigits = 40;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.935 -0400", hash_original_field = "7EB911BA8BD0D322029A9FDAB57505FC", hash_generated_field = "7C07B0CC78175F8B345B2FD942DE4829")
	private int minimumIntegerDigits = 1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.935 -0400", hash_original_field = "F8E2B2219E9D1D35671A6FF9D8DD023B", hash_generated_field = "9031A923FB51BEDA5191306AA866610E")
	private int maximumFractionDigits = 3;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.935 -0400", hash_original_field = "81C5674E758DBE4CDDC7554C3C6402D5", hash_generated_field = "A2436992C475A167FCC16C9C61FB2AEF")
	private int minimumFractionDigits = 0;

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.936 -0400", hash_original_method = "AC8E136DE5A642003A57BDCF52FB755A", hash_generated_method = "4471CB6ABEB340D260FD4A286AE4BB26")
	protected NumberFormat() {
		// ---------- Original Method ----------
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.936 -0400", hash_original_method = "323EA29B58059AEF6BA9ED0328A60A9B", hash_generated_method = "7EC35F94DC6359902DE23C8D0C6F0935")
	@Override
	public Object clone() {
		Object varB4EAC82CA7396A68D541C85D26508E83_720822178 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_720822178 = super.clone();
		varB4EAC82CA7396A68D541C85D26508E83_720822178.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varB4EAC82CA7396A68D541C85D26508E83_720822178;
		// ---------- Original Method ----------
		// return super.clone();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.936 -0400", hash_original_method = "CF2A5131022F3DE945450C291D454139", hash_generated_method = "B0F0F3F5F877D0DB1C5D10184AA64020")
	@Override
	public boolean equals(Object object) {
		{
			boolean var3F549205D4C262003697A031F89E5954_2108033581 = (object == this);
		} // End collapsed parenthetic
		NumberFormat obj = (NumberFormat) object;
		addTaint(object.getTaint());
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_513928498 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_513928498;
		// ---------- Original Method ----------
		// if (object == this) {
		// return true;
		// }
		// if (!(object instanceof NumberFormat)) {
		// return false;
		// }
		// NumberFormat obj = (NumberFormat) object;
		// return groupingUsed == obj.groupingUsed
		// && parseIntegerOnly == obj.parseIntegerOnly
		// && maximumFractionDigits == obj.maximumFractionDigits
		// && maximumIntegerDigits == obj.maximumIntegerDigits
		// && minimumFractionDigits == obj.minimumFractionDigits
		// && minimumIntegerDigits == obj.minimumIntegerDigits;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.937 -0400", hash_original_method = "D30D6926B1574E72997696CC4AACA867", hash_generated_method = "73CBC7A800FA6C1AEFAAF59F02C3F9AE")
	public final String format(double value) {
		String varB4EAC82CA7396A68D541C85D26508E83_2032691399 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_2032691399 = format(value, new StringBuffer(), new FieldPosition(0)).toString();
		addTaint(value);
		varB4EAC82CA7396A68D541C85D26508E83_2032691399.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_2032691399;
		// ---------- Original Method ----------
		// return format(value, new StringBuffer(), new FieldPosition(0))
		// .toString();
	}

	public abstract StringBuffer format(double value, StringBuffer buffer, FieldPosition field);

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.938 -0400", hash_original_method = "D84155C6B50E9BFD8F05A957DEB6EF42", hash_generated_method = "CA707BAE38402AE5C889734E7EA2A85D")
	public final String format(long value) {
		String varB4EAC82CA7396A68D541C85D26508E83_464176772 = null; // Variable
																		// for
																		// return
																		// #1
		varB4EAC82CA7396A68D541C85D26508E83_464176772 = format(value, new StringBuffer(), new FieldPosition(0)).toString();
		addTaint(value);
		varB4EAC82CA7396A68D541C85D26508E83_464176772.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varB4EAC82CA7396A68D541C85D26508E83_464176772;
		// ---------- Original Method ----------
		// return format(value, new StringBuffer(), new FieldPosition(0))
		// .toString();
	}

	public abstract StringBuffer format(long value, StringBuffer buffer, FieldPosition field);

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.940 -0400", hash_original_method = "294F85583D2E74BD6D7B73B5CBA517EA", hash_generated_method = "D6D7997E453C242B195A6AE903707359")
	@Override
	public StringBuffer format(Object object, StringBuffer buffer, FieldPosition field) {
		StringBuffer varB4EAC82CA7396A68D541C85D26508E83_435612994 = null; // Variable
																			// for
																			// return
																			// #1
		StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1158300728 = null; // Variable
																			// for
																			// return
																			// #2
		{
			boolean varD611950ED406B9E001DAC51F5B874D45_1610421566 = (object instanceof Byte || object instanceof Short || object instanceof Integer || object instanceof Long || (object instanceof BigInteger && ((BigInteger) object)
					.bitLength() < 64));
			{
				long lv = ((Number) object).longValue();
				varB4EAC82CA7396A68D541C85D26508E83_435612994 = format(lv, buffer, field);
			} // End block
			{
				double dv = ((Number) object).doubleValue();
				varB4EAC82CA7396A68D541C85D26508E83_1158300728 = format(dv, buffer, field);
			} // End block
		} // End collapsed parenthetic
		if (DroidSafeAndroidRuntime.control)
			throw new IllegalArgumentException();
		addTaint(object.getTaint());
		addTaint(buffer.getTaint());
		addTaint(field.getTaint());
		StringBuffer varA7E53CE21691AB073D9660D615818899_245570977; // Final
																	// return
																	// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_245570977 = varB4EAC82CA7396A68D541C85D26508E83_435612994;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_245570977 = varB4EAC82CA7396A68D541C85D26508E83_1158300728;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_245570977.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_245570977;
		// ---------- Original Method ----------
		// if (object instanceof Byte || object instanceof Short || object
		// instanceof Integer ||
		// object instanceof Long ||
		// (object instanceof BigInteger && ((BigInteger) object).bitLength() <
		// 64)) {
		// long lv = ((Number) object).longValue();
		// return format(lv, buffer, field);
		// } else if (object instanceof Number) {
		// double dv = ((Number) object).doubleValue();
		// return format(dv, buffer, field);
		// }
		// throw new IllegalArgumentException();
	}

	public static Locale[] getAvailableLocales() {
		return ICU.getAvailableNumberFormatLocales();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.942 -0400", hash_original_method = "B4D372C49661A5E03C88F7CDA081E3AF", hash_generated_method = "370E82BA21D43D3A988968089383E8D8")
	public Currency getCurrency() {
		throw new UnsupportedOperationException();
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	public static final NumberFormat getCurrencyInstance() {
		return getCurrencyInstance(Locale.getDefault());
	}

	public static NumberFormat getCurrencyInstance(Locale locale) {
		return getInstance(LocaleData.get(locale).currencyPattern, locale);
	}

	public static final NumberFormat getIntegerInstance() {
		return getIntegerInstance(Locale.getDefault());
	}

	public static NumberFormat getIntegerInstance(Locale locale) {
		NumberFormat result = getInstance(LocaleData.get(locale).integerPattern, locale);
		result.setParseIntegerOnly(true);
		return result;
	}

	public static final NumberFormat getInstance() {
		return getNumberInstance();
	}

	public static NumberFormat getInstance(Locale locale) {
		return getNumberInstance(locale);
	}

	private static NumberFormat getInstance(String pattern, Locale locale) {
		return new DecimalFormat(pattern, locale);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.944 -0400", hash_original_method = "E813DF8258936A130B114EAEAD95EDA2", hash_generated_method = "E4943E02A55209BB0DFBA16B0220CED1")
	public int getMaximumFractionDigits() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_259455014 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_259455014;
		// ---------- Original Method ----------
		// return maximumFractionDigits;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.945 -0400", hash_original_method = "78A0327FC665D89694C44AF144F747A0", hash_generated_method = "CB467B7782049FA75A4B651B6A7B5F43")
	public int getMaximumIntegerDigits() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876906333 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1876906333;
		// ---------- Original Method ----------
		// return maximumIntegerDigits;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.945 -0400", hash_original_method = "357B48579C639D091425919515E6A5BC", hash_generated_method = "45B795EE1BD31899B66B524D0B89956A")
	public int getMinimumFractionDigits() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908027095 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1908027095;
		// ---------- Original Method ----------
		// return minimumFractionDigits;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.945 -0400", hash_original_method = "F5C90064F0CFBE4D6C8C4DDC2FA4814C", hash_generated_method = "329FC4F6F5B871125E31221EA602D526")
	public int getMinimumIntegerDigits() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816723963 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1816723963;
		// ---------- Original Method ----------
		// return minimumIntegerDigits;
	}

	public static final NumberFormat getNumberInstance() {
		return getNumberInstance(Locale.getDefault());
	}

	public static NumberFormat getNumberInstance(Locale locale) {
		return getInstance(LocaleData.get(locale).numberPattern, locale);
	}

	public static final NumberFormat getPercentInstance() {
		return getPercentInstance(Locale.getDefault());
	}

	public static NumberFormat getPercentInstance(Locale locale) {
		return getInstance(LocaleData.get(locale).percentPattern, locale);
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.947 -0400", hash_original_method = "BA195880AA858EB457E0D875FED9F2CD", hash_generated_method = "D1A89EEA004CC9B420A4A836AD74BFBC")
	@Override
	public int hashCode() {
		int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689792573 = getTaintInt();
		return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_689792573;
		// ---------- Original Method ----------
		// return (groupingUsed ? 1231 : 1237) + (parseIntegerOnly ? 1231 :
		// 1237)
		// + maximumFractionDigits + maximumIntegerDigits
		// + minimumFractionDigits + minimumIntegerDigits;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.947 -0400", hash_original_method = "4D5DDA7520229906D909C6D4DE03887B", hash_generated_method = "9AAA6D87A2A37F3FE2836C49F0F54E0D")
	public boolean isGroupingUsed() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1264205816 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_1264205816;
		// ---------- Original Method ----------
		// return groupingUsed;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.948 -0400", hash_original_method = "2C7184F183FABEE99D4475D92EBC3629", hash_generated_method = "69AED87F3AFA9246B4553CFF3634ABD3")
	public boolean isParseIntegerOnly() {
		boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_104959384 = getTaintBoolean();
		return var84E2C64F38F78BA3EA5C905AB5A2DA27_104959384;
		// ---------- Original Method ----------
		// return parseIntegerOnly;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.949 -0400", hash_original_method = "FE3646B6613636F305FFC18B8FD2F859", hash_generated_method = "45B4C442F1B56B39F507C01CD47EFA1A")
	public Number parse(String string) throws ParseException {
		Number varB4EAC82CA7396A68D541C85D26508E83_1189202990 = null; // Variable
																		// for
																		// return
																		// #1
		ParsePosition pos = new ParsePosition(0);
		Number number = parse(string, pos);
		{
			boolean varD85785EE01F666E79EC762AC1E448E10_627536926 = (pos.getIndex() == 0);
			{
				if (DroidSafeAndroidRuntime.control)
					throw new ParseException("Unparseable number: \"" + string + "\"", pos.getErrorIndex());
			} // End block
		} // End collapsed parenthetic
		varB4EAC82CA7396A68D541C85D26508E83_1189202990 = number;
		addTaint(string.getTaint());
		varB4EAC82CA7396A68D541C85D26508E83_1189202990.addTaint(getTaint()); // Add
																				// taint
																				// from
																				// parent
		return varB4EAC82CA7396A68D541C85D26508E83_1189202990;
		// ---------- Original Method ----------
		// ParsePosition pos = new ParsePosition(0);
		// Number number = parse(string, pos);
		// if (pos.getIndex() == 0) {
		// throw new ParseException("Unparseable number: \"" + string + "\"",
		// pos.getErrorIndex());
		// }
		// return number;
	}

	public abstract Number parse(String string, ParsePosition position);

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.953 -0400", hash_original_method = "CBC8FD7F8E88C5B63A9D5DAA3A983953", hash_generated_method = "9F8BC1AE2640F4258D00D86940D028F0")
	@Override
	public final Object parseObject(String string, ParsePosition position) {
		Object varB4EAC82CA7396A68D541C85D26508E83_827239396 = null; // Variable
																		// for
																		// return
																		// #1
		Object varB4EAC82CA7396A68D541C85D26508E83_644890472 = null; // Variable
																		// for
																		// return
																		// #2
		{
			if (DroidSafeAndroidRuntime.control)
				throw new NullPointerException("position is null");
		} // End block
		try {
			varB4EAC82CA7396A68D541C85D26508E83_827239396 = parse(string, position);
		} // End block
		catch (Exception e) {
			varB4EAC82CA7396A68D541C85D26508E83_644890472 = null;
		} // End block
		addTaint(string.getTaint());
		addTaint(position.getTaint());
		Object varA7E53CE21691AB073D9660D615818899_807766844; // Final return
																// value
		switch (DroidSafeAndroidRuntime.switchControl) {
		case 1: // Assign result for return ordinal #1
			varA7E53CE21691AB073D9660D615818899_807766844 = varB4EAC82CA7396A68D541C85D26508E83_827239396;
			break;
		default:
			varA7E53CE21691AB073D9660D615818899_807766844 = varB4EAC82CA7396A68D541C85D26508E83_644890472;
			break;
		}
		varA7E53CE21691AB073D9660D615818899_807766844.addTaint(getTaint()); // Add
																			// taint
																			// from
																			// parent
		return varA7E53CE21691AB073D9660D615818899_807766844;
		// ---------- Original Method ----------
		// if (position == null) {
		// throw new NullPointerException("position is null");
		// }
		// try {
		// return parse(string, position);
		// } catch (Exception e) {
		// return null;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.954 -0400", hash_original_method = "840FE994670C453CCC1032B9649CFF03", hash_generated_method = "DA36CEB75A8C642CC390F7BB3852AB35")
	public void setCurrency(Currency currency) {
		if (DroidSafeAndroidRuntime.control)
			throw new UnsupportedOperationException();
		addTaint(currency.getTaint());
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.955 -0400", hash_original_method = "A7E1435E673E29B6F1D0E28A7EA1B8E8", hash_generated_method = "579E547AED141F13B97721B484886296")
	public void setGroupingUsed(boolean value) {
		groupingUsed = value;
		// ---------- Original Method ----------
		// groupingUsed = value;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.956 -0400", hash_original_method = "8D829B5D993AE8CFC3165307650DC45D", hash_generated_method = "979309CAAEB255D26FFC8E250B3A1A58")
	public void setMaximumFractionDigits(int value) {
		maximumFractionDigits = value < 0 ? 0 : value;
		{
			minimumFractionDigits = maximumFractionDigits;
		} // End block
			// ---------- Original Method ----------
			// maximumFractionDigits = value < 0 ? 0 : value;
			// if (maximumFractionDigits < minimumFractionDigits) {
			// minimumFractionDigits = maximumFractionDigits;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.956 -0400", hash_original_method = "21B8BEFD42232423658838BAC20C84FE", hash_generated_method = "5E1D03428256DBB14D382BAF5C25FAC5")
	public void setMaximumIntegerDigits(int value) {
		maximumIntegerDigits = value < 0 ? 0 : value;
		{
			minimumIntegerDigits = maximumIntegerDigits;
		} // End block
			// ---------- Original Method ----------
			// maximumIntegerDigits = value < 0 ? 0 : value;
			// if (maximumIntegerDigits < minimumIntegerDigits) {
			// minimumIntegerDigits = maximumIntegerDigits;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.957 -0400", hash_original_method = "2004D453A285EC62847C50B61DD7CBAF", hash_generated_method = "CA921B64E5FB83ADC0F5C232AF317A79")
	public void setMinimumFractionDigits(int value) {
		minimumFractionDigits = value < 0 ? 0 : value;
		{
			maximumFractionDigits = minimumFractionDigits;
		} // End block
			// ---------- Original Method ----------
			// minimumFractionDigits = value < 0 ? 0 : value;
			// if (maximumFractionDigits < minimumFractionDigits) {
			// maximumFractionDigits = minimumFractionDigits;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.958 -0400", hash_original_method = "6D62345156926236ED68DA3CBABDD448", hash_generated_method = "314275626C7C3ACE82FAB27B43E94527")
	public void setMinimumIntegerDigits(int value) {
		minimumIntegerDigits = value < 0 ? 0 : value;
		{
			maximumIntegerDigits = minimumIntegerDigits;
		} // End block
			// ---------- Original Method ----------
			// minimumIntegerDigits = value < 0 ? 0 : value;
			// if (maximumIntegerDigits < minimumIntegerDigits) {
			// maximumIntegerDigits = minimumIntegerDigits;
		// }
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.959 -0400", hash_original_method = "7914BBF7EC4F88E69DC0254980E5E100", hash_generated_method = "17744EC5A610FD6FB76060138790E549")
	public void setParseIntegerOnly(boolean value) {
		parseIntegerOnly = value;
		// ---------- Original Method ----------
		// parseIntegerOnly = value;
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.959 -0400", hash_original_method = "615BDCCE0F576CE8071CDC67AB896544", hash_generated_method = "BA33056D003B43E42B698BC09B9640EF")
	private void writeObject(ObjectOutputStream stream) throws IOException {
		ObjectOutputStream.PutField fields = stream.putFields();
		fields.put("groupingUsed", groupingUsed);
		fields.put("maxFractionDigits", maximumFractionDigits < Byte.MAX_VALUE ? (byte) maximumFractionDigits : Byte.MAX_VALUE);
		fields.put("maximumFractionDigits", maximumFractionDigits);
		fields.put("maximumIntegerDigits", maximumIntegerDigits);
		fields.put("maxIntegerDigits", maximumIntegerDigits < Byte.MAX_VALUE ? (byte) maximumIntegerDigits : Byte.MAX_VALUE);
		fields.put("minFractionDigits", minimumFractionDigits < Byte.MAX_VALUE ? (byte) minimumFractionDigits : Byte.MAX_VALUE);
		fields.put("minimumFractionDigits", minimumFractionDigits);
		fields.put("minimumIntegerDigits", minimumIntegerDigits);
		fields.put("minIntegerDigits", minimumIntegerDigits < Byte.MAX_VALUE ? (byte) minimumIntegerDigits : Byte.MAX_VALUE);
		fields.put("parseIntegerOnly", parseIntegerOnly);
		fields.put("serialVersionOnStream", 1);
		stream.writeFields();
		addTaint(stream.getTaint());
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.961 -0400", hash_original_method = "7CE1B061AB7260929E58BDEF36BC550E", hash_generated_method = "CF44530804DD657117A56D1102564A03")
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		ObjectInputStream.GetField fields = stream.readFields();
		groupingUsed = fields.get("groupingUsed", true);
		parseIntegerOnly = fields.get("parseIntegerOnly", false);
		{
			boolean varB1402D125FA51CA7547D890DB81A6275_519731916 = (fields.get("serialVersionOnStream", 0) == 0);
			{
				maximumFractionDigits = fields.get("maxFractionDigits", (byte) 3);
				maximumIntegerDigits = fields.get("maxIntegerDigits", (byte) 40);
				minimumFractionDigits = fields.get("minFractionDigits", (byte) 0);
				minimumIntegerDigits = fields.get("minIntegerDigits", (byte) 1);
			} // End block
			{
				maximumFractionDigits = fields.get("maximumFractionDigits", 3);
				maximumIntegerDigits = fields.get("maximumIntegerDigits", 40);
				minimumFractionDigits = fields.get("minimumFractionDigits", 0);
				minimumIntegerDigits = fields.get("minimumIntegerDigits", 1);
			} // End block
		} // End collapsed parenthetic
		{
			if (DroidSafeAndroidRuntime.control)
				throw new InvalidObjectException("min digits greater than max digits");
		} // End block
		{
			if (DroidSafeAndroidRuntime.control)
				throw new InvalidObjectException("min or max digits negative");
		} // End block
		addTaint(stream.getTaint());
		// ---------- Original Method ----------
		// Original Method Too Long, Refer to Original Implementation
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.962 -0400", hash_original_method = "E6FF1C57537669874BDF42CE722EB942", hash_generated_method = "A68D6EAADB7B38CEDCDD0A0A873B1985")
	public RoundingMode getRoundingMode() {
		throw new UnsupportedOperationException();
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.962 -0400", hash_original_method = "0C28590135419FD8FADCC2330801FC90", hash_generated_method = "F95A59A0280013F81EE5FB65FD12A168")
	public void setRoundingMode(RoundingMode roundingMode) {
		if (DroidSafeAndroidRuntime.control)
			throw new UnsupportedOperationException();
		addTaint(roundingMode.getTaint());
		// ---------- Original Method ----------
		// throw new UnsupportedOperationException();
	}

	public static class Field extends Format.Field {

		@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.963 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "465767ECB3AF93CD4C2D7AEDA23F18B3")
		protected Field(String fieldName) {
			super(fieldName);
			addTaint(fieldName.getTaint());
			// ---------- Original Method ----------
		}

		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.963 -0400", hash_original_field = "2FFF218EC81F19332810C67805AA588F", hash_generated_field = "E6808DCA2B613BACD85F5DF8A49842E5")
		private static final long serialVersionUID = 7494728892700160890L;
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.963 -0400", hash_original_field = "C17D51A6125EA6A3385B4D72203CA690", hash_generated_field = "E67CF04835E7440B3B8255401771C5CD")
		public static final Field SIGN = new Field("sign");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "59910FEA88AFC9673A7975540E0C6925", hash_generated_field = "3E710ACC9159D86DCBAEF807D5972AA9")
		public static final Field INTEGER = new Field("integer");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "5E0217A095C352CEC03311A125609AFC", hash_generated_field = "6E1A733B400A6EC7E2C2C43052CECE2A")
		public static final Field FRACTION = new Field("fraction");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "A2A6879886A605EE3675E7DA49C1979F", hash_generated_field = "319F9EC01C54BF39610B784926849985")
		public static final Field EXPONENT = new Field("exponent");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "2B71E7B00BB2FED06381E6BF37FB977D", hash_generated_field = "6F3344887D5C43063B3E3BB99EEA0438")
		public static final Field EXPONENT_SIGN = new Field("exponent sign");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "3BAE80E0C7E567B712E0EA667FCF280A", hash_generated_field = "9DAFAC188978AAF54D1712AE1358211E")
		public static final Field EXPONENT_SYMBOL = new Field("exponent symbol");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "C15DA94BE137825E07F879EA3CB2DA19", hash_generated_field = "7DA4CAE4944D7EA0085939A97D217F42")
		public static final Field DECIMAL_SEPARATOR = new Field("decimal separator");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "1196F40BFD62B1FFF47459DF9CACCFD1", hash_generated_field = "426A0B45CE473A2A95A3111A95B0BC93")
		public static final Field GROUPING_SEPARATOR = new Field("grouping separator");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "E7F0EC9BE1B2FE1FED599FA6F37BEF54", hash_generated_field = "8E65210094B4E3C543532347F9FF71EC")
		public static final Field PERCENT = new Field("percent");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "8304A2F34144D5D349572E6C95EB2710", hash_generated_field = "E1C4AB1812D6EAA5813530289FF65B7E")
		public static final Field PERMILLE = new Field("per mille");
		@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "1C4C7EF748C9866E3B3752B5A41AE5CC", hash_generated_field = "4C849A2E4130CBE7D5EC854384ED9B8E")
		public static final Field CURRENCY = new Field("currency");
	}

	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "BE4A61B7295266FE7928F531C26A7099", hash_generated_field = "F09073C8D8AE7A807304B7452EAEF8B1")
	private static final long serialVersionUID = -2308460125733713944L;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "23A2515812AC5924453701219A432517", hash_generated_field = "8E8C994FB7A9C648CA5248364548DF14")
	public static final int INTEGER_FIELD = 0;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "BBE29EE2A18D6AE982BDFB95538B188F", hash_generated_field = "366746AFA392D2AA06B116040E73FAAC")
	public static final int FRACTION_FIELD = 1;
	@DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.964 -0400", hash_original_field = "33C00664BC739ABE02AC1026A2BAE10E", hash_generated_field = "BAD9E2169D2150C1AD558C00FC601059")
	private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("groupingUsed", boolean.class),
			new ObjectStreamField("maxFractionDigits", byte.class), new ObjectStreamField("maximumFractionDigits", int.class),
			new ObjectStreamField("maximumIntegerDigits", int.class), new ObjectStreamField("maxIntegerDigits", byte.class),
			new ObjectStreamField("minFractionDigits", byte.class), new ObjectStreamField("minimumFractionDigits", int.class),
			new ObjectStreamField("minimumIntegerDigits", int.class), new ObjectStreamField("minIntegerDigits", byte.class),
			new ObjectStreamField("parseIntegerOnly", boolean.class), new ObjectStreamField("serialVersionOnStream", int.class), };
}
