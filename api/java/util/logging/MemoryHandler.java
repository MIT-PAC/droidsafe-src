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

package java.util.logging;

/**
 * A {@code Handler} put the description of log events into a cycled memory
 * buffer.
 * <p>
 * Mostly this {@code MemoryHandler} just puts the given {@code LogRecord} into
 * the internal buffer and doesn't perform any formatting or any other process.
 * When the buffer is full, the earliest buffered records will be discarded.
 * <p>
 * Every {@code MemoryHandler} has a target handler, and push action can be
 * triggered so that all buffered records will be output to the target handler
 * and normally the latter will publish the records. After the push action, the
 * buffer will be cleared.
 * <p>
 * The push method can be called directly, but will also be called automatically
 * if a new <code>LogRecord</code> is added that has a level greater than or
 * equal to than the value defined for the property
 * java.util.logging.MemoryHandler.push.
 * <p>
 * {@code MemoryHandler} will read following {@code LogManager} properties for
 * initialization, if given properties are not defined or has invalid values,
 * default value will be used.
 * <ul>
 * <li>java.util.logging.MemoryHandler.filter specifies the {@code Filter}
 * class name, defaults to no {@code Filter}.</li>
 * <li>java.util.logging.MemoryHandler.level specifies the level for this
 * {@code Handler}, defaults to {@code Level.ALL}.</li>
 * <li>java.util.logging.MemoryHandler.push specifies the push level, defaults
 * to level.SEVERE.</li>
 * <li>java.util.logging.MemoryHandler.size specifies the buffer size in number
 * of {@code LogRecord}, defaults to 1000.</li>
 * <li>java.util.logging.MemoryHandler.target specifies the class of the target
 * {@code Handler}, no default value, which means this property must be
 * specified either by property setting or by constructor.</li>
 * </ul>
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class MemoryHandler extends Handler {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.405 -0400", hash_original_field = "856EDFF82F66DFC95AA6EB1A5424C75E", hash_generated_field = "100764EDFE533F11F2DC9973B4E2806C")

    private static final int DEFAULT_SIZE = 1000;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.405 -0400", hash_original_field = "6747FE4EAD68C59D650E1B0351577C58", hash_generated_field = "D9BE4D6027D046588E61209CCBD035B7")

    private Handler target;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.406 -0400", hash_original_field = "D294CD0DD93AF1C19E28F967D8A04BEF", hash_generated_field = "1B47BB3BA826F5F7101D823C92BCDAA5")

    private int size = DEFAULT_SIZE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.406 -0400", hash_original_field = "DDEF684173476E720BF1C00C3E3CDBBE", hash_generated_field = "0F163BD471C8767957ECDEDF9AA76A54")

    private Level push = Level.SEVERE;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.407 -0400", hash_original_field = "74A3274E5CAD6FDE123DAC973B60BB84", hash_generated_field = "9605BC98227B13A5DDCFDE869377D3B4")

    private final LogManager manager = LogManager.getLogManager();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.407 -0400", hash_original_field = "70F201D9950342FCAA2BADCB98B86518", hash_generated_field = "63DF00216C46A66328B1E85F967B0B41")

    private LogRecord[] buffer;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.407 -0400", hash_original_field = "574451AF3BDD0EC887A8F04530DC95F1", hash_generated_field = "51399A9A7B5D946D408F3A55F870AD46")

    private int cursor;

    /**
     * Default constructor, construct and init a {@code MemoryHandler} using
     * {@code LogManager} properties or default values.
     *
     * @throws RuntimeException
     *             if property value are invalid and no default value could be
     *             used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.408 -0400", hash_original_method = "B043A14D8A32B57190A280B41BE6EAC3", hash_generated_method = "C068200C47426EAA214867E0C6B8E1EB")
    
public MemoryHandler() {
        String className = this.getClass().getName();
        // init target
        final String targetName = manager.getProperty(className + ".target");
        try {
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            if (loader == null) {
                loader = ClassLoader.getSystemClassLoader();
            }
            Class<?> targetClass = loader.loadClass(targetName);
            target = (Handler) targetClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Cannot load target handler '" + targetName + "'");
        }
        // init size
        String sizeString = manager.getProperty(className + ".size");
        if (sizeString != null) {
            try {
                size = Integer.parseInt(sizeString);
                if (size <= 0) {
                    size = DEFAULT_SIZE;
                }
            } catch (Exception e) {
                printInvalidPropMessage(className + ".size", sizeString, e);
            }
        }
        // init push level
        String pushName = manager.getProperty(className + ".push");
        if (pushName != null) {
            try {
                push = Level.parse(pushName);
            } catch (Exception e) {
                printInvalidPropMessage(className + ".push", pushName, e);
            }
        }
        // init other properties which are common for all Handler
        initProperties("ALL", null, "java.util.logging.SimpleFormatter", null);
        buffer = new LogRecord[size];
    }

    /**
     * Construct and init a {@code MemoryHandler} using given target, size and
     * push level, other properties using {@code LogManager} properties or
     * default values.
     *
     * @param target
     *            the given {@code Handler} to output
     * @param size
     *            the maximum number of buffered {@code LogRecord}, greater than
     *            zero
     * @param pushLevel
     *            the push level
     * @throws IllegalArgumentException
     *             if {@code size <= 0}
     * @throws RuntimeException
     *             if property value are invalid and no default value could be
     *             used.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.409 -0400", hash_original_method = "820F601F979B51666029A62CB5946BCC", hash_generated_method = "CF6B6A9899E4F5DA7BC58D68652DDB1F")
    
public MemoryHandler(Handler target, int size, Level pushLevel) {
        if (size <= 0) {
            throw new IllegalArgumentException("size <= 0");
        }
        target.getLevel();
        pushLevel.intValue();
        this.target = target;
        this.size = size;
        this.push = pushLevel;
        initProperties("ALL", null, "java.util.logging.SimpleFormatter", null);
        buffer = new LogRecord[size];
    }

    /**
     * Close this handler and target handler, free all associated resources.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.409 -0400", hash_original_method = "E2DD18B436EC71C9A2470341512E64D6", hash_generated_method = "D58DD999E921170D7193CA72702E3C8A")
    
@Override
    public void close() {
        manager.checkAccess();
        target.close();
        setLevel(Level.OFF);
    }

    /**
     * Call target handler to flush any buffered output. Note that this doesn't
     * cause this {@code MemoryHandler} to push.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.409 -0400", hash_original_method = "2F6F0CC8821791B75D80457EE953082B", hash_generated_method = "7A3E6A027925417643149F6F66BE7587")
    
@Override
    public void flush() {
        target.flush();
    }

    /**
     * Put a given {@code LogRecord} into internal buffer. If given record is
     * not loggable, just return. Otherwise it is stored in the buffer.
     * Furthermore if the record's level is not less than the push level, the
     * push action is triggered to output all the buffered records to the target
     * handler, and the target handler will publish them.
     *
     * @param record
     *            the log record
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.410 -0400", hash_original_method = "1106E97D9CE5AF0EFE8BC26483FB0C89", hash_generated_method = "41E8A46BD01DB1AC5759EEEDA5DD7C1E")
    
@Override public synchronized void publish(LogRecord record) {
        if (!isLoggable(record)) {
            return;
        }
        if (cursor >= size) {
            cursor = 0;
        }
        buffer[cursor++] = record;
        if (record.getLevel().intValue() >= push.intValue()) {
            push();
        }
    }

    /**
     * Return the push level.
     *
     * @return the push level
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.410 -0400", hash_original_method = "2326FB4BAF45BFA37E595D947EF4551E", hash_generated_method = "566D967F342C49470321B8379A97EF64")
    
public Level getPushLevel() {
        return push;
    }

    /**
     * Check if given {@code LogRecord} would be put into this
     * {@code MemoryHandler}'s internal buffer.
     * <p>
     * The given {@code LogRecord} is loggable if and only if it has appropriate
     * level and it pass any associated filter's check.
     * <p>
     * Note that the push level is not used for this check.
     *
     * @param record
     *            the given {@code LogRecord}
     * @return the given {@code LogRecord} if it should be logged, {@code false}
     *         if {@code LogRecord} is {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.411 -0400", hash_original_method = "2F5769E8DB571DB2C42926159DC7FC7C", hash_generated_method = "FC26624D20179BD2C1B8146B6A0D4438")
    
@Override
    public boolean isLoggable(LogRecord record) {
        return super.isLoggable(record);
    }

    /**
     * Triggers a push action to output all buffered records to the target handler,
     * and the target handler will publish them. Then the buffer is cleared.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.411 -0400", hash_original_method = "81F38009176C270674E529671B18DCFB", hash_generated_method = "D0BBF492D648E618C4FC0DEC9B6E17A1")
    
public void push() {
        for (int i = cursor; i < size; i++) {
            if (buffer[i] != null) {
                target.publish(buffer[i]);
            }
            buffer[i] = null;
        }
        for (int i = 0; i < cursor; i++) {
            if (buffer[i] != null) {
                target.publish(buffer[i]);
            }
            buffer[i] = null;
        }
        cursor = 0;
    }

    /**
     * Set the push level. The push level is used to check the push action
     * triggering. When a new {@code LogRecord} is put into the internal
     * buffer and its level is not less than the push level, the push action
     * will be triggered. Note that set new push level won't trigger push action.
     *
     * @param newLevel
     *                 the new level to set.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.412 -0400", hash_original_method = "6111AF8FA2CD9ADED0E226717004BB9D", hash_generated_method = "A6B7178BFC34B24A62C149E5B9E8B42C")
    
public void setPushLevel(Level newLevel) {
        manager.checkAccess();
        newLevel.intValue();
        this.push = newLevel;
    }
}
