package gov.nist.core;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;

public abstract class ParserCore {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.733 -0400", hash_original_field = "9F927900A282DAFC832F8F2BDF850983", hash_generated_field = "AF108A7E81C8C1348B39F9FCBD8C60E7")

    protected LexerCore lexer;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.733 -0400", hash_original_method = "23390B10F07F5D8E9EE5EBAB724E0597", hash_generated_method = "23390B10F07F5D8E9EE5EBAB724E0597")
    public ParserCore ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.734 -0400", hash_original_method = "2B8F776DAFC357EFC899FF251A427EF6", hash_generated_method = "1252DB65E0525B015A8BF035F45D5B15")
    protected NameValue nameValue(char separator) throws ParseException {
        addTaint(separator);
    if(debug)        
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
    if(la == separator)                
                {
                    lexer.consume(1);
                    lexer.SPorHT();
                    String str = null;
                    boolean isFlag = false;
    if(lexer.lookAhead(0) == '\"')                    
                    {
                        str = lexer.quotedString();
                        quoted = true;
                    } //End block
                    else
                    {
                        lexer.match(LexerCore.ID);
                        Token value = lexer.getNextToken();
                        str = value.tokenValue;
    if(str==null)                        
                        {
                            str = "";
                            isFlag = true;
                        } //End block
                    } //End block
                    NameValue nv = new NameValue(name.tokenValue,str,isFlag);
    if(quoted)                    
                    nv.setQuotedValue();
NameValue var8CDC8D1FFB0B29D7089B99B596CC9F85_1765330665 =                     nv;
                    var8CDC8D1FFB0B29D7089B99B596CC9F85_1765330665.addTaint(taint);
                    return var8CDC8D1FFB0B29D7089B99B596CC9F85_1765330665;
                } //End block
                else
                {
NameValue varED2B84A58195618988E404B38559B5DC_1805732522 =                     new NameValue(name.tokenValue,"",true);
                    varED2B84A58195618988E404B38559B5DC_1805732522.addTaint(taint);
                    return varED2B84A58195618988E404B38559B5DC_1805732522;
                } //End block
            } //End block
            catch (ParseException ex)
            {
NameValue varBAC8C205DFE70B1E08EB9CE4F0171A33_1900304504 =                 new NameValue(name.tokenValue,null,false);
                varBAC8C205DFE70B1E08EB9CE4F0171A33_1900304504.addTaint(taint);
                return varBAC8C205DFE70B1E08EB9CE4F0171A33_1900304504;
            } //End block
        } //End block
        finally 
        {
    if(debug)            
            dbg_leave("nameValue");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.735 -0400", hash_original_method = "FEF315A443660226B56655DBFD660360", hash_generated_method = "5A4DCF2DF2E206560721120A8EA05450")
    protected void dbg_enter(String rule) {
        addTaint(rule.getTaint());
        StringBuffer stringBuffer = new StringBuffer();
for(int i = 0;i < nesting_level;i++)
        stringBuffer.append(">");
    if(debug)        
        {
            System.out.println(
                stringBuffer + rule +
                "\nlexer buffer = \n" +
                lexer.getRest());
        } //End block
        nesting_level++;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.736 -0400", hash_original_method = "1BC6FB469729E22F0BBD9E3870285FA5", hash_generated_method = "74352E2BDC3D668C345F76CE81634AE1")
    protected void dbg_leave(String rule) {
        addTaint(rule.getTaint());
        StringBuffer stringBuffer = new StringBuffer();
for(int i = 0;i < nesting_level;i++)
        stringBuffer.append("<");
    if(debug)        
        {
            System.out.println(
                stringBuffer +
                rule +
                "\nlexer buffer = \n" +
                lexer.getRest());
        } //End block
        nesting_level --;
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

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.736 -0400", hash_original_method = "96EC2DBFF0EC1BA1DEDB704D9ED6E4AE", hash_generated_method = "9DA2A6CAC5A3FE77A0AFEE70E502C857")
    protected NameValue nameValue() throws ParseException {
NameValue var52FFE96DF188A662888F079EBA8775A7_1452138498 =         nameValue('=');
        var52FFE96DF188A662888F079EBA8775A7_1452138498.addTaint(taint);
        return var52FFE96DF188A662888F079EBA8775A7_1452138498;
        // ---------- Original Method ----------
        //return nameValue('=');
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.737 -0400", hash_original_method = "9816EEB9F7DF054BEDA3076A1CE20DA0", hash_generated_method = "BF8BB688FC34A47C30963622DA3C58F0")
    protected void peekLine(String rule) {
        addTaint(rule.getTaint());
    if(debug)        
        {
            Debug.println(rule +" " + lexer.peekLine());
        } //End block
        // ---------- Original Method ----------
        //if (debug) {
            //Debug.println(rule +" " + lexer.peekLine());
        //}
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.737 -0400", hash_original_field = "83846441597C43A253E4BA178E096F17", hash_generated_field = "C7421C837BE84CB71F0718DB57F8E962")

    public static final boolean debug = Debug.parserDebug;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:33.737 -0400", hash_original_field = "D5906A698AA118FAAE31F8E6C8C9EB5B", hash_generated_field = "80C87DAAFBB424B160F9721506874F09")

    static int nesting_level;
}

