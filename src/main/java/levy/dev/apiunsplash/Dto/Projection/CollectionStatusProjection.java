package levy.dev.apiunsplash.Dto.Projection;

import java.util.UUID;

public interface CollectionStatusProjection {
    UUID getId();
    String getName();
    Long getTotalImages();
    Boolean getContainsPhoto();
}
