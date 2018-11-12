
public class Document 
{
	private int docID;
	private String docName;
	
	//***************************************************************************
	
	public Document(int docID, String docName) 
	{
		this.docID = docID;
		this.docName = docName;
	}
	
	//***************************************************************************
	
	public String getName()
	{
		return this.docName;
	}
	
	//***************************************************************************
	
	public int getID()
	{
		return this.docID;
	}
	
	//***************************************************************************
	
	@Override
	public String toString()
	{
		
	}
	
	//***************************************************************************
	
	@Override
	public boolean equals(Object o)
	{
		
	}
	
	
} // end class Document
