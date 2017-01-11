package com.truskawki.mw.dal;

import com.truskawki.mw.lib.OwnerDTO;
import com.truskawki.mw.lib.VehicleDTO;
import org.apache.ibatis.annotations.Lang;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;

import java.util.ArrayList;

public interface VehicleMapper {

    @Select("INSERT INTO Dokument VALUES (seq_Dokument.NEXTVAL, #{rodzaj_pojazdu}, #{marka}, #{typ}, #{model}, #{rok_produkcji},"
            + "#{nr_VIN}, #{nr_silnika}, #{d_nr_rejestracyjny}, #{nr_kart_pojazdu}, #{przebieg_p_w_km}, #{barwa_nadwozia})")
    VehicleDTO addVehicleDocument(VehicleDTO vehicleDTO);

    @Select("INSERT INTO Wlasciciel VALUES (seq_Wlasciciel.NEXTVAL, #{imie}, #{nazwisko}, #{pesel}, #{ulica}, #{kod_pocztowy},"
            + "#{miejscowosc}, #{nr_domu})")
    OwnerDTO addOwner(OwnerDTO ownerDTO);

    @Select("INSERT INTO Pojazd VALUES (seq_Pojazd.NEXTVAL, seq_Dokument.CURRVAL, seq_Wlasciciel.CURRVAL)")
    OwnerDTO addVehicle();

    @Select("COMMIT")
    void commit();

    ////////

    @Select("SELECT * FROM Pojazd where id = ( select count(*) from Pojazd)")
    VehicleDTO getLastAddedVehicle();
}