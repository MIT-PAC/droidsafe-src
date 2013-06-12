package java.text;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.runtime.DroidSafeAndroidRuntime;
import droidsafe.annotations.*;

// import Iterator to deal with enhanced for loop translation
import java.util.Iterator;

import java.io.Serializable;

public abstract class Format implements Serializable, Cloneable {
    private static final long serialVersionUID = -299282585814624189L;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.107 -0400", hash_original_method = "6FBA04B2B44BD6140150C63C748AD62A", hash_generated_method = "FD54502A3B0103E4D456B080F8AD6E0B")
    @DSModeled(DSC.SAFE)
    protected Format() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.107 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "C420FC2A2DCD7A910256BE8E4D64E0CB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    public Object clone() {
        try 
        {
            Object varDEB570B566DA7549E2F197D0AFA5A2B6_643595414 = (super.clone());
        } //End block
        catch (CloneNotSupportedException e)
        {
            throw new AssertionError(e);
        } //End block
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.108 -0400", hash_original_method = "37693C41F5C0477FFE14A538377AD1D2", hash_generated_method = "235F44A74CE4D4263CC7E251F10305A1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public final String format(Object object) {
        dsTaint.addTaint(object.dsTaint);
        String var73D3057EEACB95BF562002B0FD4B0030_520237787 = (format(object, new StringBuffer(), new FieldPosition(0))
                .toString());
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return format(object, new StringBuffer(), new FieldPosition(0))
                //.toString();
    }

    
    public abstract StringBuffer format(Object object, StringBuffer buffer,
            FieldPosition field);

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.108 -0400", hash_original_method = "29C223BA8E4C1B7CC40F40C2878521D9", hash_generated_method = "4EE418B4FB7DF2EBBA93D7B847ACD9DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public AttributedCharacterIterator formatToCharacterIterator(Object object) {
        dsTaint.addTaint(object.dsTaint);
        AttributedCharacterIterator var6AB48EA89770C8A393BC5F173886D54B_698536908 = (new AttributedString(format(object)).getIterator());
        return (AttributedCharacterIterator)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return new AttributedString(format(object)).getIterator();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.108 -0400", hash_original_method = "6F2C2FABFB0232DE8BE4D0269373F5D5", hash_generated_method = "2E465E7F4F0991A4D1101F3F912A878D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object parseObject(String string) throws ParseException {
        dsTaint.addTaint(string);
        ParsePosition position;
        position = new ParsePosition(0);
        Object result;
        result = parseObject(string, position);
        {
            boolean varA01BF4F3DE22A214F5C7EB004E28484E_409031979 = (position.getIndex() == 0);
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.108 -0400", hash_original_method = "342F58D58D7CDE61587D20CC55F1BF65", hash_generated_method = "E40E3DF50A129A615CEDF26F12F19796")
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.108 -0400", hash_original_method = "E4DAD8C2181AF3C8695050B31E68F195", hash_generated_method = "EC7B532152BFC21D3BEC28BD5621AAB5")
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
        private static final long serialVersionUID = 276966692217360283L;
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4", generated_on = "2013-06-11 11:15:13.108 -0400", hash_original_method = "5600516370D16E6925F34153CC1B60B8", hash_generated_method = "44A9ADF13A56517663185B21C3D0C919")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        protected Field(String fieldName) {
            super(fieldName);
            dsTaint.addTaint(fieldName);
            // ---------- Original Method ----------
        }

        
    }


    
}


