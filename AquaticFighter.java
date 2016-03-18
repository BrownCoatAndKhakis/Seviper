import java.util.Scanner;

public class AquaticFighter extends Fighter {
  Type type = Type.WATER;

  Move specialWaterMove;

  public AquaticFighter(
    String name,
    Move[] moves,
    int level,
    double hp,
    double attack,
    double defense,
    double specialAttack,
    double specialDefense,
    double speed) {
    super(name, Type.WATER, moves, level, hp, attack, defense, specialAttack, specialDefense, speed);
  }

  /**
  * Apply a 2x multiplier to the chose attack if it's a water move
  **/
  public Move selectMove() {
    Move normalMove = super.selectMove();

    if (normalMove != null && normalMove.type == this.type) {
      System.out.println("You're using a water move... it's going to be 2 times as powerful!");
      Move enhancedMove = new Move(normalMove.name, normalMove.pp, normalMove.attack * 2, Type.WATER, normalMove.effect);
      return enhancedMove;
    }
    return normalMove;
  }

  public static void main(String[] args) {
    Move[] m = new Move[2];

    Effect e1 = new Effect("scratches the opponent with your fighter\'s claws");
    m[0] = new Move("Scratch", 35, 10, Type.NORMAL, e1);

    Effect e2 = new Effect("fires a powerful jet of water");
    m[1] = new Move("Water Blast", 20, 20, Type.WATER, e2);

    AquaticFighter waterFighter = new AquaticFighter("water pillow", m, 2, 77.0, 4.0, 85.0, 32.0, 88.0, 55.0);

    waterFighter.selectMove();
  }
}