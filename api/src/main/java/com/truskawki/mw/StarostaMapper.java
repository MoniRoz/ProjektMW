package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StarostaMapper extends Mapper {

    @Insert("INSERT INTO Rodzaj_pojazdu VALUES (seq_Rodzaj_pojazdu.NEXTVAL, #{rodzaj_pojazdu})")
    void insertRodzaj_pojazdu(String rodzaj_pojazdu);

    @Insert("INSERT INTO Marka VALUES (seq_Marka.NEXTVAL, #{marka})")
    void insertMarka(String marka);

    @Insert("INSERT INTO Pojazd VALUES (seq_Pojazd.NEXTVAL, seq_Marka.CURRVAL, seq_Rodzaj_pojazdu.CURRVAL, #{model}," +
            "#{rok_produkcji}, #{nr_VIN}, #{masa}, #{p_silnika}, #{m_silnika}, #{r_silnika}, #{d_nr_rejestracyjny} )")
    void insertPojazd(Pojazd pojazd);

    @Insert("INSERT INTO Wlasciciel VALUES (seq_Wlasciciel.NEXTVAL, #{imie}, #{nazwisko}, #{pesel}, #{ulica}, #{kod_pocztowy}, #{miejscowosc}, #{nr_domu} )")
    void insertWlasciciel(Wlasciciel wlasciciel);

    @Insert("INSERT INTO Posiadanie VALUES (seq_Posiadanie.NEXTVAL, seq_Pojazd.CURRVAL, seq_Wlasciciel.CURRVAL, current_date, null )")
    void insertPosiadanie();

    @Insert("INSERT INTO Dokument VALUES (seq_Dokument.NEXTVAL, seq_Pojazd.CURRVAL, seq_Wlasciciel.CURRVAL, 1, 'Starosta bialobrzeski', current_date, null )")
    void insertDowodRejestracyjny();

    @Insert("INSERT INTO Dokument VALUES (seq_Dokument.NEXTVAL, seq_Pojazd.CURRVAL, seq_Wlasciciel.CURRVAL, 2, 'Starosta bialobrzeski', current_date, null )")
    void insertKartaPojazdu();

    ///

    @Select("SELECT isPojazdAlreadyUsed(#{vin}) FROM DUAL")
    int isPojazdAlreadyUsed(String vin);

    @Select("SELECT isWlascicielAlreadyUsed(#{pesel}) FROM DUAL")
    int isWlascicielAlreadyUsed(long pesel);

    ///

    @Update("UPDATE Wlasciciel SET imie = #{imie}, nazwisko = #{nazwisko}, ulica = #{ulica}, kod_pocztowy = #{kod_pocztowy}, miejscowosc = #{miejscowosc}, nr_domu = #{nr_domu}" +
            "WHERE pesel = #{pesel}")
    void updateWlasciciel(Wlasciciel wlasciciel);

    @Update("UPDATE Pojazd SET masa = #{masa}, r_silnika = #{r_silnika}, d_nr_rejestracyjny = #{d_nr_rejestracyjny} WHERE nr_VIN = #{nr_VIN}")
    void updatePojazd(Pojazd pojazd);
}

