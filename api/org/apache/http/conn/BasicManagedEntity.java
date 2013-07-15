package org.apache.http.conn;

// Droidsafe Imports
import droidsafe.helpers.*;
import droidsafe.annotations.*;
import droidsafe.runtime.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.http.HttpEntity;
import org.apache.http.entity.HttpEntityWrapper;

public class BasicManagedEntity extends HttpEntityWrapper implements ConnectionReleaseTrigger, EofSensorWatcher {
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.344 -0400", hash_original_field = "58ED85B7F214AB5BB7A822D300274AA0", hash_generated_field = "A39C84F92F3A7EA4C05EE395EC188DAE")

    protected ManagedClientConnection managedConn;
    @DSGeneratedField(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.344 -0400", hash_original_field = "BC1D8257E471E8A2ADFDE56CC9E36679", hash_generated_field = "E3C3E883F50FA4994DDE044495909683")

    protected boolean attemptReuse;
    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.344 -0400", hash_original_method = "75E41BB014942CF37AED72804C2A632B", hash_generated_method = "65105DC1740CD150BD6A158FADC7BA6C")
    public  BasicManagedEntity(HttpEntity entity,
                              ManagedClientConnection conn,
                              boolean reuse) {
        super(entity);
        addTaint(entity.getTaint());
    if(conn == null)        
        {
        IllegalArgumentException var71F5544A68765CAB47D8B8A7ED0FBD93_749902635 = new IllegalArgumentException
                ("Connection may not be null.");
        var71F5544A68765CAB47D8B8A7ED0FBD93_749902635.addTaint(taint);
        throw var71F5544A68765CAB47D8B8A7ED0FBD93_749902635;
        }
        this.managedConn = conn;
        this.attemptReuse = reuse;
        // ---------- Original Method ----------
        //if (conn == null)
            //throw new IllegalArgumentException
                //("Connection may not be null.");
        //this.managedConn = conn;
        //this.attemptReuse = reuse;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.345 -0400", hash_original_method = "731D88F5D8865617BA362DCED4C30896", hash_generated_method = "51900B30D0BFA891BECF226941EBA2C6")
    @Override
    public boolean isRepeatable() {
        boolean var68934A3E9455FA72420237EB05902327_191510632 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1016760894 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1016760894;
        // ---------- Original Method ----------
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.345 -0400", hash_original_method = "5A535D8BC3EB290E639D312782FBEB37", hash_generated_method = "284BD3789ACC3A92F724FD0620221F12")
    @Override
    public InputStream getContent() throws IOException {
InputStream var3413A152FFF46FA6CE18671D68F2D3B0_1814976837 =         new EofSensorInputStream(wrappedEntity.getContent(), this);
        var3413A152FFF46FA6CE18671D68F2D3B0_1814976837.addTaint(taint);
        return var3413A152FFF46FA6CE18671D68F2D3B0_1814976837;
        // ---------- Original Method ----------
        //return new EofSensorInputStream(wrappedEntity.getContent(), this);
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.345 -0400", hash_original_method = "58D11A845FE872643BE2CB7CB3DAF1D5", hash_generated_method = "6CFFE41A967356C0CBB831B899F93E97")
    @Override
    public void consumeContent() throws IOException {
    if(managedConn == null)        
        return;
        try 
        {
    if(attemptReuse)            
            {
                wrappedEntity.consumeContent();
                managedConn.markReusable();
            } //End block
        } //End block
        finally 
        {
            releaseManagedConnection();
        } //End block
        // ---------- Original Method ----------
        //if (managedConn == null)
            //return;
        //try {
            //if (attemptReuse) {
                //wrappedEntity.consumeContent();
                //managedConn.markReusable();
            //}
        //} finally {
            //releaseManagedConnection();
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.346 -0400", hash_original_method = "7A0C9BF6AEBE62A6A7FD18951D7BE860", hash_generated_method = "BD56901B9360967D1E94CECF9D8A2CE6")
    @Override
    public void writeTo(final OutputStream outstream) throws IOException {
        addTaint(outstream.getTaint());
        super.writeTo(outstream);
        consumeContent();
        // ---------- Original Method ----------
        //super.writeTo(outstream);
        //consumeContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.346 -0400", hash_original_method = "4116E5CDB1EF6E698D2E6ADBA9E28033", hash_generated_method = "CCEB45ABA7930FB8F4049A36679817EB")
    public void releaseConnection() throws IOException {
        this.consumeContent();
        // ---------- Original Method ----------
        //this.consumeContent();
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.346 -0400", hash_original_method = "09E9D1BA9D6B3D57F6131522158659B5", hash_generated_method = "80A8079743AA59D5DF9755147664C19D")
    public void abortConnection() throws IOException {
    if(managedConn != null)        
        {
            try 
            {
                managedConn.abortConnection();
            } //End block
            finally 
            {
                managedConn = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (managedConn != null) {
            //try {
                //managedConn.abortConnection();
            //} finally {
                //managedConn = null;
            //}
        //}
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.347 -0400", hash_original_method = "5A64D16D6F2B869D7FBA53B05FD87C82", hash_generated_method = "CD38B8A2925EB43C0FF3DB171C8D671E")
    public boolean eofDetected(InputStream wrapped) throws IOException {
        addTaint(wrapped.getTaint());
        try 
        {
    if(attemptReuse && (managedConn != null))            
            {
                wrapped.close();
                managedConn.markReusable();
            } //End block
        } //End block
        finally 
        {
            releaseManagedConnection();
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_273662054 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_276156149 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_276156149;
        // ---------- Original Method ----------
        //try {
            //if (attemptReuse && (managedConn != null)) {
                //wrapped.close();
                //managedConn.markReusable();
            //}
        //} finally {
            //releaseManagedConnection();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.347 -0400", hash_original_method = "317830EACA4241C6C1785BE58FAD1AFA", hash_generated_method = "24E58FC3214E21D770F656F672783727")
    public boolean streamClosed(InputStream wrapped) throws IOException {
        addTaint(wrapped.getTaint());
        try 
        {
    if(attemptReuse && (managedConn != null))            
            {
                wrapped.close();
                managedConn.markReusable();
            } //End block
        } //End block
        finally 
        {
            releaseManagedConnection();
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_367484118 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_2114119067 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_2114119067;
        // ---------- Original Method ----------
        //try {
            //if (attemptReuse && (managedConn != null)) {
                //wrapped.close();
                //managedConn.markReusable();
            //}
        //} finally {
            //releaseManagedConnection();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.348 -0400", hash_original_method = "BAB258C2D5F3651DF9A25667D27EF99D", hash_generated_method = "3A009FCAE93B9364D4219DFA20AFC145")
    public boolean streamAbort(InputStream wrapped) throws IOException {
        addTaint(wrapped.getTaint());
    if(managedConn != null)        
        {
            managedConn.abortConnection();
        } //End block
        boolean var68934A3E9455FA72420237EB05902327_235363661 = (false);
                boolean var84E2C64F38F78BA3EA5C905AB5A2DA27_1242485212 = getTaintBoolean();
        return var84E2C64F38F78BA3EA5C905AB5A2DA27_1242485212;
        // ---------- Original Method ----------
        //if (managedConn != null) {
            //managedConn.abortConnection();
        //}
        //return false;
    }

    
    @DSGenerator(tool_name = "Doppelganger", tool_version = "0.4.2", generated_on = "2013-07-12 09:49:34.349 -0400", hash_original_method = "713B19D560033B1B50E26BAD17DD5FF2", hash_generated_method = "0CEB6928C118BF6301564F82313DE396")
    protected void releaseManagedConnection() throws IOException {
    if(managedConn != null)        
        {
            try 
            {
                managedConn.releaseConnection();
            } //End block
            finally 
            {
                managedConn = null;
            } //End block
        } //End block
        // ---------- Original Method ----------
        //if (managedConn != null) {
            //try {
                //managedConn.releaseConnection();
            //} finally {
                //managedConn = null;
            //}
        //}
    }

    
}

