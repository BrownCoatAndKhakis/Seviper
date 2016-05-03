import java.util.Scanner;

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
	