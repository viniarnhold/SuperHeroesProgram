package domain;

import java.util.List;

public interface HeroesRepository {

    public List<Heroes> findAll();
    public void saveAll(Heroes herois);
    
}