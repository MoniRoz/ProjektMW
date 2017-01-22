package com.truskawki.mw;

import com.truskawki.mw.lib.Pojazd;
import com.truskawki.mw.lib.Wlasciciel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;

public interface PolicjantMapper extends Mapper {



    @Lang(XMLLanguageDriver.class)
    @Select("<script>" +
            "select marka, rodzaj_pojazdu, model, rok_produkcji, nr_vin, masa, p_silnika, m_silnika, r_paliwa, d_nr_rejestracyjny\n" +
            "from Dokument d, Pojazd p, Marka m, Rodzaj_pojazdu r " +
            "WHERE d.ID_POJAZDU = p.ID_POJAZDU \n" +
            "and m.ID_marki = p.id_marki\n" +
            "and r.ID_RODZAJU_POJAZDU = p.ID_RODZAJU_POJAZDU\n" +
            "and ID_typu = 1 and data_koncowa is null " +
            " <if test=\"param1 != null\">" +
            "    AND nr_VIN = #{vin}" +
            " </if>\n" +
            " <if test=\"param2 != null\">" +
            "    AND d_nr_rejestracyjny = #{rejestracja}" +
            " </if>" +
            "</script>")
    Pojazd getPojazd(@Param("vin") String vin, @Param("rejestracja") String rejestracja);





//    @SelectProvider(type = UserSqlBuilder.class, method = "buildGetUsersByName")
//    Pojazd getUsersByName(@Param("name") String name, @Param("orderByColumn") String orderByColumn);
//
//    class UserSqlBuilder {
//        public String buildGetUsersByName(final String name, final String orderByColumn) {
//            return new SQL(){{
//                SELECT("*");
//                FROM("users");
//                WHERE("name like #{name} || '%'");
//                ORDER_BY(orderByColumn);
//            }}.toString();
//        }
//    }
}

