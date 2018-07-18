package nameddto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class NamedDtoService {

    private HashMap<Integer, NamedDto> namedDtoHashMap = new HashMap<>();

    public void addNamedDto(NamedDto namedDto) {
        namedDtoHashMap.put(namedDto.getId(), namedDto);
    }

    public NamedDto findNamedDtoById(int id) {
        return namedDtoHashMap.get(id);
    }

    public String findLongestString(int id) {
        NamedDto namedDto = findNamedDtoById(id);
        List<String> strings = new ArrayList<>();

        if (namedDto.getChildren().isEmpty()) {
            return namedDto.getName();
        } else {
            for (int i = 0; i < namedDto.getChildren().size(); i++) {
                strings.add(namedDto.getName() + findLongestString(namedDto.getChildren().get(i)));
            }
            strings.sort(Comparator.comparingInt(String::length).reversed());
            return strings.get(0);
        }

    }
}
