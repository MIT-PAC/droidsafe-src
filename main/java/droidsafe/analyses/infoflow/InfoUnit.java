package droidsafe.analyses.infoflow;

import java.util.HashMap;
import java.util.Map;

import soot.Unit;

public class InfoUnit implements InfoValue {
    private static Map<Unit, InfoUnit> unitToInfoUnit = new HashMap<Unit, InfoUnit>();

    Unit unit;

    private InfoUnit(Unit unit) {
        assert unit != null;
        this.unit = unit;
    }
    
    public Unit getUnit() {
        return unit;
    }

    static InfoUnit v(Unit unit) {
        assert unit != null;
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
