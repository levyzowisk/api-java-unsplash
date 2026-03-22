package levy.dev.apiunsplash.Service;

import levy.dev.apiunsplash.Dto.Projection.CollectionSummaryProjection;
import levy.dev.apiunsplash.Dto.Request.CollectionRequestDto;
import levy.dev.apiunsplash.Dto.Request.UpdateCollectionRequestDto;
import levy.dev.apiunsplash.Dto.Response.CollectionResponseDto;
import levy.dev.apiunsplash.Dto.Response.GetAllCollectionResponseDto;
import levy.dev.apiunsplash.Entity.Collection;
import levy.dev.apiunsplash.Repository.CollectionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CollectionService {

    private final CollectionRepository collectionRepository;

    public CollectionService(CollectionRepository collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    public List<GetAllCollectionResponseDto> getAll() {
        List<CollectionSummaryProjection >collectionSummary = collectionRepository.findAllWithImageCount();
        return collectionSummary.stream().map(collection -> {
            GetAllCollectionResponseDto responseDto = new GetAllCollectionResponseDto();

            responseDto.setId(collection.getId());
            responseDto.setName(collection.getName());
            responseDto.setTotalImages(collection.getTotalImages());

            return responseDto;
        }).collect(Collectors.toList());
    }

    public void create(CollectionRequestDto collection) {
        Collection data = new Collection();

        data.setName(collection.getName());

        collectionRepository.save(data);
    }

    public void delete (UUID id) {
        collectionRepository.deleteById(id);
    }

    public Collection getCollectionById(UUID id) {
        return collectionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Collection not found"));
    }

    public CollectionResponseDto update(UUID id, UpdateCollectionRequestDto collection)  {

        Collection data = this.getCollectionById(id);

        data.setName(collection.getName());
        collectionRepository.save(data);

        return new CollectionResponseDto(
                data.getId(),
                data.getName()
        );
    }

}