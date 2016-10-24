package es.upm.miw.api.sports.daos.memory;

import es.upm.miw.api.sports.daos.DaoFactory;
import es.upm.miw.api.sports.daos.ThemeDao;
import es.upm.miw.api.sports.daos.VoteDao;

public class DaoFactoryMemory extends DaoFactory {

	private ThemeDao themeDao;
	private VoteDao voteDao;

	public DaoFactoryMemory() {
	}

	@Override
	public ThemeDao getThemeDao() {
		if (themeDao == null) {
			themeDao = new ThemeDaoMemory();
		}
		return themeDao;
	}

	@Override
	public VoteDao getVoteDao() {
		if (voteDao == null) {
			voteDao = new VoteDaoMemory();
		}
		return voteDao;
	}

}
