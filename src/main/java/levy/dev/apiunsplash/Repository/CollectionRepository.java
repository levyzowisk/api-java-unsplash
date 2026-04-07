package levy.dev.apiunsplash.Repository;

import levy.dev.apiunsplash.Dto.Projection.CollectionStatusProjection;
import levy.dev.apiunsplash.Dto.Projection.CollectionSummaryProjection;
import levy.dev.apiunsplash.Entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CollectionRepository  extends JpaRepository<Collection, UUID> {

    @Query("SELECT c.id as id, c.name as name, COUNT(ci) as totalImages, MAX(i.url) as photo " +
            "FROM Collection c " +
            "LEFT JOIN c.images ci " +
            "LEFT JOIN ci.image i " +
            "GROUP BY c.id, c.name")
    List<CollectionSummaryProjection> findAllWithImageCount();

    @Query("SELECT c.id as id, c.name as name, " +
           "(SELECT COUNT(ci) FROM CollectionImage ci WHERE ci.collection.id = c.id) AS totalImages, " +
           "(CASE WHEN EXISTS(SELECT 1 FROM CollectionImage ci WHERE ci.collection.id = c.id AND ci.image.idImage = :idImage) THEN true ELSE false END) AS containsPhoto " +
           "FROM Collection c")
    List<CollectionStatusProjection> findAllWithPhotoStatus(@Param("idImage") String idImage);
}
