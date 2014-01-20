package org.apache.harmony.xml.parsers;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.SAXParser;

import org.apache.harmony.xml.ExpatReader;
import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderAdapter;

final class SAXParserImpl extends SAXParser {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.926 -0500", hash_original_field = "6AF9CA75BF6E407C2238C9D0D923A66C", hash_generated_field = "5A288FC03A9EC3CBF67B84D7411659BA")

    private Map<String, Boolean> initialFeatures;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.928 -0500", hash_original_field = "8E6314392E70940A1B07E44449D11769", hash_generated_field = "2331E55663EE08977E2E12264071B561")

    private XMLReader reader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.931 -0500", hash_original_field = "B21B1E552EA5A0FE54418F38DDB90070", hash_generated_field = "D434606E37B1227241E7860D969B4643")

    private Parser parser;

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.933 -0500", hash_original_method = "9779EC9D1D1B404AB344DB3CA0720707", hash_generated_method = "9779EC9D1D1B404AB344DB3CA0720707")
    
SAXParserImpl(Map<String, Boolean> initialFeatures)
            throws SAXNotRecognizedException, SAXNotSupportedException {
        this.initialFeatures = initialFeatures.isEmpty()
                ? Collections.<String, Boolean>emptyMap()
                : new HashMap<String, Boolean>(initialFeatures);
        resetInternal();
    }

    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.936 -0500", hash_original_method = "92E2D289AE561178AC5F307252F0C6F0", hash_generated_method = "06CA538B3A50705C32B2A5DA5AF24422")
    
private void resetInternal()
            throws SAXNotSupportedException, SAXNotRecognizedException {
        reader = new ExpatReader();
        for (Map.Entry<String,Boolean> entry : initialFeatures.entrySet()) {
            reader.setFeature(entry.getKey(), entry.getValue());
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.938 -0500", hash_original_method = "26E1B1518091EE44E3A8C3E01B27E1B4", hash_generated_method = "2898938DE6B14D74ACC1D1D3C2B99EED")
    
@Override public void reset() {
        /*
         * The exceptions are impossible. If any features are unrecognized or
         * unsupported, construction of this instance would have failed.
         */
        try {
            resetInternal();
        } catch (SAXNotRecognizedException e) {
            throw new AssertionError();
        } catch (SAXNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.940 -0500", hash_original_method = "18862164328B5438252F399ABE567B5E", hash_generated_method = "7884A55313909A6C1563B41E6E0F55FF")
    
@Override
    public Parser getParser() {
        if (parser == null) {
            parser = new XMLReaderAdapter(reader);
        }

        return parser;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.942 -0500", hash_original_method = "9F43AD8AE86873C6002272EA37B61BFA", hash_generated_method = "32E74ED6EADDA5569D9DF42E5624C797")
    
@Override
    public Object getProperty(String name) throws SAXNotRecognizedException,
            SAXNotSupportedException {
        return reader.getProperty(name);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.945 -0500", hash_original_method = "2EF684CE098290C07222DD88BA41AEFB", hash_generated_method = "51BB6E535D74ABE10E8E21FFF8AD9491")
    
@Override
    public XMLReader getXMLReader() {
        return reader;
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:30.814 -0400", hash_original_method = "4C988836598C02053146886655E4EB88", hash_generated_method = "5614AF223E7F379B9355021058B06156")
    @Override
    public boolean isNamespaceAware() {
        try 
        {
            boolean varAAF6B023277518C6238E2264EF86C519_2089365130 = (reader.getFeature("http://xml.org/sax/features/namespaces"));
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1352929187 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1352929187;
        } //End block
        catch (SAXException ex)
        {
            boolean var68934A3E9455FA72420237EB05902327_1973632088 = (false);
                        boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1763879763 = getTaintBoolean();
            return var84E2C64F38F78BA3EA5C905AB5A2DA27_1763879763;
        } //End block
        // ---------- Original Method ----------
        //try {
            //return reader.getFeature("http://xml.org/sax/features/namespaces");
        //} catch (SAXException ex) {
            //return false;
        //}
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.950 -0500", hash_original_method = "BC62268279A4D4DB4B44A495D4290EBF", hash_generated_method = "521D4F41CD5F8C10A9AEB994B00B3678")
    
@Override
    public boolean isValidating() {
        return false;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:23.952 -0500", hash_original_method = "3CB351E70AA30B9105B52B17172319A2", hash_generated_method = "A394D0BBF949A4D62A30B6A06A9D0485")
    
@Override
    public void setProperty(String name, Object value)
            throws SAXNotRecognizedException, SAXNotSupportedException {
        reader.setProperty(name, value);
    }
    
}

