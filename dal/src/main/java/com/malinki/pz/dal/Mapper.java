package com.malinki.pz.dal;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.malinki.pz.dal.domain.VehicleDTO;

public interface Mapper {
	@Select("INSERT INTO Pojazd VALUES (getMinPojazdID, #{rodzaj_pojazdu}, #{marka}, #{typ}, #{model}, #{rok_produkcji},"
			+ "#{nr_VIN}, #{nr_silnika}, #{d_nr_rejestracyjny}, #{nr_kart_pojazdu}, #{przebieg_p_w_km}, #{barwa_nadwozia})")
	VehicleDTO addVehicle(
			@Param("rodzaj_pojazdu") String rodzaj_pojazdu,
			@Param("marka") String marka,
			@Param("typ") String typ,
			@Param("model") String password,
			@Param("rok_produkcji") int rok_produkcji,
			@Param("nr_VIN") String nr_VIN,
			@Param("nr_silnika") String nr_silnika,
			@Param("d_nr_rejestracyjny") String d_nr_rejestracyjny,
			@Param("nr_kart_pojazdu") String nr_kart_pojazdu,
			@Param("przebieg_p_w_km") int przebieg_p_w_km,
			@Param("barwa_nadwozia") String barwa_nadwozia);	
	
	@Select("SELECT * FROM Pojazd where id = ( select count(*) from Pojazd)") 
	VehicleDTO getLastAddedVehicle();
	
	@Select("COMMIT")
	void commit();
}