package es.upm.miw.api.sports.api;

import es.upm.miw.api.sports.controllers.VoteController;
import es.upm.miw.api.sports.exceptions.InvalidVoteException;
import es.upm.miw.api.sports.exceptions.NotFoundThemeIdException;
import es.upm.miw.api.sports.wrappers.VoteListWrapper;

public class VoteResource {

	// POST **/votes   body="themeId:vote"
	public void createVote(int themeId, int vote) throws InvalidVoteException, NotFoundThemeIdException {
		if (vote < 0 || vote > 10) {
			throw new InvalidVoteException("" + vote);
		}
		if (!new VoteController().createVote(themeId, vote)) {
			throw new NotFoundThemeIdException("" + themeId);
		}
	}

	// GET **/votes
	public VoteListWrapper voteList() {
		return new VoteController().voteList();
	}

}
