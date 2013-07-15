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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.484 -0400", hash_original_field = "DACC316D060F4EC4A159A2F45A706659", hash_generated_field = "ED2D30C35903F5702DFA6B6B053F7D87")

    private double[] choiceLimits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.484 -0400", hash_original_field = "D7BA0E5ACC5078784279CE94B525E7CC", hash_generated_field = "05C2A4AC24967E0A070ABD8FDE0D9A95")

    private String[] choiceFormats;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.484 -0400", hash_original_method = "6AA98ECEF055DFD6530181EFB704802A", hash_generated_method = "ACD028F8EA6BC8E69CA309C91F48773D")
    public  ChoiceFormat(double[] limits, String[] formats) {
        addTaint(formats[0].getTaint());
        addTaint(limits[0]);
        setChoices(limits, formats);
        // ---------- Original Method ----------
        //setChoices(limits, formats);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.485 -0400", hash_original_method = "7A22DFD5F0C8BF76D2134AD604327DD6", hash_generated_method = "93C351C34DF6315C36BF2170EFF4591B")
    public  ChoiceFormat(String template) {
        addTaint(template.getTaint());
        applyPattern(template);
        // ---------- Original Method ----------
        //applyPattern(template);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.487 -0400", hash_original_method = "61054E3E36618E298A5F058604E71A93", hash_generated_method = "5E5CC576179BDD11A5072FC090211519")
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
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1558968244 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1558968244.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1558968244;
}    if(limitCount > 0 && next <= limits[limitCount - 1])            
            {
                IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_295993073 = new IllegalArgumentException();
                var5783EF97022AA508B74A1E3EA38534AF_295993073.addTaint(taint);
                throw var5783EF97022AA508B74A1E3EA38534AF_295993073;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.488 -0400", hash_original_method = "0E78DE057CBD16D1EEA99DBEA20DA3A1", hash_generated_method = "DC5C6A00F20B4637A78CC7060A34BD9F")
    @Override
    public Object clone() {
        ChoiceFormat clone = (ChoiceFormat) super.clone();
        clone.choiceLimits = choiceLimits.clone();
        clone.choiceFormats = choiceFormats.clone();
Object var3DE52045BFD3C1BF3742F994ED6139AD_1060535345 =         clone;
        var3DE52045BFD3C1BF3742F994ED6139AD_1060535345.addTaint(taint);
        return var3DE52045BFD3C1BF3742F994ED6139AD_1060535345;
        // ---------- Original Method ----------
        //ChoiceFormat clone = (ChoiceFormat) super.clone();
        //clone.choiceLimits = choiceLimits.clone();
        //clone.choiceFormats = choiceFormats.clone();
        //return clone;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.489 -0400", hash_original_method = "F2D7C03023A3AAC9DFCE95AB2EC2A780", hash_generated_method = "3E193EC63040FAB116FA8618BE0BF1C3")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
    if(this == object)        
        {
            boolean varB326B5062B2F0E69046810717534CB09_1494676602 = (true);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1350009709 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1350009709;
        } //End block
    if(!(object instanceof ChoiceFormat))        
        {
            boolean var68934A3E9455FA72420237EB05902327_154767361 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_128411019 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_128411019;
        } //End block
        ChoiceFormat choice = (ChoiceFormat) object;
        boolean var005FB9FA5E826A7CF1459954E52AFD49_904883650 = (Arrays.equals(choiceLimits, choice.choiceLimits)
                && Arrays.equals(choiceFormats, choice.choiceFormats));
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_681654948 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_681654948;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.489 -0400", hash_original_method = "BC91D466505972771C623F66D301FB6D", hash_generated_method = "43E47CA2DE420B0DD6EACBEACFDA20F2")
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
StringBuffer var823D14912D47E8CD0140C8216D616435_942790989 =                 buffer.append(choiceFormats[i]);
                var823D14912D47E8CD0140C8216D616435_942790989.addTaint(taint);
                return var823D14912D47E8CD0140C8216D616435_942790989;
            } //End block
        } //End block
StringBuffer varFE1AF0FC425B0517A12FB0D99DC93E0B_64160906 =         choiceFormats.length == 0 ? buffer : buffer
                .append(choiceFormats[0]);
        varFE1AF0FC425B0517A12FB0D99DC93E0B_64160906.addTaint(taint);
        return varFE1AF0FC425B0517A12FB0D99DC93E0B_64160906;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.490 -0400", hash_original_method = "F9B960B049B919C822FEECA2E3BD7537", hash_generated_method = "33B6B00C86C3CD6550E61FEA4C922550")
    @Override
    public StringBuffer format(long value, StringBuffer buffer,
            FieldPosition field) {
        addTaint(field.getTaint());
        addTaint(buffer.getTaint());
        addTaint(value);
StringBuffer var4279DFD88F47264B789C0548FD6DCA8B_1690290145 =         format((double) value, buffer, field);
        var4279DFD88F47264B789C0548FD6DCA8B_1690290145.addTaint(taint);
        return var4279DFD88F47264B789C0548FD6DCA8B_1690290145;
        // ---------- Original Method ----------
        //return format((double) value, buffer, field);
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.490 -0400", hash_original_method = "989D9CABCA800EE4DFA0CFCD3DE77FA9", hash_generated_method = "22F08E8B06568AB38688B00B94299A46")
    public Object[] getFormats() {
Object[] var90D971D276260C19EE1F729DAA26FA65_1303755815 =         choiceFormats;
        var90D971D276260C19EE1F729DAA26FA65_1303755815.addTaint(taint);
        return var90D971D276260C19EE1F729DAA26FA65_1303755815;
        // ---------- Original Method ----------
        //return choiceFormats;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.491 -0400", hash_original_method = "290809530CC76A10C33738C53A5176B9", hash_generated_method = "70AB6D339E61076A876F78535EC3D737")
    public double[] getLimits() {
        double[] varDACC316D060F4EC4A159A2F45A706659_893396536 = (choiceLimits);
                double[] var74D44D7D9EE6FE6C3433D694F869E521_1672430050 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_1672430050;
        // ---------- Original Method ----------
        //return choiceLimits;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.492 -0400", hash_original_method = "9AF9F658465E6920280B1655C8022A86", hash_generated_method = "9A89529794BC014670625A4B07DFBCEA")
    @Override
    public int hashCode() {
        int hashCode = 0;
for(int i = 0;i < choiceLimits.length;i++)
        {
            long v = Double.doubleToLongBits(choiceLimits[i]);
            hashCode += (int) (v ^ (v >>> 32)) + choiceFormats[i].hashCode();
        } //End block
        int var550D1CC054A1B23A411DDDA46FD64811_375608775 = (hashCode);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025721952 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2025721952;
        // ---------- Original Method ----------
        //int hashCode = 0;
        //for (int i = 0; i < choiceLimits.length; i++) {
            //long v = Double.doubleToLongBits(choiceLimits[i]);
            //hashCode += (int) (v ^ (v >>> 32)) + choiceFormats[i].hashCode();
        //}
        //return hashCode;
    }

    
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.493 -0400", hash_original_method = "609F300632C6A9AB79113AF961C366BC", hash_generated_method = "939EC569AD39D4DD5F0B164573DE4975")
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
Number varE40049941127811A3AE44408CE935228_343958511 =                 new Double(choiceLimits[i]);
                varE40049941127811A3AE44408CE935228_343958511.addTaint(taint);
                return varE40049941127811A3AE44408CE935228_343958511;
            } //End block
        } //End block
        position.setErrorIndex(offset);
Number var96FCA40988E63EBA31357867B6B325E4_1901631751 =         new Double(Double.NaN);
        var96FCA40988E63EBA31357867B6B325E4_1901631751.addTaint(taint);
        return var96FCA40988E63EBA31357867B6B325E4_1901631751;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.494 -0400", hash_original_method = "A68DB2E05654867D5DABBF703FA90F00", hash_generated_method = "B3EC702E4C4F0F80A44FF1B1CA9FFC7A")
    public void setChoices(double[] limits, String[] formats) {
    if(limits.length != formats.length)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1398585918 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1398585918.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1398585918;
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
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.495 -0400", hash_original_method = "55E8B28E1CF4E8D52478B124E3FA683B", hash_generated_method = "78F287CD151E72BBA19A982A56EC7AE7")
    private int skipWhitespace(String string, int index) {
        addTaint(index);
        addTaint(string.getTaint());
        int length = string.length();
        while
(index < length && Character.isWhitespace(string.charAt(index)))        
        {
            index++;
        } //End block
        int var6A992D5529F459A44FEE58C733255E86_685670151 = (index);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776357754 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_776357754;
        // ---------- Original Method ----------
        //int length = string.length();
        //while (index < length && Character.isWhitespace(string.charAt(index))) {
            //index++;
        //}
        //return index;
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.495 -0400", hash_original_method = "C892C3517E889BA7A99732103703F353", hash_generated_method = "9CBAA547562301706CCC9F87FDC0F224")
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
String varD03843288D33B9E1D3062E25339ECF6D_561770123 =         buffer.toString();
        varD03843288D33B9E1D3062E25339ECF6D_561770123.addTaint(taint);
        return varD03843288D33B9E1D3062E25339ECF6D_561770123;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:59.496 -0400", hash_original_field = "F0E5953C1F171C3A96BC62E66787D9C2", hash_generated_field = "74F3624CBC64496D38F62E5EDD514F89")

    private static final long serialVersionUID = 1795184449645032964L;
}

