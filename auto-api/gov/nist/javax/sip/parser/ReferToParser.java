package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.text.ParseException;
import gov.nist.javax.sip.header.*;

public class ReferToParser extends AddressParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.062 -0400", hash_original_method = "DF57B31FD2F05C7FE41E5F087EC0A031", hash_generated_method = "306BD483FA2BCDBD92831A5479E623FC")
    public  ReferToParser(String referTo) {
        super(referTo);
        addTaint(referTo.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.062 -0400", hash_original_method = "78341A496A4C46C460D57FED9263DC9D", hash_generated_method = "33783D1B9AF63A24398C18B41F2BD83E")
    protected  ReferToParser(Lexer lexer) {
        super(lexer);
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:38:34.063 -0400", hash_original_method = "3469BCE5DE818D1E33012B0295E9EC56", hash_generated_method = "DFC3C4E20C0808DB2D56E19F954B64B4")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1301399697 = null; //Variable for return #1
        headerName(TokenTypes.REFER_TO);
        ReferTo referTo;
        referTo = new ReferTo();
        super.parse(referTo);
        this.lexer.match('\n');
        varB4EAC82CA7396A68D541C85D26508E83_1301399697 = referTo;
        varB4EAC82CA7396A68D541C85D26508E83_1301399697.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1301399697;
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

