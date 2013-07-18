package org.bouncycastle.asn1;

// Droidsafe Imports
import java.io.IOException;
import java.io.InputStream;

import droidsafe.annotations.DSGeneratedField;
import droidsafe.annotations.DSGenerator;

class ConstructedOctetStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.044 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.044 -0400", hash_original_field = "2B67AB308F9AAF105EE0F6883DA05B14", hash_generated_field = "5715766DFE7FD713CE352A25A0465277")

    private boolean _first = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.044 -0400", hash_original_field = "389FB33704674EA5FD8F0BD6C9991724", hash_generated_field = "B436CB06F4CDF9C194959E64C13D82E8")

    private InputStream _currentStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.045 -0400", hash_original_method = "25BBB36D71D2D30850B0439DCA6D8B9F", hash_generated_method = "7609202E714AC535C8430BB5461BC38F")
      ConstructedOctetStream(
        ASN1StreamParser parser) {
        _parser = parser;
        // ---------- Original Method ----------
        //_parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.046 -0400", hash_original_method = "30D34BC5FF70D0CD39A8963110E96C00", hash_generated_method = "DD97326E256DD106749DB12FA66B5C6A")
    public int read(byte[] b, int off, int len) throws IOException {
        addTaint(len);
        addTaint(off);
        addTaint(b[0]);
        if(_currentStream == null)        
        {
            if(!_first)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_691232033 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523350878 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1523350878;
            } //End block
            ASN1OctetStringParser s = (ASN1OctetStringParser)_parser.readObject();
            if(s == null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1074371580 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110741041 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2110741041;
            } //End block
            _first = false;
            _currentStream = s.getOctetStream();
        } //End block
        int totalRead = 0;
for(;;)
        {
            int numRead = _currentStream.read(b, off + totalRead, len - totalRead);
            if(numRead >= 0)            
            {
                totalRead += numRead;
                if(totalRead == len)                
                {
                    int varC97168D982F3E80961E0DAF3924044A2_1446502726 = (totalRead);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260439521 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1260439521;
                } //End block
            } //End block
            else
            {
                ASN1OctetStringParser aos = (ASN1OctetStringParser)_parser.readObject();
                if(aos == null)                
                {
                    _currentStream = null;
                    int var492C6F602F33DC064055C460F704F726_942576554 = (totalRead < 1 ? -1 : totalRead);
                                        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456425788 = getTaintInt();
                    return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1456425788;
                } //End block
                _currentStream = aos.getOctetStream();
            } //End block
        } //End block
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:38.048 -0400", hash_original_method = "07E101CE9B272EF565A5C01515093572", hash_generated_method = "789B1A923FAFEEDE69F5F9561FD992A6")
    public int read() throws IOException {
        if(_currentStream == null)        
        {
            if(!_first)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1629579255 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502733457 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_502733457;
            } //End block
            ASN1OctetStringParser s = (ASN1OctetStringParser)_parser.readObject();
            if(s == null)            
            {
                int var6BB61E3B7BCE0931DA574D19D1D82C88_426793446 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194678867 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_194678867;
            } //End block
            _first = false;
            _currentStream = s.getOctetStream();
        } //End block
for(;;)
        {
            int b = _currentStream.read();
            if(b >= 0)            
            {
                int var92EB5FFEE6AE2FEC3AD71C777531578F_942473675 = (b);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113292626 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_2113292626;
            } //End block
            ASN1OctetStringParser s = (ASN1OctetStringParser)_parser.readObject();
            if(s == null)            
            {
                _currentStream = null;
                int var6BB61E3B7BCE0931DA574D19D1D82C88_1738869126 = (-1);
                                int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459147455 = getTaintInt();
                return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1459147455;
            } //End block
            _currentStream = s.getOctetStream();
        } //End block
        // ---------- Original Method ----------
        //if (_currentStream == null)
        //{
            //if (!_first)
            //{
                //return -1;
            //}
            //ASN1OctetStringParser s = (ASN1OctetStringParser)_parser.readObject();
            //if (s == null)
            //{
                //return -1;
            //}
            //_first = false;
            //_currentStream = s.getOctetStream();
        //}
        //for (;;)
        //{
            //int b = _currentStream.read();
            //if (b >= 0)
            //{
                //return b;
            //}
            //ASN1OctetStringParser s = (ASN1OctetStringParser)_parser.readObject();
            //if (s == null)
            //{
                //_currentStream = null;
                //return -1;
            //}
            //_currentStream = s.getOctetStream();
        //}
    }

    
}

