/**
* @author  Ben Schreyer
* @version 1.0
* @since   2020-08-30 
* This interface represents the actions that can be taken on a object that represents a bid on an AC system
*/
public interface AirConditioningBid {
	/**
	* @return A String object containing the name of the company
	* get the company name of the bid object
	*/
	
	String getCompanyName();
	/**
	* @param String containing the company's name
	* set the company name of the bid object
	*/
	
	void setCompanyName(String name);
	
	/**
	* @return A String object containing a description of the AC unit
	* get the AC unit description
	*/
	
	String getDescription();
	/**
	* @param String containing a description of the AC unit
	* set the AC unit description
	*/
	
	void setDescription(String description);
	
	/**
	* @return A float giving the rate of heat removal during AC operation
	* get the AC unit performance
	* At what rate does the AC unit remove heat from the building watts or joules/seconds.
	*/
	float getPerformance();
	
	/**
	* @param A float giving the rate of heat removal during AC operation
	* set the AC unit performance
	* At what rate does the AC unit remove heat from the building watts or joules/seconds.
	*/
	void setPerfomance(float performance);
	
	/**
	* @return A float representing the cost of the unit in USD
	* get cost of the air conditioning unit USD.
	*/
	float getUnitCost();
	
	/**
	* @param A float representing the cost of the unit in USD
	* set cost of the air conditioning unit USD.
	*/
	void setUnitCost(float cost);
	
	/**
	* @return A float representing the cost of installing the unit in USD
	* get cost of unit installation USD.
	*/
	float getInstallationCost();
	
	/**
	* @param A float representing the cost of installing the unit in USD
	* set cost of unit installation USD.
	*/
	void setInstallationCost(float cost);
	
	
}
