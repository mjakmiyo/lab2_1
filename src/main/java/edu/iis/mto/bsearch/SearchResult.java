/**
 * 
 */
package edu.iis.mto.bsearch;

public class SearchResult {

	private static final int NOT_FOUND = -1;
	private int position = NOT_FOUND;
	private int numberOfIteration = 0;

	public boolean isFound() {
		return position > NOT_FOUND;
	}

	void setPosition(int position) {
		if (position > NOT_FOUND) {
			this.position = position;
		}
	}

	public int getPosition() {
		return position;
	}

	public int getNumberOfIteration() {
		return numberOfIteration;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof SearchResult) {
			return this.position == ((SearchResult) obj).position;

		}
		return false;
	}

	public void setNumberOfIteration(int numberOfIteration) {
		this.numberOfIteration = numberOfIteration;
	}

	@Override
	public String toString() {

		return isFound() ? "( elem at position " + position + ")"
				: "elem not found";
	}
}