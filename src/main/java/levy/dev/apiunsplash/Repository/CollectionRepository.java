package levy.dev.apiunsplash.Repository;

import levy.dev.apiunsplash.Entity.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CollectionRepository  extends JpaRepository<Collection, UUID> {
}
