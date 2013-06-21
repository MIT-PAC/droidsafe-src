package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ATResponseParser {
    private String line;
    private int next = 0;
    private int tokStart, tokEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.569 -0400", hash_original_method = "2DC067EE65EE5AEB61F14CBD640EED38", hash_generated_method = "171D3E9C224F8FE743F8551C1D35484A")
    @DSModeled(DSC.SAFE)
    public ATResponseParser(String line) {
        dsTaint.addTaint(line);
        // ---------- Original Method ----------
        //this.line = line;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.569 -0400", hash_original_method = "D2BEE04A1EF039BFE740D598D7938B39", hash_generated_method = "973F9303C7CE0D521136D860A9B127DF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean nextBoolean() {
        nextTok();
        {
            if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
        } //End block
        char c;
        c = line.charAt(tokStart);
        if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //nextTok();
        //if (tokEnd - tokStart > 1) {
            //throw new ATParseEx();
        //}
        //char c = line.charAt(tokStart);
        //if (c == '0') return false;
        //if (c ==  '1') return true;
        //throw new ATParseEx();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.570 -0400", hash_original_method = "D8B8577219277F33EAE3DA6AB88F25AB", hash_generated_method = "E5DCC165EBBA94B4A8BB4F7B8C9C747B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public int nextInt() {
        int ret;
        ret = 0;
        nextTok();
        {
            int i;
            i = tokStart;
            {
                char c;
                c = line.charAt(i);
                {
                    if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
                } //End block
                ret *= 10;
                ret += c - '0';
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //int ret = 0;
        //nextTok();
        //for (int i = tokStart ; i < tokEnd ; i++) {
            //char c = line.charAt(i);
            //if (c < '0' || c > '9') {
                //throw new ATParseEx();
            //}
            //ret *= 10;
            //ret += c - '0';
        //}
        //return ret;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.570 -0400", hash_original_method = "098AF12FD324D863E13EA52B5E17698D", hash_generated_method = "A3F9E7DE7390F57A7A0F2FA7431B0582")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String nextString() {
        nextTok();
        String varEE90AA5282DB675D966B79BC7AB216B5_1243083446 = (line.substring(tokStart, tokEnd));
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //nextTok();
        //return line.substring(tokStart, tokEnd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.570 -0400", hash_original_method = "10F6658C8E801D9A6B4832727F713C99", hash_generated_method = "CDC9D36BE80E25DCC6D9DDB847D54367")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public boolean hasMore() {
        boolean var9DE4D5566B42123C1C443418F59BA9C1_1200785437 = (next < line.length());
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return next < line.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.571 -0400", hash_original_method = "0441D3F31DB45A49823AD290225E4F8E", hash_generated_method = "861592D4DD37DD2B5095AA92CCBA5D85")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void nextTok() {
        int len;
        len = line.length();
        {
            skipPrefix();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
        } //End block
        try 
        {
            char c;
            c = line.charAt(next++);
            boolean hasQuote;
            hasQuote = false;
            c = skipWhiteSpace(c);
            {
                {
                    if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
                } //End block
                c = line.charAt(next++);
                tokStart = next - 1;
                {
                    c = line.charAt(next++);
                } //End block
                {
                    if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
                } //End block
                tokEnd = next - 1;
                {
                    boolean var488986A807B0AA949327E1256E728FED_1918056911 = (next < len && line.charAt(next++) != ',');
                    {
                        if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
                    } //End block
                } //End collapsed parenthetic
            } //End block
            {
                tokStart = next - 1;
                tokEnd = tokStart;
                {
                    {
                        boolean var986CE0AC04F096ACE050202F107CC62E_220696486 = (!Character.isWhitespace(c));
                        {
                            tokEnd = next;
                        } //End block
                    } //End collapsed parenthetic
                    c = line.charAt(next++);
                } //End block
            } //End block
        } //End block
        catch (StringIndexOutOfBoundsException ex)
        {
            if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.572 -0400", hash_original_method = "418256DED150EC59875240044DA6104A", hash_generated_method = "857EE92B95EE46C6664B2547BE2E3BB1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private char skipWhiteSpace(char c) {
        dsTaint.addTaint(c);
        int len;
        len = line.length();
        {
            boolean varD1EAF0076B3F6CEF9D5427CD7D342734_54384061 = (next < len && Character.isWhitespace(c));
            {
                c = line.charAt(next++);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBC2264F2A42C701245C9D8635C1E30A5_223542021 = (Character.isWhitespace(c));
            {
                if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
            } //End block
        } //End collapsed parenthetic
        return dsTaint.getTaintChar();
        // ---------- Original Method ----------
        //int len;
        //len = line.length();
        //while (next < len && Character.isWhitespace(c)) {
            //c = line.charAt(next++);
        //}
        //if (Character.isWhitespace(c)) {
            //throw new ATParseEx();
        //}
        //return c;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:40:10.573 -0400", hash_original_method = "1D94A267F6B395134932A5B3B0C0A195", hash_generated_method = "22DDC60EEA727A37C273CD75CA0BBACD")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void skipPrefix() {
        next = 0;
        int s;
        s = line.length();
        {
            char c;
            c = line.charAt(next++);
        } //End block
        if (DroidSafeAndroidRuntime.control) throw new ATParseEx("missing prefix");
        // ---------- Original Method ----------
        //next = 0;
        //int s = line.length();
        //while (next < s){
            //char c = line.charAt(next++);
            //if (c == ':') {
                //return;
            //}
        //}
        //throw new ATParseEx("missing prefix");
    }

    
}

