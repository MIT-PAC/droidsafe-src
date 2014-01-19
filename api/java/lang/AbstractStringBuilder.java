package java.lang;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.io.InvalidObjectException;
import java.util.Arrays;

import libcore.util.EmptyArray;

abstract class AbstractStringBuilder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.701 -0500", hash_original_field = "F46BD29C6E17578C395874054BC81C6E", hash_generated_field = "737C5532807A143D11A79A7148513E52")

    static final int INITIAL_CAPACITY = 16;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.704 -0500", hash_original_field = "CA3CEF12FBB39E8368D4DC357E1B2764", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")

    private char[] value;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.706 -0500", hash_original_field = "B83BF7ED7F5719DA923E1BC0AC69952B", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.708 -0500", hash_original_field = "34293CAAA37E17C8FA8487D55D95082F", hash_generated_field = "208F8AA93D19EFFECF64F85E89AD016E")

    private boolean shared;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.718 -0500", hash_original_method = "C4ACD0AC259F7EA41C20592CA02F17C8", hash_generated_method = "C4ACD0AC259F7EA41C20592CA02F17C8")
    
AbstractStringBuilder() {
        value = new char[INITIAL_CAPACITY];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.721 -0500", hash_original_method = "18E3A9BF20D4EDF142A00D9C9EE6DE65", hash_generated_method = "18E3A9BF20D4EDF142A00D9C9EE6DE65")
    
AbstractStringBuilder(int capacity) {
        if (capacity < 0) {
            throw new NegativeArraySizeException();
        }
        value = new char[capacity];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.724 -0500", hash_original_method = "0C09A579E41A9FFDC9603418777FC2FA", hash_generated_method = "0C09A579E41A9FFDC9603418777FC2FA")
    
AbstractStringBuilder(String string) {
        count = string.length();
        shared = false;
        value = new char[count + INITIAL_CAPACITY];
        string._getChars(0, count, value, 0);
    }

    /*
     * Returns the character array.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.711 -0500", hash_original_method = "CA36BDE7C01AB0B5E4CF30DF6E006183", hash_generated_method = "2BE9E3503687526A3D670895B26B03C2")
    
final char[] getValue() {
        return value;
    }

    /*
     * Returns the underlying buffer and sets the shared flag.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.713 -0500", hash_original_method = "BF651BBA1175DAD67C837DDC7CF4E9BB", hash_generated_method = "3E0B77C959AFAA2A6E95669BF1F6B2A2")
    
final char[] shareValue() {
        shared = true;
        return value;
    }

    /*
     * Restores internal state after deserialization.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.716 -0500", hash_original_method = "8C798CD9819DA5BF9BBE1043F1031580", hash_generated_method = "6CD3ACFEEACBD1C83FFFEDE6EDA4687C")
    
final void set(char[] val, int len) throws InvalidObjectException {
        if (val == null) {
            val = EmptyArray.CHAR;
        }
        if (val.length < len) {
            throw new InvalidObjectException("count out of range");
        }

        shared = false;
        value = val;
        count = len;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.727 -0500", hash_original_method = "8DE386E9EA04BE56519C8A6264F91502", hash_generated_method = "62F407B7E75F75DE3E6791DD28A3852F")
    
private void enlargeBuffer(int min) {
        int newCount = ((value.length >> 1) + value.length) + 2;
        char[] newData = new char[min > newCount ? min : newCount];
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.729 -0500", hash_original_method = "BE4C961EA91A0D5BF81DD6DF988583CA", hash_generated_method = "0026E8F7271FCB4540320659CA2A9DA7")
    
final void appendNull() {
        int newCount = count + 4;
        if (newCount > value.length) {
            enlargeBuffer(newCount);
        }
        value[count++] = 'n';
        value[count++] = 'u';
        value[count++] = 'l';
        value[count++] = 'l';
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.731 -0500", hash_original_method = "8C85C9AFF9EA1123A22A14B3A5C3C022", hash_generated_method = "A6667FA89203D112B27C7D329C3CCDF5")
    
final void append0(char[] chars) {
        int newCount = count + chars.length;
        if (newCount > value.length) {
            enlargeBuffer(newCount);
        }
        System.arraycopy(chars, 0, value, count, chars.length);
        count = newCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.734 -0500", hash_original_method = "7BE8867E430B01B44EC74C0F78249D07", hash_generated_method = "85BE030D378734CCD5485E78B713DD3D")
    
final void append0(char[] chars, int offset, int length) {
        Arrays.checkOffsetAndCount(chars.length, offset, length);
        int newCount = count + length;
        if (newCount > value.length) {
            enlargeBuffer(newCount);
        }
        System.arraycopy(chars, offset, value, count, length);
        count = newCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.736 -0500", hash_original_method = "ECBEE238E1E86380FF7C7052710927A2", hash_generated_method = "F2DDEA2FE5C77E4F2BC68D7E15627FC4")
    
final void append0(char ch) {
        if (count == value.length) {
            enlargeBuffer(count + 1);
        }
        value[count++] = ch;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.739 -0500", hash_original_method = "B96D71BE07A8651AC5DD35DFB1E0B9E9", hash_generated_method = "C954915CE23D2CC547AA2CB578D414C5")
    
final void append0(String string) {
        if (string == null) {
            appendNull();
            return;
        }
        int length = string.length();
        int newCount = count + length;
        if (newCount > value.length) {
            enlargeBuffer(newCount);
        }
        string._getChars(0, length, value, count);
        count = newCount;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.743 -0500", hash_original_method = "C43881C5821BA2B06BD7E52CBFC700AF", hash_generated_method = "A2934907B51AA94AB82681F6BB94AA6C")
    
final void append0(CharSequence s, int start, int end) {
        if (s == null) {
            s = "null";
        }
        if ((start | end) < 0 || start > end || end > s.length()) {
            throw new IndexOutOfBoundsException();
        }

        int length = end - start;
        int newCount = count + length;
        if (newCount > value.length) {
            enlargeBuffer(newCount);
        } else if (shared) {
            value = value.clone();
            shared = false;
        }

        if (s instanceof String) {
            ((String) s)._getChars(start, end, value, count);
        } else if (s instanceof AbstractStringBuilder) {
            AbstractStringBuilder other = (AbstractStringBuilder) s;
            System.arraycopy(other.value, start, value, count, length);
        } else {
            int j = count; // Destination index.
            for (int i = start; i < end; i++) {
                value[j++] = s.charAt(i);
            }
        }

        this.count = newCount;
    }

    /**
     * Returns the number of characters that can be held without growing.
     *
     * @return the capacity
     * @see #ensureCapacity
     * @see #length
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.745 -0500", hash_original_method = "4EDD82B1AA77527A58B2DDD935211532", hash_generated_method = "2A8E845FAB75D5F75E0F9358D232401F")
    
public int capacity() {
        return value.length;
    }

    /**
     * Retrieves the character at the {@code index}.
     *
     * @param index
     *            the index of the character to retrieve.
     * @return the char value.
     * @throws IndexOutOfBoundsException
     *             if {@code index} is negative or greater than or equal to the
     *             current {@link #length()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.748 -0500", hash_original_method = "447DEA66ED097ABAE0E9735DA732DBDF", hash_generated_method = "FAC07C09F852D642353F0EF74A2A34E0")
    
public char charAt(int index) {
        if (index < 0 || index >= count) {
            throw indexAndLength(index);
        }
        return value[index];
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.751 -0500", hash_original_method = "FC4FB8D4DBB369ED29C378FB60B58B5D", hash_generated_method = "7B98068F17E8D428A6C713A5A4392DBD")
    
private StringIndexOutOfBoundsException indexAndLength(int index) {
        throw new StringIndexOutOfBoundsException(count, index);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.753 -0500", hash_original_method = "ABFB3D9F0C982EE0B945F30A8DA651B2", hash_generated_method = "EB4B9181C1076BCCFC1077E84155E225")
    
private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        throw new StringIndexOutOfBoundsException(count, start, end - start);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.756 -0500", hash_original_method = "19BE941D07BAB030F14923AC484F383F", hash_generated_method = "7295AD2FB7044894CDFDF9B97A609EE0")
    
final void delete0(int start, int end) {
        if (start >= 0) {
            if (end > count) {
                end = count;
            }
            if (end == start) {
                return;
            }
            if (end > start) {
                int length = count - end;
                if (length >= 0) {
                    if (!shared) {
                        System.arraycopy(value, end, value, start, length);
                    } else {
                        char[] newData = new char[value.length];
                        System.arraycopy(value, 0, newData, 0, start);
                        System.arraycopy(value, end, newData, start, length);
                        value = newData;
                        shared = false;
                    }
                }
                count -= end - start;
                return;
            }
        }
        throw startEndAndLength(start, end);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.758 -0500", hash_original_method = "54D305E0C27E04AE130B9F0D173AF3D5", hash_generated_method = "544AFCD3A08DBE245A2B212D8ADC4F53")
    
final void deleteCharAt0(int index) {
        if (index < 0 || index >= count) {
            throw indexAndLength(index);
        }
        int length = count - index - 1;
        if (length > 0) {
            if (!shared) {
                System.arraycopy(value, index + 1, value, index, length);
            } else {
                char[] newData = new char[value.length];
                System.arraycopy(value, 0, newData, 0, index);
                System.arraycopy(value, index + 1, newData, index, length);
                value = newData;
                shared = false;
            }
        }
        count--;
    }

    /**
     * Ensures that this object has a minimum capacity available before
     * requiring the internal buffer to be enlarged. The general policy of this
     * method is that if the {@code minimumCapacity} is larger than the current
     * {@link #capacity()}, then the capacity will be increased to the largest
     * value of either the {@code minimumCapacity} or the current capacity
     * multiplied by two plus two. Although this is the general policy, there is
     * no guarantee that the capacity will change.
     *
     * @param min
     *            the new minimum capacity to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.761 -0500", hash_original_method = "DB245C34644491EEEAB0523333BD6692", hash_generated_method = "42490A7AFC6A57F55CB7D84C7093B2E9")
    
public void ensureCapacity(int min) {
        if (min > value.length) {
            int ourMin = value.length*2 + 2;
            enlargeBuffer(Math.max(ourMin, min));
        }
    }

    /**
     * Copies the requested sequence of characters into {@code dst} passed
     * starting at {@code dst}.
     *
     * @param start
     *            the inclusive start index of the characters to copy.
     * @param end
     *            the exclusive end index of the characters to copy.
     * @param dst
     *            the {@code char[]} to copy the characters to.
     * @param dstStart
     *            the inclusive start index of {@code dst} to begin copying to.
     * @throws IndexOutOfBoundsException
     *             if the {@code start} is negative, the {@code dstStart} is
     *             negative, the {@code start} is greater than {@code end}, the
     *             {@code end} is greater than the current {@link #length()} or
     *             {@code dstStart + end - begin} is greater than
     *             {@code dst.length}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.764 -0500", hash_original_method = "AE7F72EED3837594CFBBCCC4060D7909", hash_generated_method = "E3BB1927CAAB08FF737445C26081F5DD")
    
public void getChars(int start, int end, char[] dst, int dstStart) {
        if (start > count || end > count || start > end) {
            throw startEndAndLength(start, end);
        }
        System.arraycopy(value, start, dst, dstStart, end - start);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.766 -0500", hash_original_method = "93FE28F62EFBAB9F8EBF9F9ADC8E87C8", hash_generated_method = "242C508258718C9D9F50007F4511FE4C")
    
final void insert0(int index, char[] chars) {
        if (index < 0 || index > count) {
            throw indexAndLength(index);
        }
        if (chars.length != 0) {
            move(chars.length, index);
            System.arraycopy(chars, 0, value, index, chars.length);
            count += chars.length;
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.769 -0500", hash_original_method = "D46FA7C87DEEBA750439C9564B3FB7FE", hash_generated_method = "8B7A403365079BE883D31B0B79020802")
    
final void insert0(int index, char[] chars, int start, int length) {
        if (index >= 0 && index <= count) {
            // start + length could overflow, start/length maybe MaxInt
            if (start >= 0 && length >= 0 && length <= chars.length - start) {
                if (length != 0) {
                    move(length, index);
                    System.arraycopy(chars, start, value, index, length);
                    count += length;
                }
                return;
            }
        }
        throw new StringIndexOutOfBoundsException("this.length=" + count
                + "; index=" + index + "; chars.length=" + chars.length
                + "; start=" + start + "; length=" + length);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.772 -0500", hash_original_method = "20DD23A1E6916CB9CC20932D676C3164", hash_generated_method = "73BB8505ED9484329723241FFAD56DF2")
    
final void insert0(int index, char ch) {
        if (index < 0 || index > count) {
            // RI compatible exception type
            throw new ArrayIndexOutOfBoundsException(count, index);
        }
        move(1, index);
        value[index] = ch;
        count++;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.775 -0500", hash_original_method = "9E8CB9B48D87CB2577EC00CC04D06833", hash_generated_method = "76DE473778E46B1CA6569CB2B850870C")
    
final void insert0(int index, String string) {
        if (index >= 0 && index <= count) {
            if (string == null) {
                string = "null";
            }
            int min = string.length();
            if (min != 0) {
                move(min, index);
                string._getChars(0, min, value, index);
                count += min;
            }
        } else {
            throw indexAndLength(index);
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.777 -0500", hash_original_method = "10AE187E8F37FB4E725DAC6B12ECB82F", hash_generated_method = "A4F5FAEA0E39234006556600C0008CB6")
    
final void insert0(int index, CharSequence s, int start, int end) {
        if (s == null) {
            s = "null";
        }
        if ((index | start | end) < 0 || index > count || start > end || end > s.length()) {
            throw new IndexOutOfBoundsException();
        }
        insert0(index, s.subSequence(start, end).toString());
    }

    /**
     * The current length.
     *
     * @return the number of characters contained in this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.779 -0500", hash_original_method = "A4F75F4D0C7ABF3196500E489B73A8D4", hash_generated_method = "1C409EC5A63808531030BD45DA1B15CF")
    
public int length() {
        return count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.782 -0500", hash_original_method = "E2C445AFFEE441B211B71B3E0E3E89EA", hash_generated_method = "9526DADBE0783B7CB28D7284CA19588D")
    
private void move(int size, int index) {
        int newCount;
        if (value.length - count >= size) {
            if (!shared) {
                // index == count case is no-op
                System.arraycopy(value, index, value, index + size, count - index);
                return;
            }
            newCount = value.length;
        } else {
            newCount = Math.max(count + size, value.length*2 + 2);
        }

        char[] newData = new char[newCount];
        System.arraycopy(value, 0, newData, 0, index);
        // index == count case is no-op
        System.arraycopy(value, index, newData, index + size, count - index);
        value = newData;
        shared = false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.786 -0500", hash_original_method = "467233E9D0CCB909364F18BB14890489", hash_generated_method = "53AEE84C0A111C22ABED1BD30476DDCA")
    
final void replace0(int start, int end, String string) {
        if (start >= 0) {
            if (end > count) {
                end = count;
            }
            if (end > start) {
                int stringLength = string.length();
                int diff = end - start - stringLength;
                if (diff > 0) { // replacing with fewer characters
                    if (!shared) {
                        // index == count case is no-op
                        System.arraycopy(value, end, value, start
                                + stringLength, count - end);
                    } else {
                        char[] newData = new char[value.length];
                        System.arraycopy(value, 0, newData, 0, start);
                        // index == count case is no-op
                        System.arraycopy(value, end, newData, start
                                + stringLength, count - end);
                        value = newData;
                        shared = false;
                    }
                } else if (diff < 0) {
                    // replacing with more characters...need some room
                    move(-diff, end);
                } else if (shared) {
                    value = value.clone();
                    shared = false;
                }
                string._getChars(0, stringLength, value, start);
                count -= diff;
                return;
            }
            if (start == end) {
                if (string == null) {
                    throw new NullPointerException();
                }
                insert0(start, string);
                return;
            }
        }
        throw startEndAndLength(start, end);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.789 -0500", hash_original_method = "227A175682657414C42D64433DAB4FBA", hash_generated_method = "B66ABB11CFAE4D2D0EAF38D8AC9E23F4")
    
final void reverse0() {
        if (count < 2) {
            return;
        }
        if (!shared) {
            int end = count - 1;
            char frontHigh = value[0];
            char endLow = value[end];
            boolean allowFrontSur = true, allowEndSur = true;
            for (int i = 0, mid = count / 2; i < mid; i++, --end) {
                char frontLow = value[i + 1];
                char endHigh = value[end - 1];
                boolean surAtFront = allowFrontSur && frontLow >= 0xdc00
                        && frontLow <= 0xdfff && frontHigh >= 0xd800
                        && frontHigh <= 0xdbff;
                if (surAtFront && (count < 3)) {
                    return;
                }
                boolean surAtEnd = allowEndSur && endHigh >= 0xd800
                        && endHigh <= 0xdbff && endLow >= 0xdc00
                        && endLow <= 0xdfff;
                allowFrontSur = allowEndSur = true;
                if (surAtFront == surAtEnd) {
                    if (surAtFront) {
                        // both surrogates
                        value[end] = frontLow;
                        value[end - 1] = frontHigh;
                        value[i] = endHigh;
                        value[i + 1] = endLow;
                        frontHigh = value[i + 2];
                        endLow = value[end - 2];
                        i++;
                        end--;
                    } else {
                        // neither surrogates
                        value[end] = frontHigh;
                        value[i] = endLow;
                        frontHigh = frontLow;
                        endLow = endHigh;
                    }
                } else {
                    if (surAtFront) {
                        // surrogate only at the front
                        value[end] = frontLow;
                        value[i] = endLow;
                        endLow = endHigh;
                        allowFrontSur = false;
                    } else {
                        // surrogate only at the end
                        value[end] = frontHigh;
                        value[i] = endHigh;
                        frontHigh = frontLow;
                        allowEndSur = false;
                    }
                }
            }
            if ((count & 1) == 1 && (!allowFrontSur || !allowEndSur)) {
                value[end] = allowFrontSur ? endLow : frontHigh;
            }
        } else {
            char[] newData = new char[value.length];
            for (int i = 0, end = count; i < count; i++) {
                char high = value[i];
                if ((i + 1) < count && high >= 0xd800 && high <= 0xdbff) {
                    char low = value[i + 1];
                    if (low >= 0xdc00 && low <= 0xdfff) {
                        newData[--end] = low;
                        i++;
                    }
                }
                newData[--end] = high;
            }
            value = newData;
            shared = false;
        }
    }

    /**
     * Sets the character at the {@code index}.
     *
     * @param index
     *            the zero-based index of the character to replace.
     * @param ch
     *            the character to set.
     * @throws IndexOutOfBoundsException
     *             if {@code index} is negative or greater than or equal to the
     *             current {@link #length()}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.792 -0500", hash_original_method = "5EFF2E769F54F3F7450C4FCC35538F65", hash_generated_method = "F067C6081462E0F84A1EDCC6EEF7313A")
    
public void setCharAt(int index, char ch) {
        if (index < 0 || index >= count) {
            throw indexAndLength(index);
        }
        if (shared) {
            value = value.clone();
            shared = false;
        }
        value[index] = ch;
    }

    /**
     * Sets the current length to a new value. If the new length is larger than
     * the current length, then the new characters at the end of this object
     * will contain the {@code char} value of {@code \u0000}.
     *
     * @param length
     *            the new length of this StringBuffer.
     * @exception IndexOutOfBoundsException
     *                if {@code length < 0}.
     * @see #length
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.795 -0500", hash_original_method = "CCD67F72D75D83378F17335F6F9DC00A", hash_generated_method = "C5DDC62D70F97D21489DAA2768EA566A")
    
public void setLength(int length) {
        if (length < 0) {
            throw new StringIndexOutOfBoundsException("length < 0: " + length);
        }
        if (length > value.length) {
            enlargeBuffer(length);
        } else {
            if (shared) {
                char[] newData = new char[value.length];
                System.arraycopy(value, 0, newData, 0, count);
                value = newData;
                shared = false;
            } else {
                if (count < length) {
                    Arrays.fill(value, count, length, (char) 0);
                }
            }
        }
        count = length;
    }

    /**
     * Returns the String value of the subsequence from the {@code start} index
     * to the current end.
     *
     * @param start
     *            the inclusive start index to begin the subsequence.
     * @return a String containing the subsequence.
     * @throws StringIndexOutOfBoundsException
     *             if {@code start} is negative or greater than the current
     *             {@link #length()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.798 -0500", hash_original_method = "1708C6B44328EC2FA5364A52800D811B", hash_generated_method = "7464E15E936DE83D60F39D0931579A21")
    
public String substring(int start) {
        if (start >= 0 && start <= count) {
            if (start == count) {
                return "";
            }

            // Remove String sharing for more performance
            return new String(value, start, count - start);
        }
        throw indexAndLength(start);
    }

    /**
     * Returns the String value of the subsequence from the {@code start} index
     * to the {@code end} index.
     *
     * @param start
     *            the inclusive start index to begin the subsequence.
     * @param end
     *            the exclusive end index to end the subsequence.
     * @return a String containing the subsequence.
     * @throws StringIndexOutOfBoundsException
     *             if {@code start} is negative, greater than {@code end} or if
     *             {@code end} is greater than the current {@link #length()}.
     */
    @DSSink({DSSinkKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.801 -0500", hash_original_method = "7121FB14814A84CA4ADE1E9CCF3D54F6", hash_generated_method = "51605E837F8A436C0F718178ED9E3C0E")
    
public String substring(int start, int end) {
        if (start >= 0 && start <= end && end <= count) {
            if (start == end) {
                return "";
            }

            // Remove String sharing for more performance
            return new String(value, start, end - start);
        }
        throw startEndAndLength(start, end);
    }

    /**
     * Returns the current String representation.
     *
     * @return a String containing the characters in this instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.803 -0500", hash_original_method = "F5CABA8208B35CC620F77C4ED2D48018", hash_generated_method = "7366ED5FE46D69DF533B9A2E6EA78195")
    
@Override
    public String toString() {
        if (count == 0) {
            return "";
        }
        // Optimize String sharing for more performance
        int wasted = value.length - count;
        if (wasted >= 256
                || (wasted >= INITIAL_CAPACITY && wasted >= (count >> 1))) {
            return new String(value, 0, count);
        }
        shared = true;
        return new String(0, count, value);
    }

    /**
     * Returns a {@code CharSequence} of the subsequence from the {@code start}
     * index to the {@code end} index.
     *
     * @param start
     *            the inclusive start index to begin the subsequence.
     * @param end
     *            the exclusive end index to end the subsequence.
     * @return a CharSequence containing the subsequence.
     * @throws IndexOutOfBoundsException
     *             if {@code start} is negative, greater than {@code end} or if
     *             {@code end} is greater than the current {@link #length()}.
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.806 -0500", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "31F89698891865DDF37976A5038C7055")
    
public CharSequence subSequence(int start, int end) {
        return substring(start, end);
    }

    /**
     * Searches for the first index of the specified character. The search for
     * the character starts at the beginning and moves towards the end.
     *
     * @param string
     *            the string to find.
     * @return the index of the specified character, -1 if the character isn't
     *         found.
     * @see #lastIndexOf(String)
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.808 -0500", hash_original_method = "7103B0EDA0D88809AB4D74CA424F106F", hash_generated_method = "0B7BA8FD2687C7E3732941870AE959F1")
    
public int indexOf(String string) {
        return indexOf(string, 0);
    }

    /**
     * Searches for the index of the specified character. The search for the
     * character starts at the specified offset and moves towards the end.
     *
     * @param subString
     *            the string to find.
     * @param start
     *            the starting offset.
     * @return the index of the specified character, -1 if the character isn't
     *         found
     * @see #lastIndexOf(String,int)
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.811 -0500", hash_original_method = "58EF09653819A20604D2729AAEA1E73D", hash_generated_method = "C87E0A918200362DCA05AAF69DC212CC")
    
public int indexOf(String subString, int start) {
        if (start < 0) {
            start = 0;
        }
        int subCount = subString.length();
        if (subCount > 0) {
            if (subCount + start > count) {
                return -1;
            }
            // TODO optimize charAt to direct array access
            char firstChar = subString.charAt(0);
            while (true) {
                int i = start;
                boolean found = false;
                for (; i < count; i++) {
                    if (value[i] == firstChar) {
                        found = true;
                        break;
                    }
                }
                if (!found || subCount + i > count) {
                    return -1; // handles subCount > count || start >= count
                }
                int o1 = i, o2 = 0;
                while (++o2 < subCount && value[++o1] == subString.charAt(o2)) {
                    // Intentionally empty
                }
                if (o2 == subCount) {
                    return i;
                }
                start = i + 1;
            }
        }
        return (start < count || start == 0) ? start : count;
    }

    /**
     * Searches for the last index of the specified character. The search for
     * the character starts at the end and moves towards the beginning.
     *
     * @param string
     *            the string to find.
     * @return the index of the specified character, -1 if the character isn't
     *         found.
     * @throws NullPointerException
     *             if {@code string} is {@code null}.
     * @see String#lastIndexOf(java.lang.String)
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.814 -0500", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "2AEEDCEF5FCA40B4012FD7194CB02C0E")
    
public int lastIndexOf(String string) {
        return lastIndexOf(string, count);
    }

    /**
     * Searches for the index of the specified character. The search for the
     * character starts at the specified offset and moves towards the beginning.
     *
     * @param subString
     *            the string to find.
     * @param start
     *            the starting offset.
     * @return the index of the specified character, -1 if the character isn't
     *         found.
     * @throws NullPointerException
     *             if {@code subString} is {@code null}.
     * @see String#lastIndexOf(String,int)
     * @since 1.4
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.817 -0500", hash_original_method = "7130CA0E46A667075374433A3B5D2D85", hash_generated_method = "C3B932323D38DDFF2F46EAA9B5DA6CB9")
    
public int lastIndexOf(String subString, int start) {
        int subCount = subString.length();
        if (subCount <= count && start >= 0) {
            if (subCount > 0) {
                if (start > count - subCount) {
                    start = count - subCount; // count and subCount are both
                }
                // >= 1
                // TODO optimize charAt to direct array access
                char firstChar = subString.charAt(0);
                while (true) {
                    int i = start;
                    boolean found = false;
                    for (; i >= 0; --i) {
                        if (value[i] == firstChar) {
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        return -1;
                    }
                    int o1 = i, o2 = 0;
                    while (++o2 < subCount
                            && value[++o1] == subString.charAt(o2)) {
                        // Intentionally empty
                    }
                    if (o2 == subCount) {
                        return i;
                    }
                    start = i - 1;
                }
            }
            return start < count ? start : count;
        }
        return -1;
    }

    /**
     * Trims off any extra capacity beyond the current length. Note, this method
     * is NOT guaranteed to change the capacity of this object.
     *
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.820 -0500", hash_original_method = "DFFDB9C5FDBA0FB3D8B8BAEB0765C9A3", hash_generated_method = "3C2FFD5B9A70C837FD2579D761B6114C")
    
public void trimToSize() {
        if (count < value.length) {
            char[] newValue = new char[count];
            System.arraycopy(value, 0, newValue, 0, count);
            value = newValue;
            shared = false;
        }
    }

    /**
     * Retrieves the Unicode code point value at the {@code index}.
     *
     * @param index
     *            the index to the {@code char} code unit.
     * @return the Unicode code point value.
     * @throws IndexOutOfBoundsException
     *             if {@code index} is negative or greater than or equal to
     *             {@link #length()}.
     * @see Character
     * @see Character#codePointAt(char[], int, int)
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.822 -0500", hash_original_method = "E01C43C5D144342C7BDF51C53F549AB8", hash_generated_method = "92C9B82B5F9D423360085BF0405A7DA4")
    
public int codePointAt(int index) {
        if (index < 0 || index >= count) {
            throw indexAndLength(index);
        }
        return Character.codePointAt(value, index, count);
    }

    /**
     * Retrieves the Unicode code point value that precedes the {@code index}.
     *
     * @param index
     *            the index to the {@code char} code unit within this object.
     * @return the Unicode code point value.
     * @throws IndexOutOfBoundsException
     *             if {@code index} is less than 1 or greater than
     *             {@link #length()}.
     * @see Character
     * @see Character#codePointBefore(char[], int, int)
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.824 -0500", hash_original_method = "F58237612B89D3EA2A0CCEABA41468D6", hash_generated_method = "AA113CAE349E2AB7195B4106C3FE1295")
    
public int codePointBefore(int index) {
        if (index < 1 || index > count) {
            throw indexAndLength(index);
        }
        return Character.codePointBefore(value, index);
    }

    /**
     * Calculates the number of Unicode code points between {@code start}
     * and {@code end}.
     *
     * @param start
     *            the inclusive beginning index of the subsequence.
     * @param end
     *            the exclusive end index of the subsequence.
     * @return the number of Unicode code points in the subsequence.
     * @throws IndexOutOfBoundsException
     *             if {@code start} is negative or greater than
     *             {@code end} or {@code end} is greater than
     *             {@link #length()}.
     * @see Character
     * @see Character#codePointCount(char[], int, int)
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.827 -0500", hash_original_method = "012FBC57A3E4CD6B3DAD71A54F843207", hash_generated_method = "5061C6CAB680A6E8AFA655DFF140F3AF")
    
public int codePointCount(int start, int end) {
        if (start < 0 || end > count || start > end) {
            throw startEndAndLength(start, end);
        }
        return Character.codePointCount(value, start, end - start);
    }

    /**
     * Returns the index that is offset {@code codePointOffset} code points from
     * {@code index}.
     *
     * @param index
     *            the index to calculate the offset from.
     * @param codePointOffset
     *            the number of code points to count.
     * @return the index that is {@code codePointOffset} code points away from
     *         index.
     * @throws IndexOutOfBoundsException
     *             if {@code index} is negative or greater than
     *             {@link #length()} or if there aren't enough code points
     *             before or after {@code index} to match
     *             {@code codePointOffset}.
     * @see Character
     * @see Character#offsetByCodePoints(char[], int, int, int, int)
     * @since 1.5
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:56:27.830 -0500", hash_original_method = "AC95F45AA90228D3C037EE242B5DE1AD", hash_generated_method = "35BCE7F2F7241D5B40C16E9A9AC4818C")
    
public int offsetByCodePoints(int index, int codePointOffset) {
        return Character.offsetByCodePoints(value, 0, count, index,
                codePointOffset);
    }
}

