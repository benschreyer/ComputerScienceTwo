/**
* @author  Ben Schreyer
* @version 1.0
* @since   2020-08-30 
* This interface represents the actions that can be taken on a object that represents a collection of bids on an AC system
*/
public interface AirConditioningBidCollection {
	/**
	* @param An AirConditioningBid to add
	*/
	void addBid(AirConditioningBid add);
	
	/**
	* @param An AirConditioningBid to remove
	*/
	void removeBid(AirConditioningBid remove);
	
	/**
	* @param An array of AirConditioningBid to add
	*/
	void addBidArray(AirConditioningBid[] add);
	
	/**
	* @param The name of the company who's bids will be returned
	* @return An array of bids offered by a certain company
	*/
	AirConditioningBid[] getByCompany(String companyName);
	
	/**
	* @param A float representing the lowest acceptable performance unit bid to return, performance is watts
	* @param A float representing the highest acceptable performance unit bid to return, performance is watts
	* @return An array of bids that have performance in the specified range
	*/
	AirConditioningBid[] getByPerformanceRange(float low, float high);
	
	/**
	* @param A float representing the lowest acceptable total price of a unit bid to return, price in USD
	* @param A float representing the highest acceptable total price of a unit bid to return, price in USD
	* @return An array of bids that have performance in the specified range
	*/
	AirConditioningBid[] getByTotalPriceRange(float low, float high);
	
	/**
	* @param A float representing the lowest acceptable unit price of a unit bid to return, price in USD
	* @param A float representing the highest acceptable unit price of a unit bid to return, price in USD
	* @return An array of bids that have performance in the specified range
	*/
	AirConditioningBid[] getByUnitPriceRange(float low, float high);
	
	/**
	* @param A float representing the lowest acceptable installation price of a unit bid to return, price in USD
	* @param A float representing the highest acceptable installation price of a unit bid to return, price in USD
	* @return An array of bids that have performance in the specified range
	*/
	AirConditioningBid[] getByInstallPriceRange(float low, float high);
	/**
	* @return all bids in the collection
	*/
	AirConditioningBid[] getAll();
}
