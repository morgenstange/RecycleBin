package robot;
import kareltherobot.*;

public class HorizontalRobot extends Robot implements RobotInterface{
	boolean movingWest = false; // instance variable should be declared up here
	public HorizontalRobot (int street, int avenue, Directions.Direction d, int beepers)
	{
		super(street, avenue, d, beepers);
	}

	private void keepMoving()
	{
			while(frontIsClear())
			{
				//both east and west movements in your program check for a clear path north
				//therefore this should only be used for north moving robot
				movingWest = false; // this was the last thing I figured out
				move();
			}
	}
	

	private void faceNorth()
	{
		while(!facingNorth())
		{
			turnLeft();
		}
	}

	/**
	 * @author jack buchanan
	 * 2-26-17
	 * @author james odonnell
	 * 3-1-17
	 * 
	 * this method solves the horizontal maze map
	 */
	public void start()
	{
		while(true)
		{
			while(frontIsClear())
			{
				keepMoving();
			}
			
			//tries to go right -- jack's original comment
			//jod** this note was actually very helpful in debugging your problem
			//check1 and check2 didn't do anything you only set them
			//then unset them at the end of the same conditional
			//your algorithm favors moving east
			while(!frontIsClear()&&!movingWest)
			{
				if(facingNorth()){
					turnLeft();
					turnLeft();
					turnLeft();
					
					if (frontIsClear())
					{
						System.out.println("move 2");
						move();
					}else{
						turnLeft();
						turnLeft();
					if (frontIsClear())
						System.out.println("move 3 sets movingWest to true");
						move();
						movingWest = true;
					}
					faceNorth();
				}
			}

			//when you are moving west you need to start each iteration with one turnLeft 
			//to face the robot west rather then east
			while(!frontIsClear() && movingWest)
				{
				System.out.println("1 goWest is: " + movingWest);
					faceNorth();
					if (frontIsClear())
					{
						movingWest = false;
						System.out.println("move 4 sets movingWest to false");
						move();
					}else{
						//I think if you were really clever you could use the same
						//while loop for both east and west moving robots
						//and put a conditional here for one left turn for west
						//and three for east
						turnLeft();
						if (frontIsClear())
						{

							System.out.println("move 5 movingWest unchanged");
							move();
							faceNorth();
						}
					}

					}
				}
			}
	}
