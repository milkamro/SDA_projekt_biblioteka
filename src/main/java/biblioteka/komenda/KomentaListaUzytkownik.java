package biblioteka.komenda;

import biblioteka.database.DataAccessObject;
import biblioteka.model.Ksiazka;
import biblioteka.model.Uzytkownik;

public class KomentaListaUzytkownik implements Komenda {
    private DataAccessObject<Uzytkownik> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista ksiazek";
    }

    @Override
    public void obsluga() {
        dao.findAll(Uzytkownik.class).forEach(System.out::println);
    }
}