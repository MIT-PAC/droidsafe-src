package java.lang;
     
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.LinkedList;
import java.util.HashMap;

import droidsafe.concrete.*;
import droidsafe.annotations.*;
     
public final class ProcessBuilder
{
    @DSVAModeled
    String commands;

    File dir = new File("ProessBuilder-dir");
    
    @DSModeled(DSC.SAFE)
    public ProcessBuilder(String[] command)
    {
        command(command);
    } 

    @DSModeled(DSC.SAFE)
    public ProcessBuilder(List<String> command) { 
        command(command);
    } 

    @DSModeled(DSC.SAFE)
    public List<String> command() { 
        List<String> ret = new LinkedList<String>();
        ret.add(commands);
        return ret;
    } 

    @DSModeled(DSC.SAFE)
    public ProcessBuilder command(String[] command) { 
        this.commands = "";

        for (int i = 0; i < command.length; i++)
            this.commands += command[i];
        
        return this;
    } 

    @DSModeled(DSC.SAFE)
    public ProcessBuilder command(List<String> command) { 
        this.commands = "";

        for (String cmd : command)
            this.commands += cmd;
        
        return this;
    } 

    @DSModeled(DSC.SAFE)
    public File directory() { 
        return dir;
    } 

    @DSModeled(DSC.SAFE)
    public ProcessBuilder directory(File directory) { 
        this.dir = directory;
        return this;
    } 

    @DSModeled(DSC.SAFE)
    public Map<String, String> environment() { 
        return new HashMap<String,String>();
    } 

    @DSModeled(DSC.SPEC)
    public boolean redirectErrorStream() {
        return getTaintBoolean();
    } 

    @DSModeled(DSC.SPEC)
    public ProcessBuilder redirectErrorStream(boolean redirectErrorStream) { 
        this.addTaint(redirectErrorStream);
        return this;
    } 

    @DSModeled(DSC.SPEC)
    public Process start() throws IOException { 
        return new DroidSafeProcess();
    }
}
