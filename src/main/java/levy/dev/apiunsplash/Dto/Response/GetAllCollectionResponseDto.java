package levy.dev.apiunsplash.Dto.Response;

import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetAllCollectionResponseDto extends CollectionResponseDto{
    private Long totalImages;
}
