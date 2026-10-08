package org.booklore.service.metadata.sidecar;

import org.booklore.model.dto.BookMetadata;
import org.booklore.model.entity.BookMetadataEntity;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SidecarMetadataMapperTest {
    private final SidecarMetadataMapper mapper = new SidecarMetadataMapper();

    @Test
    void roundTripsDoubanMetadataThroughSidecarBackup() {
        BookMetadataEntity entity = BookMetadataEntity.builder().title("Book")
                .doubanId("12345").doubanRating(8.7).doubanReviewCount(120).build();

        BookMetadata restored = mapper.toBookMetadata(mapper.toSidecarMetadata(entity, null));

        assertThat(restored.getDoubanId()).isEqualTo("12345");
        assertThat(restored.getDoubanRating()).isEqualTo(8.7);
        assertThat(restored.getDoubanReviewCount()).isEqualTo(120);
    }
}
