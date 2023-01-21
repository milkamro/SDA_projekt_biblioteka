//package biblioteka.komenda;
//
//import biblioteka.database.DataAccessObject;
//import biblioteka.model.Ksiazka;
//
//import java.util.Optional;
//
//public class KomendaZnajdzKsiazka implements Komenda{
//    private DataAccessObject<Ksiazka> dataAccessObject;
//
//    public KomendaZnajdzKsiazka() {
//        this.dataAccessObject = new DataAccessObject<>();
//    }
//
//    @Override
//    public String getKomenda() {
//        return "znajdz ksiazke";
//    }
//
//    @Override
//    public void obsluga() {
//        System.out.println("Opcje wyszukiwania: 1-tytul/2-nazwisko autora/3-isbn/4-kategoria:");
//        System.out.println("Podaj numer komendy:");
//        String idString = Komenda.scanner.nextLine();
//        Long id = Long.parseLong(idString);
//
//        Optional<Mechanik> mechanikOptional = dataAccessObject.find(Mechanik.class, id);
//        if (mechanikOptional.isPresent()) {
//            System.out.println(mechanikOptional.get());
//        } else {
//            System.err.println("Nie znaleziono mechanika!");
//        }
//    }
//}
//
