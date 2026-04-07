package levy.dev.apiunsplash.Dto.Projection;

import java.util.UUID;

public interface CollectionSummaryProjection {
    UUID getId();
    String getName();
    Long getTotalImages();
    String getPhoto();
}
