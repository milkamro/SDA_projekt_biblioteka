package biblioteka.komenda;

import biblioteka.database.DataAccessObject;
import biblioteka.model.Ksiazka;

public class KomendaUsunKsiazka implements Komenda {

    private DataAccessObject<Ksiazka> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun ksiazke";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id ksiazki:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);
        dao.delete(Ksiazka.class, id);
    }
}