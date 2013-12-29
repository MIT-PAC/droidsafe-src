package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class ATResponseParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.653 -0500", hash_original_field = "3627E23FB85D13386D00E9B32A363F83", hash_generated_field = "D67826549E3D41E5CE98380D120E6CF5")


    private String line;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.655 -0500", hash_original_field = "87EB6EAD268EF2EF71FED639D7336DA6", hash_generated_field = "AEA186324829F814A60F0A9E76E33097")

    private int next = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.267 -0400", hash_original_field = "2DAFAB33EFF3A7ADBF93857974424079", hash_generated_field = "EF8D5775B3974DB3958306FC63AF0BE7")

    private int tokStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.267 -0400", hash_original_field = "8B359F3D11E71A51199F8D485E1E0073", hash_generated_field = "345E8F5C06914BAC3B70D4CC8A39CD1A")

    private int tokEnd;

    /***************************** Class Methods *****************************/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.657 -0500", hash_original_method = "2DC067EE65EE5AEB61F14CBD640EED38", hash_generated_method = "29B08364401AE1C2C8FFB7EC4FD994A9")
    public ATResponseParser (String line)
    {
        this.line = line;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.658 -0500", hash_original_method = "D2BEE04A1EF039BFE740D598D7938B39", hash_generated_method = "208418BA72C22CC2181B6A4F081A3619")
    public boolean
    nextBoolean()
    {
        // "\s*(\d)(,|$)"
        // \d is '0' or '1'

        nextTok();

        if (tokEnd - tokStart > 1) {
            throw new ATParseEx();
        }
        char c = line.charAt(tokStart);

        if (c == '0') return false;
        if (c ==  '1') return true;
        throw new ATParseEx();
    }


    /** positive int only */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.659 -0500", hash_original_method = "D8B8577219277F33EAE3DA6AB88F25AB", hash_generated_method = "E8E2B6FBE224BAA7C30E7FAF5E2CD4A6")
    public int
    nextInt()
    {
        // "\s*(\d+)(,|$)"
        int ret = 0;

        nextTok();

        for (int i = tokStart ; i < tokEnd ; i++) {
            char c = line.charAt(i);

            // Yes, ASCII decimal digits only
            if (c < '0' || c > '9') {
                throw new ATParseEx();
            }

            ret *= 10;
            ret += c - '0';
        }

        return ret;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.660 -0500", hash_original_method = "098AF12FD324D863E13EA52B5E17698D", hash_generated_method = "166CB708896172395E3726729E517306")
    public String
    nextString()
    {
        nextTok();

        return line.substring(tokStart, tokEnd);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.660 -0500", hash_original_method = "10F6658C8E801D9A6B4832727F713C99", hash_generated_method = "772C810FF475263A450A05E64148B030")
    public boolean
    hasMore()
    {
        return next < line.length();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.662 -0500", hash_original_method = "0441D3F31DB45A49823AD290225E4F8E", hash_generated_method = "0B19355957898A14CBCE7D9492B71AF5")
    private void
    nextTok()
    {
        int len = line.length();

        if (next == 0) {
            skipPrefix();
        }

        if (next >= len) {
            throw new ATParseEx();
        }

        try {
            // \s*("([^"]*)"|(.*)\s*)(,|$)

            char c = line.charAt(next++);
            boolean hasQuote = false;

            c = skipWhiteSpace(c);

            if (c == '"') {
                if (next >= len) {
                    throw new ATParseEx();
                }
                c = line.charAt(next++);
                tokStart = next - 1;
                while (c != '"' && next < len) {
                    c = line.charAt(next++);
                }
                if (c != '"') {
                    throw new ATParseEx();
                }
                tokEnd = next - 1;
                if (next < len && line.charAt(next++) != ',') {
                    throw new ATParseEx();
                }
            } else {
                tokStart = next - 1;
                tokEnd = tokStart;
                while (c != ',') {
                    if (!Character.isWhitespace(c)) {
                        tokEnd = next;
                    }
                    if (next == len) {
                        break;
                    }
                    c = line.charAt(next++);
                }
            }
        } catch (StringIndexOutOfBoundsException ex) {
            throw new ATParseEx();
        }
    }


    /** Throws ATParseEx if whitespace extends to the end of string */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.663 -0500", hash_original_method = "418256DED150EC59875240044DA6104A", hash_generated_method = "8D968F93EAB2D7A400AB6776E32FE6E3")
    private char
    skipWhiteSpace (char c)
    {
        int len;
        len = line.length();
        while (next < len && Character.isWhitespace(c)) {
            c = line.charAt(next++);
        }

        if (Character.isWhitespace(c)) {
            throw new ATParseEx();
        }
        return c;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:30.664 -0500", hash_original_method = "1D94A267F6B395134932A5B3B0C0A195", hash_generated_method = "FE611489707CC77209F852F7A49C603B")
    private void
    skipPrefix()
    {
        // consume "^[^:]:"

        next = 0;
        int s = line.length();
        while (next < s){
            char c = line.charAt(next++);

            if (c == ':') {
                return;
            }
        }

        throw new ATParseEx("missing prefix");
    }

    
}

