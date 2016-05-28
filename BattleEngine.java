import java.util.Scanner;
import java.util.Random;

public class BattleEngine {
	Fighter fighter1;
	Fighter fighter2;

	public BattleEngine(Fighter f1, Fighter f2){
		this.fighter1 = f1;
		this.fighter2 = f2;
	}

	public void battle(){
		Move player1ActionMove = playerActionMove(this.fighter1);
		Move player2ActionMove = playerActionMove(this.fighter2);
		Fighter fasterFighter = checkSpeed(this.fighter1, this.fighter2);
		if (fasterFighter.equals(fighter1)) {
			double damage = calculateDamage(player1ActionMove,player1);
		}
		else {
			double damage = calculateDamage(player2ActionMove,player2);
		}
		

	
	}
	public Move playerActionMove (Fighter fighter){
		String playerAction = selectPlayerAction(fighter);
		
		if(playerAction.equals("Moves")) {
			Move selectedMove = null;
 			while(selectedMove == null && checkMovePP(selectedMove) == false) {
				selectedMove = selectMove(fighter);
				
 			}
 			return selectedMove;
 		}
 		//TODO: Make the function repeat instead of staying at null
 		else {
 			return null;
 		}
	}

	public String selectPlayerAction(Fighter fighter){ 
		System.out.println("Select Switch or Moves for " + fighter.name);
		Scanner input = new Scanner(System.in);
		String inputAction = input.next();
		if (inputAction.equals("Switch")){
			System.out.println("Selected Switch");
			return "Switch";
		}
		else if (inputAction.equals("Moves")){
			System.out.println("Selected Moves");
			return "Moves";
		}
		else {
			System.out.println("Invalid");
			return null;
		}
	}

	public void printMove (Fighter fighter) {
		for(Move m : fighter.moves){
			System.out.println(m.name);
		}
	}

	public Move selectMove(Fighter fighter) {
		Scanner input = new Scanner( System.in );
		input.useDelimiter("\n");
		System.out.println("Select which move you want to use for " + fighter.name);
		printMove(fighter);
		String moveName = input.next();

		// check if user's choice is actually a move this Fighter has in their moves list
		Move selectedMove = null;
		for (Move m : fighter.moves) {
			if (m.name.equals(moveName)) {
				selectedMove = m;
			}
		}

		if (selectedMove == null) {
			System.out.println("ERROR: The move you chose does not exist for this Fighter!");
		}
		return selectedMove;
	}

	public Boolean checkMovePP(Move selectedMove) {
		if (selectedMove == null) {
			return false;
		}
		int pp = selectedMove.pp;
		if (pp > 0){
			return true;
		}
		else {
			return false;
		}
	}

	public Fighter checkSpeed(Fighter fighter1, Fighter fighter2) {
		if (fighter1.speed > fighter2.speed) {
			System.out.println(fighter1.name);
			return fighter1;
		}
		if (fighter2.speed > fighter1.speed) {
			System.out.println(fighter2.name);
			return fighter2;
		}
		else {
			Random r = new Random();
			int num = r.nextInt(2);
			if (num == 0) {
				System.out.println(fighter1.name);
				return fighter1;
			}
			else {
				System.out.println(fighter2.name);
				return fighter2;
			}
		}
	}

	public double calculateDamage(Move selectedMove, Fighter fighter1) {
		int level = fighter1.level;
		double attack = fighter1.attack;
		double defense = fighter1.defense;
		int attackMove = selectedMove.attack;
		double damage = ((2 * level + 10)/ 250) * ( attack/ defense) * attackMove + 2;
		System.out.println(damage);
		return damage;
	}

	public double calculateTypeDamage(Fighter fighter1, Fighter fighter2){
		if (fighter1.type = "Fire" && fighter2.type = "Grass"){
			return 2.0;
			//TODO: do it
		} 
	}

	public static void main (String[] args){
		Move[] moveListMew = new Move[1];
		moveListMew[0] = new Move("Cut", 4, 20);
		Move[] moveListPiplup = new Move[1];
		moveListPiplup[0] = new Move("Bubble Beam", 4, 20);

		Fighter mew = new Fighter("Mew", moveListMew,  2, 77.0, 4.0, 85.0, 32.0, 88.0, 55.0);
		Fighter piplup = new Fighter("Piplup", moveListPiplup, 2, 77.0, 4.0, 85.0, 32.0, 88.0, 55.0);

		BattleEngine be = new BattleEngine(mew, piplup);

		be.battle();
		
	
	}
		}

}
	