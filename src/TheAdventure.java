import java.util.ArrayList;
import java.util.Scanner;

//Author: Walker Brown
//Date:9/11/14
//Class: CS192
//Email: wbrown64@rams.colostate.edu
//
//
////Welcome to my major project.  It is a text based adventure game based in a small house.  To begin, I beleive the way I wrote the code is fairly 
//innefective for such a large and multi-option
//type setting.  The massive if/else statements tend to build up and may require you input code a second time, for the most part though, 
//if your input isn't working it's probably not in the system, intended so.  For the sake of exploration and readability 
//// I will explain the layout and correct text input to get through the game, as well as explaining all the tedious points.  If you are 
////trying to play this game for entertainments sake, DO NOT READ THE FOLLOWING PORTION IT WILL GIVE IT ALL AWAY TAKING AWAY ALL THE FUN
//for the rest of you, here we go. The first room is small, look around and gather the important items, 'key' to exit room, and look at 'letter'
//to learn how to combine objects(important later in game).  In the 2nd room you have the option to go into 2 rooms or the back yard.  Also in 
// the room is a safe, where you must enter the code given to you on the letter, to get you the
//laptop, t.v., and cat.  All unimportant except for the glass of blue liquid on the counter.  Take this and DONT DRINK
//it will kill you when you go outside.  In the first room nothing is important except for the lighter, water bottle, and batman mask(if you want 100x points)
//room two is a dud except for the batman mask which is required to pass the game, to get in here you need the key from outside
//outside is an unimportant key and a hatch.  In the hatch lies the basement room, where a lone plant lies next to a drainage pipe.
//After combining the water bottle and glass of blue liquid to get water bottle of blue liquid, use that with the plant to make it glow.  THen 
//use the flashlight and NOT THE LIGHTER to promote the effect.  Using lighter or using glass of blue water (without bottle) will kill you  Soon aliens will come and solve the game.....
//


public class TheAdventure {

	public static void main(String[] args) {
		//create world
		  World world = new World();
		//create title screen
		  world.title();
		//load world 1...
		  world.a1();
		
	}
	public static class World  {
		boolean blueLiquid=true;
		boolean drankLiquid=false;
		boolean batmanMask=false;
		boolean aliensIncoming=false;
		
		
		void title(){
			Scanner input= new Scanner(System.in);
			System.out.println("+---------------------------------------------+");
			System.out.println("|  Text Adventure: The House Down the Street  |");
			System.out.println("+---------------------------------------------+");
			System.out.println("");
			System.out.println("");
			System.out.println("What is your name?");
			System.out.print("-");
			String userName=input.next();
			System.out.println("Nice to meet you, "+userName);
		}
		//extra commands?
		
		//load player inventory
		static Backpack backpack = new Backpack();
		
		//start
		
		void a1(){
			Area a1=new Area();
			a1.setRoom(1);
			a1.setName("Mudroom");
			a1.setDescription("A small clustered room with a windows and a door.  A box lies in the corner next to an old bike and desk");
			a1.setCount(1);
			ArrayList<String> a1Items=new ArrayList<String>();
			ArrayList<String>boxItems=new ArrayList<String>();
			a1Items.add("desk");
			a1Items.add("old bike");
			boxItems.add("key");
			a1Items.add("box");
			a1Items.add("old comic book");
			boxItems.add("letter");
			boolean isOpen=false;
			a1.setItems(a1Items);
			System.out.println("You walk into a house, the first room is small and seperated from the rest of the house.");
			System.out.println("If you have any questions use the ~ button.  Good luck!");
			a1.printItems(a1Items);
			
			//take input and gooooo!
			Scanner command =new Scanner(System.in);
			
			String input=getInput();
			while(input!="quit"){
			
				if(input.equals("look around")||input.equals("look")){
					System.out.println(a1.
							getDescription());
					a1.printItems(a1Items);
				}
				//get items
				else if(input.equals("take letter")&&boxItems.contains("letter")){
					boxItems.remove("letter");
					this.backpack.add("letter");
					
				}
				else if (input.equals("take key")&&!boxItems.contains("key")) {
                    System.out.println("You already have the key");
                }
				else if(input.equals("open box")){
					System.out.println("A couple old cans, a lacrosse ball, letter, and a key");
					}
				else if(input.equals("take key")&&boxItems.contains("key")){
						this.backpack.add("key");
						boxItems.remove("key");
						
					}	
				else if(input.equals("read letter")||input.equals("open letter")){
						System.out.println(" 'To combine items use the WITH command.  ex.  use peanut butter with jelly.  Produces PB&J sandwich ' ");
						System.out.println("At the bottom lies the digits '0129'");
					}
				else if(input.equals("take letter")){
					this.backpack.add("letter");
					a1Items.remove("letter");
				}
				else if(input.equals("take lacrosse balls")||input.equals("take lacrosse ball")||input.equals("take cans")){
						System.out.println("Lacrosse balls and old cans can't help you here.");
					}
				
				else if(input.equals("read old comic book")||input.equals("open old comic book")){
					System.out.println("*The Amazing Spider Man: Vol. 72*");
					System.out.print(".");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print(".");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print(".");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print(".");
					
					
				}
				else if(input.equals("take desk")||input.equals("take old bike")||input.equals("take old comic book")){
					System.out.println("Leave that alone");
				}
				//save game?
				else if(input.equals("open door")&&isOpen==false||input.equals("leave")){
				System.out.println("The door is locked");
					}
				else if(input.equals("use key")&&backpack.isInBkp("key")){
					isOpen=true;
					System.out.println("The lock clicks...");
				}
				else if(input.equals("open door")||input.equals("leave")&&isOpen==true){
					this.a2();
				}
				
				 // Catch-all for unavailable actions
                else if (systemCommand(input)==false) {
                    System.out.println("You can't do that.");
                }
				input=getInput();	
			}
			
		}
		

		void a2()  {
			
			
			Area a2=new Area();
			a2.setRoom(2);
			a2.setName("Living room");
			a2.setDescription("A room with furniture and three doors along the length labeled 1 and 2.  A cat purrs on the couch and footprints lead out the back door(3)");
			a2.setCount(2);
			ArrayList<String> a2Items =new ArrayList<String>();
			ArrayList<String>safeItems=new ArrayList<String>();
			a2Items.add("T.V.");
			a2Items.add("scissors");
			a2Items.add("glass of blue liquid");
			a2Items.add("laptop computer");
			a2Items.add("safe");
			safeItems.add("key1");
			
			System.out.println("You are in a living room void of any source of humanity besides a furry feline staring from the couch.");
			String input=getInput();
			boolean isOpen1=false;
			while(input!="quit"){
				
				
				if(input.equals("look around")||input.equals("look")){
					System.out.println(a2.getDescription());
					a2.printItems(a2Items);
				}
				else if(input.equals("open safe")||input.equals("use safe")){
					System.out.println("There is a 4-digit combination lock on the safe");
				}
				
				else if(input.equals("use safe")||input.equals("open safe")){
					a2.printItems(safeItems);
				}
				
				else if(input.equalsIgnoreCase("use T.V.")||input.equalsIgnoreCase("use T.V")){
					System.out.println("Some hockey game playing...");
					 try {
						Thread.sleep(1000);
					} catch (InterruptedException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					System.out.println("..."); 
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("...");
					 try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						System.out.println("error");
					}
					
					System.out.println("Someones having a rough day!");
					}
				else if(input.equals("take scissors")){
					a2Items.remove("scissors");
					System.out.println("carefull");
				}
				else if(input.equals("use scissors")){
					System.out.println("it's not the time for that");
				}
				else if(input.equals("use glass of liquid")||input.equals("use glass")||input.equals("drink liquid")||input.equals("use glass of blue liquid")){
					System.out.println("*lukewarm and bubbly*");
					System.out.println("...");
					System.out.println("you feel alert");
					drankLiquid=true;
				}
				else if(input.equals("take liquid")||input.equals("take glass of blue liquid")||input.equals("take blue liquid")||input.equals("take glass of liquid")){
					System.out.println("this could come in handy, better not spill it");
					a2Items.remove("glass of blue liquid");
					backpack.add("glass of blue liquid");
					blueLiquid=false;
				}
				else if(input.equalsIgnoreCase("use laptop computer")||input.equals("use laptop")){
					System.out.println("it's password protected");
					System.out.println("I wonder who Treb Begay is?");
					
				}
				else if(input.equals("take laptop")||input.equals("take laptop computer")){
					System.out.println("it's not nice to steal things");
				}
				else if(input.equals("take cat")||input.equals("fuck cat")||input.contains("diddy")){
					System.out.println("the animal springs into another room");
				}
				else if (input.equals("use water bottle with glass of blue liquid")||input.equals("use glass of blue liquid with water bottle")
						||input.equals("use water bottle with blue liquid")&&backpack.bkp.contains("glass of blue liquid")){
					System.out.println("You now have a bottle of blue liquid");
					backpack.add("bottle of blue liquid");
					
				}
				
				else if(input.equals("0129")){
					System.out.println("The safe opens and there lies a lone key! Practically leaps to your hand");
					safeItems.remove("key1");
					backpack.add("key1");
					
				}
				else if(input.equals("open door 1")||input.equals("open door one")){
					System.out.println("You glimpse someone walk in the back door");
					this.a3();
				}
			
				
				else if(input.equals("open door 2")||input.equals("open door two")&&isOpen1==true){
					this.a4();
				}
				
				else if(input.equals("open door 3")||input.equals("open door three")){
					System.out.println("Fresh air is nice");
					this.a6();
				}
				 
				else if (!systemCommand(input)) {
	                System.out.println("You can't do that.");
	            }
				
				input=getInput();
				//get 
			}
		}
		void a3(){


					Area a3=new Area();
					a3.setRoom(3);
					a3.setName("Trebs room");
					a3.setDescription("A small room crowded with chairs and a couch on the floor.  Another T.V. sits in the corner adjacent to 2 guitars on the wall.");
					a3.setCount(3);
					ArrayList<String> a3Items =new ArrayList<String>();
					a3Items.add("lighter");
					a3Items.add("flashlight");
					a3Items.add("water bottle");
					
					System.out.println("It's cluttered and kind of smelly..There are paw stains on the window and the fan has way too much dust on it");
					
					String input=getInput();
					
			while(input!="quit"){
			if(input.equals("look around")){
				System.out.println(a3.getDescription());
				a3.printItems(a3Items);
			}
			
		
			else if(input.equals("take water bottle")){
				backpack.add("water bottle");
				a3Items.remove("water bottle");
			}
			else if (input.equals("use water bottle with glass of blue liquid")||input.equals("use glass of blue liquid with water bottle")||input.equals("use water bottle with blue liquid")&&backpack.bkp.contains("glass of blue liquid")){
				System.out.println("You now have a bottle of blue liquid");
				backpack.add("bottle of blue liquid");
				
			}
			else if(input.equals("take lighter")){
				System.out.println("You're getting quite the collection");
				backpack.add("lighter");
				a3Items.remove("lighter");
			}
			else if(input.equals("take flashlight")){
				System.out.println("Going for an adventure?");
				backpack.add("flashlight");
				a3Items.remove("flashlight");
			}
			else if(input.equals("use guitar")){
				System.out.println("You shred a couple lines of Jimi Hendrix, nice.");
			}
			else if(input.equals("open door")||input.equals("leave")){
				System.out.println("The door won't open");
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(".");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(".");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.print(".");
			
				
				System.out.println("Ah finally! Must of gotten stuck somehow.");
			
				this.a2();
			}
			else if (input.equals("use water bottle with glass of blue liquid")||input.equals("use water bottle with blue liquid")&&backpack.bkp.contains("glass of blue liquid")){
				System.out.println("You now have a bottle of blue liquid");
				backpack.add("bottle of blue liquid");
				
			}
			
			
			else if (!systemCommand(input)) {
                System.out.println("You can't do that.");
            }
			input=getInput();
			}
			
	}
		//marcellas room
		void a4(){
			Area a4=new Area();
			a4.setRoom(3);
			a4.setName("Master bedroom");
			a4.setDescription("A nicely spaced room with picture on the walls and clothes on the bed.  Looks as if someone slept here last night");
			a4.setCount(3);
			ArrayList<String> a4Items =new ArrayList<String>();
			a4Items.add("clothes");
			a4Items.add("batman mask");
			
			System.out.println("This room smells lovely.");
			String input=getInput();
			while(input!="quit"){
			if(input.equals("look around")||input.equals("look")){
				System.out.println(a4.getDescription());
				a4.printItems(a4Items);
			}
			else if(input.equals("take pictures")||input.equals("take clothes")){
				System.out.println("Better not do that");
			}
			
			else if(input.equals("leave")||input.equals("open door")){
				this.a2();
			}
		
			else if(input.equals("take batman mask")||input.equals("take mask")){
					System.out.println("this could come in handy..");
					backpack.add("batman mask");
					a4Items.remove("batman mask");
				}
			else if (input.equals("use water bottle with glass of blue liquid")||input.equals("use glass of blue liquid with water bottle")||input.equals("use water bottle with blue liquid")&&backpack.bkp.contains("glass of blue liquid")){
				System.out.println("You now have a bottle of blue liquid");
					backpack.add("bottle of blue liquid");
					
				}
			 else if (systemCommand(input)==false) {
                 System.out.println("You can't do that.");
                 
			 }
			input=getInput();
			}
			
			
		
	}
		
		//back yard
		void a6() {
			Area a6=new Area();
			a6.setName("Backyard");
			a6.setDescription("Nice piece of land, mostly barren with an apple tree growing up from the ground.  A mysterious hatch lies underneath the verander.");
			ArrayList<String> a6Items =new ArrayList<String>();
			a6Items.add("key");
			System.out.println("The day is cloudy and dangerous");
			String input=getInput();
			boolean isOpen1=true;
			while(input!="quit"&&drankLiquid==false&&aliensIncoming==false){
			
			
			 if(input.equals("take key")){
				backpack.add("key2");
				System.out.println("So many of these things");
			}
			else if(input.equals("look around")||input.equals("look")){
				System.out.println(a6.getDescription());
				a6.printItems(a6Items);
			}
			else if(input.equals("use key")&&backpack.isInBkp("key1")){
				
				System.out.println("The lock clicks...");
			}
			
			else if (input.equals("use water bottle with glass of blue liquid")||input.equals("use glass of blue liquid with water bottle")||input.equals("use water bottle with blue liquid")&&backpack.bkp.contains("glass of blue liquid")){
				System.out.println("You now have a bottle of blue liquid");
				backpack.add("bottle of blue liquid");
				
			}
			else if(input.equals("open hatch")||input.equals("use hatch")&&backpack.bkp.contains("key1")){
			this.a7();
			}
			else if(input.equals("open hatch")||input.equals("use hatch")&&!backpack.bkp.contains("key1")){
				System.out.println("Only the mightiest of keys can open this lock!");
				}
			else if(input.equals("leave")||input.equals("open door")){
				this.a2();
			}
			 else if (systemCommand(input)==false) {
                 System.out.println("You can't do that.");
             }
			
			 
			input=getInput();
			}
			while(input!="quit"&&aliensIncoming==true&&drankLiquid==false){
				
				if(input.equals("look around")){
					System.out.println("The world is a hazy purple, leaves and dust are being pushed into the air by some large hovercraft");
				}
				else if(input.equals("open hatch")||input.equals("use hatch")){
					System.out.println("The hatched jammed!!  Looks like I'm stuck up here");
				}
				else if(input.equals("leave")||input.equals("open door")){
					this.a2();
				}
				else if(input.equals("help")){
					System.out.println("You need something else to make contact!");
				}
				else if(input.equals("use batman mask")&&backpack.bkp.contains("batman mask")){
					System.out.println("The flying saucer comes down and sucks you in through a golden particle wall.  Goodbye earthling!");
					System.out.println("THE END");
					 try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print(".");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print(".");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print(".");
					
						restart();
				}
				
				
			
				input=getInput();
			}
		
			if(input.equals("look around")||input.equals("open hatch")||input.equals("use hatch")||input.equals("leave")||input.equals("open door")&&drankLiquid==true){
				System.out.println("Your vision becomes fuzzy.  Soon after you fall over and die.  The End!");
				restart();
			}
		
			input=getInput();
		
			
		}
		void a7(){
			Area a7=new Area();
			a7.setName("Basement");
			a7.setDescription("Can't see much down here");
			ArrayList<String> a7Items =new ArrayList<String>();
			a7Items.add("green plant");
			a7Items.add("drainage pipe");
			a7Items.add("dirt");
			System.out.println("Damp and dark down here, a cool breeze blows as dripping noises come from the far corner");
			String input=getInput();
			backpack.bkp.add("flashlight");
			backpack.bkp.add("lighter");
			backpack.bkp.add("bottle of blue liquid");
			backpack.bkp.add("glass of blue liquid");
			boolean plantIsReady=false;
			
			while(input!="quit"){
				if(input.equals("look around")||input.equals("look")){
					System.out.println(a7.getDescription());
					a7.printItems(a7Items);
				}
				else if(input.equals("use flashlight")&&backpack.bkp.contains("flashlight")&&plantIsReady==false){
					System.out.println("The room is illuminated");
					System.out.println("A small drainage pipe opens in the corner, with area of damp soil leading to a lone plant.  Otherwise the room is empty.");
				}
				else if(input.equals("use lighter")&&backpack.bkp.contains("lighter")){
					System.out.println("You apply fire to the plant, it smolders and some weird odor comes from the plant, uh oh!");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print(".");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print(".");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print(".");
					System.out.println("You keel over and die");
				restart();
			
				}
				else if(input.equals("use glass")||input.equals("use glass of blue liquid")&&!backpack.bkp.contains("glass of blue liquid")){
					System.out.println("The liquid floods onto the plant, soaking its ruits and soon shriveling it to a golden yellow noodle");
					backpack.bkp.remove("glass of blue liquid");
					System.out.println("Some weird odor is coming from the plant, uh oh!");
					try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print(".");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print(".");
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.print(".");
						System.out.println("You keel over and die");
					restart();
				}
				else if (input.equals("use water bottle with glass of blue liquid")||input.equals("use glass of blue liquid with water bottle")||input.equals("use water bottle with blue liquid")&&backpack.bkp.contains("glass of blue liquid")){
					System.out.println("You now have a bottle of blue liquid");
					backpack.add("bottle of blue liquid");
					
				}
				else if(input.equals("use bottle")||input.equals("use blue liquid")||input.equals("use bottle of blue liquid")&&backpack.bkp.contains("bottle of blue liquid")){
					System.out.println("The water bottle allows you to use the perfect amount of liquid, the plant responds well and seems to become brighter");
					backpack.bkp.remove("bottle of blue liquid");
					plantIsReady=true;
				
					
				}
				else if(input.equals("use flashlight")&&backpack.bkp.contains("flashlight")&&plantIsReady==true){
					System.out.println("You apply light to the plant, a thin glow spreads over the plant and then disappears in a bright shine...");
					System.out.println("The ground begins to rumble, time to go!");
					aliensIncoming=true;
					
				}
				else if(input.equals("leave")||input.equals("open door")){
					this.a6();
				}
				
				else if (systemCommand(input)==false) {
	                    System.out.println("You can't do that.");
	                
				
			
				}	
				input=getInput();	
			}
			
			
		
		
	}
	}
		
	
	
	 public static String getInput() {
		 
	        // Prompt and read input
	        System.out.print("> ");
	        Scanner in = new Scanner(System.in);
	        String input = in.nextLine();
	 
	        // Format input
	       
	 
	        // Re-prompt if input is empty or gibberish
	        while (notValidCommand(input)) {
	            System.out.print("> ");
	            input = in.nextLine();
	           
	        }
	 
	        // If system command is typed, send to systemCommandResponses method
	        if (systemCommand(input)) {
	            systemCommandAnswer(input);
	        }
	 
	        return input;
	    }
	
	 public static boolean notValidCommand(String input) {
		 
	        // If command is valid, input is not empty or gibberish
	        if ((actionCommand(input) || systemCommand(input))) {
	            return false;
	        }
	        // Otherwise, provide responses if empty or gibberish
	        else if (input.isEmpty()) {
	            System.out.println("Cat got your tongue?");
	        } else if(actionCommand(input)==false) {
	            System.out.println("I don't understand.");
	        }
	 
	        return true;
	    }
	 public static boolean actionCommand(String input) {
		  if (input.contains(" ")) {
	            input = input.substring(0, input.indexOf(' '));
	        }
	  
	        // Define valid action commands
	 ArrayList <String>Command=new ArrayList <String>();
	 Command.add("look");
	 Command.add("take");
	 Command.add("drop");
	 Command.add("leave");
	 Command.add("read");
	 Command.add("open");
	 Command.add("look around");
	 Command.add("backpack");
	 Command.add("save");
	 Command.add("use");
	 Command.add("0129");
	        // Check for valid action command
	        return Command.contains(input);
	    }
	  public static boolean systemCommand(String input) {
		  
	        // Extract command from input (all letters before space)
	        if (input.contains(" ")) {
	            input = input.substring(0, input.indexOf(' '));
	        }
	 
	        // Define valid system commands
	        String[] commands = {  "load",
	                "save", "restart", "quit","~" };
	 
	        // Check for valid system command
	        for (int i = 0; i < commands.length; i++) {
	            if (input.equals(commands[i])) {
	                return true;
	            }
	        }
	 
	        return false;
	    }
	 	 
	public static void systemCommandAnswer(String input){
		//Help info
		if(input.equals("~")){
		System.out.println("------");
		System.out.println("~HELP~");
		System.out.println("------");
		System.out.println("Game commands: take, drop, leave, read, open, look around, use");
		System.out.println("System commands: restart, quit, ");
		System.out.println("_______________________________________________________________________________");
		System.out.println("There is something not quite right about this house.  You have a backpack and a brilliant mind, good luck!");
		}
		//display backpack contents
		
		
		else if(input.equals("restart")){
			restart();
			System.out.println("Lets try this again");
		}
		
		//exit
		else if(input.equals("quit")){
			System.out.println("Are you sure? Press y to quit, or n to choose a number for an inspiring quote");
			Scanner keyboard = new Scanner(System.in);
			String exit4sure=keyboard.next();
			int quoteInt=keyboard.nextInt();
			if(exit4sure.equals("y")){
			System.out.println("Thanks for playing!");
			System.exit(0);
			}
		else if(exit4sure.equals("n")){
				
			System.out.println(iQuote(quoteInt));
			try {
				Thread.sleep(900);
				Thread.sleep(900);
				Thread.sleep(900);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println(".");
			System.out.println(".");
			System.out.println(".");
			}
		}
		System.out.println("You walk into a house, the first room is small and seperated from the rest of the house.");
		
		//restart
		}
	public static boolean numberQuote(int input){
		for(int a=0;a<=10;a++){
			if(input==a){
				return true;
			}
			else{break;}
		}
		 return false;
	}
	public static class Backpack{
//		String []backpack= new String[50];
//		void add(String object){
//			System.out.println("You picked up the "+object);
//			int a=0;
//			while(a<=backpack.length){
//				backpack[a]=object;
//				a++;
//			}
//		}
		 static ArrayList<String> bkp = new ArrayList<String>();
		 
		 void add(String object){
			 System.out.println("You picked up the "+object);
			 this.bkp.add(object);
			 
		 }
		 
		void showBackpack(){
			System.out.println("[BACKPACK]");
			if(this.bkp.size()==0){
				System.out.println("Your backpack is empty.");
			}
		}
		boolean isInBkp(String input){
			if(this.bkp.contains(input)){
			return true;
			}
			return false;
		}
		
	}
	 public static String formatInput(String input) {
		 
	        // Convert to lower case
	        input = input.toUpperCase();
	 
	        // Remove extra spaces
	        input = input.replaceAll("\\s+", " ");
	        input = input.replaceAll("^\\s+|\\s+$", "");
	 
	        return input;
	    }
	 public static class Area{
		 private int room;
		 private int count =0;
		 private String name;
		 private String description;
		 private ArrayList<String> items;
	     private ArrayList<String> actions;
	     
	     public int getRoom(){
	    	 return this.room;
	     }
	  public void printItems(ArrayList<String> a1Items) {
		
		  if (a1Items.size() > 0) {
			 
	            System.out.print("There is a ");
	            if (a1Items.size() == 1) {
	                System.out.println(a1Items.get(0) + ".");
	                
	                
	            }
	            if (a1Items.size() == 2) {
	                System.out.println(a1Items.get(0) + " and a "
	                        + a1Items.get(1) + ".");
	            }
	            if (a1Items.size() == 3) {
	                System.out.println(a1Items.get(0) + ", a "
	                        + a1Items.get(1) + ", and a " + a1Items.get(2)
	                        + ".");
	            }
	            if (a1Items.size() == 4) {
	                System.out.println(a1Items.get(0) + ", a "
	                        + a1Items.get(1) + ", a " + a1Items.get(2)
	                        + ", and a "+a1Items.get(3));
	            }
	            if (a1Items.size() == 5) {
	                System.out.println(a1Items.get(0) + ", a "
	                        + a1Items.get(1) + ", a " + a1Items.get(2)
	                        + ", a "+a1Items.get(3)+", and a "+a1Items.get(4));
	            }
	            if (a1Items.size() == 6) {
	                System.out.println(a1Items.get(0) + ", a "
	                        + a1Items.get(1) + ", a " + a1Items.get(2)
	                        + ", a "+a1Items.get(3)+", a "
	                        		+a1Items.get(4)+", and a "+a1Items.get(5));
	            }
		}
}
   public void setRoom(int R1){
	    	 this.room=R1;
	     }
	     public int getCount(){
	    	 return this.count;
	     }
	     public int setCount(int C1){
	    	 return this.count=C1;
	     }
	     public String getName(){
	    	 return this.name;
	     }
	     public void setName(String name1){
	    	this.name=name1;
	     }
	     public String getDescription(){
	    	return this.description;
	     }
	     public void setDescription(String D1){
	    	 this.description=D1;
	     }
	     public ArrayList<String> getItem(){
	    	 return this.items;
	     }
	     public void setItems(ArrayList<String>items1){
	    	 this.items=items1;
	     }
	     public ArrayList<String> getActions(){
	    	 return this.actions;
	     }
	     public void setActions(ArrayList<String> actions1){
	    	 this.actions=actions1;
	     }
	     
	 }
	 public static void restart(){
		 World world = new World();
			//create title screen
			  world.title();
			//load world 1...
			  world.a1();
			  
	 }
	 
	 
	 public static String iQuote(int i1){
		 String []quoteArray= new String[11];{
			quoteArray[1]="If you have built castles in the air, your work need not be lost; that is where they should be. Now put foundations under them. -Henry David Thoreau";
			 quoteArray[2]="Inspiration and genius--one and the same. -Victor Hugo";
			 quoteArray[3]="Doubt whom you will, but never yourself. -Christian Nestell Bovee ";
			 quoteArray[4]="If you would create something,you must be something. -Johann Wolfgang von Goethe";
			 quoteArray[4]="Every artist was first an amateur. -Ralph Waldo Emerson";
			 quoteArray[5]="The more difficulties one has to encounter, within and without, the more significant and the higher in inspiration his life will be. -Horace Bushnell";
			 quoteArray[6]="Perfection is not attainable, but if we chase perfection we can catch excellence.-Vince Lombardi";
			 quoteArray[7]="When the sun is shining I can do anything; no mountain is too high, no trouble too difficult to overcome.-Wilma Rudolph";
			 quoteArray[8]="Everyone here has the sense that right now is one of those moments when we are influencing the future.-Steve Jobs";
			 quoteArray[9]="With self dicipline most anything is possible.-Theodore Roosevelt";
			 quoteArray[10]="Try not to become a man of success but a man of value.-Albert Einstein";
			
		 }
		 String quote=quoteArray[i1];
		 return quote;
	 }
	 
}
