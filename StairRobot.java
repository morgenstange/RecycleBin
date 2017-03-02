package robot;
import kareltherobot.*;

public class StairRobot extends UrRobot implements Directions{

	public StairRobot (int street, int avenue, Directions.Direction d, int beepers)
	{
		super(street, avenue, d, beepers);
	}
	
	/**
	 * @author jack buchanan
	 * 2-22-17
	 * 
	 * solves the staircase maze
	 */
	public void start(){
		while(true)
		{
			move();
			turnLeft();
			turnLeft();
			turnLeft();
			move();
			turnLeft();
		}
	}
	}

