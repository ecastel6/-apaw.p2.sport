package es.upm.miw.api.sports.controllers;

import java.util.List;

import es.upm.miw.api.sports.daos.DaoFactory;
import es.upm.miw.api.sports.entities.Theme;
import es.upm.miw.api.sports.entities.Vote;
import es.upm.miw.api.sports.wrappers.VoteListWrapper;
import es.upm.miw.api.sports.wrappers.VoteWrapper;

public class VoteController {

	public boolean createVote(int themeId, int vote) {
		Theme theme = DaoFactory.getFactory().getThemeDao().read(themeId);
		if (theme != null) {
			DaoFactory.getFactory().getVoteDao().create(new Vote(vote, theme));
			return true;
		} else {
			return false;
		}
	}

	public VoteListWrapper voteList() {
		List<Vote> votes = DaoFactory.getFactory().getVoteDao().findAll();
		VoteListWrapper voteListWrapper = new VoteListWrapper();
		for (Vote vote : votes) {
			voteListWrapper.addVoteWrapper(new VoteWrapper(vote.getTheme().getName(),vote.getValue()));
		}
		return voteListWrapper;
	}

}
