package levy.dev.apiunsplash.Repository;

import jakarta.transaction.Transactional;
import levy.dev.apiunsplash.Dto.Projection.ImageSummaryProjection;
import levy.dev.apiunsplash.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

        @Modifying
        @Transactional
        @Query("DELETE FROM Image i WHERE i.idImage = :image_id " +
                "AND NOT EXISTS (SELECT 1 FROM CollectionImage ci WHERE ci.image.id = i.id)")
        void deleteImage(@Param("image_id") String imageId);
}
