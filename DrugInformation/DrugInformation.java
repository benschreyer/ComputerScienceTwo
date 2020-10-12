//Ben Schreyer 9/30/2020
public interface DrugInformation {
	//Add a drug to list of drugs, true if the drug was added false if is already documented
	public boolean addDrug(String name);
	
	//Check whether a drug is in the list, true if the drug is in the list
	public boolean isDocumented(String name);
	
	//add a side effect to a drug's list of side effects, returns false if the drug is not in the structure
	public boolean addSideEffect(String drugName, String sideEffect);
	
	//remove a drug from the documents, return false if the drug doesn't exist
	public boolean removeDrug(String name);
	
	//remove a side effect of a drug, returns false if the drug was not found or the side effect was not found
	public boolean removeSideEffect(String drugName, String sideEffect);
	
	//returns an empty array if the drug does not exist or has not side effects listed, otherwise each entry is a side effect of the drug
	public String[] getSideEffects(String name);
	
	//returns number of listed side effects, -1 if the drug doesnt exist
	public int sideEffectCount(String name);
}
