package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public final class StringBuilder extends AbstractStringBuilder implements Appendable, CharSequence, Serializable {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.175 -0500", hash_original_field = "7CEF4316B76E69AAF57103267772616E", hash_generated_field = "B39011C4BB0C9D7DCA32E1A2469D43EC")

    private static final long serialVersionUID = 4383685877147921099L;

    /**
     * Constructs an instance with an initial capacity of {@code 16}.
     *
     * @see #capacity()
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.177 -0500", hash_original_method = "7F69BEEEB3AFB76A0F531C605E603484", hash_generated_method = "7169FB6FFC5F8BA666834292D850982F")
    
public StringBuilder() {
    }

    /**
     * Constructs an instance with the specified capacity.
     *
     * @param capacity
     *            the initial capacity to use.
     * @throws NegativeArraySizeException
     *             if the specified {@code capacity} is negative.
     * @see #capacity()
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.180 -0500", hash_original_method = "E4F57F923C13DCFDFB2A278667BC010D", hash_generated_method = "5D0A27352F38E3C125CF335CBDA1294C")
    
public StringBuilder(int capacity) {
        super(capacity);
    }

    /**
     * Constructs an instance that's initialized with the contents of the
     * specified {@code CharSequence}. The capacity of the new builder will be
     * the length of the {@code CharSequence} plus 16.
     *
     * @param seq
     *            the {@code CharSequence} to copy into the builder.
     * @throws NullPointerException
     *            if {@code seq} is {@code null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.183 -0500", hash_original_method = "6026ED097BE2B2C063828C0943FCE04D", hash_generated_method = "7BB2522BCAA4830FEDD7EA86B4207862")
    
public StringBuilder(CharSequence seq) {
        super(seq.toString());
    }

    /**
     * Constructs an instance that's initialized with the contents of the
     * specified {@code String}. The capacity of the new builder will be the
     * length of the {@code String} plus 16.
     *
     * @param str
     *            the {@code String} to copy into the builder.
     * @throws NullPointerException
     *            if {@code str} is {@code null}.
     */
    @DSComment("constructor")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.186 -0500", hash_original_method = "AED4EA464802033AF614945292CFDAC8", hash_generated_method = "DF9AB23776A1F0CC49E7F85950B92881")
    
public StringBuilder(String str) {
        super(str);
    }

    /**
     * Appends the string representation of the specified {@code boolean} value.
     * The {@code boolean} value is converted to a String according to the rule
     * defined by {@link String#valueOf(boolean)}.
     *
     * @param b
     *            the {@code boolean} value to append.
     * @return this builder.
     * @see String#valueOf(boolean)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.188 -0500", hash_original_method = "F4B609B0FD968769DCA7EA12F3C7D749", hash_generated_method = "10234F2C6B874DC25F3B85EB5405B8BF")
    
public StringBuilder append(boolean b) {
        this.addTaint(b);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code char} value.
     * The {@code char} value is converted to a string according to the rule
     * defined by {@link String#valueOf(char)}.
     *
     * @param c
     *            the {@code char} value to append.
     * @return this builder.
     * @see String#valueOf(char)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.190 -0500", hash_original_method = "9D73E236BE501966A93F921E007247A5", hash_generated_method = "573014C053845D973AB8BF2E1141C001")
    
public StringBuilder append(char c) {
        append0(c);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code int} value. The
     * {@code int} value is converted to a string according to the rule defined
     * by {@link String#valueOf(int)}.
     *
     * @param i
     *            the {@code int} value to append.
     * @return this builder.
     * @see String#valueOf(int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.193 -0500", hash_original_method = "03C42A72247CEAA018EF9799EE93DC9B", hash_generated_method = "06B8F1DCC54980DA0607BA7F80669E0E")
    
public StringBuilder append(int i) {
        addTaint(i);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code long} value.
     * The {@code long} value is converted to a string according to the rule
     * defined by {@link String#valueOf(long)}.
     *
     * @param l
     *            the {@code long} value.
     * @return this builder.
     * @see String#valueOf(long)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.195 -0500", hash_original_method = "3D332B8F712AE97F73088EED6A4C60D8", hash_generated_method = "AF09391DF0EB76459C4CDE72BE800231")
    
public StringBuilder append(long l) {
        addTaint(l);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code float} value.
     * The {@code float} value is converted to a string according to the rule
     * defined by {@link String#valueOf(float)}.
     *
     * @param f
     *            the {@code float} value to append.
     * @return this builder.
     * @see String#valueOf(float)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.197 -0500", hash_original_method = "C39FE91FF51EAFB5C369F19D2F31B26F", hash_generated_method = "CDEFE36323E4CF99EA8F8E5BB889EA8B")
    
public StringBuilder append(float f) {
        this.addTaint(f);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code double} value.
     * The {@code double} value is converted to a string according to the rule
     * defined by {@link String#valueOf(double)}.
     *
     * @param d
     *            the {@code double} value to append.
     * @return this builder.
     * @see String#valueOf(double)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.200 -0500", hash_original_method = "E9C651CD5B73A9D5605CA0251B77324C", hash_generated_method = "4D0DCE75113BEA77BE9EBE194E669575")
    
public StringBuilder append(double d) {
        this.addTaint(d);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code Object}.
     * The {@code Object} value is converted to a string according to the rule
     * defined by {@link String#valueOf(Object)}.
     *
     * @param obj
     *            the {@code Object} to append.
     * @return this builder.
     * @see String#valueOf(Object)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.203 -0500", hash_original_method = "63927F926AE6750A93D97E305D647A93", hash_generated_method = "9E396BD3A53B208EFDF6E5AE46CE5E65")
    
public StringBuilder append(Object obj) {
        /*
        if (obj == null) {
            appendNull();
        } else {
            append0(obj.toString());
        }
        */
        if (obj != null) {
            addTaint(obj.getTaint());
        }
        return this;
    }

    /**
     * Appends the contents of the specified string. If the string is {@code
     * null}, then the string {@code "null"} is appended.
     *
     * @param str
     *            the string to append.
     * @return this builder.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.205 -0500", hash_original_method = "055F3A9C4AB035713F11AAFD846DE2F4", hash_generated_method = "1CA0EEEC4D7F7F784CE4A097257726E9")
    
public StringBuilder append(String str) {
        append0(str);
        return this;
    }

    /**
     * Appends the contents of the specified {@code StringBuffer}. If the
     * StringBuffer is {@code null}, then the string {@code "null"} is
     * appended.
     *
     * @param sb
     *            the {@code StringBuffer} to append.
     * @return this builder.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.207 -0500", hash_original_method = "DA3BC72B04D08CA1AE27B14F3B2132F6", hash_generated_method = "3CDECCB6296E381BB262A6BF8AF07057")
    
public StringBuilder append(StringBuffer sb) {
        addTaint(sb.getTaint());
        return this;
    }

    /**
     * Appends the string representation of the specified {@code char[]}.
     * The {@code char[]} is converted to a string according to the rule
     * defined by {@link String#valueOf(char[])}.
     *
     * @param chars
     *            the {@code char[]} to append..
     * @return this builder.
     * @see String#valueOf(char[])
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.210 -0500", hash_original_method = "E629F87AB17E4A16AA1195961D01ABB5", hash_generated_method = "C96A15857874B6E4B9B3612988C7C3ED")
    
public StringBuilder append(char[] chars) {
        append0(chars);
        return this;
    }

    /**
     * Appends the string representation of the specified subset of the {@code
     * char[]}. The {@code char[]} value is converted to a String according to
     * the rule defined by {@link String#valueOf(char[],int,int)}.
     *
     * @param str
     *            the {@code char[]} to append.
     * @param offset
     *            the inclusive offset index.
     * @param len
     *            the number of characters.
     * @return this builder.
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code offset} and {@code len} do not specify a valid
     *             subsequence.
     * @see String#valueOf(char[],int,int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.213 -0500", hash_original_method = "68F618A3FDF87C48D7DDC534C9C181A8", hash_generated_method = "7C783A60ED2BEC8CF513FFA3F10A8FC8")
    
public StringBuilder append(char[] str, int offset, int len) {
        append0(str, offset, len);
        return this;
    }

    /**
     * Appends the string representation of the specified {@code CharSequence}.
     * If the {@code CharSequence} is {@code null}, then the string {@code
     * "null"} is appended.
     *
     * @param csq
     *            the {@code CharSequence} to append.
     * @return this builder.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.215 -0500", hash_original_method = "D80365633E36C9036E4897C864A6AF37", hash_generated_method = "FDC02CA5B38F45068CDDBB9202395239")
    
public StringBuilder append(CharSequence csq) {
        append0(csq, 0, csq.length());
        return this;
    }

    /**
     * Appends the string representation of the specified subsequence of the
     * {@code CharSequence}. If the {@code CharSequence} is {@code null}, then
     * the string {@code "null"} is used to extract the subsequence from.
     *
     * @param csq
     *            the {@code CharSequence} to append.
     * @param start
     *            the beginning index.
     * @param end
     *            the ending index.
     * @return this builder.
     * @throws IndexOutOfBoundsException
     *             if {@code start} or {@code end} are negative, {@code start}
     *             is greater than {@code end} or {@code end} is greater than
     *             the length of {@code csq}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.218 -0500", hash_original_method = "B3407F260091B09D879B57806B9A4E00", hash_generated_method = "794B834A31083CBEDCB6E4DE1626E692")
    
public StringBuilder append(CharSequence csq, int start, int end) {
        append0(csq, start, end);
        return this;
    }

    /**
     * Appends the encoded Unicode code point. The code point is converted to a
     * {@code char[]} as defined by {@link Character#toChars(int)}.
     *
     * @param codePoint
     *            the Unicode code point to encode and append.
     * @return this builder.
     * @see Character#toChars(int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.220 -0500", hash_original_method = "6B412AA8DE0150EC1DBDE5B0F42A5CFB", hash_generated_method = "4AE22F5CB99576F6B7D639914551478A")
    
public StringBuilder appendCodePoint(int codePoint) {
        addTaint(codePoint);
        return this;
    }

    /**
     * Deletes a sequence of characters specified by {@code start} and {@code
     * end}. Shifts any remaining characters to the left.
     *
     * @param start
     *            the inclusive start index.
     * @param end
     *            the exclusive end index.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code start} is less than zero, greater than the current
     *             length or greater than {@code end}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.223 -0500", hash_original_method = "803DF05D4CC063384FBA901C5CCA5A92", hash_generated_method = "B5E959D005426B0B53B53DF077CB11E6")
    
public StringBuilder delete(int start, int end) {
        delete0(start, end);
        return this;
    }

    /**
     * Deletes the character at the specified index. shifts any remaining
     * characters to the left.
     *
     * @param index
     *            the index of the character to delete.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index} is less than zero or is greater than or
     *             equal to the current length.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.225 -0500", hash_original_method = "9587E0C001AA5E4FBDAD3ADB8121DB12", hash_generated_method = "7294A5044E5D4CF77099393F4198FD4D")
    
public StringBuilder deleteCharAt(int index) {
        deleteCharAt0(index);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code boolean} value
     * at the specified {@code offset}. The {@code boolean} value is converted
     * to a string according to the rule defined by
     * {@link String#valueOf(boolean)}.
     *
     * @param offset
     *            the index to insert at.
     * @param b
     *            the {@code boolean} value to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length}.
     * @see String#valueOf(boolean)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.227 -0500", hash_original_method = "9E94636A15CA5FDDF7E9AC999A98B61E", hash_generated_method = "D5451CE46EB1A61A7740C8D3D125ABAF")
    
public StringBuilder insert(int offset, boolean b) {
        addTaint(b);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code char} value at
     * the specified {@code offset}. The {@code char} value is converted to a
     * string according to the rule defined by {@link String#valueOf(char)}.
     *
     * @param offset
     *            the index to insert at.
     * @param c
     *            the {@code char} value to insert.
     * @return this builder.
     * @throws IndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(char)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.229 -0500", hash_original_method = "50B127D3D7AA52B10DEE8D9E61CF2830", hash_generated_method = "E9E98D3666F6DCC95B4A80456C9FBE03")
    
public StringBuilder insert(int offset, char c) {
        insert0(offset, c);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code int} value at
     * the specified {@code offset}. The {@code int} value is converted to a
     * String according to the rule defined by {@link String#valueOf(int)}.
     *
     * @param offset
     *            the index to insert at.
     * @param i
     *            the {@code int} value to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.232 -0500", hash_original_method = "0E2F0E15101F82363F6315617D179ADE", hash_generated_method = "8794B9AC39FE97D939AC8F6B3DABBC3A")
    
public StringBuilder insert(int offset, int i) {
        addTaint(i);
        addTaint(offset);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code long} value at
     * the specified {@code offset}. The {@code long} value is converted to a
     * String according to the rule defined by {@link String#valueOf(long)}.
     *
     * @param offset
     *            the index to insert at.
     * @param l
     *            the {@code long} value to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {code length()}.
     * @see String#valueOf(long)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.235 -0500", hash_original_method = "0414BCBB4B3CD85646765E73B01D123B", hash_generated_method = "A24B024E0D99D53BD03CEC4D3E9887E8")
    
public StringBuilder insert(int offset, long l) {
        addTaint(l);addTaint(offset);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code float} value at
     * the specified {@code offset}. The {@code float} value is converted to a
     * string according to the rule defined by {@link String#valueOf(float)}.
     *
     * @param offset
     *            the index to insert at.
     * @param f
     *            the {@code float} value to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(float)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.237 -0500", hash_original_method = "8BED9229B1DF452CCAD065018015A008", hash_generated_method = "2EAB1FAF0819E152B085B766F439EB26")
    
public StringBuilder insert(int offset, float f) {
        addTaint(f);addTaint(offset);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code double} value
     * at the specified {@code offset}. The {@code double} value is converted
     * to a String according to the rule defined by
     * {@link String#valueOf(double)}.
     *
     * @param offset
     *            the index to insert at.
     * @param d
     *            the {@code double} value to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(double)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.240 -0500", hash_original_method = "1BF020DB1D2B7F2D38356085E08D1D32", hash_generated_method = "C290A3D0DE64D1A7BB5BD94652237949")
    
public StringBuilder insert(int offset, double d) {
        addTaint(d);addTaint(offset);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code Object} at the
     * specified {@code offset}. The {@code Object} value is converted to a
     * String according to the rule defined by {@link String#valueOf(Object)}.
     *
     * @param offset
     *            the index to insert at.
     * @param obj
     *            the {@code Object} to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(Object)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.242 -0500", hash_original_method = "61D3E125BF148F03C1F93F887D6D82B6", hash_generated_method = "FB88A32D48655BF1B000CF687A0A5E1E")
    
public StringBuilder insert(int offset, Object obj) {
        addTaint(obj.toString().getTaint());
        addTaint(offset);
        return this;
    }

    /**
     * Inserts the specified string at the specified {@code offset}. If the
     * specified string is null, then the String {@code "null"} is inserted.
     *
     * @param offset
     *            the index to insert at.
     * @param str
     *            the {@code String} to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.245 -0500", hash_original_method = "4CB9FC326C4E78987F03B46DA89B63D1", hash_generated_method = "C765E6E72AE3132F820D4A99E27BB5DC")
    
public StringBuilder insert(int offset, String str) {
        insert0(offset, str);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code char[]} at the
     * specified {@code offset}. The {@code char[]} value is converted to a
     * String according to the rule defined by {@link String#valueOf(char[])}.
     *
     * @param offset
     *            the index to insert at.
     * @param ch
     *            the {@code char[]} to insert.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see String#valueOf(char[])
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.247 -0500", hash_original_method = "9DA55870F4603974121079300CB9220C", hash_generated_method = "D5440A8E10CCBDE365B6DD1208B2F624")
    
public StringBuilder insert(int offset, char[] ch) {
        insert0(offset, ch);
        return this;
    }

    /**
     * Inserts the string representation of the specified subsequence of the
     * {@code char[]} at the specified {@code offset}. The {@code char[]} value
     * is converted to a String according to the rule defined by
     * {@link String#valueOf(char[],int,int)}.
     *
     * @param offset
     *            the index to insert at.
     * @param str
     *            the {@code char[]} to insert.
     * @param strOffset
     *            the inclusive index.
     * @param strLen
     *            the number of characters.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}, or {@code strOffset} and {@code strLen} do
     *             not specify a valid subsequence.
     * @see String#valueOf(char[],int,int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.249 -0500", hash_original_method = "74676FBA295331D75BECD58900BE097F", hash_generated_method = "C817D4366B92ACE52182F85AD59D5CAB")
    
public StringBuilder insert(int offset, char[] str, int strOffset,
            int strLen) {
        insert0(offset, str, strOffset, strLen);
        return this;
    }

    /**
     * Inserts the string representation of the specified {@code CharSequence}
     * at the specified {@code offset}. The {@code CharSequence} is converted
     * to a String as defined by {@link CharSequence#toString()}. If {@code s}
     * is {@code null}, then the String {@code "null"} is inserted.
     *
     * @param offset
     *            the index to insert at.
     * @param s
     *            the {@code CharSequence} to insert.
     * @return this builder.
     * @throws IndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}.
     * @see CharSequence#toString()
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.252 -0500", hash_original_method = "0A4800E098392CF1EA9CC33E7FA664BB", hash_generated_method = "625E8215F22D8F7FC0AED569BB692C26")
    
public StringBuilder insert(int offset, CharSequence s) {
        insert0(offset, s == null ? "null" : s.toString());
        return this;
    }

    /**
     * Inserts the string representation of the specified subsequence of the
     * {@code CharSequence} at the specified {@code offset}. The {@code
     * CharSequence} is converted to a String as defined by
     * {@link CharSequence#subSequence(int, int)}. If the {@code CharSequence}
     * is {@code null}, then the string {@code "null"} is used to determine the
     * subsequence.
     *
     * @param offset
     *            the index to insert at.
     * @param s
     *            the {@code CharSequence} to insert.
     * @param start
     *            the start of the subsequence of the character sequence.
     * @param end
     *            the end of the subsequence of the character sequence.
     * @return this builder.
     * @throws IndexOutOfBoundsException
     *             if {@code offset} is negative or greater than the current
     *             {@code length()}, or {@code start} and {@code end} do not
     *             specify a valid subsequence.
     * @see CharSequence#subSequence(int, int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.254 -0500", hash_original_method = "C80E7B31DC60FBAF173CE4F526E97A54", hash_generated_method = "918EF69E5FA94D4C371DDF236AE13456")
    
public StringBuilder insert(int offset, CharSequence s, int start, int end) {
        insert0(offset, s, start, end);
        return this;
    }

    /**
     * Replaces the specified subsequence in this builder with the specified
     * string.
     *
     * @param start
     *            the inclusive begin index.
     * @param end
     *            the exclusive end index.
     * @param str
     *            the replacement string.
     * @return this builder.
     * @throws StringIndexOutOfBoundsException
     *             if {@code start} is negative, greater than the current
     *             {@code length()} or greater than {@code end}.
     * @throws NullPointerException
     *            if {@code str} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.256 -0500", hash_original_method = "3EE339644717E8959D7BEAA9750FDE03", hash_generated_method = "0F41B9F0A794DA792133C40C5D75BFC3")
    
public StringBuilder replace(int start, int end, String str) {
        replace0(start, end, str);
        return this;
    }

    /**
     * Reverses the order of characters in this builder.
     *
     * @return this buffer.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.259 -0500", hash_original_method = "D5BEA44E320721AFAC8F5C9BC1BCBDE4", hash_generated_method = "750FE538DFFBF83E01F2E82D4AAF23C6")
    
public StringBuilder reverse() {
        reverse0();
        return this;
    }

    /**
     * Returns the contents of this builder.
     *
     * @return the string representation of the data in this builder.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.262 -0500", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "B495614081449F8C08A453388FD8F37A")
    
@Override
    public String toString() {
        /* Note: This method is required to workaround a compiler bug
         * in the RI javac (at least in 1.5.0_06) that will generate a
         * reference to the non-public AbstractStringBuilder if we don't
         * override it here.
         */
        return super.toString();
    }

    /**
     * Reads the state of a {@code StringBuilder} from the passed stream and
     * restores it to this instance.
     *
     * @param in
     *            the stream to read the state from.
     * @throws IOException
     *             if the stream throws it during the read.
     * @throws ClassNotFoundException
     *             if the stream throws it during the read.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.264 -0500", hash_original_method = "2C3CA2755DA5729156EEFA2755095C82", hash_generated_method = "3584495E19EDD6202EC70FCEC799889D")
    
private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        in.defaultReadObject();
        int count = in.readInt();
        char[] value = (char[]) in.readObject();
        set(value, count);
    }

    /**
     * Writes the state of this object to the stream passed.
     *
     * @param out
     *            the stream to write the state to.
     * @throws IOException
     *             if the stream throws it during the write.
     * @serialData {@code int} - the length of this object. {@code char[]} - the
     *             buffer from this object, which may be larger than the length
     *             field.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:33.266 -0500", hash_original_method = "955BAED9D745223A762EA03F9D3C1E25", hash_generated_method = "D1E550090E6BBB897CAC6429B103B177")
    
private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(length());
        out.writeObject(getValue());
    }
}

