package org.apache.http.conn.scheme;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import java.util.Locale;

import org.apache.http.util.LangUtils;






public final class Scheme {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.206 -0500", hash_original_field = "BF45F7481B8091DE3CBF80E94F7F940B", hash_generated_field = "531F96E2AEBFB44CD229EC4CB1F012B0")

    private  String name;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.207 -0500", hash_original_field = "F5D708FA52E1CEE0A363F0B1B8FF1782", hash_generated_field = "EE0A679D7069D3BF51EFF346308E2FC4")

    private  SocketFactory socketFactory;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.208 -0500", hash_original_field = "47331465E462A0CF223A67E4F658AFC0", hash_generated_field = "FC0F8278C90053902D318AF538EA40AF")

    private  int defaultPort;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.209 -0500", hash_original_field = "E2E7742510C17C1B3A922E4AA466C397", hash_generated_field = "656433D6E22132E512C250C9ABEE8490")

    private  boolean layered;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.210 -0500", hash_original_field = "E3930F4F4617B35851A6540EEE3F9D12", hash_generated_field = "A7CB93AD593788A74C76D77C24510B38")

    private String stringRep;


    /**
     * Creates a new scheme.
     * Whether the created scheme allows for layered connections
     * depends on the class of <code>factory</code>.
     *
     * @param name      the scheme name, for example "http".
     *                  The name will be converted to lowercase.
     * @param factory   the factory for creating sockets for communication
     *                  with this scheme
     * @param port      the default port for this scheme
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.211 -0500", hash_original_method = "FC3EBEAFEA712CD3115701A02487AC2E", hash_generated_method = "3D0DBE9192B830DF8F56939BB0FA9EA2")
    public Scheme(final String name,
                  final SocketFactory factory,
                  final int port) {

        if (name == null) {
            throw new IllegalArgumentException
                ("Scheme name may not be null");
        }
        if (factory == null) {
            throw new IllegalArgumentException
                ("Socket factory may not be null");
        }
        if ((port <= 0) || (port > 0xffff)) {
            throw new IllegalArgumentException
                ("Port is invalid: " + port);
        }

        this.name = name.toLowerCase(Locale.ENGLISH);
        this.socketFactory = factory;
        this.defaultPort = port;
        this.layered = (factory instanceof LayeredSocketFactory);
    }


    /**
     * Obtains the default port.
     *
     * @return  the default port for this scheme
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.212 -0500", hash_original_method = "CA86BB3AB3ACF92C5C19618DD925F5A0", hash_generated_method = "401192712493098D15EFB1F0ECDEF1C4")
    public final int getDefaultPort() {
        return defaultPort;
    }


    /**
     * Obtains the socket factory.
     * If this scheme is {@link #isLayered layered}, the factory implements
     * {@link LayeredSocketFactory LayeredSocketFactory}.
     *
     * @return  the socket factory for this scheme
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.212 -0500", hash_original_method = "8D53BDBBDB5B8DACC183C2C5A3A2FE13", hash_generated_method = "44F91E40C7436BBE9C4296A40627D690")
    public final SocketFactory getSocketFactory() {
        return socketFactory;
    }


    /**
     * Obtains the scheme name.
     *
     * @return  the name of this scheme, in lowercase
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.213 -0500", hash_original_method = "7070E6AABEDCBA653834DDC8CF79A47C", hash_generated_method = "CEAA3BC43A9BFF97F5638C3D9028D82D")
    public final String getName() {
        return name;
    }


    /**
     * Indicates whether this scheme allows for layered connections.
     *
     * @return <code>true</code> if layered connections are possible,
     *         <code>false</code> otherwise
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.214 -0500", hash_original_method = "9614A7277DEC14D06C0E4E046469A079", hash_generated_method = "29CD0897EECAA79CFC9E02A109F73666")
    public final boolean isLayered() {
        return layered;
    }


    /**
     * Resolves the correct port for this scheme.
     * Returns the given port if it is valid, the default port otherwise.
     * 
     * @param port      the port to be resolved,
     *                  a negative number to obtain the default port
     * 
     * @return the given port or the defaultPort
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.215 -0500", hash_original_method = "64F6A6BD8BE8E9634AE7594AC6F06F64", hash_generated_method = "E92BEB28A041B72F482175599A614F8B")
    public final int resolvePort(int port) {
        return ((port <= 0) || (port > 0xffff)) ? defaultPort : port;
    }


    /**
     * Return a string representation of this object.
     *
     * @return  a human-readable string description of this scheme
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.216 -0500", hash_original_method = "DC9B71D58EF4666028CCB60CC7379DF5", hash_generated_method = "E00F298668F65E9C2A06FCA512B9F74F")
    @Override
public final String toString() {
        if (stringRep == null) {
            StringBuilder buffer = new StringBuilder();
            buffer.append(this.name);
            buffer.append(':');
            buffer.append(Integer.toString(this.defaultPort));
            stringRep = buffer.toString();
        }
        return stringRep;
    }


    /**
     * Compares this scheme to an object.
     *
     * @param obj       the object to compare with
     *
     * @return  <code>true</code> iff the argument is equal to this scheme
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.217 -0500", hash_original_method = "62FA4DFF9313BF5A320239E33F35F300", hash_generated_method = "733B69A8EB45CD063949BB0690FB1778")
    @Override
public final boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (!(obj instanceof Scheme)) return false;

        Scheme s = (Scheme) obj;
        return (name.equals(s.name) &&
                defaultPort == s.defaultPort &&
                layered == s.layered &&
                socketFactory.equals(s.socketFactory)
                );
    } // equals


    /**
     * Obtains a hash code for this scheme.
     *
     * @return  the hash code
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:47:18.218 -0500", hash_original_method = "D2A22011D07817D724D5F16905D145B4", hash_generated_method = "5AE1AC9C87791C009A45FC7036D03F56")
    @Override
public int hashCode() {
        int hash = LangUtils.HASH_SEED;
        hash = LangUtils.hashCode(hash, this.defaultPort);
        hash = LangUtils.hashCode(hash, this.name);
        hash = LangUtils.hashCode(hash, this.layered);
        hash = LangUtils.hashCode(hash, this.socketFactory);
        return hash;
    }

    
}

