package es.upm.miw.api.sports.daos;

import java.util.List;

import es.upm.miw.api.sports.entities.Vote;

public interface VoteDao extends GenericDao<Vote, Integer> {
	List<Integer> findValueByThemeId(int themeId);
}
