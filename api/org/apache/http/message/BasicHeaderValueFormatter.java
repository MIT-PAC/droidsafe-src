package org.apache.http.message;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import org.apache.http.HeaderElement;
import org.apache.http.NameValuePair;
import org.apache.http.util.CharArrayBuffer;






public class BasicHeaderValueFormatter implements HeaderValueFormatter {



    // public default constructor



    /**
     * Formats an array of header elements.
     *
     * @param elems     the header elements to format
     * @param quote     <code>true</code> to always format with quoted values,
     *                  <code>false</code> to use quotes only when necessary
     * @param formatter         the formatter to use, or <code>null</code>
     *                          for the {@link #DEFAULT default}
     *
     * @return  the formatted header elements
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.373 -0500", hash_original_method = "B2284C46A701781D8BDD9EA191683CED", hash_generated_method = "26C3FB4762D89BDBBCCEAF2814863CBB")
    public final static String formatElements(final HeaderElement[] elems,
                              final boolean quote,
                              HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatElements(null, elems, quote).toString();
    }



    /**
     * Formats a header element.
     *
     * @param elem      the header element to format
     * @param quote     <code>true</code> to always format with quoted values,
     *                  <code>false</code> to use quotes only when necessary
     * @param formatter         the formatter to use, or <code>null</code>
     *                          for the {@link #DEFAULT default}
     *
     * @return  the formatted header element
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.376 -0500", hash_original_method = "F1DF96C7A348307D7810D3F93EAE9BCB", hash_generated_method = "13F97006567F796652FBF53C29F317AD")
    public final static String formatHeaderElement(final HeaderElement elem,
                                   boolean quote,
                                   HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatHeaderElement(null, elem, quote).toString();
    }




    /**
     * Formats a set of parameters.
     *
     * @param nvps      the parameters to format
     * @param quote     <code>true</code> to always format with quoted values,
     *                  <code>false</code> to use quotes only when necessary
     * @param formatter         the formatter to use, or <code>null</code>
     *                          for the {@link #DEFAULT default}
     *
     * @return  the formatted parameters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.378 -0500", hash_original_method = "EAFE8FC789D709377CF509D3CD765292", hash_generated_method = "51188B37EB4E00338394120ECAFD5F4B")
    public final static String formatParameters(final NameValuePair[] nvps,
                                final boolean quote,
                                HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatParameters(null, nvps, quote).toString();
    }


    /**
     * Formats a name-value pair.
     *
     * @param nvp       the name-value pair to format
     * @param quote     <code>true</code> to always format with a quoted value,
     *                  <code>false</code> to use quotes only when necessary
     * @param formatter         the formatter to use, or <code>null</code>
     *                          for the {@link #DEFAULT default}
     *
     * @return  the formatted name-value pair
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.381 -0500", hash_original_method = "FA5FE1EBC875FBC58DA87E4CCEA9F5F1", hash_generated_method = "2D9AE5E85CA49B771D90002278AACFC7")
    public final static String formatNameValuePair(final NameValuePair nvp,
                                   final boolean quote,
                                   HeaderValueFormatter formatter) {
        if (formatter == null)
            formatter = BasicHeaderValueFormatter.DEFAULT;
        return formatter.formatNameValuePair(null, nvp, quote).toString();
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.371 -0500", hash_original_field = "0C209E4BF3D7F3F6C5E32E4DD3CBD6B5", hash_generated_field = "87CD1F964F54FF38D274F82D32A3B239")

    public final static
        BasicHeaderValueFormatter DEFAULT = new BasicHeaderValueFormatter();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.371 -0500", hash_original_field = "F746F9B2B935A7254D583CE27BD9F322", hash_generated_field = "A7ED65FEAF3FE8A2CDE4A15F0B581CC9")

    public final static String SEPARATORS = " ;,:@()<>\\\"/[]?={}\t";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.372 -0500", hash_original_field = "0566C64715D3C20677AEC92BBBD7B98E", hash_generated_field = "9EFC8BAC7FF2406E13D9C9CA1C607AA5")

    public final static String UNSAFE_CHARS = "\"\\";
    
    @DSModeled(DSC.SAFE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:36.788 -0400", hash_original_method = "88ED703AD5842214D5052F930ED18AF6", hash_generated_method = "88ED703AD5842214D5052F930ED18AF6")
    public BasicHeaderValueFormatter ()
    {
        //Synthesized constructor
    }


    // non-javadoc, see interface HeaderValueFormatter
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.374 -0500", hash_original_method = "3B962169F247D53704261A5A24F1A431", hash_generated_method = "FF56C14BEA3A406FF1D1725DBCEC42B1")
    public CharArrayBuffer formatElements(CharArrayBuffer buffer,
                                          final HeaderElement[] elems,
                                          final boolean quote) {
        if (elems == null) {
            throw new IllegalArgumentException
                ("Header element array must not be null.");
        }

        int len = estimateElementsLen(elems);
        if (buffer == null) {
            buffer = new CharArrayBuffer(len);
        } else {
            buffer.ensureCapacity(len);
        }

        for (int i=0; i<elems.length; i++) {
            if (i > 0) {
                buffer.append(", ");
            }
            formatHeaderElement(buffer, elems[i], quote);
        }

        return buffer;
    }


    /**
     * Estimates the length of formatted header elements.
     *
     * @param elems     the header elements to format, or <code>null</code>
     *
     * @return  a length estimate, in number of characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.375 -0500", hash_original_method = "62CDCB67E7EC0B179AEAB50C07EF0602", hash_generated_method = "CA66DF63F87B017456736C73611F0CBD")
    protected int estimateElementsLen(final HeaderElement[] elems) {
        if ((elems == null) || (elems.length < 1))
            return 0;

        int result = (elems.length-1) * 2; // elements separated by ", "
        for (int i=0; i<elems.length; i++) {
            result += estimateHeaderElementLen(elems[i]);
        }

        return result;
    }


    // non-javadoc, see interface HeaderValueFormatter
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.377 -0500", hash_original_method = "355882C41BE16D37B0209DA6D54CCB3E", hash_generated_method = "BDE2B8858C74FCCBA82D0DDF0DB2B876")
    public CharArrayBuffer formatHeaderElement(CharArrayBuffer buffer,
                                               final HeaderElement elem,
                                               final boolean quote) {
        if (elem == null) {
            throw new IllegalArgumentException
                ("Header element must not be null.");
        }

        int len = estimateHeaderElementLen(elem);
        if (buffer == null) {
            buffer = new CharArrayBuffer(len);
        } else {
            buffer.ensureCapacity(len);
        }

        buffer.append(elem.getName());
        final String value = elem.getValue();
        if (value != null) {
            buffer.append('=');
            doFormatValue(buffer, value, quote);
        }

        final int parcnt = elem.getParameterCount();
        if (parcnt > 0) {
            for (int i=0; i<parcnt; i++) {
                buffer.append("; ");
                formatNameValuePair(buffer, elem.getParameter(i), quote);
            }
        }

        return buffer;
    }


    /**
     * Estimates the length of a formatted header element.
     *
     * @param elem      the header element to format, or <code>null</code>
     *
     * @return  a length estimate, in number of characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.377 -0500", hash_original_method = "8E6899628E610E70351C174244187E71", hash_generated_method = "2C8CCAE7A2B508498E08DCE1D812D971")
    protected int estimateHeaderElementLen(final HeaderElement elem) {
        if (elem == null)
            return 0;

        int result = elem.getName().length(); // name
        final String value = elem.getValue();
        if (value != null) {
            // assume quotes, but no escaped characters
            result += 3 + value.length(); // ="value"
        }

        final int parcnt = elem.getParameterCount();
        if (parcnt > 0) {
            for (int i=0; i<parcnt; i++) {
                result += 2 +                   // ; <param>
                    estimateNameValuePairLen(elem.getParameter(i));
            }
        }

        return result;
    }


    // non-javadoc, see interface HeaderValueFormatter
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.379 -0500", hash_original_method = "7ECB2224BD638F620F916826D26E8E08", hash_generated_method = "D383404BFA9AEFD6B48DE7A3F1885CC4")
    public CharArrayBuffer formatParameters(CharArrayBuffer buffer,
                                            NameValuePair[] nvps,
                                            boolean quote) {
        if (nvps == null) {
            throw new IllegalArgumentException
                ("Parameters must not be null.");
        }

        int len = estimateParametersLen(nvps);
        if (buffer == null) {
            buffer = new CharArrayBuffer(len);
        } else {
            buffer.ensureCapacity(len);
        }

        for (int i = 0; i < nvps.length; i++) {
            if (i > 0) {
                buffer.append("; ");
            }
            formatNameValuePair(buffer, nvps[i], quote);
        }

        return buffer;
    }


    /**
     * Estimates the length of formatted parameters.
     *
     * @param nvps      the parameters to format, or <code>null</code>
     *
     * @return  a length estimate, in number of characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.380 -0500", hash_original_method = "C68A0319865C468C0B8527915CD85227", hash_generated_method = "E3173E7117B23FE62E9483F9170C1A4F")
    protected int estimateParametersLen(final NameValuePair[] nvps) {
        if ((nvps == null) || (nvps.length < 1))
            return 0;

        int result = (nvps.length-1) * 2; // "; " between the parameters
        for (int i=0; i<nvps.length; i++) {
            result += estimateNameValuePairLen(nvps[i]);
        }

        return result;
    }


    // non-javadoc, see interface HeaderValueFormatter
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.382 -0500", hash_original_method = "0780CB3EF81283DFA07B40BE9042FB6E", hash_generated_method = "1CDF4A0DB2B219C3E4DD34DBDF1AD6EE")
    public CharArrayBuffer formatNameValuePair(CharArrayBuffer buffer,
                                               final NameValuePair nvp,
                                               final boolean quote) {
        if (nvp == null) {
            throw new IllegalArgumentException
                ("NameValuePair must not be null.");
        }

        int len = estimateNameValuePairLen(nvp);
        if (buffer == null) {
            buffer = new CharArrayBuffer(len);
        } else {
            buffer.ensureCapacity(len);
        }

        buffer.append(nvp.getName());
        final String value = nvp.getValue();
        if (value != null) {
            buffer.append('=');
            doFormatValue(buffer, value, quote);
        }

        return buffer;
    }


    /**
     * Estimates the length of a formatted name-value pair.
     *
     * @param nvp       the name-value pair to format, or <code>null</code>
     *
     * @return  a length estimate, in number of characters
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.383 -0500", hash_original_method = "91AA35E40301ABCAA7663733F9252D07", hash_generated_method = "DFFAF750CDD2C27120F71D364A8B853C")
    protected int estimateNameValuePairLen(final NameValuePair nvp) {
        if (nvp == null)
            return 0;

        int result = nvp.getName().length(); // name
        final String value = nvp.getValue();
        if (value != null) {
            // assume quotes, but no escaped characters
            result += 3 + value.length(); // ="value"
        }
        return result;
    }


    /**
     * Actually formats the value of a name-value pair.
     * This does not include a leading = character.
     * Called from {@link #formatNameValuePair formatNameValuePair}.
     *
     * @param buffer    the buffer to append to, never <code>null</code>
     * @param value     the value to append, never <code>null</code>
     * @param quote     <code>true</code> to always format with quotes,
     *                  <code>false</code> to use quotes only when necessary
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.383 -0500", hash_original_method = "11FAB29668F5F530D34F327A08D6984E", hash_generated_method = "32246FFC03272025E9A05773E2BE5522")
    protected void doFormatValue(final CharArrayBuffer buffer,
                                 final String value,
                                 boolean quote) {

        if (!quote) {
            for (int i = 0; (i < value.length()) && !quote; i++) {
                quote = isSeparator(value.charAt(i));
            }
        }

        if (quote) {
            buffer.append('"');
        }
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (isUnsafe(ch)) {
                buffer.append('\\');
            }
            buffer.append(ch);
        }
        if (quote) {
            buffer.append('"');
        }
    }


    /**
     * Checks whether a character is a {@link #SEPARATORS separator}.
     *
     * @param ch        the character to check
     *
     * @return  <code>true</code> if the character is a separator,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.385 -0500", hash_original_method = "541354ACFD70CC9FA3913AE1E29B9D2A", hash_generated_method = "11BDFB0BE72C4BEDA8034610D2A984CF")
    protected boolean isSeparator(char ch) {
        return SEPARATORS.indexOf(ch) >= 0;
    }


    /**
     * Checks whether a character is {@link #UNSAFE_CHARS unsafe}.
     *
     * @param ch        the character to check
     *
     * @return  <code>true</code> if the character is unsafe,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:24.386 -0500", hash_original_method = "8B650CEFA0EAACAAB9B471FC321305C5", hash_generated_method = "69B051D4387C9C0AAAFECCDC593533BB")
    protected boolean isUnsafe(char ch) {
        return UNSAFE_CHARS.indexOf(ch) >= 0;
    }
}

