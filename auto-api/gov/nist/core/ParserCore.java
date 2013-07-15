package gov.nist.core;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;


import java.util.Iterator;
import java.text.ParseException;

public abstract class ParserCore {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.842 -0400", hash_original_field = "9F927900A282DAFC832F8F2BDF850983", hash_generated_field = "AF108A7E81C8C1348B39F9FCBD8C60E7")

    protected LexerCore lexer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.842 -0400", hash_original_method = "23390B10F07F5D8E9EE5EBAB724E0597", hash_generated_method = "23390B10F07F5D8E9EE5EBAB724E0597")
    public ParserCore ()
    {
        
    }


    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.843 -0400", hash_original_method = "2B8F776DAFC357EFC899FF251A427EF6", hash_generated_method = "F7D5720394B3C0E44EF164FDE7BB67C2")
    protected NameValue nameValue(char separator) throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_105195127 = null; 
        NameValue varB4EAC82CA7396A68D541C85D26508E83_738409076 = null; 
        NameValue varB4EAC82CA7396A68D541C85D26508E83_1983327275 = null; 
        dbg_enter("nameValue");
        try 
        {
            lexer.match(LexerCore.ID);
            Token name = lexer.getNextToken();
            lexer.SPorHT();
            try 
            {
                boolean quoted = false;
                char la = lexer.lookAhead(0);
                {
                    lexer.consume(1);
                    lexer.SPorHT();
                    String str = null;
                    boolean isFlag = false;
                    {
                        boolean var16FB55FE897EE64C0FC602655BA882F2_1182683953 = (lexer.lookAhead(0) == '\"');
                        {
                            str = lexer.quotedString();
                            quoted = true;
                        } 
                        {
                            lexer.match(LexerCore.ID);
                            Token value = lexer.getNextToken();
                            str = value.tokenValue;
                            {
                                str = "";
                                isFlag = true;
                            } 
                        } 
                    } 
                    NameValue nv = new NameValue(name.tokenValue,str,isFlag);
                    nv.setQuotedValue();
                    varB4EAC82CA7396A68D541C85D26508E83_105195127 = nv;
                } 
                {
                    varB4EAC82CA7396A68D541C85D26508E83_738409076 = new NameValue(name.tokenValue,"",true);
                } 
            } 
            catch (ParseException ex)
            {
                varB4EAC82CA7396A68D541C85D26508E83_1983327275 = new NameValue(name.tokenValue,null,false);
            } 
        } 
        finally 
        {
            dbg_leave("nameValue");
        } 
        addTaint(separator);
        NameValue varA7E53CE21691AB073D9660D615818899_308321744; 
        switch (DroidSafeAndroidRuntime.switchControl) {
            case 1: 
                varA7E53CE21691AB073D9660D615818899_308321744 = varB4EAC82CA7396A68D541C85D26508E83_105195127;
                break;
            case 2: 
                varA7E53CE21691AB073D9660D615818899_308321744 = varB4EAC82CA7396A68D541C85D26508E83_738409076;
                break;
            default:
                varA7E53CE21691AB073D9660D615818899_308321744 = varB4EAC82CA7396A68D541C85D26508E83_1983327275;
                break;
        }
        varA7E53CE21691AB073D9660D615818899_308321744.addTaint(getTaint()); 
        return varA7E53CE21691AB073D9660D615818899_308321744;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.843 -0400", hash_original_method = "FEF315A443660226B56655DBFD660360", hash_generated_method = "6FB912B555ECA1674AF9D9AEEECFF9DB")
    protected void dbg_enter(String rule) {
        StringBuffer stringBuffer = new StringBuffer();
        {
            int i = 0;
            stringBuffer.append(">");
        } 
        {
            System.out.println(
                stringBuffer + rule +
                "\nlexer buffer = \n" +
                lexer.getRest());
        } 
        addTaint(rule.getTaint());
        
        
        
            
        
            
                
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.844 -0400", hash_original_method = "1BC6FB469729E22F0BBD9E3870285FA5", hash_generated_method = "38BDD24C383006D2F9F1EA649A05B28A")
    protected void dbg_leave(String rule) {
        StringBuffer stringBuffer = new StringBuffer();
        {
            int i = 0;
            stringBuffer.append("<");
        } 
        {
            System.out.println(
                stringBuffer +
                rule +
                "\nlexer buffer = \n" +
                lexer.getRest());
        } 
        addTaint(rule.getTaint());
        
        
        
            
        
            
                
                
                
                
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.845 -0400", hash_original_method = "96EC2DBFF0EC1BA1DEDB704D9ED6E4AE", hash_generated_method = "A04CB51C7216179BC6E781C20FEF5E19")
    protected NameValue nameValue() throws ParseException {
        NameValue varB4EAC82CA7396A68D541C85D26508E83_448030045 = null; 
        varB4EAC82CA7396A68D541C85D26508E83_448030045 = nameValue('=');
        varB4EAC82CA7396A68D541C85D26508E83_448030045.addTaint(getTaint()); 
        return varB4EAC82CA7396A68D541C85D26508E83_448030045;
        
        
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.845 -0400", hash_original_method = "9816EEB9F7DF054BEDA3076A1CE20DA0", hash_generated_method = "6F665FEEADE1FA4D0B33F8051548AFCB")
    protected void peekLine(String rule) {
        {
            Debug.println(rule +" " + lexer.peekLine());
        } 
        addTaint(rule.getTaint());
        
        
            
        
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.845 -0400", hash_original_field = "83846441597C43A253E4BA178E096F17", hash_generated_field = "C7421C837BE84CB71F0718DB57F8E962")

    public static final boolean debug = Debug.parserDebug;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:36.845 -0400", hash_original_field = "D5906A698AA118FAAE31F8E6C8C9EB5B", hash_generated_field = "80C87DAAFBB424B160F9721506874F09")

    static int nesting_level;
}

