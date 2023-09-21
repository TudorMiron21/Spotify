package tudor.practice.spotify.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tudor.practice.spotify.model.ArtistModel;


@Repository
public interface ArtistRepository extends ListCrudRepository<ArtistModel,Long> {
    

    @Query("select a from artist a where a.email = ?1")
    Optional<ArtistModel> findByEmail(String email);
}
