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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.954 -0400", hash_original_field = "DACC316D060F4EC4A159A2F45A706659", hash_generated_field = "ED2D30C35903F5702DFA6B6B053F7D87")

    private double[] choiceLimits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.954 -0400", hash_original_field = "D7BA0E5ACC5078784279CE94B525E7CC", hash_generated_field = "05C2A4AC24967E0A070ABD8FDE0D9A95")

    private String[] choiceFormats;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.955 -0400", hash_original_method = "6AA98ECEF055DFD6530181EFB704802A", hash_generated_method = "E6CC56A755DB5212579A56293B11E738")
    public  ChoiceFormat(double[] limits, String[] formats) {
        setChoices(limits, formats);
        addTaint(limits[0]);
        addTaint(formats[0].getTaint());
        // ---------- Original Method ----------
        //setChoices(limits, formats);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.955 -0400", hash_original_method = "7A22DFD5F0C8BF76D2134AD604327DD6", hash_generated_method = "F997FE64B273F18ECE9990522E138A0D")
    public  ChoiceFormat(String template) {
        applyPattern(template);
        addTaint(template.getTaint());
        // ---------- Original Method ----------
        //applyPattern(template);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.965 -0400", hash_original_method = "61054E3E36618E298A5F058604E71A93", hash_generated_method = "7C4066C5AA8AC149A27B69EA8051D93A")
    public void applyPattern(String template) {
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
                    boolean var12C1132047B83F5C7F42C3880F3580DA_1651591168 = (i < formats.size());
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
                boolean var803A7BE3FF440C6FB2756CCD8D3C4347_949925743 = (position.getErrorIndex() != -1 || index >= length);
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
        addTaint(template.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.967 -0400", hash_original_method = "0E78DE057CBD16D1EEA99DBEA20DA3A1", hash_generated_method = "8DD076B27226A7256F985F1BB57473CB")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_1176661625 = null; //Variable for return #1
        ChoiceFormat clone;
        clone = (ChoiceFormat) super.clone();
        clone.choiceLimits = choiceLimits.clone();
        clone.choiceFormats = choiceFormats.clone();
        varB4EAC82CA7396A68D541C85D26508E83_1176661625 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_1176661625.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1176661625;
        // ---------- Original Method ----------
        //ChoiceFormat clone = (ChoiceFormat) super.clone();
        //clone.choiceLimits = choiceLimits.clone();
        //clone.choiceFormats = choiceFormats.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.967 -0400", hash_original_method = "F2D7C03023A3AAC9DFCE95AB2EC2A780", hash_generated_method = "2E106F74B223C93E4CDBFEEEB2E61066")
    @Override
    public boolean equals(Object object) {
        ChoiceFormat choice;
        choice = (ChoiceFormat) object;
        boolean varA782AEC7A8869A4A0890C9A206DC5B39_2124678612 = (Arrays.equals(choiceLimits, choice.choiceLimits)
                && Arrays.equals(choiceFormats, choice.choiceFormats));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_278179390 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_278179390;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.967 -0400", hash_original_method = "BC91D466505972771C623F66D301FB6D", hash_generated_method = "FA70566FD0A4C485D6892AEB8D9C975A")
    @Override
    public StringBuffer format(double value, StringBuffer buffer,
            FieldPosition field) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1760508274 = null; //Variable for return #1
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_104391477 = null; //Variable for return #2
        {
            int i;
            i = choiceLimits.length - 1;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1760508274 = buffer.append(choiceFormats[i]);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_104391477 = choiceFormats.length == 0 ? buffer : buffer
                .append(choiceFormats[0]);
        addTaint(value);
        addTaint(buffer.getTaint());
        addTaint(field.getTaint());
        StringBuffer varA7E53CE21691AB073D9660D615818899_1502555560; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1502555560 = varB4EAC82CA7396A68D541C85D26508E83_1760508274;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1502555560 = varB4EAC82CA7396A68D541C85D26508E83_104391477;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1502555560.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1502555560;
        // ---------- Original Method ----------
        //for (int i = choiceLimits.length - 1; i >= 0; i--) {
            //if (choiceLimits[i] <= value) {
                //return buffer.append(choiceFormats[i]);
            //}
        //}
        //return choiceFormats.length == 0 ? buffer : buffer
                //.append(choiceFormats[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.977 -0400", hash_original_method = "F9B960B049B919C822FEECA2E3BD7537", hash_generated_method = "845E080C5A588D51031FA29430335B47")
    @Override
    public StringBuffer format(long value, StringBuffer buffer,
            FieldPosition field) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1619596867 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1619596867 = format((double) value, buffer, field);
        addTaint(value);
        addTaint(buffer.getTaint());
        addTaint(field.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1619596867.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1619596867;
        // ---------- Original Method ----------
        //return format((double) value, buffer, field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.978 -0400", hash_original_method = "989D9CABCA800EE4DFA0CFCD3DE77FA9", hash_generated_method = "38467A37CFBE1FBDF6C319A8D5DE2F97")
    public Object[] getFormats() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_1929557288 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1929557288 = choiceFormats;
        varB4EAC82CA7396A68D541C85D26508E83_1929557288.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1929557288;
        // ---------- Original Method ----------
        //return choiceFormats;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.978 -0400", hash_original_method = "290809530CC76A10C33738C53A5176B9", hash_generated_method = "C15FFCBEDD0DA51559918B08A667E520")
    public double[] getLimits() {
        double[] var74D44D7D9EE6FE6C3433D694F869E521_695756019 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_695756019;
        // ---------- Original Method ----------
        //return choiceLimits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.978 -0400", hash_original_method = "9AF9F658465E6920280B1655C8022A86", hash_generated_method = "8F40A5BA636BE2A5B093FD6060C99071")
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
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1123473694 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1123473694;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.982 -0400", hash_original_method = "609F300632C6A9AB79113AF961C366BC", hash_generated_method = "B62526E714F99F7F343000589BF693BD")
    @Override
    public Number parse(String string, ParsePosition position) {
        Number varB4EAC82CA7396A68D541C85D26508E83_1147623893 = null; //Variable for return #1
        Number varB4EAC82CA7396A68D541C85D26508E83_115402544 = null; //Variable for return #2
        int offset;
        offset = position.getIndex();
        {
            int i;
            i = 0;
            {
                {
                    boolean var3E491709BF0A55E3EF4BCF49107179CA_558759421 = (string.startsWith(choiceFormats[i], offset));
                    {
                        position.setIndex(offset + choiceFormats[i].length());
                        varB4EAC82CA7396A68D541C85D26508E83_1147623893 = new Double(choiceLimits[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        position.setErrorIndex(offset);
        varB4EAC82CA7396A68D541C85D26508E83_115402544 = new Double(Double.NaN);
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        Number varA7E53CE21691AB073D9660D615818899_1671559703; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1671559703 = varB4EAC82CA7396A68D541C85D26508E83_1147623893;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1671559703 = varB4EAC82CA7396A68D541C85D26508E83_115402544;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1671559703.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1671559703;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.998 -0400", hash_original_method = "A68DB2E05654867D5DABBF703FA90F00", hash_generated_method = "657A8E35C6EF53B9664F05C7D9F70329")
    public void setChoices(double[] limits, String[] formats) {
        {
            if (DroidSafeAndroidRuntime.control) throw new IllegalArgumentException();
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.999 -0400", hash_original_method = "55E8B28E1CF4E8D52478B124E3FA683B", hash_generated_method = "0B550E93CF20EF5F4E3DCBCB141F4464")
    private int skipWhitespace(String string, int index) {
        int length;
        length = string.length();
        {
            boolean var54E926F7898256E16580AE3AB0DD1494_402349976 = (index < length && Character.isWhitespace(string.charAt(index)));
        } //End collapsed parenthetic
        addTaint(string.getTaint());
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022370267 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2022370267;
        // ---------- Original Method ----------
        //int length = string.length();
        //while (index < length && Character.isWhitespace(string.charAt(index))) {
            //index++;
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:47.999 -0400", hash_original_method = "C892C3517E889BA7A99732103703F353", hash_generated_method = "F1CA14223415C782A101B5118961B5DF")
    public String toPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_755588380 = null; //Variable for return #1
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
                    boolean var66D3910CEF4502B2D205777FD11B560A_1796970424 = (previous.length() < limit.length());
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
        varB4EAC82CA7396A68D541C85D26508E83_755588380 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_755588380.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_755588380;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:48.000 -0400", hash_original_field = "F0E5953C1F171C3A96BC62E66787D9C2", hash_generated_field = "94DDE4DC33ECFA5BFB3DB5A68087541F")

    private static long serialVersionUID = 1795184449645032964L;
}

