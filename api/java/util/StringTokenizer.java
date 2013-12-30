package java.util;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class StringTokenizer implements Enumeration<Object> {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.834 -0500", hash_original_field = "38EA5C212184AA9651934368805B840B", hash_generated_field = "D1325E87F7D151CD81D0B4A318C3AE5C")


    private String string;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.837 -0500", hash_original_field = "F79F5753CE2341DD7B606D07AE46B031", hash_generated_field = "08557D348CBDF8CC7B00F6CD8CA91B61")


    private String delimiters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.840 -0500", hash_original_field = "B5FC224E1DE2A1E7C035EE0675169694", hash_generated_field = "641E06957176D04FBFF2F11AEC2A6EC3")


    private boolean returnDelimiters;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.842 -0500", hash_original_field = "92D7808EB8CD548A137230400384C6DC", hash_generated_field = "312206EA2404526B7BBC621459C87A80")


    private int position;

    /**
     * Constructs a new {@code StringTokenizer} for the parameter string using
     * whitespace as the delimiter. The {@code returnDelimiters} flag is set to
     * {@code false}.
     *
     * @param string
     *            the string to be tokenized.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.844 -0500", hash_original_method = "B454FB9D24CB40B920B0F26A1DEB0F99", hash_generated_method = "B9D0AB32248C17CD91D8043386355085")
    
public StringTokenizer(String string) {
        this(string, " \t\n\r\f", false);
    }

    /**
     * Constructs a new {@code StringTokenizer} for the parameter string using
     * the specified delimiters. The {@code returnDelimiters} flag is set to
     * {@code false}. If {@code delimiters} is {@code null}, this constructor
     * doesn't throw an {@code Exception}, but later calls to some methods might
     * throw a {@code NullPointerException}.
     *
     * @param string
     *            the string to be tokenized.
     * @param delimiters
     *            the delimiters to use.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.847 -0500", hash_original_method = "19F75AB88247B84D1EA58EB13E75D4B3", hash_generated_method = "04C80AC85BD9505571E3AE925FFB6AC8")
    
public StringTokenizer(String string, String delimiters) {
        this(string, delimiters, false);
    }

    /**
     * Constructs a new {@code StringTokenizer} for the parameter string using
     * the specified delimiters, returning the delimiters as tokens if the
     * parameter {@code returnDelimiters} is {@code true}. If {@code delimiters}
     * is null this constructor doesn't throw an {@code Exception}, but later
     * calls to some methods might throw a {@code NullPointerException}.
     *
     * @param string
     *            the string to be tokenized.
     * @param delimiters
     *            the delimiters to use.
     * @param returnDelimiters
     *            {@code true} to return each delimiter as a token.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.850 -0500", hash_original_method = "8522BA3F0D65BC6302678F3FDA0BEB48", hash_generated_method = "4961743F82F120E40236D723FA546A45")
    
public StringTokenizer(String string, String delimiters,
            boolean returnDelimiters) {
        if (string != null) {
            this.string = string;
            this.delimiters = delimiters;
            this.returnDelimiters = returnDelimiters;
            this.position = 0;
        } else
            throw new NullPointerException();
    }

    /**
     * Returns the number of unprocessed tokens remaining in the string.
     *
     * @return number of tokens that can be retreived before an {@code
     *         Exception} will result from a call to {@code nextToken()}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.853 -0500", hash_original_method = "F396A87D2BE9368C37D12C0E764C04A1", hash_generated_method = "4A47E56558FC986E42C18A2593CCA129")
    
public int countTokens() {
        int count = 0;
        boolean inToken = false;
        for (int i = position, length = string.length(); i < length; i++) {
            if (delimiters.indexOf(string.charAt(i), 0) >= 0) {
                if (returnDelimiters)
                    count++;
                if (inToken) {
                    count++;
                    inToken = false;
                }
            } else {
                inToken = true;
            }
        }
        if (inToken)
            count++;
        return count;
    }

    /**
     * Returns {@code true} if unprocessed tokens remain. This method is
     * implemented in order to satisfy the {@code Enumeration} interface.
     *
     * @return {@code true} if unprocessed tokens remain.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.856 -0500", hash_original_method = "8165B2FDF405707BFEA9EF223873FBB9", hash_generated_method = "D5A6D5FD357EFF4FEB63192C5E0E5823")
    
public boolean hasMoreElements() {
        return hasMoreTokens();
    }

    /**
     * Returns {@code true} if unprocessed tokens remain.
     *
     * @return {@code true} if unprocessed tokens remain.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.858 -0500", hash_original_method = "15C5B981D98A46AC76B0A556FC01F2CE", hash_generated_method = "74F9C40B020314D4A7B8D5D14B376800")
    
public boolean hasMoreTokens() {
        if (delimiters == null) {
            throw new NullPointerException();
        }
        int length = string.length();
        if (position < length) {
            if (returnDelimiters)
                return true; // there is at least one character and even if
            // it is a delimiter it is a token

            // otherwise find a character which is not a delimiter
            for (int i = position; i < length; i++)
                if (delimiters.indexOf(string.charAt(i), 0) == -1)
                    return true;
        }
        return false;
    }

    /**
     * Returns the next token in the string as an {@code Object}. This method is
     * implemented in order to satisfy the {@code Enumeration} interface.
     *
     * @return next token in the string as an {@code Object}
     * @throws NoSuchElementException
     *                if no tokens remain.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.860 -0500", hash_original_method = "0727048C65431FDBB400A5F8931A38E2", hash_generated_method = "2634E1621F3C8D111804CB487E4DAB7A")
    
public Object nextElement() {
        return nextToken();
    }

    /**
     * Returns the next token in the string as a {@code String}.
     *
     * @return next token in the string as a {@code String}.
     * @throws NoSuchElementException
     *                if no tokens remain.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.864 -0500", hash_original_method = "195590523F66664753FCC18930183C87", hash_generated_method = "A91970AF79C2D14A1D51498CECDB806B")
    
public String nextToken() {
        if (delimiters == null) {
            throw new NullPointerException();
        }
        int i = position;
        int length = string.length();

        if (i < length) {
            if (returnDelimiters) {
                if (delimiters.indexOf(string.charAt(position), 0) >= 0)
                    return String.valueOf(string.charAt(position++));
                for (position++; position < length; position++)
                    if (delimiters.indexOf(string.charAt(position), 0) >= 0)
                        return string.substring(i, position);
                return string.substring(i);
            }

            while (i < length && delimiters.indexOf(string.charAt(i), 0) >= 0)
                i++;
            position = i;
            if (i < length) {
                for (position++; position < length; position++)
                    if (delimiters.indexOf(string.charAt(position), 0) >= 0)
                        return string.substring(i, position);
                return string.substring(i);
            }
        }
        throw new NoSuchElementException();
    }

    /**
     * Returns the next token in the string as a {@code String}. The delimiters
     * used are changed to the specified delimiters.
     *
     * @param delims
     *            the new delimiters to use.
     * @return next token in the string as a {@code String}.
     * @throws NoSuchElementException
     *                if no tokens remain.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:58:00.866 -0500", hash_original_method = "A244E208DF1B5D62AF8E286FEDEE9DEC", hash_generated_method = "0265576B03E3A6C9E042B5AA5E7F63EA")
    
public String nextToken(String delims) {
        this.delimiters = delims;
        return nextToken();
    }

    
}

