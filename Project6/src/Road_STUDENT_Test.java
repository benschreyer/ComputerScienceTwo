


import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Road_STUDENT_Test {
	
	private Road r;
	private Town a;
	private Town b;
	@Before
	public void setUp() throws Exception 
	{
		a = new Town("town_a");
		b = new Town("town_b");
		r = new Road(a, b, 45, "road");
		
	}

	@After
	public void tearDown() throws Exception 
	{
	
	}

	@Test
	public void testConstruction()
	{
		
		assertEquals(r.getName(),"road");
		assertEquals(r.getWeight(), 45);
		assertTrue(r.getConnections().contains(a)&&r.getConnections().contains(b));
	}
	
	
	@Test
	public void testEquals()
	{
		assertTrue(new Road(a, b, 45, "road").equals(r));
	}
	

}
