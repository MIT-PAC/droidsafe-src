/*
 * Copyright 2001-2005 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.net.nntp;

/***
 * This class is used to construct the bare minimum
 * acceptable header for most news readers.  To construct more
 * complicated headers you should refer to RFC 822.  When the
 * Java Mail API is finalized, you will be
 * able to use it to compose fully compliant Internet text messages.
 * <p>
 * The main purpose of the class is to faciliatate the article posting
 * process, by relieving the programmer from having to explicitly format
 * an article header.  For example:
 * <pre>
 * writer = client.postArticle();
 * if(writer == null) // failure
 *   return false;
 * header = new SimpleNNTPHeader("foobar@foo.com", "Just testing");
 * header.addNewsgroup("alt.test");
 * header.addHeaderField("Organization", "Foobar, Inc.");
 * writer.write(header.toString());
 * writer.write("This is just a test");
 * writer.close();
 * if(!client.completePendingCommand()) // failure
 *   return false;
 * </pre>
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see NNTPClient
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public class SimpleNNTPHeader
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.690 -0500", hash_original_field = "A607F6B9F649834D68AD762F6914B4ED", hash_generated_field = "EB66108FB14C8D56EB9029155B9417EE")

    private String __subject, __from;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.693 -0500", hash_original_field = "24B019AFCBD684347BB5EFB993958A6A", hash_generated_field = "2A8CDF4263C8B6B16CB9EB6A90291B60")

    private StringBuffer __newsgroups;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.696 -0500", hash_original_field = "3F69ED8A33EDCB3A114DC4CD57A3505A", hash_generated_field = "C4061A9142D60CFCDC1A275C24B3F0B4")

    private StringBuffer __headerFields;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.699 -0500", hash_original_field = "7531F7E4078F9D073E194DF790CB278B", hash_generated_field = "87E6ED1365BE634212DEFBB9CEB036C4")

    private int __newsgroupCount;

    /***
     * Creates a new SimpleNNTPHeader instance initialized with the given
     * from and subject header field values.
     * <p>
     * @param from  The value of the <code>From:</code> header field.  This
     *              should be the article poster's email address.
     * @param subject  The value of the <code>Subject:</code> header field.
     *              This should be the subject of the article.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.702 -0500", hash_original_method = "993E59EE437D78A2EC4A4EFD6428AB11", hash_generated_method = "A12DAF5E99E7B6026D85046BB227E106")
    
public SimpleNNTPHeader(String from, String subject)
    {
        __from = from;
        __subject = subject;
        __newsgroups = new StringBuffer();
        __headerFields = new StringBuffer();
        __newsgroupCount = 0;
    }

    /***
     * Adds a newsgroup to the article <code>Newsgroups:</code> field.
     * <p>
     * @param newsgroup  The newsgroup to add to the article's newsgroup
     *                   distribution list.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.707 -0500", hash_original_method = "7078CFBD339BE392BC3DC074EBD75CC7", hash_generated_method = "6D5CE8F064820FA605D14D95AEFC54DD")
    
public void addNewsgroup(String newsgroup)
    {
        if (__newsgroupCount++ > 0)
            __newsgroups.append(',');
        __newsgroups.append(newsgroup);
    }

    /***
     * Adds an arbitrary header field with the given value to the article
     * header.  These headers will be written after the From, Newsgroups,
     * and Subject fields when the SimpleNNTPHeader is convertered to a string.
     * An example use would be:
     * <pre>
     * header.addHeaderField("Organization", "Foobar, Inc.");
     * </pre>
     * <p>
     * @param headerField  The header field to add, not including the colon.
     * @param value  The value of the added header field.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.710 -0500", hash_original_method = "5FCF67AB7FDBB19E75F1395E1E296333", hash_generated_method = "089221D91A9BEA064E10692D44044A1F")
    
public void addHeaderField(String headerField, String value)
    {
        __headerFields.append(headerField);
        __headerFields.append(": ");
        __headerFields.append(value);
        __headerFields.append('\n');
    }

    /***
     * Returns the address used in the <code> From: </code> header field.
     * <p>
     * @return The from address.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.713 -0500", hash_original_method = "49AD9BEB69F232A819EB83D15E77A79E", hash_generated_method = "8EDCBB8E137BC24D1E43B04CF470CFC9")
    
public String getFromAddress()
    {
        return __from;
    }

    /***
     * Returns the subject used in the <code> Subject: </code> header field.
     * <p>
     * @return The subject.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.717 -0500", hash_original_method = "D484BB5883B85B4D6A6AE1B8E6B0F9E6", hash_generated_method = "6BD26F565CD74EF3A2EB24E76BF2B8B0")
    
public String getSubject()
    {
        return __subject;
    }

    /***
     * Returns the contents of the <code> Newsgroups: </code> header field.
     * <p>
     * @return The comma-separated list of newsgroups to which the article
     *         is being posted.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.719 -0500", hash_original_method = "9B7F1B1CED05DC3E7387A426428F6230", hash_generated_method = "564F811F762894A3A5D1B77917D70589")
    
public String getNewsgroups()
    {
        return __newsgroups.toString();
    }

    /***
     * Converts the SimpleNNTPHeader to a properly formatted header in
     * the form of a String, including the blank line used to separate
     * the header from the article body.
     * <p>
     * @return The article header in the form of a String.
     ***/
    @DSSource({DSSourceKind.NETWORK})
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.723 -0500", hash_original_method = "8EB7107FA2367D701AF7CBC234A81F19", hash_generated_method = "B23ED7B4CA5FBA5E6343C71EA6EDB1E4")
    
public String toString()
    {
        StringBuffer header = new StringBuffer();

        header.append("From: ");
        header.append(__from);
        header.append("\nNewsgroups: ");
        header.append(__newsgroups.toString());
        header.append("\nSubject: ");
        header.append(__subject);
        header.append('\n');
        if (__headerFields.length() > 0)
            header.append(__headerFields.toString());
        header.append('\n');

        return header.toString();
    }
}
