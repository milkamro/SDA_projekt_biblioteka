package biblioteka.komenda;

import biblioteka.database.DataAccessObject;
import biblioteka.model.Ksiazka;

public class KomentaListaKsiazka implements Komenda {
    private DataAccessObject<Ksiazka> dao = new DataAccessObject<>();

    @Override
    public String getKomenda() {
        return "lista ksiazek";
    }

    @Override
    public void obsluga() {
        dao.findAll(Ksiazka.class).forEach(System.out::println);
    }
}