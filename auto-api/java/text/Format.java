package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.Serializable;

public abstract class Format implements Serializable, Cloneable {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.294 -0400", hash_original_method = "6FBA04B2B44BD6140150C63C748AD62A", hash_generated_method = "8A4387ADC0046A91B4EE8D219103BC9A")
    @DSModeled(DSC.SAFE)
    protected Format() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.295 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "B88B942FB9EA0C37CF8AAE435764F125")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_320819512 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            if (DroidSafeAndroidRuntime.control) throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.295 -0400", hash_original_method = "37693C41F5C0477FFE14A538377AD1D2", hash_generated_method = "5AA571E5B9E0A4742EF2F33334268818")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String format(Object object) {
        dsTaint.addTaint(object.dsTaint);
        String var73D3057EEACB95BF562002B0FD4B0030_654864055 = (format(object, new StringBuffer(), new FieldPosition(0))
                .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return format(object, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.295 -0400", hash_original_method = "29C223BA8E4C1B7CC40F40C2878521D9", hash_generated_method = "59F7102D1F1388E9D76062D44BE8516D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        dsTaint.addTaint(object.dsTaint);
        AttributedCharacterIterator var6AB48EA89770C8A393BC5F173886D54B_457082589 = (new AttributedString(format(object)).getIterator());
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttributedString(format(object)).getIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.296 -0400", hash_original_method = "6F2C2FABFB0232DE8BE4D0269373F5D5", hash_generated_method = "F35EA5B86A02D73BC7F203A79FD35DDE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object parseObject(String string) throws ParseException {
        dsTaint.addTaint(string);
        ParsePosition position;
        position = new ParsePosition(0);
        Object result;
        result = parseObject(string, position);
        {
            boolean varA01BF4F3DE22A214F5C7EB004E28484E_484390745 = (position.getIndex() == 0);
            {
                if (DroidSafeAndroidRuntime.control) throw new ParseException("Parse failure", position.getErrorIndex());
            } //End block
        } //End collapsed parenthetic
        return (Object)dsTaint.getTaint();
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
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:30.296 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "C99CCBB0448DF6198290968345EBA180")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Field(String fieldName) {
            super(fieldName);
            dsTaint.addTaint(fieldName);
            // ---------- Original Method ----------
        }

        
        private static final long serialVersionUID = 276966692217360283L;
    }


    
    private static final long serialVersionUID = -299282585814624189L;
}

