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
    private char[] value;
    private int count;
    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.399 -0400", hash_original_method = "C4ACD0AC259F7EA41C20592CA02F17C8", hash_generated_method = "7E18A23DEBF832E11F71B13CFDB1A343")
    //DSFIXME:  CODE0002: Requires DSC value to be set
     AbstractStringBuilder() {
        value = new char[INITIAL_CAPACITY];
        // ---------- Original Method ----------
        //value = new char[INITIAL_CAPACITY];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.399 -0400", hash_original_method = "18E3A9BF20D4EDF142A00D9C9EE6DE65", hash_generated_method = "B01803B029A74D70DF66FD53D514183E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.400 -0400", hash_original_method = "0C09A579E41A9FFDC9603418777FC2FA", hash_generated_method = "45A5141B12ED78FED4407FEA611491C9")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.400 -0400", hash_original_method = "CA36BDE7C01AB0B5E4CF30DF6E006183", hash_generated_method = "82477EAE287FEBA389EBF3809AC0476B")
    @DSModeled(DSC.SAFE)
    final char[] getValue() {
        char[] retVal = new char[1];
        retVal[0] = dsTaint.getTaintString().charAt(0);
        return retVal;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.400 -0400", hash_original_method = "BF651BBA1175DAD67C837DDC7CF4E9BB", hash_generated_method = "40905074D1E002B62F0D167BAE20385D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.400 -0400", hash_original_method = "8C798CD9819DA5BF9BBE1043F1031580", hash_generated_method = "004AD6A31535717BDA48CAAD59314F27")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.400 -0400", hash_original_method = "8DE386E9EA04BE56519C8A6264F91502", hash_generated_method = "5842B2802BAEE1DA7D06DC49D72E079F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.401 -0400", hash_original_method = "BE4C961EA91A0D5BF81DD6DF988583CA", hash_generated_method = "08108BC472AEB9D1E6CD6D954D95A44A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.401 -0400", hash_original_method = "8C85C9AFF9EA1123A22A14B3A5C3C022", hash_generated_method = "46AA84CD7C582E519BE6199DA800B737")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.401 -0400", hash_original_method = "7BE8867E430B01B44EC74C0F78249D07", hash_generated_method = "EB647F252C25CB37B3E76CD5735D3650")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.401 -0400", hash_original_method = "ECBEE238E1E86380FF7C7052710927A2", hash_generated_method = "D7D48D89BFD243431331571E6F867B9C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.402 -0400", hash_original_method = "B96D71BE07A8651AC5DD35DFB1E0B9E9", hash_generated_method = "CE81F1C615FD7358074B93E6AFEBDC8D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.402 -0400", hash_original_method = "C43881C5821BA2B06BD7E52CBFC700AF", hash_generated_method = "509BA87F32ABE919CE3A85AC6A0853B3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void append0(CharSequence s, int start, int end) {
        dsTaint.addTaint(s);
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            s = "null";
        } //End block
        {
            boolean var89DBE3D09A4757E86A87E512699BEC01_1472478607 = ((start | end) < 0 || start > end || end > s.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.402 -0400", hash_original_method = "4EDD82B1AA77527A58B2DDD935211532", hash_generated_method = "881518166AF5FC1809FB0973B2359E40")
    @DSModeled(DSC.SAFE)
    public int capacity() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return value.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.402 -0400", hash_original_method = "447DEA66ED097ABAE0E9735DA732DBDF", hash_generated_method = "0F5F6BBF5427EAE15E1D01CBF6E6FB48")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.403 -0400", hash_original_method = "FC4FB8D4DBB369ED29C378FB60B58B5D", hash_generated_method = "8DEC028604C63258258F5286BF7816F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        dsTaint.addTaint(index);
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(count, index);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(count, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.403 -0400", hash_original_method = "ABFB3D9F0C982EE0B945F30A8DA651B2", hash_generated_method = "3F5E1C381CBC84583B6AB6305819B152")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(count, start, end - start);
        return (StringIndexOutOfBoundsException)dsTaint.getTaint();
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(count, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.403 -0400", hash_original_method = "19BE941D07BAB030F14923AC484F383F", hash_generated_method = "D9C6E064D02DAA095BB812F7498AF46E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.403 -0400", hash_original_method = "54D305E0C27E04AE130B9F0D173AF3D5", hash_generated_method = "FFD3A529DAACB1614D0289B68471C1CD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.404 -0400", hash_original_method = "DB245C34644491EEEAB0523333BD6692", hash_generated_method = "EDBBD72F0D58BC19471C7B99058CAAA0")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.404 -0400", hash_original_method = "AE7F72EED3837594CFBBCCC4060D7909", hash_generated_method = "89486E080A3285A2E9CDFFB09A83F8F4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.404 -0400", hash_original_method = "93FE28F62EFBAB9F8EBF9F9ADC8E87C8", hash_generated_method = "6D701477E07CA7DA8649A8962229AD1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.404 -0400", hash_original_method = "D46FA7C87DEEBA750439C9564B3FB7FE", hash_generated_method = "EB6A6C43D880485D1813390E7240A343")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.405 -0400", hash_original_method = "20DD23A1E6916CB9CC20932D676C3164", hash_generated_method = "0352ECABB6F570902AD381C9B785D6E5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    final void insert0(int index, char ch) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(ch);
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException(count, index);
        } //End block
        move(1, index);
        value[index] = ch;
        // ---------- Original Method ----------
        //if (index < 0 || index > count) {
            //throw new ArrayIndexOutOfBoundsException(count, index);
        //}
        //move(1, index);
        //value[index] = ch;
        //count++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.405 -0400", hash_original_method = "9E8CB9B48D87CB2577EC00CC04D06833", hash_generated_method = "946232BAA650B359538F95A695AA3093")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.405 -0400", hash_original_method = "10AE187E8F37FB4E725DAC6B12ECB82F", hash_generated_method = "63CD01962FEAD1258EB2F3CCD08ABAEE")
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
            boolean var499DCA3E97A15B9D8FE01D782B7A07A5_1697250594 = ((index | start | end) < 0 || index > count || start > end || end > s.length());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.405 -0400", hash_original_method = "A4F75F4D0C7ABF3196500E489B73A8D4", hash_generated_method = "6A0CE42C1903827D291888BEF557F2DF")
    @DSModeled(DSC.SAFE)
    public int length() {
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.406 -0400", hash_original_method = "E2C445AFFEE441B211B71B3E0E3E89EA", hash_generated_method = "4502A4A410E2D4F5D78F4226B9CA3256")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.406 -0400", hash_original_method = "467233E9D0CCB909364F18BB14890489", hash_generated_method = "73AE8BC0267D2D6D9012FD1655AA10EB")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.407 -0400", hash_original_method = "227A175682657414C42D64433DAB4FBA", hash_generated_method = "AB7A833C7F0221A323427F80E6E73CDD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.407 -0400", hash_original_method = "5EFF2E769F54F3F7450C4FCC35538F65", hash_generated_method = "EBED57D34D4778BC135851E1BAF855AC")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.408 -0400", hash_original_method = "CCD67F72D75D83378F17335F6F9DC00A", hash_generated_method = "99BA47A7AD938588C8BAFEF6496E2D3C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.408 -0400", hash_original_method = "1708C6B44328EC2FA5364A52800D811B", hash_generated_method = "250C6A78068B0B9F0F687521AA88D1C3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String substring(int start) {
        dsTaint.addTaint(start);
        {
            String varFF5D7C0C0693CDD5283542456758DA09_945759929 = (new String(value, start, count - start));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.408 -0400", hash_original_method = "7121FB14814A84CA4ADE1E9CCF3D54F6", hash_generated_method = "2008660AF3C02C0A42BA922BD09ACBA1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String substring(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            String var7517ACAC1294EB85B5ED3A9C2C8C284E_250854270 = (new String(value, start, end - start));
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.408 -0400", hash_original_method = "F5CABA8208B35CC620F77C4ED2D48018", hash_generated_method = "AC5D26FD6A035A8487563E52E4B8D5AF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public String toString() {
        int wasted;
        wasted = value.length - count;
        {
            String var83CDB60D885F69ADB94B9FF090DF9615_990709548 = (new String(value, 0, count));
        } //End block
        shared = true;
        String varB17172BEED2BE74C0D7F241925D62E10_585680027 = (new String(0, count, value));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.408 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "BBE35FCE4055C70F6CDFFE7BD1A85151")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public CharSequence subSequence(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        CharSequence varC847D8C41835030B7BEFF7774EE43A1F_1485674143 = (substring(start, end));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.409 -0400", hash_original_method = "7103B0EDA0D88809AB4D74CA424F106F", hash_generated_method = "5A280D8575F184F92D66BCC8975983C4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int indexOf(String string) {
        dsTaint.addTaint(string);
        int var69BB5E01AE8CE71924DBD4CF1DEEFE55_876940215 = (indexOf(string, 0));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return indexOf(string, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.409 -0400", hash_original_method = "58EF09653819A20604D2729AAEA1E73D", hash_generated_method = "B45C1A7925E229F077C72BFB0DD1AA99")
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
                    boolean var07F0F34C78F832D4432771EF4DCEE186_591602528 = (++o2 < subCount && value[++o1] == subString.charAt(o2));
                } //End collapsed parenthetic
                start = i + 1;
            } //End block
        } //End block
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.409 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "1E9969BA81C87C9E3D700E6A0B18F7D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int lastIndexOf(String string) {
        dsTaint.addTaint(string);
        int var629483EEC7DE422E0B8E730771A3942E_231394598 = (lastIndexOf(string, count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return lastIndexOf(string, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.410 -0400", hash_original_method = "7130CA0E46A667075374433A3B5D2D85", hash_generated_method = "F725923507709638254EE5D648961D46")
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
                        boolean varC6F1A2D739E8E9688B6BA89C00E8647F_470981412 = (++o2 < subCount
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.410 -0400", hash_original_method = "DFFDB9C5FDBA0FB3D8B8BAEB0765C9A3", hash_generated_method = "455DB6A5A459B4A1DCF028D172027D5A")
    //DSFIXME:  CODE0002: Requires DSC value to be set
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.410 -0400", hash_original_method = "E01C43C5D144342C7BDF51C53F549AB8", hash_generated_method = "5A8931CF52744FA2173AA67B8776E0D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointAt(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int var754C26F5C1DC59BD50BDC20E577E9886_735576770 = (Character.codePointAt(value, index, count));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointAt(value, index, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.410 -0400", hash_original_method = "F58237612B89D3EA2A0CCEABA41468D6", hash_generated_method = "FA7D6B4E03F395D4406FE5A7A449C0A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointBefore(int index) {
        dsTaint.addTaint(index);
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int var47513E82D5F330EECEA70775E6161519_1039376543 = (Character.codePointBefore(value, index));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (index < 1 || index > count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointBefore(value, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.411 -0400", hash_original_method = "012FBC57A3E4CD6B3DAD71A54F843207", hash_generated_method = "245998849CE17DB07506E8A7A8C8B005")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int codePointCount(int start, int end) {
        dsTaint.addTaint(start);
        dsTaint.addTaint(end);
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        int var3CCF693878924901A110D91C3295E7F1_1396537227 = (Character.codePointCount(value, start, end - start));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //if (start < 0 || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //return Character.codePointCount(value, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:25.411 -0400", hash_original_method = "AC95F45AA90228D3C037EE242B5DE1AD", hash_generated_method = "7652FC0CE4E7F1525C782C0645D4DFF5")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int offsetByCodePoints(int index, int codePointOffset) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(codePointOffset);
        int var8106FFBFDD8426C615EB8F94705A68B6_234342541 = (Character.offsetByCodePoints(value, 0, count, index,
                codePointOffset));
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return Character.offsetByCodePoints(value, 0, count, index,
                //codePointOffset);
    }

    
    static final int INITIAL_CAPACITY = 16;
}

