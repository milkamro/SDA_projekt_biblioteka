package biblioteka.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wypozyczenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private LocalDate dataWypozyczenia;

    private LocalDate dataKoncaWypozyczenia;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Ksiazka ksiazka;

    @ManyToOne
    @EqualsAndHashCode.Exclude
    private Uzytkownik uzytkownik;

    @OneToOne
    @EqualsAndHashCode.Exclude
    private Zwrot zwrot;


}
