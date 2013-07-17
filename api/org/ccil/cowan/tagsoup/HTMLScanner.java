package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.*;
import org.xml.sax.SAXException;
import org.xml.sax.Locator;

public class HTMLScanner implements Scanner, Locator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.834 -0400", hash_original_field = "BD3C6DEEF8852BB42141E913BBA840E8", hash_generated_field = "5DE7612FB52B4C7CD7CF6BE3E02E09B6")

    private String thePublicid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.834 -0400", hash_original_field = "1EF74CA2C18D4B1096919D4DCD34B6E0", hash_generated_field = "9A678ABFCD87282CEC96ECE7EA2137F4")

    private String theSystemid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_field = "2E34B41773FC69D7C11F409A5E94C2B9", hash_generated_field = "002B529451A6709EF216BD8F8F7D4F81")

    private int theLastLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_field = "D0ED4454AD7B9B58066BE371F3FE580C", hash_generated_field = "F4A44194D173076DCB26B2C8E351310B")

    private int theLastColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_field = "25DC9E914F5BE785CE1529E8CEC45D2B", hash_generated_field = "1E986C0C45EC0CBFCB2541DDE893227E")

    private int theCurrentLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_field = "8BACECFED60B1EE08C52E677CDEBE6CD", hash_generated_field = "A6C1CC9770372CF135647494BE6B1EA7")

    private int theCurrentColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_field = "7D285F98B2C714536428EBC96A3E3736", hash_generated_field = "2A9B3707FE4B47A183CA387F06CD96C3")

    int theState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_field = "B020CFF806AA29820EB9C46EA3FEB21A", hash_generated_field = "B539E59DE16ED9BC0EA86219F312D4FD")

    int theNextState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_field = "CEA2DA4D480E410EF586AD3F4F4B5C2B", hash_generated_field = "BFE6CE6F03989DB396BE3B22A5F736FE")

    char[] theOutputBuffer = new char[200];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_field = "11D4DAC72FACB9A9EF8FB95B42B3C959", hash_generated_field = "22B5A69CFAB142C36A53904D0940E17C")

    int theSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_field = "26C43D09D55C2310EBC32EA5E6FDF4DC", hash_generated_field = "542BE9D4F64152B2AED96D4C22F1251F")

    int[] theWinMap = {				
		0x20AC, 0xFFFD, 0x201A, 0x0192, 0x201E, 0x2026, 0x2020, 0x2021,
		0x02C6, 0x2030, 0x0160, 0x2039, 0x0152, 0xFFFD, 0x017D, 0xFFFD,
		0xFFFD, 0x2018, 0x2019, 0x201C, 0x201D, 0x2022, 0x2013, 0x2014,
		0x02DC, 0x2122, 0x0161, 0x203A, 0x0153, 0xFFFD, 0x017E, 0x0178};
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_method = "A8030374AECACF3BB4D2A2FA58C4A7D8", hash_generated_method = "A8030374AECACF3BB4D2A2FA58C4A7D8")
    public HTMLScanner ()
    {
        //Synthesized constructor
    }


        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.835 -0400", hash_original_method = "7BF7C7D5830ADAF76FEF60D8F3F10567", hash_generated_method = "890AFDC0362A983D917AD9F3C0B327CD")
    private void unread(PushbackReader r, int c) throws IOException {
        addTaint(c);
        addTaint(r.getTaint());
        if(c != -1)        
        r.unread(c);
        // ---------- Original Method ----------
        //if (c != -1) r.unread(c);
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.836 -0400", hash_original_method = "17D8C6B884298309CDBB8C115CEF45AD", hash_generated_method = "250BFA5BADC0CEA43E644147A31C1CD3")
    public int getLineNumber() {
        int var2E34B41773FC69D7C11F409A5E94C2B9_1162911553 = (theLastLine);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456079948 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_456079948;
        // ---------- Original Method ----------
        //return theLastLine;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.836 -0400", hash_original_method = "CC76CCC6A19838EC65870F98307D39F4", hash_generated_method = "BA4FC9CEC114F54F7C4469F75063CB87")
    public int getColumnNumber() {
        int varD0ED4454AD7B9B58066BE371F3FE580C_2051928577 = (theLastColumn);
                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344865481 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_344865481;
        // ---------- Original Method ----------
        //return theLastColumn;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.836 -0400", hash_original_method = "EE9557AC8121925813378C18555B01E0", hash_generated_method = "17F552ED53B27B8D1B4949DF699FE3CF")
    public String getPublicId() {
String var1DBC46D2465A49E95EB3980BC6533132_1153430222 =         thePublicid;
        var1DBC46D2465A49E95EB3980BC6533132_1153430222.addTaint(taint);
        return var1DBC46D2465A49E95EB3980BC6533132_1153430222;
        // ---------- Original Method ----------
        //return thePublicid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.837 -0400", hash_original_method = "B52DC32D5FB92F39EE1C6D62A566FA39", hash_generated_method = "1A970CE513280896BAF9FE5B0D4F267A")
    public String getSystemId() {
String varA3B6F3DF0A8A325DDC3609E1800ED4DA_1987528967 =         theSystemid;
        varA3B6F3DF0A8A325DDC3609E1800ED4DA_1987528967.addTaint(taint);
        return varA3B6F3DF0A8A325DDC3609E1800ED4DA_1987528967;
        // ---------- Original Method ----------
        //return theSystemid;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.837 -0400", hash_original_method = "0F092EE343E640C5A578BAEFAE8AEFB5", hash_generated_method = "75FB287F9A48CFCE5989892AD073900A")
    public void resetDocumentLocator(String publicid, String systemid) {
        thePublicid = publicid;
        theSystemid = systemid;
        theLastLine = theLastColumn = theCurrentLine = theCurrentColumn = 0;
        // ---------- Original Method ----------
        //thePublicid = publicid;
        //theSystemid = systemid;
        //theLastLine = theLastColumn = theCurrentLine = theCurrentColumn = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.844 -0400", hash_original_method = "D85CBFA2F1A37C13B743BA6B1C12F2CC", hash_generated_method = "269A96E09186BFD3D9B4BEB628F16A69")
    public void scan(Reader r0, ScanHandler h) throws IOException, SAXException {
        addTaint(h.getTaint());
        addTaint(r0.getTaint());
        theState = S_PCDATA;
        PushbackReader r;
        if(r0 instanceof PushbackReader)        
        {
            r = (PushbackReader)r0;
        } //End block
        else
        if(r0 instanceof BufferedReader)        
        {
            r = new PushbackReader(r0);
        } //End block
        else
        {
            r = new PushbackReader(new BufferedReader(r0, 200));
        } //End block
        int firstChar = r.read();
        if(firstChar != '\uFEFF')        
        unread(r, firstChar);
        while
(theState != S_DONE)        
        {
            int ch = r.read();
            if(ch >= 0x80 && ch <= 0x9F)            
            ch = theWinMap[ch-0x80];
            if(ch == '\r')            
            {
                ch = r.read();
                if(ch != '\n')                
                {
                    unread(r, ch);
                    ch = '\n';
                } //End block
            } //End block
            if(ch == '\n')            
            {
                theCurrentLine++;
                theCurrentColumn = 0;
            } //End block
            else
            {
                theCurrentColumn++;
            } //End block
            if(!(ch >= 0x20 || ch == '\n' || ch == '\t' || ch == -1))            
            continue;
            int action = 0;
for(int i = 0;i < statetable.length;i += 4)
            {
                if(theState != statetable[i])                
                {
                    if(action != 0)                    
                    break;
                    continue;
                } //End block
                if(statetable[i+1] == 0)                
                {
                    action = statetable[i+2];
                    theNextState = statetable[i+3];
                } //End block
                else
                if(statetable[i+1] == ch)                
                {
                    action = statetable[i+2];
                    theNextState = statetable[i+3];
                    break;
                } //End block
            } //End block
switch(action){
            case 0:
            Error varB82BAE6527CD51306D59675D0459D506_714417810 = new Error(
"HTMLScanner can't cope with " + Integer.toString(ch) + " in state " +
Integer.toString(theState));
            varB82BAE6527CD51306D59675D0459D506_714417810.addTaint(taint);
            throw varB82BAE6527CD51306D59675D0459D506_714417810;
            case A_ADUP:
            h.adup(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_ADUP_SAVE:
            h.adup(theOutputBuffer, 0, theSize);
            theSize = 0;
            save(ch, h);
            break;
            case A_ADUP_STAGC:
            h.adup(theOutputBuffer, 0, theSize);
            theSize = 0;
            h.stagc(theOutputBuffer, 0, theSize);
            break;
            case A_ANAME:
            h.aname(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_ANAME_ADUP:
            h.aname(theOutputBuffer, 0, theSize);
            theSize = 0;
            h.adup(theOutputBuffer, 0, theSize);
            break;
            case A_ANAME_ADUP_STAGC:
            h.aname(theOutputBuffer, 0, theSize);
            theSize = 0;
            h.adup(theOutputBuffer, 0, theSize);
            h.stagc(theOutputBuffer, 0, theSize);
            break;
            case A_AVAL:
            h.aval(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_AVAL_STAGC:
            h.aval(theOutputBuffer, 0, theSize);
            theSize = 0;
            h.stagc(theOutputBuffer, 0, theSize);
            break;
            case A_CDATA:
            mark();
            if(theSize > 1)            
            theSize -= 2;
            h.pcdata(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_ENTITY_START:
            h.pcdata(theOutputBuffer, 0, theSize);
            theSize = 0;
            save(ch, h);
            break;
            case A_ENTITY:
            mark();
            char ch1 = (char)ch;
            if(theState == S_ENT && ch1 == '#')            
            {
                theNextState = S_NCR;
                save(ch, h);
                break;
            } //End block
            else
            if(theState == S_NCR && (ch1 == 'x' || ch1 == 'X'))            
            {
                theNextState = S_XNCR;
                save(ch, h);
                break;
            } //End block
            else
            if(theState == S_ENT && Character.isLetterOrDigit(ch1))            
            {
                save(ch, h);
                break;
            } //End block
            else
            if(theState == S_NCR && Character.isDigit(ch1))            
            {
                save(ch, h);
                break;
            } //End block
            else
            if(theState == S_XNCR && (Character.isDigit(ch1) || "abcdefABCDEF".indexOf(ch1) != -1))            
            {
                save(ch, h);
                break;
            } //End block
            h.entity(theOutputBuffer, 1, theSize - 1);
            int ent = h.getEntity();
            if(ent != 0)            
            {
                theSize = 0;
                if(ent >= 0x80 && ent <= 0x9F)                
                {
                    ent = theWinMap[ent-0x80];
                } //End block
                if(ent < 0x20)                
                {
                    ent = 0x20;
                } //End block
                else
                if(ent >= 0xD800 && ent <= 0xDFFF)                
                {
                    ent = 0;
                } //End block
                else
                if(ent <= 0xFFFF)                
                {
                    save(ent, h);
                } //End block
                else
                {
                    ent -= 0x10000;
                    save((ent>>10) + 0xD800, h);
                    save((ent&0x3FF) + 0xDC00, h);
                } //End block
                if(ch != ';')                
                {
                    unread(r, ch);
                    theCurrentColumn--;
                } //End block
            } //End block
            else
            {
                unread(r, ch);
                theCurrentColumn--;
            } //End block
            theNextState = S_PCDATA;
            break;
            case A_ETAG:
            h.etag(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_DECL:
            h.decl(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_GI:
            h.gi(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_GI_STAGC:
            h.gi(theOutputBuffer, 0, theSize);
            theSize = 0;
            h.stagc(theOutputBuffer, 0, theSize);
            break;
            case A_LT:
            mark();
            save('<', h);
            save(ch, h);
            break;
            case A_LT_PCDATA:
            mark();
            save('<', h);
            h.pcdata(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_PCDATA:
            mark();
            h.pcdata(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_CMNT:
            mark();
            h.cmnt(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_MINUS3:
            save('-', h);
            save(' ', h);
            break;
            case A_MINUS2:
            save('-', h);
            save(' ', h);
            case A_MINUS:
            save('-', h);
            save(ch, h);
            break;
            case A_PI:
            mark();
            h.pi(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_PITARGET:
            h.pitarget(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_PITARGET_PI:
            h.pitarget(theOutputBuffer, 0, theSize);
            theSize = 0;
            h.pi(theOutputBuffer, 0, theSize);
            break;
            case A_SAVE:
            save(ch, h);
            break;
            case A_SKIP:
            break;
            case A_SP:
            save(' ', h);
            break;
            case A_STAGC:
            h.stagc(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            case A_EMPTYTAG:
            mark();
            if(theSize > 0)            
            h.gi(theOutputBuffer, 0, theSize);
            theSize = 0;
            h.stage(theOutputBuffer, 0, theSize);
            break;
            case A_UNGET:
            unread(r, ch);
            theCurrentColumn--;
            break;
            case A_UNSAVE_PCDATA:
            if(theSize > 0)            
            theSize--;
            h.pcdata(theOutputBuffer, 0, theSize);
            theSize = 0;
            break;
            default:
            Error var0FB12B56B461A3FE1F82DABD91C7306F_439703707 = new Error("Can't process state " + action);
            var0FB12B56B461A3FE1F82DABD91C7306F_439703707.addTaint(taint);
            throw var0FB12B56B461A3FE1F82DABD91C7306F_439703707;
}            theState = theNextState;
        } //End block
        h.eof(theOutputBuffer, 0, 0);
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.846 -0400", hash_original_method = "5C668F99FD089E189A03C18C500CC1BE", hash_generated_method = "184BAEB313A1690D7B9F3C377B2C05BA")
    private void mark() {
        theLastColumn = theCurrentColumn;
        theLastLine = theCurrentLine;
        // ---------- Original Method ----------
        //theLastColumn = theCurrentColumn;
        //theLastLine = theCurrentLine;
    }

    
        @DSModeled(DSC.SAFE)
@DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.846 -0400", hash_original_method = "ADD8A6D3E398AE84BB2395E77CB3DD25", hash_generated_method = "1EF97924DE4200F8FC7B47D12F17ED38")
    public void startCDATA() {
        theNextState = S_CDATA;
        // ---------- Original Method ----------
        //theNextState = S_CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.847 -0400", hash_original_method = "84101FD8AB96FAF4340E309879AEA5A7", hash_generated_method = "BDB56D4C31FAEB51F43AB1DF40590216")
    private void save(int ch, ScanHandler h) throws IOException, SAXException {
        addTaint(h.getTaint());
        if(theSize >= theOutputBuffer.length - 20)        
        {
            if(theState == S_PCDATA || theState == S_CDATA)            
            {
                h.pcdata(theOutputBuffer, 0, theSize);
                theSize = 0;
            } //End block
            else
            {
                char[] newOutputBuffer = new char[theOutputBuffer.length * 2];
                System.arraycopy(theOutputBuffer, 0, newOutputBuffer, 0, theSize+1);
                theOutputBuffer = newOutputBuffer;
            } //End block
        } //End block
        theOutputBuffer[theSize++] = (char)ch;
        // ---------- Original Method ----------
        //if (theSize >= theOutputBuffer.length - 20) {
			//if (theState == S_PCDATA || theState == S_CDATA) {
				//h.pcdata(theOutputBuffer, 0, theSize);
				//theSize = 0;
				//}
			//else {
				//char[] newOutputBuffer = new char[theOutputBuffer.length * 2];
                                //System.arraycopy(theOutputBuffer, 0, newOutputBuffer, 0, theSize+1);
				//theOutputBuffer = newOutputBuffer;
				//}
			//}
        //theOutputBuffer[theSize++] = (char)ch;
    }

    
    public static void main(String[] argv) throws IOException, SAXException {
        Scanner s = new HTMLScanner();
        Reader r = new InputStreamReader(System.in, "UTF-8");
        Writer w = new OutputStreamWriter(System.out, "UTF-8");
        PYXWriter pw = new PYXWriter(w);
        s.scan(r, pw);
        w.close();
    }

    
    @DSModeled(DSC.SAFE)
    private static String nicechar(int in) {
        if (in == '\n') return "\\n";
        if (in < 32) return "0x"+Integer.toHexString(in);
        return "'"+((char)in)+"'";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "B69C4C28A2A5795B62B424B40F2A94CC", hash_generated_field = "FBF4CCB0E0C015F7A0D40EF16DBFEE4F")

    private static final int S_ANAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "2BBFBA73812960D4D2B4493D4A77CCAC", hash_generated_field = "7427FF5CF2F4140DD15D538DCE4941F9")

    private static final int S_APOS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "10570404ADAFA63AEC826135822F7F85", hash_generated_field = "E3A0255D1F2889AA367FBDB4FBBFA19B")

    private static final int S_AVAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "4464CF35B4DED325C16F32C443D6DA59", hash_generated_field = "D81BA253EF5CB7720634733F1FA9C426")

    private static final int S_BB = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "89D47318E4C5F6C9C7B2D40168319CAB", hash_generated_field = "658E6171037AF7B58264EEA0EA4E3C07")

    private static final int S_BBC = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "2B4BFC088672D9FE1E8413DE0E6475D2", hash_generated_field = "1CBC31A5B8CD34B7ED0EA9AA51CBAA50")

    private static final int S_BBCD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "56805628E5AE36E0ABDB1D54563571C0", hash_generated_field = "FC57827FD7CB64929EC205F2C8218CAD")

    private static final int S_BBCDA = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "DC9E33E573D704AB24C78318747D6262", hash_generated_field = "56A686C56D1EC3FA6E5EC6963F8AEEEC")

    private static final int S_BBCDAT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "A4E1F33F843B77828E15625807928573", hash_generated_field = "856C0AC527EB9310BDC893358DEFDAE9")

    private static final int S_BBCDATA = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "F9DEA08AC6B86C4E1B431C66E0D8AE8B", hash_generated_field = "5381C86960EECA2A1F31C2F74C8F8E42")

    private static final int S_CDATA = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "2F6A27962D8C3CBC4105D5431C3C299A", hash_generated_field = "6241444BE23EE130D76378E0BD67A4EF")

    private static final int S_CDATA2 = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.848 -0400", hash_original_field = "7F31FF65DC15F63276DA10DC20B54D80", hash_generated_field = "AB987E6AD90B0188EFB8E7A3B6C2499F")

    private static final int S_CDSECT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "6408B9F73262215EEEE29309C3E2B890", hash_generated_field = "6AA4751A3D5CB29B690FE78C72B7CFDC")

    private static final int S_CDSECT1 = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "2C8D5BE088D6191A29FD9146AF2E717D", hash_generated_field = "71D398473DF5A41C8CF4750C1668453B")

    private static final int S_CDSECT2 = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "39DFEFEEEF21FBB3EBB0B2E82E517CB5", hash_generated_field = "ABB31CB0D5E2B0912E20492D6D912ECC")

    private static final int S_COM = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "FF21A572F438C41ED700E9F7473BA75C", hash_generated_field = "C3CB91E60A32613603D31C9CFFA5800D")

    private static final int S_COM2 = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "D248DA15992071EC4360348F86E8C427", hash_generated_field = "F4EA6CF25AFA7BDCD82F2F466A79FFB2")

    private static final int S_COM3 = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "0BD7F748AE2974D3B9470D75A81519CB", hash_generated_field = "85EB2897B78D7E4982DE1EE56EF7DC1C")

    private static final int S_COM4 = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "6B91C7DC3AD566C6F8167771C9FA3FFD", hash_generated_field = "20D5D3AD590B0C95D5E8EDF5F377B75B")

    private static final int S_DECL = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "AD215F1E237F9F09FDFF3862FC21ACD6", hash_generated_field = "0106DCCA5118758BCB2D6D1074C9BA96")

    private static final int S_DECL2 = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "E901DDD0DC7B3C3567F8C13CAB7F0161", hash_generated_field = "730EE6C4156A9FB471549766C70732EE")

    private static final int S_DONE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "F1CD467C574FD0F16B3CDD9AF43E2E9D", hash_generated_field = "062AE6CCC0D6C9EEA85B7FCA9F6C285F")

    private static final int S_EMPTYTAG = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "1B11B889A0F210E05F2A572E51E1139F", hash_generated_field = "25ADD432C0243739691F2A8BA2BBDE65")

    private static final int S_ENT = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "230DE7824B806D1DF2666F31159D9679", hash_generated_field = "44B6AFF7497D41E66DD272AA78186370")

    private static final int S_EQ = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "F25AF337684EB980BAC2A532DD364BD2", hash_generated_field = "DE92DE56C324D7DB69544B1CBF59EF93")

    private static final int S_ETAG = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "2E20E2579B56B0B35228ECE13E4C5D53", hash_generated_field = "7A6CD32C477C7B4ACFD7F0D089BCFF32")

    private static final int S_GI = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "49ED6A1F2D320182090E94DDA3875378", hash_generated_field = "9A939DC8562C7DFBCA9FCC4CE55AD0FC")

    private static final int S_NCR = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "19D26FC69F618AE0947359D851B6AE36", hash_generated_field = "63EA530657B6CB08E6729244F2A7A029")

    private static final int S_PCDATA = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.849 -0400", hash_original_field = "FEF73C0F59A264A8549F5E4260E5348D", hash_generated_field = "25FEF3C4A0E8E055E58FCFB0CF22B90D")

    private static final int S_PI = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "A64B4025F5C42412F980093004DA9AE1", hash_generated_field = "080F9295264C75AE1CFA3F2B6EBA6BC5")

    private static final int S_PITARGET = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "A3C66FC9B73B54760E6663C9BA4D4DEE", hash_generated_field = "18CD1CB472777438443FD159F8A10A15")

    private static final int S_QUOT = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "AD7AA542EE699C10DB45A05214E6D20A", hash_generated_field = "F1754F8A1FEBC2122F5A09D3B549FAD7")

    private static final int S_STAGC = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "86534BF5C68ADCD06919FAE39DB00FDF", hash_generated_field = "BB5FF0FC10B5FC449A0D56D044C30EB4")

    private static final int S_TAG = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "B2792E6B793EDE8A85E098D0BC0F79EE", hash_generated_field = "3D7B4113B9A82A541DF21E497BD00E3A")

    private static final int S_TAGWS = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "2044C1399A0618C2400CB9B626FD07D2", hash_generated_field = "2FC1662A6EB227CAE0ACC13CE07C0035")

    private static final int S_XNCR = 35;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "475E9E06633FDD29CC8E42ED2512A7AD", hash_generated_field = "8C5023571008931FD6C3E012329D8D5F")

    private static final int A_ADUP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "D2905A8EA69B05289E12D4D18AAD0183", hash_generated_field = "03E70ACC95A0D6624061A6F56180C17B")

    private static final int A_ADUP_SAVE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "0591E09BFDDC72D3F373807476AC3D3B", hash_generated_field = "B84619190E8FBDCE64F9CB6C57E94654")

    private static final int A_ADUP_STAGC = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "B07064B2A19E45D525AD2AA27AA9FBBA", hash_generated_field = "A6DA3A552D53EFA5B307D90D50252444")

    private static final int A_ANAME = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "2400C94E036015EE6F76B452BED9D211", hash_generated_field = "1D1E27CBE8CC6448A8D21899A2361585")

    private static final int A_ANAME_ADUP = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "874E578A39867E786EAFC1279E0C775C", hash_generated_field = "9F345F9AE2E0005999C252F423E3F525")

    private static final int A_ANAME_ADUP_STAGC = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "41198C2BC16E839FAA6C289CB861B7FE", hash_generated_field = "82CD7AAD2EE078CAA921AB2EB6326E09")

    private static final int A_AVAL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "629E992F4A4D762846002B1979F0114D", hash_generated_field = "EEFDDC8ACED2CD34778BCC6EC802E850")

    private static final int A_AVAL_STAGC = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "C57C4A3FB50F4D9DD6631E7C0E150047", hash_generated_field = "9CECF6163CE38788BF45727AFB596AF9")

    private static final int A_CDATA = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "3DB7B1B9EE591FD4201F3DF2E1A40181", hash_generated_field = "54D0165ABD723C054926D3136BB733E1")

    private static final int A_CMNT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "93A0187AAD72D2AE8124799CE809A030", hash_generated_field = "22C009E05903A8534711EF342CCB4038")

    private static final int A_DECL = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.850 -0400", hash_original_field = "BE9CC787D1AD462AD41D7B5BFEA7F0F2", hash_generated_field = "BB51D1D35458744DBC815D0458DE69B6")

    private static final int A_EMPTYTAG = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "4CCD70075D7454A8602B43B175DF7A09", hash_generated_field = "37737BF736E122BF7FDCED5DDBFB7161")

    private static final int A_ENTITY = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "E53E76A7371482D21A24212828CA4E98", hash_generated_field = "6B9C51D6EBB62046F08D2B38607C1BE2")

    private static final int A_ENTITY_START = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "CA1B938D7D52D4158EDA46D45C967FC7", hash_generated_field = "9C34690B75DFCF16209554E97CA2BEB1")

    private static final int A_ETAG = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "EF9C128E73200D5A06EAF938BA8FBDF9", hash_generated_field = "5EA41916D95BB4944453B271F6FC1030")

    private static final int A_GI = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "86419319742C6C74218573F422B344F5", hash_generated_field = "12495701D92212BF028152A5DA08BFBF")

    private static final int A_GI_STAGC = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "CEB0F0B7CA22C6204ADBFD9650B31F03", hash_generated_field = "F1CCAE09B6E014C30D84F88807E429AB")

    private static final int A_LT = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "E5E6FF4F3C524294EBC4FBB8F555CC35", hash_generated_field = "6537BA942DB865D3C7C6DB0C487FF794")

    private static final int A_LT_PCDATA = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "D574BEA8E22E16B80ECE879396283999", hash_generated_field = "38554D6769B35C70CF5C7375FEACBF7A")

    private static final int A_MINUS = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "D03E04317EF3762EFBA4F82137A4EB62", hash_generated_field = "15ACE7B1927A8182F3B74716A7C03DC4")

    private static final int A_MINUS2 = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "644D72FB06DC47245CD41CF6FE96A9A6", hash_generated_field = "731E47753233B88C1E3B4AFE9BDB82DE")

    private static final int A_MINUS3 = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "8696AA27C3C9F51B5A8FB4CF825B0B95", hash_generated_field = "461EC7F282E796E6FE44A983EC72F12C")

    private static final int A_PCDATA = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "496C32D1E65BF050FA40AEC8E68B271C", hash_generated_field = "C58113A1D5C5274ECA947F1BE8E15CB2")

    private static final int A_PI = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "5B575A5D8AF1FD65F3D8BDEDCD46CA1A", hash_generated_field = "3071C8CCE67164F186CBDF4B9091F1B1")

    private static final int A_PITARGET = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.851 -0400", hash_original_field = "ED4BF26013CFAF4AEE01339FDE0F8926", hash_generated_field = "7AB8724EC540C89B444DC191810E83D5")

    private static final int A_PITARGET_PI = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.852 -0400", hash_original_field = "E896DF5872204532EB9BBE82CE1CC313", hash_generated_field = "527517156BADF85E45A33E49629ED526")

    private static final int A_SAVE = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.852 -0400", hash_original_field = "049348B505A4E02B25669B76B7E7F3E3", hash_generated_field = "CB0A06A7AE6857936556DD70E2884DB6")

    private static final int A_SKIP = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.852 -0400", hash_original_field = "4B8E9AD17DC848E67DA331592D934460", hash_generated_field = "0B2D976710E3273CCCE75D9466DBA3A8")

    private static final int A_SP = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.852 -0400", hash_original_field = "65D471490A6BC31671B549CB93734B3F", hash_generated_field = "F786E60D4FF5503E86C58EDB3C40EF90")

    private static final int A_STAGC = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.852 -0400", hash_original_field = "07CA4750739C3C1E4441FF848E7CA191", hash_generated_field = "D315D76E37601DEDC5FE51F70EC23581")

    private static final int A_UNGET = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.852 -0400", hash_original_field = "52A925888923F19F30527B9CB24A2EEA", hash_generated_field = "97B05E575B3CDCB636E59F91B624B432")

    private static final int A_UNSAVE_PCDATA = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.853 -0400", hash_original_field = "EF9E2F8FE7EBD5632CC43B7FE6BE6AFF", hash_generated_field = "42AE8F347F354E39EDE4E32AAC75B88F")

    private static int[] statetable = {
		S_ANAME, '/', A_ANAME_ADUP, S_EMPTYTAG,
		S_ANAME, '=', A_ANAME, S_AVAL,
		S_ANAME, '>', A_ANAME_ADUP_STAGC, S_PCDATA,
		S_ANAME, 0, A_SAVE, S_ANAME,
		S_ANAME, -1, A_ANAME_ADUP_STAGC, S_DONE,
		S_ANAME, ' ', A_ANAME, S_EQ,
		S_ANAME, '\n', A_ANAME, S_EQ,
		S_ANAME, '\t', A_ANAME, S_EQ,
		S_APOS, '\'', A_AVAL, S_TAGWS,
		S_APOS, 0, A_SAVE, S_APOS,
		S_APOS, -1, A_AVAL_STAGC, S_DONE,
		S_APOS, ' ', A_SP, S_APOS,
		S_APOS, '\n', A_SP, S_APOS,
		S_APOS, '\t', A_SP, S_APOS,
		S_AVAL, '\'', A_SKIP, S_APOS,
		S_AVAL, '"', A_SKIP, S_QUOT,
		S_AVAL, '>', A_AVAL_STAGC, S_PCDATA,
		S_AVAL, 0, A_SAVE, S_STAGC,
		S_AVAL, -1, A_AVAL_STAGC, S_DONE,
		S_AVAL, ' ', A_SKIP, S_AVAL,
		S_AVAL, '\n', A_SKIP, S_AVAL,
		S_AVAL, '\t', A_SKIP, S_AVAL,
		S_BB, 'C', A_SKIP, S_BBC,
		S_BB, 0, A_SKIP, S_DECL,
		S_BB, -1, A_SKIP, S_DONE,
		S_BBC, 'D', A_SKIP, S_BBCD,
		S_BBC, 0, A_SKIP, S_DECL,
		S_BBC, -1, A_SKIP, S_DONE,
		S_BBCD, 'A', A_SKIP, S_BBCDA,
		S_BBCD, 0, A_SKIP, S_DECL,
		S_BBCD, -1, A_SKIP, S_DONE,
		S_BBCDA, 'T', A_SKIP, S_BBCDAT,
		S_BBCDA, 0, A_SKIP, S_DECL,
		S_BBCDA, -1, A_SKIP, S_DONE,
		S_BBCDAT, 'A', A_SKIP, S_BBCDATA,
		S_BBCDAT, 0, A_SKIP, S_DECL,
		S_BBCDAT, -1, A_SKIP, S_DONE,
		S_BBCDATA, '[', A_SKIP, S_CDSECT,
		S_BBCDATA, 0, A_SKIP, S_DECL,
		S_BBCDATA, -1, A_SKIP, S_DONE,
		S_CDATA, '<', A_SAVE, S_CDATA2,
		S_CDATA, 0, A_SAVE, S_CDATA,
		S_CDATA, -1, A_PCDATA, S_DONE,
		S_CDATA2, '/', A_UNSAVE_PCDATA, S_ETAG,
		S_CDATA2, 0, A_SAVE, S_CDATA,
		S_CDATA2, -1, A_UNSAVE_PCDATA, S_DONE,
		S_CDSECT, ']', A_SAVE, S_CDSECT1,
		S_CDSECT, 0, A_SAVE, S_CDSECT,
		S_CDSECT, -1, A_SKIP, S_DONE,
		S_CDSECT1, ']', A_SAVE, S_CDSECT2,
		S_CDSECT1, 0, A_SAVE, S_CDSECT,
		S_CDSECT1, -1, A_SKIP, S_DONE,
		S_CDSECT2, '>', A_CDATA, S_PCDATA,
		S_CDSECT2, 0, A_SAVE, S_CDSECT,
		S_CDSECT2, -1, A_SKIP, S_DONE,
		S_COM, '-', A_SKIP, S_COM2,
		S_COM, 0, A_SAVE, S_COM2,
		S_COM, -1, A_CMNT, S_DONE,
		S_COM2, '-', A_SKIP, S_COM3,
		S_COM2, 0, A_SAVE, S_COM2,
		S_COM2, -1, A_CMNT, S_DONE,
		S_COM3, '-', A_SKIP, S_COM4,
		S_COM3, 0, A_MINUS, S_COM2,
		S_COM3, -1, A_CMNT, S_DONE,
		S_COM4, '-', A_MINUS3, S_COM4,
		S_COM4, '>', A_CMNT, S_PCDATA,
		S_COM4, 0, A_MINUS2, S_COM2,
		S_COM4, -1, A_CMNT, S_DONE,
		S_DECL, '-', A_SKIP, S_COM,
		S_DECL, '[', A_SKIP, S_BB,
		S_DECL, '>', A_SKIP, S_PCDATA,
		S_DECL, 0, A_SAVE, S_DECL2,
		S_DECL, -1, A_SKIP, S_DONE,
		S_DECL2, '>', A_DECL, S_PCDATA,
		S_DECL2, 0, A_SAVE, S_DECL2,
		S_DECL2, -1, A_SKIP, S_DONE,
		S_EMPTYTAG, '>', A_EMPTYTAG, S_PCDATA,
		S_EMPTYTAG, 0, A_SAVE, S_ANAME,
		S_EMPTYTAG, ' ', A_SKIP, S_TAGWS,
		S_EMPTYTAG, '\n', A_SKIP, S_TAGWS,
		S_EMPTYTAG, '\t', A_SKIP, S_TAGWS,
		S_ENT, 0, A_ENTITY, S_ENT,
		S_ENT, -1, A_ENTITY, S_DONE,
		S_EQ, '=', A_SKIP, S_AVAL,
		S_EQ, '>', A_ADUP_STAGC, S_PCDATA,
		S_EQ, 0, A_ADUP_SAVE, S_ANAME,
		S_EQ, -1, A_ADUP_STAGC, S_DONE,
		S_EQ, ' ', A_SKIP, S_EQ,
		S_EQ, '\n', A_SKIP, S_EQ,
		S_EQ, '\t', A_SKIP, S_EQ,
		S_ETAG, '>', A_ETAG, S_PCDATA,
		S_ETAG, 0, A_SAVE, S_ETAG,
		S_ETAG, -1, A_ETAG, S_DONE,
		S_ETAG, ' ', A_SKIP, S_ETAG,
		S_ETAG, '\n', A_SKIP, S_ETAG,
		S_ETAG, '\t', A_SKIP, S_ETAG,
		S_GI, '/', A_SKIP, S_EMPTYTAG,
		S_GI, '>', A_GI_STAGC, S_PCDATA,
		S_GI, 0, A_SAVE, S_GI,
		S_GI, -1, A_SKIP, S_DONE,
		S_GI, ' ', A_GI, S_TAGWS,
		S_GI, '\n', A_GI, S_TAGWS,
		S_GI, '\t', A_GI, S_TAGWS,
		S_NCR, 0, A_ENTITY, S_NCR,
		S_NCR, -1, A_ENTITY, S_DONE,
		S_PCDATA, '&', A_ENTITY_START, S_ENT,
		S_PCDATA, '<', A_PCDATA, S_TAG,
		S_PCDATA, 0, A_SAVE, S_PCDATA,
		S_PCDATA, -1, A_PCDATA, S_DONE,
		S_PI, '>', A_PI, S_PCDATA,
		S_PI, 0, A_SAVE, S_PI,
		S_PI, -1, A_PI, S_DONE,
		S_PITARGET, '>', A_PITARGET_PI, S_PCDATA,
		S_PITARGET, 0, A_SAVE, S_PITARGET,
		S_PITARGET, -1, A_PITARGET_PI, S_DONE,
		S_PITARGET, ' ', A_PITARGET, S_PI,
		S_PITARGET, '\n', A_PITARGET, S_PI,
		S_PITARGET, '\t', A_PITARGET, S_PI,
		S_QUOT, '"', A_AVAL, S_TAGWS,
		S_QUOT, 0, A_SAVE, S_QUOT,
		S_QUOT, -1, A_AVAL_STAGC, S_DONE,
		S_QUOT, ' ', A_SP, S_QUOT,
		S_QUOT, '\n', A_SP, S_QUOT,
		S_QUOT, '\t', A_SP, S_QUOT,
		S_STAGC, '>', A_AVAL_STAGC, S_PCDATA,
		S_STAGC, 0, A_SAVE, S_STAGC,
		S_STAGC, -1, A_AVAL_STAGC, S_DONE,
		S_STAGC, ' ', A_AVAL, S_TAGWS,
		S_STAGC, '\n', A_AVAL, S_TAGWS,
		S_STAGC, '\t', A_AVAL, S_TAGWS,
		S_TAG, '!', A_SKIP, S_DECL,
		S_TAG, '?', A_SKIP, S_PITARGET,
		S_TAG, '/', A_SKIP, S_ETAG,
		S_TAG, '<', A_SAVE, S_TAG,
		S_TAG, 0, A_SAVE, S_GI,
		S_TAG, -1, A_LT_PCDATA, S_DONE,
		S_TAG, ' ', A_LT, S_PCDATA,
		S_TAG, '\n', A_LT, S_PCDATA,
		S_TAG, '\t', A_LT, S_PCDATA,
		S_TAGWS, '/', A_SKIP, S_EMPTYTAG,
		S_TAGWS, '>', A_STAGC, S_PCDATA,
		S_TAGWS, 0, A_SAVE, S_ANAME,
		S_TAGWS, -1, A_STAGC, S_DONE,
		S_TAGWS, ' ', A_SKIP, S_TAGWS,
		S_TAGWS, '\n', A_SKIP, S_TAGWS,
		S_TAGWS, '\t', A_SKIP, S_TAGWS,
		S_XNCR, 0, A_ENTITY, S_XNCR,
		S_XNCR, -1, A_ENTITY, S_DONE,

	};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.853 -0400", hash_original_field = "AD1F2934D28AA40FA58B840F5D0A9533", hash_generated_field = "A974EA1E26A24169F00F81DBB3C02AD2")

    private static final String[] debug_actionnames = { "", "A_ADUP", "A_ADUP_SAVE", "A_ADUP_STAGC", "A_ANAME", "A_ANAME_ADUP", "A_ANAME_ADUP_STAGC", "A_AVAL", "A_AVAL_STAGC", "A_CDATA", "A_CMNT", "A_DECL", "A_EMPTYTAG", "A_ENTITY", "A_ENTITY_START", "A_ETAG", "A_GI", "A_GI_STAGC", "A_LT", "A_LT_PCDATA", "A_MINUS", "A_MINUS2", "A_MINUS3", "A_PCDATA", "A_PI", "A_PITARGET", "A_PITARGET_PI", "A_SAVE", "A_SKIP", "A_SP", "A_STAGC", "A_UNGET", "A_UNSAVE_PCDATA"};
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:42.853 -0400", hash_original_field = "31953C15CED5AA777A763817C4341DBC", hash_generated_field = "94C8DD3C0B0DF20945959CD74C941DDC")

    private static final String[] debug_statenames = { "", "S_ANAME", "S_APOS", "S_AVAL", "S_BB", "S_BBC", "S_BBCD", "S_BBCDA", "S_BBCDAT", "S_BBCDATA", "S_CDATA", "S_CDATA2", "S_CDSECT", "S_CDSECT1", "S_CDSECT2", "S_COM", "S_COM2", "S_COM3", "S_COM4", "S_DECL", "S_DECL2", "S_DONE", "S_EMPTYTAG", "S_ENT", "S_EQ", "S_ETAG", "S_GI", "S_NCR", "S_PCDATA", "S_PI", "S_PITARGET", "S_QUOT", "S_STAGC", "S_TAG", "S_TAGWS", "S_XNCR"};
}

