package gov.nist.javax.sip.parser.extensions;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import gov.nist.javax.sip.header.extensions.*;
import gov.nist.javax.sip.parser.*;
import java.text.ParseException;
import javax.sip.*;

public class MinSEParser extends ParametersParser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.730 -0400", hash_original_method = "4E326F54C0BC2C416F3292ADC3B64C39", hash_generated_method = "EBBAEE02EE07DF63F1AC5AB03D1CA6DC")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public MinSEParser(String text) {
        super(text);
        dsTaint.addTaint(text);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.730 -0400", hash_original_method = "B8B8CA8DFA565E816EE248A435214726", hash_generated_method = "EF48AF04CEF962E8A713290632EEEF62")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected MinSEParser(Lexer lexer) {
        super(lexer);
        dsTaint.addTaint(lexer.dsTaint);
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:22.730 -0400", hash_original_method = "528678E8CA90A52E25DB45830845A36C", hash_generated_method = "FB8E41C80D6D978E90787D715E058783")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public SIPHeader parse() throws ParseException {
        MinSE minse;
        minse = new MinSE();
        dbg_enter("parse");
        try 
        {
            headerName(TokenTypes.MINSE_TO);
            String nextId;
            nextId = lexer.getNextId();
            try 
            {
                int delta;
                delta = Integer.parseInt(nextId);
                minse.setExpires(delta);
            } //End block
            catch (NumberFormatException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException("bad integer format");
            } //End block
            catch (InvalidArgumentException ex)
            {
                if (DroidSafeAndroidRuntime.control) throw createParseException(ex.getMessage());
            } //End block
            this.lexer.SPorHT();
            super.parse(minse);
        } //End block
        finally 
        {
            dbg_leave("parse");
        } //End block
        return (SIPHeader)dsTaint.getTaint();
        // ---------- Original Method ----------
        //MinSE minse = new MinSE();
        //if (debug)
            //dbg_enter("parse");
        //try {
            //headerName(TokenTypes.MINSE_TO);
            //String nextId = lexer.getNextId();
            //try {
                //int delta = Integer.parseInt(nextId);
                //minse.setExpires(delta);
            //} catch (NumberFormatException ex) {
                //throw createParseException("bad integer format");
            //} catch (InvalidArgumentException ex) {
                //throw createParseException(ex.getMessage());
            //}
            //this.lexer.SPorHT();
            //super.parse(minse);
            //return minse;
        //} finally {
            //if (debug)
                //dbg_leave("parse");
        //}
    }

    
        public static void main(String args[]) throws ParseException {
        String to[] =
            {   "Min-SE: 30\n",
                "Min-SE: 45;some-param=somevalue\n",
            };
        for (int i = 0; i < to.length; i++) {
            MinSEParser tp = new MinSEParser(to[i]);
            MinSE t = (MinSE) tp.parse();
            System.out.println("encoded = " + t.encode());
            System.out.println("\ntime=" + t.getExpires() );
            if ( t.getParameter("some-param") != null)
                System.out.println("some-param=" + t.getParameter("some-param") );
        }
    }

    
}

