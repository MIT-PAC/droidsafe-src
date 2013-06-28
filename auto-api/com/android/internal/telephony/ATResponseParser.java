package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;

public class ATResponseParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.141 -0400", hash_original_field = "6438C669E0D0DE98E6929C2CC0FAC474", hash_generated_field = "D67826549E3D41E5CE98380D120E6CF5")

    private String line;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.141 -0400", hash_original_field = "38EA60B61176AFBFDFE18136E198D5E9", hash_generated_field = "AEA186324829F814A60F0A9E76E33097")

    private int next = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.141 -0400", hash_original_field = "2DAFAB33EFF3A7ADBF93857974424079", hash_generated_field = "EF8D5775B3974DB3958306FC63AF0BE7")

    private int tokStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.142 -0400", hash_original_field = "8B359F3D11E71A51199F8D485E1E0073", hash_generated_field = "345E8F5C06914BAC3B70D4CC8A39CD1A")

    private int tokEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.142 -0400", hash_original_method = "2DC067EE65EE5AEB61F14CBD640EED38", hash_generated_method = "90B4D99E6FA66562090E2203837F21D3")
    public  ATResponseParser(String line) {
        this.line = line;
        // ---------- Original Method ----------
        //this.line = line;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.143 -0400", hash_original_method = "D2BEE04A1EF039BFE740D598D7938B39", hash_generated_method = "736528C13C18403C86C54A807CC25AD4")
    public boolean nextBoolean() {
        nextTok();
        {
            if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
        } //End block
        char c = line.charAt(tokStart);
        if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_119315920 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_119315920;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.144 -0400", hash_original_method = "D8B8577219277F33EAE3DA6AB88F25AB", hash_generated_method = "72C12E5B6D4EADCBF5E415626EADD712")
    public int nextInt() {
        int ret = 0;
        nextTok();
        {
            int i = tokStart;
            {
                char c = line.charAt(i);
                {
                    if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
                } //End block
                ret *= 10;
                ret += c - '0';
            } //End block
        } //End collapsed parenthetic
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8738172 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_8738172;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.144 -0400", hash_original_method = "098AF12FD324D863E13EA52B5E17698D", hash_generated_method = "2A5E4C97F7C434B4A1B582CEC243B85A")
    public String nextString() {
        String varB4EAC82CA7396A68D541C85D26508E83_2066783393 = null; //Variable for return #1
        nextTok();
        varB4EAC82CA7396A68D541C85D26508E83_2066783393 = line.substring(tokStart, tokEnd);
        varB4EAC82CA7396A68D541C85D26508E83_2066783393.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_2066783393;
        // ---------- Original Method ----------
        //nextTok();
        //return line.substring(tokStart, tokEnd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.145 -0400", hash_original_method = "10F6658C8E801D9A6B4832727F713C99", hash_generated_method = "7EEB68D8B07411E859D03B4E7EF4E30B")
    public boolean hasMore() {
        boolean var9DE4D5566B42123C1C443418F59BA9C1_1160598790 = (next < line.length());
        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_590042603 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_590042603;
        // ---------- Original Method ----------
        //return next < line.length();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.145 -0400", hash_original_method = "0441D3F31DB45A49823AD290225E4F8E", hash_generated_method = "AA7238087C92AED1098A9A3354DF2966")
    private void nextTok() {
        int len = line.length();
        {
            skipPrefix();
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
        } //End block
        try 
        {
            char c = line.charAt(next++);
            boolean hasQuote = false;
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
                    boolean var488986A807B0AA949327E1256E728FED_833717794 = (next < len && line.charAt(next++) != ',');
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
                        boolean var986CE0AC04F096ACE050202F107CC62E_1194847588 = (!Character.isWhitespace(c));
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.146 -0400", hash_original_method = "418256DED150EC59875240044DA6104A", hash_generated_method = "F13AF0AD2C7D7E8614FCFB947240648D")
    private char skipWhiteSpace(char c) {
        int len;
        len = line.length();
        {
            boolean varD1EAF0076B3F6CEF9D5427CD7D342734_326297316 = (next < len && Character.isWhitespace(c));
            {
                c = line.charAt(next++);
            } //End block
        } //End collapsed parenthetic
        {
            boolean varBC2264F2A42C701245C9D8635C1E30A5_2079336203 = (Character.isWhitespace(c));
            {
                if (DroidSafeAndroidRuntime.control) throw new ATParseEx();
            } //End block
        } //End collapsed parenthetic
        addTaint(c);
        char varA87DEB01C5F539E6BDA34829C8EF2368_1188406087 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1188406087;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-28 14:14:20.146 -0400", hash_original_method = "1D94A267F6B395134932A5B3B0C0A195", hash_generated_method = "8CCF7C2DCD263BCF30CDA0F38974C1FB")
    private void skipPrefix() {
        next = 0;
        int s = line.length();
        {
            char c = line.charAt(next++);
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

