package es.upm.miw.api.sports.wrappers;

import java.util.ArrayList;
import java.util.List;

public class SportListWrapper {
    private List<String> nickList;

    public SportListWrapper() {
        this.nickList = new ArrayList<>();
    }

    @Override
    public String toString() {
        String result = "{\"userList\":[ ";
        for (String nick : nickList) {
            result += nick + ",";
        }
        return result.substring(0, result.length() - 1) + "]}";
    }

}
