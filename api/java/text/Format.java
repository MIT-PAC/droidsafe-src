package java.text;

// Droidsafe Imports
import java.io.Serializable;

import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public abstract class Format implements Serializable, Cloneable {
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.525 -0400", hash_original_method = "6FBA04B2B44BD6140150C63C748AD62A", hash_generated_method = "8A4387ADC0046A91B4EE8D219103BC9A")
    protected  Format() {
        // ---------- Original Method ----------
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.526 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "C9645302D063753FFAB2BADFD02E92B6")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_259151495 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_259151495.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_259151495;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_461924189 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_461924189.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_461924189;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.526 -0400", hash_original_method = "37693C41F5C0477FFE14A538377AD1D2", hash_generated_method = "BAD74ED666EC189584D6FD6AB33F90BB")
    public final String format(Object object) {
        addTaint(object.getTaint());
String var8CB4AA7B650AA7040D828797C5473E3E_1079027195 =         format(object, new StringBuffer(), new FieldPosition(0))
                .toString();
        var8CB4AA7B650AA7040D828797C5473E3E_1079027195.addTaint(taint);
        return var8CB4AA7B650AA7040D828797C5473E3E_1079027195;
        // ---------- Original Method ----------
        //return format(object, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    @DSModeled(DSC.SAFE)
    public abstract StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field);

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.527 -0400", hash_original_method = "29C223BA8E4C1B7CC40F40C2878521D9", hash_generated_method = "3720D3086FAD156FB52DF8D12A8F00BE")
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        addTaint(object.getTaint());
AttributedCharacterIterator var55BEE374F3F96F74248D37376B200680_507043001 =         new AttributedString(format(object)).getIterator();
        var55BEE374F3F96F74248D37376B200680_507043001.addTaint(taint);
        return var55BEE374F3F96F74248D37376B200680_507043001;
        // ---------- Original Method ----------
        //return new AttributedString(format(object)).getIterator();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.527 -0400", hash_original_method = "6F2C2FABFB0232DE8BE4D0269373F5D5", hash_generated_method = "654FCA3DB89931322ADE5FC96B3C2F8A")
    public Object parseObject(String string) throws ParseException {
        addTaint(string.getTaint());
        ParsePosition position = new ParsePosition(0);
        Object result = parseObject(string, position);
        if(position.getIndex() == 0)        
        {
            ParseException varE37A2D5B4EBF9E36CFB19B811F94CB20_1931239906 = new ParseException("Parse failure", position.getErrorIndex());
            varE37A2D5B4EBF9E36CFB19B811F94CB20_1931239906.addTaint(taint);
            throw varE37A2D5B4EBF9E36CFB19B811F94CB20_1931239906;
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_962123644 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_962123644.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_962123644;
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(0);
        //Object result = parseObject(string, position);
        //if (position.getIndex() == 0) {
            //throw new ParseException("Parse failure", position.getErrorIndex());
        //}
        //return result;
    }

    
    @DSModeled(DSC.SAFE)
    public abstract Object parseObject(String string, ParsePosition position);

    
    @DSModeled(DSC.SAFE)
    static boolean upTo(String string, ParsePosition position,
            StringBuffer buffer, char stop) {
        int index = position.getIndex(), length = string.length();
        boolean lastQuote = false, quote = false;
        while (index < length) {
            char ch = string.charAt(index++);
            if (ch == '\'') {
                if (lastQuote) {
                    buffer.append('\'');
                }
                quote = !quote;
                lastQuote = true;
            } else if (ch == stop && !quote) {
                position.setIndex(index);
                return true;
            } else {
                lastQuote = false;
                buffer.append(ch);
            }
        }
        position.setIndex(index);
        return false;
    }

    
    @DSModeled(DSC.SAFE)
    static boolean upToWithQuotes(String string, ParsePosition position,
            StringBuffer buffer, char stop, char start) {
        int index = position.getIndex(), length = string.length(), count = 1;
        boolean quote = false;
        while (index < length) {
            char ch = string.charAt(index++);
            if (ch == '\'') {
                quote = !quote;
            }
            if (!quote) {
                if (ch == stop) {
                    count--;
                }
                if (count == 0) {
                    position.setIndex(index);
                    return true;
                }
                if (ch == start) {
                    count++;
                }
            }
            buffer.append(ch);
        }
        throw new IllegalArgumentException("Unmatched braces in the pattern");
    }

    
    public static class Field extends AttributedCharacterIterator.Attribute {
        
                @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.528 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "465767ECB3AF93CD4C2D7AEDA23F18B3")
        protected  Field(String fieldName) {
            super(fieldName);
            addTaint(fieldName.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.528 -0400", hash_original_field = "CD3DAE455C77872D19C5AEA7227DBEF8", hash_generated_field = "DE61A40CF1E88A2D4F1C7CBD694BE984")

        private static final long serialVersionUID = 276966692217360283L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:57.528 -0400", hash_original_field = "C56B73F9CC0B5F51F3C2FEF02E637B2F", hash_generated_field = "F20B0022FF8D3E84304897148427AD29")

    private static final long serialVersionUID = -299282585814624189L;
}

