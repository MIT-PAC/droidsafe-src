package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

public final class StringBuffer extends AbstractStringBuilder implements Appendable, Serializable, CharSequence {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.038 -0500", hash_original_field = "337C95B1FDC499D5049FB3E7C13B23CE", hash_generated_field = "FC0674932C46ABA4FCCDFE0606287381")

    private static final long serialVersionUID = 3388685877147921107L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.041 -0500", hash_original_field = "BCD371E8115631B09AC41219DD5C15C0", hash_generated_field = "B99DBA28D5BC805935B08D57FFE80361")

    private static final ObjectStreamField[] serialPersistentFields = {
        new ObjectStreamField("count", int.class),
        new ObjectStreamField("shared", boolean.class),
        new ObjectStreamField("value", char[].class),
    };

    /**
     * Constructs a new StringBuffer using the default capacity which is 16.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.043 -0500", hash_original_method = "6484BCA0EF411C515D6EAFFBE43997C3", hash_generated_method = "69ADD4EC850DAA0BC95FE3266726B3FE")
    
public StringBuffer() {
    }

    /**
     * Constructs a new StringBuffer using the specified capacity.
     *
     * @param capacity
     *            the initial capacity.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.047 -0500", hash_original_method = "7B7971D2835EB2D685FF89EC3D85C02A", hash_generated_method = "8CAA87DB79F0EC4C38563D4D1770A0D3")
    
public StringBuffer(int capacity) {
        super(capacity);
    }

    /**
     * Constructs a new StringBuffer containing the characters in the specified
     * string. The capacity of the new buffer will be the length of the
     * {@code String} plus the default capacity.
     *
     * @param string
     *            the string content with which to initialize the new instance.
     * @throws NullPointerException
     *            if {@code string} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.049 -0500", hash_original_method = "505E372B31FD7A37A1258BF28C555BD1", hash_generated_method = "7B365BBE067553F3FE0F70CA346D6DF1")
    
public StringBuffer(String string) {
        super(string);
    }

    /**
     * Constructs a StringBuffer and initializes it with the content from the
     * specified {@code CharSequence}. The capacity of the new buffer will be
     * the length of the {@code CharSequence} plus the default capacity.
     *
     * @param cs
     *            the content to initialize the instance.
     * @throws NullPointerException
     *            if {@code cs} is {@code null}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.052 -0500", hash_original_method = "8B31F280D5DC89D8F89BF293509278C5", hash_generated_method = "BDEE148D02BA5765CEAF19AA1AB377D3")
    
public StringBuffer(CharSequence cs) {
        super(cs.toString());
    }

    /**
     * Adds the string representation of the specified boolean to the end of
     * this StringBuffer.
     * <p>
     * If the argument is {@code true} the string {@code "true"} is appended,
     * otherwise the string {@code "false"} is appended.
     *
     * @param b
     *            the boolean to append.
     * @return this StringBuffer.
     * @see String#valueOf(boolean)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.054 -0500", hash_original_method = "AD3312372D1C20C6FA4349EE546D8C31", hash_generated_method = "5D5448789B272975A2988E62DB673EA0")
    
public StringBuffer append(boolean b) {
        return append(b ? "true" : "false");
    }

    /**
     * Adds the specified character to the end of this buffer.
     *
     * @param ch
     *            the character to append.
     * @return this StringBuffer.
     * @see String#valueOf(char)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.057 -0500", hash_original_method = "CEE54B5A4214CACDA44FA719AFBE18BD", hash_generated_method = "479211C586724C2B02DAEA765B5A2A07")
    
public synchronized StringBuffer append(char ch) {
        append0(ch);
        return this;
    }

    /**
     * Adds the string representation of the specified double to the end of this
     * StringBuffer.
     *
     * @param d
     *            the double to append.
     * @return this StringBuffer.
     * @see String#valueOf(double)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.059 -0500", hash_original_method = "0AFE0A1757F436EAD0779848DAA16349", hash_generated_method = "F6AB23291A5B282DA207B93C0353B068")
    
public StringBuffer append(double d) {
        addTaint(d);
        return this;
    }

    /**
     * Adds the string representation of the specified float to the end of this
     * StringBuffer.
     *
     * @param f
     *            the float to append.
     * @return this StringBuffer.
     * @see String#valueOf(float)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.061 -0500", hash_original_method = "E91CEA6395085A2C805805AEC660F914", hash_generated_method = "7E86911A557B95B7B6AC85986E42C999")
    
public StringBuffer append(float f) {
        addTaint(f);
        return this;
    }

    /**
     * Adds the string representation of the specified integer to the end of
     * this StringBuffer.
     *
     * @param i
     *            the integer to append.
     * @return this StringBuffer.
     * @see String#valueOf(int)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.064 -0500", hash_original_method = "BEA181157FE20523F8DAE95D96DA45D4", hash_generated_method = "7D280E4AD18897171EECE2E55A094B2E")
    
public StringBuffer append(int i) {
        addTaint(i);
        return this;
    }

    /**
     * Adds the string representation of the specified long to the end of this
     * StringBuffer.
     *
     * @param l
     *            the long to append.
     * @return this StringBuffer.
     * @see String#valueOf(long)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.066 -0500", hash_original_method = "83E6088E5FD422B34A78952B80516F81", hash_generated_method = "D02F3B64A279C32A1CC10AD39F39AB60")
    
public StringBuffer append(long l) {
        addTaint(l);
        return this;
    }

    /**
     * Adds the string representation of the specified object to the end of this
     * StringBuffer.
     * <p>
     * If the specified object is {@code null} the string {@code "null"} is
     * appended, otherwise the objects {@code toString} is used to get its
     * string representation.
     *
     * @param obj
     *            the object to append (may be null).
     * @return this StringBuffer.
     * @see String#valueOf(Object)
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.069 -0500", hash_original_method = "2D15CD6872414C1946401A7870801F7E", hash_generated_method = "0680B24696FEFB38714FEC87A351DC5B")
    
public synchronized StringBuffer append(Object obj) {
    append0(obj.toString());
        return this;
    }

    /**
     * Adds the specified string to the end of this buffer.
     * <p>
     * If the specified string is {@code null} the string {@code "null"} is
     * appended, otherwise the contents of the specified string is appended.
     *
     * @param string
     *            the string to append (may be null).
     * @return this StringBuffer.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.071 -0500", hash_original_method = "BA0CFF22AB5EB829F1FAF589162ABBEB", hash_generated_method = "918BB57509315C997E6103AE872DAA7C")
    
public synchronized StringBuffer append(String string) {
        append0(string);
        return this;
    }

    /**
     * Adds the specified StringBuffer to the end of this buffer.
     * <p>
     * If the specified StringBuffer is {@code null} the string {@code "null"}
     * is appended, otherwise the contents of the specified StringBuffer is
     * appended.
     *
     * @param sb
     *            the StringBuffer to append (may be null).
     * @return this StringBuffer.
     *
     * @since 1.4
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.074 -0500", hash_original_method = "F6E1A459EC09255D7DD48512D99C9457", hash_generated_method = "E37E86CF6BC125A770B254F284CB6953")
    
    public synchronized StringBuffer append(StringBuffer sb) {
        append0(sb.getValue(), 0, sb.length());
        return this;
    }
    
    /**
     * Adds the character array to the end of this buffer.
     *
     * @param chars
     *            the character array to append.
     * @return this StringBuffer.
     * @throws NullPointerException
     *            if {@code chars} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.076 -0500", hash_original_method = "711104B80207109E628FE8DD74956179", hash_generated_method = "03D4713F9A09AE1CFF33A93E20B13BCA")
    
public synchronized StringBuffer append(char[] chars) {
        append0(chars);
        return this;
    }

    /**
     * Adds the specified sequence of characters to the end of this buffer.
     *
     * @param chars
     *            the character array to append.
     * @param start
     *            the starting offset.
     * @param length
     *            the number of characters.
     * @return this StringBuffer.
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code length < 0} , {@code start < 0} or {@code start +
     *             length > chars.length}.
     * @throws NullPointerException
     *            if {@code chars} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.078 -0500", hash_original_method = "46001E95C0F59DFED22A324D2D070740", hash_generated_method = "BF273AFD2BD6FD003E3BC80121842413")
    
public synchronized StringBuffer append(char[] chars, int start, int length) {
        append0(chars, start, length);
        return this;
    }

    /**
     * Appends the specified CharSequence to this buffer.
     * <p>
     * If the specified CharSequence is {@code null} the string {@code "null"}
     * is appended, otherwise the contents of the specified CharSequence is
     * appended.
     *
     * @param s
     *            the CharSequence to append.
     * @return this StringBuffer.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.081 -0500", hash_original_method = "2C28D2E65709E046DB9D8E48F9D4C881", hash_generated_method = "CF5F54D37511371BF72B6F64B465B028")
    
    public synchronized StringBuffer append(CharSequence s) {
        append0(s, 0, s.length());
        return this;
    }

    /**
     * Appends the specified subsequence of the CharSequence to this buffer.
     * <p>
     * If the specified CharSequence is {@code null}, then the string {@code
     * "null"} is used to extract a subsequence.
     *
     * @param s
     *            the CharSequence to append.
     * @param start
     *            the inclusive start index.
     * @param end
     *            the exclusive end index.
     * @return this StringBuffer.
     * @throws IndexOutOfBoundsException
     *             if {@code start} or {@code end} are negative, {@code start}
     *             is greater than {@code end} or {@code end} is greater than
     *             the length of {@code s}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.084 -0500", hash_original_method = "C1E3B870A5740951AADEEF0491CD7264", hash_generated_method = "F736447AA6D7242FF8318D00F32A2D4C")
    
    public synchronized StringBuffer append(CharSequence s, int start, int end) {
        append0(s, start, end);
        return this;
    }

    /**
     * Appends the string representation of the specified Unicode code point to
     * the end of this buffer.
     * <p>
     * The code point is converted to a {@code char[]} as defined by
     * {@link Character#toChars(int)}.
     *
     * @param codePoint
     *            the Unicode code point to encode and append.
     * @return this StringBuffer.
     * @see Character#toChars(int)
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.087 -0500", hash_original_method = "4B31A9F498F093ACA181C8BA507E02E7", hash_generated_method = "51B3EB01EF89D31312417A193DAB15E9")
    
    public StringBuffer appendCodePoint(int codePoint) {
        addTaint(codePoint);
        return this;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.090 -0500", hash_original_method = "52E39D47ECD902DE3C84A8ACBB2DE582", hash_generated_method = "26FAB4B9F051634BC64E4723138FC5EF")
    
@Override
    public synchronized char charAt(int index) {
        addTaint(index);
        return getTaintChar();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.092 -0500", hash_original_method = "48A83889A4814C372999BC69DB011FE1", hash_generated_method = "864DE504C086C981981415990BF4A493")
    
@Override
    public synchronized int codePointAt(int index) {
        return super.codePointAt(index);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.095 -0500", hash_original_method = "E2FD7EE4758777A7F8810D08D8C81C5F", hash_generated_method = "CC194F968AE0F80BDB16FC9B4F8B652B")
    
@Override
    public synchronized int codePointBefore(int index) {
        return super.codePointBefore(index);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.097 -0500", hash_original_method = "C17E5B71844DF6A2EACD3D99CBFE136F", hash_generated_method = "E94CFA84BC0F35AB95CEFD4EEDAD8182")
    
@Override
    public synchronized int codePointCount(int beginIndex, int endIndex) {
        return super.codePointCount(beginIndex, endIndex);
    }

    /**
     * Deletes a range of characters.
     *
     * @param start
     *            the offset of the first character.
     * @param end
     *            the offset one past the last character.
     * @return this StringBuffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code start < 0}, {@code start > end} or {@code end >
     *             length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.100 -0500", hash_original_method = "235414C6394F3123BE59FBE1973087EC", hash_generated_method = "A0A7CEC8D23BCA2FF66D7F23CCD8D47A")
    
public synchronized StringBuffer delete(int start, int end) {
        delete0(start, end);
        return this;
    }

    /**
     * Deletes the character at the specified offset.
     *
     * @param location
     *            the offset of the character to delete.
     * @return this StringBuffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code location < 0} or {@code location >= length()}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.102 -0500", hash_original_method = "737D447D9524E38B88FDFD3CE0E844F0", hash_generated_method = "F2B7ACF724054E38903F869AC10500B5")
    
public synchronized StringBuffer deleteCharAt(int location) {
        deleteCharAt0(location);
        return this;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.105 -0500", hash_original_method = "1B87A2C630A8B8AD61E299E2980BE5BA", hash_generated_method = "7461A67DB18CCEE72109B8F670B36E01")
    
@Override
    public synchronized void ensureCapacity(int min) {
        super.ensureCapacity(min);
    }

    /**
     * Copies the requested sequence of characters to the {@code char[]} passed
     * starting at {@code idx}.
     *
     * @param start
     *            the starting offset of characters to copy.
     * @param end
     *            the ending offset of characters to copy.
     * @param buffer
     *            the destination character array.
     * @param idx
     *            the starting offset in the character array.
     * @throws IndexOutOfBoundsException
     *             if {@code start < 0}, {@code end > length()}, {@code start >
     *             end}, {@code index < 0}, {@code end - start > buffer.length -
     *             index}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.107 -0500", hash_original_method = "037A31D5BC34DCBBE5FD8C41FC89B29B", hash_generated_method = "9A1D1BA6AEB664C3D81C70B00DDE6A3B")
    
@Override
    public synchronized void getChars(int start, int end, char[] buffer, int idx) {
        super.getChars(start, end, buffer, idx);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.110 -0500", hash_original_method = "BF7B498FDD44487B77C2BA2659BC8482", hash_generated_method = "71045AFCB34CA14AD1E33C978431E43C")
    
@Override
    public synchronized int indexOf(String subString, int start) {
        return super.indexOf(subString, start);
    }

    /**
     * Inserts the character into this buffer at the specified offset.
     *
     * @param index
     *            the index at which to insert.
     * @param ch
     *            the character to insert.
     * @return this buffer.
     * @throws ArrayIndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.113 -0500", hash_original_method = "CE1956BD7F5F63F118F54E2B606E5A97", hash_generated_method = "7A674EE026F6110E466C3758BCF5001A")
    
public synchronized StringBuffer insert(int index, char ch) {
        insert0(index, ch);
        return this;
    }

    /**
     * Inserts the string representation of the specified boolean into this
     * buffer at the specified offset.
     *
     * @param index
     *            the index at which to insert.
     * @param b
     *            the boolean to insert.
     * @return this buffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.116 -0500", hash_original_method = "162176ED227569BA5BCA4BCD896EB6BD", hash_generated_method = "8A0663796DEAA523B3A44491704958DC")
    
public StringBuffer insert(int index, boolean b) {
        addTaint(index);
        addTaint(b);
        return this;
    }

    /**
     * Inserts the string representation of the specified integer into this
     * buffer at the specified offset.
     *
     * @param index
     *            the index at which to insert.
     * @param i
     *            the integer to insert.
     * @return this buffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.118 -0500", hash_original_method = "5A54C4D4DA42D98D57F22399AE362D5B", hash_generated_method = "219E2E02AE15A517294992BEEEB98F5A")
    
public StringBuffer insert(int index, int i) {
        addTaint(index);
        addTaint(i);
        return this;
    }

    /**
     * Inserts the string representation of the specified long into this buffer
     * at the specified offset.
     *
     * @param index
     *            the index at which to insert.
     * @param l
     *            the long to insert.
     * @return this buffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.120 -0500", hash_original_method = "5D8E4B66E2DC4C0F0AE2C3587B4A421D", hash_generated_method = "07E69C4F0157179849617A1E3687C2FD")
    
public StringBuffer insert(int index, long l) {
        addTaint(l);
        addTaint(index);
        return this;
    }

    /**
     * Inserts the string representation of the specified into this buffer
     * double at the specified offset.
     *
     * @param index
     *            the index at which to insert.
     * @param d
     *            the double to insert.
     * @return this buffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.122 -0500", hash_original_method = "6F91201558DE19CA8BB7D7C8218AE116", hash_generated_method = "C1453933B6DCD4B8D289D21A9ACAC6E5")
    
public StringBuffer insert(int index, double d) {
        addTaint(d);
        addTaint(index);
        return this;
    }

    /**
     * Inserts the string representation of the specified float into this buffer
     * at the specified offset.
     *
     * @param index
     *            the index at which to insert.
     * @param f
     *            the float to insert.
     * @return this buffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.124 -0500", hash_original_method = "F7E2A65D054608BBB689E2070378B818", hash_generated_method = "96D3E5CFDD6B54015A707CF978492C04")
    
public StringBuffer insert(int index, float f) {
        addTaint(f);
        addTaint(index);
        return this;
    }

    /**
     * Inserts the string representation of the specified object into this
     * buffer at the specified offset.
     * <p>
     * If the specified object is {@code null}, the string {@code "null"} is
     * inserted, otherwise the objects {@code toString} method is used to get
     * its string representation.
     *
     * @param index
     *            the index at which to insert.
     * @param obj
     *            the object to insert (may be null).
     * @return this buffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.127 -0500", hash_original_method = "474B289AA5CB68BD472602D89AE62101", hash_generated_method = "1DCEC35B84C61CF75282A56269007DC4")
    
public StringBuffer insert(int index, Object obj) {
        addTaint(index);
        addTaint(obj.toString().getTaint());
        return this;
    }

    /**
     * Inserts the string into this buffer at the specified offset.
     * <p>
     * If the specified string is {@code null}, the string {@code "null"} is
     * inserted, otherwise the contents of the string is inserted.
     *
     * @param index
     *            the index at which to insert.
     * @param string
     *            the string to insert (may be null).
     * @return this buffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.130 -0500", hash_original_method = "5591CE5A2850A371416D9B24730643D5", hash_generated_method = "81005FFA63B907E35CDCD373C80A1DFE")
    
public synchronized StringBuffer insert(int index, String string) {
        insert0(index, string);
        return this;
    }

    /**
     * Inserts the character array into this buffer at the specified offset.
     *
     * @param index
     *            the index at which to insert.
     * @param chars
     *            the character array to insert.
     * @return this buffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     * @throws NullPointerException
     *            if {@code chars} is {@code null}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.132 -0500", hash_original_method = "1121EB69A68046BEB419CFEB2B6021C8", hash_generated_method = "55C434B2E76B6614FDCA0DC7762D91F2")
    
public synchronized StringBuffer insert(int index, char[] chars) {
        insert0(index, chars);
        return this;
    }

    /**
     * Inserts the specified subsequence of characters into this buffer at the
     * specified index.
     *
     * @param index
     *            the index at which to insert.
     * @param chars
     *            the character array to insert.
     * @param start
     *            the starting offset.
     * @param length
     *            the number of characters.
     * @return this buffer.
     * @throws NullPointerException
     *             if {@code chars} is {@code null}.
     * @throws StringIndexOutOfBoundsException
     *             if {@code length < 0}, {@code start < 0}, {@code start +
     *             length > chars.length}, {@code index < 0} or {@code index >
     *             length()}
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.135 -0500", hash_original_method = "E3508FF8AABC28C56148C557B4E38064", hash_generated_method = "7253AF807017D803A7677EF0EDA83AD0")
    
public synchronized StringBuffer insert(int index, char[] chars, int start, int length) {
        insert0(index, chars, start, length);
        return this;
    }

    /**
     * Inserts the specified CharSequence into this buffer at the specified
     * index.
     * <p>
     * If the specified CharSequence is {@code null}, the string {@code "null"}
     * is inserted, otherwise the contents of the CharSequence.
     *
     * @param index
     *            The index at which to insert.
     * @param s
     *            The char sequence to insert.
     * @return this buffer.
     * @throws IndexOutOfBoundsException
     *             if {@code index < 0} or {@code index > length()}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.137 -0500", hash_original_method = "313D5F48F5D2BFD8C8C3947312396740", hash_generated_method = "4ACA4BD1DF55AFCC3240809DC91469C6")
    
    public synchronized StringBuffer insert(int index, CharSequence s) {
        addTaint(s.toString().getTaint());
        addTaint(index);
        return this;
    }

    /**
     * Inserts the specified subsequence into this buffer at the specified
     * index.
     * <p>
     * If the specified CharSequence is {@code null}, the string {@code "null"}
     * is inserted, otherwise the contents of the CharSequence.
     *
     * @param index
     *            The index at which to insert.
     * @param s
     *            The char sequence to insert.
     * @param start
     *            The inclusive start index in the char sequence.
     * @param end
     *            The exclusive end index in the char sequence.
     * @return this buffer.
     * @throws IndexOutOfBoundsException
     *             if {@code index} is negative or greater than the current
     *             length, {@code start} or {@code end} are negative, {@code
     *             start} is greater than {@code end} or {@code end} is greater
     *             than the length of {@code s}.
     * @since 1.5
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.139 -0500", hash_original_method = "BBD93AF1317886AF1B5FFE12E83BEB02", hash_generated_method = "77C89CAD86715F09EB636A8B26DD82B8")
    
public synchronized StringBuffer insert(int index, CharSequence s,
            int start, int end) {
        insert0(index, s, start, end);
        return this;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.142 -0500", hash_original_method = "39077D4F93550F62A3B71E5EF9B37555", hash_generated_method = "A5D138F0AE51E855A7CD8DE165ED1FF8")
    
@Override
    public synchronized int lastIndexOf(String subString, int start) {
        return super.lastIndexOf(subString, start);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.145 -0500", hash_original_method = "C8ABB25D4960EE5BE30D58FFF30054AF", hash_generated_method = "779FF1D1009C2113B93E927B049B0DF2")
    
@Override
    public synchronized int offsetByCodePoints(int index, int codePointOffset) {
        return super.offsetByCodePoints(index, codePointOffset);
    }

    /**
     * Replaces the characters in the specified range with the contents of the
     * specified string.
     *
     * @param start
     *            the inclusive begin index.
     * @param end
     *            the exclusive end index.
     * @param string
     *            the string that will replace the contents in the range.
     * @return this buffer.
     * @throws StringIndexOutOfBoundsException
     *             if {@code start} or {@code end} are negative, {@code start}
     *             is greater than {@code end} or {@code end} is greater than
     *             the length of {@code s}.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.147 -0500", hash_original_method = "7F162AB48D360AADEB1B9DD8B238BF48", hash_generated_method = "60D0A2AC6B5C448235A55D6721DE1DB9")
    
public synchronized StringBuffer replace(int start, int end, String string) {
        replace0(start, end, string);
        return this;
    }

    /**
     * Reverses the order of characters in this buffer.
     *
     * @return this buffer.
     */
    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.149 -0500", hash_original_method = "098653D6B0F25929404FF528DA5234A0", hash_generated_method = "41813C68DF13445F7AE1E7B77D1F256D")
    
public synchronized StringBuffer reverse() {
        reverse0();
        return this;
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.153 -0500", hash_original_method = "5E8E344457E07DCAD9D3AB0618D1D4EE", hash_generated_method = "AF499A2A33AF6CDF77B7FE0D2F4F7363")
    
@Override
    public synchronized void setCharAt(int index, char ch) {
        super.setCharAt(index, ch);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.155 -0500", hash_original_method = "384C5D925F648A6C0E5C9532F172E2E9", hash_generated_method = "7BB60A3B3EEDEFEE6B324D309879F75D")
    
@Override
    public synchronized void setLength(int length) {
        super.setLength(length);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.158 -0500", hash_original_method = "A9B709A81F57A675D3A25B35A00D1C6F", hash_generated_method = "58B174A11B64D033BEE8CE3854346CFE")
    
@Override
    public synchronized CharSequence subSequence(int start, int end) {
        return super.substring(start, end);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.160 -0500", hash_original_method = "9DB8630678DB6396B8F68E9EC4290146", hash_generated_method = "2DBBC33EBD2A4E91C83B7472CBE82B8D")
    
@Override
    public synchronized String substring(int start) {
        return super.substring(start);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.163 -0500", hash_original_method = "8F6436CA8EA2D690A9089AF2007B25C6", hash_generated_method = "E6668EB5960D238AB759F9AA0BF22B72")
    
@Override
    public synchronized String substring(int start, int end) {
        return super.substring(start, end);
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.166 -0500", hash_original_method = "C92C5C24967E99B8B02E357BFAE9005B", hash_generated_method = "E32EB3A5772E47254E0018220CB3E7DC")
    
@Override
    public synchronized String toString() {
        return super.toString();
    }

    @DSComment("From safe class list")
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.168 -0500", hash_original_method = "596F21FA7699F8C3786ED3A552D7371B", hash_generated_method = "0FE7A1736121032DEEAAB327E64B2FAC")
    
@Override
    public synchronized void trimToSize() {
        super.trimToSize();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.171 -0500", hash_original_method = "1BC53113CC0063A57FC602AA53299ECD", hash_generated_method = "527366FA4E1C2D0442B6D8734C4FD80A")
    
private synchronized void writeObject(ObjectOutputStream out)
            throws IOException {
        ObjectOutputStream.PutField fields = out.putFields();
        fields.put("count", length());
        fields.put("shared", false);
        fields.put("value", getValue());
        out.writeFields();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:18.173 -0500", hash_original_method = "9B6E3FB5AF7FD24ED316678958241184", hash_generated_method = "AC7A443A026FB65B591ED989CDC16D2F")
    
private void readObject(ObjectInputStream in) throws IOException,
            ClassNotFoundException {
        ObjectInputStream.GetField fields = in.readFields();
        int count = fields.get("count", 0);
        char[] value = (char[]) fields.get("value", null);
        set(value, count);


    }
}

