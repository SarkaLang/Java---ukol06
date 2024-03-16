package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.time.MonthDay;
import java.util.List;
import java.io.IOException;

class SvatkySluzbaTest {

    @Test
    void vyhledatSvatkyKeDni() throws IOException{

        SvatkySluzba svatkySluzba = new SvatkySluzba();

        List<String> svatky1 = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.of(1, 2));
        assertEquals(List.of("Karina", "Vasil"), svatky1);

        List<String> svatky2 = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.of(12, 24));
        assertEquals(List.of("Adam", "Eva", "Gaia", "Kračun"), svatky2);

        List<String> svatky3 = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.of(1, 1));
        assertEquals(List.of(), svatky3);
    }
}
