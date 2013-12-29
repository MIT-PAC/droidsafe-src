package java.net;

// Droidsafe Imports
import droidsafe.runtime.*;
import droidsafe.helpers.*;
import droidsafe.annotations.*;





public class Proxy {
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.134 -0500", hash_original_field = "7A90B00F2DD5A44F0498BE34EC4A9BC4", hash_generated_field = "CFAF9C7805E2D3759922DBF914F8A204")

    public static final Proxy NO_PROXY = new Proxy();
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.135 -0500", hash_original_field = "C3BCDFF467E25677A4CAD03D3685368E", hash_generated_field = "0493BBFB1288023B7B163197BF9857A6")


    private Proxy.Type type;
@DSGeneratedField(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.136 -0500", hash_original_field = "886A1037AAF343052F31583F2126531A", hash_generated_field = "E0A43CBF82D512E62F9819C96F9107F8")


    private SocketAddress address;

    /**
     * Creates a new {@code Proxy} instance. {@code SocketAddress} must NOT be
     * {@code null} when {@code type} is either {@code Proxy.Type.HTTP} or
     * {@code Proxy.Type.SOCKS}. To create a {@code Proxy} instance representing
     * the proxy type {@code Proxy.Type.DIRECT}, use {@code Proxy.NO_PROXY}
     * instead of this constructor.
     *
     * @param type
     *            the proxy type of this instance.
     * @param sa
     *            the proxy address of this instance.
     * @throws IllegalArgumentException
     *             if the parameter {@code type} is set to {@code
     *             Proxy.Type.DIRECT} or the value for {@code SocketAddress} is
     *             {@code null}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.137 -0500", hash_original_method = "16752A487C0930093F66EAD9AA8B14F8", hash_generated_method = "3F303DBA817C4C30439318FC3F690B49")
    public Proxy(Proxy.Type type, SocketAddress sa) {
        /*
         * Don't use DIRECT type to construct a proxy instance directly.
         * SocketAddress must NOT be null.
         */
        if (type == Type.DIRECT || sa == null) {
            throw new IllegalArgumentException("Illegal Proxy.Type or SocketAddress argument");
        }
        this.type = type;
        address = sa;
    }

    /*
     * Constructs a Proxy instance, which is Proxy.DIRECT type with null
     * SocketAddress. This constructor is used for NO_PROXY.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.138 -0500", hash_original_method = "D66A32319FBF400033B05D10E8B8C304", hash_generated_method = "48AD1BF6F9D8AB8F908FD2AFD012C28A")
    private Proxy() {
        type = Type.DIRECT;
        address = null;
    }

    /**
     * Gets the type of this {@code Proxy} instance.
     *
     * @return the stored proxy type.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.139 -0500", hash_original_method = "78A2D2ADD0266F75C3E71E2673988A41", hash_generated_method = "E3E3657E190AA2B16FD0C9404E53EA2D")
    public Proxy.Type type() {
        return type;
    }

    /**
     * Gets the address of this {@code Proxy} instance.
     *
     * @return the stored proxy address or {@code null} if the proxy type is
     *         {@code DIRECT}.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.140 -0500", hash_original_method = "9D457D33A5E2F2EF090CABC1273126C2", hash_generated_method = "E9A573AFC34D91819F556C96EE516988")
    public SocketAddress address() {
        return address;
    }

    /**
     * Gets a textual representation of this {@code Proxy} instance. The string
     * includes the two parts {@code type.toString()} and {@code
     * address.toString()} if {@code address} is not {@code null}.
     *
     * @return the representing string of this proxy.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.140 -0500", hash_original_method = "15D85DA96A49804E7A6DD9EB58950877", hash_generated_method = "E6576740E2634FC2E7865B5234D8A111")
    @Override
public String toString() {
        StringBuilder builder = new StringBuilder();
        if (type != null) {
            builder.append(type.toString());
        }
        builder.append("@");
        if (type != Proxy.Type.DIRECT && address != null) {
            builder.append(address.toString());
        }
        return builder.toString();
    }

    /**
     * Compares the specified {@code obj} to this {@code Proxy} instance and
     * returns whether they are equal or not. The given object must be an
     * instance of {@code Proxy} with the same address and the same type value
     * to be equal.
     *
     * @param obj
     *            the object to compare with this instance.
     * @return {@code true} if the given object represents the same {@code
     *         Proxy} as this instance, {@code false} otherwise.
     * @see #hashCode
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.141 -0500", hash_original_method = "0AADE3011667515449A8CD7BE7CB43B7", hash_generated_method = "5E4FA92ED2FAEE29695A17E553FEC1CD")
    @Override
public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Proxy)) {
            return false;
        }
        Proxy another = (Proxy) obj;
        // address is null when and only when it's NO_PROXY.
        return (type == another.type) && address.equals(another.address);
    }

    
    public enum Type {
        DIRECT,
        HTTP,
        SOCKS
    }

    /**
     * Gets the hashcode for this {@code Proxy} instance.
     *
     * @return the hashcode value for this Proxy instance.
     */
    @DSGenerator(tool_name = "Doppelganger", tool_version = "2.0", generated_on = "2013-12-27 12:46:07.142 -0500", hash_original_method = "AFEB3E9B74402AACB68FC4AD63CE261F", hash_generated_method = "AEBC8342316450BCA39FD0E8718D8875")
    @Override
public final int hashCode() {
        int ret = 0;
        ret += type.hashCode();
        if (address != null) {
            ret += address.hashCode();
        }
        return ret;
    }
}

