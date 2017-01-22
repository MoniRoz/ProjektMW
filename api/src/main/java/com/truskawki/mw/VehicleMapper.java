package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.ibatis.annotations.Select;

public interface VehicleMapper {

    @Select("INSERT INTO Dokument VALUES (seq_Dokument.NEXTVAL, #{rodzaj_pojazdu}, #{marka}, #{typ}, #{model}, #{rok_produkcji},"
            + "#{nr_VIN}, #{nr_silnika}, #{d_nr_rejestracyjny}, #{nr_kart_pojazdu}, #{przebieg_p_w_km}, #{barwa_nadwozia})")
    Pojazd addVehicleDocument(Pojazd vehicleDTO);

    @Select("INSERT INTO Wlasciciel VALUES (seq_Wlasciciel.NEXTVAL, #{imie}, #{nazwisko}, #{pesel}, #{ulica}, #{kod_pocztowy},"
            + "#{miejscowosc}, #{nr_domu})")
    Wlasciciel addOwner(Wlasciciel ownerDTO);

    @Select("INSERT INTO Pojazd VALUES (seq_Pojazd.NEXTVAL, seq_Dokument.CURRVAL, seq_Wlasciciel.CURRVAL)")
    Wlasciciel addVehicle();
}