package restaurantsvotes.service;

import restaurantsvotes.entity.Vote;

import java.util.List;

public interface VoteService {
    public void saveToBD(Vote vote);
    public List<Vote> getAll();
}
