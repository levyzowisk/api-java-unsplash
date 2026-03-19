package levy.dev.apiunsplash.Service;

import levy.dev.apiunsplash.Entity.Collection;
import levy.dev.apiunsplash.Repository.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> getAll() {
       return collectionRepository.findAll();
    }
}
