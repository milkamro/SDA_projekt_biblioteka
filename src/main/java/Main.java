import biblioteka.komenda.Komenda;
import biblioteka.komenda.KomendaDodajKsiazka;
import biblioteka.komenda.KomendaDodajUzytkownik;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Komenda> listaKomend = List.of(
                new KomendaDodajKsiazka(),
                new KomendaDodajUzytkownik()
                );

        String komenda;
        do {
            System.out.println("Lista dostepnych komend:");
            for (int i = 0; i < listaKomend.size(); i++) {
                System.out.println((i + 1) + ". " + listaKomend.get(i).getKomenda());
            }
            System.out.println();

            System.out.println("Podaj komende:");
            komenda = Komenda.scanner.nextLine();

            for (Komenda dostepnaKomenda : listaKomend) {
                if (dostepnaKomenda.getKomenda().equals(komenda)) {
                    dostepnaKomenda.obsluga();
                }
            }
        } while (!komenda.equalsIgnoreCase("exit"));
    }
}

