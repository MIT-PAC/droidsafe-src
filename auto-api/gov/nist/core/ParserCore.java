package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public abstract class ParserCore {
    protected LexerCore lexer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.758 -0400", hash_original_method = "891B71DDDC3FE2593E87FD6E32AE5A20", hash_generated_method = "891B71DDDC3FE2593E87FD6E32AE5A20")
        public ParserCore ()
    {
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.758 -0400", hash_original_method = "2B8F776DAFC357EFC899FF251A427EF6", hash_generated_method = "71297DE61D519D6362D06B626B9176D9")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected NameValue nameValue(char separator) throws ParseException {
        dsTaint.addTaint(separator);
        dbg_enter("nameValue");
        try 
        {
            lexer.match(LexerCore.ID);
            Token name;
            name = lexer.getNextToken();
            lexer.SPorHT();
            try 
            {
                boolean quoted;
                quoted = false;
                char la;
                la = lexer.lookAhead(0);
                {
                    lexer.consume(1);
                    lexer.SPorHT();
                    String str;
                    str = null;
                    boolean isFlag;
                    isFlag = false;
                    {
                        boolean var16FB55FE897EE64C0FC602655BA882F2_1218061042 = (lexer.lookAhead(0) == '\"');
                        {
                            str = lexer.quotedString();
                            quoted = true;
                        } //End block
                        {
                            lexer.match(LexerCore.ID);
                            Token value;
                            value = lexer.getNextToken();
                            str = value.tokenValue;
                            {
                                str = "";
                                isFlag = true;
                            } //End block
                        } //End block
                    } //End collapsed parenthetic
                    NameValue nv;
                    nv = new NameValue(name.tokenValue,str,isFlag);
                    nv.setQuotedValue();
                } //End block
                {
                    NameValue var9CD56D579E2F26FBFCA1CD807CEF8FD6_475117200 = (new NameValue(name.tokenValue,"",true));
                } //End block
            } //End block
            catch (ParseException ex)
            {
                NameValue varC7F5C4A1F49C2744DAEE6F6578453192_865559404 = (new NameValue(name.tokenValue,null,false));
            } //End block
        } //End block
        finally 
        {
            dbg_leave("nameValue");
        } //End block
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.759 -0400", hash_original_method = "FEF315A443660226B56655DBFD660360", hash_generated_method = "B6D37A3B9C502E86596F5A412198B0D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dbg_enter(String rule) {
        dsTaint.addTaint(rule);
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer();
        {
            int i;
            i = 0;
            stringBuffer.append(">");
        } //End collapsed parenthetic
        {
            System.out.println(
                stringBuffer + rule +
                "\nlexer buffer = \n" +
                lexer.getRest());
        } //End block
        // ---------- Original Method ----------
        //StringBuffer stringBuffer = new StringBuffer();
        //for (int i = 0; i < nesting_level ; i++)
            //stringBuffer.append(">");
        //if (debug)  {
            //System.out.println(
                //stringBuffer + rule +
                //"\nlexer buffer = \n" +
                //lexer.getRest());
        //}
        //nesting_level++;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.759 -0400", hash_original_method = "1BC6FB469729E22F0BBD9E3870285FA5", hash_generated_method = "3BE670D95BC5E1429CA4B4EB5983BA0D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void dbg_leave(String rule) {
        dsTaint.addTaint(rule);
        StringBuffer stringBuffer;
        stringBuffer = new StringBuffer();
        {
            int i;
            i = 0;
            stringBuffer.append("<");
        } //End collapsed parenthetic
        {
            System.out.println(
                stringBuffer +
                rule +
                "\nlexer buffer = \n" +
                lexer.getRest());
        } //End block
        // ---------- Original Method ----------
        //StringBuffer stringBuffer = new StringBuffer();
        //for (int i = 0; i < nesting_level ; i++)
            //stringBuffer.append("<");
        //if (debug)  {
            //System.out.println(
                //stringBuffer +
                //rule +
                //"\nlexer buffer = \n" +
                //lexer.getRest());
        //}
        //nesting_level --;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.759 -0400", hash_original_method = "96EC2DBFF0EC1BA1DEDB704D9ED6E4AE", hash_generated_method = "9D5096ADE4B708457C1CFB53E2A02E7E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected NameValue nameValue() throws ParseException {
        NameValue var98D9EB12944321E8803BB328372A7149_1544002341 = (nameValue('='));
        return (NameValue)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return nameValue('=');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:19.760 -0400", hash_original_method = "9816EEB9F7DF054BEDA3076A1CE20DA0", hash_generated_method = "596E8863B531AB01CE0A71B736A980A3")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void peekLine(String rule) {
        dsTaint.addTaint(rule);
        {
            Debug.println(rule +" " + lexer.peekLine());
        } //End block
        // ---------- Original Method ----------
        //if (debug) {
            //Debug.println(rule +" " + lexer.peekLine());
        //}
    }

    
    public static final boolean debug = Debug.parserDebug;
    static int nesting_level;
}

