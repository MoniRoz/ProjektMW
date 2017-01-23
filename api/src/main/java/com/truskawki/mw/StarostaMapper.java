package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.ibatis.annotations.*;

public interface StarostaMapper extends Mapper {

    @Insert("INSERT INTO Rodzaj_pojazdu VALUES (seq_Rodzaj_pojazdu.NEXTVAL, #{rodzaj_pojazdu})")
    void insertRodzaj_pojazdu(String rodzaj_pojazdu);

    @Insert("INSERT INTO Marka VALUES (seq_Marka.NEXTVAL, #{marka})")
    void insertMarka(String marka);

    @Insert("INSERT INTO Pojazd VALUES (seq_Pojazd.NEXTVAL, seq_Marka.CURRVAL, seq_Rodzaj_pojazdu.CURRVAL, #{model}," +
            "#{rok_produkcji}, #{nr_VIN}, #{masa}, #{p_silnika}, #{m_silnika}, #{r_paliwa}, #{d_nr_rejestracyjny} )")
    void insertPojazd(Pojazd pojazd);

    @Insert("INSERT INTO Wlasciciel VALUES (seq_Wlasciciel.NEXTVAL, #{imie}, #{nazwisko}, #{pesel}, #{ulica}, #{kod_pocztowy}, #{miejscowosc}, #{nr_domu} )")
    void insertWlasciciel(Wlasciciel wlasciciel);

    @Insert("INSERT INTO Posiadanie VALUES (seq_Posiadanie.NEXTVAL, #{idPojazd}, #{idWlasciciel}, current_date, null )")
    void insertPosiadanie(@Param("idPojazd") int idPojazd, @Param("idWlasciciel") int idWlasciciel);

    @Insert("INSERT INTO Dokument VALUES (seq_Dokument.NEXTVAL, #{idPojazd}, #{idWlasciciel}, 1, 'Starosta bialobrzeski', current_date, null )")
    void insertNewDowodRejestracyjny(@Param("idPojazd") int idPojazd, @Param("idWlasciciel") int idWlasciciel);

    @Insert("INSERT INTO Dokument VALUES (seq_Dokument.NEXTVAL, #{idPojazd}, #{idWlasciciel}, 2, 'Starosta bialobrzeski', current_date, null )")
    void insertKartaPojazdu(@Param("idPojazd") int idPojazd, @Param("idWlasciciel") int idWlasciciel);

    @Insert("INSERT INTO przeglad VALUES (seq_Przeglad.NEXTVAL, seq_Dokument.CURRVAL, current_date, current_date + 3 * 365, 'SKP Myszogrod')")
    void insertPrzeglad();

    ///

    @Select("SELECT isPojazdAlreadyUsed(#{vin}) FROM DUAL")
    int isPojazdAlreadyUsed(String vin);

    @Select("SELECT isWlascicielAlreadyUsed(#{pesel}) FROM DUAL")
    int isWlascicielAlreadyUsed(long pesel);

    ///

    @Update("UPDATE Wlasciciel SET imie = #{imie}, nazwisko = #{nazwisko}, ulica = #{ulica}, kod_pocztowy = #{kod_pocztowy}, miejscowosc = #{miejscowosc}, nr_domu = #{nr_domu}" +
            "WHERE pesel = #{pesel}")
    void updateWlasciciel(Wlasciciel wlasciciel);

    @Update("UPDATE Pojazd SET masa = #{masa}, r_paliwa = #{r_paliwa}, d_nr_rejestracyjny = #{d_nr_rejestracyjny} WHERE nr_VIN = #{nr_VIN}")
    void updatePojazd(Pojazd pojazd);

    @Update("UPDATE Dokument set data_koncowa = current_date  \n" +
            "WHERE ID_dokument = \n" +
            "(\n" +
            "select ID_dokument from Dokument, Pojazd, Wlasciciel where Pojazd.ID_Pojazdu = Dokument.ID_Pojazdu and Wlasciciel.ID_Wlasciciela = Dokument.ID_Wlasciciela " +
            "and id_typu = 1 \n" +
            "and nr_VIN = #{vin} and pesel = #{pesel} and data_koncowa is null\n" +
            ")")
    void updateDowodRejestracyjny(@Param("vin") String vin, @Param("pesel") long pesel);

    @Update("UPDATE Posiadanie set data_koncowa = current_date  \n" +
            "WHERE ID_posiadania = \n" +
            "(\n" +
            "select ID_posiadania from Posiadanie, Pojazd, Wlasciciel where Pojazd.ID_Pojazdu = Posiadanie.ID_Pojazdu and Wlasciciel.ID_Wlasciciela = Posiadanie.ID_Wlasciciela \n" +
            "and nr_VIN = #{vin} and pesel = #{pesel} and data_koncowa is null\n" +
            ")")
    void updatePosiadanie(@Param("vin") String vin, @Param("pesel") long pesel);






    @Update("UPDATE Dokument set data_koncowa = current_date  \n" +
            "WHERE ID_dokument = \n" +
            "(\n" +
            "select ID_dokument from Dokument, Pojazd where Pojazd.ID_Pojazdu = Dokument.ID_Pojazdu " +
            "and id_typu = 1 \n" +
            "and nr_VIN = #{vin} and data_koncowa is null\n" +
            ")")
    void updateDowodRejestracyjny2(@Param("vin") String vin);

    @Update("UPDATE Posiadanie set data_koncowa = current_date  \n" +
            "WHERE ID_posiadania = \n" +
            "(\n" +
            "select ID_posiadania from Posiadanie, Pojazd where Pojazd.ID_Pojazdu = Posiadanie.ID_Pojazdu \n" +
            "and nr_VIN = #{vin} and data_koncowa is null\n" +
            ")")
    void updatePosiadanie2(@Param("vin") String vin);





    @Insert("INSERT INTO Dokument VALUES (seq_Dokument.NEXTVAL, (select ID_pojazdu from Pojazd where nr_VIN = #{vin}), (select ID_wlasciciela from Wlasciciel where pesel = #{pesel}), 1, 'Starosta bialobrzeski', current_date, null )")
    void insertUpdateDowodRejestracyjny(@Param("vin") String vin, @Param("pesel") long pesel);

    @Insert("INSERT INTO Posiadanie VALUES (seq_Posiadanie.NEXTVAL, (select ID_pojazdu from Pojazd where nr_VIN = #{vin}), (select ID_wlasciciela from Wlasciciel where pesel = #{pesel}), current_date, null )")
    void insertUpdatePosiadania(@Param("vin") String vin, @Param("pesel") long pesel);


    @Select("select seq_Pojazd.CURRVAL from dual")
    int getPojazdCurrval();



    @Select("select ID_wlasciciela from Wlasciciel where pesel = #{pesel}")
    int getWlascicielID(long pesel);

    @Select("select ID_pojazdu from Pojazd where nr_VIN = #{vin}")
    int getPojazdID(String vin);





    @Select("select ID_przegladu from Przeglad, Dokument, Pojazd\n" +
            "where Dokument.ID_POJAZDU = Pojazd.ID_POJAZDU and Przeglad.ID_DOKUMENT = Dokument.ID_DOKUMENT\n" +
            "and id_typu = 1 and nr_VIN = #{vin} and data_koncowa is null and data_waznosci > current_date")
    int getPrzegladID(String vin);


    @Update("update Przeglad set ID_dokument = \n" +
            "(\n" +
            "    select ID_posiadania from Posiadanie, Pojazd, Wlasciciel where Pojazd.ID_Pojazdu = Posiadanie.ID_Pojazdu and Wlasciciel.ID_Wlasciciela = Posiadanie.ID_Wlasciciela \n" +
            "    and nr_VIN = #{vin} and pesel = #{pesel} and data_koncowa is null\n" +
            ")\n" +
            "where ID_Przegladu = #{id}")
    int updatePrzeglad(@Param("id") int id, @Param("vin") String vin, @Param("pesel") long pesel);
}

