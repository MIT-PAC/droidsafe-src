package org.ccil.cowan.tagsoup;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.*;
import org.xml.sax.SAXException;
import org.xml.sax.Locator;

public class HTMLScanner implements Scanner, Locator {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.386 -0400", hash_original_field = "BD3C6DEEF8852BB42141E913BBA840E8", hash_generated_field = "5DE7612FB52B4C7CD7CF6BE3E02E09B6")

    private String thePublicid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.386 -0400", hash_original_field = "1EF74CA2C18D4B1096919D4DCD34B6E0", hash_generated_field = "9A678ABFCD87282CEC96ECE7EA2137F4")

    private String theSystemid;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.386 -0400", hash_original_field = "2E34B41773FC69D7C11F409A5E94C2B9", hash_generated_field = "002B529451A6709EF216BD8F8F7D4F81")

    private int theLastLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.387 -0400", hash_original_field = "D0ED4454AD7B9B58066BE371F3FE580C", hash_generated_field = "F4A44194D173076DCB26B2C8E351310B")

    private int theLastColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.387 -0400", hash_original_field = "25DC9E914F5BE785CE1529E8CEC45D2B", hash_generated_field = "1E986C0C45EC0CBFCB2541DDE893227E")

    private int theCurrentLine;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.387 -0400", hash_original_field = "8BACECFED60B1EE08C52E677CDEBE6CD", hash_generated_field = "A6C1CC9770372CF135647494BE6B1EA7")

    private int theCurrentColumn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.387 -0400", hash_original_field = "7D285F98B2C714536428EBC96A3E3736", hash_generated_field = "2A9B3707FE4B47A183CA387F06CD96C3")

    int theState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.387 -0400", hash_original_field = "B020CFF806AA29820EB9C46EA3FEB21A", hash_generated_field = "B539E59DE16ED9BC0EA86219F312D4FD")

    int theNextState;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.387 -0400", hash_original_field = "CEA2DA4D480E410EF586AD3F4F4B5C2B", hash_generated_field = "BFE6CE6F03989DB396BE3B22A5F736FE")

    char[] theOutputBuffer = new char[200];
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.387 -0400", hash_original_field = "11D4DAC72FACB9A9EF8FB95B42B3C959", hash_generated_field = "22B5A69CFAB142C36A53904D0940E17C")

    int theSize;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.387 -0400", hash_original_field = "26C43D09D55C2310EBC32EA5E6FDF4DC", hash_generated_field = "35E50BD19A7E4E51E2AA0BBD51BAEC94")

    int[] theWinMap = ;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.387 -0400", hash_original_method = "A8030374AECACF3BB4D2A2FA58C4A7D8", hash_generated_method = "A8030374AECACF3BB4D2A2FA58C4A7D8")
    public HTMLScanner ()
    {
        //Synthesized constructor
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.388 -0400", hash_original_method = "7BF7C7D5830ADAF76FEF60D8F3F10567", hash_generated_method = "5DB8B086407B6829FE6D7DCF3ED184BE")
    private void unread(PushbackReader r, int c) throws IOException {
        r.unread(c);
        addTaint(r.getTaint());
        addTaint(c);
        // ---------- Original Method ----------
        //if (c != -1) r.unread(c);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.388 -0400", hash_original_method = "17D8C6B884298309CDBB8C115CEF45AD", hash_generated_method = "9764D5F65DB3576DA2E79843A60316EE")
    public int getLineNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956023773 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_956023773;
        // ---------- Original Method ----------
        //return theLastLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.388 -0400", hash_original_method = "CC76CCC6A19838EC65870F98307D39F4", hash_generated_method = "5EAF607FCFEFFCFD9496487EEC691D7C")
    public int getColumnNumber() {
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286170401 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_286170401;
        // ---------- Original Method ----------
        //return theLastColumn;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.398 -0400", hash_original_method = "EE9557AC8121925813378C18555B01E0", hash_generated_method = "F8CD1C3DC448F683FC068404876BA7E6")
    public String getPublicId() {
        String varB4EAC82CA7396A68D541C85D26508E83_235504544 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_235504544 = thePublicid;
        varB4EAC82CA7396A68D541C85D26508E83_235504544.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_235504544;
        // ---------- Original Method ----------
        //return thePublicid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.398 -0400", hash_original_method = "B52DC32D5FB92F39EE1C6D62A566FA39", hash_generated_method = "02145A61346FD670C979B53E86F95C6E")
    public String getSystemId() {
        String varB4EAC82CA7396A68D541C85D26508E83_1210446241 = null; //Variable for return #1
        varB4EAC82CA7396A68D541C85D26508E83_1210446241 = theSystemid;
        varB4EAC82CA7396A68D541C85D26508E83_1210446241.addTaint(getTaint()); //Add taint from parent
        return varB4EAC82CA7396A68D541C85D26508E83_1210446241;
        // ---------- Original Method ----------
        //return theSystemid;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.398 -0400", hash_original_method = "0F092EE343E640C5A578BAEFAE8AEFB5", hash_generated_method = "75FB287F9A48CFCE5989892AD073900A")
    public void resetDocumentLocator(String publicid, String systemid) {
        thePublicid = publicid;
        theSystemid = systemid;
        theLastLine = theLastColumn = theCurrentLine = theCurrentColumn = 0;
        // ---------- Original Method ----------
        //thePublicid = publicid;
        //theSystemid = systemid;
        //theLastLine = theLastColumn = theCurrentLine = theCurrentColumn = 0;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.418 -0400", hash_original_method = "D85CBFA2F1A37C13B743BA6B1C12F2CC", hash_generated_method = "7D132BC32ED61FEA6075654AD32DAAA2")
    public void scan(Reader r0, ScanHandler h) throws IOException, SAXException {
        theState = S_PCDATA;
        PushbackReader r;
        {
            r = (PushbackReader)r0;
        } //End block
        {
            r = new PushbackReader(r0);
        } //End block
        {
            r = new PushbackReader(new BufferedReader(r0, 200));
        } //End block
        int firstChar;
        firstChar = r.read();
        unread(r, firstChar);
        {
            int ch;
            ch = r.read();
            ch = theWinMap[ch-0x80];
            {
                ch = r.read();
                {
                    unread(r, ch);
                    ch = '\n';
                } //End block
            } //End block
            {
                theCurrentColumn = 0;
            } //End block
            int action;
            action = 0;
            {
                int i;
                i = 0;
                i += 4;
                {
                    {
                        action = statetable[i+2];
                        theNextState = statetable[i+3];
                    } //End block
                    {
                        action = statetable[i+2];
                        theNextState = statetable[i+3];
                    } //End block
                } //End block
            } //End collapsed parenthetic
            //Begin case 0 
            if (DroidSafeAndroidRuntime.control) throw new Error(
"HTMLScanner can't cope with " + Integer.toString(ch) + " in state " +
Integer.toString(theState));
            //End case 0 
            //Begin case A_ADUP 
            h.adup(theOutputBuffer, 0, theSize);
            //End case A_ADUP 
            //Begin case A_ADUP 
            theSize = 0;
            //End case A_ADUP 
            //Begin case A_ADUP_SAVE 
            h.adup(theOutputBuffer, 0, theSize);
            //End case A_ADUP_SAVE 
            //Begin case A_ADUP_SAVE 
            theSize = 0;
            //End case A_ADUP_SAVE 
            //Begin case A_ADUP_SAVE 
            save(ch, h);
            //End case A_ADUP_SAVE 
            //Begin case A_ADUP_STAGC 
            h.adup(theOutputBuffer, 0, theSize);
            //End case A_ADUP_STAGC 
            //Begin case A_ADUP_STAGC 
            theSize = 0;
            //End case A_ADUP_STAGC 
            //Begin case A_ADUP_STAGC 
            h.stagc(theOutputBuffer, 0, theSize);
            //End case A_ADUP_STAGC 
            //Begin case A_ANAME 
            h.aname(theOutputBuffer, 0, theSize);
            //End case A_ANAME 
            //Begin case A_ANAME 
            theSize = 0;
            //End case A_ANAME 
            //Begin case A_ANAME_ADUP 
            h.aname(theOutputBuffer, 0, theSize);
            //End case A_ANAME_ADUP 
            //Begin case A_ANAME_ADUP 
            theSize = 0;
            //End case A_ANAME_ADUP 
            //Begin case A_ANAME_ADUP 
            h.adup(theOutputBuffer, 0, theSize);
            //End case A_ANAME_ADUP 
            //Begin case A_ANAME_ADUP_STAGC 
            h.aname(theOutputBuffer, 0, theSize);
            //End case A_ANAME_ADUP_STAGC 
            //Begin case A_ANAME_ADUP_STAGC 
            theSize = 0;
            //End case A_ANAME_ADUP_STAGC 
            //Begin case A_ANAME_ADUP_STAGC 
            h.adup(theOutputBuffer, 0, theSize);
            //End case A_ANAME_ADUP_STAGC 
            //Begin case A_ANAME_ADUP_STAGC 
            h.stagc(theOutputBuffer, 0, theSize);
            //End case A_ANAME_ADUP_STAGC 
            //Begin case A_AVAL 
            h.aval(theOutputBuffer, 0, theSize);
            //End case A_AVAL 
            //Begin case A_AVAL 
            theSize = 0;
            //End case A_AVAL 
            //Begin case A_AVAL_STAGC 
            h.aval(theOutputBuffer, 0, theSize);
            //End case A_AVAL_STAGC 
            //Begin case A_AVAL_STAGC 
            theSize = 0;
            //End case A_AVAL_STAGC 
            //Begin case A_AVAL_STAGC 
            h.stagc(theOutputBuffer, 0, theSize);
            //End case A_AVAL_STAGC 
            //Begin case A_CDATA 
            mark();
            //End case A_CDATA 
            //Begin case A_CDATA 
            theSize -= 2;
            //End case A_CDATA 
            //Begin case A_CDATA 
            h.pcdata(theOutputBuffer, 0, theSize);
            //End case A_CDATA 
            //Begin case A_CDATA 
            theSize = 0;
            //End case A_CDATA 
            //Begin case A_ENTITY_START 
            h.pcdata(theOutputBuffer, 0, theSize);
            //End case A_ENTITY_START 
            //Begin case A_ENTITY_START 
            theSize = 0;
            //End case A_ENTITY_START 
            //Begin case A_ENTITY_START 
            save(ch, h);
            //End case A_ENTITY_START 
            //Begin case A_ENTITY 
            mark();
            //End case A_ENTITY 
            //Begin case A_ENTITY 
            char ch1;
            ch1 = (char)ch;
            //End case A_ENTITY 
            //Begin case A_ENTITY 
            {
                theNextState = S_NCR;
                save(ch, h);
            } //End block
            {
                theNextState = S_XNCR;
                save(ch, h);
            } //End block
            {
                boolean var399AB106AA77FAAABC7591A7F8A9BC78_1782826247 = (theState == S_ENT && Character.isLetterOrDigit(ch1));
                {
                    save(ch, h);
                } //End block
                {
                    boolean var5DB9D4C814C915FDFA1C54A8F00A4A7F_90073007 = (theState == S_NCR && Character.isDigit(ch1));
                    {
                        save(ch, h);
                    } //End block
                    {
                        boolean var6D97DB103201670807C571750651BB95_55345158 = (theState == S_XNCR && (Character.isDigit(ch1) || "abcdefABCDEF".indexOf(ch1) != -1));
                        {
                            save(ch, h);
                        } //End block
                    } //End collapsed parenthetic
                } //End collapsed parenthetic
            } //End collapsed parenthetic
            //End case A_ENTITY 
            //Begin case A_ENTITY 
            h.entity(theOutputBuffer, 1, theSize - 1);
            //End case A_ENTITY 
            //Begin case A_ENTITY 
            int ent;
            ent = h.getEntity();
            //End case A_ENTITY 
            //Begin case A_ENTITY 
            {
                theSize = 0;
                {
                    ent = theWinMap[ent-0x80];
                } //End block
                {
                    ent = 0x20;
                } //End block
                {
                    ent = 0;
                } //End block
                {
                    save(ent, h);
                } //End block
                {
                    ent -= 0x10000;
                    save((ent>>10) + 0xD800, h);
                    save((ent&0x3FF) + 0xDC00, h);
                } //End block
                {
                    unread(r, ch);
                } //End block
            } //End block
            {
                unread(r, ch);
            } //End block
            //End case A_ENTITY 
            //Begin case A_ENTITY 
            theNextState = S_PCDATA;
            //End case A_ENTITY 
            //Begin case A_ETAG 
            h.etag(theOutputBuffer, 0, theSize);
            //End case A_ETAG 
            //Begin case A_ETAG 
            theSize = 0;
            //End case A_ETAG 
            //Begin case A_DECL 
            h.decl(theOutputBuffer, 0, theSize);
            //End case A_DECL 
            //Begin case A_DECL 
            theSize = 0;
            //End case A_DECL 
            //Begin case A_GI 
            h.gi(theOutputBuffer, 0, theSize);
            //End case A_GI 
            //Begin case A_GI 
            theSize = 0;
            //End case A_GI 
            //Begin case A_GI_STAGC 
            h.gi(theOutputBuffer, 0, theSize);
            //End case A_GI_STAGC 
            //Begin case A_GI_STAGC 
            theSize = 0;
            //End case A_GI_STAGC 
            //Begin case A_GI_STAGC 
            h.stagc(theOutputBuffer, 0, theSize);
            //End case A_GI_STAGC 
            //Begin case A_LT 
            mark();
            //End case A_LT 
            //Begin case A_LT 
            save('<', h);
            //End case A_LT 
            //Begin case A_LT 
            save(ch, h);
            //End case A_LT 
            //Begin case A_LT_PCDATA 
            mark();
            //End case A_LT_PCDATA 
            //Begin case A_LT_PCDATA 
            save('<', h);
            //End case A_LT_PCDATA 
            //Begin case A_LT_PCDATA 
            h.pcdata(theOutputBuffer, 0, theSize);
            //End case A_LT_PCDATA 
            //Begin case A_LT_PCDATA 
            theSize = 0;
            //End case A_LT_PCDATA 
            //Begin case A_PCDATA 
            mark();
            //End case A_PCDATA 
            //Begin case A_PCDATA 
            h.pcdata(theOutputBuffer, 0, theSize);
            //End case A_PCDATA 
            //Begin case A_PCDATA 
            theSize = 0;
            //End case A_PCDATA 
            //Begin case A_CMNT 
            mark();
            //End case A_CMNT 
            //Begin case A_CMNT 
            h.cmnt(theOutputBuffer, 0, theSize);
            //End case A_CMNT 
            //Begin case A_CMNT 
            theSize = 0;
            //End case A_CMNT 
            //Begin case A_MINUS3 
            save('-', h);
            //End case A_MINUS3 
            //Begin case A_MINUS3 
            save(' ', h);
            //End case A_MINUS3 
            //Begin case A_MINUS2 
            save('-', h);
            //End case A_MINUS2 
            //Begin case A_MINUS2 
            save(' ', h);
            //End case A_MINUS2 
            //Begin case A_MINUS 
            save('-', h);
            //End case A_MINUS 
            //Begin case A_MINUS 
            save(ch, h);
            //End case A_MINUS 
            //Begin case A_PI 
            mark();
            //End case A_PI 
            //Begin case A_PI 
            h.pi(theOutputBuffer, 0, theSize);
            //End case A_PI 
            //Begin case A_PI 
            theSize = 0;
            //End case A_PI 
            //Begin case A_PITARGET 
            h.pitarget(theOutputBuffer, 0, theSize);
            //End case A_PITARGET 
            //Begin case A_PITARGET 
            theSize = 0;
            //End case A_PITARGET 
            //Begin case A_PITARGET_PI 
            h.pitarget(theOutputBuffer, 0, theSize);
            //End case A_PITARGET_PI 
            //Begin case A_PITARGET_PI 
            theSize = 0;
            //End case A_PITARGET_PI 
            //Begin case A_PITARGET_PI 
            h.pi(theOutputBuffer, 0, theSize);
            //End case A_PITARGET_PI 
            //Begin case A_SAVE 
            save(ch, h);
            //End case A_SAVE 
            //Begin case A_SP 
            save(' ', h);
            //End case A_SP 
            //Begin case A_STAGC 
            h.stagc(theOutputBuffer, 0, theSize);
            //End case A_STAGC 
            //Begin case A_STAGC 
            theSize = 0;
            //End case A_STAGC 
            //Begin case A_EMPTYTAG 
            mark();
            //End case A_EMPTYTAG 
            //Begin case A_EMPTYTAG 
            h.gi(theOutputBuffer, 0, theSize);
            //End case A_EMPTYTAG 
            //Begin case A_EMPTYTAG 
            theSize = 0;
            //End case A_EMPTYTAG 
            //Begin case A_EMPTYTAG 
            h.stage(theOutputBuffer, 0, theSize);
            //End case A_EMPTYTAG 
            //Begin case A_UNGET 
            unread(r, ch);
            //End case A_UNGET 
            //Begin case A_UNSAVE_PCDATA 
            h.pcdata(theOutputBuffer, 0, theSize);
            //End case A_UNSAVE_PCDATA 
            //Begin case A_UNSAVE_PCDATA 
            theSize = 0;
            //End case A_UNSAVE_PCDATA 
            //Begin case default 
            if (DroidSafeAndroidRuntime.control) throw new Error("Can't process state " + action);
            //End case default 
            theState = theNextState;
        } //End block
        h.eof(theOutputBuffer, 0, 0);
        addTaint(r0.getTaint());
        addTaint(h.getTaint());
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.419 -0400", hash_original_method = "5C668F99FD089E189A03C18C500CC1BE", hash_generated_method = "184BAEB313A1690D7B9F3C377B2C05BA")
    private void mark() {
        theLastColumn = theCurrentColumn;
        theLastLine = theCurrentLine;
        // ---------- Original Method ----------
        //theLastColumn = theCurrentColumn;
        //theLastLine = theCurrentLine;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.423 -0400", hash_original_method = "ADD8A6D3E398AE84BB2395E77CB3DD25", hash_generated_method = "1EF97924DE4200F8FC7B47D12F17ED38")
    public void startCDATA() {
        theNextState = S_CDATA;
        // ---------- Original Method ----------
        //theNextState = S_CDATA;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.428 -0400", hash_original_method = "84101FD8AB96FAF4340E309879AEA5A7", hash_generated_method = "7E6A116FC2D0250631ADE46F53D6DC95")
    private void save(int ch, ScanHandler h) throws IOException, SAXException {
        {
            {
                h.pcdata(theOutputBuffer, 0, theSize);
                theSize = 0;
            } //End block
            {
                char[] newOutputBuffer;
                newOutputBuffer = new char[theOutputBuffer.length * 2];
                System.arraycopy(theOutputBuffer, 0, newOutputBuffer, 0, theSize+1);
                theOutputBuffer = newOutputBuffer;
            } //End block
        } //End block
        theOutputBuffer[theSize++] = (char)ch;
        addTaint(h.getTaint());
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

    
        private static String nicechar(int in) {
        if (in == '\n') return "\\n";
        if (in < 32) return "0x"+Integer.toHexString(in);
        return "'"+((char)in)+"'";
    }

    
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "B69C4C28A2A5795B62B424B40F2A94CC", hash_generated_field = "0FDBA2CF5C36ED63D70A8628F5863CAA")

    private static int S_ANAME = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "2BBFBA73812960D4D2B4493D4A77CCAC", hash_generated_field = "2D20A6BAAA7E99B908E8F275E76B6E39")

    private static int S_APOS = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "10570404ADAFA63AEC826135822F7F85", hash_generated_field = "A3C02349CC2543C7A7DE1B4077717EED")

    private static int S_AVAL = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "4464CF35B4DED325C16F32C443D6DA59", hash_generated_field = "6E98B70772DF6473A57C150864C576DF")

    private static int S_BB = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "89D47318E4C5F6C9C7B2D40168319CAB", hash_generated_field = "73011EFD642E25AF0B3BEB8EFE86FB53")

    private static int S_BBC = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "2B4BFC088672D9FE1E8413DE0E6475D2", hash_generated_field = "78CAE56EBB85F0442F6B39654EA9231D")

    private static int S_BBCD = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "56805628E5AE36E0ABDB1D54563571C0", hash_generated_field = "3DC44CD41D4E4A1C30BAA6266E37C6EC")

    private static int S_BBCDA = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "DC9E33E573D704AB24C78318747D6262", hash_generated_field = "471EB99B216FC8C5FC3F33E136833A0D")

    private static int S_BBCDAT = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "A4E1F33F843B77828E15625807928573", hash_generated_field = "CBF9836358913B58A4B1168B46ECCEBC")

    private static int S_BBCDATA = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "F9DEA08AC6B86C4E1B431C66E0D8AE8B", hash_generated_field = "5946E31D5A2108278687FDBFD0B12E85")

    private static int S_CDATA = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "2F6A27962D8C3CBC4105D5431C3C299A", hash_generated_field = "A48E4805E33FEC68796DBA8AF5805667")

    private static int S_CDATA2 = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "7F31FF65DC15F63276DA10DC20B54D80", hash_generated_field = "FCD0CE44C228595E8E3F504D7437D02A")

    private static int S_CDSECT = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "6408B9F73262215EEEE29309C3E2B890", hash_generated_field = "0F1F20FD73DAED289C2682BF2A74809A")

    private static int S_CDSECT1 = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "2C8D5BE088D6191A29FD9146AF2E717D", hash_generated_field = "BDBE7C8AB04F012B69D44EC6542A2A30")

    private static int S_CDSECT2 = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "39DFEFEEEF21FBB3EBB0B2E82E517CB5", hash_generated_field = "C140793A7516B453EEE83DD03C26FDA6")

    private static int S_COM = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "FF21A572F438C41ED700E9F7473BA75C", hash_generated_field = "8EDD50BFA263F8A2F0DDED65184AA8A3")

    private static int S_COM2 = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "D248DA15992071EC4360348F86E8C427", hash_generated_field = "804CC715D8981BAEBA35F7333C57DB7B")

    private static int S_COM3 = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "0BD7F748AE2974D3B9470D75A81519CB", hash_generated_field = "90614CC2061410A3484AE6F0439B8F63")

    private static int S_COM4 = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.429 -0400", hash_original_field = "6B91C7DC3AD566C6F8167771C9FA3FFD", hash_generated_field = "653CD39D6A319B0588D73D82598FD5DD")

    private static int S_DECL = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "AD215F1E237F9F09FDFF3862FC21ACD6", hash_generated_field = "B0E5567494054304C4090182ECED08ED")

    private static int S_DECL2 = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "E901DDD0DC7B3C3567F8C13CAB7F0161", hash_generated_field = "A006EC62E56B57AAA22F3E8439F798DA")

    private static int S_DONE = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "F1CD467C574FD0F16B3CDD9AF43E2E9D", hash_generated_field = "ABD022C13A23FB8C7FFF821DA4136473")

    private static int S_EMPTYTAG = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "1B11B889A0F210E05F2A572E51E1139F", hash_generated_field = "FB45620D4B24F72D26C368861D3C8C44")

    private static int S_ENT = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "230DE7824B806D1DF2666F31159D9679", hash_generated_field = "A2066C1A997ED785A23E3A8B41D3A376")

    private static int S_EQ = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "F25AF337684EB980BAC2A532DD364BD2", hash_generated_field = "06A9AB21CCCA826C7C8CBDB1BB7F9978")

    private static int S_ETAG = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "2E20E2579B56B0B35228ECE13E4C5D53", hash_generated_field = "978FAD04F3E3C7607E83C0DE236EFA98")

    private static int S_GI = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "49ED6A1F2D320182090E94DDA3875378", hash_generated_field = "CF5565DA130EB65CB6AFBEFA12C91AF8")

    private static int S_NCR = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "19D26FC69F618AE0947359D851B6AE36", hash_generated_field = "0FE3BE6ADFAECDE8528F4EF4AD81D041")

    private static int S_PCDATA = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "FEF73C0F59A264A8549F5E4260E5348D", hash_generated_field = "DD2A4025BAA5CBFE2D0F83476A25BBCE")

    private static int S_PI = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "A64B4025F5C42412F980093004DA9AE1", hash_generated_field = "2DEA238111BA892A46B7CF146F490449")

    private static int S_PITARGET = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "A3C66FC9B73B54760E6663C9BA4D4DEE", hash_generated_field = "3FE4A1619AA6C57B0049DDB52C501626")

    private static int S_QUOT = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "AD7AA542EE699C10DB45A05214E6D20A", hash_generated_field = "AA1D523DFEC8E6BC096D7716A6C74072")

    private static int S_STAGC = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "86534BF5C68ADCD06919FAE39DB00FDF", hash_generated_field = "5F22023E368B19D0DFEA7143725C3F36")

    private static int S_TAG = 33;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "B2792E6B793EDE8A85E098D0BC0F79EE", hash_generated_field = "8602D356B5D0638E440C1868E84EB97D")

    private static int S_TAGWS = 34;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "2044C1399A0618C2400CB9B626FD07D2", hash_generated_field = "F6771F95B514CDC6B859694361EC198D")

    private static int S_XNCR = 35;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "475E9E06633FDD29CC8E42ED2512A7AD", hash_generated_field = "A3B6948A7E0A941A3F27210C55930699")

    private static int A_ADUP = 1;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "D2905A8EA69B05289E12D4D18AAD0183", hash_generated_field = "E6DC784FD17FC6B3E8944A8116AE043A")

    private static int A_ADUP_SAVE = 2;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "0591E09BFDDC72D3F373807476AC3D3B", hash_generated_field = "DF1F5E93BDD528799B80065D1629FC28")

    private static int A_ADUP_STAGC = 3;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "B07064B2A19E45D525AD2AA27AA9FBBA", hash_generated_field = "AC804D1762D9520EB9533D22B21C9C30")

    private static int A_ANAME = 4;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "2400C94E036015EE6F76B452BED9D211", hash_generated_field = "3CEEF7DA7117B82EA6743D36F31040DD")

    private static int A_ANAME_ADUP = 5;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "874E578A39867E786EAFC1279E0C775C", hash_generated_field = "5E6EE947CE7BB465EDB9869FD286BD0E")

    private static int A_ANAME_ADUP_STAGC = 6;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "41198C2BC16E839FAA6C289CB861B7FE", hash_generated_field = "707C22F4307F9224F7419405ECAF932A")

    private static int A_AVAL = 7;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "629E992F4A4D762846002B1979F0114D", hash_generated_field = "72D19C0F09ED2F21163B6461BAA4FD40")

    private static int A_AVAL_STAGC = 8;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "C57C4A3FB50F4D9DD6631E7C0E150047", hash_generated_field = "21CB3D4ED88E32BDBD810DAE2C6BB13A")

    private static int A_CDATA = 9;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "3DB7B1B9EE591FD4201F3DF2E1A40181", hash_generated_field = "5C4F450AAF790F79E2893F61BD19A5AD")

    private static int A_CMNT = 10;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "93A0187AAD72D2AE8124799CE809A030", hash_generated_field = "E7E7D1A3B19681CCE80789870C965CF8")

    private static int A_DECL = 11;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "BE9CC787D1AD462AD41D7B5BFEA7F0F2", hash_generated_field = "1E361CCFC62F0F68DB39CC250DAF6CCF")

    private static int A_EMPTYTAG = 12;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.430 -0400", hash_original_field = "4CCD70075D7454A8602B43B175DF7A09", hash_generated_field = "C3707E4124320A988209958AEC7AB72B")

    private static int A_ENTITY = 13;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "E53E76A7371482D21A24212828CA4E98", hash_generated_field = "574F3C4E36CAE2B36C72E5AAA0ED00A7")

    private static int A_ENTITY_START = 14;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "CA1B938D7D52D4158EDA46D45C967FC7", hash_generated_field = "B25540FD2904B0FAD1AC8B5B59FE539E")

    private static int A_ETAG = 15;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "EF9C128E73200D5A06EAF938BA8FBDF9", hash_generated_field = "41D20100683A4B3D8817A8F6ED66C103")

    private static int A_GI = 16;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "86419319742C6C74218573F422B344F5", hash_generated_field = "321864EAC7C6970EF1BF62F89F7A701F")

    private static int A_GI_STAGC = 17;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "CEB0F0B7CA22C6204ADBFD9650B31F03", hash_generated_field = "A8BF6F2E67BB3277432F180F8374F4C1")

    private static int A_LT = 18;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "E5E6FF4F3C524294EBC4FBB8F555CC35", hash_generated_field = "1C1D56C0E077BBA95D17BA8CA00F22F7")

    private static int A_LT_PCDATA = 19;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "D574BEA8E22E16B80ECE879396283999", hash_generated_field = "90964263DD03FF2B94A33B2803C0EC0F")

    private static int A_MINUS = 20;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "D03E04317EF3762EFBA4F82137A4EB62", hash_generated_field = "CBA6F4D30214D1CB83CB3EC89685AE54")

    private static int A_MINUS2 = 21;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "644D72FB06DC47245CD41CF6FE96A9A6", hash_generated_field = "7F6789A059CB3E6757487244A6E2EEE5")

    private static int A_MINUS3 = 22;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "8696AA27C3C9F51B5A8FB4CF825B0B95", hash_generated_field = "8396477D5765F5B89F16417A6FAED9B8")

    private static int A_PCDATA = 23;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "496C32D1E65BF050FA40AEC8E68B271C", hash_generated_field = "7DDC0EB93393BD52611A650302150EAD")

    private static int A_PI = 24;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "5B575A5D8AF1FD65F3D8BDEDCD46CA1A", hash_generated_field = "11F4A3297E858CB3152553B866652F15")

    private static int A_PITARGET = 25;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "ED4BF26013CFAF4AEE01339FDE0F8926", hash_generated_field = "B8B3F4C4EA192EFB8D717025A2077EFF")

    private static int A_PITARGET_PI = 26;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "E896DF5872204532EB9BBE82CE1CC313", hash_generated_field = "1D445BAC801BDB00380129CC63B51F5F")

    private static int A_SAVE = 27;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "049348B505A4E02B25669B76B7E7F3E3", hash_generated_field = "E2898AEEA2B1D418D28752D230682E43")

    private static int A_SKIP = 28;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "4B8E9AD17DC848E67DA331592D934460", hash_generated_field = "9F858F8813DBC349041C9CEE6C87F3CE")

    private static int A_SP = 29;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "65D471490A6BC31671B549CB93734B3F", hash_generated_field = "305F024558115B98C35BC26E484B5D75")

    private static int A_STAGC = 30;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "07CA4750739C3C1E4441FF848E7CA191", hash_generated_field = "C5D2AF3006C0B824F67D1371EF452F23")

    private static int A_UNGET = 31;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "52A925888923F19F30527B9CB24A2EEA", hash_generated_field = "84FB5A74E85C8DBAA8B55E7D2E4C5605")

    private static int A_UNSAVE_PCDATA = 32;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "EF9E2F8FE7EBD5632CC43B7FE6BE6AFF", hash_generated_field = "23B6F0C3CBC064D2662C21F16788CE51")

    private static int[] statetable = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "AD1F2934D28AA40FA58B840F5D0A9533", hash_generated_field = "796BFC847BB78A4437E83D474D8B85C5")

    private static String[] debug_actionnames = ;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:21.431 -0400", hash_original_field = "31953C15CED5AA777A763817C4341DBC", hash_generated_field = "9FB1537C5398CB003FC79497774D5542")

    private static String[] debug_statenames = ;
}

