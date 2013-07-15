package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.Serializable;

public abstract class Format implements Serializable, Cloneable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.678 -0400", hash_original_method = "6FBA04B2B44BD6140150C63C748AD62A", hash_generated_method = "8A4387ADC0046A91B4EE8D219103BC9A")
    protected  Format() {
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.678 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "AE2BDB91C20849CF6DB7908F342316E3")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_673939613 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_673939613.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_673939613;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_601178413 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_601178413.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_601178413;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.679 -0400", hash_original_method = "37693C41F5C0477FFE14A538377AD1D2", hash_generated_method = "824B109ED2625635EB03F9F46FB0D5F6")
    public final String format(Object object) {
        addTaint(object.getTaint());
String var8CB4AA7B650AA7040D828797C5473E3E_458678430 =         format(object, new StringBuffer(), new FieldPosition(0))
                .toString();
        var8CB4AA7B650AA7040D828797C5473E3E_458678430.addTaint(taint);
        return var8CB4AA7B650AA7040D828797C5473E3E_458678430;
        // ---------- Original Method ----------
        //return format(object, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.680 -0400", hash_original_method = "29C223BA8E4C1B7CC40F40C2878521D9", hash_generated_method = "0B767908623DAC78138F653602E4FFFA")
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        addTaint(object.getTaint());
AttributedCharacterIterator var55BEE374F3F96F74248D37376B200680_287148818 =         new AttributedString(format(object)).getIterator();
        var55BEE374F3F96F74248D37376B200680_287148818.addTaint(taint);
        return var55BEE374F3F96F74248D37376B200680_287148818;
        // ---------- Original Method ----------
        //return new AttributedString(format(object)).getIterator();
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.680 -0400", hash_original_method = "6F2C2FABFB0232DE8BE4D0269373F5D5", hash_generated_method = "29EED93628B8ED5C4DC41AE1A6539BF7")
    public Object parseObject(String string) throws ParseException {
        addTaint(string.getTaint());
        ParsePosition position = new ParsePosition(0);
        Object result = parseObject(string, position);
    if(position.getIndex() == 0)        
        {
            ParseException varE37A2D5B4EBF9E36CFB19B811F94CB20_1604747765 = new ParseException("Parse failure", position.getErrorIndex());
            varE37A2D5B4EBF9E36CFB19B811F94CB20_1604747765.addTaint(taint);
            throw varE37A2D5B4EBF9E36CFB19B811F94CB20_1604747765;
        } //End block
Object varDC838461EE2FA0CA4C9BBB70A15456B0_627065926 =         result;
        varDC838461EE2FA0CA4C9BBB70A15456B0_627065926.addTaint(taint);
        return varDC838461EE2FA0CA4C9BBB70A15456B0_627065926;
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(0);
        //Object result = parseObject(string, position);
        //if (position.getIndex() == 0) {
            //throw new ParseException("Parse failure", position.getErrorIndex());
        //}
        //return result;
    }

    
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.681 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "465767ECB3AF93CD4C2D7AEDA23F18B3")
        protected  Field(String fieldName) {
            super(fieldName);
            addTaint(fieldName.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.681 -0400", hash_original_field = "CD3DAE455C77872D19C5AEA7227DBEF8", hash_generated_field = "DE61A40CF1E88A2D4F1C7CBD694BE984")

        private static final long serialVersionUID = 276966692217360283L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 11:02:54.682 -0400", hash_original_field = "C56B73F9CC0B5F51F3C2FEF02E637B2F", hash_generated_field = "F20B0022FF8D3E84304897148427AD29")

    private static final long serialVersionUID = -299282585814624189L;
}

