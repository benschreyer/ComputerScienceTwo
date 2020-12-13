


import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Town_STUDENT_Test {
	
	private Town t;
	@Before
	public void setUp() throws Exception 
	{
		t = new Town("Test###$$$%%%123");
	}

	@After
	public void tearDown() throws Exception 
	{
	
	}

	@Test
	public void testConstruction()
	{
		
		assertEquals(t.getName(),"Test###$$$%%%123");
	}
	
	@Test
	public void testSetName()
	{
		t.setName("4");
		assertEquals(t.getName(),"4");
	}
	
	@Test
	public void testSetDistance()
	{
		t.setDistance(3);
		assertEquals(t.getDistance(),3);
	}
	
	@Test
	public void testEquals()
	{
		assertTrue(new Town("a").equals(new Town("a")));
	}
	
	@Test 
	public void testAdjacency()
	{
		Town f = new Town("F");
		t.addAdjacency(f, 13);
		assertEquals(t.getWeightTo(f), 13);
	}
	
	@Test
	public void testShortestPath()
	{
		t.getShortestPath().add(new Town("abc"));
		assertTrue(t.getShortestPath().get(0).equals(new Town("abc")));

	}
}
