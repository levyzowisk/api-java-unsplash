package levy.dev.apiunsplash.Repository;

import jakarta.transaction.Transactional;
import levy.dev.apiunsplash.Entity.CollectionImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CollectionImageRepository extends JpaRepository<CollectionImage, UUID> {

    @Transactional()
    void deleteByCollectionIdAndImageId(UUID collectionID, String imageId);

    Optional<CollectionImage> findByCollectionIdAndImageId(UUID collectionID, String imageId);

}
