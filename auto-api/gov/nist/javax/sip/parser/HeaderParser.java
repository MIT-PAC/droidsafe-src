package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import gov.nist.javax.sip.header.*;
import java.util.*;
import java.text.ParseException;

public class HeaderParser extends Parser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.799 -0400", hash_original_method = "D7BF0781EB1B150DCC61F7ABE4F04AEB", hash_generated_method = "01DBEC03B2CB347A4566513BB13E1FE3")
    protected  HeaderParser(String header) {
        this.lexer = new Lexer("command_keywordLexer", header);
        addTaint(header.getTaint());
        // ---------- Original Method ----------
        //this.lexer = new Lexer("command_keywordLexer", header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.803 -0400", hash_original_method = "844D98E200F4C4A3FE69D132F5D518A2", hash_generated_method = "F1A83F91A44FD4BA40A408F306CA687A")
    protected  HeaderParser(Lexer lexer) {
        this.lexer = lexer;
        this.lexer.selectLexer("command_keywordLexer");
        addTaint(lexer.getTaint());
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("command_keywordLexer");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.804 -0400", hash_original_method = "3252974D26894AAD7C4FB2AFA441C9B3", hash_generated_method = "6A7044F3614B0EA71E2265FAEDC2C68A")
    protected int wkday() throws ParseException {
        dbg_enter("wkday");
        try 
        {
            String tok;
            tok = lexer.ttoken();
            String id;
            id = tok.toLowerCase();
            {
                boolean varFBBD09A165C3CD21B7CB07BB2947A8C6_507237591 = (TokenNames.MON.equalsIgnoreCase(id));
                {
                    boolean varA0B9871A289865119D112F580831DCD0_1507093768 = (TokenNames.TUE.equalsIgnoreCase(id));
                    {
                        boolean var35080559ECE6280BC3F96EB0045ED968_961390623 = (TokenNames.WED.equalsIgnoreCase(id));
                        {
                            boolean var682C1883901FF8641C6B50F4B8DD6A10_1179107641 = (TokenNames.THU.equalsIgnoreCase(id));
                            {
                                boolean varA2A1C2732A98E67B628DE72612F71350_534847896 = (TokenNames.FRI.equalsIgnoreCase(id));
                                {
                                    boolean varAED658A37D1D624744CAC013F45A97D1_877083078 = (TokenNames.SAT.equalsIgnoreCase(id));
                                    {
                                        boolean varD8F3B695147616021483803FA469195C_1433621263 = (TokenNames.SUN.equalsIgnoreCase(id));
                                        if (DroidSafeAndroidRuntime.control) throw createParseException("bad wkday");
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
        } //End block
        finally 
        {
            dbg_leave("wkday");
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021669299 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1021669299;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.812 -0400", hash_original_method = "C8449F66AC8DB5DC1EE33D138B3717DE", hash_generated_method = "D4ADCAD94645FBCD5137765CCB783815")
    protected Calendar date() throws ParseException {
        Calendar varB4EAC82CA7396A68D541C85D26508E83_633153008 = null; //Variable for return #1
        try 
        {
            Calendar retval;
            retval = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            String s1;
            s1 = lexer.number();
            int day;
            day = Integer.parseInt(s1);
            if (DroidSafeAndroidRuntime.control) throw createParseException("Bad day ");
            retval.set(Calendar.DAY_OF_MONTH, day);
            lexer.match(' ');
            String month;
            month = lexer.ttoken().toLowerCase();
            {
                boolean var9743F073DC13D11A170547C6332EA441_23428193 = (month.equals("jan"));
                {
                    retval.set(Calendar.MONTH, Calendar.JANUARY);
                } //End block
                {
                    boolean var2118529D719391BDEC0B6E339390CA00_983443720 = (month.equals("feb"));
                    {
                        retval.set(Calendar.MONTH, Calendar.FEBRUARY);
                    } //End block
                    {
                        boolean varF2858B81441E0AABDAD312E1A6511F2E_1669693991 = (month.equals("mar"));
                        {
                            retval.set(Calendar.MONTH, Calendar.MARCH);
                        } //End block
                        {
                            boolean var7C6B5F5685CF2B4C959CE97ACBFE690A_1227037584 = (month.equals("apr"));
                            {
                                retval.set(Calendar.MONTH, Calendar.APRIL);
                            } //End block
                            {
                                boolean varFB33E58DBB0B2E1031E4918AF1E03AB5_1675755290 = (month.equals("may"));
                                {
                                    retval.set(Calendar.MONTH, Calendar.MAY);
                                } //End block
                                {
                                    boolean varE06819B3892FC278D4AEDDDF96946D0A_466606163 = (month.equals("jun"));
                                    {
                                        retval.set(Calendar.MONTH, Calendar.JUNE);
                                    } //End block
                                    {
                                        boolean var1A89EB1F66E757EFB63FBA3804435455_1904321602 = (month.equals("jul"));
                                        {
                                            retval.set(Calendar.MONTH, Calendar.JULY);
                                        } //End block
                                        {
                                            boolean var6724DCBF558B5DA45EBF2AAE3F3F3E3B_1662744598 = (month.equals("aug"));
                                            {
                                                retval.set(Calendar.MONTH, Calendar.AUGUST);
                                            } //End block
                                            {
                                                boolean varD81EC2556AFC62DC4BD9B743B703BE5D_609988120 = (month.equals("sep"));
                                                {
                                                    retval.set(Calendar.MONTH, Calendar.SEPTEMBER);
                                                } //End block
                                                {
                                                    boolean var3B86497E6630B448890CD02542810333_6697049 = (month.equals("oct"));
                                                    {
                                                        retval.set(Calendar.MONTH, Calendar.OCTOBER);
                                                    } //End block
                                                    {
                                                        boolean var37ADD223AA87DAFF3B87F6E4A98522E7_552809150 = (month.equals("nov"));
                                                        {
                                                            retval.set(Calendar.MONTH, Calendar.NOVEMBER);
                                                        } //End block
                                                        {
                                                            boolean var4F0C3E471E78B53BFED0511B116F3AE6_338698693 = (month.equals("dec"));
                                                            {
                                                                retval.set(Calendar.MONTH, Calendar.DECEMBER);
                                                            } //End block
                                                        } //End collapsed parenthetic
                                                    } //End collapsed parenthetic
                                                } //End collapsed parenthetic
                                            } //End collapsed parenthetic
                                        } //End collapsed parenthetic
                                    } //End collapsed parenthetic
                                } //End collapsed parenthetic
                            } //End collapsed parenthetic
                        } //End collapsed parenthetic
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            lexer.match(' ');
            String s2;
            s2 = lexer.number();
            int yr;
            yr = Integer.parseInt(s2);
            retval.set(Calendar.YEAR, yr);
            varB4EAC82CA7396A68D541C85D26508E83_633153008 = retval;
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException("bad date field");
        } //End block
        varB4EAC82CA7396A68D541C85D26508E83_633153008.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_633153008;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.820 -0400", hash_original_method = "A339A3BD9B311A61AF23D5CD23AA066A", hash_generated_method = "2237A6C9E3C26797E2E95C0F7372638F")
    protected void time(Calendar calendar) throws ParseException {
        try 
        {
            String s;
            s = lexer.number();
            int hour;
            hour = Integer.parseInt(s);
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            lexer.match(':');
            s = lexer.number();
            int min;
            min = Integer.parseInt(s);
            calendar.set(Calendar.MINUTE, min);
            lexer.match(':');
            s = lexer.number();
            int sec;
            sec = Integer.parseInt(s);
            calendar.set(Calendar.SECOND, sec);
        } //End block
        catch (Exception ex)
        {
            if (DroidSafeAndroidRuntime.control) throw createParseException("error processing time ");
        } //End block
        addTaint(calendar.getTaint());
        // ---------- Original Method ----------
        //try {
            //String s = lexer.number();
            //int hour = Integer.parseInt(s);
            //calendar.set(Calendar.HOUR_OF_DAY, hour);
            //lexer.match(':');
            //s = lexer.number();
            //int min = Integer.parseInt(s);
            //calendar.set(Calendar.MINUTE, min);
            //lexer.match(':');
            //s = lexer.number();
            //int sec = Integer.parseInt(s);
            //calendar.set(Calendar.SECOND, sec);
        //} catch (Exception ex) {
            //throw createParseException("error processing time ");
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.830 -0400", hash_original_method = "D87C47C2DE06FF746589C19C83F3FD66", hash_generated_method = "2BB5FA50F269DEEFD5CFE8EDA1C9C806")
    public SIPHeader parse() throws ParseException {
        SIPHeader varB4EAC82CA7396A68D541C85D26508E83_1175047009 = null; //Variable for return #1
        String name;
        name = lexer.getNextToken(':');
        lexer.consume(1);
        String body;
        body = lexer.getLine().trim();
        ExtensionHeaderImpl retval;
        retval = new ExtensionHeaderImpl(name);
        retval.setValue(body);
        varB4EAC82CA7396A68D541C85D26508E83_1175047009 = retval;
        varB4EAC82CA7396A68D541C85D26508E83_1175047009.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1175047009;
        // ---------- Original Method ----------
        //String name = lexer.getNextToken(':');
        //lexer.consume(1);
        //String body = lexer.getLine().trim();
        //ExtensionHeaderImpl retval = new ExtensionHeaderImpl(name);
        //retval.setValue(body);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:13:34.831 -0400", hash_original_method = "E611EE61C75972DE5AB5B484EC7DE89C", hash_generated_method = "B75AAFB90FCC5F82614CCBEA95FFED24")
    protected void headerName(int tok) throws ParseException {
        this.lexer.match(tok);
        this.lexer.SPorHT();
        this.lexer.match(':');
        this.lexer.SPorHT();
        addTaint(tok);
        // ---------- Original Method ----------
        //this.lexer.match(tok);
        //this.lexer.SPorHT();
        //this.lexer.match(':');
        //this.lexer.SPorHT();
    }

    
}

