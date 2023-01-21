package biblioteka.komenda;

import biblioteka.database.DataAccessObject;
import biblioteka.model.Kategoria;
import biblioteka.model.Ksiazka;
import biblioteka.model.Uzytkownik;

public class KomendaDodajUzytkownik implements Komenda {
    private DataAccessObject<Uzytkownik> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj uzytkownika";
    }

    @Override
    public void obsluga() {
                System.out.println("Podaj imię:");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj nazwisko:");
        String nazwisko = Komenda.scanner.nextLine();

        System.out.println("Podaj numer karty:");
        String numer = Komenda.scanner.nextLine();

        Uzytkownik uzytkownik = Uzytkownik.builder()
                .imie(imie)
                .nazwisko(nazwisko)
                .numerKarty(numer)
                .build();

        dao.insert(uzytkownik);
    }
}
