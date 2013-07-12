package java.nio;


import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.FileDescriptor;

interface FileDescriptorChannel {
    public FileDescriptor getFD();
}
