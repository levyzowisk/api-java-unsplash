package levy.dev.apiunsplash.Dto.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class GetAllCollectionWithContainsPhotoDto extends GetAllCollectionResponseDto {

    private Boolean containsPhoto;
}
