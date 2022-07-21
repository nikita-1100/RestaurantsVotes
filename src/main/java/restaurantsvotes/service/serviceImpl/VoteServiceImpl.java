package restaurantsvotes.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restaurantsvotes.entity.User;
import restaurantsvotes.entity.Vote;
import restaurantsvotes.repository.VoteJpaRepository;
import restaurantsvotes.service.VoteService;

import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {
    @Autowired
    private VoteJpaRepository voteJpaRepository;

    @Transactional
    @Override
    public void saveToBD(Vote vote) {
        voteJpaRepository.save(vote);
    }

    @Override
    public List<Vote> getAll() {
        return voteJpaRepository.findAll();
    }
}
