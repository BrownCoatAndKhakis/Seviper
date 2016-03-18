public class Move {
	String name;
	int pp;
	int attack;
	Type type;	
	Effect effect; 

	public Move(
		String name,
		int pp,
		int attack,
		Type type,
		Effect effect) {

		this.name = name;
		this.pp = pp;
		this.attack = attack;
		this.type = type;
		this.effect = effect;

	    };
	public static void main (String[] args) {
		Effect e = new Effect("Pokemon faints");
		Type bug = Type.BUG;
		Move m = new Move("Poison Sting", 10, 25, bug, e);
	}
}