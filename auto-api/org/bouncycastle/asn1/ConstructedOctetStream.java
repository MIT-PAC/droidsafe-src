package org.bouncycastle.asn1;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.InputStream;
import java.io.IOException;

class ConstructedOctetStream extends InputStream {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.871 -0400", hash_original_field = "5431B8D4D4E17964894E609DD0DF69C0", hash_generated_field = "76949B28A5103E4F545C65F9E6322200")

    private ASN1StreamParser _parser;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.886 -0400", hash_original_field = "2B67AB308F9AAF105EE0F6883DA05B14", hash_generated_field = "5715766DFE7FD713CE352A25A0465277")

    private boolean _first = true;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.886 -0400", hash_original_field = "389FB33704674EA5FD8F0BD6C9991724", hash_generated_field = "B436CB06F4CDF9C194959E64C13D82E8")

    private InputStream _currentStream;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.887 -0400", hash_original_method = "25BBB36D71D2D30850B0439DCA6D8B9F", hash_generated_method = "7609202E714AC535C8430BB5461BC38F")
      ConstructedOctetStream(
        ASN1StreamParser parser) {
        _parser = parser;
        // ---------- Original Method ----------
        //_parser = parser;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.888 -0400", hash_original_method = "30D34BC5FF70D0CD39A8963110E96C00", hash_generated_method = "30D19850EE93982A5F1C3EA207FE73B9")
    public int read(byte[] b, int off, int len) throws IOException {
        {
            ASN1OctetStringParser s;
            s = (ASN1OctetStringParser)_parser.readObject();
            _first = false;
            _currentStream = s.getOctetStream();
        } //End block
        int totalRead;
        totalRead = 0;
        {
            int numRead;
            numRead = _currentStream.read(b, off + totalRead, len - totalRead);
            {
                totalRead += numRead;
            } //End block
            {
                ASN1OctetStringParser aos;
                aos = (ASN1OctetStringParser)_parser.readObject();
                {
                    _currentStream = null;
                } //End block
                _currentStream = aos.getOctetStream();
            } //End block
        } //End block
        addTaint(b[0]);
        addTaint(off);
        addTaint(len);
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284981839 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_284981839;
        // ---------- Original Method ----------
        // Original Method Too Long, Refer to Original Implementation
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-06-27 14:14:17.888 -0400", hash_original_method = "07E101CE9B272EF565A5C01515093572", hash_generated_method = "6BA248CC4326119C51A58B7C70C0957D")
    public int read() throws IOException {
        {
            ASN1OctetStringParser s;
            s = (ASN1OctetStringParser)_parser.readObject();
            _first = false;
            _currentStream = s.getOctetStream();
        } //End block
        {
            int b;
            b = _currentStream.read();
            ASN1OctetStringParser s;
            s = (ASN1OctetStringParser)_parser.readObject();
            {
                _currentStream = null;
            } //End block
            _currentStream = s.getOctetStream();
        } //End block
        int varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624197883 = getTaintInt();
        return varFA7153F7ED1CB6C0FCF2FFB2FAC21748_1624197883;
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

