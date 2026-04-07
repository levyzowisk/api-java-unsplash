package levy.dev.apiunsplash.Repository;

import levy.dev.apiunsplash.Dto.Projection.ImageSummaryProjection;
import levy.dev.apiunsplash.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ImageRepository extends JpaRepository<Image, UUID> {

        @Query("SELECT i.id as id, i.url as url, i.photographerName as photographerName " +
                "FROM Image i " +
                "JOIN i.collections ci " +
                "WHERE ci.collection.id = :collectionId")
        List<ImageSummaryProjection> findImagesByCollectionId(@Param("collectionId") UUID collectionId);
}
