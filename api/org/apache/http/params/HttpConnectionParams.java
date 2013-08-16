package org.apache.http.params;

// Droidsafe Imports
import droidsafe.annotations.*;


public final class HttpConnectionParams implements CoreConnectionPNames {
    
    @DSModeled(DSC.BAN)
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-17 10:25:37.208 -0400", hash_original_method = "E377E6E9E726367BB194BBBFED21463F", hash_generated_method = "C92261D75273D144D335B520B6DC917E")
    private  HttpConnectionParams() {
        super();
        // ---------- Original Method ----------
    }

    
    @DSModeled(DSC.SAFE)
    public static int getSoTimeout(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getIntParameter(CoreConnectionPNames.SO_TIMEOUT, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setSoTimeout(final HttpParams params, int timeout) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setIntParameter(CoreConnectionPNames.SO_TIMEOUT, timeout);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean getTcpNoDelay(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getBooleanParameter
            (CoreConnectionPNames.TCP_NODELAY, true);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setTcpNoDelay(final HttpParams params, boolean value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setBooleanParameter(CoreConnectionPNames.TCP_NODELAY, value);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getSocketBufferSize(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getIntParameter
            (CoreConnectionPNames.SOCKET_BUFFER_SIZE, -1);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setSocketBufferSize(final HttpParams params, int size) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setIntParameter(CoreConnectionPNames.SOCKET_BUFFER_SIZE, size);
    }

    
    @DSModeled(DSC.SAFE)
    public static int getLinger(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getIntParameter(CoreConnectionPNames.SO_LINGER, -1);
    }

    
    public static void setLinger(final HttpParams params, int value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setIntParameter(CoreConnectionPNames.SO_LINGER, value);
    }

    
    public static int getConnectionTimeout(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getIntParameter
            (CoreConnectionPNames.CONNECTION_TIMEOUT, 0);
    }

    
    @DSModeled(DSC.SAFE)
    public static void setConnectionTimeout(final HttpParams params, int timeout) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setIntParameter
            (CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
    }

    
    @DSModeled(DSC.SAFE)
    public static boolean isStaleCheckingEnabled(final HttpParams params) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        return params.getBooleanParameter
            (CoreConnectionPNames.STALE_CONNECTION_CHECK, true);
    }

    
    public static void setStaleCheckingEnabled(final HttpParams params, boolean value) {
        if (params == null) {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
        params.setBooleanParameter
            (CoreConnectionPNames.STALE_CONNECTION_CHECK, value);
    }

    
}

