package levy.dev.apiunsplash.Repository;

import levy.dev.apiunsplash.Entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ImageRepository extends JpaRepository<Image, UUID> {
}
