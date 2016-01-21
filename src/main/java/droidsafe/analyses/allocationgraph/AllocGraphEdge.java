package droidsafe.analyses.allocationgraph;

import soot.SootClass;

/**
 * Directed, two weighted, edge.
 * 
 * @author mgordon
 *
 */
public class AllocGraphEdge {
	private SootClass enclosing;
	private SootClass allocated;
	
	private double virtualWeight = 0.0;
	private double staticWeight = 0.0;
		
	
	public AllocGraphEdge(SootClass enclosing, SootClass allocated) {
		super();
		this.enclosing = enclosing;
		this.allocated = allocated;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allocated == null) ? 0 : allocated.hashCode());
		result = prime * result + ((enclosing == null) ? 0 : enclosing.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AllocGraphEdge other = (AllocGraphEdge) obj;
		if (allocated == null) {
			if (other.allocated != null)
				return false;
		} else if (!allocated.equals(other.allocated))
			return false;
		if (enclosing == null) {
			if (other.enclosing != null)
				return false;
		} else if (!enclosing.equals(other.enclosing))
			return false;
		return true;
	}

	public void incrementStaticWeight() {
		staticWeight += 1.0;
	}
	
	public void incrementVirtualWeight() {
		virtualWeight += 1.0;
	}

	public SootClass getEnclosing() {
		return enclosing;
	}

	public SootClass getAllocated() {
		return allocated;
	}

	public double getVirtualWeight() {
		return virtualWeight;
	}

	public double getStaticWeight() {
		return staticWeight;
	}
	
	
}
