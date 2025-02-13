import java.util.ArrayList;

public class Pokedex extends ArrayList<Pokemon> {
    public Pokedex() {
        iniciarPokedex();
    }

    private void iniciarPokedex() {
        this.add(new Pokemon(101, "Pikachu", "Eléctrico", "Electricidad Estática", 120, 5));
        this.add(new Pokemon(102, "Charmander", "Fuego", "Mar de Llamas", 150, 5));
        this.add(new Pokemon(103, "Bulbasaur", "Planta/Veneno", "Espesura", 130, 5));
        this.add(new Pokemon(104, "Squirtle", "Agua", "Torrente", 140, 5));
        this.add(new Pokemon(105, "Eevee", "Normal", "Fuga", 160, 5));
        this.add(new Pokemon(106, "Gengar", "Fantasma/Veneno", "Levitación", 200, 5));
    }
}
