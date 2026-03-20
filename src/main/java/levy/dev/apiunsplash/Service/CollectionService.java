package levy.dev.apiunsplash.Service;

import levy.dev.apiunsplash.Dto.Request.CollectionRequestDto;
import levy.dev.apiunsplash.Entity.Collection;
import levy.dev.apiunsplash.Repository.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<Collection> getAll() {
        return collectionRepository.findAll();
    }

    public void create(CollectionRequestDto collection) {
        Collection data = new Collection();

        data.setName(collection.getName());

        collectionRepository.save(data);
    }

    public void delete (UUID id) {
        collectionRepository.deleteById(id);
    }

}