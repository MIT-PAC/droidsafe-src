package gov.nist.javax.sip.parser;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import gov.nist.javax.sip.header.*;
import java.util.*;
import java.text.ParseException;

public class HeaderParser extends Parser {
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.534 -0400", hash_original_method = "D7BF0781EB1B150DCC61F7ABE4F04AEB", hash_generated_method = "46DA31DA5B47D55BC12A84C005EF4143")
    protected  HeaderParser(String header) {
        addTaint(header.getTaint());
        this.lexer = new Lexer("command_keywordLexer", header);
        // ---------- Original Method ----------
        //this.lexer = new Lexer("command_keywordLexer", header);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.535 -0400", hash_original_method = "844D98E200F4C4A3FE69D132F5D518A2", hash_generated_method = "8DC163926180CDBC36982AACF4429F5C")
    protected  HeaderParser(Lexer lexer) {
        addTaint(lexer.getTaint());
        this.lexer = lexer;
        this.lexer.selectLexer("command_keywordLexer");
        // ---------- Original Method ----------
        //this.lexer = lexer;
        //this.lexer.selectLexer("command_keywordLexer");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.585 -0400", hash_original_method = "3252974D26894AAD7C4FB2AFA441C9B3", hash_generated_method = "BFB57450E82F940C83DAB3CF45DD608C")
    protected int wkday() throws ParseException {
        dbg_enter("wkday");
        try 
        {
            String tok = lexer.ttoken();
            String id = tok.toLowerCase();
    if(TokenNames.MON.equalsIgnoreCase(id))            
            {
            int var9A1D6068C766BF52E1D103482C09C63C_1328624687 = (Calendar.MONDAY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281274132 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1281274132;
            }
            else
    if(TokenNames.TUE.equalsIgnoreCase(id))            
            {
            int var878F53927F22152EC2A546C4C7DE8C7B_1811428121 = (Calendar.TUESDAY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1508544211 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1508544211;
            }
            else
    if(TokenNames.WED.equalsIgnoreCase(id))            
            {
            int varF85BDECE70123F94D9DFD025F36A5549_848846541 = (Calendar.WEDNESDAY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599210547 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_599210547;
            }
            else
    if(TokenNames.THU.equalsIgnoreCase(id))            
            {
            int var58DC1C9117D47C49B66491B4FBBAADC1_1796365272 = (Calendar.THURSDAY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739705944 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_739705944;
            }
            else
    if(TokenNames.FRI.equalsIgnoreCase(id))            
            {
            int var50E5A8F9DD368743D5613EE9BDEADA67_1518495650 = (Calendar.FRIDAY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322057941 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1322057941;
            }
            else
    if(TokenNames.SAT.equalsIgnoreCase(id))            
            {
            int var83F0488F0B43538D6E7176EB9AEA7914_1138171741 = (Calendar.SATURDAY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276466242 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_276466242;
            }
            else
    if(TokenNames.SUN.equalsIgnoreCase(id))            
            {
            int var45526D26941C0591C338B7FD50E84850_1811258834 = (Calendar.SUNDAY);
                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014270657 = getTaintInt();
            return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1014270657;
            }
            else
            {
            java.text.ParseException varC641FDD74E6E9FC26E59A7186CE82DF5_1718109556 = createParseException("bad wkday");
            varC641FDD74E6E9FC26E59A7186CE82DF5_1718109556.addTaint(taint);
            throw varC641FDD74E6E9FC26E59A7186CE82DF5_1718109556;
            }
        } //End block
        finally 
        {
            dbg_leave("wkday");
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.639 -0400", hash_original_method = "C8449F66AC8DB5DC1EE33D138B3717DE", hash_generated_method = "033E2E448A76A27CD67C6C8EA1A458DE")
    protected Calendar date() throws ParseException {
        try 
        {
            Calendar retval = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
            String s1 = lexer.number();
            int day = Integer.parseInt(s1);
    if(day <= 0 || day > 31)            
            {
            java.text.ParseException varE36C22BF43D102D6C52FA5E50609E385_1013041576 = createParseException("Bad day ");
            varE36C22BF43D102D6C52FA5E50609E385_1013041576.addTaint(taint);
            throw varE36C22BF43D102D6C52FA5E50609E385_1013041576;
            }
            retval.set(Calendar.DAY_OF_MONTH, day);
            lexer.match(' ');
            String month = lexer.ttoken().toLowerCase();
    if(month.equals("jan"))            
            {
                retval.set(Calendar.MONTH, Calendar.JANUARY);
            } //End block
            else
    if(month.equals("feb"))            
            {
                retval.set(Calendar.MONTH, Calendar.FEBRUARY);
            } //End block
            else
    if(month.equals("mar"))            
            {
                retval.set(Calendar.MONTH, Calendar.MARCH);
            } //End block
            else
    if(month.equals("apr"))            
            {
                retval.set(Calendar.MONTH, Calendar.APRIL);
            } //End block
            else
    if(month.equals("may"))            
            {
                retval.set(Calendar.MONTH, Calendar.MAY);
            } //End block
            else
    if(month.equals("jun"))            
            {
                retval.set(Calendar.MONTH, Calendar.JUNE);
            } //End block
            else
    if(month.equals("jul"))            
            {
                retval.set(Calendar.MONTH, Calendar.JULY);
            } //End block
            else
    if(month.equals("aug"))            
            {
                retval.set(Calendar.MONTH, Calendar.AUGUST);
            } //End block
            else
    if(month.equals("sep"))            
            {
                retval.set(Calendar.MONTH, Calendar.SEPTEMBER);
            } //End block
            else
    if(month.equals("oct"))            
            {
                retval.set(Calendar.MONTH, Calendar.OCTOBER);
            } //End block
            else
    if(month.equals("nov"))            
            {
                retval.set(Calendar.MONTH, Calendar.NOVEMBER);
            } //End block
            else
    if(month.equals("dec"))            
            {
                retval.set(Calendar.MONTH, Calendar.DECEMBER);
            } //End block
            lexer.match(' ');
            String s2 = lexer.number();
            int yr = Integer.parseInt(s2);
            retval.set(Calendar.YEAR, yr);
Calendar varF9E19AD6135C970F387F77C6F3DE4477_1008686575 =             retval;
            varF9E19AD6135C970F387F77C6F3DE4477_1008686575.addTaint(taint);
            return varF9E19AD6135C970F387F77C6F3DE4477_1008686575;
        } //End block
        catch (Exception ex)
        {
            java.text.ParseException var175DA175F84F59D992CB0979F0854B9D_337999672 = createParseException("bad date field");
            var175DA175F84F59D992CB0979F0854B9D_337999672.addTaint(taint);
            throw var175DA175F84F59D992CB0979F0854B9D_337999672;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.664 -0400", hash_original_method = "A339A3BD9B311A61AF23D5CD23AA066A", hash_generated_method = "75B09702DAB483FDEDA041C19469FEE2")
    protected void time(Calendar calendar) throws ParseException {
        addTaint(calendar.getTaint());
        try 
        {
            String s = lexer.number();
            int hour = Integer.parseInt(s);
            calendar.set(Calendar.HOUR_OF_DAY, hour);
            lexer.match(':');
            s = lexer.number();
            int min = Integer.parseInt(s);
            calendar.set(Calendar.MINUTE, min);
            lexer.match(':');
            s = lexer.number();
            int sec = Integer.parseInt(s);
            calendar.set(Calendar.SECOND, sec);
        } //End block
        catch (Exception ex)
        {
            java.text.ParseException varFFA5BEB846477E615E8CC3D0DE513D2A_1617531805 = createParseException("error processing time ");
            varFFA5BEB846477E615E8CC3D0DE513D2A_1617531805.addTaint(taint);
            throw varFFA5BEB846477E615E8CC3D0DE513D2A_1617531805;
        } //End block
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.665 -0400", hash_original_method = "D87C47C2DE06FF746589C19C83F3FD66", hash_generated_method = "2358936519CB391E7C1E7AE98DB42FF3")
    public SIPHeader parse() throws ParseException {
        String name = lexer.getNextToken(':');
        lexer.consume(1);
        String body = lexer.getLine().trim();
        ExtensionHeaderImpl retval = new ExtensionHeaderImpl(name);
        retval.setValue(body);
SIPHeader varF9E19AD6135C970F387F77C6F3DE4477_519838563 =         retval;
        varF9E19AD6135C970F387F77C6F3DE4477_519838563.addTaint(taint);
        return varF9E19AD6135C970F387F77C6F3DE4477_519838563;
        // ---------- Original Method ----------
        //String name = lexer.getNextToken(':');
        //lexer.consume(1);
        //String body = lexer.getLine().trim();
        //ExtensionHeaderImpl retval = new ExtensionHeaderImpl(name);
        //retval.setValue(body);
        //return retval;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:40.665 -0400", hash_original_method = "E611EE61C75972DE5AB5B484EC7DE89C", hash_generated_method = "729814072190F6B773BDA8F6ADC3A39F")
    protected void headerName(int tok) throws ParseException {
        addTaint(tok);
        this.lexer.match(tok);
        this.lexer.SPorHT();
        this.lexer.match(':');
        this.lexer.SPorHT();
        // ---------- Original Method ----------
        //this.lexer.match(tok);
        //this.lexer.SPorHT();
        //this.lexer.match(':');
        //this.lexer.SPorHT();
    }

    
}

