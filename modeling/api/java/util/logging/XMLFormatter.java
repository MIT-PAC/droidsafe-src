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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.text.MessageFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Formatter to convert a {@link LogRecord} into an XML string. The DTD
 * specified in Appendix A to the Java Logging APIs specification is used.
 * {@code XMLFormatter} uses the output handler's encoding if it is specified,
 * otherwise the default platform encoding is used instead. UTF-8 is the
 * recommended encoding.
 */
public class XMLFormatter extends Formatter {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.357 -0400", hash_original_field = "9E85645BAF00159EDADCB5E80F6A475D", hash_generated_field = "9FEA415FC9DE7E036EF434A1C1543B9D")


    private static final String indent = "    ";

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.360 -0400", hash_original_method = "84C835DA9949D8BBC71EF239CFBB9A87", hash_generated_method = "FE57E623D4826E346B295FE0592CCE79")
    
private static void append(StringBuilder sb, int indentCount, String tag, Object value) {
        for (int i = 0; i < indentCount; ++i) {
            sb.append(indent);
        }
        sb.append("<").append(tag).append(">");
        sb.append(value);
        sb.append("</").append(tag).append(">");
        sb.append(System.lineSeparator());
    }

    /**
     * Constructs a new {@code XMLFormatter}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.357 -0400", hash_original_method = "5B7E73F97E9A36641837E50077BA979E", hash_generated_method = "4E68EE780ED46E06A49B453158231D4E")
    
public XMLFormatter() {
    }

    /**
     * Converts a {@code LogRecord} into an XML string.
     *
     * @param r
     *            the log record to be formatted.
     * @return the log record formatted as an XML string.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.358 -0400", hash_original_method = "39FC6F23D6511A6D8782CE54BF4D3082", hash_generated_method = "D596207BD99B4C8EB08CC21D75F9F8C5")
    
@Override
    public String format(LogRecord r) {
        // call a method of LogRecord to ensure not null
        long time = r.getMillis();
        // format to date
        String date = MessageFormat.format("{0, date} {0, time}", new Object[] { new Date(time) });
        String nl = System.lineSeparator();

        StringBuilder sb = new StringBuilder();
        sb.append("<record>").append(nl);
        append(sb, 1, "date", date);
        append(sb, 1, "millis", time);
        append(sb, 1, "sequence", r.getSequenceNumber());
        if (r.getLoggerName() != null) {
            append(sb, 1, "logger", r.getLoggerName());
        }
        append(sb, 1, "level", r.getLevel().getName());
        if (r.getSourceClassName() != null) {
            append(sb, 1, "class", r.getSourceClassName());
        }
        if (r.getSourceMethodName() != null) {
            append(sb, 1, "method", r.getSourceMethodName());
        }
        append(sb, 1, "thread", r.getThreadID());
        formatMessages(r, sb);
        Object[] params = r.getParameters();
        if (params != null) {
            for (Object element : params) {
                append(sb, 1, "param", element);
            }
        }
        formatThrowable(r, sb);
        sb.append("</record>").append(nl);
        return sb.toString();
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.359 -0400", hash_original_method = "98F4175D3B7DC7C9D574A94F00A4058D", hash_generated_method = "98DC8DC6EF6980033D740A7BF725F4EF")
    
private void formatMessages(LogRecord r, StringBuilder sb) {
        // get localized message if has, but don't call Formatter.formatMessage
        // to parse pattern string
        ResourceBundle rb = r.getResourceBundle();
        String pattern = r.getMessage();
        if (rb != null && pattern != null) {
            String message;
            try {
                message = rb.getString(pattern);
            } catch (Exception e) {
                message = null;
            }

            if (message == null) {
                message = pattern;
                append(sb, 1, "message", message);
            } else {
                append(sb, 1, "message", message);
                append(sb, 1, "key", pattern);
                append(sb, 1, "catalog", r.getResourceBundleName());
            }
        } else if (pattern != null) {
            append(sb, 1, "message", pattern);
        } else {
            sb.append(indent).append("<message/>");
        }
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.360 -0400", hash_original_method = "52688AEA59A5FBBCDD654A6752C831B7", hash_generated_method = "EEDCBD0A766C0EC2EB3DCEF56C0F8327")
    
private void formatThrowable(LogRecord r, StringBuilder sb) {
        Throwable t;
        if ((t = r.getThrown()) != null) {
            String nl = System.lineSeparator();
            sb.append(indent).append("<exception>").append(nl);
            append(sb, 2, "message", t.toString());
            // format throwable's stack trace
            StackTraceElement[] elements = t.getStackTrace();
            for (StackTraceElement e : elements) {
                sb.append(indent).append(indent).append("<frame>").append(nl);
                append(sb, 3, "class", e.getClassName());
                append(sb, 3, "method", e.getMethodName());
                append(sb, 3, "line", e.getLineNumber());
                sb.append(indent).append(indent).append("</frame>").append(nl);
            }
            sb.append(indent).append("</exception>").append(nl);
        }
    }

    /**
     * Returns the header string for a set of log records formatted as XML
     * strings, using the output handler's encoding if it is defined, otherwise
     * using the default platform encoding.
     *
     * @param h
     *            the output handler, may be {@code null}.
     * @return the header string for log records formatted as XML strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.361 -0400", hash_original_method = "CE82BE6717E0FF5184F162F72F4C6BC2", hash_generated_method = "7C98BC39A6315692192753A8313326E0")
    
@Override
    public String getHead(Handler h) {
        String encoding = null;
        if (h != null) {
            encoding = h.getEncoding();
        }
        if (encoding == null) {
            encoding = System.getProperty("file.encoding");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"").append(encoding).append("\" standalone=\"no\"?>");
        sb.append(System.lineSeparator());
        sb.append("<!DOCTYPE log SYSTEM \"logger.dtd\">");
        sb.append(System.lineSeparator());
        sb.append("<log>");
        return sb.toString();
    }

    /**
     * Returns the tail string for a set of log records formatted as XML
     * strings.
     *
     * @param h
     *            the output handler, may be {@code null}.
     * @return the tail string for log records formatted as XML strings.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 15:01:08.361 -0400", hash_original_method = "49701FD0F944CF1591F64CF03495EA6A", hash_generated_method = "F83FCDF2338FBBF66B23133534E4BFC1")
    
@Override
    public String getTail(Handler h) {
        return "</log>";
    }
}
