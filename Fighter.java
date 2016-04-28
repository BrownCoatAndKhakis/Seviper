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
	Move[] moves;

	public Fighter(
		String name,
		
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
		this.level = level;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;

	}	
}
	