package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class Format implements Serializable, Cloneable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.027 -0400", hash_original_method = "6FBA04B2B44BD6140150C63C748AD62A", hash_generated_method = "8A4387ADC0046A91B4EE8D219103BC9A")
    protected  Format() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.028 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "0F9B682B0DEDF6BD206933F5C5287D4F")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_15062306 = null; //Variable for return #1
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_15062306 = super.clone();
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_15062306.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_15062306;
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.028 -0400", hash_original_method = "37693C41F5C0477FFE14A538377AD1D2", hash_generated_method = "5D314EB97F16CBBFE36D197315A5E144")
    public final String format(Object object) {
        String varB4EAC82CA7396A68D541C85D26508E83_1331443974 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1331443974 = format(object, new StringBuffer(), new FieldPosition(0))
                .toString();
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1331443974.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1331443974;
        // ---------- Original Method ----------
        //return format(object, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.029 -0400", hash_original_method = "29C223BA8E4C1B7CC40F40C2878521D9", hash_generated_method = "1D3E3588A051C18AFE84DE95F054A92A")
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_1391278363 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1391278363 = new AttributedString(format(object)).getIterator();
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1391278363.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1391278363;
        // ---------- Original Method ----------
        //return new AttributedString(format(object)).getIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.047 -0400", hash_original_method = "6F2C2FABFB0232DE8BE4D0269373F5D5", hash_generated_method = "0D4A934D4F1640934470AB6072D13EEB")
    public Object parseObject(String string) throws ParseException {
        Object varB4EAC82CA7396A68D541C85D26508E83_1298335039 = null; //Variable for return #1
        ParsePosition position;
        position = new ParsePosition(0);
        Object result;
        result = parseObject(string, position);
        {
            boolean varA01BF4F3DE22A214F5C7EB004E28484E_151834044 = (position.getIndex() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Parse failure", position.getErrorIndex());
            } //End block
        } //End collapsed parenthetic
        varB4EAC82CA7396A68D541C85D26508E83_1298335039 = result;
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_1298335039.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1298335039;
        // ---------- Original Method ----------
        //ParsePosition position = new ParsePosition(0);
        //Object result = parseObject(string, position);
        //if (position.getIndex() == 0) {
            //throw new ParseException("Parse failure", position.getErrorIndex());
        //}
        //return result;
    }

    
    public abstract Object parseObject(String string, ParsePosition position);

    
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.048 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "465767ECB3AF93CD4C2D7AEDA23F18B3")
        protected  Field(String fieldName) {
            super(fieldName);
            addTaint(fieldName.getTaint());
            // ---------- Original Method ----------
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.048 -0400", hash_original_field = "CD3DAE455C77872D19C5AEA7227DBEF8", hash_generated_field = "AC7F51A753FB0C82CF00788FB43D034E")

        private static long serialVersionUID = 276966692217360283L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:48.048 -0400", hash_original_field = "C56B73F9CC0B5F51F3C2FEF02E637B2F", hash_generated_field = "78D25AD4D32DC218A18319D4F9BF939F")

    private static long serialVersionUID = -299282585814624189L;
}

