package biblioteka.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Ksiazka {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "VARCHAR(50) CHECK (kategoria IN ('BIOGRAFIA', 'FANTASTYKA', 'KRYMINAŁ'," +
            " 'OBYCZAJOWA', 'PIĘKNA', 'PORADNIK', 'TURYSTYKA'))")
    @Enumerated(EnumType.STRING)
    private Kategoria kategoria;
    private String autorImie;
    private String autorNazwisko;
    private String tytul;
    private int rokWydania;
    private String isbn;


    @OneToMany(mappedBy = "ksiazka")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Wypozyczenie> wypozyczenia;

}
