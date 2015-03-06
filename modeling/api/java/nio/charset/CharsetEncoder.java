/* Licensed to the Apache Software Foundation (ASF) under one or more
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.nio.charset;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

public abstract class CharsetEncoder {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.230 -0500", hash_original_field = "B76CDD71E689972A5BDDB24204A777AF", hash_generated_field = "13F9744A97D618343432AF93BBD9D480")

    private static final int READY = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.233 -0500", hash_original_field = "DB372BD195DD04D38594D658CD0941C7", hash_generated_field = "BE844086D377CEB871B6E1DD59844EB0")

    private static final int ONGOING = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.236 -0500", hash_original_field = "330B5909E190BF7186B4F7E611F5BC23", hash_generated_field = "B476F4C7146F42E47055EAC44A214B2C")

    private static final int END = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.238 -0500", hash_original_field = "15B05665B9D3473592ABD28718757C60", hash_generated_field = "D345F0B97A5F86F7808649FE9032B485")

    private static final int FLUSH = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.241 -0500", hash_original_field = "FFE197A6174A45A9AA66A22BD0EF4A1E", hash_generated_field = "A23FBDE5837AE7A8AD8DDC6F0A5E686A")

    private static final int INIT = 4;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.243 -0500", hash_original_field = "071AD032827EC07DCD0193396C176EE2", hash_generated_field = "220BF257D2CCF23A35C6D1D35FB3F79C")

    private  Charset cs;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.246 -0500", hash_original_field = "B3DDB7A0B36CE088327AE6AB3E3FE881", hash_generated_field = "5C783D0D8B0013302A29C9244F7615B3")

    private  float averageBytesPerChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.249 -0500", hash_original_field = "D0B54BAFB708906DB74080547292069C", hash_generated_field = "B19FD23ACD0442A467073D3E6F98A95A")

    private  float maxBytesPerChar;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.251 -0500", hash_original_field = "66F7C2E8DE97CDE8CFCDC7D1BE499877", hash_generated_field = "A0C8011AEB0BF78979EBADE417E449F0")

    private byte[] replacementBytes;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.253 -0500", hash_original_field = "72D62D1933050B7AC2D9DFC43782C64E", hash_generated_field = "4BAC49709EDEAEFDD9E07400E0F02406")

    private int status;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.259 -0500", hash_original_field = "59CD61E3A383ACAD01F8F1AA33285180", hash_generated_field = "3E2B0E3E2E572DECE0B20D77E19B79CF")

    private boolean finished;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.262 -0500", hash_original_field = "321407B0D07B357A2C1E6B0BC805BF74", hash_generated_field = "1214F64762553AD2B0BE51AAC36B64DE")

    private CodingErrorAction malformedInputAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.265 -0500", hash_original_field = "27CE0B153219039850616F66BE87462B", hash_generated_field = "60F320659477DF0A50B0661AEB74E53F")

    private CodingErrorAction unmappableCharacterAction;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.267 -0500", hash_original_field = "EB8B81788E764E7EC09C99438B975CD8", hash_generated_field = "E190C0DE068854E0E786DAC309DED1B8")

    private CharsetDecoder decoder;

    /**
     * Constructs a new {@code CharsetEncoder} using the given parameters and
     * the replacement byte array {@code { (byte) '?' }}.
     */
    @DSComment("Character encoder/decoder")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.270 -0500", hash_original_method = "5E9CA4841A80C315BA24674061FE2949", hash_generated_method = "D723EDBE48CACC50A9409DF44DC42EAC")
    
protected CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar) {
        this(cs, averageBytesPerChar, maxBytesPerChar, new byte[] { (byte) '?' });
    }

    /**
     * Constructs a new <code>CharsetEncoder</code> using the given
     * <code>Charset</code>, replacement byte array, average number and
     * maximum number of bytes created by this encoder for one input character.
     *
     * @param cs
     *            the <code>Charset</code> to be used by this encoder.
     * @param averageBytesPerChar
     *            average number of bytes created by this encoder for one single
     *            input character, must be positive.
     * @param maxBytesPerChar
     *            maximum number of bytes which can be created by this encoder
     *            for one single input character, must be positive.
     * @param replacement
     *            the replacement byte array, cannot be null or empty, its
     *            length cannot be larger than <code>maxBytesPerChar</code>,
     *            and must be a legal replacement, which can be justified by
     *            {@link #isLegalReplacement(byte[]) isLegalReplacement}.
     * @throws IllegalArgumentException
     *             if any parameters are invalid.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.272 -0500", hash_original_method = "33500150E00A96E14E2810282423268E", hash_generated_method = "0353D675BDF5C244E9E528B3C3C563D6")
    
protected CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement) {
        this(cs, averageBytesPerChar, maxBytesPerChar, replacement, false);
    }

    @DSComment("Package priviledge")
    @DSBan(DSCat.DEFAULT_MODIFIER)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.275 -0500", hash_original_method = "173A83611BD70B9738420414876CE0BB", hash_generated_method = "50AF5491F0B8B2D5C34DF134EC7ECEFF")
    
CharsetEncoder(Charset cs, float averageBytesPerChar, float maxBytesPerChar, byte[] replacement, boolean trusted) {
        if (averageBytesPerChar <= 0 || maxBytesPerChar <= 0) {
            throw new IllegalArgumentException("averageBytesPerChar and maxBytesPerChar must both be positive");
        }
        if (averageBytesPerChar > maxBytesPerChar) {
            throw new IllegalArgumentException("averageBytesPerChar is greater than maxBytesPerChar");
        }
        this.cs = cs;
        this.averageBytesPerChar = averageBytesPerChar;
        this.maxBytesPerChar = maxBytesPerChar;
        status = INIT;
        malformedInputAction = CodingErrorAction.REPORT;
        unmappableCharacterAction = CodingErrorAction.REPORT;
        if (trusted) {
            // The RI enforces unnecessary restrictions on the replacement bytes. We trust ICU to
            // know what it's doing. Doing so lets us support ICU's EUC-JP, SCSU, and Shift_JIS.
            this.replacementBytes = replacement;
        } else {
            replaceWith(replacement);
        }
    }

    /**
     * Returns the average number of bytes created by this encoder for a single
     * input character.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.278 -0500", hash_original_method = "A746602428AC27FECC8176A57B5A2933", hash_generated_method = "63E37E337CD2C4CC1A05968ED0D75790")
    
public final float averageBytesPerChar() {
        return averageBytesPerChar;
    }

    /**
     * Checks if the given character can be encoded by this encoder.
     * <p>
     * Note that this method can change the internal status of this encoder, so
     * it should not be called when another encoding process is ongoing,
     * otherwise it will throw an <code>IllegalStateException</code>.
     * <p>
     * This method can be overridden for performance improvement.
     *
     * @param c
     *            the given encoder.
     * @return true if given character can be encoded by this encoder.
     * @throws IllegalStateException
     *             if another encode process is ongoing so that the current
     *             internal status is neither RESET or FLUSH.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.280 -0500", hash_original_method = "DF8D80CA8C09E77634765D8D414FAE26", hash_generated_method = "CC1D7AFBDC33C8FD5681DF2F0BA20738")
    
public boolean canEncode(char c) {
        return implCanEncode(CharBuffer.wrap(new char[] { c }));
    }

    // implementation of canEncode
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.283 -0500", hash_original_method = "8FE38300B66D2E408C3C937D4188B910", hash_generated_method = "B24499D4671ABD45CCE054E5DE6BAEFD")
    
private boolean implCanEncode(CharBuffer cb) {
        if (status == FLUSH || status == INIT) {
            status = READY;
        }
        if (status != READY) {
            throw new IllegalStateException("encoding already in progress");
        }
        CodingErrorAction malformBak = malformedInputAction;
        CodingErrorAction unmapBak = unmappableCharacterAction;
        onMalformedInput(CodingErrorAction.REPORT);
        onUnmappableCharacter(CodingErrorAction.REPORT);
        boolean result = true;
        try {
            this.encode(cb);
        } catch (CharacterCodingException e) {
            result = false;
        }
        onMalformedInput(malformBak);
        onUnmappableCharacter(unmapBak);
        reset();
        return result;
    }

    /**
     * Checks if a given <code>CharSequence</code> can be encoded by this
     * encoder.
     *
     * Note that this method can change the internal status of this encoder, so
     * it should not be called when another encode process is ongoing, otherwise
     * it will throw an <code>IllegalStateException</code>.
     *
     * This method can be overridden for performance improvement.
     *
     * @param sequence
     *            the given <code>CharSequence</code>.
     * @return true if the given <code>CharSequence</code> can be encoded by
     *         this encoder.
     * @throws IllegalStateException
     *             if current internal status is neither RESET or FLUSH.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.286 -0500", hash_original_method = "54A1B7BF9180636CA7E06E09FE414A09", hash_generated_method = "B5B4B2D83E66A14A1BB7D29DF8647F4F")
    
public boolean canEncode(CharSequence sequence) {
        CharBuffer cb;
        if (sequence instanceof CharBuffer) {
            cb = ((CharBuffer) sequence).duplicate();
        } else {
            cb = CharBuffer.wrap(sequence);
        }
        return implCanEncode(cb);
    }

    /**
     * Returns the {@link Charset} which this encoder uses.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.289 -0500", hash_original_method = "B98730A31745049759B27FC27542555A", hash_generated_method = "1B3A1A60F8135EF363B08F511D4AE81E")
    
public final Charset charset() {
        return cs;
    }

    /**
     * This is a facade method for the encoding operation.
     * <p>
     * This method encodes the remaining character sequence of the given
     * character buffer into a new byte buffer. This method performs a complete
     * encoding operation, resets at first, then encodes, and flushes at last.
     * <p>
     * This method should not be invoked if another encode operation is ongoing.
     *
     * @param in
     *            the input buffer.
     * @return a new <code>ByteBuffer</code> containing the bytes produced by
     *         this encoding operation. The buffer's limit will be the position
     *         of the last byte in the buffer, and the position will be zero.
     * @throws IllegalStateException
     *             if another encoding operation is ongoing.
     * @throws MalformedInputException
     *             if an illegal input character sequence for this charset is
     *             encountered, and the action for malformed error is
     *             {@link CodingErrorAction#REPORT CodingErrorAction.REPORT}
     * @throws UnmappableCharacterException
     *             if a legal but unmappable input character sequence for this
     *             charset is encountered, and the action for unmappable
     *             character error is
     *             {@link CodingErrorAction#REPORT CodingErrorAction.REPORT}.
     *             Unmappable means the Unicode character sequence at the input
     *             buffer's current position cannot be mapped to a equivalent
     *             byte sequence.
     * @throws CharacterCodingException
     *             if other exception happened during the encode operation.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.292 -0500", hash_original_method = "6617ED92398FABBB6F1186A03F59422C", hash_generated_method = "8A3458D855F96B73420B80FFD95A2DAE")
    
public final ByteBuffer encode(CharBuffer in) throws CharacterCodingException {
        if (in.remaining() == 0) {
            return ByteBuffer.allocate(0);
        }
        reset();
        int length = (int) (in.remaining() * averageBytesPerChar);
        ByteBuffer output = ByteBuffer.allocate(length);
        CoderResult result = null;
        while (true) {
            result = encode(in, output, false);
            if (result==CoderResult.UNDERFLOW) {
                break;
            } else if (result==CoderResult.OVERFLOW) {
                output = allocateMore(output);
                continue;
            }
            checkCoderResult(result);
        }
        result = encode(in, output, true);
        checkCoderResult(result);

        while (true) {
            result = flush(output);
            if (result==CoderResult.UNDERFLOW) {
                output.flip();
                break;
            } else if (result==CoderResult.OVERFLOW) {
                output = allocateMore(output);
                continue;
            }
            checkCoderResult(result);
            output.flip();
            if (result.isMalformed()) {
                throw new MalformedInputException(result.length());
            } else if (result.isUnmappable()) {
                throw new UnmappableCharacterException(result.length());
            }
            break;
        }
        status = READY;
        finished = true;
        return output;
    }

    /*
     * checks the result whether it needs to throw CharacterCodingException.
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.295 -0500", hash_original_method = "AAF7B17852C8827C6D375001E4EF8669", hash_generated_method = "D4B9B7436AC3B98BB199F3D923E8CA0A")
    
private void checkCoderResult(CoderResult result) throws CharacterCodingException {
        if (malformedInputAction == CodingErrorAction.REPORT && result.isMalformed() ) {
            throw new MalformedInputException(result.length());
        } else if (unmappableCharacterAction == CodingErrorAction.REPORT && result.isUnmappable()) {
            throw new UnmappableCharacterException(result.length());
        }
    }

    // allocate more spaces to the given ByteBuffer
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.297 -0500", hash_original_method = "46B614F003BDECDBAF0C028FA8A61DD7", hash_generated_method = "05A13E5088B9AD144A3A695CB753E4B7")
    
private ByteBuffer allocateMore(ByteBuffer output) {
        if (output.capacity() == 0) {
            return ByteBuffer.allocate(1);
        }
        ByteBuffer result = ByteBuffer.allocate(output.capacity() * 2);
        output.flip();
        result.put(output);
        return result;
    }

    /**
     * Encodes characters starting at the current position of the given input
     * buffer, and writes the equivalent byte sequence into the given output
     * buffer from its current position.
     * <p>
     * The buffers' position will be changed with the reading and writing
     * operation, but their limits and marks will be kept intact.
     * <p>
     * A <code>CoderResult</code> instance will be returned according to
     * following rules:
     * <ul>
     * <li>A {@link CoderResult#malformedForLength(int) malformed input} result
     * indicates that some malformed input error was encountered, and the
     * erroneous characters start at the input buffer's position and their
     * number can be got by result's {@link CoderResult#length() length}. This
     * kind of result can be returned only if the malformed action is
     * {@link CodingErrorAction#REPORT CodingErrorAction.REPORT}.</li>
     * <li>{@link CoderResult#UNDERFLOW CoderResult.UNDERFLOW} indicates that
     * as many characters as possible in the input buffer have been encoded. If
     * there is no further input and no characters left in the input buffer then
     * this task is complete. If this is not the case then the client should
     * call this method again supplying some more input characters.</li>
     * <li>{@link CoderResult#OVERFLOW CoderResult.OVERFLOW} indicates that the
     * output buffer has been filled, while there are still some characters
     * remaining in the input buffer. This method should be invoked again with a
     * non-full output buffer.</li>
     * <li>A {@link CoderResult#unmappableForLength(int) unmappable character}
     * result indicates that some unmappable character error was encountered,
     * and the erroneous characters start at the input buffer's position and
     * their number can be got by result's {@link CoderResult#length() length}.
     * This kind of result can be returned only on
     * {@link CodingErrorAction#REPORT CodingErrorAction.REPORT}.</li>
     * </ul>
     * <p>
     * The <code>endOfInput</code> parameter indicates if the invoker can
     * provider further input. This parameter is true if and only if the
     * characters in the current input buffer are all inputs for this encoding
     * operation. Note that it is common and won't cause an error if the invoker
     * sets false and then has no more input available, while it may cause an
     * error if the invoker always sets true in several consecutive invocations.
     * This would make the remaining input to be treated as malformed input.
     * input.
     * <p>
     * This method invokes the
     * {@link #encodeLoop(CharBuffer, ByteBuffer) encodeLoop} method to
     * implement the basic encode logic for a specific charset.
     *
     * @param in
     *            the input buffer.
     * @param out
     *            the output buffer.
     * @param endOfInput
     *            true if all the input characters have been provided.
     * @return a <code>CoderResult</code> instance indicating the result.
     * @throws IllegalStateException
     *             if the encoding operation has already started or no more
     *             input is needed in this encoding process.
     * @throws CoderMalfunctionError
     *             If the {@link #encodeLoop(CharBuffer, ByteBuffer) encodeLoop}
     *             method threw an <code>BufferUnderflowException</code> or
     *             <code>BufferUnderflowException</code>.
     */
    @DSComment("Character encoder/decoder")
    @DSSafe(DSCat.UTIL_FUNCTION)
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.300 -0500", hash_original_method = "F53B4856D46D71BB987D9EC6F2ED08EE", hash_generated_method = "708ABAF1F51A81A7CA9ECE00BF14A3A2")
    
public final CoderResult encode(CharBuffer in, ByteBuffer out, boolean endOfInput) {
        // If the previous step is encode(CharBuffer), then no more input is needed
        // thus endOfInput should not be false
        if (status == READY && finished && !endOfInput) {
            throw new IllegalStateException();
        }
        if ((status == FLUSH) || (!endOfInput && status == END)) {
            throw new IllegalStateException();
        }

        CoderResult result;
        while (true) {
            try {
                result = encodeLoop(in, out);
            } catch (BufferOverflowException e) {
                throw new CoderMalfunctionError(e);
            } catch (BufferUnderflowException e) {
                throw new CoderMalfunctionError(e);
            }
            if (result==CoderResult.UNDERFLOW) {
                status = endOfInput ? END : ONGOING;
                if (endOfInput) {
                    int remaining = in.remaining();
                    if (remaining > 0) {
                        result = CoderResult.malformedForLength(remaining);
                    } else {
                        return result;
                    }
                } else {
                    return result;
                }
            } else if (result==CoderResult.OVERFLOW) {
                status = endOfInput ? END : ONGOING;
                return result;
            }
            CodingErrorAction action = malformedInputAction;
            if (result.isUnmappable()) {
                action = unmappableCharacterAction;
            }
            // If the action is IGNORE or REPLACE, we should continue
            // encoding.
            if (action == CodingErrorAction.REPLACE) {
                if (out.remaining() < replacementBytes.length) {
                    return CoderResult.OVERFLOW;
                }
                out.put(replacementBytes);
            } else {
                if (action != CodingErrorAction.IGNORE) {
                    return result;
                }
            }
            in.position(in.position() + result.length());
        }
    }

    /**
     * Encodes characters into bytes. This method is called by
     * {@link #encode(CharBuffer, ByteBuffer, boolean) encode}.
     * <p>
     * This method will implement the essential encoding operation, and it won't
     * stop encoding until either all the input characters are read, the output
     * buffer is filled, or some exception is encountered. Then it will
     * return a <code>CoderResult</code> object indicating the result of the
     * current encoding operation. The rule to construct the
     * <code>CoderResult</code> is the same as for
     * {@link #encode(CharBuffer, ByteBuffer, boolean) encode}. When an
     * exception is encountered in the encoding operation, most implementations
     * of this method will return a relevant result object to the
     * {@link #encode(CharBuffer, ByteBuffer, boolean) encode} method, and some
     * performance optimized implementation may handle the exception and
     * implement the error action itself.
     * <p>
     * The buffers are scanned from their current positions, and their positions
     * will be modified accordingly, while their marks and limits will be
     * intact. At most {@link CharBuffer#remaining() in.remaining()} characters
     * will be read, and {@link ByteBuffer#remaining() out.remaining()} bytes
     * will be written.
     * <p>
     * Note that some implementations may pre-scan the input buffer and return
     * <code>CoderResult.UNDERFLOW</code> until it receives sufficient input.
     * <p>
     * @param in
     *            the input buffer.
     * @param out
     *            the output buffer.
     * @return a <code>CoderResult</code> instance indicating the result.
     */
    @DSComment("Abstract Method")
    @DSSpec(DSCat.ABSTRACT_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.303 -0500", hash_original_method = "9616F044279972BD99324EB6552327DB", hash_generated_method = "87FA30EDAC109573D595DF9CF40D1A26")
    
protected abstract CoderResult encodeLoop(CharBuffer in, ByteBuffer out);

    /**
     * Flushes this encoder.
     * <p>
     * This method will call {@link #implFlush(ByteBuffer) implFlush}. Some
     * encoders may need to write some bytes to the output buffer when they have
     * read all input characters, subclasses can overridden
     * {@link #implFlush(ByteBuffer) implFlush} to perform writing action.
     * <p>
     * The maximum number of written bytes won't larger than
     * {@link ByteBuffer#remaining() out.remaining()}. If some encoder wants to
     * write more bytes than the output buffer's available remaining space, then
     * <code>CoderResult.OVERFLOW</code> will be returned, and this method
     * must be called again with a byte buffer that has free space. Otherwise
     * this method will return <code>CoderResult.UNDERFLOW</code>, which
     * means one encoding process has been completed successfully.
     * <p>
     * During the flush, the output buffer's position will be changed
     * accordingly, while its mark and limit will be intact.
     *
     * @param out
     *            the given output buffer.
     * @return <code>CoderResult.UNDERFLOW</code> or
     *         <code>CoderResult.OVERFLOW</code>.
     * @throws IllegalStateException
     *             if this encoder hasn't read all input characters during one
     *             encoding process, which means neither after calling
     *             {@link #encode(CharBuffer) encode(CharBuffer)} nor after
     *             calling {@link #encode(CharBuffer, ByteBuffer, boolean)
     *             encode(CharBuffer, ByteBuffer, boolean)} with {@code true}
     *             for the last boolean parameter.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.306 -0500", hash_original_method = "7DF66453B2225F37798DBF2842A3A344", hash_generated_method = "157E2A514418A254EA8960AE10FAF083")
    
public final CoderResult flush(ByteBuffer out) {
        if (status != END && status != READY) {
            throw new IllegalStateException();
        }
        CoderResult result = implFlush(out);
        if (result == CoderResult.UNDERFLOW) {
            status = FLUSH;
        }
        return result;
    }

    /**
     * Flushes this encoder. The default implementation does nothing and always
     * returns <code>CoderResult.UNDERFLOW</code>; this method can be
     * overridden if needed.
     *
     * @param out
     *            the output buffer.
     * @return <code>CoderResult.UNDERFLOW</code> or
     *         <code>CoderResult.OVERFLOW</code>.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.308 -0500", hash_original_method = "A9BF2BD565E7966B3C6B16D11959F2CA", hash_generated_method = "B360BD1295B9D6721C2DA60E9DC9314C")
    
protected CoderResult implFlush(ByteBuffer out) {
        return CoderResult.UNDERFLOW;
    }

    /**
     * Notifies that this encoder's <code>CodingErrorAction</code> specified
     * for malformed input error has been changed. The default implementation
     * does nothing; this method can be overridden if needed.
     *
     * @param newAction
     *            the new action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.311 -0500", hash_original_method = "E03D9D5B6C40FD58B1EEECF43C9BC127", hash_generated_method = "C5211B0A34ACC9B09F85B9C3BB00884B")
    
protected void implOnMalformedInput(CodingErrorAction newAction) {
        // default implementation is empty
    }

    /**
     * Notifies that this encoder's <code>CodingErrorAction</code> specified
     * for unmappable character error has been changed. The default
     * implementation does nothing; this method can be overridden if needed.
     *
     * @param newAction
     *            the new action.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.313 -0500", hash_original_method = "33D941D09604A3F698502AE892B2B2F1", hash_generated_method = "0A2CA91C3F95D4B9B90FF47CE10AEDD0")
    
protected void implOnUnmappableCharacter(CodingErrorAction newAction) {
        // default implementation is empty
    }

    /**
     * Notifies that this encoder's replacement has been changed. The default
     * implementation does nothing; this method can be overridden if needed.
     *
     * @param newReplacement
     *            the new replacement string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.315 -0500", hash_original_method = "BBBD9A68869312EDB40CCAE9146777D7", hash_generated_method = "ECB5A88F778C3531BB777EE6B7CE22DF")
    
protected void implReplaceWith(byte[] newReplacement) {
        // default implementation is empty
    }

    /**
     * Resets this encoder's charset related state. The default implementation
     * does nothing; this method can be overridden if needed.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.318 -0500", hash_original_method = "B1E265ECD4B779BE3343E27B901DC354", hash_generated_method = "D34CBDF19BAA869AFE1F7988761B919A")
    
protected void implReset() {
        // default implementation is empty
    }

    /**
     * Checks if the given argument is legal as this encoder's replacement byte
     * array.
     *
     * The given byte array is legal if and only if it can be decode into
     * sixteen bits Unicode characters.
     *
     * This method can be overridden for performance improvement.
     *
     * @param replacement
     *            the given byte array to be checked.
     * @return true if the the given argument is legal as this encoder's
     *         replacement byte array.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.321 -0500", hash_original_method = "0E6BADBD5D3BB826133FA0CE0CAA8F2B", hash_generated_method = "69D218CAF7786E069C4F35593AA33A65")
    
public boolean isLegalReplacement(byte[] replacement) {
        if (decoder == null) {
            decoder = cs.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.REPORT);
            decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
        }
        ByteBuffer in = ByteBuffer.wrap(replacement);
        CharBuffer out = CharBuffer.allocate((int) (replacement.length * decoder.maxCharsPerByte()));
        CoderResult result = decoder.decode(in, out, true);
        return !result.isError();
    }

    /**
     * Returns this encoder's <code>CodingErrorAction</code> when a malformed
     * input error occurred during the encoding process.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.323 -0500", hash_original_method = "14FFD5293B4145E0D4BC6D81F9598816", hash_generated_method = "B62894BCE731B87F0E58598D87803EE2")
    
public CodingErrorAction malformedInputAction() {
        return malformedInputAction;
    }

    /**
     * Returns the maximum number of bytes which can be created by this encoder for
     * one input character, must be positive.
     */
    @DSComment("Character encoder/decoder")
    @DSSafe(DSCat.UTIL_FUNCTION)
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.326 -0500", hash_original_method = "F4624CD8E2F5B5C085387046C0856D44", hash_generated_method = "0EE4AAAF4A83FB7CE34D8002046C29C5")
    
public final float maxBytesPerChar() {
        return maxBytesPerChar;
    }

    /**
     * Sets this encoder's action on malformed input error.
     *
     * This method will call the
     * {@link #implOnMalformedInput(CodingErrorAction) implOnMalformedInput}
     * method with the given new action as argument.
     *
     * @param newAction
     *            the new action on malformed input error.
     * @return this encoder.
     * @throws IllegalArgumentException
     *             if the given newAction is null.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.328 -0500", hash_original_method = "9AA0403DB22EF3A510B565026DCE2424", hash_generated_method = "0011EC96FF5543956D12364517834E9A")
    
public final CharsetEncoder onMalformedInput(CodingErrorAction newAction) {
        if (newAction == null) {
            throw new IllegalArgumentException("newAction == null");
        }
        malformedInputAction = newAction;
        implOnMalformedInput(newAction);
        return this;
    }

    /**
     * Sets this encoder's action on unmappable character error.
     *
     * This method will call the
     * {@link #implOnUnmappableCharacter(CodingErrorAction) implOnUnmappableCharacter}
     * method with the given new action as argument.
     *
     * @param newAction
     *            the new action on unmappable character error.
     * @return this encoder.
     * @throws IllegalArgumentException
     *             if the given newAction is null.
     */
    @DSComment("normal android callback")
    @DSSafe(DSCat.ANDROID_CALLBACK)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.331 -0500", hash_original_method = "8F9E9A5BA6AED0663F62AB88ADE1A1B8", hash_generated_method = "92C50D049871AEE37000E49D171DBEFA")
    
public final CharsetEncoder onUnmappableCharacter(CodingErrorAction newAction) {
        if (newAction == null) {
            throw new IllegalArgumentException("newAction == null");
        }
        unmappableCharacterAction = newAction;
        implOnUnmappableCharacter(newAction);
        return this;
    }

    /**
     * Returns the replacement byte array, which is never null or empty.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.333 -0500", hash_original_method = "D4DB6E703F0B5C3D24041A00F1C8C203", hash_generated_method = "4545941C969FD37B8017D053CD6AA5CB")
    
public final byte[] replacement() {
        return replacementBytes;
    }

    /**
     * Sets the new replacement value.
     *
     * This method first checks the given replacement's validity, then changes
     * the replacement value and finally calls the
     * {@link #implReplaceWith(byte[]) implReplaceWith} method with the given
     * new replacement as argument.
     *
     * @param replacement
     *            the replacement byte array, cannot be null or empty, its
     *            length cannot be larger than <code>maxBytesPerChar</code>,
     *            and it must be legal replacement, which can be justified by
     *            calling <code>isLegalReplacement(byte[] replacement)</code>.
     * @return this encoder.
     * @throws IllegalArgumentException
     *             if the given replacement cannot satisfy the requirement
     *             mentioned above.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.337 -0500", hash_original_method = "267C7D54312382305679F98E9AD49DA0", hash_generated_method = "2A83C62DEA8BAF96E6A492527CD3B2E2")
    
public final CharsetEncoder replaceWith(byte[] replacement) {
        if (replacement == null) {
            throw new IllegalArgumentException("replacement == null");
        }
        if (replacement.length == 0) {
            throw new IllegalArgumentException("replacement.length == 0");
        }
        if (replacement.length > maxBytesPerChar()) {
            throw new IllegalArgumentException("replacement length > maxBytesPerChar: " +
                    replacement.length + " > " + maxBytesPerChar());
        }
        if (!isLegalReplacement(replacement)) {
            throw new IllegalArgumentException("bad replacement: " + Arrays.toString(replacement));
        }
        // It seems like a bug, but the RI doesn't clone, and we have tests that check we don't.
        this.replacementBytes = replacement;
        implReplaceWith(replacementBytes);
        return this;
    }

    /**
     * Resets this encoder. This method will reset the internal status and then
     * calls <code>implReset()</code> to reset any status related to the
     * specific charset.
     *
     * @return this encoder.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.339 -0500", hash_original_method = "939E78B196C94EAC65CBC7206A9E1DD0", hash_generated_method = "74582C54E087C1EF781FF318AC604A85")
    
public final CharsetEncoder reset() {
        status = INIT;
        implReset();
        return this;
    }

    /**
     * Returns this encoder's <code>CodingErrorAction</code> when unmappable
     * character occurred during encoding process.
     */
    @DSSource({DSSourceKind.SENSITIVE_UNCATEGORIZED})
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 12:57:00.341 -0500", hash_original_method = "01254405DC3888434A269A87FF2AF4FB", hash_generated_method = "1F078C226DD272E4C9A8DABC7770CFCF")
    
public CodingErrorAction unmappableCharacterAction() {
        return unmappableCharacterAction;
    }
}

