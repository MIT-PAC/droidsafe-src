package java.io;

// Droidsafe Imports

public abstract interface ObjectStreamConstants {

    
    public static final short STREAM_MAGIC = (short) 0xaced;

    
    public static final short STREAM_VERSION = 5;

    

    
    public static final byte TC_BASE = 0x70;

    
    public static final byte TC_NULL = (byte) 0x70;

    
    public static final byte TC_REFERENCE = (byte) 0x71;

    
    public static final byte TC_CLASSDESC = (byte) 0x72;

    
    public static final byte TC_OBJECT = (byte) 0x73;

    
    public static final byte TC_STRING = (byte) 0x74;

    
    public static final byte TC_ARRAY = (byte) 0x75;

    
    public static final byte TC_CLASS = (byte) 0x76;

    
    public static final byte TC_BLOCKDATA = (byte) 0x77;

    
    public static final byte TC_ENDBLOCKDATA = (byte) 0x78;

    
    public static final byte TC_RESET = (byte) 0x79;

    
    public static final byte TC_BLOCKDATALONG = (byte) 0x7A;

    
    public static final byte TC_EXCEPTION = (byte) 0x7B;

    
    public static final byte TC_LONGSTRING = (byte) 0x7C;

    
    public static final byte TC_PROXYCLASSDESC = (byte) 0x7D;

    
    public static final byte TC_MAX = 0x7E;

    
    public static final int baseWireHandle = 0x007e0000;

    
    public static final int PROTOCOL_VERSION_1 = 1;

    
    public static final int PROTOCOL_VERSION_2 = 2;

    
    public static final SerializablePermission SUBCLASS_IMPLEMENTATION_PERMISSION = new SerializablePermission(
            "enableSubclassImplementation");

    
    public static final SerializablePermission SUBSTITUTION_PERMISSION = new SerializablePermission(
            "enableSubstitution");

    
    
    
    public static final byte SC_WRITE_METHOD = 0x01; 

    
    public static final byte SC_SERIALIZABLE = 0x02;

    
    public static final byte SC_EXTERNALIZABLE = 0x04;

    
    public static final byte SC_BLOCK_DATA = 0x08; 

    
    public static final byte TC_ENUM = 0x7E;

    
    public static final byte SC_ENUM = 0x10;
}
