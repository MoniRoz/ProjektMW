package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Przeglad;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OtherMapper extends Mapper {

    @Select("SELECT * FROM Wlasciciel WHERE pesel = #{pesel}")
    Wlasciciel getWlasciciel(long pesel);

    @Select("SELECT * FROM Pojazd WHERE nr_VIN = #{vin}")
    Pojazd getPojazd(String vin);

    @Select("SELECT Rodzaj_pojazdu FROM Rodzaj_pojazdu r, Pojazd p WHERE r.ID_rodzaju_pojazdu = p.ID_rodzaju_pojazdu AND nr_VIN = #{vin}")
    String getRodzaj_pojazdu(String vin);

    @Select("SELECT Marka FROM Marka m, Pojazd p WHERE m.ID_marki = p.ID_marki AND nr_VIN = #{vin}")
    String getMarka(String vin);

    ////////


    @Insert("insert into przeglad values (seq_Przeglad.nextval, \n" +
            "(\n" +
            "select Id_dokument from Pojazd, Dokument \n" +
            "where Dokument.ID_POJAZDU = Pojazd.ID_POJAZDU \n" +
            "and nr_VIN = #{vin} and id_typu = 1 and data_koncowa is null\n" +
            ")\n" +
            ",#{data_wystawienia}, #{data_waznosci}, #{wystawiajacy}) ")
    void addPrzeglad(@Param("vin") String vin,
                     @Param("data_wystawienia") String data_wystawienia,
                     @Param("data_waznosci") String data_waznosci,
                     @Param("wystawiajacy") String wystawiajacy);
}

