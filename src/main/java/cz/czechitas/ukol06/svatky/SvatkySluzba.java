package cz.czechitas.ukol06.svatky;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.MonthDay;
import java.util.List;
import java.util.stream.Collectors;

public class SvatkySluzba {

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();
    private final Path cestaKDatum = Path.of("data/svatky.json");
    private final SeznamSvatku seznamSvatku;

    public SvatkySluzba() throws IOException {
        // TODO načíst seznam svátků ze souboru svatky.json
        String json = Files.readString(cestaKDatum);
        seznamSvatku = objectMapper.readValue(json, SeznamSvatku.class);

    }

    public List<String> vyhledatSvatkyDnes() {
        return vyhledatSvatkyKeDni(MonthDay.now());
    }

    public List<String> vyhledatSvatkyKeDni(MonthDay day) {
        return seznamSvatku.getSvatky().stream()
                .filter(s -> s.getDen().equals(day))
                .map(Svatek::getJmeno)
                .collect(Collectors.toList());
    }
}