/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
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
package java.util.jar;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.SortedMap;

/**
 * Class factory for {@link Pack200.Packer} and {@link Pack200.Unpacker}.
 */
public abstract class Pack200 {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.000 -0400", hash_original_field = "0A8D9C94DF63C00EC52E266A40B1B48C", hash_generated_field = "397EC0F88228C3E73975453F2E0A6686")


    private static final String SYSTEM_PROPERTY_PACKER = "java.util.jar.Pack200.Packer";
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.000 -0400", hash_original_field = "E48B99E48EF6FA9B4C90896A19DA4DC5", hash_generated_field = "1818C1322912F587690ABBCC7672BEF8")


    private static final String SYSTEM_PROPERTY_UNPACKER = "java.util.jar.Pack200.Unpacker";

    /**
     * Returns a new instance of a packer engine.
     * <p>
     * The implementation of the packer engine is defined by the system property
     * {@code 'java.util.jar.Pack200.Packer'}. If this system property is
     * defined an instance of the specified class is returned, otherwise the
     * system's default implementation is returned.
     *
     * @return an instance of {@code Packer}
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.001 -0400", hash_original_method = "0DB61DB55DA4BB16061851D8A960B208", hash_generated_method = "FCD64532160FF61812D8E59AB8415D2D")
    
public static Pack200.Packer newPacker() {
        String className = System.getProperty(SYSTEM_PROPERTY_PACKER, "org.apache.harmony.pack200.Pack200PackerAdapter");
        try {
            // TODO Not sure if this will cause problems with
            // loading the packer
            return (Packer) ClassLoader.getSystemClassLoader().loadClass(className).newInstance();
        } catch (Exception e) {
            throw new Error("Can't load class " + className, e);
        }
    }

    /**
     * Returns a new instance of a unpacker engine.
     * <p>
     * The implementation of the unpacker engine is defined by the system
     * property {@code 'java.util.jar.Pack200.Unpacker'}. If this system
     * property is defined an instance of the specified class is returned,
     * otherwise the system's default implementation is returned.
     *
     * @return a instance of {@code Unpacker}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.002 -0400", hash_original_method = "BCB56600D81258E18974C175F9748F0D", hash_generated_method = "EF82BE10A5D9A85A2AA555E9DD1FA398")
    
public static Pack200.Unpacker newUnpacker() {
        String className = System.getProperty(SYSTEM_PROPERTY_UNPACKER, "org.apache.harmony.unpack200.Pack200UnpackerAdapter");
        try {
            return (Unpacker) ClassLoader.getSystemClassLoader().loadClass(className).newInstance();
        } catch (Exception e) {
            throw new Error("Can't load class " + className, e);
        }
    }

    /**
     * Prevent this class from being instantiated.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:00:57.001 -0400", hash_original_method = "05DDD215702ADC72D2339C8CAF8FC4D2", hash_generated_method = "7B0A2E701DC5214837AAFEA4DA158CD7")
    
private Pack200() {
        // do nothing
    }

    /**
     * The interface defining the API for converting a JAR file to an output
     * stream in the Pack200 format.
     */
    public static interface Packer {

        /**
         * the format of a class attribute name.
         */
        static final String CLASS_ATTRIBUTE_PFX = "pack.class.attribute.";

        /**
         * the format of a code attribute name.
         */
        static final String CODE_ATTRIBUTE_PFX = "pack.code.attribute.";

        /**
         * the deflation hint to set in the output archive.
         */
        static final String DEFLATE_HINT = "pack.deflate.hint";

        /**
         * the indicated amount of effort to use in compressing the archive.
         */
        static final String EFFORT = "pack.effort";

        /**
         * a String representation for {@code error}.
         */
        static final String ERROR = "error";

        /**
         * a String representation of {@code false}.
         */
        static final String FALSE = "false";

        /**
         * the format of a field attribute name.
         */
        static final String FIELD_ATTRIBUTE_PFX = "pack.field.attribute.";

        /**
         * a String representation for {@code keep}.
         */
        static final String KEEP = "keep";

        /**
         * decide if all elements shall transmit in their original order.
         */
        static final String KEEP_FILE_ORDER = "pack.keep.file.order";

        /**
         * a String representation for {@code latest}.
         */
        static final String LATEST = "latest";

        /**
         * the format of a method attribute name.
         */
        static final String METHOD_ATTRIBUTE_PFX = "pack.method.attribute.";

        /**
         * if it shall attempt to determine the latest modification time if this
         * is set to {@code LATEST}.
         */
        static final String MODIFICATION_TIME = "pack.modification.time";

        /**
         * a String representation of {@code pass}.
         */
        static final String PASS = "pass";

        /**
         * the file that will not be compressed.
         */
        static final String PASS_FILE_PFX = "pack.pass.file.";

        /**
         * packer progress as a percentage.
         */
        static final String PROGRESS = "pack.progress";

        /**
         * The number of bytes of each archive segment.
         */
        static final String SEGMENT_LIMIT = "pack.segment.limit";

        /**
         * a String representation of {@code strip}.
         */
        static final String STRIP = "strip";

        /**
         * a String representation of {@code true}.
         */
        static final String TRUE = "true";

        /**
         * the action to take if an unknown attribute is encountered.
         */
        static final String UNKNOWN_ATTRIBUTE = "pack.unknown.attribute";

        /**
         * Returns a sorted map of the properties of this packer.
         *
         * @return the properties of the packer.
         */
        SortedMap<String, String> properties();

        /**
         * Pack the specified JAR file to the specified output stream.
         *
         * @param in
         *            JAR file to be compressed.
         * @param out
         *            stream of compressed data.
         * @throws IOException
         *             if I/O exception occurs.
         */
        void pack(JarFile in, OutputStream out) throws IOException;

        /**
         * Pack the data from the specified jar input stream to the specified
         * output stream.
         *
         * @param in
         *            stream of uncompressed JAR data.
         * @param out
         *            stream of compressed data.
         * @throws IOException
         *             if I/O exception occurs.
         */
        void pack(JarInputStream in, OutputStream out) throws IOException;

        /**
         * add a listener for PropertyChange events
         *
         * @param listener
         *            the listener to listen if PropertyChange events occurs
         */
        void addPropertyChangeListener(PropertyChangeListener listener);

        /**
         * remove a listener
         *
         * @param listener
         *            listener to remove
         */
        void removePropertyChangeListener(PropertyChangeListener listener);
    }

    /**
     * The interface defining the API for converting a packed stream in the
     * Pack200 format to a JAR file.
     */
    public static interface Unpacker {

        /**
         * The String indicating if the unpacker should ignore all transmitted
         * values,can be replaced by either {@code true} or {@code false}.
         */
        static final String DEFLATE_HINT = "unpack.deflate.hint";

        /**
         * a String representation of {@code false}.
         */
        static final String FALSE = "false";

        /**
         * a String representation of {@code keep}.
         */
        static final String KEEP = "keep";

        /**
         * the progress as a {@code percentage}.
         */
        static final String PROGRESS = "unpack.progress";

        /**
         * a String representation of {@code true}.
         */
        static final String TRUE = "true";

        /**
         * Returns a sorted map of the properties of this unpacker.
         *
         * @return the properties of unpacker.
         */
        SortedMap<String, String> properties();

        /**
         * Unpack the specified stream to the specified JAR output stream.
         *
         * @param in
         *            stream to uncompressed.
         * @param out
         *            JAR output stream of uncompressed data.
         * @throws IOException
         *             if I/O exception occurs.
         */
        void unpack(InputStream in, JarOutputStream out) throws IOException;

        /**
         * Unpack the contents of the specified {@code File} to the specified
         * JAR output stream.
         *
         * @param in
         *            file to be uncompressed.
         * @param out
         *            JAR output stream of uncompressed data.
         * @throws IOException
         *             if I/O exception occurs.
         */
        void unpack(File in, JarOutputStream out) throws IOException;

        /**
         * add a listener for {@code PropertyChange} events.
         *
         * @param listener
         *            the listener to listen if {@code PropertyChange} events
         *            occurs.
         */
        void addPropertyChangeListener(PropertyChangeListener listener);

        /**
         * remove a listener.
         *
         * @param listener
         *            listener to remove.
         */
        void removePropertyChangeListener(PropertyChangeListener listener);
    }

}
