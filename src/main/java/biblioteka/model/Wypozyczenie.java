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

//    // Część relacji Samochod-Wypozyczenie
//    @ManyToOne
//    @EqualsAndHashCode.Exclude
//    private Samochod samochodX;
//
//    // Część relacji Klient-Wypozyczenie
//    @ManyToOne
//    @EqualsAndHashCode.Exclude
//    private Klient klientY;
//
//    // Część relacji Zwrot-Wypozyczenie
//    @OneToOne(mappedBy = "wypozyczenieZ")
//    @EqualsAndHashCode.Exclude
//    private Zwrot zwrot;
//}

}
