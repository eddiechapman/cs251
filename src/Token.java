import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Token {
	
	private String token;
	private Map<Document, List<Integer>> positionalIndex;

	//***************************************************************************
	
	public Token(String str) {
		
		token = str;
		positionalIndex = new HashMap<>();
		
	}
	
	//***************************************************************************
	
	/**
	 * Get the positions of the Token for the document passed in.
	 * If the Token has no positions in the document, meaning there is no Map from the doc to the list, return null.
	 * 
	 * @param doc
	 * @return list of integers or null
	 */
	public List<Integer> getPositions(Document doc) {
		
		if (!positionalIndex.containsKey(doc)) {
			return null;
		}
		
		return positionalIndex.get(doc);
		
	} // end getPositions
	
	//***************************************************************************

	/**
	 * Sets the position of the Token in the document passed in.
	 * If doc already occurs in the postionalIndex, it means the token has already appeared in the document.
	 * If doc doesn't exist in positionalIndex, it means this is the first time the token appeared in the document.
	 * How can you check for this?
	 * After checking, what should be done for either case to make sure the list of integers is correct?
	 * 
	 * @param doc
	 * @param p
	 */
	public void setPositions(Document doc, Integer p) {
		
		if (positionalIndex.get(doc) == null) {
			positionalIndex.put(doc, new ArrayList<Integer>());
		}
		
		if (!positionalIndex.get(doc).contains(p)) {
			positionalIndex.get(doc).add(p);
		}

	} // end setPositions
	
	//***************************************************************************

	@Override
	public String toString() {
		
		return token;
		
	} // end toString
	
	//***************************************************************************
	
	@Override
	public boolean equals(Object o) {
		
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof Token)) {
			return false;
		}
		
		Token temp = (Token) o;
		
		return temp.toString().equals(this.toString());

	} // end equals

} // end class token
