package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class ReferToParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.626 -0400", hash_original_method = "DF57B31FD2F05C7FE41E5F087EC0A031", hash_generated_method = "306BD483FA2BCDBD92831A5479E623FC")
    public  ReferToParser(String referTo) {
        super(referTo);
        addTaint(referTo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.627 -0400", hash_original_method = "78341A496A4C46C460D57FED9263DC9D", hash_generated_method = "33783D1B9AF63A24398C18B41F2BD83E")
    protected  ReferToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:41.627 -0400", hash_original_method = "3469BCE5DE818D1E33012B0295E9EC56", hash_generated_method = "554F6CA0A2ABE4B73EEAF9477BBDDCA6")
    public SIPHeader parse() throws ParseException {
        headerName(TokenTypes.REFER_TO);
        ReferTo referTo = new ReferTo();
        super.parse(referTo);
        this.lexer.match('\n');
SIPHeader varF03467BD7719B93D23F3A1857BAA9912_1135718305 =         referTo;
        varF03467BD7719B93D23F3A1857BAA9912_1135718305.addTaint(taint);
        return varF03467BD7719B93D23F3A1857BAA9912_1135718305;
        // ---------- Original Method ----------
        //headerName(TokenTypes.REFER_TO);
        //ReferTo referTo = new ReferTo();
        //super.parse(referTo);
        //this.lexer.match('\n');
        //return referTo;
    }

    
        public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Refer-To: <sip:dave@denver.example.org?" +
                    "Replaces=12345%40192.168.118.3%3Bto-tag%3D12345%3Bfrom-tag%3D5FFE-3994>\n",
                "Refer-To: <sip:+1-650-555-2222@ss1.wcom.com;user=phone>;tag=5617\n",
                "Refer-To: T. A. Watson <sip:watson@bell-telephone.com>\n",
                "Refer-To: LittleGuy <sip:UserB@there.com>\n",
                "Refer-To: sip:mranga@120.6.55.9\n",
                "Refer-To: sip:mranga@129.6.55.9 ; tag=696928473514.129.6.55.9\n" };
        for (int i = 0; i < to.length; i++) {
            ReferToParser tp = new ReferToParser(to[i]);
            ReferTo t = (ReferTo) tp.parse();
            System.out.println("encoded = " + t.encode());
        }
    }

    
}

