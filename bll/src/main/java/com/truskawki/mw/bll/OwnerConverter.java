package com.truskawki.mw.bll;


import com.truskawki.mw.lib.OwnerDTO;
import com.truskawki.mw.lib.OwnerUVM;
import com.truskawki.mw.lib.VehicleDTO;
import com.truskawki.mw.lib.VehicleUVM;

public class OwnerConverter {

    public static OwnerDTO fromOwnerUVMToOwnerDTO(OwnerUVM p) {
        return new OwnerDTO.OwnerDTOBuilder()
                .imie(p.getImie())
                .nazwisko(p.getNazwisko())
                .ulica(p.getUlica())
                .nr_domu(p.getNr_domu())
                .kod_pocztowy(p.getKod_pocztowy())
                .miejscowosc(p.getMiejscowosc())
                .pesel(p.getPesel())
                .build();
    }

    public static OwnerUVM fromOwnerDTOToOwnerUVM(OwnerDTO p) {
        return new OwnerUVM.OwnerUVMBuilder()
                .imie(p.getImie())
                .nazwisko(p.getNazwisko())
                .ulica(p.getUlica())
                .nr_domu(p.getNr_domu())
                .kod_pocztowy(p.getKod_pocztowy())
                .miejscowosc(p.getMiejscowosc())
                .pesel(p.getPesel())
                .build();
    }
}
