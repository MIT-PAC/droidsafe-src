package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import libcore.util.EmptyArray;

public class ChoiceFormat extends NumberFormat {
    private double[] choiceLimits;
    private String[] choiceFormats;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.866 -0400", hash_original_method = "6AA98ECEF055DFD6530181EFB704802A", hash_generated_method = "1FB3AE0D65009459259FF0E177EA9A15")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ChoiceFormat(double[] limits, String[] formats) {
        dsTaint.addTaint(limits[0]);
        dsTaint.addTaint(formats[0]);
        setChoices(limits, formats);
        // ---------- Original Method ----------
        //setChoices(limits, formats);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.866 -0400", hash_original_method = "7A22DFD5F0C8BF76D2134AD604327DD6", hash_generated_method = "CFB309C45D142C7770C17D46E33D60F3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public ChoiceFormat(String template) {
        dsTaint.addTaint(template);
        applyPattern(template);
        // ---------- Original Method ----------
        //applyPattern(template);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.867 -0400", hash_original_method = "61054E3E36618E298A5F058604E71A93", hash_generated_method = "7EBAC1D27BF962132095FFE2144C22E4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void applyPattern(String template) {
        dsTaint.addTaint(template);
        double[] limits;
        limits = new double[5];
        List<String> formats;
        formats = new ArrayList<String>();
        int length, limitCount, index;
        length = template.length();
        limitCount = 0;
        index = 0;
        StringBuffer buffer;
        buffer = new StringBuffer();
        NumberFormat format;
        format = NumberFormat.getInstance(Locale.US);
        ParsePosition position;
        position = new ParsePosition(0);
        {
            index = skipWhitespace(template, index);
            {
                {
                    choiceLimits = limits;
                } //End block
                {
                    choiceLimits = new double[limitCount];
                    System.arraycopy(limits, 0, choiceLimits, 0, limitCount);
                } //End block
                choiceFormats = new String[formats.size()];
                {
                    int i;
                    i = 0;
                    boolean var12C1132047B83F5C7F42C3880F3580DA_1239286230 = (i < formats.size());
                    {
                        choiceFormats[i] = formats.get(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            position.setIndex(index);
            Number value;
            value = format.parse(template, position);
            index = skipWhitespace(template, position.getIndex());
            {
                boolean var803A7BE3FF440C6FB2756CCD8D3C4347_1925716118 = (position.getErrorIndex() != -1 || index >= length);
                {
                    choiceLimits = EmptyArray.DOUBLE;
                    choiceFormats = EmptyArray.STRING;
                } //End block
            } //End collapsed parenthetic
            char ch;
            ch = template.charAt(index++);
            {
                double[] newLimits;
                newLimits = new double[limitCount * 2];
                System.arraycopy(limits, 0, newLimits, 0, limitCount);
                limits = newLimits;
            } //End block
            double next;
            //Begin case '#' '\u2264' 
            next = value.doubleValue();
            //End case '#' '\u2264' 
            //Begin case '<' 
            next = nextDouble(value.doubleValue());
            //End case '<' 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
            //End case default 
            {
                if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.868 -0400", hash_original_method = "0E78DE057CBD16D1EEA99DBEA20DA3A1", hash_generated_method = "E6DE24A9910A78C42B78F22599150169")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        ChoiceFormat clone;
        clone = (ChoiceFormat) super.clone();
        clone.choiceLimits = choiceLimits.clone();
        clone.choiceFormats = choiceFormats.clone();
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //ChoiceFormat clone = (ChoiceFormat) super.clone();
        //clone.choiceLimits = choiceLimits.clone();
        //clone.choiceFormats = choiceFormats.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.868 -0400", hash_original_method = "F2D7C03023A3AAC9DFCE95AB2EC2A780", hash_generated_method = "0C8F7571B8056A746352F8EB5044CD46")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public boolean equals(Object object) {
        dsTaint.addTaint(object.dsTaint);
        ChoiceFormat choice;
        choice = (ChoiceFormat) object;
        boolean varA782AEC7A8869A4A0890C9A206DC5B39_447995663 = (Arrays.equals(choiceLimits, choice.choiceLimits)
                && Arrays.equals(choiceFormats, choice.choiceFormats));
        return dsTaint.getTaintBoolean();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.870 -0400", hash_original_method = "BC91D466505972771C623F66D301FB6D", hash_generated_method = "52E85CDB186FB1F90DC915E85E523359")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringBuffer format(double value, StringBuffer buffer,
            FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(value);
        {
            int i;
            i = choiceLimits.length - 1;
            {
                {
                    StringBuffer var0FB70E6725D13213A0A2457ADA670B24_1985199071 = (buffer.append(choiceFormats[i]));
                } //End block
            } //End block
        } //End collapsed parenthetic
        {
            Object var8C9406EC328442943C16BDCB8044670C_1546991072 = (buffer
                .append(choiceFormats[0]));
        } //End flattened ternary
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //for (int i = choiceLimits.length - 1; i >= 0; i--) {
            //if (choiceLimits[i] <= value) {
                //return buffer.append(choiceFormats[i]);
            //}
        //}
        //return choiceFormats.length == 0 ? buffer : buffer
                //.append(choiceFormats[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.870 -0400", hash_original_method = "F9B960B049B919C822FEECA2E3BD7537", hash_generated_method = "5D0880C4715B1E4B4795A30C8096A250")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public StringBuffer format(long value, StringBuffer buffer,
            FieldPosition field) {
        dsTaint.addTaint(field.dsTaint);
        dsTaint.addTaint(buffer.dsTaint);
        dsTaint.addTaint(value);
        StringBuffer varBD915CAAB113C83EBB95D84C416D99DB_1740910832 = (format((double) value, buffer, field));
        return (StringBuffer)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return format((double) value, buffer, field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.870 -0400", hash_original_method = "989D9CABCA800EE4DFA0CFCD3DE77FA9", hash_generated_method = "8F3EF0C28FB9346DDFD9936B342025A7")
    @DSModeled(DSC.SAFE)
    public Object[] getFormats() {
        return (Object[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //return choiceFormats;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.871 -0400", hash_original_method = "290809530CC76A10C33738C53A5176B9", hash_generated_method = "F2BE9583DC1500B8311F9D34FB4FEB3F")
    @DSModeled(DSC.SAFE)
    public double[] getLimits() {
        double[] retVal = new double[1];
        retVal[0] = dsTaint.getTaintFloat();
        return retVal;
        // ---------- Original Method ----------
        //return choiceLimits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.871 -0400", hash_original_method = "9AF9F658465E6920280B1655C8022A86", hash_generated_method = "7F5CC0B8AE0A810C5C7D4423452810D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public int hashCode() {
        int hashCode;
        hashCode = 0;
        {
            int i;
            i = 0;
            {
                long v;
                v = Double.doubleToLongBits(choiceLimits[i]);
                hashCode += (int) (v ^ (v >>> 32)) + choiceFormats[i].hashCode();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
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

    
        public static double nextDouble(double value, boolean increment) {
        return increment ? nextDouble(value) : previousDouble(value);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.872 -0400", hash_original_method = "609F300632C6A9AB79113AF961C366BC", hash_generated_method = "229035224AD48F260CD21582BDB4EA29")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Number parse(String string, ParsePosition position) {
        dsTaint.addTaint(position.dsTaint);
        dsTaint.addTaint(string);
        int offset;
        offset = position.getIndex();
        {
            int i;
            i = 0;
            {
                {
                    boolean var3E491709BF0A55E3EF4BCF49107179CA_196593707 = (string.startsWith(choiceFormats[i], offset));
                    {
                        position.setIndex(offset + choiceFormats[i].length());
                        Number var557AF4084A308BD8347C92BFCCC4F917_1093519550 = (new Double(choiceLimits[i]));
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        position.setErrorIndex(offset);
        Number var405F643C11C35123FC5FCCB1CD608A62_2130471758 = (new Double(Double.NaN));
        return (Number)dsTaint.getTaint();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.872 -0400", hash_original_method = "A68DB2E05654867D5DABBF703FA90F00", hash_generated_method = "913DF6F328F716D57289107E3D5F5E1D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setChoices(double[] limits, String[] formats) {
        dsTaint.addTaint(limits[0]);
        dsTaint.addTaint(formats[0]);
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
        } //End block
        // ---------- Original Method ----------
        //if (limits.length != formats.length) {
            //throw new IllegalArgumentException();
        //}
        //choiceLimits = limits;
        //choiceFormats = formats;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.872 -0400", hash_original_method = "55E8B28E1CF4E8D52478B124E3FA683B", hash_generated_method = "C66AF72A92FE61C6555CD5704C149878")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int skipWhitespace(String string, int index) {
        dsTaint.addTaint(index);
        dsTaint.addTaint(string);
        int length;
        length = string.length();
        {
            boolean var54E926F7898256E16580AE3AB0DD1494_787549644 = (index < length && Character.isWhitespace(string.charAt(index)));
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int length = string.length();
        //while (index < length && Character.isWhitespace(string.charAt(index))) {
            //index++;
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:29.872 -0400", hash_original_method = "C892C3517E889BA7A99732103703F353", hash_generated_method = "BB7F119103A7D3E1D84F02ECB886ADA4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toPattern() {
        StringBuilder buffer;
        buffer = new StringBuilder();
        {
            int i;
            i = 0;
            {
                {
                    buffer.append('|');
                } //End block
                String previous;
                previous = String.valueOf(previousDouble(choiceLimits[i]));
                String limit;
                limit = String.valueOf(choiceLimits[i]);
                {
                    boolean var66D3910CEF4502B2D205777FD11B560A_679673961 = (previous.length() < limit.length());
                    {
                        buffer.append(previous);
                        buffer.append('<');
                    } //End block
                    {
                        buffer.append(limit);
                        buffer.append('#');
                    } //End block
                } //End collapsed parenthetic
                boolean quote;
                quote = (choiceFormats[i].indexOf('|') != -1);
                {
                    buffer.append('\'');
                } //End block
                buffer.append(choiceFormats[i]);
                {
                    buffer.append('\'');
                } //End block
            } //End block
        } //End collapsed parenthetic
        String varAD28D02EB1C6982A5710D014292E1955_1234720020 = (buffer.toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    private static final long serialVersionUID = 1795184449645032964L;
}

