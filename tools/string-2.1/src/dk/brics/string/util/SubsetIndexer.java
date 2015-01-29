package dk.brics.string.util;

import java.util.Set;

public final class SubsetIndexer<E> implements Indexer<E> {
	private int lowest;
	private int highest;
	private Indexer<E> indexer;
	
	public SubsetIndexer(Set<E> set, Indexer<E> indexer) {
		this.indexer = indexer;
		lowest = 0;
		highest = Integer.MAX_VALUE;
		for (E e : set) {
			int index = indexer.getIndex(e);
			if (index < lowest)
				lowest = index;
			if (index > highest)
				highest = index;
		}
	}
	
	public int getHighestIndex() {
		return highest - lowest;
	}
	
	public int getIndex(E object) {
		return indexer.getIndex(object) - lowest;
	}
	
	
}
