package levy.dev.apiunsplash.Controller;

import levy.dev.apiunsplash.Dto.Request.AddImageToCollectionDto;
import levy.dev.apiunsplash.Dto.Request.CollectionRequestDto;
import levy.dev.apiunsplash.Dto.Request.UpdateCollectionRequestDto;
import levy.dev.apiunsplash.Dto.Response.CollectionResponseDto;
import levy.dev.apiunsplash.Dto.Response.GetAllCollectionResponseDto;
import levy.dev.apiunsplash.Entity.Collection;
import levy.dev.apiunsplash.Service.CollectionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/collections")
public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping
    public ResponseEntity<List<GetAllCollectionResponseDto>> getAll() {
        var collections = collectionService.getAll();
        return ResponseEntity.ok(collections);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CollectionRequestDto collection) {
        collectionService.create(collection);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete (@PathVariable("id") UUID id) {
        collectionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CollectionResponseDto> update (@PathVariable("id") UUID id, @RequestBody UpdateCollectionRequestDto collection) {
        CollectionResponseDto collectionRes = collectionService.update(id, collection);
        return ResponseEntity.ok(collectionRes);
    }


//    @DeleteMapping("/{collectionId}/images/{imageId}")
//    public ResponseEntity<Void> deletePhotoFromCollection (@PathVariable("collectionId") UUID collectionId, @PathVariable("imageId") String imageId) {
//        collectionService.deleteCollectionImage(collectionId, imageId);
//        return ResponseEntity.noContent().build();
//    }

    @PostMapping("/{collectionId}/images")
    public ResponseEntity<Void> addImageToCollection(@PathVariable("collectionId") UUID collectionID, @RequestBody AddImageToCollectionDto image) {
        collectionService.addImageToCollection(collectionID, image);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
