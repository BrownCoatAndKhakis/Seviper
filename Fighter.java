 package CathyPokemon;

public class Fighter{
	double hp;
	double attack;
	double defense;
	double specialAttack;
	double specialDefense;
	double speed;

	String name;
	int level;

	Type[] type  = new Type[2];
	Move[] moves = new Move[4];

	public Fighter(
		String name,
		Type[] type;
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
	public static void main(String[] args) {
		Type[] t = new Type[2];
		Move[] m = new Move[4];
		Fighter f = new Fighter(pillow, t, m, 2, 77.0,4.0, 85.0,32.0,88.0,55.0)
	}
}