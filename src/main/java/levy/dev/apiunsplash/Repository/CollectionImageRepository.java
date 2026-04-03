package levy.dev.apiunsplash.Repository;

import jakarta.transaction.Transactional;
import levy.dev.apiunsplash.Entity.CollectionImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CollectionImageRepository extends JpaRepository<CollectionImage, UUID> {

    @Transactional()
    @Modifying
    @Query("DELETE FROM CollectionImage ci WHERE ci.collection.id = :collectionID AND ci.image.idImage = :idImage")
    void deleteByCollectionIdAndImageIdImage(@Param("collectionID") UUID collectionID, @Param("idImage") String idImage);

    @Query("SELECT ci FROM CollectionImage ci WHERE ci.collection.id = :collectionID AND ci.image.idImage = :idImage")
    List<CollectionImage> findByCollectionIdAndImageIdImage(@Param("collectionID") UUID collectionID, @Param("idImage") String idImage);

}
