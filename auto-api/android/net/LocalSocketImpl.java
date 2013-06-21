package android.net;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;

// needed for enhanced for control translations
import java.util.Iterator;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.FileDescriptor;
import java.net.SocketOptions;

class LocalSocketImpl {
    private SocketInputStream fis;
    private SocketOutputStream fos;
    private Object readMonitor = new Object();
    private Object writeMonitor = new Object();
    private FileDescriptor fd;
    FileDescriptor[] inboundFileDescriptors;
    FileDescriptor[] outboundFileDescriptors;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.019 -0400", hash_original_method = "EB46FEA2FE489ABD86FB64E17870F7D5", hash_generated_method = "CD8997B5BBD288454729017F9D0FB34B")
    @DSModeled(DSC.SAFE)
     LocalSocketImpl() {
        // ---------- Original Method ----------
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.020 -0400", hash_original_method = "D456C6C1E42DF15F5B9AFA3DF483BFD5", hash_generated_method = "4AD34B976B9F43912FE7A139800EA305")
    @DSModeled(DSC.SAFE)
     LocalSocketImpl(FileDescriptor fd) throws IOException {
        dsTaint.addTaint(fd.dsTaint);
        // ---------- Original Method ----------
        //this.fd = fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.020 -0400", hash_original_method = "2758981D1030A8FDA90CA71A02304595", hash_generated_method = "6A510F41A5B87301F432B314A3C9A9FF")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int available_native(FileDescriptor fd) throws IOException {
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.021 -0400", hash_original_method = "C4F1C4509B0A008CEB1A520A33B1432C", hash_generated_method = "8EF9C79B87F6F04ABD6BE3A066AA12FE")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void close_native(FileDescriptor fd) throws IOException {
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.021 -0400", hash_original_method = "C5E1B2BCA848D2C54F079D7825712FAA", hash_generated_method = "A3012EC8783532ACC7487B8813733125")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int read_native(FileDescriptor fd) throws IOException {
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.021 -0400", hash_original_method = "6C0CD8F9940E6252A80F192C7FCEF247", hash_generated_method = "E0A6763390420A11852B2BEDC95678F1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int readba_native(byte[] b, int off, int len,
            FileDescriptor fd) throws IOException {
        dsTaint.addTaint(b[0]);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.021 -0400", hash_original_method = "411B6D80F43D59E374103A18918D197B", hash_generated_method = "E7ACFB21AA276FA2D0E8FA1902324C00")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void writeba_native(byte[] b, int off, int len,
            FileDescriptor fd) throws IOException {
        dsTaint.addTaint(b[0]);
        dsTaint.addTaint(off);
        dsTaint.addTaint(len);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.022 -0400", hash_original_method = "EC6860394B0EC0B22E9CA8C353E6B2CD", hash_generated_method = "EB92B2EB7D70448F45A38E01C9680DCB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void write_native(int b, FileDescriptor fd) throws IOException {
        dsTaint.addTaint(b);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.022 -0400", hash_original_method = "FB81706A2E5D939365DC1E11BB4FE7D5", hash_generated_method = "D6C41B8FECA0626D2EDB97E0E3518005")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void connectLocal(FileDescriptor fd, String name,
            int namespace) throws IOException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(namespace);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.022 -0400", hash_original_method = "62C617B37F715EB0C7D8B05FC6062D1C", hash_generated_method = "99CC68644F432DB5F6E641CE9D734C8F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void bindLocal(FileDescriptor fd, String name, int namespace) throws IOException {
        dsTaint.addTaint(name);
        dsTaint.addTaint(fd.dsTaint);
        dsTaint.addTaint(namespace);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.022 -0400", hash_original_method = "91E7A83B201CCE6F03E99B6B97993D3C", hash_generated_method = "7E7295114523BB21BF2E2CD51095176D")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private FileDescriptor create_native(boolean stream) throws IOException {
        dsTaint.addTaint(stream);
        return (FileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.022 -0400", hash_original_method = "565F45EE1777149341C55D43CF68422B", hash_generated_method = "2D15399BA9242D0A6A8DFE0C52F208C8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void listen_native(FileDescriptor fd, int backlog) throws IOException {
        dsTaint.addTaint(backlog);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.023 -0400", hash_original_method = "AE79C436903413982C1AAE7FD29B4B48", hash_generated_method = "9A2E4BEC03DB0601A56468389762CE8B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void shutdown(FileDescriptor fd, boolean shutdownInput) {
        dsTaint.addTaint(shutdownInput);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.023 -0400", hash_original_method = "0137F99D53D5E10D02D5A211BB31B969", hash_generated_method = "F64433A66CCCB1AC8AAF70D9D7968E3E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private Credentials getPeerCredentials_native(
            FileDescriptor fd) throws IOException {
        dsTaint.addTaint(fd.dsTaint);
        return (Credentials)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.023 -0400", hash_original_method = "57547C3595B23A135CCDE37FD7052F1D", hash_generated_method = "98F5BBB2164BA993E5F967D4EC1E3905")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private int getOption_native(FileDescriptor fd, int optID) throws IOException {
        dsTaint.addTaint(optID);
        dsTaint.addTaint(fd.dsTaint);
        return dsTaint.getTaintInt();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.023 -0400", hash_original_method = "DE678D0521D206818FAC33E612ECDEF9", hash_generated_method = "C5C01041E55E612783C53835BD8873BB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private void setOption_native(FileDescriptor fd, int optID,
            int b, int value) throws IOException {
        dsTaint.addTaint(b);
        dsTaint.addTaint(optID);
        dsTaint.addTaint(value);
        dsTaint.addTaint(fd.dsTaint);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.024 -0400", hash_original_method = "AD93B21D07861EA052C26EC40030E4DA", hash_generated_method = "BF6A293668A69DF8F400B886C4258A4C")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    private FileDescriptor accept(FileDescriptor fd, LocalSocketImpl s) throws IOException {
        dsTaint.addTaint(s.dsTaint);
        dsTaint.addTaint(fd.dsTaint);
        return (FileDescriptor)dsTaint.getTaint();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.024 -0400", hash_original_method = "910906868F2A4F19B7D2844E1F779346", hash_generated_method = "BBF1D043AA10CD168897B94197A3959F")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public String toString() {
        String var1F7F2419C264642270DB93B2B3724083_975955013 = (super.toString() + " fd:" + fd);
        return dsTaint.getTaintString();
        // ---------- Original Method ----------
        //return super.toString() + " fd:" + fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.024 -0400", hash_original_method = "C69FBA5615AE4C555A8E605188FC5D70", hash_generated_method = "1AD088513A4AD1546094F1BAE20B96D4")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void create(boolean stream) throws IOException {
        dsTaint.addTaint(stream);
        {
            fd = create_native(stream);
        } //End block
        // ---------- Original Method ----------
        //if (fd == null) {
            //fd = create_native(stream);
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.025 -0400", hash_original_method = "ABF18B5E6666C8F5D8A2BB5F41F5792B", hash_generated_method = "8366CA807E9C5D2609C5D88533A0A513")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void close() throws IOException {
        {
            Object varE19B0DA50F6EB975A9A155685A0B3663_1081992393 = (LocalSocketImpl.this);
            {
                close_native(fd);
                fd = null;
            } //End block
        } //End collapsed parenthetic
        // ---------- Original Method ----------
        //synchronized (LocalSocketImpl.this) {
            //if (fd == null) return;
            //close_native(fd);
            //fd = null;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.025 -0400", hash_original_method = "425C245C15643B6C00C58E49D6A6C651", hash_generated_method = "83F17E2FF11975FE124353767974C358")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void connect(LocalSocketAddress address, int timeout) throws IOException {
        dsTaint.addTaint(address.dsTaint);
        dsTaint.addTaint(timeout);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        connectLocal(fd, address.getName(), address.getNamespace().getId());
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //connectLocal(fd, address.getName(), address.getNamespace().getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.025 -0400", hash_original_method = "D301FBD428349B466ACCB27339A08D2F", hash_generated_method = "8C175C463C0870A561328720292A6544")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void bind(LocalSocketAddress endpoint) throws IOException {
        dsTaint.addTaint(endpoint.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        bindLocal(fd, endpoint.getName(), endpoint.getNamespace().getId());
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //bindLocal(fd, endpoint.getName(), endpoint.getNamespace().getId());
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.026 -0400", hash_original_method = "A6DEE76A07DA4242CC30FE3245F17D51", hash_generated_method = "DAFFD6DEFAA57B7296EE06E4889D8AE8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void listen(int backlog) throws IOException {
        dsTaint.addTaint(backlog);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        listen_native(fd, backlog);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //listen_native(fd, backlog);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.027 -0400", hash_original_method = "E2D863498299C9CF5B0AE6150A21C675", hash_generated_method = "E1AE49D5D702A3A11CE7E01BF385752B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void accept(LocalSocketImpl s) throws IOException {
        dsTaint.addTaint(s.dsTaint);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        s.fd = accept(fd, s);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //s.fd = accept(fd, s);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.028 -0400", hash_original_method = "D37322C17A1B9B191A9C32D9BD81E000", hash_generated_method = "43E6F0589D4F415038A3DB3D2D804F1B")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected InputStream getInputStream() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        {
            {
                fis = new SocketInputStream();
            } //End block
        } //End block
        return (InputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //synchronized (this) {
            //if (fis == null) {
                //fis = new SocketInputStream();
            //}
            //return fis;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.028 -0400", hash_original_method = "2E8F2E95CF2F6CF40AEA3B38F9B68B34", hash_generated_method = "7FD0ED5F9B04074046C79FBC76F6D1D8")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected OutputStream getOutputStream() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        {
            {
                fos = new SocketOutputStream();
            } //End block
        } //End block
        return (OutputStream)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //synchronized (this) {
            //if (fos == null) {
                //fos = new SocketOutputStream();
            //}
            //return fos;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.028 -0400", hash_original_method = "A7CC818E7F384DAEC54D76069E9C5019", hash_generated_method = "2D45E666DC1D7CCF348F0986A47A74DB")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected int available() throws IOException {
        int var6B9EBF6BA37A6BD9983DF13805FEE2B0_823652317 = (getInputStream().available());
        return dsTaint.getTaintInt();
        // ---------- Original Method ----------
        //return getInputStream().available();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.029 -0400", hash_original_method = "CED8C1FFBDBF9F9E7A40EC2B2E6DD909", hash_generated_method = "B9E9E1065BD5DCF9B6CDD30A30C64630")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void shutdownInput() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        shutdown(fd, true);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //shutdown(fd, true);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.029 -0400", hash_original_method = "DE98B1F2C9FD8DEEFDCE620E4EB90078", hash_generated_method = "88FE1B1AA32A8F5AC8F548BD316D929E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void shutdownOutput() throws IOException {
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        shutdown(fd, false);
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //shutdown(fd, false);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.029 -0400", hash_original_method = "C1B4172ED9A628993584DE4384B8AF55", hash_generated_method = "EAD66F9260E01901E44F8BA8437BA9E5")
    @DSModeled(DSC.SAFE)
    protected FileDescriptor getFileDescriptor() {
        return (FileDescriptor)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return fd;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.029 -0400", hash_original_method = "84442B2358C6BD30716C7D72481FD8C4", hash_generated_method = "FB3474151C904A3D2581D2FD62A54A93")
    @DSModeled(DSC.SAFE)
    protected boolean supportsUrgentData() {
        return dsTaint.getTaintBoolean();
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.029 -0400", hash_original_method = "EC21D6BA9A1DE1709D242100460B4B8C", hash_generated_method = "E41FA55071EB6B1BD7C479C0ACED76F6")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    protected void sendUrgentData(int data) throws IOException {
        dsTaint.addTaint(data);
        if (DroidSafeAndroidRuntime.control) throw new RuntimeException ("not impled");
        // ---------- Original Method ----------
        //throw new RuntimeException ("not impled");
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.030 -0400", hash_original_method = "02CEF5E6368D2209C8707863BE147BD2", hash_generated_method = "666A629C03BE7DCB8620AB81A7583015")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Object getOption(int optID) throws IOException {
        dsTaint.addTaint(optID);
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        int value;
        value = getOption_native(fd, optID);
        return (Object)dsTaint.getTaint();
        // ---------- Original Method ----------
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //if (optID == SocketOptions.SO_TIMEOUT) {
            //return 0;
        //}
        //int value = getOption_native(fd, optID);
        //switch (optID)
        //{
            //case SocketOptions.SO_RCVBUF:
            //case SocketOptions.SO_SNDBUF:
                //return value;
            //case SocketOptions.SO_REUSEADDR:
            //default:
                //return value;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.030 -0400", hash_original_method = "A0313708A2FB484B7104FAC62F0E39B4", hash_generated_method = "D7E0B3767FBA97A875FD20142A15EA2E")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public void setOption(int optID, Object value) throws IOException {
        dsTaint.addTaint(optID);
        dsTaint.addTaint(value.dsTaint);
        int boolValue;
        boolValue = -1;
        int intValue;
        intValue = 0;
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("socket not created");
        } //End block
        {
            intValue = (Integer)value;
        } //End block
        {
            boolValue = ((Boolean) value)? 1 : 0;
        } //End block
        {
            if (DroidSafeAndroidRuntime.control) throw new IOException("bad value: " + value);
        } //End block
        setOption_native(fd, optID, boolValue, intValue);
        // ---------- Original Method ----------
        //int boolValue = -1;
        //int intValue = 0;
        //if (fd == null) {
            //throw new IOException("socket not created");
        //}
        //if (value instanceof Integer) {
            //intValue = (Integer)value;
        //} else if (value instanceof Boolean) {
            //boolValue = ((Boolean) value)? 1 : 0;
        //} else {
            //throw new IOException("bad value: " + value);
        //}
        //setOption_native(fd, optID, boolValue, intValue);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.030 -0400", hash_original_method = "AEC4AD692525702323537BC369199B7F", hash_generated_method = "C6F9097150E107B86C665C4625C313FA")
    @DSModeled(DSC.SAFE)
    public void setFileDescriptorsForSend(FileDescriptor[] fds) {
        dsTaint.addTaint(fds[0].dsTaint);
        // ---------- Original Method ----------
        //synchronized(writeMonitor) {
            //outboundFileDescriptors = fds;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.031 -0400", hash_original_method = "D444308F286D853D2E5F97ACF37B86DF", hash_generated_method = "0A8B1B92E5C82A81DDD8B64D7DF76D6B")
    @DSModeled(DSC.SAFE)
    public FileDescriptor[] getAncillaryFileDescriptors() throws IOException {
        {
            FileDescriptor[] result;
            result = inboundFileDescriptors;
            inboundFileDescriptors = null;
        } //End block
        return (FileDescriptor[])dsTaint.getTaint();
        // ---------- Original Method ----------
        //synchronized(readMonitor) {
            //FileDescriptor[] result = inboundFileDescriptors;
            //inboundFileDescriptors = null;
            //return result;
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.031 -0400", hash_original_method = "3E3240E544229F6BEFF619755963B808", hash_generated_method = "41910F0BA775D2CB113F9F72DD0E51C1")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    public Credentials getPeerCredentials() throws IOException {
        Credentials varA80554B1A1CC9D4CA33C6C08BF82200B_1332639825 = (getPeerCredentials_native(fd));
        return (Credentials)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return getPeerCredentials_native(fd);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.031 -0400", hash_original_method = "C6AD39B00524B9355CA4153DB07C4B13", hash_generated_method = "50CE1124ECE240760F7D75E5DF2FAFED")
    @DSModeled(DSC.SAFE)
    public LocalSocketAddress getSockAddress() throws IOException {
        return (LocalSocketAddress)dsTaint.getTaint();
        // ---------- Original Method ----------
        //return null;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.031 -0400", hash_original_method = "CA22E17CA63436350E75BC7DD678FC6C", hash_generated_method = "EE7B698A5C5971F84CA5AA51E8CB3380")
    //DSFIXME:  CODE0002: Requires DSC value to be set
    @Override
    protected void finalize() throws IOException {
        close();
        // ---------- Original Method ----------
        //close();
    }

    
    class SocketInputStream extends InputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.031 -0400", hash_original_method = "ED28319C5AF83EC443233EFFAEE209B5", hash_generated_method = "ED28319C5AF83EC443233EFFAEE209B5")
                public SocketInputStream ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.032 -0400", hash_original_method = "8F92B1C37F1E7B064EB55148DFA3D6F8", hash_generated_method = "D6A55183939E6490EFE7078809243DD5")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int available() throws IOException {
            int varE70871DEC74DFE680005AAB58E0DA61C_463908960 = (available_native(fd));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return available_native(fd);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.032 -0400", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "ECE646958EE00D511DDB45A2F54ADA78")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
            // ---------- Original Method ----------
            //LocalSocketImpl.this.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.032 -0400", hash_original_method = "395E06403A9BB7E16A5F2E3FCA2C1758", hash_generated_method = "EBF87495B95F33172B3AB115F3F41868")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read() throws IOException {
            int ret;
            {
                FileDescriptor myFd;
                myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                ret = read_native(myFd);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //int ret;
            //synchronized (readMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //ret = read_native(myFd);
                //return ret;
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.033 -0400", hash_original_method = "03121A7AC3B4E7519E88953F37DA485C", hash_generated_method = "4998C37BBAF983F66FC82DB78DB4E697")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] b) throws IOException {
            dsTaint.addTaint(b[0]);
            int var622F29548219192F8BB382FD386339B9_1818773708 = (read(b, 0, b.length));
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //return read(b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.033 -0400", hash_original_method = "554DCEA621C79251D4E71F6BA8C4411B", hash_generated_method = "CF0BAE90697A2A98EC07C89E5F6D88C0")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public int read(byte[] b, int off, int len) throws IOException {
            dsTaint.addTaint(b[0]);
            dsTaint.addTaint(off);
            dsTaint.addTaint(len);
            {
                FileDescriptor myFd;
                myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                {
                    if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
                } //End block
                int ret;
                ret = readba_native(b, off, len, myFd);
            } //End block
            return dsTaint.getTaintInt();
            // ---------- Original Method ----------
            //synchronized (readMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //if (off < 0 || len < 0 || (off + len) > b.length ) {
                    //throw new ArrayIndexOutOfBoundsException();
                //}
                //int ret = readba_native(b, off, len, myFd);
                //return ret;
            //}
        }

        
    }


    
    class SocketOutputStream extends OutputStream {
        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.033 -0400", hash_original_method = "6458CF3F1325286BA7B963E8FAE1E65A", hash_generated_method = "6458CF3F1325286BA7B963E8FAE1E65A")
                public SocketOutputStream ()
        {
        }


        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.033 -0400", hash_original_method = "C23E504E812AF14B0F4062FED57A7B1E", hash_generated_method = "ECE646958EE00D511DDB45A2F54ADA78")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void close() throws IOException {
            LocalSocketImpl.this.close();
            // ---------- Original Method ----------
            //LocalSocketImpl.this.close();
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.033 -0400", hash_original_method = "E1D4EA7BC5A1A039095C078064FA6BD5", hash_generated_method = "F80367D112B482C5F87D46F2C88171CA")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(byte[] b) throws IOException {
            dsTaint.addTaint(b[0]);
            write(b, 0, b.length);
            // ---------- Original Method ----------
            //write(b, 0, b.length);
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.034 -0400", hash_original_method = "EBF729639A281DEC85F834E9B1299F05", hash_generated_method = "29C2ABE05506F1D0DE74902003D1D658")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            dsTaint.addTaint(b[0]);
            dsTaint.addTaint(off);
            dsTaint.addTaint(len);
            {
                FileDescriptor myFd;
                myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                {
                    if (DroidSafeAndroidRuntime.control) throw new ArrayIndexOutOfBoundsException();
                } //End block
                writeba_native(b, off, len, myFd);
            } //End block
            // ---------- Original Method ----------
            //synchronized (writeMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //if (off < 0 || len < 0 || (off + len) > b.length ) {
                    //throw new ArrayIndexOutOfBoundsException();
                //}
                //writeba_native(b, off, len, myFd);
            //}
        }

        
        @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.1", generated_on = "2013-06-21 15:39:51.034 -0400", hash_original_method = "0B4435377A393210C076C48249BA83BB", hash_generated_method = "2E5289AF806DE333A803C499AEAEE70F")
        //DSFIXME:  CODE0002: Requires DSC value to be set
        @Override
        public void write(int b) throws IOException {
            dsTaint.addTaint(b);
            {
                FileDescriptor myFd;
                myFd = fd;
                if (DroidSafeAndroidRuntime.control) throw new IOException("socket closed");
                write_native(b, myFd);
            } //End block
            // ---------- Original Method ----------
            //synchronized (writeMonitor) {
                //FileDescriptor myFd = fd;
                //if (myFd == null) throw new IOException("socket closed");
                //write_native(b, myFd);
            //}
        }

        
    }


    
}

