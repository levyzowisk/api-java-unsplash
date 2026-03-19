package levy.dev.apiunsplash.Controller;

import levy.dev.apiunsplash.Entity.Collection;
import levy.dev.apiunsplash.Service.CollectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/collections")
public class CollectionController {

    private final CollectionService collectionService;

    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }

    @GetMapping
    public ResponseEntity<List<Collection>> getAll() {
        var collections = collectionService.getAll();
        return ResponseEntity.ok(collections);
    }
}
