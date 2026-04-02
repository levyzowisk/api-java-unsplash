package levy.dev.apiunsplash.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetAllImageCollectionResponseDto {

    private UUID id;
    private String url;
    private String photographerName;
}
