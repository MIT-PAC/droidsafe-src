/*
 * Copyright 2001-2004 The Apache Software Foundation.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */ 


package org.apache.commons.logging.impl;


import droidsafe.annotations.*;
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import java.io.Serializable;
import org.apache.commons.logging.Log;


/**
 * <p>Trivial implementation of Log that throws away all messages.  No
 * configurable system properties are supported.</p>
 *
 * @author <a href="mailto:sanders@apache.org">Scott Sanders</a>
 * @author Rod Waldhoff
 * @version $Id: NoOpLog.java 155426 2005-02-26 13:10:49Z dirkv $
 */
public class NoOpLog implements Log, Serializable {

    /** Convenience constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.716 -0400", hash_original_method = "9B66D6F9B744B1FAFCA93B2BC6825F47", hash_generated_method = "CB6E2B473AE4CE574D64DE3670EB881D")
    
public NoOpLog() { }
    /** Base constructor */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.717 -0400", hash_original_method = "96BF647C82DFEAF4CB93D4922D5D81F5", hash_generated_method = "E1E4C04D24D0C2EF6E7070D8EAD64D75")
    
public NoOpLog(String name) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.717 -0400", hash_original_method = "818E0B883DC58DC995B22E0761F71440", hash_generated_method = "5852B7F78978A6F35354CA318266DEE1")
    
public void trace(Object message) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.718 -0400", hash_original_method = "307DABE77B65556975D712DF7F2D3DF0", hash_generated_method = "BC48B88DF10CE450AA1C6373806B3AF8")
    
public void trace(Object message, Throwable t) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.718 -0400", hash_original_method = "03D0FDA651EE7341EA30E6AEE8095C69", hash_generated_method = "642AA1525A0152FEA4F6CCADF27D64F1")
    
public void debug(Object message) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.719 -0400", hash_original_method = "437F187B645F284244F5B74E41AA5BBA", hash_generated_method = "5E244C14A54206C531475348A66A59FB")
    
public void debug(Object message, Throwable t) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.719 -0400", hash_original_method = "6CA7D23F1FBD47EE0D87B2C3D2BAE183", hash_generated_method = "784D9D3317A42F405422A8F6DBB23875")
    
public void info(Object message) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.719 -0400", hash_original_method = "AD89F091290D19303ADA48600DF6A2FC", hash_generated_method = "451594E5762109D8B39106231F5CEB3F")
    
public void info(Object message, Throwable t) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.720 -0400", hash_original_method = "7F8CAB6D20F7AC107E4A95701A6FE6CB", hash_generated_method = "0578DE253C812004FB2864653CC2386E")
    
public void warn(Object message) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.720 -0400", hash_original_method = "4E278DFE620C1E8D5124E68175AB8DE2", hash_generated_method = "3C61176C0544A2396B026C452133CFF6")
    
public void warn(Object message, Throwable t) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.721 -0400", hash_original_method = "B08580BE26568ABAA59E21E644AD634F", hash_generated_method = "708E83190D467DC7D258871144946F0E")
    
public void error(Object message) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.721 -0400", hash_original_method = "0AF56B72B76C0484915AB9E07E067DAB", hash_generated_method = "EDC6FA6AC807C838C86EF2098F93DF3F")
    
public void error(Object message, Throwable t) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.722 -0400", hash_original_method = "5DFB5D6899D7E24F024F31AED4C1F9EE", hash_generated_method = "B67B4C52312DC41272A94E5EAE90D577")
    
public void fatal(Object message) { }
    /** Do nothing */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.722 -0400", hash_original_method = "CF250A137F40D9381257D232C0971E16", hash_generated_method = "600017799DF7EF285FD0AAC0E01978D7")
    
public void fatal(Object message, Throwable t) { }

    /**
     * Debug is never enabled.
     *
     * @return false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.723 -0400", hash_original_method = "114418523011366118D69E47C15578FD", hash_generated_method = "DAF770A53152C7940EC0816CFE314FCA")
    
public final boolean isDebugEnabled() { return false; }

    /**
     * Error is never enabled.
     *
     * @return false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.723 -0400", hash_original_method = "F3A65193C6854CE5E8578754D48CBE4D", hash_generated_method = "098D454E7770DCD432F546BC1B0DCED0")
    
public final boolean isErrorEnabled() { return false; }

    /**
     * Fatal is never enabled.
     *
     * @return false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.723 -0400", hash_original_method = "8CB077407585A81E631AD914041484F1", hash_generated_method = "E68592A1BBA4C27603E7B7070DD53088")
    
public final boolean isFatalEnabled() { return false; }

    /**
     * Info is never enabled.
     *
     * @return false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.724 -0400", hash_original_method = "930B33BA178409D40E0CB2B262DB0E77", hash_generated_method = "BD735D0399A1C938B31B1EFA6E0E42BD")
    
public final boolean isInfoEnabled() { return false; }

    /**
     * Trace is never enabled.
     *
     * @return false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.724 -0400", hash_original_method = "EE7B6AEF92F692D4A87236D2AC2DCE66", hash_generated_method = "445E4E5DC875A6B05A93A51D5ABD46F3")
    
public final boolean isTraceEnabled() { return false; }

    /**
     * Warn is never enabled.
     *
     * @return false
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2014-09-03 14:59:47.725 -0400", hash_original_method = "AD6098A49801FEDA58A88E610AA25434", hash_generated_method = "5588E1900A4BAB6A048BAAA410A85A13")
    
public final boolean isWarnEnabled() { return false; }

}
