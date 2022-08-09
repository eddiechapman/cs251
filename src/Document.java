
public class Document {
	
	private int docID;
	private String docName;
	
	//***************************************************************************
	
	public Document(int docID, String docName) {
		
		this.docID = docID;
		this.docName = docName;
		
	}
	
	//***************************************************************************
	
	public String getName() {
		
		return this.docName;
	}
	
	//***************************************************************************
	
	public int getID() {
		
		return this.docID;
		
	}
	
	//***************************************************************************
	
	@Override
	public String toString() {
		
		return String.valueOf(this.docID);
		
	}
	
	//***************************************************************************
	
	@Override
	public boolean equals(Object o) {
		
		if (o == this) {
			return true;
		}
		
		if (!(o instanceof Document)) {
			return false;
		}
		
		Document temp = (Document) o;
		
		return temp.docName.equals(this.docName) 
				&& temp.docID == this.docID;

	} // end equals
	
	
} // end class Document
