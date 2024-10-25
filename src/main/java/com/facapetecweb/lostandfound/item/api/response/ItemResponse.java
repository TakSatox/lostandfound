package com.facapetecweb.lostandfound.item.api.response;

import java.util.List;
import java.time.LocalDate;

import com.facapetecweb.lostandfound.item.model.entity.Item;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Response class to be returned from Item controller")
public class ItemResponse {
    
    @Schema(description = "ID")
    private Long id;
    
    @Schema(description = "Title")
    private String title;

    @Schema(description = "Picture Link")
    private String pictureLink;

    @Schema(description = "Current Location")
    private String currentLocation;

    @Schema(description = "Found Location")
    private String foundLocation;

    @Schema(description = "Found Date")
    private LocalDate foundDate;

    @Schema(description = "Who Found")
    private String whoFound;

    @Schema(description = "Is Retrieved")
    private Boolean isRetrieved;

    @Schema(description = "Who Retrieved")
    private String whoRetrieved;

    @Schema(description = "Retrieved Date")
    private LocalDate retrievedDate;

    public static ItemResponse from(Item entity) {
        return ItemResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .pictureLink(entity.getPictureLink())
                .currentLocation(entity.getCurrentLocation())
                .foundLocation(entity.getFoundLocation())
                .foundDate(entity.getFoundDate())
                .whoFound(entity.getWhoFound())
                .isRetrieved(entity.getIsRetrieved())
                .whoRetrieved(entity.getWhoRetrieved())
                .retrievedDate(entity.getRetrievedDate())
            .build();
    }

    public static List<ItemResponse> fromList(List<Item> entities) {
        return entities.stream().map(ItemResponse::from).toList();
    }

}
