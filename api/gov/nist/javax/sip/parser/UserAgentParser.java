package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import gov.nist.javax.sip.header.SIPHeader;
import gov.nist.javax.sip.header.UserAgent;

import java.text.ParseException;





public class UserAgentParser extends HeaderParser {


      @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.212 -0500", hash_original_method = "20E70CF6E7A6970225082D89AB2D734D", hash_generated_method = "514731961847CCC15B5FE2F7C683B7CB")
    
public static void main(String args[]) throws ParseException { String
      userAgent[] = { "User-Agent: Softphone/Beta1.5 \n", "User-Agent:Nist/Beta1 (beta version) \n", "User-Agent: Nist UA (beta version)\n",
      "User-Agent: Nist1.0/Beta2 Ubi/vers.1.0 (very cool) \n" ,
      "User-Agent: SJphone/1.60.299a/L (SJ Labs)\n",
      "User-Agent: sipXecs/3.5.11 sipXecs/sipxbridge (Linux)\n"};

      for (int i = 0; i < userAgent.length; i++ ) { UserAgentParser parser =
      new UserAgentParser(userAgent[i]); UserAgent ua= (UserAgent)
      parser.parse(); System.out.println("encoded = " + ua.encode()); }
       }

    /**
     * Constructor
     *
     * @param userAgent -
     *            UserAgent header to parse
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.202 -0500", hash_original_method = "72C240456E98B58E534CB3630B89C3C4", hash_generated_method = "7AE5D9F5EC165E8DEB680519446B6B66")
    
public UserAgentParser(String userAgent) {
        super(userAgent);
    }

    /**
     * Constructor
     *
     * @param lexer -
     *            the lexer to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.204 -0500", hash_original_method = "1D2877F696A9DE47D6D871F3024594AA", hash_generated_method = "9CF1E5C512FD2E8FD8F666461AA2E1C0")
    
protected UserAgentParser(Lexer lexer) {
        super(lexer);
    }

    /**
     * parse the message. Note that we have losened up on the parsing quite a bit because
     * user agents tend to be very bad about specifying the user agent according to RFC.
     *
     * @return SIPHeader (UserAgent object)
     * @throws SIPParseException
     *             if the message does not respect the spec.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:55:47.208 -0500", hash_original_method = "67E8EBD2906BCEC3B5F02757CFDC6836", hash_generated_method = "0F21D589345DAE214FD9040C8112095B")
    
public SIPHeader parse() throws ParseException {
        if (debug)
            dbg_enter("UserAgentParser.parse");
        UserAgent userAgent = new UserAgent();
        try {
            headerName(TokenTypes.USER_AGENT);
            if (this.lexer.lookAhead(0) == '\n')
                throw createParseException("empty header");

            /*
             * BNF User-Agent = "User-Agent" HCOLON server-val *(LWS server-val)
             * server-val = product / comment product = token [SLASH
             * product-version] product-version = token
             */
            while (this.lexer.lookAhead(0) != '\n'
                    && this.lexer.lookAhead(0) != '\0') {

                if (this.lexer.lookAhead(0) == '(') {
                    String comment = this.lexer.comment();
                    userAgent.addProductToken('(' + comment + ')');
                } else {
                    // product = token [SLASHproduct-version]
                    // product-version = token
                    // The RFC Does NOT allow this space but we are generous in what we accept

                    this.getLexer().SPorHT();


                    String product = this.lexer.byteStringNoSlash();
                    if ( product == null ) throw createParseException("Expected product string");

                    StringBuffer productSb = new StringBuffer(product);
                    // do we possibily have the optional product-version?
                    if (this.lexer.peekNextToken().getTokenType() == TokenTypes.SLASH) {
                        // yes
                        this.lexer.match(TokenTypes.SLASH);
                        // product-version
                        // The RFC Does NOT allow this space but we are generous in what we accept
                        this.getLexer().SPorHT();

                        String productVersion = this.lexer.byteStringNoSlash();

                        if ( productVersion == null ) throw createParseException("Expected product version");

                        productSb.append("/");

                        productSb.append(productVersion);
                    }

                    userAgent.addProductToken(productSb.toString());
                }
                // LWS
                this.lexer.SPorHT();
            }
        } finally {
            if (debug)
                dbg_leave("UserAgentParser.parse");
        }

        return userAgent;
    }

    
}

