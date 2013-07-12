package java.lang;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.InvalidObjectException;
import java.util.Arrays;
import libcore.util.EmptyArray;

abstract class AbstractStringBuilder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.253 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")

    private char[] value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.253 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.254 -0400", hash_original_field = "9E81E7B963C71363E2FB3EEFCFECFC0E", hash_generated_field = "208F8AA93D19EFFECF64F85E89AD016E")

    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.254 -0400", hash_original_method = "C4ACD0AC259F7EA41C20592CA02F17C8", hash_generated_method = "7E18A23DEBF832E11F71B13CFDB1A343")
      AbstractStringBuilder() {
        value = new char[INITIAL_CAPACITY];
        // ---------- Original Method ----------
        //value = new char[INITIAL_CAPACITY];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.255 -0400", hash_original_method = "18E3A9BF20D4EDF142A00D9C9EE6DE65", hash_generated_method = "784C45F0BABC0FFD7B331503F00B2623")
      AbstractStringBuilder(int capacity) {
    if(capacity < 0)        
        {
            NegativeArraySizeException var5AE37C69772C7B3670FB23F69A1A89DC_1708731822 = new NegativeArraySizeException();
            var5AE37C69772C7B3670FB23F69A1A89DC_1708731822.addTaint(taint);
            throw var5AE37C69772C7B3670FB23F69A1A89DC_1708731822;
        } //End block
        value = new char[capacity];
        // ---------- Original Method ----------
        //if (capacity < 0) {
            //throw new NegativeArraySizeException();
        //}
        //value = new char[capacity];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.256 -0400", hash_original_method = "0C09A579E41A9FFDC9603418777FC2FA", hash_generated_method = "83BF7EE3FC5376E0A4CCA6CA8877D61D")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.257 -0400", hash_original_method = "CA36BDE7C01AB0B5E4CF30DF6E006183", hash_generated_method = "C1A61F20B2F33AE93BDDE377B5F2EE53")
    final char[] getValue() {
        char[] var2063C1608D6E0BAF80249C42E2BE5804_738767128 = (value);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_802323173 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_802323173;
        // ---------- Original Method ----------
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.258 -0400", hash_original_method = "BF651BBA1175DAD67C837DDC7CF4E9BB", hash_generated_method = "40DFD6050552108352295637B0B45405")
    final char[] shareValue() {
        shared = true;
        char[] var2063C1608D6E0BAF80249C42E2BE5804_421161933 = (value);
                char[] var50607924ABD4C17119BAF3A1CE41C0EC_27089245 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_27089245;
        // ---------- Original Method ----------
        //shared = true;
        //return value;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.259 -0400", hash_original_method = "8C798CD9819DA5BF9BBE1043F1031580", hash_generated_method = "5A98E1ECF04468F4CB3E00A3ADAB9095")
    final void set(char[] val, int len) throws InvalidObjectException {
    if(val == null)        
        {
            val = EmptyArray.CHAR;
        } //End block
    if(val.length < len)        
        {
            InvalidObjectException var44EB1B9040FBA8CDED7BF7EDEE5E94E1_724917344 = new InvalidObjectException("count out of range");
            var44EB1B9040FBA8CDED7BF7EDEE5E94E1_724917344.addTaint(taint);
            throw var44EB1B9040FBA8CDED7BF7EDEE5E94E1_724917344;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.261 -0400", hash_original_method = "8DE386E9EA04BE56519C8A6264F91502", hash_generated_method = "F483F597C52285B82C03EDA25CF66C3A")
    private void enlargeBuffer(int min) {
        addTaint(min);
        int newCount = ((value.length >> 1) + value.length) + 2;
        char[] newData = new char[min > newCount ? min : newCount];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.263 -0400", hash_original_method = "BE4C961EA91A0D5BF81DD6DF988583CA", hash_generated_method = "AB580E3365C74070129FF01539AC0F35")
    final void appendNull() {
        int newCount = count + 4;
    if(newCount > value.length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.264 -0400", hash_original_method = "8C85C9AFF9EA1123A22A14B3A5C3C022", hash_generated_method = "DA1CBBC3FAC1E7B075210673B681A890")
    final void append0(char[] chars) {
        addTaint(chars[0]);
        int newCount = count + chars.length;
    if(newCount > value.length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.265 -0400", hash_original_method = "7BE8867E430B01B44EC74C0F78249D07", hash_generated_method = "ADFA7261F543BE7548DD2D3049AF91EF")
    final void append0(char[] chars, int offset, int length) {
        addTaint(length);
        addTaint(offset);
        addTaint(chars[0]);
        Arrays.checkOffsetAndCount(chars.length, offset, length);
        int newCount = count + length;
    if(newCount > value.length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.266 -0400", hash_original_method = "ECBEE238E1E86380FF7C7052710927A2", hash_generated_method = "F700D327012FD67C8F2665AF34B580FD")
    final void append0(char ch) {
    if(count == value.length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.267 -0400", hash_original_method = "B96D71BE07A8651AC5DD35DFB1E0B9E9", hash_generated_method = "4CEFA211743A0D24D98F2C371D06EEAD")
    final void append0(String string) {
        addTaint(string.getTaint());
    if(string == null)        
        {
            appendNull();
            return;
        } //End block
        int length = string.length();
        int newCount = count + length;
    if(newCount > value.length)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.269 -0400", hash_original_method = "C43881C5821BA2B06BD7E52CBFC700AF", hash_generated_method = "A931231F6FC6FF15E0627F2A8D43E14D")
    final void append0(CharSequence s, int start, int end) {
        addTaint(end);
        addTaint(start);
    if(s == null)        
        {
            s = "null";
        } //End block
    if((start | end) < 0 || start > end || end > s.length())        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_1720970814 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_1720970814.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_1720970814;
        } //End block
        int length = end - start;
        int newCount = count + length;
    if(newCount > value.length)        
        {
            enlargeBuffer(newCount);
        } //End block
        else
    if(shared)        
        {
            value = value.clone();
            shared = false;
        } //End block
    if(s instanceof String)        
        {
            ((String) s)._getChars(start, end, value, count);
        } //End block
        else
    if(s instanceof AbstractStringBuilder)        
        {
            AbstractStringBuilder other = (AbstractStringBuilder) s;
            System.arraycopy(other.value, start, value, count, length);
        } //End block
        else
        {
            int j = count;
for(int i = start;i < end;i++)
            {
                value[j++] = s.charAt(i);
            } //End block
        } //End block
        this.count = newCount;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.270 -0400", hash_original_method = "4EDD82B1AA77527A58B2DDD935211532", hash_generated_method = "03586E4A628021B462143CCB0718E227")
    public int capacity() {
        int var014C1DEA33AEAA22508575E6FA159FEE_1048915659 = (value.length);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579691518 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_579691518;
        // ---------- Original Method ----------
        //return value.length;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.276 -0400", hash_original_method = "447DEA66ED097ABAE0E9735DA732DBDF", hash_generated_method = "348552A86B3EA9A2F7000216586B000D")
    public char charAt(int index) {
        addTaint(index);
    if(index < 0 || index >= count)        
        {
            java.lang.StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_975180212 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_975180212.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_975180212;
        } //End block
        char varDB191346F76C2459661064420AAF1DEB_2145576564 = (value[index]);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1206276335 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1206276335;
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return value[index];
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.276 -0400", hash_original_method = "FC4FB8D4DBB369ED29C378FB60B58B5D", hash_generated_method = "048D8B70168BEE28208B4F313E14CF7B")
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        addTaint(index);
        StringIndexOutOfBoundsException var8E0E058F8B3A84D7D7050503A76FC6B1_1768069039 = new StringIndexOutOfBoundsException(count, index);
        var8E0E058F8B3A84D7D7050503A76FC6B1_1768069039.addTaint(taint);
        throw var8E0E058F8B3A84D7D7050503A76FC6B1_1768069039;
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(count, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.277 -0400", hash_original_method = "ABFB3D9F0C982EE0B945F30A8DA651B2", hash_generated_method = "229900B0633F992C8ADC11B013235C38")
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        addTaint(end);
        addTaint(start);
        StringIndexOutOfBoundsException var89C1C7CB314577BC7057C018CA7F3CA1_2113635526 = new StringIndexOutOfBoundsException(count, start, end - start);
        var89C1C7CB314577BC7057C018CA7F3CA1_2113635526.addTaint(taint);
        throw var89C1C7CB314577BC7057C018CA7F3CA1_2113635526;
        // ---------- Original Method ----------
        //throw new StringIndexOutOfBoundsException(count, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.291 -0400", hash_original_method = "19BE941D07BAB030F14923AC484F383F", hash_generated_method = "C736F48F00A970326ACB59B9599A4F30")
    final void delete0(int start, int end) {
    if(start >= 0)        
        {
    if(end > count)            
            {
                end = count;
            } //End block
    if(end == start)            
            {
                return;
            } //End block
    if(end > start)            
            {
                int length = count - end;
    if(length >= 0)                
                {
    if(!shared)                    
                    {
                        System.arraycopy(value, end, value, start, length);
                    } //End block
                    else
                    {
                        char[] newData = new char[value.length];
                        System.arraycopy(value, 0, newData, 0, start);
                        System.arraycopy(value, end, newData, start, length);
                        value = newData;
                        shared = false;
                    } //End block
                } //End block
                count -= end - start;
                return;
            } //End block
        } //End block
        java.lang.StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_2026230420 = startEndAndLength(start, end);
        varD4320BED3007B31B0BCB1B90CDC7325C_2026230420.addTaint(taint);
        throw varD4320BED3007B31B0BCB1B90CDC7325C_2026230420;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.304 -0400", hash_original_method = "54D305E0C27E04AE130B9F0D173AF3D5", hash_generated_method = "3FB780669D8683250E0F81DA8EFCF367")
    final void deleteCharAt0(int index) {
        addTaint(index);
    if(index < 0 || index >= count)        
        {
            java.lang.StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_317592774 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_317592774.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_317592774;
        } //End block
        int length = count - index - 1;
    if(length > 0)        
        {
    if(!shared)            
            {
                System.arraycopy(value, index + 1, value, index, length);
            } //End block
            else
            {
                char[] newData = new char[value.length];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.305 -0400", hash_original_method = "DB245C34644491EEEAB0523333BD6692", hash_generated_method = "E44A018038A2E7B7BA940DECDC42960D")
    public void ensureCapacity(int min) {
        addTaint(min);
    if(min > value.length)        
        {
            int ourMin = value.length*2 + 2;
            enlargeBuffer(Math.max(ourMin, min));
        } //End block
        // ---------- Original Method ----------
        //if (min > value.length) {
            //int ourMin = value.length*2 + 2;
            //enlargeBuffer(Math.max(ourMin, min));
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.315 -0400", hash_original_method = "AE7F72EED3837594CFBBCCC4060D7909", hash_generated_method = "59CE66A501175AF60D170B40299E5BE7")
    public void getChars(int start, int end, char[] dst, int dstStart) {
        addTaint(dstStart);
        addTaint(dst[0]);
        addTaint(end);
        addTaint(start);
    if(start > count || end > count || start > end)        
        {
            java.lang.StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_678552132 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_678552132.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_678552132;
        } //End block
        System.arraycopy(value, start, dst, dstStart, end - start);
        // ---------- Original Method ----------
        //if (start > count || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //System.arraycopy(value, start, dst, dstStart, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.324 -0400", hash_original_method = "93FE28F62EFBAB9F8EBF9F9ADC8E87C8", hash_generated_method = "C25E52D5E106E4B6D1F4CFECC0065BEB")
    final void insert0(int index, char[] chars) {
        addTaint(index);
    if(index < 0 || index > count)        
        {
            java.lang.StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_1491620542 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_1491620542.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_1491620542;
        } //End block
    if(chars.length != 0)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.325 -0400", hash_original_method = "D46FA7C87DEEBA750439C9564B3FB7FE", hash_generated_method = "CA15398D83783CDC6B035BEF4CE7EA27")
    final void insert0(int index, char[] chars, int start, int length) {
        addTaint(start);
        addTaint(chars[0]);
        addTaint(index);
    if(index >= 0 && index <= count)        
        {
    if(start >= 0 && length >= 0 && length <= chars.length - start)            
            {
    if(length != 0)                
                {
                    move(length, index);
                    System.arraycopy(chars, start, value, index, length);
                    count += length;
                } //End block
                return;
            } //End block
        } //End block
        StringIndexOutOfBoundsException var9FABAEA77DB1043194E57B6366EEB048_1956485039 = new StringIndexOutOfBoundsException("this.length=" + count
                + "; index=" + index + "; chars.length=" + chars.length
                + "; start=" + start + "; length=" + length);
        var9FABAEA77DB1043194E57B6366EEB048_1956485039.addTaint(taint);
        throw var9FABAEA77DB1043194E57B6366EEB048_1956485039;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.326 -0400", hash_original_method = "20DD23A1E6916CB9CC20932D676C3164", hash_generated_method = "F8253601E8BA75E60376D6526BD6D5FC")
    final void insert0(int index, char ch) {
    if(index < 0 || index > count)        
        {
            ArrayIndexOutOfBoundsException varE14ED5F7FD76F036C57F78CEC508739F_580998213 = new ArrayIndexOutOfBoundsException(count, index);
            varE14ED5F7FD76F036C57F78CEC508739F_580998213.addTaint(taint);
            throw varE14ED5F7FD76F036C57F78CEC508739F_580998213;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.335 -0400", hash_original_method = "9E8CB9B48D87CB2577EC00CC04D06833", hash_generated_method = "3AC2BC4A93D761F9F70E6A938178948A")
    final void insert0(int index, String string) {
        addTaint(string.getTaint());
        addTaint(index);
    if(index >= 0 && index <= count)        
        {
    if(string == null)            
            {
                string = "null";
            } //End block
            int min = string.length();
    if(min != 0)            
            {
                move(min, index);
                string._getChars(0, min, value, index);
                count += min;
            } //End block
        } //End block
        else
        {
            java.lang.StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_1421706122 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_1421706122.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_1421706122;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.339 -0400", hash_original_method = "10AE187E8F37FB4E725DAC6B12ECB82F", hash_generated_method = "5F85A0A07CA6A522157216E2880D3624")
    final void insert0(int index, CharSequence s, int start, int end) {
        addTaint(end);
        addTaint(start);
        addTaint(s.getTaint());
        addTaint(index);
    if(s == null)        
        {
            s = "null";
        } //End block
    if((index | start | end) < 0 || index > count || start > end || end > s.length())        
        {
            IndexOutOfBoundsException varE4A00D3DB3B35ED0F12562B8AA17377A_371174121 = new IndexOutOfBoundsException();
            varE4A00D3DB3B35ED0F12562B8AA17377A_371174121.addTaint(taint);
            throw varE4A00D3DB3B35ED0F12562B8AA17377A_371174121;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.341 -0400", hash_original_method = "A4F75F4D0C7ABF3196500E489B73A8D4", hash_generated_method = "2AA488740D36070C1ACA0BB150D8EE78")
    public int length() {
        int varE2942A04780E223B215EB8B663CF5353_1990755844 = (count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_785772688 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_785772688;
        // ---------- Original Method ----------
        //return count;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.343 -0400", hash_original_method = "E2C445AFFEE441B211B71B3E0E3E89EA", hash_generated_method = "624012EDA1A9446A3F17269E2BA17F00")
    private void move(int size, int index) {
        addTaint(index);
        addTaint(size);
        int newCount;
    if(value.length - count >= size)        
        {
    if(!shared)            
            {
                System.arraycopy(value, index, value, index + size, count - index);
                return;
            } //End block
            newCount = value.length;
        } //End block
        else
        {
            newCount = Math.max(count + size, value.length*2 + 2);
        } //End block
        char[] newData = new char[newCount];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.364 -0400", hash_original_method = "467233E9D0CCB909364F18BB14890489", hash_generated_method = "1CDDB33DCEB54D51D0355A387F1675E3")
    final void replace0(int start, int end, String string) {
        addTaint(string.getTaint());
        addTaint(end);
        addTaint(start);
    if(start >= 0)        
        {
    if(end > count)            
            {
                end = count;
            } //End block
    if(end > start)            
            {
                int stringLength = string.length();
                int diff = end - start - stringLength;
    if(diff > 0)                
                {
    if(!shared)                    
                    {
                        System.arraycopy(value, end, value, start
                                + stringLength, count - end);
                    } //End block
                    else
                    {
                        char[] newData = new char[value.length];
                        System.arraycopy(value, 0, newData, 0, start);
                        System.arraycopy(value, end, newData, start
                                + stringLength, count - end);
                        value = newData;
                        shared = false;
                    } //End block
                } //End block
                else
    if(diff < 0)                
                {
                    move(-diff, end);
                } //End block
                else
    if(shared)                
                {
                    value = value.clone();
                    shared = false;
                } //End block
                string._getChars(0, stringLength, value, start);
                count -= diff;
                return;
            } //End block
    if(start == end)            
            {
    if(string == null)                
                {
                    NullPointerException var7338BC9F48D81FE0BBD6183F4014DCC4_307998953 = new NullPointerException();
                    var7338BC9F48D81FE0BBD6183F4014DCC4_307998953.addTaint(taint);
                    throw var7338BC9F48D81FE0BBD6183F4014DCC4_307998953;
                } //End block
                insert0(start, string);
                return;
            } //End block
        } //End block
        java.lang.StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_519067169 = startEndAndLength(start, end);
        varD4320BED3007B31B0BCB1B90CDC7325C_519067169.addTaint(taint);
        throw varD4320BED3007B31B0BCB1B90CDC7325C_519067169;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.370 -0400", hash_original_method = "227A175682657414C42D64433DAB4FBA", hash_generated_method = "7494AB8A09F5A8670BC51D94534E8B52")
    final void reverse0() {
    if(count < 2)        
        {
            return;
        } //End block
    if(!shared)        
        {
            int end = count - 1;
            char frontHigh = value[0];
            char endLow = value[end];
            boolean allowFrontSur = true;
            boolean allowEndSur = true;
for(int i = 0, mid = count / 2;i < mid;i++,--end)
            {
                char frontLow = value[i + 1];
                char endHigh = value[end - 1];
                boolean surAtFront = allowFrontSur && frontLow >= 0xdc00
                        && frontLow <= 0xdfff && frontHigh >= 0xd800
                        && frontHigh <= 0xdbff;
    if(surAtFront && (count < 3))                
                {
                    return;
                } //End block
                boolean surAtEnd = allowEndSur && endHigh >= 0xd800
                        && endHigh <= 0xdbff && endLow >= 0xdc00
                        && endLow <= 0xdfff;
                allowFrontSur = allowEndSur = true;
    if(surAtFront == surAtEnd)                
                {
    if(surAtFront)                    
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
                    else
                    {
                        value[end] = frontHigh;
                        value[i] = endLow;
                        frontHigh = frontLow;
                        endLow = endHigh;
                    } //End block
                } //End block
                else
                {
    if(surAtFront)                    
                    {
                        value[end] = frontLow;
                        value[i] = endLow;
                        endLow = endHigh;
                        allowFrontSur = false;
                    } //End block
                    else
                    {
                        value[end] = frontHigh;
                        value[i] = endHigh;
                        frontHigh = frontLow;
                        allowEndSur = false;
                    } //End block
                } //End block
            } //End block
    if((count & 1) == 1 && (!allowFrontSur || !allowEndSur))            
            {
                value[end] = allowFrontSur ? endLow : frontHigh;
            } //End block
        } //End block
        else
        {
            char[] newData = new char[value.length];
for(int i = 0, end = count;i < count;i++)
            {
                char high = value[i];
    if((i + 1) < count && high >= 0xd800 && high <= 0xdbff)                
                {
                    char low = value[i + 1];
    if(low >= 0xdc00 && low <= 0xdfff)                    
                    {
                        newData[--end] = low;
                        i++;
                    } //End block
                } //End block
                newData[--end] = high;
            } //End block
            value = newData;
            shared = false;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.379 -0400", hash_original_method = "5EFF2E769F54F3F7450C4FCC35538F65", hash_generated_method = "E5BC2947B2277E2E64E5C91E731E048F")
    public void setCharAt(int index, char ch) {
    if(index < 0 || index >= count)        
        {
            java.lang.StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_820202379 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_820202379.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_820202379;
        } //End block
    if(shared)        
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.381 -0400", hash_original_method = "CCD67F72D75D83378F17335F6F9DC00A", hash_generated_method = "1190E7C186901A5EF9A4D5B4C03F058B")
    public void setLength(int length) {
    if(length < 0)        
        {
            StringIndexOutOfBoundsException var519D94A834CD64337A885A48C79C1FFE_1303032558 = new StringIndexOutOfBoundsException("length < 0: " + length);
            var519D94A834CD64337A885A48C79C1FFE_1303032558.addTaint(taint);
            throw var519D94A834CD64337A885A48C79C1FFE_1303032558;
        } //End block
    if(length > value.length)        
        {
            enlargeBuffer(length);
        } //End block
        else
        {
    if(shared)            
            {
                char[] newData = new char[value.length];
                System.arraycopy(value, 0, newData, 0, count);
                value = newData;
                shared = false;
            } //End block
            else
            {
    if(count < length)                
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.391 -0400", hash_original_method = "1708C6B44328EC2FA5364A52800D811B", hash_generated_method = "76DECDBCEDFB6074012B60B7E62A27C8")
    public String substring(int start) {
        addTaint(start);
    if(start >= 0 && start <= count)        
        {
    if(start == count)            
            {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_262746298 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_262746298.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_262746298;
            } //End block
String var941456B7B2856A00B402ED3619A20844_539145990 =             new String(value, start, count - start);
            var941456B7B2856A00B402ED3619A20844_539145990.addTaint(taint);
            return var941456B7B2856A00B402ED3619A20844_539145990;
        } //End block
        java.lang.StringIndexOutOfBoundsException varC9C52284361B891C0CBD2284A6FE0828_371273529 = indexAndLength(start);
        varC9C52284361B891C0CBD2284A6FE0828_371273529.addTaint(taint);
        throw varC9C52284361B891C0CBD2284A6FE0828_371273529;
        // ---------- Original Method ----------
        //if (start >= 0 && start <= count) {
            //if (start == count) {
                //return "";
            //}
            //return new String(value, start, count - start);
        //}
        //throw indexAndLength(start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.399 -0400", hash_original_method = "7121FB14814A84CA4ADE1E9CCF3D54F6", hash_generated_method = "E3406F91A9ED49CC36A2DD5E36CB27A6")
    public String substring(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(start >= 0 && start <= end && end <= count)        
        {
    if(start == end)            
            {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_570517033 =                 "";
                var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_570517033.addTaint(taint);
                return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_570517033;
            } //End block
String varD817CE0CE55587478ECBA12712F5EB2E_2122504235 =             new String(value, start, end - start);
            varD817CE0CE55587478ECBA12712F5EB2E_2122504235.addTaint(taint);
            return varD817CE0CE55587478ECBA12712F5EB2E_2122504235;
        } //End block
        java.lang.StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_344740687 = startEndAndLength(start, end);
        varD4320BED3007B31B0BCB1B90CDC7325C_344740687.addTaint(taint);
        throw varD4320BED3007B31B0BCB1B90CDC7325C_344740687;
        // ---------- Original Method ----------
        //if (start >= 0 && start <= end && end <= count) {
            //if (start == end) {
                //return "";
            //}
            //return new String(value, start, end - start);
        //}
        //throw startEndAndLength(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.401 -0400", hash_original_method = "F5CABA8208B35CC620F77C4ED2D48018", hash_generated_method = "7B52A5AD236855189CB256B39C1FB6A6")
    @Override
    public String toString() {
    if(count == 0)        
        {
String var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1465269378 =             "";
            var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1465269378.addTaint(taint);
            return var9CB9B6C9951BF8E98E1ABAF5E2CADCAD_1465269378;
        } //End block
        int wasted = value.length - count;
    if(wasted >= 256
                || (wasted >= INITIAL_CAPACITY && wasted >= (count >> 1)))        
        {
String var6E86F5436CC97280AEEC740E7B3A4D4B_902102176 =             new String(value, 0, count);
            var6E86F5436CC97280AEEC740E7B3A4D4B_902102176.addTaint(taint);
            return var6E86F5436CC97280AEEC740E7B3A4D4B_902102176;
        } //End block
        shared = true;
String var51CD9F80628198C4B5CFEE108014BFB8_1125886420 =         new String(0, count, value);
        var51CD9F80628198C4B5CFEE108014BFB8_1125886420.addTaint(taint);
        return var51CD9F80628198C4B5CFEE108014BFB8_1125886420;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.402 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "4470F62793F260D98C6515CB6C83B90C")
    public CharSequence subSequence(int start, int end) {
        addTaint(end);
        addTaint(start);
CharSequence var14116236EC4BC8D62F0E86641118EABD_194966827 =         substring(start, end);
        var14116236EC4BC8D62F0E86641118EABD_194966827.addTaint(taint);
        return var14116236EC4BC8D62F0E86641118EABD_194966827;
        // ---------- Original Method ----------
        //return substring(start, end);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.402 -0400", hash_original_method = "7103B0EDA0D88809AB4D74CA424F106F", hash_generated_method = "F24C3E614773547DCA2597882F03FCA0")
    public int indexOf(String string) {
        addTaint(string.getTaint());
        int varB340192257F79A565561D36D741E5295_307897119 = (indexOf(string, 0));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688047285 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688047285;
        // ---------- Original Method ----------
        //return indexOf(string, 0);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.405 -0400", hash_original_method = "58EF09653819A20604D2729AAEA1E73D", hash_generated_method = "1C17EFA78BED18598FF315DB31622FE0")
    public int indexOf(String subString, int start) {
        addTaint(start);
        addTaint(subString.getTaint());
    if(start < 0)        
        {
            start = 0;
        } //End block
        int subCount = subString.length();
    if(subCount > 0)        
        {
    if(subCount + start > count)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1152612816 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414255026 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_414255026;
            } //End block
            char firstChar = subString.charAt(0);
            while
(true)            
            {
                int i = start;
                boolean found = false;
for(;i < count;i++)
                {
    if(value[i] == firstChar)                    
                    {
                        found = true;
                        break;
                    } //End block
                } //End block
    if(!found || subCount + i > count)                
                {
                    int var6BB61E3B7BCE0931DA574D19D1D82C88_1335021329 = (-1);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45418080 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_45418080;
                } //End block
                int o1 = i;
                int o2 = 0;
                while
(++o2 < subCount && value[++o1] == subString.charAt(o2))                
                {
                } //End block
    if(o2 == subCount)                
                {
                    int var865C0C0B4AB0E063E5CAA3387C1A8741_1595077005 = (i);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128243586 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_128243586;
                } //End block
                start = i + 1;
            } //End block
        } //End block
        int varA37391EA3114A773613C280B01BD4796_627178725 = ((start < count || start == 0) ? start : count);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299139171 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_299139171;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.407 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "1E19799CE7E190408AAE51709A056D46")
    public int lastIndexOf(String string) {
        addTaint(string.getTaint());
        int var9D74F68960E009CAC27271987951F701_167556722 = (lastIndexOf(string, count));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286087763 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286087763;
        // ---------- Original Method ----------
        //return lastIndexOf(string, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.409 -0400", hash_original_method = "7130CA0E46A667075374433A3B5D2D85", hash_generated_method = "E06A677357605A35A1D4661A768B5D5B")
    public int lastIndexOf(String subString, int start) {
        addTaint(start);
        addTaint(subString.getTaint());
        int subCount = subString.length();
    if(subCount <= count && start >= 0)        
        {
    if(subCount > 0)            
            {
    if(start > count - subCount)                
                {
                    start = count - subCount;
                } //End block
                char firstChar = subString.charAt(0);
                while
(true)                
                {
                    int i = start;
                    boolean found = false;
for(;i >= 0;--i)
                    {
    if(value[i] == firstChar)                        
                        {
                            found = true;
                            break;
                        } //End block
                    } //End block
    if(!found)                    
                    {
                        int var6BB61E3B7BCE0931DA574D19D1D82C88_736014792 = (-1);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062612502 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2062612502;
                    } //End block
                    int o1 = i;
                    int o2 = 0;
                    while
(++o2 < subCount
                            && value[++o1] == subString.charAt(o2))                    
                    {
                    } //End block
    if(o2 == subCount)                    
                    {
                        int var865C0C0B4AB0E063E5CAA3387C1A8741_2072258628 = (i);
                                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456362678 = getTaintInt();
                        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456362678;
                    } //End block
                    start = i - 1;
                } //End block
            } //End block
            int var0FFB83E5F2423119ED71A6AA9F842533_271360637 = (start < count ? start : count);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867736048 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1867736048;
        } //End block
        int var6BB61E3B7BCE0931DA574D19D1D82C88_173162983 = (-1);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837397293 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_837397293;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.412 -0400", hash_original_method = "DFFDB9C5FDBA0FB3D8B8BAEB0765C9A3", hash_generated_method = "012E50662FD544CBDF434085556C87E2")
    public void trimToSize() {
    if(count < value.length)        
        {
            char[] newValue = new char[count];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.421 -0400", hash_original_method = "E01C43C5D144342C7BDF51C53F549AB8", hash_generated_method = "5E31267E763BF3FDDDF0C98326280C20")
    public int codePointAt(int index) {
        addTaint(index);
    if(index < 0 || index >= count)        
        {
            java.lang.StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_556972029 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_556972029.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_556972029;
        } //End block
        int var22B7D8D1B91EC5C8C76A0BDECAD991A3_1159033132 = (Character.codePointAt(value, index, count));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021704454 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021704454;
        // ---------- Original Method ----------
        //if (index < 0 || index >= count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointAt(value, index, count);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.433 -0400", hash_original_method = "F58237612B89D3EA2A0CCEABA41468D6", hash_generated_method = "8D73501B2FEFFAB473E7BF4D1D1AF632")
    public int codePointBefore(int index) {
        addTaint(index);
    if(index < 1 || index > count)        
        {
            java.lang.StringIndexOutOfBoundsException var31A81F65A9D9C0D123C8BD6CC0A6023B_1763335762 = indexAndLength(index);
            var31A81F65A9D9C0D123C8BD6CC0A6023B_1763335762.addTaint(taint);
            throw var31A81F65A9D9C0D123C8BD6CC0A6023B_1763335762;
        } //End block
        int var033954CD6B3721BDA20E9342AFC6AB3C_1795184927 = (Character.codePointBefore(value, index));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215150625 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1215150625;
        // ---------- Original Method ----------
        //if (index < 1 || index > count) {
            //throw indexAndLength(index);
        //}
        //return Character.codePointBefore(value, index);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.447 -0400", hash_original_method = "012FBC57A3E4CD6B3DAD71A54F843207", hash_generated_method = "07E99D3575435AAE0DA930D509D66C6B")
    public int codePointCount(int start, int end) {
        addTaint(end);
        addTaint(start);
    if(start < 0 || end > count || start > end)        
        {
            java.lang.StringIndexOutOfBoundsException varD4320BED3007B31B0BCB1B90CDC7325C_487851497 = startEndAndLength(start, end);
            varD4320BED3007B31B0BCB1B90CDC7325C_487851497.addTaint(taint);
            throw varD4320BED3007B31B0BCB1B90CDC7325C_487851497;
        } //End block
        int var0C54BE96406A8775D99B9F0076AAE625_1647209017 = (Character.codePointCount(value, start, end - start));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283103209 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1283103209;
        // ---------- Original Method ----------
        //if (start < 0 || end > count || start > end) {
            //throw startEndAndLength(start, end);
        //}
        //return Character.codePointCount(value, start, end - start);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.447 -0400", hash_original_method = "AC95F45AA90228D3C037EE242B5DE1AD", hash_generated_method = "7382C32BE2A2F5B3A50139E60BCEDF17")
    public int offsetByCodePoints(int index, int codePointOffset) {
        addTaint(codePointOffset);
        addTaint(index);
        int var2ED574B3008A859CE1F549ABD854D4DD_802935928 = (Character.offsetByCodePoints(value, 0, count, index,
                codePointOffset));
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540601581 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_540601581;
        // ---------- Original Method ----------
        //return Character.offsetByCodePoints(value, 0, count, index,
                //codePointOffset);
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:43.448 -0400", hash_original_field = "60E8041D14101DDB569AC77FCB6B5097", hash_generated_field = "737C5532807A143D11A79A7148513E52")

    static final int INITIAL_CAPACITY = 16;
}

