package CathyPokemon;

	public class Move{
		int pp;
		String type;
		String moveType;
		
		Effect[] effect = new Effect[]; 

		public Move(
			int pp,
			String type,
			String moveType,
			Effect[] effect) {

			this.pp = pp;
			this.type = type;
			this.moveType = moveType;
			this.effect = effect;

		    };
		public static void main (String[] args) {
			Effect[] e = new Effect["Pokemon faints"];
			Move m = new Move(10,bug,status,e)
		}
	}