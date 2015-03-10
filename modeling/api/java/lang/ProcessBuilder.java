/* Licensed to the Apache Software Foundation (ASF) under one or more
 * Copyright (C) 2015,  Massachusetts Institute of Technology
 * 
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the
 * Free Software Foundation; either version 2 of the License, or (at your
 * option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc., 
 * 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * 
 * Please email droidsafe@lists.csail.mit.edu if you need additional
 * information or have any questions.
 * 
 * 
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


/***** THIS FILE HAS BEEN MODIFIED FROM THE ORIGINAL BY THE DROIDSAFE PROJECT. *****/


package java.lang;
     
import droidsafe.runtime.*;
import droidsafe.helpers.*;
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
    
    /*
    @DSSink({DSSinkKind.OS_COMMAND})
    @DSSource({DSSourceKind.OS_PROCESS})
    */
    public ProcessBuilder(String[] command)
    {
        command(command);
    }
    
    /*
    @DSSource({DSSourceKind.OS_PROCESS})
    @DSSink({DSSinkKind.OS_COMMAND})
    */
    public ProcessBuilder(List<String> command) { 
        command(command);
    }
    
    /* we have to make it a SINK or we will need to do a replacement later */
    @DSComment("No action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.OS_COMMAND})
    @DSSource({DSSourceKind.OS_PROCESS})
    
    public List<String> command() { 
        List<String> ret = new LinkedList<String>();
        ret.add(commands);
        return ret;
    }
    
    @DSComment("No action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSink({DSSinkKind.OS_COMMAND})
    @DSSource({DSSourceKind.OS_PROCESS})
    public ProcessBuilder command(String[] command) { 
        this.commands = "";

        for (int i = 0; i < command.length; i++)
            this.commands += command[i];
        
        return this;
    }
    
    @DSComment("No action")
    @DSSafe(DSCat.SAFE_OTHERS)
    @DSSource({DSSourceKind.OS_PROCESS})
    @DSSink({DSSinkKind.OS_COMMAND})
    public ProcessBuilder command(List<String> command) { 
        this.commands = "";

        for (String cmd : command)
            this.commands += cmd;
        
        return this;
    }
    
    public File directory() { 
        return dir;
    }
    
    public ProcessBuilder directory(File directory) { 
        this.dir = directory;
        return this;
    }
    
    public Map<String, String> environment() { 
        return new HashMap<String,String>();
    }
    
    public boolean redirectErrorStream() {
        return getTaintBoolean();
    }
    
    public ProcessBuilder redirectErrorStream(boolean redirectErrorStream) { 
        this.addTaint(redirectErrorStream);
        return this;
    }
    
    @DSSpec(DSCat.OS_LOW_LEVEL)
    @DSSink({DSSinkKind.OS_COMMAND})
    @DSSource({DSSourceKind.OS_PROCESS})
    public Process start() throws IOException { 
        DroidSafeProcess process = new DroidSafeProcess();
        process.addTaint(commands.getTaint());
        return process;
    }
}
