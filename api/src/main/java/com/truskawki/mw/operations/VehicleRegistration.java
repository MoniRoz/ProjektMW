package com.truskawki.mw.operations;

import com.truskawki.mw.VehicleMapper;
import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.TruskawkiSimpleResponse;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.log4j.Logger;

public class VehicleRegistration extends DatabaseComplexResponseOperation {

    private final Logger logger = Logger.getLogger(VehicleRegistration.class);
    private Pojazd pojazd;
    private Wlasciciel wlasciciel;


    public VehicleRegistration(Pojazd pojazd, Wlasciciel wlasciciel) {
        super(VehicleMapper.class);
        this.pojazd = pojazd;
        this.wlasciciel = wlasciciel;
    }

    @Override
    protected TruskawkiSimpleResponse mainAction() {
//        MalinkiComplexResponse malinkiComplexResponse = new MalinkiComplexResponse();
//        TicketResponseDTO ticketResponseDTO = new TicketResponseDTO();
//
//        try{
//            ((TicketMapper)mapper).addTicket(ticket);
//            ticketResponseDTO = ((TicketMapper) mapper).getTicketByID(ticket.getId());
//
//            databaseOperationResultEnum = DatabaseOperationResultEnum.TICKET_BOUGHT_SUCCESSFULLY;
//        } catch (Exception e){
//            logger.log(Level.ERROR, e.toString());
//            databaseOperationResultEnum = DatabaseOperationResultEnum.TICKET_NOT_BOUGHT_SUCCESSFULLY_DUE_TO_ERROR;
//        }
//
//        malinkiComplexResponse.setDtoResult(ticketResponseDTO);

        return new TruskawkiSimpleResponse();
    }
}
