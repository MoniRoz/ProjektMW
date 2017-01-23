package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Przeglad;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;

import java.util.List;

public interface PolicjantMapper extends Mapper {

    @Lang(XMLLanguageDriver.class)
    @Select("<script>" +
            "select distinct marka, rodzaj_pojazdu, model, rok_produkcji, nr_vin, masa, p_silnika, m_silnika, r_paliwa, d_nr_rejestracyjny\n" +
            "from Dokument d, Pojazd p, Marka m, Rodzaj_pojazdu r " +
            "WHERE d.ID_POJAZDU = p.ID_POJAZDU \n" +
            "and m.ID_marki = p.id_marki\n" +
            "and r.ID_RODZAJU_POJAZDU = p.ID_RODZAJU_POJAZDU\n" +
            "and ID_typu = 1 and data_koncowa is null " +
            " <if test=\"param1 != null\">" +
            "    AND nr_VIN = #{vin}" +
            " </if>\n" +
            " <if test=\"param2 != null\">" +
            "    AND d_nr_rejestracyjny = #{rejestracja}" +
            " </if>" +
            "</script>")
    Pojazd getPojazd(@Param("vin") String vin, @Param("rejestracja") String rejestracja);


    @Select("select imie, nazwisko, pesel, ulica, nr_domu, kod_pocztowy, miejscowosc, data_poczatkowa, data_koncowa from Wlasciciel, Dokument, Pojazd \n" +
            "where Dokument.ID_WLASCICIELA = Wlasciciel.ID_WLASCICIELA and Dokument.ID_POJAZDU = Pojazd.ID_POJAZDU\n" +
            "and id_typu = 1 and nr_vin = #{vin}")
    List<Wlasciciel> getWlasciciele(String vin);

    @Select("select data_wystawienia, data_waznosci, Przeglad.wystawiajacy from Przeglad, Dokument, Pojazd \n" +
            "where Przeglad.ID_DOKUMENT = Dokument.ID_DOKUMENT and Dokument.ID_POJAZDU = Pojazd.ID_POJAZDU\n" +
            "and id_typu = 1 and nr_vin = #{vin}")
    List<Przeglad> getPrzeglady(String vin);
}

