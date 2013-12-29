package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;






public abstract class CharsetDecoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.466 -0500", hash_original_field = "B0FB523B648357C2D209F8AF6CA69E55", hash_generated_field = "9EA234AF8E19378FF28F64776BC1B1AC")

    private static final int INIT = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.467 -0500", hash_original_field = "DB372BD195DD04D38594D658CD0941C7", hash_generated_field = "BE844086D377CEB871B6E1DD59844EB0")

    private static final int ONGOING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.468 -0500", hash_original_field = "330B5909E190BF7186B4F7E611F5BC23", hash_generated_field = "B476F4C7146F42E47055EAC44A214B2C")

    private static final int END = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.469 -0500", hash_original_field = "15B05665B9D3473592ABD28718757C60", hash_generated_field = "D345F0B97A5F86F7808649FE9032B485")

    private static final int FLUSH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.469 -0500", hash_original_field = "A5A0742DE1C607C5AFC2D6D8C6DE846C", hash_generated_field = "529EF1EB47EC503C08AD8590AE0F62F5")


    private  float averageCharsPerByte;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.470 -0500", hash_original_field = "335B73EC7EF8375CB4CA97A0379D4E5D", hash_generated_field = "2DF37DC2E87CE8D294B5CF2F013FD634")

    private  float maxCharsPerByte;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.471 -0500", hash_original_field = "071AD032827EC07DCD0193396C176EE2", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")


    private  Charset cs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.472 -0500", hash_original_field = "321407B0D07B357A2C1E6B0BC805BF74", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")


    private CodingErrorAction malformedInputAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.473 -0500", hash_original_field = "27CE0B153219039850616F66BE87462B", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.474 -0500", hash_original_field = "C61D54B61607D94E0EEB3AC6825C82E9", hash_generated_field = "4FB9354D4FC1B3B8FECFC231454ED4BC")


    private String replacementChars;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.474 -0500", hash_original_field = "72D62D1933050B7AC2D9DFC43782C64E", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")


    private int status;

    /**
     * Constructs a new <code>CharsetDecoder</code> using the given
     * <code>Charset</code>, average number and maximum number of characters
     * created by this decoder for one input byte, and the default replacement
     * string "\uFFFD".
     *
     * @param charset
     *            the <code>Charset</code> to be used by this decoder.
     * @param averageCharsPerByte
     *            the average number of characters created by this decoder for
     *            one input byte, must be positive.
     * @param maxCharsPerByte
     *            the maximum number of characters created by this decoder for
     *            one input byte, must be positive.
     * @throws IllegalArgumentException
     *             if <code>averageCharsPerByte</code> or
     *             <code>maxCharsPerByte</code> is negative.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.475 -0500", hash_original_method = "8CF9EF6BF1CF308B9A895B171C1AF9B5", hash_generated_method = "4FF9BD66A6DC43288D75AA41F9B7BB87")
    protected CharsetDecoder(Charset charset, float averageCharsPerByte, float maxCharsPerByte) {
        if (averageCharsPerByte <= 0 || maxCharsPerByte <= 0) {
            throw new IllegalArgumentException("averageCharsPerByte and maxCharsPerByte must be positive");
        }
        if (averageCharsPerByte > maxCharsPerByte) {
            throw new IllegalArgumentException("averageCharsPerByte is greater than maxCharsPerByte");
        }
        this.averageCharsPerByte = averageCharsPerByte;
        this.maxCharsPerByte = maxCharsPerByte;
        cs = charset;
        status = INIT;
        malformedInputAction = CodingErrorAction.REPORT;
        unmappableCharacterAction = CodingErrorAction.REPORT;
        replacementChars = "\ufffd";
    }

    /**
     * Returns the average number of characters created by this decoder for a
     * single input byte.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.476 -0500", hash_original_method = "835453458CD254EFEDF140BA3E3A0055", hash_generated_method = "FEB808B4E51BFBC31EDC37607902D59D")
    public final float averageCharsPerByte() {
        return averageCharsPerByte;
    }

    /**
     * Returns the {@link Charset} which this decoder uses.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.477 -0500", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "1B3A1A60F8135EF363B08F511D4AE81E")
    public final Charset charset() {
        return cs;
    }

    /**
     * This is a facade method for the decoding operation.
     * <p>
     * This method decodes the remaining byte sequence of the given byte buffer
     * into a new character buffer. This method performs a complete decoding
     * operation, resets at first, then decodes, and flushes at last.
     * <p>
     * This method should not be invoked while another {@code decode} operation
     * is ongoing.
     *
     * @param in
     *            the input buffer.
     * @return a new <code>CharBuffer</code> containing the the characters
     *         produced by this decoding operation. The buffer's limit will be
     *         the position of the last character in the buffer, and the
     *         position will be zero.
     * @throws IllegalStateException
     *             if another decoding operation is ongoing.
     * @throws MalformedInputException
     *             if an illegal input byte sequence for this charset was
     *             encountered, and the action for malformed error is
     *             {@link CodingErrorAction#REPORT CodingErrorAction.REPORT}
     * @throws UnmappableCharacterException
     *             if a legal but unmappable input byte sequence for this
     *             charset was encountered, and the action for unmappable
     *             character error is
     *             {@link CodingErrorAction#REPORT CodingErrorAction.REPORT}.
     *             Unmappable means the byte sequence at the input buffer's
     *             current position cannot be mapped to a Unicode character
     *             sequence.
     * @throws CharacterCodingException
     *             if another exception happened during the decode operation.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.478 -0500", hash_original_method = "0575B5D8A4FDBA875B2771D84C02D5E1", hash_generated_method = "4E1F50AFF1315AC3C24BFB4D1EF50700")
    public final CharBuffer decode(ByteBuffer in) throws CharacterCodingException {
        reset();
        int length = (int) (in.remaining() * averageCharsPerByte);
        CharBuffer output = CharBuffer.allocate(length);
        CoderResult result = null;
        while (true) {
            result = decode(in, output, false);
            checkCoderResult(result);
            if (result.isUnderflow()) {
                break;
            } else if (result.isOverflow()) {
                output = allocateMore(output);
            }
        }
        result = decode(in, output, true);
        checkCoderResult(result);

        while (true) {
            result = flush(output);
            checkCoderResult(result);
            if (result.isOverflow()) {
                output = allocateMore(output);
            } else {
                break;
            }
        }

        output.flip();
        status = FLUSH;
        return output;
    }

    /*
     * checks the result whether it needs to throw CharacterCodingException.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.479 -0500", hash_original_method = "297219195E5B4473685A201861AC1DC3", hash_generated_method = "93EDC8FB71FB36A64E5E63F079D470B4")
    private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        if (result.isMalformed() && malformedInputAction == CodingErrorAction.REPORT) {
            throw new MalformedInputException(result.length());
        } else if (result.isUnmappable() && unmappableCharacterAction == CodingErrorAction.REPORT) {
            throw new UnmappableCharacterException(result.length());
        }
    }

    /*
     * original output is full and doesn't have remaining. allocate more space
     * to new CharBuffer and return it, the contents in the given buffer will be
     * copied into the new buffer.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.481 -0500", hash_original_method = "D4DFBF2849FE3731857D4FDEE2ED4787", hash_generated_method = "A3953E5E70D27F89B9943BCEBCDC7E83")
    private CharBuffer allocateMore(CharBuffer output) {
        if (output.capacity() == 0) {
            return CharBuffer.allocate(1);
        }
        CharBuffer result = CharBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
        return result;
    }

    /**
     * Decodes bytes starting at the current position of the given input buffer,
     * and writes the equivalent character sequence into the given output buffer
     * from its current position.
     * <p>
     * The buffers' position will be changed with the reading and writing
     * operation, but their limits and marks will be kept intact.
     * <p>
     * A <code>CoderResult</code> instance will be returned according to
     * following rules:
     * <ul>
     * <li>{@link CoderResult#OVERFLOW CoderResult.OVERFLOW} indicates that
     * even though not all of the input has been processed, the buffer the
     * output is being written to has reached its capacity. In the event of this
     * code being returned this method should be called once more with an
     * <code>out</code> argument that has not already been filled.</li>
     * <li>{@link CoderResult#UNDERFLOW CoderResult.UNDERFLOW} indicates that
     * as many bytes as possible in the input buffer have been decoded. If there
     * is no further input and no remaining bytes in the input buffer then this
     * operation may be regarded as complete. Otherwise, this method should be
     * called once more with additional input.</li>
     * <li>A {@link CoderResult#malformedForLength(int) malformed input} result
     * indicates that some malformed input error has been encountered, and the
     * erroneous bytes start at the input buffer's position and their number can
     * be got by result's {@link CoderResult#length() length}. This kind of
     * result can be returned only if the malformed action is
     * {@link CodingErrorAction#REPORT CodingErrorAction.REPORT}. </li>
     * <li>A {@link CoderResult#unmappableForLength(int) unmappable character}
     * result indicates that some unmappable character error has been
     * encountered, and the erroneous bytes start at the input buffer's position
     * and their number can be got by result's
     * {@link CoderResult#length() length}. This kind of result can be returned
     * only if the unmappable character action is
     * {@link CodingErrorAction#REPORT CodingErrorAction.REPORT}. </li>
     * </ul>
     * <p>
     * The <code>endOfInput</code> parameter indicates that the invoker cannot
     * provide further input. This parameter is true if and only if the bytes in
     * current input buffer are all inputs for this decoding operation. Note
     * that it is common and won't cause an error if the invoker sets false and
     * then can't provide more input, while it may cause an error if the invoker
     * always sets true in several consecutive invocations. This would make the
     * remaining input to be treated as malformed input.
     * <p>
     * This method invokes the
     * {@link #decodeLoop(ByteBuffer, CharBuffer) decodeLoop} method to
     * implement the basic decode logic for a specific charset.
     *
     * @param in
     *            the input buffer.
     * @param out
     *            the output buffer.
     * @param endOfInput
     *            true if all the input characters have been provided.
     * @return a <code>CoderResult</code> instance which indicates the reason
     *         of termination.
     * @throws IllegalStateException
     *             if decoding has started or no more input is needed in this
     *             decoding progress.
     * @throws CoderMalfunctionError
     *             if the {@link #decodeLoop(ByteBuffer, CharBuffer) decodeLoop}
     *             method threw an <code>BufferUnderflowException</code> or
     *             <code>BufferOverflowException</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.482 -0500", hash_original_method = "40037F62CA1EB410AEAF236C6BDF7EBA", hash_generated_method = "8696A9EA77812DC900E306EDA0974CF9")
    public final CoderResult decode(ByteBuffer in, CharBuffer out,
            boolean endOfInput) {
        /*
         * status check
         */
        if ((status == FLUSH) || (!endOfInput && status == END)) {
            throw new IllegalStateException();
        }

        CoderResult result = null;

        // begin to decode
        while (true) {
            CodingErrorAction action = null;
            try {
                result = decodeLoop(in, out);
            } catch (BufferOverflowException ex) {
                // unexpected exception
                throw new CoderMalfunctionError(ex);
            } catch (BufferUnderflowException ex) {
                // unexpected exception
                throw new CoderMalfunctionError(ex);
            }

            /*
             * result handling
             */
            if (result.isUnderflow()) {
                int remaining = in.remaining();
                status = endOfInput ? END : ONGOING;
                if (endOfInput && remaining > 0) {
                    result = CoderResult.malformedForLength(remaining);
                } else {
                    return result;
                }
            }
            if (result.isOverflow()) {
                return result;
            }
            // set coding error handle action
            action = malformedInputAction;
            if (result.isUnmappable()) {
                action = unmappableCharacterAction;
            }
            // If the action is IGNORE or REPLACE, we should continue decoding.
            if (action == CodingErrorAction.REPLACE) {
                if (out.remaining() < replacementChars.length()) {
                    return CoderResult.OVERFLOW;
                }
                out.put(replacementChars);
            } else {
                if (action != CodingErrorAction.IGNORE)
                    return result;
            }
            in.position(in.position() + result.length());
        }
    }

    /**
     * Decodes bytes into characters. This method is called by the
     * {@link #decode(ByteBuffer, CharBuffer, boolean) decode} method.
     * <p>
     * This method will implement the essential decoding operation, and it won't
     * stop decoding until either all the input bytes are read, the output
     * buffer is filled, or some exception is encountered. Then it will return a
     * <code>CoderResult</code> object indicating the result of current
     * decoding operation. The rules to construct the <code>CoderResult</code>
     * are the same as for
     * {@link #decode(ByteBuffer, CharBuffer, boolean) decode}. When an
     * exception is encountered in the decoding operation, most implementations
     * of this method will return a relevant result object to the
     * {@link #decode(ByteBuffer, CharBuffer, boolean) decode} method, and some
     * performance optimized implementation may handle the exception and
     * implement the error action itself.
     * <p>
     * The buffers are scanned from their current positions, and their positions
     * will be modified accordingly, while their marks and limits will be
     * intact. At most {@link ByteBuffer#remaining() in.remaining()} characters
     * will be read, and {@link CharBuffer#remaining() out.remaining()} bytes
     * will be written.
     * <p>
     * Note that some implementations may pre-scan the input buffer and return a
     * <code>CoderResult.UNDERFLOW</code> until it receives sufficient input.
     *
     * @param in
     *            the input buffer.
     * @param out
     *            the output buffer.
     * @return a <code>CoderResult</code> instance indicating the result.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.483 -0500", hash_original_method = "9680F981801283FFB7CE500C1C691EF0", hash_generated_method = "45E10C8598041348E587BA19E1D99A75")
    protected abstract CoderResult decodeLoop(ByteBuffer in, CharBuffer out);

    /**
     * Gets the charset detected by this decoder; this method is optional.
     * <p>
     * If implementing an auto-detecting charset, then this decoder returns the
     * detected charset from this method when it is available. The returned
     * charset will be the same for the rest of the decode operation.
     * <p>
     * If insufficient bytes have been read to determine the charset, an
     * <code>IllegalStateException</code> will be thrown.
     * <p>
     * The default implementation always throws
     * <code>UnsupportedOperationException</code>, so it should be overridden
     * by a subclass if needed.
     *
     * @return the charset detected by this decoder, or null if it is not yet
     *         determined.
     * @throws UnsupportedOperationException
     *             if this decoder does not implement an auto-detecting charset.
     * @throws IllegalStateException
     *             if insufficient bytes have been read to determine the
     *             charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.483 -0500", hash_original_method = "FA8F0AC80549BCE47D29C328C4E0F049", hash_generated_method = "E29F4E85BA1EF1A3A600E3063251DEF9")
    public Charset detectedCharset() {
        throw new UnsupportedOperationException();
    }

    /**
     * Flushes this decoder.
     *
     * This method will call {@link #implFlush(CharBuffer) implFlush}. Some
     * decoders may need to write some characters to the output buffer when they
     * have read all input bytes; subclasses can override
     * {@link #implFlush(CharBuffer) implFlush} to perform the writing operation.
     * <p>
     * The maximum number of written bytes won't be larger than
     * {@link CharBuffer#remaining() out.remaining()}. If some decoder wants to
     * write more bytes than an output buffer's remaining space allows, then a
     * <code>CoderResult.OVERFLOW</code> will be returned, and this method
     * must be called again with a character buffer that has more remaining
     * space. Otherwise this method will return
     * <code>CoderResult.UNDERFLOW</code>, which means one decoding process
     * has been completed successfully.
     * <p>
     * During the flush, the output buffer's position will be changed
     * accordingly, while its mark and limit will be intact.
     *
     * @param out
     *            the given output buffer.
     * @return <code>CoderResult.UNDERFLOW</code> or
     *         <code>CoderResult.OVERFLOW</code>.
     * @throws IllegalStateException
     *             if this decoder hasn't read all input bytes during one
     *             decoding process, which means neither after calling
     *             {@link #decode(ByteBuffer) decode(ByteBuffer)} nor after
     *             calling {@link #decode(ByteBuffer, CharBuffer, boolean)
     *             decode(ByteBuffer, CharBuffer, boolean)} with true as value
     *             for the last boolean parameter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.484 -0500", hash_original_method = "5C3493C7F863D5F0BA88F45F364D1985", hash_generated_method = "0C1B7548141C5F33F7CCB8B03163DF20")
    public final CoderResult flush(CharBuffer out) {
        if (status != END && status != INIT) {
            throw new IllegalStateException();
        }
        CoderResult result = implFlush(out);
        if (result == CoderResult.UNDERFLOW) {
            status = FLUSH;
        }
        return result;
    }

    /**
     * Flushes this decoder. The default implementation does nothing and always
     * returns <code>CoderResult.UNDERFLOW</code>; this method can be
     * overridden if needed.
     *
     * @param out
     *            the output buffer.
     * @return <code>CoderResult.UNDERFLOW</code> or
     *         <code>CoderResult.OVERFLOW</code>.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.485 -0500", hash_original_method = "6025E36E88B99911562F9F8AEE21E28F", hash_generated_method = "1E04149446A6B36F49CA84A2DCCB87EA")
    protected CoderResult implFlush(CharBuffer out) {
        return CoderResult.UNDERFLOW;
    }

    /**
     * Notifies that this decoder's <code>CodingErrorAction</code> specified
     * for malformed input error has been changed. The default implementation
     * does nothing; this method can be overridden if needed.
     *
     * @param newAction
     *            the new action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.486 -0500", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C5211B0A34ACC9B09F85B9C3BB00884B")
    protected void implOnMalformedInput(CodingErrorAction newAction) {
        // default implementation is empty
    }

    /**
     * Notifies that this decoder's <code>CodingErrorAction</code> specified
     * for unmappable character error has been changed. The default
     * implementation does nothing; this method can be overridden if needed.
     *
     * @param newAction
     *            the new action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.487 -0500", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "0A2CA91C3F95D4B9B90FF47CE10AEDD0")
    protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        // default implementation is empty
    }

    /**
     * Notifies that this decoder's replacement has been changed. The default
     * implementation does nothing; this method can be overridden if needed.
     *
     * @param newReplacement
     *            the new replacement string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.487 -0500", hash_original_method = "5014FF47E324504A21AF53F373310654", hash_generated_method = "CA7126CFB919C910AB9265CA91E4181E")
    protected void implReplaceWith(String newReplacement) {
        // default implementation is empty
    }

    /**
     * Reset this decoder's charset related state. The default implementation
     * does nothing; this method can be overridden if needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.488 -0500", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "D34CBDF19BAA869AFE1F7988761B919A")
    protected void implReset() {
        // default implementation is empty
    }

    /**
     * Indicates whether this decoder implements an auto-detecting charset.
     *
     * @return <code>true</code> if this decoder implements an auto-detecting
     *         charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.489 -0500", hash_original_method = "0E3C677639C4DB544DC0D4E7955DC077", hash_generated_method = "484F68005E7CC6E1AD4CCC21E01D546D")
    public boolean isAutoDetecting() {
        return false;
    }

    /**
     * Indicates whether this decoder has detected a charset; this method is
     * optional.
     * <p>
     * If this decoder implements an auto-detecting charset, then this method
     * may start to return true during decoding operation to indicate that a
     * charset has been detected in the input bytes and that the charset can be
     * retrieved by invoking the {@link #detectedCharset() detectedCharset}
     * method.
     * <p>
     * Note that a decoder that implements an auto-detecting charset may still
     * succeed in decoding a portion of the given input even when it is unable
     * to detect the charset. For this reason users should be aware that a
     * <code>false</code> return value does not indicate that no decoding took
     * place.
     * <p>
     * The default implementation always throws an
     * <code>UnsupportedOperationException</code>; it should be overridden by
     * a subclass if needed.
     *
     * @return <code>true</code> if this decoder has detected a charset.
     * @throws UnsupportedOperationException
     *             if this decoder doesn't implement an auto-detecting charset.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.490 -0500", hash_original_method = "EB764964ACE224C10D45E3B66AA00682", hash_generated_method = "6E590BE5A6AC0D3E9330E41B4052CAB7")
    public boolean isCharsetDetected() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns this decoder's <code>CodingErrorAction</code> when malformed input
     * occurred during the decoding process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.491 -0500", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "B62894BCE731B87F0E58598D87803EE2")
    public CodingErrorAction malformedInputAction() {
        return malformedInputAction;
    }

    /**
     * Returns the maximum number of characters which can be created by this
     * decoder for one input byte, must be positive.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.491 -0500", hash_original_method = "1F4ECBF7B137C80889EF1BC2E2A0CCD1", hash_generated_method = "DC866DD1CE1C44A848F8CB588384E580")
    public final float maxCharsPerByte() {
        return maxCharsPerByte;
    }

    /**
     * Sets this decoder's action on malformed input errors.
     *
     * This method will call the
     * {@link #implOnMalformedInput(CodingErrorAction) implOnMalformedInput}
     * method with the given new action as argument.
     *
     * @param newAction
     *            the new action on malformed input error.
     * @return this decoder.
     * @throws IllegalArgumentException
     *             if {@code newAction} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.492 -0500", hash_original_method = "34F534C82C11F1FDAA0DD59455B931CF", hash_generated_method = "CB640B46E428E18A59A6CE6A5A17B083")
    public final CharsetDecoder onMalformedInput(CodingErrorAction newAction) {
        if (newAction == null) {
            throw new IllegalArgumentException();
        }
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
        return this;
    }

    /**
     * Sets this decoder's action on unmappable character errors.
     *
     * This method will call the
     * {@link #implOnUnmappableCharacter(CodingErrorAction) implOnUnmappableCharacter}
     * method with the given new action as argument.
     *
     * @param newAction
     *            the new action on unmappable character error.
     * @return this decoder.
     * @throws IllegalArgumentException
     *             if {@code newAction} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.493 -0500", hash_original_method = "652123D755D0FEE6B30AA61176E436F9", hash_generated_method = "1C907D67377A59EFD818A4E43E32488C")
    public final CharsetDecoder onUnmappableCharacter(CodingErrorAction newAction) {
        if (newAction == null) {
            throw new IllegalArgumentException();
        }
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
        return this;
    }

    /**
     * Returns the replacement string, which is never null or empty.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.494 -0500", hash_original_method = "30CB7E3F60490326C9B63C38EC65670E", hash_generated_method = "818A655877260D9ED8122E58AFE6F930")
    public final String replacement() {
        return replacementChars;
    }

    /**
     * Sets the new replacement string.
     *
     * This method first checks the given replacement's validity, then changes
     * the replacement value, and at last calls the
     * {@link #implReplaceWith(String) implReplaceWith} method with the given
     * new replacement as argument.
     *
     * @param replacement
     *            the replacement string, cannot be null or empty. Its length
     *            cannot be larger than {@link #maxCharsPerByte()}.
     * @return this decoder.
     * @throws IllegalArgumentException
     *             if the given replacement cannot satisfy the requirement
     *             mentioned above.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.496 -0500", hash_original_method = "B18C28BF3814F00BA79DEB9A20AA9835", hash_generated_method = "FED7B2ED5D480DFDBF7CF3E25C57F8FF")
    public final CharsetDecoder replaceWith(String replacement) {
        if (replacement == null) {
            throw new IllegalArgumentException("replacement == null");
        }
        if (replacement.isEmpty()) {
            throw new IllegalArgumentException("replacement.isEmpty()");
        }
        if (replacement.length() > maxCharsPerByte()) {
            throw new IllegalArgumentException("replacement length > maxCharsPerByte: " +
                    replacement.length() + " > " + maxCharsPerByte());
        }
        replacementChars = replacement;
        implReplaceWith(replacement);
        return this;
    }

    /**
     * Resets this decoder. This method will reset the internal status, and then
     * calls <code>implReset()</code> to reset any status related to the
     * specific charset.
     *
     * @return this decoder.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.497 -0500", hash_original_method = "81D7771694F65FD718A9EEA5159D0F76", hash_generated_method = "948F67A0BEFA3B942C2F6F1786ADF726")
    public final CharsetDecoder reset() {
        status = INIT;
        implReset();
        return this;
    }

    /**
     * Returns this decoder's <code>CodingErrorAction</code> when an unmappable
     * character error occurred during the decoding process.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:45:37.498 -0500", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "1F078C226DD272E4C9A8DABC7770CFCF")
    public CodingErrorAction unmappableCharacterAction() {
        return unmappableCharacterAction;
    }
}

