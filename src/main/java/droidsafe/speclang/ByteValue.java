package droidsafe.speclang;

/**
 * A byte constant value in the spec language IR.
 * 
 * @author mgordon
 *
 */
public class ByteValue extends ConcreteArgumentValue {
    /** Internal value */
    private byte value;

    /** Create a new byte value with the given byte value */
    public ByteValue(byte value) {
        this.value = value;
    }
    
    @Override
    public String toStringValue() {
        return "BYTE: " + value;
    }

    public byte getValue() {
        return value;
    }

    /**
     * Return a hex representation of the byte.
     */
    public String toString() {
        return String.format("0x%02X", value);
    }
    
    public void setValue(byte value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        ByteValue other = (ByteValue) obj;
        if (value != other.value) return false;
        return true;
    }
    
    
}
