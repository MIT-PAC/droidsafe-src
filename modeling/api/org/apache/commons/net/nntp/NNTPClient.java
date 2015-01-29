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

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.commons.net.io.DotTerminatedMessageReader;
import org.apache.commons.net.io.DotTerminatedMessageWriter;
import org.apache.commons.net.io.Util;
import org.apache.commons.net.MalformedServerReplyException;

/***
 * NNTPClient encapsulates all the functionality necessary to post and
 * retrieve articles from an NNTP server.  As with all classes derived
 * from {@link org.apache.commons.net.SocketClient},
 * you must first connect to the server with
 * {@link org.apache.commons.net.SocketClient#connect  connect }
 * before doing anything, and finally
 * {@link org.apache.commons.net.nntp.NNTP#disconnect  disconnect() }
 * after you're completely finished interacting with the server.
 * Remember that the
 * {@link org.apache.commons.net.nntp.NNTP#isAllowedToPost isAllowedToPost()}
 *  method is defined in
 * {@link org.apache.commons.net.nntp.NNTP}.
 * <p>
 * You should keep in mind that the NNTP server may choose to prematurely
 * close a connection if the client has been idle for longer than a
 * given time period or if the server is being shutdown by the operator or
 * some other reason.  The NNTP class will detect a
 * premature NNTP server connection closing when it receives a
 * {@link org.apache.commons.net.nntp.NNTPReply#SERVICE_DISCONTINUED NNTPReply.SERVICE_DISCONTINUED }
 *  response to a command.
 * When that occurs, the NNTP class method encountering that reply will throw
 * an {@link org.apache.commons.net.nntp.NNTPConnectionClosedException}
 * .
 * <code>NNTPConectionClosedException</code>
 * is a subclass of <code> IOException </code> and therefore need not be
 * caught separately, but if you are going to catch it separately, its
 * catch block must appear before the more general <code> IOException </code>
 * catch block.  When you encounter an
 * {@link org.apache.commons.net.nntp.NNTPConnectionClosedException}
 * , you must disconnect the connection with
 * {@link org.apache.commons.net.nntp.NNTP#disconnect  disconnect() }
 *  to properly clean up the
 * system resources used by NNTP.  Before disconnecting, you may check the
 * last reply code and text with
 * {@link org.apache.commons.net.nntp.NNTP#getReplyCode  getReplyCode } and
 * {@link org.apache.commons.net.nntp.NNTP#getReplyString  getReplyString }.
 * <p>
 * Rather than list it separately for each method, we mention here that
 * every method communicating with the server and throwing an IOException
 * can also throw a
 * {@link org.apache.commons.net.MalformedServerReplyException}
 * , which is a subclass
 * of IOException.  A MalformedServerReplyException will be thrown when
 * the reply received from the server deviates enough from the protocol
 * specification that it cannot be interpreted in a useful manner despite
 * attempts to be as lenient as possible.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @author Rory Winston
 * @author Ted Wise
 * @see NNTP
 * @see NNTPConnectionClosedException
 * @see org.apache.commons.net.MalformedServerReplyException
 ***/

public class NNTPClient extends NNTP
{

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.713 -0500", hash_original_method = "4D0F0A74AEF2BAAF2A8BC4B4837AE42C", hash_generated_method = "BE78172D14A51320AD77F9606FDB2F7B")
    
private void __parseArticlePointer(String reply, ArticlePointer pointer)
    throws MalformedServerReplyException
    {
        StringTokenizer tokenizer;

        // Do loop is a kluge to simulate goto
        do
        {
            tokenizer = new StringTokenizer(reply);

            if (tokenizer.countTokens() < 3)
                break;

            // Skip numeric response value
            tokenizer.nextToken();
            // Get article number
            try
            {
                pointer.articleNumber = Integer.parseInt(tokenizer.nextToken());
            }
            catch (NumberFormatException e)
            {
                break;
            }

            // Get article id
            pointer.articleId = tokenizer.nextToken();
            return ;
        }
        while (false);

        throw new MalformedServerReplyException(
            "Could not parse article pointer.\nServer reply: " + reply);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.718 -0500", hash_original_method = "7B918A9738DD1EA1D1F206444EDCC6A2", hash_generated_method = "D86A431889B7B35ADA4A0B3AD67AA4D4")
    
private void __parseGroupReply(String reply, NewsgroupInfo info)
    throws MalformedServerReplyException
    {
        String count, first, last;
        StringTokenizer tokenizer;

        // Do loop is a kluge to simulate goto
        do
        {
            tokenizer = new StringTokenizer(reply);

            if (tokenizer.countTokens() < 5)
                break;

            // Skip numeric response value
            tokenizer.nextToken();
            // Get estimated article count
            count = tokenizer.nextToken();
            // Get first article number
            first = tokenizer.nextToken();
            // Get last article number
            last = tokenizer.nextToken();
            // Get newsgroup name
            info._setNewsgroup(tokenizer.nextToken());

            try
            {
                info._setArticleCount(Integer.parseInt(count));
                info._setFirstArticle(Integer.parseInt(first));
                info._setLastArticle(Integer.parseInt(last));
            }
            catch (NumberFormatException e)
            {
                break;
            }

            info._setPostingPermission(NewsgroupInfo.UNKNOWN_POSTING_PERMISSION);
            return ;
        }
        while (false);

        throw new MalformedServerReplyException(
            "Could not parse newsgroup info.\nServer reply: " + reply);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.723 -0500", hash_original_method = "1505EFFCA6A06B72BD5475A484995B9D", hash_generated_method = "D821C1B7B11C1C761482BEBBDB0ACB87")
    
private NewsgroupInfo __parseNewsgroupListEntry(String entry)
    {
        NewsgroupInfo result;
        StringTokenizer tokenizer;
        int lastNum, firstNum;
        String last, first, permission;

        result = new NewsgroupInfo();
        tokenizer = new StringTokenizer(entry);

        if (tokenizer.countTokens() < 4)
            return null;

        result._setNewsgroup(tokenizer.nextToken());
        last = tokenizer.nextToken();
        first = tokenizer.nextToken();
        permission = tokenizer.nextToken();

        try
        {
            lastNum = Integer.parseInt(last);
            firstNum = Integer.parseInt(first);
            result._setFirstArticle(firstNum);
            result._setLastArticle(lastNum);

	    if((firstNum == 0) && (lastNum == 0))
		    result._setArticleCount(0);
	    else
		    result._setArticleCount(lastNum - firstNum + 1);
        }
        catch (NumberFormatException e)
        {
            return null;
        }

        switch (permission.charAt(0))
        {
        case 'y':
        case 'Y':
            result._setPostingPermission(
                NewsgroupInfo.PERMITTED_POSTING_PERMISSION);
            break;
        case 'n':
        case 'N':
            result._setPostingPermission(
                NewsgroupInfo.PROHIBITED_POSTING_PERMISSION);
            break;
        case 'm':
        case 'M':
            result._setPostingPermission(
                NewsgroupInfo.MODERATED_POSTING_PERMISSION);
            break;
        default:
            result._setPostingPermission(
                NewsgroupInfo.UNKNOWN_POSTING_PERMISSION);
            break;
        }

        return result;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.726 -0500", hash_original_method = "A1DA2307EDE8A8CDFF3B0D60B64F032C", hash_generated_method = "BEAD75092253BEC77CAC51D407A89C1D")
    
private NewsgroupInfo[] __readNewsgroupListing() throws IOException
    {
        int size;
        String line;
        Vector list;
        BufferedReader reader;
        NewsgroupInfo tmp, info[];

        reader = new BufferedReader(new DotTerminatedMessageReader(_reader_));
        // Start of with a big vector because we may be reading a very large
        // amount of groups.
        list = new Vector(2048);

        while ((line = reader.readLine()) != null)
        {
            tmp = __parseNewsgroupListEntry(line);
            if (tmp != null)
                list.addElement(tmp);
            else
                throw new MalformedServerReplyException(line);
        }

        if ((size = list.size()) < 1)
            return new NewsgroupInfo[0];

        info = new NewsgroupInfo[size];
        list.copyInto(info);

        return info;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.731 -0500", hash_original_method = "F29668DE5B158BF603FB225CEBC8FFA5", hash_generated_method = "DC0642352BB84F31B619C62BD3E6D067")
    
private Reader __retrieve(int command,
                              String articleId, ArticlePointer pointer)
    throws IOException
    {
        Reader reader;

        if (articleId != null)
        {
            if (!NNTPReply.isPositiveCompletion(sendCommand(command, articleId)))
                return null;
        }
        else
        {
            if (!NNTPReply.isPositiveCompletion(sendCommand(command)))
                return null;
        }


        if (pointer != null)
            __parseArticlePointer(getReplyString(), pointer);

        reader = new DotTerminatedMessageReader(_reader_);
        return reader;
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.734 -0500", hash_original_method = "9051DB5626792880346BEA19D9DB7187", hash_generated_method = "A13D29F036013D736C70C8CDF6939040")
    
private Reader __retrieve(int command,
                              int articleNumber, ArticlePointer pointer)
    throws IOException
    {
        Reader reader;

        if (!NNTPReply.isPositiveCompletion(sendCommand(command,
                                            Integer.toString(articleNumber))))
            return null;

        if (pointer != null)
            __parseArticlePointer(getReplyString(), pointer);

        reader = new DotTerminatedMessageReader(_reader_);
        return reader;
    }



    /***
     * Retrieves an article from the NNTP server.  The article is referenced
     * by its unique article identifier (including the enclosing &lt and &gt).
     * The article number and identifier contained in the server reply
     * are returned through an ArticlePointer.  The <code> articleId </code>
     * field of the ArticlePointer cannot always be trusted because some
     * NNTP servers do not correctly follow the RFC 977 reply format.
     * <p>
     * A DotTerminatedMessageReader is returned from which the article can
     * be read.  If the article does not exist, null is returned.
     * <p>
     * You must not issue any commands to the NNTP server (i.e., call any
     * other methods) until you finish reading the message from the returned
     * Reader instance.
     * The NNTP protocol uses the same stream for issuing commands as it does
     * for returning results.  Therefore the returned Reader actually reads
     * directly from the NNTP connection.  After the end of message has been
     * reached, new commands can be executed and their replies read.  If
     * you do not follow these requirements, your program will not work
     * properly.
     * <p>
     * @param articleId  The unique article identifier of the article to
     *     retrieve.  If this parameter is null, the currently selected
     *     article is retrieved.
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  The articleId field cannot always be trusted
     *   because of server deviations from RFC 977 reply formats.  You may
     *   set this parameter to null if you do not desire to retrieve the
     *   returned article information.
     * @return A DotTerminatedMessageReader instance from which the article
     *         be read.  null if the article does not exist.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.738 -0500", hash_original_method = "5CB9E6037B66ED3BBABE76506745A953", hash_generated_method = "7CF64B31DF0C0EACE880634D44CE7E8D")
    
public Reader retrieveArticle(String articleId, ArticlePointer pointer)
    throws IOException
    {
        return __retrieve(NNTPCommand.ARTICLE, articleId, pointer);

    }

    /*** Same as <code> retrieveArticle(articleId, null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.741 -0500", hash_original_method = "9926DEDCE0AD57538A98733BEC1EBC43", hash_generated_method = "C6FE64D8EC648CFC28775D65084A39F7")
    
public Reader retrieveArticle(String articleId) throws IOException
    {
        return retrieveArticle(articleId, null);
    }

    /*** Same as <code> retrieveArticle(null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.744 -0500", hash_original_method = "2ABCB1D0790925DD46BDC5BB8C03FD73", hash_generated_method = "1A95363C7BC3159ED8353369C2AEC0BA")
    
public Reader retrieveArticle() throws IOException
    {
        return retrieveArticle(null);
    }


    /***
     * Retrieves an article from the currently selected newsgroup.  The
     * article is referenced by its article number.
     * The article number and identifier contained in the server reply
     * are returned through an ArticlePointer.  The <code> articleId </code>
     * field of the ArticlePointer cannot always be trusted because some
     * NNTP servers do not correctly follow the RFC 977 reply format.
     * <p>
     * A DotTerminatedMessageReader is returned from which the article can
     * be read.  If the article does not exist, null is returned.
     * <p>
     * You must not issue any commands to the NNTP server (i.e., call any
     * other methods) until you finish reading the message from the returned
     * Reader instance.
     * The NNTP protocol uses the same stream for issuing commands as it does
     * for returning results.  Therefore the returned Reader actually reads
     * directly from the NNTP connection.  After the end of message has been
     * reached, new commands can be executed and their replies read.  If
     * you do not follow these requirements, your program will not work
     * properly.
     * <p>
     * @param articleNumber  The number of the the article to
     *     retrieve.
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  The articleId field cannot always be trusted
     *   because of server deviations from RFC 977 reply formats.  You may
     *   set this parameter to null if you do not desire to retrieve the
     *   returned article information.
     * @return A DotTerminatedMessageReader instance from which the article
     *         be read.  null if the article does not exist.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.747 -0500", hash_original_method = "1D8A1B8D2424014178FB911DECFC4B1D", hash_generated_method = "FB20D702C5CC71C8A8DAF162E013244A")
    
public Reader retrieveArticle(int articleNumber, ArticlePointer pointer)
    throws IOException
    {
        return __retrieve(NNTPCommand.ARTICLE, articleNumber, pointer);
    }

    /*** Same as <code> retrieveArticle(articleNumber, null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.751 -0500", hash_original_method = "A4C37C4D0CE3F53721DEA2441C8D1CE8", hash_generated_method = "51BD2B03D0021F2CF31A90897EA75645")
    
public Reader retrieveArticle(int articleNumber) throws IOException
    {
        return retrieveArticle(articleNumber, null);
    }



    /***
     * Retrieves an article header from the NNTP server.  The article is
     * referenced
     * by its unique article identifier (including the enclosing &lt and &gt).
     * The article number and identifier contained in the server reply
     * are returned through an ArticlePointer.  The <code> articleId </code>
     * field of the ArticlePointer cannot always be trusted because some
     * NNTP servers do not correctly follow the RFC 977 reply format.
     * <p>
     * A DotTerminatedMessageReader is returned from which the article can
     * be read.  If the article does not exist, null is returned.
     * <p>
     * You must not issue any commands to the NNTP server (i.e., call any
     * other methods) until you finish reading the message from the returned
     * Reader instance.
     * The NNTP protocol uses the same stream for issuing commands as it does
     * for returning results.  Therefore the returned Reader actually reads
     * directly from the NNTP connection.  After the end of message has been
     * reached, new commands can be executed and their replies read.  If
     * you do not follow these requirements, your program will not work
     * properly.
     * <p>
     * @param articleId  The unique article identifier of the article whose
     *    header is being retrieved.  If this parameter is null, the
     *    header of the currently selected article is retrieved.
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  The articleId field cannot always be trusted
     *   because of server deviations from RFC 977 reply formats.  You may
     *   set this parameter to null if you do not desire to retrieve the
     *   returned article information.
     * @return A DotTerminatedMessageReader instance from which the article
     *         header can be read.  null if the article does not exist.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.754 -0500", hash_original_method = "B0C72949A49C04FF8BBAFFAE803FD2AC", hash_generated_method = "84E13B01C3042696D2CD3A6E8D951A96")
    
public Reader retrieveArticleHeader(String articleId, ArticlePointer pointer)
    throws IOException
    {
        return __retrieve(NNTPCommand.HEAD, articleId, pointer);

    }

    /*** Same as <code> retrieveArticleHeader(articleId, null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.758 -0500", hash_original_method = "FAC876C37AFEF4F78CD743FFA4604104", hash_generated_method = "BD2EA33AFE401E1B9E6A8F89B30E473D")
    
public Reader retrieveArticleHeader(String articleId) throws IOException
    {
        return retrieveArticleHeader(articleId, null);
    }

    /*** Same as <code> retrieveArticleHeader(null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.761 -0500", hash_original_method = "FBABDEBA24E2FAF25491977C12B27187", hash_generated_method = "72803833DB15AD29B531821D4FB85D33")
    
public Reader retrieveArticleHeader() throws IOException
    {
        return retrieveArticleHeader(null);
    }


    /***
     * Retrieves an article header from the currently selected newsgroup.  The
     * article is referenced by its article number.
     * The article number and identifier contained in the server reply
     * are returned through an ArticlePointer.  The <code> articleId </code>
     * field of the ArticlePointer cannot always be trusted because some
     * NNTP servers do not correctly follow the RFC 977 reply format.
     * <p>
     * A DotTerminatedMessageReader is returned from which the article can
     * be read.  If the article does not exist, null is returned.
     * <p>
     * You must not issue any commands to the NNTP server (i.e., call any
     * other methods) until you finish reading the message from the returned
     * Reader instance.
     * The NNTP protocol uses the same stream for issuing commands as it does
     * for returning results.  Therefore the returned Reader actually reads
     * directly from the NNTP connection.  After the end of message has been
     * reached, new commands can be executed and their replies read.  If
     * you do not follow these requirements, your program will not work
     * properly.
     * <p>
     * @param articleNumber  The number of the the article whose header is
     *     being retrieved.
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  The articleId field cannot always be trusted
     *   because of server deviations from RFC 977 reply formats.  You may
     *   set this parameter to null if you do not desire to retrieve the
     *   returned article information.
     * @return A DotTerminatedMessageReader instance from which the article
     *         header can be read.  null if the article does not exist.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.765 -0500", hash_original_method = "F192CCDB118CC85A380791B707646EA3", hash_generated_method = "79537E25D67E0A797AAC9342E8D07C7C")
    
public Reader retrieveArticleHeader(int articleNumber,
                                        ArticlePointer pointer)
    throws IOException
    {
        return __retrieve(NNTPCommand.HEAD, articleNumber, pointer);
    }


    /*** Same as <code> retrieveArticleHeader(articleNumber, null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.769 -0500", hash_original_method = "33B2EE0D613829F3E6CC4153F4B973DF", hash_generated_method = "0DD6982524DC9E51BEE039C819E1E1B3")
    
public Reader retrieveArticleHeader(int articleNumber) throws IOException
    {
        return retrieveArticleHeader(articleNumber, null);
    }



    /***
     * Retrieves an article body from the NNTP server.  The article is
     * referenced
     * by its unique article identifier (including the enclosing &lt and &gt).
     * The article number and identifier contained in the server reply
     * are returned through an ArticlePointer.  The <code> articleId </code>
     * field of the ArticlePointer cannot always be trusted because some
     * NNTP servers do not correctly follow the RFC 977 reply format.
     * <p>
     * A DotTerminatedMessageReader is returned from which the article can
     * be read.  If the article does not exist, null is returned.
     * <p>
     * You must not issue any commands to the NNTP server (i.e., call any
     * other methods) until you finish reading the message from the returned
     * Reader instance.
     * The NNTP protocol uses the same stream for issuing commands as it does
     * for returning results.  Therefore the returned Reader actually reads
     * directly from the NNTP connection.  After the end of message has been
     * reached, new commands can be executed and their replies read.  If
     * you do not follow these requirements, your program will not work
     * properly.
     * <p>
     * @param articleId  The unique article identifier of the article whose
     *    body is being retrieved.  If this parameter is null, the
     *    body of the currently selected article is retrieved.
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  The articleId field cannot always be trusted
     *   because of server deviations from RFC 977 reply formats.  You may
     *   set this parameter to null if you do not desire to retrieve the
     *   returned article information.
     * @return A DotTerminatedMessageReader instance from which the article
     *         body can be read.  null if the article does not exist.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.772 -0500", hash_original_method = "D0F10B1E844DBE54E1C95079D90DDAB9", hash_generated_method = "D470C4BE1EF8CCE32AD669400786EA9D")
    
public Reader retrieveArticleBody(String articleId, ArticlePointer pointer)
    throws IOException
    {
        return __retrieve(NNTPCommand.BODY, articleId, pointer);

    }

    /*** Same as <code> retrieveArticleBody(articleId, null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.775 -0500", hash_original_method = "46806E59674A3999FECD68BC3A52D44D", hash_generated_method = "47A995612DEAB59037431FA6ED023A14")
    
public Reader retrieveArticleBody(String articleId) throws IOException
    {
        return retrieveArticleBody(articleId, null);
    }

    /*** Same as <code> retrieveArticleBody(null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.778 -0500", hash_original_method = "52B6F67F184184B52BA8234FFCA8CD43", hash_generated_method = "066E43B791FD8B9336586C488192B1BD")
    
public Reader retrieveArticleBody() throws IOException
    {
        return retrieveArticleBody(null);
    }


    /***
     * Retrieves an article body from the currently selected newsgroup.  The
     * article is referenced by its article number.
     * The article number and identifier contained in the server reply
     * are returned through an ArticlePointer.  The <code> articleId </code>
     * field of the ArticlePointer cannot always be trusted because some
     * NNTP servers do not correctly follow the RFC 977 reply format.
     * <p>
     * A DotTerminatedMessageReader is returned from which the article can
     * be read.  If the article does not exist, null is returned.
     * <p>
     * You must not issue any commands to the NNTP server (i.e., call any
     * other methods) until you finish reading the message from the returned
     * Reader instance.
     * The NNTP protocol uses the same stream for issuing commands as it does
     * for returning results.  Therefore the returned Reader actually reads
     * directly from the NNTP connection.  After the end of message has been
     * reached, new commands can be executed and their replies read.  If
     * you do not follow these requirements, your program will not work
     * properly.
     * <p>
     * @param articleNumber  The number of the the article whose body is
     *     being retrieved.
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  The articleId field cannot always be trusted
     *   because of server deviations from RFC 977 reply formats.  You may
     *   set this parameter to null if you do not desire to retrieve the
     *   returned article information.
     * @return A DotTerminatedMessageReader instance from which the article
     *         body can be read.  null if the article does not exist.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.782 -0500", hash_original_method = "34F4A4372E44ECCE36EFF0A68D9EEA82", hash_generated_method = "06A169190BAFFBFF1D43CAB047683A35")
    
public Reader retrieveArticleBody(int articleNumber,
                                      ArticlePointer pointer)
    throws IOException
    {
        return __retrieve(NNTPCommand.BODY, articleNumber, pointer);
    }


    /*** Same as <code> retrieveArticleBody(articleNumber, null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.786 -0500", hash_original_method = "FBE545DCDF92873EF64141364622B9CC", hash_generated_method = "8C27469AE71D33265549A0640CA93689")
    
public Reader retrieveArticleBody(int articleNumber) throws IOException
    {
        return retrieveArticleBody(articleNumber, null);
    }


    /***
     * Select the specified newsgroup to be the target of for future article
     * retrieval and posting operations.  Also return the newsgroup
     * information contained in the server reply through the info parameter.
     * <p>
     * @param newsgroup  The newsgroup to select.
     * @param info  A parameter through which the newsgroup information of
     *      the selected newsgroup contained in the server reply is returned.
     *      Set this to null if you do not desire this information.
     * @return True if the newsgroup exists and was selected, false otherwise.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.789 -0500", hash_original_method = "BC1E149DEA4318AACD21177389BEB192", hash_generated_method = "CF86A7FDA40E49DE5A97A206A4212FEB")
    
public boolean selectNewsgroup(String newsgroup, NewsgroupInfo info)
    throws IOException
    {
        if (!NNTPReply.isPositiveCompletion(group(newsgroup)))
            return false;

        if (info != null)
            __parseGroupReply(getReplyString(), info);

        return true;
    }

    /*** Same as <code> selectNewsgroup(newsgroup, null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.792 -0500", hash_original_method = "A0EFCC43C4A80383B3AEC9C232E1412A", hash_generated_method = "0C7A3CFF7F0F4ED318D18A0330551AD4")
    
public boolean selectNewsgroup(String newsgroup) throws IOException
    {
        return selectNewsgroup(newsgroup, null);
    }

    /***
     * List the command help from the server.
     * <p>
     * @return The sever help information.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.796 -0500", hash_original_method = "94D120157B0912550580C1CAC9F20DA0", hash_generated_method = "BB3A53AFD57574A4D4A63B3DE6E61CDE")
    
public String listHelp() throws IOException
    {
        StringWriter help;
        Reader reader;

        if (!NNTPReply.isInformational(help()))
            return null;

        help = new StringWriter();
        reader = new DotTerminatedMessageReader(_reader_);
        Util.copyReader(reader, help);
        reader.close();
        help.close();
        return help.toString();
    }


    /***
     * Select an article by its unique identifier (including enclosing
     * &lt and &gt) and return its article number and id through the
     * pointer parameter.  This is achieved through the STAT command.
     * According to RFC 977, this will NOT set the current article pointer
     * on the server.  To do that, you must reference the article by its
     * number.
     * <p>
     * @param articleId  The unique article identifier of the article that
     *    is being selectedd.  If this parameter is null, the
     *    body of the current article is selected
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  The articleId field cannot always be trusted
     *   because of server deviations from RFC 977 reply formats.  You may
     *   set this parameter to null if you do not desire to retrieve the
     *   returned article information.
     * @return True if successful, false if not.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.799 -0500", hash_original_method = "DDA50D17BBCB2332C76722E4627B13B3", hash_generated_method = "1C73B35A968B10680E838B758C2CCD45")
    
public boolean selectArticle(String articleId, ArticlePointer pointer)
    throws IOException
    {
        if (articleId != null)
        {
            if (!NNTPReply.isPositiveCompletion(stat(articleId)))
                return false;
        }
        else
        {
            if (!NNTPReply.isPositiveCompletion(stat()))
                return false;
        }

        if (pointer != null)
            __parseArticlePointer(getReplyString(), pointer);

        return true;
    }

    /**** Same as <code> selectArticle(articleId, null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.803 -0500", hash_original_method = "8D41BAE77B1D2757C2C572E8ECB76782", hash_generated_method = "2546F8BD279B1E33E4D844073D43ED11")
    
public boolean selectArticle(String articleId) throws IOException
    {
        return selectArticle(articleId, null);
    }

    /****
     * Same as <code> selectArticle(null, articleId) </code>.  Useful
     * for retrieving the current article number.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.807 -0500", hash_original_method = "5E5E1971677BE94A53109D4D5BC08EE3", hash_generated_method = "605D7749020D76CEAE070E02604B491C")
    
public boolean selectArticle(ArticlePointer pointer) throws IOException
    {
        return selectArticle(null, pointer);
    }


    /***
     * Select an article in the currently selected newsgroup by its number.
     * and return its article number and id through the
     * pointer parameter.  This is achieved through the STAT command.
     * According to RFC 977, this WILL set the current article pointer
     * on the server.  Use this command to select an article before retrieving
     * it, or to obtain an article's unique identifier given its number.
     * <p>
     * @param articleNumber The number of the article to select from the
     *       currently selected newsgroup.
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  Although the articleId field cannot always
     *   be trusted because of server deviations from RFC 977 reply formats,
     *   we haven't found a server that misformats this information in response
     *   to this particular command.  You may set this parameter to null if
     *   you do not desire to retrieve the returned article information.
     * @return True if successful, false if not.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.810 -0500", hash_original_method = "FB20EF55F35D3226A9AFDA2331141C8C", hash_generated_method = "39EDA9F6C146B141AAA6BF5C48BD6E7A")
    
public boolean selectArticle(int articleNumber, ArticlePointer pointer)
    throws IOException
    {
        if (!NNTPReply.isPositiveCompletion(stat(articleNumber)))
            return false;

        if (pointer != null)
            __parseArticlePointer(getReplyString(), pointer);

        return true;
    }


    /*** Same as <code> selectArticle(articleNumber, null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.814 -0500", hash_original_method = "7C42892213EAED0FE3F4CD66EF8B0266", hash_generated_method = "18035E0C6E66CCE1B7A4D9DA9BCEB77C")
    
public boolean selectArticle(int articleNumber) throws IOException
    {
        return selectArticle(articleNumber, null);
    }


    /***
     * Select the article preceeding the currently selected article in the
     * currently selected newsgroup and return its number and unique id
     * through the pointer parameter.  Because of deviating server
     * implementations, the articleId information cannot be trusted.  To
     * obtain the article identifier, issue a
     * <code> selectArticle(pointer.articleNumber, pointer) </code> immediately
     * afterward.
     * <p>
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  The articleId field cannot always be trusted
     *   because of server deviations from RFC 977 reply formats.  You may
     *   set this parameter to null if you do not desire to retrieve the
     *   returned article information.
     * @return True if successful, false if not (e.g., there is no previous
     *     article).
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.817 -0500", hash_original_method = "AE5755A8BB0D3254AAC992CD2FDD3EF1", hash_generated_method = "FBFE82AEDC329B60ECFDFFBAE6E4971B")
    
public boolean selectPreviousArticle(ArticlePointer pointer)
    throws IOException
    {
        if (!NNTPReply.isPositiveCompletion(last()))
            return false;

        if (pointer != null)
            __parseArticlePointer(getReplyString(), pointer);

        return true;
    }

    /*** Same as <code> selectPreviousArticle(null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.820 -0500", hash_original_method = "0B604ECD72825E7302A598A21F9391D8", hash_generated_method = "AF51DBFFF03D639AD0E24EC2D4F6F2D4")
    
public boolean selectPreviousArticle() throws IOException
    {
        return selectPreviousArticle(null);
    }


    /***
     * Select the article following the currently selected article in the
     * currently selected newsgroup and return its number and unique id
     * through the pointer parameter.  Because of deviating server
     * implementations, the articleId information cannot be trusted.  To
     * obtain the article identifier, issue a
     * <code> selectArticle(pointer.articleNumber, pointer) </code> immediately
     * afterward.
     * <p>
     * @param pointer    A parameter through which to return the article's
     *   number and unique id.  The articleId field cannot always be trusted
     *   because of server deviations from RFC 977 reply formats.  You may
     *   set this parameter to null if you do not desire to retrieve the
     *   returned article information.
     * @return True if successful, false if not (e.g., there is no following
     *         article).
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.823 -0500", hash_original_method = "62ECA1A77D23337015138C43AC039257", hash_generated_method = "0E9F76BDA6A2C5FDCC7BF68E2DDF98DC")
    
public boolean selectNextArticle(ArticlePointer pointer) throws IOException
    {
        if (!NNTPReply.isPositiveCompletion(next()))
            return false;

        if (pointer != null)
            __parseArticlePointer(getReplyString(), pointer);

        return true;
    }


    /*** Same as <code> selectNextArticle(null) </code> ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.826 -0500", hash_original_method = "F67C85082F69BDA511360EC02B0C3E98", hash_generated_method = "A02A009C4F33FFC78A7CF1888F57183E")
    
public boolean selectNextArticle() throws IOException
    {
        return selectNextArticle(null);
    }


    /***
     * List all newsgroups served by the NNTP server.  If no newsgroups
     * are served, a zero length array will be returned.  If the command
     * fails, null will be returned.
     * <p>
     * @return An array of NewsgroupInfo instances containing the information
     *    for each newsgroup served by the NNTP server.   If no newsgroups
     *    are served, a zero length array will be returned.  If the command
     *    fails, null will be returned.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.830 -0500", hash_original_method = "5731BA9CD64E4E7BEF9BBCA44F05227A", hash_generated_method = "B70511FEEEC415EBAA2F6405B63918CF")
    
public NewsgroupInfo[] listNewsgroups() throws IOException
    {
        if (!NNTPReply.isPositiveCompletion(list()))
            return null;

        return __readNewsgroupListing();
    }

    /**
     * An overloaded listNewsgroups() command that allows us to
     * specify with a pattern what groups we want to list. Wraps the
     * LIST ACTIVE command.
     * <p>
     * @param wildmat a pseudo-regex pattern (cf. RFC 2980)
     * @return An array of NewsgroupInfo instances containing the information
     *    for each newsgroup served by the NNTP server corresponding to the
     *    supplied pattern.   If no such newsgroups are served, a zero length
     *    array will be returned.  If the command fails, null will be returned.
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.834 -0500", hash_original_method = "F28B5BF4E03C8DBEAAFF8385872990FD", hash_generated_method = "A6B150B9E5EBD7E685808E03558379BE")
    
public NewsgroupInfo[] listNewsgroups(String wildmat) throws IOException
    {
        if(!NNTPReply.isPositiveCompletion(listActive(wildmat)))
            return null;
        return __readNewsgroupListing();
    }


    /***
     * List all new newsgroups added to the NNTP server since a particular
     * date subject to the conditions of the specified query.  If no new
     * newsgroups were added, a zero length array will be returned.  If the
     * command fails, null will be returned.
     * <p>
     * @param query  The query restricting how to search for new newsgroups.
     * @return An array of NewsgroupInfo instances containing the information
     *    for each new newsgroup added to the NNTP server.   If no newsgroups
     *    were added, a zero length array will be returned.  If the command
     *    fails, null will be returned.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.837 -0500", hash_original_method = "6768CBB27E7172AA2C7826D88AD4CDFA", hash_generated_method = "1A7EA78CAC96ECE4855438EF4C52664A")
    
public NewsgroupInfo[] listNewNewsgroups(NewGroupsOrNewsQuery query)
    throws IOException
    {
        if (!NNTPReply.isPositiveCompletion(newgroups(
                                                query.getDate(), query.getTime(),
                                                query.isGMT(), query.getDistributions())))
            return null;

        return __readNewsgroupListing();
    }


    /***
     * List all new articles added to the NNTP server since a particular
     * date subject to the conditions of the specified query.  If no new
     * new news is found, a zero length array will be returned.  If the
     * command fails, null will be returned.  You must add at least one
     * newsgroup to the query, else the command will fail.  Each String
     * in the returned array is a unique message identifier including the
     * enclosing &lt and &gt.
     * <p>
     * @param query  The query restricting how to search for new news.  You
     *    must add at least one newsgroup to the query.
     * @return An array of String instances containing the unique message
     *    identifiers for each new article added to the NNTP server.  If no
     *    new news is found, a zero length array will be returned.  If the
     *    command fails, null will be returned.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.841 -0500", hash_original_method = "CEA799A3A5D71AC4A4B6E1D8871A32D5", hash_generated_method = "44B04DEDFA13B69A131EA52296DBC6D0")
    
public String[] listNewNews(NewGroupsOrNewsQuery query)
    throws IOException
    {
        int size;
        String line;
        Vector list;
        String[] result;
        BufferedReader reader;

        if (!NNTPReply.isPositiveCompletion(newnews(
                                                query.getNewsgroups(), query.getDate(), query.getTime(),
                                                query.isGMT(), query.getDistributions())))
            return null;

        list = new Vector();
        reader = new BufferedReader(new DotTerminatedMessageReader(_reader_));

        while ((line = reader.readLine()) != null)
            list.addElement(line);

        size = list.size();

        if (size < 1)
            return new String[0];

        result = new String[size];
        list.copyInto(result);

        return result;
    }

    /***
     * There are a few NNTPClient methods that do not complete the
     * entire sequence of NNTP commands to complete a transaction.  These
     * commands require some action by the programmer after the reception
     * of a positive preliminary command.  After the programmer's code
     * completes its actions, it must call this method to receive
     * the completion reply from the server and verify the success of the
     * entire transaction.
     * <p>
     * For example
     * <pre>
     * writer = client.postArticle();
     * if(writer == null) // failure
     *   return false;
     * header = new SimpleNNTPHeader("foobar@foo.com", "Just testing");
     * header.addNewsgroup("alt.test");
     * writer.write(header.toString());
     * writer.write("This is just a test");
     * writer.close();
     * if(!client.completePendingCommand()) // failure
     *   return false;
     * </pre>
     * <p>
     * @return True if successfully completed, false if not.
     * @exception NNTPConnectionClosedException
     *      If the NNTP server prematurely closes the connection as a result
     *      of the client being idle or some other reason causing the server
     *      to send NNTP reply code 400.  This exception may be caught either
     *      as an IOException or independently as itself.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.844 -0500", hash_original_method = "1EC153F6A3B13AC418211B89C9B1FD3E", hash_generated_method = "14790151CAAACE56A5A6E26A925AEAD2")
    
public boolean completePendingCommand() throws IOException
    {
        return NNTPReply.isPositiveCompletion(getReply());
    }

    /***
     * Post an article to the NNTP server.  This method returns a
     * DotTerminatedMessageWriter instance to which the article can be
     * written.  Null is returned if the posting attempt fails.  You
     * should check {@link NNTP#isAllowedToPost isAllowedToPost() }
     *  before trying to post.  However, a posting
     * attempt can fail due to malformed headers.
     * <p>
     * You must not issue any commands to the NNTP server (i.e., call any
     * (other methods) until you finish writing to the returned Writer
     * instance and close it.  The NNTP protocol uses the same stream for
     * issuing commands as it does for returning results.  Therefore the
     * returned Writer actually writes directly to the NNTP connection.
     * After you close the writer, you can execute new commands.  If you
     * do not follow these requirements your program will not work properly.
     * <p>
     * Different NNTP servers will require different header formats, but
     * you can use the provided
     * {@link org.apache.commons.net.nntp.SimpleNNTPHeader}
     * class to construct the bare minimum acceptable header for most
     * news readers.  To construct more complicated headers you should
     * refer to RFC 822.  When the Java Mail API is finalized, you will be
     * able to use it to compose fully compliant Internet text messages.
     * The DotTerminatedMessageWriter takes care of doubling line-leading
     * dots and ending the message with a single dot upon closing, so all
     * you have to worry about is writing the header and the message.
     * <p>
     * Upon closing the returned Writer, you need to call
     * {@link #completePendingCommand  completePendingCommand() }
     * to finalize the posting and verify its success or failure from
     * the server reply.
     * <p>
     * @return A DotTerminatedMessageWriter to which the article (including
     *      header) can be written.  Returns null if the command fails.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.847 -0500", hash_original_method = "5E6790B4EC341687B72EBB3DC0F33765", hash_generated_method = "216D49235606315FC0FD6D0FD7AFA8C7")
    
public Writer postArticle() throws IOException
    {
        if (!NNTPReply.isPositiveIntermediate(post()))
            return null;

        return new DotTerminatedMessageWriter(_writer_);
    }


    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.851 -0500", hash_original_method = "57FBC7C84C2F8B58E83C012277ABE19F", hash_generated_method = "077E6506A363826F629D8932FCE60AC0")
    
public Writer forwardArticle(String articleId) throws IOException
    {
        if (!NNTPReply.isPositiveIntermediate(ihave(articleId)))
            return null;

        return new DotTerminatedMessageWriter(_writer_);
    }


    /***
     * Logs out of the news server gracefully by sending the QUIT command.
     * However, you must still disconnect from the server before you can open
     * a new connection.
     * <p>
     * @return True if successfully completed, false if not.
     * @exception IOException  If an I/O error occurs while either sending a
     *      command to the server or receiving a reply from the server.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.854 -0500", hash_original_method = "5DE5F2E6648159BA44979C01CBE407AE", hash_generated_method = "06A231199A8AAF9997FDC9D5141CEB18")
    
public boolean logout() throws IOException
    {
        return NNTPReply.isPositiveCompletion(quit());
    }


    /**
     * Log into a news server by sending the AUTHINFO USER/AUTHINFO
     * PASS command sequence. This is usually sent in response to a
     * 480 reply code from the NNTP server.
     * <p>
     * @param username a valid username
     * @param password the corresponding password
     * @return True for successful login, false for a failure
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.858 -0500", hash_original_method = "EDB190C8321DBF8F29E66BCB92691482", hash_generated_method = "E56E2E15D6CCD7BD6EC3738F6E50A17C")
    
public boolean authenticate(String username, String password)
        throws IOException
    {
        int replyCode = authinfoUser(username);

        if (replyCode == NNTPReply.MORE_AUTH_INFO_REQUIRED)
            {
                replyCode = authinfoPass(password);

                if (replyCode == NNTPReply.AUTHENTICATION_ACCEPTED)
                    {
                        _isAllowedToPost = true;
                        return true;
                    }
            }
        return false;
    }

    /***
     * Private implementation of XOVER functionality.
     *
     * See {@link NNTP#xover}
     * for legal agument formats. Alternatively, read RFC 2980 :-)
     * <p>
     * @param articleRange
     * @return Returns a DotTerminatedMessageReader if successful, null
     *         otherwise
     * @exception IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.861 -0500", hash_original_method = "F872673B3CB758169F9DC843B258CF5B", hash_generated_method = "45091A3F7BB98DA50E507330BF84C3E0")
    
private Reader __retrieveArticleInfo(String articleRange)
        throws IOException
    {
        if (!NNTPReply.isPositiveCompletion(xover(articleRange)))
            return null;

        return new DotTerminatedMessageReader(_reader_);
    }

    /**
     * Return article headers for a specified post.
     * <p>
     * @param articleNumber the article to retrieve headers for
     * @return a DotTerminatedReader if successful, null otherwise
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.864 -0500", hash_original_method = "2DE6D59516911FC4734AA5A206FF4E78", hash_generated_method = "91146851C3B6D8130793C4946EE03C6E")
    
public Reader retrieveArticleInfo(int articleNumber) throws IOException
    {
        return __retrieveArticleInfo(Integer.toString(articleNumber));
    }

    /**
     * Return article headers for all articles between lowArticleNumber
     * and highArticleNumber, inclusively.
     * <p>
     * @param lowArticleNumber
     * @param highArticleNumber
     * @return a DotTerminatedReader if successful, null otherwise
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.867 -0500", hash_original_method = "26B374DF35690169D780ED0303365B37", hash_generated_method = "C1310D0C442D41E97C20864B12FEEBBE")
    
public Reader retrieveArticleInfo(int lowArticleNumber,
                                      int highArticleNumber)
        throws IOException
    {
        return
            __retrieveArticleInfo(new String(lowArticleNumber + "-" +
                                             highArticleNumber));
    }

    /***
     * Private implementation of XHDR functionality.
     *
     * See {@link NNTP#xhdr}
     * for legal agument formats. Alternatively, read RFC 1036.
     * <p>
     * @param header
     * @param articleRange
     * @return Returns a DotTerminatedMessageReader if successful, null
     *         otherwise
     * @exception IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.870 -0500", hash_original_method = "596F4722B5E69EC9F61696E9C9DD37AE", hash_generated_method = "6F39064009FAF133D9221D2E10E16ED2")
    
private Reader __retrieveHeader(String header, String articleRange)
        throws IOException
    {
        if (!NNTPReply.isPositiveCompletion(xhdr(header, articleRange)))
            return null;

        return new DotTerminatedMessageReader(_reader_);
    }

    /**
     * Return an article header for a specified post.
     * <p>
     * @param header the header to retrieve
     * @param articleNumber the article to retrieve the header for
     * @return a DotTerminatedReader if successful, null otherwise
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.874 -0500", hash_original_method = "8D2FFBDF3C47E1B46E6758446155167E", hash_generated_method = "D935931994EB884B3A0814B2E72A19B2")
    
public Reader retrieveHeader(String header, int articleNumber)
        throws IOException
    {
        return __retrieveHeader(header, Integer.toString(articleNumber));
    }

    /**
     * Return an article header for all articles between lowArticleNumber
     * and highArticleNumber, inclusively.
     * <p>
     * @param header
     * @param lowArticleNumber
     * @param highArticleNumber
     * @return a DotTerminatedReader if successful, null otherwise
     * @throws IOException
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:06.878 -0500", hash_original_method = "42A30DA5805C25DC1FF8BB76E1D4A883", hash_generated_method = "B0E719B437F0CB56217298A3A09102B7")
    
public Reader retrieveHeader(String header, int lowArticleNumber,
                                 int highArticleNumber)
        throws IOException
    {
        return
            __retrieveHeader(header,
                             new String(lowArticleNumber + "-" +
                                        highArticleNumber));
    }
}


/* Emacs configuration
 * Local variables:        **
 * mode:             java  **
 * c-basic-offset:   4     **
 * indent-tabs-mode: nil   **
 * End:                    **
 */
