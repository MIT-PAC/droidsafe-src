package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.core.Token;
import gov.nist.javax.sip.header.*;
import java.text.ParseException;

public class UserAgentParser extends HeaderParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.933 -0400", hash_original_method = "72C240456E98B58E534CB3630B89C3C4", hash_generated_method = "8E84A0C3F9F84722131501E191D0670E")
    public  UserAgentParser(String userAgent) {
        super(userAgent);
        addTaint(userAgent.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.933 -0400", hash_original_method = "1D2877F696A9DE47D6D871F3024594AA", hash_generated_method = "3CAEFF70DD19529513F3F7832479172C")
    protected  UserAgentParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:43.934 -0400", hash_original_method = "67E8EBD2906BCEC3B5F02757CFDC6836", hash_generated_method = "1C7D480532A75CB8F5F21661F521587B")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1731453958 = null; //Variable for return #1
        dbg_enter("UserAgentParser.parse");
        UserAgent userAgent = new UserAgent();
        try 
        {
            headerName(TokenTypes.USER_AGENT);
            {
                boolean varE8319E96ED7B82FE86A0F5A02AAB8C1A_1278022999 = (this.lexer.lookAhead(0) == '\n');
                if (DroidSafeAndroidRuntime.control) throw createParseException("empty header");
            } //End collapsed parenthetic
            {
                boolean var8F462703D5AFB8059D6E8FF16FEB4CE3_984498933 = (this.lexer.lookAhead(0) != '\n'
                    && this.lexer.lookAhead(0) != '\0');
                {
                    {
                        boolean varBE42586E6C05C1C337617197702A94AB_1873280024 = (this.lexer.lookAhead(0) == '(');
                        {
                            String comment = this.lexer.comment();
                            userAgent.addProductToken('(' + comment + ')');
                        } //End block
                        {
                            this.getLexer().SPorHT();
                            String product = this.lexer.byteStringNoSlash();
                            if (DroidSafeAndroidRuntime.control) throw createParseException("Expected product string");
                            StringBuffer productSb = new StringBuffer(product);
                            {
                                boolean varFDA4A89BAF4E98EA4E3B3B4AD09BAA25_490289852 = (this.lexer.peekNextToken().getTokenType() == TokenTypes.SLASH);
                                {
                                    this.lexer.match(TokenTypes.SLASH);
                                    this.getLexer().SPorHT();
                                    String productVersion = this.lexer.byteStringNoSlash();
                                    if (DroidSafeAndroidRuntime.control) throw createParseException("Expected product version");
                                    productSb.append("/");
                                    productSb.append(productVersion);
                                } //End block
                            } //End collapsed parenthetic
                            userAgent.addProductToken(productSb.toString());
                        } //End block
                    } //End collapsed parenthetic
                    this.lexer.SPorHT();
                } //End block
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("UserAgentParser.parse");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_1731453958 = userAgent;
        varB4EAC82CA7396A68D541C85D26508E83_1731453958.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1731453958;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    public static void main(String args[]) throws ParseException {
        String
      userAgent[] = { "User-Agent: Softphone/Beta1.5 \n", "User-Agent:Nist/Beta1 (beta version) \n", "User-Agent: Nist UA (beta version)\n",
      "User-Agent: Nist1.0/Beta2 Ubi/vers.1.0 (very cool) \n" ,
      "User-Agent: SJphone/1.60.299a/L (SJ Labs)\n",
      "User-Agent: sipXecs/3.5.11 sipXecs/sipxbridge (Linux)\n"};
        for (int i = 0; i < userAgent.length; i++ ) { UserAgentParser parser =
      new UserAgentParser(userAgent[i]); UserAgent ua= (UserAgent)
      parser.parse(); System.out.println("encoded = " + ua.encode()); }
    }

    
}

