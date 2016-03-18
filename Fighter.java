import java.util.Scanner;

public class Fighter{
	double hp;
	double attack;
	double defense;
	double specialAttack;
	double specialDefense;
	double speed;

	String name;
	int level;

	Type type;
	Move[] moves;

	public Fighter(
		String name,
		Type type,
		Move[] moves,
		int level,
		double hp,
		double attack,
		double defense,
		double specialAttack,
		double specialDefense,
		double speed) {
		
		this.name = name;
		this.moves = moves;
		this.type = type;
		this.level = level;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.speed = speed;

	};

	/**
	* Asks the user for which of their Fighter's move they'd like to use
	*
	**/
	public Move selectMove() {
		Scanner input = new Scanner( System.in );
		input.useDelimiter("\n");
		System.out.println("Select which move you want to use:");
		String moveName = input.next();

		// check if user's choice is actually a move this Fighter has in their moves list
		Move selectedMove = null;
		for (Move m : this.moves) {
			if (m.name.equals(moveName)) {
				selectedMove = m;
			}
		}

		if (selectedMove == null) {
			System.out.println("ERROR: The move you chose does not exist for this Fighter!");
		}
		return selectedMove;
	}

	public static void main(String[] args) {
		Type t = Type.FIRE;
		Move[] m = new Move[4];
		Fighter f = new Fighter("pillow", t, m, 2, 77.0, 4.0, 85.0, 32.0, 88.0, 55.0);
	}
}