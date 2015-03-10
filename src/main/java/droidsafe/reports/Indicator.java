/*
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
 */

package droidsafe.reports;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import soot.SootMethod;
import soot.jimple.Stmt;

import com.google.gson.annotations.SerializedName;

import droidsafe.utils.JimpleRelationships;
import droidsafe.utils.SootUtils;
import droidsafe.utils.SourceLocationTag;

public class Indicator<T> {

    @SerializedName("indicator-type")
    String indicator_type;
    Map<String, Boolean> visibility = new HashMap<String,Boolean>();
    Map<String, Boolean> display = new HashMap<String,Boolean>();
    ArrayList<T> contents = new ArrayList<T>();
    
    public Indicator(String type) { 
        indicator_type = type;
    }
    
    public void addContents(T t) {
        contents.add(t);
    }
    
    public void addVisibility(String str) {
        visibility.put(str, true);
    }
    
    public void removeVisibility(String str) {
        visibility.put(str, false);
    }
    
    public void addDisplay(String str) {
        display.put(str, true);
    }
    
    public void removeDisplay(String str) {
        display.put(str, false);
    }
    
   
}
