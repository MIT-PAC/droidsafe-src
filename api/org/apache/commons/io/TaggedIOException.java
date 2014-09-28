/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.io;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.IOException;
import java.io.Serializable;

/**
 * An {@link IOException} decorator that adds a serializable tag to the
 * wrapped exception. Both the tag and the original exception can be used
 * to determine further processing when this exception is caught.
 *
 * @since 2.0
 */
public class TaggedIOException extends IOExceptionWithCause {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.693 -0400", hash_original_field = "F94E2E655094FD7447B8A24BADCCA6FB", hash_generated_field = "F26F0168B6E12A1D6C601DA33E32D966")

    private static final long serialVersionUID = -6994123481142850163L;

    /**
     * Checks whether the given throwable is tagged with the given tag.
     * <p>
     * This check can only succeed if the throwable is a
     * {@link TaggedIOException} and the tag is {@link Serializable}, but
     * the argument types are intentionally more generic to make it easier
     * to use this method without type casts.
     * <p>
     * A typical use for this method is in a <code>catch</code> block to
     * determine how a caught exception should be handled:
     * <pre>
     * Serializable tag = ...;
     * try {
     *     ...;
     * } catch (Throwable t) {
     *     if (TaggedIOExcepton.isTaggedWith(t, tag)) {
     *         // special processing for tagged exception
     *     } else {
     *         // handling of other kinds of exceptions
     *     }
     * }
     * </pre>
     *
     * @param throwable The Throwable object to check
     * @param tag tag object
     * @return {@code true} if the throwable has the specified tag,
     * otherwise {@code false}
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.694 -0400", hash_original_method = "63E0E48FCFAD3B9CDC2B7151B763236E", hash_generated_method = "BBABA609D970B3C755CFB46C4556000E")
    
public static boolean isTaggedWith(Throwable throwable, Object tag) {
        return tag != null
            && throwable instanceof TaggedIOException
            && tag.equals(((TaggedIOException) throwable).tag);
    }

    /**
     * Throws the original {@link IOException} if the given throwable is
     * a {@link TaggedIOException} decorator the given tag. Does nothing
     * if the given throwable is of a different type or if it is tagged
     * with some other tag.
     * <p>
     * This method is typically used in a <code>catch</code> block to
     * selectively rethrow tagged exceptions.
     * <pre>
     * Serializable tag = ...;
     * try {
     *     ...;
     * } catch (Throwable t) {
     *     TaggedIOExcepton.throwCauseIfTagged(t, tag);
     *     // handle other kinds of exceptions
     * }
     * </pre>
     *
     * @param throwable an exception
     * @param tag tag object
     * @throws IOException original exception from the tagged decorator, if any
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.694 -0400", hash_original_method = "6F0D83A0421B43B98C64CC4ED5F9276C", hash_generated_method = "C0143962DB8A2834BF4ADCA279761328")
    
public static void throwCauseIfTaggedWith(Throwable throwable, Object tag)
            throws IOException {
        if (isTaggedWith(throwable, tag)) {
            throw ((TaggedIOException) throwable).getCause();
        }
    }
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.695 -0400", hash_original_field = "35F9E36AFD5656E2053D0090B3543EB8", hash_generated_field = "46DF86FF17DD00E0280EE95BAD31EE1B")

    private  Serializable tag;

    /**
     * Creates a tagged wrapper for the given exception.
     *
     * @param original the exception to be tagged
     * @param tag tag of this exception
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.695 -0400", hash_original_method = "AC74491EC46A5F4D5E2635850D49BE12", hash_generated_method = "74563480FCB539C53D13497F29297E99")
    
public TaggedIOException(IOException original, Serializable tag) {
        super(original.getMessage(), original);
        this.tag = tag;
    }

    /**
     * Returns the serializable tag object.
     *
     * @return tag object
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.696 -0400", hash_original_method = "4F4B9B983AF73239615D861FCC97BC71", hash_generated_method = "F6FE9BE16DECBD0D11C68CF59EE8A4EA")
    
public Serializable getTag() {
        return tag;
    }

    /**
     * Returns the wrapped exception. The only difference to the overridden
     * {@link Throwable#getCause()} method is the narrower return type.
     *
     * @return wrapped exception
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:57.696 -0400", hash_original_method = "5CB5049271906C3DE2CF2601187D937A", hash_generated_method = "FF4BB6D04BD41BD41FBE055CC403C939")
    
@Override
    public IOException getCause() {
        return (IOException) super.getCause();
    }

}
