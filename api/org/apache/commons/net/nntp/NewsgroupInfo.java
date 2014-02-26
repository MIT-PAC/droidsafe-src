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
 * NewsgroupInfo stores information pertaining to a newsgroup returned by
 * the NNTP GROUP, LIST, and NEWGROUPS commands, implemented by
 * {@link org.apache.commons.net.nntp.NNTPClient#selectNewsgroup selectNewsgroup }
 * ,
 * {@link org.apache.commons.net.nntp.NNTPClient#listNewsgroups listNewsgroups }
 * , and
 * {@link org.apache.commons.net.nntp.NNTPClient#listNewNewsgroups listNewNewsgroups }
 *  respectively.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see NNTPClient
 ***/

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class NewsgroupInfo
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.845 -0500", hash_original_field = "387C15DE0CB8A4AFD24CC3A2AE6663A8", hash_generated_field = "D68BB53F8F4F8FB390B52E6CA00C48EB")

    public static final int UNKNOWN_POSTING_PERMISSION = 0;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.848 -0500", hash_original_field = "CBF2392AEEB6933B80DFFF120D49B641", hash_generated_field = "95CE06E528BD235B9C23BF77F1146069")

    public static final int MODERATED_POSTING_PERMISSION = 1;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.851 -0500", hash_original_field = "E53BB3A0AF6CA953649F6E5694CABC83", hash_generated_field = "7B6DF602496066305D38F0E46CE29B7F")

    public static final int PERMITTED_POSTING_PERMISSION = 2;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.855 -0500", hash_original_field = "0378AB4330C5F5B84F7F6E5E9FF1EB66", hash_generated_field = "54ABB6EADFFB08078E0DA77D389F4CEA")

    public static final int PROHIBITED_POSTING_PERMISSION = 3;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.858 -0500", hash_original_field = "954103CE35D4766AB4DF3602BDA38C60", hash_generated_field = "107894FB880B61AD0B2F3E4B71955CBA")


    private String __newsgroup;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.860 -0500", hash_original_field = "15DA5495CE5776C28812E640963C234B", hash_generated_field = "50EC406D5B586863FF4D34EE154CF682")

    private int __estimatedArticleCount;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.863 -0500", hash_original_field = "B686DD2EE2F8FB4BDEDEE422EC3596A4", hash_generated_field = "CC8FDB7887E7E2DEC0126F89705FA979")

    private int __firstArticle, __lastArticle;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.866 -0500", hash_original_field = "158B3C92F1CB36A7A7C8103EEDE1F98A", hash_generated_field = "24A0C0BAFA54CD72D88B334CA84A5503")

    private int __postingPermission;

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.868 -0500", hash_original_method = "EAFBF3739344812639C54061F5E19DCE", hash_generated_method = "EAFBF3739344812639C54061F5E19DCE")
    
void _setNewsgroup(String newsgroup)
    {
        __newsgroup = newsgroup;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.871 -0500", hash_original_method = "38E8B4BB98F8C4812F427D0B0E09A0B6", hash_generated_method = "38E8B4BB98F8C4812F427D0B0E09A0B6")
    
void _setArticleCount(int count)
    {
        __estimatedArticleCount = count;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.873 -0500", hash_original_method = "118A174D7F2E8FC48210DF48D1C54CC0", hash_generated_method = "118A174D7F2E8FC48210DF48D1C54CC0")
    
void _setFirstArticle(int first)
    {
        __firstArticle = first;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.877 -0500", hash_original_method = "1BCAF0FDB3913C1DA7129C46D5DF3361", hash_generated_method = "1BCAF0FDB3913C1DA7129C46D5DF3361")
    
void _setLastArticle(int last)
    {
        __lastArticle = last;
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.880 -0500", hash_original_method = "FA8B99E1188E0D4F77B493C8205126CE", hash_generated_method = "FA8B99E1188E0D4F77B493C8205126CE")
    
void _setPostingPermission(int permission)
    {
        __postingPermission = permission;
    }

    /***
     * Get the newsgroup name.
     * <p>
     * @return The name of the newsgroup.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.884 -0500", hash_original_method = "9E2CE54BF1FAF9132AB977C2B84796C5", hash_generated_method = "620B61492E3EA18E08C8C4FFD30D358D")
    
public String getNewsgroup()
    {
        return __newsgroup;
    }

    /***
     * Get the estimated number of articles in the newsgroup.  The
     * accuracy of this value will depend on the server implementation.
     * <p>
     * @return The estimated number of articles in the newsgroup.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.887 -0500", hash_original_method = "A51D70E750E12530BA7E718E6376FFD1", hash_generated_method = "3EA28BEA213D3AA9095D2FBEEEC208E6")
    
public int getArticleCount()
    {
        return __estimatedArticleCount;
    }

    /***
     * Get the number of the first article in the newsgroup.
     * <p>
     * @return The number of the first article in the newsgroup.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.889 -0500", hash_original_method = "F249B52F70BFB9F5AD1BF9CA6C95C85F", hash_generated_method = "0CBA2CCAFC4B7012159E8EB9B8CEC08E")
    
public int getFirstArticle()
    {
        return __firstArticle;
    }

    /***
     * Get the number of the last article in the newsgroup.
     * <p>
     * @return The number of the last article in the newsgroup.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.893 -0500", hash_original_method = "DAA97CE3ED69AC620776BC122566C2D6", hash_generated_method = "C9A55A0EF879D06C3602E93793409285")
    
public int getLastArticle()
    {
        return __lastArticle;
    }

    /***
     * Get the posting permission of the newsgroup.  This will be one of
     * the <code> POSTING_PERMISSION </code> constants.
     * <p>
     * @return The posting permission status of the newsgroup.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.895 -0500", hash_original_method = "78A9AE5F3639BE45129FE4FB1CDD52F2", hash_generated_method = "1ACD8F4D123954D33FA1A6A8BE583D03")
    
public int getPostingPermission()
    {
        return __postingPermission;
    }

    /*
    public String toString() {
      StringBuffer buffer = new StringBuffer();
      buffer.append(__newsgroup);
      buffer.append(' ');
      buffer.append(__lastArticle);
      buffer.append(' ');
      buffer.append(__firstArticle);
      buffer.append(' ');
      switch(__postingPermission) {
        case 1: buffer.append('m'); break;
        case 2: buffer.append('y'); break;
        case 3: buffer.append('n'); break;
      }
      return buffer.toString();
}
    */
}
