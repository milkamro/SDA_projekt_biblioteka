package biblioteka.komenda;

import biblioteka.database.DataAccessObject;
import biblioteka.model.Ksiazka;
import biblioteka.model.Uzytkownik;

public class KomendaUsunUzytkownik implements Komenda {

    private DataAccessObject<Uzytkownik> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "usun uzytkownika";
    }

    @Override
    public void obsluga() {
        System.out.println("Podaj id uzytkownika:");
        String idString = Komenda.scanner.nextLine();
        Long id = Long.parseLong(idString);
        dao.delete(Uzytkownik.class, id);
    }
}