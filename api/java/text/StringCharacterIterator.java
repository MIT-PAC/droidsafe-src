package java.text;

// Droidsafe Imports
import droidsafe.annotations.*;





public final class StringCharacterIterator implements CharacterIterator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.313 -0400", hash_original_field = "B45CFFE084DD3D20D928BEE85E7B0F21", hash_generated_field = "38EA5C212184AA9651934368805B840B")

    String string;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.313 -0400", hash_original_field = "EA2B2676C28C0DB26D39331A336C6B92", hash_generated_field = "A420862623A673AB42FCEC90A616158F")

    int start;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.313 -0400", hash_original_field = "7F021A1415B86F2D013B2618FB31AE53", hash_generated_field = "302E5A3147803830441A79AED31F4022")

    int end;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.313 -0400", hash_original_field = "7A86C157EE9713C34FBD7A1EE40F0C5A", hash_generated_field = "B7E810BF01B52122CB927525A0CA4721")

    int offset;
    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.314 -0400", hash_original_method = "DAE1DA2C567D7E8FDA6EBD1FE5405924", hash_generated_method = "61D955F47042EEBAE171065441D93BDE")
    public  StringCharacterIterator(String value) {
        string = value;
        start = offset = 0;
        end = string.length();
        // ---------- Original Method ----------
        //string = value;
        //start = offset = 0;
        //end = string.length();
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.315 -0400", hash_original_method = "5C2CF51DC0D0A9D0DCD2C7E4ADB28E8E", hash_generated_method = "8389284849958691A5392D086BEAD7D7")
    public  StringCharacterIterator(String value, int location) {
        string = value;
        start = 0;
        end = string.length();
        if(location < 0 || location > end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1100349275 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1100349275.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1100349275;
        } //End block
        offset = location;
        // ---------- Original Method ----------
        //string = value;
        //start = 0;
        //end = string.length();
        //if (location < 0 || location > end) {
            //throw new IllegalArgumentException();
        //}
        //offset = location;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.317 -0400", hash_original_method = "704865465DB7061F34F598DD3605E202", hash_generated_method = "AE555DCB18C1C073EB8245FF54746277")
    public  StringCharacterIterator(String value, int start, int end, int location) {
        string = value;
        if(start < 0 || end > string.length() || start > end
                || location < start || location > end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_609427523 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_609427523.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_609427523;
        } //End block
        this.start = start;
        this.end = end;
        offset = location;
        // ---------- Original Method ----------
        //string = value;
        //if (start < 0 || end > string.length() || start > end
                //|| location < start || location > end) {
            //throw new IllegalArgumentException();
        //}
        //this.start = start;
        //this.end = end;
        //offset = location;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.318 -0400", hash_original_method = "0B6FE6D01B20019581445CB40F5DED3F", hash_generated_method = "90488857828136DA25515E81385D3C39")
    @Override
    public Object clone() {
        try 
        {
Object var46F3A0D86742C1D6E099C2B166941A33_1632828299 =             super.clone();
            var46F3A0D86742C1D6E099C2B166941A33_1632828299.addTaint(taint);
            return var46F3A0D86742C1D6E099C2B166941A33_1632828299;
        } //End block
        catch (CloneNotSupportedException e)
        {
            AssertionError varA5A331D65C8C3F32D42E49D64BCF4109_1044283466 = new AssertionError(e);
            varA5A331D65C8C3F32D42E49D64BCF4109_1044283466.addTaint(taint);
            throw varA5A331D65C8C3F32D42E49D64BCF4109_1044283466;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return super.clone();
        //} catch (CloneNotSupportedException e) {
            //throw new AssertionError(e);
        //}
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.319 -0400", hash_original_method = "0495E4BE554B279F8C8552A3E8BBAE9B", hash_generated_method = "5D1633C796ECBA619A200C3E134DBFF1")
    public char current() {
        if(offset == end)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_1319531160 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1278927108 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1278927108;
        } //End block
        char var721AA069F761152C09EB16E9E8C899B9_44565144 = (string.charAt(offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1498600195 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1498600195;
        // ---------- Original Method ----------
        //if (offset == end) {
            //return DONE;
        //}
        //return string.charAt(offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.319 -0400", hash_original_method = "4A7E92C9AA8B158215F27F7CAB59071D", hash_generated_method = "78BBA4BFDAFE2AB2674C80BFF814B0F3")
    @Override
    public boolean equals(Object object) {
        addTaint(object.getTaint());
        if(!(object instanceof StringCharacterIterator))        
        {
            boolean var68934A3E9455FA72420237EB05902327_341243810 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1818942368 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1818942368;
        } //End block
        StringCharacterIterator it = (StringCharacterIterator) object;
        boolean varE97EE582A82473061DA20F1E791A5FE2_348062224 = (string.equals(it.string) && start == it.start && end == it.end
                && offset == it.offset);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_611853576 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_611853576;
        // ---------- Original Method ----------
        //if (!(object instanceof StringCharacterIterator)) {
            //return false;
        //}
        //StringCharacterIterator it = (StringCharacterIterator) object;
        //return string.equals(it.string) && start == it.start && end == it.end
                //&& offset == it.offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.320 -0400", hash_original_method = "B333B42236D9FFA1243D291D9F8E02D4", hash_generated_method = "FFCFFA478B207BE03EA683609F7CF5B1")
    public char first() {
        if(start == end)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_425435345 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1895754082 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1895754082;
        } //End block
        offset = start;
        char var721AA069F761152C09EB16E9E8C899B9_1559191766 = (string.charAt(offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_549790684 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_549790684;
        // ---------- Original Method ----------
        //if (start == end) {
            //return DONE;
        //}
        //offset = start;
        //return string.charAt(offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.320 -0400", hash_original_method = "C91A51EED2BDD0863CA60178FB31B7F7", hash_generated_method = "A8AA1F29232928BAE0F24C77C2C03EB0")
    public int getBeginIndex() {
        int varEA2B2676C28C0DB26D39331A336C6B92_2018583549 = (start);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045379067 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2045379067;
        // ---------- Original Method ----------
        //return start;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.320 -0400", hash_original_method = "2693C2AA223CB37D0504CD257C6327BC", hash_generated_method = "256E2BE59E5C60436C60E51C7F6C1C43")
    public int getEndIndex() {
        int var7F021A1415B86F2D013B2618FB31AE53_114260889 = (end);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_871464193 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_871464193;
        // ---------- Original Method ----------
        //return end;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.321 -0400", hash_original_method = "0952456464DB8DF9DBB7507E3C2ED53C", hash_generated_method = "A7887C3FA53814D7A2906810589E0E4A")
    public int getIndex() {
        int var7A86C157EE9713C34FBD7A1EE40F0C5A_1673911562 = (offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688463878 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1688463878;
        // ---------- Original Method ----------
        //return offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.321 -0400", hash_original_method = "261EF3CD78C94C444435F1728CE93178", hash_generated_method = "021C461A3678F92363B969E1367020C0")
    @Override
    public int hashCode() {
        int var1EE1504AE6C76CDF0E633425310C3EEC_553030073 = (string.hashCode() + start + end + offset);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620890332 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_620890332;
        // ---------- Original Method ----------
        //return string.hashCode() + start + end + offset;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.321 -0400", hash_original_method = "920E2CC099037AFE91302301CF7E9F3E", hash_generated_method = "5C8C1299734E0E129BFCCDFEB2ED8827")
    public char last() {
        if(start == end)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_361894220 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1519515224 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1519515224;
        } //End block
        offset = end - 1;
        char var721AA069F761152C09EB16E9E8C899B9_1104248638 = (string.charAt(offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1417995545 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1417995545;
        // ---------- Original Method ----------
        //if (start == end) {
            //return DONE;
        //}
        //offset = end - 1;
        //return string.charAt(offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.322 -0400", hash_original_method = "8F260F0099582263F775831BBCA28C0F", hash_generated_method = "A1690CA04E7C9041A633CA93C86E1E5E")
    public char next() {
        if(offset >= (end - 1))        
        {
            offset = end;
            char var2BA22E58CA17BB728D522BBA36CF8350_894340448 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1321304435 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1321304435;
        } //End block
        char var8120EFC8EA6EC39FFC83C09CBC143231_1896360660 = (string.charAt(++offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1220919975 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1220919975;
        // ---------- Original Method ----------
        //if (offset >= (end - 1)) {
            //offset = end;
            //return DONE;
        //}
        //return string.charAt(++offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.322 -0400", hash_original_method = "6641F70E0E9C6153122A4B9C58397241", hash_generated_method = "17997B51659C83F8488E1DE1EB240127")
    public char previous() {
        if(offset == start)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_1463209017 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1954836160 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1954836160;
        } //End block
        char var85D9FBB298252268E258650FAC9E12B3_1348526944 = (string.charAt(--offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_264362576 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_264362576;
        // ---------- Original Method ----------
        //if (offset == start) {
            //return DONE;
        //}
        //return string.charAt(--offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.323 -0400", hash_original_method = "EE5D609C4869D1C6E36BED6C6655B503", hash_generated_method = "F7F0672E18F0CAF673135DB2931374DA")
    public char setIndex(int location) {
        if(location < start || location > end)        
        {
            IllegalArgumentException var5783EF97022AA508B74A1E3EA38534AF_1495137145 = new IllegalArgumentException();
            var5783EF97022AA508B74A1E3EA38534AF_1495137145.addTaint(taint);
            throw var5783EF97022AA508B74A1E3EA38534AF_1495137145;
        } //End block
        offset = location;
        if(offset == end)        
        {
            char var2BA22E58CA17BB728D522BBA36CF8350_622266425 = (DONE);
                        char varA87DEB01C5F539E6BDA34829C8EF2368_1557254437 = getTaintChar();
            return varA87DEB01C5F539E6BDA34829C8EF2368_1557254437;
        } //End block
        char var721AA069F761152C09EB16E9E8C899B9_1820451435 = (string.charAt(offset));
                char varA87DEB01C5F539E6BDA34829C8EF2368_1170174209 = getTaintChar();
        return varA87DEB01C5F539E6BDA34829C8EF2368_1170174209;
        // ---------- Original Method ----------
        //if (location < start || location > end) {
            //throw new IllegalArgumentException();
        //}
        //offset = location;
        //if (offset == end) {
            //return DONE;
        //}
        //return string.charAt(offset);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:24:58.324 -0400", hash_original_method = "C3050CECF999A44D7D35577309274942", hash_generated_method = "16F449977253B2E84B6BB597D2C69A77")
    public void setText(String value) {
        string = value;
        start = offset = 0;
        end = value.length();
        // ---------- Original Method ----------
        //string = value;
        //start = offset = 0;
        //end = value.length();
    }

    
}

