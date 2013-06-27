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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.160 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")

    private char[] value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.161 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.161 -0400", hash_original_field = "9E81E7B963C71363E2FB3EEFCFECFC0E", hash_generated_field = "208F8AA93D19EFFECF64F85E89AD016E")

    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.168 -0400", hash_original_method = "C4ACD0AC259F7EA41C20592CA02F17C8", hash_generated_method = "7E18A23DEBF832E11F71B13CFDB1A343")
      AbstractStringBuilder() {
        value = new char[INITIAL_CAPACITY];
        // ---------- Original Method ----------
        //value = new char[INITIAL_CAPACITY];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.169 -0400", hash_original_method = "18E3A9BF20D4EDF142A00D9C9EE6DE65", hash_generated_method = "6FE33D43FB57ED25AB066978A5449548")
      AbstractStringBuilder(int capacity) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.169 -0400", hash_original_method = "0C09A579E41A9FFDC9603418777FC2FA", hash_generated_method = "83BF7EE3FC5376E0A4CCA6CA8877D61D")
      AbstractStringBuilder(String string) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.169 -0400", hash_original_method = "CA36BDE7C01AB0B5E4CF30DF6E006183", hash_generated_method = "E9097F276976FD24EC69393D48CABF94")
    final char[] getValue() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1385927476 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1385927476;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.174 -0400", hash_original_method = "BF651BBA1175DAD67C837DDC7CF4E9BB", hash_generated_method = "19F0A2951066248F9CF32E75819EF61E")
    final char[] shareValue() {
        shared = true;
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_581260641 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_581260641;
        // ---------- Original Method ----------
        //shared = true;
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.179 -0400", hash_original_method = "8C798CD9819DA5BF9BBE1043F1031580", hash_generated_method = "C0879A15B741CC0CA0812D94D2E68AA1")
    final void set(char[] val, int len) throws InvalidObjectException {
        {
            val = EmptyArray.CHAR;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("count out of range");
        } //End block
        shared = false;
        value = val;
        count = len;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.180 -0400", hash_original_method = "8DE386E9EA04BE56519C8A6264F91502", hash_generated_method = "FC1ECC1B6EEB663230F177D79D76E23C")
    private void enlargeBuffer(int min) {
        int newCount;
        newCount = ((value.length >> 1) + value.length) + 2;
        char[] newData;
        newData = new char[min > newCount ? min : newCount];//DSFIXME:  CODE0008: Nested ternary operator in expression
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
        addTaint(min);
        // ---------- Original Method ----------
        //int newCount = ((value.length >> 1) + value.length) + 2;
        //char[] newData = new char[min > newCount ? min : newCount];
        //System.arraycopy(value, 0, newData, 0, count);
        //value = newData;
        //shared = false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.180 -0400", hash_original_method = "BE4C961EA91A0D5BF81DD6DF988583CA", hash_generated_method = "08108BC472AEB9D1E6CD6D954D95A44A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.187 -0400", hash_original_method = "8C85C9AFF9EA1123A22A14B3A5C3C022", hash_generated_method = "32DC324E7F894AFBF4F3CE1448FF291E")
    final void append0(char[] chars) {
        int newCount;
        newCount = count + chars.length;
        {
            enlargeBuffer(newCount);
        } //End block
        System.arraycopy(chars, 0, value, count, chars.length);
        count = newCount;
        addTaint(chars[0]);
        // ---------- Original Method ----------
        //int newCount = count + chars.length;
        //if (newCount > value.length) {
            //enlargeBuffer(newCount);
        //}
        //System.arraycopy(chars, 0, value, count, chars.length);
        //count = newCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.195 -0400", hash_original_method = "7BE8867E430B01B44EC74C0F78249D07", hash_generated_method = "30231D3D140A3E4B78E82457A327D606")
    final void append0(char[] chars, int offset, int length) {
        Arrays.checkOffsetAndCount(chars.length, offset, length);
        int newCount;
        newCount = count + length;
        {
            enlargeBuffer(newCount);
        } //End block
        System.arraycopy(chars, offset, value, count, length);
        count = newCount;
        addTaint(chars[0]);
        addTaint(offset);
        addTaint(length);
        // ---------- Original Method ----------
        //Arrays.checkOffsetAndCount(chars.length, offset, length);
        //int newCount = count + length;
        //if (newCount > value.length) {
            //enlargeBuffer(newCount);
        //}
        //System.arraycopy(chars, offset, value, count, length);
        //count = newCount;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.196 -0400", hash_original_method = "ECBEE238E1E86380FF7C7052710927A2", hash_generated_method = "398AE6984C650B7C505FB5974E5D0554")
    final void append0(char ch) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.197 -0400", hash_original_method = "B96D71BE07A8651AC5DD35DFB1E0B9E9", hash_generated_method = "6E251ACDF913746C445A929DF494E461")
    final void append0(String string) {
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
        addTaint(string.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.198 -0400", hash_original_method = "C43881C5821BA2B06BD7E52CBFC700AF", hash_generated_method = "AA4A95CB31EFC06882FE032A4D3F47BA")
    final void append0(CharSequence s, int start, int end) {
        {
            s = "null";
        } //End block
        {
            boolean var89DBE3D09A4757E86A87E512699BEC01_1960525053 = ((start | end) < 0 || start > end || end > s.length());
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
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.198 -0400", hash_original_method = "4EDD82B1AA77527A58B2DDD935211532", hash_generated_method = "57E2BD5A92BF5FB9C39CCFDF611482AA")
    public int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658435758 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_658435758;
        // ---------- Original Method ----------
        //return value.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.198 -0400", hash_original_method = "447DEA66ED097ABAE0E9735DA732DBDF", hash_generated_method = "4ED6A0D62AFB4E697DA75E82872F316C")
    public char charAt(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1869628007 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1869628007;
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return value[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.208 -0400", hash_original_method = "FC4FB8D4DBB369ED29C378FB60B58B5D", hash_generated_method = "3BAA7497F0414B8D9D56510DDB119646")
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(count, index);
        addTaint(index);
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(count, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.209 -0400", hash_original_method = "ABFB3D9F0C982EE0B945F30A8DA651B2", hash_generated_method = "36B0B40AF5F4C672627A26D7C22A8FA1")
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException(count, start, end - start);
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(count, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.213 -0400", hash_original_method = "19BE941D07BAB030F14923AC484F383F", hash_generated_method = "C5250AEA21093D2CFF9DCB4F16681FC5")
    final void delete0(int start, int end) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.214 -0400", hash_original_method = "54D305E0C27E04AE130B9F0D173AF3D5", hash_generated_method = "AB6D072542DC5004A180625B58CE9155")
    final void deleteCharAt0(int index) {
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
        addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.222 -0400", hash_original_method = "DB245C34644491EEEAB0523333BD6692", hash_generated_method = "4A0BB35211ED04E829067F60C8EBF190")
    public void ensureCapacity(int min) {
        {
            int ourMin;
            ourMin = value.length*2 + 2;
            enlargeBuffer(Math.max(ourMin, min));
        } //End block
        addTaint(min);
        // ---------- Original Method ----------
        //if (min > value.length) {
            //int ourMin = value.length*2 + 2;
            //enlargeBuffer(Math.max(ourMin, min));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.222 -0400", hash_original_method = "AE7F72EED3837594CFBBCCC4060D7909", hash_generated_method = "EFACE025E8162EED0314AFB1378DEF76")
    public void getChars(int start, int end, char[] dst, int dstStart) {
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        System.arraycopy(value, start, dst, dstStart, end - start);
        addTaint(start);
        addTaint(end);
        addTaint(dst[0]);
        addTaint(dstStart);
        // ---------- Original Method ----------
        //if (start > count || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //System.arraycopy(value, start, dst, dstStart, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.222 -0400", hash_original_method = "93FE28F62EFBAB9F8EBF9F9ADC8E87C8", hash_generated_method = "747E3B3EAD654A711E65D4C34943D102")
    final void insert0(int index, char[] chars) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        {
            move(chars.length, index);
            System.arraycopy(chars, 0, value, index, chars.length);
            count += chars.length;
        } //End block
        addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.234 -0400", hash_original_method = "D46FA7C87DEEBA750439C9564B3FB7FE", hash_generated_method = "122DFF0189BB122D16DEC9C765BB8902")
    final void insert0(int index, char[] chars, int start, int length) {
        {
            {
                {
                    move(length, index);
                    System.arraycopy(chars, start, value, index, length);
                    count += length;
                } //End block
            } //End block
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException("this.length=" + count
                + "; index=" + index + "; chars.length=" + chars.length
                + "; start=" + start + "; length=" + length);
        addTaint(index);
        addTaint(chars[0]);
        addTaint(start);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.234 -0400", hash_original_method = "20DD23A1E6916CB9CC20932D676C3164", hash_generated_method = "93DA36F06271D08C4000CC7E13C7951D")
    final void insert0(int index, char ch) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.235 -0400", hash_original_method = "9E8CB9B48D87CB2577EC00CC04D06833", hash_generated_method = "859F92B4189BED2100A97CE469E0BAEE")
    final void insert0(int index, String string) {
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
        addTaint(index);
        addTaint(string.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.235 -0400", hash_original_method = "10AE187E8F37FB4E725DAC6B12ECB82F", hash_generated_method = "E3E6073213295B983272C62C6DFA14E3")
    final void insert0(int index, CharSequence s, int start, int end) {
        {
            s = "null";
        } //End block
        {
            boolean var499DCA3E97A15B9D8FE01D782B7A07A5_158416261 = ((index | start | end) < 0 || index > count || start > end || end > s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } //End block
        } //End collapsed parenthetic
        insert0(index, s.subSequence(start, end).toString());
        addTaint(index);
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        // ---------- Original Method ----------
        //if (s == null) {
            //s = "null";
        //}
        //if ((index | start | end) < 0 || index > count || start > end || end > s.length()) {
            //throw new IndexOutOfBoundsException();
        //}
        //insert0(index, s.subSequence(start, end).toString());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.242 -0400", hash_original_method = "A4F75F4D0C7ABF3196500E489B73A8D4", hash_generated_method = "716BFACA550E54FBBC470E9CAC92A682")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47604381 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_47604381;
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.259 -0400", hash_original_method = "E2C445AFFEE441B211B71B3E0E3E89EA", hash_generated_method = "AE37A3B3F0BF27225C3923CED28A4A9A")
    private void move(int size, int index) {
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
        addTaint(size);
        addTaint(index);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.260 -0400", hash_original_method = "467233E9D0CCB909364F18BB14890489", hash_generated_method = "F3BE99ACA951584678539B09257F62CD")
    final void replace0(int start, int end, String string) {
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
        addTaint(start);
        addTaint(end);
        addTaint(string.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.264 -0400", hash_original_method = "227A175682657414C42D64433DAB4FBA", hash_generated_method = "AB7A833C7F0221A323427F80E6E73CDD")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.277 -0400", hash_original_method = "5EFF2E769F54F3F7450C4FCC35538F65", hash_generated_method = "FED66A96D4FA84C46B96B468ED844BA6")
    public void setCharAt(int index, char ch) {
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.278 -0400", hash_original_method = "CCD67F72D75D83378F17335F6F9DC00A", hash_generated_method = "A234A84BC219471D6F830E005B4C6ED3")
    public void setLength(int length) {
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
        count = length;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.279 -0400", hash_original_method = "1708C6B44328EC2FA5364A52800D811B", hash_generated_method = "E9C751180B196C9A7A082AE0286D0605")
    public String substring(int start) {
        String varB4EAC82CA7396A68D541C85D26508E83_2121979494 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_520291715 = null; //Variable for return #2
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_2121979494 = "";
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_520291715 = new String(value, start, count - start);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw indexAndLength(start);
        addTaint(start);
        String varA7E53CE21691AB073D9660D615818899_1563866846; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1563866846 = varB4EAC82CA7396A68D541C85D26508E83_2121979494;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1563866846 = varB4EAC82CA7396A68D541C85D26508E83_520291715;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1563866846.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1563866846;
        // ---------- Original Method ----------
        //if (start >= 0 && start <= count) {
            //if (start == count) {
                //return "";
            //}
            //return new String(value, start, count - start);
        //}
        //throw indexAndLength(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.286 -0400", hash_original_method = "7121FB14814A84CA4ADE1E9CCF3D54F6", hash_generated_method = "74A09F1C25BCD4CFC1F1EFFE71F7C498")
    public String substring(int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_32656910 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_126197720 = null; //Variable for return #2
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_32656910 = "";
            } //End block
            varB4EAC82CA7396A68D541C85D26508E83_126197720 = new String(value, start, end - start);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        addTaint(start);
        addTaint(end);
        String varA7E53CE21691AB073D9660D615818899_591856208; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_591856208 = varB4EAC82CA7396A68D541C85D26508E83_32656910;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_591856208 = varB4EAC82CA7396A68D541C85D26508E83_126197720;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_591856208.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_591856208;
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //if (start == end) {
                //return "";
            //}
            //return new String(value, start, end - start);
        //}
        //throw startEndAndLength(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.287 -0400", hash_original_method = "F5CABA8208B35CC620F77C4ED2D48018", hash_generated_method = "746D3FE7D795119934FFFA02923A85F2")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_808061524 = null; //Variable for return #1
        String varB4EAC82CA7396A68D541C85D26508E83_1158237230 = null; //Variable for return #2
        String varB4EAC82CA7396A68D541C85D26508E83_2080822533 = null; //Variable for return #3
        {
            varB4EAC82CA7396A68D541C85D26508E83_808061524 = "";
        } //End block
        int wasted;
        wasted = value.length - count;
        {
            varB4EAC82CA7396A68D541C85D26508E83_1158237230 = new String(value, 0, count);
        } //End block
        shared = true;
        varB4EAC82CA7396A68D541C85D26508E83_2080822533 = new String(0, count, value);
        String varA7E53CE21691AB073D9660D615818899_963747962; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_963747962 = varB4EAC82CA7396A68D541C85D26508E83_808061524;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_963747962 = varB4EAC82CA7396A68D541C85D26508E83_1158237230;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_963747962 = varB4EAC82CA7396A68D541C85D26508E83_2080822533;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_963747962.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_963747962;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.288 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "6C672B55BA1A36592FDF7227866840FE")
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_506155506 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_506155506 = substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_506155506.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_506155506;
        // ---------- Original Method ----------
        //return substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.288 -0400", hash_original_method = "7103B0EDA0D88809AB4D74CA424F106F", hash_generated_method = "8867E0F4226F77B7CD3154733CC1F313")
    public int indexOf(String string) {
        int var69BB5E01AE8CE71924DBD4CF1DEEFE55_1269671695 = (indexOf(string, 0));
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1440209879 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1440209879;
        // ---------- Original Method ----------
        //return indexOf(string, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.293 -0400", hash_original_method = "58EF09653819A20604D2729AAEA1E73D", hash_generated_method = "F1A5181AF01FA63F38458859B9B5F5F8")
    public int indexOf(String subString, int start) {
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
                    boolean var07F0F34C78F832D4432771EF4DCEE186_1137805939 = (++o2 < subCount && value[++o1] == subString.charAt(o2));
                } //End collapsed parenthetic
                start = i + 1;
            } //End block
        } //End block
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571566507 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_571566507;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.293 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "AF61A40E3F4B09E0D1CCA7372CAB4E58")
    public int lastIndexOf(String string) {
        int var629483EEC7DE422E0B8E730771A3942E_911339816 = (lastIndexOf(string, count));
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851021939 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_851021939;
        // ---------- Original Method ----------
        //return lastIndexOf(string, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.305 -0400", hash_original_method = "7130CA0E46A667075374433A3B5D2D85", hash_generated_method = "8BD1EF7CB0AEAC4E459E643DD62D123F")
    public int lastIndexOf(String subString, int start) {
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
                        boolean varC6F1A2D739E8E9688B6BA89C00E8647F_679744917 = (++o2 < subCount
                            && value[++o1] == subString.charAt(o2));
                    } //End collapsed parenthetic
                    start = i - 1;
                } //End block
            } //End block
        } //End block
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671857068 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_671857068;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.306 -0400", hash_original_method = "DFFDB9C5FDBA0FB3D8B8BAEB0765C9A3", hash_generated_method = "455DB6A5A459B4A1DCF028D172027D5A")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.306 -0400", hash_original_method = "E01C43C5D144342C7BDF51C53F549AB8", hash_generated_method = "3BC773DF3B6423481CA497FC583CD1E6")
    public int codePointAt(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int var754C26F5C1DC59BD50BDC20E577E9886_1601854826 = (Character.codePointAt(value, index, count));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265998282 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_265998282;
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointAt(value, index, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.306 -0400", hash_original_method = "F58237612B89D3EA2A0CCEABA41468D6", hash_generated_method = "3F85AB33C46E8733E57496AC9E3B9DE6")
    public int codePointBefore(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } //End block
        int var47513E82D5F330EECEA70775E6161519_706339278 = (Character.codePointBefore(value, index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_314741148 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_314741148;
        // ---------- Original Method ----------
        //if (index < 1 || index > count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointBefore(value, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.307 -0400", hash_original_method = "012FBC57A3E4CD6B3DAD71A54F843207", hash_generated_method = "27FF9922561457C53922EFE8E75C0DDD")
    public int codePointCount(int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } //End block
        int var3CCF693878924901A110D91C3295E7F1_1429146727 = (Character.codePointCount(value, start, end - start));
        addTaint(start);
        addTaint(end);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_982305237 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_982305237;
        // ---------- Original Method ----------
        //if (start < 0 || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //return Character.codePointCount(value, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.307 -0400", hash_original_method = "AC95F45AA90228D3C037EE242B5DE1AD", hash_generated_method = "9488B2565B6D22DA3008FD1AC56A6A89")
    public int offsetByCodePoints(int index, int codePointOffset) {
        int var8106FFBFDD8426C615EB8F94705A68B6_1799989585 = (Character.offsetByCodePoints(value, 0, count, index,
                codePointOffset));
        addTaint(index);
        addTaint(codePointOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945446046 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_945446046;
        // ---------- Original Method ----------
        //return Character.offsetByCodePoints(value, 0, count, index,
                //codePointOffset);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:40.307 -0400", hash_original_field = "60E8041D14101DDB569AC77FCB6B5097", hash_generated_field = "36FB1DCC3FECC4C5B441A4A419F91EE5")

    static int INITIAL_CAPACITY = 16;
}

