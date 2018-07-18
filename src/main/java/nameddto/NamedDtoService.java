package nameddto;

import java.util.HashMap;

public class NamedDtoService {

    private HashMap<Integer, NamedDto> namedDtoHashMap = new HashMap<>();

    public void addNamedDto(NamedDto namedDto) {
        namedDtoHashMap.put(namedDto.getId(), namedDto);
    }

    public NamedDto findNamedDtoById(int id) {
        return namedDtoHashMap.get(id);
    }

    public String findLongestString(NamedDto one) {
       return findStringForObject(one);
    }

    private String findStringForObject(NamedDto one) {
        if (one.getChildren().isEmpty()) {
            return "";
        } else {
            return one.getName() + findStringForObject(findNamedDtoById(one.getChildren().get(0)));
        }
    }

}
