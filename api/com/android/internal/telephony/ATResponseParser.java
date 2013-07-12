package com.android.internal.telephony;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

public class ATResponseParser {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.585 -0400", hash_original_field = "6438C669E0D0DE98E6929C2CC0FAC474", hash_generated_field = "D67826549E3D41E5CE98380D120E6CF5")

    private String line;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.586 -0400", hash_original_field = "38EA60B61176AFBFDFE18136E198D5E9", hash_generated_field = "AEA186324829F814A60F0A9E76E33097")

    private int next = 0;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.586 -0400", hash_original_field = "2DAFAB33EFF3A7ADBF93857974424079", hash_generated_field = "EF8D5775B3974DB3958306FC63AF0BE7")

    private int tokStart;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.586 -0400", hash_original_field = "8B359F3D11E71A51199F8D485E1E0073", hash_generated_field = "345E8F5C06914BAC3B70D4CC8A39CD1A")

    private int tokEnd;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.586 -0400", hash_original_method = "2DC067EE65EE5AEB61F14CBD640EED38", hash_generated_method = "90B4D99E6FA66562090E2203837F21D3")
    public  ATResponseParser(String line) {
        this.line = line;
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.587 -0400", hash_original_method = "D2BEE04A1EF039BFE740D598D7938B39", hash_generated_method = "3FF91B6B0ACFAC32E28230CD6B28A0B5")
    public boolean nextBoolean() {
        nextTok();
    if(tokEnd - tokStart > 1)        
        {
            ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_68784970 = new ATParseEx();
            varDF8D702F817CA60573E382BA3DEC9A9D_68784970.addTaint(taint);
            throw varDF8D702F817CA60573E382BA3DEC9A9D_68784970;
        } 
        char c = line.charAt(tokStart);
    if(c == '0')        
        {
        boolean var68934A3E9455FA72420237EB05902327_1089548959 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2014130547 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2014130547;
        }
    if(c ==  '1')        
        {
        boolean varB326B5062B2F0E69046810717534CB09_1710476846 = (true);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_56487043 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_56487043;
        }
        ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_2041851468 = new ATParseEx();
        varDF8D702F817CA60573E382BA3DEC9A9D_2041851468.addTaint(taint);
        throw varDF8D702F817CA60573E382BA3DEC9A9D_2041851468;
        
        
        
            
        
        
        
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.587 -0400", hash_original_method = "D8B8577219277F33EAE3DA6AB88F25AB", hash_generated_method = "AA4FEE81EC3851222644B793D6556736")
    public int nextInt() {
        int ret = 0;
        nextTok();
for(int i = tokStart;i < tokEnd;i++)
        {
            char c = line.charAt(i);
    if(c < '0' || c > '9')            
            {
                ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_1757287678 = new ATParseEx();
                varDF8D702F817CA60573E382BA3DEC9A9D_1757287678.addTaint(taint);
                throw varDF8D702F817CA60573E382BA3DEC9A9D_1757287678;
            } 
            ret *= 10;
            ret += c - '0';
        } 
        int var2CB9DF9898E55FD0AD829DC202DDBD1C_1346821617 = (ret);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422459293 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_422459293;
        
        
        
        
            
            
                
            
            
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.588 -0400", hash_original_method = "098AF12FD324D863E13EA52B5E17698D", hash_generated_method = "02B2FBC8A9CAE09DCE9BE46DA708D21E")
    public String nextString() {
        nextTok();
String varA4C6ED80D7BD7C6313759B77A024A3A2_1788779287 =         line.substring(tokStart, tokEnd);
        varA4C6ED80D7BD7C6313759B77A024A3A2_1788779287.addTaint(taint);
        return varA4C6ED80D7BD7C6313759B77A024A3A2_1788779287;
        
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.588 -0400", hash_original_method = "10F6658C8E801D9A6B4832727F713C99", hash_generated_method = "BF454D1A2BD88AA7E30A2E995FEAD251")
    public boolean hasMore() {
        boolean var6025777476581CB9A5AD5A10C75E617E_111544812 = (next < line.length());
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_309806341 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_309806341;
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.590 -0400", hash_original_method = "0441D3F31DB45A49823AD290225E4F8E", hash_generated_method = "D416AF255BD54634A3BD954560D5CA8F")
    private void nextTok() {
        int len = line.length();
    if(next == 0)        
        {
            skipPrefix();
        } 
    if(next >= len)        
        {
            ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_1117089403 = new ATParseEx();
            varDF8D702F817CA60573E382BA3DEC9A9D_1117089403.addTaint(taint);
            throw varDF8D702F817CA60573E382BA3DEC9A9D_1117089403;
        } 
        try 
        {
            char c = line.charAt(next++);
            boolean hasQuote = false;
            c = skipWhiteSpace(c);
    if(c == '"')            
            {
    if(next >= len)                
                {
                    ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_1018804998 = new ATParseEx();
                    varDF8D702F817CA60573E382BA3DEC9A9D_1018804998.addTaint(taint);
                    throw varDF8D702F817CA60573E382BA3DEC9A9D_1018804998;
                } 
                c = line.charAt(next++);
                tokStart = next - 1;
                while
(c != '"' && next < len)                
                {
                    c = line.charAt(next++);
                } 
    if(c != '"')                
                {
                    ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_1049280105 = new ATParseEx();
                    varDF8D702F817CA60573E382BA3DEC9A9D_1049280105.addTaint(taint);
                    throw varDF8D702F817CA60573E382BA3DEC9A9D_1049280105;
                } 
                tokEnd = next - 1;
    if(next < len && line.charAt(next++) != ',')                
                {
                    ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_399603558 = new ATParseEx();
                    varDF8D702F817CA60573E382BA3DEC9A9D_399603558.addTaint(taint);
                    throw varDF8D702F817CA60573E382BA3DEC9A9D_399603558;
                } 
            } 
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
                    } 
    if(next == len)                    
                    {
                        break;
                    } 
                    c = line.charAt(next++);
                } 
            } 
        } 
        catch (StringIndexOutOfBoundsException ex)
        {
            ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_2078781059 = new ATParseEx();
            varDF8D702F817CA60573E382BA3DEC9A9D_2078781059.addTaint(taint);
            throw varDF8D702F817CA60573E382BA3DEC9A9D_2078781059;
        } 
        
        
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.592 -0400", hash_original_method = "418256DED150EC59875240044DA6104A", hash_generated_method = "AB32AC69CBB28D4924CA5CB7CF3B72DD")
    private char skipWhiteSpace(char c) {
        addTaint(c);
        int len;
        len = line.length();
        while
(next < len && Character.isWhitespace(c))        
        {
            c = line.charAt(next++);
        } 
    if(Character.isWhitespace(c))        
        {
            ATParseEx varDF8D702F817CA60573E382BA3DEC9A9D_595820322 = new ATParseEx();
            varDF8D702F817CA60573E382BA3DEC9A9D_595820322.addTaint(taint);
            throw varDF8D702F817CA60573E382BA3DEC9A9D_595820322;
        } 
        char var4A8A08F09D37B73795649038408B5F33_2053476765 = (c);
                char varA87DEB01C5F539E6BDA34829C8EF2368_1208812236 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1208812236;
        
        
        
        
            
        
        
            
        
        
    }

    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:48:19.592 -0400", hash_original_method = "1D94A267F6B395134932A5B3B0C0A195", hash_generated_method = "080063B67FE2ECAEE5448CFFF06D0FD3")
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
            } 
        } 
        ATParseEx varC5AFE13D63FF09DE11E7747293E3B8D8_797890138 = new ATParseEx("missing prefix");
        varC5AFE13D63FF09DE11E7747293E3B8D8_797890138.addTaint(taint);
        throw varC5AFE13D63FF09DE11E7747293E3B8D8_797890138;
        
        
        
        
            
            
                
            
        
        
    }

    
}

