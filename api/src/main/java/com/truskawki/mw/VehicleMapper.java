package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface VehicleMapper extends Mapper {

    @Insert("INSERT INTO Rodzaj_pojazdu VALUES (seq_Rodzaj_pojazdu.NEXTVAL, #{rodzaj_pojazdu})")
    void insertRodzaj_pojazdu(String rodzaj_pojazdu);

    @Insert("INSERT INTO Marka VALUES (seq_Marka.NEXTVAL, #{marka})")
    void insertMarka(String marka);

    @Insert("INSERT INTO Pojazd VALUES (seq_Pojazd.NEXTVAL, seq_Marka.CURRVAL, seq_Rodzaj_pojazdu.CURRVAL, #{model}," +
            "#{rok_produkcji}, #{nr_VIN}, #{masa}, #{p_silnika}, #{m_silnika}, #{r_silnika}, #{d_nr_rejestracyjny} )")
    void insertPojazd(Pojazd pojazd);

    @Insert("INSERT INTO Wlasciciel VALUES (seq_Wlasciciel.NEXTVAL, #{imie}, #{nazwisko}, #{pesel}, #{ulica}, #{kod_pocztowy}, #{miejscowosc}, #{nr_domu} )")
    void insertWlasciciel(Wlasciciel wlasciciel);

    @Insert("INSERT INTO Posiadanie VALUES (seq_Posiadanie.NEXTVAL, seq_Pojazd.CURRVAL, seq_Wlasciciel.CURRVAL, current_date, current_date + 365 * 15 )")
    void insertPosiadanie();

    @Insert("INSERT INTO Dokument VALUES (seq_Dokument.NEXTVAL, seq_Pojazd.CURRVAL, seq_Wlasciciel.CURRVAL, 1, 'Starosta bialobrzeski', current_date, current_date + 365 * 15 )")
    void insertDowodRejestracyjny();

    @Insert("INSERT INTO Dokument VALUES (seq_Dokument.NEXTVAL, seq_Pojazd.CURRVAL, seq_Wlasciciel.CURRVAL, 2, 'Starosta bialobrzeski', current_date, current_date + 365 * 15 )")
    void insertKartaPojazdu();


    /////

    @Select("SELECT * FROM Wlasciciel WHERE pesel = #{pesel}")
    Wlasciciel getWlasciciel(long pesel);

    @Select("SELECT * FROM Pojazd WHERE nr_VIN = #{vin}")
    Pojazd getPojazd(long vin);

    @Select("SELECT Rodzaj_pojazdu FROM Rodzaj_pojazdu r, Pojazd p WHERE r.ID_rodzaju_pojazdu = p.ID_rodzaju_pojazdu AND nr_VIN = #{vin}")
    String getRodzaj_pojazdu(long vin);

    @Select("SELECT Marka FROM Marka m, Pojazd p WHERE m.ID_marki = p.ID_marki AND nr_VIN = #{vin}")
    String getMarka(long vin);
}

