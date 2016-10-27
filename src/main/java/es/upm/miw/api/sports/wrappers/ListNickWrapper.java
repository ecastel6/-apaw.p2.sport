package es.upm.miw.api.sports.wrappers;

import java.util.ArrayList;
import java.util.List;

public class ListNickWrapper {
    private List<String> nickList;

    public ListNickWrapper() {
        nickList = new ArrayList<>();
    }

    public void addNick(String nick) {
        nickList.add(nick);
    }

    @Override
    public String toString() {
        String result = "{\"userList\":[";
        for (String nick : nickList) {
            result += nick + ",";
        }
        return result.substring(0, result.length() - 1) + "]}";
    }
}
