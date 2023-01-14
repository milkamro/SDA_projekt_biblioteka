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
    @Column(columnDefinition = "VARCHAR(50) CHECK (nazwa IN ('OBYCZAJOWA', 'KRYMINAL'))")
    @Enumerated
    private Kategoria kategoria;
    private String autor;
    private String tytul;
    private String isbn;
    private int rok_wydania;

    @OneToMany(mappedBy = "ksiazka")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Wypozyczenie> wypozyczenia;

}
