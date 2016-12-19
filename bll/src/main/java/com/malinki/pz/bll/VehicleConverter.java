package com.malinki.pz.bll;

import com.malinki.pz.dal.domain.VehicleDTO;

public class VehicleConverter {

	public static VehicleDTO fromVehicleUVMToVehicleDTO(VehicleUVM p) {
		return new VehicleDTO.PojazdDTOBuilder()
				.rodzaj_pojazdu(p.getRodzaj_pojazdu())
				.marka(p.getMarka())
				.typ(p.getTyp())
				.model(p.getModel())
				.rok_produkcji(p.getRok_produkcji())
				.nr_VIN(p.getNr_VIN())
				.nr_silnika(p.getNr_silnika())
				.d_nr_rejestracyjny(p.getD_nr_rejestracyjny())
				.nr_kart_pojazdu(p.getNr_kart_pojazdu())
				.przebieg_p_w_km(p.getPrzebieg_p_w_km())
				.barwa_nadwozia(p.getBarwa_nadwozia())
				.build();
	}
	

	
	public static VehicleUVM fromVehicleDTOToUVM(VehicleDTO p) {
		return new VehicleUVM.PojazdUVMBuilder()
				.rodzaj_pojazdu(p.getRodzaj_pojazdu())
				.marka(p.getMarka())
				.typ(p.getTyp())
				.model(p.getModel())
				.rok_produkcji(p.getRok_produkcji())
				.nr_VIN(p.getNr_VIN())
				.nr_silnika(p.getNr_silnika())
				.d_nr_rejestracyjny(p.getD_nr_rejestracyjny())
				.nr_kart_pojazdu(p.getNr_kart_pojazdu())
				.przebieg_p_w_km(p.getPrzebieg_p_w_km())
				.barwa_nadwozia(p.getBarwa_nadwozia())
				.build();
	}
}
