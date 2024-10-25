package com.facapetecweb.lostandfound.item.api.request;

import java.util.List;

import com.facapetecweb.lostandfound.item.model.entity.Item;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(description = "Item request to create or update an Item entity")
public class ItemRequest {
    
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

    public static Item toEntity(ItemRequest req) {
        return Item.builder()
                .title(req.getTitle())
                .pictureLink(req.getPictureLink())
                .currentLocation(req.getCurrentLocation())
                .foundLocation(req.getFoundLocation())
                .foundDate(req.getFoundDate())
                .whoFound(req.getWhoFound())
                .isRetrieved(req.getIsRetrieved())
                .whoRetrieved(req.getWhoRetrieved())
                .retrievedDate(req.getRetrievedDate())
            .build();
    }

    public static List<Item> toEntities(List<ItemRequest> reqs) {
        return reqs.stream().map(ItemRequest::toEntity).toList();
    }

}
