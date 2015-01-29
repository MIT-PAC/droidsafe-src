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

/**
 * This class is a structure used to return article number and unique
 * id information extracted from an NNTP server reply.  You will normally
 * want this information when issuing a STAT command, implemented by
 * {@link NNTPClient#selectArticle selectArticle}.
 * @author Daniel F. Savarese
 * @see NNTPClient
 */
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
public final class ArticlePointer
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.804 -0500", hash_original_field = "AD73D511D8C0DDDC6A5FC70A12252EE6", hash_generated_field = "BC4DFD87E5E5C19F44368501CF440B69")

    public int articleNumber;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.806 -0500", hash_original_field = "5BEF1F2E0B8C500D11739D073D3AF413", hash_generated_field = "332AC04AE0F84D581D84FEB4F31F5677")

    public String articleId;
}
