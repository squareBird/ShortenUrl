package com.example.shortenurl.infrastructure;

import com.example.shortenurl.domain.ShortenUrl;
import com.example.shortenurl.domain.ShortenUrlRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
@Profile({"prod","dev"})
public class DatabaseShortenUrlRepository implements ShortenUrlRepository {

    private final EntityManager em;

    public DatabaseShortenUrlRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(ShortenUrl shortenUrl) {
        em.persist(shortenUrl);
    }

    @Override
    public Optional<ShortenUrl> findByShortenUrl(String kwd) {
        em.createQuery("update ShortenUrl s set s.views = s.views+1 where s.shortenUrl = :kwd")
                .setParameter("kwd", kwd);
        ShortenUrl shortenUrl = em.find(ShortenUrl.class, kwd);
        return Optional.ofNullable(shortenUrl);
    }

    @Override
    public List<ShortenUrl> showAll() {
        List<ShortenUrl> result = em.createQuery("select s from ShortenUrl s", ShortenUrl.class).
                getResultList();
        return result;
    }
}
