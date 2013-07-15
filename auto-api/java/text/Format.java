package java.text;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.io.Serializable;

public abstract class Format implements Serializable, Cloneable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.615 -0400", hash_original_method = "6FBA04B2B44BD6140150C63C748AD62A", hash_generated_method = "8A4387ADC0046A91B4EE8D219103BC9A")
    protected  Format() {
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.616 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "CF3C344FBAAEB1A0A2D9FB5B2B6E35AE")
    @Override
    public Object clone() {
        Object varB4EAC82CA7396A68D541C85D26508E83_413092231 = null; 
        try 
        {
            varB4EAC82CA7396A68D541C85D26508E83_413092231 = super.clone();
        } 
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } 
        varB4EAC82CA7396A68D541C85D26508E83_413092231.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_413092231;
        
        
            
        
            
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.616 -0400", hash_original_method = "37693C41F5C0477FFE14A538377AD1D2", hash_generated_method = "B9861996B97298BE5C3C5C617995C155")
    public final String format(Object object) {
        String varB4EAC82CA7396A68D541C85D26508E83_851981071 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_851981071 = format(object, new StringBuffer(), new FieldPosition(0))
                .toString();
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_851981071.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_851981071;
        
        
                
    }

    
    public abstract StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field);

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.617 -0400", hash_original_method = "29C223BA8E4C1B7CC40F40C2878521D9", hash_generated_method = "2E573A9B6D6F0EC48FFC520E7534F4FE")
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        AttributedCharacterIterator varB4EAC82CA7396A68D541C85D26508E83_279750239 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_279750239 = new AttributedString(format(object)).getIterator();
        addTaint(object.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_279750239.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_279750239;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.617 -0400", hash_original_method = "6F2C2FABFB0232DE8BE4D0269373F5D5", hash_generated_method = "158080E8DE9AE68032F39B7DED57BCE7")
    public Object parseObject(String string) throws ParseException {
        Object varB4EAC82CA7396A68D541C85D26508E83_32902287 = null; 
        ParsePosition position = new ParsePosition(0);
        Object result = parseObject(string, position);
        {
            boolean varA01BF4F3DE22A214F5C7EB004E28484E_1863327859 = (position.getIndex() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Parse failure", position.getErrorIndex());
            } 
        } 
        varB4EAC82CA7396A68D541C85D26508E83_32902287 = result;
        addTaint(string.getTaint());
        varB4EAC82CA7396A68D541C85D26508E83_32902287.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_32902287;
        
        
        
        
            
        
        
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.618 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "465767ECB3AF93CD4C2D7AEDA23F18B3")
        protected  Field(String fieldName) {
            super(fieldName);
            addTaint(fieldName.getTaint());
            
        }

        
        @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.618 -0400", hash_original_field = "CD3DAE455C77872D19C5AEA7227DBEF8", hash_generated_field = "DE61A40CF1E88A2D4F1C7CBD694BE984")

        private static final long serialVersionUID = 276966692217360283L;
    }


    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:59.618 -0400", hash_original_field = "C56B73F9CC0B5F51F3C2FEF02E637B2F", hash_generated_field = "F20B0022FF8D3E84304897148427AD29")

    private static final long serialVersionUID = -299282585814624189L;
}

