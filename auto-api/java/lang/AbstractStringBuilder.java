package java.lang;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.InvalidObjectException;
import java.util.Arrays;
import libcore.util.EmptyArray;

abstract class AbstractStringBuilder {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.249 -0400", hash_original_field = "2063C1608D6E0BAF80249C42E2BE5804", hash_generated_field = "C068225E28B5BE74066BE5338158F76B")

    private char[] value;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.249 -0400", hash_original_field = "E2942A04780E223B215EB8B663CF5353", hash_generated_field = "82CC849FCF58347832EA6BB917282DBE")

    private int count;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.249 -0400", hash_original_field = "9E81E7B963C71363E2FB3EEFCFECFC0E", hash_generated_field = "208F8AA93D19EFFECF64F85E89AD016E")

    private boolean shared;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.249 -0400", hash_original_method = "C4ACD0AC259F7EA41C20592CA02F17C8", hash_generated_method = "7E18A23DEBF832E11F71B13CFDB1A343")
      AbstractStringBuilder() {
        value = new char[INITIAL_CAPACITY];
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.249 -0400", hash_original_method = "18E3A9BF20D4EDF142A00D9C9EE6DE65", hash_generated_method = "6FE33D43FB57ED25AB066978A5449548")
      AbstractStringBuilder(int capacity) {
        {
            if (DroidSafeAndroidRuntime.control) throw new NegativeArraySizeException();
        } 
        value = new char[capacity];
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.250 -0400", hash_original_method = "0C09A579E41A9FFDC9603418777FC2FA", hash_generated_method = "83BF7EE3FC5376E0A4CCA6CA8877D61D")
      AbstractStringBuilder(String string) {
        count = string.length();
        shared = false;
        value = new char[count + INITIAL_CAPACITY];
        string._getChars(0, count, value, 0);
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.250 -0400", hash_original_method = "CA36BDE7C01AB0B5E4CF30DF6E006183", hash_generated_method = "5D8840ED809118846CE5C98B7441189F")
    final char[] getValue() {
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_1148084777 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_1148084777;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.250 -0400", hash_original_method = "BF651BBA1175DAD67C837DDC7CF4E9BB", hash_generated_method = "6BC2041541ECE0FC4BF2326236DDEA34")
    final char[] shareValue() {
        shared = true;
        char[] var50607924ABD4C17119BAF3A1CE41C0EC_129005894 = {getTaintChar()};
        return var50607924ABD4C17119BAF3A1CE41C0EC_129005894;
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.251 -0400", hash_original_method = "8C798CD9819DA5BF9BBE1043F1031580", hash_generated_method = "C0879A15B741CC0CA0812D94D2E68AA1")
    final void set(char[] val, int len) throws InvalidObjectException {
        {
            val = EmptyArray.CHAR;
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw new InvalidObjectException("count out of range");
        } 
        shared = false;
        value = val;
        count = len;
        
        
            
        
        
            
        
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.251 -0400", hash_original_method = "8DE386E9EA04BE56519C8A6264F91502", hash_generated_method = "3276380EFFCE68C122457A69EBA20B0D")
    private void enlargeBuffer(int min) {
        int newCount = ((value.length >> 1) + value.length) + 2;
        char[] newData = new char[min > newCount ? min : newCount];
        System.arraycopy(value, 0, newData, 0, count);
        value = newData;
        shared = false;
        addTaint(min);
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.251 -0400", hash_original_method = "BE4C961EA91A0D5BF81DD6DF988583CA", hash_generated_method = "1DCE7C6E7B853AFCE5999899F843901C")
    final void appendNull() {
        int newCount = count + 4;
        {
            enlargeBuffer(newCount);
        } 
        value[count++] = 'n';
        value[count++] = 'u';
        value[count++] = 'l';
        value[count++] = 'l';
        
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.252 -0400", hash_original_method = "8C85C9AFF9EA1123A22A14B3A5C3C022", hash_generated_method = "AFD8E042C0941C64608BAC4BC962584C")
    final void append0(char[] chars) {
        int newCount = count + chars.length;
        {
            enlargeBuffer(newCount);
        } 
        System.arraycopy(chars, 0, value, count, chars.length);
        count = newCount;
        addTaint(chars[0]);
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.253 -0400", hash_original_method = "7BE8867E430B01B44EC74C0F78249D07", hash_generated_method = "8090981BA283F21CD4547BE7D89E33E2")
    final void append0(char[] chars, int offset, int length) {
        Arrays.checkOffsetAndCount(chars.length, offset, length);
        int newCount = count + length;
        {
            enlargeBuffer(newCount);
        } 
        System.arraycopy(chars, offset, value, count, length);
        count = newCount;
        addTaint(chars[0]);
        addTaint(offset);
        addTaint(length);
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.253 -0400", hash_original_method = "ECBEE238E1E86380FF7C7052710927A2", hash_generated_method = "398AE6984C650B7C505FB5974E5D0554")
    final void append0(char ch) {
        {
            enlargeBuffer(count + 1);
        } 
        value[count++] = ch;
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.254 -0400", hash_original_method = "B96D71BE07A8651AC5DD35DFB1E0B9E9", hash_generated_method = "E57D40CB71ED247102A03B6C497E9299")
    final void append0(String string) {
        {
            appendNull();
        } 
        int length = string.length();
        int newCount = count + length;
        {
            enlargeBuffer(newCount);
        } 
        string._getChars(0, length, value, count);
        count = newCount;
        addTaint(string.getTaint());
        
        
            
            
        
        
        
        
            
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.255 -0400", hash_original_method = "C43881C5821BA2B06BD7E52CBFC700AF", hash_generated_method = "D9C505D147164DC3488692CF3236C2A2")
    final void append0(CharSequence s, int start, int end) {
        {
            s = "null";
        } 
        {
            boolean var89DBE3D09A4757E86A87E512699BEC01_413831730 = ((start | end) < 0 || start > end || end > s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } 
        } 
        int length = end - start;
        int newCount = count + length;
        {
            enlargeBuffer(newCount);
        } 
        {
            value = value.clone();
            shared = false;
        } 
        {
            ((String) s)._getChars(start, end, value, count);
        } 
        {
            AbstractStringBuilder other = (AbstractStringBuilder) s;
            System.arraycopy(other.value, start, value, count, length);
        } 
        {
            int j = count;
            {
                int i = start;
                {
                    value[j++] = s.charAt(i);
                } 
            } 
        } 
        this.count = newCount;
        addTaint(start);
        addTaint(end);
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.255 -0400", hash_original_method = "4EDD82B1AA77527A58B2DDD935211532", hash_generated_method = "D89A583CE4B32501794224AF095C9707")
    public int capacity() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350138849 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_350138849;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.255 -0400", hash_original_method = "447DEA66ED097ABAE0E9735DA732DBDF", hash_generated_method = "3F5B7F6398E526435610BEE28E5CAA2E")
    public char charAt(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } 
        addTaint(index);
        char varA87DEB01C5F539E6BDA34829C8EF2368_2044530937 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_2044530937;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.256 -0400", hash_original_method = "FC4FB8D4DBB369ED29C378FB60B58B5D", hash_generated_method = "3BAA7497F0414B8D9D56510DDB119646")
    private StringIndexOutOfBoundsException indexAndLength(int index) {
        addTaint(index);
    	throw new StringIndexOutOfBoundsException(count, index);

        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.256 -0400", hash_original_method = "ABFB3D9F0C982EE0B945F30A8DA651B2", hash_generated_method = "36B0B40AF5F4C672627A26D7C22A8FA1")
    private StringIndexOutOfBoundsException startEndAndLength(int start, int end) {
        addTaint(start);
        addTaint(end);
    	throw new StringIndexOutOfBoundsException(count, start, end - start);

        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.256 -0400", hash_original_method = "19BE941D07BAB030F14923AC484F383F", hash_generated_method = "A4BC5E807B63D7C8C1391905CAFB27D8")
    final void delete0(int start, int end) {
        {
            {
                end = count;
            } 
            {
                int length = count - end;
                {
                    {
                        System.arraycopy(value, end, value, start, length);
                    } 
                    {
                        char[] newData = new char[value.length];
                        System.arraycopy(value, 0, newData, 0, start);
                        System.arraycopy(value, end, newData, start, length);
                        value = newData;
                        shared = false;
                    } 
                } 
                count -= end - start;
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.257 -0400", hash_original_method = "54D305E0C27E04AE130B9F0D173AF3D5", hash_generated_method = "5A9466A43B1BD4B4EB5D4ED4B1DDAF39")
    final void deleteCharAt0(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } 
        int length = count - index - 1;
        {
            {
                System.arraycopy(value, index + 1, value, index, length);
            } 
            {
                char[] newData = new char[value.length];
                System.arraycopy(value, 0, newData, 0, index);
                System.arraycopy(value, index + 1, newData, index, length);
                value = newData;
                shared = false;
            } 
        } 
        addTaint(index);
        
        
            
        
        
        
            
                
            
                
                
                
                
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.257 -0400", hash_original_method = "DB245C34644491EEEAB0523333BD6692", hash_generated_method = "4974B42BB4F630F8E88E5DD5D87931F6")
    public void ensureCapacity(int min) {
        {
            int ourMin = value.length*2 + 2;
            enlargeBuffer(Math.max(ourMin, min));
        } 
        addTaint(min);
        
        
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.258 -0400", hash_original_method = "AE7F72EED3837594CFBBCCC4060D7909", hash_generated_method = "EFACE025E8162EED0314AFB1378DEF76")
    public void getChars(int start, int end, char[] dst, int dstStart) {
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } 
        System.arraycopy(value, start, dst, dstStart, end - start);
        addTaint(start);
        addTaint(end);
        addTaint(dst[0]);
        addTaint(dstStart);
        
        
            
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.258 -0400", hash_original_method = "93FE28F62EFBAB9F8EBF9F9ADC8E87C8", hash_generated_method = "747E3B3EAD654A711E65D4C34943D102")
    final void insert0(int index, char[] chars) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } 
        {
            move(chars.length, index);
            System.arraycopy(chars, 0, value, index, chars.length);
            count += chars.length;
        } 
        addTaint(index);
        
        
            
        
        
            
            
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.258 -0400", hash_original_method = "D46FA7C87DEEBA750439C9564B3FB7FE", hash_generated_method = "122DFF0189BB122D16DEC9C765BB8902")
    final void insert0(int index, char[] chars, int start, int length) {
        {
            {
                {
                    move(length, index);
                    System.arraycopy(chars, start, value, index, length);
                    count += length;
                } 
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException("this.length=" + count
                + "; index=" + index + "; chars.length=" + chars.length
                + "; start=" + start + "; length=" + length);
        addTaint(index);
        addTaint(chars[0]);
        addTaint(start);
        
        
            
                
                    
                    
                    
                
                
            
        
        
                
                
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.259 -0400", hash_original_method = "20DD23A1E6916CB9CC20932D676C3164", hash_generated_method = "93DA36F06271D08C4000CC7E13C7951D")
    final void insert0(int index, char ch) {
        {
            if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException(count, index);
        } 
        move(1, index);
        value[index] = ch;
        
        
            
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.259 -0400", hash_original_method = "9E8CB9B48D87CB2577EC00CC04D06833", hash_generated_method = "508FBEE7E7B9605B2E973F976B9912C7")
    final void insert0(int index, String string) {
        {
            {
                string = "null";
            } 
            int min = string.length();
            {
                move(min, index);
                string._getChars(0, min, value, index);
                count += min;
            } 
        } 
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } 
        addTaint(index);
        addTaint(string.getTaint());
        
        
            
                
            
            
            
                
                
                
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.259 -0400", hash_original_method = "10AE187E8F37FB4E725DAC6B12ECB82F", hash_generated_method = "C87AF22DD8F5589EB03367F50606F871")
    final void insert0(int index, CharSequence s, int start, int end) {
        {
            s = "null";
        } 
        {
            boolean var499DCA3E97A15B9D8FE01D782B7A07A5_1000953380 = ((index | start | end) < 0 || index > count || start > end || end > s.length());
            {
                if (DroidSafeAndroidRuntime.control) throw new IndexOutOfBoundsException();
            } 
        } 
        insert0(index, s.subSequence(start, end).toString());
        addTaint(index);
        addTaint(s.getTaint());
        addTaint(start);
        addTaint(end);
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.260 -0400", hash_original_method = "A4F75F4D0C7ABF3196500E489B73A8D4", hash_generated_method = "3D2E00475EEBB65E299EA251CF2638FD")
    public int length() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900160039 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_900160039;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.260 -0400", hash_original_method = "E2C445AFFEE441B211B71B3E0E3E89EA", hash_generated_method = "B27F799BAC4008415C71FEED6E68CC40")
    private void move(int size, int index) {
        int newCount;
        {
            {
                System.arraycopy(value, index, value, index + size, count - index);
            } 
            newCount = value.length;
        } 
        {
            newCount = Math.max(count + size, value.length*2 + 2);
        } 
        char[] newData = new char[newCount];
        System.arraycopy(value, 0, newData, 0, index);
        System.arraycopy(value, index, newData, index + size, count - index);
        value = newData;
        shared = false;
        addTaint(size);
        addTaint(index);
        
        
        
            
                
                
            
            
        
            
        
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.261 -0400", hash_original_method = "467233E9D0CCB909364F18BB14890489", hash_generated_method = "3D588D36173DC0E0F62BDE1B493F12F3")
    final void replace0(int start, int end, String string) {
        {
            {
                end = count;
            } 
            {
                int stringLength = string.length();
                int diff = end - start - stringLength;
                {
                    {
                        System.arraycopy(value, end, value, start
                                + stringLength, count - end);
                    } 
                    {
                        char[] newData = new char[value.length];
                        System.arraycopy(value, 0, newData, 0, start);
                        System.arraycopy(value, end, newData, start
                                + stringLength, count - end);
                        value = newData;
                        shared = false;
                    } 
                } 
                {
                    move(-diff, end);
                } 
                {
                    value = value.clone();
                    shared = false;
                } 
                string._getChars(0, stringLength, value, start);
                count -= diff;
            } 
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new NullPointerException();
                } 
                insert0(start, string);
            } 
        } 
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        addTaint(start);
        addTaint(end);
        addTaint(string.getTaint());
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.262 -0400", hash_original_method = "227A175682657414C42D64433DAB4FBA", hash_generated_method = "81AFD450AAFED00D2F91ACA86BE23BEC")
    final void reverse0() {
        {
            int end = count - 1;
            char frontHigh = value[0];
            char endLow = value[end];
            boolean allowFrontSur = true;
            boolean allowEndSur = true;
            {
                int i = 0;
                int mid = count / 2;
                {
                    char frontLow = value[i + 1];
                    char endHigh = value[end - 1];
                    boolean surAtFront = allowFrontSur && frontLow >= 0xdc00
                        && frontLow <= 0xdfff && frontHigh >= 0xd800
                        && frontHigh <= 0xdbff;
                    boolean surAtEnd = allowEndSur && endHigh >= 0xd800
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
                        } 
                        {
                            value[end] = frontHigh;
                            value[i] = endLow;
                            frontHigh = frontLow;
                            endLow = endHigh;
                        } 
                    } 
                    {
                        {
                            value[end] = frontLow;
                            value[i] = endLow;
                            endLow = endHigh;
                            allowFrontSur = false;
                        } 
                        {
                            value[end] = frontHigh;
                            value[i] = endHigh;
                            frontHigh = frontLow;
                            allowEndSur = false;
                        } 
                    } 
                } 
            } 
            {
                value[end] = allowFrontSur ? endLow : frontHigh;
            } 
        } 
        {
            char[] newData = new char[value.length];
            {
                int i = 0;
                int end = count;
                {
                    char high = value[i];
                    {
                        char low = value[i + 1];
                        {
                            newData[--end] = low;
                        } 
                    } 
                    newData[--end] = high;
                } 
            } 
            value = newData;
            shared = false;
        } 
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.263 -0400", hash_original_method = "5EFF2E769F54F3F7450C4FCC35538F65", hash_generated_method = "FED66A96D4FA84C46B96B468ED844BA6")
    public void setCharAt(int index, char ch) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } 
        {
            value = value.clone();
            shared = false;
        } 
        value[index] = ch;
        
        
            
        
        
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.265 -0400", hash_original_method = "CCD67F72D75D83378F17335F6F9DC00A", hash_generated_method = "49CC1925F2FFEDB4967C7B80E81952CA")
    public void setLength(int length) {
        {
            if (DroidSafeAndroidRuntime.control) throw new StringIndexOutOfBoundsException("length < 0: " + length);
        } 
        {
            enlargeBuffer(length);
        } 
        {
            {
                char[] newData = new char[value.length];
                System.arraycopy(value, 0, newData, 0, count);
                value = newData;
                shared = false;
            } 
            {
                {
                    Arrays.fill(value, count, length, (char) 0);
                } 
            } 
        } 
        count = length;
        
        
            
        
        
            
        
            
                
                
                
                
            
                
                    
                
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.267 -0400", hash_original_method = "1708C6B44328EC2FA5364A52800D811B", hash_generated_method = "B74081A692FCF834D733FC8E3F5618B5")
    public String substring(int start) {
        String varB4EAC82CA7396A68D541C85D26508E83_1113030639 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_792883667 = null; 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1113030639 = "";
            } 
            varB4EAC82CA7396A68D541C85D26508E83_792883667 = new String(value, start, count - start);
        } 
        if (DroidSafeAndroidRuntime.control) throw indexAndLength(start);
        addTaint(start);
        String varA7E53CE21691AB073D9660D615818899_840613831; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_840613831 = varB4EAC82CA7396A68D541C85D26508E83_1113030639;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_840613831 = varB4EAC82CA7396A68D541C85D26508E83_792883667;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_840613831.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_840613831;
        
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.268 -0400", hash_original_method = "7121FB14814A84CA4ADE1E9CCF3D54F6", hash_generated_method = "ABD34F8B873353217C25C096755D69D1")
    public String substring(int start, int end) {
        String varB4EAC82CA7396A68D541C85D26508E83_1143681701 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1852725811 = null; 
        {
            {
                varB4EAC82CA7396A68D541C85D26508E83_1143681701 = "";
            } 
            varB4EAC82CA7396A68D541C85D26508E83_1852725811 = new String(value, start, end - start);
        } 
        if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        addTaint(start);
        addTaint(end);
        String varA7E53CE21691AB073D9660D615818899_813268455; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_813268455 = varB4EAC82CA7396A68D541C85D26508E83_1143681701;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_813268455 = varB4EAC82CA7396A68D541C85D26508E83_1852725811;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_813268455.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_813268455;
        
        
            
                
            
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.272 -0400", hash_original_method = "F5CABA8208B35CC620F77C4ED2D48018", hash_generated_method = "44E7D22F20C346A8DB7D4EAB4C3355DA")
    @Override
    public String toString() {
        String varB4EAC82CA7396A68D541C85D26508E83_552565968 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_779347586 = null; 
        String varB4EAC82CA7396A68D541C85D26508E83_1209895418 = null; 
        {
            varB4EAC82CA7396A68D541C85D26508E83_552565968 = "";
        } 
        int wasted = value.length - count;
        {
            varB4EAC82CA7396A68D541C85D26508E83_779347586 = new String(value, 0, count);
        } 
        shared = true;
        varB4EAC82CA7396A68D541C85D26508E83_1209895418 = new String(0, count, value);
        String varA7E53CE21691AB073D9660D615818899_1878953408; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_1878953408 = varB4EAC82CA7396A68D541C85D26508E83_552565968;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_1878953408 = varB4EAC82CA7396A68D541C85D26508E83_779347586;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1878953408 = varB4EAC82CA7396A68D541C85D26508E83_1209895418;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1878953408.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_1878953408;
        
        
            
        
        
        
                
            
        
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.274 -0400", hash_original_method = "30B2B5AAE6BF00B7B5DE2415CD1C93C0", hash_generated_method = "828D03D36AA8950743C1848E8C0149DC")
    public CharSequence subSequence(int start, int end) {
        CharSequence varB4EAC82CA7396A68D541C85D26508E83_1869022707 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_1869022707 = substring(start, end);
        addTaint(start);
        addTaint(end);
        varB4EAC82CA7396A68D541C85D26508E83_1869022707.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_1869022707;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.275 -0400", hash_original_method = "7103B0EDA0D88809AB4D74CA424F106F", hash_generated_method = "9F98CDC5D466585748BE49E956BFDE0C")
    public int indexOf(String string) {
        int var69BB5E01AE8CE71924DBD4CF1DEEFE55_1586468505 = (indexOf(string, 0));
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628942115 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1628942115;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.278 -0400", hash_original_method = "58EF09653819A20604D2729AAEA1E73D", hash_generated_method = "F53B3EFBE4A5CA2FCEBC3ACF581B6FD3")
    public int indexOf(String subString, int start) {
        {
            start = 0;
        } 
        int subCount = subString.length();
        {
            char firstChar = subString.charAt(0);
            {
                int i = start;
                boolean found = false;
                {
                    {
                        found = true;
                    } 
                } 
                int o1 = i;
                int o2 = 0;
                {
                    boolean var07F0F34C78F832D4432771EF4DCEE186_513617000 = (++o2 < subCount && value[++o1] == subString.charAt(o2));
                } 
                start = i + 1;
            } 
        } 
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988798079 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_988798079;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.280 -0400", hash_original_method = "692347B4AF93950259A2DA740A39B258", hash_generated_method = "C567B83012CCE55A20E51905A4A6F561")
    public int lastIndexOf(String string) {
        int var629483EEC7DE422E0B8E730771A3942E_435148119 = (lastIndexOf(string, count));
        addTaint(string.getTaint());
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907314363 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1907314363;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.281 -0400", hash_original_method = "7130CA0E46A667075374433A3B5D2D85", hash_generated_method = "A83B4309653706AF5A9B8927B1BEC3A7")
    public int lastIndexOf(String subString, int start) {
        int subCount = subString.length();
        {
            {
                {
                    start = count - subCount;
                } 
                char firstChar = subString.charAt(0);
                {
                    int i = start;
                    boolean found = false;
                    {
                        {
                            found = true;
                        } 
                    } 
                    int o1 = i;
                    int o2 = 0;
                    {
                        boolean varC6F1A2D739E8E9688B6BA89C00E8647F_807160849 = (++o2 < subCount
                            && value[++o1] == subString.charAt(o2));
                    } 
                    start = i - 1;
                } 
            } 
        } 
        addTaint(subString.getTaint());
        addTaint(start);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693524608 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_693524608;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.282 -0400", hash_original_method = "DFFDB9C5FDBA0FB3D8B8BAEB0765C9A3", hash_generated_method = "E5441FC42630F2A23137023FF8AABA56")
    public void trimToSize() {
        {
            char[] newValue = new char[count];
            System.arraycopy(value, 0, newValue, 0, count);
            value = newValue;
            shared = false;
        } 
        
        
            
            
            
            
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.282 -0400", hash_original_method = "E01C43C5D144342C7BDF51C53F549AB8", hash_generated_method = "03649048C7230FB3C3DD2A34C58D6F17")
    public int codePointAt(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } 
        int var754C26F5C1DC59BD50BDC20E577E9886_535117968 = (Character.codePointAt(value, index, count));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056852966 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1056852966;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.283 -0400", hash_original_method = "F58237612B89D3EA2A0CCEABA41468D6", hash_generated_method = "2F9ABBF064A933EB647FB8EA143757AC")
    public int codePointBefore(int index) {
        {
            if (DroidSafeAndroidRuntime.control) throw indexAndLength(index);
        } 
        int var47513E82D5F330EECEA70775E6161519_1638395635 = (Character.codePointBefore(value, index));
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789141520 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1789141520;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.283 -0400", hash_original_method = "012FBC57A3E4CD6B3DAD71A54F843207", hash_generated_method = "EC039B117D3B24A8A155D8B7F53FE3A9")
    public int codePointCount(int start, int end) {
        {
            if (DroidSafeAndroidRuntime.control) throw startEndAndLength(start, end);
        } 
        int var3CCF693878924901A110D91C3295E7F1_339186399 = (Character.codePointCount(value, start, end - start));
        addTaint(start);
        addTaint(end);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013246499 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1013246499;
        
        
            
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.284 -0400", hash_original_method = "AC95F45AA90228D3C037EE242B5DE1AD", hash_generated_method = "7AF2CEB27825C8A14AE3D33AFC007076")
    public int offsetByCodePoints(int index, int codePointOffset) {
        int var8106FFBFDD8426C615EB8F94705A68B6_304278731 = (Character.offsetByCodePoints(value, 0, count, index,
                codePointOffset));
        addTaint(index);
        addTaint(codePointOffset);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_957135004 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_957135004;
        
        
                
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:49.284 -0400", hash_original_field = "60E8041D14101DDB569AC77FCB6B5097", hash_generated_field = "737C5532807A143D11A79A7148513E52")

    static final int INITIAL_CAPACITY = 16;
}

