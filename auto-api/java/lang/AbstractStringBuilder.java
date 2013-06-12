package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InvalidObjectException;
import java.util.Arrays;
import libcore.util.EmptyArray;

abstract class AbstractStringBuilder {
    static int INITIAL_CAPACITY = 16;
    private char[] value;
    private int count;
    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.627 -0400", hash_original_method = "C4ACD0AC259F7EA41C20592CA02F17C8", hash_generated_method = "9151EF38202C744A7D1CC234437EBFD6")
    @DSModeled(DSC.SAFE)
     AbstractStringBuilder() {
        value = new char[INITIAL_CAPACITY];
        // ---------- Original Method ----------
        //value = new char[INITIAL_CAPACITY];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.636 -0400", hash_original_method = "18E3A9BF20D4EDF142A00D9C9EE6DE65", hash_generated_method = "E47D5C4614271FC3CC42B9A5EDD05D15")
    @DSModeled(DSC.SAFE)
     AbstractStringBuilder(int capacity) {
        dsTaint.addTaint(capacity);
        {
            if (DroidSafeAndroidRuntime.control) throw new NegativeArraySizeException();
        } //End block
        value = new char[capacity];
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new NegativeArraySizeException();
        //}
        //value = new char[capacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.651 -0400", hash_original_method = "0C09A579E41A9FFDC9603418777FC2FA", hash_generated_method = "D0D68202D8FA58202AECD06A48240A9A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AbstractStringBuilder(String string) {
        dsTaint.addTaint(string);
        count = string.length();
        shared = false;
        value = new char[count + INITIAL_CAPACITY];
        string._getChars(0, count, value, 0);
        // ---------- Original Method ----------
        //count = string.length();
        //shared = false;
        //value = new char[count + INITIAL_CAPACITY];
        //string._getChars(0, count, value, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.661 -0400", hash_original_method = "CA36BDE7C01AB0B5E4CF30DF6E006183", hash_generated_method = "7B4164475890DE6638B4A6FACEFA5DD6")
    @DSModeled(DSC.SAFE)
    final char[] getValue() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.667 -0400", hash_original_method = "BF651BBA1175DAD67C837DDC7CF4E9BB", hash_generated_method = "C36331D424FA49C11AD85543E23F13D9")
    @DSModeled(DSC.SAFE)
    final char[] shareValue() {
        shared = true;
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //shared = true;
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.692 -0400", hash_original_method = "8C798CD9819DA5BF9BBE1043F1031580", hash_generated_method = "A07254A0D4A73E7BBCFF4033469D86EB")
    @DSModeled(DSC.SAFE)
    final void set(char[] val, int len) throws InvalidObjectException {
        dsTaint.addTaint(val[0]);
        dsTaint.addTaint(len);
        {
            val = EmptyArray.CHAR;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("count out of range");
        } //End block
        shared = false;
        // ---------- Original Method ----------
        //if (val == null) {
            //val = EmptyArray.CHAR;
        //}
        //if (val.length < len) {
            //throw new InvalidObjectException("count out of range");
        //}
        //shared = false;
        //value = val;
        //count = len;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.707 -0400", hash_original_method = "8DE386E9EA04BE56519C8A6264F91502", hash_generated_method = "38226832AC96910E6A8681C5C2A2A74A")
    @DSModeled(DSC.SAFE)
    private void enlargeBuffer(int min) {
        dsTaint.addTaint(min);
        int newCount;
        newCount = ((value.length >> 1) + value.length) + 2;
        char[] newData;
        newData = new char[min > newCount ? min : newCount];//DSFIXME:  CODE0008: Nested ternary operator in expression
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
        // ---------- Original Method ----------
        //int newCount = ((value.length >> 1) + value.length) + 2;
        //char[] newData = new char[min > newCount ? min : newCount];
        //System.arraycopy(value, 0, newData, 0, count);
        //value = newData;
        //shared = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.726 -0400", hash_original_method = "BE4C961EA91A0D5BF81DD6DF988583CA", hash_generated_method = "2850BBBA322591340681D84618A1ECD7")
    @DSModeled(DSC.SAFE)
    final void appendNull() {
        int newCount;
        newCount = count + 4;
        {
            enlargeBuffer(newCount);
        } //End block
        value[count++] = 'n';
        value[count++] = 'u';
        value[count++] = 'l';
        value[count++] = 'l';
        // ---------- Original Method ----------
        //int newCount = count + 4;
        //if (newCount > value.length) {
            //enlargeBuffer(newCount);
        //}
        //value[count++] = 'n';
        //value[count++] = 'u';
        //value[count++] = 'l';
        //value[count++] = 'l';
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.742 -0400", hash_original_method = "8C85C9AFF9EA1123A22A14B3A5C3C022", hash_generated_method = "9E55BB983E64E743A106E5F2FD24BE51")
    @DSModeled(DSC.SAFE)
    final void append0(char[] chars) {
        dsTaint.addTaint(chars[0]);
        int newCount;
        newCount = count + chars.length;
        {
            enlargeBuffer(newCount);
        } //End block
        System.arraycopy(chars, 0, value, count, chars.length);
        count = newCount;
        // ---------- Original Method ----------
        //int newCount = count + chars.length;
        //if (newCount > value.length) {
            //enlargeBuffer(newCount);
        //}
        //System.arraycopy(chars, 0, value, count, chars.length);
        //count = newCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.755 -0400", hash_original_method = "7BE8867E430B01B44EC74C0F78249D07", hash_generated_method = "3BC9D460DC29B30EEEDCCADE4E7EF16D")
    @DSModeled(DSC.SAFE)
    final void append0(char[] chars, int offset, int length) {
        dsTaint.addTaint(length);
        dsTaint.addTaint(chars[0]);
        dsTaint.addTaint(offset);
        Arrays.checkOffsetAndCount(chars.length, offset, length);
        int newCount;
        newCount = count + length;
        {
            enlargeBuffer(newCount);
        } //End block
        System.arraycopy(chars, offset, value, count, length);
        count = newCount;
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(chars.length, offset, length);
        //int newCount = count + length;
        //if (newCount > value.length) {
            //enlargeBuffer(newCount);
        //}
        //System.arraycopy(chars, offset, value, count, length);
        //count = newCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.766 -0400", hash_original_method = "ECBEE238E1E86380FF7C7052710927A2", hash_generated_method = "A365B7CA24A72E4C97235DD6CE8C8D73")
    @DSModeled(DSC.SAFE)
    final void append0(char ch) {
        dsTaint.addTaint(ch);
        {
            enlargeBuffer(count + 1);
        } //End block
        value[count++] = ch;
        // ---------- Original Method ----------
        //if (count == value.length) {
            //enlargeBuffer(count + 1);
        //}
        //value[count++] = ch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.777 -0400", hash_original_method = "B96D71BE07A8651AC5DD35DFB1E0B9E9", hash_generated_method = "0131C070707D6DCBCD1362A0A466AA81")
    @DSModeled(DSC.SAFE)
    final void append0(String string) {
        dsTaint.addTaint(string);
        {
            appendNull();
        } //End block
        int length;
        length = string.length();
        int newCount;
        newCount = count + length;
        {
            enlargeBuffer(newCount);
        } //End block
        string._getChars(0, length, value, count);
        count = newCount;
        // ---------- Original Method ----------
        //if (string == null) {
            //appendNull();
            //return;
        //}
        //int length = string.length();
        //int newCount = count + length;
        //if (newCount > value.length) {
            //enlargeBuffer(newCount);
        //}
        //string._getChars(0, length, value, count);
        //count = newCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.823 -0400", hash_original_method = "C43881C5821BA2B06BD7E52CBFC700AF", hash_generated_method = "7AED9C5AC5D9E152B1B810956B08E91D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void append0(CharSequence s, int start, int end) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            s = "null";
        } //End block
        {
            boolean var89DBE3D09A4757E86A87E512699BEC01_1619367745 = ((start | end) < 0 || start > end || end > s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        int length;
        length = end - start;
        int newCount;
        newCount = count + length;
        {
            enlargeBuffer(newCount);
        } //End block
        {
            value = value.clone();
            shared = false;
        } //End block
        {
            ((String) s)._getChars(start, end, value, count);
        } //End block
        {
            AbstractStringBuilder other;
            other = (AbstractStringBuilder) s;
            System.arraycopy(other.value, start, value, count, length);
        } //End block
        {
            int j;
            j = count;
            {
                int i;
                i = start;
                {
                    value[j++] = s.charAt(i);
                } //End block
            } //End collapsed parenthetic
        } //End block
        this.count = newCount;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.832 -0400", hash_original_method = "4EDD82B1AA77527A58B2DDD935211532", hash_generated_method = "E0A090577EE4976C7A97FF990EF91EBC")
    @DSModeled(DSC.SAFE)
    public int capacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.840 -0400", hash_original_method = "447DEA66ED097ABAE0E9735DA732DBDF", hash_generated_method = "29AC93156D89FD114441DCD51AF572F9")
    @DSModeled(DSC.SAFE)
    public char charAt(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return value[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.844 -0400", hash_original_method = "FC4FB8D4DBB369ED29C378FB60B58B5D", hash_generated_method = "24747E9F036E088932E945675C12C87B")
    @DSModeled(DSC.SAFE)
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        dsTaint.addTaint(index);
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(count, index);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(count, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.849 -0400", hash_original_method = "ABFB3D9F0C982EE0B945F30A8DA651B2", hash_generated_method = "DF43DED87A12077DE202FE255CF96EE3")
    @DSModeled(DSC.SAFE)
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(count, start, end - start);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(count, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.861 -0400", hash_original_method = "19BE941D07BAB030F14923AC484F383F", hash_generated_method = "0E52BBB11BB0F083E23C227B0B524386")
    @DSModeled(DSC.SAFE)
    final void delete0(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            {
                end = count;
            } //End block
            {
                int length;
                length = count - end;
                {
                    {
                        System.arraycopy(value, end, value, start, length);
                    } //End block
                    {
                        char[] newData;
                        newData = new char[value.length];
                        System.arraycopy(value, 0, newData, 0, start);
                        System.arraycopy(value, end, newData, start, length);
                        value = newData;
                        shared = false;
                    } //End block
                } //End block
                count -= end - start;
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.878 -0400", hash_original_method = "54D305E0C27E04AE130B9F0D173AF3D5", hash_generated_method = "6E825FE59081C7FD4425B07C30238FB2")
    @DSModeled(DSC.SAFE)
    final void deleteCharAt0(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int length;
        length = count - index - 1;
        {
            {
                System.arraycopy(value, index + 1, value, index, length);
            } //End block
            {
                char[] newData;
                newData = new char[value.length];
                System.arraycopy(value, 0, newData, 0, index);
                System.arraycopy(value, index + 1, newData, index, length);
                value = newData;
                shared = false;
            } //End block
        } //End block
        count--;
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //int length = count - index - 1;
        //if (length > 0) {
            //if (!shared) {
                //System.arraycopy(value, index + 1, value, index, length);
            //} else {
                //char[] newData = new char[value.length];
                //System.arraycopy(value, 0, newData, 0, index);
                //System.arraycopy(value, index + 1, newData, index, length);
                //value = newData;
                //shared = false;
            //}
        //}
        //count--;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.886 -0400", hash_original_method = "DB245C34644491EEEAB0523333BD6692", hash_generated_method = "9423B6C0712BD8B9402C2C2E1BE4E7DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void ensureCapacity(int min) {
        dsTaint.addTaint(min);
        {
            int ourMin;
            ourMin = value.length*2 + 2;
            enlargeBuffer(Math.max(ourMin, min));
        } //End block
        // ---------- Original Method ----------
        //if (min > value.length) {
            //int ourMin = value.length*2 + 2;
            //enlargeBuffer(Math.max(ourMin, min));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.893 -0400", hash_original_method = "AE7F72EED3837594CFBBCCC4060D7909", hash_generated_method = "2D321BBD835D296A61FDD666E44F15E1")
    @DSModeled(DSC.SAFE)
    public void getChars(int start, int end, char[] dst, int dstStart) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(dst[0]);
        dsTaint.addTaint(dstStart);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        System.arraycopy(value, start, dst, dstStart, end - start);
        // ---------- Original Method ----------
        //if (start > count || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //System.arraycopy(value, start, dst, dstStart, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.904 -0400", hash_original_method = "93FE28F62EFBAB9F8EBF9F9ADC8E87C8", hash_generated_method = "0BE64B214C2FF4C146C91F4C4C0947C5")
    @DSModeled(DSC.SAFE)
    final void insert0(int index, char[] chars) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(chars[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        {
            move(chars.length, index);
            System.arraycopy(chars, 0, value, index, chars.length);
            count += chars.length;
        } //End block
        // ---------- Original Method ----------
        //if (index < 0 || index > count) {
            //throw indexAndLength(index);
        //}
        //if (chars.length != 0) {
            //move(chars.length, index);
            //System.arraycopy(chars, 0, value, index, chars.length);
            //count += chars.length;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.917 -0400", hash_original_method = "D46FA7C87DEEBA750439C9564B3FB7FE", hash_generated_method = "BA716FF91C87DB81BD72B6E4BF5465A0")
    @DSModeled(DSC.SAFE)
    final void insert0(int index, char[] chars, int start, int length) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(start);
        dsTaint.addTaint(length);
        dsTaint.addTaint(chars[0]);
        {
            {
                {
                    move(length, index);
                    System.arraycopy(chars, start, value, index, length);
                } //End block
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException("this.length=" + count
                + "; index=" + index + "; chars.length=" + chars.length
                + "; start=" + start + "; length=" + length);
        // ---------- Original Method ----------
        //if (index >= 0 && index <= count) {
            //if (start >= 0 && length >= 0 && length <= chars.length - start) {
                //if (length != 0) {
                    //move(length, index);
                    //System.arraycopy(chars, start, value, index, length);
                    //count += length;
                //}
                //return;
            //}
        //}
        //throw new StringIndexOutOfBoundsException("this.length=" + count
                //+ "; index=" + index + "; chars.length=" + chars.length
                //+ "; start=" + start + "; length=" + length);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.944 -0400", hash_original_method = "20DD23A1E6916CB9CC20932D676C3164", hash_generated_method = "6D568638A812092262EC96D6D0FDC5AC")
    @DSModeled(DSC.SAFE)
    final void insert0(int index, char ch) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(ch);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException(count, index);
        } //End block
        move(1, index);
        value[index] = ch;
        count++;
        // ---------- Original Method ----------
        //if (index < 0 || index > count) {
            //throw new ArrayIndexOutOfBoundsException(count, index);
        //}
        //move(1, index);
        //value[index] = ch;
        //count++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.953 -0400", hash_original_method = "9E8CB9B48D87CB2577EC00CC04D06833", hash_generated_method = "02A1254942E3E26C5B9F640B265F80A5")
    @DSModeled(DSC.SAFE)
    final void insert0(int index, String string) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(string);
        {
            {
                string = "null";
            } //End block
            int min;
            min = string.length();
            {
                move(min, index);
                string._getChars(0, min, value, index);
                count += min;
            } //End block
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        // ---------- Original Method ----------
        //if (index >= 0 && index <= count) {
            //if (string == null) {
                //string = "null";
            //}
            //int min = string.length();
            //if (min != 0) {
                //move(min, index);
                //string._getChars(0, min, value, index);
                //count += min;
            //}
        //} else {
            //throw indexAndLength(index);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.977 -0400", hash_original_method = "10AE187E8F37FB4E725DAC6B12ECB82F", hash_generated_method = "569061C537410CA2E370D3E403B0B0B5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void insert0(int index, CharSequence s, int start, int end) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            s = "null";
        } //End block
        {
            boolean var499DCA3E97A15B9D8FE01D782B7A07A5_1065272533 = ((index | start | end) < 0 || index > count || start > end || end > s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        insert0(index, s.subSequence(start, end).toString());
        // ---------- Original Method ----------
        //if (s == null) {
            //s = "null";
        //}
        //if ((index | start | end) < 0 || index > count || start > end || end > s.length()) {
            //throw new IndexOutOfBoundsException();
        //}
        //insert0(index, s.subSequence(start, end).toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.981 -0400", hash_original_method = "A4F75F4D0C7ABF3196500E489B73A8D4", hash_generated_method = "3F83B03C6B07FFE85F6740B6F6698D7D")
    @DSModeled(DSC.SAFE)
    public int length() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:55.990 -0400", hash_original_method = "E2C445AFFEE441B211B71B3E0E3E89EA", hash_generated_method = "7577A7AA7F00991AF490B1F19B7AA395")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void move(int size, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(size);
        int newCount;
        {
            {
                System.arraycopy(value, index, value, index + size, count - index);
            } //End block
            newCount = value.length;
        } //End block
        {
            newCount = Math.max(count + size, value.length*2 + 2);
        } //End block
        char[] newData;
        newData = new char[newCount];
        System.arraycopy(value, 0, newData, 0, index);
        System.arraycopy(value, index, newData, index + size, count - index);
        value = newData;
        shared = false;
        // ---------- Original Method ----------
        //int newCount;
        //if (value.length - count >= size) {
            //if (!shared) {
                //System.arraycopy(value, index, value, index + size, count - index);
                //return;
            //}
            //newCount = value.length;
        //} else {
            //newCount = Math.max(count + size, value.length*2 + 2);
        //}
        //char[] newData = new char[newCount];
        //System.arraycopy(value, 0, newData, 0, index);
        //System.arraycopy(value, index, newData, index + size, count - index);
        //value = newData;
        //shared = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.008 -0400", hash_original_method = "467233E9D0CCB909364F18BB14890489", hash_generated_method = "5504A0693A3F3A16ADA8A6FC312F9D02")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void replace0(int start, int end, String string) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(string);
        dsTaint.addTaint(end);
        {
            {
                end = count;
            } //End block
            {
                int stringLength;
                stringLength = string.length();
                int diff;
                diff = end - start - stringLength;
                {
                    {
                        System.arraycopy(value, end, value, start
                                + stringLength, count - end);
                    } //End block
                    {
                        char[] newData;
                        newData = new char[value.length];
                        System.arraycopy(value, 0, newData, 0, start);
                        System.arraycopy(value, end, newData, start
                                + stringLength, count - end);
                        value = newData;
                        shared = false;
                    } //End block
                } //End block
                {
                    move(-diff, end);
                } //End block
                {
                    value = value.clone();
                    shared = false;
                } //End block
                string._getChars(0, stringLength, value, start);
                count -= diff;
            } //End block
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } //End block
                insert0(start, string);
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.049 -0400", hash_original_method = "227A175682657414C42D64433DAB4FBA", hash_generated_method = "0FE9AFDDFC8D07C97666B1F4AD9B29DB")
    @DSModeled(DSC.SAFE)
    final void reverse0() {
        {
            int end;
            end = count - 1;
            char frontHigh;
            frontHigh = value[0];
            char endLow;
            endLow = value[end];
            boolean allowFrontSur, allowEndSur;
            allowFrontSur = true;
            allowEndSur = true;
            {
                int i, mid;
                i = 0;
                mid = count / 2;
                {
                    char frontLow;
                    frontLow = value[i + 1];
                    char endHigh;
                    endHigh = value[end - 1];
                    boolean surAtFront;
                    surAtFront = allowFrontSur && frontLow >= 0xdc00
                        && frontLow <= 0xdfff && frontHigh >= 0xd800
                        && frontHigh <= 0xdbff;
                    boolean surAtEnd;
                    surAtEnd = allowEndSur && endHigh >= 0xd800
                        && endHigh <= 0xdbff && endLow >= 0xdc00
                        && endLow <= 0xdfff;
                    allowFrontSur = allowEndSur = true;
                    {
                        {
                            value[end] = frontLow;
                            value[end - 1] = frontHigh;
                            value[i] = endHigh;
                            value[i + 1] = endLow;
                            frontHigh = value[i + 2];
                            endLow = value[end - 2];
                            i++;
                            end--;
                        } //End block
                        {
                            value[end] = frontHigh;
                            value[i] = endLow;
                            frontHigh = frontLow;
                            endLow = endHigh;
                        } //End block
                    } //End block
                    {
                        {
                            value[end] = frontLow;
                            value[i] = endLow;
                            endLow = endHigh;
                            allowFrontSur = false;
                        } //End block
                        {
                            value[end] = frontHigh;
                            value[i] = endHigh;
                            frontHigh = frontLow;
                            allowEndSur = false;
                        } //End block
                    } //End block
                } //End block
            } //End collapsed parenthetic
            {
                value[end] = allowFrontSur ? endLow : frontHigh;
            } //End block
        } //End block
        {
            char[] newData;
            newData = new char[value.length];
            {
                int i, end;
                i = 0;
                end = count;
                {
                    char high;
                    high = value[i];
                    {
                        char low;
                        low = value[i + 1];
                        {
                            newData[--end] = low;
                            i++;
                        } //End block
                    } //End block
                    newData[--end] = high;
                } //End block
            } //End collapsed parenthetic
            value = newData;
            shared = false;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.063 -0400", hash_original_method = "5EFF2E769F54F3F7450C4FCC35538F65", hash_generated_method = "9549BEA65C7F2B062BB56FD971C60E1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setCharAt(int index, char ch) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(ch);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        {
            value = value.clone();
            shared = false;
        } //End block
        value[index] = ch;
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //if (shared) {
            //value = value.clone();
            //shared = false;
        //}
        //value[index] = ch;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.072 -0400", hash_original_method = "CCD67F72D75D83378F17335F6F9DC00A", hash_generated_method = "4BF90A0A6735F25E1B1DF094DB1B97D1")
    @DSModeled(DSC.SAFE)
    public void setLength(int length) {
        dsTaint.addTaint(length);
        {
            if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException("length < 0: " + length);
        } //End block
        {
            enlargeBuffer(length);
        } //End block
        {
            {
                char[] newData;
                newData = new char[value.length];
                System.arraycopy(value, 0, newData, 0, count);
                value = newData;
                shared = false;
            } //End block
            {
                {
                    Arrays.fill(value, count, length, (char) 0);
                } //End block
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (length < 0) {
            //throw new StringIndexOutOfBoundsException("length < 0: " + length);
        //}
        //if (length > value.length) {
            //enlargeBuffer(length);
        //} else {
            //if (shared) {
                //char[] newData = new char[value.length];
                //System.arraycopy(value, 0, newData, 0, count);
                //value = newData;
                //shared = false;
            //} else {
                //if (count < length) {
                    //Arrays.fill(value, count, length, (char) 0);
                //}
            //}
        //}
        //count = length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.079 -0400", hash_original_method = "1708C6B44328EC2FA5364A52800D811B", hash_generated_method = "3AE222315E433371DC40883B6F0F6863")
    @DSModeled(DSC.SAFE)
    public String substring(int start) {
        dsTaint.addTaint(start);
        if (DroidSafeAndroidRuntime.control) throw indexAndLength(start);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (start >= 0 && start <= count) {
            //if (start == count) {
                //return "";
            //}
            //return new String(value, start, count - start);
        //}
        //throw indexAndLength(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.087 -0400", hash_original_method = "7121FB14814A84CA4ADE1E9CCF3D54F6", hash_generated_method = "ACE8CE6B50D0AB546B01670A9671C449")
    @DSModeled(DSC.SAFE)
    public String substring(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //if (start == end) {
                //return "";
            //}
            //return new String(value, start, end - start);
        //}
        //throw startEndAndLength(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.095 -0400", hash_original_method = "F5CABA8208B35CC620F77C4ED2D48018", hash_generated_method = "89714AD9F10A282E4B65368C3796B4A9")
    @DSModeled(DSC.SAFE)
    @Override
    public String toString() {
        int wasted;
        wasted = value.length - count;
        shared = true;
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //if (count == 0) {
            //return "";
        //}
        //int wasted = value.length - count;
        //if (wasted >= 256
                //|| (wasted >= INITIAL_CAPACITY && wasted >= (count >> 1))) {
            //return new String(value, 0, count);
        //}
        //shared = true;
        //return new String(0, count, value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.100 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "ABF9FC589D446813F1D0D6A947C77551")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        CharSequence varC847D8C41835030B7BEFF7774EE43A1F_292720833 = (substring(start, end));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.104 -0400", hash_original_method = "7103B0EDA0D88809AB4D74CA424F106F", hash_generated_method = "0EF04C466375F7BEEBB82C6835F88EC0")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(String string) {
        dsTaint.addTaint(string);
        int var69BB5E01AE8CE71924DBD4CF1DEEFE55_1458953081 = (indexOf(string, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return indexOf(string, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.116 -0400", hash_original_method = "58EF09653819A20604D2729AAEA1E73D", hash_generated_method = "53F4972FB06215E3863F465E4903C97C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(String subString, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(subString);
        {
            start = 0;
        } //End block
        int subCount;
        subCount = subString.length();
        {
            char firstChar;
            firstChar = subString.charAt(0);
            {
                int i;
                i = start;
                boolean found;
                found = false;
                {
                    {
                        found = true;
                    } //End block
                } //End block
                int o1, o2;
                o1 = i;
                o2 = 0;
                {
                    boolean var07F0F34C78F832D4432771EF4DCEE186_145068062 = (++o2 < subCount && value[++o1] == subString.charAt(o2));
                } //End collapsed parenthetic
                start = i + 1;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.130 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "6D24DCC64F8C601158EAA1B377B17D8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(String string) {
        dsTaint.addTaint(string);
        int var629483EEC7DE422E0B8E730771A3942E_1518976727 = (lastIndexOf(string, count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lastIndexOf(string, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.141 -0400", hash_original_method = "7130CA0E46A667075374433A3B5D2D85", hash_generated_method = "1E9C18B79D1B14C419965C99C4911473")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(String subString, int start) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(subString);
        int subCount;
        subCount = subString.length();
        {
            {
                {
                    start = count - subCount;
                } //End block
                char firstChar;
                firstChar = subString.charAt(0);
                {
                    int i;
                    i = start;
                    boolean found;
                    found = false;
                    {
                        {
                            found = true;
                        } //End block
                    } //End block
                    int o1, o2;
                    o1 = i;
                    o2 = 0;
                    {
                        boolean varC6F1A2D739E8E9688B6BA89C00E8647F_1922184899 = (++o2 < subCount
                            && value[++o1] == subString.charAt(o2));
                    } //End collapsed parenthetic
                    start = i - 1;
                } //End block
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.147 -0400", hash_original_method = "DFFDB9C5FDBA0FB3D8B8BAEB0765C9A3", hash_generated_method = "84C26536105CDB1D227BAD12DBF63E96")
    @DSModeled(DSC.SAFE)
    public void trimToSize() {
        {
            char[] newValue;
            newValue = new char[count];
            System.arraycopy(value, 0, newValue, 0, count);
            value = newValue;
            shared = false;
        } //End block
        // ---------- Original Method ----------
        //if (count < value.length) {
            //char[] newValue = new char[count];
            //System.arraycopy(value, 0, newValue, 0, count);
            //value = newValue;
            //shared = false;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.152 -0400", hash_original_method = "E01C43C5D144342C7BDF51C53F549AB8", hash_generated_method = "004917BEC3579ACC20FF4ED90581FF78")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointAt(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int var754C26F5C1DC59BD50BDC20E577E9886_1231964882 = (Character.codePointAt(value, index, count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointAt(value, index, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.157 -0400", hash_original_method = "F58237612B89D3EA2A0CCEABA41468D6", hash_generated_method = "1A25E1D4E01F4E2A12D157B1C735312C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointBefore(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int var47513E82D5F330EECEA70775E6161519_406369646 = (Character.codePointBefore(value, index));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index < 1 || index > count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointBefore(value, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.162 -0400", hash_original_method = "012FBC57A3E4CD6B3DAD71A54F843207", hash_generated_method = "4383FA8E7F1D00D962243BB785A12D79")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointCount(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        int var3CCF693878924901A110D91C3295E7F1_705804074 = (Character.codePointCount(value, start, end - start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (start < 0 || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //return Character.codePointCount(value, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-12 17:18:56.166 -0400", hash_original_method = "AC95F45AA90228D3C037EE242B5DE1AD", hash_generated_method = "4B306BC478471F8DF147AF64C31F02FC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int offsetByCodePoints(int index, int codePointOffset) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(codePointOffset);
        int var8106FFBFDD8426C615EB8F94705A68B6_1567175004 = (Character.offsetByCodePoints(value, 0, count, index,
                codePointOffset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Character.offsetByCodePoints(value, 0, count, index,
                //codePointOffset);
    }

    
}


