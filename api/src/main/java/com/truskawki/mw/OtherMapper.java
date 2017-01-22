package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
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
}

