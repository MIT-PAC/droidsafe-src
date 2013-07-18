package com.android.internal.telephony;

// Droidsafe Imports
import droidsafe.annotations.DSC;
import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;
import droidsafe.annotations.DSModeled;

public class ATResponseParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.266 -0400", hash_original_field = "6438C669E0D0DE98E6929C2CC0FAC474", hash_generated_field = "D67826549E3D41E5CE98380D120E6CF5")

    private String line;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.267 -0400", hash_original_field = "38EA60B61176AFBFDFE18136E198D5E9", hash_generated_field = "AEA186324829F814A60F0A9E76E33097")

    private int next = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.267 -0400", hash_original_field = "2DAFAB33EFF3A7ADBF93857974424079", hash_generated_field = "EF8D5775B3974DB3958306FC63AF0BE7")

    private int tokStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.267 -0400", hash_original_field = "8B359F3D11E71A51199F8D485E1E0073", hash_generated_field = "345E8F5C06914BAC3B70D4CC8A39CD1A")

    private int tokEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.267 -0400", hash_original_method = "2DC067EE65EE5AEB61F14CBD640EED38", hash_generated_method = "90B4D99E6FA66562090E2203837F21D3")
    public  ATResponseParser(String line) {
        this.line = line;
        // ---------- Original Method ----------
        //this.line = line;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.267 -0400", hash_original_method = "D2BEE04A1EF039BFE740D598D7938B39", hash_generated_method = "CF43656056F89F03172AD80E7680D4D2")
    public boolean nextBoolean() {
        nextTok();
        if(tokEnd - tokStart > 1)        
        {
            ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_1382003888 = new ATParseEx();
            varDF8D702F817CA60573E382BA3DEC9A9D_1382003888.addTaint(taint);
            throw varDF8D702F817CA60573E382BA3DEC9A9D_1382003888;
        } //End block
        char c = line.charAt(tokStart);
        if(c == '0')        
        {
        boolean var68934A3E9455FA72420237EB05902327_1789519088 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_221150652 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_221150652;
        }
        if(c ==  '1')        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1548447871 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1009792295 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1009792295;
        }
        ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_339850679 = new ATParseEx();
        varDF8D702F817CA60573E382BA3DEC9A9D_339850679.addTaint(taint);
        throw varDF8D702F817CA60573E382BA3DEC9A9D_339850679;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.268 -0400", hash_original_method = "D8B8577219277F33EAE3DA6AB88F25AB", hash_generated_method = "D739903131E1C897DBA6A70C5FD5DFC8")
    public int nextInt() {
        int ret = 0;
        nextTok();
for(int i = tokStart;i < tokEnd;i++)
        {
            char c = line.charAt(i);
            if(c < '0' || c > '9')            
            {
                ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_1665228303 = new ATParseEx();
                varDF8D702F817CA60573E382BA3DEC9A9D_1665228303.addTaint(taint);
                throw varDF8D702F817CA60573E382BA3DEC9A9D_1665228303;
            } //End block
            ret *= 10;
            ret += c - '0';
        } //End block
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_1441322679 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990768352 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_990768352;
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

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.269 -0400", hash_original_method = "098AF12FD324D863E13EA52B5E17698D", hash_generated_method = "74D936D17813AAD968F9BC841BF853F0")
    public String nextString() {
        nextTok();
String varA4C6ED80D7BD7C6313759B77A024A3A2_1908455533 =         line.substring(tokStart, tokEnd);
        varA4C6ED80D7BD7C6313759B77A024A3A2_1908455533.addTaint(taint);
        return varA4C6ED80D7BD7C6313759B77A024A3A2_1908455533;
        // ---------- Original Method ----------
        //nextTok();
        //return line.substring(tokStart, tokEnd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.269 -0400", hash_original_method = "10F6658C8E801D9A6B4832727F713C99", hash_generated_method = "66ABBE79AC471142FF8F7FFA04ED4DD6")
    public boolean hasMore() {
        boolean var6025777476581CB9A5AD5A10C75E617E_1539499950 = (next < line.length());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1063955759 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1063955759;
        // ---------- Original Method ----------
        //return next < line.length();
    }

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.271 -0400", hash_original_method = "0441D3F31DB45A49823AD290225E4F8E", hash_generated_method = "71F498A2AC4489B87AB0606231FE438B")
    private void nextTok() {
        int len = line.length();
        if(next == 0)        
        {
            skipPrefix();
        } //End block
        if(next >= len)        
        {
            ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_298800280 = new ATParseEx();
            varDF8D702F817CA60573E382BA3DEC9A9D_298800280.addTaint(taint);
            throw varDF8D702F817CA60573E382BA3DEC9A9D_298800280;
        } //End block
        try 
        {
            char c = line.charAt(next++);
            boolean hasQuote = false;
            c = skipWhiteSpace(c);
            if(c == '"')            
            {
                if(next >= len)                
                {
                    ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_493872672 = new ATParseEx();
                    varDF8D702F817CA60573E382BA3DEC9A9D_493872672.addTaint(taint);
                    throw varDF8D702F817CA60573E382BA3DEC9A9D_493872672;
                } //End block
                c = line.charAt(next++);
                tokStart = next - 1;
                while
(c != '"' && next < len)                
                {
                    c = line.charAt(next++);
                } //End block
                if(c != '"')                
                {
                    ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_1402026711 = new ATParseEx();
                    varDF8D702F817CA60573E382BA3DEC9A9D_1402026711.addTaint(taint);
                    throw varDF8D702F817CA60573E382BA3DEC9A9D_1402026711;
                } //End block
                tokEnd = next - 1;
                if(next < len && line.charAt(next++) != ',')                
                {
                    ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_1619400949 = new ATParseEx();
                    varDF8D702F817CA60573E382BA3DEC9A9D_1619400949.addTaint(taint);
                    throw varDF8D702F817CA60573E382BA3DEC9A9D_1619400949;
                } //End block
            } //End block
            else
            {
                tokStart = next - 1;
                tokEnd = tokStart;
                while
(c != ',')                
                {
                    if(!Character.isWhitespace(c))                    
                    {
                        tokEnd = next;
                    } //End block
                    if(next == len)                    
                    {
                        break;
                    } //End block
                    c = line.charAt(next++);
                } //End block
            } //End block
        } //End block
        catch (StringIndexOutOfBoundsException ex)
        {
            ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_1734825592 = new ATParseEx();
            varDF8D702F817CA60573E382BA3DEC9A9D_1734825592.addTaint(taint);
            throw varDF8D702F817CA60573E382BA3DEC9A9D_1734825592;
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.274 -0400", hash_original_method = "418256DED150EC59875240044DA6104A", hash_generated_method = "17D08790EA4A082751A988013E200436")
    private char skipWhiteSpace(char c) {
        addTaint(c);
        int len;
        len = line.length();
        while
(next < len && Character.isWhitespace(c))        
        {
            c = line.charAt(next++);
        } //End block
        if(Character.isWhitespace(c))        
        {
            ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_2836421 = new ATParseEx();
            varDF8D702F817CA60573E382BA3DEC9A9D_2836421.addTaint(taint);
            throw varDF8D702F817CA60573E382BA3DEC9A9D_2836421;
        } //End block
        char var4A8A08F09D37B73795649038408B5F33_295829102 = (c);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1106286829 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1106286829;
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

    
        @DSModeled(DSC.BAN)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:11.275 -0400", hash_original_method = "1D94A267F6B395134932A5B3B0C0A195", hash_generated_method = "6320F821AD87C32F8E8BFE5EFE1796EF")
    private void skipPrefix() {
        next = 0;
        int s = line.length();
        while
(next < s)        
        {
            char c = line.charAt(next++);
            if(c == ':')            
            {
                return;
            } //End block
        } //End block
        ATParseEx varC5AFE13D63FF09DE11E7747293E3B8D8_601270754 = new ATParseEx("missing prefix");
        varC5AFE13D63FF09DE11E7747293E3B8D8_601270754.addTaint(taint);
        throw varC5AFE13D63FF09DE11E7747293E3B8D8_601270754;
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

