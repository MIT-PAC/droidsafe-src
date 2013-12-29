package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class URISyntaxException extends Exception {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.029 -0500", hash_original_field = "36BD0379ACF830B6786D2B8E93773859", hash_generated_field = "CB65BAFBA372A5B522C6FE0957B2DAA9")


    private static final long serialVersionUID = 2137979680897488891L;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.029 -0500", hash_original_field = "5C462996083F0F42B19C9D5F27993F9B", hash_generated_field = "6283A1859476002FA59A8C77FB48608E")


    private String input;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.030 -0500", hash_original_field = "8BD524D6245D998B3BBC44EB9313082E", hash_generated_field = "56A277C77B76B31C1E1045C8C11CA802")


    private int index;

    /**
     * Constructs a new {@code URISyntaxException} instance containing the
     * string that caused the exception, a description of the problem and the
     * index at which the error occurred.
     *
     * @param input
     *            the string that caused the exception.
     * @param reason
     *            the reason why the exception occurred.
     * @param index
     *            the position where the exception occurred.
     * @throws NullPointerException
     *             if one of the arguments {@code input} or {@code reason} is
     *             {@code null}.
     * @throws IllegalArgumentException
     *             if the value for {@code index} is lesser than {@code -1}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.031 -0500", hash_original_method = "97528CB9DDAE82ED090B6E0F20E64C52", hash_generated_method = "58A8FD99F611D4F09285AB2F3320C4B7")
    public URISyntaxException(String input, String reason, int index) {
        super(reason);

        if (input == null || reason == null) {
            throw new NullPointerException();
        }

        if (index < -1) {
            throw new IllegalArgumentException();
        }

        this.input = input;
        this.index = index;
    }

    /**
     * Constructs a new {@code URISyntaxException} instance containing the
     * string that caused the exception and a description of the problem.
     *
     *@param input
     *            the string that caused the exception.
     * @param reason
     *            the reason why the exception occurred.
     * @throws NullPointerException
     *             if one of the arguments {@code input} or {@code reason} is
     *             {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.032 -0500", hash_original_method = "9E8506F7D035742973E1D45F72C781FB", hash_generated_method = "03C2E4364E4AA808702EA4BB00E6F68C")
    public URISyntaxException(String input, String reason) {
        super(reason);

        if (input == null || reason == null) {
            throw new NullPointerException();
        }

        this.input = input;
        index = -1;
    }

    /**
     * Gets the index at which the syntax error was found or {@code -1} if the
     * index is unknown/unavailable.
     *
     * @return the index of the syntax error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.033 -0500", hash_original_method = "398BD1DDC3618561F914960ED7D21764", hash_generated_method = "96CCC69099797392A28F97F5383D17E0")
    public int getIndex() {
        return index;
    }

    /**
     * Gets a description of the syntax error.
     *
     * @return the string describing the syntax error.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.034 -0500", hash_original_method = "D4B65418D906ACD682013E7ACC1989F7", hash_generated_method = "69CA2D86010C04E3D461DAA6BA0538D6")
    public String getReason() {
        return super.getMessage();
    }

    /**
     * Gets the initial string that contains an invalid syntax.
     *
     * @return the string that caused the exception.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.035 -0500", hash_original_method = "DF4880B690A0BCFCB8F3C337A75DD5A0", hash_generated_method = "A86ADFB04EAC98F41A92AD9716876241")
    public String getInput() {
        return input;
    }

    /**
     * Gets a description of the exception, including the reason, the string
     * that caused the syntax error and the position of the syntax error if
     * available.
     *
     * @return a sting containing information about the exception.
     * @see java.lang.Throwable#getMessage()
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.036 -0500", hash_original_method = "2C0C7C544BFDCEB0F806A466417CE15E", hash_generated_method = "00B5136E5193B48EC240369BC34C9A9D")
    @Override
public String getMessage() {
        String reason = super.getMessage();
        if (index != -1) {
            return reason + " at index " + index + ": " + input;
        }
        return reason + ": " + input;
    }
}

