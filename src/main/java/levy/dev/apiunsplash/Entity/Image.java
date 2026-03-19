package levy.dev.apiunsplash.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "unsplash_id", unique = true, nullable = false)
    private String unsplashId;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String url;

    @Column(name = "photographer_name")
    private String photographerName;

    @OneToMany(mappedBy = "image")
    private Set<CollectionImage> collections;
}