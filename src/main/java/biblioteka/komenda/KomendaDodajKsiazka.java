package biblioteka.komenda;

import biblioteka.database.DataAccessObject;
import biblioteka.model.Kategoria;
import biblioteka.model.Ksiazka;

public class KomendaDodajKsiazka implements Komenda {
    private DataAccessObject<Ksiazka> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "dodaj ksiazke";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj kategorię:");
        String kategoria = Komenda.scanner.nextLine();

        System.out.println("Podaj imię autora:");
        String imie = Komenda.scanner.nextLine();

        System.out.println("Podaj nazwisko autora:");
        String nazwisko = Komenda.scanner.nextLine();

        System.out.println("Podaj tytul:");
        String tytul = Komenda.scanner.nextLine();

        System.out.println("Podaj rok wydania:");
        String rokString = Komenda.scanner.nextLine();
        Integer rok = Integer.parseInt(rokString);

        System.out.println("Podaj ISBN:");
        String isbn = Komenda.scanner.nextLine();

        Ksiazka ksiazka = Ksiazka.builder()
                .kategoria(Kategoria.valueOf(kategoria))
                .autorImie(imie)
                .autorNazwisko(nazwisko)
                .tytul(tytul)
                .rokWydania(rok)
                .isbn(isbn)
                .build();

        dao.insert(ksiazka);
    }
}
