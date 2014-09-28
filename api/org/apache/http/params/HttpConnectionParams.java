package org.apache.http.params;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;

public final class HttpConnectionParams implements CoreConnectionPNames {

    /**
     * Returns the default socket timeout (<tt>SO_TIMEOUT</tt>) in milliseconds which is the 
     * timeout for waiting for data. A timeout value of zero is interpreted as an infinite 
     * timeout. This value is used when no socket timeout is set in the 
     * method parameters. 
     *
     * @return timeout in milliseconds
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.661 -0500", hash_original_method = "05BCF4E96AB58D17B392E6E260A9049E", hash_generated_method = "686FD23A2525281745ED9ED4B8C375C5")
    
public static int getSoTimeout(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0);
    }

    /**
     * Sets the default socket timeout (<tt>SO_TIMEOUT</tt>) in milliseconds which is the 
     * timeout for waiting for data. A timeout value of zero is interpreted as an infinite 
     * timeout. This value is used when no socket timeout is set in the 
     * method parameters. 
     *
     * @param timeout Timeout in milliseconds
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.664 -0500", hash_original_method = "CB4B61C273CDC408983770CE1E9EEDF9", hash_generated_method = "64F4FEB6925839C1613845C4B9312681")
    
public static void setSoTimeout(final HttpParams params, int timeout) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, timeout);
        
    }

    /**
     * Tests if Nagle's algorithm is to be used.  
     *
     * @return <tt>true</tt> if the Nagle's algorithm is to NOT be used
     *   (that is enable TCP_NODELAY), <tt>false</tt> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.666 -0500", hash_original_method = "AD5A0E8D3A1BB4484F88E13BC8C4A2DD", hash_generated_method = "8B89FB7746FD7218A9E48EA012FDD89B")
    
public static boolean getTcpNoDelay(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getBooleanParameter
            (CoreConnectionPNames.TCP_NODELAY, true);
    }

    /**
     * Determines whether Nagle's algorithm is to be used. The Nagle's algorithm 
     * tries to conserve bandwidth by minimizing the number of segments that are 
     * sent. When applications wish to decrease network latency and increase 
     * performance, they can disable Nagle's algorithm (that is enable TCP_NODELAY). 
     * Data will be sent earlier, at the cost of an increase in bandwidth consumption. 
     *
     * @param value <tt>true</tt> if the Nagle's algorithm is to NOT be used
     *   (that is enable TCP_NODELAY), <tt>false</tt> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.669 -0500", hash_original_method = "C8D6523A87926B7A8E23C46F9EDFC6C0", hash_generated_method = "1F503690EE7DA407C8BAA2ECC063A5B2")
    
public static void setTcpNoDelay(final HttpParams params, boolean value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setBooleanParameter(CoreConnectionPNames.TCP_NODELAY, value);
    }

    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.671 -0500", hash_original_method = "F6DEAEAAADFCF9D50BA34D77250A8EB5", hash_generated_method = "5BFD7A9D9444AAFE865292D73EF6E764")
    
public static int getSocketBufferSize(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getIntParameter
            (CoreConnectionPNames.SOCKET_BUFFER_SIZE, -1);
    }
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.673 -0500", hash_original_method = "ADFAED6AF5B6F0F5EC76AF8795780FDD", hash_generated_method = "64CD606D5749F60BC00518C48F0E1582")
    
public static void setSocketBufferSize(final HttpParams params, int size) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, size);
    }

    /**
     * Returns linger-on-close timeout. Value <tt>0</tt> implies that the option is 
     * disabled. Value <tt>-1</tt> implies that the JRE default is used.
     * 
     * @return the linger-on-close timeout
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.676 -0500", hash_original_method = "F33D82740E9F90EE4781C3A18A7B7803", hash_generated_method = "181A6DF9EB8C6E1210F47FDBF0FD0FBC")
    
public static int getLinger(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getIntParameter(CoreConnectionPNames.SO_LINGER, -1);
    }

    /**
     * Returns linger-on-close timeout. This option disables/enables immediate return 
     * from a close() of a TCP Socket. Enabling this option with a non-zero Integer 
     * timeout means that a close() will block pending the transmission and 
     * acknowledgement of all data written to the peer, at which point the socket is 
     * closed gracefully. Value <tt>0</tt> implies that the option is 
     * disabled. Value <tt>-1</tt> implies that the JRE default is used.
     *
     * @param value the linger-on-close timeout
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.678 -0500", hash_original_method = "DABCBB52F4FFB299C5415652B2A77E01", hash_generated_method = "5ED90C3ABF176FAF40385D4292480299")
    
public static void setLinger(final HttpParams params, int value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setIntParameter(CoreConnectionPNames.SO_LINGER, value);
    }

    /**
     * Returns the timeout until a connection is etablished. A value of zero 
     * means the timeout is not used. The default value is zero.
     * 
     * @return timeout in milliseconds.
     */
    @DSSafe(DSCat.SAFE_LIST)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.681 -0500", hash_original_method = "22B41023B926EDDF5DFDC983ED2E70CB", hash_generated_method = "DD6907D10B3A87975E503CDDB5AEAEEF")
    
public static int getConnectionTimeout(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getIntParameter
            (CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
    }

    /**
     * Sets the timeout until a connection is etablished. A value of zero 
     * means the timeout is not used. The default value is zero.
     * 
     * @param timeout Timeout in milliseconds.
     */
    @DSSafe(DSCat.DATA_STRUCTURE)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.683 -0500", hash_original_method = "51CE67EE0A63F7004F655B49DB0B10B9", hash_generated_method = "5DE9D6C9CF48A352E7092533F5911958")
    
public static void setConnectionTimeout(final HttpParams params, int timeout) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setIntParameter
            (CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
    }
    
    /**
     * Tests whether stale connection check is to be used. Disabling 
     * stale connection check may result in slight performance improvement 
     * at the risk of getting an I/O error when executing a request over a
     * connection that has been closed at the server side. 
     * 
     * @return <tt>true</tt> if stale connection check is to be used, 
     *   <tt>false</tt> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.686 -0500", hash_original_method = "5518B866833D7125D58C449584816A72", hash_generated_method = "48A0DB17D3202AAB3AE3D6973E9AFDC5")
    
public static boolean isStaleCheckingEnabled(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getBooleanParameter
            (CoreConnectionPNames.STALE_CONNECTION_CHECK, true);
    }

    /**
     * Defines whether stale connection check is to be used. Disabling 
     * stale connection check may result in slight performance improvement 
     * at the risk of getting an I/O error when executing a request over a
     * connection that has been closed at the server side. 
     * 
     * @param value <tt>true</tt> if stale connection check is to be used, 
     *   <tt>false</tt> otherwise.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.688 -0500", hash_original_method = "C494A4728CB2E55350B613865E9262C9", hash_generated_method = "64258C278B31BC5930658CFAA138013C")
    
public static void setStaleCheckingEnabled(final HttpParams params, boolean value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setBooleanParameter
            (CoreConnectionPNames.STALE_CONNECTION_CHECK, value);
    }

    /**
     */
    @DSComment("Private Method")
    @DSBan(DSCat.PRIVATE_METHOD)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-30 13:01:31.659 -0500", hash_original_method = "E377E6E9E726367BB194BBBFED21463F", hash_generated_method = "432DB92DA846202D53CA72C75B4DE476")
    
private HttpConnectionParams() {
        super();
    }
    
}

