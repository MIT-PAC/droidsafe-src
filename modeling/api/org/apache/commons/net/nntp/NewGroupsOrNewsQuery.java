/*
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

/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package org.apache.commons.net.nntp;

import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.util.Calendar;

/***
 * The NewGroupsOrNewsQuery class.  This is used to issue NNTP NEWGROUPS and
 * NEWNEWS queries, implemented by
 * {@link org.apache.commons.net.nntp.NNTPClient#listNewNewsgroups listNewNewsGroups }
 *  and
 * {@link org.apache.commons.net.nntp.NNTPClient#listNewNews listNewNews }
 *  respectively.  It prevents you from having to format
 * date, time, distribution, and newgroup arguments.
 * <p>
 * You might use the class as follows:
 * <pre>
 * query = new NewsGroupsOrNewsQuery(new GregorianCalendar(97, 11, 15), false);
 * query.addDistribution("comp");
 * NewsgroupInfo[] newsgroups = client.listNewgroups(query);
 * </pre>
 * This will retrieve the list of newsgroups starting with the comp.
 * distribution prefix created since midnight 11/15/97.
 * <p>
 * <p>
 * @author Daniel F. Savarese
 * @see NNTPClient
 ***/

public final class NewGroupsOrNewsQuery
{
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.309 -0500", hash_original_field = "F9AB91E55C3152C3A49B60EACFF824BC", hash_generated_field = "D7040F1686DAAEC3EFF4DD54E86FFAD2")

    private String __date, __time;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.312 -0500", hash_original_field = "A5D9A0B8951510B9891ECA42F4811E45", hash_generated_field = "90F30887F64DE0ACA638229E8A4B2978")

    private StringBuffer __distributions;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.314 -0500", hash_original_field = "24B019AFCBD684347BB5EFB993958A6A", hash_generated_field = "2A8CDF4263C8B6B16CB9EB6A90291B60")

    private StringBuffer __newsgroups;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.317 -0500", hash_original_field = "FB5AB8C30188B07D302297FADFE4F047", hash_generated_field = "38089CC536F27EE30EF421063725BFE6")

    private boolean __isGMT;


    /***
     * Creates a new query using the given time as a reference point.
     * <p>
     * @param date  The date since which new groups or news have arrived.
     * @param gmt   True if the date should be considered as GMT, false if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.322 -0500", hash_original_method = "CC5F7FB4DC48CBC8ED3335B5D2CB27F3", hash_generated_method = "55452880AD3979DCEBCC15C80780241B")
    
public NewGroupsOrNewsQuery(Calendar date, boolean gmt)
    {
        int num;
        String str;
        StringBuffer buffer;

        __distributions = null;
        __newsgroups = null;
        __isGMT = gmt;

        buffer = new StringBuffer();

        // Get year
        num = date.get(Calendar.YEAR);
        str = Integer.toString(num);
        num = str.length();

        if (num >= 2)
            buffer.append(str.substring(num - 2));
        else
            buffer.append("00");

        // Get month
        num = date.get(Calendar.MONTH) + 1;
        str = Integer.toString(num);
        num = str.length();

        if (num == 1)
        {
            buffer.append('0');
            buffer.append(str);
        }
        else if (num == 2)
            buffer.append(str);
        else
            buffer.append("01");

        // Get day
        num = date.get(Calendar.DAY_OF_MONTH);
        str = Integer.toString(num);
        num = str.length();

        if (num == 1)
        {
            buffer.append('0');
            buffer.append(str);
        }
        else if (num == 2)
            buffer.append(str);
        else
            buffer.append("01");

        __date = buffer.toString();

        buffer.setLength(0);

        // Get hour
        num = date.get(Calendar.HOUR_OF_DAY);
        str = Integer.toString(num);
        num = str.length();

        if (num == 1)
        {
            buffer.append('0');
            buffer.append(str);
        }
        else if (num == 2)
            buffer.append(str);
        else
            buffer.append("00");

        // Get minutes
        num = date.get(Calendar.MINUTE);
        str = Integer.toString(num);
        num = str.length();

        if (num == 1)
        {
            buffer.append('0');
            buffer.append(str);
        }
        else if (num == 2)
            buffer.append(str);
        else
            buffer.append("00");


        // Get seconds
        num = date.get(Calendar.SECOND);
        str = Integer.toString(num);
        num = str.length();

        if (num == 1)
        {
            buffer.append('0');
            buffer.append(str);
        }
        else if (num == 2)
            buffer.append(str);
        else
            buffer.append("00");

        __time = buffer.toString();
    }


    /***
     * Add a newsgroup to the list of newsgroups being queried.  Newsgroups
     * added this way are only meaningful to the NEWNEWS command.  Newsgroup
     * names may include the <code> * </code> wildcard, as in
     * <code>comp.lang.* </code> or <code> comp.lang.java.* </code>.  Adding
     * at least one newsgroup is mandatory for the NEWNEWS command.
     * <p>
     * @param newsgroup  The newsgroup to add to the list of groups to be
     *                   checked for new news.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.325 -0500", hash_original_method = "D59B525355274204B82DF4FF44540199", hash_generated_method = "6173B1DB2E76F67DB3683D3E5D8DC8FE")
    
public void addNewsgroup(String newsgroup)
    {
        if (__newsgroups != null)
            __newsgroups.append(',');
        else
            __newsgroups = new StringBuffer();
        __newsgroups.append(newsgroup);
    }


    /***
     * Add a newsgroup to the list of newsgroups being queried, but indicate
     * that group should not be checked for new news.  Newsgroups
     * added this way are only meaningful to the NEWNEWS command.
     * Newsgroup names may include the <code> * </code> wildcard, as in
     * <code>comp.lang.* </code> or <code> comp.lang.java.* </code>.
     * <p>
     * The following would create a query that searched for new news in
     * all comp.lang.java newsgroups except for comp.lang.java.advocacy.
     * <pre>
     * query.addNewsgroup("comp.lang.java.*");
     * query.omitNewsgroup("comp.lang.java.advocacy");
     * </pre>
     * <p>
     * @param newsgroup  The newsgroup to add to the list of groups to be
     *                   checked for new news, but which should be omitted from
     *                   the search for new news..
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.328 -0500", hash_original_method = "92C4F166E70C624B99616146CD2891F2", hash_generated_method = "E87D29FAADF54EF31A60E51B38DD625D")
    
public void omitNewsgroup(String newsgroup)
    {
        addNewsgroup("!" + newsgroup);
    }


    /***
     * Add a distribution group to the query.  The distribution part of a
     * newsgroup is the segment of the name preceding the first dot (e.g.,
     * comp, alt, rec).  Only those newsgroups matching one of the
     * distributions or, in the case of NEWNEWS, an article in a newsgroup
     * matching one of the distributions, will be reported as a query result.
     * Adding distributions is purely optional.
     * <p>
     * @param distribution A distribution to add to the query.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.331 -0500", hash_original_method = "6E7CAC1BD9D34894D7DD6DF3025860CE", hash_generated_method = "8A91176A490D98661F6D58AC2D3125BA")
    
public void addDistribution(String distribution)
    {
        if (__distributions != null)
            __distributions.append(',');
        else
            __distributions = new StringBuffer();
        __distributions.append(distribution);
    }

    /***
     * Return the NNTP query formatted date (year, month, day in the form
     * YYMMDD.
     * <p>
     * @return The NNTP query formatted date.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.334 -0500", hash_original_method = "BCB6169262A773FDFD2993A6C5E4D314", hash_generated_method = "39E97F911943EE53EA7B0DC05DE1EF50")
    
public String getDate()
    {
        return __date;
    }

    /***
     * Return the NNTP query formatted time (hour, minutes, seconds in the form
     * HHMMSS.
     * <p>
     * @return The NNTP query formatted time.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.337 -0500", hash_original_method = "FA7276E4191EA0C5AF4E51606D03DF8A", hash_generated_method = "9DE51FB34F12851276F05E0C7E048672")
    
public String getTime()
    {
        return __time;
    }

    /***
     * Return whether or not the query date should be treated as GMT.
     * <p>
     * @return True if the query date is to be treated as GMT, false if not.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.340 -0500", hash_original_method = "EB96D9E246D4FDE5EEEAEC5ECFA9C261", hash_generated_method = "7C1050428167AAF5169AA19185F44CF4")
    
public boolean isGMT()
    {
        return __isGMT;
    }

    /***
     * Return the comma separated list of distributions.  This may be null
     * if there are no distributions.
     * <p>
     * @return The list of distributions, which may be null if no distributions
     *         have been specified.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.343 -0500", hash_original_method = "8F16FBEC6968212B23AA7F652099781D", hash_generated_method = "C5FBA51B1A781D47B49DB3D4D99EA848")
    
public String getDistributions()
    {
        return (__distributions == null ? null : __distributions.toString());
    }

    /***
     * Return the comma separated list of newsgroups.  This may be null
     * if there are no newsgroups
     * <p>
     * @return The list of newsgroups, which may be null if no newsgroups
     *         have been specified.
     ***/
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-02-25 10:38:10.346 -0500", hash_original_method = "811C2B1C8B3B6C78FA61E27DF52264C0", hash_generated_method = "76714C65881FB3431D896D452BDF5D0F")
    
public String getNewsgroups()
    {
        return (__newsgroups == null ? null : __newsgroups.toString());
    }
}
