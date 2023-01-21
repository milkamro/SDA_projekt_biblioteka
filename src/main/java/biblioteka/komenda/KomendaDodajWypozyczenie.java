package biblioteka.komenda;

import biblioteka.database.DataAccessObject;
import biblioteka.model.Ksiazka;
import biblioteka.model.Uzytkownik;
import biblioteka.model.Wypozyczenie;

import java.time.LocalDate;
import java.util.Optional;

public class KomendaDodajWypozyczenie implements Komenda {
    private DataAccessObject<Wypozyczenie> dao = new DataAccessObject<>();
    private DataAccessObject<Ksiazka> daoKsiazka = new DataAccessObject<>();
    private DataAccessObject<Uzytkownik> daoUzytkownik = new DataAccessObject<>();
    @Override
    public String getKomenda() {
        return "dodaj wypozyczenie";
    }

    @Override
    public void obsluga() {System.out.println("Podaj id ksiazki:");
        String idKsiazkiString = Komenda.scanner.nextLine();
        Long idKsiazki = Long.parseLong(idKsiazkiString);
        Optional<Ksiazka> ksiazkaOptional = daoKsiazka.find(Ksiazka.class, idKsiazki);
        if (ksiazkaOptional.isEmpty()) {
            System.err.println("Ksiazka o podanym id nie istnieje");
            return;
        }

        System.out.println("Podaj id uzytkownika:");
        String idUzytkownikaString = Komenda.scanner.nextLine();
        Long idUzytkownika = Long.parseLong(idUzytkownikaString);
        Optional<Uzytkownik> uzytkownikOptional = daoUzytkownik.find(Uzytkownik.class, idUzytkownika);
        if (uzytkownikOptional.isEmpty()) {
            System.err.println("Uzytkownik o podanym id nie istnieje");
            return;
        }

        LocalDate dataWypozyczenia = LocalDate.now();

        // DODAĆ OBLICZANIE DATY ZWROTU
        LocalDate dataZwrotu = dataWypozyczenia;

  Wypozyczenie wypozyczenie = Wypozyczenie.builder()
          .dataWypozyczenia(dataWypozyczenia)
          .dataKoncaWypozyczenia(dataZwrotu)
          .ksiazka(ksiazkaOptional.get())
          .uzytkownik(uzytkownikOptional.get())
          .build();

        dao.insert(wypozyczenie);
    }
}
