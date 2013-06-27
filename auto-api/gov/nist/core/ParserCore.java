package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;

public abstract class ParserCore {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.785 -0400", hash_original_field = "9F927900A282DAFC832F8F2BDF850983", hash_generated_field = "AF108A7E81C8C1348B39F9FCBD8C60E7")

    protected LexerCore lexer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.785 -0400", hash_original_method = "23390B10F07F5D8E9EE5EBAB724E0597", hash_generated_method = "23390B10F07F5D8E9EE5EBAB724E0597")
    public ParserCore ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.804 -0400", hash_original_method = "2B8F776DAFC357EFC899FF251A427EF6", hash_generated_method = "5DFCE8E62F4939AA1A880194B50626C6")
    protected NameValue nameValue(char separator) throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_819078431 = null; //Variable for return #1
        NameValue varB4EAC82CA7396A68D541C85D26508E83_438594117 = null; //Variable for return #2
        NameValue varB4EAC82CA7396A68D541C85D26508E83_375967197 = null; //Variable for return #3
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
                        boolean var16FB55FE897EE64C0FC602655BA882F2_1280647565 = (lexer.lookAhead(0) == '\"');
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
                    varB4EAC82CA7396A68D541C85D26508E83_819078431 = nv;
                } //End block
                {
                    varB4EAC82CA7396A68D541C85D26508E83_438594117 = new NameValue(name.tokenValue,"",true);
                } //End block
            } //End block
            catch (ParseException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_375967197 = new NameValue(name.tokenValue,null,false);
            } //End block
        } //End block
        finally 
        {
            dbg_leave("nameValue");
        } //End block
        addTaint(separator);
        NameValue varA7E53CE21691AB073D9660D615818899_1155755306; //Final return value
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: //Assign result for return ordinal #1
                varA7E53CE21691AB073D9660D615818899_1155755306 = varB4EAC82CA7396A68D541C85D26508E83_819078431;
                break;
            case 2: //Assign result for return ordinal #2
                varA7E53CE21691AB073D9660D615818899_1155755306 = varB4EAC82CA7396A68D541C85D26508E83_438594117;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_1155755306 = varB4EAC82CA7396A68D541C85D26508E83_375967197;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_1155755306.addTaint(getTaint()); //Add taint from parent
        return varA7E53CE21691AB073D9660D615818899_1155755306;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.804 -0400", hash_original_method = "FEF315A443660226B56655DBFD660360", hash_generated_method = "39BF05C2EADFD98F7933FBAD6B1F9569")
    protected void dbg_enter(String rule) {
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
        addTaint(rule.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.805 -0400", hash_original_method = "1BC6FB469729E22F0BBD9E3870285FA5", hash_generated_method = "5359D83DB03E37BAEE6A3543B18F471B")
    protected void dbg_leave(String rule) {
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
        addTaint(rule.getTaint());
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.809 -0400", hash_original_method = "96EC2DBFF0EC1BA1DEDB704D9ED6E4AE", hash_generated_method = "C5E8E13C3D35995AE6173FB65358042C")
    protected NameValue nameValue() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1262590325 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1262590325 = nameValue('=');
        varB4EAC82CA7396A68D541C85D26508E83_1262590325.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1262590325;
        // ---------- Original Method ----------
        //return nameValue('=');
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.813 -0400", hash_original_method = "9816EEB9F7DF054BEDA3076A1CE20DA0", hash_generated_method = "6F665FEEADE1FA4D0B33F8051548AFCB")
    protected void peekLine(String rule) {
        {
            Debug.println(rule +" " + lexer.peekLine());
        } //End block
        addTaint(rule.getTaint());
        // ---------- Original Method ----------
        //if (debug) {
            //Debug.println(rule +" " + lexer.peekLine());
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.813 -0400", hash_original_field = "83846441597C43A253E4BA178E096F17", hash_generated_field = "C7421C837BE84CB71F0718DB57F8E962")

    public static final boolean debug = Debug.parserDebug;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:29.813 -0400", hash_original_field = "D5906A698AA118FAAE31F8E6C8C9EB5B", hash_generated_field = "80C87DAAFBB424B160F9721506874F09")

    static int nesting_level;
}

