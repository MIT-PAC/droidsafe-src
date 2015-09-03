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

package droidsafe.utils;

import java.io.Serializable;

public class IntRange implements Comparable, Serializable {

    private static final long serialVersionUID = -509438439792027883L;

    public int min;
    public int max;
    
    public IntRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof IntRange) {
            IntRange other = (IntRange) o;
            int diff = this.min - other.min;
            if (diff == 0)
                diff = this.max - other.max;
            return diff;
        }
        return -1;
    }
    
    public String toString() {
        return "[" + min + ", " + max + "]";
    }

}
