package org.apache.http.message;

// Droidsafe Imports
import droidsafe.annotations.*;
import droidsafe.helpers.*;

import droidsafe.runtime.*;
import java.util.NoSuchElementException;
import org.apache.http.HeaderIterator;
import org.apache.http.ParseException;
import org.apache.http.TokenIterator;

public class BasicTokenIterator implements TokenIterator {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.178 -0500", hash_original_field = "3FA5FAB4934413AB18E238AD3664C3DF", hash_generated_field = "1D584E5C603C33010618C39D38DE59A8")

    // the order of the characters here is adjusted to put the
    // most likely candidates at the beginning of the collection
    public final static String HTTP_SEPARATORS = " ,;=()<>@:\\\"/[]?{}\t";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.180 -0500", hash_original_field = "8A85502E058E78CBD7CD2C77295C667A", hash_generated_field = "EC9D0C260936A48CE3D00DF1B58760FD")

    protected  HeaderIterator headerIt;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.184 -0500", hash_original_field = "37289A7DD43FBC4977CBAC8A7AAC4E3C", hash_generated_field = "7B4E018C3F013525C08A27A13DF71B71")

    protected String currentHeader;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.187 -0500", hash_original_field = "13CA1C8C25931787343EDD7CED641380", hash_generated_field = "74D8A76D642811495F7C9EB2CC2B1DBE")

    protected String currentToken;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.191 -0500", hash_original_field = "519DA85885D597293B5A9F826104F04F", hash_generated_field = "41CA8C81CB60760B0D4A540CC5B31524")

    protected int searchPos;

    /**
     * Creates a new instance of {@link BasicTokenIterator}.
     *
     * @param headerIterator    the iterator for the headers to tokenize
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.194 -0500", hash_original_method = "728241B000D06E5A4B3FF4A1E835CDCC", hash_generated_method = "599B695EDAC2F0302E5E43CCF17EC365")
    
public BasicTokenIterator(final HeaderIterator headerIterator) {
        if (headerIterator == null) {
            throw new IllegalArgumentException
                ("Header iterator must not be null.");
        }

        this.headerIt = headerIterator;
        this.searchPos = findNext(-1);
    }
    
	@DSSafe(DSCat.SAFE_LIST)
    @Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}
    
    @Override
	public String nextToken() {
        return this.headerIt.nextHeader().getValue();
	}
    
	@DSSafe(DSCat.SAFE_LIST)
    @Override
	public Object next() {
            return  this.headerIt.nextHeader().getValue();
	
	}
    
    @DSSafe(DSCat.DATA_STRUCTURE)
    @Override
	public void remove() {
		// TODO Auto-generated method stub
	}

    /**
     * Determines the next token.
     * If found, the token is stored in {@link #currentToken}.
     * The return value indicates the position after the token
     * in {@link #currentHeader}. If necessary, the next header
     * will be obtained from {@link #headerIt}.
     * If not found, {@link #currentToken} is set to <code>null</code>.
     *
     * @param from      the position in the current header at which to
     *                  start the search, -1 to search in the first header
     *
     * @return  the position after the found token in the current header, or
     *          negative if there was no next token
     *
     * @throws ParseException   if an invalid header value is encountered
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.206 -0500", hash_original_method = "32F5FD491C11EBCEB75A9EB408CEB9C9", hash_generated_method = "80E96F22A52ADB2E497B5F68F07D141A")
    
protected int findNext(int from)
        throws ParseException {

        if (from < 0) {
            // called from the constructor, initialize the first header
            if (!this.headerIt.hasNext()) {
                return -1;
            }
            this.currentHeader = this.headerIt.nextHeader().getValue();
            from = 0;
        } else {
            // called after a token, make sure there is a separator
            from = findTokenSeparator(from);
        }

        int start = findTokenStart(from);
        if (start < 0) {
            this.currentToken = null;
            return -1; // nothing found
        }

        int end = findTokenEnd(start);
        this.currentToken = createToken(this.currentHeader, start, end);
        return end;
    }

    /**
     * Creates a new token to be returned.
     * Called from {@link #findNext findNext} after the token is identified.
     * The default implementation simply calls
     * {@link java.lang.String#substring String.substring}.
     * <br/>
     * If header values are significantly longer than tokens, and some
     * tokens are permanently referenced by the application, there can
     * be problems with garbage collection. A substring will hold a
     * reference to the full characters of the original string and
     * therefore occupies more memory than might be expected.
     * To avoid this, override this method and create a new string
     * instead of a substring.
     *
     * @param value     the full header value from which to create a token
     * @param start     the index of the first token character
     * @param end       the index after the last token character
     *
     * @return  a string representing the token identified by the arguments
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.208 -0500", hash_original_method = "8A7AB715022476147F81646A7190B2B6", hash_generated_method = "671A4B39BC9236FA2264CF679986569B")
    
protected String createToken(String value, int start, int end) {
        return value.substring(start, end);
    }

    /**
     * Determines the starting position of the next token.
     * This method will iterate over headers if necessary.
     *
     * @param from      the position in the current header at which to
     *                  start the search
     *
     * @return  the position of the token start in the current header,
     *          negative if no token start could be found
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.211 -0500", hash_original_method = "C3C9B07DEC7C1A6A9535E620A84F019D", hash_generated_method = "9430F8637E78E5012E729DA0023F57BD")
    
protected int findTokenStart(int from) {
        if (from < 0) {
            throw new IllegalArgumentException
                ("Search position must not be negative: " + from);
        }

        boolean found = false;
        while (!found && (this.currentHeader != null)) {

            final int to = this.currentHeader.length();
            while (!found && (from < to)) {

                final char ch = this.currentHeader.charAt(from);
                if (isTokenSeparator(ch) || isWhitespace(ch)) {
                    // whitspace and token separators are skipped
                    from++;
                } else if (isTokenChar(this.currentHeader.charAt(from))) {
                    // found the start of a token
                    found = true;
                } else {
                    throw new ParseException
                        ("Invalid character before token (pos " + from +
                         "): " + this.currentHeader);
                }
            }
            if (!found) {
                if (this.headerIt.hasNext()) {
                    this.currentHeader = this.headerIt.nextHeader().getValue();
                    from = 0;
                } else {
                    this.currentHeader = null;
                }
            }
        } // while headers

        return found ? from : -1;
    }

    /**
     * Determines the position of the next token separator.
     * Because of multi-header joining rules, the end of a
     * header value is a token separator. This method does
     * therefore not need to iterate over headers.
     *
     * @param from      the position in the current header at which to
     *                  start the search
     *
     * @return  the position of a token separator in the current header,
     *          or at the end
     *
     * @throws ParseException
     *         if a new token is found before a token separator.
     *         RFC 2616, section 2.1 explicitly requires a comma between
     *         tokens for <tt>#</tt>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.214 -0500", hash_original_method = "85E1DE95D8123E292DCFF62F7D93B47F", hash_generated_method = "8A7C619EAF677F2600E4007D5EC728C9")
    
protected int findTokenSeparator(int from) {
        if (from < 0) {
            throw new IllegalArgumentException
                ("Search position must not be negative: " + from);
        }

        boolean found = false;
        final int to = this.currentHeader.length();
        while (!found && (from < to)) {
            final char ch = this.currentHeader.charAt(from);
            if (isTokenSeparator(ch)) {
                found = true;
            } else if (isWhitespace(ch)) {
                from++;
            } else if (isTokenChar(ch)) {
                throw new ParseException
                    ("Tokens without separator (pos " + from +
                     "): " + this.currentHeader);
            } else {
                throw new ParseException
                    ("Invalid character after token (pos " + from +
                     "): " + this.currentHeader);
            }
        }

        return from;
    }

    /**
     * Determines the ending position of the current token.
     * This method will not leave the current header value,
     * since the end of the header value is a token boundary.
     *
     * @param from      the position of the first character of the token
     *
     * @return  the position after the last character of the token.
     *          The behavior is undefined if <code>from</code> does not
     *          point to a token character in the current header value.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.218 -0500", hash_original_method = "ED818B78DD519794D8AD6912C0355074", hash_generated_method = "21CC2FD2A81A4C5E1A7FDD3CA9402F5F")
    
protected int findTokenEnd(int from) {
        if (from < 0) {
            throw new IllegalArgumentException
                ("Token start position must not be negative: " + from);
        }

        final int to = this.currentHeader.length();
        int end = from+1;
        while ((end < to) && isTokenChar(this.currentHeader.charAt(end))) {
            end++;
        }

        return end;
    }

    /**
     * Checks whether a character is a token separator.
     * RFC 2616, section 2.1 defines comma as the separator for
     * <tt>#token</tt> sequences. The end of a header value will
     * also separate tokens, but that is not a character check.
     *
     * @param ch        the character to check
     *
     * @return  <code>true</code> if the character is a token separator,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.222 -0500", hash_original_method = "82ADC719B633E23931D943624F51E118", hash_generated_method = "4CD109DB55737959103AA18D0543B705")
    
protected boolean isTokenSeparator(char ch) {
        return (ch == ',');
    }

    /**
     * Checks whether a character is a whitespace character.
     * RFC 2616, section 2.2 defines space and horizontal tab as whitespace.
     * The optional preceeding line break is irrelevant, since header
     * continuation is handled transparently when parsing messages.
     *
     * @param ch        the character to check
     *
     * @return  <code>true</code> if the character is whitespace,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.224 -0500", hash_original_method = "C3B308F031251D57A69A78A18E46CB9C", hash_generated_method = "4B7C59921BE18EE0CEC54F37CC4E92CC")
    
protected boolean isWhitespace(char ch) {

        // we do not use Character.isWhitspace(ch) here, since that allows
        // many control characters which are not whitespace as per RFC 2616
        return ((ch == '\t') || Character.isSpaceChar(ch));
    }

    /**
     * Checks whether a character is a valid token character.
     * Whitespace, control characters, and HTTP separators are not
     * valid token characters. The HTTP specification (RFC 2616, section 2.2)
     * defines tokens only for the US-ASCII character set, this
     * method extends the definition to other character sets.
     *
     * @param ch        the character to check
     *
     * @return  <code>true</code> if the character is a valid token start,
     *          <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.226 -0500", hash_original_method = "776CFF97F037037124FC98CDEBC144D9", hash_generated_method = "7F44A91851C61867CCC26530BF48F302")
    
protected boolean isTokenChar(char ch) {

        // common sense extension of ALPHA + DIGIT
        if (Character.isLetterOrDigit(ch))
            return true;

        // common sense extension of CTL
        if (Character.isISOControl(ch))
            return false;

        // no common sense extension for this
        if (isHttpSeparator(ch))
            return false;

        // RFC 2616, section 2.2 defines a token character as
        // "any CHAR except CTLs or separators". The controls
        // and separators are included in the checks above.
        // This will yield unexpected results for Unicode format characters.
        // If that is a problem, overwrite isHttpSeparator(char) to filter
        // out the false positives.
        return true;
    }

    /**
     * Checks whether a character is an HTTP separator.
     * The implementation in this class checks only for the HTTP separators
     * defined in RFC 2616, section 2.2. If you need to detect other
     * separators beyond the US-ASCII character set, override this method.
     *
     * @param ch        the character to check
     *
     * @return  <code>true</code> if the character is an HTTP separator
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:49.228 -0500", hash_original_method = "8ABD66F1955A5164E5EB5D68E76EE993", hash_generated_method = "74DEFB6A6A350EBAE0C8DB21B4AF57E7")
    
protected boolean isHttpSeparator(char ch) {
        return (HTTP_SEPARATORS.indexOf(ch) >= 0);
    }
}

