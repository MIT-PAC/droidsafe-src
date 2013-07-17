package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import libcore.util.EmptyArray;

public class ChoiceFormat extends NumberFormat {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.634 -0400", hash_original_field = "DACC316D060F4EC4A159A2F45A706659", hash_generated_field = "ED2D30C35903F5702DFA6B6B053F7D87")

    private double[] choiceLimits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.635 -0400", hash_original_field = "D7BA0E5ACC5078784279CE94B525E7CC", hash_generated_field = "05C2A4AC24967E0A070ABD8FDE0D9A95")

    private String[] choiceFormats;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.635 -0400", hash_original_method = "6AA98ECEF055DFD6530181EFB704802A", hash_generated_method = "ACD028F8EA6BC8E69CA309C91F48773D")
    public  ChoiceFormat(double[] limits, String[] formats) {
        addTaint(formats[0].getTaint());
        addTaint(limits[0]);
        setChoices(limits, formats);
        // ---------- Original Method ----------
        //setChoices(limits, formats);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.635 -0400", hash_original_method = "7A22DFD5F0C8BF76D2134AD604327DD6", hash_generated_method = "93C351C34DF6315C36BF2170EFF4591B")
    public  ChoiceFormat(String template) {
        addTaint(template.getTaint());
        applyPattern(template);
        // ---------- Original Method ----------
        //applyPattern(template);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.636 -0400", hash_original_method = "61054E3E36618E298A5F058604E71A93", hash_generated_method = "3276D0B32904627097A6783CDD31BFFE")
    public void applyPattern(String template) {
        addTaint(template.getTaint());
        double[] limits = new double[5];
        List<String> formats = new ArrayList<String>();
        int length = template.length();
        int limitCount = 0;
        int index = 0;
        StringBuffer buffer = new StringBuffer();
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        ParsePosition position = new ParsePosition(0);
        while
(true)        
        {
            index = skipWhitespace(template, index);
            if(index >= length)            
            {
                if(limitCount == limits.length)                
                {
                    choiceLimits = limits;
                } //End block
                else
                {
                    choiceLimits = new double[limitCount];
                    System.arraycopy(limits, 0, choiceLimits, 0, limitCount);
                } //End block
                choiceFormats = new String[formats.size()];
for(int i = 0;i < formats.size();i++)
                {
                    choiceFormats[i] = formats.get(i);
                } //End block
                return;
            } //End block
            position.setIndex(index);
            Number value = format.parse(template, position);
            index = skipWhitespace(template, position.getIndex());
            if(position.getErrorIndex() != -1 || index >= length)            
            {
                choiceLimits = EmptyArray.DOUBLE;
                choiceFormats = EmptyArray.STRING;
                return;
            } //End block
            char ch = template.charAt(index++);
            if(limitCount == limits.length)            
            {
                double[] newLimits = new double[limitCount * 2];
                System.arraycopy(limits, 0, newLimits, 0, limitCount);
                limits = newLimits;
            } //End block
            double next;
switch(ch){
            case '#':
            case '\u2264':
            next = value.doubleValue();
            break;
            case '<':
            next = nextDouble(value.doubleValue());
            break;
            default:
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1002919967 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1002919967.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1002919967;
}            if(limitCount > 0 && next <= limits[limitCount - 1])            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_583617381 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_583617381.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_583617381;
            } //End block
            buffer.setLength(0);
            position.setIndex(index);
            upTo(template, position, buffer, '|');
            index = position.getIndex();
            limits[limitCount++] = next;
            formats.add(buffer.toString());
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.637 -0400", hash_original_method = "0E78DE057CBD16D1EEA99DBEA20DA3A1", hash_generated_method = "1B16F688A1C217EE0CD138582B393132")
    @Override
    public Object clone() {
        ChoiceFormat clone = (ChoiceFormat) super.clone();
        clone.choiceLimits = choiceLimits.clone();
        clone.choiceFormats = choiceFormats.clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_1984396279 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1984396279.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1984396279;
        // ---------- Original Method ----------
        //ChoiceFormat clone = (ChoiceFormat) super.clone();
        //clone.choiceLimits = choiceLimits.clone();
        //clone.choiceFormats = choiceFormats.clone();
        //return clone;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.637 -0400", hash_original_method = "F2D7C03023A3AAC9DFCE95AB2EC2A780", hash_generated_method = "341CECDF0F25EB48F97E5E1DC5C6F173")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_656906338 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1957504015 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1957504015;
        } //End block
        if(!(object instanceof ChoiceFormat))        
        {
            boolean var68934A3E9455FA72420237EB05902327_1805702305 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_25899027 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_25899027;
        } //End block
        ChoiceFormat choice = (ChoiceFormat) object;
        boolean var005FB9FA5E826A7CF1459954E52AFD49_1836123611 = (Arrays.equals(choiceLimits, choice.choiceLimits)
                && Arrays.equals(choiceFormats, choice.choiceFormats));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1299765885 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1299765885;
        // ---------- Original Method ----------
        //if (this == object) {
            //return true;
        //}
        //if (!(object instanceof ChoiceFormat)) {
            //return false;
        //}
        //ChoiceFormat choice = (ChoiceFormat) object;
        //return Arrays.equals(choiceLimits, choice.choiceLimits)
                //&& Arrays.equals(choiceFormats, choice.choiceFormats);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.638 -0400", hash_original_method = "BC91D466505972771C623F66D301FB6D", hash_generated_method = "933F219BF500304D2C042494E01921BA")
    @Override
    public StringBuffer format(double value, StringBuffer buffer,
            FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(buffer.getTaint());
        addTaint(value);
for(int i = choiceLimits.length - 1;i >= 0;i--)
        {
            if(choiceLimits[i] <= value)            
            {
StringBuffer var823D14912D47E8CD0140C8216D616435_1353894431 =                 buffer.append(choiceFormats[i]);
                var823D14912D47E8CD0140C8216D616435_1353894431.addTaint(taint);
                return var823D14912D47E8CD0140C8216D616435_1353894431;
            } //End block
        } //End block
StringBuffer varFE1AF0FC425B0517A12FB0D99DC93E0B_1496774563 =         choiceFormats.length == 0 ? buffer : buffer
                .append(choiceFormats[0]);
        varFE1AF0FC425B0517A12FB0D99DC93E0B_1496774563.addTaint(taint);
        return varFE1AF0FC425B0517A12FB0D99DC93E0B_1496774563;
        // ---------- Original Method ----------
        //for (int i = choiceLimits.length - 1; i >= 0; i--) {
            //if (choiceLimits[i] <= value) {
                //return buffer.append(choiceFormats[i]);
            //}
        //}
        //return choiceFormats.length == 0 ? buffer : buffer
                //.append(choiceFormats[0]);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.639 -0400", hash_original_method = "F9B960B049B919C822FEECA2E3BD7537", hash_generated_method = "2A47C268B11F1FA463CAC92BC7A10026")
    @Override
    public StringBuffer format(long value, StringBuffer buffer,
            FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(buffer.getTaint());
        addTaint(value);
StringBuffer var4279DFD88F47264B789C0548FD6DCA8B_1255246722 =         format((double) value, buffer, field);
        var4279DFD88F47264B789C0548FD6DCA8B_1255246722.addTaint(taint);
        return var4279DFD88F47264B789C0548FD6DCA8B_1255246722;
        // ---------- Original Method ----------
        //return format((double) value, buffer, field);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.639 -0400", hash_original_method = "989D9CABCA800EE4DFA0CFCD3DE77FA9", hash_generated_method = "D31BA24041C8B9EB779BDEC31649F3AE")
    public Object[] getFormats() {
Object[] var90D971D276260C19EE1F729DAA26FA65_1300820016 =         choiceFormats;
        var90D971D276260C19EE1F729DAA26FA65_1300820016.addTaint(taint);
        return var90D971D276260C19EE1F729DAA26FA65_1300820016;
        // ---------- Original Method ----------
        //return choiceFormats;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.640 -0400", hash_original_method = "290809530CC76A10C33738C53A5176B9", hash_generated_method = "A1040F742976F93EF9DE4B06E84DBA50")
    public double[] getLimits() {
        double[] varDACC316D060F4EC4A159A2F45A706659_878752457 = (choiceLimits);
                double[] var74D44D7D9EE6FE6C3433D694F869E521_1304268599 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_1304268599;
        // ---------- Original Method ----------
        //return choiceLimits;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.640 -0400", hash_original_method = "9AF9F658465E6920280B1655C8022A86", hash_generated_method = "A797DD81898178167E4131EDBA4174B8")
    @Override
    public int hashCode() {
        int hashCode = 0;
for(int i = 0;i < choiceLimits.length;i++)
        {
            long v = Double.doubleToLongBits(choiceLimits[i]);
            hashCode += (int) (v ^ (v >>> 32)) + choiceFormats[i].hashCode();
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_2094684935 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407888930 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_407888930;
        // ---------- Original Method ----------
        //int hashCode = 0;
        //for (int i = 0; i < choiceLimits.length; i++) {
            //long v = Double.doubleToLongBits(choiceLimits[i]);
            //hashCode += (int) (v ^ (v >>> 32)) + choiceFormats[i].hashCode();
        //}
        //return hashCode;
    }

    
    @DSModeled(DSC.SAFE)
    public static final double nextDouble(double value) {
        if (value == Double.POSITIVE_INFINITY) {
            return value;
        }
        long bits;
        if (value == 0) {
            bits = 0;
        } else {
            bits = Double.doubleToLongBits(value);
        }
        return Double.longBitsToDouble(value < 0 ? bits - 1 : bits + 1);
    }

    
    @DSModeled(DSC.SAFE)
    public static double nextDouble(double value, boolean increment) {
        return increment ? nextDouble(value) : previousDouble(value);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.641 -0400", hash_original_method = "609F300632C6A9AB79113AF961C366BC", hash_generated_method = "4FBC165F19D62B6CC94CD762EDC97812")
    @Override
    public Number parse(String string, ParsePosition position) {
        addTaint(position.getTaint());
        addTaint(string.getTaint());
        int offset = position.getIndex();
for(int i = 0;i < choiceFormats.length;i++)
        {
            if(string.startsWith(choiceFormats[i], offset))            
            {
                position.setIndex(offset + choiceFormats[i].length());
Number varE40049941127811A3AE44408CE935228_665703364 =                 new Double(choiceLimits[i]);
                varE40049941127811A3AE44408CE935228_665703364.addTaint(taint);
                return varE40049941127811A3AE44408CE935228_665703364;
            } //End block
        } //End block
        position.setErrorIndex(offset);
Number var96FCA40988E63EBA31357867B6B325E4_482790010 =         new Double(Double.NaN);
        var96FCA40988E63EBA31357867B6B325E4_482790010.addTaint(taint);
        return var96FCA40988E63EBA31357867B6B325E4_482790010;
        // ---------- Original Method ----------
        //int offset = position.getIndex();
        //for (int i = 0; i < choiceFormats.length; i++) {
            //if (string.startsWith(choiceFormats[i], offset)) {
                //position.setIndex(offset + choiceFormats[i].length());
                //return new Double(choiceLimits[i]);
            //}
        //}
        //position.setErrorIndex(offset);
        //return new Double(Double.NaN);
    }

    
    @DSModeled(DSC.SAFE)
    public static final double previousDouble(double value) {
        if (value == Double.NEGATIVE_INFINITY) {
            return value;
        }
        long bits;
        if (value == 0) {
            bits = 0x8000000000000000L;
        } else {
            bits = Double.doubleToLongBits(value);
        }
        return Double.longBitsToDouble(value <= 0 ? bits + 1 : bits - 1);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.642 -0400", hash_original_method = "A68DB2E05654867D5DABBF703FA90F00", hash_generated_method = "AB781FA5D50397AA65072903CD8FB689")
    public void setChoices(double[] limits, String[] formats) {
        if(limits.length != formats.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_570888823 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_570888823.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_570888823;
        } //End block
        choiceLimits = limits;
        choiceFormats = formats;
        // ---------- Original Method ----------
        //if (limits.length != formats.length) {
            //throw new IllegalArgumentException();
        //}
        //choiceLimits = limits;
        //choiceFormats = formats;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.643 -0400", hash_original_method = "55E8B28E1CF4E8D52478B124E3FA683B", hash_generated_method = "46A59EEE358E4109016C95E4A36E8D38")
    private int skipWhitespace(String string, int index) {
        addTaint(index);
        addTaint(string.getTaint());
        int length = string.length();
        while
(index < length && Character.isWhitespace(string.charAt(index)))        
        {
            index++;
        } //End block
        int var6A992D5529F459A44FEE58C733255E86_370846706 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767811944 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1767811944;
        // ---------- Original Method ----------
        //int length = string.length();
        //while (index < length && Character.isWhitespace(string.charAt(index))) {
            //index++;
        //}
        //return index;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.643 -0400", hash_original_method = "C892C3517E889BA7A99732103703F353", hash_generated_method = "74A3C8EAC6862739DE980F055539B2A6")
    public String toPattern() {
        StringBuilder buffer = new StringBuilder();
for(int i = 0;i < choiceLimits.length;i++)
        {
            if(i != 0)            
            {
                buffer.append('|');
            } //End block
            String previous = String.valueOf(previousDouble(choiceLimits[i]));
            String limit = String.valueOf(choiceLimits[i]);
            if(previous.length() < limit.length())            
            {
                buffer.append(previous);
                buffer.append('<');
            } //End block
            else
            {
                buffer.append(limit);
                buffer.append('#');
            } //End block
            boolean quote = (choiceFormats[i].indexOf('|') != -1);
            if(quote)            
            {
                buffer.append('\'');
            } //End block
            buffer.append(choiceFormats[i]);
            if(quote)            
            {
                buffer.append('\'');
            } //End block
        } //End block
String varD03843288D33B9E1D3062E25339ECF6D_2138926499 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_2138926499.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_2138926499;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:56.643 -0400", hash_original_field = "F0E5953C1F171C3A96BC62E66787D9C2", hash_generated_field = "74F3624CBC64496D38F62E5EDD514F89")

    private static final long serialVersionUID = 1795184449645032964L;
}

