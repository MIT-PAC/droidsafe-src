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

package droidsafe.analyses.infoflow;

import java.util.HashMap;
import java.util.Map;

import soot.Unit;

import droidsafe.main.Config;

public class InfoUnit implements InfoValue {
    private static Map<Unit, InfoUnit> unitToInfoUnit = new HashMap<Unit, InfoUnit>();

    Unit unit;

    private InfoUnit(Unit unit) {
        if (Config.v().strict) {
            assert unit != null;
        }
        this.unit = unit;
    }
    
    public Unit getUnit() {
        return unit;
    }

    static InfoUnit v(Unit unit) {
        if (Config.v().strict) {
            assert unit != null;
        }
        InfoUnit infoUnit = unitToInfoUnit.get(unit);
        if (infoUnit == null) {
            infoUnit = new InfoUnit(unit);
            unitToInfoUnit.put(unit, infoUnit);
        }
        return infoUnit;
    }
    
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof InfoUnit)) {
            return false;
        }
        InfoUnit that = (InfoUnit)object;

        return this.unit.equals(that.unit);
    }
    
    @Override
    public int hashCode() {
        return unit.hashCode();
    }
    
    @Override
    public String toString() {
        return unit.toString();
    }
}
