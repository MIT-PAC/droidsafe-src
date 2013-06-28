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
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.565 -0400", hash_original_field = "DACC316D060F4EC4A159A2F45A706659", hash_generated_field = "ED2D30C35903F5702DFA6B6B053F7D87")

    private double[] choiceLimits;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.565 -0400", hash_original_field = "D7BA0E5ACC5078784279CE94B525E7CC", hash_generated_field = "05C2A4AC24967E0A070ABD8FDE0D9A95")

    private String[] choiceFormats;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.566 -0400", hash_original_method = "6AA98ECEF055DFD6530181EFB704802A", hash_generated_method = "E6CC56A755DB5212579A56293B11E738")
    public  ChoiceFormat(double[] limits, String[] formats) {
        setChoices(limits, formats);
        addTaint(limits[0]);
        addTaint(formats[0].getTaint());
        // ---------- Original Method ----------
        //setChoices(limits, formats);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.566 -0400", hash_original_method = "7A22DFD5F0C8BF76D2134AD604327DD6", hash_generated_method = "F997FE64B273F18ECE9990522E138A0D")
    public  ChoiceFormat(String template) {
        applyPattern(template);
        addTaint(template.getTaint());
        // ---------- Original Method ----------
        //applyPattern(template);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.567 -0400", hash_original_method = "61054E3E36618E298A5F058604E71A93", hash_generated_method = "12A81D7EA43668046BEE42BA8019676D")
    public void applyPattern(String template) {
        double[] limits = new double[5];
        List<String> formats = new ArrayList<String>();
        int length = template.length();
        int limitCount = 0;
        int index = 0;
        StringBuffer buffer = new StringBuffer();
        NumberFormat format = NumberFormat.getInstance(Locale.US);
        ParsePosition position = new ParsePosition(0);
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
                    int i = 0;
                    boolean var12C1132047B83F5C7F42C3880F3580DA_649600721 = (i < formats.size());
                    {
                        choiceFormats[i] = formats.get(i);
                    } //End block
                } //End collapsed parenthetic
            } //End block
            position.setIndex(index);
            Number value = format.parse(template, position);
            index = skipWhitespace(template, position.getIndex());
            {
                boolean var803A7BE3FF440C6FB2756CCD8D3C4347_314653577 = (position.getErrorIndex() != -1 || index >= length);
                {
                    choiceLimits = EmptyArray.DOUBLE;
                    choiceFormats = EmptyArray.STRING;
                } //End block
            } //End collapsed parenthetic
            char ch = template.charAt(index++);
            {
                double[] newLimits = new double[limitCount * 2];
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.569 -0400", hash_original_method = "0E78DE057CBD16D1EEA99DBEA20DA3A1", hash_generated_method = "CB4808CAA29D362DD7519CE3108C4868")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_145817936 = null; //Variable for return #1
        ChoiceFormat clone = (ChoiceFormat) super.clone();
        clone.choiceLimits = choiceLimits.clone();
        clone.choiceFormats = choiceFormats.clone();
        varB4EAC82CA7396A68D541C85D26508E83_145817936 = clone;
        varB4EAC82CA7396A68D541C85D26508E83_145817936.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_145817936;
        // ---------- Original Method ----------
        //ChoiceFormat clone = (ChoiceFormat) super.clone();
        //clone.choiceLimits = choiceLimits.clone();
        //clone.choiceFormats = choiceFormats.clone();
        //return clone;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.570 -0400", hash_original_method = "F2D7C03023A3AAC9DFCE95AB2EC2A780", hash_generated_method = "838A1C38D6B334664294897EA9B822C0")
    @Override
    public boolean equals(Object object) {
        ChoiceFormat choice = (ChoiceFormat) object;
        boolean varA782AEC7A8869A4A0890C9A206DC5B39_36528078 = (Arrays.equals(choiceLimits, choice.choiceLimits)
                && Arrays.equals(choiceFormats, choice.choiceFormats));
        addTaint(object.getTaint());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1813616719 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1813616719;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.571 -0400", hash_original_method = "BC91D466505972771C623F66D301FB6D", hash_generated_method = "4D1A374E33E70909058951B1F9C4B565")
    @Override
    public StringBuffer format(double value, StringBuffer buffer,
            FieldPosition field) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_1043093000 = null; //Variable for return #1
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_534127155 = null; //Variable for return #2
        {
            int i = choiceLimits.length - 1;
            {
                {
                    varB4EAC82CA7396A68D541C85D26508E83_1043093000 = buffer.append(choiceFormats[i]);
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_534127155 = choiceFormats.length == 0 ? buffer : buffer
                .append(choiceFormats[0]);
        addTaint(value);
        addTaint(buffer.getTaint());
        addTaint(field.getTaint());
        StringBuffer varA7E53CE21691AB073D9660D615818899_1611065970; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1611065970 = varB4EAC82CA7396A68D541C85D26508E83_1043093000;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1611065970 = varB4EAC82CA7396A68D541C85D26508E83_534127155;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1611065970.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1611065970;
        // ---------- Original Method ----------
        //for (int i = choiceLimits.length - 1; i >= 0; i--) {
            //if (choiceLimits[i] <= value) {
                //return buffer.append(choiceFormats[i]);
            //}
        //}
        //return choiceFormats.length == 0 ? buffer : buffer
                //.append(choiceFormats[0]);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.572 -0400", hash_original_method = "F9B960B049B919C822FEECA2E3BD7537", hash_generated_method = "5F517B9EA12AFAD35D4F0205AC5D9C5D")
    @Override
    public StringBuffer format(long value, StringBuffer buffer,
            FieldPosition field) {
        StringBuffer varB4EAC82CA7396A68D541C85D26508E83_631856753 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_631856753 = format((double) value, buffer, field);
        addTaint(value);
        addTaint(buffer.getTaint());
        addTaint(field.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_631856753.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_631856753;
        // ---------- Original Method ----------
        //return format((double) value, buffer, field);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.573 -0400", hash_original_method = "989D9CABCA800EE4DFA0CFCD3DE77FA9", hash_generated_method = "C3B37C7EAD5EF0D8FB2FECDF1F2EFD57")
    public Object[] getFormats() {
        Object[] varB4EAC82CA7396A68D541C85D26508E83_148008514 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_148008514 = choiceFormats;
        varB4EAC82CA7396A68D541C85D26508E83_148008514.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_148008514;
        // ---------- Original Method ----------
        //return choiceFormats;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.574 -0400", hash_original_method = "290809530CC76A10C33738C53A5176B9", hash_generated_method = "A7DE174286B56DDA9F067B9ADDC3EDA9")
    public double[] getLimits() {
        double[] var74D44D7D9EE6FE6C3433D694F869E521_906407038 = {getTaintDouble()};
        return var74D44D7D9EE6FE6C3433D694F869E521_906407038;
        // ---------- Original Method ----------
        //return choiceLimits;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.574 -0400", hash_original_method = "9AF9F658465E6920280B1655C8022A86", hash_generated_method = "2600DFE630B13B1048B5F0B56D742178")
    @Override
    public int hashCode() {
        int hashCode = 0;
        {
            int i = 0;
            {
                long v = Double.doubleToLongBits(choiceLimits[i]);
                hashCode += (int) (v ^ (v >>> 32)) + choiceFormats[i].hashCode();
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122393826 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_122393826;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.575 -0400", hash_original_method = "609F300632C6A9AB79113AF961C366BC", hash_generated_method = "16E2FFE9CE2E836D41A8CD6EA7B35EA1")
    @Override
    public Number parse(String string, ParsePosition position) {
        Number varB4EAC82CA7396A68D541C85D26508E83_558849356 = null; //Variable for return #1
        Number varB4EAC82CA7396A68D541C85D26508E83_2067657250 = null; //Variable for return #2
        int offset = position.getIndex();
        {
            int i = 0;
            {
                {
                    boolean var3E491709BF0A55E3EF4BCF49107179CA_720794532 = (string.startsWith(choiceFormats[i], offset));
                    {
                        position.setIndex(offset + choiceFormats[i].length());
                        varB4EAC82CA7396A68D541C85D26508E83_558849356 = new Double(choiceLimits[i]);
                    } //End block
                } //End collapsed parenthetic
            } //End block
        } //End collapsed parenthetic
        position.setErrorIndex(offset);
        varB4EAC82CA7396A68D541C85D26508E83_2067657250 = new Double(Double.NaN);
        addTaint(string.getTaint());
        addTaint(position.getTaint());
        Number varA7E53CE21691AB073D9660D615818899_394120045; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_394120045 = varB4EAC82CA7396A68D541C85D26508E83_558849356;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_394120045 = varB4EAC82CA7396A68D541C85D26508E83_2067657250;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_394120045.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_394120045;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.576 -0400", hash_original_method = "A68DB2E05654867D5DABBF703FA90F00", hash_generated_method = "657A8E35C6EF53B9664F05C7D9F70329")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.576 -0400", hash_original_method = "55E8B28E1CF4E8D52478B124E3FA683B", hash_generated_method = "67F86EC1A9881346B24E8E8497B5315E")
    private int skipWhitespace(String string, int index) {
        int length = string.length();
        {
            boolean var54E926F7898256E16580AE3AB0DD1494_2027587724 = (index < length && Character.isWhitespace(string.charAt(index)));
        } //End collapsed parenthetic
        addTaint(string.getTaint());
        addTaint(index);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391538837 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1391538837;
        // ---------- Original Method ----------
        //int length = string.length();
        //while (index < length && Character.isWhitespace(string.charAt(index))) {
            //index++;
        //}
        //return index;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.577 -0400", hash_original_method = "C892C3517E889BA7A99732103703F353", hash_generated_method = "8FECDFDE2735D07F77D1A3FA42972668")
    public String toPattern() {
        String varB4EAC82CA7396A68D541C85D26508E83_388741495 = null; //Variable for return #1
        StringBuilder buffer = new StringBuilder();
        {
            int i = 0;
            {
                {
                    buffer.append('|');
                } //End block
                String previous = String.valueOf(previousDouble(choiceLimits[i]));
                String limit = String.valueOf(choiceLimits[i]);
                {
                    boolean var66D3910CEF4502B2D205777FD11B560A_1319437489 = (previous.length() < limit.length());
                    {
                        buffer.append(previous);
                        buffer.append('<');
                    } //End block
                    {
                        buffer.append(limit);
                        buffer.append('#');
                    } //End block
                } //End collapsed parenthetic
                boolean quote = (choiceFormats[i].indexOf('|') != -1);
                {
                    buffer.append('\'');
                } //End block
                buffer.append(choiceFormats[i]);
                {
                    buffer.append('\'');
                } //End block
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_388741495 = buffer.toString();
        varB4EAC82CA7396A68D541C85D26508E83_388741495.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_388741495;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:58.577 -0400", hash_original_field = "F0E5953C1F171C3A96BC62E66787D9C2", hash_generated_field = "74F3624CBC64496D38F62E5EDD514F89")

    private static final long serialVersionUID = 1795184449645032964L;
}

