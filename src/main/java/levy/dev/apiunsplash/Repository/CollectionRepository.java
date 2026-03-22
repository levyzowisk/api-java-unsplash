package levy.dev.apiunsplash.Repository;

import levy.dev.apiunsplash.Dto.Projection.CollectionSummaryProjection;
import levy.dev.apiunsplash.Entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CollectionRepository  extends JpaRepository<Collection, UUID> {

    @Query("SELECT c.id as id, c.name as name, COUNT(ci) as totalImages " +
            "FROM Collection c " +
            "LEFT JOIN c.images ci " +
            "GROUP BY c.id, c.name")
    List<CollectionSummaryProjection> findAllWithImageCount();
}
